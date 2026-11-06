package com.hzchum.scim.wms.core.service.impl.wmsUse;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.cut.core.api.service.NestCutPlatePartService;
import com.hzchum.scim.cut.core.api.service.NestCutPlateService;
import com.hzchum.scim.cut.core.api.service.NestCutSurplusService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingNestCutPlateService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.system.core.api.common.enums.NumberTypeEnum;
import com.hzchum.scim.system.core.api.pojo._do.MesBuildingNestingTeam;
import com.hzchum.scim.system.core.api.service.MesBuildingNestingTeamService;
import com.hzchum.scim.system.core.api.service.NumberConfigService;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.enums.MaterialFreezeTypeEnum;
import com.hzchum.scim.wms.core.api.enums.MaterialIsWholeEnum;
import com.hzchum.scim.wms.core.api.enums.OutboundRelationTypeEnum;
import com.hzchum.scim.wms.core.api.enums.ReceiptTypeEnum;
import com.hzchum.scim.wms.core.api.enums.TransferTypeEnum;
import com.hzchum.scim.wms.core.api.enums.UnitsPrecisionEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Measure;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.Statistics;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsOutbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialFreeze;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialFreezeRecord;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MonthWeightedAveragePrice;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MoveOutboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Outbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Transfer;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.TransferDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WholeWeightedAveragePrice;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.SteelPlateInventoryDTO;
import com.hzchum.scim.wms.core.api.service.wmsConfig.BasicConfigService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.MeasureService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialFreezeRecordService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialFreezeService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WeightedAveragePriceService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsCutService;
import com.hzchum.scim.wms.core.api.utils.CommonUtil;
import com.hzchum.scim.wms.core.mapper.wmsReport.CutSurplusRecordMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsEndPeriodMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsOutboundMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.BarcodeMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MaterialInventoryMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MonthWeightedAveragePriceMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MoveOutboundDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.OutboundMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.PrintDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.PrintMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.ScrapMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.TransferDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.TransferMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.WholeWeightedAveragePriceMapper;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WmsCutServiceImpl implements WmsCutService {
   private static final Logger log = LoggerFactory.getLogger(WmsCutServiceImpl.class);
   @Resource
   MaterialInventoryMapper materialInventoryMapper;
   @Resource
   ContractProjectService contractProjectService;
   @Resource
   MaterialFreezeService materialFreezeService;
   @Resource
   MaterialFreezeRecordService materialFreezeRecordService;
   @Resource
   MonthWeightedAveragePriceMapper wapMapper;
   @Resource
   NestCutPlateService nestCutPlateService;
   @Resource
   MesBuildingNestCutPlateService cutPlateService;
   @Resource
   NestCutSurplusService nestCutSurplusService;
   @Resource
   TechMachinePartService techMachinePartService;
   @Resource
   NestCutPlatePartService nestCutPlatePartService;
   @Resource
   BasicConfigService basicConfigService;
   @Resource
   ScrapMapper scrapMapper;
   @Resource
   CutSurplusRecordMapper cutSurplusRecordMapper;
   @Resource
   BarcodeMapper barcodeMapper;
   @Resource
   StatisticsMapper statisticsMapper;
   @Resource
   NumberConfigService numberConfigService;
   @Resource
   OutboundMapper outboundMapper;
   @Resource
   MoveOutboundDetailMapper moveOutboundDetailMapper;
   @Resource
   MonthWeightedAveragePriceMapper monthWAPMapper;
   @Resource
   TransferMapper transferMapper;
   @Resource
   TransferDetailMapper transferDetailMapper;
   @Resource
   StatisticsEndPeriodMapper statisticsEndPeriodMapper;
   @Resource
   StatisticsOutboundMapper statisticsOutboundMapper;
   @Resource
   PrintMapper printMapper;
   @Resource
   PrintDetailMapper printDetailMapper;
   @Resource
   WeightedAveragePriceService WAPService;
   @Resource
   WholeWeightedAveragePriceMapper wholeWAPMapper;
   @Value("${wms.amount-accuracy}")
   private Integer amountAccuracy;
   RoundingMode ROUNDING = RoundingMode.HALF_UP;
   @Resource
   MesBuildingNestingTeamService mesBuildingNestingTeamService;
   @Resource
   MeasureService measureService;

   @Override
   public List<SteelPlateInventoryDTO> getSteelPlateList(String spec, Double thickness, String teamCode) {
      List<MesBuildingNestingTeam> mesBuildingNestingTeamList = this.mesBuildingNestingTeamService
         .list(
            (Wrapper<MesBuildingNestingTeam>)(new LambdaQueryWrapper<MesBuildingNestingTeam>().eq(MesBuildingNestingTeam::getBoolDrillHole, 1))
               .eq(MesBuildingNestingTeam::getTeamCode, teamCode)
         );
      MesBuildingNestingTeam mesBuildingNestingTeam = mesBuildingNestingTeamList.get(0);
      List<MaterialInventory> materialInventories = this.materialInventoryMapper
         .selectList(
            (Wrapper<MaterialInventory>)(((new LambdaQueryWrapper<MaterialInventory>()
                        .eq(MaterialInventory::getBasicClass, BasicClassEnum.STEEL_PLATE.getType()))
                     .eq(StrUtil.isNotBlank(spec), MaterialInventory::getSpecification, spec))
                  .eq(thickness != null, MaterialInventory::getThickness, thickness))
               .eq(MaterialInventory::getMaterialIsWhole, 1)
         );
      List<MaterialInventory> materialInventories1 = this.materialInventoryMapper
         .selectList(
            (Wrapper<MaterialInventory>)(((new LambdaQueryWrapper<MaterialInventory>()
                        .eq(MaterialInventory::getBasicClass, BasicClassEnum.STEEL_PLATE.getType()))
                     .eq(StrUtil.isNotBlank(spec), MaterialInventory::getSpecification, spec))
                  .eq(thickness != null, MaterialInventory::getThickness, thickness))
               .eq(MaterialInventory::getBoolNestSurplus, true)
         );
      materialInventories.addAll(materialInventories1);
      return materialInventories.stream()
         .map(
            m -> {
               SteelPlateInventoryDTO dto = BeanUtil.copy(m, SteelPlateInventoryDTO.class);
               MaterialFreeze materialFreeze = this.materialFreezeService
                  .getOne((Wrapper<MaterialFreeze>)Wrappers.<MaterialFreeze>lambdaQuery().eq(MaterialFreeze::getMaterialInventoryId, m.getId()));
               if (materialFreeze != null) {
                  dto.setQuantity(m.getQuantity().subtract(materialFreeze.getTotalQuantity()));
               }

               dto.setPlateNo(m.getBarcode());
               dto.setThickness(m.getThickness());
               dto.setUserdata1(m.getProjectId() != null ? this.contractProjectService.getById(m.getProjectId()).getShortName() : "公共库");
               if (!m.getBoolNestSurplus()) {
                  dto.setIsRemnant(0);
               } else {
                  dto.setIsRemnant(1);
               }

               return dto;
            }
         )
         .filter(Objects::nonNull)
         .collect(Collectors.toList());
   }

   @Override
   public Boolean setMaterialFreeze(
      Outbound outbound, String material, Long thickness, String serialNumber, Long syncId, Integer quantity, Map<Long, BigDecimal> sumFreezeMete
   ) {
      MaterialInventory materialInventory = this.materialInventoryMapper.selectById(syncId);
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(materialInventory), material + thickness + "当前物料不存在" + syncId + "排样图guid" + serialNumber);
      MaterialFreeze materialFreeze = this.materialFreezeService
         .getOne((Wrapper<MaterialFreeze>)Wrappers.<MaterialFreeze>lambdaQuery().eq(MaterialFreeze::getMaterialInventoryId, materialInventory.getId()));
      log.info("本地冻结主表记录信息:{}", materialFreeze);
      BigDecimal freezeTotalMete = BigDecimal.ZERO;
      BigDecimal freezeTotalQuantity = BigDecimal.ZERO;
      if (materialFreeze != null) {
         freezeTotalMete = materialFreeze.getTotalMete();
         freezeTotalQuantity = materialFreeze.getTotalQuantity();
      }

      Preconditions.checkArgument(quantity != null && quantity > 0, "当前套料数量必须大于零");
      BigDecimal num = BigDecimal.valueOf(quantity.longValue());
      BigDecimal mete = CommonUtil.getStockOutboundMete(
         num, materialInventory.getQuantity().subtract(freezeTotalQuantity), materialInventory.getMete().subtract(freezeTotalMete)
      );
      sumFreezeMete.merge(materialInventory.getWorkshopId(), mete, BigDecimal::add);
      if (materialFreeze != null) {
         Preconditions.checkArgument(
            materialFreeze.getTotalQuantity().add(num).compareTo(materialInventory.getQuantity()) <= 0, material + thickness + "当前套料数量超出仓库现有数量"
         );
         materialFreeze.setTotalMete(materialFreeze.getTotalMete().add(mete));
         materialFreeze.setTotalQuantity(materialFreeze.getTotalQuantity().add(num));
      }

      if (materialFreeze == null) {
         materialFreeze = BeanUtil.copy(materialInventory, MaterialFreeze.class, "createTime");
         materialFreeze.setMaterialInventoryId(materialInventory.getId());
         materialFreeze.setTotalQuantity(num);
         materialFreeze.setTotalFreezeTypes(MaterialFreezeTypeEnum.NESTING.getType() + "");
         materialFreeze.setTotalMete(mete);
         log.info("新增冻结主表:{}", materialFreeze);
         this.materialFreezeService
            .saveOrUpdate(materialFreeze, (Wrapper<MaterialFreeze>)new UpdateWrapper().eq("material_inventory_id", materialInventory.getId()));
      }

      MaterialFreezeRecord freezeRecord = this.materialFreezeRecordService
         .getOne(
            (Wrapper<MaterialFreezeRecord>)((Wrappers.<MaterialFreezeRecord>lambdaQuery()
                     .eq(MaterialFreezeRecord::getMaterialFreezeId, materialFreeze.getId()))
                  .eq(MaterialFreezeRecord::getFreezeType, MaterialFreezeTypeEnum.NESTING.getType()))
               .eq(MaterialFreezeRecord::getFreezeSourceSn, serialNumber)
         );
      log.info("本地冻结明细记录信息:{}", materialFreeze);
      if (freezeRecord != null) {
         freezeRecord.setQuantity(num);
         freezeRecord.setMete(mete);
         log.info("明细记录存在，更新冻结明细表:{}", freezeRecord);
         this.materialFreezeRecordService.updateById(freezeRecord);
      } else {
         MaterialFreezeRecord materialFreezeRecord = MaterialFreezeRecord.builder()
            .freezeSourceSn(serialNumber)
            .materialFreezeId(materialFreeze.getId())
            .freezeType(MaterialFreezeTypeEnum.NESTING.getType())
            .mete(mete)
            .quantity(num)
            .frozenTime(LocalDateTime.now())
            .build();
         log.info("冻结明细表不存在，新增:{}", materialFreezeRecord);
         this.materialFreezeRecordService
            .saveOrUpdate(
               materialFreezeRecord,
               (Wrapper<MaterialFreezeRecord>)((UpdateWrapper)((UpdateWrapper)new UpdateWrapper().eq("material_freeze_id", materialFreeze.getId()))
                     .eq("freeze_type", MaterialFreezeTypeEnum.NESTING.getType()))
                  .eq("freeze_source_SN", serialNumber)
            );
         List<Integer> t = Arrays.stream(materialFreeze.getTotalFreezeTypes().split(",")).map(Integer::parseInt).collect(Collectors.toList());
         if (!t.contains(MaterialFreezeTypeEnum.NESTING.getType())) {
            t.add(MaterialFreezeTypeEnum.NESTING.getType());
            materialFreeze.setTotalFreezeTypes(StrUtil.join(",", t));
         }
      }

      log.info("更新冻结主表:{}", materialFreeze);
      this.materialFreezeService.updateById(materialFreeze);
      return true;
   }

   @NotNull
   private Transfer saveTransfer(MaterialInventory materialInventory, MonthWeightedAveragePrice wap, Transfer transfer, MoveOutboundDetail outboundDetail) {
      if (transfer == null) {
         transfer = Transfer.builder()
            .basicClass(outboundDetail.getBasicClass())
            .directionProjectId(outboundDetail.getProjectId())
            .directionWorkshopId(outboundDetail.getWorkshopId())
            .directionWarehouseId(outboundDetail.getWarehouseId())
            .directionMonomerId(outboundDetail.getMonomerId())
            .directionAreaId(outboundDetail.getAreaId())
            .transferType(TransferTypeEnum.PROJECT_WARE.getType())
            .reviewStatus(ReviewStatusEnum.REVIEWED.getType())
            .reviewTime(LocalDateTime.now())
            .userUpdateTime(LocalDateTime.now())
            .transferCreateType(2)
            .build();
         Integer count = this.transferMapper.getMaxDayNumber(LocalDateTime.now());
         String sn = this.numberConfigService.getNumber(NumberTypeEnum.TRANSFER, count);
         transfer.setSerialNumber(sn);
         this.transferMapper.insert(transfer);
      }

      BigDecimal amount;
      BigDecimal amountExcludingVat;
      if (wap.getAmount() != null) {
         BigDecimal p = outboundDetail.getMete().divide(wap.getMete(), 20, this.ROUNDING);
         amount = wap.getAmount().multiply(p).setScale(this.amountAccuracy, this.ROUNDING);
         amountExcludingVat = wap.getAmountExcludingVat().multiply(p).setScale(this.amountAccuracy, this.ROUNDING);
      } else {
         WholeWeightedAveragePrice price = this.wholeWAPMapper.getPrice(materialInventory);
         BigDecimal p = outboundDetail.getMete().divide(price.getMete(), 20, this.ROUNDING);
         amount = price.getAmount().multiply(p).setScale(this.amountAccuracy, this.ROUNDING);
         amountExcludingVat = price.getAmountExcludingVat().multiply(p).setScale(this.amountAccuracy, this.ROUNDING);
      }

      TransferDetail transferDetail = TransferDetail.builder()
         .boolPartyA(materialInventory.getBoolPartyA())
         .transferId(transfer.getId())
         .materialInventoryId(materialInventory.getId())
         .specification(materialInventory.getSpecification())
         .basicClass(materialInventory.getBasicClass())
         .brand(materialInventory.getBrand())
         .heatNoAndBatchNo(materialInventory.getHeatNoAndBatchNo())
         .classifyId(materialInventory.getClassifyId())
         .transferType(TransferTypeEnum.PROJECT_WARE.getType())
         .sourceWorkshopId(materialInventory.getWorkshopId())
         .sourceWarehouseId(materialInventory.getWarehouseId())
         .sourceProjectId(materialInventory.getProjectId())
         .sourceMonomerId(materialInventory.getMonomerId())
         .sourceAreaId(materialInventory.getAreaId())
         .mete(outboundDetail.getMete())
         .quantity(outboundDetail.getQuantity())
         .unitPrice(wap.getUnitPrice())
         .unitPriceExcludingVat(wap.getUnitPriceExcludingVat())
         .color(materialInventory.getColor())
         .remark(outboundDetail.getRemark())
         .taxRate(materialInventory.getTaxRate())
         .invoiceType(materialInventory.getInvoiceType())
         .standardId(materialInventory.getStandardId())
         .standardName(materialInventory.getStandardName())
         .amount(amount)
         .amountExcludingVat(amountExcludingVat)
         .inputVat(amount.subtract(amountExcludingVat))
         .build();
      this.transferDetailMapper.insert(transferDetail);
      wap.setMete(wap.getMete().subtract(transferDetail.getMete()));
      if (wap.getAmount() != null) {
         wap.setAmount(wap.getAmount().subtract(amount));
         wap.setAmountExcludingVat(wap.getAmountExcludingVat().subtract(amountExcludingVat));
      }

      if (wap.getMete().compareTo(BigDecimal.ZERO) <= 0) {
         this.monthWAPMapper.deleteById(wap);
      } else {
         this.monthWAPMapper.updateById(wap);
      }

      MaterialInventory inventory = BeanUtil.copy(materialInventory, MaterialInventory.class);
      inventory.setProjectId(outboundDetail.getProjectId());
      inventory.setWorkshopId(outboundDetail.getWorkshopId());
      InboundDetail inboundDetail = InboundDetail.builder()
         .basicClass(inventory.getBasicClass())
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
         .quantity(transferDetail.getQuantity())
         .mete(transferDetail.getMete())
         .workshopId(transfer.getDirectionWorkshopId())
         .warehouseId(transfer.getDirectionWarehouseId())
         .measureUnit(inventory.getMeasureUnit())
         .taxRate(inventory.getTaxRate())
         .invoiceType(inventory.getInvoiceType())
         .standardName(inventory.getStandardName())
         .standardId(inventory.getStandardId())
         .oneTheoryWeight(inventory.getOneTheoryWeight())
         .sectionSteelWeight(inventory.getSectionSteelWeight())
         .monomerId(inventory.getMonomerId())
         .areaId(inventory.getAreaId())
         .projectId(outboundDetail.getProjectId())
         .build();
      Statistics statistics = this.WAPService
         .createMonthWAP(inboundDetail, inventory, transfer.getId(), transfer.getSerialNumber(), ReceiptTypeEnum.TRANSFER.getType());
      outboundDetail.setWapId(statistics.getWapId());
      this.moveOutboundDetailMapper.updateById(outboundDetail);
      return transfer;
   }

   private MoveOutboundDetail getMoveOutboundDetail(
      MaterialInventory materialInventory,
      MonthWeightedAveragePrice wap,
      Outbound outbound,
      Long projectId,
      Long workshopId,
      BigDecimal actualMete,
      Integer materialIsWhole,
      Long statId
   ) {
      MoveOutboundDetail outboundDetail = MoveOutboundDetail.builder()
         .warehouseId(materialInventory.getWarehouseId())
         .materialIsWhole(materialIsWhole)
         .workshopId(workshopId)
         .materialInventoryId(materialInventory.getId())
         .outboundId(outbound.getId())
         .basicClass(materialInventory.getBasicClass())
         .thickness(materialInventory.getThickness())
         .theoryThickness(materialInventory.getTheoryThickness())
         .specification(materialInventory.getSpecification())
         .classifyId(materialInventory.getClassifyId())
         .sourceProjectId(materialInventory.getProjectId())
         .sourceMonomerId(materialInventory.getMonomerId())
         .sourceAreaId(materialInventory.getAreaId())
         .heatNoAndBatchNo(materialInventory.getHeatNoAndBatchNo())
         .brand(materialInventory.getBrand())
         .outboundTime(LocalDateTime.now())
         .color(materialInventory.getColor())
         .projectId(projectId)
         .boolPartyA(materialInventory.getBoolPartyA())
         .taxRate(materialInventory.getTaxRate())
         .invoiceType(materialInventory.getInvoiceType())
         .standardId(materialInventory.getStandardId())
         .standardName(materialInventory.getStandardName())
         .materialSn(materialInventory.getSerialNumber())
         .quantity(BigDecimal.ONE)
         .mete(actualMete)
         .wapId(wap.getId())
         .build();
      if (materialInventory.getProjectId() != null) {
         outboundDetail.setOutboundRelationType(
            materialInventory.getProjectId().equals(projectId) ? OutboundRelationTypeEnum.CUT_TRANSFER.getType() : OutboundRelationTypeEnum.CUT.getType()
         );
      }

      this.moveOutboundDetailMapper.insert(outboundDetail);
      StatisticsOutbound statisticsOutbound = BeanUtil.copy(outboundDetail, StatisticsOutbound.class, "createTime");
      statisticsOutbound.setReceiptType(ReceiptTypeEnum.OUTBOUND.getType());
      statisticsOutbound.setReceiptId(outbound.getId());
      statisticsOutbound.setReceiptSerialNumber(outbound.getSerialNumber());
      statisticsOutbound.setWarehouseType(materialInventory.getWarehouseType());
      statisticsOutbound.setBoolPartyA(materialInventory.getBoolPartyA());
      statisticsOutbound.setStatisticsId(statId);
      statisticsOutbound.setClassifyName(materialInventory.getClassifyName());
      statisticsOutbound.setTheoryThickness(materialInventory.getTheoryThickness());
      statisticsOutbound.setOutboundRelationType(
         MaterialIsWholeEnum.WHOLE.getType().equals(outboundDetail.getMaterialIsWhole())
            ? OutboundRelationTypeEnum.ROUTINE.getType()
            : OutboundRelationTypeEnum.CUT.getType()
      );
      statisticsOutbound.setDetailId(outboundDetail.getId());
      this.statisticsOutboundMapper.insert(statisticsOutbound);
      return outboundDetail;
   }
}
