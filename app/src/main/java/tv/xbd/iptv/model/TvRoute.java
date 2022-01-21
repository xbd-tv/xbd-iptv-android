package tv.xbd.iptv.model;

import java.io.Serializable;

public class TvRoute implements Serializable {
    /**
     * 线路地址
     */
    private String uri;

    /**
     * 线路评分
     */
    private Integer grade;

    /**
     * 线路分辨率
     */
    private Integer dpi;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getDpi() {
        return dpi;
    }

    public void setDpi(Integer dpi) {
        this.dpi = dpi;
    }
}
