package com.easondongh.dao;

import com.easondongh.domain.Link;
import org.apache.ibatis.annotations.Insert;

/**
 *
 * @author EasonDongH
 * @date 2020/1/20 10:07
 */
public interface LinkDao {

    @Insert("insert into link (id,siteName,siteUrl,siteDescription,contactWay,remark,userId) " +
            "values(#{id},#{siteName},#{siteUrl},#{siteDescription},#{contactWay},#{remark},#{userId})")
    int addLink(Link link);
}
