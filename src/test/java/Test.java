import student.entity.Activity;
import student.entity.Member;
import student.util.DBUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Test {

    @org.junit.Test
    public void loginMember() {
        String name="sensei";
        String pwd="1235";
        Connection connection = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select* from member where username = ? and password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,pwd);
            ResultSet resultSet = preparedStatement.executeQuery();
            Member member = new Member();
            if(resultSet.next()){
                member.setMid(resultSet.getInt("mid"));
                member.setMname(resultSet.getString("mname"));
                member.setUsername(resultSet.getString("username"));
                member.setPassword(resultSet.getString("password"));
                member.setRole(resultSet.getInt("role"));
                member.setAge(resultSet.getString("age"));
                member.setBirthday(resultSet.getString("birthday"));
                member.setHeight(resultSet.getString("height"));
                member.setGrade(resultSet.getString("grade"));
                member.setHobby(resultSet.getString("hobby"));
                member.setClub(resultSet.getInt("club"));
                System.out.println("登录成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection);
        }
    }
    @org.junit.Test
    public void registerMember() {
        Member member = new Member(null,"周杰","zj","123",2,"18","4月18日","168","","",1);
        Connection  connection = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "insert into member values(null,?,?,?,2,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,member.getMname());
            preparedStatement.setString(2,member.getUsername());
            preparedStatement.setString(3,member.getPassword());
            preparedStatement.setString(4,member.getAge());
            preparedStatement.setString(5,member.getBirthday());
            preparedStatement.setString(6,member.getHeight());
            preparedStatement.setString(7,member.getGrade());
            preparedStatement.setString(8,member.getHobby());
            preparedStatement.setInt(9,member.getClub());
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection);
        }
    }
    @org.junit.Test
    public void selectNameById() {
        int id=3;
        Connection connection = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select cname from club where cid = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            System.out.println(resultSet.getString("cname"));
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection);
        }
        System.out.println("无");
    }
    @org.junit.Test
    public void selectAllActivity() {
        String keyword = "";
        Connection connection = null;
        List<Activity> activityList = new ArrayList<>();
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from activity where aname like ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,"%"+keyword+"%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                System.out.println("编号："+resultSet.getInt("aid")+"name:"+resultSet.getString("aname")
                        +"简介："+resultSet.getString("asynopsis")+"");
                Activity activity = new Activity();
                activity.setAid(resultSet.getInt("aid"));
                activity.setAname(resultSet.getString("aname"));
                activity.setAsynopsis(resultSet.getString("asynopsis"));
                activity.setStarttime(resultSet.getDate("starttime"));
                activity.setEndtime(resultSet.getDate("endtime"));
                activity.setPlace(resultSet.getString("place"));
                activity.setAnumber(resultSet.getInt("anumber"));
                activity.setClub(resultSet.getInt("club"));
                activity.setAleader(resultSet.getString("aleader"));
                activityList.add(activity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection);
        }
        System.out.println("查询结束");
    }
    @org.junit.Test
    public void updateActivity() {
        Connection connection = null;
        Activity activity =new Activity(2,"huoz","sb", Date.valueOf("2003-2-27"),Date.valueOf("2023-12-15"),"xialai",2,2,"wang");
        try {
            connection = DBUtil.getConnection();
            String sql = "update activity set aname = ?,asynopsis = ?,starttime = ?,endtime = ?,place = ?,anumber = ?," +
                    "aleader = ? where aid = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,activity.getAname());
            preparedStatement.setString(2,activity.getAsynopsis());
            preparedStatement.setDate(3,activity.getStarttime());
            preparedStatement.setDate(4,activity.getEndtime());
            preparedStatement.setString(5,activity.getPlace());
            preparedStatement.setInt(6,activity.getAnumber());
            preparedStatement.setString(7,activity.getAleader());
            preparedStatement.setInt(8,activity.getAid());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection);
        }
    }
}
