package com.hzchum.scim.contract.core.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.contract.core.api.biz.ContractSupplierSummaryBiz;
import com.hzchum.scim.contract.core.api.enums.SettlementStatusEnum;
import com.hzchum.scim.contract.core.api.enums.payment.SupplierPaymentInvoiceDetailTypeEnum;
import com.hzchum.scim.contract.core.api.enums.payment.SupplierPropertyTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierInvoice;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierPayment;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierPaymentDetail;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierSummaryCargoListDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierSummaryLedgerDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierSummaryLogisticsOrderDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierSummaryPurchaseOrderDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierSummarySubOrderDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.SupplierSummaryLedgerQueryParam;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.SupplierInvoiceService;
import com.hzchum.scim.contract.core.api.service.SupplierPaymentDetailService;
import com.hzchum.scim.contract.core.api.service.SupplierPaymentService;
import com.hzchum.scim.mes.building.core.api.enums.cargoList.CargoListStatusEnum;
import com.hzchum.scim.mes.building.core.api.enums.cargoList.ChangeFreightEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingCargoList;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingSupplierPrice;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListService;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingSupplierPriceService;
import com.hzchum.scim.scm.core.api.enums.LogisticsPayerEnum;
import com.hzchum.scim.scm.core.api.pojo._do.LogisticsOrder;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrder;
import com.hzchum.scim.scm.core.api.pojo._do.SubcontractOrder;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import com.hzchum.scim.scm.core.api.service.LogisticsOrderService;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import com.hzchum.scim.scm.core.api.service.SubcontractOrderService;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.wms.core.api.enums.DataStatusEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Inbound;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class ContractSupplierSummaryLedgerBizImpl implements ContractSupplierSummaryBiz {
   private final BranchCompanyService branchCompanyService;
   private final SupplierService supplierService;
   private final ContractProjectService projectService;
   private final PurchaseOrderService purchaseOrderService;
   private final SubcontractOrderService subcontractOrderService;
   private final MesBuildingCargoListService cargoListService;
   private final MesBuildingSupplierPriceService supplierPriceService;
   private final LogisticsOrderService logisticsOrderService;
   private final SupplierPaymentService supplierPaymentService;
   private final SupplierPaymentDetailService supplierPaymentDetailService;
   private final SupplierInvoiceService supplierInvoiceService;
   private final InboundService inboundService;

   @Override
   public List<SupplierSummaryLedgerDTO> listSupplierLedger(SupplierSummaryLedgerQueryParam param) {
      List<Long> supplierIds = this.getSupplierIds(param.getSupplierName());
      if (supplierIds != null && supplierIds.isEmpty()) {
         return Collections.emptyList();
      }

      Map<Long, Map<Long, BigDecimal>> supplierIdPurchaseIdAmountMap = this.getSupplierIdPurchaseIdAmountMap(param.getType(), supplierIds);
      Map<Long, BigDecimal> supplierInboundAmountMap = this.getSupplierInboundAmountMap(supplierIdPurchaseIdAmountMap);
      Map<Long, BigDecimal> supplierIdIdSubAmountMap = this.getSupplierIdIdSubAmountMap(param.getType(), supplierIds);
      Map<Long, BigDecimal> supplierIdTotalPriceMap = this.getSupplierIdTotalPriceMap(param.getType(), supplierIds);
      Map<Long, BigDecimal> supplierIdFreightMap = this.getSupplierIdLogisticsFreightMap(param.getType(), supplierIds);
      Set<Long> supplierIdSet = new HashSet<>(1024);
      supplierIdSet.addAll(supplierIdPurchaseIdAmountMap.keySet());
      supplierIdSet.addAll(supplierIdIdSubAmountMap.keySet());
      supplierIdSet.addAll(supplierIdFreightMap.keySet());
      supplierIdSet.addAll(supplierIdTotalPriceMap.keySet());
      List<SupplierSummaryLedgerDTO> supplierSummaryLedgerList = new ArrayList<>(supplierIdSet.size());
      if (CollectionUtils.isNotEmpty(supplierIdSet)) {
         Map<Long, String> supplierIdNameMap = this.supplierService
            .listByIds(supplierIdSet)
            .stream()
            .collect(Collectors.toMap(Supplier::getId, Supplier::getName));
         Map<Long, BigDecimal> supplierIdPaymentAmountMap = this.getSummaryPaymentMap(supplierIdSet, param.getType());
         Map<Long, BigDecimal> supplierIdInvoiceAmountMap = this.supplierInvoiceService
            .list(
               Wrappers.lambdaQuery(SupplierInvoice.class)
                  .in(SupplierInvoice::getSupplierId, supplierIdSet)
                  .ne(param.getType() == null, SupplierInvoice::getPropertyType, SupplierPropertyTypeEnum.RECYCLE_FINISHED_FEE.getType())
                  .in(
                     ContractSupplierSummaryLedgerBizImpl.TypeEnum.PURCHASE_ORDER.getType().equals(param.getType()),
                     SupplierInvoice::getPropertyType,
                     SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(),
                     SupplierPropertyTypeEnum.PURCHASE_FEE.getType()
                  )
                  .eq(
                     ContractSupplierSummaryLedgerBizImpl.TypeEnum.SUB_ORDER.getType().equals(param.getType()),
                     SupplierInvoice::getPropertyType,
                     SupplierPropertyTypeEnum.SUB_FEE.getType()
                  )
                  .eq(
                     ContractSupplierSummaryLedgerBizImpl.TypeEnum.CARGO_LIST.getType().equals(param.getType())
                        || ContractSupplierSummaryLedgerBizImpl.TypeEnum.LOGISTICS.getType().equals(param.getType()),
                     SupplierInvoice::getPropertyType,
                     SupplierPropertyTypeEnum.TRANSPORT_FEE.getType()
                  )
                  .eq(SupplierInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
            )
            .stream()
            .collect(
               Collectors.groupingBy(
                  SupplierInvoice::getSupplierId,
                  Collectors.reducing(
                     BigDecimal.ZERO,
                     s -> s.getActualInvoiceAmount().compareTo(BigDecimal.ZERO) != 0 ? s.getActualInvoiceAmount() : s.getInvoiceAmount(),
                     BigDecimal::add
                  )
               )
            );
         supplierIdSet.forEach(
            supplierId -> {
               BigDecimal purchaseAmount = supplierIdPurchaseIdAmountMap.getOrDefault(supplierId, Collections.emptyMap())
                  .values()
                  .stream()
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal subOrderAmount = supplierIdIdSubAmountMap.getOrDefault(supplierId, BigDecimal.ZERO);
               BigDecimal logisticsAmount = supplierIdFreightMap.getOrDefault(supplierId, BigDecimal.ZERO);
               BigDecimal cargoListAmount = supplierIdTotalPriceMap.getOrDefault(supplierId, BigDecimal.ZERO);
               BigDecimal totalAmount = purchaseAmount.add(subOrderAmount).add(logisticsAmount).add(cargoListAmount);
               BigDecimal paymentAmount = supplierIdPaymentAmountMap.getOrDefault(supplierId, BigDecimal.ZERO);
               BigDecimal receivedInvoiceAmount = supplierIdInvoiceAmountMap.getOrDefault(supplierId, BigDecimal.ZERO);
               BigDecimal inboundAmount = supplierInboundAmountMap.get(supplierId);
               SupplierSummaryLedgerDTO summaryLedgerDto = SupplierSummaryLedgerDTO.builder()
                  .supplierId(supplierId)
                  .supplierName(supplierId.equals(0L) ? "个人" : supplierIdNameMap.get(supplierId))
                  .totalAmount(totalAmount.setScale(2, RoundingMode.HALF_UP))
                  .paidAmount(paymentAmount.setScale(2, RoundingMode.HALF_UP))
                  .unPaidAmount(
                     totalAmount.compareTo(paymentAmount) > 0 ? totalAmount.subtract(paymentAmount).setScale(2, RoundingMode.HALF_UP) : BigDecimal.ZERO
                  )
                  .paymentRate(
                     totalAmount.compareTo(paymentAmount) > 0
                        ? paymentAmount.multiply(BigDecimal.valueOf(100L)).divide(totalAmount, 2, RoundingMode.HALF_UP)
                        : BigDecimal.valueOf(100L)
                  )
                  .receivedInvoiceAmount(receivedInvoiceAmount.setScale(2, RoundingMode.HALF_UP))
                  .unreceivedInvoiceAmount(
                     totalAmount.compareTo(receivedInvoiceAmount) > 0
                        ? totalAmount.subtract(receivedInvoiceAmount).setScale(2, RoundingMode.HALF_UP)
                        : BigDecimal.ZERO
                  )
                  .invoiceRate(
                     totalAmount.compareTo(receivedInvoiceAmount) > 0
                        ? receivedInvoiceAmount.multiply(BigDecimal.valueOf(100L)).divide(totalAmount, 2, RoundingMode.HALF_UP)
                        : BigDecimal.valueOf(100L)
                  )
                  .inboundAmount(inboundAmount != null ? inboundAmount.setScale(2, RoundingMode.HALF_UP) : null)
                  .build();
               supplierSummaryLedgerList.add(summaryLedgerDto);
            }
         );
      }

      return supplierSummaryLedgerList.stream()
         .filter(
            s -> param.getBoolHavePayable() == null
               || param.getBoolHavePayable() && s.getTotalAmount().compareTo(s.getPaidAmount()) > 0
               || !param.getBoolHavePayable() && s.getTotalAmount().compareTo(s.getPaidAmount()) <= 0
         )
         .filter(
            s -> param.getBoolArrearsTax() == null
               || param.getBoolArrearsTax() && s.getTotalAmount().compareTo(s.getReceivedInvoiceAmount()) > 0
               || !param.getBoolArrearsTax() && s.getTotalAmount().compareTo(s.getReceivedInvoiceAmount()) <= 0
         )
         .collect(Collectors.toList());
   }

   private Map<Long, BigDecimal> getSummaryPaymentMap(Set<Long> supplierIdSet, Integer type) {
      if (type == null) {
         return this.supplierPaymentService
            .list(
               Wrappers.lambdaQuery(SupplierPayment.class)
                  .in(SupplierPayment::getSupplierId, supplierIdSet)
                  .ne(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.RECYCLE_FINISHED_FEE.getType())
                  .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
            )
            .stream()
            .collect(
               Collectors.groupingBy(
                  SupplierPayment::getSupplierId, Collectors.reducing(BigDecimal.ZERO, SupplierPayment::getActuallyPaymentAmount, BigDecimal::add)
               )
            );
      } else if (type.equals(ContractSupplierSummaryLedgerBizImpl.TypeEnum.PURCHASE_ORDER.getType())) {
         return this.supplierPaymentService
            .list(
               Wrappers.lambdaQuery(SupplierPayment.class)
                  .in(SupplierPayment::getSupplierId, supplierIdSet)
                  .in(
                     SupplierPayment::getPropertyType,
                     SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(),
                     SupplierPropertyTypeEnum.PURCHASE_FEE.getType()
                  )
                  .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
            )
            .stream()
            .collect(
               Collectors.groupingBy(
                  SupplierPayment::getSupplierId, Collectors.reducing(BigDecimal.ZERO, SupplierPayment::getActuallyPaymentAmount, BigDecimal::add)
               )
            );
      } else {
         return type.equals(ContractSupplierSummaryLedgerBizImpl.TypeEnum.SUB_ORDER.getType())
            ? this.supplierPaymentService
               .list(
                  Wrappers.lambdaQuery(SupplierPayment.class)
                     .in(SupplierPayment::getSupplierId, supplierIdSet)
                     .in(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
                     .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               )
               .stream()
               .collect(
                  Collectors.groupingBy(
                     SupplierPayment::getSupplierId, Collectors.reducing(BigDecimal.ZERO, SupplierPayment::getActuallyPaymentAmount, BigDecimal::add)
                  )
               )
            : this.supplierPaymentDetailService
               .list(
                  Wrappers.lambdaQuery(SupplierPaymentDetail.class)
                     .in(SupplierPaymentDetail::getReceivingUnitId, supplierIdSet)
                     .in(
                        type.equals(ContractSupplierSummaryLedgerBizImpl.TypeEnum.LOGISTICS.getType()),
                        SupplierPaymentDetail::getType,
                        SupplierPaymentInvoiceDetailTypeEnum.MATERIALS_PURCHASE.getType(),
                        SupplierPaymentInvoiceDetailTypeEnum.MANUFACTURES_PURCHASE.getType()
                     )
                     .in(
                        type.equals(ContractSupplierSummaryLedgerBizImpl.TypeEnum.CARGO_LIST.getType()),
                        SupplierPaymentDetail::getType,
                        SupplierPaymentInvoiceDetailTypeEnum.MANUFACTURES_SHIP.getType()
                     )
                     .eq(SupplierPaymentDetail::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               )
               .stream()
               .collect(
                  Collectors.groupingBy(
                     SupplierPaymentDetail::getReceivingUnitId,
                     Collectors.reducing(BigDecimal.ZERO, SupplierPaymentDetail::getActuallyPaymentAmount, BigDecimal::add)
                  )
               );
      }
   }

   @Override
   public PrintVO<List<SupplierSummaryLedgerDTO>> printSupplierLedgerList(SupplierSummaryLedgerQueryParam param) {
      PrintVO<List<SupplierSummaryLedgerDTO>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      List<SupplierSummaryLedgerDTO> summaryLedgerDTOList = this.listSupplierLedger(param);
      printVO.setTable(summaryLedgerDTOList);
      return printVO;
   }

   @Override
   public PageVO<SupplierSummaryPurchaseOrderDTO> purchaseOrderPageList(Long supplierId, Integer pageNumber, Integer pageSize) {
      Page<Object> page = PageHelper.startPage(pageNumber, pageSize);
      List<SupplierSummaryPurchaseOrderDTO> purchaseOrderDtoList = this.getPurchaseOrderList(supplierId);
      return new PageVO<>(page, purchaseOrderDtoList);
   }

   private List<SupplierSummaryPurchaseOrderDTO> getPurchaseOrderList(Long supplierId) {
      List<PurchaseOrder> orderList = this.purchaseOrderService
         .list(
            Wrappers.lambdaQuery(PurchaseOrder.class)
               .in(supplierId != null, PurchaseOrder::getSupplierId, supplierId)
               .eq(PurchaseOrder::getDataStatus, DataStatusEnum.SUCCEED.getType())
               .eq(PurchaseOrder::getReviewStatus, ReviewStatusEnum.REVIEWED.getType())
               .orderByDesc(PurchaseOrder::getId)
         );
      if (orderList.isEmpty()) {
         return Collections.emptyList();
      }

      List<SupplierSummaryPurchaseOrderDTO> purchaseOrderDtoList = new ArrayList<>(orderList.size());
      List<Long> orderIds = orderList.stream().map(PurchaseOrder::getId).collect(Collectors.toList());
      Map<Long, BigDecimal> supplierPaymentMap = this.getOrderIdPaymentAmountMap(
         orderIds, Arrays.asList(SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(), SupplierPropertyTypeEnum.PURCHASE_FEE.getType())
      );
      Map<Long, BigDecimal> supplierInvoiceMap = this.getOrderIdInvoiceAmountMap(
         orderIds, Arrays.asList(SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(), SupplierPropertyTypeEnum.PURCHASE_FEE.getType())
      );
      Map<Long, BigDecimal> purchaseActualInboundAmountMap = this.inboundService.getPurchaseActualInboundAmountMap(orderIds);
      Map<Long, String> branchCompanyMap = this.branchCompanyService.list().stream().collect(Collectors.toMap(BranchCompany::getId, BranchCompany::getName));
      Map<Long, String> supplierMap = this.supplierService
         .listByIds(orderList.stream().map(PurchaseOrder::getSupplierId).collect(Collectors.toSet()))
         .stream()
         .collect(Collectors.toMap(Supplier::getId, Supplier::getName));
      Set<Long> projectIdList = new HashSet<>(orderList.size());
      Map<Long, List<Long>> orderIdProjectIdsMap = new HashMap<>(orderList.size());
      orderList.forEach(order -> {
         if (StringUtils.isNotBlank(order.getProjectIds())) {
            List<Long> collect = Arrays.stream(StringUtils.split(order.getProjectIds(), ",")).map(Long::valueOf).collect(Collectors.toList());
            projectIdList.addAll(collect);
            orderIdProjectIdsMap.put(order.getId(), collect);
         }
      });
      Map<Long, ProjectInfo> projectMap = this.projectService
         .listInfoByIdList(projectIdList)
         .stream()
         .collect(Collectors.toMap(ProjectInfo::getId, Function.identity()));
      orderList.forEach(
         order -> {
            SupplierSummaryPurchaseOrderDTO dto = BeanUtil.copy(order, SupplierSummaryPurchaseOrderDTO.class);
            dto.setInboundAmount(purchaseActualInboundAmountMap.getOrDefault(order.getId(), BigDecimal.ZERO).setScale(2, RoundingMode.HALF_UP));
            dto.setPaidAmount(supplierPaymentMap.getOrDefault(order.getId(), BigDecimal.ZERO));
            dto.setReceivedInvoiceAmount(supplierInvoiceMap.getOrDefault(order.getId(), BigDecimal.ZERO));
            dto.setBranchCompanyName(branchCompanyMap.get(order.getBranchCompanyId()));
            dto.setSupplierName(supplierMap.get(order.getSupplierId()));
            dto.setProjectList(
               orderIdProjectIdsMap.getOrDefault(order.getId(), Collections.emptyList()).stream().map(projectMap::get).collect(Collectors.toList())
            );
            dto.setCreateUserId(order.getApplicantId());
            dto.setCreateUserName(order.getApplicantName());
            purchaseOrderDtoList.add(dto);
         }
      );
      return purchaseOrderDtoList;
   }

   @Override
   public PrintVO<List<SupplierSummaryPurchaseOrderDTO>> purchaseOrderListPrint(Long supplierId) {
      PrintVO<List<SupplierSummaryPurchaseOrderDTO>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      Supplier supplier = this.supplierService.getById(supplierId);
      header.put("supplier", supplier);
      printVO.setHeader(header);
      List<SupplierSummaryPurchaseOrderDTO> purchaseOrderList = this.getPurchaseOrderList(supplierId);
      printVO.setTable(purchaseOrderList);
      return printVO;
   }

   @Override
   public PageVO<SupplierSummarySubOrderDTO> subOrderPageList(Long supplierId, Integer pageNumber, Integer pageSize) {
      Page<Object> page = PageHelper.startPage(pageNumber, pageSize);
      List<SupplierSummarySubOrderDTO> subOrderList = this.getSubOrderList(supplierId);
      return new PageVO<>(page, subOrderList);
   }

   private List<SupplierSummarySubOrderDTO> getSubOrderList(Long supplierId) {
      List<SubcontractOrder> subcontractOrderList = this.subcontractOrderService
         .list(
            Wrappers.lambdaQuery(SubcontractOrder.class)
               .eq(supplierId != null, SubcontractOrder::getSupplierId, supplierId)
               .orderByDesc(SubcontractOrder::getId)
         );
      if (subcontractOrderList.isEmpty()) {
         return Collections.emptyList();
      }

      List<SupplierSummarySubOrderDTO> subOrderDTOList = new ArrayList<>(subcontractOrderList.size());
      List<Long> orderIds = subcontractOrderList.stream().map(SubcontractOrder::getId).collect(Collectors.toList());
      Map<Long, BigDecimal> supplierPaymentMap = this.getOrderIdPaymentAmountMap(
         orderIds, Collections.singletonList(SupplierPropertyTypeEnum.SUB_FEE.getType())
      );
      Map<Long, BigDecimal> supplierInvoiceMap = this.getOrderIdInvoiceAmountMap(
         orderIds, Collections.singletonList(SupplierPropertyTypeEnum.SUB_FEE.getType())
      );
      Map<Long, String> branchCompanyMap = this.branchCompanyService.list().stream().collect(Collectors.toMap(BranchCompany::getId, BranchCompany::getName));
      Map<Long, ProjectInfo> projectMap = this.projectService
         .listInfoByIdList(subcontractOrderList.stream().map(SubcontractOrder::getProjectId).collect(Collectors.toSet()))
         .stream()
         .collect(Collectors.toMap(ProjectInfo::getId, Function.identity()));
      subcontractOrderList.forEach(order -> {
         SupplierSummarySubOrderDTO dto = BeanUtil.copy(order, SupplierSummarySubOrderDTO.class);
         dto.setPaidAmount(supplierPaymentMap.getOrDefault(order.getId(), BigDecimal.ZERO));
         dto.setReceivedInvoiceAmount(supplierInvoiceMap.getOrDefault(order.getId(), BigDecimal.ZERO));
         dto.setSettlementStatus(order.getBoolSettlementStatus() ? SettlementStatusEnum.SETTLED.getType() : SettlementStatusEnum.UN_SETTLED.getType());
         dto.setBranchCompanyName(branchCompanyMap.get(order.getBranchCompanyId()));
         dto.setProjectList(Collections.singletonList(projectMap.get(order.getProjectId())));
         dto.setCreateUserId(order.getUserId());
         dto.setCreateUserName(order.getUserName());
         subOrderDTOList.add(dto);
      });
      return subOrderDTOList;
   }

   @Override
   public PrintVO<List<SupplierSummarySubOrderDTO>> subOrderListPrint(Long supplierId) {
      PrintVO<List<SupplierSummarySubOrderDTO>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      Supplier supplier = this.supplierService.getById(supplierId);
      header.put("supplier", supplier);
      printVO.setHeader(header);
      List<SupplierSummarySubOrderDTO> subOrderList = this.getSubOrderList(supplierId);
      printVO.setTable(subOrderList);
      return printVO;
   }

   @Override
   public PageVO<SupplierSummaryCargoListDTO> cargoListPageList(Long supplierId, Integer pageNumber, Integer pageSize) {
      List<MesBuildingSupplierPrice> supplierPriceList = this.getSupplierPriceList(supplierId);
      Page<Object> page = PageHelper.startPage(pageNumber, pageSize);
      List<SupplierSummaryCargoListDTO> cargoList = this.getCargoList(supplierPriceList);
      return new PageVO<>(page, cargoList);
   }

   private List<MesBuildingSupplierPrice> getSupplierPriceList(Long supplierId) {
      return this.supplierPriceService
         .list(
            Wrappers.lambdaQuery(MesBuildingSupplierPrice.class)
               .isNull(supplierId == null || supplierId.equals(0L), MesBuildingSupplierPrice::getSupplierId)
               .eq(supplierId == null || supplierId.equals(0L), MesBuildingSupplierPrice::getBoolPersonalEnum, true)
               .eq(supplierId != null && !supplierId.equals(0L), MesBuildingSupplierPrice::getSupplierId, supplierId)
         );
   }

   private List<SupplierSummaryCargoListDTO> getCargoList(List<MesBuildingSupplierPrice> supplierPriceList) {
      if (supplierPriceList.isEmpty()) {
         return Collections.emptyList();
      }

      List<Long> supplierPriceIds = supplierPriceList.stream().map(MesBuildingSupplierPrice::getId).collect(Collectors.toList());
      List<MesBuildingCargoList> cargoListList = this.cargoListService
         .list(
            Wrappers.lambdaQuery(MesBuildingCargoList.class)
               .in(MesBuildingCargoList::getSupplierPriceId, supplierPriceIds)
               .in(MesBuildingCargoList::getStatus, CargoListStatusEnum.SHIPMENT.getType(), CargoListStatusEnum.RECEIPT.getType())
               .gt(MesBuildingCargoList::getTotalPrice, BigDecimal.ZERO)
               .orderByDesc(MesBuildingCargoList::getId)
         );
      if (cargoListList.isEmpty()) {
         return Collections.emptyList();
      }

      Map<Long, MesBuildingSupplierPrice> supplierPriceIdMap = supplierPriceList.stream()
         .collect(Collectors.toMap(MesBuildingSupplierPrice::getId, Function.identity()));
      Set<Long> supplierIds = supplierPriceList.stream().map(MesBuildingSupplierPrice::getSupplierId).collect(Collectors.toSet());
      Map<Long, String> supplierMap = this.supplierService.listByIds(supplierIds).stream().collect(Collectors.toMap(Supplier::getId, Supplier::getName));
      Map<Long, ProjectInfo> projectInfoMap = this.projectService
         .listInfoByIdList(cargoListList.stream().map(MesBuildingCargoList::getProjectId).collect(Collectors.toSet()))
         .stream()
         .collect(Collectors.toMap(ProjectInfo::getId, Function.identity()));
      List<SupplierSummaryCargoListDTO> cargoListDTOList = new ArrayList<>(cargoListList.size());
      cargoListList.forEach(cargoList -> {
         SupplierSummaryCargoListDTO dto = BeanUtil.copy(cargoList, SupplierSummaryCargoListDTO.class);
         dto.setProject(projectInfoMap.get(cargoList.getProjectId()));
         dto.setLoadingWeight(cargoList.getActualWeight());
         dto.setShipDate(cargoList.getAuditTime());
         dto.setChangeFreight(cargoList.getChangeFreight() != null ? cargoList.getChangeFreight() : ChangeFreightEnum.FREIGHT_RETAIN.getType());
         MesBuildingSupplierPrice supplierPrice = supplierPriceIdMap.get(cargoList.getSupplierPriceId());
         if (supplierPrice != null) {
            dto.setSupplierId(supplierPrice.getSupplierId());
            dto.setSupplierName(supplierMap.get(supplierPrice.getSupplierId()));
         }

         cargoListDTOList.add(dto);
      });
      return cargoListDTOList;
   }

   @Override
   public PrintVO<List<SupplierSummaryCargoListDTO>> cargoListPrint(Long supplierId) {
      PrintVO<List<SupplierSummaryCargoListDTO>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      Supplier supplier = this.supplierService.getById(supplierId);
      header.put("supplier", supplier);
      printVO.setHeader(header);
      List<MesBuildingSupplierPrice> supplierPriceList = this.getSupplierPriceList(supplierId);
      List<SupplierSummaryCargoListDTO> cargoList = this.getCargoList(supplierPriceList);
      printVO.setTable(cargoList);
      return printVO;
   }

   @Override
   public PageVO<SupplierSummaryLogisticsOrderDTO> logisticsPageList(Long supplierId, Integer pageNumber, Integer pageSize) {
      Page<Object> page = PageHelper.startPage(pageNumber, pageSize);
      List<SupplierSummaryLogisticsOrderDTO> logisticsList = this.getLogisticsList(supplierId);
      return new PageVO<>(page, logisticsList);
   }

   private List<SupplierSummaryLogisticsOrderDTO> getLogisticsList(Long supplierId) {
      List<LogisticsOrder> logisticsOrderList = this.logisticsOrderService
         .list(
            Wrappers.lambdaQuery(LogisticsOrder.class)
               .eq(supplierId != null, LogisticsOrder::getSupplierId, supplierId)
               .eq(LogisticsOrder::getLogisticsPayerType, LogisticsPayerEnum.DEMAND.getType())
               .eq(LogisticsOrder::getInboundReviewStatus, ReviewStatusEnum.REVIEWED.getType())
               .orderByDesc(LogisticsOrder::getId)
         );
      if (logisticsOrderList.isEmpty()) {
         return Collections.emptyList();
      }

      Set<Long> purchaseIds = logisticsOrderList.stream().map(LogisticsOrder::getPurchaseId).collect(Collectors.toSet());
      Map<Long, PurchaseOrder> purchaseOrderMap = this.purchaseOrderService
         .listByIds(purchaseIds)
         .stream()
         .collect(Collectors.toMap(PurchaseOrder::getId, Function.identity()));
      List<Long> inboundIds = logisticsOrderList.stream().map(LogisticsOrder::getInboundId).collect(Collectors.toList());
      Map<Long, Inbound> inboundMap = this.inboundService.listByIds(inboundIds).stream().collect(Collectors.toMap(Inbound::getId, Function.identity()));
      List<SupplierSummaryLogisticsOrderDTO> dtoList = new ArrayList<>(logisticsOrderList.size());
      logisticsOrderList.forEach(logisticsOrder -> {
         SupplierSummaryLogisticsOrderDTO dto = BeanUtil.copy(logisticsOrder, SupplierSummaryLogisticsOrderDTO.class);
         PurchaseOrder purchaseOrder = purchaseOrderMap.get(logisticsOrder.getPurchaseId());
         Inbound inbound = inboundMap.get(logisticsOrder.getInboundId());
         dto.setInboundTime(inbound != null ? inbound.getReviewTime() : null);
         if (purchaseOrder != null) {
            dto.setPurchaseUserId(purchaseOrder.getApplicantId());
            dto.setPurchaseUserName(purchaseOrder.getApplicantName());
         }

         dtoList.add(dto);
      });
      return dtoList;
   }

   @Override
   public PrintVO<List<SupplierSummaryLogisticsOrderDTO>> logisticsListPrint(Long supplierId) {
      PrintVO<List<SupplierSummaryLogisticsOrderDTO>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      Supplier supplier = this.supplierService.getById(supplierId);
      header.put("supplier", supplier);
      printVO.setHeader(header);
      List<SupplierSummaryLogisticsOrderDTO> logisticsList = this.getLogisticsList(supplierId);
      printVO.setTable(logisticsList);
      return printVO;
   }

   private List<Long> getSupplierIds(String supplierName) {
      List<Long> supplierIds = null;
      if (StringUtils.isNotBlank(supplierName)) {
         supplierIds = this.supplierService
            .list(Wrappers.lambdaQuery(Supplier.class).like(Supplier::getName, supplierName).or().like(Supplier::getShortName, supplierName))
            .stream()
            .map(Supplier::getId)
            .collect(Collectors.toList());
         if ("个人".contains(supplierName)) {
            supplierIds.add(null);
         }
      }

      return supplierIds;
   }

   private Map<Long, Map<Long, BigDecimal>> getSupplierIdPurchaseIdAmountMap(Integer type, List<Long> supplierIds) {
      Map<Long, Map<Long, BigDecimal>> supplierIdPurchaseIdAmountMap = Collections.emptyMap();
      if (type == null || type.equals(ContractSupplierSummaryLedgerBizImpl.TypeEnum.PURCHASE_ORDER.getType())) {
         supplierIdPurchaseIdAmountMap = this.purchaseOrderService
            .list(
               Wrappers.lambdaQuery(PurchaseOrder.class)
                  .in(supplierIds != null, PurchaseOrder::getSupplierId, supplierIds)
                  .eq(PurchaseOrder::getDataStatus, DataStatusEnum.SUCCEED.getType())
                  .eq(PurchaseOrder::getReviewStatus, ReviewStatusEnum.REVIEWED.getType())
            )
            .stream()
            .collect(Collectors.groupingBy(PurchaseOrder::getSupplierId, Collectors.toMap(PurchaseOrder::getId, PurchaseOrder::getAmount)));
      }

      return supplierIdPurchaseIdAmountMap;
   }

   private Map<Long, BigDecimal> getSupplierInboundAmountMap(Map<Long, Map<Long, BigDecimal>> supplierIdPurchaseIdAmountMap) {
      if (supplierIdPurchaseIdAmountMap.isEmpty()) {
         return Collections.emptyMap();
      }

      Map<Long, BigDecimal> supplierInboundAmountMap = new HashMap<>(supplierIdPurchaseIdAmountMap.keySet().size());
      List<Long> purchaseOrderIds = new ArrayList<>(supplierIdPurchaseIdAmountMap.values().stream().mapToInt(map -> map.keySet().size()).sum());
      supplierIdPurchaseIdAmountMap.values().forEach(map -> purchaseOrderIds.addAll(map.keySet()));
      Map<Long, BigDecimal> orderIdActualInboundAmountMap = this.inboundService.getPurchaseActualInboundAmountMap(purchaseOrderIds);
      supplierIdPurchaseIdAmountMap.forEach((supplierId, orderIdAmountMap) -> {
         BigDecimal supplierInboundAmount = orderIdAmountMap.keySet().stream().map(orderIdActualInboundAmountMap::get).reduce(BigDecimal.ZERO, BigDecimal::add);
         supplierInboundAmountMap.put(supplierId, supplierInboundAmount);
      });
      return supplierInboundAmountMap;
   }

   private Map<Long, BigDecimal> getSupplierIdIdSubAmountMap(Integer type, List<Long> supplierIds) {
      Map<Long, BigDecimal> supplierIdIdSubAmountMap = Collections.emptyMap();
      if (type == null || type.equals(ContractSupplierSummaryLedgerBizImpl.TypeEnum.SUB_ORDER.getType())) {
         supplierIdIdSubAmountMap = this.subcontractOrderService
            .list(Wrappers.lambdaQuery(SubcontractOrder.class).in(supplierIds != null, SubcontractOrder::getSupplierId, supplierIds))
            .stream()
            .collect(Collectors.groupingBy(SubcontractOrder::getSupplierId, Collectors.reducing(BigDecimal.ZERO, SubcontractOrder::getAmount, BigDecimal::add)));
      }

      return supplierIdIdSubAmountMap;
   }

   private Map<Long, BigDecimal> getSupplierIdLogisticsFreightMap(Integer type, List<Long> supplierIds) {
      Map<Long, BigDecimal> supplierIdFreightMap = Collections.emptyMap();
      if (type == null || type.equals(ContractSupplierSummaryLedgerBizImpl.TypeEnum.LOGISTICS.getType())) {
         supplierIdFreightMap = this.logisticsOrderService
            .list(
               Wrappers.lambdaQuery(LogisticsOrder.class)
                  .in(supplierIds != null, LogisticsOrder::getSupplierId, supplierIds)
                  .eq(LogisticsOrder::getLogisticsPayerType, LogisticsPayerEnum.DEMAND.getType())
                  .eq(LogisticsOrder::getInboundReviewStatus, ReviewStatusEnum.REVIEWED.getType())
            )
            .stream()
            .collect(Collectors.groupingBy(LogisticsOrder::getSupplierId, Collectors.reducing(BigDecimal.ZERO, LogisticsOrder::getFreight, BigDecimal::add)));
      }

      return supplierIdFreightMap;
   }

   private Map<Long, BigDecimal> getSupplierIdTotalPriceMap(Integer type, List<Long> supplierIds) {
      Map<Long, BigDecimal> supplierIdTotalPriceMap = Collections.emptyMap();
      if (type == null || type.equals(ContractSupplierSummaryLedgerBizImpl.TypeEnum.CARGO_LIST.type)) {
         List<MesBuildingSupplierPrice> supplierPriceList = this.supplierPriceService.list();
         if (supplierIds != null) {
            supplierPriceList = supplierPriceList.stream().filter(s -> supplierIds.contains(s.getSupplierId())).collect(Collectors.toList());
         }

         if (CollectionUtils.isNotEmpty(supplierPriceList)) {
            Map<Long, Long> supplierPriceIdMap = supplierPriceList.stream()
               .collect(Collectors.toMap(MesBuildingSupplierPrice::getId, s -> s.getSupplierId() == null && s.getBoolPersonalEnum() ? 0L : s.getSupplierId()));
            supplierIdTotalPriceMap = this.cargoListService
               .list(
                  Wrappers.lambdaQuery(MesBuildingCargoList.class)
                     .in(MesBuildingCargoList::getSupplierPriceId, supplierPriceIdMap.keySet())
                     .in(MesBuildingCargoList::getStatus, CargoListStatusEnum.SHIPMENT.getType(), CargoListStatusEnum.RECEIPT.getType())
               )
               .stream()
               .collect(
                  Collectors.groupingBy(
                     s -> supplierPriceIdMap.get(s.getSupplierPriceId()),
                     Collectors.reducing(BigDecimal.ZERO, MesBuildingCargoList::getTotalPrice, BigDecimal::add)
                  )
               );
         }
      }

      return supplierIdTotalPriceMap;
   }

   private Map<Long, BigDecimal> getOrderIdPaymentAmountMap(Collection<Long> orderIds, List<Integer> supplierPropertyTypeEnumList) {
      return this.supplierPaymentService
         .list(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .in(SupplierPayment::getOrderId, orderIds)
               .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .in(SupplierPayment::getPropertyType, supplierPropertyTypeEnumList)
         )
         .stream()
         .collect(
            Collectors.groupingBy(SupplierPayment::getOrderId, Collectors.reducing(BigDecimal.ZERO, SupplierPayment::getActuallyPaymentAmount, BigDecimal::add))
         );
   }

   private Map<Long, BigDecimal> getOrderIdInvoiceAmountMap(Collection<Long> orderIds, List<Integer> supplierPropertyTypeEnumList) {
      return this.supplierInvoiceService
         .list(
            Wrappers.lambdaQuery(SupplierInvoice.class)
               .in(SupplierInvoice::getOrderId, orderIds)
               .in(SupplierInvoice::getPropertyType, supplierPropertyTypeEnumList)
               .eq(SupplierInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         )
         .stream()
         .collect(
            Collectors.groupingBy(
               SupplierInvoice::getOrderId,
               Collectors.reducing(
                  BigDecimal.ZERO, s -> s.getActualInvoiceAmount() != null ? s.getActualInvoiceAmount() : s.getInvoiceAmount(), BigDecimal::add
               )
            )
         );
   }

   public ContractSupplierSummaryLedgerBizImpl(
      final BranchCompanyService branchCompanyService,
      final SupplierService supplierService,
      final ContractProjectService projectService,
      final PurchaseOrderService purchaseOrderService,
      final SubcontractOrderService subcontractOrderService,
      final MesBuildingCargoListService cargoListService,
      final MesBuildingSupplierPriceService supplierPriceService,
      final LogisticsOrderService logisticsOrderService,
      final SupplierPaymentService supplierPaymentService,
      final SupplierPaymentDetailService supplierPaymentDetailService,
      final SupplierInvoiceService supplierInvoiceService,
      final InboundService inboundService
   ) {
      this.branchCompanyService = branchCompanyService;
      this.supplierService = supplierService;
      this.projectService = projectService;
      this.purchaseOrderService = purchaseOrderService;
      this.subcontractOrderService = subcontractOrderService;
      this.cargoListService = cargoListService;
      this.supplierPriceService = supplierPriceService;
      this.logisticsOrderService = logisticsOrderService;
      this.supplierPaymentService = supplierPaymentService;
      this.supplierPaymentDetailService = supplierPaymentDetailService;
      this.supplierInvoiceService = supplierInvoiceService;
      this.inboundService = inboundService;
   }

   private enum TypeEnum {
      PURCHASE_ORDER(1, "采购合同"),
      SUB_ORDER(2, "分包合同"),
      CARGO_LIST(4, "制成品物流"),
      LOGISTICS(8, "原材料物料");

      private final Integer type;
      private final String name;

      TypeEnum(final Integer type, final String name) {
         this.type = type;
         this.name = name;
      }

      public Integer getType() {
         return this.type;
      }

      public String getName() {
         return this.name;
      }
   }
}
