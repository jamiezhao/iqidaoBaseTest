package iqidaoTest.testCase;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import iqidaoTest.Utils.TestProperties;
import iqidaoTest.Utils.xmlData;
import iqidaoTest.adminPageObject.AdminHomePage;
import iqidaoTest.adminPageObject.AdminLoginPage;

public class AAA1Open {
	private WebDriver driver;
	// 页面URL
	String adminLoginUrl = xmlData.getParamFromXml("adminLoginUrl");
	String adminHomeUrl = xmlData.getParamFromXml("adminHomeUrl");
	// 登录
	String ChormeURL = xmlData.getParamFromXml("ChormeURL");
	String userName = xmlData.getParamFromXml("userName");
	String passWord = xmlData.getParamFromXml("passWord");

	@BeforeTest
	public void beforeTest() throws IOException {
		// 打开浏览器且保存sessionid以及登录到iqidao后台系统
		System.setProperty("webdriver.chrome.driver", ChormeURL);
		this.driver = new ChromeDriver();
		URL url = ((HttpCommandExecutor) (((RemoteWebDriver) driver).getCommandExecutor())).getAddressOfRemoteServer();
		String dri = url.toString();
		String sesion = ((RemoteWebDriver) driver).getSessionId().toString();
		TestProperties prop = new TestProperties();
		prop.WriteProperties("Test.properties", "Sessionid", sesion);
		prop.WriteProperties("Test.properties", "Driver", dri);
//		this.driver.manage().window().maximize();
	}
	@Test(groups = { "adminLogin" })
	public void adminLogin() throws InterruptedException {
		String expectedResult = "首页";
		AdminLoginPage adminLoginPage = new AdminLoginPage(this.driver, adminLoginUrl);
		AdminHomePage adminHomePage = adminLoginPage.adminLogin(userName, passWord, adminHomeUrl);
		String actualResult = adminHomePage.getTitleText();
		AssertJUnit.assertTrue(actualResult.contains(expectedResult));
	}

}
