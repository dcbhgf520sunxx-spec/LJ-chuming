package com.hzchum.scim.rest.runner.sql;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hzchum.scim.system.core.api.pojo._do.script.InitSqlScript;
import com.hzchum.scim.system.core.api.service.script.InitSqlScriptService;
import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class InitSqlScriptRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(InitSqlScriptRunner.class);
   private final InitSqlScriptService initSqlScriptService;
   private final JdbcTemplate jdbcTemplate;

   @Override
   public void run(String... strings) {
      log.info("开始执行系统初始化SQL脚本...");
      List<InitSqlScript> sqlScriptList = this.initSqlScriptService
         .list((Wrapper<InitSqlScript>)new LambdaQueryWrapper<InitSqlScript>().eq(InitSqlScript::getExecutionCount, 0));
      if (sqlScriptList.isEmpty()) {
         log.info("暂无未执行的初始化SQL脚本");
      }

      for (InitSqlScript script : sqlScriptList) {
         Long scriptId = script.getId();
         String scriptName = script.getScriptName();
         String sqlContent = script.getSqlContent();

         try {
            log.info("开始执行脚本[{}]，ID：{}", scriptName, scriptId);
            this.jdbcTemplate.execute(sqlContent);
            script.setExecutionCount(script.getExecutionCount() + 1);
            script.setExecuteTime(LocalDateTime.now());
            this.initSqlScriptService.updateById(script);
            log.info("脚本[{}]执行成功", scriptName);
         } catch (Exception e) {
            log.error("脚本[{}]执行失败，ID：{}，错误信息：{}", scriptName, scriptId, e.getMessage(), e);
            throw new RuntimeException("初始化SQL执行失败：" + scriptName, e);
         }
      }
   }

   public InitSqlScriptRunner(final InitSqlScriptService initSqlScriptService, final JdbcTemplate jdbcTemplate) {
      this.initSqlScriptService = initSqlScriptService;
      this.jdbcTemplate = jdbcTemplate;
   }
}
