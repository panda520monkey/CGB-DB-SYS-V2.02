package com.test.dao;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.db.sys.dao.SysMenuDao;
import com.test.TestBase;

public class TestSysMenuDao extends TestBase {
	 @Test
	 public void testFindObjects(){
		 SysMenuDao dao=
		 ctx.getBean("sysMenuDao",SysMenuDao.class);
		 System.out.println(dao.getClass().getName());
		 List<Map<String,Object>> list=dao.findObjects();
		 System.out.println(list.size());
		 for(Map<String,Object> map:list){
			 System.out.println(map);
		 }
	 }
}
