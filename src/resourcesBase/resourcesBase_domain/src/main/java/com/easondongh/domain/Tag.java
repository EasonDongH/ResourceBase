package com.easondongh.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Tag implements Serializable {

    private Long id;

    private String tagName;

    private String tagDescription;

    /**
     * tag背景颜色
     */
    private String tagBackground;
}
