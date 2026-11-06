package com.hzchum.scim.wms.core.service.impl.wmsUse;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.ApproveRecordStatusEnum;
import com.hzchum.scim.common.core.api.enums.CheckStatusEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.enums.TableNameTypeEnum;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordFlowDTO;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.enums.cargoList.ChangeFreightEnum;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.scm.core.api.pojo._do.LogisticsOrder;
import com.hzchum.scim.scm.core.api.pojo._do.LogisticsOrderChangeRecord;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrderDetail;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import com.hzchum.scim.scm.core.api.pojo.dto.ProjectInfoDTO;
import com.hzchum.scim.scm.core.api.service.LogisticsOrderChangeRecordService;
import com.hzchum.scim.scm.core.api.service.LogisticsOrderService;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderDetailService;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.enums.NumberTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.service.NumberConfigService;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.enums.InvoiceTypeEnum;
import com.hzchum.scim.wms.core.api.enums.MaterialFreezeTypeEnum;
import com.hzchum.scim.wms.core.api.enums.MaterialLabelPrintTypeEnum;
import com.hzchum.scim.wms.core.api.enums.MeasureTypeEnum;
import com.hzchum.scim.wms.core.api.enums.OutboundStatusEnum;
import com.hzchum.scim.wms.core.api.enums.ReceiptTypeEnum;
import com.hzchum.scim.wms.core.api.enums.RejectEnum;
import com.hzchum.scim.wms.core.api.enums.RejectFreightTypeEnum;
import com.hzchum.scim.wms.core.api.enums.UnitEnum;
import com.hzchum.scim.wms.core.api.enums.UnitsPrecisionEnum;
import com.hzchum.scim.wms.core.api.enums.WeightedPriceEnum;
import com.hzchum.scim.wms.core.api.enums.WeightedPriceTypeEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.BasicConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Classification;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Measure;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Unit;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Warehouse;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WeightedExecutionPriceConf;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WeightedPriceConf;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WmsMaterialCodeConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Workshop;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.Statistics;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsEndPeriod;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsInbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.WmsClosingTime;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Inbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialFreeze;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialFreezeRecord;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialUnfreeze;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MonthWeightedAveragePrice;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Print;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.PrintDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Reject;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.RejectDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Supplement;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WholeWeightedAveragePrice;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsAdjustDetail;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndSNDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.MeteAndQuantity;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.SubjectMeasureDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.InboundDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialInventoryDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialUnfreezeDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.QuantityMeteDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.RejectDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.RejectDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.RejectInboundDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryRejectDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryRejectInboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.RejectDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.RejectDetailDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.BasicConfigService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.ClassificationService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.MeasureService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WarningService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WorkshopService;
import com.hzchum.scim.wms.core.api.service.wmsReport.WmsClosingTimeService;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialFreezeService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialInventoryService;
import com.hzchum.scim.wms.core.api.service.wmsUse.RejectService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsAdjustDetailService;
import com.hzchum.scim.wms.core.api.utils.WmsUtil;
import com.hzchum.scim.wms.core.mapper.wmsConfig.ClassificationMapper;
import com.hzchum.scim.wms.core.mapper.wmsConfig.MeasureMapper;
import com.hzchum.scim.wms.core.mapper.wmsConfig.UnitMapper;
import com.hzchum.scim.wms.core.mapper.wmsConfig.WarehouseMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsEndPeriodMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsInboundMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MaterialFreezeRecordMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MaterialInventoryMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MaterialUnfreezeMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MonthWeightedAveragePriceMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.PrintDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.PrintMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.RejectDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.RejectMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.SupplementMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.WholeWeightedAveragePriceMapper;
import com.hzchum.scim.wms.core.utils.QueryUtilImpl;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RejectServiceImpl extends ServiceImpl<RejectMapper, Reject> implements RejectService {
   @Resource
   InboundService inboundService;
   @Resource
   InboundDetailService inboundDetailService;
   @Resource
   ContractProjectService contractProjectService;
   @Resource
   MaterialInventoryService materialInventoryService;
   @Resource
   WorkshopService workshopService;
   @Resource
   SupplierService supplierService;
   @Resource
   RejectMapper rejectMapper;
   @Resource
   RejectDetailMapper rejectDetailMapper;
   @Resource
   PurchaseOrderService purchaseOrderService;
   @Resource
   PurchaseOrderDetailService poDetailService;
   @Resource
   WarehouseMapper warehouseMapper;
   @Resource
   MaterialInventoryMapper materialInventoryMapper;
   @Resource
   MaterialFreezeService materialFreezeService;
   @Resource
   MaterialFreezeRecordMapper materialFreezeRecordMapper;
   @Resource
   NumberConfigService numberConfigService;
   @Resource
   MonthWeightedAveragePriceMapper wapMapper;
   @Resource
   MeasureMapper measureMapper;
   @Resource
   MeasureService measureService;
   @Resource
   MaterialUnfreezeMapper materialUnfreezeMapper;
   @Resource
   BasicConfigService basicConfigService;
   @Resource
   StatisticsInboundMapper statisticsInboundMapper;
   @Resource
   StatisticsMapper statisticsMapper;
   @Resource
   StatisticsEndPeriodMapper statisticsEndPeriodMapper;
   @Resource
   PrintMapper printMapper;
   @Resource
   PrintDetailMapper printDetailMapper;
   @Resource
   WarningService warningService;
   @Resource
   SupplementMapper supplementMapper;
   @Resource
   PlanMonomerService planMonomerService;
   @Resource
   PlanAreaService planAreaService;
   @Resource
   UnitMapper unitMapper;
   @Resource
   ClassificationMapper classificationMapper;
   @Resource
   ClassificationService classificationService;
   @Resource
   WholeWeightedAveragePriceMapper wholeWAPMapper;
   @Resource
   LogisticsOrderService logisticsOrderService;
   @Resource
   LogisticsOrderChangeRecordService logisticsOrderChangeRecordService;
   @Resource
   WmsAdjustDetailService wmsAdjustDetailService;
   @Resource
   WmsClosingTimeService wmsClosingTimeService;
   @Value("${wms.amount-accuracy}")
   private Integer amountAccuracy;
   @Resource
   WmsUtil wmsUtil;
   @Resource
   QueryUtilImpl queryUtil;
   @Resource
   WmsApproveRecordService wmsApproveRecordService;
   RoundingMode ROUNDING = RoundingMode.HALF_UP;

   @Override
   public PageVO<RejectInboundDTO> getInbound(QueryRejectInboundDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort) {
      String s = StringUtils.analyzeSortConditions(sort);
      Page<Inbound> page = PageHelper.startPage(pageNumber, pageSize, s);
      LambdaQueryWrapper<Inbound> wrapper = (LambdaQueryWrapper<Inbound>)(((((Wrappers.<Inbound>lambdaQuery()
                        .like(param.getPurchaseSN() != null, Inbound::getPurchaseSn, param.getPurchaseSN()))
                     .like(param.getSerialNumber() != null, Inbound::getSerialNumber, param.getSerialNumber()))
                  .eq(Inbound::getBoolPartyA, false))
               .eq(Inbound::getReviewStatus, ReviewStatusEnum.REVIEWED.getType()))
            .ne(Inbound::getRejectStatus, RejectEnum.All_REJECT.getType()))
         .eq(param.getSupplierId() != null, Inbound::getSupplierId, param.getSupplierId());
      if (CollectionUtils.isNotEmpty(param.getCreateTime())) {
         wrapper.ge(Inbound::getReviewTime, param.getCreateTime().get(0)).le(Inbound::getReviewTime, param.getCreateTime().get(1));
      }

      if (param.getProjectWarehouseType() != null) {
         if (param.getProjectWarehouseType() == 1) {
            wrapper.isNull(Inbound::getProjectIds);
         } else {
            wrapper.isNotNull(Inbound::getProjectIds);
         }
      }

      if (param.getProjectId() != null) {
         wrapper.apply(" find_in_set(" + param.getProjectId() + " ,project_ids)");
      }

      if (param.getBasicClass() != null) {
         wrapper.apply(" basic_class & " + param.getBasicClass() + " > 0");
      }

      if (StrUtil.isNotBlank(param.getOperatorName())) {
         wrapper.apply(
            " (editor_name like '%"
               + param.getOperatorName()
               + "%' or applicant_name like '%"
               + param.getOperatorName()
               + "%' or reviewer_name like '%"
               + param.getOperatorName()
               + "%')"
         );
      }

      return new PageVO<>(
         page,
         this.inboundService
            .list(wrapper)
            .stream()
            .map(
               inbound -> {
                  RejectInboundDTO dto = BeanUtil.copy(inbound, RejectInboundDTO.class);
                  dto.setPurchaseOrder(BriefIdAndSNDTO.builder().id(inbound.getPurchaseId()).serialNumber(inbound.getPurchaseSn()).build());
                  if (StrUtil.isNotBlank(inbound.getProjectIds())) {
                     dto.setProjects(
                        this.contractProjectService
                           .listByIds(inbound.getProjectIds())
                           .stream()
                           .map(po -> BeanUtil.copy(po, ProjectInfoDTO.class))
                           .collect(Collectors.toList())
                     );
                  }

                  if (inbound.getSupplierId() != null) {
                     Supplier supplier = this.supplierService.getById(inbound.getSupplierId());
                     dto.setSupplier(BriefIdAndNameDTO.builder().id(supplier.getId()).name(supplier.getName()).build());
                  }

                  return dto;
               }
            )
            .collect(Collectors.toList())
      );
   }

   @Override
   public InboundDTO getInboundDetailList(Long id) {
      InboundDTO inboundDTO = this.inboundService.getList(id, true, true);
      if (ObjectUtil.isNotEmpty(inboundDTO.getLogisticsOrder()) && ObjectUtil.isNotEmpty(inboundDTO.getLogisticsOrder().getFreight())) {
         List<Reject> rejects = this.rejectMapper
            .selectList(
               (Wrapper<Reject>)((new LambdaQueryWrapper<Reject>().eq(Reject::getInboundId, inboundDTO.getId()))
                     .eq(Reject::getRejectFreightType, RejectFreightTypeEnum.REJECT_FREIGHT.getType()))
                  .and(
                     r -> {
                        LambdaQueryWrapper var10000 = ((((r.eq(
                                       Reject::getReviewStatus, ReviewStatusEnum.REVIEWED.getType()
                                    ))
                                    .or())
                                 .eq(Reject::getReviewStatus, ReviewStatusEnum.UN_REVIEWED.getType()))
                              .or())
                           .eq(Reject::getReviewStatus, ReviewStatusEnum.AUDITING.getType());
                     }
                  )
            );
         BigDecimal freightInitial = inboundDTO.getLogistics().getFreightInitial();
         BigDecimal surplusFreight = freightInitial;
         if (ObjectUtil.isNotEmpty(rejects)) {
            BigDecimal reduce = rejects.stream().map(Reject::getFreight).filter(ObjectUtil::isNotEmpty).reduce(BigDecimal.ZERO, BigDecimal::add);
            surplusFreight = freightInitial.subtract(reduce);
         }

         inboundDTO.setSurplusFreight(surplusFreight);
      }

      return inboundDTO;
   }

   @Override
   public PageVO<RejectDTO> pageInfo(QueryRejectDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort) {
      String s = StringUtils.analyzeSortConditions(sort);
      Page<Reject> page = PageHelper.startPage(pageNumber, pageSize, s);
      LambdaQueryWrapper<Reject> wrapper = this.getRejectLambdaQueryWrapper(param);
      return new PageVO<>(
         page,
         this.rejectMapper
            .selectList(wrapper)
            .stream()
            .map(
               reject -> {
                  RejectDTO dto = BeanUtil.copy(reject, RejectDTO.class);
                  dto.setPurchaseOrder(BriefIdAndSNDTO.builder().id(reject.getPurchaseOrderId()).serialNumber(reject.getPurchaseSn()).build());
                  dto.setInboundReceipt(BriefIdAndSNDTO.builder().id(reject.getInboundId()).serialNumber(reject.getInboundSn()).build());
                  List<MaterialUnfreeze> materialUnfreezes = this.materialUnfreezeMapper
                     .selectList(
                        (Wrapper<MaterialUnfreeze>)(Wrappers.<MaterialUnfreeze>lambdaQuery()
                              .eq(MaterialUnfreeze::getFreezeType, MaterialFreezeTypeEnum.REJECTED.getType()))
                           .eq(MaterialUnfreeze::getSourceId, reject.getId())
                     );
                  dto.setBoolHasUnfreeze(CollectionUtil.isNotEmpty(materialUnfreezes));
                  if (reject.getSupplierId() != null) {
                     Supplier supplier = this.supplierService.getById(reject.getSupplierId());
                     dto.setSupplier(BriefIdAndNameDTO.builder().id(supplier.getId()).name(supplier.getName()).build());
                  }

                  if (reject.getProjectIds() != null) {
                     dto.setProjects(
                        this.contractProjectService
                           .listByIds(reject.getProjectIds())
                           .stream()
                           .map(po -> BeanUtil.copy(po, ProjectInfoDTO.class))
                           .collect(Collectors.toList())
                     );
                  }

                  return dto;
               }
            )
            .collect(Collectors.toList())
      );
   }

   private LambdaQueryWrapper<Reject> getRejectLambdaQueryWrapper(QueryRejectDTOParam param) {
      LambdaQueryWrapper<Reject> wrapper = (LambdaQueryWrapper<Reject>)(((Wrappers.<Reject>lambdaQuery()
                  .like(param.getInboundSN() != null, Reject::getInboundSn, param.getInboundSN()))
               .like(param.getPurchaseSN() != null, Reject::getPurchaseSn, param.getPurchaseSN()))
            .eq(param.getReviewStatus() != null, Reject::getReviewStatus, param.getReviewStatus()))
         .eq(param.getSerialNumber() != null, Reject::getSerialNumber, param.getSerialNumber());
      if (CollectionUtils.isNotEmpty(param.getCreateTime())) {
         wrapper.ge(BaseEntity::getCreateTime, param.getCreateTime().get(0)).le(BaseEntity::getCreateTime, param.getCreateTime().get(1));
      }

      if (param.getBasicClass() != null) {
         wrapper.last("and basic_class & " + param.getBasicClass() + " > 0");
      }

      if (StrUtil.isNotBlank(param.getOperatorName())) {
         wrapper.last("and (applicant_name like '%" + param.getOperatorName() + "%' or reviewer_name like '%" + param.getOperatorName() + "%')");
      }

      if (param.getProjectWarehouseType() != null) {
         if (param.getProjectWarehouseType() == 1) {
            wrapper.isNull(Reject::getProjectIds);
         } else if (param.getProjectWarehouseType() == 2) {
            wrapper.isNotNull(Reject::getProjectIds);
         }
      }

      if (param.getProjectId() != null) {
         wrapper.last("and find_in_set(" + param.getProjectId() + ",project_ids)");
      }

      return wrapper;
   }

   @Override
   public RejectDetailDTO detailList(Long id) {
      Reject reject = this.rejectMapper.selectById(id);
      Preconditions.checkArgument(reject != null, "退货单不存在");
      RejectDetailDTO dto = BeanUtil.copy(reject, RejectDetailDTO.class);
      if (reject.getPurchaseOrderId() != null) {
         dto.setPurchaseOrder(this.purchaseOrderService.selectByIdPurchaseOrder(reject.getPurchaseOrderId()));
      }

      List<MaterialUnfreeze> materialUnfreezes = this.materialUnfreezeMapper
         .selectList(
            (Wrapper<MaterialUnfreeze>)(Wrappers.<MaterialUnfreeze>lambdaQuery()
                  .eq(MaterialUnfreeze::getFreezeType, MaterialFreezeTypeEnum.REJECTED.getType()))
               .eq(MaterialUnfreeze::getSourceId, reject.getId())
         );
      if (CollectionUtil.isNotEmpty(materialUnfreezes)) {
         List<MaterialUnfreezeDTO> unfreezeDTOS = this.materialFreezeService.getUnfreezeDTOS(materialUnfreezes);
         dto.setBoolHasUnfreeze(true);
         dto.setUnfreezeList(unfreezeDTOS);
      } else {
         dto.setBoolHasUnfreeze(false);
         dto.setUnfreezeList(new ArrayList<>());
      }

      Map<String, WmsMaterialCodeConfig> materialCodeConfigMaps = this.queryUtil.getMaterialCodeConfigMaps(null);
      List<MaterialInventoryDTO> collect = this.rejectDetailMapper
         .selectList((Wrapper<RejectDetail>)Wrappers.<RejectDetail>lambdaQuery().eq(RejectDetail::getRejectId, reject.getId()))
         .stream()
         .map(detail -> {
            MaterialInventoryDTO materialInventoryDTO = BeanUtil.copy(detail, MaterialInventoryDTO.class);
            materialInventoryDTO.setUnitPriceExcludingVAT(detail.getUnitPriceExcludingVat());
            materialInventoryDTO.setNationalStandard(detail.getStandardName());
            materialInventoryDTO.setAmountExcludingVAT(detail.getAmountExcludingVat());
            materialInventoryDTO.setInputVAT(detail.getInputVat());
            String s1 = this.queryUtil.buildCompositeKey(detail.getClassifyId(), detail.getSpecification(), detail.getThickness());
            WmsMaterialCodeConfig wmsMaterialCodeConfig = materialCodeConfigMaps.get(s1);
            materialInventoryDTO.setMaterialSnNew(ObjectUtil.isNotEmpty(wmsMaterialCodeConfig) ? wmsMaterialCodeConfig.getMaterialSnNew() : "");
            materialInventoryDTO.setUnitPriceExcludingVATNoFreight(detail.getUnitPriceExcludingVatNoFreight());
            materialInventoryDTO.setAmountExcludingVATNoFreight(detail.getAmountExcludingVatNoFreight());
            materialInventoryDTO.setInputVATNoFreight(detail.getInputVatNoFreight());
            materialInventoryDTO.setRealTime(detail.getRealTime());
            if (detail.getProjectId() != null) {
               materialInventoryDTO.setProject(this.contractProjectService.getSimpleById(detail.getProjectId()));
               if (detail.getMonomerId() != null) {
                  materialInventoryDTO.setMonomerName(this.planMonomerService.getById(detail.getMonomerId()).getName());
                  if (detail.getAreaId() != null) {
                     materialInventoryDTO.setAreaName(this.planAreaService.getById(detail.getAreaId()).getName());
                  }
               }
            }

            Workshop workshop = this.workshopService.getById(detail.getWorkshopId());
            if (workshop != null) {
               materialInventoryDTO.setWorkshop(BriefIdAndNameDTO.builder().id(workshop.getId()).name(workshop.getName()).build());
            }

            Warehouse warehouse = this.warehouseMapper.selectById(detail.getWarehouseId());
            materialInventoryDTO.setWarehouse(BriefIdAndNameDTO.builder().id(warehouse.getId()).name(warehouse.getName()).build());
            return materialInventoryDTO;
         })
         .collect(Collectors.toList());
      dto.setList(collect);
      if (reject.getApproveRecordId() != null) {
         WmsApproveRecordFlowDTO approveRecordFlowDTO = this.wmsApproveRecordService.getApproveRecordDTO(reject.getApproveRecordId());
         dto.setWmsApproveRecordFlowDTO(approveRecordFlowDTO);
      }

      return dto;
   }

   @Override
   public ListVO<MaterialInventoryDTO> getMatByDetailId(Long id) {
      InboundDetail inboundDetail = this.inboundDetailService.getById(id);
      List<MaterialInventoryDTO> dtoList = this.materialInventoryMapper
         .getRejectMat(inboundDetail)
         .stream()
         .map(
            mat -> {
               MaterialInventoryDTO dto = BeanUtil.copy(mat, MaterialInventoryDTO.class);
               dto.setNationalStandard(mat.getStandardName());
               if (mat.getProjectId() != null) {
                  dto.setProject(this.contractProjectService.getSimpleById(mat.getProjectId()));
                  if (mat.getMonomerId() != null) {
                     dto.setMonomerName(this.planMonomerService.getById(mat.getMonomerId()).getName());
                     if (mat.getAreaId() != null) {
                        dto.setAreaName(this.planAreaService.getById(mat.getAreaId()).getName());
                     }
                  }
               }

               Workshop workshop = this.workshopService.getById(mat.getWorkshopId());
               if (workshop != null) {
                  dto.setWorkshop(BriefIdAndNameDTO.builder().id(workshop.getId()).name(workshop.getName()).build());
               }

               Warehouse warehouse = this.warehouseMapper.selectById(mat.getWarehouseId());
               dto.setWarehouse(BriefIdAndNameDTO.builder().id(warehouse.getId()).name(warehouse.getName()).build());
               MaterialFreeze materialFreeze = this.materialFreezeService
                  .getOne((Wrapper<MaterialFreeze>)Wrappers.<MaterialFreeze>lambdaQuery().eq(MaterialFreeze::getMaterialInventoryId, mat.getId()));
               if (materialFreeze != null) {
                  dto.setBoolHasFrozen(true);
                  dto.setFrozenMete(materialFreeze.getTotalMete());
                  dto.setFrozenQuantity(materialFreeze.getTotalQuantity());
               }

               int sort = 0;
               if (inboundDetail.getProjectId() != null) {
                  if (mat.getProjectId() != null) {
                     if (mat.getProjectId().equals(inboundDetail.getProjectId())) {
                        sort += 32;
                     }
                  } else {
                     sort += 10;
                  }

                  if (inboundDetail.getWorkshopId().equals(mat.getWorkshopId())) {
                     sort += 16;
                  }

                  if (inboundDetail.getWarehouseId().equals(mat.getWarehouseId())) {
                     sort += 8;
                  }
               } else {
                  if (mat.getProjectId() == null) {
                     sort += 32;
                  }

                  if (inboundDetail.getWorkshopId().equals(mat.getWorkshopId())) {
                     sort += 16;
                  }

                  if (inboundDetail.getWarehouseId().equals(mat.getWarehouseId())) {
                     sort += 8;
                  }
               }

               dto.setSort(sort);
               return dto;
            }
         )
         .collect(Collectors.toList());
      List<MaterialInventoryDTO> list = dtoList.stream().sorted(Comparator.comparing(MaterialInventoryDTO::getSort)).collect(Collectors.toList());
      Collections.reverse(list);
      return new ListVO<>(list);
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean saveReject(RejectDTOParam dtoParam) {
      Reject reject = Reject.builder()
         .applicantId(UserUtil.getCurrentUserId())
         .editorId(UserUtil.getCurrentUserId())
         .applicantName(UserUtil.getCurrentName())
         .editorName(UserUtil.getCurrentName())
         .reviewStatus(ReviewStatusEnum.UN_REVIEWED.getType())
         .userUpdateTime(LocalDateTime.now())
         .remark(dtoParam.getRemark())
         .build();
      Integer count = this.rejectMapper.getMaxDayNumber(LocalDateTime.now());
      String serviceNumber = this.numberConfigService.getNumber(NumberTypeEnum.SALES_RETURN, count);
      reject.setSerialNumber(serviceNumber);
      this.rejectMapper.insert(reject);
      Inbound inbound = null;
      int basicClass = 0;
      List<Long> ids = new ArrayList<>();
      WmsClosingTime oneTime = this.wmsClosingTimeService
         .getOne((Wrapper<WmsClosingTime>)(new LambdaQueryWrapper<WmsClosingTime>().orderBy(true, false, WmsClosingTime::getId)).last("limit 1"));

      for (RejectDetailDTOParam param : dtoParam.getList()) {
         MaterialInventory materialInventory = this.materialInventoryMapper.selectById(param.getId());
         Preconditions.checkArgument(materialInventory != null, "当前物料不存在.");
         Measure measure = this.measureMapper
            .selectOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, materialInventory.getClassifyId()));
         MaterialFreeze materialFreeze = this.materialFreezeService
            .getOne((Wrapper<MaterialFreeze>)Wrappers.<MaterialFreeze>lambdaQuery().eq(MaterialFreeze::getMaterialInventoryId, materialInventory.getId()));
         BigDecimal freezeTotalMete;
         BigDecimal freezeTotalQuantity;
         if (materialFreeze != null) {
            freezeTotalMete = materialFreeze.getTotalMete();
            freezeTotalQuantity = materialFreeze.getTotalQuantity();
         } else {
            freezeTotalMete = BigDecimal.ZERO;
            freezeTotalQuantity = BigDecimal.ZERO;
         }

         InboundDetail inboundDetail = this.inboundDetailService.getById(param.getInboundMaterialId());
         Preconditions.checkArgument(inboundDetail != null, "入库物料ID错误");
         if (RejectEnum.All_REJECT.getType().equals(inboundDetail.getRejectStatus())) {
            Preconditions.checkArgument(true, "退货失败,入库单已全部退货.");
         }

         if (oneTime != null) {
            Preconditions.checkArgument(
               param.getRealTime().isAfter(oneTime.getEndTime()) && param.getRealTime().isBefore(LocalDateTime.now()), "实际时间不能在实际关账时间之前,请刷新页面重新办理"
            );
         }

         RejectDetail rejectDetail = RejectDetail.builder()
            .inboundDetailId(inboundDetail.getId())
            .materialInventoryId(materialInventory.getId())
            .classifyId(materialInventory.getClassifyId())
            .basicClass(materialInventory.getBasicClass())
            .specification(materialInventory.getSpecification())
            .materialIsWhole(materialInventory.getMaterialIsWhole())
            .warehouseType(materialInventory.getWarehouseType())
            .boolPartyA(materialInventory.getBoolPartyA())
            .projectId(materialInventory.getProjectId())
            .quantity(param.getQuantity())
            .length(materialInventory.getLength())
            .width(materialInventory.getWidth())
            .thickness(materialInventory.getThickness())
            .theoryThickness(materialInventory.getTheoryThickness())
            .color(materialInventory.getColor())
            .brand(materialInventory.getBrand())
            .heatNoAndBatchNo(materialInventory.getHeatNoAndBatchNo())
            .unitNet(materialInventory.getUnitNet())
            .workshopId(materialInventory.getWorkshopId())
            .warehouseId(materialInventory.getWarehouseId())
            .standardId(materialInventory.getStandardId())
            .standardName(materialInventory.getStandardName())
            .materialSn(materialInventory.getSerialNumber())
            .monomerId(materialInventory.getMonomerId())
            .areaId(materialInventory.getAreaId())
            .realTime(param.getRealTime())
            .build();
         rejectDetail.setRejectId(reject.getId());
         BigDecimal precision = UnitsPrecisionEnum.getByName(measure.getAccountingUnit());
         if (BasicClassEnum.STEEL_PLATE.getType().equals(materialInventory.getBasicClass())
            || BasicClassEnum.SECTION_STEEL.getType().equals(materialInventory.getBasicClass())) {
            Preconditions.checkArgument(param.getQuantity().add(freezeTotalQuantity).compareTo(materialInventory.getQuantity()) <= 0, "物料可操作量不足,请核对后");
            Preconditions.checkArgument(
               param.getQuantity().add(inboundDetail.getRejectQuantity()).compareTo(inboundDetail.getQuantity()) <= 0, "物料退货数量超出入库数量请核对后操作"
            );
            rejectDetail.setQuantity(param.getQuantity());
            if (param.getQuantity().compareTo(inboundDetail.getQuantity()) == 0) {
               rejectDetail.setMete(inboundDetail.getMete().min(materialInventory.getMete()));
            } else {
               BigDecimal b = param.getQuantity().divide(inboundDetail.getQuantity(), 20, this.ROUNDING);
               rejectDetail.setMete(b.multiply(inboundDetail.getMete()).divide(precision, 0, this.ROUNDING).multiply(precision));
            }
         } else if (BasicClassEnum.COLOR_ROLL.getType().equals(materialInventory.getBasicClass())) {
            Preconditions.checkArgument(param.getMete().add(freezeTotalMete).compareTo(materialInventory.getMete()) <= 0, "物料可操作量不足,请核对后");
            rejectDetail.setMete(param.getMete());
            rejectDetail.setQuantity(
               param.getMete()
                  .divide(materialInventory.getMete().subtract(freezeTotalMete), 20, this.ROUNDING)
                  .multiply(materialInventory.getQuantity().subtract(freezeTotalQuantity))
                  .setScale(0, 4)
            );
         } else if (BasicClassEnum.checkNotSteel(materialInventory.getBasicClass())) {
            if (MeasureTypeEnum.MEASURE.getType().equals(measure.getOutboundUnitType())) {
               Preconditions.checkArgument(param.getQuantity().add(freezeTotalQuantity).compareTo(materialInventory.getQuantity()) <= 0, "物料可操作量不足,请核对后");
               rejectDetail.setQuantity(param.getQuantity());
               if (param.getQuantity().compareTo(inboundDetail.getQuantity()) == 0) {
                  rejectDetail.setMete(inboundDetail.getMete().min(materialInventory.getMete()));
               } else {
                  BigDecimal b = param.getQuantity().divide(inboundDetail.getQuantity(), 20, this.ROUNDING);
                  BigDecimal mete = b.multiply(inboundDetail.getMete());
                  if (StrUtil.isBlank(measure.getAccountingUnit())) {
                     Classification classification = this.classificationMapper.selectById(materialInventory.getClassifyId());
                     Measure m1 = this.getMeasure(classification.getParentId());
                     measure.setAccountingUnit(m1.getAccountingUnit());
                     measure.setAccountingPrecision(m1.getAccountingPrecision());
                  }

                  Unit u = this.unitMapper.selectOne((Wrapper<Unit>)Wrappers.<Unit>lambdaQuery().eq(Unit::getName, measure.getAccountingUnit()));
                  new HashMap();
                  if (UnitEnum.DIGIT.getType().equals(u.getType())) {
                     rejectDetail.setMete(mete.setScale(0, RoundingMode.HALF_UP));
                  } else {
                     BigDecimal pr = UnitsPrecisionEnum.getByName(measure.getAccountingUnit());
                     rejectDetail.setMete(mete.divide(pr, measure.getAccountingPrecision(), RoundingMode.HALF_UP).multiply(pr));
                  }
               }
            } else {
               Preconditions.checkArgument(param.getMete().add(freezeTotalMete).compareTo(materialInventory.getMete()) <= 0, "物料可操作量不足,请核对后");
               rejectDetail.setMete(param.getMete());
            }
         }

         if (BasicClassEnum.checkIsSteel(inboundDetail.getBasicClass())) {
            BigDecimal rejectQuantity = inboundDetail.getRejectQuantity().add(param.getQuantity());
            Preconditions.checkArgument(rejectQuantity.compareTo(inboundDetail.getQuantity()) <= 0, "退货失败,退货量大于入库量");
         } else {
            BigDecimal rejectMete = inboundDetail.getRejectMete().add(param.getMete());
            Preconditions.checkArgument(rejectMete.compareTo(inboundDetail.getMete()) <= 0, "退货失败,退货量大于入库量");
         }

         if (BasicClassEnum.COLOR_ROLL.getType().equals(materialInventory.getBasicClass())) {
            BigDecimal steelCoilMinLength = this.basicConfigService.getSteelScrapDefinitionConf().getSteelCoilMinLength();
            if (param.getMete().compareTo(materialInventory.getMete()) < 0) {
               BigDecimal mete = materialInventory.getQuantity()
                  .subtract(materialFreeze != null ? materialFreeze.getTotalQuantity() : BigDecimal.ZERO)
                  .subtract(rejectDetail.getQuantity());
               Preconditions.checkArgument(mete.compareTo(steelCoilMinLength) > 0 || mete.compareTo(BigDecimal.ZERO) <= 0, "退货失败,退货后剩余量小于或等于废料定义.");
            }
         }

         rejectDetail.setUnitPriceExcludingVat(inboundDetail.getUnitPriceExcludingVat());
         rejectDetail.setUnitPrice(inboundDetail.getUnitPrice());
         BigDecimal b = rejectDetail.getMete().divide(inboundDetail.getMete(), 20, this.ROUNDING);
         rejectDetail.setAmount(b.multiply(inboundDetail.getAmount()).setScale(this.amountAccuracy, this.ROUNDING));
         rejectDetail.setAmountExcludingVat(b.multiply(inboundDetail.getAmountExcludingVat()).setScale(this.amountAccuracy, this.ROUNDING));
         if (InvoiceTypeEnum.SPECIAL.getType().equals(inboundDetail.getInvoiceType())) {
            rejectDetail.setInputVat(rejectDetail.getAmount().subtract(rejectDetail.getAmountExcludingVat()));
         }

         this.rejectDetailMapper.insert(rejectDetail);
         inboundDetail.setRejectStatus(RejectEnum.UN_REVIEWED.getType());
         this.inboundDetailService.updateById(inboundDetail);
         inbound = this.inboundService.getById(inboundDetail.getInboundId());
         basicClass |= materialInventory.getBasicClass();
         if (materialInventory.getProjectId() != null && !ids.contains(materialInventory.getProjectId())) {
            ids.add(materialInventory.getProjectId());
         }

         if (materialFreeze == null) {
            materialFreeze = BeanUtil.copy(materialInventory, MaterialFreeze.class, "createTime");
            materialFreeze.setMaterialInventoryId(materialInventory.getId());
            materialFreeze.setTotalQuantity(rejectDetail.getQuantity());
            materialFreeze.setTotalMete(rejectDetail.getMete());
            materialFreeze.setTotalFreezeTypes(MaterialFreezeTypeEnum.REJECTED.getType() + "");
            this.materialFreezeService.save(materialFreeze);
         } else {
            materialFreeze.setTotalQuantity(rejectDetail.getQuantity() != null ? materialFreeze.getTotalQuantity().add(rejectDetail.getQuantity()) : null);
            materialFreeze.setTotalMete(materialFreeze.getTotalMete().add(rejectDetail.getMete()));
            List<Integer> t = Arrays.stream(materialFreeze.getTotalFreezeTypes().split(",")).map(Integer::parseInt).collect(Collectors.toList());
            if (!t.contains(MaterialFreezeTypeEnum.REJECTED.getType())) {
               t.add(MaterialFreezeTypeEnum.REJECTED.getType());
               materialFreeze.setTotalFreezeTypes(StrUtil.join(",", t));
            }

            this.materialFreezeService.updateById(materialFreeze);
         }

         MaterialFreezeRecord materialFreezeRecord = MaterialFreezeRecord.builder()
            .materialFreezeId(materialFreeze.getId())
            .freezeType(MaterialFreezeTypeEnum.REJECTED.getType())
            .freezeDetailId(rejectDetail.getId())
            .freezeSourceId(reject.getId())
            .freezeSourceSn(reject.getSerialNumber())
            .operatorId(UserUtil.getCurrentUserId())
            .operatorName(UserUtil.getCurrentName())
            .mete(rejectDetail.getMete())
            .quantity(rejectDetail.getQuantity())
            .projectId(rejectDetail.getProjectId())
            .frozenTime(LocalDateTime.now())
            .outboundUnitType(measure.getOutboundUnitType())
            .build();
         this.materialFreezeRecordMapper.insert(materialFreezeRecord);
         this.materialInventoryService.updateBoolHasFrozen(materialInventory.getId(), true);
      }

      reject.setInboundId(inbound.getId());
      reject.setInboundSn(inbound.getSerialNumber());
      reject.setPurchaseOrderId(inbound.getPurchaseId());
      reject.setPurchaseSn(inbound.getPurchaseSn());
      reject.setBasicClass(basicClass);
      reject.setSupplierId(inbound.getSupplierId());
      if (CollectionUtil.isNotEmpty(ids)) {
         reject.setProjectIds(StrUtil.join(",", ids));
      }

      inbound.setRejectStatus(RejectEnum.UN_REVIEWED.getType());
      this.inboundService.updateById(inbound);
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService
         .createRecord(reject.getId(), reject.getSerialNumber(), ApproveProcessTypeEnumV2.REJECT.getType(), null, null, null, false, null, null, null);
      reject.setApproveRecordId(wmsApproveRecord.getId());
      this.rejectMapper.updateById(reject);
      if (wmsApproveRecord.getStatus().equals(ApproveRecordStatusEnum.END.getType())) {
         this.passedV2(reject.getId(), null);
      }

      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean saveRejectV2(RejectDTOParam dtoParam) {
      Reject reject = Reject.builder()
         .applicantId(UserUtil.getCurrentUserId())
         .editorId(UserUtil.getCurrentUserId())
         .applicantName(UserUtil.getCurrentName())
         .editorName(UserUtil.getCurrentName())
         .reviewStatus(ReviewStatusEnum.UN_REVIEWED.getType())
         .userUpdateTime(LocalDateTime.now())
         .remark(dtoParam.getRemark())
         .rejectFreightType(dtoParam.getRejectFreightType())
         .freight(dtoParam.getFreight())
         .build();
      Integer count = this.rejectMapper.getMaxDayNumber(LocalDateTime.now());
      String serviceNumber = this.numberConfigService.getNumber(NumberTypeEnum.SALES_RETURN, count);
      reject.setSerialNumber(serviceNumber);
      this.rejectMapper.insert(reject);
      InboundDetail byId = this.inboundDetailService.getById(dtoParam.getList().get(0).getInboundMaterialId());
      Inbound inbound = this.inboundService.getById(byId.getInboundId());
      if (RejectFreightTypeEnum.REJECT_FREIGHT.getType().equals(dtoParam.getRejectFreightType())) {
         Preconditions.checkArgument(ObjectUtil.isNotEmpty(inbound.getFreight()), "原入库单没有运费，不可选择退运费");
         Preconditions.checkArgument(dtoParam.getFreight() != null && dtoParam.getFreight().compareTo(BigDecimal.ZERO) >= 0, "退运费金额不能为空且不能小于零");
         LogisticsOrder logisticsOrder = this.logisticsOrderService
            .getOne(
               (Wrapper<LogisticsOrder>)(new LambdaQueryWrapper<LogisticsOrder>().eq(LogisticsOrder::getInboundId, inbound.getId()))
                  .eq(LogisticsOrder::getTableNameType, TableNameTypeEnum.WMS_INBOUND.getType())
            );
         Preconditions.checkArgument(ObjectUtil.isNotEmpty(logisticsOrder), "原入库单物流记录不存在，不可选择退运费");
         BigDecimal taxRate = new BigDecimal(1);
         if (ObjectUtil.isNotEmpty(logisticsOrder.getTaxRate())) {
            taxRate = BigDecimal.ONE.add(logisticsOrder.getTaxRate().divide(BigDecimal.valueOf(100L)));
         }

         reject.setFreightExcludingVat(dtoParam.getFreight().divide(taxRate, 2, RoundingMode.HALF_UP));
         List<Reject> rejects = this.rejectMapper
            .selectList(
               (Wrapper<Reject>)((new LambdaQueryWrapper<Reject>().eq(Reject::getInboundId, inbound.getId()))
                     .eq(Reject::getRejectFreightType, RejectFreightTypeEnum.REJECT_FREIGHT.getType()))
                  .and(
                     r -> {
                        LambdaQueryWrapper var10000 = ((((r.eq(
                                       Reject::getReviewStatus, ReviewStatusEnum.REVIEWED.getType()
                                    ))
                                    .or())
                                 .eq(Reject::getReviewStatus, ReviewStatusEnum.UN_REVIEWED.getType()))
                              .or())
                           .eq(Reject::getReviewStatus, ReviewStatusEnum.AUDITING.getType());
                     }
                  )
            );
         BigDecimal reduce = rejects.stream().map(Reject::getFreight).filter(ObjectUtil::isNotEmpty).reduce(BigDecimal.ZERO, BigDecimal::add);
         Preconditions.checkArgument(
            reduce.add(dtoParam.getFreight()).compareTo(logisticsOrder.getFreightInitial()) < 1,
            "所退运费之和已超出该入库单运费，现剩余可退运费：" + logisticsOrder.getFreightInitial().subtract(reduce)
         );
      }

      int basicClass = 0;
      List<Long> ids = new ArrayList<>();
      WmsClosingTime oneTime = this.wmsClosingTimeService
         .getOne((Wrapper<WmsClosingTime>)(new LambdaQueryWrapper<WmsClosingTime>().orderBy(true, false, WmsClosingTime::getId)).last("limit 1"));

      for (RejectDetailDTOParam param : dtoParam.getList()) {
         MaterialInventory materialInventory = this.materialInventoryMapper.selectById(param.getId());
         Preconditions.checkArgument(materialInventory != null, "当前物料不存在.");
         Measure measure = this.getMeasure(materialInventory.getClassifyId());
         SubjectMeasureDTO subjectMeasureDTO = this.measureService.measureListById(materialInventory.getClassifyId());
         Integer accountingPrecision = subjectMeasureDTO.getAccountingPrecision();
         MaterialFreeze materialFreeze = this.materialFreezeService
            .getOne((Wrapper<MaterialFreeze>)Wrappers.<MaterialFreeze>lambdaQuery().eq(MaterialFreeze::getMaterialInventoryId, materialInventory.getId()));
         BigDecimal freezeTotalMete;
         BigDecimal freezeTotalQuantity;
         if (materialFreeze != null) {
            freezeTotalMete = materialFreeze.getTotalMete();
            freezeTotalQuantity = materialFreeze.getTotalQuantity();
         } else {
            freezeTotalMete = BigDecimal.ZERO;
            freezeTotalQuantity = BigDecimal.ZERO;
         }

         InboundDetail inboundDetail = this.inboundDetailService.getById(param.getInboundMaterialId());
         Preconditions.checkArgument(inboundDetail != null, "入库物料ID错误");
         if (RejectEnum.All_REJECT.getType().equals(inboundDetail.getRejectStatus())) {
            Preconditions.checkArgument(true, "退货失败,入库单已全部退货.");
         }

         if (oneTime != null) {
            Preconditions.checkArgument(
               param.getRealTime().isAfter(oneTime.getEndTime()) && param.getRealTime().isBefore(LocalDateTime.now()), "实际时间不能在实际关账时间之前,请刷新页面重新办理"
            );
         }

         RejectDetail rejectDetail = RejectDetail.builder()
            .inboundDetailId(inboundDetail.getId())
            .materialInventoryId(materialInventory.getId())
            .classifyId(materialInventory.getClassifyId())
            .basicClass(materialInventory.getBasicClass())
            .specification(materialInventory.getSpecification())
            .materialIsWhole(materialInventory.getMaterialIsWhole())
            .warehouseType(materialInventory.getWarehouseType())
            .boolPartyA(materialInventory.getBoolPartyA())
            .projectId(materialInventory.getProjectId())
            .quantity(param.getQuantity())
            .length(materialInventory.getLength())
            .width(materialInventory.getWidth())
            .thickness(materialInventory.getThickness())
            .theoryThickness(materialInventory.getTheoryThickness())
            .color(materialInventory.getColor())
            .brand(materialInventory.getBrand())
            .heatNoAndBatchNo(materialInventory.getHeatNoAndBatchNo())
            .unitNet(materialInventory.getUnitNet())
            .workshopId(materialInventory.getWorkshopId())
            .warehouseId(materialInventory.getWarehouseId())
            .standardId(materialInventory.getStandardId())
            .standardName(materialInventory.getStandardName())
            .materialSn(materialInventory.getSerialNumber())
            .monomerId(materialInventory.getMonomerId())
            .areaId(materialInventory.getAreaId())
            .realTime(param.getRealTime())
            .build();
         rejectDetail.setRejectId(reject.getId());
         BigDecimal precision = UnitsPrecisionEnum.getByName(measure.getAccountingUnit());
         MeteAndQuantity meteAndQuantitySend = new MeteAndQuantity();
         meteAndQuantitySend.setSendQuantity(param.getQuantity());
         meteAndQuantitySend.setSendMete(param.getMete());
         MeteAndQuantity meteAndQuantity = this.checkInventory(
            materialInventory.getBasicClass(),
            materialInventory.getClassifyId(),
            meteAndQuantitySend,
            materialInventory.getQuantity(),
            materialInventory.getMete(),
            freezeTotalQuantity,
            freezeTotalMete,
            subjectMeasureDTO,
            measure
         );
         BigDecimal sendQuantity = meteAndQuantity.getSendQuantity();
         BigDecimal sendMete = meteAndQuantity.getSendMete();
         if (BasicClassEnum.STEEL_PLATE.getType().equals(materialInventory.getBasicClass())
            || BasicClassEnum.SECTION_STEEL.getType().equals(materialInventory.getBasicClass())) {
            Preconditions.checkArgument(sendQuantity.add(inboundDetail.getRejectQuantity()).compareTo(inboundDetail.getQuantity()) <= 0, "物料退货数量超出入库数量请核对后操作");
            rejectDetail.setQuantity(sendQuantity);
            if (sendQuantity.compareTo(inboundDetail.getQuantity()) == 0) {
               rejectDetail.setMete(inboundDetail.getMete().min(materialInventory.getMete()));
            } else {
               BigDecimal b = sendQuantity.divide(inboundDetail.getQuantity(), 20, this.ROUNDING);
               rejectDetail.setMete(b.multiply(inboundDetail.getMete()).divide(precision, accountingPrecision, this.ROUNDING).multiply(precision));
            }
         } else if (BasicClassEnum.COLOR_ROLL.getType().equals(materialInventory.getBasicClass())) {
            rejectDetail.setMete(sendMete);
            rejectDetail.setQuantity(
               sendMete.divide(materialInventory.getMete().subtract(freezeTotalMete), 20, this.ROUNDING)
                  .multiply(materialInventory.getQuantity().subtract(freezeTotalQuantity))
                  .setScale(0, 4)
            );
         } else if (BasicClassEnum.checkNotSteel(materialInventory.getBasicClass())) {
            if (MeasureTypeEnum.MEASURE.getType().equals(measure.getOutboundUnitType())) {
               rejectDetail.setQuantity(sendQuantity);
               if (sendQuantity.compareTo(inboundDetail.getQuantity()) == 0) {
                  rejectDetail.setMete(inboundDetail.getMete().min(materialInventory.getMete()));
               } else {
                  BigDecimal b = sendQuantity.divide(inboundDetail.getQuantity(), 20, this.ROUNDING);
                  BigDecimal mete = b.multiply(inboundDetail.getMete());
                  if (StrUtil.isBlank(measure.getAccountingUnit())) {
                     Classification classification = this.classificationMapper.selectById(materialInventory.getClassifyId());
                     Measure m1 = this.getMeasure(classification.getParentId());
                     measure.setAccountingUnit(m1.getAccountingUnit());
                     measure.setAccountingPrecision(m1.getAccountingPrecision());
                  }

                  rejectDetail.setMete(mete.divide(precision, measure.getAccountingPrecision(), 4).multiply(precision));
               }
            } else {
               Preconditions.checkArgument(sendMete.add(freezeTotalMete).compareTo(materialInventory.getMete()) <= 0, "物料可操作量不足,请核对后");
               rejectDetail.setMete(sendMete);
            }
         }

         if (BasicClassEnum.checkIsSteel(inboundDetail.getBasicClass())) {
            BigDecimal rejectQuantity = inboundDetail.getRejectQuantity().add(sendQuantity);
            Map<Integer, BigDecimal> unitConversion = this.unitConversion(
               BigDecimal.ZERO, subjectMeasureDTO.getMeasureUnit(), subjectMeasureDTO.getMeasurePrecision()
            );
            BigDecimal halfUpQuantity = inboundDetail.getQuantity()
               .divide(unitConversion.get(2), subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP)
               .setScale(subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP);
            BigDecimal halfUpRejectQuantity = rejectQuantity.divide(unitConversion.get(2), subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP)
               .setScale(subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP);
            Preconditions.checkArgument(halfUpRejectQuantity.compareTo(halfUpQuantity) <= 0, "退货失败,退货量大于入库量");
         } else if (MeasureTypeEnum.MEASURE.getType().equals(measure.getOutboundUnitType())) {
            BigDecimal rejectQuantity = inboundDetail.getRejectQuantity().add(sendQuantity);
            Map<Integer, BigDecimal> unitConversion = this.unitConversion(
               BigDecimal.ZERO, subjectMeasureDTO.getMeasureUnit(), subjectMeasureDTO.getMeasurePrecision()
            );
            BigDecimal halfUpQuantity = inboundDetail.getQuantity()
               .divide(unitConversion.get(2), subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP)
               .setScale(subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP);
            BigDecimal halfUpRejectQuantity = rejectQuantity.divide(unitConversion.get(2), subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP)
               .setScale(subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP);
            Preconditions.checkArgument(halfUpRejectQuantity.compareTo(halfUpQuantity) <= 0, "退货失败,退货量大于入库量");
         } else {
            BigDecimal rejectMete = inboundDetail.getRejectMete().add(sendMete);
            Map<Integer, BigDecimal> unitConversion = this.unitConversion(
               BigDecimal.ZERO, subjectMeasureDTO.getAccountingUnit(), subjectMeasureDTO.getAccountingPrecision()
            );
            BigDecimal halfUpMete = inboundDetail.getMete()
               .divide(unitConversion.get(2), subjectMeasureDTO.getAccountingPrecision(), RoundingMode.HALF_UP)
               .setScale(subjectMeasureDTO.getAccountingPrecision(), RoundingMode.HALF_UP);
            BigDecimal halfUpRejectMete = rejectMete.divide(unitConversion.get(2), subjectMeasureDTO.getAccountingPrecision(), RoundingMode.HALF_UP)
               .setScale(subjectMeasureDTO.getAccountingPrecision(), RoundingMode.HALF_UP);
            Preconditions.checkArgument(halfUpRejectMete.compareTo(halfUpMete) <= 0, "退货失败,退货量大于入库量");
         }

         if (BasicClassEnum.COLOR_ROLL.getType().equals(materialInventory.getBasicClass())) {
            BigDecimal steelCoilMinLength = this.basicConfigService.getSteelScrapDefinitionConf().getSteelCoilMinLength();
            if (sendMete.compareTo(materialInventory.getMete()) < 0) {
               BigDecimal mete = materialInventory.getQuantity()
                  .subtract(materialFreeze != null ? materialFreeze.getTotalQuantity() : BigDecimal.ZERO)
                  .subtract(rejectDetail.getQuantity());
               Preconditions.checkArgument(mete.compareTo(steelCoilMinLength) > 0 || mete.compareTo(BigDecimal.ZERO) <= 0, "退货失败,退货后剩余量小于或等于废料定义.");
            }
         }

         WmsAdjustDetail one = this.wmsAdjustDetailService
            .getOne(
               (Wrapper<WmsAdjustDetail>)(((new LambdaQueryWrapper<WmsAdjustDetail>()
                           .eq(WmsAdjustDetail::getInboundDetailId, inboundDetail.getId()))
                        .eq(WmsAdjustDetail::getReviewStatus, OutboundStatusEnum.REVIEWED.getType()))
                     .orderByDesc(BaseEntity::getCreateTime))
                  .last("limit 1")
            );
         if (one == null) {
            rejectDetail.setUnitPriceExcludingVat(inboundDetail.getUnitPriceExcludingVatNoFreight());
            rejectDetail.setUnitPrice(inboundDetail.getUnitPriceNoFreight());
            BigDecimal b = rejectDetail.getMete().divide(inboundDetail.getMete(), 20, this.ROUNDING);
            rejectDetail.setAmount(b.multiply(inboundDetail.getAmountNoFreight()).setScale(this.amountAccuracy, this.ROUNDING));
            rejectDetail.setAmountExcludingVat(b.multiply(inboundDetail.getAmountExcludingVatNoFreight()).setScale(this.amountAccuracy, this.ROUNDING));
            rejectDetail.setUnitPriceExcludingVatNoFreight(inboundDetail.getUnitPriceExcludingVatNoFreight());
            rejectDetail.setUnitPriceNoFreight(inboundDetail.getUnitPriceNoFreight());
            rejectDetail.setAmountNoFreight(b.multiply(inboundDetail.getAmountNoFreight()).setScale(this.amountAccuracy, this.ROUNDING));
            rejectDetail.setAmountExcludingVatNoFreight(b.multiply(inboundDetail.getAmountExcludingVatNoFreight()).setScale(this.amountAccuracy, this.ROUNDING));
         } else {
            BigDecimal unitPrice = one.getAmount().divide(inboundDetail.getMete(), 12, 4);
            BigDecimal unitPriceExcludingVat = one.getAmountExcludingVat().divide(inboundDetail.getMete(), 12, 4);
            rejectDetail.setUnitPriceExcludingVat(unitPriceExcludingVat);
            rejectDetail.setUnitPrice(unitPrice);
            BigDecimal b = rejectDetail.getMete().divide(inboundDetail.getMete(), 20, this.ROUNDING);
            rejectDetail.setAmount(b.multiply(one.getAmount()).setScale(this.amountAccuracy, this.ROUNDING));
            rejectDetail.setAmountExcludingVat(b.multiply(one.getAmountExcludingVat()).setScale(this.amountAccuracy, this.ROUNDING));
            rejectDetail.setUnitPriceExcludingVatNoFreight(unitPriceExcludingVat);
            rejectDetail.setUnitPriceNoFreight(unitPrice);
            rejectDetail.setAmountNoFreight(b.multiply(one.getAmount()).setScale(this.amountAccuracy, this.ROUNDING));
            rejectDetail.setAmountExcludingVatNoFreight(b.multiply(one.getAmountExcludingVat()).setScale(this.amountAccuracy, this.ROUNDING));
         }

         if (InvoiceTypeEnum.SPECIAL.getType().equals(inboundDetail.getInvoiceType())) {
            rejectDetail.setInputVat(rejectDetail.getAmount().subtract(rejectDetail.getAmountExcludingVatNoFreight()));
            rejectDetail.setInputVatNoFreight(rejectDetail.getAmountNoFreight().subtract(rejectDetail.getAmountExcludingVatNoFreight()));
         }

         this.rejectDetailMapper.insert(rejectDetail);
         inboundDetail.setRejectStatus(RejectEnum.UN_REVIEWED.getType());
         this.inboundDetailService.updateById(inboundDetail);
         basicClass |= materialInventory.getBasicClass();
         if (materialInventory.getProjectId() != null && !ids.contains(materialInventory.getProjectId())) {
            ids.add(materialInventory.getProjectId());
         }

         if (materialFreeze == null) {
            materialFreeze = BeanUtil.copy(materialInventory, MaterialFreeze.class, "createTime");
            materialFreeze.setMaterialInventoryId(materialInventory.getId());
            materialFreeze.setTotalQuantity(rejectDetail.getQuantity());
            materialFreeze.setTotalMete(rejectDetail.getMete());
            materialFreeze.setTotalFreezeTypes(MaterialFreezeTypeEnum.REJECTED.getType() + "");
            this.materialFreezeService.save(materialFreeze);
         } else {
            materialFreeze.setTotalQuantity(rejectDetail.getQuantity() != null ? materialFreeze.getTotalQuantity().add(rejectDetail.getQuantity()) : null);
            materialFreeze.setTotalMete(materialFreeze.getTotalMete().add(rejectDetail.getMete()));
            List<Integer> t = Arrays.stream(materialFreeze.getTotalFreezeTypes().split(",")).map(Integer::parseInt).collect(Collectors.toList());
            if (!t.contains(MaterialFreezeTypeEnum.REJECTED.getType())) {
               t.add(MaterialFreezeTypeEnum.REJECTED.getType());
               materialFreeze.setTotalFreezeTypes(StrUtil.join(",", t));
            }

            this.materialFreezeService.updateById(materialFreeze);
         }

         MaterialFreezeRecord materialFreezeRecord = MaterialFreezeRecord.builder()
            .materialFreezeId(materialFreeze.getId())
            .freezeType(MaterialFreezeTypeEnum.REJECTED.getType())
            .freezeDetailId(rejectDetail.getId())
            .freezeSourceId(reject.getId())
            .freezeSourceSn(reject.getSerialNumber())
            .operatorId(UserUtil.getCurrentUserId())
            .operatorName(UserUtil.getCurrentName())
            .mete(rejectDetail.getMete())
            .quantity(rejectDetail.getQuantity())
            .projectId(rejectDetail.getProjectId())
            .frozenTime(LocalDateTime.now())
            .outboundUnitType(measure.getOutboundUnitType())
            .build();
         this.materialFreezeRecordMapper.insert(materialFreezeRecord);
         this.materialInventoryService.updateBoolHasFrozen(materialInventory.getId(), true);
      }

      reject.setInboundId(inbound.getId());
      reject.setInboundSn(inbound.getSerialNumber());
      reject.setPurchaseOrderId(inbound.getPurchaseId());
      reject.setPurchaseSn(inbound.getPurchaseSn());
      reject.setBasicClass(basicClass);
      reject.setSupplierId(inbound.getSupplierId());
      if (CollectionUtil.isNotEmpty(ids)) {
         reject.setProjectIds(StrUtil.join(",", ids));
      }

      inbound.setRejectStatus(RejectEnum.UN_REVIEWED.getType());
      this.inboundService.updateById(inbound);
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService
         .createRecord(reject.getId(), reject.getSerialNumber(), ApproveProcessTypeEnumV2.REJECT.getType(), null, null, null, false, null, null, null);
      reject.setApproveRecordId(wmsApproveRecord.getId());
      this.rejectMapper.updateById(reject);
      if (wmsApproveRecord.getStatus().equals(ApproveRecordStatusEnum.END.getType())) {
         this.passedV2(reject.getId(), null);
      }

      return true;
   }

   @Override
   public List<Long> getIds(QueryRejectDTOParam param) {
      param.setReviewStatus(ReviewStatusEnum.UN_REVIEWED.getType());
      return this.rejectMapper
         .selectList(this.getRejectLambdaQueryWrapper(param))
         .stream()
         .map(Reject::getId)
         .sorted(Comparator.reverseOrder())
         .collect(Collectors.toList());
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean passed(Long id, String approvalComments) {
      Reject reject = this.rejectMapper.selectById(id);
      Preconditions.checkArgument(reject != null, "退货单不存在");
      Preconditions.checkArgument(ReviewStatusEnum.UN_REVIEWED.getType().equals(reject.getReviewStatus()), "退货单已审核,请刷新后重试.");
      reject.setReviewerId(UserUtil.getCurrentUserId());
      reject.setReviewerName(UserUtil.getCurrentName());
      reject.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
      reject.setUserUpdateTime(LocalDateTime.now());
      reject.setApprovalComments(approvalComments);
      reject.setReviewTime(LocalDateTime.now());
      BigDecimal amount = BigDecimal.ZERO;
      BigDecimal amountExcludingVAT = BigDecimal.ZERO;
      BigDecimal amountNoFreight = BigDecimal.ZERO;
      BigDecimal amountExcludingVATNoFreight = BigDecimal.ZERO;
      int reduceQuantity = 0;

      for (RejectDetail rejectDetail : this.rejectDetailMapper
         .selectList((Wrapper<RejectDetail>)Wrappers.<RejectDetail>lambdaQuery().eq(RejectDetail::getRejectId, reject.getId()))) {
         InboundDetail inboundDetail = this.inboundDetailService.getById(rejectDetail.getInboundDetailId());
         inboundDetail.setRejectMete(rejectDetail.getMete().add(inboundDetail.getRejectMete()));
         inboundDetail.setGasReturnStatus(true);
         MaterialInventory materialInventory = this.materialInventoryMapper.selectById(rejectDetail.getMaterialInventoryId());
         if (materialInventory.getQuantity() != null) {
            materialInventory.setQuantity(materialInventory.getQuantity().subtract(rejectDetail.getQuantity()));
            inboundDetail.setRejectQuantity(inboundDetail.getRejectQuantity().add(rejectDetail.getQuantity()));
         }

         materialInventory.setMete(materialInventory.getMete().subtract(rejectDetail.getMete()));
         inboundDetail.setRejectStatus(
            inboundDetail.getMete().compareTo(inboundDetail.getRejectMete()) == 0 ? RejectEnum.All_REJECT.getType() : RejectEnum.PART_REJECT.getType()
         );
         if (materialInventory.getMete().compareTo(BigDecimal.ZERO) == 0) {
            this.materialInventoryMapper.deleteById(materialInventory);
         } else {
            if (materialInventory.getQuantity() != null) {
               materialInventory.setUseStatus(materialInventory.getQuantity().compareTo(BigDecimal.ZERO) == 0);
            }

            this.materialInventoryMapper.updateById(materialInventory);
         }

         this.wmsUtil
            .setInventoryUse(
               materialInventory,
               rejectDetail.getQuantity(),
               rejectDetail.getMete(),
               ReceiptTypeEnum.REJECTED,
               reject.getId(),
               reject.getSerialNumber(),
               1,
               false
            );
         this.warningService.updateStatus(materialInventory, 2);
         MonthWeightedAveragePrice wap = this.wapMapper.getPrice(materialInventory);
         amount = amount.add(rejectDetail.getAmount());
         amountExcludingVAT = amountExcludingVAT.add(rejectDetail.getAmountExcludingVat());
         amountNoFreight = amountNoFreight.add(rejectDetail.getAmountNoFreight());
         amountExcludingVATNoFreight = amountExcludingVATNoFreight.add(rejectDetail.getAmountExcludingVatNoFreight());
         WeightedPriceConf weightedPriceConf = JSON.parseObject(
            this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置")).getValue(), WeightedPriceConf.class
         );
         wap.setMete(wap.getMete().subtract(rejectDetail.getMete()));
         if (wap.getQuantity() != null) {
            wap.setQuantity(wap.getQuantity().subtract(rejectDetail.getQuantity()));
         }

         boolean isDel = false;
         if (WeightedPriceEnum.WHOLE.getType().equals(weightedPriceConf.getWeightedType())) {
            WholeWeightedAveragePrice wholeWAP = this.wholeWAPMapper.selectById(wap.getWholeWapId());
            wholeWAP.setMete(wholeWAP.getMete().subtract(rejectDetail.getMete()));
            wholeWAP.setAmount(wholeWAP.getAmount().subtract(rejectDetail.getAmount()));
            wholeWAP.setAmountExcludingVat(wholeWAP.getAmountExcludingVat().subtract(rejectDetail.getAmountExcludingVat()));
            wholeWAP.setAmountNoFreight(wholeWAP.getAmountNoFreight().subtract(rejectDetail.getAmountNoFreight()));
            wholeWAP.setAmountExcludingVatNoFreight(wholeWAP.getAmountExcludingVatNoFreight().subtract(rejectDetail.getAmountExcludingVatNoFreight()));
            if (wholeWAP.getQuantity() != null) {
               wholeWAP.setQuantity(wholeWAP.getQuantity().subtract(rejectDetail.getQuantity()));
            }

            this.wholeWAPMapper.updateById(wholeWAP);
            isDel = wap.getMete().compareTo(BigDecimal.ZERO) == 0;
         } else if (WeightedPriceEnum.SINGLE.getType().equals(weightedPriceConf.getWeightedType())) {
            wap.setAmount(wap.getAmount().subtract(rejectDetail.getAmount()));
            wap.setAmountExcludingVat(wap.getAmountExcludingVat().subtract(rejectDetail.getAmountExcludingVat()));
            wap.setAmountNoFreight(wap.getAmountNoFreight().subtract(rejectDetail.getAmountNoFreight()));
            wap.setAmountExcludingVatNoFreight(wap.getAmountExcludingVatNoFreight().subtract(rejectDetail.getAmountExcludingVatNoFreight()));
            if (wap.getMete().compareTo(BigDecimal.ZERO) == 0 && wap.getAmount().compareTo(BigDecimal.ZERO) == 0) {
               boolean var25 = true;
            } else {
               boolean var10000 = false;
            }
         }

         this.wapMapper.updateById(wap);
         PurchaseOrderDetail orderDetail = this.poDetailService.getById(inboundDetail.getPurchaseOrderDetailId());
         if (orderDetail != null) {
            if (rejectDetail.getQuantity() != null) {
               orderDetail.setInboundQuantity(orderDetail.getInboundQuantity().subtract(rejectDetail.getQuantity()));
            }

            if (rejectDetail.getMete() != null) {
               orderDetail.setInboundMete(orderDetail.getInboundMete().subtract(rejectDetail.getMete()));
            }

            this.poDetailService.updateById(orderDetail);
         }

         this.inboundDetailService.updateById(inboundDetail);
         this.materialFreezeService.materialUnfreeze(reject.getId(), rejectDetail.getId(), MaterialFreezeTypeEnum.REJECTED.getType(), false);
         Statistics statistics = this.statisticsMapper.get(materialInventory);
         if (statistics != null) {
            statistics.setInboundMete(
               statistics.getInboundMete() != null
                  ? statistics.getInboundMete().subtract(rejectDetail.getMete())
                  : BigDecimal.ZERO.subtract(rejectDetail.getMete())
            );
            statistics.setEndMete(statistics.getEndMete().subtract(rejectDetail.getMete()));
            if (rejectDetail.getQuantity() != null) {
               statistics.setInboundQuantity(
                  statistics.getInboundQuantity() != null
                     ? statistics.getInboundQuantity().subtract(rejectDetail.getQuantity())
                     : BigDecimal.ZERO.subtract(rejectDetail.getQuantity())
               );
               statistics.setEndQuantity(statistics.getEndQuantity().subtract(rejectDetail.getQuantity()));
            }

            statistics.setInboundAmount(
               statistics.getInboundAmount() != null
                  ? statistics.getInboundAmount().subtract(rejectDetail.getAmount())
                  : BigDecimal.ZERO.subtract(rejectDetail.getAmount())
            );
            statistics.setInboundAmountExcludingVat(
               statistics.getInboundAmountExcludingVat() != null
                  ? statistics.getInboundAmountExcludingVat().subtract(rejectDetail.getAmountExcludingVat())
                  : BigDecimal.ZERO.subtract(rejectDetail.getAmountExcludingVat())
            );
            statistics.setInboundAmountNoFreight(
               statistics.getInboundAmountNoFreight() != null
                  ? statistics.getInboundAmountNoFreight().subtract(rejectDetail.getAmountNoFreight())
                  : BigDecimal.ZERO.subtract(rejectDetail.getAmountNoFreight())
            );
            statistics.setInboundAmountExcludingVatNoFreight(
               statistics.getInboundAmountExcludingVatNoFreight() != null
                  ? statistics.getInboundAmountExcludingVatNoFreight().subtract(rejectDetail.getAmountExcludingVatNoFreight())
                  : BigDecimal.ZERO.subtract(rejectDetail.getAmountExcludingVatNoFreight())
            );
            if (statistics.getEndAmount() != null) {
               statistics.setEndAmount(statistics.getEndAmount().subtract(rejectDetail.getAmount()));
               statistics.setEndAmountExcludingVat(statistics.getEndAmountExcludingVat().subtract(rejectDetail.getAmountExcludingVat()));
            }

            if (statistics.getEndAmountNoFreight() != null) {
               statistics.setEndAmountNoFreight(statistics.getEndAmountNoFreight().subtract(rejectDetail.getAmountNoFreight()));
               statistics.setEndAmountExcludingVatNoFreight(
                  statistics.getEndAmountExcludingVatNoFreight().subtract(rejectDetail.getAmountExcludingVatNoFreight())
               );
            }

            if (statistics.getInboundMete().compareTo(BigDecimal.ZERO) > 0 && statistics.getInboundAmount().compareTo(BigDecimal.ZERO) > 0) {
               statistics.setInboundUnitPrice(statistics.getInboundAmount().divide(statistics.getInboundMete(), 12, RoundingMode.HALF_UP));
               statistics.setInboundUnitPriceExcludingVat(
                  statistics.getInboundAmountExcludingVat().divide(statistics.getInboundMete(), 12, RoundingMode.HALF_UP)
               );
            } else {
               statistics.setInboundUnitPrice(BigDecimal.ZERO);
               statistics.setInboundUnitPriceExcludingVat(BigDecimal.ZERO);
            }

            if (statistics.getInboundMete().compareTo(BigDecimal.ZERO) > 0 && statistics.getInboundAmountNoFreight().compareTo(BigDecimal.ZERO) > 0) {
               statistics.setInboundUnitPriceNoFreight(statistics.getInboundAmountNoFreight().divide(statistics.getInboundMete(), 12, RoundingMode.HALF_UP));
               statistics.setInboundUnitPriceExcludingVatNoFreight(
                  statistics.getInboundAmountExcludingVatNoFreight().divide(statistics.getInboundMete(), 12, RoundingMode.HALF_UP)
               );
            } else {
               statistics.setInboundUnitPriceNoFreight(BigDecimal.ZERO);
               statistics.setInboundUnitPriceExcludingVatNoFreight(BigDecimal.ZERO);
            }

            if (statistics.getEndMete().compareTo(BigDecimal.ZERO) <= 0) {
               statistics.setEndUnitPrice(null);
               statistics.setEndUnitPriceExcludingVat(null);
               statistics.setEndAmount(null);
               statistics.setEndAmountExcludingVat(null);
               statistics.setEndUnitPriceNoFreight(null);
               statistics.setEndUnitPriceExcludingVatNoFreight(null);
               statistics.setEndAmountNoFreight(null);
               statistics.setEndAmountExcludingVatNoFreight(null);
            }

            this.statisticsMapper.updateById(statistics);
         }

         StatisticsEndPeriod statisticsEndPeriod = this.statisticsEndPeriodMapper
            .selectOne((Wrapper<StatisticsEndPeriod>)Wrappers.<StatisticsEndPeriod>lambdaQuery().eq(StatisticsEndPeriod::getMaterialInventoryId, materialInventory.getId()));
         statisticsEndPeriod.setMete(statisticsEndPeriod.getMete().subtract(rejectDetail.getMete()));
         if (statisticsEndPeriod.getQuantity() != null) {
            statisticsEndPeriod.setQuantity(statisticsEndPeriod.getQuantity().subtract(rejectDetail.getQuantity()));
         }

         this.statisticsEndPeriodMapper.updateById(statisticsEndPeriod);
         StatisticsInbound si = BeanUtil.copy(materialInventory, StatisticsInbound.class, "createTime");
         si.setMaterialInventoryId(materialInventory.getId());
         si.setReceiptType(ReceiptTypeEnum.REJECTED.getType());
         si.setReceiptId(reject.getId());
         si.setReceiptSerialNumber(reject.getSerialNumber());
         si.setStatisticsId(statistics.getId());
         si.setMete(BigDecimal.ZERO.subtract(rejectDetail.getMete()));
         if (materialInventory.getQuantity() != null) {
            si.setQuantity(BigDecimal.ZERO.subtract(rejectDetail.getQuantity()));
         }

         si.setUnitPrice(rejectDetail.getUnitPrice());
         si.setUnitPriceExcludingVat(rejectDetail.getUnitPriceExcludingVat());
         si.setAmount(BigDecimal.ZERO.subtract(rejectDetail.getAmount()));
         si.setAmountExcludingVat(BigDecimal.ZERO.subtract(rejectDetail.getAmountExcludingVat()));
         si.setUnitPriceNoFreight(rejectDetail.getUnitPriceNoFreight());
         si.setUnitPriceExcludingVatNoFreight(rejectDetail.getUnitPriceExcludingVatNoFreight());
         si.setAmountNoFreight(BigDecimal.ZERO.subtract(rejectDetail.getAmountNoFreight()));
         si.setAmountExcludingVatNoFreight(BigDecimal.ZERO.subtract(rejectDetail.getAmountExcludingVatNoFreight()));
         si.setRealTime(reject.getReviewTime());
         this.statisticsInboundMapper.insert(si);
         if (BasicClassEnum.checkIsSteel(materialInventory.getBasicClass())) {
            PrintDetail printDetail = this.printDetailMapper
               .selectOne(
                  (Wrapper<PrintDetail>)(Wrappers.<PrintDetail>lambdaQuery().eq(PrintDetail::getType, MaterialLabelPrintTypeEnum.INBOUND.getType()))
                     .eq(PrintDetail::getReceiptDetailId, inboundDetail.getId())
               );
            if (printDetail != null && printDetail.getNotPrintNumber() > 0) {
               if (BasicClassEnum.COLOR_ROLL.getType().equals(materialInventory.getBasicClass())) {
                  if (materialInventory.getQuantity().compareTo(BigDecimal.ZERO) <= 0) {
                     printDetail.setNotPrintNumber(0);
                     printDetail.setQuantity(BigDecimal.ZERO);
                     printDetail.setMete(BigDecimal.ZERO);
                     reduceQuantity++;
                  } else {
                     printDetail.setQuantity(printDetail.getQuantity().subtract(rejectDetail.getQuantity()));
                     printDetail.setMete(printDetail.getMete().subtract(rejectDetail.getMete()));
                  }
               } else {
                  printDetail.setNotPrintNumber(Math.max(materialInventory.getQuantity().intValue() - printDetail.getPrintNumber(), 0));
                  printDetail.setQuantity(materialInventory.getQuantity());
                  printDetail.setMete(printDetail.getMete().subtract(rejectDetail.getMete()));
                  reduceQuantity += rejectDetail.getQuantity().intValue();
               }

               if (printDetail.getQuantity().compareTo(BigDecimal.ZERO) <= 0) {
                  this.printDetailMapper.deleteById(printDetail);
               } else {
                  if (printDetail.getNotPrintNumber() == 0) {
                     printDetail.setBoolPrinted(true);
                  }

                  this.printDetailMapper.updateById(printDetail);
               }
            }

            Print print = this.printMapper
               .selectOne(
                  (Wrapper<Print>)(Wrappers.<Print>lambdaQuery().eq(Print::getReceiptId, reject.getInboundId()))
                     .eq(Print::getReceiptType, ReceiptTypeEnum.INBOUND.getType())
               );
            if (print != null) {
               print.setTotalNotPrintNumber(Math.max(print.getTotalNotPrintNumber() - reduceQuantity, 0));
               if (print.getTotalPrintNumber() == 0 && print.getTotalNotPrintNumber() == 0) {
                  this.printMapper.deleteById(print);
               } else {
                  if (print.getTotalNotPrintNumber() == 0) {
                     print.setBoolPrinted(true);
                  }

                  this.printMapper.updateById(print);
               }
            }
         }
      }

      this.inboundService.updateRejectStatus(reject.getInboundId());
      reject.setAmount(amount);
      reject.setAmountExcludingVat(amountExcludingVAT);
      reject.setAmountNoFreight(amountNoFreight);
      reject.setAmountExcludingVatNoFreight(amountExcludingVATNoFreight);
      return this.rejectMapper.updateById(reject) == 1;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean passedV2(Long id, String approvalComments) {
      Reject reject = this.rejectMapper.selectById(id);
      Preconditions.checkArgument(reject != null, "退货单不存在");
      Preconditions.checkArgument(ReviewStatusEnum.UN_REVIEWED.getType().equals(reject.getReviewStatus()), "退货单已审核,请刷新后重试.");
      reject.setReviewerId(UserUtil.getCurrentUserId());
      reject.setReviewerName(UserUtil.getCurrentName());
      reject.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
      reject.setUserUpdateTime(LocalDateTime.now());
      reject.setApprovalComments(approvalComments);
      reject.setReviewTime(LocalDateTime.now());
      BigDecimal amount = BigDecimal.ZERO;
      BigDecimal amountExcludingVAT = BigDecimal.ZERO;
      BigDecimal amountNoFreight = BigDecimal.ZERO;
      BigDecimal amountExcludingVATNoFreight = BigDecimal.ZERO;
      int reduceQuantity = 0;
      List<RejectDetail> rejectDetails = this.rejectDetailMapper
         .selectList((Wrapper<RejectDetail>)Wrappers.<RejectDetail>lambdaQuery().eq(RejectDetail::getRejectId, reject.getId()));
      BigDecimal freight = new BigDecimal(0);
      BigDecimal freightExcludingVat = new BigDecimal(0);
      if (RejectFreightTypeEnum.REJECT_FREIGHT.getType().equals(reject.getRejectFreightType())) {
         freight = reject.getFreight();
         freightExcludingVat = reject.getFreightExcludingVat();
         LogisticsOrder one = this.logisticsOrderService
            .getOne(
               (Wrapper<LogisticsOrder>)(new LambdaQueryWrapper<LogisticsOrder>().eq(LogisticsOrder::getInboundId, reject.getInboundId()))
                  .eq(LogisticsOrder::getTableNameType, TableNameTypeEnum.WMS_INBOUND.getType())
            );
         Preconditions.checkArgument(ObjectUtil.isNotEmpty(one), "原入库单物流记录不存在，不可选择退运费");
         LogisticsOrderChangeRecord logisticsOrderChangeRecord = new LogisticsOrderChangeRecord();
         logisticsOrderChangeRecord.setLogisticsOrderId(one.getId());
         logisticsOrderChangeRecord.setFreightOld(one.getFreight());
         logisticsOrderChangeRecord.setFreightExcludingVatOld(one.getAmountExcludingVat());
         logisticsOrderChangeRecord.setReason("退运费");
         BigDecimal freightNew = one.getFreight().subtract(reject.getFreight());
         BigDecimal freightExcludingVatNew = one.getAmountExcludingVat().subtract(reject.getFreightExcludingVat());
         one.setFreight(freightNew);
         one.setAmountExcludingVat(freightExcludingVatNew);
         if (ObjectUtil.isNotEmpty(one.getInputVat())) {
            logisticsOrderChangeRecord.setInputVatOld(one.getInputVat());
            BigDecimal inputVatNew = freightNew.subtract(freightExcludingVatNew);
            one.setInputVat(inputVatNew);
            logisticsOrderChangeRecord.setInputVatOldNew(inputVatNew);
         }

         one.setChangeFreight(ChangeFreightEnum.FREIGHT_CHANGES.getType());
         logisticsOrderChangeRecord.setFreightNew(freightNew);
         logisticsOrderChangeRecord.setFreightExcludingVatNew(freightExcludingVatNew);
         this.logisticsOrderChangeRecordService.save(logisticsOrderChangeRecord);
         one.setUpdateTime(LocalDateTime.now());
         this.logisticsOrderService.updateById(one);
      }

      BigDecimal meteSum = rejectDetails.stream().map(RejectDetail::getMete).reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal amountSum = rejectDetails.stream().map(RejectDetail::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
      Integer num = 0;
      WeightedExecutionPriceConf weightedExecutionPriceConf = JSON.parseObject(
         this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权执行方式配置")).getValue(),
         WeightedExecutionPriceConf.class
      );
      WeightedPriceConf weightedPriceConf = JSON.parseObject(
         this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置")).getValue(), WeightedPriceConf.class
      );

      for (RejectDetail rejectDetail : rejectDetails) {
         if (RejectFreightTypeEnum.REJECT_FREIGHT.getType().equals(reject.getRejectFreightType())) {
            num = num + 1;
            if (BasicClassEnum.checkIsSteelAddOtherSteelMaterials(rejectDetail.getBasicClass())) {
               BigDecimal meteNow = rejectDetail.getMete();
               if (num == rejectDetails.size()) {
                  rejectDetail.setAmount(rejectDetail.getAmount().add(freight));
                  rejectDetail.setUnitPrice(rejectDetail.getAmount().divide(meteNow, 12, RoundingMode.HALF_UP));
                  rejectDetail.setAmountExcludingVat(rejectDetail.getAmountExcludingVat().add(freightExcludingVat));
                  rejectDetail.setUnitPriceExcludingVat(rejectDetail.getAmountExcludingVat().divide(meteNow, 12, RoundingMode.HALF_UP));
               } else {
                  BigDecimal ratio = rejectDetail.getMete().divide(meteSum, 12, RoundingMode.HALF_UP);
                  BigDecimal halveAllFreightTax = freight.multiply(ratio).setScale(2, 4);
                  rejectDetail.setAmount(rejectDetail.getAmount().add(halveAllFreightTax));
                  rejectDetail.setUnitPrice(rejectDetail.getAmount().divide(meteNow, 12, RoundingMode.HALF_UP));
                  freight = freight.subtract(halveAllFreightTax);
                  BigDecimal halveAllFreightNoTax = freightExcludingVat.multiply(ratio);
                  rejectDetail.setAmountExcludingVat(rejectDetail.getAmountExcludingVat().add(halveAllFreightNoTax));
                  rejectDetail.setUnitPriceExcludingVat(rejectDetail.getAmountExcludingVat().divide(meteNow, 12, RoundingMode.HALF_UP));
                  freightExcludingVat = freightExcludingVat.subtract(halveAllFreightNoTax);
                  meteSum = meteSum.subtract(rejectDetail.getMete());
               }
            } else {
               BigDecimal meteNow = rejectDetail.getMete();
               if (num == rejectDetails.size()) {
                  rejectDetail.setAmount(rejectDetail.getAmount().add(freight));
                  rejectDetail.setUnitPrice(rejectDetail.getAmount().divide(meteNow, 12, RoundingMode.HALF_UP));
                  rejectDetail.setAmountExcludingVat(rejectDetail.getAmountExcludingVat().add(freightExcludingVat));
                  rejectDetail.setUnitPriceExcludingVat(rejectDetail.getAmountExcludingVat().divide(meteNow, 12, RoundingMode.HALF_UP));
               } else {
                  BigDecimal ratio = rejectDetail.getAmount().divide(amountSum, 12, RoundingMode.HALF_UP);
                  BigDecimal halveAllFreightTax = freight.multiply(ratio).setScale(2, 4);
                  rejectDetail.setAmount(rejectDetail.getAmount().add(halveAllFreightTax));
                  rejectDetail.setUnitPrice(rejectDetail.getAmount().divide(meteNow, 12, RoundingMode.HALF_UP));
                  freight = freight.subtract(halveAllFreightTax);
                  BigDecimal halveAllFreightNoTax = freightExcludingVat.multiply(ratio);
                  rejectDetail.setAmountExcludingVat(rejectDetail.getAmountExcludingVat().add(halveAllFreightNoTax));
                  rejectDetail.setUnitPriceExcludingVat(rejectDetail.getAmountExcludingVat().divide(meteNow, 12, RoundingMode.HALF_UP));
                  freightExcludingVat = freightExcludingVat.subtract(halveAllFreightNoTax);
                  meteSum = meteSum.subtract(rejectDetail.getMete());
               }
            }

            if (ObjectUtil.isNotEmpty(rejectDetail.getInputVat())) {
               rejectDetail.setInputVat(rejectDetail.getAmount().subtract(rejectDetail.getAmountExcludingVat()));
               rejectDetail.setInputVatNoFreight(rejectDetail.getAmountNoFreight().subtract(rejectDetail.getAmountExcludingVatNoFreight()));
            }
         }

         amount = amount.add(rejectDetail.getAmount());
         amountNoFreight = amountNoFreight.add(rejectDetail.getAmountNoFreight());
         amountExcludingVAT = amountExcludingVAT.add(rejectDetail.getAmountExcludingVat());
         amountExcludingVATNoFreight = amountExcludingVATNoFreight.add(rejectDetail.getAmountExcludingVatNoFreight());
         if (weightedExecutionPriceConf.getWeightedExecutionType() == WeightedPriceTypeEnum.USER.getType()) {
            this.wmsClosingTimeService.checkInventoryMete(rejectDetail.getRealTime(), rejectDetail.getMaterialInventoryId(), rejectDetail.getMete());
         }

         this.rejectDetailMapper.updateById(rejectDetail);
         InboundDetail inboundDetail = this.inboundDetailService.getById(rejectDetail.getInboundDetailId());
         inboundDetail.setRejectMete(rejectDetail.getMete().add(inboundDetail.getRejectMete()));
         inboundDetail.setGasReturnStatus(true);
         MaterialInventory materialInventory = this.materialInventoryMapper.selectById(rejectDetail.getMaterialInventoryId());
         if (materialInventory.getQuantity() != null) {
            materialInventory.setQuantity(materialInventory.getQuantity().subtract(rejectDetail.getQuantity()));
            inboundDetail.setRejectQuantity(inboundDetail.getRejectQuantity().add(rejectDetail.getQuantity()));
         }

         materialInventory.setMete(materialInventory.getMete().subtract(rejectDetail.getMete()));
         inboundDetail.setRejectStatus(
            inboundDetail.getMete().compareTo(inboundDetail.getRejectMete()) == 0 ? RejectEnum.All_REJECT.getType() : RejectEnum.PART_REJECT.getType()
         );
         this.materialInventoryMapper.updateById(materialInventory);
         if (materialInventory.getMete().compareTo(BigDecimal.ZERO) == 0) {
            this.materialInventoryMapper.deleteById(materialInventory);
         } else {
            if (materialInventory.getQuantity() != null) {
               materialInventory.setUseStatus(materialInventory.getQuantity().compareTo(BigDecimal.ZERO) == 0);
            }

            this.materialInventoryMapper.updateById(materialInventory);
         }

         this.wmsUtil
            .setInventoryUse(
               materialInventory,
               rejectDetail.getQuantity(),
               rejectDetail.getMete(),
               ReceiptTypeEnum.REJECTED,
               reject.getId(),
               reject.getSerialNumber(),
               1,
               false
            );
         this.warningService.updateStatus(materialInventory, 2);
         MonthWeightedAveragePrice wap = this.wapMapper.getPrice(materialInventory);
         wap.setMete(wap.getMete().subtract(rejectDetail.getMete()));
         if (wap.getQuantity() != null) {
            wap.setQuantity(wap.getQuantity().subtract(rejectDetail.getQuantity()));
         }

         boolean isDel = false;
         if (WeightedPriceEnum.WHOLE.getType().equals(weightedPriceConf.getWeightedType())) {
            WholeWeightedAveragePrice wholeWAP = this.wholeWAPMapper.selectById(wap.getWholeWapId());
            wholeWAP.setMete(wholeWAP.getMete().subtract(rejectDetail.getMete()));
            wholeWAP.setAmount(wholeWAP.getAmount().subtract(rejectDetail.getAmount()));
            wholeWAP.setAmountExcludingVat(wholeWAP.getAmountExcludingVat().subtract(rejectDetail.getAmountExcludingVat()));
            wholeWAP.setAmountNoFreight(wholeWAP.getAmountNoFreight().subtract(rejectDetail.getAmountNoFreight()));
            wholeWAP.setAmountExcludingVatNoFreight(wholeWAP.getAmountExcludingVatNoFreight().subtract(rejectDetail.getAmountExcludingVatNoFreight()));
            if (wholeWAP.getQuantity() != null) {
               wholeWAP.setQuantity(wholeWAP.getQuantity().subtract(rejectDetail.getQuantity()));
            }

            this.wholeWAPMapper.updateById(wholeWAP);
            isDel = wap.getMete().compareTo(BigDecimal.ZERO) == 0;
         } else if (WeightedPriceEnum.SINGLE.getType().equals(weightedPriceConf.getWeightedType())) {
            wap.setAmount(wap.getAmount().subtract(rejectDetail.getAmount()));
            wap.setAmountExcludingVat(wap.getAmountExcludingVat().subtract(rejectDetail.getAmountExcludingVat()));
            wap.setAmountNoFreight(wap.getAmountNoFreight().subtract(rejectDetail.getAmountNoFreight()));
            wap.setAmountExcludingVatNoFreight(wap.getAmountExcludingVatNoFreight().subtract(rejectDetail.getAmountExcludingVatNoFreight()));
            if (wap.getMete().compareTo(BigDecimal.ZERO) == 0 && wap.getAmount().compareTo(BigDecimal.ZERO) == 0) {
               boolean var44 = true;
            } else {
               boolean var10000 = false;
            }
         }

         this.wapMapper.updateById(wap);
         PurchaseOrderDetail orderDetail = this.poDetailService.getById(inboundDetail.getPurchaseOrderDetailId());
         if (orderDetail != null) {
            if (rejectDetail.getQuantity() != null) {
               orderDetail.setInboundQuantity(orderDetail.getInboundQuantity().subtract(rejectDetail.getQuantity()));
            }

            if (rejectDetail.getMete() != null) {
               orderDetail.setInboundMete(orderDetail.getInboundMete().subtract(rejectDetail.getMete()));
            }

            this.poDetailService.updateById(orderDetail);
         }

         this.inboundDetailService.updateById(inboundDetail);
         this.materialFreezeService.materialUnfreeze(reject.getId(), rejectDetail.getId(), MaterialFreezeTypeEnum.REJECTED.getType(), false);
         Statistics statistics = this.statisticsMapper.get(materialInventory);
         if (statistics != null) {
            statistics.setInboundMete(
               statistics.getInboundMete() != null
                  ? statistics.getInboundMete().subtract(rejectDetail.getMete())
                  : BigDecimal.ZERO.subtract(rejectDetail.getMete())
            );
            statistics.setEndMete(statistics.getEndMete().subtract(rejectDetail.getMete()));
            if (rejectDetail.getQuantity() != null) {
               statistics.setInboundQuantity(
                  statistics.getInboundQuantity() != null
                     ? statistics.getInboundQuantity().subtract(rejectDetail.getQuantity())
                     : BigDecimal.ZERO.subtract(rejectDetail.getQuantity())
               );
               statistics.setEndQuantity(statistics.getEndQuantity().subtract(rejectDetail.getQuantity()));
            }

            statistics.setInboundAmount(
               statistics.getInboundAmount() != null
                  ? statistics.getInboundAmount().subtract(rejectDetail.getAmount())
                  : BigDecimal.ZERO.subtract(rejectDetail.getAmount())
            );
            statistics.setInboundAmountExcludingVat(
               statistics.getInboundAmountExcludingVat() != null
                  ? statistics.getInboundAmountExcludingVat().subtract(rejectDetail.getAmountExcludingVat())
                  : BigDecimal.ZERO.subtract(rejectDetail.getAmountExcludingVat())
            );
            statistics.setInboundAmountNoFreight(
               statistics.getInboundAmountNoFreight() != null
                  ? statistics.getInboundAmountNoFreight().subtract(rejectDetail.getAmountNoFreight())
                  : BigDecimal.ZERO.subtract(rejectDetail.getAmountNoFreight())
            );
            statistics.setInboundAmountExcludingVatNoFreight(
               statistics.getInboundAmountExcludingVatNoFreight() != null
                  ? statistics.getInboundAmountExcludingVatNoFreight().subtract(rejectDetail.getAmountExcludingVatNoFreight())
                  : BigDecimal.ZERO.subtract(rejectDetail.getAmountExcludingVatNoFreight())
            );
            if (statistics.getEndAmount() != null) {
               statistics.setEndAmount(statistics.getEndAmount().subtract(rejectDetail.getAmount()));
               statistics.setEndAmountExcludingVat(statistics.getEndAmountExcludingVat().subtract(rejectDetail.getAmountExcludingVat()));
            }

            if (statistics.getEndAmountNoFreight() != null) {
               statistics.setEndAmountNoFreight(statistics.getEndAmountNoFreight().subtract(rejectDetail.getAmountNoFreight()));
               statistics.setEndAmountExcludingVatNoFreight(
                  statistics.getEndAmountExcludingVatNoFreight().subtract(rejectDetail.getAmountExcludingVatNoFreight())
               );
            }

            if (statistics.getInboundMete().compareTo(BigDecimal.ZERO) > 0 && statistics.getInboundAmount().compareTo(BigDecimal.ZERO) > 0) {
               statistics.setInboundUnitPrice(statistics.getInboundAmount().divide(statistics.getInboundMete(), 12, RoundingMode.HALF_UP));
               statistics.setInboundUnitPriceExcludingVat(
                  statistics.getInboundAmountExcludingVat().divide(statistics.getInboundMete(), 12, RoundingMode.HALF_UP)
               );
            } else {
               statistics.setInboundUnitPrice(BigDecimal.ZERO);
               statistics.setInboundUnitPriceExcludingVat(BigDecimal.ZERO);
            }

            if (statistics.getInboundMete().compareTo(BigDecimal.ZERO) > 0 && statistics.getInboundAmountNoFreight().compareTo(BigDecimal.ZERO) > 0) {
               statistics.setInboundUnitPriceNoFreight(statistics.getInboundAmountNoFreight().divide(statistics.getInboundMete(), 12, RoundingMode.HALF_UP));
               statistics.setInboundUnitPriceExcludingVatNoFreight(
                  statistics.getInboundAmountExcludingVatNoFreight().divide(statistics.getInboundMete(), 12, RoundingMode.HALF_UP)
               );
            } else {
               statistics.setInboundUnitPriceNoFreight(BigDecimal.ZERO);
               statistics.setInboundUnitPriceExcludingVatNoFreight(BigDecimal.ZERO);
            }

            if (statistics.getEndMete().compareTo(BigDecimal.ZERO) <= 0) {
               statistics.setEndUnitPrice(null);
               statistics.setEndUnitPriceExcludingVat(null);
               statistics.setEndAmount(null);
               statistics.setEndAmountExcludingVat(null);
               statistics.setEndUnitPriceNoFreight(null);
               statistics.setEndUnitPriceExcludingVatNoFreight(null);
               statistics.setEndAmountNoFreight(null);
               statistics.setEndAmountExcludingVatNoFreight(null);
            }

            this.statisticsMapper.updateById(statistics);
         }

         StatisticsEndPeriod statisticsEndPeriod = this.statisticsEndPeriodMapper
            .selectOne((Wrapper<StatisticsEndPeriod>)Wrappers.<StatisticsEndPeriod>lambdaQuery().eq(StatisticsEndPeriod::getMaterialInventoryId, materialInventory.getId()));
         statisticsEndPeriod.setMete(statisticsEndPeriod.getMete().subtract(rejectDetail.getMete()));
         if (statisticsEndPeriod.getQuantity() != null) {
            statisticsEndPeriod.setQuantity(statisticsEndPeriod.getQuantity().subtract(rejectDetail.getQuantity()));
         }

         this.statisticsEndPeriodMapper.updateById(statisticsEndPeriod);
         StatisticsInbound si = BeanUtil.copy(materialInventory, StatisticsInbound.class, "createTime");
         si.setMaterialInventoryId(materialInventory.getId());
         si.setReceiptType(ReceiptTypeEnum.REJECTED.getType());
         si.setReceiptId(reject.getId());
         si.setReceiptSerialNumber(reject.getSerialNumber());
         si.setStatisticsId(statistics.getId());
         si.setMete(BigDecimal.ZERO.subtract(rejectDetail.getMete()));
         if (materialInventory.getQuantity() != null) {
            si.setQuantity(BigDecimal.ZERO.subtract(rejectDetail.getQuantity()));
         }

         si.setUnitPrice(rejectDetail.getUnitPrice());
         si.setUnitPriceExcludingVat(rejectDetail.getUnitPriceExcludingVat());
         si.setAmount(BigDecimal.ZERO.subtract(rejectDetail.getAmount()));
         si.setAmountExcludingVat(BigDecimal.ZERO.subtract(rejectDetail.getAmountExcludingVat()));
         si.setUnitPriceNoFreight(rejectDetail.getUnitPriceNoFreight());
         si.setUnitPriceExcludingVatNoFreight(rejectDetail.getUnitPriceExcludingVatNoFreight());
         si.setAmountNoFreight(BigDecimal.ZERO.subtract(rejectDetail.getAmountNoFreight()));
         si.setAmountExcludingVatNoFreight(BigDecimal.ZERO.subtract(rejectDetail.getAmountExcludingVatNoFreight()));
         si.setRealTime(rejectDetail.getRealTime());
         this.statisticsInboundMapper.insert(si);
         if (BasicClassEnum.checkIsSteel(materialInventory.getBasicClass())) {
            PrintDetail printDetail = this.printDetailMapper
               .selectOne(
                  (Wrapper<PrintDetail>)(Wrappers.<PrintDetail>lambdaQuery().eq(PrintDetail::getType, MaterialLabelPrintTypeEnum.INBOUND.getType()))
                     .eq(PrintDetail::getReceiptDetailId, inboundDetail.getId())
               );
            if (printDetail != null && printDetail.getNotPrintNumber() > 0) {
               if (BasicClassEnum.COLOR_ROLL.getType().equals(materialInventory.getBasicClass())) {
                  if (materialInventory.getQuantity().compareTo(BigDecimal.ZERO) <= 0) {
                     printDetail.setNotPrintNumber(0);
                     printDetail.setQuantity(BigDecimal.ZERO);
                     printDetail.setMete(BigDecimal.ZERO);
                     reduceQuantity++;
                  } else {
                     printDetail.setQuantity(printDetail.getQuantity().subtract(rejectDetail.getQuantity()));
                     printDetail.setMete(printDetail.getMete().subtract(rejectDetail.getMete()));
                  }
               } else {
                  printDetail.setNotPrintNumber(Math.max(materialInventory.getQuantity().intValue() - printDetail.getPrintNumber(), 0));
                  printDetail.setQuantity(materialInventory.getQuantity());
                  printDetail.setMete(printDetail.getMete().subtract(rejectDetail.getMete()));
                  reduceQuantity += rejectDetail.getQuantity().intValue();
               }

               if (printDetail.getQuantity().compareTo(BigDecimal.ZERO) <= 0) {
                  this.printDetailMapper.deleteById(printDetail);
               } else {
                  if (printDetail.getNotPrintNumber() == 0) {
                     printDetail.setBoolPrinted(true);
                  }

                  this.printDetailMapper.updateById(printDetail);
               }
            }

            Print print = this.printMapper
               .selectOne(
                  (Wrapper<Print>)(Wrappers.<Print>lambdaQuery().eq(Print::getReceiptId, reject.getInboundId()))
                     .eq(Print::getReceiptType, ReceiptTypeEnum.INBOUND.getType())
               );
            if (print != null) {
               print.setTotalNotPrintNumber(Math.max(print.getTotalNotPrintNumber() - reduceQuantity, 0));
               if (print.getTotalPrintNumber() == 0 && print.getTotalNotPrintNumber() == 0) {
                  this.printMapper.deleteById(print);
               } else {
                  if (print.getTotalNotPrintNumber() == 0) {
                     print.setBoolPrinted(true);
                  }

                  this.printMapper.updateById(print);
               }
            }
         }
      }

      this.inboundService.updateRejectStatus(reject.getInboundId());
      reject.setAmount(amount);
      reject.setAmountExcludingVat(amountExcludingVAT);
      reject.setAmountNoFreight(amountNoFreight);
      reject.setAmountExcludingVatNoFreight(amountExcludingVATNoFreight);
      return this.rejectMapper.updateById(reject) == 1;
   }

   @NotNull
   private Supplement getSupplement(Reject reject, MaterialInventory materialInventory) {
      Supplement supplement = Supplement.builder()
         .classifyId(materialInventory.getClassifyId())
         .basicClass(materialInventory.getBasicClass())
         .specification(materialInventory.getSpecification())
         .projectId(materialInventory.getProjectId())
         .length(materialInventory.getLength())
         .width(materialInventory.getWidth())
         .thickness(materialInventory.getThickness())
         .brand(materialInventory.getBrand())
         .color(materialInventory.getColor())
         .workshopId(materialInventory.getWorkshopId())
         .accountingUnit(materialInventory.getAccountingUnit())
         .receiptId(reject.getId())
         .receiptSn(reject.getSerialNumber())
         .build();
      Integer maxDayNumber = this.supplementMapper.getMaxDayNumber(LocalDateTime.now());
      supplement.setSerialNumber(this.numberConfigService.getNumber(NumberTypeEnum.SUPPLEMENT, maxDayNumber));
      return supplement;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean returned(Long id, String approvalComments) {
      Reject reject = this.rejectMapper.selectById(id);
      Preconditions.checkArgument(reject != null, "退货单不存在");
      Preconditions.checkArgument(ReviewStatusEnum.UN_REVIEWED.getType().equals(reject.getReviewStatus()), "退货单已审核");
      reject.setReviewerId(UserUtil.getCurrentUserId());
      reject.setReviewerName(UserUtil.getCurrentName());
      reject.setReviewStatus(ReviewStatusEnum.RETURNED.getType());
      reject.setUserUpdateTime(LocalDateTime.now());
      reject.setApprovalComments(approvalComments);
      reject.setReviewTime(LocalDateTime.now());

      for (RejectDetail rejectDetail : this.rejectDetailMapper
         .selectList((Wrapper<RejectDetail>)Wrappers.<RejectDetail>lambdaQuery().eq(RejectDetail::getRejectId, reject.getId()))) {
         InboundDetail inboundDetail = this.inboundDetailService.getById(rejectDetail.getInboundDetailId());
         inboundDetail.setRejectStatus(inboundDetail.getGasReturnStatus() ? RejectEnum.PART_REJECT.getType() : RejectEnum.NO_REJECT.getType());
         this.inboundDetailService.updateById(inboundDetail);
         this.materialFreezeService.materialUnfreeze(reject.getId(), rejectDetail.getId(), MaterialFreezeTypeEnum.REJECTED.getType(), false);
      }

      this.inboundService.updateRejectStatus(reject.getInboundId());
      return this.rejectMapper.updateById(reject) == 1;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean detailByIds(List<Long> ids) {
      for (Long id : ids) {
         Reject reject = this.rejectMapper.selectById(id);
         Preconditions.checkArgument(reject != null, "退货单不存在");

         for (RejectDetail rejectDetail : this.rejectDetailMapper
            .selectList((Wrapper<RejectDetail>)Wrappers.<RejectDetail>lambdaQuery().eq(RejectDetail::getRejectId, reject.getId()))) {
            InboundDetail inboundDetail = this.inboundDetailService.getById(rejectDetail.getInboundDetailId());
            inboundDetail.setRejectStatus(inboundDetail.getGasReturnStatus() ? RejectEnum.PART_REJECT.getType() : RejectEnum.NO_REJECT.getType());
            this.inboundDetailService.updateById(inboundDetail);
            this.materialFreezeService.materialUnfreeze(reject.getId(), rejectDetail.getId(), MaterialFreezeTypeEnum.REJECTED.getType(), false);
         }

         this.inboundService.updateRejectStatus(reject.getInboundId());
         this.rejectMapper.deleteById(reject);
      }

      return true;
   }

   @Override
   public BigDecimal getSumRejectAmount(Long purchaseId, Long supplierId, Long inboundId) {
      return this.baseMapper.selectSumRejectAmount(purchaseId, supplierId, inboundId);
   }

   @Override
   public BigDecimal getSumRejectAmountV2(Long purchaseId, Long supplierId, Long inboundId) {
      return this.baseMapper.selectSumRejectAmountV2(purchaseId, supplierId, inboundId);
   }

   @Override
   public BigDecimal getTotalAmount(List<Long> inboundIds) {
      return this.baseMapper.getTotalAmount(inboundIds);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean review(Long approveRecordId, Integer decision, String opinion) {
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService.getById(approveRecordId);
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(wmsApproveRecord), "审批日志不存在");
      Reject reject = this.baseMapper.selectById(wmsApproveRecord.getDataId());
      Boolean b = this.wmsApproveRecordService.commonApproveStep(reject.getId(), decision, opinion, wmsApproveRecord.getSerialNumber(), null);
      if (b) {
         if (decision.equals(CheckStatusEnum.PASS.getType())) {
            this.passedV2(reject.getId(), opinion);
         } else {
            this.returned(reject.getId(), opinion);
         }
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean revocation(Long id) {
      SecurityUser currentUser = UserUtil.getCurrentUser();
      Reject reject = this.baseMapper.selectById(id);
      Preconditions.checkArgument(currentUser.getId().equals(reject.getApplicantId()), "仅创建此退货单的人才可进行撤销操作");
      Preconditions.checkArgument(
         ReviewStatusEnum.AUDITING.getType().equals(reject.getReviewStatus()) || ReviewStatusEnum.UN_REVIEWED.getType().equals(reject.getReviewStatus()),
         "只可在创建中才可撤销申请，撤销失败"
      );
      if (ObjectUtil.isNotEmpty(reject.getApproveRecordId())) {
         this.wmsApproveRecordService.revocation(reject.getApproveRecordId());
      }

      for (RejectDetail rejectDetail : this.rejectDetailMapper
         .selectList((Wrapper<RejectDetail>)Wrappers.<RejectDetail>lambdaQuery().eq(RejectDetail::getRejectId, reject.getId()))) {
         InboundDetail inboundDetail = this.inboundDetailService.getById(rejectDetail.getInboundDetailId());
         inboundDetail.setRejectStatus(inboundDetail.getGasReturnStatus() ? RejectEnum.PART_REJECT.getType() : RejectEnum.NO_REJECT.getType());
         this.inboundDetailService.updateById(inboundDetail);
         this.materialFreezeService.materialUnfreeze(reject.getId(), rejectDetail.getId(), MaterialFreezeTypeEnum.REJECTED.getType(), false);
      }

      this.inboundService.updateRejectStatus(reject.getInboundId());
      reject.setReviewerId(UserUtil.getCurrentUserId());
      reject.setReviewerName(UserUtil.getCurrentName());
      reject.setReviewStatus(ReviewStatusEnum.CANCEL.getType());
      reject.setUserUpdateTime(LocalDateTime.now());
      reject.setApprovalComments(null);
      reject.setReviewTime(LocalDateTime.now());
      return this.rejectMapper.updateById(reject) == 1;
   }

   @Override
   public QuantityMeteDTO getCountMete(Long purchaseId, List<Integer> status) {
      return this.baseMapper.getCountMete(purchaseId, status);
   }

   private Measure getMeasure(Long pid) {
      Measure m = this.measureMapper.selectOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, pid));
      if (m.getAccountingUnit() != null) {
         return m;
      }

      Classification classification = this.classificationMapper.selectById(pid);
      return this.getMeasure(classification.getParentId());
   }

   private Measure getMeasured(Long id) {
      Classification classification = this.classificationService.getById(id);
      Measure m = this.measureService.getOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, id));
      return m.getOutboundUnitType() != null ? m : this.getMeasure(classification.getParentId());
   }

   private MeteAndQuantity checkInventory(
      Integer basicClass,
      Long classifyId,
      MeteAndQuantity meteAndQuantity,
      BigDecimal inventoryQuantity,
      BigDecimal inventoryMete,
      BigDecimal freezeTotalQuantity,
      BigDecimal freezeTotalMete,
      SubjectMeasureDTO subjectMeasureDTO,
      Measure measure
   ) {
      if (BasicClassEnum.checkNotSteel(basicClass)) {
         if (measure.getOutboundUnitType() == null) {
            measure = this.getMeasured(classifyId);
         }

         if (MeasureTypeEnum.MEASURE.getType().equals(measure.getOutboundUnitType())) {
            Map<Integer, BigDecimal> unitConversion = this.unitConversion(
               BigDecimal.ZERO, subjectMeasureDTO.getMeasureUnit(), subjectMeasureDTO.getMeasurePrecision()
            );
            inventoryQuantity = inventoryQuantity.subtract(freezeTotalQuantity);
            BigDecimal halfUpMete = inventoryQuantity.divide(unitConversion.get(2), subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP)
               .setScale(subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP);
            BigDecimal halfSendQuantity = meteAndQuantity.getSendQuantity()
               .divide(unitConversion.get(2), subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP)
               .setScale(subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP);
            Preconditions.checkArgument(halfSendQuantity.compareTo(halfUpMete) <= 0, "当前库存量不足,请重新操作");
            if (halfSendQuantity.compareTo(halfUpMete) > -1) {
               meteAndQuantity.setSendQuantity(inventoryQuantity);
            }
         } else {
            Map<Integer, BigDecimal> unitConversion = this.unitConversion(
               BigDecimal.ZERO, subjectMeasureDTO.getAccountingUnit(), subjectMeasureDTO.getAccountingPrecision()
            );
            inventoryMete = inventoryMete.subtract(freezeTotalMete);
            BigDecimal halfUpMete = inventoryMete.divide(unitConversion.get(2), subjectMeasureDTO.getAccountingPrecision(), RoundingMode.HALF_UP)
               .setScale(subjectMeasureDTO.getAccountingPrecision(), RoundingMode.HALF_UP);
            BigDecimal halfSendMete = meteAndQuantity.getSendMete()
               .divide(unitConversion.get(2), subjectMeasureDTO.getAccountingPrecision(), RoundingMode.HALF_UP)
               .setScale(subjectMeasureDTO.getAccountingPrecision(), RoundingMode.HALF_UP);
            Preconditions.checkArgument(halfSendMete.compareTo(halfUpMete) <= 0, "当前库存量不足,请重新操作");
            if (halfSendMete.compareTo(halfUpMete) > -1) {
               meteAndQuantity.setSendMete(inventoryMete);
            }
         }
      } else {
         Map<Integer, BigDecimal> unitConversion = this.unitConversion(
            BigDecimal.ZERO, subjectMeasureDTO.getMeasureUnit(), subjectMeasureDTO.getMeasurePrecision()
         );
         inventoryQuantity = inventoryQuantity.subtract(freezeTotalQuantity);
         BigDecimal halfUpMete = inventoryQuantity.divide(unitConversion.get(2), subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP)
            .setScale(subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP);
         BigDecimal halfSendQuantity = meteAndQuantity.getSendQuantity()
            .divide(unitConversion.get(2), subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP)
            .setScale(subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP);
         Preconditions.checkArgument(halfSendQuantity.compareTo(halfUpMete) <= 0, "当前库存量不足,请重新操作");
         if (halfSendQuantity.compareTo(halfUpMete) > -1) {
            meteAndQuantity.setSendQuantity(inventoryQuantity);
         }
      }

      return meteAndQuantity;
   }

   private Map<Integer, BigDecimal> unitConversion(BigDecimal value, String unit, Integer scale) {
      Unit u = this.unitMapper.selectOne((Wrapper<Unit>)Wrappers.<Unit>lambdaQuery().eq(Unit::getName, unit));
      Map<Integer, BigDecimal> map = new HashMap<>();
      if (UnitEnum.DIGIT.getType().equals(u.getType())) {
         map.put(2, BigDecimal.ONE);
         map.put(1, new BigDecimal(value.stripTrailingZeros().toPlainString()));
      } else {
         BigDecimal precision = UnitsPrecisionEnum.getByName(unit);
         if (value != null && precision.compareTo(BigDecimal.ZERO) != 0) {
            map.put(1, value.divide(precision, scale, 4));
            map.put(2, precision);
         } else {
            map.put(1, BigDecimal.ZERO);
            map.put(2, precision);
         }
      }

      return map;
   }
}
