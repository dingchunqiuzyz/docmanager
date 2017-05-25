package com.jlju.docmanager.dto.echarts;

import java.util.List;

/**
 * User: 张月忠
 * Date: 2017/5/25
 * Time: 下午5:53
 * To change this template use File | Settings | File Templates.
 */

public class Bar {
    private Title title;

    private List<Data> datas;



    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public List<Data> getDatas() {
        return datas;
    }

    public void setDatas(List<Data> datas) {
        this.datas = datas;
    }
}
