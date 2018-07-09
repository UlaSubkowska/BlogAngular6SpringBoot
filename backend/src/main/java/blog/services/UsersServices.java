package blog.services;

import blog.entites.BlogUser;

import java.util.List;

public interface UsersServices {
    List<BlogUser> getAllUsers();

    BlogUser getUser(int id);
}

