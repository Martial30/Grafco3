package martioux.pro.grafco3;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Accueils#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Accueils extends Fragment {
    ImageView userimgs;
    /*TextView profile, commercial, rapport, listerapport, audio, listevocal,facturep, factureip ;

    ImageView userimgs, teamworkimg, rapportimg, searchimg, audioimg, vocalimg,  facturepimg, factureipimg;
    TextView profile, commercial, rapport, listerapport, audio, listevocal,facturep, factureip ;*/
    ScrollView scrollView;




    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Accueils() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Accueils.
     */
    // TODO: Rename and change types and number of parameters
    public static Accueils newInstance(String param1, String param2) {
        Accueils fragment = new Accueils ();
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

          View in=inflater.inflate (R.layout.fragment_accueils, container, false);

       /* userimgs.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {


            ProfileFragment profileFragment = new ProfileFragment ();
               FragmentTransaction fragmentTransaction=getParentFragmentManager ()
                       .beginTransaction();
                        fragmentTransaction.replace (R.id.scrollView,profileFragment);
                        fragmentTransaction.commit ();
                   }

        });
*/


        return in;
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated (view, savedInstanceState);


       /* userimg = view.findViewById (R.id.userimg);
        teamworkimg = view.findViewById (R.id.teamworkimg);
        rapportimg = view.findViewById (R.id.rapportimg);
        searchimg = view.findViewById (R.id.searchimg);
        audioimg = view.findViewById (R.id.audioimg);
        vocalimg = view.findViewById (R.id.vocalimg);
        facturepimg = view.findViewById (R.id.facturepimg);
        factureipimg = view.findViewById (R.id.factureipimg);
        profile = view.findViewById (R.id.profile);
        commercial = view.findViewById (R.id.commercial);
        rapport = view.findViewById (R.id.rapport);
        listerapport = view.findViewById (R.id.listerapport);
        audio = view.findViewById (R.id.audio);
        listevocal = view.findViewById (R.id.listevocal);
        facturep = view.findViewById (R.id.facturep);
        factureip = view.findViewById (R.id.factureip);


        userimg.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent in = new Intent (getContext (),
                        ProfileFragment.class);
                startActivity (in);
            }
        });
        profile.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (getContext (),ProfileFragment.class);
                startActivity (i);
            }
        });*/



      /*  teamworkimg.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (getContext (),GestionCommercialFragment.class);
                startActivity (i);
            }
        });
        commercial.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (getContext (),GestionCommercialFragment.class);
                startActivity (i);
            }
        });
        rapportimg.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (getContext (),ecrire_rapport.class);
                startActivity (i);
            }
        });
        rapport.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (getContext (),ecrire_rapport.class);
                startActivity (i);
            }
        });
        searchimg.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (getContext (),FacturePayeeFragment.class);
                startActivity (i);
            }
        });
        listerapport.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (getContext (),FacturePayeeFragment.class);
                startActivity (i);
            }
        });
        audioimg.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (getContext (),vocal_rapport.class);
                startActivity (i);
            }
        });
        audio.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (getContext (),vocal_rapport.class);
                startActivity (i);
            }
        });
        vocalimg.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (getContext (),voir_vocal_rapport.class);
                startActivity (i);
            }
        });
        listevocal.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (getContext (),voir_vocal_rapport.class);
                startActivity (i);
            }
        });
        facturepimg.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (getContext (),FacturePayeeFragment.class);
                startActivity (i);
            }
        });
        facturep.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (getContext (),FacturePayeeFragment.class);
                startActivity (i);
            }
        });
        factureipimg.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (getContext (),Facture_Imapyee.class);
                startActivity (i);
            }
        });
        factureip.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (getContext (),Facture_Imapyee.class);
                startActivity (i);
            }
        }); */

    }
}