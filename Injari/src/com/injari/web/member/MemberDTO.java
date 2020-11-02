package com.injari.web.member;

import java.sql.Timestamp;

public class MemberDTO {
	private String email;
	private String password;
	private String name;
	private int uid;
	private int authority;
	private Timestamp mkdate;
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getAuthority() {
		return authority;
	}
	public void setAuthority(int authority) {
		this.authority = authority;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getMkdate() {
		return mkdate;
	}
	public void setMkdate(Timestamp mkdate) {
		this.mkdate = mkdate;
	}
}
