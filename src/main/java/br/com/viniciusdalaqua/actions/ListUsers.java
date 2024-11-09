package br.com.viniciusdalaqua.actions;

import model.entities.User;
import model.entities.dao.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListUsers implements Action {


    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = UserDao.findAll();

        req.setAttribute("users", users);

        return "/WEB-INF/list-users.jsp";
    }
}
