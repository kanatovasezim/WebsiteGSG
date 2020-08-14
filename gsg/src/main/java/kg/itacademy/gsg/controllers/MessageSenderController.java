package kg.itacademy.gsg.controllers;

import kg.itacademy.gsg.entities.Mail;
import kg.itacademy.gsg.entities.User;
import kg.itacademy.gsg.models.CommentModel;
import kg.itacademy.gsg.models.NotificationModel;
import kg.itacademy.gsg.models.UserModel;
import kg.itacademy.gsg.services.CommentService;
import kg.itacademy.gsg.services.MailSenderService;
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
@RequestMapping("/mail")
public class MessageSenderController {
    @Autowired
    MailSenderService mailSenderService;
    @Autowired
    UserService userService;
    @Autowired
    NotificationService notificationService;
    @Autowired
    CommentService commentService;

    User user;

    @ModelAttribute("mail")
    public Mail newMail() {
        return new Mail();
    }


    @GetMapping("/users")
    public String showMailSenderPageUser(@RequestParam(value = "userMail", required = false) String userMail, Model model, Authentication authentication, @PageableDefault(5) Pageable pageable) {
        getUserInfo(authentication);
        List<NotificationModel> notificationList = notificationService.getAllNotificationsByUserId(user.getId());
        if (userMail != null && !userMail.equals("")) {
            List<User> userList = new ArrayList<>();
            userList.add(userService.findByEmail(userMail));
            model.addAttribute("userList", userList);
        } else {
            List<UserModel> userList = userService.getByUserRole("ROLE_USER");
            model.addAttribute("userList", userList);
        }
        List<CommentModel> commentList = commentService.getAllCommentsByRole(user.getId());
        model.addAttribute("commentList", commentList);
        model.addAttribute("user", user);
        model.addAttribute("notificationList", notificationList);
        return "admin/mail_form";
    }


    @PostMapping("/sendMailUser/{mail}")
    public String sendEmailUser(@PathVariable("mail") String mail, @ModelAttribute("mail") Mail m) {
        System.out.println(m.getActive());
        System.out.println(m.getNonActive());
        if(m.getMessage() != null && mail != null){
            ArrayList<String> mails = new ArrayList<>();
            mails.add(mail);
            m.setTo(mails);
            mailSenderService.sendForAny(m.getTo(), m.getSubject(), m.getMessage());
        }
        return "redirect:/";
    }

    @PostMapping("/sendMailUser")
    public String sendEmailUser(@ModelAttribute("mail") Mail m) {
        System.out.println(m.getActive());
        System.out.println(m.getNonActive());
        if (m.getMessage() != null) {
            mailSenderService.sendForAll(m);
        }
        return "redirect:/";
    }

    private void getUserInfo(Authentication authentication) {
        UserDetails userPrincipal = (UserDetails) authentication.getPrincipal();
        user = userService.findByEmail(userPrincipal.getUsername());
    }
}
