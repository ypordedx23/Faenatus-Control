package yurydaniel.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class POND extends AppCompatActivity    implements View.OnClickListener {

    String[] PositY={"Q","R","S","T","U","V","AA","AB","AC","AD","AE","AF","AG"};
    Spinner PosiX,PosiY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pond);
        List PosX=new ArrayList();
        for(int i=1;i<25;i++){
            PosX.add(i);
        }
        List PosY = new ArrayList();
        PosY= Arrays.asList(PositY);
        PosiX=(Spinner)findViewById(R.id.PosX);
        PosiY=(Spinner)findViewById(R.id.PosY);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,PosX);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        PosiX.setAdapter(adapter);
        ArrayAdapter adapter2 = new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,PosY);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        PosiY.setAdapter(adapter2);
    }

    @Override
    public void onClick(View v) {

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
                Intent intentN = new Intent(this,Formulario.class);
                Integer posX2= (Integer) PosiX.getSelectedItem();
                String posY2=(String)PosiY.getSelectedItem();
                intentN.putExtra("Place",POND);
                intentN.putExtra("PosiX",posX2);
                intentN.putExtra("PosiY",posY2);
                intentN.putExtra("Hora",horas);
                intentN.putExtra("Fecha",fechas);
                intentN.putExtra("Halconero",Halconeros);
                intentN.putExtra("Accion",actRes);
                System.out.print("hola si sirvo");
                startActivity(intentN);
                finish();
                return true;
            case R.id.pprincipal:
                finish();
                return true;
            case R.id.sol:
                Toast.makeText(POND.this,"Sonríe",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
