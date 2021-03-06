package com.easondongh.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author EasonDongH
 */
@Data
public class Article implements Serializable {

    private Long id;

    private String articleTitle;

    private String articleContent;

    private String articleSummary;

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

    private Integer articleOrder;

    private Long categoryId;

    /**
     * 文章分类
     */
    private Category category;

    /**
     * 文章标签
     */
    private List<Tag> tagList;

    private Long userId;

    private User user;
}
