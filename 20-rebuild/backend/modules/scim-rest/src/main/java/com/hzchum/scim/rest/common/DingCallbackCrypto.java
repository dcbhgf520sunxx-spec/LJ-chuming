package com.hzchum.scim.rest.common;

import com.alibaba.fastjson.JSON;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.Security;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

public class DingCallbackCrypto {
   private static final Charset CHARSET = Charset.forName("utf-8");
   private static final Base64 base64 = new Base64();
   private byte[] aesKey;
   private String token;
   private String corpId;
   private static final Integer AES_ENCODE_KEY_LENGTH = 43;
   private static final Integer RANDOM_LENGTH = 16;

   public DingCallbackCrypto(String token, String encodingAesKey, String corpId) throws DingCallbackCrypto.DingTalkEncryptException {
      if (null != encodingAesKey && encodingAesKey.length() == AES_ENCODE_KEY_LENGTH) {
         this.token = token;
         this.corpId = corpId;
         this.aesKey = Base64.decodeBase64(encodingAesKey + "=");
      } else {
         throw new DingCallbackCrypto.DingTalkEncryptException(900004);
      }
   }

   public Map<String, String> getEncryptedMap(String plaintext) throws DingCallbackCrypto.DingTalkEncryptException {
      return this.getEncryptedMap(plaintext, System.currentTimeMillis(), DingCallbackCrypto.Utils.getRandomStr(16));
   }

   public Map<String, String> getEncryptedMap(String plaintext, Long timeStamp, String nonce) throws DingCallbackCrypto.DingTalkEncryptException {
      if (null == plaintext) {
         throw new DingCallbackCrypto.DingTalkEncryptException(900001);
      }

      if (null == timeStamp) {
         throw new DingCallbackCrypto.DingTalkEncryptException(900002);
      }

      if (null == nonce) {
         throw new DingCallbackCrypto.DingTalkEncryptException(900003);
      }

      String encrypt = this.encrypt(DingCallbackCrypto.Utils.getRandomStr(RANDOM_LENGTH), plaintext);
      String signature = this.getSignature(this.token, String.valueOf(timeStamp), nonce, encrypt);
      Map<String, String> resultMap = new HashMap<>();
      resultMap.put("msg_signature", signature);
      resultMap.put("encrypt", encrypt);
      resultMap.put("timeStamp", String.valueOf(timeStamp));
      resultMap.put("nonce", nonce);
      return resultMap;
   }

   public String getDecryptMsg(String msgSignature, String timeStamp, String nonce, String encryptMsg) throws DingCallbackCrypto.DingTalkEncryptException {
      String signature = this.getSignature(this.token, timeStamp, nonce, encryptMsg);
      if (!signature.equals(msgSignature)) {
         throw new DingCallbackCrypto.DingTalkEncryptException(900006);
      } else {
         return this.decrypt(encryptMsg);
      }
   }

   private String encrypt(String random, String plaintext) throws DingCallbackCrypto.DingTalkEncryptException {
      try {
         byte[] randomBytes = random.getBytes(CHARSET);
         byte[] plainTextBytes = plaintext.getBytes(CHARSET);
         byte[] lengthByte = DingCallbackCrypto.Utils.int2Bytes(plainTextBytes.length);
         byte[] corpidBytes = this.corpId.getBytes(CHARSET);
         ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
         byteStream.write(randomBytes);
         byteStream.write(lengthByte);
         byteStream.write(plainTextBytes);
         byteStream.write(corpidBytes);
         byte[] padBytes = DingCallbackCrypto.PKCS7Padding.getPaddingBytes(byteStream.size());
         byteStream.write(padBytes);
         byte[] unencrypted = byteStream.toByteArray();
         byteStream.close();
         Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
         SecretKeySpec keySpec = new SecretKeySpec(this.aesKey, "AES");
         IvParameterSpec iv = new IvParameterSpec(this.aesKey, 0, 16);
         cipher.init(1, keySpec, iv);
         byte[] encrypted = cipher.doFinal(unencrypted);
         return base64.encodeToString(encrypted);
      } catch (Exception e) {
         throw new DingCallbackCrypto.DingTalkEncryptException(900007);
      }
   }

