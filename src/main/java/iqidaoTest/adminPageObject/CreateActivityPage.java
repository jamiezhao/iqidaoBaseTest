package iqidaoTest.adminPageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//http://101.132.45.64/admin001/activity/post
public class CreateActivityPage extends BasePage {
	public CreateActivityPage(WebDriver driver, String url) {
		super(driver);
		this.url = url;
		this.goTo();
	}

	By activityNameLocator = By.name("name");
	By activityUserLimitLocator = By.id("userLimit");
	By activityVersionLocator = By.name("activityVersion");
	By activityTypeLocator = By.name("type");
	By activityPictureLocator = By.name("logo1");
	By activityDescriptionLocator = By.cssSelector("div.fr-element.fr-view");
	By activityLowduanLocator = By.name("lowerduan");
	By activityupperduanLocator = By.name("upperduan");
	By activitySignupCountLocator = By.name("signupCount");
	By activityPriceLocator = By.name("price");
	By activitySignupStartTimeLocator = By.name("signupStartTime");
	By activitySignupEndTimeLocator = By.name("signupEndTime");
	By activityStartTimeLocator = By.name("startTime");
	By activityEndTimeLocator = By.name("endTime");
	By activityquarterLocator = By.name("quarter");
	By enableSignupLocator = By
			.xpath("/html/body/div[1]/div/section[2]/section/form/div[1]/div[4]/div[2]/div/label/span");
	By enableOnlineLocator = By
			.xpath("/html/body/div[1]/div/section[2]/section/form/div[1]/div[4]/div[1]/div/label/span");
	By enableCouponLocator = By
			.xpath("/html/body/div[1]/div/section[2]/section/form/div[1]/div[4]/div[3]/div/label/span");
	By enableSMSLocator = By
			.xpath("/html/body/div[1]/div/section[2]/section/form/div[1]/div[4]/div[4]/div/label/span");
	By enablecomboLocator = By
			.xpath("/html/body/div[1]/div/section[2]/section/form/div[1]/div[4]/div[5]/div/label/span");
	By enablesignTestLocator = By
			.xpath("/html/body/div[1]/div/section[2]/section/form/div[1]/div[4]/div[6]/div/label/span");
	By enableAuditLocator = By.xpath("/html/body/div[1]/div/section[2]/section/form/div[1]/div[4]/div[7]/div/label/span");
	By enableAILocator = By.xpath("/html/body/div[1]/div/section[2]/section[2]/form/div/div[5]/div[8]/div/label/span");
	By submitButtonLocator = By.xpath("/html/body/div[1]/div/section[2]/section/form/div[2]/button");
	
	public WebElement getActivityNameTextField() {
		return this.dr.findElement(activityNameLocator);
	}
	public WebElement getActivityUserLimitTextField() {
		return this.dr.findElement(activityUserLimitLocator);
	}

	// 1为普通模式，2为双师模式
	public Select getActivityVersionSelect() {
		Select activityVersionSelect = new Select(this.dr.findElement(activityVersionLocator));
		return activityVersionSelect;
	}

	// 101为特战队，2为年级训练，3短期班，4讲座课，5公开课，6分班测评
	public Select getActivityTypeSelect() {
		Select activityTypeSelect = new Select(this.dr.findElement(activityTypeLocator));
		return activityTypeSelect;
	}

