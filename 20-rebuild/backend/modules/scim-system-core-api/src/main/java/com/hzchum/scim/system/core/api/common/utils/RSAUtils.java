package com.hzchum.scim.system.core.api.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.digest.DigestUtils;

public class RSAUtils {
   public static final String PRIVATE_KEY = localKey("LJAPS_SYSTEM_RSA_PRIVATE_KEY", "LJAPS_RSA_PRIVATE_KEY_PATH");
   public static final String PUBLIC_KEY = localKey("LJAPS_SYSTEM_RSA_PUBLIC_KEY", "LJAPS_RSA_PUBLIC_KEY_PATH");

   private static String localKey(String explicitName, String pathName) {
      String explicit = System.getenv(explicitName);
      if (explicit != null && !explicit.trim().isEmpty()) return explicit;
      String path = System.getenv(pathName);
      if (path == null || path.trim().isEmpty()) return null;
      try {
         String pem = new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(path)), StandardCharsets.UTF_8);
         return pem.replaceAll("-----BEGIN [^-]+-----|-----END [^-]+-----|\\s", "");
      } catch (java.io.IOException error) {
         throw new IllegalStateException("Cannot read configured reconstruction RSA key", error);
      }
   }
   public static final String UTF_8 = "UTF-8";
   public static final String AES_ALGORITHM = "AES/CFB/PKCS5Padding";
   public static final String RSA_ALGORITHM = "RSA/ECB/PKCS1Padding";
   public static final String RSA_ALGORITHM_NOPADDING = "RSA";

   public static String decryptReceivedData(PublicKey externalPublicKey, PrivateKey selfPrivateKey, String receiveData) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException, InvalidAlgorithmParameterException, DecoderException {
      Map<String, String> receivedMap = (Map<String, String>)JSON.parse(receiveData);
      String inputSign = receivedMap.get("sign");
      inputSign = decryptRSA(externalPublicKey, inputSign);
      String sign = sha256(receivedMap);
      if (!sign.equals(inputSign)) {
         System.out.println("input sign: " + inputSign + ", calculated sign: " + sign);
         return null;
      } else {
         String key = receivedMap.get("key");
         String salt = receivedMap.get("salt");
         key = decryptRSA(selfPrivateKey, key);
         salt = decryptRSA(selfPrivateKey, salt);
         String data = decryptAES(key, salt, receivedMap.get("data"));
         System.out.println("接收到的data内容：" + data);
         return data;
      }
   }

   public static String encryptSendData(PublicKey externalPublicKey, PrivateKey selfPrivateKey, JSONObject sendData) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
      String aesKeyWithBase64 = genRandomAesSecretKey();
      String aesIVWithBase64 = genRandomIV();
      String key = encryptRSA(externalPublicKey, aesKeyWithBase64);
      String salt = encryptRSA(externalPublicKey, aesIVWithBase64);
      System.out.println("发送的data内容：" + sendData.toJSONString());
      String cipherData = encryptAES(aesKeyWithBase64, aesIVWithBase64, sendData.toJSONString());
      Map<String, String> requestMap = new TreeMap<>();
      requestMap.put("key", key);
      requestMap.put("salt", salt);
      requestMap.put("data", cipherData);
      requestMap.put("source", "由接收方提供");
      String sign = sha256(requestMap);
      requestMap.put("sign", encryptRSA(selfPrivateKey, sign));
      JSONObject json = new JSONObject();
      json.putAll(requestMap);
      return json.toString();
   }

   private static String genRandomAesSecretKey() throws NoSuchAlgorithmException {
      KeyGenerator keyGen = KeyGenerator.getInstance("AES");
      keyGen.init(128);
      SecretKey secretKey = keyGen.generateKey();
      return Arrays.toString(Base64.getEncoder().encode(secretKey.getEncoded()));
   }

   private static String genRandomIV() {
      SecureRandom r = new SecureRandom();
      byte[] iv = new byte[16];
      r.nextBytes(iv);
      return Arrays.toString(Base64.getEncoder().encode(iv));
   }

   private static String encryptAES(String keyWithBase64, String ivWithBase64, String plainText) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, InvalidAlgorithmParameterException {
      byte[] keyWithBase64Arry = keyWithBase64.getBytes();
      byte[] ivWithBase64Arry = ivWithBase64.getBytes();
      SecretKeySpec key = new SecretKeySpec(Base64.getDecoder().decode(keyWithBase64Arry), "AES");
      IvParameterSpec iv = new IvParameterSpec(Base64.getDecoder().decode(ivWithBase64Arry));
      Cipher cipher = Cipher.getInstance("AES/CFB/PKCS5Padding");
      cipher.init(1, key, iv);
      return Arrays.toString(Base64.getEncoder().encode(cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8))));
   }

   private static String decryptAES(String keyWithBase64, String ivWithBase64, String cipherText) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, InvalidAlgorithmParameterException {
      byte[] keyWithBase64Arry = keyWithBase64.getBytes();
      byte[] ivWithBase64Arry = ivWithBase64.getBytes();
      byte[] cipherTextArry = cipherText.getBytes();
      SecretKeySpec key = new SecretKeySpec(Base64.getDecoder().decode(keyWithBase64Arry), "AES");
      IvParameterSpec iv = new IvParameterSpec(Base64.getDecoder().decode(ivWithBase64Arry));
      Cipher cipher = Cipher.getInstance("AES/CFB/PKCS5Padding");
      cipher.init(2, key, iv);
      return new String(cipher.doFinal(Base64.getDecoder().decode(cipherTextArry)), "UTF-8");
   }

   private static String encryptRSA(Key key, String plainText) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
      Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
      cipher.init(1, key);
      return Arrays.toString(Base64.getEncoder().encode(cipher.doFinal(plainText.getBytes("UTF-8"))));
   }

   private static String decryptRSA(Key key, String content) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException, InvalidAlgorithmParameterException {
      Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
      cipher.init(2, key);
      byte[] contentArry = content.getBytes();
      return new String(cipher.doFinal(Base64.getDecoder().decode(contentArry)), "UTF-8");
   }

   private static String sha256(Map<String, String> paramMap) {
      Map<String, String> params = new TreeMap<>(paramMap);
      StringBuilder concatStr = new StringBuilder();

      for (Entry<String, String> entry : params.entrySet()) {
         if (!"sign".equals(entry.getKey())) {
            concatStr.append(entry.getKey() + "=" + entry.getValue() + "&");
         }
      }

      return DigestUtils.md5Hex(concatStr.toString());
   }

   public static void createKeyPairs() throws NoSuchAlgorithmException {
      KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
      keyPairGenerator.initialize(2048);
      KeyPair keyPair = keyPairGenerator.generateKeyPair();
      RSAPublicKey publicKey = (RSAPublicKey)keyPair.getPublic();
      RSAPrivateKey privateKey = (RSAPrivateKey)keyPair.getPrivate();
      System.out.println("公钥" + Arrays.toString(Base64.getEncoder().encode(publicKey.getEncoded())));
      System.out.println("私钥" + Arrays.toString(Base64.getEncoder().encode(privateKey.getEncoded())));
   }

   public static String decryptRSADefault(String privateKeyStr, String data) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
      if (privateKeyStr == null || privateKeyStr.trim().isEmpty()) privateKeyStr = PRIVATE_KEY;
      KeyFactory keyFactory = KeyFactory.getInstance("RSA");
      byte[] privateKeyArray = privateKeyStr.getBytes();
      byte[] dataArray = data.getBytes();
      PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKeyArray));
      PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
      Cipher cipher = Cipher.getInstance("RSA");
      cipher.init(2, privateKey);
      return new String(cipher.doFinal(Base64.getDecoder().decode(dataArray)), StandardCharsets.UTF_8);
   }

   public static String encryptWithPublicKey(String message, String publicKeyStr) throws Exception {
      publicKeyStr = publicKeyStr.replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", "").replaceAll("\\s+", "");
      byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyStr);
      X509EncodedKeySpec spec = new X509EncodedKeySpec(publicKeyBytes);
      KeyFactory keyFactory = KeyFactory.getInstance("RSA");
      RSAPublicKey publicKey = (RSAPublicKey)keyFactory.generatePublic(spec);
      Cipher cipher = Cipher.getInstance("RSA");
      cipher.init(1, publicKey);
      byte[] encryptedBytes = cipher.doFinal(message.getBytes());
      return Base64.getEncoder().encodeToString(encryptedBytes);
   }

   public static String encryptWithPublicKey(String data) throws Exception {
      byte[] keyBytes;
      try {
         keyBytes = Base64.getDecoder()
            .decode(
               PUBLIC_KEY
            );
      } catch (IllegalArgumentException e) {
         throw new IllegalArgumentException("公钥格式错误，应该是Base64编码", e);
      }

      X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
      KeyFactory keyFactory = KeyFactory.getInstance("RSA");
      PublicKey publicKey = keyFactory.generatePublic(keySpec);
      Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
      cipher.init(1, publicKey);
      byte[] encryptedBytes = cipher.doFinal(data.getBytes("UTF-8"));
      return Base64.getEncoder().encodeToString(encryptedBytes);
   }
}
