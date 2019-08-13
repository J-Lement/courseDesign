package com.nchu.hospital_system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.nchu.hospital_system")
@MapperScan(value = "com.nchu.hospital_system.mapper")
public class HospitalSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalSystemApplication.class, args);
    }

}
