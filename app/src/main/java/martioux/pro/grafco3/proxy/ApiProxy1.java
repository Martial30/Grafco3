package martioux.pro.grafco3.proxy;

import java.util.ArrayList;
import java.util.List;

import martioux.pro.grafco3.restbeans.ObjetCommerciallierClient;
import martioux.pro.grafco3.restbeans.ObjetListeRapNomUser;
import martioux.pro.grafco3.restbeans.ObjetListeRapport;
import martioux.pro.grafco3.restbeans.ObjetListefactureimpayee;
import martioux.pro.grafco3.restbeans.Quete;
import martioux.pro.grafco3.restbeans.Quetes;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiProxy1 {
    @GET("gestion/obtenirfactureimpayee ")
    Call<List<ObjetListefactureimpayee>> callobjetListefactureimpayee();

    @GET("obtenirlisterapportusernom")
    Call<List<ObjetListeRapNomUser>> callobjetlisterapportusernom(
            @Body Quetes quetes);

    @POST("gestion/obtenirCommercialarapport")
    Call<List<ObjetListeRapport>> callObjetListeRapport(
            @Body Quetes quetes
    );
}
