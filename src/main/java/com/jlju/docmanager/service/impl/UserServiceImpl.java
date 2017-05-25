package com.jlju.docmanager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jlju.docmanager.bean.TeachersExample;
import com.jlju.docmanager.bean.Users;
import com.jlju.docmanager.bean.UsersExample;
import com.jlju.docmanager.dao.UsersMapper;
import com.jlju.docmanager.dto.WebResult;
import com.jlju.docmanager.service.UsersSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zyz on 2016/11/9.
 */
@Service
public class UserServiceImpl implements UsersSerivce {
    @Autowired
    private UsersMapper mapper;
    @Transactional(readOnly = false)
    public int updateUsers(Users users) {
        return mapper.updateByPrimaryKey(users);
    }

    @Transactional(readOnly = false)
    public int insertUsers(Users users) {
       return mapper.insert(users);
    }
    @Transactional(readOnly = false)
    public int deleteUserById(int userId) {
        return mapper.deleteByPrimaryKey(userId);
    }
    @Transactional(readOnly = true)
    public PageInfo<Users> queryPage(int pageNum, Users users) {
        //每页显示10条
        PageHelper.startPage(pageNum,10);
        //创建查询条件
        UsersExample example = new UsersExample();
        UsersExample.Criteria criteria = example.createCriteria();
        if(users.getUsername()!=null&&!"".equals(users.getUsername())){
            criteria.andUsernameLike("%" + users.getUsername() + "%");
        }

        if(users.getRealName()!=null&&!"".equals(users.getRealName())){
            criteria.andRealNameLike("%" + users.getRealName() + "%");
        }
        List<Users> userses = mapper.selectByExample(example);
        PageInfo<Users> info = new PageInfo<Users>(userses);
        return info;
    }
    @Transactional(readOnly = true)
    public Users selectById(Integer userid) {
        return mapper.selectByPrimaryKey(userid);
    }

    /**
     * 登录业务逻辑
     * @param username
     * @param password
     * @return
     */
    @Transactional(readOnly = true)
    public WebResult<Users> login(String username, String password) {

        UsersExample example = new UsersExample();

        example.createCriteria().andUsernameEqualTo(username);

        List<Users> userses = mapper.selectByExample(example);

        if(userses==null||userses.size()!=1){
            //账号不正确
            return  new WebResult<Users>(false,"您输入的账号不存在",null);
        }
        //校验密码

        if(!userses.get(0).getPassword().equals(password)){
            //密码错误
            return  new WebResult<Users>(false,"您输入的密码有误",null);
        }
        //登录成功
       return  new WebResult<Users>(true,"登录成功",userses.get(0));
    }
}
