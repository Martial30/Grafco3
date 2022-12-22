package martioux.pro.grafco3.repository;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import martioux.pro.grafco3.OpenApplication;
import martioux.pro.grafco3.database.CommercialDao;
import martioux.pro.grafco3.database.DbPool;
import martioux.pro.grafco3.database.RapportDao;
import martioux.pro.grafco3.model.Commercial;
import martioux.pro.grafco3.model.Rapport;

public class RapportRepository {


    RapportDao rapportDao;
    OpenApplication app;

    public RapportRepository(Application application) {
        this.app=(OpenApplication) application;
        rapportDao=app.getDb ().rapportDao ();
    }

    public List<Rapport> getAll(){
        List<Rapport> data = new ArrayList<> ();
        data = rapportDao.getAll ();
        return data;
    }

    public Rapport getRapport(int idrapportx){
        return rapportDao.getOne (idrapportx);
    }

    // insérer :
    public void insert(Rapport... rapports){
        insert(null, rapports);
    }

    // appel :
    void insert(Runnable completion, Rapport... rapports){
        DbPool.post(()->{
            for(Rapport rp : rapports){
                rapportDao.insert(rp);
            }
        });
    }
}
