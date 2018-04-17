package com.baizhi.test;

import java.util.Date;
import java.util.List;

import com.baizhi.dao.EmpDAO;
import com.baizhi.dao.UserDAO;
import com.baizhi.dao.impl.EmpDAOImpl;
import com.baizhi.dao.impl.UserDAOImpl;
import com.baizhi.entity.Emp;
import com.baizhi.entity.User;
import com.baizhi.service.EmpService;
import com.baizhi.service.UserService;
import com.baizhi.service.impl.EmpServiceImpl;
import com.baizhi.service.impl.UserServiceImpl;

public class Main {

	public static void main(String[] args) {
		// Test EmpDAOImpl//////////////////

		EmpDAO ed = new EmpDAOImpl();
		Emp e = new Emp("test1", 10000, new java.sql.Date(new Date().getTime()));

		// insert
		// ed.insert(e);

		// update
		// e.setName("test111");
		// ed.update(e, 6);

		// delete
		// ed.delete(6);

		// findbyid
		// System.out.println(ed.findById(5));

		// query list
		// System.out.println(ed.queryAll());

		// initialize(int pageIndex, int pageSize);
		// System.out.println(ed.initialize(2));

		// count
		// System.out.println(ed.count());

		// Test UserDAOImpl//////////////////

		UserDAO ud = new UserDAOImpl();
		User u = new User("test1", "test1");

		// insert
		// ud.insert(u);

		// update
		// u.setAccount("test111");
		// ud.update(u, 6);

		// delete
		// ud.delete(6);

		// findById
		// System.out.println(ud.findById(1));

		// findByAccount
		// System.out.println(ud.findByAccount("admin1"));

		// query List
		// System.out.println(ud.queryAll());

		// Test UserService///////////////////////
		UserService us = new UserServiceImpl();

		// System.out.println(us.login(new User("admin1","test"))); //测试登录

		// us.regist(new User("test","test1")); //测试注册

		// us.update(new User(1,"admin1","test")); //测试更新操作

		// us.delete(new User(2)); //测试删除

		// System.out.println(us.showAllUsers()); //测试查询全部用户

		// //////////////////////////////////
		// 测试EMP///////////////////////////////
		EmpService es = new EmpServiceImpl();
		Emp em = new Emp("test", 2000, new java.sql.Date(new Date().getTime()));

		// es.save(em); //测试插入

		// 测试更新
		// em.setId(1);
		// es.update(em);

		// es.delete(1); //测试删除

		// System.out.println(es.get(2)); //测试获取

		// System.out.println(es.query()); //测试获取全部

	}

}
