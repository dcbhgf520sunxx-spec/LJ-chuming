package com.hzchum.scim.scm.core.service;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.alibaba.excel.write.style.column.SimpleColumnWidthStyleStrategy;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.config.ConfigProperties;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.ApproveRecordStatusEnum;
import com.hzchum.scim.common.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo._do.Attachment;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecordDetail;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveTemplateVersions;
import com.hzchum.scim.common.core.api.pojo.common.ClassificationCheckDTO;
import com.hzchum.scim.common.core.api.pojo.common.IdsStatusDTO;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.common.core.api.pojo.dto.MountMessageDTO;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordFlowDTO;
import com.hzchum.scim.common.core.api.pojo.dtoParam.WmsApproveOpinionDTOParam;
import com.hzchum.scim.common.core.api.pojo.export.ApproveRecordDetailExportDTO;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordDetailService;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.common.core.api.service.WmsApproveTemplateVersionsService;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.enums.AuditTypeEnum;
import com.hzchum.scim.contract.core.api.enums.SettlementStatusEnum;
import com.hzchum.scim.contract.core.api.enums.finance.AuditPaymentEnum;
import com.hzchum.scim.contract.core.api.enums.payment.OrderClassEnum;
import com.hzchum.scim.contract.core.api.enums.payment.SupplierPaymentInvoiceDetailTypeEnum;
import com.hzchum.scim.contract.core.api.enums.payment.SupplierPropertyTypeEnum;
import com.hzchum.scim.contract.core.api.enums.visa.ProjectAttributeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo._do.ProjectBranchCompanyLink;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierInvoice;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierPayment;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierPaymentDetail;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierSettlement;
import com.hzchum.scim.contract.core.api.pojo._do.audit.ContractAuditLedger;
import com.hzchum.scim.contract.core.api.pojo.dto.ProjectBranchCompanyLinkDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ProjectRelevancyDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.SupplierSettlementDto;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.PurchaseStandingBookDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierPaymentRecordDTO;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.ProjectBranchCompanyLinkService;
import com.hzchum.scim.contract.core.api.service.SupplierInvoiceService;
import com.hzchum.scim.contract.core.api.service.SupplierPaymentDetailService;
import com.hzchum.scim.contract.core.api.service.SupplierPaymentService;
import com.hzchum.scim.contract.core.api.service.SupplierSettlementService;
import com.hzchum.scim.contract.core.api.service.audit.ContractAuditLedgerService;
import com.hzchum.scim.contract.core.api.service.finance.ContractReimbursementFeeService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingFactory;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingFactoryService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactDTO;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.project.core.api.pojo._do.ProjectReceivingRecord;
import com.hzchum.scim.project.core.api.service.ProjectReceivingRecordService;
import com.hzchum.scim.scm.core.api.common.DetailQuantityAndMete;
import com.hzchum.scim.scm.core.api.common.utils.ExcelUtils;
import com.hzchum.scim.scm.core.api.enums.ApplyPurchaseMaterialTypeEnum;
import com.hzchum.scim.scm.core.api.enums.ApplyPurchaseStateEnum;
import com.hzchum.scim.scm.core.api.enums.DelButtonTypeEnum;
import com.hzchum.scim.scm.core.api.enums.LogisticsPayerEnum;
import com.hzchum.scim.scm.core.api.enums.LogisticsTransportTypeEnum;
import com.hzchum.scim.scm.core.api.enums.PlaceEnum;
import com.hzchum.scim.scm.core.api.enums.PurchaseEnum;
import com.hzchum.scim.scm.core.api.enums.PurchaseOrderModeEnum;
import com.hzchum.scim.scm.core.api.enums.PurchaseStatusEnum;
import com.hzchum.scim.scm.core.api.pojo._do.ApplyPurchase;
import com.hzchum.scim.scm.core.api.pojo._do.ApplyPurchaseDetail;
import com.hzchum.scim.scm.core.api.pojo._do.LogisticsOrder;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrder;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrderDetail;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import com.hzchum.scim.scm.core.api.pojo.dao.PurchaseOrderGroupDetailDO;
import com.hzchum.scim.scm.core.api.pojo.dto.ApplyPurchaseDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.ApplyPurchaseDetailDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.BriefIdAndNameDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.BriefIdAndSNDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.BriefPurchaseOrderDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.BriefPurchaseOrderNewDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.BuildingFactoryDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.IdAndNameDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.PurchaseOrderDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.PurchaseOrderDetailDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.PurchaseOrderGroupDetailDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.PurchaseOrderGroupMonthDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.PurchaseOrderGroupMonthDetailDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.PurchaseOrderGroupSupplierDetailDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.PurchaseOrderSummaryDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.PurchaseSupplierSummaryDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.SimpleListDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.SupplierAllBriefDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.SupplierDTO;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.ApplyPurchaseStatusDTOParam;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.PurchaseOrderDTOParam;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.PurchaseOrderDetailDTOParam;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.QueryPurchaseOrderDTOParam;
import com.hzchum.scim.scm.core.api.service.ApplyPurchaseService;
import com.hzchum.scim.scm.core.api.service.LogisticsOrderService;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import com.hzchum.scim.scm.core.mapper.ApplyPurchaseDetailMapper;
import com.hzchum.scim.scm.core.mapper.PurchaseOrderDetailMapper;
import com.hzchum.scim.scm.core.mapper.PurchaseOrderMapper;
import com.hzchum.scim.system.core.api.biz.notification.SysPushFlowConfigBiz;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.enums.notification.NotificationModuleTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.common.utils.notification.MessagePushUtil;
import com.hzchum.scim.system.core.api.common.utils.notification.NotificationTemplateDetailsUtils;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo.dto.UserResponseVO;
import com.hzchum.scim.system.core.api.pojo.dto.config.FinanceAmountLimitConfigDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.FinanceAmountShowConfigDTO;
import com.hzchum.scim.system.core.api.pojo.dto.notification.NotificationServiceTriggerDTO;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.system.core.api.service.ConfigService;
import com.hzchum.scim.system.core.api.service.NumberConfigService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.wms.core.api.biz.SectionSteelSpecService;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.enums.DataStatusEnum;
import com.hzchum.scim.wms.core.api.enums.InvoiceTypeEnum;
import com.hzchum.scim.wms.core.api.enums.MeasureTypeEnum;
import com.hzchum.scim.wms.core.api.enums.MessageEnum;
import com.hzchum.scim.wms.core.api.enums.RejectEnum;
import com.hzchum.scim.wms.core.api.enums.UnitEnum;
import com.hzchum.scim.wms.core.api.enums.UnitsPrecisionEnum;
import com.hzchum.scim.wms.core.api.enums.WmsWageQuotaTypeEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.BasicInbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.BasicShowConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Classification;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Measure;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.SectionSteelSpec;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.SectionSteelSpecStandardDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Standard;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Unit;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Workshop;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.AnnualContract;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Inbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundDetailManufactured;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundManufactured;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Reject;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsAdjustDetail;
import com.hzchum.scim.wms.core.api.pojo.dto.common.ReceiptMeteDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.InstantMessageHintDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.QuantityMeteDTO;
import com.hzchum.scim.wms.core.api.service.wmsConfig.BasicConfigService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.ClassificationService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.MeasureService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.SectionSteelSpecStandardDetailService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.SpecificationService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.StandardService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.UnitService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WorkshopService;
import com.hzchum.scim.wms.core.api.service.wmsReport.WarehouseDataDashboardService;
import com.hzchum.scim.wms.core.api.service.wmsUse.AnnualContractService;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundDetailManufacturedService;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundManufacturedService;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundService;
import com.hzchum.scim.wms.core.api.service.wmsUse.RejectDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.RejectService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsAdjustDetailService;
import com.hzchum.scim.wms.core.api.utils.CommonUtil;
import com.hzchum.scim.wms.core.api.utils.QueryUtilService;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PurchaseOrderServiceImpl extends ServiceImpl<PurchaseOrderMapper, PurchaseOrder> implements PurchaseOrderService {
   private static final Logger log = LogManager.getLogger(PurchaseOrderServiceImpl.class);
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private ContractProjectService contractProjectService;
   @Resource
   private SupplierService supplierService;
   @Resource
   private NumberConfigService numberConfigService;
   @Resource
   private InboundService inboundService;
   @Resource
   private InboundManufacturedService inboundManufacturedService;
   @Resource
   private InboundDetailManufacturedService inboundDetailManufacturedService;
   @Resource
   private WmsAdjustDetailService wmsAdjustDetailService;
   @Resource
   private BranchCompanyService branchCompanyService;
   @Resource
   private PurchaseOrderDetailMapper purchaseOrderDetailMapper;
   @Resource
   private ApplyPurchaseService applyPurchaseService;
   @Resource
   private TechArtifactService artifactService;
   @Resource
   private SupplierPaymentService supplierPaymentService;
   @Resource
   private SupplierPaymentDetailService supplierPaymentDetailService;
   @Resource
   private SupplierInvoiceService supplierInvoiceService;
   @Resource
   private SupplierSettlementService supplierSettlementService;
   @Resource
   private ContractAuditLedgerService contractAuditLedgerService;
   @Resource
   private ApplyPurchaseDetailMapper applyPurchaseDetailMapper;
   @Resource
   InboundDetailService inboundDetailService;
   @Resource
   AnnualContractService annualContractService;
   @Resource
   WmsApproveRecordService wmsApproveRecordService;
   @Resource
   private WmsApproveRecordDetailService wmsApproveRecordDetailService;
   @Resource
   private ConfigService configService;
   @Resource
   MesBuildingFactoryService factoryService;
   @Resource
   WmsApproveTemplateVersionsService wmsApproveTemplateVersionsService;
   @Resource
   ClassificationService classificationService;
   @Resource
   SectionSteelSpecService sectionSteelSpecService;
   @Resource
   SectionSteelSpecStandardDetailService sectionSteelSpecStandardDetailService;
   @Resource
   StandardService standardService;
   @Resource
   SpecificationService specificationService;
   @Resource
   UserService userService;
   @Resource
   MeasureService measureService;
   @Resource
   UnitService unitService;
   @Resource
   ProjectBranchCompanyLinkService companyLinkService;
   @Resource
   private ContractReimbursementFeeService reimbursementFeeService;
   @Resource
   private ContractProjectService projectService;
   @Resource
   private MesBuildingWorkshopService mesWorkshopService;
   @Resource
   QueryUtilService queryUtilService;
   @Resource
   RejectService rejectService;
   @Resource
   BasicConfigService basicConfigService;
   @Resource
   WorkshopService workshopService;
   @Resource
   PlanMonomerService planMonomerService;
   @Resource
   PlanAreaService planAreaService;
   @Resource
   private SysPushFlowConfigBiz sysPushFlowConfigBiz;
   @Resource
   private NotificationTemplateDetailsUtils detailsUtils;
   @Resource
   private MessagePushUtil messagePushUtil;
   @Resource
   private ConfigProperties configProperties;
   @Resource
   private RedisTemplate redisTemplate;
   @Resource
   private ProjectReceivingRecordService receivingRecordService;
   @Resource
   private RejectDetailService rejectDetailService;
   @Resource
   private WarehouseDataDashboardService warehouseDataDashboardService;
   @Resource
   LogisticsOrderService logisticsOrderService;
   private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
   private static final BigDecimal MAX = new BigDecimal(99999999999L);
   private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");

   @Override
   public PageVO<PurchaseOrderDTO> pageInfo(QueryPurchaseOrderDTOParam param, Integer pageNum, Integer size, List<String> sort) {
      String s = StringUtils.analyzeSortConditions(sort);
      Page<PurchaseOrder> page = PageHelper.startPage(pageNum, size, s);
      List<PurchaseOrder> purchaseOrders = this.baseMapper.listInfo(param);
      List<PurchaseOrderDTO> collect = new ArrayList<>();

      for (PurchaseOrder po : purchaseOrders) {
         PurchaseOrderDTO orderDTO = BeanUtil.copy(po, PurchaseOrderDTO.class);
         orderDTO.setCreateTime(po.getCreateTime());
         orderDTO.setUpdateTime(po.getUpdateTime());
         if (po.getSupplierId() != null) {
            Supplier supplier = this.supplierService.getById(po.getSupplierId());
            orderDTO.setSupplier(BriefIdAndNameDTO.builder().id(supplier.getId()).name(supplier.getName()).build());
         }

         if (StrUtil.isNotBlank(po.getApplyPurchaseSN())) {
            orderDTO.setApplyPurchaseSN(Arrays.asList((String[])po.getApplyPurchaseSN().split(",").clone()));
         }

         if (StrUtil.isNotBlank(po.getAuxMaterialIds())) {
            orderDTO.setAuxMaterialIds(CommonUtil.spilt(po.getAuxMaterialIds(), ","));
         }

         if (StrUtil.isNotBlank(po.getOtherMaterialIds())) {
            orderDTO.setOtherMaterialIds(CommonUtil.spilt(po.getOtherMaterialIds(), ","));
         }

         BranchCompany branchCompany = this.branchCompanyService.getById(po.getBranchCompanyId());
         orderDTO.setBranchCompany(BriefIdAndNameDTO.builder().id(branchCompany.getId()).name(branchCompany.getName()).build());
         if (StrUtil.isNotBlank(po.getAttachments())) {
            orderDTO.setAttachments(
               this.attachmentService
                  .listByIds(po.getAttachments())
                  .stream()
                  .map(attachmentDTO -> BeanUtil.copy(attachmentDTO, AttachmentDTO.class))
                  .collect(Collectors.toList())
            );
         } else {
            orderDTO.setAttachments(new ArrayList<>());
         }

         if (StrUtil.isNotBlank(po.getProjectIds())) {
            List<ProjectInfo> projectInfos = this.contractProjectService.listByIds(po.getProjectIds());
            if (BasicClassEnum.STRUC_MANUFACTURED.getType().equals(po.getBasicClass())) {
               orderDTO.setProject(projectInfos.get(0));
            } else {
               orderDTO.setProjects(projectInfos);
            }
         }

         if (po.getPurchaseType().equals(PurchaseEnum.MATERIAL.getType())) {
            orderDTO.setBoolUsed(
               CollectionUtils.isNotEmpty(this.inboundService.list((Wrapper<Inbound>)Wrappers.<Inbound>lambdaQuery().eq(Inbound::getPurchaseId, orderDTO.getId())))
            );
         } else if (po.getPurchaseType().equals(PurchaseEnum.FINISHED_GOODS.getType())) {
            orderDTO.setBoolUsed(
               CollectionUtils.isNotEmpty(
                  this.inboundManufacturedService
                     .list((Wrapper<InboundManufactured>)Wrappers.<InboundManufactured>lambdaQuery().eq(InboundManufactured::getPurchaseId, orderDTO.getId()))
               )
            );
         } else {
            Preconditions.checkArgument(false, "未知采购材料类型！！！");
         }

         collect.add(orderDTO);
      }

      return new PageVO<>(page, collect);
   }

   @Override
   public List<SimpleListDTO> simpleListInfo() {
      return this.baseMapper.simpleListInfo();
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean editPurchaseStatus(Long id, Integer purchaseStatus) {
      PurchaseOrder purchaseOrder = this.baseMapper.selectById(id);
      Preconditions.checkArgument(purchaseStatus != null, "订单信息不存在");
      Preconditions.checkArgument(
         purchaseStatus.equals(PurchaseStatusEnum.FINISH.getType()) || purchaseOrder.getSettlementStatus().equals(SettlementStatusEnum.UN_SETTLED.getType()),
         "订单已结算,不能设为采购状态!"
      );
      if (purchaseOrder.getPurchaseType().equals(PurchaseEnum.MATERIAL.getType())) {
         List<Inbound> inbounds = this.inboundService
            .list(
               (Wrapper<Inbound>)(Wrappers.<Inbound>lambdaQuery().eq(Inbound::getPurchaseId, purchaseOrder.getId()))
                  .eq(Inbound::getReviewStatus, ReviewStatusEnum.UN_REVIEWED.getType())
            );
         Preconditions.checkArgument(CollectionUtil.isEmpty(inbounds), "修改失败,订单存在入库未审核！！！");
      } else if (purchaseOrder.getPurchaseType().equals(PurchaseEnum.FINISHED_GOODS.getType())) {
         List<InboundManufactured> inboundManufactureds = this.inboundManufacturedService
            .list(
               (Wrapper<InboundManufactured>)(Wrappers.<InboundManufactured>lambdaQuery().eq(InboundManufactured::getPurchaseId, purchaseOrder.getId()))
                  .eq(InboundManufactured::getReviewStatus, ReviewStatusEnum.UN_REVIEWED.getType())
            );
         Preconditions.checkArgument(CollectionUtil.isEmpty(inboundManufactureds), "修改失败,订单存在入库未审核！！！");
      } else {
         Preconditions.checkArgument(false, "未知采购材料类型！！！");
      }

      purchaseOrder.setPurchaseStatus(purchaseStatus);
      return this.baseMapper.updateById(purchaseOrder) == 1;
   }

   @Override
   public void exportOrder(Long id, HttpServletResponse response) {
      PurchaseOrder detail = this.baseMapper.selectById(id);
      Preconditions.checkArgument(detail != null, "下载失败，对应订单不存在");
      HashMap<String, Object> map = new HashMap<>(16);
      String resourcePath = "files/template/supplier/OrderDetailExportTemplate.xlsx";
      String tempFileName = "OrderDetailExportTemplate";
      String exportFileName = "采购订单.xlsx";
      DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      String date = df.format(detail.getCreateTime());
      map.put("date", date);
      map.put("SN", detail.getSerialNumber());
      if (detail.getSupplierId() != null) {
         Supplier supplier = this.supplierService.getById(detail.getSupplierId());
         map.put("supplierName", supplier.getName());
      }

      List<String> list = new ArrayList<>();
      if ((detail.getBasicClass() & BasicClassEnum.STEEL_PLATE.getType()) > 0
         || (detail.getBasicClass() & BasicClassEnum.SECTION_STEEL.getType()) > 0
         || (detail.getBasicClass() & BasicClassEnum.COLOR_ROLL.getType()) > 0) {
         list.add("钢材");
      }

      if ((detail.getBasicClass() & BasicClassEnum.ENCL_MANUFACTURED.getType()) > 0) {
         list.add(BasicClassEnum.ENCL_MANUFACTURED.getName());
      }

      if ((detail.getBasicClass() & BasicClassEnum.STRUC_MANUFACTURED.getType()) > 0) {
         list.add(BasicClassEnum.STRUC_MANUFACTURED.getName());
      }

      if ((BasicClassEnum.GENERAL_MATERIAL.getType() & detail.getBasicClass()) > 0) {
         list.add(BasicClassEnum.GENERAL_MATERIAL.getName());
      }

      if ((BasicClassEnum.GAS.getType() & detail.getBasicClass()) > 0) {
         list.add(BasicClassEnum.GAS.getName());
      }

      map.put("basicClass", StrUtil.join("、", list));
      map.put("amount", detail.getAmount());
      map.put("number", detail.getMete().stripTrailingZeros().toPlainString() + detail.getMeteUnit());
      StringBuilder stringBuilder = new StringBuilder();
      if (detail.getTaxRate() != null) {
         stringBuilder.append(detail.getTaxRate().stripTrailingZeros().toPlainString()).append("%");
      }

      map.put("invoiceType", detail.getInvoiceType() != null ? InvoiceTypeEnum.getValueByType(detail.getInvoiceType()) + stringBuilder : "");
      map.put("transportType", LogisticsTransportTypeEnum.getNameByType(detail.getLogisticsTransportType()));
      map.put(
         "purchaseOrderPaymentMode",
         detail.getPurchaseOrderPaymentMode() != null ? PurchaseOrderModeEnum.getNameByType(detail.getPurchaseOrderPaymentMode()) : ""
      );
      map.put("createUser", detail.getApplicantName());
      float f = 0.0F;
      if (StrUtil.isNotBlank(detail.getProjectIds())) {
         List<Long> projectIds = CommonUtil.spilt(detail.getProjectIds(), ",");
         List<ProjectInfo> projectInfos = projectIds.stream().map(pid -> this.contractProjectService.getSimpleById(pid)).collect(Collectors.toList());
         StringBuilder projectInfo = new StringBuilder();

         for (ProjectInfo info : projectInfos) {
            projectInfo.append(info.getSerialNumber()).append("-").append(info.getShortName()).append("\r\n");
            f += 20.0F;
         }

         map.put("project", projectInfo);
      }

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
      Sheet sheet = workbook.getSheetAt(0);
      Row row = sheet.getRow(7);
      row.setHeightInPoints(f == 0.0F ? 20.0F : f);
      Cell cell = row.getCell(1);
      CellStyle cellStyle = workbook.createCellStyle();
      cellStyle.setWrapText(true);
      cellStyle.setBorderBottom(BorderStyle.THIN);
      cell.setCellStyle(cellStyle);
      PoiUtils.downLoadExcel(exportFileName, response, workbook);
   }

   @Override
   public ListVO<BriefPurchaseOrderDTO> listBrief() {
      List<BriefPurchaseOrderDTO> objectList = this.getBriefPurchaseOrderDTOS(null, 1);
      return new ListVO<>(objectList);
   }

   private List<BriefPurchaseOrderDTO> getBriefPurchaseOrderDTOS(Long id, Integer purchaseStatus) {
      List<PurchaseOrder> purchaseOrders = this.baseMapper
         .selectList(
            (Wrapper<PurchaseOrder>)((Wrappers.<PurchaseOrder>lambdaQuery().eq(id != null, PurchaseOrder::getId, id))
                  .eq(purchaseStatus != null, PurchaseOrder::getPurchaseStatus, purchaseStatus))
               .orderByDesc(BaseEntity::getCreateTime)
         );
      if (CollectionUtil.isEmpty(purchaseOrders)) {
         return new ArrayList<>();
      }

      TreeSet<Long> purchaseIds = new TreeSet<>();
      TreeSet<Long> supplierIds = new TreeSet<>();
      TreeSet<Long> branchCompanyIds = new TreeSet<>();
      TreeSet<Long> applyPurchaseIds = new TreeSet<>();
      TreeSet<Long> projectIds = new TreeSet<>();

      for (PurchaseOrder purchaseOrder : purchaseOrders) {
         purchaseIds.add(purchaseOrder.getId());
         if (ObjectUtil.isNotEmpty(purchaseOrder.getSupplierId())) {
            supplierIds.add(purchaseOrder.getSupplierId());
         }

         if (ObjectUtil.isNotEmpty(purchaseOrder.getBranchCompanyId())) {
            branchCompanyIds.add(purchaseOrder.getBranchCompanyId());
         }

         if (ObjectUtil.isNotEmpty(purchaseOrder.getApplyPurchaseIds())) {
            List<Long> collect = Arrays.stream(purchaseOrder.getApplyPurchaseIds().split(",")).map(Long::valueOf).collect(Collectors.toList());
            applyPurchaseIds.addAll(collect);
         }

         if (ObjectUtil.isNotEmpty(purchaseOrder.getProjectIds())) {
            List<Long> collect = Arrays.stream(purchaseOrder.getProjectIds().split(",")).map(Long::valueOf).collect(Collectors.toList());
            projectIds.addAll(collect);
         }
      }

      Map<Long, Supplier> supplierMap = this.queryUtilService.getSupplierMapByIds(supplierIds);
      Map<Long, ContractProject> projectMap = this.queryUtilService.getProjectMapByIds(projectIds);
      Map<Long, BranchCompany> branchCompanyMap = this.queryUtilService.getBranchCompanyMap(null);
      List<PurchaseOrderDetail> purchaseOrderDetails = this.purchaseOrderDetailMapper
         .selectList((Wrapper<PurchaseOrderDetail>)new LambdaQueryWrapper<PurchaseOrderDetail>().in(PurchaseOrderDetail::getPurchaseId, purchaseIds));
      Map<Long, List<PurchaseOrderDetail>> collect = purchaseOrderDetails.stream().collect(Collectors.groupingBy(PurchaseOrderDetail::getPurchaseId));
      Map<Long, ApplyPurchase> applyPurchaseMap = new HashMap<>();
      Map<Long, ApplyPurchaseDetail> applyPurchaseDetailMap = new HashMap<>();
      if (CollectionUtil.isNotEmpty(applyPurchaseIds)) {
         applyPurchaseMap = this.queryUtilService.getApplyPurchaseMapByIds(applyPurchaseIds);
         List<ApplyPurchaseDetail> applyPurchaseDetails = this.applyPurchaseDetailMapper
            .selectList((Wrapper<ApplyPurchaseDetail>)new LambdaQueryWrapper<ApplyPurchaseDetail>().in(ApplyPurchaseDetail::getApplyPurchaseId, applyPurchaseIds));
         applyPurchaseDetailMap = applyPurchaseDetails.stream().collect(Collectors.toMap(ApplyPurchaseDetail::getId, Function.identity()));
      }

      List<BriefPurchaseOrderDTO> briefPurchaseOrderDTOS = new ArrayList<>();

      for (PurchaseOrder po : purchaseOrders) {
         BriefPurchaseOrderDTO orderDTO = BeanUtil.copy(po, BriefPurchaseOrderDTO.class);
         if (po.getSupplierId() != null) {
            Supplier supplier = supplierMap.get(po.getSupplierId());
            if (supplier != null) {
               orderDTO.setSupplier(BriefIdAndNameDTO.builder().id(supplier.getId()).name(supplier.getName()).build());
            }
         }

         BranchCompany branchCompany = branchCompanyMap.get(po.getBranchCompanyId());
         if (branchCompany != null) {
            orderDTO.setBranchCompany(BriefIdAndNameDTO.builder().id(branchCompany.getId()).name(branchCompany.getName()).build());
         }

         if (StrUtil.isNotBlank(po.getApplyPurchaseIds())) {
            List<Long> ids = CommonUtil.spilt(po.getApplyPurchaseIds(), ",");
            List<BriefIdAndSNDTO> applyPurchases = new ArrayList<>();

            for (Long l : ids) {
               ApplyPurchase applyPurchase = applyPurchaseMap.get(l);
               if (applyPurchase != null) {
                  BriefIdAndSNDTO build = BriefIdAndSNDTO.builder().id(applyPurchase.getId()).serialNumber(applyPurchase.getSerialNumber()).build();
                  applyPurchases.add(build);
               }
            }

            orderDTO.setApplyPurchase(applyPurchases);
         }

         if (StrUtil.isNotBlank(po.getAttachments())) {
            orderDTO.setAttachments(this.attachmentService.listByIds(po.getAttachments()));
         }

         if (StrUtil.isNotBlank(po.getAuxMaterialIds())) {
            orderDTO.setAuxMaterialIds(CommonUtil.spilt(po.getAuxMaterialIds(), ","));
         }

         if (StrUtil.isNotBlank(po.getOtherMaterialIds())) {
            orderDTO.setOtherMaterialIds(CommonUtil.spilt(po.getOtherMaterialIds(), ","));
         }

         if (StrUtil.isNotBlank(po.getProjectIds())) {
            orderDTO.setProjects(this.contractProjectService.listByIds(po.getProjectIds()));
            List<ProjectInfo> projectInfos = new ArrayList<>();
            List<Long> ids = CommonUtil.spilt(po.getProjectIds(), ",");
            ids.forEach(projectId -> {
               ContractProject project = projectMap.get(projectId);
               ProjectInfo copy = BeanUtil.copy(project, ProjectInfo.class);
               projectInfos.add(copy);
            });
            orderDTO.setProjects(projectInfos);
         }

         if (po.getPurchaseType().equals(PurchaseEnum.MATERIAL.getType())) {
            orderDTO.setBoolUsed(
               CollectionUtils.isNotEmpty(this.inboundService.list((Wrapper<Inbound>)Wrappers.<Inbound>lambdaQuery().eq(Inbound::getPurchaseId, orderDTO.getId())))
            );
         } else if (po.getPurchaseType().equals(PurchaseEnum.FINISHED_GOODS.getType())) {
            orderDTO.setBoolUsed(
               CollectionUtils.isNotEmpty(
                  this.inboundManufacturedService
                     .list((Wrapper<InboundManufactured>)Wrappers.<InboundManufactured>lambdaQuery().eq(InboundManufactured::getPurchaseId, orderDTO.getId()))
               )
            );
         } else {
            Preconditions.checkArgument(false, "未知采购材料类型！！！");
         }

         if (po.getWorkshopId() != null) {
            MesBuildingWorkshop mesWorkshop = this.mesWorkshopService.getWorkshopById(po.getWorkshopId());
            orderDTO.setMesWorkshop(IdAndNameDTO.builder().id(mesWorkshop.getId()).name(mesWorkshop.getName()).build());
         }

         orderDTO.setBoolUsed(
            CollectionUtils.isNotEmpty(this.inboundService.list((Wrapper<Inbound>)Wrappers.<Inbound>lambdaQuery().eq(Inbound::getPurchaseId, orderDTO.getId())))
         );
         List<PurchaseOrderDetail> list = collect.get(po.getId());
         List<PurchaseOrderDetailDTO> d = new ArrayList<>();
         BigDecimal quantity = BigDecimal.ZERO;
         BigDecimal mete = BigDecimal.ZERO;
         if (CollectionUtil.isNotEmpty(list)) {
            for (PurchaseOrderDetail l : list) {
               if (l.getArtifactEnclosureId() != null) {
                  d.add(BeanUtil.copy(l, PurchaseOrderDetailDTO.class));
               } else {
                  PurchaseOrderDetailDTO dto = BeanUtil.copy(l, PurchaseOrderDetailDTO.class);
                  quantity = l.getInboundQuantity().add(quantity);
                  mete = l.getInboundMete().add(mete);
                  if (l.getApplyPurchaseDetailId() != null) {
                     ApplyPurchaseDetail purchaseDetail = applyPurchaseDetailMap.get(l.getApplyPurchaseDetailId());
                     if (purchaseDetail != null) {
                        dto.setApplyPurchaseMete(purchaseDetail.getMete());
                        dto.setApplyPurchaseQuantity(purchaseDetail.getQuantity());
                     }
                  }

                  d.add(dto);
               }
            }
         }

         orderDTO.setInboundTotalMete(mete);
         orderDTO.setInboundTotalQuantity(quantity);
         orderDTO.setDetails(d);
         briefPurchaseOrderDTOS.add(orderDTO);
      }

      return briefPurchaseOrderDTOS;
   }

   @Override
   public ListVO<BriefPurchaseOrderNewDTO> listBriefV2(
      Boolean BoolAnnual, Long supplierId, Integer level, Integer dataStatus, List<Integer> projectAttribute, Long workshopId, Integer orderPlace
   ) {
      List<BriefPurchaseOrderNewDTO> objectList = this.getBriefPurchaseOrderDTOSV2(
         BoolAnnual, null, PurchaseStatusEnum.DURING.getType(), supplierId, level, dataStatus, projectAttribute, workshopId, orderPlace
      );
      return new ListVO<>(objectList);
   }

   private List<BriefPurchaseOrderNewDTO> getBriefPurchaseOrderDTOSV2(
      Boolean boolAnnual,
      Long id,
      Integer purchaseStatus,
      Long supplierId,
      Integer level,
      Integer dataStatus,
      List<Integer> projectAttribute,
      Long workshopId,
      Integer orderPlace
   ) {
      return this.baseMapper
         .selectList(
            (Wrapper<PurchaseOrder>)(((((((((Wrappers.<PurchaseOrder>lambdaQuery()
                                          .eq(boolAnnual != null, PurchaseOrder::getBoolAnnual, boolAnnual))
                                       .eq(id != null, PurchaseOrder::getId, id))
                                    .eq(purchaseStatus != null, PurchaseOrder::getPurchaseStatus, purchaseStatus))
                                 .eq(supplierId != null, PurchaseOrder::getSupplierId, supplierId))
                              .eq(level != null, PurchaseOrder::getLevel, level))
                           .eq(orderPlace != null, PurchaseOrder::getOrderPlace, orderPlace))
                        .eq(dataStatus != null, PurchaseOrder::getDataStatus, dataStatus))
                     .eq(workshopId != null, PurchaseOrder::getWorkshopId, workshopId))
                  .in(projectAttribute != null, PurchaseOrder::getProjectAttribute, projectAttribute))
               .orderByDesc(BaseEntity::getCreateTime)
         )
         .stream()
         .map(
            po -> {
               BriefPurchaseOrderNewDTO orderDTO = BeanUtil.copy(po, BriefPurchaseOrderNewDTO.class);
               if (po.getSupplierId() != null) {
                  Supplier supplier = this.supplierService.getById(po.getSupplierId());
                  orderDTO.setSupplier(BriefIdAndNameDTO.builder().id(supplier.getId()).name(supplier.getName()).build());
               }

               BranchCompany branchCompany = this.branchCompanyService.getById(po.getBranchCompanyId());
               orderDTO.setBranchCompany(BriefIdAndNameDTO.builder().id(branchCompany.getId()).name(branchCompany.getName()).build());
               if (StrUtil.isNotBlank(po.getApplyPurchaseIds())) {
                  List<Long> ids = CommonUtil.spilt(po.getApplyPurchaseIds(), ",");
                  orderDTO.setApplyPurchase(
                     this.applyPurchaseService
                        .listByIds(ids)
                        .stream()
                        .map(l -> BriefIdAndSNDTO.builder().id(l.getId()).serialNumber(l.getSerialNumber()).build())
                        .collect(Collectors.toList())
                  );
               }

               if (StrUtil.isNotBlank(po.getAuxMaterialIds())) {
                  orderDTO.setAuxMaterialIds(CommonUtil.spilt(po.getAuxMaterialIds(), ","));
               }

               if (StrUtil.isNotBlank(po.getOtherMaterialIds())) {
                  orderDTO.setOtherMaterialIds(CommonUtil.spilt(po.getOtherMaterialIds(), ","));
               }

               if (StrUtil.isNotBlank(po.getProjectIds())) {
                  orderDTO.setProjects(this.contractProjectService.listByIds(po.getProjectIds()));
               }

               orderDTO.setBoolAnnual(po.getBoolAnnual());
               List<Integer> status = new ArrayList<>();
               status.add(ReviewStatusEnum.AUDITING.getType());
               status.add(ReviewStatusEnum.REVIEWED.getType());
               BigDecimal quantity = new BigDecimal(0);
               BigDecimal mete = new BigDecimal(0);
               if (po.getPurchaseType().equals(PurchaseEnum.MATERIAL.getType())) {
                  QuantityMeteDTO countMete = this.inboundDetailService.getCountMete(po.getId(), status);
                  quantity = countMete.getQuantity();
                  mete = countMete.getMete();
               } else if (po.getPurchaseType().equals(PurchaseEnum.FINISHED_GOODS.getType())) {
                  QuantityMeteDTO countMete = this.inboundDetailManufacturedService.getCountMete(po.getId(), status);
                  quantity = countMete.getQuantity();
               } else {
                  Preconditions.checkArgument(false, "未知采购材料类型！！！");
               }

               orderDTO.setInboundTotalMete(mete);
               orderDTO.setInboundTotalQuantity(quantity);
               return orderDTO;
            }
         )
         .collect(Collectors.toList());
   }

   @Override
   public BriefPurchaseOrderDTO selectById(Long id) {
      return this.getBriefPurchaseOrderDTOS(id, null).get(0);
   }

   @Override
   public List<SupplierPaymentRecordDTO> listByCondition(
      LocalDate startDate,
      LocalDate endDate,
      Integer basicClass,
      Integer purchaseType,
      Long supplierId,
      String supplierName,
      String serialNumber,
      Long projectId,
      Integer settlementStatus
   ) {
      return this.baseMapper.listByCondition(startDate, endDate, basicClass, purchaseType, supplierId, supplierName, serialNumber, projectId, settlementStatus);
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean save(PurchaseOrderDTOParam dtoParam) {
      if (CollectionUtil.isNotEmpty(dtoParam.getApplyPurchaseIds())) {
         int updateCount = this.applyPurchaseService
            .count(
               (Wrapper<ApplyPurchase>)(Wrappers.<ApplyPurchase>lambdaQuery().in(ApplyPurchase::getId, dtoParam.getApplyPurchaseIds()))
                  .ge(BaseEntity::getUpdateTime, dtoParam.getClickAddTime())
            );
         Preconditions.checkArgument(updateCount == 0, "申购内容有变化，请关闭当前页面重新创建采购订单");
      }

      PurchaseOrder purchaseOrder = PurchaseOrder.builder().settlementStatus(SettlementStatusEnum.UN_SETTLED.getType()).build();
      this.checkSelfParam(dtoParam);
      BeanUtil.copy(dtoParam, purchaseOrder);
      if (InvoiceTypeEnum.RECEIPT.getType().equals(dtoParam.getInvoiceType())) {
         purchaseOrder.setTaxRate(null);
      }

      if (StrUtil.isBlank(dtoParam.getSerialNumber())) {
         int count = this.baseMapper.getCountByDate() + 1;
         Supplier supplier = this.supplierService.getById(purchaseOrder.getSupplierId());
         Preconditions.checkArgument(supplier != null, "新增失败,供应商不存在");
         String serialNumber = supplier.getShortName()
            + "-"
            + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"))
            + "-"
            + (count < 10 ? "0" + count : count + "");
         purchaseOrder.setSerialNumber(serialNumber);
      } else {
         Preconditions.checkArgument(
            CollectionUtil.isEmpty(
               this.baseMapper.selectList((Wrapper<PurchaseOrder>)Wrappers.<PurchaseOrder>lambdaQuery().eq(PurchaseOrder::getSerialNumber, dtoParam.getSerialNumber()))
            ),
            "添加失败,订单号[" + dtoParam.getSerialNumber() + "]已存在."
         );
         purchaseOrder.setSerialNumber(dtoParam.getSerialNumber());
      }

      SecurityUser currentUser = UserUtil.getCurrentUser();
      purchaseOrder.setPurchaseStatus(1);
      purchaseOrder.setBranchCompanyId(dtoParam.getBranchCompanyId());
      purchaseOrder.setApplicantId(currentUser.getId());
      purchaseOrder.setApplicantName(currentUser.getName());
      purchaseOrder.setLastOperatorNameId(currentUser.getId());
      purchaseOrder.setLastOperatorName(currentUser.getName());
      purchaseOrder.setUserUpdateTime(LocalDateTime.now());
      purchaseOrder.setProjectIds(StrUtil.join(",", dtoParam.getProjectIds()));
      this.listChangeStrV2(dtoParam, purchaseOrder);
      int insert = this.baseMapper.insert(purchaseOrder);
      this.saveDetail(dtoParam, purchaseOrder);
      this.classificationService.updateClassifyUsed(IdsStatusDTO.builder().idsStr(purchaseOrder.getClassifyIds()).build());
      this.sysPushFlowConfigBiz
         .triggerFlow(
            NotificationServiceTriggerDTO.builder()
               .createUserId(UserUtil.getCurrentUserId())
               .contentDetails(
                  this.detailsUtils
                     .getPurchaseOrderDetails(
                        dtoParam.getSerialNumber(), dtoParam.getAmount(), this.supplierService.getById(dtoParam.getSupplierId()).getName()
                     )
               )
               .notificationTypeEnum(NotificationModuleTypeEnum.PURCHASE.getNotificationType())
               .userList(new ArrayList<>())
               .build()
         );
      return this.baseMapper.updateById(purchaseOrder) == 1;
   }

   private void saveDetail(PurchaseOrderDTOParam dtoParam, PurchaseOrder purchaseOrder) {
      List<Long> projectIds = new ArrayList<>();
      List<String> SN = new ArrayList<>();
      List<String> checkDetail = new ArrayList<>();
      if (CollectionUtil.isNotEmpty(dtoParam.getList())) {
         List<String> classifyIds = new ArrayList<>();
         List<ClassificationCheckDTO> classificationCheckDTOS = dtoParam.getList()
            .stream()
            .map(d -> cn.hutool.core.bean.BeanUtil.toBean(d, ClassificationCheckDTO.class))
            .collect(Collectors.toList());
         Map<Long, Classification> classificationMap = this.classificationService.checkClassification(classificationCheckDTOS, dtoParam.getClickTime());

         for (PurchaseOrderDetailDTOParam detailParam : dtoParam.getList()) {
            classifyIds.add(detailParam.getClassifyId().toString());
            PurchaseOrderDetail productDetail = BeanUtil.copy(detailParam, PurchaseOrderDetail.class, "createTime");
            productDetail.setPurchaseId(purchaseOrder.getId());
            String uniqueIdentification = this.creatUniqueIdentification(purchaseOrder.getId(), purchaseOrder.getSerialNumber(), detailParam.getBasicClass());
            productDetail.setUniqueIdentification(uniqueIdentification);
            if (detailParam.getApplyPurchaseId() != null) {
               ApplyPurchase applyPurchase = this.applyPurchaseService
                  .updatePurchaseStatus(detailParam.getApplyPurchaseId(), detailParam.getApplyPurchaseDetailId(), productDetail);
               if (applyPurchase.getProjectId() != null && !projectIds.contains(applyPurchase.getProjectId())) {
                  projectIds.add(applyPurchase.getProjectId());
               }

               if (!SN.contains(applyPurchase.getSerialNumber())) {
                  String s = purchaseOrder.getApplyPurchaseIds();
                  purchaseOrder.setApplyPurchaseIds(s != null ? s + "," + applyPurchase.getId() : applyPurchase.getId() + "");
                  SN.add(applyPurchase.getSerialNumber());
               }
            } else {
               if (CollectionUtils.isNotEmpty(dtoParam.getProjectIds())) {
                  projectIds.addAll(dtoParam.getProjectIds());
               }

               String s = detailParam.getClassifyId()
                  + detailParam.getSpecification()
                  + (detailParam.getLength() != null ? detailParam.getLength() : "-")
                  + (detailParam.getWidth() != null ? detailParam.getWidth() : "-")
                  + (detailParam.getThickness() != null ? detailParam.getThickness() : "-")
                  + detailParam.getUnitPrice()
                  + (detailParam.getBrand() != null ? detailParam.getBrand() : "-");
               Preconditions.checkArgument(!checkDetail.contains(s), "新增失败,请勿添加相同物料");
               checkDetail.add(s);
            }

            if (InvoiceTypeEnum.SPECIAL.getType().equals(purchaseOrder.getInvoiceType())) {
               BigDecimal value = purchaseOrder.getTaxRate().divide(BigDecimal.valueOf(100L)).add(BigDecimal.ONE);
               productDetail.setAmountExcludingVat(productDetail.getAmount().divide(value, 2, 4));
               productDetail.setUnitPriceExcludingVat(
                  productDetail.getAmountExcludingVat()
                     .divide(detailParam.getArtifactEnclosureId() != null ? detailParam.getQuantity() : detailParam.getMete(), 12, 4)
               );
               productDetail.setInputVat(productDetail.getAmount().subtract(productDetail.getAmountExcludingVat()));
            } else {
               productDetail.setAmountExcludingVat(detailParam.getAmount());
               productDetail.setUnitPriceExcludingVat(detailParam.getUnitPrice());
            }

            this.purchaseOrderDetailMapper.insert(productDetail);
         }

         if (CollectionUtils.isNotEmpty(classifyIds)) {
            classifyIds = classifyIds.stream().distinct().collect(Collectors.toList());
            purchaseOrder.setClassifyIds(StringUtils.list2String(classifyIds, ","));
         }
      }

      if (CollectionUtils.isNotEmpty(SN)) {
         purchaseOrder.setApplyPurchaseSN(StrUtil.join(",", SN));
      }

      if (CollectionUtils.isNotEmpty(projectIds)) {
         ArrayList<Long> distinct = CollectionUtil.distinct(projectIds);
         purchaseOrder.setProjectIds(StrUtil.join(",", distinct));
      }
   }

   private void checkSelfParam(PurchaseOrderDTOParam dtoParam) {
      if (!dtoParam.getBoolTemporaryStorage()) {
         Preconditions.checkArgument(dtoParam.getSupplierId() != null, "请选择供应商");
      }

      Preconditions.checkArgument(dtoParam.getInvoiceType() != null && InvoiceTypeEnum.isExist(dtoParam.getInvoiceType()), "请输入正确发票类型");
      if (!dtoParam.getBoolTemporaryStorage()
         && (dtoParam.getInvoiceType().equals(InvoiceTypeEnum.SPECIAL.getType()) || dtoParam.getInvoiceType().equals(InvoiceTypeEnum.ORDINARY.getType()))) {
         Preconditions.checkArgument(dtoParam.getTaxRate() != null, "稅率不可为空！！！");
         Preconditions.checkArgument(dtoParam.getTaxRate().compareTo(BigDecimal.ZERO) >= 0, "税率需大于等于0");
      }
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean updatePurchaseOrder(PurchaseOrderDTOParam dtoParam) {
      Preconditions.checkArgument(dtoParam.getId() != null, "订单ID不能为空");
      PurchaseOrder purchaseOrder = this.baseMapper.selectById(dtoParam.getId());
      Preconditions.checkArgument(purchaseOrder != null, "采购单不存在");
      if (CollectionUtil.isNotEmpty(dtoParam.getApplyPurchaseIds())) {
         int updateCount = this.applyPurchaseService
            .count(
               (Wrapper<ApplyPurchase>)(Wrappers.<ApplyPurchase>lambdaQuery().in(ApplyPurchase::getId, dtoParam.getApplyPurchaseIds()))
                  .ge(BaseEntity::getUpdateTime, dtoParam.getClickAddTime())
            );
         Preconditions.checkArgument(updateCount == 0, "申购内容有变化，请关闭当前页面重新创建采购订单");
      }

      if (StrUtil.isNotBlank(purchaseOrder.getApplyPurchaseIds()) && !dtoParam.isBoolUsed()) {
         this.updateApplyPurchaseStatus(purchaseOrder);
      }

      if (!purchaseOrder.getSerialNumber().equals(dtoParam.getSerialNumber())) {
         Preconditions.checkArgument(
            CollectionUtils.isEmpty(
               this.baseMapper.selectList((Wrapper<PurchaseOrder>)Wrappers.<PurchaseOrder>lambdaQuery().eq(PurchaseOrder::getSerialNumber, dtoParam.getSerialNumber()))
            ),
            "当前采购订单号已存在"
         );
         purchaseOrder.setSerialNumber(dtoParam.getSerialNumber());
      }

      this.checkSelfParam(dtoParam);
      BeanUtil.copy(dtoParam, purchaseOrder);
      this.listChangeStr(dtoParam, purchaseOrder);
      SecurityUser currentUser = UserUtil.getCurrentUser();
      purchaseOrder.setLastOperatorNameId(currentUser.getId());
      purchaseOrder.setLastOperatorName(currentUser.getName());
      purchaseOrder.setAuxMaterialIds(StrUtil.join(",", dtoParam.getAuxMaterialIds()));
      purchaseOrder.setOtherMaterialIds(StrUtil.join(",", dtoParam.getOtherMaterialIds()));
      purchaseOrder.setUserUpdateTime(LocalDateTime.now());
      purchaseOrder.setBranchCompanyId(dtoParam.getBranchCompanyId());
      purchaseOrder.setProjectIds(StrUtil.join(",", dtoParam.getProjectIds()));
      Boolean boolExistInbound = false;
      if (dtoParam.getPurchaseType().equals(PurchaseEnum.MATERIAL.getType())) {
         boolExistInbound = CollectionUtils.isNotEmpty(
            this.inboundService.list((Wrapper<Inbound>)Wrappers.<Inbound>lambdaQuery().eq(Inbound::getPurchaseId, dtoParam.getId()))
         );
      } else if (purchaseOrder.getPurchaseType().equals(PurchaseEnum.FINISHED_GOODS.getType())) {
         boolExistInbound = CollectionUtils.isNotEmpty(
            this.inboundManufacturedService.list((Wrapper<InboundManufactured>)Wrappers.<InboundManufactured>lambdaQuery().eq(InboundManufactured::getPurchaseId, dtoParam.getId()))
         );
      } else {
         Preconditions.checkArgument(false, "未知采购材料类型！！！");
      }

      if (!boolExistInbound) {
         IdsStatusDTO idsStatusDTO = new IdsStatusDTO();
         if (ObjectUtil.isNotEmpty(purchaseOrder.getClassifyIds())) {
            idsStatusDTO.setIdsStr(purchaseOrder.getClassifyIds());
         } else {
            List<PurchaseOrderDetail> purchaseOrderDetails = this.purchaseOrderDetailMapper
               .selectList((Wrapper<PurchaseOrderDetail>)Wrappers.<PurchaseOrderDetail>lambdaQuery().eq(PurchaseOrderDetail::getPurchaseId, purchaseOrder.getId()));
            List<Long> classifyIds = purchaseOrderDetails.stream().map(PurchaseOrderDetail::getClassifyId).collect(Collectors.toList());
            idsStatusDTO.setIds(classifyIds);
         }

         this.purchaseOrderDetailMapper
            .delete((Wrapper<PurchaseOrderDetail>)Wrappers.<PurchaseOrderDetail>lambdaQuery().eq(PurchaseOrderDetail::getPurchaseId, purchaseOrder.getId()));
         this.classificationService.deleteDataUpdateClass(idsStatusDTO);
         this.saveDetail(dtoParam, purchaseOrder);
         this.classificationService.updateClassifyUsed(IdsStatusDTO.builder().idsStr(purchaseOrder.getClassifyIds()).build());
      }

      return this.baseMapper.updateById(purchaseOrder) == 1;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean deletePurchaseOrder(List<Long> ids) {
      for (Long id : ids) {
         PurchaseOrder purchaseOrder = this.baseMapper.selectById(id);
         Preconditions.checkArgument(purchaseOrder != null, "采购订单不存在");
         if (purchaseOrder.getPurchaseType().equals(PurchaseEnum.MATERIAL.getType())) {
            Preconditions.checkArgument(
               this.inboundService.count((Wrapper<Inbound>)Wrappers.<Inbound>lambdaQuery().eq(Inbound::getPurchaseId, id)) == 0, "当前采购单存在入库,禁止删除！！！"
            );
         } else if (purchaseOrder.getPurchaseType().equals(PurchaseEnum.FINISHED_GOODS.getType())) {
            Preconditions.checkArgument(
               this.inboundManufacturedService.count((Wrapper<InboundManufactured>)Wrappers.<InboundManufactured>lambdaQuery().eq(InboundManufactured::getPurchaseId, id)) == 0,
               "当前采购单存在入库,禁止删除！！！"
            );
         } else {
            Preconditions.checkArgument(false, "未知采购材料类型！！！");
         }

         Preconditions.checkArgument(SettlementStatusEnum.UN_SETTLED.getType().equals(purchaseOrder.getSettlementStatus()), "删除失败,当前采购订单已结算.");
         Preconditions.checkArgument(PurchaseStatusEnum.DURING.getType().equals(purchaseOrder.getPurchaseStatus()), "删除失败,当前采购订单已采购完成.");
         int count = this.supplierPaymentService
            .count(
               Wrappers.lambdaQuery(SupplierPayment.class)
                  .eq(SupplierPayment::getOrderId, id)
                  .eq(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType())
            );
         Preconditions.checkArgument(count == 0, "订单删除失败,已存在该订单付款记录");
         count = this.supplierPaymentDetailService
            .count(
               Wrappers.lambdaQuery(SupplierPaymentDetail.class)
                  .eq(SupplierPaymentDetail::getPurchaseId, id)
                  .eq(SupplierPaymentDetail::getType, SupplierPaymentInvoiceDetailTypeEnum.MATERIALS_PURCHASE.getType())
            );
         Preconditions.checkArgument(count == 0, "订单删除失败,已存在该订单物流付款记录");
         count = this.supplierInvoiceService
            .count(
               Wrappers.lambdaQuery(SupplierInvoice.class)
                  .eq(SupplierInvoice::getPropertyType, SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType())
                  .eq(SupplierInvoice::getOrderId, id)
            );
         Preconditions.checkArgument(count == 0, "订单删除失败,已存在该订单开票记录");
         if (StrUtil.isNotBlank(purchaseOrder.getApplyPurchaseIds())) {
            this.updateApplyPurchaseStatus(purchaseOrder);
         }

         IdsStatusDTO idsStatusDTO = new IdsStatusDTO();
         if (ObjectUtil.isNotEmpty(purchaseOrder.getClassifyIds())) {
            idsStatusDTO.setIdsStr(purchaseOrder.getClassifyIds());
         } else {
            List<PurchaseOrderDetail> purchaseOrderDetails = this.purchaseOrderDetailMapper
               .selectList((Wrapper<PurchaseOrderDetail>)Wrappers.<PurchaseOrderDetail>lambdaQuery().eq(PurchaseOrderDetail::getPurchaseId, purchaseOrder.getId()));
            List<Long> classifyIds = purchaseOrderDetails.stream().map(PurchaseOrderDetail::getClassifyId).collect(Collectors.toList());
            idsStatusDTO.setIds(classifyIds);
         }

         this.purchaseOrderDetailMapper
            .delete((Wrapper<PurchaseOrderDetail>)Wrappers.<PurchaseOrderDetail>lambdaQuery().eq(PurchaseOrderDetail::getPurchaseId, purchaseOrder.getId()));
         this.classificationService.deleteDataUpdateClass(idsStatusDTO);
         this.baseMapper.deleteById(id);
      }

      return true;
   }

   private void updateApplyPurchaseStatus(PurchaseOrder purchaseOrder) {
      for (PurchaseOrderDetail detail : this.purchaseOrderDetailMapper
         .selectList(
            (Wrapper<PurchaseOrderDetail>)(Wrappers.<PurchaseOrderDetail>lambdaQuery().eq(PurchaseOrderDetail::getPurchaseId, purchaseOrder.getId()))
               .isNotNull(PurchaseOrderDetail::getApplyPurchaseDetailId)
         )) {
         this.applyPurchaseDetailMapper.updateStatus(detail.getApplyPurchaseDetailId(), detail.getMete(), detail.getQuantity(), false);
      }

      for (Long aId : CommonUtil.spilt(purchaseOrder.getApplyPurchaseIds(), ",")) {
         ApplyPurchase applyPurchase = this.applyPurchaseService.getById(aId);
         long count = this.applyPurchaseDetailMapper
            .selectList((Wrapper<ApplyPurchaseDetail>)Wrappers.<ApplyPurchaseDetail>lambdaQuery().eq(ApplyPurchaseDetail::getApplyPurchaseId, applyPurchase.getId()))
            .stream()
            .filter(ApplyPurchaseDetail::getBoolPurchase)
            .count();
         applyPurchase.setPurchaseCreationState(count > 0L ? ApplyPurchaseStateEnum.PARTIAL_CREATED.getType() : ApplyPurchaseStateEnum.NOT_STARTED.getType());
         this.applyPurchaseService.updateById(applyPurchase);
      }
   }

   private void listChangeStr(PurchaseOrderDTOParam dtoParam, PurchaseOrder purchaseOrder) {
      purchaseOrder.setAuxMaterialIds(CollectionUtil.isNotEmpty(dtoParam.getAuxMaterialIds()) ? StrUtil.join(",", dtoParam.getAuxMaterialIds()) : null);
      purchaseOrder.setOtherMaterialIds(CollectionUtil.isNotEmpty(dtoParam.getOtherMaterialIds()) ? StrUtil.join(",", dtoParam.getOtherMaterialIds()) : null);
      purchaseOrder.setAttachments(CollectionUtil.isNotEmpty(dtoParam.getAttachmentIds()) ? StrUtil.join(",", dtoParam.getAttachmentIds()) : null);
   }

   private void listChangeStrV2(PurchaseOrderDTOParam dtoParam, PurchaseOrder purchaseOrder) {
      purchaseOrder.setAuxMaterialIds(CollectionUtil.isNotEmpty(dtoParam.getAuxMaterialIds()) ? StrUtil.join(",", dtoParam.getAuxMaterialIds()) : null);
      purchaseOrder.setOtherMaterialIds(CollectionUtil.isNotEmpty(dtoParam.getOtherMaterialIds()) ? StrUtil.join(",", dtoParam.getOtherMaterialIds()) : null);
      purchaseOrder.setGasMaterialIds(CollectionUtil.isNotEmpty(dtoParam.getGasMaterialIds()) ? StrUtil.join(",", dtoParam.getGasMaterialIds()) : null);
      purchaseOrder.setAttachments(CollectionUtil.isNotEmpty(dtoParam.getAttachmentIds()) ? StrUtil.join(",", dtoParam.getAttachmentIds()) : null);
   }

   @Override
   public List<PurchaseSupplierSummaryDTO> listBySupplierSum(String supplierName, LocalDate startDate, LocalDate endDate) {
      return this.baseMapper.listSupplierSum(supplierName, startDate, endDate);
   }

   @Override
   public List<PurchaseOrder> listByProjectId(Long projectId) {
      return this.baseMapper.selectByProjectId(projectId);
   }

   @Override
   public BigDecimal getPurchaseAmountSum(LocalDate startDate, LocalDate endDate, Long supplierId, Long branchCompanyId, Integer purchaseType) {
      return this.baseMapper.selectPurchaseAmountSum(startDate, endDate, supplierId, branchCompanyId, purchaseType);
   }

   @Override
   public int getCount(Long classId) {
      return this.baseMapper.getCountByClassId(classId);
   }

   @Override
   public Map<String, Object> getStatistics() {
      BigDecimal contractAmount = BigDecimal.ZERO;
      int progressOrder = 0;
      int settlementOrder = 0;
      BigDecimal purchaseAmount = BigDecimal.ZERO;
      List<PurchaseOrder> purchaseOrders = this.baseMapper.selectList(null);

      for (PurchaseOrder order : purchaseOrders) {
         if (SettlementStatusEnum.SETTLED.getType().equals(order.getSettlementStatus())) {
            settlementOrder++;
         }

         if (PurchaseStatusEnum.DURING.getType().equals(order.getPurchaseStatus())) {
            progressOrder++;
         }

         contractAmount = order.getAmount().add(contractAmount);
         if (order.getPurchaseType().equals(PurchaseEnum.MATERIAL.getType())) {
            purchaseAmount = this.inboundService.getAmount(order.getId()).get("amount").add(purchaseAmount);
         } else if (order.getPurchaseType().equals(PurchaseEnum.FINISHED_GOODS.getType())) {
            List<InboundManufactured> list = this.inboundManufacturedService
               .list(
                  (Wrapper<InboundManufactured>)(new LambdaQueryWrapper<InboundManufactured>().eq(InboundManufactured::getPurchaseId, order.getId()))
                     .eq(InboundManufactured::getReviewStatus, ReviewStatusEnum.REVIEWED.getType())
               );
            if (CollectionUtil.isNotEmpty(list)) {
               BigDecimal reduce = list.stream().map(InboundManufactured::getAmount).filter(ObjectUtil::isNotEmpty).reduce(BigDecimal.ZERO, BigDecimal::add);
               purchaseAmount = reduce.add(purchaseAmount);
            }
         } else {
            Preconditions.checkArgument(false, "未知采购材料类型！！！");
         }
      }

      Map<String, Object> map = new HashMap<>();
      map.put("contractAmount", contractAmount);
      map.put("orderTotalQuantity", purchaseOrders.size());
      map.put("purchaseAmount", purchaseAmount);
      map.put("processingOrder", progressOrder);
      map.put("settlementOrder", settlementOrder);
      return map;
   }

   @Override
   public ListVO<PurchaseOrderDTO> getSNByYear(LocalDateTime year) {
      return new ListVO<>(this.baseMapper.getSNByYear(year));
   }

   @Override
   public ListVO getStructureClass(Long projectId, Long monomerId, Long areaId) {
      return new ListVO<>(this.artifactService.getStructureClass(projectId, monomerId, areaId));
   }

   @Override
   public PageVO getArtifactEnclosureDetail(
      Long projectId, Long monomerId, Long structureClassId, Integer type, Long areaId, Integer pageNumber, Integer pageSize
   ) {
      Page<PurchaseOrder> page = PageHelper.startPage(pageNumber, pageSize);
      return new PageVO<>(page, this.artifactService.listByCondition(projectId, monomerId, structureClassId, areaId));
   }

   @Override
   public ListVO<PurchaseOrderDetailDTO> canInboundDetail(Long id) {
      List<PurchaseOrderDetail> details = this.purchaseOrderDetailMapper
         .selectList((Wrapper<PurchaseOrderDetail>)Wrappers.<PurchaseOrderDetail>lambdaQuery().eq(PurchaseOrderDetail::getPurchaseId, id));
      List<PurchaseOrderDetailDTO> list = new ArrayList<>();
      Map<String, PurchaseOrderDetailDTO> map = new HashMap<>();
      Map<String, List<BriefIdAndSNDTO>> appPurchaseMap = new HashMap<>();

      for (PurchaseOrderDetail detail : details) {
         ApplyPurchaseDTO applyPurchaseDTO = null;
         if (detail.getApplyPurchaseId() != null) {
            applyPurchaseDTO = this.applyPurchaseService.selectById(detail.getApplyPurchaseId());
            if (ObjectUtil.isEmpty(detail.getArtifactEnclosureId())) {
               applyPurchaseDTO.setInboundList(
                  this.inboundDetailService
                     .getListByApplyPurchaseId(detail.getApplyPurchaseId())
                     .stream()
                     .filter(l -> l.getPurchaseOrderDetailId().equals(detail.getId()) && l.getMete().subtract(l.getRejectMete()).compareTo(BigDecimal.ZERO) > 0)
                     .map(l -> {
                        ApplyPurchaseDetailDTO copyx = BeanUtil.copy(l, ApplyPurchaseDetailDTO.class);
                        if (l.getRejectMete() != null) {
                           copyx.setMete(copyx.getMete().subtract(l.getRejectMete()));
                           if (l.getQuantity() != null) {
                              copyx.setQuantity(copyx.getQuantity().subtract(l.getRejectQuantity()));
                           }
                        }

                        return copyx;
                     })
                     .collect(Collectors.toList())
               );
            } else {
               applyPurchaseDTO.setInboundList(
                  this.inboundDetailManufacturedService
                     .getListByApplyPurchaseId(detail.getApplyPurchaseId())
                     .stream()
                     .map(l -> BeanUtil.copy(l, ApplyPurchaseDetailDTO.class))
                     .collect(Collectors.toList())
               );
            }
         }

         if (detail.getArtifactEnclosureId() != null) {
            ArtifactDTO artifactDTO = this.artifactService.getInfoById(detail.getArtifactEnclosureId(), 1);
            PurchaseOrderDetailDTO dto = BeanUtil.copy(artifactDTO, PurchaseOrderDetailDTO.class);
            dto.setId(detail.getId());
            dto.setInboundQuantity(detail.getInboundQuantity());
            dto.setInboundMete(detail.getInboundMete());
            dto.setBasicClass(detail.getBasicClass());
            dto.setQuantity(detail.getQuantity());
            dto.setAmount(detail.getAmount());
            dto.setUnitPrice(detail.getUnitPrice());
            dto.setArtifactEnclosureId(detail.getArtifactEnclosureId());
            list.add(dto);
         } else if (applyPurchaseDTO == null) {
            list.add(BeanUtil.copy(detail, PurchaseOrderDetailDTO.class));
         } else {
            StringBuilder sb = new StringBuilder()
               .append(detail.getClassifyId())
               .append(detail.getBrand() != null ? detail.getBrand() : "-")
               .append(detail.getUnitPrice().stripTrailingZeros().toPlainString());
            String s;
            if (BasicClassEnum.checkIsSteel(detail.getBasicClass())) {
               s = sb.append(detail.getSpecification())
                  .append(detail.getThickness() != null ? detail.getThickness() : "-")
                  .append(detail.getLength() != null ? detail.getLength() : "-")
                  .append(detail.getWidth() != null ? detail.getWidth() : "-")
                  .toString();
            } else {
               s = sb.append(detail.getSpecification() != null ? detail.getSpecification() : "-").toString();
            }

            PurchaseOrderDetailDTO dto = map.get(s);
            if (dto != null) {
               List<BriefIdAndSNDTO> idMap = dto.getApplyPurchase();
               idMap.add(
                  BriefIdAndSNDTO.builder()
                     .id(detail.getApplyPurchaseId())
                     .purchaseDetailId(detail.getId())
                     .serialNumber(applyPurchaseDTO.getSerialNumber())
                     .mete(detail.getMete())
                     .quantity(detail.getQuantity())
                     .project(applyPurchaseDTO.getProject())
                     .inboundQuantity(detail.getInboundQuantity())
                     .inboundMete(detail.getInboundMete())
                     .build()
               );
               if (dto.getQuantity() != null) {
                  dto.setQuantity(dto.getQuantity().add(detail.getQuantity()));
               }

               dto.setMete(dto.getMete().add(detail.getMete()));
               dto.setInboundMete(dto.getInboundMete().add(detail.getInboundMete()));
               dto.setInboundQuantity(dto.getInboundQuantity().add(detail.getInboundQuantity()));
               List<ApplyPurchaseDetailDTO> inboundList = applyPurchaseDTO.getInboundList();
               if (CollectionUtil.isNotEmpty(inboundList)) {
                  List<ApplyPurchaseDetailDTO> inbound = dto.getInboundList();
                  if (CollectionUtil.isNotEmpty(inbound)) {
                     inbound.addAll(inboundList);
                  }
               }
            } else {
               PurchaseOrderDetailDTO copy = BeanUtil.copy(detail, PurchaseOrderDetailDTO.class);
               List<BriefIdAndSNDTO> m = new ArrayList<>();
               m.add(
                  BriefIdAndSNDTO.builder()
                     .id(detail.getApplyPurchaseId())
                     .purchaseDetailId(detail.getId())
                     .serialNumber(applyPurchaseDTO.getSerialNumber())
                     .mete(detail.getMete())
                     .quantity(detail.getQuantity())
                     .project(applyPurchaseDTO.getProject())
                     .inboundQuantity(detail.getInboundQuantity())
                     .inboundMete(detail.getInboundMete())
                     .build()
               );
               copy.setApplyPurchase(m);
               List<ApplyPurchaseDetailDTO> inbound = applyPurchaseDTO.getInboundList();
               if (CollectionUtil.isNotEmpty(inbound)) {
                  copy.setInboundList(inbound);
               }

               map.put(s, copy);
            }
         }
      }

      if (CollectionUtils.isNotEmpty(appPurchaseMap)) {
         for (String k : appPurchaseMap.keySet()) {
            PurchaseOrderDetailDTO detailDTO = map.get(k);
            detailDTO.setApplyPurchase(appPurchaseMap.get(k));
         }
      }

      return new ListVO<>(CollectionUtils.isNotEmpty(list) ? list : new ArrayList<>(map.values()));
   }

   @Override
   public ListVO<PurchaseOrderDetailDTO> canInboundDetailV2(Long id) {
      List<PurchaseOrderDetail> details = this.purchaseOrderDetailMapper
         .selectList((Wrapper<PurchaseOrderDetail>)Wrappers.<PurchaseOrderDetail>lambdaQuery().eq(PurchaseOrderDetail::getPurchaseId, id));
      if (CollectionUtil.isEmpty(details)) {
         return new ListVO<>();
      }

      List<PurchaseOrderDetailDTO> list = new ArrayList<>();
      Map<String, PurchaseOrderDetailDTO> map = new HashMap<>();
      Map<String, List<BriefIdAndSNDTO>> appPurchaseMap = new HashMap<>();
      List<Long> projectIds = new ArrayList<>();
      List<Long> monomerIds = new ArrayList<>();
      List<Long> areaIds = new ArrayList<>();

      for (PurchaseOrderDetail detail : details) {
         if (ObjectUtil.isNotEmpty(detail.getProjectId())) {
            projectIds.add(detail.getProjectId());
         }

         if (ObjectUtil.isNotEmpty(detail.getMonomerId())) {
            monomerIds.add(detail.getMonomerId());
         }

         if (ObjectUtil.isNotEmpty(detail.getAreaId())) {
            areaIds.add(detail.getAreaId());
         }
      }

      Map<Long, ContractProject> projectMap = this.queryUtilService.getProjectMapByIds(projectIds);
      Map<Long, PlanMonomer> planMonomerMap = this.queryUtilService.getMonomerMapByIds(monomerIds);
      Map<Long, PlanArea> planAreaMap = this.queryUtilService.getAreaMapByIds(areaIds);

      for (PurchaseOrderDetail detail : details) {
         ApplyPurchaseDTO applyPurchaseDTO = null;
         if (detail.getApplyPurchaseId() != null) {
            applyPurchaseDTO = this.applyPurchaseService.selectById(detail.getApplyPurchaseId());
            if (ObjectUtil.isEmpty(detail.getArtifactEnclosureId())) {
               applyPurchaseDTO.setInboundList(
                  this.inboundDetailService
                     .getListByApplyPurchaseId(detail.getApplyPurchaseId())
                     .stream()
                     .filter(l -> l.getPurchaseOrderDetailId().equals(detail.getId()) && l.getMete().subtract(l.getRejectMete()).compareTo(BigDecimal.ZERO) > 0)
                     .map(l -> {
                        ApplyPurchaseDetailDTO copyx = BeanUtil.copy(l, ApplyPurchaseDetailDTO.class);
                        if (l.getRejectMete() != null) {
                           copyx.setMete(copyx.getMete().subtract(l.getRejectMete()));
                           if (l.getQuantity() != null) {
                              copyx.setQuantity(copyx.getQuantity().subtract(l.getRejectQuantity()));
                           }
                        }

                        return copyx;
                     })
                     .collect(Collectors.toList())
               );
            } else {
               applyPurchaseDTO.setInboundList(
                  this.inboundDetailManufacturedService
                     .getListByApplyPurchaseId(detail.getApplyPurchaseId())
                     .stream()
                     .map(l -> BeanUtil.copy(l, ApplyPurchaseDetailDTO.class))
                     .collect(Collectors.toList())
               );
            }
         }

         if (detail.getArtifactEnclosureId() != null) {
            PurchaseOrderDetailDTO dto = BeanUtil.copy(detail, PurchaseOrderDetailDTO.class);
            if (ObjectUtil.isNotEmpty(detail.getMonomerId())) {
               PlanMonomer monomer = planMonomerMap.get(detail.getMonomerId());
               dto.setMonomer(NameInfo.builder().id(monomer.getId()).name(monomer.getName()).build());
            }

            if (ObjectUtil.isNotEmpty(detail.getAreaId())) {
               PlanArea area = planAreaMap.get(detail.getAreaId());
               dto.setArea(NameInfo.builder().id(area.getId()).name(area.getName()).build());
            }

            if (ObjectUtil.isNotEmpty(detail.getProjectId())) {
               ContractProject contractProject = projectMap.get(detail.getProjectId());
               ProjectInfo bean = cn.hutool.core.bean.BeanUtil.toBean(contractProject, ProjectInfo.class);
               dto.setProject(bean);
               List<ProjectInfo> projects = new ArrayList<>();
               projects.add(bean);
               dto.setProjects(projects);
            }

            QuantityMeteDTO passQuantity = this.inboundDetailManufacturedService.getPassQuantity(detail.getId());
            dto.setMRInboundQuantity(passQuantity.getQuantity());
            list.add(dto);
         } else if (applyPurchaseDTO == null) {
            PurchaseOrderDetailDTO noApplyDto = BeanUtil.copy(detail, PurchaseOrderDetailDTO.class);
            if (ObjectUtil.isNotEmpty(detail.getProjectId())) {
               ContractProject contractProject = projectMap.get(detail.getProjectId());
               if (contractProject != null) {
                  ProjectInfo projectInfo = cn.hutool.core.bean.BeanUtil.toBean(contractProject, ProjectInfo.class);
                  noApplyDto.setProject(projectInfo);
                  List<ProjectInfo> projects = new ArrayList<>();
                  projects.add(projectInfo);
                  noApplyDto.setProjects(projects);
               }
            }

            list.add(noApplyDto);
         } else {
            ProjectInfo project = null;
            if (ObjectUtil.isNotEmpty(detail.getProjectId())) {
               ContractProject contractProject = projectMap.get(detail.getProjectId());
               if (contractProject != null) {
                  project = cn.hutool.core.bean.BeanUtil.toBean(contractProject, ProjectInfo.class);
               }
            }

            StringBuilder sb = new StringBuilder()
               .append(detail.getClassifyId())
               .append(detail.getBrand() != null ? detail.getBrand() : "-")
               .append(detail.getUnitPrice().stripTrailingZeros().toPlainString());
            String s;
            if (BasicClassEnum.checkIsSteel(detail.getBasicClass())) {
               s = sb.append(detail.getSpecification())
                  .append(detail.getThickness() != null ? detail.getThickness() : "-")
                  .append(detail.getLength() != null ? detail.getLength() : "-")
                  .append(detail.getWidth() != null ? detail.getWidth() : "-")
                  .toString();
            } else {
               s = sb.append(detail.getSpecification() != null ? detail.getSpecification() : "-").toString();
            }

            PurchaseOrderDetailDTO dto = map.get(s);
            if (dto == null) {
               PurchaseOrderDetailDTO copy = BeanUtil.copy(detail, PurchaseOrderDetailDTO.class);
               List<BriefIdAndSNDTO> m = new ArrayList<>();
               m.add(
                  BriefIdAndSNDTO.builder()
                     .id(detail.getApplyPurchaseId())
                     .purchaseDetailId(detail.getId())
                     .serialNumber(applyPurchaseDTO.getSerialNumber())
                     .mete(detail.getMete())
                     .quantity(detail.getQuantity())
                     .inboundQuantity(detail.getInboundQuantity())
                     .inboundMete(detail.getInboundMete())
                     .build()
               );
               copy.setApplyPurchase(m);
               if (project != null) {
                  List<ProjectInfo> projects = new ArrayList<>();
                  projects.add(project);
                  copy.setProjects(projects);
               }

               List<ApplyPurchaseDetailDTO> inbound = applyPurchaseDTO.getInboundList();
               if (CollectionUtil.isNotEmpty(inbound)) {
                  copy.setInboundList(inbound);
               }

               map.put(s, copy);
            } else {
               List<BriefIdAndSNDTO> idMap = dto.getApplyPurchase();
               idMap.add(
                  BriefIdAndSNDTO.builder()
                     .id(detail.getApplyPurchaseId())
                     .purchaseDetailId(detail.getId())
                     .serialNumber(applyPurchaseDTO.getSerialNumber())
                     .mete(detail.getMete())
                     .quantity(detail.getQuantity())
                     .inboundQuantity(detail.getInboundQuantity())
                     .inboundMete(detail.getInboundMete())
                     .build()
               );
               if (project != null) {
                  List<ProjectInfo> projects = dto.getProjects();
                  if (projects == null) {
                     projects = new ArrayList<>();
                  }

                  boolean projectExists = false;

                  for (ProjectInfo p : projects) {
                     if (p.getId().equals(project.getId())) {
                        projectExists = true;
                        break;
                     }
                  }

                  if (!projectExists) {
                     projects.add(project);
                  }

                  dto.setProjects(projects);
               }

               if (dto.getQuantity() != null) {
                  dto.setQuantity(dto.getQuantity().add(detail.getQuantity()));
               }

               dto.setMete(dto.getMete().add(detail.getMete()));
               dto.setInboundMete(dto.getInboundMete().add(detail.getInboundMete()));
               dto.setInboundQuantity(dto.getInboundQuantity().add(detail.getInboundQuantity()));
               List<ApplyPurchaseDetailDTO> inboundList = applyPurchaseDTO.getInboundList();
               if (CollectionUtil.isNotEmpty(inboundList)) {
                  List<ApplyPurchaseDetailDTO> inbound = dto.getInboundList();
                  if (CollectionUtil.isNotEmpty(inbound)) {
                     inbound.addAll(inboundList);
                  }
               }
            }
         }
      }

      if (CollectionUtils.isNotEmpty(appPurchaseMap)) {
         for (String k : appPurchaseMap.keySet()) {
            PurchaseOrderDetailDTO detailDTO = map.get(k);
            detailDTO.setApplyPurchase(appPurchaseMap.get(k));
         }
      }

      ArrayList<PurchaseOrderDetailDTO> purchaseOrderDetailDTOS = new ArrayList<>(map.values());
      purchaseOrderDetailDTOS.addAll(list);
      return new ListVO<>(purchaseOrderDetailDTOS);
   }

   @Override
   public List<SupplierDTO> getSupplierInfo(Long id) {
      List<Long> supplierIds = this.baseMapper
         .selectList(
            (Wrapper<PurchaseOrder>)((((new LambdaQueryWrapper<PurchaseOrder>()
                           .eq(PurchaseOrder::getWorkshopId, id))
                        .eq(PurchaseOrder::getProjectAttribute, ProjectAttributeEnum.SELF_SUPPORT.getType()))
                     .eq(PurchaseOrder::getDataStatus, DataStatusEnum.SUCCEED.getType()))
                  .eq(PurchaseOrder::getLevel, PlaceEnum.FACTORY.getType()))
               .isNotNull(PurchaseOrder::getWorkshopId)
         )
         .stream()
         .map(PurchaseOrder::getSupplierId)
         .collect(Collectors.toList());
      List<SupplierDTO> supplierDTOS = new ArrayList<>();
      if (CollectionUtils.isNotEmpty(supplierIds)) {
         List<Supplier> suppliers = this.supplierService.listByIds(supplierIds);
         supplierDTOS = cn.hutool.core.bean.BeanUtil.copyToList(suppliers, SupplierDTO.class);
      }

      return supplierDTOS;
   }

   @Override
   public List<MesBuildingWorkshop> getMesWorkshop() {
      List<Long> mesWorkshopIds = this.baseMapper
         .selectList(
            (Wrapper<PurchaseOrder>)(((new LambdaQueryWrapper<PurchaseOrder>()
                        .eq(PurchaseOrder::getProjectAttribute, ProjectAttributeEnum.SELF_SUPPORT.getType()))
                     .eq(PurchaseOrder::getDataStatus, DataStatusEnum.SUCCEED.getType()))
                  .eq(PurchaseOrder::getLevel, PlaceEnum.FACTORY.getType()))
               .isNotNull(PurchaseOrder::getWorkshopId)
         )
         .stream()
         .map(PurchaseOrder::getWorkshopId)
         .collect(Collectors.toList());
      List<MesBuildingWorkshop> mesBuildingWorkshops = new ArrayList<>();
      if (CollectionUtils.isNotEmpty(mesWorkshopIds)) {
         mesBuildingWorkshops = this.mesWorkshopService.listByIds(mesWorkshopIds);
      }

      return mesBuildingWorkshops;
   }

   @Override
   public PageVO<PurchaseOrderDTO> pageInfoV2(QueryPurchaseOrderDTOParam param, Integer pageNum, Integer size, List<String> sort) {
      List<String> projectAttributeList = Arrays.stream(param.getProjectAttribute().split(",")).map(String::valueOf).collect(Collectors.toList());
      param.setProjectAttributes(projectAttributeList);
      String s = StringUtils.analyzeSortConditions(sort);
      Page<PurchaseOrder> page = PageHelper.startPage(pageNum, size, s);
      List<PurchaseOrder> purchaseOrders = this.baseMapper.listInfoV2(param);
      if (CollectionUtil.isEmpty(purchaseOrders)) {
         return new PageVO<>();
      }

      List<Long> supplierIds = purchaseOrders.stream().map(PurchaseOrder::getSupplierId).filter(ObjectUtil::isNotEmpty).collect(Collectors.toList());
      Map<Long, Supplier> supplierMap = new HashMap<>();
      if (CollectionUtil.isNotEmpty(supplierIds)) {
         supplierMap = this.supplierService.listByIds(supplierIds).stream().collect(Collectors.toMap(Supplier::getId, Function.identity()));
      }

      List<Long> userIds = purchaseOrders.stream().map(PurchaseOrder::getProjectManagerId).filter(ObjectUtil::isNotEmpty).collect(Collectors.toList());
      Map<Long, User> userMap = new HashMap<>();
      if (CollectionUtil.isNotEmpty(userIds)) {
         userMap = this.userService.listByIds(userIds).stream().collect(Collectors.toMap(User::getId, Function.identity()));
      }

      List<Long> branchCompanyIds = purchaseOrders.stream().map(PurchaseOrder::getBranchCompanyId).filter(ObjectUtil::isNotEmpty).collect(Collectors.toList());
      Map<Long, BranchCompany> branchCompanyMap = new HashMap<>();
      if (CollectionUtil.isNotEmpty(branchCompanyIds)) {
         branchCompanyMap = this.branchCompanyService.listByIds(branchCompanyIds).stream().collect(Collectors.toMap(BranchCompany::getId, Function.identity()));
      }

      Map<Long, ProjectInfo> projectInfoMap = new HashMap<>();
      List<PurchaseOrder> purchaseOrderProject = purchaseOrders.stream().filter(p -> ObjectUtil.isNotEmpty(p.getProjectIds())).collect(Collectors.toList());
      if (CollectionUtil.isNotEmpty(purchaseOrderProject)) {
         List<Long> projectIds = purchaseOrderProject.stream()
            .flatMap(p -> Arrays.stream(p.getProjectIds().split(",")).map(Long::valueOf))
            .collect(Collectors.toList());
         if (CollectionUtil.isNotEmpty(projectIds)) {
            projectInfoMap = this.contractProjectService
               .listSimpleByIdList(projectIds)
               .stream()
               .collect(Collectors.toMap(ProjectInfo::getId, Function.identity()));
         }
      }

      Map<Long, AttachmentDTO> attachmentMap = new HashMap<>();
      List<PurchaseOrder> purchaseOrdersAttachment = purchaseOrders.stream()
         .filter(p -> ObjectUtil.isNotEmpty(p.getAttachments()))
         .collect(Collectors.toList());
      if (CollectionUtil.isNotEmpty(purchaseOrdersAttachment)) {
         List<Long> attachmentIds = purchaseOrdersAttachment.stream()
            .flatMap(p -> Arrays.stream(p.getAttachments().split(",")).map(Long::valueOf))
            .collect(Collectors.toList());
         if (CollectionUtil.isNotEmpty(attachmentIds)) {
            attachmentMap = this.attachmentService.listByIdList(attachmentIds).stream().collect(Collectors.toMap(AttachmentDTO::getId, Function.identity()));
         }
      }

      List<Long> purchaseIds = purchaseOrders.stream()
         .filter(p -> p.getPurchaseType().equals(PurchaseEnum.MATERIAL.getType()))
         .map(PurchaseOrder::getId)
         .collect(Collectors.toList());
      List<Inbound> inboundList = new ArrayList<>();
      if (CollectionUtil.isNotEmpty(purchaseIds)) {
         inboundList = this.inboundService.list((Wrapper<Inbound>)new LambdaQueryWrapper<Inbound>().in(Inbound::getPurchaseId, purchaseIds));
      }

      List<Long> purchaseManufacturedIds = purchaseOrders.stream()
         .filter(p -> p.getPurchaseType().equals(PurchaseEnum.FINISHED_GOODS.getType()))
         .map(PurchaseOrder::getId)
         .collect(Collectors.toList());
      List<InboundManufactured> inboundManufacturedList = new ArrayList<>();
      if (CollectionUtil.isNotEmpty(purchaseManufacturedIds)) {
         inboundManufacturedList = this.inboundManufacturedService
            .list((Wrapper<InboundManufactured>)new LambdaQueryWrapper<InboundManufactured>().in(InboundManufactured::getPurchaseId, purchaseManufacturedIds));
      }

      List<PurchaseOrderDTO> collect = new ArrayList<>();

      for (PurchaseOrder po : purchaseOrders) {
         PurchaseOrderDTO orderDTO = BeanUtil.copy(po, PurchaseOrderDTO.class);
         orderDTO.setCreateTime(po.getCreateTime());
         orderDTO.setUpdateTime(po.getUpdateTime());
         if (po.getSupplierId() != null) {
            Supplier supplier = supplierMap.get(po.getSupplierId());
            orderDTO.setSupplier(BriefIdAndNameDTO.builder().id(supplier.getId()).name(supplier.getName()).shortName(supplier.getShortName()).build());
         }

         if (StrUtil.isNotBlank(po.getApplyPurchaseSN())) {
            orderDTO.setApplyPurchaseSN(Arrays.asList((String[])po.getApplyPurchaseSN().split(",").clone()));
         }

         if (StrUtil.isNotBlank(po.getAuxMaterialIds())) {
            orderDTO.setAuxMaterialIds(CommonUtil.spilt(po.getAuxMaterialIds(), ","));
         }

         if (StrUtil.isNotBlank(po.getOtherMaterialIds())) {
            orderDTO.setOtherMaterialIds(CommonUtil.spilt(po.getOtherMaterialIds(), ","));
         }

         if (!param.getProjectAttribute().equals(String.valueOf(ProjectAttributeEnum.SELF_SUPPORT.getType()))) {
            User user = userMap.get(po.getProjectManagerId());
            orderDTO.setProjectManager(com.hzchum.scim.common.core.api.pojo.common.IdAndNameDTO.builder().id(user.getId()).name(user.getName()).build());
         }

         BranchCompany branchCompany = branchCompanyMap.get(po.getBranchCompanyId());
         orderDTO.setBranchCompany(BriefIdAndNameDTO.builder().id(branchCompany.getId()).name(branchCompany.getName()).build());
         if (StrUtil.isNotBlank(po.getAttachments())) {
            List<Long> attachmentList = Arrays.asList(po.getAttachments().split(",")).stream().map(a -> Long.parseLong(a.trim())).collect(Collectors.toList());
            List<AttachmentDTO> attachmentDTOS = attachmentMap.entrySet()
               .stream()
               .filter(a -> attachmentList.contains(a.getKey()))
               .map(Entry::getValue)
               .collect(Collectors.toList());
            orderDTO.setAttachments(attachmentDTOS);
         } else {
            orderDTO.setAttachments(new ArrayList<>());
         }

         if (StrUtil.isNotBlank(po.getProjectIds())) {
            List<Long> projectIdList = Arrays.asList(po.getProjectIds().split(",")).stream().map(p -> Long.parseLong(p.trim())).collect(Collectors.toList());
            List<ProjectInfo> projectInfos = projectInfoMap.entrySet()
               .stream()
               .filter(p -> projectIdList.contains(p.getKey()))
               .map(Entry::getValue)
               .collect(Collectors.toList());
            if (BasicClassEnum.STRUC_MANUFACTURED.getType().equals(po.getBasicClass())) {
               orderDTO.setProject(projectInfos.get(0));
            } else {
               orderDTO.setProjects(projectInfos);
            }
         }

         if (po.getPurchaseType().equals(PurchaseEnum.MATERIAL.getType())) {
            orderDTO.setBoolUsed(
               CollectionUtils.isNotEmpty(inboundList.stream().filter(i -> i.getPurchaseId().equals(orderDTO.getId())).collect(Collectors.toList()))
            );
         } else if (po.getPurchaseType().equals(PurchaseEnum.FINISHED_GOODS.getType())) {
            orderDTO.setBoolUsed(
               CollectionUtils.isNotEmpty(inboundManufacturedList.stream().filter(i -> i.getPurchaseId().equals(orderDTO.getId())).collect(Collectors.toList()))
            );
         } else {
            Preconditions.checkArgument(false, "未知采购材料类型！！！");
         }

         if (po.getWorkshopId() != null) {
            MesBuildingWorkshop mesWorkshop = this.mesWorkshopService.getWorkshopById(po.getWorkshopId());
            orderDTO.setMesWorkshop(
               com.hzchum.scim.common.core.api.pojo.common.IdAndNameDTO.builder().id(mesWorkshop.getId()).name(mesWorkshop.getName()).build()
            );
         }

         orderDTO.setBoolUsed(
            CollectionUtils.isNotEmpty(this.inboundService.list((Wrapper<Inbound>)Wrappers.<Inbound>lambdaQuery().eq(Inbound::getPurchaseId, orderDTO.getId())))
         );
         collect.add(orderDTO);
      }

      this.setFinanceInfo(collect);
      this.setActualTotalMete(collect);
      return new PageVO<>(page, collect);
   }

   @Override
   public PageVO<BriefPurchaseOrderNewDTO> getSimplePageList(QueryPurchaseOrderDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort) {
      List<String> projectAttributeList = Arrays.stream(param.getProjectAttribute().split(",")).map(String::valueOf).collect(Collectors.toList());
      param.setProjectAttributes(projectAttributeList);
      String s = StringUtils.analyzeSortConditions(sort);
      Page<PurchaseOrder> page = PageHelper.startPage(pageNumber, pageSize, s);
      List<PurchaseOrder> purchaseOrders = this.baseMapper.listInfoV2(param);
      if (CollectionUtil.isEmpty(purchaseOrders)) {
         return new PageVO<>();
      }

      List<BriefPurchaseOrderNewDTO> collect = purchaseOrders.stream()
         .map(
            po -> {
               BriefPurchaseOrderNewDTO orderDTO = BeanUtil.copy(po, BriefPurchaseOrderNewDTO.class);
               if (po.getSupplierId() != null) {
                  Supplier supplier = this.supplierService.getById(po.getSupplierId());
                  orderDTO.setSupplier(BriefIdAndNameDTO.builder().id(supplier.getId()).name(supplier.getName()).build());
               }

               BranchCompany branchCompany = this.branchCompanyService.getById(po.getBranchCompanyId());
               orderDTO.setBranchCompany(BriefIdAndNameDTO.builder().id(branchCompany.getId()).name(branchCompany.getName()).build());
               if (StrUtil.isNotBlank(po.getApplyPurchaseIds())) {
                  List<Long> ids = CommonUtil.spilt(po.getApplyPurchaseIds(), ",");
                  orderDTO.setApplyPurchase(
                     this.applyPurchaseService
                        .listByIds(ids)
                        .stream()
                        .map(l -> BriefIdAndSNDTO.builder().id(l.getId()).serialNumber(l.getSerialNumber()).build())
                        .collect(Collectors.toList())
                  );
               }

               if (StrUtil.isNotBlank(po.getAuxMaterialIds())) {
                  orderDTO.setAuxMaterialIds(CommonUtil.spilt(po.getAuxMaterialIds(), ","));
               }

               if (StrUtil.isNotBlank(po.getOtherMaterialIds())) {
                  orderDTO.setOtherMaterialIds(CommonUtil.spilt(po.getOtherMaterialIds(), ","));
               }

               if (StrUtil.isNotBlank(po.getProjectIds())) {
                  orderDTO.setProjects(this.contractProjectService.listByIds(po.getProjectIds()));
               }

               orderDTO.setBoolAnnual(po.getBoolAnnual());
               List<Integer> status = new ArrayList<>();
               status.add(ReviewStatusEnum.AUDITING.getType());
               status.add(ReviewStatusEnum.REVIEWED.getType());
               BigDecimal quantity = new BigDecimal(0);
               BigDecimal mete = new BigDecimal(0);
               if (po.getPurchaseType().equals(PurchaseEnum.MATERIAL.getType())) {
                  QuantityMeteDTO countMete = this.inboundDetailService.getCountMete(po.getId(), status);
                  status.add(ReviewStatusEnum.UN_REVIEWED.getType());
                  QuantityMeteDTO rejectMeteDTO = this.rejectService.getCountMete(po.getId(), status);
                  quantity = countMete.getQuantity().subtract(rejectMeteDTO.getQuantity());
                  mete = countMete.getMete().subtract(rejectMeteDTO.getMete());
               } else if (po.getPurchaseType().equals(PurchaseEnum.FINISHED_GOODS.getType())) {
                  QuantityMeteDTO countMete = this.inboundDetailManufacturedService.getCountMete(po.getId(), status);
                  quantity = countMete.getQuantity();
               } else {
                  Preconditions.checkArgument(false, "未知采购材料类型！！！");
               }

               orderDTO.setInboundTotalMete(mete);
               orderDTO.setInboundTotalQuantity(quantity);
               return orderDTO;
            }
         )
         .collect(Collectors.toList());
      return new PageVO<>(page, collect);
   }

   private void setFinanceInfo(List<PurchaseOrderDTO> purchaseOrderDTOList) {
      List<Long> purchaseIds = purchaseOrderDTOList.stream().map(PurchaseOrderDTO::getId).collect(Collectors.toList());
      List<SupplierPayment> supplierPaymentList = this.supplierPaymentService
         .list(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .in(SupplierPayment::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
               .in(SupplierPayment::getOrderId, purchaseIds)
               .in(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(), SupplierPropertyTypeEnum.PURCHASE_FEE.getType())
         );
      Map<Long, BigDecimal> supplierPaymentMap = supplierPaymentList.stream()
         .filter(s -> s.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType()))
         .collect(
            Collectors.groupingBy(
               SupplierPayment::getOrderId,
               Collectors.mapping(SupplierPayment::getActuallyPaymentAmount, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))
            )
         );
      Map<Long, Long> orderUnAuditPaymentCountMap = supplierPaymentList.stream()
         .filter(s -> s.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()))
         .collect(Collectors.groupingBy(SupplierPayment::getOrderId, Collectors.counting()));
      List<SupplierInvoice> supplierInvoiceList = this.supplierInvoiceService
         .list(
            Wrappers.lambdaQuery(SupplierInvoice.class)
               .in(SupplierInvoice::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
               .in(SupplierInvoice::getOrderId, purchaseIds)
               .in(SupplierInvoice::getPropertyType, SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(), SupplierPropertyTypeEnum.PURCHASE_FEE.getType())
         );
      Map<Long, BigDecimal> supplierInvoiceMap = supplierInvoiceList.stream()
         .filter(s -> s.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType()))
         .collect(
            Collectors.groupingBy(
               SupplierInvoice::getOrderId, Collectors.mapping(SupplierInvoice::getActualInvoiceAmount, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))
            )
         );
      Map<Long, Long> orderUnAuditInvoiceCountMap = supplierInvoiceList.stream()
         .filter(s -> s.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()))
         .collect(Collectors.groupingBy(SupplierInvoice::getOrderId, Collectors.counting()));
      List<SupplierSettlement> settlementList = this.supplierSettlementService
         .list(
            Wrappers.lambdaQuery(SupplierSettlement.class)
               .in(SupplierSettlement::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
               .in(SupplierSettlement::getOrderId, purchaseIds)
               .in(SupplierSettlement::getOrderClass, OrderClassEnum.MATERIAL_ORDER.getType(), OrderClassEnum.MANUFACTURE_ORDER.getType())
         );
      Map<Long, Map<Boolean, Long>> orderUnAuditSettlementCountMap = settlementList.stream()
         .filter(s -> s.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()))
         .collect(Collectors.groupingBy(SupplierSettlement::getOrderId, Collectors.groupingBy(SupplierSettlement::getBoolPreSettlement, Collectors.counting())));
      Map<Long, BigDecimal> orderIdPreSettleAmountMap = settlementList.stream()
         .filter(SupplierSettlement::getBoolPreSettlement)
         .filter(s -> s.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType()))
         .collect(Collectors.groupingBy(SupplierSettlement::getOrderId, Collectors.reducing(BigDecimal.ZERO, SupplierSettlement::getAmount, BigDecimal::add)));
      Map<Long, BigDecimal> orderIdInboundAmountMap = this.inboundService
         .list(Wrappers.lambdaQuery(Inbound.class).eq(Inbound::getReviewStatus, ReviewStatusEnum.REVIEWED.getType()).in(Inbound::getPurchaseId, purchaseIds))
         .stream()
         .filter(s -> s.getAmountNoFreight() != null)
         .collect(Collectors.groupingBy(Inbound::getPurchaseId, Collectors.reducing(BigDecimal.ZERO, Inbound::getAmountNoFreight, BigDecimal::add)));
      Map<Long, BigDecimal> orderIdInboundManufacturedAmountMap = this.inboundManufacturedService
         .list(
            Wrappers.lambdaQuery(InboundManufactured.class)
               .eq(InboundManufactured::getReviewStatus, ReviewStatusEnum.REVIEWED.getType())
               .in(InboundManufactured::getPurchaseId, purchaseIds)
         )
         .stream()
         .filter(s -> s.getAmount() != null)
         .collect(
            Collectors.groupingBy(InboundManufactured::getPurchaseId, Collectors.reducing(BigDecimal.ZERO, InboundManufactured::getAmount, BigDecimal::add))
         );
      Map<Long, BigDecimal> orderIdRejectAmountMap = this.rejectService
         .list(Wrappers.lambdaQuery(Reject.class).eq(Reject::getReviewStatus, ReviewStatusEnum.REVIEWED.getType()).in(Reject::getPurchaseOrderId, purchaseIds))
         .stream()
         .filter(s -> s.getAmountNoFreight() != null)
         .collect(Collectors.groupingBy(Reject::getPurchaseOrderId, Collectors.reducing(BigDecimal.ZERO, Reject::getAmountNoFreight, BigDecimal::add)));
      Map<Long, BigDecimal> receiviedAmountMap = this.getReceiviedAmount(purchaseIds);
      Map<Long, BigDecimal> orderIdAdjustAmountMap = this.getOrderIdAdjustAmountMap(purchaseIds);
      FinanceAmountShowConfigDTO financeAmountShowConfig = this.configService.getFinanceAmountShowConfig();
      purchaseOrderDTOList.forEach(
         dto -> {
            BigDecimal adjustAmount = orderIdAdjustAmountMap.getOrDefault(dto.getId(), BigDecimal.ZERO);
            if (PlaceEnum.FACTORY.getType().equals(dto.getOrderPlace())) {
               if (dto.getPurchaseType().equals(PurchaseEnum.MATERIAL.getType())) {
                  dto.setInboundAmount(
                     orderIdInboundAmountMap.getOrDefault(dto.getId(), BigDecimal.ZERO)
                        .subtract(orderIdRejectAmountMap.getOrDefault(dto.getId(), BigDecimal.ZERO))
                        .add(adjustAmount)
                        .setScale(2, RoundingMode.HALF_UP)
                  );
               } else {
                  dto.setInboundAmount(
                     orderIdInboundManufacturedAmountMap.getOrDefault(dto.getId(), BigDecimal.ZERO).add(adjustAmount).setScale(2, RoundingMode.HALF_UP)
                  );
               }
            }

            if (PlaceEnum.CONSTRUCTION_SITE.getType().equals(dto.getOrderPlace())) {
               dto.setInboundAmount(receiviedAmountMap.get(dto.getId()));
            }

            dto.setPreSettlementAmount(orderIdPreSettleAmountMap.get(dto.getId()));
            dto.setCumulativePayment(supplierPaymentMap.getOrDefault(dto.getId(), BigDecimal.ZERO));
            dto.setCumulativeInvoice(supplierInvoiceMap.getOrDefault(dto.getId(), BigDecimal.ZERO));
            if (dto.getSettlementStatus() != null && !dto.getSettlementStatus().equals(SettlementStatusEnum.UN_SETTLED.getType())) {
               dto.setPaymentRate(
                  dto.getSettlementAmount().compareTo(BigDecimal.ZERO) != 0
                     ? supplierPaymentMap.getOrDefault(dto.getId(), BigDecimal.ZERO)
                        .multiply(BigDecimal.valueOf(100L))
                        .divide(dto.getSettlementAmount(), 2, RoundingMode.HALF_UP)
                     : BigDecimal.ZERO
               );
               dto.setInvoiceRate(
                  dto.getSettlementAmount().compareTo(BigDecimal.ZERO) != 0
                     ? supplierInvoiceMap.getOrDefault(dto.getId(), BigDecimal.ZERO)
                        .multiply(BigDecimal.valueOf(100L))
                        .divide(dto.getSettlementAmount(), 2, RoundingMode.HALF_UP)
                     : BigDecimal.ZERO
               );
               dto.setUnpaidAmount(
                  dto.getSettlementAmount().compareTo(dto.getCumulativePayment()) > 0
                     ? dto.getSettlementAmount().subtract(dto.getCumulativePayment()).setScale(2, RoundingMode.HALF_UP)
                     : BigDecimal.ZERO
               );
            } else {
               dto.setPaymentRate(
                  dto.getAmount().compareTo(BigDecimal.ZERO) != 0
                     ? supplierPaymentMap.getOrDefault(dto.getId(), BigDecimal.ZERO)
                        .multiply(BigDecimal.valueOf(100L))
                        .divide(dto.getAmount(), 2, RoundingMode.HALF_UP)
                     : BigDecimal.ZERO
               );
               dto.setInvoiceRate(
                  dto.getAmount().compareTo(BigDecimal.ZERO) != 0
                     ? supplierInvoiceMap.getOrDefault(dto.getId(), BigDecimal.ZERO)
                        .multiply(BigDecimal.valueOf(100L))
                        .divide(dto.getAmount(), 2, RoundingMode.HALF_UP)
                     : BigDecimal.ZERO
               );
               if (financeAmountShowConfig.getBoolShowUnsettledUnpaidAmount()) {
                  dto.setUnpaidAmount(
                     dto.getAmount().compareTo(dto.getCumulativePayment()) > 0
                        ? dto.getAmount().subtract(dto.getCumulativePayment()).setScale(2, RoundingMode.HALF_UP)
                        : BigDecimal.ZERO
                  );
               }
            }

            dto.setPaymentSize(orderUnAuditPaymentCountMap.getOrDefault(dto.getId(), 0L).intValue());
            dto.setInvoiceSize(orderUnAuditInvoiceCountMap.getOrDefault(dto.getId(), 0L).intValue());
            dto.setSettlementSize(orderUnAuditSettlementCountMap.getOrDefault(dto.getId(), Collections.emptyMap()).getOrDefault(false, 0L).intValue());
            dto.setPreSettlementSize(orderUnAuditSettlementCountMap.getOrDefault(dto.getId(), Collections.emptyMap()).getOrDefault(true, 0L).intValue());
         }
      );
   }

   @Override
   public void setActualTotalMete(List<PurchaseOrderDTO> purchaseOrderDTOList) {
      List<Long> purchaseIds = purchaseOrderDTOList.stream()
         .filter(e -> Boolean.TRUE.equals(e.getBoolDetail()))
         .filter(
            e -> {
               int showx = BasicClassEnum.STEEL_PLATE.getType()
                  | BasicClassEnum.SECTION_STEEL.getType()
                  | BasicClassEnum.COLOR_ROLL.getType()
                  | BasicClassEnum.STRUC_MANUFACTURED.getType();
               Integer basicClassx = e.getBasicClass();
               return (basicClassx & ~showx) == 0;
            }
         )
         .map(PurchaseOrderDTO::getId)
         .collect(Collectors.toList());
      if (!CollectionUtils.isEmpty(purchaseIds)) {
         Map<Long, BigDecimal> orderIdInboundMeteMap = new HashMap<>();
         Map<Long, BigDecimal> orderIdRejectMeteMap = new HashMap<>();
         Map<Long, BigDecimal> orderIdInboundManufacturedMeteMap = new HashMap<>();
         Map<Long, BigDecimal> orderIdReceivingMeteMap = new HashMap<>();
         Map<Long, BigDecimal> orderIdManufacturedMeteMap = new HashMap<>();
         List<ReceiptMeteDTO> inboundMeteList = this.inboundDetailService.getPurchaseInboundMete(purchaseIds);
         if (CollectionUtil.isNotEmpty(inboundMeteList)) {
            orderIdInboundMeteMap = inboundMeteList.stream().collect(Collectors.toMap(ReceiptMeteDTO::getId, ReceiptMeteDTO::getMete));
         }

         List<ReceiptMeteDTO> rejectMeteList = this.rejectDetailService.getPurchaseRejectMete(purchaseIds);
         if (CollectionUtil.isNotEmpty(rejectMeteList)) {
            orderIdRejectMeteMap = rejectMeteList.stream().collect(Collectors.toMap(ReceiptMeteDTO::getId, ReceiptMeteDTO::getMete));
         }

         List<ReceiptMeteDTO> inboundManufacturedMeteList = this.inboundDetailManufacturedService.getPurchaseRejectMete(purchaseIds);
         if (CollectionUtil.isNotEmpty(inboundManufacturedMeteList)) {
            orderIdInboundManufacturedMeteMap = inboundManufacturedMeteList.stream().collect(Collectors.toMap(ReceiptMeteDTO::getId, ReceiptMeteDTO::getMete));
         }

         List<Long> purchaseIds2 = purchaseOrderDTOList.stream()
            .filter(e -> PlaceEnum.CONSTRUCTION_SITE.getType().equals(e.getOrderPlace()))
            .map(PurchaseOrderDTO::getId)
            .collect(Collectors.toList());
         if (CollectionUtil.isNotEmpty(purchaseIds2)) {
            orderIdReceivingMeteMap = this.purchaseOrderDetailMapper
               .selectList(Wrappers.lambdaQuery(PurchaseOrderDetail.class).in(PurchaseOrderDetail::getPurchaseId, purchaseIds2))
               .stream()
               .collect(
                  Collectors.groupingBy(
                     PurchaseOrderDetail::getPurchaseId,
                     Collectors.mapping(
                        detail -> detail.getWageQuotaType() != null && WmsWageQuotaTypeEnum.WMS_WEIGHT_PRICE.getType() != detail.getWageQuotaType()
                           ? detail.getReceivedMete()
                           : detail.getActualReceivedMete(),
                        Collectors.reducing(BigDecimal.ZERO, BigDecimal::add)
                     )
                  )
               );
         }

         List<Long> purchaseIds3 = purchaseOrderDTOList.stream().filter(e -> e.getBasicClass() == 32).map(PurchaseOrderDTO::getId).collect(Collectors.toList());
         if (CollectionUtil.isNotEmpty(purchaseIds3)) {
            orderIdManufacturedMeteMap = this.purchaseOrderDetailMapper
               .selectList(
                  Wrappers.lambdaQuery(PurchaseOrderDetail.class)
                     .in(PurchaseOrderDetail::getPurchaseId, purchaseIds3)
                     .eq(PurchaseOrderDetail::getBasicClass, BasicClassEnum.STRUC_MANUFACTURED.getType())
               )
               .stream()
               .collect(
                  Collectors.groupingBy(
                     PurchaseOrderDetail::getPurchaseId,
                     Collectors.mapping(PurchaseOrderDetail::getTotalWeight, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))
                  )
               );
         }

         Map<String, Unit> unitMap = this.unitService.list(new LambdaQueryWrapper<>()).stream().collect(Collectors.toMap(Unit::getName, Function.identity()));

         for (PurchaseOrderDTO dto : purchaseOrderDTOList) {
            int show = BasicClassEnum.STEEL_PLATE.getType()
               | BasicClassEnum.SECTION_STEEL.getType()
               | BasicClassEnum.COLOR_ROLL.getType()
               | BasicClassEnum.STRUC_MANUFACTURED.getType();
            Integer basicClass = dto.getBasicClass();
            boolean showActualTotalMete = (basicClass & ~show) == 0;
            if (showActualTotalMete) {
               BigDecimal purchaseInboundMeteA = orderIdInboundMeteMap.getOrDefault(dto.getId(), BigDecimal.ZERO);
               BigDecimal purchaseInboundManufacturedMeteA = orderIdInboundManufacturedMeteMap.getOrDefault(dto.getId(), BigDecimal.ZERO);
               BigDecimal purchaseReceivingMeteA = orderIdReceivingMeteMap.getOrDefault(dto.getId(), BigDecimal.ZERO);
               BigDecimal purchaseRejectMeteA = orderIdRejectMeteMap.getOrDefault(dto.getId(), BigDecimal.ZERO);
               BigDecimal actualTotalMete = purchaseInboundMeteA.add(purchaseInboundManufacturedMeteA)
                  .add(purchaseReceivingMeteA)
                  .subtract(purchaseRejectMeteA);
               if (basicClass == 32) {
                  BigDecimal mete = orderIdManufacturedMeteMap.getOrDefault(dto.getId(), BigDecimal.ZERO);
                  dto.setMete(mete.divide(BigDecimal.valueOf(1000L), 2, 4));
                  dto.setMeteUnit("kg");
                  dto.setActualInboundMeteRatio(actualTotalMete.multiply(BigDecimal.valueOf(100L)).divide(mete, 2, 1));
               } else {
                  List<Integer> nameStr2 = BasicClassEnum.getNameStr2(basicClass);
                  List<Measure> measures = this.measureService.list((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().in(Measure::getBasicClass, nameStr2));
                  Map<Integer, BigDecimal> convertMete = this.unitConversionV2(
                     actualTotalMete, measures.get(0).getAccountingUnit(), measures.get(0).getAccountingPrecision(), unitMap
                  );
                  dto.setActualInboundMeteRatio(convertMete.get(1).multiply(BigDecimal.valueOf(100L)).divide(dto.getMete(), 2, 1));
               }
            }
         }
      }
   }

   @Override
   public List<PurchaseOrder> listAllByIds(List<Long> ids) {
      return this.baseMapper.listAllByIds(ids);
   }

   @Override
   public BigDecimal getActualInboundAmount(Long orderId, Integer orderPlace, Integer purchaseType) {
      BigDecimal actualInboundAmount;
      if (PlaceEnum.FACTORY.getType().equals(orderPlace)) {
         if (purchaseType.equals(PurchaseEnum.MATERIAL.getType())) {
            BigDecimal inboundAmount = this.inboundService
               .list(Wrappers.lambdaQuery(Inbound.class).eq(Inbound::getReviewStatus, ReviewStatusEnum.REVIEWED.getType()).eq(Inbound::getPurchaseId, orderId))
               .stream()
               .map(Inbound::getAmountNoFreight)
               .filter(Objects::nonNull)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal rejectAmount = this.rejectService
               .list(
                  Wrappers.lambdaQuery(Reject.class).eq(Reject::getReviewStatus, ReviewStatusEnum.REVIEWED.getType()).eq(Reject::getPurchaseOrderId, orderId)
               )
               .stream()
               .map(Reject::getAmountNoFreight)
               .filter(Objects::nonNull)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal adjustAmount = this.getOrderIdAdjustAmountMap(Collections.singletonList(orderId)).getOrDefault(orderId, BigDecimal.ZERO);
            actualInboundAmount = inboundAmount.subtract(rejectAmount).add(adjustAmount);
         } else {
            BigDecimal inboundManufacturedAmount = this.inboundManufacturedService
               .list(
                  Wrappers.lambdaQuery(InboundManufactured.class)
                     .eq(InboundManufactured::getReviewStatus, ReviewStatusEnum.REVIEWED.getType())
                     .eq(InboundManufactured::getPurchaseId, orderId)
               )
               .stream()
               .map(InboundManufactured::getAmount)
               .filter(Objects::nonNull)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal adjustAmount = this.getOrderIdAdjustAmountMap(Collections.singletonList(orderId)).getOrDefault(orderId, BigDecimal.ZERO);
            actualInboundAmount = inboundManufacturedAmount.subtract(adjustAmount).add(adjustAmount);
         }
      } else {
         List<PurchaseOrderDetail> orderDetailList = this.purchaseOrderDetailMapper
            .selectList(Wrappers.lambdaQuery(PurchaseOrderDetail.class).in(PurchaseOrderDetail::getPurchaseId, orderId));
         actualInboundAmount = orderDetailList.stream()
            .filter(e -> e.getUnitPrice() != null)
            .filter(e -> e.getActualReceivedMete() != null)
            .map(orderDetail -> orderDetail.getActualReceivedMete().multiply(orderDetail.getUnitPrice()))
            .reduce(BigDecimal.ZERO, BigDecimal::add);
      }

      return actualInboundAmount;
   }

   private Map<Long, BigDecimal> getReceiviedAmount(List<Long> purchaseIds) {
      Map<Long, BigDecimal> resultMap = new HashMap<>();
      if (CollectionUtils.isEmpty(purchaseIds)) {
         return resultMap;
      }

      Map<Long, List<PurchaseOrderDetail>> orderDetailMap = this.purchaseOrderDetailMapper
         .selectList(Wrappers.lambdaQuery(PurchaseOrderDetail.class).in(PurchaseOrderDetail::getPurchaseId, purchaseIds))
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
   public Map<Long, BigDecimal> getOrderIdAdjustAmountMap(Collection<Long> orderIds) {
      List<Inbound> inboundList = this.inboundService
         .list(Wrappers.lambdaQuery(Inbound.class).eq(Inbound::getReviewStatus, ReviewStatusEnum.REVIEWED.getType()).in(Inbound::getPurchaseId, orderIds));
      if (inboundList.isEmpty()) {
         return Collections.emptyMap();
      }

      List<InboundDetail> inboundDetailList = this.inboundDetailService
         .list(Wrappers.lambdaQuery(InboundDetail.class).in(InboundDetail::getInboundId, inboundList.stream().map(Inbound::getId).collect(Collectors.toList())));
      Map<Long, BigDecimal> inboundDetailIdAdjustAmountMap = this.wmsAdjustDetailService
         .list(
            Wrappers.lambdaQuery(WmsAdjustDetail.class)
               .in(WmsAdjustDetail::getInboundDetailId, inboundDetailList.stream().map(InboundDetail::getId).collect(Collectors.toList()))
               .eq(WmsAdjustDetail::getReviewStatus, ReviewStatusEnum.REVIEWED.getType())
         )
         .stream()
         .filter(ad -> ad.getDifferentAmount() != null)
         .collect(
            Collectors.groupingBy(
               WmsAdjustDetail::getInboundDetailId, Collectors.reducing(BigDecimal.ZERO, WmsAdjustDetail::getDifferentAmount, BigDecimal::add)
            )
         );
      Map<Long, BigDecimal> inboundIdAdjustAmountMap = inboundDetailList.stream()
         .collect(
            Collectors.groupingBy(
               InboundDetail::getInboundId,
               Collectors.mapping(
                  de -> inboundDetailIdAdjustAmountMap.getOrDefault(de.getId(), BigDecimal.ZERO), Collectors.reducing(BigDecimal.ZERO, BigDecimal::add)
               )
            )
         );
      return inboundList.stream()
         .collect(
            Collectors.groupingBy(
               Inbound::getPurchaseId,
               Collectors.mapping(
                  in -> inboundIdAdjustAmountMap.getOrDefault(in.getId(), BigDecimal.ZERO), Collectors.reducing(BigDecimal.ZERO, BigDecimal::add)
               )
            )
         );
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveV2(PurchaseOrderDTOParam dtoParam, Boolean boolAgainSubmit) {
      PurchaseOrder purchaseOrder = PurchaseOrder.builder().build();
      purchaseOrder.setArtifactWageQuotaType(dtoParam.getArtifactWageQuotaType());
      purchaseOrder.setIsGoForOaApproval(dtoParam.getIsGoForOaApproval());
      if (CollectionUtil.isNotEmpty(dtoParam.getApplyPurchaseIds())) {
         List<ApplyPurchase> applyPurchases = this.applyPurchaseService.listByIds(dtoParam.getApplyPurchaseIds());
         List<String> collectUpdate = applyPurchases.stream()
            .filter(a -> ObjectUtil.isNotEmpty(a.getUpdateTime()) && a.getUpdateTime().isAfter(dtoParam.getClickAddTime()))
            .map(ApplyPurchase::getSerialNumber)
            .collect(Collectors.toList());
         Preconditions.checkArgument(CollectionUtil.isEmpty(collectUpdate), "申购单：" + collectUpdate + "内容有变化，请关闭当前页面重新创建采购订单");
         List<String> collectFinish = applyPurchases.stream()
            .filter(a -> a.getPurchaseCreationState().equals(ApplyPurchaseStateEnum.CREATED.getType()))
            .map(ApplyPurchase::getSerialNumber)
            .collect(Collectors.toList());
         Preconditions.checkArgument(boolAgainSubmit || CollectionUtil.isEmpty(collectFinish), "申购单：" + collectFinish + "已完成，不可创建采购单");
         purchaseOrder.setApplyPurchaseIds(StrUtil.join(",", dtoParam.getApplyPurchaseIds()));
      }

      this.checkSelfParam(dtoParam);
      BeanUtil.copy(dtoParam, purchaseOrder);
      if (InvoiceTypeEnum.RECEIPT.getType().equals(dtoParam.getInvoiceType())) {
         purchaseOrder.setTaxRate(null);
      }

      purchaseOrder.setBoolSysgen(ObjectUtil.isNotEmpty(dtoParam.getBoolSysgen()) ? dtoParam.getBoolSysgen() : false);
      purchaseOrder.setSerialNumber(this.getSerialNumber(dtoParam, purchaseOrder));
      SecurityUser currentUser = UserUtil.getCurrentUser();
      if (!boolAgainSubmit) {
         purchaseOrder.setApplicantId(currentUser.getId());
         purchaseOrder.setApplicantName(currentUser.getName());
         purchaseOrder.setLastOperatorNameId(currentUser.getId());
         purchaseOrder.setLastOperatorName(currentUser.getName());
      } else {
         PurchaseOrder purchaseOrderOld = this.baseMapper.selectById(dtoParam.getId());
         purchaseOrder.setApplicantId(purchaseOrderOld.getApplicantId());
         purchaseOrder.setApplicantName(purchaseOrderOld.getApplicantName());
         purchaseOrder.setLastOperatorNameId(currentUser.getId());
         purchaseOrder.setLastOperatorName(currentUser.getName());
         purchaseOrder.setPassParentId(dtoParam.getId());
      }

      purchaseOrder.setBranchCompanyId(dtoParam.getBranchCompanyId());
      purchaseOrder.setUserUpdateTime(LocalDateTime.now());
      purchaseOrder.setProjectIds(StrUtil.join(",", dtoParam.getProjectIds()));
      purchaseOrder.setBoolUsed(0);
      if (!dtoParam.getProjectAttribute().equals(ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType()) && ObjectUtil.isNotEmpty(dtoParam.getBranchCompanyId())) {
         BranchCompany branchCompany = this.branchCompanyService.getById(dtoParam.getBranchCompanyId());
         if (branchCompany != null) {
            Optional.ofNullable(branchCompany.getLevel()).ifPresent(purchaseOrder::setLevel);
            Optional.ofNullable(branchCompany.getBranchAttributeEnum()).ifPresent(purchaseOrder::setBranchAttributeEnum);
         }
      }

      if (ObjectUtil.isEmpty(dtoParam.getProjectIds())) {
         purchaseOrder.setProjectIds(ObjectUtil.isNotEmpty(dtoParam.getProjectId()) ? String.valueOf(dtoParam.getProjectId()) : null);
      }

      purchaseOrder.setBoolAnnual(dtoParam.getBoolAnnual());
      this.listChangeStrV2(dtoParam, purchaseOrder);
      int insert = this.baseMapper.insert(purchaseOrder);
      dtoParam.setId(purchaseOrder.getId());
      dtoParam.setSerialNumber(purchaseOrder.getSerialNumber());
      if (dtoParam.getBoolDetail()) {
         this.saveDetailV2(dtoParam, purchaseOrder);
      }

      this.classificationService.updateClassifyUsed(IdsStatusDTO.builder().idsStr(purchaseOrder.getClassifyIds()).build());
      return this.baseMapper.updateById(purchaseOrder) == 1;
   }

   @Transactional(rollbackFor = Exception.class)
   public ResultVO saveV2Oa(PurchaseOrderDTOParam dtoParam, Boolean boolAgainSubmit) {
      ResultVO<Object> build = ResultVO.<Object>builder().build();
      PurchaseOrder purchaseOrder = PurchaseOrder.builder().build();
      if (CollectionUtil.isNotEmpty(dtoParam.getApplyPurchaseIds())) {
         int updateCount = this.applyPurchaseService
            .count(
               (Wrapper<ApplyPurchase>)(Wrappers.<ApplyPurchase>lambdaQuery().in(ApplyPurchase::getId, dtoParam.getApplyPurchaseIds()))
                  .ge(BaseEntity::getUpdateTime, dtoParam.getClickAddTime())
            );
         Preconditions.checkArgument(updateCount == 0, "申购内容有变化，请关闭当前页面重新创建采购订单");

         for (ApplyPurchase applyPurchase : this.applyPurchaseService.listByIds(dtoParam.getApplyPurchaseIds())) {
            Preconditions.checkArgument(
               applyPurchase.getPurchaseCreationState().equals(ApplyPurchaseStateEnum.NOT_STARTED.getType())
                  || applyPurchase.getPurchaseCreationState().equals(ApplyPurchaseStateEnum.PARTIAL_CREATED.getType()),
               "申购单已采购完毕不能创建"
            );
         }

         purchaseOrder.setApplyPurchaseIds(StrUtil.join(",", dtoParam.getApplyPurchaseIds()));
      }

      this.checkSelfParam(dtoParam);
      BeanUtil.copy(dtoParam, purchaseOrder);
      if (InvoiceTypeEnum.RECEIPT.getType().equals(dtoParam.getInvoiceType())) {
         purchaseOrder.setTaxRate(null);
      }

      purchaseOrder.setBoolSysgen(ObjectUtil.isNotEmpty(dtoParam.getBoolSysgen()) ? dtoParam.getBoolSysgen() : false);
      purchaseOrder.setSerialNumber(this.getSerialNumber(dtoParam, purchaseOrder));
      SecurityUser currentUser = UserUtil.getCurrentUser();
      if (!boolAgainSubmit) {
         purchaseOrder.setApplicantId(currentUser.getId());
         purchaseOrder.setApplicantName(currentUser.getName());
         purchaseOrder.setLastOperatorNameId(currentUser.getId());
         purchaseOrder.setLastOperatorName(currentUser.getName());
      } else {
         PurchaseOrder purchaseOrderOld = this.baseMapper.selectById(dtoParam.getId());
         purchaseOrder.setApplicantId(purchaseOrderOld.getApplicantId());
         purchaseOrder.setApplicantName(purchaseOrderOld.getApplicantName());
         purchaseOrder.setLastOperatorNameId(currentUser.getId());
         purchaseOrder.setLastOperatorName(currentUser.getName());
         purchaseOrder.setPassParentId(dtoParam.getId());
      }

      purchaseOrder.setBranchCompanyId(dtoParam.getBranchCompanyId());
      purchaseOrder.setUserUpdateTime(LocalDateTime.now());
      purchaseOrder.setProjectIds(StrUtil.join(",", dtoParam.getProjectIds()));
      purchaseOrder.setBoolUsed(0);
      if (!dtoParam.getProjectAttribute().equals(ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType()) && ObjectUtil.isNotEmpty(dtoParam.getBranchCompanyId())) {
         Integer level = this.branchCompanyService.getById(dtoParam.getBranchCompanyId()).getLevel();
         if (ObjectUtil.isNotEmpty(level)) {
            purchaseOrder.setLevel(level);
         }
      }

      if (ObjectUtil.isEmpty(dtoParam.getProjectIds())) {
         purchaseOrder.setProjectIds(ObjectUtil.isNotEmpty(dtoParam.getProjectId()) ? String.valueOf(dtoParam.getProjectId()) : null);
      }

      purchaseOrder.setBoolAnnual(dtoParam.getBoolAnnual());
      this.listChangeStrV2(dtoParam, purchaseOrder);
      int insert = this.baseMapper.insert(purchaseOrder);
      dtoParam.setId(purchaseOrder.getId());
      dtoParam.setSerialNumber(purchaseOrder.getSerialNumber());
      if (dtoParam.getBoolDetail()) {
         this.saveDetailV2(dtoParam, purchaseOrder);
      }

      this.classificationService.updateClassifyUsed(IdsStatusDTO.builder().idsStr(purchaseOrder.getClassifyIds()).build());
      purchaseOrder.setReviewStatus(ReviewStatusEnum.AUDITING.getType());
      purchaseOrder.setDataStatus(DataStatusEnum.UNDER_REVIEW.getType());
      purchaseOrder.setBoolRewrite(Boolean.FALSE);
      purchaseOrder.setProjectIds(StrUtil.join(",", dtoParam.getProjectIds()));
      purchaseOrder.setAttachments(StrUtil.join(",", dtoParam.getAttachmentIds()));
      this.baseMapper.updateById(purchaseOrder);
      this.baseMapper.deleteById(purchaseOrder);
      build.setCode(2000L);
      build.setData(purchaseOrder.getId());
      return build;
   }

   private String getSerialNumber(PurchaseOrderDTOParam dtoParam, PurchaseOrder purchaseOrder) {
      String serialNumber = ObjectUtil.isNotEmpty(dtoParam.getSerialNumber()) ? dtoParam.getSerialNumber() : "";
      List<PurchaseOrder> purchaseOrders;
      if (StrUtil.isBlank(dtoParam.getSerialNumber())) {
         do {
            purchaseOrder.setBoolSysgen(true);
            Preconditions.checkArgument(ObjectUtil.isNotEmpty(dtoParam.getSupplierId()), "请先选择供应商，以此来默认生成采购单编号");
            Integer maxDayNumber = this.queryUtilService.createInboundSerialNumber("scm_purchase_order_operation");
            Supplier supplier = this.supplierService.getById(dtoParam.getSupplierId());
            Preconditions.checkArgument(supplier != null, "新增失败,供应商不存在");
            if (dtoParam.getProjectAttribute().equals(ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType())) {
               serialNumber = "C-"
                  + supplier.getShortName()
                  + "-"
                  + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"))
                  + "-"
                  + (maxDayNumber < 10 ? "0" + maxDayNumber : maxDayNumber + "");
            } else if (dtoParam.getBoolAnnual()) {
               AnnualContract one = this.annualContractService
                  .getOne(
                     (Wrapper<AnnualContract>)((new LambdaQueryWrapper<AnnualContract>()
                              .eq(AnnualContract::getSupplierId, dtoParam.getSupplierId()))
                           .eq(AnnualContract::getStatus, Boolean.FALSE))
                        .ge(AnnualContract::getTimeEnd, LocalDateTime.now())
                  );
               Preconditions.checkArgument(ObjectUtil.isNotEmpty(one), "未查询到年度合同，请重试！！！");
               if (dtoParam.getBasicClass() != null) {
                  List<Integer> BasicClass1 = BasicClassEnum.getNameStr2(one.getBasicClass());
                  List<Integer> BasicClass2 = BasicClassEnum.getNameStr2(dtoParam.getBasicClass());
                  Preconditions.checkArgument(BasicClass1.containsAll(BasicClass2), "采购单所选材料类型该供应商年度合同中不存在，创建失败！！！");
               }

               serialNumber = one.getSerialNumber()
                  + "-"
                  + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"))
                  + "-"
                  + (maxDayNumber < 10 ? "0" + maxDayNumber : maxDayNumber + "");
            } else {
               Integer number = this.numberConfigService.getById(3).getNumber();
               String format = "%0" + number + "d";
               serialNumber = supplier.getShortName()
                  + "-"
                  + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"))
                  + "-"
                  + String.format(format, maxDayNumber + 1)
                  + "";
            }

            purchaseOrders = this.baseMapper.selectList((Wrapper<PurchaseOrder>)new LambdaQueryWrapper<PurchaseOrder>().eq(PurchaseOrder::getSerialNumber, serialNumber));
         } while (!CollectionUtils.isEmpty(purchaseOrders));
      }

      this.checkSerialNumber(serialNumber, purchaseOrder.getId());
      return serialNumber;
   }

   private void checkSerialNumber(String serialNumber, Long id) {
      Integer i = this.baseMapper
         .selectCount(
            (Wrapper<PurchaseOrder>)((Wrappers.<PurchaseOrder>lambdaQuery().eq(PurchaseOrder::getSerialNumber, serialNumber))
                  .ne(ObjectUtil.isNotEmpty(id), PurchaseOrder::getId, id))
               .and(
                  p -> {
                     LambdaQueryWrapper var10000 = ((((((p.eq(
                                          PurchaseOrder::getDataStatus, DataStatusEnum.UNDER_REVIEW.getType()
                                       ))
                                       .or())
                                    .eq(PurchaseOrder::getDataStatus, DataStatusEnum.SUCCEED.getType()))
                                 .or())
                              .eq(PurchaseOrder::getDataStatus, DataStatusEnum.CANCELLATION_UNDER_WAY.getType()))
                           .or())
                        .eq(PurchaseOrder::getBoolTemporaryStorage, Boolean.TRUE);
                  }
               )
         );
      PurchaseOrder purchaseOrderPass = this.baseMapper.selectAgainOrder(serialNumber);
      if (ObjectUtil.isNotEmpty(purchaseOrderPass) || i != 0) {
         Preconditions.checkArgument(false, "添加失败,订单号[" + serialNumber + "]已被使用.");
      }
   }

   private void saveDetailV2(PurchaseOrderDTOParam dtoParam, PurchaseOrder purchaseOrder) {
      if (!CollectionUtil.isEmpty(dtoParam.getList())) {
         List<Long> projectIds = ObjectUtil.isNotEmpty(purchaseOrder.getProjectIds())
            ? Arrays.stream(purchaseOrder.getProjectIds().split(",")).map(Long::parseLong).collect(Collectors.toList())
            : new ArrayList<>();
         List<String> SN = ObjectUtil.isNotEmpty(purchaseOrder.getApplyPurchaseSN())
            ? Arrays.stream(purchaseOrder.getApplyPurchaseSN().split(",")).collect(Collectors.toList())
            : new ArrayList<>();
         List<String> applyPurchaseIds = ObjectUtil.isNotEmpty(purchaseOrder.getApplyPurchaseIds())
            ? Arrays.stream(purchaseOrder.getApplyPurchaseIds().split(",")).collect(Collectors.toList())
            : new ArrayList<>();
         List<String> classifyIds = ObjectUtil.isNotEmpty(purchaseOrder.getClassifyIds())
            ? Arrays.stream(purchaseOrder.getClassifyIds().split(",")).collect(Collectors.toList())
            : new ArrayList<>();
         Map<Long, Classification> classificationMap = new HashMap<>();
         Map<Long, Measure> measureMap = new HashMap<>();
         if (purchaseOrder.getPurchaseType().equals(PurchaseEnum.MATERIAL.getType())) {
            List<ClassificationCheckDTO> classificationCheckDTOS = dtoParam.getList()
               .stream()
               .map(d -> cn.hutool.core.bean.BeanUtil.toBean(d, ClassificationCheckDTO.class))
               .collect(Collectors.toList());
            classificationMap = this.classificationService.checkClassification(classificationCheckDTOS, dtoParam.getClickTime());
            List<Long> classifyIdList = classificationCheckDTOS.stream().map(ClassificationCheckDTO::getClassifyId).distinct().collect(Collectors.toList());
            List<Measure> measures = this.measureService.list((Wrapper<Measure>)new LambdaQueryWrapper<Measure>().in(Measure::getClassificationId, classifyIdList));
            measureMap = measures.stream().collect(Collectors.toMap(Measure::getClassificationId, Function.identity()));
         }

         List<DetailQuantityAndMete> detailQuantityAndMetes = new ArrayList<>();
         Map<Long, DetailQuantityAndMete> detailQuantityAndMeteMap = new HashMap<>();
         if (ObjectUtil.isNotEmpty(purchaseOrder.getPassParentId())) {
            PurchaseOrder byId = this.baseMapper.getById(purchaseOrder.getPassParentId());
            if (ObjectUtil.isNotEmpty(byId.getApplyDetailMeteJson())) {
               List<DetailQuantityAndMete> detailQuantityAndMetesOld = JSONArray.parseArray(byId.getApplyDetailMeteJson(), DetailQuantityAndMete.class);
               detailQuantityAndMeteMap = detailQuantityAndMetesOld.stream().collect(Collectors.toMap(DetailQuantityAndMete::getId, Function.identity()));
            }
         }

         BasicInbound purchaseSpecBasicConf = this.basicConfigService.getPurchaseSpecBasicConf();
         List<ApplyPurchase> applyPurchases = new ArrayList<>();
         List<ApplyPurchaseDetail> applyPurchaseDetails = new ArrayList<>();
         List<PurchaseOrderDetailDTOParam> bindingApplyDetailList = dtoParam.getList()
            .stream()
            .filter(l -> ObjectUtil.isNotEmpty(l.getApplyPurchaseId()))
            .collect(Collectors.toList());
         if (CollectionUtil.isNotEmpty(bindingApplyDetailList)) {
            List<Long> applyIds = bindingApplyDetailList.stream().map(PurchaseOrderDetailDTOParam::getApplyPurchaseId).distinct().collect(Collectors.toList());
            applyPurchases = this.applyPurchaseService.list((Wrapper<ApplyPurchase>)new LambdaQueryWrapper<ApplyPurchase>().in(ApplyPurchase::getId, applyIds));
            applyPurchases.addAll(applyPurchases);
            List<String> applyIdStrs = applyIds.stream().map(String::valueOf).collect(Collectors.toList());
            applyPurchaseIds.addAll(applyIdStrs);
            List<String> applySerialNumber = applyPurchases.stream().map(ApplyPurchase::getSerialNumber).collect(Collectors.toList());
            SN.addAll(applySerialNumber);
            TreeSet<PurchaseOrderDetailDTOParam> purchaseOrderDetailDTOParams = new TreeSet<>(
               Comparator.comparing(PurchaseOrderDetailDTOParam::getApplyPurchaseDetailId)
            );
            purchaseOrderDetailDTOParams.addAll(bindingApplyDetailList);

            for (PurchaseOrderDetailDTOParam purchaseOrderDetailDTOParam : purchaseOrderDetailDTOParams) {
               ApplyPurchaseDetail applyPurchaseDetail = this.applyPurchaseDetailMapper
                  .selectOne(
                     (Wrapper<ApplyPurchaseDetail>)new LambdaQueryWrapper<ApplyPurchaseDetail>()
                        .eq(ApplyPurchaseDetail::getId, purchaseOrderDetailDTOParam.getApplyPurchaseDetailId())
                  );
               Preconditions.checkArgument(ObjectUtil.isNotEmpty(applyPurchaseDetail), "绑定的申购明细不存在！！！");
               ApplyPurchase applyPurchase = applyPurchases.stream()
                  .filter(a -> a.getId().equals(applyPurchaseDetail.getApplyPurchaseId()))
                  .findAny()
                  .orElse(null);
               Preconditions.checkArgument(ObjectUtil.isNotEmpty(applyPurchase), "绑定的申购单不存在或申购发生改变，请刷新页面重试！！！");
               if (ObjectUtil.isNotEmpty(applyPurchase.getPurchaseCreationState())
                  && applyPurchase.getPurchaseCreationState().equals(ApplyPurchaseStateEnum.CREATED.getType())
                  && ObjectUtil.isEmpty(detailQuantityAndMeteMap.get(applyPurchaseDetail.getId()))) {
                  Preconditions.checkArgument(false, applyPurchase.getSerialNumber() + "已完成采购！！！");
               }

               applyPurchaseDetails.add(applyPurchaseDetail);
               List<PurchaseOrderDetailDTOParam> collect = bindingApplyDetailList.stream()
                  .filter(b -> b.getApplyPurchaseDetailId().equals(purchaseOrderDetailDTOParam.getApplyPurchaseDetailId()))
                  .collect(Collectors.toList());
               DetailQuantityAndMete detailQuantityAndMete = detailQuantityAndMeteMap.get(applyPurchaseDetail.getId());
               BigDecimal sumApplyDetailMete = null;
               List<PurchaseOrderDetail> underReviewDetailsByApplyId = this.purchaseOrderDetailMapper
                  .getUnderReviewDetailsByApplyId(applyPurchaseDetail.getId());
               if (purchaseOrder.getPurchaseType().equals(PurchaseEnum.MATERIAL.getType())) {
                  sumApplyDetailMete = collect.stream().map(PurchaseOrderDetailDTOParam::getMete).reduce(BigDecimal.ZERO, BigDecimal::add);
                  BigDecimal addMete = sumApplyDetailMete.add(
                     ObjectUtil.isNotEmpty(applyPurchaseDetail.getProductMete()) ? applyPurchaseDetail.getProductMete() : BigDecimal.ZERO
                  );
                  if (ObjectUtil.isNotEmpty(detailQuantityAndMete)) {
                     addMete = addMete.subtract(detailQuantityAndMete.getMete());
                  }

                  if (purchaseSpecBasicConf.getApplyAndProcureMeteDiffState()) {
                     BigDecimal sumUnderReviewMete = BigDecimal.ZERO;
                     if (CollectionUtil.isNotEmpty(underReviewDetailsByApplyId)) {
                        sumUnderReviewMete = underReviewDetailsByApplyId.stream().map(PurchaseOrderDetail::getMete).reduce(BigDecimal.ZERO, BigDecimal::add);
                     }

                     addMete = addMete.add(sumUnderReviewMete);
                     BigDecimal mete = applyPurchaseDetail.getMete()
                        .multiply(BigDecimal.ONE.add(purchaseSpecBasicConf.getApplyAndProcureMeteDiff().divide(new BigDecimal(100))));
                     Preconditions.checkArgument(
                        mete.compareTo(addMete) > -1,
                        sumUnderReviewMete.compareTo(BigDecimal.ZERO) > 0
                           ? "【审核中核算量 + 已采购量 + 当前采购量】已超出申购量允许误差范围("
                              + purchaseSpecBasicConf.getApplyAndProcureMeteDiff().toPlainString()
                              + "%)，科目名称为："
                              + applyPurchaseDetail.getClassifyName()
                           : "已采购量 + 当前采购量，已超出申购量允许误差范围("
                              + purchaseSpecBasicConf.getApplyAndProcureMeteDiff().toPlainString()
                              + "%)，科目名称为："
                              + applyPurchaseDetail.getClassifyName()
                     );
                  }
               } else if (purchaseOrder.getPurchaseType().equals(PurchaseEnum.FINISHED_GOODS.getType())) {
                  BigDecimal sumApplyDetailQuantity = collect.stream().map(PurchaseOrderDetailDTOParam::getQuantity).reduce(BigDecimal.ZERO, BigDecimal::add);
                  BigDecimal addQuantity = sumApplyDetailQuantity.add(
                     ObjectUtil.isNotEmpty(applyPurchaseDetail.getProductQuantity()) ? applyPurchaseDetail.getProductQuantity() : BigDecimal.ZERO
                  );
                  if (ObjectUtil.isNotEmpty(detailQuantityAndMete)) {
                     addQuantity = addQuantity.subtract(detailQuantityAndMete.getQuantity());
                  }

                  BigDecimal sumUnderReviewQuantity = BigDecimal.ZERO;
                  if (CollectionUtil.isNotEmpty(underReviewDetailsByApplyId)) {
                     sumUnderReviewQuantity = underReviewDetailsByApplyId.stream()
                        .map(PurchaseOrderDetail::getQuantity)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
                  }

                  addQuantity = addQuantity.add(sumUnderReviewQuantity);
                  Preconditions.checkArgument(
                     applyPurchaseDetail.getQuantity().compareTo(addQuantity) > -1,
                     sumUnderReviewQuantity.compareTo(BigDecimal.ZERO) > 0
                        ? "【审核中数量 + 已采购数量 + 当前采购数量】已超出申购数量，科目名称为：" + applyPurchaseDetail.getManufacturedName()
                        : "已采购数量 + 当前采购数量，已超出申购数量，科目名称为：" + applyPurchaseDetail.getManufacturedName()
                  );
               } else {
                  Preconditions.checkArgument(false, "未知采购材料类型！！！");
               }

               BigDecimal sumApplyDetailQuantity = collect.stream()
                  .map(PurchaseOrderDetailDTOParam::getQuantity)
                  .filter(ObjectUtil::isNotEmpty)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               detailQuantityAndMetes.add(
                  DetailQuantityAndMete.builder()
                     .id(applyPurchaseDetail.getId())
                     .quantity(sumApplyDetailQuantity)
                     .mete(sumApplyDetailMete)
                     .classifyId(applyPurchaseDetail.getClassifyId())
                     .build()
               );
            }
         }

         if (purchaseOrder.getPurchaseType().equals(PurchaseEnum.FINISHED_GOODS.getType())) {
            this.insertManufacturedDetail(dtoParam, purchaseOrder, applyPurchases, applyPurchaseDetails, projectIds);
         } else if (purchaseOrder.getPurchaseType().equals(PurchaseEnum.MATERIAL.getType())) {
            for (PurchaseOrderDetailDTOParam detailParam : dtoParam.getList()) {
               PurchaseOrderDetail productDetail = BeanUtil.copy(detailParam, PurchaseOrderDetail.class, "createTime");
               productDetail.setPurchaseId(purchaseOrder.getId());
               String uniqueIdentification = this.creatUniqueIdentification(purchaseOrder.getId(), purchaseOrder.getSerialNumber(), detailParam.getBasicClass());
               productDetail.setUniqueIdentification(uniqueIdentification);
               if (productDetail.getProjectId() != null) {
                  projectIds.add(productDetail.getProjectId());
               }

               if (detailParam.getApplyPurchaseId() != null) {
                  ApplyPurchase applyPurchase = applyPurchases.stream().filter(a -> a.getId().equals(detailParam.getApplyPurchaseId())).findAny().orElse(null);
                  productDetail.setApplyPurchaseSN(applyPurchase.getSerialNumber());
               }

               if (!purchaseOrder.getBoolTemporaryStorage()) {
                  if (!InvoiceTypeEnum.SPECIAL.getType().equals(purchaseOrder.getInvoiceType())
                     && !InvoiceTypeEnum.ORDINARY.getType().equals(purchaseOrder.getInvoiceType())) {
                     productDetail.setAmountExcludingVat(detailParam.getAmount());
                     productDetail.setUnitPriceExcludingVat(detailParam.getUnitPrice());
                  } else {
                     Preconditions.checkArgument(ObjectUtil.isNotEmpty(productDetail.getAmount()), "请传价格信息");
                     BigDecimal value = purchaseOrder.getTaxRate().divide(BigDecimal.valueOf(100L)).add(BigDecimal.ONE);
                     productDetail.setAmountExcludingVat(productDetail.getAmount().divide(value, 2, 4));
                     productDetail.setUnitPriceExcludingVat(
                        productDetail.getAmountExcludingVat()
                           .divide(detailParam.getArtifactEnclosureId() != null ? detailParam.getQuantity() : detailParam.getMete(), 12, 4)
                     );
                     productDetail.setInputVat(productDetail.getAmount().subtract(productDetail.getAmountExcludingVat()));
                  }
               }

               Classification classification = classificationMap.get(detailParam.getClassifyId());
               classifyIds.add(classification.getId().toString());
               if (!purchaseOrder.getBoolTemporaryStorage()) {
                  Measure measure = measureMap.get(detailParam.getClassifyId());
                  if (!BasicClassEnum.checkIsSteel(measure.getBasicClass()) && measure.getOutboundUnitType().equals(MeasureTypeEnum.MEASURE.getType())) {
                     Preconditions.checkArgument(ObjectUtil.isNotEmpty(productDetail.getQuantity()), classification.getName() + "为计量方式，但未提交数量，请检查该科目计量配置！！！");
                  }

                  if (measure.getOutboundUnitType().equals(MeasureTypeEnum.ACCOUNTING.getType())) {
                     Preconditions.checkArgument(ObjectUtil.isEmpty(productDetail.getQuantity()), classification.getName() + "为核算方式，但提交了数量，请检查该科目计量配置！！！");
                  }
               }

               productDetail.setDoNotSectionSteelSpec(
                  ObjectUtil.isNotEmpty(detailParam.getDoNotSectionSteelSpec()) ? detailParam.getDoNotSectionSteelSpec() : detailParam.getSpecification()
               );
               StringBuilder specification = new StringBuilder();
               if (BasicClassEnum.SECTION_STEEL.getType().equals(detailParam.getBasicClass())) {
                  String sn = "";
                  String specCode = "";
                  Preconditions.checkArgument(ObjectUtil.isNotEmpty(detailParam.getSectionSteelSpec()), "该型材未配置国标规格");
                  SectionSteelSpec sectionSteelSpec = this.sectionSteelSpecService
                     .getOne(
                        (Wrapper<SectionSteelSpec>)(Wrappers.<SectionSteelSpec>lambdaQuery()
                              .eq(SectionSteelSpec::getClassificationId, classification.getId()))
                           .eq(SectionSteelSpec::getSpecification, detailParam.getSectionSteelSpec())
                     );
                  Preconditions.checkArgument(sectionSteelSpec != null, "当前型材库规格为[" + detailParam.getSectionSteelSpec() + "]的型材不存在.");
                  if (ObjectUtil.isEmpty(detailParam.getApplyPurchaseDetailId())) {
                     Preconditions.checkArgument(sectionSteelSpec.getStatus(), "当前型材库规格为[" + detailParam.getSectionSteelSpec() + "]的型材已禁用.");
                  }

                  SectionSteelSpecStandardDetail standardDetail = this.sectionSteelSpecStandardDetailService
                     .getOne(
                        (Wrapper<SectionSteelSpecStandardDetail>)((Wrappers.<SectionSteelSpecStandardDetail>lambdaQuery()
                                 .eq(SectionSteelSpecStandardDetail::getSpecId, sectionSteelSpec.getId()))
                              .eq(SectionSteelSpecStandardDetail::getStandardId, detailParam.getStandardId()))
                           .eq(SectionSteelSpecStandardDetail::getSectionSteelId, sectionSteelSpec.getSectionSteelId())
                     );
                  Preconditions.checkArgument(ObjectUtil.isNotEmpty(standardDetail), "采购失败," + classification.getName() + "未查询到型材规格国标重量");
                  Preconditions.checkArgument(
                     standardDetail.getUnitNet() != null && standardDetail.getUnitNet().compareTo(BigDecimal.ZERO) > 0, "入库失败,当前型材规格未配置国标重量"
                  );
                  Standard standard = this.standardService.getById(standardDetail.getStandardId());
                  sn = standard.getCode() + "-" + standardDetail.getCode();
                  productDetail.setStandardId(standard.getId());
                  productDetail.setSectionSteelSpecId(sectionSteelSpec.getId());
                  productDetail.setSectionSteelSpec(sectionSteelSpec.getSpecification());
                  productDetail.setDoNotSectionSteelSpec(detailParam.getDoNotSectionSteelSpec());
                  if (ObjectUtil.isNotEmpty(detailParam.getDoNotSectionSteelSpec())) {
                     Map<String, String> map = this.specificationService.checkClassifySpec(detailParam.getClassifyId(), detailParam.getDoNotSectionSteelSpec());
                     specCode = map.get("code");
                     specification.append(map.get("ids"));
                  }

                  productDetail.setMaterialSn(classification.getSerialNumber() + "-" + sn + specCode);
               } else {
                  Map<String, String> map = this.specificationService.checkClassifySpec(detailParam.getClassifyId(), detailParam.getSpecification());
                  String specCode = map.get("code");
                  specification.append(map.get("ids"));
                  productDetail.setMaterialSn(classification.getSerialNumber() + (StrUtil.isNotBlank(specCode) ? "-" + specCode : ""));
               }

               productDetail.setSpecificationIds(specification.toString());
               this.purchaseOrderDetailMapper.insert(productDetail);
            }
         } else {
            Preconditions.checkArgument(false, "未知采购材料类型！！！");
         }

         if (CollectionUtils.isNotEmpty(classifyIds)) {
            classifyIds = classifyIds.stream().distinct().collect(Collectors.toList());
            purchaseOrder.setClassifyIds(StringUtils.list2String(classifyIds, ","));
         }

         if (CollectionUtils.isNotEmpty(applyPurchaseIds)) {
            List<String> applyPurchaseIdsDistinct = applyPurchaseIds.stream().distinct().collect(Collectors.toList());
            purchaseOrder.setApplyPurchaseIds(StrUtil.join(",", applyPurchaseIdsDistinct));
         }

         if (CollectionUtils.isNotEmpty(SN)) {
            List<String> SNDistinct = SN.stream().distinct().collect(Collectors.toList());
            purchaseOrder.setApplyPurchaseSN(StrUtil.join(",", SNDistinct));
         }

         if (CollectionUtils.isNotEmpty(projectIds)) {
            ArrayList<Long> distinct = CollectionUtil.distinct(projectIds);
            purchaseOrder.setProjectIds(StrUtil.join(",", distinct));
         }

         if (CollectionUtils.isNotEmpty(detailQuantityAndMetes)) {
            String jsonString = JSON.toJSONString(detailQuantityAndMetes);
            purchaseOrder.setApplyDetailMeteJson(jsonString);
         }
      }
   }

   private void insertManufacturedDetail(
      PurchaseOrderDTOParam dtoParam,
      PurchaseOrder purchaseOrder,
      List<ApplyPurchase> applyPurchases,
      List<ApplyPurchaseDetail> applyPurchaseDetails,
      List<Long> projectIds
   ) {
      for (PurchaseOrderDetailDTOParam detailParam : dtoParam.getList()) {
         ApplyPurchase applyPurchase = applyPurchases.stream().filter(a -> a.getId().equals(detailParam.getApplyPurchaseId())).findAny().orElse(null);
         ApplyPurchaseDetail applyPurchaseDetail = applyPurchaseDetails.stream()
            .filter(a -> a.getId().equals(detailParam.getApplyPurchaseDetailId()))
            .findAny()
            .orElse(null);
         PurchaseOrderDetail productDetail = PurchaseOrderDetail.builder()
            .purchaseId(purchaseOrder.getId())
            .applyPurchaseId(ObjectUtil.isNotEmpty(applyPurchase) ? applyPurchase.getId() : null)
            .applyPurchaseSN(ObjectUtil.isNotEmpty(applyPurchase) ? applyPurchase.getSerialNumber() : null)
            .applyPurchaseDetailId(ObjectUtil.isNotEmpty(applyPurchaseDetail) ? applyPurchaseDetail.getId() : null)
            .artifactEnclosureId(ObjectUtil.isNotEmpty(applyPurchaseDetail) ? applyPurchaseDetail.getArtifactEnclosureId() : null)
            .basicClass(ObjectUtil.isNotEmpty(applyPurchaseDetail) ? applyPurchaseDetail.getBasicClass() : detailParam.getBasicClass())
            .specification(ObjectUtil.isNotEmpty(applyPurchaseDetail) ? applyPurchaseDetail.getSpecification() : detailParam.getSpecification())
            .color(ObjectUtil.isNotEmpty(applyPurchaseDetail) ? applyPurchaseDetail.getColor() : detailParam.getColor())
            .length(ObjectUtil.isNotEmpty(applyPurchaseDetail) ? applyPurchaseDetail.getLength() : detailParam.getLength())
            .width(ObjectUtil.isNotEmpty(applyPurchaseDetail) ? applyPurchaseDetail.getWidth() : detailParam.getWidth())
            .thickness(ObjectUtil.isNotEmpty(applyPurchaseDetail) ? applyPurchaseDetail.getThickness() : detailParam.getThickness())
            .surfaceArea(ObjectUtil.isNotEmpty(applyPurchaseDetail) ? applyPurchaseDetail.getSurfaceArea() : detailParam.getSurfaceArea())
            .brand(ObjectUtil.isNotEmpty(applyPurchaseDetail) ? applyPurchaseDetail.getBrand() : detailParam.getBrand())
            .projectId(ObjectUtil.isNotEmpty(applyPurchaseDetail) ? applyPurchaseDetail.getProjectId() : detailParam.getProjectId())
            .monomerId(ObjectUtil.isNotEmpty(applyPurchaseDetail) ? applyPurchaseDetail.getMonomerId() : detailParam.getMonomerId())
            .areaId(ObjectUtil.isNotEmpty(applyPurchaseDetail) ? applyPurchaseDetail.getAreaId() : detailParam.getAreaId())
            .weight(ObjectUtil.isNotEmpty(applyPurchaseDetail) ? applyPurchaseDetail.getWeight() : detailParam.getWeight())
            .manufacturedName(ObjectUtil.isNotEmpty(applyPurchaseDetail) ? applyPurchaseDetail.getManufacturedName() : detailParam.getManufacturedName())
            .manufacturedType(ObjectUtil.isNotEmpty(applyPurchaseDetail) ? applyPurchaseDetail.getManufacturedType() : detailParam.getManufacturedType())
            .manufacturedSn(ObjectUtil.isNotEmpty(applyPurchaseDetail) ? applyPurchaseDetail.getManufacturedSn() : detailParam.getManufacturedSn())
            .manufacturedUnit(applyPurchaseDetail.getManufacturedUnit())
            .material(ObjectUtil.isNotEmpty(applyPurchaseDetail) ? applyPurchaseDetail.getMaterial() : detailParam.getMaterial())
            .finishedGoodsTypeName(detailParam.getFinishedGoodsTypeName())
            .manufacturedSpecification(detailParam.getManufacturedSpecification())
            .factoryId(detailParam.getFactoryId())
            .quantity(detailParam.getQuantity())
            .unitPrice(detailParam.getUnitPrice())
            .wageQuotaType(detailParam.getWageQuotaType())
            .boolOriginalDetail(ObjectUtil.isNotEmpty(detailParam.getBoolOriginalDetail()) ? detailParam.getBoolOriginalDetail() : null)
            .build();
         Preconditions.checkArgument(ObjectUtil.isNotEmpty(productDetail.getUnitPrice()), "请传价格信息");
         String uniqueIdentification = this.creatUniqueIdentification(
            purchaseOrder.getId(), purchaseOrder.getSerialNumber(), applyPurchaseDetail.getBasicClass()
         );
         productDetail.setUniqueIdentification(uniqueIdentification);
         if (ObjectUtil.isNotEmpty(productDetail.getLength())) {
            BigDecimal totalLength = productDetail.getQuantity().multiply(productDetail.getLength());
            productDetail.setTotalLength(totalLength);
         }

         if (ObjectUtil.isNotEmpty(productDetail.getSurfaceArea())) {
            BigDecimal totalArea = productDetail.getQuantity().multiply(productDetail.getSurfaceArea());
            productDetail.setTotalArea(totalArea);
         }

         if (ObjectUtil.isNotEmpty(productDetail.getWeight())) {
            BigDecimal totalWeight = productDetail.getQuantity().multiply(productDetail.getWeight());
            productDetail.setTotalWeight(totalWeight);
         }

         BigDecimal amount = new BigDecimal(0);
         if (productDetail.getWageQuotaType().equals(WmsWageQuotaTypeEnum.WMS_WEIGHT_PRICE.getType())) {
            Preconditions.checkArgument(ObjectUtil.isNotEmpty(productDetail.getTotalWeight()), "重量不存在，不可为重量计价！！！");
            amount = productDetail.getUnitPrice().multiply(productDetail.getTotalWeight());
         } else if (productDetail.getWageQuotaType().equals(WmsWageQuotaTypeEnum.WMS_LENGTH_PRICE.getType())) {
            Preconditions.checkArgument(ObjectUtil.isNotEmpty(productDetail.getTotalLength()), "长度不存在，不可为长度计价！！！");
            amount = productDetail.getUnitPrice().multiply(productDetail.getTotalLength());
         } else if (productDetail.getWageQuotaType().equals(WmsWageQuotaTypeEnum.WMS_AREA_PRICE.getType())) {
            Preconditions.checkArgument(ObjectUtil.isNotEmpty(productDetail.getTotalArea()), "面积不存在，不可为面积计价！！！");
            amount = productDetail.getUnitPrice().multiply(productDetail.getTotalArea());
         } else if (productDetail.getWageQuotaType().equals(WmsWageQuotaTypeEnum.WMS_QUANTITY_PRICE.getType())) {
            Preconditions.checkArgument(ObjectUtil.isNotEmpty(productDetail.getQuantity()), "数量不存在，不可为数量计价！！！");
            amount = productDetail.getUnitPrice().multiply(productDetail.getQuantity());
         } else {
            Preconditions.checkArgument(false, "未知计价方式");
         }

         productDetail.setAmount(amount);
         if (!InvoiceTypeEnum.SPECIAL.getType().equals(purchaseOrder.getInvoiceType())
            && !InvoiceTypeEnum.ORDINARY.getType().equals(purchaseOrder.getInvoiceType())) {
            productDetail.setAmountExcludingVat(detailParam.getAmount());
            productDetail.setUnitPriceExcludingVat(detailParam.getUnitPrice());
         } else {
            BigDecimal value = purchaseOrder.getTaxRate().divide(BigDecimal.valueOf(100L)).add(BigDecimal.ONE);
            productDetail.setAmountExcludingVat(productDetail.getAmount().divide(value, 2, 4));
            if (productDetail.getWageQuotaType().equals(WmsWageQuotaTypeEnum.WMS_WEIGHT_PRICE.getType())) {
               productDetail.setUnitPriceExcludingVat(productDetail.getAmountExcludingVat().divide(productDetail.getTotalWeight(), 12, 4));
            } else if (productDetail.getWageQuotaType().equals(WmsWageQuotaTypeEnum.WMS_LENGTH_PRICE.getType())) {
               productDetail.setUnitPriceExcludingVat(productDetail.getAmountExcludingVat().divide(productDetail.getTotalLength(), 12, 4));
            } else if (productDetail.getWageQuotaType().equals(WmsWageQuotaTypeEnum.WMS_AREA_PRICE.getType())) {
               productDetail.setUnitPriceExcludingVat(productDetail.getAmountExcludingVat().divide(productDetail.getTotalArea(), 12, 4));
            } else if (productDetail.getWageQuotaType().equals(WmsWageQuotaTypeEnum.WMS_QUANTITY_PRICE.getType())) {
               productDetail.setUnitPriceExcludingVat(productDetail.getAmountExcludingVat().divide(productDetail.getQuantity(), 12, 4));
            }

            productDetail.setInputVat(productDetail.getAmount().subtract(productDetail.getAmountExcludingVat()));
         }

         if (productDetail.getProjectId() != null) {
            projectIds.add(productDetail.getProjectId());
         }

         this.purchaseOrderDetailMapper.insert(productDetail);
      }
   }

   @Override
   public Map<String, Object> getStatisticsV2(List<LocalDateTime> createTime) {
      int annualPurchaseQuantity = 0;
      BigDecimal contractAmount = BigDecimal.ZERO;
      int progressOrder = 0;
      int settlementOrder = 0;
      int notSettlementOrder = 0;
      int newThisMonth = 0;
      LocalDate currentDate = LocalDate.now();
      List<PurchaseOrder> purchaseOrders = this.baseMapper
         .selectList((Wrapper<PurchaseOrder>)new LambdaQueryWrapper<PurchaseOrder>().eq(PurchaseOrder::getProjectAttribute, ProjectAttributeEnum.SELF_SUPPORT.getType()));

      for (PurchaseOrder purchaseOrder : this.baseMapper.purchaseCount(createTime)) {
         if (purchaseOrder.getReviewPassTime() != null) {
            if (DataStatusEnum.SUCCEED.getType().equals(purchaseOrder.getDataStatus())
               || DataStatusEnum.CANCELLATION_UNDER_WAY.getType().equals(purchaseOrder.getDataStatus())) {
               annualPurchaseQuantity++;
            }

            if (SettlementStatusEnum.SETTLED.getType().equals(purchaseOrder.getSettlementStatus())
               && DataStatusEnum.SUCCEED.getType().equals(purchaseOrder.getDataStatus())) {
               settlementOrder++;
            }

            if (SettlementStatusEnum.UN_SETTLED.getType().equals(purchaseOrder.getSettlementStatus())
               && DataStatusEnum.SUCCEED.getType().equals(purchaseOrder.getDataStatus())) {
               notSettlementOrder++;
            }

            if (PurchaseStatusEnum.DURING.getType().equals(purchaseOrder.getPurchaseStatus())
               && (
                  DataStatusEnum.SUCCEED.getType().equals(purchaseOrder.getDataStatus())
                     || DataStatusEnum.CANCELLATION_UNDER_WAY.getType().equals(purchaseOrder.getDataStatus())
               )) {
               progressOrder++;
            }

            if (DataStatusEnum.SUCCEED.getType().equals(purchaseOrder.getDataStatus())) {
               contractAmount = purchaseOrder.getAmount() != null ? purchaseOrder.getAmount().add(contractAmount) : BigDecimal.ZERO.add(contractAmount);
            }
         }
      }

      for (PurchaseOrder order : purchaseOrders) {
         if (order.getReviewPassTime() != null
            && (DataStatusEnum.SUCCEED.getType().equals(order.getDataStatus()) || DataStatusEnum.CANCELLATION_UNDER_WAY.getType().equals(order.getDataStatus()))
            && currentDate.getYear() == order.getReviewPassTime().getYear()
            && currentDate.getMonth() == order.getReviewPassTime().getMonth()) {
            newThisMonth++;
         }
      }

      Map<String, Object> map = new HashMap<>();
      map.put("annualPurchaseQuantity", annualPurchaseQuantity);
      map.put("contractAmount", contractAmount);
      map.put("processingOrder", progressOrder);
      map.put("settlementOrder", settlementOrder);
      map.put("notSettlementOrder", notSettlementOrder);
      map.put("newThisMonth", newThisMonth);
      return map;
   }

   @Override
   public List<PurchaseOrderDTO> StagingList(Integer boolTemporaryStorage, List<Integer> projectAttribute) {
      SecurityUser currentUser = UserUtil.getCurrentUser();
      List<PurchaseOrder> purchaseOrders = this.baseMapper
         .selectList(
            (Wrapper<PurchaseOrder>)((Wrappers.<PurchaseOrder>lambdaQuery()
                     .eq(boolTemporaryStorage.equals(1), PurchaseOrder::getBoolTemporaryStorage, boolTemporaryStorage))
                  .eq(PurchaseOrder::getApplicantId, currentUser.getId()))
               .in(PurchaseOrder::getProjectAttribute, projectAttribute)
         );
      List<PurchaseOrderDTO> purchaseOrderDTOS = new ArrayList<>();

      for (PurchaseOrder purchaseOrder : purchaseOrders) {
         PurchaseOrderDTO copy = BeanUtil.copy(purchaseOrder, PurchaseOrderDTO.class);
         if (StrUtil.isNotBlank(purchaseOrder.getApplyPurchaseSN())) {
            copy.setApplyPurchaseSN(Arrays.asList((String[])purchaseOrder.getApplyPurchaseSN().split(",").clone()));
         }

         if (StrUtil.isNotBlank(purchaseOrder.getProjectIds())) {
            List<ProjectInfo> projectInfos = this.contractProjectService.listByIds(purchaseOrder.getProjectIds());
            if (BasicClassEnum.STRUC_MANUFACTURED.getType().equals(purchaseOrder.getBasicClass())) {
               copy.setProject(projectInfos.get(0));
            } else {
               copy.setProjects(projectInfos);
            }
         }

         if (purchaseOrder.getSupplierId() != null) {
            Supplier supplier = this.supplierService.getById(purchaseOrder.getSupplierId());
            copy.setSupplier(BriefIdAndNameDTO.builder().id(supplier.getId()).name(supplier.getName()).shortName(supplier.getShortName()).build());
         }

         if (purchaseOrder.getBranchCompanyId() != null) {
            BranchCompany branchCompany = this.branchCompanyService.getById(purchaseOrder.getBranchCompanyId());
            copy.setBranchCompany(BriefIdAndNameDTO.builder().id(branchCompany.getId()).name(branchCompany.getName()).build());
         }

         if (!purchaseOrder.getProjectAttribute().equals(ProjectAttributeEnum.SELF_SUPPORT.getType()) && purchaseOrder.getProjectManagerId() != null) {
            User user = this.userService.getById(purchaseOrder.getProjectManagerId());
            copy.setProjectManager(com.hzchum.scim.common.core.api.pojo.common.IdAndNameDTO.builder().id(user.getId()).name(user.getName()).build());
         }

         if (purchaseOrder.getWorkshopId() != null) {
            MesBuildingWorkshop mesWorkshop = this.mesWorkshopService.getWorkshopById(purchaseOrder.getWorkshopId());
            copy.setMesWorkshop(com.hzchum.scim.common.core.api.pojo.common.IdAndNameDTO.builder().id(mesWorkshop.getId()).name(mesWorkshop.getName()).build());
         }

         List<PurchaseOrderDetail> purchaseOrderDetails = this.purchaseOrderDetailMapper
            .selectList(Wrappers.<PurchaseOrderDetail>lambdaQuery().eq(true, PurchaseOrderDetail::getPurchaseId, purchaseOrder.getId()));
         if (purchaseOrderDetails.size() > 0) {
            for (PurchaseOrderDetail purchaseOrderDetail : purchaseOrderDetails) {
               PurchaseOrderDetailDTO copy1 = BeanUtil.copy(purchaseOrderDetail, PurchaseOrderDetailDTO.class);
               if (purchaseOrderDetail.getProjectId() != null && !purchaseOrderDetail.getProjectId().equals(-1L)) {
                  ContractProject project = this.contractProjectService.getById(purchaseOrderDetail.getProjectId());
                  copy1.setProject(ProjectInfo.builder().id(project.getId()).name(project.getName()).shortName(project.getShortName()).build());
               }

               List<PurchaseOrderDetailDTO> purchaseOrderDetailDTOS = new ArrayList<>();
               purchaseOrderDetailDTOS.add(copy1);
               copy.setPurchaseOrderDetailDTOS(purchaseOrderDetailDTOS);
            }
         }

         purchaseOrderDTOS.add(copy);
      }

      return purchaseOrderDTOS;
   }

   @Override
   public Integer StagingListCount(Integer boolTemporaryStorage, List<Integer> projectAttribute) {
      SecurityUser currentUser = UserUtil.getCurrentUser();
      return this.baseMapper
         .selectCount(
            (Wrapper<PurchaseOrder>)((Wrappers.<PurchaseOrder>lambdaQuery()
                     .eq(PurchaseOrder::getBoolTemporaryStorage, boolTemporaryStorage))
                  .eq(PurchaseOrder::getApplicantId, currentUser.getId()))
               .in(PurchaseOrder::getProjectAttribute, projectAttribute)
         );
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean deleteStagingPurchaseOrder(List<Integer> projectAttribute) {
      SecurityUser currentUser = UserUtil.getCurrentUser();

      for (PurchaseOrder purchaseOrder : this.baseMapper
         .selectList(
            (Wrapper<PurchaseOrder>)((new LambdaQueryWrapper<PurchaseOrder>().eq(PurchaseOrder::getBoolTemporaryStorage, 1))
                  .eq(PurchaseOrder::getApplicantId, currentUser.getId()))
               .in(PurchaseOrder::getProjectAttribute, projectAttribute)
         )) {
         Preconditions.checkArgument(purchaseOrder.getBoolTemporaryStorage(), "采购单【" + purchaseOrder.getSerialNumber() + "】暂存状态发生变化！！！");
         List<PurchaseOrderDetail> purchaseOrderDetails = this.purchaseOrderDetailMapper
            .selectList((Wrapper<PurchaseOrderDetail>)new LambdaQueryWrapper<PurchaseOrderDetail>().eq(PurchaseOrderDetail::getPurchaseId, purchaseOrder.getId()));
         IdsStatusDTO idsStatusDTO = new IdsStatusDTO();
         if (ObjectUtil.isNotEmpty(purchaseOrder.getClassifyIds())) {
            idsStatusDTO.setIdsStr(purchaseOrder.getClassifyIds());
         } else {
            List<Long> classifyIds = purchaseOrderDetails.stream().map(PurchaseOrderDetail::getClassifyId).collect(Collectors.toList());
            idsStatusDTO.setIds(classifyIds);
         }

         this.purchaseOrderDetailMapper
            .delete((Wrapper<PurchaseOrderDetail>)new LambdaQueryWrapper<PurchaseOrderDetail>().eq(PurchaseOrderDetail::getPurchaseId, purchaseOrder.getId()));
         this.classificationService.deleteDataUpdateClass(idsStatusDTO);
         this.baseMapper.deleteById(purchaseOrder.getId());
      }

      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean deleteByIdStagingPurchaseOrder(List<Long> ids) {
      for (Long id : ids) {
         PurchaseOrder purchaseOrder = this.baseMapper.selectById(id);
         Preconditions.checkArgument(purchaseOrder.getBoolTemporaryStorage(), "采购单【" + purchaseOrder.getSerialNumber() + "】暂存状态发生变化！！！");
         List<PurchaseOrderDetail> list = this.purchaseOrderDetailMapper
            .selectList(new LambdaQueryWrapper<PurchaseOrderDetail>().eq(id != null, PurchaseOrderDetail::getPurchaseId, id));
         IdsStatusDTO idsStatusDTO = new IdsStatusDTO();
         if (ObjectUtil.isNotEmpty(purchaseOrder.getClassifyIds())) {
            idsStatusDTO.setIdsStr(purchaseOrder.getClassifyIds());
         } else {
            List<Long> classifyIds = list.stream().map(PurchaseOrderDetail::getClassifyId).collect(Collectors.toList());
            idsStatusDTO.setIds(classifyIds);
         }

         this.purchaseOrderDetailMapper.delete((Wrapper<PurchaseOrderDetail>)Wrappers.<PurchaseOrderDetail>lambdaQuery().eq(PurchaseOrderDetail::getPurchaseId, id));
         this.classificationService.deleteDataUpdateClass(idsStatusDTO);
         this.baseMapper.deleteById(id);
      }

      return true;
   }

   @Override
   public BriefPurchaseOrderDTO selectByIdPurchaseOrder(Long id) {
      PurchaseOrder purchaseOrder = this.baseMapper.getById(id);
      BriefPurchaseOrderDTO orderDTO = BeanUtil.copy(purchaseOrder, BriefPurchaseOrderDTO.class);
      Map<Long, User> userMap = this.userService.list().stream().collect(Collectors.toMap(User::getId, Function.identity()));
      if (purchaseOrder.getSupplierId() != null) {
         Supplier supplier = this.supplierService.getById(purchaseOrder.getSupplierId());
         orderDTO.setSupplier(BriefIdAndNameDTO.builder().id(supplier.getId()).name(supplier.getName()).shortName(supplier.getShortName()).build());
      }

      BranchCompany branchCompany = this.branchCompanyService.getById(purchaseOrder.getBranchCompanyId());
      if (ObjectUtil.isNotEmpty(branchCompany)) {
         orderDTO.setBranchCompany(BriefIdAndNameDTO.builder().id(branchCompany.getId()).name(branchCompany.getName()).build());
      }

      if (StrUtil.isNotBlank(purchaseOrder.getApplyPurchaseIds())) {
         List<Long> ids = CommonUtil.spilt(purchaseOrder.getApplyPurchaseIds(), ",");
         orderDTO.setApplyPurchase(
            this.applyPurchaseService
               .listByIds(ids)
               .stream()
               .map(l -> BriefIdAndSNDTO.builder().id(l.getId()).serialNumber(l.getSerialNumber()).build())
               .collect(Collectors.toList())
         );
      }

      if (StrUtil.isNotBlank(purchaseOrder.getAttachments())) {
         orderDTO.setAttachments(this.attachmentService.listByIds(purchaseOrder.getAttachments()));
      }

      if (StrUtil.isNotBlank(purchaseOrder.getAuxMaterialIds())) {
         orderDTO.setAuxMaterialIds(CommonUtil.spilt(purchaseOrder.getAuxMaterialIds(), ","));
         String auxMaterialNames = this.classificationService
            .listByIds(orderDTO.getAuxMaterialIds())
            .stream()
            .map(Classification::getName)
            .collect(Collectors.joining(","));
         orderDTO.setAuxMaterialNames(auxMaterialNames);
      }

      if (StrUtil.isNotBlank(purchaseOrder.getOtherMaterialIds())) {
         orderDTO.setOtherMaterialIds(CommonUtil.spilt(purchaseOrder.getOtherMaterialIds(), ","));
         String otherMaterialNames = this.classificationService
            .listByIds(orderDTO.getOtherMaterialIds())
            .stream()
            .map(Classification::getName)
            .collect(Collectors.joining(","));
         orderDTO.setOtherMaterialNames(otherMaterialNames);
      }

      if (StrUtil.isNotBlank(purchaseOrder.getGasMaterialIds())) {
         orderDTO.setGasMaterialIds(CommonUtil.spilt(purchaseOrder.getGasMaterialIds(), ","));
         String gasMaterialNames = this.classificationService
            .listByIds(orderDTO.getGasMaterialIds())
            .stream()
            .map(Classification::getName)
            .collect(Collectors.joining(","));
         orderDTO.setGasMaterialNames(gasMaterialNames);
      }

      if (!purchaseOrder.getProjectAttribute().equals(ProjectAttributeEnum.SELF_SUPPORT.getType()) && purchaseOrder.getProjectManagerId() != null) {
         User user = this.userService.getById(purchaseOrder.getProjectManagerId());
         orderDTO.setProjectManager(IdAndNameDTO.builder().id(user.getId()).name(user.getName()).build());
      }

      if (StrUtil.isNotBlank(purchaseOrder.getProjectIds())) {
         orderDTO.setProjects(this.contractProjectService.listByIds(purchaseOrder.getProjectIds()));
      }

      new ArrayList();
      List<PurchaseOrderDetail> var21;
      if (ObjectUtil.isNotEmpty(purchaseOrder.getDetailIds())) {
         List<Long> collect1 = Arrays.stream(purchaseOrder.getDetailIds().split(",")).map(Long::valueOf).collect(Collectors.toList());
         var21 = this.purchaseOrderDetailMapper.selectBatchIds(collect1);
         var21.forEach(p -> p.setPurchaseId(purchaseOrder.getId()));
      } else {
         var21 = this.purchaseOrderDetailMapper
            .selectList((Wrapper<PurchaseOrderDetail>)new LambdaQueryWrapper<PurchaseOrderDetail>().eq(PurchaseOrderDetail::getPurchaseId, purchaseOrder.getId()));
      }

      if (purchaseOrder.getWorkshopId() != null) {
         MesBuildingWorkshop workshopById = this.mesWorkshopService.getWorkshopById(purchaseOrder.getWorkshopId());
         orderDTO.setMesWorkshop(IdAndNameDTO.builder().id(workshopById.getId()).name(workshopById.getName()).build());
      }

      Boolean boolUsed = false;
      List<InboundDetail> inboundDetailList = this.inboundDetailService.getInboundDetailList(purchaseOrder.getId(), null, ReviewStatusEnum.AUDITING.getType());
      List<InboundDetailManufactured> inboundDetailManufacturedList = this.inboundDetailManufacturedService
         .getInboundDetailManufacturedList(purchaseOrder.getId(), null, ReviewStatusEnum.AUDITING.getType());
      if (var21.size() > 0) {
         List<PurchaseOrderDetailDTO> purchaseOrderDetailDTOS = new ArrayList<>();

         for (PurchaseOrderDetail purchaseOrderDetail : var21) {
            PurchaseOrderDetailDTO purchaseOrderDetailDTO = BeanUtil.copy(purchaseOrderDetail, PurchaseOrderDetailDTO.class);
            if (purchaseOrderDetailDTO.getProjectId() != null && !purchaseOrderDetail.getProjectId().equals(-1L)) {
               ContractProject contractProject = this.contractProjectService.getById(purchaseOrderDetail.getProjectId());
               purchaseOrderDetailDTO.setProject(
                  ProjectInfo.builder()
                     .id(contractProject.getId())
                     .name(contractProject.getName())
                     .shortName(contractProject.getShortName())
                     .serialNumber(contractProject.getSerialNumber())
                     .build()
               );
            }

            if (purchaseOrderDetail.getFactoryId() != null) {
               MesBuildingFactory factory = this.factoryService.getById(purchaseOrderDetail.getFactoryId());
               BuildingFactoryDTO build = BuildingFactoryDTO.builder().id(factory.getId()).name(factory.getName()).shortName(factory.getShortName()).build();
               purchaseOrderDetailDTO.setFactoryDTO(build);
            }

            if (ObjectUtil.isNotEmpty(purchaseOrderDetail.getMonomerId())) {
               PlanMonomer byId = this.planMonomerService.getById(purchaseOrderDetail.getMonomerId());
               purchaseOrderDetailDTO.setMonomer(NameInfo.builder().id(byId.getId()).name(byId.getName()).build());
            }

            if (ObjectUtil.isNotEmpty(purchaseOrderDetail.getAreaId())) {
               PlanArea byId = this.planAreaService.getById(purchaseOrderDetail.getAreaId());
               purchaseOrderDetailDTO.setArea(NameInfo.builder().id(byId.getId()).name(byId.getName()).build());
            }

            if (ObjectUtil.isNotEmpty(purchaseOrderDetail.getApplyPurchaseDetailId())) {
               ApplyPurchaseDetail applyPurchaseDetail = this.applyPurchaseDetailMapper.selectById(purchaseOrderDetail.getApplyPurchaseDetailId());
               purchaseOrderDetailDTO.setApplyPurchaseQuantity(applyPurchaseDetail.getQuantity());
               purchaseOrderDetailDTO.setApplyPurchaseMete(applyPurchaseDetail.getMete());
               purchaseOrderDetailDTO.setProductQuantity(applyPurchaseDetail.getProductQuantity());
               purchaseOrderDetailDTO.setProductMete(applyPurchaseDetail.getProductMete());
            }

            if (ObjectUtil.isNotEmpty(purchaseOrderDetail.getWorkshopId()) && !purchaseOrderDetail.getWorkshopId().equals(-1L)) {
               Workshop workshop = this.workshopService.getById(purchaseOrderDetail.getWorkshopId());
               purchaseOrderDetailDTO.setWorkshop(
                  com.hzchum.scim.common.core.api.pojo.common.IdAndNameDTO.builder().id(workshop.getId()).name(workshop.getName()).build()
               );
            }

            purchaseOrderDetailDTO.setBoolUsed(false);
            if (purchaseOrder.getPurchaseType().equals(PurchaseEnum.MATERIAL.getType())) {
               if (purchaseOrderDetail.getInboundMete().compareTo(BigDecimal.ZERO) > 0) {
                  purchaseOrderDetailDTO.setBoolUsed(true);
                  boolUsed = true;
               } else {
                  List<InboundDetail> collect = inboundDetailList.stream()
                     .filter(inboundDetail -> inboundDetail.getPurchaseOrderDetailId().equals(purchaseOrderDetail.getId()))
                     .collect(Collectors.toList());
                  if (CollectionUtil.isNotEmpty(collect)) {
                     purchaseOrderDetailDTO.setBoolUsed(true);
                     boolUsed = true;
                  }
               }
            } else if (purchaseOrder.getPurchaseType().equals(PurchaseEnum.FINISHED_GOODS.getType())) {
               if (purchaseOrderDetail.getInboundQuantity().compareTo(BigDecimal.ZERO) > 0) {
                  purchaseOrderDetailDTO.setBoolUsed(true);
                  boolUsed = true;
               } else {
                  List<InboundDetailManufactured> collect = inboundDetailManufacturedList.stream()
                     .filter(inboundDetailManufactured -> inboundDetailManufactured.getPurchaseOrderDetailId().equals(purchaseOrderDetail.getId()))
                     .collect(Collectors.toList());
                  if (CollectionUtil.isNotEmpty(collect)) {
                     purchaseOrderDetailDTO.setBoolUsed(true);
                     boolUsed = true;
                  }
               }
            }

            if (purchaseOrderDetail.getReceivedMete().compareTo(BigDecimal.ZERO) > 0) {
               purchaseOrderDetailDTO.setBoolUsed(true);
               boolUsed = true;
            }

            purchaseOrderDetailDTOS.add(purchaseOrderDetailDTO);
         }

         orderDTO.setDetails(purchaseOrderDetailDTOS);
      }

      if (!purchaseOrder.getBoolTemporaryStorage()) {
         List<WmsApproveRecordFlowDTO> wmsApproveRecordFlowDTOS = new ArrayList<>();
         if (ObjectUtil.isNotEmpty(purchaseOrder.getApproveRecordIds())) {
            String approveRecordIds = purchaseOrder.getApproveRecordIds();

            for (Long approveRecordId : Arrays.stream(approveRecordIds.split(",")).map(Long::valueOf).collect(Collectors.toList())) {
               WmsApproveRecordFlowDTO wmsApproveRecordFlowDTO = this.wmsApproveRecordService.getApproveRecordDTO(approveRecordId);
               wmsApproveRecordFlowDTOS.add(wmsApproveRecordFlowDTO);
            }
         }

         orderDTO.setWmsApproveRecordFlowDTOS(wmsApproveRecordFlowDTOS);
      }

      List<InboundDetail> inboundDetailListPass = this.inboundDetailService
         .getInboundDetailList(purchaseOrder.getId(), null, ReviewStatusEnum.REVIEWED.getType());
      List<InboundDetail> collect = inboundDetailListPass.stream().filter(i -> i.getMete().compareTo(i.getRejectMete()) != 0).collect(Collectors.toList());
      if (CollectionUtil.isNotEmpty(collect)) {
         boolUsed = true;
      }

      orderDTO.setBoolUsed(boolUsed);
      orderDTO.setDelButtonType(DelButtonTypeEnum.BU_ZHAN_SHI.getType());
      if (ObjectUtil.isNotEmpty(purchaseOrder.getDataStatus())) {
         if (purchaseOrder.getDataStatus().equals(DataStatusEnum.SUCCEED.getType())) {
            orderDTO.setDelButtonType(DelButtonTypeEnum.SHAN_CHU.getType());
            if (ObjectUtil.isNotEmpty(purchaseOrder.getApplyDetailMeteJson())) {
               orderDTO.setDetailQuantityAndMetes(JSONArray.parseArray(purchaseOrder.getApplyDetailMeteJson(), DetailQuantityAndMete.class));
            }
         }

         if (purchaseOrder.getDataStatus().equals(DataStatusEnum.UNDER_REVIEW.getType())) {
            if (ObjectUtil.isNotEmpty(purchaseOrder.getPassParentId())) {
               orderDTO.setDelButtonType(DelButtonTypeEnum.CHE_XIAO_BIAN_JI.getType());
               PurchaseOrder passParentOrder = this.baseMapper.getById(purchaseOrder.getPassParentId());
               if (ObjectUtil.isNotEmpty(passParentOrder.getApplyDetailMeteJson())) {
                  orderDTO.setDetailQuantityAndMetes(JSONArray.parseArray(passParentOrder.getApplyDetailMeteJson(), DetailQuantityAndMete.class));
               }
            } else {
               orderDTO.setDelButtonType(DelButtonTypeEnum.CHE_XIAO.getType());
            }
         }

         if (purchaseOrder.getDataStatus().equals(DataStatusEnum.CANCELLATION_UNDER_WAY.getType())) {
            orderDTO.setDelButtonType(DelButtonTypeEnum.CHE_XIAO_SHAN_CHU.getType());
         }
      }

      return orderDTO;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean editPurchaseStatusV2(Long id, Integer purchaseStatus) {
      PurchaseOrder purchaseOrder = this.baseMapper.selectById(id);
      Preconditions.checkArgument(purchaseStatus != null, "订单信息不存在");
      Preconditions.checkArgument(!purchaseOrder.getDataStatus().equals(DataStatusEnum.CANCELLATION_UNDER_WAY.getType()), "采购单在作废中不能修改采购状态");
      Preconditions.checkArgument(!purchaseOrder.getDataStatus().equals(DataStatusEnum.CANCELLATION.getType()), "采购单已作废不能修改采购状态");
      Preconditions.checkArgument(
         purchaseStatus.equals(PurchaseStatusEnum.FINISH.getType()) || purchaseOrder.getSettlementStatus().equals(SettlementStatusEnum.UN_SETTLED.getType()),
         "订单已结算,不能设为采购状态!"
      );
      if (purchaseOrder.getPurchaseType().equals(PurchaseEnum.MATERIAL.getType())) {
         List<Inbound> inbounds = this.inboundService
            .list(
               (Wrapper<Inbound>)(Wrappers.<Inbound>lambdaQuery().eq(Inbound::getPurchaseId, purchaseOrder.getId()))
                  .eq(Inbound::getReviewStatus, ReviewStatusEnum.UN_REVIEWED.getType())
            );
         Preconditions.checkArgument(CollectionUtil.isEmpty(inbounds), "修改失败,订单存在入库未审核！！！");
      } else if (purchaseOrder.getPurchaseType().equals(PurchaseEnum.FINISHED_GOODS.getType())) {
         List<InboundManufactured> inboundManufacturedList = this.inboundManufacturedService
            .list(
               (Wrapper<InboundManufactured>)(Wrappers.<InboundManufactured>lambdaQuery().eq(InboundManufactured::getPurchaseId, purchaseOrder.getId()))
                  .eq(InboundManufactured::getReviewStatus, ReviewStatusEnum.UN_REVIEWED.getType())
            );
         Preconditions.checkArgument(CollectionUtil.isEmpty(inboundManufacturedList), "修改失败,订单存在入库未审核！！！");
      } else {
         Preconditions.checkArgument(false, "未知采购材料类型！！！");
      }

      purchaseOrder.setPurchaseStatus(purchaseStatus);
      return this.baseMapper.updateById(purchaseOrder) == 1;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public ResultVO submitOaReviewOrder(PurchaseOrderDTOParam param) {
      ResultVO build = ResultVO.builder().build();
      if (param.getBoolTemporaryStorage()) {
         Boolean e = this.saveV2(param, false);
      } else if (ObjectUtil.isEmpty(param.getId())) {
         Boolean b = this.saveV2(param, false);
         Preconditions.checkArgument(b, "采购单创建失败");
         PurchaseOrder purchaseOrder = this.baseMapper.selectById(param.getId());
         purchaseOrder.setReviewStatus(ReviewStatusEnum.AUDITING.getType());
         purchaseOrder.setDataStatus(DataStatusEnum.UNDER_REVIEW.getType());
         purchaseOrder.setEditable(Boolean.FALSE);
         purchaseOrder.setBoolRewrite(Boolean.FALSE);
         purchaseOrder.setSigningTime(LocalDateTime.now());
         this.baseMapper.updateById(purchaseOrder);
         this.baseMapper.deleteById(purchaseOrder);
         build.setCode(2000L);
         build.setData(purchaseOrder.getId());
      } else {
         Boolean var7 = this.updatePurchaseOrderV2(param);
      }

      if (CollectionUtils.isNotEmpty(param.getList())) {
         try {
            String url = this.configProperties.getFilePath() + "purchase_order_detail/" + formatter.format(new Date()) + "_attachments.xlsx";
            ExcelUtils.steelPlatesExcel(param.getList(), url);
            this.redisTemplate.opsForValue().set("oa_purchase_order_detail_dataId:" + param.getId(), this.uploadExcelFile(url, 100));
         } catch (Exception e) {
            log.error("导出excel失败", e);
            build.setMessage(e.getMessage());
            return build;
         }
      }

      return build;
   }

   public Attachment uploadExcelFile(String filePath, int fileType) throws IOException {
      File file = new File(filePath);
      byte[] fileContent = FileUtils.readFileToByteArray(file);
      MultipartFile multipartFile = new MockMultipartFile(
         "file", file.getName(), "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", fileContent
      );
      return this.attachmentService.uploadFile(multipartFile, fileType);
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean submitReviewOrder(PurchaseOrderDTOParam param) {
      Boolean b = this.saveV2(param, false);
      Preconditions.checkArgument(b, "采购单创建失败");
      if (param.getBoolTemporaryStorage()) {
         Preconditions.checkArgument(!param.getPurchaseType().equals(PurchaseEnum.FINISHED_GOODS.getType()), "制成品采购不可进行暂存！！！");
         return true;
      }

      if (!param.getBoolDetail() || CollectionUtil.isEmpty(param.getList())) {
         Preconditions.checkArgument(!param.getPurchaseType().equals(PurchaseEnum.FINISHED_GOODS.getType()), "制成品不可进行无明细采购！！！");
      }

      MountMessageDTO mountMessageDTO = new MountMessageDTO();
      List<Integer> projectAttributes = new ArrayList<>();
      projectAttributes.add(param.getProjectAttribute());
      mountMessageDTO.setProjectAttribute(projectAttributes);
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService
         .createRecord(
            param.getId(), param.getSerialNumber(), ApproveProcessTypeEnumV2.PURCHASE_ORDER_ADD.getType(), null, null, null, false, mountMessageDTO, null, null
         );
      PurchaseOrder purchaseOrder = this.baseMapper.selectById(param.getId());
      purchaseOrder.setReviewStatus(ReviewStatusEnum.AUDITING.getType());
      purchaseOrder.setDataStatus(DataStatusEnum.UNDER_REVIEW.getType());
      purchaseOrder.setEditable(Boolean.FALSE);
      purchaseOrder.setBoolRewrite(Boolean.FALSE);
      purchaseOrder.setApproveRecordIds(String.valueOf(wmsApproveRecord.getId()));
      purchaseOrder.setApproveRecordIdNow(wmsApproveRecord.getId());
      if (wmsApproveRecord.getStatus().equals(ApproveRecordStatusEnum.END.getType())) {
         purchaseOrder.setDataStatus(DataStatusEnum.SUCCEED.getType());
         purchaseOrder.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
         purchaseOrder.setReviewPassTime(LocalDateTime.now());
         purchaseOrder.setPurchaseStatus(PurchaseStatusEnum.DURING.getType());
         purchaseOrder.setSettlementStatus(SettlementStatusEnum.UN_SETTLED.getType());
         purchaseOrder.setBoolRewrite(Boolean.FALSE);
         if (ObjectUtil.isNotEmpty(purchaseOrder.getApplyPurchaseIds())) {
            this.updateApplyProductQuantityAndMete(purchaseOrder, true);
         }

         this.warehouseDataDashboardService
            .saveInstantMessageHint(
               InstantMessageHintDTO.builder()
                  .type(MessageEnum.PURCHASE_ORDER.getType())
                  .typeName(MessageEnum.PURCHASE_ORDER.getName())
                  .dateTimeStr(DATE_TIME_FORMATTER.format(purchaseOrder.getReviewPassTime()))
                  .createUser(purchaseOrder.getApplicantName())
                  .serialNumber(purchaseOrder.getSerialNumber())
                  .supplier(this.supplierService.getById(purchaseOrder.getSupplierId()).getName())
                  .basicClass(BasicClassEnum.getNameStr(purchaseOrder.getBasicClass()))
                  .build()
            );
      }

      this.sysPushFlowConfigBiz
         .triggerFlow(
            NotificationServiceTriggerDTO.builder()
               .createUserId(UserUtil.getCurrentUserId())
               .contentDetails(
                  this.detailsUtils
                     .getPurchaseOrderDetails(param.getSerialNumber(), param.getAmount(), this.supplierService.getById(param.getSupplierId()).getName())
               )
               .notificationTypeEnum(NotificationModuleTypeEnum.PURCHASE.getNotificationType())
               .userList(new ArrayList<>())
               .build()
         );
      return this.baseMapper.updateById(purchaseOrder) == 1;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updatePurchaseOrderV2(PurchaseOrderDTOParam dtoParam) {
      if (!dtoParam.getBoolDetail() || CollectionUtil.isEmpty(dtoParam.getList())) {
         Preconditions.checkArgument(!dtoParam.getPurchaseType().equals(PurchaseEnum.FINISHED_GOODS.getType()), "制成品不可进行无明细采购！！！");
      }

      PurchaseOrder purchaseOrderOld = this.baseMapper.selectById(dtoParam.getId());
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(purchaseOrderOld), "采购订单不存在！！！");
      SecurityUser currentUser = UserUtil.getCurrentUser();
      if (!dtoParam.getBoolTemporaryStorage()) {
         if (dtoParam.getReviewStatus() == null) {
            if (InvoiceTypeEnum.RECEIPT.getType().equals(dtoParam.getInvoiceType())) {
               dtoParam.setTaxRate(null);
            }

            if (dtoParam.getInvoiceType().equals(InvoiceTypeEnum.SPECIAL.getType()) || dtoParam.getInvoiceType().equals(InvoiceTypeEnum.ORDINARY.getType())) {
               Preconditions.checkArgument(dtoParam.getTaxRate() != null, "稅率不可为空！！！");
               Preconditions.checkArgument(dtoParam.getTaxRate().compareTo(BigDecimal.ZERO) >= 0, "税率需大于等于0");
            }

            if (dtoParam.getUseRequisitions() == Boolean.FALSE && !dtoParam.getProjectAttribute().equals(ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType())) {
               dtoParam.setApplyPurchaseStatus(null);
            }

            if (CollectionUtil.isNotEmpty(dtoParam.getApplyPurchaseIds())) {
               this.checkApplyBoolAlter(dtoParam.getApplyPurchaseIds(), dtoParam.getClickAddTime());
            }

            if (dtoParam.getSerialNumberParent() == null) {
               dtoParam.setSerialNumberParent(dtoParam.getSerialNumber());
            }

            dtoParam.setUserUpdateTime(LocalDateTime.now());
            dtoParam.setLastOperatorNameId(currentUser.getId());
            dtoParam.setLastOperatorName(currentUser.getName());
            PurchaseOrder purchaseOrder = BeanUtil.copy(dtoParam, PurchaseOrder.class);
            purchaseOrder.setArtifactWageQuotaType(dtoParam.getArtifactWageQuotaType());
            if (dtoParam.getList() != null) {
               IdsStatusDTO idsStatusDTO = new IdsStatusDTO();
               if (ObjectUtil.isNotEmpty(purchaseOrderOld.getClassifyIds())) {
                  idsStatusDTO.setIdsStr(purchaseOrderOld.getClassifyIds());
               } else {
                  List<PurchaseOrderDetail> purchaseOrderDetails = this.purchaseOrderDetailMapper
                     .selectList((Wrapper<PurchaseOrderDetail>)Wrappers.<PurchaseOrderDetail>lambdaQuery().eq(PurchaseOrderDetail::getPurchaseId, purchaseOrder.getId()));
                  List<Long> classifyIds = purchaseOrderDetails.stream().map(PurchaseOrderDetail::getClassifyId).collect(Collectors.toList());
                  idsStatusDTO.setIds(classifyIds);
               }

               this.purchaseOrderDetailMapper
                  .delete((Wrapper<PurchaseOrderDetail>)new LambdaQueryWrapper<PurchaseOrderDetail>().eq(PurchaseOrderDetail::getPurchaseId, dtoParam.getId()));
               this.classificationService.deleteDataUpdateClass(idsStatusDTO);
               this.saveDetailV2(dtoParam, purchaseOrder);
               this.classificationService.updateClassifyUsed(IdsStatusDTO.builder().idsStr(purchaseOrder.getClassifyIds()).build());
            }

            if (ObjectUtil.isEmpty(purchaseOrder.getSerialNumber())) {
               String serialNumber = this.getSerialNumber(dtoParam, purchaseOrder);
               purchaseOrder.setSerialNumber(serialNumber);
            } else if (purchaseOrder.getSerialNumber().equals(purchaseOrderOld.getSerialNumber())) {
               purchaseOrder.setBoolSysgen(purchaseOrderOld.getBoolSysgen());
            } else {
               this.checkSerialNumber(purchaseOrder.getSerialNumber(), null);
               purchaseOrder.setBoolSysgen(false);
            }

            if (!dtoParam.getProjectAttribute().equals(ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType()) && ObjectUtil.isNotEmpty(dtoParam.getBranchCompanyId())) {
               BranchCompany branchCompany = this.branchCompanyService.getById(dtoParam.getBranchCompanyId());
               if (branchCompany != null) {
                  Optional.ofNullable(branchCompany.getLevel()).ifPresent(purchaseOrder::setLevel);
                  Optional.ofNullable(branchCompany.getBranchAttributeEnum()).ifPresent(purchaseOrder::setBranchAttributeEnum);
               }
            }

            if (ObjectUtil.isNotEmpty(dtoParam.getBranchCompanyId())
               && (ObjectUtil.isNotEmpty(dtoParam.getProjectId()) || CollectionUtils.isNotEmpty(dtoParam.getProjectIds()))) {
               this.contractProjectService.checkContractSignBodyId(dtoParam.getProjectId(), dtoParam.getProjectIds(), null, dtoParam.getBranchCompanyId());
            }

            purchaseOrder.setReviewStatus(ReviewStatusEnum.AUDITING.getType());
            purchaseOrder.setDataStatus(DataStatusEnum.UNDER_REVIEW.getType());
            purchaseOrder.setUserUpdateTime(LocalDateTime.now());
            purchaseOrder.setLastOperatorNameId(currentUser.getId());
            purchaseOrder.setLastOperatorName(currentUser.getName());
            purchaseOrder.setBoolRewrite(Boolean.FALSE);
            if (dtoParam.getWorkshopId() != null) {
               purchaseOrder.setWorkshopId(dtoParam.getWorkshopId());
            }

            MountMessageDTO mountMessageDTO = new MountMessageDTO();
            List<Integer> projectAttributes = new ArrayList<>();
            projectAttributes.add(purchaseOrder.getProjectAttribute());
            mountMessageDTO.setProjectAttribute(projectAttributes);
            WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService
               .createRecord(
                  purchaseOrder.getId(),
                  purchaseOrder.getSerialNumber(),
                  ApproveProcessTypeEnumV2.PURCHASE_ORDER_ADD.getType(),
                  null,
                  null,
                  null,
                  false,
                  mountMessageDTO,
                  null,
                  null
               );
            purchaseOrder.setApproveRecordIds(String.valueOf(wmsApproveRecord.getId()));
            purchaseOrder.setApproveRecordIdNow(wmsApproveRecord.getId());
            if (wmsApproveRecord.getStatus().equals(ApproveRecordStatusEnum.END.getType())) {
               purchaseOrder.setDataStatus(DataStatusEnum.SUCCEED.getType());
               purchaseOrder.setPurchaseStatus(PurchaseStatusEnum.DURING.getType());
               purchaseOrder.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
               purchaseOrder.setReviewPassTime(LocalDateTime.now());
               purchaseOrder.setSettlementStatus(SettlementStatusEnum.UN_SETTLED.getType());
               purchaseOrder.setBoolRewrite(Boolean.FALSE);
               if (ObjectUtil.isNotEmpty(purchaseOrder.getApplyDetailMeteJson())) {
                  this.updateApplyProductQuantityAndMete(purchaseOrder, true);
               }
            }

            this.baseMapper.updateById(purchaseOrder);
         } else if (dtoParam.getDataStatus().equals(DataStatusEnum.USELESS.getType()) || dtoParam.getDataStatus().equals(DataStatusEnum.CANCELLATION.getType())
            )
          {
            PurchaseOrder purchaseOrder = purchaseOrderOld;
            if (dtoParam.getUseRequisitions() == Boolean.FALSE) {
               dtoParam.setApplyPurchaseStatus(null);
            }

            if (CollectionUtil.isNotEmpty(dtoParam.getApplyPurchaseIds())) {
               this.checkApplyBoolAlter(dtoParam.getApplyPurchaseIds(), dtoParam.getClickAddTime());
            }

            if (ObjectUtil.isNotEmpty(dtoParam.getSerialNumber()) && dtoParam.getSerialNumber().equals(purchaseOrder.getSerialNumber())) {
               dtoParam.setBoolSysgen(purchaseOrder.getBoolSysgen());
            } else {
               dtoParam.setBoolSysgen(false);
            }

            dtoParam.setPurchaseStatus(null);
            dtoParam.setSettlementStatus(null);
            dtoParam.setSerialNumberParent(dtoParam.getSerialNumberParent());
            this.saveV2(dtoParam, false);
            MountMessageDTO mountMessageDTO = new MountMessageDTO();
            List<Integer> projectAttributes = new ArrayList<>();
            projectAttributes.add(purchaseOrder.getProjectAttribute());
            mountMessageDTO.setProjectAttribute(projectAttributes);
            WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService
               .createRecord(
                  dtoParam.getId(),
                  dtoParam.getSerialNumber(),
                  ApproveProcessTypeEnumV2.PURCHASE_ORDER_ADD.getType(),
                  null,
                  null,
                  null,
                  false,
                  mountMessageDTO,
                  null,
                  null
               );
            PurchaseOrder order = this.baseMapper.selectById(dtoParam.getId());
            order.setReviewStatus(ReviewStatusEnum.AUDITING.getType());
            order.setDataStatus(DataStatusEnum.UNDER_REVIEW.getType());
            order.setApproveRecordIds(String.valueOf(wmsApproveRecord.getId()));
            order.setApproveRecordIdNow(wmsApproveRecord.getId());
            order.setBoolRewrite(Boolean.FALSE);
            if (wmsApproveRecord.getStatus().equals(ApproveRecordStatusEnum.END.getType())) {
               order.setDataStatus(DataStatusEnum.SUCCEED.getType());
               order.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
               order.setReviewPassTime(LocalDateTime.now());
               order.setPurchaseStatus(PurchaseStatusEnum.DURING.getType());
               order.setSettlementStatus(SettlementStatusEnum.UN_SETTLED.getType());
               order.setBoolRewrite(Boolean.FALSE);
               if (ObjectUtil.isNotEmpty(purchaseOrder.getApplyDetailMeteJson())) {
                  this.updateApplyProductQuantityAndMete(purchaseOrder, true);
               }
            }

            this.baseMapper.updateById(order);
         }
      } else {
         Preconditions.checkArgument(!dtoParam.getPurchaseType().equals(PurchaseEnum.FINISHED_GOODS.getType()), "制成品采购不可进行暂存！！！");
         if (ObjectUtil.isEmpty(purchaseOrderOld.getDataStatus())) {
            PurchaseOrder purchaseOrder = purchaseOrderOld;
            BeanUtil.copy(dtoParam, purchaseOrder);
            if (dtoParam.getUseRequisitions() == Boolean.FALSE) {
               dtoParam.setApplyPurchaseStatus(null);
            }

            if (CollectionUtil.isNotEmpty(dtoParam.getApplyPurchaseIds())) {
               this.checkApplyBoolAlter(dtoParam.getApplyPurchaseIds(), dtoParam.getClickAddTime());
            }

            this.checkSelfParam(dtoParam);
            if (ObjectUtil.isEmpty(dtoParam.getSerialNumber())) {
               String serialNumber = this.getSerialNumber(dtoParam, purchaseOrder);
               purchaseOrder.setSerialNumber(serialNumber);
            } else if (purchaseOrder.getSerialNumber().equals(purchaseOrderOld.getSerialNumber())) {
               purchaseOrder.setBoolSysgen(purchaseOrderOld.getBoolSysgen());
            } else {
               this.checkSerialNumber(purchaseOrder.getSerialNumber(), null);
               purchaseOrder.setBoolSysgen(false);
            }

            this.listChangeStr(dtoParam, purchaseOrder);
            purchaseOrder.setArtifactWageQuotaType(dtoParam.getArtifactWageQuotaType());
            purchaseOrder.setLastOperatorNameId(currentUser.getId());
            purchaseOrder.setLastOperatorName(currentUser.getName());
            purchaseOrder.setAuxMaterialIds(StrUtil.join(",", dtoParam.getAuxMaterialIds()));
            purchaseOrder.setOtherMaterialIds(StrUtil.join(",", dtoParam.getOtherMaterialIds()));
            purchaseOrder.setUserUpdateTime(LocalDateTime.now());
            purchaseOrder.setBranchCompanyId(dtoParam.getBranchCompanyId());
            purchaseOrder.setProjectIds(StrUtil.join(",", dtoParam.getProjectIds()));
            if (InvoiceTypeEnum.RECEIPT.getType().equals(dtoParam.getInvoiceType())) {
               purchaseOrder.setInvoiceType(dtoParam.getInvoiceType());
               purchaseOrder.setTaxRate(null);
            }

            if (!dtoParam.getProjectAttribute().equals(ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType()) && ObjectUtil.isNotEmpty(dtoParam.getBranchCompanyId())) {
               BranchCompany branchCompany = this.branchCompanyService.getById(dtoParam.getBranchCompanyId());
               if (branchCompany != null) {
                  Optional.ofNullable(branchCompany.getLevel()).ifPresent(purchaseOrder::setLevel);
                  Optional.ofNullable(branchCompany.getBranchAttributeEnum()).ifPresent(purchaseOrder::setBranchAttributeEnum);
               }
            }

            IdsStatusDTO idsStatusDTO = new IdsStatusDTO();
            if (ObjectUtil.isNotEmpty(purchaseOrder.getClassifyIds())) {
               idsStatusDTO.setIdsStr(purchaseOrder.getClassifyIds());
            } else {
               List<PurchaseOrderDetail> purchaseOrderDetails = this.purchaseOrderDetailMapper
                  .selectList((Wrapper<PurchaseOrderDetail>)Wrappers.<PurchaseOrderDetail>lambdaQuery().eq(PurchaseOrderDetail::getPurchaseId, purchaseOrder.getId()));
               List<Long> classifyIds = purchaseOrderDetails.stream().map(PurchaseOrderDetail::getClassifyId).collect(Collectors.toList());
               idsStatusDTO.setIds(classifyIds);
            }

            this.purchaseOrderDetailMapper
               .delete((Wrapper<PurchaseOrderDetail>)Wrappers.<PurchaseOrderDetail>lambdaQuery().eq(PurchaseOrderDetail::getPurchaseId, purchaseOrder.getId()));
            this.classificationService.deleteDataUpdateClass(idsStatusDTO);
            if (dtoParam.getList() != null && dtoParam.getList().size() > 0) {
               this.saveDetailV2(dtoParam, purchaseOrder);
               this.classificationService.updateClassifyUsed(IdsStatusDTO.builder().idsStr(purchaseOrder.getClassifyIds()).build());
            }

            this.baseMapper.updateById(purchaseOrder);
         } else {
            dtoParam.setReviewStatus(null);
            dtoParam.setReviewPassTime(null);
            dtoParam.setDataStatus(null);
            dtoParam.setPurchaseStatus(null);
            dtoParam.setSettlementStatus(null);
            dtoParam.setApproveRecordIds(null);
            dtoParam.setApproveRecordIdNow(null);
            dtoParam.setSerialNumberParent(dtoParam.getSerialNumberParent());
            this.saveV2(dtoParam, false);
         }
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public ResultVO updateOaPurchaseOrderV2(PurchaseOrderDTOParam dtoParam) {
      ResultVO<Object> build = ResultVO.<Object>builder().build();
      PurchaseOrder purchaseOrderOld = this.baseMapper.selectById(dtoParam.getId());
      SecurityUser currentUser = UserUtil.getCurrentUser();
      if (!dtoParam.getBoolTemporaryStorage()) {
         if (dtoParam.getReviewStatus() == null) {
            if (InvoiceTypeEnum.RECEIPT.getType().equals(dtoParam.getInvoiceType())) {
               dtoParam.setTaxRate(null);
            }

            if (dtoParam.getInvoiceType().equals(InvoiceTypeEnum.SPECIAL.getType()) || dtoParam.getInvoiceType().equals(InvoiceTypeEnum.ORDINARY.getType())) {
               Preconditions.checkArgument(dtoParam.getTaxRate() != null, "稅率不可为空！！！");
               Preconditions.checkArgument(dtoParam.getTaxRate().compareTo(BigDecimal.ZERO) >= 0, "税率需大于等于0");
            }

            if (dtoParam.getUseRequisitions() == Boolean.FALSE && !dtoParam.getProjectAttribute().equals(ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType())) {
               dtoParam.setApplyPurchaseStatus(null);
            }

            if (CollectionUtil.isNotEmpty(dtoParam.getApplyPurchaseIds())) {
               this.checkApplyBoolAlter(dtoParam.getApplyPurchaseIds(), dtoParam.getClickAddTime());
            }

            if (dtoParam.getSerialNumberParent() == null) {
               dtoParam.setSerialNumberParent(dtoParam.getSerialNumber());
            }

            dtoParam.setUserUpdateTime(LocalDateTime.now());
            dtoParam.setLastOperatorNameId(currentUser.getId());
            dtoParam.setLastOperatorName(currentUser.getName());
            PurchaseOrder purchaseOrder = BeanUtil.copy(dtoParam, PurchaseOrder.class);
            purchaseOrder.setArtifactWageQuotaType(dtoParam.getArtifactWageQuotaType());
            if (dtoParam.getList() != null) {
               IdsStatusDTO idsStatusDTO = new IdsStatusDTO();
               if (ObjectUtil.isNotEmpty(purchaseOrderOld.getClassifyIds())) {
                  idsStatusDTO.setIdsStr(purchaseOrderOld.getClassifyIds());
               } else {
                  List<PurchaseOrderDetail> purchaseOrderDetails = this.purchaseOrderDetailMapper
                     .selectList((Wrapper<PurchaseOrderDetail>)Wrappers.<PurchaseOrderDetail>lambdaQuery().eq(PurchaseOrderDetail::getPurchaseId, purchaseOrder.getId()));
                  List<Long> classifyIds = purchaseOrderDetails.stream().map(PurchaseOrderDetail::getClassifyId).collect(Collectors.toList());
                  idsStatusDTO.setIds(classifyIds);
               }

               this.purchaseOrderDetailMapper
                  .delete((Wrapper<PurchaseOrderDetail>)new LambdaQueryWrapper<PurchaseOrderDetail>().eq(PurchaseOrderDetail::getPurchaseId, dtoParam.getId()));
               this.classificationService.deleteDataUpdateClass(idsStatusDTO);
               this.saveDetailV2(dtoParam, purchaseOrder);
               this.classificationService.updateClassifyUsed(IdsStatusDTO.builder().idsStr(purchaseOrder.getClassifyIds()).build());
            }

            if (ObjectUtil.isEmpty(purchaseOrder.getSerialNumber())) {
               String serialNumber = this.getSerialNumber(dtoParam, purchaseOrder);
               purchaseOrder.setSerialNumber(serialNumber);
            } else if (purchaseOrder.getSerialNumber().equals(purchaseOrderOld.getSerialNumber())) {
               purchaseOrder.setBoolSysgen(purchaseOrderOld.getBoolSysgen());
            } else {
               this.checkSerialNumber(purchaseOrder.getSerialNumber(), null);
               purchaseOrder.setBoolSysgen(false);
            }

            if (!dtoParam.getProjectAttribute().equals(ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType()) && ObjectUtil.isNotEmpty(dtoParam.getBranchCompanyId())) {
               Integer level = this.branchCompanyService.getById(dtoParam.getBranchCompanyId()).getLevel();
               if (ObjectUtil.isNotEmpty(level)) {
                  purchaseOrder.setLevel(level);
               }
            }

            if (ObjectUtil.isNotEmpty(dtoParam.getBranchCompanyId())
               && (ObjectUtil.isNotEmpty(dtoParam.getProjectId()) || CollectionUtils.isNotEmpty(dtoParam.getProjectIds()))) {
               this.contractProjectService.checkContractSignBodyId(dtoParam.getProjectId(), dtoParam.getProjectIds(), null, dtoParam.getBranchCompanyId());
            }

            purchaseOrder.setReviewStatus(ReviewStatusEnum.AUDITING.getType());
            purchaseOrder.setDataStatus(DataStatusEnum.UNDER_REVIEW.getType());
            purchaseOrder.setUserUpdateTime(LocalDateTime.now());
            purchaseOrder.setLastOperatorNameId(currentUser.getId());
            purchaseOrder.setLastOperatorName(currentUser.getName());
            purchaseOrder.setBoolRewrite(Boolean.FALSE);
            if (dtoParam.getWorkshopId() != null) {
               purchaseOrder.setWorkshopId(dtoParam.getWorkshopId());
            }

            purchaseOrder.setProjectIds(StrUtil.join(",", dtoParam.getProjectIds()));
            purchaseOrder.setAttachments(StrUtil.join(",", dtoParam.getAttachmentIds()));
            this.baseMapper.updateById(purchaseOrder);
            this.baseMapper.deleteById(purchaseOrder);
            build.setCode(2000L);
            build.setData(purchaseOrder.getId());
         } else if (dtoParam.getDataStatus().equals(DataStatusEnum.USELESS.getType()) || dtoParam.getDataStatus().equals(DataStatusEnum.CANCELLATION.getType())
            )
          {
            Preconditions.checkArgument(dtoParam.getEditable().equals(Boolean.TRUE), "该采购单已有新的采购单在进行中,该采购单不能发起审批");
            PurchaseOrder purchaseOrder = purchaseOrderOld;
            Preconditions.checkArgument(purchaseOrder != null, "采购单不存在");
            if (dtoParam.getUseRequisitions() == Boolean.FALSE) {
               dtoParam.setApplyPurchaseStatus(null);
            }

            if (CollectionUtil.isNotEmpty(dtoParam.getApplyPurchaseIds())) {
               this.checkApplyBoolAlter(dtoParam.getApplyPurchaseIds(), dtoParam.getClickAddTime());
            }

            if (ObjectUtil.isNotEmpty(dtoParam.getSerialNumber()) && dtoParam.getSerialNumber().equals(purchaseOrder.getSerialNumber())) {
               dtoParam.setBoolSysgen(purchaseOrder.getBoolSysgen());
            } else {
               dtoParam.setBoolSysgen(false);
            }

            dtoParam.setPurchaseStatus(null);
            dtoParam.setSettlementStatus(null);
            dtoParam.setSerialNumberParent(dtoParam.getSerialNumberParent());
            return this.saveV2Oa(dtoParam, false);
         }
      } else {
         if (!ObjectUtil.isEmpty(purchaseOrderOld.getDataStatus())) {
            dtoParam.setReviewStatus(null);
            dtoParam.setReviewPassTime(null);
            dtoParam.setDataStatus(null);
            dtoParam.setPurchaseStatus(null);
            dtoParam.setSettlementStatus(null);
            dtoParam.setApproveRecordIds(null);
            dtoParam.setApproveRecordIdNow(null);
            dtoParam.setSerialNumberParent(dtoParam.getSerialNumberParent());
            return this.saveV2Oa(dtoParam, false);
         }

         Preconditions.checkArgument(dtoParam.getId() != null, "订单ID不能为空");
         PurchaseOrder purchaseOrder = purchaseOrderOld;
         Preconditions.checkArgument(purchaseOrder != null, "采购单不存在");
         if (dtoParam.getUseRequisitions() == Boolean.FALSE) {
            dtoParam.setApplyPurchaseStatus(null);
         }

         if (CollectionUtil.isNotEmpty(dtoParam.getApplyPurchaseIds())) {
            int updateCount = this.applyPurchaseService
               .count(
                  (Wrapper<ApplyPurchase>)(Wrappers.<ApplyPurchase>lambdaQuery().in(ApplyPurchase::getId, dtoParam.getApplyPurchaseIds()))
                     .ge(BaseEntity::getUpdateTime, dtoParam.getClickAddTime())
               );
            Preconditions.checkArgument(updateCount == 0, "申购内容有变化，请关闭当前页面重新创建采购订单");

            for (ApplyPurchase applyPurchase : this.applyPurchaseService.listByIds(dtoParam.getApplyPurchaseIds())) {
               Preconditions.checkArgument(
                  applyPurchase.getPurchaseCreationState().equals(ApplyPurchaseStateEnum.NOT_STARTED.getType())
                     || applyPurchase.getPurchaseCreationState().equals(ApplyPurchaseStateEnum.PARTIAL_CREATED.getType()),
                  "申购单已采购完毕不能创建"
               );
            }
         }

         if (!purchaseOrder.getSerialNumber().equals(dtoParam.getSerialNumber())) {
            Preconditions.checkArgument(
               CollectionUtils.isEmpty(
                  this.baseMapper.selectList((Wrapper<PurchaseOrder>)Wrappers.<PurchaseOrder>lambdaQuery().eq(PurchaseOrder::getSerialNumber, dtoParam.getSerialNumber()))
               ),
               "当前采购订单号已存在"
            );
            purchaseOrder.setSerialNumber(dtoParam.getSerialNumber());
         }

         this.checkSelfParam(dtoParam);
         if (ObjectUtil.isEmpty(dtoParam.getSerialNumber())) {
            String serialNumber = this.getSerialNumber(dtoParam, purchaseOrder);
            purchaseOrder.setSerialNumber(serialNumber);
         } else if (purchaseOrder.getSerialNumber().equals(purchaseOrderOld.getSerialNumber())) {
            purchaseOrder.setBoolSysgen(purchaseOrderOld.getBoolSysgen());
         } else {
            this.checkSerialNumber(purchaseOrder.getSerialNumber(), null);
            purchaseOrder.setBoolSysgen(true);
         }

         BeanUtil.copy(dtoParam, purchaseOrder);
         this.listChangeStr(dtoParam, purchaseOrder);
         purchaseOrder.setLastOperatorNameId(currentUser.getId());
         purchaseOrder.setLastOperatorName(currentUser.getName());
         purchaseOrder.setAuxMaterialIds(StrUtil.join(",", dtoParam.getAuxMaterialIds()));
         purchaseOrder.setOtherMaterialIds(StrUtil.join(",", dtoParam.getOtherMaterialIds()));
         purchaseOrder.setUserUpdateTime(LocalDateTime.now());
         purchaseOrder.setBranchCompanyId(dtoParam.getBranchCompanyId());
         purchaseOrder.setProjectIds(StrUtil.join(",", dtoParam.getProjectIds()));
         if (CollectionUtil.isNotEmpty(dtoParam.getApplyPurchaseIds())) {
            purchaseOrder.setApplyPurchaseIds(CollectionUtil.join(dtoParam.getApplyPurchaseIds(), ","));
         }

         if (InvoiceTypeEnum.RECEIPT.getType().equals(dtoParam.getInvoiceType())) {
            purchaseOrder.setInvoiceType(dtoParam.getInvoiceType());
            purchaseOrder.setTaxRate(null);
         }

         if (!dtoParam.getProjectAttribute().equals(ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType()) && ObjectUtil.isNotEmpty(dtoParam.getBranchCompanyId())) {
            Integer level = this.branchCompanyService.getById(dtoParam.getBranchCompanyId()).getLevel();
            if (ObjectUtil.isNotEmpty(level)) {
               purchaseOrder.setLevel(level);
            }
         }

         IdsStatusDTO idsStatusDTO = new IdsStatusDTO();
         if (ObjectUtil.isNotEmpty(purchaseOrder.getClassifyIds())) {
            idsStatusDTO.setIdsStr(purchaseOrder.getClassifyIds());
         } else {
            List<PurchaseOrderDetail> purchaseOrderDetails = this.purchaseOrderDetailMapper
               .selectList((Wrapper<PurchaseOrderDetail>)Wrappers.<PurchaseOrderDetail>lambdaQuery().eq(PurchaseOrderDetail::getPurchaseId, purchaseOrder.getId()));
            List<Long> classifyIds = purchaseOrderDetails.stream().map(PurchaseOrderDetail::getClassifyId).collect(Collectors.toList());
            idsStatusDTO.setIds(classifyIds);
         }

         this.purchaseOrderDetailMapper
            .delete((Wrapper<PurchaseOrderDetail>)Wrappers.<PurchaseOrderDetail>lambdaQuery().eq(PurchaseOrderDetail::getPurchaseId, purchaseOrder.getId()));
         this.classificationService.deleteDataUpdateClass(idsStatusDTO);
         if (dtoParam.getList() != null && dtoParam.getList().size() > 0) {
            this.saveDetailV2(dtoParam, purchaseOrder);
            this.classificationService.updateClassifyUsed(IdsStatusDTO.builder().idsStr(purchaseOrder.getClassifyIds()).build());
         }

         purchaseOrder.setProjectIds(StrUtil.join(",", dtoParam.getProjectIds()));
         purchaseOrder.setAttachments(StrUtil.join(",", dtoParam.getAttachmentIds()));
         this.baseMapper.updateById(purchaseOrder);
         this.baseMapper.deleteById(purchaseOrder);
         build.setCode(2000L);
         build.setData(purchaseOrder.getId());
      }

      if (CollectionUtils.isNotEmpty(dtoParam.getList())) {
         try {
            String url = this.configProperties.getFilePath() + "purchase_order_detail/" + formatter.format(new Date()) + "_attachments.xlsx";
            ExcelUtils.steelPlatesExcel(dtoParam.getList(), url);
            this.redisTemplate.opsForValue().set("oa_purchase_order_detail_dataId:" + dtoParam.getId(), this.uploadExcelFile(url, 100));
         } catch (Exception e) {
            log.error("导出excel失败", e);
            build.setMessage(e.getMessage());
            return build;
         }
      }

      return build;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateApplyPurchaseOrderStatus(List<ApplyPurchaseStatusDTOParam> applyPurchaseStatusDTOParams) {
      for (ApplyPurchaseStatusDTOParam applyPurchaseStatusDTOParam : applyPurchaseStatusDTOParams) {
         ApplyPurchase applyPurchase = this.applyPurchaseService
            .getOne(
               ((new LambdaQueryWrapper<ApplyPurchase>().eq(true, ApplyPurchase::getBoolTemporaryStorage, 0))
                     .eq(true, ApplyPurchase::getId, applyPurchaseStatusDTOParam.getId()))
                  .eq(true, ApplyPurchase::getDataStatus, DataStatusEnum.SUCCEED.getType())
            );
         Preconditions.checkArgument(
            !applyPurchase.getPurchaseCreationState().equals(ApplyPurchaseStateEnum.CREATED), applyPurchase.getSerialNumber() + "申购单已被采购完成,请刷新页面重试"
         );
         applyPurchase.setPurchaseCreationState(applyPurchaseStatusDTOParam.getPurchaseCreationState());
         this.applyPurchaseService.updateById(applyPurchase);
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean ApprovePurchaseOrder(WmsApproveOpinionDTOParam wmsApproveOpinionDTOParam) {
      PurchaseOrder purchaseOrder = this.baseMapper.selectById(wmsApproveOpinionDTOParam.getDataId());
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService.getById(wmsApproveOpinionDTOParam.getApproveRecordId());
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(wmsApproveRecord), "未存在审批日志信息");
      String jsonData = null;
      Boolean b = this.wmsApproveRecordService
         .commonApproveStep(
            wmsApproveOpinionDTOParam.getDataId(),
            wmsApproveOpinionDTOParam.getDecision(),
            wmsApproveOpinionDTOParam.getOpinion(),
            wmsApproveRecord.getSerialNumber(),
            jsonData
         );
      Long approveVersionsId = wmsApproveRecord.getApproveVersionsId();
      WmsApproveTemplateVersions wmsApproveTemplateVersions = this.wmsApproveTemplateVersionsService.getById(approveVersionsId);
      if (!b) {
         return true;
      }

      Boolean boolExistInbound = false;
      if (purchaseOrder.getPurchaseType().equals(PurchaseEnum.MATERIAL.getType())) {
         boolExistInbound = CollectionUtil.isNotEmpty(
            this.inboundService.list((Wrapper<Inbound>)new LambdaQueryWrapper<Inbound>().eq(Inbound::getPurchaseId, purchaseOrder.getId()))
         );
      } else if (purchaseOrder.getPurchaseType().equals(PurchaseEnum.FINISHED_GOODS.getType())) {
         boolExistInbound = CollectionUtil.isNotEmpty(
            this.inboundManufacturedService
               .list((Wrapper<InboundManufactured>)new LambdaQueryWrapper<InboundManufactured>().eq(InboundManufactured::getPurchaseId, purchaseOrder.getId()))
         );
      } else {
         Preconditions.checkArgument(false, "未知采购材料类型！！！");
      }

      if (wmsApproveOpinionDTOParam.getDecision().equals(ReviewStatusEnum.REVIEWED.getType())) {
         if (ApproveProcessTypeEnumV2.PURCHASE_ORDER_ADD.getType().equals(wmsApproveTemplateVersions.getApproveProcessType())) {
            purchaseOrder.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
            purchaseOrder.setDataStatus(DataStatusEnum.SUCCEED.getType());
            purchaseOrder.setReviewPassTime(LocalDateTime.now());
            purchaseOrder.setPurchaseStatus(PurchaseStatusEnum.DURING.getType());
            purchaseOrder.setSettlementStatus(SettlementStatusEnum.UN_SETTLED.getType());
            purchaseOrder.setBoolRewrite(Boolean.FALSE);
            if (ObjectUtil.isNotEmpty(purchaseOrder.getApplyPurchaseIds())) {
               this.updateApplyProductQuantityAndMete(purchaseOrder, true);
            }

            this.warehouseDataDashboardService
               .saveInstantMessageHint(
                  InstantMessageHintDTO.builder()
                     .type(MessageEnum.PURCHASE_ORDER.getType())
                     .typeName(MessageEnum.PURCHASE_ORDER.getName())
                     .dateTimeStr(DATE_TIME_FORMATTER.format(purchaseOrder.getReviewPassTime()))
                     .createUser(purchaseOrder.getApplicantName())
                     .serialNumber(purchaseOrder.getSerialNumber())
                     .supplier(this.supplierService.getById(purchaseOrder.getSupplierId()).getName())
                     .basicClass(BasicClassEnum.getNameStr(purchaseOrder.getBasicClass()))
                     .build()
               );
            return this.baseMapper.updateById(purchaseOrder) == 1;
         }

         if (ApproveProcessTypeEnumV2.PURCHASE_ORDER_CANCELLATION.getType().equals(wmsApproveRecord.getApproveProcessType())) {
            if (ObjectUtil.isNotEmpty(purchaseOrder.getApplyDetailMeteJson())) {
               this.updateApplyProductQuantityAndMete(purchaseOrder, false);
            }

            purchaseOrder.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
            purchaseOrder.setDataStatus(DataStatusEnum.CANCELLATION.getType());
            purchaseOrder.setEditable(Boolean.TRUE);
            purchaseOrder.setBoolRewrite(Boolean.TRUE);
            this.removeOrderFinance(purchaseOrder);
            this.warehouseDataDashboardService
               .delInstantMessageHint(
                  InstantMessageHintDTO.builder().type(MessageEnum.PURCHASE_ORDER.getType()).serialNumber(purchaseOrder.getSerialNumber()).build()
               );
            return this.baseMapper.updateById(purchaseOrder) == 1;
         }

         if (ApproveProcessTypeEnumV2.PURCHASE_ORDER_UPDATE_ADD.getType().equals(wmsApproveTemplateVersions.getApproveProcessType())) {
            purchaseOrder.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
            purchaseOrder.setDataStatus(DataStatusEnum.SUCCEED.getType());
            purchaseOrder.setReviewPassTime(LocalDateTime.now());
            purchaseOrder.setPurchaseStatus(PurchaseStatusEnum.DURING.getType());
            purchaseOrder.setSettlementStatus(SettlementStatusEnum.UN_SETTLED.getType());
            purchaseOrder.setBoolRewrite(Boolean.FALSE);
            PurchaseOrder purchaseOrderOld = this.baseMapper.getById(purchaseOrder.getPassParentId());
            if (ObjectUtil.isNotEmpty(purchaseOrderOld.getApplyDetailMeteJson())) {
               this.updateApplyProductQuantityAndMete(purchaseOrderOld, false);
            }

            if (ObjectUtil.isNotEmpty(purchaseOrder.getApplyDetailMeteJson())) {
               this.updateApplyProductQuantityAndMete(purchaseOrder, true);
            }

            this.purchaseOrderDetailMapper
               .update(
                  null,
                  (Wrapper<PurchaseOrderDetail>)(new LambdaUpdateWrapper<PurchaseOrderDetail>().set(PurchaseOrderDetail::getBoolOriginalDetail, true))
                     .eq(PurchaseOrderDetail::getPurchaseId, purchaseOrder.getId())
               );
            this.warehouseDataDashboardService
               .saveInstantMessageHint(
                  InstantMessageHintDTO.builder()
                     .type(MessageEnum.PURCHASE_ORDER.getType())
                     .typeName(MessageEnum.PURCHASE_ORDER.getName())
                     .dateTimeStr(DATE_TIME_FORMATTER.format(purchaseOrder.getReviewPassTime()))
                     .createUser(purchaseOrder.getApplicantName())
                     .serialNumber(purchaseOrder.getSerialNumber())
                     .supplier(this.supplierService.getById(purchaseOrder.getSupplierId()).getName())
                     .basicClass(BasicClassEnum.getNameStr(purchaseOrder.getBasicClass()))
                     .oldSerialNumber(purchaseOrderOld.getSerialNumber())
                     .build()
               );
            return this.baseMapper.updateById(purchaseOrder) == 1;
         }
      }

      if (wmsApproveOpinionDTOParam.getDecision().equals(ReviewStatusEnum.RETURNED.getType())) {
         if (ApproveProcessTypeEnumV2.PURCHASE_ORDER_ADD.getType().equals(wmsApproveRecord.getApproveProcessType())) {
            purchaseOrder.setReviewStatus(ReviewStatusEnum.RETURNED.getType());
            purchaseOrder.setEditable(Boolean.TRUE);
            purchaseOrder.setDataStatus(DataStatusEnum.USELESS.getType());
         } else if (ApproveProcessTypeEnumV2.PURCHASE_ORDER_CANCELLATION.getType().equals(wmsApproveRecord.getApproveProcessType())) {
            purchaseOrder.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
            purchaseOrder.setPurchaseStatus(PurchaseStatusEnum.DURING.getType());
            purchaseOrder.setDataStatus(DataStatusEnum.SUCCEED.getType());
            purchaseOrder.setEditable(Boolean.TRUE);
         } else if (ApproveProcessTypeEnumV2.PURCHASE_ORDER_UPDATE_ADD.getType().equals(wmsApproveRecord.getApproveProcessType())) {
            purchaseOrder.setReviewStatus(ReviewStatusEnum.RETURNED.getType());
            purchaseOrder.setEditable(Boolean.TRUE);
            purchaseOrder.setDataStatus(DataStatusEnum.USELESS.getType());
            this.updateFinanceOrderId(purchaseOrder.getId(), purchaseOrder.getPassParentId());
            if (boolExistInbound) {
               this.purchaseOrderDetailMapper
                  .update(
                     null,
                     (Wrapper<PurchaseOrderDetail>)((new LambdaUpdateWrapper<PurchaseOrderDetail>()
                              .set(PurchaseOrderDetail::getPurchaseId, purchaseOrder.getPassParentId()))
                           .eq(PurchaseOrderDetail::getPurchaseId, purchaseOrder.getId()))
                        .eq(PurchaseOrderDetail::getBoolOriginalDetail, true)
                  );
               if (purchaseOrder.getPurchaseType().equals(PurchaseEnum.MATERIAL.getType())) {
                  this.inboundService
                     .update(
                        null,
                        (Wrapper<Inbound>)(new LambdaUpdateWrapper<Inbound>().set(Inbound::getPurchaseId, purchaseOrder.getPassParentId()))
                           .eq(Inbound::getPurchaseId, purchaseOrder.getId())
                     );
                  this.rejectService
                     .update(
                        null,
                        (Wrapper<Reject>)(new LambdaUpdateWrapper<Reject>().set(Reject::getPurchaseOrderId, purchaseOrder.getPassParentId()))
                           .eq(Reject::getPurchaseOrderId, purchaseOrder.getId())
                     );
                  this.inboundDetailService
                     .update(
                        null,
                        (Wrapper<InboundDetail>)(new LambdaUpdateWrapper<InboundDetail>()
                              .set(InboundDetail::getPurchaseId, purchaseOrder.getPassParentId()))
                           .eq(InboundDetail::getPurchaseId, purchaseOrder.getId())
                     );
               } else if (purchaseOrder.getPurchaseType().equals(PurchaseEnum.FINISHED_GOODS.getType())) {
                  this.inboundManufacturedService
                     .update(
                        null,
                        (Wrapper<InboundManufactured>)(new LambdaUpdateWrapper<InboundManufactured>()
                              .set(InboundManufactured::getPurchaseId, purchaseOrder.getPassParentId()))
                           .eq(InboundManufactured::getPurchaseId, purchaseOrder.getId())
                     );
                  this.inboundDetailManufacturedService
                     .update(
                        null,
                        (Wrapper<InboundDetailManufactured>)(new LambdaUpdateWrapper<InboundDetailManufactured>()
                              .set(InboundDetailManufactured::getPurchaseId, purchaseOrder.getPassParentId()))
                           .eq(InboundDetailManufactured::getPurchaseId, purchaseOrder.getId())
                     );
               } else {
                  Preconditions.checkArgument(false, "未知采购材料类型！！！");
               }
            }

            this.baseMapper.updateBoolDeleteById(purchaseOrder.getPassParentId());
            purchaseOrder.setBoolDeleteEnum(true);
         }
      }

      return this.baseMapper.updateById(purchaseOrder) == 1;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean revocation(Long id) {
      SecurityUser currentUser = UserUtil.getCurrentUser();
      PurchaseOrder purchaseOrder = this.baseMapper.selectById(id);
      Preconditions.checkArgument(purchaseOrder != null, "该采购单不存在,请刷新页面重试");
      Preconditions.checkArgument(currentUser.getId().equals(purchaseOrder.getApplicantId()), "仅创建此采购单的人才可进行撤销操作");
      Preconditions.checkArgument(
         DataStatusEnum.UNDER_REVIEW.getType().equals(purchaseOrder.getDataStatus())
            || DataStatusEnum.CANCELLATION_UNDER_WAY.getType().equals(purchaseOrder.getDataStatus()),
         "只可在创建中或作废中才可撤销申请，撤销失败"
      );
      if (ObjectUtil.isNotEmpty(purchaseOrder.getApproveRecordIdNow())) {
         this.wmsApproveRecordService.revocation(purchaseOrder.getApproveRecordIdNow());
      }

      Boolean boolExistInbound = false;
      if (purchaseOrder.getPurchaseType().equals(PurchaseEnum.MATERIAL.getType())) {
         boolExistInbound = CollectionUtil.isNotEmpty(
            this.inboundService.list((Wrapper<Inbound>)new LambdaQueryWrapper<Inbound>().eq(Inbound::getPurchaseId, purchaseOrder.getId()))
         );
      } else if (purchaseOrder.getPurchaseType().equals(PurchaseEnum.FINISHED_GOODS.getType())) {
         boolExistInbound = CollectionUtil.isNotEmpty(
            this.inboundManufacturedService
               .list((Wrapper<InboundManufactured>)new LambdaQueryWrapper<InboundManufactured>().eq(InboundManufactured::getPurchaseId, purchaseOrder.getId()))
         );
      } else {
         Preconditions.checkArgument(false, "未知采购材料类型！！！");
      }

      if (purchaseOrder.getDataStatus().equals(DataStatusEnum.UNDER_REVIEW.getType())) {
         if (ObjectUtil.isEmpty(purchaseOrder.getPassParentId())) {
            purchaseOrder.setDataStatus(DataStatusEnum.USELESS.getType());
            purchaseOrder.setReviewStatus(ReviewStatusEnum.CANCEL.getType());
            purchaseOrder.setPurchaseStatus(null);
            purchaseOrder.setSettlementStatus(null);
            purchaseOrder.setEditable(Boolean.TRUE);
         } else {
            purchaseOrder.setDataStatus(DataStatusEnum.USELESS.getType());
            purchaseOrder.setReviewStatus(ReviewStatusEnum.CANCEL.getType());
            purchaseOrder.setPurchaseStatus(null);
            purchaseOrder.setSettlementStatus(null);
            purchaseOrder.setEditable(Boolean.TRUE);
            if (boolExistInbound) {
               this.purchaseOrderDetailMapper
                  .update(
                     null,
                     (Wrapper<PurchaseOrderDetail>)((new LambdaUpdateWrapper<PurchaseOrderDetail>()
                              .set(PurchaseOrderDetail::getPurchaseId, purchaseOrder.getPassParentId()))
                           .eq(PurchaseOrderDetail::getPurchaseId, purchaseOrder.getId()))
                        .eq(PurchaseOrderDetail::getBoolOriginalDetail, true)
                  );
               if (purchaseOrder.getPurchaseType().equals(PurchaseEnum.MATERIAL.getType())) {
                  this.inboundService
                     .update(
                        null,
                        (Wrapper<Inbound>)(new LambdaUpdateWrapper<Inbound>().set(Inbound::getPurchaseId, purchaseOrder.getPassParentId()))
                           .eq(Inbound::getPurchaseId, purchaseOrder.getId())
                     );
                  this.rejectService
                     .update(
                        null,
                        (Wrapper<Reject>)(new LambdaUpdateWrapper<Reject>().set(Reject::getPurchaseOrderId, purchaseOrder.getPassParentId()))
                           .eq(Reject::getPurchaseOrderId, purchaseOrder.getId())
                     );
                  this.inboundDetailService
                     .update(
                        null,
                        (Wrapper<InboundDetail>)(new LambdaUpdateWrapper<InboundDetail>()
                              .set(InboundDetail::getPurchaseId, purchaseOrder.getPassParentId()))
                           .eq(InboundDetail::getPurchaseId, purchaseOrder.getId())
                     );
               } else if (purchaseOrder.getPurchaseType().equals(PurchaseEnum.FINISHED_GOODS.getType())) {
                  this.inboundManufacturedService
                     .update(
                        null,
                        (Wrapper<InboundManufactured>)(new LambdaUpdateWrapper<InboundManufactured>()
                              .set(InboundManufactured::getPurchaseId, purchaseOrder.getPassParentId()))
                           .eq(InboundManufactured::getPurchaseId, purchaseOrder.getId())
                     );
                  this.inboundDetailManufacturedService
                     .update(
                        null,
                        (Wrapper<InboundDetailManufactured>)(new LambdaUpdateWrapper<InboundDetailManufactured>()
                              .set(InboundDetailManufactured::getPurchaseId, purchaseOrder.getPassParentId()))
                           .eq(InboundDetailManufactured::getPurchaseId, purchaseOrder.getId())
                     );
               } else {
                  Preconditions.checkArgument(false, "未知采购材料类型！！！");
               }
            }

            this.baseMapper.updateBoolDeleteById(purchaseOrder.getPassParentId());
            purchaseOrder.setBoolDeleteEnum(true);
            this.updateFinanceOrderId(purchaseOrder.getId(), purchaseOrder.getPassParentId());
         }
      }

      if (purchaseOrder.getDataStatus().equals(DataStatusEnum.CANCELLATION_UNDER_WAY.getType())) {
         purchaseOrder.setDataStatus(DataStatusEnum.SUCCEED.getType());
         purchaseOrder.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
         purchaseOrder.setPurchaseStatus(PurchaseStatusEnum.DURING.getType());
         purchaseOrder.setSettlementStatus(SettlementStatusEnum.UN_SETTLED.getType());
         purchaseOrder.setEditable(Boolean.TRUE);
      }

      int i = this.baseMapper.updateById(purchaseOrder);
      Preconditions.checkArgument(i == 1, "撤销失败");
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean cancellation(Long id) {
      PurchaseOrder purchaseOrder = this.baseMapper.selectById(id);
      Preconditions.checkArgument(purchaseOrder.getDataStatus().equals(DataStatusEnum.SUCCEED.getType()), "仅创建成功的采购单可以作废，作废失败！！！");
      if (purchaseOrder.getPurchaseType().equals(PurchaseEnum.MATERIAL.getType())) {
         List<Inbound> list = this.inboundService
            .list(
               (Wrapper<Inbound>)((new LambdaQueryWrapper<Inbound>().eq(Inbound::getPurchaseId, purchaseOrder.getId()))
                     .ne(Inbound::getReviewStatus, ReviewStatusEnum.CANCEL.getType()))
                  .ne(Inbound::getReviewStatus, ReviewStatusEnum.RETURNED.getType())
            );
         if (CollectionUtil.isNotEmpty(list)) {
            List<Inbound> auditingList = list.stream()
               .filter(l -> l.getReviewStatus().equals(ReviewStatusEnum.AUDITING.getType()))
               .collect(Collectors.toList());
            if (CollectionUtil.isNotEmpty(auditingList)) {
               String serialNumber = auditingList.stream().map(Inbound::getSerialNumber).collect(Collectors.joining("，"));
               Preconditions.checkArgument(false, "该采购单有正在审核的入库单【" + serialNumber + "】，作废失败！！！");
            }

            List<Long> inboundIds = list.stream().map(Inbound::getId).collect(Collectors.toList());
            List<InboundDetail> inboundDetails = this.inboundDetailService
               .list((Wrapper<InboundDetail>)new LambdaQueryWrapper<InboundDetail>().in(InboundDetail::getInboundId, inboundIds));
            List<InboundDetail> collect = inboundDetails.stream().filter(i -> i.getMete().compareTo(i.getRejectMete()) != 0).collect(Collectors.toList());
            if (CollectionUtil.isNotEmpty(collect)) {
               List<Long> collect1 = collect.stream().map(InboundDetail::getInboundId).distinct().collect(Collectors.toList());
               String serialNumber = list.stream()
                  .filter(l -> collect1.contains(l.getId()))
                  .collect(Collectors.toList())
                  .stream()
                  .map(Inbound::getSerialNumber)
                  .collect(Collectors.joining("，"));
               Preconditions.checkArgument(false, "该采购单有未退货完成的入库单【" + serialNumber + "】，作废失败！！！");
            }
         }
      } else if (purchaseOrder.getPurchaseType().equals(PurchaseEnum.FINISHED_GOODS.getType())) {
         Preconditions.checkArgument(
            CollectionUtil.isEmpty(
               this.inboundManufacturedService
                  .list((Wrapper<InboundManufactured>)new LambdaQueryWrapper<InboundManufactured>().eq(InboundManufactured::getPurchaseId, purchaseOrder.getId()))
            ),
            "该采购单已绑定制成品入库作废失败！！！"
         );
      } else {
         Preconditions.checkArgument(false, "未知采购材料类型！！！");
      }

      this.removeOrderCheckFinance(id);
      this.checkReceived(purchaseOrder);
      purchaseOrder.setDataStatus(DataStatusEnum.CANCELLATION_UNDER_WAY.getType());
      purchaseOrder.setReviewStatus(ReviewStatusEnum.AUDITING.getType());
      MountMessageDTO mountMessageDTO = new MountMessageDTO();
      List<Integer> projectAttributes = new ArrayList<>();
      projectAttributes.add(purchaseOrder.getProjectAttribute());
      mountMessageDTO.setProjectAttribute(projectAttributes);
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService
         .createRecord(
            purchaseOrder.getId(),
            purchaseOrder.getSerialNumber(),
            ApproveProcessTypeEnumV2.PURCHASE_ORDER_CANCELLATION.getType(),
            null,
            null,
            null,
            false,
            mountMessageDTO,
            null,
            null
         );
      purchaseOrder.setApproveRecordIdNow(wmsApproveRecord.getId());
      if (ObjectUtil.isNotEmpty(purchaseOrder.getApproveRecordIds())) {
         purchaseOrder.setApproveRecordIds(purchaseOrder.getApproveRecordIds() + "," + wmsApproveRecord.getId());
      } else {
         purchaseOrder.setApproveRecordIds(wmsApproveRecord.getId().toString());
      }

      if (wmsApproveRecord.getStatus().equals(ApproveRecordStatusEnum.END.getType())) {
         purchaseOrder.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
         purchaseOrder.setDataStatus(DataStatusEnum.CANCELLATION.getType());
         purchaseOrder.setEditable(Boolean.TRUE);
         purchaseOrder.setBoolRewrite(Boolean.TRUE);
         if (ObjectUtil.isNotEmpty(purchaseOrder.getApplyDetailMeteJson())) {
            this.updateApplyProductQuantityAndMete(purchaseOrder, false);
         }
      }

      return this.baseMapper.updateById(purchaseOrder) == 1;
   }

   private void checkReceived(PurchaseOrder purchaseOrder) {
      if (PlaceEnum.CONSTRUCTION_SITE.getType().equals(purchaseOrder.getOrderPlace()) && purchaseOrder.getBoolDetail()) {
         List<Long> detailIds = this.purchaseOrderDetailMapper
            .selectList(Wrappers.lambdaQuery(PurchaseOrderDetail.class).eq(PurchaseOrderDetail::getPurchaseId, purchaseOrder.getId()))
            .stream()
            .map(PurchaseOrderDetail::getId)
            .collect(Collectors.toList());
         int count = this.receivingRecordService
            .count(Wrappers.lambdaQuery(ProjectReceivingRecord.class).in(ProjectReceivingRecord::getPurchaseDetailsId, detailIds));
         Preconditions.checkArgument(count == 0, "该订单已外购收货!");
      }
   }

   @Override
   public void purchaseExcel(Long id, HttpServletResponse response) {
      PurchaseOrder purchaseOrder = this.baseMapper.getById(id);
      Preconditions.checkArgument(purchaseOrder != null, "采购订单不存在");
      Preconditions.checkArgument(PurchaseEnum.MATERIAL.getType().equals(purchaseOrder.getPurchaseType())
         || PurchaseEnum.FINISHED_GOODS.getType().equals(purchaseOrder.getPurchaseType()), "采购类型不正确");
      String resourcePath = purchaseOrder.getPurchaseType().equals(PurchaseEnum.MATERIAL.getType())
         ? "files/templateV2/自合营采购详情.xlsx"
         : "files/templateV2/自合营采购详情-制成品.xlsx";
      String tempFileName = "自合营采购详情";
      String exportFileName = "自合营采购详情.xlsx";
      String message = null;
      HashMap<String, Object> map = new HashMap<>(16);
      map.put("serialNumber", purchaseOrder.getSerialNumber());
      map.put("contractType", purchaseOrder.getBoolAnnual() == null ? "-" : (Boolean.TRUE.equals(purchaseOrder.getBoolAnnual()) ? "年度合同" : "非年度合同"));
      if (purchaseOrder.getSupplierId() != null) {
         map.put("shortName", this.supplierService.getById(purchaseOrder.getSupplierId()).getShortName());
      }

      if (purchaseOrder.getBranchCompanyId() != null) {
         map.put("branchCompanyName", this.branchCompanyService.getById(purchaseOrder.getBranchCompanyId()).getName());
      }

      if (InvoiceTypeEnum.SPECIAL.getType().equals(purchaseOrder.getInvoiceType())) {
         map.put("InvoiceType", "专用发票(" + purchaseOrder.getTaxRate() + "%)");
      } else if (InvoiceTypeEnum.ORDINARY.getType().equals(purchaseOrder.getInvoiceType())) {
         map.put("InvoiceType", "普通发票(" + purchaseOrder.getTaxRate() + "%)");
      } else {
         map.put("InvoiceType", "收据");
      }

      map.put("weightMeasurementMode", "-");
      if (purchaseOrder.getWeightMeasurementMode() != null) {
         if (purchaseOrder.getPurchaseType().equals(PurchaseEnum.MATERIAL.getType())) {
            if (purchaseOrder.getWeightMeasurementMode() == 1) {
               map.put("weightMeasurementMode", "理计");
            } else if (purchaseOrder.getWeightMeasurementMode() == 2) {
               map.put("weightMeasurementMode", "磅计");
            } else {
               map.put("weightMeasurementMode", "混合计");
            }
         } else {
            map.put("weightMeasurementMode", "混合计");
         }
      }

      if (purchaseOrder.getAttachments() != null) {
         List<AttachmentDTO> attachmentDTOS = this.attachmentService.listByIds(purchaseOrder.getAttachments());
         List<String> att = new ArrayList<>();

         for (AttachmentDTO attachmentDTO : attachmentDTOS) {
            att.add(attachmentDTO.getName());
         }

         map.put("Attachment", String.join(",", att));
      } else {
         map.put("Attachment", "-");
      }

      if (purchaseOrder.getBasicClass() == null) {
         map.put("materialType", "-");
      } else if (Boolean.TRUE.equals(purchaseOrder.getBoolDetail())) {
         map.put("materialType", BasicClassEnum.getNameStr1(purchaseOrder.getBasicClass()));
      } else {
         map.put("materialType", BasicClassEnum.getNameStr(purchaseOrder.getBasicClass()));
      }

      map.put("logisticsTransportType", purchaseOrder.getLogisticsTransportType() == null ? "-" : (LogisticsTransportTypeEnum.FREIGHT.getType().equals(purchaseOrder.getLogisticsTransportType()) ? "货运" : "邮递"));
      map.put(
         "purchaseOrderPaymentMode",
         purchaseOrder.getPurchaseOrderPaymentMode() == null ? "-" : PurchaseOrderModeEnum.FUTURE.getType().equals(purchaseOrder.getPurchaseOrderPaymentMode())
            ? "期货订单"
            : (PurchaseOrderModeEnum.SPOT.getType().equals(purchaseOrder.getPurchaseOrderPaymentMode()) ? "现货订单" : "到货订单")
      );
      map.put(
         "logisticsPayerType",
         LogisticsPayerEnum.DEMAND.getType().equals(purchaseOrder.getLogisticsPayerType())
            ? "需方承担"
            : (LogisticsPayerEnum.SUPPLIER.getType().equals(purchaseOrder.getLogisticsPayerType()) ? "供方承担" : "-")
      );
      if (purchaseOrder.getApplyPurchaseIds() != null) {
         map.put("applyPurchaseSN", purchaseOrder.getApplyPurchaseSN());
      } else {
         map.put("applyPurchaseSN", "-");
      }

      map.put("level", purchaseOrder.getOrderPlace() == null ? "-" : (PlaceEnum.CONSTRUCTION_SITE.getType().equals(purchaseOrder.getOrderPlace()) ? "工地" : "工厂"));
      map.put("mete", purchaseOrder.getMete());
      map.put("amount", purchaseOrder.getAmount());
      map.put("remark", purchaseOrder.getRemark() != null ? purchaseOrder.getRemark() : "-");
      map.put("mesWorkshopName", purchaseOrder.getWorkshopId() != null ? this.mesWorkshopService.getWorkshopById(purchaseOrder.getWorkshopId()).getName() : "-");
      List<PurchaseOrderDetail> purchaseOrderDetails = this.purchaseOrderDetailMapper
         .selectList((Wrapper<PurchaseOrderDetail>)new LambdaQueryWrapper<PurchaseOrderDetail>().eq(PurchaseOrderDetail::getPurchaseId, purchaseOrder.getId()));
      BigDecimal MeteCount = new BigDecimal("0");
      BigDecimal amountCount = new BigDecimal("0.0");
      BigDecimal quantityCount = new BigDecimal("0");
      new BigDecimal(1000);
      int size = 12;
      BasicShowConfig basicShowConfig = this.basicConfigService.getBasicShowConfig();
      Map<String, Unit> unitMap = this.unitService.list(new LambdaQueryWrapper<>()).stream().collect(Collectors.toMap(Unit::getName, Function.identity()));
      if (purchaseOrderDetails.size() > 0) {
         size += purchaseOrderDetails.size();
         List<Map<String, Object>> mapList = new ArrayList<>();
         Integer orderNo = 1;

         for (PurchaseOrderDetail purchaseOrderDetail : purchaseOrderDetails) {
            Map<String, Object> mapObject = new HashMap<>();
            Integer cellStyle = orderNo;
            orderNo = orderNo + 1;
            mapObject.put("orderNo", cellStyle);
            mapObject.put("applyPurchaseSN", purchaseOrderDetail.getApplyPurchaseSN() != null ? purchaseOrderDetail.getApplyPurchaseSN() : "-");
            if (purchaseOrder.getPurchaseType().equals(PurchaseEnum.MATERIAL.getType())) {
               Classification classification = this.classificationService.getById(purchaseOrderDetail.getClassifyId());
               mapObject.put("classifySerialNumber", classification.getSerialNumber());
               mapObject.put("classifyName", classification.getName());
               Measure measure = this.measureService
                  .getOne((Wrapper<Measure>)new LambdaQueryWrapper<Measure>().eq(Measure::getClassificationId, classification.getId()));
               mapObject.put("unit", measure.getMeasureUnit());
               mapObject.put("model", ObjectUtil.isNotEmpty(purchaseOrderDetail.getSpecification()) ? purchaseOrderDetail.getSpecification() : "-");
               mapObject.put("specification", this.queryUtilService.getConfigShowSpec(JSON.toJSONString(purchaseOrderDetail), basicShowConfig));
               Map<Integer, BigDecimal> decimalMap = this.unitConversionV2(
                  purchaseOrderDetail.getMete(), measure.getAccountingUnit(), measure.getAccountingPrecision(), unitMap
               );
               mapObject.put("unitPrice", purchaseOrderDetail.getUnitPrice().multiply(decimalMap.get(2)).setScale(2, 4));
               mapObject.put("mete", decimalMap.get(1).toPlainString());
               MeteCount = MeteCount.add(decimalMap.get(1));
            } else {
               mapObject.put(
                  "manufacturedName", ObjectUtil.isNotEmpty(purchaseOrderDetail.getManufacturedName()) ? purchaseOrderDetail.getManufacturedName() : "-"
               );
               mapObject.put(
                  "finishedGoodsTypeName",
                  ObjectUtil.isNotEmpty(purchaseOrderDetail.getFinishedGoodsTypeName()) ? purchaseOrderDetail.getFinishedGoodsTypeName() : "-"
               );
               mapObject.put("manufacturedSn", ObjectUtil.isNotEmpty(purchaseOrderDetail.getManufacturedSn()) ? purchaseOrderDetail.getManufacturedSn() : "-");
               mapObject.put(
                  "manufacturedSpecification",
                  ObjectUtil.isNotEmpty(purchaseOrderDetail.getManufacturedSpecification()) ? purchaseOrderDetail.getManufacturedSpecification() : "-"
               );
               mapObject.put("specification", ObjectUtil.isNotEmpty(purchaseOrderDetail.getSpecification()) ? purchaseOrderDetail.getSpecification() : "-");
               mapObject.put("material", ObjectUtil.isNotEmpty(purchaseOrderDetail.getMaterial()) ? purchaseOrderDetail.getMaterial() : "-");
               mapObject.put(
                  "manufacturedUnit", ObjectUtil.isNotEmpty(purchaseOrderDetail.getManufacturedUnit()) ? purchaseOrderDetail.getManufacturedUnit() : "-"
               );
               if (purchaseOrderDetail.getWageQuotaType().equals(WmsWageQuotaTypeEnum.WMS_WEIGHT_PRICE.getType())) {
                  mapObject.put("mete", purchaseOrderDetail.getTotalWeight().divide(UnitsPrecisionEnum.EG_T.getRate()));
                  mapObject.put("unitPrice", purchaseOrderDetail.getUnitPrice().multiply(UnitsPrecisionEnum.EG_T.getRate()));
                  mapObject.put("meteUnit", UnitsPrecisionEnum.EG_T.getName());
               } else if (purchaseOrderDetail.getWageQuotaType().equals(WmsWageQuotaTypeEnum.WMS_LENGTH_PRICE.getType())) {
                  mapObject.put("mete", purchaseOrderDetail.getTotalLength().divide(UnitsPrecisionEnum.LG_M.getRate()));
                  mapObject.put("unitPrice", purchaseOrderDetail.getUnitPrice().multiply(UnitsPrecisionEnum.LG_M.getRate()));
                  mapObject.put("meteUnit", UnitsPrecisionEnum.LG_M.getName());
               } else if (purchaseOrderDetail.getWageQuotaType().equals(WmsWageQuotaTypeEnum.WMS_AREA_PRICE.getType())) {
                  mapObject.put("mete", purchaseOrderDetail.getTotalArea().divide(UnitsPrecisionEnum.AG_M.getRate()));
                  mapObject.put("unitPrice", purchaseOrderDetail.getUnitPrice().multiply(UnitsPrecisionEnum.AG_M.getRate()));
                  mapObject.put("meteUnit", UnitsPrecisionEnum.AG_M.getName());
               } else if (purchaseOrderDetail.getWageQuotaType().equals(WmsWageQuotaTypeEnum.WMS_QUANTITY_PRICE.getType())) {
                  mapObject.put("mete", purchaseOrderDetail.getQuantity());
                  mapObject.put("unitPrice", purchaseOrderDetail.getUnitPrice());
                  mapObject.put("meteUnit", "-");
               } else {
                  mapObject.put("mete", purchaseOrderDetail.getQuantity());
                  mapObject.put("unitPrice", purchaseOrderDetail.getUnitPrice());
                  mapObject.put("meteUnit", "-");
               }

               MeteCount = MeteCount.add(new BigDecimal(String.valueOf(mapObject.get("mete"))));
            }

            mapObject.put("quantity", purchaseOrderDetail.getQuantity());
            mapObject.put("amount", purchaseOrderDetail.getAmount().setScale(2, RoundingMode.HALF_UP));
            mapObject.put("brand", ObjectUtil.isNotEmpty(purchaseOrderDetail.getBrand()) ? purchaseOrderDetail.getBrand() : "-");
            mapObject.put(
               "projectName",
               ObjectUtil.isNotEmpty(purchaseOrderDetail.getProjectId()) && purchaseOrderDetail.getProjectId() > 0L
                  ? this.contractProjectService.getById(purchaseOrderDetail.getProjectId()).getShortName()
                  : "-"
            );
            MesBuildingFactory byId = this.factoryService.getById(purchaseOrderDetail.getFactoryId());
            mapObject.put("factoryName", ObjectUtil.isNotEmpty(byId) ? byId.getShortName() : "-");
            amountCount = amountCount.add(purchaseOrderDetail.getAmount());
            quantityCount = quantityCount.add(purchaseOrderDetail.getQuantity() != null ? purchaseOrderDetail.getQuantity() : BigDecimal.ZERO);
            mapList.add(mapObject);
         }

         map.put("mapList", mapList);
      }

      if (purchaseOrder.getBasicClass() == null) {
         map.put("materialType", "-");
      } else if (Boolean.TRUE.equals(purchaseOrder.getBoolDetail())) {
         map.put("meteCount", MeteCount);
         map.put("amountCount", amountCount.setScale(2, RoundingMode.HALF_UP));
         map.put("quantityCount", quantityCount);
      }

      InputStream inputStream = null;
      File file = null;

      try {
         org.springframework.core.io.Resource resource = new ClassPathResource(resourcePath);
         inputStream = resource.getInputStream();
         file = File.createTempFile(tempFileName, ".xlsx");
      } catch (Exception e) {
         e.printStackTrace();
      }

      FileUtil.copyInputStreamToFile(inputStream, file);
      assert file != null;
      TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath());
      Workbook workbook = ExcelExportUtil.exportExcel(params, map);
      Sheet sheet = workbook.getSheetAt(0);
      CellStyle cellStyle = workbook.createCellStyle();
      cellStyle.setAlignment(HorizontalAlignment.CENTER);
      cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
      cellStyle.setBorderTop(BorderStyle.THIN);
      cellStyle.setBorderBottom(BorderStyle.THIN);
      cellStyle.setBorderLeft(BorderStyle.THIN);
      cellStyle.setBorderRight(BorderStyle.THIN);
      int approvalStartRow = size + 6;
      Row approvalHeaderRow = sheet.createRow(approvalStartRow);
      Cell approvalHeaderCell = approvalHeaderRow.createCell(0);
      approvalHeaderCell.setCellValue("审批信息");
      CellRangeAddress cellAddresses = new CellRangeAddress(approvalStartRow, approvalStartRow, 0, 5);
      PoiUtils.setRegionStyle(sheet, cellAddresses, cellStyle);
      sheet.addMergedRegion(cellAddresses);
      if (ObjectUtil.isNotEmpty(purchaseOrder) && ObjectUtil.isNotEmpty(purchaseOrder.getApproveRecordIdNow())) {
         Row approvalTitleRow = sheet.createRow(approvalStartRow + 1);
         String[] approvalTitles = new String[]{"节点", "审批人", "到达时间", "审批时间", "审批结果", "审批意见"};

         for (int i = 0; i < approvalTitles.length; i++) {
            Cell cell = approvalTitleRow.createCell(i);
            cell.setCellValue(approvalTitles[i]);
            cell.setCellStyle(cellStyle);
         }

         List<ApproveRecordDetailExportDTO> approveRecordDetailExportDTOS = this.wmsApproveRecordService.getExport(purchaseOrder.getApproveRecordIdNow());
         int startRow = approvalStartRow + 2;

         for (int i = 0; i < approveRecordDetailExportDTOS.size(); i++) {
            ApproveRecordDetailExportDTO info = approveRecordDetailExportDTOS.get(i);
            Row dataRow = sheet.createRow(startRow + i);
            Cell node = dataRow.createCell(0);
            node.setCellValue(info.getFlowTypeName());
            node.setCellStyle(cellStyle);
            Cell approver = dataRow.createCell(1);
            approver.setCellValue(info.getCheckUserName());
            approver.setCellStyle(cellStyle);
            Cell arrivalTime = dataRow.createCell(2);
            arrivalTime.setCellValue(info.getArrivalTimeStr());
            arrivalTime.setCellStyle(cellStyle);
            Cell approvalTime = dataRow.createCell(3);
            approvalTime.setCellValue(info.getApproveTimeStr());
            approvalTime.setCellStyle(cellStyle);
            Cell approvalResult = dataRow.createCell(4);
            approvalResult.setCellValue(info.getDecisionStr());
            approvalResult.setCellStyle(cellStyle);
            Cell approvalComment = dataRow.createCell(5);
            approvalComment.setCellValue(info.getOpinion());
            approvalComment.setCellStyle(cellStyle);
         }

         this.mergeApprovalNodes(sheet, approvalStartRow + 2, approveRecordDetailExportDTOS);
      }

      PoiUtils.wmsDownLoadExcel(exportFileName, response, workbook, message);
   }

   private Map<Integer, BigDecimal> unitConversionV2(BigDecimal value, String unit, Integer scale, Map<String, Unit> unitMap) {
      Unit u = unitMap.get(unit);
      Map<Integer, BigDecimal> map = new HashMap<>();
      if (scale == null) {
         scale = 0;
      }

      if (UnitEnum.DIGIT.getType().equals(u.getType())) {
         map.put(2, BigDecimal.ONE);
         map.put(1, new BigDecimal(value.stripTrailingZeros().toPlainString()));
      } else {
         BigDecimal precision = UnitsPrecisionEnum.getByName(unit);
         map.put(1, value.divide(precision, scale, 4));
         map.put(2, precision);
      }

      return map;
   }

   private void mergeApprovalNodes(Sheet sheet, int startRow, List<ApproveRecordDetailExportDTO> approveRecordDetailExportDTOS) {
      int mergeStart = startRow;
      String previousValue = null;
      Long previousFlowId = null;

      for (int i = 0; i < approveRecordDetailExportDTOS.size(); i++) {
         String currentValue = approveRecordDetailExportDTOS.get(i).getFlowTypeName();
         Long currentFlowId = null;
         if (ObjectUtil.isNotEmpty(approveRecordDetailExportDTOS.get(i).getFlowId())) {
            currentFlowId = approveRecordDetailExportDTOS.get(i).getFlowId();
         }

         if (previousValue != null && (ObjectUtil.isEmpty(previousFlowId) || !currentValue.equals(previousValue) || !currentFlowId.equals(previousFlowId))) {
            if (mergeStart != startRow + i - 1) {
               sheet.addMergedRegion(new CellRangeAddress(mergeStart, startRow + i - 1, 0, 0));
            }

            mergeStart = startRow + i;
         }

         previousValue = currentValue;
         previousFlowId = currentFlowId;
      }

      if (mergeStart != startRow + approveRecordDetailExportDTOS.size() - 1) {
         sheet.addMergedRegion(new CellRangeAddress(mergeStart, startRow + approveRecordDetailExportDTOS.size() - 1, 0, 0));
      }
   }

   @Override
   public List<UserResponseVO> selectUserList() {
      List<Integer> projectAttributes = new ArrayList<>();
      projectAttributes.add(ProjectAttributeEnum.JOINT_VENTURE.getType());
      projectAttributes.add(ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType());
      List<ContractProject> list = this.contractProjectService
         .list(
            (Wrapper<ContractProject>)(new LambdaQueryWrapper<ContractProject>().isNotNull(ContractProject::getProjectManagerId))
               .in(ContractProject::getProjectAttribute, projectAttributes)
         );
      if (CollectionUtil.isNotEmpty(list)) {
         List<Long> collect = list.stream().map(ContractProject::getProjectManagerId).distinct().collect(Collectors.toList());
         List<User> list1 = this.userService.list((Wrapper<User>)new LambdaQueryWrapper<User>().in(User::getId, collect));
         return cn.hutool.core.bean.BeanUtil.copyToList(list1, UserResponseVO.class);
      } else {
         return null;
      }
   }

   @Override
   public List<ProjectRelevancyDTO> selectProjectList() {
      List<ProjectRelevancyDTO> projectRelevancyDTOS = new ArrayList<>();

      for (ContractProject contractProject : this.contractProjectService.list()) {
         ProjectRelevancyDTO projectRelevancyDTO = BeanUtil.copy(contractProject, ProjectRelevancyDTO.class);
         if (contractProject.getProjectManagerId() != null) {
            User user = this.userService.getById(contractProject.getProjectManagerId());
            projectRelevancyDTO.setProjectManagerId(user.getId());
            projectRelevancyDTO.setProjectManagerName(user.getName());
         }

         List<ProjectBranchCompanyLink> projectBranchCompanyLinks = this.companyLinkService
            .list((Wrapper<ProjectBranchCompanyLink>)new LambdaQueryWrapper<ProjectBranchCompanyLink>().eq(ProjectBranchCompanyLink::getProjectId, contractProject.getId()));
         List<ProjectBranchCompanyLinkDTO> projectBranchCompanyLinkDTOS = cn.hutool.core.bean.BeanUtil.copyToList(
            projectBranchCompanyLinks, ProjectBranchCompanyLinkDTO.class
         );
         projectRelevancyDTO.setCompanyLinkDTO(projectBranchCompanyLinkDTOS);
         projectRelevancyDTOS.add(projectRelevancyDTO);
      }

      return projectRelevancyDTOS;
   }

   @Override
   public Set<Long> selectCreatedProject() {
      Set<Long> projectAllIds = new HashSet<>();

      for (String projectId : this.baseMapper
         .selectList(
            (Wrapper<PurchaseOrder>)((((((new LambdaQueryWrapper<PurchaseOrder>()
                                 .eq(PurchaseOrder::getDataStatus, DataStatusEnum.SUCCEED.getType()))
                              .or())
                           .eq(PurchaseOrder::getDataStatus, DataStatusEnum.UNDER_REVIEW.getType()))
                        .or())
                     .eq(PurchaseOrder::getDataStatus, DataStatusEnum.CANCELLATION_UNDER_WAY.getType()))
                  .or())
               .eq(PurchaseOrder::getBoolTemporaryStorage, Boolean.TRUE)
         )
         .stream()
         .map(PurchaseOrder::getProjectIds)
         .collect(Collectors.toList())) {
         for (Long aLong : this.contractProjectService.listByIds(projectId).stream().map(ProjectInfo::getId).collect(Collectors.toList())) {
            projectAllIds.add(aLong);
         }
      }

      return projectAllIds;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean againSubmitPurchaseOrder(PurchaseOrderDTOParam param) {
      PurchaseOrder purchaseOrderOld = this.baseMapper.selectById(param.getId());
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(purchaseOrderOld), "未查询到采购单信息");
      Preconditions.checkArgument(
         ObjectUtil.isNotEmpty(purchaseOrderOld.getPurchaseStatus()) && purchaseOrderOld.getPurchaseStatus().equals(PurchaseStatusEnum.DURING.getType()),
         "采购单状态为通过、采购中的才可再次申请"
      );
      Preconditions.checkArgument(
         ObjectUtil.isNotEmpty(purchaseOrderOld.getSettlementStatus())
            && purchaseOrderOld.getSettlementStatus().equals(SettlementStatusEnum.UN_SETTLED.getType()),
         "采购单状态为通过、未结算的才可再次申请"
      );
      Preconditions.checkArgument(purchaseOrderOld.getDataStatus().equals(DataStatusEnum.SUCCEED.getType()), "未通过的采购单禁止再次发起申请");
      Boolean boolExistInbound = false;
      if (purchaseOrderOld.getPurchaseType().equals(PurchaseEnum.MATERIAL.getType())) {
         List<Inbound> list = this.inboundService
            .list(
               (Wrapper<Inbound>)(((new LambdaQueryWrapper<Inbound>()
                           .eq(Inbound::getPurchaseId, purchaseOrderOld.getId()))
                        .ne(Inbound::getReviewStatus, ReviewStatusEnum.CANCEL.getType()))
                     .ne(Inbound::getReviewStatus, ReviewStatusEnum.RETURNED.getType()))
                  .ne(Inbound::getRejectStatus, RejectEnum.All_REJECT.getType())
            );
         if (param.isBoolUsed() != CollectionUtil.isNotEmpty(list)) {
            Preconditions.checkArgument(false, "该采购单已存在入库数据！！！请刷新页面重新编辑！！！");
         }

         if (CollectionUtil.isNotEmpty(list)) {
            boolExistInbound = true;
         }
      } else if (purchaseOrderOld.getPurchaseType().equals(PurchaseEnum.FINISHED_GOODS.getType())) {
         List<InboundManufactured> inboundManufactureds = this.inboundManufacturedService
            .list((Wrapper<InboundManufactured>)new LambdaQueryWrapper<InboundManufactured>().eq(InboundManufactured::getPurchaseId, purchaseOrderOld.getId()));
         if (param.isBoolUsed() != CollectionUtil.isNotEmpty(inboundManufactureds)) {
            Preconditions.checkArgument(false, "该采购单已存在入库数据！！！请刷新页面重新编辑！！！");
         }

         if (CollectionUtil.isNotEmpty(inboundManufactureds)) {
            boolExistInbound = true;
         }
      } else {
         Preconditions.checkArgument(false, "未知采购材料类型！！！");
      }

      if (param.getAmount().compareTo(purchaseOrderOld.getAmount()) < 0) {
         this.updateOrderCheckFinance(param.getId(), param.getAmount());
      }

      Long orderId = null;
      String serialNumber = null;
      if (PlaceEnum.FACTORY.getType().equals(purchaseOrderOld.getOrderPlace()) && !boolExistInbound
         || PlaceEnum.CONSTRUCTION_SITE.getType().equals(purchaseOrderOld.getOrderPlace()) && purchaseOrderOld.getReceiveState().equals(1)) {
         if (ObjectUtil.isNotEmpty(param.getSerialNumber()) && param.getSerialNumber().equals(purchaseOrderOld.getSerialNumber())) {
            param.setBoolSysgen(purchaseOrderOld.getBoolSysgen());
         } else {
            param.setBoolSysgen(false);
         }

         Boolean b = this.saveV2(param, true);
         orderId = param.getId();
         serialNumber = param.getSerialNumber();
         Preconditions.checkArgument(b, "采购单创建失败");
      } else {
         PurchaseOrder purchaseOrderNew = cn.hutool.core.bean.BeanUtil.toBean(purchaseOrderOld, PurchaseOrder.class);
         purchaseOrderNew.setId(null);
         purchaseOrderNew.setAmount(param.getAmount());
         purchaseOrderNew.setApplyPurchaseStatus(param.getApplyPurchaseStatus());
         purchaseOrderNew.setUpdateTime(LocalDateTime.now());
         purchaseOrderNew.setAttachments(param.getAttachmentIds().toString());
         purchaseOrderNew.setAttachments(CollectionUtil.isNotEmpty(param.getAttachmentIds()) ? StrUtil.join(",", param.getAttachmentIds()) : null);
         purchaseOrderNew.setPassParentId(purchaseOrderOld.getId());
         purchaseOrderNew.setBasicClass(param.getBasicClass());
         purchaseOrderNew.setDelDetailIds(CollectionUtil.isNotEmpty(param.getDelDetailIds()) ? CollectionUtil.join(param.getDelDetailIds(), ",") : null);
         this.baseMapper.insert(purchaseOrderNew);
         this.checkDelPurchaseDetail(purchaseOrderOld, param.getDelDetailIds());
         if (CollectionUtil.isNotEmpty(param.getList())) {
            List<PurchaseOrderDetailDTOParam> addDetails = param.getList()
               .stream()
               .filter(p -> ObjectUtil.isEmpty(p.getBoolOriginalDetail()) || !p.getBoolOriginalDetail())
               .collect(Collectors.toList());
            if (CollectionUtil.isNotEmpty(addDetails)) {
               addDetails.forEach(a -> a.setBoolOriginalDetail(false));
               param.setList(addDetails);
               this.saveDetailV2(param, purchaseOrderNew);
               List<PurchaseOrderDetail> oldPurchaseOrderDetails = this.purchaseOrderDetailMapper
                  .selectList(
                     (Wrapper<PurchaseOrderDetail>)(new LambdaQueryWrapper<PurchaseOrderDetail>()
                           .eq(PurchaseOrderDetail::getPurchaseId, purchaseOrderOld.getId()))
                        .isNotNull(PurchaseOrderDetail::getApplyPurchaseDetailId)
                  );
               List<DetailQuantityAndMete> detailQuantityAndMetes = oldPurchaseOrderDetails.stream()
                  .map(
                     p -> DetailQuantityAndMete.builder()
                        .id(p.getApplyPurchaseDetailId())
                        .quantity(p.getQuantity())
                        .mete(p.getMete())
                        .classifyId(p.getClassifyId())
                        .build()
                  )
                  .collect(Collectors.toList());
               List<DetailQuantityAndMete> newDetailQuantityAndMetes = JSONArray.parseArray(
                  purchaseOrderNew.getApplyDetailMeteJson(), DetailQuantityAndMete.class
               );
               if (CollectionUtil.isNotEmpty(newDetailQuantityAndMetes)) {
                  detailQuantityAndMetes.addAll(newDetailQuantityAndMetes);
               }

               purchaseOrderNew.setApplyDetailMeteJson(CollectionUtil.isNotEmpty(detailQuantityAndMetes) ? JSON.toJSONString(newDetailQuantityAndMetes) : null);
               this.baseMapper.updateById(purchaseOrderNew);
            }
         }

         orderId = purchaseOrderNew.getId();
         serialNumber = purchaseOrderNew.getSerialNumber();
         this.purchaseOrderDetailMapper
            .update(
               null,
               ((new LambdaUpdateWrapper<PurchaseOrderDetail>().set(PurchaseOrderDetail::getPurchaseId, purchaseOrderNew.getId()))
                     .eq(PurchaseOrderDetail::getPurchaseId, purchaseOrderOld.getId()))
                  .notIn(CollectionUtil.isNotEmpty(param.getDelDetailIds()), PurchaseOrderDetail::getId, param.getDelDetailIds())
            );
         this.logisticsOrderService
            .update(
               null,
               (Wrapper<LogisticsOrder>)(new LambdaUpdateWrapper<LogisticsOrder>().set(LogisticsOrder::getPurchaseId, purchaseOrderNew.getId()))
                  .eq(LogisticsOrder::getPurchaseId, purchaseOrderOld.getId())
            );
         if (purchaseOrderOld.getPurchaseType().equals(PurchaseEnum.MATERIAL.getType())) {
            this.inboundService
               .update(
                  null,
                  (Wrapper<Inbound>)(new LambdaUpdateWrapper<Inbound>().set(Inbound::getPurchaseId, purchaseOrderNew.getId()))
                     .eq(Inbound::getPurchaseId, purchaseOrderOld.getId())
               );
            this.rejectService
               .update(
                  null,
                  (Wrapper<Reject>)(new LambdaUpdateWrapper<Reject>().set(Reject::getPurchaseOrderId, purchaseOrderNew.getId()))
                     .eq(Reject::getPurchaseOrderId, purchaseOrderOld.getId())
               );
            this.inboundDetailService
               .update(
                  null,
                  (Wrapper<InboundDetail>)(new LambdaUpdateWrapper<InboundDetail>().set(InboundDetail::getPurchaseId, purchaseOrderNew.getId()))
                     .eq(InboundDetail::getPurchaseId, purchaseOrderOld.getId())
               );
         } else if (purchaseOrderOld.getPurchaseType().equals(PurchaseEnum.FINISHED_GOODS.getType())) {
            this.inboundManufacturedService
               .update(
                  null,
                  (Wrapper<InboundManufactured>)(new LambdaUpdateWrapper<InboundManufactured>()
                        .set(InboundManufactured::getPurchaseId, purchaseOrderNew.getId()))
                     .eq(InboundManufactured::getPurchaseId, purchaseOrderOld.getId())
               );
            this.inboundDetailManufacturedService
               .update(
                  null,
                  (Wrapper<InboundDetailManufactured>)(new LambdaUpdateWrapper<InboundDetailManufactured>()
                        .set(InboundDetailManufactured::getPurchaseId, purchaseOrderNew.getId()))
                     .eq(InboundDetailManufactured::getPurchaseId, purchaseOrderOld.getId())
               );
         } else {
            Preconditions.checkArgument(false, "未知采购材料类型！！！");
         }
      }

      MountMessageDTO mountMessageDTO = new MountMessageDTO();
      List<Integer> projectAttributes = new ArrayList<>();
      projectAttributes.add(param.getProjectAttribute());
      mountMessageDTO.setProjectAttribute(projectAttributes);
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService
         .createRecord(
            orderId, serialNumber, ApproveProcessTypeEnumV2.PURCHASE_ORDER_UPDATE_ADD.getType(), null, null, null, false, mountMessageDTO, null, null
         );
      PurchaseOrder purchaseOrder = this.baseMapper.selectById(orderId);
      List<PurchaseOrderDetail> purchaseOrderDetails = this.purchaseOrderDetailMapper
         .selectList((Wrapper<PurchaseOrderDetail>)new LambdaQueryWrapper<PurchaseOrderDetail>().eq(PurchaseOrderDetail::getPurchaseId, purchaseOrder.getId()));
      if (CollectionUtil.isNotEmpty(purchaseOrderDetails)) {
         List<String> orderDetailIds = purchaseOrderDetails.stream().map(PurchaseOrderDetail::getId).map(String::valueOf).collect(Collectors.toList());
         String s = StringUtils.list2String(orderDetailIds, ",");
         purchaseOrder.setDetailIds(s);
      }

      purchaseOrder.setReviewStatus(ReviewStatusEnum.AUDITING.getType());
      purchaseOrder.setDataStatus(DataStatusEnum.UNDER_REVIEW.getType());
      purchaseOrder.setEditable(Boolean.FALSE);
      purchaseOrder.setBoolRewrite(Boolean.FALSE);
      purchaseOrder.setApproveRecordIds(String.valueOf(wmsApproveRecord.getId()));
      purchaseOrder.setApproveRecordIdNow(wmsApproveRecord.getId());
      if (wmsApproveRecord.getStatus().equals(ApproveRecordStatusEnum.END.getType())) {
         purchaseOrder.setDataStatus(DataStatusEnum.SUCCEED.getType());
         purchaseOrder.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
         purchaseOrder.setReviewPassTime(LocalDateTime.now());
         purchaseOrder.setPurchaseStatus(PurchaseStatusEnum.DURING.getType());
         purchaseOrder.setSettlementStatus(SettlementStatusEnum.UN_SETTLED.getType());
         purchaseOrder.setBoolRewrite(Boolean.FALSE);
         if (ObjectUtil.isNotEmpty(purchaseOrderOld.getApplyDetailMeteJson())) {
            this.updateApplyProductQuantityAndMete(purchaseOrderOld, false);
         }

         if (ObjectUtil.isNotEmpty(purchaseOrder.getApplyDetailMeteJson())) {
            this.updateApplyProductQuantityAndMete(purchaseOrder, true);
         }

         this.purchaseOrderDetailMapper
            .update(
               null,
               (Wrapper<PurchaseOrderDetail>)(new LambdaUpdateWrapper<PurchaseOrderDetail>().set(PurchaseOrderDetail::getBoolOriginalDetail, true))
                  .eq(PurchaseOrderDetail::getPurchaseId, purchaseOrder.getId())
            );
      }

      this.baseMapper.updateById(purchaseOrder);
      this.baseMapper.deleteById(purchaseOrderOld.getId());
      this.updateFinanceOrderId(purchaseOrderOld.getId(), purchaseOrder.getId());
      return true;
   }

   private void checkDelPurchaseDetail(PurchaseOrder purchaseOrderOld, List<Long> delDetailIds) {
      if (!CollectionUtil.isEmpty(delDetailIds)) {
         for (Long delDetailId : delDetailIds) {
            if (purchaseOrderOld.getPurchaseType().equals(PurchaseEnum.MATERIAL.getType())) {
               PurchaseOrderDetail purchaseOrderDetail = this.purchaseOrderDetailMapper.selectById(delDetailId);
               Preconditions.checkArgument(
                  purchaseOrderDetail.getInboundMete().compareTo(BigDecimal.ZERO) == 0, "【" + purchaseOrderDetail.getClassifyName() + "】存在入库数据，删除失败"
               );
               List<InboundDetail> inboundDetailList = this.inboundDetailService
                  .getInboundDetailList(purchaseOrderOld.getId(), delDetailId, ReviewStatusEnum.AUDITING.getType());
               Preconditions.checkArgument(CollectionUtil.isEmpty(inboundDetailList), "【" + purchaseOrderDetail.getClassifyName() + "】存在审核中的入库数据，删除失败");
            } else if (purchaseOrderOld.getPurchaseType().equals(PurchaseEnum.FINISHED_GOODS.getType())) {
               PurchaseOrderDetail purchaseOrderDetail = this.purchaseOrderDetailMapper.selectById(delDetailId);
               Preconditions.checkArgument(
                  purchaseOrderDetail.getInboundQuantity().compareTo(BigDecimal.ZERO) == 0, "【" + purchaseOrderDetail.getManufacturedName() + "】存在入库数据，删除失败"
               );
               List<InboundDetailManufactured> inboundDetailManufacturedList = this.inboundDetailManufacturedService
                  .getInboundDetailManufacturedList(purchaseOrderOld.getId(), delDetailId, ReviewStatusEnum.AUDITING.getType());
               Preconditions.checkArgument(
                  CollectionUtil.isEmpty(inboundDetailManufacturedList), "【" + purchaseOrderDetail.getManufacturedName() + "】存在审核中的入库数据，删除失败"
               );
            } else {
               Preconditions.checkArgument(false, "未知采购材料类型！！！");
            }
         }
      }
   }

   private void updateOrderCheckFinance(Long orderId, BigDecimal newAmount) {
      FinanceAmountLimitConfigDTO financeAmountLimitConfig = this.configService.getFinanceAmountLimitConfig();
      if (!financeAmountLimitConfig.getBoolAllowOverContractAmount()) {
         BigDecimal totalPaymentAmount = this.supplierPaymentService
            .list(
               Wrappers.lambdaQuery(SupplierPayment.class)
                  .eq(SupplierPayment::getOrderId, orderId)
                  .in(
                     SupplierPayment::getPropertyType,
                     SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(),
                     SupplierPropertyTypeEnum.PURCHASE_FEE.getType()
                  )
                  .in(SupplierPayment::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
            )
            .stream()
            .map(s -> s.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()) ? s.getPaymentAmount() : s.getActuallyPaymentAmount())
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         Preconditions.checkArgument(totalPaymentAmount.compareTo(newAmount) <= 0, "合同额不能小于订单已付款总额[" + totalPaymentAmount + "]元(含未审批)!");
         BigDecimal totalInvoiceAmount = this.supplierInvoiceService
            .list(
               Wrappers.lambdaQuery(SupplierInvoice.class)
                  .eq(SupplierInvoice::getOrderId, orderId)
                  .in(
                     SupplierInvoice::getPropertyType,
                     SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(),
                     SupplierPropertyTypeEnum.PURCHASE_FEE.getType()
                  )
                  .in(SupplierInvoice::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
            )
            .stream()
            .map(s -> s.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()) ? s.getInvoiceAmount() : s.getActualInvoiceAmount())
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         Preconditions.checkArgument(totalInvoiceAmount.compareTo(newAmount) <= 0, "合同额不能小于订单收票总额[" + totalInvoiceAmount + "]元(含未审批)!");
      }
   }

   private void updateFinanceOrderId(Long oldOrderId, Long newOrderId) {
      PurchaseOrder newOrder = this.baseMapper.getById(newOrderId);
      Preconditions.checkArgument(newOrder != null, "订单数据出错!");
      List<SupplierPayment> supplierPaymentList = this.supplierPaymentService
         .list(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .in(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(), SupplierPropertyTypeEnum.PURCHASE_FEE.getType())
               .eq(SupplierPayment::getOrderId, oldOrderId)
         );
      if (CollectionUtils.isNotEmpty(supplierPaymentList)) {
         supplierPaymentList.forEach(
            supplierPayment -> {
               supplierPayment.setOrderId(newOrderId);
               supplierPayment.setBranchCompanyId(newOrder.getBranchCompanyId());
               supplierPayment.setSupplierId(newOrder.getSupplierId());
               supplierPayment.setPropertyType(
                  newOrder.getPurchaseType().equals(PurchaseEnum.MATERIAL.getType())
                     ? SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType()
                     : SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType()
               );
            }
         );
         this.supplierPaymentService.updateBatchById(supplierPaymentList);
      }

      List<SupplierInvoice> supplierInvoiceList = this.supplierInvoiceService
         .list(
            Wrappers.lambdaQuery(SupplierInvoice.class)
               .in(SupplierInvoice::getPropertyType, SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(), SupplierPropertyTypeEnum.PURCHASE_FEE.getType())
               .eq(SupplierInvoice::getOrderId, oldOrderId)
         );
      if (CollectionUtils.isNotEmpty(supplierInvoiceList)) {
         supplierInvoiceList.forEach(
            supplierInvoice -> {
               supplierInvoice.setOrderId(newOrderId);
               supplierInvoice.setBranchCompanyId(newOrder.getBranchCompanyId());
               supplierInvoice.setSupplierId(newOrder.getSupplierId());
               supplierInvoice.setPropertyType(
                  newOrder.getPurchaseType().equals(PurchaseEnum.MATERIAL.getType())
                     ? SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType()
                     : SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType()
               );
            }
         );
         this.supplierInvoiceService.updateBatchById(supplierInvoiceList);
      }

      List<SupplierSettlement> supplierSettlementList = this.supplierSettlementService
         .list(
            Wrappers.lambdaQuery(SupplierSettlement.class)
               .in(SupplierSettlement::getOrderClass, OrderClassEnum.MATERIAL_ORDER.getType(), OrderClassEnum.MANUFACTURE_ORDER.getType())
               .eq(SupplierSettlement::getOrderId, oldOrderId)
         );
      if (CollectionUtils.isNotEmpty(supplierSettlementList)) {
         supplierSettlementList.forEach(
            supplierSettlement -> {
               supplierSettlement.setOrderId(newOrderId);
               supplierSettlement.setSupplierId(newOrder.getSupplierId());
               supplierSettlement.setOrderClass(
                  newOrder.getPurchaseType().equals(PurchaseEnum.MATERIAL.getType())
                     ? OrderClassEnum.MATERIAL_ORDER.getType()
                     : OrderClassEnum.MANUFACTURE_ORDER.getType()
               );
            }
         );
         this.supplierSettlementService.updateBatchById(supplierSettlementList);
      }

      List<ContractAuditLedger> contractAuditLedgerList = this.contractAuditLedgerService
         .list(
            Wrappers.lambdaQuery(ContractAuditLedger.class)
               .eq(ContractAuditLedger::getAuditType, AuditTypeEnum.PAYMENT_APPROVE.getType())
               .apply("FIND_IN_SET ({0}, contract_id) > 0", oldOrderId)
         );
      if (CollectionUtils.isNotEmpty(contractAuditLedgerList)) {
         contractAuditLedgerList.forEach(contractAuditLedger -> {
            List<String> orderIds = Arrays.stream(contractAuditLedger.getContractId().split(",")).collect(Collectors.toList());
            Collections.replaceAll(orderIds, String.valueOf(oldOrderId), String.valueOf(newOrderId));
            contractAuditLedger.setContractId(org.apache.commons.lang3.StringUtils.join(orderIds, ","));
         });
         this.contractAuditLedgerService.updateBatchById(contractAuditLedgerList);
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateUnderReviewPurchase(PurchaseOrderDTOParam param) {
      PurchaseOrder purchaseOrder = this.baseMapper.selectById(param.getId());
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(purchaseOrder), "该采购单不存在");
      Preconditions.checkArgument(purchaseOrder.getDataStatus().equals(DataStatusEnum.UNDER_REVIEW.getType()), "采购单状态已改变，请刷新页面！！！");
      this.revocation(param.getId());
      if (ObjectUtil.isNotEmpty(purchaseOrder.getPassParentId())) {
         Preconditions.checkArgument(!param.getBoolTemporaryStorage(), "该采购单为通过的采购单再次发起审批，禁止暂存！！！");
         param.setId(purchaseOrder.getPassParentId());
         List<Long> delDetailIds = ObjectUtil.isNotEmpty(purchaseOrder.getDelDetailIds())
            ? Arrays.stream(purchaseOrder.getDelDetailIds().split(",")).map(Long::valueOf).collect(Collectors.toList())
            : new ArrayList<>();
         if (CollectionUtils.isNotEmpty(param.getDelDetailIds())) {
            delDetailIds.addAll(param.getDelDetailIds());
         }

         param.setDelDetailIds(delDetailIds);
         this.againSubmitPurchaseOrder(param);
      } else {
         this.submitReviewOrder(param);
      }

      return true;
   }

   @Override
   public Boolean checkClassify(Long classifyId) {
      Integer i = this.purchaseOrderDetailMapper
         .selectCount((Wrapper<PurchaseOrderDetail>)Wrappers.<PurchaseOrderDetail>lambdaQuery().eq(PurchaseOrderDetail::getClassifyId, classifyId));
      Integer i1 = this.baseMapper.selectCount((Wrapper<PurchaseOrder>)new LambdaQueryWrapper<PurchaseOrder>().last("and find_in_set(" + classifyId + ",classify_ids)"));
      return i <= 0 && i1 <= 0 ? false : true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteType(PurchaseOrderDTOParam param) {
      if (param.getDelButtonType().equals(DelButtonTypeEnum.CHE_XIAO.getType())) {
         this.revocation(param.getId());
      } else if (param.getDelButtonType().equals(DelButtonTypeEnum.SHAN_CHU.getType())) {
         this.cancellation(param.getId());
      } else if (param.getDelButtonType().equals(DelButtonTypeEnum.CHE_XIAO_SHAN_CHU.getType())) {
         this.revocation(param.getId());
      } else if (param.getDelButtonType().equals(DelButtonTypeEnum.CHE_XIAO_BIAN_JI.getType())) {
         this.revocation(param.getId());
      }

      return true;
   }

   private void checkApplyBoolAlter(List<Long> applyPurchaseIds, LocalDateTime dateTime) {
      int updateCount = this.applyPurchaseService
         .count(
            (Wrapper<ApplyPurchase>)(Wrappers.<ApplyPurchase>lambdaQuery().in(ApplyPurchase::getId, applyPurchaseIds))
               .ge(BaseEntity::getUpdateTime, dateTime)
         );
      Preconditions.checkArgument(updateCount == 0, "申购内容有变化，请关闭当前页面重新创建采购订单");

      for (ApplyPurchase applyPurchase : this.applyPurchaseService.listByIds(applyPurchaseIds)) {
         Preconditions.checkArgument(
            applyPurchase.getPurchaseCreationState().equals(ApplyPurchaseStateEnum.NOT_STARTED.getType())
               || applyPurchase.getPurchaseCreationState().equals(ApplyPurchaseStateEnum.PARTIAL_CREATED.getType()),
            "申购单已采购完毕不能创建"
         );
      }
   }

   @Override
   public void updateApplyProductQuantityAndMete(PurchaseOrder purchaseOrder, Boolean boolAdd) {
      if (!ObjectUtil.isEmpty(purchaseOrder.getApplyDetailMeteJson())) {
         if (purchaseOrder.getPurchaseType().equals(PurchaseEnum.FINISHED_GOODS.getType())) {
            List<DetailQuantityAndMete> detailQuantityAndMetes = JSONArray.parseArray(purchaseOrder.getApplyDetailMeteJson(), DetailQuantityAndMete.class);
            List<Long> applyDetailIds = detailQuantityAndMetes.stream().map(DetailQuantityAndMete::getId).collect(Collectors.toList());
            List<ApplyPurchaseDetail> applyPurchaseDetails = this.applyPurchaseDetailMapper.selectBatchIds(applyDetailIds);

            for (DetailQuantityAndMete detailQuantityAndMete : detailQuantityAndMetes) {
               ApplyPurchaseDetail applyPurchaseDetail = applyPurchaseDetails.stream()
                  .filter(a -> a.getId().equals(detailQuantityAndMete.getId()))
                  .findAny()
                  .orElse(null);
               BigDecimal productQuantityNow = ObjectUtil.isNotEmpty(applyPurchaseDetail.getProductQuantity())
                  ? applyPurchaseDetail.getProductQuantity()
                  : BigDecimal.ZERO;
               if (boolAdd) {
                  applyPurchaseDetail.setProductQuantity(productQuantityNow.add(detailQuantityAndMete.getQuantity()));
               } else {
                  applyPurchaseDetail.setProductQuantity(productQuantityNow.subtract(detailQuantityAndMete.getQuantity()));
               }

               Preconditions.checkArgument(
                  applyPurchaseDetail.getQuantity().compareTo(productQuantityNow) > -1,
                  applyPurchaseDetail.getManufacturedName() + "共申购【" + applyPurchaseDetail.getQuantity() + "】现已采购【" + productQuantityNow + "】申购失败！！！"
               );
               applyPurchaseDetail.setUpdateTime(LocalDateTime.now());
               applyPurchaseDetail.setBoolPurchase(Boolean.TRUE);
               this.applyPurchaseDetailMapper.updateById(applyPurchaseDetail);
            }

            for (Long l : Arrays.stream(purchaseOrder.getApplyPurchaseIds().split(",")).map(Long::new).collect(Collectors.toList())) {
               ApplyPurchase byId = this.applyPurchaseService.getById(l);
               List<ApplyPurchaseDetail> applyPurchaseDetailsAll = this.applyPurchaseDetailMapper
                  .selectList((Wrapper<ApplyPurchaseDetail>)new LambdaQueryWrapper<ApplyPurchaseDetail>().eq(ApplyPurchaseDetail::getApplyPurchaseId, l));
               BigDecimal quantity = applyPurchaseDetailsAll.stream()
                  .map(ApplyPurchaseDetail::getQuantity)
                  .filter(ObjectUtil::isNotEmpty)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal productQuantity = applyPurchaseDetailsAll.stream()
                  .map(ApplyPurchaseDetail::getProductQuantity)
                  .filter(ObjectUtil::isNotEmpty)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               Integer state = byId.getPurchaseCreationState();
               if (quantity.compareTo(productQuantity) <= 0) {
                  state = ApplyPurchaseStateEnum.CREATED.getType();
               }

               if (quantity.compareTo(productQuantity) == 1) {
                  state = ApplyPurchaseStateEnum.PARTIAL_CREATED.getType();
               }

               if (productQuantity.compareTo(BigDecimal.ZERO) == 0) {
                  state = ApplyPurchaseStateEnum.NOT_STARTED.getType();
               }

               if (!byId.getPurchaseCreationState().equals(state)) {
                  byId.setPurchaseCreationState(state);
                  byId.setUserUpdateTime(LocalDateTime.now());
                  byId.setUpdateTime(LocalDateTime.now());
                  this.applyPurchaseService.updateById(byId);
               }
            }
         } else if (purchaseOrder.getPurchaseType().equals(PurchaseEnum.MATERIAL.getType())) {
            BasicInbound purchaseSpecBasicConf = this.basicConfigService.getPurchaseSpecBasicConf();
            List<Long> classifyIds = Arrays.stream(purchaseOrder.getClassifyIds().split(",")).map(Long::new).collect(Collectors.toList());
            List<Measure> measureList = this.measureService.list((Wrapper<Measure>)new LambdaQueryWrapper<Measure>().in(Measure::getClassificationId, classifyIds));
            if (ObjectUtil.isNotEmpty(purchaseOrder.getApplyDetailMeteJson())) {
               List<DetailQuantityAndMete> detailQuantityAndMetes = JSONArray.parseArray(purchaseOrder.getApplyDetailMeteJson(), DetailQuantityAndMete.class);
               List<Long> applyDetailIds = detailQuantityAndMetes.stream().map(DetailQuantityAndMete::getId).collect(Collectors.toList());
               List<ApplyPurchaseDetail> applyPurchaseDetails = this.applyPurchaseDetailMapper.selectBatchIds(applyDetailIds);

               for (DetailQuantityAndMete detailQuantityAndMete : detailQuantityAndMetes) {
                  ApplyPurchaseDetail applyPurchaseDetail = applyPurchaseDetails.stream()
                     .filter(a -> a.getId().equals(detailQuantityAndMete.getId()))
                     .findAny()
                     .orElse(null);
                  Measure measure = measureList.stream()
                     .filter(m -> m.getClassificationId().equals(applyPurchaseDetail.getClassifyId()))
                     .findAny()
                     .orElse(null);
                  if (measure.getOutboundUnitType().equals(MeasureTypeEnum.MEASURE.getType())) {
                     BigDecimal productQuantityNow = ObjectUtil.isNotEmpty(applyPurchaseDetail.getProductQuantity())
                        ? applyPurchaseDetail.getProductQuantity()
                        : BigDecimal.ZERO;
                     if (boolAdd) {
                        applyPurchaseDetail.setProductQuantity(productQuantityNow.add(detailQuantityAndMete.getQuantity()));
                     } else {
                        applyPurchaseDetail.setProductQuantity(productQuantityNow.subtract(detailQuantityAndMete.getQuantity()));
                     }
                  }

                  BigDecimal productMeteNow = ObjectUtil.isNotEmpty(applyPurchaseDetail.getProductMete())
                     ? applyPurchaseDetail.getProductMete()
                     : BigDecimal.ZERO;
                  if (boolAdd) {
                     applyPurchaseDetail.setProductMete(productMeteNow.add(detailQuantityAndMete.getMete()));
                  } else {
                     applyPurchaseDetail.setProductMete(productMeteNow.subtract(detailQuantityAndMete.getMete()));
                  }

                  if (purchaseSpecBasicConf.getApplyAndProcureMeteDiffState()) {
                     BigDecimal mete = applyPurchaseDetail.getMete()
                        .multiply(BigDecimal.ONE.add(purchaseSpecBasicConf.getApplyAndProcureMeteDiff().divide(new BigDecimal(100))));
                     Preconditions.checkArgument(
                        applyPurchaseDetail.getProductMete().compareTo(mete) < 1, "采购量已超过所绑定申购的量，科目名称为：" + applyPurchaseDetail.getClassifyName()
                     );
                  }

                  applyPurchaseDetail.setUpdateTime(LocalDateTime.now());
                  applyPurchaseDetail.setBoolPurchase(Boolean.TRUE);
                  this.applyPurchaseDetailMapper.updateById(applyPurchaseDetail);
               }
            }

            for (Long l : Arrays.stream(purchaseOrder.getApplyPurchaseIds().split(",")).map(Long::new).collect(Collectors.toList())) {
               ApplyPurchase byId = this.applyPurchaseService.getById(l);
               List<ApplyPurchaseDetail> applyPurchaseDetailsAll = this.applyPurchaseDetailMapper
                  .selectList((Wrapper<ApplyPurchaseDetail>)new LambdaQueryWrapper<ApplyPurchaseDetail>().eq(ApplyPurchaseDetail::getApplyPurchaseId, l));
               BigDecimal mete = applyPurchaseDetailsAll.stream()
                  .map(ApplyPurchaseDetail::getMete)
                  .filter(ObjectUtil::isNotEmpty)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               if (purchaseSpecBasicConf.getApplyAndProcureMeteDiffState()) {
                  mete = mete.multiply(BigDecimal.ONE.add(purchaseSpecBasicConf.getApplyAndProcureMeteDiff().divide(new BigDecimal(100))));
               }

               BigDecimal productMete = applyPurchaseDetailsAll.stream()
                  .map(ApplyPurchaseDetail::getProductMete)
                  .filter(ObjectUtil::isNotEmpty)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               Integer state = byId.getPurchaseCreationState();
               if (mete.compareTo(productMete) <= 0) {
                  state = ApplyPurchaseStateEnum.CREATED.getType();
               }

               if (mete.compareTo(productMete) == 1) {
                  state = ApplyPurchaseStateEnum.PARTIAL_CREATED.getType();
               }

               if (productMete.compareTo(BigDecimal.ZERO) == 0) {
                  state = ApplyPurchaseStateEnum.NOT_STARTED.getType();
               }

               if (!byId.getPurchaseCreationState().equals(state)) {
                  byId.setPurchaseCreationState(state);
                  byId.setUserUpdateTime(LocalDateTime.now());
                  byId.setUpdateTime(LocalDateTime.now());
                  this.applyPurchaseService.updateById(byId);
               }
            }
         } else {
            Preconditions.checkArgument(false, "未知采购材料类型！！！");
         }
      }
   }

   @Override
   public void initUpdateOrderPlace() {
      this.baseMapper.initUpdateOrderPlace();
   }

   @Override
   public List<SupplierAllBriefDTO> getSupplier(Boolean boolAnnual, Integer level, Integer dataStatus, List<Integer> projectAttribute, Integer orderPlace) {
      QueryWrapper<PurchaseOrder> purchaseOrderQueryWrapper = new QueryWrapper<>();
      purchaseOrderQueryWrapper.select("DISTINCT supplier_id");
      purchaseOrderQueryWrapper.lambda()
         .eq(boolAnnual != null, PurchaseOrder::getBoolAnnual, boolAnnual)
         .eq(PurchaseOrder::getPurchaseStatus, PurchaseStatusEnum.DURING.getType())
         .eq(level != null, PurchaseOrder::getLevel, level)
         .eq(orderPlace != null, PurchaseOrder::getOrderPlace, orderPlace)
         .eq(dataStatus != null, PurchaseOrder::getDataStatus, dataStatus)
         .in(projectAttribute != null, PurchaseOrder::getProjectAttribute, projectAttribute)
         .isNotNull(PurchaseOrder::getSupplierId);
      List<PurchaseOrder> purchaseOrders = this.baseMapper.selectList(purchaseOrderQueryWrapper);
      if (CollectionUtil.isEmpty(purchaseOrders)) {
         return new ArrayList<>();
      }

      List<Long> supplierIds = purchaseOrders.stream().map(PurchaseOrder::getSupplierId).collect(Collectors.toList());
      return CollectionUtil.isEmpty(supplierIds) ? new ArrayList<>() : this.supplierService.getListBriefByIds(supplierIds);
   }

   @Override
   public PrintVO<List<PurchaseOrderDTO>> purchaseOrderPrint(QueryPurchaseOrderDTOParam param) {
      PrintVO<List<PurchaseOrderDTO>> vo = new PrintVO<>();
      Map<String, Object> header = vo.initHeader(UserUtil.getCurrentName());
      vo.setHeader(header);
      List<PurchaseOrder> purchaseOrders = this.baseMapper.listInfoV2(param);
      purchaseOrders.sort((po1, po2) -> Long.compare(po2.getId(), po1.getId()));
      List<String> projectAttributeList = Arrays.stream(param.getProjectAttribute().split(",")).map(String::valueOf).collect(Collectors.toList());
      param.setProjectAttributes(projectAttributeList);
      List<Long> supplierIds = purchaseOrders.stream().map(PurchaseOrder::getSupplierId).filter(ObjectUtil::isNotEmpty).collect(Collectors.toList());
      Map<Long, Supplier> supplierMap = new HashMap<>();
      if (CollectionUtil.isNotEmpty(supplierIds)) {
         supplierMap = this.supplierService.listByIds(supplierIds).stream().collect(Collectors.toMap(Supplier::getId, Function.identity()));
      }

      List<Long> userIds = purchaseOrders.stream().map(PurchaseOrder::getProjectManagerId).filter(ObjectUtil::isNotEmpty).collect(Collectors.toList());
      Map<Long, User> userMap = new HashMap<>();
      if (CollectionUtil.isNotEmpty(userIds)) {
         userMap = this.userService.listByIds(userIds).stream().collect(Collectors.toMap(User::getId, Function.identity()));
      }

      List<Long> branchCompanyIds = purchaseOrders.stream().map(PurchaseOrder::getBranchCompanyId).filter(ObjectUtil::isNotEmpty).collect(Collectors.toList());
      Map<Long, BranchCompany> branchCompanyMap = new HashMap<>();
      if (CollectionUtil.isNotEmpty(branchCompanyIds)) {
         branchCompanyMap = this.branchCompanyService.listByIds(branchCompanyIds).stream().collect(Collectors.toMap(BranchCompany::getId, Function.identity()));
      }

      Map<Long, ProjectInfo> projectInfoMap = new HashMap<>();
      List<PurchaseOrder> purchaseOrderProject = purchaseOrders.stream().filter(p -> ObjectUtil.isNotEmpty(p.getProjectIds())).collect(Collectors.toList());
      if (CollectionUtil.isNotEmpty(purchaseOrderProject)) {
         List<Long> projectIds = purchaseOrderProject.stream()
            .flatMap(p -> Arrays.stream(p.getProjectIds().split(",")).map(Long::valueOf))
            .collect(Collectors.toList());
         if (CollectionUtil.isNotEmpty(projectIds)) {
            projectInfoMap = this.contractProjectService
               .listSimpleByIdList(projectIds)
               .stream()
               .collect(Collectors.toMap(ProjectInfo::getId, Function.identity()));
         }
      }

      Map<Long, AttachmentDTO> attachmentMap = new HashMap<>();
      List<PurchaseOrder> purchaseOrdersAttachment = purchaseOrders.stream()
         .filter(p -> ObjectUtil.isNotEmpty(p.getAttachments()))
         .collect(Collectors.toList());
      if (CollectionUtil.isNotEmpty(purchaseOrdersAttachment)) {
         List<Long> attachmentIds = purchaseOrdersAttachment.stream()
            .flatMap(p -> Arrays.stream(p.getAttachments().split(",")).map(Long::valueOf))
            .collect(Collectors.toList());
         if (CollectionUtil.isNotEmpty(attachmentIds)) {
            attachmentMap = this.attachmentService.listByIdList(attachmentIds).stream().collect(Collectors.toMap(AttachmentDTO::getId, Function.identity()));
         }
      }

      List<Long> purchaseIds = purchaseOrders.stream()
         .filter(p -> p.getPurchaseType().equals(PurchaseEnum.MATERIAL.getType()))
         .map(PurchaseOrder::getId)
         .collect(Collectors.toList());
      List<Inbound> inboundList = new ArrayList<>();
      if (CollectionUtil.isNotEmpty(purchaseIds)) {
         inboundList = this.inboundService.list((Wrapper<Inbound>)new LambdaQueryWrapper<Inbound>().in(Inbound::getPurchaseId, purchaseIds));
      }

      List<Long> purchaseManufacturedIds = purchaseOrders.stream()
         .filter(p -> p.getPurchaseType().equals(PurchaseEnum.FINISHED_GOODS.getType()))
         .map(PurchaseOrder::getId)
         .collect(Collectors.toList());
      List<InboundManufactured> inboundManufacturedList = new ArrayList<>();
      if (CollectionUtil.isNotEmpty(purchaseManufacturedIds)) {
         inboundManufacturedList = this.inboundManufacturedService
            .list((Wrapper<InboundManufactured>)new LambdaQueryWrapper<InboundManufactured>().in(InboundManufactured::getPurchaseId, purchaseManufacturedIds));
      }

      List<PurchaseOrderDTO> collect = new ArrayList<>();

      for (PurchaseOrder po : purchaseOrders) {
         PurchaseOrderDTO orderDTO = BeanUtil.copy(po, PurchaseOrderDTO.class);
         orderDTO.setCreateTime(po.getCreateTime());
         orderDTO.setUpdateTime(po.getUpdateTime());
         if (po.getSupplierId() != null) {
            Supplier supplier = supplierMap.get(po.getSupplierId());
            orderDTO.setSupplier(BriefIdAndNameDTO.builder().id(supplier.getId()).name(supplier.getName()).shortName(supplier.getShortName()).build());
         }

         if (StrUtil.isNotBlank(po.getApplyPurchaseSN())) {
            orderDTO.setApplyPurchaseSN(Arrays.asList((String[])po.getApplyPurchaseSN().split(",").clone()));
         }

         if (StrUtil.isNotBlank(po.getAuxMaterialIds())) {
            orderDTO.setAuxMaterialIds(CommonUtil.spilt(po.getAuxMaterialIds(), ","));
         }

         if (StrUtil.isNotBlank(po.getOtherMaterialIds())) {
            orderDTO.setOtherMaterialIds(CommonUtil.spilt(po.getOtherMaterialIds(), ","));
         }

         if (!param.getProjectAttribute().equals(String.valueOf(ProjectAttributeEnum.SELF_SUPPORT.getType()))) {
            User user = userMap.get(po.getProjectManagerId());
            orderDTO.setProjectManager(com.hzchum.scim.common.core.api.pojo.common.IdAndNameDTO.builder().id(user.getId()).name(user.getName()).build());
         }

         BranchCompany branchCompany = branchCompanyMap.get(po.getBranchCompanyId());
         orderDTO.setBranchCompany(BriefIdAndNameDTO.builder().id(branchCompany.getId()).name(branchCompany.getName()).build());
         if (StrUtil.isNotBlank(po.getAttachments())) {
            List<Long> attachmentList = Arrays.asList(po.getAttachments().split(",")).stream().map(a -> Long.parseLong(a.trim())).collect(Collectors.toList());
            List<AttachmentDTO> attachmentDTOS = attachmentMap.entrySet()
               .stream()
               .filter(a -> attachmentList.contains(a.getKey()))
               .map(Entry::getValue)
               .collect(Collectors.toList());
            orderDTO.setAttachments(attachmentDTOS);
         } else {
            orderDTO.setAttachments(new ArrayList<>());
         }

         if (StrUtil.isNotBlank(po.getProjectIds())) {
            List<Long> projectIdList = Arrays.asList(po.getProjectIds().split(",")).stream().map(p -> Long.parseLong(p.trim())).collect(Collectors.toList());
            List<ProjectInfo> projectInfos = projectInfoMap.entrySet()
               .stream()
               .filter(p -> projectIdList.contains(p.getKey()))
               .map(Entry::getValue)
               .collect(Collectors.toList());
            if (BasicClassEnum.STRUC_MANUFACTURED.getType().equals(po.getBasicClass())) {
               orderDTO.setProject(projectInfos.get(0));
            } else {
               orderDTO.setProjects(projectInfos);
            }
         }

         if (po.getPurchaseType().equals(PurchaseEnum.MATERIAL.getType())) {
            orderDTO.setBoolUsed(
               CollectionUtils.isNotEmpty(inboundList.stream().filter(i -> i.getPurchaseId().equals(orderDTO.getId())).collect(Collectors.toList()))
            );
         } else if (po.getPurchaseType().equals(PurchaseEnum.FINISHED_GOODS.getType())) {
            orderDTO.setBoolUsed(
               CollectionUtils.isNotEmpty(inboundManufacturedList.stream().filter(i -> i.getPurchaseId().equals(orderDTO.getId())).collect(Collectors.toList()))
            );
         } else {
            Preconditions.checkArgument(false, "未知采购材料类型！！！");
         }

         collect.add(orderDTO);
      }

      this.setFinanceInfo(collect);
      vo.setTable(collect);
      return vo;
   }

   @Override
   public SupplierSettlementDto getPurchaseOrder(Long orderId) {
      return this.baseMapper.getPurchaseOrder(orderId);
   }

   @Override
   public List<PurchaseStandingBookDTO> getSecondaryUnitAll(
      Long supplierId, Integer settlementStatus, String serialNumber, Integer basicClass, Long branchCompanyId
   ) {
      return this.baseMapper.getSecondaryUnitAll(supplierId, settlementStatus, serialNumber, basicClass, branchCompanyId);
   }

   private String creatUniqueIdentification(Long id, String serialNumber, Integer basicClass) {
      Integer countByPurchaseId = this.purchaseOrderDetailMapper
         .selectCount((Wrapper<PurchaseOrderDetail>)new LambdaQueryWrapper<PurchaseOrderDetail>().eq(PurchaseOrderDetail::getPurchaseId, id));
      String acronymByType = BasicClassEnum.getAcronymByType(basicClass);
      return serialNumber + "：" + acronymByType + "-" + (countByPurchaseId + 1);
   }

   private void removeOrderCheckFinance(Long orderId) {
      List<SupplierPayment> paymentList = this.supplierPaymentService
         .list(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .eq(SupplierPayment::getOrderId, orderId)
               .in(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(), SupplierPropertyTypeEnum.PURCHASE_FEE.getType())
         );
      Preconditions.checkArgument(paymentList.stream().noneMatch(s -> s.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType())), "订单存在未审批的付款记录!");
      BigDecimal totalPaymentAmount = paymentList.stream()
         .filter(s -> s.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType()))
         .map(SupplierPayment::getActuallyPaymentAmount)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      Preconditions.checkArgument(totalPaymentAmount.compareTo(BigDecimal.ZERO) == 0, "订单已付款总额不等于0!");
      List<SupplierInvoice> invoiceList = this.supplierInvoiceService
         .list(
            Wrappers.lambdaQuery(SupplierInvoice.class)
               .eq(SupplierInvoice::getOrderId, orderId)
               .in(SupplierInvoice::getPropertyType, SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(), SupplierPropertyTypeEnum.PURCHASE_FEE.getType())
         );
      Preconditions.checkArgument(invoiceList.stream().noneMatch(s -> s.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType())), "订单存在未审批的收票记录!");
      BigDecimal totalInvoiceAmount = invoiceList.stream()
         .filter(s -> s.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType()))
         .map(SupplierInvoice::getActualInvoiceAmount)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      Preconditions.checkArgument(totalInvoiceAmount.compareTo(BigDecimal.ZERO) == 0, "订单已收发票总额不等于0!");
      List<SupplierSettlement> settlementList = this.supplierSettlementService
         .list(
            Wrappers.lambdaQuery(SupplierSettlement.class)
               .eq(SupplierSettlement::getOrderId, orderId)
               .in(SupplierSettlement::getOrderClass, OrderClassEnum.MATERIAL_ORDER.getType(), OrderClassEnum.MANUFACTURE_ORDER.getType())
         );
      Preconditions.checkArgument(
         settlementList.stream().filter(s -> !s.getBoolPreSettlement()).noneMatch(s -> s.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType())),
         "订单结算正在审批中!"
      );
      Preconditions.checkArgument(
         settlementList.stream().filter(SupplierSettlement::getBoolPreSettlement).noneMatch(s -> s.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType())),
         "订单存在未审批的预结算记录!"
      );
      BigDecimal preSettlementAmount = settlementList.stream()
         .filter(SupplierSettlement::getBoolPreSettlement)
         .filter(s -> s.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType()))
         .map(SupplierSettlement::getAmount)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      Preconditions.checkArgument(preSettlementAmount.compareTo(BigDecimal.ZERO) == 0, "订单预结算总额不等于0!");
      List<ContractAuditLedger> contractAuditLedgerList = this.contractAuditLedgerService
         .list(
            Wrappers.lambdaQuery(ContractAuditLedger.class)
               .eq(ContractAuditLedger::getAuditType, AuditTypeEnum.PAYMENT_APPROVE.getType())
               .apply("FIND_IN_SET ({0}, contract_id) > 0", orderId)
         );
      Map<Long, SupplierPayment> paymentMap = paymentList.stream().collect(Collectors.toMap(SupplierPayment::getId, Function.identity()));
      Map<Long, SupplierInvoice> invoiceMap = invoiceList.stream().collect(Collectors.toMap(SupplierInvoice::getId, Function.identity()));
      Map<Long, SupplierSettlement> settlementMap = settlementList.stream().collect(Collectors.toMap(SupplierSettlement::getId, Function.identity()));
      contractAuditLedgerList.forEach(
         auditLedger -> {
            Set<Long> paymentIds = Arrays.stream(auditLedger.getPaymentId().trim().split(","))
               .filter(org.apache.commons.lang3.StringUtils::isNotBlank)
               .map(Long::valueOf)
               .collect(Collectors.toSet());
            Set<Long> orderIds = Arrays.stream(auditLedger.getContractId().trim().split(","))
               .filter(org.apache.commons.lang3.StringUtils::isNotBlank)
               .map(Long::valueOf)
               .collect(Collectors.toSet());
            if (auditLedger.getPaymentEnum().equals(AuditPaymentEnum.PROCUREMENT_PAYMENT.getType())) {
               Preconditions.checkArgument(paymentIds.size() == orderIds.size(), "订单付款审批记录数据异常!!!");
               Preconditions.checkArgument(paymentIds.stream().anyMatch(paymentMap::containsKey), "订单付款审批记录数据异常!!!");
            } else if (auditLedger.getPaymentEnum().equals(AuditPaymentEnum.INCOMING_INVOICES.getType())) {
               Preconditions.checkArgument(paymentIds.size() == orderIds.size(), "订单收票审批记录数据异常!!!");
               Preconditions.checkArgument(paymentIds.stream().anyMatch(invoiceMap::containsKey), "订单收票审批记录数据异常!!!");
            } else if (auditLedger.getPaymentEnum().equals(AuditPaymentEnum.PURCHASE_PRE_SETTLEMENT.getType())) {
               Preconditions.checkArgument(paymentIds.size() == orderIds.size(), "订单预结算审批记录数据异常!!!");
               Preconditions.checkArgument(paymentIds.stream().anyMatch(settlementMap::containsKey), "订单预结算审批记录数据异常!!!");
            } else {
               Preconditions.checkArgument(paymentIds.size() == orderIds.size(), "订单结算审批记录数据异常!!!");
               Preconditions.checkArgument(paymentIds.stream().anyMatch(settlementMap::containsKey), "订单结算审批记录数据异常!!!");
            }
         }
      );
   }

   private void removeOrderFinance(PurchaseOrder order) {
      Map<Long, SupplierPayment> supplierPaymentMap = this.supplierPaymentService
         .list(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .eq(SupplierPayment::getOrderId, order.getId())
               .in(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(), SupplierPropertyTypeEnum.PURCHASE_FEE.getType())
         )
         .stream()
         .collect(Collectors.toMap(SupplierPayment::getId, Function.identity()));
      this.supplierPaymentService.removeByIds(supplierPaymentMap.keySet());
      Map<Long, SupplierInvoice> supplierInvoiceMap = this.supplierInvoiceService
         .list(
            Wrappers.lambdaQuery(SupplierInvoice.class)
               .eq(SupplierInvoice::getOrderId, order.getId())
               .in(SupplierInvoice::getPropertyType, SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(), SupplierPropertyTypeEnum.PURCHASE_FEE.getType())
         )
         .stream()
         .collect(Collectors.toMap(SupplierInvoice::getId, Function.identity()));
      this.supplierInvoiceService.removeByIds(supplierInvoiceMap.keySet());
      Map<Long, SupplierSettlement> supplierSettlementMap = this.supplierSettlementService
         .list(
            Wrappers.lambdaQuery(SupplierSettlement.class)
               .eq(SupplierSettlement::getOrderId, order.getId())
               .in(SupplierSettlement::getOrderClass, OrderClassEnum.MATERIAL_ORDER.getType(), OrderClassEnum.MANUFACTURE_ORDER.getType())
         )
         .stream()
         .collect(Collectors.toMap(SupplierSettlement::getId, Function.identity()));
      this.supplierSettlementService.removeByIds(supplierSettlementMap.keySet());
      List<ContractAuditLedger> contractAuditLedgerList = this.contractAuditLedgerService
         .list(
            Wrappers.lambdaQuery(ContractAuditLedger.class)
               .eq(ContractAuditLedger::getAuditType, AuditTypeEnum.PAYMENT_APPROVE.getType())
               .apply("FIND_IN_SET ({0}, contract_id) > 0", order.getId())
         );
      if (!contractAuditLedgerList.isEmpty()) {
         Map<Long, WmsApproveRecord> approveRecordMap = this.wmsApproveRecordService
            .listByIds(contractAuditLedgerList.stream().map(ContractAuditLedger::getApproveRecordId).collect(Collectors.toList()))
            .stream()
            .collect(Collectors.toMap(WmsApproveRecord::getId, Function.identity()));
         Map<Long, List<Long>> dataIdApproveDetailsMap = new HashMap<>(contractAuditLedgerList.size());
         if (CollectionUtils.isNotEmpty(approveRecordMap)) {
            Map<Long, List<Long>> collect = this.wmsApproveRecordDetailService
               .list(
                  Wrappers.lambdaQuery(WmsApproveRecordDetail.class)
                     .in(WmsApproveRecordDetail::getDataId, contractAuditLedgerList.stream().map(ContractAuditLedger::getId).collect(Collectors.toList()))
                     .in(
                        WmsApproveRecordDetail::getApproveProcessType,
                        approveRecordMap.values().stream().map(WmsApproveRecord::getApproveProcessType).collect(Collectors.toSet())
                     )
               )
               .stream()
               .collect(Collectors.groupingBy(WmsApproveRecordDetail::getDataId, Collectors.mapping(WmsApproveRecordDetail::getId, Collectors.toList())));
            dataIdApproveDetailsMap.putAll(collect);
         }

         contractAuditLedgerList.forEach(
            auditLedger -> {
               Set<Long> paymentIds = Arrays.stream(auditLedger.getPaymentId().trim().split(","))
                  .filter(org.apache.commons.lang3.StringUtils::isNotBlank)
                  .map(Long::valueOf)
                  .collect(Collectors.toSet());
               Set<Long> orderIds = Arrays.stream(auditLedger.getContractId().trim().split(","))
                  .filter(org.apache.commons.lang3.StringUtils::isNotBlank)
                  .map(Long::valueOf)
                  .collect(Collectors.toSet());
               Preconditions.checkArgument(paymentIds.size() == orderIds.size(), "业财审批记录数据异常!!!");
               WmsApproveRecord approveRecord = approveRecordMap.get(auditLedger.getApproveRecordId());
               if (paymentIds.size() == 1) {
                  this.contractAuditLedgerService.removeById(auditLedger.getId());
                  if (approveRecord != null) {
                     this.wmsApproveRecordService.removeById(approveRecord.getId());
                     this.wmsApproveRecordDetailService.removeByIds(dataIdApproveDetailsMap.get(auditLedger.getId()));
                  }
               } else {
                  orderIds.remove(order.getId());
                  auditLedger.setContractId(orderIds.isEmpty() ? "" : org.apache.commons.lang3.StringUtils.join(orderIds, ","));
                  List<String> orderSnList = orderIds.isEmpty()
                     ? Collections.emptyList()
                     : this.baseMapper.selectBatchIds(orderIds).stream().map(PurchaseOrder::getSerialNumber).collect(Collectors.toList());
                  auditLedger.setContractNumber(orderSnList.isEmpty() ? "" : orderSnList.get(0) + "等");
                  if (auditLedger.getPaymentEnum().equals(AuditPaymentEnum.PROCUREMENT_PAYMENT.getType())) {
                     Long paymentId = paymentIds.stream().filter(supplierPaymentMap::containsKey).findFirst().orElse(null);
                     paymentIds.remove(paymentId);
                     SupplierPayment supplierPayment = supplierPaymentMap.get(paymentId);
                     auditLedger.setApplyAmount(auditLedger.getApplyAmount().subtract(supplierPayment.getApplyAmount()));
                     auditLedger.setPaymentAmount(
                        auditLedger.getAuditStatusEnum().equals(AuditStatusEnum.SUCCEED.getType())
                           ? auditLedger.getPaymentAmount().subtract(supplierPayment.getApplyAmount())
                           : auditLedger.getActuallyPayAmount()
                     );
                  } else {
                     Long invoiceId = paymentIds.stream().filter(supplierInvoiceMap::containsKey).findFirst().orElse(null);
                     paymentIds.remove(invoiceId);
                     SupplierInvoice supplierInvoice = supplierInvoiceMap.get(invoiceId);
                     auditLedger.setApplyAmount(auditLedger.getApplyAmount().subtract(supplierInvoice.getInvoiceAmount()));
                     auditLedger.setPaymentAmount(
                        auditLedger.getAuditStatusEnum().equals(AuditStatusEnum.SUCCEED.getType())
                           ? auditLedger.getPaymentAmount().subtract(supplierInvoice.getInvoiceAmount())
                           : auditLedger.getActuallyPayAmount()
                     );
                  }

                  auditLedger.setPaymentId(org.apache.commons.lang3.StringUtils.join(paymentIds, ","));
                  this.contractAuditLedgerService.updateById(auditLedger);
                  if (approveRecord != null) {
                     approveRecord.setDataSerialNumber(auditLedger.getContractNumber());
                     this.wmsApproveRecordService.updateById(approveRecord);
                  }
               }
            }
         );
      }
   }

   @Override
   public Boolean update(Long id) {
      return this.baseMapper.update(id);
   }

   @Override
   public PurchaseOrder getById(Long id) {
      return this.baseMapper.getById(id);
   }

   @Override
   public List<PurchaseOrderSummaryDTO> getPurchaseSummary(LocalDate yearDate, Long branchCompanyId) {
      List<PurchaseOrderSummaryDTO> purchaseSummary = this.baseMapper.getPurchaseSummary(yearDate, branchCompanyId);

      for (PurchaseOrderSummaryDTO dto : purchaseSummary) {
         dto.setMaterialTypeName(ApplyPurchaseMaterialTypeEnum.getOrderTypeName(dto.getMaterialType()));
      }

      return purchaseSummary;
   }

   @Override
   public List<PurchaseOrderGroupMonthDTO> getGroupMonth(LocalDate yearDate, Long branchCompanyId) {
      List<LocalDate> yearMonthDateList = this.getYearMonthDateList(yearDate);
      Map<String, PurchaseOrderGroupMonthDTO> monthDTOMap = this.baseMapper
         .getGroupMonth(yearDate, branchCompanyId)
         .stream()
         .collect(Collectors.toMap(PurchaseOrderGroupMonthDTO::getDateTime, Function.identity()));
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
      return yearMonthDateList.stream()
         .map(
            e -> {
               String key = e.format(formatter);
               return monthDTOMap.containsKey(key)
                  ? monthDTOMap.get(key)
                  : PurchaseOrderGroupMonthDTO.builder().dateTime(key).numbers(0).amount(BigDecimal.ZERO).build();
            }
         )
         .collect(Collectors.toList());
   }

   @Override
   public List<PurchaseOrderGroupDetailDTO> getGroupDetail(LocalDate yearDate, Boolean yearGroup, Long branchCompanyId) {
      List<PurchaseOrderGroupDetailDO> doList = this.baseMapper.getGroupDetail(yearDate, yearGroup, branchCompanyId);
      if (CollectionUtils.isEmpty(doList)) {
         return new ArrayList<>();
      }

      List<Long> supplierIds = doList.stream().map(PurchaseOrderGroupDetailDO::getSupplierId).distinct().collect(Collectors.toList());
      Map<Long, String> supplierMap = this.supplierService.listByIds(supplierIds).stream().collect(Collectors.toMap(Supplier::getId, Supplier::getName));
      Map<String, List<PurchaseOrderGroupDetailDO>> doMap = doList.stream().collect(Collectors.groupingBy(PurchaseOrderGroupDetailDO::getDateTime));
      List<PurchaseOrderGroupDetailDTO> dtoList = new ArrayList<>();
      Integer index = 1;
      if (yearGroup) {
         for (LocalDate dateTime : this.getYearMonthDateList(yearDate)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
            String key = dateTime.format(formatter);
            if (doMap.containsKey(key)) {
               List<PurchaseOrderGroupDetailDO> detailDOList = doMap.get(key);
               BigDecimal reduce = detailDOList.stream().map(PurchaseOrderGroupDetailDO::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
               PurchaseOrderGroupDetailDTO title = new PurchaseOrderGroupDetailDTO();
               title.setIndex(this.convertToChinese(dateTime.getMonthValue()) + "月");
               title.setAmount(reduce);
               dtoList.add(title);

               for (int i = 0; i < detailDOList.size(); i++) {
                  PurchaseOrderGroupDetailDO detailDO = detailDOList.get(i);
                  String indexD = index + "." + (i + 1);
                  String supplierName = supplierMap.get(detailDO.getSupplierId());
                  PurchaseOrderGroupDetailDTO build = PurchaseOrderGroupDetailDTO.builder()
                     .index(indexD)
                     .materialType(detailDO.getMaterialType())
                     .materialTypeName(ApplyPurchaseMaterialTypeEnum.getOrderTypeName(detailDO.getMaterialType()))
                     .supplierName(supplierName)
                     .amount(detailDO.getAmount().stripTrailingZeros())
                     .dateTime(detailDO.getDateTime())
                     .build();
                  dtoList.add(build);
               }

               index = index + 1;
            }
         }
      }

      if (!yearGroup) {
         BigDecimal reduce = doList.stream().map(PurchaseOrderGroupDetailDO::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
         PurchaseOrderGroupDetailDTO title = new PurchaseOrderGroupDetailDTO();
         title.setIndex(this.convertToChinese(yearDate.getMonthValue()) + "月");
         title.setAmount(reduce);
         dtoList.add(title);

         for (LocalDate dateTime : this.getDaysInMonth(yearDate)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String key = dateTime.format(formatter);
            if (doMap.containsKey(key)) {
               List<PurchaseOrderGroupDetailDO> detailDOList = doMap.get(key);

               for (int i = 0; i < detailDOList.size(); i++) {
                  PurchaseOrderGroupDetailDO detailDO = detailDOList.get(i);
                  String indexD = index + "." + (i + 1);
                  String supplierName = supplierMap.get(detailDO.getSupplierId());
                  PurchaseOrderGroupDetailDTO build = PurchaseOrderGroupDetailDTO.builder()
                     .index(indexD)
                     .materialType(detailDO.getMaterialType())
                     .materialTypeName(ApplyPurchaseMaterialTypeEnum.getOrderTypeName(detailDO.getMaterialType()))
                     .supplierName(supplierName)
                     .amount(detailDO.getAmount().stripTrailingZeros())
                     .dateTime(detailDO.getDateTime())
                     .build();
                  dtoList.add(build);
               }

               index = index + 1;
            }
         }
      }

      return dtoList;
   }

   @Override
   public void getGroupDetailDownload(LocalDate yearDate, Boolean yearGroup, Long branchCompanyId, HttpServletResponse response) {
      List<PurchaseOrderGroupDetailDTO> dtoList = this.getGroupDetail(yearDate, yearGroup, branchCompanyId);
      String title = "";
      DateTimeFormatter formatter;
      if (yearGroup) {
         formatter = DateTimeFormatter.ofPattern("yyyy");
      } else {
         formatter = DateTimeFormatter.ofPattern("yyyy-MM");
      }

      title = title + "日期：" + yearDate.format(formatter) + "\n";
      if (branchCompanyId != null) {
         BranchCompany branchCompany = this.branchCompanyService.getById(branchCompanyId);
         if (branchCompany != null) {
            title = title + "分支机构：" + branchCompany.getName() + "\n";
         }
      }

      List<List<String>> headList = new ArrayList<>();
      headList.add(Arrays.asList(title, "序号"));
      headList.add(Arrays.asList(title, "类型"));
      headList.add(Arrays.asList(title, "供应商"));
      headList.add(Arrays.asList(title, "合同金额（元）"));
      headList.add(Arrays.asList(title, "创建日期"));
      List<List<Object>> dataList = new ArrayList<>();
      dtoList.forEach(ex -> {
         List<Object> data = new ArrayList<>();
         data.add(ex.getIndex());
         data.add(ex.getMaterialTypeName());
         data.add(ex.getSupplierName());
         data.add(ex.getAmount().setScale(0, RoundingMode.HALF_UP));
         data.add(ex.getDateTime());
         dataList.add(data);
      });

      try {
         response.reset();
         response.setContentType("application/vnd.ms-excel;charset=utf-8");
         String fileName = StrUtil.concat(true, "采购汇总.xlsx");
         response.setHeader("Access-Control-Allow-Origin", "*");
         response.setHeader("Access-Control-Expose-Headers", "*");
         response.setCharacterEncoding("UTF-8");
         response.setHeader("content-Type", "application/vnd.ms-excel");
         response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
         response.setHeader("Access-Control-Expose-Headers", "*");
         response.setHeader("Result", "code=" + ResultCodeEnum.SUCCESS.getCode() + ";message=" + ResultCodeEnum.SUCCESS.getCode());
         EasyExcel.write(response.getOutputStream())
            .head(headList)
            .registerWriteHandler(new SimpleColumnWidthStyleStrategy(15))
            .registerWriteHandler(
               new CellWriteHandler() {
                  @Override
                  public void beforeCellCreate(
                     WriteSheetHolder writeSheetHolder,
                     WriteTableHolder writeTableHolder,
                     Row row,
                     Head head,
                     Integer columnIndex,
                     Integer relativeRowIndex,
                     Boolean isHead
                  ) {
                     if (isHead && relativeRowIndex == 0) {
                        row.setHeight((short)550);
                     }
                  }
               }
            )
            .registerWriteHandler(new HorizontalCellStyleStrategy(new WriteCellStyle() {
               {
                  this.setHorizontalAlignment(HorizontalAlignment.CENTER);
                  this.setVerticalAlignment(VerticalAlignment.CENTER);
                  this.setWriteFont(new WriteFont() {
                     {
                        this.setFontName("宋体");
                        this.setFontHeightInPoints((short)10);
                        this.setBold(true);
                     }
                  });
                  this.setWrapped(true);
                  this.setShrinkToFit(true);
               }
            }, new WriteCellStyle() {
               {
                  this.setHorizontalAlignment(HorizontalAlignment.CENTER);
                  this.setVerticalAlignment(VerticalAlignment.CENTER);
                  this.setBorderBottom(BorderStyle.THIN);
                  this.setBorderLeft(BorderStyle.THIN);
                  this.setBorderRight(BorderStyle.THIN);
                  this.setBorderTop(BorderStyle.THIN);
               }
            }))
            .sheet("采购汇总详情表")
            .doWrite(dataList);
      } catch (Exception e) {
         throw new RuntimeException(e.getMessage());
      }
   }

   @Override
   public List<PurchaseOrderSummaryDTO> getSupplierSummary(LocalDate yearDate, Long branchCompanyId) {
      List<PurchaseOrderSummaryDTO> dtoList = this.baseMapper.getSupplierSummary(yearDate, branchCompanyId);

      for (PurchaseOrderSummaryDTO dto : dtoList) {
         dto.setMaterialTypeName(ApplyPurchaseMaterialTypeEnum.getOrderTypeName(dto.getMaterialType()));
      }

      return dtoList;
   }

   @Override
   public List<PurchaseOrderGroupSupplierDetailDTO> getSupplierGroupDetail(LocalDate yearDate, Long branchCompanyId) {
      List<PurchaseOrderGroupSupplierDetailDTO> groupDetail = this.baseMapper.getSupplierGroupDetail(yearDate, branchCompanyId);

      for (PurchaseOrderGroupSupplierDetailDTO dto : groupDetail) {
         dto.setMaterialTypeName(ApplyPurchaseMaterialTypeEnum.getOrderTypeName(dto.getMaterialType()));
      }

      return groupDetail;
   }

   @Override
   public void getSupplierGroupDetailDownload(LocalDate yearDate, Long branchCompanyId, HttpServletResponse response) {
      List<PurchaseOrderGroupSupplierDetailDTO> dtoList = this.getSupplierGroupDetail(yearDate, branchCompanyId);
      if (!CollectionUtils.isEmpty(dtoList)) {
         String title = "";
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
         title = title + "日期：" + yearDate.format(formatter) + "\n";
         if (branchCompanyId != null) {
            BranchCompany branchCompany = this.branchCompanyService.getById(branchCompanyId);
            if (branchCompany != null) {
               title = title + "分支机构：" + branchCompany.getName() + "\n";
            }
         }

         AtomicInteger index = new AtomicInteger(0);
         List<List<String>> headList = new ArrayList<>();
         headList.add(Arrays.asList(title, "序号"));
         headList.add(Arrays.asList(title, "类型"));
         headList.add(Arrays.asList(title, "供应商"));
         headList.add(Arrays.asList(title, "社会信用统一代码"));
         headList.add(Arrays.asList(title, "登记日期"));
         List<List<Object>> dataList = new ArrayList<>();
         DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
         dtoList.forEach(ex -> {
            List<Object> data = new ArrayList<>();
            data.add(index.incrementAndGet());
            data.add(ex.getMaterialTypeName());
            data.add(ex.getSupplierName());
            data.add(ex.getSocialCode());
            data.add(ex.getCreateTime().format(formatter2));
            dataList.add(data);
         });

         try {
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            String fileName = StrUtil.concat(true, "采购供应商详情.xlsx");
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Expose-Headers", "*");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            response.setHeader("Access-Control-Expose-Headers", "*");
            response.setHeader("Result", "code=" + ResultCodeEnum.SUCCESS.getCode() + ";message=" + ResultCodeEnum.SUCCESS.getCode());
            EasyExcel.write(response.getOutputStream())
               .head(headList)
               .registerWriteHandler(new SimpleColumnWidthStyleStrategy(15))
               .registerWriteHandler(
                  new CellWriteHandler() {
                     @Override
                     public void beforeCellCreate(
                        WriteSheetHolder writeSheetHolder,
                        WriteTableHolder writeTableHolder,
                        Row row,
                        Head head,
                        Integer columnIndex,
                        Integer relativeRowIndex,
                        Boolean isHead
                     ) {
                        if (isHead && relativeRowIndex == 0) {
                           row.setHeight((short)550);
                        }
                     }
                  }
               )
               .registerWriteHandler(new HorizontalCellStyleStrategy(new WriteCellStyle() {
                  {
                     this.setHorizontalAlignment(HorizontalAlignment.CENTER);
                     this.setVerticalAlignment(VerticalAlignment.CENTER);
                     this.setWriteFont(new WriteFont() {
                        {
                           this.setFontName("宋体");
                           this.setFontHeightInPoints((short)10);
                           this.setBold(true);
                        }
                     });
                     this.setWrapped(true);
                     this.setShrinkToFit(true);
                  }
               }, new WriteCellStyle() {
                  {
                     this.setHorizontalAlignment(HorizontalAlignment.CENTER);
                     this.setVerticalAlignment(VerticalAlignment.CENTER);
                     this.setBorderBottom(BorderStyle.THIN);
                     this.setBorderLeft(BorderStyle.THIN);
                     this.setBorderRight(BorderStyle.THIN);
                     this.setBorderTop(BorderStyle.THIN);
                  }
               }))
               .sheet("采购供应商详情表")
               .doWrite(dataList);
         } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
         }
      }
   }

   @Override
   public List<PurchaseOrderGroupMonthDTO> getGroupSupplierMonth(LocalDate yearDate, Long branchCompanyId, Boolean isAmountSort) {
      List<PurchaseOrder> purchaseOrderList = this.baseMapper.getPurchaseOrderList(yearDate, branchCompanyId, null);
      if (CollectionUtils.isEmpty(purchaseOrderList)) {
         return new ArrayList<>();
      }

      Map<Long, Supplier> supplierMap = new HashMap<>();
      List<Long> supplierIds = purchaseOrderList.stream().map(PurchaseOrder::getSupplierId).filter(ObjectUtil::isNotEmpty).collect(Collectors.toList());
      if (CollectionUtil.isNotEmpty(supplierIds)) {
         supplierMap = this.supplierService.listByIds(supplierIds).stream().collect(Collectors.toMap(Supplier::getId, Function.identity()));
      }

      List<PurchaseOrderDTO> collect = new ArrayList<>();

      for (PurchaseOrder po : purchaseOrderList) {
         PurchaseOrderDTO orderDTO = BeanUtil.copy(po, PurchaseOrderDTO.class);
         collect.add(orderDTO);
      }

      this.setFinanceInfo(collect);
      Map<Long, List<PurchaseOrderDTO>> groupedBySupplierMap = collect.stream().collect(Collectors.groupingBy(PurchaseOrderDTO::getSupplierId));
      List<PurchaseOrderGroupMonthDTO> result = new ArrayList<>();
      Map<Long, Supplier> finalSupplierMap = supplierMap;
      groupedBySupplierMap.forEach(
         (supplierId, orderList) -> {
            Supplier supplier = finalSupplierMap.get(supplierId);
            BigDecimal inboundAmount = orderList.stream()
               .map(PurchaseOrderDTO::getInboundAmount)
               .filter(Objects::nonNull)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            result.add(
               PurchaseOrderGroupMonthDTO.builder()
                  .supplierId(supplier.getId())
                  .supplierName(supplier.getName())
                  .shortName(supplier.getShortName())
                  .amount(inboundAmount)
                  .numbers(orderList.size())
                  .build()
            );
         }
      );
      return isAmountSort
         ? result.stream()
            .filter(e -> e.getAmount() != null)
            .sorted((o1, o2) -> o2.getAmount().compareTo(o1.getAmount()))
            .limit(10L)
            .collect(Collectors.toList())
         : result.stream()
            .filter(e -> e.getNumbers() != null)
            .sorted(Comparator.comparing(PurchaseOrderGroupMonthDTO::getNumbers).reversed())
            .limit(10L)
            .collect(Collectors.toList());
   }

   @Override
   public List<PurchaseOrderGroupMonthDetailDTO> getGroupMonthDetail(LocalDate yearDate, Long branchCompanyId, Long supplierId) {
      List<PurchaseOrder> purchaseOrderList = this.baseMapper.getPurchaseOrderList(yearDate, branchCompanyId, supplierId);
      if (CollectionUtils.isEmpty(purchaseOrderList)) {
         return new ArrayList<>();
      }

      List<PurchaseOrderDTO> collect = new ArrayList<>();

      for (PurchaseOrder po : purchaseOrderList) {
         PurchaseOrderDTO orderDTO = BeanUtil.copy(po, PurchaseOrderDTO.class);
         orderDTO.setCreateTime(po.getCreateTime());
         orderDTO.setUpdateTime(po.getUpdateTime());
         BranchCompany branchCompany = this.branchCompanyService.getById(po.getBranchCompanyId());
         orderDTO.setBranchCompany(BriefIdAndNameDTO.builder().id(branchCompany.getId()).name(branchCompany.getName()).build());
         collect.add(orderDTO);
      }

      this.setFinanceInfo(collect);
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
      DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      Map<String, List<PurchaseOrderDTO>> groupedData = collect.stream()
         .filter(e -> e.getInboundAmount() != null && e.getInboundAmount().compareTo(BigDecimal.ZERO) > 0)
         .collect(Collectors.groupingBy(item -> item.getCreateTime().format(formatter)));
      List<PurchaseOrderGroupMonthDetailDTO> result = new ArrayList<>();

      for (LocalDate monthDate : this.getYearMonthDateList(yearDate)) {
         String key = monthDate.format(formatter);
         if (groupedData.containsKey(key)) {
            List<PurchaseOrderDTO> orderDTOList = groupedData.get(key);
            BigDecimal reduce = orderDTOList.stream().map(PurchaseOrderDTO::getInboundAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
            PurchaseOrderGroupMonthDetailDTO title = PurchaseOrderGroupMonthDetailDTO.builder()
               .index(this.convertToChinese(monthDate.getMonthValue()) + "月小计")
               .amount(reduce)
               .build();
            result.add(title);
            orderDTOList.sort(Comparator.comparing(PurchaseOrderDTO::getCreateTime));

            for (PurchaseOrderDTO orderDTO : orderDTOList) {
               PurchaseOrderGroupMonthDetailDTO content = PurchaseOrderGroupMonthDetailDTO.builder()
                  .index(orderDTO.getCreateTime().format(formatter2))
                  .basicClass(orderDTO.getBasicClass())
                  .purchaseSn(orderDTO.getSerialNumber())
                  .branchCompanyName(orderDTO.getBranchCompany().getName())
                  .amount(orderDTO.getInboundAmount())
                  .build();
               result.add(content);
            }
         }
      }

      return result;
   }

   @Override
   public void getGroupMonthDetailDownload(LocalDate yearDate, Long branchCompanyId, Long supplierId, HttpServletResponse response) {
      List<PurchaseOrderGroupMonthDetailDTO> dtoList = this.getGroupMonthDetail(yearDate, branchCompanyId, supplierId);
      if (!CollectionUtils.isEmpty(dtoList)) {
         String title = "";
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
         title = title + "日期：" + yearDate.format(formatter) + "\n";
         if (branchCompanyId != null) {
            BranchCompany branchCompany = this.branchCompanyService.getById(branchCompanyId);
            if (branchCompany != null) {
               title = title + "分支机构：" + branchCompany.getName() + "\n";
            }
         }

         List<List<String>> headList = new ArrayList<>();
         headList.add(Arrays.asList(title, "序号"));
         headList.add(Arrays.asList(title, "采购订单号"));
         headList.add(Arrays.asList(title, "签订主体"));
         headList.add(Arrays.asList(title, "类别"));
         headList.add(Arrays.asList(title, "入库额（元）"));
         List<List<Object>> dataList = new ArrayList<>();
         dtoList.forEach(ex -> {
            List<Object> data = new ArrayList<>();
            data.add(ex.getIndex());
            data.add(ex.getPurchaseSn());
            data.add(ex.getBranchCompanyName());
            data.add(ex.getBasicClass() != null ? ApplyPurchaseMaterialTypeEnum.getOrderTypeName(ex.getBasicClass()) : "");
            data.add(ex.getAmount().setScale(0, RoundingMode.HALF_UP));
            dataList.add(data);
         });

         try {
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            String fileName = StrUtil.concat(true, "供应商采购详情.xlsx");
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Expose-Headers", "*");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            response.setHeader("Access-Control-Expose-Headers", "*");
            response.setHeader("Result", "code=" + ResultCodeEnum.SUCCESS.getCode() + ";message=" + ResultCodeEnum.SUCCESS.getCode());
            EasyExcel.write(response.getOutputStream())
               .head(headList)
               .registerWriteHandler(new SimpleColumnWidthStyleStrategy(15))
               .registerWriteHandler(
                  new CellWriteHandler() {
                     @Override
                     public void beforeCellCreate(
                        WriteSheetHolder writeSheetHolder,
                        WriteTableHolder writeTableHolder,
                        Row row,
                        Head head,
                        Integer columnIndex,
                        Integer relativeRowIndex,
                        Boolean isHead
                     ) {
                        if (isHead && relativeRowIndex == 0) {
                           row.setHeight((short)550);
                        }
                     }
                  }
               )
               .registerWriteHandler(new HorizontalCellStyleStrategy(new WriteCellStyle() {
                  {
                     this.setHorizontalAlignment(HorizontalAlignment.CENTER);
                     this.setVerticalAlignment(VerticalAlignment.CENTER);
                     this.setWriteFont(new WriteFont() {
                        {
                           this.setFontName("宋体");
                           this.setFontHeightInPoints((short)10);
                           this.setBold(true);
                        }
                     });
                     this.setWrapped(true);
                     this.setShrinkToFit(true);
                  }
               }, new WriteCellStyle() {
                  {
                     this.setHorizontalAlignment(HorizontalAlignment.CENTER);
                     this.setVerticalAlignment(VerticalAlignment.CENTER);
                     this.setBorderBottom(BorderStyle.THIN);
                     this.setBorderLeft(BorderStyle.THIN);
                     this.setBorderRight(BorderStyle.THIN);
                     this.setBorderTop(BorderStyle.THIN);
                  }
               }))
               .sheet("供应商采购详情")
               .doWrite(dataList);
         } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
         }
      }
   }

   private String convertToChinese(int number) {
      Map<Integer, String> numberMap = new HashMap<>();
      numberMap.put(1, "一");
      numberMap.put(2, "二");
      numberMap.put(3, "三");
      numberMap.put(4, "四");
      numberMap.put(5, "五");
      numberMap.put(6, "六");
      numberMap.put(7, "七");
      numberMap.put(8, "八");
      numberMap.put(9, "九");
      numberMap.put(10, "十");
      numberMap.put(11, "十一");
      numberMap.put(12, "十二");
      return numberMap.getOrDefault(number, "");
   }

   private List<LocalDate> getYearMonthDateList(LocalDate year) {
      LocalDate startDate = LocalDate.of(year.getYear(), 1, 1);
      LocalDate endDate = LocalDate.of(year.getYear(), 12, 1);
      List<LocalDate> yearMonthList = new ArrayList<>();
      long monthsBetween = ChronoUnit.MONTHS.between(startDate, endDate);
      Stream.<LocalDate>iterate(startDate, date -> date.plusMonths(1L)).limit(monthsBetween + 1L).forEach(yearMonthList::add);
      return yearMonthList;
   }

   private List<LocalDate> getDaysInMonth(LocalDate month) {
      LocalDate startDate = month.withDayOfMonth(1);
      LocalDate endDate = month.withDayOfMonth(month.lengthOfMonth());
      List<LocalDate> daysInMonthList = new ArrayList<>();
      Stream.<LocalDate>iterate(startDate, date -> date.plusDays(1L)).limit(ChronoUnit.DAYS.between(startDate, endDate) + 1L).forEach(daysInMonthList::add);
      return daysInMonthList;
   }
}
