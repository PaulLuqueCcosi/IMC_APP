package com.paul.activitys.IMCapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.paul.activitys.R

class IMCActivity : AppCompatActivity() {

    private var isMaleSelected: Boolean = true
    private var isFemaleSelecd: Boolean = false
    private lateinit var viewMale :CardView
    private lateinit var viewFemale : CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)

        initComponents()
        initListeners()
        initUX()


    }

    private fun initUX() {
        setGenderColor()
    }

    private fun initListeners() {
        viewMale.setOnClickListener{ selectMale()}
        viewFemale.setOnClickListener { selectFemale()  }
    }

    private fun selectMale() {
        isMaleSelected = true;
        isFemaleSelecd = false;
        setGenderColor()
    }

    private fun selectFemale() {
        isMaleSelected = false;
        isFemaleSelecd = true;
        setGenderColor()
    }

    private fun setGenderColor() {
        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelecd))
    }

    private fun changeGender() {

    }


    private fun initComponents() {
        viewMale = findViewById(R.id.cvMale)
        viewFemale = findViewById(R.id.cvFemale)
    }

    private fun getBackgroundColor(isSelectComponent: Boolean): Int {
        val colorReference = if(isSelectComponent){
            R.color.background_component_selected
        } else{
            R.color.background_component
        }

        return ContextCompat.getColor(this, colorReference)

    }
}