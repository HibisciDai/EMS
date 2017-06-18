package com.baizhi.dao;

import java.util.List;
import com.baizhi.entity.User;

public interface UserDAO {
	
	public abstract void insert(User u);

	public abstract void update(User u, int id);
	
	public abstract void delete(int id);

	public abstract User findByAccount(String account);
	
	public abstract User findById(int id);

	public abstract List<User> queryAll();
}
