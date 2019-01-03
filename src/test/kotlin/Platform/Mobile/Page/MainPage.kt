package Platform.Mobile.Page

import io.appium.java_client.AppiumDriver
import platform.android.modules.BasePageMobile


    class MainPage(driver: AppiumDriver<*>) : BasePageMobile(driver) {

        fun clickNumberOne(): MainPage{
            clickElement(getElementById("digit_1"))
            return this
        }

        fun clickNumberTwo(): MainPage{
            clickElement(getElementById("digit_2"))
            return this
        }
    }
