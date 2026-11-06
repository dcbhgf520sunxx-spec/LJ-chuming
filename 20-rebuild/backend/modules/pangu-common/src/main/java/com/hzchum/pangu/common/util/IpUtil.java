package com.hzchum.pangu.common.util;

import javax.servlet.http.HttpServletRequest;

public class IpUtil {
   private static final String HEADER_X_FORWARDED_FOR = "x-forwarded-for";
   private static final String IP_UNKNOWN = "unknown";
   private static final String HEADER_PROXY_CLIENT_IP = "Proxy-Client-IP";
   private static final String HEADER_WL_PROXY_CLIENT_IP = "WL-Proxy-Client-IP";
   private static final String HEADER_HTTP_CLIENT_IP = "HTTP_CLIENT_IP";
   private static final String HEADER_HTTP_X_FORWARDED_FOR = "HTTP_X_FORWARDED_FOR";
   private static final String SEPARATOR_COMMA = ",";

   public static String getIpAddress(final HttpServletRequest request) {
      String ip = request.getHeader("x-forwarded-for");
      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
         ip = request.getHeader("Proxy-Client-IP");
      }

      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
         ip = request.getHeader("WL-Proxy-Client-IP");
      }

      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
         ip = request.getHeader("HTTP_CLIENT_IP");
      }

      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
         ip = request.getHeader("HTTP_X_FORWARDED_FOR");
      }

      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
         ip = request.getRemoteAddr();
      }

      if (ip != null && ip.contains(",")) {
         ip = ip.substring(0, ip.indexOf(",")).trim();
      }

      return ip;
   }
}
