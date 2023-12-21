import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;

public class DragDrop extends LaunchAppium{

	public void drapAndDrop() throws InterruptedException {
		//Click Views->Drag&Drop->
		driver.findElement(AppiumBy.accessibilityId("Views")).click();   //Click Views Button
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();  //Click drag & drop

		Thread.sleep(2000);
		//long press
		WebElement dotLongPress = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
	
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement) dotLongPress).getId(),
				"endX", 365,
				"endY", 434   
				));
		Thread.sleep(2000);
		String displayedText = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.TextView[2]")).getText();
		
		
		//String displayedText = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.TextView[2]"));
		System.out.println("Dropped Text is visible");
		Assert.assertEquals(displayedText, "Dropped!");
		
	}

	public static void main(String[] args) throws InterruptedException, MalformedURLException{
		DragDrop drag = new DragDrop();
		drag.launchApp();
		drag.drapAndDrop();

	}
}

