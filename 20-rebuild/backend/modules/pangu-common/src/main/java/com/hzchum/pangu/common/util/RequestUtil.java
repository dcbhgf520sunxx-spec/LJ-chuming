package com.hzchum.pangu.common.util;

import com.alibaba.fastjson.JSONObject;
import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestUtil {
   private static final Logger log = LoggerFactory.getLogger(RequestUtil.class);

   public static JSONObject getRequestJsonObject(HttpServletRequest request) {
      String json = getRequestJsonString(request);
      return JSONObject.parseObject(json);
   }

   public static String getRequestJsonString(HttpServletRequest request) {
      String submitMehtod = request.getMethod();
      if (submitMehtod.equals("GET")) {
         try {
            return new String(request.getQueryString().getBytes("iso-8859-1"), "utf-8").replaceAll("%22", "\"");
         } catch (UnsupportedEncodingException e) {
            log.error("获取post请求参数错误", e);
            throw new BusinessException(ResultCodeEnum.INTERNAL_SERVER_ERROR);
         }
      } else {
         return getRequestPostStr(request);
      }
   }

   public static byte[] getRequestPostBytes(HttpServletRequest request) {
      try {
         int contentLength = request.getContentLength();
         if (contentLength < 0) {
            return null;
         }

         byte[] buffer = new byte[contentLength];
         int i = 0;

         while (i < contentLength) {
            int readlen = 0;
            readlen = request.getInputStream().read(buffer, i, contentLength - i);
            if (readlen == -1) {
               break;
            }

            i += readlen;
         }

         return buffer;
      } catch (IOException e) {
         log.error("获取post请求参数错误", e);
         throw new BusinessException(ResultCodeEnum.INTERNAL_SERVER_ERROR);
      }
   }

   public static String getRequestPostStr(HttpServletRequest request) {
      byte[] buffer = getRequestPostBytes(request);
      String charEncoding = request.getCharacterEncoding();
      if (charEncoding == null) {
         charEncoding = "UTF-8";
      }

      try {
         return new String(buffer, charEncoding);
      } catch (UnsupportedEncodingException e) {
         log.error("获取post请求参数错误", e);
         throw new BusinessException(ResultCodeEnum.INTERNAL_SERVER_ERROR);
      }
   }
}
