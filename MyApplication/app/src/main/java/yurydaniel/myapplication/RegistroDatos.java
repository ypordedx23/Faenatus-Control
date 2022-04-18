package yurydaniel.myapplication;




import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistroDatos extends AppCompatActivity implements View.OnClickListener {
    ImageView empezarReg;

    TextView hora,fecha;
    Spinner halconeros, controles;
    String[] halcon={"Johnny Sanchez","Luis Gualotuña","Patricio Castro","Javier Monar","Ruth Muñiz","Paúl Tufiño"};
    String[] control={"Zona Aire","Pond","Area Resgtringida"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_datos);
        halconeros = (Spinner)findViewById(R.id.ListaDeAlconeros);
        controles = (Spinner)findViewById(R.id.ListaControl);
        List listaHalconeros = new ArrayList();
        List listaContro = new ArrayList();
        listaHalconeros = Arrays.asList(halcon); //Pasar un array a lista
        listaContro = Arrays.asList(control);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,listaHalconeros);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        halconeros.setAdapter(adapter);
        ArrayAdapter adapter2 = new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,listaContro);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        controles.setAdapter(adapter2);
        halconeros.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(RegistroDatos.this,"Halconero: "+String.valueOf(halconeros.getSelectedItem()),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        controles.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(RegistroDatos.this,"Tipo de Control: "+String.valueOf(controles.getSelectedItem()),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Date date = new Date();
        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
        hora = (TextView)findViewById(R.id.TextHora);
        System.out.println("Hora: "+hourFormat.format(date));
        hora.setText(hourFormat.format(date));
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        fecha =(TextView)findViewById(R.id.TextFecha);
        fecha.setText(dateFormat.format(date));
        empezarReg = (ImageView) findViewById(R.id.done);
        empezarReg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.done:
                if(controles.getSelectedItem()=="Pond"){
                    Intent intent = new Intent(this,POND.class);
                    String horas=(String) hora.getText();
                    String fechas=(String)fecha.getText();
                    String Halconeros=(String)halconeros.getSelectedItem();
                    String AcRealizar = (String)controles.getSelectedItem();
                    intent.putExtra("Place","POND");
                    intent.putExtra("Hora",horas);
                    intent.putExtra("Fecha",fechas);
                    intent.putExtra("Halconero",Halconeros);
                    intent.putExtra("Accion",AcRealizar);
                    startActivity(intent);
                    finish();
                }else{
                    if(controles.getSelectedItem()=="Zona Aire") {
                        Intent intent = new Intent(this, FormularioZonaAire.class);
                        String horas = (String) hora.getText();
                        String fechas = (String) fecha.getText();
                        String Halconeros = (String) halconeros.getSelectedItem();
                        String AcRealizar = (String)controles.getSelectedItem();
                        intent.putExtra("Place","ZONAAIRE");
                        intent.putExtra("Hora", horas);
                        intent.putExtra("Fecha", fechas);
                        intent.putExtra("Halconero", Halconeros);
                        intent.putExtra("Accion",AcRealizar);
                        startActivity(intent);
                        finish();
                    }
                    if(controles.getSelectedItem()=="Area Resgtringida") {
                        Intent intent = new Intent(this, mapa.class);
                        String horas = (String) hora.getText();
                        String fechas = (String) fecha.getText();
                        String Halconeros = (String) halconeros.getSelectedItem();
                        String AcRealizar = (String)controles.getSelectedItem();
                        intent.putExtra("Place","AREARESTRINGIDA");
                        intent.putExtra("Hora", horas);
                        intent.putExtra("Fecha", fechas);
                        intent.putExtra("Halconero", Halconeros);
                        intent.putExtra("Accion",AcRealizar);
                        startActivity(intent);
                        finish();
                    }

                }
                break;

            default:
                break;
        }
    }
}
