package student.controller;

import org.thymeleaf.context.Context;
import student.util.ThUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ShowRegisterServlet", value = "/ShowRegisterServlet")
public class ShowRegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Context context = new Context();
        ThUtil.print(context,response,"student/register.html");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
