package yurydaniel.myapplication;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class mapa extends AppCompatActivity implements View.OnClickListener {
    Spinner spinner;
    Spinner spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        int i=0;
        spinner2 = (Spinner)findViewById(R.id.numero);
        List lis = new ArrayList();
        for (i=1;i<101;i++){
            lis.add(i);
        }
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,lis);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(arrayAdapter2);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(mapa.this,"Posición "+String.valueOf(spinner2.getSelectedItem()),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner = (Spinner)findViewById(R.id.letras);
        List list = new ArrayList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        list.add("G");
        list.add("H");
        list.add("I");
        list.add("J");
        list.add("K");
        list.add("L");
        list.add("M");
        list.add("N");
        list.add("O");
        list.add("P");
        list.add("W");
        list.add("X");
        list.add("Y");
        list.add("Z");


        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(mapa.this,"Posición "+String.valueOf(spinner.getSelectedItem()),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_formulario,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.siguiente:
                Intent intentAnterior=getIntent();
                Bundle bundle = intentAnterior.getExtras();
                String POND =(String) bundle.getString("Place");
                String horas=(String) bundle.getString("Hora");
                String fechas=(String)bundle.getString("Fecha");
                String Halconeros=(String)bundle.getString("Halconero");
                String actRes=(String)bundle.getString("Accion");
                Integer px = (Integer) spinner2.getSelectedItem();
                String py = (String) spinner.getSelectedItem().toString();
                Intent posicion = new Intent(this,Formulario.class);
                posicion.putExtra("Place",POND);
                posicion.putExtra("Hora",horas);
                posicion.putExtra("Fecha",fechas);
                posicion.putExtra("Halconero",Halconeros);
                posicion.putExtra("PosiX",px);
                posicion.putExtra("PosiY",py);
                posicion.putExtra("Accion",actRes);
                startActivity(posicion);
                finish();
                return true;
            case R.id.pprincipal:
                finish();
                return true;
            case R.id.sol:
                Toast.makeText(mapa.this,"Sonríe",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View v) {

    }
}
