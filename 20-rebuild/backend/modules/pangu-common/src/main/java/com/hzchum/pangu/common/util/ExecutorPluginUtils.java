package com.hzchum.pangu.common.util;

import com.hzchum.pangu.common.valid.DataPermissionCheck;
import com.hzchum.pangu.common.valid.DataPermissionIgnoreCheck;
import java.lang.reflect.Method;
import java.sql.SQLException;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.mapping.MappedStatement.Builder;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;

public class ExecutorPluginUtils {
   public static String getSqlByInvocation(Invocation invocation) {
      Object[] args = invocation.getArgs();
      MappedStatement ms = (MappedStatement)args[0];
      Object parameterObject = args[1];
      BoundSql boundSql = ms.getBoundSql(parameterObject);
      return boundSql.getSql();
   }

   public static void resetSql2Invocation(Invocation invocation, String sql) throws SQLException {
      Object[] args = invocation.getArgs();
      MappedStatement statement = (MappedStatement)args[0];
      Object parameterObject = args[1];
      BoundSql boundSql = statement.getBoundSql(parameterObject);
      MappedStatement newStatement = newMappedStatement(statement, new ExecutorPluginUtils.BoundSqlSqlSource(boundSql));
      MetaObject msObject = MetaObject.forObject(newStatement, new DefaultObjectFactory(), new DefaultObjectWrapperFactory(), new DefaultReflectorFactory());
      msObject.setValue("sqlSource.boundSql.sql", sql);
      args[0] = newStatement;
   }

   private static MappedStatement newMappedStatement(MappedStatement ms, SqlSource newSqlSource) {
      Builder builder = new Builder(ms.getConfiguration(), ms.getId(), newSqlSource, ms.getSqlCommandType());
      builder.resource(ms.getResource());
      builder.fetchSize(ms.getFetchSize());
      builder.statementType(ms.getStatementType());
      builder.keyGenerator(ms.getKeyGenerator());
      if (ms.getKeyProperties() != null && ms.getKeyProperties().length != 0) {
         StringBuilder keyProperties = new StringBuilder();

         for (String keyProperty : ms.getKeyProperties()) {
            keyProperties.append(keyProperty).append(",");
         }

         keyProperties.delete(keyProperties.length() - 1, keyProperties.length());
         builder.keyProperty(keyProperties.toString());
      }

      builder.timeout(ms.getTimeout());
      builder.parameterMap(ms.getParameterMap());
      builder.resultMaps(ms.getResultMaps());
      builder.resultSetType(ms.getResultSetType());
      builder.cache(ms.getCache());
      builder.flushCacheRequired(ms.isFlushCacheRequired());
      builder.useCache(ms.isUseCache());
      return builder.build();
   }

   public static boolean isAreaTag(MappedStatement mappedStatement) throws ClassNotFoundException {
      String id = mappedStatement.getId();
      Class<?> classType = Class.forName(id.substring(0, mappedStatement.getId().lastIndexOf(".")));
      String mName = mappedStatement.getId().substring(mappedStatement.getId().lastIndexOf(".") + 1);
      boolean ignore = false;

      for (Method method : classType.getDeclaredMethods()) {
         if (method.isAnnotationPresent(DataPermissionIgnoreCheck.class) && mName.equals(method.getName())) {
            ignore = true;
         }
      }

      return classType.isAnnotationPresent(DataPermissionCheck.class) && !ignore;
   }

   public static boolean isAreaTagIngore(MappedStatement mappedStatement) throws ClassNotFoundException {
      String id = mappedStatement.getId();
      Class<?> classType = Class.forName(id.substring(0, mappedStatement.getId().lastIndexOf(".")));
      String mName = mappedStatement.getId().substring(mappedStatement.getId().lastIndexOf(".") + 1);
      boolean ignore = false;

      for (Method method : classType.getDeclaredMethods()) {
         if (method.isAnnotationPresent(DataPermissionIgnoreCheck.class) && mName.equals(method.getName())) {
            ignore = true;
         }
      }

      return ignore;
   }

   public static String getOperateType(Invocation invocation) {
      Object[] args = invocation.getArgs();
      MappedStatement ms = (MappedStatement)args[0];
      SqlCommandType commondType = ms.getSqlCommandType();
      if (commondType.compareTo(SqlCommandType.SELECT) == 0) {
         return "select";
      } else if (commondType.compareTo(SqlCommandType.INSERT) == 0) {
         return "insert";
      } else if (commondType.compareTo(SqlCommandType.UPDATE) == 0) {
         return "update";
      } else {
         return commondType.compareTo(SqlCommandType.DELETE) == 0 ? "delete" : null;
      }
   }

   static class BoundSqlSqlSource implements SqlSource {
      private BoundSql boundSql;

      public BoundSqlSqlSource(BoundSql boundSql) {
         this.boundSql = boundSql;
      }

      @Override
      public BoundSql getBoundSql(Object parameterObject) {
         return this.boundSql;
      }
   }
}
