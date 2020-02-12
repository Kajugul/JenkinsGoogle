package TestCases;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.ExtentReports.ExtentTestManager;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;


@Listeners(Listen.TestListener.class)
public class JenkinsTesting
{
    public WebDriver driver;
    ExtentTest extent;

    @Test(description = "Google launch testing.")
    public void verifytitle(Method method) throws InterruptedException
    {
        extent = ExtentTestManager.startTest(method.getName(), "verifytitle");

        extent.log(LogStatus.INFO, "initiating webdriver");
        //WebDriverManager.chromedriver().setup();
        System.out.println("Initialing the browser for you....Please wait...");
        String chromeDriverPath = System.getProperty("user.dir") + "//Datafiles//chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
       // driver = new ChromeDriver();
        extent.log(LogStatus.INFO, "webdriver initiated successfully.");

        extent.log(LogStatus.INFO, "maximizing the window");
        driver.manage().window().maximize();
        extent.log(LogStatus.INFO, "window maximizing successfully.");

        driver.manage().timeouts().pageLoadTimeout(40000, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        extent.log(LogStatus.INFO, "launching the google site");
        driver.get("https://www.google.com/");
        extent.log(LogStatus.INFO, "google site lauched successfully.");

        extent.log(LogStatus.INFO, "verifing the title it should failed");
        Assert.assertEquals(driver.getTitle(), "Google");
        extent.log(LogStatus.INFO, "title verified successfully.");

        Thread.sleep(2000);
    }

    public WebDriver getWebDriver()
    {
        return driver;
        // time pass
    }

    @AfterTest
    public void close()
    {
        driver.quit();
    }
}
