package selenium.tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import selenium.pages.HomePage;
import selenium.pages.PostDetailPage;


public class PostDetailTests extends BaseTest {
    private static final String EXPECTED_TITLE = "Blog";

    // Detail of current fifth post
    private static final String EXPECTED_POST_TITLE_5 = "nesciunt quas odio";
    private static final String EXPECTED_POST_BODY_5 = "repudiandae veniam quaerat sunt sed\\nalias aut fugiat sit autem sed est\\" +
            "nvoluptatem omnis possimus esse voluptatibus quis\\nest aut tenetur dolor neque";
    private static final int EXPECTED_NUMBER_OF_COMMENTS_5 = 5;

    // Detail of current fourteenth post
    private static final String EXPECTED_POST_TITLE_14 = "voluptatem eligendi optio";
    private static final String EXPECTED_POST_BODY_14 = "fuga et accusamus dolorum perferendis illo voluptas\\nnon doloremque neque facere\\" +
            "nad qui dolorum molestiae beatae\\nsed aut voluptas totam sit illum";
    private static final int EXPECTED_NUMBER_OF_COMMENTS_14 = 5;

    @Test
    public void Given_VerifyPostDetail_When_NavigateFromDashbroad_Then_AssertPostDetail () throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        PostDetailPage postDetailPage = new PostDetailPage(driver);

        homePage.goToDashbroad();
        Assert.assertEquals(EXPECTED_TITLE, driver.getTitle());
        Thread.sleep(500);

        homePage.goToPost(EXPECTED_POST_TITLE_5);

        Assert.assertEquals(EXPECTED_POST_TITLE_5, postDetailPage.getPostTitle());
        Assert.assertEquals(EXPECTED_POST_BODY_5, postDetailPage.getPostBody());
        Assert.assertEquals(EXPECTED_NUMBER_OF_COMMENTS_5, postDetailPage.getNumberOfComments());
    }


    @Test
    public void Given_VerifyPostDetail_When_NavigateFromAllPostsList_Then_AssertPostDetail () throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        PostDetailPage postDetailPage = new PostDetailPage(driver);

        homePage.goToDashbroad();
        Assert.assertEquals(EXPECTED_TITLE, driver.getTitle());
        Thread.sleep(500);

        homePage.goToAllPosts();
        Thread.sleep(500);
        homePage.goToPost(EXPECTED_POST_TITLE_14);

        Assert.assertEquals(EXPECTED_POST_TITLE_14, postDetailPage.getPostTitle());
        Assert.assertEquals(EXPECTED_POST_BODY_14, postDetailPage.getPostBody());
        Assert.assertEquals(EXPECTED_NUMBER_OF_COMMENTS_14, postDetailPage.getNumberOfComments());

    }

}
