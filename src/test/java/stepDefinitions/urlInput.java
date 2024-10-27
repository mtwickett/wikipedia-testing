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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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

    @When("A correct Wikipedia URL is provided in the input bar")
    public void a_correct_wikipedia_url_is_provided_in_the_input_bar() {
        driver.findElement(By.id("wikipedia-url"))
                .sendKeys("https://en.wikipedia.org/wiki/Chemical_compound");
    }
    @And("User clicks the Get word count button")
    public void user_clicks_the_get_word_count_button() {
        driver.findElement(By.id("get-word-count")).click();
    }
    @Then("The page displays the word count")
    public void the_page_displays_the_word_count() {
        System.out.println("3");
    }
}

