package com.gc.msagateway.msa.filter;

import com.gc.msagateway.msa.config.JwtProperties;
import com.gc.msagateway.msa.config.RouteProperties;
import com.gc.msagateway.msa.pojo.UserInfo;
import com.gc.msagateway.msa.utils.CookieUtils;
import com.gc.msagateway.msa.utils.JwtUtils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;

/**
 * @author GC
 */
@EnableConfigurationProperties({JwtProperties.class, RouteProperties.class})
@Component
public class LoginFilter extends ZuulFilter {

    @Autowired
    private JwtProperties jwtProperties;

    @Autowired
    private RouteProperties routeProperties;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 00;
    }

    @Override
    public boolean shouldFilter() {
        List<String> allowPaths = routeProperties.getAllowPaths();
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        StringBuffer requestURL = request.getRequestURL();
        String s = requestURL.toString();
        for (String allowPath : allowPaths) {
            if(StringUtils.contains(s,allowPath)){//s是否包含allowPath
                return false;//在白名单中直接放行
            }
        }
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();

        String invoicing_token1 = request.getHeader("Authorization");
        int i = invoicing_token1.indexOf(" ");
        String invoicing_token = invoicing_token1.substring(i);

        //String invoicing_token = CookieUtils.getCookieValue(request, "INVOICING_TOKEN");
        String servletPath1 = request.getServletPath();

        if (StringUtils.isBlank(invoicing_token)) {
            //拦截
            currentContext.setSendZuulResponse(false);//不转发
            currentContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());//返回状态
        }
        //解析
        try {
            String servletPath = request.getServletPath();
            //System.out.println(servletPath);
            UserInfo infoFromToken = JwtUtils.getInfoFromToken(invoicing_token, jwtProperties.getPublicKey());
            //System.out.println(infoFromToken);
        } catch (Exception e) {
            //解析失败就拦截
            e.printStackTrace();
            currentContext.setSendZuulResponse(false);//不转发
            currentContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());//返回状态
        }
        //放行
        return null;
    }
}
