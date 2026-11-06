package com.hzchum.scim.plan.core.api.biz.check;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.plan.core.api.pojo.dto.check.InventoryFixUpRecordDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.check.MesTechInventoryOperationDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.check.MesTechInventoryOperationDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.check.TechArtifactRecordDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.check.TechAssembleMachinePartRecordDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.check.TechEnclosureRecordDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.check.TechMachinePartRecordDTO;
import com.hzchum.scim.plan.core.api.pojo.vo.TechAssemblyAutomaticCombinationVO;
import com.hzchum.scim.plan.core.api.pojo.vo.TechUnitRecordBaseVO;
import com.hzchum.scim.plan.core.api.pojo.vo.TechUnitRecordVO;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.web.multipart.MultipartFile;

public interface MesTechInventoryOperationBiz {
   void importInventory(
      MultipartFile file,
      Long monomerId,
      Long areaId,
      Integer importType,
      Integer inventoryTypeEnum,
      String remark,
      String areaBatchName,
      HttpServletResponse response
   );

   MesTechInventoryOperationDTO getInventoryStatusByArea(Long areaBatchId);

   InventoryFixUpRecordDTO getRepetitionInventoryList(
      Long inventoryId,
      String serialNumber,
      String specification,
      String material,
      Long maxLength,
      Long minLength,
      Boolean boolCombination,
      Long structureClassId
   );

   List<TechMachinePartRecordDTO> getRepetitionInventoryMachineList(Long artifactId);

   TechAssembleMachinePartRecordDTO getRepetitionInventoryMachineListTwo(Long artifactId);

   List<String> getMachineSpecification(Long artifactId);

   PageVO<MesTechInventoryOperationDTO> getInventoryList(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      String projectName,
      String createUserName,
      String reviewedName,
      Integer buildingType,
      Integer inventoryReviewedEnum,
      Integer pageNumber,
      Integer pageSize
   );

   PageVO<TechArtifactRecordDTO> getInventoryDetailList(Long inventoryId, Integer pageNumber, Integer pageSize);

   void exportInventoryDetailList(Long inventoryId, HttpServletResponse response);

   void exportEnclosureInventoryDetailList(Long inventoryId, HttpServletResponse response);

   Boolean fixUpRecordInventory(@Valid MesTechInventoryOperationDTOParam dtoParam);

   Boolean partSave(@Valid TechUnitRecordBaseVO unitRecordBaseVO);

   Boolean partDelete(@Valid List<TechUnitRecordVO> techUnitRecordVOList);

   Boolean saveAutomaticCombinationAssemble(TechAssemblyAutomaticCombinationVO automaticCombinationVO);

   PageVO<TechEnclosureRecordDTO> getInventoryEnclosureDetailList(
      Long inventoryId, String dictionaryId, String serialNumber, Integer pageNumber, Integer pageSize
   );
}
