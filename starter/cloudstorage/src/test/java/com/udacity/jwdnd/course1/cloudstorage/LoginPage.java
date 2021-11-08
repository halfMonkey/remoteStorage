package com.udacity.jwdnd.course1.cloudstorage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(id = "inputUsername")
	private WebElement userName;
	
	@FindBy(id = "inputPassword")
	private WebElement password;
	
	@FindBy(id = "login")
	private WebElement loginButton;
	
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
	
	public void login(String userName, String password) {
		this.userName.clear();
		this.password.clear();
		this.userName.sendKeys(userName);
		this.password.sendKeys(password);
		this.loginButton.click();
	}
	
	
	
	

}
