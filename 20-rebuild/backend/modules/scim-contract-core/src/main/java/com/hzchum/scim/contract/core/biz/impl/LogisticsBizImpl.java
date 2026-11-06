package com.hzchum.scim.contract.core.biz.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.SupplierInfo;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.common.core.api.utils.PageUtils;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.biz.LogisticsBiz;
import com.hzchum.scim.contract.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.contract.core.api.enums.payment.SupplierPaymentInvoiceDetailTypeEnum;
import com.hzchum.scim.contract.core.api.enums.payment.SupplierPropertyTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierInvoice;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierPayment;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierPaymentDetail;
import com.hzchum.scim.contract.core.api.pojo.dto.LogisticsPaymentInfoDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.logistics.LoadingChargeRecordDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.logistics.LogisticsDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.logistics.LogisticsLedgerDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.logistics.LogisticsRecordDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.logistics.LogisticsV2DTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.LogisticsStandingBookDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.LogisticsSupplierSummaryDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.LogisticsSupplierPaymentSaveDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.LogisticsSupplierPaymentUpdateDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.SupplierPaymentDetailSaveParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.SupplierPaymentDetailUpdateParam;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.SupplierInvoiceService;
import com.hzchum.scim.contract.core.api.service.SupplierPaymentDetailService;
import com.hzchum.scim.contract.core.api.service.SupplierPaymentService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingCargoList;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingSupplierPrice;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.ProjectCargoListDTO;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListService;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingSupplierPriceService;
import com.hzchum.scim.scm.core.api.pojo._do.LogisticsOrder;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import com.hzchum.scim.scm.core.api.pojo.dto.PurchaseOrderFreightDTO;
import com.hzchum.scim.scm.core.api.service.LogisticsOrderService;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.pojo._do.SysDictionary;
import com.hzchum.scim.system.core.api.pojo.dto.ProjectConfigVO;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.system.core.api.service.ConfigService;
import com.hzchum.scim.system.core.api.service.SysDictionaryService;
import java.io.File;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = TransactionException.class)
public class LogisticsBizImpl implements LogisticsBiz {
   @Autowired
   private SupplierPaymentService supplierPaymentService;
   @Resource
   private SupplierPaymentDetailService supplierPaymentDetailService;
   @Resource
   private LogisticsOrderService logisticsOrderService;
   @Resource
   private SupplierInvoiceService supplierInvoiceService;
   @Resource
   private MesBuildingCargoListService buildingCargoListService;
   @Resource
   private SupplierService supplierService;
   @Resource
   private BranchCompanyService branchCompanyService;
   @Resource
   private SysDictionaryService dictionaryService;
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private ConfigService configService;
   @Resource
   private ContractProjectService projectService;
   @Resource
   private MesBuildingSupplierPriceService supplierPrice;
   @Resource
   private MesBuildingCargoListService cargoListService;

   @Override
   public PageVO<LogisticsDTO> summary(Integer type, String name, LocalDate startDate, LocalDate endDate, Integer pageNumber, Integer pageSize) {
      SecurityUser currentUser = UserUtil.getCurrentUser();
      List<Long> projectIds = null;
      if (!currentUser.isAdmin()) {
         projectIds = this.projectService.listProjectIdByUser(currentUser.getId(), null);
         if (projectIds.isEmpty()) {
            return new PageVO<>();
         }
      }

      PageHelper.startPage(pageNumber, pageSize);
      List<LogisticsDTO> summary = this.supplierPaymentService.summary(type, name, startDate, endDate, projectIds);
      return new PageVO<>(summary);
   }

   @Override
   public PageVO<LogisticsV2DTO> summaryV2(Integer type, Integer settlementStatus, Integer year, Integer branchCompanyId, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<LogisticsV2DTO> summary = this.supplierPaymentService.summaryV2(type, settlementStatus, year, branchCompanyId);
      return null;
   }

