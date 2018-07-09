package blog.services;

import blog.entites.Photo;

import java.util.List;

public interface PhotosServices {
    List<Photo> getAllPhotos();
    List<Photo> getAlbumPhotos(int id);

}
