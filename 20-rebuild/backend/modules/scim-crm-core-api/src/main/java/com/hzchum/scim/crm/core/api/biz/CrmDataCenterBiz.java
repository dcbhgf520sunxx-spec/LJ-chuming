package com.hzchum.scim.crm.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmBusinessSummaryReportListDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmBusinessSummaryReportListDTOV2;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmNewProjectInformationDTO;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface CrmDataCenterBiz {
   PrintVO<List<Map<String, Object>>> businessSummaryReportPrint(LocalDateTime startDate, LocalDateTime endDate, String projectName, String informantUserName);

   PrintVO<List<Map<String, Object>>> newProjectInformationPrint(LocalDateTime startDate, LocalDateTime endDate, String projectName, String salesName);

   PrintVO<List<Map<String, Object>>> getInfoByInformantUserPrint(Long informantUserId);

   PageVO<CrmBusinessSummaryReportListDTO> businessSummaryReport(
      LocalDateTime startDate, LocalDateTime endDate, String informantUserName, Integer pageNumber, Integer pageSize
   );

   PageVO<CrmBusinessSummaryReportListDTO> getInfoByInformantUser(Long informantUserId, Integer pageNumber, Integer pageSize);

   PageVO<CrmNewProjectInformationDTO> newProjectInformation(
      LocalDateTime startDate, LocalDateTime endDate, String projectName, String salesName, Integer pageNumber, Integer pageSize
   );

   PageVO<CrmBusinessSummaryReportListDTOV2> businessSummaryReportCustom(
      LocalDateTime startDate, LocalDateTime endDate, String informantUserName, Integer pageNumber, Integer pageSize
   );

   PrintVO<List<Map<String, Object>>> businessSummaryReportPrintCustom(
      LocalDateTime startDate, LocalDateTime endDate, String projectName, String informantUserName
   );

   PrintVO<List<Map<String, Object>>> getInfoByInformantUserPrintCustom(Long informantUserId);

   PageVO<CrmBusinessSummaryReportListDTOV2> getInfoByInformantUserCustom(Long informantUserId, Integer pageNumber, Integer pageSize);
}
