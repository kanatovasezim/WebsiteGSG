package kg.itacademy.gsg.controllers;

import kg.itacademy.gsg.entities.User;
import kg.itacademy.gsg.entities.UserRole;
import kg.itacademy.gsg.models.CommentModel;
import kg.itacademy.gsg.models.NotificationModel;
import kg.itacademy.gsg.models.SomeFile;
import kg.itacademy.gsg.models.UserModel;
import kg.itacademy.gsg.services.CommentService;
import kg.itacademy.gsg.services.NotificationService;
import kg.itacademy.gsg.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@Secured({"ROLE_ADMIN", "ROLE_MANAGER"})
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    NotificationService notificationService;
    @Autowired
    CommentService commentService;
    User user;

    @GetMapping(value = "/list")
    public String getUserListForAdmin(@RequestParam(value = "search", required = false) String userRole, @PageableDefault(5) Pageable pageable, Model model, Authentication authentication) {
        getUserInfo(authentication);
        Page<UserModel> userList;
        List<NotificationModel> notificationList = notificationService.getAllNotificationsByUserId(user.getId());
        if (userRole == null || userRole.equals("Все")) {
            userList = userService.findAll(pageable);
        } else {
            userList = userService.getByRole(userRole, pageable);
        }
        List<CommentModel> commentList = commentService.getAllCommentsByRole(user.getId());
        model.addAttribute("commentList", commentList);
        model.addAttribute("user", user);
        model.addAttribute("userList", userList);
        model.addAttribute("notificationList", notificationList);
        return "admin/list_of_users";
    }

    @GetMapping(value = "/form")
    public String getCreateUserForm(Model model, Authentication authentication) {
        getUserInfo(authentication);
        List<NotificationModel> notificationList = notificationService.getAllNotificationsByUserId(user.getId());
        List<CommentModel> commentList = commentService.getAllCommentsByRole(user.getId());
        model.addAttribute("commentList", commentList);
        model.addAttribute("notificationList", notificationList);
        model.addAttribute("add", true);
        model.addAttribute("user", user);
        return "admin/user_form";
    }


    @GetMapping(value = "/{id}")
    public String editUserProfile(@PathVariable("id") Long id, Model model, Authentication authentication) {
        getUserInfo(authentication);
        User userProfile = userService.getUserById(id);
        List<NotificationModel> notificationList = notificationService.getAllNotificationsByUserId(user.getId());
        List<CommentModel> commentList = commentService.getAllCommentsByRole(user.getId());
        model.addAttribute("commentList", commentList);
        model.addAttribute("notificationList", notificationList);
        model.addAttribute("add", false);
        model.addAttribute("userProfile", userProfile);
        model.addAttribute("user", user);
        return "admin/user_form";
    }

    @Secured({"ROLE_ADMIN", "ROLE_MANAGER", "ROLE_USER"})
    @GetMapping(value = "/profile/{id}")
    public String userProfile(@PathVariable("id") Long id, Model model, Authentication authentication) {
        getUserInfo(authentication);
        User user1 = userService.getUserById(id);
        if (user.getRole().getRoleName().equals("ROLE_USER"))
            user1 = userService.getUserById(user.getId());
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
        List<CommentModel> commentList = commentService.getAllCommentsByRole(user.getId());
        model.addAttribute("commentList", commentList);
        model.addAttribute("notificationList", notificationList);
        model.addAttribute("user", user);
        model.addAttribute("user1", user1);
        return "user/userProfile";
    }

    @PostMapping(value = "/create")
    public String addUser(@Valid @ModelAttribute("somefile") SomeFile someFile, @Valid @ModelAttribute("user") UserModel userModel, @Valid @ModelAttribute("userRole") UserRole userRole) throws IOException {
        userModel.setRole(userRole);
        userModel.setMultipartFile(someFile.getDocs());
        userService.saveUser(userModel);
        return "redirect:/user/list";
    }

    @PostMapping(value = "/update/{id}")
    public String updateUser(@Valid @ModelAttribute("somefile") SomeFile someFile, @Valid @ModelAttribute("user") UserModel userModel, @PathVariable("id") Long id) {
        userModel.setId(id);
        userModel.setMultipartFile(someFile.getDocs());
        userService.updateUser(userModel);
        return "redirect:/user/list";
    }

    @PostMapping(value = "/delete/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/user/list";
    }

    private void getUserInfo(Authentication authentication) {
        UserDetails userPrincipal = (UserDetails) authentication.getPrincipal();
        user = userService.findByEmail(userPrincipal.getUsername());
    }
}