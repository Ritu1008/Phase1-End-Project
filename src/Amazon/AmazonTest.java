package Amazon;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("Samsung mobile");
		searchBox.submit();
		
		
	    
		List<WebElement> product_names =driver.findElements(By.xpath("//div[@class='a-section']//h2//span"));
		
		List<WebElement> product_price =driver.findElements(By.xpath("//div[@class='a-section']//a//span[@class=\'a-price-whole\']"));
		
		List<WebElement> product_symbol =driver.findElements(By.xpath("//div[@class='sg-row']//span[@class='a-price-symbol']"));
		
		for(int i=0;i<product_names.size();i++)
		{
			System.out.println((product_names.get(i)).getText() +" " +product_symbol.get(i).getText()+(product_price.get(i).getText() ));
					
		}
		
		TakesScreenshot tsObj = (TakesScreenshot) driver;
		File fileObj = tsObj.getScreenshotAs(OutputType.FILE);
		File screenshotObj = new File("image.png");
		
		FileUtils.copyFile(fileObj,screenshotObj);
		
	}

}
