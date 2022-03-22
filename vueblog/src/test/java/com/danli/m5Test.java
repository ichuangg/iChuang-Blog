package com.danli;

import cn.hutool.crypto.SecureUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class m5Test {

    @Test
    void t1(){
        String s = SecureUtil.md5("ichuang");
        System.out.println(s);
    }

}
