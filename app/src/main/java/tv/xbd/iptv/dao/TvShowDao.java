package tv.xbd.iptv.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import tv.xbd.iptv.entity.TvShowEntity;

@Dao
public interface TvShowDao {

    @Query("SELECT * FROM tv_show")
    List<TvShowEntity> queryAll();

    @Query("SELECT * FROM tv_show")
    LiveData<List<TvShowEntity>> queryAllLive();

    @Insert
    void save(TvShowEntity... tvShowEntities);
}