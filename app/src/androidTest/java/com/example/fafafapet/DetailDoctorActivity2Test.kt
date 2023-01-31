package com.example.fafafapet

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import junit.framework.TestCase
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

class DetailDoctorActivity2Test : TestCase()

@RunWith(AndroidJUnit4::class)
class MainTest{

    @Rule
    @JvmField
    var activityTestsRule = ActivityTestRule(PetForm::class.java)

    @Test

    fun navigateToPetForm(){
        onView(withId(R.id.btn_Submit))
            .perform(click())

        onView(withId(R.id.pet_list_activity))
            .check(matches(isDisplayed()))
    }

    fun backPress(){
        onView(withId(R.id.btn_Submit))
            .perform(click())

        onView(withId(R.id.pet_list_activity))
            .check(matches(isDisplayed()))

        Espresso.pressBack()

        onView(withId(R.id.pet_form_activity))
            .check(matches(isDisplayed()))
    }
}