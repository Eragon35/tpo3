import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlogPage {
    @FindBy(xpath = "//*[@id=\"block-3\"]/ul/li[2]/a")
    private WebElement chooseBlogName;

    @FindBy(xpath = "//*[@id=\"wp-block-search__input-1\"]")
    private WebElement searchBlog;

    @FindBy(xpath = "//*[@id=\"block-5\"]/form/div/button")
    private WebElement submitButton;


    @FindBy(xpath = "//*[@id=\"crypto_short_by_date\"]")
    private WebElement filterDateBlog;



    BlogPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickChooseBlog(){
        chooseBlogName.click();
    }

    public void clickSubmit(){
        submitButton.click();
    }
    public void writeToSearch(String name) {
        searchBlog.sendKeys(name);
    }

}
