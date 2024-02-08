package com.paul.activitys.IMCapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.paul.activitys.R
import java.text.DecimalFormat


class IMCActivity : AppCompatActivity() {

    private var isMaleSelected: Boolean = true
    private var isFemaleSelecd: Boolean = false
    private var height: Int = 190
    private var age: Int = 18
    private var weight: Int = 60
    private val MIN_WEIGHT = 30
    private val MIN_AGE = 2
    private val MAX_AGE = 110
    private val MAX_WEIGHT = 160





    private lateinit var textViewHeight: TextView
    private lateinit var seekbarHeight: SeekBar
    private lateinit var textViewWeight: TextView
    private lateinit var textViewAge: TextView
    private lateinit var btnPlusAge: FloatingActionButton
    private lateinit var btnMinusAge: FloatingActionButton
    private lateinit var btnPlusWeight: FloatingActionButton
    private lateinit var btnMinusWeight: FloatingActionButton
    private lateinit var btnCalculateIMC: Button


    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)

        initComponents()
        initListeners()
        initUX()


    }



    private fun initUX() {
        setGenderColor()
        setAge()
        setWeight()
        setHeight()
    }

    private fun setHeight() {
        textViewHeight.setText(height.toString())
        seekbarHeight.setProgress(height)

    }

    private fun setWeight() {
        textViewWeight.text = weight.toString()
    }

    private fun setAge() {
        textViewAge.text = age.toString()
    }

    private fun initListeners() {
        viewMale.setOnClickListener { selectMale() }
        viewFemale.setOnClickListener { selectFemale() }
        btnPlusWeight.setOnClickListener { plusWeight() }
        btnMinusWeight.setOnClickListener { minusWeight() }
        btnPlusAge.setOnClickListener { plusAge() }
        btnMinusAge.setOnClickListener { minusAge() }
        btnCalculateIMC.setOnClickListener{ calculateIMC() }
        seekbarHeight.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                height = progress
                setHeight()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // TODO Auto-generated method stub
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
//                Toast.makeText(this,"Seek bar progress is :$progressChangedValue",Toast.LENGTH_SHORT).show()
            }
        })


    }

    private fun calculateIMC() {
        val imc = weight / (height.toDouble() / 100 * height.toDouble() / 100)
        val intent = Intent(this, Result_IMC_Activity::class.java)
        val df = DecimalFormat("#.##")
        val roundIMC = df.format(imc)

        intent.putExtra("IMC", roundIMC)
        intent.putExtra("GENDER", isMaleSelected)
        intent.putExtra("WEIGHT", weight.toString())
        intent.putExtra("HEIGHT", height.toString())

        startActivity(intent)
//        Toast.makeText(this,  imc.toString(), Toast.LENGTH_LONG).show()
    }

    private fun minusAge() {
        if(age <= MIN_AGE){
            Toast.makeText(this,  "Edad Minima", Toast.LENGTH_SHORT).show()
            return
        }
        age--
        setAge()
    }

    private fun plusAge() {
        if(age >= MAX_AGE){
            Toast.makeText(this,  "Edad Maxima", Toast.LENGTH_SHORT).show()
            return
        }
        age++
        setAge()
    }

    private fun minusWeight() {
        if(weight <= MIN_WEIGHT){
            Toast.makeText(this,  "Peso Minimo", Toast.LENGTH_SHORT).show()
            return
        }
        weight--
        setWeight()
    }

    private fun plusWeight() {
        if(weight >= MAX_WEIGHT){
            Toast.makeText(this,  "Peso Maximo", Toast.LENGTH_SHORT).show()
            return
        }
        weight++
        setWeight()
    }

    private fun selectMale() {
        isMaleSelected = true
        isFemaleSelecd = false
        setGenderColor()
    }

    private fun selectFemale() {
        isMaleSelected = false
        isFemaleSelecd = true
        setGenderColor()
    }

    private fun setGenderColor() {
        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelecd))
    }



    private fun initComponents() {
        viewMale = findViewById(R.id.cvMale)
        viewFemale = findViewById(R.id.cvFemale)

        textViewHeight = findViewById(R.id.tvHeight)
        seekbarHeight = findViewById(R.id.sb_height)
        textViewWeight = findViewById(R.id.tvWeight)
        textViewAge = findViewById(R.id.tvAge)
        btnPlusAge = findViewById(R.id.btnPlusAge)
        btnMinusAge = findViewById(R.id.btnMinusAge)
        btnPlusWeight = findViewById(R.id.btnPlusWeight)
        btnMinusWeight = findViewById(R.id.btnMinusWeight)
        btnCalculateIMC = findViewById(R.id.btnCalculateIMC)

    }

    private fun getBackgroundColor(isSelectComponent: Boolean): Int {
        val colorReference = if (isSelectComponent) {
            R.color.background_component_selected
        } else {
            R.color.background_component
        }

        return ContextCompat.getColor(this, colorReference)

    }
}