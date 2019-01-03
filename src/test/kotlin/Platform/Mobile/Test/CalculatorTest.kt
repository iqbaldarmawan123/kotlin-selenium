package Boilerplate.Test

import Boilerplate.DriverUtils.AppiumTest
import Platform.Mobile.Page.MainPage
import org.junit.Test

class CalculatorTest : AppiumTest() {

  @Test
  fun login() {
   MainPage(driver!!)
     .clickNumberOne()
     .clickNumberTwo()
  }
}
