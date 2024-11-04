package application;

import model.entities.User;
import model.entities.dao.UserDao;

import java.util.Date;

public class Program {
    public static void main(String[] args) {
        User user = new User("vini", "123", "v@gmail.com", "5555", new Date());

        UserDao userDao = new UserDao();
        int ra = userDao.insert(user);

        System.out.println(userDao.findById(1));
        System.out.println(userDao.findAll());
    }
}
