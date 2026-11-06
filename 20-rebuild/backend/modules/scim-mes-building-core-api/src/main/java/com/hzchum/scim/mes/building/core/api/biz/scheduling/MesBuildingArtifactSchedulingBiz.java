package com.hzchum.scim.mes.building.core.api.biz.scheduling;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.MesBuildingAssembleTypeDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingArtifactScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.ArtifactSchedulingDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.ArtifactSchedulingDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.ArtifactSchedulingSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingArtifactSchedulingDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingArtifactSchedulingGroupSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingArtifactSchedulingSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingArtifactTypeDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingAssembleSchedulingDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.ProductMonitorByGroupDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.ProductMonitorKanbanByGroupDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.ProductMonitorKanbanBySummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.ProductMonitorKanbanDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.TeamScheduledSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingProductionTaskDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingArtifactSchedulingDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingAssembleSchedulingDTOParam;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

public interface MesBuildingArtifactSchedulingBiz extends IBiz<MesBuildingArtifactScheduling> {
   PageVO<MesBuildingArtifactSchedulingDTO> artifactByConditionList(MesBuildingArtifactSchedulingDTOParam dtoParam, Integer pageNumber, Integer pageSize);

   PageVO<MesBuildingArtifactSchedulingDTO> artifactByConditionPage(
      MesBuildingArtifactSchedulingDTOParam dtoParam, String sort, Integer pageNumber, Integer pageSize
   );

   MesBuildingArtifactSchedulingSummaryDTO artifactByConditionSummary(MesBuildingArtifactSchedulingDTOParam dtoParam);

   List<Integer> getProductionLineTypeList(MesBuildingArtifactSchedulingDTOParam copy);

   List<MesBuildingArtifactTypeDTO> getArtifactTypeList(MesBuildingArtifactSchedulingDTOParam copy);

   List<MesBuildingArtifactTypeDTO> getArtifactNameList(MesBuildingArtifactSchedulingDTOParam dtoParam);

   Boolean saveArtifactSchedulingList(List<MesBuildingArtifactSchedulingDTOParam> dtoParamList);

   @Transactional(rollbackFor = Exception.class)
   Boolean saveArtifactSchedulingList2(List<MesBuildingArtifactSchedulingDTOParam> dtoParamList);

   @Transactional(rollbackFor = Exception.class)
   Boolean saveArtifactSchedulingListV8(List<MesBuildingArtifactSchedulingDTOParam> dtoParamList);

   @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
   Boolean saveAssembleSchedulingListV8(List<MesBuildingAssembleSchedulingDTOParam> dtoParamList);

   List<MesBuildingArtifactSchedulingDTO> getArtifactSchedulingRecordList(MesBuildingArtifactSchedulingDTOParam dtoParam);

   List<MesBuildingArtifactSchedulingDTO> getArtifactSchedulingRecordList2(MesBuildingArtifactSchedulingDTOParam dtoParam);

   List<MesBuildingArtifactSchedulingDTO> getArtifactSchedulingRecordListV8(MesBuildingArtifactSchedulingDTOParam dtoParam);

   PageVO<MesBuildingArtifactSchedulingDTO> getArtifactSchedulingRecordPage(
      MesBuildingArtifactSchedulingDTOParam dtoParam, Integer pageNumber, Integer pageSize
   );

   MesBuildingArtifactSchedulingSummaryDTO getArtifactSchedulingRecordSummary(MesBuildingArtifactSchedulingDTOParam dtoParam);

   MesBuildingArtifactSchedulingSummaryDTO getArtifactSchedulingRecordSummary2(MesBuildingArtifactSchedulingDTOParam dtoParam);

   List<MesBuildingArtifactSchedulingGroupSummaryDTO> getGroupsRecordSummary(MesBuildingArtifactSchedulingDTOParam copy);

   List<MesBuildingArtifactTypeDTO> getArtifactRecordTypeList(MesBuildingArtifactSchedulingDTOParam dtoParam);

   List<MesBuildingArtifactTypeDTO> getArtifactRecordTypeListV8(MesBuildingArtifactSchedulingDTOParam dtoParam);

   List<MesBuildingAssembleTypeDO> getAssembleRecordTypeListV8(Long areaId);

   List<MesBuildingArtifactTypeDTO> getArtifactRecordNameList(MesBuildingArtifactSchedulingDTOParam dtoParam);

   List<Long> getRecordProductionLineTypeList(MesBuildingArtifactSchedulingDTOParam copy);

   List<Boolean> getArtifactRecordProductionTypeList(MesBuildingArtifactSchedulingDTOParam dtoParam);

