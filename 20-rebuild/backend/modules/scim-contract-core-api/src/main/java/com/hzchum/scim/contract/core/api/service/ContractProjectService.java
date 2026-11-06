package com.hzchum.scim.contract.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.ProjectsTreeDTO;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractInvoiceCollectionDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractProjectLedgerDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractProjectListDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractProjectListForUserDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractProjectOrderDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ProjectLedgerDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.business.ContractBusinessDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.business.ContractBusinessDetailDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.business.ContractLedgerSimpleDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractProjectFinanceDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectAbleCollectionDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectAbleCollectionStatisticsDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectAnalysisDetailDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectAnalysisSummaryDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectExecuteStateDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectFeedingStateDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectOrderStatisticsDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectProductionMeteDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectSimpleInfoDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ProjectInstallDivideMethodDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ProjectInstallReportMethodDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.project.ContractProjectFilesParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.project.ProjectDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.project.ProjectLedgerDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.project.ProjectLedgerQueryDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.project.ProjectListQueryParam;
import com.hzchum.scim.contract.core.api.pojo.vo.largeScreen.ProjectDataVO;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosurePlanDetailDto;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosurePlanDetailQureyDto;
import com.hzchum.scim.plan.core.api.pojo.dto.TechnologyDTO;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import org.apache.ibatis.annotations.Param;

public interface ContractProjectService extends IService<ContractProject> {
   List<ContractProject> listProjectFiles(Long projectId, Long userId, ContractProjectFilesParam contractProjectFilesParam);

   List<Map<String, Object>> selectAttachmentTypeList();

   List<ContractProjectListDTO> listProjectsByConditions(ProjectListQueryParam queryParam);

   List<ContractProjectListForUserDTO> listProjectsByIdOrName(ProjectListQueryParam queryParam);

   BigDecimal getContractAmountSum(Integer projectType, Integer year, Integer status);

   Map<String, Integer> getOutFinishCount();

   List<Map<String, Object>> selectAllProject();

   ListVO<ProjectSimpleInfoDTO> listSimpleProject(Integer projectType, Integer businessType, Integer lumpSumSystemType, Integer level);

   List<Long> listProjectIdByUser(@NotNull Long userId, Integer level);

   ContractProject checkProjectStatus(Long projectId);

   ContractProject packageAndCargoListcheckProjectStatus(Long projectId);

   ProjectInfo getSimpleById(Long id);

   ProjectInfo getByIdFromCache(Long id);

   ProjectInfo updateWithCache(ContractProject project);

   ProjectInfo saveWithCache(ContractProject project);

   int deleteWithCache(Long id);

   List<ProjectInfo> listByIds(String projectIds);

   List<ProjectInfo> listSimpleByIdList(Collection<Long> idList);

   List<ContractProject> listTree(Long userId, Integer status, Integer settlementStatus, Integer projectType, Integer lumpSumSystemType, Integer level);

   List<ContractProject> listByCondition(ProjectDTOParam param);

   List<ContractProjectLedgerDTO> listProjectLedger(ProjectLedgerQueryDTOParam queryDTOParam);

   List<ProjectSimpleInfoDTO> listMyProject(
      Integer status, Integer settlementStatus, Integer year, String noName, Integer projectType, Integer lumpSumSystemType, Integer level
   );

   Integer getProjectMode(Long projectId);

   ListVO<ContractBusinessDTO> customerTransactionSummary(String name, Integer businessType, LocalDateTime startDate, LocalDateTime endDate);

   PageVO<ContractBusinessDTO> customerTransactionSummaryPage(
      String name, Integer businessType, LocalDateTime startDate, LocalDateTime endDate, Integer pageNumber, Integer pageSize, List<String> sortList
   );

   PrintVO<List<Map<String, Object>>> printCustomerTransactionSummary(String name, Integer businessType, LocalDateTime startDate, LocalDateTime endDate);

   ListVO<ContractBusinessDetailDTO> customerTransactionDetail(String name, Integer businessType, LocalDateTime startDate, LocalDateTime endDate);

   PrintVO<List<Map<String, Object>>> printCustomerTransactionDetail(String name, Integer businessType, LocalDateTime startDate, LocalDateTime endDate);

   List<ContractLedgerSimpleDTO> listSalesLedger(Long userId, Integer year, Integer projectStatus, String name, Integer orderSourceType, Integer productType);

   List<ContractProjectOrderDTO> listProjectOrderCount(LocalDateTime dateTime);

   List<ProjectAbleCollectionDTO> listAbleCollection(@Param("type") Integer type);

   ProjectAbleCollectionStatisticsDTO getAbleCollectionStatistics(Integer type);

