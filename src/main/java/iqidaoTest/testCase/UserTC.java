package iqidaoTest.testCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import iqidaoTest.Utils.xmlData;
import iqidaoTest.adminPageObject.AdminHomePage;
import iqidaoTest.adminPageObject.AdminLoginPage;
import iqidaoTest.adminPageObject.UserCouponsPage;
import iqidaoTest.adminPageObject.UsersListPage;

public class UserTC {
	private WebDriver driver;
	//页面URL
	String adminLoginUrl = xmlData.getParamFromXml("adminLoginUrl");
	String adminHomeUrl = xmlData.getParamFromXml("adminHomeUrl");
	String userCouponListUrl = xmlData.getParamFromXml("userCouponListUrl");
	String usersListUrl = xmlData.getParamFromXml("usersListUrl");
	//登录
	String ChormeURL=xmlData.getParamFromXml("ChormeURL");
	String userName = xmlData.getParamFromXml("userName");
	String passWord = xmlData.getParamFromXml("passWord");
	//发放用户优惠券
	String couponUserName = xmlData.getParamFromXml("couponUserName");
	String couponPrice = xmlData.getParamFromXml("couponPrice");
	String couponStartTime = xmlData.getParamFromXml("couponStartTime");
	String couponEndTime = xmlData.getParamFromXml("couponEndTime");
	//添加用户
	String userRealName = xmlData.getParamFromXml("userRealName");
	String mobilePhone = xmlData.getParamFromXml("mobilePhone");	//专属测试手机号
	String userGroup = xmlData.getParamFromXml("userGroup"); 	//100为客服身份
	String userPassword = xmlData.getParamFromXml("userPassword");
	
	
	
	@BeforeTest
	public void beforeTest() {
//		this.driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", ChormeURL);
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
	}
	
	//后台登录
	@Test
	public void adminLogin(){
		String expectedResult = "首页";
		AdminLoginPage adminLoginPage = new AdminLoginPage(this.driver, adminLoginUrl);
		AdminHomePage adminHomePage = adminLoginPage.adminLogin(userName, passWord, adminHomeUrl);
		String actualResult = adminHomePage.getTitleText();
		AssertJUnit.assertTrue(actualResult.contains(expectedResult));
	}
	
	
	//发放用户优惠券
	@Test(dependsOnMethods = {"adminLogin"})
	public void sendUserCoupon() {
		UserCouponsPage userCouponsPage = new UserCouponsPage(this.driver, userCouponListUrl);
		userCouponsPage.addUserCoupon(couponUserName, couponPrice, couponStartTime, couponEndTime);
		boolean result = userCouponsPage.checkFirstUserCoupon(couponUserName);
		AssertJUnit.assertTrue(result);
	}
	
	
	//添加用户
	@Test(dependsOnMethods = {"adminLogin"})
	public void addUser() {
		UsersListPage usersListPage = new UsersListPage(this.driver, usersListUrl);
		usersListPage.addUser(userRealName, mobilePhone, userGroup, userPassword);
		
	}
	
	@AfterTest
	public void afterTest() {
		this.driver.close();
	}

}
