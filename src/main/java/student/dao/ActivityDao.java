package student.dao;

import student.entity.Activity;

import java.util.List;

public interface ActivityDao {
    List<Activity> selectAllActivity(String keyword);
    void addActivity(Activity activity);
    void updateActivity(Activity activity);
    void deleteActivity(int id);
    Activity selectById(int id);
}
