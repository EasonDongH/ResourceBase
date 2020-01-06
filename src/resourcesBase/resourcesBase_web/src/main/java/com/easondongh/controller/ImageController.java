package com.easondongh.controller;

import com.easondongh.domain.Options;
import com.easondongh.domain.Photo;
import com.easondongh.service.OptionsService;
import com.easondongh.service.PhotoService;
import com.easondongh.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private OptionsService optionsService;
    @Autowired
    private PhotoService photoService;

    @RequestMapping("/authorPhoto")
    @ResponseBody
    public void getAuthorPhoto(HttpServletResponse response) {
        Options options = optionsService.getOne();
        if (options != null) {
            writeStream(options.getSiteAuthorPhotoPath(), response);
        }
    }

    @RequestMapping("/{photoId}")
    @ResponseBody
    public void getPhoto(@PathVariable("photoId") int photoId, HttpServletResponse response) {
        Photo photo = this.photoService.getById(photoId);
        if (photo != null) {
            writeStream(photo.getPath(), response);
        }
    }

    /**
     * 将path中文件写入outputStream，并关闭outputStream
     *
     * @param path
     * @param response
     */
    private void writeStream(String path, HttpServletResponse response) {
        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            FileUtil.writeFile(path, outputStream);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
