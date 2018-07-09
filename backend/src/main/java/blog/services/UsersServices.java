package blog.services;

import blog.entites.User;

import java.util.List;

public interface UsersServices {
    List<User> getAllUsers();
    User getUser(int id);
}

