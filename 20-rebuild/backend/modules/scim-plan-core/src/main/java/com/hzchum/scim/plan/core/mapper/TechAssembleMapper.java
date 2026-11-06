package com.hzchum.scim.plan.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo.dto.AssembleDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.AssembleNestingDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.AssembleStructureConfigDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.AssemblesDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.BridgeElementPartDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.SendPurlinDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.building.ComponentCrderInformationDTO;
import com.hzchum.scim.plan.core.api.pojo.vo.ArtifactSimpleVO;
import com.hzchum.scim.plan.core.api.pojo.vo.BimBoxOrElementsVO;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import org.apache.ibatis.annotations.Param;

public interface TechAssembleMapper extends BaseMapper<TechAssemble> {
   List<AssembleDTO> selectListByConditions(
      @Param("areaId") Long areaId,
      @Param("areaBatchId") Long areaBatchId,
      @Param("serialNumber") String serialNumber,
      @Param("specification") String specification,
      @Param("material") String material,
      @Param("permissionCheck") Integer permissionCheck,
      @Param("userId") Long userId
   );

   List<String> selectAbnormalSerialNumber(@Param("areaId") Long areaId);

   List<Long> selectIdsByAreaId(@Param("areaId") Long areaId);

   TechAssemble selectByIdIgnoreDelete(Long id);

   TechAssemble selectOneByPrefix(@Param("assembleConfigId") Long assembleConfigId, @Param("specPrefix") String specPrefix);

   List<ComponentCrderInformationDTO> selectProjectGroupBySpec(Long projectId);

   List<AssemblesDTO> getAssembleList(
      @Param("classificationName") String classificationName, @Param("material") String material, @Param("projectId") Long projectId
   );

   TechAssemble listBySpecification(
      @Param("artifactId") Long artifactId, @Param("monomerId") Long monomerId, @Param("specification") String specification, @Param("areaId") Long areaId
   );

   List<TechAssemble> listByArtifactIds(@Param("ids") List<Long> ids, @Param("specification") String specification, @Param("length") BigDecimal length);

   List<AssembleNestingDTOParam> listAssembleNesting(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaIds") Set<Long> areaIds,
      @Param("productionLineTypeEnum") Integer productionLineTypeEnum,
      @Param("boolMainAssemble") Integer boolMainAssemble,
      @Param("specPrefix") String specPrefix,
      @Param("specification") String specification,
      @Param("material") String material,
      @Param("serialNumber") String serialNumber,
      @Param("boolLength") boolean boolLength,
      @Param("length") BigDecimal length,
      @Param("structureClassIds") List<Long> structureClassIds,
      @Param("boolHaveNC1") Integer boolHaveNC1
   );

   List<AssembleNestingDTOParam> listAssembleNoNesting(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaIds") Set<Long> areaIds,
      @Param("productionLineTypeEnum") Integer productionLineTypeEnum,
      @Param("specPrefix") String specPrefix,
      @Param("specification") String specification,
      @Param("material") String material,
      @Param("serialNumber") String serialNumber,
      @Param("length") BigDecimal length
   );

   List<AssembleStructureConfigDTOParam> listAssembleAndStructureClassIdConfig(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaIds") Set<Long> areaIds,
      @Param("structureClassIds") Set<Long> structureClassIds,
      @Param("productionLineTypeEnum") Integer productionLineTypeEnum
   );

   AssembleDTO assembleSourceProductList(Long productId);

   List<SendPurlinDTO> listAllByArtifactIds(@Param("ids") List<Long> ids);

   BigDecimal sumTnventoryTon(@Param("projectId") Long projectId);

   BimBoxOrElementsVO selectElementByBim(Long monomerId, List<Long> areaIds, String serialNumber);

   List<BridgeElementPartDTO> selectByArtifactId(Long artifactId);

   List<ArtifactSimpleVO> getAssemble(
      @Param("serialNumber") String serialNumber, @Param("projectId") Long projectId, @Param("monomerId") Long monomerId, @Param("areaId") Long areaId
   );
}
