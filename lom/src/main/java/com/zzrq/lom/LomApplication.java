package com.zzrq.lom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.zzrq.lom.mapper")
public class LomApplication {

    public static void main(String[] args) {
        SpringApplication.run(LomApplication.class, args);
    }

}

