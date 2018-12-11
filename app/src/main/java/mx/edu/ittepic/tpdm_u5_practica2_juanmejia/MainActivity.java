package mx.edu.ittepic.tpdm_u5_practica2_juanmejia;

import android.Manifest;
import android.content.ContentValues;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button permisos,enviar;
    EditText numero,mensaje;
    Base basedatos;
    String h, tbl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

        permisos = findViewById(R.id.permisos);
        enviar = findViewById(R.id.enviar);
        numero = findViewById(R.id.numero);
        mensaje = findViewById(R.id.mensaje);
        basedatos = new Base(this,"base1",null,1);

        solicitarPermiso();

        permisos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verPermisos();
            }
        });

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarSMS();
            }
        });
    }

    private void enviarSMS() {
        int r1 = (int) (Math.random()*5)+1;
        String id = "";
        if(r1 == 1){id = "DEADPOOL";}if(r1 == 2){id = "BATMAN";}if(r1 == 3){id = "WOLVERINE";}if(r1 == 4){id = "SUPERMAN";}if(r1 == 5){id = "SPIDERMAN";}
        try {
            String t = numero.getText().toString();
            String m = mensaje.getText().toString();

            SmsManager smsManager = SmsManager.getDefault();
            if(m.startsWith("HEROE")){//DE COMICS
                String[] parametros=m.split(" ");
                if (parametros.length==3){

                    /*SQLiteDatabase base = basedatos.getWritableDatabase();
                    String SQL = "select * from HEROES where ID =" + r1;
                    Cursor x = base.rawQuery(SQL, null);

                    if (x.moveToFirst() == false) {
                        AlertDialog.Builder a = new AlertDialog.Builder(this);
                        a.setMessage("No se encontro Ningun registro").show();
                        base.close();
                        return;
                    }

                    Toast.makeText(this, ""+x.getString(0)+x.getString(1), Toast.LENGTH_SHORT).show();
                    //id = x.getString(1);*/
                    m = id;
                    //base.close();

                    smsManager.sendTextMessage(t,null,m,null,null);
                    Toast.makeText(this, "SE ENVIO", Toast.LENGTH_SHORT).show();
                    numero.setText("");
                    mensaje.setText("");
                }else{
                    smsManager.sendTextMessage(t,null,m,null,null);
                    Toast.makeText(this, "SE ENVIO", Toast.LENGTH_SHORT).show();
                    numero.setText("");
                    mensaje.setText("");
                }
            }

        }catch (Exception e){
            Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    private void verPermisos() {
        String resultado="";
        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.READ_PHONE_STATE)
                ==PackageManager.PERMISSION_GRANTED){
            //ENTRA SI EL PERMISO ESTA DENEGADO YA QUE SERA DIERENTE A PERMISO OTORGADO
            resultado="SI PERMISO LECTURA ESTADO TELEFONO";
        }else{
            resultado="NO HAY PERMISO LECTURA ESTADO TELEFONO";
        }

        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.SEND_SMS)
                ==PackageManager.PERMISSION_GRANTED){
            //ENTRA SI EL PERMISO ESTA DENEGADO YA QUE SERA DIERENTE A PERMISO OTORGADO
            resultado+="\nSI PERMISO ENVIO SMS";
        }else {
            resultado+="\nNO HAY PERMISO ENVIO SMS";
        }

        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setTitle("ATENCION")
                .setMessage(resultado)
                .setPositiveButton("ACEPTAR",null)
                .show();

    }

    private void solicitarPermiso() {
        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.READ_PHONE_STATE)
                !=PackageManager.PERMISSION_GRANTED){
            //ENTRA SI EL PERMISO ESTA DENEGADO YA QUE SERA DIERENTE A PERMISO OTORGADO
            ActivityCompat.requestPermissions(this,new String []{Manifest.permission.READ_PHONE_STATE},1);
        }

        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.SEND_SMS)
                !=PackageManager.PERMISSION_GRANTED){
            //ENTRA SI EL PERMISO ESTA DENEGADO YA QUE SERA DIERENTE A PERMISO OTORGADO
            ActivityCompat.requestPermissions(this,new String []{Manifest.permission.SEND_SMS},2);
        }

        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.READ_SMS)
                !=PackageManager.PERMISSION_GRANTED){
            //ENTRA SI EL PERMISO ESTA DENEGADO YA QUE SERA DIERENTE A PERMISO OTORGADO
            ActivityCompat.requestPermissions(this,new String []{Manifest.permission.READ_SMS},3);
        }
        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.RECEIVE_SMS)
                !=PackageManager.PERMISSION_GRANTED){
            //ENTRA SI EL PERMISO ESTA DENEGADO YA QUE SERA DIERENTE A PERMISO OTORGADO
            ActivityCompat.requestPermissions(this,new String []{Manifest.permission.RECEIVE_SMS},4);
        }

    }

    /*private void buscar(String valor) {
            try {
                SQLiteDatabase base = basedatos.getWritableDatabase();
                String SQL = "select * from HEROES where ID =" + valor;
                Cursor x = base.rawQuery(SQL, null);
                if (x.moveToFirst() == false) {
                    AlertDialog.Builder a = new AlertDialog.Builder(this);
                    a.setMessage("No se encontro Ningun registro con ese id").show();
                    base.close();
                    return;
                }


                tbl =h;

                base.close();
            } catch (SQLiteException e) {
                mensaje("error", e.getMessage());
            }
        }//buscar


    private void mensaje(String title,String message){
        AlertDialog.Builder a = new AlertDialog.Builder(this);
        a.setTitle(title).setMessage(message);
    }*/
}//class
