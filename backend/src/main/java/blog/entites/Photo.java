package blog.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Photo {
    private int albumId;
    private int id;
    private String title;
    private String url;
    private String thumbnaiUrl;
}

