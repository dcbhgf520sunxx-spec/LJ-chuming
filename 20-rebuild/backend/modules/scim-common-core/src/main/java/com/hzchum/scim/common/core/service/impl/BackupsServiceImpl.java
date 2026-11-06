package com.hzchum.scim.common.core.service.impl;

import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.config.ConfigProperties;
import com.hzchum.scim.common.core.api.pojo._do.Backups;
import com.hzchum.scim.common.core.api.service.BackupsService;
import com.hzchum.scim.common.core.mapper.BackupsMapper;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BackupsServiceImpl extends ServiceImpl<BackupsMapper, Backups> implements BackupsService {
   private static final Logger log = LoggerFactory.getLogger(BackupsServiceImpl.class);

   @Override
   public void mysqlBackups(ConfigProperties configProperties) {
      List<Backups> list = this.baseMapper.selectList((Wrapper<Backups>)Wrappers.<Backups>lambdaQuery().orderByDesc(BaseEntity::getCreateTime));
      Integer backupsNumber = configProperties.getBackupsNumber();
      if (list.size() > backupsNumber - 1) {
         for (int i = backupsNumber - 1; i < list.size(); i++) {
            Backups backups = list.get(i);
            String filePath = backups.getBackupsPath() + "/" + backups.getBackupsName();
            boolean b = FileUtil.deleteFile(filePath);
            log.info("----------------- 是否删除成功：" + b + " -----------------");
            log.info("------------------文件绝对路径：" + filePath + " -----------------");
            if (b) {
               this.baseMapper.deleteById(backups);
            }
         }
      }

      String fileName = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now()) + ".sql";
      String filePath = configProperties.getFilePath() + "mysql-backups";
      File folder = new File(filePath);
      if (!folder.exists() && !folder.isDirectory()) {
         folder.mkdirs();
      }

      String[] command = new String[]{
         "/bin/sh",
         "-c",
         "docker exec -i mysql mysqldump -u"
            + configProperties.getUserName()
            + " -p"
            + configProperties.getSqlPassWord()
            + " "
            + configProperties.getDatabase()
            + " > "
            + filePath
            + "/"
            + fileName
      };

      try {
         Process process = Runtime.getRuntime().exec(command);
         process.waitFor();
         Backups backups = Backups.builder().backupsName(fileName).backupsPath(filePath).databaseName(configProperties.getDatabase()).build();
         this.baseMapper.insert(backups);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   @Override
   public void mysqlBackups(Integer number, String path, Map<String, DataSourceProperty> dataSourcePropertyMap) {
      dataSourcePropertyMap.entrySet()
         .forEach(
            dataSourceProperty -> {
               List<Backups> list = this.baseMapper.selectList((Wrapper<Backups>)Wrappers.<Backups>lambdaQuery().orderByDesc(BaseEntity::getCreateTime));
               Integer backupsNumber = number;
               if (list.size() > backupsNumber - 1) {
                  for (int i = backupsNumber - 1; i < list.size(); i++) {
                     Backups backups = list.get(i);
                     String filePath = backups.getBackupsPath() + "/" + backups.getBackupsName();
                     boolean b = FileUtil.deleteFile(filePath);
                     log.info("----------------- 是否删除成功：" + b + " -----------------");
                     log.info("------------------文件绝对路径：" + filePath + " -----------------");
                     if (b) {
                        this.baseMapper.deleteById(backups);
                     }
                  }
               }

               String fileName = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now()) + ".sql";
               String filePath = path + "mysql-backups";
               File folder = new File(filePath);
               if (!folder.exists() && !folder.isDirectory()) {
                  folder.mkdirs();
               }

               String[] command = new String[]{
                  "/bin/sh",
                  "-c",
                  "docker exec -i plm-mysql mysqldump -u"
                     + dataSourceProperty.getValue().getUsername()
                     + " -p"
                     + dataSourceProperty.getValue().getPassword()
                     + " "
                     + this.getDateBaseName(dataSourceProperty.getValue().getUrl())
                     + " --no-tablespaces > "
                     + filePath
                     + "/"
                     + fileName
               };

               try {
                  Process process = Runtime.getRuntime().exec(command);
                  process.waitFor();
                  Backups backups = Backups.builder()
                     .backupsName(fileName)
                     .backupsPath(filePath)
                     .databaseName(this.getDateBaseName(dataSourceProperty.getValue().getUrl()))
                     .build();
                  this.baseMapper.insert(backups);
               } catch (Exception e) {
                  e.printStackTrace();
               }
            }
         );
   }

   private String getDateBaseName(String url) {
      return url.substring(url.indexOf("/", url.indexOf("//") + 2) + 1, url.indexOf("?"));
   }
}
