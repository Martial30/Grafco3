package martioux.pro.grafco3;

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

import java.util.List;
import java.util.concurrent.TimeUnit;

import martioux.pro.grafco3.adapters1.AdapterListeClientCommercials;
import martioux.pro.grafco3.proxy.ApiProxy1;
import martioux.pro.grafco3.proxy.ApiProxy2;
import martioux.pro.grafco3.restbeans.ObjetListeClientCommercial;
import martioux.pro.grafco3.restbeans.ObjetListefactureimpayee;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListeClientCommercials#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListeClientCommercials extends Fragment {
           /* RecyclerView listeclientcommercial;
            ApiProxy2 apiProxy2;
            List<ObjetListeClientCommercial> objetListeClientCommercialList;
            AdapterListeClientCommercials adapterListeClientCommercials;*/

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListeClientCommercials() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListeClientCommercials.
     */
    // TODO: Rename and change types and number of parameters
    public static ListeClientCommercials newInstance(String param1, String param2) {
        ListeClientCommercials fragment = new ListeClientCommercials ();
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

    /*private void initProxyt(){
        OkHttpClient okHttpClient= new OkHttpClient.Builder ()
                .readTimeout(300, TimeUnit.SECONDS)
                .connectTimeout(300, TimeUnit.SECONDS)
                .build();

        apiProxy2= (ApiProxy2) new Retrofit.Builder()

                .baseUrl("http://192.168.1.144:8081/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create ())
                .build()
                .create(ApiProxy1.class);

        recupeListeClientCommercial();
    }

    private void recupeListeClientCommercial() {

        apiProxy2.calllisteclientcommercial ().enqueue (new Callback<List<ObjetListeClientCommercial>> () {
            @RequiresApi(api = Build.VERSION_CODES.N)

            @Override
            public void onResponse(Call<List<ObjetListeClientCommercial>> call, Response<List<ObjetListeClientCommercial>> response) {
                // Toast.makeText (getContext (), "Taille : "+response.body ().size (), Toast.LENGTH_SHORT).show ();
                response.body ().forEach (adapterListeClientCommercials::addElementlcc);
            }

            @Override
            public void onFailure(Call<List<ObjetListeClientCommercial>> call, Throwable t) {

            }
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated (view, savedInstanceState);

        adapterListeClientCommercials= new AdapterListeClientCommercials();
        listeclientcommercial = view.findViewById (R.id.listeclientcommercial);
        listeclientcommercial.setAdapter (adapterListeClientCommercials);
        initProxyt ();

    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate (R.layout.fragment_liste_client_commercials, container, false);
    }

}