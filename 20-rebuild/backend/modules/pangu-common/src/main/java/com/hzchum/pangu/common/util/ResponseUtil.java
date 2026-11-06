package com.hzchum.pangu.common.util;

import com.alibaba.fastjson.JSON;
import com.hzchum.pangu.common.enums.ResultCodeEnum;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

public class ResponseUtil {
   public static void render(HttpServletResponse response, ResultCodeEnum resultCodeEnum) throws IOException {
      response.setCharacterEncoding("UTF-8");
      response.setContentType("application/json; charset=utf-8");
      PrintWriter out = response.getWriter();
      out.write(JSON.toJSONString(ResultBuilder.failed(resultCodeEnum)));
      out.flush();
   }

   public static void render(HttpServletResponse response, String message) throws IOException {
      response.setCharacterEncoding("UTF-8");
      response.setContentType("application/json; charset=utf-8");
      PrintWriter out = response.getWriter();
      out.write(JSON.toJSONString(ResultBuilder.failed(message)));
      out.flush();
   }

   public static void success(HttpServletResponse response, Object data) throws IOException {
      response.setCharacterEncoding("UTF-8");
      response.setContentType("application/json; charset=utf-8");
      PrintWriter out = response.getWriter();
      out.write(JSON.toJSONString(ResultBuilder.success(data)));
   }
}
