package com.jlju.docmanager.utils;

import com.jlju.docmanager.dto.WebResult;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

import java.util.List;

/**
 * User: 张月忠
 * Date: 2017/5/25
 * Time: 下午1:50
 * To change this template use File | Settings | File Templates.
 */

public class ValidateUtils{
    /**
     * 校验工具
     * @param validator
     * @param t
     * @return
     */
    public static WebResult<Void> validate(Validator validator, Object t){
        List<ConstraintViolation> messages = validator.validate(t);
        if(!messages.isEmpty()){
            StringBuffer sb = new StringBuffer();
            int i =1;
            for(ConstraintViolation m:messages){
                sb.append("<font color='red'>").append(i).append(".").append(m.getMessage()).append("</font>").append("<br/>");
                i++;
            }
            return new WebResult<Void>(false, sb.toString());
        }
        return null;
    }
}
