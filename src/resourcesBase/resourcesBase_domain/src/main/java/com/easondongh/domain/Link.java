package com.easondongh.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author EasonDongH
 * @date 2020/1/20 9:50
 */
@Data
public class Link implements Serializable {

    private Long id;

    private String siteName;

    private String siteUrl;

    private String siteDescription;

    private String contactWay;

    private String remark;

    private Long userId;

    private Integer status;

    @Override
    public String toString() {
        return "申请友链：" +
                "网站名称=" + siteName +
                ", 网站地址=" + siteUrl +
                ", 网站描述=" + siteDescription +
                ", 备注=" + remark;
    }
}
