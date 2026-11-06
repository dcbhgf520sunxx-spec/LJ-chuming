package com.hzchum.scim.system.core.biz.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.enums.CodingTypeEnum;
import com.hzchum.scim.common.core.api.enums.MesProductEnum;
import com.hzchum.scim.common.core.api.enums.ProductClassificationEnum;
import com.hzchum.scim.common.core.api.enums.ProductSectionNameEnum;
import com.hzchum.scim.mes.building.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProductProcess;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessService;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactExt;
import com.hzchum.scim.plan.core.api.service.TechArtifactExtService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.scm.core.api.enums.NoDefinitionArtifactPrefixEnum;
import com.hzchum.scim.system.core.api.biz.SysStructureClassificationBiz;
import com.hzchum.scim.system.core.api.common.enums.ArtifactTypeEnum;
import com.hzchum.scim.system.core.api.common.enums.ProductionLineTypeEnum;
import com.hzchum.scim.system.core.api.common.enums.SmallArtifactClassEnum;
import com.hzchum.scim.system.core.api.pojo._do.MesSectionWarehouseConfigDetail;
import com.hzchum.scim.system.core.api.pojo._do.SysAssembleConfig;
import com.hzchum.scim.system.core.api.pojo._do.SysSteelClassification;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureClassification;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureClassificationChange;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureSerialNumberPrefix;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureSerialNumberPrefixChange;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureSpec;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureSpecChange;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureSpecNumberLink;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo.dto.PartArtAssClassificationDTO;
import com.hzchum.scim.system.core.api.pojo.dto.StructureClassificationBasicDTO;
import com.hzchum.scim.system.core.api.pojo.dto.StructureClassificationDTO;
import com.hzchum.scim.system.core.api.pojo.dto.StructureParentTypeDTO;
import com.hzchum.scim.system.core.api.pojo.dto.StructureSerialNumberPrefixDTO;
import com.hzchum.scim.system.core.api.pojo.dto.StructureSpecDTO;
import com.hzchum.scim.system.core.api.pojo.request.StructureClassificationSaveDTOParam;
import com.hzchum.scim.system.core.api.pojo.request.StructureClassificationUpdateTOParam;
import com.hzchum.scim.system.core.api.pojo.request.StructureSerialNumberPrefixDTOParam;
import com.hzchum.scim.system.core.api.service.MesSectionWarehouseConfigDetailService;
import com.hzchum.scim.system.core.api.service.SysAssembleConfigService;
import com.hzchum.scim.system.core.api.service.SysSteelClassificationService;
import com.hzchum.scim.system.core.api.service.SysStructureClassificationChangeService;
import com.hzchum.scim.system.core.api.service.SysStructureClassificationService;
import com.hzchum.scim.system.core.api.service.SysStructureSerialNumberPrefixChangeService;
import com.hzchum.scim.system.core.api.service.SysStructureSerialNumberPrefixService;
import com.hzchum.scim.system.core.api.service.SysStructureSpecChangeService;
import com.hzchum.scim.system.core.api.service.SysStructureSpecNumberLinkService;
import com.hzchum.scim.system.core.api.service.SysStructureSpecService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SysStructureClassificationBizImpl implements SysStructureClassificationBiz {
   private static final Logger log = LoggerFactory.getLogger(SysStructureClassificationBizImpl.class);
   @Resource
   private SysStructureSpecService structureSpecService;
   @Resource
   private SysStructureClassificationService structureClassificationService;
   @Resource
   private TechArtifactService artifactService;
   @Resource
   private SysStructureSerialNumberPrefixService serialNumberPrefixService;
   @Resource
   private SysStructureSpecNumberLinkService structureSpecNumberLinkService;
   @Resource
   private MesBuildingProductProcessService productProcessService;
   @Resource
   private SysStructureClassificationChangeService classificationChangeService;
   @Resource
   private SysStructureSerialNumberPrefixChangeService serialNumberPrefixChangeService;
   @Resource
   private SysStructureSpecChangeService specChangeService;
   @Resource
   private UserService userService;
   @Autowired
   private TechArtifactExtService artifactExtService;
   @Resource
   private SysSteelClassificationService partClassificationService;
   @Resource
   private SysAssembleConfigService assembleConfigService;
   @Resource
   private MesSectionWarehouseConfigDetailService sectionWarehouseConfigDetailService;

   @Override
   public List<PartArtAssClassificationDTO> findAllTypeClassification(Integer mesProductEnum) {
      List<PartArtAssClassificationDTO> dtoListVO = new ArrayList<>();
      List<PartArtAssClassificationDTO> artClassification = this.structureClassificationService
         .list((Wrapper<SysStructureClassification>)new LambdaQueryWrapper<SysStructureClassification>().eq(SysStructureClassification::getMesProductEnum, mesProductEnum))
         .stream()
         .map(s -> {
            PartArtAssClassificationDTO dto = new PartArtAssClassificationDTO();
            dto.setId(s.getId());
            dto.setClassName(s.getClassificationName());
            dto.setArtifactType(s.getArtifactType());
            dto.setTaskTypeEnum(TaskTypeEnum.ARTIFACT.getType());
            return dto;
         })
         .collect(Collectors.toList());
      List<PartArtAssClassificationDTO> parClassification = this.partClassificationService
         .list((Wrapper<SysSteelClassification>)new LambdaQueryWrapper<SysSteelClassification>().eq(SysSteelClassification::getMesProductEnum, mesProductEnum))
         .stream()
         .map(s -> {
            PartArtAssClassificationDTO dto = new PartArtAssClassificationDTO();
            dto.setId(s.getId());
            dto.setClassName(s.getName());
            dto.setTaskTypeEnum(TaskTypeEnum.MACHINE_PART.getType());
            return dto;
         })
         .collect(Collectors.toList());
      List<PartArtAssClassificationDTO> assClassification = this.assembleConfigService
         .list((Wrapper<SysAssembleConfig>)new LambdaQueryWrapper<SysAssembleConfig>().eq(SysAssembleConfig::getMesProductEnum, mesProductEnum))
         .stream()
         .map(s -> {
            PartArtAssClassificationDTO dto = new PartArtAssClassificationDTO();
            dto.setId(s.getId());
            dto.setClassName(s.getName());
            dto.setTaskTypeEnum(TaskTypeEnum.ASSEMBLE.getType());
            return dto;
         })
         .collect(Collectors.toList());
      dtoListVO.addAll(artClassification);
      dtoListVO.addAll(parClassification);
      dtoListVO.addAll(assClassification);
      return dtoListVO;
   }

   @Override
   public ListVO<StructureParentTypeDTO> listByCondition(
      Integer productionLineType, String classificationName, Integer artifactType, Integer mesProductEnum, String sectionAndNameAndType
   ) {
      List<Long> classificationIds = this.structureClassificationService
         .selectIdsByCondition(productionLineType, classificationName, null, artifactType, mesProductEnum, sectionAndNameAndType);
      if (CollectionUtils.isEmpty(classificationIds)) {
         return new ListVO<>();
      }

      List<StructureClassificationDTO> dtoList = this.structureClassificationService.listByCondition(classificationIds);
      this.setChangeInfo(dtoList);
      List<StructureParentTypeDTO> parentTypeDTOS = dtoList.stream()
         .filter(s -> s.getProductionLineTypeEnum().equals(ProductionLineTypeEnum.TRADITIONAL_LINE.getType()))
         .map(
            s -> StructureParentTypeDTO.builder()
               .productionLineTypeEnum(s.getProductionLineTypeEnum())
               .parentType(s.getParentType())
               .structureClassificationList(Collections.singletonList(s))
               .build()
         )
         .collect(Collectors.toList());
      return new ListVO<>(parentTypeDTOS);
   }

   private void setChangeInfo(List<StructureClassificationDTO> dtoList) {
      Set<Long> changeIds = dtoList.stream().map(StructureClassificationDTO::getLastChangeId).filter(Objects::nonNull).collect(Collectors.toSet());
      if (!CollUtil.isEmpty(changeIds)) {
         List<SysStructureClassificationChange> scChageList = this.classificationChangeService.listByIds(changeIds);
         if (!CollUtil.isEmpty(scChageList)) {
            Set<Long> auditUserIds = scChageList.stream()
               .map(SysStructureClassificationChange::getAuditUserId)
               .filter(Objects::nonNull)
               .collect(Collectors.toSet());
            Map<Long, String> auditUserMap = MapUtil.newHashMap();
            if (CollUtil.isNotEmpty(auditUserIds)) {
               auditUserMap = this.userService.listByIds(auditUserIds).stream().collect(Collectors.toMap(User::getId, User::getName));
            }

            List<SysStructureSpecChange> spChangeList = this.specChangeService
               .list(Wrappers.lambdaQuery(SysStructureSpecChange.class).in(SysStructureSpecChange::getStructureClassificationChangeId, changeIds));
            Map<Long, List<SysStructureSpecChange>> spChangeMap = MapUtil.newHashMap();
            if (CollUtil.isNotEmpty(spChangeList)) {
               spChangeMap = spChangeList.stream().collect(Collectors.groupingBy(SysStructureSpecChange::getStructureClassificationChangeId));
            }

            List<SysStructureSerialNumberPrefixChange> snChangeList = this.serialNumberPrefixChangeService
               .list(
                  Wrappers.lambdaQuery(SysStructureSerialNumberPrefixChange.class)
                     .in(SysStructureSerialNumberPrefixChange::getStructureClassificationChangeId, changeIds)
               );
            Map<Long, List<SysStructureSerialNumberPrefixChange>> snChangeMap = MapUtil.newHashMap();
            if (CollUtil.isNotEmpty(snChangeList)) {
               snChangeMap = snChangeList.stream().collect(Collectors.groupingBy(SysStructureSerialNumberPrefixChange::getStructureClassificationChangeId));
            }

            Map<Long, SysStructureClassificationChange> scChangeMap = scChageList.stream()
               .collect(Collectors.toMap(SysStructureClassificationChange::getStructureClassificationId, Function.identity()));

            for (StructureClassificationDTO dto : dtoList) {
               SysStructureClassificationChange scChange = scChangeMap.get(dto.getId());
               if (scChange != null) {
                  dto.setNewClassificationName(scChange.getClassificationName());
                  dto.setNewParentType(scChange.getParentType());
                  dto.setNewCodingType(scChange.getCodingType());
                  dto.setNewSort(scChange.getSort());
                  dto.setNewDefinitionWord(scChange.getDefinitionWord());
                  dto.setNewSmallArtifactClassEnum(scChange.getSmallArtifactClassEnum());
                  dto.setAuditName(auditUserMap.get(scChange.getAuditUserId()));
                  dto.setAuditStatus(scChange.getAuditStatus());
                  dto.setAuditTime(scChange.getAuditTime());
                  Map<Long, StructureSpecDTO> spMap = dto.getSpecPrefixList().stream().collect(Collectors.toMap(StructureSpecDTO::getId, Function.identity()));
                  List<SysStructureSpecChange> spChanges = spChangeMap.get(scChange.getId());
                  if (CollUtil.isNotEmpty(spChanges)) {
                     List<StructureSpecDTO> spNewDTOList = CollUtil.newArrayList();

                     for (SysStructureSpecChange spChange : spChanges) {
                        StructureSpecDTO spNewDTO = StructureSpecDTO.builder().build();
                        StructureSpecDTO spOldDTO = spMap.get(spChange.getStructureSpecId());
                        if (spOldDTO != null) {
                           spNewDTO.setId(spOldDTO.getId());
                           spNewDTO.setSpecPrefix(spOldDTO.getSpecPrefix());
                           spNewDTO.setProductionLineTypeEnum(spOldDTO.getProductionLineTypeEnum());
                        }

                        spNewDTO.setNewSpecPrefix(spChange.getSpecPrefix());
                        spNewDTO.setChangeType(spChange.getChangeType());
                        spNewDTOList.add(spNewDTO);
                     }

                     dto.setNewSpecPrefixList(spNewDTOList);
                  }

                  Map<Long, StructureSerialNumberPrefixDTO> snMap = dto.getSerialNumberPrefixList()
                     .stream()
                     .collect(Collectors.toMap(StructureSerialNumberPrefixDTO::getId, Function.identity()));
                  List<SysStructureSerialNumberPrefixChange> snChanges = snChangeMap.get(scChange.getId());
                  if (CollUtil.isNotEmpty(snChanges)) {
                     List<StructureSerialNumberPrefixDTO> snNewDTOList = CollUtil.newArrayList();

                     for (SysStructureSerialNumberPrefixChange snChange : snChanges) {
                        StructureSerialNumberPrefixDTO snNewDTO = StructureSerialNumberPrefixDTO.builder().build();
                        StructureSerialNumberPrefixDTO snOldDTO = snMap.get(snChange.getStructureSerialNumberPrefixId());
                        if (snOldDTO != null) {
                           snNewDTO.setId(snOldDTO.getId());
                           snNewDTO.setSerialNumberPrefix(snOldDTO.getSerialNumberPrefix());
                           snNewDTO.setProductionLineTypeEnum(snOldDTO.getProductionLineTypeEnum());
                        }

                        snNewDTO.setNewSerialNumberPrefix(snChange.getSerialNumberPrefix());
                        snNewDTO.setChangeType(snChange.getChangeType());
                        snNewDTOList.add(snNewDTO);
                     }

                     dto.setNewSerialNumberPrefixList(snNewDTOList);
                  }
               }
            }
         }
      }
   }

   @Override
   public ListVO<StructureParentTypeDTO> list(Integer productionLineType, String classificationName) {
      List<StructureParentTypeDTO> parentTypeDTOS = this.structureClassificationService.listStructureClass(productionLineType, classificationName);
      return new ListVO<>(parentTypeDTOS);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveOne(StructureClassificationSaveDTOParam param) {
      List<String> productTypeList = Arrays.asList("预埋件,埋件,平台板,直发件,钢板墙,异型构件,定位板,折弯件,檩托板,檩托".split(","));
      this.checkInsertStructureClass(param);
      SysStructureClassification structureClassification = BeanUtil.copy(param, SysStructureClassification.class);
      if (structureClassification.getArtifactType().equals(ArtifactTypeEnum.SMALL.getType())
         && productTypeList.contains(structureClassification.getClassificationName())) {
         structureClassification.setBoolComposeAssemble(Boolean.FALSE);
      }

      this.structureClassificationService.save(structureClassification);
      List<String> specPrefixList = param.getSpecPrefixList().stream().filter(StringUtils::isNotBlank).collect(Collectors.toList());
      this.saveStructureClass(structureClassification, specPrefixList, param.getSerialNumberPrefixList());
      return true;
   }

   private void checkInsertStructureClass(StructureClassificationSaveDTOParam param) {
      int count = this.structureClassificationService
         .count(
            Wrappers.lambdaQuery(SysStructureClassification.class)
               .eq(SysStructureClassification::getClassificationName, param.getClassificationName())
               .eq(SysStructureClassification::getMesProductEnum, param.getMesProductEnum())
         );
      Preconditions.checkArgument(count == 0, "新增失败,该产品类型内,构件类型名称已存在");
      Preconditions.checkArgument(param.getArtifactType() == null || ArtifactTypeEnum.exist(param.getArtifactType()), "构件类型传值错误");
      if (param.getMesProductEnum().equals(MesProductEnum.BRIDGE.getType())) {
         Preconditions.checkArgument(ArtifactTypeEnum.COMMON.getType().equals(param.getArtifactType()), "桥梁构件不可配置为次构件!");
      }

      param.setCodingType(param.getCodingType() == null ? CodingTypeEnum.SINGLE.getType() : param.getCodingType());
      List<String> specPrefixList = param.getSpecPrefixList().stream().filter(StringUtils::isNotBlank).map(String::toUpperCase).collect(Collectors.toList());
      specPrefixList.forEach(
         specPrefix -> {
            this.checkSpecPrefix(specPrefix);
            if (param.getMesProductEnum().equals(MesProductEnum.BUILDING.getType())) {
               Preconditions.checkArgument(
                  param.getArtifactType().equals(ArtifactTypeEnum.SMALL.getType()) || !NoDefinitionArtifactPrefixEnum.isExist(specPrefix),
                  "主构件规格前缀不能定义为" + specPrefix
               );
            }
         }
      );
      if (param.getArtifactType().equals(ArtifactTypeEnum.COMMON.getType())) {
         specPrefixList.forEach(
            specPrefix -> {
               SysStructureSpec structureSpec = this.structureSpecService
                  .getOne(
                     Wrappers.lambdaQuery(SysStructureSpec.class)
                        .eq(SysStructureSpec::getArtifactType, param.getArtifactType())
                        .eq(SysStructureSpec::getSpecPrefix, specPrefix)
                        .eq(SysStructureSpec::getMesProductEnum, param.getMesProductEnum())
                  );
               Preconditions.checkArgument(structureSpec == null, "该主构件规格前缀类型[" + specPrefix + "]已存在");
            }
         );
      }

      if (param.getArtifactType().equals(ArtifactTypeEnum.SMALL.getType())) {
         List<String> snPrefixList = param.getSerialNumberPrefixList()
            .stream()
            .filter(s -> s != null && StringUtils.isNotBlank(s.getSerialNumberPrefix()))
            .map(StructureSerialNumberPrefixDTOParam::getSerialNumberPrefix)
            .collect(Collectors.toList());
         Preconditions.checkArgument(com.baomidou.mybatisplus.core.toolkit.CollectionUtils.isNotEmpty(snPrefixList), "次构件类型-必须配置匹配名称");
         Map<String, Map<String, SysStructureSpecNumberLink>> specSnPrefixMap = this.structureSpecNumberLinkService
            .list()
            .stream()
            .collect(
               Collectors.groupingBy(SysStructureSpecNumberLink::getSpecPrefix, Collectors.toMap(SysStructureSpecNumberLink::getSnPrefix, Function.identity()))
            );
         specPrefixList.forEach(
            specPrefix -> {
               if (specSnPrefixMap.containsKey(specPrefix)) {
                  snPrefixList.forEach(
                     snPrefix -> Preconditions.checkArgument(
                        !specSnPrefixMap.get(specPrefix).containsKey(snPrefix), "次构件的规格前缀[" + specPrefix + "]和匹配名称[" + snPrefix + "]已存在定义"
                     )
                  );
               }
            }
         );
         List<MesSectionWarehouseConfigDetail> warehouseConfigDetailList = this.sectionWarehouseConfigDetailService
            .list(
               (Wrapper<MesSectionWarehouseConfigDetail>)(((new LambdaQueryWrapper<MesSectionWarehouseConfigDetail>()
                           .eq(
                              MesSectionWarehouseConfigDetail::getProductClassificationEnum,
                              ProductClassificationEnum.SECONDARY_MEMBER.getType() | ProductClassificationEnum.PRIMARY_MEMBER.getType()
                           ))
                        .eq(MesSectionWarehouseConfigDetail::getProductSectionNameEnum, ProductSectionNameEnum.SECTION_TYPE_ENUM.getType()))
                     .eq(MesSectionWarehouseConfigDetail::getProductType, ProductTypeEnum.ARTIFACT.getType()))
                  .eq(MesSectionWarehouseConfigDetail::getSmallArtifactClassEnum, SmallArtifactClassEnum.PURLIN.getType())
            );
         if (com.baomidou.mybatisplus.core.toolkit.CollectionUtils.isNotEmpty(warehouseConfigDetailList)) {
            Set<String> configDetailNames = warehouseConfigDetailList.stream().map(MesSectionWarehouseConfigDetail::getName).collect(Collectors.toSet());
            if (configDetailNames.stream().anyMatch(specPrefixList::contains)) {
               Preconditions.checkArgument(configDetailNames.containsAll(specPrefixList), "操作失败,所选截面包含檩条类规格,其余规格也需要都是檩条类截面!");
               param.setSmallArtifactClassEnum(SmallArtifactClassEnum.PURLIN.getType());
            }
         }
      }
   }

   private void checkSpecPrefix(String specPrefix) {
      Preconditions.checkArgument(StringUtils.isNotBlank(specPrefix), "规格前缀不能为空");
      char[] chars = specPrefix.toCharArray();

      for (char c : chars) {
         boolean boolDiameter = String.valueOf(c).equals("Φ") || String.valueOf(c).equals("⏀") || String.valueOf(c).equals("φ");
         Preconditions.checkArgument(c >= 'A' && c <= 'Z' || String.valueOf(c).matches("[一-龥 ]") || boolDiameter, "规格前缀只可配置[大写字母]或者[汉字]");
      }
   }

   private void saveStructureClass(
      SysStructureClassification structureClassification, List<String> specPrefixList, Set<StructureSerialNumberPrefixDTOParam> serialNumberPrefixDtoParamList
   ) {
      List<SysStructureSpec> structureSpecList = specPrefixList.stream()
         .map(
            specPrefix -> SysStructureSpec.builder()
               .specPrefix(specPrefix)
               .structureClassificationId(structureClassification.getId())
               .artifactType(structureClassification.getArtifactType())
               .smallArtifactClassEnum(structureClassification.getSmallArtifactClassEnum())
               .mesProductEnum(structureClassification.getMesProductEnum())
               .build()
         )
         .collect(Collectors.toList());
      this.structureSpecService.saveBatch(structureSpecList);
      if (structureClassification.getArtifactType().equals(ArtifactTypeEnum.SMALL.getType())) {
         Set<String> snPrefixList = serialNumberPrefixDtoParamList.stream()
            .filter(s -> s != null && StringUtils.isNotBlank(s.getSerialNumberPrefix()))
            .map(StructureSerialNumberPrefixDTOParam::getSerialNumberPrefix)
            .collect(Collectors.toSet());
         List<SysStructureSerialNumberPrefix> serialNumberPrefixList = snPrefixList.stream().map(snPrefix -> {
            SysStructureSerialNumberPrefix serialNumberPrefix = BeanUtil.copy(structureClassification, SysStructureSerialNumberPrefix.class);
            serialNumberPrefix.setSerialNumberPrefix(snPrefix);
            serialNumberPrefix.setStructureClassificationId(structureClassification.getId());
            return serialNumberPrefix;
         }).collect(Collectors.toList());
         this.serialNumberPrefixService.saveBatch(serialNumberPrefixList);
         List<SysStructureSpecNumberLink> specNumberLinkList = new ArrayList<>(64);
         specPrefixList.forEach(
            specPrefix -> snPrefixList.forEach(
               snPrefix -> {
                  SysStructureSpecNumberLink link = SysStructureSpecNumberLink.builder()
                     .structureClassificationId(structureClassification.getId())
                     .specPrefix(specPrefix)
                     .snPrefix(snPrefix)
                     .smallArtifactClassEnum(structureClassification.getSmallArtifactClassEnum())
                     .mesProductEnum(structureClassification.getMesProductEnum())
                     .build();
                  specNumberLinkList.add(link);
               }
            )
         );
         this.structureSpecNumberLinkService.saveBatch(specNumberLinkList);
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateStructureClassification(StructureClassificationUpdateTOParam param) {
      List<String> productTypeList = Arrays.asList("预埋件,埋件,平台板,直发件,钢板墙,异型构件,定位板,折弯件,檩托板,檩托".split(","));
      SysStructureClassification structureClassification = this.structureClassificationService.getById(param.getId());
      Preconditions.checkArgument(structureClassification != null, "修改失败,构件类型不存在");
      this.checkUpdateStructureClass(structureClassification, param);
      BeanUtil.copy(param, structureClassification);
      if (structureClassification.getArtifactType().equals(ArtifactTypeEnum.SMALL.getType())
         && productTypeList.contains(structureClassification.getClassificationName())) {
         structureClassification.setBoolComposeAssemble(Boolean.FALSE);
      }

      this.structureClassificationService.updateById(structureClassification);
      this.structureSpecService.remove(Wrappers.lambdaQuery(SysStructureSpec.class).eq(SysStructureSpec::getStructureClassificationId, param.getId()));
      this.serialNumberPrefixService
         .remove(Wrappers.lambdaQuery(SysStructureSerialNumberPrefix.class).eq(SysStructureSerialNumberPrefix::getStructureClassificationId, param.getId()));
      this.structureSpecNumberLinkService.remove(Wrappers.lambdaQuery(SysStructureSpecNumberLink.builder().structureClassificationId(param.getId()).build()));
      List<String> specPrefixList = param.getSpecPrefixList()
         .stream()
         .filter(s -> s != null && StringUtils.isNotBlank(s.getSpecPrefix()))
         .map(s -> s.getSpecPrefix().toUpperCase())
         .collect(Collectors.toList());
      this.saveStructureClass(structureClassification, specPrefixList, param.getSerialNumberPrefixList());
      return true;
   }

   @Override
   public void checkUpdateStructureClass(SysStructureClassification structureClass, StructureClassificationUpdateTOParam param) {
      int processCount = this.productProcessService
         .count(
            Wrappers.lambdaQuery(
               MesBuildingProductProcess.builder()
                  .productType(com.hzchum.scim.common.core.api.enums.ProductTypeEnum.ARTIFACT.getType())
                  .typeId(param.getId())
                  .build()
            )
         );
      if (!structureClass.getClassificationName().equals(param.getClassificationName())) {
         int count = this.structureClassificationService
            .count(
               Wrappers.lambdaQuery(SysStructureClassification.class)
                  .eq(SysStructureClassification::getMesProductEnum, param.getMesProductEnum())
                  .eq(SysStructureClassification::getClassificationName, param.getClassificationName())
            );
         Preconditions.checkArgument(count == 0, "该产品类型内,构件类型名称已存在");
         Preconditions.checkArgument(processCount == 0, "该类型已配置工序,不可修改类型名称!");
      }

      List<String> newSpecPrefixList = param.getSpecPrefixList()
         .stream()
         .filter(s -> s != null && StringUtils.isNotBlank(s.getSpecPrefix()))
         .map(s -> s.getSpecPrefix().toUpperCase())
         .collect(Collectors.toList());
      Preconditions.checkArgument(com.baomidou.mybatisplus.core.toolkit.CollectionUtils.isNotEmpty(newSpecPrefixList), "修改失败,规格类型列表不能为空!");
      List<String> oldSpecPrefixList = this.structureSpecService
         .list(Wrappers.lambdaQuery(SysStructureSpec.class).eq(SysStructureSpec::getStructureClassificationId, param.getId()))
         .stream()
         .map(SysStructureSpec::getSpecPrefix)
         .collect(Collectors.toList());
      oldSpecPrefixList.forEach(specPrefix -> {
         if (!newSpecPrefixList.contains(specPrefix)) {
            Preconditions.checkArgument(processCount == 0, "该类型已配置工序,不可修改规格前缀类型!");
            TechArtifact artifact = this.artifactService.getOneByClassIdAndPrefix(structureClass.getId(), specPrefix, null);
            Preconditions.checkArgument(artifact == null, "修改失败,规格前缀类型(" + specPrefix + ")不能删除,清单中已存在该类型构件");
         }
      });
      if (structureClass.getArtifactType().equals(ArtifactTypeEnum.COMMON.getType())) {
         newSpecPrefixList.forEach(
            specPrefix -> {
               if (!oldSpecPrefixList.contains(specPrefix)) {
                  this.checkSpecPrefix(specPrefix);
                  if (param.getMesProductEnum().equals(MesProductEnum.BUILDING.getType())) {
                     Preconditions.checkArgument(!NoDefinitionArtifactPrefixEnum.isExist(specPrefix), "主构件规格前缀不能定义为" + specPrefix);
                  }

                  int count = this.structureSpecService
                     .count(
                        Wrappers.lambdaQuery(SysStructureSpec.class)
                           .eq(SysStructureSpec::getSpecPrefix, specPrefix)
                           .eq(SysStructureSpec::getMesProductEnum, param.getMesProductEnum())
                           .eq(SysStructureSpec::getArtifactType, structureClass.getArtifactType())
                     );
                  Preconditions.checkArgument(count == 0, "修改失败,规格前缀类型(" + specPrefix + ")已定义");
               }
            }
         );
      }

      if (structureClass.getArtifactType().equals(ArtifactTypeEnum.SMALL.getType())) {
         List<String> newSnPrefixList = param.getSerialNumberPrefixList()
            .stream()
            .filter(s -> s != null && StringUtils.isNotBlank(s.getSerialNumberPrefix()))
            .map(StructureSerialNumberPrefixDTOParam::getSerialNumberPrefix)
            .collect(Collectors.toList());
         Preconditions.checkArgument(com.baomidou.mybatisplus.core.toolkit.CollectionUtils.isNotEmpty(newSnPrefixList), "修改失败：次构件必须配置匹配名称");
         List<String> oldSnPrefixList = this.serialNumberPrefixService
            .list(
               Wrappers.lambdaQuery(
                  SysStructureSerialNumberPrefix.builder().structureClassificationId(param.getId()).mesProductEnum(param.getMesProductEnum()).build()
               )
            )
            .stream()
            .map(SysStructureSerialNumberPrefix::getSerialNumberPrefix)
            .collect(Collectors.toList());
         oldSnPrefixList.forEach(oldSnPrefix -> {
            if (!newSnPrefixList.contains(oldSnPrefix)) {
               Preconditions.checkArgument(processCount == 0, "该类型已配置工序,不可修改匹配名称!");
               TechArtifact artifact = this.artifactService.getOneByClassIdAndPrefix(structureClass.getId(), null, oldSnPrefix);
               Preconditions.checkArgument(artifact == null, "修改失败,匹配名称(" + oldSnPrefix + ")不能删除,清单中已存在该类型构件");
            }
         });
         Map<String, Map<String, SysStructureSpecNumberLink>> specSnPrefixMap = this.structureSpecNumberLinkService
            .list(
               (Wrapper<SysStructureSpecNumberLink>)new LambdaQueryWrapper<SysStructureSpecNumberLink>()
                  .eq(SysStructureSpecNumberLink::getMesProductEnum, MesProductEnum.BUILDING.getType())
            )
            .stream()
            .collect(
               Collectors.groupingBy(SysStructureSpecNumberLink::getSpecPrefix, Collectors.toMap(SysStructureSpecNumberLink::getSnPrefix, Function.identity()))
            );
         newSpecPrefixList.forEach(
            newSpecPrefix -> {
               if (oldSpecPrefixList.contains(newSpecPrefix)) {
                  newSnPrefixList.forEach(
                     newSnPrefix -> {
                        if (!oldSnPrefixList.contains(newSnPrefix) && com.baomidou.mybatisplus.core.toolkit.CollectionUtils.isNotEmpty(specSnPrefixMap)) {
                           Preconditions.checkArgument(
                              !specSnPrefixMap.getOrDefault(newSpecPrefix, new HashMap<>()).containsKey(newSnPrefix),
                              "修改失败,规格前缀[" + newSpecPrefix + "]和匹配名称[" + newSnPrefix + "]已定义"
                           );
                        }
                     }
                  );
               }

               if (!oldSpecPrefixList.contains(newSpecPrefix) && specSnPrefixMap.containsKey(newSpecPrefix)) {
                  newSnPrefixList.forEach(
                     snPrefix -> Preconditions.checkArgument(
                        !specSnPrefixMap.getOrDefault(newSpecPrefix, new HashMap<>()).containsKey(snPrefix),
                        "修改失败,规格前缀[" + newSpecPrefix + "]和匹配名称[" + snPrefix + "]已定义"
                     )
                  );
               }
            }
         );
         List<MesSectionWarehouseConfigDetail> warehouseConfigDetailList = this.sectionWarehouseConfigDetailService
            .list(
               (Wrapper<MesSectionWarehouseConfigDetail>)(((new LambdaQueryWrapper<MesSectionWarehouseConfigDetail>()
                           .eq(
                              MesSectionWarehouseConfigDetail::getProductClassificationEnum,
                              ProductClassificationEnum.SECONDARY_MEMBER.getType() | ProductClassificationEnum.PRIMARY_MEMBER.getType()
                           ))
                        .eq(MesSectionWarehouseConfigDetail::getProductSectionNameEnum, ProductSectionNameEnum.SECTION_TYPE_ENUM.getType()))
                     .eq(MesSectionWarehouseConfigDetail::getProductType, ProductTypeEnum.ARTIFACT.getType()))
                  .eq(MesSectionWarehouseConfigDetail::getSmallArtifactClassEnum, SmallArtifactClassEnum.PURLIN.getType())
            );
         if (com.baomidou.mybatisplus.core.toolkit.CollectionUtils.isNotEmpty(warehouseConfigDetailList)) {
            Set<String> configDetailNames = warehouseConfigDetailList.stream().map(MesSectionWarehouseConfigDetail::getName).collect(Collectors.toSet());
            if (configDetailNames.stream().anyMatch(newSpecPrefixList::contains)) {
               Preconditions.checkArgument(configDetailNames.containsAll(newSpecPrefixList), "操作失败,所选截面包含檩条类规格,其余规格也需要都是檩条类截面!");
               param.setSmallArtifactClassEnum(SmallArtifactClassEnum.PURLIN.getType());
            }
         }
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteIds(List<Long> ids) {
      ids.forEach(
         id -> {
            SysStructureClassification structureClassification = this.structureClassificationService.getById(id);
            Preconditions.checkArgument(structureClassification != null, "删除失败,数据不存在");
            TechArtifact artifact = this.artifactService.getOneByClassIdAndPrefix(id, null, null);
            Preconditions.checkArgument(artifact == null, "删除失败,构件清单中存在该类型构件");
            Preconditions.checkArgument(
               this.productProcessService
                     .count(
                        Wrappers.lambdaQuery(
                           MesBuildingProductProcess.builder()
                              .productType(com.hzchum.scim.common.core.api.enums.ProductTypeEnum.ARTIFACT.getType())
                              .typeId(id)
                              .build()
                        )
                     )
                  == 0,
               "删除失败,构件类型已配置工序!"
            );
            this.structureSpecService.remove(Wrappers.lambdaQuery(SysStructureSpec.class).eq(SysStructureSpec::getStructureClassificationId, id));
            this.serialNumberPrefixService
               .remove((Wrapper<SysStructureSerialNumberPrefix>)Wrappers.<SysStructureSerialNumberPrefix>lambdaQuery().eq(SysStructureSerialNumberPrefix::getStructureClassificationId, id));
            this.structureSpecNumberLinkService.remove(Wrappers.lambdaQuery(SysStructureSpecNumberLink.builder().structureClassificationId(id).build()));
            this.structureClassificationService.removeById(id);
         }
      );
      return true;
   }

   @Override
   public List<StructureClassificationDTO> listByContractProjectId(Long contractProjectId, Long monomerId, Long areaId) {
      List<TechArtifact> artifactList = this.artifactService
         .list(
            Wrappers.lambdaQuery(TechArtifact.class)
               .eq(TechArtifact::getProjectId, contractProjectId)
               .eq(monomerId != null, TechArtifact::getMonomerId, monomerId)
               .eq(areaId != null, TechArtifact::getAreaId, areaId)
         );
      Preconditions.checkArgument(CollUtil.isNotEmpty(artifactList), "无构件种类列表");
      Map<Long, List<TechArtifact>> artifactByStructureClassIdMap = artifactList.stream().collect(Collectors.groupingBy(TechArtifact::getStructureClassId));
      List<Long> unassociatedArtifactIdList = this.artifactExtService
         .list(
            Wrappers.lambdaQuery(TechArtifactExt.class)
               .in(TechArtifactExt::getArtifactId, artifactList.stream().map(TechArtifact::getId).collect(Collectors.toList()))
               .isNull(TechArtifactExt::getBooleanPainting)
         )
         .stream()
         .map(TechArtifactExt::getArtifactId)
         .collect(Collectors.toList());
      List<SysStructureClassification> structureClassificationList = this.structureClassificationService
         .listByIds(artifactList.stream().map(TechArtifact::getStructureClassId).collect(Collectors.toList()));
      Preconditions.checkArgument(CollUtil.isNotEmpty(structureClassificationList), "无构件种类列表");
      return structureClassificationList.stream()
         .map(
            sc -> {
               StructureClassificationDTO structureClassificationDTO = cn.hutool.core.bean.BeanUtil.toBean(sc, StructureClassificationDTO.class);
               List<TechArtifact> artifacts = artifactByStructureClassIdMap.get(structureClassificationDTO.getId());
               structureClassificationDTO.setArtifactQuantity(artifacts.size());
               Long associatedPaintingArtifactQuantity = artifacts.stream()
                  .filter(a -> CollUtil.isNotEmpty(unassociatedArtifactIdList) && !unassociatedArtifactIdList.contains(a.getId()))
                  .count();
               structureClassificationDTO.setAssociatedPaintingArtifactQuantity(associatedPaintingArtifactQuantity.intValue());
               return structureClassificationDTO;
            }
         )
         .collect(Collectors.toList());
   }

   @Override
   public Map<Integer, List<StructureClassificationDTO>> listArtifactSysAll(Integer mesProductEnum) {
      List<Long> classificationIds = this.structureClassificationService.selectIdsByCondition(null, null, null, null, mesProductEnum, null);
      if (CollectionUtils.isEmpty(classificationIds)) {
         return new HashMap<>();
      }

      List<StructureClassificationDTO> dtoList = this.structureClassificationService.listByCondition(classificationIds);
      this.setChangeInfo(dtoList);
      List<StructureParentTypeDTO> parentTypeDTOS = dtoList.stream()
         .filter(s -> s.getProductionLineTypeEnum().equals(ProductionLineTypeEnum.TRADITIONAL_LINE.getType()))
         .filter(s -> s.getArtifactType().equals(ArtifactTypeEnum.COMMON.getType()))
         .map(
            s -> StructureParentTypeDTO.builder()
               .productionLineTypeEnum(s.getProductionLineTypeEnum())
               .parentType(s.getParentType())
               .structureClassificationList(Collections.singletonList(s))
               .build()
         )
         .collect(Collectors.toList());
      List<StructureClassificationDTO> collect = parentTypeDTOS.stream()
         .map(StructureParentTypeDTO::getStructureClassificationList)
         .flatMap(Collection::stream)
         .collect(Collectors.toList());
      return collect.stream().collect(Collectors.groupingBy(StructureClassificationDTO::getArtifactType));
   }

   @Override
   public Map<Integer, List<StructureClassificationBasicDTO>> listArtifactWeldingProfilessAll(Integer mesProductEnum) {
      List<SysStructureClassification> structureClassifications = this.structureClassificationService
         .list(
            (Wrapper<SysStructureClassification>)(new LambdaQueryWrapper<SysStructureClassification>()
                  .eq(SysStructureClassification::getMesProductEnum, mesProductEnum))
               .isNotNull(SysStructureClassification::getBoolComposeAssemble)
         );
      if (!com.baomidou.mybatisplus.core.toolkit.CollectionUtils.isNotEmpty(structureClassifications)) {
         return new HashMap<>();
      }

      Map<Long, List<SysStructureSpec>> structureSpecMap = this.structureSpecService
         .list(
            (Wrapper<SysStructureSpec>)new LambdaQueryWrapper<SysStructureSpec>()
               .in(
                  SysStructureSpec::getStructureClassificationId,
                  structureClassifications.stream().map(SysStructureClassification::getId).collect(Collectors.toList())
               )
         )
         .stream()
         .collect(Collectors.groupingBy(SysStructureSpec::getStructureClassificationId));
      List<StructureClassificationBasicDTO> structureClassificationBasicDTOS = cn.hutool.core.bean.BeanUtil.copyToList(
         structureClassifications, StructureClassificationBasicDTO.class
      );

      for (StructureClassificationBasicDTO basicDTO : structureClassificationBasicDTOS) {
         List<SysStructureSpec> sysStructureSpecs = structureSpecMap.get(basicDTO.getId());
         basicDTO.setSpecPrefixList(sysStructureSpecs.stream().map(SysStructureSpec::getSpecPrefix).collect(Collectors.toList()));
      }

      return structureClassificationBasicDTOS.stream().collect(Collectors.groupingBy(StructureClassificationBasicDTO::getArtifactType));
   }
}
