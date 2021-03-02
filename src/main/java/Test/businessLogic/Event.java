package Test.businessLogic;

import Test.entity.User;
import Test.service.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

public class Event {
    private User user = new User();



    public void start(){
        System.out.println("Hello");
        user = getAuthorization();
        System.out.println(user.toString());
    }

    private User getAuthorization() {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            System.out.println("Enter you name : ");
            user.setName(reader.readLine());

            System.out.println("Enter you password : ");
            user.setPassword(reader.readLine());
            System.out.println("event : " + user.toString());

            UserService userService = new UserService();
            userService.add(user);
            UserService userService1 = new UserService();
            List<Long> longListUser = userService1.searchUser(user.getName(), user.getPassword());


        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return user;
    }
}
