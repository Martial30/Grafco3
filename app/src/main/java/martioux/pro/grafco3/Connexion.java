package martioux.pro.grafco3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import martioux.pro.grafco3.model.Commercial;
import martioux.pro.grafco3.proxy.ApiProxy;
import martioux.pro.grafco3.repository.CommercialRepository;
import martioux.pro.grafco3.restbeans.ObjetConnexion;
import martioux.pro.grafco3.restbeans.Users;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Connexion extends AppCompatActivity implements RTI.MaisonMere{
    // LIEN DE TUTO IMPORTANT https://youtu.be/fHaOaSc7urc
    ScrollView uet;
    EditText edi_login, edi_mdp;
    TextView btn_connexion;
    ProgressBar progres;
    TextView patienter;
    ApiProxy apiProxy;
    //CardView card;

    CommercialRepository commercialRepository;
    OpenApplication app;


    public void aller(){
                getSupportFragmentManager ().beginTransaction ()
        .replace (R.id.scrollViews, new ProfileFragment () )
        .commit ();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_connexion);

        app = (OpenApplication)getApplication ();
        commercialRepository = new CommercialRepository (getApplication());

        uet =findViewById (R.id.uet);
        edi_login = findViewById (R.id.textlogin);
        edi_mdp = findViewById (R.id.textmdp);
        btn_connexion = findViewById (R.id.btnConnexion);
//        progres=findViewById (R.id.progres);
//        patienter=findViewById (R.id.inscription);

        btn_connexion.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                //Déclaration des variable et liaison
                String  login, mdpmobile;
                login= String.valueOf (edi_login.getText ());
                mdpmobile= String.valueOf (edi_mdp.getText ());
                //azertyuiop

                if(commercialRepository.checkcommercial ().size () > 0){
                    Commercial cl = commercialRepository.checkcommercial ().get (0);
                    if(cl.getLogin().trim().equals (login.trim()) &&
                            cl.getMotdepasse().trim ().equals (mdpmobile.trim ())){
                        startActivity (new Intent (getApplicationContext (), MainActivity.class ));
                    }
                    else Toast.makeText(getApplicationContext(),
                            "L'Identifiant ou le Mot de passe est " +
                                    "incorrect !" ,
                            Toast.LENGTH_LONG).show();
                }
                else {
                    initproxy ();
                    envoiDonnee (login, mdpmobile);
                }
            }
        });

       // public void fetchData(){

    }



    private void initproxy(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                //.addInterceptor(loggingInterceptor)
                .readTimeout(300, TimeUnit.SECONDS)
                .connectTimeout(300, TimeUnit.SECONDS)
                .build();

        apiProxy = new Retrofit.Builder()
                .baseUrl("http://192.168.1.18:8081/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiProxy.class);
    }

    private void envoiDonnee(String identifiant, String pwd){
        ObjetConnexion on = new ObjetConnexion ();
        on.setUtilisateur (identifiant);
        on.setPwd (pwd);
        apiProxy.connexion(on).enqueue(new Callback<Users> () {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
               if(response.body ().getLogin ().trim ().length ()>0){

                   Commercial cl=
                           commercialRepository.getCommercial (response.body ().getRowid ());
                   if(cl==null){
                       cl= new Commercial ();
                       cl.setLogin (response.body ().getLogin ());
                       cl.setMotdepasse (response.body ().getMdpmobile ());
                       cl.setComid (response.body ().getRowid ());
                       cl.setNomusers (response.body ().getNomusers ());
                       cl.setPrenomusers (response.body ().getPrenomusers ());
                       cl.setEmailusers (response.body ().getEmailusers ());
                       cl.setPhotousers (response.body ().getPhotousers ());
                       commercialRepository.insert (cl);
                   }

                   Snackbar snackbar= Snackbar.make (uet,"Login ou Mot de passe incorrect !", Snackbar.LENGTH_LONG)
                           .setAction ("Fermer", new View.OnClickListener () {
                               @Override
                               public void onClick(View view) {
                                   Snackbar snackbar1= Snackbar.make (uet, "done", Snackbar.LENGTH_LONG);
                                   snackbar1.show ();
                               }
                           });
                   snackbar.setBackgroundTint (getResources ().getColor (R.color.snak_color_success));

                   snackbar.show ();



                   Intent i = new Intent (getApplicationContext (), MainActivity.class );
                   startActivity (i);

               }else{
                   /*Toast.makeText(getApplicationContext(),
                           "L'Identifiant ou le Mot de passe est " +
                                   "incorrect !" ,
                           Toast.LENGTH_LONG).show();*/

                   Snackbar snackbar= Snackbar.make (uet,"Login ou Mot de passe incorrect !", Snackbar.LENGTH_LONG)
                           .setAction ("Fermer", new View.OnClickListener () {
                               @Override
                               public void onClick(View view) {
                                   Snackbar snackbar1= Snackbar.make (uet, "done", Snackbar.LENGTH_LONG);
                                   snackbar1.show ();
                               }
                           });
                   snackbar.setBackgroundTint (getResources ().getColor (R.color.snak_color_wrong));
                   snackbar.show ();


               }

                /*
                 @Override
                 public void onResponse(Call<Users> call, Response<Users> response) {
                Toast.makeText(getApplicationContext(),
                        "Identifiant : " + response.body ().getUsername (),
                        Toast.LENGTH_SHORT).show();
                 */
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {
                    Toast.makeText(getApplicationContext(),
                            "Erreur liée à la connexion! " + t.toString(), Toast.LENGTH_SHORT).show();
                /*    */
                //update_finished++;
            }
        });
    }
}


