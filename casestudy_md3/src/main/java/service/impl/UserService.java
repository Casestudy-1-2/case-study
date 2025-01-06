package service.impl;

import model.User;
import repository.UserRepository;
import service.IUserService;

import java.util.List;

public class UserService implements IUserService {
    private UserRepository userRepository = new UserRepository();
    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void add(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public User getById(int id) {
        return null;
    }

    @Override
    public boolean login(String username, String password) {
        return userRepository.validateUser(username, password);
    }
}
