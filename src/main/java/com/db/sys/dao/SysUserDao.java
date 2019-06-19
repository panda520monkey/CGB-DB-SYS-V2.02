package com.db.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.db.sys.entity.SysUser;
import com.db.sys.vo.SysUserDeptResult;
public interface SysUserDao {
	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return
	 */
	SysUser findUserByUsername(String username);

	/**
	 * 更新用户自身信息
	 * @param entity
	 * @return
	 */
	int updateObject(SysUser entity);
	/**
	 * 基于用户id查询用户以及用户对应的部门信息
	 * @param id
	 * @return
	 */
	SysUserDeptResult findObjectById(Integer id);
	
	/**
	 * 保存用户自身信息
	 * @param entity
	 * @return
	 */
	int insertObject(SysUser entity);
	/**
	 * 负责禁用和启用用户
	 * @param id 用户id
	 * @param valid 状态值(1,0)
	 * @param modifiedUser
	 * @return
	 */
	int validById(
			@Param("id")Integer id,
			@Param("valid")Integer valid,
			@Param("modifiedUser")String modifiedUser);
	
	 int getRowCount(@Param("username")String username);
	 List<SysUserDeptResult> findPageObjects(
			 @Param("username")String username,
			 @Param("startIndex")Integer startIndex,
			 @Param("pageSize")Integer pageSize);
}






