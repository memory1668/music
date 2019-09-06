package action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import service.IExamService;
import vo.ExamEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ExamAction extends ActionSupport {
    private IExamService examService;
    private ExamEntity examEntity;

    public ExamEntity getExamEntity() {
        return examEntity;
    }

    public void setExamEntity(ExamEntity examEntity) {
        this.examEntity = examEntity;
    }

    public IExamService getExamService() {
        return examService;
    }

    public void setExamService(IExamService examService) {
        this.examService = examService;
    }

    /**
     * ����������Ϣ
     */
    public String addExam(){
       if (examService.addExam(examEntity))
           return SUCCESS;
       return ERROR;
    }

    /**
     * ��ʾ���п�����Ϣ(δ����)
     */
    public String showAllExamName(){
        ExamEntity examEntity=new ExamEntity();
        List resultList=examService.queryAllExamName(examEntity);
        HttpServletRequest request= ServletActionContext.getRequest();
        request.setAttribute("AllExam",resultList);
        return SUCCESS;
    }

    /**
     * ɾ��������Ϣ
     */
    public String deleteExam(){
        if (examService.removeExam(examEntity))
            return SUCCESS;
        return ERROR;
    }

    /**
     * ��ѯĳһ������Ϣ
     */
    public String queryOneExam(){
        List resultList=examService.queryOneExam(examEntity);
        HttpServletRequest request=ServletActionContext.getRequest();
        request.setAttribute("examInfo",resultList);
        if (resultList.size()!=0)
            return SUCCESS;
        return ERROR;
    }
}
