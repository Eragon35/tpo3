import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReviewPage {

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]")
    private WebElement cardCompany;

    ReviewPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickCard(){
        cardCompany.click();
    }
}
