package com.hzchum.scim.plan.core.api.manager;

import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactSpecAmend;
import com.hzchum.scim.plan.core.api.pojo._do.check.TechArtifactMachinePartLinkRecord;
import com.hzchum.scim.plan.core.api.pojo._do.check.TechMachinePartRecord;
import com.hzchum.scim.plan.core.api.pojo.dto.MistakeExportDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.manager.TechAreaProductInfoDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.manager.TechConfigUtilsDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.manager.TechMonomerDrawInfoDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.ArtifactBoxImportDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.InventoryArtifactBoxDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.InventoryAssembleImportDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.InventoryStandardPartDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.MachinePartImportDtoParam;
import com.hzchum.scim.plan.core.api.pojo.vo.TechAssemblyAutomaticCombinationVO;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

public interface TechUtilManager {
   TechConfigUtilsDTO getTechConfigUtilsDto(Integer inventoryTypeEnum);

   TechAreaProductInfoDTO getAreaProductInfo(Long areaBachId);

   TechMonomerDrawInfoDTO getMonomerDrawInfo(Long monomerId);

   List<InventoryArtifactBoxDTO> getInventoryList(Long inventoryId);

   List<InventoryStandardPartDTO> getInventoryStandardPartList(Long inventoryId);

   List<MachinePartImportDtoParam> getComponentSplitWingWebV2(
      Map<String, Map<String, Long>> steelClassSpecNameLinkMap, String specPrefix, InventoryAssembleImportDTO assembleImportDtoParam
   );

   void buildAssemblePartLinks(
      List<TechArtifactMachinePartLinkRecord> artifactMachinePartLinkList,
      List<TechMachinePartRecord> newMachinePartList,
      List<TechArtifactSpecAmend> specAmendList,
      TechAssemblyAutomaticCombinationVO automaticCombinationVO
   );

   List<ArtifactBoxImportDTO> getArtifactBoxImportDTOS(
      MultipartFile file,
      Integer inventoryTypeEnum,
      HttpServletResponse response,
      List<MistakeExportDTO> mistakeExportDTOList,
      TechConfigUtilsDTO utilsDTO,
      Long monomerId,
      Integer importType
   );
}
