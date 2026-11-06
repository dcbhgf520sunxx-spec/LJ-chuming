package com.hzchum.scim.crm.core.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.crm.core.api.biz.CrmApplyForBidRecordBiz;
import com.hzchum.scim.crm.core.api.biz.CrmBasicsConfigBiz;
import com.hzchum.scim.crm.core.api.biz.CrmBiddingPlatformWarehousingBiz;
import com.hzchum.scim.crm.core.api.biz.CrmEnterpriseWarehousingBiz;
import com.hzchum.scim.crm.core.api.biz.CrmGovernmentWarehousingBiz;
import com.hzchum.scim.crm.core.api.biz.CrmPrequalificationRecordBiz;
import com.hzchum.scim.crm.core.api.biz.CrmProjectAbandonRecordBiz;
import com.hzchum.scim.crm.core.api.biz.CrmProjectFollowUpRecordBiz;
import com.hzchum.scim.crm.core.api.biz.CrmProjectInformationWarehousingBiz;
import com.hzchum.scim.crm.core.api.biz.CrmProjectTrackerWireBiz;
import com.hzchum.scim.crm.core.api.biz.CrmSupplierWarehousingBiz;
import com.hzchum.scim.crm.core.api.enums.CrmBasicsConfigEnum;
import com.hzchum.scim.crm.core.api.pojo._do.CrmBasicsConfig;
import com.hzchum.scim.crm.core.api.pojo._do.CrmEnterpriseWarehousing;
import com.hzchum.scim.crm.core.api.pojo._do.CrmProjectInformationWarehousing;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmBasicsConfigDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmBasicsConfigEnumListDTO;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmBasicsConfigUpdateParam;
import com.hzchum.scim.crm.core.api.service.CrmBasicsConfigService;
import com.hzchum.scim.crm.core.mapper.CrmBasicsConfigMapper;
import com.hzchum.scim.system.core.api.pojo._do.SysDictionary;
import com.hzchum.scim.system.core.api.service.SysDictionaryService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CrmBasicsConfigBizImpl extends IBizImpl<CrmBasicsConfigService, CrmBasicsConfigMapper, CrmBasicsConfig> implements CrmBasicsConfigBiz {
   @Resource
   private CrmEnterpriseWarehousingBiz crmEnterpriseWarehousingBiz;
   @Resource
   private CrmSupplierWarehousingBiz crmSupplierWarehousingBiz;
   @Resource
   private CrmProjectInformationWarehousingBiz crmProjectInformationWarehousingBiz;
   @Resource
   private CrmProjectTrackerWireBiz crmProjectTrackerWireBiz;
   @Resource
   private CrmGovernmentWarehousingBiz crmGovernmentWarehousingBiz;
   @Resource
   private CrmApplyForBidRecordBiz crmApplyForBidRecordBiz;
   @Resource
   private CrmBiddingPlatformWarehousingBiz crmBiddingPlatformWarehousingBiz;
   @Resource
   private CrmProjectFollowUpRecordBiz crmProjectFollowUpRecordBiz;
   @Resource
   private CrmPrequalificationRecordBiz crmPrequalificationRecordBiz;
   @Resource
   private CrmProjectAbandonRecordBiz crmProjectAbandonRecordBiz;
   @Resource
   private SysDictionaryService sysDictionaryService;

   @Override
   public List<CrmBasicsConfigEnumListDTO> getList(Integer crmBasicsConfigEnum) {
      List<CrmBasicsConfigEnumListDTO> crmBasicsConfigEnumListDTOS = new ArrayList<>();
      CrmBasicsConfigEnumListDTO crmBasicsConfigEnumListDTO = CrmBasicsConfigEnumListDTO.builder()
         .crmBasicsConfigEnum(crmBasicsConfigEnum)
         .crmBasicsConfigEnumName(CrmBasicsConfigEnum.getNameByType(crmBasicsConfigEnum))
         .build();
      List<CrmBasicsConfig> crmBasicsConfigs = this.baseService
         .list(
            Wrappers.lambdaQuery(CrmBasicsConfig.class).eq(CrmBasicsConfig::getCrmBasicsConfigEnum, crmBasicsConfigEnum).orderByAsc(CrmBasicsConfig::getSort)
         );
      if (CollectionUtils.isNotEmpty(crmBasicsConfigs)) {
         crmBasicsConfigEnumListDTO.setCrmBasicsConfigDTOS(
            crmBasicsConfigs.stream().map(item -> BeanUtil.copy(item, CrmBasicsConfigDTO.class)).collect(Collectors.toList())
         );
      } else {
         crmBasicsConfigEnumListDTO.setCrmBasicsConfigDTOS(new ArrayList<>());
      }

      crmBasicsConfigEnumListDTOS.add(crmBasicsConfigEnumListDTO);
      return crmBasicsConfigEnumListDTOS;
   }

   @Transactional
   @Override
   public Boolean updateByList(List<CrmBasicsConfigUpdateParam> crmBasicsConfigUpdateParams, Integer crmBasicsConfigEnum) {
      Map<String, List<CrmBasicsConfigUpdateParam>> map = crmBasicsConfigUpdateParams.stream().collect(Collectors.groupingBy(item -> item.getName()));
      map.forEach((k, v) -> Preconditions.checkArgument(v.size() == 1, k + "配置重复,请剔除!!!"));
      new ArrayList();
      List<CrmBasicsConfig> updateList = new ArrayList<>();
      List<CrmBasicsConfig> deleteList = new ArrayList<>();
      Map<Long, CrmBasicsConfig> crmBasicsConfigMap = this.baseService
         .list(Wrappers.lambdaQuery(CrmBasicsConfig.class).eq(CrmBasicsConfig::getCrmBasicsConfigEnum, crmBasicsConfigEnum))
         .stream()
         .collect(Collectors.toMap(CrmBasicsConfig::getId, Function.identity()));
      List<CrmBasicsConfigUpdateParam> configSaveParams = crmBasicsConfigUpdateParams.stream()
         .filter(item -> item.getId() == null)
         .collect(Collectors.toList());
      List<CrmBasicsConfig> saveList = configSaveParams.stream()
         .map(item -> BeanUtil.copy(item, CrmBasicsConfig.class).setCrmBasicsConfigEnum(crmBasicsConfigEnum))
         .collect(Collectors.toList());
      crmBasicsConfigUpdateParams.forEach(item -> {
         if (item.getId() != null) {
            CrmBasicsConfig crmBasicsConfig = crmBasicsConfigMap.get(item.getId());
            if (!item.getName().equals(crmBasicsConfig.getName()) || !item.getSort().equals(crmBasicsConfig.getSort())) {
               updateList.add(BeanUtil.copy(item, CrmBasicsConfig.class).setCrmBasicsConfigEnum(crmBasicsConfigEnum));
            }
         }
      });
      List<Long> newIds = crmBasicsConfigUpdateParams.stream()
         .filter(item -> item.getId() != null)
         .map(CrmBasicsConfigUpdateParam::getId)
         .collect(Collectors.toList());
      crmBasicsConfigMap.forEach((k, v) -> {
         if (!newIds.contains(k)) {
            deleteList.add(v);
         }
      });
      List<String> notModifiableAndDeleteList = new ArrayList<>();
      List<Long> updateIds = updateList.stream().map(CrmBasicsConfig::getId).collect(Collectors.toList());
      List<Long> deleteIds = deleteList.stream().map(CrmBasicsConfig::getId).collect(Collectors.toList());
      List<CrmEnterpriseWarehousing> crmEnterpriseWarehousings = this.crmEnterpriseWarehousingBiz.list();
      if (CollectionUtils.isNotEmpty(crmEnterpriseWarehousings)) {
         crmEnterpriseWarehousings.forEach(item -> {
            if (item.getUnitPropertyAllocationConfigId() != null && deleteIds.contains(item.getUnitPropertyAllocationConfigId())) {
               notModifiableAndDeleteList.add(crmBasicsConfigMap.get(item.getUnitPropertyAllocationConfigId()).getName());
            }

            if (item.getUnitClassConfigurationId() != null && deleteIds.contains(item.getUnitClassConfigurationId())) {
               notModifiableAndDeleteList.add(crmBasicsConfigMap.get(item.getUnitClassConfigurationId()).getName());
            }

            if (item.getIndustryConfigurationId() != null && deleteIds.contains(item.getIndustryConfigurationId())) {
               notModifiableAndDeleteList.add(crmBasicsConfigMap.get(item.getIndustryConfigurationId()).getName());
            }

            if (item.getUnitReputationAllocationConfigId() != null && deleteIds.contains(item.getUnitReputationAllocationConfigId())) {
               notModifiableAndDeleteList.add(crmBasicsConfigMap.get(item.getUnitReputationAllocationConfigId()).getName());
            }
         });
      }

      Preconditions.checkArgument(CollectionUtils.isEmpty(notModifiableAndDeleteList), notModifiableAndDeleteList.toString() + "已被引用不可删除");
      List<CrmProjectInformationWarehousing> crmProjectInformationWarehousings = this.crmProjectInformationWarehousingBiz.list();
      if (CollectionUtils.isNotEmpty(crmProjectInformationWarehousings)) {
         crmProjectInformationWarehousings.forEach(item -> {
            if (item.getIndustryConfigurationId() != null && deleteIds.contains(item.getIndustryConfigurationId())) {
               notModifiableAndDeleteList.add(crmBasicsConfigMap.get(item.getIndustryConfigurationId()).getName());
            }
         });
      }

      Preconditions.checkArgument(CollectionUtils.isEmpty(notModifiableAndDeleteList), notModifiableAndDeleteList.toString() + "已被引用不可删除");
      this.baseService.updateBatchById(updateList);
      this.baseService.removeByIds(deleteList.stream().map(CrmBasicsConfig::getId).collect(Collectors.toList()));
      this.baseService.saveBatch(saveList);
      return Boolean.TRUE;
   }

   @Override
   public List<CrmBasicsConfigEnumListDTO> getListSkipPermissions(Integer crmBasicsConfigEnum) {
      List<CrmBasicsConfigEnumListDTO> crmBasicsConfigEnumListDTOS = new ArrayList<>();
      if (crmBasicsConfigEnum != null) {
         CrmBasicsConfigEnumListDTO crmBasicsConfigEnumListDTO = CrmBasicsConfigEnumListDTO.builder()
            .crmBasicsConfigEnum(crmBasicsConfigEnum)
            .crmBasicsConfigEnumName(CrmBasicsConfigEnum.getNameByType(crmBasicsConfigEnum))
            .build();
         List<CrmBasicsConfig> crmBasicsConfigs = this.baseService
            .list(
               Wrappers.lambdaQuery(CrmBasicsConfig.class)
                  .eq(CrmBasicsConfig::getCrmBasicsConfigEnum, crmBasicsConfigEnum)
                  .orderByAsc(CrmBasicsConfig::getSort)
            );
         if (CollectionUtils.isNotEmpty(crmBasicsConfigs)) {
            crmBasicsConfigEnumListDTO.setCrmBasicsConfigDTOS(
               crmBasicsConfigs.stream().map(item -> BeanUtil.copy(item, CrmBasicsConfigDTO.class)).collect(Collectors.toList())
            );
         } else {
            crmBasicsConfigEnumListDTO.setCrmBasicsConfigDTOS(new ArrayList<>());
         }

         crmBasicsConfigEnumListDTOS.add(crmBasicsConfigEnumListDTO);
         return crmBasicsConfigEnumListDTOS;
      } else {
         CrmBasicsConfigEnum[] values = CrmBasicsConfigEnum.values();

         for (CrmBasicsConfigEnum value : values) {
            CrmBasicsConfigEnumListDTO crmBasicsConfigEnumListDTO = CrmBasicsConfigEnumListDTO.builder()
               .crmBasicsConfigEnum(value.getType())
               .crmBasicsConfigEnumName(value.getName())
               .build();
            List<CrmBasicsConfig> crmBasicsConfigs = this.baseService
               .list(
                  Wrappers.lambdaQuery(CrmBasicsConfig.class).eq(CrmBasicsConfig::getCrmBasicsConfigEnum, value.getType()).orderByAsc(CrmBasicsConfig::getSort)
               );
            if (CollectionUtils.isNotEmpty(crmBasicsConfigs)) {
               crmBasicsConfigEnumListDTO.setCrmBasicsConfigDTOS(
                  crmBasicsConfigs.stream().map(item -> BeanUtil.copy(item, CrmBasicsConfigDTO.class)).collect(Collectors.toList())
               );
            } else {
               crmBasicsConfigEnumListDTO.setCrmBasicsConfigDTOS(new ArrayList<>());
            }

            crmBasicsConfigEnumListDTOS.add(crmBasicsConfigEnumListDTO);
         }

         return crmBasicsConfigEnumListDTOS;
      }
   }

   @Override
   public Boolean syncBasicsConfigInformation(Integer crmBasicsConfigEnum, String name) {
      List<String> stringList = this.baseService
         .list(Wrappers.lambdaQuery(CrmBasicsConfig.class).eq(CrmBasicsConfig::getCrmBasicsConfigEnum, crmBasicsConfigEnum))
         .stream()
         .map(CrmBasicsConfig::getName)
         .collect(Collectors.toList());
      List<SysDictionary> sysDictionaryList = this.sysDictionaryService.listByName(name);
      sysDictionaryList.forEach(item -> {
         boolean contains = stringList.contains(item.getLabel());
         if (!contains) {
            this.baseService.save(CrmBasicsConfig.builder().sort(1).crmBasicsConfigEnum(crmBasicsConfigEnum).name(item.getLabel()).build());
         }
      });
      return Boolean.TRUE;
   }
}
