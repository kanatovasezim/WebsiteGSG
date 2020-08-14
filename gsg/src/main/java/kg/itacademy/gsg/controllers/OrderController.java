package kg.itacademy.gsg.controllers;

import kg.itacademy.gsg.entities.Order;
import kg.itacademy.gsg.entities.User;
import kg.itacademy.gsg.enums.Status;
import kg.itacademy.gsg.models.*;
import kg.itacademy.gsg.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private PackageService packageService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private ClientTasksService clientTasksService;

    @Autowired
    private NotificationService notificationService;

    User user;

    @Secured({"ROLE_ADMIN", "ROLE_MANAGER"})
    @GetMapping(value = "/list")
    public String getOrderList(@RequestParam(value = "search", required = false) String search, @Param("dateFrom") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFrom, @Param("dateTo") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateTo, @PageableDefault(3) Pageable pageable, Model model, Authentication authentication) {
        getUserInfo(authentication);
        Page<OrderModel> orderList;
        List<NotificationModel> notificationList = notificationService.getAllNotificationsByUserId(user.getId());
        if (search != null) {
            orderList = orderService.findAllOrdersByName(search.toLowerCase(), pageable);
        } else if (dateFrom != null && dateTo != null) {
            orderList = orderService.findAllOrdersByDate(dateFrom, dateTo, pageable);
        } else {
            orderList = orderService.findAll(pageable,user);
        }
        List<CommentModel> commentList = commentService.getAllCommentsByRole(user.getId());
        model.addAttribute("commentList", commentList);
        model.addAttribute("user", user);
        model.addAttribute("notificationList", notificationList);
        model.addAttribute("orderList", orderList);
        return "admin/list_of_orders";
    }

    @GetMapping(value = "/{id}")
    public String orderInfo(@PathVariable("id") Long id, Model model, Authentication authentication) {
        getUserInfo(authentication);
        Order o = orderService.getOrderById(id);
        List<NotificationModel> notificationList = notificationService.getAllNotificationsByUserId(user.getId());
        model.addAttribute("notificationList", notificationList);
        List<CommentModel> commentList = commentService.getAllCommentsByRole(user.getId());
        model.addAttribute("commentList", commentList);
        model.addAttribute("user", user);
        model.addAttribute("add", true);
        model.addAttribute("order", o);
        return "admin/order_form";
    }

    @GetMapping(value = "/{id}/clientTasks")
    public String getClientTasks(@PathVariable("id") Long id, @PageableDefault(6) Pageable pageable, Model model, Authentication authentication) {
        getUserInfo(authentication);
        Order o = orderService.getOrderById(id);
        Page<ClientTasksModel> clientTasksModels = clientTasksService.findAllClientTasksByOrderId(id, pageable);
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
        List<CommentModel> commentList = commentService.getAllCommentsByRole(user.getId());
        model.addAttribute("commentList", commentList);
        model.addAttribute("user", user);
        model.addAttribute("orderId", id);
        model.addAttribute("add", true);
        model.addAttribute("status", Status.values());
        model.addAttribute("order", o);
        model.addAttribute("taskModels", clientTasksModels);
        model.addAttribute("commentService", commentService);
        return "admin/list_of_clientTask";
    }

    @GetMapping(value = "/form")
    public String getCreateOrderForm(Model model, Authentication authentication) {
        getUserInfo(authentication);
        List<UserModel> userList = userService.getByUserRole("ROLE_USER");
        List<PackageModel> packageList = packageService.getAll();
        List<NotificationModel> notificationList = notificationService.getAllNotificationsByUserId(user.getId());
        model.addAttribute("notificationList", notificationList);
        List<CommentModel> commentList = commentService.getAllCommentsByRole(user.getId());
        model.addAttribute("commentList", commentList);
        model.addAttribute("user", user);
        model.addAttribute("userList", userList);
        model.addAttribute("packageList", packageList);
        model.addAttribute("add", true);
        return "admin/order_form";
    }

    @PostMapping(value = "/create")
    public String addOrder(@Valid @ModelAttribute("order") OrderCreationModel orderCreationModel) {
        orderCreationModel.setManagerId(user.getId());
        orderService.saveOrder(orderCreationModel);
        return "redirect:/order/list";
    }

    @PostMapping(value = "/update/{id}")
    public String updateOrder(@Valid @ModelAttribute("order") OrderModel orderModel, @PathVariable("id") Long id) {
        orderModel.setId(id);
        orderService.updateOrder(orderModel);
        return "redirect:/order/list";
    }

    @PostMapping(value = "/delete/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        orderService.deleteOrderById(id);
        return "redirect:/order/list";
    }

    private void getUserInfo(Authentication authentication) {
        UserDetails userPrincipal = (UserDetails) authentication.getPrincipal();
        user = userService.findByEmail(userPrincipal.getUsername());
    }
}
