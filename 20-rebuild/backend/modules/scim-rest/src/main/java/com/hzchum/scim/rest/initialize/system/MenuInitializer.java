package com.hzchum.scim.rest.initialize.system;

import cn.hutool.core.util.StrUtil;
import com.hzchum.scim.rest.runner.MenuRootConfigRunner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

@Configuration
public class MenuInitializer {
   private static final Logger log = LoggerFactory.getLogger(MenuInitializer.class);
   @Value("classpath:sql/schema-7.sql")
   private Resource sqlScriptSchema;
   @Value("classpath:sql/menu/SysMenu-V1.sql")
   private Resource sqlScriptSysMenu;
   @Value("classpath:sql/menu/DeviceManagement-menu.sql")
   private Resource sqlScriptDeviceManagement;
   @Value("${menu.version}")
   private String menuVersion;
   @Value("classpath:sql/menu/${menu.version}-menu-V1.sql")
   private Resource sqlScriptMenu;
   @Value("classpath:sql/menu/Customized-menu.sql")
   private Resource sqlScriptCustomizedMenu;
   @Value("${menu.deviceManagement.enable}")
   private boolean enable;
   @Value("${menu.deviceManagement.externalLinkAddress}")
   private String deviceManagementUrl;
   @Value("${menu.recruitment.enable}")
   private boolean enableRecruitment;
   @Value("${menu.recruitment.externalLinkAddress}")
   private String recruitmentUrl;
   @Autowired
   private JdbcTemplate jdbcTemplate;
   @Autowired
   private MenuRootConfigRunner menuRootConfigRunner;

   @Bean
   @Transactional
   public void insertMenu() throws Exception {
      log.info("==========菜单初始化开始=============");
      if (!StrUtil.isBlank(this.menuVersion)
         && (
            this.menuVersion.equals("group")
               || this.menuVersion.equals("group-joint")
               || this.menuVersion.equals("make")
               || this.menuVersion.equals("project")
               || this.menuVersion.equals("base")
         )) {
         if (this.sqlScriptSchema.exists()) {
            String scriptContent = this.readScriptContent(this.sqlScriptSchema);
            if (!scriptContent.isEmpty()) {
               System.out.println("初始化菜单脚本: " + this.sqlScriptSchema.getURI());
               this.jdbcTemplate.execute(scriptContent);
            }
         }

         if (this.sqlScriptSysMenu.exists()) {
            String scriptContent = this.readScriptContent(this.sqlScriptSysMenu);
            if (!scriptContent.isEmpty()) {
               System.out.println("初始化菜单脚本: " + this.sqlScriptSysMenu.getURI());
               this.jdbcTemplate.execute(scriptContent);
            }
         }

         if (this.sqlScriptMenu.exists()) {
            String scriptContent = this.readScriptContent(this.sqlScriptMenu);
            if (!scriptContent.isEmpty()) {
               System.out.println("初始化菜单脚本: " + this.sqlScriptMenu.getURI());
               this.jdbcTemplate.execute(scriptContent);
            }
         }

         if (this.sqlScriptCustomizedMenu.exists()) {
            String scriptContent = this.readScriptContent(this.sqlScriptCustomizedMenu);
            if (!scriptContent.isEmpty()) {
               System.out.println("初始化菜单脚本: " + this.sqlScriptCustomizedMenu.getURI());
               this.jdbcTemplate.execute(scriptContent);
            }
         }

         if (this.enable) {
            String sql = "INSERT INTO `sys_menu` VALUES (19784, '2024-08-16 09:53:43.549000', '2024-08-16 09:54:14.855000', 2, 0, '设备管理', NULL, NULL, NULL, NULL, 0, b'0', 'system', b'1', b'0', 0, b'0', NULL, ?, 0, 17, 0)";
            this.jdbcTemplate.update(sql, this.deviceManagementUrl);
            if (this.sqlScriptDeviceManagement.exists()) {
               String scriptContent = this.readScriptContent(this.sqlScriptDeviceManagement);
               if (!scriptContent.isEmpty()) {
                  System.out.println("初始化菜单脚本: " + this.sqlScriptDeviceManagement.getURI());
                  this.jdbcTemplate.execute(scriptContent);
               }
            }
         }

         if (this.enableRecruitment) {
            String sql = "INSERT INTO `sys_menu` VALUES (15, '2024-08-16 09:53:43.549000', '2024-08-16 09:54:14.855000', 2, 0, '初鸣云招采', NULL, NULL, NULL, NULL, 0, b'0', 'system-recruitment', b'1', b'0', 0, b'0', NULL, ?, 0, 17, 0)";
            this.jdbcTemplate.update(sql, this.recruitmentUrl);
         }

         this.menuRootConfigRunner.run();
         this.jdbcTemplate.execute("ALTER TABLE sys_menu AUTO_INCREMENT = 1000000");
         log.info("==========菜单初始化结束=============");
      } else {
         throw new IllegalArgumentException("菜单启动配置版本不能为空或配置不正确，请检查配置文件中的 menu.version 配置");
      }
   }

   private String readScriptContent(Resource resource) throws IOException {
      StringBuilder contentBuilder = new StringBuilder();

      String line;
      try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
         while ((line = reader.readLine()) != null) {
            contentBuilder.append(line).append("\n");
         }
      }

      return contentBuilder.toString();
   }
}
