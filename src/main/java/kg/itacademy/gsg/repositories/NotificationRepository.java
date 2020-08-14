package kg.itacademy.gsg.repositories;

import kg.itacademy.gsg.entities.Notification;
import kg.itacademy.gsg.models.NotificationModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification,Long> {
    @Query("select new kg.itacademy.gsg.models.NotificationModel(n.id,n.title,n.category,n.message,n.poster,n.userFrom,n.userTo,n.createdDate,n.isOpen) FROM Notification n where n.userTo.id = :id order by n.createdDate desc ")
    Page<NotificationModel> getAllNotificationsByUserId(Long id, Pageable pageable);

    @Query("select new kg.itacademy.gsg.models.NotificationModel(n.id,n.title,n.category,n.message,n.poster,n.userFrom,n.userTo,n.createdDate,n.isOpen) FROM Notification n where n.userTo.id = :id order by n.createdDate desc ")
    List<NotificationModel> getAllNotificationsByUserId(Long id);


    @Query(value = "select count(*) from gsg_notifications where is_open = false and user_to = :user_id", nativeQuery = true)
    Integer getNotificationsCount(@Param("user_id") Long user_id);

    @Modifying
    @Transactional
    @Query(value = "delete FROM gsg_notifications WHERE user_to = :user_id", nativeQuery = true)
    void deleteNotificationByUser(@Param("user_id") Long user_id);

    List<Notification> findAllByCreatedDateLessThanEqualAndCreatedDateGreaterThanEqual(Date toDate, Date fromDate);
}
