package com.jlju.docmanager.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Prizes {
    private String priUuid;

    private String priName;

    private String priOrg;

    private String priRank;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date priDate;

    private Integer priTeacherOrder;

    private Integer priSchoolOrder;

    private String priType;

    private Long fkTeacherCode;

    public String getPriUuid() {
        return priUuid;
    }

    public void setPriUuid(String priUuid) {
        this.priUuid = priUuid == null ? null : priUuid.trim();
    }

    public String getPriName() {
        return priName;
    }

    public void setPriName(String priName) {
        this.priName = priName == null ? null : priName.trim();
    }

    public String getPriOrg() {
        return priOrg;
    }

    public void setPriOrg(String priOrg) {
        this.priOrg = priOrg == null ? null : priOrg.trim();
    }

    public String getPriRank() {
        return priRank;
    }

    public void setPriRank(String priRank) {
        this.priRank = priRank == null ? null : priRank.trim();
    }

    public Date getPriDate() {
        return priDate;
    }

    public void setPriDate(Date priDate) {
        this.priDate = priDate;
    }

    public Integer getPriTeacherOrder() {
        return priTeacherOrder;
    }

    public void setPriTeacherOrder(Integer priTeacherOrder) {
        this.priTeacherOrder = priTeacherOrder;
    }

    public Integer getPriSchoolOrder() {
        return priSchoolOrder;
    }

    public void setPriSchoolOrder(Integer priSchoolOrder) {
        this.priSchoolOrder = priSchoolOrder;
    }

    public String getPriType() {
        return priType;
    }

    public void setPriType(String priType) {
        this.priType = priType == null ? null : priType.trim();
    }

    public Long getFkTeacherCode() {
        return fkTeacherCode;
    }

    public void setFkTeacherCode(Long fkTeacherCode) {
        this.fkTeacherCode = fkTeacherCode;
    }



    private  Teachers teachers;

    public Teachers getTeachers() {
        return teachers;
    }

    public void setTeachers(Teachers teachers) {
        this.teachers = teachers;
    }
}