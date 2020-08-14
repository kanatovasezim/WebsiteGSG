package kg.itacademy.gsg.services;

import kg.itacademy.gsg.entities.User;
import kg.itacademy.gsg.models.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User getUserById(Long id);

    User updateUser(UserModel userModel);

    User saveUser(UserModel userModel);

    void deleteUserById(Long id);

    User findByEmail(String email);

    Page<UserModel> findAll(Pageable pageable);

    Page<UserModel> getByRole(String name, Pageable pageable);

    List<UserModel> getByUserRole(String name);

    List<String> getEmailsOfActiveClients();

    List<String> getEmailsOfNonActiveClients();

    List<String> getEmailsByUserRole(String name);

    Page<UserModel> findAllForManager(Pageable pageable);

    Integer getLoggedInUsers();

    Integer getLoggedInEmployees();

    UserModel getByUserRoleAndEmail(String name, String email);

    List<String> getDayOfWeek();

    List<Integer> getUserCountByDOW();

    Integer getUserTotalCountByWeek();
}