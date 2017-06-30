package com.hacker.exception;

import com.hacker.message.MessageContainer;
import com.hacker.message.ResultObj;

/**
 * 自定义service层异常
 */
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 8002283590289218255L;

    private String msg;
    private int code;

    protected BaseException(int code, String arg0, Throwable arg1) {
        super(arg0, arg1);
        this.code = code;
        this.msg = arg0;
    }

    public BaseException(int code) {
        this.code = code;
        this.msg = MessageContainer.getMsg(code);
    }

    public BaseException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public BaseException(ResultObj resultObj){
        super(resultObj.getErrMsg());
        this.code = resultObj.getResCode();
        this.msg = resultObj.getErrMsg();
    }

    @Override
    public String getMessage() {
        return this.msg;
    }

    public int getCode() {
        return this.code;
    }

}

