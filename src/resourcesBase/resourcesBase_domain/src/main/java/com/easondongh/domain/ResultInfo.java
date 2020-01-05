package com.easondongh.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultInfo implements Serializable {

    /**
     * 后端返回结果正常为true，发生异常返回false
     */
    private boolean flag;

    /**
     * 后端返回结果数据对象
     */
    private Object data;

    /**
     * 发生异常的错误消息
     */
    private String errorMsg;

}
