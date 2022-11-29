package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        Car car1 = new Car("Model1", 1111);
        User user1 = new User("User1", "Lastname1", "user1@mail.ru");
        user1.setUserCar(car1);
        Car car2 = new Car("Model2", 2222);
        User user2 = new User("User2", "Lastname2", "user2@mail.ru");
        user2.setUserCar(car2);
        Car car3 = new Car("Model3", 3333);
        User user3 = new User("User3", "Lastname3", "user3@mail.ru");
        user3.setUserCar(car3);
        Car car4 = new Car("Model4", 4444);
        User user4 = new User("User4", "Lastname4", "user4@mail.ru");
        user4.setUserCar(car4);

        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);

      List<User> users = userService.listUsers();
      for (User user : users) {
          System.out.println(user);
          System.out.println(user.getUserCar());
          System.out.println();
      }

        User user = userService.getUserByCarInfo("Model3", 3333);
        System.out.println("\nInfo about user who has a car model \"Model3\" with serial number 3333:");
        System.out.println(user);
        context.close();
    }
}
