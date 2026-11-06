package com.hzchum.scim.common.core.api.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.springframework.stereotype.Component;

@Component
public class JsonCompressionUtil {
   public static String compressJson(String json) {
      if (json != null && !json.isEmpty()) {
         ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

         try (JsonCompressionUtil.CustomGZIPOutputStream gzipOutputStream = new JsonCompressionUtil.CustomGZIPOutputStream(outputStream, true)) {
            gzipOutputStream.write(json.getBytes("UTF-8"));
         } catch (Exception e) {
            e.printStackTrace();
         }

         return Base64.getEncoder().encodeToString(outputStream.toByteArray());
      } else {
         return json;
      }
   }

   public static String decompressJson(String compressedJson) throws IOException {
      if (compressedJson != null && compressedJson.length() != 0) {
         byte[] compressedData = Base64.getDecoder().decode(compressedJson);
         ByteArrayInputStream in = new ByteArrayInputStream(compressedData);
         ByteArrayOutputStream out = new ByteArrayOutputStream();

         try (GZIPInputStream gzip = new GZIPInputStream(in)) {
            byte[] buffer = new byte[4096];

            int len;
            while ((len = gzip.read(buffer)) > 0) {
               out.write(buffer, 0, len);
            }
         }

         return out.toString(StandardCharsets.UTF_8.name());
      } else {
         return compressedJson;
      }
   }

   private static class CustomGZIPOutputStream extends GZIPOutputStream {
      public CustomGZIPOutputStream(ByteArrayOutputStream out, boolean syncFlush) throws IOException {
         super(out, syncFlush);

         this.def.setLevel(9);
      }
   }
}
