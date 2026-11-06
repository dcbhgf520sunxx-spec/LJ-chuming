package com.hzchum.scim.common.core.api.utils.oa;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import javax.crypto.Cipher;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.binary.Base64;

public class RSA {
   private static final String PUB_KEY_NAME = "rsa_2048_pub.key";
   private static final String PRI_KEY_NAME = "rsa_2048_priv.key";
   private static String RSA_PUB = null;
   private static String RSA_PUB_FILE = null;
   private static PrivateKey PRI_KEY = null;
   private static ThreadLocal<Cipher> encryptThreadLocal = new ThreadLocal<>();
   private static ThreadLocal<Cipher> decryptThreadLocal = new ThreadLocal<>();
   private static Map<String, String> randCodeMap = new ConcurrentHashMap<>();
   private static Map<String, Long> randCodeTimeMap = new ConcurrentHashMap<>();
   private static final String RSA_MODE = "RSA/ECB/PKCS1Padding";
   private static boolean start = true;
   private static final String RSA_FLAG = "``RSA``";
   private String salt = "";
   private int saltLen = 0;
   private static boolean initRsASuccess = false;
   private String message = "0";

   public static String getProjectPath() {
      URL var0 = RSA.class.getProtectionDomain().getCodeSource().getLocation();
      String var1 = null;

      try {
         var1 = URLDecoder.decode(var0.getPath(), "utf-8");
      } catch (Exception var3) {
         var3.printStackTrace();
      }

      if (var1.endsWith(".jar")) {
         var1 = var1.substring(0, var1.lastIndexOf("/") + 1);
      }

      System.out.println("before skip real path:::::" + var1);
      if (var1.startsWith("file:")) {
         var1 = var1.substring(5);
      }

      System.out.println("skip file:::::" + var1);
      int var2 = var1.indexOf("RSA");
      System.out.println("RSA POS:::" + var2);
      if (var2 != -1) {
         var1 = var1.substring(0, var2);
      }

      if (var1.indexOf("classbean") != -1 || var1.indexOf("classes") != -1) {
         var1 = var1.replace("/WEB-INF", "");
         var1 = var1.replace("/classes", "");
         var1 = var1.replace("/classbean", "");
         if (!var1.endsWith("/")) {
            var1 = var1 + "/";
         }

         var1 = var1 + "WEB-INF/lib/";
      }

      if (!var1.endsWith("/")) {
         var1 = var1 + "/";
      }

      return var1;
   }

   public String getMessage() {
      return this.message;
   }

   public static String getRsaFlag() {
      return "``RSA``";
   }

   public void setSalt(String var1) {
      this.salt = var1;
   }

   public String getSalt() {
      return this.salt;
   }

   public String encrypt(String var1) {
      return this.encrypt((HttpServletRequest)null, var1);
   }

   public String encrypt(HttpServletRequest var1, String var2) {
      return this.encrypt(var1, var2, this.generateSalt(), "UTF-8");
   }

   public String encrypt(HttpServletRequest var1, String var2, String var3) {
      return this.encrypt(var1, var2, var3, "UTF-8");
   }

   public String encrypt(HttpServletRequest var1, String var2, String var3, String var4) {
      return this.encrypt(var1, var2, var3, var4, RSA_PUB_FILE, true);
   }

