package service;

import vo.CategoryEntity;

import java.util.List;

public interface ICategoryService {
    //������������
    boolean addCategory(CategoryEntity categoryEntity);

    //��ѯ���п������
    List queryAllCategory(CategoryEntity categoryEntity);
}
