import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlogPage {
    @FindBy(xpath = "//*[@id=\"search_crypto_by_tag-2\"]/div/li[2]")
    private WebElement chooseBlogName;

    @FindBy(xpath = "//*[@id=\"email___ecd412e904309dcce66177488240b016_0_891778450\"]")
    private WebElement yourEmail;

    @FindBy(xpath = "//*[@id=\"ctct-submitted_0_1496985149\"]")
    private WebElement submitButton;

    @FindBy(xpath = "//*[@id=\"ctct-form-wrapper-0\"]/p")
    private WebElement submitInfo;

    @FindBy(xpath = "//*[@id=\"crypto_short_by_date\"]")
    private WebElement filterDateBlog;



    BlogPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickChooseBlog(){
        chooseBlogName.click();
    }

    public void clickFilterDate(){
        filterDateBlog.click();
    }

    public void clickSubmit(){
        submitButton.click();
    }

    public void writeToEmail(String email) {
        yourEmail.sendKeys(email);
    }

    public String getInfo(){
        return submitInfo.getText();
    }
}
