package com.jlju.docmanager.service;

import com.jlju.docmanager.bean.Magazine;
import com.jlju.docmanager.bean.QueryCache;
import com.jlju.docmanager.dto.echarts.Data;

import java.util.List;

/**
 * Created by zyz on 2016/11/23.
 */
public interface QueryCacheService {

    QueryCache selectById(Integer cache_id);

    List<QueryCache> listByIds(List<Integer> ids);

    List<QueryCache> listFilesWithMagazine(QueryCache cache,Integer pageNum);

    /**
     * 统计上传文件最多的6个老师
     * @return
     */
    List<Data> countFileTop6();

    /**
     * 统计各种类型的分布
     * @return
     */
    List<Data> countFileType();
}
