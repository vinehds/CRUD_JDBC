package br.com.viniciusdalaqua.actions;

import model.entities.dao.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteUser implements Action {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        int UserID = Integer.parseInt(id);

        UserDao.delete(UserID);

        return "controller?action=ListUsers";
    }
}
