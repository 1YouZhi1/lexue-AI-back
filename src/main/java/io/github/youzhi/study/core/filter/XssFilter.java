package io.github.youzhi.study.core.filter;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import io.github.youzhi.study.core.config.XssProperties;
import io.github.youzhi.study.wrapper.XssHttpServletRequestWrapper;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Xss过滤链
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 24 - 11:34
 */
@Component
@ConditionalOnProperty(value = "study.xss.enabled", havingValue = "true")
@WebFilter(urlPatterns = "/*", filterName = "xssFilter")
@EnableConfigurationProperties(value = {XssProperties.class})
@RequiredArgsConstructor
public class XssFilter implements Filter {

    private final XssProperties xssProperties;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        if (handleExcludeUrl(req)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        XssHttpServletRequestWrapper xssRequest = new XssHttpServletRequestWrapper(
                (HttpServletRequest) servletRequest);
        filterChain.doFilter(xssRequest, servletResponse);
    }

    private boolean handleExcludeUrl(HttpServletRequest request) {
        if (CollectionUtils.isEmpty(xssProperties.excludes())) {
            return false;
        }
        String url = request.getServletPath();
        for (String pattern : xssProperties.excludes()) {
            Pattern p = Pattern.compile("^" + pattern);
            Matcher m = p.matcher(url);
            if (m.find()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}