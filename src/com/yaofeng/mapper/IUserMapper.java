package com.yaofeng.mapper;

import java.util.List;

import com.yaofeng.model.Email;
import com.yaofeng.model.Leave;
import com.yaofeng.model.User;

public interface IUserMapper {
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
	//�����ݼ�---->�������б�
	List<User> findAllAdmin();
	//�ύ�������
	void submitapply(Leave leave);
	//������������˱�
	List<Leave> findAllLeave(Leave leave);
	//�������
	Leave selectById(Leave leave);
	//���ͨ��
	void updateLeaveState(Leave leave);
	//��˾ܾ�
	void updateLeaveStateFail(Leave leave);
	//�������е��ռ���
	List<User> selectAllRevice();
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
