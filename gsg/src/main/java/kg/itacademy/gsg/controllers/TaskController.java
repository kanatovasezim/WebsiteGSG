package kg.itacademy.gsg.controllers;

import kg.itacademy.gsg.entities.ClientTasks;
import kg.itacademy.gsg.entities.Task;
import kg.itacademy.gsg.entities.User;
import kg.itacademy.gsg.models.ClientTasksModel;
import kg.itacademy.gsg.models.CommentModel;
import kg.itacademy.gsg.models.NotificationModel;
import kg.itacademy.gsg.models.TaskModel;
import kg.itacademy.gsg.services.*;
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
import java.util.ArrayList;
import java.util.List;

@Controller
@Secured({"ROLE_ADMIN", "ROLE_MANAGER"})
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private ClientTasksService clientTasksService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private NotificationService notificationService;

    User user;


    @GetMapping(value = "/list")
    public String getTaskList(@PageableDefault(6) Pageable pageable, Model model, Authentication authentication) {
        getUserInfo(authentication);
        Page<TaskModel> taskList = taskService.findAll(pageable);
        List<NotificationModel> notificationList = notificationService.getAllNotificationsByUserId(user.getId());
        List<CommentModel> commentList = commentService.getAllCommentsByRole(user.getId());
        model.addAttribute("commentList", commentList);
        model.addAttribute("taskList", taskList);
        model.addAttribute("user", user);
        model.addAttribute("notificationList", notificationList);
        return "admin/list_of_tasks";
    }

    @GetMapping(value = "/{id}")
    public String taskInfo(@PathVariable("id") Long id, Model model, Authentication authentication) {
        getUserInfo(authentication);
        Task task = taskService.getTaskById(id);
        List<NotificationModel> notificationList = notificationService.getAllNotificationsByUserId(user.getId());
        model.addAttribute("notificationList", notificationList);
        model.addAttribute("task", task);
        model.addAttribute("add", false);
        List<CommentModel> commentList = commentService.getAllCommentsByRole(user.getId());
        model.addAttribute("commentList", commentList);
        model.addAttribute("user", user);
        return "admin/task_form";
    }

    @Secured({"ROLE_ADMIN", "ROLE_MANAGER","ROLE_USER"})
    @GetMapping(value = "/form/{orderId}")
    public String getCreateTaskForm(@PathVariable("orderId") Long orderId, Model model, Authentication authentication) {
        getUserInfo(authentication);
        List<NotificationModel> notificationList = notificationService.getAllNotificationsByUserId(user.getId());
        model.addAttribute("notificationList", notificationList);
        model.addAttribute("orderId", orderId);
        model.addAttribute("add", true);
        List<CommentModel> commentList = commentService.getAllCommentsByRole(user.getId());
        model.addAttribute("commentList", commentList);
        model.addAttribute("user", user);
        return "admin/task_form";
    }

    @GetMapping(value = "/form/{packageId}/{catId}")
    public String getCreateTaskForm(@PathVariable("packageId") Long packageId, @PathVariable("catId") Long catId, Model model, Authentication authentication) {
        getUserInfo(authentication);
        List<NotificationModel> notificationList = notificationService.getAllNotificationsByUserId(user.getId());
        List<NotificationModel> posterURL = new ArrayList<>();
        int count = 0;
        for (NotificationModel notif: notificationList ) {
            if (notif.getPoster()!=null && count<3){
                posterURL.add(notif);
                count++;
            }
        }
        model.addAttribute("posterURL", posterURL);
        model.addAttribute("notificationList", notificationList);
        model.addAttribute("packageId", packageId);
        model.addAttribute("catId", catId);
        model.addAttribute("add", true);
        List<CommentModel> commentList = commentService.getAllCommentsByRole(user.getId());
        model.addAttribute("commentList", commentList);
        model.addAttribute("user", user);
        return "admin/task_form";
    }

    @PostMapping(value = "/create/{packageId}/{catId}")
    public String addTask(@PathVariable("packageId") Long packageId, @PathVariable("catId") Long catId, @Valid @ModelAttribute("task") TaskModel taskModel) {
        taskModel.setCategoryId(categoryService.getCategoryById(catId));
        taskService.saveTask(taskModel);
        return "redirect:/package/" + packageId + "/category/" + catId + "/task/list";
    }

    @Secured({"ROLE_ADMIN", "ROLE_MANAGER","ROLE_USER"})
    @PostMapping(value = "/create/{orderId}")
    public String addTask(@PathVariable("orderId") Long orderId, @Valid @ModelAttribute("task") TaskModel taskModel) {
        clientTasksService.saveClientTaskInOrder(orderId, taskModel);
        return "redirect:/order/" + orderId + "/clientTasks";
    }

    @PostMapping(value = "/update/{id}")
    public String updateTask(@Valid @ModelAttribute("task") TaskModel taskModel, @PathVariable("id") Long id) {
        taskModel.setId(id);
        taskService.updateTask(taskModel);
        return "redirect:/task/list";
    }

    @PostMapping(value = "/update/{id}/{packageId}/{catId}")
    public String updateTask(@PathVariable("packageId") Long packageId, @PathVariable("catId") Long catId, @Valid @ModelAttribute("task") TaskModel taskModel, @PathVariable("id") Long id) {
        taskModel.setId(id);
        taskService.updateTask(taskModel);
        return "redirect:/package/" + packageId + "/category/" + catId + "/task/list";
    }

    @PostMapping(value = "/updateClientTask/{id}")
    public String updateClientTask(@PathVariable("id") Long id, @Valid @ModelAttribute("clientTask") ClientTasksModel clientTasksModel) {
        clientTasksModel.setId(id);
        ClientTasks clientTasks = clientTasksService.updateClientTask(clientTasksModel);
        return "redirect:/order/" + clientTasks.getOrder().getId() + "/clientTasks";
    }

    @PostMapping(value = "/delete/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        taskService.deleteTaskById(id);
        return "redirect:/task/list";
    }

    @PostMapping(value = "{id}/delete/clientTask")
    public String deleteByClientTaskId(@PathVariable("id") Long id) {
        Long orderId = clientTasksService.getById(id).getOrder().getId();
        clientTasksService.deleteById(id);
        return "redirect:/order/" + orderId + "/clientTasks";
    }


    @PostMapping(value = "/delete/{id}/{packageId}/{catId}")
    public String deleteById(@PathVariable("packageId") Long packageId, @PathVariable("catId") Long catId, @PathVariable("id") Long id) {
        taskService.deleteTaskById(id);
        return "redirect:/package/" + packageId + "/category/" + catId + "/task/list";
    }

    private void getUserInfo(Authentication authentication) {
        UserDetails userPrincipal = (UserDetails) authentication.getPrincipal();
        user = userService.findByEmail(userPrincipal.getUsername());
    }
}
