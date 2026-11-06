package com.hzchum.scim.mes.building.core.api.service.quota_config;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesProductionReportingApprovalPassed;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesProductionReportingApprovalDateDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesProductionReportingApprovalPassedDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesProductionReportingApprovalReportSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesProductionReportingApprovalTeamReportSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesTeamSalaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesTeamSalaryTeamProductionDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesProductionReportingApprovalPassedParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesProductionReportingApprovalPassedQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesProductionReportingApprovalQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesTeamSalaryQuery;
import java.time.LocalDate;
import java.util.List;

public interface MesProductionReportingApprovalPassedService extends IService<MesProductionReportingApprovalPassed> {
   List<MesProductionReportingApprovalDateDTO> dateExistsUnapprovedDataList(MesProductionReportingApprovalQuery query);

   List<MesProductionReportingApprovalDateDTO> dateExistsApprovedDataList(MesProductionReportingApprovalQuery query);

   List<MesProductionReportingApprovalTeamReportSummaryDTO> teamReportSummaryList(MesProductionReportingApprovalQuery query);

   List<MesProductionReportingApprovalTeamReportSummaryDTO> teamReportApprovedSummaryList(MesProductionReportingApprovalQuery query);

   List<MesProductionReportingApprovalReportSummaryDTO> unapprovedList(MesProductionReportingApprovalQuery query);

   List<MesProductionReportingApprovalReportSummaryDTO> approvedList(MesProductionReportingApprovalQuery query);

   Boolean add(MesProductionReportingApprovalPassedParam param);

   Boolean batchAdd(List<MesProductionReportingApprovalPassedParam> paramList);

   List<MesTeamSalaryDTO> teamSalaryList(MesTeamSalaryQuery query);

   List<MesTeamSalaryTeamProductionDTO> teamProductionList(MesTeamSalaryQuery query);

   List<MesProductionReportingApprovalPassedDTO> listInfo(MesProductionReportingApprovalPassedQuery query);

   List<MesProductionReportingApprovalReportSummaryDTO> whitelistUnapprovedList(
      Integer productTypeEnum, List<Long> workshopIdList, List<Long> processIdList, List<Long> teamIdList, LocalDate date
   );

   List<MesProductionReportingApprovalReportSummaryDTO> whitelistUnapprovedEnclosureList(
      List<Long> workshopIdList, List<Long> processIdList, List<Long> teamIdList, LocalDate date
   );
}
