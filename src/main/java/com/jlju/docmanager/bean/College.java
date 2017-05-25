package com.jlju.docmanager.bean;

import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.NotBlank;

public class College {
    private Integer collegeId;
    @NotBlank(message = "学院名称不能为空")
    @Length(min = 4,max = 20,message = "学院名称长度在4-20个字符")
    private String collegeName;

    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName == null ? null : collegeName.trim();
    }
}