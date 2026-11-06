package com.hzchum.scim.rest.runner.contract;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.contract.core.api.enums.payment.OrderClassEnum;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierSettlement;
import com.hzchum.scim.contract.core.api.service.SupplierSettlementService;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrder;
import com.hzchum.scim.scm.core.api.pojo._do.SubcontractOrder;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import com.hzchum.scim.scm.core.api.service.SubcontractOrderService;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SupplierSettlementRunner implements CommandLineRunner {
   private final SupplierSettlementService supplierSettlementService;
   private final PurchaseOrderService purchaseOrderService;
   private final SubcontractOrderService subcontractOrderService;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void run(String... args) throws Exception {
      List<SupplierSettlement> settlementList = this.supplierSettlementService.list(Wrappers.lambdaQuery(SupplierSettlement.builder().supplierId(0L).build()));
      if (!settlementList.isEmpty()) {
         Map<Integer, List<SupplierSettlement>> orderClassListMap = settlementList.stream().collect(Collectors.groupingBy(SupplierSettlement::getOrderClass));
         orderClassListMap.forEach(
            (orderClass, list) -> {
               List<Long> orderIds = list.stream().map(SupplierSettlement::getOrderId).collect(Collectors.toList());
               if (orderClass.equals(OrderClassEnum.MATERIAL_ORDER.getType())) {
                  Map<Long, PurchaseOrder> purchaseOrderMap = this.purchaseOrderService
                     .listByIds(orderIds)
                     .stream()
                     .collect(Collectors.toMap(PurchaseOrder::getId, Function.identity()));
                  list.stream()
                     .filter(s -> purchaseOrderMap.containsKey(s.getOrderId()))
                     .forEach(s -> s.setSupplierId(purchaseOrderMap.get(s.getOrderId()).getSupplierId()));
               }

               if (orderClass.equals(OrderClassEnum.SUB_ORDER.getType())) {
                  Map<Long, SubcontractOrder> subcontractOrderMap = this.subcontractOrderService
                     .listByIds(orderIds)
                     .stream()
                     .collect(Collectors.toMap(SubcontractOrder::getId, Function.identity()));
                  list.stream()
                     .filter(s -> subcontractOrderMap.containsKey(s.getOrderId()))
                     .forEach(s -> s.setSupplierId(subcontractOrderMap.get(s.getOrderId()).getSupplierId()));
               }
            }
         );
         this.supplierSettlementService.updateBatchById(settlementList);
      }
   }

   public SupplierSettlementRunner(
      final SupplierSettlementService supplierSettlementService,
      final PurchaseOrderService purchaseOrderService,
      final SubcontractOrderService subcontractOrderService
   ) {
      this.supplierSettlementService = supplierSettlementService;
      this.purchaseOrderService = purchaseOrderService;
      this.subcontractOrderService = subcontractOrderService;
   }
}
