import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class LabTest {
    ChromeDriver driver;
    MainPage mainPage;
    ReviewPage reviewPage;
    ProjectPage projectPage;
    String btc = "3J98t1WpEZ73CNmQviecrnyiWrnqRhWNLy";
    String eth = "0xb794f5ea0ba39494ce839613fffba74279579268";
    String usdt = "0x36928500bc1dcd7af6a2b4008875cc336b927d57";
    String xmr = "888tNkZrPN6JsEgekjMnABU4TBzc2Dt29EPAvkRxbANsAnjyPbb3iQ1YBRk1UXcdRsiKc9dhwMVgN5S9cQUiyoogDavup3H";

    @Test
    public void startLabTest() {
        System.setProperty("webdriver.chrome.driver", ConfigReader.getProperty("driver"));
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        reviewPage = new ReviewPage(driver);
        projectPage = new ProjectPage(driver);

        driver.get(ConfigReader.getProperty("url"));

        mainPage.clickToReview();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        reviewPage.clickCard();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        projectPage.clickReviewButton();
        projectPage.writeToName("Test");
        projectPage.writeToEmail("test@test.ru");
        projectPage.writeToTransaction("12312313");
        projectPage.writeToTitle("test Title");
        projectPage.writeToReview("test review");
        projectPage.acceptCoockie();
        projectPage.clickSubmit();
        assertEquals("Check the reCAPTCHA", projectPage.getError());
    }

    @Test
    public void startLabTestFirstComment() {
        System.setProperty("webdriver.chrome.driver", ConfigReader.getProperty("driver"));
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        reviewPage = new ReviewPage(driver);
        projectPage = new ProjectPage(driver);
        driver.get(ConfigReader.getProperty("url"));
        mainPage.clickToReview();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        reviewPage.clickCard();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println(projectPage.getFirstComment());
    }

    @Test
    public void exchangeByBestRateTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", ConfigReader.getProperty("driver"));
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        reviewPage = new ReviewPage(driver);
        projectPage = new ProjectPage(driver);

        driver.get(ConfigReader.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        mainPage.acceptCoockie();
        mainPage.clickToExchange();
        mainPage.setFirstAdressField(xmr);
        mainPage.setSecondAdressField(btc);
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        mainPage.clickSubmitExchangeButton();
        Thread.sleep(5000);
        assertTrue(driver.getCurrentUrl().contains("https://swapzone.io/transaction/"));
    }

    @Test
    public void exchangeUsdtToEthFastestTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", ConfigReader.getProperty("driver"));
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);

        driver.get(ConfigReader.getProperty("url"));
        mainPage.acceptCoockie();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        mainPage.selectFirstETH();
//        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        mainPage.selectSecondUsdt();
        Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
        mainPage.selectFastestMarket();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        mainPage.setFirstAdressField(usdt);
        mainPage.setEthAdress(eth);
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        mainPage.clickSubmitExchangeButton();
        Thread.sleep(5000);
        assertTrue(driver.getCurrentUrl().contains("https://swapzone.io/transaction/"));
    }
}