   private String decrypt(String text) throws DingCallbackCrypto.DingTalkEncryptException {
      byte[] originalArr;
      try {
         Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
         SecretKeySpec keySpec = new SecretKeySpec(this.aesKey, "AES");
         IvParameterSpec iv = new IvParameterSpec(Arrays.copyOfRange(this.aesKey, 0, 16));
         cipher.init(2, keySpec, iv);
         byte[] encrypted = Base64.decodeBase64(text);
         originalArr = cipher.doFinal(encrypted);
      } catch (Exception e) {
         throw new DingCallbackCrypto.DingTalkEncryptException(900008);
      }

      String plainText;
      String fromCorpid;
      try {
         byte[] bytes = DingCallbackCrypto.PKCS7Padding.removePaddingBytes(originalArr);
         byte[] networkOrder = Arrays.copyOfRange(bytes, 16, 20);
         int plainTextLegth = DingCallbackCrypto.Utils.bytes2int(networkOrder);
         plainText = new String(Arrays.copyOfRange(bytes, 20, 20 + plainTextLegth), CHARSET);
         fromCorpid = new String(Arrays.copyOfRange(bytes, 20 + plainTextLegth, bytes.length), CHARSET);
      } catch (Exception e) {
         throw new DingCallbackCrypto.DingTalkEncryptException(900009);
      }

      if (!fromCorpid.equals(this.corpId)) {
         throw new DingCallbackCrypto.DingTalkEncryptException(900010);
      } else {
         return plainText;
      }
   }

   public String getSignature(String token, String timestamp, String nonce, String encrypt) throws DingCallbackCrypto.DingTalkEncryptException {
      try {
         String[] array = new String[]{token, timestamp, nonce, encrypt};
         Arrays.sort(array);
         System.out.println(JSON.toJSONString(array));
         StringBuffer sb = new StringBuffer();

         for (int i = 0; i < 4; i++) {
            sb.append(array[i]);
         }

         String str = sb.toString();
         System.out.println(str);
         MessageDigest md = MessageDigest.getInstance("SHA-1");
         md.update(str.getBytes());
         byte[] digest = md.digest();
         StringBuffer hexstr = new StringBuffer();
         String shaHex = "";

         for (int i = 0; i < digest.length; i++) {
            shaHex = Integer.toHexString(digest[i] & 255);
            if (shaHex.length() < 2) {
               hexstr.append(0);
            }

            hexstr.append(shaHex);
         }

         return hexstr.toString();
      } catch (Exception e) {
         throw new DingCallbackCrypto.DingTalkEncryptException(900006);
      }
   }

   private static void RemoveCryptographyRestrictions() throws Exception {
      Class<?> jceSecurity = getClazz("javax.crypto.JceSecurity");
      Class<?> cryptoPermissions = getClazz("javax.crypto.CryptoPermissions");
      Class<?> cryptoAllPermission = getClazz("javax.crypto.CryptoAllPermission");
      if (jceSecurity != null) {
         setFinalStaticValue(jceSecurity, "isRestricted", false);
         PermissionCollection defaultPolicy = getFieldValue(jceSecurity, "defaultPolicy", null, PermissionCollection.class);
         if (cryptoPermissions != null) {
            Map<?, ?> map = getFieldValue(cryptoPermissions, "perms", defaultPolicy, Map.class);
            map.clear();
         }

         if (cryptoAllPermission != null) {
            Permission permission = getFieldValue(cryptoAllPermission, "INSTANCE", null, Permission.class);
            defaultPolicy.add(permission);
         }
      }
   }

   private static Class<?> getClazz(String className) {
      Class clazz = null;

      try {
         clazz = Class.forName(className);
      } catch (Exception var3) {
      }

      return clazz;
   }

   private static void setFinalStaticValue(Class<?> srcClazz, String fieldName, Object newValue) throws Exception {
      Field field = srcClazz.getDeclaredField(fieldName);
      field.setAccessible(true);
      Field modifiersField = Field.class.getDeclaredField("modifiers");
      modifiersField.setAccessible(true);
      modifiersField.setInt(field, field.getModifiers() & -17);
      field.set(null, newValue);
   }

