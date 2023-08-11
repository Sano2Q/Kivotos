package student.dao;

import student.entity.Club;

import java.util.List;

public interface ClubDao {
    String selectNameById(int id);
    List<Club> selectAllClub(String keyword);
}
