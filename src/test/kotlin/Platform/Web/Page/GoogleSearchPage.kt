package boilerplate.kotlin.Page

import org.openqa.selenium.WebDriver

class GoogleSearchPage(driver: WebDriver) : BasePageWeb(driver) {


    fun checkTitileIsDisplayed() : GoogleSearchPage{
        assertTitlePageIsEquals("Google")
        return this
    }

    fun searchin (text : String) : GoogleSearchPage {
        inputElementByName("q",text)
        threadSleep(1000)
        return this
    }

    fun clickBtnSearch(): SearchResultsPage{
        clickElementByName("btnK")
        return SearchResultsPage(driver)
    }

}