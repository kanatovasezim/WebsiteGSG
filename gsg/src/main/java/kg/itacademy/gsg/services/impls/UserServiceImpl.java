package kg.itacademy.gsg.services.impls;

import kg.itacademy.gsg.entities.User;
import kg.itacademy.gsg.entities.UserRole;
import kg.itacademy.gsg.exceptions.RecordNotFoundException;
import kg.itacademy.gsg.models.UserModel;
import kg.itacademy.gsg.repositories.NotificationRepository;
import kg.itacademy.gsg.repositories.UserRepository;
import kg.itacademy.gsg.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    SessionRegistry sessionRegistry;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Page<UserModel> findAll(Pageable pageable) {
        return userRepository.findAllUsersWithPagination(pageable);
    }

    @Override
    public Page<UserModel> getByRole(String name, Pageable pageable) {
        return userRepository.getByRole(name, pageable);
    }

    @Override
    public UserModel getByUserRoleAndEmail(String name, String email) {
        return userRepository.getByUserRoleAndEmail(name, email);
    }

    @Override
    public List<UserModel> getByUserRole(String name) {
        return userRepository.getByUserRole(name);
    }

    @Override
    public List<String> getEmailsOfActiveClients() {
        return userRepository.getEmailsOfActiveClients();
    }

    @Override
    public List<String> getEmailsOfNonActiveClients() {
        return userRepository.getEmailsOfNonActiveClients();
    }

    @Override
    public List<String> getEmailsByUserRole(String name) {
        return userRepository.getEmailsByUserRole(name);
    }

    @Override
    public Page<UserModel> findAllForManager(Pageable pageable) {
        return userRepository.findAllForManager(pageable);
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(new User());
    }

    @Override
    public User updateUser(UserModel userModel) {
        FileOutputStream out;
        String modifiedTitle =System.currentTimeMillis() + userModel.getMultipartFile().getOriginalFilename();
        String filePath = "D://images/" + modifiedTitle;
        if(userModel.getMultipartFile() != null){
            try {
                out = new FileOutputStream(filePath);
                out.write(userModel.getMultipartFile().getBytes());
                out.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return userRepository.findById(userModel.getId())
                .map(newUser -> {
                    if(userModel.getMultipartFile() != null)
                        newUser.setImage(modifiedTitle);
                    newUser.setFirstName(userModel.getFirstName());
                    newUser.setLastName(userModel.getLastName());
                    newUser.setPatronymic(userModel.getPatronymic());
                    newUser.setEmail(userModel.getEmail());
                    newUser.setPosition(userModel.getPosition());
                    newUser.setPhoneNumber(userModel.getPhoneNumber());
                    newUser.setCompanyName(userModel.getCompanyName());
                    newUser.setCompanyOccupation(userModel.getCompanyOccupation());
                    newUser.setWebsite(userModel.getWebsite());
                    newUser.setAddress(userModel.getAddress());
                    newUser.setSource(userModel.getSource());
                    newUser.setIsActive(userModel.getIsActive());
                    if (userModel.getPassword() != null && userModel.getPassword().length() >=5)
                        newUser.setPassword(passwordEncoder.encode(userModel.getPassword()));

                    return userRepository.save(newUser);
                })
                .orElseThrow(() ->
                        new RecordNotFoundException("User not found with id:" + userModel.getId()));
    }

    @Override
    public User saveUser(UserModel userModel) {
        FileOutputStream out;
        String modifiedTitle = System.currentTimeMillis() + userModel.getMultipartFile().getOriginalFilename();
        String filePath = "D://images/" + modifiedTitle;
        try {
            out = new FileOutputStream(filePath);
            out.write(userModel.getMultipartFile().getBytes());
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        User user = new User();
        user.setImage(modifiedTitle);
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setPatronymic(userModel.getPatronymic());
        user.setEmail(userModel.getEmail());
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));
        user.setPosition(userModel.getPosition());
        user.setPhoneNumber(userModel.getPhoneNumber());
        user.setCompanyName(userModel.getCompanyName());
        user.setCompanyOccupation(userModel.getCompanyOccupation());
        user.setWebsite(userModel.getWebsite());
        user.setAddress(userModel.getAddress());
        user.setSource(userModel.getSource());
        user.setIsActive(Boolean.TRUE);
        if (userModel.getRole().getRoleName().equals("ROLE_MANAGER") || userModel.getRole().getRoleName().equals("ROLE_USER")) {
            user.setRole(userModel.getRole());
        }

        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRole()));
    }


    private List<GrantedAuthority> mapRolesToAuthorities(UserRole role) {
        SimpleGrantedAuthority auth = new SimpleGrantedAuthority(role.getRoleName());
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(auth);
        return authorities;
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Integer getLoggedInUsers() {
        List<UserDetails> allPrincipals = sessionRegistry.getAllPrincipals()
                .stream()
                .filter(principal -> principal instanceof UserDetails)
                .map(UserDetails.class::cast)
                .collect(Collectors.toList());
        return allPrincipals.size()-getLoggedInEmployees()-1;
    }

    @Override
    public Integer getLoggedInEmployees() {
        int count = 0;
        List<UserDetails> allPrincipals = sessionRegistry.getAllPrincipals()
                .stream()
                .filter(principal -> principal instanceof UserDetails)
                .map(UserDetails.class::cast)
                .collect(Collectors.toList());
        for (UserDetails u : allPrincipals) {
             count =getByUserRoleAndEmail("ROLE_MANAGER", u.getUsername())!=null ? count+1 : count;
        }
        return count;
    }

    @Override
    public List<String> getDayOfWeek() {
        String[] dayOfWeekList = {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"};
        List<String> arrayList = new ArrayList<>(Arrays.asList(dayOfWeekList));
        LinkedList<String> dowList = new LinkedList<>();
        LocalDate d = LocalDate.now();
        String dow = String.valueOf(d.getDayOfWeek());
        int x = arrayList.indexOf(dow);
        for (int i = 1; i <= 7; i++) {
            if (x < 0) {
                x = 6;
            }
            dowList.addFirst(arrayList.get(x));
            x--;
        }
        return dowList;
    }

    @Override
    public List<Integer> getUserCountByDOW() {
        Date toDate = new Date();
        LinkedList<Integer> listOfCount = new LinkedList<>();
        for (int i = 1; i <= 7; i++) {
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, -i);
            Date fromDate = cal.getTime();
            Integer size = notificationRepository.findAllByCreatedDateLessThanEqualAndCreatedDateGreaterThanEqual(toDate, fromDate).size();
            listOfCount.addFirst(size);
            toDate = fromDate;
        }
        return listOfCount;
    }

    @Override
    public Integer getUserTotalCountByWeek() {
        List<Integer> integerList = getUserCountByDOW();
        int sum = 0;
        for (Integer i : integerList) {
            sum += i;
        }
        return sum;
    }
}
