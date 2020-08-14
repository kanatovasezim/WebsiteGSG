package kg.itacademy.gsg.controllers;

import kg.itacademy.gsg.entities.Notification;
import kg.itacademy.gsg.entities.User;
import kg.itacademy.gsg.enums.Status;
import kg.itacademy.gsg.models.ClientTasksModel;
import kg.itacademy.gsg.models.CommentModel;
import kg.itacademy.gsg.models.NotificationModel;
import kg.itacademy.gsg.models.OrderModel;
import kg.itacademy.gsg.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private ClientTasksService clientTasksService;


    User user;

    @GetMapping(value = "/order/list")
    public String getClientsOrderList(@PageableDefault(5) Pageable pageable, Model model, Authentication authentication) {
        getUserInfo(authentication);
        Page<OrderModel> clientOrderList = orderService.findAllOrdersByClientId(user.getId(), pageable);

        List<NotificationModel> notificationList = notificationService.getAllNotificationsByUserId(user.getId());
        model.addAttribute("notificationList", notificationList);
        List<NotificationModel> posterURL = new ArrayList<>();
        int count = 0;
        for (NotificationModel notif : notificationList) {
            if (notif.getPoster() != null && count < 3) {
                posterURL.add(notif);
                count++;
            }
        }
        model.addAttribute("posterURL", posterURL);
        model.addAttribute("notificationList", notificationList);
        List<CommentModel> commentList = commentService.getAllCommentsByRole(user.getId());
        model.addAttribute("commentList", commentList);
        model.addAttribute("orderList", clientOrderList);
        model.addAttribute("user", user);
        return "admin/list_of_orders";
    }

    @PostMapping(value = "/{forPackage}/order/{id}/clientTasks/{clientTaskId}/changeStatus")
    public String changeClientTasksStatus(@PathVariable("forPackage") Long forPackage, @PathVariable("id") Long id, @PathVariable("clientTaskId") Long clientTaskId, @ModelAttribute("status") Status status, Authentication authentication) {
        getUserInfo(authentication);
        clientTasksService.changeClientTasksStatus(clientTaskId, status, user);
        if (forPackage == 0) {
            return "redirect:/client/";
        }
        return "redirect:/order/" + id + "/clientTasks";
    }

    @GetMapping(value = "/updateClientTask/{clientTaskId}")
    public String changeClientTask(Model model, @PathVariable("clientTaskId") Long clientTaskId, Authentication authentication) {
        getUserInfo(authentication);
        List<NotificationModel> notificationList = notificationService.getAllNotificationsByUserId(user.getId());
        ClientTasksModel clientTasks = clientTasksService.findClientTaskById(clientTaskId);
        List<NotificationModel> posterURL = new ArrayList<>();
        int count = 0;
        for (NotificationModel notif : notificationList) {
            if (notif.getPoster() != null && count < 3) {
                posterURL.add(notif);
                count++;
            }
        }
        model.addAttribute("posterURL", posterURL);
        model.addAttribute("notificationList", notificationList);
        model.addAttribute("clientTask", clientTasks);
        model.addAttribute("add", false);
        List<CommentModel> commentList = commentService.getAllCommentsByRole(user.getId());
        model.addAttribute("commentList", commentList);
        model.addAttribute("user", user);
        return "admin/clientTask_form";
    }

    @GetMapping(value = "/comment/list")
    public String getAllComments(Model model, Authentication authentication) {
        getUserInfo(authentication);
        List<CommentModel> comments = commentService.getAllCommentsByClientId(user.getId());
        List<NotificationModel> notificationList = notificationService.getAllNotificationsByUserId(user.getId());
        model.addAttribute("notificationList", notificationList);
        List<NotificationModel> posterURL = new ArrayList<>();
        int count = 0;
        for (NotificationModel notif : notificationList) {
            if (notif.getPoster() != null && count < 3) {
                posterURL.add(notif);
                count++;
            }
        }
        model.addAttribute("posterURL", posterURL);
        List<CommentModel> commentList = commentService.getAllCommentsByRole(user.getId());
        model.addAttribute("commentList", commentList);
        model.addAttribute("comments", comments);
        model.addAttribute("user", user);
        return "admin/list_of_comments";
    }

    @GetMapping(value = "/notification/list")
    public String getAllNotifications(@PageableDefault(6) Pageable pageable, Model model, Authentication authentication) {
        getUserInfo(authentication);
        Page<NotificationModel> notifications = notificationService.getAllNotificationsByUserId(user.getId(), pageable);
        List<NotificationModel> notificationList = notificationService.getAllNotificationsByUserId(user.getId());
        model.addAttribute("notificationList", notificationList);
        List<NotificationModel> posterURL = new ArrayList<>();
        int count = 0;
        for (NotificationModel notif : notificationList) {
            if (notif.getPoster() != null && count < 3) {
                posterURL.add(notif);
                count++;
            }
        }
        model.addAttribute("posterURL", posterURL);
        List<CommentModel> commentList = commentService.getAllCommentsByRole(user.getId());
        model.addAttribute("commentList", commentList);
        model.addAttribute("notifications", notifications);
        model.addAttribute("user", user);
        return "user/list_of_notifications";
    }

    @GetMapping("/notification/{id}")
    public String detailNotificationPage(@PathVariable("id") Long id, Model model, Authentication authentication) {
        getUserInfo(authentication);
        notificationService.isOpened(id);
        Notification notification = notificationService.getNotificationById(id);
        List<NotificationModel> notificationList = notificationService.getAllNotificationsByUserId(user.getId());
        List<NotificationModel> posterURL = new ArrayList<>();
        int count = 0;
        for (NotificationModel notif : notificationList) {
            if (notif.getPoster() != null && count < 3) {
                posterURL.add(notif);
                count++;
            }
        }
        model.addAttribute("notificationList", notificationList);
        model.addAttribute("posterURL", posterURL);
        List<CommentModel> commentList = commentService.getAllCommentsByRole(user.getId());
        model.addAttribute("commentList", commentList);
        model.addAttribute("user", user);
        model.addAttribute("notification", notification);
        return "user/notification_detail";
    }

    @GetMapping("/")
    public String clientPage(@RequestParam(value = "search", required = false) String status, @PageableDefault(6) Pageable pageable, Model model, Authentication authentication) {
        getUserInfo(authentication);
        Page<ClientTasksModel> clientTasksList = null;
        if (status == null || status.equals("Все")) {
            clientTasksList = clientTasksService.findAllClientTasksByClientId(user.getId(), pageable);
        } else if (Status.valueOf(status).equals(Status.INPROGRESS)) {
            clientTasksList = clientTasksService.findAllClientTasksByStatusManager(Status.INPROGRESS, user.getId(), pageable);
        } else if (Status.valueOf(status).equals(Status.DONE)) {
            clientTasksList = clientTasksService.findAllClientTasksByStatusManager(Status.DONE, user.getId(), pageable);
        } else if (Status.valueOf(status).equals(Status.TODO)) {
            clientTasksList = clientTasksService.findAllClientTasksByStatusManager(Status.TODO, user.getId(), pageable);
        } else if (Status.valueOf(status).equals(Status.ACCEPTED)) {
            clientTasksList = clientTasksService.findAllClientTasksByStatusManager(Status.ACCEPTED, user.getId(), pageable);
        } else if (Status.valueOf(status).equals(Status.DECLINED)) {
            clientTasksList = clientTasksService.findAllClientTasksByStatusManager(Status.DECLINED, user.getId(), pageable);
        }
        List<NotificationModel> notificationList = notificationService.getAllNotificationsByUserId(user.getId());
        List<NotificationModel> posterURL = new ArrayList<>();
        int count = 0;
        for (NotificationModel notif : notificationList) {
            if (notif.getPoster() != null && count < 3) {
                posterURL.add(notif);
                count++;
            }
        }
        model.addAttribute("posterURL", posterURL);
        model.addAttribute("notificationList", notificationList);
        List<CommentModel> commentList = commentService.getAllCommentsByRole(user.getId());
        model.addAttribute("commentList", commentList);
        model.addAttribute("user", user);
        model.addAttribute("taskModels", clientTasksList);
        model.addAttribute("commentService", commentService);
        return "user/client";
    }

    private void getUserInfo(Authentication authentication) {
        UserDetails userPrincipal = (UserDetails) authentication.getPrincipal();
        user = userService.findByEmail(userPrincipal.getUsername());
    }
}