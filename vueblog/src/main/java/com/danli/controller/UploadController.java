package com.danli.controller;

import com.danli.common.lang.Result;
import com.danli.util.QiniuUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.UUID;

@RestController
public class UploadController {
    @RequestMapping("/uploadImg")
    public Result uploadImg(@RequestParam(name = "img")MultipartFile multipartFile) throws IOException {
        String s = UUID.randomUUID() +"."+ multipartFile.getOriginalFilename().split("\\.")[1];
        System.out.println(s);
        QiniuUtils.upload2Qiniu(multipartFile.getBytes(),s);
        return Result.succ(s);
    }
}
