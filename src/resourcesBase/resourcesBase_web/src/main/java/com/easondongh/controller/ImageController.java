package com.easondongh.controller;

import com.easondongh.domain.Options;
import com.easondongh.service.OptionsService;
import com.easondongh.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping("/authorPhoto")
    @ResponseBody
    public void getAuthorPhoto(HttpServletResponse response){
        ServletOutputStream outputStream = null;
        try {
            Options options = optionsService.getOne();
            if(options != null) {
                outputStream = response.getOutputStream();
                FileUtil.writeFile(options.getSiteAuthorPhotoPath(), outputStream);
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            if(outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
