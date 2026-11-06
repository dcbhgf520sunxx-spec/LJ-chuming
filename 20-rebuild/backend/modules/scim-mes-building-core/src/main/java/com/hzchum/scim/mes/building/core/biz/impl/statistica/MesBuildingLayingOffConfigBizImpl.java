package com.hzchum.scim.mes.building.core.biz.impl.statistica;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.mes.building.core.api.biz.statistica.MesBuildingLayingOffConfigBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingCutConfig;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingMachinePartTeamDetail;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.statistica.MesBuildingLayingOffConfig;
import com.hzchum.scim.mes.building.core.api.pojo._dto.statistica.MesBuildingLayingOffConfigDTO;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingCutConfigService;
import com.hzchum.scim.mes.building.core.api.service.statistica.MesBuildingLayingOffConfigService;
import com.hzchum.scim.mes.building.core.api.service.team.MesBuildingMachinePartTeamDetailService;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import java.math.BigDecimal;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingLayingOffConfigBizImpl implements MesBuildingLayingOffConfigBiz {
   @Resource
   private TechMachinePartService techMachinePartService;
   @Resource
   private MesBuildingLayingOffConfigService mesBuildingLayingOffConfigService;
   @Resource
   private MesBuildingCutConfigService mesBuildingCutConfigService;
   @Resource
   private MesBuildingMachinePartTeamDetailService mesBuildingMachinePartTeamDetailService;

   @Override
   public MesBuildingLayingOffConfigDTO getLayingOffConfig(Long productId, Long cutConfigId) {
      TechMachinePart part = this.techMachinePartService.getById(productId);
      Preconditions.checkArgument(part != null, "零件产品不存在!!!");
      MesBuildingMachinePartTeamDetail mesBuildingMachinePartTeamDetail = this.mesBuildingMachinePartTeamDetailService.getById(cutConfigId);
      List<MesBuildingCutConfig> mesBuildingCutConfigList = this.mesBuildingCutConfigService
         .list((Wrapper<MesBuildingCutConfig>)new LambdaQueryWrapper<MesBuildingCutConfig>().eq(MesBuildingCutConfig::getName, mesBuildingMachinePartTeamDetail.getDeviceType()));
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(mesBuildingCutConfigList), "切割配置不存在!!!");
      MesBuildingCutConfig cutConfig = mesBuildingCutConfigList.get(0);
      List<MesBuildingLayingOffConfig> layingOffConfigs = this.mesBuildingLayingOffConfigService
         .list(
            (Wrapper<MesBuildingLayingOffConfig>)(new LambdaQueryWrapper<MesBuildingLayingOffConfig>().eq(MesBuildingLayingOffConfig::getCutConfigId, cutConfigId))
               .eq(MesBuildingLayingOffConfig::getSpecPrefix, part.getSpecPrefix())
         );
      if (CollectionUtils.isNotEmpty(layingOffConfigs)) {
         for (MesBuildingLayingOffConfig config : layingOffConfigs) {
            if (config.getMaxNumerical().compareTo(new BigDecimal(part.getThick())) >= 0
               && config.getMinNumerical().compareTo(new BigDecimal(part.getThick())) <= 0) {
               return BeanUtil.copy(config, MesBuildingLayingOffConfigDTO.class);
            }
         }
      }

      return null;
   }
}
