package martioux.pro.grafco3.repository;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import martioux.pro.grafco3.OpenApplication;
import martioux.pro.grafco3.database.CommercialDao;
import martioux.pro.grafco3.database.DbPool;
import martioux.pro.grafco3.model.Commercial;

public class CommercialRepository {

    CommercialDao commercialDao;
    OpenApplication app;

    public CommercialRepository(Application application) {
        this.app=(OpenApplication) application;
        commercialDao=app.getDb ().commercialDao ();
    }

    public List<Commercial> checkcommercial(){
        List<Commercial> data = new ArrayList<> ();
        data = commercialDao.getAll ();
        return data;
    }

    public Commercial getCommercial(int idcom){
        return commercialDao.getOne (idcom);
    }

    // insérer :
    public void insert(Commercial... commercials){
        insert(null, commercials);
    }

    // appel :
    void insert(Runnable completion, Commercial... commercials){
        DbPool.post(()->{
            for(Commercial cl : commercials){
                commercialDao.insert(cl);
            }
        });
    }
}
