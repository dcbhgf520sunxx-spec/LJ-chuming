package com.hzchum.scim.project.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectAppInstallReportGroupDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectInstallBoardDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectInstallReportDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectInstallReportGroupDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectInstallSummaryDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectManageModeTaskDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectSupplierInstallSummaryDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.InstallBoardQueryDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.InstallReportQueryDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.InstallStatementQueryDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.AppCheckInstallReportDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.CheckInstallReportDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectInstallReportSaveDTOParam;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface ProjectInstallBiz {
   Boolean saveInstallReport(ProjectInstallReportSaveDTOParam param);

   Boolean saveInstallReportV2(ProjectInstallReportSaveDTOParam param);

   Boolean saveAppInstallReport(ProjectInstallReportSaveDTOParam param);

   Boolean saveAppInstallReportV2(ProjectInstallReportSaveDTOParam param);

   List<ProjectInstallReportGroupDTO> listInstallReportGroup(Long projectId, Integer productType, String yearMonth);

   PageVO<ProjectInstallReportDTO> pageListInstallReport(InstallReportQueryDTOParam param, Integer pageNumber, Integer pageSize);

   PageVO<ProjectInstallReportDTO> pageListInstallReportV2(InstallReportQueryDTOParam param, Integer pageNumber, Integer pageSize);

   List<ProjectInstallReportDTO> listInstallReport(InstallReportQueryDTOParam param);

   List<ProjectAppInstallReportGroupDTO> listAppInstallReportGroup(Long projectId, Integer productType);

   Boolean checkInstallReport(List<CheckInstallReportDTOParam> paramList);

   Boolean checkInstallReportV2(List<CheckInstallReportDTOParam> paramList, Long projectId);

   Boolean checkAppReport(List<AppCheckInstallReportDTOParam> paramList);

   Boolean checkAppReportV2(List<AppCheckInstallReportDTOParam> paramList, Long projectId);

   PageVO<ProjectInstallSummaryDTO> pageListInstallStatement(InstallStatementQueryDTOParam param, Integer pageNumber, Integer pageSize);

   PrintVO<List<Map<String, Object>>> printListInstallStatement(InstallStatementQueryDTOParam param);

   PageVO<ProjectInstallBoardDTO> listInstallBoard(InstallBoardQueryDTOParam param, Integer pageNumber, Integer pageSize);

   PageVO<ProjectInstallBoardDTO> listInstallBoardV2(InstallBoardQueryDTOParam param, Integer pageNumber, Integer pageSize);

   PageVO<ProjectInstallReportDTO> installBoardDetails(Integer productType, Long productId, Integer pageNumber, Integer pageSize);

   List<ProjectSupplierInstallSummaryDTO> getSupplierInstallSummary(Long projectId);

   PageVO<ProjectInstallReportDTO> getSupplierInstallDetails(
      Long projectId, Long supplierId, Integer productType, LocalDate startDate, LocalDate endDate, Integer pageNumber, Integer pageSize
   );

   PrintVO<List<Map<String, Object>>> getSupplierInstallDetailsPrint(
      Long projectId, Long supplierId, Integer productType, LocalDate startDate, LocalDate endDate
   );

   ProjectSupplierInstallSummaryDTO getProjectInstallSummary(Long projectId, Integer productType);

   PageVO<ProjectInstallReportDTO> getProjectInstallDetails(
      Long projectId, Integer productType, LocalDate startDate, LocalDate endDate, Integer pageNumber, Integer pageSize
   );

   PrintVO<List<Map<String, Object>>> getProjectInstallDetailsPrint(Long projectId, Integer productType, LocalDate startDate, LocalDate endDate);

   PageVO<ProjectInstallReportDTO> getUserInstallDetails(
      Integer productType, Boolean isMe, LocalDate startDate, LocalDate endDate, Integer pageNumber, Integer pageSize
   );

   List<ProjectManageModeTaskDTO> getUserTaskQuantity();
}
