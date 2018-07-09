package blog.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

public class Post {
    private int userId;
    private int id;
    private String title;
    private String body;

}
