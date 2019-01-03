//package Platform.Mobile.DriverUtils;
//
//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.ios.IOSDriver;
//import io.appium.java_client.remote.AndroidMobileCapabilityType;
//import io.appium.java_client.remote.MobileCapabilityType;
//import org.openqa.selenium.Point;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//
//import java.awt.*;
//import java.io.File;
//import java.net.URL;
//import java.util.concurrent.TimeUnit;
//
//
//public class DriverBuilder {
//    private static int[] screenDimension;
//    private static AppiumDriver appiumDriver = null;
//    private static String platform;
//    private static String nativePlatform;
//    private static DesiredCapabilities capabilities;
//    Process process;
//
//    public void setPlatform(String platform) {
//        this.platform = platform;
//    }
//
//    public void setNativePlatform(String nativePlatform) {
//        this.nativePlatform = nativePlatform;
//    }
//
//    public static String getPlatform() {
//        return platform;
//    }
//
//    public static String getNativePlatform() {
//        return nativePlatform;
//    }
//
//    public static void setDriver() throws Exception {
//        if (getPlatform().equalsIgnoreCase("Web")) {
//            setWebDriver();
//        } else {
//            setNativeDriver();
//        }
//    }
//
//    public static AppiumDriver getAppiumDriver() {
//        return appiumDriver;
//    }
//
//
//    public static void setNativeDriver() throws Exception {
//        appiumDriver = getNativePlatform().equalsIgnoreCase("Android") ? getAndroidDriver() : getIOSDriver();
//    }
//
//    public static AppiumDriver getAndroidDriver() throws Exception {
//        File appDir = new File(Constants.DEFAULT_APP_PATH);
//        File app = new File(appDir, Constants.DEFAULT_ANDROID_APP_NAME);
//        capabilities = new DesiredCapabilities().android();
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, Constants.DEFAULT_ANDROID_PLATFORM_VERSION);
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, Constants.DEFAULT_ANDROID_DEVICE_NAME);
//        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
//        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 520000);
//        capabilities.setCapability("--session-override", true);
//        capabilities.setCapability("avd", Constants.DEFAULT_ANDROID_DEVICE_NAME);
//        capabilities.setCapability("platformName", getNativePlatform());
//        capabilities.setCapability("appWaitDuration", Constants.DEFAULT_ANDROID_APP_WAIT);
//        capabilities.setCapability("appPackage", Constants.DEFAULT_ANDROID_APP_PACKAGE);
//        capabilities.setCapability("appWaitActivity", Constants.DEFAULT_ANDROID_WAIT_ACTIVITY);
//        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
//        capabilities.setCapability("unicodeKeyboard", true);
//        capabilities.setCapability("recreateChromeDriverSessions", true);
//        return new AndroidDriver(new URL(Constants.DEFAULT_WD_URL), capabilities);
//    }
//
//    public static AppiumDriver getIOSDriver() throws Exception {
//        File appDir = new File(Constants.DEFAULT_APP_PATH);
//        File app = new File(appDir, Constants.DEFAULT_IOS_APP_NAME);
//        capabilities = new DesiredCapabilities();
////        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, Constants.DEFAULT_IOS_PLATFORM_VERSION);
////        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, Constants.DEFAULT_IOS_DEVICE_NAME);
////        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
////        capabilities.setCapability("bundleId", "**TBD**"); //todo set from script
////        capabilities.setCapability("newCommandTimeout", 720000);
////        capabilities.setCapability("launchTimeout", 720000);
////        capabilities.setCapability("locationServicesAuthorized", true);
////        capabilities.setCapability("locationServicesEnabled", true);
////        capabilities.setCapability("autoAcceptAlerts", true);
////        capabilities.setCapability("fullReset", false);
////        capabilities.setCapability("noReset", true);
//        return new IOSDriver(new URL(Constants.DEFAULT_WD_URL), capabilities);
//    }
//
//
//    public void executeShFile(String port, String longitude, String latitude) {
//        try {
//            process = Runtime.getRuntime().exec("sh mockLocation.sh "+port+" "+longitude+" "+latitude);
//            process.waitFor();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//}
