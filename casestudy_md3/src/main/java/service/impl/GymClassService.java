
package service.impl;

import model.GymClass;
import repository.GymClassRepository;
import service.IGymClassService;

import java.util.List;

public class GymClassService implements IGymClassService {
    private static GymClassRepository gymClassRepository = new GymClassRepository();

    @Override
    public List<GymClass> getAll() {
        List<GymClass> gymClasses = gymClassRepository.getAll();
        if (gymClasses.isEmpty()) {
            throw new RuntimeException();
        }
        return gymClasses;
    }

    @Override
    public void add(GymClass gymClass) {

    }

    @Override
    public void update(GymClass gymClass) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public GymClass getById(int id) {
        return null;
    }
}
