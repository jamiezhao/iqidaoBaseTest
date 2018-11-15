package iqidaoTest.WebFrontObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import iqidaoTest.adminPageObject.ActivitysListPage;
import iqidaoTest.adminPageObject.BasePage;

public class CreatePaperPage extends BasePage{

	public CreatePaperPage(WebDriver driver, String url) {
		// TODO Auto-generated constructor stub
		// TODO Auto-generated constructor stub
		super(driver);
		this.url = url;
		this.goTo();
	}
	//创建作业试卷
	By CreateButton = By.xpath("//*[@id='filters']/a");
	By PaperNameInput=By.xpath("//*[@id='addquiz']/form/div[2]/div[1]/div[1]/input");
	By StartPaperTime=By.name("startTime");
	By submitbutton = By.xpath("//*[@id='addquiz']/form/div[3]/button[2]");
	//查询试卷
	By SearchNameInput=By.xpath("//*[@id='filters']/div[1]/input");
	By SearchButton=By.xpath("//*[@id='filters']/button[1]");
	//导入试题
	By DaYuSelect=By.xpath("//*[@id='import-paperquiz']/div[2]/div/div[1]/div[2]/select");
	By ImportQuizButton=By.xpath("//*[@id='main']/div/section/form/header/h3/a[1]");
	By sgfButton=By.name("sgf");
	By SaveButton=By.xpath("//*[@id='import-paperquiz']/div[3]/button[2]");
	//添加已有试题
	By AddQuizButton=By.xpath("//*[@id='main']/div/section/form/header/h3/a[2]");
	By QuizSearchButton=By.xpath("//*[@id='query_paperQuiz']/div[10]/a");
	By AllChooseButton=By.xpath("//*[@id='paperQuiz-list']/thead/tr/th[1]/div/label/span");
	By SaveButton1=By.id("paperQuiz-submit");	
	public WebElement getCreateButton(){
		return this.dr.findElement(CreateButton);
	}
	public WebElement getPaperNameInput(){
		return this.dr.findElement(PaperNameInput);
	}
	public WebElement getStartPaperTime(){
		return this.dr.findElement(StartPaperTime);
	}
	public WebElement getsubmitbutton(){
		return this.dr.findElement(submitbutton);
	}
	public WebElement getSearchNameInput(){
		return this.dr.findElement(SearchNameInput);
	}
	public WebElement getSearchButton(){
		return this.dr.findElement(SearchButton);
	}
	public WebElement getImportQuizButton(){
		return this.dr.findElement(ImportQuizButton);
	}
	public WebElement getsgfButton(){
		return this.dr.findElement(sgfButton);
	}
	public WebElement getSaveButton(){
		return this.dr.findElement(SaveButton);
	}
	public WebElement getAddQuizButton(){
		return this.dr.findElement(AddQuizButton);
	}
	public WebElement getQuizSearchButton(){
		return this.dr.findElement(QuizSearchButton);
	}
	public WebElement getSaveButton1(){
		return this.dr.findElement(SaveButton1);
	}
	public WebElement getAllChooseButton(){
		return this.dr.findElement(AllChooseButton);
	}
	public Select getDaYuSelect(){
		Select dayu=new Select(this.dr.findElement(DaYuSelect));
		return dayu;
	}
	//创建作业试卷
	public void CreatePaper(String Papername, String PaperStarttime){
		this.getCreateButton().click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getPaperNameInput().sendKeys(Papername);
		this.getStartPaperTime().clear();
		this.getStartPaperTime().sendKeys(PaperStarttime);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getsubmitbutton().click();	
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//查询试卷且打开
	public void SearchPaper(String Papername){
		this.getSearchNameInput().sendKeys(Papername);
		this.getSearchButton().click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			WebElement getPapername = this.dr.findElement(By.xpath("//*[@id='main']/div[2]/div/div[2]/div[2]/table/tbody/tr[1]/td[2]/a/span"));
			if(getPapername.getText().contains(Papername)) {
				getPapername.click();
				}
			else{
				System.out.print("无法找到创建的试卷，请检查创建脚本是否有误");
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	//打开试卷创建试题
	public CreatePaperPage InsertQuiz(String frontquizurl,String dayuselect,String reurl){
		//导入试题
		this.getImportQuizButton().click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Select dayu=this.getDaYuSelect();
		//1-死活；2-布局；3-定式；4-中盘；5-官子
		dayu.selectByValue(dayuselect);		
		this.getsgfButton().sendKeys(frontquizurl);
		this.getSaveButton().click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//添加已有题目，随机筛选10道题
		this.getAddQuizButton().click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getQuizSearchButton().click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getAllChooseButton().click();
		this.getSaveButton1().click();
		return new CreatePaperPage(this.dr, reurl);

	}
	}

