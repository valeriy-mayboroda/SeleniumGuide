package pages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by val on 13.07.2019.
 */
public class HomePage {
    private String chapter = "a[href*=chapter%d]";
    private final Logger logger = LoggerFactory.getLogger(HomePage.class);

    public void clickChapter(int number) {
        $(By.cssSelector(String.format(chapter, number))).click();
        logger.info(String.format("Link 'Chapter%d' is clicked", number));
    }
}