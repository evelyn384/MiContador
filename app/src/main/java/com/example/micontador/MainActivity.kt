package com.example.micontador

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity<onClickListener> : AppCompatActivity(), onClickListener, Parcelable {

    constructor(parcel: Parcel) : this() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var contador = 0
        etiquetaMostrar.text = "$contador"

        btnIncrementar.setOnClickListener {
            contador ++
            etiquetaMostrar.text = "$contador"
        }
        btnDecremen.setOnClickListener{
            contador --
            etiquetaMostrar.text = "$contador"

        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity<Any?>> {
        override fun createFromParcel(parcel: Parcel): MainActivity<Any?> {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity<Any?>?> {
            return arrayOfNulls(size)
        }
    }

}

