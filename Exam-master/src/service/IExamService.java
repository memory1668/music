package service;

import vo.ExamEntity;

import java.util.List;

public interface IExamService {
    //����������Ϣ
    boolean addExam(ExamEntity examEntity);

    //    ��ѯ���п���
    List queryAllExamName(ExamEntity examEntity);

    //    ɾ��������Ϣ
    boolean removeExam(ExamEntity examEntity);

    //    ��ѯĳһ������Ϣ
    List queryOneExam(ExamEntity examEntity);

    //���Ŀ���״̬Ϊ�ѷ���
    boolean updateExamStatus(int examId);
}
