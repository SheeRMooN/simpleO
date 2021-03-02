package Test;

import Test.businessLogic.Event;
import Test.service.UserService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
//        Event event = new Event();
//        event.start();
        UserService userService = new UserService();
        List<Long> list = new ArrayList<>();
        try {
            list = userService.searchUser("wow", "111");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (Long list1 : list){
            System.out.println(list1);
        }
    }
}