   public String encrypt(HttpServletRequest var1, String var2, String var3, String var4, String var5, boolean var6) {
      if (!initRsASuccess) {
         this.message = "-3";
         return var2;
      }

      if (var2 == null || "".equals(var2)) {
         this.message = "-6";
      }

      if (var5 == null) {
         var5 = RSA_PUB_FILE;
      }

      String var7 = "";

      try {
         if (var3 != null && !var3.equals("")) {
            var2 = var2 + var3;
            this.salt = var3;
         }

         byte[] var8 = var2.getBytes(var4);
         if (var8.length <= 245) {
            PublicKey var9 = null;
            if (var6) {
               var9 = PublicKeyReader.getFromBase64(var5);
            } else {
               var9 = PublicKeyReader.getFromBase64String(var5);
            }

            Cipher var10 = encryptThreadLocal.get();
            if (var10 == null) {
               var10 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
               var10.init(1, var9);
               encryptThreadLocal.set(var10);
            }

            byte[] var11 = var10.doFinal(var8);
            if (var1 != null) {
               var1.getSession().setAttribute("rsa_code", var3);
            }

            return Base64.encodeBase64String(var11);
         }

         this.message = "-4";
      } catch (Exception var16) {
         var16.printStackTrace();
         this.message = "-2";
      } finally {
         encryptThreadLocal.remove();
      }

      return var7;
   }

   public String encryptCommon(String var1) {
      return this.encryptCommon((HttpServletRequest)null, var1);
   }

   public String encryptCommon(HttpServletRequest var1, String var2) {
      return this.encryptCommon(var1, var2, this.generateSalt(), "UTF-8");
   }

   public String encryptCommon(HttpServletRequest var1, String var2, String var3) {
      return this.encryptCommon(var1, var2, var3, "UTF-8");
   }

   public String encryptCommon(HttpServletRequest var1, String var2, String var3, String var4) {
      return this.encryptCommon(var1, var2, var3, var4, RSA_PUB_FILE, true);
   }

   public String encryptCommon(HttpServletRequest var1, String var2, String var3, String var4, String var5, boolean var6) {
      if (!initRsASuccess) {
         this.message = "-3";
         return var2;
      }

      if (var2 == null || "".equals(var2)) {
         this.message = "-6";
      }

      if (var5 == null) {
         var5 = RSA_PUB_FILE;
      }

      String var7 = "";

      String var12;
      try {
         byte[] var8 = var2.getBytes(var4);
         if (var8.length > 245) {
            this.message = "-4";
            return var7;
         }

         PublicKey var9 = null;
         if (var6) {
            var9 = PublicKeyReader.getFromBase64(var5);
         } else {
            var9 = PublicKeyReader.getFromBase64String(var5);
         }

         Cipher var10 = encryptThreadLocal.get();
         if (var10 == null) {
            var10 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            var10.init(1, var9);
            encryptThreadLocal.set(var10);
         }

         byte[] var11 = var10.doFinal(var8);
         var12 = Base64.encodeBase64String(var11);
      } catch (Exception var16) {
         var16.printStackTrace();
         this.message = "-2";
         return var7;
      } finally {
         encryptThreadLocal.remove();
      }

      return var12;
   }

   public String generateSalt() {
      return this.generateSalt((HttpServletRequest)null);
   }

   public String generateSalt(HttpServletRequest var1) {
      return this.generateSalt(var1, (HttpServletResponse)null);
   }

   public Object callMethod(String var1, Object var2, String var3, Class[] var4, Object... var5) {
      try {
         Class var6 = Class.forName(var1);
         Method var7 = var6.getMethod(var3, var4);
         return var7.invoke(var2, var5);
      } catch (Exception var9) {
         return null;
      }
   }

   public String generateSalt(HttpServletRequest var1, HttpServletResponse var2) {
      SecureRandom var3 = new SecureRandom();
      byte[] var4 = new byte[4];
      var3.nextBytes(var4);
      StringBuffer var5 = new StringBuffer();

      for (int var6 = 0; var6 < var4.length; var6++) {
         String var7 = Integer.toHexString(255 & var4[var6]);
         if (var7.length() == 1) {
            var5.append('0');
         }

         var5.append(var7);
      }

      if (var1 != null) {
         var1.getSession().setAttribute("rsa_code", var5.toString());
         if (var2 != null) {
            String var8 = "";
            var8 = UUID.randomUUID().toString();
            Cookie var9 = new Cookie("__randcode__", var8);
            randCodeMap.put(var8, var5.toString());
            randCodeTimeMap.put(var8, new Date().getTime());
            this.callMethod(
               "com.cloudstore.dev.api.util.Util_DataCache", null, "setObjVal", new Class[]{String.class, Object.class, int.class}, var8, var5.toString(), 600
            );
            var9.setMaxAge(-1);
            var9.setPath("/");
            var2.addCookie(var9);
         }
      }

      return var5.toString();
   }

