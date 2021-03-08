package com.example.superheroes

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.renderscript.ScriptGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.graphics.drawable.toBitmap
import com.example.superheroes.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.activity_ver_datos.view.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding

    @SuppressLint("StringFormatInvalid")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.btnSend.setOnClickListener {
            val intent = Intent(this,verDatosActivity::class.java)
            val heroe:String = viewBinding.etHeroeName.text.toString()
            val power:Float = viewBinding.rbPower.rating
            val bitmap:Bitmap = viewBinding.ivPhoto.drawable.toBitmap()

            intent.putExtra(verDatosActivity.HEROE_KEY,heroe)
            intent.putExtra(verDatosActivity.POWER_KEY,power)
            intent.putExtra(verDatosActivity.IMAGEN_KEY,bitmap)
            startActivity(intent)
        }

        viewBinding.ivPhoto.setOnClickListener {
            val intentImplicito =Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intentImplicito,7)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==7 && resultCode==Activity.RESULT_OK){
            val imagen:Bundle? = data?.extras
            val heroImagen:Bitmap? = imagen?.getParcelable<Bitmap>("data")
            viewBinding.ivPhoto.setImageBitmap(heroImagen)
        }

    }
}


















