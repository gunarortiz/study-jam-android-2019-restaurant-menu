package com.gunar.ticos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class FacturaActivity extends AppCompatActivity {

    TextView lista;
    EditText total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factura);

        lista = (TextView) findViewById(R.id.textView3);
        lista.setText(getIntent().getExtras().getString("lista"));

        total = (EditText) findViewById(R.id.editText);
        total.setText(getIntent().getExtras().getString("total"));

    }

    public void regresar(View view){
        finish();
    }
}
