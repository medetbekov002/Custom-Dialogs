package com.example.customdialogs

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import com.example.customdialogs.databinding.ActivityMainBinding
import com.example.customdialogs.databinding.CustomDialogLayoutBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogOut.setOnClickListener {
            val message: String? = "Are you sure you want to log out"
            showCustomDialogBox(message)
        }
    }

    private fun showCustomDialogBox(message: String?) {
        val dialog = Dialog(this)
        val dialogBinding = CustomDialogLayoutBinding.inflate(layoutInflater)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(dialogBinding.root)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialogBinding.tvMessage.text = message

        dialogBinding.btnYes.setOnClickListener {
            Toast.makeText(this, "click on Yes", Toast.LENGTH_LONG).show()
        }

        dialogBinding.btnNo.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }
}
