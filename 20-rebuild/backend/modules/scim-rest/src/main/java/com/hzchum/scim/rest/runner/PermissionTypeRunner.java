package com.hzchum.scim.rest.runner;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.system.core.api.common.enums.PermissionTypeEnum;
import com.hzchum.scim.system.core.api.pojo._do.PermissionType;
import com.hzchum.scim.system.core.api.service.PermissionTypeService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Order(2)
@Component
public class PermissionTypeRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(PermissionTypeRunner.class);
   private final PermissionTypeService permissionTypeService;

   @Override
   public void run(String... strings) {
      log.info("初始化权限类型信息开始............................................");

      for (PermissionTypeEnum permission : PermissionTypeEnum.values()) {
         List<PermissionType> checkType = this.permissionTypeService
            .list((Wrapper<PermissionType>)Wrappers.<PermissionType>lambdaQuery().eq(PermissionType::getName, permission.getName()));
         if (CollectionUtils.isEmpty(checkType)) {
            PermissionType permissionType = new PermissionType();
            permissionType.setId(permission.getId());
            permissionType.setName(permission.getName());
            permissionType.setIcon(permission.getIcon());
            permissionType.setSort(permission.getSort());
            this.permissionTypeService.save(permissionType);
         }
      }

      log.info("初始化权限类型信息结束............................................");
   }

   public PermissionTypeRunner(final PermissionTypeService permissionTypeService) {
      this.permissionTypeService = permissionTypeService;
   }
}
