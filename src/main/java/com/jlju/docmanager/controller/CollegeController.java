package com.jlju.docmanager.controller;

import com.jlju.docmanager.bean.College;
import com.jlju.docmanager.dto.WebResult;
import com.jlju.docmanager.service.CollegeService;
import com.jlju.docmanager.utils.ValidateUtils;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by zyz on 2016/11/9.
 */
@Controller
@RequestMapping("/college")
public class CollegeController {


    @Autowired
    private CollegeService collegeService;
    @Autowired
    private Validator validator;

    /**
     * 查询所有用户
     *
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String list(Model model) {
        List<College> colleges = collegeService.query();
        model.addAttribute("colleges", colleges);
        return "/colleges/list";
    }
    @RequestMapping(value = "/queryAll", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    @ResponseBody
    public WebResult<List<College>> queryAll(){
        List<College> colleges = collegeService.query();
        if(colleges==null||colleges.isEmpty()){
            return new WebResult<List<College>>(false,"查询失败");
        }
        return new WebResult<List<College>>(true,"查询成功",colleges);
    }

    @RequestMapping(value = "/edit", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    @ResponseBody
    public WebResult<Void> edit(College college) {
        //校验参数
        WebResult<Void> validateResult = ValidateUtils.validate(validator,college);
        if (validateResult != null)
            return validateResult;


        int result = -1;
        try {
            //添加
            result = collegeService.insert(college);
            if (result > 0) {
                return new WebResult<Void>(true, "操作成功");
            } else {
                return new WebResult<Void>(false, "操作失败");
            }

        } catch (Exception e) {
            return new WebResult<Void>(false, "操作失败:可能原因：该账号已经被占用了\n\r" + e.getMessage());
        }

    }



    @RequestMapping(value = "/{collegeId}/delete", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    @ResponseBody
    public WebResult<Void> delete(@PathVariable("collegeId") Integer collegeId) {
        int result = -1;
        try {
            if (collegeId != null) {
                result = collegeService.delete(collegeId);
            }
            if (result > 0) {
                return new WebResult<Void>(true, "删除成功！");
            } else {
                return new WebResult<Void>(false, "删除失败");
            }
        } catch (Exception e) {
            return new WebResult<Void>(false, "操作失败:" + e.getMessage());
        }

    }


}
