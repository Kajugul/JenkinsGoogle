package TestCases;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
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
public class BuildTest
{
    public WebDriver driver;
    ExtentTest extent;

    @Test(description = "build test")
    public void verifytitle(Method method) throws InterruptedException
    {
        extent = ExtentTestManager.startTest(method.getName(), "verifytitle");

        extent.log(LogStatus.INFO, "initiating webdriver");
    }

}
