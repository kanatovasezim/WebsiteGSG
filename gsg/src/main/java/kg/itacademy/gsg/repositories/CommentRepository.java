package kg.itacademy.gsg.repositories;

import kg.itacademy.gsg.entities.Comment;
import kg.itacademy.gsg.models.CommentModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("select new kg.itacademy.gsg.models.CommentModel(c.id,c.commentText,c.user,c.clientTask,c.createdDate,c.isOpen) FROM Comment c join ClientTasks ct on ct.id = c.clientTask.id where ct.client.id = :id order by c.id asc")
    List<CommentModel> getAllCommentsByClientId(Long id);

    @Query("select new kg.itacademy.gsg.models.CommentModel(c.id,c.commentText,c.user,c.clientTask,c.createdDate,c.isOpen) FROM Comment c join ClientTasks ct on ct.id = c.clientTask.id where ct.manager.id = :id order by c.id asc")
    List<CommentModel> getAllCommentsByManagerId(Long id);

    @Query("select new kg.itacademy.gsg.models.CommentModel(c.id,c.commentText,c.user,c.clientTask,c.createdDate,c.isOpen) FROM Comment c join ClientTasks ct on ct.id = c.clientTask.id where ct.id = :taskId order by c.id asc")
    List<CommentModel> getAllCommentsByClientTask(@Param("taskId") Long taskId);

//    @Query(value = "select count(*) from gsg_comments where client_task = :taskId", nativeQuery = true)
//    Integer getAllCommentsCount(@Param("taskId") Long taskId);

    @Query(value = "select count(*) from gsg_comments join gsg_client_tasks on gsg_comments.client_task = gsg_client_tasks.id where gsg_client_tasks.client_id = :clientId", nativeQuery = true)
    Integer getCommentsCountByClientId(@Param("clientId") Long clientId);

    @Query(value = "select count(*) from gsg_comments join gsg_client_tasks on gsg_comments.client_task = gsg_client_tasks.id where gsg_client_tasks.manager_id = :managerId", nativeQuery = true)
    Integer getCommentsCountByManagerId(@Param("managerId") Long managerId);

    @Query(value = "select count(*) from gsg_comments where is_open = false and client_task = :taskId and user_id != :userId", nativeQuery = true)
    Integer getCommentsCount(@Param("taskId") Long taskId, @Param("userId") Long userId);

    @Modifying
    @Transactional
    @Query(value = "delete FROM gsg_comments WHERE  client_task =:ct_id", nativeQuery = true)
    void deleteCommentByClientTask(@Param("ct_id") Long id);
}
