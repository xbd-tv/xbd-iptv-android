package tv.xbd.iptv.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tv.xbd.iptv.db.TvShowRepository;
import tv.xbd.iptv.db.entity.TvShowEntity;

public class TvShowViewModel extends AndroidViewModel {
    private final TvShowRepository repository;
    public LiveData<List<TvShowEntity>> showList;

    public TvShowViewModel(@NonNull Application application) {
        super(application);
        repository = new TvShowRepository(application);
        showList = repository.getAllLive();
    }

    public Map<String, List<TvShowEntity>> getGenreMapTvShowList() {
        return tvShowListToGenreMap(repository.getAll());
    }

    private Map<String, List<TvShowEntity>> tvShowListToGenreMap(List<TvShowEntity> tvShowList) {
        Map<String, List<TvShowEntity>> map = new HashMap<>();
        for (TvShowEntity item : tvShowList) {
            if (item.getGenre() != null) {
                for (final String genre : item.getGenre()) {
                    if (map.containsKey(genre)) {
                        if (map.get(genre) != null) {
                            map.get(genre).add(item);
                        }
                    } else {
                        List<TvShowEntity> list = new ArrayList<>();
                        list.add(item);
                        map.put(genre, list);
                    }
                }
            }
        }
        return map;
    }
}
