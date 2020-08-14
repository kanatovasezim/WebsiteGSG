package kg.itacademy.gsg.services.impls;

import kg.itacademy.gsg.entities.Notification;
import kg.itacademy.gsg.exceptions.RecordNotFoundException;
import kg.itacademy.gsg.models.ClientTasksModel;
import kg.itacademy.gsg.models.NewsModel;
import kg.itacademy.gsg.models.NotificationModel;
import kg.itacademy.gsg.repositories.NotificationRepository;
import kg.itacademy.gsg.services.MailSenderService;
import kg.itacademy.gsg.services.MediaFileService;
import kg.itacademy.gsg.services.NotificationService;
import kg.itacademy.gsg.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    private UserService userService;
    @Autowired
    private MediaFileService mediaFileService;
    @Autowired
    private MailSenderService mailSenderService;

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    @Override
    public Notification getNotificationById(Long id) {
        Optional<Notification> notification = notificationRepository.findById(id);
        return notification.orElse(new Notification());
    }

    @Override
    public void updateNotification(Long id, NotificationModel notificationModel) {

    }


    @Override
    public Notification saveNotification(Notification notification) {
        notification.setIsOpen(Boolean.FALSE);
        return notificationRepository.save(notification);
    }

    @Override
    public void deleteNotificationById(Long id) {
        notificationRepository.deleteById(id);
    }

    @Override
    public Notification isOpened(Long id) {
        return notificationRepository.findById(id)
                .map(notification -> {
                    notification.setIsOpen(Boolean.TRUE);
                    return notificationRepository.save(notification);
                })
                .orElseThrow(() -> new RecordNotFoundException("Notification not found with id:" + id));
    }

    @Override
    public Integer getNotificationsCount(Long userId) {
        return notificationRepository.getNotificationsCount(userId);
    }

    @Override
    public void deleteNotificationByUser(Long id) {
        notificationRepository.deleteNotificationByUser(id);
    }

    @Override
    public Page<NotificationModel> getAllNotificationsByUserId(Long id, Pageable pageable) {
        return notificationRepository.getAllNotificationsByUserId(id, pageable);
    }

    @Override
    public List<NotificationModel> getAllNotificationsByUserId(Long id) {
        return notificationRepository.getAllNotificationsByUserId(id);
    }

    @Override
    public void sendNotification(NewsModel newsModel) {
        for (String user : newsModel.getTo()) {
            if (newsModel.getMultipartFile() != null) {
                newsModel.setImage("/posters/" + mediaFileService.saveMediaNotification(newsModel));
            }
            saveNotification(Notification.builder()
                    .category("Пост-уведомления")
                    .userTo(userService.findByEmail(user))
                    .message(newsModel.getMessage())
                    .poster(newsModel.getImage())
                    .title(newsModel.getTitle())
                    .userFrom(newsModel.getPublisher())
                    .build());
        }
        mailSenderService.sendForAny(newsModel.getTo(), newsModel.getTitle(), newsModel.getMessage());
    }

    @Override
    public void sendDeadlineNotification(ClientTasksModel clientTasksModel) {
        new Notification();
        String message;
        switch (clientTasksModel.getDaysLeft()) {
            case (0):
                message = "Сегодня дедлайн задачи: " + clientTasksModel.getTask().getTitle();
                break;
            case (1):
                message = "Остался 1 день до дедлайна задачи: " + clientTasksModel.getTask().getTitle();
                break;
            default:
                message = "Осталось " + clientTasksModel.getDaysLeft() + " дня до дедлайна задачи: " + clientTasksModel.getTask().getTitle();
                break;
        }
        saveNotification(Notification.builder()
                .category("Дедлайн-уведомления")
                .userTo(clientTasksModel.getManager())
                .message(message)
                .title("Дедлайн заказа: " + clientTasksModel.getOrder().getTitle())
                .userFrom(clientTasksModel.getManager())
                .build());
        List<String> emails = new ArrayList<>();
        emails.add(clientTasksModel.getManager().getEmail());
        mailSenderService.sendForAny(emails, "Дедлайн заказа: " + clientTasksModel.getOrder().getTitle(), message);
    }
}
