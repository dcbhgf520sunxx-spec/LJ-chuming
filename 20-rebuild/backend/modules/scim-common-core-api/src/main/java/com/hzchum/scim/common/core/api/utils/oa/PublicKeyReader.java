package com.hzchum.scim.common.core.api.utils.oa;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

public class PublicKeyReader {
   public static PublicKey get(String filename) throws Exception {
      FileInputStream fis = new FileInputStream(new File(filename));
      PublicKey pk = get(fis);
      fis.close();
      return pk;
   }

   public static PublicKey getFromBase64(String filename) throws Exception {
      FileInputStream fis = new FileInputStream(new File(filename));
      PublicKey pk = getFromBase64(fis);
      fis.close();
      return pk;
   }

   public static PublicKey getFromBase64String(String publicKeyString) throws Exception {
      InputStream is = new ByteArrayInputStream(publicKeyString.getBytes());
      return getFromBase64(is);
   }

   public static PublicKey get(InputStream input) throws Exception {
      ByteArrayOutputStream os = new ByteArrayOutputStream();
      IOUtils.copy(input, os);
      byte[] keyBytes = os.toByteArray();
      X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
      KeyFactory kf = KeyFactory.getInstance("RSA");
      return kf.generatePublic(spec);
   }

   public static PublicKey getFromBase64(InputStream input) throws Exception {
      ByteArrayOutputStream os = new ByteArrayOutputStream();
      IOUtils.copy(input, os);
      byte[] keyBytes = os.toByteArray();
      byte[] ks = Base64.decodeBase64(keyBytes);
      X509EncodedKeySpec spec = new X509EncodedKeySpec(ks);
      KeyFactory kf = KeyFactory.getInstance("RSA");
      return kf.generatePublic(spec);
   }
}
