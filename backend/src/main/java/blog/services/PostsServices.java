package blog.services;

import blog.entites.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostsServices extends CrudRepository<Post, Integer> {
}


