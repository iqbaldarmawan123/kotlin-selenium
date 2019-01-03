package Platform.Mobile.DriverUtils

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.openqa.selenium.By
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.net.MalformedURLException
import java.net.URL

class ioSampleTest {

    lateinit var driver: AppiumDriver<MobileElement>
    lateinit var wait: WebDriverWait

    //Elements
    internal var secondNewJob =
        "//android.widget.FrameLayout[2]/android.widget.LinearLayout/" + "android.widget.RelativeLayout/android.widget.ImageView"

    @Before
    @Throws(MalformedURLException::class)
    fun setup() {
        val caps = DesiredCapabilities()
        caps.setCapability("deviceName", "AndroidM")
//        caps.setCapability("udid", "WUJ01N4RQ3") //DeviceId from "adb devices" command
        caps.setCapability("platformName", "Android")
        caps.setCapability("platformVersion", "6.0")
        caps.setCapability("skipUnlock", "true")
        caps.setCapability("noReset", "false")
        caps.setCapability("appPackage", "com.android.calculator2")
        caps.setCapability("appActivity", "Calculator")
        driver = AndroidDriver<MobileElement>(URL("http://0.0.0.0:4723/wd/hub"), caps)
        wait = WebDriverWait(driver, 10)
    }

    @Test
    @Throws(InterruptedException::class)
    fun basicTest() {
        //Click and pass Splash

        val el = driver.findElement(By.id("digit_1"))
//        val el2 = driver.findElementByAccessibilityId("digit_5")
        el.click()
//        el2.click()


        //Click and pass Tutorial
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("digit_3"))).click()

        //Click to "Is Ariyorum" Button
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.isinolsun.app:id/bluecollar_type_button")))
//            .click()
//
//
//        //Notification Allow
//        if (driver.findElements(By.id("com.android.packageinstaller:id/permission_allow_button")).size > 0) {
//            driver.findElements(By.id("com.android.packageinstaller:id/permission_allow_button")).get(0).click()
//        }
//
//        //Click second job
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(secondNewJob))).click()

    }

    @After
    fun teardown() {
        driver.quit()
    }

}