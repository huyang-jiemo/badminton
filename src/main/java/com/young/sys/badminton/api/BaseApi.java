package com.young.sys.badminton.api;

import com.young.sys.badminton.model.AjaxResult;
import com.young.sys.badminton.model.Constant;

/**
 * @author huyang8
 * // TODO: 2018/11/10 基础api
 */
public abstract class BaseApi {
    <T> AjaxResult successData(T data){
        AjaxResult result=new AjaxResult();
        result.setCode(Constant.SUCCESS_CODE);
        result.setData(data);
        return result;
    }

    protected AjaxResult success(){
        AjaxResult result=new AjaxResult();
        result.setCode(Constant.SUCCESS_CODE);
        return result;
    }

    protected AjaxResult failMessage(String message){
        AjaxResult result=new AjaxResult();
        result.setCode(Constant.FAIL_CODE);
        result.setMessage(message);
        return result;
    }

    protected AjaxResult error(){
        AjaxResult result=new AjaxResult();
        result.setCode(Constant.FAIL_CODE);
        result.setMessage(Constant.ERROR_MESSAGE);
        return result;
    }
}
