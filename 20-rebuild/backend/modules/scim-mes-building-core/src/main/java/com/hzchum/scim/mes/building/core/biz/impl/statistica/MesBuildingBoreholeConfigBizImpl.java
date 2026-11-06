package com.hzchum.scim.mes.building.core.biz.impl.statistica;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.mes.building.core.api.biz.statistica.MesBuildingBoreholeConfigBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.statistica.MesBuildingBoreholeConfig;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.statistica.MesBuildingBoreholeConfigLink;
import com.hzchum.scim.mes.building.core.api.pojo._dto.statistica.MesBuildingBoreholeHoleRadiusLinkDTO;
import com.hzchum.scim.mes.building.core.api.service.statistica.MesBuildingBoreholeConfigLinkService;
import com.hzchum.scim.mes.building.core.api.service.statistica.MesBuildingBoreholeConfigService;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachineHoleRadiusLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.service.TechMachineHoleRadiusLinkService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingBoreholeConfigBizImpl implements MesBuildingBoreholeConfigBiz {
   @Resource
   private TechMachinePartService techMachinePartService;
   @Resource
   private MesBuildingBoreholeConfigService mesBuildingBoreholeConfigService;
   @Resource
   private TechMachineHoleRadiusLinkService techMachineHoleRadiusLinkService;
   @Resource
   private MesBuildingBoreholeConfigLinkService mesBuildingBoreholeConfigLinkService;

   @Override
   public List<MesBuildingBoreholeHoleRadiusLinkDTO> getBoreholeConfigPrice(Long productId) {
      TechMachinePart machinePart = this.techMachinePartService.getById(productId);
      Preconditions.checkArgument(machinePart != null, "零件产品不存在!!!");
      MesBuildingBoreholeConfig boreholeConfig = this.mesBuildingBoreholeConfigService
         .getOne(
            (Wrapper<MesBuildingBoreholeConfig>)((new LambdaQueryWrapper<MesBuildingBoreholeConfig>()
                     .eq(MesBuildingBoreholeConfig::getSpecPrefix, machinePart.getSpecPrefix()))
                  .gt(MesBuildingBoreholeConfig::getMaxThickness, machinePart.getThick()))
               .lt(MesBuildingBoreholeConfig::getMinThickness, machinePart.getThick())
         );
      List<MesBuildingBoreholeHoleRadiusLinkDTO> linkDTOS = new ArrayList<>();
      if (boreholeConfig != null) {
         List<MesBuildingBoreholeConfigLink> configLinks = this.mesBuildingBoreholeConfigLinkService
            .list(
               (Wrapper<MesBuildingBoreholeConfigLink>)new LambdaQueryWrapper<MesBuildingBoreholeConfigLink>().eq(MesBuildingBoreholeConfigLink::getBoreholeConfigId, boreholeConfig.getId())
            );
         List<TechMachineHoleRadiusLink> holeRadiusLinks = this.techMachineHoleRadiusLinkService
            .list(
               (Wrapper<TechMachineHoleRadiusLink>)(new LambdaQueryWrapper<TechMachineHoleRadiusLink>()
                     .eq(TechMachineHoleRadiusLink::getMonomerId, machinePart.getMonomerId()))
                  .eq(TechMachineHoleRadiusLink::getSerialNumber, machinePart.getSerialNumber())
            );
         if (CollectionUtils.isNotEmpty(holeRadiusLinks) && CollectionUtils.isNotEmpty(configLinks)) {
            holeRadiusLinks.forEach(e -> {
               for (MesBuildingBoreholeConfigLink link : configLinks) {
                  if (link.getMaxBoreDiameter().compareTo(e.getRadius()) >= 0 && link.getMinBoreDiameter().compareTo(e.getRadius()) <= 0) {
                     MesBuildingBoreholeHoleRadiusLinkDTO linkDTO = BeanUtil.copy(link, MesBuildingBoreholeHoleRadiusLinkDTO.class);
                     linkDTO.setHoleRadiusLinkId(e.getId());
                     linkDTOS.add(linkDTO);
                     return;
                  }
               }
            });
         }
      }

      return linkDTOS;
   }
}
