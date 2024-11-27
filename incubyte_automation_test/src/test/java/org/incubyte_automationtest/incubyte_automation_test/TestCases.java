package org.incubyte_automationtest.incubyte_automation_test;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class TestCases {
	
	public static void main(String[] args) throws InterruptedException {
		
		String randomEmailString = Utilities.generateRandomString()+TestData.email;
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(" https://magento.softwaretestingboard.com/");
		driver.manage().window().maximize();
		
        //Testcase1
		driver.findElement(Page_Objects.CREATE_ACCOUNT_LINK).click();
        driver.findElement(Page_Objects.FIRST_NAME_FIELD).sendKeys(TestData.firstName);
        driver.findElement(Page_Objects.LAST_NAME_FIELD).sendKeys(TestData.lastName);
        driver.findElement(Page_Objects.EMAIL_FIELD).sendKeys(randomEmailString);
        driver.findElement(Page_Objects.PASSWORD_FIELD).sendKeys(TestData.password);
        driver.findElement(Page_Objects.CONFIRM_PASSWORD_FIELD).sendKeys(TestData.password);
        Thread.sleep(Duration.ofSeconds(5));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(Page_Objects.CREATE_ACCOUNT_BUTTON));
        driver.findElement(Page_Objects.CREATE_ACCOUNT_BUTTON).click();
        Assert.assertEquals("Thank you for registering with Main Website Store.", driver.findElement(Page_Objects.CONFIRMATION_MSG).getText());
        Assert.assertEquals("Firstname matched!",TestData.firstName.trim(),driver.findElement(Page_Objects.CONTACT_INFO).getText().split(" ")[0]);
        Assert.assertEquals("Lastname matched!",TestData.lastName.trim(),driver.findElement(Page_Objects.CONTACT_INFO).getText().split(" ")[1].split("\n")[0].trim());
        Assert.assertEquals("Email matched!",randomEmailString,driver.findElement(Page_Objects.CONTACT_INFO).getText().split(" ")[1].split("\n")[1].trim());
        
        
        //Testcase2
        driver.findElement(Page_Objects.ACCOUNT_DDL).click();
        driver.findElement(Page_Objects.SIGNOUT_BUTTON).click();
        driver.findElement(Page_Objects.CREATE_ACCOUNT_LINK).click();
        
        
        //Testcase3
        Thread.sleep(Duration.ofSeconds(6));
        driver.findElement(Page_Objects.CREATE_ACCOUNT_LINK).click();
        driver.findElement(Page_Objects.FIRST_NAME_FIELD).sendKeys(TestData.firstName);
        driver.findElement(Page_Objects.LAST_NAME_FIELD).sendKeys(TestData.lastName);
        driver.findElement(Page_Objects.EMAIL_FIELD).sendKeys(randomEmailString);
        driver.findElement(Page_Objects.PASSWORD_FIELD).sendKeys(TestData.password);
        driver.findElement(Page_Objects.CONFIRM_PASSWORD_FIELD).sendKeys(TestData.password);
        Thread.sleep(Duration.ofSeconds(5));
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(Page_Objects.CREATE_ACCOUNT_BUTTON));
        driver.findElement(Page_Objects.CREATE_ACCOUNT_BUTTON).click();
        String accountExistErrorMsg = "There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.";
        Thread.sleep(Duration.ofSeconds(2));
        Assert.assertEquals(accountExistErrorMsg,driver.findElement(Page_Objects.ALREADY_ACCOUNT_WITH_SAME_EMAIL).getText());
        

	}
}
