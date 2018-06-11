package com.testcomp.dubbo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testcomp.test.DemoService;

@Service
public class UserDubboService {
	
	@Autowired
	private DemoService demoService;
	
	public String findAllUser()
	{
		return demoService.findAllUser();
	}
}
