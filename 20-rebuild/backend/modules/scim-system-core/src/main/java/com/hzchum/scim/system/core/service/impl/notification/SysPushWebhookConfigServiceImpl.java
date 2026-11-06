package com.hzchum.scim.system.core.service.impl.notification;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.google.common.base.Preconditions;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.system.core.api.common.enums.notification.NotificationModuleTypeEnum;
import com.hzchum.scim.system.core.api.pojo._do.notification.SysPushWebhookConfig;
import com.hzchum.scim.system.core.api.pojo.dto.notification.SysPushWebhookConfigDTO;
import com.hzchum.scim.system.core.api.service.notification.SysPushWebhookConfigService;
import com.hzchum.scim.system.core.mapper.notification.SysPushWebhookConfigMapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SysPushWebhookConfigServiceImpl extends ServiceImpl<SysPushWebhookConfigMapper, SysPushWebhookConfig> implements SysPushWebhookConfigService {
   @Override
   public List<SysPushWebhookConfigDTO> getWebhookList(String url, String name, Integer status, Integer notificationType) {
      LambdaQueryWrapper<SysPushWebhookConfig> wrapper = Wrappers.lambdaQuery(SysPushWebhookConfig.class);
      if (status != null) {
         wrapper.eq(SysPushWebhookConfig::getStatus, status);
      }

      if (url != null) {
         wrapper.like(SysPushWebhookConfig::getHookUrl, url);
      }

      if (name != null) {
         wrapper.like(SysPushWebhookConfig::getName, name);
      }

      if (ObjectUtils.isNotEmpty(notificationType)) {
         wrapper.apply("FIND_IN_SET({0}, notification_type) > 0", notificationType);
      }

      return this.baseMapper.selectList(wrapper).stream().map(item -> {
         SysPushWebhookConfigDTO configDTO = new SysPushWebhookConfigDTO();
         if (ObjectUtils.isNotEmpty(item.getNotificationType())) {
            List<Integer> notificationTypes = Arrays.stream(item.getNotificationType().split(",")).map(Integer::parseInt).collect(Collectors.toList());
            List<String> notificationTypeNames = new ArrayList<>();
            notificationTypes.forEach(item1 -> {
               NotificationModuleTypeEnum notificationName = NotificationModuleTypeEnum.getNotificationType(item1);
               notificationTypeNames.add(notificationName != null ? notificationName.getNotificationTypeName() : "");
            });
            configDTO.setNotificationType(notificationTypes);
            configDTO.setNotificationTypeName(notificationTypeNames);
         }

         BeanUtil.copy(item, configDTO);
         return configDTO;
      }).collect(Collectors.toList());
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public ResultVO save(List<SysPushWebhookConfigDTO> sysPushWebhookConfigDTOs) {
      Preconditions.checkArgument(sysPushWebhookConfigDTOs != null && !sysPushWebhookConfigDTOs.isEmpty(), "请至少添加一条Webhook配置");
      sysPushWebhookConfigDTOs.forEach(this::validateConfiguration);
      sysPushWebhookConfigDTOs.forEach(
         item -> {
            String notificationType = item.getNotificationType().stream().map(String::valueOf).collect(Collectors.joining(","));
            this.baseMapper
               .insert(
                  SysPushWebhookConfig.builder()
                     .hookUrl(item.getHookUrl())
                     .name(item.getName())
                     .status(item.getStatus())
                     .notificationType(notificationType)
                     .build()
               );
         }
      );
      return ResultVO.builder().message("添加成功").build();
   }

   @Override
   public ResultVO update(SysPushWebhookConfigDTO item) {
      this.validateConfiguration(item);
      Preconditions.checkArgument(item.getId() != null && this.baseMapper.selectById(item.getId()) != null, "Webhook配置不存在");
      String notificationType = item.getNotificationType().stream().map(String::valueOf).collect(Collectors.joining(","));
      this.baseMapper
         .updateById(
            SysPushWebhookConfig.builder()
               .status(item.getStatus())
               .notificationType(notificationType)
               .hookUrl(item.getHookUrl())
               .name(item.getName())
               .id(item.getId())
               .build()
         );
      return ResultVO.builder().message("修改成功").build();
   }

   @Override
   public ResultVO delete(List<Long> ids) {
      Preconditions.checkArgument(ids != null && !ids.isEmpty(), "请选择需要删除的Webhook配置");
      this.baseMapper.delete(Wrappers.lambdaQuery(SysPushWebhookConfig.class).in(SysPushWebhookConfig::getId, ids));
      return ResultVO.builder().message("删除成功").build();
   }

   private void validateConfiguration(SysPushWebhookConfigDTO item) {
      Preconditions.checkArgument(item != null, "Webhook配置不能为空");
      Preconditions.checkArgument(item.getName() != null && !item.getName().trim().isEmpty()
         && item.getName().length() <= 20, "Webhook名称不能为空且不能超过20个字符");
      Preconditions.checkArgument(item.getHookUrl() != null && !item.getHookUrl().trim().isEmpty()
         && item.getHookUrl().length() <= 255, "WebhookURL不能为空且不能超过255个字符");
      Preconditions.checkArgument(item.getStatus() != null && (item.getStatus() == 0 || item.getStatus() == 1), "状态必须为启用或禁用");
      Preconditions.checkArgument(item.getNotificationType() != null && !item.getNotificationType().isEmpty(), "请选择业务流程类型");
      Preconditions.checkArgument(item.getNotificationType().stream().allMatch(value -> value != null
         && NotificationModuleTypeEnum.getNotificationType(value) != null), "业务流程类型不存在");
      Preconditions.checkArgument(item.getNotificationType().stream().map(String::valueOf).collect(Collectors.joining(",")).length() <= 100,
         "业务流程类型配置过长");
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public boolean setEnabled(Long id, Integer status) {
      SysPushWebhookConfig config = this.baseMapper.selectById(id);
      Preconditions.checkArgument(config != null, "Webhook配置不存在");
      Preconditions.checkArgument(status != null && (status == 0 || status == 1), "状态必须为启用或禁用");
      config.setStatus(status);
      this.baseMapper.updateById(config);
      return true;
   }
}
