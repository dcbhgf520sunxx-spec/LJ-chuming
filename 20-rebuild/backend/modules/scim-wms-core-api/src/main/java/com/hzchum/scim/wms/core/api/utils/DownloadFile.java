package com.hzchum.scim.wms.core.api.utils;

import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.scim.common.core.api.config.ConfigProperties;
import com.hzchum.scim.common.core.api.enums.AttachmentTypeEnum;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class DownloadFile {
   @Resource
   private ConfigProperties configProperties;

   public String downloadFile(String fileURL, String fileName) {
      String folderPath = this.configProperties.getFilePath();
      String dirName = AttachmentTypeEnum.getNameByType(900) + File.separator;
      FileUtil.mkdirs(this.configProperties.getFilePath() + dirName);
      String saveFilePath = folderPath + dirName + fileName;

      try {
         URL url = new URL(fileURL);
         HttpURLConnection httpConn = (HttpURLConnection)url.openConnection();
         int responseCode = httpConn.getResponseCode();
         if (responseCode == 200) {
            InputStream inputStream = httpConn.getInputStream();
            OutputStream outputStream = new FileOutputStream(saveFilePath);
            byte[] buffer = new byte[4096];
            int bytesRead = -1;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
               outputStream.write(buffer, 0, bytesRead);
            }

            outputStream.close();
            inputStream.close();
            return dirName + fileName;
         }

         System.out.println("服务器响应代码：" + responseCode);
      } catch (Exception e) {
         e.printStackTrace();
      }

      return null;
   }
}
