package kg.itacademy.gsg.restcontrollers;

import kg.itacademy.gsg.entities.User;
import kg.itacademy.gsg.models.CommentCountModel;
import kg.itacademy.gsg.models.CommentModel;
import kg.itacademy.gsg.services.impls.CommentServiceImpl;
import kg.itacademy.gsg.services.impls.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/comment")
public class CommentRestController {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private CommentServiceImpl commentService;

    @GetMapping(value = "{id}/count")
    public CommentCountModel getCommentsCount(@PathVariable("id") Long id, Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return new CommentCountModel(commentService.getAllCommentsCount(id, userService.findByEmail(userDetails.getUsername()).getId()));
    }

    @GetMapping(value = "{id}/countByRole")
    public CommentCountModel getCommentsCountByRole(@PathVariable("id") Long id,Authentication authentication) {
       int count=0;
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User user = userService.findByEmail(userDetails.getUsername());
        if (user.getRole().getRoleName().equals("ROLE_MANAGER"))
            for (CommentModel c: commentService.getAllCommentsByManagerId(user.getId())) {
                if (!c.getIsOpen()&& c.getUser()!=user)
                    count++;
            }
        else
            for (CommentModel c: commentService.getAllCommentsByClientId(user.getId())) {
                if (!c.getIsOpen()&& c.getUser()!=user)
                    count++;
            }
        return new CommentCountModel(count);
    }
}
