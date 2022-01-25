package tv.xbd.iptv.db.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.List;

import tv.xbd.iptv.model.TvChannel;

@Entity(tableName = "tv_show")
public class TvShowEntity implements Serializable {
    static final long serialVersionUID = 727566175075960653L;
    @PrimaryKey
    private Long id;
    private String title;
    private String country;
    private String province;

    /**
     * 分类，流派
     */
    private List<String> genre;

    private String logo;

    /**
     * 节目分类：live:直播;movie:电影;
     */
    private String type;

    /**
     * 频道信息
     */
    private List<TvChannel> channel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<TvChannel> getChannel() {
        return channel;
    }

    public void setChannel(List<TvChannel> channel) {
        this.channel = channel;
    }

    public String getBestRouteUri() {
        // TODO 获取最优播放线路
        // 1.根据设备分辨率
        // 2.根据网络环境
        return this.channel.get(0).getRoute().get(0).getUri();
    }
}
