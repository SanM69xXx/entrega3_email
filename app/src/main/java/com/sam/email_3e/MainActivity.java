package com.sam.email_3e;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ListAdapter;

public class MainActivity extends AppCompatActivity {
    ListView listaEmails;
    boolean[] leido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] fotosEmail = {
                R.drawable.chucho,
                R.drawable.mi_negra,
                R.drawable.nelson,
                R.drawable.novia,
                R.drawable.tony,
        };
        String[] nombresEmail = {
                "chucho",
                "mi negra hermosa",
                "Nelson banhautenn",
                "mi amor",
                "tony el mafiosd",
        };
        String[] descripciones = {
                "oe mañana vamos para envigado a comprar los cascos",
                "santi acuerdate que el 13 cumplo años,no se te olvide la salida,te amo",
                "ja ja ,ja ja ,ja ja",
                ",te amo,te amo,te amote amo,vte amote amote amote amote amote amote amote amo",
                "cojieron la mercancia,pero no importa ,mañana enviaremos mas",
        };
        String[] horas = {
                "13:30 PM",
                "00:19 AM",
                "4:20 PM",
                "3:33 PM",
                "00:01",
        };
        Boolean[] reenviado = {
                true,
                false,
                true,
                true,
                true,
        };
        leido = new boolean[nombresEmail.length];

        activity_listadapter emails = new activity_listadapter(MainActivity.this, nombresEmail,horas,fotosEmail,descripciones, reenviado, leido);
        listaEmails = (ListView) findViewById(R.id.listaEmails);
        listaEmails.setAdapter(emails);

        listaEmails.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                leido[position] = true;
                emails.notifyDataSetChanged();
                Intent SendInfo = new Intent(MainActivity.this, MainActivity2.class);
                SendInfo.putExtra("emisor", nombresEmail[position])
                        .putExtra("hora", horas[position])
                        .putExtra("foto", fotosEmail[position])
                        .putExtra("asunto", descripciones[position])
                        .putExtra("reenviado:", reenviado[position]);
                startActivity(SendInfo);
            }
        });

    }
}
