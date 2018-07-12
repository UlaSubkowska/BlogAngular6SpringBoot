package blog;


import blog.controllers.AlbumsController;
import blog.entites.Album;
import blog.entites.BlogUser;
import blog.entites.Photo;
import blog.entites.Post;
import blog.services.AlbumsServices;
import blog.services.PhotosServices;
import blog.services.UsersServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(MockitoJUnitRunner.class)
public class AlbumTestClass {

    private MockMvc mvc;

    @Mock
    private AlbumsServices albumsServices;

    @Mock
    private PhotosServices photosServices;

    @Mock
    private UsersServices usersServices;

    @InjectMocks
    private AlbumsController controller;


    private JacksonTester<List<Album>> albumListJsonTester;
    private JacksonTester<List<Photo>> photoListJsonTester;
    private JacksonTester<List<BlogUser>> blogUserListJsonTester;
    private JacksonTester<BlogUser> blogUserJsonTester;


    @Before
    public void setup(){
        JacksonTester.initFields(this, new ObjectMapper());

        mvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void Given_AlbumsRepoContainsAlbums_When_ClientRequestsAllAlbums_Then_ResponseStatusOkAndContentIsJsonAlbumsArray() throws Exception{
        List<Album> albums = new ArrayList<>();
        albums.add(new Album(1,2,"title"));

        given(albumsServices.findAll()).willReturn(albums);

        MockHttpServletResponse response = mvc.perform(get("/albums").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();


        List<Album> resultArray = new ArrayList<>();
        resultArray.add(new Album(1,2,"title"));

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(albumListJsonTester.write(resultArray).getJson());

    }

    @Test
    public void Given_AlbumsRepoIsEmpty_When_ClientRequestsAllAlbums_Then_ResponseStatusOKAndContentIsEmptyJsonArray() throws Exception{
        List<Album> albums = new ArrayList<>();

        given(albumsServices.findAll()).willReturn(albums);

        MockHttpServletResponse response = mvc.perform(get("/albums").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("[]");
    }

    @Test
    public void Given_PhotosRepoContainsPhotos_When_ClientRequestsAllPhotos_Then_ResponseStatusOKAndContentIsJsonPhotsArray() throws Exception{
        List<Photo> photos = new ArrayList<>();
        photos.add(new Photo(1,1,"title", "url", "thumbnailUrl"));

        given(photosServices.findAll()).willReturn(photos);

        MockHttpServletResponse response = mvc.perform(get("/photos").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();


        List<Photo> resultArray = new ArrayList<>();
        resultArray.add(new Photo(1,1,"title", "url", "thumbnailUrl"));

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(photoListJsonTester.write(resultArray).getJson());
    }

    @Test
    public void Given_PhotosRepoIsEmpty_When_ClientRequestsAllPhotos_Then_ResponseStatusOKAndContentIsEmptyJsonArray() throws Exception{
        List<Photo> photos = new ArrayList<>();

        given(photosServices.findAll()).willReturn(photos);

        MockHttpServletResponse response = mvc.perform(get("/photos").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("[]");
    }

    @Test
    public void Given_PhotosRepoContainsPhotosForAlbumWithId1_When_ClientRequestsPhotosFromAlbumWithId1_Then_ResponseStatusOKAndContentIsJsonPhotosArray() throws Exception{
        List<Photo> photos = new ArrayList<>();
        photos.add(new Photo(1,1,"title", "url", "thumbnailUrl"));

        given(photosServices.findByAlbumId(1)).willReturn(photos);

        MockHttpServletResponse response = mvc.perform(get("/photos/albumId/1").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();


        List<Photo> resultArray = new ArrayList<>();
        resultArray.add(new Photo(1,1,"title", "url", "thumbnailUrl"));

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(photoListJsonTester.write(resultArray).getJson());
    }

    @Test
    public void Given_PhotosRepoIsEmpty_When_ClientRequestsPhotosFromAlbumWithId1_Then_ResponseStatusOKandContentIsEmptyJsonArray() throws Exception{
        List<Photo> photos = new ArrayList<>();

        given(photosServices.findByAlbumId(1)).willReturn(photos);

        MockHttpServletResponse response = mvc.perform(get("/photos/albumId/1").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("[]");
    }


    @Test
    public void Given_UsersRepoContainsUsers_When_ClientRequestsAllUsers_Then_ResponseStatusOKandContentIsJsonUsersArray() throws Exception{
        List<BlogUser> users = new ArrayList<>();
        users.add(new BlogUser(1, "name", "username"));

        given(usersServices.findAll()).willReturn(users);

        MockHttpServletResponse response = mvc.perform(get("/users").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();


        List<BlogUser> resultArray = new ArrayList<>();
        resultArray.add(new BlogUser(1, "name", "username"));

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(blogUserListJsonTester.write(resultArray).getJson());
    }

    @Test
    public void Given_UsersRepoIsEmpty_When_ClientRequestsAllUsers_Then_ResponseStatusOKandContentIsEmptyJsonArray() throws Exception{
        List<BlogUser> users = new ArrayList<>();

        given(usersServices.findAll()).willReturn(users);

        MockHttpServletResponse response = mvc.perform(get("/users").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("[]");
    }

    @Test
    public void Given_UsersRepoContainsUsers_When_ClientRequestsUserByID_Then_ResponseStatusOKandContentIsUserEntityMappedToJson() throws Exception{
        BlogUser user = new BlogUser(1, "name", "username");

        given(usersServices.findById(1)).willReturn(Optional.of(user));

        MockHttpServletResponse response = mvc.perform(get("/users/1").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(blogUserJsonTester.write(new BlogUser(1, "name", "username")).getJson());
    }

    @Test
    public void Given_UsersRepoIsEmpty_When_ClientRequestsUserByID_Then_ResponseStatusOKandContentIsEmpty() throws Exception{
        given(usersServices.findById(1)).willReturn(Optional.empty());

        MockHttpServletResponse response = mvc.perform(get("/users/1").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("");
    }


}
