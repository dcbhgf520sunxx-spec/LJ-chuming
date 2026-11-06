package com.hzchum.scim.system.core.api.common.utils;

import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.util.UserInfoUtil;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.pojo._do.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserUtil {
   private static final Logger log = LoggerFactory.getLogger(UserUtil.class);

   public static SecurityUser getCurrentUser() {
      try {
         return (SecurityUser)UserInfoUtil.getCurrentUser();
      } catch (Exception e) {
         log.error("获取当前登录用户失败", e);
         throw new BusinessException("用户未登录，无法进行操作");
      }
   }

   public static Long getCurrentUserId() {
      return getCurrentUser().getId();
   }

   public static String getCurrentName() {
      return getCurrentUser().getName();
   }

   public static Department getCurrentDepartment() {
      return getCurrentUser().getDepartment();
   }
}
