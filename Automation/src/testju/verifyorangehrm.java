package testju;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
public class verifyorangehrm {
public WebDriver driver;
@Test(priority=1)
public void OpenBrowser()
{
System.setProperty("webdriver.chrome.driver","C:\\browserdriver\\chromedriver.exe");
driver=new ChromeDriver();
driver.manage().window().maximize();
driver.get("https://opensource-demo.orangehrmlive.com/");
}
@Test(priority=2)
 public void ValidateLoginpage()
{
String actual=driver.getTitle();
Assert.assertEquals("OrangeHRM", actual);
}
	@Test(priority=3)
	public void loginWithValidCredentails() 
	{
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
	}
	@Test(priority=4)
	public void VerifySuccesfullLogin() throws InterruptedException 
	{
		Thread.sleep(3000);
		String actual=driver.findElement(By.id("welcome")).getAttribute("id");
		Assert.assertEquals("welcome",actual);
		
	}
	@Test(priority=5)
	public void closebrowser() 
	{
		driver.quit();
		
	}
}


