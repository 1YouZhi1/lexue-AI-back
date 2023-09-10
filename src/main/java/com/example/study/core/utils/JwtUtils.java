package com.example.study.core.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * Jwt工具类
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 10 - 18:48
 */
@Slf4j
@Component
public class JwtUtils {

    /**
     * 注入JWT加密密匙
     */
    @Value("${study.jwt.secret}")
    private String secret;

    /**
     * 定义系统标识头常量
     */
    private static final String HEADER_SYSTEM_KEY = "systemKey";

    /**
     * 根据用户ID生成JWT
     * @param id  用户ID
     * @param systemKey  系统标识
     * @return JWT
     */
    public String generateToken(Long id, String systemKey){
        return Jwts.builder()
                .setHeaderParam(HEADER_SYSTEM_KEY, systemKey)
                .setSubject(id.toString())
                .signWith(Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8)))
                .compact();
    }

    /**
     * 解析JWT返回用户ID
     * @param token JWT
     * @param systemKey 系统标识
     * @return 用户ID
     */
    public Long parseToken(String token, String systemKey){
        Jws<Claims> claimsJws;
        try {
            claimsJws = Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8)))
                    .build()
                    .parseClaimsJws(token);
            if(Objects.equals(claimsJws.getHeader().get(HEADER_SYSTEM_KEY), systemKey)){
                return Long.parseLong(claimsJws.getBody().getSubject());
            }
        }catch (JwtException e){
            log.warn("JWT解析失败: { }", token);
        }
        return null;
    }
}
