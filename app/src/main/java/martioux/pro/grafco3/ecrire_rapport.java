package martioux.pro.grafco3;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import martioux.pro.grafco3.model.Commercial;
import martioux.pro.grafco3.model.Rapport;
import martioux.pro.grafco3.proxy.ApiProxy1;
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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ecrire_rapport#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ecrire_rapport extends Fragment {
    LinearLayout fermer;
    TextView heurerapport, date_rapport;
    TextInputEditText  textrapport;
    Button btnenvoyerrapport;
    ApiProxy2 apiProxy2;
    int idRapport=0;
    ObjetEcrireRapport objetEcrireRapport;
    OpenApplication app;
    RapportRepository rapportRepository;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ecrire_rapport() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ecrire_rapport.
     */
    // TODO: Rename and change types and number of parameters
    public static ecrire_rapport newInstance(String param1, String param2) {

        ecrire_rapport fragment = new ecrire_rapport ();
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
        return inflater.inflate (R.layout.fragment_ecrire_rapport, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated (view, savedInstanceState);

        textrapport = view.findViewById (R.id.textrapport);
        btnenvoyerrapport = view.findViewById (R.id.btnenvoyerrapport);
        fermer = view.findViewById (R.id.fermer);

        app = (OpenApplication) getActivity ().getApplication ();
        rapportRepository= new RapportRepository (getActivity ().getApplication ());

        btnenvoyerrapport.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                if (textrapport.getText ().toString ().isEmpty ()) {
                    Snackbar snackbar = Snackbar.make (fermer, "Veuillez remplir les champs de saisie S.V.P !", Snackbar.LENGTH_LONG)
                            .setAction ("Fermer", new View.OnClickListener () {
                                @Override
                                public void onClick(View view) {
                                    Snackbar snackbar1 = Snackbar.make (fermer, "done", Snackbar.LENGTH_LONG);
                                    snackbar1.show ();
                                }
                            });
                    snackbar.setBackgroundTint (getResources ().getColor (R.color.snak_color_wrong));
                    snackbar.show ();
                } else {

                    initProxyt ();
                    Snackbar snackbar = Snackbar.make (fermer, "Rapport enregistré avec succès", Snackbar.LENGTH_LONG)
                            .setAction ("Ok", new View.OnClickListener () {
                                @Override
                                public void onClick(View view) {
                                    Snackbar snackbar1 = Snackbar.make (fermer, "done", Snackbar.LENGTH_LONG);
                                    snackbar1.show ();
                                }
                            });
                    snackbar.setBackgroundTint (getResources ().getColor (R.color.snak_color_success));
                    snackbar.show ();

                }
            }
        });
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
            ot.setIdrapport (0);
            ot.setTexterapport (textrapport.getText ().toString ());
            Commercial cl= app.getDb ().commercialDao ().getAll ().get (0);

            ot.setCode (cl.getComid ());

            apiProxy2.callfairerapport (ot).enqueue (new Callback<Quete> () {
                @RequiresApi (api = Build.VERSION_CODES.N)
                @Override
                public void onResponse(Call<Quete> call, Response<Quete> response) {
                    // response.body ().forEach (objetEcrireRapport ->);
                    Rapport rapport= rapportRepository.getRapport (response.body ().getIdent ());
                    if (rapport==null) rapport= new Rapport ();
                    rapport.setIdraps (response.body ().getIdent ());
                    rapport.setCode (cl.getComid ());
                    rapport.setTexterapport (textrapport.getText ().toString ());
                    rapportRepository.insert (rapport);
                    Toast.makeText (getContext (), "Rapport sauvegrdé !", Toast.LENGTH_SHORT);
                }

                @Override
                public void onFailure(Call<Quete> call, Throwable t) {
                    //Toast.makeText (ecrire_rapport.this, "Une erreur a due se produire", Toast.LENGTH_SHORT);
                }
            });

    }

}