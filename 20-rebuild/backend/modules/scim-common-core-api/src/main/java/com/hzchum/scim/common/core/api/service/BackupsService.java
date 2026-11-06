package com.hzchum.scim.common.core.api.service;

import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.common.core.api.config.ConfigProperties;
import com.hzchum.scim.common.core.api.pojo._do.Backups;
import java.util.Map;

public interface BackupsService extends IService<Backups> {
   void mysqlBackups(ConfigProperties configProperties);

   void mysqlBackups(Integer backupsNumber, String filePath, Map<String, DataSourceProperty> dataSourcePropertyMap);
}
