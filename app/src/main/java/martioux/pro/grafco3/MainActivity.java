package martioux.pro.grafco3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import martioux.pro.grafco3.model.Commercial;

public class MainActivity extends AppCompatActivity {
 TextView deconnexion, nomEtPrenom, email;
 ImageView imageProfile;
 OpenApplication app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        app = (OpenApplication)getApplication ();

        deconnexion=findViewById (R.id.deconnexion);
        nomEtPrenom=findViewById (R.id.nomEtPrenom);
        email=findViewById (R.id.email);
        imageProfile=findViewById (R.id.imageProfile);

        final DrawerLayout drawLayout = findViewById (R.id.drawLayout);

        NavigationView navigationView =
                (NavigationView)findViewById (R.id.navigatioView);
        View headerView = navigationView.getHeaderView (0);
        TextView nomprenom = (TextView)headerView.findViewById (R.id.nomEtPrenom);
        TextView mail= (TextView)headerView.findViewById (R.id.email);
        Commercial cl= app.getDb ().commercialDao ().getAll ().get (0);
        nomprenom.setText (cl.getNomusers ()+" "+ cl.getPrenomusers ());
        mail.setText (cl.getEmailusers ());
        findViewById (R.id.imageMenu).setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                drawLayout.openDrawer (GravityCompat.START);
            }
        });

        //NavigationView navigationView= findViewById (R.id.navigatioView);
        navigationView.setItemIconTintList (null);

        NavController navController= Navigation.findNavController (this, R.id.navHostFragment);
        NavigationUI.setupWithNavController (navigationView,navController);

        final TextView texTitle= findViewById (R.id.textTitle);
        navController.addOnDestinationChangedListener (new NavController.OnDestinationChangedListener () {
            @Override
            public void onDestinationChanged(@NonNull NavController navController, @NonNull NavDestination navDestination, @Nullable Bundle bundle) {
                texTitle.setText (navDestination.getLabel ());
            }
        });

    }
}