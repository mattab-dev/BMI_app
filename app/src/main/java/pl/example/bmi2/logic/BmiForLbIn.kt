package pl.example.bmi2.logic

class BmiForLbIn(var mass: Double, var height: Double) : Bmi {


    override fun countBmi(): Double {
        if ((mass > 837 || mass < 66) || (height > 94 || height < 40)) {
            return 0.0
        }
        return (mass / height / height) * 703

    }
}