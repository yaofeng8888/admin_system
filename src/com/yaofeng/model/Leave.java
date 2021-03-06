package com.yaofeng.model;

import java.io.Serializable;

public class Leave implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String emp_name;
	private String start;
	private String end;
	private Integer days;
	private Integer state;
	private String reason;
	private String checkmen;
	private Integer leave_id;
	
	public Integer getLeave_id() {
		return leave_id;
	}
	public void setLeave_id(Integer leave_id) {
		this.leave_id = leave_id;
	}
	public String getCheckmen() {
		return checkmen;
	}
	public void setCheckmen(String checkmen) {
		this.checkmen = checkmen;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public Integer getDays() {
		return days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
