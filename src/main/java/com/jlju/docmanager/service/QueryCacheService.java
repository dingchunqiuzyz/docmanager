package com.jlju.docmanager.service;

import com.jlju.docmanager.bean.Magazine;
import com.jlju.docmanager.bean.QueryCache;

import java.util.List;

/**
 * Created by zyz on 2016/11/23.
 */
public interface QueryCacheService {

    QueryCache selectById(Integer cache_id);

    List<QueryCache> listByIds(List<Integer> ids);

    List<QueryCache> listFilesWithMagazine(QueryCache cache,Integer pageNum);
}
