package com.hacker.message;

import com.hacker.exception.BaseException;

import java.util.LinkedHashMap;

/**
 * Description:自定以message统一返回
 */
public class JsonData extends LinkedHashMap<String, Object> {

    private static final String KEY_RESULT = "result";

    public JsonData() {
        this(true);
    }

    public JsonData(boolean hasResultObj) {
        super();
        if (hasResultObj) {
            this.put(KEY_RESULT, ResultObj.getSuccResult());
        }
    }

    public void setErrResult(int resCode) {
        ResultObj resultObj = (ResultObj) this.get(KEY_RESULT);

        String errMsg = MessageContainer.getMsg(resCode);

        if (resultObj == null) {
            resultObj = ResultObj.getFailResult(resCode, errMsg);
            this.put(KEY_RESULT, resultObj);
        }

        resultObj.setResCode(resCode);
        resultObj.setErrMsg(errMsg);
    }

    public void setErrResult(int resCode, String errMsg) {
        ResultObj resultObj = (ResultObj) this.get(KEY_RESULT);

        if (resultObj == null) {
            resultObj = ResultObj.getFailResult(resCode, errMsg);
            this.put(KEY_RESULT, resultObj);
        }

        resultObj.setResCode(resCode);
        resultObj.setErrMsg(errMsg);
    }

    public void setErrResult(BaseException e) {
        int code = e.getCode();
        String errMsg = e.getMessage();
        if (errMsg == null) {
            errMsg = MessageContainer.getMsg(code);
        }
        setErrResult(code, errMsg);
    }
}
