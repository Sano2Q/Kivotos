package student.controller;

import org.thymeleaf.context.Context;
import student.dao.ClubDao;
import student.dao.ClubDaoImpl;
import student.dao.MemberDao;
import student.dao.MemberDaoImpl;
import student.entity.Club;
import student.entity.Member;
import student.util.ThUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SelectAllMemberServlet", value = "/SelectAllMemberServlet")
public class SelectAllMemberServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String keyword = request.getParameter("keyword");

        MemberDao memberDao =new MemberDaoImpl();
        List<Member> members = memberDao.selectMember(keyword);
        ClubDao clubDao = new ClubDaoImpl();
        for (Member m:members){
            String club = clubDao.selectNameById(m.getClub());
            m.setClubName(club);
        }

        Context context = new Context();
        context.setVariable("members",members);
        ThUtil.print(context,response,"student/member.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
