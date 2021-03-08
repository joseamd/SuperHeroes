package com.example.superheroes

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.superheroes.databinding.ActivityMainBinding
import com.example.superheroes.databinding.ActivityVerDatosBinding

class verDatosActivity : AppCompatActivity() {

    private lateinit var viewBinding:ActivityVerDatosBinding
    companion object {
        const val HEROE_KEY = "heroe_key"
        const val POWER_KEY = "power_key"
        const val IMAGEN_KEY = "imagen_key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityVerDatosBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val intent:Bundle = intent.extras!! //ESTE OBJETO NO VA A SER NULO
        viewBinding.tvNameEnviado.text = intent.getString(HEROE_KEY)
        viewBinding.ratingBar.rating = intent.getFloat(POWER_KEY)
        viewBinding.photoEnviada.setImageBitmap(intent.getParcelable<Bitmap>(IMAGEN_KEY))

    }
}






