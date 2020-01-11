package com.easondongh.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 管理图片信息
 * @author EasonDongH
 */
@Data
public class Photo implements Serializable {

    private long id;
    /**
     * 图片路径
     */
    private String path;
}
