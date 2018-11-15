package iqidaoTest.testCase;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import iqidaoTest.Utils.MyChormeDriver;
import iqidaoTest.Utils.TestProperties;
import iqidaoTest.Utils.xmlData;
import iqidaoTest.adminPageObject.ActivityComboPage;
import iqidaoTest.adminPageObject.AdminHomePage;
import iqidaoTest.adminPageObject.AdminLoginPage;

public class ActivityTComboTC {

	private WebDriver driver;
	// 页面URL
	String adminLoginUrl = xmlData.getParamFromXml("adminLoginUrl");
	String adminHomeUrl = xmlData.getParamFromXml("adminHomeUrl");
	String CmoboListUrl = xmlData.getParamFromXml("CmoboListUrl");
	String activitysListUrl = xmlData.getParamFromXml("activitysListUrl");
	// 登录
	String ChormeURL = xmlData.getParamFromXml("ChormeURL");
	String userName = xmlData.getParamFromXml("userName");
	String passWord = xmlData.getParamFromXml("passWord");
	// 创建续报关联
	String Combonamemod = xmlData.getParamFromXml("Combonamemod");
	String combostartime = xmlData.getParamFromXml("combostartime");
	String comboendtime = xmlData.getParamFromXml("comboendtime");
	String activityName = xmlData.getParamFromXml("activityName");

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", ChormeURL);
		//多个案例连续跑，只打开1个浏览器时用这个
		TestProperties prop =new TestProperties();
		String  driverserver = prop.GetValueByKey("Test.Properties", "Driver");
		String  caseSession = prop.GetValueByKey("Test.Properties", "Sessionid");
		this.driver = new MyChormeDriver(driverserver,caseSession);
		/*//单个测试案例执行时使用
		this.driver = new ChromeDriver();
		String expectedResult = "首页";
		AdminLoginPage adminLoginPage = new AdminLoginPage(this.driver, adminLoginUrl);
		AdminHomePage adminHomePage = adminLoginPage.adminLogin(userName, passWord, adminHomeUrl);
		String actualResult = adminHomePage.getTitleText();
		AssertJUnit.assertTrue(actualResult.contains(expectedResult));*/
		this.driver.manage().window().maximize();
	}

	// 创建活动-续报关联
	@Test(groups = { "CreateComboLink" })
	public void ComboLink() {
		ActivityComboPage activityComboPage = new ActivityComboPage(this.driver, activitysListUrl);
		activityComboPage.SearchActivity(activityName);
		activityComboPage.CreatActivityCombo(Combonamemod, combostartime, comboendtime);
	}
	/*@AfterTest
	public void afterTest() {
		this.driver.quit();
	}*/
}
