package platform.android.modules

import Boilerplate.DriverUtils.OsType
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.TouchAction
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.AndroidKeyCode
import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.AndroidFindBySet
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import org.apache.commons.io.IOUtils
import org.junit.Assert
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

import java.io.*
import java.nio.charset.StandardCharsets
import java.text.DateFormatSymbols
import java.time.Duration
import java.time.LocalDate
import java.util.ArrayList
import java.util.Random
import java.util.concurrent.TimeUnit


abstract class BasePageMobile(var driver : AppiumDriver<*>)
{


    private val touchAction = TouchAction(this.driver)
    internal var stringBuilder = StringBuilder()
    internal var randomGenerator = Random()

    @AndroidFindBySet(AndroidFindBy(id = datePickerView), AndroidFindBy(className = "android.view.View"))
     var eachDayNumberView: List<MobileElement>? = null

    @AndroidFindBySet(
        AndroidFindBy(id = "recycleTemplate"),
        AndroidFindBy(id = "layoutRoot"),
        AndroidFindBy(id = "textName")
    )
     var listOfLayoutText: List<MobileElement>? = null



    init {
        this.driver = appiumDriver
//        PageFactory.initElements(AppiumFieldDecorator(appiumDriver), this)
    }

    val os = if (driver is AndroidDriver) OsType.ANDROID else OsType.IOS

    init {
        PageFactory.initElements(AppiumFieldDecorator(driver), this)
    }

    fun waitPageElement() {}

    fun assertTrue(message: String, condition: Boolean) {
        Assert.assertTrue(message, condition)
    }

     fun assertFalse(message: String, condition: Boolean) {
        Assert.assertFalse(message, condition)
    }

     fun assertEquals(message: String, expected: String, actual: String) {
        Assert.assertEquals(message, expected, actual)
    }

     fun assertNotEquals(message: String, notExpected: String, actual: String) {
        Assert.assertNotEquals(message, notExpected, actual)
    }

     fun assertElementIsDisplayed(mobileElement: MobileElement) {
        assertTrue("Failed : " + mobileElement.toString() + "Is Not Displayed", isElementPresent(mobileElement)!!)
    }

    fun assertTextElementIsEquals(mobileElement: MobileElement, expected: String) {
        val actual = getTextOrValueElement(mobileElement)
        assertEquals("Failed : $actual Not Equals With $expected", expected, actual)
    }

    fun assertTextElementNotEquals(mobileElement: MobileElement, notExpected: String) {
        val actual = getTextOrValueElement(mobileElement)
        assertNotEquals("Failed : $actual Equals With $notExpected", notExpected, actual)
    }

    fun assertTextElementIsNotEquals(mobileElement: MobileElement, expected: String) {
        val actual = getTextOrValueElement(mobileElement)
        assertEquals("Failed : $actual Equals With $expected", expected, actual)
    }

    fun clickElement(mobileElement: MobileElement) {
        assertElementIsDisplayed(mobileElement)
        mobileElement.click()
    }

    fun clearTextOnElement(mobileElement: MobileElement) {
        assertElementIsDisplayed(mobileElement)
        mobileElement.clear()
    }

     fun inputTextToElement(mobileElement: MobileElement, textToInput: String) {
        assertElementIsDisplayed(mobileElement)
        mobileElement.sendKeys(textToInput)
        //        appiumDriver.hideKeyboard();
    }

     fun setTextToElement(mobileElement: MobileElement, textToInput: String) {
        assertElementIsDisplayed(mobileElement)
        mobileElement.setValue(textToInput)
        appiumDriver.hideKeyboard()
    }

     fun getTextOrValueElement(mobileElement: MobileElement): String {
        assertElementIsDisplayed(mobileElement)
        return mobileElement.text
    }

     fun isElementPresent(mobileElement: MobileElement): Boolean? {
        return mobileElement.isDisplayed
    }

     fun waitForVisibilityOf(webElement: WebElement) {
        val wait = WebDriverWait(appiumDriver, 15)
        wait.until(ExpectedConditions.visibilityOf(webElement))
    }

     fun waitForVisibilityOf(webElement: WebElement, timeOut: Int) {
        val wait = WebDriverWait(appiumDriver, timeOut.toLong())
        wait.until(ExpectedConditions.visibilityOf(webElement))
    }

     fun waitForClickabilityOf(webElement: WebElement) {
        val wait = WebDriverWait(appiumDriver, 15)
        wait.until(ExpectedConditions.elementToBeClickable(webElement))
    }

     fun WaitForClickabilityOf(webElement: WebElement, time: Int) {
        val wait = WebDriverWait(appiumDriver, time.toLong())
        wait.until(ExpectedConditions.elementToBeClickable(webElement))
    }

     fun waitForInvisibilityOf(mobileElement: MobileElement) {
        val wait = WebDriverWait(appiumDriver, 15)
        wait.until(ExpectedConditions.invisibilityOf(mobileElement))
    }

