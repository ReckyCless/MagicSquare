package com.example.magicsquare

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.magicsquare.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    fun squareCheck(view: View)
    {
        // Setting Default values
        binding.txtViewResult.text = "";
        binding.txtViewResult.setTextColor(Color.BLACK);
        var flag = true;
        // Start of function
        // Check if all fields is filled
        if (binding.txtEdit1.text.isBlank() ||
            binding.txtEdit2.text.isEmpty() ||
            binding.txtEdit3.text.isEmpty() ||
            binding.txtEdit4.text.isEmpty() ||
            binding.txtEdit5.text.isEmpty() ||
            binding.txtEdit6.text.isEmpty() ||
            binding.txtEdit7.text.isEmpty() ||
            binding.txtEdit8.text.isEmpty() ||
            binding.txtEdit9.text.isEmpty()
        ){
            binding.txtViewResult.text = "НЕ ЗАПОЛНЕННОЕ ПОЛЕ";
            binding.txtViewResult.setTextColor(Color.RED);
        }
        else {
            // Get numbers from fields in the massive
            val numbers: Array<Int> = arrayOf(
                binding.txtEdit1.text.toString().toInt(),
                binding.txtEdit2.text.toString().toInt(),
                binding.txtEdit3.text.toString().toInt(),
                binding.txtEdit4.text.toString().toInt(),
                binding.txtEdit5.text.toString().toInt(),
                binding.txtEdit6.text.toString().toInt(),
                binding.txtEdit7.text.toString().toInt(),
                binding.txtEdit8.text.toString().toInt(),
                binding.txtEdit9.text.toString().toInt()
            )
            // Check that all numbers is Unique
            if (numbers.size != numbers.distinct().count()) {
                binding.txtViewResult.text = "СОВПАДАЮЩИЕ ЧИСЛА";
                binding.txtViewResult.setTextColor(Color.GREEN);
                flag == false;
            }
            // Get Sums for magic square in the massive
            val sumsOfNumbers: Array<Int> = arrayOf(
                numbers[0] + numbers[1] + numbers[2], // Horizontal 1
                numbers[3] + numbers[4] + numbers[5], // Horizontal 2
                numbers[6] + numbers[7] + numbers[8], // Horizontal 3
                numbers[0] + numbers[3] + numbers[6], // Vertical 1
                numbers[1] + numbers[4] + numbers[7], // Vertical 2
                numbers[2] + numbers[5] + numbers[8], // Vertical 3
                numbers[0] + numbers[4] + numbers[8], // Diagonal 1
                numbers[2] + numbers[4] + numbers[6]  // Diagonal 2
            )
            for (number in numbers) {
                if (number == 0) {
                    binding.txtViewResult.setTextColor(Color.BLUE);
                    binding.txtViewResult.text = "НУЛЕВОЕ ЗНАЧЕНИЕ";
                    break;
                }
            }
            for (number1 in sumsOfNumbers) {
                for (number2 in sumsOfNumbers) {
                    if (number1 != number2) {
                        flag = false;
                    }
                }
            }
            if (flag && binding.txtViewResult.text == "") {
                binding.txtViewResult.text = "МАГИЯ";
            } else if (!flag && binding.txtViewResult.text == "") { // !flag
                binding.txtViewResult.text = "НЕ МАГИЯ";
            }
        }
    }
}