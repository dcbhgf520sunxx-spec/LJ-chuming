package com.hzchum.scim.system.core.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.system.core.api.common.enums.PriceModifySceneEnum;
import com.hzchum.scim.system.core.api.pojo._do.MesPriceModifyConfig;
import com.hzchum.scim.system.core.api.pojo.request.MesPriceModifyConfigSaveDTOParam;
import com.hzchum.scim.system.core.api.service.MesPriceModifyConfigService;
import com.hzchum.scim.system.core.mapper.MesPriceModifyConfigMapper;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesPriceModifyConfigServiceImpl extends ServiceImpl<MesPriceModifyConfigMapper, MesPriceModifyConfig> implements MesPriceModifyConfigService {
   @Override
   public MesPriceModifyConfig getInfo() {
      List<MesPriceModifyConfig> priceModifyConfigList = this.baseMapper.selectList(Wrappers.emptyWrapper());
      return CollUtil.isNotEmpty(priceModifyConfigList) ? priceModifyConfigList.get(0) : null;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean editPriceModifyConfig(MesPriceModifyConfigSaveDTOParam param) {
      if (PriceModifySceneEnum.SYNC_PRICE_BEFORE_MODIFICATION.getType().equals(param.getConfigPrice())) {
         Preconditions.checkArgument(param.getConfigPriceSyncStartDate() != null, "配置价格同步开始日期不能为空");
         Preconditions.checkArgument(param.getConfigPriceSyncEndDate() != null, "配置价格同步结束日期不能为空");
      }

      if (param.getIndividualPrice() != null && PriceModifySceneEnum.SYNC_PRICE_BEFORE_MODIFICATION.getType().equals(param.getIndividualPrice())) {
         Preconditions.checkArgument(param.getIndividualPriceSyncStartDate() != null, "单个价格同步开始日期不能为空");
         Preconditions.checkArgument(param.getIndividualPriceSyncEndDate() != null, "单个价格同步结束日期不能为空");
      }

      Integer count = this.baseMapper.selectCount(Wrappers.emptyWrapper());
      if (count == 0) {
         MesPriceModifyConfig priceModifyConfig = BeanUtil.toBean(param, MesPriceModifyConfig.class);
         this.baseMapper.insert(priceModifyConfig);
         return Boolean.TRUE;
      } else {
         MesPriceModifyConfig priceModifyConfigOld = this.baseMapper.selectById(param.getId());
         Preconditions.checkArgument(priceModifyConfigOld != null, "当前价格修改配置不存在，请核对后操作");
         MesPriceModifyConfig priceModifyConfig = BeanUtil.toBean(param, MesPriceModifyConfig.class);
         this.baseMapper.updateById(priceModifyConfig);
         return Boolean.TRUE;
      }
   }

   @Override
   public Boolean isConfigured() {
      List<MesPriceModifyConfig> priceModifyConfigList = this.baseMapper.selectList(Wrappers.emptyWrapper());
      if (CollUtil.isNotEmpty(priceModifyConfigList)) {
         MesPriceModifyConfig priceModifyConfig = priceModifyConfigList.get(0);
         if (priceModifyConfig.getConfigPrice() != null) {
            return Boolean.TRUE;
         }
      }

      return Boolean.FALSE;
   }
}
