package martioux.pro.grafco3;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link vocal_rapport#newInstance} factory method to
 * create an instance of this fragment.
 */
public class vocal_rapport extends Fragment {

                EditText message_vocal;
                ImageView micro;
                TextToSpeech audio;
                String userToSpeak;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public vocal_rapport() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment vocal_rapport.
     */
    // TODO: Rename and change types and number of parameters
    public static vocal_rapport newInstance(String param1, String param2) {

        vocal_rapport fragment = new vocal_rapport ();
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

        View root= inflater.inflate (R.layout.fragment_vocal_rapport, container, false);

        message_vocal= root.findViewById (R.id.message_vocal);
        micro= root.findViewById (R.id.micro);

        audio= new TextToSpeech (getContext (), new TextToSpeech.OnInitListener () {
            @Override
            public void onInit(int i) {
                        if (i != TextToSpeech.ERROR){
                            audio.setLanguage (Locale.FRANCE);
                        }
            }
        });

        micro.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                String parler= message_vocal.getText ().toString ();
                Toast.makeText (getContext (), parler, Toast.LENGTH_SHORT).show ();
                audio.speak (parler,TextToSpeech.QUEUE_FLUSH,null );
            }
        });

        return root;
    }

    public void onPause() {
        if (audio != null){
            audio.stop ();
            audio.shutdown ();
        }
        super.onPause ();
    }

}