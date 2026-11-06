package com.hzchum.pangu.mybatisplus.interceptor;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;
import com.baomidou.mybatisplus.core.toolkit.PluginUtils;
import com.baomidou.mybatisplus.core.toolkit.PluginUtils.MPBoundSql;
import com.baomidou.mybatisplus.extension.plugins.inner.InnerInterceptor;
import com.hzchum.pangu.common.valid.DefaultSelect;
import java.lang.reflect.Field;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.scripting.defaults.RawSqlSource;
import org.apache.ibatis.scripting.xmltags.DynamicSqlSource;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DefaultSelectInterceptor implements InnerInterceptor {
   private static final Logger log = LoggerFactory.getLogger(DefaultSelectInterceptor.class);

   @Override
   public void beforeQuery(Executor executor, MappedStatement ms, Object parameter, RowBounds rowBounds, ResultHandler resultHandler, BoundSql boundSql) {
      String originSql = boundSql.getSql();
      String methodId = ms.getId();
      if (methodId.matches(".*\\.(selectBatchIds|selectByMap|selectOne|selectCount|selectList|selectMaps|selectObjs|selectPage|selectMapsPage)")
            && ms.getSqlSource() instanceof DynamicSqlSource
         || methodId.matches(".*\\.(selectById)") && ms.getSqlSource() instanceof RawSqlSource) {
         String tableName = this.extractTableName(boundSql.getSql());
         if (tableName != null) {
            TableInfo tableInfo = TableInfoHelper.getTableInfo(tableName);
            if (tableInfo != null && tableInfo.getEntityType() != null) {
               String startSql = originSql.substring(0, originSql.indexOf("WHERE") + 5);
               String endSql = originSql.substring(originSql.indexOf("WHERE") + 5);
               StringBuilder insertSql = new StringBuilder();

               for (Field field : tableInfo.getEntityType().getDeclaredFields()) {
                  if (field.isAnnotationPresent(DefaultSelect.class) && field.isAnnotationPresent(TableField.class)) {
                     field.setAccessible(true);
                     TableField tableField = field.getAnnotation(TableField.class);
                     DefaultSelect defaultSelect = field.getAnnotation(DefaultSelect.class);
                     String column = tableField.value();
                     int defaultValue = defaultSelect.value();
                     if (!endSql.contains(column)) {
                        insertSql.append(" ").append(column).append("=").append(defaultValue).append(" AND ");
                     }
                  }
               }

               String newSql = startSql + insertSql.toString() + endSql;
               MPBoundSql mpBoundSql = PluginUtils.mpBoundSql(boundSql);
               mpBoundSql.sql(newSql);
            }
         }
      }
   }

   private String extractTableName(String sql) {
      return sql.contains("FROM") ? sql.substring(sql.indexOf("FROM") + 4, sql.indexOf("WHERE")).trim() : null;
   }
}
