package kg.itacademy.gsg.services;

import kg.itacademy.gsg.entities.Notification;
import kg.itacademy.gsg.models.ClientTasksModel;
import kg.itacademy.gsg.models.NewsModel;
import kg.itacademy.gsg.models.NotificationModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NotificationService {
    List<Notification> getAllNotifications();

    Notification getNotificationById(Long id);

    void updateNotification(Long id, NotificationModel notificationModel);

    void sendNotification(NewsModel newsModel);

    void sendDeadlineNotification(ClientTasksModel clientTasksModel);

    Notification saveNotification(Notification notification);

    void deleteNotificationById(Long id);

    Notification isOpened(Long id);

    Integer getNotificationsCount(Long userId);

    void deleteNotificationByUser( Long id);

    Page<NotificationModel> getAllNotificationsByUserId(Long id, Pageable pageable);

    List<NotificationModel> getAllNotificationsByUserId(Long id);

//    List<NewsModel> getNews();

//    Integer getLeftDays (ClientTasksModel clientTasksModel);
}
