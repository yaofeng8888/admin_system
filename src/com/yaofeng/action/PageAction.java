package com.yaofeng.action;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yaofeng.model.Email;

@Controller
@RequestMapping(value="/user")
public class PageAction {
	

	//登陆界面
	@RequestMapping(value="/tologin")
	public String tologin() {
		return"login";
	}
	//主页
	@RequestMapping(value="/toindex")
	public String toindex() {
		return "index";
	}
	//个人信息页面
	@RequestMapping(value="personinfor")
	public String toperson() {
		return "personinfor";
	}
	//编辑个人信息页面
	@RequestMapping(value="editinfor")
	public String editinfor() {
		return "editinfor";
	}
	
	@RequestMapping(value="personAccount")
	public String personAccount() {
		return "personAccount";
	}
	//编辑个人账户页面
	@RequestMapping(value="editAccount")
	public String editAccount() {
		return "editAccount";
	}
	//添加用户页面
	@RequestMapping(value="toaddUser")
	public String toaddUser() {
		return "addUser";
	}
	//申请休假页面
	@RequestMapping(value="applyleave")
	public String applyleave() {
		return "applyleave";
	}
	//处理休假页面
	@RequestMapping(value="dealleave")
	public String dealleave() {
		return "dealleave";
	}
	//写邮件页面
	@RequestMapping(value="writeEmail")
	public String writeEmail() {
		return "writeEmail";
	}
	
}