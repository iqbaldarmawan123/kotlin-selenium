package boilerplate.kotlin.Page

import org.openqa.selenium.WebDriver

class SearchResultsPage(driver: WebDriver) : BasePageWeb(driver){

    fun checkTitlePageResultSearchIsDisplayed() : SearchResultsPage{
        assertTitlePageIsEquals("cobacoba - Penelusuran Google")
        return this
    }
}