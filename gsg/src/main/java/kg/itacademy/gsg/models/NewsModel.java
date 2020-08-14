package kg.itacademy.gsg.models;

import kg.itacademy.gsg.entities.User;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NewsModel {
    Long id;
    String title;
    User publisher;
    String message;
    List<String> to;
    String image;
    MultipartFile multipartFile;
}
