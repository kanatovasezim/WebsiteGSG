package kg.itacademy.gsg.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "gsg_tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "title")
    String title;

    @Column(name = "description",columnDefinition = "text")
    String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    Category categoryId;

    @CreationTimestamp
    @Column(name = "created_date")
    Date createdDate;

    public Task(String title, String description,Category categoryId) {
        this.title = title;
        this.description = description;
        this.categoryId = categoryId;
    }
}
