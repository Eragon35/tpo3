import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthorizationPage {

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div[2]/div/div/div[1]/div/div/div/a[1]")
    private WebElement createAccount;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div/div/div[2]/div/div[1]/input[2]")
    private WebElement yourNameField;

    @FindBy(xpath = "//*[@id=\"blockContact\"]/div/div[1]/input[2]")
    private WebElement yourNameForReferralField;

    @FindBy(xpath = "//*[@id=\"blockContact\"]/div/div[1]/textarea")
    private WebElement yourProductReferralField;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div/div/div[2]/div/div[1]/input[1]")
    private WebElement yourEmailField;

    @FindBy(xpath = "//*[@id=\"blockContact\"]/div/div[1]/input[1]")
    private WebElement yourEmailForReferralField;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div/div/div[2]/div/div[1]/input[3]")
    private WebElement yourPasswordField;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div/div/div[2]/div/div[1]/input[4]")
    private WebElement checkPasswordField;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div/div/div[2]/div/div[2]/div[1]/label/span[1]")
    private WebElement coockieButton;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div/div/div[2]/div/div/div[3]/a[1]")
    private WebElement signUpButton;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div/div/div[2]/div/button")
    private WebElement submitButton;


    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div/div/div[2]/div/div[3]")
    private WebElement errorCaptcha;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div[6]/div/div/div[2]/div/div/div[2]")
    private WebElement info;


    @FindBy(xpath = "//*[@id=\"blockContact\"]/div/div[1]/a")
    private WebElement getLinkButton;

    AuthorizationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void writeToName(String name) {
        yourNameField.sendKeys(name);
    }

    public void writeToEmail(String email) {
        yourEmailField.sendKeys(email);
    }

    public void writeToPassword(String password) {
        yourPasswordField.sendKeys(password);
    }

    public void writeToCheckPassword(String password) {
        checkPasswordField.sendKeys(password);
    }

    public void acceptCoockie() { coockieButton.click(); }

    public void clickSignUpButton() {
        signUpButton.click();
    }
    public void clickSubmit() {
        submitButton.click();
    }

    public String getError(){
        return errorCaptcha.getText();
    }

    public String getInfo(){
        return info.getText();
    }

    public void writeToNameForReferral(String name) {
        yourNameForReferralField.sendKeys(name);
    }

    public void writeToEmailForReferral(String email) {
        yourEmailForReferralField.sendKeys(email);
    }

    public void writeToProductForReferral(String product) {
        yourProductReferralField.sendKeys(product);
    }


    public void clickGetLink() {
        getLinkButton.click();
    }

    public void clickCreateAccount() {
        createAccount.click();
    }

}
