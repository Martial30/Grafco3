package martioux.pro.grafco3;

import android.content.Intent;
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
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import martioux.pro.grafco3.adapters.AdapterFacturePayee;
import martioux.pro.grafco3.proxy.ApiProxy;
import martioux.pro.grafco3.proxy.ApiProxy2;
import martioux.pro.grafco3.restbeans.ObjetConnexion;
import martioux.pro.grafco3.restbeans.ObjetListefacturepayee;
import martioux.pro.grafco3.restbeans.Users;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FacturePayeeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FacturePayeeFragment extends Fragment {

    //ListView lv_fact_pay;
    RecyclerView listefacturepayee;
    ApiProxy2 apiProxy2;
    List<ObjetListefacturepayee> objetListefacturepayeeList;
    AdapterFacturePayee adapterFacturePayee;
    // ArrayList<ObjetListefacturepayee> objetListefacturepayeeArrayList;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FacturePayeeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FacturePayeeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FacturePayeeFragment newInstance(String param1, String param2) {
        FacturePayeeFragment fragment = new FacturePayeeFragment ();
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
        //return inflater.inflate (R.layout.fragment_facture_payee, container, false);
        super.onCreateView(inflater, container, savedInstanceState);
        View koi= inflater.inflate (R.layout.fragment_facture_payee, container, false);
        return koi;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated (view, savedInstanceState);

        adapterFacturePayee= new AdapterFacturePayee ();
        listefacturepayee= view.findViewById (R.id.listefacturepayee);
        listefacturepayee.setAdapter (adapterFacturePayee);
        initproyxs();

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

        //
        recupeFacture();
    }


    void recupeFacture(){
        apiProxy2.callobjetListefacturepayee ().enqueue(new Callback<List<ObjetListefacturepayee>> () {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<List<ObjetListefacturepayee>> call, Response<List<ObjetListefacturepayee>> response) {
                response.body ().forEach (adapterFacturePayee::addElement);
            }

            @Override
            public void onFailure(Call<List<ObjetListefacturepayee>> call, Throwable t) {
            }
        });
    }


}