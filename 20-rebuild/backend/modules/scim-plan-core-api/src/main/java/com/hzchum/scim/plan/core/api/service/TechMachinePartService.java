package com.hzchum.scim.plan.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.pojo.dto.MachinePartResponseDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.MachinePartResponseExportDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.MachinePartSimpleDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.MachinePartSummaryDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.MachinePartsDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProductMeteDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.SendPurlinDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.TechMachinePartDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.building.ComponentCrderInformationDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.product.ProductMeteGroupDTO;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public interface TechMachinePartService extends IService<TechMachinePart> {
   List<MachinePartResponseDTO> listByCondition(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Integer status,
      Integer type,
      String serialNumber,
      String specification,
      String material,
      String thick,
      Integer steelPlateTypeEnum
   );

   List<MachinePartResponseExportDTO> listByConditionExport(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Integer status,
      Integer type,
      String serialNumber,
      String specification,
      String material,
      String thick,
      Integer steelPlateTypeEnum
   );

   List<TechMachinePartDTO> listMachinePartByArtifact(Long artifactId);

   ProductMeteDTO sumMeteByCondition(Long areaId);

   List<ProductMeteGroupDTO> sumMeteGroup(Long projectId, Long monomerId, Integer permissionCheck, Long userId);

   List<TechMachinePart> listBySteelId(Long steelId);

   List<TechMachinePartDTO> listByArtifactId(Long artifactId);

   List<TechMachinePartDTO> listByArtifactIds(List<Long> artifactIds);

   List<MachinePartSimpleDTO> listSimpleByMonomerId(Long monomerId, String serialNumber);

   TechMachinePart getByIdIgnoreDelete(Long id);

   TechMachinePart getOneByPrefix(Long steelId, String specPrefix);

   TechMachinePart getOneBySerialNumber(String serialNumber);

   List<ComponentCrderInformationDTO> selectByProjectId(Long projectId);

   List<MachinePartsDTO> getMachinePartList(String classificationName, String material, String specification, Boolean boolHaveHole, Long projectId);

   void updateBoolProcess(Boolean flag, Long steelId);

   List<MachinePartSummaryDTO> listSummary(Long projectId, Long monomerId, Long areaId, Long areaBatchId, Integer steelPlateTypeEnum, Integer permissionCheck);

   void listSummaryExport(Long projectId, Long monomerId, Long areaId, Long areaBatchId, Integer steelPlateTypeEnum, HttpServletResponse response);

   List<TechMachinePartDTO> listSpacerByCondition(String serialNumber, String specification, String thick, String material);

   ListVO<TechMachinePartDTO> appListMachinePart(Long artifactId);

   List<TechMachinePart> listByBusinessId(Long businessId);

   List<SendPurlinDTO> listAllByArtifactIds(List<Long> collect);

   BigDecimal sumTnventoryTon(Long projectId);
}