	public void setActivityTeacher(String teacherName) {
		// 设置活动教师，1.点击输入框，弹出搜索框 2.在输入框输入搜索内容 3.等待ajax加载数据，点击数据
		List<WebElement> lists = this.dr.findElements(By.className("select2-selection__placeholder"));
		lists.get(1).click();
		this.dr.findElement(By.className("select2-search__field")).sendKeys(teacherName);
		new WebDriverWait(this.dr, 5)
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".clearfix.text-center.ajaxSelect")));
		this.dr.findElement(By.cssSelector(".clearfix.text-center.ajaxSelect")).click();
	}

	public WebElement getActivityPictureField() {
		return this.dr.findElement(activityPictureLocator);
	}

	public WebElement getDescriptionTextField() {
		return this.dr.findElement(activityDescriptionLocator);
	}

	public Select getLowduanSelect() {
		Select LowduanTextSelect = new Select(this.dr.findElement(activityLowduanLocator));
		return LowduanTextSelect;
	}

	public Select getactivityupperduanSelect() {
		Select UpperduanSelect = new Select(this.dr.findElement(activityupperduanLocator));
		return UpperduanSelect;
	}

	public WebElement getSignupCountTextField() {
		return this.dr.findElement(activitySignupCountLocator);
	}

	public WebElement getActivityPriceTextField() {
		return this.dr.findElement(activityPriceLocator);
	}

	public WebElement getSignupStartTimeTextField() {
		return this.dr.findElement(activitySignupStartTimeLocator);
	}

	public WebElement getSignupEndTimeTextField() {
		return this.dr.findElement(activitySignupEndTimeLocator);
	}

	public WebElement getStartTimeTextField() {
		return this.dr.findElement(activityStartTimeLocator);
	}

	public WebElement getEndTimeTextField() {
		return this.dr.findElement(activityEndTimeLocator);
	}

	// 1春季班，2暑假班，3.秋季班，4寒假班
	public Select getactivityquarterSelect() {
		Select activityquarter = new Select(this.dr.findElement(activityquarterLocator));
		return activityquarter;
	}

	public WebElement getEnableSignupButton() {
		return this.dr.findElement(enableSignupLocator);
	}

	public WebElement getEnableOnlineButton() {
		return this.dr.findElement(enableOnlineLocator);
	}

	public WebElement getEnableCouponButton() {
		return this.dr.findElement(enableCouponLocator);
	}
	public WebElement getenableSMSButton() {
		return this.dr.findElement(enableSMSLocator);
	}
	public WebElement getenablecomboButton() {
		return this.dr.findElement(enablecomboLocator);
	}
	public WebElement getenablesignTestButton() {
		return this.dr.findElement(enablesignTestLocator);
	}
	public WebElement getenableAuditLocator() {
		return this.dr.findElement(enableAuditLocator);
	}
	public WebElement getenableAILocator() {
		return this.dr.findElement(enableAILocator);
	}
	public WebElement getSubmitButton() {
		return this.dr.findElement(submitButtonLocator);
	}
	public ActivitysListPage createActivity(String activityName, String teacherName, String activityPicture,
			String signupCount, String lowduan, String price, String signupStartTime, String signupEndTime,
			String activityStartTime, String activityEndTime, String redirectPageUrl,String type) {
		this.getActivityNameTextField().sendKeys(activityName);
		this.getActivityUserLimitTextField().sendKeys("10");
		Select activityVersion = this.getActivityVersionSelect();
		activityVersion.selectByValue("2"); // 2为双师模式
		Select activityType = this.getActivityTypeSelect();
		activityType.selectByValue(type); // 2为年级训练
		this.setActivityTeacher(teacherName);
		this.getActivityPictureField().sendKeys(activityPicture);
		this.getDescriptionTextField().sendKeys("this is activity's description");
		Select activityLowDuan = this.getLowduanSelect();
		activityLowDuan.selectByValue("2"); // 最低段位
		Select activityUpperDuan = this.getactivityupperduanSelect();
		activityUpperDuan.selectByValue("4"); // 最高段位
		this.getSignupCountTextField().sendKeys(signupCount);
		this.getActivityPriceTextField().sendKeys(price);
		this.getSignupStartTimeTextField().clear();
		this.getSignupStartTimeTextField().sendKeys(signupStartTime);
		this.getSignupEndTimeTextField().clear();
		this.getSignupEndTimeTextField().sendKeys(signupEndTime);
		this.getStartTimeTextField().clear();
		this.getStartTimeTextField().sendKeys(activityStartTime);
		this.getEndTimeTextField().clear();
		this.getEndTimeTextField().sendKeys(activityEndTime);
		Select activityquarterSelect = this.getactivityquarterSelect();
		activityquarterSelect.selectByValue("2"); // 2-暑假班
		
//		JavascriptExecutor js1 = (JavascriptExecutor) this.dr;
//		js1.executeScript("arguments[0].scrollIntoView(true);", this.getEnableSignupButton());
//		this.getEnableSignupButton().click();
//		this.getEnableOnlineButton().click();
//		this.getEnableCouponButton().click();
//		this.getenableSMSButton().click();
//		this.getenablecomboButton().click();
//		this.getenablesignTestButton().click();
//		this.getenableAuditLocator().click();
		//可AI对弈，默认未开，所以注释掉
		//this.getenableAILocator().click();
		JavascriptExecutor js2 = (JavascriptExecutor) this.dr;
		js2.executeScript("arguments[0].scrollIntoView(true);", this.getSubmitButton());
		this.getSubmitButton().click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new ActivitysListPage(this.dr, redirectPageUrl);
	}

}
