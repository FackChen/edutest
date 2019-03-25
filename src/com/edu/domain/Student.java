package com.edu.domain;

public class Student
{
	private Integer id;
	private String name;
	private String gender;
	private String classes;
	private String number;
	private String telephone;
	private Integer achievement;
	private Teacher teacher;
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
	public Integer getAchievement()
	{
		return achievement;
	}
	public void setAchievement(Integer achievement)
	{
		this.achievement = achievement;
	}
	public Teacher getTeacher()
	{
		return teacher;
	}
	public void setTeacher(Teacher teacher)
	{
		this.teacher = teacher;
	}
	@Override
	public String toString()
	{
		return "Student [id=" + id + ", name=" + name + ", gender=" + gender + ", classes=" + classes + ", number=" + number + ", telephone="
				+ telephone + ", achievement=" + achievement + "]";
	}
	
}
