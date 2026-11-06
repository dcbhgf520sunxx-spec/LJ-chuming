package com.hzchum.scim.scm.core.service;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.contract.core.api.pojo.dto.logistics.LoadingChargeRecordDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.logistics.LogisticsHomeDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.LogisticsSupplierSummaryDTO;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.scm.core.api.enums.LogisticsTransportTypeEnum;
import com.hzchum.scim.scm.core.api.pojo._do.LogisticsOrder;
import com.hzchum.scim.scm.core.api.pojo.dto.LogisticsOrderDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.PurchaseOrderFreightDTO;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.QueryLogisticsOrderDTOParam;
import com.hzchum.scim.scm.core.api.service.LogisticsOrderService;
import com.hzchum.scim.scm.core.mapper.LogisticsOrderMapper;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Measure;
import com.hzchum.scim.wms.core.api.service.wmsConfig.MeasureService;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LogisticsOrderServiceImpl extends ServiceImpl<LogisticsOrderMapper, LogisticsOrder> implements LogisticsOrderService {
   @Resource
   private ContractProjectService contractProjectService;
   @Resource
   private MeasureService measureService;

   @Override
   public PageVO<LogisticsOrderDTO> pageInfo(QueryLogisticsOrderDTOParam param, Integer pageNum, Integer size) {
      PageHelper.startPage(pageNum, size);
      List<LogisticsOrderDTO> logisticsOrderList = this.baseMapper.listInfo(param);
      logisticsOrderList.forEach(lo -> {
         lo.setProjects(this.contractProjectService.listByIds(lo.getProjectIds()));
         lo.setSerialNumber(lo.getLogisticsTransportType().equals(LogisticsTransportTypeEnum.POST.getType()) ? lo.getShipmentNumber() : lo.getSerialNumber());
      });
      return new PageVO<>(logisticsOrderList);
   }

   @Override
   public Integer getCreateCount() {
      return this.baseMapper.getCreateCount();
   }

   @Override
   public List<LogisticsSupplierSummaryDTO> summaryBySupplier(Integer year, String supplierName) {
      return this.baseMapper.selectSummaryOnSupplier(year, supplierName);
   }

   @Override
   public List<LogisticsHomeDTO> showAll(String supplierName) {
      return this.baseMapper.showAll(supplierName);
   }

   @Override
   public List<PurchaseOrderFreightDTO> getLogisticsFee(Long purchaseId, Long supplierId, Long branchCompanyId) {
      return this.baseMapper.selectSumLogisticsFeeList(purchaseId, supplierId, branchCompanyId);
   }

   @Override
   public BigDecimal getSumFreight(Long purchaseId, Long branchCompanyId, Long supplierId, LocalDate startDate, LocalDate endDate) {
      return this.baseMapper.selectLogisticsFee(purchaseId, branchCompanyId, supplierId, startDate, endDate);
   }

   @Override
   public PageVO<LoadingChargeRecordDTO> recordLoadingCharge(
      LocalDateTime passStartDate,
      LocalDateTime passEndDate,
      String licensePlate,
      String inboundSN,
      String purchaseOrderSN,
      String userName,
      Integer pageNumber,
      Integer pageSize
   ) {
      PageHelper.startPage(pageNumber, pageSize);
      List<LoadingChargeRecordDTO> loadingChargeRecordDTOS = this.baseMapper
         .recordLoadingCharge(passStartDate, passEndDate, licensePlate, inboundSN, purchaseOrderSN, userName);
      Measure measures = this.measureService
         .getOne(
            (Wrapper<Measure>)(new LambdaQueryWrapper<Measure>()
                  .or(
                     m -> {
                        LambdaQueryWrapper var10000 = ((((m.eq(
                                       Measure::getBasicClass, BasicClassEnum.STEEL_PLATE.getType()
                                    ))
                                    .or())
                                 .eq(Measure::getBasicClass, BasicClassEnum.SECTION_STEEL.getType()))
                              .or())
                           .eq(Measure::getBasicClass, BasicClassEnum.COLOR_ROLL.getType());
                     }
                  ))
               .last("limit 1")
         );
      if (ObjectUtil.isNotEmpty(measures)) {
         if (measures.getAccountingUnit().equals("克")) {
            loadingChargeRecordDTOS.forEach(l -> l.setLoadingWeight(l.getLoadingWeight().divide(new BigDecimal(1000000))));
         } else if (measures.getAccountingUnit().equals("千克")) {
            loadingChargeRecordDTOS.stream()
               .filter(l -> ObjectUtil.isNotEmpty(l.getLoadingWeight()))
               .forEach(l -> l.setLoadingWeight(l.getLoadingWeight().divide(new BigDecimal(1000))));
         }
      }

      return new PageVO<>(loadingChargeRecordDTOS);
   }

   @Override
   public List<LoadingChargeRecordDTO> recordLoadingChargeAll(
      LocalDateTime passStartDate, LocalDateTime passEndDate, String licensePlate, String inboundSN, String purchaseOrderSN, String userName
   ) {
      return this.baseMapper.recordLoadingCharge(passStartDate, passEndDate, licensePlate, inboundSN, purchaseOrderSN, userName);
   }

   @Override
   public BigDecimal loadingChargeCount(
      LocalDateTime passStartDate, LocalDateTime passEndDate, String licensePlate, String inboundSN, String purchaseOrderSN, String userName
   ) {
      return this.baseMapper.loadingChargeCount(passStartDate, passEndDate, licensePlate, inboundSN, purchaseOrderSN, userName);
   }
}
