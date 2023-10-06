package pt.ipt.dam2023.acercademim

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // <=> à função MAIN de outras linguagens de programação
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ponteiro para o nosso botão
        // e responder ao evento de 'click'
        findViewById<Button>(R.id.button).setOnClickListener {
            escreveDiminutivo(it)
        }

    }

    /**
     * transfere o diminutivo do utilizador da TextBox para a Label,
     * e esconde os objetos não necessários
     */
    private fun escreveDiminutivo(bt:View) {

        // criar ponteiros para os objetos da View (interface gráfico)
        val txtLabel = findViewById<TextView>(R.id.diminutivo_utilizadorTextView)
        val txtCaixaTexto = findViewById<EditText>(R.id.diminutivo_utilizadorEditText)

        // atribuir o texto do diminutivo que o utilizador escreveu
        // à label que o vai mostrar no ecrã
        txtLabel.text=txtCaixaTexto.text

        // esconder os recursos que não são necessários
        txtCaixaTexto.visibility= View.GONE
        bt.visibility=View.GONE

        // hide the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(bt.windowToken, 0)

        // apresentar a 'label' no ecrã
        txtLabel.visibility=View.VISIBLE

    }


}