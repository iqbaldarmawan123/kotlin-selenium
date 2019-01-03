package Boilerplate.DriverUtils

import org.junit.After
import org.junit.Before
import org.openqa.selenium.remote.DesiredCapabilities
import io.appium.java_client.android.AndroidDriver
import java.net.URL
import java.nio.file.Paths
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.remote.MobileCapabilityType
import java.util.concurrent.TimeUnit
import io.appium.java_client.android.AndroidElement
import org.openqa.selenium.remote.RemoteWebDriver





open class AppiumTest {

  var os: OsType = OsType.ANDROID
  var driver: AppiumDriver<MobileElement>? = null


  @Before
  fun setup() {

    os = OsType.valueOf(System.getProperty("platform", OsType.ANDROID.name))
    val capabilities = DesiredCapabilities()
    val userDir = System.getProperty("user.dir")
//    val serverAddress = URL("http://0.0.0.0:4723/wd/hub")
    val baseURL = "http://0.0.0.0:"
    val minorURL = "/wd/hub"
    val port = "4723"


    if (os == OsType.ANDROID) {

      val caps = DesiredCapabilities()
      caps.setCapability("deviceName", "AndroiM")
      caps.setCapability("platformName", "Android")
      caps.setCapability("platformVersion", "6.0")
      caps.setCapability("appPackage", "com.android.calculator2")
      caps.setCapability("appActivity", "Calculator")
      caps.setCapability("automationName", "UiAutomator2")
      caps.setCapability("noReset", "true")
      var driver = AndroidDriver<AndroidElement>(URL("http://0.0.0.0:4723/wd/hub"), caps)



//      capabilities.setCapability("appiumVersion", "1.10.0")
//      capabilities.setCapability("platformName", "Android")
//      capabilities.setCapability("deviceName", "AndroidM")
//      capabilities.setCapability("automationName", "UiAutomator2")
//
//      val localApp = "android.apk"
//      val appPath = Paths.get(userDir, localApp).toAbsolutePath().toString()
//      capabilities.setCapability(MobileCapabilityType.APP, appPath)
//
//      driver = AndroidDriver(URL(baseURL + port + minorURL), capabilities)
//      driver = AndroidDriver(serverAddress, capabilities)
    } else {
      capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.7.1")
      capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS")
      capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone SE")
      capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest")

      val localApp = "ios.app"
      val appPath = Paths.get(userDir, localApp).toAbsolutePath().toString()
      capabilities.setCapability("app", appPath)

      driver = IOSDriver(URL(baseURL + port + minorURL), capabilities)
    }

    driver?.let {
      it.manage()?.timeouts()?.implicitlyWait(30, TimeUnit.SECONDS)
    }
  }

  @After
  fun tearDown() {
    driver?.quit()
  }
}
