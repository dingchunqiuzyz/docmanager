package com.jlju.docmanager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jlju.docmanager.bean.QueryCache;
import com.jlju.docmanager.bean.QueryCacheExample;
import com.jlju.docmanager.dao.QueryCacheMapper;
import com.jlju.docmanager.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zyz on 2016/11/17.
 */
@Service
public class SearchServiceImpl implements SearchService{
    @Autowired
    private QueryCacheMapper mapper;
    public PageInfo<QueryCache> search(QueryCache cache, Integer pageNum) {

        PageHelper.startPage(pageNum,10);
        QueryCacheExample example = new QueryCacheExample();
        QueryCacheExample.Criteria criteria = example.createCriteria();

        // 根据教师名  教师编号  文件名 文件类型进行检索

        if(cache.getTeacherName()!=null&&!"".equals(cache.getTeacherName())){
            criteria.andTeacherNameLike("%"+cache.getTeacherName()+"%");
        }

        if(cache.getFkTeacherCode()!=null&&cache.getFkTeacherCode()>0){
            criteria.andFkTeacherCodeEqualTo(cache.getFkTeacherCode());
        }

        if(cache.getFileName()!=null&&!"".equals(cache.getFileName())){
            criteria.andFileNameLike("%"+cache.getFileName()+"%");
        }

        if(cache.getStartDate()!=null){
            criteria.andFileDateGreaterThanOrEqualTo(cache.getStartDate());
        }

        if(cache.getEndDate()!=null){
            criteria.andFileDateLessThanOrEqualTo(cache.getEndDate());
        }

        if(cache.getFileType()==null){
            cache.setFileType("");
        }
        criteria.andFileTypeLike("%" + cache.getFileType()+"%");
        //条件设置结束
        List<QueryCache> files = mapper.selectByExample(example);
        PageInfo info = new PageInfo(files);
        return info;
    }
    @Transactional(readOnly = false)
    public int insertFileCache(QueryCache cache) {
        return mapper.insert(cache);
    }

    public QueryCache selectById(Integer cacheId) {
        return mapper.selectByPrimaryKey(cacheId);
    }
}
