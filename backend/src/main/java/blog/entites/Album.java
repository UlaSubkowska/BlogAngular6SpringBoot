package blog.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@Getter
@Setter
@Entity
@NoArgsConstructor

public class Album {
    private int userId;
    @Id
    private int id;
    private String title;
}


