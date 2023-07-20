package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager web = WebDriverManager.chromedriver();
        web.setup();
        ChromeDriver dr = new ChromeDriver();
        dr.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(15));

        System.out.println("---------------------Flow1---------------------");
        //Flow1: Login
            //1.1:input and label username
        WebElement u_name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
        u_name.sendKeys("Admin");
        WebElement lbl_username = dr.findElement(By.xpath("//label[text()='Username']"));
        System.out.println("Label u_name: " + lbl_username.getText());

            //1.2:input password
        WebElement psword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
        psword.sendKeys("admin123");
        WebElement lbl_psword = dr.findElement(By.xpath("//label[text()='Password']"));
        System.out.println("Label psword: " + lbl_psword.getText());
            //1.3: login's label and click to button Login
        WebElement btnLogin = dr.findElement(By.xpath("//button[@type='submit']"));
        wait.until(ExpectedConditions.visibilityOf(btnLogin));
        wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
        System.out.println("Label Login: " + btnLogin.getText()); // Label login
        btnLogin.click();


        System.out.println("---------------------Flow2---------------------");
        //Flow2: Click vào My info
        WebElement btnTab_Myinfo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/web/index.php/pim/viewMyDetails']")));
        System.out.println("Tab title: " + btnTab_Myinfo.getText());
        btnTab_Myinfo.click();

        Thread.sleep(10000);
        System.out.println("---------------------Flow3---------------------");
        //Flow3: Update information
            //Fullname
              //label fullname
        WebElement lbl_fullname = dr.findElement(By.xpath("//label[text()='Employee Full Name']"));
        System.out.println("Label fullname: " + lbl_fullname.getText());
                //FirstName : Automation
        WebElement i_fname = dr.findElement(By.xpath("//input[@placeholder='First Name']"));
        i_fname.sendKeys(Keys.CONTROL + "A");
        i_fname.sendKeys(Keys.BACK_SPACE);
        i_fname.sendKeys("Automation");

                //MiddleName : STT group
        WebElement i_mname = dr.findElement(By.xpath("//input[@placeholder='Middle Name']"));
        i_mname.sendKeys(Keys.CONTROL + "A");
        i_mname.sendKeys(Keys.BACK_SPACE);
        i_mname.sendKeys("Group 6");
                //LastName : Lesson
        WebElement i_lname = dr.findElement(By.xpath("//input[@placeholder='Last Name']"));
        i_lname.sendKeys(Keys.CONTROL + "A");
        i_lname.sendKeys(Keys.BACK_SPACE);
        i_lname.sendKeys("3");
            //Nickname : Testing
        WebElement lbl_Nname = dr.findElement(By.xpath("//label[text()='Nickname']"));
        System.out.println("Label lbl_Nname: " + lbl_Nname.getText());
        WebElement i_Nickname = dr.findElement(By.xpath("//label[text()='Nickname']/../following-sibling::div/input[@class='oxd-input oxd-input--active']"));
        i_Nickname.sendKeys(Keys.CONTROL + "A");
        i_Nickname.sendKeys(Keys.BACK_SPACE);
        i_Nickname.sendKeys("Testing");

            //Employee id : STT group
        WebElement lbl_EmId = dr.findElement(By.xpath("//label[text()='Employee Id']"));
        System.out.println("Label lbl_EmID: " + lbl_EmId.getText());
        WebElement i_EmId = dr.findElement(By.xpath("//label[text()='Employee Id']/../following-sibling::div/input[@class='oxd-input oxd-input--active']"));
        i_EmId.sendKeys(Keys.CONTROL + "A");
        i_EmId.sendKeys(Keys.BACK_SPACE);
        i_EmId.sendKeys("6");

            //Other id : STT group * 10
        WebElement lbl_Otherid = dr.findElement(By.xpath("//label[text()='Other Id']"));
        System.out.println("Label lbl_Otherid: " + lbl_Otherid.getText());
        WebElement i_Otherid = dr.findElement(By.xpath("//label[text()='Other Id']/../following-sibling::div/input[@class='oxd-input oxd-input--active']"));
        i_Otherid.sendKeys(Keys.CONTROL + "A");
        i_Otherid.sendKeys(Keys.BACK_SPACE);
        i_Otherid.sendKeys("60");

            //Driver's License Number : 11111
        WebElement lbl_DrivLi = dr.findElement(By.xpath("(//label[@class='oxd-label'])[4]"));
        System.out.println("Label lbl_DrivLi: " + lbl_DrivLi.getText());
        WebElement i_DrivLi = dr.findElement(By.xpath("(//label[@class='oxd-label'])[4]/../following-sibling::div/input[@class='oxd-input oxd-input--active']"));
        i_DrivLi.sendKeys(Keys.CONTROL + "A");
        i_DrivLi.sendKeys(Keys.BACK_SPACE);
        i_DrivLi.sendKeys("11111");

            //License Expiry Date : Today
        WebElement lbl_ex_date = dr.findElement(By.xpath("//label[text()='License Expiry Date']"));
        System.out.println("Label ex date: " + lbl_ex_date.getText());
        WebElement i_ex_date = dr.findElement(By.xpath("(//input[@placeholder='yyyy-mm-dd'])[1]"));
        i_ex_date.click();
        WebElement value_today = dr.findElement(By.xpath("//div[text()='Today']"));
        value_today.click();

            //SSN Number : 300
        WebElement lbl_SNum = dr.findElement(By.xpath("//label[text()='SSN Number']"));
        System.out.println("Label lbl_SNum: " + lbl_SNum.getText());
        WebElement i_SNum = dr.findElement(By.xpath("//label[text()='SSN Number']/../following-sibling::div/input[@class='oxd-input oxd-input--active']"));
        i_SNum.sendKeys(Keys.CONTROL + "A");
        i_SNum.sendKeys(Keys.BACK_SPACE);
        i_SNum.sendKeys("300");

            //Nationality : optional
        WebElement lbl_Nat = dr.findElement(By.xpath("//label[text()='Nationality']"));
        System.out.println("Label lbl_Nat: " + lbl_Nat.getText());
        WebElement i_Nat = dr.findElement(By.xpath("(//div[@clear='false'])[1]"));
        i_Nat.click();
        WebElement value_Belgian = dr.findElement(By.xpath("//span[text()='Belgian']"));
        value_Belgian.click();

            //Marital Status : Single
        WebElement lbl_Marti = dr.findElement(By.xpath("//label[text()='Marital Status']"));
        System.out.println("Label lbl_Marti: " + lbl_Marti.getText());
        WebElement i_status = dr.findElement(By.xpath("//label[text()='Marital Status']/../following-sibling::div"));
        i_status.click();
        WebElement value_single = dr.findElement(By.xpath("//label[text()='Marital Status']/../following-sibling::div/div[@class='oxd-select-wrapper']/div[@role]/div/span[text()='Single']"));
        value_single.click();

            //Date of Birth : optional
        WebElement lbl_DoB = dr.findElement(By.xpath("//label[text()='Date of Birth']"));
        System.out.println("Label lbl_DoB: " + lbl_DoB.getText());
        WebElement i_DoB = dr.findElement(By.xpath("(//input[@placeholder='yyyy-mm-dd'])[2]"));
        i_DoB.click();
        WebElement value_clear = dr.findElement(By.xpath("//div[text()='Clear']"));
        value_clear.click();

            //Gender : Female
        WebElement lbl_Gender = dr.findElement(By.xpath("//label[text()='Gender']"));
        System.out.println("Label lbl_Gender: " + lbl_Gender.getText());
        WebElement rad_Gender = dr.findElement(By.xpath("//label[text()='Gender']/../following-sibling::div/div[2]"));
        rad_Gender.click();

            //Military service : 1
        WebElement lbl_Mil = dr.findElement(By.xpath("//label[text()='Military Service']"));
        System.out.println("Label lbl_Mil: " + lbl_Mil.getText());
        WebElement i_Mil = dr.findElement(By.xpath("//label[text()='Military Service']/../following-sibling::div/input[@class='oxd-input oxd-input--active']"));
        i_Mil.sendKeys(Keys.CONTROL + "A");
        i_Mil.sendKeys(Keys.BACK_SPACE);
        i_Mil.sendKeys("1");

            //Smoker: No
        WebElement lbl_Smo = dr.findElement(By.xpath("//label[text()='Smoker']"));
        System.out.println("Label lbl_Smo: " + lbl_Smo.getText());
        WebElement check_Smo = dr.findElement(By.xpath("//label[text()='Smoker']/../following-sibling::div/div/label/input[@type='checkbox']"));
        if (check_Smo.isSelected()){
            check_Smo.click();
        } else {
            System.out.println("Value: No Smoker");
        }
            //Save
        WebElement btn_save = dr.findElement(By.xpath("(//button[@type='submit'])[1]"));
        btn_save.click();

        //Flow 4: Logout
        WebElement tab_user = dr.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']"));
        tab_user.click();
        WebElement Lgout = dr.findElement(By.xpath("//a[text()='Logout']"));
        System.out.println("Label Lgout: " + Lgout.getText());
        Lgout.click();

    }
}


