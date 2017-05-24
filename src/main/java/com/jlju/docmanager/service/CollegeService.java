package com.jlju.docmanager.service;

import com.jlju.docmanager.bean.College;

import java.util.List;

/**
 * User: 张月忠
 * Date: 2017/5/23
 * Time: 下午8:55
 * To change this template use File | Settings | File Templates.
 */

public interface CollegeService {

    Integer insert(College college);

    Integer delete(int id);

    List<College> query();
}
