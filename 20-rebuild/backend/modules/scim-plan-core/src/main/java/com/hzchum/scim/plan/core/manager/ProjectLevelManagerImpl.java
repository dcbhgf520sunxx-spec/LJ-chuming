package com.hzchum.scim.plan.core.manager;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.scim.common.core.api.enums.BranchCompanyLevelEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo._do.ProjectBranchCompanyLink;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.ProjectBranchCompanyLinkService;
import com.hzchum.scim.plan.core.api.enums.AreaTypeEnum;
import com.hzchum.scim.plan.core.api.manager.ProjectLevelManager;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.scm.core.api.pojo._do.ApplyPurchase;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrder;
import com.hzchum.scim.scm.core.api.service.ApplyPurchaseService;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.wms.core.api.enums.DataStatusEnum;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundService;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectLevelManagerImpl implements ProjectLevelManager {
   private final ContractProjectService contractProjectService;
   private final PlanAreaService areaService;
   private final BranchCompanyService branchCompanyService;
   private final PurchaseOrderService purchaseOrderService;
   private final ProjectBranchCompanyLinkService projectBranchCompanyLinkService;
   private final ApplyPurchaseService applyPurchaseService;
   private final InboundService inboundService;

   @Override
   public void saveAreaByType(Long projectId, Integer type) {
      ContractProject project = this.contractProjectService.getById(projectId);
      if (BranchCompanyLevelEnum.PRIMARY_UNIT.getType().equals(project.getLevel()) && AreaTypeEnum.PROCESS.getType().equals(type)) {
         project.setLevel(BranchCompanyLevelEnum.PRIMARY_UNIT.getType() | BranchCompanyLevelEnum.SECONDARY_UNIT.getType());
         List<ProjectBranchCompanyLink> projectBranchCompanyLinkServiceOne = this.projectBranchCompanyLinkService
            .list(
               Wrappers.lambdaQuery(ProjectBranchCompanyLink.class)
                  .eq(ProjectBranchCompanyLink::getBranchCompanyLevel, 2)
                  .eq(ProjectBranchCompanyLink::getProjectId, projectId)
            );
         if (CollectionUtils.isEmpty(projectBranchCompanyLinkServiceOne)) {
            BranchCompany one = this.branchCompanyService.getOne(Wrappers.lambdaQuery(BranchCompany.class).eq(BranchCompany::getLevel, 2));
            ProjectBranchCompanyLink projectBranchCompanyLink = ProjectBranchCompanyLink.builder()
               .branchCompanyId(one.getId())
               .branchCompanyLevel(one.getLevel())
               .projectId(project.getId())
               .build();
            this.projectBranchCompanyLinkService.save(projectBranchCompanyLink);
         }

         this.contractProjectService.updateById(project);
      }
   }

   @Transactional
   @Override
   public void updateAreaByType(Long projectId, Long areaId, Integer oldType, Integer newType) {
      if (!oldType.equals(newType)) {
         ContractProject project = this.contractProjectService.getById(projectId);
         PlanArea area = this.areaService.getById(areaId);
         if (BranchCompanyLevelEnum.PRIMARY_UNIT.getType().equals(project.getLevel()) && AreaTypeEnum.PROCESS.getType().equals(area.getType())) {
            project.setLevel(BranchCompanyLevelEnum.PRIMARY_UNIT.getType() | BranchCompanyLevelEnum.SECONDARY_UNIT.getType());
            this.contractProjectService.updateById(project);
            ProjectBranchCompanyLink projectBranchCompanyLinkServiceOne = this.projectBranchCompanyLinkService
               .getOne(
                  Wrappers.lambdaQuery(ProjectBranchCompanyLink.class)
                     .eq(ProjectBranchCompanyLink::getBranchCompanyLevel, 2)
                     .eq(ProjectBranchCompanyLink::getProjectId, projectId)
               );
            if (projectBranchCompanyLinkServiceOne == null) {
               BranchCompany one = this.branchCompanyService.getOne(Wrappers.lambdaQuery(BranchCompany.class).eq(BranchCompany::getLevel, 2));
               ProjectBranchCompanyLink projectBranchCompanyLink = ProjectBranchCompanyLink.builder()
                  .branchCompanyId(one.getId())
                  .branchCompanyLevel(one.getLevel())
                  .projectId(project.getId())
                  .build();
               this.projectBranchCompanyLinkService.save(projectBranchCompanyLink);
            }
         }

         if (area.getType().equals(AreaTypeEnum.EPIBOLY.getType())
            && project.getLevel().equals(BranchCompanyLevelEnum.PRIMARY_UNIT.getType() | BranchCompanyLevelEnum.SECONDARY_UNIT.getType())) {
            List<PlanArea> areaList = this.areaService
               .list(
                  (Wrapper<PlanArea>)(new LambdaQueryWrapper<PlanArea>().eq(PlanArea::getType, AreaTypeEnum.EPIBOLY.getType()))
                     .ne(PlanArea::getId, area.getId())
               );
            if (CollectionUtils.isEmpty(areaList)) {
               this.boolUpdateProject(projectId);
               this.checkOrder(project.getId());
               project.setLevel(BranchCompanyLevelEnum.PRIMARY_UNIT.getType());
               this.contractProjectService.updateById(project);
               ProjectBranchCompanyLink projectBranchCompanyLinkServiceOne = this.projectBranchCompanyLinkService
                  .getOne(
                     Wrappers.lambdaQuery(ProjectBranchCompanyLink.class)
                        .eq(ProjectBranchCompanyLink::getBranchCompanyLevel, 2)
                        .eq(ProjectBranchCompanyLink::getProjectId, projectId)
                  );
               if (projectBranchCompanyLinkServiceOne != null) {
                  this.projectBranchCompanyLinkService.removeById(projectBranchCompanyLinkServiceOne.getId());
               }
            }
         }
      }
   }

   @Transactional
   @Override
   public void removeAreaByIds(List<Long> areaIds) {
      List<PlanArea> planAreas = this.areaService.listByIds(areaIds);
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(planAreas) && planAreas.size() == areaIds.size(), "区域不存在!");
      Map<Long, PlanArea> areaMap = planAreas.stream().collect(Collectors.toMap(PlanArea::getId, Function.identity()));
      Map<Long, List<PlanArea>> areaProjectMap = planAreas.stream()
         .filter(e -> e.getType().equals(AreaTypeEnum.PROCESS.getType()))
         .collect(Collectors.groupingBy(PlanArea::getProjectId));
      if (CollectionUtils.isNotEmpty(areaProjectMap)) {
         List<ContractProject> contractProjects = this.contractProjectService
            .list(
               (Wrapper<ContractProject>)(new LambdaQueryWrapper<ContractProject>().in(ContractProject::getId, areaProjectMap.keySet()))
                  .eq(ContractProject::getLevel, BranchCompanyLevelEnum.PRIMARY_UNIT.getType() | BranchCompanyLevelEnum.SECONDARY_UNIT.getType())
            );
         if (CollectionUtils.isNotEmpty(contractProjects)) {
            for (ContractProject project : contractProjects) {
               List<PlanArea> areas = areaProjectMap.get(project.getId());
               List<PlanArea> areaList = this.areaService
                  .list(
                     (Wrapper<PlanArea>)((new LambdaQueryWrapper<PlanArea>().eq(PlanArea::getProjectId, project.getId()))
                           .eq(PlanArea::getType, AreaTypeEnum.PROCESS.getType()))
                        .notIn(PlanArea::getId, areas.stream().map(PlanArea::getId).collect(Collectors.toList()))
                  );
               if (CollectionUtils.isEmpty(areaList)) {
                  this.boolUpdateProject(project.getId());
                  this.checkOrder(project.getId());
                  project.setLevel(BranchCompanyLevelEnum.PRIMARY_UNIT.getType());
                  this.contractProjectService.updateById(project);
                  ProjectBranchCompanyLink projectBranchCompanyLinkServiceOne = this.projectBranchCompanyLinkService
                     .getOne(
                        Wrappers.lambdaQuery(ProjectBranchCompanyLink.class)
                           .eq(ProjectBranchCompanyLink::getBranchCompanyLevel, 2)
                           .eq(ProjectBranchCompanyLink::getProjectId, project.getId())
                     );
                  if (projectBranchCompanyLinkServiceOne != null) {
                     this.projectBranchCompanyLinkService.removeById(projectBranchCompanyLinkServiceOne.getId());
                  }
               }
            }
         }
      }
   }

   @Override
   public void boolUpdateProjectBranchCompany(Long projectId, Long branchCompanyId) {
      ContractProject project = this.contractProjectService.getById(projectId);
      BranchCompany branchCompany = this.branchCompanyService.getById(branchCompanyId);
      if ((project.getLevel() & BranchCompanyLevelEnum.PRIMARY_UNIT.getType()) > 0
         && branchCompany.getLevel().equals(BranchCompanyLevelEnum.SECONDARY_UNIT.getType())) {
         this.boolUpdateProject(project.getId());
      }
   }

   @Override
   public void updateProjectBranchCompany(Long projectId, Long branchCompanyId) {
      ContractProject project = this.contractProjectService.getById(projectId);
      BranchCompany branchCompany = this.branchCompanyService.getById(branchCompanyId);
      if ((project.getLevel() & BranchCompanyLevelEnum.PRIMARY_UNIT.getType()) > 0
         && branchCompany.getLevel().equals(BranchCompanyLevelEnum.SECONDARY_UNIT.getType())) {
         this.boolUpdateProject(project.getId());
         this.projectBranchCompanyLinkService
            .remove(
               Wrappers.lambdaUpdate(ProjectBranchCompanyLink.class)
                  .eq(ProjectBranchCompanyLink::getProjectId, projectId)
                  .eq(ProjectBranchCompanyLink::getBranchCompanyLevel, BranchCompanyLevelEnum.PRIMARY_UNIT.getType())
            );
         if (project.getLevel() == 1) {
            ProjectBranchCompanyLink projectBranchCompanyLink = ProjectBranchCompanyLink.builder()
               .branchCompanyId(branchCompanyId)
               .projectId(projectId)
               .branchCompanyLevel(BranchCompanyLevelEnum.SECONDARY_UNIT.getType())
               .build();
            this.projectBranchCompanyLinkService.save(projectBranchCompanyLink);
         }

         project.setLevel(BranchCompanyLevelEnum.SECONDARY_UNIT.getType());
         this.contractProjectService.updateWithCache(project);
      }

      if (project.getLevel().equals(BranchCompanyLevelEnum.SECONDARY_UNIT.getType())
         && branchCompany.getLevel().equals(BranchCompanyLevelEnum.SECONDARY_UNIT.getType())) {
         this.projectBranchCompanyLinkService
            .remove(Wrappers.lambdaUpdate(ProjectBranchCompanyLink.class).eq(ProjectBranchCompanyLink::getProjectId, projectId));
         ProjectBranchCompanyLink projectBranchCompanyLink = ProjectBranchCompanyLink.builder()
            .branchCompanyId(branchCompanyId)
            .projectId(projectId)
            .branchCompanyLevel(BranchCompanyLevelEnum.SECONDARY_UNIT.getType())
            .build();
         this.projectBranchCompanyLinkService.save(projectBranchCompanyLink);
         project.setLevel(BranchCompanyLevelEnum.SECONDARY_UNIT.getType());
         this.contractProjectService.updateWithCache(project);
      }

      if (project.getLevel().equals(BranchCompanyLevelEnum.SECONDARY_UNIT.getType())
         && branchCompany.getLevel().equals(BranchCompanyLevelEnum.PRIMARY_UNIT.getType())) {
         this.projectBranchCompanyLinkService
            .remove(Wrappers.lambdaUpdate(ProjectBranchCompanyLink.class).eq(ProjectBranchCompanyLink::getProjectId, projectId));
         ProjectBranchCompanyLink projectBranchCompanyLink = ProjectBranchCompanyLink.builder()
            .branchCompanyId(branchCompanyId)
            .projectId(projectId)
            .branchCompanyLevel(BranchCompanyLevelEnum.PRIMARY_UNIT.getType())
            .build();
         this.projectBranchCompanyLinkService.save(projectBranchCompanyLink);
         project.setLevel(BranchCompanyLevelEnum.PRIMARY_UNIT.getType());
         this.contractProjectService.updateWithCache(project);
      }

      if (project.getLevel().equals(BranchCompanyLevelEnum.PRIMARY_UNIT.getType())
         && branchCompany.getLevel().equals(BranchCompanyLevelEnum.PRIMARY_UNIT.getType())) {
         this.projectBranchCompanyLinkService
            .remove(
               Wrappers.lambdaUpdate(ProjectBranchCompanyLink.class)
                  .eq(ProjectBranchCompanyLink::getProjectId, projectId)
                  .eq(ProjectBranchCompanyLink::getBranchCompanyLevel, BranchCompanyLevelEnum.PRIMARY_UNIT.getType())
            );
         ProjectBranchCompanyLink projectBranchCompanyLink = ProjectBranchCompanyLink.builder()
            .branchCompanyId(branchCompanyId)
            .projectId(projectId)
            .branchCompanyLevel(BranchCompanyLevelEnum.PRIMARY_UNIT.getType())
            .build();
         this.projectBranchCompanyLinkService.save(projectBranchCompanyLink);
         project.setLevel(BranchCompanyLevelEnum.PRIMARY_UNIT.getType());
         this.contractProjectService.updateWithCache(project);
      }
   }

   private void boolUpdateProject(Long projectId) {
      List<ApplyPurchase> applyPurchases = this.applyPurchaseService
         .list(
            (Wrapper<ApplyPurchase>)(new LambdaQueryWrapper<ApplyPurchase>()
                  .in(
                     ApplyPurchase::getDataStatus,
                     DataStatusEnum.SUCCEED.getType(),
                     DataStatusEnum.UNDER_REVIEW.getType(),
                     DataStatusEnum.CANCELLATION_UNDER_WAY.getType()
                  ))
               .and(
                  a -> {
                     LambdaQueryWrapper var10000 = ((a.eq(ApplyPurchase::getProjectId, projectId))
                           .or())
                        .last("and find_in_set(" + projectId + ",project_ids)");
                  }
               )
         );
      Preconditions.checkArgument(applyPurchases.isEmpty(), "物料申购单已关联该项目，并且申购单状态为已通过或审批中或作废中！！！");
      List<PurchaseOrder> purchaseOrders = this.purchaseOrderService
         .list(
            (Wrapper<PurchaseOrder>)(new LambdaQueryWrapper<PurchaseOrder>()
                  .in(
                     PurchaseOrder::getDataStatus,
                     DataStatusEnum.SUCCEED.getType(),
                     DataStatusEnum.UNDER_REVIEW.getType(),
                     DataStatusEnum.CANCELLATION_UNDER_WAY.getType()
                  ))
               .last("and find_in_set(" + projectId + ",project_ids)")
         );
      Preconditions.checkArgument(purchaseOrders.isEmpty(), "物料采购单已关联该项目，并且采购单状态为已通过或审批中或作废中！！！");
   }

   private Boolean checkOrder(Long projectId) {
      List<PurchaseOrder> purchaseOrders = this.purchaseOrderService
         .list(Wrappers.lambdaQuery(PurchaseOrder.class).isNotNull(PurchaseOrder::getProjectIds))
         .stream()
         .filter(e -> Arrays.asList(e.getProjectIds().split(",")).contains(projectId.toString()))
         .collect(Collectors.toList());
      return CollectionUtils.isNotEmpty(purchaseOrders);
   }

   public ProjectLevelManagerImpl(
      final ContractProjectService contractProjectService,
      final PlanAreaService areaService,
      final BranchCompanyService branchCompanyService,
      final PurchaseOrderService purchaseOrderService,
      final ProjectBranchCompanyLinkService projectBranchCompanyLinkService,
      final ApplyPurchaseService applyPurchaseService,
      final InboundService inboundService
   ) {
      this.contractProjectService = contractProjectService;
      this.areaService = areaService;
      this.branchCompanyService = branchCompanyService;
      this.purchaseOrderService = purchaseOrderService;
      this.projectBranchCompanyLinkService = projectBranchCompanyLinkService;
      this.applyPurchaseService = applyPurchaseService;
      this.inboundService = inboundService;
   }
}
