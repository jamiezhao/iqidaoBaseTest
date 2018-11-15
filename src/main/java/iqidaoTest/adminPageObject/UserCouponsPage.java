package iqidaoTest.adminPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserCouponsPage extends BasePage {

	public UserCouponsPage(WebDriver driver, String url) {
		super(driver);
		this.url = url;
		this.goTo();
	}
	
	By addCouponButtonLocator = By.linkText("添加代金券");
	
	By couponUserNameLocator = By.xpath(".//*[@id='addcoupon']/form/div[2]/div[1]/div/span[1]/span[1]/span");
	By couponPriceLocator = By.name("price");
	By couponStartTimeLocator = By.name("startTime");
	By couponEndtimeLocator = By.name("endTime");
	By couponSubmitButtonLocator = By.xpath(".//*[@id='addcoupon']/form/div[3]/button[2]");
	
	public WebElement getAddCouponButton() {
		return this.dr.findElement(addCouponButtonLocator);
	}
	
	public WebElement getCouponUserNameField() {
		return this.dr.findElement(couponUserNameLocator);
	}
	
	public WebElement getCouponPriceField() {
		return this.dr.findElement(couponPriceLocator);
	}
	
	public WebElement getcouponStartTimeField() {
		return this.dr.findElement(couponStartTimeLocator);
	}
	
	public WebElement getcouponEndtimeField() {
		return this.dr.findElement(couponEndtimeLocator);
	}
	
	public WebElement getcouponSubmitButton() {
		return this.dr.findElement(couponSubmitButtonLocator);
	}
	
	public void addUserCoupon(String couponUserName, String couponPrice, String couponStartTime, String couponEndTime) {
		this.getAddCouponButton().click();
		//1.点击用户名输入框，待出现输入框后输入搜索值，待出现搜索结果后进行点击选择
		new WebDriverWait(this.dr,5).until(ExpectedConditions.presenceOfElementLocated(couponUserNameLocator));
		this.getCouponUserNameField().click();
		this.dr.findElement(By.className("select2-search__field")).sendKeys(couponUserName);
		new WebDriverWait(this.dr,5).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".clearfix.text-center.ajaxSelect")));
		this.dr.findElement(By.cssSelector(".clearfix.text-center.ajaxSelect")).click();
		//2.输入其他信息提交
		this.getCouponPriceField().sendKeys(couponPrice);
		this.getcouponStartTimeField().clear();
		this.getcouponStartTimeField().sendKeys(couponStartTime);
		this.getcouponEndtimeField().clear();
		this.getcouponEndtimeField().sendKeys(couponEndTime);
		this.getcouponSubmitButton().click();
	}
	
	public boolean checkFirstUserCoupon(String couponUserName) {
		boolean flag = false;
		String firstCouponUserName = this.dr.findElement(By.xpath("html/body/div[1]/div/section[2]/div/div/div/div[1]/table/tbody/tr[1]/td[2]")).getText();
		String firstCouponStatus = this.dr.findElement(By.xpath("html/body/div[1]/div/section[2]/div/div/div/div[1]/table/tbody/tr[1]/td[7]")).getText();
		if(firstCouponUserName.equals(couponUserName) && firstCouponStatus.equals("未使用")) {
			return flag = true;
		}
		return flag;
	}
	
}
