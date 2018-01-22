package com.yaofeng.service;

import java.util.List;

import com.yaofeng.model.Email;
import com.yaofeng.model.Leave;
import com.yaofeng.model.User;

public interface IUserService {
	
	/*User findUser(User user);
	void saveUser(User user);
	void saveAccount(User user);
	List<User> findAll();
	void addAccount(User user);
	List<Leave> findLeaveList(User user);
	void submitapply(Leave leave);
	List<Leave> findAllLeave();
	void saveEmail(Email email);
	List<Email> findEmailByName(User user);
	Email findEmailById(Email email);
	void updateEmailById(Email email);
	void deleteBylogically(Email email);
	List<Email> findAllJunk(User user);
	void deleteEmail(Email email);
	void restoreEmail(Email email);*/
	//登陆检查
	User findUser(User user);
	//保存用户修改信息
	void saveUser(User user);
	//保存账户
	void saveAccount(User user);
	//查找所有用户
	List<User> findAll();
	//添加账户
	void addAccount(User user);
	//查找所有自己请假列表
	List<Leave> findLeaveList(User user);
	//提交请假申请
	void submitapply(Leave leave);
	//查找所有审核了表
	List<Leave> findAllLeave();
	//发送邮件
	void saveEmail(Email email);
	//查询邮件列表
	List<Email> findEmailByName(User user);
	//邮件详情页
	Email findEmailById(Email email);
	//已读操作
	void updateEmailById(Email email);
	//逻辑删除
	void deleteBylogically(Email email);
	//垃圾邮箱
	List<Email> findAllJunk(User user);
	//物理删除
	void deleteEmail(Email email);
	//还原操作
	void restoreEmail(Email email);
}
