package mx.edu.ittepic.tpdm_u5_practica2_juanmejia;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        Object[] pdus = (Object[]) extras.get("pdus");
        SmsMessage mensaje = SmsMessage.createFromPdu((byte[])pdus[0]);

        Toast.makeText(context,"TELEFONO ORIGEN: "+mensaje.getOriginatingAddress()+
                "CONTENIDO: "+mensaje.getMessageBody(),Toast.LENGTH_LONG).show();
    }
}
