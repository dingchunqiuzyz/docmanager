package com.jlju.docmanager.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Honours {
    private String hoUuid;

    private String hoName;

    private String hoRank;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date hoStartDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date hoEndDate;

    private Integer hoTeacherOrder;

    private String hoOrg;

    private Float hoMoney;

    private Long fkTeacherCode;

    public String getHoUuid() {
        return hoUuid;
    }

    public void setHoUuid(String hoUuid) {
        this.hoUuid = hoUuid == null ? null : hoUuid.trim();
    }

    public String getHoName() {
        return hoName;
    }

    public void setHoName(String hoName) {
        this.hoName = hoName == null ? null : hoName.trim();
    }

    public String getHoRank() {
        return hoRank;
    }

    public void setHoRank(String hoRank) {
        this.hoRank = hoRank == null ? null : hoRank.trim();
    }

    public Date getHoStartDate() {
        return hoStartDate;
    }

    public void setHoStartDate(Date hoStartDate) {
        this.hoStartDate = hoStartDate;
    }

    public Date getHoEndDate() {
        return hoEndDate;
    }

    public void setHoEndDate(Date hoEndDate) {
        this.hoEndDate = hoEndDate;
    }

    public Integer getHoTeacherOrder() {
        return hoTeacherOrder;
    }

    public void setHoTeacherOrder(Integer hoTeacherOrder) {
        this.hoTeacherOrder = hoTeacherOrder;
    }

    public String getHoOrg() {
        return hoOrg;
    }

    public void setHoOrg(String hoOrg) {
        this.hoOrg = hoOrg == null ? null : hoOrg.trim();
    }

    public Float getHoMoney() {
        return hoMoney;
    }

    public void setHoMoney(Float hoMoney) {
        this.hoMoney = hoMoney;
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