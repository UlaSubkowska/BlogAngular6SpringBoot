package blog.services;

import blog.entites.Photo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhotosServicesProvider implements PhotosServices {

    private List<Photo> photos;

    public PhotosServicesProvider() {
        photos = new ArrayList<>();

        Photo photo = new Photo(1, 1, "accusamus beatae ad facilis cum similique qui sunt", "http://placehold.it/600/92c952", "http://placehold.it/150/92c952");
        photos.add(photo);

        photo = new Photo(1, 12, "mollitia soluta ut rerum…ur perspiciatis maiores", "http://placehold.it/600/66b7d2", "http://placehold.it/150/66b7d2");
        photos.add(photo);

        photo = new Photo(2, 65, "sed voluptatum enim eaque cumque qui sunt", "http://placehold.it/600/149540", "http://placehold.it/150/149540");
        photos.add(photo);
    }


    @Override
    public List<Photo> getAllPhotos() {
        return photos;
    }

    @Override
    public List<Photo> getAlbumPhotos(int id) {
        List<Photo> albumPhotos = new ArrayList<>();
        for (Photo photo : photos) {
            if (photo.getAlbumId() == id) {

                albumPhotos.add(photo);
            }
        }
        return albumPhotos;
    }
}


