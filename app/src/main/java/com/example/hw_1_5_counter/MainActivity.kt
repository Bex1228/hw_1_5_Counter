package com.example.hw_1_5_counter

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.hw_1_5_counter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CounterView {

    private lateinit var binding: ActivityMainBinding

    private val presenter = Injector.getPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
    }

    private fun initClickers() = with(binding) {
        btnPlus.setOnClickListener {
            presenter.increment()
        }
        btnMinus.setOnClickListener {
            presenter.decrement()
        }
    }

    override fun showChangeCount(count: Int) {
        binding.tvCount.text = count.toString()
    }

    override fun showToast() {
        Toast.makeText(this, getString(R.string.toast),Toast.LENGTH_SHORT).show()
    }

    override fun changeTextColor() {
       binding.tvCount.setTextColor(Color.GREEN)
    }
}