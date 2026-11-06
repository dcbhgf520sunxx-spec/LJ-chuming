package com.hzchum.scim.plan.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo.dto.AssembleArtifactSaveDTOParam;
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

public interface TechAssembleService extends IService<TechAssemble> {
   void downloadTemplate();

   List<AssembleDTO> listByCondition(
      Long areaId, Long areaBatchId, String serialNumber, String specification, String material, Integer permissionCheck, Long userId
   );

   ListVO<String> listAbnormalAssemble(Long areaId);

   Boolean deleteAssembleById(Long id);

   Boolean deleteByIdList(List<Long> ids);

   Boolean insertAssembleArtifact(AssembleArtifactSaveDTOParam saveDTOParam);

   Boolean deleteAssembleArtifact(Long assembleId, String artifactNo);

   Boolean clearAssembles(Long areaId);

   AssembleDTO getAssembleById(Long id);

   TechAssemble getByIdIgnoreDelete(Long id);

   TechAssemble getOneByPrefix(Long assembleConfigId, String specPrefix);

   TechAssemble getOneBySerialNumber(String serialNumber);

   List<ComponentCrderInformationDTO> selectProjectGroupBySpec(Long projectId);

   List<AssemblesDTO> getAssembleList(String classificationName, String material, Long projectId);

   void updateBoolProcess(Boolean flag, Long assembleConfigId);

   TechAssemble listBySpecification(Long artifactId, Long monomerId, String specification, Long areaId);

   List<TechAssemble> listByArtifactIds(List<Long> idS, String specification, BigDecimal length);

   List<AssembleNestingDTOParam> listAssembleNesting(
      Long projectId,
      Long monomerId,
      Set<Long> areaIds,
      Integer productionLineTypeEnum,
      Integer boolMainAssemble,
      String specPrefix,
      String specification,
      String material,
      String serialNumber,
      boolean boolLength,
      BigDecimal length,
      List<Long> structureClassIds,
      Integer boolHaveNC1
   );

   List<AssembleNestingDTOParam> listAssembleNoNesting(
      Long projectId,
      Long monomerId,
      Set<Long> areaIds,
      Integer productionLineTypeEnum,
      String specPrefix,
      String specification,
      String material,
      String serialNumber,
      BigDecimal length
   );

   List<AssembleStructureConfigDTOParam> listAssembleAndStructureClassIdConfig(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaIds") Set<Long> areaIds,
      @Param("structureClassIds") Set<Long> structureClassIds,
      @Param("productionLineTypeEnum") Integer productionLineTypeEnum
   );

   AssembleDTO assembleSourceProductList(Long productId, Integer productType, Long taskId, Integer number);

   List assembleSourceReportProductList(Long productId, Integer number, Long taskId);

   List<SendPurlinDTO> listAllByArtifactIds(List<Long> ids);

   BigDecimal sumTnventoryTon(Long projectId);

   BimBoxOrElementsVO selectElementByBim(Long monomerId, List<Long> areaIds, String serialNumber);

   List<BridgeElementPartDTO> listMachinePartByArtifact(Long id);

   List<ArtifactSimpleVO> getAssemble(String serialNumber, Long projectId, Long monomerId, Long areaId);
}
