package com.jlju.docmanager.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Report {
    private String repUuid;

    private String repName;

    private String repRank;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date repDate;

    private Integer repTeacherOrder;

    private String repOrg;

    private Long fkTeacherCode;

    public String getRepUuid() {
        return repUuid;
    }

    public void setRepUuid(String repUuid) {
        this.repUuid = repUuid == null ? null : repUuid.trim();
    }

    public String getRepName() {
        return repName;
    }

    public void setRepName(String repName) {
        this.repName = repName == null ? null : repName.trim();
    }

    public String getRepRank() {
        return repRank;
    }

    public void setRepRank(String repRank) {
        this.repRank = repRank == null ? null : repRank.trim();
    }

    public Date getRepDate() {
        return repDate;
    }

    public void setRepDate(Date repDate) {
        this.repDate = repDate;
    }

    public Integer getRepTeacherOrder() {
        return repTeacherOrder;
    }

    public void setRepTeacherOrder(Integer repTeacherOrder) {
        this.repTeacherOrder = repTeacherOrder;
    }

    public String getRepOrg() {
        return repOrg;
    }

    public void setRepOrg(String repOrg) {
        this.repOrg = repOrg == null ? null : repOrg.trim();
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