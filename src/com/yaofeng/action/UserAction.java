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

	// 登陆检查
	@RequestMapping(value = "/checkuser")
	@ResponseBody
	public String checkUser(User user, HttpSession session) {
		User findUser = userService.findUser(user);
		if (findUser != null) {
			System.out.println("用户不为空");
			// 判断密码是否正确
			if (user.getEmp_password().equals(findUser.getEmp_password())) {
				System.out.println("验证通过，转到index界面");
				session.setAttribute("findUser", findUser);
				return "1";
			} else {
				return "0";
			}
		}
		return "0";
	}
	//注销
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:tologin";
	}

	// 修改保存
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

	// 个人账户
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

	// 账户管理
	@RequestMapping(value = "/adminAccount")
	public String adminAccount(HttpSession session) {
		List<User> findAll = userService.findAll();
		session.setAttribute("findAll", findAll);
		return "adminAccount";

	}

	// 添加账户
	@RequestMapping(value = "/addAccount")
	public String addAccount(User user, HttpSession session) {
		userService.addAccount(user);
		return "redirect:adminAccount";

	}

	// 查询申请休假的信息列表
	@RequestMapping(value = "/toleavelist")
	public String leavelist(User user, HttpSession session) {
		User usersession = (User) session.getAttribute("findUser");
		List<Leave> leaveList = userService.findLeaveList(usersession);
		session.setAttribute("leavelist", leaveList);
		return "leavelist";

	}
	//申请休假页面---->审批人
	@RequestMapping(value="applyleave")
	public String applyleave(HttpSession session) {
		List<User> allAdmin = userService.findAllAdmin();
		session.setAttribute("allAdmin", allAdmin);
		return "applyleave";
	}

	// 提交申请submitapply
	@RequestMapping(value = "/submitapply")
	public String submitapply(Leave leave, HttpSession session) {
		userService.submitapply(leave);
		return "redirect:toleavelist";

	}

	// 查询所有的请假人的列表
	@RequestMapping(value = "/showAllLeave")
	public String dealleave(User user,Leave leave,HttpSession session) {
		User usersession = (User) session.getAttribute("findUser");
		String emp_name = usersession.getEmp_name();
		leave.setCheckmen(emp_name);
		List<Leave> leavelist = userService.findAllLeave(leave);
		session.setAttribute("leavelist", leavelist);
		return "leavelist";
	}
	
	//审核详情页
	@RequestMapping(value = "/dealleave")
	public String dealleave(Leave leave,HttpSession session) {
		Leave personLeave = userService.selectById(leave);
		session.setAttribute("personLeave", personLeave);
		return "dealleave";
	}
	
	//通过请假审核
	@RequestMapping(value = "/passCheck")
	public String passCheck(Leave leave,HttpSession session) {
		userService.updateLeaveState(leave);
		return "redirect:showAllLeave";
	}
	//请假不通过	
	@RequestMapping(value = "/passfail")
	public String passfail(Leave leave,HttpSession session) {
		userService.updateLeaveStateFail(leave);
		return "redirect:showAllLeave";
	}
	
	//收件人列表
	@RequestMapping(value = "/writeEmail")
	public String writeEmail(HttpSession session) {
		List<User> allRevice = userService.selectAllRevice();
		session.setAttribute("allRevice", allRevice);
		return "writeEmail";
	}
	
	// 发送邮件
	@RequestMapping(value = "/sendEmail")
	public String sendEmail(User user, Email email, HttpSession session, @RequestParam("file") MultipartFile file)
			throws Exception, IOException {
		if (!file.isEmpty()) {
			// String picName = UUID.randomUUID().toString();
			// 截取文件的扩展名(如.jpg)
			String oriName = file.getOriginalFilename();
			System.out.println("+++++++"+oriName);
			/*
			 * String extName = oriName.substring(oriName.lastIndexOf(".")); // 保存文件
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

	// 查询邮件列表
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

	// 邮件详情页
	@RequestMapping(value = "/emailinfor")
	public String emailinfor(Email email, User user, HttpSession session) {
		Email findEmailById = userService.findEmailById(email);
		session.setAttribute("findEmailById", findEmailById);		
		return "emailinfor";
	}
	//邮件的已读操作
	@RequestMapping(value = "/updateEmail")
	public String updateEmail(Email email, HttpSession session) {
		userService.updateEmailById(email);
		return "redirect:reviceEmail";
	}
	
	// 文件下载
	@RequestMapping(value="/download")
		public void down(HttpServletRequest request, HttpServletResponse response) throws Exception {
			String file = request.getParameter("file_name");
			// 拼接路劲
			String fileName = "d:/" + file;
			// 获取输入流
			InputStream bis = new BufferedInputStream(new FileInputStream(new File(fileName)));
			// 假如以中文名下载的话
			String filenameDown = file;
			// 转码，免得文件名中文乱码
			filenameDown = URLEncoder.encode(filenameDown, "iso-8859-1");
			// 设置文件下载头		
			response.addHeader("Content-Disposition", "attachment;filename=" + filenameDown);
			// 1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
			response.setContentType("multipart/form-data");
			BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
			int len = 0;
			while ((len = bis.read()) != -1) {
				out.write(len);
				out.flush();
			}
			out.close();
		}

	//逻辑删除
	@RequestMapping(value = "/logicallydelete")
	public String logicallydelete(Email email, HttpSession session) {
		userService.deleteBylogically(email);
		return "redirect:reviceEmail";
	}
	//显示垃圾邮件列表
	@RequestMapping(value = "/junkEmail")
	public String junkEmail(User user,HttpSession session) {
		User usersession = (User) session.getAttribute("findUser");
		String emp_name = usersession.getEmp_name();
		user.setEmp_name(emp_name);
		List<Email> findAllJunk = userService.findAllJunk(user);
		session.setAttribute("findAll", findAllJunk);
		return "junkEmail";
	}
	
	//物理删除
	@RequestMapping(value = "/delete")
	public String delete(Email email,HttpSession session) {
		userService.deleteEmail(email);
		return "redirect:junkEmail";
	}
	//还原操作
	@RequestMapping(value = "/restoreEmail")
	public String restoreEmail(Email email,HttpSession session) {
		userService.restoreEmail(email);
		return "redirect:junkEmail";
	}
}
