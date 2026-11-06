package com.hzchum.scim.contract.core.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.contract.core.api.enums.ContractTechTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo._do.ContractTech;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractTechBaseDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.StructureTypeDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ContractTechListDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.save.MeasureModeDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.save.PressureBearingPlateDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.save.ProfiledPlateDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.save.SandwichBoardDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.save.StructureDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.save.TrussFloorPlateDTOParam;
import com.hzchum.scim.contract.core.api.service.ContractProjectContentService;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.ContractTechService;
import com.hzchum.scim.contract.core.mapper.ContractTechMapper;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosurePlanTechDto;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class ContractTechServiceImpl extends ServiceImpl<ContractTechMapper, ContractTech> implements ContractTechService {
   @Resource
   private ContractProjectService projectService;
   @Resource
   private ContractProjectContentService projectContentService;
   @Resource
   private AttachmentService attachmentService;

   @Override
   public BigDecimal getWeightMeter(Long projectId, String plate) {
      ContractTech contractTech = this.baseMapper
         .selectOne(
            Wrappers.lambdaQuery(ContractTech.class)
               .eq(ContractTech::getProjectId, projectId)
               .eq(ContractTech::getType, ContractTechTypeEnum.TRUSS_FLOOR_PLATE.getType())
         );
      BigDecimal weightMeter = null;
      if (StringUtils.isNotBlank(contractTech.getDetailJson())) {
         Map<String, TrussFloorPlateDTOParam> plateDTOParamMap = JSON.parseArray(contractTech.getDetailJson(), TrussFloorPlateDTOParam.class)
            .stream()
            .collect(Collectors.toMap(TrussFloorPlateDTOParam::getSerialNumber, Function.identity(), (s1, s2) -> s2));
         weightMeter = plateDTOParamMap.get(plate).getWeightMeter();
      }

      return weightMeter;
   }

   @Override
   public ContractTechBaseDTO getWithDTO(Long projectId, Integer type, String plate) {
      Preconditions.checkArgument(projectId != null, "项目id不能为空");
      Preconditions.checkArgument(StringUtils.isNotBlank(plate), "板型不能为空");
      Preconditions.checkArgument(
         type.equals(ContractTechTypeEnum.PROFILED_PLATE.getType()) || type.equals(ContractTechTypeEnum.PRESSURE_BEARING_PLATE.getType()), "只支持压型彩板和压型楼承板!"
      );
      ContractTech tech = this.baseMapper
         .selectOne(Wrappers.lambdaQuery(ContractTech.class).eq(ContractTech::getProjectId, projectId).eq(ContractTech::getType, type));
      ContractTechBaseDTO baseDTO = null;
      if (type.equals(ContractTechTypeEnum.PROFILED_PLATE.getType())) {
         List<ProfiledPlateDTOParam> profiledPlateDTOParams = JSON.parseArray(tech.getDetailJson(), ProfiledPlateDTOParam.class);
         if (CollectionUtils.isNotEmpty(profiledPlateDTOParams)) {
            Map<String, ProfiledPlateDTOParam> map = profiledPlateDTOParams.stream()
               .collect(Collectors.toMap(ProfiledPlateDTOParam::getPlateType, Function.identity(), (s1, s2) -> s2));
            if (map.containsKey(plate)) {
               baseDTO = BeanUtil.copy(map.get(plate), ContractTechBaseDTO.class);
            }
         }
      } else {
         List<PressureBearingPlateDTOParam> pressureBearingPlateDTOParams = JSON.parseArray(tech.getDetailJson(), PressureBearingPlateDTOParam.class);
         if (CollectionUtils.isNotEmpty(pressureBearingPlateDTOParams)) {
            Map<String, PressureBearingPlateDTOParam> map = pressureBearingPlateDTOParams.stream()
               .collect(Collectors.toMap(PressureBearingPlateDTOParam::getPlateType, Function.identity(), (s1, s2) -> s2));
            if (map.containsKey(plate)) {
               baseDTO = BeanUtil.copy(map.get(plate), ContractTechBaseDTO.class);
            }
         }
      }

      return baseDTO;
   }

   @Override
   public List<Map<String, Object>> getEnclosureConfig(Long projectId, Integer type, String plateType) {
      Preconditions.checkArgument(projectId != null && type != null, "方法传参不可为空");
      ContractTech tech = this.baseMapper
         .selectOne(Wrappers.lambdaQuery(ContractTech.class).eq(ContractTech::getType, type).eq(ContractTech::getProjectId, projectId));
      List<Map<String, Object>> mapList = new ArrayList<>();
      if (ContractTechTypeEnum.PROFILED_PLATE.getType().equals(type) && StringUtils.isNotBlank(tech.getDetailJson())) {
         List<ProfiledPlateDTOParam> profiledPlateDTOParams = JSON.parseArray(tech.getDetailJson(), ProfiledPlateDTOParam.class);
         mapList = profiledPlateDTOParams.stream().filter(s -> s.getPlateType().equals(plateType)).map(BeanUtil::beanToMap).collect(Collectors.toList());
      }

      if (ContractTechTypeEnum.SANDWICH_BOARD.getType().equals(type) && StringUtils.isNotBlank(tech.getDetailJson())) {
         List<SandwichBoardDTOParam> sandwichBoardDTOParams = JSON.parseArray(tech.getDetailJson(), SandwichBoardDTOParam.class);
         mapList = sandwichBoardDTOParams.stream().filter(s -> s.getPlateType().equals(plateType)).map(BeanUtil::beanToMap).collect(Collectors.toList());
      }

      if (ContractTechTypeEnum.TRUSS_FLOOR_PLATE.getType().equals(type) && StringUtils.isNotBlank(tech.getDetailJson())) {
         List<TrussFloorPlateDTOParam> trussFloorPlateDTOParams = JSON.parseArray(tech.getDetailJson(), TrussFloorPlateDTOParam.class);
         mapList = trussFloorPlateDTOParams.stream().filter(s -> s.getSerialNumber().equals(plateType)).map(BeanUtil::beanToMap).collect(Collectors.toList());
      }

      if (ContractTechTypeEnum.PRESSURE_BEARING_PLATE.getType().equals(type) && StringUtils.isNotBlank(tech.getDetailJson())) {
         List<PressureBearingPlateDTOParam> pressureBearingPlateDTOParams = JSON.parseArray(tech.getDetailJson(), PressureBearingPlateDTOParam.class);
         mapList = pressureBearingPlateDTOParams.stream().filter(s -> s.getPlateType().equals(plateType)).map(BeanUtil::beanToMap).collect(Collectors.toList());
      }

      return mapList;
   }

   @Override
   public ContractTechListDTO listTech(Long projectId, Integer type) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "该项目不存在,或者id输入错误");
      ContractTechListDTO responseVO = new ContractTechListDTO();
      List<ContractTech> contractTechList = this.baseMapper
         .selectList(Wrappers.lambdaQuery(ContractTech.class).eq(ContractTech::getProjectId, projectId).eq(type != null, ContractTech::getType, type));
      if (contractTechList.isEmpty()) {
         return responseVO;
      }

      contractTechList.forEach(t -> {
         if (t.getType().equals(ContractTechTypeEnum.STRUCTURE.getType())) {
            List<StructureDTOParam> structureDTOParams = JSON.parseArray(t.getDetailJson(), StructureDTOParam.class);
            if (CollectionUtils.isNotEmpty(structureDTOParams)) {
               List<StructureTypeDTO> structureDTOList = structureDTOParams.stream().map(s -> {
                  StructureTypeDTO structureDTO = BeanUtil.copy(s, StructureTypeDTO.class);
                  structureDTO.setAttachments(this.attachmentService.listByIds(s.getAttachmentIds()));
                  return structureDTO;
               }).collect(Collectors.toList());
               responseVO.setStructureList(structureDTOList);
            }
         }

         if (t.getType().equals(ContractTechTypeEnum.PROFILED_PLATE.getType())) {
            List<ProfiledPlateDTOParam> profiledPlateDTOParams = JSON.parseArray(t.getDetailJson(), ProfiledPlateDTOParam.class);
            responseVO.setProfiledPlateList(profiledPlateDTOParams);
         }

         if (t.getType().equals(ContractTechTypeEnum.SANDWICH_BOARD.getType())) {
            List<SandwichBoardDTOParam> sandwichBoardDTOParams = JSON.parseArray(t.getDetailJson(), SandwichBoardDTOParam.class);
            responseVO.setSandwichBoardList(sandwichBoardDTOParams);
         }

         if (t.getType().equals(ContractTechTypeEnum.TRUSS_FLOOR_PLATE.getType())) {
            List<TrussFloorPlateDTOParam> trussFloorPlateDTOParams = JSON.parseArray(t.getDetailJson(), TrussFloorPlateDTOParam.class);
            responseVO.setTrussFloorPlateList(trussFloorPlateDTOParams);
         }

         if (t.getType().equals(ContractTechTypeEnum.PRESSURE_BEARING_PLATE.getType())) {
            List<PressureBearingPlateDTOParam> pressureBearingPlateDTOParams = JSON.parseArray(t.getDetailJson(), PressureBearingPlateDTOParam.class);
            responseVO.setPressureBearingPlateList(pressureBearingPlateDTOParams);
         }
      });
      return responseVO;
   }

   @Override
   public List<String> listPlate(Long projectId, Integer type) {
      ContractTech tech = this.baseMapper
         .selectOne(Wrappers.lambdaQuery(ContractTech.class).eq(ContractTech::getProjectId, projectId).eq(ContractTech::getType, type));
      if (tech != null && !StringUtils.isBlank(tech.getDetailJson()) && !"[]".equals(tech.getDetailJson()) && !"null".equals(tech.getDetailJson())) {
         List<String> collect = new ArrayList<>();
         if (type.equals(ContractTechTypeEnum.PROFILED_PLATE.getType())) {
            List<ProfiledPlateDTOParam> profiledPlateDTOParams = JSON.parseArray(tech.getDetailJson(), ProfiledPlateDTOParam.class);
            collect = profiledPlateDTOParams.stream().map(ProfiledPlateDTOParam::getPlateType).distinct().collect(Collectors.toList());
         }

         if (type.equals(ContractTechTypeEnum.PRESSURE_BEARING_PLATE.getType())) {
            List<PressureBearingPlateDTOParam> pressureBearingPlateDTOParams = JSON.parseArray(tech.getDetailJson(), PressureBearingPlateDTOParam.class);
            collect = pressureBearingPlateDTOParams.stream().map(PressureBearingPlateDTOParam::getPlateType).distinct().collect(Collectors.toList());
         }

         if (type.equals(ContractTechTypeEnum.TRUSS_FLOOR_PLATE.getType())) {
            List<TrussFloorPlateDTOParam> trussFloorPlateDTOParams = JSON.parseArray(tech.getDetailJson(), TrussFloorPlateDTOParam.class);
            collect = trussFloorPlateDTOParams.stream().map(TrussFloorPlateDTOParam::getSerialNumber).distinct().collect(Collectors.toList());
         }

         if (type.equals(ContractTechTypeEnum.SANDWICH_BOARD.getType())) {
            List<SandwichBoardDTOParam> sandwichBoardDTOParams = JSON.parseArray(tech.getDetailJson(), SandwichBoardDTOParam.class);
            collect = sandwichBoardDTOParams.stream().map(SandwichBoardDTOParam::getPlateType).distinct().collect(Collectors.toList());
         }

         return collect;
      } else {
         return new ArrayList<>();
      }
   }

   @Override
   public List<Map<String, Integer>> listEnclosureMeasureMode(Long projectId) {
      return this.baseMapper
         .selectList(Wrappers.lambdaQuery(ContractTech.class).eq(ContractTech::getProjectId, projectId))
         .stream()
         .filter(s -> s.getMeasureMode() != null)
         .map(s -> {
            Map<String, Integer> map = new LinkedHashMap<>();
            map.put("type", s.getType());
            map.put("measureMode", s.getMeasureMode());
            return map;
         })
         .collect(Collectors.toList());
   }

   @Override
   public List<Integer> changeEnclosureMeasureMode(Long projectId, List<MeasureModeDTOParam> measureModeDTOParamList) {
      List<Integer> categoryList = new ArrayList<>();
      List<ContractTech> contractTechList = this.baseMapper
         .selectList(Wrappers.lambdaQuery(ContractTech.class).eq(ContractTech::getProjectId, projectId).isNotNull(ContractTech::getMeasureMode));
      if (!CollectionUtils.isEmpty(measureModeDTOParamList) && !contractTechList.isEmpty()) {
         Map<Integer, ContractTech> techMap = contractTechList.stream().collect(Collectors.toMap(ContractTech::getType, Function.identity()));

         for (MeasureModeDTOParam m : measureModeDTOParamList) {
            if (techMap.containsKey(m.getNo()) && !techMap.get(m.getNo()).getMeasureMode().equals(m.getMeasureMode())) {
               categoryList.add(m.getNo());
            }
         }

         return categoryList;
      } else {
         return categoryList;
      }
   }

   @Override
   public Integer getMeasureMode(Long projectId, Integer productType, Integer category) {
      if (productType.equals(ProductTypeEnum.MACHINE_PART.getType()) || productType.equals(ProductTypeEnum.ARTIFACT.getType())) {
         ContractTech contractTech = this.baseMapper
            .selectOne(Wrappers.lambdaQuery(ContractTech.builder().projectId(projectId).categoryType(ProductTypeEnum.ARTIFACT.getType()).build()));
         return contractTech.getMeasureMode();
      } else if (productType.equals(ProductTypeEnum.ENCLOSURE.getType())) {
         Preconditions.checkArgument(category != null, "围护类型不能为空");
         ContractTech contractTech = this.baseMapper
            .selectOne(Wrappers.lambdaQuery(ContractTech.builder().projectId(projectId).categoryType(productType).type(category).build()));
         Preconditions.checkArgument(contractTech != null, "项目不包含该类型围护");
         return contractTech.getMeasureMode();
      } else {
         return null;
      }
   }

   @Override
   public Map<Integer, Integer> listProjectMeasureMode(Long projectId) {
      List<ContractTech> techList = this.baseMapper
         .selectList(Wrappers.lambdaQuery(ContractTech.class).eq(ContractTech::getProjectId, projectId).orderByAsc(ContractTech::getType));
      Map<Integer, Integer> measureModeMap = new LinkedHashMap<>();
      techList.forEach(tech -> {
         Integer var10000 = measureModeMap.put(tech.getType(), tech.getMeasureMode());
      });
      return measureModeMap;
   }

   @Override
   public List<EnclosurePlanTechDto> findByProjectId(Long projectId) {
      return this.baseMapper.findByProjectId(projectId);
   }
}
