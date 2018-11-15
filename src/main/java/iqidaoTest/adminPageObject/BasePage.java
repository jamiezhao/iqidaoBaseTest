package iqidaoTest.adminPageObject;

import org.openqa.selenium.WebDriver;

public class BasePage {
	protected final WebDriver dr;
	protected String url;
	protected static final String CAPTCHA = "666666";
	
	public BasePage(WebDriver driver){
		this.dr = driver;
	}
	
	public void goTo(){
		this.dr.get(url);
	}

	
}
