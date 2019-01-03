//package Platform.Mobile.DriverUtils
//
//import io.appium.java_client.AppiumDriver
//import io.appium.java_client.android.AndroidDriver
//import io.appium.java_client.pagefactory.AppiumFieldDecorator
//import org.apache.commons.exec.OsType
//import org.openqa.selenium.support.PageFactory
//
//abstract class Page(val driver: AppiumDriver<*>) {
//
//  val os = if (driver is AndroidDriver) OsType.ANDROID else OsType.IOS
//
//  init {
//    PageFactory.initElements(AppiumFieldDecorator(driver), this)
//  }
//}