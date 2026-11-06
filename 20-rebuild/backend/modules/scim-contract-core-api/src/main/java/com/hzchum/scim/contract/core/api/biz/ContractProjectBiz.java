package com.hzchum.scim.contract.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo.dto.AppendAttachmentDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractProjectInfoDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractProjectListDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractProjectListForUserDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractProjectPrimeListDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ProjectLedgerDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ProjectLedgerV2DTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ProjectRelevancyDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.projectManagerLedgerDisburseDetailDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.PeriodCostDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ProjectCostReportDto;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ProjectElseAllDto;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ProjectExpenseCostReportDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ProjectMaterialsAllDto;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ProjectSelfSupportCostReportDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.project.ManagementFeeAllDto;
import com.hzchum.scim.contract.core.api.pojo.dto.project.ProjectSupplierDto;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ContractProjectArchivistDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ContractProjectFilesDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectBaseDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectBusinessDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectCustomerDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectDetailsDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectSimpleInfoDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.app.AppCollectionDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.ProjectLedgerSeltSupportPaymentDto;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.ProjectLedgerSupplierInvoiceDetailDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.visa.ContractVisaSettlementDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.project.ContractProjectFilesParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.project.ContractProjectIsArchivistParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.project.ProjectLedgerDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.project.ProjectListQueryParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.save.ProjectSaveDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.update.ProjectUserUpdateCollectDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.update.ProjectUserUpdateParam;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

public interface ContractProjectBiz extends IBiz<ContractProject> {
   PageVO<ContractProjectListDTO> pageListProjectByCondition(ProjectListQueryParam queryParam, Integer pageNumber, Integer pageSize);

   PageVO<ContractProjectListForUserDTO> pageListProjectByIdOrName(ProjectListQueryParam queryParam, Integer pageNumber, Integer pageSize);

   List<ContractProjectListForUserDTO> pageListProjectByIdOrNameAll(ProjectListQueryParam queryParam);

   PrintVO<List<Map<String, Object>>> printContractByConditions(ProjectListQueryParam queryParam);

   BigDecimal getSumStructureWorkQuantity(ProjectListQueryParam param);

   PageVO<ContractProjectFilesDTO> listProjectFiles(ContractProjectFilesParam contractProjectFilesParam, Long projectId, Integer pageNumber, Integer pageSize);

   Boolean exportProject(Long id, HttpServletResponse response);

   Boolean saveContract(ProjectSaveDTOParam requestDTO);

   ListVO listByType(Integer type);

   ProjectBaseDTO getContractBaseByProjectId(Long projectId);

   ProjectBusinessDTO getContractBusinessByProjectId(Long projectId);

   ProjectBusinessDTO getContractBusinessByProjectIdV2(Long projectId);

   ProjectCustomerDTO getContractCustomerByProjectId(Long projectId);

   Boolean saveLinks(Long projectId, List<Long> userIdList);

   Boolean saveProjectsLinks(ProjectUserUpdateCollectDTOParam projectUserUpdateCollectDTOParam);

   ListVO<ContractVisaSettlementDTO> listProjectSettleInfo(Integer projectType, Integer businessType, Integer status, Integer settlementStatus);

   Boolean updateProjectStatus(Long projectId, Integer status, Boolean isCheckOutFinishStatus);

   Boolean delete(List<Long> ids);

   List<ProjectSimpleInfoDTO> listAllProjectSimple();

   List<ProjectSimpleInfoDTO> listSimpleProjectInfo(
      Integer projectType, Integer businessType, Integer status, Integer settlementStatus, Integer lumpSumSystemType, Integer level
   );

   AppCollectionDTO collectionInfo(Long projectId);

   ContractProject getById(Long projectId);

   List<ContractProject> listAllProjectBstatus();

   ContractProjectInfoDTO getMyProjectInfo(Integer year, Integer projectType, Integer lumpSumSystemType, Integer level);

   PageVO<ProjectSimpleInfoDTO> listMyProjects(
      Integer status,
      Integer settlementStatus,
      Integer year,
      String noName,
      Integer projectType,
      Integer lumpSumSystemType,
      Integer level,
      Integer pageNumber,
      Integer pageSize
   );

   PrintVO<List<Map<String, Object>>> printMyProjects(
      Integer year, Integer status, Integer settlementStatus, String noName, Integer projectType, Integer lumpSumSystemType, Integer level
   );

   PageVO<ContractProjectArchivistDTO> isArchivist(ContractProjectIsArchivistParam contractProjectIsArchivistParam, Integer pageNumber, Integer pageSize);

   boolean updateProject(ProjectSaveDTOParam projectSaveDTOParam);

   ProjectDetailsDTO getContractDetailsByProjectId(Long projectId);

   String getSerialNumber(Integer projectId);

   Integer getUnArchived();

   void bulkDownloadAttachment(List<Long> projectIds);

   Boolean bulkDownloadAttachmentNew(Map<Long, List<Long>> projectIdsMap) throws IOException;

   boolean appendAttachment(AppendAttachmentDTO attachmentDTO);

   Boolean addContract(ProjectSaveDTOParam requestDTO);

   boolean putProject(ProjectSaveDTOParam projectSaveDTOParam);

