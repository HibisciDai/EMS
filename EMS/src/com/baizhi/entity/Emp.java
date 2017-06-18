package com.baizhi.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Emp {
	private int id;
	private String name;
	private int salary;
	private Date birthday;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public java.sql.Date getBirthday() {
		java.sql.Date birthday = new java.sql.Date(this.birthday.getTime());
		return birthday;
	}
	
	public String getBirthdayString() {
		return this.birthday.toString();
	}

	public java.util.Date setBirthday(String birthday) {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		
		try {
			date = sdf1.parse(birthday);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return date;
//		this.birthday = date;
	}
	
	public void setBirthday(Date date) {
		this.birthday = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + salary;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emp other = (Emp) obj;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (salary != other.salary)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", salary=" + salary + ", date=" + birthday + "]";
	}

	public Emp(int id) {
		super();
		this.id = id;
	}

	public Emp(int id, String name, int salary, Date birthday) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.birthday = birthday;
	}
	
	public Emp(int id, String name, int salary, String birthday) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.birthday = this.setBirthday(birthday);
	}

	public Emp(String name, int salary, Date birthday) {
		super();
		this.name = name;
		this.salary = salary;
		this.birthday = birthday;
	}

	public Emp(String name, int salary, String birthday) {
		super();
		this.name = name;
		this.salary = salary;
		this.birthday = this.setBirthday(birthday);
	}
	
	public Emp() {
		super();
	}

}
