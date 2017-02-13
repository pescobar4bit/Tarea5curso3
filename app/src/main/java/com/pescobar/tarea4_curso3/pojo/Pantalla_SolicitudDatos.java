package com.pescobar.tarea4_curso3.pojo;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.pescobar.tarea4_curso3.R;

import java.security.Security;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Pantalla_SolicitudDatos extends AppCompatActivity implements View.OnClickListener {

    Session session= null;
    ProgressDialog pdialog=null;
    Context context=null;
    private TextView txtNombre;
    private TextView txtCorreo;
    private TextView txtMensaje;
    private Button btnEnviarB;
    String rec,subject, textMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla__solicitud_datos);

        context=this;
        txtNombre = (TextView) findViewById(R.id.txtNombrePersona);
        txtCorreo = (TextView) findViewById(R.id.txtCorreo);
        txtMensaje = (TextView) findViewById(R.id.textMensaje);
        Button login= (Button) findViewById(R.id.btnEnviar);

        login.setOnClickListener(this);
      }

    @Override
    public void onClick(View view) {
        rec= txtCorreo.getText().toString();
        subject="Asunto";
        textMessage= txtMensaje.getText().toString();

        Properties props= new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smpt.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.port","465");

        session= Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("pabloxela@gmail.com","mipass");
            }
        });
        pdialog= ProgressDialog.show(context,"","Enviando mensaje...", true);

        RetrieveFeedTask task= new RetrieveFeedTask();
        task.execute();
    }

    class RetrieveFeedTask extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... strings) {
            try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("pabloxela@gmail.com"));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(rec));
                message.setSubject(subject);
                message.setContent(textMessage, "text/html; charset=utf-8");
                Transport.send(message);

            } catch (MessagingException e){
                e.printStackTrace();
            } catch (Exception e){
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            pdialog.dismiss();
            txtNombre.setText("");
            txtCorreo.setText("");
            txtMensaje.setText("");
            Toast.makeText(getApplicationContext(),"Mensaje enviado", Toast.LENGTH_LONG).show();
        }
    }


    }





