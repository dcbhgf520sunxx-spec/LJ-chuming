package com.hzchum.scim.mes.building.core.api.biz.qhse;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.ArtifactQhseSpotCheckDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.LastSendPersonDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.MesBuildingQhseDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.MesBuildingQhseDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.MesBuildingSpotStatisticsCountDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.MesBuildingSpotStatisticsCountDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.QhseSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.qhse.MesBuildingCheckQhseDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.qhse.MesBuildingQhseDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.qhse.MesBuildingQhseRectifyDTOParam;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.transaction.annotation.Transactional;

public interface MesBuildingQhseBiz {
   boolean saveQhse(MesBuildingQhseDTOParam dtoParam);

   boolean saveQhseRectify(MesBuildingQhseRectifyDTOParam dtoParam);

   @Transactional(rollbackFor = Exception.class)
   boolean saveQhseRectifyAV2(MesBuildingQhseRectifyDTOParam dtoParam);

   Boolean updateQhseStatus(Long id, Integer status);

   Boolean updateQhseRectify(MesBuildingQhseRectifyDTOParam copy);

   Boolean changeQhseRectify(MesBuildingQhseRectifyDTOParam copy);

   List<MesBuildingQhseDTO> qhseList(
      Long qhseId,
      Long projectId,
      String userName,
      String dutyName,
      String rectifyName,
      String serialNumber,
      Integer type,
      Integer status,
      Boolean boolApp,
      Long userId,
      LocalDateTime startDate,
      LocalDateTime endDate,
      LocalDateTime specifiedDate,
      List<Long> qhseIds,
      Long processId,
      Long levelOneType,
      Long levelTwoType
   );

   MesBuildingQhseDetailDTO qhseDetail(Long qhseId);

   PageVO anhuanExposure(LocalDateTime startDate, LocalDateTime endDate, Integer pageNumber, Integer pageSize);

   PageVO<MesBuildingQhseDTO> qhsePage(
      Long qhseId,
      Long projectId,
      String userName,
      String dutyName,
      String rectifyName,
      String serialNumber,
      Integer type,
      Integer status,
      Boolean boolApp,
      Long userId,
      String sort,
      Integer pageNumber,
      Integer pageSize,
      LocalDateTime startDate,
      LocalDateTime endDate,
      LocalDateTime specifiedDate,
      List<Long> qhseIds,
      Long processId,
      Long levelOneType,
      Long levelTwoType
   );

   MesBuildingQhseDTO getQhseById(Long id, Integer status, Long userId);

   MesBuildingQhseDTO getAcceptOnDeviationById(Long id, Integer status, Long userId);

   List<QhseSummaryDTO> qhseSummary(Long projectId);

   Boolean qhseDetailDownload(Long id, HttpServletResponse response);

   Boolean qhseDetailAllDownload(List<Long> id, HttpServletResponse response);

   List<LastSendPersonDTO> LastSendPerson();

   void exportQhseList(
      Long qhseId,
      Long projectId,
      String userName,
      String dutyName,
      String rectifyName,
      String serialNumber,
      Integer type,
      Integer status,
      Boolean boolApp,
      Long userId,
      String sort,
      Integer pageNumber,
      Integer pageSize,
      LocalDateTime startDate,
      LocalDateTime endDate,
      LocalDateTime specifiedDate,
      List<Long> qhseIds,
      Long processId,
      Long levelOneType,
      Long levelTwoType,
      HttpServletResponse response
   );

   void exportQhseStats(
      Long qhseId,
      Long projectId,
      String userName,
      String dutyName,
      String rectifyName,
      String serialNumber,
      Integer type,
      Integer status,
      Boolean boolApp,
      Long userId,
      String sort,
      Integer pageNumber,
      Integer pageSize,
      LocalDateTime startDate,
      LocalDateTime endDate,
      LocalDateTime specifiedDate,
      List<Long> qhseIds,
      Long processId,
      Long levelOneType,
      Long levelTwoType,
      HttpServletResponse response
   );

   ArtifactQhseSpotCheckDTO getArtifactByTaskId(Long taskId, Integer number);

   Boolean saveQhseSpotCheck(MesBuildingCheckQhseDTOParam mesBuildingQhseDTOParam);

   PageVO findSpotCheckListPage(Long projectId, String projectName, String userName, Integer pageNumber, Integer pageSize);

   List<MesBuildingSpotStatisticsCountDTO> findSpotCheckList(Long projectId, String projectName, String userName);

   PageVO findSpotCheckDetailListPage(
      Long projectId,
      Long monomerId,
      String userName,
      String monomerName,
      String name,
      String serialNumber,
      String specification,
      Integer pageNumber,
      Integer pageSize
   );

   List<MesBuildingSpotStatisticsCountDetailDTO> findSpotCheckDetailList(
      Long projectId, Long monomerId, String userName, String monomerName, String name, String serialNumber, String specification
   );

   void printFindSpotCheckList(Long projectId, String projectName, String userName, HttpServletResponse response);

   void printFindSpotCheckDetailList(
      Long projectId, Long monomerId, String userName, String monomerName, String name, String serialNumber, String specification, HttpServletResponse response
   );

   Boolean qhseSafetyEnvironmentDownload(Long id, HttpServletResponse response);

   Boolean qhseProblemStatisticsDownload(Long id, HttpServletResponse response);
}
