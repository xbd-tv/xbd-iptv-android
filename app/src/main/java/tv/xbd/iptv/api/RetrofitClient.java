package tv.xbd.iptv.api;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static RetrofitClient mInstance;

    public ChannelService channelService;

    public RetrofitClient(Context context) {
        Retrofit retrofit = new Retrofit.Builder()
                // TODO 放置到设置中
                .baseUrl("https://cdn.jsdelivr.net/gh/xbd-tv/xbd-iptv@main/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        channelService = retrofit.create(ChannelService.class);
    }

    public synchronized static RetrofitClient getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new RetrofitClient(context);
        }
        return mInstance;
    }
}
