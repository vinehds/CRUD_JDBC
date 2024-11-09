package br.com.viniciusdalaqua.actions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Action{

    String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

}
