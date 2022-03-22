package com.danli;

import com.danli.util.QiniuUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

@SpringBootTest
public class qiniuTest {

    @Test
    void  t(){
        String s = "166841c6-1442-4898-8c71-b4629d308fec.jpg";
        QiniuUtils.deleteFileFromQiniu(s);
    }
}
