package com.platform.ptcms.service.iface;

import com.platform.ptcms.entity.WeUserRef;

public interface IDemoService {

	public WeUserRef find(String id);
	
	public void save() ;
	
}
