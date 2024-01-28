package generalStore;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class ToastMessage extends Base{
	
	@Test
		public void generalStoreHome() {
		
		
//Country Select Drop Down
		WebElement dropdown = driver.findElement(By.id("android:id/text1"));
		dropdown.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));	
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector())"
				+ ".scrollIntoView(text(\"Canada\"));"));
				  
		driver.findElement(By.xpath("//android.widget.TextView[@text='Canada']")).click();
		
// get a list of all the elements present in the dropdown list
		List<WebElement> dropdownOptions = driver.findElements(By.xpath("//android.widget.ListView[@index= 0]"));
		
		int totalDropdownOptions = dropdownOptions.size();
		System.out.println("No. of countries in dropdown List is : " + totalDropdownOptions );

//Enter Your Name	
//		WebElement nameField = driver.findElement(By.id("com.androidsample.generalstore:id/nameField"));
//		nameField.sendKeys("thantrain10");
//		driver.hideKeyboard();
		
//Select Gender
		WebElement gender = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale"));
		Assert.assertTrue(gender.isDisplayed());
		gender.click();	
		
//Let's Shop button
		WebElement shopButton = driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop"));
		Assert.assertEquals(shopButton.getText(), "Let's  Shop");	
		shopButton.click();
		
		
	}


}
