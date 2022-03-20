import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Path resourceDirectory = Paths.get("src","main","resources");
        String driverPath = resourceDirectory.toFile().getAbsolutePath().concat("\\chromedriver.exe");

        System.out.println(driverPath);
        System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriver webDriver = new ChromeDriver();

        webDriver.get("https://swapzone.io");
    }
}
