package service;

import vo.DepartmentEntity;
import vo.ExamineEntity;
import vo.StudentEntity;

import java.util.List;

public interface IExamineService {
    //    ��ע��ѧ��id���� examine��
    void addStuIdToExam(ExamineEntity examineEntity);

    //    ��ѯ�����д���˵�ѧ����Ϣ
    List queryAllStuToBeAudited(ExamineEntity examineEntity, StudentEntity studentEntity);

    //    ��ѯδ��˵�ѧ��id
    List queryStuidByExam(ExamineEntity examineEntity);

    //  ���ѧ������
    void setStuExStatus(int examStatus, int stuId);

    //    ��ѯ���д������֯������Ա��Ϣ
    List queryAllDepartToBeAudited(DepartmentEntity departmentEntity, ExamineEntity examineEntity);

    //��ע����֯����id�浽examine��
    void addDepartIdToExam(ExamineEntity examineEntity);

    //�����֯������Ա��Ϣ����
    void setDepartExStatus(int examStatus, int departId);
}
