package com.hzchum.scim.scm.core.biz;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.DateTimeUtil;
import com.hzchum.scim.contract.core.api.enums.payment.SupplierPropertyTypeEnum;
import com.hzchum.scim.contract.core.api.service.SupplierInvoiceService;
import com.hzchum.scim.contract.core.api.service.SupplierPaymentService;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListService;
import com.hzchum.scim.scm.core.api.biz.SupplierBiz;
import com.hzchum.scim.scm.core.api.enums.SupplierClassEnum;
import com.hzchum.scim.scm.core.api.pojo.dto.SupplierPayableSummaryDTO;
import com.hzchum.scim.scm.core.api.service.LogisticsOrderService;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import com.hzchum.scim.scm.core.mapper.SupplierMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundService;
import com.hzchum.scim.wms.core.api.service.wmsUse.RejectService;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class SupplierBizImpl implements SupplierBiz {
   @Resource
   private SupplierMapper supplierMapper;
   @Resource
   private LogisticsOrderService logisticsOrderService;
   @Resource
   private PurchaseOrderService purchaseOrderService;
   @Resource
   private MesBuildingCargoListService cargoListService;
   @Resource
   private SupplierPaymentService supplierPaymentService;
   @Resource
   private SupplierInvoiceService supplierInvoiceService;
   @Resource
   private InboundService inboundService;
   @Resource
   private RejectService rejectService;

   @Override
   public ListVO<SupplierPayableSummaryDTO> summaryPayable(
      Integer supplierClassification, String supplierName, LocalDate startDate, LocalDate endDate, Boolean payable, Boolean isTaxArrears
   ) {
      return new ListVO<>(this.listSummaryPayable(supplierClassification, supplierName, startDate, endDate, payable, isTaxArrears));
   }

   @Override
   public ListVO<SupplierPayableSummaryDTO> summaryPayableV2(
      Integer supplierClassification, String supplierName, LocalDate startDate, LocalDate endDate, Boolean payable, Boolean isTaxArrears
   ) {
      return new ListVO<>(this.listSummaryPayableV2(supplierClassification, supplierName, startDate, endDate, payable, isTaxArrears));
   }

   private List<SupplierPayableSummaryDTO> listSummaryPayable(
      Integer supplierClassification, String supplierName, LocalDate startDate, LocalDate endDate, Boolean payable, Boolean isTaxArrears
   ) {
      List<SupplierPayableSummaryDTO> payableSummaryDTOList = this.supplierMapper.selectPayableOnSupplier(supplierName, supplierClassification);
      if (payableSummaryDTOList.isEmpty()) {
         return new ArrayList<>();
      }

      payableSummaryDTOList.forEach(
         sumDTO -> {
            if (sumDTO.getSupplierClassification().equals(SupplierClassEnum.LOGISTICS.getType())) {
               BigDecimal sumFreight = this.logisticsOrderService.getSumFreight(null, null, sumDTO.getSupplierId(), null, null);
               BigDecimal shipFeeSum = this.cargoListService.getShipFeeSum(sumDTO.getSupplierId(), null, null, null);
               sumDTO.setAmount(sumFreight.add(shipFeeSum));
               sumDTO.setPaymentAmount(
                  this.supplierPaymentService.getSumPayment(sumDTO.getSupplierId(), null, SupplierPropertyTypeEnum.TRANSPORT_FEE.getType(), null, null)
               );
               sumDTO.setInvoiceAmount(
                  this.supplierInvoiceService.getInvoiceAmount(null, sumDTO.getSupplierId(), SupplierPropertyTypeEnum.TRANSPORT_FEE.getType(), null)
               );
            }

            if (SupplierClassEnum.checkPurchaseSupplier(sumDTO.getSupplierClassification())) {
               BigDecimal inboundAmountSum = this.inboundService.getInboundAmountSum(null, sumDTO.getSupplierId());
               BigDecimal sumRejectAmount = this.rejectService.getSumRejectAmount(null, sumDTO.getSupplierId(), null);
               sumDTO.setAmount(inboundAmountSum.subtract(sumRejectAmount));
               sumDTO.setPaymentAmount(this.supplierPaymentService.getPurchasePaymentSum(null, sumDTO.getSupplierId(), startDate, endDate));
               sumDTO.setInvoiceAmount(this.supplierInvoiceService.getPurchaseInvoiceSum(sumDTO.getSupplierId(), startDate, endDate));
            }

            if (sumDTO.getAmount() != null) {
               sumDTO.setUnPaymentAmount(
                  sumDTO.getAmount().compareTo(sumDTO.getPaymentAmount()) > 0 ? sumDTO.getAmount().subtract(sumDTO.getPaymentAmount()) : BigDecimal.ZERO
               );
               sumDTO.setUnInvoiceAmount(
                  sumDTO.getAmount().compareTo(sumDTO.getInvoiceAmount()) > 0 ? sumDTO.getAmount().subtract(sumDTO.getInvoiceAmount()) : BigDecimal.ZERO
               );
            }
         }
      );
      Stream<SupplierPayableSummaryDTO> stream = payableSummaryDTOList.stream()
         .filter(s -> s.getAmount() != null && s.getAmount().compareTo(BigDecimal.ZERO) > 0);
      if (payable != null && payable) {
         stream = stream.filter(s -> s.getUnPaymentAmount().compareTo(BigDecimal.ZERO) > 0);
      }

      if (payable != null && !payable) {
         stream = stream.filter(s -> s.getUnPaymentAmount().compareTo(BigDecimal.ZERO) == 0);
      }

      if (isTaxArrears != null && isTaxArrears) {
         stream = stream.filter(s -> s.getUnInvoiceAmount().compareTo(BigDecimal.ZERO) > 0);
      }

      if (isTaxArrears != null && !isTaxArrears) {
         stream = stream.filter(s -> s.getUnInvoiceAmount().compareTo(BigDecimal.ZERO) == 0);
      }

      return stream.collect(Collectors.toList());
   }

   private List<SupplierPayableSummaryDTO> listSummaryPayableV2(
      Integer supplierClassification, String supplierName, LocalDate startDate, LocalDate endDate, Boolean payable, Boolean isTaxArrears
   ) {
      List<SupplierPayableSummaryDTO> payableSummaryDTOList = this.supplierMapper.selectPayableOnSupplier(supplierName, supplierClassification);
      if (payableSummaryDTOList.isEmpty()) {
         return new ArrayList<>();
      }

      payableSummaryDTOList.forEach(
         sumDTO -> {
            if (SupplierClassEnum.checkPurchaseSupplier(sumDTO.getSupplierClassification())) {
               BigDecimal inboundAmountSum = this.inboundService.getInboundAmountSumV2(null, sumDTO.getSupplierId());
               BigDecimal sumRejectAmount = this.rejectService.getSumRejectAmountV2(null, sumDTO.getSupplierId(), null);
               sumDTO.setAmount(inboundAmountSum.subtract(sumRejectAmount));
               sumDTO.setPaymentAmount(this.supplierPaymentService.getPurchasePaymentSum(null, sumDTO.getSupplierId(), startDate, endDate));
               sumDTO.setInvoiceAmount(this.supplierInvoiceService.getPurchaseInvoiceSum(sumDTO.getSupplierId(), startDate, endDate));
            }

            if (sumDTO.getAmount() != null) {
               sumDTO.setUnPaymentAmount(
                  sumDTO.getAmount().compareTo(sumDTO.getPaymentAmount()) > 0 ? sumDTO.getAmount().subtract(sumDTO.getPaymentAmount()) : BigDecimal.ZERO
               );
               sumDTO.setUnInvoiceAmount(
                  sumDTO.getAmount().compareTo(sumDTO.getInvoiceAmount()) > 0 ? sumDTO.getAmount().subtract(sumDTO.getInvoiceAmount()) : BigDecimal.ZERO
               );
            }
         }
      );
      Stream<SupplierPayableSummaryDTO> stream = payableSummaryDTOList.stream()
         .filter(s -> s.getAmount() != null && s.getAmount().compareTo(BigDecimal.ZERO) > 0);
      if (payable != null && payable) {
         stream = stream.filter(s -> s.getUnPaymentAmount().compareTo(BigDecimal.ZERO) > 0);
      }

      if (payable != null && !payable) {
         stream = stream.filter(s -> s.getUnPaymentAmount().compareTo(BigDecimal.ZERO) == 0);
      }

      if (isTaxArrears != null && isTaxArrears) {
         stream = stream.filter(s -> s.getUnInvoiceAmount().compareTo(BigDecimal.ZERO) > 0);
      }

      if (isTaxArrears != null && !isTaxArrears) {
         stream = stream.filter(s -> s.getUnInvoiceAmount().compareTo(BigDecimal.ZERO) == 0);
      }

      return stream.collect(Collectors.toList());
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printListSummaryPayable(
      Integer supplierClassification, String supplierName, LocalDate startDate, LocalDate endDate, Boolean payable, Boolean isTaxArrears
   ) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (startDate != null || endDate != null) {
         String statisticsDate;
         if (startDate == null) {
            String endDateStr = DateTimeUtil.getLocalDateStr(endDate);
            statisticsDate = endDateStr + "以前";
         } else if (endDate == null) {
            String startDateStr = DateTimeUtil.getLocalDateStr(startDate);
            statisticsDate = startDateStr + "至今";
         } else {
            statisticsDate = DateTimeUtil.getLocalDateStr(startDate) + "/" + DateTimeUtil.getLocalDateStr(endDate);
         }

         header.put("statisticsDate", statisticsDate);
      }

      printVO.setHeader(header);
      List<Map<String, Object>> mapList = this.listSummaryPayable(supplierClassification, supplierName, startDate, endDate, payable, isTaxArrears)
         .stream()
         .map(BeanUtil::beanToMap)
         .collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printListSummaryPayableV2(
      Integer supplierClassification, String supplierName, LocalDate startDate, LocalDate endDate, Boolean payable, Boolean isTaxArrears
   ) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (startDate != null || endDate != null) {
         String statisticsDate;
         if (startDate == null) {
            String endDateStr = DateTimeUtil.getLocalDateStr(endDate);
            statisticsDate = endDateStr + "以前";
         } else if (endDate == null) {
            String startDateStr = DateTimeUtil.getLocalDateStr(startDate);
            statisticsDate = startDateStr + "至今";
         } else {
            statisticsDate = DateTimeUtil.getLocalDateStr(startDate) + "/" + DateTimeUtil.getLocalDateStr(endDate);
         }

         header.put("statisticsDate", statisticsDate);
      }

      printVO.setHeader(header);
      List<Map<String, Object>> mapList = this.listSummaryPayableV2(supplierClassification, supplierName, startDate, endDate, payable, isTaxArrears)
         .stream()
         .map(BeanUtil::beanToMap)
         .collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }
}
