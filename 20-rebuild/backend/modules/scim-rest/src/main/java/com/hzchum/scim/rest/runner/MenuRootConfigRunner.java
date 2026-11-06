package com.hzchum.scim.rest.runner;

import cn.hutool.core.util.StrUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Component
@PropertySource(value = "classpath:module/module.properties", encoding = "UTF-8")
public class MenuRootConfigRunner {
   private static final Logger log = LoggerFactory.getLogger(MenuRootConfigRunner.class);
   @Value("${module}")
   private String module;
   @Value("${menu}")
   private String menu;
   @Value("${project-mode}")
   private String projectMode;
   @Value("${bool-leased-edition}")
   private Boolean boolLeasedEdition;
   @Autowired
   private MenuRootRunner menuRootRunner;

   @Transactional(rollbackFor = TransactionException.class)
   public void run(String... args) throws Exception {
      if (!this.module.contains("contract")) {
         this.menuRootRunner.deleteContract();
      }

      if (!this.module.contains("smartLine")) {
         this.menuRootRunner.deleteSmartLine();
      }

      if (!this.module.contains("enclosure")) {
         this.menuRootRunner.deleteEnclosure();
      }

      if (!this.module.contains("assemble_typesetting")) {
         this.menuRootRunner.deleteAT();
      }

      if (!this.module.contains("mes")) {
         this.menuRootRunner.deleteMes();
      }

      if (!this.module.contains("wms")) {
         this.menuRootRunner.deleteWms();
      }

      if (!this.module.contains("cut")) {
         this.menuRootRunner.deleteCut();
      }

      if (!this.module.contains("project")) {
         this.menuRootRunner.deleteProject();
      }

      if (!this.module.contains("scm")) {
         this.menuRootRunner.deleteScm();
         if (!this.module.contains("project")) {
            this.menuRootRunner.deleteScmModule();
         }
      }

      if (!this.module.contains("bim")) {
         this.menuRootRunner.deleteBim();
      }

      if (!this.module.contains("operation")) {
         this.menuRootRunner.deleteOperation();
      }

      if (!this.module.contains("bridge")) {
         this.menuRootRunner.deleteBridge();
      }

      if (StrUtil.isNotBlank(this.menu)) {
         if (!this.menu.contains("enclosure")) {
            this.menuRootRunner.deleteMesEnclosure();
            this.menuRootRunner.deletePlanEnclosure();
         }

         if (!this.menu.contains("auxiliary_material")) {
            this.menuRootRunner.deletePlanAm();
            this.menuRootRunner.deleteMesAuxiliaryAaterial();
         }
      }

      if (StringUtils.isNotBlank(this.projectMode) && this.projectMode.equals("simple")) {
         this.menuRootRunner.deleteModeConfig();
         this.menuRootRunner.deleteAT();
         this.menuRootRunner.deletePartScheduling();
         this.menuRootRunner.deleteMachinePartOrder();
         this.menuRootRunner.deleteDrillOrder();
      }

      if (this.boolLeasedEdition != null && this.boolLeasedEdition.equals(true)) {
         this.menuRootRunner.deleteModeConfig();
         this.menuRootRunner.deleteMachinePart();
         this.menuRootRunner.deletePartScheduling();
         this.menuRootRunner.deleteMachinePartOrder();
         this.menuRootRunner.deleteDrillOrder();
         this.menuRootRunner.deleteLeasedEditionMenu();
      }

      log.info("根据 application.properties 配置，删除对应菜单id已执行=================================");
   }
}
