package com.hzchum.pangu.common.util;

import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.enums.FileTypeEnum;
import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
   private static final Logger LOGGER = LoggerFactory.getLogger(FileUtil.class);

   private FileUtil() {
   }

   public static boolean mkdirs(String dirPath) {
      File file = new File(dirPath);
      return !file.exists() ? file.mkdirs() : true;
   }

   public static boolean saveFile(InputStream inputStream, String targetFilePath) {
      File targetFile = new File(targetFilePath);
      return copyInputStreamToFile(inputStream, targetFile);
   }

   public static boolean copyInputStreamToFile(InputStream inputStream, File file) {
      try (OutputStream outputStream = new FileOutputStream(file)) {
         byte[] bytes = new byte[1024];

         int len;
         while ((len = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);
         }

         return true;
      } catch (IOException e) {
         LOGGER.error("Save file failed");
         return false;
      }
   }

   public static boolean deleteFile(String filePath) {
      File file = new File(filePath);
      return file.exists() ? file.delete() : false;
   }

   public static boolean deleteDir(String dirPath) {
      File file = new File(dirPath);
      if (file.exists() && file.isDirectory()) {
         String[] childFilePath = file.list();
         if (childFilePath != null) {
            for (String aChildFilePath : childFilePath) {
               boolean result = deleteFile(dirPath + File.separator + aChildFilePath);
               if (!result) {
                  return false;
               }
            }
         }
      }

      return file.delete();
   }

   public static String getFileExtension(String fileName) {
      Assert.notNull(fileName, "文件名称不能为空");
      String[] fileNameParts = org.apache.commons.lang3.StringUtils.split(fileName, ".");
      if (fileNameParts.length == 0) {
         return "";
      }

      int index = fileNameParts.length - 1;
      return fileNameParts[index];
   }

   public static String bytesToHex(byte[] src) {
      StringBuilder stringBuilder = new StringBuilder();
      if (src != null && src.length > 0) {
         for (int i = 0; i < src.length; i++) {
            int v = src[i] & 255;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
               stringBuilder.append(0);
            }

            stringBuilder.append(hv);
         }

         return stringBuilder.toString();
      } else {
         return null;
      }
   }

   public static Boolean isImage(InputStream fis) {
      byte[] b = new byte[4];

      try {
         fis.read(b, 0, b.length);
         String type = bytesToHex(b).toUpperCase();
         return type.contains(FileTypeEnum.JPEG.getValue())
            || type.contains(FileTypeEnum.PNG.getValue())
            || type.contains(FileTypeEnum.GIF.getValue())
            || type.contains(FileTypeEnum.BMP.getValue());
      } catch (IOException e) {
         LOGGER.error("file read failed", e);
         e.printStackTrace();
         return false;
      }
   }

   public static Boolean checkType(MultipartFile file, List<String> fileTypes) {
      if (CollectionUtils.isEmpty(fileTypes)) {
         return false;
      }

      byte[] b = new byte[4];
      InputStream fis = null;

      try {
         fis = file.getInputStream();
         fis.read(b, 0, b.length);
         String type = Objects.requireNonNull(bytesToHex(b)).toUpperCase();
         return fileTypes.stream().anyMatch(type::contains);
      } catch (IOException e) {
         LOGGER.error("file read failed", e);
      } finally {
         if (fis != null) {
            try {
               fis.close();
            } catch (IOException e) {
               LOGGER.error("file close failed", e);
            }
         }
      }

      return false;
   }

   public static void downloadFile(String filePath) {
      File file = new File(filePath);
      String fileName = file.getName();
      downloadFile(file, fileName);
   }

   public static void downloadFile(File file, String fileName) {
      ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
      HttpServletResponse response = servletRequestAttributes.getResponse();

      try (
         InputStream inputStream = new FileInputStream(file);
         OutputStream outputStream = response.getOutputStream();
      ) {
         response.setContentType("apply/octet-stream;charset=UTF-8");
         response.setContentLengthLong(file.length());
         if (fileName.contains("_")) {
            String timeStamp = fileName.split("_")[0];
            fileName = fileName.replaceFirst(timeStamp + "_", "");
         }

         response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
         response.setHeader("Access-Control-Expose-Headers", "*");
         byte[] bytes = new byte[1024];

         int length;
         while ((length = inputStream.read(bytes)) > 0) {
            outputStream.write(bytes, 0, length);
         }
      } catch (IOException e) {
         LOGGER.error("文件下载失败", e);
         throw new BusinessException(ResultCodeEnum.ERROR, "文件下载失败");
      }
   }

   public static String transformLowercaseSuffix(String fileName) {
      String[] split = org.apache.commons.lang3.StringUtils.split(fileName, ".");
      Preconditions.checkArgument(split != null && split.length >= 2, "文件名称格式不正确");
      split[split.length - 1] = split[split.length - 1].toLowerCase();
      return org.apache.commons.lang3.StringUtils.join(split, ".");
   }

   public static List<String> unzipFile(File file, String targetPath) throws IOException {
      Preconditions.checkArgument(file != null && file.getName().endsWith(".zip"), "请传入zip格式压缩文件!");
      List<String> fileNameList = new ArrayList<>();
      FileOutputStream fos = null;
      InputStream is = null;

      try (ZipFile zipFile = new ZipFile(file, Charset.forName("gbk"))) {
         Enumeration<?> entries = zipFile.entries();

         while (entries.hasMoreElements()) {
            ZipEntry entry = (ZipEntry)entries.nextElement();
            if (!entry.isDirectory()) {
               System.out.println("解压>>>>>>>>>>>>" + entry.getName());
               String fileName = entry.getName().substring(entry.getName().lastIndexOf("/") + 1);
               fileName = transformLowercaseSuffix(fileName);
               fileNameList.add(fileName);
               File targetFile = new File(targetPath + fileName);
               is = zipFile.getInputStream(entry);
               fos = new FileOutputStream(targetFile);
               byte[] buf = new byte[1024];

               int len;
               while ((len = is.read(buf)) != -1) {
                  fos.write(buf, 0, len);
               }
            }
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         if (fos != null) {
            fos.close();
         }

         if (is != null) {
            is.close();
         }
      }

      return fileNameList;
   }

   public static String charset(String path) {
      String charset = "GBK";
      byte[] first3Bytes = new byte[3];

      try {
         boolean checked = false;
         BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
         bis.mark(0);
         int read = bis.read(first3Bytes, 0, 3);
         if (read == -1) {
            bis.close();
            return charset;
         }

         if (first3Bytes[0] == -1 && first3Bytes[1] == -2) {
            charset = "UTF-16LE";
            checked = true;
         } else if (first3Bytes[0] == -2 && first3Bytes[1] == -1) {
            charset = "UTF-16BE";
            checked = true;
         } else if (first3Bytes[0] == -17 && first3Bytes[1] == -69 && first3Bytes[2] == -65) {
            charset = "UTF-8";
            checked = true;
         }

         bis.reset();
         if (!checked) {
            while ((read = bis.read()) != -1 && read < 240 && (128 > read || read > 191)) {
               if (192 <= read && read <= 223) {
                  read = bis.read();
                  if (128 > read || read > 191) {
                     break;
                  }
               } else if (224 <= read && read <= 239) {
                  read = bis.read();
                  if (128 <= read && read <= 191) {
                     read = bis.read();
                     if (128 <= read && read <= 191) {
                        charset = "UTF-8";
                     }
                  }
                  break;
               }
            }
         }

         bis.close();
      } catch (Exception e) {
         e.printStackTrace();
      }

      return charset;
   }

   public static String copyFile(String oldFilePath, String newFilePath) {
      File oldFile = new File(oldFilePath);
      File newFile = new File(newFilePath);
      boolean bool = oldFile.renameTo(newFile);
      Preconditions.checkArgument(bool, "文件生成失败!!!");
      return newFile.getPath();
   }
}
