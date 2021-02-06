package com.zain.jo.linkedin.network_app.config.filter;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// have look at config class there are a filter bean
@Log4j2
@Component
public class DataAttacher implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        auth.getName();
        httpServletResponse.setHeader(
                "odeh-Example-Filter-Header#welcome", auth.getName());
        chain.doFilter(request, response);
    }

}
