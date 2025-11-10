import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import ro.pub.cs.systems.eim.practicaltest01.R

class PracticalTest01SecondaryActivity : AppCompatActivity() {

    private lateinit var coordonate: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test_01_secondary)

        coordonate = findViewById<TextView>(R.id.coordonatele)
        val input1 = intent.getStringExtra("coordonate")

        // Varaiabila retine asocierea cu butonul ok
        // Se termina activitatea si mesajul este ok
        val okButton = findViewById<Button>(R.id.butonRegister)
        okButton.setOnClickListener {
            setResult(RESULT_OK)
            finish()
        }

        // Varaiabila retine asocierea cu butonul cancel
        // Se termina activitatea si mesajul este canceled
        val cancelButton = findViewById<Button>(R.id.butonCancel)
        cancelButton.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }
    }
}