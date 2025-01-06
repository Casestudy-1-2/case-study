package service.impl;

import model.GymCard;
import repository.GymCardRepository;
import service.IGymCardService;

import java.util.List;

public class GymCardService implements IGymCardService {
    private static GymCardRepository gymCardRepository = new GymCardRepository();
    @Override
    public List<GymCard> getAll() {
        return gymCardRepository.getAll();
    }

    @Override
    public void add(GymCard gymCard) {

    }

    @Override
    public void update(GymCard gymCard) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public GymCard getById(int id) {
        return null;
    }
}
