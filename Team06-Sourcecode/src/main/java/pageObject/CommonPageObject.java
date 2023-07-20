package pageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonPageObject {
    public static WebDriver edriver;

    public static WebDriverWait ewait;

//Testcase1: Login Successful
    //username
    @FindBy(how = How.XPATH, using = "//input[@name='username']")
    public WebElement username;
    //password
    @FindBy(how = How.XPATH, using = "//input[@name='password']")
    public WebElement password;
    //Element Dashboard
    @FindBy(how = How.XPATH, using = "//span[text()='Dashboard']")
    public  WebElement dashboard;

//Testcase2: Add user into system
    //Button add
    @FindBy(how = How.XPATH, using = "//div[@class='orangehrm-header-container']/button[@type='button']")
    public WebElement btn_add;
    //Page add user:
    @FindBy(how = How.XPATH, using = "//h6[text()='Add User']")
    public WebElement pg_adduser;
    //Select user role
    @FindBy(how = How.XPATH, using = "(//div[text()='-- Select --'])[1]")
    public WebElement se_user_role;
    //Select status
    @FindBy(how = How.XPATH, using = "(//div[@class='oxd-select-text oxd-select-text--active'])[2]")
    public WebElement se_status;
    //Input Employee Name
    @FindBy(how = How.XPATH, using = "//input[@placeholder='Type for hints...']")
    public WebElement i_emName;
    //Input Username
    @FindBy(how = How.XPATH, using = "(//input[@autocomplete='off'])[1]")
    public WebElement add_username;
    //Input Password
    @FindBy(how = How.XPATH, using = "(//input[@type='password'])[1]")
    public WebElement i_psw;
    //Input confirm password
    @FindBy(how = How.XPATH, using = "(//input[@type='password'])[2]")
    public WebElement i_cpsw;

//Testcase3: Update myInfo
    //Click Myinfo
    @FindBy(how = How.XPATH, using = "//a[@href='/web/index.php/pim/viewMyDetails']")
    public WebElement btnTabs_Myinfo;
    //tab myinfo
    @FindBy(how = How.XPATH, using = "//h6[text()='Personal Details']")
    public WebElement my_info;
    //Fullname
    @FindBy(how = How.XPATH, using = "//input[@name='firstName']")
    public WebElement firstName;
    @FindBy(how = How.XPATH, using = "//input[@name='middleName']")
    public WebElement middleName;
    @FindBy(how = How.XPATH, using = "//input[@name='lastName']")
    public WebElement lastName;
    //Gender: Female
    @FindBy(how = How.XPATH, using = "//label[text()='Gender']/../following-sibling::div/div[1]")
    public WebElement Gen_male;

//Testcase4: Post newsfeed
    //Page Buzz newsfeed
    @FindBy(how = How.XPATH,using = "//div[@class='oxd-tab-bar']/a[text()='Buzz Newsfeed']")
    public WebElement page_buzznewsfeed;
    //Btn_buzz tabmenu
    @FindBy(how = How.XPATH,using = "//a[@href=\"/web/index.php/buzz/viewBuzz\"]")
    public WebElement btnBuzz;
    //Textarea
    @FindBy(how = How.XPATH,using = "//textarea[@rows='1']")
    public WebElement textArea;
    //btnPost
    @FindBy(how = How.XPATH,using = "//button[@class='oxd-button oxd-button--medium oxd-button--main']")
    public WebElement btnPost;

//Testcase5:
    //Password's element change frame:

    //Current password
    @FindBy(how = How.XPATH, using = "(//input[@type='password'])[1]")
    public WebElement Curr_psw;
    //New passowrd
    @FindBy(how = How.XPATH, using = "(//input[@type='password'])[2]")
    public WebElement New_psw;
    //Confirm new password
    @FindBy(how = How.XPATH, using = "(//input[@type='password'])[3]")
    public WebElement Cnew_psw;



    public CommonPageObject(WebDriver driver) throws Exception {
        edriver = new ChromeDriver();
        PageFactory.initElements(edriver,this);
        ewait = new WebDriverWait(edriver, Duration.ofSeconds(5));
        edriver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }

    public void closeWeb() throws Exception {
        edriver.close();
    }

    public void sendKeys(WebElement element, String text) {
        waitUntilElementVisible(element);
        element.sendKeys(text);
    }

    public void clickElement(WebElement element) {
        waitUntilElementVisible(element);
        element.click();
    }

    public void updateDetails(WebElement element, String text) {
        element.click();
        element.sendKeys(Keys.CONTROL + "A");
        element.sendKeys(Keys.BACK_SPACE);
        element.sendKeys(text);
    }


    public void waitUntilElementVisible(WebElement element) {
        int tryTimes = 0;
        while (tryTimes < 2) {
            try {
                ewait.until(ExpectedConditions.visibilityOf(element));
                break;
            } catch (StaleElementReferenceException se) {
                tryTimes++;
                if (tryTimes == 2)
                    throw se;
            }
        }
    }
    public void waitUntilElementVisible(String path) throws Exception{
        int tryTimes = 0;
        while (tryTimes < 2){
            try {
                WebElement element = edriver.findElement(By.xpath(path));
                ewait.until(ExpectedConditions.visibilityOf(element));
                break;
            }
            catch (StaleElementReferenceException se) {
                tryTimes ++;
                if (tryTimes == 2)
                    throw se;
            }
        }
    }
}
