package com.song.framework.model;

import com.google.gson.JsonElement;

/**
 * Created by songyawei on 2017/4/13.
 */
public class ResponseModel {
    private String status;
    private String msg;
    private String errNum;
    private String errMsg;
    private JsonElement result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setResult(JsonElement result) {
        this.result = result;
    }

    public JsonElement getResult() {
        return result;
    }

    public String getErrNum() {
        return errNum;
    }

    public void setErrNum(String errNum) {
        this.errNum = errNum;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
