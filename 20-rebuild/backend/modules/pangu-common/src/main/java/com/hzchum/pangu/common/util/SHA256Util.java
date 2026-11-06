package com.hzchum.pangu.common.util;

import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import org.apache.commons.codec.binary.Base64;

public class SHA256Util {
   public static String getSha256Str(String str) {
      String encodeStr = "";

      try {
         MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
         messageDigest.update(str.getBytes(StandardCharsets.UTF_8));
         encodeStr = byte2Hex(messageDigest.digest());
      } catch (NoSuchAlgorithmException e) {
         e.printStackTrace();
      }

      return encodeStr;
   }

   private static String byte2Hex(byte[] bytes) {
      StringBuilder stringBuilder = new StringBuilder();

      for (byte aByte : bytes) {
         String temp = Integer.toHexString(aByte & 255);
         if (temp.length() == 1) {
            stringBuilder.append("0");
         }

         stringBuilder.append(temp);
      }

      return stringBuilder.toString();
   }

   public static PublicKey loadPubKey(String keyStr) throws Exception {
      X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.decodeBase64(keyStr));
      KeyFactory keyFactory = KeyFactory.getInstance("RSA");
      return keyFactory.generatePublic(keySpec);
   }

   public static String pubEncrypt(String source, PublicKey key) throws Exception {
      Cipher cipher = Cipher.getInstance("RSA");
      cipher.init(1, key);
      return Base64.encodeBase64String(cipher.doFinal(source.getBytes("utf8")));
   }
}
