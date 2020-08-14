package kg.itacademy.gsg.models;

import kg.itacademy.gsg.entities.Order;
import kg.itacademy.gsg.entities.Task;
import kg.itacademy.gsg.entities.User;
import kg.itacademy.gsg.enums.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClientTasksModel {
    Long id;
    User client;
    User manager;
    Order order;
    Task task;
    Status statusManager;
    Status statusClient;
    Date createdDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date deadline;
    Integer daysLeft;


    public ClientTasksModel(Long id) {
        this.id = id;
    }

    public ClientTasksModel(Date deadline) {
        this.deadline = deadline;
    }

    public ClientTasksModel(Long id, Date deadline) {
        this.id = id;
        this.deadline = deadline;
    }

    public String getDeadlineWithoutZeros() {
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return formatter.format(deadline);
    }

    public Integer getDaysLeft() {
        Period period;
        if(this.deadline!=null){
        LocalDate now = LocalDate.now();
        Date clientTasksDeadline= this.deadline;
        LocalDate date = clientTasksDeadline.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        period = Period.between(now, date);}
        else {
            return -1;
        }
        return period.getDays();
    }

    public ClientTasksModel(Long id, User client, User manager, Order order, Task task, Status statusManager, Status statusClient, Date createdDate, Date deadline) {
        this.id = id;
        this.client = client;
        this.manager = manager;
        this.order = order;
        this.task = task;
        this.statusManager = statusManager;
        this.statusClient = statusClient;
        this.createdDate = createdDate;
        this.deadline = deadline;
    }
}