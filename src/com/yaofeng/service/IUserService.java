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
	//��½���
	User findUser(User user);
	//�����û��޸���Ϣ
	void saveUser(User user);
	//�����˻�
	void saveAccount(User user);
	//���������û�
	List<User> findAll();
	//����˻�
	void addAccount(User user);
	//���������Լ�����б�
	List<Leave> findLeaveList(User user);
	//�ύ�������
	void submitapply(Leave leave);
	//������������˱�
	List<Leave> findAllLeave();
	//�����ʼ�
	void saveEmail(Email email);
	//��ѯ�ʼ��б�
	List<Email> findEmailByName(User user);
	//�ʼ�����ҳ
	Email findEmailById(Email email);
	//�Ѷ�����
	void updateEmailById(Email email);
	//�߼�ɾ��
	void deleteBylogically(Email email);
	//��������
	List<Email> findAllJunk(User user);
	//����ɾ��
	void deleteEmail(Email email);
	//��ԭ����
	void restoreEmail(Email email);
}
