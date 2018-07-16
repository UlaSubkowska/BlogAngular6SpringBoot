package blog.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@AllArgsConstructor
@Getter
@Setter
@Entity
@NoArgsConstructor

public class Post {
    private int userId;
    @Id
    private int id;
    private String title;
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String body;

}
