package com.jlju.docmanager.service;

import com.github.pagehelper.PageInfo;
import com.jlju.docmanager.bean.QueryCache;

/**
 * Created by zyz on 2016/11/17.
 */

public interface SearchService {

    PageInfo<QueryCache> search(QueryCache cache,Integer pageNum);

    int insertFileCache(QueryCache cache);

    QueryCache selectById(Integer cacheId);

}
