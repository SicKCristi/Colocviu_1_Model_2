package ro.pub.cs.systems.eim.practicaltest01

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class PracticalTest01MainActivity : AppCompatActivity() {
    private lateinit var sir: EditText
    private lateinit var numar_puncte_cardinale : EditText

    private var coordonate = ""
    private var numar=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_main)

        sir=findViewById<EditText>(R.id.afisare_coordonate)
        numar_puncte_cardinale=findViewById<EditText>(R.id.numar_puncte_cardinale_selectate)

        val apasaButonNord=findViewById<Button>(R.id.nord)
        apasaButonNord.setOnClickListener {
            coordonate+="Nord"
            coordonate+=", "
            numar++
            sir.setText(coordonate)
            numar_puncte_cardinale.setText(numar.toString())
        }

        val apasaButonSud=findViewById<Button>(R.id.sud)
        apasaButonSud.setOnClickListener {
            coordonate+="Sud";
            coordonate+=", ";
            numar++
            sir.setText(coordonate)
            numar_puncte_cardinale.setText(numar.toString())
        }

        val apasaButonVest=findViewById<Button>(R.id.vest)
        apasaButonVest.setOnClickListener {
            coordonate+="Vest";
            coordonate+=", ";
            numar++
            sir.setText(coordonate)
            numar_puncte_cardinale.setText(numar.toString())
        }

        val apasaButonEst=findViewById<Button>(R.id.est)
        apasaButonEst.setOnClickListener {
            coordonate+="Est";
            coordonate+=", ";
            numar++
            sir.setText(coordonate)
            numar_puncte_cardinale.setText(numar.toString())
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("numar_puncte_cardinale_selectate",numar.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState.containsKey("edittext1")){
            numar_puncte_cardinale.setText(savedInstanceState.getString("numar_puncte_carinale"))
            numar=Integer.valueOf(numar_puncte_cardinale.text.toString())
        }
    }
}