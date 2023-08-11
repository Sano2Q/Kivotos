package student.controller;

import student.dao.MemberDao;
import student.dao.MemberDaoImpl;
import student.entity.Member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("username");
        String pwd = request.getParameter("password");
        HttpSession httpSession;

        MemberDao memberDao = new MemberDaoImpl();
        Member member = memberDao.loginMember(name,pwd);

        if(member!=null){
            Cookie c1 =new Cookie("name", URLEncoder.encode(name,"utf-8"));
            Cookie c2 = new Cookie("pwd",pwd);
            response.addCookie(c1);
            response.addCookie(c2);

            httpSession = request.getSession();
            httpSession.setAttribute("user",member);
            response.sendRedirect("/Kivotos_war_exploded");
        } else
            response.sendRedirect("ShowLoginServlet");
    }
}
