package selenium.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import selenium.pages.AlbumPage;
import selenium.pages.HomePage;
import selenium.pages.PostDetailPage;

public class AlbumPhotosTests extends BaseTest {

    AlbumPage albumPage;

    //Detail of user with id 5
    private static final int USER_ID_5 = 5;
    private static final String EXPECTED_USER_NAME_5 = "Kamren";
    //Detail of one of user5 album
    private static final int ALBUM_ID_5 = 43;
    private static final String EXPECTED_ALBUM_TITLE_5 = "aperiam doloremque nihil";
    private static final int EXPECTED_ALBUM_PHOTOS_NUMBER_5 = 50;

    //Detail of user with id 3
    private static final int USER_ID_3 = 3;
    private static final String EXPECTED_USER_NAME_3 = "Samantha";
    //Detail of one of user3 album
    private static final int ALBUM_ID_3 = 27;
    private static final int PHOTO_ID = 1302;

    private static final String EXPECTED_ALBUM_TITLE_3 = "id non nostrum expedita";
    private static final int EXPECTED_ALBUM_PHOTOS_NUMBER_3 = 50;

    @Before
    public void setupEachTest() throws InterruptedException {
        homePage =new HomePage(driver);
        albumPage = new AlbumPage(driver);

        homePage.goToDashbroad();
        Thread.sleep(500);

        homePage.goToAlbums();
        Thread.sleep(500);
    }

    @Test
    public void Given_VerifyUserAlbum_When_DisplayThumbnailsPhotosInTheAlbum_Then_AssertAlbumContent() throws InterruptedException {
        albumPage.displayUserAlbums(USER_ID_5);
        Assert.assertEquals(EXPECTED_USER_NAME_5, albumPage.getUserName(USER_ID_5));

        albumPage.goToUserAlbum(ALBUM_ID_5);
        Assert.assertEquals(EXPECTED_ALBUM_TITLE_5, albumPage.getAlbumName());
        Assert.assertEquals(EXPECTED_ALBUM_PHOTOS_NUMBER_5, albumPage.getNumberOfPhotos());
    }

    @Test
    public void Given_ViewThePhoto_When_NavigateToTheAlbum_Then_PopupPhoto() throws InterruptedException{
        albumPage.displayUserAlbums(USER_ID_3);
        Assert.assertEquals(EXPECTED_USER_NAME_3, albumPage.getUserName(USER_ID_3));

        albumPage.goToUserAlbum(ALBUM_ID_3);
        albumPage.popupPhoto(PHOTO_ID);
    }
}
