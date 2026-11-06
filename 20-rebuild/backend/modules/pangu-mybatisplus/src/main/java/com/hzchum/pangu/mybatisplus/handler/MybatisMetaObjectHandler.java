package com.hzchum.pangu.mybatisplus.handler;

import cn.hutool.core.date.DatePattern;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MybatisMetaObjectHandler implements MetaObjectHandler {
   private static final Logger log = LoggerFactory.getLogger(MybatisMetaObjectHandler.class);
   private static String DISTRIBUTE_KEY = "DISTRIBUTE_KEY:";

   @Override
   public void insertFill(MetaObject metaObject) {
      try {
         log.debug("createTime:设为null");
         metaObject.setValue("createTime", null);
      } catch (Exception e) {
         log.error("createTime:设为null失败");
      }

      try {
         metaObject.setValue("inYearMonthDate", null);
         metaObject.setValue("inYearMonthDayDate", null);
      } catch (Exception var3) {
      }

      this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
      this.strictInsertFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
      this.strictInsertFill(metaObject, "boolDeleteEnum", Boolean.class, false);
      this.strictInsertFill(metaObject, "deleteEnum", Long.class, 0L);
      this.strictInsertFill(metaObject, "version", Integer.class, 1);
      this.strictInsertFill(metaObject, "inYearMonthDayDate", String.class, LocalDate.now().format(DatePattern.NORM_DATE_FORMATTER));
      this.strictInsertFill(metaObject, "inYearMonthDate", String.class, LocalDate.now().format(DatePattern.NORM_MONTH_FORMATTER));
   }

   @Override
   public void updateFill(MetaObject metaObject) {
      try {
         if (metaObject.hasSetter("updateTime")) {
            log.debug("自动插入 updateTime");
            metaObject.setValue("updateTime", null);
         }
      } catch (Exception e) {
         log.error("设为空失败");
      }

      this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
   }
}
