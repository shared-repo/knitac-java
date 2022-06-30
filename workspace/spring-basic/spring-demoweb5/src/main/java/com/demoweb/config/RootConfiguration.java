package com.demoweb.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = { "com.demoweb.mapper" })
public class RootConfiguration {

}
