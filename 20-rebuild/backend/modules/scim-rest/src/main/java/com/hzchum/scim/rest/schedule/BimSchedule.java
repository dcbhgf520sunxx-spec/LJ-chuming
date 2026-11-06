package com.hzchum.scim.rest.schedule;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hzchum.scim.bim.core.api.biz.BimModelBiz;
import com.hzchum.scim.bim.core.api.enums.BimMenuBarEnum;
import com.hzchum.scim.bim.core.api.enums.BimModelTypeEnum;
import com.hzchum.scim.bim.core.api.enums.BimStatusCommonEnum;
import com.hzchum.scim.bim.core.api.pojo._do.BimModelCommonDO;
import com.hzchum.scim.bim.core.api.service.BimModelCommonService;
import com.hzchum.scim.plan.core.api.enums.BuildingTypeEnum;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BimSchedule {
   private static final Logger log = LoggerFactory.getLogger(BimSchedule.class);
   @Resource
   private BimModelCommonService bimModelCommonService;
   @Resource
   private BimModelBiz bimModelBiz;
   @Resource
   private PlanMonomerService monomerService;

   @Scheduled(cron = "0 0 0 * * ?")
   public void updateBimModelCommon() {
      List<BimModelCommonDO> bimModelCommonDOList = this.bimModelCommonService
         .list(
            (Wrapper<BimModelCommonDO>)((new LambdaQueryWrapper<BimModelCommonDO>()
                     .eq(BimModelCommonDO::getTranslateStatus, BimStatusCommonEnum.SUCCESS.getName()))
                  .eq(BimModelCommonDO::getModelType, BimModelTypeEnum.FILETYPE.getName()))
               .eq(BimModelCommonDO::getBoolRendering, Boolean.FALSE)
         );
      if (CollectionUtils.isNotEmpty(bimModelCommonDOList)) {
         for (BimModelCommonDO bimModelCommonDO : bimModelCommonDOList) {
            try {
               PlanMonomer monomer = this.monomerService.getById(bimModelCommonDO.getMonomerId());
               if (monomer.getBuildingTypeEnum().equals(BuildingTypeEnum.BRIDGE.getType())) {
                  Map<String, List<String>> artifactStatus = this.bimModelBiz
                     .getArtifactStatus(bimModelCommonDO.getFileId(), BimMenuBarEnum.COMPONENT_TREE.getType());
                  bimModelCommonDO.setBoolRendering(Boolean.TRUE);
               }

               if (monomer.getBuildingTypeEnum().equals(BuildingTypeEnum.BUILDING.getType())) {
                  Map<String, List<String>> artifactStatus = this.bimModelBiz
                     .getOldArtifactStatus(bimModelCommonDO.getFileId(), BimMenuBarEnum.COMPONENT_TREE.getType());
                  bimModelCommonDO.setBoolRendering(Boolean.TRUE);
               }

               this.bimModelCommonService.updateById(bimModelCommonDO);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      }

      List<BimModelCommonDO> bimModelIntegrationCommonDOList = this.bimModelCommonService
         .list(
            (Wrapper<BimModelCommonDO>)((new LambdaQueryWrapper<BimModelCommonDO>()
                     .eq(BimModelCommonDO::getIntegrationStatus, BimStatusCommonEnum.SUCCESS.getName()))
                  .eq(BimModelCommonDO::getModelType, BimModelTypeEnum.INTEGRATIONTYPE.getName()))
               .eq(BimModelCommonDO::getBoolRendering, Boolean.FALSE)
         );
      if (CollectionUtils.isNotEmpty(bimModelIntegrationCommonDOList)) {
         for (BimModelCommonDO bimModelCommonDO : bimModelIntegrationCommonDOList) {
            try {
               PlanMonomer monomer = this.monomerService.getById(bimModelCommonDO.getMonomerId());
               if (monomer.getBuildingTypeEnum().equals(BuildingTypeEnum.BRIDGE.getType())) {
                  Map<String, List<String>> artifactStatus = this.bimModelBiz
                     .getArtifactStatus(bimModelCommonDO.getFileId(), BimMenuBarEnum.COMPONENT_TREE.getType());
                  bimModelCommonDO.setBoolRendering(Boolean.TRUE);
               }

               if (monomer.getBuildingTypeEnum().equals(BuildingTypeEnum.BUILDING.getType())) {
                  Map<String, List<String>> artifactStatus = this.bimModelBiz
                     .getOldArtifactStatus(bimModelCommonDO.getFileId(), BimMenuBarEnum.COMPONENT_TREE.getType());
                  bimModelCommonDO.setBoolRendering(Boolean.TRUE);
               }

               this.bimModelCommonService.updateById(bimModelCommonDO);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      }
   }
}
