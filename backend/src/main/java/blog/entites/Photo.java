package blog.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

public class Photo {
    private int albumId;
    private int id;
    private String title;
    private String url;
    private String thumbnaiUrl;
}

