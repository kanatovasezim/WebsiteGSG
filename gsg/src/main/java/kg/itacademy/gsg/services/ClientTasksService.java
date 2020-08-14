package kg.itacademy.gsg.services;

import kg.itacademy.gsg.entities.ClientTasks;
import kg.itacademy.gsg.entities.User;
import kg.itacademy.gsg.enums.Status;
import kg.itacademy.gsg.models.ClientTasksModel;
import kg.itacademy.gsg.models.TaskModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClientTasksService {
    List<ClientTasksModel> getAll();

    ClientTasks getById(Long id);

    Page<ClientTasksModel> findAllClientTasksByClientId(Long id, Pageable pageable);

    ClientTasks updateClientTask(ClientTasksModel clientTasksModel);

    ClientTasks save(ClientTasksModel clientTasksModel);

    ClientTasks save(ClientTasks clientTasks);

    Page<ClientTasksModel> findAllClientTasksByOrderId(Long id, Pageable pageable);

    List<ClientTasksModel> findAllClientTasksByOrder(Long id);

    Page<ClientTasksModel> findAllClientTasksByStatusManager(Status status, Long userId, Pageable pageable);

    ClientTasks changeClientTasksStatus(Long id, Status status, User user);

    ClientTasksModel findClientTaskById(Long id);

    void deleteById(Long id);

    void deleteClientTasksInOrder(Long id);

    ClientTasks saveClientTaskInOrder(Long orderId, TaskModel taskModel);

}
