package tv.xbd.iptv.db;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import retrofit2.Response;
import tv.xbd.iptv.api.ChannelService;
import tv.xbd.iptv.api.RetrofitClient;
import tv.xbd.iptv.db.dao.TvShowDao;
import tv.xbd.iptv.db.entity.TvShowEntity;

public class TvShowRepository {
    public static String TAG = TvShowEntity.class.getSimpleName();
    private final TvShowDao dao;
    private final ChannelService channelService;

    public TvShowRepository(Context context) {
        this.dao = TvDatabase.getInstance(context).tvShowDao();
        this.channelService = RetrofitClient.getInstance(context).channelService;
    }

    public List<TvShowEntity> getAll() {
        try {
            return new AllTask(dao).execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public LiveData<List<TvShowEntity>> getAllLive() {
        try {
            return new AllLiveTask(dao).execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveList(TvShowEntity... list) {
        new SaveTask(dao).execute(list);
    }

    static class SaveTask extends AsyncTask<TvShowEntity, Void, Void> {
        TvShowDao dao;

        public SaveTask(TvShowDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(TvShowEntity... tvShowEntities) {
            dao.save(tvShowEntities);
            return null;
        }
    }

    class AllTask extends AsyncTask<Void, Void, List<TvShowEntity>> {

        TvShowDao dao;

        public AllTask(TvShowDao dao) {
            this.dao = dao;
        }

        @Override
        protected List<TvShowEntity> doInBackground(Void... voids) {
            List<TvShowEntity> list = dao.queryAll();
            if (list == null || list.size() < 1) {
                try {
                    Response<List<TvShowEntity>> response = channelService.cnList().execute();
                    if (response.isSuccessful() && response.body() != null) {
                        saveList(response.body().toArray(new TvShowEntity[0]));
                        list = dao.queryAll();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return list;
        }
    }

    static class AllLiveTask extends AsyncTask<Void, Void, LiveData<List<TvShowEntity>>> {
        TvShowDao dao;

        public AllLiveTask(TvShowDao dao) {
            this.dao = dao;
        }

        @Override
        protected LiveData<List<TvShowEntity>> doInBackground(Void... voids) {
            return dao.queryAllLive();
        }
    }
}
