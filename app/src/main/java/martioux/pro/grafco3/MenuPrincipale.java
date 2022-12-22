package martioux.pro.grafco3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MenuPrincipale extends AppCompatActivity  {

        ImageView userimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_menu_principale);

        userimg=findViewById (R.id.userimg);
        userimg.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent (getApplicationContext (), Facture_Imapyee.class);
                startActivity (intent);
            }
        });


    }
}