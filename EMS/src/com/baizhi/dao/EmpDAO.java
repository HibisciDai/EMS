package com.baizhi.dao;

import java.util.List;
import com.baizhi.entity.Emp;

public interface EmpDAO {
	public abstract void insert(Emp e);

	public abstract void update(Emp e, int id);
	
	public abstract void delete(int id);

	public abstract Emp findById(int id);

	public abstract List<Emp> queryAll();
	
	public List<Emp> initialize(int pageIndex, int pageSize);	//分页查询
	
	public List<Emp> initialize(int pageIndex);	//分页查询，每页10
	
	public int count();	//统计所有条数
	
}
