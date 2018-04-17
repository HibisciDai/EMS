package com.baizhi.service.impl;

import java.util.List;
import com.baizhi.dao.UserDAO;
import com.baizhi.dao.impl.UserDAOImpl;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;

public class UserServiceImpl implements UserService {
	public UserDAO ud = new UserDAOImpl();

	public User login(User u) {
		User getu = null;
		try {
			getu = ud.findByAccount(u.getAccount()); // 根据账户扫描用户
			if (u.getPassword().equals(getu.getPassword())) { // 密码匹配
				return getu;
			} else {
				return null;
			}
		} catch (NullPointerException e) {
			System.out.println("用户名不存在");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return getu;
	}

	public void regist(User u) {
		ud.insert(u);
	}

	public void update(User u) {
		ud.update(u, u.getId());
	}

	public void delete(User u) {
		ud.delete(u.getId());
	}

	public List<User> showAllUsers() {
		return ud.queryAll();
	}

}
