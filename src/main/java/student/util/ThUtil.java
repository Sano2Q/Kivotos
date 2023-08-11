package student.util;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 该类封装Thymeleaf相关逻辑代码，是工具类
 * 其作用如同JDBC里面DBUtil工具类一样
 */
public class ThUtil {

    private static TemplateEngine templateEngine;
    //创建的视图模板引擎和解析器对象都是只需要一次
    static {
        //实例化Thymeleaf的模板引擎
        templateEngine = new TemplateEngine();
        //实例化解析器对象
        ClassLoaderTemplateResolver classLoaderTemplateResolver = new ClassLoaderTemplateResolver();
        //设置字符集编码
        classLoaderTemplateResolver.setCharacterEncoding("utf-8");
        //解析器关联模板引擎
        templateEngine.setTemplateResolver(classLoaderTemplateResolver);
    }
    //响应界面
    public static void print(Context context, HttpServletResponse response,String htmlName) throws IOException {
        String html=templateEngine.process(htmlName,context);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter =response.getWriter();
        printWriter.print(html);
        printWriter.close();
    }

}
