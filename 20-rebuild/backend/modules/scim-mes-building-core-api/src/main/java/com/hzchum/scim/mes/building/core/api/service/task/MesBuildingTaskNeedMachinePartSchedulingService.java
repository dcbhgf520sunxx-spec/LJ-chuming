package com.hzchum.scim.mes.building.core.api.service.task;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordFlowDTO;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.MesBuildingTaskNeedMachinePartSchedulingDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.WorkshopDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingBoChuNestingResult;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNeedMachinePartScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._dto.nesting.MachinePartNestingProductInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.nesting.NestPdfDataDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.nesting.NestingQuantityDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.nesting.WorkTreeDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.nesting.WorkshopTeamDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.ApprovePartRecordDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MachinePartNestingDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MachinePartNestingTeamDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingBoChuJobDirectoryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingBoChuNestingResultNewDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.APPAutoCutSchedulingDetail;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MachinePartNestingCutJobParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MachinePartNestingCutJobUpdateParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MachinePartNestingCutParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MachinePartNestingProductDetailDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MachinePartNestingTeamDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingMachinePartNestingExportParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingMachinePartNestingParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingMachinePartSchedulingDTOParam;
import com.hzchum.scim.system.core.api.pojo.dto.steel.SteelClassificationDTO;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public interface MesBuildingTaskNeedMachinePartSchedulingService extends IService<MesBuildingTaskNeedMachinePartScheduling> {
   List<MesBuildingTaskNeedMachinePartSchedulingDO> getNeedDetailByIds(List<Long> ids);

   List<WorkshopDetailDO> getWorkShopList(MachinePartNestingTeamDTOParam param);

   List<ProjectInfo> getProjectList(MachinePartNestingTeamDTOParam param);

   List<MachinePartNestingTeamDTO> getTeamList(MachinePartNestingTeamDTOParam param);

   PageVO<MachinePartNestingDetailDTO> getNeedMachinePartDetailList(MachinePartNestingProductDetailDTOParam param, Integer pageNumber, Integer pageSize);

   List<String> getThickList(MachinePartNestingProductDetailDTOParam param);

   List<String> getMaterialList(MachinePartNestingProductDetailDTOParam param);

   List<SteelClassificationDTO> getPartTypeList(MachinePartNestingProductDetailDTOParam param);

   String sendToNestingTwo(MesBuildingMachinePartNestingParam mesBuildingMachinePartNestingParam, HttpServletResponse response);

   void sendToNestingV3(MesBuildingMachinePartNestingParam param, HttpServletResponse response);

   void sendToNestingModeTwo(MesBuildingMachinePartNestingParam param, HttpServletResponse response);

   List<MesBuildingBoChuJobDirectoryDTO> getWorkTree(WorkTreeDTO workTreeDTO);

   List<MesBuildingBoChuNestingResult> getWorkMachinePartListFromNesting(Integer jobId, Integer cutStatus, Integer cutSendStatus);

   List<MesBuildingBoChuNestingResultNewDTO> getWorkMachinePartListFromNestingLocal(
      Integer jobId, Integer cutStatus, Integer cutSendStatus, String material, BigDecimal thickness
   ) throws UnsupportedEncodingException;

   Boolean exportMachinePartListFromNesting(MesBuildingMachinePartNestingExportParam mesBuildingMachinePartNestingExportParam, HttpServletResponse response);

   void exportMachinePartList(MachinePartNestingProductDetailDTOParam param, HttpServletResponse response);

   void setMachineTool(MachinePartNestingCutJobParam machinePartNestingCutJobParam);

   List<MesBuildingTaskNeedMachinePartScheduling> saveMachinePartNestingCut(MachinePartNestingCutParam machinePartNestingCutParam);

   Boolean updateMachinePartNestingCutJob(MachinePartNestingCutJobUpdateParam machinePartNestingCutJobUpdateParam);

   void downloadPdf(HttpServletResponse response, String resultId, Long machineToolId);

   NestPdfDataDTO getNestPdfData(String resultId, Long machineToolId) throws IOException;

   List<MachinePartNestingProductInfoDTO> getJobInfoByJobId(Integer jobId);

   List<WorkshopTeamDTO> getJobWorkShopInfo();

   NestingQuantityDTO getJobMaterial(Integer jobId);

   String deleteMachinePartNestingJob(Integer jobId);

   String deleteMachinePartNestingJobList(MesBuildingMachinePartNestingExportParam mesBuildingMachinePartNestingExportParam);

   String updateMachinePartNestingJobStatus(String wsJson);

   String updateMachinePartNestingJobStatusV2(String wsJson);

   Long saveMachinePartDirectScheduling(MesBuildingMachinePartSchedulingDTOParam mesBuildingMachinePartSchedulingDTOParam);

   WmsApproveRecord createPartApprovalRecord(Long schedulingId, String orderNumber);

   WmsApproveRecord createAutoPartApprovalRecord(List<APPAutoCutSchedulingDetail> appAutoCutSchedulingDetailList);

   Boolean approvePart(Long id, Integer decision, String serialNumber);

   Boolean approveAutoCut(Long wmsApproveRecordId);

   PageVO<ApprovePartRecordDTO> approvePartList(Integer type, Integer status, Integer pageNumber, Integer pageSize);

   WmsApproveRecordFlowDTO approvePartDetail(Long id);

   Boolean manuallyProcessingMachinePartIssuedToNestingSoftwareAbnormalData(List<Long> taskOrderIdList);
}
