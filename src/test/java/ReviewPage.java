import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReviewPage {

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]")
    private WebElement cardCompany;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div[1]/div[2]/div[2]/div[2]/div[1]/input[2]")
    private WebElement yourEmailField;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div[1]/div[2]/div[2]/div[2]/div[1]/input[1]")
    private WebElement yourCompanyField;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div[1]/div[2]/div[2]/div[2]/div[1]/button")
    private WebElement submitButton;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div[1]/div[2]/div[2]/div[2]/div[2]")
    private WebElement info;


    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]")
    private WebElement card;


    ReviewPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickCard(){
        cardCompany.click();
    }

    public void clickSubmitCompany(){
        submitButton.click();
    }

    public void clickReviewCard(){
        card.click();
    }
    public void writeToCompany(String company) {
        yourCompanyField.sendKeys(company);
    }

    public void writeToEmail(String email) {
        yourEmailField.sendKeys(email);
    }
    public String getInfo(){
        return info.getText();
    }
}
