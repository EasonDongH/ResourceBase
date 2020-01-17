package com.easondongh.util;

import org.springframework.stereotype.Component;

/**
 * 生成id
 * @author EasonDongH
 * @date 2020/1/17 12:54
 */
@Component
public class IdGenerator {

    public Long next(){
        return System.nanoTime();
    }
}
