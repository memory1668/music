package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import service.IUserService;
import vo.StudentEntity;
import vo.UserEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class UserAction extends ActionSupport {
    private UserEntity userEntity;      //���յ�¼����������û���Ϣ.
    private StudentEntity studentEntity;    //���ܹ���Ա���ͨ����ѧ����Ϣ


    private IUserService userService;

    private String newPassword;//�����루�޸�����ʹ�ã�

    //    �û���½
    public String login() {
        UserEntity u = userService.validateUser(userEntity.getUserEmail(), userEntity.getUserPassword(), userEntity.getUserPermit());
        if (u != null) {
            Map<String, Object> session = ActionContext.getContext().getSession();

//            ����˴λỰ��Ϣ
            session.put("user", u);
//            HttpServletRequest request= ServletActionContext.getRequest();
//            request.setAttribute("user",u);
            if (u.getUserPermit()==0){
                return SUCCESS;
            }else if (u.getUserPermit()==1){
                return "stu_success";
            }else if (u.getUserPermit()==2){
                return "depart_success";
            }


        }
        return ERROR;
    }

    //�û�ע��
    public String loginout(){
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.remove("user");
        return SUCCESS;
    }

    /**
     *�޸�����
     */
    public String updatePassword(){
        if (userService.updatePassword(userEntity,newPassword))
            return SUCCESS;
        return ERROR;
    }


    //    set��get
    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public void setStudentEntity(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }


    public IUserService getUserService() {
        return userService;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
