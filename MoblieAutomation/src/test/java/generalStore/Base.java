package generalStore;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class Base {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	
	public void configureAppium() throws MalformedURLException {
		
		//File app =new File("/Users/thangam/Downloads/ApiDemo.apk");	
		File app =new File("/Users/thangam/Downloads/General-Store.apk");	
		File js = new File("/usr/local/lib/node_modules/appium/build/lib/main.js");

		 service =
				  new AppiumServiceBuilder()
				  .withAppiumJS(js)
				  .withIPAddress("127.0.0.1")
				  .withArgument(GeneralServerFlag.BASEPATH, "wd/hub")
				  .usingPort(4723)
				  .build();
				  service.start();
		
		//Create Desired Capabilities	  
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("app", app.getAbsolutePath());
		cap.setCapability("deviceName", "emulator-5554");
		cap.setCapability("platformName", "Android");
		cap.setCapability("automationName","UiAutomator2");
				  
		//Create object for Android driver	 
		URL url =new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver(url , cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));				  
		
	}
	
	//Scroll as long as the App has element 
	public void scrollToEnd() {
		Boolean canScrollMore;
		do{					
		canScrollMore = (Boolean) ((JavascriptExecutor) driver)
				.executeScript("mobile: scrollGesture", ImmutableMap.of(
				 "left", 100, "top", 100, "width", 200, "height", 200,
				 "direction", "down",
					  "percent", 0.90
				));
		} while(canScrollMore);
	}
	
	//Scroll to Specific Element
	public void scrollToElement(String element) {
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector())"
				+ ".scrollIntoView(text(\"element\"));"));
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();    //Closes the app
		service.stop();   //Stops Appium Server
	}
	//Create Capabilities
			/*UiAutomator2Options options=new UiAutomator2Options();
			options.setDeviceName("emulator-5554");
			options.setApp(System.getProperty("app", app.getAbsolutePath()));
			
			//Create object for Android driver
			AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
			
			*/
	
}
