package com.easondongh.domain;

import lombok.Data;
import org.apache.ibatis.binding.MapperMethod;

import java.util.*;

/**
 * 将文章按年、月分组
 * @author EasonDongH
 * @date 2020/1/20 16:31
 */
@Data
public class ArticleGroup {

    Map<String,Map<String,List<Article>>> articleGroup = new LinkedHashMap<>();

    public ArticleGroup(List<Article> articleList){
        toArticleGroup(articleList);
    }

    public void toArticleGroup(List<Article> articleList) {
        int lastYear = 1970, curYear = 0;
        Calendar calender = Calendar.getInstance();
        Map<String,List<Article>> articleMap = new LinkedHashMap<>();
        for(int i=0; i<articleList.size(); ) {
            calender.setTime(articleList.get(i).getArticleCreateTime());
            curYear = calender.get(Calendar.YEAR);
            if(curYear != lastYear) {
                if(articleMap != null && articleMap.size() > 0) {
                    this.articleGroup.put(lastYear + "", articleMap);
                }
                lastYear = curYear;
                articleMap = new HashMap<>();
            }
            int lastMonth = 13, curMonth = 0, tmpYear = curYear;
            List<Article> articles = new ArrayList<>();
            for(; i<articleList.size(); i++) {
                calender.setTime(articleList.get(i).getArticleCreateTime());
                tmpYear = calender.get(Calendar.YEAR);
                if(tmpYear != curYear) {
                    break;
                }
                curMonth =  calender.get(Calendar.MONTH);
                if(curMonth != lastMonth) {
                    if(articles != null && articles.size() > 0) {
                        articleMap.put(lastMonth + "", articles);
                    }
                    lastMonth = curMonth;
                    articles = new ArrayList<>();
                }
                articles.add(articleList.get(i));
            }
            if(articles != null && articles.size() > 0) {
                articleMap.put(curMonth + "", articles);
            }
        }
        if(articleMap != null && articleMap.size() > 0) {
            this.articleGroup.put(curYear + "", articleMap);
        }
    }
}
