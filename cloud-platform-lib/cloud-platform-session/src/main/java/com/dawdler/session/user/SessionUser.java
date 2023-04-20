package com.dawdler.session.user;

import java.io.Serializable;

public class SessionUser implements Serializable {
	private static final long serialVersionUID = 2504435591777694795L;

	private Long userId;

	private Long ugId;

	private String nickName;

	private String mobile;

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
