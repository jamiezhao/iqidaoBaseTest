package iqidaoTest.adminPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActivityTestExam extends BasePage {

	public ActivityTestExam(WebDriver driver, String url) {
		super(driver);
		this.url = url;
		this.goTo();
		// TODO Auto-generated constructor stub
	}
	// 添加入学测配置
	By ActivityTestButton = By.xpath("/html/body/div[1]/div/section[2]/section[1]/a[4]");
	By TestAddButton = By.xpath("/html/body/div/div[1]/section[2]/div[1]/header/a");
	By AcitivityTest = By.xpath("//*[@id='copy-config']/div[2]/div[1]/div[1]/span[1]/span[1]/span/span");
	By AcitivityTestInput = By.xpath("/html/body/span/span/span[1]/input");
	By PassScoreInput = By.name("passScore");
	By DivideTimeInput = By.name("divideTime");
	By ViewScoreTimeInput = By.name("viewScoreTime");
	By SaveButton = By.xpath("//*[@id='copy-config']/div[3]/button[2]");
	// 删除入学测配置/html/body/div/div[1]/section[2]/div[1]/div/div/table/tbody/tr/td[7]/a
	By DelButton = By.xpath("/html/body/div/div[1]/section[2]/div[1]/div/div/table/tbody/tr[1]/td[7]/a");
	By DelConfirmButton = By.xpath("//*[@id='delete-confirm']");

	public WebElement getActivityTestButton() {
		return this.dr.findElement(ActivityTestButton);
	}

	public WebElement getTestAddButton() {
		return this.dr.findElement(TestAddButton);
	}

	public WebElement getAcitivityTest() {
		return this.dr.findElement(AcitivityTest);
	}

	public WebElement getAcitivityTestInput() {
		return this.dr.findElement(AcitivityTestInput);
	}

	public WebElement getPassScoreInput() {
		return this.dr.findElement(PassScoreInput);
	}

	public WebElement getDivideTimeInput() {
		return this.dr.findElement(DivideTimeInput);
	}

	public WebElement getViewScoreTimeInput() {
		return this.dr.findElement(ViewScoreTimeInput);
	}

	public WebElement getSaveButton() {
		return this.dr.findElement(SaveButton);
	}

	public WebElement getDelButton() {
		return this.dr.findElement(DelButton);
	}

	public WebElement getDelConfirmButton() {
		return this.dr.findElement(DelConfirmButton);
	}

	// 查找源活动进入入学测管理界面
	public void SearchActivity(String activityName) {
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
		this.dr.findElement(By.xpath("/html/body/div[1]/div/section[2]/section[1]/a[4]")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 添加入学测配置
	public void AddTest(String activityName, String testpassscore, String viewscoretime, String dividetime) {
		this.getTestAddButton().click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getAcitivityTest().click();
		this.getAcitivityTestInput().sendKeys(activityName);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getAcitivityTestInput().sendKeys(Keys.ENTER);
		this.getPassScoreInput().sendKeys(testpassscore);
		this.getDivideTimeInput().clear();
		this.getDivideTimeInput().sendKeys(dividetime);
		this.getViewScoreTimeInput().clear();
		this.getViewScoreTimeInput().sendKeys(viewscoretime);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getSaveButton().click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// 删除入学测配置
	public void DelTest() {
		this.getDelButton().click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getDelConfirmButton().click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
