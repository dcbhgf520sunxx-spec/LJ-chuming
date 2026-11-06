package com.hzchum.pangu.common.util;

import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpUrlUtils {
   private static final Logger log = LoggerFactory.getLogger(HttpUrlUtils.class);

   public static String doPostWithSignature(String url_tb, String info, String appKey, String timestamp, String signature) {
      OutputStreamWriter out = null;
      HttpURLConnection conn = null;
      BufferedReader in = null;

      try {
         Map<String, String> header = new HashMap<>();
         header.put("accept", "*/*");
         header.put("connection", "Keep-Alive");
         header.put("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
         header.put("Content-Type", "application/json");
         header.put("timestamp", timestamp);
         header.put("sign", signature);
         header.put("chum-key", appKey);
         StringBuilder result = new StringBuilder();
         URL url = new URL(url_tb);
         conn = (HttpURLConnection)url.openConnection();
         conn.setDoOutput(true);
         conn.setDoInput(true);
         conn.setRequestMethod("POST");
         conn.setUseCaches(false);
         conn.setRequestProperty("Charset", "UTF-8");
         conn.setConnectTimeout(30000);
         conn.setReadTimeout(30000);

         for (String key : header.keySet()) {
            conn.setRequestProperty(key, header.get(key));
         }

         out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
         out.write(info);
         out.flush();
         int code = conn.getResponseCode();
         if (code == 200) {
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
         } else {
            in = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
         }

         String line;
         while ((line = in.readLine()) != null) {
            result.append(line);
         }

         return result.toString();
      } catch (Exception e) {
         throw new BusinessException(ResultCodeEnum.INTERFACE_ERROR);
      } finally {
         try {
            if (conn != null) {
               conn.disconnect();
            }

            if (out != null) {
               out.close();
            }

            if (in != null) {
               in.close();
            }
         } catch (IOException ex) {
            ex.printStackTrace();
         }
      }
   }

   public static String doPostWithParamHeader(String NCUrl, Map<String, String> paramMap, Map<String, String> headerMap, String info, String mediaType) {
      OutputStreamWriter out = null;
      HttpURLConnection conn = null;
      BufferedReader in = null;
      StringBuilder params = new StringBuilder();
      if (paramMap != null && !paramMap.isEmpty()) {
         for (Entry<String, String> entry : paramMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            String s = key + "=" + value + "&";
            params.append(s);
         }
      }

      try {
         Map<String, String> header = new HashMap<>();
         header.put("accept", "*/*");
         header.put("connection", "Keep-Alive");
         header.put("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
         header.put("Content-Type", mediaType);
         if (headerMap != null && !headerMap.isEmpty()) {
            for (Entry<String, String> entry : headerMap.entrySet()) {
               header.put(entry.getKey(), entry.getValue());
            }
         }

         StringBuilder result = new StringBuilder();
         URL url = new URL(NCUrl);
         conn = (HttpURLConnection)url.openConnection();
         conn.setDoOutput(true);
         conn.setDoInput(true);
         conn.setRequestMethod("POST");
         conn.setUseCaches(false);
         conn.setRequestProperty("Charset", "UTF-8");
         conn.setConnectTimeout(30000);
         conn.setReadTimeout(30000);

         for (String key : header.keySet()) {
            conn.setRequestProperty(key, header.get(key));
         }

         out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
         if (paramMap != null) {
            for (Entry<String, String> entry : paramMap.entrySet()) {
               header.put(entry.getKey(), entry.getValue());
            }
         }

         if (org.apache.commons.lang3.StringUtils.isNotBlank(params)) {
            out.write(params.toString());
         }

         if (org.apache.commons.lang3.StringUtils.isNotBlank(info)) {
            out.write(info);
         }

         out.flush();
         int code = conn.getResponseCode();
         if (code == 200) {
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
         } else {
            in = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
         }

         String line;
         while ((line = in.readLine()) != null) {
            result.append(line);
         }

         return result.toString();
      } catch (Exception e) {
         e.printStackTrace();
         throw new BusinessException(e.getMessage());
      } finally {
         try {
            if (conn != null) {
               conn.disconnect();
            }

            if (out != null) {
               out.close();
            }

            if (in != null) {
               in.close();
            }
         } catch (IOException ex) {
            ex.printStackTrace();
         }
      }
   }
}
