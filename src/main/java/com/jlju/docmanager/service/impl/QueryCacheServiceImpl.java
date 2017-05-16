package com.jlju.docmanager.service.impl;

import com.jlju.docmanager.bean.QueryCache;
import com.jlju.docmanager.bean.QueryCacheExample;
import com.jlju.docmanager.dao.QueryCacheMapper;
import com.jlju.docmanager.service.QueryCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zyz on 2016/11/23.
 */
@Service
public class QueryCacheServiceImpl implements QueryCacheService {
    @Autowired
    private QueryCacheMapper mapper;
    public QueryCache selectById(Integer cache_id) {
        return mapper.selectByPrimaryKey(cache_id);
    }

    public List<QueryCache> listByIds(List<Integer> ids) {
        QueryCacheExample example = new QueryCacheExample();
        example.createCriteria().andCacheIdIn(ids);
        return mapper.selectByExample(example);
    }

    public List<QueryCache> listFilesWithMagazine(QueryCache cache, Integer pageNum) {
        return null;
    }
}
