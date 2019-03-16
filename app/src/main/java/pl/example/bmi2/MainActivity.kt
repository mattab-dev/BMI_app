package pl.example.bmi2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import pl.example.bmi2.logic.BmiForKgCm
import pl.example.bmi2.logic.BmiForLbIn

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var isSwitchOn: Boolean = false

        resultSectionHide()
        unitSwitch.text = "Kg/Cm"
        unitSwitch.setOnCheckedChangeListener { unitSwitch, isChecked ->
            if (isChecked) {
                unitSwitch.text = "Lb/In"
                heightInput.text.clear()
                heightInput.hint = "78.6"
                weightInput.text.clear()
                weightInput.hint = "200.5"
                resultSectionHide()
                isSwitchOn = true
            } else {
                unitSwitch.text = "Kg/Cm"
                heightInput.text.clear()
                heightInput.hint = "170"
                weightInput.text.clear()
                weightInput.hint = "70"
                resultSectionHide()
                isSwitchOn = false
            }
        }
        calculateButton.setOnClickListener { v ->
            resultSectionHide()
            countForInstance(isSwitchOn)
        }
    }

    fun resultSectionHide() {
        bmiResult.text = ""
        bmiResultLabel.alpha = 0.0f
        bmiResult.alpha = 0.0f
    }

    fun countForInstance(isEnglish: Boolean) {
        try {
            if (isEnglish) {
                val height: Double = heightInput.text.toString().toDouble()
                val weight: Double = weightInput.text.toString().toDouble()
                val result: String = String.format("%.1f", BmiForLbIn(weight, height).countBmi())
                if (result == 0.0.toString()) {
                    Toast.makeText(this@MainActivity, "Data outside of reasonable range", Toast.LENGTH_SHORT).show()
                } else {
                    bmiResult.text = result
                    bmiResultLabel.alpha = 1.0f
                    bmiResult.alpha = 1.0f
                }
            } else {
                val height: Int = heightInput.text.toString().toInt()
                val weight: Int = weightInput.text.toString().toInt()
                val result: String = String.format("%.1f", BmiForKgCm(weight, height).countBmi())
                if (result == 0.0.toString()) {
                    Toast.makeText(this@MainActivity, "Data outside of reasonable range", Toast.LENGTH_SHORT).show()
                } else {
                    bmiResult.text = result
                    bmiResultLabel.alpha = 1.0f
                    bmiResult.alpha = 1.0f
                }
            }
        } catch (e: Exception) {
            Toast.makeText(this@MainActivity, "Please correct data", Toast.LENGTH_SHORT).show()
        }
    }
}

