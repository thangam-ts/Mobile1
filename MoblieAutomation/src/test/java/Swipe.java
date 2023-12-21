import java.net.MalformedURLException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class Swipe extends LaunchAppium {
	
	public void swipeExample() throws InterruptedException {
		WebElement viewsTab = driver.findElement(AppiumBy.accessibilityId("Views"));
		viewsTab.click();
		Thread.sleep(1000);
		
		WebElement gallery = driver.findElement(AppiumBy.accessibilityId("Gallery"));
		gallery.click();
		Thread.sleep(2000);
		
		WebElement photos = driver.findElement(AppiumBy.accessibilityId("1. Photos"));
		photos.click();
		Thread.sleep(2000);
		
		
		WebElement image1 = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.Gallery/android.widget.ImageView[1]"));
		//image1.click();
		
			// Swipe Right
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId",((RemoteWebElement)image1).getId(), 
			    "direction", "left",
			    "percent", 0.75
			));
		
	
	}
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		Swipe obj= new Swipe();
		obj.launchApp();
		obj.swipeExample();
	}
	
}
