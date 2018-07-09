package blog.services;

import blog.entites.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersServicesProvider implements UsersServices{

    List<User> users;

    public UsersServicesProvider(){
        users = new ArrayList<>();

        User user = new User(1, "Leanne Graham", "Bret");
        users.add(user);

        user = new User(2, "Ervin Howell", "Antonette");
        users.add(user);

        user = new User(3, "Clementine Bauch", "Samantha");
        users.add(user);

    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public User getUser(int id) {
        for (User item: users) {
            if (item.getId()==id){
                return item;
            }
        }
        return null;
    }
}

