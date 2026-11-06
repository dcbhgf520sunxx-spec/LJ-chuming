package com.hzchum.scim.common.core.api.utils.oa;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

public class PrivateKeyReader {
   public static PrivateKey get(String filename) throws Exception {
      FileInputStream fis = new FileInputStream(new File(filename));
      PrivateKey pk = get(fis);
      fis.close();
      return pk;
   }

   public static PrivateKey getFromBase64(String filename) throws Exception {
      FileInputStream fis = new FileInputStream(new File(filename));
      PrivateKey pk = getFromBase64(fis);
      fis.close();
      return pk;
   }

   public static PrivateKey get(InputStream input) throws Exception {
      ByteArrayOutputStream os = new ByteArrayOutputStream();
      IOUtils.copy(input, os);
      byte[] keyBytes = os.toByteArray();
      PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
      KeyFactory kf = KeyFactory.getInstance("RSA");
      return kf.generatePrivate(spec);
   }

   public static PrivateKey getFromBase64(InputStream input) throws Exception {
      ByteArrayOutputStream os = new ByteArrayOutputStream();
      IOUtils.copy(input, os);
      byte[] keyBytes = os.toByteArray();
      byte[] ks = Base64.decodeBase64(keyBytes);
      PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(ks);
      KeyFactory kf = KeyFactory.getInstance("RSA");
      return kf.generatePrivate(spec);
   }
}
