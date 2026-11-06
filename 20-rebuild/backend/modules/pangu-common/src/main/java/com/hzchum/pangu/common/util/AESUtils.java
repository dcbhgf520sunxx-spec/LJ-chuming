package com.hzchum.pangu.common.util;

import cn.hutool.core.codec.Base64;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AESUtils {
   private static final String algorithm = "AES";
   private static final String cipher = "AES/ECB/PKCS5Padding";

   public static String encrypt(String key, String password) {
      try {
         SecretKey deskey = new SecretKeySpec(Base64.decode(key), "AES");
         Cipher c1 = Cipher.getInstance("AES/ECB/PKCS5Padding");
         c1.init(1, deskey);
         byte[] biff = c1.doFinal(password.getBytes());
         return Base64.encode(biff);
      } catch (Exception e) {
         e.printStackTrace();
         return null;
      }
   }

   public static String decrypt(String key, String password) {
      try {
         SecretKey deskey = new SecretKeySpec(Base64.decode(key), "AES");
         Cipher c1 = Cipher.getInstance("AES/ECB/PKCS5Padding");
         c1.init(2, deskey);
         return new String(c1.doFinal(Base64.decode(password)));
      } catch (Exception e1) {
         e1.printStackTrace();
         return null;
      }
   }

   public static String generateKey() {
      try {
         SecureRandom sr = new SecureRandom();
         KeyGenerator kg = KeyGenerator.getInstance("AES");
         kg.init(sr);
         SecretKey secretKey = kg.generateKey();
         return Base64.encode(secretKey.getEncoded());
      } catch (NoSuchAlgorithmException e) {
         e.printStackTrace();
         return null;
      }
   }
}
