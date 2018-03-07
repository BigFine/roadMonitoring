package com.platform.ptcms.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platform.ptcms.entity.WeUserRef;
import com.platform.ptcms.service.iface.IDemoService;

@RestController
@RequestMapping
public class DemoController {

	@Autowired
	private IDemoService demoService;
	
	
	@RequestMapping("/hello")  
	String index() {  
		return "Hello SPRINGBOOT";  
	}
	
	@RequestMapping(path = "/find")
    public String getAdminInfo()
    {
		WeUserRef account = demoService.find("1");
        System.out.println(account);
        return account.toString();
    }
	@RequestMapping(path = "/save")
	public String save()
	{
		demoService.save();
		return "success";
	}
}
