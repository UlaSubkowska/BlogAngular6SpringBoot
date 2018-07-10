package blog.services;

import blog.entites.BlogUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsersServices extends CrudRepository<BlogUser, Integer> {

}

