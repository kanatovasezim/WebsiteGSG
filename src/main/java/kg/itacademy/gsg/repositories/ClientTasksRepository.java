package kg.itacademy.gsg.repositories;

import kg.itacademy.gsg.entities.ClientTasks;
import kg.itacademy.gsg.enums.Status;
import kg.itacademy.gsg.models.ClientTasksModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ClientTasksRepository extends JpaRepository<ClientTasks, Long> {
    @Query("select new kg.itacademy.gsg.models.ClientTasksModel(c.id,c.client,c.manager,c.order,c.task,c.statusManager,c.statusClient,c.createdDate,c.deadline) FROM ClientTasks c")
    List<ClientTasksModel> findAllClientTasks();

    @Query("select new kg.itacademy.gsg.models.ClientTasksModel(c.id,c.client,c.manager,c.order,c.task,c.statusManager,c.statusClient,c.createdDate,c.deadline) FROM ClientTasks c where c.id = :id")
    ClientTasksModel findClientTaskById(@Param("id") Long id);

    @Query("select new kg.itacademy.gsg.models.ClientTasksModel(c.id,c.client,c.manager,c.order,c.task,c.statusManager,c.statusClient,c.createdDate,c.deadline) FROM ClientTasks c where c.statusManager = :status and c.client.id=:client ORDER BY c.id DESC")
    Page<ClientTasksModel> findAllClientTasksByStatusManager(@Param("status") Status status, @Param("client") Long userId, Pageable pageable);

    @Query("select new kg.itacademy.gsg.models.ClientTasksModel(c.id,c.client,c.manager,c.order,c.task,c.statusManager,c.statusClient,c.createdDate,c.deadline) FROM ClientTasks c where c.order.id = :id ORDER BY c.id DESC")
    Page<ClientTasksModel> findAllClientTasksByOrder(@Param("id") Long id, Pageable pageable);

    @Query("select new kg.itacademy.gsg.models.ClientTasksModel(c.id) FROM ClientTasks c where c.order.id = :id ORDER BY c.id DESC")
    List<ClientTasksModel> findAllClientTasksByOrder(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "delete FROM gsg_client_tasks WHERE  order_id=:order_id", nativeQuery = true)
    void deleteClientTasksInOrder(@Param("order_id") Long id);

    @Query("select new kg.itacademy.gsg.models.ClientTasksModel(c.id,c.client,c.manager,c.order,c.task,c.statusManager,c.statusClient,c.createdDate,c.deadline) FROM ClientTasks c where c.client.id = :id ORDER BY c.id DESC")
    Page<ClientTasksModel> findAllClientTasksByClientId(@Param("id") Long id, Pageable pageable);
}