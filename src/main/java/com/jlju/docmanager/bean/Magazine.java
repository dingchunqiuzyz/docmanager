package com.jlju.docmanager.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.Min;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Magazine {
    private String magUuid;
    @NotBlank(message = "论文名称不能为空")
    @Length(min = 4,max = 40,message = "论文名称长度在4-40个字符之间")
    private String magName;

    private String magLevel;
    @NotNull(message = "发表时间不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date magPubDate;
    @NotNull(message = "教师排名不能为空")
    @Min(value = 1,message = "排名最小值为1")
    private Integer magTeacherOrder;
    @NotNull(message = "本校排名不能为空")
    @Min(value = 1,message = "排名最小值为1")
    private Integer magSchoolOrder;
    @NotNull(message = "教师编号尚未选择")
    private Long fkTeacherCode;
    @NotBlank(message = "检索清空不能为空")
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