   private static <T> T getFieldValue(Class<?> srcClazz, String fieldName, Object owner, Class<T> dstClazz) throws Exception {
      Field field = srcClazz.getDeclaredField(fieldName);
      field.setAccessible(true);
      return dstClazz.cast(field.get(owner));
   }

   static {
      try {
         Security.setProperty("crypto.policy", "limited");
         RemoveCryptographyRestrictions();
      } catch (Exception var1) {
      }
   }

   public static class DingTalkEncryptException extends Exception {
      public static final int SUCCESS = 0;
      public static final int ENCRYPTION_PLAINTEXT_ILLEGAL = 900001;
      public static final int ENCRYPTION_TIMESTAMP_ILLEGAL = 900002;
      public static final int ENCRYPTION_NONCE_ILLEGAL = 900003;
      public static final int AES_KEY_ILLEGAL = 900004;
      public static final int SIGNATURE_NOT_MATCH = 900005;
      public static final int COMPUTE_SIGNATURE_ERROR = 900006;
      public static final int COMPUTE_ENCRYPT_TEXT_ERROR = 900007;
      public static final int COMPUTE_DECRYPT_TEXT_ERROR = 900008;
      public static final int COMPUTE_DECRYPT_TEXT_LENGTH_ERROR = 900009;
      public static final int COMPUTE_DECRYPT_TEXT_CORPID_ERROR = 900010;
      private static Map<Integer, String> msgMap = new HashMap<>();
      private Integer code;

      public Integer getCode() {
         return this.code;
      }

      public DingTalkEncryptException(Integer exceptionCode) {
         super(msgMap.get(exceptionCode));
         this.code = exceptionCode;
      }

      static {
         msgMap.put(0, "成功");
         msgMap.put(900001, "加密明文文本非法");
         msgMap.put(900002, "加密时间戳参数非法");
         msgMap.put(900003, "加密随机字符串参数非法");
         msgMap.put(900005, "签名不匹配");
         msgMap.put(900006, "签名计算失败");
         msgMap.put(900004, "不合法的aes key");
         msgMap.put(900007, "计算加密文字错误");
         msgMap.put(900008, "计算解密文字错误");
         msgMap.put(900009, "计算解密文字长度不匹配");
         msgMap.put(900010, "计算解密文字corpid不匹配");
      }
   }

   public static class PKCS7Padding {
      private static final Charset CHARSET = Charset.forName("utf-8");
      private static final int BLOCK_SIZE = 32;

      public static byte[] getPaddingBytes(int count) {
         int amountToPad = 32 - count % 32;
         if (amountToPad == 0) {
            amountToPad = 32;
         }

         char padChr = chr(amountToPad);
         String tmp = new String();

         for (int index = 0; index < amountToPad; index++) {
            tmp = tmp + padChr;
         }

         return tmp.getBytes(CHARSET);
      }

      public static byte[] removePaddingBytes(byte[] decrypted) {
         int pad = decrypted[decrypted.length - 1];
         if (pad < 1 || pad > 32) {
            pad = 0;
         }

         return Arrays.copyOfRange(decrypted, 0, decrypted.length - pad);
      }

      private static char chr(int a) {
         byte target = (byte)(a & 0xFF);
         return (char)target;
      }
   }

   public static class Utils {
      public static String getRandomStr(int count) {
         String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
         Random random = new Random();
         StringBuffer sb = new StringBuffer();

         for (int i = 0; i < count; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
         }

         return sb.toString();
      }

      public static byte[] int2Bytes(int count) {
         return new byte[]{(byte)(count >> 24 & 0xFF), (byte)(count >> 16 & 0xFF), (byte)(count >> 8 & 0xFF), (byte)(count & 0xFF)};
      }

      public static int bytes2int(byte[] byteArr) {
         int count = 0;

         for (int i = 0; i < 4; i++) {
            count <<= 8;
            count |= byteArr[i] & 255;
         }

         return count;
      }
   }
}
