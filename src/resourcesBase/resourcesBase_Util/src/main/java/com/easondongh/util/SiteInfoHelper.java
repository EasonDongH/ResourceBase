package com.easondongh.util;

import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 提供网站信息的帮助类
 */
public class SiteInfoHelper {

    private static Logger logger = Logger.getLogger(SiteInfoHelper.class);

    public static int getSiteRunDays() {
        Date cur = new Date(), build = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
             build = simpleDateFormat.parse("2019-12-31");
        } catch (Exception ex) {
            logger.error("getSiteRunDays",ex);
            build = new Date();
        }
        return (int)((cur.getTime() - build.getTime()) / (1000L*24L*3600L));
    }
}
