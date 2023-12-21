import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class LongPress extends LaunchAppium{

	public void longPressExample() throws InterruptedException {
		WebElement viewsTab = driver.findElement(AppiumBy.accessibilityId("Views"));
		viewsTab.click();
		WebElement expandList = driver.findElement(AppiumBy.accessibilityId("Expandable Lists"));
		expandList.click();
		
		WebElement cursorPeopleTab = driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter"));
		cursorPeopleTab.click();
		Thread.sleep(2000);
		
		WebElement elmt = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		longPressMethod(elmt,driver);
		Thread.sleep(2000);
	}
		public void longPressMethod(WebElement element, AppiumDriver driver) {
		// longPressEvent 
			((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
				    "elementId", ((RemoteWebElement) element).getId()
				));
		
	}
	
	public static void main(String[] args) throws Exception, InterruptedException {
		LongPress obj = new LongPress();
		obj.launchApp();
		obj.longPressExample();
	}

}

