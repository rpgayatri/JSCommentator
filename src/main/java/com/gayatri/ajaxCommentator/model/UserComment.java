package com.gayatri.ajaxCommentator.model;

public class UserComment {

	private String userName;
	private String comment;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "UserComment [userName=" + userName + ", comment=" + comment + "]";
	}

}
