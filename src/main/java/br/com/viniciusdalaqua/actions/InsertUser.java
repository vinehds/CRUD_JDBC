package br.com.viniciusdalaqua.actions;

import model.entities.User;
import model.entities.dao.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InsertUser implements Action {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String cpf = req.getParameter("cpf");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String dateOfBirth = req.getParameter("dateOfBirth");

        User newUSer = new User(name, cpf, email, password, LocalDate.parse(dateOfBirth,
                DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        UserDao.insert(newUSer);

        return "/WEB-INF/user-added.jsp";

    }
}
