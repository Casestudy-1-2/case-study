package repository;

import entity.GymClass;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GymClassRepository {
    public List<GymClass> getAll() {
        List<GymClass> gymClass = new ArrayList<>();
        try {
            PreparedStatement statement = BaseRepository.getConnection().prepareStatement("select * from gym_classes");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("class_id");
                String className = resultSet.getString("class_name");
                String classTime = resultSet.getString("class_time");
                int maxCapacity = resultSet.getInt("max_capacity");
                int trainerId = resultSet.getInt("trainer_id");
                int gymID = resultSet.getInt("gym_id");
                gymClass.add(new GymClass(id, className, classTime, maxCapacity, trainerId, gymID));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return gymClass;
    }
}