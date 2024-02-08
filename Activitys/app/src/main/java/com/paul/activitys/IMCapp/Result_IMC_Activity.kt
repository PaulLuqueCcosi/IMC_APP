package com.paul.activitys.IMCapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.paul.activitys.R

class Result_IMC_Activity : AppCompatActivity() {

    private lateinit var imc: String
    private var genderIsMale: Boolean = false
    private lateinit var height: String
    private lateinit var weight: String

    private lateinit var photo: ImageView
    private lateinit var tvResult: TextView
    private lateinit var tvIMC: TextView
    private lateinit var tvText: TextView
    private lateinit var tvInfo: TextView

    private lateinit var buttonRecalculate: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imc)

        recoverExtras()
        initComponents()
        initListeners()


    }

    private fun recoverExtras() {
        imc = intent.extras?.getString("IMC")!!
        genderIsMale = intent.extras?.getBoolean("GENDER")!!
        height = intent.extras?.getString("HEIGHT")!!
        weight = intent.extras?.getString("WEIGHT")!!
    }


    private fun checkIMC(imc: String, genderIsMale: Boolean): EstadoPeso {
        val imcDouble = imc.toDouble()


        val estado = if (genderIsMale) {
            when {
                imcDouble < ClasificacionPeso.POR_DEBAJO.rangoMaxHombre -> ClasificacionPeso.POR_DEBAJO
                imcDouble < ClasificacionPeso.SALUDABLE.rangoMaxHombre -> ClasificacionPeso.SALUDABLE
                imcDouble < ClasificacionPeso.SOBREPESO.rangoMaxHombre -> ClasificacionPeso.SOBREPESO
                imcDouble < ClasificacionPeso.OBESIDAD_I.rangoMaxHombre -> ClasificacionPeso.OBESIDAD_I
                imcDouble < ClasificacionPeso.OBESIDAD_II.rangoMaxHombre -> ClasificacionPeso.OBESIDAD_II
                else -> ClasificacionPeso.OBESIDAD_III
            }
        } else {
            when {
                imcDouble < ClasificacionPeso.POR_DEBAJO.rangoMaxMujer -> ClasificacionPeso.POR_DEBAJO
                imcDouble < ClasificacionPeso.SALUDABLE.rangoMaxMujer -> ClasificacionPeso.SALUDABLE
                imcDouble < ClasificacionPeso.SOBREPESO.rangoMaxMujer -> ClasificacionPeso.SOBREPESO
                imcDouble < ClasificacionPeso.OBESIDAD_I.rangoMaxMujer -> ClasificacionPeso.OBESIDAD_I
                imcDouble < ClasificacionPeso.OBESIDAD_II.rangoMaxMujer -> ClasificacionPeso.OBESIDAD_II
                else -> ClasificacionPeso.OBESIDAD_III
            }
        }


        return estado
    }

    private fun initComponents() {
        photo = findViewById(R.id.imageViewGender)
        if (genderIsMale) {
            photo.setImageResource(R.drawable.ic_male)
        } else {
            photo.setImageResource(R.drawable.ic_femlae)
        }


        tvResult = findViewById(R.id.tvResult)
        val estado: EstadoPeso = checkIMC(imc, genderIsMale)
        tvResult.text = estado.nombre
        tvResult.setTextColor(ContextCompat.getColor(this, estado.colorId))

        tvIMC = findViewById(R.id.tvIMC)
        tvIMC.text = imc

        tvText = findViewById(R.id.tvText)
        tvText.text = estado.descripcion

        tvInfo = findViewById(R.id.tvInfo)
        val info = "Weight : $weight kg., Height: $height cm."
        tvInfo.text = info
        buttonRecalculate = findViewById(R.id.btRecalculate)

    }


    private fun initListeners() {

        buttonRecalculate.setOnClickListener {
            recalculate()
        }
    }

    private fun recalculate() {
        finish()
    }


}

class EstadoPeso(
    val nombre: String,
    val descripcion: String,
    val rangoMaxHombre: Double,
    val rangoMaxMujer: Double,
    val colorId: Int
) {
    override fun toString(): String {
        return nombre
    }
}

class ClasificacionPeso {
    companion object {
        val POR_DEBAJO = EstadoPeso(
            "Por Debajo del Peso",
            "Por debajo del rango saludable de peso",
            18.4,
            17.9,
            R.color.por_debajo_color
        )
        val SALUDABLE = EstadoPeso(
            "Saludable",
            "Rango saludable de peso",
            24.9,
            24.9,
            R.color.saludable_color
        )
        val SOBREPESO = EstadoPeso(
            "Sobrepeso",
            "Por encima del rango saludable de peso",
            29.9,
            29.9,
            R.color.sobrepeso_color
        )
        val OBESIDAD_I = EstadoPeso(
            "Obesidad I",
            "Obesidad grado I",
            34.9,
            34.9,
            R.color.obesidad_i_color
        )
        val OBESIDAD_II = EstadoPeso(
            "Obesidad II",
            "Obesidad grado II",
            39.9,
            39.9,
            R.color.obesidad_ii_color
        )
        val OBESIDAD_III = EstadoPeso(
            "Obesidad III",
            "Obesidad grado III",
            Double.MAX_VALUE,
            Double.MAX_VALUE,
            R.color.obesidad_iii_color
        )
    }
}
