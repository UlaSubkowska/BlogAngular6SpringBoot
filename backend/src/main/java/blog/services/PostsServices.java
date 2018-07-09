package blog.services;

import blog.entites.Post;

import java.util.List;

public interface PostsServices {
    List<Post>getAllPosts();
    Post getPost(int id);
}

