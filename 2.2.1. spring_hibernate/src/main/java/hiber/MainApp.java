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

      User user1 = new User("Lena", "Golovach", "@1..");
      User user2 = new User("Oleg", "Smirnov", "@2..");
      User user3 = new User("Gleb", "Golovach", "@3..");
      User user4 = new User("Anton", "Sidorov", "@4..");

      Car car1 = new Car("Subaru", 1998);
      Car car2 = new Car("Kia", 1999);
      Car car3 = new Car("Lada", 1989);

      user1.setUserCar(car1);
      user2.setUserCar(car2);
      user3.setUserCar(car1);
      user4.setUserCar(car3);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user);
         System.out.println();
      }

      System.out.println(userService.getCarInfo("Subaru", 1998));

      context.close();
   }
}
