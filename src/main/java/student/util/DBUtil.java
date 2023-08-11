package student.util;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.util.Properties;

/*封装DBUtil工具类*/
public class DBUtil {
    //声明参数变量
    private static String driver;
    private static String url;
    private static String user;
    private static String pwd;

    //声明连接池对象
    private static DruidDataSource dds;//需要导包
    private static String initSize;
    private static String maxSize;

    //因为读取配置文件只需要读取一次，连接池对象也只需要创建一次，所以写在静态块中
    static {
        Properties p=new Properties();
        try {
            //异常最后try...catch捕获
            p.load(DBUtil.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            //取参数值
            driver=p.getProperty("jdbc.driver");
            url=p.getProperty("jdbc.url");
            user=p.getProperty("jdbc.username");
            pwd=p.getProperty("jdbc.password");

            //创建连接池对象
            dds = new DruidDataSource();
            initSize = p.getProperty("jdbc.initialSize");
            maxSize = p.getProperty("jdbc.maxActive");

            dds = new DruidDataSource();
            //并设置连接参数放入连接池中，连接池会自动加载驱动，
            //所以这里不必再Class.forName()。
            dds.setDriverClassName(driver);
            dds.setUrl(url);
            dds.setUsername(user);
            dds.setPassword(pwd);
            //要求传入整数，我们传入字符串需要进行解析
            dds.setInitialSize(Integer.parseInt(initSize));
            dds.setMaxActive(Integer.parseInt(maxSize));
        } catch (Exception e) {
            //处理异常
            e.printStackTrace();
        }
    }

    //该方法最好写成静态的，不需要new创建对象调用，使用时直接调用该方法。
    public static Connection getConnection() throws Exception {//抛出异常
        return dds.getConnection();
    }

    //关闭连接
    public static void close(Connection con) {
        if(con != null) {//避免空指针异常
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("关闭连接失败", e);
            }
        }
    }
}
