package service;

import model.User;

public interface IUserService extends IService<User> {
    boolean login(String username, String password);
}
