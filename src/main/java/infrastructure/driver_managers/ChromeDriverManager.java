package infrastructure.driver_managers;

import infrastructure.DriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class ChromeDriverManager extends DriverManager {
    private ChromeDriverService service;

    @Override
    protected void startService() {
        if (service == null) {
            try {
                service = new ChromeDriverService.Builder ()
                        .usingDriverExecutable (new File ("D:/JAVA_COMMON/JAVA_HELPFUL/Selenium/chromedriver.exe"))
                        .usingAnyFreePort ()
                        .build ();
                service.start ();
            } catch (Exception e) {
                e.printStackTrace ();
            }
        }
    }

    @Override
    protected void stopService() {
        if (service != null && service.isRunning ())
            service.stop ();
    }

    @Override
    protected void createDriver() {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome ();
        ChromeOptions options = new ChromeOptions ();
        options.addArguments ("test-type");
        capabilities.setCapability (ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver (service, capabilities);
    }
}
