package application;

import model.entities.User;
import model.entities.dao.UserDao;
import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();

        userDao.insert(new User("joana","joana", "joana", "joana", new Date()));


        User user1 = userDao.findById(1);
        System.out.println(user1);


        List<User> users = userDao.findAll();
        System.out.println(users);

        userDao.delete(18);

        userDao.update(new User("ana","ana", "ana", "ana", new Date()), 1);



    }
}
