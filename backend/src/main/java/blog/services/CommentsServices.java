package blog.services;

import blog.entites.Comment;
import blog.entites.Post;

import java.util.List;

public interface CommentsServices {
    List<Comment> getAllComments();
    List<Comment> getPostComments(int id);
}
