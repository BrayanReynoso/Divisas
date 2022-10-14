package mx.edu.utez.practicadivisas
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import mx.edu.utez.practicadivisas.databinding.ActivityMainBinding
@Suppress("UNREACHABLE_CODE")
class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    var op1 = 0
    var op2 = 0
    lateinit var spinner: Spinner
    lateinit var spinner1: Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        spinner = binding.spinner
        spinner1 = binding.spinner1
        val totalCambio = binding.totalCambio.text
        val resultadoCambio = binding.resultadoCambio
        val button = binding.button
        var total:Double

        //Asignar los valores al Spinner
        ArrayAdapter.createFromResource(
            this,
            R.array.divisas,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
            spinner1.adapter = adapter
        }
        spinner.onItemSelectedListener = this
        spinner1.onItemSelectedListener = this

       button.setOnClickListener {
           // si el valor ingresado contiene un valor realiza la accion
           if (totalCambio.toString().isNotEmpty()){
                   val cambio1:Double = totalCambio.toString().toDouble()
                   when(op1){
                       //peso mexicano
                       0 -> {
                           when(op2){
                               0 -> {
                                   total = cambio1
                                   resultadoCambio.text = "El cambio es: $total pesos"
                               }
                               1 -> {
                                   total = cambio1 * 0.050
                                   resultadoCambio.text = "El cambio es: $total dolares"
                               }
                               2 ->{
                                   total = cambio1 * 0.057
                                   resultadoCambio.text = "El cambio es: $total euros"
                               }

                           }
                       }
                       //dolar
                       1 -> {
                           when(op2){
                               0 -> {
                                   total = cambio1 * 20
                                   resultadoCambio.text = "El cambio es: $total pesos"
                               }
                               1 -> {
                                   total = cambio1
                                   resultadoCambio.text = "El cambio es: $total dolares"
                               }
                               2 ->{
                                   total = cambio1 * 1.02
                                   resultadoCambio.text = "El cambio es: $total euros"
                               }
                           }
                       }
                       //euro
                       2 -> {
                           when(op2){
                               0 -> {
                                   total = cambio1 * 19.54
                                   resultadoCambio.text = "El cambio es: $total pesos"
                               }
                               1 -> {
                                   total = cambio1 * 0.98
                                   resultadoCambio.text = "El cambio es: $total dolares"
                               }
                               2 ->{
                                   total = cambio1
                                   resultadoCambio.text = "El cambio es: $total euros"
                               }

                           }
                       }

                   }
               }
        }
    }
    //cuando se selecciono algo
    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
       //obtener la posicion del las opciones del spinner
        if (p0 != null){
            if (p0.id  == spinner.id){
                //asignar valor
                op1 = position
            }else if (p0.id == spinner1.id){
                op2 = position
            }
        }
    }
    // cuando no se ha selccionado nada
    override fun onNothingSelected(p0: AdapterView<*>?) {
    }
}