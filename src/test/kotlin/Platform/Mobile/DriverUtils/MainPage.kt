//package Platform.Mobile.DriverUtils
//
//import io.appium.java_client.AppiumDriver
//import io.appium.java_client.MobileElement
//import io.appium.java_client.android.AndroidDriver
//import io.appium.java_client.ios.IOSDriver
//import io.appium.java_client.pagefactory.AndroidFindBy
//import io.appium.java_client.pagefactory.iOSFindBy
//import io.appium.java_client.remote.AndroidMobileCapabilityType
//import io.appium.java_client.remote.MobileCapabilityType
//import org.openqa.selenium.remote.DesiredCapabilities
//import java.io.File
//import java.lang.Exception
//import java.net.URL
//
//class MainPage(driver: AppiumDriver<*>) : Page(driver) {
//
//
//    val androidDriver: AppiumDriver<*>
//        @Throws(Exception::class)
//        get() {
//            val appDir = File(Constants.DEFAULT_APP_PATH)
//            val app = File(appDir, Constants.DEFAULT_ANDROID_APP_NAME)
//            capabilities = DesiredCapabilities().android()
//            capabilities!!.setCapability(MobileCapabilityType.PLATFORM_VERSION, Constants.DEFAULT_ANDROID_PLATFORM_VERSION)
//            capabilities!!.setCapability(MobileCapabilityType.DEVICE_NAME, Constants.DEFAULT_ANDROID_DEVICE_NAME)
//            capabilities!!.setCapability(MobileCapabilityType.APP, app.absolutePath)
//            capabilities!!.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 520000)
//            capabilities!!.setCapability("--session-override", true)
//            capabilities!!.setCapability("avd", Constants.DEFAULT_ANDROID_DEVICE_NAME)
//            capabilities!!.setCapability("platformName", nativePlatform)
//            capabilities!!.setCapability("appWaitDuration", Constants.DEFAULT_ANDROID_APP_WAIT)
//            capabilities!!.setCapability("appPackage", Constants.DEFAULT_ANDROID_APP_PACKAGE)
//            capabilities!!.setCapability("appWaitActivity", Constants.DEFAULT_ANDROID_WAIT_ACTIVITY)
//            capabilities!!.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true)
//            capabilities!!.setCapability("unicodeKeyboard", true)
//            capabilities!!.setCapability("recreateChromeDriverSessions", true)
//            return AndroidDriver(URL(Constants.DEFAULT_WD_URL), capabilities)
//        }
//
//
//
//    val iosDriver: AppiumDriver<*>
//        @Throws(Exception::class)
//        get() {
//            val appDir = File(Constants.DEFAULT_APP_PATH)
//            val app = File(appDir, Constants.DEFAULT_IOS_APP_NAME)
//            capabilities = DesiredCapabilities()
//            return IOSDriver(URL(Constants.DEFAULT_WD_URL), capabilities)
//        }
//
//
//}