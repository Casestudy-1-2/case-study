package repository;

import dto.TrainerDTO;
import model.Trainer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrainerRepository {
    public List<TrainerDTO> getAllTrainerDTO(){
        List<TrainerDTO> trainerDTO = new ArrayList<>();
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
                    "    trainers t\n" +
                    "LEFT JOIN \n" +
                    "    gym_classes g\n" +
                    "ON \n" +
                    "    t.class_id = g.class_id;\n");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                int trainerId = resultSet.getInt("trainer_id");
                String trainerName = resultSet.getString("trainer_name");
                String specialization = resultSet.getString("specialization");
                String phone = resultSet.getString("phone");
                String className = resultSet.getString("class_name");
                trainerDTO.add(new TrainerDTO(trainerId, trainerName, specialization, phone ,className));
            }
        }catch(SQLException e) {
            throw new RuntimeException(e);
        }
        return trainerDTO;
    }

    public void add(Trainer trainer) {
        try {
            PreparedStatement statement = BaseRepository.getConnection()
                    .prepareStatement("insert into trainers(trainer_name, specialization , phone, class_id) values (?,?,?,?)");
            statement.setString(1, trainer.getName());
            statement.setString(2, trainer.getSpecialization());
            statement.setString(3, trainer.getPhone());
            statement.setInt(4, trainer.getIdClass());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id){
        try{
            PreparedStatement statement = BaseRepository.getConnection().
                    prepareStatement("delete from trainers where trainer_id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Trainer trainer, int newClassId) {
        String updateTrainerSQL = "UPDATE trainers SET trainer_name = ?, specialization = ?, phone = ? WHERE trainer_id = ?";
        String updateGymClassSQL = "UPDATE gym_classes SET class_id = ? WHERE trainer_id = ?";

        try (PreparedStatement statement = BaseRepository.getConnection().prepareStatement(updateTrainerSQL)) {
            statement.setString(1, trainer.getName());
            statement.setString(2, trainer.getSpecialization());
            statement.setString(3, trainer.getPhone());
            statement.setInt(4, trainer.getId());
            statement.executeUpdate();
            if (newClassId != -1) {
                try (PreparedStatement gymClassStatement = BaseRepository.getConnection().prepareStatement(updateGymClassSQL)) {
                    gymClassStatement.setInt(1, newClassId);
                    gymClassStatement.setInt(2, trainer.getId());
                    gymClassStatement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Trainer getByIdTrainer(int id) {
        Trainer trainer = null;
        try (PreparedStatement statement = BaseRepository.getConnection().
                prepareStatement("select * from trainers where trainer_id = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("trainer_name");
                String specialization = resultSet.getString("specialization");
                String phone = resultSet.getString("phone");
//                Integer idClass = resultSet.getInt("id_class");
                trainer = new Trainer(id, name,specialization, phone, null);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return trainer;
    }

    public List<TrainerDTO> searchByName(String searchName) {
        List<TrainerDTO> trainerDTOList = new ArrayList<>();
        String sql = "SELECT t.trainer_id, t.trainer_name, t.specialization, t.phone, g.class_name " +
                "FROM trainers t " +
                "LEFT JOIN gym_classes g ON t.class_id = g.class_id " +
                "WHERE t.trainer_name LIKE ?";
        try (PreparedStatement statement = BaseRepository.getConnection().prepareStatement(sql)) {
            statement.setString(1, "%" + searchName + "%");
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    trainerDTOList.add(new TrainerDTO(
                            resultSet.getInt("trainer_id"),
                            resultSet.getString("trainer_name"),
                            resultSet.getString("specialization"),
                            resultSet.getString("phone"),
                            resultSet.getString("class_name")
                    ));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error while searching trainer by name", e);
        }
        return trainerDTOList;
    }

}
