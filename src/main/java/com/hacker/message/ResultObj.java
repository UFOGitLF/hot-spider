package com.hacker.message;

/**
 * Description:
 */
public class ResultObj {

    private int resCode;

    private String errMsg;

    public ResultObj() {

    }

    public ResultObj(int resCode, String errMsg) {
        this.resCode = resCode;
        this.errMsg = errMsg;
    }

    public static ResultObj getSuccResult() {
        return new ResultObj(ResultCodeConstants.SUCCESS, MessageContainer.getMsg(ResultCodeConstants.SUCCESS));
    }

    public static ResultObj getFailResult(int resCode, String errMsg) {
        return new ResultObj(resCode, errMsg);
    }

    public int getResCode() {
        return resCode;
    }

    public void setResCode(int resCode) {
        this.resCode = resCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
