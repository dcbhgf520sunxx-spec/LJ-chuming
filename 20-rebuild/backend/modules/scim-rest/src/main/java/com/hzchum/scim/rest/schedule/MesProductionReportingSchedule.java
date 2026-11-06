package com.hzchum.scim.rest.schedule;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesProductionReportingApprovalWhitelist;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesProductionReportingApprovalReportSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesProductionReportingApprovalWhitelistDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesProductionReportingApprovalPassedParam;
import com.hzchum.scim.mes.building.core.api.service.quota_config.MesProductionReportingApprovalPassedService;
import com.hzchum.scim.mes.building.core.api.service.quota_config.MesProductionReportingApprovalWhitelistService;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MesProductionReportingSchedule {
   private static final Logger log = LoggerFactory.getLogger(MesProductionReportingSchedule.class);
   @Autowired
   private MesProductionReportingApprovalPassedService productionReportingApprovalPassedService;
   @Autowired
   private MesProductionReportingApprovalWhitelistService whitelistService;

   @Scheduled(cron = "0 1 0 * * ?")
   public void schedule() {
      log.info("报工审核白名单数据自动审核通过开始======================================================================>");
      List<MesProductionReportingApprovalWhitelistDTO> whitelistDTOList = this.whitelistService.listInfo();
      if (CollUtil.isNotEmpty(whitelistDTOList)) {
         LocalDate now = LocalDate.now();
         List<Long> workshopIdList = whitelistDTOList.stream()
            .map(MesProductionReportingApprovalWhitelistDTO::getWorkshopIdList)
            .filter(CollUtil::isNotEmpty)
            .flatMap(Collection::stream)
            .filter(ObjectUtil::isNotNull)
            .distinct()
            .collect(Collectors.toList());
         List<Long> processIdList = whitelistDTOList.stream().map(MesProductionReportingApprovalWhitelist::getProcessId).collect(Collectors.toList());
         List<Long> teamIdList = whitelistDTOList.stream()
            .map(MesProductionReportingApprovalWhitelistDTO::getTeamIdList)
            .filter(CollUtil::isNotEmpty)
            .flatMap(Collection::stream)
            .filter(ObjectUtil::isNotNull)
            .distinct()
            .collect(Collectors.toList());
         List<MesProductionReportingApprovalReportSummaryDTO> whitelistUnapprovedList = this.productionReportingApprovalPassedService
            .whitelistUnapprovedList(ProductTypeEnum.ARTIFACT.getType(), workshopIdList, processIdList, teamIdList, now);
         whitelistUnapprovedList.addAll(
            this.productionReportingApprovalPassedService
               .whitelistUnapprovedList(ProductTypeEnum.ASSEMBLE.getType(), workshopIdList, processIdList, teamIdList, now)
         );
         whitelistUnapprovedList.addAll(
            this.productionReportingApprovalPassedService
               .whitelistUnapprovedList(ProductTypeEnum.MACHINE_PART.getType(), workshopIdList, processIdList, teamIdList, now)
         );
         List<MesProductionReportingApprovalReportSummaryDTO> whitelistUnapprovedEnclosureList = this.productionReportingApprovalPassedService
            .whitelistUnapprovedEnclosureList(workshopIdList, processIdList, teamIdList, now);
         whitelistUnapprovedList.addAll(whitelistUnapprovedEnclosureList);
         if (CollUtil.isNotEmpty(whitelistUnapprovedList)) {
            whitelistDTOList.forEach(
               whitelist -> {
                  List<MesProductionReportingApprovalPassedParam> paramList = whitelistUnapprovedList.stream()
                     .filter(
                        unapproved -> whitelist.getWorkshopIdList().contains(unapproved.getWorkshop().getId())
                           && Objects.equals(whitelist.getProcessId(), unapproved.getProcess().getId())
                           && whitelist.getTeamIdList().contains(unapproved.getTeam().getId())
                           && unapproved.getPrice() != null
                           && unapproved.getMeasurementQuantity() != null
                     )
                     .map(unapproved -> {
                        MesProductionReportingApprovalPassedParam param = new MesProductionReportingApprovalPassedParam();
                        param.setBoolAutomaticApproval(true);
                        param.setWorkshopId(unapproved.getWorkshop().getId());
                        param.setProjectId(unapproved.getProject().getId());
                        param.setProductTypeEnum(unapproved.getProduct().getProductTypeEnum());
                        param.setProcessId(unapproved.getProcess().getId());
                        param.setTeamId(unapproved.getTeam().getId());
                        param.setReportQuantity(unapproved.getReportQuantity());
                        param.setReportDate(now);
                        param.setQuotaConfigId(unapproved.getQuotaConfigId());
                        param.setQuotaConfigSerialNumber(unapproved.getQuotaConfigSerialNumber());
                        param.setQuotaMatchingCondition(unapproved.getQuotaMatchingCondition());
                        param.setMeasureUnit(unapproved.getMeasureUnit());
                        param.setMeasurementQuantity(unapproved.getMeasurementQuantity());
                        param.setPrice(unapproved.getPrice());
                        param.setAmount(unapproved.getAmount());
                        param.setProduceTeamReportIds(unapproved.getProduceTeamReportIds());
                        if (Objects.equals(ProductTypeEnum.ENCLOSURE.getType(), unapproved.getProduct().getProductTypeEnum())) {
                           param.setDictionaryId(unapproved.getProduct().getDictionaryId());
                        } else {
                           param.setMonomerId(unapproved.getMonomer().getId());
                           param.setAreaId(unapproved.getArea().getId());
                           param.setProductClassificationEnum(unapproved.getProduct().getProductClassificationEnum());
                           param.setProductClassId(unapproved.getProduct().getClassId());
                           param.setProductId(unapproved.getProduct().getId());
                        }

                        return param;
                     })
                     .collect(Collectors.toList());
                  this.productionReportingApprovalPassedService.batchAdd(paramList);
               }
            );
         }
      }

      log.info("报工审核白名单数据自动审核通过结束======================================================================>");
   }
}
