package com.sam.email_3e;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import de.hdodenhof.circleimageview.CircleImageView;
import androidx.annotation.Nullable;


public class MainActivity2 extends AppCompatActivity {
    String nombre, hora, descripcion;
    Boolean  reenviado;
    int img;
    CircleImageView foto;
    TextView textoNombre, textoHora, textoDescripcion, textoReenviado;

    @Override
    protected  void onCreate(Bundle savedIntanceState){
        super.onCreate(savedIntanceState);
        setContentView(R.layout.activity_main2);

        textoNombre = findViewById(R.id.nombreEmail);
        textoHora = findViewById(R.id.horaEmail);
        textoDescripcion = findViewById(R.id.descripcion);
        textoReenviado = findViewById(R.id.reenviadoEmail);
        foto = findViewById(R.id.fotoEmail);

        Intent recibir = this.getIntent();
        if (recibir != null){
            nombre = recibir.getStringExtra("emisor");
            hora = recibir.getStringExtra("hora");
            img = recibir.getIntExtra("foto", R.drawable.def_email);
            descripcion = recibir.getStringExtra("asunto");
            reenviado = recibir.getBooleanExtra("reenviado", false);

            textoNombre.setText(nombre);
            textoHora.setText(hora);
            textoDescripcion.setText(descripcion);
            textoReenviado.setText(resentParser(reenviado));
            foto.setImageResource(img);
        }
    }
    private String resentParser(Boolean resent){
        return resent ? "Email reenviado" : "Este email no ha sido reenviado";
    }
}