   @Override
   public PageVO<LogisticsStandingBookDTO> showLogisticsLedger(
      Integer executeStatus, Integer type, Integer level, LocalDate date, Integer pageNumber, Integer pageSize
   ) {
      SecurityUser currentUser = UserUtil.getCurrentUser();
      List<Long> projectIds = null;
      if (!currentUser.isAdmin()) {
         projectIds = this.projectService.listProjectIdByUser(currentUser.getId(), level);
         if (projectIds.isEmpty()) {
            return new PageVO<>();
         }
      }

      PageHelper.startPage(pageNumber, pageSize);
      return new PageVO<>(new Page<>());
   }

   @Override
   public PageVO<LogisticsRecordDTO> record(
      Integer type,
      Long id,
      Long branchCompanyId,
      Long supplierId,
      Integer changeFreight,
      LocalDate startDate,
      LocalDate endDate,
      Integer pageNumber,
      Integer pageSize
   ) {
      PageHelper.startPage(pageNumber, pageSize);
      List<LogisticsRecordDTO> record = this.supplierPaymentService.record(type, id, branchCompanyId, supplierId, changeFreight, startDate, endDate);
      return new PageVO<>(record);
   }

   @Override
   public PrintVO printRecord(Integer type, Long id, Long branchCompanyId, Long supplierId, Integer changeFreight, LocalDate startDate, LocalDate endDate) {
      PrintVO printVO = new PrintVO();
      Map header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      List<Map<String, Object>> mapList = this.supplierPaymentService
         .record(type, id, branchCompanyId, supplierId, changeFreight, startDate, endDate)
         .stream()
         .map(BeanUtil::beanToMap)
         .collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public ListVO<LogisticsDTO> summaryPaymentAndInvoice(String name) {
      return new ListVO<>(this.supplierPaymentService.summaryPaymentAndInvoice(name));
   }

   @Override
   public PageVO<LogisticsSupplierSummaryDTO> listSummaryOnSupplier(Integer year, String supplierName, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      return new PageVO<>(this.listSummaryBySupplier(year, supplierName));
   }

   private List<LogisticsSupplierSummaryDTO> listSummaryBySupplier(Integer year, String supplierName) {
      List<LogisticsSupplierSummaryDTO> summaryDTOList = this.logisticsOrderService.summaryBySupplier(year, supplierName);
      if (CollectionUtils.isNotEmpty(summaryDTOList)) {
         summaryDTOList.forEach(
            s -> {
               Long supplierId = s.getSupplierId() != null ? s.getSupplierId() : 0L;
               s.setPaymentAmount(
                  this.supplierPaymentService.getSumPayment(supplierId, s.getBranchCompanyId(), SupplierPropertyTypeEnum.TRANSPORT_FEE.getType(), null, null)
               );
               s.setInvoiceAmount(
                  this.supplierInvoiceService.getInvoiceAmount(null, supplierId, SupplierPropertyTypeEnum.TRANSPORT_FEE.getType(), s.getBranchCompanyId())
               );
               int unCheckPaymentCount = this.supplierPaymentService
                  .count(
                     Wrappers.lambdaQuery(SupplierPayment.class)
                        .eq(s.getSupplierId() != null, SupplierPayment::getReceivingUnitId, s.getSupplierId())
                        .eq(s.getSupplierId() == null, SupplierPayment::getReceivingUnitId, 0L)
                        .eq(SupplierPayment::getPaymentUnitId, s.getBranchCompanyId())
                        .eq(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.TRANSPORT_FEE.getType())
                        .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.AUDITING.getType())
                  );
               s.setUnCheckPaymentCount(unCheckPaymentCount);
               int unCheckInvoiceCount = this.supplierInvoiceService
                  .count(
                     Wrappers.lambdaQuery(SupplierInvoice.class)
                        .eq(s.getSupplierId() != null, SupplierInvoice::getSupplierId, s.getSupplierId())
                        .eq(s.getSupplierId() == null, SupplierInvoice::getSupplierId, 0L)
                        .eq(SupplierInvoice::getBranchCompanyId, s.getBranchCompanyId())
                        .eq(SupplierInvoice::getPropertyType, SupplierPropertyTypeEnum.TRANSPORT_FEE.getType())
                        .eq(SupplierInvoice::getAuditStatus, AuditStatusEnum.AUDITING.getType())
                  );
               s.setUnCheckInvoiceCount(unCheckInvoiceCount);
               SupplierPayment lastPayment = this.supplierPaymentService
                  .getLastPayment(null, SupplierPropertyTypeEnum.TRANSPORT_FEE.getType(), s.getBranchCompanyId(), supplierId);
               s.setLastPaymentAmount(lastPayment != null ? lastPayment.getActuallyPaymentAmount() : null);
            }
         );
      }

      return summaryDTOList;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printSummaryOnSupplier(Integer year, String supplierName) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (year != null) {
         header.put("statisticsDate", year + "年");
      }

      printVO.setHeader(header);
      List<Map<String, Object>> mapList = this.listSummaryBySupplier(year, supplierName).stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public ListVO<LogisticsPaymentInfoDTO> listBySupplierId(Long supplierId, Long branchCompanyId) {
      List<LogisticsPaymentInfoDTO> logisticsPaymentInfoDTOList = new ArrayList<>();
      List<PurchaseOrderFreightDTO> freightDTOList = this.logisticsOrderService.getLogisticsFee(null, supplierId, branchCompanyId);
      if (CollectionUtils.isNotEmpty(freightDTOList)) {
         freightDTOList.forEach(
            f -> {
               LogisticsPaymentInfoDTO logisticsPaymentInfoDTO = BeanUtil.copy(f, LogisticsPaymentInfoDTO.class);
               logisticsPaymentInfoDTO.setType(SupplierPaymentInvoiceDetailTypeEnum.MATERIALS_PURCHASE.getType());
               logisticsPaymentInfoDTO.setPaymentAmount(
                  this.supplierPaymentService.getSumPayment(supplierId, branchCompanyId, SupplierPropertyTypeEnum.TRANSPORT_FEE.getType())
               );
               if (logisticsPaymentInfoDTO.getPaymentAmount().compareTo(f.getFreight()) < 0) {
                  logisticsPaymentInfoDTOList.add(logisticsPaymentInfoDTO);
               }
            }
         );
      }

      List<ProjectCargoListDTO> logisticsFees = this.buildingCargoListService.getLogisticsFees(supplierId, branchCompanyId);
      if (CollectionUtils.isNotEmpty(logisticsFees)) {
         logisticsFees.forEach(
            f -> {
               LogisticsPaymentInfoDTO logisticsPaymentInfoDTO = BeanUtil.copy(f, LogisticsPaymentInfoDTO.class);
               logisticsPaymentInfoDTO.setType(SupplierPaymentInvoiceDetailTypeEnum.MANUFACTURES_SHIP.getType());
               logisticsPaymentInfoDTO.setPaymentAmount(
                  this.supplierPaymentService.getSumPayment(supplierId, branchCompanyId, SupplierPropertyTypeEnum.TRANSPORT_FEE.getType())
               );
               if (logisticsPaymentInfoDTO.getPaymentAmount().compareTo(f.getFreight()) != 0) {
                  logisticsPaymentInfoDTOList.add(logisticsPaymentInfoDTO);
               }
            }
         );
      }

      return new ListVO<>(logisticsPaymentInfoDTOList);
   }

   @Override
   public ListVO<LogisticsPaymentInfoDTO> listBySupplierIdAndBranchCompanyId(Long supplierId, Long branchCompanyId) {
      List<LogisticsPaymentInfoDTO> logisticsPaymentInfoDTOList = new ArrayList<>();
      List<PurchaseOrderFreightDTO> freightDTOList = this.logisticsOrderService.getLogisticsFee(null, supplierId, branchCompanyId);
      if (CollectionUtils.isNotEmpty(freightDTOList)) {
         freightDTOList.forEach(
            f -> {
               LogisticsPaymentInfoDTO logisticsPaymentInfoDTO = BeanUtil.copy(f, LogisticsPaymentInfoDTO.class);
               logisticsPaymentInfoDTO.setType(SupplierPaymentInvoiceDetailTypeEnum.MATERIALS_PURCHASE.getType());
               logisticsPaymentInfoDTO.setPaymentAmount(
                  this.supplierPaymentService
                     .getSumPayment(
                        supplierId,
                        branchCompanyId,
                        SupplierPropertyTypeEnum.TRANSPORT_FEE.getType(),
                        SupplierPaymentInvoiceDetailTypeEnum.MATERIALS_PURCHASE.getType(),
                        f.getPurchaseId()
                     )
               );
               if (logisticsPaymentInfoDTO.getPaymentAmount().compareTo(f.getFreight()) < 0) {
                  logisticsPaymentInfoDTOList.add(logisticsPaymentInfoDTO);
               }
            }
         );
      }

      List<ProjectCargoListDTO> logisticsFees = this.buildingCargoListService.getLogisticsFees(supplierId, branchCompanyId);
      if (CollectionUtils.isNotEmpty(logisticsFees)) {
         ProjectConfigVO projectConfig = this.configService.getProjectConfig();
         logisticsFees.forEach(
            f -> {
               LogisticsPaymentInfoDTO logisticsPaymentInfoDTO = LogisticsPaymentInfoDTO.builder()
                  .type(SupplierPaymentInvoiceDetailTypeEnum.MANUFACTURES_SHIP.getType())
                  .projectId(f.getProjectId())
                  .freight(f.getFreight())
                  .build();
               String name = projectConfig.getShowProjectFullName() ? f.getProjectName() : f.getShortName();
               if (projectConfig.getShowSerialNumber()) {
                  name = !projectConfig.getArrangement().equals(0) && !projectConfig.getArrangement().equals(1)
                     ? name + "_" + f.getSerialNumber()
                     : f.getSerialNumber() + "_" + name;
               }

               logisticsPaymentInfoDTO.setProjectName(name);
               logisticsPaymentInfoDTO.setPaymentAmount(
                  this.supplierPaymentService
                     .getSumPayment(
                        supplierId,
                        branchCompanyId,
                        SupplierPropertyTypeEnum.TRANSPORT_FEE.getType(),
                        SupplierPaymentInvoiceDetailTypeEnum.MANUFACTURES_SHIP.getType(),
                        f.getProjectId()
                     )
               );
               if (logisticsPaymentInfoDTO.getPaymentAmount().compareTo(f.getFreight()) != 0) {
                  logisticsPaymentInfoDTOList.add(logisticsPaymentInfoDTO);
               }
            }
         );
      }

      return new ListVO<>(logisticsPaymentInfoDTOList);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveLogisticsPayment(LogisticsSupplierPaymentSaveDTOParam saveDTOParam) {
      int count = this.supplierPaymentService
         .count(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .eq(SupplierPayment::getReceivingUnitId, saveDTOParam.getSupplierId())
               .eq(SupplierPayment::getPaymentUnitId, saveDTOParam.getBranchCompanyId())
               .eq(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.TRANSPORT_FEE.getType())
               .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.AUDITING.getType())
         );
      Preconditions.checkArgument(count == 0, "新增付款失败,存在未审核的付款");
      SupplierPayment payment = BeanUtil.copy(saveDTOParam, SupplierPayment.class);
      payment.setPropertyType(SupplierPropertyTypeEnum.TRANSPORT_FEE.getType());
      payment.setPaymentUnitId(saveDTOParam.getBranchCompanyId());
      payment.setReceivingUnitId(saveDTOParam.getSupplierId());
      this.setPayInfo(payment);
      payment.setApplyUserId(UserUtil.getCurrentUserId());
      payment.setApplyUserName(UserUtil.getCurrentName());
      payment.setAttachmentIds(StringUtils.join(saveDTOParam.getAttachmentIds(), ","));
      payment.setAuditStatus(AuditStatusEnum.AUDITING.getType());
      this.supplierPaymentService.save(payment);
      List<SupplierPaymentDetailSaveParam> detailSaveParams = saveDTOParam.getDetailSaveParams();
      detailSaveParams.forEach(
         d -> {
            this.check(payment.getPaymentUnitId(), payment.getReceivingUnitId(), d.getType(), d.getPurchaseId(), d.getProjectId(), d.getApplyAmount());
            SupplierPaymentDetail detail = SupplierPaymentDetail.builder()
               .supplierPaymentId(payment.getId())
               .paymentUnitId(payment.getPaymentUnitId())
               .receivingUnitId(payment.getReceivingUnitId())
               .auditStatus(AuditStatusEnum.AUDITING.getType())
               .build();
            BeanUtil.copy(d, detail);
            this.supplierPaymentDetailService.save(detail);
         }
      );
      return true;
   }

   private void setPayInfo(SupplierPayment payment) {
      BranchCompany branchCompany = this.branchCompanyService.getById(payment.getPaymentUnitId());
      Preconditions.checkArgument(branchCompany != null, "付款单位不存在!");
      payment.setPaymentUnit(branchCompany.getName());
      if (payment.getReceivingUnitId() != null && payment.getReceivingUnitId() != 0L) {
         Supplier supplier = this.supplierService.getById(payment.getReceivingUnitId());
         Preconditions.checkArgument(supplier != null, "收款单位不存在");
         payment.setReceivingUnit(supplier.getName());
         payment.setReceiveBank(supplier.getBankName());
         payment.setReceiveBankAccount(supplier.getBankAccount());
      } else {
         payment.setReceivingUnitId(0L);
         payment.setReceivingUnit("个人");
      }

      if (payment.getPaymentReasonId() != null) {
         SysDictionary dictionary = this.dictionaryService.getById(payment.getPaymentReasonId());
         Preconditions.checkArgument(dictionary != null, "付款是由不存在");
         payment.setPaymentReasonName(dictionary.getLabel());
      }
   }

   private void check(Long paymentUnitId, Long receivingUnitId, Integer type, Long purchaseId, Long projectId, BigDecimal applyAmount) {
      Preconditions.checkArgument(SupplierPaymentInvoiceDetailTypeEnum.getNameByType(type) != null, "物流付款类型有误");
      BigDecimal applyAmountSum = this.supplierPaymentDetailService.getApplyAmount(type, projectId, purchaseId, paymentUnitId, receivingUnitId);
      BigDecimal freight;
      if (type.equals(SupplierPaymentInvoiceDetailTypeEnum.MATERIALS_PURCHASE.getType())) {
         freight = this.logisticsOrderService.getSumFreight(purchaseId, paymentUnitId, receivingUnitId, null, null);
      } else {
         BigDecimal buildingShipFeeSum = this.buildingCargoListService.getShipFeeSum(receivingUnitId, projectId, null, null);
         freight = buildingShipFeeSum;
      }

      Preconditions.checkArgument(applyAmountSum.add(applyAmount).compareTo(freight) <= 0, "申请金额超出物流费用");
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateLogisticsPayment(LogisticsSupplierPaymentUpdateDTOParam updateDTOParam) {
      SupplierPayment payment = this.supplierPaymentService.getById(updateDTOParam.getId());
      Preconditions.checkArgument(payment != null, "物流付款记录不存在");
      Preconditions.checkArgument(payment.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()), "修改失败,付款记录已审核");
      BeanUtil.copy(updateDTOParam, payment);
      payment.setPaymentUnitId(updateDTOParam.getPaymentUnitId());
      payment.setReceivingUnitId(updateDTOParam.getReceivingUnitId());
      this.setPayInfo(payment);
      String join = StringUtils.join(updateDTOParam.getAttachmentIds(), ",");
      this.attachmentService.replaceAttachment(payment.getAttachmentIds(), join);
      payment.setAttachmentIds(join);
      this.supplierPaymentService.updateById(payment);
      this.supplierPaymentDetailService
         .remove(Wrappers.lambdaQuery(SupplierPaymentDetail.class).eq(SupplierPaymentDetail::getSupplierPaymentId, updateDTOParam.getId()));
      List<SupplierPaymentDetailUpdateParam> paymentDetails = updateDTOParam.getPaymentDetails();
      paymentDetails.forEach(d -> {
         this.check(payment.getPaymentUnitId(), payment.getReceivingUnitId(), d.getType(), d.getPurchaseId(), d.getProjectId(), d.getApplyAmount());
         d.setId(null);
         SupplierPaymentDetail paymentDetail = BeanUtil.copy(d, SupplierPaymentDetail.class);
         this.supplierPaymentDetailService.save(paymentDetail);
      });
      return true;
   }

   @Override
   public void loadingChargeExport(
      LocalDateTime passStartDate,
      LocalDateTime passEndDate,
      String licensePlate,
      String inboundSN,
      String purchaseOrderSN,
      String userName,
      HttpServletResponse response
   ) {
      String resourcePath = "files/loadingCharge.xlsx";
      String tempFileName = "loadingCharge";
      String exportFileName = "原材料装车费记录.xlsx";
      HashMap<String, Object> map = new HashMap<>();
      List<LoadingChargeRecordDTO> loadingChargeRecordDTOS = this.logisticsOrderService
         .recordLoadingChargeAll(passStartDate, passEndDate, licensePlate, inboundSN, purchaseOrderSN, userName);
      List<Map<String, Object>> mapList = new ArrayList<>();
      BigDecimal thousand = new BigDecimal(1000);

      for (int i = 0; i < loadingChargeRecordDTOS.size(); i++) {
         Map<String, Object> mapObject = new HashMap<>();
         LoadingChargeRecordDTO loadingChargeRecordDTO = loadingChargeRecordDTOS.get(i);
         mapObject.put("id", i + 1);
         mapObject.put("inboundPassTime", DateTimeFormatter.ofPattern("yyyy/MM/dd").format(loadingChargeRecordDTO.getInboundPassTime()));
         mapObject.put("licensePlate", loadingChargeRecordDTO.getLicensePlate());
         mapObject.put("loadingCharge", loadingChargeRecordDTO.getLoadingCharge());
         mapObject.put("inboundSN", loadingChargeRecordDTO.getInboundReceipt().getSerialNumber());
         mapObject.put(
            "loadingWeight",
            ObjectUtil.isNotEmpty(loadingChargeRecordDTO.getLoadingWeight())
               ? loadingChargeRecordDTO.getLoadingWeight().divide(thousand).setScale(2, RoundingMode.HALF_UP)
               : 0
         );
         mapObject.put(
            "freightWeight",
            ObjectUtil.isNotEmpty(loadingChargeRecordDTO.getFreightWeight())
               ? loadingChargeRecordDTO.getFreightWeight().divide(thousand).setScale(2, RoundingMode.HALF_UP)
               : 0
         );
         mapObject.put("purchaseOrderSN", loadingChargeRecordDTO.getPurchaseOrder().getSerialNumber());
         mapObject.put("purchaseUserName", loadingChargeRecordDTO.getPurchaseUserName());
         mapObject.put("inboundUserName", loadingChargeRecordDTO.getInboundUserName());
         mapList.add(mapObject);
      }

      map.put("mapList", mapList);
      InputStream inputStream = null;
      File file = null;

      try {
         org.springframework.core.io.Resource resource = new ClassPathResource(resourcePath);
         inputStream = resource.getInputStream();
         file = File.createTempFile(tempFileName, "xlsx");
      } catch (Exception e) {
         e.printStackTrace();
      }

      FileUtil.copyInputStreamToFile(inputStream, file);
      assert file != null;
      TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath());
      Workbook workbook = ExcelExportUtil.exportExcel(params, map);
      PoiUtils.wmsDownLoadExcel(exportFileName, response, workbook, null);
   }

