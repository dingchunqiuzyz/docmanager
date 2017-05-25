package com.jlju.docmanager.dto.echarts;

/**
 * User: 张月忠
 * Date: 2017/5/25
 * Time: 下午5:43
 * To change this template use File | Settings | File Templates.
 */

public class Title {

    private String text;
    private String subtext;
    private String x;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSubtext() {
        return subtext;
    }

    public void setSubtext(String subtext) {
        this.subtext = subtext;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }
}
