package com.easondongh.dao.dynamicSql;

import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * 生成article相关的动态SQL语句
 * @author EasonDongH
 * @date 2020/1/17 11:16
 */
public class ArticleDynaSqlProvider {

    public String selectByParam(Map<String,Object> params) {
        return new SQL(){
            {
                SELECT("*");
                FROM("article");
                if(params != null) {
                    for (Map.Entry<String, Object> entry : params.entrySet()) {
                        WHERE(entry.getKey() + " = " + entry.getValue());
                    }
                }
            }
        }.toString();
    }
}
