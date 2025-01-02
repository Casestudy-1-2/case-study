package repository;

import dto.GymClassDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrainerRepository {
    public List<GymClassDTO> getAllTrainerDTO(){
        List<GymClassDTO> gymClassDTO = new ArrayList<>();
        try{
            PreparedStatement statement = BaseRepository.getConnection().prepareStatement("SELECT \n" +
                    "    g.class_id,\n" +
                    "    g.class_name,\n" +
                    "    g.class_time,\n" +
                    "    g.max_capacity,\n" +
                    "    t.trainer_id,\n" +
                    "    t.trainer_name,\n" +
                    "    t.specialization,\n" +
                    "    t.phone\n" +
                    "FROM \n" +
                    "    gym_classes g\n" +
                    "LEFT JOIN \n" +
                    "    trainers t\n" +
                    "ON \n" +
                    "    g.trainer_id = t.trainer_id;\n");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                int trainerId = resultSet.getInt("trainer_id");
                String trainerName = resultSet.getString("trainer_name");
                String specialization = resultSet.getString("specialization");
                String phone = resultSet.getString("phone");
                String className = resultSet.getString("class_name");
                gymClassDTO.add(new GymClassDTO(trainerId, trainerName, specialization, phone ,className));
            }
        }catch(SQLException e) {
            throw new RuntimeException(e);
        }
        return gymClassDTO;
    }
}
