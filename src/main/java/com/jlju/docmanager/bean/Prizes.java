package com.jlju.docmanager.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.Min;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Prizes {
    private String priUuid;
    @NotBlank(message = "奖项名称不能为空")
    @Length(min = 4,max = 40,message = "奖项名称长度在4-40个字符之间")
    private String priName;
    @NotBlank(message = "颁发单位不能为空")
    @Length(min = 4,max = 40,message = "颁发单位长度在4-40个字符之间")
    private String priOrg;

    private String priRank;
    @NotNull(message = "获奖时间不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date priDate;
    @NotNull(message = "作者排名不能为空")
    @Min(value = 1,message = "作者排名最小值为1")
    private Integer priTeacherOrder;
    @NotNull(message = "本校排名不能为空")
    @Min(value = 1,message = "本校排名最小值为1")
    private Integer priSchoolOrder;

    private String priType;
    @NotNull(message = "教师编号尚未选择")
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