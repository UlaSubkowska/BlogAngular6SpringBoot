package blog.services;

import blog.entites.BlogUser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersServicesProvider implements UsersServices {

    List<BlogUser> blogUsers;

    public UsersServicesProvider() {
        blogUsers = new ArrayList<>();

        BlogUser blogUser = new BlogUser(1, "Leanne Graham", "Bret");
        blogUsers.add(blogUser);

        blogUser = new BlogUser(2, "Ervin Howell", "Antonette");
        blogUsers.add(blogUser);

        blogUser = new BlogUser(3, "Clementine Bauch", "Samantha");
        blogUsers.add(blogUser);

    }

    @Override
    public List<BlogUser> getAllUsers() {
        return blogUsers;
    }

    @Override
    public BlogUser getUser(int id) {
        for (BlogUser item : blogUsers) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}

