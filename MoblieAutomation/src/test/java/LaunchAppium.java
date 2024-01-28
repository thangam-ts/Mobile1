import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class LaunchAppium {
	public AndroidDriver driver;
	
	public void launchApp() throws InterruptedException, MalformedURLException
	{
		  File app =new File("/Users/thangam/Downloads","ApiDemo.apk");		  
		  File js = new File("/usr/local/lib/node_modules/appium/build/lib/main.js");

		  AppiumDriverLocalService service =
		  new AppiumServiceBuilder()
		  .withAppiumJS(js)
		  .withIPAddress("127.0.0.1")
		  .withArgument(GeneralServerFlag.BASEPATH, "wd/hub")
		  .usingPort(4723)
		  .build();
		  service.start();

		
		  DesiredCapabilities dc = new DesiredCapabilities();
		 
		  Thread.sleep(2000);
		  dc.setCapability("app", app.getAbsolutePath());
		  dc.setCapability("deviceName", "emulator-5554");
		  dc.setCapability("platformName", "Android");
		  dc.setCapability("automationName","UiAutomator2");
		  
		  
		  Thread.sleep(2000);
		  URL url = new URL("http://127.0.0.1:4723/wd/hub");
		   driver = new AndroidDriver(url, dc);
		   
//		  driver.findElement(AppiumBy.accessibilityId("Preference")).click();
//		  driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
//	
	}


}

