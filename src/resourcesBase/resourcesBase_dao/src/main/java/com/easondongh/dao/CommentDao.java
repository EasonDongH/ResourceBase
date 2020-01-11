package com.easondongh.dao;

import com.easondongh.domain.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author EasonDongH
 * @date 2020/1/11 20:39
 */
public interface CommentDao {

    /**
     * 新增评论
     * @param comment
     * @return
     */
    @Insert("insert into comment (id,aid,userId,avatarId,pid,nickName,pname,content,createTime,updateTime) " +
            "values(#{id},#{aid},#{userId},#{avatarId},#{pid},#{nickName},#{pname},#{content},#{createTime},#{updateTime})")
    int addComment(Comment comment);

    /**
     * 根据文章id获取评论列表（status!=0），按updateTime倒序排列
     * @param articleId
     * @return
     */
    @Select("select * from comment where aid=#{articleId} and status!=0 order by updateTime desc")
    List<Comment> getCommentListByaid(Long articleId);
}
