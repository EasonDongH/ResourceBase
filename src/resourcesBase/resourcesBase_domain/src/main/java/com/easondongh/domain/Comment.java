package com.easondongh.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author EasonDongH
 * @date 2020/1/11 20:18
 */
@Data
public class Comment implements Serializable {

    private Long id;

    /**
     * 该条评论的父节点（为0表示没有父节点）
     */
    private Long pid;

    /**
     * 文章id
     */
    private Long aid;

    /**
     * 为0时表示为游客
     */
    private Long userId;

    /**
     * 头像id
     */
    private Long avatarId;

    /**
     * 游客的nickName为"游客"
     */
    private String nickName;

    /**
     * 当前评论的父节点名称（为空时则表示为评论根节点）
     */
    private String pname;

    public String getPname(){
        boolean isTourist = this.pname == null || this.pname.length() == 0;
        if(isTourist) {
            pname = "游客";
        }
        return pname;
    }

    public String getNickName() {
        boolean isTourist = userId == 0 && (this.nickName == null || this.nickName.length() == 0);
        if(isTourist) {
            nickName = "游客";
        }
        return nickName;
    }

    private String content;

    /**
     * 该评论下的评论数量
     */
    private int childCommentCount;

    private Date createTime;

    private Date updateTime;

    /**
     * 0：删除  1：新建  2：已读
     */
    private int status;
}
