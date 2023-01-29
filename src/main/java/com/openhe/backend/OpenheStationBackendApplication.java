package com.openhe.backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.openhe.backend.mapper")
public class OpenheStationBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(OpenheStationBackendApplication.class, args);
    }
}
