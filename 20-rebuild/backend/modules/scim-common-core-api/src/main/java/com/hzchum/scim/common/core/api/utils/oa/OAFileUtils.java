package com.hzchum.scim.common.core.api.utils.oa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import org.apache.commons.io.IOUtils;

public class OAFileUtils {
   public static void writeStringToFile(File file, String data, Charset encoding) throws IOException {
      OutputStream out = null;

      try {
         out = openOutputStream(file, false);
         IOUtils.write(data, out, String.valueOf(encoding));
         out.close();
      } finally {
         IOUtils.closeQuietly(out);
      }
   }

   public static FileOutputStream openOutputStream(File file, boolean append) throws IOException {
      if (file.exists()) {
         if (file.isDirectory()) {
            throw new IOException("File '" + file + "' exists but is a directory");
         }

         if (!file.canWrite()) {
            throw new IOException("File '" + file + "' cannot be written to");
         }
      } else {
         File parent = file.getParentFile();
         if (parent != null && !parent.mkdirs() && !parent.isDirectory()) {
            throw new IOException("Directory '" + parent + "' could not be created");
         }
      }

      return new FileOutputStream(file, append);
   }

   public static String readFileToString(File file, Charset encoding) throws IOException {
      InputStream in = null;

      String var3;
      try {
         in = openInputStream(file);
         var3 = IOUtils.toString(in, String.valueOf(encoding == null ? Charset.defaultCharset() : encoding));
      } finally {
         IOUtils.closeQuietly(in);
      }

      return var3;
   }

   public static FileInputStream openInputStream(File file) throws IOException {
      if (file.exists()) {
         if (file.isDirectory()) {
            throw new IOException("File '" + file + "' exists but is a directory");
         } else if (!file.canRead()) {
            throw new IOException("File '" + file + "' cannot be read");
         } else {
            return new FileInputStream(file);
         }
      } else {
         throw new FileNotFoundException("File '" + file + "' does not exist");
      }
   }
}
