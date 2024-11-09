package br.com.viniciusdalaqua.actions;

import model.entities.User;
import model.entities.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FindUserById implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int userID = Integer.parseInt(request.getParameter("id"));

        User userFound = UserDao.findById(userID);
        request.setAttribute("userFound", userFound);

        return "WEB-INF/findById.jsp";
    }
}
