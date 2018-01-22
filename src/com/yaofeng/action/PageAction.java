package com.yaofeng.action;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yaofeng.model.Email;

@Controller
@RequestMapping(value="/user")
public class PageAction {
	

	//��½����
	@RequestMapping(value="/tologin")
	public String tologin() {
		return"login";
	}
	//��ҳ
	@RequestMapping(value="/toindex")
	public String toindex() {
		return "index";
	}
	//������Ϣҳ��
	@RequestMapping(value="personinfor")
	public String toperson() {
		return "personinfor";
	}
	//�༭������Ϣҳ��
	@RequestMapping(value="editinfor")
	public String editinfor() {
		return "editinfor";
	}
	
	@RequestMapping(value="personAccount")
	public String personAccount() {
		return "personAccount";
	}
	//�༭�����˻�ҳ��
	@RequestMapping(value="editAccount")
	public String editAccount() {
		return "editAccount";
	}
	//����û�ҳ��
	@RequestMapping(value="toaddUser")
	public String toaddUser() {
		return "addUser";
	}
	//�����ݼ�ҳ��
	@RequestMapping(value="applyleave")
	public String applyleave() {
		return "applyleave";
	}
	//�����ݼ�ҳ��
	@RequestMapping(value="dealleave")
	public String dealleave() {
		return "dealleave";
	}
	//д�ʼ�ҳ��
	@RequestMapping(value="writeEmail")
	public String writeEmail() {
		return "writeEmail";
	}
	
}