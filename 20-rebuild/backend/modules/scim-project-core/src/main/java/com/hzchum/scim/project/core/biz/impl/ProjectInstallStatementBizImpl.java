package com.hzchum.scim.project.core.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.plan.core.api.biz.ProductBiz;
import com.hzchum.scim.plan.core.api.enums.PlanDetailTypeEnum;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanDetail;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo.dto.ProductMeteDTO;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanDetailService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.project.core.api.biz.ProjectInstallStatementBiz;
import com.hzchum.scim.project.core.api.pojo._do.ProjectQhseProblem;
import com.hzchum.scim.project.core.api.pojo._do.ProjectSupplierAreaLink;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectInstallMeteSummaryDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectInstallStatementDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectInstallSumDTO;
import com.hzchum.scim.project.core.api.service.ProjectInstallReportService;
import com.hzchum.scim.project.core.api.service.ProjectInstallSummaryService;
import com.hzchum.scim.project.core.api.service.ProjectQhseProblemService;
import com.hzchum.scim.project.core.api.service.ProjectReceivingSummaryService;
import com.hzchum.scim.project.core.api.service.ProjectSupplierAccountService;
import com.hzchum.scim.project.core.api.service.ProjectSupplierAreaLinkService;
import com.hzchum.scim.project.core.api.utils.ProjectInstallBizUtil;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ProjectInstallStatementBizImpl implements ProjectInstallStatementBiz {
   private static final Logger log = LoggerFactory.getLogger(ProjectInstallStatementBizImpl.class);
   @Resource
   private ProjectInstallReportService projectInstallReportService;
   @Resource
   private ProjectSupplierAccountService supplierAccountService;
   @Resource
   private ProjectSupplierAreaLinkService supplierAreaLinkService;
   @Resource
   private PlanMonomerService monomerService;
   @Resource
   private PlanAreaService areaService;
   @Resource
   private PlanDetailService planDetailService;
   @Resource
   private ProductBiz productBiz;
   @Resource
   private ProjectInstallBizUtil projectInstallBizUtil;
   @Resource
   private ProjectQhseProblemService problemService;
   @Resource
   private ProjectReceivingSummaryService receivingSummaryService;
   @Resource
   private ProjectInstallSummaryService installSummaryService;
   @Resource
   private ContractProjectService projectService;

   @Override
   public List<ProjectInstallStatementDTO> listInstallStatement(Long projectId, Integer projectType, Integer productType, Integer year, Integer month) {
      Long supplierId = this.supplierAccountService.getSupplierIdByUserId(UserUtil.getCurrentUserId());
      return this.projectInstallReportService.listSumStatement(projectId, supplierId, projectType, productType, year, month);
   }

   @Override
   public List<ProjectInstallSumDTO> getInstallSum(Long monomerId) {
      Long supplierId = this.supplierAccountService.getSupplierIdByUserId(UserUtil.getCurrentUserId());
      PlanMonomer monomer = this.monomerService.getById(monomerId);
      Preconditions.checkArgument(monomer != null, "单体不存在");
      ContractProject project = this.projectService.getById(monomer.getProjectId());
      List<ProjectSupplierAreaLink> linkList = this.supplierAreaLinkService
         .list(
            Wrappers.lambdaQuery(ProjectSupplierAreaLink.class)
               .eq(ProjectSupplierAreaLink::getSupplierId, supplierId)
               .eq(ProjectSupplierAreaLink::getMonomerId, monomerId)
               .eq(ProjectSupplierAreaLink::getBoolSettlementStatus, false)
               .eq(ProjectSupplierAreaLink::getBoolRelationStatus, true)
         );
      List<Long> areaIds = linkList.stream().map(ProjectSupplierAreaLink::getAreaId).collect(Collectors.toList());
      List<ProjectInstallSumDTO> list = new ArrayList<>();
      areaIds.forEach(
         areaId -> {
            PlanArea area = this.areaService.getById(areaId);
            ProjectInstallMeteSummaryDTO installMete = this.projectInstallBizUtil.getActualInstallMete(areaId);
            ProductMeteDTO deepenMete = null;
            if (project.getProjectType().equals(ProjectTypeEnum.MES.getType()) || project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())) {
               deepenMete = this.productBiz.getDeepenMete(areaId);
            }

            ProjectInstallSumDTO installSumDTO = ProjectInstallSumDTO.builder()
               .areaId(areaId)
               .areaName(area.getName())
               .productType(area.getProductCategory())
               .quantity(BigDecimal.valueOf(deepenMete.getQuantity().intValue()))
               .mete(deepenMete.getMete())
               .totalArea(deepenMete.getMeteTwo())
               .actualQuantity(installMete.getActualQuantity())
               .actualMete(installMete.getActualMete().divide(BigDecimal.valueOf(1000L)))
               .actualTotalArea(installMete.getActualTotalArea())
               .build();
            list.add(installSumDTO);
         }
      );
      return list;
   }

   @Override
   public List<Map<String, Object>> listInstallPlan(Long projectId) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目");
      Long supplierId = this.supplierAccountService.getSupplierIdByUserId(UserUtil.getCurrentUserId());
      List<ProjectSupplierAreaLink> areaLinkList = this.supplierAreaLinkService
         .list(
            Wrappers.lambdaQuery(ProjectSupplierAreaLink.class)
               .eq(ProjectSupplierAreaLink::getSupplierId, supplierId)
               .eq(ProjectSupplierAreaLink::getProjectId, projectId)
               .eq(ProjectSupplierAreaLink::getBoolRelationStatus, true)
               .eq(ProjectSupplierAreaLink::getBoolSettlementStatus, false)
         );
      List<Map<String, Object>> monomerMapList = new ArrayList<>();
      Map<Long, List<ProjectSupplierAreaLink>> monomerListMap = areaLinkList.stream().collect(Collectors.groupingBy(ProjectSupplierAreaLink::getMonomerId));
      monomerListMap.forEach(
         (monomerId, links) -> {
            PlanMonomer monomer = this.monomerService.getById(monomerId);
            Map<String, Object> monomerMap = new HashMap<>(8);
            monomerMap.put("id", monomer.getId());
            monomerMap.put("name", monomer.getName());
            List<Map<String, Object>> areaMapList = new ArrayList<>();
            links.forEach(
               link -> {
                  PlanArea area = this.areaService.getById(link.getAreaId());
                  PlanDetail planDetail = this.planDetailService
                     .getOne(
                        Wrappers.lambdaQuery(PlanDetail.class)
                           .eq(PlanDetail::getAreaId, link.getAreaId())
                           .eq(PlanDetail::getType, PlanDetailTypeEnum.INSTALL_PLAN.getType())
                     );
                  BigDecimal deepQuantity = BigDecimal.ZERO;
                  BigDecimal deepMete = BigDecimal.ZERO;
                  BigDecimal deepTotalArea = BigDecimal.ZERO;
                  if (project.getProjectType().equals(ProjectTypeEnum.MES.getType()) || project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())) {
                     ProductMeteDTO deepenMete = this.productBiz.getDeepenMete(link.getAreaId());
                     deepQuantity = BigDecimal.valueOf(deepenMete.getQuantity().intValue());
                     deepMete = deepenMete.getMete();
                     deepTotalArea = deepenMete.getMeteTwo();
                  }

                  ProjectInstallMeteSummaryDTO installMete = this.projectInstallBizUtil.getActualInstallMete(link.getAreaId());
                  Map<String, Object> areaMap = new HashMap<>(8);
                  areaMap.put("id", link.getAreaId());
                  areaMap.put("name", area.getName());
                  areaMap.put("productCategory", area.getProductCategory());
                  areaMap.put("startDate", planDetail != null ? planDetail.getStartDate() : null);
                  areaMap.put("endDate", planDetail != null ? planDetail.getEndDate() : null);
                  areaMap.put("completeDate", planDetail != null ? planDetail.getCompleteDate() : null);
                  areaMap.put("quantity", deepQuantity);
                  areaMap.put("mete", deepMete);
                  areaMap.put("actualQuantity", installMete.getActualQuantity());
                  if (area.getProductCategory().equals(ProductTypeEnum.ENCLOSURE.getType())) {
                     areaMap.put("totalArea", deepTotalArea);
                     areaMap.put("actualMete", installMete.getActualMete());
                     areaMap.put("actualTotalArea", installMete.getActualTotalArea());
                  } else {
                     areaMap.put("actualMete", installMete.getActualMete().divide(BigDecimal.valueOf(1000L)));
                  }

                  areaMapList.add(areaMap);
               }
            );
            monomerMap.put("children", areaMapList);
            monomerMapList.add(monomerMap);
         }
      );
      return monomerMapList;
   }

   @Override
   public Map<String, Number> getMyTaskQuantity() {
      Long supplierId = this.supplierAccountService.getSupplierIdByUserId(UserUtil.getCurrentUserId());
      int count = this.problemService
         .count(
            Wrappers.lambdaQuery(ProjectQhseProblem.class).eq(ProjectQhseProblem::getBoolChangeStatus, false).eq(ProjectQhseProblem::getSupplierId, supplierId)
         );
      List<ProjectSupplierAreaLink> linkList = this.supplierAreaLinkService
         .list(
            Wrappers.lambdaQuery(ProjectSupplierAreaLink.class)
               .eq(ProjectSupplierAreaLink::getSupplierId, supplierId)
               .eq(ProjectSupplierAreaLink::getBoolSettlementStatus, false)
               .eq(ProjectSupplierAreaLink::getBoolRelationStatus, true)
         );
      BigDecimal subMyTask = BigDecimal.ZERO;
      if (CollectionUtils.isNotEmpty(linkList)) {
         List<Long> areaIds = linkList.stream().map(ProjectSupplierAreaLink::getAreaId).collect(Collectors.toList());
         BigDecimal receivingQuantity = this.receivingSummaryService.getReceivingQuantity(areaIds);
         BigDecimal actualInstallQuantity = this.installSummaryService.getActualInstallQuantity(areaIds);
         subMyTask = receivingQuantity.subtract(actualInstallQuantity);
      }

      Map<String, Number> map = new HashMap<>(8);
      map.put("subMyRectify", count);
      map.put("subMyTask", subMyTask);
      return map;
   }
}
