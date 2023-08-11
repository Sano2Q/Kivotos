package student.controller;

import org.thymeleaf.context.Context;
import student.dao.ClubDao;
import student.dao.ClubDaoImpl;
import student.entity.Club;
import student.util.ThUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SelectAllClubServlet", value = "/SelectAllClubServlet")
public class SelectAllClubServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String keyword = request.getParameter("keyword");

        ClubDao clubDao = new ClubDaoImpl();
        List<Club> clubList = clubDao.selectAllClub(keyword);

        Context context = new Context();
        context.setVariable("clubs",clubList);
        ThUtil.print(context,response,"student/club.html");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
