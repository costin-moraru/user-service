package com.demo.users.service.dto;

public class UserFullnameDTO {
	
	private Integer id;
	
	private String fullname;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	@Override
	public String toString() {
		return "UserFullnameDTO [id=" + id + ", fullname=" + fullname + "]";
	}
	

}
