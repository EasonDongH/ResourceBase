package com.easondongh.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Options implements Serializable {

    private Long id;

    /**
     * 网站标题
     */
    private String optionSiteTitle;

    /**
     * 网站描述
     */
    private String optionSiteDescrption;

    /**
     * META-Descrption
     */
    private String optionMetaDescrption;

    /**
     * META-Keyword
     */
    private String optionMetaKeyword;

    /**
     * 网站作者信息
     */
    private String siteAuthorName;

    private String siteAuthorPhotoPath;

    /**
     * 网站作者微信
     */
    private String siteAuthorWechat;

    private String siteAuthorQq;

    private String siteAuthorWeibo;

    private String siteAuthorGitHub;
}
