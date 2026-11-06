package com.hzchum.scim.rest.controller.cut.lantek;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import java.io.File;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Oss {
   @Value("${accessKeyId}")
   private String accessKeyId;
   @Value("${accessKeySecret}")
   private String accessKeySecret;

   public String upFile(String bucketName, String key, String path) {
      String endpoint = "https://oss-cn-hangzhou.aliyuncs.com";
      OSS ossClient = new OSSClientBuilder().build(endpoint, this.accessKeyId, this.accessKeySecret);
      PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, new File(path));
      String filePath = "https://" + bucketName + ".oss-cn-hangzhou.aliyuncs.com" + key;
      PutObjectResult putObjectResult = ossClient.putObject(putObjectRequest);
      System.out.println(putObjectResult.getVersionId());
      ossClient.shutdown();
      return filePath;
   }
}
