package com.hzchum.scim.wms.core.service.impl.wmsUse;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.ApproveRecordStatusEnum;
import com.hzchum.scim.common.core.api.enums.CheckStatusEnum;
import com.hzchum.scim.common.core.api.enums.OutboundTypeEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.scm.core.api.pojo.dto.ProjectInfoDTO;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.enums.NumberTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.service.NumberConfigService;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.enums.MaterialFreezeTypeEnum;
import com.hzchum.scim.wms.core.api.enums.MeasureTypeEnum;
import com.hzchum.scim.wms.core.api.enums.OutboundStatusEnum;
import com.hzchum.scim.wms.core.api.enums.ReceiptTypeEnum;
import com.hzchum.scim.wms.core.api.enums.TransferTypeEnum;
import com.hzchum.scim.wms.core.api.enums.UnitsPrecisionEnum;
import com.hzchum.scim.wms.core.api.enums.WeightedPriceEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.BasicConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Classification;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Measure;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Warehouse;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WeightedPriceConf;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.Statistics;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsEndPeriod;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsInbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsOutbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialFreeze;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialFreezeRecord;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MonthWeightedAveragePrice;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Transfer;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.TransferDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WholeWeightedAveragePrice;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsDeficit;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsDeficitDetail;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.WmsDeficitDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.WmsDeficitDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryReportDeficitDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.DeficitDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.DeficitDTODetailParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.BasicConfigService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.ClassificationService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.MeasureService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialFreezeService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialInventoryService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WeightedAveragePriceService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsDeficitDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsDeficitService;
import com.hzchum.scim.wms.core.api.utils.CommonUtil;
import com.hzchum.scim.wms.core.api.utils.WmsUtil;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsEndPeriodMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsInboundMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsOutboundMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MaterialFreezeMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MaterialFreezeRecordMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MaterialInventoryMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MonthWeightedAveragePriceMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.TransferDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.TransferMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.WholeWeightedAveragePriceMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.WmsDeficitMapper;
import com.hzchum.scim.wms.core.utils.QueryUtilImpl;
import java.util.HashMap;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WmsDeficitServiceImpl extends ServiceImpl<WmsDeficitMapper, WmsDeficit> implements WmsDeficitService {
   @Resource
   MaterialInventoryService materialInventoryService;
   @Resource
   MaterialFreezeMapper materialFreezeMapper;
   @Resource
   ClassificationService classificationService;
   @Resource
   private MeasureService measureService;
   @Resource
   BasicConfigService basicConfigService;
   @Resource
   WeightedAveragePriceService weightedAveragePriceService;
   @Resource
   WholeWeightedAveragePriceMapper wholeWAPMapper;
   @Resource
   NumberConfigService numberConfigService;
   @Resource
   WmsDeficitDetailService wmsDeficitDetailService;
   @Resource
   StatisticsMapper statisticsMapper;
   @Resource
   MonthWeightedAveragePriceMapper monthWeightedAveragePriceMapper;
   @Resource
   TransferMapper transferMapper;
   @Resource
   TransferDetailMapper transferDetailMapper;
   @Resource
   StatisticsInboundMapper statisticsInboundMapper;
   @Resource
   StatisticsOutboundMapper statisticsOutboundMapper;
   RoundingMode ROUNDING = RoundingMode.HALF_UP;
   @Value("${wms.amount-accuracy}")
   private Integer amountAccuracy;
   @Resource
   MaterialFreezeService materialFreezeService;
   @Resource
   MaterialInventoryMapper materialInventoryMapper;
   @Resource
   MaterialFreezeRecordMapper materialFreezeRecordMapper;
   @Resource
   StatisticsEndPeriodMapper statisticsEndPeriodMapper;
   @Resource
   QueryUtilImpl queryUtil;
   @Resource
   ContractProjectService projectService;
   @Resource
   WmsApproveRecordService wmsApproveRecordService;
   @Resource
   WmsUtil wmsUtil;

   private void checkDeficitStoragePrecision(DeficitDTOParam params) {
      Map<Long, BigDecimal> pendingQuantities = new HashMap<>();
      Map<Long, BigDecimal> pendingMetes = new HashMap<>();
      for (DeficitDTODetailParam param : params.getList()) {
         MaterialInventory inventory = this.materialInventoryService.getById(param.getMaterialId());
         Preconditions.checkArgument(inventory != null, "当前物料不存在");
         boolean steel = BasicClassEnum.checkIsSteel(inventory.getBasicClass());
         boolean nonSteelMeasure = BasicClassEnum.checkNotSteel(inventory.getBasicClass())
            && MeasureTypeEnum.MEASURE.getType().equals(this.getMeasured(inventory.getClassifyId()).getOutboundUnitType());
         if (!steel && !nonSteelMeasure) {
            continue;
         }
         MaterialFreeze frozen = this.materialFreezeMapper.selectOne(
            Wrappers.<MaterialFreeze>lambdaQuery().eq(MaterialFreeze::getMaterialInventoryId, inventory.getId())
         );
         BigDecimal frozenMete = frozen == null ? BigDecimal.ZERO : this.materialFreezeMapper.getTotalMete(frozen.getId());
         BigDecimal frozenQuantity = frozen == null ? BigDecimal.ZERO : this.materialFreezeMapper.getTotalQuantity(frozen.getId());
         BigDecimal quantity = param.getQuantity();
         BigDecimal mete = steel ? CommonUtil.getOutboundMete1(
            BigDecimal.ONE, quantity, inventory,
            frozenMete.add(pendingMetes.getOrDefault(inventory.getId(), BigDecimal.ZERO)),
            frozenQuantity.add(pendingQuantities.getOrDefault(inventory.getId(), BigDecimal.ZERO)), 8
         ) : CommonUtil.getStockOutboundMete(
            quantity,
            inventory.getQuantity().subtract(frozenQuantity).subtract(pendingQuantities.getOrDefault(inventory.getId(), BigDecimal.ZERO)),
            inventory.getMete().subtract(frozenMete).subtract(pendingMetes.getOrDefault(inventory.getId(), BigDecimal.ZERO))
         );
         // This existing document stores both the source snapshot and movement at DECIMAL(19,2).
         for (BigDecimal value : Arrays.asList(inventory.getQuantity(), inventory.getMete(), quantity, mete)) {
            Preconditions.checkArgument(
               value != null && value.stripTrailingZeros().scale() <= 2 && value.setScale(2).precision() <= 19,
               "当前盘亏计量量或核算量超出可保存精度,请核对后操作"
            );
         }
         pendingQuantities.merge(inventory.getId(), quantity, BigDecimal::add);
         pendingMetes.merge(inventory.getId(), mete, BigDecimal::add);
      }
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean saveDeficit(DeficitDTOParam params) {
      for (DeficitDTODetailParam detail : params.getList()) {
         Preconditions.checkArgument(detail.getQuantity() != null && detail.getQuantity().signum() > 0, "盘亏数量必须大于0");
      }
      this.checkDeficitStoragePrecision(params);
      String serviceNumber = this.numberConfigService.getNumber(NumberTypeEnum.MANUFACTURES_DEFICIT, this.baseMapper.getCount(LocalDateTime.now()));
      WmsDeficit build = WmsDeficit.builder()
         .basicClass(params.getBasicClass())
         .deficitType(params.getDeficitType())
         .serialNumber(serviceNumber)
         .reviewStatus(OutboundStatusEnum.AUDITING.getType())
         .applicantId(UserUtil.getCurrentUserId())
         .applicantName(UserUtil.getCurrentName())
         .build();
      this.baseMapper.insert(build);
      params.getList()
         .forEach(
            param -> {
               MaterialInventory materialInventory = this.materialInventoryService.getById(param.getMaterialId());
               WmsDeficitDetail wmsDeficitDetail = BeanUtil.copy(materialInventory, WmsDeficitDetail.class);
               wmsDeficitDetail.setDeficitSerialNumber(build.getSerialNumber());
               wmsDeficitDetail.setApplicantName(UserUtil.getCurrentName());
               wmsDeficitDetail.setDeficitId(build.getId());
               wmsDeficitDetail.setReviewStatus(OutboundStatusEnum.UN_REVIEWED.getType());
               wmsDeficitDetail.setRemark(param.getRemark());
               wmsDeficitDetail.setDeficitType(params.getDeficitType());
               wmsDeficitDetail.setMaterialId(materialInventory.getId());
               wmsDeficitDetail.setDeficitType(build.getDeficitType());
               wmsDeficitDetail.setDeficitProjectId(param.getProjectId());
               wmsDeficitDetail.setRealTime(LocalDateTime.now());
               MaterialFreeze materialFreeze = this.materialFreezeMapper
                  .selectOne((Wrapper<MaterialFreeze>)Wrappers.<MaterialFreeze>lambdaQuery().eq(MaterialFreeze::getMaterialInventoryId, materialInventory.getId()));
               BigDecimal freezeTotalMete;
               BigDecimal freezeTotalQuantity;
               if (materialFreeze != null) {
                  freezeTotalMete = this.materialFreezeMapper.getTotalMete(materialFreeze.getId());
                  freezeTotalQuantity = this.materialFreezeMapper.getTotalQuantity(materialFreeze.getId());
               } else {
                  freezeTotalMete = BigDecimal.ZERO;
                  freezeTotalQuantity = BigDecimal.ZERO;
               }

               Measure measure = this.getMeasured(materialInventory.getClassifyId());
               Integer accountingPrecision = measure.getAccountingPrecision();
               BigDecimal precision = UnitsPrecisionEnum.getByName(measure.getAccountingUnit());
               if (BasicClassEnum.STEEL_PLATE.getType().equals(materialInventory.getBasicClass())
                  || BasicClassEnum.SECTION_STEEL.getType().equals(materialInventory.getBasicClass())) {
                  Preconditions.checkArgument(
                     materialInventory.getQuantity().subtract(freezeTotalQuantity).compareTo(param.getQuantity()) >= 0, "当前物料仓库中可操作量不足,请核对后操作"
                  );
                  wmsDeficitDetail.setDeficitQuantity(param.getQuantity());
                  wmsDeficitDetail.setDeficitMete(
                     CommonUtil.getOutboundMete1(
                        precision, param.getQuantity(), materialInventory, freezeTotalMete, freezeTotalQuantity, measure.getAccountingPrecision()
                     )
                  );
               } else if (BasicClassEnum.COLOR_ROLL.getType().equals(materialInventory.getBasicClass())) {
                  Preconditions.checkArgument(
                     materialInventory.getQuantity().subtract(freezeTotalQuantity).compareTo(param.getQuantity()) >= 0, "当前物料仓库中可操作量不足,请核对后操作"
                  );
                  wmsDeficitDetail.setDeficitQuantity(param.getQuantity());
                  wmsDeficitDetail.setDeficitMete(
                     CommonUtil.getOutboundMete1(
                        precision, param.getQuantity(), materialInventory, freezeTotalMete, freezeTotalQuantity, measure.getAccountingPrecision()
                     )
                  );
               } else if (BasicClassEnum.checkNotSteel(materialInventory.getBasicClass())) {
                  if (MeasureTypeEnum.MEASURE.getType().equals(measure.getOutboundUnitType())) {
                     Preconditions.checkArgument(
                        param.getQuantity().compareTo(materialInventory.getQuantity().subtract(freezeTotalQuantity)) <= 0, "当前库存量不足,请核对后操作"
                     );
                     wmsDeficitDetail.setDeficitMete(CommonUtil.getStockOutboundMete(
                        param.getQuantity(), materialInventory.getQuantity().subtract(freezeTotalQuantity), materialInventory.getMete().subtract(freezeTotalMete)
                     ));
                     wmsDeficitDetail.setDeficitQuantity(param.getQuantity());
                  } else {
                     Preconditions.checkArgument(param.getQuantity().compareTo(materialInventory.getMete().subtract(freezeTotalMete)) <= 0, "当前库存量不足,请核对后操作");
                     wmsDeficitDetail.setDeficitMete(param.getQuantity());
                     if (materialInventory.getQuantity() != null) {
                        wmsDeficitDetail.setDeficitQuantity(param.getQuantity().divide(materialInventory.getUnitNet(), 8, this.ROUNDING));
                     }
                  }
               }

               if (wmsDeficitDetail.getProjectId() != null) {
                  if (StrUtil.isNotBlank(build.getProjectIds())) {
                     List<Long> list = CommonUtil.spilt(build.getProjectIds(), ",");
                     if (!list.contains(wmsDeficitDetail.getProjectId())) {
                        build.setProjectIds(build.getProjectIds() + "," + wmsDeficitDetail.getProjectId());
                     }
                  } else {
                     build.setProjectIds(wmsDeficitDetail.getProjectId() + "");
                  }
               }

               this.wmsDeficitDetailService.save(wmsDeficitDetail);
               this.baseMapper.updateById(build);
               this.setMaterialFreeze(materialInventory, wmsDeficitDetail);
            }
         );
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService
         .createRecord(build.getId(), build.getSerialNumber(), ApproveProcessTypeEnumV2.CHECK_DEFICIT.getType(), null, null, null, false, null, null, null);
      WmsDeficit wmsDeficit = build.setApproveRecordId(wmsApproveRecord.getId());
      this.baseMapper.updateById(wmsDeficit);
      if (wmsApproveRecord.getStatus().equals(ApproveRecordStatusEnum.END.getType())) {
         this.passedDeficit(wmsDeficit.getId());
      }

      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean passedDeficit(Long id) {
      WmsDeficit wmsDeficit = this.baseMapper.selectById(id);
      Preconditions.checkArgument(
         OutboundStatusEnum.UN_REVIEWED.getType().equals(wmsDeficit.getReviewStatus())
            || OutboundStatusEnum.AUDITING.getType().equals(wmsDeficit.getReviewStatus()),
         "盘库单已审核,请核对后操作"
      );
      String currentName = UserUtil.getCurrentName();
      Long currentUserId = UserUtil.getCurrentUserId();
      wmsDeficit.setReviewStatus(OutboundStatusEnum.REVIEWED.getType());
      wmsDeficit.setReviewTime(LocalDateTime.now());
      wmsDeficit.setReviewerId(currentUserId);
      wmsDeficit.setReviewerName(currentName);
      this.baseMapper.updateById(wmsDeficit);
      List<WmsDeficitDetail> list = this.wmsDeficitDetailService
         .list((Wrapper<WmsDeficitDetail>)new LambdaQueryWrapper<WmsDeficitDetail>().eq(WmsDeficitDetail::getDeficitId, id));
      list.forEach(
         wmsDeficitDetail -> {
            this.materialUnfreeze(id, wmsDeficitDetail.getId(), MaterialFreezeTypeEnum.DEFICIT.getType());
            WeightedPriceConf weightedPriceConf = JSON.parseObject(
               this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置")).getValue(),
               WeightedPriceConf.class
            );
            MaterialInventory materialInventory = this.materialInventoryService.getById(wmsDeficitDetail.getMaterialId());
            MonthWeightedAveragePrice wap = this.weightedAveragePriceService.getPrice(materialInventory);
            Statistics statistics = this.statisticsMapper.get(materialInventory);
            BigDecimal amount;
            BigDecimal amountExcludingVat;
            BigDecimal amountNoFreight;
            BigDecimal amountExcludingVatNoFreight;
            if (WeightedPriceEnum.SINGLE.getType().equals(weightedPriceConf.getWeightedType())) {
               BigDecimal p = wmsDeficitDetail.getDeficitMete().divide(wap.getMete(), 20, this.ROUNDING);
               amount = wap.getAmount().multiply(p).setScale(this.amountAccuracy, this.ROUNDING);
               amountExcludingVat = wap.getAmountExcludingVat().multiply(p).setScale(this.amountAccuracy, this.ROUNDING);
               wmsDeficitDetail.setUnitPrice(wap.getAmount().divide(wap.getMete(), 12, this.ROUNDING));
               wmsDeficitDetail.setUnitPriceExcludingVat(wap.getAmountExcludingVat().divide(wap.getMete(), 12, this.ROUNDING));
               amountNoFreight = wap.getAmountNoFreight().multiply(p).setScale(this.amountAccuracy, this.ROUNDING);
               amountExcludingVatNoFreight = wap.getAmountExcludingVatNoFreight().multiply(p).setScale(this.amountAccuracy, this.ROUNDING);
               wmsDeficitDetail.setUnitPriceNoFreight(wap.getAmountNoFreight().divide(wap.getMete(), 12, this.ROUNDING));
               wmsDeficitDetail.setUnitPriceExcludingVatNoFreight(wap.getAmountExcludingVatNoFreight().divide(wap.getMete(), 12, this.ROUNDING));
            } else {
               WholeWeightedAveragePrice price = this.wholeWAPMapper.getPrice(materialInventory);
               BigDecimal p = wmsDeficitDetail.getDeficitMete().divide(price.getMete(), 20, this.ROUNDING);
               amount = price.getAmount().multiply(p).setScale(this.amountAccuracy, this.ROUNDING);
               amountExcludingVat = price.getAmountExcludingVat().multiply(p).setScale(this.amountAccuracy, this.ROUNDING);
               amountNoFreight = price.getAmountNoFreight().multiply(p).setScale(this.amountAccuracy, this.ROUNDING);
               amountExcludingVatNoFreight = price.getAmountExcludingVatNoFreight().multiply(p).setScale(this.amountAccuracy, this.ROUNDING);
               wmsDeficitDetail.setUnitPrice(price.getAmount().divide(price.getMete(), 12, this.ROUNDING));
               wmsDeficitDetail.setUnitPriceExcludingVat(price.getAmountExcludingVat().divide(price.getMete(), 12, this.ROUNDING));
               wmsDeficitDetail.setUnitPriceNoFreight(price.getAmountNoFreight().divide(price.getMete(), 12, this.ROUNDING));
               wmsDeficitDetail.setUnitPriceExcludingVatNoFreight(price.getAmountExcludingVatNoFreight().divide(price.getMete(), 12, this.ROUNDING));
            }

            wmsDeficitDetail.setAmount(amount);
            wmsDeficitDetail.setAmountExcludingVat(amountExcludingVat);
            wmsDeficitDetail.setInputVat(amount.subtract(amountExcludingVat));
            wmsDeficitDetail.setAmountNoFreight(amountNoFreight);
            wmsDeficitDetail.setAmountExcludingVatNoFreight(amountExcludingVatNoFreight);
            wmsDeficitDetail.setInputVatNoFreight(amountNoFreight.subtract(amountExcludingVatNoFreight));
            if (wmsDeficitDetail.getDeficitType() == 1) {
               this.weightedAveragePriceService
                  .createMonthWAP(
                     InboundDetail.builder()
                        .mete(wmsDeficitDetail.getDeficitMete().negate())
                        .quantity(wmsDeficitDetail.getDeficitQuantity() != null ? wmsDeficitDetail.getDeficitQuantity().negate() : null)
                        .projectId(materialInventory.getProjectId())
                        .accountingUnit(materialInventory.getAccountingUnit())
                        .unitPrice(wmsDeficitDetail.getUnitPrice())
                        .unitPriceExcludingVat(wmsDeficitDetail.getUnitPriceExcludingVat())
                        .amount(amount.negate())
                        .amountExcludingVat(amountExcludingVat.negate())
                        .amountNoFreight(amountNoFreight.negate())
                        .amountExcludingVatNoFreight(amountExcludingVatNoFreight.negate())
                        .unitPriceNoFreight(wmsDeficitDetail.getUnitPriceNoFreight())
                        .unitPriceExcludingVatNoFreight(wmsDeficitDetail.getUnitPriceExcludingVatNoFreight())
                        .invoiceType(materialInventory.getInvoiceType())
                        .realTime(wmsDeficitDetail.getRealTime())
                        .build(),
                     materialInventory,
                     wmsDeficit.getId(),
                     wmsDeficit.getSerialNumber(),
                     ReceiptTypeEnum.DEFICIT.getType()
                  );
            } else {
               if (WeightedPriceEnum.SINGLE.getType().equals(weightedPriceConf.getWeightedType())) {
                  if (wmsDeficitDetail.getDeficitQuantity() != null) {
                     wap.setQuantity(wap.getQuantity().subtract(wmsDeficitDetail.getDeficitQuantity()));
                  }

                  wap.setMete(wap.getMete().subtract(wmsDeficitDetail.getDeficitMete()));
                  wap.setAmount(wap.getAmount().subtract(amount));
                  wap.setAmountExcludingVat(wap.getAmountExcludingVat().subtract(amountExcludingVat));
                  wap.setAmountNoFreight(wap.getAmountNoFreight().subtract(amountNoFreight));
                  wap.setAmountExcludingVatNoFreight(wap.getAmountExcludingVatNoFreight().subtract(amountExcludingVatNoFreight));
                  this.monthWeightedAveragePriceMapper.updateById(wap);
               } else {
                  WholeWeightedAveragePrice price = this.wholeWAPMapper.getPrice(materialInventory);
                  price.setAmount(price.getAmount().subtract(amount));
                  price.setAmountExcludingVat(price.getAmountExcludingVat().subtract(amountExcludingVat));
                  price.setAmountNoFreight(price.getAmountNoFreight().subtract(amountNoFreight));
                  price.setAmountExcludingVatNoFreight(price.getAmountExcludingVatNoFreight().subtract(amountExcludingVatNoFreight));
                  price.setMete(price.getMete().subtract(wmsDeficitDetail.getDeficitMete()));
                  if (wmsDeficitDetail.getDeficitQuantity() != null) {
                     price.setQuantity(price.getQuantity().subtract(wmsDeficitDetail.getDeficitQuantity()));
                  }

                  this.wholeWAPMapper.updateById(price);
               }

               long outPId = wmsDeficitDetail.getDeficitProjectId() != null ? wmsDeficitDetail.getDeficitProjectId() : -1L;
               long sourcePId = materialInventory.getProjectId() != null ? materialInventory.getProjectId() : -1L;
               if (outPId == sourcePId) {
                  statistics.setOutboundMete(
                     statistics.getOutboundMete() != null
                        ? wmsDeficitDetail.getDeficitMete().add(statistics.getOutboundMete())
                        : wmsDeficitDetail.getDeficitMete()
                  );
                  statistics.setOutboundQuantity(
                     statistics.getOutboundQuantity() != null
                        ? wmsDeficitDetail.getDeficitQuantity().add(statistics.getOutboundQuantity())
                        : wmsDeficitDetail.getDeficitQuantity()
                  );
                  statistics.setOutboundAmount(statistics.getOutboundAmount() != null ? amount.add(statistics.getOutboundAmount()) : amount);
                  statistics.setOutboundAmountExcludingVat(
                     statistics.getOutboundAmountExcludingVat() != null
                        ? amountExcludingVat.add(statistics.getOutboundAmountExcludingVat())
                        : amountExcludingVat
                  );
                  statistics.setOutboundUnitPriceExcludingVat(wmsDeficitDetail.getUnitPriceExcludingVat());
                  statistics.setOutboundUnitPrice(wmsDeficitDetail.getUnitPrice());
                  statistics.setOutboundAmountNoFreight(
                     statistics.getOutboundAmountNoFreight() != null ? amountNoFreight.add(statistics.getOutboundAmountNoFreight()) : amountNoFreight
                  );
                  statistics.setOutboundAmountExcludingVatNoFreight(
                     statistics.getOutboundAmountExcludingVatNoFreight() != null
                        ? amountExcludingVatNoFreight.add(statistics.getOutboundAmountExcludingVatNoFreight())
                        : amountExcludingVatNoFreight
                  );
                  statistics.setOutboundUnitPriceExcludingVatNoFreight(wmsDeficitDetail.getUnitPriceExcludingVatNoFreight());
                  statistics.setOutboundUnitPriceNoFreight(wmsDeficitDetail.getUnitPriceNoFreight());
                  this.saveStatisticsOutbound(wmsDeficit, wmsDeficitDetail, materialInventory, statistics.getId());
               } else {
                  Transfer transfer = Transfer.builder()
                     .basicClass(materialInventory.getBasicClass())
                     .directionProjectId(wmsDeficitDetail.getDeficitProjectId())
                     .directionWorkshopId(wmsDeficitDetail.getWorkshopId())
                     .directionWarehouseId(wmsDeficitDetail.getWarehouseId())
                     .transferType(TransferTypeEnum.PROJECT_WARE.getType())
                     .reviewStatus(ReviewStatusEnum.REVIEWED.getType())
                     .applicantId(currentUserId)
                     .editorId(currentUserId)
                     .applicantName(currentName)
                     .editorName(currentName)
                     .reviewerName(currentName)
                     .reviewTime(LocalDateTime.now())
                     .reviewerId(currentUserId)
                     .userUpdateTime(LocalDateTime.now())
                     .transferCreateType(2)
                     .build();
                  Integer count = this.transferMapper.getMaxDayNumber(LocalDateTime.now());
                  String sn = this.numberConfigService.getNumber(NumberTypeEnum.TRANSFER, count);
                  transfer.setSerialNumber(sn);
                  this.transferMapper.insert(transfer);
                  TransferDetail transferDetail = TransferDetail.builder()
                     .boolPartyA(materialInventory.getBoolPartyA())
                     .transferId(transfer.getId())
                     .materialInventoryId(materialInventory.getId())
                     .specification(materialInventory.getSpecification())
                     .basicClass(materialInventory.getBasicClass())
                     .length(materialInventory.getLength())
                     .width(materialInventory.getWidth())
                     .thickness(materialInventory.getThickness())
                     .brand(materialInventory.getBrand())
                     .heatNoAndBatchNo(materialInventory.getHeatNoAndBatchNo())
                     .classifyId(materialInventory.getClassifyId())
                     .transferType(TransferTypeEnum.PROJECT_WARE.getType())
                     .sourceWorkshopId(materialInventory.getWorkshopId())
                     .sourceWarehouseId(materialInventory.getWarehouseId())
                     .sourceProjectId(materialInventory.getProjectId())
                     .sourceMonomerId(materialInventory.getMonomerId())
                     .sourceAreaId(materialInventory.getAreaId())
                     .mete(wmsDeficitDetail.getDeficitMete())
                     .quantity(wmsDeficitDetail.getDeficitQuantity())
                     .color(materialInventory.getColor())
                     .taxRate(materialInventory.getTaxRate())
                     .invoiceType(materialInventory.getInvoiceType())
                     .standardId(materialInventory.getStandardId())
                     .standardName(materialInventory.getStandardName())
                     .realTime(wmsDeficitDetail.getRealTime())
                     .build();
                  if (amount.compareTo(BigDecimal.ZERO) != 0) {
                     transferDetail.setUnitPrice(wmsDeficitDetail.getUnitPrice());
                     transferDetail.setUnitPriceExcludingVat(wmsDeficitDetail.getUnitPriceExcludingVat());
                  } else {
                     transferDetail.setUnitPrice(BigDecimal.ZERO);
                     transferDetail.setUnitPriceExcludingVat(BigDecimal.ZERO);
                  }

                  transferDetail.setAmount(amount);
                  transferDetail.setAmountExcludingVat(amountExcludingVat);
                  transferDetail.setInputVat(transferDetail.getAmount().subtract(transferDetail.getAmountExcludingVat()));
                  if (amountNoFreight.compareTo(BigDecimal.ZERO) != 0) {
                     transferDetail.setUnitPriceNoFreight(wmsDeficitDetail.getUnitPriceNoFreight());
                     transferDetail.setUnitPriceExcludingVatNoFreight(wmsDeficitDetail.getUnitPriceExcludingVatNoFreight());
                  } else {
                     transferDetail.setUnitPriceNoFreight(BigDecimal.ZERO);
                     transferDetail.setUnitPriceExcludingVatNoFreight(BigDecimal.ZERO);
                  }

                  transferDetail.setAmountNoFreight(amountNoFreight);
                  transferDetail.setAmountExcludingVatNoFreight(amountExcludingVatNoFreight);
                  transferDetail.setInputVatNoFreight(transferDetail.getAmountNoFreight().subtract(transferDetail.getAmountExcludingVatNoFreight()));
                  this.transferDetailMapper.insert(transferDetail);
                  statistics.setTransferMete(
                     statistics.getTransferMete() != null ? statistics.getTransferMete().subtract(transferDetail.getMete()) : transferDetail.getMete().negate()
                  );
                  if (transferDetail.getQuantity() != null) {
                     statistics.setTransferQuantity(
                        statistics.getTransferQuantity() != null
                           ? statistics.getTransferQuantity().subtract(transferDetail.getQuantity())
                           : transferDetail.getQuantity().negate()
                     );
                  }

                  statistics.setTransferUnitPrice(transferDetail.getUnitPrice());
                  statistics.setTransferUnitPriceExcludingVat(transferDetail.getUnitPriceExcludingVat());
                  statistics.setTransferAmount(statistics.getTransferAmount() != null ? statistics.getTransferAmount().subtract(amount) : amount.negate());
                  statistics.setTransferAmountExcludingVat(
                     statistics.getTransferAmountExcludingVat() != null
                        ? statistics.getTransferAmountExcludingVat().subtract(amountExcludingVat)
                        : amountExcludingVat.negate()
                  );
                  statistics.setTransferUnitPriceNoFreight(transferDetail.getUnitPriceNoFreight());
                  statistics.setTransferUnitPriceExcludingVatNoFreight(transferDetail.getUnitPriceExcludingVatNoFreight());
                  statistics.setTransferAmountNoFreight(
                     statistics.getTransferAmountNoFreight() != null
                        ? statistics.getTransferAmountNoFreight().subtract(amountNoFreight)
                        : amountNoFreight.negate()
                  );
                  statistics.setTransferAmountExcludingVatNoFreight(
                     statistics.getTransferAmountExcludingVatNoFreight() != null
                        ? statistics.getTransferAmountExcludingVatNoFreight().subtract(amountExcludingVatNoFreight)
                        : amountExcludingVatNoFreight.negate()
                  );
                  StatisticsInbound si = BeanUtil.copy(materialInventory, StatisticsInbound.class, "createTime");
                  si.setMaterialInventoryId(materialInventory.getId());
                  si.setReceiptType(ReceiptTypeEnum.TRANSFER.getType());
                  si.setReceiptId(transfer.getId());
                  si.setReceiptSerialNumber(transfer.getSerialNumber());
                  si.setStatisticsId(statistics.getId());
                  si.setMete(transferDetail.getMete().negate());
                  if (materialInventory.getQuantity() != null) {
                     si.setQuantity(transferDetail.getQuantity().negate());
                  }

                  si.setUnitPrice(transferDetail.getUnitPrice());
                  si.setUnitPriceExcludingVat(transferDetail.getUnitPriceExcludingVat());
                  si.setAmount(transferDetail.getAmount().negate());
                  si.setAmountExcludingVat(transferDetail.getAmountExcludingVat().negate());
                  si.setUnitPriceNoFreight(transferDetail.getUnitPriceNoFreight());
                  si.setUnitPriceExcludingVatNoFreight(transferDetail.getUnitPriceExcludingVatNoFreight());
                  si.setAmountNoFreight(transferDetail.getAmountNoFreight().negate());
                  si.setAmountExcludingVatNoFreight(transferDetail.getAmountExcludingVatNoFreight().negate());
                  si.setRealTime(wmsDeficitDetail.getRealTime());
                  this.statisticsInboundMapper.insert(si);
                  MaterialInventory inventory = BeanUtil.copy(materialInventory, MaterialInventory.class);
                  inventory.setId(-1L);
                  inventory.setProjectId(outPId);
                  inventory.setWarehouseType(outPId == -1L ? 1 : 2);
                  InboundDetail inboundDetail1 = InboundDetail.builder()
                     .basicClass(inventory.getBasicClass())
                     .classifyName(inventory.getClassifyName())
                     .classifyId(inventory.getClassifyId())
                     .accountingUnit(inventory.getAccountingUnit())
                     .length(inventory.getLength())
                     .width(inventory.getWidth())
                     .thickness(inventory.getThickness())
                     .brand(inventory.getBrand())
                     .heatNoAndBatchNo(inventory.getHeatNoAndBatchNo())
                     .specification(inventory.getSpecification())
                     .color(inventory.getColor())
                     .unitNet(inventory.getUnitNet())
                     .quantity(wmsDeficitDetail.getDeficitQuantity())
                     .mete(wmsDeficitDetail.getDeficitMete())
                     .workshopId(inventory.getWorkshopId())
                     .warehouseId(inventory.getWarehouseId())
                     .measureUnit(inventory.getMeasureUnit())
                     .taxRate(inventory.getTaxRate())
                     .invoiceType(inventory.getInvoiceType())
                     .standardName(inventory.getStandardName())
                     .standardId(inventory.getStandardId())
                     .oneTheoryWeight(inventory.getOneTheoryWeight())
                     .sectionSteelWeight(inventory.getSectionSteelWeight())
                     .boolPartyA(inventory.getBoolPartyA())
                     .amount(amount)
                     .amountExcludingVat(amountExcludingVat)
                     .unitPrice(transferDetail.getUnitPrice())
                     .unitPriceExcludingVat(transferDetail.getUnitPriceExcludingVat())
                     .amountNoFreight(amountNoFreight)
                     .amountExcludingVatNoFreight(amountExcludingVatNoFreight)
                     .unitPriceNoFreight(transferDetail.getUnitPriceNoFreight())
                     .unitPriceExcludingVatNoFreight(transferDetail.getUnitPriceExcludingVatNoFreight())
                     .realTime(wmsDeficitDetail.getRealTime())
                     .projectId(inventory.getProjectId())
                     .build();
                  Statistics targetStatistics = this.weightedAveragePriceService
                     .createMonthWAP(inboundDetail1, inventory, transfer.getId(), transfer.getSerialNumber(), ReceiptTypeEnum.TRANSFER.getType());
                  targetStatistics.setOutboundMete(
                     targetStatistics.getOutboundMete() != null
                        ? wmsDeficitDetail.getDeficitMete().add(targetStatistics.getOutboundMete())
                        : wmsDeficitDetail.getDeficitMete()
                  );
                  targetStatistics.setOutboundQuantity(
                     targetStatistics.getOutboundQuantity() != null
                        ? wmsDeficitDetail.getDeficitQuantity().add(targetStatistics.getOutboundQuantity())
                        : wmsDeficitDetail.getDeficitQuantity()
                  );
                  targetStatistics.setOutboundAmount(
                     targetStatistics.getOutboundAmount() != null
                        ? wmsDeficitDetail.getAmount().add(targetStatistics.getOutboundAmount())
                        : wmsDeficitDetail.getAmount()
                  );
                  targetStatistics.setOutboundAmountExcludingVat(
                     targetStatistics.getOutboundAmountExcludingVat() != null
                        ? wmsDeficitDetail.getAmountExcludingVat().add(targetStatistics.getOutboundAmountExcludingVat())
                        : wmsDeficitDetail.getAmountExcludingVat()
                  );
                  targetStatistics.setOutboundUnitPriceExcludingVat(wmsDeficitDetail.getUnitPriceExcludingVat());
                  targetStatistics.setOutboundUnitPrice(wmsDeficitDetail.getUnitPrice());
                  targetStatistics.setOutboundAmountNoFreight(
                     targetStatistics.getOutboundAmountNoFreight() != null
                        ? wmsDeficitDetail.getAmountNoFreight().add(targetStatistics.getOutboundAmountNoFreight())
                        : wmsDeficitDetail.getAmountNoFreight()
                  );
                  targetStatistics.setOutboundAmountExcludingVatNoFreight(
                     targetStatistics.getOutboundAmountExcludingVatNoFreight() != null
                        ? wmsDeficitDetail.getAmountExcludingVatNoFreight().add(targetStatistics.getOutboundAmountExcludingVatNoFreight())
                        : wmsDeficitDetail.getAmountExcludingVatNoFreight()
                  );
                  targetStatistics.setOutboundUnitPriceExcludingVatNoFreight(wmsDeficitDetail.getUnitPriceExcludingVatNoFreight());
                  targetStatistics.setOutboundUnitPriceNoFreight(wmsDeficitDetail.getUnitPriceNoFreight());
                  targetStatistics.setEndMete(targetStatistics.getEndMete().subtract(wmsDeficitDetail.getDeficitMete()));
                  if (targetStatistics.getEndQuantity() != null) {
                     targetStatistics.setEndQuantity(targetStatistics.getEndQuantity().subtract(wmsDeficitDetail.getDeficitQuantity()));
                  }

                  this.statisticsMapper.updateById(targetStatistics);
                  this.saveStatisticsOutbound(wmsDeficit, wmsDeficitDetail, inventory, targetStatistics.getId());
                  if (WeightedPriceEnum.SINGLE.getType().equals(weightedPriceConf.getWeightedType())) {
                     MonthWeightedAveragePrice wap1 = this.weightedAveragePriceService.getPrice(inventory);
                     if (wmsDeficitDetail.getDeficitQuantity() != null) {
                        wap1.setQuantity(wap1.getQuantity().subtract(wmsDeficitDetail.getDeficitQuantity()));
                     }

                     wap1.setMete(wap1.getMete().subtract(wmsDeficitDetail.getDeficitMete()));
                     wap1.setAmount(wap1.getAmount().subtract(wmsDeficitDetail.getAmount()));
                     wap1.setAmountExcludingVat(wap1.getAmountExcludingVat().subtract(wmsDeficitDetail.getAmountExcludingVat()));
                     wap1.setAmountNoFreight(wap1.getAmountNoFreight().subtract(wmsDeficitDetail.getAmountNoFreight()));
                     wap1.setAmountExcludingVatNoFreight(wap1.getAmountExcludingVatNoFreight().subtract(wmsDeficitDetail.getAmountExcludingVatNoFreight()));
                     this.monthWeightedAveragePriceMapper.updateById(wap1);
                  } else {
                     WholeWeightedAveragePrice price = this.wholeWAPMapper.getPrice(inventory);
                     price.setAmount(price.getAmount().subtract(wmsDeficitDetail.getAmount()));
                     price.setAmountExcludingVat(price.getAmountExcludingVat().subtract(wmsDeficitDetail.getAmountExcludingVat()));
                     price.setAmountNoFreight(price.getAmountNoFreight().subtract(wmsDeficitDetail.getAmountNoFreight()));
                     price.setAmountExcludingVatNoFreight(price.getAmountExcludingVatNoFreight().subtract(wmsDeficitDetail.getAmountExcludingVatNoFreight()));
                     price.setMete(price.getMete().subtract(wmsDeficitDetail.getDeficitMete()));
                     this.wholeWAPMapper.updateById(price);
                  }
               }

               statistics.setEndMete(statistics.getEndMete().subtract(wmsDeficitDetail.getDeficitMete()));
               if (statistics.getEndQuantity() != null) {
                  statistics.setEndQuantity(statistics.getEndQuantity().subtract(wmsDeficitDetail.getDeficitQuantity()));
               }

               this.statisticsMapper.updateById(statistics);
            }

            materialInventory.setMete(materialInventory.getMete().subtract(wmsDeficitDetail.getDeficitMete()));
            if (materialInventory.getQuantity() != null) {
               materialInventory.setQuantity(materialInventory.getQuantity().subtract(wmsDeficitDetail.getDeficitQuantity()));
            }

            if (materialInventory.getMete().compareTo(BigDecimal.ZERO) == 0) {
               this.materialInventoryService.removeById(materialInventory);
            } else {
               this.materialInventoryService.updateById(materialInventory);
            }

            this.wmsUtil
               .setInventoryUse(
                  materialInventory,
                  wmsDeficitDetail.getDeficitQuantity(),
                  wmsDeficitDetail.getDeficitMete(),
                  ReceiptTypeEnum.DEFICIT,
                  wmsDeficit.getId(),
                  wmsDeficit.getSerialNumber(),
                  1,
                  false
               );
            this.setStatisticsEndPeriod(materialInventory, statistics);
            wmsDeficitDetail.setReviewStatus(OutboundStatusEnum.REVIEWED.getType());
            this.wmsDeficitDetailService.updateById(wmsDeficitDetail);
         }
      );
      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean returnDeficit(Long id) {
      WmsDeficit wmsDeficit = this.baseMapper.selectById(id);
      Preconditions.checkArgument(
         OutboundStatusEnum.UN_REVIEWED.getType().equals(wmsDeficit.getReviewStatus())
            || OutboundStatusEnum.AUDITING.getType().equals(wmsDeficit.getReviewStatus()),
         "盘库单已审核,请核对后操作"
      );
      wmsDeficit.setReviewStatus(4);
      this.baseMapper.updateById(wmsDeficit);

      for (WmsDeficitDetail wmsDeficitDetail : this.wmsDeficitDetailService
         .list((Wrapper<WmsDeficitDetail>)new LambdaQueryWrapper<WmsDeficitDetail>().eq(WmsDeficitDetail::getDeficitId, id))) {
         this.materialUnfreeze(id, wmsDeficitDetail.getId(), MaterialFreezeTypeEnum.DEFICIT.getType());
         wmsDeficitDetail.setReviewStatus(4);
         this.wmsDeficitDetailService.updateById(wmsDeficitDetail);
      }

      return null;
   }

   private void setStatisticsEndPeriod(MaterialInventory materialInventory, Statistics statistics) {
      StatisticsEndPeriod endPeriod = this.statisticsEndPeriodMapper.getOne(statistics.getId(), materialInventory.getId());
      endPeriod.setMete(materialInventory.getMete());
      endPeriod.setQuantity(materialInventory.getQuantity());
      this.statisticsEndPeriodMapper.updateById(endPeriod);
   }

   @Override
   public List<WmsDeficitDetailDTO> getDefictById(Long id) {
      List<WmsDeficitDetail> list = this.wmsDeficitDetailService
         .list((Wrapper<WmsDeficitDetail>)new LambdaQueryWrapper<WmsDeficitDetail>().eq(WmsDeficitDetail::getDeficitId, id));
      Map<Long, Warehouse> warehouseMap = this.queryUtil.getWarehouseMap(null);
      Map<Long, ContractProject> projectMap = this.queryUtil.getProjectMap(null);
      return list.stream()
         .map(
            deficitDTO -> {
               WmsDeficitDetailDTO dto = BeanUtil.copy(deficitDTO, WmsDeficitDetailDTO.class);
               if (deficitDTO.getWarehouseId() != null) {
                  Warehouse warehouse = warehouseMap.get(deficitDTO.getWarehouseId());
                  dto.setWarehouse(BriefIdAndNameDTO.builder().id(warehouse.getId()).name(warehouse.getName()).build());
               }

               if (deficitDTO.getProjectId() != null) {
                  ContractProject project = projectMap.get(deficitDTO.getProjectId());
                  dto.setProject(
                     ProjectInfoDTO.builder()
                        .id(project.getId())
                        .serialNumber(project.getSerialNumber())
                        .shortName(project.getShortName())
                        .name(project.getName())
                        .build()
                  );
               }

               if (deficitDTO.getDeficitProjectId() != null) {
                  ContractProject project = projectMap.get(deficitDTO.getDeficitProjectId());
                  dto.setDeficitProject(
                     ProjectInfoDTO.builder()
                        .id(project.getId())
                        .serialNumber(project.getSerialNumber())
                        .shortName(project.getShortName())
                        .name(project.getName())
                        .build()
                  );
               }

               return dto;
            }
         )
         .collect(Collectors.toList());
   }

   @Override
   public PageVO<WmsDeficitDetailDTO> getWmsDeficitDetail(QueryReportDeficitDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort) {
      String s = StringUtils.analyzeSortConditions(sort);
      Page<WmsDeficitDetailDTO> page = PageHelper.startPage(pageNumber, pageSize, s);
      LambdaQueryWrapper<WmsDeficitDetail> wmsDeficitDetailLambdaQueryWrapper = new LambdaQueryWrapper<>();
      wmsDeficitDetailLambdaQueryWrapper.eq(param.getBasicClass() != null, WmsDeficitDetail::getBasicClass, param.getBasicClass())
         .eq(param.getDeficitType() != null, WmsDeficitDetail::getDeficitType, param.getDeficitType())
         .eq(param.getProjectId() != null, WmsDeficitDetail::getProjectId, param.getProjectId())
         .eq(param.getWarehouseType() != null, WmsDeficitDetail::getWarehouseType, param.getWarehouseType())
         .eq(StrUtil.isNotEmpty(param.getSerialNumber()), WmsDeficitDetail::getDeficitSerialNumber, param.getSerialNumber())
         .like(StrUtil.isNotEmpty(param.getApplicantName()), WmsDeficitDetail::getApplicantName, param.getApplicantName())
         .eq(param.getReviewStatus() != null, WmsDeficitDetail::getReviewStatus, param.getReviewStatus())
         .orderByDesc(BaseEntity::getCreateTime);
      if (CollectionUtil.isNotEmpty(param.getCreateTime())) {
         wmsDeficitDetailLambdaQueryWrapper.between(BaseEntity::getCreateTime, param.getCreateTime().get(0), param.getCreateTime().get(1));
      }

      List<WmsDeficitDetail> list = this.wmsDeficitDetailService.list(wmsDeficitDetailLambdaQueryWrapper);
      Map<Long, Warehouse> warehouseMap = this.queryUtil.getWarehouseMap(null);
      Map<Long, ContractProject> projectMap = this.queryUtil.getProjectMap(null);
      List<WmsDeficitDetailDTO> wmsDeficitDetailDTOList = list.stream()
         .map(
            deficitDTO -> {
               WmsDeficitDetailDTO dto = BeanUtil.copy(deficitDTO, WmsDeficitDetailDTO.class);
               if (deficitDTO.getWarehouseId() != null) {
                  Warehouse warehouse = warehouseMap.get(deficitDTO.getWarehouseId());
                  dto.setWarehouse(BriefIdAndNameDTO.builder().id(warehouse.getId()).name(warehouse.getName()).build());
               }

               if (deficitDTO.getProjectId() != null) {
                  ContractProject project = projectMap.get(deficitDTO.getProjectId());
                  dto.setProject(
                     ProjectInfoDTO.builder()
                        .id(project.getId())
                        .serialNumber(project.getSerialNumber())
                        .shortName(project.getShortName())
                        .name(project.getName())
                        .build()
                  );
               }

               if (deficitDTO.getDeficitProjectId() != null) {
                  ContractProject project = projectMap.get(deficitDTO.getDeficitProjectId());
                  dto.setDeficitProject(
                     ProjectInfoDTO.builder()
                        .id(project.getId())
                        .serialNumber(project.getSerialNumber())
                        .shortName(project.getShortName())
                        .name(project.getName())
                        .build()
                  );
               }

               return dto;
            }
         )
         .collect(Collectors.toList());
      return new PageVO<>(page, wmsDeficitDetailDTOList);
   }

   @Override
   public PageVO<WmsDeficitDTO> getWmsDeficit(QueryReportDeficitDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort) {
      String s = StringUtils.analyzeSortConditions(sort);
      Page<WmsDeficitDTO> page = PageHelper.startPage(pageNumber, pageSize, s);
      List<WmsDeficit> deficitList = this.baseMapper.getDeficitList(param);
      List<WmsDeficitDTO> list = deficitList.stream()
         .map(
            deficitDTO -> {
               WmsDeficitDTO dto = BeanUtil.copy(deficitDTO, WmsDeficitDTO.class);
               if (StrUtil.isNotBlank(deficitDTO.getProjectIds())) {
                  dto.setProjects(
                     this.projectService
                        .listByIds(deficitDTO.getProjectIds())
                        .stream()
                        .map(pro -> BeanUtil.copy(pro, ProjectInfoDTO.class))
                        .collect(Collectors.toList())
                  );
               }

               return dto;
            }
         )
         .collect(Collectors.toList());
      return new PageVO<>(page, list);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean revocation(Long id) {
      SecurityUser currentUser = UserUtil.getCurrentUser();
      WmsDeficit wmsDeficit = this.baseMapper.selectById(id);
      Preconditions.checkArgument(currentUser.getId().equals(wmsDeficit.getApplicantId()), "仅创建此盘亏单的人才可进行撤销操作");
      Preconditions.checkArgument(ReviewStatusEnum.AUDITING.getType().equals(wmsDeficit.getReviewStatus()), "只可在创建中才可撤销申请，撤销失败");
      if (ObjectUtil.isNotEmpty(wmsDeficit.getApproveRecordId())) {
         this.wmsApproveRecordService.revocation(wmsDeficit.getApproveRecordId());
      }

      for (WmsDeficitDetail wmsDeficitDetail : this.wmsDeficitDetailService
         .list((Wrapper<WmsDeficitDetail>)new LambdaQueryWrapper<WmsDeficitDetail>().eq(WmsDeficitDetail::getDeficitId, id))) {
         this.materialUnfreeze(id, wmsDeficitDetail.getId(), MaterialFreezeTypeEnum.DEFICIT.getType());
         wmsDeficitDetail.setReviewStatus(4);
         this.wmsDeficitDetailService.updateById(wmsDeficitDetail);
      }

      wmsDeficit.setReviewStatus(ReviewStatusEnum.CANCEL.getType());
      int i = this.baseMapper.updateById(wmsDeficit);
      Preconditions.checkArgument(i == 1, "撤销失败");
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean approvalDeficit(Long id, Long approveRecordId, Integer decision, String opinion) {
      WmsDeficit wmsDeficit = this.baseMapper.selectById(id);
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(wmsDeficit), "盘亏单不存在");
      Preconditions.checkArgument(!ReviewStatusEnum.REVIEWED.getType().equals(wmsDeficit.getReviewStatus()), "当前盘亏单已审核通过,不能修改");
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService.getById(approveRecordId);
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(wmsApproveRecord), "审批日志不存在");
      Boolean b = this.wmsApproveRecordService.commonApproveStep(wmsDeficit.getId(), decision, opinion, wmsApproveRecord.getSerialNumber(), null);
      if (b) {
         if (decision.equals(CheckStatusEnum.PASS.getType())) {
            this.passedDeficit(wmsDeficit.getId());
         } else {
            this.returnDeficit(wmsDeficit.getId());
         }
      }

      return true;
   }

   private Measure getMeasure(Long pid) {
      Classification classification = this.classificationService.getById(pid);
      Measure m = this.measureService.getOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, pid));
      if (m.getAccountingUnit() != null) {
         m.setAccountingUnit(m.getAccountingUnit() + "/" + classification.getName());
         return m;
      } else {
         return this.getMeasure(classification.getParentId());
      }
   }

   private Measure getMeasured(Long id) {
      Classification classification = this.classificationService.getById(id);
      Measure m = this.measureService.getOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, id));
      return m.getOutboundUnitType() != null ? m : this.getMeasure(classification.getParentId());
   }

   private void saveStatisticsOutbound(WmsDeficit wmsDeficit, WmsDeficitDetail wmsDeficitDetail, MaterialInventory materialInventory, Long statisticsId) {
      StatisticsOutbound statisticsOutbound = BeanUtil.copy(materialInventory, StatisticsOutbound.class, "createTime");
      statisticsOutbound.setReceiptType(ReceiptTypeEnum.DEFICIT.getType());
      statisticsOutbound.setReceiptId(wmsDeficit.getId());
      statisticsOutbound.setReceiptSerialNumber(wmsDeficit.getSerialNumber());
      statisticsOutbound.setWarehouseType(materialInventory.getWarehouseType());
      statisticsOutbound.setBoolPartyA(materialInventory.getBoolPartyA());
      statisticsOutbound.setStatisticsId(statisticsId);
      statisticsOutbound.setClassifyName(materialInventory.getClassifyName());
      statisticsOutbound.setTheoryThickness(materialInventory.getTheoryThickness());
      statisticsOutbound.setDetailId(wmsDeficitDetail.getId());
      statisticsOutbound.setAmount(wmsDeficitDetail.getAmount());
      statisticsOutbound.setAmountExcludingVat(wmsDeficitDetail.getAmountExcludingVat());
      statisticsOutbound.setMete(wmsDeficitDetail.getDeficitMete());
      statisticsOutbound.setQuantity(wmsDeficitDetail.getDeficitQuantity());
      statisticsOutbound.setUnitPrice(wmsDeficitDetail.getUnitPrice());
      statisticsOutbound.setUnitPriceExcludingVat(wmsDeficitDetail.getUnitPriceExcludingVat());
      statisticsOutbound.setOutboundRelationType(OutboundTypeEnum.PRODUCTION_USE.getType());
      statisticsOutbound.setAmountNoFreight(wmsDeficitDetail.getAmountNoFreight());
      statisticsOutbound.setAmountExcludingVatNoFreight(wmsDeficitDetail.getAmountExcludingVatNoFreight());
      statisticsOutbound.setUnitPriceNoFreight(wmsDeficitDetail.getUnitPriceNoFreight());
      statisticsOutbound.setUnitPriceExcludingVatNoFreight(wmsDeficitDetail.getUnitPriceExcludingVatNoFreight());
      statisticsOutbound.setOutboundTime(LocalDateTime.now());
      this.statisticsOutboundMapper.insert(statisticsOutbound);
   }

   private void setMaterialFreeze(MaterialInventory materialInventory, WmsDeficitDetail convertDetail) {
      MaterialFreeze materialFreeze = this.materialFreezeService
         .getOne((Wrapper<MaterialFreeze>)Wrappers.<MaterialFreeze>lambdaQuery().eq(MaterialFreeze::getMaterialInventoryId, materialInventory.getId()));
      if (materialFreeze == null) {
         materialFreeze = BeanUtil.copy(materialInventory, MaterialFreeze.class, "createTime");
         materialFreeze.setTotalQuantity(convertDetail.getDeficitQuantity());
         materialFreeze.setTotalMete(convertDetail.getDeficitMete());
         materialFreeze.setTotalFreezeTypes(MaterialFreezeTypeEnum.DEFICIT.getType() + "");
         materialFreeze.setMaterialInventoryId(materialInventory.getId());
         this.materialFreezeService.save(materialFreeze);
      } else {
         if (convertDetail.getQuantity() != null) {
            materialFreeze.setTotalQuantity(
               convertDetail.getDeficitQuantity() != null
                  ? materialFreeze.getTotalQuantity().add(convertDetail.getDeficitQuantity())
                  : materialFreeze.getTotalQuantity().add(convertDetail.getDeficitQuantity())
            );
         }

         List<Integer> t = Arrays.stream(materialFreeze.getTotalFreezeTypes().split(",")).map(Integer::parseInt).collect(Collectors.toList());
         if (!t.contains(MaterialFreezeTypeEnum.DEFICIT.getType())) {
            t.add(MaterialFreezeTypeEnum.DEFICIT.getType());
            materialFreeze.setTotalFreezeTypes(StrUtil.join(",", t));
         }

         materialFreeze.setTotalMete(materialFreeze.getTotalMete().add(convertDetail.getDeficitMete()));
         this.materialFreezeService.updateById(materialFreeze);
      }

      MaterialFreezeRecord materialFreezeRecord = MaterialFreezeRecord.builder()
         .materialFreezeId(materialFreeze.getId())
         .freezeDetailId(convertDetail.getId())
         .freezeType(MaterialFreezeTypeEnum.DEFICIT.getType())
         .freezeSourceId(convertDetail.getDeficitId())
         .freezeSourceSn(convertDetail.getDeficitSerialNumber())
         .operatorId(UserUtil.getCurrentUserId())
         .operatorName(UserUtil.getCurrentName())
         .mete(convertDetail.getDeficitMete())
         .quantity(convertDetail.getDeficitQuantity())
         .boolBatten(false)
         .projectId(convertDetail.getProjectId())
         .frozenTime(LocalDateTime.now())
         .outboundUnitType(1)
         .build();
      this.materialFreezeRecordMapper.insert(materialFreezeRecord);
      if (!materialInventory.getBoolHasFrozen()) {
         this.materialInventoryMapper.updateBoolHasFrozen(materialInventory.getId(), true);
      }
   }

   public void materialUnfreeze(Long id, Long detailId, Integer freezeType) {
      MaterialFreezeRecord freezeRecord = this.materialFreezeRecordMapper
         .selectOne(
            ((Wrappers.<MaterialFreezeRecord>lambdaQuery().eq(MaterialFreezeRecord::getFreezeType, freezeType))
                  .eq(MaterialFreezeRecord::getFreezeSourceId, id))
               .eq(detailId != null, MaterialFreezeRecord::getFreezeDetailId, detailId)
         );
      if (freezeRecord != null) {
         MaterialFreeze materialFreeze = this.materialFreezeService.getById(freezeRecord.getMaterialFreezeId());
         materialFreeze.setTotalMete(materialFreeze.getTotalMete().subtract(freezeRecord.getMete()));
         materialFreeze.setTotalQuantity(
            materialFreeze.getTotalQuantity() != null ? materialFreeze.getTotalQuantity().subtract(freezeRecord.getQuantity()) : null
         );
         if (materialFreeze.getTotalMete().compareTo(BigDecimal.ZERO) > 0) {
            this.materialFreezeService.updateById(materialFreeze);
         } else {
            this.materialInventoryMapper.updateBoolHasFrozen(materialFreeze.getMaterialInventoryId(), false);
            this.materialFreezeService.removeById(materialFreeze);
         }

         this.materialFreezeRecordMapper.deleteById(freezeRecord);
      }
   }
}
