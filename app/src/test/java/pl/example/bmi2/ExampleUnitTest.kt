package pl.example.bmi2

import org.junit.Assert.assertEquals
import org.junit.Test
import pl.example.bmi2.logic.BmiForKgCm
import pl.example.bmi2.logic.BmiForLbIn

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

class ExampleUnitTest {

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun for_valid_mass_and_height_should_return_bmi_kgCm() {
        // GIVEN
        val mass = 65
        val height = 170
        // WHEN
        val bmi = BmiForKgCm(mass, height)
        // THEN
        assertEquals(22.491, bmi.countBmi(), 0.001)
    }

    @Test
    fun for_valid_mass_and_height_should_return_bmi_lbFt() {
        // GIVEN
        val mass = 200.5
        val height = 78.6
        // WHEN
        val bmi = BmiForLbIn(mass, height)
        // THEN
        assertEquals(22.815, bmi.countBmi(), 0.001)
    }

    @Test
    fun for_invalid_mass_kg_bmi_should_equal_zero() {
        // GIVEN
        val height = 180
        val mass = 500

        // WHEN
        var bmi = BmiForKgCm(mass, height).countBmi()
        // THEN
        assertEquals(0.0, bmi, 0.01)
    }

    @Test
    fun for_invalid_height_cm_bmi_should_equal_zero() {
        // GIVEN
        val height = 330
        val mass = 120

        // WHEN
        var bmi = BmiForKgCm(mass, height).countBmi()
        // THEN
        assertEquals(0.0, bmi, 0.01)
    }

    @Test
    fun for_invalid_height_inches_bmi_should_equal_zero() {
        // GIVEN
        val height = 118.11
        val mass = 264.55

        // WHEN
        var bmi = BmiForLbIn(mass, height).countBmi()
        // THEN
        assertEquals(0.0, bmi, 0.01)
    }

    @Test
    fun for_invalid_mass_lbs_bmi_should_equal_zero() {
        // GIVEN
        val height = 70.86
        val mass = 881.84

        // WHEN
        var bmi = BmiForLbIn(mass, height).countBmi()
        // THEN
        assertEquals(0.0, bmi, 0.01)
    }
}
