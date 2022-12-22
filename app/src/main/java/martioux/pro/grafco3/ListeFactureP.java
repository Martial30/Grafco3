package martioux.pro.grafco3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

import martioux.pro.grafco3.proxy.ApiProxy2;
import martioux.pro.grafco3.restbeans.ObjetListefacturepayee;

public class ListeFactureP extends AppCompatActivity {
    private ArrayList<ObjetListefacturepayee> objetListefacturepayee;
    private ApiProxy2 apiProxy2;
    private String BaseUrl="http://localhost:8081";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_liste_facture_p);
    }
}