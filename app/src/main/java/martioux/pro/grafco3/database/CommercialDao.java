package martioux.pro.grafco3.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import martioux.pro.grafco3.model.Commercial;

@Dao
public interface CommercialDao {

    @Query("SELECT * FROM Commercial")
    LiveData<List<Commercial>> getLiveAll();

    @Query("SELECT * FROM Commercial order by comid desc")
    List<Commercial> getAll();

    @Query("SELECT * FROM Commercial where comid = :idcom")
    Commercial getOne(int idcom);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Commercial... commercials);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Commercial commercial);


}
