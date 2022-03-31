import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/mariamaksimova/Desktop/chromedriver");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://swapzone.io");
    }
}
