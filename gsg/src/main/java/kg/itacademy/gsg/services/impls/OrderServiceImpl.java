package kg.itacademy.gsg.services.impls;

import kg.itacademy.gsg.entities.*;
import kg.itacademy.gsg.entities.Package;
import kg.itacademy.gsg.enums.Status;
import kg.itacademy.gsg.exceptions.RecordNotFoundException;
import kg.itacademy.gsg.models.*;
import kg.itacademy.gsg.repositories.OrderRepository;
import kg.itacademy.gsg.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    UserService userService;

    @Autowired
    PackageService packageService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    TaskService taskService;

    @Autowired
    ClientTasksService clientTasksService;

    @Autowired
    CommentService commentService;

    @Autowired
    NotificationService notificationService;

    @Autowired
    MediaFileService mediaFileService;

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        Optional<Order> p = orderRepository.findById(id);
        return p.orElse(new Order());
    }

    @Override
    public Page<OrderModel> findAll(Pageable pageable, User user) {
        Page<OrderModel> orderModelPageable;
        if (user.getRole().getRoleName().equals("ROLE_MANAGER"))
            orderModelPageable = orderRepository.findAllOrdersByManagerId(user.getId(), pageable);
        else
            orderModelPageable = orderRepository.findAllOrdersWithPagination(pageable);
        return orderModelPageable;
    }

    @Override
    public Order updateOrder(OrderModel orderModel) {
        return orderRepository.findById(orderModel.getId())
                .map(newOrder -> {
                    newOrder.setTitle(orderModel.getTitle());
                    newOrder.setClientId(orderModel.getClientId());
                    newOrder.setManagerId(orderModel.getManagerId());
                    newOrder.setPackageId(orderModel.getPackageId());
                    return orderRepository.save(newOrder);
                })
                .orElseThrow(() -> new RecordNotFoundException("Order not found with id:" + orderModel.getId()));
    }

    @Override
    public Order saveOrder(OrderCreationModel orderCreationModel) {
        Order newOrder = new Order();
        Package pFromDB = packageService.getPackageById(orderCreationModel.getPackageId());
        User user = userService.getUserById(orderCreationModel.getClientId());
        User manager = userService.getUserById(orderCreationModel.getManagerId());
        newOrder.setPackageId(pFromDB);
        newOrder.setClientId(user);
        newOrder.setManagerId(userService.getUserById(orderCreationModel.getManagerId()));
        newOrder.setTitle(orderCreationModel.getTitle());
        List<CategoryModel> categoryModelList = categoryService.getAllByPackageId(pFromDB.getId());
        Order orderSave = orderRepository.save(newOrder);
        for (CategoryModel catModel : categoryModelList) {
            List<Task> taskList = taskService.findAllTasksByCatId(catModel.getId());
            for (Task task : taskList) {
                ClientTasks clientTasks = new ClientTasks();
                clientTasks.setClient(user);
                clientTasks.setTask(task);
                clientTasks.setManager(manager);
                clientTasks.setOrder(orderSave);
                clientTasks.setStatusManager(Status.TODO);
                clientTasks.setStatusClient(Status.DECLINED);
                clientTasksService.save(clientTasks);
            }
        }
        return orderSave;
    }

    @Override
    public void deleteOrderById(Long orderId) {
        for (ClientTasksModel c : clientTasksService.findAllClientTasksByOrder(orderId)) {
            commentService.deleteCommentByClientTasks(c.getId());
            mediaFileService.deleteMediaFileByClientTask(c.getId());
            clientTasksService.deleteById(c.getId());
        }
        orderRepository.deleteByOrderId(orderId);
    }

    @Override
    public Page<OrderModel> findAllOrdersByClientId(Long id, Pageable pageable) {
        return orderRepository.findAllOrdersByClientId(id, pageable);
    }

    @Override
    public Page<OrderModel> findAllOrdersByManagerId(Long id, Pageable pageable) {
        return orderRepository.findAllOrdersByManagerId(id, pageable);
    }

    @Override
    public Page<OrderModel> findAllOrdersByName(String toLowerCase, Pageable pageable) {
        return orderRepository.findAllOrdersByName(toLowerCase, pageable);
    }

    @Override
    public Page<OrderModel> findAllOrdersByDate(Date dateFrom, Date dateTo, Pageable pageable) {
        return orderRepository.findAllOrdersByDate(dateFrom, dateTo, pageable);
    }
}
