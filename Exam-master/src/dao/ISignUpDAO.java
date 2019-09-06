package dao;

import vo.ExamEntity;
import vo.SignupEntity;

import java.util.List;

public interface ISignUpDAO {

//    ��ӱ�����Ϣ
    boolean addSignUp(SignupEntity signupEntity);

//    ��ѯ���пɱ�������
    List queryAllToBeSignUp(SignupEntity signupEntity, ExamEntity examEntity);

//    ��ѯ�����ѷ���������Ϣ
    List querySignUp(SignupEntity signupEntity,ExamEntity examEntity);
}
