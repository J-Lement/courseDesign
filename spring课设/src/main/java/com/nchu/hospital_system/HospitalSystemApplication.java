package com.nchu.hospital_system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.nchu.hospital_system.mapper")
@SpringBootApplication
public class HospitalSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalSystemApplication.class, args);
    }
}
