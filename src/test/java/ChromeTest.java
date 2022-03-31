import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class ChromeTest {
    ChromeDriver driver;
    MainPage mainPage;
    ReviewPage reviewPage;
    ProjectPage projectPage;
    BlogPage blogPage;
    AuthorizationPage authorizationPage;
    String btc = "3J98t1WpEZ73CNmQviecrnyiWrnqRhWNLy";
    String eth = "0xb794f5ea0ba39494ce839613fffba74279579268";
    String usdt = "0xdac17f958d2ee523a2206206994597c13d831ec7";
    String xmr = "888tNkZrPN6JsEgekjMnABU4TBzc2Dt29EPAvkRxbANsAnjyPbb3iQ1YBRk1UXcdRsiKc9dhwMVgN5S9cQUiyoogDavup3H";


    @Test
    public void reviewTest() {
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
    public void registrationTest() {
        System.setProperty("webdriver.chrome.driver", ConfigReader.getProperty("driver"));
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        authorizationPage = new AuthorizationPage(driver);

        driver.get(ConfigReader.getProperty("url"));

        mainPage.clickToReferralProgram();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        authorizationPage.clickSignUpButton();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        authorizationPage.writeToEmail("test@test.ru");
        authorizationPage.writeToName("test");
        authorizationPage.writeToPassword("123456");
        authorizationPage.writeToCheckPassword("123456");
        authorizationPage.acceptCoockie();
        authorizationPage.clickSubmit();
        assertEquals("Check the reCAPTCHA", authorizationPage.getError());
    }

    @Test
    public void referralLinkTest() {
        System.setProperty("webdriver.chrome.driver", ConfigReader.getProperty("driver"));
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        authorizationPage = new AuthorizationPage(driver);

        driver.get(ConfigReader.getProperty("url"));

        mainPage.clickToReferralProgram();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        authorizationPage.writeToNameForReferral("test");
        authorizationPage.writeToEmailForReferral("test@test.ru");
        authorizationPage.clickGetLink();
        assertTrue(driver.getCurrentUrl().contains("https://swapzone.io/referral-program"));
    }

    @Test
    public void weAreInTelegramTest() {
        System.setProperty("webdriver.chrome.driver", ConfigReader.getProperty("driver"));
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        projectPage = new ProjectPage(driver);

        driver.get(ConfigReader.getProperty("url"));

        mainPage.clickToReferralProgram();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        projectPage.clickTelegramButton();
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
    public void getInformationBitcoin() {
        System.setProperty("webdriver.chrome.driver", ConfigReader.getProperty("driver"));
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        reviewPage = new ReviewPage(driver);
        projectPage = new ProjectPage(driver);

        driver.get(ConfigReader.getProperty("url"));
        mainPage.clickToSupportedCurrencies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        projectPage.clickChooseBitcoin();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println(projectPage.getBitcoinInformation());
        assertTrue(driver.getCurrentUrl().contains("https://swapzone.io/currencies/bitcoin"));
    }

    @Test
    public void SearchTest() {
        System.setProperty("webdriver.chrome.driver", ConfigReader.getProperty("driver"));
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        projectPage = new ProjectPage(driver);

        driver.get(ConfigReader.getProperty("url"));
        mainPage.clickToFag();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        projectPage.writeToRequest("What is Swapzone");
        projectPage.clickSearch();
        assertEquals("WHAT IS SWAPZONE?", projectPage.getResultSearch());
    }

    @Test
    public void SeeAMABlogTest() {
        System.setProperty("webdriver.chrome.driver", ConfigReader.getProperty("driver"));
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        blogPage = new BlogPage(driver);

        driver.get(ConfigReader.getProperty("url"));
        mainPage.clickToBlog();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        blogPage.clickChooseBlog();
        assertTrue(driver.getCurrentUrl().contains("https://swapzone.io/blog/"));
    }

    @Test
    public void FilterBlogByDateTest() {
        System.setProperty("webdriver.chrome.driver", ConfigReader.getProperty("driver"));
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        blogPage = new BlogPage(driver);

        driver.get(ConfigReader.getProperty("url"));
        mainPage.clickToBlog();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        blogPage.writeToSearch("AMA");
        blogPage.clickSubmit();
        assertTrue(driver.getCurrentUrl().contains("https://swapzone.io/blog/"));
    }

    @Test
    public void ConnectCompanyTest() {
        System.setProperty("webdriver.chrome.driver", ConfigReader.getProperty("driver"));
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        reviewPage= new ReviewPage(driver);

        driver.get(ConfigReader.getProperty("url"));

        mainPage.clickToReview();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        reviewPage.writeToCompany("Test");
        reviewPage.writeToEmail("test@test.ru");
        reviewPage.clickSubmitCompany();
        System.out.println(reviewPage.getInfo());
        assertTrue(driver.getCurrentUrl().contains("https://swapzone.io/reviews"));
    }


    @Test
    public void exchangeBtcToXmrByBestRateTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", ConfigReader.getProperty("driver"));
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);

        driver.get(ConfigReader.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        mainPage.acceptCoockie();
        mainPage.clickToExchange();
        mainPage.setFirstAdressField(xmr);
        mainPage.setSecondAdressField(btc);
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        mainPage.clickSubmitExchangeButton();
        Thread.sleep(5000);
        System.out.println(driver.getCurrentUrl());
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
        System.out.println(driver.getCurrentUrl());
        assertTrue(driver.getCurrentUrl().contains("https://swapzone.io/transaction/"));
    }
}
