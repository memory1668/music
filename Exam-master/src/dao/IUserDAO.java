package dao;

import vo.UserEntity;

public interface IUserDAO {

    //    �û���½ʱ����֤�û���Ϣ
    UserEntity validateUser(String userEmail, String password, int permit);

    UserEntity addUser(UserEntity userEntity);

//    �޸�����
    boolean updatePassword(UserEntity userEntity,String newPassword);
}
