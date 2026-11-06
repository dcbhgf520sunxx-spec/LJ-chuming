package com.hzchum.pangu.common.util;

import com.google.common.base.Preconditions;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZiPFileUtil {
   private static final Logger LOGGER = LoggerFactory.getLogger(ZiPFileUtil.class);
   private static final int BUFFER_SIZE = 2048;

   private ZiPFileUtil() {
   }

   public static void compress(File sourceFile, ZipOutputStream zos, String name, boolean KeepDirStructure) throws Exception {
      byte[] buf = new byte[2048];
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
                  compress(file, zos, name + "/" + file.getName(), true);
               } else {
                  compress(file, zos, file.getName(), false);
               }
            }
         } else if (KeepDirStructure) {
            zos.putNextEntry(new ZipEntry(name + "/"));
            zos.closeEntry();
         }
      }
   }

   public static void DownAndReadFile(String filePath, String dir) {
      File saverPath = new File(dir);
      if (!saverPath.exists()) {
         Preconditions.checkArgument(saverPath.mkdirs(), "指定目录创建失败");
      }

      String[] urlName = filePath.split("/");
      int len = urlName.length - 1;
      String fileName = urlName[len];

      try {
         File file = new File(saverPath + "//" + fileName);
         if (!file.exists()) {
            Preconditions.checkArgument(file.createNewFile(), "创建临时文件失败");
         }

         BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
         URL url = new URL(filePath);
         HttpURLConnection uc = (HttpURLConnection)url.openConnection();
         uc.setDoInput(true);
         uc.connect();
         InputStream inputStream = uc.getInputStream();
         byte[] b = new byte[4096];

         int byteRead;
         while ((byteRead = inputStream.read(b)) != -1) {
            bufferedOutputStream.write(b, 0, byteRead);
         }

         inputStream.close();
         bufferedOutputStream.close();
         BufferedInputStream fs = new BufferedInputStream(new FileInputStream(saverPath + "//" + fileName));
         BufferedReader br = new BufferedReader(new InputStreamReader(fs, "UTF-8"));
         br.close();
         fs.close();
         unZipUnCompress(dir + "/" + fileName, dir + "/");
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public static void unZipUnCompress(String inputFile, String destDirPath) {
      File srcFile = new File(inputFile);

      try {
         if (!srcFile.exists()) {
            throw new Exception(srcFile.getPath() + "所指文件不存在");
         }

         ZipFile zipFile = new ZipFile(srcFile);
         Enumeration<?> entries = zipFile.entries();

         while (entries.hasMoreElements()) {
            ZipEntry entry = (ZipEntry)entries.nextElement();
            if (entry.isDirectory()) {
               Preconditions.checkArgument(srcFile.mkdirs(), "创建文件夹失败!!!");
            } else {
               File targetFile = new File(destDirPath + "/" + entry.getName());
               if (!targetFile.getParentFile().exists()) {
                  Preconditions.checkArgument(targetFile.getParentFile().mkdirs(), "创建父目录失败!!!");
               }

               Preconditions.checkArgument(targetFile.createNewFile(), "创建文件失败!!!");
               InputStream is = zipFile.getInputStream(entry);
               FileOutputStream fos = new FileOutputStream(targetFile);
               byte[] buf = new byte[1024];

               int len;
               while ((len = is.read(buf)) != -1) {
                  fos.write(buf, 0, len);
               }

               fos.close();
               is.close();
            }
         }

         zipFile.close();
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         Preconditions.checkArgument(srcFile.delete(), "删除临时压缩文件失败");
      }
   }
}
