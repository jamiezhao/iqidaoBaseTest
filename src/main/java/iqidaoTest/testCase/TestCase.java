package iqidaoTest.testCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import iqidaoTest.Utils.SwitchToWindow;
import iqidaoTest.frontPageObject.ActivityDetailPage;
import iqidaoTest.frontPageObject.ActivitysPage;
import iqidaoTest.frontPageObject.HomePage;
import iqidaoTest.frontPageObject.LoginPage;

public class TestCase {
	private WebDriver driver;
	//页面url
	String loginUrl = "http://testing.iqidao.com/";
	String homeUrl = "http://testing.iqidao.com/home";
	String activitysListUrl = "http://testing.iqidao.com/trainings";
	String traninsListUrl = "http://testing.iqidao.com/trainings";
	String mytrainsUrl = "http://testing.iqidao.com/mytrainings";
	
	//登录
	String userName = "13811460080";
	String passWord = "111111";
	
	//购买活动
	String activityName = "zl双师1109活动";
	
	@BeforeTest
	public void setUp(){
//		this.driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\工作目录\\autoTest\\chromedriver33.exe");
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
	}
	

	//前台登录
	@Test
	public void testLogin(){
		
		String expectedResult = "学习中心";
		//登录
		LoginPage login = new LoginPage(this.driver, loginUrl);
		HomePage homePage = login.login(userName, passWord, homeUrl);
		
		//检查登录结果
		String actualResult = homePage.getTitleText();
		AssertJUnit.assertTrue(actualResult.contains(expectedResult));
		
	}
	
	
	//购买活动
	@Test(dependsOnMethods = {"testLogin"})
	public void buyActivity() {
		ActivitysPage activitysPage = new ActivitysPage(this.driver, traninsListUrl);
		boolean result = activitysPage.gotoActivityDetailPageByName(activityName);
		if(result) {
			boolean flag = SwitchToWindow.changeWindow(this.driver, activityName);
			if(flag) {
				String activityDetailUrl = this.driver.getCurrentUrl();
				ActivityDetailPage activityDetailPage = new ActivityDetailPage(this.driver, activityDetailUrl);
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				activityDetailPage.buyActivityByCoupon(activityName, mytrainsUrl);
			}
		}
		
		
	}
	
	@AfterTest
	public void afterTest() {
		this.driver.close();
	}
	
}
