package selenium.tests;

import blog.entites.Album;
import org.junit.Assert;
import org.junit.Test;
import selenium.pages.AlbumPage;
import selenium.pages.HomePage;
import selenium.pages.PostDetailPage;

public class AlbumPhotosTests extends BaseTest {
    private static final String EXPECTED_TITLE = "Blog";

    //Detail of user with id 5
    private static final int USER_ID = 5;
    private static final String EXPECTED_USER_NAME = "Kamren";
    //Detail of one of user album
    private static final int ALBUM_ID = 43;
    private static final String EXPECTED_ALBUM_TITLE = "aperiam doloremque nihil";


    //String expectedAlbumUserName = "Kamren";


    @Test
    public void GetPhotosFromExactAlbum() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        AlbumPage albumPage = new AlbumPage(driver);

        homePage.goToDashbroad();
        Assert.assertEquals(EXPECTED_TITLE, driver.getTitle());
        Thread.sleep(500);

        homePage.goToAlbums();
        Thread.sleep(500);

        albumPage.displayUserAlbums(USER_ID);
        Assert.assertEquals(EXPECTED_USER_NAME, albumPage.getUserName(USER_ID));

    }
}
