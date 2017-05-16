package com.jlju.docmanager.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Works {
    private String workUuid;

    private String workName;

    private String workPublish;

    private String workIsbn;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date workDate;

    private Float workCharNumber;

    private Integer workTeacherOrder;

    private String workType;

    private String workProductType;

    private Long fkTeacherCode;

    public String getWorkUuid() {
        return workUuid;
    }

    public void setWorkUuid(String workUuid) {
        this.workUuid = workUuid == null ? null : workUuid.trim();
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName == null ? null : workName.trim();
    }

    public String getWorkPublish() {
        return workPublish;
    }

    public void setWorkPublish(String workPublish) {
        this.workPublish = workPublish == null ? null : workPublish.trim();
    }

    public String getWorkIsbn() {
        return workIsbn;
    }

    public void setWorkIsbn(String workIsbn) {
        this.workIsbn = workIsbn == null ? null : workIsbn.trim();
    }

    public Date getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    public Float getWorkCharNumber() {
        return workCharNumber;
    }

    public void setWorkCharNumber(Float workCharNumber) {
        this.workCharNumber = workCharNumber;
    }

    public Integer getWorkTeacherOrder() {
        return workTeacherOrder;
    }

    public void setWorkTeacherOrder(Integer workTeacherOrder) {
        this.workTeacherOrder = workTeacherOrder;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType == null ? null : workType.trim();
    }

    public String getWorkProductType() {
        return workProductType;
    }

    public void setWorkProductType(String workProductType) {
        this.workProductType = workProductType == null ? null : workProductType.trim();
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