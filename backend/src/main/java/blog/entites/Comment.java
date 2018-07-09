package blog.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Comment {

    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;
}
