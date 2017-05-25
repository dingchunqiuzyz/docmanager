package com.jlju.docmanager.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.Min;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Report {
    private String repUuid;
    @NotBlank(message = "名称不能为空")
    @Length(min = 4,max = 40,message = "名称长度在4-40个字符之间")
    private String repName;

    private String repRank;
    @NotNull(message = "采用时间不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date repDate;
    @NotNull(message = "作者排名不能为空")
    @Min(value = 1,message = "作者排名最小值为1")
    private Integer repTeacherOrder;
    @NotBlank(message = "采用单位不能为空")
    @Length(min = 4,max = 40,message = "采用单位长度在4-40个字符之间")
    private String repOrg;
    @NotNull(message = "教师编号尚未选择")
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