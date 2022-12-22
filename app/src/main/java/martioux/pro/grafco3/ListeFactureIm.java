package martioux.pro.grafco3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import martioux.pro.grafco3.proxy.ApiProxy1;
import martioux.pro.grafco3.restbeans.ObjetListefactureimpayee;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListeFactureIm extends AppCompatActivity {
    /*private ArrayList<ObjetListefactureimpayee> objetListefactureimpayee;
    private ApiProxy1 apiProxy1;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_liste_facture_im);
        listView= findViewById (R.id.lv_fact_impaye);
        objetListefactureimpayee=new ArrayList<> ();
        AfficheListeFactIm();
    }

    private void AfficheListeFactIm() {
        Retrofit retrofit= new Retrofit.Builder ()
                .baseUrl ("http://192.168.43.135:8081/")
                .addConverterFactory (GsonConverterFactory.create ())
                .build ();
        apiProxy1=retrofit.create (ApiProxy1.class);
        Call<ArrayList<ObjetListefactureimpayee>>arrayListCall=apiProxy1.callobjetListefactureimpayee ();
        arrayListCall.enqueue (new Callback<ArrayList<ObjetListefactureimpayee>> () {
            @Override
            public void onResponse(Call<ArrayList<ObjetListefactureimpayee>> call, Response<ArrayList<ObjetListefactureimpayee>> response) {
                objetListefactureimpayee=response.body();
                for (int i=0; i<objetListefactureimpayee.size (); i++){
                    Facture facture = new Facture(objetListefactureimpayee, ListeFactureIm.this,R.layout.fragment_facture_im_payee);
                    listView.setAdapter (facture);
                }

            }

            @Override
            public void onFailure(Call<ArrayList<ObjetListefactureimpayee>> call, Throwable t) {
                Toast.makeText (ListeFactureIm.this,"Erreur de connexion", Toast.LENGTH_SHORT).show ();

            }
        });

    }*/
}