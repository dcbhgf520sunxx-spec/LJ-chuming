package com.hzchum.scim.plan.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.pojo.dto.MachinePartResponseDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.MachinePartResponseExportDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.MachinePartSimpleDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.MachinePartSummaryDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.MachinePartSummaryExportDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProductMeteDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.SendPurlinDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.TechMachinePartDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.building.ComponentCrderInformationDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.product.ProductMeteGroupDTO;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TechMachinePartMapper extends BaseMapper<TechMachinePart> {
   List<MachinePartSimpleDTO> listSimpleByMonomerId(@Param("monomerId") Long monomerId, @Param("serialNumber") String serialNumber);

   List<TechMachinePartDTO> listMachinePartByArtifactId(@Param("artifactId") Long artifactId, @Param("serialNumber") String serialNumber);

   List<TechMachinePartDTO> listMachinePartByArtifactIds(@Param("artifactIds") List<Long> artifactIds);

   List<MachinePartResponseDTO> selectListByCondition(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("areaBatchId") Long areaBatchId,
      @Param("status") Integer status,
      @Param("type") Integer type,
      @Param("serialNumber") String serialNumber,
      @Param("specification") String specification,
      @Param("material") String material,
      @Param("thick") String thick,
      @Param("steelPlateTypeEnum") Integer steelPlateTypeEnum
   );

   List<MachinePartResponseExportDTO> selectListByConditionExport(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("areaBatchId") Long areaBatchId,
      @Param("status") Integer status,
      @Param("type") Integer type,
      @Param("serialNumber") String serialNumber,
      @Param("specification") String specification,
      @Param("material") String material,
      @Param("thick") String thick,
      @Param("steelPlateTypeEnum") Integer steelPlateTypeEnum
   );

   ProductMeteDTO sumMeteByCondition(Long areaId);

   List<ProductMeteGroupDTO> sumMeteGroupByMonomerId(
      @Param("projectId") Long projectId, @Param("permissionCheck") Integer permissionCheck, @Param("userId") Long userId
   );

   List<ProductMeteGroupDTO> sumMeteGroupByAreaId(
      @Param("monomerId") Long monomerId, @Param("permissionCheck") Integer permissionCheck, @Param("userId") Long userId
   );

   TechMachinePart selectByIdIgnoreDelete(Long id);

   List<TechMachinePartDTO> selectByArtifactId(@Param("artifactId") Long artifactId);

   TechMachinePart selectOneByPrefix(@Param("steelId") Long steelId, @Param("specPrefix") String specPrefix);

   List<ComponentCrderInformationDTO> selectByProjectId(Long projectId);

   List<MachinePartSummaryDTO> selectSummary(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("areaBatchId") Long areaBatchId,
      @Param("steelPlateTypeEnum") Integer steelPlateTypeEnum,
      @Param("permissionCheck") Integer permissionCheck,
      @Param("userId") Long userId
   );

   List<MachinePartSummaryExportDTO> selectSummaryExport(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("areaBatchId") Long areaBatchId,
      @Param("steelPlateTypeEnum") Integer steelPlateTypeEnum
   );

   List<TechMachinePartDTO> selectAssembleByArtifactId(@Param("artifactId") Long artifactId);

   List<SendPurlinDTO> listAllByArtifactIds(@Param("artifactIds") List<Long> artifactIds);

   BigDecimal sumTnventoryTon(@Param("projectId") Long projectId);
}
