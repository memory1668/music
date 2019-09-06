package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import service.INoticeService;
import vo.NoticeEntity;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class NoticeAction extends ActionSupport {
    private NoticeEntity noticeEntity;
    private INoticeService noticeService;

    public NoticeEntity getNoticeEntity() {
        return noticeEntity;
    }

    public void setNoticeEntity(NoticeEntity noticeEntity) {
        this.noticeEntity = noticeEntity;
    }

    public INoticeService getNoticeService() {
        return noticeService;
    }

    public void setNoticeService(INoticeService noticeService) {
        this.noticeService = noticeService;
    }

    /**
     * ��������
     */
    public String addNotice(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");//�������ڸ�ʽ
        noticeEntity.setPublishesTime(df.format(new Date()));//��ȡ��ǰ����
        if (noticeService.addNotice(noticeEntity))
            return SUCCESS;
        return ERROR;

    }

    /**
     * ɾ������
     */
    public String removeNotice(){
        if (noticeService.removeNotice(noticeEntity))
            return SUCCESS;
        return ERROR;
    }

    /**
     * ��ѯȫ��
     */
    public String queryAllNotice(){
        NoticeEntity noticeEntity=new NoticeEntity();
        List reslutList=noticeService.queryAllNotice(noticeEntity);


            HttpServletRequest request= ServletActionContext.getRequest();
            request.setAttribute("notice",reslutList);
            return SUCCESS;

    }

    /**
     * ��ѯ�����������
     */
    public String queryNoticeAbout(){
        List reslutList=noticeService.queryNoticeAbout(noticeEntity);
//        Map<String, Object> session = ActionContext.getContext().getSession();
//        session.put("noticeAbout",reslutList);
        if (reslutList.size()>0){
            HttpServletRequest request=ServletActionContext.getRequest();
            request.setAttribute("noticeAbout",reslutList);
        }
        return SUCCESS;
    }
}
