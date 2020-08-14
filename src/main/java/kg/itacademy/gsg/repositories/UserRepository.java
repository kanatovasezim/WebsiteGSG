package kg.itacademy.gsg.repositories;

import kg.itacademy.gsg.entities.User;
import kg.itacademy.gsg.models.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    @Query("select new kg.itacademy.gsg.models.UserModel(user.id,user.image,user.email,user.password,user.firstName,user.lastName,user.patronymic,user.position,user.phoneNumber,user.companyName,user.companyOccupation,user.website,user.address,user.source,user.isActive,user.createdDate,user.role) from User user join UserRole r on user.role.id = r.id where r.roleName = :name")
    Page<UserModel> getByRole(@Param("name") String name, Pageable pageable);

    @Query("select user.email from User user join UserRole r on user.role.id = r.id where r.roleName = :name")
    List<String> getEmailsByUserRole(@Param("name") String name);

    @Query("select user.email from User user join UserRole r on user.role.id = r.id where r.roleName = 'ROLE_USER' and user.isActive = 'true'")
    List<String> getEmailsOfActiveClients();

    @Query("select user.email from User user join UserRole r on user.role.id = r.id where r.roleName = 'ROLE_USER' and user.isActive = 'false'")
    List<String> getEmailsOfNonActiveClients();

    @Query("select new kg.itacademy.gsg.models.UserModel(user.id,user.image,user.email,user.password,user.firstName,user.lastName,user.patronymic,user.position,user.phoneNumber,user.companyName,user.companyOccupation,user.website,user.address,user.source,user.isActive,user.createdDate,user.role) from User user join UserRole r on user.role.id = r.id where r.roleName = :name")
    List<UserModel> getByUserRole(@Param("name") String name);

    @Query("select new kg.itacademy.gsg.models.UserModel(user.id,user.image,user.email,user.password,user.firstName,user.lastName,user.patronymic,user.position,user.phoneNumber,user.companyName,user.companyOccupation,user.website,user.address,user.source,user.isActive,user.createdDate,user.role) from User user join UserRole r on user.role.id = r.id where r.roleName = :name and user.email= :email")
    UserModel getByUserRoleAndEmail(@Param("name") String name, @Param("email") String email);

    @Query("select new kg.itacademy.gsg.models.UserModel(user.id,user.image,user.email,user.password,user.firstName,user.lastName,user.patronymic,user.position,user.phoneNumber,user.companyName,user.companyOccupation,user.website,user.address,user.source,user.isActive,user.createdDate,user.role) FROM User user ORDER BY user.firstName ASC")
    Page<UserModel> findAllUsersWithPagination(Pageable pageable);

    @Query("select new kg.itacademy.gsg.models.UserModel(user.id,user.image,user.email,user.password,user.firstName,user.lastName,user.patronymic,user.position,user.phoneNumber,user.companyName,user.companyOccupation,user.website,user.address,user.source,user.isActive,user.createdDate,user.role) FROM User user ORDER BY user.firstName ASC")
    List<UserModel> findAllUsers();

    @Query("select new kg.itacademy.gsg.models.UserModel(user.id,user.image,user.email,user.password,user.firstName,user.lastName,user.patronymic,user.position,user.phoneNumber,user.companyName,user.companyOccupation,user.website,user.address,user.source,user.isActive,user.createdDate,user.role) from User user join UserRole r on user.role.id = r.id where r.roleName = 'ROLE_USER'")
    Page<UserModel> findAllForManager(Pageable pageable);


}
