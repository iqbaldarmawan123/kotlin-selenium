package boilerplate.kotlin.Page

import junit.framework.Assert
import org.apache.commons.lang3.RandomStringUtils
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.support.ui.WebDriverWait
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

open class BasePageWeb(var driver: WebDriver)
{

    internal var stringBuilder = StringBuilder()
    internal var randomGenerator = Random()
    val dateFormat = SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
    val date = Date()

    init {
        PageFactory.initElements(driver, this)
    }

    fun getUrl(url: String) {
        return driver.get(url)
    }

    fun getElementById(id: String): WebElement {
        return driver.findElement(By.id(id))
    }

    fun getElementByName(name: String): WebElement {
        return driver.findElement(By.name(name))
    }

    fun getElementByClassName(className: String): WebElement {
        return driver.findElement(By.className(className))
    }

    fun getElementByXPath(xPath: String): WebElement {
        return driver.findElement(By.xpath(xPath))
    }

    fun getElementByCssSelector(cssSelector: String): WebElement {
        return driver.findElement(By.cssSelector(cssSelector))
    }

    fun getElementByTagName(tagName: String): WebElement {
        return driver.findElement(By.tagName(tagName))
    }

    fun getElementByLinkText(linkText: String): WebElement {
        return driver.findElement(By.linkText(linkText))
    }

    fun getElementByPartialLinkText(partialLinkText: String): WebElement {
        return driver.findElement(By.partialLinkText(partialLinkText))
    }

    fun clickElementById(id: String) {
        assertElementIsDisplayedById(id)
        getElementById(id).click()
    }

    fun clickElementByName(name: String) {
        assertElementIsDisplayedByName(name)
        getElementByName(name).click()
    }

    fun clickElementByClasName(className: String) {
        assertElementIsDisplayedByClassName(className)
        getElementByClassName(className).click()
    }

    fun clickElementByXpath(xpath: String) {
        assertElementIsDisplayedByXpath(xpath)
        getElementByXPath(xpath).click()
    }

    fun clickElementByCssSelector(cssSelector: String) {
        assertElementIsDisplayedByCssSelector(cssSelector)
        getElementByCssSelector(cssSelector).click()
    }

    fun clickElementByTagNme(tagName: String) {
        assertElementIsDisplayedByTagName(tagName)
        getElementByTagName(tagName).click()
    }

    fun clickElementByLinkText(linkText: String) {
        assertElementIsDisplayedByLinkText(linkText)
        getElementByLinkText(linkText).click()
    }

    fun clickElementByPartialLinkText(partialLinkText: String) {
        assertElementIsDisplayedByPartialLinkTex(partialLinkText)
        getElementByPartialLinkText(partialLinkText).click()
    }

    fun inputElementById(id: String, text: String) {
        assertElementIsDisplayedById(id)
        getElementById(id).sendKeys(text)
    }

    fun inputElementByName(name: String, text: String) {
        assertElementIsDisplayedByName(name)
        getElementByName(name).sendKeys(text)
    }

    fun inputElementByClasName(className: String, text: String) {
        assertElementIsDisplayedByClassName(className)
        getElementByClassName(className).sendKeys(text)
    }

    fun inputElementByXpath(xpath: String, text: String) {
        assertElementIsDisplayedByXpath(xpath)
        getElementByXPath(xpath).sendKeys(text)
    }

    fun inputElementByCssSelector(cssSelector: String, text: String) {
        assertElementIsDisplayedByCssSelector(cssSelector)
        getElementByCssSelector(cssSelector).sendKeys(text)
    }

    fun inputElementByTagNme(tagName: String, text: String) {
        assertElementIsDisplayedByTagName(tagName)
        getElementByTagName(tagName).sendKeys(text)
    }

    fun inputElementByLinkText(linkText: String, text: String) {
        assertElementIsDisplayedByLinkText(linkText)
        getElementByLinkText(linkText).sendKeys(text)
    }

    fun inputElementByPartialLinkText(partialLinkText: String, text: String) {
        assertElementIsDisplayedByPartialLinkTex(partialLinkText)
        getElementByPartialLinkText(partialLinkText).sendKeys(text)
    }

    fun getTextOrValueElementById(id: String): String {
        assertElementIsDisplayedById(id)
        return getElementById(id).getText()
    }

    fun getTextOrValueElementByName(name: String): String {
        assertElementIsDisplayedByName(name)
        return getElementByName(name).getText()
    }

    fun getTextOrValueElementByClassName(className: String): String {
        assertElementIsDisplayedByClassName(className)
        return getElementByClassName(className).getText()
    }

    fun getTextOrValueElementByXPath(xpath: String): String {
        assertElementIsDisplayedByXpath(xpath)
        return getElementByXPath(xpath).getText()
    }

