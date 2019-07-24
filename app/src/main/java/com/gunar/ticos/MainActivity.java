package com.gunar.ticos;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

//    int imagenes[] = {R.drawable.aries, R.drawable.tauro, R.drawable.geminis, R.drawable.cancer, R.drawable.leo, R.drawable.virgo, R.drawable.libra, R.drawable.escorpion, R.drawable.sagitario, R.drawable.capricornio, R.drawable.acuario, R.drawable.piscis};
//    String nombres[] = {"aries", "tauro", "geminis", "cancer", "leo", "virgo", "libra", "escorpion", "sagitario", "capricornio", "acuario", "piscis"};
    int indice = 0;
    private ImageView imagen;
    private TextView nombre;
    private EditText pedido, apagar;
    private int aux;
    int contador = 0;
    double pagar = 0;

//    SensorManager sensorManager;
//    Sensor sensor;
//    SensorEventListener sensorEventListener;

    private List<Producto> listaComida = new ArrayList<Producto>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aux = 0;
        imagen = (ImageView) findViewById(R.id.imageView);
        nombre = (TextView) findViewById(R.id.texto);

        pedido = (EditText) findViewById(R.id.pedido);
        apagar = (EditText) findViewById(R.id.apagar);

        pagar = 0;
        apagar.setText(0 + "");

        listaComida.add(new Producto("Hamburguesa Normal", R.drawable.hnormal, 0, 12));
        listaComida.add(new Producto("Hamburguesa 1/2 Kilo", R.drawable.hmediokilo, 0, 18));
        listaComida.add(new Producto("Hamburguesa c/Huevo", R.drawable.hconhuevo, 0, 13.5));
        listaComida.add(new Producto("Hamburguesa c/Fideitos", R.drawable.hconfideitos, 0, 15));
        listaComida.add(new Producto("Hamburguesa Doble", R.drawable.hdoble, 0, 18));
        listaComida.add(new Producto("Hamburguesa Gemelas", R.drawable.hgemelas, 0, 21));
        listaComida.add(new Producto("Hamburguesa MariaJuana", R.drawable.hmariajuana, 0, 25));
        listaComida.add(new Producto("Hamburguesa c/Vegetales", R.drawable.hvegetal, 0, 15));
        listaComida.add(new Producto("Hamburguesa Pollo c/papas", R.drawable.hpollo, 0, 12));



        imagen.setImageResource(listaComida.get(indice).getImagen());
        nombre.setText(listaComida.get(indice).getNombre() + " " + listaComida.get(indice).getPrecio() + "Bs.");
        pedido.setText(listaComida.get(indice).getPedido() + "");



//        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
//        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
//
//        if (sensor == null) {
//            Toast.makeText(getApplicationContext(), "No cuenta con el sensor", Toast.LENGTH_LONG).show();
//            //finish();
//        }
//
//        sensorEventListener = new SensorEventListener() {
//            @Override
//            public void onSensorChanged(SensorEvent sensorEvent) {
//                float x = sensorEvent.values[0];
//                System.out.println("Valor giro " + x);
//                //Izquierda
//
//                if (x < 1 && x > -1) contador = 1;
//                if (x > 5 && contador==1) {
//                    indice--;
//                    if (indice<0) indice=10;
//                    nombre.setText(nombres[indice]);
//                    imagen.setImageResource(imagenes[indice]);
//                    contador = 0;
//                } else if (x < -5 && contador==1) {
//                    indice++;
//                    if (indice>10) indice=0;
//                    nombre.setText(nombres[indice]);
//                    imagen.setImageResource(imagenes[indice]);
//                    contador = 0;
//                }
//            }
//
//            @Override
//            public void onAccuracyChanged(Sensor sensor, int i) {
//
//            }
//        };
    }

    public void aumentar(View view) {
        listaComida.get(indice).setPedido(listaComida.get(indice).getPedido()+1);
        pedido.setText(listaComida.get(indice).getPedido() + "");

        pagar = pagar + (listaComida.get(indice).getPrecio());
        apagar.setText(pagar+"");
    }

    public void reducir(View view) {
        if(listaComida.get(indice).getPedido()>0){
            listaComida.get(indice).setPedido(listaComida.get(indice).getPedido()-1);
            pedido.setText(listaComida.get(indice).getPedido() + "");
            pagar = pagar - (listaComida.get(indice).getPrecio());
            apagar.setText(pagar+"");
        }

    }

    public  void botonC(View view) {
        for(int i = 0; i<9; i++){
            listaComida.get(i).setPedido(0);
        }
        pagar = 0;
        apagar.setText("0");
        pedido.setText("0");
    }

    public  void botonF(View view) {
        String r = "";
        for(int i = 0; i<9; i++){
            double a = listaComida.get(i).getPedido() * listaComida.get(i).getPrecio();
            if(listaComida.get(i).getPedido()>0){
                r+=listaComida.get(i).getNombre() + "\t\t\t\t\t\t" + listaComida.get(i).getPedido() + "\t\t\t\t\t\t" + a + " \n";
            }

        }
        //r+=" "+pagar;


        Intent intent = new Intent(this, FacturaActivity.class);
        intent.putExtra("lista", r);
        intent.putExtra("total", pagar + "");
        startActivity(intent);

//        Toast.makeText(getApplicationContext(),r, Toast.LENGTH_LONG).show();
    }




    public void siguiente(View view) {
        indice++;
        if (indice > 8) indice = 0;
        imagen.setImageResource(listaComida.get(indice).getImagen());
        nombre.setText(listaComida.get(indice).getNombre() + " " + listaComida.get(indice).getPrecio() + "Bs.");
        pedido.setText(listaComida.get(indice).getPedido() + "");
    }

    public void anterior(View view) {
        indice--;
        if (indice < 0) indice = 8;
        imagen.setImageResource(listaComida.get(indice).getImagen());
        nombre.setText(listaComida.get(indice).getNombre() + " " + listaComida.get(indice).getPrecio() + "Bs.");
        pedido.setText(listaComida.get(indice).getPedido() + "");
    }

    public void ocultar(View view) {

    }

}
