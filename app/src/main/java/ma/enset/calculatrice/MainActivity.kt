package ma.enset.calculatrice

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ma.enset.calculatrice.databinding.ActivityMainBinding
import org.mariuszgromada.math.mxparser.Expression


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding // Binding variable

    private fun equationNotEmpty(): Boolean {
        return binding.equation.text[0] != '0' && binding.equation.text.toString().isNotEmpty()
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.equation.text = "0"
        binding.result.text = "0"

        val operationStrings = arrayOf("+", "-", "*", "/")

        var results: Double

        binding.del.setOnClickListener {
            if (binding.equation.text.toString().isNotEmpty() && binding.equation.text[0]!='0') {
                if (binding.equation.text.length!=1) {
                    binding.equation.text = binding.equation.text.dropLast(1)
                }else{
                    binding.equation.text = "0"
                    binding.result.text = "0"
                }
            }
            return@setOnClickListener
        }
        binding.num0.setOnClickListener {
            if (binding.equation.text[0] != '0') {
                binding.equation.text = binding.equation.text.toString().plus('0')
                results = Expression(binding.equation.text.toString()).calculate()
                if (results.isNaN()) binding.result.text = "ERROR!"
                else binding.result.text = formatDouble(results)
            }
        }

        binding.num1.setOnClickListener {
            if (binding.equation.text == "0") {
                binding.equation.text = "1"
            } else {
                binding.equation.text = binding.equation.text.toString().plus("1")
            }
            results = Expression(binding.equation.text.toString()).calculate()
            if (results.isNaN()) binding.result.text = "ERROR!"
            else binding.result.text = formatDouble(results)
        }
        binding.num2.setOnClickListener {
            if (binding.equation.text == "0") {
                binding.equation.text = "2"
            } else {
                binding.equation.text = binding.equation.text.toString().plus("2")
            }
            results = Expression(binding.equation.text.toString()).calculate()
            if (results.isNaN()) binding.result.text = "ERROR!"
            else binding.result.text = formatDouble(results)
        }
        binding.num3.setOnClickListener {
            if (binding.equation.text == "0") {
                binding.equation.text = "3"
            } else {
                binding.equation.text = binding.equation.text.toString().plus("3")
            }
            results = Expression(binding.equation.text.toString()).calculate()
            if (results.isNaN()) binding.result.text = "ERROR!"
            else binding.result.text = formatDouble(results)

        }
        binding.num4.setOnClickListener {
            if (binding.equation.text == "0") {
                binding.equation.text = "4"
            } else {
                binding.equation.text = binding.equation.text.toString().plus("4")
            }
            results = Expression(binding.equation.text.toString()).calculate()
            if (results.isNaN()) binding.result.text = "ERROR!"
            else binding.result.text = formatDouble(results)

        }
        binding.num5.setOnClickListener {
            if (binding.equation.text == "0") {
                binding.equation.text = "5"
            } else {
                binding.equation.text = binding.equation.text.toString().plus("5")
            }
            results = Expression(binding.equation.text.toString()).calculate()
            if (results.isNaN()) binding.result.text = "ERROR!"
            else binding.result.text = formatDouble(results)

        }
        binding.num6.setOnClickListener {
            if (binding.equation.text == "0") {
                binding.equation.text = "6"
            } else {
                binding.equation.text = binding.equation.text.toString().plus("6")
            }
            results = Expression(binding.equation.text.toString()).calculate()
            if (results.isNaN()) binding.result.text = "ERROR!"
            else binding.result.text = formatDouble(results)

        }
        binding.num7?.setOnClickListener {
            if (binding.equation.text == "0") {
                binding.equation.text = "7"
            } else {
                binding.equation.text = binding.equation.text.toString().plus("7")
            }
            results = Expression(binding.equation.text.toString()).calculate()
            if (results.isNaN()) binding.result.text = "ERROR!"
            else binding.result.text = formatDouble(results)

        }
        binding.num8.setOnClickListener {
            if (binding.equation.text == "0") {
                binding.equation.text = "8"
            } else {
                binding.equation.text = binding.equation.text.toString().plus("8")
            }
            results = Expression(binding.equation.text.toString()).calculate()
            if (results.isNaN()) binding.result.text = "ERROR!"
            else binding.result.text = formatDouble(results)

        }
        binding.num9.setOnClickListener {
            if (binding.equation.text == "0") {
                binding.equation.text = "9"
            } else {
                binding.equation.text = binding.equation.text.toString().plus("9")
            }
            results = Expression(binding.equation.text.toString()).calculate()
            if (results.isNaN()) binding.result.text = "ERROR!"
            else binding.result.text = formatDouble(results)

        }

        binding.clear.setOnClickListener {
            binding.equation.text = "0"
            binding.result.text = "0"
        }
        binding.parLeft.setOnClickListener {
            if(equationNotEmpty()){
                binding.equation.text = binding.equation.text.toString().plus("(")
            }
            calculate()
        }
        binding.parRight.setOnClickListener {
            if(equationNotEmpty()){
                binding.equation.text = binding.equation.text.toString().plus(")")
            }
            calculate()
        }
        binding.plus.setOnClickListener {
            val lastIndex = binding.equation.text.length - 1
            if (operationStrings.contains(binding.equation.text[binding.equation.text!!.length - 1].toString())) {
                binding.equation.text =
                    binding.equation.text.replaceRange(lastIndex, lastIndex + 1, "+")
                return@setOnClickListener
            }
            binding.equation.text = binding.equation.text.toString().plus("+")
        }
        binding.multiply.setOnClickListener {
            val lastIndex = binding.equation.text.length.minus(1)
            if (operationStrings.contains(binding.equation.text[binding.equation.text!!.length - 1].toString())) {
                binding.equation.text =
                    binding.equation.text.replaceRange(lastIndex, lastIndex + 1, "*")
                return@setOnClickListener
            }
            binding.equation.text = binding.equation.text.toString().plus("×")
        }
        binding.minux.setOnClickListener {
            val lastIndex = binding.equation.text.length.minus(1)
            if (operationStrings.contains(binding.equation.text[binding.equation.text!!.length - 1].toString())) {
                binding.equation.text =
                    binding.equation.text.replaceRange(lastIndex, lastIndex + 1, "-")
                return@setOnClickListener
            }
            binding.equation.text = binding.equation.text.toString().plus("-")
        }
        binding.divide.setOnClickListener {
            val lastIndex = binding.equation.text.length.minus(1)
            if (operationStrings.contains(binding.equation.text[binding.equation.text!!.length - 1].toString())) {
                binding.equation.text =
                    binding.equation.text.replaceRange(lastIndex, lastIndex + 1, "-")
                return@setOnClickListener
            }
            binding.equation.text = binding.equation.text.toString().plus("÷")
        }
        binding.percent.setOnClickListener {
            binding.equation.text = binding.equation.text.toString().plus("%")
            calculate()
        }
        binding.point.setOnClickListener {
            binding.equation.text = binding.equation.text.toString().plus(".")
            calculate()
        }

        binding.ln?.setOnClickListener {
            if (equationNotEmpty()){
                binding.equation.text = binding.equation.text.toString().plus("ln(")
            }else{
                binding.equation.text = "ln("
            }
        }
        binding.rooot?.setOnClickListener {
            if (equationNotEmpty()){
                binding.equation.text = binding.equation.text.toString().plus("√(")
            }else{
                binding.equation.text = "√("
            }
        }
        binding.sin?.setOnClickListener {
            if (equationNotEmpty()){
                binding.equation.text = binding.equation.text.toString().plus("sin(")
            }else{
                binding.equation.text = "sin("
            }
        }
        binding.pow?.setOnClickListener {
            if (equationNotEmpty()){
                binding.equation.text = binding.equation.text.toString().plus("^(")
            }else{
                binding.equation.text = "^("
            }
        }
        binding.cos?.setOnClickListener {
            if (equationNotEmpty()){
                binding.equation.text = binding.equation.text.toString().plus("cos(")
            }else{
                binding.equation.text = "cos("
            }
        }
        binding.exp?.setOnClickListener {
            if (equationNotEmpty()){
                binding.equation.text = binding.equation.text.toString().plus("exp(")
            }else{
                binding.equation.text = "exp("
            }
        }
        binding.tan?.setOnClickListener {
            if (equationNotEmpty()){
                binding.equation.text = binding.equation.text.toString().plus("tan(")
            }else{
                binding.equation.text = "tan("
            }
        }
        binding.log?.setOnClickListener {
            if (equationNotEmpty()){
                binding.equation.text = binding.equation.text.toString().plus("lg(")
            }else{
                binding.equation.text = "lg("
            }
        }
        binding.abs?.setOnClickListener {
            if (equationNotEmpty()){
                binding.equation.text = binding.equation.text.toString().plus("abs(")
            }else{
                binding.equation.text = "abs("
            }
        }


    }

    @SuppressLint("SetTextI18n")
    private fun calculate() {
        val results = Expression(binding.equation.text.toString()).calculate()
        if (results.isNaN()) binding.result.text = "ERROR!"
        else binding.result.text = formatDouble(results)
    }

    private fun formatDouble(number: Double): String {
        return if (number == number.toLong().toDouble()) {
            String.format("%.0f", number)
        } else {
            number.toString()
        }
    }
}
