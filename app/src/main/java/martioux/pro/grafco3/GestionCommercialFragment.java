package martioux.pro.grafco3;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import martioux.pro.grafco3.proxy.ApiProxy1;
import martioux.pro.grafco3.proxy.ApiProxy2;
import martioux.pro.grafco3.restbeans.ObjetCommerciallierClient;
import martioux.pro.grafco3.restbeans.ObjetListeClientCommercial;
import martioux.pro.grafco3.restbeans.ObjetListeCommerciaux;
import martioux.pro.grafco3.restbeans.ObjetListefacturepayee;
import martioux.pro.grafco3.restbeans.Quete;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GestionCommercialFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GestionCommercialFragment extends Fragment {
    ApiProxy2 apiProxy2;
    AutoCompleteTextView commercialautocomp;
    int i_commercial = 0;
    Button btsearcclient;
    String[] nomCommerciaux;
    List<ObjetListeCommerciaux> listeCommerciaux;
    List<ObjetListeClientCommercial> objetListeClientCommercialList;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GestionCommercialFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CollectionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GestionCommercialFragment newInstance(String param1, String param2) {
        GestionCommercialFragment fragment = new GestionCommercialFragment ();
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

    private void initproyxs(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(300, TimeUnit.SECONDS)
                .connectTimeout(300, TimeUnit.SECONDS)
                .build();

        apiProxy2 = (ApiProxy2) new Retrofit.Builder()
                .baseUrl("http://192.168.1.18:8081/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiProxy2.class);

       recupeCommerciaux ();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate (R.layout.fragment_gestion_commercial, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {


        commercialautocomp = view.findViewById (R.id.commercialautocomp);
        btsearcclient = view.findViewById (R.id.btsearcclient);
        btsearcclient.setOnClickListener (new View.OnClickListener () {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                String commercial = nomCommerciaux[i_commercial];
                int idCommercial = listeCommerciaux.stream()
                        .filter(donnee -> (donnee.getFirstname ()+" "+
                                donnee.getLastname ()).equals(commercial))
                        .map(donnee -> donnee.getId ()).collect(Collectors.toList()).get(0);

                Quete quete= new Quete ();
                quete.setIdent (idCommercial);
                recupeClient (quete);

            }
        });
        initproyxs();
    }

    void recupeCommerciaux(){
        apiProxy2.callobjetlistecommerciaux ().enqueue(new Callback<List<ObjetListeCommerciaux>> () {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<List<ObjetListeCommerciaux>> call, Response<List<ObjetListeCommerciaux>> response) {
                //response.body ().forEach (adapterFacturePayee::addElement);

                nomCommerciaux = new String[response.body ().size ()];
                ArrayAdapter adapterFrais = null;
                if(response.body().size() > 0){

                    listeCommerciaux = response.body();

                    nomCommerciaux = listeCommerciaux.stream().map(
                            donnee -> (donnee.getFirstname ()+" "+
                                    donnee.getLastname ())).toArray(String[]::new);
                    adapterFrais = new ArrayAdapter(getContext (),android.R.layout.simple_list_item_1,
                            nomCommerciaux);
                    commercialautocomp.setAdapter(adapterFrais);
                    commercialautocomp.setText(adapterFrais.getItem(0).toString(), false);
                    commercialautocomp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            i_commercial = position;
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<List<ObjetListeCommerciaux>> call, Throwable t) {
            }
        });
    }

    void recupeClient(Quete quete){
        apiProxy2.callCommerciallierClient (quete).enqueue(new Callback<List<ObjetCommerciallierClient>> () {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<List<ObjetCommerciallierClient>> call, Response<List<ObjetCommerciallierClient>> response) {
                //response.body ().forEach (adapterFacturePayee::addElement);

                if(response.body().size()>0){
                    Intent intent = new Intent (getContext (), ListClientCommercial.class);
                    intent.putExtra ("idcom",quete.getIdent ());
                    startActivity (intent);
                }
                else{
                    Intent intent = new Intent (getContext (), ecrire_rapport.class);
                    startActivity (intent);
                    /*Toast.makeText(getContext (),
                            "Aucun client pour ce commercial !",
                            Toast.LENGTH_LONG).show();*/
                }
            }

            @Override
            public void onFailure(Call<List<ObjetCommerciallierClient>> call, Throwable t) {
            }
        });
    }
}