package com.hzchum.scim.wms.core.service.impl.wmsUse;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.enums.OutboundStatusEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Classification;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.InboundDetailDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsAdjustDetail;
import com.hzchum.scim.wms.core.api.pojo.dto.common.CommonSummaryDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.ReceiptMeteDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.InboundDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.InboundPriceSummaryDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.InboundRecordDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.QuantityMeteDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ReconciliationDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryByMaterialDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryPurchaseInboundDetailDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.ClassificationService;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsAdjustDetailService;
import com.hzchum.scim.wms.core.mapper.wmsConfig.WarehouseMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.InboundDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.InboundMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.RejectDetailMapper;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class InboundDetailServiceImpl extends ServiceImpl<InboundDetailMapper, InboundDetail> implements InboundDetailService {
   @Resource
   InboundMapper inboundMapper;
   @Resource
   InboundDetailMapper inboundDetailMapper;
   @Resource
   RejectDetailMapper rejectDetailMapper;
   @Resource
   WmsAdjustDetailService wmsAdjustDetailService;
   @Value("${wms.path-symbol}")
   private String pathSymbol;
   @Resource
   WarehouseMapper warehouseMapper;
   @Resource
   private ClassificationService classificationService;

   @Override
   public List<InboundRecordDTO> listInboundRecord(
      Long purchaseId,
      Long supplierId,
      LocalDate startDate,
      LocalDate endDate,
      Integer basicClass,
      Long classifyId,
      String classifyName,
      String purchaseSerialNumber,
      Long inboundId,
      String inboundSerialNumber
   ) {
      return this.baseMapper
         .listInboundRecord(
            purchaseId, supplierId, startDate, endDate, basicClass, classifyId, classifyName, purchaseSerialNumber, inboundId, inboundSerialNumber
         );
   }

   @Override
   public BigDecimal getInboundAmount(Long purchaseId, Long supplierId) {
      return this.baseMapper.selectInboundAmount(purchaseId, supplierId);
   }

   @Override
   public List<InboundDetailDTO> getDetailList(String year, Long supplierId, List<Long> classifyIds, Long purchaseId, List<LocalDateTime> inboundTime) {
      return this.baseMapper.getList(year, supplierId, classifyIds, purchaseId, inboundTime);
   }

   @Override
   public Map<String, BigDecimal> getMeteByYear(String year) {
      int basicClass = BasicClassEnum.STEEL_PLATE.getType() | BasicClassEnum.SECTION_STEEL.getType();
      Map<String, BigDecimal> map = new HashMap<>();

      for (int i = 1; i < 13; i++) {
         String date = year + (i < 10 ? "0" + i : i);
         BigDecimal mete = this.inboundDetailMapper.getByYear(date, basicClass);
         map.put(i + "", mete.subtract(this.rejectDetailMapper.getByYear(date, basicClass)));
      }

      return map;
   }

   @Override
   public List<InboundDetail> getListByApplyPurchaseId(Long id) {
      return this.baseMapper.getByApplyPurchaseId(id);
   }

   @Override
   public QuantityMeteDTO getCountMete(Long purchaseId, List<Integer> status) {
      return this.baseMapper.getCountMete(purchaseId, status);
   }

   @Override
   public BigDecimal getStorageQuantity() {
      return this.baseMapper.getStorageQuantity();
   }

   @Override
   public List<InboundDetail> selectPassDetailByPurchaseDetailIds(List<Long> purchaseDetailIds) {
      return CollectionUtil.isEmpty(purchaseDetailIds) ? new ArrayList<>() : this.baseMapper.selectPassDetailByPurchaseDetailIds(purchaseDetailIds);
   }

   @Override
   public List<InboundDetail> getInboundDetailList(Long purchaseId, Long purchaseDetailId, Integer reviewStatus) {
      return this.baseMapper.getInboundDetailList(purchaseId, purchaseDetailId, reviewStatus);
   }

   @Override
   public List<ReconciliationDetailDTO> orderReconciliationDetail(QueryPurchaseInboundDetailDTOParam queryDTOParam) {
      return this.baseMapper.orderReconciliationDetail(queryDTOParam);
   }

   @Override
   public List<CommonSummaryDTO> getMaterialInboundMete(Integer basicClass, List<Long> classifyIds, LocalDate yearDate, Long branchCompanyId, Long workshopId) {
      return this.baseMapper.getMaterialInboundMete(basicClass, classifyIds, yearDate, branchCompanyId, workshopId);
   }

   @Override
   public List<InboundDetail> getOperationsAnalysisInboundDetail(
      Integer basicClass, List<Long> classifyIds, LocalDate mouthDate, Long branchCompanyId, Long workshopId
   ) {
      return this.baseMapper.getOperationsAnalysisInboundDetail(basicClass, classifyIds, mouthDate, branchCompanyId, workshopId);
   }

   @Override
   public List<InboundDetail> getMaterialInbound(QueryByMaterialDTOParam param) {
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
         param.setClassifyIds(objects);
      }

      return this.baseMapper.getMaterialInbound(param);
   }

   @Override
   public HashMap<String, Object> getInboundPriceSummary(QueryByMaterialDTOParam param) {
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
         param.setClassifyIds(objects);
      }

      HashMap<String, Object> resultMap = new HashMap<>();
      List<InboundPriceSummaryDTO> dtoList1 = this.getInboundPriceSummaryList(param);
      resultMap.put("currentYear", dtoList1);
      param.setYearDate(param.getYearDate().minusYears(1L));
      List<InboundPriceSummaryDTO> dtoList2 = this.getInboundPriceSummaryList(param);
      resultMap.put("lastYear", dtoList2);
      return resultMap;
   }

   @Override
   public List<ReceiptMeteDTO> getPurchaseInboundMete(List<Long> purchaseIds) {
      return this.baseMapper.getPurchaseInboundMete(purchaseIds);
   }

   @Override
   public List<InboundDetailDO> selectPassDetail(Long workshopId, LocalDateTime startDay, LocalDateTime endDay) {
      return this.baseMapper.selectPassDetail(workshopId, startDay, endDay);
   }

   private List<InboundPriceSummaryDTO> getInboundPriceSummaryList(QueryByMaterialDTOParam param) {
      List<InboundDetail> materialInbound = this.getMaterialInbound(param);
      List<Long> inboundDetailIds = materialInbound.stream().map(InboundDetail::getId).collect(Collectors.toList());
      Map<Long, WmsAdjustDetail> adjustMap = this.wmsAdjustDetailService
         .list(
            (Wrapper<WmsAdjustDetail>)(new LambdaQueryWrapper<WmsAdjustDetail>()
                  .in(CollectionUtil.isNotEmpty(inboundDetailIds), WmsAdjustDetail::getInboundDetailId, inboundDetailIds))
               .eq(WmsAdjustDetail::getReviewStatus, OutboundStatusEnum.REVIEWED.getType())
         )
         .stream()
         .collect(
            Collectors.toMap(
               WmsAdjustDetail::getInboundDetailId,
               detail -> (WmsAdjustDetail)detail,
               (existing, replacement) -> existing.getId() > replacement.getId() ? existing : replacement
            )
         );
      materialInbound.forEach(e -> {
         WmsAdjustDetail adjustDetail = adjustMap.get(e.getId());
         if (adjustDetail != null) {
            e.setAmount(adjustDetail.getAmount());
            e.setAmountExcludingVat(adjustDetail.getAmountExcludingVat());
         }
      });
      List<InboundPriceSummaryDTO> dtoList = new ArrayList<>();
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
      Map<String, List<InboundDetail>> groupedByInboundTime = materialInbound.stream()
         .collect(Collectors.groupingBy(detail -> detail.getInboundTime().format(formatter)));

      for (LocalDate dateTime : this.getYearMonthDateList(param.getYearDate())) {
         String key = dateTime.format(formatter);
         BigDecimal amount = BigDecimal.ZERO;
         BigDecimal mete = BigDecimal.ZERO;
         BigDecimal avgPrice = BigDecimal.ZERO;
         List<InboundDetail> detailList = groupedByInboundTime.get(key);
         if (CollectionUtils.isNotEmpty(detailList)) {
            amount = detailList.stream().map(InboundDetail::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
            mete = detailList.stream().map(InboundDetail::getMete).reduce(BigDecimal.ZERO, BigDecimal::add);
            avgPrice = amount.divide(mete.divide(BigDecimal.valueOf(1000000L)), 2, RoundingMode.HALF_UP);
         }

         dtoList.add(InboundPriceSummaryDTO.builder().dateTime(key).price(amount).mete(mete.divide(BigDecimal.valueOf(1000000L))).avgPrice(avgPrice).build());
      }

      return dtoList;
   }

   private List<LocalDate> getYearMonthDateList(LocalDate year) {
      LocalDate startDate = LocalDate.of(year.getYear(), 1, 1);
      LocalDate endDate = LocalDate.of(year.getYear(), 12, 1);
      List<LocalDate> yearMonthList = new ArrayList<>();
      long monthsBetween = ChronoUnit.MONTHS.between(startDate, endDate);
      Stream.<LocalDate>iterate(startDate, date -> date.plusMonths(1L)).limit(monthsBetween + 1L).forEach(yearMonthList::add);
      return yearMonthList;
   }
}
