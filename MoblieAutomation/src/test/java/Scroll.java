import java.net.MalformedURLException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class Scroll extends LaunchAppium {
	
	public void scrollExample() throws InterruptedException {
		WebElement viewsTab = driver.findElement(AppiumBy.accessibilityId("Views"));
		viewsTab.click();
		
		Thread.sleep(2000);
		
		boolean canScrollMore;
		do {
			// Java
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 0.90
			));
		
	}while(canScrollMore);
	}
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		Scroll obj= new Scroll();
		obj.launchApp();
		obj.scrollExample();
	}
	
}