   Boolean updateArtifactScheduling(List<MesBuildingArtifactSchedulingDTOParam> dtoParamList);

   Boolean updateArtifactScheduling2(List<MesBuildingArtifactSchedulingDTOParam> dtoParamList);

   Boolean deleteArtifactScheduling(List<MesBuildingArtifactSchedulingDTOParam> dtoParamList);

   Boolean deleteArtifactSchedulingV8(List<MesBuildingArtifactSchedulingDTOParam> dtoParamList);

   List<MesBuildingAssembleSchedulingDTO> getArtifactSchedulingAssemble(List<MesBuildingArtifactSchedulingDTOParam> dtoParamList);

   List<MesBuildingAssembleSchedulingDTO> getArtifactSchedulingAssemble2(List<MesBuildingArtifactSchedulingDTOParam> dtoParamList);

   List<MesBuildingAssembleSchedulingDTO> getArtifactSchedulingAssembleV8(Long areaId);

   Map<String, List<String>> getArtifactSchedulingAssembleFilterCriteria(List<MesBuildingArtifactSchedulingDTOParam> dtoParamList);

   Integer getArtifactSchedulingRecordCount(List<Long> areaIdList);

   Integer getArtifactSchedulingRecordCount2(List<Long> areaIdList);

   Integer getArtifactSchedulingRecordCountV8(List<Long> areaIdList);

   PageVO<ProductMonitorKanbanDTO> getProductMonitorKanbanPage(
      Long workshopId, Integer status, String name, Integer projectType, Integer lumpSumSystemType, Integer pageNumber, Integer pageSize
   );

   List<ProductMonitorKanbanDTO> getProductMonitorKanbanList(Long workshopId, Integer status, String name, Integer projectType, Integer lumpSumSystemType);

   PageVO<MesBuildingProductionTaskDTO> getProductMonitorKanbanDetail(
      Long workshopId, Long projectId, Long monomerId, Long areaId, Integer pageNumber, Integer pageSize
   );

   List<ProductMonitorKanbanByGroupDTO> getProductMonitorKanbanByGroup(Long workshopId, Long processId, Integer taskTypeEnum);

   PageVO<ProductMonitorByGroupDetailDTO> getProductMonitorKanbanByGroupDetail(
      Long workshopId,
      Long productionLineId,
      Long groupId,
      Long teamId,
      Long processId,
      Integer taskTypeEnum,
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      Integer pageNumber,
      Integer pageSize
   );

   ProductMonitorKanbanBySummaryDTO getProductMonitorKanbanSummary(Long workshopId, Integer projectType, Integer lumpSumSystemType);

   PrintVO<List<Map<String, Object>>> getProductMonitorKanbanDetailPrint(Long workshopId, Long projectId, Long monomerId, Long areaId);

   PrintVO<List<Map<String, Object>>> getProductMonitorKanbanByGroupDetailPrint(
      Long workshopId,
      Long productionLineId,
      Long groupId,
      Long teamId,
      Long processId,
      Integer taskTypeEnum,
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber
   );

   void exportArtifactSchedulingTemplate(HttpServletResponse response, Long areaId, Integer productType, Long structureClassId);

   void exportArtifactSchedulingTemplateAV2(HttpServletResponse response, Long areaId, Integer productType, Long structureClassId, Integer mesProductEnum);

   Boolean importArtifactScheduling(MultipartFile file, Long areaId, Integer productType);

   @Transactional(rollbackFor = TransactionException.class)
   Boolean importArtifactSchedulingAV2(MultipartFile file, Long areaId, Integer productType) throws IOException;

   List<ArtifactSchedulingDTO> artifactSchedulingList(LocalDateTime dateTime, Long workshopId, Integer type, Integer projectType, Integer lumpSumSystemType);

   PageVO<ArtifactSchedulingDetailDTO> artifactSchedulingDetailPage(
      LocalDateTime dateTime, Long workshopId, Long projectId, Long monomerId, Long areaId, String serialNumber, Integer pageNumber, Integer pageSize
   );

   List<ArtifactSchedulingDetailDTO> artifactSchedulingDetailList(
      LocalDateTime dateTime, Long workshopId, Long projectId, Long monomerId, Long areaId, String serialNumber
   );

   ArtifactSchedulingSummaryDTO artifactSchedulingSummary(LocalDateTime dateTime, Long workshopId, Integer type, Integer projectType, Integer lumpSumSystemType);

   PrintVO<List<Map<String, Object>>> artifactSchedulingDetailPrint(
      LocalDateTime dateTime, Long workshopId, Long projectId, Long monomerId, Long areaId, String serialNumber
   );

   TeamScheduledSummaryDTO findTeamScheduledSummary(Long workshopId, Long projectId);
}
