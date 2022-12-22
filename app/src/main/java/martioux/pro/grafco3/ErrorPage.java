package martioux.pro.grafco3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class ErrorPage extends AppCompatActivity {
 /*ProgressBar progres;
       EditText userText;
       Button b1;
       ImageView imageView;
       TextToSpeech t1;
       String userToSpeak;
        private final int REQUEST_CODE =200;
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_error_page);
        //progres=findViewById (R.id.progres);
        //progres.setVisibility (View.VISIBLE);

      /* userText = findViewById(R.id.userText);
        b1 = findViewById(R.id.button);
        imageView = findViewById(R.id.imageMic);

        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.FRANCE);
                }
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userToSpeak = userText.getText().toString();
                if (userToSpeak.equals("")){
                    Toast.makeText(getApplicationContext(), "Please enter your text",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), userToSpeak, Toast.LENGTH_SHORT).show();
                    t1.speak(userToSpeak, TextToSpeech.QUEUE_FLUSH, null);
                }
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Say something");

                try {
                    startActivityForResult(intent, REQUEST_CODE);
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Sorry! your device does not support speech input.", Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case REQUEST_CODE: {
                if (resultCode == RESULT_OK && null != data){
                    ArrayList<String> res = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    userText.setText(res.get(0));
                    Toast.makeText(getApplicationContext(), res.get(0), Toast.LENGTH_SHORT).show();
                    t1.speak(res.get(0), TextToSpeech.QUEUE_FLUSH, null);
                }
                break;
            }
        }

    }

    public void onDestroy() {
        // Don't forget to shutdown!
        if (t1 != null) {
            t1.stop();
            t1.shutdown();
        }
        super.onDestroy();*/
    }
    }
