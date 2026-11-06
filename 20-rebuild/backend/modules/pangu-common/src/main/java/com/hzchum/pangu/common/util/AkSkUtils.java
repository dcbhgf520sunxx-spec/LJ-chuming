package com.hzchum.pangu.common.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;
import java.util.Map.Entry;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

public class AkSkUtils {
   private static final String HASH_ALGORITHM = "HmacSHA256";
   private static final String SIGN_SEP = "\n";
   private static final String DEFAULT_ENCODING = "UTF-8";
   private static final String SERVER_NAME = "tender_bid_chum";
   private static final String[] chars = new String[]{
      "a",
      "b",
      "c",
      "d",
      "e",
      "f",
      "g",
      "h",
      "i",
      "j",
      "k",
      "l",
      "m",
      "n",
      "o",
      "p",
      "q",
      "r",
      "s",
      "t",
      "u",
      "v",
      "w",
      "x",
      "y",
      "z",
      "0",
      "1",
      "2",
      "3",
      "4",
      "5",
      "6",
      "7",
      "8",
      "9",
      "A",
      "B",
      "C",
      "D",
      "E",
      "F",
      "G",
      "H",
      "I",
      "J",
      "K",
      "L",
      "M",
      "N",
      "O",
      "P",
      "Q",
      "R",
      "S",
      "T",
      "U",
      "V",
      "W",
      "X",
      "Y",
      "Z"
   };

   private static String getAppKey() {
      StringBuilder shortBuffer = new StringBuilder();
      String uuid = UUID.randomUUID().toString().replace("-", "");

      for (int i = 0; i < 8; i++) {
         String str = uuid.substring(i * 4, i * 4 + 4);
         int x = Integer.parseInt(str, 16);
         shortBuffer.append(chars[x % 62]);
      }

      return shortBuffer.toString();
   }

   private static String getAppSecret(String appKey) {
      try {
         String[] array = new String[]{appKey, getAppKey()};
         StringBuilder sb = new StringBuilder();
         Arrays.sort(array);

         for (String anArray : array) {
            sb.append(anArray);
         }

         String str = sb.toString();
         MessageDigest md = MessageDigest.getInstance("SHA-1");
         md.update(str.getBytes());
         byte[] digest = md.digest();
         StringBuilder hexStr = new StringBuilder();

         for (byte aDigest : digest) {
            String shaHex = Integer.toHexString(aDigest & 255);
            if (shaHex.length() < 2) {
               hexStr.append(0);
            }

            hexStr.append(shaHex);
         }

         hexStr.append("tender_bid_chum");
         return hexStr.toString();
      } catch (NoSuchAlgorithmException e) {
         e.printStackTrace();
         throw new RuntimeException();
      }
   }

   private static String stringToSign(Map<String, String[]> headers) {
      TreeMap<String, String> cannibalizedHeaders = new TreeMap<>();
      List<String> temp = new ArrayList<>();

      for (Entry<String, String[]> entry : headers.entrySet()) {
         String key = entry.getKey();
         if ("chum-key".equalsIgnoreCase(key) || "timestamp".equalsIgnoreCase(key)) {
            if (entry.getValue().length == 0) {
               cannibalizedHeaders.put(key.toLowerCase(), null);
            }

            for (String value : entry.getValue()) {
               if (value != null) {
                  temp.add(value.trim());
                  cannibalizedHeaders.put(key.toLowerCase(), join(temp));
               }

               temp.clear();
            }
         }
      }

      StringBuilder stringToSign = new StringBuilder();

      for (Entry<String, String> entry : cannibalizedHeaders.entrySet()) {
         if (entry.getValue() == null) {
            stringToSign.append(entry.getKey()).append(":").append("\n");
         } else {
            stringToSign.append(entry.getKey()).append(":").append(entry.getValue()).append("\n");
         }
      }

      return stringToSign.toString();
   }

   private static String join(List<?> items) {
      StringBuilder sb = new StringBuilder();

      for (int i = 0; i < items.size(); i++) {
         String item = items.get(i).toString();
         sb.append(item);
         if (i < items.size() - 1) {
            sb.append(",");
         }
      }

      return sb.toString();
   }

   private static String genEncryptString(String stringToSign, String appSecret) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
      Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
      byte[] keyBytes = appSecret.getBytes("UTF-8");
      SecretKeySpec secret_key = new SecretKeySpec(keyBytes, 0, keyBytes.length, "HmacSHA256");
      sha256_HMAC.init(secret_key);
      return new String(Base64.encodeBase64(sha256_HMAC.doFinal(stringToSign.getBytes("UTF-8"))));
   }

   public static String headerSignature(Map<String, String[]> headers, String appSecret) throws Exception {
      String stringToSign = stringToSign(headers);
      return genEncryptString(stringToSign, appSecret);
   }
}
