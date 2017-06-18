package com.baizhi.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.baizhi.dao.UserDAO;
import com.baizhi.entity.Emp;
import com.baizhi.entity.User;
import com.baizhi.util.JDBCUtil;

public class UserDAOImpl implements UserDAO {

	//插入用户
	public void insert(User u) {
		Connection conn = null;
		PreparedStatement pst = null;
		int rs = 0;
		try {
			conn = JDBCUtil.getConnection();
			String sql ="insert into user(account,password) values (?,?)";
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, u.getAccount());
			pst.setString(2, u.getPassword());
			
			rs = pst.executeUpdate();
			System.out.println("插入User" + u);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}finally{
			JDBCUtil.close(conn, pst);
		}	
	}

	//更新用户
	public void update(User u, int id) {
		Connection conn = null;
		PreparedStatement pst = null;
		int rs = 0;
		try {
			conn = JDBCUtil.getConnection();
			String sql ="update user set account=?,password=? where id=?";
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, u.getAccount());
			pst.setString(2, u.getPassword());
			pst.setInt(3, id);
			
			rs = pst.executeUpdate();
			System.out.println("更新用户User" + u);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}finally{
			JDBCUtil.close(conn, pst);
		}		
	}

	//根据id删除用户
	public void delete(int id) {
		Connection conn = null;
		PreparedStatement pst = null;
		boolean rs = true;
		try {
			conn = JDBCUtil.getConnection();
			String sql ="delete from user where id = ?";
			pst = conn.prepareStatement(sql);
			
			pst.setInt(1, id);
			
			rs = pst.execute();
			System.out.println("删除User， id=" + id);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(conn, pst);
		}
	}

	//通过id查找用户
	public User findById(int id) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		User u = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql ="select * from user where id = ?";
			pst = conn.prepareStatement(sql);
			
			pst.setInt(1, id);
			
			rs = pst.executeQuery();
			
			while(rs.next()){
				u = new User();
				u.setId(rs.getInt(1));
				u.setAccount(rs.getString(2));
				u.setPassword(rs.getString(3));
				break;
			}	
		} catch (SQLException e1) {
			e1.printStackTrace();
		}finally{
			JDBCUtil.close(conn, pst, rs);
		}
		return u;
	}

	//查询全部用户
	public List<User> queryAll() {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List userList = new ArrayList<Emp>();
		try {
			conn = JDBCUtil.getConnection();
			String sql ="select * from user";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				User u = new User();
				u.setId(rs.getInt(1));
				u.setAccount(rs.getString(2));
				u.setPassword(rs.getString(3));
				
				userList.add(u);
             }
			return userList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			JDBCUtil.close(conn, pst, rs);
		}
	}

	//查询用户
	public User findByAccount(String account) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		User u = new User();

		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from user where account = ?";
			pst = conn.prepareStatement(sql);

			pst.setString(1, account);

			rs = pst.executeQuery();

			while(rs.next()) {
				u.setId(rs.getInt(1));
				u.setAccount(rs.getString(2));
				u.setPassword(rs.getString(3));
				break;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pst, rs);
		}
		return u;
	}

}
