package pl.example.bmi2.logic

class BmiForKgCm(var mass: Int, var height: Int) : Bmi {


    override fun countBmi(): Double {
        if ((height > 240 || height < 110) || (mass > 380 || mass < 30)) {
            return 0.0
        }
        return mass * 10000.0 / (height * height)
    }
}

