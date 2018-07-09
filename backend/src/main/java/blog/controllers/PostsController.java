package blog.controllers;

import blog.entites.Comment;
import blog.entites.Post;
import blog.services.CommentsServices;
import blog.services.PostsServices;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class PostsController {

    private PostsServices postsServices;
    private CommentsServices commentsServices;


    @RequestMapping("/posts/{id}")
    public Post getPost(@PathVariable("id") int id) {
        Post post = postsServices.getPost(id);
        return post;
    }

    @RequestMapping("/posts")
    public List<Post> getPosts() {
        return postsServices.getAllPosts();
    }

    @RequestMapping("/posts/{id}/comments")
    public List<Comment> getPostComments(@PathVariable("id") int id) {
        return commentsServices.getPostComments(id);
    }

}

