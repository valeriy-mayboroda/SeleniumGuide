package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ChapterPage;
import pages.HomePage;

import static com.codeborne.selenide.Selenide.open;

/**
 * Created by val on 13.07.2019.
 */
public class ChapterTest extends BaseTest {
    @Test
    public void clickChapterLinksTest(){
        HomePage homePage = new HomePage();
        ChapterPage chapterPage = new ChapterPage();

        open("http://book.theautomatedtester.co.uk");
        homePage.clickChapter(1);
        Assert.assertEquals("Assert that this text is on the page", chapterPage.getChapterText());
        chapterPage.clickHomePageLink();
    }
}