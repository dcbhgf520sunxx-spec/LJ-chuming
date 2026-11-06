package com.hzchum.pangu.common.util;

import com.hzchum.pangu.common.config.QiniuProperties;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import java.io.IOException;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class QiniuUtil {
   private static final Logger log = LoggerFactory.getLogger(QiniuUtil.class);
   @Resource
   QiniuProperties qiniuProperties;

   private Auth getAuth() {
      return Auth.create(this.qiniuProperties.getAccessKey(), this.qiniuProperties.getSecretKey());
   }

   private Configuration getConfiguration() {
      return new Configuration(Region.region2());
   }

   public String getUpToken(boolean isPrivate) {
      return this.getAuth()
         .uploadToken(
            isPrivate ? this.qiniuProperties.getPrivateBucketName() : this.qiniuProperties.getPublicBucketName(),
            null,
            this.qiniuProperties.getExpiration(),
            new StringMap()
               .put("callbackUrl", this.qiniuProperties.getCallBackUrl())
               .put(
                  "callbackBody",
                  "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"mimeType\":\"$(mimeType)\",\"endUser\":\"$(endUser)\",\"status\":\"$(status)\",\"md5\":\"$(md5)\",\"name\":\"$(x:name)\",\"path\":\"$(x:path)\",\"size\":\"$(x:size)\",\"type\":\"$(x:type)\"}"
               )
         );
   }

   public Response upload(String token, MultipartFile file, String fileName, String path, Integer type) {
      try {
         UploadManager uploadManager = new UploadManager(this.getConfiguration());
         return uploadManager.put(
            file.getInputStream(),
            path,
            token,
            new StringMap().put("x:name", fileName).put("x:path", path).put("x:size", file.getSize()).put("x:type", type),
            null
         );
      } catch (QiniuException e) {
         Response r = e.response;
         System.out.println(r.toString());

         try {
            System.out.println(r.bodyString());
         } catch (QiniuException var9) {
         }
      } catch (IOException e) {
         e.printStackTrace();
      }

      return null;
   }

   public String getUrl(boolean isPrivate, String path) {
      String url = null;
      if (isPrivate) {
         url = this.privateDownloadUrl(this.qiniuProperties.getPrivateDomain() + path);
      } else {
         url = this.qiniuProperties.getPublicDomain() + path;
      }

      return url;
   }

   public String privateDownloadUrl(String url) {
      return this.privateDownloadUrl(url, this.qiniuProperties.getExpiration());
   }

   public String privateDownloadUrl(String url, Long expiration) {
      return this.getAuth().privateDownloadUrl(url, expiration);
   }

   public FileInfo getFileInfo(String bucket, String key) {
      try {
         BucketManager bucketManager = new BucketManager(this.getAuth(), this.getConfiguration());
         return bucketManager.stat(bucket, key);
      } catch (Exception e) {
         e.printStackTrace();
         return null;
      }
   }

   public Response delete(String bucket, String key) {
      try {
         BucketManager bucketManager = new BucketManager(this.getAuth(), this.getConfiguration());
         return bucketManager.delete(bucket, key);
      } catch (Exception e) {
         e.printStackTrace();
         return null;
      }
   }

   public QiniuProperties getQiniuProperties() {
      return this.qiniuProperties;
   }

   public void setQiniuProperties(final QiniuProperties qiniuProperties) {
      this.qiniuProperties = qiniuProperties;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QiniuUtil)) {
         return false;
      }

      QiniuUtil other = (QiniuUtil)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$qiniuProperties = this.getQiniuProperties();
      Object other$qiniuProperties = other.getQiniuProperties();
      return this$qiniuProperties == null ? other$qiniuProperties == null : this$qiniuProperties.equals(other$qiniuProperties);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof QiniuUtil;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $qiniuProperties = this.getQiniuProperties();
      return result * 59 + ($qiniuProperties == null ? 43 : $qiniuProperties.hashCode());
   }

   @Override
   public String toString() {
      return "QiniuUtil(qiniuProperties=" + this.getQiniuProperties() + ")";
   }
}
