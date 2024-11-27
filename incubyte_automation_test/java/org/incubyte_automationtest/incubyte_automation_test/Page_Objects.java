package org.incubyte_automationtest.incubyte_automation_test;

import org.openqa.selenium.By;

public class Page_Objects {
	public static final By CREATE_ACCOUNT_LINK = By.xpath("//a[contains(text(),'Create an Account')]");
    public static final By FIRST_NAME_FIELD = By.xpath("//input[@id='firstname']");
    public static final By LAST_NAME_FIELD = By.xpath("//input[@id='lastname']");
    public static final By EMAIL_FIELD = By.xpath("//input[@name='email']");
    public static final By PASSWORD_FIELD = By.xpath("//input[@id='password']");
    public static final By CONFIRM_PASSWORD_FIELD = By.xpath("//input[@id='password-confirmation']");
    public static final By CREATE_ACCOUNT_BUTTON = By.xpath("//button[@class='action submit primary']");
    public static final By CONFIRMATION_MSG = By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']");
    public static final By CONTACT_INFO = By.xpath("//p[contains(text(),'testUser')]");
    public static final By ACCOUNT_DDL = By.xpath("//button[@class='action switch']");
    public static final By SIGNOUT_BUTTON = By.xpath("//a[contains(text(),'Sign Out ')]");
    public static final By ALREADY_ACCOUNT_WITH_SAME_EMAIL = By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']");
    

}
