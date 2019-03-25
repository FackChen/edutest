package com.edu.domain;

public class Teacher
{
	private Integer id;
	private String name;
	private String gender;
	private String classes;
	private String number;
	private String telephone;
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getGender()
	{
		return gender;
	}
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	public String getClasses()
	{
		return classes;
	}
	public void setClasses(String classes)
	{
		this.classes = classes;
	}
	public String getNumber()
	{
		return number;
	}
	public void setNumber(String number)
	{
		this.number = number;
	}
	public String getTelephone()
	{
		return telephone;
	}
	public void setTelephone(String telephone)
	{
		this.telephone = telephone;
	}
	@Override
	public String toString()
	{
		return "Teacher [id=" + id + ", name=" + name + ", gender=" + gender + ", classes=" + classes + ", number=" + number + ", telephone="
				+ telephone + "]";
	}
	
}
