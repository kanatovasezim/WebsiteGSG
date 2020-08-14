package kg.itacademy.gsg.controllers;

import kg.itacademy.gsg.entities.Comment;
import kg.itacademy.gsg.entities.User;
import kg.itacademy.gsg.models.CommentModel;
import kg.itacademy.gsg.models.NotificationModel;
import kg.itacademy.gsg.services.ClientTasksService;
import kg.itacademy.gsg.services.CommentService;
import kg.itacademy.gsg.services.NotificationService;
import kg.itacademy.gsg.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private ClientTasksService clientTasksService;

    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notificationService;

    private User user;

    @GetMapping(value = "/{id}/list")
    public String getCommentList(@PathVariable("id") Long id, Model model, Authentication authentication) {
        getUserInfo(authentication);

        List<CommentModel> comments = commentService.getAllCommentsByClientTask(id);
        List<NotificationModel> notificationList = notificationService.getAllNotificationsByUserId(user.getId());
        commentService.checkIsOpen(comments, user);
        List<NotificationModel> posterURL = new ArrayList<>();
        int count = 0;
        for (NotificationModel notif : notificationList) {
            if (notif.getPoster() != null && count < 3) {
                posterURL.add(notif);
                count++;
            }
        }
        model.addAttribute("posterURL", posterURL);
        String taskName = clientTasksService.getById(id).getTask().getTitle();
        model.addAttribute("comments", comments);
        List<CommentModel> commentList = commentService.getAllCommentsByRole(user.getId());
        model.addAttribute("commentList", commentList);
        model.addAttribute("taskId", id);
        model.addAttribute("taskName", taskName);
        model.addAttribute("notificationList", notificationList);
        model.addAttribute("user", user);
        return "admin/list_of_comments";
    }

    @PostMapping(value = "/{id}/create")
    public String addComment(@PathVariable("id") Long id, @Valid @ModelAttribute("comment") Comment comment, Authentication authentication) {
        getUserInfo(authentication);
        commentService.saveComment(comment, user, id);
        return "redirect:/comment/" + id + "/list";
    }

    @PostMapping(value = "/delete/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        commentService.deleteCommentById(id);
        return "redirect:/comment/list";
    }


    private void getUserInfo(Authentication authentication) {
        UserDetails userPrincipal = (UserDetails) authentication.getPrincipal();
        user = userService.findByEmail(userPrincipal.getUsername());
    }
}