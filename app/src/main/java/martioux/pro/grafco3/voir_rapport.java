package martioux.pro.grafco3;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import martioux.pro.grafco3.adapters1.AdaptaterListeRapport;
import martioux.pro.grafco3.adapters1.AdapterListeFactureImpayee;
import martioux.pro.grafco3.adapters1.AdapterListeRapUserNom;
import martioux.pro.grafco3.model.Commercial;
import martioux.pro.grafco3.proxy.ApiProxy1;
import martioux.pro.grafco3.restbeans.ObjetListeRapNomUser;
import martioux.pro.grafco3.restbeans.ObjetListeRapport;
import martioux.pro.grafco3.restbeans.Quetes;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link voir_rapport#newInstance} factory method to
 * create an instance of this fragment.
 */
public class voir_rapport extends Fragment {
    RecyclerView listedesrapport;
    ObjetListeRapport objetListeRapport;
    ObjetListeRapNomUser objetListeRapNomUser;
    ApiProxy1 apiProxy1;
    AdaptaterListeRapport adaptaterListeRapport;
    AdapterListeRapUserNom adapterListeRapUserNom;
    OpenApplication app;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public voir_rapport() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment voir_rapport.
     */
    // TODO: Rename and change types and number of parameters
    public static voir_rapport newInstance(String param1, String param2) {
        voir_rapport fragment = new voir_rapport ();
        Bundle args = new Bundle ();
        args.putString (ARG_PARAM1, param1);
        args.putString (ARG_PARAM2, param2);
        fragment.setArguments (args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        if (getArguments () != null) {
            mParam1 = getArguments ().getString (ARG_PARAM1);
            mParam2 = getArguments ().getString (ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate (R.layout.fragment_voir_rapport, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated (view, savedInstanceState);

        app = (OpenApplication) getActivity ().getApplication ();
        adapterListeRapUserNom= new AdapterListeRapUserNom (getContext ());
        listedesrapport = view.findViewById (R.id.listedesrapport);
        listedesrapport.setAdapter (adapterListeRapUserNom);
        initProxyt ();
    }


    private void initProxyt(){
        OkHttpClient okHttpClient= new OkHttpClient.Builder ()
                .readTimeout(300, TimeUnit.SECONDS)
                .connectTimeout(300, TimeUnit.SECONDS)
                .build();

        apiProxy1= (ApiProxy1) new Retrofit.Builder()

                .baseUrl("http://192.168.1.18:8081/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create ())
                .build()
                .create(ApiProxy1.class);

        recupeFactureImpaye();
    }

    //Quetes quetes;
     void recupeFactureImpaye() {

         Commercial cl= app.getDb ().commercialDao ().getAll ().get (0);
         Quetes quetes= new Quetes ();
         quetes.setIdlistrapport (cl.getComid ());
        apiProxy1.callobjetlisterapportusernom (quetes).enqueue (new Callback<List<ObjetListeRapNomUser>> () {

            @RequiresApi (api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<List<ObjetListeRapNomUser>> call, Response<List<ObjetListeRapNomUser>> response) {
                response.body ().forEach (adapterListeRapUserNom::AjouterUnElement);
            }



            @Override
            public void onFailure(Call<List<ObjetListeRapNomUser>> call, Throwable t) {
                Toast.makeText (getContext (), "Err : "+t.toString (), Toast.LENGTH_LONG).show ();
            }
        });
    }


}