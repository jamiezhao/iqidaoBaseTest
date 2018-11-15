package iqidaoTest.WebFrontObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import iqidaoTest.adminPageObject.AdminHomePage;
import iqidaoTest.adminPageObject.BasePage;

public class LoginObject extends BasePage{

	public LoginObject(WebDriver driver, String url) {
		// TODO Auto-generated constructor stub
		// TODO Auto-generated constructor stub
		super(driver);
		this.url = url;
		this.goTo();
	}
	By LoginButton = By.id("header-signin");
	By UserNameInput=By.name("key");
	By PasswordInput=By.xpath("//*[@id='signin-dialog-signin']/div[1]/form/div[2]/input");
	By captchaInput = By.xpath("//*[@id='signin-dialog-signin']/div[1]/form/div[3]/input");
	By submitbutton = By.id("signin-btn");
	public WebElement getLoginButton(){
		return this.dr.findElement(LoginButton);
	}
	
	public WebElement getUserNameInput(){
		return this.dr.findElement(UserNameInput);
	}
	
	public WebElement getPasswordInput(){
		return this.dr.findElement(PasswordInput);
	}
	
	public WebElement getcaptchaInput(){
		return this.dr.findElement(captchaInput);
	}
	public WebElement getsubmitbutton(){
		return this.dr.findElement(submitbutton);
	}
	public void Login(String frontName, String passWord){
		this.getLoginButton().click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getUserNameInput().sendKeys(frontName);
		this.getPasswordInput().sendKeys(passWord);
		this.getcaptchaInput().sendKeys(CAPTCHA);
		this.getsubmitbutton().click();

		
	}
}
