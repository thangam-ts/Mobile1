package generalStore;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class startUpPage extends LaunchApp{

	public void countrySelect() throws InterruptedException {
		
//		WebElement dropdown = driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry"));
//		Select country = new Select(dropdown);
//		//country.selectByIndex(4);
//		Thread.sleep(3000);
//		country.selectByVisibleText("Afghanistan");
		//System.out.println("First Selected is " + country.getFirstSelectedOption());

		
		//Enter Your Name
		Thread.sleep(3000);
		WebElement nameField = driver.findElement(By.id("com.androidsample.generalstore:id/nameField"));
		nameField.sendKeys("thantrain10");
		driver.hideKeyboard();
		
		//Select Gender
		Thread.sleep(3000);
		WebElement gender=driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale"));
		Assert.assertTrue(gender.isDisplayed());
		gender.click();
		
		//Check Let's Shop Button
		Thread.sleep(3000);
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
	public static void main(String[] args) throws InterruptedException, Exception {
		startUpPage obj = new startUpPage();
		obj.appStart();
		obj.countrySelect();
	}
}

 