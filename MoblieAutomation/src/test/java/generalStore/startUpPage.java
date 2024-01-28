package generalStore;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class startUpPage extends Base{
@Test

	public void countrySelect() throws InterruptedException {

//Country Select Drop Down
		WebElement dropdown = driver.findElement(By.id("android:id/text1"));
		dropdown.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));	
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector())"
				+ ".scrollIntoView(text(\"Canada\"));"));
				  
		driver.findElement(By.xpath("//android.widget.TextView[@text='Canada']")).click();
		
//Enter Your Name
		Thread.sleep(3000);
		WebElement nameField = driver.findElement(By.id("com.androidsample.generalstore:id/nameField"));
		nameField.sendKeys("thantrain10");
		driver.hideKeyboard();
		
//Select Gender
		WebElement gender=driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale"));
		Assert.assertTrue(gender.isDisplayed());
		gender.click();
		
//Check Let's Shop Button
		WebElement shop_button = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop"));
		if (shop_button.getText()== "Let's Shop") {
			System.out.println("Text on Let's shop button is correct");
		}
		else {System.out.println("Text needs to be checked & logged since text doesn't match");
		}
		shop_button.click();		
	}
	
	
//	public void addToCart() {
//		
//		WebElement item1= driver.findElement(By.xpath("//android.widget.TextView[@Text()='ADD TO CART']"));
//		item1.click();
//		
//		boolean canScrollMore;
//		do {
//			// Java
//			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
//			    "left", 100, "top", 100, "width", 200, "height", 200,
//			    "direction", "down",
//			    "percent", 0.90
//			));
//		
//	}while(canScrollMore);
//		WebElement item2= driver.findElement(By.xpath("//android.widget.TextView[@Text()='ADD TO CART']"));
//		item2.click();
//		
//	}
	
}

 