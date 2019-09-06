package service;

import vo.UserEntity;

public interface IUserService {

    //    ��֤�û���Ϣ
    UserEntity validateUser(String username, String password, int permit);

    //����û�
    UserEntity addUser(UserEntity userEntity);


    //    �޸�����
    boolean updatePassword(UserEntity userEntity,String newPassword);
}
