package com.testcomp.dubbo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testcomp.entity.User;
import com.testcomp.test.DemoService;

@Service
public class UserDubboService {
	
	@Autowired
	private DemoService demoService;
	
	public List<User> findAllUser()
	{
		return demoService.findAllUser();
	}
}
