package iqidaoTest.testCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import iqidaoTest.Utils.MyChormeDriver;
import iqidaoTest.Utils.TestProperties;
import iqidaoTest.Utils.xmlData;
import iqidaoTest.adminPageObject.ActivityTestExam;
import iqidaoTest.adminPageObject.AdminHomePage;
import iqidaoTest.adminPageObject.AdminLoginPage;

public class EntranceTestActivityTC {

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
	// 创建入学测配置
	String testpassscore = xmlData.getParamFromXml("testpassscore");
	String viewscoretime = xmlData.getParamFromXml("viewscoretime");
	String dividetime = xmlData.getParamFromXml("dividetime");
	String[] activityName = xmlData.getParamArrayFromXml("activityName");

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", ChormeURL);
		//多个案例连续跑，只打开1个浏览器时用这个
		TestProperties prop =new TestProperties();
		String  driverserver = prop.GetValueByKey("Test.Properties", "Driver");
		String  caseSession = prop.GetValueByKey("Test.Properties", "Sessionid");
		this.driver = new MyChormeDriver(driverserver,caseSession);
	/*	//单个测试案例执行时使用
		this.driver = new ChromeDriver();
		String expectedResult = "首页";
		AdminLoginPage adminLoginPage = new AdminLoginPage(this.driver, adminLoginUrl);
		AdminHomePage adminHomePage = adminLoginPage.adminLogin(userName, passWord, adminHomeUrl);
		String actualResult = adminHomePage.getTitleText();
		AssertJUnit.assertTrue(actualResult.contains(expectedResult));
		this.driver.manage().window().maximize();*/
	}

	// 创建入学测配置
	@Test(groups = { "Creaentrancetetest" })
	public void CreateEntranceTest() {
		ActivityTestExam activityTestExam = new ActivityTestExam(this.driver, activitysListUrl);
		activityTestExam.SearchActivity(activityName[0]);
		activityTestExam.AddTest(activityName[2], testpassscore, viewscoretime, dividetime);
		// 删除入学测配置
		activityTestExam.DelTest();
		//重新添加
		activityTestExam.AddTest(activityName[2], testpassscore, viewscoretime, dividetime);

	}
}
