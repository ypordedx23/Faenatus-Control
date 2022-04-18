package yurydaniel.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView botonmapa,botonVer,botonAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonmapa=(ImageView) findViewById(R.id.imagen2);
        botonmapa.setOnClickListener(this);
        botonVer=(ImageView)findViewById(R.id.imagen3);
        botonVer.setOnClickListener(this);
        botonAd = (ImageView)findViewById(R.id.imagen1);
        botonAd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imagen2:
                Intent intent = new Intent(this,RegistroDatos.class);
                startActivity(intent);

                break;
            case R.id.imagen3:
                Intent intentM = new Intent(this, recursos.class);
                startActivity(intentM);
                break;
            case R.id.imagen1:
                //path the intentde envio de archivo

                File root=android.os.Environment.getExternalStorageDirectory();
                File dir = new File (root.getAbsolutePath()+"/Android/data/RegistroControlFauna/Files");
                dir.mkdirs();
                String filename="contacts_sid.vcf";
                File filelocation = new File(dir, "registroPOND.xls");
                File filelocation2 = new File(dir, "registroZONAAIRE.xls");
                File filelocation3 = new File(dir, "registroAREARESTRINGIDA.xls");
                ArrayList<Uri> uris = new ArrayList<Uri>();
                Uri path = Uri.fromFile(filelocation);
                Uri path2 = Uri.fromFile(filelocation2);
                Uri path3 = Uri.fromFile(filelocation3);
                uris.add(path);
                uris.add(path2);
                uris.add(path3);
                Intent emailIntent = new Intent(Intent.ACTION_SEND_MULTIPLE);
// set the type to 'email'
                emailIntent .setType("vnd.android.cursor.dir/email");
                String to[] = {"ptufino@yahoo.com"};
                emailIntent .putExtra(Intent.EXTRA_EMAIL, to);
                //emailIntent .putExtra(Intent.EXTRA_EMAIL, to2);
                emailIntent .putExtra(Intent.EXTRA_STREAM, uris);
// the mail subject
                emailIntent .putExtra(Intent.EXTRA_SUBJECT, "Registros de Control de Fauna");
                startActivity(Intent.createChooser(emailIntent , "Send email..."));
                break;
        }
    }
}
