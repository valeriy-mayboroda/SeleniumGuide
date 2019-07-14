package pages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by val on 13.07.2019.
 */
public class ChapterPage {
    private By textPresence = By.id("divontheleft");
    private By homePage = By.cssSelector("a[href='/']");
    private final Logger logger = LoggerFactory.getLogger(ChapterPage.class);

    public String getChapterText(){
        String text = $(textPresence).getText();
        logger.info(String.format("Text '%s' is found", text));
        return text;
    }

    public void clickHomePageLink(){
        $(homePage).click();
        logger.info("HomePage link is clicked");
    }
}