     fun waitForInvisibilityOf(mobileElement: MobileElement, timeOut: Int) {
        val wait = WebDriverWait(appiumDriver, timeOut.toLong())
        wait.until(ExpectedConditions.invisibilityOf(mobileElement))
    }

     fun waitForPresenceOfElementById(id: String) {
        val wait = WebDriverWait(appiumDriver, 15)
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)))
    }

     fun waitForPresenceOfElementById(id: String, timeout: Int) {
        val wait = WebDriverWait(appiumDriver, timeout.toLong())
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)))
    }

     fun waitForPresenceOfElementByXpath(xpath: String) {
        val wait = WebDriverWait(appiumDriver, 15)
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)))
    }

     fun waitForPresenceOfElementByXpath(xpath: String, timeout: Int) {
        val wait = WebDriverWait(appiumDriver, timeout.toLong())
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)))
    }

     fun waitForClickableOfElementById(id: String) {
        val wait = WebDriverWait(appiumDriver, 15)
        wait.until(ExpectedConditions.elementToBeClickable(By.id(id)))
    }

     fun waitForClickableOfElementById(id: String, timeout: Int) {
        val wait = WebDriverWait(appiumDriver, timeout.toLong())
        wait.until(ExpectedConditions.elementToBeClickable(By.id(id)))
    }

     fun getElementById(id: String): MobileElement {
        return appiumDriver.findElement(By.id(id)) as MobileElement
    }

     fun getElementByCssSelector(cssSelector: String): MobileElement {
        return appiumDriver.findElement(By.cssSelector(cssSelector)) as MobileElement
    }

     fun getElementByXPath(xPath: String): MobileElement {
        return appiumDriver.findElement(By.xpath(xPath)) as MobileElement
    }

     fun getElementByClassName(className: String): MobileElement {
        return appiumDriver.findElement(By.className(className)) as MobileElement
    }

     fun getElementByName(name: String): MobileElement {
        return appiumDriver.findElement(By.name(name)) as MobileElement
    }

     fun getElementByTagName(tagName: String): MobileElement {
        return appiumDriver.findElement(By.tagName(tagName)) as MobileElement
    }

     fun getElementByLinkText(linkText: String): MobileElement {
        return appiumDriver.findElement(By.linkText(linkText)) as MobileElement
    }

     fun getElementByPartialLinkText(partialLinkText: String): MobileElement {
        return appiumDriver.findElement(By.partialLinkText(partialLinkText)) as MobileElement
    }

    fun slideInteraction(mobileElement: MobileElement, mobileElement2: MobileElement) {
        assertElementIsDisplayed(mobileElement)
        assertElementIsDisplayed(mobileElement2)
        touchAction.press(mobileElement).moveTo(mobileElement2).perform().release().cancel()
    }

     fun dragElement(mobileElement1: MobileElement, mobileElement2: MobileElement) {
        assertElementIsDisplayed(mobileElement1)
        assertElementIsDisplayed(mobileElement2)
        touchAction.longPress(mobileElement1).waitAction(Duration.ofSeconds(2)).moveTo(mobileElement2).perform()
            .release()
    }

    fun swipeScreenWithPress(xElement: MobileElement, yElement: MobileElement, fromBottom: Boolean?) {
        val upperHeight = xElement.location.getY()
        val bottomHeight = xElement.size.getHeight() + upperHeight
        val upperHeight1 = yElement.location.getY()
        val bottomHeight1 = yElement.size.getHeight() + upperHeight1
        val middleScreen = appiumDriver.manage().window().size.width / 2

        val touchAction = TouchAction(appiumDriver)
        if (fromBottom!!) {
            touchAction.press(middleScreen, bottomHeight).waitAction(Duration.ofMillis(200))
                .moveTo(middleScreen, bottomHeight1).release().perform()
        } else {
            touchAction.press(middleScreen, upperHeight).waitAction(Duration.ofMillis(200))
                .moveTo(middleScreen, upperHeight1).release().perform()
        }
    }

    fun swipeScreenWithLongPress(xElement: MobileElement, yElement: MobileElement, fromBottom: Boolean?) {
        val upperHeight = xElement.location.getY()
        val bottomHeight = xElement.size.getHeight() + upperHeight
        val upperHeight1 = yElement.location.getY()
        val bottomHeight1 = yElement.size.getHeight() + upperHeight1
        val middleScreen = appiumDriver.manage().window().size.width / 2

        val touchAction = TouchAction(appiumDriver)
        if (fromBottom!!) {
            touchAction.longPress(middleScreen, bottomHeight).waitAction(Duration.ofMillis(200))
                .moveTo(middleScreen, bottomHeight1).release().perform()
        } else {
            touchAction.longPress(middleScreen, upperHeight).waitAction(Duration.ofMillis(200))
                .moveTo(middleScreen, upperHeight1).release().perform()
        }
    }

    private fun getListElementById(id: String): List<MobileElement> {
        return appiumDriver.findElements(By.id(id)) as List<MobileElement>
    }

     fun openNotification() {
        (appiumDriver as AndroidDriver<*>).openNotifications()
    }



     fun getRandomNumberGenerator(amountNumber: Int): String {
        for (i in 0..amountNumber) {
            val randomInt = randomGenerator.nextInt(10)
            stringBuilder.append(randomInt)
        }
        return stringBuilder.toString()
    }

     fun getRandomNumberAndCharGenerator(amountNumber: Int): String {
        val charsToRandom = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
        val chars = StringBuilder()
        val rnd = Random()
        while (chars.length < 15) { // length of the random string.
            val index = (rnd.nextFloat() * charsToRandom.length).toInt()
            chars.append(charsToRandom[index])
        }
        return chars.toString()
    }



     fun clickBackBtnDefaultAndroid() {
        (appiumDriver as AndroidDriver<*>).pressKeyCode(AndroidKeyCode.BACK)
    }

     fun sendEnterKeyboardAndroid() {
        (appiumDriver as AndroidDriver<*>).pressKeyCode(AndroidKeyCode.ENTER)
    }

     fun sendCommandLineTerminal(command: String) {
        val process: Process
        try {
            process = Runtime.getRuntime().exec(command)
            process.waitFor()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

     fun switchNativeCtx() {
        appiumDriver.context("NATIVE_APP")
    }

     fun writeTextToFile(fileName: String, textToWrite: String) {
        try {
            val out = BufferedWriter(FileWriter(fileName, true))
            out.write(textToWrite)
            out.newLine()
            out.close()

        } catch (e: IOException) {
            e.printStackTrace()
        }

    }

     fun replaceTextOnFileLastIndex(fileName: String, textToReplace: String, replacementText: String) {
        try {
            var content = IOUtils.toString(FileInputStream(fileName), StandardCharsets.UTF_8)
            content = content.replace(textToReplace.toRegex(), replacementText)
            IOUtils.write(content, FileOutputStream(fileName), StandardCharsets.UTF_8)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

//     fun readLastIndexTextFromFile(fileName: String): String {
//        var currentLine: String
//        var lastLine = ""
//        try {
//            val bufferedReader = BufferedReader(FileReader(fileName))
//            while ((currentLine = bufferedReader.readLine()) != null) {
//                lastLine = currentLine
//            }
//            bufferedReader.close()
//        } catch (e: FileNotFoundException) {
//            e.printStackTrace()
//        } catch (e: IOException) {
//            e.printStackTrace()
//        }
//
//        return lastLine
//    }

    fun delayThread(timeoutInMilliSeconds: Int) {
        try {
            TimeUnit.MILLISECONDS.sleep(timeoutInMilliSeconds.toLong())
        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt()
        }

    }



    fun swipeIfElementNotAppear(elementToFind: String) {
        val middleScreenX = appiumDriver.manage().window().size.width / 2
        val middleScreenY = appiumDriver.manage().window().size.height / 2
        val upperScreenY = (appiumDriver.manage().window().size.getHeight() * 0.20).toInt()
        while (!appiumDriver.pageSource.contains(elementToFind)) {
            touchAction.press(middleScreenX, middleScreenY).waitAction(Duration.ofMillis(200))
                .moveTo(middleScreenX, upperScreenY).release().perform()
        }
    }



    fun addedMonthFromCurrentDate(monthCount: Int): String {
        val futureDate = LocalDate.now().plusMonths(monthCount.toLong())
        val date = futureDate.toString().split("-".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        val monthString = DateFormatSymbols().months[Integer.parseInt(date[1]) - 1]
        return date[2] + "-" + monthString + "-" + date[0]
    }

     fun isElementEnabled(mobileElement: MobileElement): Boolean? {
        return mobileElement.isEnabled
    }

    fun assertElementIsEnabled(mobileElement: MobileElement) {
        assertTrue("Failed : " + mobileElement.toString() + "Is Not Enabled", isElementEnabled(mobileElement)!!)
    }

     fun isElementSelected(mobileElement: MobileElement): Boolean? {
        return mobileElement.isSelected
    }

    fun assertElementIsSelected(mobileElement: MobileElement) {
        assertTrue("Failed : " + mobileElement.toString() + "Is Not Selected", isElementSelected(mobileElement)!!)
    }

    companion object {
         lateinit var appiumDriver: AppiumDriver<*>
        private const val datePickerView = "month_view"

         fun switchToWebViewContext() {
            val handles = appiumDriver.contextHandles
            val handlesList = ArrayList(handles)
            val webView = handlesList[1]
            appiumDriver.context(webView)
        }
    }
}
