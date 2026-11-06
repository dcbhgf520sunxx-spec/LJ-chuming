package com.hzchum.scim.crm.core.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.crm.core.api.biz.CrmProjectFollowUpRecordBiz;
import com.hzchum.scim.crm.core.api.biz.CrmProjectInformationConfigBiz;
import com.hzchum.scim.crm.core.api.biz.CrmProjectInformationWarehousingBiz;
import com.hzchum.scim.crm.core.api.biz.CrmTheNumberOfCustomProjectConfigBiz;
import com.hzchum.scim.crm.core.api.enums.CrmProjectInformationConfigEnum;
import com.hzchum.scim.crm.core.api.pojo._do.CrmProjectFollowUpRecord;
import com.hzchum.scim.crm.core.api.pojo._do.CrmProjectInformationConfig;
import com.hzchum.scim.crm.core.api.pojo._do.CrmProjectInformationWarehousing;
import com.hzchum.scim.crm.core.api.pojo._do.CrmTheNumberOfCustomProjectConfig;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmProjectInformationConfigDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmProjectInformationConfigEnumListDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmTheNumberOfCustomProjectConfigDTO;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmCustomQuantityUpdateParam;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmProjectInformationConfigUpdateParam;
import com.hzchum.scim.crm.core.api.service.CrmProjectInformationConfigService;
import com.hzchum.scim.crm.core.mapper.CrmProjectInformationConfigMapper;
import com.hzchum.scim.system.core.api.pojo._do.SysDictionary;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.SysDictionaryService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CrmProjectInformationConfigBizImpl
   extends IBizImpl<CrmProjectInformationConfigService, CrmProjectInformationConfigMapper, CrmProjectInformationConfig>
   implements CrmProjectInformationConfigBiz {
   @Resource
   private CrmProjectInformationWarehousingBiz crmProjectInformationWarehousingBiz;
   @Resource
   private CrmProjectFollowUpRecordBiz crmProjectFollowUpRecordBiz;
   @Resource
   private CrmTheNumberOfCustomProjectConfigBiz crmTheNumberOfCustomProjectConfigBiz;
   @Resource
   private UserService userService;
   @Resource
   private SysDictionaryService sysDictionaryService;

   @Override
   public List<CrmProjectInformationConfigEnumListDTO> getList(Integer crmProjectInformationConfigEnum) {
      List<CrmProjectInformationConfigEnumListDTO> crmBasicsConfigEnumListDTOS = new ArrayList<>();
      CrmProjectInformationConfigEnumListDTO crmProjectInformationConfigEnumListDTO = CrmProjectInformationConfigEnumListDTO.builder()
         .crmProjectInformationConfigEnum(crmProjectInformationConfigEnum)
         .crmProjectInformationConfigEnumName(CrmProjectInformationConfigEnum.getNameByType(crmProjectInformationConfigEnum))
         .build();
      List<CrmProjectInformationConfig> crmProjectInformationConfigs = this.baseService
         .list(
            Wrappers.lambdaQuery(CrmProjectInformationConfig.class)
               .eq(CrmProjectInformationConfig::getCrmProjectInformationConfigEnum, crmProjectInformationConfigEnum)
               .orderByAsc(CrmProjectInformationConfig::getSort)
         );
      if (CollectionUtils.isNotEmpty(crmProjectInformationConfigs)) {
         crmProjectInformationConfigEnumListDTO.setCrmProjectInformationConfigDTOS(
            crmProjectInformationConfigs.stream().map(item -> BeanUtil.copy(item, CrmProjectInformationConfigDTO.class)).collect(Collectors.toList())
         );
      } else {
         crmProjectInformationConfigEnumListDTO.setCrmProjectInformationConfigDTOS(new ArrayList<>());
      }

      crmBasicsConfigEnumListDTOS.add(crmProjectInformationConfigEnumListDTO);
      return crmBasicsConfigEnumListDTOS;
   }

   @Override
   public Boolean updateByList(List<CrmProjectInformationConfigUpdateParam> crmProjectInformationConfigUpdateParams, Integer crmProjectInformationConfigEnum) {
      Map<String, List<CrmProjectInformationConfigUpdateParam>> map = crmProjectInformationConfigUpdateParams.stream()
         .collect(Collectors.groupingBy(item -> item.getName()));
      map.forEach((k, v) -> Preconditions.checkArgument(v.size() == 1, k + "配置重复,请剔除!!!"));
      new ArrayList();
      List<CrmProjectInformationConfig> updateList = new ArrayList<>();
      List<CrmProjectInformationConfig> deleteList = new ArrayList<>();
      Map<Long, CrmProjectInformationConfig> crmProjectInformationConfigMap = this.baseService
         .list(
            Wrappers.lambdaQuery(CrmProjectInformationConfig.class)
               .eq(CrmProjectInformationConfig::getCrmProjectInformationConfigEnum, crmProjectInformationConfigEnum)
         )
         .stream()
         .collect(Collectors.toMap(CrmProjectInformationConfig::getId, Function.identity()));
      List<CrmProjectInformationConfigUpdateParam> configSaveParams = crmProjectInformationConfigUpdateParams.stream()
         .filter(item -> item.getId() == null)
         .collect(Collectors.toList());
      List<CrmProjectInformationConfig> saveList = configSaveParams.stream()
         .map(item -> BeanUtil.copy(item, CrmProjectInformationConfig.class).setCrmProjectInformationConfigEnum(crmProjectInformationConfigEnum))
         .collect(Collectors.toList());
      crmProjectInformationConfigUpdateParams.forEach(item -> {
         if (item.getId() != null) {
            CrmProjectInformationConfig crmProjectInformationConfig = crmProjectInformationConfigMap.get(item.getId());
            if (!item.getName().equals(crmProjectInformationConfig.getName()) || !item.getSort().equals(crmProjectInformationConfig.getSort())) {
               updateList.add(BeanUtil.copy(item, CrmProjectInformationConfig.class).setCrmProjectInformationConfigEnum(crmProjectInformationConfigEnum));
            }
         }
      });
      List<Long> newIds = crmProjectInformationConfigUpdateParams.stream()
         .filter(item -> item.getId() != null)
         .map(CrmProjectInformationConfigUpdateParam::getId)
         .collect(Collectors.toList());
      crmProjectInformationConfigMap.forEach((k, v) -> {
         if (!newIds.contains(k)) {
            deleteList.add(v);
         }
      });
      Set<String> notModifiableAndDeleteList = new HashSet<>();
      List<Long> deleteIds = deleteList.stream().map(CrmProjectInformationConfig::getId).collect(Collectors.toList());
      List<CrmProjectInformationWarehousing> crmProjectInformationWarehousings = this.crmProjectInformationWarehousingBiz.list();
      if (CollectionUtils.isNotEmpty(crmProjectInformationWarehousings)) {
         crmProjectInformationWarehousings.forEach(item -> {
            if (item.getConfigurationOfArchitecturalFormId() != null && deleteIds.contains(item.getConfigurationOfArchitecturalFormId())) {
               notModifiableAndDeleteList.add(crmProjectInformationConfigMap.get(item.getConfigurationOfArchitecturalFormId()).getName());
            }

            if (item.getStructureTypeConfigurationId() != null && deleteIds.contains(item.getStructureTypeConfigurationId())) {
               notModifiableAndDeleteList.add(crmProjectInformationConfigMap.get(item.getStructureTypeConfigurationId()).getName());
            }

            if (item.getKeyProjectId() != null && deleteIds.contains(item.getKeyProjectId())) {
               notModifiableAndDeleteList.add(crmProjectInformationConfigMap.get(item.getKeyProjectId()).getName());
            }

            if (item.getItemCategoryId() != null && deleteIds.contains(item.getItemCategoryId())) {
               notModifiableAndDeleteList.add(crmProjectInformationConfigMap.get(item.getItemCategoryId()).getName());
            }

            if (item.getTypeOfContractorId() != null && deleteIds.contains(item.getTypeOfContractorId())) {
               notModifiableAndDeleteList.add(crmProjectInformationConfigMap.get(item.getTypeOfContractorId()).getName());
            }

            if (item.getBusinessDifficultyFactorId() != null && deleteIds.contains(item.getBusinessDifficultyFactorId())) {
               notModifiableAndDeleteList.add(crmProjectInformationConfigMap.get(item.getBusinessDifficultyFactorId()).getName());
            }

            if (item.getDeviseDifficultyFactorId() != null && deleteIds.contains(item.getDeviseDifficultyFactorId())) {
               notModifiableAndDeleteList.add(crmProjectInformationConfigMap.get(item.getDeviseDifficultyFactorId()).getName());
            }

            if (item.getTechnologyDifficultyFactorId() != null && deleteIds.contains(item.getTechnologyDifficultyFactorId())) {
               notModifiableAndDeleteList.add(crmProjectInformationConfigMap.get(item.getTechnologyDifficultyFactorId()).getName());
            }

            if (item.getProjectLevelConfigId() != null && deleteIds.contains(item.getProjectLevelConfigId())) {
               notModifiableAndDeleteList.add(crmProjectInformationConfigMap.get(item.getProjectLevelConfigId()).getName());
            }
         });
      }

      Preconditions.checkArgument(CollectionUtils.isEmpty(notModifiableAndDeleteList), notModifiableAndDeleteList.toString() + "已被引用不可删除");
      List<CrmProjectFollowUpRecord> crmProjectFollowUpRecords = this.crmProjectFollowUpRecordBiz.list();
      crmProjectFollowUpRecords.forEach(item -> {
         if (item.getFollowUpMethods() != null && deleteIds.contains(item.getFollowUpMethods())) {
            notModifiableAndDeleteList.add(crmProjectInformationConfigMap.get(item.getFollowUpMethods()).getName());
         }
      });
      this.baseService.updateBatchById(updateList);
      this.baseService.removeByIds(deleteList.stream().map(CrmProjectInformationConfig::getId).collect(Collectors.toList()));
      this.baseService.saveBatch(saveList);
      return Boolean.TRUE;
   }

   @Override
   public List<CrmProjectInformationConfigEnumListDTO> getListSkipPermissionsAPP(Integer crmProjectInformationConfigEnum) {
      List<CrmProjectInformationConfigEnumListDTO> crmBasicsConfigEnumListDTOS = new ArrayList<>();
      if (crmProjectInformationConfigEnum != null) {
         CrmProjectInformationConfigEnumListDTO crmProjectInformationConfigEnumListDTO = CrmProjectInformationConfigEnumListDTO.builder()
            .crmProjectInformationConfigEnum(crmProjectInformationConfigEnum)
            .crmProjectInformationConfigEnumName(CrmProjectInformationConfigEnum.getNameByType(crmProjectInformationConfigEnum))
            .build();
         if (crmProjectInformationConfigEnum.equals(CrmProjectInformationConfigEnum.PROJECT_MANAGER_COOPERATION.getType())) {
            List<SysDictionary> sysDictionaryList = this.sysDictionaryService.listByName("info_source");
            if (CollectionUtils.isNotEmpty(sysDictionaryList)) {
               crmProjectInformationConfigEnumListDTO.setCrmProjectInformationConfigDTOS(sysDictionaryList.stream().map(item -> {
                  CrmProjectInformationConfigDTO crmProjectInformationConfigDTO = new CrmProjectInformationConfigDTO();
                  crmProjectInformationConfigDTO.setId(Long.valueOf(item.getValue()));
                  crmProjectInformationConfigDTO.setCrmProjectInformationConfigEnum(crmProjectInformationConfigEnum);
                  crmProjectInformationConfigDTO.setName(item.getLabel());
                  crmProjectInformationConfigDTO.setSort(item.getSort());
                  return crmProjectInformationConfigDTO;
               }).collect(Collectors.toList()));
            } else {
               crmProjectInformationConfigEnumListDTO.setCrmProjectInformationConfigDTOS(new ArrayList<>());
            }

            crmBasicsConfigEnumListDTOS.add(crmProjectInformationConfigEnumListDTO);
         } else {
            List<CrmProjectInformationConfig> crmProjectInformationConfigs = this.baseService
               .list(
                  Wrappers.lambdaQuery(CrmProjectInformationConfig.class)
                     .eq(CrmProjectInformationConfig::getCrmProjectInformationConfigEnum, crmProjectInformationConfigEnum)
                     .orderByAsc(CrmProjectInformationConfig::getSort)
               );
            if (CollectionUtils.isNotEmpty(crmProjectInformationConfigs)) {
               crmProjectInformationConfigEnumListDTO.setCrmProjectInformationConfigDTOS(
                  crmProjectInformationConfigs.stream().map(item -> BeanUtil.copy(item, CrmProjectInformationConfigDTO.class)).collect(Collectors.toList())
               );
            } else {
               crmProjectInformationConfigEnumListDTO.setCrmProjectInformationConfigDTOS(new ArrayList<>());
            }

            crmBasicsConfigEnumListDTOS.add(crmProjectInformationConfigEnumListDTO);
         }

         return crmBasicsConfigEnumListDTOS;
      } else {
         CrmProjectInformationConfigEnum[] values = CrmProjectInformationConfigEnum.values();

         for (CrmProjectInformationConfigEnum value : values) {
            CrmProjectInformationConfigEnumListDTO crmProjectInformationConfigEnumListDTO = CrmProjectInformationConfigEnumListDTO.builder()
               .crmProjectInformationConfigEnum(value.getType())
               .crmProjectInformationConfigEnumName(value.getName())
               .build();
            if (value.getType().equals(CrmProjectInformationConfigEnum.PROJECT_MANAGER_COOPERATION.getType())) {
               List<SysDictionary> sysDictionaryList = this.sysDictionaryService.listByName("info_source");
               if (CollectionUtils.isNotEmpty(sysDictionaryList)) {
                  crmProjectInformationConfigEnumListDTO.setCrmProjectInformationConfigDTOS(sysDictionaryList.stream().map(item -> {
                     CrmProjectInformationConfigDTO crmProjectInformationConfigDTO = new CrmProjectInformationConfigDTO();
                     crmProjectInformationConfigDTO.setId(Long.valueOf(item.getValue()));
                     crmProjectInformationConfigDTO.setCrmProjectInformationConfigEnum(value.getType());
                     crmProjectInformationConfigDTO.setName(item.getLabel());
                     crmProjectInformationConfigDTO.setSort(item.getSort());
                     return crmProjectInformationConfigDTO;
                  }).collect(Collectors.toList()));
               } else {
                  crmProjectInformationConfigEnumListDTO.setCrmProjectInformationConfigDTOS(new ArrayList<>());
               }

               crmBasicsConfigEnumListDTOS.add(crmProjectInformationConfigEnumListDTO);
            } else {
               List<CrmProjectInformationConfig> crmProjectInformationConfigs = this.baseService
                  .list(
                     Wrappers.lambdaQuery(CrmProjectInformationConfig.class)
                        .eq(CrmProjectInformationConfig::getCrmProjectInformationConfigEnum, value.getType())
                        .orderByAsc(CrmProjectInformationConfig::getSort)
                  );
               if (CollectionUtils.isNotEmpty(crmProjectInformationConfigs)) {
                  crmProjectInformationConfigEnumListDTO.setCrmProjectInformationConfigDTOS(
                     crmProjectInformationConfigs.stream().map(item -> BeanUtil.copy(item, CrmProjectInformationConfigDTO.class)).collect(Collectors.toList())
                  );
               } else {
                  crmProjectInformationConfigEnumListDTO.setCrmProjectInformationConfigDTOS(new ArrayList<>());
               }

               crmBasicsConfigEnumListDTOS.add(crmProjectInformationConfigEnumListDTO);
            }
         }

         return crmBasicsConfigEnumListDTOS;
      }
   }

   @Override
   public List<CrmProjectInformationConfigEnumListDTO> getListSkipPermissions(Integer crmProjectInformationConfigEnum) {
      List<CrmProjectInformationConfigEnumListDTO> crmBasicsConfigEnumListDTOS = new ArrayList<>();
      if (crmProjectInformationConfigEnum != null) {
         CrmProjectInformationConfigEnumListDTO crmProjectInformationConfigEnumListDTO = CrmProjectInformationConfigEnumListDTO.builder()
            .crmProjectInformationConfigEnum(crmProjectInformationConfigEnum)
            .crmProjectInformationConfigEnumName(CrmProjectInformationConfigEnum.getNameByType(crmProjectInformationConfigEnum))
            .build();
         List<CrmProjectInformationConfig> crmProjectInformationConfigs = this.baseService
            .list(
               Wrappers.lambdaQuery(CrmProjectInformationConfig.class)
                  .eq(CrmProjectInformationConfig::getCrmProjectInformationConfigEnum, crmProjectInformationConfigEnum)
                  .orderByAsc(CrmProjectInformationConfig::getSort)
            );
         if (CollectionUtils.isNotEmpty(crmProjectInformationConfigs)) {
            crmProjectInformationConfigEnumListDTO.setCrmProjectInformationConfigDTOS(
               crmProjectInformationConfigs.stream().map(item -> BeanUtil.copy(item, CrmProjectInformationConfigDTO.class)).collect(Collectors.toList())
            );
         } else {
            crmProjectInformationConfigEnumListDTO.setCrmProjectInformationConfigDTOS(new ArrayList<>());
         }

         crmBasicsConfigEnumListDTOS.add(crmProjectInformationConfigEnumListDTO);
         return crmBasicsConfigEnumListDTOS;
      } else {
         CrmProjectInformationConfigEnum[] values = CrmProjectInformationConfigEnum.values();

         for (CrmProjectInformationConfigEnum value : values) {
            CrmProjectInformationConfigEnumListDTO crmProjectInformationConfigEnumListDTO = CrmProjectInformationConfigEnumListDTO.builder()
               .crmProjectInformationConfigEnum(value.getType())
               .crmProjectInformationConfigEnumName(value.getName())
               .build();
            List<CrmProjectInformationConfig> crmProjectInformationConfigs = this.baseService
               .list(
                  Wrappers.lambdaQuery(CrmProjectInformationConfig.class)
                     .eq(CrmProjectInformationConfig::getCrmProjectInformationConfigEnum, value.getType())
                     .orderByAsc(CrmProjectInformationConfig::getSort)
               );
            if (CollectionUtils.isNotEmpty(crmProjectInformationConfigs)) {
               crmProjectInformationConfigEnumListDTO.setCrmProjectInformationConfigDTOS(
                  crmProjectInformationConfigs.stream().map(item -> BeanUtil.copy(item, CrmProjectInformationConfigDTO.class)).collect(Collectors.toList())
               );
            } else {
               crmProjectInformationConfigEnumListDTO.setCrmProjectInformationConfigDTOS(new ArrayList<>());
            }

            crmBasicsConfigEnumListDTOS.add(crmProjectInformationConfigEnumListDTO);
         }

         return crmBasicsConfigEnumListDTOS;
      }
   }

   @Transactional
   @Override
   public Boolean customQuantityUpdate(List<CrmCustomQuantityUpdateParam> crmCustomQuantityUpdateParams) {
      if (CollectionUtils.isEmpty(crmCustomQuantityUpdateParams)) {
         this.crmTheNumberOfCustomProjectConfigBiz.remove(Wrappers.lambdaQuery(CrmTheNumberOfCustomProjectConfig.class));
      } else {
         crmCustomQuantityUpdateParams.forEach(item -> {
            Preconditions.checkArgument(CollectionUtils.isNotEmpty(item.getUserIds()), "请选择人员列表");
            Preconditions.checkArgument(item.getProjectQuota() != null, "请选择项目上限数量");
         });
         this.crmTheNumberOfCustomProjectConfigBiz.remove(Wrappers.lambdaQuery(CrmTheNumberOfCustomProjectConfig.class));
         List<CrmTheNumberOfCustomProjectConfig> crmTheNumberOfCustomProjectConfigs = new ArrayList<>();
         crmCustomQuantityUpdateParams.forEach(
            item -> {
               List<Long> userIds = item.getUserIds();
               userIds.forEach(
                  userId -> crmTheNumberOfCustomProjectConfigs.add(
                     CrmTheNumberOfCustomProjectConfig.builder().userId(userId).projectQuota(item.getProjectQuota()).build()
                  )
               );
            }
         );
         Map<Long, String> userMap = this.userService.list().stream().collect(Collectors.toMap(User::getId, User::getName));
         Map<Long, List<CrmTheNumberOfCustomProjectConfig>> map = crmTheNumberOfCustomProjectConfigs.stream()
            .collect(Collectors.groupingBy(CrmTheNumberOfCustomProjectConfig::getUserId));
         map.forEach((k, v) -> Preconditions.checkArgument(v.size() == 1, userMap.get(k) + "人员配置重复,请剔除!!!"));
         crmTheNumberOfCustomProjectConfigs.forEach(item -> this.crmTheNumberOfCustomProjectConfigBiz.save(item));
      }

      return Boolean.TRUE;
   }

   @Transactional
   @Override
   public Boolean customQuantityClean() {
      return this.crmTheNumberOfCustomProjectConfigBiz.remove(Wrappers.lambdaQuery(CrmTheNumberOfCustomProjectConfig.class));
   }

   @Override
   public List<CrmTheNumberOfCustomProjectConfigDTO> customQuantityList(Long userId) {
      List<CrmTheNumberOfCustomProjectConfig> list = this.crmTheNumberOfCustomProjectConfigBiz
         .list(Wrappers.lambdaQuery(CrmTheNumberOfCustomProjectConfig.class).eq(userId != null, CrmTheNumberOfCustomProjectConfig::getUserId, userId));
      List<CrmTheNumberOfCustomProjectConfigDTO> crmTheNumberOfCustomProjectConfigDTOS = new ArrayList<>();
      if (CollectionUtils.isNotEmpty(list)) {
         Map<Integer, List<CrmTheNumberOfCustomProjectConfig>> collect = list.stream()
            .collect(Collectors.groupingBy(CrmTheNumberOfCustomProjectConfig::getProjectQuota));
         collect.forEach(
            (k, v) -> crmTheNumberOfCustomProjectConfigDTOS.add(
               CrmTheNumberOfCustomProjectConfigDTO.builder()
                  .userIds(v.stream().map(CrmTheNumberOfCustomProjectConfig::getUserId).collect(Collectors.toList()))
                  .projectQuota(k)
                  .build()
            )
         );
      }

      return crmTheNumberOfCustomProjectConfigDTOS;
   }

   @Transactional
   @Override
   public Boolean syncProjectInformation(Integer crmProjectInformationConfigEnum, String name) {
      List<String> stringList = this.baseService
         .list(
            Wrappers.lambdaQuery(CrmProjectInformationConfig.class)
               .eq(CrmProjectInformationConfig::getCrmProjectInformationConfigEnum, crmProjectInformationConfigEnum)
         )
         .stream()
         .map(CrmProjectInformationConfig::getName)
         .collect(Collectors.toList());
      List<SysDictionary> sysDictionaryList = this.sysDictionaryService.listByName(name);
      sysDictionaryList.forEach(
         item -> {
            boolean contains = stringList.contains(item.getLabel());
            if (!contains) {
               this.baseService
                  .save(
                     CrmProjectInformationConfig.builder()
                        .sort(1)
                        .crmProjectInformationConfigEnum(crmProjectInformationConfigEnum)
                        .name(item.getLabel())
                        .build()
                  );
            }
         }
      );
      return Boolean.TRUE;
   }
}
