package com.hzchum.scim.project.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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

public interface ProjectInstallReportMapper extends BaseMapper<ProjectInstallReport> {
   BigDecimal selectUnCheckReportQuantity(
      @Param("projectType") Integer projectType, @Param("productType") Integer productType, @Param("productId") Long productId
   );

   int selectUnCheckQuantity(
      @Param("productType") Integer productType,
      @Param("supplierId") Long supplierId,
      @Param("projectId") Long projectId,
      @Param("category") Integer category,
      @Param("reportDate") String reportDate
   );

   ProjectInstallMeteDO selectActualInstallMete(
      @Param("supplierId") Long supplierId,
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("productType") Integer productType,
      @Param("category") Integer category
   );

   List<ProjectInstallReportGroupDO> selectInstallReportGroup(
      @Param("projectId") Long projectId, @Param("productType") Integer productType, @Param("yearMonth") String yearMonth
   );

   List<ProjectProductInstallSummaryDO> selectInstallReportSummary(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("monomerDetailType") Integer monomerDetailType,
      @Param("areaId") Long areaId,
      @Param("supplierId") Long supplierId
   );

   List<ProjectInstallReport> selectByCondition(InstallReportQueryDTOParam param);

   List<ProjectInstallSummaryDTO> selectInstallStatement(InstallStatementQueryDTOParam param);

   List<ProjectInstallStatementDTO> selectSumStatement(
      @Param("projectId") Long projectId,
      @Param("supplierId") Long supplierId,
      @Param("projectType") Integer projectType,
      @Param("productType") Integer productType,
      @Param("year") Integer year,
      @Param("month") Integer month
   );

   List<ProjectAppInstallReportGroupDO> selectUnAuditReportGroup(@Param("projectId") Long projectId, @Param("productType") Integer productType);

   List<ProjectSupplierInstallSummaryDTO> getSupplierInstallArtifactSummary(@Param("projectId") Long projectId);

   ProjectSupplierInstallSummaryDTO getProjectInstallArtifactSummary(@Param("projectId") Long projectId, @Param("productType") Integer productType);

   List<ProjectInstallReportDTO> getProjectInstallDetails(
      @Param("projectId") Long projectId,
      @Param("productType") Integer productType,
      @Param("startDate") LocalDate startDate,
      @Param("endDate") LocalDate endDate
   );
}
