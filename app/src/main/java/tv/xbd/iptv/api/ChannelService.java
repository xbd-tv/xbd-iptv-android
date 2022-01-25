package tv.xbd.iptv.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import tv.xbd.iptv.db.entity.TvShowEntity;

public interface ChannelService {
    // https://cdn.jsdelivr.net/gh/xbd-tv/xbd-iptv@main/channels/cn.json
    @GET("channels/cn.json")
    Call<List<TvShowEntity>> cnList();
}
