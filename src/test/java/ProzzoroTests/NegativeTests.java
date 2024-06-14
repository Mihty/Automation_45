package ProzzoroTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTests extends BaseTest {

    @Test(groups = "negative")
    public void testVeryLongSearchQuery() {
        String longQuery = "a".repeat(100);
        driver.findElement(By.className("search-text__input")).sendKeys(longQuery);
        driver.findElement(By.xpath("//button[@class='btn search-text__btn' and @type='submit']")).click();
        Assert.assertTrue(driver.findElement(By.className("search-result__empty")).getText().contains("За вашим запитом нічого не знайдено."));
    }

    @Test(groups = "negative")
    public void testEmptySearchQuery() {
        driver.findElement(By.xpath("//button[@class='btn search-text__btn' and @type='submit']")).click();
        Assert.assertTrue(driver.findElements(By.className("search-result-card")).size() > 0, "No search results displayed for empty query.");
    }

    @Test(groups = "negative")
    public void testSpecialCharactersSearchQuery() {
        driver.findElement(By.className("search-text__input")).sendKeys("!@#$%^&*()");
        driver.findElement(By.xpath("//button[@class='btn search-text__btn' and @type='submit']")).click();
        Assert.assertTrue(driver.findElement(By.className("search-result__empty")).getText().contains("За вашим запитом нічого не знайдено."));
    }
}
