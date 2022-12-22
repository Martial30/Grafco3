package martioux.pro.grafco3;

import static java.security.AccessController.getContext;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.concurrent.TimeUnit;

import martioux.pro.grafco3.model.Commercial;
import martioux.pro.grafco3.model.Rapport;
import martioux.pro.grafco3.proxy.ApiProxy2;
import martioux.pro.grafco3.repository.RapportRepository;
import martioux.pro.grafco3.restbeans.ObjetEcrireRapport;
import martioux.pro.grafco3.restbeans.Quete;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ModifRapport extends AppCompatActivity {

    TextInputEditText editrapport;
    int idrap = 0;
    ApiProxy2 apiProxy2;
    OpenApplication app;
    RapportRepository rapportRepository;
    Button btnmodif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_modif_rapport);

        editrapport = findViewById (R.id.editrapport);
        btnmodif = findViewById (R.id.btnmodif);

        btnmodif.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                initProxyt();

            }
        });

        Bundle intent = getIntent ().getExtras ();
        if (intent!= null){
            idrap = intent.getInt ("idrap", 0);
            editrapport.setText (intent.getString ("rapport"));
        }
    }



    private void initProxyt(){
        OkHttpClient okHttpClient= new OkHttpClient.Builder ()
                .readTimeout(300, TimeUnit.SECONDS)
                .connectTimeout(300, TimeUnit.SECONDS)
                .build();

        apiProxy2= (ApiProxy2) new Retrofit.Builder()
                .baseUrl("http://192.168.1.18:8081/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create ())
                .build()
                .create(ApiProxy2.class);

        recupeEcrireRapport();
    }

    private void recupeEcrireRapport() {

        ObjetEcrireRapport ot = new ObjetEcrireRapport ();
        ot.setIdrapport (idrap);
        ot.setTexterapport (editrapport.getText ().toString ());
        Commercial cl= app.getDb ().commercialDao ().getAll ().get (0);

        ot.setCode (cl.getComid ());

        apiProxy2.callfairerapport (ot).enqueue (new Callback<Quete> () {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<Quete> call, Response<Quete> response) {
                // response.body ().forEach (objetEcrireRapport ->);
                Rapport rapport= rapportRepository.getRapport (response.body ().getIdent ());
                if (rapport==null) rapport= new Rapport ();
                rapport.setIdraps (response.body ().getIdent ());
                rapport.setCode (cl.getComid ());
                rapport.setTexterapport (editrapport.getText ().toString ());
                rapportRepository.insert (rapport);
                Toast.makeText (getApplicationContext (), "Rapport sauvegrdé !", Toast.LENGTH_SHORT);
            }

            @Override
            public void onFailure(Call<Quete> call, Throwable t) {
                //Toast.makeText (ecrire_rapport.this, "Une erreur a due se produire", Toast.LENGTH_SHORT);
            }
        });

    }
}