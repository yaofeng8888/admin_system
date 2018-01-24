package com.yaofeng.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


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
	//ע��
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:tologin";
	}

	// �޸ı���
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

	// �����˻�
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

	// �˻�����
	@RequestMapping(value = "/adminAccount")
	public String adminAccount(HttpSession session) {
		List<User> findAll = userService.findAll();
		session.setAttribute("findAll", findAll);
		return "adminAccount";

	}

	// ����˻�
	@RequestMapping(value = "/addAccount")
	public String addAccount(User user, HttpSession session) {
		userService.addAccount(user);
		return "redirect:adminAccount";

	}

	// ��ѯ�����ݼٵ���Ϣ�б�
	@RequestMapping(value = "/toleavelist")
	public String leavelist(User user, HttpSession session) {
		User usersession = (User) session.getAttribute("findUser");
		List<Leave> leaveList = userService.findLeaveList(usersession);
		session.setAttribute("leavelist", leaveList);
		return "leavelist";

	}
	//�����ݼ�ҳ��---->������
	@RequestMapping(value="applyleave")
	public String applyleave(HttpSession session) {
		List<User> allAdmin = userService.findAllAdmin();
		session.setAttribute("allAdmin", allAdmin);
		return "applyleave";
	}

	// �ύ����submitapply
	@RequestMapping(value = "/submitapply")
	public String submitapply(Leave leave, HttpSession session) {
		userService.submitapply(leave);
		return "redirect:toleavelist";

	}

	// ��ѯ���е�����˵��б�
	@RequestMapping(value = "/showAllLeave")
	public String dealleave(User user,Leave leave,HttpSession session) {
		User usersession = (User) session.getAttribute("findUser");
		String emp_name = usersession.getEmp_name();
		leave.setCheckmen(emp_name);
		List<Leave> leavelist = userService.findAllLeave(leave);
		session.setAttribute("leavelist", leavelist);
		return "leavelist";
	}
	
	//�������ҳ
	@RequestMapping(value = "/dealleave")
	public String dealleave(Leave leave,HttpSession session) {
		Leave personLeave = userService.selectById(leave);
		session.setAttribute("personLeave", personLeave);
		return "dealleave";
	}
	
	//ͨ��������
	@RequestMapping(value = "/passCheck")
	public String passCheck(Leave leave,HttpSession session) {
		userService.updateLeaveState(leave);
		return "redirect:showAllLeave";
	}
	//��ٲ�ͨ��	
	@RequestMapping(value = "/passfail")
	public String passfail(Leave leave,HttpSession session) {
		userService.updateLeaveStateFail(leave);
		return "redirect:showAllLeave";
	}
	
	//�ռ����б�
	@RequestMapping(value = "/writeEmail")
	public String writeEmail(HttpSession session) {
		List<User> allRevice = userService.selectAllRevice();
		session.setAttribute("allRevice", allRevice);
		return "writeEmail";
	}
	
	// �����ʼ�
	@RequestMapping(value = "/sendEmail")
	public String sendEmail(User user, Email email, HttpSession session, @RequestParam("file") MultipartFile file)
			throws Exception, IOException {
		if (!file.isEmpty()) {
			// String picName = UUID.randomUUID().toString();
			// ��ȡ�ļ�����չ��(��.jpg)
			String oriName = file.getOriginalFilename();
			System.out.println("+++++++"+oriName);
			/*
			 * String extName = oriName.substring(oriName.lastIndexOf(".")); // �����ļ�
			 * file.transferTo(new File("E:\\upload\\" + picName + extName));
			 */

			file.transferTo(new File("d:/" + file.getOriginalFilename()));
			email.setFile_name(oriName);
		}
		User usersession = (User) session.getAttribute("findUser");
		String send_name = usersession.getEmp_name();
		email.setSend_name(send_name);
		userService.saveEmail(email);
		return "index";
	}

	// ��ѯ�ʼ��б�
	@RequestMapping(value = "/reviceEmail")
	public String reviceEmail(User user, HttpSession session) {
		User usersession = (User) session.getAttribute("findUser");
		String emp_name = usersession.getEmp_name();
		System.out.println("=====" + emp_name);
		user.setEmp_name(emp_name);
		List<Email> findEmailByName = userService.findEmailByName(user);
		session.setAttribute("findEmailByName", findEmailByName);
		return "reviceEmail";
	}

	// �ʼ�����ҳ
	@RequestMapping(value = "/emailinfor")
	public String emailinfor(Email email, User user, HttpSession session) {
		Email findEmailById = userService.findEmailById(email);
		session.setAttribute("findEmailById", findEmailById);		
		return "emailinfor";
	}
	//�ʼ����Ѷ�����
	@RequestMapping(value = "/updateEmail")
	public String updateEmail(Email email, HttpSession session) {
		userService.updateEmailById(email);
		return "redirect:reviceEmail";
	}
	
	// �ļ�����
	@RequestMapping(value="/download")
		public void down(HttpServletRequest request, HttpServletResponse response) throws Exception {
			String file = request.getParameter("file_name");
			// ƴ��·��
			String fileName = "d:/" + file;
			// ��ȡ������
			InputStream bis = new BufferedInputStream(new FileInputStream(new File(fileName)));
			// ���������������صĻ�
			String filenameDown = file;
			// ת�룬����ļ�����������
			filenameDown = URLEncoder.encode(filenameDown, "iso-8859-1");
			// �����ļ�����ͷ		
			response.addHeader("Content-Disposition", "attachment;filename=" + filenameDown);
			// 1.�����ļ�ContentType���ͣ��������ã����Զ��ж������ļ�����
			response.setContentType("multipart/form-data");
			BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
			int len = 0;
			while ((len = bis.read()) != -1) {
				out.write(len);
				out.flush();
			}
			out.close();
		}

	//�߼�ɾ��
	@RequestMapping(value = "/logicallydelete")
	public String logicallydelete(Email email, HttpSession session) {
		userService.deleteBylogically(email);
		return "redirect:reviceEmail";
	}
	//��ʾ�����ʼ��б�
	@RequestMapping(value = "/junkEmail")
	public String junkEmail(User user,HttpSession session) {
		User usersession = (User) session.getAttribute("findUser");
		String emp_name = usersession.getEmp_name();
		user.setEmp_name(emp_name);
		List<Email> findAllJunk = userService.findAllJunk(user);
		session.setAttribute("findAll", findAllJunk);
		return "junkEmail";
	}
	
	//����ɾ��
	@RequestMapping(value = "/delete")
	public String delete(Email email,HttpSession session) {
		userService.deleteEmail(email);
		return "redirect:junkEmail";
	}
	//��ԭ����
	@RequestMapping(value = "/restoreEmail")
	public String restoreEmail(Email email,HttpSession session) {
		userService.restoreEmail(email);
		return "redirect:junkEmail";
	}
}
