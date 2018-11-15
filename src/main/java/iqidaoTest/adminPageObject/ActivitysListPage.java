package iqidaoTest.adminPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


//http://101.132.45.64/admin001/activities
public class ActivitysListPage extends BasePage{
	private int activitiesTableRows = 20;
	public ActivitysListPage(WebDriver driver, String url){
		super(driver);
		this.url = url;
		this.goTo();
	}
	
	By activityMenuLocator = By.xpath("html/body/div[1]/aside/section/ul/li[1]/a/span[1]");
	By activityListMenuLocator = By.xpath("html/body/div[1]/aside/section/ul/li[1]/ul/li/a/span");
	
	By createActivityLocator = By.linkText("创建活动");
	//查找活动
	By activitySearchLocator = By.xpath("//*[@id='activity-query']/div[1]/div/input");
	By activitySearchButton = By.xpath("//*[@id='activity-query']/div[6]/div/div/input");	
	public WebElement getFirstActivityName(){
		return this.dr.findElement(By.xpath(".//*[@id='activity-list']/tbody/tr[1]/td[4]/a"));
	}
	public WebElement getactivitySearchLocator(){
		return this.dr.findElement(activitySearchLocator);
	}
	public WebElement getactivitySearchButton(){
		return this.dr.findElement(activitySearchButton);
	}
	public String getActivityUrlByName(String activityName) {
		boolean flag = false; 
		for(int row = 1; row < activitiesTableRows + 1; row++) {
			WebElement actualActivityName = this.dr.findElement(By.xpath(".//*[@id='activity-list']/tbody/tr[" + row + "]/td[4]"));
			if(actualActivityName.getText().contains(activityName)) {
				flag = true;
				actualActivityName.click();
				break;
			}
		}
		if(flag) {
			String currentUrl = this.dr.getCurrentUrl();
			return currentUrl;
		}else {
			return "can not find the activity";
		}
		
	}
	
	public void getActivityByName(String activityName) {
		this.getactivitySearchLocator().sendKeys(activityName);
		this.getactivitySearchButton().click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.dr.findElement(By.xpath("//*[@id='activity-list']/tbody/tr[1]/td[4]/a/span")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public WebElement getActivityUsersByName(String activityName) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement activityUsers = null; 
		for(int row = 1; row < activitiesTableRows + 1; row++) {
			WebElement actualActivityName = this.dr.findElement(By.xpath(".//*[@id='activity-list']/tbody/tr[" + row + "]/td[4]"));
			System.out.println(actualActivityName);
			if(actualActivityName.getText().contains(activityName)) {
				activityUsers = this.dr.findElement(By.xpath(".//*[@id='activity-list']/tbody/tr[" + row + "]/td[5]"));
				break;
			}
		}
		return activityUsers;
	}
	//查找活动
	
}
