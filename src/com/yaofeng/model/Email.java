package com.yaofeng.model;

import java.io.Serializable;

public class Email implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer email_id;
	private String email_title;
	private String email_body;
	private String sendTime;
	private Integer isRead;
	private String emp_name;
	private String file_name;
	private String send_name;
	
	public Integer getEmail_id() {
		return email_id;
	}
	public void setEmail_id(Integer email_id) {
		this.email_id = email_id;
	}
	public String getSend_name() {
		return send_name;
	}
	public void setSend_name(String send_name) {
		this.send_name = send_name;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getEmail_title() {
		return email_title;
	}
	public void setEmail_title(String email_title) {
		this.email_title = email_title;
	}
	public String getEmail_body() {
		return email_body;
	}
	public void setEmail_body(String email_body) {
		this.email_body = email_body;
	}
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	public Integer getIsRead() {
		return isRead;
	}
	public void setIsRead(Integer isRead) {
		this.isRead = isRead;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	
}
