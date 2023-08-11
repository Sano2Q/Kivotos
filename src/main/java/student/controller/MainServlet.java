package student.controller;

import org.thymeleaf.context.Context;
import student.entity.Member;
import student.util.ThUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MainServlet", value = "/MainServlet")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Member member = (Member) session.getAttribute("user");

        Context context = new Context();
        context.setVariable("member", member);
        ThUtil.print(context,response, "student/index.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
