package generalStore;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class ScrollPage extends Base{
	
	@Test
	public void scrollViews() {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		scrollToEnd();  //Scroll to end of page
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
		
		
		//scrollToElement("WebView");  //Scroll until view an element -> WebView
	}
	
}
