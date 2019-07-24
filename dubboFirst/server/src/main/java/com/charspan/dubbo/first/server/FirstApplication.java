package com.charspan.dubbo.first.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(value = {"classpath:spring/spring-jdbc.xml", "classpath:spring/spring-dubbo.xml"})
@MapperScan(basePackages = "com.charspan.dubbo.first.model.mapper")
public class FirstApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(FirstApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(FirstApplication.class, args);
    }

}
