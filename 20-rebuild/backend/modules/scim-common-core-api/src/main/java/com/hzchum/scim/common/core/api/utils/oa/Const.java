package com.hzchum.scim.common.core.api.utils.oa;

import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Const {
   public static final String UTF8_ENCODING = "UTF-8";
   public static final Charset UTF8_CHARSET = Charset.forName("UTF-8");
   public static final DateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy'-'MM'-'dd' 'HH:mm:ss");
   public static final String ENCRYPT_SALT = "1p^~G";
}
