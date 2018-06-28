package com.c4tman.play.design.pattern.frs;


import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhangxiaoman on 2018/6/28.
 */
public class Utils {
    public static String getRealIp(HttpServletRequest request){
        String ip = request.getHeader("X-Real-IP");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Forwarded-For");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip != null && ip.indexOf(":") >= 0) { // 判断是否为IPV6地址
            ip = "127.0.0.1";
        }
        return ip;
    }

    public static String getStoreKey(String ip, String className, String methodName, String keyWord){
        StringBuilder key = new StringBuilder().append(ip).append(className).append(methodName);
        if(StringUtils.isNotEmpty(keyWord)){
            key.append(key);
        }
        return DigestUtils.md5Hex(key.toString());
    }
}
