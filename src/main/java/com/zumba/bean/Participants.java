package com.zumba.bean;

public class Participants {
	public int pid;
	public String fname;
	public String lname;
	public int age;
	public String phonenumber;
	public int bid;
	public Participants() {}
	public Participants(int pid, String fname, String lname, int age, String phonenumber, int bid) {
		super();
		this.pid = pid;
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.phonenumber = phonenumber;
		this.bid = bid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	
	

}
