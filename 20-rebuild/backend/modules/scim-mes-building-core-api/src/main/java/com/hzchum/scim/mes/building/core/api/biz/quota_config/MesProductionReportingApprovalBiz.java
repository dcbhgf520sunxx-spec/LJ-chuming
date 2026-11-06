package com.hzchum.scim.mes.building.core.api.biz.quota_config;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesProductionReportingApprovalDateDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesProductionReportingApprovalReportSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesProductionReportingApprovalTeamReportSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesProductionReportingApprovalPassedParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesProductionReportingApprovalQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesProductionReportingApprovedParam;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public interface MesProductionReportingApprovalBiz {
   List<MesProductionReportingApprovalDateDTO> dateExistsUnapprovedDataList(MesProductionReportingApprovalQuery query);

   List<MesProductionReportingApprovalDateDTO> dateExistsApprovedDataList(MesProductionReportingApprovalQuery query);

   List<MesProductionReportingApprovalTeamReportSummaryDTO> teamReportSummaryList(MesProductionReportingApprovalQuery query);

   List<MesProductionReportingApprovalTeamReportSummaryDTO> teamReportApprovedSummaryList(MesProductionReportingApprovalQuery query);

   PageVO<MesProductionReportingApprovalReportSummaryDTO> unapprovedPage(
      MesProductionReportingApprovalQuery query, Integer pageNumber, Integer pageSize, List<String> sort
   );

   PageVO<MesProductionReportingApprovalReportSummaryDTO> approvedPage(
      MesProductionReportingApprovalQuery query, Integer pageNumber, Integer pageSize, List<String> sort
   );

   Boolean approvalPassed(MesProductionReportingApprovalPassedParam param);

   Boolean batchApprovalPassed(List<MesProductionReportingApprovalPassedParam> paramList);

   Boolean approvedEdit(MesProductionReportingApprovedParam param);

   void approvedRecordExport(MesProductionReportingApprovalQuery query, HttpServletResponse response);
}
