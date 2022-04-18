package yurydaniel.myapplication;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.StrictMode;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.w3c.dom.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Formulario extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    static String TAG = "ExelLog";
    //clase formulario
    public class formPond extends AppCompatActivity{
        String fecha;
        String hora;
        String halconero;
        String localizacion;
        String clima;
        String altura;
        String especie;
        Integer cantidad;
        String tamanioGrupo;
        String actividad;
        String metControl;
        String metControlComent;
        String resultado;
        String estadoMall;
        String estadoMallComent;
        String responsable;
        String procedimiento;
        //setter constructor
        public formPond(String fecha,String hora,String halconero,String localizacion,String clima,String altura,String especie,Integer cantidad,String tamanioGrupo,String actividad,String metControl,String metControlComent, String resultado, String estadoMall,String estadoMallComent,String responsable,String procedimiento){
            this.fecha=fecha;
            this.hora=hora;
            this.halconero=halconero;
            this.localizacion=localizacion;
            this.clima=clima;
            this.altura=altura;
            this.especie=especie;
            this.cantidad=cantidad;
            this.tamanioGrupo=tamanioGrupo;
            this.actividad=actividad;
            this.metControl=metControl;
            this.metControlComent=metControlComent;
            this.resultado=resultado;
            this.estadoMall=estadoMall;
            this.estadoMallComent=estadoMallComent;
            this.responsable=responsable;
            this.procedimiento=procedimiento;
        }
        //getters
        public String getFecha(){
            return fecha;
        }
        public String getHora(){
            return hora;
        }
        public String getHalconero(){
            return halconero;
        }
        public String getLocalizacion(){
            return localizacion;
        }
        public String getClima(){
            return clima;
        }
        public String getAltura(){
            return altura;
        }
        public String getEspecie(){
            return especie;
        }
        public Integer getCantidad(){
            return cantidad;
        }
        public String getTamanioGrupo(){
            return tamanioGrupo;
        }
        public String getActividad(){
            return actividad;
        }
        public String getMetControl(){
            return metControl;
        }
        public String getMetControlComent(){
            return metControlComent;
        }
        public String getResultado(){
            return resultado;
        }
        public String getEstadoMall(){
            return estadoMall;
        }
        public String getEstadoMallComent(){
            return estadoMallComent;
        }
        public String getResponsable(){
            return responsable;
        }
        public String getProcedimiento(){
            return procedimiento;
        }


    }
    //cadenas de texto
    String[] cadClima = {"Cielo despejado", "Algunas nubes", "Cielo cubierto", "Lluvia"};
    String[] cadAltura = {"0 - 30 metros", "31 - 150 metros", "Mayor a 150 metros"};
    String[] cadEspecie = {"Actitis macularia / Andarríos Coleador", "Anairetes parulus / Cachudito Torito", "Anas andium / Cerceta Andina", "Anas discors / Cerceta aliazul", "Anas bahamensis / Anade Cariblanco", "Anas georgica / Anade Piquiamarillo", "Ardea alba / Garceta Grande"
            , "Athene cunicularia / Búhito Terrestre", "Atlapetes leucopterus / Picogrueso pechirrosado", "Bubo virginianus / Búho Coronado Americano", "Bubulcus ibis / Garceta Bueyera", "Buteo polyosoma / Gavilán Variable", "Butorides striatus / Garcilla Estriada"
            , "Camptostoma obsoletum / Tiranolete Silbador Sureño", "Calidris bairdii / Playero de Baird", "Calidris pusilla / Playero semipalmeado", "Camptostoma obsoletum / Tiranolete silvador", "Caprimulgus longirostris / Chotacabra Alifajeada"
            , "Carduelis magellanica / Jilguero Encapuchado", "Carduelis spinescens / Jilguero Andino", "Catamenia analis / Semillero Colifajeado", "Cathartes aura / Gallinazo Cabecirrojo", "Catharus ustulatus / Zorzal de Swainson", "Chaetocercus mulsant / Estrellita Ventriblanca"
            , "Chlorostilbon mellisugus / Esmeralda Occidental", "Chlorostilbon melanorhynchus / Esmeralda Occidental", "Colibri coruscans / Orejivioleta Ventriazul", "Columbina passerina / Tortolita Común", "Conirostrum cinereum / Picocono Cinéreo"
            , "Contopus fumigatus / Pibí Ahumado", "Coragyps atratus / Gallinazo Negro", "Diglossa humeralis / Pinchaflor Negro", "Diglossa sittoides / Pinchaflor Pechicanelo", "Egretta thula / Garceta Nívea", "Elanus leucurus / Elanio Coliblanco"
            , "Euphonia cyanocephala / Eufonia Lomidorada", "Falco peregrinus / Halcón Peregrino", "Falco sparverius / Cernícalo Americano", "Fulica ardesiaca / Focha Andina", "Geranoaetus melanoleucus / Aguila Pechinegra", "Geranoaetus polyosoma / Gavlilán variable"
            , "Larus serranus / Gaviota Andina", "Larus argentatus / Gaviota Argentea", "Lesbia victoriae / Colacintillo Colinegro", "Mimus gilvus / Sinsonte Tropical", "Myioborus miniatus / Candelita Coliplomiza", "Myiophobus fasciatus / Alinaranja Colilistada"
            , "Myiotheretes striaticollis / Alinaranja Colilistada", "Myrtis fannyi / Estrellita Gargantillada", "Nomonyx dominicus / Pato Enmascarado", "Notiochelidon cyanoleuca / Golondrina Azuliblanca", "Notiochelidon murina / Golondrina Ventricafé"
            , "Pandion haliaetus / Aguila Pescadora", "Parabuteo unicinctus / Gavilán Alicastaño", "Patagona gigas / Colibrí Gigante", "Patagioenas fasciata / Paloma Collajera", "Phalcoboenus carunculatus / Caracara Curiquingue", "Phalacrocorax brasilianus / Cormorán neotropical"
            , "Pheucticus chrysogaster / Picogrueso Amarillo Sureño", "Pheucticus ludovicianus / Frigilo Colifajeado", "Phrygilus alaudinus / Frigilo Colifajeado", "Phrygilus plebejus / Frigilo Pechicinéreo", "Podilymbus podiceps / Zambullidor Piquipinto", "Pygochelidon cyanoleuca / Golondrina Azuliblanca"
            , "Piculus rivoli / Carpintero Dorsicarmesí", "Podylimbus podiceps / Zambullidor Piquipinto", "Pyrocephalus rubinus / Mosquero Bermellón", "Saltator striatipectus / Saltador Listado", "Sicalis flaveola / Pinzón Sabanero Azafranado"
            , "Sicalis luteola / Pinzón-Sabanero Común", "Spatula discors / Cerceta Aliazul", "Sporophila nigricollis / Espiguero Ventriamarillo", "Sporophila luctuosa*+ / Espiguero Negriblanco", "Steganopus tricolor / Falaropo tricolor"
            , "Stectoprocne zonaris / Vencejo Cuelliblanco", "Synallaxis azarae / Colaespina de Azara", "Tachybaptus dominicus / Zambullidor Menor", "Tangara vitriolina / Tangara Matorralera", "Thlypopsis ornata / Tangara Pechicanela",
            "Thraupis bonariensis / Tangara Azuliamarilla", "Tringa flavipes / Patiamarillo Menor", "Tringa melanoleuca / Patiamarillo Mayor", "Troglodytes aedon / Soterrey Criollo", "Turdus fuscater / Mirlo Grande", "Tyto alba / Lechuza de Campanario"
            , "Zenaida auriculata / Tórtola Orejuda", "Zonotrichia capensis / Gorrión o Chingolo"};
    String[] cadGrupo = {"Bandadas grandes >20 individuos", "Bandadas medianas: entre 5 y 20 individuos", "Bandadas pequeñas, entre 3 y 5 individuos", "Solitarios y en parejas"};
    String[] cadActividad = {"Malla perimetral", "Césped", "Volando", "Perchando árbol", "Plataforma", "Pista", "Cruzando pista", "Perchando infraestructura"};
    String[] cadMetodoControl = {"Canes", "Águilas", "Halcones", "Pirotécnia", "Laser", "Canes + rapaz", "Canes + pirotecnia", "Eliminación de nidos", "Captura y traslocación", "Persecución vehículo", "Obstrucción de accesos", "Eliminación de atractivos", "No aplica"};
    String[] cadResultado = {"Despejado", "Caza", "Retorna (dentro mismo recorrido)", "Avistamiento", "Segimiento"};
    String[] cadEstadoMalla = {"Sin Novedad", "Presenta novedades"};
    String[] cadResponsable = {"Faunaetus", "Oscar II", "Faunaetus / Oscar II", "Oscar I", "Kilo 10", "Oscar III", "Otro"};
    String[] cadProcedimiento = {"Recorrido diario", "Atención llamado"};
    String tipoFORM="";
    Spinner clima, altura, Especie, grupo, actividad, metCOntrol, Resul, Respon, Proced, EstaMall;
    TextView hora, fecha, halconero;
    EditText localizcion, Cantidad, NombreAlt, EstadoMallEdit;
    private static final int ABRIRFICHERO_RESULT_CODE = 1;
    //Boton de Envio
    Button agrArra;
    ArrayList <formPond> formPond=null;
    boolean flag=false;
    formPond aux=null;
    static List<claseDatosFormulario> listaTot=new ArrayList<claseDatosFormulario>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        listaTot.clear();
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        builder.detectFileUriExposure();
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_formulario);
        //extracion de Datos
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        tipoFORM=(String)bundle.getString("Place");
        String horas = (String) bundle.getString("Hora");
        String fechas = (String) bundle.getString("Fecha");
        String Halconeros = (String) bundle.getString("Halconero");
        String actRealizar = (String) bundle.getString("Accion");
        Integer posX = (Integer) bundle.getInt("PosiX");
        String posY = (String) bundle.getString("PosiY");
        //Seteado de datos en pantalla
        hora = (TextView) findViewById(R.id.txtHoraDato);
        fecha = (TextView) findViewById(R.id.txtFechaDato);
        halconero = (TextView) findViewById(R.id.textResponsable);
        localizcion = (EditText) findViewById(R.id.textPosXY);
        Cantidad = (EditText) findViewById(R.id.editTextCantidad);
        NombreAlt = (EditText) findViewById(R.id.textNombreMetodo);
        EstadoMallEdit = (EditText) findViewById(R.id.textEstadoMalla);
        //llenando cajas de texo
        hora.setText(horas);
        System.out.print(horas);
        fecha.setText(fechas);
        halconero.setText(Halconeros);
        localizcion.setText("X : " + posX + " - Y:" + posY);
        localizcion.setEnabled(false);
        //Seteando Listas!!!!
        List lClima = new ArrayList();
        lClima = Arrays.asList(cadClima);
        List lAltura = new ArrayList();
        lAltura = Arrays.asList(cadAltura);
        List lEspecie = new ArrayList();
        lEspecie = Arrays.asList(cadEspecie);
        List lGrupo = new ArrayList();
        lGrupo = Arrays.asList(cadGrupo);
        List lActividad = new ArrayList();
        lActividad = Arrays.asList(cadActividad);
        List lMetControl = new ArrayList();
        lMetControl = Arrays.asList(cadMetodoControl);
        List lResult = new ArrayList();
        lResult = Arrays.asList(cadResultado);
        List lMalla = new ArrayList();
        lMalla = Arrays.asList(cadEstadoMalla);
        List lRespons = new ArrayList();
        lRespons = Arrays.asList(cadResponsable);
        List lProcedimiento = new ArrayList();
        lProcedimiento = Arrays.asList(cadProcedimiento);
        clima = (Spinner) findViewById(R.id.spinnerClima);
        ArrayAdapter adapterClim = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, lClima);
        adapterClim.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        clima.setAdapter(adapterClim);
        Especie = (Spinner) findViewById(R.id.spinnerEspecie);
        ArrayAdapter adapterEsp = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, lEspecie);
        adapterEsp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Especie.setAdapter(adapterEsp);
        altura = (Spinner) findViewById(R.id.spinnerAltura);
        ArrayAdapter adaptAltu = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, lAltura);
        adaptAltu.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        altura.setAdapter(adaptAltu);
        grupo = (Spinner) findViewById(R.id.spinnerTamanio);
        ArrayAdapter adapTamGrup = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, lGrupo);
        adapTamGrup.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        grupo.setAdapter(adapTamGrup);
        actividad = (Spinner) findViewById(R.id.spinnerActividad);
        ArrayAdapter adapAct = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, lActividad);
        adapAct.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        actividad.setAdapter(adapAct);
        metCOntrol = (Spinner) findViewById(R.id.spinnerMetoControl);
        ArrayAdapter adapMetCon = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, lMetControl);
        adapMetCon.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        metCOntrol.setAdapter(adapMetCon);
        Resul = (Spinner) findViewById(R.id.spinnerResulCom);
        ArrayAdapter adapResul = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, lResult);
        adapResul.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Resul.setAdapter(adapResul);
        Respon = (Spinner) findViewById(R.id.spinnerRespon);
        ArrayAdapter adapRespo = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, lRespons);
        adapRespo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Respon.setAdapter(adapRespo);
        Proced = (Spinner) findViewById(R.id.spinnerProcedimiento);
        ArrayAdapter adapProce = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, lProcedimiento);
        adapProce.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Proced.setAdapter(adapProce);
        EstaMall = (Spinner) findViewById(R.id.spinnerEstadoMalla);
        ArrayAdapter adapMalla = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, lMalla);
        adapMalla.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        EstaMall.setAdapter(adapMalla);
        EstaMall.setOnItemSelectedListener(this);
        metCOntrol.setOnItemSelectedListener(this);



        if(flag!=false){
            System.out.print(aux.getEstadoMallComent());
            String Salida= "";
            for( int i = 0 ; i  < formPond.size(); i++){
                Salida += i+" : "+formPond.get(i).getFecha()+formPond.get(i).getHora()+formPond.get(i).getLocalizacion()+formPond.get(i).getCantidad()+formPond.get(i).getMetControl()
                        +formPond.get(i).getEstadoMallComent();
                Salida += "n"+"n";
            }
            System.out.print(Salida);
        }

        verifyStoragePermissions(this);
        readExcelFile(this,"registro"+tipoFORM+".xls");
        if(listaTot.isEmpty()){
            Toast.makeText(this,"Lista vacia, no funciona la operacion leer",Toast.LENGTH_LONG);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()){
            case R.id.spinnerEstadoMalla:
                if((String)EstaMall.getSelectedItem()=="Sin Novedad"){
                    EstadoMallEdit.setEnabled(false);
                }else{
                    EstadoMallEdit.setEnabled(true);
                }
                break;
            case R.id.spinnerMetoControl:
                if((String)metCOntrol.getSelectedItem()=="Laser" || (String)metCOntrol.getSelectedItem()=="Eliminación de nidos" ||(String)metCOntrol.getSelectedItem()=="Persecución vehículo" || (String)metCOntrol.getSelectedItem()=="Eliminación de atractivos" || (String)metCOntrol.getSelectedItem()=="No aplica"){
                    NombreAlt.setEnabled(false);
                }else{
                    NombreAlt.setEnabled(true);
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_enviar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.pprincipal:
                finish();
                return true;
            case R.id.sol:
                Toast.makeText(Formulario.this,"Guardado",Toast.LENGTH_SHORT).show();
                verifyStoragePermissions(this);
                String horasf=(String)hora.getText().toString();
                String halconeros=(String)halconero.getText().toString();
                String localizacions=(String)localizcion.getText().toString();
                String climas=(String)clima.getSelectedItem().toString();
                String alturas=(String)altura.getSelectedItem().toString();
                String especies=(String)Especie.getSelectedItem().toString();
                String cantidads=Cantidad.getText().toString();
                String tamanioGrupos=(String)grupo.getSelectedItem().toString();
                String actividads=(String)actividad.getSelectedItem().toString();
                String metControls=(String)metCOntrol.getSelectedItem().toString();
                String metControlComents=(String)NombreAlt.getText().toString();
                String resultados=(String)Resul.getSelectedItem().toString();
                String estadoMalls=(String)EstaMall.getSelectedItem().toString();
                String estadoMallComents=(String)EstadoMallEdit.getText().toString();
                String responsables=(String)Respon.getSelectedItem().toString();
                String procedimientos=(String)Proced.getSelectedItem().toString();
                String fechas=(String)fecha.getText().toString();
                listaTot.add(new claseDatosFormulario(horasf,halconeros,climas,localizacions,alturas,especies,cantidads,actividads,tamanioGrupos,metControls,metControlComents,estadoMalls,
                        resultados,fechas, estadoMallComents,responsables,procedimientos));
                claseDatosFormulario t1;
                System.out.println("___________________________________");
                Iterator it=listaTot.iterator();
                while(it.hasNext())
                {
                    t1=(claseDatosFormulario)it.next();
                    System.out.println(t1.toString());
                }

                try {
                    saveExcelFile(this,"registro"+tipoFORM+".xls");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public boolean saveExcelFile(Context context, String fileName) throws IOException {

        // check if available and not read only


        boolean success = false;

        //New Workbook
        Workbook wb = new HSSFWorkbook();


        String[] headers = new String[]{
                "Fecha","Hora","Hora final", "Agente a Cargo","Localozación","Clima", "Altura","Especie de Fauna",
                "Cantidad","Tamaño Grupo", "Actividad","Metodo de control","Comentario Met.Control","Resultados","Estado Malla","Comentarios Est.Malla","Responsable","Procedimiento"
        };

        CellStyle cs = wb.createCellStyle();
        cs.setFillForegroundColor(HSSFColor.LIME.index);
        claseDatosFormulario t1;
        Sheet sheet = null;
        sheet = wb.createSheet("Registro");

        CellStyle headerStyle = wb.createCellStyle();
        Font font = wb.createFont();
        headerStyle.setFont(font);
        HSSFRow headerRow = (HSSFRow) sheet.createRow(0);
        for (int i = 0; i < headers.length; ++i) {
            String header = headers[i];
            HSSFCell cell = headerRow.createCell(i);
            cell.setCellStyle(headerStyle);
            cell.setCellValue(header);
        }
        int p=1;
        Iterator it=listaTot.iterator();
        while(it.hasNext())
        {
            HSSFRow dataRow = (HSSFRow) sheet.createRow(p + 1);
            t1=(claseDatosFormulario)it.next();
            String horasf=(String)t1.getHorasf();
            String halconeros=t1.getHalconeros();
            String localizacions=t1.getLocalizacions();
            String climas=t1.getClimas();
            String alturas=t1.getAlturas();
            String especies=t1.getEspecies();
            String cantidads=t1.getCantidads();
            String tamanioGrupos=t1.getTamanioGrupos();
            String actividads=t1.getActividads();
            String metControls=t1.getMetControls();
            String metControlComents=t1.getMetControlComents();
            String resultados=t1.getResultados();
            String estadoMalls=t1.getEstadoMalls();
            String estadoMallComents=t1.getEstadoMallComents();
            String responsables=t1.getResponsables();
            String procedimientos=t1.getProcedimientos();
            String fechas = t1.getFecha();
            Date date = new Date();
            DateFormat hourFormats = new SimpleDateFormat("HH:mm:ss");
            dataRow.createCell(0).setCellValue(fechas);
            dataRow.createCell(1).setCellValue(horasf);
            dataRow.createCell(2).setCellValue(hourFormats.format(date).toString());
            dataRow.createCell(3).setCellValue(halconeros);
            dataRow.createCell(4).setCellValue(localizacions);
            dataRow.createCell(5).setCellValue(climas);
            dataRow.createCell(6).setCellValue(alturas);
            dataRow.createCell(7).setCellValue(especies);
            dataRow.createCell(8).setCellValue(cantidads);
            dataRow.createCell(9).setCellValue(tamanioGrupos);
            dataRow.createCell(10).setCellValue(actividads);
            dataRow.createCell(11).setCellValue(metControls);
            dataRow.createCell(12).setCellValue(metControlComents);
            dataRow.createCell(13).setCellValue(resultados);
            dataRow.createCell(14).setCellValue(estadoMalls);
            dataRow.createCell(15).setCellValue(estadoMallComents);
            dataRow.createCell(16).setCellValue(responsables);
            dataRow.createCell(17).setCellValue(procedimientos);
            p++;
        }
        //lectura
        Iterator rowIter = sheet.rowIterator();
        while(rowIter.hasNext()){
            int cantCel=0;
            HSSFRow myRow = (HSSFRow) rowIter.next();
            Iterator cellIter = myRow.cellIterator();
            while(cellIter.hasNext()){
                HSSFCell myCell = (HSSFCell) cellIter.next();
                Log.d(TAG, "Cell Value: " +  myCell.toString());
            }
        }
        //guardado
        File root=android.os.Environment.getExternalStorageDirectory();
        File dir = new File (root.getAbsolutePath()+"/Registros");
        dir.mkdirs();
        File dir2 = new File (root.getAbsolutePath()+"/Android/data/RegistroControlFauna/Files");
        dir2.mkdirs();
        File file = new File(dir, fileName);
        File file2 = new File(dir2, fileName);
        FileOutputStream os = null;
        FileOutputStream os2 = null;
        try {
            os = new FileOutputStream(file);
            os2= new FileOutputStream(file2);
            wb.write(os);
            wb.write(os2);
            Log.w("FileUtils", "Writing file" + file);
            Log.w("FileUtils", "Writing file" + file2);
            success = true;
        } catch (IOException e) {
            Log.w("FileUtils", "Error writing " + file, e);
        } catch (Exception e) {
            Log.w("FileUtils", "Failed to save file", e);
        } finally {
            if (null != os)
                os.close();
        }
        return success;
    }

    private static void readExcelFile(Context context, String filename) {
        String fechas1="",horasf1="",horasf2="",halconeros1="",localizacions1="",climas1="",alturas1="",especies1="",cantidads1="1",tamanioGrupos1="",actividads1="",metControls1="",metControlComents1="",resultados1="",estadoMalls1="",estadoMallComents1="",responsables1="",procedimientos1="";
        try{
            File root=android.os.Environment.getExternalStorageDirectory();
            File dir = new File (root.getAbsolutePath()+"/Android/data/RegistroControlFauna/Files");
            dir.mkdirs();
            File file = new File(dir, filename);
            FileInputStream myInput = new FileInputStream(file);
            // Create a POIFSFileSystem object
            POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);

            // Create a workbook using the File System
            HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);

            // Get the first sheet from workbook
            HSSFSheet mySheet = myWorkBook.getSheetAt(0);
            int contRow=0;
            /** We now need something to iterate through the cells.**/
            Iterator rowIter = mySheet.rowIterator();
            while(rowIter.hasNext()){
                int cantCel=0;

                if(contRow==0 ){
                    HSSFRow myRow = (HSSFRow) rowIter.next();
                    contRow++;
                }else{
                    HSSFRow myRow = (HSSFRow) rowIter.next();
                    Iterator cellIter = myRow.cellIterator();
                    while(cellIter.hasNext()){
                        HSSFCell myCell = (HSSFCell) cellIter.next();
                        Log.d(TAG, "Cell Value: " +  myCell.toString());
                        switch(cantCel){
                            case 0:
                                fechas1=myCell.toString();
                                break;
                            case 1:
                                horasf1=myCell.toString();
                                break;
                            case 2:
                                horasf2=myCell.toString();
                                break;
                            case 3:
                                halconeros1=myCell.toString();
                                break;
                            case 4:
                                localizacions1=myCell.toString();
                                break;
                            case 5:
                                climas1=myCell.toString();
                                break;
                            case 6:
                                alturas1=myCell.toString();
                                break;
                            case 7:
                                especies1=myCell.toString();
                                break;
                            case 8:
                                cantidads1=myCell.toString();
                                break;
                            case 9:
                                tamanioGrupos1=myCell.toString();
                                break;
                            case 10:
                                actividads1=myCell.toString();
                                break;
                            case 11:
                                metControls1=myCell.toString();
                                break;
                            case 12:
                                metControlComents1=myCell.toString();
                                break;
                            case 13:
                                resultados1=myCell.toString();
                                break;
                            case 14:
                                estadoMalls1=myCell.toString();
                                break;
                            case 15:
                                estadoMallComents1=myCell.toString();
                                break;
                            case 16:
                                responsables1=myCell.toString();
                                break;
                            case 17:
                                procedimientos1=myCell.toString();
                                break;
                        }
                        cantCel++;
                        //Toast.makeText(context, "cell Value: " + myCell.toString(), Toast.LENGTH_SHORT).show();
                    }
                    claseDatosFormulario t1= new claseDatosFormulario(fechas1,horasf1,horasf2,halconeros1,localizacions1,climas1,alturas1,especies1,cantidads1,tamanioGrupos1,actividads1,metControls1,metControlComents1,resultados1,estadoMalls1,estadoMallComents1,responsables1,procedimientos1);
                    listaTot.add(t1);

                }
            }

            myWorkBook.close();
            myFileSystem.close();
            myInput.close();
            boolean deleted = file.delete();
        }catch (Exception e){e.printStackTrace(); }

        return;
    }

    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }
}