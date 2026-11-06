package com.hzchum.scim.plan.core.api.util;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.PutObjectRequest;
import com.google.common.base.Preconditions;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OssUtils {
   @Value("${endpoint}")
   private String endpoint;
   @Value("${accessKeyId}")
   private String accessKeyId;
   @Value("${accessKeySecret}")
   private String accessKeySecret;
   @Value("${bucketName}")
   private String bucketName;
   @Value("${ljaps.storage.public-base-url:}")
   private String publicBaseUrl;
   @Value("${ljaps.storage.local:false}")
   private boolean localStorage;
   @Value("${chum.config.filePath}")
   private String localFilePath;
   private static String END_POINT;
   private static String ACCESS_KEY_ID;
   private static String ACCESS_KEY_SECRET;
   private static String BUCKET_NAME;

   @PostConstruct
   private void init() {
      END_POINT = this.endpoint;
      ACCESS_KEY_ID = this.accessKeyId;
      ACCESS_KEY_SECRET = this.accessKeySecret;
      BUCKET_NAME = this.bucketName;
   }

   public OSS openClient() {
      if (this.localStorage) {
         return null;
      }
      return new OSSClientBuilder().build(END_POINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
   }

   public String uploadFile(OSS client, String ossRelativePath, String localAbsolutePath) {
      if (this.localStorage) {
         try {
            Path source = Paths.get(localAbsolutePath).toRealPath();
            Path base = this.localBase();
            Preconditions.checkArgument(source.startsWith(base) && Files.isRegularFile(source), "本地上传源文件不在文件目录内");
            try (InputStream input = Files.newInputStream(source)) {
               return this.uploadLocal(ossRelativePath, input);
            }
         } catch (IOException e) {
            throw new IllegalStateException("本地对象文件读取失败", e);
         }
      }
      String fileUrl = this.remoteObjectUrl(ossRelativePath);
      Preconditions.checkArgument(client.doesBucketExist(BUCKET_NAME), BUCKET_NAME + "存储空间不存在!");
      PutObjectRequest putObjectRequest = new PutObjectRequest(BUCKET_NAME, ossRelativePath, new File(localAbsolutePath));
      client.putObject(putObjectRequest);
      return fileUrl;
   }

   public String uploadFile(OSS client, String ossRelativePath, InputStream inputStream) {
      if (this.localStorage) {
         return this.uploadLocal(ossRelativePath, inputStream);
      }
      String fileUrl = this.remoteObjectUrl(ossRelativePath);
      Preconditions.checkArgument(client.doesBucketExist(BUCKET_NAME), BUCKET_NAME + "存储空间不存在!");
      PutObjectRequest putObjectRequest = new PutObjectRequest(BUCKET_NAME, ossRelativePath, inputStream);
      client.putObject(putObjectRequest);
      return fileUrl;
   }

   private String remoteObjectUrl(String key) {
      boolean explicitBase = this.publicBaseUrl != null && !this.publicBaseUrl.trim().isEmpty();
      String value = explicitBase ? this.publicBaseUrl.trim() : END_POINT;
      Preconditions.checkArgument(value != null && !value.trim().isEmpty(), "OSS访问地址未配置");
      if (!explicitBase && !value.contains("://")) {
         value = "https://" + value;
      }
      try {
         URI base = new URI(value);
         Preconditions.checkArgument(
            ("https".equalsIgnoreCase(base.getScheme()) || "http".equalsIgnoreCase(base.getScheme()))
               && base.getHost() != null && base.getUserInfo() == null && base.getRawQuery() == null && base.getRawFragment() == null,
            "OSS访问地址必须是无账号、查询参数和片段的HTTP(S)地址"
         );
         if (!explicitBase) {
            Preconditions.checkArgument(base.getPath() == null || base.getPath().isEmpty() || "/".equals(base.getPath()), "OSS endpoint不能包含路径");
            Preconditions.checkArgument(BUCKET_NAME != null && !BUCKET_NAME.isEmpty(), "OSS存储空间未配置");
            base = new URI(base.getScheme(), null, BUCKET_NAME + "." + base.getHost(), base.getPort(), null, null, null);
         }
         String baseUrl = base.toASCIIString();
         while (baseUrl.endsWith("/")) {
            baseUrl = baseUrl.substring(0, baseUrl.length() - 1);
         }
         return baseUrl + "/" + key;
      } catch (URISyntaxException e) {
         throw new IllegalArgumentException("OSS访问地址格式不正确", e);
      }
   }

   public void deleteFile(OSS client, String ossRelativePath) {
      if (this.localStorage) {
         try {
            Files.deleteIfExists(this.localObject(ossRelativePath, false));
            return;
         } catch (IOException e) {
            throw new IllegalStateException("本地对象文件删除失败", e);
         }
      }
      client.deleteObject(BUCKET_NAME, ossRelativePath);
   }

   public void downLoad(OSS client, String ossRelativePath) {
      if (this.localStorage) {
         try (InputStream input = Files.newInputStream(this.localObject(ossRelativePath, false))) {
            return;
         } catch (IOException e) {
            throw new IllegalStateException("本地对象文件读取失败", e);
         }
      }
      client.getObject(new GetObjectRequest(BUCKET_NAME, ossRelativePath));
   }

   public void closeClient(OSS client) {
      if (client != null) {
         client.shutdown();
      }
   }

   private Path localBase() throws IOException {
      Path base = Paths.get(this.localFilePath).toAbsolutePath().normalize();
      Preconditions.checkArgument(!Files.isSymbolicLink(base), "本地文件目录不能是符号链接");
      Files.createDirectories(base);
      return base.toRealPath();
   }

   private Path localObject(String key, boolean createParents) throws IOException {
      Preconditions.checkArgument(key != null && !key.isEmpty() && key.indexOf('\\') < 0 && key.indexOf(':') < 0, "本地对象文件路径非法");
      Path relative = Paths.get(key);
      Preconditions.checkArgument(!relative.isAbsolute(), "本地对象文件路径必须是相对路径");
      for (Path part : relative) {
         Preconditions.checkArgument(!part.toString().equals("..") && !part.toString().equals("."), "本地对象文件路径不能包含跳转目录");
      }
      Path root = this.localBase().resolve("oss");
      Path target = root.resolve(relative).normalize();
      Preconditions.checkArgument(target.startsWith(root) && !target.equals(root), "本地对象文件路径越界");
      Path current = root;
      Path parent = target.getParent();
      while (true) {
         Preconditions.checkArgument(!Files.isSymbolicLink(current), "本地对象文件路径不能包含符号链接");
         if (Files.exists(current, LinkOption.NOFOLLOW_LINKS)) {
            Preconditions.checkArgument(Files.isDirectory(current, LinkOption.NOFOLLOW_LINKS), "本地对象文件父路径不是目录");
         } else if (createParents) {
            Files.createDirectory(current);
         }
         if (current.equals(parent)) {
            break;
         }
         current = current.resolve(current.relativize(parent).getName(0));
      }
      Preconditions.checkArgument(!Files.isSymbolicLink(target), "本地对象文件不能是符号链接");
      return target;
   }

   private String uploadLocal(String key, InputStream input) {
      Path temporary = null;
      try {
         Path target = this.localObject(key, true);
         temporary = Files.createTempFile(target.getParent(), ".upload-", ".tmp");
         Files.copy(input, temporary, StandardCopyOption.REPLACE_EXISTING);
         try {
            Files.move(temporary, target, StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);
         } catch (AtomicMoveNotSupportedException e) {
            Files.move(temporary, target, StandardCopyOption.REPLACE_EXISTING);
         }
         return new URI(null, null, "/files/oss/" + key, null).toASCIIString();
      } catch (IOException | URISyntaxException e) {
         throw new IllegalStateException("本地对象文件写入失败", e);
      } finally {
         if (temporary != null) {
            try {
               Files.deleteIfExists(temporary);
            } catch (IOException e) {
               throw new IllegalStateException("本地对象临时文件清理失败", e);
            }
         }
      }
   }

   public static void main(String[] args) {
      String END_POINT = java.util.Objects.requireNonNull(System.getenv("LJAPS_OSS_ENDPOINT"), "LJAPS_OSS_ENDPOINT is required");
      String ACCESS_KEY_ID = java.util.Objects.requireNonNull(System.getenv("LJAPS_OSS_ACCESS_KEY_ID"), "LJAPS_OSS_ACCESS_KEY_ID is required");
      String ACCESS_KEY_SECRET = java.util.Objects.requireNonNull(System.getenv("LJAPS_OSS_ACCESS_KEY_SECRET"), "LJAPS_OSS_ACCESS_KEY_SECRET is required");
      String BUCKET_NAME = java.util.Objects.requireNonNull(System.getenv("LJAPS_OSS_BUCKET_NAME"), "LJAPS_OSS_BUCKET_NAME is required");
      OSS client = new OSSClientBuilder().build(END_POINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);

      try {
         client.setBucketAcl(BUCKET_NAME, CannedAccessControlList.PublicRead);
      } catch (OSSException oe) {
         System.out.println("Caught an OSSException, which means your request made it to OSS, but was rejected with an error response for some reason.");
         System.out.println("Error Message:" + oe.getErrorMessage());
         System.out.println("Error Code:" + oe.getErrorCode());
         System.out.println("Request ID:" + oe.getRequestId());
         System.out.println("Host ID:" + oe.getHostId());
      } catch (ClientException ce) {
         System.out
            .println(
               "Caught an ClientException, which means the client encountered a serious internal problem while trying to communicate with OSS, such as not being able to access the network."
            );
         System.out.println("Error Message:" + ce.getMessage());
      } finally {
         if (client != null) {
            client.shutdown();
         }
      }
   }
}
