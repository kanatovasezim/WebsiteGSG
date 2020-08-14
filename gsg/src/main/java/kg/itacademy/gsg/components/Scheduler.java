package kg.itacademy.gsg.components;
import kg.itacademy.gsg.models.ClientTasksModel;
import kg.itacademy.gsg.services.ClientTasksService;
import kg.itacademy.gsg.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {
    @Autowired
    private ClientTasksService clientTasksService;
    @Autowired
    private NotificationService notificationService;

    @Scheduled(cron = "0 8 * * * ?")
    public void cronJobSch() {
        for (ClientTasksModel ct :clientTasksService.getAll()) {
            if (ct.getDaysLeft()<=2 && ct.getDaysLeft()>=0){
               notificationService.sendDeadlineNotification(ct);
            }
        }
    }
}