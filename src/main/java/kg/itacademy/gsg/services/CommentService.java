package kg.itacademy.gsg.services;

import kg.itacademy.gsg.entities.Comment;
import kg.itacademy.gsg.entities.User;
import kg.itacademy.gsg.models.CommentModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import java.util.List;

public interface CommentService {
    List<Comment> getAllComments();

    List<CommentModel> getAllCommentsByRole(Long id);

    List<CommentModel> getAllCommentsByClientId(Long id);

    List<CommentModel> getAllCommentsByManagerId(Long id);

    List<CommentModel> getAllCommentsByClientTask(Long taskId);

    Comment getCommentById(Long id);

    void updateComment(Long id, Comment comment);

    void saveComment(Comment comment, User user, Long clientTaskId);

    void saveComment(CommentModel commentModel);

    void checkIsOpen(List<CommentModel> commentModel, User user);

    void deleteCommentById(Long id);

    Comment isOpened(Long id);

    Integer getAllCommentsCount(Long id, Long userId);

    Integer getCommentsCountByClientId( Long clientId);

    Integer getCommentsCountByManagerId(Long managerId);

    void deleteCommentByClientTasks(Long id);
}