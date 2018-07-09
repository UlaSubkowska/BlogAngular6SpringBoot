package blog.services;

import blog.entites.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServicesProvider implements PostsServices {



    List<Post> posts;

    public PostServicesProvider(){
        posts = new ArrayList<>();

        Post post = new Post(1,1,"sunt aut facere repellat provident occaecati excepturi optio reprehenderit", "quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto");
        posts.add(post);

        post = new Post(1,2,"qui est esse", "est rerum tempore vitae\\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\\nqui aperiam non debitis possimus qui neque nisi nulla");
        posts.add(post);

        post = new Post(1,3,"ea molestias quasi exercitationem repellat qui ipsa sit aut", "et iusto sed quo iure\nvoluptatem occaecati omnis eligendi aut ad\nvoluptatem doloribus vel accusantium quis pariatur\nmolestiae porro eius odio et labore et velit aut");
        posts.add(post);
    }

    @Override
    public List<Post> getAllPosts() {
        return posts;
    }

    @Override
    public Post getPost(int id) {
        for (Post item: posts) {
            if (item.getId()==id){
                return item;
            }
        }
        return null;
    }

}
