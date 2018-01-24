package com.yaofeng.mapper;

import java.util.List;

import com.yaofeng.model.Email;
import com.yaofeng.model.Leave;
import com.yaofeng.model.User;

public interface IUserMapper {
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
	//申请休假---->审批人列表
	List<User> findAllAdmin();
	//提交请假申请
	void submitapply(Leave leave);
	//查找所有审核了表
	List<Leave> findAllLeave(Leave leave);
	//审核详情
	Leave selectById(Leave leave);
	//审核通过
	void updateLeaveState(Leave leave);
	//审核拒绝
	void updateLeaveStateFail(Leave leave);
	//查找所有的收件人
	List<User> selectAllRevice();
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
