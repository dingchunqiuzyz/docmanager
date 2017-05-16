package com.jlju.docmanager.service;

import com.github.pagehelper.PageInfo;
import com.jlju.docmanager.bean.Users;
import com.jlju.docmanager.dto.WebResult;

import java.util.List;

/**
 * Created by zyz on 2016/11/9.
 */
public interface UsersSerivce
{
     /**
      * 修改系统使用人员信息
      * @param users 用户信息
      * @return
      */
     int updateUsers(Users users);

     /**
      * 添加系统使用人员
      * @param users  系统使用人员
      */
     int insertUsers(Users users);

     /**
      * 根据id删除系统使用人员
      * @param userId
      * @return
      */
     int deleteUserById(int userId);

     /**
      * 分页查询用户信息
      * @param pageNum 起始页码
      * @param users 封装了查询条件
      * @return
      */
     PageInfo<Users> queryPage(int pageNum,Users users);

     /**
      * 根据id查询
      * @param userid
      * @return
      */
     Users selectById(Integer userid);

     /**
      * 用户登录
      * @param username
      * @param password
      * @return
      */
     WebResult<Users> login(String username,String password);

}
