package com.test.dao;
import java.util.List;
import org.junit.Test;
import com.db.sys.dao.SysLogDao;
import com.db.sys.entity.SysLog;
import com.test.TestBase;
public class TestSysLogDao extends TestBase{
      @Test
	  public void testGetRowCount(){
    	  SysLogDao dao=
		  ctx.getBean("sysLogDao",SysLogDao.class);
    	  int rowCount=
    	  dao.getRowCount("admin");
    	  System.out.println("rowCount="+rowCount);
	  }
      @Test
      public void testFindPageObjects(){
    	  SysLogDao dao=
    	  ctx.getBean("sysLogDao",SysLogDao.class);
    	  List<SysLog> list=
    	  dao.findPageObjects("admin",0, 3);
    	  System.out.println(list.size());
      }
}


