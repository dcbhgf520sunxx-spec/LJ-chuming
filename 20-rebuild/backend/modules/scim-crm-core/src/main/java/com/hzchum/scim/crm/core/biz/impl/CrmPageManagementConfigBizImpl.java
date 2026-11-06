package com.hzchum.scim.crm.core.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.crm.core.api.biz.CrmPageManagementConfigBiz;
import com.hzchum.scim.crm.core.api.enums.CrmFieldParentTypeEnum;
import com.hzchum.scim.crm.core.api.enums.CrmPageManagementConfigEnum;
import com.hzchum.scim.crm.core.api.pojo._do.CrmPageManagementConfig;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmPageManagementConfigDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmStyleLayoutDTO;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmPageManagementConfigUpdateParam;
import com.hzchum.scim.crm.core.api.service.CrmPageManagementConfigService;
import com.hzchum.scim.crm.core.mapper.CrmPageManagementConfigMapper;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CrmPageManagementConfigBizImpl
   extends IBizImpl<CrmPageManagementConfigService, CrmPageManagementConfigMapper, CrmPageManagementConfig>
   implements CrmPageManagementConfigBiz {
   @Override
   public List<CrmPageManagementConfigDTO> getPageDetailByPageEnum(Integer crmPageManagementConfigEnum, Integer crmCountryTypeEnum) {
      if (crmPageManagementConfigEnum.equals(CrmPageManagementConfigEnum.ENTERPRISE_RECORD_PAGE_MANAGEMENT.getType())
         || crmPageManagementConfigEnum.equals(CrmPageManagementConfigEnum.PROJECT_INFORMATION_REGISTRATION_PAGE_MANAGEMENT.getType())) {
         Preconditions.checkArgument(crmCountryTypeEnum != null, "请先选择国家类型");
      }

      List<CrmPageManagementConfig> crmPageManagementConfigs = this.baseService
         .list(
            Wrappers.lambdaQuery(CrmPageManagementConfig.class)
               .eq(crmCountryTypeEnum != null, CrmPageManagementConfig::getCrmCountryTypeEnum, crmCountryTypeEnum)
               .eq(CrmPageManagementConfig::getCrmPageManagementConfigEnum, crmPageManagementConfigEnum)
         );
      List<CrmPageManagementConfigDTO> crmPageManagementConfigDTOS = crmPageManagementConfigs.stream()
         .map(item -> BeanUtil.copy(item, CrmPageManagementConfigDTO.class))
         .collect(Collectors.toList());
      crmPageManagementConfigDTOS.forEach(item -> {
         item.setCrmFieldParentTypeEnumName(CrmFieldParentTypeEnum.getNameByType(item.getCrmFieldParentTypeEnum()));
         item.setCrmFieldParentTypeEnumSort(CrmFieldParentTypeEnum.getSortByType(item.getCrmFieldParentTypeEnum()));
      });
      return crmPageManagementConfigDTOS.stream()
         .sorted(Comparator.comparing(CrmPageManagementConfigDTO::getCrmFieldParentTypeEnumSort).thenComparing(CrmPageManagementConfigDTO::getSort))
         .collect(Collectors.toList());
   }

   @Override
   public List<CrmStyleLayoutDTO> getStyleLayoutList() {
      List<CrmStyleLayoutDTO> styleLayoutDTOS = new ArrayList<>();
      Map<Integer, List<CrmPageManagementConfig>> map = this.baseService
         .list()
         .stream()
         .collect(Collectors.groupingBy(CrmPageManagementConfig::getCrmPageManagementConfigEnum));
      CrmPageManagementConfigEnum[] enums = CrmPageManagementConfigEnum.values();

      for (CrmPageManagementConfigEnum crmPageManagementConfigEnum : enums) {
         CrmStyleLayoutDTO crmStyleLayoutDTO = CrmStyleLayoutDTO.builder()
            .crmPageManagementConfigEnum(crmPageManagementConfigEnum.getType())
            .crmPageManagementConfigEnumName(crmPageManagementConfigEnum.getName())
            .build();
         List<CrmPageManagementConfig> crmPageManagementConfigs = map.get(crmPageManagementConfigEnum.getType());
         if (CollectionUtils.isNotEmpty(crmPageManagementConfigs)) {
            List<CrmPageManagementConfig> pageManagementConfigs = crmPageManagementConfigs.stream()
               .filter(item -> item.getUpdateTime() != null)
               .sorted(Comparator.<CrmPageManagementConfig, java.time.LocalDateTime>comparing(BaseEntity::getUpdateTime).reversed())
               .collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(pageManagementConfigs)) {
               crmStyleLayoutDTO.setFinallyUpdateTime(pageManagementConfigs.get(0).getUpdateTime());
            }
         }

         styleLayoutDTOS.add(crmStyleLayoutDTO);
      }

      return styleLayoutDTOS;
   }

   @Transactional
   @Override
   public Boolean updateByList(List<CrmPageManagementConfigUpdateParam> crmPageManagementConfigUpdateParams) {
      List<CrmPageManagementConfig> crmPageManagementConfigs = crmPageManagementConfigUpdateParams.stream()
         .map(item -> BeanUtil.copy(item, CrmPageManagementConfig.class))
         .collect(Collectors.toList());
      return this.baseService.updateBatchById(crmPageManagementConfigs);
   }
}
