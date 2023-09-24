package com.example.study.core.config;

import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Xss过滤配置属性
 * @Author YouZhi
 * @Date 2023 - 09 - 24 - 11:30
 */
@ConfigurationProperties(prefix = "study.xss")
public record XssProperties(Boolean enabled, List<String> excludes) {

}
