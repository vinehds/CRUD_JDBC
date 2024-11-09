package br.com.viniciusdalaqua;

import br.com.viniciusdalaqua.actions.Action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controller")
public class ControllerServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            String actionName = request.getParameter("action");
            String classPackage = "br.com.viniciusdalaqua.actions.";

            Class<?> actionClass = Class.forName(classPackage + actionName);
            Action action = (Action)  actionClass.newInstance();

            String result = action.execute(request, response);

            RequestDispatcher dispatcher = request.getRequestDispatcher(result);
            dispatcher.forward(request, response);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
