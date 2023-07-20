package demo;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.CommonPageObject;
import pageObject.DataField;


public class testClass extends CommonPageObject {
    public WebDriver edriver;

    public WebDriverWait ewait;
    DataField dataField;

    public testClass() throws Exception{
        super(CommonPageObject.edriver);
        edriver = CommonPageObject.edriver;
        ewait = CommonPageObject.ewait;
        dataField = new DataField("src/main/java/demo/testClass.xlsx");
    }

    @Test
    public void test() throws Exception {
    //Testcase1:
        //Username
        sendKeys(username, dataField.getData(1,2));
        //Password
        sendKeys(password, dataField.getData(2,2));
        //Button Login
        clickElement(edriver.findElement(By.xpath("//*[@type='submit']")));
        waitUntilElementVisible(dashboard);
        try {
            Assert.assertTrue(dashboard.isDisplayed());
            System.out.println(dataField.getData(0,0));
        }
        catch (Exception e) {
            System.out.println("Testcase1: Login Fail");
        }
        Thread.sleep(5000);

    //Testcase2: Add user into system
        //Click btn_Admin in tabmenu
        clickElement(edriver.findElement(By.xpath("//span[text()='Admin']")));
        //Click btn_add
        clickElement(btn_add);
        //Check page Add user
        waitUntilElementVisible(pg_adduser);
        System.out.println(dataField.getData(4,0) + ". That Page " + pg_adduser.getText() + " show" );
        //Click user role*
        clickElement(se_user_role);
        //Choose value: Admin
        clickElement(edriver.findElement(By.xpath(dataField.getData(5,2))));
        //Click status*
        clickElement(se_status);
        //Choose value: Enabled
        clickElement(edriver.findElement(By.xpath(dataField.getData(6,2))));
        //Input Employee name
        clickElement(i_emName);
        //Choose any value
        i_emName.sendKeys("A");
        Thread.sleep(2000);
        i_emName.sendKeys(Keys.ARROW_DOWN);
        i_emName.sendKeys(Keys.ENTER);
        //Input username
        clickElement(add_username);
        sendKeys(add_username,dataField.getData(7,2));
        //Input password
        clickElement(i_psw);
        sendKeys(i_psw,dataField.getData(8,2));
        //Input password
        clickElement(i_cpsw);
        sendKeys(i_cpsw,dataField.getData(8,2));
        //Save
        clickElement(edriver.findElement(By.xpath("//button[@type='submit']")));
        Thread.sleep(2500);
        System.out.println("Add new user successful, you can access new account!");
        //Login new user
        clickElement(edriver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']")));
        edriver.findElement(By.xpath("//a[text()='Logout']")).click();
            //Input
                //Username
        sendKeys(username, dataField.getData(7,2));
                //Password
        sendKeys(password, dataField.getData(8,2));
        clickElement(edriver.findElement(By.xpath("//*[@type='submit']")));
        System.out.println("Login new account succesful! ");
        Thread.sleep(5000);

    //Testcase3: Update myinfo
        //Access to page myinfo
        clickElement(btnTabs_Myinfo);
        //Assert check page myinfo
        waitUntilElementVisible(my_info);
        try {
            Assert.assertTrue(my_info.isDisplayed());
            System.out.println(dataField.getData(10,0) + "Personal information window frame interface appears");
        }
        catch (Exception e) {
            System.out.println("Command fail");
        }

        //Employee Full Name
        waitUntilElementVisible(firstName);
        updateDetails(firstName, dataField.getData(12,2));
        waitUntilElementVisible(middleName);
        updateDetails(middleName, dataField.getData(12,3));
        waitUntilElementVisible(lastName);
        updateDetails(lastName, dataField.getData(12,4));
        //Nickname
        waitUntilElementVisible("//label[text()='Nickname']/../following-sibling::div/input[@class='oxd-input oxd-input--active']");
        WebElement nickName = edriver.findElement(By.xpath("//label[text()='Nickname']/../following-sibling::div/input[@class='oxd-input oxd-input--active']"));
        updateDetails(nickName,dataField.getData(13,2));
        //Employee Id
        waitUntilElementVisible("//label[text()='Employee Id']/../following-sibling::div/input[@class='oxd-input oxd-input--active']");
        WebElement Emp_Id = edriver.findElement(By.xpath("//label[text()='Employee Id']/../following-sibling::div/input[@class='oxd-input oxd-input--active']"));
        updateDetails(Emp_Id, dataField.getData(14,2));
        //Other Id
        waitUntilElementVisible("//label[text()='Other Id']/../following-sibling::div/input[@class='oxd-input oxd-input--active']");
        WebElement Oth_Id = edriver.findElement(By.xpath("//label[text()='Other Id']/../following-sibling::div/input[@class='oxd-input oxd-input--active']"));
        updateDetails(Oth_Id, dataField.getData(15,2));
        //Driver's License Number
        waitUntilElementVisible("(//label[@class='oxd-label'])[4]/../following-sibling::div/input[@class='oxd-input oxd-input--active']");
        WebElement Driv_Lic = edriver.findElement(By.xpath("(//label[@class='oxd-label'])[4]/../following-sibling::div/input[@class='oxd-input oxd-input--active']"));
        updateDetails(Driv_Lic, dataField.getData(16,2));
        //License Expiry Date
        clickElement(edriver.findElement(By.xpath("(//input[@placeholder='yyyy-mm-dd'])[1]")));
            //Click value clear
        clickElement(edriver.findElement(By.xpath(dataField.getData(17,2))));
        //SSN Number
        waitUntilElementVisible("//label[text()='SSN Number']/../following-sibling::div/input[@class='oxd-input oxd-input--active']");
        WebElement ssn_Num = edriver.findElement(By.xpath("//label[text()='SSN Number']/../following-sibling::div/input[@class='oxd-input oxd-input--active']"));
        updateDetails(ssn_Num,dataField.getData(18,2));
        //SIN Number
        waitUntilElementVisible("//label[text()='SIN Number']/../following-sibling::div/input[@class='oxd-input oxd-input--active']");
        WebElement sin_Num = edriver.findElement(By.xpath("//label[text()='SIN Number']/../following-sibling::div/input[@class='oxd-input oxd-input--active']"));
        updateDetails(sin_Num,dataField.getData(19,2));
        //Nationality
        clickElement(edriver.findElement(By.xpath("(//div[@clear='false'])[1]")));
        //Click value Vietnamese
        clickElement(edriver.findElement(By.xpath(dataField.getData(20,2))));
        //Marital Status: Single
        clickElement(edriver.findElement(By.xpath("//label[text()='Marital Status']/../following-sibling::div")));
        //Click value Single
        clickElement(edriver.findElement(By.xpath(dataField.getData(21,2))));
        //Date of Birth: Optional
        clickElement(edriver.findElement(By.xpath("(//input[@placeholder='yyyy-mm-dd'])[2]")));
        //CLick value Clear
        clickElement(edriver.findElement(By.xpath(dataField.getData(22,2))));
        //Gender: male
        clickElement(Gen_male);
        //Military service : 0
        updateDetails(edriver.findElement(By.xpath("//label[text()='Military Service']/../following-sibling::div/input[@class='oxd-input oxd-input--active']")),dataField.getData(24,2));
        //Smoker: no
        WebElement check_Smo = edriver.findElement(By.xpath("//label[text()='Smoker']/../following-sibling::div/div/label/input[@type='checkbox']"));
        if (check_Smo.isSelected()){
            check_Smo.click();
        } else {
            System.out.println("Value: " + dataField.getData(25,2));
        }
        //Save
        clickElement(edriver.findElement(By.xpath("(//button[@type='submit'])[1]")));
        System.out.println("Update myinfo completed!");
        Thread.sleep(5000);

    //Testcase4: Post newsfeed
        //Click btnBuzz on tabmenu
        clickElement(btnBuzz);
        //Appearing to page buzz newsfeed
        System.out.println(dataField.getData(27,0));
        //Click textarea
        clickElement(textArea);
            //send data to textarea
        textArea.sendKeys(dataField.getData(28,2));
            //complete to mypost
        clickElement(btnPost);
        System.out.println("My post has been uploaded");
        Thread.sleep(5000);

    //Testcase5: Update myinfo
        //Click tabuser
        clickElement(edriver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']")));
        //Click button change password
        clickElement(edriver.findElement(By.xpath("//a[text()='Change Password']")));
        //Appear to page change password
        System.out.println(dataField.getData(30,0));
        //Input Current password
        sendKeys(Curr_psw, dataField.getData(8,2));
        //Input New password
        sendKeys(New_psw, dataField.getData(31,2));
        //Input Confirm new password
        sendKeys(Cnew_psw, dataField.getData(31,2));
        //Save
        clickElement(edriver.findElement(By.xpath("//button[@type='submit']")));
        Thread.sleep(2500);
        System.out.println("Change password completed!, you can create to login with new password!");
        //Login again with new password
        clickElement(edriver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']")));
        edriver.findElement(By.xpath("//a[text()='Logout']")).click();
            //Input
                //Username
        sendKeys(username, dataField.getData(7,2));
                //Password
        sendKeys(password, dataField.getData(31,2));
        clickElement(edriver.findElement(By.xpath("//*[@type='submit']")));
        waitUntilElementVisible(dashboard);
        try {
            Assert.assertTrue(dashboard.isDisplayed());
            System.out.println("Login again succesful! ");
        }
        catch (Exception e) {
            System.out.println("Command fail");
        }
        Thread.sleep(5000);

        closeWeb();

    }
}


