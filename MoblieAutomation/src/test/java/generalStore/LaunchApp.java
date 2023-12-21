package generalStore;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class LaunchApp {
	
public AndroidDriver driver;

public void appStart() throws InterruptedException, Exception
	{
		  File app =new File("/Users/thangam/Downloads/General-Store.apk");		  
		  File js = new File("/usr/local/lib/node_modules/appium/build/lib/main.js");

		  AppiumDriverLocalService service =
		  new AppiumServiceBuilder()
		  .withAppiumJS(js)
		  .withIPAddress("127.0.0.1")
		  .withArgument(GeneralServerFlag.BASEPATH, "wd/hub")
		  .usingPort(4723)
		  .build();
		  service.start();

		
		  DesiredCapabilities cap = new DesiredCapabilities();
		 
		  Thread.sleep(2000);
		  cap.setCapability("app", app.getAbsolutePath());
		  cap.setCapability("deviceName", "emulator-5554");
		  cap.setCapability("platformName", "Android");
		  cap.setCapability("automationName","UiAutomator2");
		  
		  Thread.sleep(2000);
		  driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	
	}	
	
}

