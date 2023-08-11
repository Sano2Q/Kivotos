package student.controller;

import org.thymeleaf.context.Context;
import student.dao.*;
import student.entity.Activity;
import student.entity.Member;
import student.util.ThUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SelectAllActivityServlet", value = "/SelectAllActivityServlet")
public class SelectAllActivityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String keyword = request.getParameter("keyword");

        ActivityDao activityDao = new ActivityDaoImpl();
        List<Activity> activities = activityDao.selectAllActivity(keyword);
        ClubDao clubDao = new ClubDaoImpl();

        for(Activity a:activities) {
            String club = clubDao.selectNameById(a.getClub());
            a.setClubName(club);
        }

        Context context = new Context();
        context.setVariable("activities",activities);
        ThUtil.print(context,response,"student/activity.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
