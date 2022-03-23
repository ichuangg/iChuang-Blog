package com.danli.controller;

import com.danli.common.lang.Result;
import com.danli.util.QiniuUtils;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.UUID;

@RestController
@ConfigurationProperties(prefix = "qiniu.address")
@Data
public class UploadController {

    @Autowired
    private QiniuUtils qiniuUtils;
//    @RequestMapping("/uploadImg")
//    public Result uploadImg(@RequestParam(name = "img")MultipartFile multipartFile) throws IOException {
//        String s = UUID.randomUUID() +"."+ multipartFile.getOriginalFilename();
//        qiniuUtils.upload2Qiniu(multipartFile.getBytes(),s);
//        return Result.succ(s);
//    }
    @RequestMapping("/uploadContentImg")
    public Result uploadContentImg(@RequestParam(name = "blogImg")MultipartFile multipartFile) throws IOException {

        String s = UUID.randomUUID() + multipartFile.getOriginalFilename();
        return Result.succ(qiniuUtils.upload2Qiniu(multipartFile.getBytes(),s));
    }
}
