package com.platform.ptcms.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.platform.framework.utils.StringUtil;
import com.platform.ptcms.dao.DemoDao;
import com.platform.ptcms.entity.WeUserRef;
import com.platform.ptcms.service.iface.IDemoService;

@Service
@Transactional//事物控制
public class DemoService  implements IDemoService{

	@Autowired
	private DemoDao demoDao;
	
	@Override
	public WeUserRef find(String id) {
		WeUserRef u = demoDao.findOne(id);
		return u;
	}
	
	
	
	public void save() {
		WeUserRef u1 = new WeUserRef();
		u1.setId(StringUtil.getUUID());
		u1.setWeId(StringUtil.getUUID());
		u1.setUserId(StringUtil.getUUID());
		u1.setSign("2");
		
		demoDao.save(u1);
		u1.setId(StringUtil.getUUID());
		u1.setWeId(StringUtil.getUUID());
		u1.setUserId(StringUtil.getUUID());
		u1.setSign("3");
		
		demoDao.save(u1);
		u1.setId(StringUtil.getUUID());
		u1.setWeId(StringUtil.getUUID());
		u1.setUserId(StringUtil.getUUID());
		u1.setSign(StringUtil.getUUID());
		
		demoDao.save(u1);
	}
}
