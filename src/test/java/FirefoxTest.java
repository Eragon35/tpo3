import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.*;

public class FirefoxTest {
    FirefoxDriver driver;
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
    //баг на сайте, не работает кнопка оставить коммент
    public void reviewTest() {
        System.setProperty("webdriver.chrome.driver", ConfigReader.getProperty("driverFF"));
        driver = new FirefoxDriver();
        mainPage = new MainPage(driver);
        reviewPage = new ReviewPage(driver);
        projectPage = new ProjectPage(driver);

        driver.get(ConfigReader.getProperty("url"));

        mainPage.clickToReview();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
        reviewPage.clickReviewCard();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
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
    public void registrationTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", ConfigReader.getProperty("driverFF"));
        driver = new FirefoxDriver();
        mainPage = new MainPage(driver);
        authorizationPage = new AuthorizationPage(driver);

        driver.get(ConfigReader.getProperty("url"));

        mainPage.clickToReferralProgram();
        Thread.sleep(1500);
        authorizationPage.clickCreateAccount();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
        authorizationPage.clickSignUpButton();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
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
        System.setProperty("webdriver.chrome.driver", ConfigReader.getProperty("driverFF"));
        driver = new FirefoxDriver();
        mainPage = new MainPage(driver);
        authorizationPage = new AuthorizationPage(driver);

        driver.get(ConfigReader.getProperty("url"));

        mainPage.clickToReferralProgram();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
        authorizationPage.writeToNameForReferral("test");
        authorizationPage.writeToEmailForReferral("test@test.ru");
        authorizationPage.writeToProductForReferral("test");
        authorizationPage.clickGetLink();
        assertTrue(driver.getCurrentUrl().contains("https://swapzone.io/partners"));
    }

    @Test
    public void weAreInTelegramTest() {
        System.setProperty("webdriver.chrome.driver", ConfigReader.getProperty("driverFF"));
        driver = new FirefoxDriver();
        mainPage = new MainPage(driver);
        projectPage = new ProjectPage(driver);

        driver.get(ConfigReader.getProperty("url"));

        mainPage.clickToReferralProgram();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
        projectPage.clickTelegramButton();
    }



    @Test
    public void startLabTestFirstComment() {
        System.setProperty("webdriver.chrome.driver", ConfigReader.getProperty("driverFF"));
        driver = new FirefoxDriver();
        mainPage = new MainPage(driver);
        reviewPage = new ReviewPage(driver);
        projectPage = new ProjectPage(driver);

        driver.get(ConfigReader.getProperty("url"));
        mainPage.clickToReview();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
        reviewPage.clickCard();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
        System.out.println(projectPage.getFirstComment());
    }

    @Test
    public void getInformationBitcoin() {
        System.setProperty("webdriver.chrome.driver", ConfigReader.getProperty("driverFF"));
        driver = new FirefoxDriver();
        mainPage = new MainPage(driver);
        reviewPage = new ReviewPage(driver);
        projectPage = new ProjectPage(driver);

        driver.get(ConfigReader.getProperty("url"));
        mainPage.clickToSupportedCurrencies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
        projectPage.clickChooseBitcoin();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
        System.out.println(projectPage.getBitcoinInformation());
        assertTrue(driver.getCurrentUrl().contains("https://swapzone.io/currencies/bitcoin"));
    }

    @Test
    public void SearchTest() {
        System.setProperty("webdriver.chrome.driver", ConfigReader.getProperty("driverFF"));
        driver = new FirefoxDriver();
        mainPage = new MainPage(driver);
        projectPage = new ProjectPage(driver);

        driver.get(ConfigReader.getProperty("url"));
        mainPage.clickToFag();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
        projectPage.writeToRequest("What is Swapzone");
        projectPage.clickSearch();
        assertEquals("WHAT IS SWAPZONE?", projectPage.getResultSearch());
    }

    @Test
    public void SeeAMABlogTest() {
        System.setProperty("webdriver.chrome.driver", ConfigReader.getProperty("driverFF"));
        driver = new FirefoxDriver();
        mainPage = new MainPage(driver);
        blogPage = new BlogPage(driver);

        driver.get(ConfigReader.getProperty("url"));
        mainPage.clickToBlog();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
        blogPage.clickChooseBlog();
        assertTrue(driver.getCurrentUrl().contains("https://swapzone.io/blog/"));
    }

    @Test
    public void FilterBlogByDateTest() {
        System.setProperty("webdriver.chrome.driver", ConfigReader.getProperty("driverFF"));
        driver = new FirefoxDriver();
        mainPage = new MainPage(driver);
        blogPage = new BlogPage(driver);

        driver.get(ConfigReader.getProperty("url"));
        mainPage.clickToBlog();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
        blogPage.writeToSearch("AMA");
        blogPage.clickSubmit();
        assertTrue(driver.getCurrentUrl().contains("https://swapzone.io/blog/"));
    }

