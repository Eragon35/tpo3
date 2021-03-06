import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProjectPage {

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div[1]/div[2]/div[1]/div[4]/div[1]/button")
    private WebElement buttonWriteReview;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div[1]/div[2]/div[1]/div[4]/div[1]/div[3]/div/div[1]/div[1]/input[1]")
    private WebElement yourNameField;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div[1]/div[2]/div[1]/div[4]/div[1]/div[3]/div/div[1]/div[1]/input[2]")
    private WebElement yourEmailField;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div[1]/div[2]/div[1]/div[4]/div[1]/div[3]/div/div[1]/div[1]/input[3]")
    private WebElement yourTransactionField;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div[1]/div[2]/div[1]/div[4]/div[1]/div[3]/div/div[1]/div[2]/input")
    private WebElement yourTitleField;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div[1]/div[2]/div[1]/div[4]/div[1]/div[3]/div/div[1]/div[2]/textarea")
    private WebElement yourReviewField;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div[1]/div[2]/div[1]/div[4]/div[1]/div[3]/div/div[3]/button")
    private WebElement submitButton;

    @FindBy(xpath = "//*[@id=\"cookie-button\"]")
    private WebElement coockieButton;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div[1]/div[2]/div[1]/div[4]/div[1]/div[2]/div[2]")
    private WebElement scoreButton;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div[1]/div[2]/div[1]/div[4]/div[1]/div[3]/div/div[2]")
    private WebElement errorCaptcha;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div[1]/div[2]/div[1]/div[4]/div[2]")
    private WebElement firstComment;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div[3]/div[1]/a[1]/div/div[1]")
    private WebElement chooseBitcoin;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div[1]/div[2]/div[1]/div[3]/p[1]")
    private WebElement informationExchange;

    @FindBy(xpath = "//*[@id=\"__next\"]/footer/div/div/div[2]/div/div[4]/nav/a[2]")
    private WebElement telegram;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div/div[2]/div/div[1]/div/div[2]/input")
    private WebElement yourRequest;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div/div[2]/div/div[1]/div/div[2]/div/img")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div/div[2]/div/div/div[1]/div[2]/div/div/div[1]")
//    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div/div[2]/div/div/div[1]/div[1]/input")
    private WebElement resultSearch;





    ProjectPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickReviewButton() {
        buttonWriteReview.click();
    }

    public void writeToName(String name) {
        yourNameField.sendKeys(name);
    }

    public void writeToEmail(String email) {
        yourEmailField.sendKeys(email);
    }

    public void writeToTransaction(String transaction) {
        yourTransactionField.sendKeys(transaction);
    }

    public void writeToTitle(String title) {
        yourTitleField.sendKeys(title);
    }

    public void writeToReview(String review) {
        yourReviewField.sendKeys(review);
    }

    public void clickSubmit(){
        submitButton.click();
    }

    public String getError(){
        return errorCaptcha.getText();
    }

    public void clickScoreButton(){
        scoreButton.click();
    }
    public void clickTelegramButton(){
        telegram.click();
    }

    public String getFirstComment(){
        return firstComment.getText();
    }


    public void clickChooseBitcoin(){
        chooseBitcoin.click();
    }

    public String getBitcoinInformation(){
        return informationExchange.getText();
    }
    public void acceptCoockie() { coockieButton.click(); }

    public void writeToRequest(String request) {
        yourRequest.sendKeys(request);
    }

    public void clickSearch(){
        searchButton.click();
    }
    public String getResultSearch(){
        return resultSearch.getText();
    }

}