   @Override
   public PageVO<LogisticsLedgerDTO> getMaterialFlowLedger(
      Integer year, Integer statusEnum, Integer propertyType, Long branchCompanyId, Integer pageNumber, Integer pageSize
   ) {
      List<MesBuildingSupplierPrice> priceList = this.supplierPrice.list();
      if (CollectionUtils.isEmpty(priceList)) {
         return new PageVO<>();
      }

      List<LogisticsLedgerDTO> dto = new ArrayList<>();
      Map<Long, Supplier> supplierMap = this.supplierService.list().stream().collect(Collectors.toMap(Supplier::getId, Function.identity()));
      Map<Long, BranchCompany> branchCompanyMap = this.branchCompanyService
         .list()
         .stream()
         .collect(Collectors.toMap(BranchCompany::getId, Function.identity()));
      Map<Boolean, List<MesBuildingSupplierPrice>> isPersonage = priceList.stream()
         .collect(Collectors.groupingBy(MesBuildingSupplierPrice::getBoolPersonalEnum));
      if (CollectionUtils.isNotEmpty(isPersonage.get(true))) {
      }

      if (CollectionUtils.isNotEmpty(isPersonage.get(false))) {
         List<MesBuildingSupplierPrice> supplierList = this.supplierPrice.getSupplierPriceList(year, branchCompanyId);
         List<MesBuildingSupplierPrice> mesBuildingSupplierPrices = isPersonage.get(false);
         supplierList.forEach(
            q -> {
               LogisticsLedgerDTO build = LogisticsLedgerDTO.builder()
                  .branchCompany(NameInfo.builder().id(q.getBranchCompanyId()).name(branchCompanyMap.get(q.getBranchCompanyId()).getName()).build())
                  .supplier(SupplierInfo.builder().supplierId(q.getSupplierId()).supplierName(supplierMap.get(q.getSupplierId()).getName()).build())
                  .build();
               List<Long> priceIds = mesBuildingSupplierPrices.stream()
                  .filter(a -> Objects.equals(a.getSupplierId(), q.getSupplierId()) && Objects.equals(a.getBranchCompanyId(), q.getBranchCompanyId()))
                  .map(MesBuildingSupplierPrice::getId)
                  .collect(Collectors.toList());
               if (propertyType.equals(2)) {
                  List<MesBuildingCargoList> cargoList = this.cargoListService
                     .list(Wrappers.lambdaQuery(MesBuildingCargoList.class).in(MesBuildingCargoList::getSupplierPriceId, priceIds));
                  if (CollectionUtils.isNotEmpty(cargoList)) {
                     build.setTrainNumber(cargoList.size());
                     build.setInvoiceAmount(cargoList.stream().map(MesBuildingCargoList::getTotalPrice).reduce(BigDecimal.ZERO, BigDecimal::add));
                  }
               }

               if (propertyType.equals(1)) {
                  this.logisticsOrderService.list(Wrappers.lambdaQuery(LogisticsOrder.class).in(LogisticsOrder::getSupplierId, q.getSupplierId()));
               }

               dto.add(build);
            }
         );
      }

      PageVO<LogisticsLedgerDTO> dtoPageVO = new PageVO<>(PageUtils.getPage(dto, pageNumber, pageSize));
      dtoPageVO.setTotalElements(dto.size());
      return dtoPageVO;
   }
}
