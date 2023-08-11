package student.dao;

import student.entity.Member;
import student.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDaoImpl implements MemberDao {

    @Override
    public Member loginMember(String name, String pwd) {
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
                return member;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection);
        }
        return null;
    }
    @Override
    public List<Member> selectMember(String keyword){
        Connection connection = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select* from member where mname LIKE ? OR username like ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"%"+keyword+"%");
            preparedStatement.setString(2,"%"+keyword+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Member> members = new ArrayList<>();
            while(resultSet.next()){
                Member member =new Member();
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
                members.add(member);
            }
            return members;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection);
        }
        return null;
    }

    @Override
    public void registerMember(Member member) {
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
}
