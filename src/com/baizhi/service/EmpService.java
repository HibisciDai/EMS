package com.baizhi.service;

import java.util.List;
import com.baizhi.entity.Emp;

public interface EmpService {

	public void save(Emp e); // 保存联系人

	public void update(Emp e); // 更新联系人

	public void delete(int id); // 删除联系人

	public Emp get(int id); // 通过id获取联系人

	public List<Emp> query(); // 查询所有联系人
}
