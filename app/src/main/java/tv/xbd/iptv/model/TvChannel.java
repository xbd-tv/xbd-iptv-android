package tv.xbd.iptv.model;

import java.io.Serializable;
import java.util.List;

public class TvChannel implements Serializable {
    private String title;
    private String plot;
    private String outline;
    /**
     * 电视线路信息
     */
    private List<TvRoute> route;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getOutline() {
        return outline;
    }

    public void setOutline(String outline) {
        this.outline = outline;
    }

    public List<TvRoute> getRoute() {
        return route;
    }

    public void setRoute(List<TvRoute> route) {
        this.route = route;
    }
}
