package org.example.controllers;

import org.example.dao.User;
import org.example.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user/list")
public class UserList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String users = req.getParameter("users");
        if (users != null && !users.isBlank()){
            req.setAttribute("users", Integer.parseInt(users));
        }

        UserDao userDao = new UserDao();
        User[] userList = userDao.findAll();
        req.setAttribute("users", userList);


        getServletContext().getRequestDispatcher("/users/list.jsp").forward(req, resp);
    }
}
