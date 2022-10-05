package com.unab.laboratorio2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var nameP: EditText
    private lateinit var ageP: EditText
    private lateinit var departamentP: EditText
    private  lateinit var listP: ListView
    private  lateinit var resultP:TextView

    var listName = arrayListOf<String>()
    var listAge = arrayListOf<String>()
    var listDepartament = arrayListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameP = findViewById(R.id.txtName)
        ageP = findViewById(R.id.txtAge)
        departamentP = findViewById(R.id.txtDepartament)
        listP = findViewById(R.id.lvNames)
        resultP = findViewById(R.id.lblR)
    }

    fun ShowList(V: View){

        listName.add(nameP.text.toString())
        listAge.add(ageP.text.toString())
        listDepartament.add(departamentP.text.toString())

        var adapterP: ArrayAdapter<String> = ArrayAdapter<String>(this, R.layout.listview_person, listName)
        listP?.adapter = adapterP

        listP?.onItemClickListener = object: AdapterView.OnItemClickListener{

            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                resultP.setText("Persona:[ { Nombre: ${listName.get(p2)}, Edad: ${listAge.get(p2)}, Departamento: ${listDepartament.get(p2)} } ]")
            }
        }

        nameP.setText("")
        ageP.setText("")
        departamentP.setText("")
    }
}