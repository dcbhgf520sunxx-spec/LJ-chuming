package com.hzchum.scim.project.core.biz.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.common.SupplierInfo;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.common.core.api.utils.PageUtils;
import com.hzchum.scim.contract.core.api.enums.DivideMethodEnum;
import com.hzchum.scim.contract.core.api.enums.EnclosureMeasureModeEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectBusinessTypeEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectTypeEnum;
import com.hzchum.scim.contract.core.api.enums.ReportMethodEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectSimpleInfoDTO;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.ContractTechService;
import com.hzchum.scim.mes.building.core.api.enums.laborManagement.EmployeeStatusEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.attend.MesBuildingAttendanceOverConfig;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.attend.MesBuildingAttendanceOverConfigUserLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.laborManagement.MesRoster;
import com.hzchum.scim.mes.building.core.api.service.attend.MesBuildingAttendanceOverConfigService;
import com.hzchum.scim.mes.building.core.api.service.attend.MesBuildingAttendanceOverConfigUserLinkService;
import com.hzchum.scim.mes.building.core.api.service.laborManagement.MesRosterService;
import com.hzchum.scim.plan.core.api.biz.ProductBiz;
import com.hzchum.scim.plan.core.api.enums.PlanDetailTypeEnum;
import com.hzchum.scim.plan.core.api.enums.ProjectPlanProductCategoryEnum;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechEnclosure;
import com.hzchum.scim.plan.core.api.pojo.dto.ProductMeteDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.product.TechProductDTO;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanDetailService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAuxiliaryPartService;
import com.hzchum.scim.plan.core.api.service.TechEnclosureService;
import com.hzchum.scim.project.core.api.biz.ProjectInstallBiz;
import com.hzchum.scim.project.core.api.biz.ProjectSubcontractManageBiz;
import com.hzchum.scim.project.core.api.enums.AttendStatusEnum;
import com.hzchum.scim.project.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.project.core.api.enums.ProjectManageMenuTaskEnum;
import com.hzchum.scim.project.core.api.enums.QhseStatusEnumV2;
import com.hzchum.scim.project.core.api.pojo._do.ProjectInstallReport;
import com.hzchum.scim.project.core.api.pojo._do.ProjectLaborSubsupplierOrderProductLink;
import com.hzchum.scim.project.core.api.pojo._do.ProjectManageRoster;
import com.hzchum.scim.project.core.api.pojo._do.ProjectQhseProblem;
import com.hzchum.scim.project.core.api.pojo._do.ProjectSupplierAreaLink;
import com.hzchum.scim.project.core.api.pojo._doModel.attend.ProjectManageAttendance;
import com.hzchum.scim.project.core.api.pojo.dao.ProjectAppInstallReportGroupDO;
import com.hzchum.scim.project.core.api.pojo.dao.ProjectInstallReportGroupDO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectAppInstallReportGroupDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectInstallBoardDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectInstallMeteSummaryDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectInstallReportDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectInstallReportGroupDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectInstallSummaryDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectManageModeTaskDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectReceivingInstallDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectReceivingMeteDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectSupplierInstallSummaryDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.InstallBoardQueryDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.InstallReportQueryDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.InstallStatementQueryDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ProjectBaseQueryDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.AppCheckInstallReportDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.CheckInstallReportDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.InstallReportDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectInstallReportSaveDTOParam;
import com.hzchum.scim.project.core.api.service.ProjectAuxiliaryMaterialClassService;
import com.hzchum.scim.project.core.api.service.ProjectInstallReportService;
import com.hzchum.scim.project.core.api.service.ProjectInstallSummaryService;
import com.hzchum.scim.project.core.api.service.ProjectLaborSubsupplierOrderProductLinkService;
import com.hzchum.scim.project.core.api.service.ProjectManageRosterService;
import com.hzchum.scim.project.core.api.service.ProjectQhseProblemService;
import com.hzchum.scim.project.core.api.service.ProjectReceivingSummaryService;
import com.hzchum.scim.project.core.api.service.ProjectSupplierAccountService;
import com.hzchum.scim.project.core.api.service.ProjectSupplierAreaLinkService;
import com.hzchum.scim.project.core.api.service.attend.ProjectManageAttendanceService;
import com.hzchum.scim.project.core.api.utils.ProjectInstallBizUtil;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import com.hzchum.scim.scm.core.api.pojo.dto.SupplierDTO;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.enums.UserTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.UserService;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.transaction.TransactionalException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectInstallBizImpl implements ProjectInstallBiz {
   private static final Logger log = LoggerFactory.getLogger(ProjectInstallBizImpl.class);
   @Resource
   private ProjectInstallReportService installReportService;
   @Resource
   private ProjectInstallBizUtil projectInstallBizUtil;
   @Resource
   private ProjectReceivingSummaryService receivingSummaryService;
   @Resource
   private ProjectSupplierAreaLinkService supplierAreaLinkService;
   @Resource
   private ProjectInstallSummaryService installSummaryService;
   @Resource
   private TechArtifactService artifactService;
   @Resource
   private TechEnclosureService enclosureService;
   @Resource
   private ContractProjectService projectService;
   @Resource
   private PlanMonomerService monomerService;
   @Resource
   private PlanAreaService areaService;
   @Resource
   private TechAuxiliaryPartService auxiliaryPartService;
   @Resource
   private UserService userService;
   @Resource
   private ProjectSupplierAccountService supplierAccountService;
   @Resource
   private PlanDetailService planDetailService;
   @Resource
   private ProductBiz productBiz;
   @Resource
   private SupplierService supplierService;
   @Resource
   private ProjectAuxiliaryMaterialClassService auxiliaryMaterialClassService;
   @Resource
   private ContractTechService contractTechService;
   @Resource
   private ProjectLaborSubsupplierOrderProductLinkService orderProductLinkService;
   @Resource
   private ProjectManageRosterService rosterService;
   @Resource
   private ProjectManageAttendanceService attendanceService;
   @Resource
   private ProjectSubcontractManageBiz subcontractManageBiz;
   @Resource
   private WmsApproveRecordService approveRecordService;
   @Resource
   private ProjectQhseProblemService qhseProblemService;
   @Resource
   private MesRosterService mesRosterService;
   @Resource
   private MesBuildingAttendanceOverConfigUserLinkService overConfigUserLinkService;
   @Resource
   private MesBuildingAttendanceOverConfigService overConfigService;

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public synchronized Boolean saveInstallReport(ProjectInstallReportSaveDTOParam saveDTOParam) {
      Long userId = UserUtil.getCurrentUserId();
      ContractProject project = this.projectService.checkProjectStatus(saveDTOParam.getProjectId());
      Preconditions.checkArgument(project.getBusinessType().equals(ProjectBusinessTypeEnum.JOB.getType()), "该项目类型为加工承揽订单");
      Preconditions.checkArgument(ReportMethodEnum.PC.getType().equals(project.getInstallReportMethod()), "该项目已设置为app端填报");
      saveDTOParam.getReportDTOParamList()
         .forEach(
            param -> {
               this.checkReportQuantity(project.getProjectType(), saveDTOParam.getProductType(), param);
               ProjectInstallReport report = ProjectInstallReport.builder()
                  .reportMethod(ReportMethodEnum.PC.getType())
                  .projectType(project.getProjectType())
                  .productType(saveDTOParam.getProductType())
                  .productId(param.getProductId())
                  .reportQuantity(param.getReportQuantity())
                  .auditStatus(AuditStatusEnum.AUDITING.getType())
                  .build();
               Long areaId = this.fillReport(report, param.getProductId());
               ProjectSupplierAreaLink supplierAreaLink = this.supplierAreaLinkService
                  .getOne(
                     Wrappers.lambdaQuery(ProjectSupplierAreaLink.class)
                        .eq(ProjectSupplierAreaLink::getAreaId, areaId)
                        .eq(ProjectSupplierAreaLink::getBoolRelationStatus, true)
                        .eq(ProjectSupplierAreaLink::getBoolSettlementStatus, false)
                  );
               Preconditions.checkArgument(supplierAreaLink != null, "填报失败,当前区域未指定分包商");
               report.setSupplierId(supplierAreaLink.getSupplierId());
               Supplier supplier = this.supplierService.getById(supplierAreaLink.getSupplierId());
               Preconditions.checkArgument(supplier != null, "填报失败,当前区域未分包商不存在");
               report.setSupplierName(supplier.getName());
               report.setAuditStatus(AuditStatusEnum.SUCCEED.getType());
               report.setActualQuantity(report.getReportQuantity());
               report.setActualMete(report.getReportMete());
               report.setActualTotalArea(report.getReportTotalArea());
               report.setAuditTime(LocalDateTime.now());
               report.setAuditUserId(userId);
               this.installReportService.save(report);
               this.installSummaryService.saveInstallSummary(report);
               this.receivingSummaryService.updateInstallQuantity(report);
               this.insertInstallPlanCompleteDate(project.getProjectType(), areaId);
            }
         );
      return true;
   }

   @Transactional
   @Override
   public Boolean saveInstallReportV2(ProjectInstallReportSaveDTOParam saveDTOParam) {
      Long userId = UserUtil.getCurrentUserId();
      ContractProject project = this.projectService.checkProjectStatus(saveDTOParam.getProjectId());
      Preconditions.checkArgument(project.getBusinessType().equals(ProjectBusinessTypeEnum.JOB.getType()), "该项目类型为加工承揽订单");
      Preconditions.checkArgument(ReportMethodEnum.PC.getType().equals(project.getInstallReportMethod()), "该项目已设置为app端填报");
      Integer installDivideMethod = project.getInstallDivideMethod();
      Preconditions.checkArgument(installDivideMethod != null, "操作失败！该项目安装划分方式未配置！");
      if (DivideMethodEnum.AREA.getType().equals(installDivideMethod)) {
         this.PCByAreaInstallReport(saveDTOParam, userId, project);
      }

      if (DivideMethodEnum.LIST.getType().equals(installDivideMethod)) {
         this.PCByListInstallReport(saveDTOParam, userId, project);
      }

      return true;
   }

   private void PCByListInstallReport(ProjectInstallReportSaveDTOParam saveDTOParam, Long userId, ContractProject project) {
      List<ProjectReceivingInstallDTO> installProductList = this.checkPCByListInstallReportDTOParam(saveDTOParam);
      Map<Long, ProjectReceivingInstallDTO> installProductMap = installProductList.stream()
         .collect(Collectors.toMap(ProjectReceivingInstallDTO::getProductId, Function.identity()));
      List<Long> supplierIds = installProductList.stream().map(ProjectReceivingInstallDTO::getSupplierId).distinct().collect(Collectors.toList());
      Map<Long, Supplier> supplierMap = this.supplierService.listByIds(supplierIds).stream().collect(Collectors.toMap(Supplier::getId, Function.identity()));
      saveDTOParam.getReportDTOParamList()
         .forEach(
            param -> {
               ProjectReceivingInstallDTO receivingInstallDTO = installProductMap.get(param.getProductId());
               Supplier supplier = supplierMap.get(receivingInstallDTO.getSupplierId());
               Preconditions.checkArgument(supplier != null, "操作失败！产品信息有误！");
               ProjectInstallReport report = ProjectInstallReport.builder()
                  .supplierId(supplier.getId())
                  .reportMethod(ReportMethodEnum.PC.getType())
                  .projectType(project.getProjectType())
                  .productType(saveDTOParam.getProductType())
                  .productId(param.getProductId())
                  .reportQuantity(param.getReportQuantity())
                  .auditStatus(AuditStatusEnum.AUDITING.getType())
                  .build();
               Long areaId = this.fillReportV2(report, param.getProductId());
               report.setUserId(userId);
               report.setSupplierName(supplier.getName());
               report.setAuditStatus(AuditStatusEnum.SUCCEED.getType());
               report.setActualQuantity(report.getReportQuantity());
               report.setActualMete(report.getReportMete());
               report.setActualTotalArea(report.getReportTotalArea());
               report.setAuditTime(LocalDateTime.now());
               report.setAuditUserId(userId);
               this.installReportService.save(report);
               this.installSummaryService.saveInstallSummary(report);
               this.receivingSummaryService.updateInstallQuantity(report);
               this.insertInstallPlanCompleteDateV2(project.getProjectType(), areaId);
               this.orderProductLinkService
                  .saveInstallInfo(project.getId(), supplier.getId(), saveDTOParam.getProductType(), param.getProductId(), param.getReportQuantity());
            }
         );
   }

   private List<ProjectReceivingInstallDTO> checkPCByListInstallReportDTOParam(ProjectInstallReportSaveDTOParam saveDTOParam) {
      ProjectBaseQueryDTOParam queryDTOParam = new ProjectBaseQueryDTOParam();
      queryDTOParam.setProjectId(saveDTOParam.getProjectId());
      queryDTOParam.setProductType(saveDTOParam.getProductType());
      List<ProjectReceivingInstallDTO> canInstallDTOList = this.receivingSummaryService.getListMethodReceivingInstall(queryDTOParam);
      Map<Long, ProjectReceivingInstallDTO> canInstallProductMap = canInstallDTOList.stream()
         .collect(Collectors.toMap(ProjectReceivingInstallDTO::getProductId, Function.identity()));
      Preconditions.checkArgument(
         saveDTOParam.getReportDTOParamList().stream().allMatch(e -> canInstallProductMap.containsKey(e.getProductId())), "操作失败！可填报产品已不存在,请刷新后重试！"
      );
      Preconditions.checkArgument(saveDTOParam.getReportDTOParamList().stream().allMatch(e -> {
         ProjectReceivingInstallDTO receivingInstallDTO = canInstallProductMap.get(e.getProductId());
         return receivingInstallDTO.getCanInstallQuantity().compareTo(e.getReportQuantity()) >= 0;
      }), "操作失败！填报数量大于可安装数量,请刷新后重试！");
      return canInstallDTOList.stream()
         .filter(
            e -> saveDTOParam.getReportDTOParamList().stream().map(InstallReportDTOParam::getProductId).collect(Collectors.toList()).contains(e.getProductId())
         )
         .collect(Collectors.toList());
   }

   private void PCByAreaInstallReport(ProjectInstallReportSaveDTOParam saveDTOParam, Long userId, ContractProject project) {
      saveDTOParam.getReportDTOParamList()
         .forEach(
            param -> {
               this.checkReportQuantity(project.getProjectType(), saveDTOParam.getProductType(), param);
               ProjectInstallReport report = ProjectInstallReport.builder()
                  .reportMethod(ReportMethodEnum.PC.getType())
                  .projectType(project.getProjectType())
                  .productType(saveDTOParam.getProductType())
                  .productId(param.getProductId())
                  .reportQuantity(param.getReportQuantity())
                  .auditStatus(AuditStatusEnum.AUDITING.getType())
                  .build();
               Long areaId = this.fillReportV2(report, param.getProductId());
               report.setUserId(userId);
               ProjectSupplierAreaLink supplierAreaLink = this.supplierAreaLinkService
                  .getOne(
                     Wrappers.lambdaQuery(ProjectSupplierAreaLink.class)
                        .eq(ProjectSupplierAreaLink::getAreaId, areaId)
                        .eq(ProjectSupplierAreaLink::getBoolRelationStatus, true)
                        .eq(ProjectSupplierAreaLink::getBoolSettlementStatus, false)
                  );
               Preconditions.checkArgument(supplierAreaLink != null, "填报失败,当前区域未指定分包商");
               report.setSupplierId(supplierAreaLink.getSupplierId());
               Supplier supplier = this.supplierService.getById(supplierAreaLink.getSupplierId());
               Preconditions.checkArgument(supplier != null, "填报失败,当前区域未分包商不存在");
               report.setSupplierName(supplier.getName());
               report.setAuditStatus(AuditStatusEnum.SUCCEED.getType());
               report.setActualQuantity(report.getReportQuantity());
               report.setActualMete(report.getReportMete());
               report.setActualTotalArea(report.getReportTotalArea());
               report.setAuditTime(LocalDateTime.now());
               report.setAuditUserId(userId);
               this.installReportService.save(report);
               this.installSummaryService.saveInstallSummary(report);
               this.receivingSummaryService.updateInstallQuantity(report);
               this.insertInstallPlanCompleteDate(project.getProjectType(), areaId);
            }
         );
   }

   void checkReportQuantity(Integer projectType, Integer productType, InstallReportDTOParam param) {
      ProjectReceivingMeteDTO receivingMete = this.receivingSummaryService.getReceivingMete(projectType, productType, param.getProductId());
      Preconditions.checkArgument(param.getReportQuantity().compareTo(receivingMete.getQuantity()) <= 0, "填报失败,填报数量不能超过收货总数量");
      BigDecimal unCheckReportedQuantity = this.installReportService.getUnCheckReportedQuantity(projectType, productType, param.getProductId());
      ProjectInstallMeteSummaryDTO reportMeteDTO = this.projectInstallBizUtil.getActualInstallMete(projectType, param.getProductId(), productType);
      Preconditions.checkArgument(
         receivingMete.getQuantity().subtract(reportMeteDTO.getActualQuantity()).subtract(unCheckReportedQuantity).compareTo(param.getReportQuantity()) >= 0,
         "填报失败,填报数量超过可填报数量"
      );
   }

   Long fillReport(ProjectInstallReport report, Long productId) {
      Long areaId = null;
      if (report.getProjectType().equals(ProjectTypeEnum.MES.getType()) || report.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())) {
         if (report.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
            TechArtifact artifact = this.artifactService.getById(productId);
            Preconditions.checkArgument(artifact != null, "填报失败,构件不存在");
            BeanUtil.copy(artifact, report);
            report.setReportMete(artifact.getNetWeight().multiply(report.getReportQuantity()));
            report.setReportTotalArea(artifact.getSurfaceArea().multiply(report.getReportQuantity()));
            report.setMeasureUnit("件");
            report.setAccountingUnit("Kg");
            areaId = artifact.getAreaId();
         }

         if (report.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
            TechEnclosure enclosure = this.enclosureService.getById(productId);
            Preconditions.checkArgument(enclosure != null, "填报失败,围护不存在");
            BeanUtil.copy(enclosure, report);
            report.setReportMete(enclosure.getLength().multiply(report.getReportQuantity()));
            report.setReportTotalArea(enclosure.getLength().multiply(enclosure.getUnfoldedWidth()).multiply(report.getReportQuantity()));
            report.setMeasureUnit("张");
            report.setAccountingUnit("m");
            areaId = enclosure.getEnclosurePlanId();
         }
      }

      return areaId;
   }

   Long fillReportV2(ProjectInstallReport report, Long productId) {
      Long areaId = null;
      if (report.getProjectType().equals(ProjectTypeEnum.MES.getType()) || report.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())) {
         if (report.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
            TechArtifact artifact = this.artifactService.getById(productId);
            Preconditions.checkArgument(artifact != null, "填报失败,构件不存在");
            BeanUtil.copy(artifact, report);
            report.setReportMete(artifact.getNetWeight().multiply(report.getReportQuantity()));
            report.setReportTotalArea(artifact.getSurfaceArea().multiply(report.getReportQuantity()));
            report.setMeasureUnit("件");
            report.setAccountingUnit("Kg");
            areaId = artifact.getAreaId();
         }

         if (report.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
            TechEnclosure enclosure = this.enclosureService.getById(productId);
            Preconditions.checkArgument(enclosure != null, "填报失败,围护不存在");
            BeanUtil.copy(enclosure, report);
            report.setReportMete(enclosure.getLength().multiply(report.getReportQuantity()));
            report.setReportTotalArea(enclosure.getLength().multiply(enclosure.getUnfoldedWidth()).multiply(report.getReportQuantity()));
            report.setMeasureUnit("张");
            report.setAccountingUnit("m");
            areaId = enclosure.getAreaId();
            BigDecimal thickness = enclosure.getThickness() != null ? enclosure.getThickness() : BigDecimal.ZERO;
            BigDecimal weight = enclosure.getUnfoldedWidth() != null ? enclosure.getUnfoldedWidth() : BigDecimal.ZERO;
            BigDecimal length = enclosure.getLength() != null ? enclosure.getLength() : BigDecimal.ZERO;
            report.setSpecification(
               thickness.stripTrailingZeros().toPlainString()
                  + "*"
                  + weight.stripTrailingZeros().toPlainString()
                  + "*"
                  + length.stripTrailingZeros().toPlainString()
            );
         }
      }

      return areaId;
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public synchronized Boolean saveAppInstallReport(ProjectInstallReportSaveDTOParam saveDTOParam) {
      Long userId = UserUtil.getCurrentUserId();
      Long supplierId = this.supplierAccountService.getSupplierIdByUserId(userId);
      Supplier supplier = this.supplierService.getById(supplierId);
      Preconditions.checkArgument(supplier != null, "当前分包商不存在");
      ContractProject project = this.projectService.checkProjectStatus(saveDTOParam.getProjectId());
      Preconditions.checkArgument(project.getBusinessType().equals(ProjectBusinessTypeEnum.JOB.getType()), "该项目类型为加工承揽订单");
      Preconditions.checkArgument(ReportMethodEnum.APP.getType().equals(project.getInstallReportMethod()), "该项目已设置为项目部填报");
      saveDTOParam.getReportDTOParamList()
         .forEach(
            param -> {
               this.checkReportQuantity(project.getProjectType(), saveDTOParam.getProductType(), param);
               ProjectInstallReport report = ProjectInstallReport.builder()
                  .reportMethod(ReportMethodEnum.APP.getType())
                  .projectType(project.getProjectType())
                  .productType(saveDTOParam.getProductType())
                  .productId(param.getProductId())
                  .reportQuantity(param.getReportQuantity())
                  .auditStatus(AuditStatusEnum.AUDITING.getType())
                  .userId(userId)
                  .build();
               Long areaId = this.fillReport(report, param.getProductId());
               int count = this.supplierAreaLinkService
                  .count(
                     Wrappers.lambdaQuery(ProjectSupplierAreaLink.class)
                        .eq(ProjectSupplierAreaLink::getAreaId, areaId)
                        .eq(ProjectSupplierAreaLink::getSupplierId, supplierId)
                        .eq(ProjectSupplierAreaLink::getBoolRelationStatus, true)
                        .eq(ProjectSupplierAreaLink::getBoolSettlementStatus, false)
                  );
               Preconditions.checkArgument(count > 0, "填报失败,您没有权限!");
               report.setSupplierId(supplierId);
               report.setSupplierName(supplier.getName());
               this.installReportService.save(report);
            }
         );
      return true;
   }

   @Transactional
   @Override
   public Boolean saveAppInstallReportV2(ProjectInstallReportSaveDTOParam saveDTOParam) {
      ContractProject project = this.projectService.checkProjectStatus(saveDTOParam.getProjectId());
      Preconditions.checkArgument(project.getBusinessType().equals(ProjectBusinessTypeEnum.JOB.getType()), "该项目类型为加工承揽订单");
      Preconditions.checkArgument(ReportMethodEnum.APP.getType().equals(project.getInstallReportMethod()), "该项目已设置为项目部填报");
      Integer installDivideMethod = project.getInstallDivideMethod();
      Preconditions.checkArgument(installDivideMethod != null, "操作失败！该项目安装划分方式未配置！");
      Long userId = UserUtil.getCurrentUserId();
      Long currentUserId = UserUtil.getCurrentUserId();
      ProjectManageRoster roster = this.rosterService
         .getOne(
            Wrappers.lambdaQuery(ProjectManageRoster.class)
               .eq(ProjectManageRoster::getUserId, currentUserId)
               .eq(ProjectManageRoster::getProjectId, project.getId())
               .eq(ProjectManageRoster::getStatus, EmployeeStatusEnum.ON_JOB.getType())
         );
      Preconditions.checkArgument(roster != null, "操作失败,该劳务花名册信息已失效！");
      Supplier supplier = this.supplierService.getById(roster.getSupplierId());
      Preconditions.checkArgument(supplier != null, "操作失败,当前分包商不已不存在");
      if (DivideMethodEnum.AREA.getType().equals(installDivideMethod)) {
         saveDTOParam.getReportDTOParamList()
            .forEach(
               param -> {
                  this.checkReportQuantity(project.getProjectType(), saveDTOParam.getProductType(), param);
                  ProjectInstallReport report = ProjectInstallReport.builder()
                     .reportMethod(ReportMethodEnum.APP.getType())
                     .projectType(project.getProjectType())
                     .productType(saveDTOParam.getProductType())
                     .productId(param.getProductId())
                     .reportQuantity(param.getReportQuantity())
                     .auditStatus(AuditStatusEnum.AUDITING.getType())
                     .build();
                  Long areaId = this.fillReportV2(report, param.getProductId());
                  report.setUserId(userId);
                  int count = this.supplierAreaLinkService
                     .count(
                        Wrappers.lambdaQuery(ProjectSupplierAreaLink.class)
                           .eq(ProjectSupplierAreaLink::getAreaId, areaId)
                           .eq(ProjectSupplierAreaLink::getSupplierId, supplier.getId())
                           .eq(ProjectSupplierAreaLink::getBoolRelationStatus, true)
                           .eq(ProjectSupplierAreaLink::getBoolSettlementStatus, false)
                     );
                  Preconditions.checkArgument(count > 0, "填报失败,您没有权限!");
                  report.setSupplierId(supplier.getId());
                  report.setSupplierName(supplier.getName());
                  this.installReportService.save(report);
               }
            );
      }

      if (DivideMethodEnum.LIST.getType().equals(installDivideMethod)) {
         this.checkPCByListInstallReportDTOParam(saveDTOParam);
         saveDTOParam.getReportDTOParamList()
            .forEach(
               param -> {
                  ProjectInstallReport report = ProjectInstallReport.builder()
                     .reportMethod(ReportMethodEnum.APP.getType())
                     .projectType(project.getProjectType())
                     .productType(saveDTOParam.getProductType())
                     .productId(param.getProductId())
                     .reportQuantity(param.getReportQuantity())
                     .auditStatus(AuditStatusEnum.AUDITING.getType())
                     .build();
                  this.fillReportV2(report, param.getProductId());
                  report.setSupplierId(supplier.getId());
                  report.setSupplierName(supplier.getName());
                  report.setUserId(userId);
                  this.installReportService.save(report);
               }
            );
      }

      return true;
   }

   @Override
   public List<ProjectInstallReportGroupDTO> listInstallReportGroup(Long projectId, Integer productType, String yearMonth) {
      List<ProjectInstallReportGroupDO> reportGroupDOList = this.installReportService.listInstallReportGroup(projectId, productType, yearMonth);
      return reportGroupDOList.stream()
         .map(
            s -> {
               ProjectInstallReportGroupDTO groupDTO = BeanUtil.copy(s, ProjectInstallReportGroupDTO.class);
               Integer quantity = this.installReportService
                  .getUnCheckReportedQuantity(s.getProductType(), s.getSupplierId(), s.getProjectId(), s.getCategory(), s.getReportDate());
               groupDTO.setBoolAuditStatus(quantity == 0);
               if ((s.getProjectType().equals(ProjectTypeEnum.MES.getType()) || s.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType()))
                  && s.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
                  groupDTO.setMeasureUnit("张");
                  Integer measureMode = this.contractTechService.getMeasureMode(s.getProjectId(), s.getProductType(), s.getCategory());
                  if (measureMode.equals(EnclosureMeasureModeEnum.LENGTH_MODE.getType())) {
                     groupDTO.setReportMete(s.getReportMete().divide(BigDecimal.valueOf(1000L)));
                     groupDTO.setActualMete(s.getActualMete().divide(BigDecimal.valueOf(1000L)));
                     groupDTO.setAccountingUnit("m");
                  }

                  if (measureMode.equals(EnclosureMeasureModeEnum.AREA_MODE.getType())) {
                     groupDTO.setReportMete(s.getReportTotalArea().divide(BigDecimal.valueOf(1000000L)));
                     groupDTO.setActualMete(s.getActualTotalArea().divide(BigDecimal.valueOf(1000000L)));
                     groupDTO.setAccountingUnit("m2");
                  }
               } else {
                  groupDTO.setMeasureUnit("件");
                  groupDTO.setAccountingUnit("kg");
               }

               return groupDTO;
            }
         )
         .collect(Collectors.toList());
   }

   @Override
   public PageVO<ProjectInstallReportDTO> pageListInstallReport(InstallReportQueryDTOParam param, Integer pageNumber, Integer pageSize) {
      if (param.getProjectId() != null) {
         ContractProject project = this.projectService.getById(param.getProjectId());
         Preconditions.checkArgument(project != null, "项目不存在");
         Preconditions.checkArgument(project.getBusinessType().equals(ProjectBusinessTypeEnum.JOB.getType()), "该项目类型为加工承揽订单");
      }

      PageHelper.startPage(pageNumber, pageSize);
      List<ProjectInstallReport> reportList = this.installReportService.listInstallReport(param);
      List<ProjectInstallReportDTO> reportDTOList = reportList.stream().map(s -> {
         ProjectInstallReportDTO reportDTO = BeanUtil.copy(s, ProjectInstallReportDTO.class);
         reportDTO.setMonomer(this.monomerService.getSimpleById(s.getMonomerId()));
         reportDTO.setArea(s.getAreaId() != null ? this.areaService.getSimpleById(s.getAreaId()) : null);
         reportDTO.setAuditUserName(this.userService.getNameById(s.getAuditUserId()));
         if (s.getProjectType().equals(ProjectTypeEnum.MES.getType()) || s.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())) {
            TechProductDTO productDTO = this.productBiz.getProductInfoBy(s.getProductId(), s.getProductType());
            reportDTO.setNetWeight(productDTO.getNetWeight());
            reportDTO.setLength(productDTO.getLength());
            if (s.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
               Integer measureMode = this.contractTechService.getMeasureMode(s.getProjectId(), s.getProductType(), s.getCategory());
               reportDTO.setMeasureUnit("张");
               if (measureMode.equals(EnclosureMeasureModeEnum.LENGTH_MODE.getType())) {
                  reportDTO.setReportMete(s.getReportMete().divide(BigDecimal.valueOf(1000L)));
                  reportDTO.setActualMete(s.getActualMete() != null ? s.getActualMete().divide(BigDecimal.valueOf(1000L)) : BigDecimal.ZERO);
                  reportDTO.setAccountingUnit("m");
               } else if (measureMode.equals(EnclosureMeasureModeEnum.AREA_MODE.getType())) {
                  reportDTO.setReportMete(s.getReportTotalArea().divide(BigDecimal.valueOf(1000000L)));
                  reportDTO.setActualMete(s.getActualTotalArea() != null ? s.getActualTotalArea().divide(BigDecimal.valueOf(1000000L)) : BigDecimal.ZERO);
                  reportDTO.setAccountingUnit("m2");
               }
            } else {
               reportDTO.setMeasureUnit("件");
               reportDTO.setAccountingUnit("kg");
            }
         }

         return reportDTO;
      }).collect(Collectors.toList());
      return new PageVO<>(PageUtils.getPageInfo(reportDTOList, reportList));
   }

   @Override
   public PageVO<ProjectInstallReportDTO> pageListInstallReportV2(InstallReportQueryDTOParam param, Integer pageNumber, Integer pageSize) {
      if (param.getProjectId() != null) {
         ContractProject project = this.projectService.getById(param.getProjectId());
         Preconditions.checkArgument(project != null, "项目不存在");
         Preconditions.checkArgument(project.getBusinessType().equals(ProjectBusinessTypeEnum.JOB.getType()), "该项目类型为加工承揽订单");
      }

      param.setAuditStatus(AuditStatusEnum.AUDITING.getType());
      PageHelper.startPage(pageNumber, pageSize);
      List<ProjectInstallReport> reportList = this.installReportService.listInstallReport(param);
      List<Long> supplierIds = reportList.stream().map(ProjectInstallReport::getSupplierId).distinct().collect(Collectors.toList());
      if (CollectionUtils.isEmpty(supplierIds)) {
         return new PageVO<>();
      }

      Map<Long, Supplier> supplierMap = this.supplierService.listByIds(supplierIds).stream().collect(Collectors.toMap(Supplier::getId, Function.identity()));
      List<ProjectInstallReportDTO> reportDTOList = reportList.stream().map(s -> {
         Supplier supplier = supplierMap.get(s.getSupplierId());
         ProjectInstallReportDTO reportDTO = BeanUtil.copy(s, ProjectInstallReportDTO.class);
         reportDTO.setMonomer(this.monomerService.getSimpleById(s.getMonomerId()));
         reportDTO.setArea(s.getAreaId() != null ? this.areaService.getSimpleById(s.getAreaId()) : null);
         reportDTO.setAuditUserName(this.userService.getNameById(s.getAuditUserId()));
         reportDTO.setReportUserName(this.userService.getNameById(s.getUserId()));
         reportDTO.setSupplier(NameInfo.builder().id(supplier.getId()).name(supplier.getName()).build());
         if (s.getProjectType().equals(ProjectTypeEnum.MES.getType()) || s.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())) {
            TechProductDTO productDTO = this.productBiz.getProductInfoBy(s.getProductId(), s.getProductType());
            reportDTO.setNetWeight(productDTO.getNetWeight());
            reportDTO.setLength(productDTO.getLength());
            if (s.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
               reportDTO.setMeasureUnit("张");
               reportDTO.setReportMete(s.getReportMete().divide(BigDecimal.valueOf(1000L)));
               reportDTO.setActualMete(s.getActualMete() != null ? s.getActualMete().divide(BigDecimal.valueOf(1000L)) : BigDecimal.ZERO);
               reportDTO.setAccountingUnit("m");
            } else {
               reportDTO.setMeasureUnit("件");
               reportDTO.setAccountingUnit("kg");
            }
         }

         return reportDTO;
      }).collect(Collectors.toList());
      return new PageVO<>(PageUtils.getPageInfo(reportDTOList, reportList));
   }

   @Override
   public List<ProjectAppInstallReportGroupDTO> listAppInstallReportGroup(Long projectId, Integer productType) {
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(projectIds)) {
         return new ArrayList<>();
      }

      List<ProjectAppInstallReportGroupDO> appInstallReportGroupDOList = this.installReportService.listAppInstallReportGroup(projectId, productType);
      return appInstallReportGroupDOList.stream().map(dao -> {
         ProjectAppInstallReportGroupDTO dto = BeanUtil.copy(dao, ProjectAppInstallReportGroupDTO.class);
         if (dao.getProjectType().equals(ProjectTypeEnum.MES.getType()) && dao.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
            dto.setMeasureUnit("张");
            Integer measureMode = this.contractTechService.getMeasureMode(dao.getProjectId(), dao.getProductType(), dao.getCategory());
            if (measureMode.equals(EnclosureMeasureModeEnum.LENGTH_MODE.getType())) {
               dto.setReportMete(dao.getReportMete().divide(BigDecimal.valueOf(1000L)));
               dto.setActualMete(dao.getActualMete().divide(BigDecimal.valueOf(1000L)));
               dto.setAccountingUnit("m");
            }

            if (measureMode.equals(EnclosureMeasureModeEnum.AREA_MODE.getType())) {
               dto.setReportMete(dao.getReportTotalArea().divide(BigDecimal.valueOf(1000000L)));
               dto.setActualMete(dao.getActualTotalArea().divide(BigDecimal.valueOf(1000000L)));
               dto.setAccountingUnit("m2");
            }
         } else {
            dto.setMeasureUnit("件");
            dto.setAccountingUnit("Kg");
         }

         return dto;
      }).filter(e -> projectIds.contains(e.getProjectId())).collect(Collectors.toList());
   }

   @Override
   public List<ProjectInstallReportDTO> listInstallReport(InstallReportQueryDTOParam param) {
      return this.installReportService.listInstallReport(param).stream().map(s -> {
         ProjectInstallReportDTO reportDTO = BeanUtil.copy(s, ProjectInstallReportDTO.class);
         reportDTO.setMonomer(this.monomerService.getSimpleById(s.getMonomerId()));
         reportDTO.setArea(s.getAreaId() != null ? this.areaService.getSimpleById(s.getAreaId()) : null);
         reportDTO.setAuditUserName(this.userService.getNameById(s.getAuditUserId()));
         if (s.getProjectType().equals(ProjectTypeEnum.MES.getType()) || s.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())) {
            TechProductDTO productDTO = this.productBiz.getProductInfoBy(s.getProductId(), s.getProductType());
            reportDTO.setNetWeight(productDTO.getNetWeight());
            reportDTO.setLength(productDTO.getLength());
            if (s.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
               Integer measureMode = this.contractTechService.getMeasureMode(s.getProjectId(), s.getProductType(), s.getCategory());
               reportDTO.setMeasureUnit("张");
               if (measureMode.equals(EnclosureMeasureModeEnum.LENGTH_MODE.getType())) {
                  reportDTO.setReportMete(s.getReportMete().divide(BigDecimal.valueOf(1000L)));
                  reportDTO.setActualMete(s.getActualMete() != null ? s.getActualMete().divide(BigDecimal.valueOf(1000L)) : BigDecimal.ZERO);
                  reportDTO.setAccountingUnit("m");
               } else if (measureMode.equals(EnclosureMeasureModeEnum.AREA_MODE.getType())) {
                  reportDTO.setReportMete(s.getReportTotalArea().divide(BigDecimal.valueOf(1000000L)));
                  reportDTO.setActualMete(s.getActualTotalArea() != null ? s.getActualTotalArea().divide(BigDecimal.valueOf(1000000L)) : BigDecimal.ZERO);
                  reportDTO.setAccountingUnit("m2");
               }
            } else {
               reportDTO.setMeasureUnit("件");
               reportDTO.setAccountingUnit("kg");
            }
         }

         return reportDTO;
      }).collect(Collectors.toList());
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public synchronized Boolean checkInstallReport(List<CheckInstallReportDTOParam> paramList) {
      paramList.forEach(
         param -> {
            ProjectInstallReport installReport = this.installReportService.getById(param.getId());
            Preconditions.checkArgument(installReport != null, "审核失败,数据不存在");
            Preconditions.checkArgument(installReport.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()), "审核失败,填报已审核");
            Preconditions.checkArgument(installReport.getReportQuantity().compareTo(param.getActualQuantity()) >= 0, "审核失败,审核数量不能大于填报数");
            BigDecimal actualMete = null;
            BigDecimal actualTotalArea = null;
            Long areaId = null;
            if ((
                  installReport.getProjectType().equals(ProjectTypeEnum.MES.getType())
                     || installReport.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())
               )
               && installReport.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
               TechArtifact artifact = this.artifactService.getById(installReport.getProductId());
               Preconditions.checkArgument(artifact != null, "审核失败,产品(构件)不存在");
               actualMete = artifact.getNetWeight().multiply(param.getActualQuantity());
               actualTotalArea = artifact.getSurfaceArea().multiply(param.getActualQuantity());
               areaId = artifact.getAreaId();
            }

            installReport.setAuditUserId(UserUtil.getCurrentUserId());
            installReport.setAuditTime(LocalDateTime.now());
            if (param.getActualQuantity().compareTo(BigDecimal.ZERO) == 0) {
               installReport.setAuditStatus(AuditStatusEnum.FAILED.getType());
            } else {
               installReport.setAuditStatus(AuditStatusEnum.SUCCEED.getType());
               installReport.setActualQuantity(param.getActualQuantity());
               installReport.setActualMete(actualMete);
               installReport.setActualTotalArea(actualTotalArea);
               this.installSummaryService.saveInstallSummary(installReport);
               this.receivingSummaryService.updateInstallQuantity(installReport);
               this.insertInstallPlanCompleteDate(installReport.getProjectType(), areaId);
            }

            this.installReportService.updateById(installReport);
         }
      );
      return true;
   }

   @Transactional
   @Override
   public Boolean checkInstallReportV2(List<CheckInstallReportDTOParam> paramList, Long projectId) {
      ContractProject project = this.projectService.checkProjectStatus(projectId);
      paramList.forEach(
         param -> {
            ProjectInstallReport installReport = this.installReportService.getById(param.getId());
            Preconditions.checkArgument(installReport != null, "审核失败,数据不存在");
            Preconditions.checkArgument(installReport.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()), "审核失败,填报已审核");
            Preconditions.checkArgument(installReport.getReportQuantity().compareTo(param.getActualQuantity()) >= 0, "审核失败,审核数量不能大于填报数");
            BigDecimal actualMete = null;
            BigDecimal actualTotalArea = null;
            Long areaId = null;
            if (installReport.getProjectType().equals(ProjectTypeEnum.MES.getType()) || installReport.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())
               )
             {
               if (installReport.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
                  TechArtifact artifact = this.artifactService.getById(installReport.getProductId());
                  Preconditions.checkArgument(artifact != null, "审核失败,产品(构件)不存在");
                  actualMete = artifact.getNetWeight().multiply(param.getActualQuantity());
                  actualTotalArea = artifact.getSurfaceArea().multiply(param.getActualQuantity());
                  areaId = artifact.getAreaId();
               }

               if (installReport.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
                  TechEnclosure enclosure = this.enclosureService.getById(installReport.getProductId());
                  Preconditions.checkArgument(enclosure != null, "审核失败,产品(围护)不存在");
                  actualMete = enclosure.getLength().multiply(param.getActualQuantity());
                  actualTotalArea = enclosure.getLength().multiply(enclosure.getUnfoldedWidth()).multiply(param.getActualQuantity());
               }
            }

            installReport.setAuditUserId(UserUtil.getCurrentUserId());
            installReport.setAuditTime(LocalDateTime.now());
            if (param.getActualQuantity().compareTo(BigDecimal.ZERO) == 0) {
               installReport.setAuditStatus(AuditStatusEnum.FAILED.getType());
            } else {
               installReport.setAuditStatus(AuditStatusEnum.SUCCEED.getType());
               installReport.setActualQuantity(param.getActualQuantity());
               installReport.setActualMete(actualMete);
               installReport.setActualTotalArea(actualTotalArea);
               this.installSummaryService.saveInstallSummary(installReport);
               this.receivingSummaryService.updateInstallQuantity(installReport);
               this.insertInstallPlanCompleteDate(installReport.getProjectType(), areaId);
               if (DivideMethodEnum.LIST.getType().equals(project.getInstallDivideMethod())) {
                  this.orderProductLinkService
                     .saveInstallInfo(
                        project.getId(), installReport.getSupplierId(), installReport.getProductType(), installReport.getProductId(), param.getActualQuantity()
                     );
               }
            }

            this.installReportService.updateById(installReport);
         }
      );
      return true;
   }

   private void insertInstallPlanCompleteDate(Integer projectType, Long areaId) {
      BigDecimal actualInstallQuantity = this.installSummaryService.getActualInstallQuantity(Collections.singletonList(areaId));
      if (projectType.equals(ProjectTypeEnum.MES.getType()) || projectType.equals(ProjectTypeEnum.BRIDGE.getType())) {
         ProductMeteDTO deepenMete = this.productBiz.getDeepenMete(areaId);
         if (actualInstallQuantity.compareTo(BigDecimal.valueOf(deepenMete.getQuantity().intValue())) >= 0) {
            this.planDetailService.setCompleteDate(areaId, PlanDetailTypeEnum.INSTALL_PLAN.getType(), LocalDate.now());
         }
      }
   }

   private void insertInstallPlanCompleteDateV2(Integer projectType, Long areaId) {
      BigDecimal actualInstallQuantity = this.installSummaryService.getActualInstallQuantity(Collections.singletonList(areaId));
      if (projectType.equals(ProjectTypeEnum.MES.getType()) || projectType.equals(ProjectTypeEnum.BRIDGE.getType())) {
         ProductMeteDTO deepenMete = this.productBiz.getDeepenMeteV2(areaId);
         if (actualInstallQuantity.compareTo(BigDecimal.valueOf(deepenMete.getQuantity().intValue())) >= 0) {
            this.planDetailService.setCompleteDate(areaId, PlanDetailTypeEnum.INSTALL_PLAN.getType(), LocalDate.now());
         }
      }
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public synchronized Boolean checkAppReport(List<AppCheckInstallReportDTOParam> paramList) {
      Long userId = UserUtil.getCurrentUserId();
      paramList.forEach(
         param -> {
            Preconditions.checkArgument(
               param.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType()) || param.getAuditStatus().equals(AuditStatusEnum.FAILED.getType()), "审核状态有误"
            );
            ProjectInstallReport installReport = this.installReportService.getById(param.getId());
            Preconditions.checkArgument(installReport != null, "上报记录不存在");
            Preconditions.checkArgument(installReport.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()), "上报已审核");
            installReport.setAuditStatus(param.getAuditStatus());
            installReport.setAuditUserId(userId);
            installReport.setAuditTime(LocalDateTime.now());
            if (param.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType())) {
               BigDecimal actualMete = null;
               BigDecimal actualTotalArea = null;
               Long areaId = null;
               if (!installReport.getProjectType().equals(ProjectTypeEnum.MES.getType())
                  && installReport.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())) {
               }

               installReport.setActualQuantity(installReport.getReportQuantity());
               installReport.setActualMete(actualMete);
               installReport.setActualTotalArea(actualTotalArea);
               this.installSummaryService.saveInstallSummary(installReport);
               this.receivingSummaryService.updateInstallQuantity(installReport);
               this.insertInstallPlanCompleteDate(installReport.getProjectType(), areaId);
            }

            this.installReportService.updateById(installReport);
         }
      );
      return true;
   }

   @Transactional
   @Override
   public Boolean checkAppReportV2(List<AppCheckInstallReportDTOParam> paramList, Long projectId) {
      ContractProject project = this.projectService.checkProjectStatus(projectId);
      Long userId = UserUtil.getCurrentUserId();
      paramList.forEach(
         param -> {
            Preconditions.checkArgument(
               param.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType()) || param.getAuditStatus().equals(AuditStatusEnum.FAILED.getType()), "审核状态有误"
            );
            ProjectInstallReport installReport = this.installReportService.getById(param.getId());
            Preconditions.checkArgument(installReport != null, "上报记录不存在");
            Preconditions.checkArgument(installReport.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()), "上报已审核");
            installReport.setAuditStatus(param.getAuditStatus());
            installReport.setAuditUserId(userId);
            installReport.setAuditTime(LocalDateTime.now());
            if (param.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType())) {
               BigDecimal actualMete = null;
               BigDecimal actualTotalArea = null;
               Long areaId = null;
               if (installReport.getProjectType().equals(ProjectTypeEnum.MES.getType())
                  || installReport.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())) {
                  if (installReport.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
                     TechArtifact artifact = this.artifactService.getById(installReport.getProductId());
                     Preconditions.checkArgument(artifact != null, "审核失败,产品(构件)不存在");
                     actualMete = artifact.getNetWeight().multiply(installReport.getReportQuantity());
                     actualTotalArea = artifact.getSurfaceArea().multiply(installReport.getReportQuantity());
                     areaId = artifact.getAreaId();
                  }

                  if (installReport.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
                     TechEnclosure enclosure = this.enclosureService.getById(installReport.getProductId());
                     Preconditions.checkArgument(enclosure != null, "审核失败,产品(围护)不存在");
                     areaId = enclosure.getAreaId();
                     actualMete = enclosure.getLength().multiply(installReport.getReportQuantity());
                     actualTotalArea = enclosure.getLength().multiply(enclosure.getUnfoldedWidth()).multiply(installReport.getReportQuantity());
                  }
               }

               installReport.setActualQuantity(installReport.getReportQuantity());
               installReport.setActualMete(actualMete);
               installReport.setActualTotalArea(actualTotalArea);
               this.installSummaryService.saveInstallSummary(installReport);
               this.receivingSummaryService.updateInstallQuantity(installReport);
               this.insertInstallPlanCompleteDateV2(installReport.getProjectType(), areaId);
               if (DivideMethodEnum.LIST.getType().equals(project.getInstallDivideMethod())) {
                  this.orderProductLinkService
                     .saveInstallInfo(
                        project.getId(),
                        installReport.getSupplierId(),
                        installReport.getProductType(),
                        installReport.getProductId(),
                        installReport.getActualQuantity()
                     );
               }
            }

            this.installReportService.updateById(installReport);
         }
      );
      return true;
   }

   @Override
   public PageVO<ProjectInstallSummaryDTO> pageListInstallStatement(InstallStatementQueryDTOParam param, Integer pageNumber, Integer pageSize) {
      ContractProject project = this.projectService.getById(param.getProjectId());
      Preconditions.checkArgument(project != null, "项目不存在");
      Preconditions.checkArgument(project.getBusinessType().equals(ProjectBusinessTypeEnum.JOB.getType()), "该项目类型为加工承揽订单");
      PageHelper.startPage(pageNumber, pageSize);
      return new PageVO<>(this.installReportService.listInstallStatement(param));
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printListInstallStatement(InstallStatementQueryDTOParam param) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      ProjectInfo project = this.projectService.getSimpleById(param.getProjectId());
      header.put("project", project);
      header.put("productType", ProductTypeEnum.getNameByType(param.getProductType()));
      printVO.setHeader(header);
      List<Map<String, Object>> mapList = this.installReportService.listInstallStatement(param).stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public PageVO<ProjectInstallBoardDTO> listInstallBoard(InstallBoardQueryDTOParam param, Integer pageNumber, Integer pageSize) {
      ContractProject project = this.projectService.getById(param.getProjectId());
      Preconditions.checkArgument(project != null, "项目不存在");
      Preconditions.checkArgument(project.getBusinessType().equals(ProjectBusinessTypeEnum.JOB.getType()), "该项目类型为加工承揽订单");
      param.setProjectType(project.getProjectType());
      if (!project.getProjectType().equals(ProjectTypeEnum.MES.getType()) && !project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())) {
         throw new BusinessException("暂不支持其他项目类型");
      }

      Preconditions.checkArgument(
         param.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())
            || param.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())
            || param.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType()),
         "建钢项目-产品类型传值有误!"
      );
      PageHelper.startPage(pageNumber, pageSize);
      return new PageVO<>(this.installSummaryService.listInstallBoard(param));
   }

   @Override
   public PageVO<ProjectInstallBoardDTO> listInstallBoardV2(InstallBoardQueryDTOParam param, Integer pageNumber, Integer pageSize) {
      ContractProject project = this.projectService.getById(param.getProjectId());
      Preconditions.checkArgument(project != null, "项目不存在");
      Preconditions.checkArgument(project.getBusinessType().equals(ProjectBusinessTypeEnum.JOB.getType()), "该项目类型为加工承揽订单");
      param.setProjectType(project.getProjectType());
      if (!project.getProjectType().equals(ProjectTypeEnum.MES.getType()) && !project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())) {
         throw new BusinessException("暂不支持其他项目类型");
      }

      Preconditions.checkArgument(
         param.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())
            || param.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())
            || param.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType()),
         "建钢项目-产品类型传值有误!"
      );
      PageHelper.startPage(pageNumber, pageSize);
      return new PageVO<>(this.installSummaryService.listInstallBoardV2(param));
   }

   @Override
   public PageVO<ProjectInstallReportDTO> installBoardDetails(Integer productType, Long productId, Integer pageNumber, Integer pageSize) {
      Page page = PageHelper.startPage(pageNumber, pageSize);
      List<ProjectInstallReport> reportList = this.installReportService
         .list(
            Wrappers.lambdaQuery(ProjectInstallReport.class)
               .eq(ProjectInstallReport::getProductType, productType)
               .eq(ProjectInstallReport::getProductId, productId)
               .eq(ProjectInstallReport::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .orderByDesc(BaseEntity::getCreateTime)
         );
      if (CollectionUtils.isEmpty(reportList)) {
         return new PageVO<>();
      }

      List<Long> supplierIds = reportList.stream().map(ProjectInstallReport::getSupplierId).distinct().collect(Collectors.toList());
      Map<Long, Supplier> supplierMap = this.supplierService.listByIds(supplierIds).stream().collect(Collectors.toMap(Supplier::getId, Function.identity()));
      List<ProjectInstallReportDTO> reportDTOList = reportList.stream().map(e -> {
         Supplier supplier = supplierMap.getOrDefault(e.getSupplierId(), new Supplier());
         ProjectInstallReportDTO reportDTO = BeanUtil.copy(e, ProjectInstallReportDTO.class);
         reportDTO.setSupplier(NameInfo.builder().id(supplier.getId()).name(supplier.getName()).build());
         reportDTO.setReportUserName(this.userService.getNameById(e.getUserId()));
         return reportDTO;
      }).collect(Collectors.toList());
      return new PageVO<>(page, reportDTOList);
   }

   @Override
   public List<ProjectSupplierInstallSummaryDTO> getSupplierInstallSummary(Long projectId) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目信息不存在！");
      if (project.getInstallDivideMethod() == null) {
         return new ArrayList<>();
      }

      HashMap<Long, BigDecimal> divideArtifactMeteMap = new HashMap<>();
      HashMap<Long, BigDecimal> divideEnclosureMeteMap = new HashMap<>();
      if (DivideMethodEnum.AREA.getType().equals(project.getInstallDivideMethod())) {
         Map<Long, List<ProjectSupplierAreaLink>> areaLinkMap = this.supplierAreaLinkService
            .list(
               Wrappers.lambdaQuery(ProjectSupplierAreaLink.class)
                  .eq(ProjectSupplierAreaLink::getProjectId, projectId)
                  .eq(ProjectSupplierAreaLink::getBoolRelationStatus, true)
                  .eq(ProjectSupplierAreaLink::getBoolSettlementStatus, false)
            )
            .stream()
            .collect(Collectors.groupingBy(ProjectSupplierAreaLink::getSupplierId));
         areaLinkMap.forEach((supplierId, areaLinkList) -> {
            List<Long> areaIds = areaLinkList.stream().map(ProjectSupplierAreaLink::getAreaId).distinct().collect(Collectors.toList());
            this.areaService.listByIds(areaIds).forEach(e -> {
               BigDecimal mete = this.productBiz.getDeepenMeteV2(e.getId()).getMete();
               if (ProjectPlanProductCategoryEnum.ARTIFACT.getType().equals(e.getProjectPlanProductCategory())) {
                  BigDecimal divideArtifactMete = divideArtifactMeteMap.getOrDefault(supplierId, BigDecimal.ZERO);
                  divideArtifactMeteMap.put(supplierId, divideArtifactMete.add(mete));
               }

               if (ProjectPlanProductCategoryEnum.ENCLOSURE.getType().equals(e.getProjectPlanProductCategory())) {
                  BigDecimal divideEnclosureMete = divideEnclosureMeteMap.getOrDefault(supplierId, BigDecimal.ZERO);
                  divideEnclosureMeteMap.put(supplierId, divideEnclosureMete.add(mete));
               }
            });
         });
      }

      if (DivideMethodEnum.LIST.getType().equals(project.getInstallDivideMethod())) {
         Map<Long, BigDecimal> collect = this.orderProductLinkService
            .list(
               Wrappers.lambdaQuery(ProjectLaborSubsupplierOrderProductLink.class)
                  .eq(ProjectLaborSubsupplierOrderProductLink::getProjectId, projectId)
                  .eq(ProjectLaborSubsupplierOrderProductLink::getProductType, ProductTypeEnum.ARTIFACT.getType())
            )
            .stream()
            .collect(
               Collectors.groupingBy(
                  ProjectLaborSubsupplierOrderProductLink::getSupplierId,
                  Collectors.mapping(
                     link -> link.getMete().divide(BigDecimal.valueOf(1000L)).stripTrailingZeros(), Collectors.reducing(BigDecimal.ZERO, BigDecimal::add)
                  )
               )
            );
         divideArtifactMeteMap.putAll(collect);
         Map<Long, BigDecimal> collect2 = this.orderProductLinkService
            .list(
               Wrappers.lambdaQuery(ProjectLaborSubsupplierOrderProductLink.class)
                  .eq(ProjectLaborSubsupplierOrderProductLink::getProjectId, projectId)
                  .eq(ProjectLaborSubsupplierOrderProductLink::getProductType, ProductTypeEnum.ENCLOSURE.getType())
            )
            .stream()
            .collect(
               Collectors.groupingBy(
                  ProjectLaborSubsupplierOrderProductLink::getSupplierId,
                  Collectors.mapping(
                     link -> link.getLength().multiply(link.getQuantity()).divide(BigDecimal.valueOf(1000L)).stripTrailingZeros(),
                     Collectors.reducing(BigDecimal.ZERO, BigDecimal::add)
                  )
               )
            );
         divideEnclosureMeteMap.putAll(collect2);
      }

      List<SupplierInfo> supplierInfoList = this.subcontractManageBiz.getInstallOrderSupplierInfoList(projectId);
      Map<Long, Map<Integer, ProjectSupplierInstallSummaryDTO>> installSummaryMap = this.installReportService
         .getSupplierInstallArtifactSummary(projectId)
         .stream()
         .collect(
            Collectors.groupingBy(
               ProjectSupplierInstallSummaryDTO::getSupplierId,
               Collectors.toMap(ProjectSupplierInstallSummaryDTO::getProductType, Function.identity(), (existing, replacement) -> existing)
            )
         );
      return supplierInfoList.stream()
         .map(
            e -> {
               if (installSummaryMap.containsKey(e.getSupplierId())) {
                  ProjectSupplierInstallSummaryDTO s1 = installSummaryMap.get(e.getSupplierId())
                     .getOrDefault(
                        ProductTypeEnum.ARTIFACT.getType(),
                        ProjectSupplierInstallSummaryDTO.builder()
                           .supplierName(e.getSupplierName())
                           .supplierId(e.getSupplierId())
                           .productType(ProductTypeEnum.ARTIFACT.getType())
                           .taskMete(BigDecimal.ZERO)
                           .mete(BigDecimal.ZERO)
                           .quantity(0)
                           .currentMonthMete(BigDecimal.ZERO)
                           .currentMonthQuantity(0)
                           .lastMonthMete(BigDecimal.ZERO)
                           .lastMonthQuantity(0)
                           .build()
                     );
                  s1.setTaskMete(divideArtifactMeteMap.getOrDefault(s1.getSupplierId(), BigDecimal.ZERO).stripTrailingZeros());
                  s1.setMeasureUnit("件");
                  s1.setAccountingUnit("吨");
                  ProjectSupplierInstallSummaryDTO s2 = installSummaryMap.get(e.getSupplierId())
                     .getOrDefault(
                        ProductTypeEnum.ENCLOSURE.getType(),
                        ProjectSupplierInstallSummaryDTO.builder()
                           .supplierName(e.getSupplierName())
                           .supplierId(e.getSupplierId())
                           .productType(ProductTypeEnum.ENCLOSURE.getType())
                           .taskMete(BigDecimal.ZERO)
                           .mete(BigDecimal.ZERO)
                           .quantity(0)
                           .currentMonthMete(BigDecimal.ZERO)
                           .currentMonthQuantity(0)
                           .lastMonthMete(BigDecimal.ZERO)
                           .lastMonthQuantity(0)
                           .measureUnit("张")
                           .accountingUnit("m")
                           .build()
                     );
                  s2.setMeasureUnit("张");
                  s2.setAccountingUnit("m");
                  s2.setTaskMete(divideEnclosureMeteMap.getOrDefault(s2.getSupplierId(), BigDecimal.ZERO));
                  return Arrays.asList(s1, s2);
               } else {
                  ProjectSupplierInstallSummaryDTO s1 = ProjectSupplierInstallSummaryDTO.builder()
                     .supplierName(e.getSupplierName())
                     .supplierId(e.getSupplierId())
                     .productType(ProductTypeEnum.ARTIFACT.getType())
                     .taskMete(BigDecimal.ZERO)
                     .mete(BigDecimal.ZERO)
                     .quantity(0)
                     .currentMonthMete(BigDecimal.ZERO)
                     .currentMonthQuantity(0)
                     .lastMonthMete(BigDecimal.ZERO)
                     .lastMonthQuantity(0)
                     .taskMete(divideArtifactMeteMap.getOrDefault(e.getSupplierId(), BigDecimal.ZERO).stripTrailingZeros())
                     .measureUnit("件")
                     .accountingUnit("吨")
                     .build();
                  ProjectSupplierInstallSummaryDTO s2 = ProjectSupplierInstallSummaryDTO.builder()
                     .supplierName(e.getSupplierName())
                     .supplierId(e.getSupplierId())
                     .productType(ProductTypeEnum.ENCLOSURE.getType())
                     .taskMete(BigDecimal.ZERO)
                     .mete(BigDecimal.ZERO)
                     .quantity(0)
                     .currentMonthMete(BigDecimal.ZERO)
                     .currentMonthQuantity(0)
                     .lastMonthMete(BigDecimal.ZERO)
                     .lastMonthQuantity(0)
                     .taskMete(divideEnclosureMeteMap.getOrDefault(e.getSupplierId(), BigDecimal.ZERO))
                     .measureUnit("张")
                     .accountingUnit("m")
                     .build();
                  return Arrays.asList(s1, s2);
               }
            }
         )
         .flatMap(Collection::stream)
         .filter(e -> e.getTaskMete().compareTo(BigDecimal.ZERO) != 0)
         .collect(Collectors.toList());
   }

   @Override
   public PageVO<ProjectInstallReportDTO> getSupplierInstallDetails(
      Long projectId, Long supplierId, Integer productType, LocalDate startDate, LocalDate endDate, Integer pageNumber, Integer pageSize
   ) {
      Page page = PageHelper.startPage(pageNumber, pageSize);
      List<ProjectInstallReportDTO> reportDTOList = this.getProjectInstallReportDTOList(projectId, supplierId, productType, startDate, endDate);
      return new PageVO<>(page, reportDTOList);
   }

   private List<ProjectInstallReportDTO> getProjectInstallReportDTOList(
      Long projectId, Long supplierId, Integer productType, LocalDate startDate, LocalDate endDate
   ) {
      List<ProjectInstallReport> reportList = this.installReportService
         .list(
            Wrappers.lambdaQuery(ProjectInstallReport.class)
               .eq(ProjectInstallReport::getProjectId, projectId)
               .eq(supplierId != null, ProjectInstallReport::getSupplierId, supplierId)
               .eq(ProjectInstallReport::getProductType, productType)
               .eq(ProjectInstallReport::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .apply(startDate != null, "date_format(create_time, '%Y-%m-%d') >= date_format({0}, '%Y-%m-%d')", startDate)
               .apply(endDate != null, "date_format(create_time, '%Y-%m-%d') <= date_format({0}, '%Y-%m-%d')", endDate)
               .orderByDesc(BaseEntity::getCreateTime)
         );
      return reportList.stream().map(e -> {
         ProjectInstallReportDTO reportDTO = BeanUtil.copy(e, ProjectInstallReportDTO.class);
         if (ProductTypeEnum.ENCLOSURE.getType().equals(e.getProductType())) {
            reportDTO.setReportMete(e.getReportMete().divide(BigDecimal.valueOf(1000L)));
         }

         return reportDTO;
      }).collect(Collectors.toList());
   }

   @Override
   public PrintVO<List<Map<String, Object>>> getSupplierInstallDetailsPrint(
      Long projectId, Long supplierId, Integer productType, LocalDate startDate, LocalDate endDate
   ) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      ProjectInfo project = this.projectService.getSimpleById(projectId);
      Supplier supplier = this.supplierService.getById(supplierId);
      SupplierDTO supplierDTO = BeanUtil.copy(supplier, SupplierDTO.class);
      header.put("supplier", supplierDTO);
      header.put("project", project);
      header.put("productType", ProductTypeEnum.getNameByType(productType));
      List<ProjectInstallReportDTO> list = this.getProjectInstallReportDTOList(projectId, supplierId, productType, startDate, endDate);
      header.put("totalQuantity", 0);
      if (CollUtil.isNotEmpty(list)) {
         BigDecimal totalQuantity = list.stream()
            .map(ProjectInstallReportDTO::getReportQuantity)
            .filter(Objects::nonNull)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         header.put("totalQuantity", totalQuantity);
      }

      printVO.setHeader(header);
      printVO.setTable(list.stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
      return printVO;
   }

   @Override
   public ProjectSupplierInstallSummaryDTO getProjectInstallSummary(Long projectId, Integer productType) {
      ProjectSupplierInstallSummaryDTO summaryDTO = this.installReportService.getProjectInstallArtifactSummary(projectId, productType);
      if (summaryDTO == null) {
         summaryDTO = ProjectSupplierInstallSummaryDTO.builder()
            .productType(productType)
            .mete(BigDecimal.ZERO)
            .currentMonthMete(BigDecimal.ZERO)
            .lastMonthMete(BigDecimal.ZERO)
            .quantity(0)
            .lastMonthQuantity(0)
            .currentMonthQuantity(0)
            .build();
      }

      if (productType.equals(ProductTypeEnum.ENCLOSURE.getType())) {
         ProductMeteDTO productMeteDTO = this.productBiz.getDeepenMete(projectId, null, null, productType);
         summaryDTO.setTaskMete(productMeteDTO.getMete().stripTrailingZeros());
         summaryDTO.setMeasureUnit("张");
         summaryDTO.setAccountingUnit("m");
      } else {
         ProductMeteDTO productMeteDTO = this.productBiz.getDeepenMete(projectId, null, null, productType);
         summaryDTO.setTaskMete(productMeteDTO.getMete().divide(BigDecimal.valueOf(1000L)).stripTrailingZeros());
         summaryDTO.setMeasureUnit("件");
         summaryDTO.setAccountingUnit("吨");
      }

      return summaryDTO;
   }

   @Override
   public PageVO<ProjectInstallReportDTO> getProjectInstallDetails(
      Long projectId, Integer productType, LocalDate startDate, LocalDate endDate, Integer pageNumber, Integer pageSize
   ) {
      Page page = PageHelper.startPage(pageNumber, pageSize);
      List<ProjectInstallReportDTO> dtoList = this.installReportService.getProjectInstallDetails(projectId, productType, startDate, endDate);
      return new PageVO<>(page, dtoList);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> getProjectInstallDetailsPrint(Long projectId, Integer productType, LocalDate startDate, LocalDate endDate) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      ProjectInfo project = this.projectService.getSimpleById(projectId);
      header.put("project", project);
      header.put("productType", ProductTypeEnum.getNameByType(productType));
      List<ProjectInstallReportDTO> list = this.installReportService.getProjectInstallDetails(projectId, productType, startDate, endDate);
      BigDecimal totalReportQuantity = Optional.ofNullable(list)
         .filter(CollUtil::isNotEmpty)
         .map(m -> m.stream().map(ProjectInstallReportDTO::getReportQuantity).filter(Objects::nonNull).reduce(BigDecimal.ZERO, BigDecimal::add))
         .orElse(BigDecimal.ZERO);
      header.put("totalReportQuantity", totalReportQuantity);
      printVO.setHeader(header);
      printVO.setTable(list.stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
      return printVO;
   }

   @Override
   public PageVO<ProjectInstallReportDTO> getUserInstallDetails(
      Integer productType, Boolean isMe, LocalDate startDate, LocalDate endDate, Integer pageNumber, Integer pageSize
   ) {
      Preconditions.checkArgument(
         ProductTypeEnum.ARTIFACT.getType().equals(productType) || ProductTypeEnum.ENCLOSURE.getType().equals(productType), "不支持的产品类型！"
      );
      Long currentUserId = UserUtil.getCurrentUserId();
      ProjectManageRoster roster = this.rosterService
         .getOne(
            Wrappers.lambdaQuery(ProjectManageRoster.class)
               .eq(ProjectManageRoster::getUserId, currentUserId)
               .eq(ProjectManageRoster::getStatus, EmployeeStatusEnum.ON_JOB.getType())
         );
      if (roster == null) {
         return new PageVO<>();
      }

      Page page = PageHelper.startPage(pageNumber, pageSize);
      List<ProjectInstallReport> reportList = this.installReportService
         .list(
            Wrappers.lambdaQuery(ProjectInstallReport.class)
               .eq(ProjectInstallReport::getProjectId, roster.getProjectId())
               .eq(ProjectInstallReport::getSupplierId, roster.getSupplierId())
               .eq(ProjectInstallReport::getProductType, productType)
               .eq(ProjectInstallReport::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .eq(isMe, ProjectInstallReport::getUserId, currentUserId)
               .apply(startDate != null, "date_format(create_time, '%Y-%m-%d') >= date_format({0}, '%Y-%m-%d')", startDate)
               .apply(endDate != null, "date_format(create_time, '%Y-%m-%d') <= date_format({0}, '%Y-%m-%d')", endDate)
               .orderByDesc(BaseEntity::getCreateTime)
         );
      if (CollectionUtils.isEmpty(reportList)) {
         return new PageVO<>();
      }

      List<Long> userIds = reportList.stream().map(ProjectInstallReport::getUserId).collect(Collectors.toList());
      Map<Long, String> userMap = this.userService.listByIds(userIds).stream().collect(Collectors.toMap(User::getId, User::getName));
      List<ProjectInstallReportDTO> reportDTOList = reportList.stream().map(e -> {
         ProjectInstallReportDTO reportDTO = BeanUtil.copy(e, ProjectInstallReportDTO.class);
         reportDTO.setReportUserName(userMap.getOrDefault(e.getUserId(), null));
         return reportDTO;
      }).collect(Collectors.toList());
      return new PageVO<>(page, reportDTOList);
   }

   @Override
   public List<ProjectManageModeTaskDTO> getUserTaskQuantity() {
      SecurityUser currentUser = UserUtil.getCurrentUser();
      return UserTypeEnum.TEMP_USER.getType().equals(currentUser.getUserType())
         ? this.getTempUserTaskQuantity(currentUser.getId())
         : this.getCommonUserTaskQuantity(currentUser.getId());
   }

   private List<ProjectManageModeTaskDTO> getCommonUserTaskQuantity(Long currentUserId) {
      List<ProjectManageModeTaskDTO> taskDTOList = Arrays.asList(
         ProjectManageModeTaskDTO.builder().modeTask(ProjectManageMenuTaskEnum.INSTALL_AUDIT.getType()).quantity(0).build(),
         ProjectManageModeTaskDTO.builder().modeTask(ProjectManageMenuTaskEnum.VISA_AUDIT.getType()).quantity(0).build(),
         ProjectManageModeTaskDTO.builder().modeTask(ProjectManageMenuTaskEnum.SAFETY.getType()).quantity(0).build(),
         ProjectManageModeTaskDTO.builder().modeTask(ProjectManageMenuTaskEnum.OVER.getType()).quantity(0).build()
      );
      taskDTOList.forEach(
         taskDTO -> {
            if (ProjectManageMenuTaskEnum.INSTALL_AUDIT.getType().equals(taskDTO.getModeTask())) {
               List<Long> projectIds = this.projectService
                  .listSimpleProject(null, null, null, null)
                  .getContent()
                  .stream()
                  .map(ProjectSimpleInfoDTO::getId)
                  .collect(Collectors.toList());
               if (CollectionUtils.isNotEmpty(projectIds)) {
                  int count = this.installReportService
                     .count(
                        Wrappers.lambdaQuery(ProjectInstallReport.class)
                           .eq(ProjectInstallReport::getAuditStatus, AuditStatusEnum.AUDITING.getType())
                           .in(ProjectInstallReport::getProjectId, projectIds)
                     );
                  taskDTO.setQuantity(count);
               }
            }

            if (ProjectManageMenuTaskEnum.VISA_AUDIT.getType().equals(taskDTO.getModeTask())) {
               Integer count = this.approveRecordService.getCanCheckCount(Collections.singletonList("InstallVisaManage"));
               taskDTO.setQuantity(count);
            }

            if (ProjectManageMenuTaskEnum.SAFETY.getType().equals(taskDTO.getModeTask())) {
               List<Long> projectIds = this.projectService
                  .listSimpleProject(null, null, null, null)
                  .getContent()
                  .stream()
                  .map(ProjectSimpleInfoDTO::getId)
                  .collect(Collectors.toList());
               if (CollectionUtils.isNotEmpty(projectIds)) {
                  int count = this.qhseProblemService
                     .count(
                        Wrappers.lambdaQuery(ProjectQhseProblem.class)
                           .in(ProjectQhseProblem::getProjectId, projectIds)
                           .nested(
                              qw1 -> {
                                 LambdaQueryWrapper var10000 = qw1.eq(ProjectQhseProblem::getIsInternal, Boolean.FALSE)
                                    .eq(ProjectQhseProblem::getBoolChangeStatusV2, QhseStatusEnumV2.REPLIED.getType());
                              }
                           )
                           .or()
                           .nested(
                              qw2 -> {
                                 LambdaQueryWrapper var10000 = qw2.eq(ProjectQhseProblem::getIsInternal, Boolean.TRUE)
                                    .eq(ProjectQhseProblem::getUserId, currentUserId)
                                    .eq(ProjectQhseProblem::getBoolChangeStatusV2, QhseStatusEnumV2.NO_REPLY.getType());
                              }
                           )
                           .or()
                           .nested(
                              qw2 -> {
                                 LambdaQueryWrapper var10000 = qw2.eq(ProjectQhseProblem::getIsInternal, Boolean.TRUE)
                                    .eq(ProjectQhseProblem::getPromoterId, currentUserId)
                                    .eq(ProjectQhseProblem::getBoolChangeStatusV2, QhseStatusEnumV2.REPLIED.getType());
                              }
                           )
                     );
                  taskDTO.setQuantity(count);
               }
            }

            if (ProjectManageMenuTaskEnum.OVER.getType().equals(taskDTO.getModeTask())) {
               MesRoster roster = this.mesRosterService
                  .getOne(
                     Wrappers.lambdaQuery(MesRoster.class)
                        .eq(MesRoster::getUserId, UserUtil.getCurrentUserId())
                        .eq(MesRoster::getStatus, EmployeeStatusEnum.ON_JOB.getType())
                  );
               if (roster != null) {
                  List<Long> configIds = this.overConfigUserLinkService
                     .list(
                        Wrappers.lambdaQuery(MesBuildingAttendanceOverConfigUserLink.class)
                           .eq(MesBuildingAttendanceOverConfigUserLink::getRosterId, roster.getId())
                     )
                     .stream()
                     .map(MesBuildingAttendanceOverConfigUserLink::getOverConfigId)
                     .collect(Collectors.toList());
                  if (CollectionUtils.isNotEmpty(configIds)) {
                     int count = this.overConfigService
                        .count(Wrappers.lambdaQuery(MesBuildingAttendanceOverConfig.class).in(MesBuildingAttendanceOverConfig::getId, configIds).and(q -> {
                           q.apply("DATE_FORMAT(overtime_working_time, '%Y-%m-%d') = {0}", LocalDate.now());
                           q.or();
                           q.apply("DATE_FORMAT(overtime_closing_time, '%Y-%m-%d') = {0}", LocalDate.now());
                        }));
                     taskDTO.setQuantity(count);
                  }
               }
            }
         }
      );
      return taskDTOList;
   }

   private List<ProjectManageModeTaskDTO> getTempUserTaskQuantity(Long currentUserId) {
      List<ProjectManageModeTaskDTO> taskDTOList = Arrays.asList(
         ProjectManageModeTaskDTO.builder().modeTask(ProjectManageMenuTaskEnum.INSTALL.getType()).quantity(0).build(),
         ProjectManageModeTaskDTO.builder().modeTask(ProjectManageMenuTaskEnum.ATTENDANCE.getType()).quantity(0).build(),
         ProjectManageModeTaskDTO.builder().modeTask(ProjectManageMenuTaskEnum.SAFETY.getType()).quantity(0).build()
      );
      ProjectManageRoster roster = this.rosterService
         .getOne(
            Wrappers.lambdaQuery(ProjectManageRoster.class)
               .eq(ProjectManageRoster::getUserId, currentUserId)
               .eq(ProjectManageRoster::getStatus, EmployeeStatusEnum.ON_JOB.getType())
         );
      if (roster == null) {
         return taskDTOList;
      }

      taskDTOList.forEach(
         taskDTO -> {
            if (ProjectManageMenuTaskEnum.INSTALL.getType().equals(taskDTO.getModeTask())) {
               ContractProject project = this.projectService.checkProjectStatus(roster.getProjectId());
               Integer installDivideMethod = project.getInstallDivideMethod();
               if (ReportMethodEnum.APP.getType().equals(project.getInstallReportMethod())) {
                  if (DivideMethodEnum.AREA.getType().equals(installDivideMethod)) {
                     List<ProjectSupplierAreaLink> areaLinkList = this.supplierAreaLinkService
                        .list(
                           Wrappers.lambdaQuery(ProjectSupplierAreaLink.class)
                              .eq(ProjectSupplierAreaLink::getProjectId, project.getId())
                              .eq(ProjectSupplierAreaLink::getSupplierId, roster.getSupplierId())
                              .eq(ProjectSupplierAreaLink::getBoolRelationStatus, true)
                              .eq(ProjectSupplierAreaLink::getBoolSettlementStatus, false)
                        );
                     List<Long> areaIds = areaLinkList.stream().map(ProjectSupplierAreaLink::getAreaId).distinct().collect(Collectors.toList());
                     if (CollectionUtils.isEmpty(areaIds)) {
                        taskDTO.setQuantity(0);
                     }

                     ProjectBaseQueryDTOParam param = new ProjectBaseQueryDTOParam();
                     param.setSupplierId(roster.getSupplierId());
                     param.setProjectId(roster.getProjectId());
                     param.setAreaIds(areaIds);
                     param.setProductType(ProductTypeEnum.ARTIFACT.getType());
                     List<ProjectReceivingInstallDTO> installDTOList = this.receivingSummaryService.listReceivingInstallV2(param);
                     taskDTO.setQuantity(installDTOList.size());
                     param.setProductType(ProductTypeEnum.ENCLOSURE.getType());
                     List<ProjectReceivingInstallDTO> installDTOList2 = this.receivingSummaryService.listReceivingInstallV2(param);
                     taskDTO.setQuantity(taskDTO.getQuantity() + installDTOList2.size());
                  }

                  if (DivideMethodEnum.LIST.getType().equals(installDivideMethod)) {
                     ProjectBaseQueryDTOParam param = new ProjectBaseQueryDTOParam();
                     param.setSupplierId(roster.getSupplierId());
                     param.setProductType(ProductTypeEnum.ARTIFACT.getType());
                     param.setProjectId(roster.getProjectId());
                     List<ProjectReceivingInstallDTO> installDTOList = this.receivingSummaryService.getListMethodReceivingInstall(param);
                     taskDTO.setQuantity(installDTOList.size());
                     param.setProductType(ProductTypeEnum.ENCLOSURE.getType());
                     List<ProjectReceivingInstallDTO> installDTOList2 = this.receivingSummaryService.getListMethodReceivingInstall(param);
                     taskDTO.setQuantity(taskDTO.getQuantity() + installDTOList2.size());
                  }
               }
            }

            if (ProjectManageMenuTaskEnum.ATTENDANCE.getType().equals(taskDTO.getModeTask())) {
               ProjectManageAttendance attendanceTask = this.attendanceService
                  .getOne(
                     Wrappers.lambdaQuery(ProjectManageAttendance.class)
                        .eq(ProjectManageAttendance::getProjectManageRosterId, roster.getId())
                        .eq(ProjectManageAttendance::getAttendanceDate, LocalDate.now())
                        .eq(ProjectManageAttendance::getIsCancel, Boolean.FALSE)
                  );
               if (attendanceTask != null && !attendanceTask.getAttendStatus().equals(AttendStatusEnum.NORMAL.getType())) {
                  taskDTO.setQuantity(1);
               }
            }

            if (ProjectManageMenuTaskEnum.SAFETY.getType().equals(taskDTO.getModeTask())) {
               int count = this.qhseProblemService
                  .count(
                     Wrappers.lambdaQuery(ProjectQhseProblem.class)
                        .eq(ProjectQhseProblem::getProjectId, roster.getProjectId())
                        .eq(ProjectQhseProblem::getSupplierId, roster.getSupplierId())
                        .eq(ProjectQhseProblem::getBoolChangeStatusV2, QhseStatusEnumV2.NO_REPLY.getType())
                        .eq(ProjectQhseProblem::getUserId, currentUserId)
                        .eq(ProjectQhseProblem::getIsInternal, Boolean.FALSE)
                  );
               taskDTO.setQuantity(count);
            }
         }
      );
      return taskDTOList;
   }
}
