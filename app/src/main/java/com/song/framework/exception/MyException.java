package com.song.framework.exception;

/**
 * Created by songyawei on 2017/4/18.
 */
public class MyException extends RuntimeException {
    public static final String ERR_CODE_HTTP = "1001";
    public static final String ERR_CODE_JSON = "1002";
    public static final String ERR_CODE_SERVER = "1003";
    public static final String ERR_CODE_UNKNOWN = "1004";

    private String errCode;

    public MyException(String errCode) {
        this(errCode, getErrMsg(errCode));
    }

    public MyException(String errCode, String errMsg) {
        super(errMsg);
        this.errCode = errCode;
    }

    public String getErrCode() {
        return errCode;
    }

    private static String getErrMsg(String errCode) {
        String errMsg;
        switch (errCode) {
            case ERR_CODE_HTTP:
                errMsg = "网络错误，请检查网络设置并重试！";
                break;
            case ERR_CODE_JSON:
                errMsg = "解析数据异常。";
                break;
            case ERR_CODE_SERVER:
                errMsg = "服务器响应异常。";
                break;
            default:
                errMsg = "未知异常";
                break;
        }
        return errMsg;
    }
}
