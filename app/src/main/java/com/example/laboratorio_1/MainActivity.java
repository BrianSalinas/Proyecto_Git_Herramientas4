package com.example.laboratorio_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import org.mariuszgromada.math.mxparser.*;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    private EditText et;
    private Switch sw1;
    Boolean isDarkModeOn=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) { //se crea el metodo onCreate, que seria lo primero que se ejecuta al abrir la aplicacion
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // se instancia el elemento activity_main que es donde se encuentra el diseño de nuestra aplicacion
        tv = (TextView)findViewById(R.id.result); // se declara el elemento textView que es lo que mostrará los resultados de lo ingresado por pantalla
        et = (EditText)findViewById(R.id.frase); // se declara el elemento editText con el que se controlará el ingreso de frases para contar las vocales
        sw1=(Switch) findViewById(R.id.switchTema);// se declara el elemento Switch con el que se controlará el cambio de Tema claro al Oscuro
isDarkModeOn=getDarkModeStatus();

        sw1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isDarkModeOn) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                isDarkModeOn=false;
                }else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    isDarkModeOn=true;
                }
            }
           });
//Metodo que ejecuta el modo claro y el modo oscuro


    }
    private boolean getDarkModeStatus(){
        int nightModeFlags=
                MainActivity.this.getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        switch (nightModeFlags){
            case Configuration.UI_MODE_NIGHT_YES:
                return true;
            case Configuration.UI_MODE_NIGHT_NO:
                return false;
            case Configuration.UI_MODE_NIGHT_UNDEFINED:
                return false;
        }
        return false;
    }

    //este metodo se ejecutará cada vez que se presione una tecla numerica dentro de la calculadora, luego de pasar por su metodo padre que traeria el numero que fupe presionado
    private void updateScreen(String text){
        String oldStr = tv.getText().toString(); //se copia el texto que se encuentra en pantalla en una nueva variable
        tv.setText(oldStr + text); // se inserta dentro de la pantalla el texto que habia antiguamente y se contacatena el nuevo valor que seria el numero presionado
    }

    //metodo que ejecuta el boton 0 al ser presionado
    public void botonCero(View view){
        updateScreen("0");
    }
    //metodo que ejecuta el boton 1 al ser presionado
    public void botonUno(View view){
        updateScreen("1");
    }
    //metodo que ejecuta el boton 2 al ser presionado
    public void botonDos(View view){
        updateScreen("2");
    }
    //metodo que ejecuta el boton 3 al ser presionado
    public void botonTres(View view){
        updateScreen("3");
    }
    //metodo que ejecuta el boton 4 al ser presionado
    public void botonCuatro(View view){
        updateScreen("4");
    }
    //metodo que ejecuta el boton 5 al ser presionado
    public void botonCinco(View view){
        updateScreen("5");
    }
    //metodo que ejecuta el boton 6 al ser presionado
    public void botonSeis(View view){
        updateScreen("6");
    }
    //metodo que ejecuta el boton 7 al ser presionado
    public void botonSiete(View view){
        updateScreen("7");
    }
    //metodo que ejecuta el boton 8 al ser presionado
    public void botonOcho(View view){
        updateScreen("8");
    }
    //metodo que ejecuta el boton 9 al ser presionado
    public void botonNueve(View view){
        updateScreen("9");
    }
    //metodo que ejecuta el boton de pocentaje al ser presionado
    public void botonPorcentajeF(View view){
        updateScreen("%");
    }
    //metodo que ejecuta el boton de division al ser presionado
    public void botonDivisionF(View view){
        updateScreen("÷");
    }
    //metodo que ejecuta el boton de multiplicacion al ser presionado
    public void botonMultiplicacionF(View view){
        updateScreen("×");
    }
    //metodo que ejecuta el boton de suma al ser presionado
    public void botonSumaF(View view){
        updateScreen("+");
    }
    //metodo que ejecuta el boton de resta al ser presionado
    public void botonRestaF(View view){
        updateScreen("-");
    }
    //metodo que ejecuta el boton con el punto decimal al ser presionado
    public void botonPuntoF(View view){
        updateScreen(".");
    }
    //metodo que ejecuta el boton de limpiar toda la pantalla al ser presionado
    public void borrarTodo(View view){
        tv.setText(""); // se agrega una variable vacia a lo que se ets mostrando actualmente por pantalla
    }
    //metodo que ejecuta el borrar caracter por caracacter de la cadena mostrada en pantalla
    public void borrarLinea(View view){
        String texto = tv.getText().toString(); // se copia el texto que aparece por pantalla
        int textLen = tv.getText().length(); // se optiene la cantidad de caracteres que tiene lo que se muestra por pantalla

        /*se valida de que el tamaño de la cadena mostrada sea mayor a 0 esto es debido a que
        si se intenta eliminar una cadena que está ya vacia por el metodo substring se cierra el programa*/
        if(textLen != 0) {
            String newTexto = texto.substring(0,textLen-1); //se obtiene el texto sin el ultimo valor ingresado ya que se corta la cadena hasta tamaño-1
            tv.setText(newTexto); //se muestra por pantalla el resultado
        }
    }
    //metodo que ejecuta el boton de igual
    public void botonResultado(View view){
        if(TextUtils.isEmpty(et.getText().toString())){ //se verifica que el campo edit text se encuentra vacio, en este caso entra y se trata de una equacion matematica
            String str = tv.getText().toString();
            //se reemplaza los simbolos que se utilizaron que el codigo no reconoce por unos que si reconoce
            str = str.replaceAll("÷","/");
            str = str.replaceAll("×","*");

            Expression exp = new Expression(str); //se convierte la cadena de texto en una expresion, con un metodo de una libreria externa (mxparser)
            String result = String.valueOf(exp.calculate()); // con la misma libreria se calcula la expresion
            tv.setText(result);
        }else{
            //en el caso de que solo se quiera contar las vocales de una cadena se ingresa en esta opcion
            Vocales frase = new Vocales(et.getText().toString()); //se instancia la clase Vocales en la variable frase que tendrá un tipo Vocales. Se ingresa los datos que necesita el constructor
            tv.setText(frase.contarFrases()); //se ingresa por pantalla la frase que returna el metodo contarFrases dentro de la case Vocales
            et.setText(""); //se muestra por pantalla
        }

    }

}