package kg.itacademy.gsg.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "gsg_users")

public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "image")
    String image;

    @Column(name = "email", nullable = false, unique = true)
    String email;

    @Column(name = "password", nullable = false)
    String password;

    @Column(name = "first_name", nullable = false)
    String firstName;

    @Column(name = "last_name", nullable = false)
    String lastName;

    @Column(name = "patronymic")
    String patronymic;

    @Column(name = "position")
    String position;

    @Column(name = "phone_number")
    String phoneNumber;

    @Column(name = "company_name")
    String companyName;

    @Column(name = "company_occupation")
    String companyOccupation;

    @Column(name = "website")
    URL website;

    @Column(name = "address")
    String address;

    @Column(name = "source")
    String source;

    @Column(name = "is_active")
    Boolean isActive;

    @CreationTimestamp
    @Column(name = "created_date")
    Date createdDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    UserRole role;

    public String getCreatedDateWithoutZeros() {
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return formatter.format(createdDate);
    }
}