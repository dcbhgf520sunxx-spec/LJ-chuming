package com.hzchum.scim.contract.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.ProjectsTreeDTO;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractProjectLedgerDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractProjectListDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractProjectListForUserDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractProjectOrderDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ProjectLedgerDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ProjectStandingBook;
import com.hzchum.scim.contract.core.api.pojo.dto.business.ContractBusinessDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.business.ContractBusinessDetailDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.business.ContractLedgerSimpleDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractProjectFinanceDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectAbleCollectionDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectAbleCollectionStatisticsDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectExecuteStateDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectSimpleInfoDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.project.ContractProjectFilesParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.project.ProjectDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.project.ProjectLedgerDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.project.ProjectLedgerQueryDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.project.ProjectListQueryParam;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosurePlanDetailDto;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosurePlanDetailQureyDto;
import com.hzchum.scim.plan.core.api.pojo.dto.TechnologyDTO;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.apache.ibatis.annotations.Param;

public interface ContractProjectMapper extends BaseMapper<ContractProject> {
   List<ProjectSimpleInfoDTO> listByConditions(@Param("status") Integer status, @Param("year") String year, @Param("projectType") Integer projectType);

   List<ContractProject> listProjectFiles(
      @Param("userId") Long userId, @Param("projectId") Long projectId, @Param("contractProjectFilesParam") ContractProjectFilesParam contractProjectFilesParam
   );

   List<ContractProjectListDTO> selectProjectsByConditions(ProjectListQueryParam queryParam);

   List<ContractProjectListForUserDTO> selectProjectsByIdOrName(ProjectListQueryParam queryParam);

   List<Long> selectProjectIdsByUserId(@Param("userId") Long userId, @Param("level") Integer level);

   ProjectInfo getProjectInfoById(@Param("projectId") Long projectId);

   List<ContractProject> selectListProject(
      @Param("userId") Long userId,
      @Param("status") Integer status,
      @Param("settlementStatus") Integer settlementStatus,
      @Param("projectType") Integer projectType,
      @Param("lumpSumSystemType") Integer lumpSumSystemType,
      @Param("level") Integer level
   );

   List<ContractProjectLedgerDTO> selectProjectLedgerList(ProjectLedgerQueryDTOParam queryDTOParam);

   List<ContractProject> listByCondition(ProjectDTOParam param);

   List<ProjectSimpleInfoDTO> selectMyProjectList(
      @Param("userId") Long userId,
      @Param("status") Integer status,
      @Param("settlementStatus") Integer settlementStatus,
      @Param("year") Integer year,
      @Param("noName") String noName,
      @Param("projectType") Integer projectType,
      @Param("lumpSumSystemType") Integer lumpSumSystemType,
      @Param("level") Integer level
   );

   BigDecimal selectContractAmountSum(@Param("projectType") Integer projectType, @Param("year") Integer year, @Param("status") Integer status);

   List<ContractBusinessDTO> customerTransactionSummary(
      @Param("name") String name,
      @Param("businessType") Integer businessType,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("projectIds") List<Long> projectIds
   );

   List<ContractBusinessDetailDTO> customerTransactionDetail(
      @Param("name") String name,
      @Param("businessType") Integer businessType,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("projectIds") List<Long> projectIds
   );

   List<ContractProjectOrderDTO> listProjectOrderCount(LocalDateTime dateTime);

   List<ProjectAbleCollectionDTO> selectAbleCollection(@Param("type") Integer type);

   ProjectAbleCollectionStatisticsDTO selectAbleCollectionStatistics(Integer type);

   List<ContractProject> costAnalysis(@Param("settlementStatus") Integer settlementStatus, @Param("status") Integer status);

   List<ContractLedgerSimpleDTO> selectListSalesLedger(
      @Param("userId") Long userId,
      @Param("year") Integer year,
      @Param("projectStatus") Integer projectStatus,
      @Param("name") String name,
      @Param("orderSourceType") Integer orderSourceType,
      @Param("productType") Integer productType
   );

   List<ProjectSimpleInfoDTO> projectSummaryYear(
      @Param("date") LocalDateTime date,
      @Param("status") Integer status,
      @Param("name") String name,
      @Param("projectIds") List<Long> projectIds,
      @Param("projectType") Integer projectType
   );

