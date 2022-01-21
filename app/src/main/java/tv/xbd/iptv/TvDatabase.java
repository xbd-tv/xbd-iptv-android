package tv.xbd.iptv;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import tv.xbd.iptv.dao.TvShowDao;
import tv.xbd.iptv.entity.TvConverters;
import tv.xbd.iptv.entity.TvShowEntity;

@Database(entities = {
        TvShowEntity.class
}, version = 1)
@TypeConverters({TvConverters.class})
public abstract class TvDatabase extends RoomDatabase {
    public static String DATABASE_NAME = "tv_show_db";

    private static TvDatabase mInstance;

    public abstract TvShowDao tvShowDao();

    public static synchronized TvDatabase getInstance(Context context) {
        if (mInstance == null) {
            mInstance = Room.databaseBuilder(context, TvDatabase.class, DATABASE_NAME)
                    .build();
        }
        return mInstance;
    }
}
