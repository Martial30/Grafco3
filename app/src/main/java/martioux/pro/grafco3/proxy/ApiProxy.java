package martioux.pro.grafco3.proxy;

import java.util.ArrayList;

import martioux.pro.grafco3.restbeans.ObjetConnexion;
import martioux.pro.grafco3.restbeans.ObjetListefactureimpayee;
import martioux.pro.grafco3.restbeans.Users;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiProxy {
    @POST("gestion/connexion")
    Call<Users> connexion(@Body ObjetConnexion objetConnexion);
}

/*Salut*/
