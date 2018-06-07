package com.testcomp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testcomp.entity.User;

@Service
@Transactional
public class UserService {
	
    @Autowired
    private UserDao userDao;
    
    
    
    public boolean add(User user){
        userDao.save(user);
        return true;
    }
    
    public String addUser(String account){
        User user = new User();
        user.setAccount(account);
        userDao.save(user);
        return "添加成功！";
    }
    
    public User getOneUser(Long id){
        return userDao.findOne(id);
    }
    
    public List<User> findAll(){
    	return userDao.findAll();
    }
    
}