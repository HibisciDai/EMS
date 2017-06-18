package com.baizhi.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.baizhi.dao.EmpDAO;
import com.baizhi.entity.Emp;
import com.baizhi.util.JDBCUtil;

public class EmpDAOImpl implements EmpDAO {

	//通讯录插入一条数据
	public void insert(Emp e) {
		Connection conn = null;
		PreparedStatement pst = null;
		int rs = 0;
		try {
			conn = JDBCUtil.getConnection();
			String sql ="insert into emp(name,salary,birthday) values (?,?,?)";
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, e.getName());
			pst.setInt(2, e.getSalary());
			pst.setDate(3, e.getBirthday());
			
			rs = pst.executeUpdate();
			System.out.println("插入Emp" + e);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}finally{
			JDBCUtil.close(conn, pst);
		}
	}

	//更新通讯录
	public void update(Emp e, int id) {
		Connection conn = null;
		PreparedStatement pst = null;
		int rs = 0;
		try {
			conn = JDBCUtil.getConnection();
			String sql ="update emp set name=?,salary=?,birthday=? where id=?";
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, e.getName());
			pst.setInt(2, e.getSalary());
			pst.setDate(3, e.getBirthday());
			pst.setInt(4, id);
			
			rs = pst.executeUpdate();
			System.out.println("更新Emp" + e);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}finally{
			JDBCUtil.close(conn, pst);
		}
	}

	//根据id删除emp
	public void delete(int id) {
		Connection conn = null;
		PreparedStatement pst = null;
		boolean rs = true;
		try {
			conn = JDBCUtil.getConnection();
			String sql ="delete from emp where id = ?";
			pst = conn.prepareStatement(sql);
			
			pst.setInt(1, id);
			
			rs = pst.execute();
			System.out.println("删除Emp， id=" + id);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(conn, pst);
		}
	}

	//通过id查找emp
	public Emp findById(int id) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Emp e = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql ="select * from emp where id = ?";
			pst = conn.prepareStatement(sql);
			
			pst.setInt(1, id);
			
			rs = pst.executeQuery();
			
			while(rs.next()){	
				e = new Emp();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSalary(rs.getInt(3));
				e.setBirthday(rs.getDate(4));
				break;
			}	
		} catch (SQLException e1) {
			e1.printStackTrace();
		}finally{
			JDBCUtil.close(conn, pst, rs);
		}
		return e;
	}

	public List<Emp> queryAll() {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List empList = new ArrayList<Emp>();
		try {
			conn = JDBCUtil.getConnection();
			String sql ="select * from emp";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				Emp e = new Emp();
				
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSalary(rs.getInt(3));
				e.setBirthday(rs.getDate(4));
				
				empList.add(e);
             }
			return empList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			JDBCUtil.close(conn, pst, rs);
		}
	}

	//暂时没有增加用户选择每页条数，设置为每页10条
	public List<Emp> initialize(int pageIndex, int pageSize) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List empList = new ArrayList<Emp>();
		try {
			conn = JDBCUtil.getConnection();
			String sql ="select * from emp limit ?,?";
			pst = conn.prepareStatement(sql);
			
			pst.setInt(1, (pageIndex-1)*pageSize);
			pst.setInt(2, pageSize);
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				Emp e = new Emp();
				
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSalary(rs.getInt(3));
				e.setBirthday(rs.getDate(4));
				
				empList.add(e);
             }
			return empList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			JDBCUtil.close(conn, pst, rs);
		}
	}

	//默认每页显示十行
	public List<Emp> initialize(int pageIndex) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List empList = new ArrayList<Emp>();
		try {
			conn = JDBCUtil.getConnection();
			String sql ="select * from emp limit ?,10";
			pst = conn.prepareStatement(sql);
			
			pst.setInt(1, (pageIndex-1)*10);
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				Emp e = new Emp();
				
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSalary(rs.getInt(3));
				e.setBirthday(rs.getDate(4));
				
				empList.add(e);
             }
			return empList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			JDBCUtil.close(conn, pst, rs);
		}
	}
	
	//获取所有条数
	public int count() {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql ="select count(*)record_ from emp";
			pst = conn.prepareStatement(sql);
			
			rs = pst.executeQuery();
			
			int rowCount = 0;    
			if(rs.next())    
			{    
			    rowCount=rs.getInt("record_");    
			}
			
			return rowCount;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}finally{
			JDBCUtil.close(conn, pst, rs);
		}
	}
}
