package martioux.pro.grafco3;

import androidx.multidex.MultiDexApplication;

import martioux.pro.grafco3.database.GrafDataBase;

public class OpenApplication extends MultiDexApplication {

    GrafDataBase db;

    @Override
    public void onCreate(){
        super.onCreate ();
        db=GrafDataBase.getInstance (this);
    }

    public GrafDataBase getDb(){
        return db;
    }
}
