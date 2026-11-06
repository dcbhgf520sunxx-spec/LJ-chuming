package com.hzchum.scim.plan.core.api.util;

import com.google.common.base.Preconditions;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class PlanFileUtils {
   private static final String UPLOAD_DIR = "C:\\Users\\admibpvc\\Desktop\\diversity\\approve";

   public static void main(String[] args) throws IOException {
      new File("D:\\银山打字");
      String[] s = new String[]{"b.txt"};
      List<String> strings = Arrays.asList(s);
   }

   public static void copyFile(String a, String b) throws IOException {
      File file = new File(a);
      File file1 = new File(b);
      if (!file1.exists()) {
         file1.mkdirs();
      }

      if (file.isDirectory()) {
         File[] files = file.listFiles();
         if (files == null) {
            return;
         }

         for (File file2 : files) {
            Files.copy(file2.toPath(), Paths.get(file1.getPath() + File.separator + file2.getName()), StandardCopyOption.REPLACE_EXISTING);
         }
      }
   }

   public static void copyFile(String a, String b, List<String> unCopyList) throws IOException {
      File file = new File(a);
      File file1 = new File(b);
      if (!file1.exists()) {
         file1.mkdirs();
      }

      if (file.isDirectory()) {
         File[] files = file.listFiles();
         if (files == null) {
            return;
         }

         for (File file2 : files) {
            if (!unCopyList.contains(file2.getName())) {
               Files.copy(file2.toPath(), Paths.get(file1.getPath() + File.separator + file2.getName()), StandardCopyOption.REPLACE_EXISTING);
            }
         }
      }
   }

   public static void deleteDirectory(String filePath, List<String> names) {
      for (String name : names) {
         File file = new File(filePath + File.separator + name);
         if (file.exists()) {
            boolean delete = file.delete();
            if (!delete) {
               Preconditions.checkArgument(false, "文件删除失败,请联系管理员!!!");
            }
         }
      }
   }

   public static boolean deleteFolder(File folder) {
      if (!folder.exists()) {
         return true;
      }

      if (folder.isFile()) {
         return folder.delete();
      }

      File[] files = folder.listFiles();
      if (files != null) {
         for (File f : files) {
            if (f.isDirectory()) {
               deleteFolder(f);
            } else {
               boolean delete = f.delete();
               System.out.println(f.getName() + "删除" + delete);
            }
         }
      }

      return true;
   }

   public String saveFileAndGetUrl(MultipartFile file) throws IOException {
      if (file.isEmpty()) {
         throw new IllegalArgumentException("上传的文件不能为空");
      }

      String originalFilename = file.getOriginalFilename();
      String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
      String fileName = UUID.randomUUID().toString() + extension;
      String filePath = "C:\\Users\\admibpvc\\Desktop\\diversity\\approve" + File.separator + fileName;
      File dest = new File(filePath);

      try (FileOutputStream fos = new FileOutputStream(dest)) {
         fos.write(file.getBytes());
      }

      return Paths.get("C:\\Users\\admibpvc\\Desktop\\diversity\\approve", fileName).toString();
   }

   public static void moveFile(String sourcePath, String targetPath) throws Exception {
      Path source = Paths.get(sourcePath);
      Path target = Paths.get(targetPath);
      if (!Files.exists(source)) {
         throw new IllegalArgumentException("源文件不存在:" + sourcePath);
      }

      if (Files.isDirectory(source)) {
         throw new IllegalArgumentException("仅支持移动文件，不支持目录");
      }

      Path targetParent = target.getParent();
      if (!Files.exists(targetParent)) {
         Files.createDirectories(targetParent);
      }

      try {
         FileUtils.copyFile(new File(sourcePath), new File(targetPath));
         Files.deleteIfExists(source);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
