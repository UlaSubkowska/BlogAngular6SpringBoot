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

public class Comment {

    private int postId;
    @Id
    private int id;
    private String name;
    private String email;
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String body;
}
