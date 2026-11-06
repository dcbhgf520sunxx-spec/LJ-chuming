package com.hzchum.scim.project.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.project.core.api.pojo._do.ProjectInstallReport;
import com.hzchum.scim.project.core.api.pojo.dao.ProjectAppInstallReportGroupDO;
import com.hzchum.scim.project.core.api.pojo.dao.ProjectInstallMeteDO;
import com.hzchum.scim.project.core.api.pojo.dao.ProjectInstallReportGroupDO;
import com.hzchum.scim.project.core.api.pojo.dao.ProjectProductInstallSummaryDO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectInstallReportDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectInstallStatementDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectInstallSummaryDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectSupplierInstallSummaryDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.InstallReportQueryDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.InstallStatementQueryDTOParam;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectInstallReportService extends IService<ProjectInstallReport> {
   ProjectInstallMeteDO getActualInstallMete(Long supplierId, Long projectId, Long monomerId, Long areaId, Integer productType, Integer category);

   List<ProjectInstallReportGroupDO> listInstallReportGroup(Long projectId, Integer productType, String yearMonth);

   List<ProjectAppInstallReportGroupDO> listAppInstallReportGroup(Long projectId, Integer productType);

   List<ProjectInstallReport> listInstallReport(InstallReportQueryDTOParam param);

   BigDecimal getUnCheckReportedQuantity(Integer projectType, Integer productType, Long productId);

   Integer getUnCheckReportedQuantity(
      @Param("productType") Integer productType,
      @Param("supplierId") Long supplierId,
      @Param("projectId") Long projectId,
      @Param("category") Integer category,
      @Param("reportDate") String reportDate
   );

   BigDecimal getUnCheckReportedQuantity(List<Long> projectIds);

   List<ProjectProductInstallSummaryDO> listProductInstallSum(Long projectId, Long monomerId, Integer monomerDetailType, Long areaId, Long supplierId);

   List<ProjectInstallSummaryDTO> listInstallStatement(InstallStatementQueryDTOParam param);

   List<ProjectInstallStatementDTO> listSumStatement(Long projectId, Long supplierId, Integer projectType, Integer productType, Integer year, Integer month);

   List<ProjectSupplierInstallSummaryDTO> getSupplierInstallArtifactSummary(Long projectId);

   ProjectSupplierInstallSummaryDTO getProjectInstallArtifactSummary(Long projectId, Integer productType);

   List<ProjectInstallReportDTO> getProjectInstallDetails(Long projectId, Integer productType, LocalDate startDate, LocalDate endDate);
}
