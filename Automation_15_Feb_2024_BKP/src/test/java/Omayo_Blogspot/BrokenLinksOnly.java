/**
 * 
 */
package Omayo_Blogspot;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @Author Akash Naykude
 * 29-Feb-2024
 */
public class BrokenLinksOnly {

	public static void main(String[] args) throws Exception 
	{
		WebDriverManager.chromedriver().setup();
		 WebDriver driver=new ChromeDriver();
		driver.get("https://omayo.blogspot.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
	//	System.out.println(links.size());
		
		for (WebElement link : links) {
			String linkURL=link.getAttribute("href");
			URI uri=new URI(linkURL);
			URL url=uri.toURL();
			URLConnection urlConnection=url.openConnection();
			HttpURLConnection httpURLConnection=(HttpURLConnection)urlConnection;
			httpURLConnection.setConnectTimeout(15000);
			httpURLConnection.connect();
			
			if (httpURLConnection.getResponseCode()!=200) {
				System.err.println(linkURL+" - "+ httpURLConnection.getResponseCode()+" - " +  	httpURLConnection.getResponseMessage());
			}
			httpURLConnection.disconnect();
		}
		
		driver.quit();
	}

}
