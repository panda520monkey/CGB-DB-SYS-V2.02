package com.test.service;
import org.junit.Test;

import com.db.common.vo.PageObject;
import com.db.sys.entity.SysLog;
import com.db.sys.service.SysLogService;
import com.test.TestBase;
public class TestSysLogService extends TestBase{
	@Test
	public void testFindPageObjects(){
		SysLogService service=
		ctx.getBean("sysLogServiceImpl",
				    SysLogService.class);
		PageObject<SysLog> po=
		service.findPageObjects("admin",1);
		System.out.println(po);
		System.out.println(po.getRecords().size());
		System.out.println(po.getRowCount());
		System.out.println(po.getPageCount());
	}
}
