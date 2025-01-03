
package service.impl;

import dto.TrainerDTO;
import model.Trainer;
import repository.TrainerRepository;
import service.ITrainerService;

import java.util.List;

public class TrainerService implements ITrainerService {
    private static TrainerRepository trainerRepository = new TrainerRepository();
    @Override
    public List<TrainerDTO> getAllTrainerDTO() {
        return trainerRepository.getAllTrainerDTO();
    }

    @Override
    public Trainer getByIdTrainer(int id) {
        return trainerRepository.getByIdTrainer(id);
    }

    @Override
    public List<Trainer> getAll() {
        return null;
    }

    @Override
    public void add(Trainer trainer) {
        trainerRepository.add(trainer);

    }

    @Override
    public void update(Trainer trainer) {
        trainerRepository.update(trainer, trainer.getIdClass());

    }

    @Override
    public void delete(int id) {
        trainerRepository.delete(id);

    }

    @Override
    public Trainer getById(int id) {
        return null;
    }
}
