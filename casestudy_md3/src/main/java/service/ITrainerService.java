
package service;

import dto.TrainerDTO;
import model.Trainer;

import java.util.List;

public interface ITrainerService extends IService<Trainer>{
    List<TrainerDTO> getAllTrainerDTO();

    Trainer getByIdTrainer(int id);
}
