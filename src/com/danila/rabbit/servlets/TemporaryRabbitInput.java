package com.danila.rabbit.servlets;

import com.danila.rabbit.dto.RabbitInput;
import com.danila.rabbit.services.RabbitSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/temporaryInput")
public class TemporaryRabbitInput extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String age = req.getParameter("age");

        RabbitSet.getInstance().setRabbit(new RabbitInput(name, Integer.parseInt(age)));
    }
}
