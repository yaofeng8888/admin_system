package com.yaofeng.mapperImpl;

import java.util.List;

import com.yaofeng.mapper.IUserMapper;
import com.yaofeng.model.Email;
import com.yaofeng.model.Leave;
import com.yaofeng.model.User;

public class UserMapperImpl implements IUserMapper {

	@Override
	public User findUser(User user) {
		return user;
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveAccount(User user) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addAccount(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Leave> findLeaveList(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void submitapply(Leave leave) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Leave> findAllLeave(Leave leave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveEmail(Email email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Email> findEmailByName(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Email findEmailById(Email email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEmailById(Email email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBylogically(Email email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Email> findAllJunk(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEmail(Email email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void restoreEmail(Email email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateLeaveState(Leave leave) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Leave selectById(Leave leave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateLeaveStateFail(Leave leave) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> findAllAdmin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> selectAllRevice() {
		// TODO Auto-generated method stub
		return null;
	}

}
