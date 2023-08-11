package student.controller;

import org.thymeleaf.context.Context;
import student.dao.ClubDao;
import student.dao.ClubDaoImpl;
import student.entity.Member;
import student.util.ThUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CenterServlet", value = "/CenterServlet")
public class CenterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession httpSession = request.getSession();
        Member member = (Member) httpSession.getAttribute("user");

        ClubDao clubDao = new ClubDaoImpl();
        String club = clubDao.selectNameById(member.getClub());
        member.setClubName(club);

        Context context = new Context();
        context.setVariable("member",member);
        ThUtil.print(context,response,"student/center.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
