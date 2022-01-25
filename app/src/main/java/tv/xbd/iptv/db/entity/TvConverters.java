package tv.xbd.iptv.db.entity;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import tv.xbd.iptv.model.TvChannel;


public class TvConverters {
    @TypeConverter
    public List<TvChannel> fromJsonString(String string) {
        Gson gson = new Gson();
        return gson.fromJson(string,
                new TypeToken<List<TvChannel>>() {
                }.getType());
    }

    @TypeConverter
    public String listTvChannelToString(List<TvChannel> list) {
        Gson gson = new Gson();
        return gson.toJson(list, new TypeToken<List<TvChannel>>() {
        }.getType());
    }

    @TypeConverter
    public List<String> fromString(String string) {
        Gson gson = new Gson();
        return gson.fromJson(string, new TypeToken<List<String>>() {
        }.getType());
    }

    @TypeConverter
    public String listStringToString(List<String> list) {
        Gson gson = new Gson();
        return gson.toJson(list, new TypeToken<List<String>>() {
        }.getType());
    }
}
