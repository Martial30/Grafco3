package martioux.pro.grafco3.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import martioux.pro.grafco3.model.Rapport;


@Dao
public interface RapportDao {

    @Query("SELECT * FROM Rapport")
    LiveData<List<Rapport>> getLiveAll();

    @Query("SELECT * FROM Rapport order by idraps desc")
    List<Rapport> getAll();

    @Query("SELECT * FROM Rapport where idraps = :idraps")
    Rapport getOne(int idraps);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Rapport... rapports);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Rapport rapport);


}