   ProjectOrderStatisticsDTO getStatistics(Integer year, Integer productType, Integer lumpSumSystemType);

   List<ContractProject> costAnalysis(Integer settlementStatus, Integer status);

   Boolean updateInstallReportMethod(ProjectInstallReportMethodDTOParam param);

   List<ProjectSimpleInfoDTO> projectSummaryYear(LocalDateTime date, Integer status, String name, List<Long> projectIds, Integer projectType);

   List<ContractProjectFinanceDTO> listProjectFinancialStatement(
      Integer year, Long projectId, Integer businessType, Integer projectType, Integer orderSourceType, Integer status, Integer settlementStatus
   );

   Map projectListMySummary(int year, Integer projectType, Integer lumpSumSystemType, Integer level);

   List getMachinePartTaskprojectList(Set<Long> cutIds, LocalDateTime localDateTime, String serialNumber, List<Long> projectIds);

   List<ContractProject> listBytimeAndName(LocalDateTime startDate, LocalDateTime endDate, String name);

   List<ContractProject> taskOrderProjectList(List<Long> taskOrderIds, Integer type);

   Map<String, Object> projectSummaryInfo();

   List<ProjectDataVO> projectList();

   Map<String, Object> projectInfo(Long projectId);

   List<EnclosurePlanDetailDto> queryEnclosurePlan(EnclosurePlanDetailQureyDto dto, List<Long> projectIds);

   List<ProjectInfo> listInfoByIdList(Collection<Long> ids);

   ContractInvoiceCollectionDTO getProjectCollectionVoiceInfo(@NotNull Long projectId);

   List<String> selectSql(String areaName);

   void updateSql(String areaName);

   List<ProjectInfo> getSimpleByIds(List<Long> projectIds);

   List<TechnologyDTO> pageByYearAndName(Integer year, String name, Integer projectType, Integer lumpSumSystemType, Long userId);

   List<ProjectSimpleInfoDTO> selectContractProjects(
      Integer status, String noOrName, LocalDate firstDayOfYear, LocalDate lastDayOfYear, Integer projectType, Integer lumpSumSystemType, Long userId
   );

   List<ContractProject> selectContractProjectList(List<Long> combinedIds, Long aLong);

   List<ProjectLedgerDTO> projectLedgerList(ProjectLedgerDtoParam param);

   List<ProjectsTreeDTO> findProjectTreeByProjectId(List<Long> projectIds, Long workShopId, LocalDateTime dateTime);

   void checkContractSignBodyId(Long projectId, List<Long> projectIdList, String projectIds, Long contractSignBodyId);

   Boolean updateInstallDivideMethod(ProjectInstallDivideMethodDTOParam param);

   List<ContractProject> listWastage(Integer year, Integer status, List<Long> projectIds);

   List<ContractProject> wastageLossProjectList(Integer year, Integer status, List<Long> projectIds);

   ProjectAnalysisSummaryDTO getProjectSummaryDTO(LocalDate yearDate, Long branchCompanyId);

   List<ProjectAnalysisSummaryDTO> getGroupProjectDTO(LocalDate yearDate, Long branchCompanyId);

   List<ProjectAnalysisSummaryDTO> getGroupMonthProjectDTO(LocalDate yearDate, Long branchCompanyId);

   List<ProjectAnalysisDetailDTO> getGroupProjectDetailDTO(LocalDate yearDate, Integer businessType, Boolean year, Long branchCompanyId);

   void getGroupProjectDetailDTODownload(LocalDate yearDate, Boolean year, Integer businessType, Long branchCompanyId, HttpServletResponse response);

   List<ProjectAnalysisDetailDTO> getGroupProjectDeepMeteDetail(LocalDate yearDate, Long branchCompanyId);

   void getGroupProjectDeepMeteDetailDownload(LocalDate yearDate, Long branchCompanyId, HttpServletResponse response);

   PageVO<ContractProjectListDTO> listAnalysisProjects(ProjectListQueryParam queryParam, Integer pageNumber, Integer pageSize);

   ProjectProductionMeteDTO getProjectProductionMete(Long project, Long branchCompanyId);

   List<ProjectFeedingStateDTO> getProjectFeedingState(Long project, Long branchCompanyId, Boolean isRecently);

   void getProjectFeedingStateDownload(Long project, Long branchCompanyId, HttpServletResponse response);

   List<ProjectExecuteStateDTO> getProjectExecuteStateDTO(Long projectId, Long branchCompanyId);

   void getProjectExecuteStateDTODownload(Long projectId, Long branchCompanyId, HttpServletResponse response);

   BigDecimal getInstallMete(Long projectId, Long branchCompanyId);

   Boolean checkRelatednessById(Long projectId, Long projectId1);
}
