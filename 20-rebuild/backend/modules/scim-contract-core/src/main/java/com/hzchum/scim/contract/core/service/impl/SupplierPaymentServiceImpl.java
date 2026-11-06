package com.hzchum.scim.contract.core.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.enums.ProjectAttributeEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.common.SupplierInfo;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaSupplierPaymentDataIdDTO;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.common.core.api.utils.PageUtils;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.biz.ContractProjectBiz;
import com.hzchum.scim.contract.core.api.biz.LogisticsBiz;
import com.hzchum.scim.contract.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.contract.core.api.enums.PayTypeEnum;
import com.hzchum.scim.contract.core.api.enums.SettlementStatusEnum;
import com.hzchum.scim.contract.core.api.enums.finance.AuditPaymentEnum;
import com.hzchum.scim.contract.core.api.enums.payment.OrderClassEnum;
import com.hzchum.scim.contract.core.api.enums.payment.SupplierPaymentInvoiceDetailTypeEnum;
import com.hzchum.scim.contract.core.api.enums.payment.SupplierPropertyTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierInvoice;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierPayment;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierPaymentDetail;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierSettlement;
import com.hzchum.scim.contract.core.api.pojo._do.audit.ContractAuditLedger;
import com.hzchum.scim.contract.core.api.pojo.dto.LogisticsPaymentInfoDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.logistics.LogisticsDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.logistics.LogisticsDetailDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.logistics.LogisticsHomeDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.logistics.LogisticsInvoiceDetailDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.logistics.LogisticsInvoiceInfoDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.logistics.LogisticsPaymentDetailDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.logistics.LogisticsRecordDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.logistics.LogisticsV2DTO;
import com.hzchum.scim.contract.core.api.pojo.dto.project.ProjectSupplierDto;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.PaymentDetailDto;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.ProjectLedgerSupplierInvoiceDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.ProjectLedgerSupplierInvoiceDetailDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SelfEmployedPaymentAndFinishDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierListDto;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierPaymentDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierPaymentPrintDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierSelfEmployedDto;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.LogisticsInvoiceSaveDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.SporadicLogisticsSaveDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.SupplierPaymentDetailSaveParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.SupplierPaymentSaveDTOParam;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.SupplierInvoiceService;
import com.hzchum.scim.contract.core.api.service.SupplierPaymentDetailService;
import com.hzchum.scim.contract.core.api.service.SupplierPaymentService;
import com.hzchum.scim.contract.core.api.service.SupplierSettlementService;
import com.hzchum.scim.contract.core.api.service.audit.ContractAuditLedgerService;
import com.hzchum.scim.contract.core.mapper.SupplierPaymentMapper;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListService;
import com.hzchum.scim.scm.core.api.enums.PlaceEnum;
import com.hzchum.scim.scm.core.api.enums.PurchaseEnum;
import com.hzchum.scim.scm.core.api.pojo._do.LogisticsOrder;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrder;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrderDetail;
import com.hzchum.scim.scm.core.api.pojo._do.SubcontractOrder;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import com.hzchum.scim.scm.core.api.service.LogisticsOrderService;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderDetailService;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import com.hzchum.scim.scm.core.api.service.SubcontractOrderService;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.BankAccount;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.BankAccountService;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.wms.core.api.enums.DataStatusEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Inbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundManufactured;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Reject;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundManufacturedService;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundService;
import com.hzchum.scim.wms.core.api.service.wmsUse.RejectService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SupplierPaymentServiceImpl extends ServiceImpl<SupplierPaymentMapper, SupplierPayment> implements SupplierPaymentService {
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private SupplierInvoiceService supplierInvoiceService;
   @Resource
   private UserService userService;
   @Resource
   private SupplierService supplierService;
   @Resource
   private ContractProjectService projectService;
   @Resource
   private PurchaseOrderService purchaseOrderService;
   @Resource
   private SupplierPaymentService supplierPaymentService;
   @Resource
   private LogisticsBiz Logistics;
   @Resource
   private InboundService inboundService;
   @Resource
   private RejectService rejectService;
   @Resource
   private ContractAuditLedgerService auditLedgerService;
   @Resource
   private SupplierPaymentDetailService supplierPaymentDetailService;
   @Resource
   private LogisticsOrderService logisticsOrderService;
   @Resource
   private MesBuildingCargoListService buildingCargoListService;
   @Resource
   private SupplierSettlementService supplierSettlementService;
   @Resource
   private BranchCompanyService branchCompanyService;
   @Resource
   private ContractProjectBiz projectBiz;
   @Resource
   private SubcontractOrderService subcontractOrderService;
   @Resource
   private BankAccountService bankAccountService;
   @Resource
   private PurchaseOrderDetailService orderDetailService;
   @Resource
   private InboundManufacturedService inboundManufacturedService;

   @Override
   public List<SupplierPayment> listByCondition(
      Long orderId, Integer propertyType, Long paymentUnitId, Long supplierId, Integer auditStatus, LocalDate startDate, LocalDate endDate
   ) {
      return this.baseMapper.selectByCondition(orderId, propertyType, paymentUnitId, supplierId, auditStatus, startDate, endDate);
   }

   @Override
   public SupplierPayment getLastPayment(Long orderId, Integer propertyType, Long paymentUnitId, Long receivingUnitId) {
      return this.baseMapper.getLastPayment(orderId, propertyType, paymentUnitId, receivingUnitId);
   }

   @Override
   public List<LogisticsDTO> summary(Integer type, String name, LocalDate startDate, LocalDate endDate, List<Long> projectIds) {
      return this.baseMapper.summary(type, name, startDate, endDate, projectIds);
   }

   @Override
   public List<LogisticsDTO> summaryPaymentAndInvoice(String name) {
      return this.baseMapper.summaryPaymentAndInvoice(name);
   }

   @Override
   public List<LogisticsRecordDTO> record(
      Integer type, Long id, Long branchCompanyId, Long supplierId, Integer changeFreight, LocalDate startDate, LocalDate endDate
   ) {
      return this.baseMapper.record(type, id, branchCompanyId, supplierId, changeFreight, startDate, endDate);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveLogisticsInvoice(LogisticsInvoiceSaveDTOParam saveDTOParam) {
      int i = saveDTOParam.getPaymentAmount()
         .compareTo(saveDTOParam.getOpenInvoiceAmount() == null ? BigDecimal.ZERO : saveDTOParam.getOpenInvoiceAmount().add(saveDTOParam.getInvoiceAmount()));
      Preconditions.checkArgument(i == 1, "已开票金额加本次发票额不允许大于付款额度");
      SupplierPayment payment = this.supplierPaymentService.getById(saveDTOParam.getPaymentId());
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(payment), "没有此付款记录");
      SupplierInvoice invoice = SupplierInvoice.builder()
         .orderId(payment.getOrderId())
         .supplierId(saveDTOParam.getSupplierId())
         .projectId(payment.getProjectId())
         .invoiceSerialNumber(saveDTOParam.getInvoiceSerialNumber())
         .invoiceAmount(saveDTOParam.getInvoiceAmount())
         .receiveInvoiceDate(saveDTOParam.getInvoiceDate().toLocalDate())
         .propertyType(SupplierPropertyTypeEnum.TRANSPORT_FEE.getType())
         .branchCompanyId(payment.getPaymentUnitId())
         .branchCompanyName(payment.getPaymentUnit())
         .supplierName(saveDTOParam.getSupplierName())
         .applyUserId(saveDTOParam.getApplyUserId())
         .applyUserName(saveDTOParam.getApplyUserName())
         .auditUserName(UserUtil.getCurrentName())
         .auditUserId(UserUtil.getCurrentUserId())
         .auditTime(LocalDateTime.now())
         .auditStatus(AuditStatusEnum.SUCCEED.getType())
         .attachmentIds(StringUtils.join(saveDTOParam.getAttachmentIds(), ","))
         .build();
      this.auditLedgerService
         .save(
            new ContractAuditLedger()
               .setContractId(payment.getId() != null ? payment.getId().toString() : null)
               .setPaymentId(payment.getId().toString())
               .setPaymentEnum(AuditPaymentEnum.LOGISTICS_INVOICES.getType())
               .setFilingDate(saveDTOParam.getInvoiceDate())
               .setInitiatorId(saveDTOParam.getApplyUserId() != null ? saveDTOParam.getApplyUserId() : UserUtil.getCurrentUserId())
               .setProjectId(payment.getProjectId().toString())
               .setSupplierId(saveDTOParam.getSupplierId())
               .setApplyAmount(saveDTOParam.getInvoiceAmount())
               .setAuditStatusEnum(AuditStatusEnum.SUCCEED.getType())
         );
      return this.supplierInvoiceService.save(invoice);
   }

   @Transactional
   @Override
   public Boolean saveSporadicLogistics(SporadicLogisticsSaveDTOParam saveDTOParam) {
      LogisticsOrder build = LogisticsOrder.builder()
         .supplierId(saveDTOParam.getSupplierId())
         .supplierName(saveDTOParam.getSupplierName())
         .purchaseType(SupplierPaymentInvoiceDetailTypeEnum.SPORADIC_PURCHASE.getType())
         .inboundReviewStatus(ReviewStatusEnum.REVIEWED.getType())
         .projectIds(saveDTOParam.getProjectId())
         .freight(saveDTOParam.getApplyAmount())
         .remark(saveDTOParam.getRemark())
         .inboundReviewStatus(ReviewStatusEnum.REVIEWED.getType())
         .applicantId(saveDTOParam.getInformantId())
         .applicantName(saveDTOParam.getInformantName())
         .build();
      return this.logisticsOrderService.save(build);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveLogisticsPayment(SupplierPaymentSaveDTOParam saveDTOParam) {
      List<SupplierPaymentDetailSaveParam> detailSaveParams = saveDTOParam.getDetailSaveParams();
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(detailSaveParams), "请填写支付明细！");
      detailSaveParams.forEach(
         d -> {
            SupplierPayment payment = BeanUtil.copy(saveDTOParam, SupplierPayment.class);
            payment.setPropertyType(SupplierPropertyTypeEnum.TRANSPORT_FEE.getType());
            payment.setReceivingUnit(saveDTOParam.getSupplierName());
            payment.setReceivingUnitId(saveDTOParam.getSupplierId());
            payment.setPaymentUnitId(1L);
            payment.setPaymentUnit("中南绿建");
            payment.setApplyUserId(UserUtil.getCurrentUserId());
            payment.setApplyUserName(UserUtil.getCurrentName());
            payment.setAttachmentIds(StringUtils.join(saveDTOParam.getAttachmentIds(), ","));
            payment.setAuditStatus(AuditStatusEnum.SUCCEED.getType());
            payment.setApplyAmount(d.getApplyAmount());
            this.supplierPaymentService.save(payment);
            if (ObjectUtils.isNotEmpty(d.getPurchaseId())) {
               PurchaseOrder order = this.purchaseOrderService.getById(d.getPurchaseId());
               this.auditLedgerService
                  .save(
                     new ContractAuditLedger()
                        .setContractId(order.getId() != null ? order.getId().toString() : null)
                        .setPaymentId(payment.getId().toString())
                        .setPaymentEnum(AuditPaymentEnum.LOGISTICS_PAYMENT.getType())
                        .setFilingDate(saveDTOParam.getPaymentDate())
                        .setInitiatorId(saveDTOParam.getApplyUserId() != null ? saveDTOParam.getApplyUserId() : UserUtil.getCurrentUserId())
                        .setContractNumber(order.getSerialNumber() != null ? order.getSerialNumber() : null)
                        .setSupplierId(saveDTOParam.getSupplierId())
                        .setApplyAmount(saveDTOParam.getApplyAmount())
                        .setAuditStatusEnum(AuditStatusEnum.SUCCEED.getType())
                  );
            }
         }
      );
      return true;
   }

   @Override
   public LogisticsPaymentDetailDTO paymentDetails(Long supplierId) {
      ListVO<LogisticsPaymentInfoDTO> logisticsPaymentInfoDTOListVO = this.Logistics.listBySupplierId(supplierId, 1L);
      logisticsPaymentInfoDTOListVO.getContent().addAll(this.getSporadicLogistics(supplierId));
      LogisticsPaymentDetailDTO PaymentDetailDTO = new LogisticsPaymentDetailDTO();
      List<SupplierPayment> list = this.supplierPaymentService
         .list(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .eq(SupplierPayment::getSupplierId, supplierId)
               .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         );
      list.sort(Comparator.comparing(BaseEntity::getCreateTime));
      if (CollectionUtils.isNotEmpty(list)) {
         PaymentDetailDTO.setApplyAmount(
            logisticsPaymentInfoDTOListVO.getContent().stream().map(LogisticsPaymentInfoDTO::getPaymentAmount).reduce(BigDecimal.ZERO, BigDecimal::add)
         );
         PaymentDetailDTO.setReceiveBank(list.get(0).getReceiveBank() != null ? list.get(0).getReceiveBank() : null);
         PaymentDetailDTO.setReceiveBankAccount(list.get(0).getReceiveBankAccount() != null ? list.get(0).getReceiveBankAccount() : null);
      }

      PaymentDetailDTO.setListVO(logisticsPaymentInfoDTOListVO);
      return PaymentDetailDTO;
   }

   @Override
   public LogisticsInvoiceDetailDTO invoicePayment(Long supplierId) {
      LogisticsInvoiceDetailDTO invoiceDetailDTO = new LogisticsInvoiceDetailDTO();
      ListVO<LogisticsPaymentInfoDTO> logisticsPaymentInfoDTOListVO = this.Logistics.listBySupplierId(supplierId, 1L);
      logisticsPaymentInfoDTOListVO.getContent().addAll(this.getSporadicLogistics(supplierId));
      List<SupplierPayment> list = this.supplierPaymentService
         .list(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .eq(SupplierPayment::getSupplierId, supplierId)
               .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         );
      list.sort(Comparator.comparing(BaseEntity::getCreateTime));
      if (CollectionUtils.isNotEmpty(list)) {
         invoiceDetailDTO.setApplyAmount(
            logisticsPaymentInfoDTOListVO.getContent().stream().map(LogisticsPaymentInfoDTO::getPaymentAmount).reduce(BigDecimal.ZERO, BigDecimal::add)
         );
         invoiceDetailDTO.setReceiveBank(list.get(0).getReceiveBank() != null ? list.get(0).getReceiveBank() : null);
         invoiceDetailDTO.setReceiveBankAccount(list.get(0).getReceiveBankAccount() != null ? list.get(0).getReceiveBankAccount() : null);
      }

      invoiceDetailDTO.setListVO(this.getInvoiceInDetail(supplierId));
      return invoiceDetailDTO;
   }

   @Override
   public Map<String, Object> showAll(Integer settlementStatus, String supplierName, Integer auditStatus, Integer pageNumber, Integer pageSize) {
      Map<String, Object> map = new HashMap<>();
      List<LogisticsHomeDTO> logisticsHome = new ArrayList<>();
      List<LogisticsHomeDTO> logisticsHomeDTOS = this.logisticsOrderService.showAll(supplierName);
      Map<String, List<LogisticsHomeDTO>> homeBySupplierId = logisticsHomeDTOS.stream()
         .filter(d -> d.getSupplierId() != null)
         .collect(Collectors.groupingBy(LogisticsHomeDTO::getSupplierId));
      homeBySupplierId.forEach(
         (supplierid, homeDTOS) -> {
            homeDTOS.sort(Comparator.comparing(LogisticsHomeDTO::getCreateTime));
            LogisticsHomeDTO homeDTO = new LogisticsHomeDTO();
            homeDTO.setSupplierName(homeDTOS.get(0).getSupplierName());
            homeDTO.setSupplierId(supplierid);
            homeDTO.setFreight(homeDTOS.stream().map(LogisticsHomeDTO::getFreight).reduce(BigDecimal.ZERO, BigDecimal::add));
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime startOfLastYear = now.minus(1L, ChronoUnit.YEARS).withDayOfYear(1);
            LocalDateTime endOfLastYear = now.minus(1L, ChronoUnit.YEARS).withDayOfYear(LocalDate.now().minusYears(1L).lengthOfYear());
            BigDecimal reduce = homeDTOS.stream()
               .filter(item -> item.getCreateTime().isAfter(startOfLastYear) && item.getCreateTime().isBefore(endOfLastYear))
               .map(LogisticsHomeDTO::getFreight)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            homeDTO.setLastFreight(reduce);
            LocalDateTime startOfYear = now.withDayOfYear(1);
            BigDecimal thisreduce = homeDTOS.stream()
               .filter(item -> item.getCreateTime().isAfter(startOfYear) && item.getCreateTime().isBefore(now))
               .map(LogisticsHomeDTO::getFreight)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            homeDTO.setThisFreight(thisreduce);
            homeDTO.setHistoricalRecord(
               homeDTOS.get(0).getCreateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                  + "~"
                  + homeDTOS.get(homeDTOS.size() - 1).getCreateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
            );
            BigDecimal paymentAmount = this.supplierPaymentService
               .list(
                  Wrappers.lambdaQuery(SupplierPayment.class)
                     .eq(SupplierPayment::getReceivingUnitId, supplierid)
                     .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               )
               .stream()
               .map(SupplierPayment::getApplyAmount)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            homeDTO.setPaymentAmount(paymentAmount);
            BigDecimal invoiceAmount = this.supplierInvoiceService
               .list(
                  Wrappers.lambdaQuery(SupplierInvoice.class)
                     .eq(SupplierInvoice::getSupplierId, supplierid)
                     .eq(SupplierInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               )
               .stream()
               .map(SupplierInvoice::getInvoiceAmount)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            homeDTO.setInvoiceAmount(invoiceAmount);
            logisticsHome.add(homeDTO);
         }
      );
      int num = pageSize * pageNumber;
      Integer size = logisticsHome.size();
      if (num > size) {
         num = size;
      }

      map.put("totalElements", logisticsHome.size());
      map.put("content", (pageNumber - 1) * pageSize > num ? new ArrayList() : logisticsHome.subList((pageNumber - 1) * pageSize, num));
      return map;
   }

   @Override
   public Map<String, Object> detail(String projectName, Long supplierId, LocalDate startDate, LocalDate endDate, Integer pageNumber, Integer pageSize) {
      Map<String, Object> map = new HashMap<>();
      List<LogisticsDetailDTO> material = this.baseMapper.material(null, supplierId, startDate, endDate);
      if (CollectionUtils.isNotEmpty(material)) {
         material.forEach(
            item -> {
               if (StringUtils.isNotBlank(item.getProjectIds())) {
                  Arrays.asList(item.getProjectIds().split(","))
                     .forEach(
                        projectId -> {
                           ContractProject project = this.projectService
                              .getOne(
                                 Wrappers.lambdaQuery(ContractProject.class).eq(ContractProject::getId, projectId).like(ContractProject::getName, projectName)
                              );
                           item.setProjectName(project != null ? project.getSerialNumber() + "+" + project.getShortName() : null);
                        }
                     );
               }
            }
         );
      }

      List<LogisticsDetailDTO> logisticsDetailDTOS = this.baseMapper.manufacturedGoods(projectName, supplierId, startDate, endDate);
      logisticsDetailDTOS.forEach(a -> a.setLoadingWeight(a.getLoadingWeight().divide(BigDecimal.valueOf(1000L), 2, RoundingMode.DOWN)));
      material.addAll(logisticsDetailDTOS);
      int num = pageSize * pageNumber;
      Integer size = material.size();
      if (num > size) {
         num = size;
      }

      map.put("totalElements", material.size());
      map.put("content", (pageNumber - 1) * pageSize > num ? new ArrayList() : material.subList((pageNumber - 1) * pageSize, num));
      return map;
   }

   @Override
   public BigDecimal getSumPaymentAmount(Long supplierId, Integer propertyType, LocalDate startDate, LocalDate endDate) {
      return this.baseMapper.sumLedgerPayment(supplierId, propertyType, startDate, endDate);
   }

   @Override
   public BigDecimal getSumPayment(Long supplierId, Long paymentUnitId, Integer propertyType, Integer type, Long id) {
      return this.baseMapper.selectSumPayment(supplierId, paymentUnitId, propertyType, type, id);
   }

   @Override
   public BigDecimal getSumPayment(Long supplierId, Long paymentUnitId, Integer propertyType) {
      return this.baseMapper.getSumPayment(supplierId, paymentUnitId, propertyType);
   }

   @Override
   public Boolean exportPaymentList(
      Long orderId,
      Integer propertyType,
      Long paymentUnitId,
      Long supplierId,
      Integer auditStatus,
      LocalDate startDate,
      LocalDate endDate,
      HttpServletResponse response
   ) {
      List<Map<String, Object>> mapList = this.listPaymentMap(orderId, propertyType, paymentUnitId, supplierId, auditStatus, startDate, endDate);
      Map<String, Object> map = new HashMap<>();
      map.put("supplierPaymentList", mapList);
      String resourcePath = "files/SupplierPaymentExportTemplate.xlsx";
      String tempFileName = "SupplierPaymentExportTemplate";
      String exportFileName = SupplierPropertyTypeEnum.getNameByType(propertyType) + "-付款记录.xlsx";
      PoiUtils.downLoadExcel(resourcePath, tempFileName, exportFileName, map, response);
      return true;
   }

   @Override
   public List<Map<String, Object>> listPaymentMap(
      Long orderId, Integer propertyType, Long paymentUnitId, Long supplierId, Integer auditStatus, LocalDate startDate, LocalDate endDate
   ) {
      List<SupplierPayment> paymentList = this.baseMapper.selectByCondition(orderId, propertyType, paymentUnitId, supplierId, auditStatus, startDate, endDate);
      List<Map<String, Object>> mapList = new ArrayList<>(16);
      if (CollectionUtils.isNotEmpty(paymentList)) {
         mapList = paymentList.stream().map(p -> BeanUtil.copy(p, SupplierPaymentPrintDTO.class)).map(p -> {
            Map<String, Object> map = BeanUtil.beanToMap(p);
            map.put("paymentBank", StringUtils.isNotBlank(p.getPaymentBank()) ? p.getPaymentBank() : "");
            map.put("paymentBankAccount", StringUtils.isNotBlank(p.getPaymentBankAccount()) ? p.getPaymentBankAccount() : "");
            map.put("applyAmount", p.getApplyAmount().setScale(2, RoundingMode.HALF_UP));
            map.put("actuallyPaymentAmount", p.getActuallyPaymentAmount() != null ? p.getActuallyPaymentAmount().setScale(2, RoundingMode.HALF_UP) : 0);
            map.put("paymentDate", p.getPaymentDate());
            map.put("paymentMethod", p.getPaymentMethod() != null ? PayTypeEnum.getNameByType(p.getPaymentMethod()) : "");
            map.put("auditStatus", AuditStatusEnum.getNameByType(p.getAuditStatus()));
            map.put("auditUserName", StringUtils.isNotBlank(p.getAuditUserName()) ? p.getAuditUserName() : "");
            return map;
         }).collect(Collectors.toList());
      }

      return mapList;
   }

   @Override
   public SupplierPaymentDTO getDetailById(Long id) {
      SupplierPayment payment = this.baseMapper.selectById(id);
      Preconditions.checkArgument(payment != null, "付款记录不存在");
      SupplierPaymentDTO copy = BeanUtil.copy(payment, SupplierPaymentDTO.class);
      copy.setAttachments(this.attachmentService.listByIds(payment.getAttachmentIds()));
      return copy;
   }

   @Override
   public BigDecimal getPurchasePaymentSum(Long orderId, Long supplierId, LocalDate startDate, LocalDate endDate) {
      return this.baseMapper.selectPurchasePaymentSum(orderId, supplierId, startDate, endDate);
   }

   @Override
   public BigDecimal getBreachAmountSum(Long orderId, Integer propertyType, Long supplierId) {
      return this.baseMapper.selectBreachAmountSum(orderId, propertyType, supplierId);
   }

   @Override
   public BigDecimal getOrderPaymentSum(Long orderId, Integer propertyType) {
      List<SupplierPayment> paymentList = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .eq(SupplierPayment::getOrderId, orderId)
               .eq(SupplierPayment::getPropertyType, propertyType)
               .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         );
      return paymentList.stream().map(SupplierPayment::getActuallyPaymentAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
   }

   @Override
   public BigDecimal getPaidPaymentAmount(Long orderId, Integer propertyType) {
      return this.baseMapper.getPaidPaymentAmount(orderId, propertyType);
   }

   @Override
   public Map<Long, BigDecimal> getSupplierPaymentAmountMap(Integer propertyType, Collection<Long> supplierIds, LocalDate startDate, LocalDate endDate) {
      List<SupplierPayment> supplierPaymentList = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .eq(propertyType != null, SupplierPayment::getPropertyType, propertyType)
               .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .in(SupplierPayment::getReceivingUnitId, supplierIds)
               .ge(startDate != null, SupplierPayment::getPaymentDate, startDate)
               .le(endDate != null, SupplierPayment::getPaymentDate, endDate)
         );
      return supplierPaymentList.stream()
         .collect(
            Collectors.groupingBy(
               SupplierPayment::getReceivingUnitId,
               Collectors.mapping(SupplierPayment::getActuallyPaymentAmount, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))
            )
         );
   }

   @Override
   public Map<Long, String> getSupplierList() {
      List<Supplier> supplierList = this.supplierService.list();
      return supplierList.isEmpty() ? Collections.emptyMap() : supplierList.stream().collect(Collectors.toMap(Supplier::getId, Supplier::getName));
   }

   @Override
   public Map<Long, String> getPaymentDetailList(Long supplierId, Boolean boolSettleUse, Boolean boolPreSettleUse) {
      List<PurchaseOrder> orderList = this.purchaseOrderService
         .list(
            Wrappers.lambdaQuery(PurchaseOrder.class)
               .eq(PurchaseOrder::getSupplierId, supplierId)
               .eq(PurchaseOrder::getProjectAttribute, ProjectAttributeEnum.SELF_SUPPORT.getType())
               .eq(boolSettleUse, PurchaseOrder::getSettlementStatus, SettlementStatusEnum.UN_SETTLED.getType())
               .eq(PurchaseOrder::getReviewStatus, ReviewStatusEnum.REVIEWED.getType())
               .eq(PurchaseOrder::getDataStatus, DataStatusEnum.SUCCEED.getType())
               .orderByDesc(PurchaseOrder::getId)
         );
      if (boolSettleUse && CollectionUtils.isNotEmpty(orderList)) {
         List<Long> auditOrderIds = this.supplierSettlementService
            .list(
               Wrappers.lambdaQuery(SupplierSettlement.class)
                  .in(SupplierSettlement::getOrderId, orderList.stream().map(PurchaseOrder::getId).collect(Collectors.toList()))
                  .in(SupplierSettlement::getOrderClass, OrderClassEnum.MATERIAL_ORDER.getType(), OrderClassEnum.MANUFACTURE_ORDER.getType())
                  .eq(SupplierSettlement::getAuditStatus, AuditStatusEnum.AUDITING.getType())
            )
            .stream()
            .map(SupplierSettlement::getOrderId)
            .collect(Collectors.toList());
         orderList = orderList.stream().filter(s -> !auditOrderIds.contains(s.getId())).collect(Collectors.toList());
      }

      return orderList.stream().collect(Collectors.toMap(PurchaseOrder::getId, PurchaseOrder::getSerialNumber));
   }

   @Override
   public SelfEmployedPaymentAndFinishDTO getSupplierPaymentList(List<Long> orderIds) {
      List<PurchaseOrder> orderList = this.purchaseOrderService.list(Wrappers.lambdaQuery(PurchaseOrder.class).in(PurchaseOrder::getId, orderIds));
      Preconditions.checkArgument(!orderList.isEmpty(), "采购合同不存在");
      Map<Long, PurchaseOrder> orderMap = orderList.stream().collect(Collectors.toMap(PurchaseOrder::getId, Function.identity()));
      List<SupplierSelfEmployedDto> dto = new ArrayList<>();
      Map<Long, List<Inbound>> orderIdListMap = this.inboundService
         .list(Wrappers.lambdaQuery(Inbound.class).eq(Inbound::getReviewStatus, ReviewStatusEnum.REVIEWED.getType()).in(Inbound::getPurchaseId, orderIds))
         .stream()
         .collect(Collectors.groupingBy(Inbound::getPurchaseId));
      Map<Long, BigDecimal> orderIdInboundAmountMap = new HashMap<>(32);
      orderIdListMap.forEach((orderId, list) -> {
         BigDecimal bigDecimal = list.stream().map(Inbound::getAmountNoFreight).filter(ObjectUtil::isNotEmpty).reduce(BigDecimal.ZERO, BigDecimal::add);
         orderIdInboundAmountMap.put(orderId, bigDecimal);
      });
      Map<Long, List<Reject>> orderIdRejectListMap = this.rejectService
         .list(Wrappers.lambdaQuery(Reject.class).eq(Reject::getReviewStatus, ReviewStatusEnum.REVIEWED.getType()).in(Reject::getPurchaseOrderId, orderIds))
         .stream()
         .collect(Collectors.groupingBy(Reject::getPurchaseOrderId));
      Map<Long, BigDecimal> orderIdRejectAmountMap = new HashMap<>(32);
      orderIdRejectListMap.forEach((orderId, list) -> {
         BigDecimal bigDecimal = list.stream().map(Reject::getAmountNoFreight).filter(ObjectUtil::isNotEmpty).reduce(BigDecimal.ZERO, BigDecimal::add);
         orderIdRejectAmountMap.put(orderId, bigDecimal);
      });
      Map<Long, BigDecimal> receiviedAmountMap = this.getReceiviedAmount(orderIds);
      Map<Long, BigDecimal> orderIdInboundManufacturedAmountMap = this.inboundManufacturedService
         .list(
            Wrappers.lambdaQuery(InboundManufactured.class)
               .eq(InboundManufactured::getReviewStatus, ReviewStatusEnum.REVIEWED.getType())
               .in(InboundManufactured::getPurchaseId, orderIds)
         )
         .stream()
         .filter(s -> s.getAmount() != null)
         .collect(
            Collectors.groupingBy(InboundManufactured::getPurchaseId, Collectors.reducing(BigDecimal.ZERO, InboundManufactured::getAmount, BigDecimal::add))
         );
      List<SupplierPayment> supplierPayments = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .in(SupplierPayment::getOrderId, orderIds)
               .in(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(), SupplierPropertyTypeEnum.PURCHASE_FEE.getType())
               .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         );
      Map<Long, BigDecimal> paymentMap = supplierPayments.stream()
         .collect(
            Collectors.groupingBy(SupplierPayment::getOrderId, Collectors.reducing(BigDecimal.ZERO, SupplierPayment::getActuallyPaymentAmount, BigDecimal::add))
         );
      List<BankAccount> bankAccountList = this.bankAccountService
         .list(
            Wrappers.lambdaQuery(BankAccount.class)
               .in(BankAccount::getBranchCompanyId, orderList.stream().map(PurchaseOrder::getBranchCompanyId).collect(Collectors.toSet()))
         );
      Map<String, String> bankMap = bankAccountList.stream().collect(Collectors.toMap(BankAccount::getDepositBank, BankAccount::getAccount, (s1, s2) -> s1));
      List<SupplierInvoice> invoiceList = this.supplierInvoiceService
         .list(
            Wrappers.lambdaQuery(SupplierInvoice.class)
               .in(SupplierInvoice::getOrderId, orderIds)
               .in(SupplierInvoice::getPropertyType, SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(), SupplierPropertyTypeEnum.PURCHASE_FEE.getType())
               .eq(SupplierInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         );
      Map<Long, BigDecimal> invoiceMap = invoiceList.stream()
         .collect(
            Collectors.groupingBy(SupplierInvoice::getOrderId, Collectors.reducing(BigDecimal.ZERO, SupplierInvoice::getActualInvoiceAmount, BigDecimal::add))
         );
      Map<Long, BranchCompany> branchCompanyMap = this.branchCompanyService
         .list()
         .stream()
         .collect(Collectors.toMap(BranchCompany::getId, Function.identity()));
      if (CollectionUtils.isNotEmpty(supplierPayments)) {
         StringBuilder projectName = new StringBuilder();
         orderList.forEach(
            order -> {
               BranchCompany company = branchCompanyMap.get(order.getBranchCompanyId());
               SupplierSelfEmployedDto selfEmployedDto = new SupplierSelfEmployedDto()
                  .setOrderId(order.getId())
                  .setContractAmount(order.getAmount())
                  .setContractSignBodyId(order.getBranchCompanyId())
                  .setContractSignBodyName(ObjectUtils.isNotEmpty(company.getShortName()) ? company.getShortName() : company.getName())
                  .setPurchaseContractNumber(order.getSerialNumber());
               if (ObjectUtils.isNotEmpty(invoiceMap)) {
                  selfEmployedDto.setInvoiceAmountSum(ObjectUtils.isNotEmpty(invoiceMap.get(order.getId())) ? invoiceMap.get(order.getId()) : BigDecimal.ZERO);
               }

               if (ObjectUtils.isNotEmpty(paymentMap)) {
                  selfEmployedDto.setPaymentAmountSum(ObjectUtils.isNotEmpty(paymentMap.get(order.getId())) ? paymentMap.get(order.getId()) : BigDecimal.ZERO);
               }

               if (ObjectUtils.isNotEmpty(order.getProjectIds())) {
                  List<Long> projectIds = Arrays.stream(order.getProjectIds().split(",")).map(Long::valueOf).collect(Collectors.toList());
                  StringBuilder name = new StringBuilder();
                  projectIds.forEach(projectId -> {
                     ContractProject pro = this.projectService.getById(projectId);
                     if (ObjectUtils.isNotEmpty(pro)) {
                        projectName.append(pro.getShortName()).append("/");
                        name.append(pro.getShortName()).append("/");
                     }
                  });
                  selfEmployedDto.setProjectNames(name.toString());
               }

               BigDecimal finalInboundAmount = orderIdInboundAmountMap.getOrDefault(order.getId(), BigDecimal.ZERO)
                  .subtract(orderIdRejectAmountMap.getOrDefault(order.getId(), BigDecimal.ZERO));
               if (PlaceEnum.FACTORY.getType().equals(order.getOrderPlace())) {
                  if (PurchaseEnum.MATERIAL.getType().equals(order.getPurchaseType())) {
                     selfEmployedDto.setStorageAmountSum(finalInboundAmount);
                  }

                  if (PurchaseEnum.FINISHED_GOODS.getType().equals(order.getPurchaseType())) {
                     selfEmployedDto.setStorageAmountSum(orderIdInboundManufacturedAmountMap.getOrDefault(order.getId(), BigDecimal.ZERO));
                  }
               }

               if (PlaceEnum.CONSTRUCTION_SITE.getType().equals(order.getOrderPlace())) {
                  selfEmployedDto.setStorageAmountSum(receiviedAmountMap.getOrDefault(order.getId(), BigDecimal.ZERO));
               }

               dto.add(selfEmployedDto);
            }
         );
         return SelfEmployedPaymentAndFinishDTO.builder().paymentDto(bankMap).projectName(projectName.toString()).invoiceDto(dto).build();
      } else {
         StringBuilder projectName = new StringBuilder();
         orderList.forEach(
            order -> {
               BranchCompany company = branchCompanyMap.get(order.getBranchCompanyId());
               SupplierSelfEmployedDto selfEmployedDto = new SupplierSelfEmployedDto()
                  .setOrderId(order.getId())
                  .setContractAmount(order.getAmount())
                  .setContractSignBodyName(ObjectUtils.isNotEmpty(company.getShortName()) ? company.getShortName() : company.getName())
                  .setPurchaseContractNumber(order.getSerialNumber());
               selfEmployedDto.setPaymentAmountSum(paymentMap.getOrDefault(order.getId(), BigDecimal.ZERO));
               selfEmployedDto.setInvoiceAmountSum(invoiceMap.getOrDefault(order.getId(), BigDecimal.ZERO));
               BigDecimal finalInboundAmount = orderIdInboundAmountMap.getOrDefault(order.getId(), BigDecimal.ZERO)
                  .subtract(orderIdRejectAmountMap.getOrDefault(order.getId(), BigDecimal.ZERO));
               if (PlaceEnum.FACTORY.getType().equals(order.getOrderPlace())) {
                  if (PurchaseEnum.MATERIAL.getType().equals(order.getPurchaseType())) {
                     selfEmployedDto.setStorageAmountSum(finalInboundAmount);
                  }

                  if (PurchaseEnum.FINISHED_GOODS.getType().equals(order.getPurchaseType())) {
                     selfEmployedDto.setStorageAmountSum(orderIdInboundManufacturedAmountMap.getOrDefault(order.getId(), BigDecimal.ZERO));
                  }
               }

               if (PlaceEnum.CONSTRUCTION_SITE.getType().equals(order.getOrderPlace())) {
                  selfEmployedDto.setStorageAmountSum(receiviedAmountMap.getOrDefault(order.getId(), BigDecimal.ZERO));
               }

               if (StringUtils.isNotBlank(order.getProjectIds())) {
                  List<Long> projectIds = Arrays.stream(order.getProjectIds().split(",")).map(Long::valueOf).collect(Collectors.toList());
                  StringBuilder name = new StringBuilder();
                  projectIds.forEach(projectId -> {
                     ContractProject pro = this.projectService.getById(projectId);
                     if (ObjectUtils.isNotEmpty(pro)) {
                        projectName.append(pro.getShortName()).append("/");
                        name.append(pro.getShortName()).append("/");
                     }
                  });
                  selfEmployedDto.setProjectNames(name.toString());
               }

               dto.add(selfEmployedDto);
            }
         );
         return SelfEmployedPaymentAndFinishDTO.builder().projectName(String.valueOf(projectName)).paymentDto(bankMap).invoiceDto(dto).build();
      }
   }

   private Map<Long, BigDecimal> getReceiviedAmount(List<Long> purchaseIds) {
      Map<Long, BigDecimal> resultMap = new HashMap<>();
      if (CollectionUtils.isEmpty(purchaseIds)) {
         return resultMap;
      }

      Map<Long, List<PurchaseOrderDetail>> orderDetailMap = this.orderDetailService
         .list(Wrappers.lambdaQuery(PurchaseOrderDetail.class).in(PurchaseOrderDetail::getPurchaseId, purchaseIds))
         .stream()
         .collect(Collectors.groupingBy(PurchaseOrderDetail::getPurchaseId));
      orderDetailMap.forEach(
         (purchaseId, orderDetailList) -> {
            BigDecimal purchaseOrderAmount = orderDetailList.stream()
               .filter(orderDetail -> orderDetail.getUnitPrice() != null)
               .filter(orderDetail -> orderDetail.getActualReceivedMete() != null)
               .map(orderDetail -> orderDetail.getActualReceivedMete().multiply(orderDetail.getUnitPrice()).setScale(2, 4))
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            resultMap.put(purchaseId, purchaseOrderAmount);
         }
      );
      return resultMap;
   }

   @Override
   public ProjectLedgerSupplierInvoiceDTO projectPaymentDetailList(Long projectId, Long supplierId, Long orderId, Integer incomeExpendType) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(project), "项目不存在");
      Long userId;
      if (project.getProjectAttribute().equals(ProjectAttributeEnum.SELF_SUPPORT.getType())) {
         userId = project.getSalesLeaderId() != null ? project.getSalesLeaderId() : project.getSignerId();
      } else {
         userId = project.getProjectManagerId();
      }

      NameInfo user = NameInfo.builder().id(userId).name(this.userService.getNameById(userId)).build();
      Supplier supplier = this.supplierService.getById(supplierId);
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(supplier), "供应商不存在");
      PurchaseOrder purchaseOrder = this.purchaseOrderService.getById(orderId);
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(purchaseOrder), "采购订单不存在");
      List<ProjectLedgerSupplierInvoiceDetailDTO> details = new ArrayList<>();
      if (incomeExpendType.equals(1)) {
         List<SupplierPayment> paymentList = this.baseMapper
            .selectList(
               Wrappers.lambdaQuery(SupplierPayment.class)
                  .eq(SupplierPayment::getOrderId, orderId)
                  .eq(SupplierPayment::getSupplierId, supplierId)
                  .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
            );
         paymentList.forEach(
            payment -> details.add(
               ProjectLedgerSupplierInvoiceDetailDTO.builder()
                  .paymentDate(payment.getAuditTime())
                  .paymentAmount(payment.getActuallyPaymentAmount())
                  .number(String.valueOf(payment.getApprovalSerialNumber()))
                  .type(Integer.valueOf(payment.getPaymentReasonId()))
                  .build()
            )
         );
      } else if (incomeExpendType.equals(2)) {
         List<SupplierInvoice> invoiceList = this.supplierInvoiceService
            .list(
               Wrappers.lambdaQuery(SupplierInvoice.class)
                  .eq(SupplierInvoice::getOrderId, orderId)
                  .eq(SupplierInvoice::getSupplierId, supplierId)
                  .eq(SupplierInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
            );
         invoiceList.forEach(
            invoice -> details.add(
               ProjectLedgerSupplierInvoiceDetailDTO.builder()
                  .paymentDate(invoice.getAuditTime())
                  .paymentAmount(invoice.getInvoiceAmount())
                  .number(invoice.getInvoiceSerialNumber())
                  .type(invoice.getInvoiceType())
                  .build()
            )
         );
      }

      return ProjectLedgerSupplierInvoiceDTO.builder()
         .project(
            ProjectInfo.builder()
               .id(project.getId())
               .serialNumber(project.getSerialNumber())
               .name(project.getName())
               .shortName(project.getShortName())
               .projectAttribute(project.getProjectAttribute())
               .build()
         )
         .createTime(project.getCreateTime())
         .projectManager(user)
         .projectAttribute(project.getProjectAttribute())
         .supplier(SupplierInfo.builder().supplierId(supplier.getId()).supplierName(supplier.getName()).build())
         .supplierNumber(purchaseOrder.getSerialNumber())
         .detail(details)
         .build();
   }

   @Override
   public PrintVO projectPaymentDetailListPrint(Long projectId, Long supplierId, Long orderId, Integer incomeExpendType) {
      ProjectLedgerSupplierInvoiceDTO ledgerSupplierInvoiceDTO = this.projectPaymentDetailList(projectId, supplierId, orderId, incomeExpendType);
      PrintVO printVO = new PrintVO();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      if (ObjectUtils.isEmpty(ledgerSupplierInvoiceDTO)) {
         return printVO;
      }

      header.put("projectAttributeName", ProjectAttributeEnum.getNameByType(ledgerSupplierInvoiceDTO.getProject().getProjectAttribute()));
      header.put("projectManager", ledgerSupplierInvoiceDTO.getProjectManager().getName());
      header.put("createTime", ledgerSupplierInvoiceDTO.getCreateTime());
      header.put("supplier", ledgerSupplierInvoiceDTO.getSupplier().getSupplierName());
      header.put("supplierNumber", ledgerSupplierInvoiceDTO.getSupplierNumber());
      header.put("projectName", ledgerSupplierInvoiceDTO.getProject().getName());
      printVO.setTable(ledgerSupplierInvoiceDTO.getDetail());
      return printVO;
   }

   @Override
   public List<SupplierListDto> getPaymentDetailById(Long projectId, Long supplierId) {
      return this.baseMapper.getList(projectId, supplierId);
   }

   @Override
   public PageVO<PaymentDetailDto> getDetailList(
      Long orderId, Long supplierId, Long projectManagerId, Long projectId, Integer type, Integer pageNumber, Integer pageSize
   ) {
      List<PaymentDetailDto> dto = new ArrayList<>();
      List<User> userList = this.userService.list();
      Preconditions.checkArgument(!userList.isEmpty(), "用户不存在");
      Map<Long, User> userMap = userList.stream().collect(Collectors.toMap(User::getId, Function.identity()));
      List<SupplierPayment> paymentList = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .eq(SupplierPayment::getOrderId, orderId)
               .eq(SupplierPayment::getSupplierId, supplierId)
               .eq(projectManagerId != null, SupplierPayment::getProjectManagerId, projectManagerId)
               .eq(projectId != null, SupplierPayment::getProjectId, projectId)
         );
      List<SupplierInvoice> invoiceList = this.supplierInvoiceService
         .list(
            Wrappers.lambdaQuery(SupplierInvoice.class)
               .eq(SupplierInvoice::getOrderId, orderId)
               .eq(SupplierInvoice::getSupplierId, supplierId)
               .eq(projectId != null, SupplierInvoice::getProjectId, projectId)
               .eq(SupplierInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         );
      if (paymentList.isEmpty()) {
         return new PageVO<>(dto);
      }

      paymentList.forEach(
         payment -> dto.add(
            new PaymentDetailDto()
               .setPaymentAmount(payment.getPaymentAmount())
               .setConfirmUserName(userMap.get(payment.getAuditUserId()) != null ? userMap.get(payment.getAuditUserId()).getName() : null)
               .setApplyDate(payment.getPaymentDate())
               .setOaNumber(payment.getOaNumber())
         )
      );
      if (!invoiceList.isEmpty()) {
         invoiceList.forEach(
            invoice -> dto.add(
               new PaymentDetailDto()
                  .setInvoiceAmount(invoice.getInvoiceAmount())
                  .setConfirmUserName(userMap.get(invoice.getAuditUserId()) != null ? userMap.get(invoice.getAuditUserId()).getName() : null)
                  .setApplyDate(invoice.getReceiveInvoiceDate())
                  .setOaNumber(invoice.getOaNumber())
            )
         );
      }

      List<PaymentDetailDto> page = PageUtils.getPage(dto, pageNumber, pageSize);
      PageVO<PaymentDetailDto> objectPageVO = new PageVO<>(page);
      objectPageVO.setTotalElements(dto.size());
      return objectPageVO;
   }

   @Override
   public List<LogisticsV2DTO> summaryV2(Integer type, Integer settlementStatus, Integer year, Integer branchCompanyId) {
      return this.baseMapper.summaryV2(type, settlementStatus, year, branchCompanyId);
   }

   @Override
   public Integer getVoucherNumber() {
      return this.baseMapper.getVoucherNumber();
   }

   @Override
   public ProjectSupplierDto getSubcontractDetailById(Long subcontractId) {
      SubcontractOrder order = this.subcontractOrderService.getById(subcontractId);
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(order), "合同不存在");
      ContractProject project = this.projectService.getById(order.getProjectId());
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(project), "项目不存在");
      ProjectSupplierDto supplierDto = this.projectBiz.getProjectSupplierDto(project);
      supplierDto.setSubcontractClassId(order.getSubcontractClassId());
      return supplierDto;
   }

   @Override
   public Boolean update(Long id) {
      return this.baseMapper.update(id);
   }

   @Override
   public List<OaSupplierPaymentDataIdDTO> getDataIdList(List<Long> ids) {
      return this.baseMapper.getDataIdList(ids);
   }

   private BigDecimal getApplyAmountSum(Long receivingUnitId, Long paymentUnitId) {
      for (LogisticsOrder order : this.logisticsOrderService
         .list(
            Wrappers.lambdaQuery(LogisticsOrder.class)
               .eq(LogisticsOrder::getPurchaseType, SupplierPaymentInvoiceDetailTypeEnum.SPORADIC_PURCHASE.getType())
               .eq(LogisticsOrder::getSupplierId, receivingUnitId)
         )) {
         ContractProject project = this.projectService.getById(order.getProjectIds());
         BranchCompany company = this.branchCompanyService.getById(project.getContractSignBodyId());
         if (Objects.equals(company.getId(), paymentUnitId)) {
            return order.getFreight();
         }
      }

      return BigDecimal.ZERO;
   }

   private List<LogisticsInvoiceInfoDTO> getInvoiceInDetail(Long supplierId) {
      List<LogisticsInvoiceInfoDTO> logisticsInvoiceInfoDTOS = new ArrayList<>();
      List<SupplierPayment> list = this.supplierPaymentService
         .list(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .eq(SupplierPayment::getSupplierId, supplierId)
               .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         );
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(list), "没有付款记录！");
      list.forEach(
         payment -> {
            LogisticsInvoiceInfoDTO invoiceInfoDTO = new LogisticsInvoiceInfoDTO();
            List<SupplierInvoice> invoiceList = this.supplierInvoiceService
               .list(Wrappers.lambdaQuery(SupplierInvoice.class).eq(SupplierInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType()));
            if (CollectionUtils.isNotEmpty(invoiceList)) {
               invoiceList.sort(Comparator.comparing(BaseEntity::getCreateTime));
               BigDecimal invoiceAmount = invoiceList.stream().map(SupplierInvoice::getInvoiceAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
               invoiceInfoDTO.setInvoiceAmount(invoiceAmount);
               invoiceInfoDTO.setInvoiceDate(list.get(0).getCreateTime());
            }

            invoiceInfoDTO.setPaymentAmount(payment.getApplyAmount());
            invoiceInfoDTO.setPaymentId(payment.getId());
            invoiceInfoDTO.setPaymentDate(payment.getCreateTime());
            logisticsInvoiceInfoDTOS.add(invoiceInfoDTO);
         }
      );
      return logisticsInvoiceInfoDTOS;
   }

   private List<LogisticsPaymentInfoDTO> getSporadicLogistics(Long supplierId) {
      List<LogisticsPaymentInfoDTO> paymentInfoDTOS = new ArrayList<>();
      List<LogisticsOrder> orders = this.logisticsOrderService
         .list(
            Wrappers.lambdaQuery(LogisticsOrder.class)
               .eq(LogisticsOrder::getPurchaseType, SupplierPaymentInvoiceDetailTypeEnum.SPORADIC_PURCHASE.getType())
               .eq(LogisticsOrder::getSupplierId, supplierId)
         );
      orders.forEach(
         order -> {
            LogisticsPaymentInfoDTO paymentInfoDTO = new LogisticsPaymentInfoDTO();
            ContractProject project = this.projectService.getById(order.getProjectIds());
            BranchCompany company = this.branchCompanyService.getById(project.getContractSignBodyId());
            if (ObjectUtils.isNotEmpty(company)) {
               paymentInfoDTO.setFreight(order.getFreight());
               paymentInfoDTO.setType(SupplierPaymentInvoiceDetailTypeEnum.SPORADIC_PURCHASE.getType());
               paymentInfoDTO.setProjectName(project.getName());
               paymentInfoDTO.setPurchaseId(company.getId());
               BigDecimal reduce = this.supplierPaymentDetailService
                  .list(
                     Wrappers.lambdaQuery(SupplierPaymentDetail.class)
                        .eq(SupplierPaymentDetail::getPaymentUnitId, company.getId())
                        .eq(SupplierPaymentDetail::getReceivingUnitId, supplierId)
                        .eq(SupplierPaymentDetail::getType, SupplierPaymentInvoiceDetailTypeEnum.SPORADIC_PURCHASE.getType())
                  )
                  .stream()
                  .map(SupplierPaymentDetail::getApplyAmount)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               paymentInfoDTO.setPaymentAmount(reduce);
               paymentInfoDTOS.add(paymentInfoDTO);
            }
         }
      );
      return paymentInfoDTOS;
   }
}