//        WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(30));
//        WebElement btnLogin = dr.findElement(By.xpath("//button[@type='submit']"));
//        wait.until(ExpectedConditions.visibilityOf(btnLogin));
//        wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
//        btnLogin.click();














//  //Set up WebDriverManager
//    WebDriverManager.chromedriver().setup();
//
//    //Create chrome's options object
//    ChromeOptions options = new ChromeOptions();
//
//    //Remove all web's popups return it is zero value
//    HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
//    chromePrefs.put("profile.default_content_settings.popups", 0);
//
//    //Save as the folder you want to save
//    String downloadFilepath = "C:\\test";
//    chromePrefs.put("download.default_directory", downloadFilepath);
//    options.setExperimentalOption("prefs", chromePrefs);
//
//    //Create variable driver
//    WebDriver driver = new ChromeDriver(options);
//    //To expand the web window to full screen
//    driver.manage().window().maximize();;
//    //Web test to download
//    driver.get("https://omayo.blogspot.com/p/page7.html");
//    //Find the element to download the file's text type
//    driver.findElement(By.linkText("ZIP file")).click();
//
//    Thread.sleep(5000);
//    File file = new File(downloadFilepath+"\\DownloadDemo-master.zip");
//    if(file.exists()) {
//        System.out.println("File got successfully downloaded");
//    }else{
//        System.out.println("File is not downloaded");
//    }


//Phần đầu
    //













//WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(20));
//
//        WebElement btnLogin = dr.findElement(By.xpath("//button[@type='submit']"));
//        wait.until(ExpectedConditions.visibilityOf(btnLogin));
//        wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
//
//        btnLogin.click();







//        // Set Chrome options
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-extensions"); // Disable browser extensions
//
//        // Instantiate ChromeDriver
//        WebDriver driver = new ChromeDriver(options);
//
//        // Navigate to the webpage
//        driver.get("http://omayo.blogspot.com/p/page7.html");
//        Thread.sleep(10000);
//
//        // Find the download link by xpath
//        WebElement downloadLink = driver.findElement(By.xpath("//a[@href='https://github.com/arunmotoori/DownloadDemo/archive/master.zip']"));
//
//        // Set the download directory
//        String downloadDirectory = "C:\\test"; // Đường dẫn đến thư mục yêu cầu
//
//        // Set ChromeOptions to specify download directory
//        options.addArguments("--download.default_directory=" + downloadDirectory);
//
//
//        // Download the file
//       downloadLink.click();



