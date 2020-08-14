package kg.itacademy.gsg.models;

import kg.itacademy.gsg.entities.Category;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskModel {
    Long id;
    String title;
    String description;
    Category categoryId;
    Date createdDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date deadline;

    public TaskModel(Long id, String title, String description, Category categoryId, Date createdDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.categoryId = categoryId;
        this.createdDate = createdDate;
    }
}
