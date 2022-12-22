package martioux.pro.grafco3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import java.util.concurrent.TimeUnit;

import martioux.pro.grafco3.adapters1.AdapterListeClientCommercials;
import martioux.pro.grafco3.adapters1.AdapterListeFactureImpayee;
import martioux.pro.grafco3.proxy.ApiProxy1;
import martioux.pro.grafco3.proxy.ApiProxy2;
import martioux.pro.grafco3.restbeans.ObjetListeClientCommercial;
import martioux.pro.grafco3.restbeans.Quete;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListClientCommercial extends AppCompatActivity {

    RecyclerView listeclientcommerciales;
    ApiProxy2 apiProxy2;
    List<ObjetListeClientCommercial> objetListeClientCommercialList;
    int idcommercial= 0;
    AdapterListeClientCommercials adapterListeClientCommercials;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_list_client_commercial);
        adapterListeClientCommercials= new AdapterListeClientCommercials ();
        listeclientcommerciales =findViewById (R.id.listeclientcommerciale);
        listeclientcommerciales.setAdapter (adapterListeClientCommercials);

        //
        Bundle extras = getIntent ().getExtras ();
        if(extras != null){
            idcommercial = extras.getInt ("idcom");
        }

        initProxyt ();
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

        Quete quete= new Quete ();
        quete.setIdent (idcommercial);
        recupeListeClientCommercial(quete);
    }

    private void recupeListeClientCommercial(Quete quete) {

        apiProxy2.calllisteclientcommercial (quete).enqueue (new Callback<List<ObjetListeClientCommercial>> () {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<List<ObjetListeClientCommercial>> call, Response<List<ObjetListeClientCommercial>> response) {
               response.body().forEach(adapterListeClientCommercials::addElementlcc);
            }

            @Override
            public void onFailure(Call<List<ObjetListeClientCommercial>> call, Throwable t) {

            }
        });


    }


}