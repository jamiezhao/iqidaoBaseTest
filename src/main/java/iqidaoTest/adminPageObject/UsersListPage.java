package iqidaoTest.adminPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UsersListPage extends BasePage{
	public UsersListPage(WebDriver driver, String url) {
		super(driver);
		this.url = url;
		this.goTo();
	}
	
	By addUserButtonLocator = By.linkText("添加新用户");
	By userNameLocator = By.xpath(".//*[@id='user_add']/div[2]/div/div[1]/div/input");
	By mobilePhoneLocator = By.xpath(".//*[@id='user_add']/div[2]/div/div[2]/div/input");
	By userGroupLocator = By.xpath("//*[@id=\"user_add\"]/div[2]/div/div[3]/div/select");
	By passwordLocator = By.xpath(".//*[@id='user_add']/div[2]/div/div[5]/div/input");
	By submitButtonLocator = By.xpath(".//*[@id='user_add']/div[3]/button[2]");
	
	public WebElement getAddUserButton() {
		return this.dr.findElement(addUserButtonLocator);
	}
	
	public WebElement getUserNameField() {
		return this.dr.findElement(userNameLocator);
	}
	
	public WebElement getMobilePhoneField() {
		return this.dr.findElement(mobilePhoneLocator);
	}
	
	public Select getUserGroupSelect() {
		Select userGroupSelect = new Select(this.dr.findElement(userGroupLocator));
		return userGroupSelect;
	}
	
	public WebElement getPasswordField() {
		return this.dr.findElement(passwordLocator);
	}
	
	public WebElement getSubmitButton() {
		return this.dr.findElement(submitButtonLocator);
	}
	
	public void addUser(String userRealName, String mobilePhone, String userGroup, String userPassword) {
		this.getAddUserButton().click();
		this.getUserNameField().sendKeys(userRealName);
		this.getMobilePhoneField().sendKeys(mobilePhone);
		Select userGroupSelect = this.getUserGroupSelect();
		userGroupSelect.selectByValue(userGroup);	//100为客服身份
		this.getPasswordField().sendKeys(userPassword);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.getSubmitButton().click();
	}

}
