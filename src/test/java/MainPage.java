import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div/div/div[2]/nav/a[3]")
    private WebElement reviewButton;

    MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickToReview() {
        reviewButton.click();
    }


}
