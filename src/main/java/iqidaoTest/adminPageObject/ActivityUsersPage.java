package iqidaoTest.adminPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActivityUsersPage extends BasePage{
	private int activityUsersTableRows = 20;
	
	public ActivityUsersPage(WebDriver driver, String url) {
		super(driver);
		this.url = url;
		this.goTo();
	}
	
	By addUserButtonLocator = By.linkText("添加用户");
	
	
	public WebElement getAddUserButton() {
		return this.dr.findElement(addUserButtonLocator);
	}
	
	public boolean findActivityUserName(String activityUserName) {
		try {
			boolean flag = false;
			for(int row = 1; row < activityUsersTableRows + 1; row++) {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				WebElement actualUserName = this.dr.findElement(By.xpath("html/body/div[1]/div/section[2]/section/div/div[1]/div[1]/table/tbody/tr[" + row + "]/td[3]"));
				String actualUserNameStr = actualUserName.getText();
				if(actualUserNameStr.equals(activityUserName)) {
					flag = true;
					break;
				}
			}
			return flag;
		}catch(NoSuchElementException e) {
			return false;
		}
		
	}
	
	public void addActivityUser(String activityUserName) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.getAddUserButton().click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//1.点击用户名输入框，待出现输入框后输入搜索值，待出现搜索结果后进行点击选择
		new WebDriverWait(this.dr,5).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='add-student']/div[2]/div[1]/div/span[1]")));
		this.dr.findElement(By.xpath(".//*[@id='add-student']/div[2]/div[1]/div/span[1]")).click();
		this.dr.findElement(By.xpath("html/body/span/span/span[1]/input")).sendKeys(activityUserName);
		new WebDriverWait(this.dr,5).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".clearfix.text-center.ajaxSelect")));
		this.dr.findElement(By.cssSelector(".clearfix.text-center.ajaxSelect")).click();
		//2.点击所属赛季，出现选项后点击，进行选择
		this.dr.findElement(By.className("select2-search__field")).click();
//		WebElement ul = this.dr.findElement(By.className("select2-results__options"));
//		new WebDriverWait(this.dr,5).until(ExpectedConditions.presenceOfElementLocated(By.tagName("li")));
		this.dr.findElement(By.xpath("html/body/span/span/span/ul/li[2]")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//3.提交
		this.dr.findElement(By.xpath(".//*[@id='add-student']/div[3]/button[2]")).click();
	}
	
	public boolean deleteActivityUser(String activityUserName) {
		boolean flag = false;
		for(int row = 1; row < activityUsersTableRows + 1; row++) {
			WebElement actualUserName = this.dr.findElement(By.xpath("html/body/div[1]/div/section[2]/section/div/div[1]/div[1]/table/tbody/tr[" + row + "]/td[3]"));
			String actualUserNameStr = actualUserName.getText();
			if(actualUserNameStr.equals(activityUserName)) {
				flag = true;
				WebElement deleteButton = this.dr.findElement(By.xpath("html/body/div[1]/div/section[2]/section/div/div[1]/div[1]/table/tbody/tr[" + row + "]/td[8]"));
				deleteButton.click();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				WebElement deleteConfirmButton = this.dr.findElement(By.xpath(".//*[@id='delete-confirm']"));
				deleteConfirmButton.click();
				return flag;
			}
			
		}
		return flag;
		
	}

}
