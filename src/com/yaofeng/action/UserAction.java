package com.yaofeng.action;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yaofeng.model.Email;
import com.yaofeng.model.Leave;
import com.yaofeng.model.User;
import com.yaofeng.service.IUserService;

@Controller
@RequestMapping(value = "/user")
public class UserAction {

	@Autowired
	IUserService userService;

	// ��½���
	@RequestMapping(value = "/checkuser")
	@ResponseBody
	public String checkUser(User user, HttpSession session) {
		User findUser = userService.findUser(user);
		if (findUser != null) {
			System.out.println("�û���Ϊ��");
			// �ж������Ƿ���ȷ
			if (user.getEmp_password().equals(findUser.getEmp_password())) {
				System.out.println("��֤ͨ����ת��index����");
				session.setAttribute("findUser", findUser);
				return "1";
			} else {
				return "0";
			}
		}
		return "0";
	}

	//�޸ı���
	@RequestMapping(value = "/saveUser")
	public String saveUser(User user, HttpSession session) {
		User usersession = (User) session.getAttribute("findUser");
		Integer emp_id = usersession.getEmp_id();
		user.setEmp_id(emp_id);
		userService.saveUser(user);

		User findUser = userService.findUser(user);
		session.setAttribute("findUser", findUser);
		return "personinfor";

	}
	
	//�����˻�
	@RequestMapping(value = "/saveAccount")
	public String saveAccount(User user, HttpSession session) {
		User usersession = (User) session.getAttribute("findUser");
		Integer emp_id = usersession.getEmp_id();
		user.setEmp_id(emp_id);
		userService.saveAccount(user);

		User findUser = userService.findUser(user);
		session.setAttribute("findUser", findUser);
		return "personAccount";

	}

	//�˻�����
	@RequestMapping(value="/adminAccount")
	public String adminAccount(HttpSession session) {
		 List<User> findAll = userService.findAll();
		session.setAttribute("findAll", findAll);
		return "adminAccount";
		
	}
	//����˻�
	@RequestMapping(value="/addAccount")
	public String addAccount(User user,HttpSession session) {
		 userService.addAccount(user);
		return "adminAccount";
		
	}
	
	//��ѯ�����ݼٵ���Ϣ�б�
		@RequestMapping(value="/toleavelist")
		public String leavelist(User user,HttpSession session) {
			User usersession = (User) session.getAttribute("findUser");
			 List<Leave> leaveList = userService.findLeaveList(usersession);
			 session.setAttribute("leavelist", leaveList);
			return "leavelist";
			
		}
		
//�ύ����submitapply
		@RequestMapping(value="/submitapply")
		public String submitapply(Leave leave,HttpSession session) {
		userService.submitapply(leave);
			return "leavelist";
			
		}
		
//��ѯ���е�����˵��б�
		@RequestMapping(value="/showAllLeave")
		public String dealleave(HttpSession session) {
		List<Leave> leavelist = userService.findAllLeave();
		session.setAttribute("leavelist", leavelist);
			return "leavelist";	
		}
//�����ʼ�
		@RequestMapping(value="/sendEmail")
		public String sendEmail(User user,Email email,HttpSession session,@RequestParam("file") MultipartFile file) throws Exception, IOException{		
			if(!file.isEmpty()) {
			 //String picName = UUID.randomUUID().toString();
			 // ��ȡ�ļ�����չ��(��.jpg)
		    String oriName = file.getOriginalFilename();
		    System.out.println("+++++++"+oriName);
			   /* String extName = oriName.substring(oriName.lastIndexOf("."));
			    // �����ļ�
			    file.transferTo(new File("E:\\upload\\" + picName + extName));*/
			   
			file.transferTo(new File("d:/"+file.getOriginalFilename()));
			email.setFile_name(oriName);
		}
		String send_name = user.getEmp_name();
		email.setSend_name(send_name);
		userService.saveEmail(email);
			return "index";	
		}
		
	//��ѯ�ʼ��б�
		@RequestMapping(value="/reviceEmail")
		public String reviceEmail(User user,HttpSession session) {
		List<Email> findEmailByName = userService.findEmailByName(user);
		session.setAttribute("findEmailByName", findEmailByName);
			return "reviceEmail";	
}
		}
