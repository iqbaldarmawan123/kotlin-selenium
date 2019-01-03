import boilerplate.kotlin.Page.GoogleSearchPage
import boilerplate.kotlin.Test.BasePageTestWeb
import org.junit.Test

class HomeGooglePageTest : BasePageTestWeb() {

    @Test
    fun exampleTest() {
        GoogleSearchPage(driver)
            .checkTitileIsDisplayed()
            .searchin("cobacoba")
            .clickBtnSearch()
            .checkTitlePageResultSearchIsDisplayed()
    }

}