package com.hzchum.scim.contract.core.biz.impl.finance;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.common.core.api.utils.PageUtils;
import com.hzchum.scim.contract.core.api.biz.finance.ContractProjectDisburseDetailBiz;
import com.hzchum.scim.contract.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectAttributeEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectBusinessTypeEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectStatusEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierInvoice;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierPayment;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractProjectDisburseDetail;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractProjectDisburseDetailDto;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.SupplierInvoiceService;
import com.hzchum.scim.contract.core.api.service.SupplierPaymentService;
import com.hzchum.scim.contract.core.api.service.finance.ContractProjectDisburseDetailService;
import com.hzchum.scim.contract.core.mapper.finance.ContractProjectDisburseDetailMapper;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrder;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ContractProjectDisburseDetailBizImpl
   extends IBizImpl<ContractProjectDisburseDetailService, ContractProjectDisburseDetailMapper, ContractProjectDisburseDetail>
   implements ContractProjectDisburseDetailBiz {
   @Resource
   private SupplierService supplierService;
   @Resource
   private ContractProjectService projectService;
   @Resource
   private PurchaseOrderService purchaseOrderService;
   @Resource
   private SupplierPaymentService paymentService;
   @Resource
   private BranchCompanyService branchCompanyService;
   @Resource
   private SupplierInvoiceService supplierInvoiceService;
   @Resource
   private UserService userService;

   @Override
   public PageVO<ContractProjectDisburseDetailDto> detailList(Long projectId, Integer pageNumber, Integer pageSize) {
      List<ContractProjectDisburseDetailDto> detailDtos = this.getContractProjectDisburseDetailDtoPageVO(projectId);
      List<ContractProjectDisburseDetailDto> page = PageUtils.getPage(detailDtos, pageNumber, pageSize);
      PageVO<ContractProjectDisburseDetailDto> contractProjectDisburseDetailDtoPageVO = new PageVO<>(page);
      contractProjectDisburseDetailDtoPageVO.setTotalElements(detailDtos.size());
      return contractProjectDisburseDetailDtoPageVO;
   }

   @Override
   public List<ContractProjectDisburseDetailDto> getContractProjectDisburseDetailDtoPageVO(Long projectId) {
      List<ContractProjectDisburseDetailDto> detailDtos = new ArrayList<>();
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在");
      Map<Long, Supplier> supplierMap = this.supplierService.list().stream().collect(Collectors.toMap(Supplier::getId, Function.identity()));
      if (!project.getProjectAttribute().equals(ProjectAttributeEnum.SELF_SUPPORT.getType())) {
         List<PurchaseOrder> purchaseOrders = this.purchaseOrderService
            .list(Wrappers.lambdaQuery(PurchaseOrder.class).isNotNull(PurchaseOrder::getProjectIds))
            .stream()
            .filter(order -> Arrays.asList(order.getProjectIds().split(",")).contains(projectId.toString()))
            .collect(Collectors.toList());
         if (!purchaseOrders.isEmpty()) {
            Map<Long, PurchaseOrder> orderMap = purchaseOrders.stream().collect(Collectors.toMap(PurchaseOrder::getId, Function.identity()));
            List<Long> orderIds = purchaseOrders.stream().map(PurchaseOrder::getId).collect(Collectors.toList());
            List<SupplierInvoice> invoiceList = this.supplierInvoiceService
               .list(
                  Wrappers.lambdaQuery(SupplierInvoice.class)
                     .in(SupplierInvoice::getOrderId, orderIds)
                     .eq(SupplierInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               );
            Map<Long, BigDecimal> invoiceMap = invoiceList.stream()
               .collect(
                  Collectors.groupingBy(
                     SupplierInvoice::getOrderId, Collectors.reducing(BigDecimal.ZERO, SupplierInvoice::getActualInvoiceAmount, BigDecimal::add)
                  )
               );
            List<SupplierPayment> paymentList = this.paymentService
               .list(
                  Wrappers.lambdaQuery(SupplierPayment.class)
                     .in(SupplierPayment::getOrderId, orderIds)
                     .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               );
            if (!paymentList.isEmpty()) {
               Map<Long, List<SupplierPayment>> supplierPaymentMap = paymentList.stream().collect(Collectors.groupingBy(SupplierPayment::getOrderId));
               supplierPaymentMap.forEach(
                  (k, v) -> {
                     BigDecimal paymentAmount = v.stream().map(SupplierPayment::getActuallyPaymentAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
                     BigDecimal invoiceAmountx = ObjectUtils.isNotEmpty(invoiceMap.get(k)) ? invoiceMap.get(k) : BigDecimal.ZERO;
                     detailDtos.add(
                        ContractProjectDisburseDetailDto.builder()
                           .supplierId(v.get(0).getSupplierId())
                           .supplierName(supplierMap.get(v.get(0).getSupplierId()).getName())
                           .expenseType(orderMap.get(k).getBasicClass())
                           .purchaseDetailId(k)
                           .projectId(projectId)
                           .expenseMoney(paymentAmount)
                           .projectAmount(orderMap.get(k).getAmount())
                           .settlementAmount(orderMap.get(k).getSettlementAmount())
                           .purchaseContractNumber(orderMap.get(k).getSerialNumber())
                           .paymentRate(paymentAmount.divide(orderMap.get(k).getAmount(), 2, RoundingMode.FLOOR).multiply(BigDecimal.valueOf(100L)))
                           .invoiceAmount(invoiceAmountx)
                           .invoiceRate(
                              invoiceAmountx.compareTo(BigDecimal.ZERO) == 0
                                 ? BigDecimal.ZERO
                                 : invoiceAmountx.divide(orderMap.get(k).getAmount(), 2, RoundingMode.FLOOR).multiply(BigDecimal.valueOf(100L))
                           )
                           .build()
                     );
                  }
               );
            }
         }
      } else {
         Map<Long, BranchCompany> companyMap = this.branchCompanyService
            .list(Wrappers.lambdaQuery(BranchCompany.class).eq(BranchCompany::getIsParent, 1))
            .stream()
            .collect(Collectors.toMap(BranchCompany::getId, Function.identity()));
         List<PurchaseOrder> orderList = this.purchaseOrderService
            .list(Wrappers.lambdaQuery(PurchaseOrder.class).isNotNull(PurchaseOrder::getProjectIds))
            .stream()
            .filter(order -> Arrays.asList(order.getProjectIds().split(",")).contains(projectId.toString()))
            .collect(Collectors.toList());
         List<Long> orderIds = orderList.stream()
            .filter(a -> companyMap.get(a.getBranchCompanyId()) == null)
            .map(PurchaseOrder::getId)
            .collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(orderIds) && CollectionUtils.isNotEmpty(orderList)) {
            Map<Long, PurchaseOrder> purchaseOrderMap = orderList.stream().collect(Collectors.toMap(PurchaseOrder::getId, Function.identity()));
            Map<Long, List<SupplierPayment>> paymentMap = this.paymentService
               .list(Wrappers.lambdaQuery(SupplierPayment.class).in(SupplierPayment::getOrderId, orderIds))
               .stream()
               .collect(Collectors.groupingBy(SupplierPayment::getOrderId));
            if (paymentMap.isEmpty()) {
               return detailDtos;
            }

            List<SupplierInvoice> invoiceList = this.supplierInvoiceService
               .list(
                  Wrappers.lambdaQuery(SupplierInvoice.class)
                     .eq(SupplierInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
                     .eq(SupplierInvoice::getProjectId, projectId)
               );
            BigDecimal invoiceAmount = !invoiceList.isEmpty()
               ? invoiceList.stream().map(SupplierInvoice::getInvoiceAmount).reduce(BigDecimal.ZERO, BigDecimal::add)
               : BigDecimal.ZERO;
            paymentMap.forEach(
               (k, v) -> {
                  BigDecimal expenseMoney = v.stream()
                     .filter(a -> a.getPaymentAmount() != null)
                     .map(SupplierPayment::getPaymentAmount)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  detailDtos.add(
                     ContractProjectDisburseDetailDto.builder()
                        .supplierId(v.get(0).getSupplierId())
                        .supplierName(supplierMap.get(v.get(0).getSupplierId()).getName())
                        .expenseType(v.get(0).getPropertyType())
                        .purchaseDetailId(k)
                        .projectId(projectId)
                        .expenseMoney(expenseMoney)
                        .projectAmount(purchaseOrderMap.get(k).getAmount())
                        .settlementAmount(purchaseOrderMap.get(k).getSettlementAmount())
                        .purchaseContractNumber(purchaseOrderMap.get(k).getSerialNumber())
                        .paymentRate(expenseMoney.divide(purchaseOrderMap.get(k).getAmount(), 2, RoundingMode.FLOOR).multiply(BigDecimal.valueOf(100L)))
                        .invoiceAmount(invoiceAmount)
                        .invoiceRate(
                           invoiceAmount.compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : expenseMoney.divide(invoiceAmount, 2, RoundingMode.FLOOR)
                        )
                        .build()
                  );
               }
            );
         }
      }

      return detailDtos;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> getSupplierInvoiceDownload(Long projectId) {
      List<ContractProjectDisburseDetailDto> detailDtos = this.getContractProjectDisburseDetailDtoPageVO(projectId);
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      printVO.setTable(detailDtos.stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
      return printVO;
   }

   @Override
   public PrintVO detailListDownload(Long projectId) {
      List<ContractProjectDisburseDetailDto> detailDtos = this.getContractProjectDisburseDetailDtoPageVO(projectId);
      ContractProject project = this.projectService.getById(projectId);
      Map<Long, BranchCompany> branchCompanyMap = this.branchCompanyService
         .list()
         .stream()
         .collect(Collectors.toMap(BranchCompany::getId, Function.identity()));
      Map<Long, User> userMap = this.userService.list().stream().collect(Collectors.toMap(User::getId, Function.identity()));
      List<ContractProjectDisburseDetailDto> contractProjectDisburseDetailDtoPageVO = this.getContractProjectDisburseDetailDtoPageVO(projectId);
      BigDecimal amount = BigDecimal.ZERO;
      if (CollectionUtils.isNotEmpty(contractProjectDisburseDetailDtoPageVO)) {
         amount = contractProjectDisburseDetailDtoPageVO.stream()
            .map(ContractProjectDisburseDetailDto::getProjectAmount)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
      }

      Map<Long, Supplier> supplierMap = this.supplierService.list().stream().collect(Collectors.toMap(Supplier::getId, Function.identity()));
      List<PurchaseOrder> orderList = this.purchaseOrderService
         .list(Wrappers.lambdaQuery(PurchaseOrder.class).isNotNull(PurchaseOrder::getProjectIds))
         .stream()
         .filter(order -> Arrays.asList(order.getProjectIds().split(",")).contains(projectId.toString()))
         .collect(Collectors.toList());
      StringBuilder supplierName = new StringBuilder();
      if (CollectionUtils.isNotEmpty(orderList)) {
         for (int i = 0; i < orderList.size(); i++) {
            Supplier supplier = supplierMap.get(orderList.get(i).getSupplierId());
            if (i == 0) {
               supplierName.append(supplier.getName());
            } else {
               supplierName.append(",").append(supplier.getName());
            }
         }
      }

      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("projectName", project.getSerialNumber() + project.getName());
      header.put("date", project.getSigningDate());
      header.put("amount", project.getContractAmount());
      header.put("salesLeaderId", userMap.get(project.getSalesLeaderId()));
      header.put("businessType", ProjectBusinessTypeEnum.getNameByType(project.getBusinessType()));
      header.put("ContractSignBodyName", branchCompanyMap.get(project.getContractSignBodyId()).getName());
      header.put("projectType", ProjectStatusEnum.getNameByType(project.getStatus()));
      header.put("accumulatedCost", amount);
      header.put("supplierName", supplierName);
      printVO.setHeader(header);
      if (CollectionUtils.isNotEmpty(detailDtos)) {
         detailDtos.forEach(a -> a.setUnpaidAmount(a.getProjectAmount().subtract(a.getExpenseMoney())));
         printVO.setTable(detailDtos.stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
      }

      return printVO;
   }
}
