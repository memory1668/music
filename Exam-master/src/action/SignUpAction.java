package action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import service.IExamService;
import service.ISignUpService;
import vo.ExamEntity;
import vo.SignupEntity;
import vo.util.TempSignUpInfo;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class SignUpAction extends ActionSupport{
    private  ISignUpService signUpService;
    private SignupEntity signupEntity;

    private IExamService examService;

    public IExamService getExamService() {
        return examService;
    }

    public void setExamService(IExamService examService) {
        this.examService = examService;
    }

    public SignupEntity getSignupEntity() {
        return signupEntity;
    }

    public void setSignupEntity(SignupEntity signupEntity) {
        this.signupEntity = signupEntity;
    }

    public ISignUpService getSignUpService() {
        return signUpService;
    }

    public void setSignUpService(ISignUpService signUpService) {
        this.signUpService = signUpService;
    }

    /**
     * ����������Ϣ
     */
    public String addSignUp(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");//�������ڸ�ʽ
        signupEntity.setSignUpPutTime(df.format(new Date()));//��ȡ��ǰ����
        if (signUpService.addSignUp(signupEntity)){
            //������Ӧ���Ե�״̬
            if (examService.updateExamStatus(signupEntity.getExamId()))
            return SUCCESS;
        }

        return ERROR;
    }

//    /**
//     * ��ʾ���пɱ�������
//     */
//    public String showAllToBeSignUp(){
//        SignupEntity signupEntity=new SignupEntity();
//        ExamEntity examEntity=new ExamEntity();
//        List resultList=signUpService.queryAllToBeSignUp(signupEntity,examEntity);
//        HttpServletRequest request= ServletActionContext.getRequest();
//        request.setAttribute("AllSignUp",resultList);
//        return SUCCESS;
//    }

    /**
     * ��ʾ�����ѷ���������Ϣ
     */
    public String showAllSignUp(){
        SignupEntity signupEntity=new SignupEntity();
        ExamEntity examEntity=new ExamEntity();
        List resultList=signUpService.querySignUp(signupEntity,examEntity);
        HttpServletRequest request=ServletActionContext.getRequest();
//        request.setAttribute("SignUp",resultList);

        //����������һ����ʱʵ������
        if (resultList.size()>0){
            List list=new LinkedList();
            TempSignUpInfo tempSignUpInfo;
            for (int i=0;i<resultList.size();i++){
                tempSignUpInfo=new TempSignUpInfo();
                Object[] objects=(Object[])resultList.get(i);
                int signUpId=(int)objects[0];
                String examName=(String)objects[1];
                String examTime=(String)objects[2];
                String signUpPutTime=(String)objects[3];
                String signUpStartTime=(String)objects[4];
                String signUpEndTime=(String)objects[5];
                String examPlace=(String)objects[6];

                // ���·�װ��һ��javabean����
                tempSignUpInfo.setSignUpId(signUpId);
                tempSignUpInfo.setExamName(examName);
                tempSignUpInfo.setExamTime(examTime);
                tempSignUpInfo.setSignUpPutTime(signUpPutTime);
                tempSignUpInfo.setSignUpStartTime(signUpStartTime);
                tempSignUpInfo.setSignUpEndTime(signUpEndTime);
                tempSignUpInfo.setExamPlace(examPlace);

                list.add(tempSignUpInfo);//����װ��list��
            }
            request.setAttribute("SignUp",list);
        }

        return SUCCESS;
    }

}
