package com.hzchum.scim.system.core.biz.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.scim.system.core.api.biz.MesContractProjectWageConfigBiz;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectAssemblingWeldingConfigLink;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectAssemblingWeldingConfigLinkDetail;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectBoltSleeveLink;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectCoatingConfigLink;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectDrillHoleConfigLink;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectDrillHoleConfigLinkDetail;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectGroupWeldingConfigLink;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectGroupWeldingConfigLinkDetail;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectLayingOffConfigLink;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectLayingOffConfigLinkDetail;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectOddJobConfigLink;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectOtherApportionmentLink;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectStatisticsConfigLink;
import com.hzchum.scim.system.core.api.service.MesContractProjectAssemblingWeldingConfigLinkDetailService;
import com.hzchum.scim.system.core.api.service.MesContractProjectAssemblingWeldingConfigLinkService;
import com.hzchum.scim.system.core.api.service.MesContractProjectBoltSleeveLinkService;
import com.hzchum.scim.system.core.api.service.MesContractProjectCoatingConfigLinkService;
import com.hzchum.scim.system.core.api.service.MesContractProjectDrillHoleConfigLinkDetailService;
import com.hzchum.scim.system.core.api.service.MesContractProjectDrillHoleConfigLinkService;
import com.hzchum.scim.system.core.api.service.MesContractProjectGroupWeldingConfigLinkDetailService;
import com.hzchum.scim.system.core.api.service.MesContractProjectGroupWeldingConfigLinkService;
import com.hzchum.scim.system.core.api.service.MesContractProjectLayingOffConfigLinkDetailService;
import com.hzchum.scim.system.core.api.service.MesContractProjectLayingOffConfigLinkService;
import com.hzchum.scim.system.core.api.service.MesContractProjectOddJobConfigLinkService;
import com.hzchum.scim.system.core.api.service.MesContractProjectOtherApportionmentLinkService;
import com.hzchum.scim.system.core.api.service.MesContractProjectStatisticsConfigLinkService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesContractProjectWageConfigBizImpl implements MesContractProjectWageConfigBiz {
   @Autowired
   private MesContractProjectStatisticsConfigLinkService statisticsConfigLinkService;
   @Autowired
   private MesContractProjectLayingOffConfigLinkService layingOffConfigLinkService;
   @Autowired
   private MesContractProjectLayingOffConfigLinkDetailService layingOffConfigLinkDetailService;
   @Autowired
   private MesContractProjectGroupWeldingConfigLinkService groupWeldingConfigLinkService;
   @Autowired
   private MesContractProjectGroupWeldingConfigLinkDetailService groupWeldingConfigLinkDetailService;
   @Autowired
   private MesContractProjectAssemblingWeldingConfigLinkService assemblingWeldingConfigLinkService;
   @Autowired
   private MesContractProjectAssemblingWeldingConfigLinkDetailService assemblingWeldingConfigLinkDetailService;
   @Autowired
   private MesContractProjectCoatingConfigLinkService coatingConfigLinkService;
   @Autowired
   private MesContractProjectBoltSleeveLinkService boltSleeveLinkService;
   @Autowired
   private MesContractProjectOtherApportionmentLinkService otherApportionmentLinkService;
   @Autowired
   private MesContractProjectDrillHoleConfigLinkService drillHoleConfigLinkService;
   @Autowired
   private MesContractProjectDrillHoleConfigLinkDetailService drillHoleConfigLinkDetailService;
   @Autowired
   private MesContractProjectOddJobConfigLinkService oddJobConfigLinkService;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveContractProjectWageConfig(Long projectId) {
      Preconditions.checkArgument(!this.existsConfig(projectId), "当前项目已存在工价配置");
      this.statisticsConfigLinkService.saveContractProjectStatisticsConfig(projectId);
      MesContractProjectStatisticsConfigLink projectStatisticsConfigLink = this.statisticsConfigLinkService
         .getOne(Wrappers.lambdaQuery(MesContractProjectStatisticsConfigLink.class).eq(MesContractProjectStatisticsConfigLink::getContractProjectId, projectId));
      this.layingOffConfigLinkService.saveContractProjectLayingOffConfigLink(projectId, projectStatisticsConfigLink.getStatisticsMode());
      this.drillHoleConfigLinkService.saveContractProjectDrillHoleConfigLink(projectId, projectStatisticsConfigLink.getStatisticsMode());
      this.groupWeldingConfigLinkService.saveContractProjectGroupWeldingConfigLink(projectId);
      this.assemblingWeldingConfigLinkService.saveContractProjectAssemblingWeldingConfigLink(projectId);
      this.coatingConfigLinkService.saveContractProjectCoatingConfigLink(projectId);
      this.boltSleeveLinkService.saveContractProjectBoltSleeveLink(projectId);
      this.otherApportionmentLinkService.saveContractProjectOtherApportionmentLink(projectId);
      this.oddJobConfigLinkService.saveContractProjectOddJobConfigLink(projectId);
      return Boolean.TRUE;
   }

   @Override
   public Boolean existsConfig(Long projectId) {
      int count = this.statisticsConfigLinkService
         .count(Wrappers.lambdaQuery(MesContractProjectStatisticsConfigLink.class).eq(MesContractProjectStatisticsConfigLink::getContractProjectId, projectId));
      return count > 0;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteContractProjectWageConfig(Long projectId) {
      Preconditions.checkArgument(this.existsConfig(projectId), "当前项目无工价配置");
      this.statisticsConfigLinkService
         .remove(Wrappers.lambdaQuery(MesContractProjectStatisticsConfigLink.class).eq(MesContractProjectStatisticsConfigLink::getContractProjectId, projectId));
      this.layingOffConfigLinkService
         .remove(Wrappers.lambdaQuery(MesContractProjectLayingOffConfigLink.class).eq(MesContractProjectLayingOffConfigLink::getContractProjectId, projectId));
      List<Long> layingOffConfigLinkIdList = this.layingOffConfigLinkService
         .list(Wrappers.lambdaQuery(MesContractProjectLayingOffConfigLink.class).eq(MesContractProjectLayingOffConfigLink::getContractProjectId, projectId))
         .stream()
         .map(MesContractProjectLayingOffConfigLink::getId)
         .collect(Collectors.toList());
      if (CollUtil.isNotEmpty(layingOffConfigLinkIdList)) {
         this.layingOffConfigLinkDetailService
            .remove(
               Wrappers.lambdaQuery(MesContractProjectLayingOffConfigLinkDetail.class)
                  .in(MesContractProjectLayingOffConfigLinkDetail::getContractProjectLayingOffConfigLinkId, layingOffConfigLinkIdList)
            );
      }

      this.drillHoleConfigLinkService
         .remove(Wrappers.lambdaQuery(MesContractProjectDrillHoleConfigLink.class).eq(MesContractProjectDrillHoleConfigLink::getContractProjectId, projectId));
      List<Long> drillHoleConfigLinkIdList = this.drillHoleConfigLinkService
         .list(Wrappers.lambdaQuery(MesContractProjectDrillHoleConfigLink.class).eq(MesContractProjectDrillHoleConfigLink::getContractProjectId, projectId))
         .stream()
         .map(MesContractProjectDrillHoleConfigLink::getId)
         .collect(Collectors.toList());
      if (CollUtil.isNotEmpty(drillHoleConfigLinkIdList)) {
         this.drillHoleConfigLinkDetailService
            .remove(
               Wrappers.lambdaQuery(MesContractProjectDrillHoleConfigLinkDetail.class)
                  .in(MesContractProjectDrillHoleConfigLinkDetail::getContractProjectDrillHoleConfigLinkId, drillHoleConfigLinkIdList)
            );
      }

      this.groupWeldingConfigLinkService
         .remove(
            Wrappers.lambdaQuery(MesContractProjectGroupWeldingConfigLink.class).eq(MesContractProjectGroupWeldingConfigLink::getContractProjectId, projectId)
         );
      List<Long> groupWeldingConfigLinkIdList = this.groupWeldingConfigLinkService
         .list(
            Wrappers.lambdaQuery(MesContractProjectGroupWeldingConfigLink.class).eq(MesContractProjectGroupWeldingConfigLink::getContractProjectId, projectId)
         )
         .stream()
         .map(MesContractProjectGroupWeldingConfigLink::getId)
         .collect(Collectors.toList());
      if (CollUtil.isNotEmpty(groupWeldingConfigLinkIdList)) {
         this.groupWeldingConfigLinkDetailService
            .remove(
               Wrappers.lambdaQuery(MesContractProjectGroupWeldingConfigLinkDetail.class)
                  .in(MesContractProjectGroupWeldingConfigLinkDetail::getContractProjectGroupWeldingConfigLinkId, groupWeldingConfigLinkIdList)
            );
      }

      this.assemblingWeldingConfigLinkService
         .remove(
            Wrappers.lambdaQuery(MesContractProjectAssemblingWeldingConfigLink.class)
               .eq(MesContractProjectAssemblingWeldingConfigLink::getContractProjectId, projectId)
         );
      List<Long> assemblingWeldingConfigLinkIdList = this.assemblingWeldingConfigLinkService
         .list(
            Wrappers.lambdaQuery(MesContractProjectAssemblingWeldingConfigLink.class)
               .eq(MesContractProjectAssemblingWeldingConfigLink::getContractProjectId, projectId)
         )
         .stream()
         .map(MesContractProjectAssemblingWeldingConfigLink::getId)
         .collect(Collectors.toList());
      if (CollUtil.isNotEmpty(assemblingWeldingConfigLinkIdList)) {
         this.assemblingWeldingConfigLinkDetailService
            .remove(
               Wrappers.lambdaQuery(MesContractProjectAssemblingWeldingConfigLinkDetail.class)
                  .in(MesContractProjectAssemblingWeldingConfigLinkDetail::getContractProjectAssemblingWeldingConfigLinkId, assemblingWeldingConfigLinkIdList)
            );
      }

      this.coatingConfigLinkService
         .remove(Wrappers.lambdaQuery(MesContractProjectCoatingConfigLink.class).eq(MesContractProjectCoatingConfigLink::getContractProjectId, projectId));
      this.boltSleeveLinkService
         .remove(Wrappers.lambdaQuery(MesContractProjectBoltSleeveLink.class).eq(MesContractProjectBoltSleeveLink::getContractProjectId, projectId));
      this.otherApportionmentLinkService
         .remove(
            Wrappers.lambdaQuery(MesContractProjectOtherApportionmentLink.class).eq(MesContractProjectOtherApportionmentLink::getContractProjectId, projectId)
         );
      this.oddJobConfigLinkService
         .remove(Wrappers.lambdaQuery(MesContractProjectOddJobConfigLink.class).eq(MesContractProjectOddJobConfigLink::getContractProjectId, projectId));
      return Boolean.TRUE;
   }
}
