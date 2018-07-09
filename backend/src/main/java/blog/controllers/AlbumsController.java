package blog.controllers;

import blog.entites.Album;
import blog.entites.Photo;
import blog.entites.User;
import blog.services.AlbumsServices;
import blog.services.PhotosServices;
import blog.services.UsersServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class AlbumsController {

    private AlbumsServices albumsServices;
    private PhotosServices photosServices;
    private UsersServices usersServices;

    @RequestMapping("/albums")
    public List<Album> getAlbums() {
        return albumsServices.getAllAlbums();
    }

    @RequestMapping("/photos")
    public List<Photo> getPhotos(@RequestParam(value = "albumId", defaultValue="all") String id){
        if (id.equals("all")){
            return photosServices.getAllPhotos();
        }
        else {
            int albumId = Integer.parseInt(id);
            return photosServices.getAlbumPhotos(albumId);
        }
    }

    @RequestMapping("/users")
    public List<User> getUsers(){
        return usersServices.getAllUsers();
    }

    @RequestMapping("/users/{id}")
    public User getUser(@PathVariable("id") int id){
        return usersServices.getUser(id);
    }
}




