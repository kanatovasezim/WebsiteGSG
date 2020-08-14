package kg.itacademy.gsg.controllers;

import kg.itacademy.gsg.entities.Notification;
import kg.itacademy.gsg.entities.User;
import kg.itacademy.gsg.models.NewsModel;
import kg.itacademy.gsg.models.NotificationModel;
import kg.itacademy.gsg.models.UserModel;
import kg.itacademy.gsg.services.NotificationService;
import kg.itacademy.gsg.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/notification")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @Autowired
    private UserService userService;

    User user;

    @ModelAttribute("news")
    public NewsModel newNewsModel() {
        return new NewsModel();
    }

    @GetMapping(value = "/list")
    public String getNotificationList(@PageableDefault(5) Pageable pageable, Model model, Authentication authentication) {
        getUserInfo(authentication);
        Page<NotificationModel> notifications = notificationService.getAllNotificationsByUserId(user.getId(), pageable);
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
        model.addAttribute("notifications", notifications);
        model.addAttribute("user", user);
        model.addAttribute("notificationList", notificationList);
        return "user/list_of_notifications";
    }

    @GetMapping(value = "/{id}")
    public String notificationInfo(@PathVariable("id") Long id, Model model, Authentication authentication) {
        getUserInfo(authentication);
        Notification notification = notificationService.getNotificationById(id);
        notificationService.isOpened(id);
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
        model.addAttribute("user", user);
        model.addAttribute("notification", notification);
        return "user/notification_detail";
    }

    @GetMapping(value = "/news/form")
    public String newsPage(Model model, Authentication authentication) {
        getUserInfo(authentication);
        List<UserModel> userList = userService.getByUserRole("ROLE_USER");
        List<NotificationModel> notificationList = notificationService.getAllNotificationsByUserId(user.getId());
        model.addAttribute("notificationList", notificationList);
        model.addAttribute("user", user);
        model.addAttribute("userList", userList);
        return "admin/latestNews_form";
    }

    @PostMapping(value = "/sendUsers")
    public String addNews(@Valid @ModelAttribute("news") NewsModel newsModel) {
        if (newsModel.getTo() != null && newsModel.getTitle() != null && newsModel.getMessage() != null) {
            newsModel.setPublisher(user);
            notificationService.sendNotification(newsModel);
        }
        return "redirect:/notification/news/form";
    }

    @PostMapping(value = "/create")
    public String addNotification(@Valid @ModelAttribute("notification") Notification notification) {
        notificationService.saveNotification(notification);
        return "redirect:/notification/list";
    }

    @PostMapping(value = "/delete/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        notificationService.deleteNotificationById(id);
        return "redirect:/notification/list";
    }

    private void getUserInfo(Authentication authentication) {
        UserDetails userPrincipal = (UserDetails) authentication.getPrincipal();
        user = userService.findByEmail(userPrincipal.getUsername());
    }
}