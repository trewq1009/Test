package com.example.user.model;

import java.sql.Timestamp;

public class UserVO {

	private String id;
	private String pw;
	private String name;
	private String email, emailProvider;
	private String phoneFirst, phoneSecond, phoneThird;
	private String address;
	private String addressDetail;
	private Timestamp regdate;
	
	public UserVO() {}

	public UserVO(String id, String pw, String name, 
			String email, String emailProvider,
			String phoneFirst, String phoneSecond, String phoneThird, 
			String address, String addressDetail,
			Timestamp regdate) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.emailProvider = emailProvider;
		this.phoneFirst = phoneFirst;
		this.phoneSecond = phoneSecond;
		this.phoneThird = phoneThird;
		this.address = address;
		this.addressDetail = addressDetail;
		this.regdate = regdate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", pw=" + pw + ", name=" + name + ", email=" + email + ", address=" + address
				+ ", regdate=" + regdate + "]";
	}

	public String getEmailProvider() {
		return emailProvider;
	}

	public void setEmailProvider(String emailProvider) {
		this.emailProvider = emailProvider;
	}

	public String getPhoneFirst() {
		return phoneFirst;
	}

	public void setPhoneFirst(String phoneFirst) {
		this.phoneFirst = phoneFirst;
	}

	public String getPhoneSecond() {
		return phoneSecond;
	}

	public void setPhoneSecond(String phoneSecond) {
		this.phoneSecond = phoneSecond;
	}

	public String getPhoneThird() {
		return phoneThird;
	}

	public void setPhoneThird(String phoneThird) {
		this.phoneThird = phoneThird;
	}
}
