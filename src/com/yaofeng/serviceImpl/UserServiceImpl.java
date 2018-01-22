package com.yaofeng.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaofeng.mapper.IUserMapper;
import com.yaofeng.model.Email;
import com.yaofeng.model.Leave;
import com.yaofeng.model.User;
import com.yaofeng.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserMapper userMapper;
	
	@Override
	public User findUser(User user) {
		return userMapper.findUser(user);
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		userMapper.saveUser(user);
	}

	@Override
	public void saveAccount(User user) {
		// TODO Auto-generated method stub
			userMapper.saveAccount(user);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userMapper.findAll();
	}

	@Override
	public void addAccount(User user) {
		// TODO Auto-generated method stub
		userMapper.addAccount(user);
	}

	@Override
	public List<Leave> findLeaveList(User user) {
		// TODO Auto-generated method stub
		return userMapper.findLeaveList(user);
	}

	@Override
	public void submitapply(Leave leave) {
		// TODO Auto-generated method stub
		userMapper.submitapply(leave);
	}

	@Override
	public List<Leave> findAllLeave() {
		// TODO Auto-generated method stub
		return userMapper.findAllLeave();
	}

	@Override
	public void saveEmail(Email email) {
		// TODO Auto-generated method stub
		userMapper.saveEmail(email);
	}

	@Override
	public List<Email> findEmailByName(User user) {
		// TODO Auto-generated method stub
		return userMapper.findEmailByName(user);
	}

}
