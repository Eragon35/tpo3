import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div/div/div[2]/nav/a[3]")
    private WebElement reviewButton;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div/div/div[2]/nav/a[2]")
    private WebElement supportCurrenciesButton;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div/div/div[2]/nav/a[5]")
    private WebElement fagButton;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div/div/div[2]/nav/a[7]")
    private WebElement blogButton;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div/div/div[2]/nav/a[4]")
    private WebElement referralProgram;


    @FindBy(xpath = "//*[contains(@class, 'button styles_second__2bse8')]")
    private WebElement exchangeButton;

    @FindBy(xpath = "//*[contains(@class, 'styles_textarea__13zWC styles_exchangeFormInput__11KtF')]")
    private WebElement firstAdressField;

    @FindBy(xpath = "(//*[contains(@class, 'styles_textarea__13zWC styles_exchangeFormInput__11KtF')])[3]")
    private WebElement secondAdressField;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div[2]/div/div[3]/div/div[8]/span/button")
    private  WebElement submitExchangeButton;

    @FindBy(xpath = "//*[@id=\"cookie-button\"]")
    private WebElement coockieButton;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div[2]/div/div[1]/div[1]/div[2]/div[1]/div[2]")
    private WebElement dropDownFirstCoin;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div[2]/div/div[1]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[3]")
    private WebElement ethLine;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div[2]/div/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/div[3]/div[3]")
//    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div[2]/div/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/div[3]/div[3]")
    private WebElement usdtLine;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div[2]/div/div[1]/div[2]/div[2]/div/div[2]")
    private WebElement dropDownSecondCoin;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/div/div/div[2]")
    private WebElement fastestMarket;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div/div[2]/div[2]/span/button")
    private WebElement fastestExchangeButton;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div[2]/div/div[3]/div/div[5]/div[1]/div[1]/textarea")
    private WebElement ethAdress;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div[2]/div/div[1]/div[1]/div[2]/div/div[1]/label/input")
    private WebElement firstInput;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div[2]/div/div[1]/div[2]/div[2]/div/div[1]")
    private WebElement secondInput;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div[2]/div/div[1]/div[3]/div[2]/div[1]/div[1]")
    private WebElement dropDownFilter;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div[2]/div/div[1]/div[3]/div[2]/div[2]/div[2]/div[1]/div/ul/li[2]/div")
    private WebElement fixedRateCheckbox;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div[2]/div/div[1]/div[3]/div[2]/div[2]/div[2]/div[1]/div/ul/li[3]/div")
    private WebElement floatedRateWithTaxesCheckbox;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div[2]/div/div[1]/img")
    private WebElement arrow;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div[2]/div/div[3]/div/div[3]/div[2]")
    private WebElement error;





    MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickToReview() {
        reviewButton.click();
    }
    public void clickToFag() {
        fagButton.click();
    }

    public void clickToSupportedCurrencies() {
        supportCurrenciesButton.click();
    }

    public void clickToReferralProgram() {
        referralProgram.click();
    }

    public void clickToBlog() {
        blogButton.click();
    }

    public void clickToExchange() { exchangeButton.click(); }

    public void setFirstAdressField(String adr) { firstAdressField.sendKeys(adr); }

    public void setSecondAdressField(String adr) { secondAdressField.sendKeys(adr); }

    public void setEthAdress(String adr) { ethAdress.sendKeys(adr);}

    public void clickSubmitExchangeButton() { submitExchangeButton.click(); }

    public void acceptCoockie() { coockieButton.click(); }

    public void selectFirstETH() {
        dropDownFirstCoin.click();
        ethLine.click();
    }

    public void selectSecondUsdt() {
        dropDownSecondCoin.click();
        usdtLine.click();
    }

    public void selectFastestMarket() {
        fastestMarket.click();
        fastestExchangeButton.click();
    }


    public void cleatFirstValue() {
        firstInput.clear();
    }
    public void writeFirstValue(String value) {
        firstInput.sendKeys(value);
    }

    public void cliclToDropdownFilter() {
        dropDownFilter.click();
    }

    public void selectFloatingRate(){
        fixedRateCheckbox.click();
        floatedRateWithTaxesCheckbox.click();
    }

    public String readFirstInput() {
        return firstInput.getText();
    }

    public String readSecondInput() {
        return secondInput.getText();
    }

    public String getError() {
        return error.getText();
    }

    public void clickToArrow() { arrow.click();}

}
