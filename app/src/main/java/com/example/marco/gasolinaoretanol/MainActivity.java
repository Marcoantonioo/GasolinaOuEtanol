package com.example.marco.gasolinaoretanol;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private EditText precoGasolina;
    private EditText precoEtanol;
    private Button btnCalcular;
    private TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        precoGasolina = (EditText) findViewById(R.id.precoGasolina);
        precoEtanol =  (EditText) findViewById(R.id.precoEtanol);
        btnCalcular =  (Button) findViewById(R.id.btnCalcular);
        resultado = (TextView) findViewById(R.id.tvResultado);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String textPrecoGasolina = precoGasolina.getText().toString();
                    String textPrecoEtanol = precoEtanol.getText().toString();
                    double valorGasolina = Double.parseDouble(textPrecoGasolina);
                    double valorEtanol = Double.parseDouble(textPrecoEtanol);

                    double resp = valorGasolina / valorEtanol;

                    if (resp <= 0.7 ) {
                        resultado.setText(R.string.melhor_etanol);
                    } else {
                        resultado.setText(R.string.melhor_gasolina);
                    }
                }catch (Exception e){
                    Context context = getApplicationContext();
                    String texto = "Campo vazio, Preecha-o! ";
                    int duracao  = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, texto, duracao);
                    toast.show();
                }
            }
        });

    }
}
