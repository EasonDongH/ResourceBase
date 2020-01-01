package com.easondongh.controller;

import com.easondongh.domain.Notice;
import com.easondongh.domain.Options;
import com.easondongh.service.NoticeService;
import com.easondongh.service.OptionsService;
import com.easondongh.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private OptionsService optionsService;
    @Autowired
    private NoticeService noticeService;

    @RequestMapping("/")
    public String index(Model model){
        List<Notice> noticeList = this.noticeService.listNotices();
        model.addAttribute("noticeList", noticeList);
        return "index";
    }

    @RequestMapping("/getAuthorPhoto")
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
