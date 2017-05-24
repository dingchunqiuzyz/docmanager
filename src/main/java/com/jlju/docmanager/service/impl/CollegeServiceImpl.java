package com.jlju.docmanager.service.impl;

import com.jlju.docmanager.bean.College;
import com.jlju.docmanager.dao.CollegeMapper;
import com.jlju.docmanager.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: 张月忠
 * Date: 2017/5/23
 * Time: 下午8:56
 * To change this template use File | Settings | File Templates.
 */
@Service
public class CollegeServiceImpl implements CollegeService {
    @Autowired
    private CollegeMapper mapper;
    @Transactional(readOnly = false)
    @Override
    public Integer insert(College college) {
        return mapper.insert(college);
    }
    @Transactional(readOnly = false)
    @Override
    public Integer delete(int id) {
        return mapper.deleteByPrimaryKey(id);
    }
    @Transactional(readOnly = true)
    @Override
    public List<College> query() {
        return mapper.selectByExample(null);
    }
}
