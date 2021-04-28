package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author 枳洛淮南
 * @version 1.0
 * @Description http 相应JSON数据，前后端同一约定的json格式
 * 相应状态码都是200，进入ajax的success来使用
 * {success:true,data:xxx}
 * {success:false,code:xxx,message:xxx}
 * @Date 2021/4/28 下午 21:51
 */

@Getter
@Setter
@ToString
public class JSONResponse
{
    //业务操作是否成功
    private boolean success;

    //业务操作的消息码，一般来说，出现错误时的错误码才有意义，给开发人员定位问题
    private String code;

    //业务操作的错误消息，给用户看的信息
    private String message;

    //业务数据：业务操作成功是，给ajax success方法使用，解析响应json数据
    private Object data;


}