   public List<String> decryptList(List<String> var1) {
      return this.decryptList((HttpServletRequest)null, var1);
   }

   public List<String> decryptList(HttpServletRequest var1, List<String> var2) {
      return this.decryptList(var1, var2, false);
   }

   public List<String> decryptList(HttpServletRequest var1, List<String> var2, boolean var3) {
      return this.decryptList(var1, var2, var3, "UTF-8");
   }

   public List<String> decryptList(HttpServletRequest var1, List<String> var2, boolean var3, String var4) {
      if (var2 != null && var2.size() != 0) {
         ArrayList var5 = new ArrayList();

         try {
            for (int var6 = 0; var6 < var2.size(); var6++) {
               String var7 = var2.get(var6);
               if (var7 != null && !"".equals(var7)) {
                  var5.add(this.decrypt(var1, var7, var3, var4, true));
               } else {
                  var5.add(var7);
               }
            }
         } finally {
            this.removeRsaCode(var1);
         }

         return var5;
      } else {
         this.message = "-6";
         return var2;
      }
   }

   public String decrypt(String var1) {
      return this.decrypt((HttpServletRequest)null, var1, false);
   }

   public String decrypt(HttpServletRequest var1, String var2) {
      return this.decrypt(var1, var2, false);
   }

   public String decrypt(HttpServletRequest var1, String var2, boolean var3) {
      return this.decrypt(var1, var2, var3, "UTF-8");
   }

   public String decrypt(HttpServletRequest var1, String var2, boolean var3, String var4) {
      return this.decrypt(var1, var2, var3, var4, false);
   }

   public String decrypt(HttpServletRequest var1, String var2, boolean var3, String var4, boolean var5) {
      if (!initRsASuccess) {
         this.message = "-3";
         return var2;
      }

      String var6 = "";
      String var7 = this.getCookie(var1, "__randcode__");

      try {
         if (var2 == null || "".equals(var2)) {
            this.message = "-6";
            return var2;
         }

         if (!var3 && !var2.endsWith("``RSA``")) {
            return var2;
         }

         List<String> var8 = Arrays.asList(var2.split("``RSA``"));
         ArrayList<String> var9 = new ArrayList<>();
         if (var2.endsWith("``RSA``")) {
            for (String var11 : var8) {
               var9.add(var11 + "``RSA``");
            }
         } else {
            var9.add(var2);
         }

         Cipher var22 = decryptThreadLocal.get();
         if (var22 == null) {
            var22 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            var22.init(2, PRI_KEY);
            decryptThreadLocal.set(var22);
         }

         for (String var12 : var9) {
            var2 = var12;
            if (var12.endsWith("``RSA``")) {
               var2 = var12.substring(0, var12.indexOf("``RSA``"));
            }

            String var13 = new String(var22.doFinal(Base64.decodeBase64(var2)), var4);
            if (var1 != null) {
               String var14 = (String)var1.getSession().getAttribute("rsa_code");
               if (this.saltLen == 0) {
                  if (this.salt != null && !this.salt.equals("")) {
                     this.saltLen = this.salt.length();
                  } else {
                     this.saltLen = 8;
                  }
               }

               String var15 = var13.substring(var13.length() - this.saltLen);
               var13 = var13.substring(0, var13.length() - this.saltLen);
               if (!var3 && (var14 == null || "".equals(var14) || !var14.equals(var15))) {
                  if (var7 != null) {
                     var14 = randCodeMap.get(var7);
                     if (var14 == null || "".equals(var14)) {
                        var14 = (String)this.callMethod("com.cloudstore.dev.api.util.Util_DataCache", null, "getObjVal", new Class[]{String.class}, var7);
                     }
                  }

                  System.out.println("result salt:" + var15 + "------rsa_code::" + var14 + "------");
               }
            }

            if (this.message.equals("0")) {
               var6 = var6 + var13;
            }
         }
      } catch (Exception var19) {
         var19.printStackTrace();
         this.message = "-2";
      } finally {
         if (var1 != null && !var5) {
            this.removeRsaCode(var1, var7);
         }

         decryptThreadLocal.remove();
      }

      return var6;
   }

