package com.jlju.docmanager.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Magazine {
    private String magUuid;

    private String magName;

    private String magLevel;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date magPubDate;

    private Integer magTeacherOrder;

    private Integer magSchoolOrder;

    private Long fkTeacherCode;

    private String magDeac;



    public String getMagUuid() {
        return magUuid;
    }

    public void setMagUuid(String magUuid) {
        this.magUuid = magUuid == null ? null : magUuid.trim();
    }

    public String getMagName() {
        return magName;
    }

    public void setMagName(String magName) {
        this.magName = magName == null ? null : magName.trim();
    }

    public String getMagLevel() {
        return magLevel;
    }

    public void setMagLevel(String magLevel) {
        this.magLevel = magLevel == null ? null : magLevel.trim();
    }

    public Date getMagPubDate() {
        return magPubDate;
    }

    public void setMagPubDate(Date magPubDate) {
        this.magPubDate = magPubDate;
    }

    public Integer getMagTeacherOrder() {
        return magTeacherOrder;
    }

    public void setMagTeacherOrder(Integer magTeacherOrder) {
        this.magTeacherOrder = magTeacherOrder;
    }

    public Integer getMagSchoolOrder() {
        return magSchoolOrder;
    }

    public void setMagSchoolOrder(Integer magSchoolOrder) {
        this.magSchoolOrder = magSchoolOrder;
    }

    public Long getFkTeacherCode() {
        return fkTeacherCode;
    }

    public void setFkTeacherCode(Long fkTeacherCode) {
        this.fkTeacherCode = fkTeacherCode;
    }

    public String getMagDeac() {
        return magDeac;
    }

    public void setMagDeac(String magDeac) {
        this.magDeac = magDeac == null ? null : magDeac.trim();
    }


    private Teachers teachers;

    public Teachers getTeachers() {
        return teachers;
    }

    public void setTeachers(Teachers teachers) {
        this.teachers = teachers;
    }
}