   ProjectSupplierDto getProjectProcurement(Long projectId, Long orderId);

   ProjectSupplierDto getProjectSupplierDto(ContractProject project);

   PageVO<ContractProjectListDTO> pageListProject(ProjectListQueryParam queryParam, Integer pageNumber, Integer pageSize);

   PageVO<ProjectSimpleInfoDTO> getMyProjects(
      Integer status, String noOrName, Integer projectType, Integer year, Integer lumpSumSystemType, Integer level, Integer pageNumber, Integer pageSize
   );

   List<ContractProject> projectWageEstimateProjectList(Integer year, Integer status, String serialNumberOrShortName);

   Map<String, Integer> projectWageEstimateProjectQuantityStatistics(Integer year);

   Map<String, List<ContractProjectListForUserDTO>> listProjectByUser(ProjectListQueryParam projectListQueryParam);

   String userUpdateProject(ProjectUserUpdateParam projectUserUpdateParam);

   Map<String, Object> getProjectSelfEmployed(LocalDateTime year, Integer level, Integer settlementStatus);

   PageVO<ProjectLedgerDTO> getProjectSelfOwnedPageSize(ProjectLedgerDtoParam param, Integer pageNumber, Integer pageSize);

   ProjectSelfSupportCostReportDTO getSelfSupportCost(Long projectId, Integer year);

   void getSelfSupportCostDownload(Long projectId, Integer year, HttpServletResponse response);

   PrintVO getSelfSupportCostDetailDownload(Long projectId, Integer year);

   List<ProjectMaterialsAllDto> getSelfSupportCostDetailList(Long projectId, Integer costTypeEnum);

   PrintVO<List<ProjectMaterialsAllDto>> printSelfSupportCostDetailList(Long projectId, Integer costTypeEnum);

   List<ProjectLedgerSupplierInvoiceDetailDTO> getSelfSupportCostPaymentList(Long orderId, Integer costTypeEnum);

   PrintVO<List<ProjectLedgerSupplierInvoiceDetailDTO>> printSelfSupportCostPaymentList(Long orderId, Integer costTypeEnum);

   List<ProjectCostReportDto> getSelfSupportCostReport(Long projectId, Integer year);

   ProjectLedgerSeltSupportPaymentDto getSeltSupportPayment(Long projectId);

   PrintVO getSeltSupportPaymentDownload(Long projectId);

   List<ProjectSimpleInfoDTO> getProjectAttributeList(String projectAttribute, Long projectManagerId, Integer year, Integer level);

   List<ProjectInfo> getProjectFilter(Integer projectAttribute, Integer level, Long branchCompanyId);

   List<PeriodCostDTO> getPeriodCostDetail(Long projectId);

   PrintVO getSelfSupportCostDetail(Long projectId, Integer year);

   ProjectCostReportDto getProjectCostReport(Long projectId);

   PageVO<ProjectMaterialsAllDto> getProjectMaterialDeductDetails(Long projectId, Integer pageNumber, Integer pageSize);

   PageVO<ProjectElseAllDto> getProjectOtherDetails(Long projectId, Integer pageNumber, Integer pageSize);

   PageVO<ManagementFeeAllDto> getProjectManagementFeeDetails(Long projectId, Integer pageNumber, Integer pageSize);

   Boolean getProjectCostReportDownload(Long projectId, HttpServletResponse response);

   PageVO<ProjectLedgerV2DTO> projectManagerLedger(
      LocalDateTime startDate,
      LocalDateTime endDate,
      String projectAttribute,
      Long projectManagerId,
      Long projectId,
      String projectName,
      Integer settlementStatus,
      Integer pageNumber,
      Integer pageSize
   );

   PageVO<projectManagerLedgerDisburseDetailDTO> projectManagerLedgerDisburseDetail(
      Long projectId, LocalDateTime startDate, LocalDateTime endDate, Integer pageNumber, Integer pageSize
   );

   BigDecimal projectManagerLedgerDisburseDetailSummary(Long projectManagerId);

   BigDecimal getContractAmountSum(ProjectListQueryParam queryParam);

   void downLoadImportProjectTemplate(HttpServletResponse response);

   void importProject(MultipartFile file, HttpServletResponse response);

   Map<String, BigDecimal> getCostSummary(ProjectLedgerDtoParam param);

   List<ProjectExpenseCostReportDTO> getProjectExpenseCostReportDTO(Long projectId, Long branchCompanyId);

   void getProjectExpenseCostReportDownload(Long projectId, Long branchCompanyId, HttpServletResponse response);

   List<ContractProjectPrimeListDTO> primeContractList();

   ContractProjectInfoDTO getProjectSummaryInfo();

   PageVO<ProjectSimpleInfoDTO> getProjectList(Integer status, String noOrName, Integer year, Integer pageNumber, Integer pageSize);

   PageVO<ProjectSimpleInfoDTO> getProjectList(
      Integer status, String noOrName, Integer year, Integer pageNumber, Integer pageSize, Integer projectType, Integer lumpSumSystemType
   );

   List<ProjectRelevancyDTO> getProjectAdditionalProject(Integer projectId);

   Map<Integer, List<ProjectRelevancyDTO>> getProjectAdditionalProjectBatch(List<Integer> projectIds);
}
