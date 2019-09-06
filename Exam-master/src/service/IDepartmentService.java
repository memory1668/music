package service;

import vo.DepartmentEntity;
import vo.ExamineEntity;

import java.util.List;

public interface IDepartmentService {
    //������֯������Ա��Ϣ
    boolean addDepartment(DepartmentEntity departmentEntity);

    //ͨ����֯������Աע��ʱ����������͹��Ų�ѯ id
    int findIdByDepartReg(DepartmentEntity departmentEntity);

    //��ѯ��֯��Ա��Ϣ����ע��ɹ���
    List queryAllRegDepart(DepartmentEntity departmentEntity, ExamineEntity examineEntity);

    //ɾ����֯��Ա��Ϣ
    boolean removeDepart(DepartmentEntity departmentEntity);

}
