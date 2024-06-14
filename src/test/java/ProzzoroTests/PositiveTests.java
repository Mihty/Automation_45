package ProzzoroTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PositiveTests extends BaseTest {

    @DataProvider(name = "positiveSearchData")
    public Object[][] positiveSearchData() {
        return new Object[][] {
                {"тендер"},
                {"стул"},
                {"Укриття"},
        };
    }

    @Test(dataProvider = "positiveSearchData", groups = "positive")
    public void testSearchFunctionality(String query) {
        driver.findElement(By.className("search-text__input")).sendKeys(query);
        driver.findElement(By.xpath("//button[@class='btn search-text__btn' and @type='submit']")).click();
        Assert.assertTrue(driver.findElement(By.className("search-result-card")).isDisplayed());
    }

    @Test(groups = "positive")
    public void testPartialSearchMatch() {
        driver.findElement(By.className("search-text__input")).sendKeys("тен");
        driver.findElement(By.xpath("//button[@class='btn search-text__btn' and @type='submit']")).click();
        Assert.assertTrue(driver.findElement(By.className("search-result-card")).isDisplayed());
    }
}