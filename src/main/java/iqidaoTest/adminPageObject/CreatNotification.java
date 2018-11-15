package iqidaoTest.adminPageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CreatNotification extends BasePage{
	private int activitiesTableRows = 20;
	public CreatNotification(WebDriver driver, String url) {
		super(driver);
		this.url = url;
		this.goTo();
	}
	By NotificationButton = By.xpath("/html/body/div[1]/div/section[2]/section[1]/a[5]");
	By CreateReportButton = By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div[2]/div[1]/a");
	
	By NameInput = By.name("name");
	By StartTimeInput = By.name("startTime");
	By EndTimeInput = By.name("endTime");
	By SendTimeInput = By.xpath("//*[@id='add-report']/div[2]/div[4]/div/input");
	By SubmitButton= By.xpath("//*[@id='add-report']/div[3]/button[2]");
	public WebElement getNotificationButton() {
		return this.dr.findElement(NotificationButton);
	}
	public WebElement getCreateReportButton() {
		return this.dr.findElement(CreateReportButton);
	}
	
	public WebElement getNameInput() {
		return this.dr.findElement(NameInput);
	}
	
	public WebElement getStartTimeInput() {
		return this.dr.findElement(StartTimeInput);
	}
	
	public WebElement getEndTimeInput() {
		return this.dr.findElement(EndTimeInput);
	}
	
	public WebElement getSendTimeInput() {
		return this.dr.findElement(SendTimeInput);
	}
	public WebElement getSubmitButton() {
		return this.dr.findElement(SubmitButton);
	}
	//添加通知消息
		public ActivitysListPage CreateNotificationPage (String ReportName,String ReportStartTime,String ReportEndTime,String ReportSendTime) {
			//点击通知管理按钮
			this.getNotificationButton().click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//进入通知管理界面
			this.getCreateReportButton().click();
			this.getNameInput().sendKeys(ReportName);
			this.getStartTimeInput().clear();
			this.getStartTimeInput().sendKeys(ReportStartTime);
			this.getEndTimeInput().clear();
			this.getEndTimeInput().sendKeys(ReportEndTime);
			this.getSendTimeInput().clear();
			this.getSendTimeInput().sendKeys(ReportSendTime);
			this.dr.findElement(By.xpath("//*[@id='add-report']/div[1]/h4")).click();
			this.getSubmitButton().click();
			return new ActivitysListPage(this.dr, this.url);

	}
	
}
