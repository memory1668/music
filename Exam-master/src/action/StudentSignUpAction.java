package action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import service.IStudentSignUpService;
import vo.StudentsignupEntity;
import vo.util.TempSignUpExam;
import vo.util.TempSignUpHaveStuInfo;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class StudentSignUpAction extends ActionSupport{
    private StudentsignupEntity studentsignupEntity;
    private IStudentSignUpService studentSignUpService;





    public StudentsignupEntity getStudentsignupEntity() {
        return studentsignupEntity;
    }

    public void setStudentsignupEntity(StudentsignupEntity studentsignupEntity) {
        this.studentsignupEntity = studentsignupEntity;
    }

    public IStudentSignUpService getStudentSignUpService() {
        return studentSignUpService;
    }

    public void setStudentSignUpService(IStudentSignUpService studentSignUpService) {
        this.studentSignUpService = studentSignUpService;
    }

    /**
     * ѧ��ѡ���Ա���
     *
     * ��Ҫ����SignUp_id��stu_id
     */
    public String selectSignUp(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");//�������ڸ�ʽ
        studentsignupEntity.setSignUpTime(df.format(new Date()));//��ȡ����ʱ��

        if (studentSignUpService.insertStudentSignUp(studentsignupEntity))
            return SUCCESS;
        return ERROR;
    }

    /**
     * �鿴ĳ���Ա�����ѧ��
     */
    public String queryStuToSignUp(){
       List resultList= studentSignUpService.queryStuToSignUp(studentsignupEntity);
        HttpServletRequest request= ServletActionContext.getRequest();
        //����������һ����ʱʵ������
        if (resultList.size()>0){
            List list=new LinkedList();
            TempSignUpHaveStuInfo signUpHaveStuInfo;
            for (int i=0;i<resultList.size();i++){
                signUpHaveStuInfo=new TempSignUpHaveStuInfo();
                Object[] objects=(Object[])resultList.get(i);
                int stuId=(int)objects[0];
                String stuName=(String)objects[1];
                String stuIdNum=(String)objects[2];
                String signUpPutTime=(String)objects[3];

                // ���·�װ��һ��javabean����
                signUpHaveStuInfo.setStuId(stuId);
                signUpHaveStuInfo.setStuName(stuName);
                signUpHaveStuInfo.setStuIdNum(stuIdNum);
                signUpHaveStuInfo.setSignUpPutTime(signUpPutTime);


                list.add(signUpHaveStuInfo);//����װ��list��
            }
            request.setAttribute("Stu",list);
        }
       return SUCCESS;
    }


    /**
     * ѧ���˲鿴�ѱ�������
     */
    public String StuQuerySignUp(){
        List reslutList=studentSignUpService.StuQuerySignUp(studentsignupEntity);
        HttpServletRequest request=ServletActionContext.getRequest();
        if (reslutList.size()>0){
            TempSignUpExam tempSignUpExam;
            List list=new LinkedList();
            for (int i=0;i<reslutList.size();i++){
                tempSignUpExam=new TempSignUpExam();

                Object[] objects=(Object[])reslutList.get(i);
                tempSignUpExam.setSignUpTime((String)objects[0]);
                tempSignUpExam.setExamName((String)objects[1]);
                tempSignUpExam.setExamPlace((String)objects[2]);
                tempSignUpExam.setExamTime((String)objects[3]);

                list.add(tempSignUpExam);
            }
            request.setAttribute("signExam",list);
        }

        return SUCCESS;
    }

}
