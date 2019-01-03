package boilerplate.kotlin.Test

import boilerplate.kotlin.driverutil.DriverFactory
import org.junit.After
import org.junit.Before
import org.openqa.selenium.WebDriver

open class BasePageTestWeb{

    lateinit var driver: WebDriver
        private set

    @Before
    fun setUp() {
        driver = DriverFactory.browser
        driver.get("https://www.google.com/")
    }

    @After
    fun tearDown() {
        driver.quit()
    }
}
