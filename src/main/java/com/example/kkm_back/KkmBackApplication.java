package com.example.kkm_back;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = {"com.example.kkm_back.Mapper"})
public class KkmBackApplication {
    public static void main(String[] args) {
        SpringApplication.run(KkmBackApplication.class, args);
    }
}