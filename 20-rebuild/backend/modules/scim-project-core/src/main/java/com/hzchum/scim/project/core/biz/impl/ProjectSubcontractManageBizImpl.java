package com.hzchum.scim.project.core.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.SupplierInfo;
import com.hzchum.scim.contract.core.api.enums.ProjectBusinessTypeEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.plan.core.api.biz.ProductBiz;
import com.hzchum.scim.plan.core.api.enums.PlanDetailTypeEnum;
import com.hzchum.scim.plan.core.api.enums.ProjectPlanProductCategoryEnum;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanDetail;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomerDetail;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechAuxiliaryMaterial;
import com.hzchum.scim.plan.core.api.pojo._do.TechEnclosure;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanDetailTraceDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProductMeteDTO;
import com.hzchum.scim.plan.core.api.pojo.vo.ProjectManagePlanAreaVO;
import com.hzchum.scim.plan.core.api.pojo.vo.ProjectManagePlanMonomerVO;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanDetailService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerDetailService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAuxiliaryMaterialService;
import com.hzchum.scim.plan.core.api.service.TechEnclosureService;
import com.hzchum.scim.project.core.api.biz.ProjectSubcontractManageBiz;
import com.hzchum.scim.project.core.api.biz.ProjectSupplierAccountBiz;
import com.hzchum.scim.project.core.api.pojo._do.ProjectSupplierAreaLink;
import com.hzchum.scim.project.core.api.pojo.dao.ProjectProductInstallSummaryDO;
import com.hzchum.scim.project.core.api.pojo.dao.ProjectSupplierAccountDO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectAreaMeteDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectProductInstallSummaryDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectSupplierAccountDTO;
import com.hzchum.scim.project.core.api.pojo.dto.plan.ProjectAreaDTO;
import com.hzchum.scim.project.core.api.pojo.dto.plan.ProjectMonomerDTO;
import com.hzchum.scim.project.core.api.pojo.dto.plan.ProjectMonomerDetailDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectInstallPlanDTOParam;
import com.hzchum.scim.project.core.api.service.ProjectInstallReportService;
import com.hzchum.scim.project.core.api.service.ProjectSupplierAccountService;
import com.hzchum.scim.project.core.api.service.ProjectSupplierAreaLinkService;
import com.hzchum.scim.scm.core.api.common.ScmConstants;
import com.hzchum.scim.scm.core.api.pojo._do.SubcontractClassConfig;
import com.hzchum.scim.scm.core.api.pojo._do.SubcontractMonomerLink;
import com.hzchum.scim.scm.core.api.pojo._do.SubcontractOrder;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import com.hzchum.scim.scm.core.api.service.SubcontractClassConfigService;
import com.hzchum.scim.scm.core.api.service.SubcontractMonomerLinkService;
import com.hzchum.scim.scm.core.api.service.SubcontractOrderService;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.transaction.TransactionalException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectSubcontractManageBizImpl implements ProjectSubcontractManageBiz {
   @Resource
   private ContractProjectService projectService;
   @Resource
   private PlanMonomerService monomerService;
   @Resource
   private PlanMonomerDetailService monomerDetailService;
   @Resource
   private ProductBiz productBiz;
   @Resource
   private PlanDetailService planDetailService;
   @Resource
   private PlanAreaService areaService;
   @Resource
   private ProjectSupplierAreaLinkService supplierAreaLinkService;
   @Resource
   private ProjectSupplierAccountService supplierAccountService;
   @Resource
   private SupplierService supplierService;
   @Resource
   private SubcontractMonomerLinkService subcontractMonomerLinkService;
   @Resource
   private SubcontractClassConfigService subcontractClassConfigService;
   @Resource
   private ProjectInstallReportService installReportService;
   @Resource
   private TechArtifactService artifactService;
   @Resource
   private TechEnclosureService enclosureService;
   @Resource
   private TechAuxiliaryMaterialService auxiliaryMaterialService;
   @Resource
   ProjectSupplierAccountBiz supplierAccountBiz;
   @Resource
   private SubcontractOrderService subcontractOrderService;

   @Override
   public ListVO<ProjectMonomerDTO> listInstallPlan(Long projectId, Long monomerId) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在");
      Preconditions.checkArgument(project.getBusinessType().equals(ProjectBusinessTypeEnum.JOB.getType()), "该项目类型是加工承揽订单");
      List<SupplierInfo> canInstallSupplierInfoList = this.getCanInstallSupplierInfoList(projectId);
      List<PlanMonomer> planMonomerList = this.monomerService
         .list(
            Wrappers.lambdaQuery(PlanMonomer.class)
               .eq(PlanMonomer::getProjectId, projectId)
               .eq(monomerId != null, PlanMonomer::getId, monomerId)
               .orderByAsc(PlanMonomer::getSort)
         );
      List<ProjectMonomerDTO> monomerDTOS = planMonomerList.stream()
         .map(
            m -> {
               ProjectMonomerDTO monomerDTO = BeanUtil.copy(m, ProjectMonomerDTO.class);
               SubcontractClassConfig subcontractClassConfig = this.subcontractClassConfigService
                  .getOne(Wrappers.lambdaQuery(SubcontractClassConfig.builder().name("劳务分包").build()));
               List<SubcontractMonomerLink> monomerLinkList = this.subcontractMonomerLinkService
                  .list(
                     Wrappers.lambdaQuery(SubcontractMonomerLink.class)
                        .eq(SubcontractMonomerLink::getMonomerId, m.getId())
                        .eq(SubcontractMonomerLink::getSubcontractClassId, subcontractClassConfig.getId())
                        .eq(SubcontractMonomerLink::getBoolSettlementStatus, false)
                  );
               List<SupplierInfo> supplierInfoList = monomerLinkList.stream().map(link -> {
                  Supplier supplier = this.supplierService.getById(link.getSupplierId());
                  return SupplierInfo.builder().supplierId(link.getSupplierId()).supplierName(supplier.getName()).build();
               }).collect(Collectors.toList());
               monomerDTO.setSupplierList(supplierInfoList);
               if (CollectionUtils.isEmpty(supplierInfoList)) {
                  monomerDTO.setSupplierList(canInstallSupplierInfoList);
               }

               List<ProjectMonomerDetailDTO> monomerDetailDTOList = this.monomerDetailService
                  .list(Wrappers.lambdaQuery(PlanMonomerDetail.class).eq(PlanMonomerDetail::getMonomerId, m.getId()))
                  .stream()
                  .map(
                     md -> {
                        ProjectMonomerDetailDTO monomerDetailDTO = BeanUtil.copy(md, ProjectMonomerDetailDTO.class);
                        if (project.getProjectType().equals(ProjectTypeEnum.MES.getType()) || project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())
                           )
                         {
                           ProductMeteDTO productMeteDTO = this.productBiz.getDeepenMete(md.getMonomerId(), md.getType());
                           monomerDetailDTO.setQuantity(BigDecimal.valueOf(productMeteDTO.getQuantity().intValue()));
                           monomerDetailDTO.setDeepenMete(productMeteDTO.getMete());
                        }

                        PlanDetailTraceDTO maxMInDate = this.planDetailService.getMaxMInDate(md.getMonomerId(), md.getType(), null, null);
                        if (maxMInDate != null) {
                           monomerDetailDTO.setStartDate(maxMInDate.getStartDate());
                           monomerDetailDTO.setEndDate(maxMInDate.getEndDate());
                        }

                        List<PlanArea> areaList = this.areaService
                           .list(
                              Wrappers.lambdaQuery(PlanArea.class)
                                 .eq(PlanArea::getMonomerId, md.getMonomerId())
                                 .eq(PlanArea::getProductType, md.getType())
                                 .orderByAsc(PlanArea::getSort)
                           );
                        List<ProjectAreaDTO> areaDTOList = areaList.stream()
                           .map(
                              a -> {
                                 ProjectAreaDTO areaDTO = BeanUtil.copy(a, ProjectAreaDTO.class);
                                 ProjectSupplierAreaLink supplierAreaLink = this.supplierAreaLinkService
                                    .getOne(
                                       Wrappers.lambdaQuery(ProjectSupplierAreaLink.class)
                                          .eq(ProjectSupplierAreaLink::getAreaId, a.getId())
                                          .eq(ProjectSupplierAreaLink::getBoolRelationStatus, true)
                                          .eq(ProjectSupplierAreaLink::getBoolSettlementStatus, false)
                                    );
                                 if (supplierAreaLink != null) {
                                    areaDTO.setSupplierId(supplierAreaLink.getSupplierId());
                                    Supplier supplier = this.supplierService.getById(supplierAreaLink.getSupplierId());
                                    areaDTO.setSupplierName(supplier.getName());
                                 }

                                 PlanDetail detail = this.planDetailService
                                    .getOne(
                                       Wrappers.lambdaQuery(PlanDetail.class)
                                          .eq(PlanDetail::getAreaId, a.getId())
                                          .eq(PlanDetail::getType, PlanDetailTypeEnum.INSTALL_PLAN.getType())
                                    );
                                 if (detail != null) {
                                    areaDTO.setStartDate(detail.getStartDate());
                                    areaDTO.setEndDate(detail.getEndDate());
                                 }

                                 return areaDTO;
                              }
                           )
                           .collect(Collectors.toList());
                        monomerDetailDTO.setAreaList(areaDTOList);
                        return monomerDetailDTO;
                     }
                  )
                  .collect(Collectors.toList());
               monomerDTO.setMonomerDetailList(monomerDetailDTOList);
               return monomerDTO;
            }
         )
         .collect(Collectors.toList());
      return new ListVO<>(monomerDTOS);
   }

   @Override
   public ListVO<ProjectManagePlanMonomerVO> listInstallPlanV4(Long projectId, Long monomerId) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在");
      Preconditions.checkArgument(project.getBusinessType().equals(ProjectBusinessTypeEnum.JOB.getType()), "该项目类型是加工承揽订单");
      List<SupplierInfo> supplierInfoList = this.getCanInstallSupplierInfoList(projectId);
      List<PlanMonomer> planMonomerList = this.monomerService
         .list(
            Wrappers.lambdaQuery(PlanMonomer.class)
               .eq(PlanMonomer::getProjectId, projectId)
               .eq(monomerId != null, PlanMonomer::getId, monomerId)
               .orderByAsc(PlanMonomer::getSort)
         );
      List<ProjectManagePlanMonomerVO> monomerDTOS = planMonomerList.stream()
         .map(
            m -> {
               ProjectManagePlanMonomerVO monomerDTO = BeanUtil.copy(m, ProjectManagePlanMonomerVO.class);
               monomerDTO.setSupplierList(supplierInfoList);
               List<PlanArea> areaList = this.areaService
                  .list(Wrappers.lambdaQuery(PlanArea.class).eq(PlanArea::getMonomerId, m.getId()).orderByAsc(PlanArea::getSort));
               List<ProjectManagePlanAreaVO> areaDTOList = areaList.stream()
                  .filter(e -> !ProjectPlanProductCategoryEnum.ACCESSORY.getType().equals(e.getProjectPlanProductCategory()))
                  .map(
                     a -> {
                        ProjectManagePlanAreaVO areaDTO = BeanUtil.copy(a, ProjectManagePlanAreaVO.class);
                        areaDTO.setDeepenMete(this.productBiz.getDeepenMeteV2(a.getId()).getMete());
                        ProjectSupplierAreaLink supplierAreaLink = this.supplierAreaLinkService
                           .list(
                              Wrappers.lambdaQuery(ProjectSupplierAreaLink.class)
                                 .eq(ProjectSupplierAreaLink::getAreaId, a.getId())
                                 .eq(ProjectSupplierAreaLink::getBoolRelationStatus, true)
                                 .eq(ProjectSupplierAreaLink::getBoolSettlementStatus, false)
                           )
                           .stream()
                           .findFirst()
                           .orElse(null);
                        if (supplierAreaLink != null) {
                           areaDTO.setSupplierId(supplierAreaLink.getSupplierId());
                           Supplier supplier = this.supplierService.getById(supplierAreaLink.getSupplierId());
                           areaDTO.setSupplierName(supplier.getName());
                        }

                        return areaDTO;
                     }
                  )
                  .filter(e -> e.getDeepenMete() != null && e.getDeepenMete().compareTo(BigDecimal.ZERO) > 0)
                  .collect(Collectors.toList());
               monomerDTO.setManageAreaList(areaDTOList);
               return monomerDTO;
            }
         )
         .filter(e -> CollectionUtils.isNotEmpty(e.getManageAreaList()))
         .collect(Collectors.toList());
      return new ListVO<>(monomerDTOS);
   }

   @Override
   public List<SupplierInfo> getInstallOrderSupplierInfoList(Long projectId) {
      return this.getCanInstallSupplierInfoList(projectId);
   }

   private List<SupplierInfo> getCanInstallSupplierInfoList(Long projectId) {
      List<Long> orderSupplierIds = this.subcontractOrderService
         .list(
            Wrappers.lambdaQuery(SubcontractOrder.class)
               .eq(SubcontractOrder::getProjectId, projectId)
               .eq(SubcontractOrder::getSubcontractClassId, ScmConstants.LABOR_SUB_ID)
               .select(SubcontractOrder::getSupplierId)
         )
         .stream()
         .map(SubcontractOrder::getSupplierId)
         .collect(Collectors.toList());
      return CollectionUtils.isEmpty(orderSupplierIds)
         ? new ArrayList<>()
         : this.supplierService
            .listByIds(orderSupplierIds)
            .stream()
            .map(e -> SupplierInfo.builder().supplierId(e.getId()).supplierName(e.getName()).build())
            .collect(Collectors.toList());
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean setInstallPlan(ProjectInstallPlanDTOParam param) {
      PlanArea area = this.areaService.getById(param.getId());
      Preconditions.checkArgument(area != null, "区域不存在");
      ContractProject project = this.projectService.checkProjectStatus(area.getProjectId());
      Preconditions.checkArgument(project.getBusinessType().equals(ProjectBusinessTypeEnum.JOB.getType()), "项目不是承包订单");
      area.setInstallStartDate(param.getStartDate());
      area.setInstallEndDate(param.getEndDate());
      this.areaService.updateById(area);
      this.saveAreaSupplierLink(area, param.getSupplierId());
      return true;
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean setInstallPlanV2(ProjectInstallPlanDTOParam param) {
      PlanArea area = this.areaService.getById(param.getId());
      Preconditions.checkArgument(area != null, "区域不存在");
      ContractProject project = this.projectService.checkProjectStatus(area.getProjectId());
      Preconditions.checkArgument(project.getBusinessType().equals(ProjectBusinessTypeEnum.JOB.getType()), "项目不是承包订单");
      Preconditions.checkArgument(!param.getEndDate().isAfter(project.getEndDate()), "区域完工日期,不能晚于项目完工日期！");
      area.setInstallStartDate(param.getStartDate());
      area.setInstallEndDate(param.getEndDate());
      this.areaService.updateById(area);
      this.saveAreaSupplierLinkV2(area, param.getSupplierId());
      return true;
   }

   private void saveInstallPlan(PlanArea area, LocalDate startDate, LocalDate endDate) {
      PlanDetail planDetail = this.planDetailService
         .getOne(
            Wrappers.lambdaQuery(PlanDetail.class).eq(PlanDetail::getAreaId, area.getId()).eq(PlanDetail::getType, PlanDetailTypeEnum.INSTALL_PLAN.getType())
         );
      if (planDetail == null) {
         planDetail = PlanDetail.builder()
            .projectId(area.getProjectId())
            .monomerId(area.getMonomerId())
            .areaId(area.getId())
            .areaProductType(area.getProductType())
            .productCategory(area.getProductCategory())
            .type(PlanDetailTypeEnum.INSTALL_PLAN.getType())
            .startDate(startDate)
            .endDate(endDate)
            .build();
         this.planDetailService.save(planDetail);
      } else {
         planDetail.setStartDate(startDate);
         planDetail.setEndDate(endDate);
         this.planDetailService.updateById(planDetail);
      }
   }

   private void saveAreaSupplierLink(PlanArea area, Long supplierId) {
      if (supplierId == null) {
         List<ProjectSupplierAreaLink> supplierAreaLinkList = this.supplierAreaLinkService
            .list(
               Wrappers.lambdaQuery(ProjectSupplierAreaLink.class)
                  .eq(ProjectSupplierAreaLink::getBoolRelationStatus, true)
                  .eq(ProjectSupplierAreaLink::getAreaId, area.getId())
                  .eq(ProjectSupplierAreaLink::getSubcontractClassId, ScmConstants.LABOR_SUB_ID)
                  .eq(ProjectSupplierAreaLink::getBoolSettlementStatus, false)
            );
         supplierAreaLinkList.forEach(supplierAreaLink -> {
            supplierAreaLink.setBoolRelationStatus(false);
            supplierAreaLink.setBreakTime(LocalDateTime.now());
            this.supplierAreaLinkService.updateById(supplierAreaLink);
            this.supplierAccountBiz.shutDownAccount(supplierAreaLink.getSupplierId());
         });
      }

      if (supplierId != null) {
         Supplier supplier = this.supplierService.getById(supplierId);
         Preconditions.checkArgument(supplier != null, "分包供应商不存在");
         List<SubcontractOrder> subcontractOrderList = this.subcontractOrderService
            .list(
               Wrappers.lambdaQuery(SubcontractOrder.class)
                  .eq(SubcontractOrder::getProjectId, area.getProjectId())
                  .eq(SubcontractOrder::getSubcontractClassId, ScmConstants.LABOR_SUB_ID)
                  .eq(SubcontractOrder::getSupplierId, supplierId)
            );
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(subcontractOrderList), "供应商不存在劳务订单");
         List<ProjectSupplierAreaLink> supplierAreaLinkList = this.supplierAreaLinkService
            .list(
               Wrappers.lambdaQuery(ProjectSupplierAreaLink.class)
                  .eq(ProjectSupplierAreaLink::getBoolRelationStatus, true)
                  .eq(ProjectSupplierAreaLink::getBoolSettlementStatus, false)
                  .eq(ProjectSupplierAreaLink::getAreaId, area.getId())
                  .eq(ProjectSupplierAreaLink::getSubcontractClassId, ScmConstants.LABOR_SUB_ID)
            );
         supplierAreaLinkList.forEach(supplierAreaLink -> {
            if (!supplierAreaLink.getSupplierId().equals(supplierId)) {
               supplierAreaLink.setBoolRelationStatus(false);
               supplierAreaLink.setBreakTime(LocalDateTime.now());
               this.supplierAreaLinkService.updateById(supplierAreaLink);
               this.supplierAccountBiz.shutDownAccount(supplierAreaLink.getSupplierId());
            } else {
               this.supplierAreaLinkService.removeById(supplierAreaLink.getId());
            }
         });
         subcontractOrderList.forEach(
            subcontractOrder -> {
               ProjectSupplierAreaLink supplierAreaLink = ProjectSupplierAreaLink.builder()
                  .projectId(area.getProjectId())
                  .monomerId(area.getMonomerId())
                  .areaId(area.getId())
                  .supplierId(supplierId)
                  .supplierName(supplier.getName())
                  .boolRelationStatus(true)
                  .subcontractOrderId(subcontractOrder.getId())
                  .subcontractClassId(subcontractOrder.getSubcontractClassId())
                  .boolSettlementStatus(subcontractOrder.getBoolSettlementStatus())
                  .build();
               this.supplierAreaLinkService.save(supplierAreaLink);
               this.supplierAccountBiz.buildAccount(supplierId);
            }
         );
      }
   }

   private void saveAreaSupplierLinkV2(PlanArea area, Long supplierId) {
      if (supplierId == null) {
         List<ProjectSupplierAreaLink> supplierAreaLinkList = this.supplierAreaLinkService
            .list(
               Wrappers.lambdaQuery(ProjectSupplierAreaLink.class)
                  .eq(ProjectSupplierAreaLink::getBoolRelationStatus, true)
                  .eq(ProjectSupplierAreaLink::getAreaId, area.getId())
                  .eq(ProjectSupplierAreaLink::getSubcontractClassId, ScmConstants.LABOR_SUB_ID)
                  .eq(ProjectSupplierAreaLink::getBoolSettlementStatus, false)
            );
         supplierAreaLinkList.forEach(supplierAreaLink -> {
            supplierAreaLink.setBoolRelationStatus(false);
            supplierAreaLink.setBreakTime(LocalDateTime.now());
            this.supplierAreaLinkService.updateById(supplierAreaLink);
         });
      }

      if (supplierId != null) {
         Supplier supplier = this.supplierService.getById(supplierId);
         Preconditions.checkArgument(supplier != null, "分包供应商不存在");
         List<SubcontractOrder> subcontractOrderList = this.subcontractOrderService
            .list(
               Wrappers.lambdaQuery(SubcontractOrder.class)
                  .eq(SubcontractOrder::getProjectId, area.getProjectId())
                  .eq(SubcontractOrder::getSubcontractClassId, ScmConstants.LABOR_SUB_ID)
                  .eq(SubcontractOrder::getSupplierId, supplierId)
            );
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(subcontractOrderList), "供应商不存在劳务订单");
         List<ProjectSupplierAreaLink> supplierAreaLinkList = this.supplierAreaLinkService
            .list(
               Wrappers.lambdaQuery(ProjectSupplierAreaLink.class)
                  .eq(ProjectSupplierAreaLink::getBoolRelationStatus, true)
                  .eq(ProjectSupplierAreaLink::getBoolSettlementStatus, false)
                  .eq(ProjectSupplierAreaLink::getAreaId, area.getId())
                  .eq(ProjectSupplierAreaLink::getSubcontractClassId, ScmConstants.LABOR_SUB_ID)
            );
         supplierAreaLinkList.forEach(supplierAreaLink -> {
            if (!supplierAreaLink.getSupplierId().equals(supplierId)) {
               supplierAreaLink.setBoolRelationStatus(false);
               supplierAreaLink.setBreakTime(LocalDateTime.now());
               this.supplierAreaLinkService.updateById(supplierAreaLink);
            } else {
               this.supplierAreaLinkService.removeById(supplierAreaLink.getId());
            }
         });
         subcontractOrderList.forEach(
            subcontractOrder -> {
               ProjectSupplierAreaLink supplierAreaLink = ProjectSupplierAreaLink.builder()
                  .projectId(area.getProjectId())
                  .monomerId(area.getMonomerId())
                  .areaId(area.getId())
                  .supplierId(supplierId)
                  .supplierName(supplier.getName())
                  .boolRelationStatus(true)
                  .subcontractOrderId(subcontractOrder.getId())
                  .subcontractClassId(subcontractOrder.getSubcontractClassId())
                  .boolSettlementStatus(subcontractOrder.getBoolSettlementStatus())
                  .build();
               this.supplierAreaLinkService.save(supplierAreaLink);
            }
         );
      }
   }

   @Override
   public List<ProjectSupplierAccountDTO> listInstallSupplier(Long projectId, Long monomerId) {
      List<ProjectSupplierAccountDO> supplierAccountDOList = this.supplierAccountService.listInstallSupplier(projectId, monomerId);
      return supplierAccountDOList.stream()
         .map(
            s -> {
               ProjectSupplierAccountDTO supplierAccountDTO = BeanUtil.copy(s, ProjectSupplierAccountDTO.class);
               List<ProjectSupplierAreaLink> linkList = this.supplierAreaLinkService
                  .list(
                     Wrappers.lambdaQuery(ProjectSupplierAreaLink.class)
                        .eq(ProjectSupplierAreaLink::getProjectId, projectId)
                        .eq(monomerId != null, ProjectSupplierAreaLink::getMonomerId, monomerId)
                        .eq(ProjectSupplierAreaLink::getSupplierId, s.getSupplierId())
                        .orderByDesc(ProjectSupplierAreaLink::getBoolRelationStatus)
                        .orderByAsc(ProjectSupplierAreaLink::getAreaId)
                  );
               List<ProjectAreaMeteDTO> projectAreaMeteDTOList = linkList.stream().map(link -> {
                  PlanArea area = this.areaService.getById(link.getAreaId());
                  ProjectAreaMeteDTO areaMeteDTO = BeanUtil.copy(area, ProjectAreaMeteDTO.class);
                  areaMeteDTO.setBoolRelationStatus(link.getBoolRelationStatus());
                  areaMeteDTO.setBoolSettlementStatus(link.getBoolSettlementStatus());
                  ProductMeteDTO deepenMete = this.productBiz.getDeepenMete(area.getId());
                  areaMeteDTO.setQuantity(BigDecimal.valueOf(deepenMete.getQuantity().intValue()));
                  areaMeteDTO.setMete(deepenMete.getMete());
                  return areaMeteDTO;
               }).collect(Collectors.toList());
               supplierAccountDTO.setProjectAreaDTOList(projectAreaMeteDTOList);
               return supplierAccountDTO;
            }
         )
         .collect(Collectors.toList());
   }

   @Override
   public List<ProjectProductInstallSummaryDTO> listProductInstallSummary(
      Long projectId, Long monomerId, Integer monomerDetailType, Long areaId, Long supplierId
   ) {
      List<ProjectProductInstallSummaryDO> installSummaryDOList = this.installReportService
         .listProductInstallSum(projectId, monomerId, monomerDetailType, areaId, supplierId);
      return installSummaryDOList.stream().map(summaryDO -> {
         ProjectProductInstallSummaryDTO summaryDTO = BeanUtil.copy(summaryDO, ProjectProductInstallSummaryDTO.class);
         if (summaryDO.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
            TechArtifact artifact = this.artifactService.getById(summaryDO.getProductId());
            BeanUtil.copy(artifact, summaryDTO);
         }

         if (summaryDO.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
            TechEnclosure enclosure = this.enclosureService.getById(summaryDO.getProductId());
            BeanUtil.copy(enclosure, summaryDTO);
            summaryDTO.setActualMete(summaryDO.getActualMete().divide(BigDecimal.valueOf(1000L)));
         }

         if (summaryDO.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
            TechAuxiliaryMaterial auxiliaryMaterial = this.auxiliaryMaterialService.getById(summaryDO.getProductId());
            BeanUtil.copy(auxiliaryMaterial, summaryDTO);
            summaryDTO.setName(auxiliaryMaterial.getClassifyName());
         }

         return summaryDTO;
      }).collect(Collectors.toList());
   }
}