   private String getCookie(HttpServletRequest var1, String var2) {
      try {
         Cookie[] var3 = var1.getCookies();
         if (var3 != null && var3.length > 0) {
            for (int var4 = 0; var4 < var3.length; var4++) {
               if (var3[var4].getName().equals(var2)) {
                  return var3[var4].getValue();
               }
            }
         }
      } catch (Exception var5) {
      }

      return null;
   }

   public List<String> decryptCommonList(List<String> var1) {
      return this.decryptCommonList((HttpServletRequest)null, var1);
   }

   public List<String> decryptCommonList(HttpServletRequest var1, List<String> var2) {
      return this.decryptCommonList(var1, var2, true);
   }

   public List<String> decryptCommonList(HttpServletRequest var1, List<String> var2, boolean var3) {
      return this.decryptCommonList(var1, var2, var3, "UTF-8");
   }

   public List<String> decryptCommonList(HttpServletRequest var1, List<String> var2, boolean var3, String var4) {
      if (var2 != null && var2.size() != 0) {
         ArrayList var5 = new ArrayList();

         for (int var6 = 0; var6 < var2.size(); var6++) {
            String var7 = var2.get(var6);
            if (var7 != null && !"".equals(var7)) {
               var5.add(this.decryptCommon(var1, var7, var3, var4, true));
            } else {
               var5.add(var7);
            }
         }

         return var5;
      } else {
         this.message = "-6";
         return var2;
      }
   }

   public String decryptCommon(String var1) {
      return this.decryptCommon((HttpServletRequest)null, var1, true);
   }

   public String decryptCommon(HttpServletRequest var1, String var2) {
      return this.decryptCommon(var1, var2, true);
   }

   public String decryptCommon(HttpServletRequest var1, String var2, boolean var3) {
      return this.decryptCommon(var1, var2, var3, "UTF-8");
   }

   public String decryptCommon(HttpServletRequest var1, String var2, boolean var3, String var4) {
      return this.decryptCommon(var1, var2, var3, var4, true);
   }

   public String decryptCommon(HttpServletRequest var1, String var2, boolean var3, String var4, boolean var5) {
      if (!initRsASuccess) {
         this.message = "-3";
         return var2;
      }

      String var6 = "";

      try {
         if (var2 != null && !"".equals(var2)) {
            if (!var3 && !var2.endsWith("``RSA``")) {
               return var2;
            }

            List<String> var7 = Arrays.asList(var2.split("``RSA``"));
            ArrayList<String> var8 = new ArrayList<>();
            if (var2.endsWith("``RSA``")) {
               for (String var10 : var7) {
                  var8.add(var10 + "``RSA``");
               }
            } else {
               var8.add(var2);
            }

            Cipher var19 = decryptThreadLocal.get();
            if (var19 == null) {
               var19 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
               var19.init(2, PRI_KEY);
               decryptThreadLocal.set(var19);
            }

            for (String var11 : var8) {
               var2 = var11;
               if (var11.endsWith("``RSA``")) {
                  var2 = var11.substring(0, var11.indexOf("``RSA``"));
               }

               String var12 = new String(var19.doFinal(Base64.decodeBase64(var2)), var4);
               if (this.message.equals("0")) {
                  var6 = var6 + var12;
               }
            }

            return var6;
         }

         this.message = "-6";
         return var2;
      } catch (Exception var16) {
         var16.printStackTrace();
         this.message = "-2";
      } finally {
         decryptThreadLocal.remove();
      }

      return var6;
   }

