package com.zzrq.lom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author mo1451
 */
@SpringBootApplication
@MapperScan("com.zzrq.lom")
public class LomApplication {

    public static void main(String[] args) {
        SpringApplication.run(LomApplication.class, args);
    }

}

