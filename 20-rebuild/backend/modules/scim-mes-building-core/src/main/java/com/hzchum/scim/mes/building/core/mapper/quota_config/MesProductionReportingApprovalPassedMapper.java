package com.hzchum.scim.mes.building.core.mapper.quota_config;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesProductionReportingApprovalPassed;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesProductionReportingApprovalDateDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesProductionReportingApprovalPassedDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesProductionReportingApprovalReportSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesProductionReportingApprovalTeamReportSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesTeamSalaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesTeamSalaryTeamProductionDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesProductionReportingApprovalPassedQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesProductionReportingApprovalQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesTeamSalaryQuery;
import java.time.LocalDate;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesProductionReportingApprovalPassedMapper extends BaseMapper<MesProductionReportingApprovalPassed> {
   List<MesProductionReportingApprovalDateDTO> dateExistsUnapprovedDataList(MesProductionReportingApprovalQuery query);

   List<MesProductionReportingApprovalDateDTO> dateExistsApprovedDataList(MesProductionReportingApprovalQuery query);

   List<MesProductionReportingApprovalTeamReportSummaryDTO> teamReportSummaryList(MesProductionReportingApprovalQuery query);

   List<MesProductionReportingApprovalTeamReportSummaryDTO> teamReportApprovedSummaryList(MesProductionReportingApprovalQuery query);

   List<MesProductionReportingApprovalReportSummaryDTO> unapprovedList(MesProductionReportingApprovalQuery query);

   List<MesProductionReportingApprovalReportSummaryDTO> unapprovedEnclosureList(MesProductionReportingApprovalQuery query);

   List<MesProductionReportingApprovalReportSummaryDTO> approvedList(MesProductionReportingApprovalQuery query);

   List<MesTeamSalaryDTO> teamSalaryList(MesTeamSalaryQuery query);

   List<MesTeamSalaryDTO> teamSalaryEnclosureList(MesTeamSalaryQuery query);

   List<MesTeamSalaryTeamProductionDTO> teamProductionList(MesTeamSalaryQuery query);

   List<MesProductionReportingApprovalPassedDTO> listInfo(MesProductionReportingApprovalPassedQuery query);

   List<MesProductionReportingApprovalReportSummaryDTO> whitelistUnapprovedList(
      @Param("productTypeEnum") Integer productTypeEnum,
      @Param("workshopIdList") List<Long> workshopIdList,
      @Param("processIdList") List<Long> processIdList,
      @Param("teamIdList") List<Long> teamIdList,
      @Param("date") LocalDate date
   );

   List<MesProductionReportingApprovalReportSummaryDTO> whitelistUnapprovedEnclosureList(
      @Param("workshopIdList") List<Long> workshopIdList,
      @Param("processIdList") List<Long> processIdList,
      @Param("teamIdList") List<Long> teamIdList,
      @Param("date") LocalDate date
   );
}
