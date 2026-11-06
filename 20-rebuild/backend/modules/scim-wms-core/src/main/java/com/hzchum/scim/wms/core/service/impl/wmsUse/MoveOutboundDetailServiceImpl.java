package com.hzchum.scim.wms.core.service.impl.wmsUse;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.common.core.api.enums.OutboundTypeEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo.common.MonthAmountInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectAmountInfo;
import com.hzchum.scim.common.core.api.pojo.dto.BasicClassMeteAndAmountDTO;
import com.hzchum.scim.common.core.api.pojo.dto.CostSummaryValueDTO;
import com.hzchum.scim.contract.core.api.enums.SettlementStatusEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ProjectMeteDTO;
import com.hzchum.scim.system.core.api.common.enums.NumberTypeEnum;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.NumberConfigService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.enums.MaterialFreezeTypeEnum;
import com.hzchum.scim.wms.core.api.enums.MaterialOutboundModeEnum;
import com.hzchum.scim.wms.core.api.enums.OutboundStatusEnum;
import com.hzchum.scim.wms.core.api.enums.WeightedPriceEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.BasicConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Classification;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Measure;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WeightedPriceConf;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.CommonDetailsDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.OutboundDetailDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.DownLoadDetailDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialFreeze;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialFreezeRecord;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MonthWeightedAveragePrice;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MoveOutboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Outbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.ReturnDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WholeWeightedAveragePrice;
import com.hzchum.scim.wms.core.api.pojo.dto.common.CommonSummaryDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.DeviceDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.DateCostDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ProjectOutSummaryDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ProjectSteelPickingStatistics;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.WmsDateMeteDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryDetailDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryDeviceByMaterialDtoParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.BatchDeviceOutboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.DeviceOutboundDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.BasicConfigService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.ClassificationService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.MeasureService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialFreezeService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MoveOutboundDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.ReturnDetailService;
import com.hzchum.scim.wms.core.api.utils.CommonUtil;
import com.hzchum.scim.wms.core.mapper.wmsConfig.MeasureMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MaterialFreezeRecordMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MaterialInventoryMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MonthWeightedAveragePriceMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MoveOutboundDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.OutboundMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.ReturnDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.WholeWeightedAveragePriceMapper;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MoveOutboundDetailServiceImpl extends ServiceImpl<MoveOutboundDetailMapper, MoveOutboundDetail> implements MoveOutboundDetailService {
   @Resource
   MaterialInventoryMapper materialInventoryMapper;
   @Resource
   MeasureMapper measureMapper;
   @Resource
   MeasureService measureService;
   @Resource
   BasicConfigService basicConfigService;
   @Resource
   NumberConfigService numberConfigService;
   @Resource
   OutboundMapper outboundMapper;
   @Resource
   MaterialFreezeService materialFreezeService;
   @Resource
   MaterialFreezeRecordMapper materialFreezeRecordMapper;
   @Resource
   ContractProjectService contractProjectService;
   @Resource
   ClassificationService classificationService;
   @Resource
   UserService userService;
   RoundingMode ROUNDING = RoundingMode.HALF_UP;
   @Resource
   ReturnDetailService returnDetailService;
   @Resource
   MoveOutboundDetailMapper moveOutboundDetailMapper;
   @Resource
   ReturnDetailMapper returnDetailMapper;
   @Resource
   MonthWeightedAveragePriceMapper monthWAPMapper;
   @Resource
   WholeWeightedAveragePriceMapper wholeWAPMapper;
   @Value("${wms.amount-accuracy}")
   private Integer amountAccuracy;

   @Override
   public List<ProjectAmountInfo> listProjectOutboundAmount(List<Long> projectIds, Integer basicClassEnum) {
      return this.baseMapper.selectProjectOutAmount(projectIds, basicClassEnum);
   }

   @Override
   public List<MonthAmountInfo> listMonthOutboundAmount(Integer startMonth, Integer endMonth, Integer basicClassEnum) {
      return this.baseMapper.selectMonthOutAmount(startMonth, endMonth, basicClassEnum);
   }

   @Override
   public List<CostSummaryValueDTO> getMeteByProjectId(
      List<Integer> basicClassList,
      Long projectId,
      List<LocalDate> yearMonthList,
      List<Long> notClassifyIds,
      List<Long> getClassifyIds,
      List<String> notClassifyNameList,
      List<String> getClassifyNameList,
      Boolean boolTaxIncluded
   ) {
      List<Long> notClassifyIdsNew = this.classificationService.getClassifyIdsByName(notClassifyNameList);
      if (CollectionUtils.isEmpty(notClassifyIds)) {
         notClassifyIds = new ArrayList<>();
      }

      notClassifyIds.addAll(notClassifyIdsNew);
      List<Long> getClassifyIdsNew = this.classificationService.getClassifyIdsByName(getClassifyNameList);
      if (CollectionUtils.isEmpty(getClassifyIds)) {
         getClassifyIds = new ArrayList<>();
      }

      getClassifyIds.addAll(getClassifyIdsNew);
      List<Long> projectIds = new ArrayList<>();
      if (ObjectUtil.isNotEmpty(projectId)) {
         projectIds.add(projectId);
      }

      Map<Long, List<CostSummaryValueDTO>> listMap = this.basicClassMeteAndAmount(
         basicClassList, projectIds, ReviewStatusEnum.REVIEWED.getType(), yearMonthList, notClassifyIds, getClassifyIds, boolTaxIncluded
      );
      long key = ObjectUtil.isNotEmpty(projectId) ? projectId : -1L;
      return listMap.get(key);
   }

   @Override
   public List<CommonDetailsDO> groupOutboundDetail(
      List<Integer> basicClassList,
      Long projectId,
      List<LocalDate> yearMonthList,
      List<Long> notClassifyIds,
      List<Long> getClassifyIds,
      List<String> notClassifyNameList,
      List<String> getClassifyNameList
   ) {
      List<Long> notClassifyIdsNew = this.classificationService.getClassifyIdsByName(notClassifyNameList);
      if (CollectionUtils.isEmpty(notClassifyIds)) {
         notClassifyIds = new ArrayList<>();
      }

      notClassifyIds.addAll(notClassifyIdsNew);
      List<Long> getClassifyIdsNew = this.classificationService.getClassifyIdsByName(getClassifyNameList);
      if (CollectionUtils.isEmpty(getClassifyIds)) {
         getClassifyIds = new ArrayList<>();
      }

      getClassifyIds.addAll(getClassifyIdsNew);
      DateTimeFormatter yyyyMM = DateTimeFormatter.ofPattern("yyyy-MM");
      List<String> yearMonthListStr = new ArrayList<>();

      for (LocalDate localDate : yearMonthList) {
         yearMonthListStr.add(yyyyMM.format(localDate));
      }

      List<CommonDetailsDO> outboundDetailDOS = this.baseMapper
         .groupOutboundDetail(basicClassList, projectId, ReviewStatusEnum.REVIEWED.getType(), yearMonthListStr, notClassifyIds, getClassifyIds);

      for (CommonDetailsDO outboundDetailDO : outboundDetailDOS) {
         DownLoadDetailDO detailDO = BeanUtil.toBean(outboundDetailDO, DownLoadDetailDO.class);
         outboundDetailDO.setBoolWeighting(ObjectUtil.isNotEmpty(detailDO.getUnitPrice()));
         ReceiptDownloadServiceImpl receiptDownloadService = new ReceiptDownloadServiceImpl();
         StringBuilder sb = new StringBuilder();
         StringBuilder lengths = new StringBuilder();
         StringBuilder material = new StringBuilder();
         receiptDownloadService.setSpecs(detailDO, sb, lengths, material);
         StringBuilder model = new StringBuilder();
         if (ObjectUtil.isNotEmpty(sb)) {
            model.append(sb);
         }

         if (ObjectUtil.isNotEmpty(lengths)) {
            model.append("*").append(lengths);
         }

         outboundDetailDO.setSpecification(model.toString());
         outboundDetailDO.setModel(material.toString());
      }

      return outboundDetailDOS;
   }

   @Override
   public Map<Long, List<CostSummaryValueDTO>> getMeteByProjectIds(
      List<Integer> basicClassList,
      List<Long> projectIds,
      List<LocalDate> yearMonthList,
      List<Long> notClassifyIds,
      List<Long> getClassifyIds,
      List<String> notClassifyNameList,
      List<String> getClassifyNameList,
      Boolean boolTaxIncluded
   ) {
      List<Long> notClassifyIdsNew = this.classificationService.getClassifyIdsByName(notClassifyNameList);
      if (CollectionUtils.isEmpty(notClassifyIds)) {
         notClassifyIds = new ArrayList<>();
      }

      notClassifyIds.addAll(notClassifyIdsNew);
      List<Long> getClassifyIdsNew = this.classificationService.getClassifyIdsByName(getClassifyNameList);
      if (CollectionUtils.isEmpty(getClassifyIds)) {
         getClassifyIds = new ArrayList<>();
      }

      getClassifyIds.addAll(getClassifyIdsNew);
      return this.basicClassMeteAndAmount(
         basicClassList, projectIds, ReviewStatusEnum.REVIEWED.getType(), yearMonthList, notClassifyIds, getClassifyIds, boolTaxIncluded
      );
   }

   @Override
   public List<ProjectSteelPickingStatistics> projectSteelPickingStatistics(String time, Long workshopId) {
      String MonthTime = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM"));
      String aboveMonthTime = LocalDate.now().minusMonths(1L).format(DateTimeFormatter.ofPattern("yyyy-MM"));
      List<MoveOutboundDetail> moveOutboundDetails = this.moveOutboundDetailMapper.projectSteelPickingStatistics(time, workshopId, null);
      Map<Long, List<MoveOutboundDetail>> YearStatistics = moveOutboundDetails.stream().collect(Collectors.groupingBy(MoveOutboundDetail::getProjectId));
      List<MoveOutboundDetail> moveOutboundDetails1 = this.moveOutboundDetailMapper.projectSteelPickingStatistics(null, workshopId, MonthTime);
      Map<Long, List<MoveOutboundDetail>> Month = moveOutboundDetails1.stream().collect(Collectors.groupingBy(MoveOutboundDetail::getProjectId));
      List<MoveOutboundDetail> moveOutboundDetails2 = this.moveOutboundDetailMapper.projectSteelPickingStatistics(null, workshopId, aboveMonthTime);
      Map<Long, List<MoveOutboundDetail>> aboveMonth = moveOutboundDetails2.stream().collect(Collectors.groupingBy(MoveOutboundDetail::getProjectId));
      Set<Long> projectIds = new HashSet<>();
      if (CollectionUtils.isNotEmpty(YearStatistics.keySet())) {
         projectIds.addAll(YearStatistics.keySet());
      }

      if (CollectionUtils.isNotEmpty(Month.keySet())) {
         projectIds.addAll(Month.keySet());
      }

      if (CollectionUtils.isNotEmpty(aboveMonth.keySet())) {
         projectIds.addAll(aboveMonth.keySet());
      }

      Map<Long, List<ReturnDetail>> YearReturnDetails = this.returnDetailMapper
         .projectSteelPickingStatistics(time, workshopId, null)
         .stream()
         .collect(Collectors.groupingBy(ReturnDetail::getProjectId));
      Map<Long, List<ReturnDetail>> MonthReturnDetails = this.returnDetailMapper
         .projectSteelPickingStatistics(null, workshopId, MonthTime)
         .stream()
         .collect(Collectors.groupingBy(ReturnDetail::getProjectId));
      Map<Long, List<ReturnDetail>> aboveReturnDetails = this.returnDetailMapper
         .projectSteelPickingStatistics(null, workshopId, aboveMonthTime)
         .stream()
         .collect(Collectors.groupingBy(ReturnDetail::getProjectId));
      List<ProjectSteelPickingStatistics> projectSteelPickingStatistics = new ArrayList<>();

      for (Long projectId : projectIds) {
         BigDecimal yearMete = BigDecimal.ZERO;
         BigDecimal monthMete = BigDecimal.ZERO;
         BigDecimal aboveMonthMete = BigDecimal.ZERO;
         ProjectSteelPickingStatistics build = ProjectSteelPickingStatistics.builder().projectId(projectId).build();
         if (CollectionUtils.isNotEmpty(YearStatistics.get(projectId))) {
            if (CollectionUtils.isEmpty(YearReturnDetails.get(projectId))) {
               yearMete = yearMete.add(YearStatistics.get(projectId).stream().map(MoveOutboundDetail::getMete).reduce(BigDecimal.ZERO, BigDecimal::add));
            } else {
               BigDecimal reduce = YearStatistics.get(projectId).stream().map(MoveOutboundDetail::getMete).reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal reduce1 = YearReturnDetails.get(projectId).stream().map(ReturnDetail::getMete).reduce(BigDecimal.ZERO, BigDecimal::add);
               yearMete = yearMete.add(reduce.subtract(reduce1));
            }
         }

         if (CollectionUtils.isNotEmpty(Month.get(projectId))) {
            if (CollectionUtils.isEmpty(MonthReturnDetails.get(projectId))) {
               monthMete = monthMete.add(Month.get(projectId).stream().map(MoveOutboundDetail::getMete).reduce(BigDecimal.ZERO, BigDecimal::add));
            } else {
               BigDecimal reduce2 = Month.get(projectId).stream().map(MoveOutboundDetail::getMete).reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal reduce3 = MonthReturnDetails.get(projectId).stream().map(ReturnDetail::getMete).reduce(BigDecimal.ZERO, BigDecimal::add);
               monthMete = monthMete.add(reduce2.subtract(reduce3));
            }
         }

         if (CollectionUtils.isNotEmpty(aboveMonth.get(projectId))) {
            if (CollectionUtils.isEmpty(aboveReturnDetails.get(projectId))) {
               aboveMonthMete = aboveMonthMete.add(aboveMonth.get(projectId).stream().map(MoveOutboundDetail::getMete).reduce(BigDecimal.ZERO, BigDecimal::add));
            } else {
               BigDecimal reduce4 = aboveMonth.get(projectId).stream().map(MoveOutboundDetail::getMete).reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal reduce5 = aboveReturnDetails.get(projectId).stream().map(ReturnDetail::getMete).reduce(BigDecimal.ZERO, BigDecimal::add);
               aboveMonthMete = aboveMonthMete.add(reduce4.subtract(reduce5));
            }
         }

         build.setYearMete(yearMete);
         build.setMonthMete(monthMete);
         build.setAboveMonthMete(aboveMonthMete);
         projectSteelPickingStatistics.add(build);
      }

      return projectSteelPickingStatistics;
   }

   private Map<Long, List<CostSummaryValueDTO>> basicClassMeteAndAmount(
      List<Integer> basicClassList,
      List<Long> projectIds,
      Integer reviewStatus,
      List<LocalDate> yearMonthList,
      List<Long> notClassifyIds,
      List<Long> getClassifyIds,
      Boolean boolTaxIncluded
   ) {
      BigDecimal thousand = new BigDecimal(1000);
      DateTimeFormatter yyyyMM = DateTimeFormatter.ofPattern("yyyy-MM");
      String nowMonth = yyyyMM.format(LocalDate.now());
      List<String> yearMonthListStr = new ArrayList<>();

      for (LocalDate localDate : yearMonthList) {
         yearMonthListStr.add(yyyyMM.format(localDate));
      }

      List<BasicClassMeteAndAmountDTO> outboundMeteAndAmountDTOSAll = this.baseMapper
         .selectCountMeteAndAmount(basicClassList, projectIds, reviewStatus, yearMonthListStr, notClassifyIds, getClassifyIds);
      List<BasicClassMeteAndAmountDTO> returnMeteAndAmountDTOSAll = this.returnDetailService
         .selectCountMeteAndAmount(basicClassList, projectIds, reviewStatus, yearMonthList, notClassifyIds, getClassifyIds);
      Map<Long, List<CostSummaryValueDTO>> meteAndAmountDTOMap = new HashMap<>();
      if (CollectionUtils.isEmpty(projectIds)) {
         List<CostSummaryValueDTO> costSummaryValueDTOList = this.getCostSummaryValueDTOList(
            thousand, boolTaxIncluded, nowMonth, yearMonthListStr, outboundMeteAndAmountDTOSAll, returnMeteAndAmountDTOSAll
         );
         meteAndAmountDTOMap.put(-1L, costSummaryValueDTOList);
      } else {
         for (Long projectId : projectIds) {
            List<BasicClassMeteAndAmountDTO> outboundMeteAndAmountDTOS = outboundMeteAndAmountDTOSAll.stream()
               .filter(o -> o.getProjectId().equals(projectId))
               .collect(Collectors.toList());
            List<BasicClassMeteAndAmountDTO> returnMeteAndAmountDTOS = returnMeteAndAmountDTOSAll.stream()
               .filter(o -> o.getProjectId().equals(projectId))
               .collect(Collectors.toList());
            List<CostSummaryValueDTO> costSummaryValueDTOList = this.getCostSummaryValueDTOList(
               thousand, boolTaxIncluded, nowMonth, yearMonthListStr, outboundMeteAndAmountDTOS, returnMeteAndAmountDTOS
            );
            meteAndAmountDTOMap.put(projectId, costSummaryValueDTOList);
         }
      }

      return meteAndAmountDTOMap;
   }

   private List<CostSummaryValueDTO> getCostSummaryValueDTOList(
      BigDecimal thousand,
      Boolean boolTaxIncluded,
      String nowMonth,
      List<String> yearMonthListStr,
      List<BasicClassMeteAndAmountDTO> outboundMeteAndAmountDTOS,
      List<BasicClassMeteAndAmountDTO> returnMeteAndAmountDTOS
   ) {
      List<CostSummaryValueDTO> costSummaryValueDTOS = new ArrayList<>();
      BigDecimal total = BigDecimal.ZERO;

      for (String timeStr : yearMonthListStr) {
         boolean equals = nowMonth.equals(timeStr);
         CostSummaryValueDTO costSummaryValueDTO = new CostSummaryValueDTO();
         costSummaryValueDTO.setBoolNowMonth(equals);
         costSummaryValueDTO.setYearMonth(timeStr);
         List<BasicClassMeteAndAmountDTO> outboundMeteAndAmountList = outboundMeteAndAmountDTOS.stream()
            .filter(o -> o.getTime().equals(timeStr))
            .collect(Collectors.toList());
         List<BasicClassMeteAndAmountDTO> rejectMeteAndAmountList = returnMeteAndAmountDTOS.stream()
            .filter(o -> o.getTime().equals(timeStr))
            .collect(Collectors.toList());
         BigDecimal outboundMete = CollectionUtils.isNotEmpty(outboundMeteAndAmountList)
            ? outboundMeteAndAmountList.stream().map(BasicClassMeteAndAmountDTO::getMete).reduce(BigDecimal.ZERO, BigDecimal::add)
            : BigDecimal.ZERO;
         BigDecimal rejectMete = CollectionUtils.isNotEmpty(rejectMeteAndAmountList)
            ? rejectMeteAndAmountList.stream().map(BasicClassMeteAndAmountDTO::getMete).reduce(BigDecimal.ZERO, BigDecimal::add)
            : BigDecimal.ZERO;
         BigDecimal realityOutboundMete = outboundMete.subtract(rejectMete);
         realityOutboundMete = realityOutboundMete.divide(thousand, 4, RoundingMode.HALF_UP);
         Boolean boolWeighting = true;
         BigDecimal outboundAmount;
         BigDecimal rejectAmount;
         if (boolTaxIncluded) {
            if (CollectionUtils.isNotEmpty(outboundMeteAndAmountList)
               && CollectionUtils.isEmpty(outboundMeteAndAmountList.stream().filter(o -> ObjectUtil.isNotEmpty(o.getAmount())).collect(Collectors.toList()))) {
               boolWeighting = false;
            }

            outboundAmount = CollectionUtils.isNotEmpty(outboundMeteAndAmountList)
               ? ObjectUtil.defaultIfNull(
                  outboundMeteAndAmountList.stream()
                     .map(BasicClassMeteAndAmountDTO::getAmount)
                     .filter(ObjectUtil::isNotEmpty)
                     .reduce(BigDecimal.ZERO, BigDecimal::add),
                  BigDecimal.ZERO
               )
               : BigDecimal.ZERO;
            rejectAmount = CollectionUtils.isNotEmpty(rejectMeteAndAmountList)
               ? ObjectUtil.defaultIfNull(
                  rejectMeteAndAmountList.stream()
                     .map(BasicClassMeteAndAmountDTO::getAmount)
                     .filter(ObjectUtil::isNotEmpty)
                     .reduce(BigDecimal.ZERO, BigDecimal::add),
                  BigDecimal.ZERO
               )
               : BigDecimal.ZERO;
         } else {
            if (CollectionUtils.isNotEmpty(outboundMeteAndAmountList)
               && CollectionUtils.isEmpty(
                  outboundMeteAndAmountList.stream().filter(o -> ObjectUtil.isNotEmpty(o.getAmountExcludingVat())).collect(Collectors.toList())
               )) {
               boolWeighting = false;
            }

            outboundAmount = CollectionUtils.isNotEmpty(outboundMeteAndAmountList)
               ? ObjectUtil.defaultIfNull(
                  outboundMeteAndAmountList.stream()
                     .map(BasicClassMeteAndAmountDTO::getAmountExcludingVat)
                     .filter(ObjectUtil::isNotEmpty)
                     .reduce(BigDecimal.ZERO, BigDecimal::add),
                  BigDecimal.ZERO
               )
               : BigDecimal.ZERO;
            rejectAmount = CollectionUtils.isNotEmpty(rejectMeteAndAmountList)
               ? ObjectUtil.defaultIfNull(
                  rejectMeteAndAmountList.stream()
                     .map(BasicClassMeteAndAmountDTO::getAmountExcludingVat)
                     .filter(ObjectUtil::isNotEmpty)
                     .reduce(BigDecimal.ZERO, BigDecimal::add),
                  BigDecimal.ZERO
               )
               : BigDecimal.ZERO;
         }

         costSummaryValueDTO.setBoolWeighting(boolWeighting);
         BigDecimal realityOutAmount = outboundAmount.subtract(rejectAmount);
         total = total.add(realityOutAmount);
         costSummaryValueDTO.setCostMonthTotal(realityOutAmount);
         if (BeanUtil.isEmpty(outboundMeteAndAmountList) && BeanUtil.isEmpty(rejectMeteAndAmountList)) {
            costSummaryValueDTO.setCostMonthTotal(null);
         }

         costSummaryValueDTOS.add(costSummaryValueDTO);
      }

      return costSummaryValueDTOS;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean batchOutbound(BatchDeviceOutboundDTOParam param) {
      for (DeviceOutboundDTOParam detailDTOParam : param.getList()) {
         this.saveOutBound(param, detailDTOParam);
      }

      return true;
   }

   @Override
   public List<DeviceDetailDTO> getDeviceDetail(QueryDeviceByMaterialDtoParam queryReceiveDateDTOParam) {
      return this.baseMapper.getDeviceDetail(queryReceiveDateDTOParam);
   }

   @Override
   public List<WmsDateMeteDTO> getMaterialLossMete(
      Integer basicClassEnum, List<Long> projectIds, LocalDate startDate, LocalDate endDate, Long branchCompanyId, Long workshopId
   ) {
      return this.baseMapper.getMaterialLossMete(basicClassEnum, projectIds, startDate, endDate, branchCompanyId, workshopId);
   }

   @Override
   public List<ProjectMeteDTO> getMaterialLossDetails(Integer basicClass, LocalDate mouthDate, Long branchCompanyId, Long workshopId) {
      return this.baseMapper.getMaterialLossDetails(basicClass, mouthDate, branchCompanyId, workshopId);
   }

   @Override
   public List<DateCostDTO> getMaterialLossCost(Integer basicClassEnum, List<Long> projectIds, LocalDate yearDate, Long branchCompanyId, Long workshopId) {
      return this.baseMapper.getMaterialLossCost(basicClassEnum, projectIds, yearDate, branchCompanyId, workshopId);
   }

   @Override
   public List<CommonSummaryDTO> getMaterialOutMete(Integer basicClass, List<Long> classifyIds, LocalDate yearDate, Long branchCompanyId, Long workshopId) {
      List<MoveOutboundDetail> outDetails = this.getOperationsAnalysisOutDetails(basicClass, classifyIds, null, yearDate, null, branchCompanyId, workshopId);
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
      return outDetails.stream()
         .collect(Collectors.toMap(dto -> dto.getCreateTime().format(formatter), dto -> (MoveOutboundDetail)dto, (existing, replacement) -> {
            BigDecimal existingMete = existing.getMete() != null ? existing.getMete() : BigDecimal.ZERO;
            BigDecimal replacementMete = replacement.getMete() != null ? replacement.getMete() : BigDecimal.ZERO;
            existing.setMete(existingMete.add(replacementMete));
            BigDecimal existingAmountExcludingVat = existing.getAmountExcludingVat() != null ? existing.getAmountExcludingVat() : BigDecimal.ZERO;
            BigDecimal replacementAmountExcludingVat = replacement.getAmountExcludingVat() != null ? replacement.getAmountExcludingVat() : BigDecimal.ZERO;
            existing.setAmountExcludingVat(existingAmountExcludingVat.add(replacementAmountExcludingVat));
            return existing;
         }))
         .entrySet()
         .stream()
         .map(entry -> new CommonSummaryDTO(entry.getKey(), entry.getValue().getMete(), entry.getValue().getAmountExcludingVat()))
         .collect(Collectors.toList());
   }

   @Override
   public List<MoveOutboundDetail> getOperationsAnalysisOutDetails(
      Integer basicClass, List<Long> classifyIds, Long projectId, LocalDate yearDate, LocalDate mouthDate, Long branchCompanyId, Long workshopId
   ) {
      List<MoveOutboundDetail> outDetails = this.baseMapper
         .getOperationsAnalysisOutDetails(basicClass, classifyIds, projectId, yearDate, mouthDate, branchCompanyId, workshopId);
      if (CollectionUtil.isEmpty(outDetails)) {
         return new ArrayList<>();
      }

      WeightedPriceConf weightedPriceConf = JSON.parseObject(
         this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置")).getValue(), WeightedPriceConf.class
      );
      Map<Long, MonthWeightedAveragePrice> monthWeightedAveragePriceMap = new HashMap<>();
      List<Long> wapIds = outDetails.stream().map(MoveOutboundDetail::getWapId).filter(ObjectUtil::isNotEmpty).distinct().collect(Collectors.toList());
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

      for (MoveOutboundDetail outboundDetailDO : outDetails) {
         if (outboundDetailDO.getAmount() == null && outboundDetailDO.getAmountExcludingVat() == null) {
            MonthWeightedAveragePrice price = monthWeightedAveragePriceMap.get(outboundDetailDO.getWapId());
            if (price != null) {
               if (WeightedPriceEnum.WHOLE.getType().equals(weightedPriceConf.getWeightedType())) {
                  WholeWeightedAveragePrice wholeWeightedAveragePrice = wholeWeightedAveragePriceMap.get(price.getWholeWapId());
                  price.setMete(wholeWeightedAveragePrice.getMete());
                  price.setAmount(wholeWeightedAveragePrice.getAmount());
                  price.setAmountExcludingVat(wholeWeightedAveragePrice.getAmountExcludingVat());
               }

               outboundDetailDO.setAmount(BigDecimal.ZERO);
               outboundDetailDO.setAmountExcludingVat(BigDecimal.ZERO);
               outboundDetailDO.setUnitPrice(BigDecimal.ZERO);
               outboundDetailDO.setUnitPriceExcludingVat(BigDecimal.ZERO);
               outboundDetailDO.setInputVat(BigDecimal.ZERO);
               if (price.getMete().compareTo(BigDecimal.ZERO) != 0) {
                  BigDecimal p = outboundDetailDO.getMete().divide(price.getMete(), 20, RoundingMode.HALF_UP);
                  BigDecimal amount = price.getAmount().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
                  BigDecimal amountExcludingVat = price.getAmountExcludingVat().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
                  if (outboundDetailDO.getMete().compareTo(BigDecimal.ZERO) != 0) {
                     BigDecimal avgPrice = NumberUtil.div(amount, outboundDetailDO.getMete(), 12);
                     BigDecimal excludingVatAvgPrice = NumberUtil.div(amountExcludingVat, outboundDetailDO.getMete(), 12);
                     outboundDetailDO.setUnitPrice(avgPrice);
                     outboundDetailDO.setUnitPriceExcludingVat(excludingVatAvgPrice);
                  }

                  outboundDetailDO.setAmount(amount);
                  outboundDetailDO.setAmountExcludingVat(amountExcludingVat);
                  outboundDetailDO.setInputVat(amount.subtract(amountExcludingVat));
               }
            }
         }
      }

      return outDetails;
   }

   @Override
   public List<ProjectOutSummaryDTO> getProjectOutSummaryList(Integer status, Integer basicClass, LocalDate yearDate, Long branchCompanyId, Long workshopId) {
      return this.baseMapper.getProjectOutSummaryList(status, basicClass, yearDate, branchCompanyId, workshopId);
   }

   @Override
   public List<WmsDateMeteDTO> getMainOutMeteV2(List<LocalDate> dateList, Long branchCompanyId, Long workshopId) {
      return this.baseMapper.getMainOutMeteV2(dateList, branchCompanyId, workshopId);
   }

   @Override
   public List<WmsDateMeteDTO> getMainOutMeteDetailV2(List<LocalDate> dateList, LocalDate yearDate, Long branchCompanyId, Long workshopId) {
      return this.baseMapper.getMainOutMeteDetailV2(dateList, yearDate, branchCompanyId, workshopId);
   }

   @Override
   public List<CommonSummaryDTO> getMaterialOutMeteV2(Integer basicClass, List<Long> classifyIds, LocalDate yearDate, Long branchCompanyId, Long workshopId) {
      return this.baseMapper.getMaterialOutMeteV2(basicClass, classifyIds, yearDate, branchCompanyId, workshopId);
   }

   @Override
   public List<OutboundDetailDO> getListNewOne(QueryDetailDTOParam queryDetailDTOParam) {
      return this.baseMapper.getListNewOne(queryDetailDTOParam);
   }

   @Override
   public List<OutboundDetailDO> selectPassDetail(Long workshopId, LocalDateTime startDay, LocalDateTime endDay, List<Long> projectIds, Integer basicClass) {
      return this.baseMapper.selectPassDetail(workshopId, startDay, endDay, projectIds, basicClass);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveOutBound(BatchDeviceOutboundDTOParam batchDeviceOutboundDTOParam, DeviceOutboundDTOParam param) {
      MaterialInventory materialInventory = this.materialInventoryMapper.selectById(param.getId());
      Preconditions.checkArgument(materialInventory != null, "仓库中不存在该物料");
      Measure measure = this.measureMapper
         .selectOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, materialInventory.getClassifyId()));
      Outbound outbound = Outbound.builder()
         .applicantId(batchDeviceOutboundDTOParam.getApplicantId())
         .applicantName(batchDeviceOutboundDTOParam.getApplicantName())
         .userUpdateTime(LocalDateTime.now())
         .reviewStatus(OutboundStatusEnum.UN_REVIEWED.getType())
         .outboundStartTime(LocalDateTime.now())
         .outboundEndTime(LocalDateTime.now())
         .boolPartyA(materialInventory.getBoolPartyA())
         .outboundTypeSelection(OutboundTypeEnum.PRODUCTION_USE.getType())
         .receiveId(batchDeviceOutboundDTOParam.getReceiveId())
         .build();
      String serviceNumber = this.numberConfigService.getNumber(NumberTypeEnum.OUTBOUND_APPLY, this.outboundMapper.getCount(LocalDateTime.now()));
      outbound.setApplicationSn(serviceNumber);
      this.outboundMapper.insert(outbound);
      MoveOutboundDetail moveOutboundDetail = MoveOutboundDetail.builder()
         .warehouseId(materialInventory.getWarehouseId())
         .materialIsWhole(materialInventory.getMaterialIsWhole())
         .workshopId(param.getWorkshopId())
         .sourceWorkshopId(materialInventory.getWorkshopId())
         .materialInventoryId(materialInventory.getId())
         .outboundId(outbound.getId())
         .basicClass(materialInventory.getBasicClass())
         .classifyId(materialInventory.getClassifyId())
         .specification(materialInventory.getSpecification())
         .sourceProjectId(materialInventory.getProjectId())
         .sourceMonomerId(materialInventory.getMonomerId())
         .sourceAreaId(materialInventory.getAreaId())
         .thickness(materialInventory.getThickness())
         .theoryThickness(materialInventory.getTheoryThickness())
         .heatNoAndBatchNo(materialInventory.getHeatNoAndBatchNo())
         .brand(materialInventory.getBrand())
         .outboundTime(LocalDateTime.now())
         .color(materialInventory.getColor())
         .recipientId(param.getRecipientId())
         .outboundMode(1)
         .remark(param.getRemark())
         .boolPartyA(materialInventory.getBoolPartyA())
         .taxRate(materialInventory.getTaxRate())
         .invoiceType(materialInventory.getInvoiceType())
         .standardId(materialInventory.getStandardId())
         .standardName(materialInventory.getStandardName())
         .materialSn(materialInventory.getSerialNumber())
         .workshopId(param.getWorkshopId())
         .outboundAddress(1)
         .outboundType(1)
         .receiveDetailId(param.getReceiveDetailId())
         .receiveId(batchDeviceOutboundDTOParam.getReceiveId())
         .build();
      MaterialFreeze materialFreeze = this.materialFreezeService
         .getOne((Wrapper<MaterialFreeze>)Wrappers.<MaterialFreeze>lambdaQuery().eq(MaterialFreeze::getMaterialInventoryId, materialInventory.getId()));
      MaterialFreezeRecord freezeRecord = null;
      Set<Integer> freezeTypes = null;
      if (materialFreeze != null) {
         freezeTypes = Arrays.stream(materialFreeze.getTotalFreezeTypes().split(",")).map(Integer::parseInt).collect(Collectors.toSet());
      }

      BigDecimal outMete = null;
      BigDecimal outQuantity = null;
      if (materialInventory.getProjectId() != null) {
         moveOutboundDetail.setProjectId(materialInventory.getProjectId());
         moveOutboundDetail.setMonomerId(materialInventory.getMonomerId());
         moveOutboundDetail.setAreaId(materialInventory.getAreaId());
      }

      if (moveOutboundDetail.getProjectId() != null) {
         ContractProject project = this.contractProjectService.getById(moveOutboundDetail.getProjectId());
         Preconditions.checkArgument(
            moveOutboundDetail.getProjectId() != null && SettlementStatusEnum.UN_SETTLED.getType().equals(project.getSettlementStatus()), "出库失败,当前项目已结算"
         );
      }

      moveOutboundDetail.setOutboundType(MaterialOutboundModeEnum.WHOLE.getType());
      if (BasicClassEnum.checkNotSteel(materialInventory.getBasicClass())) {
         moveOutboundDetail.setMete(param.getMete());
         if (materialInventory.getQuantity() != null) {
            moveOutboundDetail.setQuantity(param.getMete().divide(materialInventory.getUnitNet(), 8, this.ROUNDING));
         }
      }

      outMete = moveOutboundDetail.getMete();
      if (moveOutboundDetail.getRecipientId() != null) {
         User user = this.userService.getById(moveOutboundDetail.getRecipientId());
         List<String> recipientName = new ArrayList<>();
         if (StrUtil.isNotBlank(outbound.getRecipients())) {
            List<String> names = Arrays.asList(outbound.getRecipients().split(","));
            if (!names.contains(user.getName())) {
               recipientName.add("," + user.getName());
            }
         } else {
            recipientName.add(user.getName());
         }

         outbound.setRecipients(StrUtil.join(",", recipientName));
      }

      if (moveOutboundDetail.getProjectId() != null) {
         if (StrUtil.isNotBlank(outbound.getProjectIds())) {
            List<Long> list = CommonUtil.spilt(outbound.getProjectIds(), ",");
            if (!list.contains(moveOutboundDetail.getProjectId())) {
               outbound.setProjectIds(outbound.getProjectIds() + "," + moveOutboundDetail.getProjectId());
            }
         } else {
            outbound.setProjectIds(moveOutboundDetail.getProjectId() + "");
         }
      }

      this.baseMapper.insert(moveOutboundDetail);
      outbound.setContainBasicClass(
         outbound.getContainBasicClass() != null ? outbound.getContainBasicClass() | moveOutboundDetail.getBasicClass() : moveOutboundDetail.getBasicClass()
      );
      MaterialFreezeRecord materialFreezeRecord = MaterialFreezeRecord.builder()
         .freezeDetailId(moveOutboundDetail.getId())
         .freezeType(MaterialFreezeTypeEnum.OUTBOUND.getType())
         .freezeSourceId(outbound.getId())
         .freezeSourceSn(outbound.getApplicationSn())
         .operatorId(batchDeviceOutboundDTOParam.getApplicantId())
         .operatorName(batchDeviceOutboundDTOParam.getApplicantName())
         .mete(outMete != null ? outMete : moveOutboundDetail.getMete())
         .quantity(outQuantity != null ? outQuantity : moveOutboundDetail.getQuantity())
         .boolBatten(outQuantity != null)
         .projectId(moveOutboundDetail.getProjectId())
         .frozenTime(LocalDateTime.now())
         .outboundUnitType(2)
         .build();
      if (materialFreeze == null) {
         materialFreeze = com.hzchum.pangu.common.util.BeanUtil.copy(materialInventory, MaterialFreeze.class, "createTime");
         materialFreeze.setTotalQuantity(outQuantity != null ? outQuantity : moveOutboundDetail.getQuantity());
         materialFreeze.setTotalMete(outMete);
         materialFreeze.setTotalFreezeTypes(MaterialFreezeTypeEnum.OUTBOUND.getType() + "");
         materialFreeze.setMaterialInventoryId(materialInventory.getId());
         this.materialFreezeService.save(materialFreeze);
      } else {
         if (freezeRecord != null) {
            if (freezeRecord.getMete().compareTo(moveOutboundDetail.getMete()) < 0) {
               materialFreezeRecord.setApplyPurchaseQuantity(freezeRecord.getQuantity());
               materialFreezeRecord.setApplyPurchaseMete(freezeRecord.getMete());
            } else {
               materialFreezeRecord.setApplyPurchaseQuantity(moveOutboundDetail.getQuantity());
               materialFreezeRecord.setApplyPurchaseMete(moveOutboundDetail.getMete());
            }

            if (freezeRecord.getQuantity() != null) {
               freezeRecord.setQuantity(freezeRecord.getQuantity().subtract(moveOutboundDetail.getQuantity()));
            }

            freezeRecord.setMete(freezeRecord.getMete().subtract(moveOutboundDetail.getMete()));
            if (freezeRecord.getMete().compareTo(BigDecimal.ZERO) <= 0) {
               if (freezeRecord.getMete().compareTo(BigDecimal.ZERO) != 0) {
                  materialFreeze.setTotalQuantity(
                     freezeRecord.getQuantity() != null ? materialFreeze.getTotalQuantity().add(freezeRecord.getQuantity().negate()) : null
                  );
                  materialFreeze.setTotalMete(materialFreeze.getTotalMete().add(freezeRecord.getMete().negate()));
               }

               this.materialFreezeRecordMapper.deleteById(freezeRecord);
            } else {
               this.materialFreezeRecordMapper.updateById(freezeRecord);
            }

            materialFreezeRecord.setBoolChangeOutbound(true);
            materialFreezeRecord.setApplyPurchaseId(freezeRecord.getFreezeSourceId());
            materialFreezeRecord.setApplyPurchaseDetailId(freezeRecord.getFreezeDetailId());
            materialFreezeRecord.setApplyPurchaseSn(freezeRecord.getFreezeSourceSn());
         } else {
            if (moveOutboundDetail.getQuantity() != null) {
               materialFreeze.setTotalQuantity(
                  outQuantity != null
                     ? materialFreeze.getTotalQuantity().add(outQuantity)
                     : materialFreeze.getTotalQuantity().add(moveOutboundDetail.getQuantity())
               );
            }

            freezeTypes.add(MaterialFreezeTypeEnum.OUTBOUND.getType());
            materialFreeze.setTotalFreezeTypes(StrUtil.join(",", freezeTypes));
            materialFreeze.setTotalMete(materialFreeze.getTotalMete().add(outMete));
         }

         this.materialFreezeService.updateById(materialFreeze);
      }

      materialFreezeRecord.setMaterialFreezeId(materialFreeze.getId());
      this.materialFreezeRecordMapper.insert(materialFreezeRecord);
      if (!materialInventory.getBoolHasFrozen()) {
         this.materialInventoryMapper.updateBoolHasFrozen(materialInventory.getId(), true);
      }

      return this.outboundMapper.updateById(outbound) == 1;
   }

   private Measure getMeasured(Long id) {
      Classification classification = this.classificationService.getById(id);
      Measure m = this.measureService.getOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, id));
      return m.getOutboundUnitType() != null ? m : this.getMeasured(classification.getParentId());
   }

   @Override
   public BigDecimal getDeliveryVolume() {
      return this.baseMapper.getDeliveryVolume();
   }
}
