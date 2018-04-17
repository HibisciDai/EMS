package com.baizhi.service.impl;

import java.util.List;
import com.baizhi.dao.EmpDAO;
import com.baizhi.dao.impl.EmpDAOImpl;
import com.baizhi.entity.Emp;
import com.baizhi.service.EmpService;

public class EmpServiceImpl implements EmpService {
	private EmpDAO ed = new EmpDAOImpl();
	
	public void save(Emp e) {
		ed.insert(e);
	}

	public void update(Emp e) {
		ed.update(e, e.getId());
	}

	public void delete(int id) {
		ed.delete(id);
	}

	public Emp get(int id) {
		return ed.findById(id);
	}

	public List<Emp> query() {
		return ed.queryAll();
	}

}
