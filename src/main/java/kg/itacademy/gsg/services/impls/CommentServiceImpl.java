package kg.itacademy.gsg.services.impls;

import kg.itacademy.gsg.entities.Comment;
import kg.itacademy.gsg.entities.User;
import kg.itacademy.gsg.exceptions.RecordNotFoundException;
import kg.itacademy.gsg.models.CommentModel;
import kg.itacademy.gsg.repositories.CommentRepository;
import kg.itacademy.gsg.services.ClientTasksService;
import kg.itacademy.gsg.services.CommentService;
import kg.itacademy.gsg.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ClientTasksService clientTasksService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public List<CommentModel> getAllCommentsByRole(Long id) {
        User user = userService.getUserById(id);
        List<CommentModel> commentList = new ArrayList<>();
        switch (user.getRole().getRoleName()) {
            case "ROLE_MANAGER":
                commentList = commentService.getAllCommentsByManagerId(user.getId());
                break;
            case "ROLE_USER":
                commentList = commentService.getAllCommentsByClientId(user.getId());
                break;
        }
        return commentList;
    }

    @Override
    public List<CommentModel> getAllCommentsByClientId(Long id) {
        return commentRepository.getAllCommentsByClientId(id);
    }

    @Override
    public List<CommentModel> getAllCommentsByManagerId(Long id) {
        return commentRepository.getAllCommentsByManagerId(id);
    }

    @Override
    public List<CommentModel> getAllCommentsByClientTask(Long taskId) {
        return commentRepository.getAllCommentsByClientTask(taskId);
    }

    @Override
    public Comment getCommentById(Long id) {
        Optional<Comment> comment = commentRepository.findById(id);
        return comment.orElse(new Comment());
    }

    @Override
    public void updateComment(Long id, Comment comment) {
    }

    @Override
    public void saveComment(Comment comment, User user, Long clientTaskId) {
        comment.setUser(user);
        comment.setClientTask(clientTasksService.getById(clientTaskId));
        comment.setIsOpen(Boolean.FALSE);
        commentRepository.save(comment);
    }

    @Override
    public void saveComment(CommentModel commentModel) {
        Comment comment = new Comment();
        comment.setClientTask(commentModel.getClientTask());
        comment.setUser(commentModel.getUser());
        comment.setCommentText(commentModel.getCommentText());
        comment.setIsOpen(Boolean.FALSE);
        commentRepository.save(comment);
    }

    @Override
    public void deleteCommentById(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public Comment isOpened(Long id) {
        return commentRepository.findById(id)
                .map(comment -> {
                    comment.setIsOpen(Boolean.TRUE);
                    return commentRepository.save(comment);
                })
                .orElseThrow(() -> new RecordNotFoundException("Comment not found with id:" + id));
    }

    @Override
    public Integer getAllCommentsCount(Long taskId, Long userId) {
        return commentRepository.getCommentsCount(taskId, userId);
    }

    @Override
    public Integer getCommentsCountByClientId(Long clientId) {
        return commentRepository.getCommentsCountByClientId(clientId);
    }

    @Override
    public Integer getCommentsCountByManagerId(Long managerId) {
        return commentRepository.getCommentsCountByManagerId(managerId);
    }

    @Override
    public void checkIsOpen(List<CommentModel> commentModelList, User user) {
        for (CommentModel comModel : commentModelList) {
            if (!user.getRole().getRoleName().equals("ROLE_ADMIN") && !comModel.getUser().getEmail().equals(user.getEmail()) && comModel.getIsOpen().equals(Boolean.FALSE)) {
                isOpened(comModel.getId());
            }
        }
    }

    @Override
    public void deleteCommentByClientTasks(Long id) {
        commentRepository.deleteCommentByClientTask(id);
    }
}
