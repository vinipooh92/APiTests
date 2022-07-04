package uiAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAccessCode {
	
	public static String getAccessCodeGoogle() throws InterruptedException
	{
		/*System.setProperty("webdriver.chrome.driver", "E:\\chromeDriver\\chromedriver.exe");
		WebDriver driver =  new ChromeDriver();
		driver.get("https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php&Auth_url=https://accounts.google.com/o/oauth2/v2/auth");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("vinithasadasivam");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("1q2w3e4r5tvpooh@#$");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(Keys.ENTER);
		Thread.sleep(5000); */
		String url = "https://rahulshettyacademy.com/getCourse.php?code=4%2F0AX4XfWjvMrZPRsNmtB5dFEMMPObqmDVyKBpWTaxp_wyO2jiN7QiZvCy8oNc36n4WoQU6wA&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none";
		String needUrl =  url.split("code")[1].split("&scope")[0].replace("=", "");
		
		return needUrl;
	}

}
