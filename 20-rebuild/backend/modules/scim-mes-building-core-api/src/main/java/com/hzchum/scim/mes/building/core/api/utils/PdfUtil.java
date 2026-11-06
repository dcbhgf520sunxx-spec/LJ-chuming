package com.hzchum.scim.mes.building.core.api.utils;

import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.get.PdfUtilDTO;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PdfUtil {
   private static final Logger log = LoggerFactory.getLogger(PdfUtil.class);

   public static void main(String[] args) {
      try {
         downLoadFromUrl(
            "https://dfzximg02.dftoutiao.com/minimodify/20230412/640x473_64369fcc143a1_mwpm_03201609.jpeg", "aswde.jpeg", "C:\\Users\\admin\\Desktop\\围护原型"
         );
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public static String mergePdf(List<PdfUtilDTO> pdfUtilDTOS, String targetPath) {
      FileUtil.mkdirs(targetPath);

      for (PdfUtilDTO dto : pdfUtilDTOS) {
         try {
            downLoadFromUrl(dto.getHttpUrl(), dto.getFileName(), targetPath);
         } catch (IOException e) {
            Preconditions.checkArgument(false, "云端图纸下载失败");
         }
      }

      List<File> files = new ArrayList<>();

      for (PdfUtilDTO pdfUtilDTO : pdfUtilDTOS) {
         File file = new File(targetPath + pdfUtilDTO.getFileName());
         files.add(file);
      }

      try {
         modifyFileContent(files, targetPath + "scheduling.pdf");
      } catch (IOException e) {
         Preconditions.checkArgument(false, "pdf合并失败");
      }

      System.gc();
      return targetPath + "scheduling.pdf";
   }

   public static void modifyFileContent(List<File> files, String targetPath) throws IOException {
      log.info(targetPath);
      PDFMergerUtility mergePdf = new PDFMergerUtility();

      for (File f : files) {
         if (f.exists() && f.isFile()) {
            mergePdf.addSource(f);
         }
      }

      mergePdf.setDestinationFileName(targetPath);
      mergePdf.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
   }

   public static void downLoadFromUrl(String urlStr, String fileName, String savePath) throws IOException {
      URL url = new URL(urlStr);
      HttpURLConnection conn = (HttpURLConnection)url.openConnection();
      conn.setConnectTimeout(10000);
      conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
      InputStream inputStream = conn.getInputStream();
      byte[] getData = readInputStream(inputStream);
      File saveDir = new File(savePath);
      if (!saveDir.exists()) {
         boolean mkdir = saveDir.mkdirs();
         System.out.println(mkdir);
      }

      File file = new File(saveDir + File.separator + fileName);
      FileOutputStream fos = new FileOutputStream(file);
      fos.write(getData);
      if (fos != null) {
         fos.close();
      }

      if (inputStream != null) {
         inputStream.close();
      }
   }

   public static byte[] readInputStream(InputStream inputStream) throws IOException {
      byte[] buffer = new byte[1024];
      int len = 0;
      ByteArrayOutputStream bos = new ByteArrayOutputStream();

      while ((len = inputStream.read(buffer)) != -1) {
         bos.write(buffer, 0, len);
      }

      bos.close();
      return bos.toByteArray();
   }
}
