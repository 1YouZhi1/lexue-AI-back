package io.github.youzhi.study.core.common.utils;

import jakarta.servlet.http.HttpServletRequest;
import lombok.experimental.UtilityClass;

/**
 * @Author YouZhi
 * @Date 2023 - 09 - 11 - 8:36
 */
@UtilityClass
public class IpUtils {

    private static final String UNKNOWN_IP = "unknown";

    private static final String IP_SEPARATOR = "，";

    /**
     * 获取真实的 IP
     *
     * @param request
     * @return
     */
    public String getRealIp(HttpServletRequest request) {
        //这个一般是Nginx 反向代理设置的参数
        String ip = request.getHeader("X-Real-IP");
        if (ip == null || ip.length() == 0 || UNKNOWN_IP.equals(ip)){
            ip = request.getHeader("X-Forwarded-For");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN_IP.equals(ip)){
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN_IP.equals(ip)){
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN_IP.equals(ip)){
            ip = request.getRemoteAddr();
        }
        // 处理多IP情况
        if (ip != null && ip.contains(IP_SEPARATOR)){
            String[] ipArray = ip.split(IP_SEPARATOR);
            ip = ipArray[0];
        }
        return ip;
    }

}
