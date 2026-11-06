package com.hzchum.scim.wms.core.service.impl.wmsReport;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.enums.AggregateTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.MonthTimeRange;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.BriefClassDTO;
import com.hzchum.scim.common.core.api.pojo.vo.StatisticsPageVO;
import com.hzchum.scim.common.core.api.utils.DateTimeUtil;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._dto.lossWorkProgressStatistics.WastageCostSummaryValueDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.util.IdAndNameDTO;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import com.hzchum.scim.scm.core.api.pojo.dto.ProjectInfoDTO;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import com.hzchum.scim.system.core.api.common.enums.NumberTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.pojo._do.Department;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.system.core.api.service.DepartmentService;
import com.hzchum.scim.system.core.api.service.NumberConfigService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.wms.core.api.biz.MaterialScheduleBiz;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.enums.InvoiceTypeEnum;
import com.hzchum.scim.wms.core.api.enums.MaterialIsWholeEnum;
import com.hzchum.scim.wms.core.api.enums.ReceiptTypeEnum;
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
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.InboundDetailDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.InventoryDetailsRecord;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.MoveMaterialMaterialDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MoveMaterialDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.OutboundDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.OutboundDetailDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.RejectDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.RejectDetailDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.ReturnDetailDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.Statistics;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsBeginPeriod;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsEndPeriod;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsInbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsMonthRecord;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsOutbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.TransferDetailDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.WmsClosingTime;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.WmsForSaleStatisticsDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.AccumulativeTotal;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.AccumulativeTotalRecord;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.DownLoadDetailDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Inbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialReturnable;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MonthSummaryDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MonthWeightedAveragePrice;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MoveOutboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Outbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Reject;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.RejectDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.ReturnDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Supplement;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WholeWeightedAveragePrice;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsForSale;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsForSaleDetail;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndSNDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.CutSurplusDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.DetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.IdAndMete;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.InventoryDetailsRecordDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.PSIRecordDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.RDFeeDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.ReceiveDateDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.ReceiveOutboundDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.ReceiveReturnDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.ReportInboundDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.ReportOutboundDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.StatisticsDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.StatisticsDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.WmsClosingTimeDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ClassCostDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ClassifyCostDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ConstructionInboundDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.DateCostDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.InboundDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.InboundDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialInventoryAmountDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialInventoryDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialInventorySimpleDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MonthInventoryCostDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.OutboundDetailSellDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.RejectDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.RejectMaterialDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ReturnDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.WmsDateMeteDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.MonthTimeRangeDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryDetailDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryReceiveDateDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryRejectDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryRejectDetailDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryReportInboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryReportOutboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryStatisticsDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryOutboundDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.BasicConfigService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.ClassificationService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.MeasureService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WarehouseService;
import com.hzchum.scim.wms.core.api.service.wmsReport.InventoryDetailsRecordService;
import com.hzchum.scim.wms.core.api.service.wmsReport.ReportService;
import com.hzchum.scim.wms.core.api.service.wmsReport.WmsClosingTimeService;
import com.hzchum.scim.wms.core.api.service.wmsUse.AccumulativeTotalRecordService;
import com.hzchum.scim.wms.core.api.service.wmsUse.AccumulativeTotalService;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundService;
import com.hzchum.scim.wms.core.api.service.wmsUse.RejectService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsForSaleDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsForSaleService;
import com.hzchum.scim.wms.core.api.utils.CommonUtil;
import com.hzchum.scim.wms.core.api.utils.QueryUtilService;
import com.hzchum.scim.wms.core.mapper.wmsConfig.MeasureMapper;
import com.hzchum.scim.wms.core.mapper.wmsConfig.UnitMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.CutSurplusRecordMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.InventoryDetailsRecordMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsBeginPeriodMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsEndPeriodMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsInboundMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsMonthRecordMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsOutboundMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.WasteSaleMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.WmsForSaleDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.InboundDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.InboundMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MaterialInventoryMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MaterialReturnableMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MonthWeightedAveragePriceMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MoveMaterialDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MoveOutboundDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.OutboundMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.RejectDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.RejectMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.ReturnDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.SupplementMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.TransferDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.WholeWeightedAveragePriceMapper;
import com.hzchum.scim.wms.core.utils.QueryUtilImpl;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReportServiceImpl implements ReportService {
   @Resource
   InboundService inboundService;
   @Resource
   InboundDetailMapper inboundDetailMapper;
   @Resource
   ContractProjectService projectService;
   @Resource
   SupplierService supplierService;
   @Resource
   ClassificationService classificationService;
   @Resource
   RejectMapper rejectMapper;
   @Resource
   RejectService rejectService;
   @Resource
   RejectDetailMapper rejectDetailMapper;
   @Resource
   WarehouseService warehouseService;
   @Resource
   MesBuildingWorkshopService workshopService;
   @Resource
   MoveOutboundDetailMapper outboundDetailMapper;
   @Resource
   TransferDetailMapper transferDetailMapper;
   @Resource
   ReturnDetailMapper returnDetailMapper;
   @Resource
   InboundMapper inboundMapper;
   @Resource
   StatisticsMapper statisticsMapper;
   @Resource
   StatisticsInboundMapper statisticsInboundMapper;
   @Resource
   StatisticsOutboundMapper statisticsOutboundMapper;
   @Resource
   StatisticsBeginPeriodMapper statisticsBeginPeriodMapper;
   @Resource
   StatisticsEndPeriodMapper statisticsEndPeriodMapper;
   @Resource
   StatisticsMonthRecordMapper statisticsMonthRecordMapper;
   @Resource
   private InventoryDetailsRecordService inventoryDetailsRecordService;
   @Resource
   MaterialInventoryMapper materialInventoryMapper;
   @Resource
   MeasureService measureService;
   @Resource
   CutSurplusRecordMapper cutSurplusRecordMapper;
   @Resource
   MonthWeightedAveragePriceMapper monthWAPMapper;
   @Resource
   MaterialReturnableMapper materialReturnableMapper;
   @Resource
   InventoryDetailsRecordMapper inventoryDetailsRecordMapper;
   @Resource
   BasicConfigService basicConfigService;
   @Resource
   WholeWeightedAveragePriceMapper wholeWAPMapper;
   @Resource
   SupplementMapper supplementMapper;
   @Resource
   NumberConfigService numberConfigService;
   @Resource
   TechArtifactService artifactService;
   @Resource
   UserService userService;
   @Resource
   DepartmentService departmentService;
   @Resource
   WmsClosingTimeService wmsClosingTimeService;
   @Resource
   MaterialScheduleBiz materialScheduleBiz;
   @Resource
   QueryUtilService QueryUtilService;
   @Value("${wms.amount-accuracy}")
   private Integer amountAccuracy;
   @Resource
   WmsForSaleDetailService wmsForSaleDetailService;
   @Resource
   BranchCompanyService branchCompanyService;
   @Resource
   WmsForSaleService wmsForSaleService;
   @Resource
   AccumulativeTotalService accumulativeTotalService;
   @Resource
   AccumulativeTotalRecordService accumulativeTotalRecordService;
   @Resource
   OutboundMapper outboundMapper;
   @Resource
   QueryUtilImpl queryUtil;
   @Resource
   MesBuildingWorkshopService mesWorkshopService;
   @Resource
   UnitMapper unitMapper;
   @Resource
   MeasureMapper measureMapper;
   @Resource
   WasteSaleMapper wasteSaleMapper;
   @Resource
   MoveMaterialDetailMapper moveMaterialDetailMapper;

   @Override
   public PageVO<ReportInboundDTO> getInbound(QueryReportInboundDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort) {
      String s = StringUtils.analyzeSortConditions(sort);
      Page<Inbound> page = PageHelper.startPage(pageNumber, pageSize, "wi." + s);
      List<ReportInboundDTO> list = this.inboundMapper
         .list(param)
         .stream()
         .map(
            inbound -> {
               ReportInboundDTO dto = BeanUtil.copy(inbound, ReportInboundDTO.class);
               BigDecimal amount = this.rejectMapper.getAmount(inbound.getId());
               dto.setRejectAmountExcludingVAT(amount != null ? amount : BigDecimal.ZERO);
               BigDecimal amountNoFreight = this.rejectMapper.getAmountNoFreight(inbound.getId());
               dto.setRejectAmountExcludingVATNoFreight(amountNoFreight != null ? amountNoFreight : BigDecimal.ZERO);
               if (StrUtil.isNotBlank(inbound.getProjectIds())) {
                  dto.setProjects(
                     this.projectService
                        .listByIds(inbound.getProjectIds())
                        .stream()
                        .map(pro -> BeanUtil.copy(pro, ProjectInfoDTO.class))
                        .collect(Collectors.toList())
                  );
               }

               dto.setInboundAmountExcludingVAT(inbound.getAmountExcludingVat());
               dto.setInboundAmountExcludingVATNoFreight(inbound.getAmountExcludingVatNoFreight());
               dto.setInboundTime(inbound.getReviewTime());
               dto.setBoolPartyA(inbound.getBoolPartyA());
               if (inbound.getSupplierId() != null) {
                  Supplier supplier = this.supplierService.getById(inbound.getSupplierId());
                  dto.setSupplier(BriefIdAndNameDTO.builder().id(supplier.getId()).name(supplier.getName()).build());
               }

               if (inbound.getMesWorkshopId() != null) {
                  MesBuildingWorkshop mesWorkshop = this.mesWorkshopService.getWorkshopById(inbound.getMesWorkshopId());
                  dto.setMesWorkshop(IdAndNameDTO.builder().id(mesWorkshop.getId()).name(mesWorkshop.getName()).build());
               }

               dto.setPurchaseOrder(BriefIdAndSNDTO.builder().id(inbound.getPurchaseId()).serialNumber(inbound.getPurchaseSn()).build());
               return dto;
            }
         )
         .collect(Collectors.toList());
      return new PageVO<>(page, list);
   }

   @Override
   public PageVO<ReportOutboundDTO> getOutbound(QueryReportOutboundDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort) {
      String s = StringUtils.analyzeSortConditions(sort);
      Page<Outbound> page = PageHelper.startPage(pageNumber, pageSize, StrUtil.isNotBlank(s) ? "wo." + s : null);
      List<Outbound> outboundList = this.outboundMapper.list(param);
      List<ReportOutboundDTO> list = this.convertReportOutboundDTOList(outboundList);
      return new PageVO<>(page, list);
   }

   private List<ReportOutboundDTO> convertReportOutboundDTOList(List<Outbound> outboundList) {
      if (CollectionUtil.isEmpty(outboundList)) {
         return new ArrayList<>();
      }

      List<Long> outboundIds = outboundList.stream().map(Outbound::getId).collect(Collectors.toList());
      Map<Long, List<OutboundDetailDO>> outboundDetailMap = this.outboundDetailMapper
         .getListById(outboundIds)
         .stream()
         .collect(Collectors.groupingBy(OutboundDetailDO::getOutboundId));
      WeightedPriceConf weightedPriceConf = JSON.parseObject(
         this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置")).getValue(), WeightedPriceConf.class
      );
      return outboundList.stream()
         .map(
            outbound -> {
               ReportOutboundDTO dto = BeanUtil.copy(outbound, ReportOutboundDTO.class);
               if (StrUtil.isNotBlank(outbound.getRecipients())) {
                  dto.setRecipientsList(Arrays.asList(outbound.getRecipients().split(",")));
               }

               if (StrUtil.isNotBlank(outbound.getProjectIds())) {
                  dto.setProjects(this.projectService.listByIds(outbound.getProjectIds()));
               }

               List<OutboundDetailDO> outboundDetailDOS = outboundDetailMap.get(outbound.getId());
               List<String> areaBatchNames = outboundDetailDOS.stream()
                  .map(OutboundDetailDO::getAreaBatchName)
                  .filter(CharSequenceUtil::isNotBlank)
                  .distinct()
                  .collect(Collectors.toList());
               dto.setAreaBatchNames(areaBatchNames);
               List<Boolean> boolPartyAs = outboundDetailDOS.stream().map(OutboundDetailDO::getBoolPartyA).distinct().collect(Collectors.toList());
               if (boolPartyAs.size() == 1) {
                  dto.setOrderSupplyType(Boolean.TRUE.equals(boolPartyAs.get(0)) ? 2 : 1);
               }

               if (boolPartyAs.size() == 2) {
                  dto.setOrderSupplyType(3);
               }

               Map<Long, MonthWeightedAveragePrice> monthWeightedAveragePriceMap = new HashMap<>();
               List<Long> wapIds = outboundDetailDOS.stream()
                  .map(OutboundDetailDO::getWapId)
                  .filter(ObjectUtil::isNotEmpty)
                  .distinct()
                  .collect(Collectors.toList());
               List<MonthWeightedAveragePrice> monthWeightedAveragePriceList = new ArrayList<>();
               if (CollectionUtil.isNotEmpty(wapIds)) {
                  monthWeightedAveragePriceList = this.monthWAPMapper.selectBatchIds(wapIds);
                  monthWeightedAveragePriceMap = monthWeightedAveragePriceList.stream()
                     .collect(Collectors.toMap(MonthWeightedAveragePrice::getId, Function.identity()));
               }

               Map<Long, WholeWeightedAveragePrice> wholeWeightedAveragePriceMap = new HashMap<>();
               if (CollectionUtil.isNotEmpty(monthWeightedAveragePriceList)) {
                  List<Long> wholeWapId = monthWeightedAveragePriceList.stream()
                     .map(MonthWeightedAveragePrice::getWholeWapId)
                     .filter(ObjectUtil::isNotEmpty)
                     .collect(Collectors.toList());
                  if (CollectionUtil.isNotEmpty(wholeWapId)) {
                     wholeWeightedAveragePriceMap = this.wholeWAPMapper
                        .selectBatchIds(wholeWapId)
                        .stream()
                        .collect(Collectors.toMap(WholeWeightedAveragePrice::getId, Function.identity()));
                  }
               }

               BigDecimal sumAmount = BigDecimal.ZERO;
               BigDecimal sumAmountExcludingVAT = BigDecimal.ZERO;
               BigDecimal sumInputVAT = BigDecimal.ZERO;

               for (OutboundDetailDO outboundDetailDO : outboundDetailDOS) {
                  if (BasicClassEnum.COLOR_ROLL.getType().equals(outboundDetailDO.getBasicClass()) && outboundDetailDO.getLength() != null) {
                     outboundDetailDO.setMeasureUnit("张");
                     outboundDetailDO.setMeasurePrecision(0);
                  }

                  if (outboundDetailDO.getAmount() == null && outboundDetailDO.getAmountExcludingVAT() == null) {
                     MonthWeightedAveragePrice price = monthWeightedAveragePriceMap.get(outboundDetailDO.getWapId());
                     if (price != null) {
                        if (WeightedPriceEnum.WHOLE.getType().equals(weightedPriceConf.getWeightedType())) {
                           WholeWeightedAveragePrice wholeWeightedAveragePrice = wholeWeightedAveragePriceMap.get(price.getWholeWapId());
                           price.setMete(wholeWeightedAveragePrice.getMete());
                           price.setAmount(wholeWeightedAveragePrice.getAmount());
                           price.setAmountExcludingVat(wholeWeightedAveragePrice.getAmountExcludingVat());
                        }

                        outboundDetailDO.setAmount(BigDecimal.ZERO);
                        outboundDetailDO.setAmountExcludingVAT(BigDecimal.ZERO);
                        outboundDetailDO.setUnitPrice(BigDecimal.ZERO);
                        outboundDetailDO.setUnitPriceExcludingVAT(BigDecimal.ZERO);
                        outboundDetailDO.setInputVAT(BigDecimal.ZERO);
                        if (price.getMete().compareTo(BigDecimal.ZERO) != 0) {
                           BigDecimal p = outboundDetailDO.getMete().divide(price.getMete(), 20, RoundingMode.HALF_UP);
                           BigDecimal amount = price.getAmount().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
                           BigDecimal amountExcludingVat = price.getAmountExcludingVat().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
                           if (outboundDetailDO.getMete().compareTo(BigDecimal.ZERO) != 0) {
                              BigDecimal avgPrice = NumberUtil.div(amount, outboundDetailDO.getMete(), 12);
                              BigDecimal excludingVatAvgPrice = NumberUtil.div(amountExcludingVat, outboundDetailDO.getMete(), 12);
                              outboundDetailDO.setUnitPrice(avgPrice);
                              outboundDetailDO.setUnitPriceExcludingVAT(excludingVatAvgPrice);
                           }

                           outboundDetailDO.setAmount(amount);
                           outboundDetailDO.setAmountExcludingVAT(amountExcludingVat);
                           outboundDetailDO.setInputVAT(amount.subtract(amountExcludingVat));
                        }
                     }
                  }

                  if (outboundDetailDO.getAmount() != null) {
                     sumAmount = sumAmount.add(outboundDetailDO.getAmount());
                  }

                  if (outboundDetailDO.getAmountExcludingVAT() != null) {
                     sumAmountExcludingVAT = sumAmountExcludingVAT.add(outboundDetailDO.getAmountExcludingVAT());
                  }

                  if (outboundDetailDO.getInputVAT() != null) {
                     sumInputVAT = sumInputVAT.add(outboundDetailDO.getInputVAT());
                  }
               }

               dto.setAmount(sumAmount);
               dto.setAmountExcludingVAT(sumAmountExcludingVAT);
               dto.setInputVAT(sumInputVAT);
               return dto;
            }
         )
         .collect(Collectors.toList());
   }

   @Override
   public InboundDTO getInboundDetailById(Long id) {
      return this.inboundService.getList(id, true, false);
   }

   @Override
   public PageVO<InboundDetailDTO> getInboundDetails(QueryReportInboundDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort) {
      param.setClassifyIds(this.QueryUtilService.getLateClassificationList(param.getClassifyId()));
      String s = StringUtils.analyzeSortConditions(sort);
      Page<InboundDetailDO> page = PageHelper.startPage(pageNumber, pageSize, s);
      List<InboundDetailDO> inboundDetailDOS = this.inboundDetailMapper.getReceiptInboundDetail(param);
      if (CollectionUtil.isEmpty(inboundDetailDOS)) {
         return new PageVO<>();
      }

      List<InboundDetailDTO> inboundDetailDTOS = new ArrayList<>();
      Map<Long, ProjectInfo> projectInfoMap = new HashMap<>();
      List<Long> projectIds = inboundDetailDOS.stream().map(InboundDetailDO::getProjectId).filter(ObjectUtil::isNotEmpty).collect(Collectors.toList());
      if (CollectionUtil.isNotEmpty(projectIds)) {
         projectInfoMap = this.projectService.getSimpleByIds(projectIds).stream().collect(Collectors.toMap(ProjectInfo::getId, Function.identity()));
      }

      List<Long> inboundIds = inboundDetailDOS.stream().map(InboundDetailDO::getInboundId).collect(Collectors.toList());
      List<Reject> rejectsAll = this.rejectMapper.selectList((Wrapper<Reject>)new LambdaQueryWrapper<Reject>().in(Reject::getInboundId, inboundIds));
      List<RejectDetail> rejectDetailsAll = new ArrayList<>();
      Map<Long, Warehouse> warehouseHashMap = new HashMap<>();
      Map<Long, MesBuildingWorkshop> mesBuildingWorkshopHashMap = new HashMap<>();
      if (CollectionUtil.isNotEmpty(rejectsAll)) {
         List<Long> rejectIds = rejectsAll.stream().map(Reject::getId).collect(Collectors.toList());
         rejectDetailsAll = this.rejectDetailMapper.selectList((Wrapper<RejectDetail>)new LambdaQueryWrapper<RejectDetail>().in(RejectDetail::getRejectId, rejectIds));
         List<Long> warehouseIds = rejectDetailsAll.stream().map(RejectDetail::getWarehouseId).collect(Collectors.toList());
         if (CollectionUtil.isNotEmpty(warehouseIds)) {
            warehouseHashMap = this.warehouseService.listByIds(warehouseIds).stream().collect(Collectors.toMap(Warehouse::getId, Function.identity()));
         }

         List<Long> workshopIds = rejectDetailsAll.stream().map(RejectDetail::getWorkshopId).collect(Collectors.toList());
         if (CollectionUtil.isNotEmpty(warehouseIds)) {
            mesBuildingWorkshopHashMap = this.workshopService
               .listByIds(workshopIds)
               .stream()
               .collect(Collectors.toMap(MesBuildingWorkshop::getId, Function.identity()));
         }
      }

      Map<String, WmsMaterialCodeConfig> materialCodeConfigMaps = this.queryUtil.getMaterialCodeConfigMaps(null);

      for (InboundDetailDO inboundDetailDO : inboundDetailDOS) {
         InboundDetailDTO dto = BeanUtil.copy(inboundDetailDO, InboundDetailDTO.class);
         dto.setNationalStandard(inboundDetailDO.getStandardName());
         dto.setInputVAT(inboundDetailDO.getInputVat());
         dto.setAmountExcludingVAT(inboundDetailDO.getAmountExcludingVat());
         dto.setUnitPriceExcludingVAT(inboundDetailDO.getPriceExcludingVat());
         if (inboundDetailDO.getProjectId() != null) {
            dto.setProject(projectInfoMap.get(inboundDetailDO.getProjectId()));
         }

         String s1 = this.queryUtil.buildCompositeKey(inboundDetailDO.getClassifyId(), inboundDetailDO.getSpecification(), inboundDetailDO.getThickness());
         WmsMaterialCodeConfig wmsMaterialCodeConfig = materialCodeConfigMaps.get(s1);
         dto.setMaterialSnNew(ObjectUtil.isNotEmpty(wmsMaterialCodeConfig) ? wmsMaterialCodeConfig.getMaterialSnNew() : null);
         List<Reject> rejects = rejectsAll.stream().filter(r -> r.getInboundId().equals(inboundDetailDO.getInboundId())).collect(Collectors.toList());
         List<RejectMaterialDTO> l = new ArrayList<>();

         for (Reject reject : rejects) {
            for (RejectDetail detail : rejectDetailsAll.stream().filter(r -> r.getRejectId().equals(reject.getId())).collect(Collectors.toList())) {
               RejectMaterialDTO d = BeanUtil.copy(detail, RejectMaterialDTO.class);
               d.setCreateTime(reject.getCreateTime());
               d.setReviewStatus(reject.getReviewStatus());
               MaterialInventoryDTO materialInventoryDTO = BeanUtil.copy(detail, MaterialInventoryDTO.class);
               Warehouse wa = warehouseHashMap.get(detail.getWarehouseId());
               MesBuildingWorkshop workshop = mesBuildingWorkshopHashMap.get(detail.getWorkshopId());
               materialInventoryDTO.setNationalStandard(detail.getStandardName());
               materialInventoryDTO.setWarehouse(BriefIdAndNameDTO.builder().id(wa.getId()).name(wa.getName()).build());
               if (workshop != null) {
                  materialInventoryDTO.setWorkshop(BriefIdAndNameDTO.builder().id(workshop.getId()).name(workshop.getName()).build());
               }

               d.setMaterial(materialInventoryDTO);
               l.add(d);
            }
         }

         dto.setRejectList(l);
         inboundDetailDTOS.add(dto);
      }

      return new PageVO<>(page, inboundDetailDTOS);
   }

   @Override
   public InboundDetailDO getInboundDetailsCount(QueryReportInboundDTOParam param) {
      param.setClassifyIds(this.QueryUtilService.getLateClassificationList(param.getClassifyId()));
      return this.inboundDetailMapper.getReceiptInboundDetailCount(param);
   }

   @Override
   public PageVO<OutboundDetailDO> getOutboundDetail(QueryDetailDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort) {
      param.setClassifyIds(this.QueryUtilService.getLateClassificationList(param.getClassifyId()));
      WeightedPriceConf weightedPriceConf = JSON.parseObject(
         this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置")).getValue(), WeightedPriceConf.class
      );
      String s = StringUtils.analyzeSortConditions(sort);
      Page<OutboundDetailDO> page = PageHelper.startPage(pageNumber, pageSize, s);
      List<OutboundDetailDO> outboundDetailDOS = this.outboundDetailMapper.getList(param);
      if (CollectionUtil.isEmpty(outboundDetailDOS)) {
         return new PageVO<>();
      }

      Map<Long, MonthWeightedAveragePrice> monthWeightedAveragePriceMap = new HashMap<>();
      List<Long> wapIds = outboundDetailDOS.stream().map(OutboundDetailDO::getWapId).filter(ObjectUtil::isNotEmpty).distinct().collect(Collectors.toList());
      List<MonthWeightedAveragePrice> monthWeightedAveragePriceList = this.monthWAPMapper.selectBatchIds(wapIds);
      if (CollectionUtil.isNotEmpty(wapIds)) {
         monthWeightedAveragePriceMap = monthWeightedAveragePriceList.stream().collect(Collectors.toMap(MonthWeightedAveragePrice::getId, Function.identity()));
      }

      Map<Long, WholeWeightedAveragePrice> wholeWeightedAveragePriceMap = new HashMap<>();
      if (CollectionUtil.isNotEmpty(monthWeightedAveragePriceList)) {
         List<Long> wholeWapId = monthWeightedAveragePriceList.stream()
            .map(MonthWeightedAveragePrice::getWholeWapId)
            .filter(ObjectUtil::isNotEmpty)
            .collect(Collectors.toList());
         if (CollectionUtil.isNotEmpty(wholeWapId)) {
            wholeWeightedAveragePriceMap = this.wholeWAPMapper
               .selectBatchIds(wholeWapId)
               .stream()
               .collect(Collectors.toMap(WholeWeightedAveragePrice::getId, Function.identity()));
         }
      }

      Map<String, WmsMaterialCodeConfig> materialCodeConfigMaps = this.queryUtil.getMaterialCodeConfigMaps(null);

      for (OutboundDetailDO outboundDetailDO : outboundDetailDOS) {
         if (BasicClassEnum.COLOR_ROLL.getType().equals(outboundDetailDO.getBasicClass()) && outboundDetailDO.getLength() != null) {
            outboundDetailDO.setMeasureUnit("张");
            outboundDetailDO.setMeasurePrecision(0);
         }

         String s1 = this.queryUtil.buildCompositeKey(outboundDetailDO.getClassifyId(), outboundDetailDO.getSpecification(), outboundDetailDO.getThickness());
         WmsMaterialCodeConfig wmsMaterialCodeConfig = materialCodeConfigMaps.get(s1);
         outboundDetailDO.setMaterialSnNew(ObjectUtil.isNotEmpty(wmsMaterialCodeConfig) ? wmsMaterialCodeConfig.getMaterialSnNew() : null);
         if (outboundDetailDO.getAmount() == null && outboundDetailDO.getAmountExcludingVAT() == null) {
            MonthWeightedAveragePrice price = monthWeightedAveragePriceMap.get(outboundDetailDO.getWapId());
            if (price != null) {
               if (WeightedPriceEnum.WHOLE.getType().equals(weightedPriceConf.getWeightedType())) {
                  WholeWeightedAveragePrice wholeWeightedAveragePrice = wholeWeightedAveragePriceMap.get(price.getWholeWapId());
                  price.setMete(wholeWeightedAveragePrice.getMete());
                  price.setAmount(wholeWeightedAveragePrice.getAmount());
                  price.setAmountExcludingVat(wholeWeightedAveragePrice.getAmountExcludingVat());
               }

               outboundDetailDO.setAmount(BigDecimal.ZERO);
               outboundDetailDO.setAmountExcludingVAT(BigDecimal.ZERO);
               outboundDetailDO.setUnitPrice(BigDecimal.ZERO);
               outboundDetailDO.setUnitPriceExcludingVAT(BigDecimal.ZERO);
               outboundDetailDO.setInputVAT(BigDecimal.ZERO);
               if (price.getMete().compareTo(BigDecimal.ZERO) != 0) {
                  BigDecimal p = outboundDetailDO.getMete().divide(price.getMete(), 20, RoundingMode.HALF_UP);
                  BigDecimal amount = price.getAmount().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
                  BigDecimal amountExcludingVat = price.getAmountExcludingVat().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
                  if (outboundDetailDO.getMete().compareTo(BigDecimal.ZERO) != 0) {
                     BigDecimal avgPrice = NumberUtil.div(amount, outboundDetailDO.getMete(), 12);
                     BigDecimal excludingVatAvgPrice = NumberUtil.div(amountExcludingVat, outboundDetailDO.getMete(), 12);
                     outboundDetailDO.setUnitPrice(avgPrice);
                     outboundDetailDO.setUnitPriceExcludingVAT(excludingVatAvgPrice);
                  }

                  outboundDetailDO.setAmount(amount);
                  outboundDetailDO.setAmountExcludingVAT(amountExcludingVat);
                  outboundDetailDO.setInputVAT(amount.subtract(amountExcludingVat));
               }
            }
         }
      }

      return new PageVO<>(page, outboundDetailDOS);
   }

   @Override
   public OutboundDetailDO getOutboundDetailCount(QueryDetailDTOParam param) {
      param.setClassifyIds(this.QueryUtilService.getLateClassificationList(param.getClassifyId()));
      WeightedPriceConf weightedPriceConf = JSON.parseObject(
         this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置")).getValue(), WeightedPriceConf.class
      );
      List<OutboundDetailDO> outboundDetailDOS = this.outboundDetailMapper.getList(param);
      BigDecimal amountCount = new BigDecimal("0");
      BigDecimal amountExcludingVatCount = new BigDecimal("0");

      for (OutboundDetailDO outboundDetailDO : outboundDetailDOS) {
         if (outboundDetailDO.getAmount() == null && outboundDetailDO.getAmountExcludingVAT() == null) {
            MonthWeightedAveragePrice price = this.monthWAPMapper.getPriceById(outboundDetailDO.getWapId());
            if (price != null) {
               if (WeightedPriceEnum.WHOLE.getType().equals(weightedPriceConf.getWeightedType())) {
                  WholeWeightedAveragePrice wholeWeightedAveragePrice = this.wholeWAPMapper.selectById(price.getWholeWapId());
                  price.setMete(wholeWeightedAveragePrice.getMete());
                  price.setAmount(wholeWeightedAveragePrice.getAmount());
                  price.setAmountExcludingVat(wholeWeightedAveragePrice.getAmountExcludingVat());
               }

               if (price.getMete().compareTo(BigDecimal.ZERO) != 0) {
                  BigDecimal p = outboundDetailDO.getMete().divide(price.getMete(), 20, RoundingMode.HALF_UP);
                  BigDecimal amount = price.getAmount().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
                  BigDecimal amountExcludingVat = price.getAmountExcludingVat().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
                  amountCount = amountCount.add(amount);
                  amountExcludingVatCount = amountExcludingVatCount.add(amountExcludingVat);
               }
            }
         } else {
            amountCount = amountCount.add(outboundDetailDO.getAmount() != null ? outboundDetailDO.getAmount() : BigDecimal.ZERO);
            amountExcludingVatCount = amountExcludingVatCount.add(
               outboundDetailDO.getAmountExcludingVAT() != null ? outboundDetailDO.getAmountExcludingVAT() : BigDecimal.ZERO
            );
         }
      }

      OutboundDetailDO outboundDetailDO = this.outboundDetailMapper.getListCount(param);
      if (outboundDetailDO != null) {
         outboundDetailDO.setAmountCount(amountCount);
         outboundDetailDO.setAmountExcludingVatCount(amountExcludingVatCount);
         return outboundDetailDO;
      } else {
         return null;
      }
   }

   @Override
   public BigDecimal getSteelOutboundMete(QueryDetailDTOParam param) {
      return BasicClassEnum.checkIsSteel(param.getBasicClass()) ? this.outboundDetailMapper.steelCountMete(param) : null;
   }

   @Override
   public PageVO<TransferDetailDO> getTransferDetail(QueryDetailDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort) {
      param.setClassifyIds(this.QueryUtilService.getLateClassificationList(param.getClassifyId()));
      Map<String, WmsMaterialCodeConfig> materialCodeConfigMaps = this.queryUtil.getMaterialCodeConfigMaps(null);
      String s = StringUtils.analyzeSortConditions(sort);
      Page<TransferDetailDO> page = PageHelper.startPage(pageNumber, pageSize, s);
      return new PageVO<>(page, this.transferDetailMapper.getTransferDetailList(param).stream().map(transferDetailDO -> {
         String s1 = this.queryUtil.buildCompositeKey(transferDetailDO.getClassifyId(), transferDetailDO.getSpecification(), transferDetailDO.getThickness());
         WmsMaterialCodeConfig wmsMaterialCodeConfig = materialCodeConfigMaps.get(s1);
         transferDetailDO.setMaterialSnNew(ObjectUtil.isNotEmpty(wmsMaterialCodeConfig) ? wmsMaterialCodeConfig.getMaterialSnNew() : null);
         return (TransferDetailDO)transferDetailDO;
      }).collect(Collectors.toList()));
   }

   @Override
   public TransferDetailDO getTransferDetailCount(QueryDetailDTOParam param) {
      param.setClassifyIds(this.QueryUtilService.getLateClassificationList(param.getClassifyId()));
      return this.transferDetailMapper.getTransferDetailListCount(param);
   }

   @Override
   public PageVO<ReturnDetailDO> getReturnDetail(QueryDetailDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort) {
      param.setClassifyIds(this.QueryUtilService.getLateClassificationList(param.getClassifyId()));
      WeightedPriceConf weightedPriceConf = JSON.parseObject(
         this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置")).getValue(), WeightedPriceConf.class
      );
      Map<String, WmsMaterialCodeConfig> materialCodeConfigMaps = this.queryUtil.getMaterialCodeConfigMaps(null);
      String s = StringUtils.analyzeSortConditions(sort);
      Page<TransferDetailDO> page = PageHelper.startPage(pageNumber, pageSize, s);
      return new PageVO<>(page, this.returnDetailMapper.getList(param).stream().map(returnDetailDO -> {
         String s1 = this.queryUtil.buildCompositeKey(returnDetailDO.getClassifyId(), returnDetailDO.getSpecification(), returnDetailDO.getThickness());
         WmsMaterialCodeConfig wmsMaterialCodeConfig = materialCodeConfigMaps.get(s1);
         returnDetailDO.setMaterialSnNew(ObjectUtil.isNotEmpty(wmsMaterialCodeConfig) ? wmsMaterialCodeConfig.getMaterialSnNew() : null);
         MaterialReturnable materialReturnable = this.materialReturnableMapper.selectById(returnDetailDO.getMaterialReturnableId());
         if (returnDetailDO.getAmount() == null && returnDetailDO.getAmountExcludingVAT() == null) {
            MoveOutboundDetail moveOutboundDetail = this.outboundDetailMapper.selectById(materialReturnable.getOutboundDetailId());
            if (moveOutboundDetail != null && moveOutboundDetail.getAmount() == null && moveOutboundDetail.getAmountExcludingVat() == null) {
               MonthWeightedAveragePrice price = this.monthWAPMapper.getPriceById(moveOutboundDetail.getWapId());
               if (price != null) {
                  if (WeightedPriceEnum.WHOLE.getType().equals(weightedPriceConf.getWeightedType())) {
                     WholeWeightedAveragePrice wholeWeightedAveragePrice = this.wholeWAPMapper.selectById(price.getWholeWapId());
                     price.setMete(wholeWeightedAveragePrice.getMete());
                     price.setAmount(wholeWeightedAveragePrice.getAmount());
                     price.setAmountExcludingVat(wholeWeightedAveragePrice.getAmountExcludingVat());
                  }

                  if (price.getMete().compareTo(BigDecimal.ZERO) != 0) {
                     BigDecimal p = moveOutboundDetail.getMete().divide(price.getMete(), 20, RoundingMode.HALF_UP);
                     BigDecimal amount = price.getAmount().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
                     BigDecimal amountExcludingVat = price.getAmountExcludingVat().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
                     BigDecimal avgPrice = NumberUtil.div(amount, moveOutboundDetail.getMete(), 12);
                     BigDecimal excludingVatAvgPrice = NumberUtil.div(amountExcludingVat, moveOutboundDetail.getMete(), 12);
                     BigDecimal p1 = returnDetailDO.getMete().divide(materialReturnable.getMete(), 20, RoundingMode.HALF_UP);
                     BigDecimal amount1 = amount.multiply(p1).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
                     BigDecimal amountExcludingVat1 = amountExcludingVat.multiply(p1).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
                     returnDetailDO.setAmountExcludingVAT(amountExcludingVat1);
                     returnDetailDO.setAmount(amount1);
                     returnDetailDO.setUnitPrice(avgPrice);
                     returnDetailDO.setUnitPriceExcludingVAT(excludingVatAvgPrice);
                     returnDetailDO.setInputVAT(amount1.subtract(amountExcludingVat1));
                  }
               }
            }
         }

         if (materialReturnable.getRecipientId() != null) {
            returnDetailDO.setRecipient(materialReturnable.getRecipientName());
            User byId = this.userService.getById(materialReturnable.getRecipientId());
            if (byId.getDepartmentId() != null) {
               Department department = this.departmentService.getById(byId.getDepartmentId());
               returnDetailDO.setDepartmentName(department.getName());
            }
         }

         return (ReturnDetailDO)returnDetailDO;
      }).collect(Collectors.toList()));
   }

   @Override
   public ReturnDetailDO getReturnDetailCount(QueryDetailDTOParam param) {
      param.setClassifyIds(this.QueryUtilService.getLateClassificationList(param.getClassifyId()));
      WeightedPriceConf weightedPriceConf = JSON.parseObject(
         this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置")).getValue(), WeightedPriceConf.class
      );
      List<ReturnDetailDO> returnDetailDOS = this.returnDetailMapper.getList(param);
      BigDecimal amountCount = new BigDecimal("0");
      BigDecimal amountExcludingVatCount = new BigDecimal("0");

      for (ReturnDetailDO returnDetailDO : returnDetailDOS) {
         MaterialReturnable materialReturnable = this.materialReturnableMapper.selectById(returnDetailDO.getMaterialReturnableId());
         if (returnDetailDO.getAmount() == null && returnDetailDO.getAmountExcludingVAT() == null) {
            MoveOutboundDetail moveOutboundDetail = this.outboundDetailMapper.selectById(materialReturnable.getOutboundDetailId());
            if (moveOutboundDetail != null && moveOutboundDetail.getAmount() == null && moveOutboundDetail.getAmountExcludingVat() == null) {
               MonthWeightedAveragePrice price = this.monthWAPMapper.getPriceById(moveOutboundDetail.getWapId());
               if (price != null) {
                  if (WeightedPriceEnum.WHOLE.getType().equals(weightedPriceConf.getWeightedType())) {
                     WholeWeightedAveragePrice wholeWeightedAveragePrice = this.wholeWAPMapper.selectById(price.getWholeWapId());
                     price.setMete(wholeWeightedAveragePrice.getMete());
                     price.setAmount(wholeWeightedAveragePrice.getAmount());
                     price.setAmountExcludingVat(wholeWeightedAveragePrice.getAmountExcludingVat());
                  }

                  if (price.getMete().compareTo(BigDecimal.ZERO) != 0) {
                     BigDecimal p = moveOutboundDetail.getMete().divide(price.getMete(), 20, RoundingMode.HALF_UP);
                     BigDecimal amount = price.getAmount().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
                     BigDecimal amountExcludingVat = price.getAmountExcludingVat().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
                     BigDecimal avgPrice = NumberUtil.div(amount, moveOutboundDetail.getMete(), 12);
                     BigDecimal excludingVatAvgPrice = NumberUtil.div(amountExcludingVat, moveOutboundDetail.getMete(), 12);
                     BigDecimal p1 = returnDetailDO.getMete().divide(materialReturnable.getMete(), 20, RoundingMode.HALF_UP);
                     BigDecimal amount1 = amount.multiply(p1).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
                     BigDecimal amountExcludingVat1 = amountExcludingVat.multiply(p1).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
                     amountCount = amountCount.add(amount1);
                     amountExcludingVatCount = amountExcludingVatCount.add(amountExcludingVat1);
                  }
               }
            }
         } else {
            amountCount = amountCount.add(returnDetailDO.getAmount() != null ? returnDetailDO.getAmount() : BigDecimal.ZERO);
            amountExcludingVatCount = amountExcludingVatCount.add(
               returnDetailDO.getAmountExcludingVAT() != null ? returnDetailDO.getAmountExcludingVAT() : BigDecimal.ZERO
            );
         }
      }

      ReturnDetailDO returnDetailDO = this.returnDetailMapper.getListCount(param);
      if (returnDetailDO != null) {
         returnDetailDO.setAmountCount(amountCount);
         returnDetailDO.setAmountExcludingVatCount(amountExcludingVatCount);
         return returnDetailDO;
      } else {
         return null;
      }
   }

   @Override
   public PageVO<RejectDO> getRejectList(QueryRejectDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort) {
      String s = StringUtils.analyzeSortConditions(sort);
      Page<RejectDO> page = PageHelper.startPage(pageNumber, pageSize, s);
      return new PageVO<>(page, this.rejectMapper.getList(param).stream().map(td -> {
         if (StrUtil.isNotBlank(td.getProjectIds())) {
            td.setProjects(this.projectService.listByIds(td.getProjectIds()));
         }

         return (RejectDO)td;
      }).collect(Collectors.toList()));
   }

   @Override
   public RejectDO getRejectListCount(QueryRejectDTOParam param) {
      return this.rejectMapper.getListCount(param);
   }

   @Override
   public PageVO<RejectDetailDO> getRejectDetailList(QueryRejectDetailDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort) {
      param.setClassifyIds(this.queryUtil.getLateClassificationList(param.getClassifyId()));
      String s = StringUtils.analyzeSortConditions(sort);
      Page<RejectDetailDO> page = PageHelper.startPage(pageNumber, pageSize, s);
      List<RejectDetailDO> list = this.rejectDetailMapper.getList(param);
      return new PageVO<>(page, list);
   }

   @Override
   public BigDecimal getReceiptDetailMete(QueryRejectDetailDTOParam param) {
      param.setClassifyIds(this.queryUtil.getLateClassificationList(param.getClassifyId()));
      List<RejectDetailDO> rejectDetails = this.rejectDetailMapper.getList(param);
      return rejectDetails.stream().map(RejectDetailDO::getMete).reduce(BigDecimal.ZERO, BigDecimal::add);
   }

   @Override
   public RejectDetailDTO getRejectDetail(Long id) {
      return this.rejectService.detailList(id);
   }

   @Override
   public StatisticsPageVO<StatisticsDTO> getStatistics(QueryStatisticsDTOParam param) {
      param.setClassifyIds(this.QueryUtilService.getLateClassificationList(param.getClassifyId()));
      MonthTimeRange monthTimeRange = DateTimeUtil.getMonthTimeRange(param.getCreateTime().toLocalDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
      boolean boolShowAmount = UserUtil.getCurrentUser().getPermissions().contains("wms_report_rawMat_sendAndReceiveStorage:showAmount");
      BigDecimal endPeriod = BigDecimal.ZERO;
      param.setBoolShowAmount(boolShowAmount);
      BasicConfig basicConfig = this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置"));
      WeightedPriceConf weightedPriceConf = JSON.parseObject(basicConfig.getValue(), WeightedPriceConf.class);
      List<StatisticsDTO> list;
      if (monthTimeRange.getStartTime().compareTo(LocalDateTime.now()) < 0 && LocalDateTime.now().compareTo(monthTimeRange.getEndTime()) < 0) {
         list = this.statisticsMapper.getListById(param);
         endPeriod = boolShowAmount ? endPeriod.add(this.statisticsEndPeriodMapper.getSumAmount()) : null;
      } else {
         list = this.statisticsMonthRecordMapper.getListById(param);
         if (CollectionUtil.isEmpty(list)) {
            return new StatisticsPageVO<>();
         }

         weightedPriceConf.setWeightedType(list.get(0).getWeightedPriceType());
         MonthTimeRange m = DateTimeUtil.getMonthTimeRange(
            monthTimeRange.getEndTime().toLocalDate().plusMonths(1L).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
         );
         endPeriod = boolShowAmount ? endPeriod.add(this.statisticsBeginPeriodMapper.getSumAmount(m)) : null;
      }

      BigDecimal beginPeriod;
      BigDecimal inbound;
      BigDecimal transfer;
      BigDecimal outbound;
      if (boolShowAmount) {
         beginPeriod = this.statisticsBeginPeriodMapper.getSumAmount(monthTimeRange);
         inbound = this.statisticsInboundMapper.getSumAmount(monthTimeRange, ReceiptTypeEnum.getInbound());
         transfer = this.statisticsInboundMapper.getGranterSumAmount(monthTimeRange, ReceiptTypeEnum.getInbound());
         outbound = this.statisticsOutboundMapper.getSumAmount(monthTimeRange);
      } else {
         beginPeriod = null;
         endPeriod = null;
         inbound = null;
         transfer = null;
         outbound = null;
      }

      Map<Long, Classification> classificationMap = new HashMap<>();
      Map<Long, Classification> oneClassificationMap = new HashMap<>();
      Map<Long, Measure> measureMap = new HashMap<>();
      Map<Long, DetailDTO> statIdDetailDTOMap = new HashMap<>();
      Map<Long, DetailDTO> notStatIdDetailDTOMap = new HashMap<>();
      if (CollectionUtil.isNotEmpty(list)) {
         List<Long> classifyIds = list.stream().map(StatisticsDTO::getClassifyId).filter(ObjectUtil::isNotEmpty).collect(Collectors.toList());
         List<Classification> classifications = this.classificationService.listByIds(classifyIds);
         classificationMap = classifications.stream().collect(Collectors.toMap(Classification::getId, Function.identity()));
         List<Classification> OneClassifications = this.classificationService
            .list((Wrapper<Classification>)new LambdaQueryWrapper<Classification>().eq(Classification::getParentId, 0L));
         oneClassificationMap = OneClassifications.stream().collect(Collectors.toMap(Classification::getId, Function.identity()));
         List<Measure> measures = this.measureService.list((Wrapper<Measure>)new LambdaQueryWrapper<Measure>().in(Measure::getClassificationId, classifyIds));
         measureMap = measures.stream().collect(Collectors.toMap(Measure::getClassificationId, m -> (Measure)m));
         List<Long> statIdList = list.stream().filter(l -> ObjectUtil.isNotEmpty(l.getStatId())).map(StatisticsDTO::getStatId).collect(Collectors.toList());
         if (CollectionUtil.isNotEmpty(statIdList)) {
            List<DetailDTO> statIdDetailDTOList = this.statisticsBeginPeriodMapper.getDetailNew(statIdList, monthTimeRange, false);
            statIdDetailDTOMap = statIdDetailDTOList.stream().collect(Collectors.toMap(DetailDTO::getId, Function.identity()));
         }

         List<Long> notStatIdList = list.stream().filter(l -> ObjectUtil.isEmpty(l.getStatId())).map(StatisticsDTO::getId).collect(Collectors.toList());
         if (CollectionUtil.isNotEmpty(notStatIdList)) {
            List<DetailDTO> notStatIdDetailDTOList = this.statisticsBeginPeriodMapper.getDetailNew(notStatIdList, monthTimeRange, false);
            notStatIdDetailDTOMap = notStatIdDetailDTOList.stream().collect(Collectors.toMap(DetailDTO::getId, Function.identity()));
         }
      }

      Map<String, WmsMaterialCodeConfig> materialCodeConfigMaps = this.queryUtil.getMaterialCodeConfigMaps(null);

      for (StatisticsDTO dto : list) {
         Classification classify = classificationMap.get(dto.getClassifyId());
         if (BasicClassEnum.GENERAL_MATERIAL.getType().equals(dto.getBasicClass()) && classify != null && classify.getBoolLastEnum()) {
            Classification classification = oneClassificationMap.get(CommonUtil.spilt(classify.getPath(), ",").get(0));
            dto.setClassifyName(classification.getName() + ">" + classify.getName());
         }

         dto.setClassifySerialNumber(classify.getSerialNumber());
         if (StrUtil.isNotBlank(dto.getSpecs())) {
            dto.setSpecifications(Arrays.asList(dto.getSpecs().split(",")));
         }

         DetailDTO detail = null;
         if (ObjectUtil.isNotEmpty(dto.getStatId())) {
            detail = statIdDetailDTOMap.get(dto.getStatId());
         } else {
            detail = notStatIdDetailDTOMap.get(dto.getId());
         }

         if (detail != null && detail.getAmountExcludingVAT() != null) {
            detail.setUnitPriceExcludingVAT(
               detail.getAmountExcludingVAT().compareTo(BigDecimal.ZERO) > 0 ? detail.getAmountExcludingVAT().divide(detail.getMete(), 12, 4) : BigDecimal.ZERO
            );
            dto.setBeginPeriod(detail);
         }

         String s1 = this.queryUtil
            .buildCompositeKey(
               dto.getClassifyId(), CollectionUtil.isNotEmpty(dto.getSpecifications()) ? dto.getSpecifications().get(0) : "", dto.getThickness()
            );
         WmsMaterialCodeConfig wmsMaterialCodeConfig = materialCodeConfigMaps.get(s1);
         dto.setMaterialSnNew(ObjectUtil.isNotEmpty(wmsMaterialCodeConfig) ? wmsMaterialCodeConfig.getMaterialSnNew() : null);
      }

      StatisticsPageVO<StatisticsDTO> statisticsDTOPageVO = new StatisticsPageVO<>();
      statisticsDTOPageVO.setWeightedType(weightedPriceConf.getWeightedType());
      Map<Long, Measure> finalMeasureMap = measureMap;
      if (WeightedPriceEnum.WHOLE.getType().equals(weightedPriceConf.getWeightedType())
         && param.getProjectWarehouseType() == null
         && param.getProjectId() == null) {
         Map<String, StatisticsDTO> map = new HashMap<>();
         Map<String, List<String>> specMap = new HashMap<>();
         this.setDetailMap(map, specMap, list);
         map = this.updateMap(map, specMap);
         statisticsDTOPageVO.setContent(
            new ArrayList<>(map.values())
               .stream()
               .peek(
                  l -> {
                     Measure measure = finalMeasureMap.get(l.getClassifyId());
                     l.setOutboundUnitType(measure.getOutboundUnitType());
                     DetailDTO lInbound = l.getInbound();
                     if (lInbound != null && lInbound.getAmount() != null) {
                        lInbound.setUnitPrice(
                           lInbound.getAmount().compareTo(BigDecimal.ZERO) > 0
                              ? lInbound.getAmount().divide(lInbound.getMete(), 8, RoundingMode.HALF_UP)
                              : BigDecimal.ZERO
                        );
                        lInbound.setUnitPriceExcludingVAT(
                           lInbound.getAmountExcludingVAT().compareTo(BigDecimal.ZERO) > 0
                              ? lInbound.getAmountExcludingVAT().divide(lInbound.getMete(), 8, RoundingMode.HALF_UP)
                              : BigDecimal.ZERO
                        );
                     }

                     DetailDTO lOutbound = l.getOutbound();
                     if (lOutbound != null && lOutbound.getAmount() != null) {
                        lOutbound.setUnitPrice(
                           lOutbound.getAmount().compareTo(BigDecimal.ZERO) > 0
                              ? lOutbound.getAmount().divide(lOutbound.getMete(), 8, RoundingMode.HALF_UP)
                              : BigDecimal.ZERO
                        );
                        lOutbound.setUnitPriceExcludingVAT(
                           lOutbound.getAmountExcludingVAT().compareTo(BigDecimal.ZERO) > 0
                              ? lOutbound.getAmountExcludingVAT().divide(lOutbound.getMete(), 8, RoundingMode.HALF_UP)
                              : BigDecimal.ZERO
                        );
                     }

                     DetailDTO lBeginPeriod = l.getBeginPeriod();
                     if (lBeginPeriod != null && lBeginPeriod.getAmount() != null) {
                        lBeginPeriod.setUnitPrice(lBeginPeriod.getAmount().divide(lBeginPeriod.getMete(), 8, RoundingMode.HALF_UP));
                        lBeginPeriod.setUnitPriceExcludingVAT(lBeginPeriod.getAmountExcludingVAT().divide(lBeginPeriod.getMete(), 8, RoundingMode.HALF_UP));
                     }

                     DetailDTO lEndPeriod = l.getEndPeriod();
                     if (lEndPeriod != null && lEndPeriod.getAmount() != null) {
                        lEndPeriod.setUnitPrice(
                           lEndPeriod.getMete().compareTo(BigDecimal.ZERO) > 0
                              ? lEndPeriod.getAmount().divide(lEndPeriod.getMete(), 8, RoundingMode.HALF_UP)
                              : BigDecimal.ZERO
                        );
                        lEndPeriod.setUnitPriceExcludingVAT(
                           lEndPeriod.getMete().compareTo(BigDecimal.ZERO) > 0
                              ? lEndPeriod.getAmountExcludingVAT().divide(lEndPeriod.getMete(), 8, RoundingMode.HALF_UP)
                              : BigDecimal.ZERO
                        );
                     }
                  }
               )
               .collect(Collectors.toList())
         );
      } else {
         statisticsDTOPageVO.setContent(list.stream().peek(l -> {
            Measure measure = finalMeasureMap.get(l.getClassifyId());
            l.setOutboundUnitType(measure.getOutboundUnitType());
            l.setStatIds(Collections.singletonList(l.getStatId()));
            l.setIds(Collections.singletonList(l.getId()));
         }).collect(Collectors.toList()));
      }

      Map<String, BigDecimal> total = new HashMap<>();
      total.put("beginPeriod", beginPeriod);
      total.put("endPeriod", endPeriod);
      total.put("inbound", inbound);
      total.put("outbound", outbound);
      total.put("transfer", transfer);
      statisticsDTOPageVO.setTotalAmount(total);
      return statisticsDTOPageVO;
   }

   @Override
   public StatisticsPageVO<StatisticsDTO> getStatisticsUser(QueryStatisticsDTOParam param) {
      param.setClassifyIds(this.QueryUtilService.getLateClassificationList(param.getClassifyId()));
      boolean boolShowAmount = UserUtil.getCurrentUser().getPermissions().contains("wms_report_rawMat_sendAndReceiveStorage:showAmount");
      BigDecimal endPeriod = BigDecimal.ZERO;
      param.setBoolShowAmount(boolShowAmount);
      BasicConfig basicConfig = this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置"));
      WeightedPriceConf weightedPriceConf = JSON.parseObject(basicConfig.getValue(), WeightedPriceConf.class);
      WmsClosingTime name = this.wmsClosingTimeService.getById(param.getWmsClosingTimeId());
      WmsClosingTime one = null;
      MonthTimeRange monthTimeRange1 = new MonthTimeRange();
      MonthTimeRange monthTimeRange = new MonthTimeRange();
      if (param.getWmsClosingTimeId() != null) {
         one = this.wmsClosingTimeService
            .getOne(
               (Wrapper<WmsClosingTime>)((new LambdaQueryWrapper<WmsClosingTime>()
                        .lt(WmsClosingTime::getId, param.getWmsClosingTimeId()))
                     .orderByDesc(WmsClosingTime::getId))
                  .last("limit 1")
            );
      } else {
         one = this.wmsClosingTimeService
            .getOne((Wrapper<WmsClosingTime>)(new LambdaQueryWrapper<WmsClosingTime>().orderBy(true, false, WmsClosingTime::getId)).last("limit 1"));
         monthTimeRange.setStartTime(one != null ? one.getEndTime() : null);
      }

      monthTimeRange1.setWmsClosingTimeId(one != null ? one.getId() : null);
      // Unlinked opening rows created after the first closing belong to a later inventory state.
      boolean firstClosedPeriod = name != null && one == null;
      if (firstClosedPeriod) {
         monthTimeRange1.setEndTime(name.getStartTime());
      }
      List<StatisticsDTO> list;
      if (name == null) {
         list = this.statisticsMapper.getListById(param);
         endPeriod = boolShowAmount ? endPeriod.add(this.statisticsEndPeriodMapper.getSumAmountUser(monthTimeRange)) : null;
      } else {
         monthTimeRange.setStartTime(name.getStartTime());
         monthTimeRange.setEndTime(name.getEndTime());
         monthTimeRange.setWmsClosingTimeId(name.getId());
         list = this.statisticsMonthRecordMapper.getListById(param);
         if (CollectionUtil.isEmpty(list)) {
            return new StatisticsPageVO<>();
         }

         weightedPriceConf.setWeightedType(list.get(0).getWeightedPriceType());
         endPeriod = boolShowAmount ? endPeriod.add(this.statisticsBeginPeriodMapper.getSumAmount(monthTimeRange)) : null;
      }

      BigDecimal beginPeriod;
      BigDecimal inbound;
      BigDecimal outbound;
      if (boolShowAmount) {
         beginPeriod = this.statisticsBeginPeriodMapper.getSumAmount(monthTimeRange1);
         inbound = this.statisticsInboundMapper.getSumAmountUser(monthTimeRange);
         outbound = this.statisticsOutboundMapper.getSumAmount(monthTimeRange);
      } else {
         beginPeriod = null;
         endPeriod = null;
         inbound = null;
         outbound = null;
      }

      Map<Long, Classification> classificationMap = new HashMap<>();
      Map<Long, Classification> oneClassificationMap = new HashMap<>();
      Map<Long, Measure> measureMap = new HashMap<>();
      Map<Long, DetailDTO> statIdDetailDTOMap = new HashMap<>();
      Map<Long, DetailDTO> notStatIdDetailDTOMap = new HashMap<>();
      if (CollectionUtil.isNotEmpty(list)) {
         List<Long> classifyIds = list.stream().map(StatisticsDTO::getClassifyId).filter(ObjectUtil::isNotEmpty).collect(Collectors.toList());
         List<Classification> classifications = this.classificationService.listByIds(classifyIds);
         classificationMap = classifications.stream().collect(Collectors.toMap(Classification::getId, Function.identity()));
         List<Classification> OneClassifications = this.classificationService
            .list((Wrapper<Classification>)new LambdaQueryWrapper<Classification>().eq(Classification::getParentId, 0L));
         oneClassificationMap = OneClassifications.stream().collect(Collectors.toMap(Classification::getId, Function.identity()));
         List<Measure> measures = this.measureService.list((Wrapper<Measure>)new LambdaQueryWrapper<Measure>().in(Measure::getClassificationId, classifyIds));
         measureMap = measures.stream().collect(Collectors.toMap(Measure::getClassificationId, m -> (Measure)m));
         List<Long> statIdList = list.stream().filter(l -> ObjectUtil.isNotEmpty(l.getStatId())).map(StatisticsDTO::getStatId).collect(Collectors.toList());
         if (CollectionUtil.isNotEmpty(statIdList)) {
            List<DetailDTO> statIdDetailDTOList = this.statisticsBeginPeriodMapper.getDetailNew(statIdList, monthTimeRange1, firstClosedPeriod);
            statIdDetailDTOMap = statIdDetailDTOList.stream().collect(Collectors.toMap(DetailDTO::getId, Function.identity()));
         }

         List<Long> notStatIdList = list.stream().filter(l -> ObjectUtil.isEmpty(l.getStatId())).map(StatisticsDTO::getId).collect(Collectors.toList());
         if (CollectionUtil.isNotEmpty(notStatIdList)) {
            List<DetailDTO> notStatIdDetailDTOList = this.statisticsBeginPeriodMapper.getDetailNew(notStatIdList, monthTimeRange1, firstClosedPeriod);
            notStatIdDetailDTOMap = notStatIdDetailDTOList.stream().collect(Collectors.toMap(DetailDTO::getId, Function.identity()));
         }
      }

      for (StatisticsDTO dto : list) {
         Classification classify = classificationMap.get(dto.getClassifyId());
         if (BasicClassEnum.GENERAL_MATERIAL.getType().equals(dto.getBasicClass()) && classify != null && classify.getBoolLastEnum()) {
            Classification classification = oneClassificationMap.get(CommonUtil.spilt(classify.getPath(), ",").get(0));
            dto.setClassifyName(classification.getName() + ">" + classify.getName());
         }

         dto.setClassifySerialNumber(classify.getSerialNumber());
         if (StrUtil.isNotBlank(dto.getSpecs())) {
            dto.setSpecifications(Arrays.asList(dto.getSpecs().split(",")));
         }

         if (param.getWmsClosingTimeId() != null) {
            monthTimeRange.setWmsClosingTimeId(param.getWmsClosingTimeId());
            monthTimeRange.setStartTime(null);
            monthTimeRange.setEndTime(null);
         }

         DetailDTO detail;
         if (ObjectUtil.isNotEmpty(dto.getStatId())) {
            detail = statIdDetailDTOMap.get(dto.getStatId());
         } else {
            detail = notStatIdDetailDTOMap.get(dto.getId());
         }

         if (detail != null && detail.getAmountExcludingVAT() != null) {
            BigDecimal mete = detail.getMete();
            if (mete != null && mete.compareTo(BigDecimal.ZERO) != 0) {
               BigDecimal unitPriceExcludingVAT = detail.getAmountExcludingVAT().divide(mete, 12, 4);
               detail.setUnitPriceExcludingVAT(unitPriceExcludingVAT);
            } else {
               detail.setUnitPriceExcludingVAT(BigDecimal.ZERO);
            }

            dto.setBeginPeriod(detail);
         }
      }

      StatisticsPageVO<StatisticsDTO> statisticsDTOPageVO = new StatisticsPageVO<>();
      statisticsDTOPageVO.setWeightedType(weightedPriceConf.getWeightedType());
      Map<Long, Measure> finalMeasureMap = measureMap;
      if (WeightedPriceEnum.WHOLE.getType().equals(weightedPriceConf.getWeightedType())
         && param.getProjectWarehouseType() == null
         && param.getProjectId() == null) {
         Map<String, StatisticsDTO> map = new HashMap<>();
         Map<String, List<String>> specMap = new HashMap<>();
         this.setDetailMap(map, specMap, list);
         map = this.updateMap(map, specMap);
         statisticsDTOPageVO.setContent(new ArrayList<>(map.values()).stream().peek(l -> {
            Measure measure = finalMeasureMap.get(l.getClassifyId());
            l.setOutboundUnitType(measure.getOutboundUnitType());
            DetailDTO lInbound = l.getInbound();
            if (lInbound != null && lInbound.getAmount() != null && lInbound.getMete().compareTo(BigDecimal.ZERO) != 0) {
               lInbound.setUnitPrice(lInbound.getAmount().divide(lInbound.getMete(), 8, RoundingMode.HALF_UP));
               lInbound.setUnitPriceExcludingVAT(lInbound.getAmountExcludingVAT().divide(lInbound.getMete(), 8, RoundingMode.HALF_UP));
            }

            DetailDTO lOutbound = l.getOutbound();
            if (lOutbound != null && lOutbound.getAmount() != null && lOutbound.getMete().compareTo(BigDecimal.ZERO) != 0) {
               lOutbound.setUnitPrice(lOutbound.getAmount().divide(lOutbound.getMete(), 8, RoundingMode.HALF_UP));
               lOutbound.setUnitPriceExcludingVAT(lOutbound.getAmountExcludingVAT().divide(lOutbound.getMete(), 8, RoundingMode.HALF_UP));
            }

            DetailDTO lBeginPeriod = l.getBeginPeriod();
            if (lBeginPeriod != null && lBeginPeriod.getMete().compareTo(BigDecimal.ZERO) != 0 && lBeginPeriod.getAmount() != null) {
               lBeginPeriod.setUnitPrice(lBeginPeriod.getAmount().divide(lBeginPeriod.getMete(), 8, RoundingMode.HALF_UP));
               lBeginPeriod.setUnitPriceExcludingVAT(lBeginPeriod.getAmountExcludingVAT().divide(lBeginPeriod.getMete(), 8, RoundingMode.HALF_UP));
            }

            DetailDTO lEndPeriod = l.getEndPeriod();
            if (lEndPeriod != null && lEndPeriod.getMete().compareTo(BigDecimal.ZERO) != 0 && lEndPeriod.getAmount() != null) {
               lEndPeriod.setUnitPrice(lEndPeriod.getAmount().divide(lEndPeriod.getMete(), 8, RoundingMode.HALF_UP));
               lEndPeriod.setUnitPriceExcludingVAT(lEndPeriod.getAmountExcludingVAT().divide(lEndPeriod.getMete(), 8, RoundingMode.HALF_UP));
            }
         }).collect(Collectors.toList()));
      } else {
         statisticsDTOPageVO.setContent(list.stream().peek(l -> {
            Measure measure = finalMeasureMap.get(l.getClassifyId());
            l.setOutboundUnitType(measure.getOutboundUnitType());
            l.setStatIds(Collections.singletonList(l.getStatId()));
            l.setIds(Collections.singletonList(l.getId()));
         }).collect(Collectors.toList()));
      }

      Map<String, BigDecimal> total = new HashMap<>();
      total.put("beginPeriod", beginPeriod);
      total.put("endPeriod", endPeriod);
      total.put("inbound", inbound);
      total.put("outbound", outbound);
      statisticsDTOPageVO.setTotalAmount(total);
      return statisticsDTOPageVO;
   }

   private Map<String, StatisticsDTO> updateMap(Map<String, StatisticsDTO> map, Map<String, List<String>> specMap) {
      Set<String> keys = map.keySet();
      Map<String, StatisticsDTO> dataMap = new HashMap<>();

      for (String key : keys) {
         List<String> spec = specMap.get(key);
         StatisticsDTO value = map.get(key);
         value.setSpecifications(spec);
         Map<String, String> m = JSON.parseObject(key, Map.class);
         m.put("specs", StrUtil.join(",", spec));
         dataMap.put(JSON.toJSONString(m), value);
      }

      return dataMap;
   }

   @Override
   public ListVO<StatisticsDetailDTO> getStatisticsDetailUser(
      List<Long> ids, List<Long> statIds, Integer formType, LocalDateTime date, Long wmsClosingTimeId, List<LocalDateTime> dateTimeList
   ) {
      MonthTimeRange monthTimeRange = new MonthTimeRange();
      if (wmsClosingTimeId != null) {
         WmsClosingTime name = this.wmsClosingTimeService.getById(wmsClosingTimeId);
         monthTimeRange.setStartTime(name.getStartTime());
         monthTimeRange.setEndTime(name.getEndTime());
         monthTimeRange.setWmsClosingTimeId(name.getId());
      } else if (CollectionUtil.isNotEmpty(dateTimeList)) {
         monthTimeRange.setStartTime(dateTimeList.get(0));
         monthTimeRange.setEndTime(dateTimeList.get(1));
      }

      List<StatisticsDetailDTO> detailDTOList = null;
      switch (formType) {
         case 1:
            if (monthTimeRange.getWmsClosingTimeId() != null) {
               MonthTimeRange monthTimeRange1 = new MonthTimeRange();
               WmsClosingTime one = this.wmsClosingTimeService
                  .getOne(
                     (Wrapper<WmsClosingTime>)((new LambdaQueryWrapper<WmsClosingTime>()
                              .lt(WmsClosingTime::getId, monthTimeRange.getWmsClosingTimeId()))
                           .orderByDesc(WmsClosingTime::getId))
                        .last("limit 1")
                  );
               if (ObjectUtil.isNotEmpty(one)) {
                  monthTimeRange1.setWmsClosingTimeId(one.getId());
                  detailDTOList = this.statisticsBeginPeriodMapper.getDetailDTOListUser(CollectionUtil.isNotEmpty(statIds) ? statIds : ids, monthTimeRange1);
               }
            } else {
               MonthTimeRange monthTimeRange1 = new MonthTimeRange();
               WmsClosingTime one = this.wmsClosingTimeService
                  .getOne((Wrapper<WmsClosingTime>)(new LambdaQueryWrapper<WmsClosingTime>().orderBy(true, false, WmsClosingTime::getId)).last("limit 1"));
               if (ObjectUtil.isNotEmpty(one)) {
                  monthTimeRange1.setWmsClosingTimeId(one.getId());
               }

               detailDTOList = this.statisticsBeginPeriodMapper.getDetailDTOListUser(CollectionUtil.isNotEmpty(statIds) ? statIds : ids, monthTimeRange1);
            }
            break;
         case 2:
            detailDTOList = this.statisticsInboundMapper
               .getDetailDTOListUser(CollectionUtil.isNotEmpty(statIds) ? statIds : ids, monthTimeRange, ReceiptTypeEnum.getInbound());
            break;
         case 3:
            detailDTOList = this.statisticsOutboundMapper
               .getDetailDTOListUser(CollectionUtil.isNotEmpty(statIds) ? statIds : ids, monthTimeRange)
               .stream()
               .peek(l -> {
                  if (BasicClassEnum.COLOR_ROLL.getType().equals(l.getBasicClass()) && l.getLength() != null) {
                     l.setMeasureUnit("张");
                     l.setMeasurePrecision(0);
                  }
               })
               .collect(Collectors.toList());
            break;
         case 4:
            if (CollectionUtil.isNotEmpty(statIds)) {
               monthTimeRange.setEndTime(null);
               monthTimeRange.setStartTime(null);
               detailDTOList = this.statisticsBeginPeriodMapper.getDetailDTOListUser(statIds, monthTimeRange);
            } else {
               detailDTOList = this.statisticsEndPeriodMapper.getDetailDTOListUser(ids, monthTimeRange);
            }
            break;
         case 5:
            detailDTOList = this.statisticsInboundMapper
               .getTransferDetailDTOListUser(CollectionUtil.isNotEmpty(statIds) ? statIds : ids, monthTimeRange, ReceiptTypeEnum.getInbound());
            break;
         default:
            detailDTOList = new ArrayList<>();
      }

      return this.getList(detailDTOList);
   }

   @Override
   public ListVO<StatisticsDetailDTO> getStatisticsDetail(List<Long> ids, List<Long> statIds, Integer formType, LocalDateTime date) {
      MonthTimeRange monthTimeRange = DateTimeUtil.getMonthTimeRange(date.toLocalDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
      Map<String, WmsMaterialCodeConfig> materialCodeConfigMaps = this.queryUtil.getMaterialCodeConfigMaps(null);
      List<StatisticsDetailDTO> detailDTOList;
      switch (formType) {
         case 1:
            detailDTOList = this.statisticsBeginPeriodMapper
               .getDetailDTOList(CollectionUtil.isNotEmpty(statIds) ? statIds : ids, monthTimeRange)
               .stream()
               .peek(l -> {
                  String s1 = this.queryUtil.buildCompositeKey(l.getClassifyId(), l.getSpecification(), l.getThickness());
                  l.setMaterialSnNew(ObjectUtil.isNotEmpty(materialCodeConfigMaps.get(s1)) ? materialCodeConfigMaps.get(s1).getMaterialSnNew() : "");
               })
               .collect(Collectors.toList());
            break;
         case 2:
            detailDTOList = this.statisticsInboundMapper
               .getDetailDTOList(CollectionUtil.isNotEmpty(statIds) ? statIds : ids, monthTimeRange)
               .stream()
               .peek(l -> {
                  String s1 = this.queryUtil.buildCompositeKey(l.getClassifyId(), l.getSpecification(), l.getThickness());
                  l.setMaterialSnNew(ObjectUtil.isNotEmpty(materialCodeConfigMaps.get(s1)) ? materialCodeConfigMaps.get(s1).getMaterialSnNew() : "");
               })
               .collect(Collectors.toList());
            break;
         case 3:
            detailDTOList = this.statisticsOutboundMapper
               .getDetailDTOList(CollectionUtil.isNotEmpty(statIds) ? statIds : ids, monthTimeRange)
               .stream()
               .peek(l -> {
                  if (BasicClassEnum.COLOR_ROLL.getType().equals(l.getBasicClass()) && l.getLength() != null) {
                     l.setMeasureUnit("张");
                     l.setMeasurePrecision(0);
                     String s1 = this.queryUtil.buildCompositeKey(l.getClassifyId(), l.getSpecification(), l.getThickness());
                     l.setMaterialSnNew(ObjectUtil.isNotEmpty(materialCodeConfigMaps.get(s1)) ? materialCodeConfigMaps.get(s1).getMaterialSnNew() : "");
                  }
               })
               .collect(Collectors.toList());
            break;
         case 4:
            if (CollectionUtil.isNotEmpty(statIds)) {
               MonthTimeRange m = DateTimeUtil.getMonthTimeRange(
                  monthTimeRange.getEndTime().toLocalDate().plusMonths(1L).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
               );
               detailDTOList = this.statisticsBeginPeriodMapper.getDetailDTOList(statIds, monthTimeRange).stream().peek(l -> {
                  String s1 = this.queryUtil.buildCompositeKey(l.getClassifyId(), l.getSpecification(), l.getThickness());
                  l.setMaterialSnNew(ObjectUtil.isNotEmpty(materialCodeConfigMaps.get(s1)) ? materialCodeConfigMaps.get(s1).getMaterialSnNew() : "");
               }).collect(Collectors.toList());
            } else {
               detailDTOList = this.statisticsEndPeriodMapper.getDetailDTOList(ids, date).stream().peek(l -> {
                  String s1 = this.queryUtil.buildCompositeKey(l.getClassifyId(), l.getSpecification(), l.getThickness());
                  l.setMaterialSnNew(ObjectUtil.isNotEmpty(materialCodeConfigMaps.get(s1)) ? materialCodeConfigMaps.get(s1).getMaterialSnNew() : "");
               }).collect(Collectors.toList());
            }
            break;
         case 5:
            detailDTOList = this.statisticsInboundMapper
               .getTransferDetailDTOListUser(CollectionUtil.isNotEmpty(statIds) ? statIds : ids, monthTimeRange, ReceiptTypeEnum.getInbound());
            break;
         default:
            detailDTOList = new ArrayList<>();
      }

      return this.getList(detailDTOList);
   }

   private ListVO<StatisticsDetailDTO> getList(List<StatisticsDetailDTO> detailDTOList) {
      if (CollectionUtil.isNotEmpty(detailDTOList)) {
         List<Long> classifyIds = detailDTOList.stream().map(StatisticsDetailDTO::getClassifyId).filter(ObjectUtil::isNotEmpty).collect(Collectors.toList());
         List<Classification> classifications = this.classificationService.listByIds(classifyIds);
         Map<Long, Classification> classificationMap = classifications.stream().collect(Collectors.toMap(Classification::getId, Function.identity()));
         List<Measure> measures = this.measureService.list((Wrapper<Measure>)new LambdaQueryWrapper<Measure>().in(Measure::getClassificationId, classifyIds));
         Map<Long, Measure> measureMap = measures.stream().collect(Collectors.toMap(Measure::getClassificationId, m -> (Measure)m));
         return new ListVO<>(detailDTOList != null ? detailDTOList.stream().map(l -> {
            l.setMeasure(measureMap.get(l.getClassifyId()));
            l.setClassifySerialNumber(classificationMap.get(l.getClassifyId()).getSerialNumber());
            this.setValue(l);
            return (StatisticsDetailDTO)l;
         }).collect(Collectors.toList()) : new ArrayList<>());
      } else {
         return new ListVO<>(new ArrayList<>());
      }
   }

   @Override
   public Map<String, List<MonthSummaryDO>> getTotalAmount(LocalDateTime year, int type) {
      int basicClass = BasicClassEnum.STEEL_PLATE.getType() | BasicClassEnum.SECTION_STEEL.getType() | BasicClassEnum.COLOR_ROLL.getType();
      int basicClass2 = BasicClassEnum.GENERAL_MATERIAL.getType() | BasicClassEnum.GAS.getType();
      Map<String, List<MonthSummaryDO>> map = new HashMap<>();
      map.put("钢材入库", this.statisticsInboundMapper.getInboundAmount(basicClass, year, type));
      map.put("钢材出库", this.statisticsOutboundMapper.getOutboundAmount(basicClass, year, type));
      map.put("辅材入库", this.statisticsInboundMapper.getInboundAmount(basicClass2, year, type));
      map.put("辅材出库", this.statisticsOutboundMapper.getOutboundAmount(basicClass2, year, type));
      return map;
   }

   @Override
   public Map<String, List<MonthSummaryDO>> getStockAmount(LocalDateTime year, int amountType) {
      int basicClass = BasicClassEnum.STEEL_PLATE.getType() | BasicClassEnum.SECTION_STEEL.getType() | BasicClassEnum.COLOR_ROLL.getType();
      int basicClass2 = BasicClassEnum.GENERAL_MATERIAL.getType() | BasicClassEnum.GAS.getType();
      List<MonthSummaryDO> steelList = new ArrayList<>();
      List<MonthSummaryDO> list = new ArrayList<>();

      for (int i = 1; i < 13; i++) {
         int month = i;
         Map<Integer, MonthSummaryDO> steelMap = this.statisticsBeginPeriodMapper
            .getAmountList(year, basicClass, amountType)
            .stream()
            .collect(Collectors.toMap(MonthSummaryDO::getDate, Function.identity(), (key1, key2) -> key2));
         Map<Integer, MonthSummaryDO> map = this.statisticsBeginPeriodMapper
            .getAmountList(year, basicClass2, amountType)
            .stream()
            .collect(Collectors.toMap(MonthSummaryDO::getDate, Function.identity(), (key1, key2) -> key2));
         MonthSummaryDO steelDO = steelMap.get(i);
         if (steelDO != null) {
            month--;
            steelDO.setDate(month == 0 ? 12 : month);
            steelList.add(steelDO);
         }

         MonthSummaryDO DO = map.get(i);
         if (DO != null) {
            month--;
            DO.setDate(month == 0 ? 12 : month);
            list.add(DO);
         }
      }

      if (year.getYear() == LocalDateTime.now().getYear()) {
         steelList.add(this.statisticsEndPeriodMapper.getByBasicClass(amountType, basicClass));
         list.add(this.statisticsEndPeriodMapper.getByBasicClass(amountType, basicClass2));
      }

      Map<String, List<MonthSummaryDO>> map = new HashMap<>();
      map.put("钢材", steelList);
      map.put("辅材", list);
      return map;
   }

   @Override
   public PageVO<RDFeeDTO> getHighTechRDFee(QueryDetailDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort) {
      param.setClassifyIds(this.QueryUtilService.getLateClassificationList(param.getClassifyId()));
      String s = StringUtils.analyzeSortConditions(sort);
      Page<RDFeeDTO> page = PageHelper.startPage(pageNumber, pageSize, s);
      List<RDFeeDTO> rows = this.outboundDetailMapper.getRDFeeDetail(param);
      if (!rows.isEmpty()) {
         QueryDetailDTOParam priceQuery = new QueryDetailDTOParam();
         priceQuery.setDetailIds(rows.stream().map(RDFeeDTO::getId).collect(Collectors.toList()));
         Map<Long, OutboundDetailDO> costs = this.getOutboundDetail(priceQuery, 1, rows.size(), null).getContent()
            .stream().collect(Collectors.toMap(OutboundDetailDO::getId, Function.identity()));
         for (RDFeeDTO dto : rows) {
            OutboundDetailDO cost = costs.get(dto.getId());
            if (cost != null) {
               dto.setAmount(cost.getAmount());dto.setAmountExcludingVAT(cost.getAmountExcludingVAT());
               dto.setUnitPrice(cost.getUnitPrice());dto.setUnitPriceExcludingVAT(cost.getUnitPriceExcludingVAT());dto.setInputVAT(cost.getInputVAT());
            }
            if (dto.getRdRate() != null && dto.getAmountExcludingVAT() != null) {
               dto.setRdFee(dto.getAmountExcludingVAT().multiply(dto.getRdRate().divide(BigDecimal.valueOf(100L))).setScale(2, 4));
            }
         }
      }
      return new PageVO<>(page, rows);
   }

   @Override
   public PageVO<MaterialInventoryDTO> getInventory(
      Integer basicClass,
      List<Long> classifyId,
      Integer orderSupplyType,
      List<Long> workshopIds,
      String specification,
      Integer pageNumber,
      Integer pageSize,
      List<String> sort
   ) {
      WeightedPriceConf weightedPriceConf = JSON.parseObject(
         this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置")).getValue(), WeightedPriceConf.class
      );
      String s = StringUtils.analyzeSortConditions(sort);
      ArrayList<Long> ids = new ArrayList<>();
      if (CollectionUtil.isNotEmpty(classifyId)) {
         List<Classification> classifications = this.classificationService.listByIds(classifyId);
         classifications.forEach(
            classification -> {
               if (!classification.getBoolLastEnum()) {
                  List<Long> collect = this.classificationService
                     .getLastSubject(classification.getId())
                     .stream()
                     .map(Classification::getId)
                     .collect(Collectors.toList());
                  ids.addAll(collect);
               } else {
                  ids.add(classification.getId());
               }
            }
         );
      }

      Page page = PageHelper.startPage(pageNumber, pageSize, s);
      return new PageVO<>(
         page, this.materialInventoryMapper.getTotalInventory(basicClass, ids, orderSupplyType, workshopIds, specification).stream().peek(dto -> {
            MaterialInventory materialInventory = BeanUtil.copy(dto, MaterialInventory.class);
            MaterialInventory materialInventory1 = this.materialInventoryMapper.selectById(dto.getId());
            MonthWeightedAveragePrice price = this.monthWAPMapper.getPrice(materialInventory1);
            if (WeightedPriceEnum.WHOLE.getType().equals(weightedPriceConf.getWeightedType())) {
               WholeWeightedAveragePrice wholeWeightedAveragePrice = this.wholeWAPMapper.selectById(price.getWholeWapId());
               price.setMete(wholeWeightedAveragePrice.getMete());
               price.setAmount(wholeWeightedAveragePrice.getAmount());
               price.setAmountExcludingVat(wholeWeightedAveragePrice.getAmountExcludingVat());
            }

            BigDecimal p = dto.getMete().divide(price.getMete(), 20, RoundingMode.HALF_UP);
            BigDecimal amount = price.getAmount().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
            BigDecimal amountExcludingVat = price.getAmountExcludingVat().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
            BigDecimal avgPrice = NumberUtil.div(amount, dto.getMete(), 12);
            BigDecimal excludingVatAvgPrice = NumberUtil.div(amountExcludingVat, dto.getMete(), 12);
            dto.setAmount(amount);
            dto.setAmountExcludingVAT(amountExcludingVat);
            dto.setUnitPrice(avgPrice);
            dto.setUnitPriceExcludingVAT(excludingVatAvgPrice);
            if (dto.getProject() != null) {
               materialInventory.setProjectId(dto.getProject().getId());
            }

            if (dto.getWorkshop() != null) {
               materialInventory.setWorkshopId(dto.getWorkshop().getId());
            }
         }).collect(Collectors.toList())
      );
   }

   @Override
   public List<ClassCostDTO> getOperationsAnalysisInventory(LocalDate yearDate, Integer basicClass, Long branchCompanyId, Long workshopId) {
      ArrayList<ClassCostDTO> resultList = new ArrayList<>();
      List<MaterialInventory> inventoryList = this.materialInventoryMapper
         .selectList(
            Wrappers.lambdaQuery(MaterialInventory.class)
               .eq(MaterialInventory::getUseStatus, 0)
               .eq(workshopId != null, MaterialInventory::getWorkshopId, workshopId)
               .apply(basicClass != null, "basic_class & {0} > 0", basicClass)
               .apply("date_format(create_time, '%Y') = date_format({0}, '%Y')", yearDate)
         );
      List<MaterialInventoryDTO> inventoryDTOList = this.convertToMaterialInventoryDTOList(inventoryList);
      Map<Integer, MaterialInventoryDTO> resultMap = inventoryDTOList.stream()
         .collect(Collectors.toMap(MaterialInventoryDTO::getBasicClass, dto -> (MaterialInventoryDTO)dto, (existing, replacement) -> {
            existing.setAmount(existing.getAmount().add(replacement.getAmount()));
            existing.setAmountExcludingVAT(existing.getAmountExcludingVAT().add(replacement.getAmountExcludingVAT()));
            return existing;
         }));
      resultMap.forEach((classId, mergedDTO) -> {
         ClassCostDTO classCostDTO = BeanUtil.copy(mergedDTO, ClassCostDTO.class);
         classCostDTO.setClassName(BasicClassEnum.getNameByType(classId));
         classCostDTO.setAmount(mergedDTO.getAmount().divide(BigDecimal.valueOf(10000L), 0, 4));
         classCostDTO.setAmountExcludingVAT(mergedDTO.getAmountExcludingVAT().divide(BigDecimal.valueOf(10000L), 0, 4));
         resultList.add(classCostDTO);
      });
      return resultList;
   }

   @Override
   public List<ClassifyCostDTO> getAuxiliaryOrOtherInventory(LocalDate yearDate, Integer basicClass, Long branchCompanyId, Long workshopId) {
      ArrayList<ClassifyCostDTO> resultList = new ArrayList<>();
      List<MaterialInventory> inventoryList = this.materialInventoryMapper
         .selectList(
            Wrappers.lambdaQuery(MaterialInventory.class)
               .eq(MaterialInventory::getUseStatus, 0)
               .eq(workshopId != null, MaterialInventory::getWorkshopId, workshopId)
               .eq(basicClass != null, MaterialInventory::getBasicClass, basicClass)
               .apply("date_format(create_time, '%Y') = date_format({0}, '%Y')", yearDate)
         );
      List<MaterialInventoryDTO> inventoryDTOList = this.convertToMaterialInventoryDTOList(inventoryList);
      List<Classification> oneLevelList = this.classificationService
         .list(Wrappers.lambdaQuery(Classification.class).apply(basicClass != null, "basic_class & {0} > 0", basicClass).eq(Classification::getLevel, 1));
      Map<Long, String> classNameMap = oneLevelList.stream().collect(Collectors.toMap(Classification::getId, Classification::getName));
      HashMap<Long, List<Long>> levelMap = this.getLevelMap(oneLevelList);
      Map<Long, MaterialInventoryDTO> resultMap = inventoryDTOList.stream()
         .collect(Collectors.toMap(e -> this.getOneLevel(levelMap, e.getClassifyId()), dto -> (MaterialInventoryDTO)dto, (existing, replacement) -> {
            existing.setAmount(existing.getAmount().add(replacement.getAmount()));
            existing.setAmountExcludingVAT(existing.getAmountExcludingVAT().add(replacement.getAmountExcludingVAT()));
            return existing;
         }));
      resultMap.forEach((classifyId, mergedDTO) -> {
         ClassifyCostDTO classifyCostDTO = BeanUtil.copy(mergedDTO, ClassifyCostDTO.class);
         classifyCostDTO.setClassifyId(classifyId);
         classifyCostDTO.setClassifyName(classNameMap.getOrDefault(classifyId, null));
         classifyCostDTO.setAmount(mergedDTO.getAmount().divide(BigDecimal.valueOf(10000L), 0, 4));
         classifyCostDTO.setAmountExcludingVAT(mergedDTO.getAmountExcludingVAT().divide(BigDecimal.valueOf(10000L), 0, 4));
         resultList.add(classifyCostDTO);
      });
      return resultList;
   }

   @Override
   public PageVO<MaterialInventorySimpleDTO> getInventorySimpleDTOPage(
      LocalDate yearDate, Integer basicClass, Long classifyId, Long branchCompanyId, Long workshopId, Integer pageNumber, Integer pageSize
   ) {
      List<Long> endLeveList = this.getEndLeveList(classifyId);
      if (classifyId != null && CollectionUtils.isEmpty(endLeveList)) {
         return new PageVO<>();
      }

      Page page = PageHelper.startPage(pageNumber, pageSize);
      List<MaterialInventory> inventoryList = this.materialInventoryMapper
         .selectList(
            Wrappers.lambdaQuery(MaterialInventory.class)
               .eq(MaterialInventory::getUseStatus, 0)
               .in(classifyId != null && CollectionUtils.isNotEmpty(endLeveList), MaterialInventory::getClassifyId, endLeveList)
               .eq(workshopId != null, MaterialInventory::getWorkshopId, workshopId)
               .apply(basicClass != null, "basic_class & {0} > 0", basicClass)
               .apply("date_format(create_time, '%Y') = date_format({0}, '%Y')", yearDate)
         );
      List<MaterialInventorySimpleDTO> simpleDTOList = this.convertToMMaterialInventorySimpleDTOList(inventoryList);
      return new PageVO<>(page, simpleDTOList);
   }

   @Override
   public List<MaterialInventorySimpleDTO> getInventorySimpleDTOList(
      LocalDate yearDate, Integer basicClass, Long classifyId, Long branchCompanyId, Long workshopId
   ) {
      List<Long> endLeveList = this.getEndLeveList(classifyId);
      if (classifyId != null && CollectionUtils.isEmpty(endLeveList)) {
         return new ArrayList<>();
      }

      List<MaterialInventory> inventoryList = this.materialInventoryMapper
         .selectList(
            Wrappers.lambdaQuery(MaterialInventory.class)
               .eq(MaterialInventory::getUseStatus, 0)
               .in(classifyId != null && CollectionUtils.isNotEmpty(endLeveList), MaterialInventory::getClassifyId, endLeveList)
               .eq(workshopId != null, MaterialInventory::getWorkshopId, workshopId)
               .apply(basicClass != null, "basic_class & {0} > 0", basicClass)
               .apply("date_format(create_time, '%Y') = date_format({0}, '%Y')", yearDate)
         );
      return this.convertToMMaterialInventorySimpleDTOListV2(inventoryList);
   }

   @Override
   public List<DateCostDTO> getOperationsAnalysisInventoryGroupByMonth(LocalDate yearDate, Integer basicClass, Long branchCompanyId, Long workshopId) {
      List<DateCostDTO> resultList = new ArrayList<>();
      List<MaterialInventory> inventoryList = this.materialInventoryMapper
         .selectList(
            Wrappers.lambdaQuery(MaterialInventory.class)
               .eq(MaterialInventory::getUseStatus, 0)
               .eq(workshopId != null, MaterialInventory::getWorkshopId, workshopId)
               .apply(basicClass != null, "basic_class & {0} > 0", basicClass)
               .apply("date_format(create_time, '%Y') = date_format({0}, '%Y')", yearDate)
         );
      List<MaterialInventorySimpleDTO> simpleDTOList = this.convertToMMaterialInventorySimpleDTOList(inventoryList);
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
      Map<String, BigDecimal> yearMonthMap = simpleDTOList.stream()
         .collect(
            Collectors.groupingBy(
               dto -> dto.getCreateTime().format(formatter),
               Collectors.mapping(MaterialInventorySimpleDTO::getAmountExcludingVAT, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))
            )
         );

      for (int i = 1; i <= 12; i++) {
         String dateTime = yearDate.getYear() + "-" + String.format("%02d", i);
         DateCostDTO build = DateCostDTO.builder().dateTime(dateTime).amountExcludingVAT(yearMonthMap.getOrDefault(dateTime, BigDecimal.ZERO)).build();
         resultList.add(build);
      }

      return resultList;
   }

   @Override
   public PageVO<MaterialInventorySimpleDTO> getOperationsAnalysisInventoryGroupByMonthPageList(
      LocalDate yearMouthDate, Integer basicClass, Long classifyId, Long branchCompanyId, Long workshopId, Integer pageNumber, Integer pageSize
   ) {
      List<Long> endLeveList = this.getEndLeveList(classifyId);
      if (classifyId != null && CollectionUtils.isEmpty(endLeveList)) {
         return new PageVO<>();
      }

      Page page = PageHelper.startPage(pageNumber, pageSize);
      List<MaterialInventory> inventoryList = this.materialInventoryMapper
         .selectList(
            Wrappers.lambdaQuery(MaterialInventory.class)
               .eq(MaterialInventory::getUseStatus, 0)
               .in(classifyId != null && CollectionUtils.isNotEmpty(endLeveList), MaterialInventory::getClassifyId, endLeveList)
               .eq(workshopId != null, MaterialInventory::getWorkshopId, workshopId)
               .apply(basicClass != null, "basic_class & {0} > 0", basicClass)
               .apply("date_format(create_time, '%Y-%m') = date_format({0}, '%Y-%m')", yearMouthDate)
         );
      List<MaterialInventorySimpleDTO> simpleDTOList = this.convertToMMaterialInventorySimpleDTOList(inventoryList);
      return new PageVO<>(page, simpleDTOList);
   }

   @Override
   public List<MaterialInventorySimpleDTO> getOperationsAnalysisInventoryGroupByMonthList(
      LocalDate yearMouthDate, Integer basicClass, Long classifyId, Long branchCompanyId, Long workshopId
   ) {
      List<Long> endLeveList = this.getEndLeveList(classifyId);
      if (classifyId != null && CollectionUtils.isEmpty(endLeveList)) {
         return new ArrayList<>();
      }

      List<MaterialInventory> inventoryList = this.materialInventoryMapper
         .selectList(
            Wrappers.lambdaQuery(MaterialInventory.class)
               .eq(MaterialInventory::getUseStatus, 0)
               .in(classifyId != null && CollectionUtils.isNotEmpty(endLeveList), MaterialInventory::getClassifyId, endLeveList)
               .eq(workshopId != null, MaterialInventory::getWorkshopId, workshopId)
               .apply(basicClass != null, "basic_class & {0} > 0", basicClass)
               .apply("date_format(create_time, '%Y-%m') = date_format({0}, '%Y-%m')", yearMouthDate)
         );
      return this.convertToMMaterialInventorySimpleDTOListV2(inventoryList);
   }

   @Override
   public List<ReturnDetail> getOperationsAnalysisReturnDetails(
      Integer basicClass, Long classifyId, Long projectId, LocalDate yearDate, LocalDate mouthDate, Long branchCompanyId, Long workshopId
   ) {
      return this.returnDetailMapper.getOperationsAnalysisReturnDetails(basicClass, classifyId, projectId, yearDate, mouthDate, branchCompanyId, workshopId);
   }

   @Override
   public List<DateCostDTO> getSurplusMaterialInventoryGroupByMonth(LocalDate yearDate, Long branchCompanyId, Long workshopId) {
      List<DateCostDTO> resultList = new ArrayList<>();
      List<MaterialInventory> inventoryList = this.materialInventoryMapper
         .selectList(
            Wrappers.lambdaQuery(MaterialInventory.class)
               .eq(MaterialInventory::getUseStatus, 0)
               .apply("basic_class & {0} > 0", 263)
               .eq(MaterialInventory::getMaterialIsWhole, 2)
               .eq(workshopId != null, MaterialInventory::getWorkshopId, workshopId)
               .apply("date_format(create_time, '%Y') = date_format({0}, '%Y')", yearDate)
         );
      List<MaterialInventorySimpleDTO> simpleDTOList = this.convertToMMaterialInventorySimpleDTOList(inventoryList);
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
      Map<String, MaterialInventorySimpleDTO> yearMonthMap = simpleDTOList.stream()
         .collect(Collectors.toMap(dto -> dto.getCreateTime().format(formatter), dto -> (MaterialInventorySimpleDTO)dto, (existing, replacement) -> {
            existing.setMete(existing.getMete().add(replacement.getMete()));
            existing.setAmount(existing.getAmount().add(replacement.getAmount()));
            existing.setAmountExcludingVAT(existing.getAmountExcludingVAT().add(replacement.getAmountExcludingVAT()));
            return existing;
         }));

      for (int i = 1; i <= 12; i++) {
         String dateTime = yearDate.getYear() + "-" + String.format("%02d", i);
         DateCostDTO build = DateCostDTO.builder()
            .dateTime(dateTime)
            .amountExcludingVAT(BigDecimal.ZERO)
            .mete(BigDecimal.ZERO)
            .avgUnitPriceExcludingVAT(BigDecimal.ZERO)
            .build();
         MaterialInventorySimpleDTO summaryDTO = yearMonthMap.getOrDefault(dateTime, null);
         if (summaryDTO != null) {
            BigDecimal amountExcludingVAT = summaryDTO.getAmountExcludingVAT();
            BigDecimal mete = summaryDTO.getMete().divide(BigDecimal.valueOf(1000000L));
            build.setAvgUnitPriceExcludingVAT(amountExcludingVAT.divide(mete, 0, 4));
            build.setAmountExcludingVAT(amountExcludingVAT.setScale(0, 4));
            build.setMete(mete.setScale(0, 4));
         }

         resultList.add(build);
      }

      return resultList;
   }

   @Override
   public List<WastageCostSummaryValueDTO> getGroupByMonthOutbound(Long projectId) {
      return this.outboundDetailMapper.getGroupByMonthOutbound(projectId);
   }

   @Override
   public List<WastageCostSummaryValueDTO> getGroupByMonthReturn(Long projectId) {
      return this.returnDetailMapper.getGroupByMonthReturn(projectId);
   }

   @Override
   public List<ClassCostDTO> getInventoryAnalysis(LocalDate yearDate, Long branchCompanyId) {
      ArrayList<ClassCostDTO> resultList = new ArrayList<>();
      List<MaterialInventory> inventoryList = this.materialInventoryMapper
         .selectList(
            Wrappers.lambdaQuery(MaterialInventory.class)
               .eq(MaterialInventory::getUseStatus, 0)
               .apply(branchCompanyId != null, "EXISTS (SELECT 1 FROM wms_workshop ww JOIN mes_building_factory mf ON mf.id=ww.factory_id AND mf.bool_delete_enum=0 WHERE ww.bool_delete_enum=0 AND ww.id=wms_material_inventory.workshop_id AND mf.branch_company_id={0})", branchCompanyId)
               .apply("date_format(create_time, '%Y') = date_format({0}, '%Y')", yearDate)
         );
      List<MaterialInventoryDTO> inventoryDTOList = this.convertToMaterialInventoryDTOList(inventoryList);
      Map<Integer, MaterialInventoryDTO> resultMap = inventoryDTOList.stream()
         .collect(
            Collectors.toMap(
               dto -> (dto.getBasicClass() & 263) > 0 ? 263 : dto.getBasicClass(),
               dto -> (MaterialInventoryDTO)dto,
               (existing, replacement) -> {
                  existing.setAmount(existing.getAmount().add(Optional.ofNullable(replacement.getAmount()).orElse(BigDecimal.ZERO)));
                  existing.setAmountExcludingVAT(
                     existing.getAmountExcludingVAT().add(Optional.ofNullable(replacement.getAmountExcludingVAT()).orElse(BigDecimal.ZERO))
                  );
                  return existing;
               }
            )
         );
      resultMap.forEach((basicClass, mergedDTO) -> {
         ClassCostDTO classCostDTO = new ClassCostDTO();
         if (basicClass == 263) {
            classCostDTO.setBasicClass(263);
            classCostDTO.setClassName("钢材");
         } else {
            classCostDTO.setBasicClass(basicClass);
            classCostDTO.setClassName(BasicClassEnum.getNameByType(basicClass));
         }

         classCostDTO.setAmount(mergedDTO.getAmount());
         classCostDTO.setAmountExcludingVAT(mergedDTO.getAmountExcludingVAT());
         resultList.add(classCostDTO);
      });
      return resultList;
   }

   @Override
   public List<MonthInventoryCostDTO> getInventoryInventoryCostDetail(LocalDate yearDate, Long branchCompanyId, Integer basicClass) {
      List<MaterialInventory> inventoryList = this.materialInventoryMapper
         .selectList(
            Wrappers.lambdaQuery(MaterialInventory.class)
               .eq(MaterialInventory::getUseStatus, 0)
               .apply(branchCompanyId != null, "EXISTS (SELECT 1 FROM wms_workshop ww JOIN mes_building_factory mf ON mf.id=ww.factory_id AND mf.bool_delete_enum=0 WHERE ww.bool_delete_enum=0 AND ww.id=wms_material_inventory.workshop_id AND mf.branch_company_id={0})", branchCompanyId)
               .apply("basic_class & {0} > 0", basicClass)
               .apply("date_format(create_time, '%Y') = date_format({0}, '%Y')", yearDate)
         );
      List<MaterialInventoryDTO> inventoryDTOList = this.convertToMaterialInventoryDTOList(inventoryList);
      BigDecimal reduce = inventoryDTOList.stream().map(MaterialInventoryDTO::getAmountExcludingVAT).reduce(BigDecimal.ZERO, BigDecimal::add);
      List<Classification> oneLevelList = this.classificationService
         .list(Wrappers.lambdaQuery(Classification.class).apply("basic_class & {0} > 0", basicClass).eq(Classification::getLevel, 1));
      Map<Long, String> classNameMap = oneLevelList.stream().collect(Collectors.toMap(Classification::getId, Classification::getName));
      HashMap<Long, List<Long>> levelMap = this.getLevelMap(oneLevelList);
      Map<Long, MaterialInventoryDTO> resultMap = inventoryDTOList.stream()
         .collect(Collectors.toMap(e -> this.getOneLevel(levelMap, e.getClassifyId()), dto -> (MaterialInventoryDTO)dto, (existing, replacement) -> {
            existing.setAmount(existing.getAmount().add(replacement.getAmount()));
            existing.setAmountExcludingVAT(existing.getAmountExcludingVAT().add(replacement.getAmountExcludingVAT()));
            return existing;
         }));
      List<MonthInventoryCostDTO> resultList = new ArrayList<>();
      resultMap.forEach(
         (classifyId, dto) -> {
            String className = classNameMap.get(classifyId);
            MonthInventoryCostDTO build = MonthInventoryCostDTO.builder()
               .className(className)
               .amountExcludingVAT(dto.getAmountExcludingVAT())
               .ratio(BigDecimal.ZERO)
               .build();
            if (reduce != null && dto.getAmountExcludingVAT() != null) {
               BigDecimal ratio = dto.getAmountExcludingVAT().multiply(BigDecimal.valueOf(100L)).divide(reduce, 2, RoundingMode.HALF_UP);
               build.setRatio(ratio);
            }

            resultList.add(build);
         }
      );
      return resultList;
   }

   @Override
   public List<DateCostDTO> getInventoryGroupByMonth(LocalDate yearDate, Long branchCompanyId, Integer materialIsWhole, Integer basicClass) {
      Map<Integer, MonthSummaryDO> amountMap = this.statisticsBeginPeriodMapper
         .getAmountListV2(yearDate, branchCompanyId, 2, materialIsWhole, basicClass)
         .stream()
         .collect(Collectors.toMap(MonthSummaryDO::getDate, Function.identity()));
      int year = yearDate.getYear();
      List<DateCostDTO> dtoList = new ArrayList<>();

      for (int i = 1; i < 13; i++) {
         MonthSummaryDO summaryDO = amountMap.get(i);
         DateCostDTO build;
         if (summaryDO != null) {
            build = DateCostDTO.builder()
               .dateTime(year + "-" + String.format("%02d", i))
               .amountExcludingVAT(summaryDO.getAmount().setScale(0, RoundingMode.HALF_UP).stripTrailingZeros())
               .mete(summaryDO.getMete())
               .build();
         } else {
            build = DateCostDTO.builder().dateTime(year + "-" + String.format("%02d", i)).amountExcludingVAT(BigDecimal.ZERO).mete(BigDecimal.ZERO).build();
         }

         dtoList.add(build);
      }

      return dtoList;
   }

   @Override
   public List<MonthInventoryCostDTO> getInventoryGroupByMonthDetail(LocalDate monthDate, Long branchCompanyId) {
      if (LocalDate.now().withDayOfMonth(1).isBefore(monthDate)) {
         return new ArrayList<>();
      }

      monthDate = monthDate.plusMonths(1L);
      List<StatisticsBeginPeriod> beginPeriodList = this.statisticsBeginPeriodMapper
         .selectList(Wrappers.lambdaQuery(StatisticsBeginPeriod.class)
            .apply("DATE_FORMAT(create_time, '%Y-%m') = DATE_FORMAT({0}, '%Y-%m')", monthDate)
            .apply(branchCompanyId != null, "EXISTS (SELECT 1 FROM wms_workshop ww JOIN mes_building_factory mf ON mf.id=ww.factory_id AND mf.bool_delete_enum=0 WHERE ww.bool_delete_enum=0 AND ww.id=wms_statistics_begin_period.workshop_id AND mf.branch_company_id={0})", branchCompanyId));
      List<Integer> hasBasicClass = beginPeriodList.stream().map(StatisticsBeginPeriod::getBasicClass).distinct().collect(Collectors.toList());
      int index = 1;
      List<MonthInventoryCostDTO> costDTOList = new ArrayList<>();

      for (BasicClassEnum basicClassEnum : BasicClassEnum.values()) {
         if (hasBasicClass.contains(basicClassEnum.getType())) {
            List<Classification> oneLevelList = this.classificationService
               .list(Wrappers.lambdaQuery(Classification.class).eq(Classification::getBasicClass, basicClassEnum.getType()).eq(Classification::getLevel, 1));
            Map<Long, Classification> classificationMap = oneLevelList.stream().collect(Collectors.toMap(Classification::getId, Function.identity()));
            HashMap<Long, List<Long>> levelMap = this.getLevelMap(oneLevelList);
            Map<Long, StatisticsBeginPeriod> amountMap = beginPeriodList.stream()
               .filter(e -> e.getBasicClass().equals(basicClassEnum.getType()))
               .collect(Collectors.toMap(e -> this.getOneLevel(levelMap, e.getClassifyId()), dto -> (StatisticsBeginPeriod)dto, (existing, replacement) -> {
                  BigDecimal existingAmount = existing.getAmount() != null ? existing.getAmount() : BigDecimal.ZERO;
                  BigDecimal replacementAmount = replacement.getAmount() != null ? replacement.getAmount() : BigDecimal.ZERO;
                  existing.setAmount(existingAmount.add(replacementAmount));
                  BigDecimal existingAmountExcludingVat = existing.getAmountExcludingVat() != null ? existing.getAmountExcludingVat() : BigDecimal.ZERO;
                  BigDecimal replacementAmountExcludingVat = replacement.getAmountExcludingVat() != null
                     ? replacement.getAmountExcludingVat()
                     : BigDecimal.ZERO;
                  existing.setAmountExcludingVat(existingAmountExcludingVat.add(replacementAmountExcludingVat));
                  return existing;
               }));
            BigDecimal reduce = amountMap.values().stream().map(StatisticsBeginPeriod::getAmountExcludingVat).reduce(BigDecimal.ZERO, BigDecimal::add);
            MonthInventoryCostDTO title = MonthInventoryCostDTO.builder()
               .isTitle(Boolean.TRUE)
               .index(this.convertToChinese(index))
               .className(basicClassEnum.getName())
               .amountExcludingVAT(reduce)
               .build();
            costDTOList.add(title);
            int t = 1;

            for (Long oneLevelId : amountMap.keySet()) {
               Classification classification = classificationMap.get(oneLevelId);
               StatisticsBeginPeriod statisticsBeginPeriod = amountMap.get(oneLevelId);
               BigDecimal amountExcludingVat = statisticsBeginPeriod.getAmountExcludingVat();
               BigDecimal ratio = BigDecimal.ZERO;
               if (reduce.compareTo(BigDecimal.ZERO) != 0) {
                  ratio = amountExcludingVat.multiply(BigDecimal.valueOf(100L)).divide(reduce, 2, RoundingMode.HALF_UP);
               }

               MonthInventoryCostDTO costDTO = MonthInventoryCostDTO.builder()
                  .isTitle(Boolean.FALSE)
                  .index(index + "." + t)
                  .className(classification.getName())
                  .amountExcludingVAT(amountExcludingVat)
                  .ratio(ratio)
                  .build();
               costDTOList.add(costDTO);
               t++;
            }

            index++;
         }
      }

      return costDTOList;
   }

   @Override
   public List<WmsDateMeteDTO> getWasteSaleMeteDetail(List<LocalDate> dateList, LocalDate yearDate, Long branchCompanyId, Long workshopId) {
      return this.wasteSaleMapper.getWasteSaleMeteDetail(dateList, yearDate, branchCompanyId, workshopId);
   }

   @Override
   public List<WmsDateMeteDTO> getWasteSaleMete(List<LocalDate> dateList, Long branchCompanyId, Long workshopId) {
      return this.wasteSaleMapper.getWasteSaleMete(dateList, branchCompanyId, workshopId);
   }

   @Override
   public PageVO<MoveMaterialMaterialDO> getMoveMaterialDetail(QueryDetailDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort) {
      param.setClassifyIds(this.QueryUtilService.getLateClassificationList(param.getClassifyId()));
      String s = StringUtils.analyzeSortConditions(sort);
      Page<TransferDetailDO> page = PageHelper.startPage(pageNumber, pageSize, s);
      List<MoveMaterialMaterialDO> rows = this.moveMaterialDetailMapper.getMoveMaterialDetailList(param);
      this.fillMoveMaterialAmounts(rows);
      return new PageVO<>(page, rows);
   }

   @Override
   public MoveMaterialMaterialDO getMoveMaterialDetailCount(QueryDetailDTOParam param) {
      param.setClassifyIds(this.QueryUtilService.getLateClassificationList(param.getClassifyId()));
      List<MoveMaterialMaterialDO> rows = this.moveMaterialDetailMapper.getMoveMaterialDetailList(param);
      if (rows.isEmpty()) return this.moveMaterialDetailMapper.getMoveMaterialDetailCount(param);
      this.fillMoveMaterialAmounts(rows);
      return MoveMaterialMaterialDO.builder()
         .quantityCount(rows.stream().map(MoveMaterialMaterialDO::getQuantity).filter(Objects::nonNull).reduce(BigDecimal::add).orElse(null))
         .meteCount(rows.stream().map(MoveMaterialMaterialDO::getMete).filter(Objects::nonNull).reduce(BigDecimal::add).orElse(null))
         .amountCount(rows.stream().map(MoveMaterialMaterialDO::getAmount).filter(Objects::nonNull).reduce(BigDecimal::add).orElse(null))
         .amountExcludingVatCount(rows.stream().map(MoveMaterialMaterialDO::getAmountExcludingVAT).filter(Objects::nonNull).reduce(BigDecimal::add).orElse(null))
         .build();
   }

   private void fillMoveMaterialAmounts(List<MoveMaterialMaterialDO> rows) {
      if (rows.isEmpty()) return;
      WeightedPriceConf config = JSON.parseObject(this.basicConfigService.getOne(
         Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置")).getValue(), WeightedPriceConf.class);
      Map<Long, MoveMaterialDetail> details = this.moveMaterialDetailMapper.selectBatchIds(
         rows.stream().map(MoveMaterialMaterialDO::getId).collect(Collectors.toList()))
         .stream().collect(Collectors.toMap(MoveMaterialDetail::getId, Function.identity()));
      for (MoveMaterialMaterialDO row : rows) {
         if (row.getAmount() != null || row.getAmountExcludingVAT() != null) continue;
         MoveMaterialDetail detail = details.get(row.getId());
         if (detail == null) continue;
         MonthWeightedAveragePrice price = this.monthWAPMapper.getPrice(BeanUtil.copy(detail, MaterialInventory.class));
         if (price == null) continue;
         if (WeightedPriceEnum.WHOLE.getType().equals(config.getWeightedType())) {
            WholeWeightedAveragePrice whole = this.wholeWAPMapper.selectById(price.getWholeWapId());
            if (whole == null) continue;
            price.setMete(whole.getMete());price.setAmount(whole.getAmount());price.setAmountExcludingVat(whole.getAmountExcludingVat());
         }
         BigDecimal ratio = price.getMete().signum() == 0 ? BigDecimal.ZERO
            : row.getMete().divide(price.getMete(), 20, RoundingMode.HALF_UP);
         BigDecimal amount = price.getAmount().multiply(ratio).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
         BigDecimal net = price.getAmountExcludingVat().multiply(ratio).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
         row.setAmount(amount);row.setAmountExcludingVAT(net);row.setInputVAT(amount.subtract(net));
         row.setUnitPrice(row.getMete().signum() == 0 ? BigDecimal.ZERO : amount.divide(row.getMete(), 12, RoundingMode.HALF_UP));
         row.setUnitPriceExcludingVAT(row.getMete().signum() == 0 ? BigDecimal.ZERO : net.divide(row.getMete(), 12, RoundingMode.HALF_UP));
      }
   }

   private String convertToChinese(int number) {
      Map<Integer, String> numberMap = new HashMap<>();
      numberMap.put(1, "一");
      numberMap.put(2, "二");
      numberMap.put(3, "三");
      numberMap.put(4, "四");
      numberMap.put(5, "五");
      numberMap.put(6, "六");
      numberMap.put(7, "七");
      numberMap.put(8, "八");
      numberMap.put(9, "九");
      numberMap.put(10, "十");
      numberMap.put(11, "十一");
      numberMap.put(12, "十二");
      return numberMap.getOrDefault(number, "");
   }

   private List<MaterialInventorySimpleDTO> convertToMMaterialInventorySimpleDTOList(List<MaterialInventory> inventoryList) {
      if (CollectionUtil.isEmpty(inventoryList)) {
         return new ArrayList<>();
      }

      WeightedPriceConf weightedPriceConf = JSON.parseObject(
         this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置")).getValue(), WeightedPriceConf.class
      );
      return inventoryList.stream()
         .map(
            inventory -> {
               MaterialInventorySimpleDTO simpleDTO = BeanUtil.copy(inventory, MaterialInventorySimpleDTO.class);
               MonthWeightedAveragePrice price = this.monthWAPMapper.getPrice(inventory);
               if (WeightedPriceEnum.WHOLE.getType().equals(weightedPriceConf.getWeightedType())) {
                  WholeWeightedAveragePrice wholeWeightedAveragePrice = this.wholeWAPMapper.selectById(price.getWholeWapId());
                  price.setMete(wholeWeightedAveragePrice.getMete());
                  price.setAmount(wholeWeightedAveragePrice.getAmount());
                  price.setAmountExcludingVat(wholeWeightedAveragePrice.getAmountExcludingVat());
               }

               BigDecimal p = inventory.getMete().divide(price.getMete(), 20, RoundingMode.HALF_UP);
               BigDecimal amount = price.getAmount().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
               BigDecimal amountExcludingVat = price.getAmountExcludingVat().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
               BigDecimal avgPrice = inventory.getMete().compareTo(BigDecimal.ZERO) != 0 ? NumberUtil.div(amount, inventory.getMete(), 12) : BigDecimal.ZERO;
               BigDecimal excludingVatAvgPrice = inventory.getMete().compareTo(BigDecimal.ZERO) != 0
                  ? NumberUtil.div(amountExcludingVat, inventory.getMete(), 12)
                  : BigDecimal.ZERO;
               simpleDTO.setAmount(amount);
               simpleDTO.setAmountExcludingVAT(amountExcludingVat);
               simpleDTO.setUnitPrice(avgPrice);
               simpleDTO.setUnitPriceExcludingVAT(excludingVatAvgPrice);
               DownLoadDetailDO detailDO = BeanUtil.copy(inventory, DownLoadDetailDO.class);
               StringBuilder sb = new StringBuilder();
               StringBuilder lengths = new StringBuilder();
               StringBuilder material = new StringBuilder();
               this.setSpecs(detailDO, sb, lengths, material);
               StringBuilder model = new StringBuilder();
               if (ObjectUtil.isNotEmpty(sb)) {
                  model.append(sb);
               }

               if (BasicClassEnum.STEEL_PLATE.getType().equals(inventory.getBasicClass())) {
                  if (ObjectUtil.isNotEmpty(lengths)) {
                     model.append("*").append(lengths);
                  }

                  if (ObjectUtil.isNotEmpty(material)) {
                     model.append("*").append(material);
                  }
               }

               if (BasicClassEnum.SECTION_STEEL.getType().equals(inventory.getBasicClass()) && ObjectUtil.isNotEmpty(material)) {
                  model.append("*").append(material);
               }

               simpleDTO.setSpecification(model.toString().replace(" ", ""));
               return simpleDTO;
            }
         )
         .collect(Collectors.toList());
   }

   private List<MaterialInventorySimpleDTO> convertToMMaterialInventorySimpleDTOListV2(List<MaterialInventory> inventoryList) {
      if (CollectionUtil.isEmpty(inventoryList)) {
         return new ArrayList<>();
      }

      Map<String, Unit> unitMap = this.unitMapper.selectList(new LambdaQueryWrapper<>()).stream().collect(Collectors.toMap(Unit::getName, Function.identity()));
      Map<Long, Measure> measureMap = this.measureMapper
         .selectList(new LambdaQueryWrapper<>())
         .stream()
         .collect(Collectors.toMap(Measure::getClassificationId, Function.identity()));
      Map<Long, Classification> classificationMap = this.classificationService
         .list()
         .stream()
         .collect(Collectors.toMap(Classification::getId, Function.identity()));
      WeightedPriceConf weightedPriceConf = JSON.parseObject(
         this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置")).getValue(), WeightedPriceConf.class
      );
      return inventoryList.stream()
         .map(
            inventory -> {
               MaterialInventorySimpleDTO simpleDTO = BeanUtil.copy(inventory, MaterialInventorySimpleDTO.class);
               Measure measure = measureMap.get(inventory.getClassifyId());
               if (StrUtil.isBlank(measure.getAccountingUnit())) {
                  Classification classification = classificationMap.get(measure.getClassificationId());
                  measure = this.getMeasureV2(classification.getParentId(), measureMap, classificationMap);
               }

               this.setMeteV2(simpleDTO, inventory, measure, classificationMap, measureMap, unitMap);
               MonthWeightedAveragePrice price = this.monthWAPMapper.getPrice(inventory);
               if (WeightedPriceEnum.WHOLE.getType().equals(weightedPriceConf.getWeightedType())) {
                  WholeWeightedAveragePrice wholeWeightedAveragePrice = this.wholeWAPMapper.selectById(price.getWholeWapId());
                  price.setMete(wholeWeightedAveragePrice.getMete());
                  price.setAmount(wholeWeightedAveragePrice.getAmount());
                  price.setAmountExcludingVat(wholeWeightedAveragePrice.getAmountExcludingVat());
               }

               Map<Integer, BigDecimal> mete = this.unitConversion(inventory.getMete(), measure.getAccountingUnit(), measure.getAccountingPrecision());
               BigDecimal p = inventory.getMete().divide(price.getMete(), 20, RoundingMode.HALF_UP);
               BigDecimal amount = price.getAmount().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
               BigDecimal amountExcludingVat = price.getAmountExcludingVat().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
               BigDecimal avgPrice = inventory.getMete().compareTo(BigDecimal.ZERO) != 0 ? NumberUtil.div(amount, inventory.getMete(), 12) : BigDecimal.ZERO;
               BigDecimal excludingVatAvgPrice = inventory.getMete().compareTo(BigDecimal.ZERO) != 0
                  ? NumberUtil.div(amountExcludingVat, inventory.getMete(), 12)
                  : BigDecimal.ZERO;
               simpleDTO.setAmount(amount);
               simpleDTO.setAmountExcludingVAT(amountExcludingVat);
               simpleDTO.setUnitPrice(avgPrice.multiply(mete.get(2)).setScale(2, 4));
               simpleDTO.setUnitPriceExcludingVAT(excludingVatAvgPrice.multiply(mete.get(2)).setScale(2, 4));
               DownLoadDetailDO detailDO = BeanUtil.copy(inventory, DownLoadDetailDO.class);
               StringBuilder sb = new StringBuilder();
               StringBuilder lengths = new StringBuilder();
               StringBuilder material = new StringBuilder();
               this.setSpecs(detailDO, sb, lengths, material);
               StringBuilder model = new StringBuilder();
               if (ObjectUtil.isNotEmpty(sb)) {
                  model.append(sb);
               }

               if (BasicClassEnum.STEEL_PLATE.getType().equals(inventory.getBasicClass())) {
                  if (ObjectUtil.isNotEmpty(lengths)) {
                     model.append("*").append(lengths);
                  }

                  if (ObjectUtil.isNotEmpty(material)) {
                     model.append("*").append(material);
                  }
               }

               if (BasicClassEnum.SECTION_STEEL.getType().equals(inventory.getBasicClass()) && ObjectUtil.isNotEmpty(material)) {
                  model.append("*").append(material);
               }

               simpleDTO.setSpecification(model.toString().replace(" ", ""));
               return simpleDTO;
            }
         )
         .collect(Collectors.toList());
   }

   private Map<Integer, BigDecimal> unitConversion(BigDecimal value, String unit, Integer scale) {
      Unit u = this.unitMapper.selectOne((Wrapper<Unit>)Wrappers.<Unit>lambdaQuery().eq(Unit::getName, unit));
      Map<Integer, BigDecimal> map = new HashMap<>();
      if (UnitEnum.DIGIT.getType().equals(u.getType())) {
         map.put(2, BigDecimal.ONE);
         map.put(1, value.stripTrailingZeros());
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

   private void setMeteV2(
      MaterialInventorySimpleDTO simpleDTO,
      MaterialInventory inventory,
      Measure measure,
      Map<Long, Classification> classificationMap,
      Map<Long, Measure> measureMap,
      Map<String, Unit> unitMap
   ) {
      if (StrUtil.isBlank(measure.getAccountingUnit())) {
         Classification classification = classificationMap.get(measure.getClassificationId());
         measure = this.getMeasureV2(classification.getParentId(), measureMap, classificationMap);
      }

      String accountingUnit = measure.getAccountingUnit();
      simpleDTO.setAccountingUnit(accountingUnit);
      Map<Integer, BigDecimal> mete = this.unitConversionV2(inventory.getMete(), accountingUnit, measure.getAccountingPrecision(), unitMap);
      simpleDTO.setMete(mete.get(1));
   }

   private Map<Integer, BigDecimal> unitConversionV2(BigDecimal value, String unit, Integer scale, Map<String, Unit> unitMap) {
      Unit u = unitMap.get(unit);
      Map<Integer, BigDecimal> map = new HashMap<>();
      if (scale == null) {
         scale = 0;
      }

      if (UnitEnum.DIGIT.getType().equals(u.getType())) {
         map.put(2, BigDecimal.ONE);
         map.put(1, value.stripTrailingZeros());
      } else {
         BigDecimal precision = UnitsPrecisionEnum.getByName(unit);
         map.put(1, value.divide(precision, scale, 4));
         map.put(2, precision);
      }

      return map;
   }

   private Measure getMeasureV2(Long pid, Map<Long, Measure> measureMap, Map<Long, Classification> classificationMap) {
      Measure m = measureMap.get(pid);
      if (m.getAccountingUnit() != null) {
         return m;
      }

      Classification classification = classificationMap.get(pid);
      return this.getMeasureV2(classification.getParentId(), measureMap, classificationMap);
   }

   private void setSpecs(DownLoadDetailDO detailDO, StringBuilder sb, StringBuilder lengths, StringBuilder material) {
      String thickness = detailDO.getThickness() != null ? detailDO.getThickness().stripTrailingZeros().toPlainString() : null;
      String width = detailDO.getWidth() != null ? detailDO.getWidth().stripTrailingZeros().toPlainString() : null;
      String length = detailDO.getLength() != null ? detailDO.getLength().stripTrailingZeros().toPlainString() : null;
      boolean b = StrUtil.isNotBlank(detailDO.getSpecification());
      if (BasicClassEnum.STEEL_PLATE.getType().equals(detailDO.getBasicClass())) {
         sb.append(thickness).append("*").append(width);
         lengths.append(length);
         material.append(StrUtil.isNotBlank(detailDO.getSpecification()) ? detailDO.getSpecification() : "-");
      } else if (BasicClassEnum.SECTION_STEEL.getType().equals(detailDO.getBasicClass())) {
         lengths = lengths.append(length);
         if (b && detailDO.getSpecification().contains("*")) {
            int index = detailDO.getSpecification().lastIndexOf("*");
            if (index != -1) {
               String result = detailDO.getSpecification().substring(0, index);
               sb.append(result);
            }

            String[] parts = detailDO.getSpecification().split("\\*");
            String lastPart = parts[parts.length - 1];
            material.append(StrUtil.isNotBlank(lastPart) ? lastPart : "-");
         }
      } else if (BasicClassEnum.COLOR_ROLL.getType().equals(detailDO.getBasicClass())) {
         sb.append(thickness).append("*").append(width);
         if (b) {
            if (detailDO.getSpecification().contains("*")) {
               int index = detailDO.getSpecification().lastIndexOf("*");
               if (index != -1) {
                  String result = detailDO.getSpecification().substring(0, index);
                  sb.append(result);
               }

               String[] parts = detailDO.getSpecification().split("\\*");
               String lastPart = parts[parts.length - 1];
               material.append(lastPart);
            } else {
               material.append(detailDO.getSpecification());
            }
         }

         if (StrUtil.isNotBlank(detailDO.getColor())) {
            sb.append("*").append(detailDO.getColor());
         }
      } else if (BasicClassEnum.checkNotSteel(detailDO.getBasicClass())) {
         if (StrUtil.isNotBlank(detailDO.getSpecification())) {
            sb.append(detailDO.getSpecification());
            if (StrUtil.isNotBlank(detailDO.getColor())) {
               sb.append("*").append(detailDO.getColor());
            }
         } else if (StrUtil.isNotBlank(detailDO.getColor())) {
            sb.append(detailDO.getColor());
         }
      }
   }

   private List<MaterialInventoryDTO> convertToMaterialInventoryDTOList(List<MaterialInventory> inventoryList) {
      if (CollectionUtil.isEmpty(inventoryList)) {
         return new ArrayList<>();
      }

      WeightedPriceConf weightedPriceConf = JSON.parseObject(
         this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置")).getValue(), WeightedPriceConf.class
      );
      return inventoryList.stream()
         .map(
            inventory -> {
               MaterialInventoryDTO inventoryDTO = BeanUtil.copy(inventory, MaterialInventoryDTO.class);
               MonthWeightedAveragePrice price = this.monthWAPMapper.getPrice(inventory);
               if (WeightedPriceEnum.WHOLE.getType().equals(weightedPriceConf.getWeightedType())) {
                  WholeWeightedAveragePrice wholeWeightedAveragePrice = this.wholeWAPMapper.selectById(price.getWholeWapId());
                  price.setMete(wholeWeightedAveragePrice.getMete());
                  price.setAmount(wholeWeightedAveragePrice.getAmount());
                  price.setAmountExcludingVat(wholeWeightedAveragePrice.getAmountExcludingVat());
               }

               BigDecimal p = inventory.getMete().divide(price.getMete(), 20, RoundingMode.HALF_UP);
               BigDecimal amount = price.getAmount().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
               BigDecimal amountExcludingVat = price.getAmountExcludingVat().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
               BigDecimal avgPrice = inventory.getMete().compareTo(BigDecimal.ZERO) != 0 ? NumberUtil.div(amount, inventory.getMete(), 12) : BigDecimal.ZERO;
               BigDecimal excludingVatAvgPrice = inventory.getMete().compareTo(BigDecimal.ZERO) != 0
                  ? NumberUtil.div(amountExcludingVat, inventory.getMete(), 12)
                  : BigDecimal.ZERO;
               inventoryDTO.setAmount(amount);
               inventoryDTO.setAmountExcludingVAT(amountExcludingVat);
               inventoryDTO.setUnitPrice(avgPrice);
               inventoryDTO.setUnitPriceExcludingVAT(excludingVatAvgPrice);
               return inventoryDTO;
            }
         )
         .collect(Collectors.toList());
   }

   public Long getOneLevel(HashMap<Long, List<Long>> levelMap, Long endLeveId) {
      for (Entry<Long, List<Long>> entry : levelMap.entrySet()) {
         Long oneLeveId = entry.getKey();
         List<Long> idList = entry.getValue();
         if (idList.contains(endLeveId)) {
            return oneLeveId;
         }
      }

      return endLeveId;
   }

   private HashMap<Long, List<Long>> getLevelMap(List<Classification> oneLevelList) {
      HashMap<Long, List<Long>> oneLevelMap = new HashMap<>();
      oneLevelList.forEach(
         e -> {
            ArrayList<Long> childList = new ArrayList<>();
            List<Long> child2 = this.classificationService
               .list(Wrappers.lambdaQuery(Classification.class).eq(Classification::getParentId, e.getId()).eq(Classification::getLevel, 2))
               .stream()
               .map(Classification::getId)
               .collect(Collectors.toList());
            if (e.getBoolLastEnum()) {
               childList.add(e.getId());
            } else if (CollectionUtils.isNotEmpty(child2)) {
               childList.addAll(child2);
               List<Long> child3 = this.classificationService
                  .list(Wrappers.lambdaQuery(Classification.class).in(Classification::getParentId, child2).eq(Classification::getLevel, 3))
                  .stream()
                  .map(Classification::getId)
                  .collect(Collectors.toList());
               if (CollectionUtils.isNotEmpty(child3)) {
                  childList.addAll(child3);
               }
            }

            if (CollectionUtils.isNotEmpty(childList)) {
               oneLevelMap.put(e.getId(), childList);
            }
         }
      );
      return oneLevelMap;
   }

   private List<Long> getEndLeveList(Long oneLevelId) {
      ArrayList<Long> childList = new ArrayList<>();
      if (oneLevelId == null) {
         return childList;
      }

      List<Classification> child2 = this.classificationService
         .list(Wrappers.lambdaQuery(Classification.class).eq(Classification::getParentId, oneLevelId).eq(Classification::getLevel, 2));
      if (CollectionUtils.isNotEmpty(child2)) {
         List<Long> endTwoLeveIds = child2.stream()
            .filter(e -> e.getBoolLastEnum().equals(Boolean.TRUE))
            .map(Classification::getId)
            .collect(Collectors.toList());
         if (CollectionUtil.isNotEmpty(endTwoLeveIds)) {
            childList.addAll(endTwoLeveIds);
         }

         List<Long> twoLeveIds = child2.stream().filter(e -> e.getBoolLastEnum().equals(Boolean.FALSE)).map(Classification::getId).collect(Collectors.toList());
         if (CollectionUtil.isNotEmpty(twoLeveIds)) {
            List<Long> child3 = this.classificationService
               .list(Wrappers.lambdaQuery(Classification.class).in(Classification::getParentId, twoLeveIds).eq(Classification::getLevel, 3))
               .stream()
               .map(Classification::getId)
               .collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(child3)) {
               childList.addAll(child3);
            }
         }
      }

      return childList;
   }

   @Override
   public BigDecimal getInventoryMete(Integer basicClass, Long classifyId, List<Long> workshopIds, String specification) {
      if (BasicClassEnum.checkIsSteel(basicClass)) {
         List<Long> ids = new ArrayList<>();
         List<Long> list = this.getClassifyId(classifyId);
         if (CollectionUtil.isNotEmpty(list)) {
            ids.addAll(list);
         } else if (classifyId != null) {
            ids.add(classifyId);
         }

         return this.materialInventoryMapper
            .getTotalInventory(basicClass, ids, null, workshopIds, specification)
            .stream()
            .map(MaterialInventoryDTO::getMete)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
      } else {
         return null;
      }
   }

   @Override
   public MaterialInventoryAmountDTO getInventoryAmount() {
      List<MaterialInventoryDTO> totalInventory = this.materialInventoryMapper.getTotalInventory(null, null, null, null, null);
      BigDecimal amount = BigDecimal.ZERO;
      BigDecimal amountExcludingVat = BigDecimal.ZERO;

      for (MaterialInventoryDTO dto : totalInventory) {
         MaterialInventory materialInventory1 = this.materialInventoryMapper.selectById(dto.getId());
         MonthWeightedAveragePrice price = this.monthWAPMapper.getPrice(materialInventory1);
         BigDecimal p = dto.getMete().divide(price.getMete(), 20, RoundingMode.HALF_UP);
         amount = amount.add(price.getAmount().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP));
         amountExcludingVat = amountExcludingVat.add(price.getAmountExcludingVat().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP));
      }

      MaterialInventoryAmountDTO build = MaterialInventoryAmountDTO.builder().amount(amount).amountExcludingVAT(amountExcludingVat).build();
      return build;
   }

   @Override
   public List<WmsClosingTimeDTO> getWmsClosingTime() {
      return this.wmsClosingTimeService
         .list()
         .stream()
         .map(wmsClosingTime -> BeanUtil.copy(wmsClosingTime, WmsClosingTimeDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public boolean setWmsClosingTime(MonthTimeRangeDTOParam monthTimeRangeDTOParam) {
      WeightedExecutionPriceConf weightedExecutionPriceConf = JSON.parseObject(
         this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权执行方式配置")).getValue(),
         WeightedExecutionPriceConf.class
      );
      Preconditions.checkArgument(weightedExecutionPriceConf.getWeightedExecutionType() == WeightedPriceTypeEnum.USER.getType(), "关账模式设置为月末关账不能手工关账");
      Preconditions.checkArgument(
         monthTimeRangeDTOParam != null && monthTimeRangeDTOParam.getDateTimeList() != null
            && monthTimeRangeDTOParam.getDateTimeList().size() == 2
            && monthTimeRangeDTOParam.getDateTimeList().get(0) != null && monthTimeRangeDTOParam.getDateTimeList().get(1) != null,
         "请选择完整的关账起止时间"
      );
      Preconditions.checkArgument(StrUtil.isNotBlank(monthTimeRangeDTOParam.getName()) && monthTimeRangeDTOParam.getName().length() <= 50, "请输入50字以内的关账名称");
      LocalDateTime startTime = monthTimeRangeDTOParam.getDateTimeList().get(0);
      LocalDateTime endTime = monthTimeRangeDTOParam.getDateTimeList().get(1);
      Preconditions.checkArgument(!endTime.isBefore(startTime), "关账结束时间不能早于开始时间");
      Preconditions.checkArgument(endTime.toLocalDate().isBefore(LocalDate.now()), "关账结束日期最迟需为昨日");
      BasicConfig basicConfig = this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置"));
      List<WmsClosingTime> list = this.wmsClosingTimeService.list();
      if (CollectionUtil.isEmpty(list)) {
         LocalDateTime firstInboundTime = this.inboundDetailMapper.getFirstApprovedInboundTime();
         if (firstInboundTime != null && startTime.isAfter(firstInboundTime)) {
            Preconditions.checkArgument(false, "关账开始时间不能在初次入库时间之后,初次入库时间为[" + firstInboundTime + "]");
         }
      }

      WeightedPriceConf weightedPriceConf = JSON.parseObject(basicConfig.getValue(), WeightedPriceConf.class);
      MonthTimeRange monthTimeRange = new MonthTimeRange();
      monthTimeRange.setStartTime(monthTimeRangeDTOParam.getDateTimeList().get(0));
      monthTimeRange.setEndTime(monthTimeRangeDTOParam.getDateTimeList().get(1));
      monthTimeRange.setName(monthTimeRangeDTOParam.getName());
      this.wmsClosingTimeService.checkBoolWmsClosing();
      this.materialScheduleBiz.calculateAveragePriceUser(monthTimeRange, weightedPriceConf);
      this.materialScheduleBiz.virtualOutbound(monthTimeRange);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void calculateAveragePrice(MonthTimeRange monthTimeRange, WeightedPriceConf weightedPriceConf) {
      try {
         List<MaterialInventory> materialInventoryList = this.materialInventoryMapper
            .selectList((Wrapper<MaterialInventory>)Wrappers.<MaterialInventory>lambdaQuery().eq(MaterialInventory::getUseStatus, true));
         if (WeightedPriceEnum.WHOLE.getType().equals(weightedPriceConf.getWeightedType())) {
            if (CollectionUtil.isNotEmpty(materialInventoryList)) {
               for (MaterialInventory materialInventory : materialInventoryList) {
                  WholeWeightedAveragePrice whole = this.wholeWAPMapper.getPrice(materialInventory);
                  Statistics statistics = this.statisticsMapper.get(materialInventory);
                  BigDecimal mete = materialInventory.getMete().negate();
                  BigDecimal p = mete.divide(whole.getMete(), 20, RoundingMode.HALF_UP);
                  BigDecimal amount = whole.getAmount().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
                  BigDecimal amountExcludingVat = whole.getAmountExcludingVat().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
                  BigDecimal amountNoFreight = whole.getAmountNoFreight().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
                  BigDecimal amountExcludingVatNoFreight = whole.getAmountExcludingVatNoFreight()
                     .multiply(p)
                     .setScale(this.amountAccuracy, RoundingMode.HALF_UP);
                  this.getSupplement(materialInventory, statistics, mete, amount, amountExcludingVat, amountNoFreight, amountExcludingVatNoFreight);
                  this.materialInventoryMapper.deleteById(materialInventory);
                  whole.setMete(whole.getMete().add(mete));
                  whole.setAmount(whole.getAmount().add(amount).setScale(this.amountAccuracy, RoundingMode.HALF_UP));
                  whole.setAmountExcludingVat(whole.getAmountExcludingVat().add(amountExcludingVat).setScale(this.amountAccuracy, RoundingMode.HALF_UP));
                  whole.setAmountNoFreight(whole.getAmountNoFreight().add(amountNoFreight).setScale(this.amountAccuracy, RoundingMode.HALF_UP));
                  whole.setAmountExcludingVatNoFreight(
                     whole.getAmountExcludingVatNoFreight().add(amountExcludingVatNoFreight).setScale(this.amountAccuracy, RoundingMode.HALF_UP)
                  );
                  if (whole.getAmount().compareTo(BigDecimal.ZERO) == 0) {
                     this.wholeWAPMapper.deleteById(whole);
                  } else {
                     this.wholeWAPMapper.updateById(whole);
                  }

                  MonthWeightedAveragePrice averagePrice = this.monthWAPMapper.getPrice(materialInventory);
                  averagePrice.setMete(averagePrice.getMete().add(mete));
                  if (averagePrice.getMete().compareTo(BigDecimal.ZERO) == 0) {
                     this.monthWAPMapper.deleteById(averagePrice);
                  } else {
                     this.monthWAPMapper.updateById(averagePrice);
                  }
               }
            }

            TimeUnit.MINUTES.sleep(31L);

            for (WholeWeightedAveragePrice wholeWAP : this.wholeWAPMapper.selectList(null)) {
               BigDecimal surplusQuantity = BigDecimal.ZERO;
               BigDecimal surplusMete = BigDecimal.ZERO;
               BigDecimal surplusAmount = BigDecimal.ZERO;
               BigDecimal surplusAmountExcludingVat = BigDecimal.ZERO;
               BigDecimal surplusAmountNoFreight = BigDecimal.ZERO;
               BigDecimal surplusAmountExcludingVatNoFreight = BigDecimal.ZERO;
               BigDecimal totalAmount = wholeWAP.getAmount();
               BigDecimal totalAmountExcludingVat = wholeWAP.getAmountExcludingVat();
               BigDecimal totalAmountNoFreight = wholeWAP.getAmountNoFreight();
               BigDecimal totalAmountExcludingVatNoFreight = wholeWAP.getAmountExcludingVatNoFreight();

               for (MonthWeightedAveragePrice monthWAP : this.monthWAPMapper
                  .selectList((Wrapper<MonthWeightedAveragePrice>)Wrappers.<MonthWeightedAveragePrice>lambdaQuery().eq(MonthWeightedAveragePrice::getWholeWapId, wholeWAP.getId()))) {
                  BigDecimal monthMete = monthWAP.getMete();
                  BigDecimal p = monthMete.divide(wholeWAP.getMete(), 20, RoundingMode.HALF_UP);
                  BigDecimal amount = wholeWAP.getAmount().multiply(p);
                  BigDecimal amountExcludingVat = wholeWAP.getAmountExcludingVat().multiply(p);
                  BigDecimal amountNoFreight = wholeWAP.getAmountNoFreight().multiply(p);
                  BigDecimal amountExcludingVatNoFreight = wholeWAP.getAmountExcludingVatNoFreight().multiply(p);
                  BigDecimal subtract = totalAmount.subtract(amount);
                  if (subtract.compareTo(BigDecimal.ONE) < 0) {
                     monthWAP.setAmount(totalAmount);
                     monthWAP.setAmountExcludingVat(totalAmountExcludingVat);
                     monthWAP.setAmountNoFreight(totalAmountNoFreight);
                     monthWAP.setAmountExcludingVatNoFreight(totalAmountExcludingVatNoFreight);
                     this.setWAP(monthWAP, monthTimeRange);
                  } else {
                     totalAmount = subtract;
                     totalAmountExcludingVat = totalAmountExcludingVat.subtract(amountExcludingVat);
                     monthWAP.setAmount(amount);
                     monthWAP.setAmountExcludingVat(amountExcludingVat);
                     monthWAP.setAmountNoFreight(amountNoFreight);
                     monthWAP.setAmountExcludingVatNoFreight(amountExcludingVatNoFreight);
                     this.setWAP(monthWAP, monthTimeRange);
                  }

                  if (monthWAP.getMete().compareTo(BigDecimal.ZERO) == 0) {
                     if (monthWAP.getAmount().compareTo(BigDecimal.ZERO) != 0) {
                        BigDecimal m = monthWAP.getAmount().negate();
                        BigDecimal me = monthWAP.getAmountExcludingVat().negate();
                        BigDecimal mNoFreight = monthWAP.getAmountNoFreight().negate();
                        BigDecimal meNoFreight = monthWAP.getAmountExcludingVatNoFreight().negate();
                        Statistics statistics = this.statisticsMapper
                           .selectOne((Wrapper<Statistics>)Wrappers.<Statistics>lambdaQuery().eq(Statistics::getWapId, monthWAP.getId()));
                        this.getSupplement(BeanUtil.copy(monthWAP, MaterialInventory.class), statistics, null, m, me, mNoFreight, meNoFreight);
                     }

                     this.monthWAPMapper.deleteById(monthWAP);
                  } else {
                     if (!weightedPriceConf.getBoolUpdate()) {
                        surplusQuantity = monthWAP.getQuantity() == null ? surplusQuantity : monthWAP.getQuantity().add(surplusQuantity);
                        surplusMete = monthWAP.getMete() == null ? surplusMete : monthWAP.getMete().add(surplusMete);
                        surplusAmount = monthWAP.getAmount() == null ? surplusAmount : monthWAP.getAmount().add(surplusAmount);
                        surplusAmountExcludingVat = monthWAP.getAmountExcludingVat() == null
                           ? surplusAmountExcludingVat
                           : monthWAP.getAmountExcludingVat().add(surplusAmountExcludingVat);
                        surplusAmountNoFreight = monthWAP.getAmountNoFreight() == null
                           ? surplusAmountNoFreight
                           : monthWAP.getAmountNoFreight().add(surplusAmountNoFreight);
                        surplusAmountExcludingVatNoFreight = monthWAP.getAmountExcludingVatNoFreight() == null
                           ? surplusAmountExcludingVatNoFreight
                           : monthWAP.getAmountExcludingVatNoFreight().add(surplusAmountExcludingVatNoFreight);
                        monthWAP.setAmount(null);
                        monthWAP.setAmountExcludingVat(null);
                        monthWAP.setAmountNoFreight(null);
                        monthWAP.setAmountExcludingVatNoFreight(null);
                     }

                     this.monthWAPMapper.updateById(monthWAP);
                  }
               }

               if (!weightedPriceConf.getBoolUpdate() && surplusMete.compareTo(BigDecimal.ZERO) != 0) {
                  if (wholeWAP.getQuantity() != null) {
                     wholeWAP.setQuantity(surplusQuantity);
                  }

                  wholeWAP.setMete(surplusMete);
                  wholeWAP.setAmount(surplusAmount);
                  wholeWAP.setAmountExcludingVat(surplusAmountExcludingVat);
                  wholeWAP.setAmountNoFreight(surplusAmountNoFreight);
                  wholeWAP.setAmountExcludingVatNoFreight(surplusAmountExcludingVatNoFreight);
                  this.wholeWAPMapper.updateById(wholeWAP);
               } else {
                  this.wholeWAPMapper.deleteById(wholeWAP);
               }
            }
         } else {
            if (CollectionUtil.isNotEmpty(materialInventoryList)) {
               for (MaterialInventory materialInventory : materialInventoryList) {
                  MonthWeightedAveragePrice averagePrice = this.monthWAPMapper.getPrice(materialInventory);
                  Statistics statistics = this.statisticsMapper.get(materialInventory);
                  BigDecimal mete = materialInventory.getMete().negate();
                  BigDecimal p = mete.divide(averagePrice.getMete(), 20, RoundingMode.HALF_UP);
                  BigDecimal amount = averagePrice.getAmount().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
                  BigDecimal amountExcludingVat = averagePrice.getAmountExcludingVat().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
                  BigDecimal amountNoFreight = averagePrice.getAmountNoFreight().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
                  BigDecimal amountExcludingVatNoFreight = averagePrice.getAmountExcludingVatNoFreight()
                     .multiply(p)
                     .setScale(this.amountAccuracy, RoundingMode.HALF_UP);
                  Supplement supplement = this.getSupplement(
                     materialInventory, statistics, mete, amount, amountExcludingVat, amountNoFreight, amountExcludingVatNoFreight
                  );
                  this.materialInventoryMapper.deleteById(materialInventory);
                  averagePrice.setMete(averagePrice.getMete().add(mete));
                  averagePrice.setAmount(averagePrice.getAmount().add(amount).setScale(this.amountAccuracy, RoundingMode.HALF_UP));
                  averagePrice.setAmountExcludingVat(
                     averagePrice.getAmountExcludingVat().add(amountExcludingVat).setScale(this.amountAccuracy, RoundingMode.HALF_UP)
                  );
                  averagePrice.setAmountNoFreight(averagePrice.getAmountNoFreight().add(amountNoFreight).setScale(this.amountAccuracy, RoundingMode.HALF_UP));
                  averagePrice.setAmountExcludingVatNoFreight(
                     averagePrice.getAmountExcludingVatNoFreight().add(amountExcludingVatNoFreight).setScale(this.amountAccuracy, RoundingMode.HALF_UP)
                  );
                  if (averagePrice.getMete().compareTo(BigDecimal.ZERO) == 0) {
                     this.monthWAPMapper.deleteById(averagePrice);
                  } else {
                     this.monthWAPMapper.updateById(averagePrice);
                  }
               }
            }

            TimeUnit.MINUTES.sleep(31L);

            for (MonthWeightedAveragePrice monthWAP : this.monthWAPMapper.selectList(null)) {
               if (this.retireClosedProjectPrice(monthWAP, monthTimeRange)) {
                  continue;
               }
               if (monthWAP.getMete().compareTo(BigDecimal.ZERO) != 0) {
                  this.setWAP(monthWAP, monthTimeRange);
               }

               if (monthWAP.getMete().compareTo(BigDecimal.ZERO) == 0 && monthWAP.getAmount().compareTo(BigDecimal.ZERO) != 0) {
                  BigDecimal m = monthWAP.getAmount().negate();
                  BigDecimal me = monthWAP.getAmountExcludingVat().negate();
                  BigDecimal mNoFreight = monthWAP.getAmountNoFreight().negate();
                  BigDecimal meNoFreight = monthWAP.getAmountExcludingVatNoFreight().negate();
                  Statistics statistics = this.statisticsMapper
                     .selectOne((Wrapper<Statistics>)Wrappers.<Statistics>lambdaQuery().eq(Statistics::getWapId, monthWAP.getId()));
                  this.getSupplement(BeanUtil.copy(monthWAP, MaterialInventory.class), statistics, null, m, me, mNoFreight, meNoFreight);
               }

               if (weightedPriceConf.getBoolUpdate() && monthWAP.getMete().compareTo(BigDecimal.ZERO) > 0) {
                  WholeWeightedAveragePrice wholeWAPMapperPrice = this.wholeWAPMapper
                     .getPrice(
                        MaterialInventory.builder()
                           .classifyId(monthWAP.getClassifyId())
                           .basicClass(monthWAP.getBasicClass())
                           .weightedAverageSpec(monthWAP.getSpecification())
                           .thickness(monthWAP.getThickness())
                           .heatNoAndBatchNo(monthWAP.getHeatNoAndBatchNo())
                           .color(monthWAP.getColor())
                           .brand(monthWAP.getBrand())
                           .quantity(monthWAP.getQuantity())
                           .mete(monthWAP.getMete())
                           .accountingUnit(monthWAP.getAccountingUnit())
                           .boolPartyA(monthWAP.getBoolPartyA())
                           .unitNet(monthWAP.getUnitNet())
                           .taxRate(monthWAP.getTaxRate())
                           .invoiceType(monthWAP.getInvoiceType())
                           .standardId(monthWAP.getStandardId())
                           .standardName(monthWAP.getStandardName())
                           .build()
                     );
                  if (wholeWAPMapperPrice != null) {
                     if (monthWAP.getQuantity() != null) {
                        wholeWAPMapperPrice.setQuantity(monthWAP.getQuantity().add(wholeWAPMapperPrice.getQuantity()));
                     }

                     wholeWAPMapperPrice.setMete(wholeWAPMapperPrice.getMete().add(monthWAP.getMete()));
                     wholeWAPMapperPrice.setAmount(
                        wholeWAPMapperPrice.getAmount().add(monthWAP.getAmount()).setScale(this.amountAccuracy, RoundingMode.HALF_UP)
                     );
                     wholeWAPMapperPrice.setAmountExcludingVat(
                        wholeWAPMapperPrice.getAmountExcludingVat().add(monthWAP.getAmountExcludingVat()).setScale(this.amountAccuracy, RoundingMode.HALF_UP)
                     );
                     wholeWAPMapperPrice.setAmountNoFreight(
                        wholeWAPMapperPrice.getAmountNoFreight().add(monthWAP.getAmountNoFreight()).setScale(this.amountAccuracy, RoundingMode.HALF_UP)
                     );
                     wholeWAPMapperPrice.setAmountExcludingVatNoFreight(
                        wholeWAPMapperPrice.getAmountExcludingVatNoFreight()
                           .add(monthWAP.getAmountExcludingVatNoFreight())
                           .setScale(this.amountAccuracy, RoundingMode.HALF_UP)
                     );
                     this.wholeWAPMapper.updateById(wholeWAPMapperPrice);
                  } else {
                     wholeWAPMapperPrice = WholeWeightedAveragePrice.builder()
                        .classifyId(monthWAP.getClassifyId())
                        .basicClass(monthWAP.getBasicClass())
                        .specification(monthWAP.getSpecification())
                        .thickness(monthWAP.getThickness())
                        .heatNoAndBatchNo(monthWAP.getHeatNoAndBatchNo())
                        .color(monthWAP.getColor())
                        .brand(monthWAP.getBrand())
                        .accountingUnit(monthWAP.getAccountingUnit())
                        .boolPartyA(monthWAP.getBoolPartyA())
                        .unitNet(monthWAP.getUnitNet())
                        .taxRate(monthWAP.getTaxRate())
                        .invoiceType(monthWAP.getInvoiceType())
                        .standardId(monthWAP.getStandardId())
                        .standardName(monthWAP.getStandardName())
                        .quantity(monthWAP.getQuantity())
                        .mete(monthWAP.getMete())
                        .amount(monthWAP.getAmount().setScale(this.amountAccuracy, 4))
                        .amountExcludingVat(monthWAP.getAmountExcludingVat().setScale(this.amountAccuracy, 4))
                        .amountNoFreight(monthWAP.getAmountNoFreight().setScale(this.amountAccuracy, 4))
                        .amountExcludingVatNoFreight(monthWAP.getAmountExcludingVatNoFreight().setScale(this.amountAccuracy, 4))
                        .build();
                     this.wholeWAPMapper.insert(wholeWAPMapperPrice);
                  }

                  monthWAP.setWholeWapId(wholeWAPMapperPrice.getId());
                  monthWAP.setAmount(null);
                  monthWAP.setAmountExcludingVat(null);
                  monthWAP.setAmountNoFreight(null);
                  monthWAP.setAmountExcludingVatNoFreight(null);
               }

               if (monthWAP.getMete().compareTo(BigDecimal.ZERO) > 0) {
                  this.monthWAPMapper.updateById(monthWAP);
               } else {
                  this.monthWAPMapper.deleteById(monthWAP);
               }
            }
         }
      } catch (Throwable $ex) {
         throw ReportServiceImpl.<RuntimeException>rethrow($ex);
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void calculateAveragePriceUser(MonthTimeRange monthTimeRange, WeightedPriceConf weightedPriceConf) {
      try {
         List<MaterialInventory> materialInventoryList = this.materialInventoryMapper
            .selectList((Wrapper<MaterialInventory>)Wrappers.<MaterialInventory>lambdaQuery().eq(MaterialInventory::getUseStatus, true));
         WmsClosingTime one = this.wmsClosingTimeService
            .getOne(
               (Wrapper<WmsClosingTime>)((new LambdaQueryWrapper<WmsClosingTime>()
                        .lt(WmsClosingTime::getId, monthTimeRange.getWmsClosingTimeId()))
                     .orderByDesc(WmsClosingTime::getId))
                  .last("limit 1")
            );
         if (WeightedPriceEnum.WHOLE.getType().equals(weightedPriceConf.getWeightedType())) {
            if (CollectionUtil.isNotEmpty(materialInventoryList)) {
               for (MaterialInventory materialInventory : materialInventoryList) {
                  WholeWeightedAveragePrice whole = this.wholeWAPMapper.getPrice(materialInventory);
                  Statistics statistics = this.statisticsMapper.get(materialInventory);
                  BigDecimal mete = materialInventory.getMete().negate();
                  BigDecimal p = mete.divide(whole.getMete(), 20, RoundingMode.HALF_UP);
                  BigDecimal amount = whole.getAmount().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
                  BigDecimal amountExcludingVat = whole.getAmountExcludingVat().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
                  BigDecimal amountNoFreight = whole.getAmountNoFreight().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
                  BigDecimal amountExcludingVatNoFreight = whole.getAmountExcludingVatNoFreight()
                     .multiply(p)
                     .setScale(this.amountAccuracy, RoundingMode.HALF_UP);
                  this.getSupplement1(
                     materialInventory, statistics, mete, amount, amountExcludingVat, amountNoFreight, amountExcludingVatNoFreight, monthTimeRange
                  );
                  this.materialInventoryMapper.deleteById(materialInventory);
                  whole.setMete(whole.getMete().add(mete));
                  whole.setAmount(whole.getAmount().add(amount).setScale(this.amountAccuracy, RoundingMode.HALF_UP));
                  whole.setAmountExcludingVat(whole.getAmountExcludingVat().add(amountExcludingVat).setScale(this.amountAccuracy, RoundingMode.HALF_UP));
                  whole.setAmountNoFreight(whole.getAmountNoFreight().add(amountNoFreight).setScale(this.amountAccuracy, RoundingMode.HALF_UP));
                  whole.setAmountExcludingVatNoFreight(
                     whole.getAmountExcludingVatNoFreight().add(amountExcludingVatNoFreight).setScale(this.amountAccuracy, RoundingMode.HALF_UP)
                  );
                  MonthWeightedAveragePrice averagePrice = this.monthWAPMapper.getPrice(materialInventory);
                  averagePrice.setMete(averagePrice.getMete().add(mete));
                  this.monthWAPMapper.updateById(averagePrice);
               }
            }

            for (WholeWeightedAveragePrice wholeWAP : this.wholeWAPMapper.selectList(null)) {
               WholeWeightedAveragePrice whole = this.getWhole(wholeWAP, monthTimeRange);
               BigDecimal surplusQuantity = BigDecimal.ZERO;
               BigDecimal surplusMete = BigDecimal.ZERO;
               BigDecimal surplusAmount = BigDecimal.ZERO;
               BigDecimal surplusAmountExcludingVat = BigDecimal.ZERO;
               BigDecimal surplusAmountNoFreight = BigDecimal.ZERO;
               BigDecimal surplusAmountExcludingVatNoFreight = BigDecimal.ZERO;
               BigDecimal mete = whole.getMete();
               BigDecimal monthAmount = whole.getAmount();
               BigDecimal monthAmountExcludingVat = whole.getAmountExcludingVat();
               BigDecimal monthAmountNoFreight = whole.getAmountNoFreight();
               BigDecimal monthAmountExcludingVatNoFreight = whole.getAmountExcludingVatNoFreight();

               for (MonthWeightedAveragePrice monthWAP : this.monthWAPMapper
                  .selectList((Wrapper<MonthWeightedAveragePrice>)Wrappers.<MonthWeightedAveragePrice>lambdaQuery().eq(MonthWeightedAveragePrice::getWholeWapId, wholeWAP.getId()))) {
                  BigDecimal monthMete = monthWAP.getMete();
                  BigDecimal p = monthMete.divide(mete, 20, RoundingMode.HALF_UP);
                  BigDecimal amount = monthAmount.multiply(p);
                  BigDecimal amountExcludingVat = monthAmountExcludingVat.multiply(p);
                  BigDecimal amountNoFreight = monthAmountNoFreight.multiply(p);
                  BigDecimal amountExcludingVatNoFreight = monthAmountExcludingVatNoFreight.multiply(p);
                  MonthWeightedAveragePrice monthWAP2 = this.getMothWap(monthWAP, monthTimeRange, one);
                  MonthWeightedAveragePrice monthWAP1 = BeanUtil.copy(monthWAP2, MonthWeightedAveragePrice.class);
                  monthWAP1.setAmount(amount);
                  monthWAP1.setAmountExcludingVat(amountExcludingVat);
                  monthWAP1.setAmountNoFreight(amountNoFreight);
                  monthWAP1.setAmountExcludingVatNoFreight(amountExcludingVatNoFreight);
                  mete = mete.subtract(monthMete);
                  monthAmount = monthAmount.subtract(amount);
                  monthAmountExcludingVat = monthAmountExcludingVat.subtract(amountExcludingVat);
                  monthAmountNoFreight = monthAmountNoFreight.subtract(amountNoFreight);
                  monthAmountExcludingVatNoFreight = monthAmountExcludingVatNoFreight.subtract(amountExcludingVatNoFreight);
                  if (monthWAP1.getMete().compareTo(BigDecimal.ZERO) != 0) {
                     this.setWAPUser(monthWAP1, monthTimeRange);
                  }

                  this.getFutureMothWap(monthWAP1, monthTimeRange);
                  if (!weightedPriceConf.getBoolUpdate()) {
                     surplusQuantity = monthWAP1.getQuantity() == null ? surplusQuantity : monthWAP1.getQuantity().add(surplusQuantity);
                     surplusMete = monthWAP1.getMete() == null ? surplusMete : monthWAP1.getMete().add(surplusMete);
                     surplusAmount = monthWAP1.getAmount() == null ? surplusAmount : monthWAP1.getAmount().add(surplusAmount);
                     surplusAmountExcludingVat = monthWAP1.getAmountExcludingVat() == null
                        ? surplusAmountExcludingVat
                        : monthWAP1.getAmountExcludingVat().add(surplusAmountExcludingVat);
                     surplusAmountNoFreight = monthWAP1.getAmountNoFreight() == null
                        ? surplusAmountNoFreight
                        : monthWAP1.getAmountNoFreight().add(surplusAmountNoFreight);
                     surplusAmountExcludingVatNoFreight = monthWAP1.getAmountExcludingVatNoFreight() == null
                        ? surplusAmountExcludingVatNoFreight
                        : monthWAP1.getAmountExcludingVatNoFreight().add(surplusAmountExcludingVatNoFreight);
                  }

                  this.monthWAPMapper.updateById(monthWAP1);
               }

               if (weightedPriceConf.getBoolUpdate()) {
                  this.wholeWAPMapper.deleteById(wholeWAP);
               } else {
                  if (wholeWAP.getQuantity() != null) {
                     wholeWAP.setQuantity(surplusQuantity);
                  }

                  wholeWAP.setMete(surplusMete);
                  wholeWAP.setAmount(surplusAmount);
                  wholeWAP.setAmountExcludingVat(surplusAmountExcludingVat);
                  wholeWAP.setAmountNoFreight(surplusAmountNoFreight);
                  wholeWAP.setAmountExcludingVatNoFreight(surplusAmountExcludingVatNoFreight);
                  this.wholeWAPMapper.updateById(wholeWAP);
               }
            }
         } else {
            if (CollectionUtil.isNotEmpty(materialInventoryList)) {
               for (MaterialInventory materialInventory : materialInventoryList) {
                  MonthWeightedAveragePrice averagePrice1 = this.monthWAPMapper.getPrice(materialInventory);
                  MonthWeightedAveragePrice averagePrice = this.getMothWap(averagePrice1, monthTimeRange, one);
                  Statistics statistics = this.statisticsMapper.get(materialInventory);
                  BigDecimal mete = materialInventory.getMete().negate();
                  BigDecimal p = mete.divide(averagePrice.getMete(), 20, RoundingMode.HALF_UP);
                  BigDecimal amount = averagePrice.getAmount().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
                  BigDecimal amountExcludingVat = averagePrice.getAmountExcludingVat().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
                  BigDecimal amountNoFreight = averagePrice.getAmountNoFreight().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
                  BigDecimal amountExcludingVatNoFreight = averagePrice.getAmountExcludingVatNoFreight()
                     .multiply(p)
                     .setScale(this.amountAccuracy, RoundingMode.HALF_UP);
                  Supplement supplement1 = this.getSupplement1(
                     materialInventory, statistics, mete, amount, amountExcludingVat, amountNoFreight, amountExcludingVatNoFreight, monthTimeRange
                  );
                  this.materialInventoryMapper.deleteById(materialInventory);
                  averagePrice1.setMete(averagePrice1.getMete().add(mete));
                  averagePrice1.setAmount(averagePrice1.getAmount().add(amount).setScale(this.amountAccuracy, RoundingMode.HALF_UP));
                  averagePrice1.setAmountExcludingVat(
                     averagePrice1.getAmountExcludingVat().add(amountExcludingVat).setScale(this.amountAccuracy, RoundingMode.HALF_UP)
                  );
                  averagePrice1.setAmountNoFreight(averagePrice1.getAmountNoFreight().add(amountNoFreight).setScale(this.amountAccuracy, RoundingMode.HALF_UP));
                  averagePrice1.setAmountExcludingVatNoFreight(
                     averagePrice1.getAmountExcludingVatNoFreight().add(amountExcludingVatNoFreight).setScale(this.amountAccuracy, RoundingMode.HALF_UP)
                  );
                  this.monthWAPMapper.updateById(averagePrice1);
               }
            }

            for (MonthWeightedAveragePrice monthWAP : this.monthWAPMapper.selectList(null)) {
               MonthWeightedAveragePrice monthWAP1 = this.getMothWap(monthWAP, monthTimeRange, one);
               if (monthWAP1.getMete().compareTo(BigDecimal.ZERO) != 0) {
                  this.setWAPUser(monthWAP1, monthTimeRange);
               }

               MonthWeightedAveragePrice futureMothWap = this.getFutureMothWap(monthWAP1, monthTimeRange);
               if (futureMothWap.getMete().compareTo(BigDecimal.ZERO) <= 0 && futureMothWap.getAmountExcludingVat().compareTo(BigDecimal.ZERO) == 0) {
                  this.monthWAPMapper.deleteById(futureMothWap);
               } else {
                  this.monthWAPMapper.updateById(futureMothWap);
               }
            }
         }
      } catch (Throwable $ex) {
         throw ReportServiceImpl.<RuntimeException>rethrow($ex);
      }
   }

   private boolean retireClosedProjectPrice(MonthWeightedAveragePrice price, MonthTimeRange period) {
      if (price.getProjectId() == null || price.getWholeWapId() != null) {
         return false;
      }

      Long priceId = price.getId();
      if (this.statisticsMapper.selectCount(Wrappers.<Statistics>lambdaQuery().eq(Statistics::getWapId, priceId)) > 0) {
         return false;
      }

      // A closed group can retain its weighted row after all inventory has been issued.
      StatisticsMonthRecord closed = this.statisticsMonthRecordMapper.selectOne(Wrappers.<StatisticsMonthRecord>lambdaQuery()
         .eq(StatisticsMonthRecord::getWapId, priceId)
         .orderByDesc(StatisticsMonthRecord::getId)
         .last("LIMIT 1"));
      Preconditions.checkState(closed != null && closed.getEndMete() != null && closed.getEndMete().signum() == 0,
         "项目加权记录 %s 缺少当前统计且无法确认结清", priceId);
      LocalDateTime closedThrough = closed.getUpdateTime();
      if (closed.getWmsClosingTimeId() != null) {
         WmsClosingTime closing = this.wmsClosingTimeService.getById(closed.getWmsClosingTimeId());
         closedThrough = closing == null ? null : closing.getEndTime();
      }
      Preconditions.checkState(closedThrough != null && closedThrough.isBefore(period.getStartTime()),
         "项目加权记录 %s 的已关账期间与本次月结重叠", priceId);

      List<MaterialInventory> inventory = this.materialInventoryMapper.selectList(Wrappers.<MaterialInventory>lambdaQuery()
         .eq(MaterialInventory::getProjectId, price.getProjectId())
         .eq(MaterialInventory::getBasicClass, price.getBasicClass())
         .eq(MaterialInventory::getClassifyId, price.getClassifyId()));
      for (MaterialInventory item : inventory) {
         MonthWeightedAveragePrice current = this.monthWAPMapper.getPrice(item);
         Preconditions.checkState(current == null || !priceId.equals(current.getId()),
            "项目加权记录 %s 仍关联库存 %s，无法自动清理", priceId, item.getId());
      }
      this.monthWAPMapper.deleteById(priceId);
      return true;
   }

   private void setWAP(MonthWeightedAveragePrice record, MonthTimeRange monthTimeRange) {
      BigDecimal amount = record.getAmount();
      BigDecimal amountExcludingVat = record.getAmountExcludingVat();
      BigDecimal amountNoFreight = record.getAmountNoFreight();
      BigDecimal amountExcludingVatNoFreight = record.getAmountExcludingVatNoFreight();
      BigDecimal mete = record.getMete();
      BigDecimal avgPrice = NumberUtil.div(amount, mete, 12);
      BigDecimal excludingVatAvgPrice = NumberUtil.div(amountExcludingVat, mete, 12);
      BigDecimal avgPriceNoFreight = NumberUtil.div(amountNoFreight, mete, 12);
      BigDecimal excludingVatAvgPriceNoFreight = NumberUtil.div(amountExcludingVatNoFreight, mete, 12);
      ArrayList<Integer> outboundTypeSelection = new ArrayList<>();
      outboundTypeSelection.add(2);
      outboundTypeSelection.add(4);
      outboundTypeSelection.add(16);
      List<MoveOutboundDetail> outList = this.outboundDetailMapper.queryCurrentMonthZi(record.getId(), monthTimeRange, null, outboundTypeSelection);
      BigDecimal tempOutMeteSum = BigDecimal.ZERO;
      BigDecimal tempOutAmountSum = BigDecimal.ZERO;
      BigDecimal tempUnOutAmountSum = BigDecimal.ZERO;
      BigDecimal tempOutAmountSumNoFreight = BigDecimal.ZERO;
      BigDecimal tempUnOutAmountSumNoFreight = BigDecimal.ZERO;

      for (MoveOutboundDetail out : outList) {
         out.setUnitPrice(avgPrice);
         out.setUnitPriceExcludingVat(excludingVatAvgPrice);
         out.setUnitPriceNoFreight(avgPriceNoFreight);
         out.setUnitPriceExcludingVatNoFreight(excludingVatAvgPriceNoFreight);
         BigDecimal totalPrice = BigDecimal.ZERO;
         BigDecimal unTotalPrice = BigDecimal.ZERO;
         BigDecimal totalPriceNoFreight = BigDecimal.ZERO;
         BigDecimal unTotalPriceNoFreight = BigDecimal.ZERO;
         BigDecimal tempMete = mete.subtract(tempOutMeteSum);
         if (out.getMete().doubleValue() != 0.0
            && mete.doubleValue() != 0.0
            && amount.doubleValue() != 0.0
            && amountExcludingVat.doubleValue() != 0.0
            && tempMete.doubleValue() != 0.0) {
            totalPrice = NumberUtil.round(NumberUtil.mul(NumberUtil.div(out.getMete(), tempMete), NumberUtil.sub(amount, tempOutAmountSum)), 2);
            unTotalPrice = NumberUtil.round(NumberUtil.mul(NumberUtil.div(out.getMete(), tempMete), NumberUtil.sub(amountExcludingVat, tempUnOutAmountSum)), 2);
            totalPriceNoFreight = NumberUtil.round(
               NumberUtil.mul(NumberUtil.div(out.getMete(), tempMete), NumberUtil.sub(amountNoFreight, tempOutAmountSumNoFreight)), 2
            );
            unTotalPriceNoFreight = NumberUtil.round(
               NumberUtil.mul(NumberUtil.div(out.getMete(), tempMete), NumberUtil.sub(amountExcludingVatNoFreight, tempUnOutAmountSumNoFreight)), 2
            );
            tempOutMeteSum = NumberUtil.add(tempOutMeteSum, out.getMete());
            tempOutAmountSum = NumberUtil.add(tempOutAmountSum, totalPrice);
            tempUnOutAmountSum = NumberUtil.add(tempUnOutAmountSum, unTotalPrice);
            tempOutAmountSumNoFreight = NumberUtil.add(tempOutAmountSumNoFreight, totalPriceNoFreight);
            tempUnOutAmountSumNoFreight = NumberUtil.add(tempUnOutAmountSumNoFreight, unTotalPriceNoFreight);
         }

         out.setAmount(totalPrice);
         out.setAmountExcludingVat(unTotalPrice);
         out.setAmountNoFreight(totalPriceNoFreight);
         out.setAmountExcludingVatNoFreight(unTotalPriceNoFreight);
         if (InvoiceTypeEnum.SPECIAL.getType().equals(out.getInvoiceType())) {
            out.setInputVat(out.getAmount().subtract(out.getAmountExcludingVat()));
            out.setInputVatNoFreight(out.getAmountNoFreight().subtract(out.getAmountExcludingVatNoFreight()));
         }

         this.outboundDetailMapper.updateById(out);
         if (record.getQuantity() != null) {
            if (BasicClassEnum.COLOR_ROLL.getType().equals(out.getBasicClass()) && out.getLength() != null) {
               record.setQuantity(record.getQuantity().subtract(out.getLength()));
            } else {
               record.setQuantity(record.getQuantity().subtract(out.getQuantity()));
            }
         }

         record.setMete(record.getMete().subtract(out.getMete()));
         if (record.getAmount() != null) {
            record.setAmount(record.getAmount().subtract(out.getAmount()));
            record.setAmountExcludingVat(record.getAmountExcludingVat().subtract(out.getAmountExcludingVat()));
         }

         if (record.getAmountNoFreight() != null) {
            record.setAmountNoFreight(record.getAmountNoFreight().subtract(out.getAmountNoFreight()));
            record.setAmountExcludingVatNoFreight(record.getAmountExcludingVatNoFreight().subtract(out.getAmountExcludingVatNoFreight()));
         }

         for (MaterialReturnable returnable : this.materialReturnableMapper
            .selectList((Wrapper<MaterialReturnable>)new LambdaQueryWrapper<MaterialReturnable>().eq(MaterialReturnable::getOutboundDetailId, out.getId()))) {
            returnable.setUnitPrice(avgPrice);
            returnable.setUnitPriceExcludingVat(excludingVatAvgPrice);
            returnable.setAmount(totalPrice);
            returnable.setAmountExcludingVat(unTotalPrice);
            returnable.setUnitPriceNoFreight(avgPriceNoFreight);
            returnable.setUnitPriceExcludingVatNoFreight(excludingVatAvgPriceNoFreight);
            returnable.setAmountNoFreight(totalPriceNoFreight);
            returnable.setAmountExcludingVatNoFreight(unTotalPriceNoFreight);
            this.materialReturnableMapper.updateById(returnable);
            List<ReturnDetail> returnList = this.returnDetailMapper.queryCurrentMonth(returnable.getId(), monthTimeRange, null);
            long tempId = 0L;
            BigDecimal tempReturnMeteSum = BigDecimal.ZERO;
            BigDecimal tempReturnAmountSum = BigDecimal.ZERO;
            BigDecimal unTempReturnAmountSum = BigDecimal.ZERO;
            BigDecimal tempReturnAmountSumNoFreight = BigDecimal.ZERO;
            BigDecimal unTempReturnAmountSumNoFreight = BigDecimal.ZERO;

            for (ReturnDetail r : returnList) {
               if (tempId != r.getMaterialReturnableId()) {
                  tempReturnMeteSum = BigDecimal.ZERO;
                  tempReturnAmountSum = BigDecimal.ZERO;
                  unTempReturnAmountSum = BigDecimal.ZERO;
                  tempReturnAmountSumNoFreight = BigDecimal.ZERO;
                  unTempReturnAmountSumNoFreight = BigDecimal.ZERO;
               }

               MaterialReturnable materialReturnable = this.materialReturnableMapper.selectById(r.getMaterialReturnableId());
               r.setUnitPrice(avgPrice);
               r.setUnitPriceExcludingVat(excludingVatAvgPrice);
               r.setUnitPriceNoFreight(avgPriceNoFreight);
               r.setUnitPriceExcludingVatNoFreight(excludingVatAvgPriceNoFreight);
               BigDecimal totalRePrice = BigDecimal.ZERO;
               BigDecimal unTotalRePrice = BigDecimal.ZERO;
               BigDecimal totalRePriceNoFreight = BigDecimal.ZERO;
               BigDecimal unTotalRePriceNoFreight = BigDecimal.ZERO;
               BigDecimal tempReMete = NumberUtil.sub(materialReturnable.getMete(), tempReturnMeteSum);
               if (r.getMete().doubleValue() != 0.0
                  && materialReturnable.getMete().doubleValue() != 0.0
                  && materialReturnable.getAmount().doubleValue() != 0.0
                  && materialReturnable.getAmountExcludingVat().doubleValue() != 0.0
                  && tempReMete.doubleValue() != 0.0) {
                  totalRePrice = NumberUtil.round(
                     NumberUtil.mul(NumberUtil.div(r.getMete(), tempReMete), NumberUtil.sub(out.getAmount(), tempReturnAmountSum)), 2
                  );
                  unTotalRePrice = NumberUtil.round(
                     NumberUtil.mul(NumberUtil.div(r.getMete(), tempReMete), NumberUtil.sub(out.getAmountExcludingVat(), unTempReturnAmountSum)), 2
                  );
                  tempReturnMeteSum = NumberUtil.add(tempReturnMeteSum, r.getMete());
                  tempReturnAmountSum = NumberUtil.add(tempReturnAmountSum, totalRePrice);
                  unTempReturnAmountSum = NumberUtil.add(unTempReturnAmountSum, unTotalRePrice);
               }

               if (r.getMete().doubleValue() != 0.0
                  && materialReturnable.getMete().doubleValue() != 0.0
                  && materialReturnable.getAmountNoFreight().doubleValue() != 0.0
                  && materialReturnable.getAmountExcludingVatNoFreight().doubleValue() != 0.0
                  && tempReMete.doubleValue() != 0.0) {
                  totalRePriceNoFreight = NumberUtil.round(
                     NumberUtil.mul(NumberUtil.div(r.getMete(), tempReMete), NumberUtil.sub(out.getAmountNoFreight(), tempReturnAmountSumNoFreight)), 2
                  );
                  unTotalRePriceNoFreight = NumberUtil.round(
                     NumberUtil.mul(
                        NumberUtil.div(r.getMete(), tempReMete), NumberUtil.sub(out.getAmountExcludingVatNoFreight(), unTempReturnAmountSumNoFreight)
                     ),
                     2
                  );
                  tempReturnAmountSumNoFreight = NumberUtil.add(tempReturnAmountSumNoFreight, totalRePriceNoFreight);
                  unTempReturnAmountSumNoFreight = NumberUtil.add(unTempReturnAmountSumNoFreight, unTotalRePriceNoFreight);
               }

               r.setAmount(totalRePrice);
               r.setAmountExcludingVat(unTotalRePrice);
               r.setAmountNoFreight(totalRePriceNoFreight);
               r.setAmountExcludingVatNoFreight(unTotalRePriceNoFreight);
               materialReturnable.setAmount(NumberUtil.sub(materialReturnable.getAmount(), totalRePrice));
               materialReturnable.setAmountExcludingVat(NumberUtil.sub(materialReturnable.getAmountExcludingVat(), unTotalRePrice));
               materialReturnable.setAmountNoFreight(NumberUtil.sub(materialReturnable.getAmountNoFreight(), totalRePrice));
               materialReturnable.setAmountExcludingVatNoFreight(NumberUtil.sub(materialReturnable.getAmountExcludingVatNoFreight(), unTotalRePrice));
               this.materialReturnableMapper.updateById(materialReturnable);
               if (InvoiceTypeEnum.SPECIAL.getType().equals(r.getInvoiceType())) {
                  r.setInputVat(r.getAmount().subtract(r.getAmountExcludingVat()));
                  r.setInputVatNoFreight(r.getAmountNoFreight().subtract(r.getAmountExcludingVatNoFreight()));
               }

               this.returnDetailMapper.updateById(r);
               if (record.getQuantity() != null) {
                  record.setQuantity(record.getQuantity().add(r.getQuantity()));
               }

               record.setMete(record.getMete().add(r.getMete()));
               if (record.getAmount() != null) {
                  record.setAmount(record.getAmount().add(r.getAmount()));
                  record.setAmountExcludingVat(record.getAmountExcludingVat().add(r.getAmountExcludingVat()));
                  tempOutMeteSum = tempOutMeteSum.subtract(r.getMete());
                  tempOutAmountSum = tempOutAmountSum.subtract(r.getAmount());
                  tempUnOutAmountSum = tempUnOutAmountSum.subtract(r.getAmountExcludingVat());
               }

               if (record.getAmountNoFreight() != null) {
                  record.setAmountNoFreight(record.getAmountNoFreight().add(r.getAmountNoFreight()));
                  record.setAmountExcludingVatNoFreight(record.getAmountExcludingVatNoFreight().add(r.getAmountExcludingVatNoFreight()));
                  tempOutAmountSumNoFreight = tempOutAmountSumNoFreight.subtract(r.getAmountNoFreight());
                  tempUnOutAmountSumNoFreight = tempUnOutAmountSumNoFreight.subtract(r.getAmountExcludingVatNoFreight());
               }

               tempId = r.getMaterialReturnableId();
               StatisticsOutbound outbound = new StatisticsOutbound();
               outbound.setUnitPriceExcludingVat(r.getUnitPriceExcludingVat());
               outbound.setUnitPrice(r.getUnitPrice());
               outbound.setAmountExcludingVat(r.getAmountExcludingVat().negate());
               outbound.setAmount(r.getAmount().negate());
               outbound.setUnitPriceExcludingVatNoFreight(r.getUnitPriceExcludingVatNoFreight());
               outbound.setUnitPriceNoFreight(r.getUnitPriceNoFreight());
               outbound.setAmountExcludingVatNoFreight(r.getAmountExcludingVatNoFreight().negate());
               outbound.setAmountNoFreight(r.getAmountNoFreight().negate());
               LambdaQueryWrapper<StatisticsOutbound> wrapper = new LambdaQueryWrapper<>();
               wrapper.eq(StatisticsOutbound::getDetailId, r.getId());
               wrapper.eq(StatisticsOutbound::getReceiptType, ReceiptTypeEnum.RETURN.getType());
               wrapper.eq(StatisticsOutbound::getReceiptId, r.getReturnId());
               this.statisticsOutboundMapper.update(outbound, wrapper);
            }
         }

         StatisticsOutbound outbound = new StatisticsOutbound();
         outbound.setUnitPriceExcludingVat(out.getUnitPriceExcludingVat());
         outbound.setUnitPrice(out.getUnitPrice());
         outbound.setAmountExcludingVat(out.getAmountExcludingVat());
         outbound.setAmount(out.getAmount());
         outbound.setUnitPriceExcludingVatNoFreight(out.getUnitPriceExcludingVatNoFreight());
         outbound.setUnitPriceNoFreight(out.getUnitPriceNoFreight());
         outbound.setAmountExcludingVatNoFreight(out.getAmountExcludingVatNoFreight());
         outbound.setAmountNoFreight(out.getAmountNoFreight());
         LambdaQueryWrapper<StatisticsOutbound> wrapper = new LambdaQueryWrapper<>();
         wrapper.eq(StatisticsOutbound::getDetailId, out.getId());
         wrapper.eq(StatisticsOutbound::getReceiptType, ReceiptTypeEnum.OUTBOUND.getType());
         wrapper.eq(StatisticsOutbound::getReceiptId, out.getOutboundId());
         this.statisticsOutboundMapper.update(outbound, wrapper);
      }

      Statistics statistics = this.statisticsMapper.selectOne((Wrapper<Statistics>)Wrappers.<Statistics>lambdaQuery().eq(Statistics::getWapId, record.getId()));
      if (statistics.getOutboundMete() != null) {
         List<StatisticsOutbound> statisticsOutbounds = this.statisticsOutboundMapper
            .selectList(
               (Wrapper<StatisticsOutbound>)((Wrappers.<StatisticsOutbound>lambdaQuery()
                        .eq(StatisticsOutbound::getStatisticsId, statistics.getId()))
                     .ge(BaseEntity::getCreateTime, monthTimeRange.getStartTime()))
                  .lt(BaseEntity::getCreateTime, monthTimeRange.getEndTime())
            );
         if (CollectionUtil.isNotEmpty(statisticsOutbounds)) {
            BigDecimal outboundAmount = statisticsOutbounds.stream()
               .filter(statisticsOutbound -> statisticsOutbound.getAmount() != null)
               .map(StatisticsOutbound::getAmount)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal outMete = statisticsOutbounds.stream()
               .filter(statisticsOutbound -> statisticsOutbound.getMete() != null)
               .map(StatisticsOutbound::getMete)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal amountExcludingVat1 = statisticsOutbounds.stream()
               .filter(statisticsOutbound -> statisticsOutbound.getAmountExcludingVat() != null)
               .map(StatisticsOutbound::getAmountExcludingVat)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            statistics.setOutboundAmountExcludingVat(amountExcludingVat1);
            BigDecimal outboundAmountNoFreight = statisticsOutbounds.stream()
               .filter(statisticsOutbound -> statisticsOutbound.getAmountNoFreight() != null)
               .map(StatisticsOutbound::getAmountNoFreight)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal amountExcludingVat1NoFreight = statisticsOutbounds.stream()
               .filter(statisticsOutbound -> statisticsOutbound.getAmountExcludingVatNoFreight() != null)
               .map(StatisticsOutbound::getAmountExcludingVatNoFreight)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            statistics.setOutboundAmountExcludingVatNoFreight(amountExcludingVat1NoFreight);
            statistics.setOutboundAmount(outboundAmount);
            statistics.setOutboundAmountNoFreight(outboundAmountNoFreight);
            if (outMete.compareTo(BigDecimal.ZERO) == 0) {
               statistics.setOutboundUnitPrice(BigDecimal.ZERO);
               statistics.setOutboundUnitPriceExcludingVat(BigDecimal.ZERO);
               statistics.setOutboundUnitPriceNoFreight(BigDecimal.ZERO);
               statistics.setOutboundUnitPriceExcludingVatNoFreight(BigDecimal.ZERO);
            } else {
               statistics.setOutboundUnitPrice(outboundAmount.divide(outMete, 12, RoundingMode.HALF_UP));
               statistics.setOutboundUnitPriceExcludingVat(amountExcludingVat1.divide(outMete, 12, RoundingMode.HALF_UP));
               statistics.setOutboundUnitPriceNoFreight(outboundAmountNoFreight.divide(outMete, 12, RoundingMode.HALF_UP));
               statistics.setOutboundUnitPriceExcludingVatNoFreight(amountExcludingVat1NoFreight.divide(outMete, 12, RoundingMode.HALF_UP));
            }
         }
      }

      statistics.setEndUnitPrice(avgPrice);
      statistics.setEndUnitPriceExcludingVat(excludingVatAvgPrice);
      statistics.setEndAmount(record.getAmount());
      statistics.setEndAmountExcludingVat(record.getAmountExcludingVat());
      statistics.setEndUnitPriceNoFreight(avgPriceNoFreight);
      statistics.setEndUnitPriceExcludingVatNoFreight(excludingVatAvgPriceNoFreight);
      statistics.setEndAmountNoFreight(record.getAmountNoFreight());
      statistics.setEndAmountExcludingVatNoFreight(record.getAmountExcludingVatNoFreight());
      this.statisticsMapper.updateById(statistics);
      List<StatisticsEndPeriod> statisticsEndPeriods = this.statisticsEndPeriodMapper
         .selectList((Wrapper<StatisticsEndPeriod>)Wrappers.<StatisticsEndPeriod>lambdaQuery().eq(StatisticsEndPeriod::getStatisticsId, statistics.getId()));
      BigDecimal mete1 = record.getMete();
      BigDecimal amount1 = record.getAmount();
      BigDecimal amountExcludingVat1 = record.getAmountExcludingVat();

      for (StatisticsEndPeriod statisticsEndPeriod : statisticsEndPeriods) {
         if (statisticsEndPeriod.getMete().compareTo(BigDecimal.ZERO) != 0 && mete1.compareTo(BigDecimal.ZERO) != 0) {
            BigDecimal divide = statisticsEndPeriod.getMete().divide(mete1, 12, RoundingMode.HALF_UP);
            statisticsEndPeriod.setAmount(divide.multiply(amount1).setScale(this.amountAccuracy, RoundingMode.HALF_UP));
            statisticsEndPeriod.setAmountExcludingVat(divide.multiply(amountExcludingVat1).setScale(this.amountAccuracy, RoundingMode.HALF_UP));
            statisticsEndPeriod.setUnitPrice(statisticsEndPeriod.getAmount().divide(statisticsEndPeriod.getMete(), this.amountAccuracy, RoundingMode.HALF_UP));
            statisticsEndPeriod.setUnitPriceExcludingVat(
               statisticsEndPeriod.getAmountExcludingVat().divide(statisticsEndPeriod.getMete(), this.amountAccuracy, RoundingMode.HALF_UP)
            );
            mete1 = mete1.subtract(statisticsEndPeriod.getMete());
            amount1 = amount1.subtract(statisticsEndPeriod.getAmount());
            amountExcludingVat1 = amountExcludingVat1.subtract(statisticsEndPeriod.getAmountExcludingVat());
         }

         this.statisticsEndPeriodMapper.updateById(statisticsEndPeriod);
      }
   }

   private void setWAPUser(MonthWeightedAveragePrice record, MonthTimeRange monthTimeRange) {
      BigDecimal amount = record.getAmount();
      BigDecimal amountExcludingVat = record.getAmountExcludingVat();
      BigDecimal amountNoFreight = record.getAmountNoFreight();
      BigDecimal amountExcludingVatNoFreight = record.getAmountExcludingVatNoFreight();
      BigDecimal mete = record.getMete();
      BigDecimal avgPrice = BigDecimal.ZERO;
      BigDecimal excludingVatAvgPrice = BigDecimal.ZERO;
      BigDecimal avgPriceNoFreight = BigDecimal.ZERO;
      BigDecimal excludingVatAvgPriceNoFreight = BigDecimal.ZERO;
      if (mete.compareTo(BigDecimal.ZERO) != 0) {
         avgPrice = NumberUtil.div(amount, mete, 12);
         excludingVatAvgPrice = NumberUtil.div(amountExcludingVat, mete, 12);
         avgPriceNoFreight = NumberUtil.div(amountNoFreight, mete, 12);
         excludingVatAvgPriceNoFreight = NumberUtil.div(amountExcludingVatNoFreight, mete, 12);
      }

      ArrayList<Integer> outboundTypeSelection = new ArrayList<>();
      outboundTypeSelection.add(2);
      outboundTypeSelection.add(4);
      outboundTypeSelection.add(16);
      List<MoveOutboundDetail> outList = this.outboundDetailMapper.queryCurrentMonth(record.getId(), monthTimeRange, null, outboundTypeSelection);
      BigDecimal tempOutMeteSum = BigDecimal.ZERO;
      BigDecimal tempOutAmountSum = BigDecimal.ZERO;
      BigDecimal tempUnOutAmountSum = BigDecimal.ZERO;
      BigDecimal tempOutAmountSumNoFreight = BigDecimal.ZERO;
      BigDecimal tempUnOutAmountSumNoFreight = BigDecimal.ZERO;

      for (MoveOutboundDetail out : outList) {
         out.setUnitPrice(avgPrice);
         out.setUnitPriceExcludingVat(excludingVatAvgPrice);
         out.setUnitPriceNoFreight(avgPriceNoFreight);
         out.setUnitPriceExcludingVatNoFreight(excludingVatAvgPriceNoFreight);
         BigDecimal totalPrice = BigDecimal.ZERO;
         BigDecimal unTotalPrice = BigDecimal.ZERO;
         BigDecimal totalPriceNoFreight = BigDecimal.ZERO;
         BigDecimal unTotalPriceNoFreight = BigDecimal.ZERO;
         BigDecimal tempMete = mete.subtract(tempOutMeteSum);
         if (out.getMete().doubleValue() != 0.0
            && mete.doubleValue() != 0.0
            && amount.doubleValue() != 0.0
            && amountExcludingVat.doubleValue() != 0.0
            && tempMete.doubleValue() != 0.0) {
            totalPrice = NumberUtil.round(NumberUtil.mul(NumberUtil.div(out.getMete(), tempMete), NumberUtil.sub(amount, tempOutAmountSum)), 2);
            unTotalPrice = NumberUtil.round(NumberUtil.mul(NumberUtil.div(out.getMete(), tempMete), NumberUtil.sub(amountExcludingVat, tempUnOutAmountSum)), 2);
            totalPriceNoFreight = NumberUtil.round(
               NumberUtil.mul(NumberUtil.div(out.getMete(), tempMete), NumberUtil.sub(amountNoFreight, tempOutAmountSumNoFreight)), 2
            );
            unTotalPriceNoFreight = NumberUtil.round(
               NumberUtil.mul(NumberUtil.div(out.getMete(), tempMete), NumberUtil.sub(amountExcludingVatNoFreight, tempUnOutAmountSumNoFreight)), 2
            );
            tempOutMeteSum = NumberUtil.add(tempOutMeteSum, out.getMete());
            tempOutAmountSum = NumberUtil.add(tempOutAmountSum, totalPrice);
            tempUnOutAmountSum = NumberUtil.add(tempUnOutAmountSum, unTotalPrice);
            tempOutAmountSumNoFreight = NumberUtil.add(tempOutAmountSumNoFreight, totalPriceNoFreight);
            tempUnOutAmountSumNoFreight = NumberUtil.add(tempUnOutAmountSumNoFreight, unTotalPriceNoFreight);
         }

         out.setAmount(totalPrice);
         out.setAmountExcludingVat(unTotalPrice);
         out.setAmountNoFreight(totalPriceNoFreight);
         out.setAmountExcludingVatNoFreight(unTotalPriceNoFreight);
         if (InvoiceTypeEnum.SPECIAL.getType().equals(out.getInvoiceType())) {
            out.setInputVat(out.getAmount().subtract(out.getAmountExcludingVat()));
            out.setInputVatNoFreight(out.getAmountNoFreight().subtract(out.getAmountExcludingVatNoFreight()));
         }

         this.outboundDetailMapper.updateById(out);
         if (record.getQuantity() != null) {
            if (BasicClassEnum.COLOR_ROLL.getType().equals(out.getBasicClass()) && out.getLength() != null) {
               record.setQuantity(record.getQuantity().subtract(out.getLength()));
            } else {
               record.setQuantity(record.getQuantity().subtract(out.getQuantity()));
            }
         }

         record.setMete(record.getMete().subtract(out.getMete()));
         if (record.getAmount() != null) {
            record.setAmount(record.getAmount().subtract(out.getAmount()));
            record.setAmountExcludingVat(record.getAmountExcludingVat().subtract(out.getAmountExcludingVat()));
         }

         if (record.getAmountNoFreight() != null) {
            record.setAmountNoFreight(record.getAmountNoFreight().subtract(out.getAmountNoFreight()));
            record.setAmountExcludingVatNoFreight(record.getAmountExcludingVatNoFreight().subtract(out.getAmountExcludingVatNoFreight()));
         }

         for (MaterialReturnable returnable : this.materialReturnableMapper
            .selectList((Wrapper<MaterialReturnable>)new LambdaQueryWrapper<MaterialReturnable>().eq(MaterialReturnable::getOutboundDetailId, out.getId()))) {
            returnable.setUnitPrice(avgPrice);
            returnable.setUnitPriceExcludingVat(excludingVatAvgPrice);
            returnable.setAmount(totalPrice);
            returnable.setAmountExcludingVat(unTotalPrice);
            returnable.setUnitPriceNoFreight(avgPriceNoFreight);
            returnable.setUnitPriceExcludingVatNoFreight(excludingVatAvgPriceNoFreight);
            returnable.setAmountNoFreight(totalPriceNoFreight);
            returnable.setAmountExcludingVatNoFreight(unTotalPriceNoFreight);
            this.materialReturnableMapper.updateById(returnable);
            List<ReturnDetail> returnList = this.returnDetailMapper.queryCurrentMonthUser(returnable.getId(), monthTimeRange, null);
            long tempId = 0L;
            BigDecimal tempReturnMeteSum = BigDecimal.ZERO;
            BigDecimal tempReturnAmountSum = BigDecimal.ZERO;
            BigDecimal unTempReturnAmountSum = BigDecimal.ZERO;
            BigDecimal tempReturnAmountSumNoFreight = BigDecimal.ZERO;
            BigDecimal unTempReturnAmountSumNoFreight = BigDecimal.ZERO;

            for (ReturnDetail r : returnList) {
               if (tempId != r.getMaterialReturnableId()) {
                  tempReturnMeteSum = BigDecimal.ZERO;
                  tempReturnAmountSum = BigDecimal.ZERO;
                  unTempReturnAmountSum = BigDecimal.ZERO;
                  tempReturnAmountSumNoFreight = BigDecimal.ZERO;
                  unTempReturnAmountSumNoFreight = BigDecimal.ZERO;
               }

               MaterialReturnable materialReturnable = this.materialReturnableMapper.selectById(r.getMaterialReturnableId());
               r.setUnitPrice(avgPrice);
               r.setUnitPriceExcludingVat(excludingVatAvgPrice);
               r.setUnitPriceNoFreight(avgPriceNoFreight);
               r.setUnitPriceExcludingVatNoFreight(excludingVatAvgPriceNoFreight);
               BigDecimal totalRePrice = BigDecimal.ZERO;
               BigDecimal unTotalRePrice = BigDecimal.ZERO;
               BigDecimal totalRePriceNoFreight = BigDecimal.ZERO;
               BigDecimal unTotalRePriceNoFreight = BigDecimal.ZERO;
               BigDecimal tempReMete = NumberUtil.sub(materialReturnable.getMete(), tempReturnMeteSum);
               if (r.getMete().doubleValue() != 0.0
                  && materialReturnable.getMete().doubleValue() != 0.0
                  && materialReturnable.getAmount().doubleValue() != 0.0
                  && materialReturnable.getAmountExcludingVat().doubleValue() != 0.0
                  && tempReMete.doubleValue() != 0.0) {
                  totalRePrice = NumberUtil.round(
                     NumberUtil.mul(NumberUtil.div(r.getMete(), tempReMete), NumberUtil.sub(out.getAmount(), tempReturnAmountSum)), 2
                  );
                  unTotalRePrice = NumberUtil.round(
                     NumberUtil.mul(NumberUtil.div(r.getMete(), tempReMete), NumberUtil.sub(out.getAmountExcludingVat(), unTempReturnAmountSum)), 2
                  );
                  tempReturnMeteSum = NumberUtil.add(tempReturnMeteSum, r.getMete());
                  tempReturnAmountSum = NumberUtil.add(tempReturnAmountSum, totalRePrice);
                  unTempReturnAmountSum = NumberUtil.add(unTempReturnAmountSum, unTotalRePrice);
               }

               if (r.getMete().doubleValue() != 0.0
                  && materialReturnable.getMete().doubleValue() != 0.0
                  && materialReturnable.getAmountNoFreight().doubleValue() != 0.0
                  && materialReturnable.getAmountExcludingVatNoFreight().doubleValue() != 0.0
                  && tempReMete.doubleValue() != 0.0) {
                  totalRePriceNoFreight = NumberUtil.round(
                     NumberUtil.mul(NumberUtil.div(r.getMete(), tempReMete), NumberUtil.sub(out.getAmountNoFreight(), tempReturnAmountSumNoFreight)), 2
                  );
                  unTotalRePriceNoFreight = NumberUtil.round(
                     NumberUtil.mul(
                        NumberUtil.div(r.getMete(), tempReMete), NumberUtil.sub(out.getAmountExcludingVatNoFreight(), unTempReturnAmountSumNoFreight)
                     ),
                     2
                  );
                  tempReturnAmountSumNoFreight = NumberUtil.add(tempReturnAmountSumNoFreight, totalRePriceNoFreight);
                  unTempReturnAmountSumNoFreight = NumberUtil.add(unTempReturnAmountSumNoFreight, unTotalRePriceNoFreight);
               }

               r.setAmount(totalRePrice);
               r.setAmountExcludingVat(unTotalRePrice);
               r.setAmountNoFreight(totalRePriceNoFreight);
               r.setAmountExcludingVatNoFreight(unTotalRePriceNoFreight);
               materialReturnable.setAmount(NumberUtil.sub(materialReturnable.getAmount(), totalRePrice));
               materialReturnable.setAmountExcludingVat(NumberUtil.sub(materialReturnable.getAmountExcludingVat(), unTotalRePrice));
               materialReturnable.setAmountNoFreight(NumberUtil.sub(materialReturnable.getAmountNoFreight(), totalRePrice));
               materialReturnable.setAmountExcludingVatNoFreight(NumberUtil.sub(materialReturnable.getAmountExcludingVatNoFreight(), unTotalRePrice));
               this.materialReturnableMapper.updateById(materialReturnable);
               if (InvoiceTypeEnum.SPECIAL.getType().equals(r.getInvoiceType())) {
                  r.setInputVat(r.getAmount().subtract(r.getAmountExcludingVat()));
                  r.setInputVatNoFreight(r.getAmountNoFreight().subtract(r.getAmountExcludingVatNoFreight()));
               }

               this.returnDetailMapper.updateById(r);
               if (record.getQuantity() != null) {
                  record.setQuantity(record.getQuantity().add(r.getQuantity()));
               }

               record.setMete(record.getMete().add(r.getMete()));
               if (record.getAmount() != null) {
                  record.setAmount(record.getAmount().add(r.getAmount()));
                  record.setAmountExcludingVat(record.getAmountExcludingVat().add(r.getAmountExcludingVat()));
                  tempOutMeteSum = tempOutMeteSum.subtract(r.getMete());
                  tempOutAmountSum = tempOutAmountSum.subtract(r.getAmount());
                  tempUnOutAmountSum = tempUnOutAmountSum.subtract(r.getAmountExcludingVat());
               }

               if (record.getAmountNoFreight() != null) {
                  record.setAmountNoFreight(record.getAmountNoFreight().add(r.getAmountNoFreight()));
                  record.setAmountExcludingVatNoFreight(record.getAmountExcludingVatNoFreight().add(r.getAmountExcludingVatNoFreight()));
                  tempOutAmountSumNoFreight = tempOutAmountSumNoFreight.subtract(r.getAmountNoFreight());
                  tempUnOutAmountSumNoFreight = tempUnOutAmountSumNoFreight.subtract(r.getAmountExcludingVatNoFreight());
               }

               tempId = r.getMaterialReturnableId();
               StatisticsOutbound outbound = new StatisticsOutbound();
               outbound.setUnitPriceExcludingVat(r.getUnitPriceExcludingVat());
               outbound.setUnitPrice(r.getUnitPrice());
               outbound.setAmountExcludingVat(r.getAmountExcludingVat().negate());
               outbound.setAmount(r.getAmount().negate());
               outbound.setUnitPriceExcludingVatNoFreight(r.getUnitPriceExcludingVatNoFreight());
               outbound.setUnitPriceNoFreight(r.getUnitPriceNoFreight());
               outbound.setAmountExcludingVatNoFreight(r.getAmountExcludingVatNoFreight().negate());
               outbound.setAmountNoFreight(r.getAmountNoFreight().negate());
               LambdaQueryWrapper<StatisticsOutbound> wrapper = new LambdaQueryWrapper<>();
               wrapper.eq(StatisticsOutbound::getDetailId, r.getId());
               wrapper.eq(StatisticsOutbound::getReceiptType, ReceiptTypeEnum.RETURN.getType());
               wrapper.eq(StatisticsOutbound::getReceiptId, r.getReturnId());
               this.statisticsOutboundMapper.update(outbound, wrapper);
            }
         }

         StatisticsOutbound outbound = new StatisticsOutbound();
         outbound.setUnitPriceExcludingVat(out.getUnitPriceExcludingVat());
         outbound.setUnitPrice(out.getUnitPrice());
         outbound.setAmountExcludingVat(out.getAmountExcludingVat());
         outbound.setAmount(out.getAmount());
         outbound.setUnitPriceExcludingVatNoFreight(out.getUnitPriceExcludingVatNoFreight());
         outbound.setUnitPriceNoFreight(out.getUnitPriceNoFreight());
         outbound.setAmountExcludingVatNoFreight(out.getAmountExcludingVatNoFreight());
         outbound.setAmountNoFreight(out.getAmountNoFreight());
         LambdaQueryWrapper<StatisticsOutbound> wrapper = new LambdaQueryWrapper<>();
         wrapper.eq(StatisticsOutbound::getDetailId, out.getId());
         wrapper.eq(StatisticsOutbound::getReceiptType, ReceiptTypeEnum.OUTBOUND.getType());
         wrapper.eq(StatisticsOutbound::getReceiptId, out.getOutboundId());
         this.statisticsOutboundMapper.update(outbound, wrapper);
      }
   }

   @Override
   public StatisticsPageVO<StatisticsDTO> getInventoryDetailsRecord(
      List<LocalDateTime> dates, List<Long> classifyId, List<Long> workshopIds, Integer pageNumber, Integer pageSize, List<String> sort
   ) {
      QueryStatisticsDTOParam param = QueryStatisticsDTOParam.builder().classifyId(classifyId).build();
      if (CollectionUtil.isNotEmpty(classifyId)) {
         List<Classification> classifications = this.classificationService.listByIds(classifyId);
         ArrayList<Long> objects = new ArrayList<>();
         classifications.forEach(
            classificationx -> {
               if (!classificationx.getBoolLastEnum()) {
                  List<Long> collect = this.classificationService
                     .getLastSubject(classificationx.getId())
                     .stream()
                     .map(Classification::getId)
                     .collect(Collectors.toList());
                  objects.addAll(collect);
               } else {
                  objects.add(classificationx.getId());
               }
            }
         );
         param.setClassifyIds(objects);
      }

      this.getTimes(dates);
      Map<String, StatisticsDTO> map = new HashMap<>();
      Map<String, List<String>> specMap = new HashMap<>();
      Map<String, Object> cacheMap = new HashMap<>();

      for (InventoryDetailsRecord detailsRecord : this.inventoryDetailsRecordMapper.getByTime(null, dates.get(0), dates.get(1))) {
         String detailKey = detailsRecord.getDetailKey();
         StatisticsDTO statisticsDTO = map.get(detailKey);
         if (statisticsDTO == null && detailsRecord.getReceiptId() != null) {
            JSONObject jsonObject = JSON.parseObject(detailKey);
            StatisticsDTO dto = StatisticsDTO.builder()
               .classifyId(Long.parseLong(jsonObject.getString("classifyId")))
               .weightedPriceType(Integer.parseInt(jsonObject.getString("weightedType")))
               .thickness(jsonObject.getString("thickness") != null ? new BigDecimal(jsonObject.getString("thickness")) : null)
               .specs(jsonObject.getString("specs"))
               .brand(jsonObject.getString("brand"))
               .color(jsonObject.getString("color"))
               .heatNoAndBatchNo(jsonObject.getString("HN"))
               .standardId(jsonObject.getString("standard") != null ? Long.parseLong(jsonObject.getString("standard")) : null)
               .boolPartyA(!"0".equals(jsonObject.getString("boolPartyA")))
               .detailKey(detailKey)
               .build();
            long workshopId = Long.parseLong(jsonObject.getString("workshopId"));
            MesBuildingWorkshop workshop = (MesBuildingWorkshop)cacheMap.get("f" + workshopId);
            if (workshop == null) {
               workshop = this.workshopService.getById(workshopId);
               cacheMap.put("f" + workshopId, workshop);
            }

            dto.setWorkshop(BriefIdAndNameDTO.builder().id(workshop.getId()).name(workshop.getName()).build());
            if (StrUtil.isNotBlank(jsonObject.getString("projectId"))) {
               long projectId = Long.parseLong(jsonObject.getString("projectId"));
               ProjectInfo projectInfo = (ProjectInfo)cacheMap.get("p" + projectId);
               if (projectInfo == null) {
                  projectInfo = this.projectService.getSimpleById(projectId);
                  cacheMap.put("p" + projectId, projectInfo);
               }

               dto.setProject(projectInfo);
            }

            Classification classification = (Classification)cacheMap.get("c" + dto.getClassifyId());
            if (classification == null) {
               classification = this.classificationService.getById(dto.getClassifyId());
               cacheMap.put("c" + classification.getId(), classification);
            }

            dto.setBasicClass(classification.getBasicClass());
            dto.setClassifyName(classification.getName());
            Measure measure = (Measure)cacheMap.get("m" + dto.getClassifyId());
            if (measure == null) {
               measure = this.getMeasure(dto.getClassifyId());
               cacheMap.put("m" + classification.getId(), measure);
            }

            dto.setMeasure(measure);
            if (dto.getSpecs() != null) {
               dto.setSpecifications(StrUtil.split(dto.getSpecs(), ","));
               List<String> list = specMap.get(detailKey);
               List<String> specs = StrUtil.split(dto.getSpecs(), ",");
               if (CollectionUtil.isNotEmpty(list)) {
                  list.removeAll(specs);
                  list.addAll(specs);
                  specMap.put(detailKey, list);
               } else {
                  specMap.put(detailKey, StrUtil.split(dto.getSpecs(), ","));
               }
            }

            map.put(detailKey, dto);
         }
      }

      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMM");
      if (formatter.format(LocalDateTime.now()).equals(formatter.format(dates.get(1)))) {
         param.setCreateTime(dates.get(1));
         param.setWorkshopIds(workshopIds);
         List<StatisticsDTO> statisticsDTOS = this.statisticsMapper.getList(param);
         this.setDetailMap(map, specMap, statisticsDTOS);
      }

      map = this.updateMap(map, specMap);
      Page<StatisticsDTO> page = CommonUtil.getPage(pageNumber, pageSize, new ArrayList<>(map.values()));
      return new StatisticsPageVO<>(page, page.getResult());
   }

   @NotNull
   private void getTimes(List<LocalDateTime> dates) {
      dates.set(0, LocalDateTime.of(dates.get(0).with(TemporalAdjusters.firstDayOfMonth()).toLocalDate(), LocalTime.MIN));
      dates.set(1, LocalDateTime.of(dates.get(1).with(TemporalAdjusters.lastDayOfMonth()).toLocalDate(), LocalTime.MAX));
   }

   @Override
   public ListVO<InventoryDetailsRecordDetailDTO> getInventoryDetailsRecordDetail(List<LocalDateTime> times, String detailKey) {
      MonthTimeRange monthTimeRange = DateTimeUtil.getMonthTimeRange(LocalDateTime.now().getMonthValue() + "");
      BasicConfig basicConfig = this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置"));
      WeightedPriceConf weightedPriceConf = JSON.parseObject(basicConfig.getValue(), WeightedPriceConf.class);
      BigDecimal inboundQuantity = BigDecimal.ZERO;
      BigDecimal inboundMete = BigDecimal.ZERO;
      BigDecimal inboundAmount = BigDecimal.ZERO;
      BigDecimal inboundAmountExcludingVat = BigDecimal.ZERO;
      BigDecimal outboundQuantity = BigDecimal.ZERO;
      BigDecimal outboundMete = BigDecimal.ZERO;
      BigDecimal outboundAmount = BigDecimal.ZERO;
      BigDecimal outboundAmountExcludingVat = BigDecimal.ZERO;
      List<InventoryDetailsRecordDetailDTO> list = new ArrayList<>();
      this.getTimes(times);

      for (InventoryDetailsRecord detailsRecord : this.inventoryDetailsRecordMapper.getByTime(detailKey, times.get(0), times.get(1))) {
         InventoryDetailsRecordDetailDTO dto = BeanUtil.copy(detailsRecord, InventoryDetailsRecordDetailDTO.class);
         if (detailsRecord.getReceiptId() != null) {
            dto.setReceipt(
               BriefIdAndSNDTO.builder()
                  .id(detailsRecord.getReceiptId())
                  .serialNumber(detailsRecord.getReceiptSerialNumber())
                  .receiptType(detailsRecord.getReceiptType())
                  .build()
            );
            list.add(dto);
         } else {
            if (detailsRecord.getInboundMete() != null) {
               if (detailsRecord.getInboundQuantity() != null) {
                  inboundQuantity = inboundQuantity.add(detailsRecord.getInboundQuantity());
               }

               inboundMete = inboundMete.add(detailsRecord.getInboundMete());
               inboundAmount = inboundAmount.add(detailsRecord.getInboundAmount());
               inboundAmountExcludingVat = inboundAmountExcludingVat.add(detailsRecord.getInboundAmountExcludingVat());
            }

            if (detailsRecord.getOutboundMete() != null) {
               if (detailsRecord.getOutboundQuantity() != null) {
                  outboundQuantity = outboundQuantity.add(detailsRecord.getOutboundQuantity());
               }

               outboundMete = outboundMete.add(detailsRecord.getOutboundMete());
               outboundAmount = outboundAmount.add(detailsRecord.getOutboundAmount());
               outboundAmountExcludingVat = outboundAmountExcludingVat.add(detailsRecord.getOutboundAmountExcludingVat());
            }

            InventoryDetailsRecordDetailDTO detailDTO = BeanUtil.copy(detailsRecord, InventoryDetailsRecordDetailDTO.class);
            detailDTO.setSummary("本月累计");
            if (detailsRecord.getInboundQuantity() != null) {
               detailDTO.setInboundQuantity(inboundQuantity);
               detailDTO.setOutboundQuantity(outboundQuantity);
            }

            detailDTO.setInboundMete(inboundMete);
            detailDTO.setInboundAmount(inboundAmount);
            detailDTO.setInboundAmountExcludingVat(inboundAmountExcludingVat);
            detailDTO.setOutboundMete(outboundMete);
            detailDTO.setOutboundAmount(outboundAmount);
            detailDTO.setOutboundAmountExcludingVat(outboundAmountExcludingVat);
            list.add(detailDTO);
         }
      }

      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMM");
      if (formatter.format(LocalDateTime.now()).equals(formatter.format(times.get(1)))) {
         Map<String, String> map = JSON.parseObject(detailKey, Map.class);
         List<Statistics> statistics = this.statisticsMapper
            .getIdByMap(
               map.get("classifyId"),
               map.get("thickness"),
               map.get("specs"),
               map.get("brand"),
               map.get("color"),
               map.get("HN"),
               map.get("workshopId"),
               map.get("standard"),
               map.get("boolPartyA"),
               map.get("projectId")
            );
         InventoryDetailsRecordDetailDTO month = this.setMonthRecord(list, statistics, monthTimeRange, weightedPriceConf);
         InventoryDetailsRecordDetailDTO build = InventoryDetailsRecordDetailDTO.builder()
            .inboundQuantity(month.getInboundQuantity().add(inboundQuantity))
            .inboundMete(month.getInboundMete().add(inboundMete))
            .inboundAmount(month.getInboundAmount().add(inboundAmount))
            .inboundAmountExcludingVat(month.getInboundAmountExcludingVat().add(inboundAmountExcludingVat))
            .outboundMete(month.getOutboundMete().add(outboundMete))
            .outboundQuantity(month.getOutboundQuantity().add(outboundQuantity))
            .outboundAmount(month.getOutboundAmount().add(outboundAmount))
            .outboundAmountExcludingVat(month.getOutboundAmountExcludingVat().add(outboundAmountExcludingVat))
            .summary("本月累计")
            .build();
         build.setInboundUnitPrice(
            build.getInboundMete().compareTo(BigDecimal.ZERO) > 0
               ? build.getInboundAmount().divide(build.getInboundMete(), 12, RoundingMode.HALF_UP)
               : BigDecimal.ZERO
         );
         build.setInboundUnitPriceExcludingVat(
            build.getInboundMete().compareTo(BigDecimal.ZERO) > 0
               ? build.getInboundAmountExcludingVat().divide(build.getInboundMete(), 12, RoundingMode.HALF_UP)
               : BigDecimal.ZERO
         );
         if (build.getOutboundMete() != null) {
            build.setOutboundUnitPrice(
               build.getOutboundAmount().compareTo(BigDecimal.ZERO) > 0
                  ? build.getOutboundAmount().divide(build.getOutboundMete(), 12, RoundingMode.HALF_UP)
                  : BigDecimal.ZERO
            );
            build.setOutboundUnitPriceExcludingVat(
               build.getOutboundAmountExcludingVat().compareTo(BigDecimal.ZERO) > 0
                  ? build.getOutboundAmountExcludingVat().divide(build.getOutboundMete(), 12, RoundingMode.HALF_UP)
                  : BigDecimal.ZERO
            );
         } else {
            build.setOutboundUnitPrice(BigDecimal.ZERO);
            build.setOutboundUnitPriceExcludingVat(BigDecimal.ZERO);
         }

         list.add(build);
      }

      return new ListVO<>(list);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void saveMonthRecord(MonthTimeRange monthTimeRange, WeightedPriceConf weightedPriceConf, List<Statistics> statistics) {
      Map<String, List<Statistics>> map = new HashMap<>();
      Map<String, String> detailKey = new HashMap<>();

      for (Statistics statistic : statistics) {
         detailKey.put("classifyId", statistic.getClassifyId().toString());
         if (statistic.getThickness() != null) {
            detailKey.put("thickness", statistic.getThickness().toString());
         }

         detailKey.put("brand", statistic.getBrand());
         detailKey.put("color", statistic.getColor());
         detailKey.put("HN", statistic.getHeatNoAndBatchNo());
         detailKey.put("standard", statistic.getStandardId() != null ? statistic.getStandardId().toString() : null);
         detailKey.put("boolPartyA", statistic.getBoolPartyA() ? "1" : "0");
         detailKey.put("specs", statistic.getSpecs());
         if (statistic.getBoolPartyA()) {
            detailKey.put("projectId", statistic.getProjectId().toString());
         }

         if (WeightedPriceEnum.SINGLE.getType().equals(weightedPriceConf.getWeightedType())) {
            detailKey.put("projectId", statistic.getProjectId() != null ? statistic.getProjectId().toString() : "0");
         }

         detailKey.put("weightedType", weightedPriceConf.getWeightedType().toString());
         String key = JSON.toJSONString(detailKey);
         List<Statistics> m = map.get(key);
         if (m != null) {
            m.add(statistic);
         } else {
            map.put(key, new ArrayList<>(Collections.singletonList(statistic)));
         }
      }

      List<InventoryDetailsRecord> detailsRecordList = new ArrayList<>();

      for (String key : map.keySet()) {
         List<InventoryDetailsRecordDetailDTO> list = new ArrayList<>();
         this.setMonthRecord(list, statistics, monthTimeRange, weightedPriceConf);

         for (InventoryDetailsRecordDetailDTO dto : list) {
            InventoryDetailsRecord detailsRecord = BeanUtil.copy(dto, InventoryDetailsRecord.class);
            detailsRecord.setWeightedPriceType(weightedPriceConf.getWeightedType());
            if (dto.getReceipt() != null) {
               detailsRecord.setDetailKey(key);
               detailsRecord.setReceiptId(dto.getReceipt().getId());
               detailsRecord.setReceiptType(dto.getReceipt().getReceiptType());
               detailsRecord.setReceiptSerialNumber(dto.getReceipt().getSerialNumber());
            }

            detailsRecordList.add(detailsRecord);
         }
      }

      if (CollectionUtil.isNotEmpty(detailsRecordList)) {
         this.inventoryDetailsRecordService.saveBatch(detailsRecordList, 2000);
      }
   }

   @Override
   public RejectDetailDO getRejectDetailListCount(QueryRejectDetailDTOParam param) {
      if (CollectionUtil.isNotEmpty(param.getClassifyId())) {
         List<Classification> classifications = this.classificationService.listByIds(param.getClassifyId());
         ArrayList<Long> objects = new ArrayList<>();
         classifications.forEach(
            classification -> {
               if (!classification.getBoolLastEnum()) {
                  List<Long> collect = this.classificationService
                     .getLastSubject(classification.getId())
                     .stream()
                     .map(Classification::getId)
                     .collect(Collectors.toList());
                  objects.addAll(collect);
               } else {
                  objects.add(classification.getId());
               }
            }
         );
         param.setClassifyId(objects);
      }

      return this.rejectDetailMapper.getListCount(param);
   }

   private InventoryDetailsRecordDetailDTO setMonthRecord(
      List<InventoryDetailsRecordDetailDTO> list, List<Statistics> statistics, MonthTimeRange monthTimeRange, WeightedPriceConf weightedPriceConf
   ) {
      BigDecimal inQuantity = BigDecimal.ZERO;
      BigDecimal inMete = BigDecimal.ZERO;
      BigDecimal inAmount = BigDecimal.ZERO;
      BigDecimal inAmountExcludingVat = BigDecimal.ZERO;
      BigDecimal outQuantity = BigDecimal.ZERO;
      BigDecimal outMete = BigDecimal.ZERO;
      BigDecimal outAmount = BigDecimal.ZERO;
      BigDecimal outAmountExcludingVat = BigDecimal.ZERO;
      DetailDTO endDetail = new DetailDTO();
      List<Long> ids = new ArrayList<>();
      Map<Long, String> supplierMap = new HashMap<>();

      for (Statistics statistic : statistics) {
         ids.add(statistic.getId());
         if (statistic.getEndQuantity() != null) {
            endDetail.setQuantity(endDetail.getQuantity() != null ? endDetail.getQuantity().add(statistic.getEndQuantity()) : statistic.getEndQuantity());
         }

         if (statistic.getEndMete() != null) {
            endDetail.setMete(endDetail.getMete() != null ? endDetail.getMete().add(statistic.getEndMete()) : statistic.getEndMete());
         }

         if (statistic.getEndAmount() != null) {
            endDetail.setAmount(endDetail.getAmount() != null ? endDetail.getAmount().add(statistic.getEndAmount()) : statistic.getEndAmount());
            endDetail.setAmountExcludingVAT(
               endDetail.getAmountExcludingVAT() != null
                  ? endDetail.getAmountExcludingVAT().add(statistic.getEndAmountExcludingVat())
                  : statistic.getEndAmountExcludingVat()
            );
         }
      }

      for (StatisticsDetailDTO statisticsDetailDTO : this.statisticsInboundMapper.getDetailDTOList(ids, monthTimeRange)) {
         if (statisticsDetailDTO.getQuantity() != null) {
            inQuantity = inQuantity.add(statisticsDetailDTO.getQuantity());
         }

         if (statisticsDetailDTO.getMete() != null) {
            inMete = inMete.add(statisticsDetailDTO.getMete());
         }

         inAmount = inAmount.add(statisticsDetailDTO.getAmount());
         inAmountExcludingVat = inAmountExcludingVat.add(statisticsDetailDTO.getAmountExcludingVAT());
         Long supplierId = null;
         if (ReceiptTypeEnum.INBOUND.getType().equals(statisticsDetailDTO.getReceipt().getReceiptType())) {
            Inbound inbound = this.inboundMapper.selectById(statisticsDetailDTO.getReceipt().getId());
            if (inbound.getSupplierId() == null) {
               supplierId = -2L;
            } else {
               supplierId = inbound.getSupplierId();
            }
         } else if (ReceiptTypeEnum.REJECTED.getType().equals(statisticsDetailDTO.getReceipt().getReceiptType())) {
            supplierId = this.rejectMapper.selectById(statisticsDetailDTO.getReceipt().getId()).getSupplierId();
         } else if (ReceiptTypeEnum.TRANSFER.getType().equals(statisticsDetailDTO.getReceipt().getReceiptType())) {
            supplierId = -1L;
         }

         String supplierName = null;
         if (supplierId != null) {
            if (supplierId == -1L) {
               supplierName = statisticsDetailDTO.getMete().compareTo(BigDecimal.ZERO) > 0 ? "调拨入库" : "调拨出库";
            } else if (supplierId == -2L) {
               supplierName = "甲供";
            } else {
               supplierName = supplierMap.get(supplierId);
               if (StrUtil.isBlank(supplierName)) {
                  Supplier supplier = this.supplierService.getById(supplierId);
                  supplierName = supplier.getName();
                  supplierMap.put(supplierId, supplierName);
               }
            }
         }

         if (WeightedPriceEnum.SINGLE.getType().equals(weightedPriceConf.getWeightedType())
            || !ReceiptTypeEnum.TRANSFER.getType().equals(statisticsDetailDTO.getReceipt().getReceiptType())) {
            list.add(
               InventoryDetailsRecordDetailDTO.builder()
                  .inboundQuantity(statisticsDetailDTO.getQuantity())
                  .inboundMete(statisticsDetailDTO.getMete())
                  .inboundUnitPrice(statisticsDetailDTO.getUnitPrice())
                  .inboundUnitPriceExcludingVat(statisticsDetailDTO.getUnitPriceExcludingVAT())
                  .inboundAmount(statisticsDetailDTO.getAmount())
                  .inboundAmountExcludingVat(statisticsDetailDTO.getAmountExcludingVAT())
                  .summary(supplierName)
                  .receipt(statisticsDetailDTO.getReceipt())
                  .createTime(statisticsDetailDTO.getCreateTime())
                  .build()
            );
         }
      }

      for (StatisticsDetailDTO statisticsDetailDTO : this.statisticsOutboundMapper.getDetailDTOList(ids, monthTimeRange)) {
         if (statisticsDetailDTO.getQuantity() != null) {
            outQuantity = outQuantity.add(statisticsDetailDTO.getQuantity());
         }

         outMete = outMete.add(statisticsDetailDTO.getMete());
         if (statisticsDetailDTO.getAmount() != null) {
            outAmount = outAmount.add(statisticsDetailDTO.getAmount());
            outAmountExcludingVat = outAmountExcludingVat.add(statisticsDetailDTO.getAmountExcludingVAT());
         }

         list.add(
            InventoryDetailsRecordDetailDTO.builder()
               .outboundQuantity(statisticsDetailDTO.getQuantity())
               .outboundMete(statisticsDetailDTO.getMete())
               .outboundUnitPrice(statisticsDetailDTO.getUnitPrice())
               .outboundUnitPriceExcludingVat(statisticsDetailDTO.getUnitPriceExcludingVAT())
               .outboundAmount(statisticsDetailDTO.getAmount())
               .outboundAmountExcludingVat(statisticsDetailDTO.getAmountExcludingVAT())
               .summary(statisticsDetailDTO.getProject() != null ? statisticsDetailDTO.getProject().getSerialNumber() : null)
               .receipt(statisticsDetailDTO.getReceipt())
               .createTime(statisticsDetailDTO.getCreateTime())
               .build()
         );
      }

      list.sort(Comparator.comparing(InventoryDetailsRecordDetailDTO::getCreateTime));
      InventoryDetailsRecordDetailDTO recordDetailDTO = new InventoryDetailsRecordDetailDTO();
      if (CollectionUtil.isNotEmpty(list)) {
         recordDetailDTO = list.remove(list.size() - 1);
      }

      if (endDetail.getMete() != null && endDetail.getMete().compareTo(BigDecimal.ZERO) != 0) {
         recordDetailDTO.setEndMete(endDetail.getMete());
         recordDetailDTO.setEndQuantity(endDetail.getQuantity());
         recordDetailDTO.setEndAmount(endDetail.getAmount());
         recordDetailDTO.setEndAmountExcludingVat(endDetail.getAmountExcludingVAT());
         if (endDetail.getAmount() != null) {
            recordDetailDTO.setEndUnitPrice(endDetail.getAmount().divide(endDetail.getMete(), 8, RoundingMode.HALF_UP));
            recordDetailDTO.setEndUnitPriceExcludingVat(endDetail.getAmountExcludingVAT().divide(endDetail.getMete(), 8, RoundingMode.HALF_UP));
         }
      } else {
         recordDetailDTO.setEndMete(BigDecimal.ZERO);
         recordDetailDTO.setEndQuantity(BigDecimal.ZERO);
         recordDetailDTO.setEndUnitPrice(BigDecimal.ZERO);
         recordDetailDTO.setEndUnitPriceExcludingVat(BigDecimal.ZERO);
         recordDetailDTO.setEndAmount(BigDecimal.ZERO);
         recordDetailDTO.setEndAmountExcludingVat(BigDecimal.ZERO);
      }

      list.add(recordDetailDTO);
      InventoryDetailsRecordDetailDTO month = InventoryDetailsRecordDetailDTO.builder()
         .inboundQuantity(inQuantity)
         .inboundMete(inMete)
         .inboundAmount(inAmount)
         .inboundAmountExcludingVat(inAmountExcludingVat)
         .outboundMete(outMete)
         .outboundQuantity(outQuantity)
         .outboundAmount(outAmount)
         .outboundAmountExcludingVat(outAmountExcludingVat)
         .summary("本月合计")
         .build();
      month.setInboundUnitPrice(
         month.getInboundMete().compareTo(BigDecimal.ZERO) > 0
            ? month.getInboundAmount().divide(month.getInboundMete(), 12, RoundingMode.HALF_UP)
            : BigDecimal.ZERO
      );
      month.setInboundUnitPriceExcludingVat(
         month.getInboundMete().compareTo(BigDecimal.ZERO) > 0
            ? month.getInboundAmountExcludingVat().divide(month.getInboundMete(), 12, RoundingMode.HALF_UP)
            : BigDecimal.ZERO
      );
      if (month.getOutboundMete() != null) {
         month.setOutboundUnitPrice(
            month.getOutboundAmount().compareTo(BigDecimal.ZERO) > 0
               ? month.getOutboundAmount().divide(month.getOutboundMete(), 12, RoundingMode.HALF_UP)
               : BigDecimal.ZERO
         );
         month.setOutboundUnitPriceExcludingVat(
            month.getOutboundAmountExcludingVat().compareTo(BigDecimal.ZERO) > 0
               ? month.getOutboundAmountExcludingVat().divide(month.getOutboundMete(), 12, RoundingMode.HALF_UP)
               : BigDecimal.ZERO
         );
      } else {
         month.setOutboundUnitPrice(BigDecimal.ZERO);
         month.setOutboundUnitPriceExcludingVat(BigDecimal.ZERO);
      }

      list.add(month);
      return month;
   }

   private void setDetailMap(Map<String, StatisticsDTO> map, Map<String, List<String>> specMap, List<StatisticsDTO> statisticsDTOS) {
      WeightedPriceConf weightedPriceConf = JSON.parseObject(
         this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置")).getValue(), WeightedPriceConf.class
      );

      for (StatisticsDTO statisticsDTO : statisticsDTOS) {
         Map<String, String> detailKey = new HashMap<>();
         statisticsDTO.setWeightedPriceType(weightedPriceConf.getWeightedType());
         detailKey.put("classifyId", statisticsDTO.getClassifyId().toString());
         if (statisticsDTO.getThickness() != null) {
            detailKey.put("thickness", statisticsDTO.getThickness().toString());
         }

         detailKey.put("brand", statisticsDTO.getBrand());
         detailKey.put("color", statisticsDTO.getColor());
         detailKey.put("HN", statisticsDTO.getHeatNoAndBatchNo());
         if (statisticsDTO.getWorkshop() != null) {
            detailKey.put("workshopId", statisticsDTO.getWorkshop().getId().toString());
         }

         detailKey.put("standard", statisticsDTO.getStandardId() != null ? statisticsDTO.getStandardId().toString() : null);
         detailKey.put("boolPartyA", statisticsDTO.getBoolPartyA() ? "1" : "0");
         if (statisticsDTO.getBoolPartyA()) {
            detailKey.put("projectId", statisticsDTO.getProject().getId().toString());
            detailKey.put("specs", statisticsDTO.getSpecs());
         }

         if (WeightedPriceEnum.SINGLE.getType().equals(weightedPriceConf.getWeightedType())) {
            detailKey.put("projectId", statisticsDTO.getProject() != null ? statisticsDTO.getProject().getId().toString() : "0");
            detailKey.put("specs", statisticsDTO.getSpecs());
         } else {
            statisticsDTO.setProject(null);
         }

         detailKey.put("weightedType", weightedPriceConf.getWeightedType().toString());
         String key = JSON.toJSONString(detailKey);
         StatisticsDTO detailsRecordDTO = map.get(key);
         List<String> list = specMap.get(key);
         List<String> specs = StrUtil.split(statisticsDTO.getSpecs(), ",");
         if (CollectionUtil.isNotEmpty(list)) {
            list.removeAll(specs);
            list.addAll(specs);
            specMap.put(key, list);
         } else {
            specMap.put(key, statisticsDTO.getSpecs() != null ? StrUtil.split(statisticsDTO.getSpecs(), ",") : new ArrayList<>());
         }

         if (detailsRecordDTO == null) {
            statisticsDTO.setDetailKey(key);
            statisticsDTO.setSpecifications(specs);
            if (statisticsDTO.getId() != null) {
               statisticsDTO.setIds(new ArrayList<>(Collections.singletonList(statisticsDTO.getId())));
            } else {
               statisticsDTO.setStatIds(new ArrayList<>(Collections.singletonList(statisticsDTO.getStatId())));
            }

            map.put(key, statisticsDTO);
         } else {
            if (CollectionUtil.isNotEmpty(specs)) {
               List<String> specifications = detailsRecordDTO.getSpecifications();
               if (CollectionUtil.isNotEmpty(specifications)) {
                  specifications.removeAll(specs);
                  specifications.addAll(specs);
               }
            }

            DetailDTO inboundDTO = detailsRecordDTO.getInbound();
            DetailDTO inbound = statisticsDTO.getInbound();
            this.dataHandle(inboundDTO, inbound);
            if (inboundDTO != null) {
               detailsRecordDTO.setInbound(inboundDTO);
            }

            DetailDTO outboundDTO = detailsRecordDTO.getOutbound();
            DetailDTO outbound = statisticsDTO.getOutbound();
            this.dataHandle(outboundDTO, outbound);
            if (outboundDTO != null) {
               detailsRecordDTO.setOutbound(outboundDTO);
            }

            DetailDTO beginPeriodDTO = detailsRecordDTO.getBeginPeriod();
            DetailDTO beginPeriod = statisticsDTO.getBeginPeriod();
            this.dataHandle(beginPeriodDTO, beginPeriod);
            if (beginPeriodDTO != null) {
               detailsRecordDTO.setBeginPeriod(beginPeriodDTO);
            }

            DetailDTO endPeriodDTO = detailsRecordDTO.getEndPeriod();
            DetailDTO endPeriod = statisticsDTO.getEndPeriod();
            this.dataHandle(endPeriodDTO, endPeriod);
            if (endPeriodDTO != null) {
               detailsRecordDTO.setEndPeriod(endPeriodDTO);
            }

            if (statisticsDTO.getId() != null) {
               List<Long> ids = detailsRecordDTO.getIds();
               if (CollectionUtil.isNotEmpty(ids)) {
                  ids.add(statisticsDTO.getId());
               } else {
                  ids = CollectionUtil.newArrayList(statisticsDTO.getId());
               }

               detailsRecordDTO.setIds(ids);
            }

            if (statisticsDTO.getStatId() != null) {
               List<Long> ids = detailsRecordDTO.getStatIds();
               if (CollectionUtil.isNotEmpty(ids)) {
                  ids.add(statisticsDTO.getId());
               } else {
                  ids = CollectionUtil.newArrayList(statisticsDTO.getId());
               }

               detailsRecordDTO.setStatIds(ids);
            }

            map.put(key, detailsRecordDTO);
         }
      }
   }

   private void dataHandle(DetailDTO source, DetailDTO add) {
      if (source != null) {
         if (add != null) {
            if (source.getQuantity() != null) {
               if (add.getQuantity() != null) {
                  source.setQuantity(source.getQuantity().add(add.getQuantity()));
               }
            } else if (add.getQuantity() != null) {
               source.setQuantity(add.getQuantity());
            }

            if (source.getMete() != null) {
               if (add.getMete() != null) {
                  source.setMete(source.getMete().add(add.getMete()));
               }
            } else if (add.getMete() != null) {
               source.setMete(add.getMete());
            }

            if (source.getAmount() != null) {
               if (add.getAmount() != null) {
                  source.setAmount(source.getAmount().add(add.getAmount()));
               }
            } else if (add.getAmount() != null) {
               source.setAmount(add.getAmount());
            }

            if (source.getAmountExcludingVAT() != null) {
               if (add.getAmountExcludingVAT() != null) {
                  source.setAmountExcludingVAT(source.getAmountExcludingVAT().add(add.getAmountExcludingVAT()));
               }
            } else if (add.getAmountExcludingVAT() != null) {
               source.setAmountExcludingVAT(add.getAmountExcludingVAT());
            }
         }
      } else if (add != null) {
         source = BeanUtil.copy(add, DetailDTO.class);
      }
   }

   @Override
   public PageVO<CutSurplusDTO> getCutSurplus(
      Long projectId, String cutTaskId, List<LocalDateTime> endTime, Integer pageNumber, Integer pageSize, List<String> sort
   ) {
      String s = StringUtils.analyzeSortConditions(sort);
      Page page = PageHelper.startPage(pageNumber, pageSize, s);
      return new PageVO<>(page, this.cutSurplusRecordMapper.getList(projectId, cutTaskId, endTime));
   }

   @Override
   public StatisticsPageVO<PSIRecordDTO> getPSIList(
      Integer basicClass,
      List<LocalDateTime> times,
      String spec,
      BigDecimal thickness,
      Long classifyId,
      Integer pageNumber,
      Integer pageSize,
      List<String> sort
   ) {
      if (spec != null && spec.equals("无规格")) {
         spec = "";
      }

      Map<String, List<BriefClassDTO>> map = new HashMap<>();
      List<PSIRecordDTO> list = null;
      Map<Long, Measure> measureMap = this.queryUtil.getMeasureMap();
      if (!BasicClassEnum.STEEL_PLATE.getType().equals(basicClass) && !BasicClassEnum.COLOR_ROLL.getType().equals(basicClass)) {
         if (BasicClassEnum.SECTION_STEEL.getType().equals(basicClass)) {
            List<InboundDetail> detailList = this.inboundDetailMapper.getMeteByTimes(basicClass, times, spec, null, classifyId, null);
            List<RejectDetail> rejectDetails = new ArrayList<>();
            if (CollectionUtil.isNotEmpty(detailList)) {
               List<Long> detailIds = detailList.stream().map(InboundDetail::getId).collect(Collectors.toList());
               rejectDetails = this.rejectDetailMapper.getDetailByInboundDetailIds(detailIds);
            }

            Map<String, PSIRecordDTO> mm = new HashMap<>();

            for (InboundDetail inboundDetail : detailList) {
               List<RejectDetail> rejectDetailList = rejectDetails.stream()
                  .filter(r -> r.getInboundDetailId().equals(inboundDetail.getId()))
                  .collect(Collectors.toList());
               BigDecimal rejectMete = rejectDetailList.stream().map(RejectDetail::getMete).reduce(BigDecimal.ZERO, BigDecimal::add);
               inboundDetail.setMete(inboundDetail.getMete().subtract(rejectMete));
               Measure measure = measureMap.get(inboundDetail.getClassifyId());
               if (ObjectUtil.isNotEmpty(measure.getMeasureUnit()) && ObjectUtil.isNotEmpty(measure.getMeasurePrecision())) {
                  BigDecimal rejectQuantity = rejectDetailList.stream().map(RejectDetail::getQuantity).reduce(BigDecimal.ZERO, BigDecimal::add);
                  inboundDetail.setQuantity(inboundDetail.getQuantity().subtract(rejectQuantity));
               }

               String key = inboundDetail.getClassifyId() + "-" + inboundDetail.getSpecification();
               PSIRecordDTO dto = mm.get(key);
               if (dto != null) {
                  dto.setInboundMete(dto.getInboundMete().add(inboundDetail.getMete()));
                  dto.setInboundQuantity(ObjectUtil.isNotEmpty(dto.getInboundQuantity()) ? dto.getInboundQuantity().add(inboundDetail.getQuantity()) : null);
                  mm.put(key, dto);
               } else {
                  PSIRecordDTO copy = BeanUtil.copy(inboundDetail, PSIRecordDTO.class);
                  copy.setInboundMete(inboundDetail.getMete());
                  copy.setLength(null);
                  copy.setInboundQuantity(inboundDetail.getQuantity());
                  copy.setMeasureUnit(measure.getMeasureUnit());
                  mm.put(key, copy);
               }
            }

            list = new ArrayList<>(mm.values());
            List<MaterialInventoryDTO> psiOutboundDetailList = new ArrayList<>();
            List<ReturnDetailDTO> returnDetailDTOS = new ArrayList<>();
            List<MaterialInventoryDTO> materialInventoryDTOS = new ArrayList<>();
            if (CollectionUtil.isNotEmpty(list)) {
               List<Long> classifyIds = list.stream().map(PSIRecordDTO::getClassifyId).collect(Collectors.toList());
               psiOutboundDetailList = this.outboundDetailMapper.getPSIOutboundDetailByClassifyIdsAndTimes(classifyIds, times);
               if (CollectionUtil.isNotEmpty(psiOutboundDetailList)) {
                  List<Long> outbounDetailIds = psiOutboundDetailList.stream().map(MaterialInventoryDTO::getId).collect(Collectors.toList());
                  returnDetailDTOS = this.returnDetailMapper.getListByOutboundDetailIds(outbounDetailIds);
               }

               materialInventoryDTOS = this.materialInventoryMapper.getPSIInventoryDetailByClassifyIds(classifyIds);
            }

            for (PSIRecordDTO dto : list) {
               String[] split = dto.getSpecification().split(" \\* ");
               String sp = split.length > 1 ? split[1] : "无规格";
               List<BriefClassDTO> values = map.get(sp);
               if (CollectionUtil.isNotEmpty(values)) {
                  boolean boolAdd = false;
                  if (CollectionUtil.isEmpty(values.stream().filter(v -> v.getValue().equals(dto.getClassifyName())).collect(Collectors.toList()))) {
                     boolAdd = true;
                  }

                  if (boolAdd) {
                     values.add(BriefClassDTO.builder().label(dto.getClassifyId().toString()).value(dto.getClassifyName()).build());
                     map.put(sp, values);
                  }
               } else {
                  ArrayList<BriefClassDTO> arrayList = new ArrayList<>();
                  arrayList.add(BriefClassDTO.builder().label(dto.getClassifyId().toString()).value(dto.getClassifyName()).build());
                  map.put(sp, arrayList);
               }

               List<MaterialInventoryDTO> psiOutboundDetail = psiOutboundDetailList.stream()
                  .filter(
                     materialInventoryDTO -> {
                        boolean bool1 = materialInventoryDTO.getClassifyId().equals(dto.getClassifyId());
                        boolean bool2 = ObjectUtil.isNotEmpty(dto.getSpecification())
                           ? ObjectUtil.equal(materialInventoryDTO.getSpecification(), dto.getSpecification())
                           : true;
                        return bool1 && bool2;
                     }
                  )
                  .collect(Collectors.toList());
               if (CollectionUtil.isNotEmpty(psiOutboundDetail)) {
                  BigDecimal outMete = psiOutboundDetail.stream().map(MaterialInventoryDTO::getMete).reduce(BigDecimal.ZERO, BigDecimal::add);
                  List<Long> ids = psiOutboundDetail.stream().map(MaterialInventoryDTO::getId).collect(Collectors.toList());
                  List<ReturnDetailDTO> returnDetails = returnDetailDTOS.stream()
                     .filter(r -> ids.contains(r.getOutboundDetailId()))
                     .collect(Collectors.toList());
                  BigDecimal returnMete = returnDetails.stream().map(ReturnDetailDTO::getMete).reduce(BigDecimal.ZERO, BigDecimal::add);
                  dto.setOutboundMete(outMete.subtract(returnMete));
                  if (ObjectUtil.isNotEmpty(psiOutboundDetail.get(0).getQuantity())) {
                     BigDecimal outboundQuantity = psiOutboundDetail.stream().map(MaterialInventoryDTO::getQuantity).reduce(BigDecimal.ZERO, BigDecimal::add);
                     BigDecimal returnQuantity = returnDetails.stream().map(ReturnDetailDTO::getQuantity).reduce(BigDecimal.ZERO, BigDecimal::add);
                     dto.setOutboundQuantity(outboundQuantity.subtract(returnQuantity));
                  }
               }

               List<MaterialInventoryDTO> psiInventoryDetail = materialInventoryDTOS.stream()
                  .filter(
                     materialInventoryDTO -> {
                        boolean bool1 = materialInventoryDTO.getClassifyId().equals(dto.getClassifyId());
                        boolean bool2 = ObjectUtil.isNotEmpty(dto.getSpecification())
                           ? ObjectUtil.equal(materialInventoryDTO.getSpecification(), dto.getSpecification())
                           : true;
                        return bool1 && bool2;
                     }
                  )
                  .collect(Collectors.toList());
               BigDecimal reduce = psiInventoryDetail.stream().map(MaterialInventoryDTO::getMete).reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal reduceQuantity = psiInventoryDetail.stream()
                  .map(MaterialInventoryDTO::getQuantity)
                  .filter(ObjectUtil::isNotEmpty)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               dto.setInventoryMete(reduce);
               dto.setInventoryQuantity(reduceQuantity);
            }
         } else if (BasicClassEnum.GENERAL_MATERIAL.getType().equals(basicClass)) {
            List<Long> ids = null;
            if (classifyId != null) {
               Classification classification = this.classificationService.getById(classifyId);
               if (!classification.getBoolLastEnum()) {
                  ids = this.classificationService.getLastSubject(classifyId).stream().map(Classification::getId).collect(Collectors.toList());
               }
            }

            List<InboundDetail> detailList = this.inboundDetailMapper.getMeteByTimes(basicClass, times, null, null, null, ids);
            List<RejectDetail> rejectDetails = new ArrayList<>();
            if (CollectionUtil.isNotEmpty(detailList)) {
               List<Long> detailIds = detailList.stream().map(InboundDetail::getId).collect(Collectors.toList());
               rejectDetails = this.rejectDetailMapper.getDetailByInboundDetailIds(detailIds);
            }

            Map<String, PSIRecordDTO> mm = new HashMap<>();

            for (InboundDetail inboundDetail : detailList) {
               List<RejectDetail> rejectDetailList = rejectDetails.stream()
                  .filter(r -> r.getInboundDetailId().equals(inboundDetail.getId()))
                  .collect(Collectors.toList());
               BigDecimal rejectMete = rejectDetailList.stream().map(RejectDetail::getMete).reduce(BigDecimal.ZERO, BigDecimal::add);
               inboundDetail.setMete(inboundDetail.getMete().subtract(rejectMete));
               Measure measure = measureMap.get(inboundDetail.getClassifyId());
               if (ObjectUtil.isNotEmpty(measure.getMeasureUnit()) && ObjectUtil.isNotEmpty(measure.getMeasurePrecision())) {
                  BigDecimal rejectQuantity = rejectDetailList.stream().map(RejectDetail::getQuantity).reduce(BigDecimal.ZERO, BigDecimal::add);
                  inboundDetail.setQuantity(inboundDetail.getQuantity().subtract(rejectQuantity));
               }

               String key = inboundDetail.getClassifyId() + "-" + inboundDetail.getSpecification();
               PSIRecordDTO dto = mm.get(key);
               if (dto != null) {
                  dto.setInboundMete(dto.getInboundMete().add(inboundDetail.getMete()));
                  dto.setInboundQuantity(ObjectUtil.isNotEmpty(dto.getInboundQuantity()) ? dto.getInboundQuantity().add(inboundDetail.getQuantity()) : null);
                  mm.put(key, dto);
               } else {
                  PSIRecordDTO copy = BeanUtil.copy(inboundDetail, PSIRecordDTO.class);
                  copy.setInboundMete(inboundDetail.getMete());
                  copy.setInboundQuantity(inboundDetail.getQuantity());
                  copy.setMeasureUnit(measure.getMeasureUnit());
                  mm.put(key, copy);
               }
            }

            list = new ArrayList<>(mm.values());
            List<Classification> classifications = this.classificationService
               .list((Wrapper<Classification>)new LambdaQueryWrapper<Classification>().eq(Classification::getBasicClass, BasicClassEnum.GENERAL_MATERIAL.getType()));
            Map<Long, Classification> classificationMap = classifications.stream().collect(Collectors.toMap(Classification::getId, Function.identity()));
            List<MaterialInventoryDTO> psiOutboundDetailList = new ArrayList<>();
            List<ReturnDetailDTO> returnDetailDTOS = new ArrayList<>();
            List<MaterialInventoryDTO> materialInventoryDTOS = new ArrayList<>();
            if (CollectionUtil.isNotEmpty(list)) {
               List<Long> classifyIds = list.stream().map(PSIRecordDTO::getClassifyId).collect(Collectors.toList());
               psiOutboundDetailList = this.outboundDetailMapper.getPSIOutboundDetailByClassifyIdsAndTimes(classifyIds, times);
               if (CollectionUtil.isNotEmpty(psiOutboundDetailList)) {
                  List<Long> outbounDetailIds = psiOutboundDetailList.stream().map(MaterialInventoryDTO::getId).collect(Collectors.toList());
                  returnDetailDTOS = this.returnDetailMapper.getListByOutboundDetailIds(outbounDetailIds);
               }

               materialInventoryDTOS = this.materialInventoryMapper.getPSIInventoryDetailByClassifyIds(classifyIds);
            }

            List<BriefClassDTO> l = new ArrayList<>();

            for (PSIRecordDTO dto : list) {
               Classification classify = classificationMap.get(dto.getClassifyId());
               Classification p = classificationMap.get(CommonUtil.spilt(classify.getPath(), ",").get(0));
               if (CollectionUtil.isEmpty(l.stream().filter(v -> v.getLabel().equals(p.getId().toString())).collect(Collectors.toList()))) {
                  l.add(BriefClassDTO.builder().label(p.getId().toString()).value(p.getName()).build());
               }

               List<MaterialInventoryDTO> psiOutboundDetail = psiOutboundDetailList.stream()
                  .filter(
                     materialInventoryDTO -> {
                        boolean bool1 = materialInventoryDTO.getClassifyId().equals(dto.getClassifyId());
                        boolean bool2 = ObjectUtil.isNotEmpty(dto.getSpecification())
                           ? ObjectUtil.equal(materialInventoryDTO.getSpecification(), dto.getSpecification())
                           : true;
                        return bool1 && bool2;
                     }
                  )
                  .collect(Collectors.toList());
               if (CollectionUtil.isNotEmpty(psiOutboundDetail)) {
                  BigDecimal outMete = psiOutboundDetail.stream().map(MaterialInventoryDTO::getMete).reduce(BigDecimal.ZERO, BigDecimal::add);
                  List<Long> materialInventoryIds = psiOutboundDetail.stream().map(MaterialInventoryDTO::getId).collect(Collectors.toList());
                  List<ReturnDetailDTO> returnDetails = returnDetailDTOS.stream()
                     .filter(r -> materialInventoryIds.contains(r.getOutboundDetailId()))
                     .collect(Collectors.toList());
                  BigDecimal returnMete = returnDetails.stream().map(ReturnDetailDTO::getMete).reduce(BigDecimal.ZERO, BigDecimal::add);
                  dto.setOutboundMete(outMete.subtract(returnMete));
                  if (ObjectUtil.isNotEmpty(psiOutboundDetail.get(0).getQuantity())) {
                     BigDecimal outboundQuantity = psiOutboundDetail.stream().map(MaterialInventoryDTO::getQuantity).reduce(BigDecimal.ZERO, BigDecimal::add);
                     BigDecimal returnQuantity = returnDetails.stream().map(ReturnDetailDTO::getQuantity).reduce(BigDecimal.ZERO, BigDecimal::add);
                     dto.setOutboundQuantity(outboundQuantity.subtract(returnQuantity));
                  }
               }

               List<MaterialInventoryDTO> psiInventoryDetail = materialInventoryDTOS.stream()
                  .filter(
                     materialInventoryDTO -> {
                        boolean bool1 = materialInventoryDTO.getClassifyId().equals(dto.getClassifyId());
                        boolean bool2 = ObjectUtil.isNotEmpty(dto.getSpecification())
                           ? ObjectUtil.equal(materialInventoryDTO.getSpecification(), dto.getSpecification())
                           : true;
                        return bool1 && bool2;
                     }
                  )
                  .collect(Collectors.toList());
               BigDecimal reduce = psiInventoryDetail.stream().map(MaterialInventoryDTO::getMete).reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal reduceQuantity = psiInventoryDetail.stream()
                  .map(MaterialInventoryDTO::getQuantity)
                  .filter(ObjectUtil::isNotEmpty)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               dto.setInventoryMete(reduce);
               dto.setInventoryQuantity(reduceQuantity);
            }

            map.put("辅材", l);
         }
      } else {
         List<InboundDetail> detailList = this.inboundDetailMapper.getMeteByTimes(basicClass, times, spec, thickness, null, null);
         List<RejectDetail> rejectDetails = new ArrayList<>();
         if (CollectionUtil.isNotEmpty(detailList)) {
            List<Long> detailIds = detailList.stream().map(InboundDetail::getId).collect(Collectors.toList());
            rejectDetails = this.rejectDetailMapper.getDetailByInboundDetailIds(detailIds);
         }

         Map<String, PSIRecordDTO> mm = new HashMap<>();

         for (InboundDetail inboundDetail : detailList) {
            List<RejectDetail> rejectDetailList = rejectDetails.stream()
               .filter(r -> r.getInboundDetailId().equals(inboundDetail.getId()))
               .collect(Collectors.toList());
            BigDecimal rejectMete = rejectDetailList.stream().map(RejectDetail::getMete).reduce(BigDecimal.ZERO, BigDecimal::add);
            inboundDetail.setMete(inboundDetail.getMete().subtract(rejectMete));
            Measure measure = measureMap.get(inboundDetail.getClassifyId());
            if (ObjectUtil.isNotEmpty(measure.getMeasureUnit()) && ObjectUtil.isNotEmpty(measure.getMeasurePrecision())) {
               BigDecimal rejectQuantity = rejectDetailList.stream().map(RejectDetail::getQuantity).reduce(BigDecimal.ZERO, BigDecimal::add);
               inboundDetail.setQuantity(inboundDetail.getQuantity().subtract(rejectQuantity));
            }

            String key = inboundDetail.getClassifyId()
               + "-"
               + inboundDetail.getLength()
               + "-"
               + inboundDetail.getWidth()
               + "-"
               + inboundDetail.getThickness()
               + "-"
               + inboundDetail.getSpecification();
            PSIRecordDTO dto = mm.get(key);
            if (dto != null) {
               dto.setInboundMete(dto.getInboundMete().add(inboundDetail.getMete()));
               dto.setInboundQuantity(ObjectUtil.isNotEmpty(dto.getInboundQuantity()) ? dto.getInboundQuantity().add(inboundDetail.getQuantity()) : null);
               mm.put(key, dto);
            } else {
               PSIRecordDTO copy = BeanUtil.copy(inboundDetail, PSIRecordDTO.class);
               copy.setInboundMete(inboundDetail.getMete());
               copy.setInboundQuantity(inboundDetail.getQuantity());
               copy.setMeasureUnit(measure.getMeasureUnit());
               mm.put(key, copy);
            }
         }

         list = new ArrayList<>(mm.values());
         List<MaterialInventoryDTO> psiOutboundDetailList = new ArrayList<>();
         List<ReturnDetailDTO> returnDetailDTOS = new ArrayList<>();
         List<MaterialInventoryDTO> materialInventoryDTOS = new ArrayList<>();
         if (CollectionUtil.isNotEmpty(list)) {
            List<Long> classifyIds = list.stream().map(PSIRecordDTO::getClassifyId).collect(Collectors.toList());
            psiOutboundDetailList = this.outboundDetailMapper.getPSIOutboundDetailByClassifyIdsAndTimes(classifyIds, times);
            if (CollectionUtil.isNotEmpty(psiOutboundDetailList)) {
               List<Long> outbounDetailIds = psiOutboundDetailList.stream().map(MaterialInventoryDTO::getId).collect(Collectors.toList());
               returnDetailDTOS = this.returnDetailMapper.getListByOutboundDetailIds(outbounDetailIds);
            }

            materialInventoryDTOS = this.materialInventoryMapper.getPSIInventoryDetailByClassifyIds(classifyIds);
         }

         for (PSIRecordDTO dto : list) {
            String th = dto.getThickness().stripTrailingZeros().toPlainString();
            String sp = StrUtil.isNotBlank(dto.getSpecification()) ? dto.getSpecification() : "无规格";
            if (StrUtil.isNotBlank(sp)) {
               List<BriefClassDTO> values = map.get(sp);
               if (CollectionUtil.isNotEmpty(values)) {
                  boolean boolAdd = false;
                  if (CollectionUtil.isEmpty(values.stream().filter(v -> v.getValue().equals(th)).collect(Collectors.toList()))) {
                     boolAdd = true;
                  }

                  if (boolAdd) {
                     values.add(BriefClassDTO.builder().label(th).value(th).build());
                     map.put(sp, values);
                  }
               } else {
                  ArrayList<BriefClassDTO> arrayList = new ArrayList<>();
                  arrayList.add(BriefClassDTO.builder().label(th).value(th).build());
                  map.put(sp, arrayList);
               }
            }

            List<MaterialInventoryDTO> psiOutboundDetail = psiOutboundDetailList.stream()
               .filter(
                  materialInventoryDTO -> {
                     boolean bool1 = materialInventoryDTO.getClassifyId().equals(dto.getClassifyId());
                     boolean bool2 = ObjectUtil.isNotEmpty(dto.getSpecification())
                        ? ObjectUtil.equal(materialInventoryDTO.getSpecification(), dto.getSpecification())
                        : true;
                     boolean bool3 = dto.getWidth() != null ? ObjectUtil.equal(materialInventoryDTO.getWidth(), dto.getWidth()) : true;
                     boolean bool4 = !BasicClassEnum.COLOR_ROLL.getType().equals(basicClass) && dto.getLength() != null
                        ? ObjectUtil.equals(materialInventoryDTO.getLength(), dto.getLength())
                        : true;
                     boolean bool5 = dto.getThickness() != null ? ObjectUtil.equals(materialInventoryDTO.getThickness(), dto.getThickness()) : true;
                     return bool1 && bool2 && bool3 && bool4 && bool5;
                  }
               )
               .collect(Collectors.toList());
            if (CollectionUtil.isNotEmpty(psiOutboundDetail)) {
               BigDecimal outMete = psiOutboundDetail.stream().map(MaterialInventoryDTO::getMete).reduce(BigDecimal.ZERO, BigDecimal::add);
               List<Long> ids = psiOutboundDetail.stream().map(MaterialInventoryDTO::getId).collect(Collectors.toList());
               List<ReturnDetailDTO> returnDetails = returnDetailDTOS.stream().filter(r -> ids.contains(r.getOutboundDetailId())).collect(Collectors.toList());
               BigDecimal returnMete = returnDetails.stream().map(ReturnDetailDTO::getMete).reduce(BigDecimal.ZERO, BigDecimal::add);
               dto.setOutboundMete(outMete.subtract(returnMete));
               if (ObjectUtil.isNotEmpty(psiOutboundDetail.get(0).getQuantity())) {
                  BigDecimal outboundQuantity = psiOutboundDetail.stream().map(MaterialInventoryDTO::getQuantity).reduce(BigDecimal.ZERO, BigDecimal::add);
                  BigDecimal returnQuantity = returnDetails.stream().map(ReturnDetailDTO::getQuantity).reduce(BigDecimal.ZERO, BigDecimal::add);
                  dto.setOutboundQuantity(outboundQuantity.subtract(returnQuantity));
               }
            }

            List<MaterialInventoryDTO> psiInventoryDetail = materialInventoryDTOS.stream()
               .filter(
                  materialInventoryDTO -> {
                     boolean bool1 = materialInventoryDTO.getClassifyId().equals(dto.getClassifyId());
                     boolean bool2 = ObjectUtil.isNotEmpty(dto.getSpecification())
                        ? ObjectUtil.equal(materialInventoryDTO.getSpecification(), dto.getSpecification())
                        : true;
                     boolean bool3 = dto.getWidth() != null ? ObjectUtil.equal(materialInventoryDTO.getWidth(), dto.getWidth()) : true;
                     boolean bool4 = !BasicClassEnum.COLOR_ROLL.getType().equals(basicClass) && dto.getLength() != null
                        ? ObjectUtil.equals(materialInventoryDTO.getLength(), dto.getLength())
                        : true;
                     boolean bool5 = dto.getThickness() != null ? ObjectUtil.equals(materialInventoryDTO.getThickness(), dto.getThickness()) : true;
                     return bool1 && bool2 && bool3 && bool4 && bool5;
                  }
               )
               .collect(Collectors.toList());
            BigDecimal reduce = psiInventoryDetail.stream().map(MaterialInventoryDTO::getMete).reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal reduceQuantity = psiInventoryDetail.stream()
               .map(MaterialInventoryDTO::getQuantity)
               .filter(ObjectUtil::isNotEmpty)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            dto.setInventoryMete(reduce);
            dto.setInventoryQuantity(reduceQuantity);
         }
      }

      StatisticsPageVO<PSIRecordDTO> statisticsPageVO = null;
      if (pageNumber != null) {
         if (CollectionUtil.isNotEmpty(list)) {
            Page<PSIRecordDTO> page = CommonUtil.getPage(pageNumber, pageSize, list);
            statisticsPageVO = new StatisticsPageVO<>(page, page.getResult());
            statisticsPageVO.setSpec(
               BasicClassEnum.GENERAL_MATERIAL.getType().equals(basicClass)
                  ? map.get("辅材")
                  : map.keySet().stream().map(k -> BriefClassDTO.builder().label(k).value(k).list(map.get(k)).build()).collect(Collectors.toList())
            );
         }
      } else {
         statisticsPageVO = new StatisticsPageVO<>();
         statisticsPageVO.setContent(list);
      }

      return statisticsPageVO;
   }

   @Override
   public PageVO<MaterialInventoryDTO> getPSIDetailList(
      Long classifyId,
      String spec,
      BigDecimal width,
      BigDecimal length,
      BigDecimal thickness,
      Integer type,
      List<LocalDateTime> times,
      Integer pageNumber,
      Integer pageSize,
      List<String> sort
   ) {
      Page page = null;
      if (pageNumber != null) {
         page = PageHelper.startPage(pageNumber, pageSize);
      }

      List<MaterialInventoryDTO> list;
      if (type == 1) {
         list = this.inboundDetailMapper.getPSIInboundDetail(classifyId, times, spec, width, length, thickness);
         List<RejectDetail> all = new ArrayList<>();

         for (MaterialInventoryDTO materialInventoryDTO : list) {
            List<RejectDetail> details = this.rejectDetailMapper.getDetailByInboundDetailId(materialInventoryDTO.getId()).stream().peek(r -> {
               if (r.getQuantity() != null) {
                  r.setQuantity(r.getQuantity().negate());
               }

               r.setMete(r.getMete().negate());
               r.setAmountExcludingVat(r.getAmountExcludingVat().negate());
               r.setAmount(r.getAmount().negate());
            }).collect(Collectors.toList());
            all.addAll(details);
         }

         list.addAll(all.stream().map(r -> {
            MaterialInventoryDTO copy = BeanUtil.copy(r, MaterialInventoryDTO.class);
            copy.setAmountExcludingVAT(r.getAmountExcludingVat());
            copy.setUnitPriceExcludingVAT(r.getUnitPriceExcludingVat());
            return copy;
         }).collect(Collectors.toList()));
      } else if (type == 2) {
         list = this.outboundDetailMapper.getPSIOutboundDetail(classifyId, times, spec, width, length, thickness);
         List<ReturnDetail> all = new ArrayList<>();

         for (MaterialInventoryDTO materialInventoryDTO : list) {
            List<ReturnDetail> detailList = this.returnDetailMapper.getListByOutboundDetailId(materialInventoryDTO.getId().toString()).stream().peek(r -> {
               if (r.getQuantity() != null) {
                  r.setQuantity(r.getQuantity().negate());
               }

               r.setMete(r.getMete().negate());
               if (r.getAmount() != null) {
                  r.setAmountExcludingVat(r.getAmountExcludingVat().negate());
                  r.setAmount(r.getAmount().negate());
               }
            }).collect(Collectors.toList());
            all.addAll(detailList);
         }

         list.addAll(all.stream().map(r -> {
            MaterialInventoryDTO copy = BeanUtil.copy(r, MaterialInventoryDTO.class);
            copy.setAmountExcludingVAT(r.getAmountExcludingVat());
            copy.setUnitPriceExcludingVAT(r.getUnitPriceExcludingVat());
            return copy;
         }).collect(Collectors.toList()));
      } else {
         list = this.materialInventoryMapper.getPSIInventoryDetail(classifyId, spec, width, length, thickness).stream().peek(m -> {
            MaterialInventory materialInventory = BeanUtil.copy(m, MaterialInventory.class);
            if (m.getProject() != null) {
               materialInventory.setProjectId(m.getProject().getId());
            }

            materialInventory.setWorkshopId(m.getWorkshop().getId());
         }).collect(Collectors.toList());
      }

      PageVO<MaterialInventoryDTO> vo;
      if (pageNumber != null) {
         vo = new PageVO<>(page, list);
      } else {
         vo = new PageVO<>(list);
      }

      return vo;
   }

   private List<Long> getClassifyId(Long id) {
      if (id != null) {
         Classification classification = this.classificationService.getById(id);
         if (!classification.getBoolLastEnum()) {
            return this.classificationService.getLastSubject(id).stream().map(Classification::getId).collect(Collectors.toList());
         }
      }

      return null;
   }

   private void setValue(StatisticsDetailDTO dto) {
      dto.setBoolOddmentByHalfOut(MaterialIsWholeEnum.ODDMENT.getType().equals(dto.getMaterialIsWhole()));
      if (dto.getInvoiceType() != null && InvoiceTypeEnum.SPECIAL.getType().equals(dto.getInvoiceType())) {
         if (dto.getAmount() != null) {
            dto.setInputVAT(dto.getAmount().subtract(dto.getAmountExcludingVAT()));
         }

         if (dto.getAmountNoFreight() != null) {
            dto.setInputVATNoFreight(dto.getAmountNoFreight().subtract(dto.getAmountExcludingVATNoFreight()));
         }
      }
   }

   private Measure getMeasure(Long pid) {
      Measure m = this.measureService.getOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, pid));
      if (m.getAccountingUnit() != null) {
         return m;
      }

      Classification classification = this.classificationService.getById(pid);
      return this.getMeasure(classification.getParentId());
   }

   private Supplement getSupplement(
      MaterialInventory materialInventory,
      Statistics statistics,
      BigDecimal mete,
      BigDecimal amount,
      BigDecimal amountExcludingVat,
      BigDecimal amountNoFreight,
      BigDecimal amountExcludingVatNoFreight
   ) {
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
         .mete(mete)
         .amount(amount)
         .amountExcludingVat(amountExcludingVat)
         .amountNoFreight(amountNoFreight)
         .amountExcludingVatNoFreight(amountExcludingVatNoFreight)
         .materialInventoryId(materialInventory.getId())
         .build();
      Integer maxDayNumber = this.supplementMapper.getMaxDayNumber(LocalDateTime.now());
      supplement.setSerialNumber(this.numberConfigService.getNumber(NumberTypeEnum.SUPPLEMENT, maxDayNumber));
      supplement.setUpdateTime(LocalDateTime.now().minusHours(2L));
      this.supplementMapper.insert(supplement);
      supplement.setCreateTime(LocalDateTime.now().minusHours(2L));
      this.supplementMapper.updateById(supplement);
      StatisticsInbound inboundSupplement = BeanUtil.copy(materialInventory, StatisticsInbound.class, "createTime");
      inboundSupplement.setMete(mete);
      inboundSupplement.setAmount(amount);
      inboundSupplement.setAmountExcludingVat(amountExcludingVat);
      inboundSupplement.setStatisticsId(statistics.getId());
      inboundSupplement.setReceiptType(ReceiptTypeEnum.SUPPLEMENT.getType());
      inboundSupplement.setReceiptId(supplement.getId());
      inboundSupplement.setReceiptSerialNumber(supplement.getSerialNumber());
      inboundSupplement.setAmountNoFreight(amountNoFreight);
      inboundSupplement.setAmountExcludingVatNoFreight(amountExcludingVatNoFreight);
      inboundSupplement.setUpdateTime(LocalDateTime.now().minusHours(2L));
      this.statisticsInboundMapper.insert(inboundSupplement);
      inboundSupplement.setCreateTime(LocalDateTime.now().minusHours(2L));
      inboundSupplement.setRealTime(LocalDateTime.now().minusHours(2L));
      this.statisticsInboundMapper.updateById(inboundSupplement);
      statistics.setInboundAmount(statistics.getInboundAmount() != null ? statistics.getInboundAmount().add(amount) : amount);
      statistics.setInboundAmountExcludingVat(
         statistics.getInboundAmountExcludingVat() != null ? statistics.getInboundAmountExcludingVat().add(amountExcludingVat) : amountExcludingVat
      );
      statistics.setInboundAmountNoFreight(
         statistics.getInboundAmountNoFreight() != null ? statistics.getInboundAmountNoFreight().add(amountNoFreight) : amountNoFreight
      );
      statistics.setInboundAmountExcludingVatNoFreight(
         statistics.getInboundAmountExcludingVatNoFreight() != null
            ? statistics.getInboundAmountExcludingVatNoFreight().add(amountExcludingVatNoFreight)
            : amountExcludingVatNoFreight
      );
      if (mete != null) {
         this.statisticsEndPeriodMapper
            .delete(
               (Wrapper<StatisticsEndPeriod>)(Wrappers.<StatisticsEndPeriod>lambdaQuery().eq(StatisticsEndPeriod::getStatisticsId, statistics.getId()))
                  .eq(StatisticsEndPeriod::getMaterialInventoryId, materialInventory.getId())
            );
         statistics.setInboundMete(statistics.getInboundMete() != null ? statistics.getInboundMete().add(mete) : mete);
         statistics.setEndMete(statistics.getEndMete().add(mete));
      }

      this.statisticsMapper.updateById(statistics);
      return supplement;
   }

   private Supplement getSupplement1(
      MaterialInventory materialInventory,
      Statistics statistics,
      BigDecimal mete,
      BigDecimal amount,
      BigDecimal amountExcludingVat,
      BigDecimal amountNoFreight,
      BigDecimal amountExcludingVatNoFreight,
      MonthTimeRange monthTimeRange
   ) {
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
         .mete(mete)
         .amount(amount)
         .amountExcludingVat(amountExcludingVat)
         .amountNoFreight(amountNoFreight)
         .amountExcludingVatNoFreight(amountExcludingVatNoFreight)
         .realTime(monthTimeRange.getEndTime().minusMinutes(1L))
         .build();
      Integer maxDayNumber = this.supplementMapper.getMaxDayNumber(LocalDateTime.now());
      supplement.setSerialNumber(this.numberConfigService.getNumber(NumberTypeEnum.SUPPLEMENT, maxDayNumber));
      this.supplementMapper.insert(supplement);
      StatisticsInbound inboundSupplement = BeanUtil.copy(materialInventory, StatisticsInbound.class, "createTime");
      inboundSupplement.setMete(mete);
      inboundSupplement.setAmount(amount);
      inboundSupplement.setAmountExcludingVat(amountExcludingVat);
      inboundSupplement.setStatisticsId(statistics.getId());
      inboundSupplement.setReceiptType(ReceiptTypeEnum.SUPPLEMENT.getType());
      inboundSupplement.setReceiptId(supplement.getId());
      inboundSupplement.setReceiptSerialNumber(supplement.getSerialNumber());
      inboundSupplement.setRealTime(monthTimeRange.getEndTime().minusMinutes(1L));
      this.statisticsInboundMapper.insert(inboundSupplement);
      statistics.setInboundAmount(statistics.getInboundAmount() != null ? statistics.getInboundAmount().add(amount) : amount);
      statistics.setInboundAmountExcludingVat(
         statistics.getInboundAmountExcludingVat() != null ? statistics.getInboundAmountExcludingVat().add(amountExcludingVat) : amountExcludingVat
      );
      if (mete != null) {
         this.statisticsEndPeriodMapper
            .delete(
               (Wrapper<StatisticsEndPeriod>)(Wrappers.<StatisticsEndPeriod>lambdaQuery().eq(StatisticsEndPeriod::getStatisticsId, statistics.getId()))
                  .eq(StatisticsEndPeriod::getMaterialInventoryId, materialInventory.getId())
            );
         statistics.setInboundMete(statistics.getInboundMete() != null ? statistics.getInboundMete().add(mete) : mete);
         statistics.setEndMete(statistics.getEndMete().add(mete));
      }

      this.statisticsMapper.updateById(statistics);
      return supplement;
   }

   MonthWeightedAveragePrice getMothWap(MonthWeightedAveragePrice monthWAP, MonthTimeRange monthTimeRange, WmsClosingTime one) {
      monthWAP.setStartTime(monthTimeRange.getStartTime());
      monthWAP.setEndTime(monthTimeRange.getEndTime());
      List<Statistics> statisticsList = this.statisticsMapper
         .selectList((Wrapper<Statistics>)Wrappers.<Statistics>lambdaQuery().eq(Statistics::getWapId, monthWAP.getId()));
      List<StatisticsMonthRecord> statisticsMonthRecords = null;
      BigDecimal endAmountExcludingVat = BigDecimal.ZERO;
      BigDecimal endAmount = BigDecimal.ZERO;
      BigDecimal endMete = BigDecimal.ZERO;
      BigDecimal endAmountNoFreight = BigDecimal.ZERO;
      BigDecimal endAmountExcludingVatNoFreight = BigDecimal.ZERO;
      if (CollectionUtil.isNotEmpty(statisticsList)) {
         if (one != null) {
            List<Long> collect = statisticsList.stream().map(Statistics::getId).collect(Collectors.toList());
            if (CollectionUtil.isNotEmpty(collect)) {
               statisticsMonthRecords = this.statisticsMonthRecordMapper
                  .selectList(
                     (Wrapper<StatisticsMonthRecord>)(new LambdaQueryWrapper<StatisticsMonthRecord>().eq(StatisticsMonthRecord::getWmsClosingTimeId, one.getId()))
                        .in(StatisticsMonthRecord::getStatId, collect)
                  );
               if (CollectionUtil.isNotEmpty(statisticsMonthRecords)) {
                  endAmount = statisticsMonthRecords.stream()
                     .filter(statisticsMonthRecord -> statisticsMonthRecord.getEndAmount() != null)
                     .map(StatisticsMonthRecord::getEndAmount)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  endAmountExcludingVat = statisticsMonthRecords.stream()
                     .filter(statisticsMonthRecord -> statisticsMonthRecord.getEndAmountExcludingVat() != null)
                     .map(StatisticsMonthRecord::getEndAmountExcludingVat)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  endMete = statisticsMonthRecords.stream()
                     .filter(statisticsMonthRecord -> statisticsMonthRecord.getEndMete() != null)
                     .map(StatisticsMonthRecord::getEndMete)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  endAmountNoFreight = statisticsMonthRecords.stream()
                     .filter(statisticsMonthRecord -> statisticsMonthRecord.getEndAmountNoFreight() != null)
                     .map(StatisticsMonthRecord::getEndAmountNoFreight)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  endAmountExcludingVatNoFreight = statisticsMonthRecords.stream()
                     .filter(statisticsMonthRecord -> statisticsMonthRecord.getEndAmountExcludingVatNoFreight() != null)
                     .map(StatisticsMonthRecord::getEndAmountExcludingVatNoFreight)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
               }
            }
         }

         for (Statistics statistics : statisticsList) {
            if (ObjectUtil.isNotEmpty(statistics)) {
               List<StatisticsInbound> inboundDetailList = this.statisticsInboundMapper
                  .selectList(
                     (Wrapper<StatisticsInbound>)(new LambdaQueryWrapper<StatisticsInbound>().eq(StatisticsInbound::getStatisticsId, statistics.getId()))
                        .apply(StatisticsInboundMapper.EFFECTIVE_REAL_TIME_SQL + " BETWEEN {0} AND {1}", monthTimeRange.getStartTime(), monthTimeRange.getEndTime())
                  );
               List<StatisticsOutbound> moveOutboundDetails = this.statisticsOutboundMapper
                  .selectList(
                     (Wrapper<StatisticsOutbound>)((((new LambdaQueryWrapper<StatisticsOutbound>()
                                    .eq(StatisticsOutbound::getStatisticsId, statistics.getId()))
                                 .isNotNull(StatisticsOutbound::getAmount))
                              .isNotNull(StatisticsOutbound::getAmountExcludingVat))
                           .eq(StatisticsOutbound::getReceiptType, ReceiptTypeEnum.RETURN.getType()))
                        .between(StatisticsOutbound::getOutboundTime, monthTimeRange.getStartTime(), monthTimeRange.getEndTime())
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
                  endAmountNoFreight = endAmountNoFreight.add(inboundDetailAmountReduceNoFreight);
                  endAmountExcludingVatNoFreight = endAmountExcludingVatNoFreight.add(inboundDetailAmountExcludingVatReduceNoFreight);
                  endAmountExcludingVat = endAmountExcludingVat.add(inboundDetailAmountExcludingVatReduce);
                  endAmount = endAmount.add(inboundDetailAmountReduce);
                  endMete = endMete.add(inboundDetailMeteReduce);
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
                  endAmountExcludingVat = endAmountExcludingVat.subtract(outboundDetailAmountExcludingVatReduce);
                  endAmount = endAmount.subtract(outboundDetailAmountReduce);
                  endMete = endMete.subtract(outboundDetailMeteReduce);
                  endAmountNoFreight = endAmountNoFreight.subtract(outboundDetailAmountReduceNoFreight);
                  endAmountExcludingVatNoFreight = endAmountExcludingVatNoFreight.subtract(outboundDetailAmountExcludingVatReduceNoFreight);
               }
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

   MonthWeightedAveragePrice getFutureMothWap(MonthWeightedAveragePrice monthWAP, MonthTimeRange monthTimeRange) {
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
                     .apply(StatisticsInboundMapper.EFFECTIVE_REAL_TIME_SQL + " >= {0}", monthTimeRange.getEndTime())
               );
            List<StatisticsOutbound> moveOutboundDetails = this.statisticsOutboundMapper
               .selectList(
                  (Wrapper<StatisticsOutbound>)((((new LambdaQueryWrapper<StatisticsOutbound>()
                                 .eq(StatisticsOutbound::getStatisticsId, statistics.getId()))
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
               endAmountNoFreight = endAmountNoFreight.add(inboundDetailAmountReduceNoFreight);
               endAmountExcludingVatNoFreight = endAmountExcludingVatNoFreight.add(inboundDetailAmountExcludingVatReduceNoFreight);
               endAmountExcludingVat = endAmountExcludingVat.add(inboundDetailAmountExcludingVatReduce);
               endAmount = endAmount.add(inboundDetailAmountReduce);
               endMete = endMete.add(inboundDetailMeteReduce);
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
               endAmountExcludingVat = endAmountExcludingVat.subtract(outboundDetailAmountExcludingVatReduce);
               endAmount = endAmount.subtract(outboundDetailAmountReduce);
               endMete = endMete.subtract(outboundDetailMeteReduce);
               endAmountNoFreight = endAmountNoFreight.subtract(outboundDetailAmountReduceNoFreight);
               endAmountExcludingVatNoFreight = endAmountExcludingVatNoFreight.subtract(outboundDetailAmountExcludingVatReduceNoFreight);
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

   WholeWeightedAveragePrice getWhole(WholeWeightedAveragePrice wholeWAP, MonthTimeRange monthTimeRange) {
      wholeWAP.setStartTime(monthTimeRange.getStartTime());
      wholeWAP.setEndTime(monthTimeRange.getEndTime());
      List<MonthWeightedAveragePrice> monthWAPs = this.monthWAPMapper
         .selectList((Wrapper<MonthWeightedAveragePrice>)Wrappers.<MonthWeightedAveragePrice>lambdaQuery().eq(MonthWeightedAveragePrice::getWholeWapId, wholeWAP.getId()));
      new ArrayList();
      List<Long> collect = monthWAPs.stream().map(MonthWeightedAveragePrice::getId).collect(Collectors.toList());
      List<Statistics> statistics = this.statisticsMapper.selectList((Wrapper<Statistics>)new LambdaQueryWrapper<Statistics>().in(Statistics::getWapId, collect));
      List<Long> collect1 = statistics.stream().map(Statistics::getId).collect(Collectors.toList());
      WmsClosingTime one = this.wmsClosingTimeService
         .getOne(
            (Wrapper<WmsClosingTime>)((new LambdaQueryWrapper<WmsClosingTime>()
                     .lt(WmsClosingTime::getId, monthTimeRange.getWmsClosingTimeId()))
                  .orderByDesc(WmsClosingTime::getId))
               .last("limit 1")
         );
      List<StatisticsMonthRecord> statisticsMonthRecords = null;
      if (one != null) {
         statisticsMonthRecords = this.statisticsMonthRecordMapper
            .selectList(
               (Wrapper<StatisticsMonthRecord>)(new LambdaQueryWrapper<StatisticsMonthRecord>().eq(StatisticsMonthRecord::getWmsClosingTimeId, one.getId()))
                  .in(StatisticsMonthRecord::getStatId, collect1)
            );
      }

      List<InboundDetail> inboundDetailList = this.inboundDetailMapper
         .selectList(
            (Wrapper<InboundDetail>)((new LambdaQueryWrapper<InboundDetail>().in(InboundDetail::getWapId, collect))
                  .between(InboundDetail::getRealTime, monthTimeRange.getStartTime(), monthTimeRange.getEndTime()))
               .eq(InboundDetail::getReviewStatus, 2)
         );
      List<RejectDetail> rejectDetailList = this.rejectDetailMapper
         .selectList(
            (Wrapper<RejectDetail>)((new LambdaQueryWrapper<RejectDetail>().in(RejectDetail::getWapId, collect))
                  .between(RejectDetail::getRealTime, monthTimeRange.getStartTime(), monthTimeRange.getEndTime()))
               .eq(RejectDetail::getReviewStatus, 2)
         );
      List<ReturnDetail> returnDetailList = this.returnDetailMapper
         .selectList(
            (Wrapper<ReturnDetail>)((new LambdaQueryWrapper<ReturnDetail>().in(ReturnDetail::getWapId, collect))
                  .between(ReturnDetail::getRealTime, monthTimeRange.getStartTime(), monthTimeRange.getEndTime()))
               .eq(ReturnDetail::getReviewStatus, 2)
         );
      BigDecimal endAmount = BigDecimal.ZERO;
      BigDecimal endAmountExcludingVat = BigDecimal.ZERO;
      BigDecimal endMete = BigDecimal.ZERO;
      BigDecimal endAmountNoFreight = BigDecimal.ZERO;
      BigDecimal endAmountExcludingVatNoFreight = BigDecimal.ZERO;
      if (CollectionUtil.isNotEmpty(statisticsMonthRecords)) {
         endAmount = statisticsMonthRecords.stream()
            .filter(statisticsMonthRecord -> statisticsMonthRecord.getEndAmount() != null)
            .map(StatisticsMonthRecord::getEndAmount)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         endAmountExcludingVat = statisticsMonthRecords.stream()
            .filter(statisticsMonthRecord -> statisticsMonthRecord.getEndAmountExcludingVat() != null)
            .map(StatisticsMonthRecord::getEndAmountExcludingVat)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         endMete = statisticsMonthRecords.stream()
            .filter(statisticsMonthRecord -> statisticsMonthRecord.getEndMete() != null)
            .map(StatisticsMonthRecord::getEndMete)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         endAmountNoFreight = statisticsMonthRecords.stream()
            .filter(statisticsMonthRecord -> statisticsMonthRecord.getEndAmountNoFreight() != null)
            .map(StatisticsMonthRecord::getEndAmountNoFreight)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         endAmountExcludingVatNoFreight = statisticsMonthRecords.stream()
            .filter(statisticsMonthRecord -> statisticsMonthRecord.getEndAmountExcludingVatNoFreight() != null)
            .map(StatisticsMonthRecord::getEndAmountExcludingVatNoFreight)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
      }

      if (CollectionUtil.isNotEmpty(inboundDetailList)) {
         BigDecimal inboundDetailAmountExcludingVatReduce = inboundDetailList.stream()
            .filter(inboundDetail -> inboundDetail.getAmountExcludingVat() != null)
            .map(InboundDetail::getAmountExcludingVat)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal inboundDetailAmountReduce = inboundDetailList.stream()
            .filter(inboundDetail -> inboundDetail.getAmount() != null)
            .map(InboundDetail::getAmount)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal inboundDetailMeteReduce = inboundDetailList.stream()
            .filter(inboundDetail -> inboundDetail.getMete() != null)
            .map(InboundDetail::getMete)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal inboundDetailAmountReduceNoFreight = inboundDetailList.stream()
            .filter(inboundDetail -> inboundDetail.getAmountNoFreight() != null)
            .map(InboundDetail::getAmountNoFreight)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal inboundDetailAmountExcludingVatReduceNoFreight = inboundDetailList.stream()
            .filter(inboundDetail -> inboundDetail.getAmountExcludingVatNoFreight() != null)
            .map(InboundDetail::getAmountExcludingVatNoFreight)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         endAmountExcludingVat = endAmountExcludingVat.add(inboundDetailAmountExcludingVatReduce);
         endAmount = endAmount.add(inboundDetailAmountReduce);
         endAmountNoFreight = endAmountNoFreight.add(inboundDetailAmountReduceNoFreight);
         endAmountExcludingVatNoFreight = endAmountExcludingVatNoFreight.add(inboundDetailAmountExcludingVatReduceNoFreight);
         endMete = endMete.add(inboundDetailMeteReduce);
      }

      if (CollectionUtil.isNotEmpty(rejectDetailList)) {
         BigDecimal rejectDetailAmountExcludingVatReduce = rejectDetailList.stream()
            .filter(rejectDetail -> rejectDetail.getAmountExcludingVat() != null)
            .map(RejectDetail::getAmountExcludingVat)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal rejectDetailAmountReduce = rejectDetailList.stream()
            .filter(rejectDetail -> rejectDetail.getAmount() != null)
            .map(RejectDetail::getAmount)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal rejectDetailAmountReduceNoFreight = rejectDetailList.stream()
            .filter(rejectDetail -> rejectDetail.getAmountNoFreight() != null)
            .map(RejectDetail::getAmountNoFreight)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal rejectDetailAmountExcludingVatReduceNoFreight = rejectDetailList.stream()
            .filter(rejectDetail -> rejectDetail.getAmountExcludingVatNoFreight() != null)
            .map(RejectDetail::getAmountExcludingVatNoFreight)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal rejectDetailMeteReduce = rejectDetailList.stream()
            .filter(rejectDetail -> rejectDetail.getMete() != null)
            .map(RejectDetail::getMete)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         endAmountExcludingVat = endAmountExcludingVat.subtract(rejectDetailAmountExcludingVatReduce);
         endAmount = endAmount.subtract(rejectDetailAmountReduce);
         endAmountNoFreight = endAmountNoFreight.subtract(rejectDetailAmountReduceNoFreight);
         endAmountExcludingVatNoFreight = endAmountExcludingVatNoFreight.subtract(rejectDetailAmountExcludingVatReduceNoFreight);
         endMete = endMete.subtract(rejectDetailMeteReduce);
      }

      if (CollectionUtil.isNotEmpty(returnDetailList)) {
         BigDecimal returnDetailAmountExcludingVatReduce = returnDetailList.stream()
            .filter(returnDetail -> returnDetail.getAmountExcludingVat() != null)
            .map(ReturnDetail::getAmountExcludingVat)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal returnDetailAmountReduce = returnDetailList.stream()
            .filter(returnDetail -> returnDetail.getAmount() != null)
            .map(ReturnDetail::getAmount)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal returnDetailAmountReduceNoFreight = returnDetailList.stream()
            .filter(returnDetail -> returnDetail.getAmountNoFreight() != null)
            .map(ReturnDetail::getAmountNoFreight)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal returnDetailAmountExcludingVatReduceNoFreight = returnDetailList.stream()
            .filter(returnDetail -> returnDetail.getAmountExcludingVatNoFreight() != null)
            .map(ReturnDetail::getAmountExcludingVatNoFreight)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal returnDetailMeteReduce = returnDetailList.stream()
            .filter(returnDetail -> returnDetail.getMete() != null)
            .map(ReturnDetail::getMete)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         if (returnDetailAmountExcludingVatReduce.compareTo(BigDecimal.ZERO) > 0) {
            endAmountExcludingVat = endAmountExcludingVat.add(returnDetailAmountExcludingVatReduce);
            endAmount = endAmount.add(returnDetailAmountReduce);
            endAmountNoFreight = endAmountNoFreight.subtract(returnDetailAmountReduceNoFreight);
            endAmountExcludingVatNoFreight = endAmountExcludingVatNoFreight.subtract(returnDetailAmountExcludingVatReduceNoFreight);
         }

         endMete = endMete.add(returnDetailMeteReduce);
      }

      wholeWAP.setAmount(endAmount);
      wholeWAP.setAmountExcludingVat(endAmountExcludingVat);
      wholeWAP.setAmountNoFreight(endAmountNoFreight);
      wholeWAP.setAmountExcludingVatNoFreight(endAmountExcludingVatNoFreight);
      wholeWAP.setMete(endMete);
      return wholeWAP;
   }

   @Override
   public PageVO<OutboundDetailDO> getOutsourcingOutboundDetail(QueryDetailDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort) {
      param.setClassifyIds(this.queryUtil.getLateClassificationList(param.getClassifyId()));
      WeightedPriceConf weightedPriceConf = JSON.parseObject(
         this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置")).getValue(), WeightedPriceConf.class
      );
      String s = StringUtils.analyzeSortConditions(sort);
      Page<OutboundDetailDO> page = PageHelper.startPage(pageNumber, pageSize, s);
      return new PageVO<>(page, this.outboundDetailMapper.getListV2(param).stream().peek(l -> {
         if (BasicClassEnum.COLOR_ROLL.getType().equals(l.getBasicClass()) && l.getLength() != null) {
            l.setMeasureUnit("张");
            l.setMeasurePrecision(0);
         }

         if (l.getAmount() == null && l.getAmountExcludingVAT() == null) {
            MonthWeightedAveragePrice price = this.monthWAPMapper.getPriceById(l.getWapId());
            if (price != null) {
               if (WeightedPriceEnum.WHOLE.getType().equals(weightedPriceConf.getWeightedType())) {
                  WholeWeightedAveragePrice wholeWeightedAveragePrice = this.wholeWAPMapper.selectById(price.getWholeWapId());
                  price.setMete(wholeWeightedAveragePrice.getMete());
                  price.setAmount(wholeWeightedAveragePrice.getAmount());
                  price.setAmountExcludingVat(wholeWeightedAveragePrice.getAmountExcludingVat());
               }

               l.setAmount(BigDecimal.ZERO);
               l.setAmountExcludingVAT(BigDecimal.ZERO);
               l.setUnitPrice(BigDecimal.ZERO);
               l.setUnitPriceExcludingVAT(BigDecimal.ZERO);
               l.setInputVAT(BigDecimal.ZERO);
               if (price.getMete().compareTo(BigDecimal.ZERO) != 0) {
                  BigDecimal p = l.getMete().divide(price.getMete(), 20, RoundingMode.HALF_UP);
                  BigDecimal amount = price.getAmount().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
                  BigDecimal amountExcludingVat = price.getAmountExcludingVat().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
                  if (l.getMete().compareTo(BigDecimal.ZERO) != 0) {
                     BigDecimal avgPrice = NumberUtil.div(amount, l.getMete(), 12);
                     BigDecimal excludingVatAvgPrice = NumberUtil.div(amountExcludingVat, l.getMete(), 12);
                     l.setUnitPrice(avgPrice);
                     l.setUnitPriceExcludingVAT(excludingVatAvgPrice);
                  }

                  l.setAmount(amount);
                  l.setAmountExcludingVAT(amountExcludingVat);
                  l.setInputVAT(amount.subtract(amountExcludingVat));
               }
            }
         }
      }).collect(Collectors.toList()));
   }

   @Override
   public PageVO<OutboundDO> getScrapsOutbound(QueryOutboundDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort) {
      param.setClassifyIds(this.getClassifyId(param.getClassifyId()));
      WeightedPriceConf weightedPriceConf = JSON.parseObject(
         this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置")).getValue(), WeightedPriceConf.class
      );
      String s = StringUtils.analyzeSortConditions(sort);
      Page<OutboundDetailDO> page = PageHelper.startPage(pageNumber, pageSize, s);
      return new PageVO<>(
         page,
         this.outboundMapper
            .getList(param)
            .stream()
            .peek(
               l -> {
                  String s1 = this.outboundDetailMapper
                     .selectList((Wrapper<MoveOutboundDetail>)new LambdaQueryWrapper<MoveOutboundDetail>().eq(MoveOutboundDetail::getOutboundId, l.getId()))
                     .stream()
                     .max(Comparator.comparing(MoveOutboundDetail::getOutboundTime))
                     .map(MoveOutboundDetail::getOutboundTime)
                     .map(dateTime -> dateTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")))
                     .orElse("");
                  String s2 = this.outboundDetailMapper
                     .selectList((Wrapper<MoveOutboundDetail>)new LambdaQueryWrapper<MoveOutboundDetail>().eq(MoveOutboundDetail::getOutboundId, l.getId()))
                     .stream()
                     .min(Comparator.comparing(MoveOutboundDetail::getOutboundTime))
                     .map(MoveOutboundDetail::getOutboundTime)
                     .map(dateTime -> dateTime.format(DateTimeFormatter.ofPattern("YYYY/MM/dd HH:mm:ss")))
                     .orElse("");
                  l.setOutboundTime(s2 + " ~ " + s1);
                  List<MoveOutboundDetail> moveOutboundDetails = this.outboundDetailMapper
                     .selectList((Wrapper<MoveOutboundDetail>)Wrappers.<MoveOutboundDetail>lambdaQuery().eq(MoveOutboundDetail::getOutboundId, l.getId()));
                  List<ProjectInfoDTO> list = new ArrayList<>();

                  for (Long id : moveOutboundDetails.stream().map(MoveOutboundDetail::getProjectId).collect(Collectors.toSet())) {
                     if (id != null) {
                        ProjectInfo projectInfo = this.projectService.getSimpleById(id);
                        list.add(BeanUtil.copy(projectInfo, ProjectInfoDTO.class));
                     }
                  }

                  l.setProjects(list);
                  l.setAmount(BigDecimal.ZERO);
                  l.setAmountExcludingVAT(BigDecimal.ZERO);
                  this.outboundDetailMapper
                     .selectList((Wrapper<MoveOutboundDetail>)new LambdaQueryWrapper<MoveOutboundDetail>().eq(MoveOutboundDetail::getOutboundId, l.getId()))
                     .stream()
                     .map(o -> {
                        if (o.getAmount() == null && o.getAmountExcludingVat() == null) {
                           MonthWeightedAveragePrice price = this.monthWAPMapper.getPriceById(o.getWapId());
                           if (price != null) {
                              if (WeightedPriceEnum.WHOLE.getType().equals(weightedPriceConf.getWeightedType())) {
                                 WholeWeightedAveragePrice wholeWeightedAveragePrice = this.wholeWAPMapper.selectById(price.getWholeWapId());
                                 price.setMete(wholeWeightedAveragePrice.getMete());
                                 price.setAmount(wholeWeightedAveragePrice.getAmount());
                                 price.setAmountExcludingVat(wholeWeightedAveragePrice.getAmountExcludingVat());
                              }

                              o.setAmount(BigDecimal.ZERO);
                              o.setAmountExcludingVat(BigDecimal.ZERO);
                              o.setUnitPrice(BigDecimal.ZERO);
                              o.setUnitPriceExcludingVat(BigDecimal.ZERO);
                              o.setInputVat(BigDecimal.ZERO);
                              if (price.getMete().compareTo(BigDecimal.ZERO) != 0) {
                                 BigDecimal p = o.getMete().divide(price.getMete(), 20, RoundingMode.HALF_UP);
                                 BigDecimal amount = price.getAmount().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
                                 BigDecimal amountExcludingVat = price.getAmountExcludingVat().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
                                 if (o.getMete().compareTo(BigDecimal.ZERO) != 0) {
                                    BigDecimal avgPrice = NumberUtil.div(amount, o.getMete(), 12);
                                    BigDecimal excludingVatAvgPrice = NumberUtil.div(amountExcludingVat, o.getMete(), 12);
                                    o.setUnitPrice(avgPrice);
                                    o.setUnitPriceExcludingVat(excludingVatAvgPrice);
                                 }

                                 o.setAmount(amount);
                                 o.setAmountExcludingVat(amountExcludingVat);
                                 o.setInputVat(amount.subtract(amountExcludingVat));
                              }
                           }
                        }

                        l.setAmount(l.getAmount().add(o.getAmount()));
                        l.setAmountExcludingVAT(l.getAmountExcludingVAT().add(o.getAmountExcludingVat()));
                        return null;
                     })
                     .collect(Collectors.toList());
               }
            )
            .collect(Collectors.toList())
      );
   }

   @Override
   public PageVO<OutboundDetailDO> getForSaleOutboundDetail(QueryDetailDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort) {
      param.setClassifyIds(this.queryUtil.getLateClassificationList(param.getClassifyId()));
      WeightedPriceConf weightedPriceConf = JSON.parseObject(
         this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置")).getValue(), WeightedPriceConf.class
      );
      String s = StringUtils.analyzeSortConditions(sort);
      Page<OutboundDetailDO> page = PageHelper.startPage(pageNumber, pageSize, s);
      List<OutboundDetailDO> outboundDetailDOS = this.outboundDetailMapper.getList(param);
      List<WmsForSaleDetail> wmsForSaleDetails = new ArrayList<>();
      List<WmsForSale> wmsForSaleList = new ArrayList<>();
      List<BranchCompany> branchCompanyList = new ArrayList<>();
      if (CollectionUtil.isNotEmpty(outboundDetailDOS)) {
         List<Long> detailIds = outboundDetailDOS.stream().map(OutboundDetailDO::getId).collect(Collectors.toList());
         wmsForSaleDetails = this.wmsForSaleDetailService
            .list((Wrapper<WmsForSaleDetail>)new LambdaQueryWrapper<WmsForSaleDetail>().in(WmsForSaleDetail::getOutboundDetailId, detailIds).exists(WmsForSaleDetailMapper.OUTBOUND_PARENT_EXISTS_SQL));
         List<String> forSaleSerialNumbers = wmsForSaleDetails.stream().map(WmsForSaleDetail::getForSaleSerialNumber).distinct().collect(Collectors.toList());
         wmsForSaleList = this.wmsForSaleService.list((Wrapper<WmsForSale>)new LambdaQueryWrapper<WmsForSale>().in(WmsForSale::getSerialNumber, forSaleSerialNumbers));
         List<Long> branchCompanyIds = wmsForSaleList.stream().map(WmsForSale::getBranchCompanyId).distinct().collect(Collectors.toList());
         branchCompanyList = this.branchCompanyService.list((Wrapper<BranchCompany>)new LambdaQueryWrapper<BranchCompany>().in(BranchCompany::getId, branchCompanyIds));
      }

      for (OutboundDetailDO outboundDetailDO : outboundDetailDOS) {
         if (BasicClassEnum.COLOR_ROLL.getType().equals(outboundDetailDO.getBasicClass()) && outboundDetailDO.getLength() != null) {
            outboundDetailDO.setMeasureUnit("张");
            outboundDetailDO.setMeasurePrecision(0);
         }

         if (outboundDetailDO.getAmount() == null && outboundDetailDO.getAmountExcludingVAT() == null) {
            MonthWeightedAveragePrice price = this.monthWAPMapper.getPriceById(outboundDetailDO.getWapId());
            if (price != null) {
               if (WeightedPriceEnum.WHOLE.getType().equals(weightedPriceConf.getWeightedType())) {
                  WholeWeightedAveragePrice wholeWeightedAveragePrice = this.wholeWAPMapper.selectById(price.getWholeWapId());
                  price.setMete(wholeWeightedAveragePrice.getMete());
                  price.setAmount(wholeWeightedAveragePrice.getAmount());
                  price.setAmountExcludingVat(wholeWeightedAveragePrice.getAmountExcludingVat());
               }

               outboundDetailDO.setAmount(BigDecimal.ZERO);
               outboundDetailDO.setAmountExcludingVAT(BigDecimal.ZERO);
               outboundDetailDO.setUnitPrice(BigDecimal.ZERO);
               outboundDetailDO.setUnitPriceExcludingVAT(BigDecimal.ZERO);
               outboundDetailDO.setInputVAT(BigDecimal.ZERO);
               if (price.getMete().compareTo(BigDecimal.ZERO) != 0) {
                  BigDecimal p = outboundDetailDO.getMete().divide(price.getMete(), 20, RoundingMode.HALF_UP);
                  BigDecimal amount = price.getAmount().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
                  BigDecimal amountExcludingVat = price.getAmountExcludingVat().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
                  if (outboundDetailDO.getMete().compareTo(BigDecimal.ZERO) != 0) {
                     BigDecimal avgPrice = NumberUtil.div(amount, outboundDetailDO.getMete(), 12);
                     BigDecimal excludingVatAvgPrice = NumberUtil.div(amountExcludingVat, outboundDetailDO.getMete(), 12);
                     outboundDetailDO.setUnitPrice(avgPrice);
                     outboundDetailDO.setUnitPriceExcludingVAT(excludingVatAvgPrice);
                  }

                  outboundDetailDO.setAmount(amount);
                  outboundDetailDO.setAmountExcludingVAT(amountExcludingVat);
                  outboundDetailDO.setInputVAT(amount.subtract(amountExcludingVat));
               }
            }
         }

         WmsForSaleDetail wmsForSaleDetail = wmsForSaleDetails.stream()
            .filter(w -> w.getOutboundDetailId().equals(outboundDetailDO.getId()))
            .findAny()
            .orElse(null);
         if (ObjectUtil.isNotEmpty(wmsForSaleDetail)) {
            OutboundDetailSellDTO outboundDetailSellDTO = cn.hutool.core.bean.BeanUtil.toBean(wmsForSaleDetail, OutboundDetailSellDTO.class);
            WmsForSale wmsForSale = wmsForSaleList.stream()
               .filter(w -> w.getSerialNumber().equals(wmsForSaleDetail.getForSaleSerialNumber()))
               .findAny()
               .orElse(null);
            if (ObjectUtil.isNotEmpty(wmsForSale)) {
               outboundDetailSellDTO.setInvoiceType(wmsForSale.getInvoiceType());
               outboundDetailSellDTO.setTaxRate(wmsForSale.getTaxRate());
               BranchCompany branchCompany = branchCompanyList.stream().filter(b -> b.getId().equals(wmsForSale.getBranchCompanyId())).findAny().orElse(null);
               if (ObjectUtil.isNotEmpty(branchCompany)) {
                  outboundDetailSellDTO.setBranchCompany(BriefIdAndNameDTO.builder().id(branchCompany.getId()).name(branchCompany.getName()).build());
               }

               outboundDetailSellDTO.setPurchaser(wmsForSale.getPurchaser());
            }

            outboundDetailDO.setOutboundDetailSellDTO(outboundDetailSellDTO);
         }
      }

      return new PageVO<>(page, outboundDetailDOS);
   }

   @Override
   public WmsForSaleStatisticsDO getForSaleOutboundDetailCount(QueryDetailDTOParam param) {
      WmsForSaleStatisticsDO wmsForSaleStatisticsDO = new WmsForSaleStatisticsDO();
      BigDecimal differenceMeteSum = BigDecimal.ZERO;
      BigDecimal profitAmountSum = BigDecimal.ZERO;
      BigDecimal sllAmountSum = BigDecimal.ZERO;
      param.setClassifyIds(this.queryUtil.getLateClassificationList(param.getClassifyId()));
      List<OutboundDetailDO> outboundDetailDOS = this.outboundDetailMapper.getList(param);
      if (CollectionUtil.isNotEmpty(outboundDetailDOS)) {
         List<Long> detailIds = outboundDetailDOS.stream().map(OutboundDetailDO::getId).collect(Collectors.toList());
         List<WmsForSaleDetail> list = this.wmsForSaleDetailService
            .list((Wrapper<WmsForSaleDetail>)new LambdaQueryWrapper<WmsForSaleDetail>().in(WmsForSaleDetail::getOutboundDetailId, detailIds).exists(WmsForSaleDetailMapper.OUTBOUND_PARENT_EXISTS_SQL));
         differenceMeteSum = list.stream().map(WmsForSaleDetail::getDifferenceMete).reduce(BigDecimal.ZERO, BigDecimal::add);
         profitAmountSum = list.stream().map(WmsForSaleDetail::getProfitAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
         sllAmountSum = list.stream().map(WmsForSaleDetail::getSellAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
      }

      wmsForSaleStatisticsDO.setDifferenceMeteSum(differenceMeteSum);
      wmsForSaleStatisticsDO.setProfitAmountSum(profitAmountSum);
      wmsForSaleStatisticsDO.setSellAmountSum(sllAmountSum);
      return wmsForSaleStatisticsDO;
   }

   @Override
   public WmsForSaleStatisticsDO forSaleStatistics() {
      WmsForSaleStatisticsDO wmsForSaleStatisticsDO = new WmsForSaleStatisticsDO();
      BigDecimal accumulativeDifference = BigDecimal.ZERO;
      BigDecimal nowYearDifference = BigDecimal.ZERO;
      BigDecimal nowMonthDifference = BigDecimal.ZERO;
      BigDecimal lastMonthDifference = BigDecimal.ZERO;
      AccumulativeTotal accumulativeTotal = this.accumulativeTotalService
         .getOne((Wrapper<AccumulativeTotal>)new LambdaQueryWrapper<AccumulativeTotal>().eq(AccumulativeTotal::getAggregateType, AggregateTypeEnum.FOR_SALE_CV.getType()));
      if (ObjectUtil.isNotEmpty(accumulativeTotal)) {
         accumulativeDifference = accumulativeTotal.getAggregateValue();
      }

      LocalDateTime now = LocalDateTime.now();
      LocalDateTime startYear = LocalDateTime.of(now.getYear(), 1, 1, 0, 0, 0);
      List<AccumulativeTotalRecord> nowYearAccumulativeTotalRecords = this.accumulativeTotalRecordService
         .list((Wrapper<AccumulativeTotalRecord>)new LambdaQueryWrapper<AccumulativeTotalRecord>().ge(BaseEntity::getCreateTime, startYear));
      if (CollectionUtil.isNotEmpty(nowYearAccumulativeTotalRecords)) {
         nowYearDifference = nowYearAccumulativeTotalRecords.stream()
            .map(AccumulativeTotalRecord::getAddValue)
            .filter(ObjectUtil::isNotEmpty)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
      }

      LocalDateTime nowStartMonth = now.with(TemporalAdjusters.firstDayOfMonth()).with(LocalTime.MIN);
      List<AccumulativeTotalRecord> nowMonthAccumulativeTotalRecords = this.accumulativeTotalRecordService
         .list((Wrapper<AccumulativeTotalRecord>)new LambdaQueryWrapper<AccumulativeTotalRecord>().ge(BaseEntity::getCreateTime, nowStartMonth));
      if (CollectionUtil.isNotEmpty(nowMonthAccumulativeTotalRecords)) {
         nowMonthDifference = nowMonthAccumulativeTotalRecords.stream()
            .map(AccumulativeTotalRecord::getAddValue)
            .filter(ObjectUtil::isNotEmpty)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
      }

      LocalDateTime lastStartMonth = now.minusMonths(1L).with(TemporalAdjusters.firstDayOfMonth()).with(LocalTime.MIN);
      LocalDateTime lastEndMonth = lastStartMonth.with(TemporalAdjusters.lastDayOfMonth()).with(LocalTime.MAX);
      List<AccumulativeTotalRecord> lastMonthAccumulativeTotalRecords = this.accumulativeTotalRecordService
         .list(
            (Wrapper<AccumulativeTotalRecord>)(new LambdaQueryWrapper<AccumulativeTotalRecord>().ge(BaseEntity::getCreateTime, lastStartMonth))
               .le(BaseEntity::getCreateTime, lastEndMonth)
         );
      if (CollectionUtil.isNotEmpty(lastMonthAccumulativeTotalRecords)) {
         lastMonthDifference = lastMonthAccumulativeTotalRecords.stream()
            .map(AccumulativeTotalRecord::getAddValue)
            .filter(ObjectUtil::isNotEmpty)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
      }

      wmsForSaleStatisticsDO.setAccumulativeDifference(accumulativeDifference);
      wmsForSaleStatisticsDO.setNowYearDifference(nowYearDifference);
      wmsForSaleStatisticsDO.setNowMonthDifference(nowMonthDifference);
      wmsForSaleStatisticsDO.setLastMonthDifference(lastMonthDifference);
      return wmsForSaleStatisticsDO;
   }

   @Override
   public List<ConstructionInboundDetailDTO> getConstructionInboundDetailList(List<Long> detailIds) {
      return this.inboundMapper.getConstructionInboundDetailList(detailIds);
   }

   @Override
   public ReceiveDateDTO getReceiveDate(QueryReceiveDateDTOParam queryReceiveDateDTOParam) {
      queryReceiveDateDTOParam.setBasicClass(1);
      List<ReceiveOutboundDetailDTO> moveOutboundDetails = this.outboundDetailMapper.getMoveOutboundDetails(queryReceiveDateDTOParam);
      queryReceiveDateDTOParam.setBasicClass(2);
      List<ReceiveOutboundDetailDTO> moveOutboundDetail = this.outboundDetailMapper.getMoveOutboundDetails(queryReceiveDateDTOParam);
      queryReceiveDateDTOParam.setBasicClass(1);
      List<ReceiveReturnDetailDTO> returnDetails = this.returnDetailMapper.getReturnDetails(queryReceiveDateDTOParam);
      queryReceiveDateDTOParam.setBasicClass(2);
      List<ReceiveReturnDetailDTO> returnDetail = this.returnDetailMapper.getReturnDetails(queryReceiveDateDTOParam);
      return ReceiveDateDTO.builder()
         .plantOutboundDetailList(moveOutboundDetails)
         .sectionOutboundDetailList(moveOutboundDetail)
         .plantReturnDetailList(returnDetails)
         .sectionReturnDetailList(returnDetail)
         .build();
   }

   @Override
   public ReceiveDateDTO getReceiveDateDetail(QueryReceiveDateDTOParam queryReceiveDateDTOParam) {
      queryReceiveDateDTOParam.setBasicClass(1);
      List<ReceiveOutboundDetailDTO> moveOutboundDetails = this.outboundDetailMapper.getMoveOutboundDetails(queryReceiveDateDTOParam);
      queryReceiveDateDTOParam.setBasicClass(2);
      List<ReceiveOutboundDetailDTO> moveOutboundDetail = this.outboundDetailMapper.getMoveOutboundDetails(queryReceiveDateDTOParam);
      queryReceiveDateDTOParam.setBasicClass(1);
      List<ReceiveReturnDetailDTO> returnDetails = this.returnDetailMapper.getReturnDetails(queryReceiveDateDTOParam);
      queryReceiveDateDTOParam.setBasicClass(2);
      List<ReceiveReturnDetailDTO> returnDetail = this.returnDetailMapper.getReturnDetails(queryReceiveDateDTOParam);
      moveOutboundDetails.addAll(moveOutboundDetail);
      returnDetails.addAll(returnDetail);
      return ReceiveDateDTO.builder().plantOutboundDetailList(moveOutboundDetails).sectionOutboundDetailList(moveOutboundDetail).build();
   }

   @Override
   public ReceiveDateDTO getReceiveDateDetailV2(QueryReceiveDateDTOParam queryReceiveDateDTOParam) {
      queryReceiveDateDTOParam.setBasicClass(1);
      List<ReceiveOutboundDetailDTO> moveOutboundDetails = this.outboundDetailMapper.getMoveOutboundDetails(queryReceiveDateDTOParam);
      queryReceiveDateDTOParam.setBasicClass(2);
      List<ReceiveOutboundDetailDTO> moveOutboundDetail = this.outboundDetailMapper.getMoveOutboundDetails(queryReceiveDateDTOParam);
      queryReceiveDateDTOParam.setBasicClass(1);
      List<ReceiveReturnDetailDTO> returnDetails = this.returnDetailMapper.getReturnDetails(queryReceiveDateDTOParam);
      queryReceiveDateDTOParam.setBasicClass(2);
      List<ReceiveReturnDetailDTO> returnDetail = this.returnDetailMapper.getReturnDetails(queryReceiveDateDTOParam);
      moveOutboundDetails.addAll(moveOutboundDetail);
      returnDetails.addAll(returnDetail);
      return ReceiveDateDTO.builder().plantOutboundDetailList(moveOutboundDetails).plantReturnDetailList(returnDetails).build();
   }

   @Override
   public PrintVO<List<ReceiveOutboundDetailDTO>> receiveDatePrint(QueryReceiveDateDTOParam queryReceiveDateDTOParam) {
      PrintVO<List<ReceiveOutboundDetailDTO>> vo = new PrintVO<>();
      Map<String, Object> header = vo.initHeader(UserUtil.getCurrentName());
      queryReceiveDateDTOParam.setBasicClass(1);
      List<ReceiveOutboundDetailDTO> moveOutboundDetails = this.outboundDetailMapper.getMoveOutboundDetails(queryReceiveDateDTOParam);
      queryReceiveDateDTOParam.setBasicClass(2);
      List<ReceiveOutboundDetailDTO> moveOutboundDetail = this.outboundDetailMapper.getMoveOutboundDetails(queryReceiveDateDTOParam);
      queryReceiveDateDTOParam.setBasicClass(1);
      List<ReceiveReturnDetailDTO> returnDetails = this.returnDetailMapper.getReturnDetails(queryReceiveDateDTOParam);
      queryReceiveDateDTOParam.setBasicClass(2);
      List<ReceiveReturnDetailDTO> returnDetail = this.returnDetailMapper.getReturnDetails(queryReceiveDateDTOParam);
      moveOutboundDetails.addAll(moveOutboundDetail);
      returnDetails.addAll(returnDetail);
      returnDetails.forEach(receiveReturnDetailDTO -> {
         ReceiveOutboundDetailDTO copy = BeanUtil.copy(receiveReturnDetailDTO, ReceiveOutboundDetailDTO.class);
         moveOutboundDetails.add(copy);
      });
      vo.setTable(moveOutboundDetails);
      vo.setHeader(header);
      return vo;
   }

   @Override
   public List<IdAndMete> getGroupByProjectOutboundMete() {
      return this.outboundDetailMapper.getGroupByProjectOutboundMete();
   }

   @Override
   public List<IdAndMete> getGroupByMesWorkshopOutboundMete() {
      return this.outboundDetailMapper.getGroupByMesWorkshopOutboundMete();
   }

   @Override
   public List<IdAndMete> getGroupByProjectReturnMete() {
      return this.returnDetailMapper.getGroupByProjectReturnMete();
   }

   @Override
   public List<IdAndMete> getGroupByMesWorkshopReturnMete() {
      return this.returnDetailMapper.getGroupByMesWorkshopReturnMete();
   }

   @Override
   public List<WastageCostSummaryValueDTO> getGroupByMonthOutboundSummary(
      Long projectId, Long workShopId, String minYearMonth, String maxYearMonth, List<LocalDate> yearMonthDateList
   ) {
      return this.outboundDetailMapper.getGroupByMonthOutboundSummary(projectId, workShopId, minYearMonth, maxYearMonth, yearMonthDateList);
   }

   @Override
   public List<WastageCostSummaryValueDTO> getGroupByMonthReturnSummary(
      Long projectId, Long workShopId, String minYearMonth, String maxYearMonth, List<LocalDate> yearMonthDateList
   ) {
      return this.returnDetailMapper.getGroupByMonthReturnSummary(projectId, workShopId, minYearMonth, maxYearMonth, yearMonthDateList);
   }

   @Override
   public List<OutboundDetailDO> getOutboundDetailList(
      List<LocalDateTime> dateTimeList, Long projectId, Long workShopId, Integer basicClass, String classifyName
   ) {
      return this.outboundDetailMapper.getOutboundDetailList(dateTimeList, projectId, workShopId, basicClass, classifyName);
   }

   @Override
   public List<ReturnDetailDO> getReturnDetailList(List<LocalDateTime> dateTimeList, Long projectId, Long workShopId, Integer basicClass, String classifyName) {
      return this.returnDetailMapper.getReturnDetailList(dateTimeList, projectId, workShopId, basicClass, classifyName);
   }
   // Preserve the original Lombok-generated unchecked rethrow without changing public signatures.
   @SuppressWarnings("unchecked")
   private static <E extends Throwable> RuntimeException rethrow(Throwable error) throws E {
      throw (E)error;
   }
}
