package kg.itacademy.gsg.models;
import kg.itacademy.gsg.entities.User;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NotificationModel {
    Long id;
    String title;
    String category;
    String message;
    String poster;
    User userFrom;
    User userTo;
    Date createdDate;
    Boolean isOpen;

    public String getCreatedDateWithoutZeros() {
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return formatter.format(createdDate);
    }
}
