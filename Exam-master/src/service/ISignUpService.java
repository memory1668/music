package service;

import vo.ExamEntity;
import vo.SignupEntity;

import java.util.List;

public interface ISignUpService {

    //    ��ӱ�����Ϣ
    boolean addSignUp(SignupEntity signupEntity);

    //    ��ѯ���б�������
    List queryAllToBeSignUp(SignupEntity signupEntity, ExamEntity examEntity);

    //    ��ѯ�����ѷ���������Ϣ
    List querySignUp(SignupEntity signupEntity,ExamEntity examEntity);
}
