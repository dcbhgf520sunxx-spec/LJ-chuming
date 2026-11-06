package com.hzchum.scim.crm.core.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.crm.core.api.biz.CrmInformationValidityPeriodConfigBiz;
import com.hzchum.scim.crm.core.api.enums.CrmInformationValidityPeriodConfigEnum;
import com.hzchum.scim.crm.core.api.pojo._do.CrmInformationValidityPeriodConfig;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmInformationValidityPeriodConfigDTO;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmInformationValidityPeriodConfigUpdateParam;
import com.hzchum.scim.crm.core.api.service.CrmInformationValidityPeriodConfigService;
import com.hzchum.scim.crm.core.mapper.CrmInformationValidityPeriodConfigMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CrmInformationValidityPeriodConfigBizImpl
   extends IBizImpl<CrmInformationValidityPeriodConfigService, CrmInformationValidityPeriodConfigMapper, CrmInformationValidityPeriodConfig>
   implements CrmInformationValidityPeriodConfigBiz {
   @Override
   public List<CrmInformationValidityPeriodConfigDTO> getList(Integer crmInformationValidityPeriodConfigEnum) {
      List<CrmInformationValidityPeriodConfigDTO> crmInformationValidityPeriodConfigDTOS = new ArrayList<>();
      CrmInformationValidityPeriodConfigDTO crmInformationValidityPeriodConfigDTO = CrmInformationValidityPeriodConfigDTO.builder()
         .crmInformationValidityPeriodConfigEnum(crmInformationValidityPeriodConfigEnum)
         .crmInformationValidityPeriodConfigEnumName(CrmInformationValidityPeriodConfigEnum.getNameByType(crmInformationValidityPeriodConfigEnum))
         .build();
      CrmInformationValidityPeriodConfig crmInformationValidityPeriodConfig = this.baseService
         .getOne(
            Wrappers.lambdaQuery(CrmInformationValidityPeriodConfig.class)
               .eq(CrmInformationValidityPeriodConfig::getCrmInformationValidityPeriodConfigEnum, crmInformationValidityPeriodConfigEnum)
         );
      if (crmInformationValidityPeriodConfig != null) {
         if (crmInformationValidityPeriodConfigEnum.equals(CrmInformationValidityPeriodConfigEnum.NUMBER_OF_PROJECT_QUOTA_ALLOCATION.getType())) {
            crmInformationValidityPeriodConfigDTO.setProjectQuota(crmInformationValidityPeriodConfig.getProjectQuota());
         } else {
            crmInformationValidityPeriodConfigDTO.setId(crmInformationValidityPeriodConfig.getId());
            crmInformationValidityPeriodConfigDTO.setRemindInAdvance(crmInformationValidityPeriodConfig.getRemindInAdvance());
            if (crmInformationValidityPeriodConfigEnum.equals(CrmInformationValidityPeriodConfigEnum.INFORMATION_VALIDITY_PERIOD.getType())) {
               crmInformationValidityPeriodConfigDTO.setValidityOfRegistration(crmInformationValidityPeriodConfig.getValidityOfRegistration());
            }
         }
      }

      crmInformationValidityPeriodConfigDTOS.add(crmInformationValidityPeriodConfigDTO);
      return crmInformationValidityPeriodConfigDTOS;
   }

   @Transactional
   @Override
   public Boolean updateByList(List<CrmInformationValidityPeriodConfigUpdateParam> list, Integer crmInformationValidityPeriodConfigEnum) {
      List<CrmInformationValidityPeriodConfig> updateList = new ArrayList<>();
      List<CrmInformationValidityPeriodConfig> saveList = new ArrayList<>();
      list.forEach(
         item -> {
            CrmInformationValidityPeriodConfig crmInformationValidityPeriodConfig = this.baseService
               .getOne(
                  Wrappers.lambdaQuery(CrmInformationValidityPeriodConfig.class)
                     .eq(CrmInformationValidityPeriodConfig::getCrmInformationValidityPeriodConfigEnum, crmInformationValidityPeriodConfigEnum)
               );
            if (crmInformationValidityPeriodConfig == null) {
               saveList.add(
                  CrmInformationValidityPeriodConfig.builder()
                     .crmInformationValidityPeriodConfigEnum(crmInformationValidityPeriodConfigEnum)
                     .remindInAdvance(item.getRemindInAdvance())
                     .projectQuota(item.getProjectQuota())
                     .validityOfRegistration(item.getValidityOfRegistration())
                     .build()
               );
            } else {
               updateList.add(
                  CrmInformationValidityPeriodConfig.builder()
                     .id(crmInformationValidityPeriodConfig.getId())
                     .projectQuota(item.getProjectQuota())
                     .crmInformationValidityPeriodConfigEnum(crmInformationValidityPeriodConfigEnum)
                     .remindInAdvance(item.getRemindInAdvance())
                     .validityOfRegistration(item.getValidityOfRegistration())
                     .build()
               );
            }
         }
      );
      this.baseService.saveBatch(saveList);
      this.baseService.updateBatchById(updateList);
      return Boolean.TRUE;
   }

   @Override
   public List<CrmInformationValidityPeriodConfigDTO> getListSkipPermissions(Integer crmInformationValidityPeriodConfigEnum) {
      List<CrmInformationValidityPeriodConfigDTO> crmInformationValidityPeriodConfigDTOS = new ArrayList<>();
      if (crmInformationValidityPeriodConfigEnum != null) {
         CrmInformationValidityPeriodConfigDTO crmInformationValidityPeriodConfigDTO = CrmInformationValidityPeriodConfigDTO.builder()
            .crmInformationValidityPeriodConfigEnum(crmInformationValidityPeriodConfigEnum)
            .crmInformationValidityPeriodConfigEnumName(CrmInformationValidityPeriodConfigEnum.getNameByType(crmInformationValidityPeriodConfigEnum))
            .build();
         CrmInformationValidityPeriodConfig crmInformationValidityPeriodConfig = this.baseService
            .getOne(
               Wrappers.lambdaQuery(CrmInformationValidityPeriodConfig.class)
                  .eq(CrmInformationValidityPeriodConfig::getCrmInformationValidityPeriodConfigEnum, crmInformationValidityPeriodConfigEnum)
            );
         if (crmInformationValidityPeriodConfig != null) {
            if (crmInformationValidityPeriodConfigEnum.equals(CrmInformationValidityPeriodConfigEnum.NUMBER_OF_PROJECT_QUOTA_ALLOCATION.getType())) {
               crmInformationValidityPeriodConfigDTO.setProjectQuota(crmInformationValidityPeriodConfig.getProjectQuota());
            } else {
               crmInformationValidityPeriodConfigDTO.setId(crmInformationValidityPeriodConfig.getId());
               crmInformationValidityPeriodConfigDTO.setRemindInAdvance(crmInformationValidityPeriodConfig.getRemindInAdvance());
               if (crmInformationValidityPeriodConfigEnum.equals(CrmInformationValidityPeriodConfigEnum.INFORMATION_VALIDITY_PERIOD.getType())) {
                  crmInformationValidityPeriodConfigDTO.setValidityOfRegistration(crmInformationValidityPeriodConfig.getValidityOfRegistration());
               }
            }
         }

         crmInformationValidityPeriodConfigDTOS.add(crmInformationValidityPeriodConfigDTO);
         return crmInformationValidityPeriodConfigDTOS;
      } else {
         CrmInformationValidityPeriodConfigEnum[] values = CrmInformationValidityPeriodConfigEnum.values();

         for (CrmInformationValidityPeriodConfigEnum value : values) {
            CrmInformationValidityPeriodConfigDTO crmInformationValidityPeriodConfigDTO = CrmInformationValidityPeriodConfigDTO.builder()
               .crmInformationValidityPeriodConfigEnum(value.getType())
               .crmInformationValidityPeriodConfigEnumName(value.getName())
               .build();
            CrmInformationValidityPeriodConfig crmInformationValidityPeriodConfig = this.baseService
               .getOne(
                  Wrappers.lambdaQuery(CrmInformationValidityPeriodConfig.class)
                     .eq(CrmInformationValidityPeriodConfig::getCrmInformationValidityPeriodConfigEnum, value.getType())
               );
            if (crmInformationValidityPeriodConfig != null) {
               if (value.getType().equals(CrmInformationValidityPeriodConfigEnum.NUMBER_OF_PROJECT_QUOTA_ALLOCATION.getType())) {
                  crmInformationValidityPeriodConfigDTO.setProjectQuota(crmInformationValidityPeriodConfig.getProjectQuota());
               } else {
                  crmInformationValidityPeriodConfigDTO.setId(crmInformationValidityPeriodConfig.getId());
                  crmInformationValidityPeriodConfigDTO.setRemindInAdvance(crmInformationValidityPeriodConfig.getRemindInAdvance());
                  if (value.getType().equals(CrmInformationValidityPeriodConfigEnum.INFORMATION_VALIDITY_PERIOD.getType())) {
                     crmInformationValidityPeriodConfigDTO.setValidityOfRegistration(crmInformationValidityPeriodConfig.getValidityOfRegistration());
                  }
               }
            }

            crmInformationValidityPeriodConfigDTOS.add(crmInformationValidityPeriodConfigDTO);
         }

         return crmInformationValidityPeriodConfigDTOS;
      }
   }
}
