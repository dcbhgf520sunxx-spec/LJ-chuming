package com.hzchum.scim.system.core.api.common.utils;

import com.google.common.base.Preconditions;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.Objects;
import javax.servlet.http.HttpServletResponse;
import org.springframework.util.CollectionUtils;

public class ArgumentCheckUtils {
   private ArgumentCheckUtils() {
   }

   public static void checkNonNull(Object object, String message) {
      Preconditions.checkArgument(Objects.nonNull(object), message);
   }

   public static void checkIsNull(Object object, String message) {
      Preconditions.checkArgument(Objects.isNull(object), message);
   }

   public static void checkNotEmptyCollection(Collection<?> collection, String message) {
      Preconditions.checkArgument(!CollectionUtils.isEmpty(collection), message);
   }

   public static Boolean checkArgumentImportForm(Boolean result, String message, HttpServletResponse response) {
      if (!result) {
         try {
            response.setHeader("result", "code=50000;message=" + URLEncoder.encode(message, "UTF-8"));
            response.setHeader("Access-Control-Expose-Headers", "result");
         } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
         }

         return true;
      } else {
         return false;
      }
   }
}
