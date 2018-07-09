package blog.services;

import blog.entites.Comment;
import blog.entites.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentsServicesProvider implements CommentsServices {
    List<Comment> comments;

    public CommentsServicesProvider() {
        comments = new ArrayList<>();

        Comment comment = new Comment(1, 1, "id labore ex et quam laborum", "Eliseo@gardner.biz", "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium");
        comments.add(comment);

        comment = new Comment(2, 6, "et fugit eligendi deleniti quidem qui sint nihil autem", "Presley.Mueller@myrl.com", "doloribus at sed quis culpa deserunt consectetur qui praesentium\naccusamus fugiat dicta\nvoluptatem rerum ut voluptate autem\nvoluptatem repellendus aspernatur dolorem in");
        comments.add(comment);

        comment = new Comment(3, 11, "fugit labore quia mollitia quas deserunt nostrum sunt", "Veronica_Goodwin@timmothy.net", "ut dolorum nostrum id quia aut est\nfuga est inventore vel eligendi explicabo quis consectetur\naut occaecati repellat id natus quo est\nut blanditiis quia ut vel ut maiores ea");
        comments.add(comment);

    }

    @Override
    public List<Comment> getAllComments() {
        return comments;
    }

    @Override
    public List<Comment> getPostComments(int id) {
        List<Comment> postComments = new ArrayList<>();
        for (Comment comment : comments) {
            if (comment.getPostId() == id) {
                postComments.add(comment);
            }
        }
        return postComments;
    }
}

