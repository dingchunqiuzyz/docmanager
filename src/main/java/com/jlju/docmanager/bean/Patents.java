package com.jlju.docmanager.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Patents {
    private String patUuid;

    private String patName;

    private String patType;

    private String patCode;

    private String patTeacherName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date patDate;

    private Integer patTeacherOrder;

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