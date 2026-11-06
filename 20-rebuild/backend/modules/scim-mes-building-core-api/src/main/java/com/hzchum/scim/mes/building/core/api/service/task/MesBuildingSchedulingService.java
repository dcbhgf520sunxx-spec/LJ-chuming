package com.hzchum.scim.mes.building.core.api.service.task;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.MesBuildingArtifactSchedulingSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.MesBuildingAssembleSchedulingSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.MesBuildingEnclosureSchedulingSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.MesBuildingMachinePartSchedulingSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.MesBuildingSchedulingDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.MesBuildingSchedulingSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.task.MesBuildingSchedulingDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.task.SchedulingSummaryDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.task.get.SchedulingDetailListDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.product.MesBuildingArtifactDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.product.MesBuildingAssembleDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.product.MesBuildingEnclosureDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.product.MesBuildingMachinePartDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.product.MesBuildingMachinePartSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.SchedulingDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.product.MachinePartSummartDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.product.MesBuildingArtifactDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.product.MesBuildingAssembleDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.product.MesBuildingEnclosureDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.product.MesBuildingMachinePartDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task.MesBuildingSchedulingClearDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task.MesBuildingSchedulingDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.building.ProductLineSummary;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

public interface MesBuildingSchedulingService extends IService<MesBuildingScheduling> {
   List<MesBuildingSchedulingDO> listByCondition(SchedulingDetailListDOParam dtoParam);

   MesBuildingSchedulingDO listById(Long id, Integer productType);

   PageVO<MesBuildingSchedulingDO> pageByCondition(SchedulingDetailListDOParam dtoParam, String sort, Integer pageNumber, Integer pageSize);

   PrintVO<List<Map<String, Object>>> printByCondition(SchedulingDetailListDOParam copy);

   List<MesBuildingAssembleSchedulingSummaryDO> getAssembleSchedulingGroupByDay(SchedulingSummaryDOParam doParam);

   List<MesBuildingArtifactSchedulingSummaryDO> getArtifactSchedulingGroupByDay(SchedulingSummaryDOParam doParam);

   List<MesBuildingEnclosureSchedulingSummaryDO> getEnclosureSchedulingGroupByDay(SchedulingSummaryDOParam doParam);

   List<MesBuildingMachinePartSchedulingSummaryDO> getMachinePartSchedulingGroupByDay(SchedulingSummaryDOParam doParam);

   Boolean updateSchedulingQuantity(MesBuildingSchedulingDTOParam dtoParam);

   Boolean clearSchedulingQuantity(MesBuildingSchedulingClearDTOParam dtoParam);

   MesBuildingSchedulingSummaryDO selectSummary(MesBuildingSchedulingDOParam build);

   SchedulingDetailDTO getSchedulingDetailByProductIdAndProductType(Long productId, Integer productType, Long assembleId);

   Boolean checkStatus(Long productionLine);

   List<MesBuildingArtifactDTO> listSchedulingArtifactByCondition(MesBuildingArtifactDTOParam copy);

   PageVO listSchedulingArtifactByConditionPage(MesBuildingArtifactDTOParam copy, String sort, Integer pageNumber, Integer pageSize);

   List<MesBuildingAssembleDTO> listSchedulingAssembleByCondition(MesBuildingAssembleDTOParam copy);

   PageVO<MesBuildingAssembleDTO> listSchedulingAssembleByConditionPage(MesBuildingAssembleDTOParam copy, String sort, Integer pageNumber, Integer pageSize);

   List<MesBuildingEnclosureDTO> listSchedulingEnclosureByCondition(MesBuildingEnclosureDTOParam copy);

   PageVO<MesBuildingEnclosureDTO> listSchedulingEnclosureByConditionPage(MesBuildingEnclosureDTOParam copy, String sort, Integer pageNumber, Integer pageSize);

   List<MesBuildingMachinePartDTO> listSchedulingMachinePartByCondition(MesBuildingMachinePartDTOParam copy);

   PageVO<MesBuildingMachinePartDTO> listSchedulingMachinePartByConditionPage(
      MesBuildingMachinePartDTOParam copy, String sort, Integer pageNumber, Integer pageSize
   );

   PageVO<MesBuildingMachinePartSummaryDTO> schedulingSummaryMachinePartByConditionPage(
      MachinePartSummartDTOParam copy, String sort, Integer pageNumber, Integer pageSize
   );

   List<MesBuildingMachinePartSummaryDTO> schedulingSummaryMachinePartByConditionList(MachinePartSummartDTOParam copy);

   MesBuildingScheduling getScheduling(LocalDateTime today, LocalDateTime askTime, Long productId, Integer productType, Long productionLineId);

   int getTotalScheduling(Long productId);

   List<NameInfo> getProductLine(Integer productType);

   void exportArtifactPartTemplate(HttpServletResponse response, Long areaId, Integer productType, Integer statusType);

   Boolean importArtifact(MultipartFile file, Long areaId, Integer productType);

   ProductLineSummary selectSummaryData(Long lineId, Long projectId);
}
