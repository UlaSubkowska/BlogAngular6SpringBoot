package blog.controllers;

import blog.entites.Album;
import blog.entites.Photo;
import blog.entites.BlogUser;
import blog.services.AlbumsServices;
import blog.services.PhotosServices;
import blog.services.UsersServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
public class AlbumsController {

    private AlbumsServices albumsServices;
    private PhotosServices photosServices;
    private UsersServices usersServices;

    @RequestMapping("/albums")
    public List<Album> getAlbums() {
        List<Album> albums = new ArrayList<>();
        albumsServices.findAll().forEach(albums::add);
        return albums;
    }

    @RequestMapping("/photos")
    public List<Photo> getPhotos() {
        List<Photo> photos = new ArrayList<>();
        photosServices.findAll().forEach(photos::add);
        return photos;
    }

    @RequestMapping("/photos/albumId/{id}")
    public List<Photo> getPhotosFromAlbum(@PathVariable("id") int albumId){
        return photosServices.findByAlbumId(albumId);
    }

    @RequestMapping("/users")
    public List<BlogUser> getUsers() {
        List<BlogUser> blogUsers = new ArrayList<>();
        usersServices.findAll().forEach(blogUsers::add);
        return blogUsers;
    }

    @RequestMapping("/users/{id}")
    public BlogUser getUser(@PathVariable("id") int id) {
        if (usersServices.findById(id).isPresent())
            return usersServices.findById(id).get();
        else
            return null;
    }
}





