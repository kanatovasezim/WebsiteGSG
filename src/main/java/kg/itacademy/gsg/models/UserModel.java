package kg.itacademy.gsg.models;

import kg.itacademy.gsg.entities.User;
import kg.itacademy.gsg.entities.UserRole;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserModel{
    Long id;
    String image;
    String email;
    String password;
    String firstName;
    String lastName;
    String patronymic;
    String position;
    String phoneNumber;
    String companyName;
    String companyOccupation;
    URL website;
    String address;
    String source;
    Boolean isActive;
    Date createdDate;
    UserRole role;
    MultipartFile multipartFile;

    public String getCreatedDateWithoutZeros() {
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return formatter.format(createdDate);
    }

    public UserModel(Long id, String image, String email, String password, String firstName, String lastName, String patronymic, String position, String phoneNumber, String companyName, String companyOccupation, URL website, String address, String source, Boolean isActive, Date createdDate, UserRole role) {
        this.id = id;
        this.image = image;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.position = position;
        this.phoneNumber = phoneNumber;
        this.companyName = companyName;
        this.companyOccupation = companyOccupation;
        this.website = website;
        this.address = address;
        this.source = source;
        this.isActive = isActive;
        this.createdDate = createdDate;
        this.role = role;
    }

    public UserModel(Long id, String image, String email, String password, String firstName, String lastName, UserRole role) {
        this.id = id;
        this.image = image;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }
}