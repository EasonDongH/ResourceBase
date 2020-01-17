package com.easondongh.dao.dynamicSql;

import org.apache.ibatis.jdbc.SQL;

import java.util.List;
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
                        Object val = entry.getValue();
                        if(val instanceof List){
                            List<Object> list = (List<Object>)val;
                            if(list != null && list.size() > 0) {
                                String condition = entry.getKey() + " in (";
                                for(int i=0; i<list.size(); i++) {
                                    if(i != 0) {
                                        condition += ",";
                                    }
                                    condition += list.get(i).toString();
                                }
                                condition += ")";
                                WHERE(condition);
                            }
                        } else {
                            WHERE(entry.getKey() + " = " + entry.getValue());
                        }
                    }
                }
                ORDER_BY("articleOrder DESC, articleCommentCount DESC, articleLikeCount DESC, articleCreateTime DESC");
            }
        }.toString();
    }
}
