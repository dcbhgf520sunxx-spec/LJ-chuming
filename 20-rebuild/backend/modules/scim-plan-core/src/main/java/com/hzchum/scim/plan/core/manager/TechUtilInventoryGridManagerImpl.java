package com.hzchum.scim.plan.core.manager;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.enums.ProductSectionNameEnum;
import com.hzchum.scim.plan.core.api.enums.InventoryTypeEnum;
import com.hzchum.scim.plan.core.api.manager.TechUtilInventoryGridManager;
import com.hzchum.scim.plan.core.api.pojo.dto.MistakeExportDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.manager.TechConfigUtilsDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.ArtifactBoxImportDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.ZnljGridImportTemplateDtoParam;
import com.hzchum.scim.plan.core.api.util.TechUtils;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureClassification;
import com.hzchum.scim.system.core.api.service.SysStructureClassificationService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class TechUtilInventoryGridManagerImpl implements TechUtilInventoryGridManager {
   private final SysStructureClassificationService structureClassificationService;

   @Override
   public List<ArtifactBoxImportDTO> getGridConversionList(
      List<MistakeExportDTO> mistakeExportDTOList,
      List<ZnljGridImportTemplateDtoParam> importList,
      TechConfigUtilsDTO utilsDTO,
      Long monomerId,
      Integer importType
   ) {
      Map<String, Long> commonStructureSpecMap = utilsDTO.getCommonStructureSpecMap();
      Map<String, Map<String, Long>> smallArtifactNameMap = utilsDTO.getSmallArtifactNameMap();
      Map<Integer, Map<String, Long>> standardPartConfigMap = utilsDTO.getStandardPartConfigMap();
      Map<String, Long> standardPartNameAndIdMap = standardPartConfigMap.get(ProductSectionNameEnum.PRODUCT_NAME.getType());
      this.checkFieldBlank(mistakeExportDTOList, commonStructureSpecMap, smallArtifactNameMap, importList);
      if (CollectionUtils.isNotEmpty(mistakeExportDTOList)) {
         return Collections.emptyList();
      }

      this.checkFieldEquals(mistakeExportDTOList, importList);
      if (CollectionUtils.isNotEmpty(mistakeExportDTOList)) {
         return Collections.emptyList();
      }

      Map<Long, SysStructureClassification> structureClassificationMap = this.structureClassificationService
         .list()
         .stream()
         .collect(Collectors.toMap(SysStructureClassification::getId, Function.identity()));
      Map<String, ArtifactBoxImportDTO> artifactBoxImportDtoMap = new LinkedHashMap<>(512);
      importList.forEach(
         importDto -> {
            SysStructureClassification classification = structureClassificationMap.get(importDto.getStructureClassId());
            ArtifactBoxImportDTO artifactBoxImportDTO = artifactBoxImportDtoMap.get(importDto.getSerialNumber());
            if (artifactBoxImportDTO != null) {
               artifactBoxImportDTO.setQuantity(artifactBoxImportDTO.getQuantity() + importDto.getQuantity());
               artifactBoxImportDTO.setTotalNetWeight(artifactBoxImportDTO.getTotalNetWeight().add(importDto.getTotalWeight()));
               artifactBoxImportDTO.setTotalGrossWeight(importDto.getTotalWeight().add(importDto.getTotalWeight()));
            } else {
               artifactBoxImportDTO = BeanUtil.copy(importDto, ArtifactBoxImportDTO.class);
               artifactBoxImportDTO.setNetWeight(
                  importDto.getTotalWeight().divide(BigDecimal.valueOf(importDto.getQuantity().intValue()), 4, RoundingMode.HALF_UP)
               );
               artifactBoxImportDTO.setGrossWeight(artifactBoxImportDTO.getNetWeight());
               artifactBoxImportDTO.setTotalNetWeight(importDto.getTotalWeight());
               artifactBoxImportDTO.setTotalGrossWeight(importDto.getTotalWeight());
               artifactBoxImportDTO.setSurfaceArea(
                  importDto.getTotalArea()
                     .multiply(BigDecimal.valueOf(1000000L))
                     .divide(BigDecimal.valueOf(importDto.getQuantity().intValue()), 8, RoundingMode.HALF_UP)
               );
               artifactBoxImportDTO.setBuildingType(InventoryTypeEnum.GRID.getType());
               artifactBoxImportDTO.setArtifactType(classification.getArtifactType());
               artifactBoxImportDTO.setCodingType(classification.getCodingType());
               artifactBoxImportDTO.setBoolAllPartSendDirectly(false);
               artifactBoxImportDTO.setBoolSchedulingEnum(true);
               artifactBoxImportDTO.setBoolSinglePartEnum(false);
               artifactBoxImportDTO.setBoolPurlineClass(utilsDTO.getPurlinClassIds().contains(importDto.getStructureClassId()));
               artifactBoxImportDTO.setAssembleImportDtoParamList(Collections.emptyList());
               artifactBoxImportDTO.setMachinePartImportDtoParamList(Collections.emptyList());
               artifactBoxImportDTO.setStandardPartImportDTOParamList(Collections.emptyList());
               artifactBoxImportDTO.setBoolSinglePartEnum(Boolean.FALSE);
               artifactBoxImportDTO.setBoolComposeAssemble(Boolean.FALSE);
               artifactBoxImportDTO.setBoolOnePartLine(Boolean.FALSE);
               if (artifactBoxImportDTO.getRemark() != null
                  && (artifactBoxImportDTO.getRemark().contains("直发件") || artifactBoxImportDTO.getRemark().contains("直发"))) {
                  artifactBoxImportDTO.setBoolSchedulingEnum(Boolean.TRUE);
                  artifactBoxImportDTO.setBoolSendDirectly(Boolean.TRUE);
                  artifactBoxImportDTO.setBoolCoatingEnum(Boolean.FALSE);
               }

               artifactBoxImportDtoMap.put(importDto.getSerialNumber(), artifactBoxImportDTO);
            }
         }
      );
      return new ArrayList<>(artifactBoxImportDtoMap.values());
   }

   private void checkFieldBlank(
      List<MistakeExportDTO> mistakeExportDTOList,
      Map<String, Long> commonStructureSpecMap,
      Map<String, Map<String, Long>> smallArtifactNameMap,
      List<ZnljGridImportTemplateDtoParam> importList
   ) {
      importList.forEach(importDto -> {
         if (importDto.getRemark() == null || !importDto.getRemark().contains("直发件") && !importDto.getRemark().contains("直发")) {
            boolean boolSendDirectly = false;
         } else {
            boolean boolSendDirectly = true;
         }

         if (StringUtils.isBlank(importDto.getStructureType())) {
            mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(importDto.getOrderNo(), "结构类型不能为空!"));
         } else if (importDto.getStructureType().length() > 255) {
            mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(importDto.getOrderNo(), "结构类型字数超出范围!"));
         }

         if (StringUtils.isBlank(importDto.getSerialNumber())) {
            mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(importDto.getOrderNo(), "杆件编号不能为空!"));
         } else if (importDto.getSerialNumber().length() > 255) {
            mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(importDto.getOrderNo(), "杆件编号字数超出范围!"));
         }

         if (StringUtils.isBlank(importDto.getName())) {
            importDto.setName("");
         } else if (importDto.getName().length() > 255) {
            mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(importDto.getOrderNo(), "名称字数超出范围!"));
         }

         if (StringUtils.isBlank(importDto.getSpecification())) {
            mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(importDto.getOrderNo(), "规格不能为空!"));
         } else if (importDto.getSpecification().length() > 255) {
            mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(importDto.getOrderNo(), "规格字数超出范围!"));
         } else {
            String specPrefix = TechUtils.getSpecPrefix(importDto.getSpecification());
            importDto.setSpecPrefix(specPrefix);
            if (smallArtifactNameMap.getOrDefault(specPrefix, Collections.emptyMap()).get(importDto.getName()) != null) {
               Long structureClassId = smallArtifactNameMap.get(specPrefix).get(importDto.getName());
               importDto.setStructureClassId(structureClassId);
            } else if (commonStructureSpecMap.get(specPrefix) != null) {
               Long structureClassId = commonStructureSpecMap.get(specPrefix);
               importDto.setStructureClassId(structureClassId);
            } else {
               mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(importDto.getOrderNo(), "规格类型未定义!"));
            }
         }

         if (StringUtils.isNotBlank(importDto.getMaterial()) && importDto.getMaterial().length() > 255) {
            mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(importDto.getOrderNo(), "材质字数超出范围!"));
         }

         if (importDto.getLength() == null || importDto.getLength().compareTo(BigDecimal.ZERO) <= 0) {
            importDto.setLength(BigDecimal.ZERO);
         }

         if (importDto.getQuantity() == null || importDto.getQuantity() <= 0) {
            mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(importDto.getOrderNo(), "数量有误!"));
         }

         if (importDto.getTotalWeight() == null || importDto.getTotalWeight().compareTo(BigDecimal.ZERO) <= 0) {
            importDto.setTotalWeight(BigDecimal.ZERO);
         }

         importDto.setBoolCoatingEnum(importDto.getTotalArea() != null && importDto.getTotalArea().compareTo(BigDecimal.ZERO) > 0);
         if (importDto.getTotalArea() == null || importDto.getTotalArea().compareTo(BigDecimal.ZERO) <= 0) {
            importDto.setTotalArea(BigDecimal.ZERO);
         }

         if (StringUtils.isNotBlank(importDto.getRemark()) && importDto.getRemark().length() > 255) {
            mistakeExportDTOList.add(TechUtils.buildMistakeByOrderNoDTO(importDto.getOrderNo(), "备注字数超出范围!"));
         }
      });
   }

   private void checkFieldEquals(List<MistakeExportDTO> mistakeExportDTOList, List<ZnljGridImportTemplateDtoParam> importList) {
      Map<String, List<ZnljGridImportTemplateDtoParam>> snImportListMap = importList.stream()
         .collect(Collectors.groupingBy(ZnljGridImportTemplateDtoParam::getSerialNumber));
      snImportListMap.forEach(
         (sn, list) -> {
            if (list.size() > 1) {
               Set<String> structureTypeSet = list.stream()
                  .map(ZnljGridImportTemplateDtoParam::getStructureType)
                  .filter(StringUtils::isNotBlank)
                  .collect(Collectors.toSet());
               if (structureTypeSet.size() > 1) {
                  mistakeExportDTOList.add(TechUtils.buildMistakeDTO("杆件编号[" + sn + "]的结构类型不一致!"));
               }

               Set<String> nameSet = list.stream().map(ZnljGridImportTemplateDtoParam::getName).filter(StringUtils::isNotBlank).collect(Collectors.toSet());
               if (nameSet.size() > 1) {
                  mistakeExportDTOList.add(TechUtils.buildMistakeDTO("杆件编号[" + sn + "]的名称不一致!"));
               }

               Set<String> specificationSet = list.stream()
                  .map(ZnljGridImportTemplateDtoParam::getSpecification)
                  .filter(StringUtils::isNotBlank)
                  .collect(Collectors.toSet());
               if (specificationSet.size() > 1) {
                  mistakeExportDTOList.add(TechUtils.buildMistakeDTO("杆件编号[" + sn + "]的规格不一致!"));
               }

               Set<String> materialSet = list.stream()
                  .map(ZnljGridImportTemplateDtoParam::getMaterial)
                  .filter(StringUtils::isNotBlank)
                  .collect(Collectors.toSet());
               if (materialSet.size() > 1) {
                  mistakeExportDTOList.add(TechUtils.buildMistakeDTO("杆件编号[" + sn + "]的材质不一致!"));
               }

               Set<BigDecimal> lengthSet = list.stream().map(ZnljGridImportTemplateDtoParam::getLength).collect(Collectors.toSet());
               if (lengthSet.size() > 1) {
                  mistakeExportDTOList.add(TechUtils.buildMistakeDTO("杆件编号[" + sn + "]的长度不一致!"));
               }

               Set<String> remarkSet = list.stream().map(ZnljGridImportTemplateDtoParam::getRemark).filter(StringUtils::isNotBlank).collect(Collectors.toSet());
               if (remarkSet.size() > 1) {
                  mistakeExportDTOList.add(TechUtils.buildMistakeDTO("杆件编号[" + sn + "]的备注不一致!"));
               }
            }
         }
      );
   }

   public TechUtilInventoryGridManagerImpl(final SysStructureClassificationService structureClassificationService) {
      this.structureClassificationService = structureClassificationService;
   }
}
