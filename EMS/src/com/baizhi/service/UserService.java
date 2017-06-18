package com.baizhi.service;

import java.util.List;
import com.baizhi.entity.User;

public interface UserService {
	
	public User login(User u);	//根据传入User进行登录验证
	
	public void regist(User u);	//用户注册
	
	public void update(User u);	//修改用户信息
	
	public void delete(User u);	//删除用户信息
	
	public List<User> showAllUsers();	//显示所有用户
}
