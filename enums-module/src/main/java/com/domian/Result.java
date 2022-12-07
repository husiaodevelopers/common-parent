package com.domian;

import lombok.Data;



/**
 * @author zack on 2020/01/09.
 * 结果实体类，使用泛型
 */
@Data
public class Result<T> {

    /**
     * code
     */
    private Integer code;

    /**
     * msg
     */
    private String msg;

    /**
     * data
     */
    private T data = null;

    private Boolean success;

}
