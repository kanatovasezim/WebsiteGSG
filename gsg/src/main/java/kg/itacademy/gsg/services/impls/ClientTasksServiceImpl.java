package kg.itacademy.gsg.services.impls;

import kg.itacademy.gsg.entities.*;
import kg.itacademy.gsg.enums.Status;
import kg.itacademy.gsg.exceptions.RecordNotFoundException;
import kg.itacademy.gsg.models.ClientTasksModel;
import kg.itacademy.gsg.models.TaskModel;
import kg.itacademy.gsg.repositories.ClientTasksRepository;
import kg.itacademy.gsg.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientTasksServiceImpl implements ClientTasksService {

    @Autowired
    ClientTasksRepository clientTasksRepository;

    @Autowired
    NotificationService notificationService;

    @Autowired
    OrderService orderService;

    @Autowired
    TaskService taskService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    CommentService commentService;

    @Autowired
    MailSenderService mailSenderService;

    @Override
    public List<ClientTasksModel> getAll() {
        return clientTasksRepository.findAllClientTasks();
    }

    @Override
    public ClientTasks getById(Long id) {
        Optional<ClientTasks> clientTasks = clientTasksRepository.findById(id);
        return clientTasks.orElse(new ClientTasks());
    }

    @Override
    public ClientTasks updateClientTask(ClientTasksModel clientTasksModel) {
        return clientTasksRepository.findById(clientTasksModel.getId())
                .map(newClientTaskModel -> {
                    if (clientTasksModel.getDaysLeft() >= 1)
                        newClientTaskModel.setDeadline(clientTasksModel.getDeadline());
                    return clientTasksRepository.save(newClientTaskModel);
                })
                .orElseThrow(() -> new RecordNotFoundException("Task not found with id:" + clientTasksModel.getId()));
    }


    @Override
    public ClientTasks save(ClientTasksModel clientTasksModel) {
        ClientTasks clientTasks = new ClientTasks();
        clientTasks.setTask(clientTasksModel.getTask());
        clientTasks.setClient(clientTasksModel.getClient());
        clientTasks.setOrder(clientTasksModel.getOrder());
        clientTasks.setManager(clientTasksModel.getManager());
        clientTasks.setStatusManager(Status.TODO);
        clientTasks.setStatusClient(Status.DECLINED);
        clientTasks.setDeadline(clientTasksModel.getDeadline());
        return save(clientTasks);
    }

    @Override
    public ClientTasks save(ClientTasks clientTasks) {
        return clientTasksRepository.save(clientTasks);
    }

    @Override
    public Page<ClientTasksModel> findAllClientTasksByOrderId(Long id, Pageable pageable) {
        return clientTasksRepository.findAllClientTasksByOrder(id, pageable);
    }

    @Override
    public Page<ClientTasksModel> findAllClientTasksByClientId(Long id, Pageable pageable) {
        return clientTasksRepository.findAllClientTasksByClientId(id, pageable);
    }

    @Override
    public List<ClientTasksModel> findAllClientTasksByOrder(Long id) {
        return clientTasksRepository.findAllClientTasksByOrder(id);
    }

    @Override
    public Page<ClientTasksModel> findAllClientTasksByStatusManager(Status status, Long clientId, Pageable pageable) {
        return clientTasksRepository.findAllClientTasksByStatusManager(status, clientId, pageable);
    }

    @Override
    public ClientTasks changeClientTasksStatus(Long id, Status status, User user) {
        return clientTasksRepository.findById(id)
                .map(newClientTaskModel -> {
                    if (user.getRole().getRoleName().equals("ROLE_MANAGER") || user.getRole().getRoleName().equals("ROLE_ADMIN")) {
                        newClientTaskModel.setStatusManager(status);
                        if (status.equals(Status.DONE)) {
                            Notification notification = new Notification();
                            notification.setTitle(newClientTaskModel.getTask().getTitle());
                            if (newClientTaskModel.getTask().getCategoryId() != null) {
                                notification.setCategory(newClientTaskModel.getTask().getCategoryId().getTitle());
                            }
                            notification.setMessage("Ваша задача " + newClientTaskModel.getTask().getTitle() + " выполнена");
                            notification.setIsOpen(Boolean.FALSE);
                            notification.setUserTo(newClientTaskModel.getClient());
                            notification.setUserFrom(user);
                            notificationService.saveNotification(notification);
                            List<String> emails = new ArrayList<>();
                            emails.add(newClientTaskModel.getClient().getEmail());
                            mailSenderService.sendForAny(emails, "Статус задачи : " + newClientTaskModel.getOrder().getTitle() + "был изменен", "Ваша задача " + newClientTaskModel.getTask().getTitle() + " выполнена");
                        }
                    } else {
                        newClientTaskModel.setStatusClient(status);
                        if (newClientTaskModel.getStatusClient().equals(Status.DECLINED)) {
                            newClientTaskModel.setStatusManager(Status.INPROGRESS);
                        } else {
                            Notification notification = new Notification();
                            notification.setTitle(newClientTaskModel.getTask().getTitle());
                            if (newClientTaskModel.getTask().getCategoryId() != null) {
                                notification.setCategory(newClientTaskModel.getTask().getCategoryId().getTitle());
                            }
                            notification.setMessage("Ваша задача " + newClientTaskModel.getTask().getTitle() + " одобрена");
                            notification.setIsOpen(Boolean.FALSE);
                            notification.setUserFrom(user);
                            notification.setUserTo(newClientTaskModel.getManager());
                            notificationService.saveNotification(notification);
                        }
                    }
                    return clientTasksRepository.save(newClientTaskModel);
                })
                .orElseThrow(() -> new RecordNotFoundException("Task not found with id:" + id));
    }

    @Override
    public ClientTasksModel findClientTaskById(Long id) {
        return clientTasksRepository.findClientTaskById(id);
    }

    @Override
    public void deleteById(Long id) {
        commentService.deleteCommentByClientTasks(id);
        clientTasksRepository.deleteById(id);
    }

    @Override
    public void deleteClientTasksInOrder(Long id) {
        clientTasksRepository.deleteClientTasksInOrder(id);
    }

    @Override
    public ClientTasks saveClientTaskInOrder(Long orderId, TaskModel taskModel) {
        Order order = orderService.getOrderById(orderId);
        if (taskModel.getCategoryId() == null) {
            taskModel.setCategoryId(categoryService.getCategoryByName("Экстра"));
        }
        Task task = taskService.saveTask(taskModel);
        ClientTasks clientTasks = new ClientTasks();
        clientTasks.setTask(task);
        clientTasks.setClient(order.getClientId());
        clientTasks.setManager(order.getManagerId());
        clientTasks.setStatusManager(Status.TODO);
        clientTasks.setStatusClient(Status.DECLINED);
        clientTasks.setOrder(order);
        clientTasks.setDeadline(taskModel.getDeadline());
        return clientTasksRepository.save(clientTasks);
    }
}