package blog.services;

import blog.entites.Album;
import blog.entites.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlbumsServices extends CrudRepository<Album, Integer> {

}
