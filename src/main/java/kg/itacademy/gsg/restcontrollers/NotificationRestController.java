package kg.itacademy.gsg.restcontrollers;

import kg.itacademy.gsg.entities.User;
import kg.itacademy.gsg.models.NotificationCountModel;
import kg.itacademy.gsg.services.NotificationService;
import kg.itacademy.gsg.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/notification")
public class NotificationRestController {
    @Autowired
    private NotificationService notificationService;

    @Autowired
    private UserService userService;

    User user;

    @GetMapping(value = "/count")
    public NotificationCountModel getNotificationsCount(Authentication authentication) {
        getUserInfo(authentication);
        return new NotificationCountModel(notificationService.getNotificationsCount(user.getId()));
    }

    private void getUserInfo(Authentication authentication) {
        UserDetails userPrincipal = (UserDetails) authentication.getPrincipal();
        user = userService.findByEmail(userPrincipal.getUsername());
    }
}
