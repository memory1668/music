package service;

import vo.ExamineEntity;
import vo.StudentEntity;

import java.util.List;

public interface IStudentService {
    //    ���ѧ����Ϣ
    boolean addStudent(StudentEntity studentEntity);

    //    ���ѧ�������Ϣ
    ExamineEntity addStudentToExamine(ExamineEntity examineEntity);

    //      ͨ��ѧ��id,��ѯ�Ƿ����
    StudentEntity findStudentById(int stu_id);


    //    ͨ��ѧ��ע��ʱ��������֤�Ų�ѯѧ��id
    void findStuIdByRegister(StudentEntity studentEntity);

    //   ��ѯѧ����Ϣ����ע��ɹ���
    List showAllRegStu(StudentEntity studentEntity, ExamineEntity examineEntity);

    //    ɾ��ѧ����Ϣ(�����˻���Ϣ)
    boolean removeStu(StudentEntity studentEntity);
}
