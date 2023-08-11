package student.dao;

import student.entity.Activity;
import student.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActivityDaoImpl implements ActivityDao{

    @Override
    public List<Activity> selectAllActivity(String keyword) {
        Connection connection = null;
        List<Activity> activityList = new ArrayList<>();
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from activity where aname like ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,"%"+keyword+"%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
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
            }return activityList;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection);
        }
        return null;
    }

    @Override
    public void addActivity(Activity activity) {
        Connection connection = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "insert into activity values(null,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,activity.getAname());
            preparedStatement.setString(2,activity.getAsynopsis());
            preparedStatement.setDate(3, activity.getStarttime());
            preparedStatement.setDate(4,activity.getEndtime());
            preparedStatement.setString(5,activity.getPlace());
            preparedStatement.setInt(6,activity.getAnumber());
            preparedStatement.setInt(7,activity.getClub());
            preparedStatement.setString(8,activity.getAleader());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection);
        }
    }

    @Override
    public void updateActivity(Activity activity) {
        Connection connection = null;
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

    @Override
    public void deleteActivity(int id) {
        Connection connection = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "delete from activity where aid = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection);
        }
    }
    @Override
    public Activity selectById(int id){
        Connection connection = null;
        try {
            connection = DBUtil.getConnection();
            Activity activity = new Activity();
            String sql = "select * from activity where aid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                activity.setAid(resultSet.getInt("aid"));
                activity.setAname(resultSet.getString("aname"));
                activity.setAsynopsis(resultSet.getString("asynopsis"));
                activity.setStarttime(resultSet.getDate("starttime"));
                activity.setEndtime(resultSet.getDate("endtime"));
                activity.setPlace(resultSet.getString("place"));
                activity.setAnumber(resultSet.getInt("anumber"));
                activity.setClub(resultSet.getInt("club"));
                activity.setAleader(resultSet.getString("aleader"));
                return activity;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection);
        }
        return null;
    }
}
