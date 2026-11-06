package com.hzchum.scim.system.core.service.impl.notification;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.enums.EnableEnum;
import com.hzchum.scim.system.core.api.pojo._do.notification.SysPushApproveConfig;
import com.hzchum.scim.system.core.api.pojo.dto.notification.SysPushApproveConfigDTO;
import com.hzchum.scim.system.core.api.service.notification.SysPushApproveConfigService;
import com.hzchum.scim.system.core.mapper.notification.SysPushApproveConfigMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SysPushApproveConfigServiceImpl extends ServiceImpl<SysPushApproveConfigMapper, SysPushApproveConfig> implements SysPushApproveConfigService {
   @Override
   public List<SysPushApproveConfigDTO> getPushApproveList(String appKey, Integer status, Integer appType) {
      LambdaQueryWrapper<SysPushApproveConfig> wrapper = Wrappers.lambdaQuery(SysPushApproveConfig.class);
      if (status != null) {
         wrapper.eq(SysPushApproveConfig::getStatus, status);
      }

      if (appKey != null) {
         wrapper.eq(SysPushApproveConfig::getAppKey, appKey);
      }

      if (appType != null) {
         wrapper.eq(SysPushApproveConfig::getAppType, appType);
      }

      return this.baseMapper.selectList(wrapper).stream().map(item -> BeanUtil.copy(item, SysPushApproveConfigDTO.class)).collect(Collectors.toList());
   }

   @Override
   public ResultVO save(SysPushApproveConfigDTO item) {
      List<SysPushApproveConfig> sysPushApproveConfigs = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(SysPushApproveConfig.class)
               .eq(SysPushApproveConfig::getAppType, item.getAppType())
               .eq(SysPushApproveConfig::getStatus, EnableEnum.ENABLE.getType())
         );
      Boolean result = CollectionUtils.isNotEmpty(sysPushApproveConfigs) && EnableEnum.ENABLE.getType().equals(item.getStatus());
      Preconditions.checkArgument(!result, "一种类型只能有一条启用的数据");
      this.baseMapper
         .insert(
            SysPushApproveConfig.builder()
               .appKey(item.getAppKey())
               .appSecret(item.getAppSecret())
               .status(item.getStatus())
               .appType(item.getAppType())
               .robotCode(item.getRobotCode())
               .build()
         );
      return ResultVO.builder().message("添加成功").build();
   }

   @Override
   public ResultVO update(SysPushApproveConfigDTO item) {
      List<SysPushApproveConfig> sysPushApproveConfigs = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(SysPushApproveConfig.class)
               .eq(SysPushApproveConfig::getAppType, item.getAppType())
               .ne(SysPushApproveConfig::getId, item.getId())
               .eq(SysPushApproveConfig::getStatus, EnableEnum.ENABLE.getType())
         );
      Boolean result = CollectionUtils.isNotEmpty(sysPushApproveConfigs) && EnableEnum.ENABLE.getType().equals(item.getStatus());
      Preconditions.checkArgument(!result, "一种类型只能有一条启用的数据");
      this.baseMapper
         .updateById(
            SysPushApproveConfig.builder()
               .appKey(item.getAppKey())
               .appSecret(item.getAppSecret())
               .status(item.getStatus())
               .appType(item.getAppType())
               .robotCode(item.getRobotCode())
               .id(item.getId())
               .build()
         );
      return ResultVO.builder().message("修改成功").build();
   }

   @Override
   public ResultVO delete(List<Long> ids) {
      this.baseMapper.delete(Wrappers.lambdaQuery(SysPushApproveConfig.class).in(SysPushApproveConfig::getId, ids));
      return ResultVO.builder().message("删除成功").build();
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public boolean setEnabled(Long id, Integer status) {
      SysPushApproveConfig config = this.baseMapper.selectById(id);
      if (EnableEnum.ENABLE.getType().equals(status)) {
         List<SysPushApproveConfig> sysPushApproveConfigs = this.baseMapper
            .selectList(
               Wrappers.lambdaQuery(SysPushApproveConfig.class)
                  .eq(SysPushApproveConfig::getAppType, config.getAppType())
                  .eq(SysPushApproveConfig::getStatus, EnableEnum.ENABLE.getType())
            );
         Preconditions.checkArgument(CollectionUtils.isEmpty(sysPushApproveConfigs), "一种类型的数据只能有一条启用的数据");
      }

      config.setStatus(status);
      this.baseMapper.updateById(config);
      return true;
   }
}
