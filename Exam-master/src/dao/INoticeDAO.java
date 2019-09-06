package dao;

import vo.NoticeEntity;

import java.util.List;

public interface INoticeDAO {
//    ��������
    boolean addNotice(NoticeEntity noticeEntity);

//    ɾ������
    boolean removeNotice(NoticeEntity noticeEntity);

//    ��ѯȫ��
    List queryAllNotice(NoticeEntity noticeEntity);

//    ��ѯ�����������
    List queryNoticeAbout(NoticeEntity noticeEntity);
}
