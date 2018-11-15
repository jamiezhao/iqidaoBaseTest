package iqidaoTest.testCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import iqidaoTest.Utils.MyChormeDriver;
import iqidaoTest.Utils.TestProperties;
import iqidaoTest.Utils.xmlData;
import iqidaoTest.adminPageObject.ActivityUsersPage;
import iqidaoTest.adminPageObject.ActivitysListPage;
import iqidaoTest.adminPageObject.AdminHomePage;
import iqidaoTest.adminPageObject.AdminLoginPage;

public class ActivityUserTC {
	private WebDriver driver;
	//页面URL
	String adminLoginUrl = xmlData.getParamFromXml("adminLoginUrl");
	String adminHomeUrl = xmlData.getParamFromXml("adminHomeUrl");
	String activitysListUrl = xmlData.getParamFromXml("activitysListUrl");

	//登录
	String ChormeURL=xmlData.getParamFromXml("ChormeURL");
	String userName = xmlData.getParamFromXml("userName");
	String passWord = xmlData.getParamFromXml("passWord");
	
	String activityName = xmlData.getParamFromXml("activityName");
	//添加或删除活动用户
	String[] activityUserName = xmlData.getParamArrayFromXml("activityUserName");

	
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
		this.driver.manage().window().maximize();
		String expectedResult = "首页";
		AdminLoginPage adminLoginPage = new AdminLoginPage(this.driver, adminLoginUrl);
		AdminHomePage adminHomePage = adminLoginPage.adminLogin(userName, passWord, adminHomeUrl);
		String actualResult = adminHomePage.getTitleText();
		AssertJUnit.assertTrue(actualResult.contains(expectedResult));*/
	}
	
	
	//手工添加活动用户
	@Test(groups = { "AcitivityAddUser" },priority = 0)
	public void addActivityUser() {
		ActivitysListPage activitysListPage = new ActivitysListPage(this.driver, activitysListUrl);
		WebElement activityUsers = activitysListPage.getActivityUsersByName(activityName);
		if(activityUsers != null) {
			activityUsers.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String currentUrl = this.driver.getCurrentUrl();
			ActivityUsersPage activityUsersPage = new ActivityUsersPage(this.driver, currentUrl);
			for (int i = 0; i < activityUserName.length; i++){
			activityUsersPage.addActivityUser(activityUserName[i]);
			boolean result = activityUsersPage.findActivityUserName(activityUserName[i]);
			AssertJUnit.assertTrue(result);
			}
		}else {
			AssertJUnit.assertTrue(false);
		}
			
	}
	
	//手动删除活动用户
	@Test(groups = { "AcitivityAddUser" },priority = 1)
	public void deleteActivityUser() {
		ActivitysListPage activityListPage = new ActivitysListPage(this.driver, activitysListUrl);
		WebElement activityUsers = activityListPage.getActivityUsersByName(activityName);
		if(activityUsers != null) {
			activityUsers.click();
			this.driver.navigate().refresh();
			String currentUrl = this.driver.getCurrentUrl();
			ActivityUsersPage activityUsersPage = new ActivityUsersPage(this.driver, currentUrl);
			activityUsersPage.deleteActivityUser(activityUserName[0]);
			boolean result = activityUsersPage.findActivityUserName(activityUserName[0]);
			AssertJUnit.assertTrue(!result);
		}else {
			AssertJUnit.assertTrue(false);
		}
		
	}
	/*@AfterTest
	public void afterTest() {
		this.driver.close();
	}*/

}
