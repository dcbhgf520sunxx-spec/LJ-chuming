package com.hzchum.scim.common.core.api.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

public class QRCodeUtil {
   public static void generateQRCodeImageWithText(String text, String topText, int width, int height, String filePath, int fontSize) throws WriterException, IOException {
      Map<EncodeHintType, Object> hints = new HashMap<>();
      hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
      hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
      BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);
      BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(bitMatrix, new MatrixToImageConfig());
      BufferedImage combined = new BufferedImage(width, height + 50, 2);
      Graphics2D g = (Graphics2D)combined.getGraphics();
      g.setColor(Color.WHITE);
      g.fillRect(0, 0, width, height + 50);
      g.setColor(Color.BLACK);
      Font font = new Font("SimHei", 0, fontSize);
      g.setFont(font);
      g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
      g.drawImage(qrImage, 0, 50, null);
      FontMetrics metrics = g.getFontMetrics(font);
      ArrayList<String> lines = new ArrayList<>();
      String currentLine = "";

      for (char character : topText.toCharArray()) {
         if (metrics.stringWidth(currentLine + character) < width) {
            currentLine = currentLine + character;
         } else {
            lines.add(currentLine);
            currentLine = "" + character;
         }
      }

      if (!currentLine.isEmpty()) {
         lines.add(currentLine);
      }

      int lineHeight = metrics.getHeight();
      int y = lineHeight;

      for (String lineText : lines) {
         int lineWidth = metrics.stringWidth(lineText);
         int x = (width - lineWidth) / 2;
         g.drawString(lineText, x, y);
         y += lineHeight;
      }

      g.dispose();
      ImageIO.write(combined, "PNG", new File(filePath));
   }

   public static void main(String[] args) {
      try {
         long start = System.currentTimeMillis();

         for (int i = 0; i < 10; i++) {
            generateQRCodeImageWithText("128|2|1", "姚文俊", 200, 200, "C:\\Users\\adminpvc\\Desktop\\ceshi\\QRCodeWithText" + i + ".png", 20);
         }

         long suhndj = System.currentTimeMillis();
         long l = (suhndj - start) / 1000L;
         System.out.println("批量二维码总用时" + l + "秒");
      } catch (WriterException e) {
         System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
      } catch (IOException e) {
         System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
      }
   }
}
