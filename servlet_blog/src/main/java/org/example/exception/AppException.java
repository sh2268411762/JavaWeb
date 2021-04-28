package org.example.exception;

/**
 * @author 枳洛淮南
 * @version 1.0
 * @Description 功能
 * @Date 2021/4/28 下午 18:03
 */
public class AppException extends RuntimeException
{
    private String code;

    public AppException(String code, String message)    //错误码，错误消息
    {
        this(code, message, null);
    }

    public AppException(String code, String message, Throwable cause)
    {
        super(message, cause);
        this.code = code;
    }

    public String getCode()
    {
        return code;
    }
}
