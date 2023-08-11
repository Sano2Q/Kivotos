package student.controller;

import org.thymeleaf.context.Context;
import student.dao.MemberDao;
import student.dao.MemberDaoImpl;
import student.entity.Member;
import student.util.ThUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String mname = request.getParameter("mname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String age = request.getParameter("age");
        String birthday = request.getParameter("birthday");
        String height = request.getParameter("height");
        String grade = request.getParameter("grade");
        String hobby = request.getParameter("hobby");
        String club = request.getParameter("club");
        Integer c;

        MemberDao memberDao = new MemberDaoImpl();
        if (!mname.equals("") && !username.equals("") && !password.equals("")) {
            if(club.equals("")) c=null;
            else c = Integer.valueOf(club);
            Member member = new Member(null,mname,username,password,2,age,birthday,height,grade,hobby,c);
            memberDao.registerMember(member);
            response.sendRedirect("ShowLoginServlet");
        }else {
            response.sendRedirect("ShowRegisterServlet");
        }

    }
}
