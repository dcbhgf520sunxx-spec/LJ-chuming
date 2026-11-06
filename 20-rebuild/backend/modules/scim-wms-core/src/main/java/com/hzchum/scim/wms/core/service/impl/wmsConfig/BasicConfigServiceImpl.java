package com.hzchum.scim.wms.core.service.impl.wmsConfig;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.common.core.api.enums.OutboundTypeEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.enums.FillWayEnum;
import com.hzchum.scim.wms.core.api.enums.MeasuringWayEnum;
import com.hzchum.scim.wms.core.api.enums.OutboundFailDestinationEnum;
import com.hzchum.scim.wms.core.api.enums.OutboundStatusEnum;
import com.hzchum.scim.wms.core.api.enums.SteelWeightCalculationTypeEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.BasicCheck;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.BasicConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.BasicInbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.BasicOutbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.BasicShowConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.ConvertConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.DeficitConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.InventoryUseConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.MaterialConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.MaterialWarehouseConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.OutboundUpdateConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.PartyABorrowReturnConf;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.PriceAbnormalConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.ReportDownload;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.ReturnConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.SteelInbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.StuffTypeConf;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.TransferConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WasteConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WeightedExecutionPriceConf;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WeightedPriceConf;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Inbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Outbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Transfer;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsDeficit;
import com.hzchum.scim.wms.core.api.pojo.dto.common.IdAndNameConvertDTO;
import com.hzchum.scim.wms.core.api.service.wmsConfig.BasicConfigService;
import com.hzchum.scim.wms.core.mapper.wmsConfig.BasicConfigMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.InboundMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.OutboundMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.TransferMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.WmsDeficitMapper;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BasicConfigServiceImpl extends ServiceImpl<BasicConfigMapper, BasicConfig> implements BasicConfigService {
   @Resource
   BasicConfigMapper basicConfigMapper;
   @Resource
   InboundMapper inboundMapper;
   @Resource
   TransferMapper transferMapper;
   @Resource
   WmsDeficitMapper wmsDeficitMapper;
   @Resource
   OutboundMapper outboundMapper;

   @Override
   public BasicInbound getInboundBasicConf() {
      BasicConfig basicInbound = this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "基础入库配置"));
      if (basicInbound == null) {
         int i = BasicClassEnum.STEEL_PLATE.getType() | BasicClassEnum.GENERAL_MATERIAL.getType() | BasicClassEnum.SECTION_STEEL.getType();
         basicInbound = BasicConfig.builder()
            .name("基础入库配置")
            .value(
               JSON.toJSONString(
                  BasicInbound.builder()
                     .length(i)
                     .width(i)
                     .thickness(i)
                     .mete(i)
                     .quantity(i)
                     .spec(BasicClassEnum.SECTION_STEEL.getType())
                     .steelDiff(BigDecimal.ZERO)
                     .trainsDiff(BigDecimal.ZERO)
                     .steelDiffType(MeasuringWayEnum.NUMERICAL.getType())
                     .trainsDiffType(MeasuringWayEnum.NUMERICAL.getType())
                     .overDiffSubmittable(true)
                     .amountFillWay(FillWayEnum.APPLICATION.getType())
                     .procureMeteDiff(BigDecimal.ZERO)
                     .procureMeteDiffState(true)
                     .saveInboundState(0)
                     .passedInboundState(1)
                     .build()
               )
            )
            .build();
         this.basicConfigMapper.insert(basicInbound);
      }

      return JSON.parseObject(basicInbound.getValue(), BasicInbound.class);
   }

   @Override
   public BasicInbound getInboundBasicConfV2() {
      BasicConfig basicConfig = this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "基础入库配置"));
      int i = BasicClassEnum.getMaterialNum();
      if (basicConfig == null) {
         basicConfig = BasicConfig.builder()
            .name("基础入库配置")
            .value(
               JSON.toJSONString(
                  BasicInbound.builder()
                     .amountFillWay(FillWayEnum.APPLICATION.getType())
                     .saveInboundState(0)
                     .passedInboundState(0)
                     .length(i)
                     .width(i)
                     .thickness(i)
                     .mete(i)
                     .spec(i)
                     .quantity(i)
                     .steelDiffType(MeasuringWayEnum.NUMERICAL.getType())
                     .steelDiff(BigDecimal.ZERO)
                     .trainsDiffType(MeasuringWayEnum.NUMERICAL.getType())
                     .trainsDiff(BigDecimal.ZERO)
                     .overDiffSubmittable(true)
                     .procureMeteDiff(BigDecimal.ZERO)
                     .procureMeteDiffState(true)
                     .boolHaveDetail(true)
                     .money(FillWayEnum.APPLICATION.getType())
                     .weight(FillWayEnum.APPLICATION.getType())
                     .LoadingFee(FillWayEnum.APPLICATION.getType())
                     .invoiceTax(FillWayEnum.APPLICATION.getType())
                     .logisticsUnit(FillWayEnum.APPLICATION.getType())
                     .applyAndProcureMeteDiff(BigDecimal.ZERO)
                     .applyAndProcureMeteDiffState(true)
                     .applyAndProcureDetailMeteRatio(new BigDecimal("100"))
                     .steelWeightCalculationType(SteelWeightCalculationTypeEnum.TOTAL_WEIGHT.getType())
                     .build()
               )
            )
            .build();
         this.basicConfigMapper.insert(basicConfig);
      }

      BasicInbound basicInbound = JSON.parseObject(basicConfig.getValue(), BasicInbound.class);
      if (ObjectUtil.isEmpty(basicInbound)
         || ObjectUtil.isEmpty(basicInbound.getAmountFillWay())
         || ObjectUtil.isEmpty(basicInbound.getSaveInboundState())
         || ObjectUtil.isEmpty(basicInbound.getPassedInboundState())
         || ObjectUtil.isEmpty(basicInbound.getLength())
         || ObjectUtil.isEmpty(basicInbound.getWidth())
         || ObjectUtil.isEmpty(basicInbound.getThickness())
         || ObjectUtil.isEmpty(basicInbound.getMete())
         || ObjectUtil.isEmpty(basicInbound.getSpec())
         || ObjectUtil.isEmpty(basicInbound.getQuantity())
         || ObjectUtil.isEmpty(basicInbound.getSteelDiffType())
         || ObjectUtil.isEmpty(basicInbound.getSteelDiff())
         || ObjectUtil.isEmpty(basicInbound.getTrainsDiffType())
         || ObjectUtil.isEmpty(basicInbound.getTrainsDiff())
         || ObjectUtil.isEmpty(basicInbound.getOverDiffSubmittable())
         || ObjectUtil.isEmpty(basicInbound.getProcureMeteDiff())
         || ObjectUtil.isEmpty(basicInbound.getProcureMeteDiffState())
         || ObjectUtil.isEmpty(basicInbound.getBoolHaveDetail())
         || ObjectUtil.isEmpty(basicInbound.getMoney())
         || ObjectUtil.isEmpty(basicInbound.getWeight())
         || ObjectUtil.isEmpty(basicInbound.getLoadingFee())
         || ObjectUtil.isEmpty(basicInbound.getInvoiceTax())
         || ObjectUtil.isEmpty(basicInbound.getLogisticsUnit())
         || ObjectUtil.isEmpty(basicInbound.getApplyAndProcureMeteDiff())
         || ObjectUtil.isEmpty(basicInbound.getApplyAndProcureMeteDiffState())
         || ObjectUtil.isEmpty(basicInbound.getApplyAndProcureDetailMeteRatio())
         || ObjectUtil.isEmpty(basicInbound.getSteelWeightCalculationType())) {
         basicConfig = BasicConfig.builder()
            .id(basicConfig.getId())
            .name("基础入库配置")
            .value(
               JSON.toJSONString(
                  BasicInbound.builder()
                     .amountFillWay(
                        ObjectUtil.isNotEmpty(basicInbound.getAmountFillWay()) ? basicInbound.getAmountFillWay() : FillWayEnum.APPLICATION.getType()
                     )
                     .saveInboundState(ObjectUtil.isNotEmpty(basicInbound.getSaveInboundState()) ? basicInbound.getSaveInboundState() : 0)
                     .passedInboundState(ObjectUtil.isNotEmpty(basicInbound.getPassedInboundState()) ? basicInbound.getPassedInboundState() : 0)
                     .length(ObjectUtil.isNotEmpty(basicInbound.getLength()) ? basicInbound.getLength() : i)
                     .width(ObjectUtil.isNotEmpty(basicInbound.getWidth()) ? basicInbound.getWidth() : i)
                     .thickness(ObjectUtil.isNotEmpty(basicInbound.getThickness()) ? basicInbound.getThickness() : i)
                     .mete(ObjectUtil.isNotEmpty(basicInbound.getMete()) ? basicInbound.getMete() : i)
                     .spec(ObjectUtil.isNotEmpty(basicInbound.getSpec()) ? basicInbound.getSpec() : i)
                     .quantity(ObjectUtil.isNotEmpty(basicInbound.getQuantity()) ? basicInbound.getQuantity() : i)
                     .steelDiffType(
                        ObjectUtil.isNotEmpty(basicInbound.getSteelDiffType()) ? basicInbound.getSteelDiffType() : MeasuringWayEnum.NUMERICAL.getType()
                     )
                     .steelDiff(ObjectUtil.isNotEmpty(basicInbound.getSteelDiff()) ? basicInbound.getSteelDiff() : BigDecimal.ZERO)
                     .trainsDiffType(
                        ObjectUtil.isNotEmpty(basicInbound.getTrainsDiffType()) ? basicInbound.getTrainsDiffType() : MeasuringWayEnum.NUMERICAL.getType()
                     )
                     .trainsDiff(ObjectUtil.isNotEmpty(basicInbound.getTrainsDiff()) ? basicInbound.getTrainsDiff() : BigDecimal.ZERO)
                     .overDiffSubmittable(ObjectUtil.isNotEmpty(basicInbound.getOverDiffSubmittable()) ? basicInbound.getOverDiffSubmittable() : true)
                     .procureMeteDiff(ObjectUtil.isNotEmpty(basicInbound.getProcureMeteDiff()) ? basicInbound.getProcureMeteDiff() : BigDecimal.ZERO)
                     .procureMeteDiffState(ObjectUtil.isNotEmpty(basicInbound.getProcureMeteDiffState()) ? basicInbound.getProcureMeteDiffState() : true)
                     .boolHaveDetail(ObjectUtil.isNotEmpty(basicInbound.getBoolHaveDetail()) ? basicInbound.getBoolHaveDetail() : true)
                     .money(ObjectUtil.isNotEmpty(basicInbound.getMoney()) ? basicInbound.getMoney() : FillWayEnum.APPLICATION.getType())
                     .weight(ObjectUtil.isNotEmpty(basicInbound.getWeight()) ? basicInbound.getWeight() : FillWayEnum.APPLICATION.getType())
                     .LoadingFee(ObjectUtil.isNotEmpty(basicInbound.getLoadingFee()) ? basicInbound.getLoadingFee() : FillWayEnum.APPLICATION.getType())
                     .invoiceTax(ObjectUtil.isNotEmpty(basicInbound.getInvoiceTax()) ? basicInbound.getInvoiceTax() : FillWayEnum.APPLICATION.getType())
                     .logisticsUnit(
                        ObjectUtil.isNotEmpty(basicInbound.getLogisticsUnit()) ? basicInbound.getLogisticsUnit() : FillWayEnum.APPLICATION.getType()
                     )
                     .applyAndProcureMeteDiff(
                        ObjectUtil.isNotEmpty(basicInbound.getApplyAndProcureMeteDiff()) ? basicInbound.getApplyAndProcureMeteDiff() : BigDecimal.ZERO
                     )
                     .applyAndProcureMeteDiffState(
                        ObjectUtil.isNotEmpty(basicInbound.getApplyAndProcureMeteDiffState()) ? basicInbound.getApplyAndProcureMeteDiffState() : true
                     )
                     .applyAndProcureDetailMeteRatio(
                        ObjectUtil.isNotEmpty(basicInbound.getApplyAndProcureDetailMeteRatio())
                           ? basicInbound.getApplyAndProcureDetailMeteRatio()
                           : new BigDecimal("100")
                     )
                     .steelWeightCalculationType(
                        ObjectUtil.isNotEmpty(basicInbound.getSteelWeightCalculationType())
                           ? basicInbound.getSteelWeightCalculationType()
                           : SteelWeightCalculationTypeEnum.TOTAL_WEIGHT.getType()
                     )
                     .build()
               )
            )
            .build();
         basicConfig.setId(null);
         this.basicConfigMapper.update(basicConfig, (Wrapper<BasicConfig>)new LambdaQueryWrapper<BasicConfig>().eq(BasicConfig::getName, "基础入库配置"));
      }

      return JSON.parseObject(basicConfig.getValue(), BasicInbound.class);
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean setInboundBasicConf(BasicInbound basicInbound) {
      BasicInbound inboundBasicConfV2 = this.getInboundBasicConfV2();
      BasicConfig basicConfig = this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "基础入库配置"));
      List<Inbound> inbounds = this.inboundMapper
         .selectList(
            (Wrapper<Inbound>)(new LambdaQueryWrapper<Inbound>().eq(Inbound::getReviewStatus, ReviewStatusEnum.AUDITING.getType()))
               .eq(Inbound::getBoolPartyA, Boolean.FALSE)
         );
      if (CollectionUtils.isNotEmpty(inbounds)) {
         if (!inboundBasicConfV2.getAmountFillWay().equals(basicInbound.getAmountFillWay())) {
            Preconditions.checkArgument(false, "存在审批中的入库单信息，修改无明细金额显示场景失败");
         }

         if (!inboundBasicConfV2.getSaveInboundState().equals(basicInbound.getSaveInboundState())) {
            Preconditions.checkArgument(false, "存在审批中的入库单信息，修改有明细金额显示场景失败");
         }

         if (!inboundBasicConfV2.getPassedInboundState().equals(basicInbound.getPassedInboundState())) {
            Preconditions.checkArgument(false, "存在审批中的入库单信息，修改有明细金额显示场景失败");
         }

         if (!inboundBasicConfV2.getMoney().equals(basicInbound.getMoney())) {
            Preconditions.checkArgument(false, "存在审批中的入库单信息，修改金额显示场景失败");
         }

         if (!inboundBasicConfV2.getWeight().equals(basicInbound.getWeight())) {
            Preconditions.checkArgument(false, "存在审批中的入库单信息，修改重量显示场景失败");
         }

         if (!inboundBasicConfV2.getLoadingFee().equals(basicInbound.getLoadingFee())) {
            Preconditions.checkArgument(false, "存在审批中的入库单信息，修改装车费显示场景失败");
         }

         if (!inboundBasicConfV2.getInvoiceTax().equals(basicInbound.getInvoiceTax())) {
            Preconditions.checkArgument(false, "存在审批中的入库单信息，修改发票显示场景失败");
         }

         if (!inboundBasicConfV2.getLogisticsUnit().equals(basicInbound.getLogisticsUnit())) {
            Preconditions.checkArgument(false, "存在审批中的入库单信息，修改物流单位显示场景失败");
         }
      }

      String value = JSON.toJSONString(basicInbound);
      basicConfig.setValue(value);
      return this.basicConfigMapper.updateById(basicConfig) == 1;
   }

   @Override
   public BasicInbound getPurchaseSpecBasicConf() {
      BasicConfig basicConfig = this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "采购规格修改配置"));
      int i = BasicClassEnum.getMaterialNum();
      if (basicConfig == null) {
         basicConfig = BasicConfig.builder()
            .name("采购规格修改配置")
            .value(
               JSON.toJSONString(
                  BasicInbound.builder()
                     .amountFillWay(FillWayEnum.APPLICATION.getType())
                     .saveInboundState(0)
                     .passedInboundState(0)
                     .length(i)
                     .width(i)
                     .thickness(i)
                     .mete(i)
                     .spec(i)
                     .quantity(i)
                     .steelDiffType(MeasuringWayEnum.NUMERICAL.getType())
                     .steelDiff(BigDecimal.ZERO)
                     .trainsDiffType(MeasuringWayEnum.NUMERICAL.getType())
                     .trainsDiff(BigDecimal.ZERO)
                     .overDiffSubmittable(true)
                     .procureMeteDiff(BigDecimal.ZERO)
                     .procureMeteDiffState(true)
                     .boolHaveDetail(true)
                     .money(FillWayEnum.APPLICATION.getType())
                     .weight(FillWayEnum.APPLICATION.getType())
                     .LoadingFee(FillWayEnum.APPLICATION.getType())
                     .invoiceTax(FillWayEnum.APPLICATION.getType())
                     .logisticsUnit(FillWayEnum.APPLICATION.getType())
                     .applyAndProcureMeteDiff(BigDecimal.ZERO)
                     .applyAndProcureMeteDiffState(true)
                     .applyAndProcureDetailMeteRatio(new BigDecimal("100"))
                     .settlementInventoryAmount(1)
                     .build()
               )
            )
            .build();
         this.basicConfigMapper.insert(basicConfig);
      }

      BasicInbound basicInbound = JSON.parseObject(basicConfig.getValue(), BasicInbound.class);
      if (ObjectUtil.isEmpty(basicInbound)
         || ObjectUtil.isEmpty(basicInbound.getAmountFillWay())
         || ObjectUtil.isEmpty(basicInbound.getSaveInboundState())
         || ObjectUtil.isEmpty(basicInbound.getPassedInboundState())
         || ObjectUtil.isEmpty(basicInbound.getLength())
         || ObjectUtil.isEmpty(basicInbound.getWidth())
         || ObjectUtil.isEmpty(basicInbound.getThickness())
         || ObjectUtil.isEmpty(basicInbound.getMete())
         || ObjectUtil.isEmpty(basicInbound.getSpec())
         || ObjectUtil.isEmpty(basicInbound.getQuantity())
         || ObjectUtil.isEmpty(basicInbound.getSteelDiffType())
         || ObjectUtil.isEmpty(basicInbound.getSteelDiff())
         || ObjectUtil.isEmpty(basicInbound.getTrainsDiffType())
         || ObjectUtil.isEmpty(basicInbound.getTrainsDiff())
         || ObjectUtil.isEmpty(basicInbound.getOverDiffSubmittable())
         || ObjectUtil.isEmpty(basicInbound.getProcureMeteDiff())
         || ObjectUtil.isEmpty(basicInbound.getProcureMeteDiffState())
         || ObjectUtil.isEmpty(basicInbound.getBoolHaveDetail())
         || ObjectUtil.isEmpty(basicInbound.getMoney())
         || ObjectUtil.isEmpty(basicInbound.getWeight())
         || ObjectUtil.isEmpty(basicInbound.getLoadingFee())
         || ObjectUtil.isEmpty(basicInbound.getInvoiceTax())
         || ObjectUtil.isEmpty(basicInbound.getLogisticsUnit())
         || ObjectUtil.isEmpty(basicInbound.getApplyAndProcureMeteDiff())
         || ObjectUtil.isEmpty(basicInbound.getApplyAndProcureMeteDiffState())
         || ObjectUtil.isEmpty(basicInbound.getApplyAndProcureDetailMeteRatio())
         || ObjectUtil.isEmpty(basicInbound.getSettlementInventoryAmount())) {
         basicConfig = BasicConfig.builder()
            .id(basicConfig.getId())
            .name("采购规格修改配置")
            .value(
               JSON.toJSONString(
                  BasicInbound.builder()
                     .amountFillWay(
                        ObjectUtil.isNotEmpty(basicInbound.getAmountFillWay()) ? basicInbound.getAmountFillWay() : FillWayEnum.APPLICATION.getType()
                     )
                     .saveInboundState(ObjectUtil.isNotEmpty(basicInbound.getSaveInboundState()) ? basicInbound.getSaveInboundState() : 0)
                     .passedInboundState(ObjectUtil.isNotEmpty(basicInbound.getPassedInboundState()) ? basicInbound.getPassedInboundState() : 0)
                     .length(ObjectUtil.isNotEmpty(basicInbound.getLength()) ? basicInbound.getLength() : i)
                     .width(ObjectUtil.isNotEmpty(basicInbound.getWidth()) ? basicInbound.getWidth() : i)
                     .thickness(ObjectUtil.isNotEmpty(basicInbound.getThickness()) ? basicInbound.getThickness() : i)
                     .mete(ObjectUtil.isNotEmpty(basicInbound.getMete()) ? basicInbound.getMete() : i)
                     .spec(ObjectUtil.isNotEmpty(basicInbound.getSpec()) ? basicInbound.getSpec() : i)
                     .quantity(ObjectUtil.isNotEmpty(basicInbound.getQuantity()) ? basicInbound.getQuantity() : i)
                     .steelDiffType(
                        ObjectUtil.isNotEmpty(basicInbound.getSteelDiffType()) ? basicInbound.getSteelDiffType() : MeasuringWayEnum.NUMERICAL.getType()
                     )
                     .steelDiff(ObjectUtil.isNotEmpty(basicInbound.getSteelDiff()) ? basicInbound.getSteelDiff() : BigDecimal.ZERO)
                     .trainsDiffType(
                        ObjectUtil.isNotEmpty(basicInbound.getTrainsDiffType()) ? basicInbound.getTrainsDiffType() : MeasuringWayEnum.NUMERICAL.getType()
                     )
                     .trainsDiff(ObjectUtil.isNotEmpty(basicInbound.getTrainsDiff()) ? basicInbound.getTrainsDiff() : BigDecimal.ZERO)
                     .overDiffSubmittable(ObjectUtil.isNotEmpty(basicInbound.getOverDiffSubmittable()) ? basicInbound.getOverDiffSubmittable() : true)
                     .procureMeteDiff(ObjectUtil.isNotEmpty(basicInbound.getProcureMeteDiff()) ? basicInbound.getProcureMeteDiff() : BigDecimal.ZERO)
                     .procureMeteDiffState(ObjectUtil.isNotEmpty(basicInbound.getProcureMeteDiffState()) ? basicInbound.getProcureMeteDiffState() : true)
                     .boolHaveDetail(ObjectUtil.isNotEmpty(basicInbound.getBoolHaveDetail()) ? basicInbound.getBoolHaveDetail() : true)
                     .money(ObjectUtil.isNotEmpty(basicInbound.getMoney()) ? basicInbound.getMoney() : FillWayEnum.APPLICATION.getType())
                     .weight(ObjectUtil.isNotEmpty(basicInbound.getWeight()) ? basicInbound.getWeight() : FillWayEnum.APPLICATION.getType())
                     .LoadingFee(ObjectUtil.isNotEmpty(basicInbound.getLoadingFee()) ? basicInbound.getLoadingFee() : FillWayEnum.APPLICATION.getType())
                     .invoiceTax(ObjectUtil.isNotEmpty(basicInbound.getInvoiceTax()) ? basicInbound.getInvoiceTax() : FillWayEnum.APPLICATION.getType())
                     .logisticsUnit(
                        ObjectUtil.isNotEmpty(basicInbound.getLogisticsUnit()) ? basicInbound.getLogisticsUnit() : FillWayEnum.APPLICATION.getType()
                     )
                     .applyAndProcureMeteDiff(
                        ObjectUtil.isNotEmpty(basicInbound.getApplyAndProcureMeteDiff()) ? basicInbound.getApplyAndProcureMeteDiff() : BigDecimal.ZERO
                     )
                     .applyAndProcureMeteDiffState(
                        ObjectUtil.isNotEmpty(basicInbound.getApplyAndProcureMeteDiffState()) ? basicInbound.getApplyAndProcureMeteDiffState() : true
                     )
                     .applyAndProcureDetailMeteRatio(
                        ObjectUtil.isNotEmpty(basicInbound.getApplyAndProcureDetailMeteRatio())
                           ? basicInbound.getApplyAndProcureDetailMeteRatio()
                           : new BigDecimal("100")
                     )
                     .settlementInventoryAmount(
                        ObjectUtil.isNotEmpty(basicInbound.getSettlementInventoryAmount()) ? basicInbound.getSettlementInventoryAmount() : 2
                     )
                     .build()
               )
            )
            .build();
         basicConfig.setId(null);
         this.basicConfigMapper.update(basicConfig, (Wrapper<BasicConfig>)new LambdaQueryWrapper<BasicConfig>().eq(BasicConfig::getName, "采购规格修改配置"));
      }

      return JSON.parseObject(basicConfig.getValue(), BasicInbound.class);
   }

   @Override
   public Boolean setPurchaseSpecBasicConf(BasicInbound basicInbound) {
      BasicConfig basicConfig = this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "采购规格修改配置"));
      String value = JSON.toJSONString(basicInbound);
      basicConfig.setValue(value);
      return this.basicConfigMapper.updateById(basicConfig) == 1;
   }

   @Override
   public ReportDownload getReportDownload() {
      BasicConfig basicInbound = this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "报表下载配置"));
      if (basicInbound != null) {
         return JSON.parseObject(basicInbound.getValue(), ReportDownload.class);
      }

      ReportDownload reportDownload = ReportDownload.builder().amountShow(0).amountExcludingTAXShow(0).build();
      String s = JSON.toJSONString(reportDownload);
      BasicConfig basicConfig = BasicConfig.builder().name("报表下载配置").value(s).build();
      this.basicConfigMapper.insert(basicConfig);
      return reportDownload;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean setReportDownload(ReportDownload reportDownload) {
      BasicConfig basicConfig = this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "报表下载配置"));
      basicConfig.setValue(JSON.toJSONString(reportDownload));
      return this.basicConfigMapper.updateById(basicConfig) == 1;
   }

   @Override
   public SteelInbound getInboundSteelConf() {
      BasicConfig basicConfig = this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "钢材入库配置"));
      if (basicConfig == null) {
         int i = BasicClassEnum.STEEL_PLATE.getType() | BasicClassEnum.GENERAL_MATERIAL.getType() | BasicClassEnum.SECTION_STEEL.getType();
         basicConfig = BasicConfig.builder()
            .name("钢材入库配置")
            .value(
               JSON.toJSONString(
                  SteelInbound.builder()
                     .steelDiffType(MeasuringWayEnum.ACCOUNTING.getType())
                     .steelDiff(BigDecimal.ZERO)
                     .trainsDiffType(MeasuringWayEnum.ACCOUNTING.getType())
                     .trainsDiff(BigDecimal.ZERO)
                     .overDiffSubmittable(Boolean.FALSE)
                     .build()
               )
            )
            .build();
         this.basicConfigMapper.insert(basicConfig);
      }

      SteelInbound steelInbound = JSON.parseObject(basicConfig.getValue(), SteelInbound.class);
      if (ObjectUtil.isEmpty(steelInbound)
         || ObjectUtil.isEmpty(steelInbound.getSteelDiffType())
         || ObjectUtil.isEmpty(steelInbound.getSteelDiff())
         || ObjectUtil.isEmpty(steelInbound.getTrainsDiffType())
         || ObjectUtil.isEmpty(steelInbound.getTrainsDiff())
         || ObjectUtil.isEmpty(steelInbound.getOverDiffSubmittable())) {
         basicConfig = BasicConfig.builder()
            .id(basicConfig.getId())
            .name("钢材入库配置")
            .value(
               JSON.toJSONString(
                  SteelInbound.builder()
                     .steelDiffType(
                        ObjectUtil.isNotEmpty(steelInbound.getSteelDiffType()) ? steelInbound.getSteelDiffType() : MeasuringWayEnum.ACCOUNTING.getType()
                     )
                     .steelDiff(ObjectUtil.isNotEmpty(steelInbound.getSteelDiff()) ? steelInbound.getSteelDiff() : BigDecimal.ZERO)
                     .trainsDiffType(
                        ObjectUtil.isNotEmpty(steelInbound.getTrainsDiffType()) ? steelInbound.getTrainsDiffType() : MeasuringWayEnum.ACCOUNTING.getType()
                     )
                     .trainsDiff(ObjectUtil.isNotEmpty(steelInbound.getTrainsDiff()) ? steelInbound.getTrainsDiff() : BigDecimal.ZERO)
                     .overDiffSubmittable(ObjectUtil.isNotEmpty(steelInbound.getOverDiffSubmittable()) ? steelInbound.getOverDiffSubmittable() : Boolean.FALSE)
                     .build()
               )
            )
            .build();
         basicConfig.setId(null);
         this.basicConfigMapper.update(basicConfig, (Wrapper<BasicConfig>)new LambdaQueryWrapper<BasicConfig>().eq(BasicConfig::getName, "钢材入库配置"));
      }

      return steelInbound;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean setInboundSteelConf(SteelInbound steelInbound) {
      BasicConfig basicConfig = this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "钢材入库配置"));
      String value = JSON.toJSONString(steelInbound);
      basicConfig.setValue(value);
      return this.basicConfigMapper.updateById(basicConfig) == 1;
   }

   @Override
   public BasicOutbound getOutboundBasicConf() {
      BasicConfig basicConfig = this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "基础出库配置"));
      if (ObjectUtil.isEmpty(basicConfig)) {
         basicConfig = BasicConfig.builder()
            .name("基础出库配置")
            .value(
               JSON.toJSONString(
                  BasicOutbound.builder()
                     .boolAuxMatToWorkShopWay(Boolean.FALSE)
                     .boolCanOutToOtherProject(Boolean.FALSE)
                     .boolGasOutAfterInbound(Boolean.FALSE)
                     .productionOutBoundShop(Boolean.FALSE)
                     .productionOutBoundUser(Boolean.FALSE)
                     .workOutBoundUser(Boolean.FALSE)
                     .outboundType(OutboundTypeEnum.PRODUCTION_USE.getType())
                     .productionOutBoundUserIsRequired(Boolean.FALSE)
                     .cancelDestination(OutboundFailDestinationEnum.returnMaterials.getType())
                     .returnedDestination(OutboundFailDestinationEnum.returnMaterials.getType())
                     .showHalfOut(Boolean.TRUE)
               )
            )
            .build();
         this.basicConfigMapper.insert(basicConfig);
      }

      BasicOutbound basicOutbound = JSON.parseObject(basicConfig.getValue(), BasicOutbound.class);
      if (ObjectUtil.isEmpty(basicOutbound.getBoolAuxMatToWorkShopWay())
         || ObjectUtil.isEmpty(basicOutbound.getBoolGasOutAfterInbound())
         || ObjectUtil.isEmpty(basicOutbound.getBoolCanOutToOtherProject())
         || ObjectUtil.isEmpty(basicOutbound.getProductionOutBoundShop())
         || ObjectUtil.isEmpty(basicOutbound.getProductionOutBoundUser())
         || ObjectUtil.isEmpty(basicOutbound.getWorkOutBoundUser())
         || ObjectUtil.isEmpty(basicOutbound.getOutboundType())
         || ObjectUtil.isEmpty(basicOutbound.getProductionOutBoundUserIsRequired())
         || ObjectUtil.isEmpty(basicOutbound.getCancelDestination())
         || ObjectUtil.isEmpty(basicOutbound.getReturnedDestination())
         || ObjectUtil.isEmpty(basicOutbound.getShowHalfOut())) {
         basicConfig = BasicConfig.builder()
            .name("基础出库配置")
            .value(
               JSON.toJSONString(
                  BasicOutbound.builder()
                     .boolAuxMatToWorkShopWay(
                        ObjectUtil.isNotEmpty(basicOutbound.getBoolAuxMatToWorkShopWay()) ? basicOutbound.getBoolAuxMatToWorkShopWay() : Boolean.FALSE
                     )
                     .boolCanOutToOtherProject(
                        ObjectUtil.isNotEmpty(basicOutbound.getBoolCanOutToOtherProject()) ? basicOutbound.getBoolCanOutToOtherProject() : Boolean.FALSE
                     )
                     .boolGasOutAfterInbound(
                        ObjectUtil.isNotEmpty(basicOutbound.getBoolGasOutAfterInbound()) ? basicOutbound.getBoolGasOutAfterInbound() : Boolean.FALSE
                     )
                     .productionOutBoundShop(
                        ObjectUtil.isNotEmpty(basicOutbound.getProductionOutBoundShop()) ? basicOutbound.getProductionOutBoundShop() : Boolean.FALSE
                     )
                     .productionOutBoundUser(
                        ObjectUtil.isNotEmpty(basicOutbound.getProductionOutBoundUser()) ? basicOutbound.getProductionOutBoundUser() : Boolean.FALSE
                     )
                     .workOutBoundUser(ObjectUtil.isNotEmpty(basicOutbound.getWorkOutBoundUser()) ? basicOutbound.getWorkOutBoundUser() : Boolean.FALSE)
                     .outboundType(
                        ObjectUtil.isNotEmpty(basicOutbound.getOutboundType()) ? basicOutbound.getOutboundType() : OutboundTypeEnum.PRODUCTION_USE.getType()
                     )
                     .productionOutBoundUserIsRequired(
                        ObjectUtil.isNotEmpty(basicOutbound.getProductionOutBoundUserIsRequired()) ? basicOutbound.getWorkOutBoundUser() : Boolean.FALSE
                     )
                     .cancelDestination(
                        ObjectUtil.isNotEmpty(basicOutbound.getCancelDestination())
                           ? basicOutbound.getCancelDestination()
                           : OutboundFailDestinationEnum.returnMaterials.getType()
                     )
                     .returnedDestination(
                        ObjectUtil.isNotEmpty(basicOutbound.getReturnedDestination())
                           ? basicOutbound.getReturnedDestination()
                           : OutboundFailDestinationEnum.returnMaterials.getType()
                     )
                     .showHalfOut(ObjectUtil.isNotEmpty(basicOutbound.getShowHalfOut()) ? basicOutbound.getShowHalfOut() : Boolean.TRUE)
                     .build()
               )
            )
            .build();
         basicConfig.setId(null);
         this.basicConfigMapper.update(basicConfig, (Wrapper<BasicConfig>)new LambdaQueryWrapper<BasicConfig>().eq(BasicConfig::getName, "基础出库配置"));
      }

      return JSON.parseObject(basicConfig.getValue(), BasicOutbound.class);
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean setOutboundBasicConf(BasicOutbound basicOutbound) {
      BasicConfig basicConfig = this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "基础出库配置"));
      if (CollectionUtils.isNotEmpty(basicOutbound.getOutboundTypes())) {
         for (Integer outboundType : basicOutbound.getOutboundTypes()) {
            List<Outbound> outbounds = this.outboundMapper
               .selectList(
                  (Wrapper<Outbound>)(new LambdaQueryWrapper<Outbound>().eq(Outbound::getOutboundTypeSelection, outboundType))
                     .and(
                        o -> {
                           LambdaQueryWrapper var10000 = ((o.eq(
                                    Outbound::getReviewStatus, ReviewStatusEnum.AUDITING.getType()
                                 ))
                                 .or())
                              .eq(Outbound::getReviewStatus, ReviewStatusEnum.NOT_SUBMITTED.getType());
                        }
                     )
               );
            Preconditions.checkArgument(CollectionUtils.isEmpty(outbounds), OutboundTypeEnum.getNameByType(outboundType) + "类型出库单存在未提交或未审核结束的单据，请先审核！");
         }
      }

      String value = JSON.toJSONString(basicOutbound);
      basicConfig.setValue(value);
      return this.basicConfigMapper.updateById(basicConfig) == 1;
   }

   @Override
   public Map<String, Object> getAllConfig() {
      HashMap<String, Object> reMap = new HashMap<>();
      HashMap<String, Object> map = new HashMap<>();
      reMap.put("report", this.getReportDownload());
      map.put("steel", this.getInboundSteelConf());
      map.put("fillWay", this.getInboundBasicConfV2());
      reMap.put("inbound", map);
      reMap.put("purchaseSpec", this.getPurchaseSpecBasicConf());
      reMap.put("outbound", this.getOutboundBasicConf());
      reMap.put("partyABorrowReturn", this.getPartyABorrowReturnConf());
      reMap.put("weightedPrice", this.getWeightedPriceConf());
      reMap.put("deficit", this.getInventoryConfig());
      reMap.put("return", this.getReturnConf());
      reMap.put("basicCheck", this.getCheckBasicConf());
      reMap.put("basicShow", this.getBasicShowConfig());
      reMap.put("convert", this.getConvertConfig());
      reMap.put("outboundUpdate", this.getOutboundUpdateConfig());
      reMap.put("priceAbnormal", this.getPriceAbnormalConfig());
      return reMap;
   }

   @Override
   public WasteConfig getSteelScrapDefinitionConf() {
      BasicConfig basicConfig = this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "废料定义配置"));
      if (ObjectUtil.isEmpty(basicConfig)) {
         basicConfig = BasicConfig.builder()
            .name("废料定义配置")
            .value(
               JSON.toJSONString(
                  WasteConfig.builder()
                     .steelPlateShortestSideMinLength(BigDecimal.ZERO)
                     .sectionSteelMinLength(BigDecimal.ZERO)
                     .steelCoilMinLength(BigDecimal.ZERO)
               )
            )
            .build();
         this.basicConfigMapper.insert(basicConfig);
      }

      WasteConfig wasteConfig = JSON.parseObject(basicConfig.getValue(), WasteConfig.class);
      if (ObjectUtil.isEmpty(wasteConfig.getSteelPlateShortestSideMinLength())
         || ObjectUtil.isEmpty(wasteConfig.getSectionSteelMinLength())
         || ObjectUtil.isEmpty(wasteConfig.getSteelCoilMinLength())) {
         basicConfig = BasicConfig.builder()
            .name("废料定义配置")
            .value(
               JSON.toJSONString(
                  WasteConfig.builder()
                     .steelPlateShortestSideMinLength(
                        ObjectUtil.isNotEmpty(wasteConfig.getSteelPlateShortestSideMinLength())
                           ? wasteConfig.getSteelPlateShortestSideMinLength()
                           : BigDecimal.ZERO
                     )
                     .sectionSteelMinLength(
                        ObjectUtil.isNotEmpty(wasteConfig.getSectionSteelMinLength()) ? wasteConfig.getSectionSteelMinLength() : BigDecimal.ZERO
                     )
                     .steelCoilMinLength(ObjectUtil.isNotEmpty(wasteConfig.getSteelCoilMinLength()) ? wasteConfig.getSteelCoilMinLength() : BigDecimal.ZERO)
                     .build()
               )
            )
            .build();
         basicConfig.setId(null);
         this.basicConfigMapper.update(basicConfig, (Wrapper<BasicConfig>)new LambdaQueryWrapper<BasicConfig>().eq(BasicConfig::getName, "废料定义配置"));
      }

      return JSON.parseObject(basicConfig.getValue(), WasteConfig.class);
   }

   @Override
   public Boolean setSteelScrapDefinitionConf(WasteConfig wasteConfig) {
      Preconditions.checkArgument(wasteConfig.getSteelCoilMinLength() != null, "请配置钢卷长度");
      Preconditions.checkArgument(wasteConfig.getSteelPlateShortestSideMinLength() != null, "请配置钢板最短边长度");
      Preconditions.checkArgument(wasteConfig.getSectionSteelMinLength() != null, "请配置型材长度");
      BasicConfig basicConfig = this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "废料定义配置"));
      String value = JSON.toJSONString(wasteConfig);
      basicConfig.setValue(value);
      return this.basicConfigMapper.updateById(basicConfig) == 1;
   }

   @Override
   public PartyABorrowReturnConf getPartyABorrowReturnConf() {
      BasicConfig basicConfig = this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "甲供材料归还基础配置"));
      if (ObjectUtil.isEmpty(basicConfig)) {
         basicConfig = BasicConfig.builder()
            .name("甲供材料归还基础配置")
            .value(
               JSON.toJSONString(
                  PartyABorrowReturnConf.builder()
                     .boolReturnByOtherProject(Boolean.FALSE)
                     .steelPlateSideLengthDiff(BigDecimal.ZERO)
                     .sectionSteelLengthDiff(BigDecimal.ZERO)
               )
            )
            .build();
         this.basicConfigMapper.insert(basicConfig);
      }

      PartyABorrowReturnConf partyABorrowReturnConf = JSON.parseObject(basicConfig.getValue(), PartyABorrowReturnConf.class);
      if (ObjectUtil.isEmpty(partyABorrowReturnConf.getBoolReturnByOtherProject())
         || ObjectUtil.isEmpty(partyABorrowReturnConf.getSteelPlateSideLengthDiff())
         || ObjectUtil.isEmpty(partyABorrowReturnConf.getSectionSteelLengthDiff())) {
         basicConfig = BasicConfig.builder()
            .name("甲供材料归还基础配置")
            .value(
               JSON.toJSONString(
                  PartyABorrowReturnConf.builder()
                     .boolReturnByOtherProject(
                        ObjectUtil.isNotEmpty(partyABorrowReturnConf.getBoolReturnByOtherProject())
                           ? partyABorrowReturnConf.getBoolReturnByOtherProject()
                           : Boolean.FALSE
                     )
                     .steelPlateSideLengthDiff(
                        ObjectUtil.isNotEmpty(partyABorrowReturnConf.getSteelPlateSideLengthDiff())
                           ? partyABorrowReturnConf.getSteelPlateSideLengthDiff()
                           : BigDecimal.ZERO
                     )
                     .sectionSteelLengthDiff(
                        ObjectUtil.isNotEmpty(partyABorrowReturnConf.getSectionSteelLengthDiff())
                           ? partyABorrowReturnConf.getSectionSteelLengthDiff()
                           : BigDecimal.ZERO
                     )
                     .build()
               )
            )
            .build();
         basicConfig.setId(null);
         this.basicConfigMapper.update(basicConfig, (Wrapper<BasicConfig>)new LambdaQueryWrapper<BasicConfig>().eq(BasicConfig::getName, "甲供材料归还基础配置"));
      }

      return JSON.parseObject(basicConfig.getValue(), PartyABorrowReturnConf.class);
   }

   @Override
   public Boolean setPartyABorrowReturnConf(PartyABorrowReturnConf partyABorrowReturnConf) {
      BasicConfig basicConfig = this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "甲供材料归还基础配置"));
      String value = JSON.toJSONString(partyABorrowReturnConf);
      basicConfig.setValue(value);
      return this.basicConfigMapper.updateById(basicConfig) == 1;
   }

   @Override
   public WeightedPriceConf getWeightedPriceConf() {
      BasicConfig basicConfig = this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置"));
      if (basicConfig == null) {
         WeightedPriceConf build = WeightedPriceConf.builder().weightedType(1).boolUpdate(false).build();
         this.basicConfigMapper.insert(BasicConfig.builder().name("加权模式配置").value(JSON.toJSONString(build)).build());
         return build;
      } else {
         return JSON.parseObject(basicConfig.getValue(), WeightedPriceConf.class);
      }
   }

   @Override
   public Boolean setWeightedPriceConf(WeightedPriceConf conf) {
      BasicConfig basicConfig = this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置"));
      WeightedPriceConf weightedPriceConf = JSON.parseObject(basicConfig.getValue(), WeightedPriceConf.class);
      Integer integer = this.inboundMapper
         .selectCount((Wrapper<Inbound>)Wrappers.<Inbound>lambdaQuery().eq(Inbound::getReviewStatus, ReviewStatusEnum.REVIEWED.getType()));
      if (integer > 0) {
         weightedPriceConf.setBoolUpdate(!conf.getWeightedType().equals(weightedPriceConf.getWeightedType()));
         if (!weightedPriceConf.getBoolUpdate()) {
            weightedPriceConf.setWeightedType(conf.getWeightedType());
         }
      } else {
         weightedPriceConf.setWeightedType(conf.getWeightedType());
      }

      String value = JSON.toJSONString(weightedPriceConf);
      basicConfig.setValue(value);
      return this.basicConfigMapper.updateById(basicConfig) == 1;
   }

   @Override
   public ReturnConfig getReturnConf() {
      BasicConfig basicConfig = this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "退库配置"));
      if (basicConfig == null) {
         ReturnConfig build = ReturnConfig.builder().returnType(1).returnDestination(1).build();
         this.basicConfigMapper.insert(BasicConfig.builder().name("退库配置").value(JSON.toJSONString(build)).build());
         return build;
      }

      ReturnConfig returnConfig = JSON.parseObject(basicConfig.getValue(), ReturnConfig.class);
      if (ObjectUtil.isEmpty(returnConfig.getReturnType()) || ObjectUtil.isEmpty(returnConfig.getReturnDestination())) {
         basicConfig = BasicConfig.builder()
            .name("退库配置")
            .value(
               JSON.toJSONString(
                  ReturnConfig.builder()
                     .returnType(ObjectUtil.isNotEmpty(returnConfig.getReturnType()) ? returnConfig.getReturnType() : 1)
                     .returnDestination(ObjectUtil.isNotEmpty(returnConfig.getReturnDestination()) ? returnConfig.getReturnDestination() : 1)
                     .build()
               )
            )
            .build();
         basicConfig.setId(null);
         this.basicConfigMapper.update(basicConfig, (Wrapper<BasicConfig>)new LambdaQueryWrapper<BasicConfig>().eq(BasicConfig::getName, "退库配置"));
      }

      return JSON.parseObject(basicConfig.getValue(), ReturnConfig.class);
   }

   @Override
   public Boolean setReturnConf(ReturnConfig conf) {
      BasicConfig basicConfig = this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "退库配置"));
      String value = JSON.toJSONString(conf);
      basicConfig.setValue(value);
      return this.basicConfigMapper.updateById(basicConfig) == 1;
   }

   @Override
   public TransferConfig getTransferConfig() {
      BasicConfig basicConfig = this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "调拨配置"));
      if (basicConfig == null) {
         TransferConfig build = TransferConfig.builder().transferType(1).build();
         this.basicConfigMapper.insert(BasicConfig.builder().name("调拨配置").value(JSON.toJSONString(build)).build());
         return build;
      } else {
         return JSON.parseObject(basicConfig.getValue(), TransferConfig.class);
      }
   }

   @Override
   public Boolean setTransferConfig(TransferConfig conf) {
      BasicConfig basicConfig = this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "调拨配置"));
      Integer integer = this.transferMapper
         .selectCount((Wrapper<Transfer>)new LambdaQueryWrapper<Transfer>().eq(Transfer::getReviewStatus, ReviewStatusEnum.UN_REVIEWED.getType()));
      Preconditions.checkArgument(integer == 0, "存在未审核的调拨单，请先审核！");
      String value = JSON.toJSONString(conf);
      basicConfig.setValue(value);
      return this.basicConfigMapper.updateById(basicConfig) == 1;
   }

   @Override
   public StuffTypeConf getStuffTypeConf() {
      BasicConfig basicConfig = this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "物料仓配置"));
      if (basicConfig == null) {
         StuffTypeConf build = StuffTypeConf.builder().build();
         this.basicConfigMapper.insert(BasicConfig.builder().name("物料仓配置").value(JSON.toJSONString(build)).build());
         return build;
      } else {
         return JSON.parseObject(basicConfig.getValue(), StuffTypeConf.class);
      }
   }

   @Override
   public Boolean setStuffTypeConf(StuffTypeConf conf) {
      BasicConfig basicConfig = this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "物料仓配置"));
      String value = JSON.toJSONString(conf);
      basicConfig.setValue(value);
      return this.basicConfigMapper.updateById(basicConfig) == 1;
   }

   @Override
   public BasicCheck getCheckBasicConf() {
      BasicConfig basicConfig = this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "基础审核配置"));
      if (basicConfig == null) {
         BasicCheck build = BasicCheck.builder().build();
         this.basicConfigMapper.insert(BasicConfig.builder().name("基础审核配置").value(JSON.toJSONString(build)).build());
         return build;
      } else {
         return JSON.parseObject(basicConfig.getValue(), BasicCheck.class);
      }
   }

   @Override
   public Boolean setCheckBasicConf(BasicCheck conf) {
      BasicConfig basicConfig = this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "基础审核配置"));
      String value = JSON.toJSONString(conf);
      basicConfig.setValue(value);
      return this.basicConfigMapper.updateById(basicConfig) == 1;
   }

   @Override
   public DeficitConfig getInventoryConfig() {
      BasicConfig basicConfig = this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "盘亏配置"));
      if (basicConfig == null) {
         DeficitConfig build = DeficitConfig.builder().inventoryType(1).build();
         this.basicConfigMapper.insert(BasicConfig.builder().name("盘亏配置").value(JSON.toJSONString(build)).build());
         return build;
      } else {
         return JSON.parseObject(basicConfig.getValue(), DeficitConfig.class);
      }
   }

   @Override
   public Boolean setInventoryConfig(DeficitConfig conf) {
      BasicConfig basicConfig = this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "盘亏配置"));
      Integer integer = this.wmsDeficitMapper
         .selectCount((Wrapper<WmsDeficit>)new LambdaQueryWrapper<WmsDeficit>().eq(WmsDeficit::getReviewStatus, ReviewStatusEnum.UN_REVIEWED.getType()));
      Preconditions.checkArgument(integer == 0, "存在未审核的盘亏单，请先审核！");
      String value = JSON.toJSONString(conf);
      basicConfig.setValue(value);
      return this.basicConfigMapper.updateById(basicConfig) == 1;
   }

   @Override
   public MaterialConfig getInventoryTypeConfig() {
      BasicConfig basicConfig = this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "物料获取配置"));
      if (basicConfig == null) {
         MaterialConfig build = MaterialConfig.builder().inventoryGainType(1).build();
         this.basicConfigMapper.insert(BasicConfig.builder().name("物料获取配置").value(JSON.toJSONString(build)).build());
         return build;
      } else {
         return JSON.parseObject(basicConfig.getValue(), MaterialConfig.class);
      }
   }

   @Override
   public Boolean setInventoryTypeConfig(MaterialConfig conf) {
      BasicConfig basicConfig = this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "物料获取配置"));
      String value = JSON.toJSONString(conf);
      basicConfig.setValue(value);
      MaterialConfig materialConfig = JSON.parseObject(value, MaterialConfig.class);
      List<Outbound> outbounds = this.outboundMapper
         .selectList(
            (Wrapper<Outbound>)((new LambdaQueryWrapper<Outbound>().isNotNull(Outbound::getStockCutGuid))
                  .isNotNull(Outbound::getStockGuid))
               .eq(Outbound::getReviewStatus, OutboundStatusEnum.UN_REVIEWED.getType())
         );
      if (materialConfig.getInventoryGainType().equals(2) && CollectionUtils.isNotEmpty(outbounds)) {
         Preconditions.checkArgument(false, "存在未报工完成的套料出库单，请上报完成之后再切换本地物料模式！");
      }

      return this.basicConfigMapper.updateById(basicConfig) == 1;
   }

   @Override
   public MaterialWarehouseConfig getMaterialWarehouseConfig() {
      BasicConfig basicConfig = this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "物料仓分类配置"));
      if (basicConfig == null) {
         MaterialWarehouseConfig build = MaterialWarehouseConfig.builder().materialWarehouseType(1).build();
         this.basicConfigMapper.insert(BasicConfig.builder().name("物料仓分类配置").value(JSON.toJSONString(build)).build());
         return build;
      } else {
         return JSON.parseObject(basicConfig.getValue(), MaterialWarehouseConfig.class);
      }
   }

   @Override
   public Boolean setMaterialWarehouseConfig(MaterialWarehouseConfig conf) {
      BasicConfig basicConfig = this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "物料仓分类配置"));
      String value = JSON.toJSONString(conf);
      basicConfig.setValue(value);
      return this.basicConfigMapper.updateById(basicConfig) == 1;
   }

   @Override
   public BasicShowConfig getBasicShowConfig() {
      BasicConfig basicConfig = this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "基础显示配置"));
      if (basicConfig == null) {
         BasicShowConfig build = BasicShowConfig.builder().steelsSpeShowConfig(1).build();
         this.basicConfigMapper.insert(BasicConfig.builder().name("基础显示配置").value(JSON.toJSONString(build)).build());
         return build;
      } else {
         return JSON.parseObject(basicConfig.getValue(), BasicShowConfig.class);
      }
   }

   @Override
   public Boolean setBasicShowConfig(BasicShowConfig config) {
      BasicConfig basicConfig = this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "基础显示配置"));
      String value = JSON.toJSONString(config);
      basicConfig.setValue(value);
      return this.basicConfigMapper.updateById(basicConfig) == 1;
   }

   @Override
   public InventoryUseConfig getInventoryBasicConf() {
      BasicConfig basicConfig = this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "库存使用配置"));
      if (basicConfig == null) {
         InventoryUseConfig build = InventoryUseConfig.builder().boolEndMonth(true).build();
         this.basicConfigMapper.insert(BasicConfig.builder().name("库存使用配置").value(JSON.toJSONString(build)).build());
         return build;
      }

      InventoryUseConfig inventoryUseConfig = JSON.parseObject(basicConfig.getValue(), InventoryUseConfig.class);
      if (ObjectUtil.isEmpty(inventoryUseConfig.getBoolEndMonth())
         || ObjectUtil.isEmpty(inventoryUseConfig.getBrand())
         || ObjectUtil.isEmpty(inventoryUseConfig.getProjectId())
         || ObjectUtil.isEmpty(inventoryUseConfig.getWorkshopId())
         || ObjectUtil.isEmpty(inventoryUseConfig.getWarehouseId())
         || ObjectUtil.isEmpty(inventoryUseConfig.getColor())
         || ObjectUtil.isEmpty(inventoryUseConfig.getHeatNoAndBatchNo())) {
         basicConfig = BasicConfig.builder()
            .name("库存使用配置")
            .value(
               JSON.toJSONString(
                  InventoryUseConfig.builder()
                     .boolEndMonth(ObjectUtil.isNotEmpty(inventoryUseConfig.getBoolEndMonth()) ? inventoryUseConfig.getBoolEndMonth() : true)
                     .brand(ObjectUtil.isNotEmpty(inventoryUseConfig.getBrand()) ? inventoryUseConfig.getBrand() : true)
                     .projectId(ObjectUtil.isNotEmpty(inventoryUseConfig.getProjectId()) ? inventoryUseConfig.getProjectId() : true)
                     .workshopId(ObjectUtil.isNotEmpty(inventoryUseConfig.getWorkshopId()) ? inventoryUseConfig.getWorkshopId() : true)
                     .warehouseId(ObjectUtil.isNotEmpty(inventoryUseConfig.getWarehouseId()) ? inventoryUseConfig.getWarehouseId() : true)
                     .color(ObjectUtil.isNotEmpty(inventoryUseConfig.getColor()) ? inventoryUseConfig.getColor() : true)
                     .heatNoAndBatchNo(ObjectUtil.isNotEmpty(inventoryUseConfig.getHeatNoAndBatchNo()) ? inventoryUseConfig.getHeatNoAndBatchNo() : true)
                     .build()
               )
            )
            .build();
         basicConfig.setId(null);
         this.basicConfigMapper.update(basicConfig, (Wrapper<BasicConfig>)new LambdaQueryWrapper<BasicConfig>().eq(BasicConfig::getName, "库存使用配置"));
      }

      return JSON.parseObject(basicConfig.getValue(), InventoryUseConfig.class);
   }

   @Override
   public Boolean setInventoryBasicConf(InventoryUseConfig conf) {
      Preconditions.checkArgument(Boolean.TRUE.equals(conf.getWorkshopId()) || !Boolean.TRUE.equals(conf.getWarehouseId()), "仓库合并时存储位置必须合并");
      BasicConfig basicConfig = this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "库存使用配置"));
      String value = JSON.toJSONString(conf);
      basicConfig.setValue(value);
      return this.basicConfigMapper.updateById(basicConfig) == 1;
   }

   @Override
   public List<ConvertConfig> getConvertConfig() {
      BasicConfig basicConfig = this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "条板转换配置"));
      if (basicConfig == null) {
         this.basicConfigMapper.insert(BasicConfig.builder().name("条板转换配置").value("").build());
         return new ArrayList<>();
      } else {
         return JSON.parseArray(basicConfig.getValue(), ConvertConfig.class);
      }
   }

   @Override
   public Boolean setConvertConfig(List<ConvertConfig> list) {
      BasicConfig basicConfig = this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "条板转换配置"));
      Map<Long, List<IdAndNameConvertDTO>> colorRollMap = list.stream()
         .flatMap(convertConfig -> convertConfig.getClassifyColorRollIds().stream())
         .collect(Collectors.groupingBy(IdAndNameConvertDTO::getId));
      colorRollMap.forEach(
         (id, idAndNameConvertDTOS) -> Preconditions.checkArgument(idAndNameConvertDTOS.size() == 1, idAndNameConvertDTOS.get(0).getName() + "重复添加")
      );
      Map<Long, List<IdAndNameConvertDTO>> collect = list.stream()
         .map(ConvertConfig::getClassifySteelPlateId)
         .collect(Collectors.groupingBy(IdAndNameConvertDTO::getId));
      collect.forEach(
         (id, idAndNameConvertDTOS) -> Preconditions.checkArgument(idAndNameConvertDTOS.size() == 1, idAndNameConvertDTOS.get(0).getName() + "重复添加")
      );
      String jsonString = JSONArray.toJSONString(list);
      basicConfig.setValue(jsonString);
      return this.basicConfigMapper.updateById(basicConfig) == 1;
   }

   @Override
   public OutboundUpdateConfig getOutboundUpdateConfig() {
      BasicConfig basicConfig = this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "出库清单可修改字段配置"));
      if (basicConfig == null) {
         OutboundUpdateConfig build = OutboundUpdateConfig.builder().quantity(false).project(false).mesWorkshop(false).recipient(false).build();
         this.basicConfigMapper.insert(BasicConfig.builder().name("出库清单可修改字段配置").value(JSON.toJSONString(build)).build());
         return build;
      } else {
         return JSON.parseObject(basicConfig.getValue(), OutboundUpdateConfig.class);
      }
   }

   @Override
   public Boolean setOutboundUpdateConfig(OutboundUpdateConfig conf) {
      BasicConfig basicConfig = this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "出库清单可修改字段配置"));
      String value = JSON.toJSONString(conf);
      basicConfig.setValue(value);
      return this.basicConfigMapper.updateById(basicConfig) == 1;
   }

   @Override
   public List<PriceAbnormalConfig> getPriceAbnormalConfig() {
      BasicConfig basicConfig = this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "单价异常提醒配置"));
      if (basicConfig == null) {
         this.basicConfigMapper.insert(BasicConfig.builder().name("单价异常提醒配置").value("").build());
         return new ArrayList<>();
      } else {
         return JSON.parseArray(basicConfig.getValue(), PriceAbnormalConfig.class);
      }
   }

   @Override
   public Boolean setPriceAbnormalConfig(List<PriceAbnormalConfig> list) {
      BasicConfig basicConfig = this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "单价异常提醒配置"));
      List<Integer> basicClassList = list.stream().map(PriceAbnormalConfig::getBasicClass).collect(Collectors.toList());
      if (basicClassList.size() != basicClassList.stream().distinct().count()) {
         Preconditions.checkArgument(false, "基础分类重复添加");
      }

      String jsonString = JSONArray.toJSONString(list);
      basicConfig.setValue(jsonString);
      return this.basicConfigMapper.updateById(basicConfig) == 1;
   }

   @Override
   public WeightedExecutionPriceConf getWeightedExecutionTypeConfig() {
      BasicConfig basicConfig = this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权执行方式配置"));
      if (basicConfig == null) {
         WeightedExecutionPriceConf build = WeightedExecutionPriceConf.builder().weightedExecutionType(1).build();
         this.basicConfigMapper.insert(BasicConfig.builder().name("加权执行方式配置").value(JSON.toJSONString(build)).build());
         return build;
      } else {
         return JSON.parseObject(basicConfig.getValue(), WeightedExecutionPriceConf.class);
      }
   }

   @Override
   public Boolean setWeightedExecutionTypeConfig(WeightedExecutionPriceConf conf) {
      BasicConfig basicConfig = this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权执行方式配置"));
      String value = JSON.toJSONString(conf);
      basicConfig.setValue(value);
      return this.basicConfigMapper.updateById(basicConfig) == 1;
   }
}
