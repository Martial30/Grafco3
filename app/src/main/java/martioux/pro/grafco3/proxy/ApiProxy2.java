package martioux.pro.grafco3.proxy;

import java.util.ArrayList;
import java.util.List;

import martioux.pro.grafco3.restbeans.ObjetCommerciallierClient;
import martioux.pro.grafco3.restbeans.ObjetEcrireRapport;
import martioux.pro.grafco3.restbeans.ObjetListeClientCommercial;
import martioux.pro.grafco3.restbeans.ObjetListeCommerciaux;
import martioux.pro.grafco3.restbeans.ObjetListefacturepayee;
import martioux.pro.grafco3.restbeans.Quete;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiProxy2 {
   @GET("gestion/obtenirfacturepayee")
    Call<List<ObjetListefacturepayee>> callobjetListefacturepayee();

    @GET("gestion/obtenirlistecommerciaux")
    Call<List<ObjetListeCommerciaux>> callobjetlistecommerciaux();


    @POST("gestion/obtenircommerciallieraclient")
    Call<List<ObjetCommerciallierClient>> callCommerciallierClient(
            @Body Quete quete
            );

    @POST("gestion/obtenirlisteclientcommerciaux")
    Call<List<ObjetListeClientCommercial>> calllisteclientcommercial(@Body Quete quete);

    @POST("gestion/faireunrapport")
    Call<Quete> callfairerapport(@Body ObjetEcrireRapport objetEcrireRapport);

}
