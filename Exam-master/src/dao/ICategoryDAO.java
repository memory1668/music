package dao;

import vo.CategoryEntity;

import java.util.List;

public interface ICategoryDAO {
    //������������
    boolean addCategory(CategoryEntity categoryEntity);

    //��ѯ���п������
    List queryAllCategory(CategoryEntity categoryEntity);
}
