package com.easondongh.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class Article implements Serializable {

    private Integer id;

    private String articleTitle;

    private String articleContent;

    private Date articleCreateTime;

    private Date articleUpdateTime;

    /**
     * 查看次数
     */
    private Integer articleViewCount;

    /**
     * 评论数
     */
    private Integer articleCommentCount;

    /**
     * 标记喜欢数
     */
    private Integer articleLikeCount;

    private List<Category> categoryList;

    private Integer articleOrder;
}
