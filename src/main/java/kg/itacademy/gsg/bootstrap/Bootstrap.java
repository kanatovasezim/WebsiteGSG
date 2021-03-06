//package kg.itacademy.gsg.bootstrap;
//
//import kg.itacademy.gsg.entities.*;
//import kg.itacademy.gsg.entities.Package;
//import kg.itacademy.gsg.enums.Status;
//import kg.itacademy.gsg.repositories.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import java.math.BigDecimal;
//
//@Component
//public class Bootstrap implements CommandLineRunner {
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Autowired
//    UserRoleRepository userRoleRepository;
//
//    @Autowired
//    TaskRepository taskRepository;
//    @Autowired
//    CategoryRepository categoryRepository;
//    @Autowired
//    PackageRepository packageRepository;
//    @Autowired
//    OrderRepository orderRepository;
//
//    @Autowired
//    PasswordEncoder passwordEncoder;
//
//    @Override
//    public void run(String... args) throws Exception {
//

//
//        User admin = User.builder()
//                .email("admin@mail.ru")
//                .firstName("Bekbolot")
//                .lastName("Nurmanbetov")
//                .patronymic("Nurmanbetovich")
//                .password(passwordEncoder.encode("123"))
//                .role(new UserRole("ROLE_ADMIN"))
//                .build();
//
//        User manager = User.builder()
//                .email("manager@mail.ru")
//                .firstName("Bakai")
//                .lastName("Kydyrbek uulu")
//                .password(passwordEncoder.encode("12"))
//                .role(new UserRole("ROLE_MANAGER"))
//                .build();
//
//        User user = User.builder()
//                .email("zhalilov.atai@mail.ru")
//                .firstName("Атай")
//                .lastName("Жалилов")
//                .patronymic("Жалилович")
//                .password(passwordEncoder.encode("1"))
//                .companyName("BAB")
//                .companyOccupation("IT")
//                .role(new UserRole("ROLE_USER"))
//                .build();
//
//
//        userRepository.save(admin);
//        userRepository.save(manager);
//        userRepository.save(user);
//
//        Package p = Package.builder()
//                .title("Экономный")
//                .description("Вариант с малым бюджетом")
//                .price(BigDecimal.valueOf(20000))
//                .build();
//
//        Package p2 = Package.builder()
//                .title("Оптимальный")
//                .description("Оптимальный вариант самый часто используемый пакет")
//                .price(BigDecimal.valueOf(40000))
//                .build();
//
//        Package p3 = Package.builder()
//                .title("Профессиональный")
//                .description("Пакет ПРО 5 extra услуг")
//                .price(BigDecimal.valueOf(60000))
//                .build();
//
//
//        Category category1 = Category.builder()
//                .title("Введение социальных сетей")
//                .packageId(p)
//                .build();
//        Category category2 = Category.builder()
//                .title("Работа со СМИ")
//                .packageId(p2)
//                .build();
//        Category category3 = Category.builder()
//                .title("Создание видеороликов, инфографики и анимации")
//                .packageId(p3)
//                .build();
//
//        Category categoryExtra = Category.builder()
//                .title("Экстра")
//                .build();
//
//        Task task = Task.builder()
//                .title("Продвижение")
//                .description("ведение аккаунта в инстаграм")
//                .categoryId(category1)
//                .build();
//
//        Task task2 = Task.builder()
//                .title("Дать рекламу в газете")
//                .description("Составить договор с газетами на рекламу")
//                .categoryId(category2)
//                .build();
//
//        Task task3 = Task.builder()
//                .title("Снять-2 минутное видео")
//                .description("Выпускное видео для абитуриентов")
//                .categoryId(category3)
//                .build();
//        packageRepository.save(p);
//        packageRepository.save(p2);
//        packageRepository.save(p3);
//
//        categoryRepository.save(category1);
//        categoryRepository.save(category2);
//        categoryRepository.save(category3);
//        categoryRepository.save(categoryExtra);
//
//        taskRepository.save(task);
//        taskRepository.save(task2);
//        taskRepository.save(task3);
//    }
//}