    @Test
    public void ConnectCompanyTest() {
        System.setProperty("webdriver.chrome.driver", ConfigReader.getProperty("driverFF"));
        driver = new FirefoxDriver();
        mainPage = new MainPage(driver);
        reviewPage= new ReviewPage(driver);

        driver.get(ConfigReader.getProperty("url"));

        mainPage.clickToReview();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
        reviewPage.writeToCompany("Test");
        reviewPage.writeToEmail("test@test.ru");
        reviewPage.clickSubmitCompany();
        System.out.println(reviewPage.getInfo());
        assertTrue(driver.getCurrentUrl().contains("https://swapzone.io/reviews"));
    }


    @Test
    public void exchangeBtcToXmrByBestRateTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", ConfigReader.getProperty("driverFF"));
        driver = new FirefoxDriver();
        mainPage = new MainPage(driver);

        driver.get(ConfigReader.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
        mainPage.acceptCoockie();
        mainPage.clickToExchange();
        mainPage.setFirstAdressField(xmr);
        mainPage.setSecondAdressField(btc);
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
        mainPage.clickSubmitExchangeButton();
        driver.manage().timeouts().implicitlyWait(800, TimeUnit.MILLISECONDS);
        //Thread.sleep(5000);
        System.out.println(driver.getCurrentUrl());
        //assertTrue(driver.getCurrentUrl().contains("https://swapzone.io/"));
    }

    @Test
    public void exchangeUsdtToEthFastestTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", ConfigReader.getProperty("driverFF"));
        driver = new FirefoxDriver();
        mainPage = new MainPage(driver);

        driver.get(ConfigReader.getProperty("url"));
        mainPage.acceptCoockie();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
        Thread.sleep(1500);
        mainPage.dropDownMenu();
        mainPage.selectFirstETH();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        mainPage.cleatFirstValue();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
        mainPage.writeFirstValue("10");
        mainPage.cliclToDropdownFilter();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        Thread.sleep(500);
        mainPage.selectFloatingRate();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        Thread.sleep(1000);
        mainPage.selectSecondUsdt();
        Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        mainPage.selectFastestMarket();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
        mainPage.setFirstAdressField(usdt);
        mainPage.setEthAdress(eth);
        Thread.sleep(1000);
        mainPage.clickSubmitExchangeButton1();
        Thread.sleep(5000);
        System.out.println(driver.getCurrentUrl());
        assertTrue(driver.getCurrentUrl().contains("https://swapzone.io/transaction/"));
    }

    @Test
    public void wrongWalletIdTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", ConfigReader.getProperty("driverFF"));
        driver = new FirefoxDriver();
        mainPage = new MainPage(driver);
        driver.get(ConfigReader.getProperty("url"));
        Thread.sleep(3000);
        mainPage.clickToExchange();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        mainPage.setFirstAdressField("111");
        mainPage.setSecondAdressField("222");
        Thread.sleep(2000);
        mainPage.clickSubmitExchangeButton();
        Thread.sleep(2000);
        assertEquals("Address is invalid", mainPage.getError());

    }

    @Test
    public void maxInputValueTest(){
        System.setProperty("webdriver.chrome.driver", ConfigReader.getProperty("driverFF"));
        driver = new FirefoxDriver();
        mainPage = new MainPage(driver);
        driver.get(ConfigReader.getProperty("url"));

        mainPage.cleatFirstValue();
        String input = "9999999999999";
        mainPage.writeFirstValue(input);
        String realValue = mainPage.readFirstInput();
        assertNotSame(input, realValue);
    }

    @Test
    public void strelochkaTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", ConfigReader.getProperty("driverFF"));
        driver = new FirefoxDriver();
        mainPage = new MainPage(driver);

        driver.get(ConfigReader.getProperty("url"));
        Thread.sleep(1000);
        String valueBefore = "10";
        mainPage.cleatFirstValue();
        Thread.sleep(100);
        mainPage.writeFirstValue(valueBefore);
        Thread.sleep(1000);
        mainPage.clickToArrow();
        Thread.sleep(1000);
        mainPage.clickToArrow();
        Thread.sleep(1000);
        String valueAfter = mainPage.readFirstInput();
        assertNotSame(valueBefore, valueAfter);
    }

    @Test
    public void roflanPomoikaTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", ConfigReader.getProperty("driverFF"));
        driver = new FirefoxDriver();
        mainPage = new MainPage(driver);
        driver.get(ConfigReader.getProperty("url"));

        Thread.sleep(1000);
        mainPage.cleatFirstValue();
        mainPage.cleatFirstValue();
        Thread.sleep(100);
        mainPage.writeFirstValue("998");
        Thread.sleep(2000);
        double firstValue = Double.parseDouble(mainPage.readSecondInput());
        Thread.sleep(100);
        mainPage.cleatFirstValue();
        mainPage.writeFirstValue("999");
        Thread.sleep(2000);
        double secondValue = Double.parseDouble(mainPage.readSecondInput());
        assertTrue(firstValue <= secondValue);
    }
}
