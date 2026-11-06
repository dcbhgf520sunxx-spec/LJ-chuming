package com.hzchum.scim.contract.core.utilsImpl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.scim.common.core.api.enums.BranchCompanyLevelEnum;
import com.hzchum.scim.contract.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.contract.core.api.enums.payment.SupplierPropertyTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierPayment;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractReimbursementFee;
import com.hzchum.scim.contract.core.api.service.ContractCollectionService;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.SupplierPaymentService;
import com.hzchum.scim.contract.core.api.service.finance.ContractReimbursementFeeService;
import com.hzchum.scim.contract.core.api.utils.ProjectFinanceUtils;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrder;
import com.hzchum.scim.scm.core.api.pojo._do.SubcontractOrder;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import com.hzchum.scim.scm.core.api.service.SubcontractOrderService;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.pojo._do.SysCity;
import com.hzchum.scim.system.core.api.pojo._do.SysCountry;
import com.hzchum.scim.system.core.api.pojo._do.SysProvinceNew;
import com.hzchum.scim.system.core.api.pojo._do.SysRegion;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.system.core.api.service.SysCityService;
import com.hzchum.scim.system.core.api.service.SysCountryService;
import com.hzchum.scim.system.core.api.service.SysProvinceNewService;
import com.hzchum.scim.system.core.api.service.SysRegionService;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProjectFinanceUtilsImpl implements ProjectFinanceUtils {
   @Resource
   private ContractProjectService projectService;
   @Resource
   private ContractCollectionService collectionService;
   @Resource
   private BranchCompanyService branchCompanyService;
   @Resource
   private SupplierPaymentService supplierPaymentService;
   @Resource
   private PurchaseOrderService purchaseOrderService;
   @Resource
   private SubcontractOrderService subcontractOrderService;
   @Resource
   private ContractReimbursementFeeService reimbursementFeeService;
   @Value("${menu.version}")
   private String menuVersion;
   @Value("${bool_many_factory:false}")
   private Boolean boolManyFactory;
   @Resource
   private SysCountryService sysCountryService;
   @Resource
   private SysProvinceNewService sysProvinceNewService;
   @Resource
   private SysCityService sysCityService;
   @Resource
   private SysRegionService sysRegionService;

   @Override
   public Boolean getBoolTwoLevelUnit() {
      Preconditions.checkArgument(StringUtils.isNotBlank(this.menuVersion), "系统版本未知!无法进行操作!");
      return this.menuVersion.contains("group");
   }

   @Override
   public Boolean getBoolMakeVersion() {
      Preconditions.checkArgument(StringUtils.isNotBlank(this.menuVersion), "系统版本未知!无法进行操作!");
      return this.menuVersion.equals("make");
   }

   @Override
   public Boolean getBoolProjectVersion() {
      Preconditions.checkArgument(StringUtils.isNotBlank(this.menuVersion), "系统版本未知!无法进行操作!");
      return this.menuVersion.equals("project");
   }

   @Override
   public Boolean getBoolManyFactory() {
      return this.boolManyFactory;
   }

   @Override
   public Boolean checkVersion() {
      return this.getBoolTwoLevelUnit() || this.getBoolProjectVersion() || this.getBoolMakeVersion();
   }

   @Override
   public Map<Long, BigDecimal> getProjectFirstLevelUnitCost(Collection<Long> projectIds) {
      if (CollectionUtils.isEmpty(projectIds)) {
         return Collections.emptyMap();
      }

      List<Long> primaryUnitCompanyIds = this.branchCompanyService
         .list(Wrappers.lambdaQuery(BranchCompany.builder().level(BranchCompanyLevelEnum.PRIMARY_UNIT.getType()).build()))
         .stream()
         .map(BranchCompany::getId)
         .collect(Collectors.toList());
      if (primaryUnitCompanyIds.isEmpty()) {
         return Collections.emptyMap();
      }

      List<PurchaseOrder> purchaseOrderList = this.purchaseOrderService
         .list(
            Wrappers.lambdaQuery(PurchaseOrder.class)
               .in(PurchaseOrder::getBranchCompanyId, primaryUnitCompanyIds)
               .in(PurchaseOrder::getProjectIds, projectIds.stream().map(String::valueOf).collect(Collectors.toList()))
         );
      Map<Long, BigDecimal> purchaseOrderIdPaymentAmountMap = new HashMap<>(purchaseOrderList.size());
      if (CollectionUtils.isNotEmpty(purchaseOrderList)) {
         List<SupplierPayment> supplierPaymentList = this.supplierPaymentService
            .list(
               Wrappers.lambdaQuery(SupplierPayment.class)
                  .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
                  .in(
                     SupplierPayment::getPropertyType,
                     SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(),
                     SupplierPropertyTypeEnum.PURCHASE_FEE.getType()
                  )
                  .in(SupplierPayment::getBranchCompanyId, primaryUnitCompanyIds)
                  .in(SupplierPayment::getOrderId, purchaseOrderList.stream().map(PurchaseOrder::getId).collect(Collectors.toList()))
            );
         purchaseOrderIdPaymentAmountMap.putAll(
            supplierPaymentList.stream()
               .collect(
                  Collectors.groupingBy(
                     SupplierPayment::getOrderId,
                     Collectors.mapping(SupplierPayment::getActuallyPaymentAmount, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))
                  )
               )
         );
      }

      Map<Long, BigDecimal> projectPaymentAmountMap = purchaseOrderList.stream()
         .collect(
            Collectors.groupingBy(
               s -> Long.parseLong(s.getProjectIds()),
               Collectors.mapping(
                  po -> purchaseOrderIdPaymentAmountMap.getOrDefault(po.getId(), BigDecimal.ZERO), Collectors.reducing(BigDecimal.ZERO, BigDecimal::add)
               )
            )
         );
      List<SubcontractOrder> subcontractOrderList = this.subcontractOrderService
         .list(
            Wrappers.lambdaQuery(SubcontractOrder.class)
               .in(SubcontractOrder::getBranchCompanyId, primaryUnitCompanyIds)
               .in(SubcontractOrder::getProjectId, projectIds)
         );
      Map<Long, BigDecimal> subOrderIdPaymentAmountMap = new HashMap<>(subcontractOrderList.size());
      if (CollectionUtils.isNotEmpty(subcontractOrderList)) {
         List<SupplierPayment> subPaymentList = this.supplierPaymentService
            .list(
               Wrappers.lambdaQuery(SupplierPayment.class)
                  .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
                  .in(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
                  .in(SupplierPayment::getOrderId, subcontractOrderList.stream().map(SubcontractOrder::getId).collect(Collectors.toList()))
            );
         subOrderIdPaymentAmountMap.putAll(
            subPaymentList.stream()
               .collect(
                  Collectors.groupingBy(
                     SupplierPayment::getOrderId,
                     Collectors.mapping(SupplierPayment::getActuallyPaymentAmount, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))
                  )
               )
         );
      }

      Map<Long, BigDecimal> projectSubPaymentAmountMap = subcontractOrderList.stream()
         .collect(
            Collectors.groupingBy(
               SubcontractOrder::getProjectId,
               Collectors.mapping(
                  po -> subOrderIdPaymentAmountMap.getOrDefault(po.getId(), BigDecimal.ZERO), Collectors.reducing(BigDecimal.ZERO, BigDecimal::add)
               )
            )
         );
      Map<Long, BigDecimal> projectReimbursementFeeMap = this.reimbursementFeeService
         .list(
            Wrappers.lambdaQuery(ContractReimbursementFee.class)
               .in(ContractReimbursementFee::getProjectId, projectIds)
               .in(ContractReimbursementFee::getBranchCompanyId, primaryUnitCompanyIds)
         )
         .stream()
         .collect(
            Collectors.groupingBy(
               ContractReimbursementFee::getProjectId,
               Collectors.mapping(ContractReimbursementFee::getReimbursementAmount, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))
            )
         );
      Map<Long, BigDecimal> projectCostMap = new HashMap<>(projectIds.size());
      projectIds.forEach(projectId -> {
         BigDecimal paymentAmount = projectPaymentAmountMap.getOrDefault(projectId, BigDecimal.ZERO);
         BigDecimal subPaymentAmount = projectSubPaymentAmountMap.getOrDefault(projectId, BigDecimal.ZERO);
         BigDecimal reimbursementAmount = projectReimbursementFeeMap.getOrDefault(projectId, BigDecimal.ZERO);
         projectCostMap.put(projectId, paymentAmount.add(subPaymentAmount).add(reimbursementAmount));
      });
      return projectCostMap;
   }

   @Override
   public String getAddress(Long countryId, Long provinceId, Long cityId, Long regionId, String joint) {
      StringBuilder address = new StringBuilder();
      SysCountry country = this.sysCountryService.getById(countryId);
      if (ObjectUtil.isNotEmpty(country)) {
         address.append(country.getName());
      }

      SysProvinceNew sysProvinceNew = ObjectUtil.isNotEmpty(provinceId) ? this.sysProvinceNewService.getById(provinceId) : null;
      if (ObjectUtil.isNotEmpty(sysProvinceNew)) {
         address.append(joint).append(sysProvinceNew.getName());
      }

      SysCity sysCity = ObjectUtil.isNotEmpty(cityId) ? this.sysCityService.getById(cityId) : null;
      if (ObjectUtil.isNotEmpty(sysCity)) {
         address.append(joint).append(sysCity.getName());
      }

      SysRegion sysRegion = ObjectUtil.isNotEmpty(regionId) ? this.sysRegionService.getById(regionId) : null;
      if (ObjectUtil.isNotEmpty(sysRegion)) {
         address.append(joint).append(sysRegion.getName());
      }

      return address.toString();
   }
}
