package com.kushan.abclab.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kushan.abclab.model.UserLoginModel;
import com.kushan.abclab.service.UserLoginSer;

public class UserLoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserLoginModel userloginmodel = new UserLoginModel(username,password);
        UserLoginSer userloginser = new UserLoginSer();

        boolean success = false;
        try {
            success = userloginser.checkLogin(userloginmodel);
        } catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }

        if (success) {
            HttpSession session = request.getSession();
            session.setAttribute("userid", username);
            response.getWriter().println("Login Success");
        } else {
            request.setAttribute("errorMessage", "Invalid username or password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
