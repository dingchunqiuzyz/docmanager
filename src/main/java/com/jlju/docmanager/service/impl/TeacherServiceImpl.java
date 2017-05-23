package com.jlju.docmanager.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jlju.docmanager.bean.Teachers;
import com.jlju.docmanager.bean.TeachersExample;
import com.jlju.docmanager.dao.TeachersMapper;
import com.jlju.docmanager.service.TeacherService;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.ExcelGeneralNumberFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zyz on 2016/11/9.
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeachersMapper mapper;

    @Transactional(readOnly = false)
    public int updateTeachers(Teachers teachers) {
        return mapper.updateByPrimaryKey(teachers);
    }
    @Transactional(readOnly = false)
    public int insertTeachers(Teachers teachers) {
        return mapper.insert(teachers);
    }
    @Transactional(readOnly = false)
    public int deleteById(int id) {
        return mapper.deleteByPrimaryKey(id);
    }

    public PageInfo<Teachers> queryPage(int pageNum, Teachers teachers) {
//        每页显示10条
        PageHelper.startPage(pageNum,10);
        //创建查询条件
        TeachersExample example = new TeachersExample();
        TeachersExample.Criteria criteria = example.createCriteria();
        if(teachers.getTeacherName()!=null&&!"".equals(teachers.getTeacherName())){
            criteria.andTeacherNameLike("%" + teachers.getTeacherName() + "%");
        }

        if(teachers.getTeacherCode()!=null&&teachers.getTeacherCode()>0){
            criteria.andTeacherCodeEqualTo(teachers.getTeacherCode());
        }
        List<Teachers> teacherses = mapper.selectByExample(example);
        PageInfo<Teachers> info = new PageInfo<Teachers>(teacherses);
        return info;
    }

    public Teachers selectById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    public List<Teachers> selectTeacherByName(String teacherName) {
        TeachersExample example = new TeachersExample();
        TeachersExample.Criteria criteria = example.createCriteria();
        if(teacherName!=null&&!"".equals(teacherName)){
            criteria.andTeacherNameLike("%" + teacherName + "%");
        }
        return mapper.selectByExample(example);
    }

    public String selectTeacherByNameAsJson(String teacherName)  {
        List<Teachers> teacherses = null;
        Map<Long,String> map =null;
        if(teacherName!=null&&!"".equals(teacherName)){
            teacherses= this.selectTeacherByName(teacherName);
        }
        if(teacherses!=null&&teacherses.size()>0){
            map = new HashMap<Long, String>();
            for(Teachers t:teacherses){
                map.put(t.getTeacherCode(),"学院："+t.getCollege());
            }
        }
        if (map!=null){
            ObjectMapper mapper = new ObjectMapper();
            try {
             return   mapper.writeValueAsString(map);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    @Transactional(readOnly = false)
    @Override
    public void batchInsert(MultipartFile file) throws Exception {
        //从文件中解析出教师信息
        //批量insert
        if(file==null||file.isEmpty())
            throw  new Exception("上传文件不存在");
        if(!file.getOriginalFilename().endsWith(".xlsx")){
            throw  new Exception("您上传的excel版本太低，请上传2007版本以上的excel");
        }
        List<Teachers> teachersList;
        try {
            teachersList = parseFromExcel(file);
            if(!teachersList.isEmpty()){
                //教师信息不为空
                mapper.batchInsert(teachersList);
            }else {
                throw new Exception("从excel解析教师记录为空，不能添加教师！");
            }
        }catch (Exception e){
            throw  e;
        }finally {
            if(file.getInputStream()!=null){
                file.getInputStream().close();
            }
        }


    }

    private List<Teachers> parseFromExcel(MultipartFile file) throws Exception{
        List<Teachers> teachersList = new ArrayList<>(200);
        OPCPackage pkg = OPCPackage.open(file.getInputStream());//打开输入流
        XSSFWorkbook wb = new XSSFWorkbook(pkg);//打开excel
        XSSFSheet sheet = wb.getSheetAt(0);//打开sheet
        int i = 0;//行数计数器
        Teachers teachers = null;
        for (Row row : sheet) {
            //遍历所有的行
            i++;
            if (i == 1) {
                continue;//跳过表头
            }
            teachers = new Teachers();
            try {
                teachers.setTeacherName(row.getCell(0).getStringCellValue());
                teachers.setTeacherCode(Long.parseLong(row.getCell(1).getStringCellValue()));
                teachers.setCollege( row.getCell(2).getStringCellValue());
                teachers.setPassword(teachers.getTeacherCode().toString());
            } catch (NumberFormatException e) {
                //数字转化出错
                throw new Exception("第["+i+"]行教师信息解析出错，可能原因是：教工编号输入的不是数字");

            } catch (NullPointerException e) {
                throw new Exception("第"+i+"行教师信息解析出错，可能原因是：输入的教师信息不完整，所有的信息为必填项");
                //格式不全
            } catch (IllegalStateException e) {
                //excel格式有问题
                try {
                    teachers.setTeacherCode(Double.valueOf(row.getCell(1).getNumericCellValue()).longValue());
                    teachers.setPassword(teachers.getTeacherCode().toString());
                } catch (NumberFormatException e1) {
                    //数字转化异常
                    throw new Exception("第["+i+"]行教师信息解析出错，可能原因是：教工编号输入的不是数字");
                }

            } catch (Exception e) {
                //其他异常
                e.printStackTrace();
                throw new Exception("第["+i+"]行教师信息解析出错，请联系开发者：982135973@qq.com 可能原因是："+e.getMessage());
            }

            teachersList.add(teachers);
        }
        pkg.close();//关闭流
        return teachersList;
    }

}