    fun getTextOrValueElementByCssSelector(cssSelector: String): String {
        assertElementIsDisplayedByCssSelector(cssSelector)
        return getElementByCssSelector(cssSelector).getText()
    }

    fun getTextOrValueElementByTagName(tagName: String): String {
        assertElementIsDisplayedByTagName(tagName)
        return getElementByTagName(tagName).getText()
    }

    fun getTextOrValueElementByLinkText(linkText: String): String {
        assertElementIsDisplayedByLinkText(linkText)
        return getElementByLinkText(linkText).getText()
    }

    fun getTextOrValueElementByPartialLinkText(partialLinkText: String): String {
        assertElementIsDisplayedByPartialLinkTex(partialLinkText)
        return getElementByPartialLinkText(partialLinkText).getText()
    }

    fun assertTrue(message: String, condition: Boolean) {
        org.junit.Assert.assertTrue(message, condition)
    }

    fun assertEquals(message: String, expected: String, actual: String) {
        org.junit.Assert.assertEquals(message, expected, actual)
    }

    fun isElementPresent(webElement: WebElement): Boolean {
        return webElement.isDisplayed()
    }

    fun assertElementIsDisplayedById(id: String) {
        assertTrue(
            "Failed : " + getElementById(id).toString() + " Is Not Displayed",
            isElementPresent(getElementById(id))
        )
    }

    fun assertElementIsDisplayedByName(name: String) {
        assertTrue(
            "Failed : " + getElementByName(name).toString() + " Is Not Displayed",
            isElementPresent(getElementByName(name))
        )
    }

    fun assertElementIsDisplayedByClassName(className: String) {
        assertTrue(
            "Failed : " + getElementByClassName(className).toString() + " Is Not Displayed",
            isElementPresent(getElementByClassName(className))
        )
    }

    fun assertElementIsDisplayedByXpath(xpath: String) {
        assertTrue(
            "Failed : " + getElementByXPath(xpath).toString() + " Is Not Displayed",
            isElementPresent(getElementByXPath(xpath))
        )
    }

    fun assertElementIsDisplayedByCssSelector(cssSelector: String) {
        assertTrue(
            "Failed : " + getElementByCssSelector(cssSelector).toString() + " Is Not Displayed",
            isElementPresent(getElementByCssSelector(cssSelector))
        )
    }

    fun assertElementIsDisplayedByTagName(tagName: String) {
        assertTrue(
            "Failed : " + getElementByTagName(tagName).toString() + " Is Not Displayed",
            isElementPresent(getElementByTagName(tagName))
        )
    }

    fun assertElementIsDisplayedByLinkText(linkText: String) {
        assertTrue(
            "Failed : " + getElementByLinkText(linkText).toString() + " Is Not Displayed",
            isElementPresent(getElementByLinkText(linkText))
        )
    }

    fun assertElementIsDisplayedByPartialLinkTex(partialLinkText: String) {
        assertTrue(
            "Failed : " + getElementByPartialLinkText(partialLinkText).toString() + " Is Not Displayed",
            isElementPresent(getElementByPartialLinkText(partialLinkText))
        )
    }

    protected fun assertElementIsDisplayed(webElement: WebElement) {
        assertTrue("Failed : " + webElement.toString() + " Is Not Displayed", isElementPresent(webElement)!!)
    }

    fun assertTextElementIsEqualsById(id: String, expected: String) {
        val actual = getTextOrValueElementById(id)
        assertEquals("Failed : $actual Not Equals With $expected", expected, actual)
    }

    fun assertTextElementIsEqualsByName(name: String, expected: String) {
        val actual = getTextOrValueElementByName(name)
        assertEquals("Failed : $actual Not Equals With $expected", expected, actual)
    }

    fun assertTextElementIsEqualsByClassName(className: String, expected: String) {
        val actual = getTextOrValueElementByClassName(className)
        assertEquals("Failed : $actual Not Equals With $expected", expected, actual)
    }

    fun assertTextElementIsEqualsByXpath(xpath: String, expected: String) {
        val actual = getTextOrValueElementByXPath(xpath)
        assertEquals("Failed : $actual Not Equals With $expected", expected, actual)
    }

    fun assertTextElementIsEqualsByCssSelector(cssSelector: String, expected: String) {
        val actual = getTextOrValueElementByCssSelector(cssSelector)
        assertEquals("Failed : $actual Not Equals With $expected", expected, actual)
    }

    fun assertTextElementIsEqualsByTagName(tagName: String, expected: String) {
        val actual = getTextOrValueElementByTagName(tagName)
        assertEquals("Failed : $actual Not Equals With $expected", expected, actual)
    }

    fun assertTextElementIsEqualsByLinkText(linkText: String, expected: String) {
        val actual = getTextOrValueElementByLinkText(linkText)
        assertEquals("Failed : $actual Not Equals With $expected", expected, actual)
    }

