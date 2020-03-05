package com.danila.rabbit.servlets;

import com.danila.rabbit.dao.RabbitDao;
import com.danila.rabbit.model.Rabbit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@WebServlet("/rabbitlist")
public class RabbitList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String value = RabbitDao.getInstance().getRabbits().stream()
                .map(Rabbit::toString)
                .collect(Collectors.joining());
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.getWriter().print(value);
    }
}
