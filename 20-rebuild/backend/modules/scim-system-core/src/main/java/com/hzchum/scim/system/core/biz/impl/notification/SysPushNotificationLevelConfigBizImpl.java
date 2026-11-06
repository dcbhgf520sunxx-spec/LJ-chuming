package com.hzchum.scim.system.core.biz.impl.notification;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.system.core.api.biz.notification.SysPushNotificationConfigBiz;
import com.hzchum.scim.system.core.api.biz.notification.SysPushNotificationLevelConfigBiz;
import com.hzchum.scim.system.core.api.pojo._do.notification.SysPushNotificationLevelConfig;
import com.hzchum.scim.system.core.api.pojo.dto.notification.NotificationLevelConfigDTO;
import com.hzchum.scim.system.core.api.pojo.dto.notification.NotificationLevelConfigSaveDTOParam;
import com.hzchum.scim.system.core.api.service.notification.SysPushNotificationLevelConfigService;
import com.hzchum.scim.system.core.mapper.notification.SysPushNotificationLevelConfigMapper;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SysPushNotificationLevelConfigBizImpl
   extends IBizImpl<SysPushNotificationLevelConfigService, SysPushNotificationLevelConfigMapper, SysPushNotificationLevelConfig>
   implements SysPushNotificationLevelConfigBiz {
   @Autowired
   private SysPushNotificationConfigBiz sysPushNotificationConfigBiz;

   @Transactional
   @Override
   public Boolean saveConfig(List<NotificationLevelConfigSaveDTOParam> params) {
      List<Long> configIds = params.stream().map(NotificationLevelConfigSaveDTOParam::getId).filter(Objects::nonNull).collect(Collectors.toList());
      List<SysPushNotificationLevelConfig> configList = this.baseService.list();
      Map<Long, SysPushNotificationLevelConfig> levelConfigMap = configList.stream()
         .collect(Collectors.toMap(SysPushNotificationLevelConfig::getId, Function.identity()));
      Map<Integer, List<NotificationLevelConfigSaveDTOParam>> map = params.stream()
         .collect(Collectors.groupingBy(NotificationLevelConfigSaveDTOParam::getLevel));
      Preconditions.checkArgument(params.size() == map.keySet().size(), "等级不能重复");
      params.forEach(
         item -> {
            if (item.getId() == null) {
               SysPushNotificationLevelConfig config = this.baseService
                  .getOne(Wrappers.lambdaQuery(SysPushNotificationLevelConfig.class).eq(SysPushNotificationLevelConfig::getLevel, item.getLevel()));
               String s = this.numberToLetter(item.getLevel());
               Preconditions.checkArgument(config == null, s + "等级配置已存在");
               SysPushNotificationLevelConfig levelConfig = BeanUtil.copy(item, SysPushNotificationLevelConfig.class);
               this.baseService.save(levelConfig);
            } else {
               SysPushNotificationLevelConfig levelConfig = this.baseService.getById(item.getId());
               Preconditions.checkArgument(levelConfig != null, "当前配置不存在");
               SysPushNotificationLevelConfig config = this.baseService
                  .getOne(
                     Wrappers.lambdaQuery(SysPushNotificationLevelConfig.class)
                        .eq(SysPushNotificationLevelConfig::getLevel, item.getLevel())
                        .ne(SysPushNotificationLevelConfig::getId, item.getId())
                  );
               Preconditions.checkArgument(config == null, "当且等级已存在配置");
               levelConfig.setLevel(item.getLevel());
               levelConfig.setColor(item.getColor());
               this.baseService.updateById(levelConfig);
            }
         }
      );
      return Boolean.TRUE;
   }

   @Override
   public List<NotificationLevelConfigDTO> getConfig() {
      return this.baseService.list().stream().map(item -> BeanUtil.copy(item, NotificationLevelConfigDTO.class)).collect(Collectors.toList());
   }

   @Override
   public String numberToLetter(int number) {
      if (number >= 65 && number <= 90) {
         char letter = (char)number;
         return String.valueOf(letter);
      } else {
         return "Invalid number";
      }
   }
}
