package com.jlju.docmanager.bean;

import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.NotBlank;

public class Users {
    private Integer userId;
    @NotBlank(message = "账号不能为空")
    @Length(min = 5,max = 16,message = "账号长度在5-16个字符之间")
    private String username;
    @NotBlank(message = "密码不能为空")
    @Length(min = 5,max = 16,message = "密码长度在5-16个字符之间")
    private String password;
    @NotBlank(message = "姓名不能为空")
    @Length(min = 2,max = 10,message = "账号长度在2-10个字符之间")
    private String realName;
    private String userType;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }
}