   public void removeRsaCode(HttpServletRequest var1) {
      if (var1 != null) {
         var1.getSession().removeAttribute("rsa_code");
      }
   }

   public void removeRsaCode(HttpServletRequest var1, String var2) {
      if (var1 != null) {
         var1.getSession().removeAttribute("rsa_code");
      }

      if (var2 != null) {
         randCodeMap.remove(var2);
         randCodeTimeMap.remove(var2);
         this.callMethod("com.cloudstore.dev.api.util.Util_DataCache", null, "clearVal", new Class[]{String.class}, var2);
      }
   }

   private static void genarateKeyFiles(String var0, Charset var1) throws Throwable {
      var0 = var0 + "keys" + File.separator;
      KeyPairGenerator var2 = KeyPairGenerator.getInstance("RSA");
      var2.initialize(2048);
      KeyPair var3 = var2.generateKeyPair();
      PublicKey var4 = var3.getPublic();
      PrivateKey var5 = var3.getPrivate();
      String var6 = Base64.encodeBase64String(var4.getEncoded());
      OAFileUtils.writeStringToFile(new File(var0 + "rsa_2048_pub.key"), var6, var1);
      String var7 = Base64.encodeBase64String(var5.getEncoded());
      OAFileUtils.writeStringToFile(new File(var0 + "rsa_2048_priv.key"), var7, var1);
   }

   public static String getRSA_PUB() {
      return RSA_PUB;
   }

   public int getSaltLen() {
      return this.saltLen;
   }

   public void setSaltLen(int var1) {
      this.saltLen = var1;
   }

   static {
      new Thread(new Runnable() {
         @Override
         public void run() {
            while (RSA.start) {
               Iterator var1 = RSA.randCodeTimeMap.entrySet().iterator();
               Long var2 = new Date().getTime();

               while (var1.hasNext()) {
                  Entry var3 = (Entry)var1.next();
                  String var4 = (String)var3.getKey();
                  Long var5 = (Long)var3.getValue();
                  if (var2 - var5 >= 600000L) {
                     RSA.randCodeMap.remove(var4);
                     RSA.randCodeTimeMap.remove(var4);
                  }
               }

               try {
                  Thread.currentThread();
                  Thread.sleep(600000L);
               } catch (InterruptedException var6) {
                  var6.printStackTrace();
               }
            }
         }
      }).start();

      try {
         String var0 = getProjectPath();
         System.out.println("============rootPath:::" + var0);

         try {
            RSA_PUB_FILE = var0 + "keys" + File.separator + "rsa_2048_pub.key";
            File var1 = new File(RSA_PUB_FILE);
            RSA_PUB = OAFileUtils.readFileToString(var1, Const.UTF8_CHARSET);
            if (RSA_PUB == null) {
               genarateKeyFiles(var0, Const.UTF8_CHARSET);
               RSA_PUB = OAFileUtils.readFileToString(var1, Const.UTF8_CHARSET);
            }
         } catch (Exception var2) {
            genarateKeyFiles(var0, Const.UTF8_CHARSET);
            RSA_PUB = OAFileUtils.readFileToString(new File(var0 + "keys" + File.separator + "rsa_2048_pub.key"), Const.UTF8_CHARSET);
         }

         System.out.println("RSA_PUB:::" + RSA_PUB);
         PRI_KEY = PrivateKeyReader.getFromBase64(var0 + "keys" + File.separator + "rsa_2048_priv.key");
         initRsASuccess = true;
      } catch (Throwable var3) {
         var3.printStackTrace();
      }
   }
}
