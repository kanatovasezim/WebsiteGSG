package kg.itacademy.gsg.controllers;

import kg.itacademy.gsg.entities.Category;
import kg.itacademy.gsg.entities.User;
import kg.itacademy.gsg.models.CategoryModel;
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
import java.util.List;

@Controller
@Secured({"ROLE_ADMIN", "ROLE_MANAGER"})
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private NotificationService notificationService;

    User user;

    @GetMapping(value = "/list")
    public String getCategoryList(@PageableDefault(5) Pageable pageable, Model model, Authentication authentication) {
        getUserInfo(authentication);
        Page<CategoryModel> categoryList = categoryService.findAll(pageable);
        List<NotificationModel> notificationList = notificationService.getAllNotificationsByUserId(user.getId());
        model.addAttribute("categoryList", categoryList);
        List<CommentModel> commentList = commentService.getAllCommentsByRole(user.getId());
        model.addAttribute("commentList", commentList);
        model.addAttribute("user", user);
        model.addAttribute("notificationList", notificationList);
        return "admin/list_of_categories";
    }

    @GetMapping(value = "/{id}/task/list")
    public String getTaskListByCatId(@PathVariable("id") Long id, @PageableDefault(6) Pageable pageable, Model model, Authentication authentication) {
        getUserInfo(authentication);
        Page<TaskModel> taskList = taskService.findAllByCategoryId(id, pageable);
        List<NotificationModel> notificationList = notificationService.getAllNotificationsByUserId(user.getId());
        model.addAttribute("taskList", taskList);
        List<CommentModel> commentList = commentService.getAllCommentsByRole(user.getId());
        model.addAttribute("commentList", commentList);
        model.addAttribute("user", user);
        model.addAttribute("notificationList", notificationList);
        return "admin/list_of_tasks";
    }

    @GetMapping(value = "/{id}")
    public String categoryInfo(@PathVariable("id") Long id, Model model, Authentication authentication) {
        getUserInfo(authentication);
        Category category = categoryService.getCategoryById(id);
        List<NotificationModel> notificationList = notificationService.getAllNotificationsByUserId(user.getId());
        model.addAttribute("category", category);
        model.addAttribute("add", false);
        List<CommentModel> commentList = commentService.getAllCommentsByRole(user.getId());
        model.addAttribute("commentList", commentList);
        model.addAttribute("user", user);
        model.addAttribute("notificationList", notificationList);
        return "admin/category_form";
    }

    @GetMapping(value = "/form/{packageId}")
    public String getCategoryCreateForm(@PathVariable("packageId") Long packageId, Model model, Authentication authentication) {
        getUserInfo(authentication);
        List<NotificationModel> notificationList = notificationService.getAllNotificationsByUserId(user.getId());
        model.addAttribute("notificationList", notificationList);
        model.addAttribute("packageId", packageId);
        model.addAttribute("add", true);
        List<CommentModel> commentList = commentService.getAllCommentsByRole(user.getId());
        model.addAttribute("commentList", commentList);
        model.addAttribute("user", user);
        return "admin/category_form";
    }

    @PostMapping(value = "/create/{packageId}")
    public String addCategory(@Valid @ModelAttribute("category") CategoryModel categoryModel, @PathVariable("packageId") Long packageId) {
        categoryModel.setPackageId(packageId);
        categoryService.saveCategory(categoryModel);
        return "redirect:/package/" + packageId + "/category/list";
    }

    @PostMapping(value = "/update/{id}")
    public String updateCategory(@Valid @ModelAttribute("package") CategoryModel categoryModel, @PathVariable("id") Long id) {
        categoryModel.setId(id);
        Category category = categoryService.updateCategory(categoryModel);
        return "redirect:/package/" + category.getPackageId().getId() + "/category/list";
    }

    @PostMapping(value = "/update/{id}/{packageId}")
    public String updateCategory(@PathVariable("packageId") Long packageId, @Valid @ModelAttribute("package") CategoryModel categoryModel, @PathVariable("id") Long id) {
        categoryModel.setId(id);
        categoryService.updateCategory(categoryModel);
        return "redirect:/package/" + packageId + "/category/list";
    }

    @PostMapping(value = "/delete/{id}/{packageId}")
    public String deleteById(@PathVariable("id") Long id, @PathVariable("packageId") Long packageId) {
        categoryService.deleteCategoryByPackageId(id);
        return "redirect:/package/" + packageId + "/category/list";
    }

    @PostMapping(value = "/delete/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        categoryService.deleteCategoryById(id);
        return "redirect:/category/list";
    }

    private void getUserInfo(Authentication authentication) {
        UserDetails userPrincipal = (UserDetails) authentication.getPrincipal();
        user = userService.findByEmail(userPrincipal.getUsername());
    }
}