    fun assertTextElementIsEqualsByPartialLinkText(partialLinkText: String, expected: String) {
        val actual = getTextOrValueElementByPartialLinkText(partialLinkText)
        assertEquals("Failed : $actual Not Equals With $expected", expected, actual)
    }

    fun assertTitlePageIsEquals(expected: String) {
        val actual = driver.getTitle()
        Assert.assertEquals("Failed : $actual Not Equals With $expected", expected, actual)
    }

//    protected fun checkTitleIsDisplayed(expected: String) {
//        val actual = driver.title
//        assertEquals("Failed : $actual Not Equals With $expected", expected, actual)
//    }

    //    fun waitForVisibilityOf(webElement: WebElement) {
//        val wait = WebDriverWait(driver, 10)
//        wait.until(ExpectedConditions.visibilityOf(webElement))
//    }

    fun waitForVisibilityOfElementById(id: String, timeOut: Int? = null) {
        val wait = WebDriverWait(driver, timeOut!!.toLong())
        wait.until(ExpectedConditions.visibilityOf(getElementById(id)))
    }

//    fun waitForClickabilityOfElementById(webElement: WebElement) {
//        val wait = WebDriverWait(driver, 10)
//        wait.until(ExpectedConditions.elementToBeClickable(webElement))
//    }


    fun WaitForClickabilityOf(webElement: WebElement, time: Int? = null) {
        val wait = WebDriverWait(driver, time!!.toLong())
        wait.until(ExpectedConditions.elementToBeClickable(webElement))
    }

    fun setValueToElement(webElement: WebElement, textToInput: String) {
        assertElementIsDisplayed(webElement)
        (driver as JavascriptExecutor).executeScript("arguments[0].innerHTML = '$textToInput'", webElement)
    }

    fun waitForPresenceOfElementById(id: String, timeout: Int? = null) {
        val wait = WebDriverWait(driver, timeout!!.toLong())
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)))
    }

    fun waitForPresenceOfElementByName(name: String, timeout: Int? = null) {
        val wait = WebDriverWait(driver, timeout!!.toLong())
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(name)))
    }

    fun waitForPresenceOfElementByClassName(className: String, timeout: Int? = null) {
        val wait = WebDriverWait(driver, timeout!!.toLong())
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)))
    }

    fun waitForPresenceOfElementByXpath(xpath: String, timeout: Int? = null) {
        val wait = WebDriverWait(driver, timeout!!.toLong())
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)))
    }

    fun waitForPresenceOfElementByCssSelector(cssSelector: String, timeout: Int? = null) {
        val wait = WebDriverWait(driver, timeout!!.toLong())
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)))
    }

    fun waitForPresenceOfElementByTagName(tagName: String, timeout: Int? = null) {
        val wait = WebDriverWait(driver, timeout!!.toLong())
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(tagName)))
    }

    fun waitForPresenceOfElementByLinkText(linkText: String, timeout: Int? = null) {
        val wait = WebDriverWait(driver, timeout!!.toLong())
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(linkText)))
    }

    fun waitForPresenceOfElementByPartialLinkText(partialLinkText: String, timeout: Int? = null) {
        val wait = WebDriverWait(driver, timeout!!.toLong())
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(partialLinkText)))
    }

    fun waitForDissapearOfElementByXpath(xPatb: String, timeout: Int? = null) {
        val wait = WebDriverWait(driver, timeout!!.toLong())
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(xPatb)))
    }

    fun getRandomNumberGenerator(amountNumber: Int): String {
        for (i in 0..amountNumber) {
            val randomInt = randomGenerator.nextInt(10)
            stringBuilder.append(randomInt)
        }
        return stringBuilder.toString()
    }

    fun delayThread(timeoutSecond: Int) {
        try {
            TimeUnit.SECONDS.sleep(timeoutSecond.toLong())
        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt()
        }

    }

    fun selectDropDownByVisibleText(webElement: WebElement, valueToSelect: String) {
        val select = Select(webElement)
        val options = select.options
        for (item in options) {
            if (item.text.contains(valueToSelect)) {
                select.selectByVisibleText(item.text)
                break
            }
        }
    }

    fun getRandomStringGenerator(length: Int): String {
        val useLetters = true
        val useNumbers = true
        return RandomStringUtils.random(length, useLetters, useNumbers)

    }

    fun threadSleep(milis:Long){
        Thread.sleep(milis)
    }

    fun scrollToElementByCssSelector(cssSelector: String){
        val element = getElementByCssSelector(cssSelector )
        (driver as JavascriptExecutor).executeScript("arguments[0].scrollIntoView();", element)

//        (driver as JavascriptExecutor).executeScript("window.scrollBy(0,500)")
    }
}