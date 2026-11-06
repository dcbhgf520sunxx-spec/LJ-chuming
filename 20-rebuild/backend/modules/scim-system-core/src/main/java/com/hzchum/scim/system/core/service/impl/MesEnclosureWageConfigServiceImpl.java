package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.system.core.api.pojo._do.MesEnclosureWageConfig;
import com.hzchum.scim.system.core.api.pojo.request.MesEnclosureWageConfigSaveDTOParam;
import com.hzchum.scim.system.core.api.service.MesEnclosureWageConfigService;
import com.hzchum.scim.system.core.api.service.MesPriceModifyConfigService;
import com.hzchum.scim.system.core.mapper.MesEnclosureWageConfigMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesEnclosureWageConfigServiceImpl
   extends ServiceImpl<MesEnclosureWageConfigMapper, MesEnclosureWageConfig>
   implements MesEnclosureWageConfigService {
   @Autowired
   private MesPriceModifyConfigService priceModifyConfigService;

   @Override
   public List<MesEnclosureWageConfig> listInfo() {
      return this.list();
   }

   @Override
   public MesEnclosureWageConfig detailById(Long id) {
      MesEnclosureWageConfig enclosureWageConfig = this.baseMapper.selectById(id);
      Preconditions.checkArgument(enclosureWageConfig != null, "当前围护工价配置不存在，请核对后操作");
      return enclosureWageConfig;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveEnclosureWageConfig(MesEnclosureWageConfigSaveDTOParam param) {
      Preconditions.checkArgument(this.priceModifyConfigService.isConfigured(), "价格修改配置未选择，请前往统计配置中选择");
      int repeat = this.baseMapper.selectCount(Wrappers.lambdaQuery(MesEnclosureWageConfig.class).eq(MesEnclosureWageConfig::getCategory, param.getCategory()));
      Preconditions.checkArgument(repeat == 0, "围护类型重复");
      MesEnclosureWageConfig enclosureWageConfig = BeanUtil.copy(param, MesEnclosureWageConfig.class);
      this.baseMapper.insert(enclosureWageConfig);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean editEnclosureWageConfig(MesEnclosureWageConfigSaveDTOParam param) {
      MesEnclosureWageConfig enclosureWageConfigOld = this.baseMapper.selectById(param.getId());
      Preconditions.checkArgument(enclosureWageConfigOld != null, "当前围护工价配置不存在，请核对后操作");
      int repeat = this.baseMapper
         .selectCount(
            Wrappers.lambdaQuery(MesEnclosureWageConfig.class)
               .ne(MesEnclosureWageConfig::getId, param.getId())
               .eq(MesEnclosureWageConfig::getCategory, param.getCategory())
         );
      Preconditions.checkArgument(repeat == 0, "围护类型重复");
      MesEnclosureWageConfig enclosureWageConfig = BeanUtil.copy(param, MesEnclosureWageConfig.class);
      this.baseMapper.updateById(enclosureWageConfig);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateStatus(Long id, Boolean status) {
      MesEnclosureWageConfig enclosureWageConfig = this.baseMapper.selectById(id);
      Preconditions.checkArgument(enclosureWageConfig != null, "当前围护工价配置不存在，请核对后操作");
      enclosureWageConfig.setStatus(status);
      this.baseMapper.updateById(enclosureWageConfig);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteEnclosureWageConfigById(Long id) {
      MesEnclosureWageConfig enclosureWageConfig = this.baseMapper.selectById(id);
      Preconditions.checkArgument(enclosureWageConfig != null, "当前围护工价配置不存在，请核对后操作");
      this.baseMapper.deleteById(id);
      return Boolean.TRUE;
   }
}
