package ro.pub.cs.systems.eim.practicaltest01

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import kotlin.toString

class PracticalTest01MainActivity : AppCompatActivity() {
    // Variabile pentru asociere cu elementele de interfata
    private lateinit var sir: EditText
    private lateinit var numar_puncte_cardinale : EditText

    // Coordonate si numar
    private var coordonate=""
    private var numar=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_main)

        // Cerinta B1
        // Folosim variabila sir pentru a face o asociere pentru elementul din interfata
        // si variabile

        sir=findViewById<EditText>(R.id.afisare_coordonate)
        numar_puncte_cardinale=findViewById<EditText>(R.id.numar_puncte_cardinale_selectate)

        // Daca se apasa butonul Nord, se adauga la sir Nord si se incrementeaza cu 1
        val apasaButonNord=findViewById<Button>(R.id.nord)
        apasaButonNord.setOnClickListener {
            coordonate+="Nord"
            coordonate+=", "
            numar++
            sir.setText(coordonate)
            numar_puncte_cardinale.setText(numar.toString())
        }

        // Daca se apasa butonul Nord, se adauga la sir Sud si se incrementeaza cu 1
        val apasaButonSud=findViewById<Button>(R.id.sud)
        apasaButonSud.setOnClickListener {
            coordonate+="Sud";
            coordonate+=", ";
            numar++
            sir.setText(coordonate)
            numar_puncte_cardinale.setText(numar.toString())
        }

        // Daca se apasa butonul Nord, se adauga la sir Vest si se incrementeaza cu 1
        val apasaButonVest=findViewById<Button>(R.id.vest)
        apasaButonVest.setOnClickListener {
            coordonate+="Vest";
            coordonate+=", ";
            numar++
            sir.setText(coordonate)
            numar_puncte_cardinale.setText(numar.toString())
        }

        // Daca se apasa butonul Est, se adauga la sir Nord si se incrementeaza cu 1
        val apasaButonEst=findViewById<Button>(R.id.est)
        apasaButonEst.setOnClickListener {
            coordonate+="Est";
            coordonate+=", ";
            numar++
            sir.setText(coordonate)
            numar_puncte_cardinale.setText(numar.toString())
        }

        // Cerinta B1

        // Cerinta C2
        // Se verifica ce rezultat am obtinut in urma apasarii butonului din activitatea secundara

        val activityResultsLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            // Dacă activitatea returnează OK
            if (result.resultCode == Activity.RESULT_OK) {
                Toast.makeText(this, "The activity returned with result OK", Toast.LENGTH_LONG).show()
            }
            // Dacă activitatea este anulată
            else if (result.resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(this, "The activity returned with result CANCELED", Toast.LENGTH_LONG).show()
            }

            // Vom reseta si elementele
            coordonate=""
            numar=0
            sir.setText("")
            numar_puncte_cardinale.setText("0")
        }

        // La click pe buton, pornește activitatea secundară și trimite valorile din input1 și input2
        val navigateToSecondaryActivityButton = findViewById<Button>(R.id.activitate_secundara)
        navigateToSecondaryActivityButton.setOnClickListener {
            val intent = Intent(this, PracticalTest01SecondaryActivity::class.java)
            intent.putExtra("coordonate", sir.text.toString())
            activityResultsLauncher.launch(intent)
        }

        // Cerinta C2
    }

    // Cerinta B2

    // Vom salva valorile in elementele de interfata cu celelalte variabile din clasa
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("numar_puncte_cardinale_selectate",numar.toString())
        outState.putString("coordonate",coordonate)
    }

    // Vom pune inapoi valori in campurile din interfata daca acestea nu sunt 0
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState.containsKey("numar_puncte_cardinale_selectate") && savedInstanceState.containsKey("coordonate")) {
            numar_puncte_cardinale.setText(savedInstanceState.getString("numar_puncte_cardinale_selectate"))
            sir.setText(savedInstanceState.getString("coordonate"))
            numar = numar_puncte_cardinale.text.toString().toInt()
            coordonate = sir.text.toString()
        }
    }

    // Cerinta B2
    }