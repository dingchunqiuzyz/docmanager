package com.jlju.docmanager.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.Min;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Patents {
    private String patUuid;
    @NotBlank(message = "专利名称不能为空")
    @Length(min = 4,max = 40,message = "专利名称长度在4-40个字符之间")
    private String patName;

    private String patType;
    @NotBlank(message = "专利代码不能为空")
    @Length(min = 4,max = 40,message = "专利代码长度在4-40个字符之间")
    private String patCode;
    @NotBlank(message = "专利权人不能为空")
    @Length(min = 2,max = 40,message = "专利权人长度在2-40个字符之间")
    private String patTeacherName;
    @NotNull(message = "授权时间不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date patDate;
    @NotNull(message = "排名不能为空")
    @Min(value = 1,message = "排名最小值为1")
    private Integer patTeacherOrder;
    @NotNull(message = "教师编号尚未选择")
    private Long fkTeacherCode;

    public String getPatUuid() {
        return patUuid;
    }

    public void setPatUuid(String patUuid) {
        this.patUuid = patUuid == null ? null : patUuid.trim();
    }

    public String getPatName() {
        return patName;
    }

    public void setPatName(String patName) {
        this.patName = patName == null ? null : patName.trim();
    }

    public String getPatType() {
        return patType;
    }

    public void setPatType(String patType) {
        this.patType = patType == null ? null : patType.trim();
    }

    public String getPatCode() {
        return patCode;
    }

    public void setPatCode(String patCode) {
        this.patCode = patCode == null ? null : patCode.trim();
    }

    public String getPatTeacherName() {
        return patTeacherName;
    }

    public void setPatTeacherName(String patTeacherName) {
        this.patTeacherName = patTeacherName == null ? null : patTeacherName.trim();
    }

    public Date getPatDate() {
        return patDate;
    }

    public void setPatDate(Date patDate) {
        this.patDate = patDate;
    }

    public Integer getPatTeacherOrder() {
        return patTeacherOrder;
    }

    public void setPatTeacherOrder(Integer patTeacherOrder) {
        this.patTeacherOrder = patTeacherOrder;
    }

    public Long getFkTeacherCode() {
        return fkTeacherCode;
    }

    public void setFkTeacherCode(Long fkTeacherCode) {
        this.fkTeacherCode = fkTeacherCode;
    }



    private Teachers teachers;

    public Teachers getTeachers() {
        return teachers;
    }

    public void setTeachers(Teachers teachers) {
        this.teachers = teachers;
    }
}