package selenium.tests;

import org.junit.Before;
import org.junit.Test;
import selenium.pages.AllPostsPage;
import selenium.pages.HomePage;
import selenium.pages.PostDetailPage;


public class PostDetailTests extends BaseTest {
    private static String expectedTitle = "Blog";

    @Test
    public void viewPostDetailFromDashbroad () throws InterruptedException {
        String expectedPostTitle = "nesciunt quas odio";
        String expectedPostBody = "repudiandae veniam quaerat sunt sed\\nalias aut fugiat sit autem sed est\\" +
                "nvoluptatem omnis possimus esse voluptatibus quis\\nest aut tenetur dolor neque";
        int expectedNumberOfComments = 5;

        HomePage homePage = new HomePage(driver);
        PostDetailPage postDetailPage = new PostDetailPage(driver);

        homePage.goToDashbroad();
        homePage.verifyTitle(expectedTitle);
        Thread.sleep(500);

        homePage.goToPost(expectedPostTitle);

        postDetailPage.verifyPostTitle(expectedPostTitle);
        postDetailPage.verifyPostBody(expectedPostBody);
        postDetailPage.verifyNumberOfComments(expectedNumberOfComments);
    }

    @Test
    public void viewPostDetailFromAllPostsList () throws InterruptedException {
        // Detail of current first post
        //TO DO - zmienic na jakis ze starszych niz 10 pierwszych postow
        String expectedPostTitle = "sunt aut facere repellat provident occaecati excepturi optio reprehenderit";
        String expectedPostBody = "quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\n" +
                "reprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto";
        int expectedNumberOfComments = 5;

        HomePage homePage = new HomePage(driver);
        AllPostsPage allPostsPage = new AllPostsPage(driver);
        PostDetailPage postDetailPage = new PostDetailPage(driver);

        homePage.goToDashbroad();
        homePage.verifyTitle(expectedTitle);
        Thread.sleep(500);

        homePage.goToAllPosts();
        Thread.sleep(500);
        allPostsPage.goToPost(expectedPostTitle);

        postDetailPage.verifyPostTitle(expectedPostTitle);
        postDetailPage.verifyPostBody(expectedPostBody);
        postDetailPage.verifyNumberOfComments(expectedNumberOfComments);
    }

}
