package com.testcomp.user.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.testcomp.dao.UserService;
import com.testcomp.entity.User;
import com.testcomp.testweb.ResponseBean;
import com.testcomp.user.bean.UserParamBean;

@RestController  
public class UserController {  
  
	@Autowired  
    private UserService userService;
	
    @RequestMapping(value = "/user", method = RequestMethod.POST)  
    public ResponseBean c_user(@RequestBody @Valid UserParamBean userParamBean) {
    	try {
			User user = new User();
			user.setName(userParamBean.getName());
			user.setAccount(userParamBean.getAccount());
			boolean addRes = userService.add(user);
			if(addRes)
			{
				return new ResponseBean().success("存库成功");
			}
			else
			{
				return new ResponseBean().failure("存库失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseBean().failure("内部异常");
		}
    }  
  
    @RequestMapping(value = "/searchUser", method = RequestMethod.POST)  
    public ResponseBean r_user(@RequestBody UserParamBean userParamBean) {
    	try {
			List<User> userList = userService.findAll();
			return new ResponseBean().success(userList);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseBean().failure("内部异常");
		}
    }  
}  