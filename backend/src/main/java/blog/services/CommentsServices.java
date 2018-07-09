package blog.services;

import blog.entites.Comment;
import blog.entites.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentsServices extends CrudRepository<Comment, Integer>{
    List<Comment> findByPostId(int postId);
}



