package student.dao;

import student.entity.Club;
import student.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClubDaoImpl implements ClubDao{
    @Override
    public String selectNameById(int id) {
        Connection connection = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select cname from club where cid = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            return resultSet.getString("cname");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection);
        }
        return "无";
    }

    @Override
    public List<Club> selectAllClub(String keyword) {
        Connection connection = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from club where cname LIKE ? OR academy LIKE ?";
            List<Club> clubs = new ArrayList<>();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,"%"+keyword+"%");
            statement.setString(2,"%"+keyword+"%");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Club club = new Club();
                club.setCid(resultSet.getInt("cid"));
                club.setCname(resultSet.getString("cname"));
                club.setCsynopsis(resultSet.getString("csynopsis"));
                club.setAcademy(resultSet.getString("academy"));
                club.setCnumber(resultSet.getInt("cnumber"));
                club.setCleader(resultSet.getString("cleader"));
                clubs.add(club);
            }return clubs;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection);
        }
        return null;
    }
}
