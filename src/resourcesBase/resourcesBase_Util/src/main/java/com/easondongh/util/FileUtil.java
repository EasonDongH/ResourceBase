package com.easondongh.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author EasonDongH
 */
@Slf4j
public class FileUtil {

    /**
     * 将path指定的文件写入os中
     * @param path
     * @param os
     */
    public static void writeFile(String path, OutputStream os) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(path);
            int count = 0;
            byte[] buffer = new byte[1024 * 8];
            while ((count = fis.read(buffer)) != -1) {
                os.write(buffer, 0, count);
                os.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("writeFile", e);
        }
        try {
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
            log.error("writeFile", e);
        }
    }
}
