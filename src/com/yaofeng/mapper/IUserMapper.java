package com.yaofeng.mapper;

import java.util.List;

import com.yaofeng.model.Email;
import com.yaofeng.model.Leave;
import com.yaofeng.model.User;

public interface IUserMapper {
	
	User findUser(User user);
	void saveUser(User user);
	void saveAccount(User user);
	List<User> findAll();
	void addAccount(User user);
	List<Leave> findLeaveList(User user);
	void submitapply(Leave leave);
	List<Leave> findAllLeave();
	void saveEmail(Email email);
	List<Email> findEmailByName(User user);
}
