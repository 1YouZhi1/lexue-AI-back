package com.example.study.core.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.*;
/**
 * 跨域配置属性
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 11 - 20:09
 */
@ConfigurationProperties(prefix = "study.cors")
public record CorsProperties(List<String> allowOrigins) {

}
