package com.jlju.docmanager.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Projects {
    private String proUuid;

    private String proName;

    private String proLevel;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date proStartDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date proEndDate;

    private String proSource;

    private Float proFunds;

    private Integer proTeacherOrder;

    private Long fkTeacherCode;

    public String getProUuid() {
        return proUuid;
    }

    public void setProUuid(String proUuid) {
        this.proUuid = proUuid == null ? null : proUuid.trim();
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName == null ? null : proName.trim();
    }

    public String getProLevel() {
        return proLevel;
    }

    public void setProLevel(String proLevel) {
        this.proLevel = proLevel == null ? null : proLevel.trim();
    }

    public Date getProStartDate() {
        return proStartDate;
    }

    public void setProStartDate(Date proStartDate) {
        this.proStartDate = proStartDate;
    }

    public Date getProEndDate() {
        return proEndDate;
    }

    public void setProEndDate(Date proEndDate) {
        this.proEndDate = proEndDate;
    }

    public String getProSource() {
        return proSource;
    }

    public void setProSource(String proSource) {
        this.proSource = proSource == null ? null : proSource.trim();
    }

    public Float getProFunds() {
        return proFunds;
    }

    public void setProFunds(Float proFunds) {
        this.proFunds = proFunds;
    }

    public Integer getProTeacherOrder() {
        return proTeacherOrder;
    }

    public void setProTeacherOrder(Integer proTeacherOrder) {
        this.proTeacherOrder = proTeacherOrder;
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