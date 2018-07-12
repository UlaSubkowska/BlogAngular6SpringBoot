import blog.controllers.PostsController;
import blog.entites.Comment;
import blog.entites.Post;
import blog.services.CommentsServices;
import blog.services.PostsServices;
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

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class PostsTestClass {

    private MockMvc mvc;

    @Mock
    private CommentsServices commentsServices;

    @Mock
    private PostsServices postsServices;

    @InjectMocks
    private PostsController controller;

    private JacksonTester<Post> postJacksonTester;
    private JacksonTester<List<Post>> postListJacksonTester;
    private JacksonTester<List<Comment>> commentListJacksonTester;

    @Before
    public void setup() {
        JacksonTester.initFields(this, new ObjectMapper());

        mvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void Given_FindAllPosts_When_PostsExist_Then_ReturnArrayWithAllPosts() throws Exception{
        List<Post> posts = new ArrayList<>();
        posts.add(new Post(1,2,"title","body"));

        given(postsServices.findAll()).willReturn(posts);

        MockHttpServletResponse response = mvc.perform(get("/posts").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        List<Post> resultArray = new ArrayList<>();
        resultArray.add(new Post(1,2,"title","body"));

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(postListJacksonTester.write(resultArray).getJson());
    }

    @Test
    public void Given_FindAllPosts_When_PostsDoesntExist_Then_ReturnEmptyArray() throws Exception{
        List<Post> posts = new ArrayList<>();

        given(postsServices.findAll()).willReturn(posts);

        MockHttpServletResponse response = mvc.perform(get("/posts").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("[]");
    }

    @Test
    public void Given_FindPostById_When_PostWithGivenIdExist_Then_ReturnPost() throws Exception{
        Post post = new Post(1,5,"title","body");

        given(postsServices.findById(5)).willReturn(Optional.of(post));

        MockHttpServletResponse response = mvc.perform(get("/posts/5").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(postJacksonTester.write(new Post(1,5,"title","body")).getJson());
    }

    @Test
    public void Given_FindPostById_When_PostWithGivenIdDoesntExist_Then_ReturnNull() throws Exception{
        given(postsServices.findById(5)).willReturn(Optional.empty());

        MockHttpServletResponse response = mvc.perform(get("/posts/5").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("");
    }

    @Test
    public void Given_FindPostComments_When_PostCommentsExist_Then_ReturnArrayWithPostComments() throws Exception{
        List<Comment> comments =new ArrayList<>();
        comments.add(new Comment(1,1, "name", "email", "body"));

        given(commentsServices.findByPostId(1)).willReturn(comments);

        MockHttpServletResponse response = mvc.perform(get("/posts/1/comments").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        List<Comment> resultArray = new ArrayList<>();
        resultArray.add(new Comment(1,1, "name", "email", "body"));

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(commentListJacksonTester.write(resultArray).getJson());
    }

    @Test
    public void Given_FindPostComments_When_PostCommentsDoesntExist_Then_ReturnEmptyArray() throws Exception{
        List<Comment> comments = new ArrayList<>();

        given(commentsServices.findByPostId(1)).willReturn(comments);

        MockHttpServletResponse response = mvc.perform(get("/posts/1/comments").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("[]");
    }
}
