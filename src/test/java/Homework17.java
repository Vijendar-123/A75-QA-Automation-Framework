import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{
    @Test
    public void addSongTOPlaylist() throws InterruptedException {
        String ExpectedString = "Added 1 song into \"Test Pro Playlist.\"";
        //Navigate to the login page
        navigatetoURL();
        //loign to the application
        provideEmail("vijendar@testpro.io");
        providePassword("cnb243YB");
        clickSubmitBtn();
        Thread.sleep(2000);
        //search for the song
        searchSong("dark");
        Thread.sleep(2000);
        //click view all button
        clickViewALLBtn();
        Thread.sleep(2000);
        //Select the first song
        selectFirstSong();
        Thread.sleep(2000);
        //Click on add to playlist
        clickAddToBtn();
        Thread.sleep(2000);
        //Select the playlist
        choosePlaylist();
        
        //Assertion for added to the playlist
        Assert.assertEquals(getAddToPlaylistSuccessMsg(),ExpectedString);
    }

}
