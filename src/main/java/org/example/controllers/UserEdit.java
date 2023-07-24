package org.example.controllers;

import org.example.dao.User;
import org.example.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/edit")
public class UserEdit extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        UserDao userDao = new UserDao();
        User read = userDao.read(Integer.parseInt(id));
        req.setAttribute("user", read);
        getServletContext().getRequestDispatcher("/users/edit.jsp")
                .forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = new User();
        user.setId(Integer.parseInt(req.getParameter("id")));
        user.setUserName(req.getParameter("userName"));
        user.setEmail(req.getParameter("userEmail"));
        user.setPassword(req.getParameter("userPassword"));
        UserDao userDao = new UserDao();
        userDao.update(user);
        resp.sendRedirect(req.getContextPath() + "/user/list");


    }
}
