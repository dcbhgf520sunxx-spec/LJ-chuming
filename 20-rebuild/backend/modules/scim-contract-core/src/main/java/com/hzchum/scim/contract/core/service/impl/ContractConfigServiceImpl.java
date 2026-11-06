package com.hzchum.scim.contract.core.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.google.common.base.Preconditions;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.contract.core.api.enums.ContractFieldEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractCatalogue;
import com.hzchum.scim.contract.core.api.pojo._do.ContractFieldConfig;
import com.hzchum.scim.contract.core.api.pojo._do.ContractPreRegistration;
import com.hzchum.scim.contract.core.api.pojo._do.ContractRegistration;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractFieldConfigDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractFieldConfigDTOParam;
import com.hzchum.scim.contract.core.api.service.ContractCatalogueService;
import com.hzchum.scim.contract.core.api.service.ContractConfigService;
import com.hzchum.scim.contract.core.api.service.ContractFieldConfigService;
import com.hzchum.scim.contract.core.api.service.ContractPreRegistrationService;
import com.hzchum.scim.contract.core.api.service.ContractRegistrationService;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContractConfigServiceImpl implements ContractConfigService {
   @Resource
   private ContractFieldConfigService contractFieldConfigService;
   @Resource
   private ContractPreRegistrationService contractPrefRegistrationService;
   @Resource
   private ContractRegistrationService contractRegistrationService;
   @Resource
   private ContractCatalogueService contractCatalogService;

   @Override
   public List<ContractFieldConfigDTO> getContractFiledConfig() {
      List<ContractFieldConfig> list = this.contractFieldConfigService.list();
      List<ContractFieldConfigDTO> contractFieldConfigDTOS = new ArrayList<>();

      for (ContractFieldEnum value : ContractFieldEnum.values()) {
         ContractFieldConfigDTO build = ContractFieldConfigDTO.builder()
            .id(null)
            .fieldEnumType(value.getType())
            .fieldEnumName(value.getName())
            .fieldValue(null)
            .build();
         List<ContractFieldConfig> collect = list.stream().filter(s -> s.getFieldEnumType().equals(value.getType())).collect(Collectors.toList());
         new ArrayList();
         List<ContractFieldConfigDTO> fieldConfigDTOS;
         if (value.getType().equals(ContractFieldEnum.SECOND_LEVEL_DEPT.getType())) {
            Map<Long, String> map = this.contractFieldConfigService
               .list(
                  (Wrapper<ContractFieldConfig>)new LambdaQueryWrapper<ContractFieldConfig>()
                     .eq(ContractFieldConfig::getFieldEnumType, ContractFieldEnum.FIRST_LEVEL_DEPT.getType())
               )
               .stream()
               .collect(Collectors.toMap(ContractFieldConfig::getId, ContractFieldConfig::getFieldValue));
            fieldConfigDTOS = collect.stream()
               .map(
                  c -> {
                     ContractFieldConfigDTO fieldConfigDTO = ContractFieldConfigDTO.builder()
                        .id(c.getId())
                        .fieldEnumType(value.getType())
                        .fieldEnumName(value.getName())
                        .fieldValue(c.getFieldValue())
                        .fieldSort(c.getFieldSort())
                        .deptJson(ObjectUtil.isNotEmpty(c.getFieldJson()) ? JSON.parseObject(c.getFieldJson(), Map.class) : null)
                        .build();
                     fieldConfigDTO.setParentId(c.getParentId());
                     fieldConfigDTO.setFirstLevelDeptName(map.get(c.getParentId()));
                     return fieldConfigDTO;
                  }
               )
               .collect(Collectors.toList());
         } else {
            fieldConfigDTOS = collect.stream()
               .map(
                  c -> ContractFieldConfigDTO.builder()
                     .id(c.getId())
                     .fieldEnumType(value.getType())
                     .fieldEnumName(value.getName())
                     .fieldValue(c.getFieldValue())
                     .fieldSort(c.getFieldSort())
                     .deptJson(
                        value.getType().equals(ContractFieldEnum.FIRST_LEVEL_DEPT.getType()) && ObjectUtil.isNotEmpty(c.getFieldJson())
                           ? JSON.parseObject(c.getFieldJson(), Map.class)
                           : null
                     )
                     .build()
               )
               .collect(Collectors.toList());
         }

         List<ContractFieldConfigDTO> collect1 = fieldConfigDTOS.stream()
            .sorted(Comparator.comparing(ContractFieldConfigDTO::getFieldSort))
            .collect(Collectors.toList());
         build.setList(collect1);
         contractFieldConfigDTOS.add(build);
      }

      return contractFieldConfigDTOS;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveContractFiledConfig(ContractFieldConfigDTOParam dtoParam) {
      Preconditions.checkArgument(dtoParam.getFieldEnumType() != null, "合同目录枚举不能为空");
      List<ContractFieldConfigDTOParam> list = dtoParam.getList();
      if (dtoParam.getFieldEnumType().equals(ContractFieldEnum.SECOND_LEVEL_DEPT.getType())) {
         Map<Long, List<ContractFieldConfigDTOParam>> map = list.stream().collect(Collectors.groupingBy(ContractFieldConfigDTOParam::getParentId));

         for (Long l : map.keySet()) {
            List<ContractFieldConfigDTOParam> collect = map.get(l);
            List<String> collect1 = collect.stream().map(ContractFieldConfigDTOParam::getFieldValue).distinct().collect(Collectors.toList());
            Preconditions.checkArgument(collect1.size() == collect.size(), "同一所属一级部门下存在名称相同的所属二级部门");
            List<Long> parentIds = collect.stream().map(ContractFieldConfigDTOParam::getParentId).filter(Objects::nonNull).collect(Collectors.toList());
            List<ContractFieldConfig> contractFieldConfigs1 = this.contractFieldConfigService.listByIds(parentIds);
            Preconditions.checkArgument(CollectionUtils.isNotEmpty(contractFieldConfigs1), "所属一级部门不存在");
            List<ContractFieldConfig> collect2 = contractFieldConfigs1.stream()
               .filter(c -> !c.getFieldEnumType().equals(ContractFieldEnum.FIRST_LEVEL_DEPT.getType()))
               .collect(Collectors.toList());
            Preconditions.checkArgument(
               CollectionUtils.isEmpty(collect2), collect2.stream().map(ContractFieldConfig::getFieldValue).collect(Collectors.joining(",")) + "不为所属一级部门"
            );

            for (ContractFieldConfigDTOParam dtoParam1 : collect) {
               List<ContractFieldConfig> contractFieldConfigs = this.contractFieldConfigService
                  .list(
                     (Wrapper<ContractFieldConfig>)(new LambdaQueryWrapper<ContractFieldConfig>().eq(ContractFieldConfig::getParentId, dtoParam1.getParentId()))
                        .eq(ContractFieldConfig::getFieldValue, dtoParam1.getFieldValue())
                  );
               Preconditions.checkArgument(contractFieldConfigs.isEmpty(), dtoParam1.getFieldValue() + "已存在");
            }
         }
      } else {
         List<String> collect1 = list.stream().map(ContractFieldConfigDTOParam::getFieldValue).distinct().collect(Collectors.toList());
         Preconditions.checkArgument(collect1.size() == list.size(), "存在相同名称");

         for (ContractFieldConfigDTOParam fieldConfigDTOParam : list) {
            List<ContractFieldConfig> contractFieldConfigs = this.contractFieldConfigService
               .list(
                  (Wrapper<ContractFieldConfig>)(new LambdaQueryWrapper<ContractFieldConfig>()
                        .eq(ContractFieldConfig::getFieldEnumType, dtoParam.getFieldEnumType()))
                     .eq(ContractFieldConfig::getFieldValue, fieldConfigDTOParam.getFieldValue())
               );
            Preconditions.checkArgument(contractFieldConfigs.isEmpty(), fieldConfigDTOParam.getFieldValue() + "已存在");
         }
      }

      for (ContractFieldConfigDTOParam fieldConfigDTOParam : list) {
         ContractFieldConfig build = ContractFieldConfig.builder()
            .fieldEnumType(dtoParam.getFieldEnumType())
            .fieldValue(fieldConfigDTOParam.getFieldValue())
            .fieldSort(fieldConfigDTOParam.getFieldSort())
            .parentId(dtoParam.getFieldEnumType().equals(ContractFieldEnum.SECOND_LEVEL_DEPT.getType()) ? fieldConfigDTOParam.getParentId() : null)
            .fieldJson(
               !dtoParam.getFieldEnumType().equals(ContractFieldEnum.SECOND_LEVEL_DEPT.getType())
                     && !dtoParam.getFieldEnumType().equals(ContractFieldEnum.FIRST_LEVEL_DEPT.getType())
                  ? null
                  : JSON.toJSONString(fieldConfigDTOParam.getDeptJson())
            )
            .build();
         this.contractFieldConfigService.save(build);
      }

      return true;
   }

   @Override
   public Boolean updateContractFiledConfig(ContractFieldConfigDTOParam dtoParam) {
      ContractFieldConfig byId = this.contractFieldConfigService.getById(dtoParam.getId());
      Preconditions.checkArgument(byId != null, "合同目录字段配置不存在");
      if (byId.getFieldEnumType().equals(ContractFieldEnum.SECOND_LEVEL_DEPT.getType())) {
         ContractFieldConfig parentConfig = this.contractFieldConfigService.getById(dtoParam.getParentId());
         Preconditions.checkArgument(parentConfig != null, "所属一级部门不存在");
         List<ContractFieldConfig> contractFieldConfigs = this.contractFieldConfigService
            .list(
               (Wrapper<ContractFieldConfig>)((new LambdaQueryWrapper<ContractFieldConfig>()
                        .eq(ContractFieldConfig::getParentId, dtoParam.getParentId()))
                     .eq(ContractFieldConfig::getFieldValue, dtoParam.getFieldValue()))
                  .ne(ContractFieldConfig::getId, dtoParam.getId())
            );
         Preconditions.checkArgument(contractFieldConfigs.isEmpty(), "所属二级部门已存在该名称");
         ContractFieldConfig contractFieldConfig = this.contractFieldConfigService.getById(dtoParam.getParentId());
         Preconditions.checkArgument(ObjectUtil.isNotEmpty(contractFieldConfig), "所属一级部门不存在");
         Preconditions.checkArgument(
            contractFieldConfig.getFieldEnumType().equals(ContractFieldEnum.FIRST_LEVEL_DEPT.getType()), contractFieldConfig.getFieldValue() + "不为所属一级部门"
         );
      } else {
         List<ContractFieldConfig> contractFieldConfigs = this.contractFieldConfigService
            .list(
               (Wrapper<ContractFieldConfig>)(new LambdaQueryWrapper<ContractFieldConfig>().eq(ContractFieldConfig::getFieldValue, dtoParam.getFieldValue()))
                  .ne(ContractFieldConfig::getId, dtoParam.getId())
            );
         Preconditions.checkArgument(contractFieldConfigs.isEmpty(), dtoParam.getFieldValue() + "已存在");
      }

      ContractFieldConfig build = ContractFieldConfig.builder()
         .id(dtoParam.getId())
         .fieldEnumType(byId.getFieldEnumType())
         .fieldValue(dtoParam.getFieldValue())
         .fieldSort(dtoParam.getFieldSort())
         .parentId(byId.getFieldEnumType().equals(ContractFieldEnum.SECOND_LEVEL_DEPT.getType()) ? dtoParam.getParentId() : null)
         .fieldJson(
            !byId.getFieldEnumType().equals(ContractFieldEnum.SECOND_LEVEL_DEPT.getType())
                  && !byId.getFieldEnumType().equals(ContractFieldEnum.FIRST_LEVEL_DEPT.getType())
               ? null
               : JSON.toJSONString(dtoParam.getDeptJson())
         )
         .build();
      return this.contractFieldConfigService.updateById(build);
   }

   @Override
   public Boolean deleteContractFiledConfig(List<Long> ids) {
      if (ids.isEmpty()) {
         return true;
      }

      for (Long id : ids) {
         ContractFieldConfig byId = this.contractFieldConfigService.getById(id);
         if (byId.getFieldEnumType().equals(ContractFieldEnum.STRUCTURE_TYPE.getType())) {
            List<ContractPreRegistration> contractPreRegistrations = this.contractPrefRegistrationService
               .list(
                  (Wrapper<ContractPreRegistration>)(new LambdaQueryWrapper<ContractPreRegistration>().eq(ContractPreRegistration::getStructureType, id))
                     .and(
                        c -> {
                           LambdaQueryWrapper var10000 = ((c.eq(
                                    ContractPreRegistration::getReviewStatus, ReviewStatusEnum.REVIEWED.getType()
                                 ))
                                 .or())
                              .eq(ContractPreRegistration::getReviewStatus, ReviewStatusEnum.AUDITING.getType());
                        }
                     )
               );
            if (CollectionUtil.isNotEmpty(contractPreRegistrations)) {
               Preconditions.checkArgument(false, byId.getFieldValue() + "已被合同预登记绑定");
            }

            List<ContractRegistration> contractRegistrations = this.contractRegistrationService
               .list(
                  (Wrapper<ContractRegistration>)(new LambdaQueryWrapper<ContractRegistration>().eq(ContractRegistration::getStructureType, id))
                     .and(
                        c -> {
                           LambdaQueryWrapper var10000 = ((c.eq(
                                    ContractRegistration::getReviewStatus, ReviewStatusEnum.REVIEWED.getType()
                                 ))
                                 .or())
                              .eq(ContractRegistration::getReviewStatus, ReviewStatusEnum.AUDITING.getType());
                        }
                     )
               );
            if (CollectionUtil.isNotEmpty(contractRegistrations)) {
               Preconditions.checkArgument(
                  false, byId.getFieldValue() + "已被合同" + (contractRegistrations.get(0).getRegistrationType().equals(1) ? "评审" : "直接") + "绑定"
               );
            }

            List<ContractCatalogue> contractCatalogues = this.contractCatalogService
               .list((Wrapper<ContractCatalogue>)new LambdaQueryWrapper<ContractCatalogue>().eq(ContractCatalogue::getStructureType, id));
            if (CollectionUtil.isNotEmpty(contractCatalogues)) {
               Preconditions.checkArgument(false, byId.getFieldValue() + "已被合同目录绑定");
            }
         } else if (byId.getFieldEnumType().equals(ContractFieldEnum.CONTRACTUAL_NATURE.getType())) {
            List<ContractPreRegistration> contractPreRegistrations = this.contractPrefRegistrationService
               .list(
                  (Wrapper<ContractPreRegistration>)(new LambdaQueryWrapper<ContractPreRegistration>().eq(ContractPreRegistration::getContractualNature, id))
                     .and(
                        c -> {
                           LambdaQueryWrapper var10000 = ((c.eq(
                                    ContractPreRegistration::getReviewStatus, ReviewStatusEnum.REVIEWED.getType()
                                 ))
                                 .or())
                              .eq(ContractPreRegistration::getReviewStatus, ReviewStatusEnum.AUDITING.getType());
                        }
                     )
               );
            if (CollectionUtil.isNotEmpty(contractPreRegistrations)) {
               Preconditions.checkArgument(false, byId.getFieldValue() + "已被合同预登记绑定");
            }

            List<ContractRegistration> contractRegistrations = this.contractRegistrationService
               .list(
                  (Wrapper<ContractRegistration>)(new LambdaQueryWrapper<ContractRegistration>().eq(ContractRegistration::getContractualNature, id))
                     .and(
                        c -> {
                           LambdaQueryWrapper var10000 = ((c.eq(
                                    ContractRegistration::getReviewStatus, ReviewStatusEnum.REVIEWED.getType()
                                 ))
                                 .or())
                              .eq(ContractRegistration::getReviewStatus, ReviewStatusEnum.AUDITING.getType());
                        }
                     )
               );
            if (CollectionUtil.isNotEmpty(contractRegistrations)) {
               Preconditions.checkArgument(
                  false, byId.getFieldValue() + "已被合同" + (contractRegistrations.get(0).getRegistrationType().equals(1) ? "评审" : "直接") + "绑定"
               );
            }

            List<ContractCatalogue> contractCatalogues = this.contractCatalogService
               .list((Wrapper<ContractCatalogue>)new LambdaQueryWrapper<ContractCatalogue>().eq(ContractCatalogue::getContractualNature, id));
            if (CollectionUtil.isNotEmpty(contractCatalogues)) {
               Preconditions.checkArgument(false, byId.getFieldValue() + "已被合同目录绑定");
            }
         } else if (byId.getFieldEnumType().equals(ContractFieldEnum.BIDDING_METHOD.getType())) {
            List<ContractRegistration> contractRegistrations = this.contractRegistrationService
               .list(
                  (Wrapper<ContractRegistration>)(new LambdaQueryWrapper<ContractRegistration>().eq(ContractRegistration::getBiddingMethod, id))
                     .and(
                        c -> {
                           LambdaQueryWrapper var10000 = ((c.eq(
                                    ContractRegistration::getReviewStatus, ReviewStatusEnum.REVIEWED.getType()
                                 ))
                                 .or())
                              .eq(ContractRegistration::getReviewStatus, ReviewStatusEnum.AUDITING.getType());
                        }
                     )
               );
            if (CollectionUtil.isNotEmpty(contractRegistrations)) {
               Preconditions.checkArgument(
                  false, byId.getFieldValue() + "已被合同" + (contractRegistrations.get(0).getRegistrationType().equals(1) ? "评审" : "直接") + "绑定"
               );
            }

            List<ContractCatalogue> contractCatalogues = this.contractCatalogService
               .list((Wrapper<ContractCatalogue>)new LambdaQueryWrapper<ContractCatalogue>().eq(ContractCatalogue::getBiddingMethod, id));
            if (CollectionUtil.isNotEmpty(contractCatalogues)) {
               Preconditions.checkArgument(false, byId.getFieldValue() + "已被合同目录绑定");
            }
         } else if (byId.getFieldEnumType().equals(ContractFieldEnum.PARTY_TYPE.getType())) {
            List<ContractPreRegistration> contractPreRegistrations = this.contractPrefRegistrationService
               .list(
                  (Wrapper<ContractPreRegistration>)(new LambdaQueryWrapper<ContractPreRegistration>().eq(ContractPreRegistration::getPartyType, id))
                     .and(
                        c -> {
                           LambdaQueryWrapper var10000 = ((c.eq(
                                    ContractPreRegistration::getReviewStatus, ReviewStatusEnum.REVIEWED.getType()
                                 ))
                                 .or())
                              .eq(ContractPreRegistration::getReviewStatus, ReviewStatusEnum.AUDITING.getType());
                        }
                     )
               );
            if (CollectionUtil.isNotEmpty(contractPreRegistrations)) {
               Preconditions.checkArgument(false, byId.getFieldValue() + "已被合同预登记绑定");
            }

            List<ContractRegistration> contractRegistrations = this.contractRegistrationService
               .list(
                  (Wrapper<ContractRegistration>)(new LambdaQueryWrapper<ContractRegistration>().eq(ContractRegistration::getPartyType, id))
                     .and(
                        c -> {
                           LambdaQueryWrapper var10000 = ((c.eq(
                                    ContractRegistration::getReviewStatus, ReviewStatusEnum.REVIEWED.getType()
                                 ))
                                 .or())
                              .eq(ContractRegistration::getReviewStatus, ReviewStatusEnum.AUDITING.getType());
                        }
                     )
               );
            if (CollectionUtil.isNotEmpty(contractRegistrations)) {
               Preconditions.checkArgument(
                  false, byId.getFieldValue() + "已被合同" + (contractRegistrations.get(0).getRegistrationType().equals(1) ? "评审" : "直接") + "绑定"
               );
            }

            List<ContractCatalogue> contractCatalogues = this.contractCatalogService
               .list((Wrapper<ContractCatalogue>)new LambdaQueryWrapper<ContractCatalogue>().eq(ContractCatalogue::getPartyType, id));
            if (CollectionUtil.isNotEmpty(contractCatalogues)) {
               Preconditions.checkArgument(false, byId.getFieldValue() + "已被合同目录绑定");
            }
         } else if (byId.getFieldEnumType().equals(ContractFieldEnum.CONTRACT_TYPE.getType())) {
            List<ContractRegistration> contractRegistrations = this.contractRegistrationService
               .list(
                  (Wrapper<ContractRegistration>)(new LambdaQueryWrapper<ContractRegistration>().eq(ContractRegistration::getContractType, id))
                     .and(
                        c -> {
                           LambdaQueryWrapper var10000 = ((c.eq(
                                    ContractRegistration::getReviewStatus, ReviewStatusEnum.REVIEWED.getType()
                                 ))
                                 .or())
                              .eq(ContractRegistration::getReviewStatus, ReviewStatusEnum.AUDITING.getType());
                        }
                     )
               );
            if (CollectionUtil.isNotEmpty(contractRegistrations)) {
               Preconditions.checkArgument(
                  false, byId.getFieldValue() + "已被合同" + (contractRegistrations.get(0).getRegistrationType().equals(1) ? "评审" : "直接") + "绑定"
               );
            }

            List<ContractCatalogue> contractCatalogues = this.contractCatalogService
               .list((Wrapper<ContractCatalogue>)new LambdaQueryWrapper<ContractCatalogue>().eq(ContractCatalogue::getContractType, id));
            if (CollectionUtil.isNotEmpty(contractCatalogues)) {
               Preconditions.checkArgument(false, byId.getFieldValue() + "已被合同目录绑定");
            }
         } else if (byId.getFieldEnumType().equals(ContractFieldEnum.FIRST_LEVEL_DEPT.getType())) {
            List<ContractRegistration> contractRegistrations = this.contractRegistrationService
               .list(
                  (Wrapper<ContractRegistration>)(new LambdaQueryWrapper<ContractRegistration>().eq(ContractRegistration::getFirstLevelDept, id))
                     .and(
                        c -> {
                           LambdaQueryWrapper var10000 = ((c.eq(
                                    ContractRegistration::getReviewStatus, ReviewStatusEnum.REVIEWED.getType()
                                 ))
                                 .or())
                              .eq(ContractRegistration::getReviewStatus, ReviewStatusEnum.AUDITING.getType());
                        }
                     )
               );
            if (CollectionUtil.isNotEmpty(contractRegistrations)) {
               Preconditions.checkArgument(
                  false, byId.getFieldValue() + "已被合同" + (contractRegistrations.get(0).getRegistrationType().equals(1) ? "评审" : "直接") + "绑定"
               );
            }

            List<ContractCatalogue> contractCatalogues = this.contractCatalogService
               .list((Wrapper<ContractCatalogue>)new LambdaQueryWrapper<ContractCatalogue>().eq(ContractCatalogue::getFirstLevelDept, id));
            if (CollectionUtil.isNotEmpty(contractCatalogues)) {
               Preconditions.checkArgument(false, byId.getFieldValue() + "已被合同目录绑定");
            }
         } else if (byId.getFieldEnumType().equals(ContractFieldEnum.SECOND_LEVEL_DEPT.getType())) {
            List<ContractRegistration> contractRegistrations = this.contractRegistrationService
               .list(
                  (Wrapper<ContractRegistration>)(new LambdaQueryWrapper<ContractRegistration>().eq(ContractRegistration::getSecondLevelDept, id))
                     .and(
                        c -> {
                           LambdaQueryWrapper var10000 = ((c.eq(
                                    ContractRegistration::getReviewStatus, ReviewStatusEnum.REVIEWED.getType()
                                 ))
                                 .or())
                              .eq(ContractRegistration::getReviewStatus, ReviewStatusEnum.AUDITING.getType());
                        }
                     )
               );
            if (CollectionUtil.isNotEmpty(contractRegistrations)) {
               Preconditions.checkArgument(
                  false, byId.getFieldValue() + "已被合同" + (contractRegistrations.get(0).getRegistrationType().equals(1) ? "评审" : "直接") + "绑定"
               );
            }

            List<ContractCatalogue> contractCatalogues = this.contractCatalogService
               .list((Wrapper<ContractCatalogue>)new LambdaQueryWrapper<ContractCatalogue>().eq(ContractCatalogue::getSecondLevelDept, id));
            if (CollectionUtil.isNotEmpty(contractCatalogues)) {
               Preconditions.checkArgument(false, byId.getFieldValue() + "已被合同目录绑定");
            }
         }
      }

      return this.contractFieldConfigService.removeByIds(ids);
   }
}
