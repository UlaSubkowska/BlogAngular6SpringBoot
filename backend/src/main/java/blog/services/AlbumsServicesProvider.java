package blog.services;

import blog.entites.Album;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlbumsServicesProvider implements AlbumsServices {

    private List<Album> albums;


    public AlbumsServicesProvider() {
        albums = new ArrayList<>();

        Album album = new Album(1, 1, "quidem molestiae enim");
        albums.add(album);

        album = new Album(2, 11, "quam nostrum impedit mollitia quod et dolor");
        albums.add(album);

        album = new Album(3, 21, "repudiandae voluptatem optio est consequatur rem in temporibus et");
        albums.add(album);
    }


    @Override
    public List<Album> getAllAlbums() {
        return albums;
    }

}
