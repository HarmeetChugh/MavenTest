package TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMagento {
	@Test
public void Login() throws InterruptedException
{	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://www.magento.com");

	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[9]/a/span[1]/div")).click();
	driver.findElement(By.id("email")).sendKeys("abdc@gmail.com");
	driver.findElement(By.name("login[password]")).sendKeys("welcome");
	driver.findElement(By.id("send2")).click();
	Thread.sleep(300);
	String text = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")).getText();
	System.out.println(text);
	//String response = "Invalid login or password.";
			if(text.equals("Invalid login or password."))
			{
		System.out.println("validated");
			}
			else {
				System.out.println("not same");	
			}
		driver.quit();		
}
	
	@Test
	public void Register() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.magento.com");
	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[9]/a/span[1]/div")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("register")).click();
		driver.findElement(By.id("firstname")).sendKeys("Harmeet");
		driver.findElement(By.id("lastname")).sendKeys("Chugh");
		driver.findElement(By.name("email")).sendKeys("meetchug@gmail.com");
		WebElement s = driver.findElement(By.id("company_type"));
		Select s1 = new Select(s);
		s1.selectByIndex(2);
		
		WebElement r= driver.findElement(By.id("individual_role"));
		Select s2= new Select(r);
		s2.selectByValue("technical/developer");
		
		WebElement c = driver.findElement(By.id("country"));
		Select s3=new Select(c);
		s3.selectByVisibleText("Canada");
		
		driver.findElement(By.id("password")).sendKeys("Welcome");
		driver.findElement(By.id("password-confirmation")).sendKeys("welcome");
		if(!driver.findElement(By.id("agree_terms")).isSelected())
		{
		driver.findElement(By.id("agree_terms")).click();
		}
		driver.quit();
		}

	@Test
	public void frames() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("http://www.Naukri.com");
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Set<String> winid = driver.getWindowHandles();
		// TODO Auto-generated method stub
 driver.get("https://account.magento.com/customer/account/create/");
 Thread.sleep(5000);
	driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"rc-anchor-container\"]")));
 driver.findElement(By.className("recaptcha-checkbox-checkmark")).click();
 driver.switchTo().defaultContent();
 driver.quit();
	}
	
	@Test 
	public void spicejet()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.spicejet.com");
	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//implicit wait
		//WebDriverWait wait = new WebDriverWait(driver,30);//explicit wait
		//wait.until((ExpectedConditions.elementToBeSelected(By.id("ctl00_mainContent_rbtnl_Trip_0"))));
	driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
	//driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).clear();
	//driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).sendKeys("Amritsar");//we could send like chen fro chennai
	driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
	//driver.findElement(By.linkText("Amritsar (ATQ)")).click();
	driver.findElement(By.xpath("//*[@id=\"dropdownGroup1\"]/div/ul[1]/li[3]/a")).click();
	driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
	//driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).sendKeys("Amritsar");
	driver.findElement(By.xpath("//*[@id=\"dropdownGroup1\"]/div/ul[1]/li[3]/a")).click();
	//driver.findElement(By.linkText("Amritsar (ATQ)")).click();
	driver.findElement(By.id("ctl00_mainContent_view_date1")).sendKeys("16/09/2021");
	//driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[2]/td[4]/a")).click();
	//Thread.sleep(3000);
	driver.findElement(By.id("divpaxinfo")).click();
	Select s = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
	s.selectByVisibleText("3");
	Select s1 = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
	s1.selectByVisibleText("INR");
	driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
	driver.quit();
	}
	}



//@Test{priority=1, Enabled = false}
// to skip test case either use//before @Test but professionally u should use enabled=false
//generally testcases execute alphabetically to change you can use priority default 0 and -1,-2 to make very high priority