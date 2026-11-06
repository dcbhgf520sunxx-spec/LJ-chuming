package com.hzchum.scim.mes.building.core.service.impl.wage_quota;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.mes.building.core.api.enums.wage_quota.TempWorkQuotaConfigTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_quota.MesTempWorkQuotaConfig;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_quota.MesTempWorkQuotaConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_quota.MesTempWorkQuotaConfigParam;
import com.hzchum.scim.mes.building.core.api.service.wage_quota.MesTempWorkQuotaConfigService;
import com.hzchum.scim.mes.building.core.mapper.wage_quota.MesTempWorkQuotaConfigMapper;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesTempWorkQuotaConfigServiceImpl
   extends ServiceImpl<MesTempWorkQuotaConfigMapper, MesTempWorkQuotaConfig>
   implements MesTempWorkQuotaConfigService {
   @Override
   public List<MesTempWorkQuotaConfigDTO> listInfo() {
      List<MesTempWorkQuotaConfig> list = this.list();
      return BeanUtil.copyToList(list, MesTempWorkQuotaConfigDTO.class);
   }

   private void verifyParam(MesTempWorkQuotaConfigParam param) {
      if (TempWorkQuotaConfigTypeEnum.HOURLY_WAGE.getType().equals(param.getType())) {
         Preconditions.checkArgument(param.getPrice() != null, "计时工价不能为空");
      }

      List<MesTempWorkQuotaConfig> list = this.lambdaQuery()
         .ne(param.getId() != null, MesTempWorkQuotaConfig::getId, param.getId())
         .eq(MesTempWorkQuotaConfig::getName, param.getName())
         .list();
      Preconditions.checkArgument(CollUtil.isEmpty(list), "点工类型不能重复");
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean add(MesTempWorkQuotaConfigParam param) {
      this.verifyParam(param);
      MesTempWorkQuotaConfig config = BeanUtil.toBean(param, MesTempWorkQuotaConfig.class);
      config.setStatus(true);
      this.save(config);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean edit(MesTempWorkQuotaConfigParam param) {
      MesTempWorkQuotaConfig oldConfig = this.getById(param.getId());
      Preconditions.checkArgument(BeanUtil.isNotEmpty(oldConfig), "数据不存在, 请刷新后重试");
      this.verifyParam(param);
      MesTempWorkQuotaConfig config = BeanUtil.toBean(param, MesTempWorkQuotaConfig.class);
      this.updateById(config);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean editStatus(Long id, Boolean status) {
      MesTempWorkQuotaConfig config = this.getById(id);
      Preconditions.checkArgument(BeanUtil.isNotEmpty(config), "数据不存在, 请刷新后重试");
      config.setStatus(status);
      this.updateById(config);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteById(Long id) {
      MesTempWorkQuotaConfig config = this.getById(id);
      Preconditions.checkArgument(BeanUtil.isNotEmpty(config), "数据不存在, 请刷新后重试");
      this.removeById(id);
      return true;
   }
}
