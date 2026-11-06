package com.hzchum.scim.project.core.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.project.core.api.enums.AuditStatusEnum;
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
import com.hzchum.scim.project.core.api.service.ProjectInstallReportService;
import com.hzchum.scim.project.core.mapper.ProjectInstallReportMapper;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Service
public class ProjectInstallReportServiceImpl extends ServiceImpl<ProjectInstallReportMapper, ProjectInstallReport> implements ProjectInstallReportService {
   @Override
   public ProjectInstallMeteDO getActualInstallMete(Long supplierId, Long projectId, Long monomerId, Long areaId, Integer productType, Integer category) {
      return this.baseMapper.selectActualInstallMete(supplierId, projectId, monomerId, areaId, productType, category);
   }

   @Override
   public List<ProjectInstallReportGroupDO> listInstallReportGroup(Long projectId, Integer productType, String yearMonth) {
      return this.baseMapper.selectInstallReportGroup(projectId, productType, yearMonth);
   }

   @Override
   public List<ProjectAppInstallReportGroupDO> listAppInstallReportGroup(Long projectId, Integer productType) {
      return this.baseMapper.selectUnAuditReportGroup(projectId, productType);
   }

   @Override
   public List<ProjectInstallReport> listInstallReport(InstallReportQueryDTOParam param) {
      return this.baseMapper.selectByCondition(param);
   }

   @Override
   public BigDecimal getUnCheckReportedQuantity(Integer projectType, Integer productType, Long productId) {
      return this.baseMapper.selectUnCheckReportQuantity(projectType, productType, productId);
   }

   @Override
   public Integer getUnCheckReportedQuantity(
      @Param("productType") Integer productType,
      @Param("supplierId") Long supplierId,
      @Param("projectId") Long projectId,
      @Param("category") Integer category,
      @Param("reportDate") String reportDate
   ) {
      return this.baseMapper.selectUnCheckQuantity(productType, supplierId, projectId, category, reportDate);
   }

   @Override
   public BigDecimal getUnCheckReportedQuantity(List<Long> projectIds) {
      List<ProjectInstallReport> installReportList = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(ProjectInstallReport.class)
               .eq(ProjectInstallReport::getAuditStatus, AuditStatusEnum.AUDITING.getType())
               .in(projectIds != null, ProjectInstallReport::getProjectId, projectIds)
         );
      return installReportList.stream().map(ProjectInstallReport::getReportQuantity).reduce(BigDecimal.ZERO, BigDecimal::add);
   }

   @Override
   public List<ProjectProductInstallSummaryDO> listProductInstallSum(Long projectId, Long monomerId, Integer monomerDetailType, Long areaId, Long supplierId) {
      return this.baseMapper.selectInstallReportSummary(projectId, monomerId, monomerDetailType, areaId, supplierId);
   }

   @Override
   public List<ProjectInstallSummaryDTO> listInstallStatement(InstallStatementQueryDTOParam param) {
      return this.baseMapper.selectInstallStatement(param);
   }

   @Override
   public List<ProjectInstallStatementDTO> listSumStatement(
      Long projectId, Long supplierId, Integer projectType, Integer productType, Integer year, Integer month
   ) {
      return this.baseMapper.selectSumStatement(projectId, supplierId, projectType, productType, year, month);
   }

   @Override
   public List<ProjectSupplierInstallSummaryDTO> getSupplierInstallArtifactSummary(Long projectId) {
      return this.baseMapper.getSupplierInstallArtifactSummary(projectId);
   }

   @Override
   public ProjectSupplierInstallSummaryDTO getProjectInstallArtifactSummary(Long projectId, Integer productType) {
      return this.baseMapper.getProjectInstallArtifactSummary(projectId, productType);
   }

   @Override
   public List<ProjectInstallReportDTO> getProjectInstallDetails(Long projectId, Integer productType, LocalDate startDate, LocalDate endDate) {
      List<ProjectInstallReportDTO> projectInstallDetails = this.baseMapper.getProjectInstallDetails(projectId, productType, startDate, endDate);

      for (ProjectInstallReportDTO installReportDTO : projectInstallDetails) {
         if (ProductTypeEnum.ENCLOSURE.getType().equals(productType)) {
            installReportDTO.setReportMete(installReportDTO.getReportMete().divide(BigDecimal.valueOf(1000L)));
         }
      }

      return projectInstallDetails;
   }
}
