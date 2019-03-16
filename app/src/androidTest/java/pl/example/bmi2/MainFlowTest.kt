package pl.example.bmi2


import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainFlowTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainFlowTestPositive() {
        val inputHeight = onView(withId(R.id.heightInput))
        inputHeight.perform(replaceText("180"), closeSoftKeyboard())

        val appCompatEditText5 = onView(withId(R.id.weightInput))
        appCompatEditText5.perform(replaceText("110"), closeSoftKeyboard())

        val appCompatButton = onView(withId(R.id.calculateButton))
        appCompatButton.perform(click())

        val textView = onView(withId(R.id.bmiResult))
        textView.check(matches(withText("34,0")))
    }

    @Test
    fun mainFlowTestNegative() {
        val inputHeight = onView(withId(R.id.heightInput))
        inputHeight.perform(replaceText("180"), closeSoftKeyboard())

        val appCompatEditText5 = onView(withId(R.id.weightInput))
        appCompatEditText5.perform(replaceText("400"), closeSoftKeyboard())

        val appCompatButton = onView(withId(R.id.calculateButton))
        appCompatButton.perform(click())

        val textView = onView(withId(R.id.bmiResult))
        textView.check(matches(withText("0,0")))
    }
}
