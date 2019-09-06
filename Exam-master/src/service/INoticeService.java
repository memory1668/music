package service;

import dao.INoticeDAO;
import vo.NoticeEntity;

import java.util.List;

public interface INoticeService {
    //    ��������
    boolean addNotice(NoticeEntity noticeEntity);

    //    ɾ������
    boolean removeNotice(NoticeEntity noticeEntity);

    //    ��ѯȫ��
    List queryAllNotice(NoticeEntity noticeEntity);

    //    ��ѯ�����������
    List queryNoticeAbout(NoticeEntity noticeEntity);
}