   List<ContractProjectFinanceDTO> selectProjectFinancialStatement(
      @Param("year") Integer year,
      @Param("projectId") Long projectId,
      @Param("businessType") Integer businessType,
      @Param("projectType") Integer projectType,
      @Param("orderSourceType") Integer orderSourceType,
      @Param("status") Integer status,
      @Param("settlementStatus") Integer settlementStatus
   );

   List<ProjectDetailDO> getMachinePartTaskprojectList(
      @Param("cutIds") Set<Long> cutIds,
      @Param("localDateTime") LocalDateTime localDateTime,
      @Param("serialNumber") String serialNumber,
      @Param("projectIds") List<Long> projectIds
   );

   List<ContractProject> listBytimeAndName(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate, @Param("name") String name);

   List<ContractProject> taskOrderProjectList(@Param("taskOrderIds") List<Long> taskOrderIds, @Param("type") Integer type);

   List<EnclosurePlanDetailDto> queryEnclosurePlan(@Param("dto") EnclosurePlanDetailQureyDto dto, @Param("projectIds") List<Long> projectIds);

   List<ProjectInfo> selectInfoByIdList(@Param("ids") Collection<Long> ids);

   List<String> selectSql(String areaName);

   void updateSql(String areaName);

   List<ProjectInfo> getProjectInfoByIds(List<Long> projectIds);

   List<TechnologyDTO> pageByYearAndName(
      @Param("year") Integer year,
      @Param("name") String name,
      @Param("projectType") Integer projectType,
      @Param("lumpSumSystemType") Integer lumpSumSystemType,
      @Param("userId") Long userId
   );

   List<ProjectSimpleInfoDTO> selectContractProjects(
      @Param("status") Integer status,
      @Param("noOrName") String noOrName,
      @Param("firstDayOfYear") LocalDate firstDayOfYear,
      @Param("lastDayOfYear") LocalDate lastDayOfYear,
      @Param("projectType") Integer projectType,
      @Param("lumpSumSystemType") Integer lumpSumSystemType,
      @Param("userId") Long userId
   );

   List<ContractProject> selectContractProjectList(@Param("combinedIds") List<Long> combinedIds, @Param("userId") Long userId);

   List<ProjectStandingBook> selectProjectStandingBook(
      @Param("projectAttribute") String projectAttribute,
      @Param("projectManagerId") Integer projectManagerId,
      @Param("projectId") Long projectId,
      @Param("startDate") LocalDate startDate,
      @Param("endDate") LocalDate endDate
   );

   List<ProjectLedgerDTO> projectLedgerList(ProjectLedgerDtoParam param);

   List<ProjectsTreeDTO> findProjectTreeByProjectid(
      @Param("projectIds") List<Long> projectIds, @Param("workShopId") Long workShopId, @Param("dateTime") LocalDateTime dateTime
   );

   Long UnAuditReport(Long projectId);

   List<ContractProject> listWastage(@Param("year") Integer year, @Param("status") Integer status, @Param("projectIds") List<Long> projectIds);

   List<ContractProject> wastageLossProjectList(@Param("year") Integer year, @Param("status") Integer status, @Param("projectIds") List<Long> projectIds);

   List<ContractProject> getProjectList(LocalDate yearDate, Boolean year, Integer businessType, Long branchCompanyId);

   List<ProjectExecuteStateDTO> getDeepMeteGroupMonth(Long projectId);

   List<ProjectExecuteStateDTO> getProduceMeteGroupMonth(Long projectId);

   List<ProjectExecuteStateDTO> getShippingMeteGroupMonth(Long projectId);

   List<ProjectExecuteStateDTO> getInstallMeteGroupMonth(Long projectId);

   BigDecimal getInstallMete(Long projectId);

   default List<ProjectSimpleInfoDTO> getProjectPlanList(Integer status, String noOrName, Integer year, Long userId) {
      return this.getProjectPlanListFiltered(status, noOrName, year, userId, null, null);
   }

   List<ProjectSimpleInfoDTO> getProjectPlanListFiltered(
      @Param("status") Integer status,
      @Param("noOrName") String noOrName,
      @Param("year") Integer year,
      @Param("userId") Long userId,
      @Param("projectType") Integer projectType,
      @Param("lumpSumSystemType") Integer lumpSumSystemType
   );
}
