package blog.services;

import blog.entites.Photo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PhotosServices extends CrudRepository<Photo, Integer>{
    List<Photo> findByAlbumId(int albumId);
}

