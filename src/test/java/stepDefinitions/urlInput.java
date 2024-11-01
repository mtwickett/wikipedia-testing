package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class urlInput {
    private WebDriver driver;

    @Before
    public void openBrowser() {
        System.setProperty(
                "webdriver.chrome.driver",
                System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver"
        );
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Given("I access the Wikipedia Page Word Counter webpage")
    public void i_access_the_wikipedia_page_word_counter_webpage() {
        driver.get("https://wikipedia-page-word-counter.s3.us-east-2.amazonaws.com/index.html");
    }

    @When("A correct Wikipedia URL is provided in the input bar {word}")
    public void a_correct_wikipedia_url_is_provided_in_the_input_bar(String url) {
        driver.findElement(By.id("wikipedia-url"))
                .sendKeys(url);
    }

    @And("User clicks the Get word count button")
    public void user_clicks_the_get_word_count_button() {
        driver.findElement(By.id("get-word-count")).click();
    }

    @Then("The page displays the wikipedia title {string}")
    public void the_page_displays_the_wikipedia_title(String title) {
        WebElement webpage_title = driver.findElement(By.id("title"));
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(d -> webpage_title.isDisplayed());
        System.out.println(webpage_title.getText());
        Assert.assertEquals(webpage_title.getText(), title);
    }
}

