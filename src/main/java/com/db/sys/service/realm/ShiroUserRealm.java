package com.db.sys.service.realm;

import com.db.sys.dao.SysUserDao;
import com.db.sys.entity.SysUser;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户权限验证
 */
@Service
public class ShiroUserRealm extends AuthorizingRealm {

    @Autowired
    private SysUserDao userDao;
    /**
    * 功能描述:
    *   通过此方法指定凭证匹配器(加密算法)
    * @parm: [credentialsMatcher]
    * @auther: panda
    * @date: 2019/6/19 17:35
    */

    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        //构建凭证对象
        HashedCredentialsMatcher cMatcher = new HashedCredentialsMatcher();
        //设置加密算法
        cMatcher.setHashAlgorithmName("MD5");
        //设置加密次数
        cMatcher.setHashIterations(1);
        super.setCredentialsMatcher(cMatcher);
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
       UsernamePasswordToken uToken  = (UsernamePasswordToken) authenticationToken;
        String username = uToken.getUsername();
        SysUser user = userDao.findUserByUsername(username);
        if (user==null){
            throw new UnknownAccountException();
        }
        if (user.getValid()==0){
            throw new LockedAccountException();
        }
        ByteSource credentialsSalt = ByteSource.Util.bytes(user.getSalt());
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
                user,//principal代表身份信息
                user.getPassword(),//hashedCredentials
                credentialsSalt, //credentialsSalt
                getName()//realmName
        );
        return info;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
    /**
    * 功能描述:
    *   基于此方法完成认证信息的获取和封装
    */


}
