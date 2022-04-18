package yurydaniel.myapplication;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.util.List;

public class recursos extends AppCompatActivity implements View.OnClickListener {

    Button archivoPond,archivoZA,archivoZR;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recursos);
        archivoPond = (Button) findViewById(R.id.btnPOND);
        archivoPond.setOnClickListener(this);
        archivoZA = (Button)findViewById(R.id.btnZonaAire);
        archivoZA.setOnClickListener(this);
        archivoZR=(Button)findViewById(R.id.btnAreaRestringida);
        archivoZR.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPOND:
                File root=android.os.Environment.getExternalStorageDirectory();
                File file= new File (root.getAbsolutePath()+"/Registros/registroPOND.xls");
                Intent intent = new Intent();
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setAction(Intent.ACTION_VIEW);
                String type = "application/vnd.ms-excel";
                intent.setDataAndType(Uri.fromFile(file), type);
                startActivity(intent);
                break;
            case R.id.btnAreaRestringida:
                File root2=android.os.Environment.getExternalStorageDirectory();
                File file2= new File (root2.getAbsolutePath()+"/Registros/registroAREARESTRINGIDA.xls");
                Intent intent2 = new Intent();
                intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent2.setAction(Intent.ACTION_VIEW);
                String type2 = "application/vnd.ms-excel";
                intent2.setDataAndType(Uri.fromFile(file2), type2);
                startActivity(intent2);
                break;
            case R.id.btnZonaAire:
                File root3=android.os.Environment.getExternalStorageDirectory();
                File file3= new File (root3.getAbsolutePath()+"/Registros/registroZONAAIRE.xls");
                Intent intent3 = new Intent();
                intent3.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent3.setAction(Intent.ACTION_VIEW);
                String type3 = "application/vnd.ms-excel";
                intent3.setDataAndType(Uri.fromFile(file3), type3);
                startActivity(intent3);
                break;
        }
    }
}
