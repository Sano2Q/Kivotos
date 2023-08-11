package student.filter;

import student.entity.Member;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class myFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //写过滤器
        HttpSession session = request.getSession();
        Member user = (Member) session.getAttribute("user");
        if(user==null){//没有登录
            response.sendRedirect("ShowLoginServlet");
        }else{//已登录，刷新
            filterChain.doFilter(request,response);
        }
    }

}
