package dao;

import vo.StudentsignupEntity;

import java.util.List;

public interface IStudentSignUpDAO {
//    ѧ��ѡ���Ա���
    boolean insertStudentSignUp(StudentsignupEntity studentsignupEntity);

//    �鿴ĳ���Ա�����ѧ��
    List queryStuToSignUp(StudentsignupEntity studentsignupEntity);

//    ѧ���˲鿴�ѱ�������
    List StuQuerySignUp(StudentsignupEntity studentsignupEntity);
}
