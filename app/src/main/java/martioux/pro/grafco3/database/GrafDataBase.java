package martioux.pro.grafco3.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import martioux.pro.grafco3.model.Commercial;
import martioux.pro.grafco3.model.Rapport;

@Database (entities = {Commercial.class, Rapport.class},
    version = 1, exportSchema = true)
public abstract class GrafDataBase extends RoomDatabase {

  private static volatile GrafDataBase instance;

  // Dao
  public abstract CommercialDao commercialDao();
  public abstract RapportDao rapportDao();


  public synchronized static GrafDataBase getInstance(Context context){
      if (instance==null){
          instance=  Room.databaseBuilder (context.getApplicationContext (),
                  GrafDataBase.class, "grafcom.db").
                  allowMainThreadQueries ()
                  .build ();
      }
      return instance;
  }

}
