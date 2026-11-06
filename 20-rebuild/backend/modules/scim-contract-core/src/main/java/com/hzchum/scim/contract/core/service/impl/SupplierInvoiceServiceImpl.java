package com.hzchum.scim.contract.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageInfo;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.DateTimeUtil;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.contract.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.contract.core.api.enums.payment.SupplierPropertyTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierInvoice;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierInvoiceDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.InvoiceFindDTOParam;
import com.hzchum.scim.contract.core.api.service.SupplierInvoiceService;
import com.hzchum.scim.contract.core.mapper.SupplierInvoiceMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class SupplierInvoiceServiceImpl extends ServiceImpl<SupplierInvoiceMapper, SupplierInvoice> implements SupplierInvoiceService {
   @Resource
   private AttachmentService attachmentService;

   @Override
   public List<SupplierInvoiceDTO> listByCondition(
      Long orderId, Integer propertyType, Long supplierId, Integer auditStatus, LocalDate startDate, LocalDate endDate
   ) {
      return this.baseMapper
         .selectList(
            (Wrapper<SupplierInvoice>)((((Wrappers.<SupplierInvoice>lambdaQuery()
                           .eq(orderId != null, SupplierInvoice::getOrderId, orderId))
                        .eq(supplierId != null, SupplierInvoice::getSupplierId, supplierId))
                     .eq(auditStatus != null, SupplierInvoice::getAuditStatus, auditStatus))
                  .eq(propertyType != null, SupplierInvoice::getPropertyType, propertyType))
               .orderByDesc(BaseEntity::getCreateTime)
         )
         .stream()
         .map(item -> {
            SupplierInvoiceDTO invoiceDTO = BeanUtil.copy(item, SupplierInvoiceDTO.class);
            if (StringUtils.isNotBlank(item.getAttachmentIds())) {
               invoiceDTO.setAttachments(this.attachmentService.listByIds(item.getAttachmentIds()));
            }

            return invoiceDTO;
         })
         .collect(Collectors.toList());
   }

   @Override
   public List<SupplierInvoiceDTO> listInvoiceByUnitId(Long branchCompanyId, Long supplierId, Integer auditStatus) {
      return this.baseMapper
         .selectList(
            (Wrapper<SupplierInvoice>)(((((Wrappers.<SupplierInvoice>lambdaQuery()
                              .eq(SupplierInvoice::getBranchCompanyId, branchCompanyId))
                           .eq(SupplierInvoice::getPropertyType, SupplierPropertyTypeEnum.TRANSPORT_FEE.getType()))
                        .eq(supplierId != null, SupplierInvoice::getSupplierId, supplierId))
                     .eq(supplierId == null, SupplierInvoice::getSupplierId, 0L))
                  .eq(auditStatus != null, SupplierInvoice::getAuditStatus, auditStatus))
               .orderByDesc(BaseEntity::getCreateTime)
         )
         .stream()
         .map(item -> {
            SupplierInvoiceDTO invoiceDTO = BeanUtil.copy(item, SupplierInvoiceDTO.class);
            if (StringUtils.isNotBlank(item.getAttachmentIds())) {
               invoiceDTO.setAttachments(this.attachmentService.listByIds(item.getAttachmentIds()));
            }

            return invoiceDTO;
         })
         .collect(Collectors.toList());
   }

   @Override
   public PageVO<SupplierInvoiceDTO> ledgerPaymentInvoice(InvoiceFindDTOParam param, Integer pageNumber, Integer pageSize) {
      IPage<SupplierInvoice> selectPage = this.baseMapper
         .selectPage(
            new Page<>(pageNumber.intValue(), pageSize.intValue()),
            (Wrapper<SupplierInvoice>)(((((Wrappers.<SupplierInvoice>lambdaQuery()
                              .ge(param.getStartDate() != null, SupplierInvoice::getReceiveInvoiceDate, param.getStartDate()))
                           .le(param.getEndDate() != null, SupplierInvoice::getReceiveInvoiceDate, param.getEndDate()))
                        .like(param.getBranchCompanyName() != null, SupplierInvoice::getBranchCompanyName, param.getBranchCompanyName()))
                     .like(param.getSupplierName() != null, SupplierInvoice::getSupplierName, param.getSupplierName()))
                  .eq(param.getAuditStatus() != null, SupplierInvoice::getAuditStatus, param.getAuditStatus()))
               .orderByDesc(BaseEntity::getCreateTime)
         );
      List<SupplierInvoiceDTO> invoiceDTOList = selectPage.getRecords().stream().map(s -> {
         SupplierInvoiceDTO invoiceDTO = BeanUtil.copy(s, SupplierInvoiceDTO.class);
         invoiceDTO.setAttachments(new ArrayList<>());
         if (StringUtils.isNotBlank(s.getAttachmentIds())) {
            invoiceDTO.setAttachments(this.attachmentService.listByIds(s.getAttachmentIds()));
         }

         return invoiceDTO;
      }).collect(Collectors.toList());
      PageInfo<SupplierInvoiceDTO> pageInfo = new PageInfo<>();
      pageInfo.setTotal(selectPage.getTotal());
      pageInfo.setList(invoiceDTOList);
      pageInfo.setHasNextPage(selectPage.getPages() > selectPage.getCurrent());
      pageInfo.setHasPreviousPage(selectPage.getCurrent() > 1L);
      return new PageVO<>(pageInfo);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printPaymentInvoice(InvoiceFindDTOParam param) {
      List<SupplierInvoice> supplierInvoiceList = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(SupplierInvoice.class)
               .ge(param.getStartDate() != null, SupplierInvoice::getReceiveInvoiceDate, param.getStartDate())
               .le(param.getEndDate() != null, SupplierInvoice::getReceiveInvoiceDate, param.getEndDate())
               .like(param.getBranchCompanyName() != null, SupplierInvoice::getBranchCompanyName, param.getBranchCompanyName())
               .like(param.getSupplierName() != null, SupplierInvoice::getSupplierName, param.getSupplierName())
               .eq(param.getAuditStatus() != null, SupplierInvoice::getAuditStatus, param.getAuditStatus())
               .orderByDesc(BaseEntity::getCreateTime)
         );
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (param.getStartDate() != null || param.getEndDate() != null) {
         String statisticsDate;
         if (param.getStartDate() == null) {
            String endDateStr = DateTimeUtil.getLocalDateStr(param.getEndDate());
            statisticsDate = endDateStr + "以前";
         } else if (param.getEndDate() == null) {
            String startDateStr = DateTimeUtil.getLocalDateStr(param.getStartDate());
            statisticsDate = startDateStr + "至今";
         } else {
            statisticsDate = DateTimeUtil.getLocalDateStr(param.getStartDate()) + "/" + DateTimeUtil.getLocalDateStr(param.getEndDate());
         }

         header.put("statisticsDate", statisticsDate);
      }

      printVO.setHeader(header);
      List<Map<String, Object>> mapList = supplierInvoiceList.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public BigDecimal getSumInvoiceAmount(Long supplierId, Integer propertyType, LocalDate startDate, LocalDate endDate) {
      return this.baseMapper.sumInvoiceAmount(supplierId, propertyType, startDate, endDate);
   }

   @Override
   public BigDecimal getInvoiceAmount(Long orderId, Long supplierId, Integer propertyType, Long branchCompanyId) {
      return this.baseMapper.selectSumInvoice(orderId, supplierId, propertyType, branchCompanyId);
   }

   @Override
   public BigDecimal getPurchaseInvoiceSum(Long supplierId, LocalDate startDate, LocalDate endDate) {
      return this.baseMapper.selectPurchaseInvoiceSum(supplierId, startDate, endDate);
   }

   @Override
   public BigDecimal getOrderInvoiceSum(Long orderId, Integer propertyType) {
      List<SupplierInvoice> invoiceList = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(SupplierInvoice.class)
               .eq(SupplierInvoice::getOrderId, orderId)
               .eq(SupplierInvoice::getPropertyType, propertyType)
               .eq(SupplierInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         );
      return invoiceList.stream().map(SupplierInvoice::getInvoiceAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
   }

   @Override
   public Map<Long, BigDecimal> getSupplierInvoiceAmountMap(Integer propertyType, Collection<Long> supplierIds, LocalDate startDate, LocalDate endDate) {
      return this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(SupplierInvoice.class)
               .eq(propertyType != null, SupplierInvoice::getPropertyType, propertyType)
               .eq(SupplierInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .in(CollectionUtils.isNotEmpty(supplierIds), SupplierInvoice::getSupplierId, supplierIds)
               .ge(startDate != null, SupplierInvoice::getReceiveInvoiceDate, startDate)
               .le(endDate != null, SupplierInvoice::getReceiveInvoiceDate, endDate)
         )
         .stream()
         .collect(
            Collectors.groupingBy(
               SupplierInvoice::getSupplierId, Collectors.mapping(SupplierInvoice::getInvoiceAmount, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))
            )
         );
   }
}
