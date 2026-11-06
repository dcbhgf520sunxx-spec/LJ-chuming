package com.hzchum.scim.project.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dtoParam.WmsApproveOpinionDTOParam;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectSimpleInfoDTO;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.plan.core.api.pojo._do.EnclosurePlan;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechEnclosure;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.pojo._do.TechStandardPart;
import com.hzchum.scim.plan.core.api.pojo.dto.ProjectProductDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.product.TechProductDTO;
import com.hzchum.scim.plan.core.api.service.EnclosurePlanService;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechEnclosureService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.plan.core.api.service.TechStandardPartService;
import com.hzchum.scim.project.core.api.enums.ProductTypeUpEnum;
import com.hzchum.scim.project.core.api.pojo._do.ProjectReceivingRecord;
import com.hzchum.scim.project.core.api.pojo._do.ProjectReceivingSummary;
import com.hzchum.scim.project.core.api.pojo._do.ProjectReject;
import com.hzchum.scim.project.core.api.pojo._do.ProjectRejectDetail;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectRejectDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectRejectDetailDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ProjectReceivedQueryDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ProjectRejectDetailQueryDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ProjectRejectQueryDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectRejectProductDTOParam;
import com.hzchum.scim.project.core.api.service.ProjectReceivingRecordService;
import com.hzchum.scim.project.core.api.service.ProjectReceivingSummaryService;
import com.hzchum.scim.project.core.api.service.ProjectRejectDetailService;
import com.hzchum.scim.project.core.api.service.ProjectRejectService;
import com.hzchum.scim.project.core.mapper.ProjectRejectDetailMapper;
import com.hzchum.scim.project.core.mapper.ProjectRejectMapper;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrder;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrderDetail;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderDetailService;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import com.hzchum.scim.system.core.api.common.enums.NumberTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.service.NumberConfigService;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.SubjectMeasureDTO;
import com.hzchum.scim.wms.core.api.service.wmsConfig.MeasureService;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectRejectServiceImpl extends ServiceImpl<ProjectRejectMapper, ProjectReject> implements ProjectRejectService {
   @Resource
   private NumberConfigService numberConfigService;
   @Resource
   private ProjectReceivingRecordService receivingRecordService;
   @Resource
   private MeasureService measureService;
   @Resource
   private ProjectRejectDetailService projectRejectDetailService;
   @Resource
   private ProjectRejectDetailMapper projectRejectDetailMapper;
   @Resource
   private ContractProjectService projectService;
   @Resource
   private PurchaseOrderDetailService orderDetailService;
   @Resource
   private PurchaseOrderService purchaseOrderService;
   @Resource
   private PlanMonomerService monomerService;
   @Resource
   private PlanAreaService areaService;
   @Resource
   private SupplierService supplierService;
   @Resource
   private EnclosurePlanService enclosurePlanService;
   @Resource
   private ProjectReceivingSummaryService receivingSummaryService;
   @Resource
   private TechArtifactService artifactService;
   @Resource
   private TechEnclosureService enclosureService;
   @Resource
   private TechAssembleService assembleService;
   @Resource
   private TechMachinePartService machinePartService;
   @Resource
   private TechStandardPartService techStandardPartService;

   @Transactional
   @Override
   public Boolean saveProjectReject(Long projectId, List<ProjectRejectProductDTOParam> paramList) {
      ContractProject project = this.projectService.checkProjectStatus(projectId);
      String serviceNumber = this.numberConfigService.getNumber(NumberTypeEnum.PROJECT_REJECT, this.baseMapper.getCount(LocalDateTime.now()));
      ProjectReject projectReject = ProjectReject.builder()
         .projectId(projectId)
         .serialNumber(serviceNumber)
         .applicantName(UserUtil.getCurrentName())
         .applicantId(UserUtil.getCurrentUserId())
         .reviewStatus(ReviewStatusEnum.AUDITING.getType())
         .build();
      List<ProjectProductDTO> outReceivedPage = this.receivingRecordService
         .getOutReceivedList(ProjectReceivedQueryDTOParam.builder().projectId(projectId).build());
      Map<Long, ProjectProductDTO> canRejectMap = outReceivedPage.stream().collect(Collectors.toMap(ProjectProductDTO::getId, Function.identity()));
      this.save(projectReject);
      Integer productType = 0;
      this.checkRejectMete(canRejectMap, paramList);
      List<ProjectRejectDetail> saveList = new ArrayList<>();

      for (ProjectRejectProductDTOParam param : paramList) {
         ProjectProductDTO recordDTO = canRejectMap.get(param.getReceivedId());
         ProjectRejectDetail rejectDetail = ProjectRejectDetail.builder()
            .purchaseDetailsId(recordDTO.getPurchaseDetailsId())
            .receivedId(recordDTO.getId())
            .rejectId(projectReject.getId())
            .rejectSn(serviceNumber)
            .receivedDate(recordDTO.getCreateTime())
            .supplierId(recordDTO.getSupplier().getId())
            .purchaseSn(recordDTO.getPurchaseSn())
            .enclosurePlanId(recordDTO.getEnclosurePlanId())
            .receivedUserName(recordDTO.getUserName())
            .productType(recordDTO.getProductType())
            .productId(recordDTO.getProductId())
            .projectId(projectId)
            .monomerId(recordDTO.getMonomerId())
            .areaId(recordDTO.getAreaId())
            .serialNumber(recordDTO.getSerialNumber())
            .projectType(project.getProjectType())
            .name(recordDTO.getName())
            .specification(recordDTO.getSpecification())
            .rejectQuantity(param.getRejectQuantity())
            .rejectActualReceivedMete(param.getRejectActualReceivedMete())
            .classifyId(recordDTO.getClassifyId())
            .accountingUnit(recordDTO.getAccountingUnit())
            .measureUnit(recordDTO.getMeasureUnit())
            .applicantName(UserUtil.getCurrentName())
            .applicantId(UserUtil.getCurrentUserId())
            .reviewStatus(ReviewStatusEnum.AUDITING.getType())
            .wageQuotaType(recordDTO.getWageQuotaType())
            .build();
         if (ProductTypeUpEnum.RAW_MATERIAL.getType().equals(recordDTO.getProductType())) {
            SubjectMeasureDTO subjectMeasureDTO = this.measureService.measureListById(recordDTO.getClassifyId());
            Preconditions.checkArgument(subjectMeasureDTO != null, "操作失败，未获取到原材料单位配置信息！");
            if (subjectMeasureDTO.getMeasureUnit() != null) {
               BigDecimal rejectQuantity = param.getRejectQuantity();
               if (rejectQuantity.compareTo(recordDTO.getCanRejectQuantity()) == 0) {
                  rejectDetail.setRejectMete(recordDTO.getCanRejectMete());
                  rejectDetail.setRejectActualReceivedMete(recordDTO.getCanRejectActualReceivedMete());
               } else {
                  BigDecimal b = rejectQuantity.divide(recordDTO.getQuantity(), 20, 4);
                  rejectDetail.setRejectMete(b.multiply(recordDTO.getMete()).setScale(0, 4));
                  rejectDetail.setRejectActualReceivedMete(b.multiply(recordDTO.getActualReceivedMete()).setScale(0, 4));
               }
            } else {
               rejectDetail.setRejectMete(param.getRejectActualReceivedMete());
            }
         } else if (ProductTypeUpEnum.ARTIFACT.getType().equals(recordDTO.getProductType())) {
            BigDecimal rejectQuantity = param.getRejectQuantity();
            if (rejectQuantity.compareTo(recordDTO.getCanRejectQuantity()) == 0) {
               rejectDetail.setRejectMete(recordDTO.getCanRejectMete());
               rejectDetail.setRejectActualReceivedMete(recordDTO.getCanRejectActualReceivedMete());
            } else {
               BigDecimal b = rejectQuantity.divide(recordDTO.getCanRejectQuantity(), 20, 4);
               rejectDetail.setRejectMete(b.multiply(recordDTO.getCanRejectMete()).setScale(0, 4));
               rejectDetail.setRejectActualReceivedMete(b.multiply(recordDTO.getCanRejectActualReceivedMete()).setScale(0, 4));
            }
         } else {
            if (!ProductTypeUpEnum.ENCLOSURE.getType().equals(recordDTO.getProductType())) {
               throw new BusinessException("暂不支持的外购退货产品类型！");
            }

            BigDecimal rejectQuantity = param.getRejectQuantity();
            if (rejectQuantity.compareTo(recordDTO.getCanRejectQuantity()) == 0) {
               rejectDetail.setRejectMete(recordDTO.getCanRejectMete());
               rejectDetail.setRejectActualReceivedMete(recordDTO.getCanRejectActualReceivedMete());
            } else {
               BigDecimal b = rejectQuantity.divide(recordDTO.getCanRejectQuantity(), 20, 4);
               rejectDetail.setRejectMete(b.multiply(recordDTO.getCanRejectMete()).setScale(0, 4));
               rejectDetail.setRejectActualReceivedMete(b.multiply(recordDTO.getCanRejectActualReceivedMete()).setScale(0, 4));
            }
         }

         saveList.add(rejectDetail);
         productType = productType | recordDTO.getProductType();
      }

      projectReject.setProductType(productType);
      this.projectRejectDetailService.saveBatch(saveList);
      return this.updateById(projectReject);
   }

   @Override
   public PageVO<ProjectRejectDTO> getProjectRejectPage(ProjectRejectQueryDTOParam param, Integer pageNumber, Integer pageSize) {
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(projectIds)) {
         return new PageVO<>();
      }

      param.setProjectIds(projectIds);
      Page page = PageHelper.startPage(pageNumber, pageSize);
      List<ProjectReject> rejectList = this.baseMapper.getProjectRejectPage(param);
      List<ProjectRejectDTO> rejectDTOList = this.convertToProjectRejectDTO(rejectList);
      return new PageVO<>(page, rejectDTOList);
   }

   @Transactional
   @Override
   public Boolean check(WmsApproveOpinionDTOParam param) {
      ProjectReject reject = this.getById(param.getDataId());
      Preconditions.checkArgument(reject != null, "外购退货单不存在!");
      Preconditions.checkArgument(ReviewStatusEnum.AUDITING.getType().equals(reject.getReviewStatus()), "外购退货单状态已改变!");
      Preconditions.checkArgument(
         ReviewStatusEnum.REVIEWED.getType().equals(param.getDecision()) || ReviewStatusEnum.RETURNED.getType().equals(param.getDecision()), "审核类型不正确！"
      );
      if (ReviewStatusEnum.REVIEWED.getType().equals(param.getDecision())) {
         this.passed(reject);
      } else {
         this.projectRejectDetailService
            .update(
               null,
               (Wrapper<ProjectRejectDetail>)(((((new LambdaUpdateWrapper<ProjectRejectDetail>()
                                 .eq(ProjectRejectDetail::getRejectId, reject.getId()))
                              .set(ProjectRejectDetail::getReviewStatus, ReviewStatusEnum.RETURNED.getType()))
                           .set(BaseEntity::getUpdateTime, LocalDateTime.now()))
                        .set(ProjectRejectDetail::getReviewTime, LocalDateTime.now()))
                     .set(ProjectRejectDetail::getReviewerId, UserUtil.getCurrentUserId()))
                  .set(ProjectRejectDetail::getReviewerName, UserUtil.getCurrentName())
            );
      }

      reject.setReviewStatus(param.getDecision());
      reject.setReviewerId(UserUtil.getCurrentUserId());
      reject.setReviewerName(UserUtil.getCurrentName());
      reject.setReviewTime(LocalDateTime.now());
      this.updateById(reject);
      return Boolean.TRUE;
   }

   @Override
   public ProjectRejectDTO getDetail(Long rejectId, Integer productType) {
      ProjectReject reject = this.getById(rejectId);
      Preconditions.checkArgument(reject != null, "外购退货单不存在！请刷新后重试！");
      ProjectRejectDTO rejectDTO = BeanUtil.copy(reject, ProjectRejectDTO.class);
      if (reject.getProjectId() != null) {
         ProjectInfo project = this.projectService.getSimpleById(reject.getProjectId());
         rejectDTO.setProject(project);
      }

      List<ProjectRejectDetail> detailList = this.projectRejectDetailService
         .list(
            Wrappers.lambdaQuery(ProjectRejectDetail.class)
               .eq(ProjectRejectDetail::getRejectId, reject.getId())
               .eq(productType != null, ProjectRejectDetail::getProductType, productType)
         );
      List<ProjectRejectDetailDTO> dtoList = this.convertToProjectRejectDetailDTO(detailList);
      rejectDTO.setDtoList(dtoList);
      return rejectDTO;
   }

   @Override
   public PageVO<ProjectRejectDetailDTO> getProjectRejectDetailPage(ProjectRejectDetailQueryDTOParam param, Integer pageNumber, Integer pageSize) {
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(projectIds)) {
         return new PageVO<>();
      }

      param.setProjectIds(projectIds);
      Page page = PageHelper.startPage(pageNumber, pageSize);
      List<ProjectRejectDetailDTO> dtoList = this.projectRejectDetailMapper.getProjectRejectDetailList(param);
      this.fillProjectRejectDetailDTO(dtoList);
      return new PageVO<>(page, dtoList);
   }

   private void fillProjectRejectDetailDTO(List<ProjectRejectDetailDTO> dtoList) {
      if (!CollectionUtils.isEmpty(dtoList)) {
         List<Long> purchaseDetailsIds = dtoList.stream()
            .map(ProjectRejectDetailDTO::getPurchaseDetailsId)
            .filter(Objects::nonNull)
            .distinct()
            .collect(Collectors.toList());
         Map<Long, PurchaseOrderDetail> purchaseOrderDetailMap = this.orderDetailService
            .listByIds(purchaseDetailsIds)
            .stream()
            .collect(Collectors.toMap(PurchaseOrderDetail::getId, Function.identity()));
         dtoList.forEach(detail -> {
            if (detail.getPurchaseDetailsId() != null) {
               PurchaseOrderDetail purchaseOrderDetail = purchaseOrderDetailMap.getOrDefault(detail.getPurchaseDetailsId(), new PurchaseOrderDetail());
               detail.setBasicClass(purchaseOrderDetail.getBasicClass());
               detail.setClassifyId(purchaseOrderDetail.getClassifyId());
               detail.setBrand(purchaseOrderDetail.getBrand());
               detail.setColor(purchaseOrderDetail.getColor());
               detail.setThickness(purchaseOrderDetail.getThickness());
               detail.setWidth(purchaseOrderDetail.getWidth());
               detail.setLength(purchaseOrderDetail.getLength());
            }

            if (ProductTypeUpEnum.RAW_MATERIAL.getType().equals(detail.getProductType())) {
               SubjectMeasureDTO subjectMeasureDTO = this.measureService.measureListById(detail.getClassifyId());
               Preconditions.checkArgument(subjectMeasureDTO != null, "操作失败，未获取到原材料单位配置信息！");
               detail.setAccountingPrecision(subjectMeasureDTO.getAccountingPrecision());
               detail.setMeasurePrecision(subjectMeasureDTO.getMeasurePrecision());
            }
         });
      }
   }

   @Override
   public PrintVO<List<Map<String, Object>>> getProjectRejectDetailPrint(ProjectRejectDetailQueryDTOParam param) {
      List<ProjectRejectDetailDTO> dtoList = this.projectRejectDetailMapper.getProjectRejectDetailList(param);
      this.fillProjectRejectDetailDTO(dtoList);
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      List<Map<String, Object>> mapList = dtoList.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }

   private List<ProjectRejectDetailDTO> convertToProjectRejectDetailDTO(List<ProjectRejectDetail> detailList) {
      if (CollectionUtils.isEmpty(detailList)) {
         return new ArrayList<>();
      }

      List<Long> supplierIds = detailList.stream().map(ProjectRejectDetail::getSupplierId).filter(Objects::nonNull).distinct().collect(Collectors.toList());
      Map<Long, Supplier> supplierMap = this.supplierService.listByIds(supplierIds).stream().collect(Collectors.toMap(Supplier::getId, Function.identity()));
      List<Long> monomerIds = detailList.stream().map(ProjectRejectDetail::getMonomerId).filter(Objects::nonNull).distinct().collect(Collectors.toList());
      List<Long> areaIds = detailList.stream().map(ProjectRejectDetail::getAreaId).filter(Objects::nonNull).distinct().collect(Collectors.toList());
      List<Long> enclosurePlanIds = detailList.stream()
         .map(ProjectRejectDetail::getEnclosurePlanId)
         .filter(Objects::nonNull)
         .distinct()
         .collect(Collectors.toList());
      List<Long> purchaseDetailsIds = detailList.stream()
         .map(ProjectRejectDetail::getPurchaseDetailsId)
         .filter(Objects::nonNull)
         .distinct()
         .collect(Collectors.toList());
      Map<Long, PurchaseOrderDetail> purchaseOrderDetailMap = this.orderDetailService
         .listByIds(purchaseDetailsIds)
         .stream()
         .collect(Collectors.toMap(PurchaseOrderDetail::getId, Function.identity()));
      Map<Long, PlanMonomer> monomerMap = new HashMap<>();
      Map<Long, PlanArea> areaMap = new HashMap<>();
      Map<Long, EnclosurePlan> batchMap = new HashMap<>();
      if (CollectionUtils.isNotEmpty(monomerIds)) {
         monomerMap = this.monomerService.listByIds(monomerIds).stream().collect(Collectors.toMap(PlanMonomer::getId, Function.identity()));
      }

      if (CollectionUtils.isNotEmpty(areaIds)) {
         areaMap = this.areaService.listByIds(areaIds).stream().collect(Collectors.toMap(PlanArea::getId, Function.identity()));
      }

      if (CollectionUtils.isNotEmpty(enclosurePlanIds)) {
         batchMap = this.enclosurePlanService.listByIds(enclosurePlanIds).stream().collect(Collectors.toMap(EnclosurePlan::getId, Function.identity()));
      }

      Map<Long, PlanMonomer> finalMonomerMap = monomerMap;
      Map<Long, PlanArea> finalAreaMap = areaMap;
      Map<Long, EnclosurePlan> finalBatchMap = batchMap;
      return detailList.stream().map(detail -> {
         ProjectRejectDetailDTO detailDTO = BeanUtil.copy(detail, ProjectRejectDetailDTO.class);
         if (detail.getSupplierId() != null) {
            Supplier supplier = supplierMap.getOrDefault(detail.getSupplierId(), new Supplier());
            detailDTO.setSupplier(NameInfo.builder().id(supplier.getId()).name(supplier.getName()).build());
         }

         if (detail.getMonomerId() != null) {
            PlanMonomer monomer = finalMonomerMap.getOrDefault(detail.getMonomerId(), new PlanMonomer());
            detailDTO.setMonomer(NameInfo.builder().id(monomer.getId()).name(monomer.getName()).build());
         }

         if (detail.getAreaId() != null) {
            PlanArea area = finalAreaMap.getOrDefault(detail.getMonomerId(), new PlanArea());
            detailDTO.setMonomer(NameInfo.builder().id(area.getId()).name(area.getName()).build());
         }

         if (detail.getEnclosurePlanId() != null) {
            EnclosurePlan batch = finalBatchMap.getOrDefault(detail.getEnclosurePlanId(), new EnclosurePlan());
            detailDTO.setBatch(NameInfo.builder().id(batch.getId()).name(batch.getName()).build());
         }

         if (detail.getPurchaseDetailsId() != null) {
            PurchaseOrderDetail purchaseOrderDetail = purchaseOrderDetailMap.getOrDefault(detail.getPurchaseDetailsId(), new PurchaseOrderDetail());
            detailDTO.setBasicClass(purchaseOrderDetail.getBasicClass());
            detailDTO.setClassifyId(purchaseOrderDetail.getClassifyId());
            detailDTO.setBrand(purchaseOrderDetail.getBrand());
            detailDTO.setColor(purchaseOrderDetail.getColor());
            detailDTO.setThickness(purchaseOrderDetail.getThickness());
            detailDTO.setWidth(purchaseOrderDetail.getWidth());
            detailDTO.setLength(purchaseOrderDetail.getLength());
         }

         if (ProductTypeUpEnum.RAW_MATERIAL.getType().equals(detail.getProductType())) {
            SubjectMeasureDTO subjectMeasureDTO = this.measureService.measureListById(detail.getClassifyId());
            Preconditions.checkArgument(subjectMeasureDTO != null, "操作失败，未获取到原材料单位配置信息！");
            detailDTO.setAccountingPrecision(subjectMeasureDTO.getAccountingPrecision());
            detailDTO.setMeasurePrecision(subjectMeasureDTO.getMeasurePrecision());
         }

         return detailDTO;
      }).collect(Collectors.toList());
   }

   private void passed(ProjectReject reject) {
      for (ProjectRejectDetail rejectDetail : this.projectRejectDetailService
         .list(Wrappers.lambdaQuery(ProjectRejectDetail.class).eq(ProjectRejectDetail::getRejectId, reject.getId()))) {
         rejectDetail.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
         rejectDetail.setReviewerId(UserUtil.getCurrentUserId());
         rejectDetail.setReviewerName(UserUtil.getCurrentName());
         rejectDetail.setReviewTime(LocalDateTime.now());
         PurchaseOrderDetail purchaseOrderDetail = this.orderDetailService.getById(rejectDetail.getPurchaseDetailsId());
         purchaseOrderDetail.setReceivedQuantity(purchaseOrderDetail.getReceivedQuantity().subtract(rejectDetail.getRejectQuantity()));
         purchaseOrderDetail.setReceivedMete(purchaseOrderDetail.getReceivedMete().subtract(rejectDetail.getRejectMete()));
         purchaseOrderDetail.setActualReceivedMete(purchaseOrderDetail.getActualReceivedMete().subtract(rejectDetail.getRejectActualReceivedMete()));
         this.orderDetailService.updateById(purchaseOrderDetail);
         PurchaseOrder purchaseOrder = this.purchaseOrderService.getById(purchaseOrderDetail.getPurchaseId());
         if (purchaseOrder.getPurchaseStatus() == 2) {
            purchaseOrder.setPurchaseStatus(1);
            this.purchaseOrderService.updateById(purchaseOrder);
         }

         ProjectReceivingRecord receivingRecord = this.receivingRecordService.getById(rejectDetail.getReceivedId());
         receivingRecord.setRejectQuantity(receivingRecord.getRejectQuantity().add(rejectDetail.getRejectQuantity()));
         receivingRecord.setRejectMete(receivingRecord.getRejectMete().add(rejectDetail.getRejectMete()));
         receivingRecord.setRejectActualReceivedMete(receivingRecord.getRejectActualReceivedMete().add(rejectDetail.getRejectActualReceivedMete()));
         this.receivingRecordService.updateById(receivingRecord);
         this.buildReduceParam(rejectDetail);
         this.projectRejectDetailService.updateById(rejectDetail);
      }
   }

   private void buildReduceParam(ProjectRejectDetail rejectDetail) {
      if (ProductTypeUpEnum.RAW_MATERIAL.getType().equals(rejectDetail.getProductType())) {
         ProjectReceivingRecord reduceParam = new ProjectReceivingRecord();
         reduceParam.setProjectType(rejectDetail.getProjectType());
         reduceParam.setProductType(rejectDetail.getProductType());
         reduceParam.setPurchaseDetailsId(rejectDetail.getPurchaseDetailsId());
         reduceParam.setMete(rejectDetail.getRejectMete());
         reduceParam.setActualReceivedMete(rejectDetail.getRejectActualReceivedMete());
         if (rejectDetail.getRejectQuantity() != null) {
            reduceParam.setQuantity(rejectDetail.getRejectQuantity());
         } else {
            reduceParam.setQuantity(BigDecimal.ZERO);
         }

         this.receivingSummaryService.reduceMete(reduceParam);
      } else {
         TechProductDTO techProductDTO = this.getProductInfoBy(rejectDetail.getProductId(), rejectDetail.getProductType());
         ProjectReceivingRecord reduceParam = BeanUtil.copy(techProductDTO, ProjectReceivingRecord.class);
         reduceParam.setProjectType(rejectDetail.getProjectType());
         reduceParam.setProductType(rejectDetail.getProductType());
         reduceParam.setProductId(techProductDTO.getId());
         reduceParam.setQuantity(rejectDetail.getRejectQuantity());
         if (ProductTypeEnum.ARTIFACT.getType().equals(rejectDetail.getProductType())) {
            reduceParam.setMete(techProductDTO.getNetWeight().multiply(rejectDetail.getRejectQuantity()));
            reduceParam.setTotalArea(techProductDTO.getSurfaceArea().multiply(rejectDetail.getRejectQuantity()));
         }

         if (ProductTypeEnum.ENCLOSURE.getType().equals(rejectDetail.getProductType())) {
            reduceParam.setMete(techProductDTO.getLength().multiply(rejectDetail.getRejectQuantity()));
            reduceParam.setTotalArea(techProductDTO.getUnfoldedWidth().multiply(techProductDTO.getLength()).multiply(rejectDetail.getRejectQuantity()));
         }

         this.receivingSummaryService.reduceMete(reduceParam);
      }
   }

   public TechProductDTO getProductInfoBy(Long productId, Integer productType) {
      Preconditions.checkArgument(productId != null && productType != null, "产品id和产品类型不能为空!");
      TechProductDTO techProductDTO = new TechProductDTO();
      if (ProductTypeEnum.MACHINE_PART.getType().equals(productType)) {
         TechMachinePart machinePart = this.machinePartService.getById(productId);
         Preconditions.checkArgument(machinePart != null, "产品id有误,零件不存在!");
         BeanUtil.copy(machinePart, techProductDTO);
      }

      if (ProductTypeEnum.ARTIFACT.getType().equals(productType)) {
         TechArtifact artifact = this.artifactService.getById(productId);
         Preconditions.checkArgument(artifact != null, "产品id有误,构件不存在!");
         BeanUtil.copy(artifact, techProductDTO);
      }

      if (ProductTypeEnum.ASSEMBLE.getType().equals(productType)) {
         TechAssemble assemble = this.assembleService.getById(productId);
         Preconditions.checkArgument(assemble != null, "产品id有误,组立不存在!");
         BeanUtil.copy(assemble, techProductDTO);
      }

      if (ProductTypeEnum.ENCLOSURE.getType().equals(productType)) {
         TechEnclosure enclosure = this.enclosureService.getById(productId);
         Preconditions.checkArgument(enclosure != null, "产品id有误,围护不存在!");
         BeanUtil.copy(enclosure, techProductDTO);
      }

      if (ProductTypeEnum.AUXILIARY_MATERIAL.getType().equals(productType)) {
         TechStandardPart standardPart = this.techStandardPartService.getById(productId);
         Preconditions.checkArgument(standardPart != null, "产品id有误,配套件不存在!");
         BeanUtil.copy(standardPart, techProductDTO);
      }

      return techProductDTO;
   }

   private List<ProjectRejectDTO> convertToProjectRejectDTO(List<ProjectReject> rejectList) {
      return CollectionUtils.isEmpty(rejectList) ? new ArrayList<>() : rejectList.stream().map(e -> {
         ProjectRejectDTO rejectDTO = BeanUtil.copy(e, ProjectRejectDTO.class);
         if (e.getProjectId() != null) {
            ProjectInfo project = this.projectService.getSimpleById(e.getProjectId());
            rejectDTO.setProject(project);
         }

         return rejectDTO;
      }).collect(Collectors.toList());
   }

   private void checkRejectMete(Map<Long, ProjectProductDTO> canRejectMap, List<ProjectRejectProductDTOParam> paramList) {
      paramList.forEach(
         param -> {
            ProjectProductDTO record = canRejectMap.get(param.getReceivedId());
            Preconditions.checkArgument(record != null, "可退货产品不存在！请刷新后重试！");
            if (ProductTypeUpEnum.RAW_MATERIAL.getType().equals(record.getProductType())) {
               SubjectMeasureDTO subjectMeasureDTO = this.measureService.measureListById(record.getClassifyId());
               Preconditions.checkArgument(subjectMeasureDTO != null, "操作失败，未获取到原材料单位配置信息！");
               if (subjectMeasureDTO.getMeasureUnit() != null) {
                  Preconditions.checkArgument(record.getCanRejectQuantity().compareTo(param.getRejectQuantity()) >= 0, record.getName() + "可外购退货数量不足！");
               } else {
                  Preconditions.checkArgument(
                     record.getCanRejectActualReceivedMete().compareTo(param.getRejectActualReceivedMete()) >= 0, record.getName() + "可外购退货实收核算量不足！"
                  );
               }
            } else if (ProductTypeUpEnum.ARTIFACT.getType().equals(record.getProductType())) {
               Preconditions.checkArgument(record.getCanRejectQuantity().compareTo(param.getRejectQuantity()) >= 0, record.getName() + "可外购退货数量不足！");
               ProjectReceivingSummary summary = this.receivingSummaryService
                  .getOne(
                     Wrappers.lambdaQuery(ProjectReceivingSummary.class)
                        .eq(ProjectReceivingSummary::getProductId, record.getProductId())
                        .eq(ProjectReceivingSummary::getProductType, record.getProductType())
                  );
               Preconditions.checkArgument(summary != null, "操作失败，库存中不存在该产品信息！");
               Preconditions.checkArgument(
                  summary.getQuantity().subtract(summary.getInstallQuantity()).compareTo(param.getRejectQuantity()) >= 0, "操作失败,产品已开始安装,库存中剩余数量不足"
               );
               Map<Long, BigDecimal> auditingRejectMap = this.projectRejectDetailMapper
                  .selectList(
                     Wrappers.lambdaQuery(ProjectRejectDetail.class)
                        .eq(ProjectRejectDetail::getReviewStatus, ReviewStatusEnum.AUDITING.getType())
                        .eq(ProjectRejectDetail::getProductType, record.getProductType())
                  )
                  .stream()
                  .collect(
                     Collectors.groupingBy(
                        ProjectRejectDetail::getProductId,
                        Collectors.mapping(ProjectRejectDetail::getRejectQuantity, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))
                     )
                  );
               if (auditingRejectMap.containsKey(record.getProductId())) {
                  BigDecimal rejectQuantity = auditingRejectMap.get(record.getProductId());
                  Preconditions.checkArgument(
                     summary.getQuantity().subtract(summary.getInstallQuantity()).subtract(rejectQuantity).compareTo(param.getRejectQuantity()) >= 0,
                     "已存在审核中的相同产品，提交审核总数量大于库存数量！"
                  );
               }
            } else {
               if (!ProductTypeUpEnum.ENCLOSURE.getType().equals(record.getProductType())) {
                  throw new BusinessException("暂不支持的外购退货产品类型！");
               }

               Preconditions.checkArgument(record.getCanRejectQuantity().compareTo(param.getRejectQuantity()) >= 0, record.getName() + "可外购退货数量不足！");
               ProjectReceivingSummary summary = this.receivingSummaryService
                  .getOne(
                     Wrappers.lambdaQuery(ProjectReceivingSummary.class)
                        .eq(ProjectReceivingSummary::getProductId, record.getProductId())
                        .eq(ProjectReceivingSummary::getProductType, record.getProductType())
                  );
               Preconditions.checkArgument(summary != null, "操作失败，库存中不存在该产品信息！");
               Preconditions.checkArgument(
                  summary.getQuantity().subtract(summary.getInstallQuantity()).compareTo(param.getRejectQuantity()) >= 0, "操作失败,产品已开始安装,库存中剩余数量不足"
               );
               Map<Long, BigDecimal> auditingRejectMap = this.projectRejectDetailMapper
                  .selectList(
                     Wrappers.lambdaQuery(ProjectRejectDetail.class)
                        .eq(ProjectRejectDetail::getReviewStatus, ReviewStatusEnum.AUDITING.getType())
                        .eq(ProjectRejectDetail::getProductType, record.getProductType())
                  )
                  .stream()
                  .collect(
                     Collectors.groupingBy(
                        ProjectRejectDetail::getProductId,
                        Collectors.mapping(ProjectRejectDetail::getRejectQuantity, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))
                     )
                  );
               if (auditingRejectMap.containsKey(record.getProductId())) {
                  BigDecimal rejectQuantity = auditingRejectMap.get(record.getProductId());
                  Preconditions.checkArgument(
                     summary.getQuantity().subtract(summary.getInstallQuantity()).subtract(rejectQuantity).compareTo(param.getRejectQuantity()) >= 0,
                     "已存在审核中的相同产品，提交审核总数量大于库存数量！"
                  );
               }
            }
         }
      );
   }
}
