package com.hzchum.scim.wms.core.service.impl.wmsUse;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.pojo.common.MonthTimeRange;
import com.hzchum.scim.wms.core.api.enums.ReceiptTypeEnum;
import com.hzchum.scim.wms.core.api.enums.WeightedPriceEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.BasicConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WeightedPriceConf;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.Statistics;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsEndPeriod;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsInbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsOutbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MonthWeightedAveragePrice;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MoveWeightedAveragePrice;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WholeWeightedAveragePrice;
import com.hzchum.scim.wms.core.api.service.wmsUse.WeightedAveragePriceService;
import com.hzchum.scim.wms.core.mapper.wmsConfig.BasicConfigMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsEndPeriodMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsInboundMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsOutboundMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MonthWeightedAveragePriceMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MoveWeightedAveragePriceMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.WholeWeightedAveragePriceMapper;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WeightedAveragePriceServiceImpl implements WeightedAveragePriceService {
   @Resource
   MoveWeightedAveragePriceMapper moveWeightedAveragePriceMapper;
   @Resource
   StatisticsMapper statisticsMapper;
   @Resource
   StatisticsInboundMapper statisticsInboundMapper;
   @Resource
   StatisticsEndPeriodMapper statisticsEndPeriodMapper;
   @Resource
   MonthWeightedAveragePriceMapper monthWeightedAveragePriceMapper;
   @Resource
   WholeWeightedAveragePriceMapper wholeWAPMapper;
   @Resource
   StatisticsOutboundMapper statisticsOutboundMapper;
   @Resource
   BasicConfigMapper basicConfigMapper;
   @Value("${wms.amount-accuracy}")
   private Integer amountAccuracy;

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Statistics createMoveWAP(
      InboundDetail inboundDetail, MaterialInventory materialInventory, Long receiptId, String receiptSerialNumber, Integer receiptType
   ) {
      MoveWeightedAveragePrice wap = this.moveWeightedAveragePriceMapper.getPrice(materialInventory);
      if (wap == null) {
         wap = MoveWeightedAveragePrice.builder()
            .classifyId(materialInventory.getClassifyId())
            .basicClass(materialInventory.getBasicClass())
            .projectId(inboundDetail.getProjectId())
            .specification(materialInventory.getWeightedAverageSpec())
            .thickness(materialInventory.getThickness())
            .heatNoAndBatchNo(materialInventory.getHeatNoAndBatchNo())
            .color(materialInventory.getColor())
            .brand(materialInventory.getBrand())
            .quantity(inboundDetail.getQuantity())
            .mete(inboundDetail.getMete())
            .accountingUnit(inboundDetail.getAccountingUnit())
            .boolPartyA(materialInventory.getBoolPartyA())
            .unitNet(materialInventory.getUnitNet())
            .taxRate(materialInventory.getTaxRate())
            .invoiceType(materialInventory.getInvoiceType())
            .standardId(materialInventory.getStandardId())
            .standardName(materialInventory.getStandardName())
            .amount(inboundDetail.getAmount().setScale(this.amountAccuracy, 4))
            .amountExcludingVat(inboundDetail.getAmountExcludingVat().setScale(this.amountAccuracy, 4))
            .amountNoFreight(inboundDetail.getAmountNoFreight().setScale(this.amountAccuracy, 4))
            .amountExcludingVatNoFreight(inboundDetail.getAmountExcludingVatNoFreight().setScale(this.amountAccuracy, 4))
            .build();
         wap.setUnitPrice(inboundDetail.getAmount().divide(wap.getMete(), 12, 4));
         wap.setUnitPriceExcludingVat(inboundDetail.getAmountExcludingVat().divide(wap.getMete(), 12, 4));
         wap.setUnitPriceNoFreight(inboundDetail.getAmountNoFreight().divide(wap.getMete(), 12, 4));
         wap.setUnitPriceExcludingVatNoFreight(inboundDetail.getAmountExcludingVatNoFreight().divide(wap.getMete(), 12, 4));
         this.moveWeightedAveragePriceMapper.insert(wap);
      } else {
         BigDecimal totalAmount = wap.getAmount().add(inboundDetail.getAmount());
         BigDecimal totalAmountExcludingVat = wap.getAmountExcludingVat().add(inboundDetail.getAmountExcludingVat());
         BigDecimal totalAmountNoFreight = wap.getAmountNoFreight().add(inboundDetail.getAmountNoFreight());
         BigDecimal totalAmountExcludingVatNoFreight = wap.getAmountExcludingVatNoFreight().add(inboundDetail.getAmountExcludingVatNoFreight());
         if (inboundDetail.getQuantity() != null) {
            wap.setQuantity(inboundDetail.getQuantity().add(wap.getQuantity()));
         }

         wap.setMete(wap.getMete().add(inboundDetail.getMete()));
         wap.setUnitPrice(totalAmount.divide(wap.getMete(), 12, 4));
         wap.setUnitPriceExcludingVat(totalAmountExcludingVat.divide(wap.getMete(), 12, 4));
         wap.setAmount(totalAmount.setScale(this.amountAccuracy, 4));
         wap.setAmountExcludingVat(totalAmountExcludingVat.setScale(this.amountAccuracy, 4));
         wap.setUnitPriceNoFreight(totalAmountNoFreight.divide(wap.getMete(), 12, 4));
         wap.setUnitPriceExcludingVatNoFreight(totalAmountExcludingVatNoFreight.divide(wap.getMete(), 12, 4));
         wap.setAmountNoFreight(totalAmountNoFreight.setScale(this.amountAccuracy, 4));
         wap.setAmountExcludingVatNoFreight(totalAmountExcludingVatNoFreight.setScale(this.amountAccuracy, 4));
         this.moveWeightedAveragePriceMapper.updateById(wap);
      }

      Statistics statistics = this.statisticsMapper.get(materialInventory);
      if (statistics != null) {
         if (ReceiptTypeEnum.RETURN.getType().equals(receiptType)) {
            if (statistics.getOutboundMete() != null) {
               statistics.setOutboundMete(statistics.getOutboundMete().subtract(inboundDetail.getMete()));
               if (statistics.getOutboundQuantity() != null) {
                  statistics.setOutboundQuantity(statistics.getOutboundQuantity().subtract(inboundDetail.getQuantity()));
               }

               statistics.setOutboundAmount(statistics.getOutboundAmount().subtract(inboundDetail.getAmount()));
               statistics.setOutboundAmountExcludingVat(statistics.getOutboundAmountExcludingVat().subtract(inboundDetail.getAmountExcludingVat()));
               statistics.setOutboundAmountNoFreight(statistics.getOutboundAmountNoFreight().subtract(inboundDetail.getAmountNoFreight()));
               statistics.setOutboundAmountExcludingVatNoFreight(
                  statistics.getOutboundAmountExcludingVatNoFreight().subtract(inboundDetail.getAmountExcludingVatNoFreight())
               );
               if (statistics.getOutboundMete().compareTo(BigDecimal.ZERO) == 0) {
                  statistics.setOutboundUnitPrice(BigDecimal.ZERO);
                  statistics.setOutboundUnitPriceExcludingVat(BigDecimal.ZERO);
                  statistics.setOutboundUnitPriceNoFreight(BigDecimal.ZERO);
                  statistics.setOutboundUnitPriceExcludingVatNoFreight(BigDecimal.ZERO);
               } else {
                  statistics.setOutboundUnitPrice(statistics.getOutboundAmount().divide(statistics.getOutboundMete(), 12, 4));
                  statistics.setOutboundUnitPriceExcludingVat(statistics.getOutboundAmountExcludingVat().divide(statistics.getOutboundMete(), 12, 4));
                  statistics.setOutboundUnitPriceNoFreight(statistics.getOutboundAmountNoFreight().divide(statistics.getOutboundMete(), 12, 4));
                  statistics.setOutboundUnitPriceExcludingVatNoFreight(
                     statistics.getOutboundAmountExcludingVatNoFreight().divide(statistics.getOutboundMete(), 12, 4)
                  );
               }

               this.statisticsMapper.updateById(statistics);
            } else {
               statistics.setOutboundMete(inboundDetail.getMete().negate());
               if (inboundDetail.getQuantity() != null) {
                  statistics.setOutboundQuantity(inboundDetail.getQuantity().negate());
               }

               statistics.setOutboundAmount(inboundDetail.getAmount().negate());
               statistics.setOutboundAmountExcludingVat(inboundDetail.getAmountExcludingVat().negate());
               statistics.setOutboundUnitPrice(wap.getUnitPrice());
               statistics.setOutboundUnitPriceExcludingVat(wap.getUnitPriceExcludingVat());
               statistics.setOutboundAmountNoFreight(inboundDetail.getAmountNoFreight().negate());
               statistics.setOutboundAmountExcludingVatNoFreight(inboundDetail.getAmountExcludingVatNoFreight().negate());
               statistics.setOutboundUnitPriceNoFreight(wap.getUnitPriceNoFreight());
               statistics.setOutboundUnitPriceExcludingVatNoFreight(wap.getUnitPriceExcludingVatNoFreight());
               this.statisticsMapper.updateById(statistics);
            }
         } else {
            if (statistics.getInboundMete() != null) {
               statistics.setInboundMete(inboundDetail.getMete().add(statistics.getInboundMete()));
               if (statistics.getInboundQuantity() != null) {
                  statistics.setInboundQuantity(inboundDetail.getQuantity().add(statistics.getInboundQuantity()));
               }

               statistics.setInboundAmount(statistics.getInboundAmount().add(inboundDetail.getAmount()));
               statistics.setInboundAmountExcludingVat(statistics.getInboundAmountExcludingVat().add(inboundDetail.getAmountExcludingVat()));
               statistics.setInboundAmountNoFreight(statistics.getInboundAmountNoFreight().add(inboundDetail.getAmountNoFreight()));
               statistics.setInboundAmountExcludingVatNoFreight(
                  statistics.getInboundAmountExcludingVatNoFreight().add(inboundDetail.getAmountExcludingVatNoFreight())
               );
            } else {
               statistics.setInboundMete(inboundDetail.getMete());
               if (inboundDetail.getQuantity() != null) {
                  statistics.setInboundQuantity(inboundDetail.getQuantity());
               }

               statistics.setInboundAmount(inboundDetail.getAmount());
               statistics.setInboundAmountExcludingVat(inboundDetail.getAmountExcludingVat());
               statistics.setInboundAmountNoFreight(inboundDetail.getAmountNoFreight());
               statistics.setInboundAmountExcludingVatNoFreight(inboundDetail.getAmountExcludingVatNoFreight());
            }

            if (statistics.getInboundAmount().compareTo(BigDecimal.ZERO) != 0) {
               statistics.setInboundUnitPrice(statistics.getInboundAmount().divide(statistics.getInboundMete(), 12, 4));
               statistics.setInboundUnitPriceExcludingVat(statistics.getInboundAmountExcludingVat().divide(statistics.getInboundMete(), 12, 4));
            }

            if (statistics.getInboundAmountNoFreight().compareTo(BigDecimal.ZERO) != 0) {
               statistics.setInboundUnitPriceNoFreight(statistics.getInboundAmountNoFreight().divide(statistics.getInboundMete(), 12, 4));
               statistics.setInboundUnitPriceExcludingVatNoFreight(
                  statistics.getInboundAmountExcludingVatNoFreight().divide(statistics.getInboundMete(), 12, 4)
               );
            }
         }

         statistics.setEndMete(wap.getMete());
         statistics.setEndQuantity(wap.getQuantity());
         statistics.setEndUnitPrice(wap.getUnitPrice());
         statistics.setEndUnitPriceExcludingVat(wap.getUnitPriceExcludingVat());
         statistics.setEndAmount(wap.getAmount());
         statistics.setEndAmountExcludingVat(wap.getAmountExcludingVat());
         statistics.setEndUnitPriceNoFreight(wap.getUnitPriceNoFreight());
         statistics.setEndUnitPriceExcludingVatNoFreight(wap.getUnitPriceExcludingVatNoFreight());
         statistics.setEndAmountNoFreight(wap.getAmountNoFreight());
         statistics.setEndAmountExcludingVatNoFreight(wap.getAmountExcludingVatNoFreight());
         if (StrUtil.isNotBlank(statistics.getSpecs())) {
            HashSet<String> set = new HashSet<>(Arrays.asList(statistics.getSpecs().split(",")));
            set.add(materialInventory.getSpecification());
            statistics.setSpecs(StrUtil.join(",", set));
         } else if (StrUtil.isNotBlank(materialInventory.getSpecification())) {
            statistics.setSpecs(materialInventory.getSpecification());
         }

         this.statisticsMapper.updateById(statistics);
      } else {
         statistics = Statistics.builder()
            .wapId(wap.getId())
            .basicClass(materialInventory.getBasicClass())
            .classifyId(materialInventory.getClassifyId())
            .projectId(materialInventory.getProjectId())
            .thickness(materialInventory.getThickness())
            .theoryThickness(materialInventory.getTheoryThickness())
            .brand(materialInventory.getBrand())
            .color(materialInventory.getColor())
            .heatNoAndBatchNo(materialInventory.getHeatNoAndBatchNo())
            .unitNet(materialInventory.getUnitNet())
            .invoiceType(materialInventory.getInvoiceType())
            .taxRate(materialInventory.getTaxRate())
            .standardId(materialInventory.getStandardId())
            .standardName(materialInventory.getStandardName())
            .specification(wap.getSpecification())
            .boolPartyA(materialInventory.getBoolPartyA())
            .specs(materialInventory.getSpecification())
            .workshopId(materialInventory.getWorkshopId())
            .build();
         if (!ReceiptTypeEnum.RETURN.getType().equals(receiptType)) {
            statistics.setInboundMete(inboundDetail.getMete());
            statistics.setInboundQuantity(inboundDetail.getQuantity());
            statistics.setInboundUnitPrice(wap.getUnitPrice());
            statistics.setInboundUnitPriceExcludingVat(wap.getUnitPriceExcludingVat());
            statistics.setInboundAmount(statistics.getInboundMete().multiply(statistics.getInboundUnitPrice()).setScale(this.amountAccuracy, 4));
            statistics.setInboundAmountExcludingVat(
               statistics.getInboundMete().multiply(statistics.getInboundUnitPriceExcludingVat()).setScale(this.amountAccuracy, 4)
            );
            statistics.setInboundUnitPriceNoFreight(wap.getUnitPriceNoFreight());
            statistics.setInboundUnitPriceExcludingVatNoFreight(wap.getUnitPriceExcludingVatNoFreight());
            statistics.setInboundAmountNoFreight(
               statistics.getInboundMete().multiply(statistics.getInboundUnitPriceNoFreight()).setScale(this.amountAccuracy, 4)
            );
            statistics.setInboundAmountExcludingVatNoFreight(
               statistics.getInboundMete().multiply(statistics.getInboundUnitPriceExcludingVatNoFreight()).setScale(this.amountAccuracy, 4)
            );
         } else {
            statistics.setOutboundMete(inboundDetail.getMete().negate());
            if (inboundDetail.getQuantity() != null) {
               statistics.setOutboundQuantity(inboundDetail.getQuantity().negate());
            }

            statistics.setOutboundAmount(inboundDetail.getAmount().negate());
            statistics.setOutboundAmountExcludingVat(inboundDetail.getAmountExcludingVat().negate());
            statistics.setOutboundUnitPrice(wap.getUnitPrice());
            statistics.setOutboundUnitPriceExcludingVat(wap.getUnitPriceExcludingVat());
            statistics.setOutboundAmountNoFreight(inboundDetail.getAmountNoFreight().negate());
            statistics.setOutboundAmountExcludingVatNoFreight(inboundDetail.getAmountExcludingVatNoFreight().negate());
            statistics.setOutboundUnitPriceNoFreight(wap.getUnitPriceNoFreight());
            statistics.setOutboundUnitPriceExcludingVatNoFreight(wap.getUnitPriceExcludingVatNoFreight());
            this.statisticsMapper.updateById(statistics);
         }

         statistics.setEndMete(wap.getMete());
         statistics.setEndQuantity(wap.getQuantity());
         statistics.setEndUnitPrice(wap.getUnitPrice());
         statistics.setEndUnitPriceExcludingVat(wap.getUnitPriceExcludingVat());
         statistics.setEndAmount(wap.getAmount());
         statistics.setEndAmountExcludingVat(wap.getAmountExcludingVat());
         statistics.setEndUnitPriceNoFreight(wap.getUnitPriceNoFreight());
         statistics.setEndUnitPriceExcludingVatNoFreight(wap.getUnitPriceExcludingVatNoFreight());
         statistics.setEndAmountNoFreight(wap.getAmountNoFreight());
         statistics.setEndAmountExcludingVatNoFreight(wap.getAmountExcludingVatNoFreight());
         this.statisticsMapper.insert(statistics);
      }

      if (!ReceiptTypeEnum.RETURN.getType().equals(receiptType)) {
         StatisticsInbound statisticsInbound = BeanUtil.copy(materialInventory, StatisticsInbound.class, "createTime");
         statisticsInbound.setReceiptType(receiptType);
         statisticsInbound.setReceiptId(receiptId);
         statisticsInbound.setReceiptSerialNumber(receiptSerialNumber);
         statisticsInbound.setMete(inboundDetail.getMete());
         statisticsInbound.setQuantity(inboundDetail.getQuantity());
         statisticsInbound.setMaterialInventoryId(materialInventory.getId());
         statisticsInbound.setStatisticsId(statistics.getId());
         statisticsInbound.setUnitPrice(inboundDetail.getUnitPrice());
         statisticsInbound.setUnitPriceExcludingVat(inboundDetail.getUnitPriceExcludingVat());
         statisticsInbound.setAmount(inboundDetail.getAmount());
         statisticsInbound.setAmountExcludingVat(inboundDetail.getAmountExcludingVat());
         statisticsInbound.setBoolPartyA(statistics.getBoolPartyA());
         statisticsInbound.setRealTime(inboundDetail.getRealTime() != null ? inboundDetail.getRealTime() : LocalDateTime.now());
         statisticsInbound.setUnitPriceNoFreight(inboundDetail.getUnitPriceNoFreight());
         statisticsInbound.setUnitPriceExcludingVatNoFreight(inboundDetail.getUnitPriceExcludingVatNoFreight());
         statisticsInbound.setAmountNoFreight(inboundDetail.getAmountNoFreight());
         statisticsInbound.setAmountExcludingVatNoFreight(inboundDetail.getAmountExcludingVatNoFreight());
         this.statisticsInboundMapper.insert(statisticsInbound);
      }

      List<StatisticsEndPeriod> statisticsEndPeriods = this.statisticsEndPeriodMapper.getList(statistics.getId());
      BigDecimal amount = wap.getAmount();
      BigDecimal amountExcludingVat = wap.getAmountExcludingVat();
      boolean boolInsert = false;

      for (StatisticsEndPeriod statisticsEndPeriod : statisticsEndPeriods) {
         if (statisticsEndPeriod.getMaterialInventoryId().equals(materialInventory.getId())) {
            statisticsEndPeriod.setMete(inboundDetail.getMete().add(statisticsEndPeriod.getMete()));
            if (statisticsEndPeriod.getQuantity() != null) {
               statisticsEndPeriod.setQuantity(inboundDetail.getQuantity().add(statisticsEndPeriod.getQuantity()));
            }

            boolInsert = true;
         }

         statisticsEndPeriod.setUnitPrice(wap.getUnitPrice());
         statisticsEndPeriod.setUnitPriceExcludingVat(wap.getUnitPriceExcludingVat());
         BigDecimal meteProportion = statisticsEndPeriod.getMete().divide(wap.getMete(), 20, 4);
         BigDecimal endAmount = meteProportion.multiply(wap.getAmount()).setScale(this.amountAccuracy, 4);
         BigDecimal endAmountExcludingVat = meteProportion.multiply(wap.getAmountExcludingVat()).setScale(this.amountAccuracy, 4);
         if (amount.subtract(endAmount).compareTo(BigDecimal.ZERO) > 0) {
            statisticsEndPeriod.setAmount(endAmount);
            amount = amount.subtract(endAmount);
         } else {
            statisticsEndPeriod.setAmount(amount);
         }

         if (amountExcludingVat.subtract(endAmountExcludingVat).compareTo(BigDecimal.ZERO) > 0) {
            statisticsEndPeriod.setAmountExcludingVat(endAmountExcludingVat);
            amountExcludingVat = amountExcludingVat.subtract(endAmountExcludingVat);
         } else {
            statisticsEndPeriod.setAmountExcludingVat(amountExcludingVat);
         }

         this.statisticsEndPeriodMapper.updateById(statisticsEndPeriod);
      }

      if (!boolInsert) {
         StatisticsEndPeriod endPeriod = BeanUtil.copy(materialInventory, StatisticsEndPeriod.class, "createTime");
         endPeriod.setStatisticsId(statistics.getId());
         endPeriod.setMaterialInventoryId(materialInventory.getId());
         endPeriod.setWeightedAveragePriceId(wap.getId());
         endPeriod.setMete(inboundDetail.getMete());
         endPeriod.setQuantity(inboundDetail.getQuantity());
         endPeriod.setUnitPrice(wap.getUnitPrice());
         endPeriod.setUnitPriceExcludingVat(wap.getUnitPriceExcludingVat());
         endPeriod.setAmount(amount);
         endPeriod.setAmountExcludingVat(amountExcludingVat);
         this.statisticsEndPeriodMapper.insert(endPeriod);
      }

      return statistics;
   }

   @Override
   public Statistics createMonthWAP(
      InboundDetail inboundDetail, MaterialInventory materialInventory, Long receiptId, String receiptSerialNumber, Integer receiptType
   ) {
      MonthWeightedAveragePrice wap = this.monthWeightedAveragePriceMapper.getPrice(materialInventory);
      Long wholeWAPId = null;
      WeightedPriceConf weightedPriceConf = JSON.parseObject(
         this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置")).getValue(), WeightedPriceConf.class
      );
      if (WeightedPriceEnum.WHOLE.getType().equals(weightedPriceConf.getWeightedType())) {
         WholeWeightedAveragePrice wholeWAP = this.wholeWAPMapper.getPrice(materialInventory);
         if (wholeWAP != null) {
            if (!ReceiptTypeEnum.TRANSFER.getType().equals(receiptType) && inboundDetail.getAmount() != null) {
               if (inboundDetail.getQuantity() != null) {
                  wholeWAP.setQuantity(wholeWAP.getQuantity() == null ? inboundDetail.getQuantity() : inboundDetail.getQuantity().add(wholeWAP.getQuantity()));
               }

               wholeWAP.setMete(wholeWAP.getMete().add(inboundDetail.getMete()));
               wholeWAP.setAmount(wholeWAP.getAmount().add(inboundDetail.getAmount()).setScale(this.amountAccuracy, RoundingMode.HALF_UP));
               wholeWAP.setAmountExcludingVat(
                  wholeWAP.getAmountExcludingVat().add(inboundDetail.getAmountExcludingVat()).setScale(this.amountAccuracy, RoundingMode.HALF_UP)
               );
               wholeWAP.setAmountNoFreight(
                  wholeWAP.getAmountNoFreight().add(inboundDetail.getAmountNoFreight()).setScale(this.amountAccuracy, RoundingMode.HALF_UP)
               );
               wholeWAP.setAmountExcludingVatNoFreight(
                  wholeWAP.getAmountExcludingVatNoFreight()
                     .add(inboundDetail.getAmountExcludingVatNoFreight())
                     .setScale(this.amountAccuracy, RoundingMode.HALF_UP)
               );
               this.wholeWAPMapper.updateById(wholeWAP);
            }
         } else {
            wholeWAP = WholeWeightedAveragePrice.builder()
               .classifyId(materialInventory.getClassifyId())
               .basicClass(materialInventory.getBasicClass())
               .specification(materialInventory.getWeightedAverageSpec())
               .thickness(materialInventory.getThickness())
               .heatNoAndBatchNo(materialInventory.getHeatNoAndBatchNo())
               .color(materialInventory.getColor())
               .brand(materialInventory.getBrand())
               .accountingUnit(inboundDetail.getAccountingUnit())
               .boolPartyA(materialInventory.getBoolPartyA())
               .unitNet(materialInventory.getUnitNet())
               .taxRate(materialInventory.getTaxRate())
               .invoiceType(materialInventory.getInvoiceType())
               .standardId(materialInventory.getStandardId())
               .standardName(materialInventory.getStandardName())
               .build();
            if (inboundDetail.getAmount() != null) {
               wholeWAP.setQuantity(inboundDetail.getQuantity());
               wholeWAP.setMete(inboundDetail.getMete());
               wholeWAP.setAmount(inboundDetail.getAmount().setScale(this.amountAccuracy, 4));
               wholeWAP.setAmountExcludingVat(inboundDetail.getAmountExcludingVat().setScale(this.amountAccuracy, 4));
            }

            if (inboundDetail.getAmountNoFreight() != null) {
               wholeWAP.setAmountNoFreight(inboundDetail.getAmountNoFreight().setScale(this.amountAccuracy, 4));
               wholeWAP.setAmountExcludingVatNoFreight(inboundDetail.getAmountExcludingVatNoFreight().setScale(this.amountAccuracy, 4));
            }

            this.wholeWAPMapper.insert(wholeWAP);
         }

         wholeWAPId = wholeWAP.getId();
      }

      if (wap == null) {
         wap = MonthWeightedAveragePrice.builder()
            .classifyId(materialInventory.getClassifyId())
            .basicClass(materialInventory.getBasicClass())
            .projectId(inboundDetail.getProjectId())
            .specification(materialInventory.getWeightedAverageSpec())
            .thickness(materialInventory.getThickness())
            .heatNoAndBatchNo(materialInventory.getHeatNoAndBatchNo())
            .color(materialInventory.getColor())
            .brand(materialInventory.getBrand())
            .accountingUnit(inboundDetail.getAccountingUnit())
            .boolPartyA(materialInventory.getBoolPartyA())
            .unitNet(materialInventory.getUnitNet())
            .taxRate(materialInventory.getTaxRate())
            .invoiceType(materialInventory.getInvoiceType())
            .standardId(materialInventory.getStandardId())
            .standardName(materialInventory.getStandardName())
            .wholeWapId(wholeWAPId)
            .build();
         if (inboundDetail.getAmount() != null) {
            wap.setQuantity(inboundDetail.getQuantity());
            wap.setMete(inboundDetail.getMete());
            if (WeightedPriceEnum.SINGLE.getType().equals(weightedPriceConf.getWeightedType())) {
               wap.setAmount(inboundDetail.getAmount().setScale(this.amountAccuracy, 4));
               wap.setAmountExcludingVat(inboundDetail.getAmountExcludingVat().setScale(this.amountAccuracy, 4));
               if (inboundDetail.getAmountNoFreight() != null) {
                  wap.setAmountNoFreight(inboundDetail.getAmountNoFreight().setScale(this.amountAccuracy, 4));
                  wap.setAmountExcludingVatNoFreight(inboundDetail.getAmountExcludingVatNoFreight().setScale(this.amountAccuracy, 4));
               }
            }
         }

         this.monthWeightedAveragePriceMapper.insert(wap);
      } else if (receiptType != ReceiptTypeEnum.MOVE_WAREHOUSE.getType()) {
         if (inboundDetail.getAmount() != null) {
            if (inboundDetail.getQuantity() != null) {
               wap.setQuantity(wap.getQuantity() == null ? inboundDetail.getQuantity() : inboundDetail.getQuantity().add(wap.getQuantity()));
            }

            wap.setMete(wap.getMete().add(inboundDetail.getMete()));
            if (WeightedPriceEnum.SINGLE.getType().equals(weightedPriceConf.getWeightedType())) {
               wap.setAmount(wap.getAmount().add(inboundDetail.getAmount()).setScale(this.amountAccuracy, RoundingMode.HALF_UP));
               wap.setAmountExcludingVat(
                  wap.getAmountExcludingVat().add(inboundDetail.getAmountExcludingVat()).setScale(this.amountAccuracy, RoundingMode.HALF_UP)
               );
               wap.setAmountNoFreight(wap.getAmountNoFreight().add(inboundDetail.getAmountNoFreight()).setScale(this.amountAccuracy, RoundingMode.HALF_UP));
               wap.setAmountExcludingVatNoFreight(
                  wap.getAmountExcludingVatNoFreight().add(inboundDetail.getAmountExcludingVatNoFreight()).setScale(this.amountAccuracy, RoundingMode.HALF_UP)
               );
            }
         }

         this.monthWeightedAveragePriceMapper.updateById(wap);
      }

      Statistics statistics = this.statisticsMapper.get(materialInventory);
      if (statistics != null) {
         if (ReceiptTypeEnum.RETURN.getType().equals(receiptType)) {
            if (statistics.getOutboundMete() != null) {
               statistics.setOutboundMete(statistics.getOutboundMete().subtract(inboundDetail.getMete()));
               if (statistics.getOutboundQuantity() != null) {
                  statistics.setOutboundQuantity(statistics.getOutboundQuantity().subtract(inboundDetail.getQuantity()));
               }

               this.statisticsMapper.updateById(statistics);
            } else {
               statistics.setOutboundMete(inboundDetail.getMete().negate());
               if (inboundDetail.getQuantity() != null) {
                  statistics.setOutboundQuantity(inboundDetail.getQuantity().negate());
               }

               this.statisticsMapper.updateById(statistics);
            }

            if (inboundDetail.getAmount() != null) {
               statistics.setOutboundAmount(
                  statistics.getOutboundAmount() != null
                     ? statistics.getOutboundAmount().subtract(inboundDetail.getAmount())
                     : inboundDetail.getAmount().negate()
               );
               statistics.setOutboundAmountExcludingVat(
                  statistics.getOutboundAmountExcludingVat() != null
                     ? statistics.getOutboundAmountExcludingVat().subtract(inboundDetail.getAmountExcludingVat())
                     : inboundDetail.getAmountExcludingVat().negate()
               );
            }

            if (inboundDetail.getAmountNoFreight() != null) {
               statistics.setOutboundAmountNoFreight(
                  statistics.getOutboundAmountNoFreight() != null
                     ? statistics.getOutboundAmountNoFreight().subtract(inboundDetail.getAmountNoFreight())
                     : inboundDetail.getAmountNoFreight().negate()
               );
               statistics.setOutboundAmountExcludingVatNoFreight(
                  statistics.getOutboundAmountExcludingVatNoFreight() != null
                     ? statistics.getOutboundAmountExcludingVatNoFreight().subtract(inboundDetail.getAmountExcludingVatNoFreight())
                     : inboundDetail.getAmountExcludingVatNoFreight().negate()
               );
            }
         } else if (ReceiptTypeEnum.getInbound().contains(receiptType)) {
            if (statistics.getInboundMete() != null) {
               statistics.setInboundMete(inboundDetail.getMete().add(statistics.getInboundMete()));
               if (inboundDetail.getQuantity() != null) {
                  statistics.setInboundQuantity(
                     statistics.getInboundQuantity() == null ? inboundDetail.getQuantity() : inboundDetail.getQuantity().add(statistics.getInboundQuantity())
                  );
               }

               statistics.setInboundAmount(statistics.getInboundAmount().add(inboundDetail.getAmount()));
               statistics.setInboundAmountExcludingVat(statistics.getInboundAmountExcludingVat().add(inboundDetail.getAmountExcludingVat()));
               if (statistics.getInboundAmountNoFreight() != null) {
                  statistics.setInboundAmountNoFreight(statistics.getInboundAmountNoFreight().add(inboundDetail.getAmountNoFreight()));
                  statistics.setInboundAmountExcludingVatNoFreight(
                     statistics.getInboundAmountExcludingVatNoFreight().add(inboundDetail.getAmountExcludingVatNoFreight())
                  );
               }
            } else {
               statistics.setInboundMete(inboundDetail.getMete());
               if (inboundDetail.getQuantity() != null) {
                  statistics.setInboundQuantity(inboundDetail.getQuantity());
               }

               statistics.setInboundAmount(inboundDetail.getAmount());
               statistics.setInboundAmountExcludingVat(inboundDetail.getAmountExcludingVat());
               statistics.setInboundAmountNoFreight(inboundDetail.getAmountNoFreight());
               statistics.setInboundAmountExcludingVatNoFreight(inboundDetail.getAmountExcludingVatNoFreight());
            }

            if (statistics.getInboundAmount().compareTo(BigDecimal.ZERO) != 0 && statistics.getInboundMete().compareTo(BigDecimal.ZERO) != 0) {
               statistics.setInboundUnitPrice(statistics.getInboundAmount().divide(statistics.getInboundMete(), 12, RoundingMode.HALF_UP));
               statistics.setInboundUnitPriceExcludingVat(
                  statistics.getInboundAmountExcludingVat().divide(statistics.getInboundMete(), 12, RoundingMode.HALF_UP)
               );
            }

            if (statistics.getInboundAmountNoFreight() != null
               && statistics.getInboundAmountNoFreight().compareTo(BigDecimal.ZERO) != 0
               && statistics.getInboundMete().compareTo(BigDecimal.ZERO) != 0) {
               statistics.setInboundUnitPriceNoFreight(statistics.getInboundAmountNoFreight().divide(statistics.getInboundMete(), 12, RoundingMode.HALF_UP));
               statistics.setInboundUnitPriceExcludingVatNoFreight(
                  statistics.getInboundAmountExcludingVatNoFreight().divide(statistics.getInboundMete(), 12, RoundingMode.HALF_UP)
               );
            }
         } else {
            if (statistics.getTransferMete() != null) {
               statistics.setTransferMete(inboundDetail.getMete().add(statistics.getTransferMete()));
               if (inboundDetail.getQuantity() != null) {
                  statistics.setTransferQuantity(
                     statistics.getTransferQuantity() == null ? inboundDetail.getQuantity() : inboundDetail.getQuantity().add(statistics.getTransferQuantity())
                  );
               }

               statistics.setTransferAmount(statistics.getTransferAmount().add(inboundDetail.getAmount()));
               statistics.setTransferAmountExcludingVat(statistics.getTransferAmountExcludingVat().add(inboundDetail.getAmountExcludingVat()));
               if (statistics.getTransferAmountNoFreight() != null) {
                  statistics.setTransferAmountNoFreight(statistics.getTransferAmountNoFreight().add(inboundDetail.getAmountNoFreight()));
                  statistics.setTransferAmountExcludingVatNoFreight(
                     statistics.getTransferAmountExcludingVatNoFreight().add(inboundDetail.getAmountExcludingVatNoFreight())
                  );
               }
            } else {
               statistics.setTransferMete(inboundDetail.getMete());
               if (inboundDetail.getQuantity() != null) {
                  statistics.setTransferQuantity(inboundDetail.getQuantity());
               }

               statistics.setTransferAmount(inboundDetail.getAmount());
               statistics.setTransferAmountExcludingVat(inboundDetail.getAmountExcludingVat());
               statistics.setTransferAmountNoFreight(inboundDetail.getAmountNoFreight());
               statistics.setTransferAmountExcludingVatNoFreight(inboundDetail.getAmountExcludingVatNoFreight());
            }

            if (statistics.getTransferAmount().compareTo(BigDecimal.ZERO) != 0 && statistics.getTransferMete().compareTo(BigDecimal.ZERO) != 0) {
               statistics.setTransferUnitPrice(statistics.getTransferAmount().divide(statistics.getTransferMete(), 12, RoundingMode.HALF_UP));
               statistics.setTransferUnitPriceExcludingVat(
                  statistics.getTransferAmountExcludingVat().divide(statistics.getTransferMete(), 12, RoundingMode.HALF_UP)
               );
            }

            if (statistics.getTransferAmountNoFreight() != null
               && statistics.getTransferAmountNoFreight().compareTo(BigDecimal.ZERO) != 0
               && statistics.getTransferMete().compareTo(BigDecimal.ZERO) != 0) {
               statistics.setTransferUnitPriceNoFreight(statistics.getTransferAmountNoFreight().divide(statistics.getTransferMete(), 12, RoundingMode.HALF_UP));
               statistics.setTransferUnitPriceExcludingVatNoFreight(
                  statistics.getTransferAmountExcludingVatNoFreight().divide(statistics.getTransferMete(), 12, RoundingMode.HALF_UP)
               );
            }
         }

         statistics.setEndMete(statistics.getEndMete().add(inboundDetail.getMete()));
         if (inboundDetail.getQuantity() != null) {
            statistics.setEndQuantity(
               statistics.getEndQuantity() == null ? inboundDetail.getQuantity() : statistics.getEndQuantity().add(inboundDetail.getQuantity())
            );
         }

         if (StrUtil.isNotBlank(statistics.getSpecs())) {
            HashSet<String> set = new HashSet<>(Arrays.asList(statistics.getSpecs().split(",")));
            set.add(materialInventory.getSpecification());
            statistics.setSpecs(StrUtil.join(",", set));
         }

         statistics.setWapId(wap.getId());
         this.statisticsMapper.updateById(statistics);
      } else {
         statistics = Statistics.builder()
            .wapId(wap.getId())
            .basicClass(materialInventory.getBasicClass())
            .classifyId(materialInventory.getClassifyId())
            .projectId(materialInventory.getProjectId())
            .thickness(materialInventory.getThickness())
            .theoryThickness(materialInventory.getTheoryThickness())
            .brand(materialInventory.getBrand())
            .color(materialInventory.getColor())
            .heatNoAndBatchNo(materialInventory.getHeatNoAndBatchNo())
            .unitNet(materialInventory.getUnitNet())
            .invoiceType(materialInventory.getInvoiceType())
            .taxRate(materialInventory.getTaxRate())
            .standardId(materialInventory.getStandardId())
            .standardName(materialInventory.getStandardName())
            .specification(wap.getSpecification())
            .boolPartyA(materialInventory.getBoolPartyA())
            .specs(materialInventory.getSpecification())
            .workshopId(materialInventory.getWorkshopId())
            .build();
         if (ReceiptTypeEnum.RETURN.getType().equals(receiptType)) {
            statistics.setOutboundMete(inboundDetail.getMete().negate());
            if (inboundDetail.getQuantity() != null) {
               statistics.setOutboundQuantity(inboundDetail.getQuantity().negate());
            }

            statistics.setOutboundUnitPrice(inboundDetail.getUnitPrice() != null ? inboundDetail.getUnitPrice().negate() : inboundDetail.getUnitPrice());
            statistics.setOutboundUnitPriceExcludingVat(
               inboundDetail.getUnitPriceExcludingVat() != null ? inboundDetail.getUnitPriceExcludingVat().negate() : inboundDetail.getUnitPriceExcludingVat()
            );
            statistics.setOutboundAmount(inboundDetail.getAmount() != null ? inboundDetail.getAmount().negate() : inboundDetail.getAmount());
            statistics.setOutboundAmountExcludingVat(
               inboundDetail.getAmountExcludingVat() != null ? inboundDetail.getAmountExcludingVat().negate() : inboundDetail.getAmountExcludingVat()
            );
            statistics.setOutboundUnitPriceNoFreight(
               inboundDetail.getUnitPriceNoFreight() != null ? inboundDetail.getUnitPriceNoFreight().negate() : inboundDetail.getUnitPriceNoFreight()
            );
            statistics.setOutboundUnitPriceExcludingVatNoFreight(
               inboundDetail.getUnitPriceExcludingVatNoFreight() != null
                  ? inboundDetail.getUnitPriceExcludingVatNoFreight().negate()
                  : inboundDetail.getUnitPriceExcludingVatNoFreight()
            );
            statistics.setOutboundAmountNoFreight(
               inboundDetail.getAmountNoFreight() != null ? inboundDetail.getAmountNoFreight().negate() : inboundDetail.getAmountNoFreight()
            );
            statistics.setOutboundAmountExcludingVatNoFreight(
               inboundDetail.getAmountExcludingVatNoFreight() != null
                  ? inboundDetail.getAmountExcludingVatNoFreight().negate()
                  : inboundDetail.getAmountExcludingVatNoFreight()
            );
         } else if (ReceiptTypeEnum.getInbound().contains(receiptType)) {
            statistics.setInboundMete(inboundDetail.getMete());
            statistics.setInboundQuantity(inboundDetail.getQuantity());
            statistics.setInboundUnitPrice(inboundDetail.getUnitPrice());
            statistics.setInboundUnitPriceExcludingVat(inboundDetail.getUnitPriceExcludingVat());
            statistics.setInboundAmount(inboundDetail.getAmount());
            statistics.setInboundAmountExcludingVat(inboundDetail.getAmountExcludingVat());
            statistics.setInboundUnitPriceNoFreight(inboundDetail.getUnitPriceNoFreight());
            statistics.setInboundUnitPriceExcludingVatNoFreight(inboundDetail.getUnitPriceExcludingVatNoFreight());
            statistics.setInboundAmountNoFreight(inboundDetail.getAmountNoFreight());
            statistics.setInboundAmountExcludingVatNoFreight(inboundDetail.getAmountExcludingVatNoFreight());
         } else {
            statistics.setTransferMete(inboundDetail.getMete());
            statistics.setTransferQuantity(inboundDetail.getQuantity());
            statistics.setTransferUnitPrice(inboundDetail.getUnitPrice());
            statistics.setTransferUnitPriceExcludingVat(inboundDetail.getUnitPriceExcludingVat());
            statistics.setTransferAmount(inboundDetail.getAmount());
            statistics.setTransferAmountExcludingVat(inboundDetail.getAmountExcludingVat());
            statistics.setTransferUnitPriceNoFreight(inboundDetail.getUnitPriceNoFreight());
            statistics.setTransferUnitPriceExcludingVatNoFreight(inboundDetail.getUnitPriceExcludingVatNoFreight());
            statistics.setTransferAmountNoFreight(inboundDetail.getAmountNoFreight());
            statistics.setTransferAmountExcludingVatNoFreight(inboundDetail.getAmountExcludingVatNoFreight());
         }

         statistics.setEndMete(inboundDetail.getMete());
         statistics.setEndQuantity(inboundDetail.getQuantity());
         this.statisticsMapper.insert(statistics);
      }

      if (!ReceiptTypeEnum.RETURN.getType().equals(receiptType)) {
         StatisticsInbound statisticsInbound = BeanUtil.copy(materialInventory, StatisticsInbound.class, "createTime");
         statisticsInbound.setReceiptType(receiptType != -1 ? receiptType : null);
         statisticsInbound.setReceiptId(receiptId);
         statisticsInbound.setReceiptSerialNumber(receiptSerialNumber);
         statisticsInbound.setMete(inboundDetail.getMete());
         statisticsInbound.setQuantity(inboundDetail.getQuantity());
         statisticsInbound.setMaterialInventoryId(materialInventory.getId());
         statisticsInbound.setStatisticsId(statistics.getId());
         statisticsInbound.setUnitPrice(inboundDetail.getUnitPrice());
         statisticsInbound.setUnitPriceExcludingVat(inboundDetail.getUnitPriceExcludingVat());
         statisticsInbound.setAmount(inboundDetail.getAmount());
         statisticsInbound.setAmountExcludingVat(inboundDetail.getAmountExcludingVat());
         statisticsInbound.setBoolPartyA(statistics.getBoolPartyA());
         statisticsInbound.setUnitPriceNoFreight(inboundDetail.getUnitPriceNoFreight());
         statisticsInbound.setUnitPriceExcludingVatNoFreight(inboundDetail.getUnitPriceExcludingVatNoFreight());
         statisticsInbound.setAmountNoFreight(inboundDetail.getAmountNoFreight());
         statisticsInbound.setAmountExcludingVatNoFreight(inboundDetail.getAmountExcludingVatNoFreight());
         statisticsInbound.setRealTime(inboundDetail.getRealTime() != null ? inboundDetail.getRealTime() : LocalDateTime.now());
         this.statisticsInboundMapper.insert(statisticsInbound);
      }

      if (materialInventory.getId() > 0L) {
         StatisticsEndPeriod statisticsEndPeriod = this.statisticsEndPeriodMapper
            .selectOne(
               (Wrapper<StatisticsEndPeriod>)(Wrappers.<StatisticsEndPeriod>lambdaQuery().eq(StatisticsEndPeriod::getStatisticsId, statistics.getId()))
                  .eq(StatisticsEndPeriod::getMaterialInventoryId, materialInventory.getId())
            );
         if (statisticsEndPeriod != null) {
            statisticsEndPeriod.setMete(inboundDetail.getMete().add(statisticsEndPeriod.getMete()));
            if (inboundDetail.getQuantity() != null) {
               statisticsEndPeriod.setQuantity(
                  statisticsEndPeriod.getQuantity() == null ? inboundDetail.getQuantity() : inboundDetail.getQuantity().add(statisticsEndPeriod.getQuantity())
               );
            }

            this.statisticsEndPeriodMapper.updateById(statisticsEndPeriod);
         } else {
            StatisticsEndPeriod endPeriod = BeanUtil.copy(materialInventory, StatisticsEndPeriod.class, "createTime");
            endPeriod.setStatisticsId(statistics.getId());
            endPeriod.setMaterialInventoryId(materialInventory.getId());
            endPeriod.setWeightedAveragePriceId(wap.getId());
            endPeriod.setMete(inboundDetail.getMete());
            endPeriod.setQuantity(inboundDetail.getQuantity());
            this.statisticsEndPeriodMapper.insert(endPeriod);
         }
      }

      return statistics;
   }

   @Override
   public MonthWeightedAveragePrice getPrice(MaterialInventory materialInventory) {
      return this.monthWeightedAveragePriceMapper.getPrice(materialInventory);
   }

   @Override
   public WholeWeightedAveragePrice getNowWholeWap(WholeWeightedAveragePrice wholeWAP, MonthTimeRange monthTimeRange) {
      List<MonthWeightedAveragePrice> monthWAPs = this.monthWeightedAveragePriceMapper
         .selectList((Wrapper<MonthWeightedAveragePrice>)Wrappers.<MonthWeightedAveragePrice>lambdaQuery().eq(MonthWeightedAveragePrice::getWholeWapId, wholeWAP.getId()));
      new ArrayList();
      List<Long> collect = monthWAPs.stream().map(MonthWeightedAveragePrice::getId).collect(Collectors.toList());
      List<Statistics> statistics = this.statisticsMapper.selectList((Wrapper<Statistics>)new LambdaQueryWrapper<Statistics>().in(Statistics::getWapId, collect));
      List<Long> collect1 = statistics.stream().map(Statistics::getId).collect(Collectors.toList());
      BigDecimal endAmountExcludingVat = wholeWAP.getAmountExcludingVat() != null ? wholeWAP.getAmountExcludingVat() : BigDecimal.ZERO;
      BigDecimal endAmount = wholeWAP.getAmount() != null ? wholeWAP.getAmount() : BigDecimal.ZERO;
      BigDecimal endMete = wholeWAP.getMete() != null ? wholeWAP.getMete() : BigDecimal.ZERO;
      BigDecimal endAmountNoFreight = wholeWAP.getAmountNoFreight() != null ? wholeWAP.getAmountNoFreight() : BigDecimal.ZERO;
      BigDecimal endAmountExcludingVatNoFreight = wholeWAP.getAmountExcludingVatNoFreight() != null
         ? wholeWAP.getAmountExcludingVatNoFreight()
         : BigDecimal.ZERO;
      List<StatisticsInbound> inboundDetailList = this.statisticsInboundMapper
         .selectList(
            (Wrapper<StatisticsInbound>)(new LambdaQueryWrapper<StatisticsInbound>().in(StatisticsInbound::getStatisticsId, collect1))
               .apply(StatisticsInboundMapper.EFFECTIVE_REAL_TIME_SQL + " >= {0}", monthTimeRange.getEndTime())
         );
      List<StatisticsOutbound> moveOutboundDetails = this.statisticsOutboundMapper
         .selectList(
            (Wrapper<StatisticsOutbound>)((((new LambdaQueryWrapper<StatisticsOutbound>()
                           .in(StatisticsOutbound::getStatisticsId, collect1))
                        .isNotNull(StatisticsOutbound::getAmount))
                     .isNotNull(StatisticsOutbound::getAmountExcludingVat))
                  .eq(StatisticsOutbound::getReceiptType, ReceiptTypeEnum.RETURN.getType()))
               .ge(StatisticsOutbound::getOutboundTime, monthTimeRange.getEndTime())
         );
      if (CollectionUtil.isNotEmpty(inboundDetailList)) {
         BigDecimal inboundDetailAmountExcludingVatReduce = inboundDetailList.stream()
            .filter(inboundDetail -> inboundDetail.getAmountExcludingVat() != null)
            .map(StatisticsInbound::getAmountExcludingVat)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal inboundDetailAmountReduce = inboundDetailList.stream()
            .filter(inboundDetail -> inboundDetail.getAmount() != null)
            .map(StatisticsInbound::getAmount)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal inboundDetailMeteReduce = inboundDetailList.stream()
            .filter(inboundDetail -> inboundDetail.getMete() != null)
            .map(StatisticsInbound::getMete)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal inboundDetailAmountReduceNoFreight = inboundDetailList.stream()
            .filter(inboundDetail -> inboundDetail.getAmountNoFreight() != null)
            .map(StatisticsInbound::getAmountNoFreight)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal inboundDetailAmountExcludingVatReduceNoFreight = inboundDetailList.stream()
            .filter(inboundDetail -> inboundDetail.getAmountExcludingVatNoFreight() != null)
            .map(StatisticsInbound::getAmountExcludingVatNoFreight)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         endAmountNoFreight = endAmountNoFreight.subtract(inboundDetailAmountReduceNoFreight);
         endAmountExcludingVatNoFreight = endAmountExcludingVatNoFreight.subtract(inboundDetailAmountExcludingVatReduceNoFreight);
         endAmountExcludingVat = endAmountExcludingVat.subtract(inboundDetailAmountExcludingVatReduce);
         endAmount = endAmount.subtract(inboundDetailAmountReduce);
         endMete = endMete.subtract(inboundDetailMeteReduce);
      }

      if (CollectionUtil.isNotEmpty(moveOutboundDetails)) {
         BigDecimal outboundDetailAmountExcludingVatReduce = moveOutboundDetails.stream()
            .filter(moveOutboundDetail -> moveOutboundDetail.getAmountExcludingVat() != null)
            .map(StatisticsOutbound::getAmountExcludingVat)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal outboundDetailAmountReduce = moveOutboundDetails.stream()
            .filter(moveOutboundDetail -> moveOutboundDetail.getAmount() != null)
            .map(StatisticsOutbound::getAmount)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal outboundDetailMeteReduce = moveOutboundDetails.stream()
            .filter(moveOutboundDetail -> moveOutboundDetail.getMete() != null)
            .map(StatisticsOutbound::getMete)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal outboundDetailAmountReduceNoFreight = moveOutboundDetails.stream()
            .filter(moveOutboundDetail -> moveOutboundDetail.getAmountNoFreight() != null)
            .map(StatisticsOutbound::getAmountNoFreight)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal outboundDetailAmountExcludingVatReduceNoFreight = moveOutboundDetails.stream()
            .filter(moveOutboundDetail -> moveOutboundDetail.getAmountExcludingVatNoFreight() != null)
            .map(StatisticsOutbound::getAmountExcludingVatNoFreight)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         endAmountExcludingVat = endAmountExcludingVat.add(outboundDetailAmountExcludingVatReduce);
         endAmount = endAmount.add(outboundDetailAmountReduce);
         endMete = endMete.add(outboundDetailMeteReduce);
         endAmountNoFreight = endAmountNoFreight.add(outboundDetailAmountReduceNoFreight);
         endAmountExcludingVatNoFreight = endAmountExcludingVatNoFreight.add(outboundDetailAmountExcludingVatReduceNoFreight);
      }

      wholeWAP.setAmount(endAmount);
      wholeWAP.setAmountExcludingVat(endAmountExcludingVat);
      wholeWAP.setAmountNoFreight(endAmountNoFreight);
      wholeWAP.setAmountExcludingVatNoFreight(endAmountExcludingVatNoFreight);
      wholeWAP.setMete(endMete);
      return wholeWAP;
   }

   @Override
   public MonthWeightedAveragePrice getNowMothWap(MonthWeightedAveragePrice monthWAP, MonthTimeRange monthTimeRange) {
      monthWAP.setStartTime(monthTimeRange.getEndTime());
      List<Statistics> statisticsList = this.statisticsMapper
         .selectList((Wrapper<Statistics>)Wrappers.<Statistics>lambdaQuery().eq(Statistics::getWapId, monthWAP.getId()));
      BigDecimal endAmountExcludingVat = monthWAP.getAmountExcludingVat() != null ? monthWAP.getAmountExcludingVat() : BigDecimal.ZERO;
      BigDecimal endAmount = monthWAP.getAmount() != null ? monthWAP.getAmount() : BigDecimal.ZERO;
      BigDecimal endMete = monthWAP.getMete() != null ? monthWAP.getMete() : BigDecimal.ZERO;
      BigDecimal endAmountNoFreight = monthWAP.getAmountNoFreight() != null ? monthWAP.getAmountNoFreight() : BigDecimal.ZERO;
      BigDecimal endAmountExcludingVatNoFreight = monthWAP.getAmountExcludingVatNoFreight() != null
         ? monthWAP.getAmountExcludingVatNoFreight()
         : BigDecimal.ZERO;

      for (Statistics statistics : statisticsList) {
         if (ObjectUtil.isNotEmpty(statistics)) {
            List<StatisticsInbound> inboundDetailList = this.statisticsInboundMapper
               .selectList(
                  (Wrapper<StatisticsInbound>)(new LambdaQueryWrapper<StatisticsInbound>().eq(StatisticsInbound::getStatisticsId, statistics.getId()))
                     .apply(StatisticsInboundMapper.EFFECTIVE_REAL_TIME_SQL + " > {0}", monthTimeRange.getEndTime())
               );
            List<StatisticsOutbound> moveOutboundDetails = this.statisticsOutboundMapper
               .selectList(
                  (Wrapper<StatisticsOutbound>)((((new LambdaQueryWrapper<StatisticsOutbound>()
                                 .eq(StatisticsOutbound::getStatisticsId, statistics.getId()))
                              .isNotNull(StatisticsOutbound::getAmount))
                           .isNotNull(StatisticsOutbound::getAmountExcludingVat))
                        .eq(StatisticsOutbound::getReceiptType, ReceiptTypeEnum.RETURN.getType()))
                     .gt(StatisticsOutbound::getOutboundTime, monthTimeRange.getEndTime())
               );
            if (CollectionUtil.isNotEmpty(inboundDetailList)) {
               BigDecimal inboundDetailAmountExcludingVatReduce = inboundDetailList.stream()
                  .filter(inboundDetail -> inboundDetail.getAmountExcludingVat() != null)
                  .map(StatisticsInbound::getAmountExcludingVat)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal inboundDetailAmountReduce = inboundDetailList.stream()
                  .filter(inboundDetail -> inboundDetail.getAmount() != null)
                  .map(StatisticsInbound::getAmount)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal inboundDetailMeteReduce = inboundDetailList.stream()
                  .filter(inboundDetail -> inboundDetail.getMete() != null)
                  .map(StatisticsInbound::getMete)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal inboundDetailAmountReduceNoFreight = inboundDetailList.stream()
                  .filter(inboundDetail -> inboundDetail.getAmountNoFreight() != null)
                  .map(StatisticsInbound::getAmountNoFreight)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal inboundDetailAmountExcludingVatReduceNoFreight = inboundDetailList.stream()
                  .filter(inboundDetail -> inboundDetail.getAmountExcludingVatNoFreight() != null)
                  .map(StatisticsInbound::getAmountExcludingVatNoFreight)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               endAmountNoFreight = endAmountNoFreight.subtract(inboundDetailAmountReduceNoFreight);
               endAmountExcludingVatNoFreight = endAmountExcludingVatNoFreight.subtract(inboundDetailAmountExcludingVatReduceNoFreight);
               endAmountExcludingVat = endAmountExcludingVat.subtract(inboundDetailAmountExcludingVatReduce);
               endAmount = endAmount.subtract(inboundDetailAmountReduce);
               endMete = endMete.subtract(inboundDetailMeteReduce);
            }

            if (CollectionUtil.isNotEmpty(moveOutboundDetails)) {
               BigDecimal outboundDetailAmountExcludingVatReduce = moveOutboundDetails.stream()
                  .filter(moveOutboundDetail -> moveOutboundDetail.getAmountExcludingVat() != null)
                  .map(StatisticsOutbound::getAmountExcludingVat)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal outboundDetailAmountReduce = moveOutboundDetails.stream()
                  .filter(moveOutboundDetail -> moveOutboundDetail.getAmount() != null)
                  .map(StatisticsOutbound::getAmount)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal outboundDetailMeteReduce = moveOutboundDetails.stream()
                  .filter(moveOutboundDetail -> moveOutboundDetail.getMete() != null)
                  .map(StatisticsOutbound::getMete)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal outboundDetailAmountReduceNoFreight = moveOutboundDetails.stream()
                  .filter(moveOutboundDetail -> moveOutboundDetail.getAmountNoFreight() != null)
                  .map(StatisticsOutbound::getAmountNoFreight)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal outboundDetailAmountExcludingVatReduceNoFreight = moveOutboundDetails.stream()
                  .filter(moveOutboundDetail -> moveOutboundDetail.getAmountExcludingVatNoFreight() != null)
                  .map(StatisticsOutbound::getAmountExcludingVatNoFreight)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               endAmountExcludingVat = endAmountExcludingVat.add(outboundDetailAmountExcludingVatReduce);
               endAmount = endAmount.add(outboundDetailAmountReduce);
               endMete = endMete.add(outboundDetailMeteReduce);
               endAmountNoFreight = endAmountNoFreight.add(outboundDetailAmountReduceNoFreight);
               endAmountExcludingVatNoFreight = endAmountExcludingVatNoFreight.add(outboundDetailAmountExcludingVatReduceNoFreight);
            }
         }
      }

      monthWAP.setAmount(endAmount);
      monthWAP.setAmountExcludingVat(endAmountExcludingVat);
      monthWAP.setAmountNoFreight(endAmountNoFreight);
      monthWAP.setAmountExcludingVatNoFreight(endAmountExcludingVatNoFreight);
      monthWAP.setMete(endMete);
      return monthWAP;
   }
}
