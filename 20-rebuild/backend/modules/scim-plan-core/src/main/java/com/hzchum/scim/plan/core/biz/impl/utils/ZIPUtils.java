package com.hzchum.scim.plan.core.biz.impl.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZIPUtils {
   private static final byte[] buf = new byte[1024];

   public static Boolean toZip(String zipFileName, String sourceFileName, boolean KeepDirStructure) {
      Boolean result = true;
      long start = System.currentTimeMillis();
      ZipOutputStream zos = null;

      try {
         FileOutputStream fileOutputStream = new FileOutputStream(zipFileName);
         zos = new ZipOutputStream(fileOutputStream);
         File sourceFile = new File(sourceFileName);
         compress(sourceFile, zos, sourceFile.getName(), KeepDirStructure);
         long var9 = System.currentTimeMillis();
      } catch (Exception e) {
         result = false;
         e.printStackTrace();
      } finally {
         if (zos != null) {
            try {
               zos.close();
            } catch (IOException e) {
               e.getStackTrace();
            }
         }
      }

      return result;
   }

   public static void compress(File sourceFile, ZipOutputStream zos, String name, boolean KeepDirStructure) throws Exception {
      if (sourceFile.isFile()) {
         zos.putNextEntry(new ZipEntry(name));
         FileInputStream in = new FileInputStream(sourceFile);

         int len;
         while ((len = in.read(buf)) != -1) {
            zos.write(buf, 0, len);
         }

         zos.closeEntry();
         in.close();
      } else {
         File[] listFiles = sourceFile.listFiles();
         if (listFiles != null && listFiles.length != 0) {
            for (File file : listFiles) {
               if (KeepDirStructure) {
                  compress(file, zos, name + "/" + file.getName(), KeepDirStructure);
               } else {
                  compress(file, zos, file.getName(), KeepDirStructure);
               }
            }
         } else if (KeepDirStructure) {
            zos.putNextEntry(new ZipEntry(name + "/"));
            zos.closeEntry();
         }
      }
   }
}
