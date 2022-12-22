package martioux.pro.grafco3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Inscription extends AppCompatActivity {

    ImageView images;
    TextView bienvenues, africao;
    Animation animHaut, animBas;
    private static int duree=6000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        //Code pour plein écran
        getWindow ().setFlags (WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView (R.layout.activity_inscription);


        images=findViewById (R.id.imagesaccueil);
        bienvenues=findViewById (R.id.bienvenues);
        africao=findViewById (R.id.africaos);

        animHaut= AnimationUtils.loadAnimation (this,R.anim.animationhaut);
        animBas= AnimationUtils.loadAnimation (this,R.anim.animationbas);

        images.setAnimation (animHaut);
        bienvenues.setAnimation (animBas);
        africao.setAnimation (animBas);

        new Handler ().postDelayed (new Runnable () {
            @Override
            public void run() {
                Intent intent= new Intent (getApplicationContext (), MainActivity.class);
                startActivity (intent);
            }
        }, duree);
        //edi_login=findViewById (R.id.edi_login);
       // edi_mdp=findViewById (R.id.edi_mdp);
       // btn_inscription=findViewById (R.id.btn_inscription);
        //connecter=findViewById (R.id.connecter);

        /*btn_inscription.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                String login, mdp_mobile;

                login= edi_login.getText ().toString ();
                mdp_mobile=edi_mdp.getText ().toString ();

                if (login.equals ("") && mdp_mobile.equals ("")){
                    Toast.makeText (getApplicationContext (),"Veuillez remplir les champs S.V.P", Toast.LENGTH_SHORT).show ();
                }else {
                    AjoutDesDonnee(login, mdp_mobile);
                    Toast.makeText (getApplicationContext (), "Inscription effectuée avec succès", Toast.LENGTH_SHORT ).show ();
                    Intent ouvreMenu= new Intent (getApplicationContext (), MainActivity.class);
                    startActivity (ouvreMenu);
                }
            }
        });

    }*/

   /* private void AjoutDesDonnee(String login, String mdp_mobile){
        String url = "http://192.168.1.19/Mobile/enregistrer.php";

        RequestQueue queue = Volley.newRequestQueue(Inscription.this);

        StringRequest request = new StringRequest(Request.Method.POST, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("TAG", "RESPONSE IS " + response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    // on below line we are displaying a success toast message.
                    Toast.makeText(Inscription.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                // and setting data to edit text as empty
                edi_login.setText("");
               edi_mdp.setText("");

            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // method to handle errors.
                Toast.makeText(Inscription.this, "Fail to get response = " + error, Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            public String getBodyContentType() {
                // as we are passing data in the form of url encoded
                // so we are passing the content type below
                return "application/x-www-form-urlencoded; charset=UTF-8";
            }

            @Override
            protected Map<String, String> getParams() {

                // below line we are creating a map for storing
                // our values in key and value pair.
                Map<String, String> params = new HashMap<String, String> ();

                // on below line we are passing our
                // key and value pair to our parameters.
                params.put("login", login);
                params.put("mdp_mobile", mdp_mobile);


                // at last we are returning our params.
                return params;
            }
        };
        // below line is to make
        // a json object request.
        queue.add(request);*/
    }
}
