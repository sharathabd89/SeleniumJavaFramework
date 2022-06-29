package co.free.tour.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import mainPacakge.BaseTestClass;
public class LoginPage extends BaseTestClass {
	@FindBy(name="txtUsername")
	WebElement username;
	@FindBy(name="txtPassword")
	WebElement password;
	@FindBy(xpath="//input[@name=\"Submit\"]")
	WebElement submit;
	@FindBy(xpath="//body/div[@id='wrapper']/div[@id='content']/div[@id='divLogin']/div[@id='divLogo']/img[1]")
	WebElement Logoimage;
	@FindBy(id="welcome")
	WebElement loginsuccesfull;
	 public LoginPage()
	{
	PageFactory.initElements(driver,this);
		}
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	public boolean validateLogoImage()
	{
		return Logoimage.isDisplayed();
		}
	public HomePage loginCheck(String un,String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		submit.click();
		return new HomePage();
		}
	public void ClickSubmitBtn() {
		submit.click();
		
	}
	public String VerifySuccesfullLogin()
	{ 
	return	loginsuccesfull.getAttribute("id");
		}
}
