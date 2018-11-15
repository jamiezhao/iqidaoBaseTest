package iqidaoTest.adminPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActivityComboPage extends BasePage {

	public ActivityComboPage(WebDriver driver, String url) {
		// TODO Auto-generated constructor stub
		// TODO Auto-generated constructor stub
		super(driver);
		this.url = url;
		this.goTo();
	}

	// 添加续报
	By AddButton = By.xpath("/html/body/div/div/section[2]/div/header/h3/a");
	By CombonameButton = By.xpath("//*[@id='add_combo']/div[2]/div/div/div/span[1]/span[1]/span");
	By ComboInput = By.xpath("/html/body/span/span/span[1]/input");
	By SaveCombotButton = By.xpath("//*[@id='add_combo']/div[3]/button[2]");
	// 添加展示时间
	By TimeStartInput = By.name("startTime");
	By TimeEndInput = By.name("endTime");
	By SaveTimeButton = By.xpath("/html/body/div/div/section[2]/div/div[1]/form/div[3]/div/button");

	public WebElement getAddButton() {
		return this.dr.findElement(AddButton);
	}

	public WebElement getCombonameButton() {
		return this.dr.findElement(CombonameButton);
	}

	public WebElement getComboInput() {
		return this.dr.findElement(ComboInput);
	}

	public WebElement getSaveCombotButton() {
		return this.dr.findElement(SaveCombotButton);
	}

	public WebElement getTimeStartInput() {
		return this.dr.findElement(TimeStartInput);
	}

	public WebElement getTimeEndInput() {
		return this.dr.findElement(TimeEndInput);
	}

	public WebElement getSaveTimeButton() {
		return this.dr.findElement(SaveTimeButton);
	}

	// 查找源活动进入续报条目添加界面
	public void SearchActivity(String activityName) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.dr.findElement(By.xpath("//*[@id='activity-query']/div[1]/div/input")).sendKeys(activityName);
		this.dr.findElement(By.xpath("//*[@id='activity-query']/div[6]/div/div/input")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.dr.findElement(By.xpath(".//*[@id='activity-list']/tbody/tr[1]/td[4]")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.dr.findElement(By.xpath("/html/body/div[1]/div/section[2]/section[1]/a[3]")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public WebDriver CreatActivityCombo(String Combonamemod, String combostartime, String comboendtime) {
		// 添加续报
		this.getAddButton().click();
		this.getCombonameButton().click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getComboInput().sendKeys(Combonamemod);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getComboInput().sendKeys(Keys.ENTER);
		this.getSaveCombotButton().click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 输入展示时间
		this.getTimeStartInput().clear();
		this.getTimeStartInput().sendKeys(combostartime);
		this.getTimeEndInput().clear();
		this.getTimeEndInput().sendKeys(comboendtime);
		this.getSaveTimeButton().click();
		return this.dr;
	}
}
