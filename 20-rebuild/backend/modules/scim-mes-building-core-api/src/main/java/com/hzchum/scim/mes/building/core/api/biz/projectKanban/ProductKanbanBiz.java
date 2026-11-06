package com.hzchum.scim.mes.building.core.api.biz.projectKanban;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.product.MesBuildingAreaProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.product.MesBuildingProjectProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ArtifactAssembleMatchingDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ArtifactDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ArtifactFormDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ArtifactKanbanDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ArtifactSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.AssembleDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.AssembleMatchingDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.EnclosureDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.EnclosureFormDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.FormSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.KanBanMachinePartSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.MachinePartDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ProductKanBanDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ProductKanBanInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.projectKanban.FormDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.projectKanban.FormSummaryDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.projectKanban.ProductKanbanDTOParam;
import java.util.List;
import java.util.Map;

public interface ProductKanbanBiz {
   List<KanBanMachinePartSummaryDTO> machinePartSteelSpec(ProductKanbanDTOParam dtoParam);

   List<ProductKanBanDTO> productKanban(ProductKanbanDTOParam dtoParam);

   PageVO<ProductKanBanDTO> productKanbanPage(ProductKanbanDTOParam dtoParam, Integer pageNumber, Integer pageSize);

   ArtifactDetailDTO artifactDetail(Long id);

   EnclosureDetailDTO enclosureDetail(Long id);

   AssembleDetailDTO assembleDetail(Long id);

   MachinePartDTO machinePartDetail(Long id);

   List<ArtifactFormDTO> projectArtifactForm(FormDTOParam dtoParam);

   PageVO<ArtifactFormDTO> projectArtifactFormPage(FormDTOParam dtoParam, Integer pageNumber, Integer pageSize);

   PrintVO<List<Map<String, Object>>> projectArtifactFormPrint(FormDTOParam param);

   List<EnclosureFormDTO> projectEnclosureForm(FormDTOParam dtoParam);

   PageVO<EnclosureFormDTO> projectEnclosureFormPage(FormDTOParam dtoParam, Integer pageNumber, Integer pageSize);

   PrintVO<List<Map<String, Object>>> projectEnclosureFormPrint(FormDTOParam param);

   List<ArtifactAssembleMatchingDTO> artifactAssembleMatchingList(ProductKanbanDTOParam dtoParam);

   PageVO<ArtifactAssembleMatchingDTO> artifactAssembleMatchingPage(ProductKanbanDTOParam dtoParam, Integer pageNumber, Integer pageSize);

   List<AssembleMatchingDTO> machinePartList(List<Long> ids);

   List<ProductKanBanInfoDTO> machinePartListV2(List<Long> ids, Integer taskTypeEnum);

   PrintVO<List<Map<String, Object>>> machinePartListPrint(List<Long> ids);

   List<FormSummaryDTO> formSummary(FormSummaryDTOParam dtoParam);

   List<ArtifactAssembleMatchingDTO> areaProductList(Long projectId, Long monomerId, Long areaId);

   PageVO<ArtifactAssembleMatchingDTO> areaProductListPage(Long projectId, Long monomerId, Long areaId, Integer pageNumber, Integer pageSize);

   PrintVO<List<Map<String, Object>>> areaProductListPrint(Long projectId, Long monomerId, Long areaId);

   List<ArtifactSummaryDTO> areaArtifactSummary(Long projectId, Long monomerId, Long areaId);

   PageVO<ProductKanBanDTO> appProductDetails(
      Long projectId, Long monomerId, Long areaId, Integer productType, String serialNumber, Integer pageNumber, Integer pageSize, Integer status
   );

   List<MesBuildingAreaProductDTO> monomerDetails(Long projectId, Long monomerId, Integer productType);

   MesBuildingProjectProductDTO projectDetails(Long projectId, Long monomerId, Long areaId);

   ArtifactKanbanDetailDTO getArtifactKanbanInfo(Long productId);
}
