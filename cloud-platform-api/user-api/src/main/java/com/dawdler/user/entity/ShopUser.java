package com.dawdler.user.entity;

public class ShopUser {
    private Long userId;
    private Long ugId;
    private String nickName;
    private String mobile;
    private String password;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getUgId() {
		return ugId;
	}
	public void setUgId(Long ugId) {
		this.ugId = ugId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}