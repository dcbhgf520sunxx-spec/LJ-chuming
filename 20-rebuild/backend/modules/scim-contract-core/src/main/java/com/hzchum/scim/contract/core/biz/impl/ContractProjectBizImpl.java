package com.hzchum.scim.contract.core.biz.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
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
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.pangu.common.util.SpringUtil;
import com.hzchum.pangu.common.util.UUIDUtil;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.config.ConfigProperties;
import com.hzchum.scim.common.core.api.enums.AttachmentTypeEnum;
import com.hzchum.scim.common.core.api.enums.BranchAttributeEnum;
import com.hzchum.scim.common.core.api.enums.BranchCompanyLevelEnum;
import com.hzchum.scim.common.core.api.enums.ProjectAttributeEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo._do.Attachment;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.common.SupplierInfo;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.common.core.api.pojo.dto.CostSummaryDTO;
import com.hzchum.scim.common.core.api.pojo.dto.ProjectImportDTO;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.common.core.api.utils.BeanToMapUtils;
import com.hzchum.scim.common.core.api.utils.DateTimeUtil;
import com.hzchum.scim.common.core.api.utils.PageUtils;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.common.core.api.utils.ZIPUtils;
import com.hzchum.scim.contract.core.api.biz.ContractCollectionInvoiceBiz;
import com.hzchum.scim.contract.core.api.biz.ContractInvoiceBiz;
import com.hzchum.scim.contract.core.api.biz.ContractProjectBiz;
import com.hzchum.scim.contract.core.api.biz.ContractSupplierPaymentBiz;
import com.hzchum.scim.contract.core.api.biz.finance.ContractProjectAssetInjectionBiz;
import com.hzchum.scim.contract.core.api.common.AddressUtil;
import com.hzchum.scim.contract.core.api.common.MapConstants;
import com.hzchum.scim.contract.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.contract.core.api.enums.ChangeEnum;
import com.hzchum.scim.contract.core.api.enums.ContractDefinitionTypeEnum;
import com.hzchum.scim.contract.core.api.enums.ContractTechTypeEnum;
import com.hzchum.scim.contract.core.api.enums.ContractTypeEnum;
import com.hzchum.scim.contract.core.api.enums.CostTypeEnum;
import com.hzchum.scim.contract.core.api.enums.EnclosureMeasureModeEnum;
import com.hzchum.scim.contract.core.api.enums.PayTypeEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectAddressTypeEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectBusinessTypeEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectContentCategoryEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectContentNoEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectStatusEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectTypeEnum;
import com.hzchum.scim.contract.core.api.enums.SettlementStatusEnum;
import com.hzchum.scim.contract.core.api.enums.StructureMeasureModeEnum;
import com.hzchum.scim.contract.core.api.enums.TaxEnum;
import com.hzchum.scim.contract.core.api.enums.TransportTypeEnum;
import com.hzchum.scim.contract.core.api.enums.finance.AmountTypeEnum;
import com.hzchum.scim.contract.core.api.enums.finance.AuditPaymentEnum;
import com.hzchum.scim.contract.core.api.enums.payment.InvoiceTypeEnum;
import com.hzchum.scim.contract.core.api.enums.payment.OrderClassEnum;
import com.hzchum.scim.contract.core.api.enums.payment.SupplierPropertyTypeEnum;
import com.hzchum.scim.contract.core.api.enums.visa.VisaTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractCollection;
import com.hzchum.scim.contract.core.api.pojo._do.ContractInvoice;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProjectContent;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProjectRecord;
import com.hzchum.scim.contract.core.api.pojo._do.ContractSettlement;
import com.hzchum.scim.contract.core.api.pojo._do.ContractTech;
import com.hzchum.scim.contract.core.api.pojo._do.ContractVisa;
import com.hzchum.scim.contract.core.api.pojo._do.ProjectBranchCompanyLink;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierPayment;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierSettlement;
import com.hzchum.scim.contract.core.api.pojo._do.audit.ContractAuditLedger;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractEarnestMoney;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractExpenseType;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractGivingCredit;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractGivingCreditReturn;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractManagementCost;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractProjectAssetInjection;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractReimbursementFee;
import com.hzchum.scim.contract.core.api.pojo._do.finance.SecurityDepositAndManagementCost;
import com.hzchum.scim.contract.core.api.pojo.dto.AppendAttachmentDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ChangeInfo;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractCollectionDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractInvoiceDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractProjectInfoDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractProjectListDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractProjectListForUserDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractProjectPrimeListDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ManufactureCostDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ProjectBranchCompanyLinkDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ProjectLedgerDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ProjectLedgerV2DTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ProjectRelevancyDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.projectManagerLedgerDisburseDetailDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.PeriodCostDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ProjectCostReportDto;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ProjectElseAllDto;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ProjectExpenseCostReportDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ProjectMaterialsAllDto;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ProjectSelfSupportCostReportDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.project.ManagementFeeAllDto;
import com.hzchum.scim.contract.core.api.pojo.dto.project.ProjectSupplierDto;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ContractProjectArchivistDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ContractProjectFilesDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.EnclosureDictionaryDetailDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.EnclosureDictionaryResponseDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectAttachmentDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectBaseDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectBusinessDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectCustomerDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectDetailsDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectSimpleInfoDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.app.AppCollectionDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.ProjectLedgerSeltSupportPaymentDetailDto;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.ProjectLedgerSeltSupportPaymentDto;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.ProjectLedgerSupplierInvoiceDetailDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.visa.ContractVisaSettlementDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractCollectionQueryDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractInvoiceQueryDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.project.ContractProjectFilesParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.project.ContractProjectIsArchivistParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.project.ProjectLedgerDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.project.ProjectListQueryParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.save.BaseSaveDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.save.BusinessSaveDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.save.CustomerSaveDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.save.MeasureModeDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.save.ProjectSaveDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.save.StructureDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.update.ProjectUserUpdateCollectDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.update.ProjectUserUpdateParam;
import com.hzchum.scim.contract.core.api.service.ContractCollectionService;
import com.hzchum.scim.contract.core.api.service.ContractInvoiceService;
import com.hzchum.scim.contract.core.api.service.ContractProjectContentService;
import com.hzchum.scim.contract.core.api.service.ContractProjectRecordService;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.ContractSettlementService;
import com.hzchum.scim.contract.core.api.service.ContractTechService;
import com.hzchum.scim.contract.core.api.service.ContractVisaService;
import com.hzchum.scim.contract.core.api.service.ManufactureCostService;
import com.hzchum.scim.contract.core.api.service.ProjectBranchCompanyLinkService;
import com.hzchum.scim.contract.core.api.service.SupplierInvoiceService;
import com.hzchum.scim.contract.core.api.service.SupplierPaymentService;
import com.hzchum.scim.contract.core.api.service.SupplierSettlementService;
import com.hzchum.scim.contract.core.api.service.audit.ContractAuditLedgerService;
import com.hzchum.scim.contract.core.api.service.finance.ContractEarnestMoneyService;
import com.hzchum.scim.contract.core.api.service.finance.ContractExpenseTypeService;
import com.hzchum.scim.contract.core.api.service.finance.ContractGivingCreditDetailService;
import com.hzchum.scim.contract.core.api.service.finance.ContractGivingCreditReturnService;
import com.hzchum.scim.contract.core.api.service.finance.ContractGivingCreditService;
import com.hzchum.scim.contract.core.api.service.finance.ContractManagementCostService;
import com.hzchum.scim.contract.core.api.service.finance.ContractProjectAssetInjectionService;
import com.hzchum.scim.contract.core.api.service.finance.ContractReimbursementFeeService;
import com.hzchum.scim.contract.core.api.service.finance.SecurityDepositAndManagementCostService;
import com.hzchum.scim.contract.core.api.utils.ProjectFinanceUtils;
import com.hzchum.scim.contract.core.mapper.ContractProjectMapper;
import com.hzchum.scim.plan.core.api.enums.ProjectPlanProductCategoryEnum;
import com.hzchum.scim.plan.core.api.pojo._do.EnclosurePlan;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo.dto.MistakeExportDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanAreaBatchDTO;
import com.hzchum.scim.plan.core.api.service.EnclosurePlanService;
import com.hzchum.scim.plan.core.api.service.PlanAreaBatchService;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.scm.core.api.enums.PlaceEnum;
import com.hzchum.scim.scm.core.api.enums.SubSupplyTypeEnum;
import com.hzchum.scim.scm.core.api.pojo._do.ApplyPurchase;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrder;
import com.hzchum.scim.scm.core.api.pojo._do.SubcontractOrder;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import com.hzchum.scim.scm.core.api.service.ApplyPurchaseService;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import com.hzchum.scim.scm.core.api.service.SubcontractOrderService;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import com.hzchum.scim.system.core.api.biz.notification.SysPushFlowConfigBiz;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.enums.DictionaryEnum;
import com.hzchum.scim.system.core.api.common.enums.DingDingMessageTypeEnum;
import com.hzchum.scim.system.core.api.common.enums.SysPressureBearingPlateEnum;
import com.hzchum.scim.system.core.api.common.enums.SysProfiledPlateEnum;
import com.hzchum.scim.system.core.api.common.enums.SysSandwichBoardEnum;
import com.hzchum.scim.system.core.api.common.enums.notification.NotificationModuleTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.DingDingUtils;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.common.utils.notification.NotificationTemplateDetailsUtils;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.pojo._do.Department;
import com.hzchum.scim.system.core.api.pojo._do.MonomerUserLink;
import com.hzchum.scim.system.core.api.pojo._do.ProjectUserLink;
import com.hzchum.scim.system.core.api.pojo._do.SysCity;
import com.hzchum.scim.system.core.api.pojo._do.SysCountry;
import com.hzchum.scim.system.core.api.pojo._do.SysDictionary;
import com.hzchum.scim.system.core.api.pojo._do.SysEnclosureDictionary;
import com.hzchum.scim.system.core.api.pojo._do.SysEnclosureDictionaryDetail;
import com.hzchum.scim.system.core.api.pojo._do.SysProjectPersonnel;
import com.hzchum.scim.system.core.api.pojo._do.SysProvince;
import com.hzchum.scim.system.core.api.pojo._do.SysRegion;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureType;
import com.hzchum.scim.system.core.api.pojo._do.SysTemplateUserLink;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo.dto.DepartmentDTO;
import com.hzchum.scim.system.core.api.pojo.dto.SysEnclosureDictionarySimpleDTO;
import com.hzchum.scim.system.core.api.pojo.dto.SysTrussFloorPlateCodeDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.FinanceAmountShowConfigDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.FinishedProductWareConfigDTO;
import com.hzchum.scim.system.core.api.pojo.dto.notification.NotificationServiceTriggerDTO;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.system.core.api.service.ConfigService;
import com.hzchum.scim.system.core.api.service.DepartmentService;
import com.hzchum.scim.system.core.api.service.MonomerUserLinkService;
import com.hzchum.scim.system.core.api.service.ProjectUserLinkService;
import com.hzchum.scim.system.core.api.service.SysCityService;
import com.hzchum.scim.system.core.api.service.SysCountryService;
import com.hzchum.scim.system.core.api.service.SysDictionaryService;
import com.hzchum.scim.system.core.api.service.SysEnclosureDictionaryDetailService;
import com.hzchum.scim.system.core.api.service.SysEnclosureDictionaryService;
import com.hzchum.scim.system.core.api.service.SysProjectPersonnelService;
import com.hzchum.scim.system.core.api.service.SysProvinceService;
import com.hzchum.scim.system.core.api.service.SysRegionService;
import com.hzchum.scim.system.core.api.service.SysStructureTypeService;
import com.hzchum.scim.system.core.api.service.SysTemplateUserLinkService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.wms.core.api.enums.DataStatusEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Inbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Outbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Transfer;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialInventoryService;
import com.hzchum.scim.wms.core.api.service.wmsUse.OutboundService;
import com.hzchum.scim.wms.core.api.service.wmsUse.TransferService;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ContractProjectBizImpl extends IBizImpl<ContractProjectService, ContractProjectMapper, ContractProject> implements ContractProjectBiz {
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private ContractProjectService projectService;
   @Resource
   private ContractProjectContentService projectContentService;
   @Resource
   private ContractInvoiceService invoiceService;
   @Resource
   private UserService userService;
   @Resource
   private DepartmentService departmentService;
   @Resource
   private SysDictionaryService dictionaryService;
   @Resource
   private BranchCompanyService branchCompanyService;
   @Resource
   private SysCountryService countryService;
   @Resource
   private SysProvinceService provinceService;
   @Resource
   private SysCityService cityService;
   @Resource
   private SysRegionService regionService;
   @Resource
   private SysStructureTypeService structureTypeService;
   @Resource
   private ConfigService configService;
   @Resource
   private ProjectUserLinkService projectUserLinkService;
   @Resource
   private ContractProjectRecordService projectRecordService;
   @Resource
   private RedisUtils redisUtils;
   @Resource
   private ContractCollectionService collectionService;
   @Resource
   private ContractTechService contractTechService;
   @Resource
   private SysEnclosureDictionaryService enclosureDictionaryService;
   @Resource
   private SysEnclosureDictionaryDetailService enclosureDictionaryDetailService;
   @Resource
   private PlanMonomerService monomerService;
   @Resource
   private PlanAreaBatchService areaBatchService;
   @Resource
   private ContractVisaService visaService;
   @Resource
   private ConfigProperties configProperties;
   @Resource
   private PurchaseOrderService purchaseOrderService;
   @Resource
   private MaterialInventoryService materialInventoryService;
   @Resource
   private EnclosurePlanService enclosurePlanService;
   @Resource
   private InboundService inboundService;
   @Resource
   private OutboundService outboundService;
   @Resource
   private TransferService transferService;
   @Resource
   private ApplyPurchaseService applyPurchaseService;
   @Resource
   private MonomerUserLinkService monomerUserLinkService;
   @Resource
   private ContractCollectionService contractCollectionService;
   @Resource
   private ContractManagementCostService contractManagementCostService;
   @Resource
   private ContractEarnestMoneyService earnestMoneyService;
   @Resource
   private SecurityDepositAndManagementCostService securityDepositAndManagementCostService;
   @Resource
   private ContractGivingCreditService contractGivingCreditService;
   @Resource
   private SupplierPaymentService supplierPaymentService;
   @Resource
   private SupplierService supplierService;
   @Resource
   private ContractInvoiceBiz contractInvoiceBiz;
   @Resource
   private ContractProjectAssetInjectionBiz assetInjectionService;
   @Resource
   private ContractProjectAssetInjectionService injectorService;
   @Resource
   private ContractReimbursementFeeService reimbursementFeeService;
   @Resource
   private SysPushFlowConfigBiz sysPushFlowConfigBiz;
   @Resource
   private NotificationTemplateDetailsUtils detailsUtils;
   @Autowired
   private PlanAreaService areaService;
   @Autowired
   private ProjectBranchCompanyLinkService projectBranchCompanyLinkService;
   @Resource
   private SubcontractOrderService subcontractOrderService;
   @Resource
   private ContractSupplierPaymentBiz contractSupplierPaymentBiz;
   @Resource
   private SupplierSettlementService supplierSettlementService;
   @Resource
   private ContractExpenseTypeService contractExpenseTypeService;
   @Resource
   private SupplierInvoiceService supplierInvoiceService;
   @Resource
   private ContractGivingCreditDetailService givingCreditDetailService;
   @Resource
   private ContractGivingCreditReturnService givingCreditReturnService;
   @Resource
   private ContractAuditLedgerService contractAuditLedgerService;
   @Resource
   private ProjectFinanceUtils projectFinanceUtils;
   @Resource
   private SysProjectPersonnelService sysProjectPersonnelService;
   @Resource
   private SysTemplateUserLinkService sysTemplateUserLinkService;
   @Resource
   private ContractCollectionInvoiceBiz collectionInvoiceBiz;
   @Resource
   private ManufactureCostService manufactureCostService;
   @Resource
   private ContractSettlementService contractSettlementService;
   @Resource
   ProjectBranchCompanyLinkService companyLinkService;

   @Override
   public PageVO<ContractProjectListDTO> pageListProjectByCondition(ProjectListQueryParam queryParam, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      return new PageVO<>(this.listByConditions(queryParam));
   }

   @Override
   public PageVO<ContractProjectListForUserDTO> pageListProjectByIdOrName(ProjectListQueryParam queryParam, Integer pageNumber, Integer pageSize) {
      SecurityUser user = UserUtil.getCurrentUser();
      queryParam.setUserId(user.isAdmin() ? null : user.getId());
      PageHelper.startPage(pageNumber, pageSize);
      List<ContractProjectListForUserDTO> projectResponseDTOS = this.projectService.listProjectsByIdOrName(queryParam);
      return new PageVO<>(projectResponseDTOS);
   }

   @Override
   public List<ContractProjectListForUserDTO> pageListProjectByIdOrNameAll(ProjectListQueryParam queryParam) {
      SecurityUser user = UserUtil.getCurrentUser();
      queryParam.setUserId(user.isAdmin() ? null : user.getId());
      return this.projectService.listProjectsByIdOrName(queryParam);
   }

   @Override
   public PageVO<ContractProjectListDTO> pageListProject(ProjectListQueryParam queryParam, Integer pageNumber, Integer pageSize) {
      List<ContractProjectListDTO> allProject = this.projectService.listProjectsByConditions(queryParam);
      if (CollectionUtils.isEmpty(allProject)) {
         return new PageVO<>();
      }

      List<Long> pIds = allProject.stream().map(ContractProjectListDTO::getPId).filter(Objects::nonNull).distinct().collect(Collectors.toList());
      List<Long> idsWithoutPid = allProject.stream().filter(dto -> dto.getPId() == null).map(ContractProjectListDTO::getId).collect(Collectors.toList());
      List<Long> combinedIds = Stream.concat(pIds.stream(), idsWithoutPid.stream()).distinct().collect(Collectors.toList());
      PageHelper.startPage(pageNumber, pageSize);
      List<ContractProject> contractProjectList = this.projectService
         .selectContractProjectList(combinedIds, UserUtil.getCurrentUser().isAdmin() ? null : UserUtil.getCurrentUserId());
      List<ContractProjectListDTO> fatherContractProjectListDTOS = new ArrayList<>();
      List<ContractProjectListDTO> subContractProjectListDTOS = allProject.stream().filter(dto -> dto.getPId() != null).collect(Collectors.toList());

      for (ContractProject contractProject : contractProjectList) {
         ContractProjectListDTO contractProjectListDTO = new ContractProjectListDTO();
         BeanUtil.copy(contractProject, contractProjectListDTO);
         fatherContractProjectListDTOS.add(contractProjectListDTO);
      }

      subContractProjectListDTOS.forEach(p -> {
         Long userId = p.getUserId();
         if (userId != null) {
            p.setUserName(this.userService.getNameById(userId));
         }

         if (p.getProjectManagerId() != null) {
            p.setProjectManagerName(this.userService.getNameById(p.getProjectManagerId()));
         } else if (p.getSalesLeaderId() != null) {
            p.setSalesLeaderName(this.userService.getNameById(p.getSalesLeaderId()));
         }

         if (p.getContractSignBodyId() != null) {
            p.setContractSignBodyName(this.branchCompanyService.getNameById(p.getContractSignBodyId()));
         }

         p.setAlreadyDays(LocalDate.now().isAfter(p.getStartDate()) ? DateTimeUtil.getBetweenDays(p.getStartDate(), LocalDate.now()) : 1);
         p.setAllDays(DateTimeUtil.getBetweenDays(p.getStartDate(), p.getEndDate()));
      });
      fatherContractProjectListDTOS.forEach(p -> {
         Long userId = p.getUserId();
         if (userId != null) {
            p.setUserName(this.userService.getNameById(userId));
         }

         if (p.getProjectManagerId() != null) {
            p.setProjectManagerName(this.userService.getNameById(p.getProjectManagerId()));
         } else if (p.getSalesLeaderId() != null) {
            p.setSalesLeaderName(this.userService.getNameById(p.getSalesLeaderId()));
         }

         if (p.getContractSignBodyId() != null) {
            p.setContractSignBodyName(this.branchCompanyService.getNameById(p.getContractSignBodyId()));
         }

         p.setAlreadyDays(LocalDate.now().isAfter(p.getStartDate()) ? DateTimeUtil.getBetweenDays(p.getStartDate(), LocalDate.now()) : 1);
         p.setAllDays(DateTimeUtil.getBetweenDays(p.getStartDate(), p.getEndDate()));
      });
      Map<Long, SysDictionary> dictionaryMap = this.dictionaryService.list().stream().collect(Collectors.toMap(SysDictionary::getId, Function.identity()));
      fatherContractProjectListDTOS.forEach(
         p -> {
            if (CollectionUtils.isNotEmpty(dictionaryMap)) {
               if (p.getStructureStatus() != null && dictionaryMap.get(p.getStructureStatus()) != null) {
                  p.setStructureStatusName(dictionaryMap.get(p.getStructureStatus()).getLabel());
               }

               if (p.getInfoSource() != null && dictionaryMap.get(p.getStructureStatus()) != null) {
                  p.setInfoSourceName(dictionaryMap.get(p.getInfoSource()).getLabel());
               }
            }

            Long projectId = p.getId();
            List<ContractCollection> contractCollectionList = this.contractCollectionService
               .list(Wrappers.lambdaQuery(ContractCollection.class).eq(ContractCollection::getProjectId, projectId).eq(ContractCollection::getAuditStatus, 2));
            if (CollectionUtils.isNotEmpty(contractCollectionList)) {
               p.setIsEffective(1);
            } else {
               p.setIsEffective(0);
            }

            Long pId = p.getId();
            List<ContractProjectListDTO> list = new ArrayList<>();
            subContractProjectListDTOS.forEach(p1 -> {
               if (CollectionUtils.isNotEmpty(dictionaryMap)) {
                  if (p1.getStructureStatus() != null) {
                     p1.setStructureStatusName(dictionaryMap.get(p1.getStructureStatus()).getLabel());
                  }

                  if (p1.getInfoSource() != null) {
                     p1.setInfoSourceName(dictionaryMap.get(p1.getInfoSource()).getLabel());
                  }
               }

               if (p1.getPId() != null && p1.getPId().equals(pId)) {
                  list.add(p1);
               }
            });
            p.setSubcontractList(list);
         }
      );
      fatherContractProjectListDTOS.forEach(p -> {
         List<ContractProjectListDTO> subcontractList = p.getSubcontractList();
         if (CollectionUtils.isNotEmpty(subcontractList)) {
            subcontractList.sort(Comparator.comparing(ContractProjectListDTO::getCreateTime));
         }
      });
      return new PageVO<>(PageUtils.getPageInfo(fatherContractProjectListDTOS, contractProjectList));
   }

   @Override
   public PageVO<ProjectSimpleInfoDTO> getMyProjects(
      Integer status, String noOrName, Integer projectType, Integer year, Integer lumpSumSystemType, Integer level, Integer pageNumber, Integer pageSize
   ) {
      PageHelper.startPage(pageNumber, pageSize);
      LocalDate firstDayOfYear = year != null ? LocalDate.of(year, 1, 1) : null;
      LocalDate lastDayOfYear = year != null ? LocalDate.of(year, 12, 31) : null;
      List<ProjectSimpleInfoDTO> projectSimpleInfoDTOS = this.projectService
         .selectContractProjects(
            status,
            noOrName,
            firstDayOfYear,
            lastDayOfYear,
            projectType,
            lumpSumSystemType,
            UserUtil.getCurrentUser().isAdmin() ? null : UserUtil.getCurrentUserId()
         );
      projectSimpleInfoDTOS = projectSimpleInfoDTOS.stream()
         .filter(a -> !a.getBusinessType().equals(ProjectBusinessTypeEnum.INSTALL.getType()))
         .collect(Collectors.toList());
      Map<Long, User> userMap = this.userService.list().stream().collect(Collectors.toMap(User::getId, Function.identity()));
      projectSimpleInfoDTOS.stream().forEach(p -> {
         Long userId = p.getUserId();
         if (userId != null && ObjectUtils.isNotEmpty(userMap.get(userId))) {
            p.setCreateName(userMap.get(userId).getName());
         }

         if (p.getProjectManagerId() != null) {
            p.setProjectManagerName(userMap.get(p.getProjectManagerId()).getName());
         }

         if (p.getSalesLeaderId() != null) {
            p.setSalesLeaderName(userMap.get(p.getSalesLeaderId()).getName());
         }

         SysDictionary sysDictionary = this.dictionaryService.getById(p.getStructureStatus());
         if (sysDictionary != null) {
            p.setStructureStatusName(sysDictionary.getLabel());
         }

         Long pId = p.getId();
         List<PlanMonomer> planMonomerlist = this.monomerService.list(Wrappers.lambdaQuery(PlanMonomer.class).eq(PlanMonomer::getProjectId, pId));
         if (CollectionUtils.isEmpty(planMonomerlist)) {
            p.setHavePlan(0);
         } else {
            p.setHavePlan(1);
         }

         LocalDate startDate = p.getStartDate();
         LocalDate endDate = p.getEndDate();
         if (startDate != null && endDate != null) {
            p.setAlreadyDays((int)ChronoUnit.DAYS.between(startDate, LocalDate.now().plusDays(1L)));
         }
      });
      return new PageVO<>(PageUtils.getPageInfo(projectSimpleInfoDTOS, projectSimpleInfoDTOS));
   }

   @Override
   public Map<String, Integer> projectWageEstimateProjectQuantityStatistics(Integer year) {
      return null;
   }

   private List<ContractProjectListDTO> listByConditions(ProjectListQueryParam queryParam) {
      SecurityUser user = UserUtil.getCurrentUser();
      queryParam.setUserId(user.isAdmin() ? null : user.getId());
      List<ContractProjectListDTO> projectResponseDTOS = this.projectService.listProjectsByConditions(queryParam);
      projectResponseDTOS.forEach(p -> {
         Long userId = p.getUserId();
         if (userId != null) {
            p.setUserName(this.userService.getNameById(userId));
         }

         if (p.getProjectManagerId() != null) {
            p.setProjectManagerName(this.userService.getNameById(p.getProjectManagerId()));
         } else if (p.getSalesLeaderId() != null) {
            p.setSalesLeaderName(this.userService.getNameById(p.getSalesLeaderId()));
         }

         if (p.getContractSignBodyId() != null) {
            p.setContractSignBodyName(this.branchCompanyService.getNameById(p.getContractSignBodyId()));
         }

         p.setAlreadyDays(LocalDate.now().isAfter(p.getStartDate()) ? DateTimeUtil.getBetweenDays(p.getStartDate(), LocalDate.now()) : 1);
      });
      List<ContractProjectListDTO> ContractProjectListDTOS = projectResponseDTOS.stream().filter(p -> p.getPId() == null).collect(Collectors.toList());
      if (CollectionUtils.isEmpty(ContractProjectListDTOS) && CollectionUtils.isNotEmpty(projectResponseDTOS)) {
         List<Long> pids = projectResponseDTOS.stream().map(ContractProjectListDTO::getPId).distinct().collect(Collectors.toList());

         for (ContractProject contractProject : this.projectService.list(Wrappers.lambdaQuery(ContractProject.class).in(ContractProject::getId, pids))) {
            ContractProjectListDTO contractProjectListDTO = new ContractProjectListDTO();
            BeanUtil.copy(contractProject, contractProjectListDTO);
            ContractProjectListDTOS.add(contractProjectListDTO);
         }

         for (ContractProjectListDTO contractProjectListDTO : ContractProjectListDTOS) {
            List<ContractProjectListDTO> lists = new ArrayList<>();
            projectResponseDTOS.forEach(p1 -> {
               if (p1.getPId() != null && p1.getPId().equals(contractProjectListDTO.getId())) {
                  lists.add(p1);
               }
            });
            contractProjectListDTO.setSubcontractList(lists);
         }

         return ContractProjectListDTOS;
      } else {
         ContractProjectListDTOS.forEach(p -> {
            Long pId = p.getId();
            List<ContractProjectListDTO> list = new ArrayList<>();
            projectResponseDTOS.forEach(p1 -> {
               if (p1.getPId() != null && p1.getPId().equals(pId)) {
                  list.add(p1);
               }
            });
            p.setSubcontractList(list);
         });
         return ContractProjectListDTOS;
      }
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printContractByConditions(ProjectListQueryParam queryParam) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("year", queryParam.getYear());
      printVO.setHeader(header);
      List<ContractProjectListDTO> projectSimpleResponseDTOS = this.listByConditions(queryParam);
      List<Map<String, Object>> mapList = projectSimpleResponseDTOS.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public BigDecimal getSumStructureWorkQuantity(ProjectListQueryParam param) {
      SecurityUser user = UserUtil.getCurrentUser();
      param.setUserId(user.isAdmin() ? null : user.getId());
      List<ContractProjectListDTO> projectListDTOS = this.baseService.listProjectsByConditions(param);
      return projectListDTOS.stream()
         .map(ContractProjectListDTO::getStructureQuantityWork)
         .filter(Objects::nonNull)
         .reduce(BigDecimal.ZERO, BigDecimal::add)
         .divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP);
   }

   @Override
   public PageVO<ContractProjectFilesDTO> listProjectFiles(
      ContractProjectFilesParam contractProjectFilesParam, Long projectId, Integer pageNumber, Integer pageSize
   ) {
      SecurityUser user = UserUtil.getCurrentUser();
      Long userId = user.isAdmin() ? null : user.getId();
      List<ContractProject> contractProjects = this.projectService.listProjectFiles(projectId, userId, contractProjectFilesParam);
      List<ContractProject> fatherContractList = contractProjects.stream().filter(p -> p.getPId() == null).collect(Collectors.toList());
      List<ContractProject> subcontractList = contractProjects.stream().filter(p -> p.getPId() != null).collect(Collectors.toList());
      List<Long> pIds = fatherContractList.stream().map(ContractProject::getId).collect(Collectors.toList());
      List<Long> sIds = subcontractList.stream().map(ContractProject::getPId).collect(Collectors.toList());
      List<Long> fatherIds = Stream.concat(pIds.stream(), sIds.stream()).distinct().collect(Collectors.toList());
      List<ContractProjectFilesDTO> subcontractFilesList = null;
      if (CollectionUtils.isNotEmpty(fatherIds)) {
         PageHelper.startPage(pageNumber, pageSize);
         fatherContractList = this.projectService
            .list(Wrappers.lambdaQuery(ContractProject.class).in(ContractProject::getId, fatherIds).orderByDesc(BaseEntity::getCreateTime));
         subcontractFilesList = this.getContractProjectFilesDTOS(subcontractList, AttachmentTypeEnum.CONTRACT_ARCHIVES.getType());
      }

      List<ContractProjectFilesDTO> fatherContractFilesList = this.getContractProjectFilesDTOS(
         fatherContractList, AttachmentTypeEnum.CONTRACT_ARCHIVES.getType()
      );

      for (SysDictionary sysDictionary : this.dictionaryService.list()) {
         if (CollectionUtils.isNotEmpty(subcontractFilesList)) {
            subcontractFilesList.forEach(p -> {
               if (p.getStructureStatus() != null && p.getStructureStatus().equals(sysDictionary.getId())) {
                  p.setStructureStatusName(sysDictionary.getLabel());
               }
            });
         }

         if (CollectionUtils.isNotEmpty(fatherContractFilesList)) {
            fatherContractFilesList.forEach(p -> {
               if (p.getStructureStatus() != null && p.getStructureStatus().equals(sysDictionary.getId())) {
                  p.setStructureStatusName(sysDictionary.getLabel());
               }
            });
         }
      }

      for (ContractProjectFilesDTO fatherContract : fatherContractFilesList) {
         Long fatherContractId = fatherContract.getId();
         List<Long> projectIds = new ArrayList<>();
         projectIds.add(fatherContractId);
         Integer contractType = fatherContract.getContractType();
         if (contractType != null && contractType.equals(ContractTypeEnum.MASTER_CONTRACT.getType())) {
            fatherContract.setContractDefinitionType(ContractDefinitionTypeEnum.CONTRACT.getType());
         }

         if (contractType != null && contractType.equals(ContractTypeEnum.REPLENISHMENT_CONTRACT.getType())
            || contractType.equals(ContractTypeEnum.QUANTITY_ADDITION_CONTRACT.getType())) {
            fatherContract.setContractDefinitionType(ContractDefinitionTypeEnum.REPLENISHMENT_CONTRACT.getType());
         }

         fatherContract.setAlreadyArchive(0);
         fatherContract.setNotArchive(0);
         List<ContractProjectFilesDTO> contractProjectFilesDTOS = new ArrayList<>();
         if (CollectionUtils.isNotEmpty(subcontractFilesList)) {
            for (ContractProjectFilesDTO subcontract : subcontractFilesList) {
               if (subcontract.getPId().equals(fatherContractId)) {
                  contractProjectFilesDTOS.add(subcontract);
                  projectIds.add(subcontract.getId());
                  Integer subcontractType = subcontract.getContractType();
                  if (subcontractType != null && subcontractType.equals(ContractTypeEnum.MASTER_CONTRACT.getType())) {
                     subcontract.setContractDefinitionType(ContractDefinitionTypeEnum.CONTRACT.getType());
                  }

                  if (subcontractType != null && subcontractType.equals(ContractTypeEnum.REPLENISHMENT_CONTRACT.getType())
                     || subcontractType.equals(ContractTypeEnum.QUANTITY_ADDITION_CONTRACT.getType())) {
                     subcontract.setContractDefinitionType(ContractDefinitionTypeEnum.REPLENISHMENT_CONTRACT.getType());
                  }

                  if (StringUtils.isNotEmpty(subcontract.getAttachments())) {
                     long count = this.attachmentService
                        .listByIds(subcontract.getAttachments())
                        .stream()
                        .filter(p -> p.getType().equals(AttachmentTypeEnum.CONTRACT_ARCHIVES.getType()))
                        .count();
                     if (count > 0L) {
                        fatherContract.setAlreadyArchive(fatherContract.getAlreadyArchive() + 1);
                     } else {
                        fatherContract.setNotArchive(fatherContract.getNotArchive() + 1);
                     }
                  } else {
                     fatherContract.setNotArchive(fatherContract.getNotArchive() + 1);
                  }
               }
            }
         }

         if (StringUtils.isNotEmpty(fatherContract.getAttachments())) {
            long count = this.attachmentService
               .listByIds(fatherContract.getAttachments())
               .stream()
               .filter(p -> p.getType().equals(AttachmentTypeEnum.CONTRACT_ARCHIVES.getType()))
               .count();
            if (count > 0L) {
               fatherContract.setAlreadyArchive(fatherContract.getAlreadyArchive() + 1);
            } else {
               fatherContract.setNotArchive(fatherContract.getNotArchive() + 1);
            }
         } else {
            fatherContract.setNotArchive(fatherContract.getNotArchive() + 1);
         }

         fatherContract.setProjectIds(projectIds);
         fatherContract.setProjectFilesDTOS(contractProjectFilesDTOS);
         fatherContract.setContractQuantity(fatherContract.getAlreadyArchive() + fatherContract.getNotArchive());
      }

      return new PageVO<>(PageUtils.getPageInfo(fatherContractFilesList, fatherContractList));
   }

   private List<ContractProjectFilesDTO> getContractProjectFilesDTOS(List<ContractProject> projectList, Integer type) {
      return projectList.stream()
         .map(
            p -> {
               ContractProjectFilesDTO projectFilesDTO = BeanUtil.copy(p, ContractProjectFilesDTO.class);
               List<ProjectAttachmentDTO> projectAttachmentDTOList = new ArrayList<>(16);
               projectFilesDTO.setContractCreatorName(p.getSignerName() != null ? p.getSignerName() : "");
               BranchCompany branchCompany = this.branchCompanyService.getById(p.getContractSignBodyId() != null ? p.getContractSignBodyId() : null);
               projectFilesDTO.setContractSignBodyName(branchCompany != null && branchCompany.getName() != null ? branchCompany.getName() : "");
               if (p.getProjectManagerId() != null) {
                  projectFilesDTO.setProjectManagerName(this.userService.getNameById(p.getProjectManagerId()));
               }

               if (p.getSalesLeaderId() != null) {
                  projectFilesDTO.setSalesLeaderName(this.userService.getNameById(p.getSalesLeaderId()));
               }

               this.attachmentService.listByIdsAndType(p.getAttachments(), type).forEach(attachmentDTO -> {
                  projectFilesDTO.setArchivistDate(attachmentDTO.getCreateTime() != null ? attachmentDTO.getCreateTime() : null);
                  projectFilesDTO.setContractArchivistName(attachmentDTO.getCreateUserName() != null ? attachmentDTO.getCreateUserName() : "");
                  ProjectAttachmentDTO projectAttachmentDTO = BeanUtil.copy(attachmentDTO, ProjectAttachmentDTO.class);
                  projectAttachmentDTO.setFilePath(attachmentDTO.getImageUrl());
                  projectAttachmentDTO.setSourceName("合同立项");
                  projectAttachmentDTOList.add(projectAttachmentDTO);
               });
               projectFilesDTO.setAttachmentCount(projectAttachmentDTOList.size());
               projectFilesDTO.setAttachmentDTOList(
                  projectAttachmentDTOList.stream().sorted(Comparator.comparing(ProjectAttachmentDTO::getCreateTime)).collect(Collectors.toList())
               );
               return projectFilesDTO;
            }
         )
         .collect(Collectors.toList());
   }

   @Override
   public Boolean exportProject(Long id, HttpServletResponse response) {
      ContractProject project = this.projectService.getById(id);
      Preconditions.checkArgument(project != null, "合同导出失败，项目不存在！");
      Map<Long, SysDictionary> sysDictionaryMap = this.dictionaryService.list().stream().collect(Collectors.toMap(SysDictionary::getId, Function.identity()));
      Map<String, Object> projectMap = BeanUtil.beanToMap(project);
      String userName = this.userService.getNameById(project.getUserId());
      projectMap.put("userName", userName != null ? userName : "/");
      DepartmentDTO departmentDTO = this.departmentService.getDepartmentByUserId(project.getUserId());
      if (project.getProvinceName() != null && project.getRegionName() != null && project.getCityName() != null) {
         projectMap.put("simpleAddress", project.getProvinceName() + project.getCityName() + project.getRegionName());
      } else if (project.getProvinceName() != null && project.getCityName() != null) {
         projectMap.put("simpleAddress", project.getProvinceName() + project.getCityName());
      } else if (project.getProvinceName() != null) {
         projectMap.put("simpleAddress", project.getProvinceName());
      } else {
         projectMap.put("simpleAddress", "/");
      }

      projectMap.put("departmentName", departmentDTO != null ? departmentDTO.getName() : "/");
      if (project.getStructureArea() != null && project.getUnitType() != null) {
         BigDecimal structureArea = project.getStructureArea().setScale(2, RoundingMode.HALF_UP);
         if (project.getUnitType().equals(2)) {
            projectMap.put("structureArea", structureArea + "㎡");
         } else if (project.getUnitType().equals(1)) {
            projectMap.put("structureArea", structureArea + "吨");
         }
      } else {
         projectMap.put("structureArea", "/");
      }

      if (project.getCurrencyType() != null) {
         projectMap.put("currencyType", sysDictionaryMap.get(project.getCurrencyType()).getLabel());
      } else {
         projectMap.put("currencyType", "/");
      }

      projectMap.put("regionalFullName", AddressUtil.getAddress(project, ProjectAddressTypeEnum.PROJECT_ADDRESS.getType()));
      projectMap.put(
         "managementFee", project.getContractAmount().multiply(project.getManagementFeeRate()).divide(BigDecimal.valueOf(100L), 0, RoundingMode.HALF_UP)
      );
      projectMap.put("managementFeeRate", project.getManagementFeeRate() + "%");
      projectMap.put("isTax", TaxEnum.getNameByType(project.getIsTax()));
      projectMap.put("taxRate", project.getTaxRate() != null ? project.getTaxRate().multiply(BigDecimal.valueOf(100L)).intValue() + "%" : "-%");
      if (project.getSendingMode() != null) {
         projectMap.put("sendingMode", sysDictionaryMap.get(project.getSendingMode()).getLabel());
      } else {
         projectMap.put("sendingMode", "/");
      }

      if (project.getPartyType() != null) {
         projectMap.put("partyType", sysDictionaryMap.get(project.getPartyType()).getLabel());
      } else {
         projectMap.put("partyType", "/");
      }

      if (project.getInfoSource() != null) {
         projectMap.put("infoSource", sysDictionaryMap.get(project.getInfoSource()).getLabel());
      } else {
         projectMap.put("infoSource", "/");
      }

      if (project.getStructureStatus() != null) {
         projectMap.put("structureStatusEnum", sysDictionaryMap.get(project.getStructureStatus()).getLabel());
      } else {
         projectMap.put("structureStatus", "/");
      }

      projectMap.put("taxRate", project.getTaxRate() != null ? project.getTaxRate() + "%" : "/");
      projectMap.put("address", StringUtils.isNotEmpty(project.getAddress()) ? project.getAddress() : "/");
      projectMap.put("isBuilding", project.getIsBuilding() != null ? (project.getIsBuilding() != 0 ? "是" : "否") : "/");
      if (project.getProjectType() != null) {
         StringBuilder sb = new StringBuilder();
         if ((project.getProjectType() & ProjectTypeEnum.MES.getType()) != 0) {
            sb.append("建筑钢结构");
            sb.append(",");
         }

         if ((project.getProjectType() & ProjectTypeEnum.PARKING_LOT.getType()) != 0) {
            sb.append("立体停车库");
            sb.append(",");
         }

         if ((project.getProjectType() & ProjectTypeEnum.ENCLOSURE.getType()) != 0) {
            sb.append("建筑围护制品");
            sb.append(",");
         }

         if ((project.getProjectType() & ProjectTypeEnum.PAINTING.getType()) != 0) {
            sb.append("涂装分项");
            sb.append(",");
         }

         if ((project.getProjectType() & ProjectTypeEnum.WINDOWS.getType()) != 0) {
            sb.append("门窗分项");
            sb.append(",");
         }

         if ((project.getProjectType() & ProjectTypeEnum.OTHER.getType()) != 0) {
            sb.append("其他分项");
            sb.append(",");
         }

         if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
         }

         projectMap.put("projectType", StringUtils.isNotEmpty(sb.toString()) ? sb.toString() : "/");
      } else {
         projectMap.put("projectType", "/");
      }

      if (project.getMarginType() != null) {
         projectMap.put("marginType", sysDictionaryMap.get(project.getMarginType()).getLabel());
      } else {
         projectMap.put("marginType", "/");
      }

      if (project.getCurrencyType() != null) {
         projectMap.put("currencyType", sysDictionaryMap.get(project.getCurrencyType()).getLabel());
      } else {
         projectMap.put("currencyType", "/");
      }

      projectMap.put(
         "qualityGuaranteeDeposit", project.getQualityGuaranteeDeposit() != null ? project.getQualityGuaranteeDeposit().setScale(2, RoundingMode.HALF_UP) : "/"
      );
      if (project.getProjectManagerId() != null) {
         String name = this.userService.getNameById(project.getProjectManagerId());
         projectMap.put("projectManagerName", name != null ? name : "/");
      }

      if (project.getSalesLeaderId() != null) {
         String salesLeaderName = this.userService.getNameById(project.getSalesLeaderId());
         projectMap.put("salesLeaderName", salesLeaderName != null ? salesLeaderName : "/");
      } else {
         projectMap.put("salesLeaderName", "/");
      }

      projectMap.put("marginType", project.getMarginType() != null ? project.getMarginType() : "/");
      if (project.getMarginType() != null) {
         projectMap.put("marginType", sysDictionaryMap.get(project.getMarginType()).getLabel());
      } else {
         projectMap.put("marginType", "/");
      }

      BranchCompany branchCompany = this.branchCompanyService.getById(project.getContractSignBodyId());
      projectMap.put("contractSignBodyName", branchCompany != null ? branchCompany.getName() : "/");
      projectMap.put(
         "businessType",
         ProjectBusinessTypeEnum.getNameByType(project.getBusinessType()) != null ? ProjectBusinessTypeEnum.getNameByType(project.getBusinessType()) : "/"
      );
      projectMap.put(
         "projectContent",
         this.projectContentService.getProjectContentStr(project.getId(), "、") != null
            ? this.projectContentService.getProjectContentStr(project.getId(), "、")
            : "/"
      );
      projectMap.put("transportMode", TransportTypeEnum.getNameByType(project.getTransportMode()));
      boolean boolContainEnclosure = (project.getProductCategory() & ProjectContentCategoryEnum.ENCLOSURE.getType()) > 0;
      String enclosureTransportMode = TransportTypeEnum.getNameByType(project.getEnclosureTransportMode());
      projectMap.put("enclosureTransportMode", boolContainEnclosure && enclosureTransportMode != null ? enclosureTransportMode : "/");
      projectMap.put(
         "structureMeasureMode",
         StructureMeasureModeEnum.getNameByType(project.getStructureMeasureMode()) != null
            ? StructureMeasureModeEnum.getNameByType(project.getStructureMeasureMode())
            : "/"
      );
      projectMap.put(
         "enclosureMeasureMode",
         EnclosureMeasureModeEnum.getNameByType(project.getEnclosureMeasureMode()) != null
            ? EnclosureMeasureModeEnum.getNameByType(project.getEnclosureMeasureMode())
            : "/"
      );
      projectMap.put(
         "invoiceType", InvoiceTypeEnum.getNameByType(project.getInvoiceType()) != null ? InvoiceTypeEnum.getNameByType(project.getInvoiceType()) : "/"
      );
      projectMap.put("payType", PayTypeEnum.getNameByType(project.getPayType()) != null ? PayTypeEnum.getNameByType(project.getPayType()) : "/");
      projectMap.put(
         "projectAttribute",
         ProjectAttributeEnum.getNameByType(project.getProjectAttribute()) != null ? ProjectAttributeEnum.getNameByType(project.getProjectAttribute()) : "/"
      );
      String resourcePath = "files/ProjectDownLoadTemplate.xlsx";
      String tempFileName = "ProjectDownLoadTemplate";
      String exportFileName = project.getName() + ".xlsx";
      ClassPathResource resource = new ClassPathResource(resourcePath);
      File file = null;

      try (InputStream inputStream = resource.getInputStream()) {
         file = File.createTempFile(tempFileName, "xlsx");
         FileUtil.copyInputStreamToFile(inputStream, file);
      } catch (IOException e) {
         e.printStackTrace();
      }

      TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath(), true);
      Workbook workbook = ExcelExportUtil.exportExcel(params, projectMap);
      PoiUtils.downLoadExcel(exportFileName, response, workbook);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveContract(ProjectSaveDTOParam saveDTOParam) {
      BaseSaveDTOParam baseRequestVO = saveDTOParam.getBaseRequestVO();
      if (baseRequestVO.getContractType().equals(ContractTypeEnum.REPLENISHMENT_CONTRACT.getType())) {
         Long projectId = baseRequestVO.getProjectId();
         ContractProject project = this.projectService.getById(projectId);
         if (CollectionUtils.isNotEmpty(baseRequestVO.getAttachments())) {
            Set<Long> set = new TreeSet<>(baseRequestVO.getAttachments());
            project.setAttachments(StringUtils.join(set, ","));
         }
      }

      Long pId = baseRequestVO.getPId();
      if (pId != null) {
         ContractProject contractProject = this.projectService.getById(pId);
         Preconditions.checkArgument(contractProject.getPId() == null, "创建子项目时,父项目不可为子项目");
      }

      ContractProject project = this.projectService
         .getOne((Wrapper<ContractProject>)new LambdaQueryWrapper<ContractProject>().eq(ContractProject::getSerialNumber, baseRequestVO.getSerialNumber()));
      Preconditions.checkArgument(project == null, "添加失败,合同编号重复！");
      Long userId = UserUtil.getCurrentUserId();
      project = ContractProject.builder().build();
      project.setLastUpdateTime(LocalDateTime.now());
      project.setLastUpdateUserId(UserUtil.getCurrentUserId());
      if (baseRequestVO.getStartDate() != null && baseRequestVO.getEndDate() != null) {
         Preconditions.checkArgument(!baseRequestVO.getStartDate().isAfter(baseRequestVO.getEndDate()), "计划结束日期不能早于计划开始日期!");
      }

      BranchCompany branchCompany = this.branchCompanyService.getById(baseRequestVO.getContractSignBodyId());
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(branchCompany), "添加失败,签订主体不存在！");
      project.setLevel(branchCompany.getLevel());
      if (baseRequestVO.getBusinessType().equals(ProjectBusinessTypeEnum.PROCESS.getType())) {
         Preconditions.checkArgument(baseRequestVO.getProjectAttribute().equals(ProjectAttributeEnum.SELF_SUPPORT.getType()), "加工承揽项目必须为自营项目");
      }

      if (baseRequestVO.getBusinessType().equals(ProjectBusinessTypeEnum.INSTALL.getType())) {
         Preconditions.checkArgument(
            baseRequestVO.getProjectAttribute().equals(ProjectAttributeEnum.SELF_SUPPORT.getType())
               || baseRequestVO.getProjectAttribute().equals(ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType()),
            "安装合同只能选择自营或者内包制!"
         );
      }

      if (baseRequestVO.getBusinessType().equals(ProjectBusinessTypeEnum.JOB.getType())) {
         Preconditions.checkArgument(branchCompany.getLevel().equals(BranchCompanyLevelEnum.PRIMARY_UNIT.getType()), "项目承包，只能选择一级单位的分支机构");
      }

      BeanUtil.copy(baseRequestVO, project);
      if (baseRequestVO.getStructureStatusName() != null) {
         project.setStructureStatus(this.dictionaryService.getByNameAndValue("structure_status", baseRequestVO.getStructureStatusName()).getId());
      }

      if (baseRequestVO.getPartyTypeName() != null) {
         project.setPartyType(this.dictionaryService.getByNameAndValue("party_type", baseRequestVO.getPartyTypeName()).getId());
      }

      if (baseRequestVO.getSendingModeName() != null) {
         project.setSendingMode(this.dictionaryService.getByNameAndValue("sending_mode", baseRequestVO.getSendingModeName()).getId());
      }

      if (baseRequestVO.getInfoSourceName() != null) {
         project.setInfoSource(this.dictionaryService.getByNameAndValue("info_source", baseRequestVO.getInfoSourceName()).getId());
      }

      if (baseRequestVO.getMarginType() != null) {
         project.setMarginTypeId(this.dictionaryService.getByNameAndValue("margin_type", baseRequestVO.getMarginType()).getId());
      }

      if (baseRequestVO.getCurrencyType() != null) {
         project.setCurrencyType(String.valueOf(this.dictionaryService.getByNameAndValue("currency_type", baseRequestVO.getCurrencyType()).getId()));
      }

      project.setManagementFeeRate(baseRequestVO.getManagementFeeRate() == null ? BigDecimal.ZERO : baseRequestVO.getManagementFeeRate());
      project.setMarginAmount(baseRequestVO.getMarginAmount() == null ? BigDecimal.ZERO : baseRequestVO.getMarginAmount());
      project.setUserId(userId);
      project.setIsEffective(0);
      project.setIsArchive(0);
      project.setAllDays((int)ChronoUnit.DAYS.between(project.getStartDate(), project.getEndDate().plusDays(1L)));
      Preconditions.checkArgument(
         StringUtils.isBlank(baseRequestVO.getProjectManagerPhone())
            || Pattern.matches("((13[0-9])|(14[0-9])|(15[0-9])|(16[0-9])|(17[0-9])|(18[0-9])|(19[0-9]))\\d{8}$", baseRequestVO.getProjectManagerPhone()),
         "项目经理电话号码有误!"
      );
      if (baseRequestVO.getProjectManagerId() != null) {
         User user = this.userService.getById(baseRequestVO.getProjectManagerId());
         Preconditions.checkArgument(user != null, "项目经理不存在!");
         project.setProjectManagerName(user.getName());
         project.setProjectManagerPhone(
            StringUtils.isNotBlank(baseRequestVO.getProjectManagerPhone()) ? baseRequestVO.getProjectManagerPhone() : user.getPhone()
         );
      }

      if (CollectionUtils.isNotEmpty(baseRequestVO.getAttachments())) {
         Set<Long> set = new TreeSet<>(baseRequestVO.getAttachments());
         project.setAttachments(StringUtils.join(set, ","));
      }

      this.ManagementFeeAndMarginCheck(baseRequestVO.getProjectAttribute(), baseRequestVO.getContractAmount(), project);
      if (baseRequestVO.getProjectAttribute().equals(ProjectAttributeEnum.JOINT_VENTURE.getType())) {
         Preconditions.checkArgument(baseRequestVO.getProjectManagerScale() != null, "合营项目，项目经理占比不能为空");
         Preconditions.checkArgument(baseRequestVO.getContractSignBodyScale() != null, "合营项目，签约主体占比不能为空");
         Preconditions.checkArgument(
            baseRequestVO.getProjectManagerScale().add(baseRequestVO.getContractSignBodyScale()).compareTo(BigDecimal.valueOf(100L)) == 0,
            "合营项目，项目经理占比和签约主体占比不能为空"
         );
      }

      if (baseRequestVO.getProjectAttribute().equals(ProjectAttributeEnum.SELF_SUPPORT.getType())) {
         project.setContractSignBodyScale(BigDecimal.valueOf(100L));
         project.setProjectManagerScale(BigDecimal.ZERO);
      }

      if (baseRequestVO.getProjectAttribute().equals(ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType())) {
         project.setContractSignBodyScale(BigDecimal.ZERO);
         project.setProjectManagerScale(BigDecimal.valueOf(100L));
      }

      Preconditions.checkArgument(
         StringUtils.isBlank(baseRequestVO.getSignerPhone())
            || Pattern.matches("((13[0-9])|(14[0-9])|(15[0-9])|(16[0-9])|(17[0-9])|(18[0-9])|(19[0-9]))\\d{8}$", baseRequestVO.getSignerPhone()),
         "销售负责人电话号码有误!"
      );
      if (baseRequestVO.getSignerId() != null) {
         User user = this.userService.getById(baseRequestVO.getSignerId());
         Preconditions.checkArgument(user != null, "销售负责人不存在!");
         project.setSignerName(user.getName());
         project.setSignerPhone(StringUtils.isNotBlank(baseRequestVO.getSignerPhone()) ? baseRequestVO.getSignerPhone() : user.getPhone());
      }

      project.setProductCategory(ProjectContentCategoryEnum.STRUCTURE.getType() | ProjectContentCategoryEnum.ENCLOSURE.getType());
      CustomerSaveDTOParam customerVO = saveDTOParam.getCustomer();
      BeanUtil.copy(customerVO, project);
      this.setProjectRegionInfo(project);
      project.setMode(this.configService.getCurrentProjectMode().getProjectMode());
      project.setStatus(ProjectStatusEnum.PROCESSING.getType());
      FinishedProductWareConfigDTO finishedProductWareConfig = this.configService.getFinishedProductWareConfig();
      project.setBoolRequiredWarehouse(finishedProductWareConfig.getBoolRequiredWarehouse());
      project.setProjectAttribute(project.getProjectAttribute() != null ? project.getProjectAttribute() : ProjectAttributeEnum.SELF_SUPPORT.getType());
      SpringUtil.getBean(ContractProjectService.class).saveWithCache(project);
      Long projectId = project.getId();
      ProjectBranchCompanyLink projectBranchCompanyLink = ProjectBranchCompanyLink.builder()
         .branchCompanyId(branchCompany.getId())
         .branchCompanyLevel(branchCompany.getLevel())
         .projectId(project.getId())
         .build();
      this.projectBranchCompanyLinkService.save(projectBranchCompanyLink);
      if (CollectionUtils.isNotEmpty(saveDTOParam.getUserIdList())) {
         saveDTOParam.getUserIdList().forEach(uid -> {
            ProjectUserLink link = ProjectUserLink.builder().projectId(projectId).userId(uid).build();
            this.projectUserLinkService.save(link);
         });
      }

      ContractProjectRecord record = ContractProjectRecord.builder().projectId(projectId).operationUserId(userId).type(ChangeEnum.ADD.getType()).build();
      this.projectRecordService.save(record);
      this.sysPushFlowConfigBiz
         .triggerFlow(
            NotificationServiceTriggerDTO.builder()
               .projectId(projectId)
               .notificationTypeEnum(NotificationModuleTypeEnum.CREATE_CONTRACT.getNotificationType())
               .contentDetails(this.detailsUtils.getProjectTemplateDetails(project.getSerialNumber(), project.getShortName(), true))
               .projectId(projectId)
               .dataId(projectId)
               .createUserId(UserUtil.getCurrentUserId())
               .userList(new ArrayList<>())
               .build()
         );
      this.sysPushFlowConfigBiz
         .triggerFlow(
            NotificationServiceTriggerDTO.builder()
               .projectId(projectId)
               .notificationTypeEnum(NotificationModuleTypeEnum.LOGISTICS_SETTING.getNotificationType())
               .contentDetails(this.detailsUtils.getLogisticsSettingDetails(project.getSerialNumber(), project.getShortName()))
               .projectId(projectId)
               .dataId(projectId)
               .createUserId(UserUtil.getCurrentUserId())
               .userList(new ArrayList<>())
               .build()
         );
      this.redisUtils.del("simpleProjectList");
      if (MapConstants.getStringConstantsMap().get("ddAccessToken") != null && StringUtils.isNotBlank(this.configProperties.getDdChatid())) {
         String action = "新建项目通知发送失败。";
         SecurityUser currentUser = UserUtil.getCurrentUser();
         String message = this.getSaveProjectMessage(currentUser, saveDTOParam);
         DingDingUtils.sendMessage(
            this.configProperties.getDdChatid(), DingDingMessageTypeEnum.MARKDOWN.getName(), DingDingUtils.getMarkdownMessageJson("新建项目通知", message), action
         );
      }

      return Boolean.TRUE;
   }

   private void setTech(Long projectId, Long userId, BusinessSaveDTOParam saveDTOParam) {
      Map<Integer, MeasureModeDTOParam> measureModeMap = saveDTOParam.getMeasureModeList()
         .stream()
         .collect(Collectors.toMap(MeasureModeDTOParam::getNo, Function.identity(), (s1, s2) -> s2));
      saveDTOParam.getProjectContent()
         .forEach(
            projectContentId -> {
               ContractProjectContent content = this.projectContentService.getById(projectContentId);
               Preconditions.checkArgument(content != null, "项目内容不存在");
               if (!content.getCategoryType().equals(ProjectContentCategoryEnum.AUXILIARY.getType())) {
                  ContractTech tech = ContractTech.builder()
                     .projectId(projectId)
                     .userId(userId)
                     .type(content.getNo())
                     .categoryType(content.getCategoryType())
                     .detailJson("")
                     .build();
                  if (content.getCategoryType().equals(ProjectContentCategoryEnum.STRUCTURE.getType())) {
                     Preconditions.checkArgument(saveDTOParam.getStructureMeasureMode() != null, "工程结算方式不能为空");
                     tech.setMeasureMode(saveDTOParam.getStructureMeasureMode());
                     List<StructureDTOParam> structureDTOParams = saveDTOParam.getStructureSaveRequestVOS();
                     if (CollectionUtils.isNotEmpty(structureDTOParams)) {
                        structureDTOParams.forEach(structureDTOParam -> structureDTOParam.setId(UUIDUtil.getUUID()));
                        tech.setDetailJson(JSON.toJSONString(structureDTOParams));
                     }

                     tech.setQuantityWork(saveDTOParam.getQuantityWork().multiply(new BigDecimal(1000)));
                  }

                  this.contractTechService.save(tech);
               }
            }
         );
   }

   private void setProjectRegionInfo(ContractProject project) {
      if (project.getCountryId() != null) {
         SysCountry country = this.countryService.getById(project.getCountryId());
         project.setCountryName(country != null ? country.getName() : null);
      }

      if (project.getProvinceId() != null) {
         SysProvince province = this.provinceService.getById(project.getProvinceId());
         project.setProvinceName(province != null ? province.getName() : null);
      }

      if (project.getCityId() != null) {
         SysCity city = this.cityService.getById(project.getCityId());
         project.setCityName(city != null ? city.getName() : null);
      }

      if (project.getRegionId() != null) {
         SysRegion region = this.regionService.getById(project.getRegionId());
         project.setRegionName(region != null ? region.getName() : null);
      }

      if (project.getCustomerCountryId() != null) {
         SysCountry country = this.countryService.getById(project.getCustomerCountryId());
         project.setCustomerCountryName(country != null ? country.getName() : null);
      }

      if (project.getCustomerProvinceId() != null) {
         SysProvince province = this.provinceService.getById(project.getCustomerProvinceId());
         project.setCustomerProvinceName(province != null ? province.getName() : null);
      }

      if (project.getCustomerCityId() != null) {
         SysCity city = this.cityService.getById(project.getCustomerCityId());
         project.setCustomerCityName(city != null ? city.getName() : null);
      }

      if (project.getCustomerRegionId() != null) {
         SysRegion region = this.regionService.getById(project.getCustomerRegionId());
         project.setCustomerRegionName(region != null ? region.getName() : null);
      }
   }

   @Override
   public ListVO listByType(Integer type) {
      if (ContractTechTypeEnum.TRUSS_FLOOR_PLATE.getType().equals(type)) {
         Object trussFloorPlate = this.redisUtils.get(ContractTechTypeEnum.getDesByType(type));
         if (trussFloorPlate != null) {
            List<Map<String, Object>> mapList = (List<Map<String, Object>>)trussFloorPlate;
            return new ListVO<>(mapList);
         } else {
            List<SysTrussFloorPlateCodeDTO> codeList = this.enclosureDictionaryService.listCodes(true);
            List<Map<String, Object>> codeMapList = codeList.stream()
               .map(
                  code -> {
                     Map<String, Object> codeMap = BeanUtil.beanToMap(code);
                     List<Map<String, String>> detailMapList = this.enclosureDictionaryService
                        .list(
                           (Wrapper<SysEnclosureDictionary>)((new LambdaQueryWrapper<SysEnclosureDictionary>()
                                    .eq(SysEnclosureDictionary::getType, type))
                                 .eq(SysEnclosureDictionary::getCode, code.getCode()))
                              .orderByAsc(SysEnclosureDictionary::getId)
                        )
                        .stream()
                        .map(s -> {
                           Map<String, String> hashMap = new HashMap<>(8);
                           hashMap.put("name", s.getName());
                           hashMap.put("remark", s.getRemark());
                           hashMap.put("value", s.getLabel());
                           return hashMap;
                        })
                        .collect(Collectors.toList());
                     codeMap.put("list", detailMapList);
                     return codeMap;
                  }
               )
               .collect(Collectors.toList());
            this.redisUtils.set(ContractTechTypeEnum.getDesByType(type), codeMapList);
            return new ListVO<>(codeList);
         }
      } else {
         Object enclosure = this.redisUtils.get(ContractTechTypeEnum.getDesByType(type));
         if (enclosure != null) {
            List<EnclosureDictionaryResponseDTO> responseVOS = (List<EnclosureDictionaryResponseDTO>)enclosure;
            return new ListVO<>(responseVOS);
         }

         List<SysEnclosureDictionarySimpleDTO> enclosureDictionarySimpleDTOS = null;
         if (type.equals(ContractTechTypeEnum.PROFILED_PLATE.getType())) {
            enclosureDictionarySimpleDTOS = SysProfiledPlateEnum.listAll();
         }

         if (type.equals(ContractTechTypeEnum.SANDWICH_BOARD.getType())) {
            enclosureDictionarySimpleDTOS = SysSandwichBoardEnum.listAll();
         }

         if (type.equals(ContractTechTypeEnum.PRESSURE_BEARING_PLATE.getType())) {
            enclosureDictionarySimpleDTOS = SysPressureBearingPlateEnum.listAll();
         }

         Preconditions.checkArgument(enclosureDictionarySimpleDTOS != null, "类型传入错误！");
         List<EnclosureDictionaryResponseDTO> responseDTOList = enclosureDictionarySimpleDTOS.stream()
            .map(
               d -> {
                  EnclosureDictionaryResponseDTO responseDTO = BeanUtil.copy(d, EnclosureDictionaryResponseDTO.class);
                  List<String> stringList = this.enclosureDictionaryService.listByTypeAndName(type, d.getName());
                  responseDTO.setLabels(stringList);
                  if ((type.equals(ContractTechTypeEnum.PROFILED_PLATE.getType()) || type.equals(ContractTechTypeEnum.PRESSURE_BEARING_PLATE.getType()))
                     && d.getName().equals(SysProfiledPlateEnum.PLATE_TYPE.getName())
                     && CollectionUtils.isNotEmpty(stringList)) {
                     List<EnclosureDictionaryDetailDTO> plateTypeList = new ArrayList<>();
                     stringList.forEach(
                        s -> {
                           SysEnclosureDictionary dictionary = this.enclosureDictionaryService
                              .getOne(
                                 Wrappers.lambdaQuery(SysEnclosureDictionary.class)
                                    .eq(SysEnclosureDictionary::getType, type)
                                    .eq(SysEnclosureDictionary::getName, d.getName())
                                    .eq(SysEnclosureDictionary::getLabel, s)
                              );
                           SysEnclosureDictionaryDetail dictionaryDetail = this.enclosureDictionaryDetailService
                              .getOne(
                                 Wrappers.lambdaQuery(SysEnclosureDictionaryDetail.class)
                                    .eq(SysEnclosureDictionaryDetail::getEnclosureDictionaryId, dictionary.getId())
                              );
                           EnclosureDictionaryDetailDTO dictionaryDetailDTO = BeanUtil.copy(dictionaryDetail, EnclosureDictionaryDetailDTO.class);
                           plateTypeList.add(dictionaryDetailDTO);
                        }
                     );
                     responseDTO.setPlateTypeList(plateTypeList);
                  }

                  return responseDTO;
               }
            )
            .collect(Collectors.toList());
         this.redisUtils.set(ContractTechTypeEnum.getDesByType(type), responseDTOList);
         return new ListVO<>(responseDTOList);
      }
   }

   @Override
   public ProjectBaseDTO getContractBaseByProjectId(Long projectId) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在,项目id可能输入有误");
      ProjectBaseDTO responseVO = new ProjectBaseDTO();
      BeanUtil.copy(project, responseVO);
      responseVO.setCurrencyType(StringUtils.isNotEmpty(project.getCurrencyType()) ? Long.valueOf(project.getCurrencyType()) : null);
      Map<Long, SysDictionary> dictionaryMap = this.dictionaryService.list().stream().collect(Collectors.toMap(SysDictionary::getId, Function.identity()));
      if (CollectionUtils.isNotEmpty(dictionaryMap)) {
         if (responseVO.getSendingMode() != null) {
            responseVO.setSendingModeName(dictionaryMap.get(responseVO.getSendingMode()).getLabel());
         }

         if (responseVO.getStructureStatus() != null) {
            responseVO.setStructureStatusName(dictionaryMap.get(responseVO.getStructureStatus()).getLabel());
         }

         if (responseVO.getPartyType() != null) {
            responseVO.setPartyTypeName(dictionaryMap.get(responseVO.getPartyType()).getLabel());
         }

         if (responseVO.getInfoSource() != null) {
            responseVO.setInfoSourceName(dictionaryMap.get(responseVO.getInfoSource()).getLabel());
         }

         if (responseVO.getCurrencyType() != null) {
            responseVO.setCurrencyTypeName(dictionaryMap.get(responseVO.getCurrencyType()).getLabel());
         }
      }

      responseVO.setAllDays(project.getAllDays());
      responseVO.setSalesLeaderId(project.getSalesLeaderId() != null ? project.getSalesLeaderId() : null);
      responseVO.setSalesLeaderName(project.getSalesLeaderId() != null ? this.userService.getNameById(project.getSalesLeaderId()) : "");
      responseVO.setProjectManagerId(project.getProjectManagerId() != null ? project.getProjectManagerId() : null);
      responseVO.setProjectManagerName(project.getProjectManagerId() != null ? this.userService.getNameById(project.getProjectManagerId()) : "");
      responseVO.setRegionalFullName(AddressUtil.getAddress(project, ProjectAddressTypeEnum.PROJECT_ADDRESS.getType()));
      Long contractSignBodyId = project.getContractSignBodyId();
      if (contractSignBodyId != null) {
         BranchCompany branchCompany = this.branchCompanyService.getById(contractSignBodyId);
         responseVO.setCustomerUnit(branchCompany != null ? branchCompany.getName() : "");
      }

      Long signerId = project.getContractSignBodyId();
      if (signerId != null) {
         BranchCompany branchCompany = this.branchCompanyService.getById(signerId);
         responseVO.setCustomerUnit(branchCompany != null ? branchCompany.getName() : "");
      }

      Long deptId = project.getDeptId();
      if (deptId != null) {
         DepartmentDTO department = this.departmentService.getDepartment(deptId);
         responseVO.setDeptName(department != null ? department.getName() : "");
      }

      if (StringUtils.isNotBlank(project.getAttachments())) {
         List<AttachmentDTO> attachmentDTOS = this.attachmentService.listByIds(project.getAttachments());
         attachmentDTOS = attachmentDTOS.stream().filter(p -> p.getType().equals(AttachmentTypeEnum.CONTRACT.getType())).collect(Collectors.toList());
         responseVO.setAttachments(attachmentDTOS);
      }

      return responseVO;
   }

   @Override
   public ProjectBusinessDTO getContractBusinessByProjectId(Long projectId) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在,项目id可能输入有误");
      ProjectBusinessDTO businessDTO = BeanUtil.copy(project, ProjectBusinessDTO.class);
      BranchCompany branchCompany = this.branchCompanyService.getById(project.getContractSignBodyId());
      businessDTO.setContractSignBodyName(branchCompany != null ? branchCompany.getName() : "");
      businessDTO.setSignerName(this.userService.getNameById(project.getSignerId()));
      List<ContractTech> contractTechList = this.contractTechService
         .list(Wrappers.lambdaQuery(ContractTech.class).eq(ContractTech::getProjectId, projectId).orderByAsc(ContractTech::getType));
      Optional<ContractTech> techOptional = contractTechList.stream()
         .filter(tech -> tech.getCategoryType().equals(ProjectContentCategoryEnum.STRUCTURE.getType()))
         .findFirst();
      if (techOptional.isPresent()) {
         ContractTech contractTech = techOptional.get();
         businessDTO.setQuantityWork(contractTech.getQuantityWork().divide(new BigDecimal(1000), 2));
      }

      List<Integer> noList = new ArrayList<>(16);
      int monomerQuantity = this.monomerService.count(Wrappers.lambdaQuery(PlanMonomer.class).eq(PlanMonomer::getProjectId, projectId));
      businessDTO.setMonomerQuantity(monomerQuantity);
      if ((project.getProjectType().equals(ProjectTypeEnum.MES.getType()) || project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType()))
         && monomerQuantity > 0) {
         noList.add(ProjectContentNoEnum.STRUCTURE.getType());
      }

      SysStructureType structureType = this.structureTypeService.getById(project.getStructureTypeId());
      businessDTO.setStructureTypeName(structureType != null ? structureType.getName() : null);
      List<Integer> categoryList = this.enclosurePlanService
         .list(Wrappers.lambdaQuery(EnclosurePlan.builder().projectId(projectId).build()))
         .stream()
         .map(EnclosurePlan::getCategory)
         .distinct()
         .sorted()
         .collect(Collectors.toList());
      noList.addAll(categoryList);
      businessDTO.setProjectContentNoList(noList);
      return businessDTO;
   }

   @Override
   public ProjectBusinessDTO getContractBusinessByProjectIdV2(Long projectId) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在,项目id可能输入有误");
      ProjectBusinessDTO businessDTO = BeanUtil.copy(project, ProjectBusinessDTO.class);
      BranchCompany branchCompany = this.branchCompanyService.getById(project.getContractSignBodyId());
      businessDTO.setContractSignBodyName(branchCompany != null ? branchCompany.getName() : "");
      businessDTO.setProjectContentList(this.projectContentService.listByContentStr(project.getProjectContent()));
      businessDTO.setSignerName(this.userService.getNameById(project.getSignerId()));
      SysStructureType structureType = this.structureTypeService.getById(project.getStructureTypeId());
      businessDTO.setStructureTypeName(structureType != null ? structureType.getName() : null);
      List<ContractTech> contractTechList = this.contractTechService
         .list(Wrappers.lambdaQuery(ContractTech.class).eq(ContractTech::getProjectId, projectId).orderByAsc(ContractTech::getType));
      Optional<ContractTech> techOptional = contractTechList.stream()
         .filter(tech -> tech.getCategoryType().equals(ProjectContentCategoryEnum.STRUCTURE.getType()))
         .findFirst();
      if (techOptional.isPresent()) {
         ContractTech contractTech = techOptional.get();
         businessDTO.setQuantityWork(contractTech.getQuantityWork().divide(new BigDecimal(1000), 2));
      }

      List<Integer> noList = new ArrayList<>(16);
      int monomerQuantity = this.monomerService.count(Wrappers.lambdaQuery(PlanMonomer.class).eq(PlanMonomer::getProjectId, projectId));
      businessDTO.setMonomerQuantity(monomerQuantity);
      if ((project.getProjectType() & 3) > 0 && monomerQuantity > 0) {
         noList.add(ProjectContentNoEnum.STRUCTURE.getType());
      }

      List<Integer> categoryList = this.enclosurePlanService
         .list(Wrappers.lambdaQuery(EnclosurePlan.builder().projectId(projectId).build()))
         .stream()
         .map(EnclosurePlan::getCategory)
         .distinct()
         .sorted()
         .collect(Collectors.toList());
      noList.addAll(categoryList);
      businessDTO.setProjectContentNoList(noList);
      return businessDTO;
   }

   @Override
   public ProjectCustomerDTO getContractCustomerByProjectId(Long projectId) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在,项目id可能输入有误");
      ProjectCustomerDTO customerDTO = BeanUtil.copy(project, ProjectCustomerDTO.class);
      if (customerDTO.getCustomerCountryId() != null) {
         SysCountry country = this.countryService.getById(customerDTO.getCustomerCountryId());
         customerDTO.setCustomerCountryName(country != null ? country.getName() : "");
      }

      if (customerDTO.getCustomerProvinceId() != null) {
         SysProvince province = this.provinceService.getById(customerDTO.getCustomerProvinceId());
         customerDTO.setCustomerProvinceName(province != null ? province.getName() : "");
      }

      if (customerDTO.getCustomerCityId() != null) {
         SysCity city = this.cityService.getById(customerDTO.getCustomerCityId());
         customerDTO.setCustomerCityName(city != null ? city.getName() : "");
      }

      if (customerDTO.getCustomerRegionId() != null) {
         SysRegion region = this.regionService.getById(customerDTO.getCustomerRegionId());
         customerDTO.setCustomerRegionName(region != null ? region.getName() : "");
      }

      return customerDTO;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveLinks(Long projectId, List<Long> userIdList) {
      this.projectService.checkProjectStatus(projectId);
      this.projectUserLinkService.remove((Wrapper<ProjectUserLink>)Wrappers.<ProjectUserLink>lambdaQuery().eq(ProjectUserLink::getProjectId, projectId));
      if (CollectionUtils.isNotEmpty(userIdList)) {
         userIdList.forEach(userId -> {
            User user = this.userService.getById(userId);
            Preconditions.checkArgument(user != null, "添加项目成员失败，员工不存在");
            ProjectUserLink userLink = ProjectUserLink.builder().projectId(projectId).userId(userId).build();
            this.projectUserLinkService.save(userLink);
         });
      }

      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveProjectsLinks(ProjectUserUpdateCollectDTOParam projectUserUpdateCollectDTOParam) {
      List<Long> projectIdList = projectUserUpdateCollectDTOParam.getProjectIds();
      List<Long> userIdList = projectUserUpdateCollectDTOParam.getIds();
      projectIdList.forEach(
         projectId -> {
            this.projectService.checkProjectStatus(projectId);
            if (projectUserUpdateCollectDTOParam.getIsCover()) {
               this.projectUserLinkService.remove((Wrapper<ProjectUserLink>)Wrappers.<ProjectUserLink>lambdaQuery().eq(ProjectUserLink::getProjectId, projectId));
            }

            if (CollectionUtils.isNotEmpty(userIdList)) {
               userIdList.forEach(
                  userId -> {
                     User user = this.userService.getById(userId);
                     Preconditions.checkArgument(user != null, "添加项目成员失败，员工不存在");
                     List<ProjectUserLink> projectUserLinkList = this.projectUserLinkService
                        .list(
                           (Wrapper<ProjectUserLink>)(new LambdaQueryWrapper<ProjectUserLink>().eq(ProjectUserLink::getUserId, userId))
                              .eq(ProjectUserLink::getProjectId, projectId)
                        );
                     if (CollectionUtils.isNotEmpty(projectUserLinkList)) {
                        this.projectUserLinkService.removeByIds(projectUserLinkList.stream().map(ProjectUserLink::getId).collect(Collectors.toList()));
                     }

                     ProjectUserLink userLink = ProjectUserLink.builder().projectId(projectId).userId(userId).build();
                     this.projectUserLinkService.save(userLink);
                  }
               );
            }
         }
      );
      return Boolean.TRUE;
   }

   @Override
   public ListVO<ContractVisaSettlementDTO> listProjectSettleInfo(Integer projectType, Integer businessType, Integer status, Integer settlementStatus) {
      List<Long> projectIds = this.visaService.listProjectIdsWithSettle();
      List<ContractVisaSettlementDTO> collect = this.projectService
         .list(
            Wrappers.lambdaQuery(ContractProject.class)
               .eq(projectType != null, ContractProject::getProjectType, projectType)
               .eq(businessType != null, ContractProject::getBusinessType, businessType)
               .eq(status != null, ContractProject::getStatus, status)
               .eq(settlementStatus != null, ContractProject::getSettlementStatus, settlementStatus)
               .orderByDesc(ContractProject::getId)
         )
         .stream()
         .map(item -> {
            ContractVisaSettlementDTO copy = BeanUtil.copy(item, ContractVisaSettlementDTO.class);
            copy.setProjectContentList(this.projectContentService.listByContentStr(item.getProjectContent()));
            copy.setIsSubmitSettle(projectIds.contains(item.getId()));
            return copy;
         })
         .collect(Collectors.toList());
      return new ListVO<>(collect);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateProjectStatus(Long projectId, Integer status, Boolean isCheckOutFinishStatus) {
      Preconditions.checkArgument(ProjectStatusEnum.isExist(status), "修改状态失败，项目状态传入错误");
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在");
      Preconditions.checkArgument(project.getSettlementStatus().equals(SettlementStatusEnum.UN_SETTLED.getType()), "项目已结算,不可修改项目状态!");
      Long pId = project.getPId();
      if (pId == null && !status.equals(ProjectStatusEnum.PROCESSING.getType()) || status.equals(ProjectStatusEnum.TRUSTEESHIP.getType())) {
         List<ContractProject> contractProjectList = this.projectService
            .list(Wrappers.lambdaQuery(ContractProject.class).eq(ContractProject::getPId, project.getId()));
         if (CollectionUtils.isNotEmpty(contractProjectList)) {
            contractProjectList.forEach(item -> {
               Integer thisStatus = item.getStatus();
               Preconditions.checkArgument(!thisStatus.equals(ProjectStatusEnum.PROCESSING.getType()), "存在进行中的子项目不可修改状态");
            });
         }
      }

      if (status.equals(ProjectStatusEnum.COMPLETED.getType())) {
         Preconditions.checkArgument(!isCheckOutFinishStatus || project.getOutFinishStatus(), "修改状态失败,项目产品未全部出库(安装)完成");
         project.setCompleteDate(LocalDate.now());
      }

      project.setStatus(status);
      SpringUtil.getBean(ContractProjectService.class).updateWithCache(project);
      ChangeInfo changeInfo = ChangeInfo.builder()
         .field("状态")
         .before(ProjectStatusEnum.getNameByType(project.getStatus()))
         .after(ProjectStatusEnum.getNameByType(status))
         .build();
      this.projectRecordService.insert(projectId, UserUtil.getCurrentUserId(), ChangeEnum.MODIFY, Collections.singletonList(changeInfo));
      this.redisUtils.del("simpleProjectList");
      return Boolean.TRUE;
   }

   private String getSaveProjectMessage(SecurityUser user, ProjectSaveDTOParam requestVO) {
      StringBuilder message = new StringBuilder();
      message.append(LocalDate.now().toString()).append(" ").append("来自：");
      if (user.getDepartment() != null) {
         message.append(user.getDepartment().getName()).append("//");
      }

      message.append(user.getName()).append("  立项了《").append(requestVO.getBaseRequestVO().getName()).append("》项目,");
      if (requestVO.getBaseRequestVO().getStartDate() != null && requestVO.getBaseRequestVO().getEndDate() != null) {
         message.append("工期：")
            .append(DateTimeUtil.getBetweenDays(requestVO.getBaseRequestVO().getStartDate(), requestVO.getBaseRequestVO().getEndDate()))
            .append("天，");
      }

      message.append("请各部门知悉并做好准备工作。");
      return message.toString();
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean delete(List<Long> ids) {
      SecurityUser user = UserUtil.getCurrentUser();
      ids.forEach(
         id -> {
            ContractProject project = this.projectService.getById(id);
            Preconditions.checkArgument(project != null, "删除失败,对应的项目不存在!");
            Preconditions.checkArgument(project.getSettlementStatus().equals(SettlementStatusEnum.UN_SETTLED.getType()), "删除失败,项目已结算");
            if (project.getPId() == null) {
               List<ContractProject> contractProjects = this.projectService
                  .list(Wrappers.lambdaQuery(ContractProject.class).eq(ContractProject::getPId, project.getId()));
               Preconditions.checkArgument(CollectionUtils.isEmpty(contractProjects), "删除失败,项目下存在子项目,请先删除子项目");
            }

            int count = this.monomerService.count(Wrappers.lambdaQuery(PlanMonomer.class).eq(PlanMonomer::getProjectId, id));
            Preconditions.checkArgument(count == 0, "删除失败,项目下存在单体,请先删除对应单体!");
            count = this.enclosurePlanService.count(Wrappers.lambdaQuery(EnclosurePlan.builder().projectId(id).build()));
            Preconditions.checkArgument(count == 0, "删除失败,项目下已创建围护计划,请先删除相关计划!");
            count = this.applyPurchaseService.count(Wrappers.lambdaQuery(ApplyPurchase.builder().projectId(id).build()));
            Preconditions.checkArgument(count == 0, "删除失败,该项目已创建物料申购订单!");
            List<PurchaseOrder> purchaseOrderList = this.purchaseOrderService.listByProjectId(id);
            Preconditions.checkArgument(CollectionUtils.isEmpty(purchaseOrderList), "删除失败,该项目已创建物料采购订单!");
            count = this.collectionService
               .count(
                  Wrappers.lambdaQuery(ContractCollection.class)
                     .eq(ContractCollection::getProjectId, id)
                     .ne(ContractCollection::getAuditStatus, AuditStatusEnum.FAILED.getType())
               );
            Preconditions.checkArgument(count == 0, "删除失败,项目存在收款记录");
            count = this.invoiceService
               .count(
                  Wrappers.lambdaQuery(ContractInvoice.class)
                     .eq(ContractInvoice::getProjectId, id)
                     .ne(ContractInvoice::getAuditStatus, AuditStatusEnum.FAILED.getType())
               );
            Preconditions.checkArgument(count == 0, "删除失败,项目存在开票记录");
            List<ContractVisa> contractVisaList = this.visaService
               .list(Wrappers.lambdaQuery(ContractVisa.class).eq(ContractVisa::getProjectId, id).ne(ContractVisa::getStatus, AuditStatusEnum.FAILED.getType()));
            if (CollectionUtils.isNotEmpty(contractVisaList)) {
               List<ContractVisa> visaList = contractVisaList.stream()
                  .filter(v -> v.getType().equals(VisaTypeEnum.VISA.getType()))
                  .collect(Collectors.toList());
               Preconditions.checkArgument(visaList.isEmpty(), "删除失败,项目存在签证申请");
               visaList = contractVisaList.stream().filter(v -> v.getType().equals(VisaTypeEnum.SETTLEMENT.getType())).collect(Collectors.toList());
               Preconditions.checkArgument(visaList.isEmpty(), "删除失败,项目已提交结算申请!");
            }

            this.visaService.remove(Wrappers.lambdaQuery(ContractVisa.builder().projectId(id).status(AuditStatusEnum.FAILED.getType()).build()));
            Preconditions.checkArgument(
               this.materialInventoryService.count((Wrapper<MaterialInventory>)Wrappers.<MaterialInventory>lambdaQuery().eq(MaterialInventory::getProjectId, id)) == 0,
               "删除失败，物料仓中还存在当前项目的物料"
            );
            count = this.outboundService.count(Wrappers.lambdaQuery(Outbound.class).last("AND FIND_IN_SET(" + id + ",project_ids)"));
            Preconditions.checkArgument(count == 0, "删除失败,项目已存在物料出库记录!");
            count = this.inboundService.count(Wrappers.lambdaQuery(Inbound.class).last("AND FIND_IN_SET(" + id + ",project_ids)"));
            Preconditions.checkArgument(count == 0, "删除失败,项目已存在物料入库记录!");
            count = this.transferService.count(Wrappers.lambdaQuery(Transfer.builder().directionProjectId(id).build()));
            Preconditions.checkArgument(count == 0, "删除失败,项目已存在物料调拨记录!");
            String attachments = project.getAttachments();
            List<AttachmentDTO> attachmentDTOS = this.attachmentService.listByIds(attachments);
            List<AttachmentDTO> attachmentDTOStream = attachmentDTOS.stream()
               .filter(p -> p.getType().equals(AttachmentTypeEnum.CONTRACT_ARCHIVES.getType()))
               .collect(Collectors.toList());
            Preconditions.checkArgument(attachmentDTOStream.size() == 0, "删除失败,项目存在归档记录");
            SpringUtil.getBean(ContractProjectService.class).removeById(id);
            this.projectUserLinkService.remove(Wrappers.lambdaQuery(ProjectUserLink.class).eq(ProjectUserLink::getProjectId, id));
            this.contractTechService.remove(Wrappers.lambdaQuery(ContractTech.class).eq(ContractTech::getProjectId, id));
            this.projectRecordService.insert(project.getId(), user.getId(), ChangeEnum.DELETE);
         }
      );
      this.redisUtils.del("simpleProjectList");
      return true;
   }

   @Override
   public List<ProjectSimpleInfoDTO> listAllProjectSimple() {
      List<ContractProject> projectList = this.projectService.list(Wrappers.lambdaQuery(ContractProject.class).orderByDesc(ContractProject::getId));
      Map<Long, List<Integer>> projectEnclosureCategoryMap = this.enclosurePlanService
         .list()
         .stream()
         .collect(Collectors.groupingBy(EnclosurePlan::getProjectId, Collectors.mapping(EnclosurePlan::getCategory, Collectors.toList())));
      List<Long> submitSettleProjectIds = this.contractAuditLedgerService
         .list(
            Wrappers.lambdaQuery(ContractAuditLedger.class)
               .eq(ContractAuditLedger::getPaymentEnum, AuditPaymentEnum.PROJECT_SETTLEMENT.getType())
               .eq(ContractAuditLedger::getAuditStatusEnum, AuditStatusEnum.AUDITING.getType())
         )
         .stream()
         .map(ContractAuditLedger::getProjectId)
         .map(Long::valueOf)
         .collect(Collectors.toList());
      Map<Long, List<PlanArea>> areaMap = new HashMap<>();
      if (CollectionUtils.isNotEmpty(projectList)) {
         List<PlanArea> areas = this.areaService
            .list(Wrappers.lambdaQuery(PlanArea.class).in(PlanArea::getProjectId, projectList.stream().map(e -> e.getId()).collect(Collectors.toList())));
         areaMap = areas.stream().collect(Collectors.groupingBy(PlanArea::getProjectId, Collectors.collectingAndThen(Collectors.toList(), list -> {
            list.sort(Comparator.comparing(BaseEntity::getCreateTime));
            return list;
         })));
      }

      Map<Long, List<PlanArea>> finalAreaMap = areaMap;
      return projectList.stream()
         .map(
            project -> {
               ProjectSimpleInfoDTO simpleInfoDTO = BeanUtil.copy(project, ProjectSimpleInfoDTO.class);
               simpleInfoDTO.setInstallReportMethod(
                  project.getBusinessType().equals(ProjectBusinessTypeEnum.JOB.getType()) ? project.getInstallReportMethod() : null
               );
               if (projectEnclosureCategoryMap.containsKey(project.getId())) {
                  List<Integer> set = projectEnclosureCategoryMap.get(project.getId());
                  simpleInfoDTO.setCategorys(set.stream().distinct().sorted().collect(Collectors.toList()));
               } else {
                  simpleInfoDTO.setCategorys(Collections.emptyList());
               }

               List<PlanArea> areaList = finalAreaMap.get(project.getId());
               if (CollectionUtils.isNotEmpty(areaList)) {
                  areaList = areaList.stream()
                     .filter(
                        s -> s.getProjectPlanProductCategory() != null
                           && s.getProjectPlanProductCategory().equals(ProjectPlanProductCategoryEnum.ENCLOSURE.getType())
                     )
                     .collect(Collectors.toList());
                  if (CollectionUtils.isNotEmpty(areaList)) {
                     simpleInfoDTO.setHasEnclosure(true);
                  } else {
                     simpleInfoDTO.setHasEnclosure(false);
                  }
               } else {
                  simpleInfoDTO.setHasEnclosure(false);
               }

               simpleInfoDTO.setBoolSubmitSettle(submitSettleProjectIds.contains(project.getId()));
               return simpleInfoDTO;
            }
         )
         .collect(Collectors.toList());
   }

   @Override
   public List<ProjectSimpleInfoDTO> listSimpleProjectInfo(
      Integer projectType, Integer businessType, Integer status, Integer settlementStatus, Integer lumpSumSystemType, Integer level
   ) {
      SecurityUser user = UserUtil.getCurrentUser();
      Object simpleProjectList = this.redisUtils.get("simpleProjectList");
      List<ProjectSimpleInfoDTO> projectSimpleList;
      if (simpleProjectList != null) {
         projectSimpleList = (List<ProjectSimpleInfoDTO>)simpleProjectList;
      } else {
         projectSimpleList = this.listAllProjectSimple();
         this.redisUtils.set("simpleProjectList", projectSimpleList);
      }

      Stream<ProjectSimpleInfoDTO> stream = projectSimpleList.stream();
      if (projectType != null) {
         stream = stream.filter(p -> (p.getProjectType() & projectType) > 0);
      }

      if (businessType != null) {
         stream = stream.filter(p -> p.getBusinessType().equals(businessType));
      }

      if (status != null) {
         stream = stream.filter(p -> p.getStatus().equals(status));
      }

      if (settlementStatus != null) {
         stream = stream.filter(p -> p.getSettlementStatus().equals(settlementStatus));
      }

      if (lumpSumSystemType != null) {
         stream = stream.filter(p -> (p.getLumpSumSystemType() & lumpSumSystemType) > 0);
      }

      if (!user.isAdmin()) {
         List<Long> projectIds = this.projectService.listProjectIdByUser(user.getId(), level);
         stream = stream.filter(p -> projectIds.contains(p.getId()));
      }

      return stream.collect(Collectors.toList());
   }

   @Override
   public AppCollectionDTO collectionInfo(Long projectId) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "操作失败，未找到项目");
      List<ContractCollectionDTO> collectionList = this.collectionService
         .listCollection(ContractCollectionQueryDtoParam.builder().projectId(projectId).build());
      List<ContractInvoiceDTO> invoiceList = this.invoiceService.listInvoice(ContractInvoiceQueryDtoParam.builder().projectId(projectId).build());
      AppCollectionDTO dto = AppCollectionDTO.builder()
         .project(ProjectInfo.builder().id(projectId).name(project.getName()).serialNumber(project.getSerialNumber()).shortName(project.getShortName()).build())
         .settlementStatus(project.getSettlementStatus())
         .settlementAmount(project.getSettlementAmount())
         .collectionAmount(project.getCollectionAmount())
         .contractAmount(project.getContractAmount())
         .invoiceAmount(project.getInvoiceAmount())
         .collectionList(collectionList.size() == 0 ? null : collectionList)
         .invoiceList(invoiceList.size() == 0 ? null : invoiceList)
         .accountAge(0)
         .build();
      if (project.getBoolArrears() && project.getSettlementStatus().equals(SettlementStatusEnum.UN_SETTLED.getType()) && invoiceList.size() != 0) {
         ContractInvoiceDTO invoiceDTO = invoiceList.get(invoiceList.size() - 1);
         dto.setAccountAge(DateTimeUtil.getBetweenDays(invoiceDTO.getAuditTime().toLocalDate(), LocalDateTime.now().toLocalDate()));
      }

      return dto;
   }

   @Override
   public ContractProject getById(Long projectId) {
      return this.projectService.getById(projectId);
   }

   @Override
   public List<ContractProject> listAllProjectBstatus() {
      return this.projectService.list(Wrappers.lambdaQuery(ContractProject.class).ne(ContractProject::getStatus, 4));
   }

   @Override
   public ContractProjectInfoDTO getMyProjectInfo(Integer year, Integer projectType, Integer lumpSumSystemType, Integer level) {
      projectType = projectType == null ? ProjectTypeEnum.MES.getType() | ProjectTypeEnum.BRIDGE.getType() : projectType;
      List<ProjectSimpleInfoDTO> projectList = this.projectService.listMyProject(null, null, year, null, projectType, lumpSumSystemType, level);
      long selfSupportQuantity = projectList.stream().filter(p -> p.getProjectAttribute().equals(ProjectAttributeEnum.SELF_SUPPORT.getType())).count();
      long jointVentureQuantity = projectList.stream().filter(p -> p.getProjectAttribute().equals(ProjectAttributeEnum.JOINT_VENTURE.getType())).count();
      long lumpSumSystemQuantity = projectList.stream().filter(p -> p.getProjectAttribute().equals(ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType())).count();
      long annualCompletedProjectsQuantity = projectList.stream().filter(p -> p.getStatus().equals(ProjectStatusEnum.COMPLETED.getType())).count();
      long annualSettledItemsQuantity = projectList.stream().filter(p -> p.getSettlementStatus().equals(1)).count();
      long newItemsThisMonthQuantity = projectList.stream().filter(p -> p.getCreateTime().getMonth().equals(LocalDateTime.now().getMonth())).count();
      long uncreatedPlanQuantity = projectList.stream().filter(p -> {
         Long pId = p.getId();
         return CollectionUtils.isEmpty(this.monomerService.list(Wrappers.lambdaQuery(PlanMonomer.class).eq(PlanMonomer::getProjectId, pId)));
      }).count();
      long uncreatedPersonQuantity = 0L;

      for (ProjectSimpleInfoDTO projectSimpleInfoDTO : projectList) {
         Long projcetId = projectSimpleInfoDTO.getId();
         List<PlanMonomer> planMonomerList = this.monomerService.list(Wrappers.lambdaQuery(PlanMonomer.class).eq(PlanMonomer::getProjectId, projcetId));
         List<MonomerUserLink> planMonomerUserLinkList = this.monomerUserLinkService
            .list(Wrappers.lambdaQuery(MonomerUserLink.class).in(MonomerUserLink::getProjectId, projcetId));
         if (CollectionUtils.isNotEmpty(planMonomerUserLinkList)) {
            List<Long> collect = planMonomerUserLinkList.stream().map(MonomerUserLink::getMonomerId).distinct().collect(Collectors.toList());
            if (collect.size() != planMonomerList.size()) {
               uncreatedPersonQuantity++;
            }
         } else {
            uncreatedPersonQuantity++;
         }
      }

      long processingQuantity = projectList.stream().filter(p -> p.getStatus().equals(ProjectStatusEnum.PROCESSING.getType())).count();
      long completedQuantity = projectList.stream().filter(p -> p.getStatus().equals(ProjectStatusEnum.COMPLETED.getType())).count();
      List<Map<String, Object>> mapList = new ArrayList<>();
      if (CollectionUtils.isNotEmpty(projectList)) {
         Map<Long, List<ProjectSimpleInfoDTO>> listMap = projectList.stream()
            .filter(p -> p.getProvinceId() != null)
            .collect(Collectors.groupingBy(ProjectSimpleInfoDTO::getProvinceId));
         int count = Math.toIntExact(projectList.stream().filter(p -> p.getProvinceId() == null).count());
         if (listMap == null) {
            Map<String, Object> map = new HashMap<>();
            map.put("provinceName", "其他");
            map.put("quantity", projectList.size());
            mapList.add(map);
         } else {
            listMap.forEach((provinceId, projects) -> {
               Map<String, Object> mapx = new HashMap<>();
               SysProvince province = this.provinceService.getById(provinceId);
               mapx.put("provinceName", province.getName());
               mapx.put("quantity", projects.size());
               mapList.add(mapx);
            });
            if (count > 0) {
               Map<String, Object> map = new HashMap<>();
               map.put("provinceName", "其他");
               map.put("quantity", count);
               mapList.add(map);
            }
         }
      }

      if (CollectionUtils.isNotEmpty(mapList)) {
         mapList.sort(Comparator.comparingInt(o -> (Integer)o.get("quantity")));
      }

      return ContractProjectInfoDTO.builder()
         .uncreatedPersonQuantity(Math.toIntExact(uncreatedPersonQuantity))
         .selfSupportQuantity(Math.toIntExact(selfSupportQuantity))
         .jointVentureQuantity(Math.toIntExact(jointVentureQuantity))
         .lumpSumSystemQuantity(Math.toIntExact(lumpSumSystemQuantity))
         .annualCompletedProjectsQuantity(Math.toIntExact(annualCompletedProjectsQuantity))
         .annualSettledItemsQuantity(Math.toIntExact(annualSettledItemsQuantity))
         .newItemsThisMonthQuantity(Math.toIntExact(newItemsThisMonthQuantity))
         .uncreatedPlanQuantity(Math.toIntExact(uncreatedPlanQuantity))
         .quantity(projectList.size())
         .processingQuantity(Math.toIntExact(processingQuantity))
         .completedQuantity(Math.toIntExact(completedQuantity))
         .provinceList(mapList)
         .build();
   }

   @Override
   public PageVO<ProjectSimpleInfoDTO> listMyProjects(
      Integer status,
      Integer settlementStatus,
      Integer year,
      String noName,
      Integer projectType,
      Integer lumpSumSystemType,
      Integer level,
      Integer pageNumber,
      Integer pageSize
   ) {
      if (pageNumber != null && pageSize != null) {
         PageHelper.startPage(pageNumber, pageSize);
      }

      projectType = projectType == null ? ProjectTypeEnum.MES.getType() | ProjectTypeEnum.BRIDGE.getType() : projectType;
      List<ProjectSimpleInfoDTO> projectSimpleInfoDTOS = this.projectService
         .listMyProject(status, settlementStatus, year, noName, projectType, lumpSumSystemType, level);
      projectSimpleInfoDTOS.stream().forEach(p -> {
         Long userId = p.getUserId();
         if (userId != null) {
            p.setCreateName(this.userService.getById(userId).getName());
         }

         if (p.getProjectManagerId() != null) {
            p.setProjectManagerName(this.userService.getById(p.getProjectManagerId()).getName());
         }

         Long pId = p.getId();
         List<PlanMonomer> planMonomerlist = this.monomerService.list(Wrappers.lambdaQuery(PlanMonomer.class).eq(PlanMonomer::getProjectId, pId));
         if (CollectionUtils.isEmpty(planMonomerlist)) {
            p.setHavePlan(0);
         } else {
            p.setHavePlan(1);
         }
      });
      projectSimpleInfoDTOS = projectSimpleInfoDTOS.stream()
         .sorted(Comparator.comparing(ProjectSimpleInfoDTO::getHavePlan).reversed().thenComparing(ProjectSimpleInfoDTO::getCreateTime).reversed())
         .collect(Collectors.toList());
      return new PageVO<>(projectSimpleInfoDTOS);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printMyProjects(
      Integer year, Integer status, Integer settlementStatus, String noName, Integer projectType, Integer lumpSumSystemType, Integer level
   ) {
      List<ProjectSimpleInfoDTO> projectDTOList = this.baseMapper.getProjectPlanListFiltered(
         status, noName, year, UserUtil.getCurrentUser().isAdmin() ? null : UserUtil.getCurrentUserId(), projectType, lumpSumSystemType
      );
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (year != null) {
         header.put("year", year);
      }

      printVO.setHeader(header);

      for (ProjectSimpleInfoDTO projectSimpleInfoDTO : projectDTOList) {
         if (projectSimpleInfoDTO.getStartDate() != null && projectSimpleInfoDTO.getEndDate() != null) {
            projectSimpleInfoDTO.setAlreadyDays((int)ChronoUnit.DAYS.between(projectSimpleInfoDTO.getStartDate(), LocalDate.now().plusDays(1L)));
         }

         projectSimpleInfoDTO.setCompleteDate(projectSimpleInfoDTO.getEndDate());
      }

      printVO.setTable(projectDTOList.stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
      return printVO;
   }

   @Override
   public PageVO<ContractProjectArchivistDTO> isArchivist(ContractProjectIsArchivistParam contractProjectIsArchivistParam, Integer pageNumber, Integer pageSize) {
      Long userId = UserUtil.getCurrentUser().isAdmin() ? null : UserUtil.getCurrentUserId();
      List<Long> projectIds = null;
      if (userId != null) {
         projectIds = this.projectUserLinkService
            .list((Wrapper<ProjectUserLink>)new LambdaQueryWrapper<ProjectUserLink>().eq(ProjectUserLink::getUserId, userId))
            .stream()
            .map(ProjectUserLink::getProjectId)
            .collect(Collectors.toList());
      }

      if (userId != null && CollectionUtils.isEmpty(projectIds)) return new PageVO<>();

      PageHelper.startPage(pageNumber, pageSize);
      List<ContractProject> contractProjects = this.projectService
         .list(
            Wrappers.lambdaQuery(ContractProject.class)
               .and(contractProjectIsArchivistParam.getProjectId() != null, scope -> scope
                  .eq(ContractProject::getId, contractProjectIsArchivistParam.getProjectId()).or()
                  .eq(ContractProject::getPId, contractProjectIsArchivistParam.getProjectId()))
               .eq(contractProjectIsArchivistParam.getIsArchivist() != null, ContractProject::getIsArchive, contractProjectIsArchivistParam.getIsArchivist())
               .in(CollectionUtils.isNotEmpty(projectIds), ContractProject::getId, projectIds)
               .orderByDesc(BaseEntity::getCreateTime)
         );
      List<ContractProjectFilesDTO> contractProjectFilesDTOS = this.getContractProjectFilesDTOS(
         contractProjects, AttachmentTypeEnum.CONTRACT_ARCHIVES.getType()
      );
      List<ContractProjectArchivistDTO> contractProjectArchivistDTOS = new ArrayList<>();

      for (ContractProjectFilesDTO contractProjectFilesDTO : contractProjectFilesDTOS) {
         ContractProjectArchivistDTO contractProjectArchivistDTO = new ContractProjectArchivistDTO();
         Integer contractType = contractProjectFilesDTO.getContractType();
         if (contractType != null && contractType.equals(ContractTypeEnum.MASTER_CONTRACT.getType())) {
            contractProjectArchivistDTO.setContractDefinitionType(ContractDefinitionTypeEnum.CONTRACT.getType());
         }

         if (contractType != null && contractType.equals(ContractTypeEnum.REPLENISHMENT_CONTRACT.getType())
            || contractType.equals(ContractTypeEnum.QUANTITY_ADDITION_CONTRACT.getType())) {
            contractProjectArchivistDTO.setContractDefinitionType(ContractDefinitionTypeEnum.REPLENISHMENT_CONTRACT.getType());
         }

         if (contractType != null && contractType.equals(ContractTypeEnum.PERSONAL_SERVICE_CONTRACT.getType())) {
            contractProjectArchivistDTO.setContractDefinitionType(ContractDefinitionTypeEnum.PERSONAL_SERVICE_CONTRACT.getType());
         }

         contractProjectArchivistDTO.setId(contractProjectFilesDTO.getId());
         contractProjectArchivistDTO.setContractType(null);
         contractProjectArchivistDTO.setSerialNumber(contractProjectFilesDTO.getSerialNumber());
         contractProjectArchivistDTO.setName(contractProjectFilesDTO.getName());
         BranchCompany branchCompany = this.branchCompanyService.getById(contractProjectFilesDTO.getContractSignBodyId());
         contractProjectArchivistDTO.setFirstParty(branchCompany != null && branchCompany.getName() != null ? branchCompany.getName() : null);
         contractProjectArchivistDTO.setContractCreatorName(contractProjectFilesDTO.getContractCreatorName());
         contractProjectArchivistDTO.setContractArchivistName(contractProjectFilesDTO.getContractArchivistName());
         contractProjectArchivistDTO.setEndDate(null);
         contractProjectArchivistDTO.setSecondParty(contractProjectFilesDTO.getCustomerUnit());
         if (contractProjectIsArchivistParam.getIsArchivist().equals(1)) {
            contractProjectArchivistDTO.setImportDate(
               CollectionUtils.isNotEmpty(contractProjectFilesDTO.getAttachmentDTOList())
                  ? contractProjectFilesDTO.getAttachmentDTOList().get(0).getCreateTime()
                  : null
            );
         }

         contractProjectArchivistDTO.setProjectAttachmentDTOList(
            contractProjectFilesDTO.getAttachmentDTOList() != null ? contractProjectFilesDTO.getAttachmentDTOList() : null
         );
         contractProjectArchivistDTOS.add(contractProjectArchivistDTO);
      }

      return new PageVO<>(PageUtils.getPageInfo(contractProjectArchivistDTOS, contractProjects));
   }

   @Override
   public boolean updateProject(ProjectSaveDTOParam projectSaveDTOParam) {
      SecurityUser currentUser = UserUtil.getCurrentUser();
      Preconditions.checkArgument(projectSaveDTOParam != null, "项目信息不能为空");
      ContractProject orderContractProject = this.projectService.getById(projectSaveDTOParam.getBaseRequestVO().getProjectId());
      Preconditions.checkArgument(orderContractProject != null, "项目不存在");
      Preconditions.checkArgument(
         orderContractProject.getContractSignBodyId().equals(projectSaveDTOParam.getBaseRequestVO().getContractSignBodyId()), "签订主体不允许修改"
      );
      ContractProject contractProject = ContractProject.builder().build();
      contractProject.setId(orderContractProject.getId());
      BaseSaveDTOParam baseRequestVO = projectSaveDTOParam.getBaseRequestVO();
      if (orderContractProject.getProjectAttribute().equals(ProjectAttributeEnum.JOINT_VENTURE.getType())
         && (
            !baseRequestVO.getProjectManagerId().equals(orderContractProject.getProjectManagerId())
               || !baseRequestVO.getContractSignBodyId().equals(orderContractProject.getContractSignBodyId())
         )) {
         List<ContractProjectAssetInjection> list = this.assetInjectionService
            .list(Wrappers.lambdaQuery(ContractProjectAssetInjection.class).eq(ContractProjectAssetInjection::getProjectId, orderContractProject.getId()));
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(list), "项目已经创建注资信息，项目经理和签订主体不能修改");
      }

      BeanUtil.copy(baseRequestVO, contractProject);
      if (baseRequestVO.getStartDate() != null && baseRequestVO.getEndDate() != null) {
         Preconditions.checkArgument(!baseRequestVO.getStartDate().isAfter(baseRequestVO.getEndDate()), "计划结束日期不能早于计划开始日期!");
      }

      contractProject.setUserId(orderContractProject.getUserId());
      contractProject.setIsEffective(orderContractProject.getIsEffective());
      contractProject.setIsArchive(orderContractProject.getIsArchive());
      contractProject.setAllDays((int)ChronoUnit.DAYS.between(baseRequestVO.getStartDate(), baseRequestVO.getEndDate().plusDays(1L)));
      contractProject.setSignerId(orderContractProject.getSignerId());
      contractProject.setSignerName(orderContractProject.getSignerName());
      contractProject.setMode(this.configService.getCurrentProjectMode().getProjectMode());
      contractProject.setStatus(ProjectStatusEnum.PROCESSING.getType());
      if (CollectionUtils.isNotEmpty(baseRequestVO.getAttachments())) {
         String attachments = contractProject.getAttachments();
         List<AttachmentDTO> attachmentDTOS = this.attachmentService.listByIds(attachments);
         List<Long> collect = attachmentDTOS.stream()
            .filter(attachmentDTO -> attachmentDTO.getType().equals(AttachmentTypeEnum.CONTRACT_ARCHIVES.getType()))
            .map(AttachmentDTO::getId)
            .collect(Collectors.toList());
         List<Long> saveIds = attachmentDTOS.stream()
            .filter(attdachmentDTO -> attdachmentDTO.getType().equals(AttachmentTypeEnum.CONTRACT.getType()))
            .map(AttachmentDTO::getId)
            .collect(Collectors.toList());
         this.attachmentService.deleteIds(StringUtils.join(saveIds, ","));
         baseRequestVO.getAttachments().addAll(collect);
         Set<Long> set = new TreeSet<>(baseRequestVO.getAttachments());
         contractProject.setAttachments(StringUtils.join(set, ","));
      } else {
         String attachments = contractProject.getAttachments();
         List<AttachmentDTO> attachmentDTOS = this.attachmentService.listByIds(attachments);
         List<Long> saveIds = attachmentDTOS.stream()
            .filter(attdachmentDTO -> attdachmentDTO.getType().equals(AttachmentTypeEnum.CONTRACT.getType()))
            .map(AttachmentDTO::getId)
            .collect(Collectors.toList());
         this.attachmentService.deleteIds(StringUtils.join(saveIds, ","));
      }

      this.ManagementFeeAndMarginCheck(baseRequestVO.getProjectAttribute(), baseRequestVO.getContractAmount(), contractProject);
      CustomerSaveDTOParam customer = projectSaveDTOParam.getCustomer();
      BeanUtil.copy(customer, contractProject);
      this.setProjectRegionInfo(contractProject);
      SpringUtil.getBean(ContractProjectService.class).updateWithCache(contractProject);
      List<Long> userIdList = projectSaveDTOParam.getUserIdList();
      if (CollectionUtils.isNotEmpty(userIdList)) {
         this.projectUserLinkService
            .remove(Wrappers.lambdaQuery(ProjectUserLink.class).eq(ProjectUserLink::getProjectId, projectSaveDTOParam.getBaseRequestVO().getProjectId()));
         userIdList.forEach(userId -> {
            ProjectUserLink projectUserLink = new ProjectUserLink();
            projectUserLink.setProjectId(projectSaveDTOParam.getBaseRequestVO().getProjectId());
            projectUserLink.setUserId(userId);
            this.projectUserLinkService.save(projectUserLink);
         });
      }

      ContractProjectRecord record = ContractProjectRecord.builder()
         .projectId(projectSaveDTOParam.getBaseRequestVO().getProjectId())
         .operationUserId(currentUser.getId())
         .type(ChangeEnum.ADD.getType())
         .build();
      this.projectRecordService.save(record);
      this.redisUtils.del("simpleProjectList");
      return true;
   }

   @Override
   public ProjectDetailsDTO getContractDetailsByProjectId(Long projectId) {
      Preconditions.checkArgument(projectId != null, "项目id不能为空");
      ContractProject contractProject = this.projectService.getById(projectId);
      Preconditions.checkArgument(contractProject != null, "项目不存在");
      ProjectDetailsDTO projectDetailsDTO = new ProjectDetailsDTO();
      BaseSaveDTOParam baseRequestVO = new BaseSaveDTOParam();
      BeanUtil.copy(contractProject, baseRequestVO);
      Map<Long, SysDictionary> dictionaryMap = this.dictionaryService.list().stream().collect(Collectors.toMap(SysDictionary::getId, Function.identity()));
      if (CollectionUtils.isNotEmpty(dictionaryMap)) {
         if (baseRequestVO.getSendingMode() != null) {
            baseRequestVO.setSendingModeName(dictionaryMap.get(baseRequestVO.getSendingMode()).getLabel());
         }

         if (baseRequestVO.getStructureStatus() != null) {
            baseRequestVO.setStructureStatusName(dictionaryMap.get(baseRequestVO.getStructureStatus()).getLabel());
         }

         if (baseRequestVO.getPartyType() != null) {
            baseRequestVO.setPartyTypeName(dictionaryMap.get(baseRequestVO.getPartyType()).getLabel());
         }

         if (baseRequestVO.getInfoSource() != null) {
            baseRequestVO.setInfoSourceName(dictionaryMap.get(baseRequestVO.getInfoSource()).getLabel());
         }

         if (baseRequestVO.getCurrencyType() != null) {
            baseRequestVO.setCurrencyType(dictionaryMap.get(Long.valueOf(baseRequestVO.getCurrencyType())).getValue());
         }
      }

      if (StringUtils.isNotEmpty(contractProject.getAttachments())) {
         List<Long> attachments = Arrays.asList(StringUtils.split(contractProject.getAttachments(), ","))
            .stream()
            .map(Long::valueOf)
            .collect(Collectors.toList());
         baseRequestVO.setAttachmentDTOList(
            this.attachmentService
               .listByIdList(attachments)
               .stream()
               .filter(attachmentDTO -> attachmentDTO.getType().equals(AttachmentTypeEnum.CONTRACT.getType()))
               .collect(Collectors.toList())
         );
      }

      Long deptId = contractProject.getDeptId();
      if (deptId != null) {
         Department department = this.departmentService.getById(deptId);
         baseRequestVO.setDeptName(department != null ? department.getName() : null);
      }

      baseRequestVO.setProjectId(contractProject.getId());
      List<PlanMonomer> list = this.monomerService.list(Wrappers.lambdaQuery(PlanMonomer.class).eq(PlanMonomer::getProjectId, contractProject.getId()));
      if (CollectionUtils.isNotEmpty(list)) {
         baseRequestVO.setHaveMonomer(1);
      } else {
         baseRequestVO.setHaveMonomer(0);
      }

      projectDetailsDTO.setBaseRequestVO(baseRequestVO);
      CustomerSaveDTOParam customer = new CustomerSaveDTOParam();
      BeanUtil.copy(contractProject, customer);
      projectDetailsDTO.setCustomer(customer);
      List<ProjectUserLink> projectUserLinkList = this.projectUserLinkService
         .list(Wrappers.lambdaQuery(ProjectUserLink.class).eq(ProjectUserLink::getProjectId, projectId));
      if (projectUserLinkList != null) {
         List<Long> userIdList = projectUserLinkList.stream().map(ProjectUserLink::getUserId).collect(Collectors.toList());
         projectDetailsDTO.setUserIdList(userIdList);
      }

      return projectDetailsDTO;
   }

   @Override
   public String getSerialNumber(Integer projectId) {
      ContractProject contractProject = this.projectService.getById(projectId);
      Preconditions.checkArgument(contractProject != null, "项目不存在");
      String serialNumber = contractProject.getSerialNumber();
      List<ContractProject> contractProjects = this.projectService.list(Wrappers.lambdaQuery(ContractProject.class).eq(ContractProject::getPId, projectId));
      if (CollectionUtils.isEmpty(contractProjects)) {
         StringBuilder newSerialNumber = new StringBuilder();
         newSerialNumber.append(serialNumber);
         newSerialNumber.append("-");
         newSerialNumber.append("1");
         return newSerialNumber.toString();
      }

      List<String> serialNumberList = contractProjects.stream().map(ContractProject::getSerialNumber).collect(Collectors.toList());
      List<String> numberList = new ArrayList<>();
      serialNumberList.forEach(p -> {
         String[] split = p.split("-");
         if (split.length > 1) {
            String s = split[split.length - 1];
            numberList.add(s);
         }
      });
      int max = 0;
      if (CollectionUtils.isNotEmpty(numberList)) {
         for (String number : numberList) {
            int i = Integer.parseInt(number);
            if (i > max) {
               max = i;
            }
         }

         max++;
         StringBuilder newSerialNumber = new StringBuilder();
         newSerialNumber.append(serialNumber);
         newSerialNumber.append("-");
         newSerialNumber.append(max);
         return newSerialNumber.toString();
      } else {
         return null;
      }
   }

   private ContractProject checkArchiveProjectAccess(Long projectId) {
      Preconditions.checkArgument(projectId != null, "项目id不能为空");
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在");
      Preconditions.checkArgument(UserUtil.getCurrentUser().isAdmin() || this.projectUserLinkService.count(
         Wrappers.lambdaQuery(ProjectUserLink.class).eq(ProjectUserLink::getProjectId, projectId)
            .eq(ProjectUserLink::getUserId, UserUtil.getCurrentUserId())) > 0, "无权限访问该项目档案");
      return project;
   }

   @Override
   public Integer getUnArchived() {
      Long userId = UserUtil.getCurrentUser().isAdmin() ? null : UserUtil.getCurrentUserId();
      List<Long> projectIds = null;
      if (userId != null) {
         projectIds = this.projectUserLinkService
            .list((Wrapper<ProjectUserLink>)new LambdaQueryWrapper<ProjectUserLink>().eq(ProjectUserLink::getUserId, userId))
            .stream()
            .map(ProjectUserLink::getProjectId)
            .collect(Collectors.toList());
      }

      if (userId != null && CollectionUtils.isEmpty(projectIds)) return 0;

      List<ContractProject> list = this.projectService
         .list(new LambdaQueryWrapper<ContractProject>().in(CollectionUtils.isNotEmpty(projectIds), ContractProject::getId, projectIds));
      int unArchivedcount = 0;

      for (ContractProject contractProject : list) {
         String attachments = contractProject.getAttachments();
         List<AttachmentDTO> attachmentDTOS = this.attachmentService.listByIds(attachments);
         long count = attachmentDTOS.stream().filter(p -> p.getType().equals(AttachmentTypeEnum.CONTRACT_ARCHIVES.getType())).count();
         if (count < 1L) {
            unArchivedcount++;
         }
      }

      return unArchivedcount;
   }

   @Override
   public void bulkDownloadAttachment(List<Long> projectIds) {
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(projectIds), "请选择项目档案");
      projectIds.forEach(this::checkArchiveProjectAccess);
      try {
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(projectIds), "项目id不能为空");
         List<ContractProject> contractProjects = this.projectService.listByIds(projectIds);
         String dirName = contractProjects.get(0).getShortName() + "归档文件";
         FileUtil.mkdirs(this.configProperties.getFilePath() + dirName);

         for (ContractProject contractProject : contractProjects) {
            String attachments = contractProject.getAttachments();
            Preconditions.checkArgument(StringUtils.isNotBlank(attachments), "合同档案不存在");
            String[] split = attachments.split(",");
            Preconditions.checkArgument(split.length > 0, "合同档案不存在");

            for (String s : split) {
               Integer attachmentId = Integer.valueOf(s);
               Attachment attachment = this.attachmentService.getById(attachmentId);
               if (attachment.getType().equals(AttachmentTypeEnum.CONTRACT_ARCHIVES.getType())) {
                  String filePath = this.configProperties.getFilePath() + attachment.getRelativePath();
                  String targetFileName = attachment.getName();
                  String targetFilePath = this.configProperties.getFilePath() + dirName + File.separator + targetFileName;

                  for (int count = 1; Files.exists(Paths.get(targetFilePath)); count++) {
                     String extension = "";
                     int dotIndex = targetFileName.lastIndexOf(".");
                     if (dotIndex != -1) {
                        extension = targetFileName.substring(dotIndex);
                        targetFileName = targetFileName.substring(0, dotIndex);
                     }

                     targetFileName = targetFileName + "_" + count + extension;
                     targetFilePath = this.configProperties.getFilePath() + dirName + File.separator + targetFileName;
                  }

                  Files.copy(Paths.get(filePath), Paths.get(targetFilePath));
               }
            }
         }

         ZIPUtils.toZip(this.configProperties.getFilePath() + dirName + ".zip", this.configProperties.getFilePath() + dirName, true);
         FileUtil.downloadFile(this.configProperties.getFilePath() + dirName + ".zip");
         FileUtil.deleteDir(this.configProperties.getFilePath() + dirName);
         FileUtil.deleteFile(this.configProperties.getFilePath() + dirName + ".zip");
      } catch (Throwable $ex) {
         throw ContractProjectBizImpl.<RuntimeException>rethrow($ex);
      }
   }

   @Override
   public Boolean bulkDownloadAttachmentNew(Map<Long, List<Long>> projectIdsMap) throws IOException {
      Preconditions.checkArgument(projectIdsMap != null && !projectIdsMap.isEmpty(), "请选择项目档案");
      for (Map.Entry<Long, List<Long>> entry : projectIdsMap.entrySet()) {
         this.checkArchiveProjectAccess(entry.getKey());
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(entry.getValue()), "请选择项目档案");
         for (Long selectedId : entry.getValue()) {
            ContractProject selected = this.checkArchiveProjectAccess(selectedId);
            Preconditions.checkArgument(Objects.equals(selected.getId(), entry.getKey())
               || Objects.equals(selected.getPId(), entry.getKey()), "档案不属于所选主合同");
         }
      }
      String dirName = "合同文档";
      String filePath1 = this.configProperties.getFilePath();
      FileUtil.mkdirs(filePath1 + dirName);

      for (Long l : projectIdsMap.keySet()) {
         List<Long> projectIds = projectIdsMap.get(l);
         ContractProject byId = this.projectService.getById(l);
         String shortName = byId.getShortName();
         String dirNameTwo = filePath1 + dirName + File.separator + shortName;
         FileUtil.mkdirs(dirNameTwo);

         for (ContractProject contractProject : this.projectService.listByIds(projectIds)) {
            String attachments = contractProject.getAttachments();
            if (!StringUtils.isEmpty(attachments)) {
               String[] split = attachments.split(",");
               if (split.length > 0) {
                  for (String s : split) {
                     Integer attachmentId = Integer.valueOf(s);
                     Attachment attachment = this.attachmentService.getById(attachmentId);
                     if (attachment.getType().equals(AttachmentTypeEnum.CONTRACT_ARCHIVES.getType())) {
                        String filePath = filePath1 + attachment.getRelativePath();
                        String targetFileName = attachment.getName();
                        String targetFilePath = dirNameTwo + File.separator + targetFileName;

                        for (int count = 1; Files.exists(Paths.get(targetFilePath)); count++) {
                           String extension = "";
                           int dotIndex = targetFileName.lastIndexOf(".");
                           if (dotIndex != -1) {
                              extension = targetFileName.substring(dotIndex);
                              targetFileName = targetFileName.substring(0, dotIndex);
                           }

                           targetFileName = targetFileName + "_" + count + extension;
                           targetFilePath = dirNameTwo + File.separator + targetFileName;
                        }

                        Files.copy(Paths.get(filePath), Paths.get(targetFilePath));
                     }
                  }
               }
            }
         }
      }

      ZIPUtils.toZip(filePath1 + dirName + ".zip", this.configProperties.getFilePath() + dirName, true);
      FileUtil.downloadFile(filePath1 + dirName + ".zip");
      FileUtils.deleteDirectory(new File(filePath1 + dirName));
      FileUtil.deleteDir(filePath1 + dirName + ".zip");
      return true;
   }

   @Transactional
   @Override
   public boolean appendAttachment(AppendAttachmentDTO attachmentDTO) {
      ContractProject contractProject = this.checkArchiveProjectAccess(attachmentDTO.getProjectId());
      if (CollectionUtils.isNotEmpty(attachmentDTO.getFileIds())) {
         Preconditions.checkArgument(attachmentDTO.getFileIds().stream().allMatch(Objects::nonNull), "归档附件不存在");
         Set<Long> requestedIds = new HashSet<>(attachmentDTO.getFileIds());
         List<AttachmentDTO> requested = this.attachmentService.listByIds(StringUtils.join(requestedIds, ","));
         Preconditions.checkArgument(requested.size() == requestedIds.size(), "归档附件不存在");
         Preconditions.checkArgument(requested.stream().allMatch(file -> Objects.equals(file.getType(), AttachmentTypeEnum.CONTRACT_ARCHIVES.getType())),
            "请选择合同归档附件");
         String attachments = contractProject.getAttachments();
         if (StringUtils.isNotEmpty(attachments)) {
            List<Long> attIds = this.attachmentService
               .listByIdsAndType(attachments, AttachmentTypeEnum.CONTRACT.getType())
               .stream()
               .map(AttachmentDTO::getId)
               .collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(attIds)) {
               attachmentDTO.getFileIds().addAll(attIds);
            }
         }

         Set<Long> set = new TreeSet<>(attachmentDTO.getFileIds());
         contractProject.setAttachments(StringUtils.join(set, ","));
         contractProject.setIsArchive(1);
      } else {
         String attachments = contractProject.getAttachments();
         List<Long> collect = this.attachmentService
            .listByIdsAndType(attachments, AttachmentTypeEnum.CONTRACT_ARCHIVES.getType())
            .stream()
            .map(AttachmentDTO::getId)
            .collect(Collectors.toList());
         this.attachmentService.deleteIds(StringUtils.join(collect, ","));
         Set<Long> set = this.attachmentService
            .listByIdsAndType(attachments, AttachmentTypeEnum.CONTRACT.getType())
            .stream()
            .map(AttachmentDTO::getId)
            .collect(Collectors.toCollection(TreeSet::new));
         contractProject.setAttachments(StringUtils.join(set, ","));
         contractProject.setIsArchive(0);
      }

      this.projectService.updateById(contractProject);
      return true;
   }

   @Override
   public List<ContractProject> projectWageEstimateProjectList(Integer year, Integer status, String serialNumberOrShortName) {
      return this.projectService
         .list(
            Wrappers.lambdaQuery(ContractProject.class)
               .apply("YEAR(create_time) = {0}", year)
               .eq(ContractProject::getStatus, status)
               .and(
                  StrUtil.isNotBlank(serialNumberOrShortName),
                  a -> {
                     LambdaQueryWrapper var10000 = a.like(ContractProject::getSerialNumber, serialNumberOrShortName)
                        .or()
                        .like(ContractProject::getShortName, serialNumberOrShortName);
                  }
               )
         );
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean addContract(ProjectSaveDTOParam saveDTOParam) {
      BaseSaveDTOParam baseRequestVO = saveDTOParam.getBaseRequestVO();
      Map<Long, BranchCompany> branchCompanyMap = this.branchCompanyService
         .list()
         .stream()
         .collect(Collectors.toMap(BranchCompany::getId, Function.identity()));
      Long pId = baseRequestVO.getPId();
      if (pId != null) {
         ContractProject contractProject = this.projectService.getById(pId);
         Preconditions.checkArgument(contractProject.getPId() == null, "创建子项目时,父项目不可为子项目");
      }

      ContractProject project = this.projectService
         .getOne((Wrapper<ContractProject>)new LambdaQueryWrapper<ContractProject>().eq(ContractProject::getSerialNumber, baseRequestVO.getSerialNumber()));
      Preconditions.checkArgument(project == null, "添加失败,合同编号重复！");
      Long userId = UserUtil.getCurrentUserId();
      BranchCompany company = this.branchCompanyService.getById(baseRequestVO.getContractSignBodyId());
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(company), "添加失败,签订主体不存在！");
      project = ContractProject.builder().build();
      project.setLevel(company.getLevel());
      if (baseRequestVO.getBusinessType().equals(ProjectBusinessTypeEnum.PROCESS.getType())) {
         Preconditions.checkArgument(baseRequestVO.getProjectAttribute().equals(ProjectAttributeEnum.SELF_SUPPORT.getType()), "加工承揽项目必须为自营项目");
      }

      if (baseRequestVO.getBusinessType().equals(ProjectBusinessTypeEnum.INSTALL.getType())) {
         Preconditions.checkArgument(
            baseRequestVO.getProjectAttribute().equals(ProjectAttributeEnum.SELF_SUPPORT.getType())
               || baseRequestVO.getProjectAttribute().equals(ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType()),
            "安装合同只能选择自营或者内包制!"
         );
      }

      if (baseRequestVO.getBusinessType().equals(ProjectBusinessTypeEnum.JOB.getType())) {
         Preconditions.checkArgument(branchCompanyMap.get(baseRequestVO.getContractSignBodyId()).getLevel().equals(1), "项目承包，只能选择一级单位的分支机构");
      }

      if (baseRequestVO.getStartDate() != null && baseRequestVO.getEndDate() != null) {
         Preconditions.checkArgument(!baseRequestVO.getStartDate().isAfter(baseRequestVO.getEndDate()), "计划结束日期不能早于计划开始日期!");
      }

      BeanUtil.copy(baseRequestVO, project);
      this.ManagementFeeAndMarginCheck(baseRequestVO.getProjectAttribute(), baseRequestVO.getContractAmount(), project);
      if (baseRequestVO.getProjectAttribute().equals(ProjectAttributeEnum.JOINT_VENTURE.getType())) {
         Preconditions.checkArgument(baseRequestVO.getProjectManagerScale() != null, "合营项目，项目经理占比不能为空");
         Preconditions.checkArgument(baseRequestVO.getContractSignBodyScale() != null, "合营项目，签约主体占比不能为空");
         Preconditions.checkArgument(
            baseRequestVO.getProjectManagerScale().add(baseRequestVO.getContractSignBodyScale()).compareTo(BigDecimal.valueOf(100L)) == 0,
            "合营项目，项目经理占比和签约主体占比不能为空"
         );
      }

      if (baseRequestVO.getProjectAttribute().equals(ProjectAttributeEnum.SELF_SUPPORT.getType())) {
         project.setContractSignBodyScale(BigDecimal.valueOf(100L));
         project.setProjectManagerScale(BigDecimal.ZERO);
      }

      if (baseRequestVO.getProjectAttribute().equals(ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType())) {
         project.setContractSignBodyScale(BigDecimal.ZERO);
         project.setProjectManagerScale(BigDecimal.valueOf(100L));
      }

      project.setUserId(userId);
      project.setIsEffective(0);
      project.setIsArchive(0);
      project.setAllDays((int)ChronoUnit.DAYS.between(project.getStartDate(), project.getEndDate().plusDays(1L)));
      if (CollectionUtils.isNotEmpty(baseRequestVO.getAttachments())) {
         Set<Long> set = new TreeSet<>(baseRequestVO.getAttachments());
         project.setAttachments(StringUtils.join(set, ","));
      }

      project.setSignerId(UserUtil.getCurrentUserId());
      project.setSignerName(UserUtil.getCurrentUser().getName());
      CustomerSaveDTOParam customerVO = saveDTOParam.getCustomer();
      BeanUtil.copy(customerVO, project);
      this.setProjectRegionInfo(project);
      project.setMode(this.configService.getCurrentProjectMode().getProjectMode());
      project.setStatus(ProjectStatusEnum.PROCESSING.getType());
      SpringUtil.getBean(ContractProjectService.class).saveWithCache(project);
      Long projectId = project.getId();
      ProjectBranchCompanyLink projectBranchCompanyLink = ProjectBranchCompanyLink.builder()
         .branchCompanyId(company.getId())
         .branchCompanyLevel(company.getLevel())
         .projectId(project.getId())
         .build();
      this.projectBranchCompanyLinkService.save(projectBranchCompanyLink);
      if (CollectionUtils.isNotEmpty(saveDTOParam.getUserIdList())) {
         saveDTOParam.getUserIdList().forEach(uid -> {
            ProjectUserLink link = ProjectUserLink.builder().projectId(projectId).userId(uid).build();
            this.projectUserLinkService.save(link);
         });
      }

      ContractProjectRecord record = ContractProjectRecord.builder().projectId(projectId).operationUserId(userId).type(ChangeEnum.ADD.getType()).build();
      this.projectRecordService.save(record);
      this.redisUtils.del("simpleProjectList");
      if (MapConstants.getStringConstantsMap().get("ddAccessToken") != null && StringUtils.isNotBlank(this.configProperties.getDdChatid())) {
         String action = "新建项目通知发送失败。";
         SecurityUser currentUser = UserUtil.getCurrentUser();
         String message = this.getSaveProjectMessage(currentUser, saveDTOParam);
         DingDingUtils.sendMessage(
            this.configProperties.getDdChatid(), DingDingMessageTypeEnum.MARKDOWN.getName(), DingDingUtils.getMarkdownMessageJson("新建项目通知", message), action
         );
      }

      return Boolean.TRUE;
   }

   private void ManagementFeeAndMarginCheck(Integer projectAttribute, BigDecimal contractAmount, ContractProject project) {
      if (projectAttribute.equals(ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType()) || projectAttribute.equals(ProjectAttributeEnum.JOINT_VENTURE.getType())) {
         ContractManagementCost cost = this.contractManagementCostService
            .getOne(
               Wrappers.lambdaQuery(ContractManagementCost.class)
                  .apply("amount_min < {0}", contractAmount)
                  .apply("amount_max >= {0}", contractAmount)
                  .eq(ContractManagementCost::getProjectAttribute, projectAttribute)
                  .eq(ContractManagementCost::getStatus, 0)
                  .isNull(ContractManagementCost::getProjectId)
            );
         Preconditions.checkArgument(cost != null, "当前项目的合同金额为" + contractAmount + "，请前往合同管理配置中为该金额创建管理费");
         project.setManagementFeeRate(cost.getCashDeposit());
         ContractEarnestMoney earnestMoney = this.earnestMoneyService
            .getOne(
               Wrappers.lambdaQuery(ContractEarnestMoney.class)
                  .apply("amount_min < {0}", contractAmount)
                  .apply("amount_max >= {0}", contractAmount)
                  .eq(ContractEarnestMoney::getStatus, 0)
                  .eq(ContractEarnestMoney::getProjectAttribute, projectAttribute)
            );
         Preconditions.checkArgument(earnestMoney != null, "当前项目的合同金额为" + contractAmount + "，请前往合同管理配置中为该金额创建保证金");
         project.setMarginAmount(earnestMoney.getCashDeposit());
         project.setManagementCostId(cost.getId());
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public boolean putProject(ProjectSaveDTOParam projectSaveDTOParam) {
      SecurityUser currentUser = UserUtil.getCurrentUser();
      Preconditions.checkArgument(projectSaveDTOParam != null, "项目信息不能为空");
      ContractProject project = this.projectService.getById(projectSaveDTOParam.getBaseRequestVO().getProjectId());
      Preconditions.checkArgument(project != null, "项目不存在");
      ContractProject contractProject = ContractProject.builder().build();
      contractProject.setId(project.getId());
      BaseSaveDTOParam baseRequestVO = projectSaveDTOParam.getBaseRequestVO();
      BeanUtil.copy(baseRequestVO, contractProject);
      if (baseRequestVO.getStartDate() != null && baseRequestVO.getEndDate() != null) {
         Preconditions.checkArgument(!baseRequestVO.getStartDate().isAfter(baseRequestVO.getEndDate()), "计划结束日期不能早于计划开始日期!");
      }

      if (baseRequestVO.getStructureStatusName() != null) {
         contractProject.setStructureStatus(this.dictionaryService.getByNameAndValue("structure_status", baseRequestVO.getStructureStatusName()).getId());
      }

      if (baseRequestVO.getPartyTypeName() != null) {
         contractProject.setPartyType(this.dictionaryService.getByNameAndValue("party_type", baseRequestVO.getPartyTypeName()).getId());
      }

      if (baseRequestVO.getSendingModeName() != null) {
         contractProject.setSendingMode(this.dictionaryService.getByNameAndValue("sending_mode", baseRequestVO.getSendingModeName()).getId());
      }

      if (baseRequestVO.getInfoSourceName() != null) {
         contractProject.setInfoSource(this.dictionaryService.getByNameAndValue("info_source", baseRequestVO.getInfoSourceName()).getId());
      }

      if (baseRequestVO.getMarginType() != null) {
         contractProject.setMarginTypeId(this.dictionaryService.getByNameAndValue("margin_type", baseRequestVO.getMarginType()).getId());
      }

      if (baseRequestVO.getCurrencyType() != null) {
         contractProject.setCurrencyType(String.valueOf(this.dictionaryService.getByNameAndValue("currency_type", baseRequestVO.getCurrencyType()).getId()));
      }

      contractProject.setUserId(project.getUserId());
      contractProject.setIsEffective(project.getIsEffective());
      contractProject.setIsArchive(project.getIsArchive());
      contractProject.setAllDays((int)ChronoUnit.DAYS.between(baseRequestVO.getStartDate(), baseRequestVO.getEndDate().plusDays(1L)));
      contractProject.setSignerId(project.getSignerId());
      contractProject.setSignerName(project.getSignerName());
      contractProject.setMode(this.configService.getCurrentProjectMode().getProjectMode());
      contractProject.setStatus(ProjectStatusEnum.PROCESSING.getType());
      if (CollectionUtils.isNotEmpty(baseRequestVO.getAttachments())) {
         String attachments = contractProject.getAttachments();
         List<AttachmentDTO> attachmentDTOS = this.attachmentService.listByIds(attachments);
         List<Long> collect = attachmentDTOS.stream()
            .filter(attachmentDTO -> attachmentDTO.getType().equals(AttachmentTypeEnum.CONTRACT_ARCHIVES.getType()))
            .map(AttachmentDTO::getId)
            .collect(Collectors.toList());
         List<Long> saveIds = attachmentDTOS.stream()
            .filter(attdachmentDTO -> attdachmentDTO.getType().equals(AttachmentTypeEnum.CONTRACT.getType()))
            .map(AttachmentDTO::getId)
            .collect(Collectors.toList());
         this.attachmentService.deleteIds(StringUtils.join(saveIds, ","));
         baseRequestVO.getAttachments().addAll(collect);
         Set<Long> set = new TreeSet<>(baseRequestVO.getAttachments());
         contractProject.setAttachments(StringUtils.join(set, ","));
      } else {
         String attachments = contractProject.getAttachments();
         List<AttachmentDTO> attachmentDTOS = this.attachmentService.listByIds(attachments);
         List<Long> saveIds = attachmentDTOS.stream()
            .filter(attdachmentDTO -> attdachmentDTO.getType().equals(AttachmentTypeEnum.CONTRACT.getType()))
            .map(AttachmentDTO::getId)
            .collect(Collectors.toList());
         this.attachmentService.deleteIds(StringUtils.join(saveIds, ","));
      }

      CustomerSaveDTOParam customer = projectSaveDTOParam.getCustomer();
      BeanUtil.copy(customer, contractProject);
      this.setProjectRegionInfo(contractProject);
      this.projectAttributeCheck(projectSaveDTOParam, contractProject);
      SpringUtil.getBean(ContractProjectService.class).updateWithCache(contractProject);
      List<Long> userIdList = projectSaveDTOParam.getUserIdList();
      if (CollectionUtils.isNotEmpty(userIdList)) {
         this.projectUserLinkService
            .remove(Wrappers.lambdaQuery(ProjectUserLink.class).eq(ProjectUserLink::getProjectId, projectSaveDTOParam.getBaseRequestVO().getProjectId()));
         userIdList.forEach(userId -> {
            ProjectUserLink projectUserLink = new ProjectUserLink();
            projectUserLink.setProjectId(projectSaveDTOParam.getBaseRequestVO().getProjectId());
            projectUserLink.setUserId(userId);
            this.projectUserLinkService.save(projectUserLink);
         });
      }

      ContractProjectRecord record = ContractProjectRecord.builder()
         .projectId(projectSaveDTOParam.getBaseRequestVO().getProjectId())
         .operationUserId(currentUser.getId())
         .type(ChangeEnum.ADD.getType())
         .build();
      this.projectRecordService.save(record);
      this.redisUtils.del("simpleProjectList");
      return true;
   }

   @Override
   public ProjectSupplierDto getProjectProcurement(Long projectId, Long orderId) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在");
      PurchaseOrder purchaseOrder = this.purchaseOrderService.getById(orderId);
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(purchaseOrder), "采购合同不存在");
      ProjectSupplierDto supplierDto = this.getProjectSupplierDto(project);
      supplierDto.setBasicClass(purchaseOrder.getBasicClass());
      return supplierDto;
   }

   @Override
   public ProjectSupplierDto getProjectSupplierDto(ContractProject project) {
      Map<Long, BranchCompany> branchCompanyMap = this.branchCompanyService
         .list()
         .stream()
         .collect(Collectors.toMap(BranchCompany::getId, Function.identity()));
      ContractGivingCredit givingCredit = this.contractGivingCreditService
         .getOne(
            Wrappers.lambdaQuery(ContractGivingCredit.class)
               .eq(ContractGivingCredit::getAccreditingPartyId, project.getProjectManagerId())
               .eq(ContractGivingCredit::getProjectId, project.getId())
               .eq(ContractGivingCredit::getStatus, 0)
         );
      List<SupplierPayment> paymentList = this.supplierPaymentService
         .list(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .eq(SupplierPayment::getProjectId, project.getId())
               .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         );
      BigDecimal projectSupplierAmount = paymentList.stream()
         .map(SupplierPayment::getActuallyPaymentAmount)
         .filter(ObjectUtils::isNotEmpty)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      List<SecurityDepositAndManagementCost> costList = this.securityDepositAndManagementCostService
         .list(Wrappers.lambdaQuery(SecurityDepositAndManagementCost.class).eq(SecurityDepositAndManagementCost::getProjectId, project.getId()));
      if (CollectionUtils.isNotEmpty(costList)) {
         Map<Integer, Map<Integer, BigDecimal>> listMap = costList.stream()
            .collect(
               Collectors.groupingBy(
                  SecurityDepositAndManagementCost::getAmountType,
                  Collectors.groupingBy(
                     SecurityDepositAndManagementCost::getAmountOperationTypeEnum,
                     Collectors.mapping(SecurityDepositAndManagementCost::getAmount, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))
                  )
               )
            );
         BigDecimal securityDeductIncome = listMap.getOrDefault(AmountTypeEnum.SECURITY_DEPOSIT.getType(), Collections.emptyMap())
            .getOrDefault(1, BigDecimal.ZERO);
         BigDecimal securityRecord = listMap.getOrDefault(AmountTypeEnum.SECURITY_DEPOSIT.getType(), Collections.emptyMap()).getOrDefault(2, BigDecimal.ZERO);
         BigDecimal managementDeductIncome = listMap.getOrDefault(AmountTypeEnum.MANAGEMENT_COST.getType(), Collections.emptyMap())
            .getOrDefault(1, BigDecimal.ZERO);
         BigDecimal managementRecord = listMap.getOrDefault(AmountTypeEnum.MANAGEMENT_COST.getType(), Collections.emptyMap()).getOrDefault(2, BigDecimal.ZERO);
         projectSupplierAmount = projectSupplierAmount.add(securityDeductIncome.subtract(securityRecord).add(managementDeductIncome.subtract(managementRecord)));
      }

      BigDecimal collectionSummary = BigDecimal.ZERO;
      BigDecimal projectManagerAmount = BigDecimal.ZERO;
      BigDecimal projectManagerPayment = BigDecimal.ZERO;
      BigDecimal contractSignBodyAmount = BigDecimal.ZERO;
      BigDecimal contractSignBodyPayment = BigDecimal.ZERO;
      BigDecimal projectCollectionSummary = BigDecimal.ZERO;
      if (project.getProjectAttribute().equals(ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType())) {
         projectCollectionSummary = ObjectUtils.isNotEmpty(project.getCollectionSummary()) ? project.getCollectionSummary() : BigDecimal.ZERO;
         collectionSummary = this.projectService
            .list(
               Wrappers.lambdaQuery(ContractProject.class)
                  .eq(ContractProject::getProjectManagerId, project.getProjectManagerId())
                  .eq(ContractProject::getProjectAttribute, project.getProjectAttribute())
            )
            .stream()
            .map(ContractProject::getCollectionSummary)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         List<ContractProjectAssetInjection> injectionList = this.assetInjectionService
            .list(Wrappers.lambdaQuery(ContractProjectAssetInjection.class).eq(ContractProjectAssetInjection::getProjectId, project.getId()));
         if (CollectionUtils.isNotEmpty(injectionList)) {
            Map<Boolean, List<ContractProjectAssetInjection>> isList = injectionList.stream()
               .collect(Collectors.groupingBy(ContractProjectAssetInjection::getIncomeOrDisburse));
            projectManagerAmount = CollectionUtils.isNotEmpty(isList.get(Boolean.TRUE))
               ? isList.get(Boolean.TRUE)
                  .stream()
                  .filter(a -> ObjectUtils.isNotEmpty(a.getProjectManagerId()))
                  .map(ContractProjectAssetInjection::getProjectManagerScale)
                  .reduce(BigDecimal.ZERO, BigDecimal::add)
               : BigDecimal.ZERO;
            projectManagerPayment = CollectionUtils.isNotEmpty(isList.get(Boolean.FALSE))
               ? isList.get(Boolean.FALSE)
                  .stream()
                  .filter(a -> ObjectUtils.isNotEmpty(a.getProjectManagerId()))
                  .map(ContractProjectAssetInjection::getProjectManagerScale)
                  .reduce(BigDecimal.ZERO, BigDecimal::add)
               : BigDecimal.ZERO;
            contractSignBodyAmount = CollectionUtils.isNotEmpty(isList.get(Boolean.TRUE))
               ? isList.get(Boolean.TRUE)
                  .stream()
                  .filter(a -> ObjectUtils.isNotEmpty(a.getContractSignBodyId()))
                  .map(ContractProjectAssetInjection::getContractSignBodyScale)
                  .reduce(BigDecimal.ZERO, BigDecimal::add)
               : BigDecimal.ZERO;
            contractSignBodyPayment = CollectionUtils.isNotEmpty(isList.get(Boolean.FALSE))
               ? isList.get(Boolean.FALSE)
                  .stream()
                  .filter(a -> ObjectUtils.isNotEmpty(a.getContractSignBodyId()))
                  .map(ContractProjectAssetInjection::getContractSignBodyScale)
                  .reduce(BigDecimal.ZERO, BigDecimal::add)
               : BigDecimal.ZERO;
         }

         collectionSummary = collectionSummary.add(projectManagerAmount.add(contractSignBodyAmount))
            .subtract(projectManagerPayment.add(contractSignBodyPayment));
      } else {
         projectCollectionSummary = ObjectUtils.isNotEmpty(project.getProjectManagerAmount())
            ? project.getProjectManagerAmount()
               .add(ObjectUtils.isNotEmpty(project.getContractSignBodyAmount()) ? project.getContractSignBodyAmount() : BigDecimal.ZERO)
            : (ObjectUtils.isNotEmpty(project.getContractSignBodyAmount()) ? project.getContractSignBodyAmount() : BigDecimal.ZERO);
         List<ContractCollection> collectionList = this.collectionService
            .list(Wrappers.lambdaQuery(ContractCollection.class).eq(ContractCollection::getProjectId, project.getId()));
         collectionSummary = CollectionUtils.isNotEmpty(collectionList)
            ? collectionSummary.add(project.getProjectManagerAmount().add(project.getContractSignBodyAmount()))
            : BigDecimal.ZERO;
         List<ContractProjectAssetInjection> injectionList = this.assetInjectionService
            .list(Wrappers.lambdaQuery(ContractProjectAssetInjection.class).eq(ContractProjectAssetInjection::getProjectId, project.getId()));
         if (CollectionUtils.isNotEmpty(injectionList)) {
            Map<Boolean, List<ContractProjectAssetInjection>> isList = injectionList.stream()
               .collect(Collectors.groupingBy(ContractProjectAssetInjection::getIncomeOrDisburse));
            projectManagerAmount = CollectionUtils.isNotEmpty(isList.get(Boolean.TRUE))
               ? isList.get(Boolean.TRUE)
                  .stream()
                  .filter(a -> ObjectUtils.isNotEmpty(a.getProjectManagerId()) && ObjectUtils.isNotEmpty(a.getProjectManagerScale()))
                  .map(ContractProjectAssetInjection::getProjectManagerScale)
                  .reduce(BigDecimal.ZERO, BigDecimal::add)
               : BigDecimal.ZERO;
            projectManagerPayment = CollectionUtils.isNotEmpty(isList.get(Boolean.FALSE))
               ? isList.get(Boolean.FALSE)
                  .stream()
                  .filter(a -> ObjectUtils.isNotEmpty(a.getProjectManagerId()) && ObjectUtils.isNotEmpty(a.getProjectManagerScale()))
                  .map(ContractProjectAssetInjection::getProjectManagerScale)
                  .reduce(BigDecimal.ZERO, BigDecimal::add)
               : BigDecimal.ZERO;
            contractSignBodyAmount = CollectionUtils.isNotEmpty(isList.get(Boolean.TRUE))
               ? isList.get(Boolean.TRUE)
                  .stream()
                  .filter(a -> ObjectUtils.isNotEmpty(a.getContractSignBodyId()) && ObjectUtils.isNotEmpty(a.getContractSignBodyScale()))
                  .map(ContractProjectAssetInjection::getContractSignBodyScale)
                  .reduce(BigDecimal.ZERO, BigDecimal::add)
               : BigDecimal.ZERO;
            contractSignBodyPayment = CollectionUtils.isNotEmpty(isList.get(Boolean.FALSE))
               ? isList.get(Boolean.FALSE)
                  .stream()
                  .filter(a -> ObjectUtils.isNotEmpty(a.getContractSignBodyId()) && ObjectUtils.isNotEmpty(a.getContractSignBodyScale()))
                  .map(ContractProjectAssetInjection::getContractSignBodyScale)
                  .reduce(BigDecimal.ZERO, BigDecimal::add)
               : BigDecimal.ZERO;
         }

         collectionSummary = collectionSummary.add(projectManagerAmount.add(contractSignBodyAmount))
            .subtract(projectManagerPayment.add(contractSignBodyPayment));
      }

      ProjectSupplierDto projectSupplierDto = new ProjectSupplierDto()
         .setContractSignBodyId(project.getContractSignBodyId())
         .setProjectAttribute(project.getProjectAttribute())
         .setContractAmount(project.getContractAmount())
         .setProjectIncome(project.getCollectionAmount())
         .setProjectExpenditure(projectSupplierAmount)
         .setCollectionSummary(project.getProjectAttribute().equals(ProjectAttributeEnum.JOINT_VENTURE.getType()) ? null : collectionSummary)
         .setProjectManagerRatio(project.getProjectManagerScale())
         .setProjectManagerRatioAmount(projectManagerAmount.subtract(projectManagerPayment))
         .setContractSignBodyName(branchCompanyMap.get(project.getContractSignBodyId()).getName())
         .setContractSignBodyRatio(project.getContractSignBodyScale())
         .setContractSignBodyRatioAmount(contractSignBodyAmount.subtract(contractSignBodyPayment))
         .setContractCollectionSummary(
            projectCollectionSummary.add(projectManagerAmount.add(contractSignBodyAmount)).subtract(projectManagerPayment.add(contractSignBodyPayment))
         )
         .setContractExpenditure(
            !paymentList.isEmpty()
               ? paymentList.stream().map(SupplierPayment::getActuallyPaymentAmount).reduce(BigDecimal.ZERO, BigDecimal::add)
               : BigDecimal.ZERO
         )
         .setPersonalCredit(ObjectUtils.isNotEmpty(givingCredit) ? givingCredit.getRemainingSum() : BigDecimal.ZERO);
      if (CollectionUtils.isNotEmpty(paymentList)) {
         projectSupplierDto.setPaymentBank(
            paymentList.get(paymentList.size() - 1).getPaymentBank() == null ? "" : paymentList.get(paymentList.size() - 1).getPaymentBank()
         );
         projectSupplierDto.setPaymentBankAccount(
            paymentList.get(paymentList.size() - 1).getPaymentBankAccount() == null ? "" : paymentList.get(paymentList.size() - 1).getPaymentBankAccount()
         );
      }

      return projectSupplierDto;
   }

   private void projectAttributeCheck(ProjectSaveDTOParam projectSaveDTOParam, ContractProject project) {
      ContractProject getProject = this.projectService.getById(projectSaveDTOParam.getBaseRequestVO().getProjectId());
      List<ContractCollection> collectionList = this.contractCollectionService
         .list(Wrappers.lambdaQuery(ContractCollection.class).eq(ContractCollection::getProjectId, projectSaveDTOParam.getBaseRequestVO().getProjectId()));
      if (!projectSaveDTOParam.getBaseRequestVO().getProjectAttribute().equals(getProject.getProjectAttribute())) {
         if (!projectSaveDTOParam.getBaseRequestVO().getProjectAttribute().equals(ProjectAttributeEnum.SELF_SUPPORT.getType())) {
            if (!getProject.getProjectAttribute().equals(ProjectAttributeEnum.SELF_SUPPORT.getType())) {
               List<SecurityDepositAndManagementCost> managementCostList = this.securityDepositAndManagementCostService
                  .list(
                     Wrappers.lambdaQuery(SecurityDepositAndManagementCost.class)
                        .eq(SecurityDepositAndManagementCost::getProjectId, projectSaveDTOParam.getBaseRequestVO().getProjectId())
                  );
               Map<Integer, List<SecurityDepositAndManagementCost>> amountTypeListMap = managementCostList.stream()
                  .collect(Collectors.groupingBy(SecurityDepositAndManagementCost::getAmountType));
               List<SecurityDepositAndManagementCost> moneyList = managementCostList.stream()
                  .collect(Collectors.groupingBy(SecurityDepositAndManagementCost::getAmountType))
                  .get(1);
               List<SecurityDepositAndManagementCost> costList = managementCostList.stream()
                  .collect(Collectors.groupingBy(SecurityDepositAndManagementCost::getAmountType))
                  .get(2);
               BigDecimal securityDeductIncome = moneyList.stream()
                  .filter(a -> a.getSecurityDeductIncome() != null)
                  .map(SecurityDepositAndManagementCost::getSecurityDeductIncome)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal securityRecord = moneyList.stream()
                  .filter(a -> a.getSecurityRecord() != null)
                  .map(SecurityDepositAndManagementCost::getSecurityRecord)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal managementDeductIncome = costList.stream()
                  .filter(a -> a.getManagementDeductIncome() != null)
                  .map(SecurityDepositAndManagementCost::getManagementDeductIncome)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal managementRecord = costList.stream()
                  .filter(a -> a.getManagementRecord() != null)
                  .map(SecurityDepositAndManagementCost::getManagementRecord)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal subtract = securityDeductIncome.add(managementDeductIncome).subtract(securityRecord.add(managementRecord));
               this.securityDepositAndManagementCostService
                  .save(
                     new SecurityDepositAndManagementCost()
                        .setRemark("项目属性修改退还保证金和管理费金额：" + subtract.setScale(2, RoundingMode.HALF_UP))
                        .setDateTime(LocalDateTime.now())
                        .setProjectId(projectSaveDTOParam.getBaseRequestVO().getProjectId())
                        .setSecurityRecord(securityDeductIncome.subtract(securityRecord))
                        .setUserId(UserUtil.getCurrentUserId())
                        .setAmountType(AmountTypeEnum.SECURITY_DEPOSIT.getType())
                  );
               this.securityDepositAndManagementCostService
                  .save(
                     new SecurityDepositAndManagementCost()
                        .setRemark("项目属性修改退还管理费金总额：" + subtract.setScale(2, RoundingMode.HALF_UP))
                        .setDateTime(LocalDateTime.now())
                        .setProjectId(projectSaveDTOParam.getBaseRequestVO().getProjectId())
                        .setManagementRecord(managementDeductIncome.subtract(managementRecord))
                        .setUserId(UserUtil.getCurrentUserId())
                        .setAmountType(2)
                  );
            }

            getProject.setIsDeposit(Boolean.FALSE);
            if (!projectSaveDTOParam.getBaseRequestVO().getProjectAttribute().equals(ProjectAttributeEnum.SELF_SUPPORT.getType())) {
               this.ManagementFeeAndMarginCheck(
                  projectSaveDTOParam.getBaseRequestVO().getProjectAttribute(), projectSaveDTOParam.getBaseRequestVO().getContractAmount(), project
               );
               BigDecimal collectionSummary = null;

               for (ContractCollection collection : collectionList) {
                  Boolean isAdd = false;
                  if (!getProject.getIsDeposit() && collection.getCollectionAmount().compareTo(project.getMarginAmount()) >= 0) {
                     this.securityDepositAndManagementCostService
                        .save(
                           new SecurityDepositAndManagementCost()
                              .setProjectId(project.getId())
                              .setDateTime(LocalDateTime.now())
                              .setUserId(UserUtil.getCurrentUserId())
                              .setIncome(collection.getCollectionAmount())
                              .setDateTime(LocalDateTime.now())
                              .setAmount(project.getMarginAmount())
                              .setSecurityDeductIncome(project.getMarginAmount())
                              .setAmountType(AmountTypeEnum.SECURITY_DEPOSIT.getType())
                              .setRemark("收款" + collection.getCollectionAmount().setScale(2, RoundingMode.HALF_UP) + "时,扣除保证金")
                        );
                     this.projectService.updateById(new ContractProject().setId(project.getId()).setIsDeposit(Boolean.TRUE));
                     getProject.setIsDeposit(Boolean.TRUE);
                     collectionSummary = collection.getCollectionAmount().subtract(project.getMarginAmount());
                     isAdd = true;
                  }

                  BigDecimal managementDeductIncome = collection.getCollectionAmount()
                     .abs()
                     .multiply(project.getManagementFeeRate())
                     .divide(BigDecimal.valueOf(100L), 2, RoundingMode.HALF_UP);
                  this.securityDepositAndManagementCostService
                     .save(
                        new SecurityDepositAndManagementCost()
                           .setUserId(UserUtil.getCurrentUserId())
                           .setProjectId(project.getId())
                           .setIncome(collection.getCollectionAmount())
                           .setAmount(managementDeductIncome)
                           .setDateTime(LocalDateTime.now())
                           .setAmountType(AmountTypeEnum.MANAGEMENT_COST.getType())
                           .setManagementDeductIncome(managementDeductIncome)
                           .setRate(String.valueOf(project.getManagementFeeRate()))
                           .setRemark("收款" + collection.getCollectionAmount().setScale(2, RoundingMode.HALF_UP) + "时,扣除管理费")
                     );
                  if (isAdd) {
                     collectionSummary = collectionSummary.subtract(managementDeductIncome);
                  } else {
                     collectionSummary = collection.getCollectionAmount()
                        .subtract(managementDeductIncome)
                        .add(collectionSummary != null ? collectionSummary : BigDecimal.ZERO);
                  }
               }

               project.setCollectionSummary(collectionSummary);
            }
         } else {
            project.setCollectionSummary(collectionList.stream().map(ContractCollection::getCollectionAmount).reduce(BigDecimal.ZERO, BigDecimal::add));
         }
      }
   }

   @Override
   public ProjectCostReportDto getProjectCostReport(Long projectId) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在");
      Map<Long, Supplier> supplierMap = this.supplierService.list().stream().collect(Collectors.toMap(Supplier::getId, Function.identity()));
      List<ProjectMaterialsAllDto> projectMaterialsAllDtos = new ArrayList<>();
      List<ProjectElseAllDto> otherExpenditures = new ArrayList<>();
      List<ManagementFeeAllDto> managementFeeDetails = new ArrayList<>();
      return !project.getProjectAttribute().equals(ProjectAttributeEnum.SELF_SUPPORT.getType())
         ? this.lumpSumSystem(projectId, projectMaterialsAllDtos, otherExpenditures, managementFeeDetails, supplierMap)
         : null;
   }

   @NotNull
   private BigDecimal getSelfEmployedBigDecimal(
      Long projectId, List<ProjectMaterialsAllDto> projectMaterialsAllDtos, Map<Long, Supplier> supplierMap, Integer pageNumber, Integer pageSize
   ) {
      if (pageNumber != null && pageSize != null) {
         PageHelper.startPage(pageNumber, pageSize);
      }

      Map<Long, BranchCompany> branchCompanyMap = this.branchCompanyService
         .list(Wrappers.lambdaQuery(BranchCompany.class).eq(BranchCompany::getLevel, 1))
         .stream()
         .collect(Collectors.toMap(BranchCompany::getId, Function.identity()));
      ContractProject project = this.projectService.getById(projectId);
      Long branchCompany = null;
      if (branchCompanyMap.get(project.getContractSignBodyId()) != null) {
         branchCompany = project.getContractSignBodyId();
      }

      List<PurchaseOrder> purchaseOrders = this.purchaseOrderService
         .list(
            Wrappers.lambdaQuery(PurchaseOrder.class)
               .isNotNull(PurchaseOrder::getProjectIds)
               .eq(branchCompany != null, PurchaseOrder::getBranchCompanyId, branchCompany)
         )
         .stream()
         .filter(order -> Arrays.asList(order.getProjectIds().split(",")).contains(projectId.toString()))
         .collect(Collectors.toList());
      BigDecimal paymentAmount = BigDecimal.ZERO;
      if (!purchaseOrders.isEmpty()) {
         List<Long> orderIds = purchaseOrders.stream().map(PurchaseOrder::getId).collect(Collectors.toList());
         List<SupplierPayment> paymentList = this.supplierPaymentService
            .list(Wrappers.lambdaQuery(SupplierPayment.class).in(SupplierPayment::getOrderId, orderIds));
         Map<Long, List<SupplierPayment>> paymentMap = paymentList.stream().collect(Collectors.groupingBy(SupplierPayment::getOrderId));
         Map<Long, BigDecimal> amountMap = new HashMap<>();
         paymentMap.forEach(
            (k, v) -> {
               if (!v.isEmpty()) {
                  amountMap.put(
                     k, v.stream().filter(a -> a.getPaymentAmount() != null).map(SupplierPayment::getPaymentAmount).reduce(BigDecimal.ZERO, BigDecimal::add)
                  );
               }
            }
         );
         paymentAmount = paymentList.stream()
            .filter(a -> a.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType()) && a.getPaymentAmount() != null)
            .map(SupplierPayment::getPaymentAmount)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         purchaseOrders.forEach(
            a -> {
               Long supplierId = a.getSupplierId() != null ? a.getSupplierId() : null;
               ProjectMaterialsAllDto materialsAllDto = ProjectMaterialsAllDto.builder()
                  .status(a.getSettlementStatus())
                  .contractAmount(a.getAmount())
                  .serialNumber(a.getSerialNumber())
                  .supplierName(supplierMap.get(supplierId) != null ? supplierMap.get(supplierId).getName() : null)
                  .totalPaid(amountMap.getOrDefault(a.getId(), BigDecimal.ZERO))
                  .unpaid(
                     a.getAmount().compareTo(amountMap.getOrDefault(a.getId(), BigDecimal.ZERO)) >= 0
                        ? a.getAmount().subtract(amountMap.getOrDefault(a.getId(), BigDecimal.ZERO))
                        : BigDecimal.ZERO
                  )
                  .build();
               if (a.getSettlementStatus().equals(SettlementStatusEnum.SETTLED.getType())) {
                  materialsAllDto.setSettlementAmount(a.getSettlementAmount());
                  materialsAllDto.setUnpaid(
                     a.getAmount().compareTo(a.getSettlementAmount()) >= 0 ? a.getAmount().subtract(a.getSettlementAmount()) : BigDecimal.ZERO
                  );
               }

               projectMaterialsAllDtos.add(materialsAllDto);
            }
         );
      }

      return paymentAmount;
   }

   private ProjectCostReportDto lumpSumSystem(
      Long projectId,
      List<ProjectMaterialsAllDto> projectMaterialsAllDtos,
      List<ProjectElseAllDto> otherExpenditures,
      List<ManagementFeeAllDto> managementFeeDetails,
      Map<Long, Supplier> supplierMap
   ) {
      BigDecimal paymentAmount = this.getLumpSumSystemConsume(projectId, projectMaterialsAllDtos, supplierMap, null, null);
      Map<String, BigDecimal> map = this.getManagementFee(projectId, managementFeeDetails, null, null);
      BigDecimal managementFee = map.get("managementFee");
      BigDecimal securityFee = map.get("securityFee");
      List<ContractCollection> collectionList = this.contractCollectionService
         .list(
            Wrappers.lambdaQuery(ContractCollection.class)
               .eq(ContractCollection::getProjectId, projectId)
               .eq(ContractCollection::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         );
      BigDecimal collectionAmount = !collectionList.isEmpty()
         ? collectionList.stream().map(ContractCollection::getCollectionAmount).reduce(BigDecimal.ZERO, BigDecimal::add)
         : BigDecimal.ZERO;
      return ProjectCostReportDto.builder()
         .totalExpenditure(paymentAmount.add(managementFee).add(securityFee))
         .totalIncome(collectionAmount)
         .profit(collectionAmount.subtract(paymentAmount.add(managementFee)))
         .materialCost(paymentAmount)
         .materialCostRatio(
            paymentAmount.compareTo(BigDecimal.ZERO) > 0
               ? paymentAmount.divide(paymentAmount.add(managementFee), 2, RoundingMode.FLOOR).multiply(BigDecimal.valueOf(100L))
               : BigDecimal.ZERO
         )
         .subcontractCost(BigDecimal.ZERO)
         .leaseCost(BigDecimal.ZERO)
         .otherCost(BigDecimal.ZERO)
         .capitalInterest(BigDecimal.ZERO)
         .managementFee(managementFee)
         .materialExpenditure(projectMaterialsAllDtos)
         .otherExpenditure(otherExpenditures)
         .managementFeeDetail(managementFeeDetails)
         .build();
   }

   @NotNull
   private Map<String, BigDecimal> getManagementFee(Long projectId, List<ManagementFeeAllDto> managementFeeDetails, Integer pageNumber, Integer pageSize) {
      Map<String, BigDecimal> map = new HashMap<>();
      if (pageNumber != null && pageSize != null) {
         PageHelper.startPage(pageNumber, pageSize);
      }

      List<SecurityDepositAndManagementCost> costList = this.securityDepositAndManagementCostService
         .list(
            Wrappers.lambdaQuery(SecurityDepositAndManagementCost.class)
               .eq(SecurityDepositAndManagementCost::getAmountType, AmountTypeEnum.MANAGEMENT_COST.getType())
               .eq(SecurityDepositAndManagementCost::getProjectId, projectId)
         );
      BigDecimal managementDeductIncome = BigDecimal.ZERO;
      BigDecimal managementRecord = BigDecimal.ZERO;
      if (ObjectUtils.isNotEmpty(costList)) {
         managementDeductIncome = costList.stream()
            .map(SecurityDepositAndManagementCost::getManagementDeductIncome)
            .filter(ObjectUtils::isNotEmpty)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         managementRecord = costList.stream()
            .map(SecurityDepositAndManagementCost::getManagementRecord)
            .filter(ObjectUtils::isNotEmpty)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
      }

      BigDecimal managementFee = managementDeductIncome.subtract(managementRecord);
      if (!costList.isEmpty()) {
         costList.forEach(
            a -> {
               ManagementFeeAllDto build = ManagementFeeAllDto.builder()
                  .createTime(a.getDateTime())
                  .incomeAmount(a.getIncome())
                  .managementFee(a.getManagementDeductIncome())
                  .build();
               if (ObjectUtils.isNotEmpty(a.getRate())) {
                  build.setManagementFeeRate(a.getRate().length() > 4 ? a.getRate().substring(0, 4) : a.getRate());
               }

               managementFeeDetails.add(build);
            }
         );
         managementFeeDetails.sort(Comparator.comparing(ManagementFeeAllDto::getCreateTime).reversed());
      }

      BigDecimal securityIncome = BigDecimal.ZERO;
      BigDecimal securityRecord = BigDecimal.ZERO;
      if (!costList.isEmpty()) {
         securityIncome = costList.stream()
            .map(SecurityDepositAndManagementCost::getSecurityDeductIncome)
            .filter(ObjectUtils::isNotEmpty)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         securityRecord = costList.stream()
            .map(SecurityDepositAndManagementCost::getSecurityRecord)
            .filter(ObjectUtils::isNotEmpty)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
      }

      BigDecimal securityFee = securityIncome.subtract(securityRecord);
      map.put("managementFee", managementFee);
      map.put("securityFee", securityFee);
      return map;
   }

   @NotNull
   private BigDecimal getLumpSumSystemConsume(
      Long projectId, List<ProjectMaterialsAllDto> projectMaterialsAllDtos, Map<Long, Supplier> supplierMap, Integer pageNumber, Integer pageSize
   ) {
      List<PurchaseOrder> purchaseOrders = this.purchaseOrderService
         .list(
            Wrappers.lambdaQuery(PurchaseOrder.class)
               .isNotNull(PurchaseOrder::getProjectIds)
               .eq(PurchaseOrder::getReviewStatus, AuditStatusEnum.SUCCEED.getType())
         )
         .stream()
         .filter(order -> Arrays.asList(order.getProjectIds().split(",")).contains(projectId.toString()))
         .collect(Collectors.toList());
      BigDecimal paymentAmount = BigDecimal.ZERO;
      if (!purchaseOrders.isEmpty()) {
         List<Long> orderIds = purchaseOrders.stream().map(PurchaseOrder::getId).collect(Collectors.toList());
         List<SupplierPayment> paymentList = this.supplierPaymentService
            .list(
               Wrappers.lambdaQuery(SupplierPayment.class)
                  .in(SupplierPayment::getOrderId, orderIds)
                  .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
            );
         Map<Long, List<SupplierPayment>> paymentMap = paymentList.stream().collect(Collectors.groupingBy(SupplierPayment::getOrderId));
         Map<Long, BigDecimal> amountMap = new HashMap<>();
         paymentMap.forEach((k, v) -> {
            if (!v.isEmpty()) {
               amountMap.put(k, v.stream().map(SupplierPayment::getActuallyPaymentAmount).reduce(BigDecimal.ZERO, BigDecimal::add));
            }
         });
         paymentAmount = paymentList.stream()
            .filter(a -> a.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType()))
            .map(SupplierPayment::getActuallyPaymentAmount)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         purchaseOrders.forEach(
            a -> {
               Long supplierId = a.getSupplierId() != null ? a.getSupplierId() : null;
               ProjectMaterialsAllDto materialsAllDto = ProjectMaterialsAllDto.builder()
                  .id(a.getId())
                  .status(a.getSettlementStatus())
                  .contractAmount(a.getAmount())
                  .serialNumber(a.getSerialNumber())
                  .supplierName(supplierMap.get(supplierId) != null ? supplierMap.get(supplierId).getName() : null)
                  .totalPaid(amountMap.getOrDefault(a.getId(), BigDecimal.ZERO))
                  .unpaid(
                     a.getAmount().compareTo(amountMap.getOrDefault(a.getId(), BigDecimal.ZERO)) >= 0
                        ? a.getAmount().subtract(amountMap.getOrDefault(a.getId(), BigDecimal.ZERO))
                        : BigDecimal.ZERO
                  )
                  .build();
               if (ObjectUtils.isNotEmpty(a.getSettlementStatus()) && a.getSettlementStatus().equals(SettlementStatusEnum.SETTLED.getType())) {
                  materialsAllDto.setSettlementAmount(a.getSettlementAmount());
                  materialsAllDto.setUnpaid(
                     a.getAmount().compareTo(a.getSettlementAmount()) >= 0 ? a.getAmount().subtract(a.getSettlementAmount()) : BigDecimal.ZERO
                  );
               }

               projectMaterialsAllDtos.add(materialsAllDto);
            }
         );
         projectMaterialsAllDtos.sort(Comparator.comparing(ProjectMaterialsAllDto::getStatus));
      }

      return paymentAmount;
   }

   @Override
   public PageVO<ProjectMaterialsAllDto> getProjectMaterialDeductDetails(Long projectId, Integer pageNumber, Integer pageSize) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在");
      Map<Long, Supplier> supplierMap = this.supplierService.list().stream().collect(Collectors.toMap(Supplier::getId, Function.identity()));
      List<ProjectMaterialsAllDto> projectMaterialsAllDtos = new ArrayList<>();
      if (!project.getProjectAttribute().equals(ProjectAttributeEnum.SELF_SUPPORT.getType())) {
         this.getLumpSumSystemConsume(projectId, projectMaterialsAllDtos, supplierMap, pageNumber, pageSize);
      } else {
         this.getSelfEmployedBigDecimal(projectId, projectMaterialsAllDtos, supplierMap, pageNumber, pageSize);
      }

      return new PageVO<>(projectMaterialsAllDtos);
   }

   @Override
   public PageVO<ProjectElseAllDto> getProjectOtherDetails(Long projectId, Integer pageNumber, Integer pageSize) {
      return null;
   }

   @Override
   public PageVO<ManagementFeeAllDto> getProjectManagementFeeDetails(Long projectId, Integer pageNumber, Integer pageSize) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在");
      List<ManagementFeeAllDto> managementFeeDetails = new ArrayList<>();
      this.getManagementFee(projectId, managementFeeDetails, pageNumber, pageSize);
      return new PageVO<>(managementFeeDetails);
   }

   @Override
   public Boolean getProjectCostReportDownload(Long projectId, HttpServletResponse response) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(project), "项目不存在");
      ProjectCostReportDto projectCostReport = this.getProjectCostReport(projectId);
      List<ProjectMaterialsAllDto> materialExpenditure = projectCostReport.getMaterialExpenditure();
      List<ProjectElseAllDto> otherExpenditure = projectCostReport.getOtherExpenditure();
      List<ManagementFeeAllDto> managementFeeDetail = projectCostReport.getManagementFeeDetail();
      materialExpenditure.stream()
         .forEach(
            item -> {
               item.setStatusName(
                  item.getStatus().equals(SettlementStatusEnum.SETTLED.getType())
                     ? SettlementStatusEnum.SETTLED.getName()
                     : SettlementStatusEnum.UN_SETTLED.getName()
               );
               item.setUnpaid(item.getContractAmount().subtract(item.getTotalPaid()));
            }
         );
      String resourcePath = "files/CostStatement.xlsx";
      String tempFileName = "CostStatement";
      String exportFileName = "成本报表.xlsx";
      Map<String, Object> stringObjectMap = BeanToMapUtils.beanToMap(projectCostReport);
      ClassPathResource resource = new ClassPathResource(resourcePath);
      File file = null;

      try (InputStream inputStream = resource.getInputStream()) {
         file = File.createTempFile(tempFileName, "xlsx");
         FileUtil.copyInputStreamToFile(inputStream, file);
      } catch (IOException e) {
         e.printStackTrace();
      }

      stringObjectMap.put("materialExpenditure", materialExpenditure);
      stringObjectMap.put("otherExpenditure", otherExpenditure);
      stringObjectMap.put("managementFeeDetail", managementFeeDetail);
      TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath(), true);
      Workbook workbook = ExcelExportUtil.exportExcel(params, stringObjectMap);
      PoiUtils.downLoadExcel(exportFileName, response, workbook);
      return Boolean.TRUE;
   }

   @Override
   public Map<String, List<ContractProjectListForUserDTO>> listProjectByUser(ProjectListQueryParam projectListQueryParam) {
      List<ContractProjectListForUserDTO> projectResponseDTOListUser = this.projectService.listProjectsByIdOrName(projectListQueryParam);
      List<Long> projectIds = projectResponseDTOListUser.stream().map(ContractProjectListForUserDTO::getId).collect(Collectors.toList());
      List<ContractProjectListForUserDTO> projectResponseDTOListNoUser = new ArrayList<>();
      new ArrayList();
      List contractProjectList;
      if (CollectionUtils.isNotEmpty(projectIds)) {
         contractProjectList = this.projectService
            .list(
               (Wrapper<ContractProject>)(new LambdaQueryWrapper<ContractProject>().notIn(ContractProject::getId, projectIds))
                  .eq(BaseEntity::getBoolDeleteEnum, 0)
            );
      } else {
         contractProjectList = this.projectService.list((Wrapper<ContractProject>)new LambdaQueryWrapper<ContractProject>().eq(BaseEntity::getBoolDeleteEnum, 0));
      }

      contractProjectList.stream().map(contractProject -> {
         ContractProjectListForUserDTO contractProjectListForUserDTO = new ContractProjectListForUserDTO();
         BeanUtils.copyProperties(contractProject, contractProjectListForUserDTO);
         return projectResponseDTOListNoUser.add(contractProjectListForUserDTO);
      }).collect(Collectors.toList());
      Map<String, List<ContractProjectListForUserDTO>> map = new HashMap<>(2);
      map.put("user", projectResponseDTOListUser);
      map.put("noUser", projectResponseDTOListNoUser);
      return map;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public String userUpdateProject(ProjectUserUpdateParam projectUserUpdateParam) {
      List<Long> projectAddIds = projectUserUpdateParam.getProjectAddIds();
      List<Long> projectDelIds = projectUserUpdateParam.getProjectDelIds();
      Long userId = projectUserUpdateParam.getUserId();
      User user = this.userService.getById(userId);
      Preconditions.checkArgument(user != null, "员工不存在");
      Preconditions.checkArgument(projectAddIds != null, "项目列表不能为空");
      projectAddIds.forEach(projectId -> Preconditions.checkArgument(projectId != null
         && this.projectService.getById(projectId) != null, "项目不存在"));
      this.projectUserLinkService
         .remove(
            (Wrapper<ProjectUserLink>)(new LambdaQueryWrapper<ProjectUserLink>().eq(ProjectUserLink::getUserId, userId))
               .eq(BaseEntity::getBoolDeleteEnum, 0)
         );
      if (CollectionUtils.isNotEmpty(projectAddIds)) {
         List<ProjectUserLink> addProjectUserLinks = new ArrayList<>();
         projectAddIds.forEach(projectId -> {
            ProjectUserLink projectUserLink = new ProjectUserLink();
            projectUserLink.setProjectId(projectId);
            projectUserLink.setUserId(userId);
            addProjectUserLinks.add(projectUserLink);
         });
         this.projectUserLinkService.saveBatch(addProjectUserLinks);
      }

      return user.getName() + "下的项目配置修改成功";
   }

   @Override
   public Map<String, Object> getProjectSelfEmployed(LocalDateTime year, Integer level, Integer settlementStatus) {
      Integer intYear = year != null ? year.getYear() : null;
      Boolean boolTwoLevelUnit = this.projectFinanceUtils.getBoolTwoLevelUnit();
      if (boolTwoLevelUnit) {
         Preconditions.checkArgument(level != null, "系统版本未知!无法操作!");
      } else {
         level = null;
      }

      List<ContractProject> projectList = this.projectService
         .list(
            Wrappers.lambdaQuery(ContractProject.class)
               .eq(settlementStatus != null, ContractProject::getSettlementStatus, settlementStatus)
               .eq(level != null, ContractProject::getProjectAttribute, ProjectAttributeEnum.SELF_SUPPORT.getType())
               .apply(intYear != null, "YEAR(create_time) = {0}", intYear)
               .apply(level != null, "level & {0} > 0", level)
         );
      Map<String, Object> map = new HashMap<>(16);
      BigDecimal contractAmount = projectList.stream().map(ContractProject::getContractAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal collectionAmount = projectList.stream().map(ContractProject::getCollectionAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
      List<ContractProject> unSettledList = projectList.stream()
         .filter(project -> project.getSettlementStatus().equals(SettlementStatusEnum.UN_SETTLED.getType()))
         .collect(Collectors.toList());
      List<ContractProject> settledList = projectList.stream()
         .filter(project -> project.getSettlementStatus().equals(SettlementStatusEnum.SETTLED.getType()))
         .collect(Collectors.toList());
      map.put("projectSum", projectList.size());
      map.put("contractAmount", contractAmount);
      map.put("collectionAmount", collectionAmount);
      map.put("unsettled", unSettledList.size());
      map.put("settled", settledList.size());
      return map;
   }

   @Override
   public PageVO<ProjectLedgerDTO> getProjectSelfOwnedPageSize(ProjectLedgerDtoParam param, Integer pageNumber, Integer pageSize) {
      Boolean boolTwoLevelUnit = this.projectFinanceUtils.getBoolTwoLevelUnit();
      if (boolTwoLevelUnit) {
         Preconditions.checkArgument(param.getLevel() != null, "单位等级未知!无法操作!");
      } else {
         param.setLevel(null);
      }

      List<BranchCompany> branchCompanyList = this.branchCompanyService.list();
      Map<Long, BranchCompany> branchCompanyMap = branchCompanyList.stream().collect(Collectors.toMap(BranchCompany::getId, Function.identity()));
      Long branchCompanyId = null;
      if (param.getLevel() != null) {
         BranchCompany branchCompany = branchCompanyList.stream()
            .filter(bc -> bc.getLevel().equals(param.getLevel()))
            .filter(
               bc -> bc.getBranchAttributeEnum().equals(BranchAttributeEnum.INSTALLATION.getType())
                  || bc.getBranchAttributeEnum().equals(BranchAttributeEnum.MANUFACTURING.getType())
            )
            .findFirst()
            .orElse(null);
         Preconditions.checkArgument(branchCompany != null, "单位不存在!");
         branchCompanyId = branchCompany.getId();
      }

      PageHelper.startPage(pageNumber, pageSize);
      List<ProjectLedgerDTO> ledgerDTOS = this.projectService.projectLedgerList(param);
      if (ledgerDTOS.isEmpty()) {
         return new PageVO<>();
      }

      List<Long> projectIds = ledgerDTOS.stream().map(ProjectLedgerDTO::getProject).map(ProjectInfo::getId).collect(Collectors.toList());
      Map<Long, BigDecimal> projectAccumulatedCostMap = this.getProjectAccumulatedCostMap(projectIds, param.getLevel());
      Long supplierId = this.getSecondCompanySupplier(branchCompanyList, boolTwoLevelUnit, param.getBranchCompanyId());
      List<PurchaseOrder> purchaseOrderList = this.purchaseOrderService
         .list(
            Wrappers.lambdaQuery(PurchaseOrder.class)
               .in(PurchaseOrder::getProjectIds, projectIds.stream().map(String::valueOf).collect(Collectors.toList()))
               .eq(PurchaseOrder::getSupplierId, supplierId)
               .eq(PurchaseOrder::getDataStatus, DataStatusEnum.SUCCEED.getType())
               .eq(PurchaseOrder::getReviewStatus, ReviewStatusEnum.REVIEWED.getType())
               .eq(PurchaseOrder::getLevel, PlaceEnum.CONSTRUCTION_SITE.getType())
         );
      Map<Long, BigDecimal> projectIdPurchaseAmountMap = purchaseOrderList.stream()
         .collect(Collectors.groupingBy(s -> Long.valueOf(s.getProjectIds()), Collectors.reducing(BigDecimal.ZERO, PurchaseOrder::getAmount, BigDecimal::add)));
      Map<Long, BigDecimal> projectIdPurchaseSettleAmountMap = purchaseOrderList.stream()
         .filter(s -> s.getSettlementAmount() != null)
         .collect(
            Collectors.groupingBy(
               s -> Long.valueOf(s.getProjectIds()), Collectors.reducing(BigDecimal.ZERO, PurchaseOrder::getSettlementAmount, BigDecimal::add)
            )
         );
      Map<Long, BigDecimal> collectionAmountMap = this.collectionService
         .list(
            Wrappers.lambdaQuery(ContractCollection.class)
               .in(ContractCollection::getProjectId, projectIds)
               .eq(ContractCollection::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .eq(param.getLevel() != null, ContractCollection::getCollectionUnitId, branchCompanyId)
         )
         .stream()
         .collect(
            Collectors.groupingBy(
               ContractCollection::getProjectId,
               Collectors.mapping(ContractCollection::getCollectionAmount, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))
            )
         );
      Map<Long, BigDecimal> invoiceAmountMap = this.invoiceService
         .list(
            Wrappers.lambdaQuery(ContractInvoice.class)
               .in(ContractInvoice::getProjectId, projectIds)
               .eq(ContractInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .eq(param.getLevel() != null, ContractInvoice::getInvoiceUnitId, branchCompanyId)
         )
         .stream()
         .collect(
            Collectors.groupingBy(
               ContractInvoice::getProjectId,
               Collectors.mapping(ContractInvoice::getActualInvoiceAmount, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))
            )
         );
      Map<Long, BigDecimal> projectIdPreSettlementAmountMap = this.contractSettlementService
         .list(
            Wrappers.lambdaQuery(ContractSettlement.class)
               .in(ContractSettlement::getProjectId, projectIds)
               .eq(ContractSettlement::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         )
         .stream()
         .collect(Collectors.groupingBy(ContractSettlement::getProjectId, Collectors.reducing(BigDecimal.ZERO, ContractSettlement::getAmount, BigDecimal::add)));
      Set<Long> salesLeaderIds = ledgerDTOS.stream().map(ProjectLedgerDTO::getSalesLeaderId).collect(Collectors.toSet());
      Map<Long, User> salesLeaderMap = this.userService.listByIds(salesLeaderIds).stream().collect(Collectors.toMap(User::getId, Function.identity()));
      FinanceAmountShowConfigDTO financeAmountShowConfig = this.configService.getFinanceAmountShowConfig();
      ledgerDTOS.forEach(
         dto -> {
            User user = salesLeaderMap.get(dto.getSalesLeaderId());
            dto.setSalesLeaderId(user != null ? dto.getSalesLeaderId() : dto.getSignerId());
            dto.setSalesLeaderName(user != null ? user.getName() : dto.getSignerName());
            dto.setAccumulatedCollection(collectionAmountMap.getOrDefault(dto.getProject().getId(), BigDecimal.ZERO));
            dto.setAccumulatedInvoice(invoiceAmountMap.getOrDefault(dto.getProject().getId(), BigDecimal.ZERO));
            dto.setAccumulatedCost(projectAccumulatedCostMap.getOrDefault(dto.getProject().getId(), BigDecimal.ZERO));
            BigDecimal availableBalance = dto.getAccumulatedCollection().subtract(dto.getAccumulatedCost());
            dto.setAvailableBalance(availableBalance.setScale(4, RoundingMode.HALF_UP));
            BranchCompany signBodyBranchCompany = branchCompanyMap.get(dto.getContractSignBodyId());
            if (param.getLevel() != null && !param.getLevel().equals(signBodyBranchCompany.getLevel())) {
               dto.setContractAmount(null);
               dto.setAmount(projectIdPurchaseAmountMap.get(dto.getProject().getId()));
               dto.setSettlementAmount(projectIdPurchaseSettleAmountMap.get(dto.getProject().getId()));
               dto.setCollectionRatio(dto.getAmount() != null ? dto.getAccumulatedCollection().divide(dto.getAmount(), 4, 4) : null);
               dto.setInvoiceRatio(dto.getAmount() != null ? dto.getAccumulatedInvoice().divide(dto.getAmount(), 4, 4) : null);
               if (financeAmountShowConfig.getBoolShowUnsettledUncollectedAmount()) {
                  BigDecimal advancesReceived = projectIdPurchaseAmountMap.getOrDefault(dto.getProject().getId(), BigDecimal.ZERO)
                     .subtract(dto.getAccumulatedCollection());
                  dto.setAdvancesReceived(advancesReceived.compareTo(BigDecimal.ZERO) >= 0 ? advancesReceived : BigDecimal.ZERO);
               }
            } else {
               dto.setSettlementAmount(dto.getSettlementStatus().equals(SettlementStatusEnum.UN_SETTLED.getType()) ? null : dto.getSettlementAmount());
               dto.setPreSettlementAmount(projectIdPreSettlementAmountMap.get(dto.getId()));
               if (dto.getSettlementStatus().equals(SettlementStatusEnum.UN_SETTLED.getType())) {
                  dto.setCollectionRatio(dto.getAccumulatedCollection().divide(dto.getAmount(), 4, 4));
                  dto.setInvoiceRatio(dto.getAccumulatedInvoice().divide(dto.getAmount(), 4, 4));
                  if (financeAmountShowConfig.getBoolShowUnsettledUncollectedAmount()) {
                     BigDecimal advancesReceived = dto.getAmount().subtract(dto.getAccumulatedCollection());
                     dto.setAdvancesReceived(advancesReceived.compareTo(BigDecimal.ZERO) >= 0 ? advancesReceived : BigDecimal.ZERO);
                  }
               } else {
                  dto.setCollectionRatio(
                     dto.getSettlementAmount().compareTo(BigDecimal.ZERO) == 0
                        ? BigDecimal.ONE
                        : dto.getAccumulatedCollection().divide(dto.getSettlementAmount(), 4, 4)
                  );
                  dto.setInvoiceRatio(
                     dto.getSettlementAmount().compareTo(BigDecimal.ZERO) == 0
                        ? BigDecimal.ONE
                        : dto.getAccumulatedInvoice().divide(dto.getSettlementAmount(), 4, 4)
                  );
                  BigDecimal advancesReceived = dto.getSettlementAmount().subtract(dto.getAccumulatedCollection());
                  dto.setAdvancesReceived(advancesReceived.compareTo(BigDecimal.ZERO) >= 0 ? advancesReceived : BigDecimal.ZERO);
               }
            }
         }
      );
      return new PageVO<>(ledgerDTOS);
   }

   private Long getSecondCompanySupplier(List<BranchCompany> branchCompanyList, Boolean boolTwoLevelUnit, Long branchCompanyId) {
      if (!boolTwoLevelUnit) {
         return null;
      }

      BranchCompany company;
      if (branchCompanyId != null) {
         company = branchCompanyList.stream().filter(bc -> bc.getId().equals(branchCompanyId)).findFirst().orElse(null);
      } else {
         company = branchCompanyList.stream().filter(bc -> bc.getLevel().equals(BranchCompanyLevelEnum.SECONDARY_UNIT.getType())).findFirst().orElse(null);
      }

      if (company != null && !company.getLevel().equals(BranchCompanyLevelEnum.PRIMARY_UNIT.getType())) {
         Supplier supplier = this.supplierService.getOne(Wrappers.lambdaQuery(Supplier.class).eq(Supplier::getName, company.getName()));
         return supplier != null ? supplier.getId() : null;
      } else {
         return null;
      }
   }

   private Map<Long, BigDecimal> getProjectAccumulatedCostMap(Collection<Long> projectIds, Integer level) {
      if (level != null && !level.equals(BranchCompanyLevelEnum.SECONDARY_UNIT.getType())) {
         List<Long> primaryUnitCompanyIds = this.branchCompanyService
            .list(Wrappers.lambdaQuery(BranchCompany.builder().level(level).build()))
            .stream()
            .map(BranchCompany::getId)
            .collect(Collectors.toList());
         if (primaryUnitCompanyIds.isEmpty()) {
            return Collections.emptyMap();
         }

         List<PurchaseOrder> purchaseOrderList = this.purchaseOrderService
            .list(
               Wrappers.lambdaQuery(PurchaseOrder.class)
                  .eq(PurchaseOrder::getLevel, level)
                  .in(PurchaseOrder::getBranchCompanyId, primaryUnitCompanyIds)
                  .in(PurchaseOrder::getProjectIds, projectIds.stream().map(String::valueOf).collect(Collectors.toList()))
            );
         List<PurchaseOrder> unSettleOrderList = purchaseOrderList.stream()
            .filter(s -> !SettlementStatusEnum.SETTLED.getType().equals(s.getSettlementStatus()))
            .collect(Collectors.toList());
         Map<Long, BigDecimal> unSettleOrderCostMap = new HashMap<>(unSettleOrderList.size());
         if (CollectionUtils.isNotEmpty(unSettleOrderList)) {
            List<Long> unSettleOrderIds = unSettleOrderList.stream().map(PurchaseOrder::getId).collect(Collectors.toList());
            Map<Long, BigDecimal> orderIdPaymentAmountMap = this.supplierPaymentService
               .list(
                  Wrappers.lambdaQuery(SupplierPayment.class)
                     .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
                     .in(
                        SupplierPayment::getPropertyType,
                        SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(),
                        SupplierPropertyTypeEnum.PURCHASE_FEE.getType()
                     )
                     .in(SupplierPayment::getOrderId, unSettleOrderIds)
               )
               .stream()
               .collect(
                  Collectors.groupingBy(
                     SupplierPayment::getOrderId, Collectors.reducing(BigDecimal.ZERO, SupplierPayment::getActuallyPaymentAmount, BigDecimal::add)
                  )
               );
            Map<Long, BigDecimal> orderIdPreSettleAmountMap = this.supplierSettlementService
               .list(
                  Wrappers.lambdaQuery(SupplierSettlement.class)
                     .eq(SupplierSettlement::getBoolPreSettlement, true)
                     .eq(SupplierSettlement::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
                     .in(SupplierSettlement::getOrderClass, OrderClassEnum.MATERIAL_ORDER.getType(), OrderClassEnum.MANUFACTURE_ORDER.getType())
                     .in(SupplierSettlement::getOrderId, unSettleOrderIds)
               )
               .stream()
               .collect(
                  Collectors.groupingBy(SupplierSettlement::getOrderId, Collectors.reducing(BigDecimal.ZERO, SupplierSettlement::getAmount, BigDecimal::add))
               );
            unSettleOrderIds.forEach(orderId -> {
               BigDecimal paymentAmount = orderIdPaymentAmountMap.getOrDefault(orderId, BigDecimal.ZERO);
               BigDecimal preSettleAmount = orderIdPreSettleAmountMap.getOrDefault(orderId, BigDecimal.ZERO);
               unSettleOrderCostMap.put(orderId, Collections.max(Arrays.asList(paymentAmount, preSettleAmount)));
            });
         }

         Map<Long, BigDecimal> projectPaymentAmountMap = purchaseOrderList.stream()
            .collect(
               Collectors.groupingBy(
                  s -> Long.parseLong(s.getProjectIds()),
                  Collectors.mapping(
                     po -> SettlementStatusEnum.SETTLED.getType().equals(po.getSettlementStatus())
                        ? po.getSettlementAmount()
                        : unSettleOrderCostMap.get(po.getId()),
                     Collectors.reducing(BigDecimal.ZERO, BigDecimal::add)
                  )
               )
            );
         List<SubcontractOrder> subcontractOrderList = this.subcontractOrderService
            .list(
               Wrappers.lambdaQuery(SubcontractOrder.class)
                  .eq(SubcontractOrder::getLevel, level)
                  .in(SubcontractOrder::getBranchCompanyId, primaryUnitCompanyIds)
                  .in(SubcontractOrder::getProjectId, projectIds)
            );
         List<SubcontractOrder> unSettleSubOrderList = subcontractOrderList.stream().filter(s -> !s.getBoolSettlementStatus()).collect(Collectors.toList());
         Map<Long, BigDecimal> unSettleSubOrderCostMap = new HashMap<>(unSettleSubOrderList.size());
         if (CollectionUtils.isNotEmpty(unSettleSubOrderList)) {
            List<Long> unSettleOrderIds = unSettleSubOrderList.stream().map(SubcontractOrder::getId).collect(Collectors.toList());
            Map<Long, BigDecimal> orderIdPaymentAmountMap = this.supplierPaymentService
               .list(
                  Wrappers.lambdaQuery(SupplierPayment.class)
                     .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
                     .eq(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
                     .in(SupplierPayment::getOrderId, unSettleOrderIds)
               )
               .stream()
               .collect(
                  Collectors.groupingBy(
                     SupplierPayment::getOrderId, Collectors.reducing(BigDecimal.ZERO, SupplierPayment::getActuallyPaymentAmount, BigDecimal::add)
                  )
               );
            Map<Long, BigDecimal> orderIdPreSettleAmountMap = this.supplierSettlementService
               .list(
                  Wrappers.lambdaQuery(SupplierSettlement.class)
                     .eq(SupplierSettlement::getBoolPreSettlement, true)
                     .eq(SupplierSettlement::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
                     .eq(SupplierSettlement::getOrderClass, OrderClassEnum.SUB_ORDER.getType())
                     .in(SupplierSettlement::getOrderId, unSettleOrderIds)
               )
               .stream()
               .collect(
                  Collectors.groupingBy(SupplierSettlement::getOrderId, Collectors.reducing(BigDecimal.ZERO, SupplierSettlement::getAmount, BigDecimal::add))
               );
            unSettleOrderIds.forEach(orderId -> {
               BigDecimal paymentAmount = orderIdPaymentAmountMap.getOrDefault(orderId, BigDecimal.ZERO);
               BigDecimal preSettleAmount = orderIdPreSettleAmountMap.getOrDefault(orderId, BigDecimal.ZERO);
               unSettleSubOrderCostMap.put(orderId, Collections.max(Arrays.asList(paymentAmount, preSettleAmount)));
            });
         }

         Map<Long, BigDecimal> projectSubPaymentAmountMap = subcontractOrderList.stream()
            .collect(
               Collectors.groupingBy(
                  SubcontractOrder::getProjectId,
                  Collectors.mapping(
                     po -> po.getBoolSettlementStatus() ? po.getSettlementAmount() : unSettleSubOrderCostMap.get(po.getId()),
                     Collectors.reducing(BigDecimal.ZERO, BigDecimal::add)
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
         Map<Long, BigDecimal> projectCostMap = new HashMap<>(256);
         projectIds.forEach(projectId -> {
            BigDecimal paymentAmount = projectPaymentAmountMap.getOrDefault(projectId, BigDecimal.ZERO);
            BigDecimal subPaymentAmount = projectSubPaymentAmountMap.getOrDefault(projectId, BigDecimal.ZERO);
            BigDecimal reimbursementAmount = projectReimbursementFeeMap.getOrDefault(projectId, BigDecimal.ZERO);
            projectCostMap.put(projectId, paymentAmount.add(subPaymentAmount).add(reimbursementAmount));
         });
         return projectCostMap;
      } else {
         return Collections.emptyMap();
      }
   }

   @Override
   public ProjectSelfSupportCostReportDTO getSelfSupportCost(Long projectId, Integer year) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!");
      BranchCompany branchCompany = this.branchCompanyService.getById(project.getContractSignBodyId());
      Preconditions.checkArgument(branchCompany != null, "项目签订主体不存在!");
      Preconditions.checkArgument(branchCompany.getBranchAttributeEnum().equals(BranchAttributeEnum.INSTALLATION.getType()), "该项目不支持此查看累计成本!!");
      List<ProjectMaterialsAllDto> materialCostList = this.getMaterialCostList(projectId);
      BigDecimal totalCost = materialCostList.stream().map(ProjectMaterialsAllDto::getCost).reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal totalMaterialAmount = materialCostList.stream()
         .map(s -> s.getSettlementAmount() != null && s.getSettlementAmount().compareTo(BigDecimal.ZERO) != 0 ? s.getSettlementAmount() : s.getContractAmount())
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      List<ProjectMaterialsAllDto> subCostList = this.getSubCostList(projectId, null);
      BigDecimal subTotalCost = subCostList.stream().map(ProjectMaterialsAllDto::getCost).reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal totalSubAmount = subCostList.stream()
         .map(s -> s.getSettlementAmount() != null && s.getSettlementAmount().compareTo(BigDecimal.ZERO) != 0 ? s.getSettlementAmount() : s.getContractAmount())
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      List<ContractReimbursementFee> reimbursementFeeList = this.reimbursementFeeService
         .list(Wrappers.lambdaQuery(ContractReimbursementFee.class).eq(ContractReimbursementFee::getBranchCompanyId, project.getContractSignBodyId()));
      List<ContractReimbursementFee> projectFeeList = reimbursementFeeList.stream()
         .filter(a -> project.getId().equals(a.getProjectId()))
         .collect(Collectors.toList());
      BigDecimal onReimbursementAmount = projectFeeList.stream()
         .map(ContractReimbursementFee::getReimbursementAmount)
         .filter(ObjectUtils::isNotEmpty)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      List<ProjectExpenseCostReportDTO> costReportDTOS = new ArrayList<>();
      BigDecimal totalAmount = totalCost.add(subTotalCost).add(onReimbursementAmount);
      costReportDTOS.add(
         ProjectExpenseCostReportDTO.builder()
            .costType(CostTypeEnum.MATERIAL_COST.getType())
            .costTypeName(CostTypeEnum.MATERIAL_COST.getName())
            .amount(totalCost)
            .proportion(
               totalAmount.compareTo(BigDecimal.ZERO) > 0
                  ? totalCost.multiply(BigDecimal.valueOf(100L)).divide(totalAmount, 2, RoundingMode.HALF_UP)
                  : BigDecimal.ZERO
            )
            .build()
      );
      Map<Integer, BigDecimal> subBasicClassAmountMap = subCostList.stream()
         .collect(
            Collectors.groupingBy(ProjectMaterialsAllDto::getBasicClass, Collectors.reducing(BigDecimal.ZERO, ProjectMaterialsAllDto::getCost, BigDecimal::add))
         );
      costReportDTOS.add(
         ProjectExpenseCostReportDTO.builder()
            .costType(CostTypeEnum.SERVICE_COST.getType())
            .costTypeName(CostTypeEnum.SERVICE_COST.getName())
            .amount(subBasicClassAmountMap.getOrDefault(SubSupplyTypeEnum.LABOR_SUPPLY.getType().intValue(), BigDecimal.ZERO))
            .proportion(
               totalAmount.compareTo(BigDecimal.ZERO) > 0
                  ? subBasicClassAmountMap.getOrDefault(SubSupplyTypeEnum.LABOR_SUPPLY.getType().intValue(), BigDecimal.ZERO)
                     .multiply(BigDecimal.valueOf(100L))
                     .divide(totalAmount, 2, RoundingMode.HALF_UP)
                  : BigDecimal.ZERO
            )
            .build()
      );
      BigDecimal subAmount1 = subBasicClassAmountMap.getOrDefault(SubSupplyTypeEnum.MATERIAL_SUPPLY.getType().intValue(), BigDecimal.ZERO);
      BigDecimal subAmount2 = subBasicClassAmountMap.getOrDefault(SubSupplyTypeEnum.QUALITYI_NSPECTION.getType().intValue(), BigDecimal.ZERO);
      costReportDTOS.add(
         ProjectExpenseCostReportDTO.builder()
            .costType(CostTypeEnum.SUBCONTRACTING_COST.getType())
            .costTypeName(CostTypeEnum.SUBCONTRACTING_COST.getName())
            .amount(subAmount1.add(subAmount2))
            .proportion(
               totalAmount.compareTo(BigDecimal.ZERO) > 0
                  ? subAmount1.add(subAmount2).multiply(BigDecimal.valueOf(100L)).divide(totalAmount, 2, RoundingMode.HALF_UP)
                  : BigDecimal.ZERO
            )
            .build()
      );
      BigDecimal subAmount3 = subBasicClassAmountMap.getOrDefault(SubSupplyTypeEnum.CONSTRUCTION_MEASURES.getType().intValue(), BigDecimal.ZERO);
      BigDecimal subAmount4 = subBasicClassAmountMap.getOrDefault(SubSupplyTypeEnum.RENTAL_SERVICE.getType().intValue(), BigDecimal.ZERO);
      costReportDTOS.add(
         ProjectExpenseCostReportDTO.builder()
            .costType(CostTypeEnum.LEASE_CHARGE.getType())
            .costTypeName(CostTypeEnum.LEASE_CHARGE.getName())
            .amount(subAmount3.add(subAmount4))
            .proportion(
               totalAmount.compareTo(BigDecimal.ZERO) > 0
                  ? subAmount3.add(subAmount4).multiply(BigDecimal.valueOf(100L)).divide(totalAmount, 2, RoundingMode.HALF_UP)
                  : BigDecimal.ZERO
            )
            .build()
      );
      costReportDTOS.add(
         ProjectExpenseCostReportDTO.builder()
            .costType(CostTypeEnum.PERIOD_EXPENSE.getType())
            .costTypeName(CostTypeEnum.PERIOD_EXPENSE.getName())
            .amount(onReimbursementAmount.setScale(2, RoundingMode.HALF_UP))
            .proportion(
               totalAmount.compareTo(BigDecimal.ZERO) > 0
                  ? onReimbursementAmount.multiply(BigDecimal.valueOf(100L)).divide(totalAmount, 2, RoundingMode.HALF_UP)
                  : BigDecimal.ZERO
            )
            .build()
      );
      Long projectManagerId = project.getSalesLeaderId() != null ? project.getSalesLeaderId() : project.getSignerId();
      ProjectInfo projectInfo = ProjectInfo.builder()
         .id(projectId)
         .shortName(project.getShortName())
         .name(project.getName())
         .serialNumber(project.getSerialNumber())
         .projectManagerId(projectManagerId)
         .projectManagerName(this.userService.getNameById(projectManagerId))
         .signDate(project.getSigningDate() != null ? project.getSigningDate() : project.getCreateTime().toLocalDate())
         .signingDate(project.getSigningDate() != null ? project.getSigningDate() : project.getCreateTime().toLocalDate())
         .projectAttribute(project.getProjectAttribute())
         .build();
      BigDecimal materialTotalPaid = materialCostList.stream().map(ProjectMaterialsAllDto::getTotalPaid).reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal remainingAdvances = totalMaterialAmount.add(totalSubAmount).subtract(materialTotalPaid).subtract(subTotalCost);
      BigDecimal profit = project.getCollectionAmount().subtract(totalAmount);
      BigDecimal profitRate = project.getSettlementStatus().equals(SettlementStatusEnum.UN_SETTLED.getType())
         ? profit.multiply(new BigDecimal(100)).divide(project.getContractAmount(), 2, RoundingMode.HALF_UP)
         : profit.multiply(new BigDecimal(100)).divide(project.getSettlementAmount(), 2, RoundingMode.HALF_UP);
      return ProjectSelfSupportCostReportDTO.builder()
         .project(projectInfo)
         .totalIncome(project.getCollectionAmount())
         .advancesReceived(
            project.getContractAmount().subtract(project.getCollectionAmount()).compareTo(BigDecimal.ZERO) >= 0
               ? project.getContractAmount().subtract(project.getCollectionAmount())
               : BigDecimal.ZERO
         )
         .remainingAdvances(remainingAdvances.compareTo(BigDecimal.ZERO) >= 0 ? remainingAdvances.setScale(2, RoundingMode.HALF_UP) : BigDecimal.ZERO)
         .sendingUnit(project.getCustomerUnit())
         .signDate(project.getSigningDate())
         .contractAmount(project.getContractAmount())
         .settlementAmount(project.getSettlementAmount() != null ? project.getSettlementAmount().setScale(2, RoundingMode.HALF_UP) : BigDecimal.ZERO)
         .totalExpenditure(totalAmount.setScale(2, RoundingMode.HALF_UP))
         .costSubjectCost(costReportDTOS)
         .profit(profit.setScale(2, RoundingMode.HALF_UP))
         .profitRate(profitRate)
         .materialExpenditure(materialCostList)
         .build();
   }

   @Override
   public void getSelfSupportCostDownload(Long projectId, Integer year, HttpServletResponse response) {
      ContractProject project = this.projectService.getById(projectId);
      ProjectSelfSupportCostReportDTO selfSupportCost = this.getSelfSupportCost(projectId, year);
      Map<String, Object> map = new HashMap<>();
      map.put("projectName", project.getSerialNumber() + " " + project.getName());
      map.put("signDate", project.getSigningDate() != null ? project.getSigningDate() : project.getCreateTime().toLocalDate());
      Long userId = ObjectUtils.isNotEmpty(project.getSignerId()) ? project.getSignerId() : project.getProjectManagerId();
      map.put("projectManagerName", ObjectUtils.isNotEmpty(userId) ? this.userService.getById(userId).getName() : null);
      map.put("contractAmount", selfSupportCost.getContractAmount());
      map.put("settlementAmount", selfSupportCost.getSettlementAmount());
      map.put("totalIncome", selfSupportCost.getTotalIncome());
      map.put("advancesReceived", selfSupportCost.getAdvancesReceived());
      map.put("totalExpenditure", selfSupportCost.getTotalExpenditure());
      map.put("remainingAdvances", selfSupportCost.getRemainingAdvances());
      map.put("sendingUnit", selfSupportCost.getSendingUnit());
      Map<Integer, ProjectExpenseCostReportDTO> costTypeMap = selfSupportCost.getCostSubjectCost()
         .stream()
         .collect(Collectors.toMap(ProjectExpenseCostReportDTO::getCostType, Function.identity()));
      Arrays.stream(CostTypeEnum.values())
         .forEach(
            em -> {
               ProjectExpenseCostReportDTO costReportDto = costTypeMap.get(em.getType());
               map.put(
                  "amount_" + em.getType(),
                  costReportDto != null ? costReportDto.getAmount().setScale(2, RoundingMode.HALF_UP) : BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP)
               );
               map.put(
                  "proportion_" + em.getType(),
                  costReportDto != null ? costReportDto.getProportion().setScale(2, RoundingMode.HALF_UP) : BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP)
               );
            }
         );
      String resourcePath = "files/cost.xlsx";
      String tempFileName = "cost";
      String exportFileName = project.getSerialNumber() + project.getShortName() + ".xlsx";
      ClassPathResource resource = new ClassPathResource(resourcePath);
      File file = null;

      try (InputStream inputStream = resource.getInputStream()) {
         file = File.createTempFile(tempFileName, "xlsx");
         FileUtil.copyInputStreamToFile(inputStream, file);
      } catch (IOException e) {
         e.printStackTrace();
      }

      TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath(), true);
      params.setColForEach(true);
      Workbook workbook = ExcelExportUtil.exportExcel(params, map);
      PoiUtils.downLoadExcel(exportFileName, response, workbook);
   }

   @Override
   public PrintVO getSelfSupportCostDetailDownload(Long projectId, Integer year) {
      PrintVO<List<ProjectMaterialsAllDto>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      List<ProjectMaterialsAllDto> materialCostList = this.getMaterialCostList(projectId);
      printVO.setHeader(header);
      printVO.setTable(materialCostList);
      return printVO;
   }

   @Override
   public List<ProjectMaterialsAllDto> getSelfSupportCostDetailList(Long projectId, Integer costTypeEnum) {
      if (costTypeEnum.equals(CostTypeEnum.MATERIAL_COST.getType())) {
         return this.getMaterialCostList(projectId);
      } else if (costTypeEnum.equals(CostTypeEnum.OTHER_COST.getType())) {
         return Collections.emptyList();
      } else {
         return costTypeEnum.equals(CostTypeEnum.PERIOD_EXPENSE.getType()) ? Collections.emptyList() : this.getSubCostList(projectId, costTypeEnum);
      }
   }

   @Override
   public PrintVO<List<ProjectMaterialsAllDto>> printSelfSupportCostDetailList(Long projectId, Integer costTypeEnum) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!");
      BranchCompany branchCompany = this.branchCompanyService.getById(project.getContractSignBodyId());
      Preconditions.checkArgument(branchCompany != null, "项目签订主体不存在!");
      PrintVO<List<ProjectMaterialsAllDto>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      header.put(
         "project",
         ProjectInfo.builder().id(projectId).name(project.getName()).shortName(project.getShortName()).serialNumber(project.getSerialNumber()).build()
      );
      header.put("signingDate", project.getSigningDate() != null ? project.getSigningDate() : project.getCreateTime().toLocalDate());
      Long salesLeaderId = project.getSalesLeaderId() != null ? project.getSalesLeaderId() : project.getSignerId();
      header.put("salesLeader", this.userService.getNameById(salesLeaderId));
      header.put(
         "projectStatus",
         project.getSettlementStatus().equals(SettlementStatusEnum.SETTLED.getType()) ? "已结算" : ProjectStatusEnum.getNameByType(project.getStatus())
      );
      header.put("customerUnit", project.getCustomerUnit());
      header.put("branchCompany", branchCompany.getName());
      BigDecimal accumulatedCollection = this.collectionService
         .listCollectionLedger(projectId, project.getContractSignBodyId())
         .stream()
         .map(ContractCollection::getCollectionAmount)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      header.put("accumulatedCollection", accumulatedCollection);
      BigDecimal accumulatedInvoice = this.invoiceService
         .listPageLedger(projectId, project.getContractSignBodyId())
         .stream()
         .map(ContractInvoice::getActualInvoiceAmount)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      header.put("accumulatedInvoice", accumulatedInvoice);
      List<ProjectMaterialsAllDto> materialCostList = this.getMaterialCostList(projectId);
      BigDecimal materialPaymentAmount = materialCostList.stream().map(ProjectMaterialsAllDto::getTotalPaid).reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal totalMaterialAmount = materialCostList.stream()
         .map(s -> s.getSettlementAmount() != null && s.getSettlementAmount().compareTo(BigDecimal.ZERO) != 0 ? s.getSettlementAmount() : s.getContractAmount())
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      List<ProjectMaterialsAllDto> subCostList = this.getSubCostList(projectId, null);
      BigDecimal subPaymentAmount = subCostList.stream().map(ProjectMaterialsAllDto::getTotalPaid).reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal totalSubAmount = subCostList.stream()
         .map(s -> s.getSettlementAmount() != null && s.getSettlementAmount().compareTo(BigDecimal.ZERO) != 0 ? s.getSettlementAmount() : s.getContractAmount())
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      header.put("totalExpenditure", materialPaymentAmount.add(subPaymentAmount).setScale(2, RoundingMode.HALF_UP));
      header.put(
         "remainingAdvances",
         totalMaterialAmount.add(totalSubAmount).subtract(materialPaymentAmount).subtract(subPaymentAmount).setScale(2, RoundingMode.HALF_UP)
      );
      header.put("contractAmount", project.getContractAmount());
      header.put("settlementAmount", project.getSettlementAmount());
      BigDecimal advancesReceived = project.getSettlementStatus().equals(SettlementStatusEnum.UN_SETTLED.getType())
         ? project.getContractAmount().subtract(accumulatedCollection)
         : project.getSettlementAmount().subtract(accumulatedCollection);
      header.put("advancesReceived", advancesReceived.compareTo(BigDecimal.ZERO) >= 0 ? advancesReceived : BigDecimal.ZERO);
      List<ProjectMaterialsAllDto> dtoList = this.getSelfSupportCostDetailList(projectId, costTypeEnum);
      printVO.setTable(dtoList);
      return printVO;
   }

   private List<ProjectMaterialsAllDto> getMaterialCostList(Long projectId) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!");
      List<PurchaseOrder> orderList = this.purchaseOrderService
         .list(
            Wrappers.lambdaQuery(PurchaseOrder.class)
               .eq(PurchaseOrder::getProjectAttribute, ProjectAttributeEnum.SELF_SUPPORT.getType())
               .eq(PurchaseOrder::getReviewStatus, AuditStatusEnum.SUCCEED.getType())
               .eq(PurchaseOrder::getProjectIds, String.valueOf(projectId))
               .eq(PurchaseOrder::getBranchCompanyId, project.getContractSignBodyId())
               .eq(PurchaseOrder::getDataStatus, 2)
         );
      if (orderList.isEmpty()) {
         return Collections.emptyList();
      }

      Map<Long, Supplier> supplierMap = this.supplierService
         .listByIds(orderList.stream().map(PurchaseOrder::getSupplierId).collect(Collectors.toSet()))
         .stream()
         .collect(Collectors.toMap(Supplier::getId, Function.identity()));
      List<Long> orderIds = orderList.stream().map(PurchaseOrder::getId).collect(Collectors.toList());
      List<SupplierPayment> supplierPaymentList = this.supplierPaymentService
         .list(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .in(SupplierPayment::getOrderId, orderIds)
               .in(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(), SupplierPropertyTypeEnum.PURCHASE_FEE.getType())
               .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         );
      Map<Long, BigDecimal> orderIdPaymentAmountMap = supplierPaymentList.stream()
         .collect(
            Collectors.groupingBy(SupplierPayment::getOrderId, Collectors.reducing(BigDecimal.ZERO, SupplierPayment::getActuallyPaymentAmount, BigDecimal::add))
         );
      Map<Long, BigDecimal> orderIdPreSettlementAmountMap = this.supplierSettlementService
         .list(
            Wrappers.lambdaQuery(SupplierSettlement.class)
               .in(SupplierSettlement::getOrderId, orderIds)
               .eq(SupplierSettlement::getBoolPreSettlement, true)
               .in(SupplierSettlement::getOrderClass, OrderClassEnum.MATERIAL_ORDER.getType(), OrderClassEnum.MANUFACTURE_ORDER.getType())
               .eq(SupplierSettlement::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         )
         .stream()
         .collect(Collectors.groupingBy(SupplierSettlement::getOrderId, Collectors.reducing(BigDecimal.ZERO, SupplierSettlement::getAmount, BigDecimal::add)));
      List<ProjectMaterialsAllDto> dtoList = new ArrayList<>(16);
      orderList.forEach(
         a -> {
            BigDecimal paymentAmount = orderIdPaymentAmountMap.getOrDefault(a.getId(), BigDecimal.ZERO);
            BigDecimal totalAmount = a.getSettlementStatus().equals(SettlementStatusEnum.UN_SETTLED.getType()) ? a.getAmount() : a.getSettlementAmount();
            BigDecimal preSettlementAmount = orderIdPreSettlementAmountMap.getOrDefault(a.getId(), BigDecimal.ZERO);
            ProjectMaterialsAllDto materialsAllDto = ProjectMaterialsAllDto.builder()
               .id(a.getId())
               .basicClass(a.getBasicClass())
               .supplierId(a.getSupplierId())
               .signingDate(a.getCreateTime())
               .status(a.getSettlementStatus())
               .statusName(
                  SettlementStatusEnum.SETTLED.getType().equals(a.getSettlementStatus())
                     ? SettlementStatusEnum.SETTLED.getName()
                     : SettlementStatusEnum.UN_SETTLED.getName()
               )
               .supplierName(supplierMap.get(a.getSupplierId()).getName())
               .serialNumber(a.getSerialNumber())
               .contractAmount(a.getAmount())
               .settlementStatus(a.getSettlementStatus())
               .settlementAmount(a.getSettlementAmount())
               .preSettlementAmount(orderIdPreSettlementAmountMap.get(a.getId()))
               .totalPaid(paymentAmount)
               .cost(
                  a.getSettlementStatus().equals(SettlementStatusEnum.SETTLED.getType())
                     ? a.getSettlementAmount()
                     : Collections.max(Arrays.asList(paymentAmount, preSettlementAmount))
               )
               .unpaid(totalAmount.subtract(paymentAmount).compareTo(BigDecimal.ZERO) >= 0 ? totalAmount.subtract(paymentAmount) : BigDecimal.ZERO)
               .build();
            dtoList.add(materialsAllDto);
         }
      );
      return dtoList;
   }

   private List<ProjectMaterialsAllDto> getSubCostList(Long projectId, Integer costTypeEnum) {
      List<SubcontractOrder> subcontractOrderList = this.subcontractOrderService
         .list(
            Wrappers.lambdaQuery(SubcontractOrder.class)
               .eq(SubcontractOrder::getProjectId, projectId)
               .eq(
                  costTypeEnum != null && costTypeEnum.equals(CostTypeEnum.SERVICE_COST.getType()),
                  SubcontractOrder::getSubcontractClassId,
                  SubSupplyTypeEnum.LABOR_SUPPLY.getType()
               )
               .in(
                  costTypeEnum != null && costTypeEnum.equals(CostTypeEnum.SUBCONTRACTING_COST.getType()),
                  SubcontractOrder::getSubcontractClassId,
                  SubSupplyTypeEnum.MATERIAL_SUPPLY.getType(),
                  SubSupplyTypeEnum.QUALITYI_NSPECTION.getType()
               )
               .in(
                  costTypeEnum != null && costTypeEnum.equals(CostTypeEnum.LEASE_CHARGE.getType()),
                  SubcontractOrder::getSubcontractClassId,
                  SubSupplyTypeEnum.CONSTRUCTION_MEASURES.getType(),
                  SubSupplyTypeEnum.RENTAL_SERVICE.getType()
               )
               .orderByDesc(SubcontractOrder::getId)
         );
      if (subcontractOrderList.isEmpty()) {
         return Collections.emptyList();
      }

      List<Long> subOrderIds = subcontractOrderList.stream().map(SubcontractOrder::getId).collect(Collectors.toList());
      Map<Long, BigDecimal> orderIdPaymentAmountMap = this.supplierPaymentService
         .list(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .in(SupplierPayment::getOrderId, subOrderIds)
               .eq(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
               .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         )
         .stream()
         .collect(
            Collectors.groupingBy(SupplierPayment::getOrderId, Collectors.reducing(BigDecimal.ZERO, SupplierPayment::getActuallyPaymentAmount, BigDecimal::add))
         );
      Map<Long, BigDecimal> orderIdPreSettlementAmountMap = this.supplierSettlementService
         .list(
            Wrappers.lambdaQuery(SupplierSettlement.class)
               .in(SupplierSettlement::getOrderId, subOrderIds)
               .eq(SupplierSettlement::getBoolPreSettlement, true)
               .in(SupplierSettlement::getOrderClass, OrderClassEnum.SUB_ORDER.getType())
               .eq(SupplierSettlement::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         )
         .stream()
         .collect(Collectors.groupingBy(SupplierSettlement::getOrderId, Collectors.reducing(BigDecimal.ZERO, SupplierSettlement::getAmount, BigDecimal::add)));
      return subcontractOrderList.stream()
         .map(
            order -> {
               BigDecimal totalPaid = orderIdPaymentAmountMap.getOrDefault(order.getId(), BigDecimal.ZERO);
               BigDecimal amount = order.getBoolSettlementStatus() ? order.getSettlementAmount() : order.getAmount();
               BigDecimal preSettlementAmount = orderIdPreSettlementAmountMap.getOrDefault(order.getId(), BigDecimal.ZERO);
               BigDecimal unpaid = amount.subtract(totalPaid);
               return ProjectMaterialsAllDto.builder()
                  .id(order.getId())
                  .basicClass(order.getSubcontractClassId().intValue())
                  .signingDate(order.getSignDate().atStartOfDay())
                  .supplierId(order.getSupplierId())
                  .supplierName(order.getSupplierName())
                  .serialNumber(order.getSerialNumber())
                  .contractAmount(order.getAmount())
                  .settlementAmount(order.getSettlementAmount())
                  .preSettlementAmount(orderIdPreSettlementAmountMap.get(order.getId()))
                  .totalPaid(totalPaid)
                  .cost(order.getBoolSettlementStatus() ? order.getSettlementAmount() : Collections.max(Arrays.asList(totalPaid, preSettlementAmount)))
                  .unpaid(unpaid.compareTo(BigDecimal.ZERO) >= 0 ? unpaid.setScale(2, RoundingMode.HALF_UP) : BigDecimal.ZERO)
                  .build();
            }
         )
         .collect(Collectors.toList());
   }

   @Override
   public List<ProjectLedgerSupplierInvoiceDetailDTO> getSelfSupportCostPaymentList(Long orderId, Integer costTypeEnum) {
      if (!costTypeEnum.equals(CostTypeEnum.PERIOD_EXPENSE.getType()) && !costTypeEnum.equals(CostTypeEnum.OTHER_COST.getType())) {
         LambdaQueryWrapper<SupplierPayment> wrapper = Wrappers.lambdaQuery(SupplierPayment.class)
            .eq(SupplierPayment::getOrderId, orderId)
            .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
            .orderByDesc(SupplierPayment::getPaymentDate)
            .orderByDesc(SupplierPayment::getId);
         if (costTypeEnum.equals(CostTypeEnum.MATERIAL_COST.getType())) {
            wrapper.in(
               SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(), SupplierPropertyTypeEnum.PURCHASE_FEE.getType()
            );
         } else {
            wrapper.eq(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType());
         }

         List<SupplierPayment> supplierPaymentList = this.supplierPaymentService.list(wrapper);
         return supplierPaymentList.stream()
            .map(
               s -> ProjectLedgerSupplierInvoiceDetailDTO.builder()
                  .number(s.getApprovalSerialNumber())
                  .paymentDate(s.getPaymentDate().atStartOfDay())
                  .paymentAmount(s.getActuallyPaymentAmount())
                  .type(s.getPaymentReasonId() != null ? Integer.valueOf(s.getPaymentReasonId()) : null)
                  .build()
            )
            .collect(Collectors.toList());
      } else {
         return Collections.emptyList();
      }
   }

   @Override
   public PrintVO<List<ProjectLedgerSupplierInvoiceDetailDTO>> printSelfSupportCostPaymentList(Long orderId, Integer costTypeEnum) {
      Preconditions.checkArgument(
         !costTypeEnum.equals(CostTypeEnum.PERIOD_EXPENSE.getType()) && !costTypeEnum.equals(CostTypeEnum.OTHER_COST.getType()), "成本类型参数有误!"
      );
      Long projectId;
      Long supplierId;
      String serialNumber;
      BigDecimal amount;
      Boolean settleStatus;
      BigDecimal settleAmount;
      if (costTypeEnum.equals(CostTypeEnum.MATERIAL_COST.getType())) {
         PurchaseOrder purchaseOrder = this.purchaseOrderService.getById(orderId);
         Preconditions.checkArgument(purchaseOrder != null, "材料订单不存在!");
         projectId = Long.valueOf(purchaseOrder.getProjectIds());
         supplierId = purchaseOrder.getSupplierId();
         serialNumber = purchaseOrder.getSerialNumber();
         amount = purchaseOrder.getAmount();
         settleStatus = SettlementStatusEnum.SETTLED.getType().equals(purchaseOrder.getSettlementStatus());
         settleAmount = purchaseOrder.getSettlementAmount();
      } else {
         SubcontractOrder subcontractOrder = this.subcontractOrderService.getById(orderId);
         Preconditions.checkArgument(subcontractOrder != null, "分包订单不存在!");
         projectId = subcontractOrder.getProjectId();
         supplierId = subcontractOrder.getSupplierId();
         serialNumber = subcontractOrder.getSerialNumber();
         amount = subcontractOrder.getAmount();
         settleStatus = subcontractOrder.getBoolSettlementStatus();
         settleAmount = subcontractOrder.getSettlementAmount();
      }

      ContractProject project = this.projectService.getById(projectId);
      BranchCompany branchCompany = this.branchCompanyService.getById(project.getContractSignBodyId());
      Preconditions.checkArgument(branchCompany != null, "项目签定主体不存在!");
      Supplier supplier = this.supplierService.getById(supplierId);
      Preconditions.checkArgument(supplier != null, "供应商不存在!");
      PrintVO<List<ProjectLedgerSupplierInvoiceDetailDTO>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      header.put(
         "project",
         ProjectInfo.builder().id(projectId).name(project.getName()).shortName(project.getShortName()).serialNumber(project.getSerialNumber()).build()
      );
      header.put("signingDate", project.getSigningDate() != null ? project.getSigningDate() : project.getCreateTime().toLocalDate());
      Long salesLeaderId = project.getSalesLeaderId() != null ? project.getSalesLeaderId() : project.getSignerId();
      header.put("salesLeader", this.userService.getNameById(salesLeaderId));
      header.put(
         "projectStatus",
         project.getSettlementStatus().equals(SettlementStatusEnum.SETTLED.getType()) ? "已结算" : ProjectStatusEnum.getNameByType(project.getStatus())
      );
      header.put("customerUnit", project.getCustomerUnit());
      header.put("branchCompany", branchCompany.getName());
      BigDecimal accumulatedCollection = this.collectionService
         .listCollectionLedger(projectId, project.getContractSignBodyId())
         .stream()
         .map(ContractCollection::getCollectionAmount)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      header.put("accumulatedCollection", accumulatedCollection);
      BigDecimal accumulatedInvoice = this.invoiceService
         .listPageLedger(projectId, project.getContractSignBodyId())
         .stream()
         .map(ContractInvoice::getActualInvoiceAmount)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      header.put("accumulatedInvoice", accumulatedInvoice);
      header.put("amount", project.getContractAmount());
      header.put("settlementAmount", project.getSettlementAmount());
      BigDecimal advancesReceived = project.getSettlementStatus().equals(SettlementStatusEnum.UN_SETTLED.getType())
         ? project.getContractAmount().subtract(accumulatedCollection)
         : project.getSettlementAmount().subtract(accumulatedCollection);
      header.put("advancesReceived", advancesReceived.compareTo(BigDecimal.ZERO) >= 0 ? advancesReceived : BigDecimal.ZERO);
      List<ProjectMaterialsAllDto> materialCostList = this.getMaterialCostList(projectId);
      BigDecimal materialPaymentAmount = materialCostList.stream().map(ProjectMaterialsAllDto::getTotalPaid).reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal totalMaterialAmount = materialCostList.stream()
         .map(s -> s.getSettlementAmount() != null && s.getSettlementAmount().compareTo(BigDecimal.ZERO) != 0 ? s.getSettlementAmount() : s.getContractAmount())
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      List<ProjectMaterialsAllDto> subCostList = this.getSubCostList(projectId, null);
      BigDecimal subPaymentAmount = subCostList.stream().map(ProjectMaterialsAllDto::getTotalPaid).reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal totalSubAmount = subCostList.stream()
         .map(s -> s.getSettlementAmount() != null && s.getSettlementAmount().compareTo(BigDecimal.ZERO) != 0 ? s.getSettlementAmount() : s.getContractAmount())
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      header.put("totalExpenditure", materialPaymentAmount.add(subPaymentAmount).setScale(2, RoundingMode.HALF_UP));
      header.put(
         "remainingAdvances",
         totalMaterialAmount.add(totalSubAmount).subtract(materialPaymentAmount).subtract(subPaymentAmount).setScale(2, RoundingMode.HALF_UP)
      );
      List<ProjectLedgerSupplierInvoiceDetailDTO> selfSupportCostPaymentList = this.getSelfSupportCostPaymentList(orderId, costTypeEnum);
      header.put("orderSupplier", supplier.getName());
      header.put("orderSerialNumber", serialNumber);
      header.put("orderAmount", amount);
      header.put("orderSettlementAmount", settleAmount);
      BigDecimal totalPaid = selfSupportCostPaymentList.stream()
         .map(ProjectLedgerSupplierInvoiceDetailDTO::getPaymentAmount)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      header.put("totalPaid", totalPaid);
      BigDecimal unPaid = settleStatus ? settleAmount.subtract(totalPaid) : amount.subtract(totalPaid);
      header.put("unPaid", unPaid.compareTo(BigDecimal.ZERO) >= 0 ? unPaid : BigDecimal.ZERO);
      printVO.setTable(selfSupportCostPaymentList);
      return printVO;
   }

   @Override
   public List<ProjectCostReportDto> getSelfSupportCostReport(Long projectId, Integer year) {
      List<ContractProject> projectList = this.projectService
         .list(
            Wrappers.lambdaQuery(ContractProject.class)
               .eq(ContractProject::getProjectAttribute, ProjectAttributeEnum.SELF_SUPPORT.getType())
               .eq(ObjectUtils.isNotEmpty(projectId), ContractProject::getId, projectId)
         );
      if (CollectionUtils.isEmpty(projectList)) {
         return null;
      }

      Map<Long, Supplier> supplierMap = this.supplierService.list().stream().collect(Collectors.toMap(Supplier::getId, Function.identity()));
      List<ProjectCostReportDto> reportDtos = new ArrayList<>();
      List<PurchaseOrder> orderList = this.purchaseOrderService
         .list(
            Wrappers.lambdaQuery(PurchaseOrder.class)
               .eq(PurchaseOrder::getProjectAttribute, ProjectAttributeEnum.SELF_SUPPORT.getType())
               .eq(PurchaseOrder::getReviewStatus, AuditStatusEnum.SUCCEED.getType())
               .apply(year != null, "year(signing_time) = {0}", year)
         );
      List<PurchaseOrder> list = new ArrayList<>();
      orderList.forEach(order -> {
         if (ObjectUtils.isNotEmpty(order.getProjectIds())) {
            if (order.getProjectIds().contains(",")) {
               String[] split = order.getProjectIds().split(",");

               for (int i = 0; i < split.length; i++) {
                  PurchaseOrder copy = BeanUtil.copy(order, PurchaseOrder.class);
                  copy.setProjectIds(split[i]);
                  list.add(copy);
               }
            } else {
               list.add(order);
            }
         }
      });
      Map<Long, List<Long>> idMap = new HashMap<>();
      Map<String, List<PurchaseOrder>> collect = list.stream().collect(Collectors.groupingBy(PurchaseOrder::getProjectIds));
      collect.forEach((k, v) -> idMap.put(Long.valueOf(k), v.stream().map(PurchaseOrder::getId).collect(Collectors.toList())));
      List<ProjectMaterialsAllDto> listDTO = new ArrayList<>();

      for (ContractProject project : projectList) {
         BigDecimal actuallyPaymentAmount = BigDecimal.ZERO;
         if (CollectionUtils.isNotEmpty(orderList)) {
            List<Long> longs = idMap.get(project.getId());
            if (CollectionUtils.isNotEmpty(longs)) {
               List<SupplierPayment> payments = this.supplierPaymentService
                  .list(
                     Wrappers.lambdaQuery(SupplierPayment.class)
                        .in(SupplierPayment::getOrderId, longs)
                        .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
                  );
               actuallyPaymentAmount = payments.stream().map(SupplierPayment::getActuallyPaymentAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
               Map<Long, BigDecimal> paymentAmount = payments.stream()
                  .collect(
                     Collectors.groupingBy(
                        SupplierPayment::getOrderId, Collectors.reducing(BigDecimal.ZERO, SupplierPayment::getActuallyPaymentAmount, BigDecimal::add)
                     )
                  );
               List<PurchaseOrder> orders = this.purchaseOrderService.list(Wrappers.lambdaQuery(PurchaseOrder.class).in(PurchaseOrder::getId, longs));
               orders.forEach(
                  a -> listDTO.add(
                     ProjectMaterialsAllDto.builder()
                        .id(a.getId())
                        .status(a.getSettlementStatus())
                        .statusName(
                           SettlementStatusEnum.SETTLED.getType().equals(a.getSettlementStatus())
                              ? SettlementStatusEnum.SETTLED.getName()
                              : SettlementStatusEnum.UN_SETTLED.getName()
                        )
                        .supplierName(supplierMap.get(a.getSupplierId()).getName())
                        .serialNumber(a.getSerialNumber())
                        .contractAmount(a.getAmount())
                        .settlementAmount(a.getSettlementStatus().equals(SettlementStatusEnum.SETTLED.getType()) ? a.getSettlementAmount() : BigDecimal.ZERO)
                        .totalPaid(paymentAmount.getOrDefault(a.getId(), BigDecimal.ZERO))
                        .unpaid(
                           a.getAmount().compareTo(paymentAmount.getOrDefault(a.getId(), BigDecimal.ZERO)) >= 0
                              ? a.getAmount().subtract(paymentAmount.getOrDefault(a.getId(), BigDecimal.ZERO))
                              : BigDecimal.ZERO
                        )
                        .build()
                  )
               );
            }
         }

         reportDtos.add(
            ProjectCostReportDto.builder()
               .orderId(project.getId())
               .project(
                  ProjectInfo.builder()
                     .id(projectId)
                     .shortName(project.getShortName())
                     .name(project.getName())
                     .serialNumber(project.getSerialNumber())
                     .projectManagerId(project.getSalesLeaderId())
                     .build()
               )
               .contractAmount(project.getContractAmount())
               .settlementAmount(project.getSettlementStatus().equals(SettlementStatusEnum.SETTLED.getType()) ? project.getSettlementAmount() : BigDecimal.ZERO)
               .totalExpenditure(actuallyPaymentAmount)
               .materialCost(actuallyPaymentAmount)
               .subcontractCost(BigDecimal.ZERO)
               .leaseCost(BigDecimal.ZERO)
               .otherCost(BigDecimal.ZERO)
               .indirectCost(BigDecimal.ZERO)
               .profit(project.getCollectionSummary().subtract(actuallyPaymentAmount))
               .profitRate(
                  project.getCollectionSummary()
                     .subtract(actuallyPaymentAmount)
                     .divide(project.getContractAmount(), 2, RoundingMode.HALF_UP)
                     .multiply(new BigDecimal(100))
               )
               .materialExpenditure(listDTO)
               .build()
         );
      }

      return reportDtos;
   }

   @Override
   public ProjectLedgerSeltSupportPaymentDto getSeltSupportPayment(Long projectId) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(project), "项目不存在");
      BranchCompany company = this.branchCompanyService.getById(project.getContractSignBodyId());
      Map<Long, User> userMap = this.userService.list().stream().collect(Collectors.toMap(User::getId, Function.identity()));
      List<PurchaseOrder> orderList = this.purchaseOrderService
         .list(
            Wrappers.lambdaQuery(PurchaseOrder.class)
               .isNotNull(PurchaseOrder::getProjectIds)
               .eq(PurchaseOrder::getReviewStatus, AuditStatusEnum.SUCCEED.getType())
         )
         .stream()
         .filter(order -> Arrays.asList(order.getProjectIds().split(",")).contains(projectId.toString()))
         .collect(Collectors.toList());
      List<Long> longList = orderList.stream().map(PurchaseOrder::getId).collect(Collectors.toList());
      List<SupplierPayment> paymentList = this.supplierPaymentService
         .list(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .eq(SupplierPayment::getOrderId, longList)
         );
      Map<Long, List<SupplierPayment>> paymentMap = paymentList.stream().collect(Collectors.groupingBy(SupplierPayment::getOrderId));
      Map<Long, Supplier> supplierMap = this.supplierService.list().stream().collect(Collectors.toMap(Supplier::getId, Function.identity()));
      List<ProjectLedgerSeltSupportPaymentDetailDto> detailDtos = new ArrayList<>();
      orderList.forEach(
         order -> {
            BigDecimal amount = BigDecimal.ZERO;
            if (ObjectUtils.isNotEmpty(paymentMap.get(order.getId()))) {
               amount = paymentMap.get(order.getId())
                  .stream()
                  .map(SupplierPayment::getActuallyPaymentAmount)
                  .filter(Objects::nonNull)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
            }

            ProjectLedgerSeltSupportPaymentDetailDto build = ProjectLedgerSeltSupportPaymentDetailDto.builder()
               .supplier(SupplierInfo.builder().supplierId(order.getSupplierId()).supplierName(supplierMap.get(order.getSupplierId()).getName()).build())
               .contractAmount(order.getAmount())
               .settlementAmount(order.getSettlementStatus().equals(SettlementStatusEnum.SETTLED.getType()) ? order.getSettlementAmount() : BigDecimal.ZERO)
               .totalPayment(amount)
               .totalUnpaid(
                  order.getSettlementStatus().equals(SettlementStatusEnum.SETTLED.getType())
                     ? order.getSettlementAmount().subtract(amount)
                     : order.getAmount().subtract(amount)
               )
               .build();
            detailDtos.add(build);
         }
      );
      Long userId = project.getProjectAttribute().equals(ProjectAttributeEnum.SELF_SUPPORT.getType())
         ? project.getSalesLeaderId()
         : project.getProjectManagerId();
      return ProjectLedgerSeltSupportPaymentDto.builder()
         .project(ProjectInfo.builder().id(projectId).serialNumber(project.getSerialNumber()).name(project.getName()).shortName(project.getShortName()).build())
         .createDate(project.getSigningDate().atStartOfDay())
         .signer(ObjectUtils.isNotEmpty(company) ? NameInfo.builder().id(project.getContractSignBodyId()).name(company.getName()).build() : null)
         .contractAmount(project.getContractAmount())
         .user(NameInfo.builder().id(userMap.get(userId).getId()).name(userMap.get(userId).getName()).build())
         .businessType(project.getBusinessType())
         .projectStatus(project.getStatus())
         .detail(detailDtos)
         .build();
   }

   @Override
   public PrintVO getSeltSupportPaymentDownload(Long projectId) {
      ProjectLedgerSeltSupportPaymentDto seltSupportPayment = this.getSeltSupportPayment(projectId);
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      Map<String, Object> stringObjectMap = BeanUtil.beanToMap(seltSupportPayment);
      header.putAll(stringObjectMap);
      printVO.setHeader(header);
      printVO.setTable(seltSupportPayment.getDetail().stream().map(a -> BeanUtil.beanToMap(a)).collect(Collectors.toList()));
      return printVO;
   }

   @Override
   public List<ProjectSimpleInfoDTO> getProjectAttributeList(String projectAttribute, Long projectManagerId, Integer year, Integer level) {
      Boolean boolTwoLevelUnit = this.projectFinanceUtils.getBoolTwoLevelUnit();
      if (boolTwoLevelUnit) {
         Preconditions.checkArgument(level != null, "系统版本未知!无法操作!");
      } else {
         level = null;
      }

      List<Integer> list = new ArrayList<>();
      if (StringUtils.isNotBlank(projectAttribute)) {
         list = Arrays.stream(projectAttribute.split(",")).map(Integer::valueOf).collect(Collectors.toList());
      }

      SecurityUser currentUser = UserUtil.getCurrentUser();
      List<Long> projectIds = null;
      if (!currentUser.isAdmin()) {
         projectIds = this.projectUserLinkService
            .list(Wrappers.lambdaQuery(ProjectUserLink.builder().userId(currentUser.getId()).build()))
            .stream()
            .map(ProjectUserLink::getProjectId)
            .collect(Collectors.toList());
         if (projectIds.isEmpty()) {
            return Collections.emptyList();
         }
      }

      List<ContractProject> projects = this.projectService
         .list(
            Wrappers.lambdaQuery(ContractProject.class)
               .orderByDesc(ContractProject::getId)
               .in(projectIds != null, ContractProject::getId, projectIds)
               .in(CollectionUtils.isNotEmpty(list), ContractProject::getProjectAttribute, list)
               .apply(ObjectUtils.isNotEmpty(year), "YEAR(create_time) = {0}", year)
               .apply(ObjectUtils.isNotEmpty(level), "level & {0} > 0", level)
               .eq(ObjectUtils.isNotEmpty(projectManagerId), ContractProject::getProjectManagerId, projectManagerId)
         );
      List<Long> submitSettleProjectIds = this.contractAuditLedgerService
         .list(
            Wrappers.lambdaQuery(ContractAuditLedger.class)
               .eq(ContractAuditLedger::getPaymentEnum, AuditPaymentEnum.PROJECT_SETTLEMENT.getType())
               .eq(ContractAuditLedger::getAuditStatusEnum, AuditStatusEnum.AUDITING.getType())
         )
         .stream()
         .map(ContractAuditLedger::getProjectId)
         .map(Long::valueOf)
         .collect(Collectors.toList());
      Map<Long, User> userMap = this.userService.list().stream().collect(Collectors.toMap(User::getId, Function.identity()));
      List<ProjectSimpleInfoDTO> projectSimpleInfoDTOS = new ArrayList<>();
      projects.forEach(
         project -> {
            ProjectSimpleInfoDTO infoDTO = new ProjectSimpleInfoDTO();
            User user = !project.getProjectAttribute().equals(ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType())
               ? userMap.get(project.getSalesLeaderId())
               : userMap.get(project.getProjectManagerId());
            infoDTO.setProjectManagerName(user != null ? user.getName() : "/");
            infoDTO.setProjectManagerId(project.getProjectManagerId());
            infoDTO.setSerialNumber(project.getSerialNumber());
            infoDTO.setName(project.getName());
            infoDTO.setShortName(project.getShortName());
            boolean boolSettle = project.getSettlementStatus().equals(SettlementStatusEnum.SETTLED.getType())
               || submitSettleProjectIds.contains(project.getId());
            infoDTO.setSettlementStatus(boolSettle ? SettlementStatusEnum.SETTLED.getType() : SettlementStatusEnum.UN_SETTLED.getType());
            User signerUser = userMap.get(project.getSignerId());
            infoDTO.setSignerName(signerUser != null ? signerUser.getName() : "/");
            infoDTO.setId(project.getId());
            projectSimpleInfoDTOS.add(infoDTO);
         }
      );
      return projectSimpleInfoDTOS;
   }

   @Override
   public List<ProjectInfo> getProjectFilter(Integer projectAttribute, Integer level, Long branchCompanyId) {
      Boolean boolTwoLevelUnit = this.projectFinanceUtils.getBoolTwoLevelUnit();
      if (boolTwoLevelUnit) {
         Preconditions.checkArgument(level != null, "单位等级未知!无法操作!");
      } else {
         level = null;
      }

      List<ContractProject> projectList = this.projectService
         .list(
            Wrappers.lambdaQuery(ContractProject.class)
               .orderByDesc(ContractProject::getId)
               .eq(projectAttribute != null, ContractProject::getProjectAttribute, projectAttribute)
               .apply(level != null, "level & {0} > 0", level)
         );
      return projectList.stream().map(project -> BeanUtil.copy(project, ProjectInfo.class)).collect(Collectors.toList());
   }

   @Override
   public List<PeriodCostDTO> getPeriodCostDetail(Long projectId) {
      Map<Long, BranchCompany> branchCompanyMap = this.branchCompanyService
         .list(Wrappers.lambdaQuery(BranchCompany.builder().level(BranchCompanyLevelEnum.PRIMARY_UNIT.getType()).build()))
         .stream()
         .collect(Collectors.toMap(BranchCompany::getId, Function.identity()));
      List<ContractReimbursementFee> reimbursementFees = this.reimbursementFeeService
         .list(Wrappers.lambdaQuery(ContractReimbursementFee.class).eq(ContractReimbursementFee::getProjectId, projectId))
         .stream()
         .filter(r -> branchCompanyMap.containsKey(r.getBranchCompanyId()))
         .collect(Collectors.toList());
      if (reimbursementFees.isEmpty()) {
         return Collections.emptyList();
      }

      Map<Long, ContractExpenseType> expenseTypeMap = this.contractExpenseTypeService
         .list()
         .stream()
         .collect(Collectors.toMap(ContractExpenseType::getId, Function.identity()));
      Set<Long> userIds = new HashSet<>(16);
      userIds.addAll(reimbursementFees.stream().map(ContractReimbursementFee::getReimburserId).collect(Collectors.toSet()));
      userIds.addAll(reimbursementFees.stream().map(ContractReimbursementFee::getWrittenById).collect(Collectors.toSet()));
      Map<Long, String> userMap = this.userService.listByIds(userIds).stream().collect(Collectors.toMap(User::getId, User::getName));
      List<PeriodCostDTO> dtoList = new ArrayList<>(16);
      reimbursementFees.forEach(
         fee -> {
            ContractExpenseType expenseType = expenseTypeMap.get(fee.getExpenseTypeId());
            PeriodCostDTO periodCostDTO = PeriodCostDTO.builder()
               .date(fee.getReimbursementDate())
               .informant(NameInfo.builder().id(fee.getWrittenById()).name(userMap.get(fee.getWrittenById())).build())
               .reimburseUser(NameInfo.builder().id(fee.getReimburserId()).name(userMap.get(fee.getReimburserId())).build())
               .reimburseAmount(fee.getReimbursementAmount())
               .summary(expenseType != null ? expenseType.getName() : "")
               .build();
            dtoList.add(periodCostDTO);
         }
      );
      return dtoList;
   }

   @Override
   public PrintVO getSelfSupportCostDetail(Long projectId, Integer year) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!");
      BranchCompany branchCompany = this.branchCompanyService.getById(project.getContractSignBodyId());
      Preconditions.checkArgument(branchCompany != null, "项目签订主体不存在!");
      PrintVO<List<PeriodCostDTO>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put(
         "project",
         ProjectInfo.builder().id(projectId).name(project.getName()).shortName(project.getShortName()).serialNumber(project.getSerialNumber()).build()
      );
      header.put("signingDate", project.getSigningDate() != null ? project.getSigningDate() : project.getCreateTime().toLocalDate());
      Long salesLeaderId = project.getSalesLeaderId() != null ? project.getSalesLeaderId() : project.getSignerId();
      header.put("salesLeader", this.userService.getNameById(salesLeaderId));
      header.put(
         "projectStatus",
         project.getSettlementStatus().equals(SettlementStatusEnum.SETTLED.getType()) ? "已结算" : ProjectStatusEnum.getNameByType(project.getStatus())
      );
      header.put("customerUnit", project.getCustomerUnit());
      header.put("branchCompany", branchCompany.getName());
      BigDecimal accumulatedCollection = this.collectionService
         .listCollectionLedger(projectId, project.getContractSignBodyId())
         .stream()
         .map(ContractCollection::getCollectionAmount)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      header.put("accumulatedCollection", accumulatedCollection);
      BigDecimal accumulatedInvoice = this.invoiceService
         .listPageLedger(projectId, project.getContractSignBodyId())
         .stream()
         .map(ContractInvoice::getActualInvoiceAmount)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      header.put("accumulatedInvoice", accumulatedInvoice);
      header.put("amount", project.getContractAmount());
      header.put("settlementAmount", project.getSettlementAmount());
      BigDecimal advancesReceived = project.getSettlementStatus().equals(SettlementStatusEnum.UN_SETTLED.getType())
         ? project.getContractAmount().subtract(accumulatedCollection)
         : project.getSettlementAmount().subtract(accumulatedCollection);
      header.put("advancesReceived", advancesReceived.compareTo(BigDecimal.ZERO) >= 0 ? advancesReceived : BigDecimal.ZERO);
      List<ProjectMaterialsAllDto> materialCostList = this.getMaterialCostList(projectId);
      BigDecimal materialPaymentAmount = materialCostList.stream().map(ProjectMaterialsAllDto::getTotalPaid).reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal totalMaterialAmount = materialCostList.stream()
         .map(s -> s.getSettlementAmount() != null && s.getSettlementAmount().compareTo(BigDecimal.ZERO) != 0 ? s.getSettlementAmount() : s.getContractAmount())
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      List<ProjectMaterialsAllDto> subCostList = this.getSubCostList(projectId, null);
      BigDecimal subPaymentAmount = subCostList.stream().map(ProjectMaterialsAllDto::getTotalPaid).reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal totalSubAmount = subCostList.stream()
         .map(s -> s.getSettlementAmount() != null && s.getSettlementAmount().compareTo(BigDecimal.ZERO) != 0 ? s.getSettlementAmount() : s.getContractAmount())
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      header.put("totalExpenditure", materialPaymentAmount.add(subPaymentAmount).setScale(2, RoundingMode.HALF_UP));
      header.put(
         "remainingAdvances",
         totalMaterialAmount.add(totalSubAmount).subtract(materialPaymentAmount).subtract(subPaymentAmount).setScale(2, RoundingMode.HALF_UP)
      );
      List<PeriodCostDTO> periodCostDetail = this.getPeriodCostDetail(projectId);
      printVO.setHeader(header);
      printVO.setTable(periodCostDetail);
      return printVO;
   }

   @Override
   public PageVO<ProjectLedgerV2DTO> projectManagerLedger(
      LocalDateTime startDate,
      LocalDateTime endDate,
      String projectAttribute,
      Long projectManagerId,
      Long projectId,
      String projectName,
      Integer settlementStatus,
      Integer pageNumber,
      Integer pageSize
   ) {
      PageHelper.startPage(pageNumber, pageSize);
      Integer intStartYear = startDate != null ? startDate.getYear() : null;
      Integer intEndYear = endDate != null ? endDate.getYear() : null;
      List<ContractProject> projectList = this.projectService
         .list(
            Wrappers.lambdaQuery(ContractProject.class)
               .in(ContractProject::getProjectAttribute, ProjectAttributeEnum.JOINT_VENTURE.getType(), ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType())
               .eq(ObjectUtils.isNotNull(projectManagerId), ContractProject::getProjectManagerId, projectManagerId)
               .eq(ObjectUtils.isNotNull(projectId), ContractProject::getId, projectId)
               .eq(ObjectUtils.isNotNull(projectAttribute), ContractProject::getProjectAttribute, projectAttribute)
               .eq(settlementStatus != null && settlementStatus < ProjectStatusEnum.SETTLED.getType(), ContractProject::getStatus, settlementStatus)
               .eq(
                  settlementStatus != null && settlementStatus.equals(ProjectStatusEnum.SETTLED.getType()),
                  ContractProject::getSettlementStatus,
                  SettlementStatusEnum.SETTLED.getType()
               )
               .apply(intStartYear != null, "YEAR(signing_date) >= {0}", intStartYear)
               .apply(intEndYear != null, "YEAR(signing_date) <= {0}", intEndYear)
               .apply(StringUtils.isNotBlank(projectName), "(name like '%" + projectName + "%' or short_name like '%" + projectName + "%')")
         );
      if (CollectionUtils.isEmpty(projectList)) {
         return new PageVO<>();
      }

      List<Long> projectIds = projectList.stream().map(ContractProject::getId).collect(Collectors.toList());
      Map<Long, BigDecimal> collectionMap = this.contractCollectionService
         .list(
            Wrappers.lambdaQuery(ContractCollection.class)
               .in(ContractCollection::getProjectId, projectIds)
               .eq(ContractCollection::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         )
         .stream()
         .collect(
            Collectors.groupingBy(
               ContractCollection::getProjectId, Collectors.reducing(BigDecimal.ZERO, ContractCollection::getCollectionAmount, BigDecimal::add)
            )
         );
      Map<Long, BigDecimal> invoiceMap = this.invoiceService
         .list(
            Wrappers.lambdaQuery(ContractInvoice.class)
               .in(ContractInvoice::getProjectId, projectIds)
               .eq(ContractInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         )
         .stream()
         .collect(
            Collectors.groupingBy(ContractInvoice::getProjectId, Collectors.reducing(BigDecimal.ZERO, ContractInvoice::getActualInvoiceAmount, BigDecimal::add))
         );
      List<PurchaseOrder> orderList = this.purchaseOrderService
         .list(
            Wrappers.lambdaQuery(PurchaseOrder.class)
               .in(PurchaseOrder::getProjectAttribute, ProjectAttributeEnum.JOINT_VENTURE.getType(), ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType())
               .in(PurchaseOrder::getProjectIds, projectIds.stream().map(String::valueOf).collect(Collectors.toList()))
         );
      Map<Long, List<SubcontractOrder>> subcontractOrderMap = this.subcontractOrderService
         .list(Wrappers.lambdaQuery(SubcontractOrder.class).in(SubcontractOrder::getProjectId, projectIds))
         .stream()
         .collect(Collectors.groupingBy(SubcontractOrder::getProjectId, Collectors.toList()));
      List<SecurityDepositAndManagementCost> costList = this.securityDepositAndManagementCostService
         .list(Wrappers.lambdaQuery(SecurityDepositAndManagementCost.class).eq(SecurityDepositAndManagementCost::getProjectId, projectIds));
      Map<Long, Map<Integer, List<SecurityDepositAndManagementCost>>> costMap = costList.stream()
         .collect(Collectors.groupingBy(SecurityDepositAndManagementCost::getProjectId, Collectors.groupingBy(SecurityDepositAndManagementCost::getAmountType)));
      Map<Long, BigDecimal> givingCreditMap = this.contractGivingCreditService
         .list(Wrappers.lambdaQuery(ContractGivingCredit.class).eq(ContractGivingCredit::getStatus, 0).in(ContractGivingCredit::getProjectId, projectIds))
         .stream()
         .collect(
            Collectors.groupingBy(
               ContractGivingCredit::getProjectId,
               Collectors.mapping(ContractGivingCredit::getLineOfCredit, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))
            )
         );
      List<ContractProjectAssetInjection> assetInjectionList = this.injectorService
         .list(Wrappers.lambdaQuery(ContractProjectAssetInjection.class).in(ContractProjectAssetInjection::getProjectId, projectIds));
      Map<Long, BigDecimal> injectionAmountMap = assetInjectionList.stream()
         .filter(ContractProjectAssetInjection::getIncomeOrDisburse)
         .collect(
            Collectors.groupingBy(
               ContractProjectAssetInjection::getProjectId,
               Collectors.mapping(
                  s -> s.getContractSignBodyScale() != null && s.getContractSignBodyScale().compareTo(BigDecimal.ZERO) != 0
                     ? s.getContractSignBodyScale()
                     : s.getProjectManagerScale(),
                  Collectors.reducing(BigDecimal.ZERO, BigDecimal::add)
               )
            )
         );
      Map<Long, BigDecimal> outInjectionAmountMap = assetInjectionList.stream()
         .filter(s -> !s.getIncomeOrDisburse())
         .collect(
            Collectors.groupingBy(
               ContractProjectAssetInjection::getProjectId,
               Collectors.mapping(
                  s -> s.getContractSignBodyScale() != null && s.getContractSignBodyScale().compareTo(BigDecimal.ZERO) != 0
                     ? s.getContractSignBodyScale()
                     : s.getProjectManagerScale(),
                  Collectors.reducing(BigDecimal.ZERO, BigDecimal::add)
               )
            )
         );
      Map<Long, User> userMap = this.userService.list().stream().collect(Collectors.toMap(User::getId, Function.identity()));
      List<ProjectLedgerV2DTO> dtoList = new ArrayList<>();

      for (ContractProject project : projectList) {
         BigDecimal totalInjectionAmount = injectionAmountMap.getOrDefault(project.getId(), BigDecimal.ZERO);
         BigDecimal totalOutjectionAmount = outInjectionAmountMap.getOrDefault(project.getId(), BigDecimal.ZERO);
         List<Long> orderIds = orderList.stream()
            .filter(a -> Arrays.asList(a.getProjectIds()).contains(project.getId().toString()))
            .map(PurchaseOrder::getId)
            .collect(Collectors.toList());
         BigDecimal paymentAmount = BigDecimal.ZERO;
         if (CollectionUtils.isNotEmpty(orderIds)) {
            BigDecimal amount = this.supplierPaymentService
               .list(
                  Wrappers.lambdaQuery(SupplierPayment.class)
                     .in(SupplierPayment::getOrderId, orderIds)
                     .eq(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType())
                     .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               )
               .stream()
               .map(SupplierPayment::getActuallyPaymentAmount)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            paymentAmount = paymentAmount.add(amount);
         }

         if (CollectionUtils.isNotEmpty(subcontractOrderMap.get(project.getId()))) {
            BigDecimal amount = this.supplierPaymentService
               .list(
                  Wrappers.lambdaQuery(SupplierPayment.class)
                     .in(
                        SupplierPayment::getOrderId,
                        subcontractOrderMap.get(project.getId()).stream().map(SubcontractOrder::getId).collect(Collectors.toList())
                     )
                     .eq(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
                     .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               )
               .stream()
               .map(SupplierPayment::getActuallyPaymentAmount)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            paymentAmount = paymentAmount.add(amount);
         }

         ProjectInfo projectInfo = ProjectInfo.builder()
            .id(project.getId())
            .projectManagerName(userMap.get(project.getProjectManagerId()).getName())
            .name(project.getName())
            .shortName(project.getShortName())
            .signingDate(project.getSigningDate())
            .projectAttribute(project.getProjectAttribute())
            .serialNumber(project.getSerialNumber())
            .build();
         ProjectLedgerV2DTO build = ProjectLedgerV2DTO.builder()
            .project(projectInfo)
            .contractAmount(project.getContractAmount())
            .status(project.getStatus())
            .settlementAmount(project.getSettlementStatus().equals(SettlementStatusEnum.SETTLED.getType()) ? project.getSettlementAmount() : null)
            .collectionAmountSum(collectionMap.get(project.getId()))
            .invoiceAmountSum(invoiceMap.get(project.getId()))
            .paymentAmountSum(paymentAmount)
            .injectionAmount(totalInjectionAmount)
            .creditAmount(givingCreditMap.getOrDefault(project.getId(), BigDecimal.ZERO))
            .projectSummary(project.getCollectionSummary())
            .build();
         if (ObjectUtils.isNotEmpty(costMap.get(project.getId()))) {
            List<SecurityDepositAndManagementCost> securityDeductList = costMap.get(project.getId()).get(1);
            List<SecurityDepositAndManagementCost> managementRecordList = costMap.get(project.getId()).get(2);
            if (CollectionUtils.isNotEmpty(securityDeductList)) {
               BigDecimal securityDeductIncome = securityDeductList.stream()
                  .map(SecurityDepositAndManagementCost::getSecurityDeductIncome)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal securityRecord = securityDeductList.stream()
                  .map(SecurityDepositAndManagementCost::getSecurityRecord)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal managementDeductIncome = managementRecordList.stream()
                  .map(SecurityDepositAndManagementCost::getManagementDeductIncome)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal managementRecord = managementRecordList.stream()
                  .map(SecurityDepositAndManagementCost::getManagementRecord)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               build.setPaymentAmountSum(
                  build.getPaymentAmountSum().add(securityDeductIncome.subtract(securityRecord)).add(managementDeductIncome.subtract(managementRecord))
               );
            }
         }

         dtoList.add(build);
      }

      return new PageVO<>(PageUtils.getPageInfo(dtoList, projectList));
   }

   @Override
   public PageVO<projectManagerLedgerDisburseDetailDTO> projectManagerLedgerDisburseDetail(
      Long projectId, LocalDateTime startDate, LocalDateTime endDate, Integer pageNumber, Integer pageSize
   ) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(project), "项目不存在");
      List<projectManagerLedgerDisburseDetailDTO> dto = new ArrayList<>();
      List<ContractCollection> collectionList = this.contractCollectionService
         .list(
            Wrappers.lambdaQuery(ContractCollection.class)
               .eq(ContractCollection::getProjectId, projectId)
               .apply(ObjectUtils.isNotNull(startDate), "date_format(create_time,'%Y-%m-%d') >= date_format({0},'%Y-%m-%d')", startDate)
               .apply(ObjectUtils.isNotNull(endDate), "date_format(create_time,'%Y-%m-%d') <= date_format({0},'%Y-%m-%d')", endDate)
               .orderByDesc(BaseEntity::getCreateTime)
         );
      if (CollectionUtils.isNotEmpty(collectionList)) {
         dto.addAll(
            collectionList.stream()
               .map(
                  a -> projectManagerLedgerDisburseDetailDTO.builder()
                     .project(
                        ProjectInfo.builder()
                           .id(project.getId())
                           .name(project.getName())
                           .serialNumber(project.getSerialNumber())
                           .shortName(project.getShortName())
                           .build()
                     )
                     .date(a.getCollectionDate().atStartOfDay())
                     .voucherNumber(a.getVoucherNumber())
                     .type("收款")
                     .summary(a.getPaymentUnit())
                     .income(a.getCollectionAmount())
                     .build()
               )
               .collect(Collectors.toList())
         );
      }

      List<PurchaseOrder> orderList = this.purchaseOrderService
         .list(
            Wrappers.lambdaQuery(PurchaseOrder.class)
               .eq(PurchaseOrder::getProjectIds, projectId)
               .ne(PurchaseOrder::getProjectAttribute, ProjectAttributeEnum.SELF_SUPPORT.getType())
         );
      if (CollectionUtils.isNotEmpty(orderList)) {
         List<SupplierPayment> paymentList = this.supplierPaymentService
            .list(
               Wrappers.lambdaQuery(SupplierPayment.class)
                  .eq(SupplierPayment::getProjectId, projectId)
                  .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
                  .eq(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType())
                  .apply(ObjectUtils.isNotNull(startDate), "date_format(audit_time,'%Y-%m-%d') >= date_format({0},'%Y-%m-%d')", startDate)
                  .apply(ObjectUtils.isNotNull(endDate), "date_format(audit_time,'%Y-%m-%d') <= date_format({0},'%Y-%m-%d')", endDate)
                  .orderByDesc(SupplierPayment::getAuditTime)
            );
         if (CollectionUtils.isNotEmpty(paymentList)) {
            Map<Long, Supplier> supplierMap = this.supplierService.list().stream().collect(Collectors.toMap(Supplier::getId, Function.identity()));
            dto.addAll(
               paymentList.stream()
                  .map(
                     a -> projectManagerLedgerDisburseDetailDTO.builder()
                        .project(
                           ProjectInfo.builder()
                              .id(project.getId())
                              .name(project.getName())
                              .serialNumber(project.getSerialNumber())
                              .shortName(project.getShortName())
                              .build()
                        )
                        .date(a.getAuditTime())
                        .voucherNumber(a.getApprovalSerialNumber())
                        .type("采购付款")
                        .summary(supplierMap.get(a.getSupplierId()).getShortName())
                        .expenditure(a.getActuallyPaymentAmount())
                        .balance(a.getResidualAmount())
                        .build()
                  )
                  .collect(Collectors.toList())
            );
         }
      }

      List<Long> subIds = this.subcontractOrderService
         .list(
            Wrappers.lambdaQuery(SubcontractOrder.class)
               .eq(SubcontractOrder::getProjectId, projectId)
               .eq(SubcontractOrder::getAuditTypeEnum, com.hzchum.scim.common.core.api.enums.AuditStatusEnum.SUCCEED.getType())
         )
         .stream()
         .map(SubcontractOrder::getId)
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(subIds)) {
         List<SupplierPayment> paymentList = this.supplierPaymentService
            .list(
               Wrappers.lambdaQuery(SupplierPayment.class)
                  .in(SupplierPayment::getOrderId, subIds)
                  .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
                  .eq(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
                  .apply(ObjectUtils.isNotNull(startDate), "date_format(audit_time,'%Y-%m-%d') >= date_format({0},'%Y-%m-%d')", startDate)
                  .apply(ObjectUtils.isNotNull(endDate), "date_format(audit_time,'%Y-%m-%d') <= date_format({0},'%Y-%m-%d')", endDate)
                  .orderByDesc(SupplierPayment::getAuditTime)
            );
         if (CollectionUtils.isNotEmpty(paymentList)) {
            Map<Long, Supplier> supplierMap = this.supplierService.list().stream().collect(Collectors.toMap(Supplier::getId, Function.identity()));
            dto.addAll(
               paymentList.stream()
                  .map(
                     a -> projectManagerLedgerDisburseDetailDTO.builder()
                        .project(
                           ProjectInfo.builder()
                              .id(project.getId())
                              .name(project.getName())
                              .serialNumber(project.getSerialNumber())
                              .shortName(project.getShortName())
                              .build()
                        )
                        .date(a.getAuditTime())
                        .voucherNumber(a.getApprovalSerialNumber())
                        .type("分包付款")
                        .summary(supplierMap.get(a.getSupplierId()).getShortName())
                        .expenditure(a.getActuallyPaymentAmount())
                        .balance(a.getResidualAmount())
                        .build()
                  )
                  .collect(Collectors.toList())
            );
         }
      }

      List<SecurityDepositAndManagementCost> costList = this.securityDepositAndManagementCostService
         .list(
            Wrappers.lambdaQuery(SecurityDepositAndManagementCost.class)
               .eq(SecurityDepositAndManagementCost::getProjectId, projectId)
               .apply(ObjectUtils.isNotNull(startDate), "date_format(create_time,'%Y-%m-%d') >= date_format({0},'%Y-%m-%d')", startDate)
               .apply(ObjectUtils.isNotNull(endDate), "date_format(create_time,'%Y-%m-%d') <= date_format({0},'%Y-%m-%d')", endDate)
               .orderByDesc(BaseEntity::getCreateTime)
         );
      if (CollectionUtils.isNotEmpty(costList)) {
         dto.addAll(
            costList.stream()
               .map(
                  a -> projectManagerLedgerDisburseDetailDTO.builder()
                     .project(
                        ProjectInfo.builder()
                           .id(project.getId())
                           .name(project.getName())
                           .serialNumber(project.getSerialNumber())
                           .shortName(project.getShortName())
                           .build()
                     )
                     .date(a.getCreateTime())
                     .voucherNumber(a.getVoucherNumber())
                     .type(a.getAmountType().equals(1) ? "保证金" : "管理费")
                     .summary(a.getAmountType().equals(1) ? "保证金" : "管理费")
                     .income(a.getAmountType().equals(1) ? a.getSecurityRecord() : a.getManagementRecord())
                     .expenditure(a.getAmountType().equals(1) ? a.getSecurityDeductIncome() : a.getManagementDeductIncome())
                     .balance(a.getResidualAmount())
                     .build()
               )
               .collect(Collectors.toList())
         );
      }

      List<ContractProjectAssetInjection> list = this.injectorService
         .list(
            Wrappers.lambdaQuery(ContractProjectAssetInjection.class)
               .eq(ContractProjectAssetInjection::getProjectId, projectId)
               .eq(ContractProjectAssetInjection::getIncomeOrDisburse, true)
               .apply(ObjectUtils.isNotNull(startDate), "date_format(create_time,'%Y-%m-%d') >= date_format({0},'%Y-%m-%d')", startDate)
               .apply(ObjectUtils.isNotNull(endDate), "date_format(create_time,'%Y-%m-%d') <= date_format({0},'%Y-%m-%d')", endDate)
         );
      if (CollectionUtils.isNotEmpty(list)) {
         Map<Long, SysDictionary> dictionaryMap = this.dictionaryService
            .list(Wrappers.lambdaQuery(SysDictionary.class).eq(SysDictionary::getName, DictionaryEnum.INJECTION_TYPE.getName()))
            .stream()
            .collect(Collectors.toMap(SysDictionary::getId, Function.identity()));
         dto.addAll(
            list.stream()
               .map(
                  a -> projectManagerLedgerDisburseDetailDTO.builder()
                     .project(
                        ProjectInfo.builder()
                           .id(project.getId())
                           .name(project.getName())
                           .serialNumber(project.getSerialNumber())
                           .shortName(project.getShortName())
                           .build()
                     )
                     .date(a.getAssetInjectionTime())
                     .voucherNumber(a.getVoucherNumber())
                     .type(a.getContractSignBodyId() != null ? "公司主体注资" : "项目经理注资")
                     .summary(a.getRemark())
                     .income(ObjectUtils.isNotEmpty(a.getProjectManagerScale()) ? a.getProjectManagerScale() : a.getContractSignBodyScale())
                     .balance(a.getResidualAmount())
                     .build()
               )
               .collect(Collectors.toList())
         );
      }

      List<ContractGivingCreditReturn> creditReturnList = this.givingCreditReturnService
         .list(
            Wrappers.lambdaQuery(ContractGivingCreditReturn.class)
               .eq(ContractGivingCreditReturn::getProjectId, projectId)
               .eq(ContractGivingCreditReturn::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         )
         .stream()
         .filter(s -> startDate == null || !s.getReturnTime().isBefore(startDate.toLocalDate().atStartOfDay()))
         .filter(s -> endDate == null || !s.getReturnTime().isAfter(endDate.toLocalDate().atStartOfDay()))
         .collect(Collectors.toList());
      List<projectManagerLedgerDisburseDetailDTO> returnDtoList = creditReturnList.stream()
         .map(
            r -> projectManagerLedgerDisburseDetailDTO.builder()
               .project(
                  ProjectInfo.builder()
                     .id(project.getId())
                     .name(project.getName())
                     .serialNumber(project.getSerialNumber())
                     .shortName(project.getShortName())
                     .build()
               )
               .date(r.getReturnTime())
               .expenditure(r.getAmount())
               .type("授信还款")
               .summary("授信还款")
               .build()
         )
         .collect(Collectors.toList());
      dto.addAll(returnDtoList);
      if (CollectionUtils.isEmpty(dto)) {
         return new PageVO<>();
      }

      dto.sort(Comparator.comparing(projectManagerLedgerDisburseDetailDTO::getDate).reversed());
      List<projectManagerLedgerDisburseDetailDTO> page = PageUtils.getPage(dto, pageNumber, pageSize);
      PageVO<projectManagerLedgerDisburseDetailDTO> objectPageVO = new PageVO<>(page);
      objectPageVO.setTotalElements(dto.size());
      return objectPageVO;
   }

   @Override
   public BigDecimal projectManagerLedgerDisburseDetailSummary(Long projectManagerId) {
      List<ContractProject> projectList = this.projectService
         .list(
            Wrappers.lambdaQuery(ContractProject.class)
               .eq(ContractProject::getProjectManagerId, projectManagerId)
               .eq(ContractProject::getProjectAttribute, ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType())
         );
      return projectList.stream().map(ContractProject::getProjectManagerAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
   }

   @Override
   public BigDecimal getContractAmountSum(ProjectListQueryParam queryParam) {
      List<ContractProjectListDTO> allProject = this.projectService.listProjectsByConditions(queryParam);
      return allProject.stream().map(ContractProjectListDTO::getContractAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
   }

   @Override
   public void downLoadImportProjectTemplate(HttpServletResponse response) {
      String resourcePath = "files/ProjectImportTemplate.xlsx";
      String exportFileName = "项目导入模板.xlsx";
      ClassPathResource resource = new ClassPathResource(resourcePath);
      File file = null;

      try (InputStream inputStream = resource.getInputStream()) {
         file = File.createTempFile(exportFileName, "xlsx");
         FileUtil.copyInputStreamToFile(inputStream, file);
      } catch (IOException e) {
         this.log.error("文件下载异常，请联系管理员, {}", e);
      }

      if (file != null) {
         FileUtil.downloadFile(file, exportFileName);
      }
   }

   @Transactional
   @Override
   public void importProject(MultipartFile file, HttpServletResponse response) {
      new ArrayList();
      List<MistakeExportDTO> mistakeExportDTOList = new ArrayList<>(1024);
      int titleRows = 1;
      int headerRows = 1;
      Integer startSheetIndex = 0;
      List<ProjectImportDTO> projectImportDTOS = PoiUtils.importExcel(file, titleRows, headerRows, startSheetIndex, ProjectImportDTO.class);
      List<ProjectSaveDTOParam> projectSaveDTOParams = this.checkImportParams(projectImportDTOS, mistakeExportDTOList, response);
      if (CollectionUtils.isNotEmpty(projectSaveDTOParams)) {
         projectSaveDTOParams.forEach(this::saveContract);
         response.setHeader("result", "code=20000;message=" + org.springframework.web.util.UriUtils.encode("导入成功", java.nio.charset.StandardCharsets.UTF_8));
         response.setHeader("Access-Control-Expose-Headers", "result");
      }

      exportMistakeList(mistakeExportDTOList, response);
   }

   private List<ProjectSaveDTOParam> checkImportParams(
      List<ProjectImportDTO> projectImportDTOS, List<MistakeExportDTO> mistakeExportDTOList, HttpServletResponse response
   ) {
      Map<String, Department> departmentMap = this.departmentService
         .list(Wrappers.lambdaQuery(Department.class).isNotNull(Department::getOrgCode).eq(Department::getStatus, 1))
         .stream()
         .collect(Collectors.toMap(Department::getOrgCode, Function.identity()));
      Map<String, User> userMap = this.userService
         .list(Wrappers.lambdaQuery(User.class).isNotNull(User::getUserCode).eq(User::getIsEnabled, 1))
         .stream()
         .collect(Collectors.toMap(User::getUserCode, Function.identity()));
      Map<String, SysCountry> countryMap = this.countryService.list().stream().collect(Collectors.toMap(SysCountry::getName, Function.identity()));
      Map<String, SysProvince> provinceMap = this.provinceService.list().stream().collect(Collectors.toMap(SysProvince::getName, Function.identity()));
      Map<String, SysCity> cityMap = this.cityService.list().stream().collect(Collectors.toMap(item -> item.getName() + "|" + item.getProvinceId(), Function.identity()));
      Map<String, SysRegion> regionMap = this.regionService
         .list()
         .stream()
         .collect(Collectors.toMap(item -> item.getName() + item.getCityId(), Function.identity()));
      Map<String, BranchCompany> branchCompanyMap = this.branchCompanyService
         .list()
         .stream()
         .collect(Collectors.toMap(BranchCompany::getName, Function.identity()));
      Map<String, SysDictionary> infoSourceMap = this.dictionaryService
         .listByName(DictionaryEnum.INFO_SOURCE.getName())
         .stream()
         .collect(Collectors.toMap(SysDictionary::getLabel, Function.identity()));
      Map<String, SysDictionary> currencyTypeMap = this.dictionaryService
         .listByName(DictionaryEnum.CURRENCY_TYPE.getName())
         .stream()
         .collect(Collectors.toMap(SysDictionary::getLabel, Function.identity()));
      Map<String, SysDictionary> structureStatusMap = this.dictionaryService
         .listByName(DictionaryEnum.STRUCTURE_STATUS.getName())
         .stream()
         .collect(Collectors.toMap(SysDictionary::getLabel, Function.identity()));
      Map<String, SysDictionary> partyTypeMap = this.dictionaryService
         .listByName(DictionaryEnum.PARTY_TYPE.getName())
         .stream()
         .collect(Collectors.toMap(SysDictionary::getLabel, Function.identity()));
      Map<String, SysDictionary> sendMap = this.dictionaryService
         .listByName(DictionaryEnum.SENDING_MODE.getName())
         .stream()
         .collect(Collectors.toMap(SysDictionary::getLabel, Function.identity()));
      projectImportDTOS = projectImportDTOS.stream().filter(importDTO -> importDTO.getOrderNo() != null).collect(Collectors.toList());
      SysProjectPersonnel sysProjectPersonnel = this.sysProjectPersonnelService
         .getOne(Wrappers.lambdaQuery(SysProjectPersonnel.class).eq(SysProjectPersonnel::getRemark, "全部公司员工").eq(SysProjectPersonnel::getTemplateName, "全部成员"));
      if (sysProjectPersonnel == null) {
         mistakeExportDTOList.add(this.getMistakeExportDTO(null, "通用人员模板不存在!!"));
         exportMistakeList(mistakeExportDTOList, response);
         return new ArrayList<>();
      } else if (projectImportDTOS.isEmpty()) {
         mistakeExportDTOList.add(this.getMistakeExportDTO(null, "该清单未找到序号!!"));
         exportMistakeList(mistakeExportDTOList, response);
         return new ArrayList<>();
      } else {
         Map<String, List<ProjectImportDTO>> map = projectImportDTOS.stream().collect(Collectors.groupingBy(ProjectImportDTO::getSerialNumber));
         map.forEach((k, v) -> {
            if (v.size() > 1) {
               v.forEach(item -> mistakeExportDTOList.add(new MistakeExportDTO(item.getOrderNo(), "清单中项目编号【" + k + "】存在重复")));
            }
         });
         if (projectImportDTOS.isEmpty()) {
            exportMistakeList(mistakeExportDTOList, response);
            return new ArrayList<>();
         } else {
            projectImportDTOS.forEach(
               item -> {
                  if (item.getBusinessType() == null) {
                     mistakeExportDTOList.add(new MistakeExportDTO(item.getOrderNo(), "订单类型不能为空"));
                  } else {
                     Boolean exist = ProjectBusinessTypeEnum.isExist(item.getBusinessType());
                     if (!exist) {
                        mistakeExportDTOList.add(new MistakeExportDTO(item.getOrderNo(), "订单类型不存在"));
                     }
                  }

                  if (item.getProjectAttribute() == null) {
                     mistakeExportDTOList.add(new MistakeExportDTO(item.getOrderNo(), "经营方式不能为空"));
                  } else {
                     Boolean exist1 = ProjectAttributeEnum.isExist(item.getProjectAttribute());
                     if (!exist1) {
                        mistakeExportDTOList.add(new MistakeExportDTO(item.getOrderNo(), "经营方式不存在"));
                     } else if (item.getProjectAttribute().equals(ProjectAttributeEnum.JOINT_VENTURE.getName())) {
                        if (item.getContractSignBodyScale() != null && item.getProjectManagerScale() != null) {
                           if (item.getProjectManagerScale().add(item.getContractSignBodyScale()).compareTo(BigDecimal.valueOf(100L)) == 1) {
                              mistakeExportDTOList.add(new MistakeExportDTO(item.getOrderNo(), "合营项目-项目经理,签约主体占比总合需为100%"));
                           }
                        } else {
                           mistakeExportDTOList.add(new MistakeExportDTO(item.getOrderNo(), "合营项目-项目经理,签约主体占比不能为空"));
                        }
                     }
                  }

                  if (item.getDept() == null) {
                     mistakeExportDTOList.add(new MistakeExportDTO(item.getOrderNo(), "部门不能为空"));
                  } else {
                     Department department = departmentMap.get(item.getDept());
                     if (department == null) {
                        mistakeExportDTOList.add(new MistakeExportDTO(item.getOrderNo(), "部门不存在"));
                     }
                  }

                  if (item.getSalesLeaderName() == null) {
                     mistakeExportDTOList.add(new MistakeExportDTO(item.getOrderNo(), "销售负责人不能为空"));
                  } else {
                     User user = userMap.get(item.getSalesLeaderName());
                     if (user == null) {
                        mistakeExportDTOList.add(new MistakeExportDTO(item.getOrderNo(), "销售负责人不存在"));
                     }
                  }

                  if (item.getSigningDate() == null) {
                     mistakeExportDTOList.add(new MistakeExportDTO(item.getOrderNo(), "签订日期不能为空"));
                  }

                  if (item.getSerialNumber() == null) {
                     mistakeExportDTOList.add(new MistakeExportDTO(item.getOrderNo(), "合同编号不能为空"));
                  } else {
                     ContractProject contractProject = this.baseService
                        .getOne(Wrappers.lambdaQuery(ContractProject.class).eq(ContractProject::getSerialNumber, item.getSerialNumber()));
                     if (contractProject != null) {
                        mistakeExportDTOList.add(new MistakeExportDTO(item.getOrderNo(), "合同编号重复"));
                     }
                  }

                  if (item.getName() == null) {
                     mistakeExportDTOList.add(new MistakeExportDTO(item.getOrderNo(), "项目名称不能为空"));
                  }

                  if (item.getShortName() == null) {
                     mistakeExportDTOList.add(new MistakeExportDTO(item.getOrderNo(), "项目简称不能为空"));
                  }

                  if (item.getStructureArea() == null) {
                     mistakeExportDTOList.add(new MistakeExportDTO(item.getOrderNo(), "结构工程量不能为空"));
                  } else if (item.getUnitType() != null && !item.getUnitType().equals("吨") && !item.getUnitType().equals("平方米")) {
                     mistakeExportDTOList.add(new MistakeExportDTO(item.getOrderNo(), "工程量单位只能是吨或者平方米"));
                  }

                  if (item.getAddress() == null) {
                     mistakeExportDTOList.add(new MistakeExportDTO(item.getOrderNo(), "合同详细地址不能为空"));
                  }

                  if (item.getStartDate() == null || item.getEndDate() == null) {
                     mistakeExportDTOList.add(new MistakeExportDTO(item.getOrderNo(), "开工时间和完工时间不能为空"));
                  } else if (item.getStartDate() != null && item.getEndDate() != null && item.getStartDate().isAfter(item.getEndDate())) {
                     mistakeExportDTOList.add(new MistakeExportDTO(item.getOrderNo(), "完工时间必须在开工时间之后"));
                  }

                  if (item.getContractSignBody() == null) {
                     mistakeExportDTOList.add(new MistakeExportDTO(item.getOrderNo(), "合同签约主体不能为空"));
                  } else if (branchCompanyMap.get(item.getContractSignBody()) == null) {
                     mistakeExportDTOList.add(new MistakeExportDTO(item.getOrderNo(), "合同签订主体不存在"));
                  }

                  if (item.getStructureStatus() == null) {
                     mistakeExportDTOList.add(new MistakeExportDTO(item.getOrderNo(), "结构类型不能为空"));
                  } else {
                     SysDictionary structureType = structureStatusMap.get(item.getStructureStatus());
                     if (structureType == null) {
                        mistakeExportDTOList.add(new MistakeExportDTO(item.getOrderNo(), "结构类型不存在"));
                     }
                  }

                  if (item.getPartyType() == null) {
                     mistakeExportDTOList.add(new MistakeExportDTO(item.getOrderNo(), "甲方类型不能为空"));
                  } else {
                     SysDictionary sysDictionary = partyTypeMap.get(item.getPartyType());
                     if (sysDictionary == null) {
                        mistakeExportDTOList.add(new MistakeExportDTO(item.getOrderNo(), "甲方类型不存在"));
                     }
                  }

                  if (item.getIsBuilding() == null) {
                     mistakeExportDTOList.add(new MistakeExportDTO(item.getOrderNo(), "是否装配式建筑不能为空"));
                  } else if (!item.getIsBuilding().equals("是") && !item.getIsBuilding().equals("否")) {
                     mistakeExportDTOList.add(new MistakeExportDTO(item.getOrderNo(), "是否装配式建筑只能是是或者否"));
                  }

                  if (item.getInfoSource() == null) {
                     mistakeExportDTOList.add(new MistakeExportDTO(item.getOrderNo(), "信息来源不能为空"));
                  } else {
                     SysDictionary infoSource = infoSourceMap.get(item.getInfoSource());
                     if (infoSource == null) {
                        mistakeExportDTOList.add(new MistakeExportDTO(item.getOrderNo(), "信息来源不存在"));
                     }
                  }

                  if (item.getSendingMode() == null) {
                     mistakeExportDTOList.add(new MistakeExportDTO(item.getOrderNo(), "发包类型不能为空"));
                  } else {
                     SysDictionary sysDictionary = sendMap.get(item.getSendingMode());
                     if (sysDictionary == null) {
                        mistakeExportDTOList.add(new MistakeExportDTO(item.getOrderNo(), "发包类型不存在"));
                     }
                  }

                  if (item.getContractAmount() == null) {
                     mistakeExportDTOList.add(new MistakeExportDTO(item.getOrderNo(), "合同金额不能为空"));
                  } else if (item.getContractAmount().compareTo(new BigDecimal("1")) < 0
                     || item.getContractAmount().compareTo(new BigDecimal("999999999999")) > 0) {
                     mistakeExportDTOList.add(new MistakeExportDTO(item.getOrderNo(), "合同金额需在 1-999999999999"));
                  }

                  if (item.getCustomerUnit() == null) {
                     mistakeExportDTOList.add(new MistakeExportDTO(item.getOrderNo(), "客户名称不能为空"));
                  }

                  if (item.getReceivingManager() == null) {
                     mistakeExportDTOList.add(new MistakeExportDTO(item.getOrderNo(), "收货负责人不能为空"));
                  }

                  if (item.getProvincesAndMunicipalities() != null) {
                     String[] split = item.getProvincesAndMunicipalities().split("/");
                     String s = split.length > 0 ? split[0] : null;
                     if (s != null) {
                        SysCountry country = countryMap.get(s);
                        if (country == null) {
                           mistakeExportDTOList.add(new MistakeExportDTO(item.getOrderNo(), "国家不存在"));
                        }
                     }

                     String s1 = split.length > 1 ? split[1] : null;
                     if (s1 != null) {
                        SysProvince province = provinceMap.get(s1);
                        if (province == null) {
                           mistakeExportDTOList.add(new MistakeExportDTO(item.getOrderNo(), "省不存在"));
                        }
                     }

                     String s2 = split.length > 2 ? split[2] : null;
                     SysProvince cityProvince = provinceMap.get(s1);
                     SysCity sysCity = cityProvince == null ? null : cityMap.get(s2 + "|" + cityProvince.getId());
                     if (s2 != null) {
                        if (sysCity == null) {
                           mistakeExportDTOList.add(new MistakeExportDTO(item.getOrderNo(), "市不存在"));
                        }
                     }

                     String s3 = split.length > 3 ? split[3] : null;
                     if (s3 != null) {
                        SysRegion region = sysCity == null ? null : regionMap.get(s3 + sysCity.getId());
                        if (region == null) {
                           mistakeExportDTOList.add(new MistakeExportDTO(item.getOrderNo(), "区不存在"));
                        }
                     }
                  }

                  if (item.getCommercialClause() != null && item.getCommercialClause().length() > 2000) {
                     mistakeExportDTOList.add(new MistakeExportDTO(item.getOrderNo(), "商务条款不可超过 2000字符"));
                  }

                  if (item.getTechnologyClause() != null && item.getTechnologyClause().length() > 2000) {
                     mistakeExportDTOList.add(new MistakeExportDTO(item.getOrderNo(), "技术条款不可超过 2000字符"));
                  }

                  if (item.getOtherRemarks() != null && item.getOtherRemarks().length() > 2000) {
                     mistakeExportDTOList.add(new MistakeExportDTO(item.getOrderNo(), "其他不可超过2000字符"));
                  }

                  if (item.getCurrencyType() != null) {
                     SysDictionary currencyType = currencyTypeMap.get(item.getCurrencyType());
                     if (currencyType == null) {
                        mistakeExportDTOList.add(new MistakeExportDTO(item.getOrderNo(), "币种不存在"));
                     }
                  }

                  if (item.getPartProvincesAndMunicipalities() != null) {
                     String[] split = item.getPartProvincesAndMunicipalities().split("/");
                     String s = split.length > 0 ? split[0] : null;
                     if (s != null) {
                        SysCountry country = countryMap.get(s);
                        if (country == null) {
                           mistakeExportDTOList.add(new MistakeExportDTO(item.getOrderNo(), "客户地址国家不存在"));
                        }
                     }

                     String s1 = split.length > 1 ? split[1] : null;
                     if (s1 != null) {
                        SysProvince province = provinceMap.get(s1);
                        if (province == null) {
                           mistakeExportDTOList.add(new MistakeExportDTO(item.getOrderNo(), "客户地址省不存在"));
                        }
                     }

                     String s2 = split.length > 2 ? split[2] : null;
                     SysProvince cityProvince = provinceMap.get(s1);
                     SysCity sysCity = cityProvince == null ? null : cityMap.get(s2 + "|" + cityProvince.getId());
                     if (s2 != null) {
                        if (sysCity == null) {
                           mistakeExportDTOList.add(new MistakeExportDTO(item.getOrderNo(), "客户地址市不存在"));
                        }
                     }

                     String s3 = split.length > 3 ? split[3] : null;
                     if (s3 != null) {
                        SysRegion region = sysCity == null ? null : regionMap.get(s3 + sysCity.getId());
                        if (region == null) {
                           mistakeExportDTOList.add(new MistakeExportDTO(item.getOrderNo(), "客户地址区不存在"));
                        }
                     }
                  }
               }
            );
            if (CollectionUtils.isNotEmpty(mistakeExportDTOList)) {
               exportMistakeList(mistakeExportDTOList, response);
               return new ArrayList<>();
            } else {
               List<ProjectSaveDTOParam> projectSaveDTOParamList = new ArrayList<>();
               projectImportDTOS.forEach(
                  item -> {
                     ProjectSaveDTOParam param = new ProjectSaveDTOParam();
                     BaseSaveDTOParam baseSaveDTOParam = new BaseSaveDTOParam();
                     baseSaveDTOParam.setContractType(ContractTypeEnum.MASTER_CONTRACT.getType());
                     baseSaveDTOParam.setSerialNumber(item.getSerialNumber());
                     baseSaveDTOParam.setName(item.getName());
                     baseSaveDTOParam.setShortName(item.getShortName());
                     if (item.getProvincesAndMunicipalities() != null) {
                        HashMap<String, Long> addressMap = this.getAddressMap(item.getProvincesAndMunicipalities(), countryMap, provinceMap, cityMap, regionMap);
                        baseSaveDTOParam.setCountryId(addressMap.get("countryId"));
                        baseSaveDTOParam.setProvinceId(addressMap.get("provinceId"));
                        baseSaveDTOParam.setCityId(addressMap.get("cityId"));
                        baseSaveDTOParam.setRegionId(addressMap.get("regionId"));
                     }

                     baseSaveDTOParam.setAddress(item.getAddress());
                     baseSaveDTOParam.setStructureStatusName(structureStatusMap.get(item.getStructureStatus()).getValue());
                     baseSaveDTOParam.setStartDate(item.getStartDate());
                     baseSaveDTOParam.setEndDate(item.getEndDate());
                     Integer projectAttribute = ProjectAttributeEnum.getTypeByName(item.getProjectAttribute());
                     Long responsibleUserId = userMap.get(item.getSalesLeaderName()).getId();
                     if (ProjectAttributeEnum.SELF_SUPPORT.getType().equals(projectAttribute)) {
                        baseSaveDTOParam.setSalesLeaderId(responsibleUserId);
                     } else {
                        baseSaveDTOParam.setProjectManagerId(responsibleUserId);
                     }
                     baseSaveDTOParam.setContractAmount(item.getContractAmount());
                     baseSaveDTOParam.setContractSignBodyScale(item.getContractSignBodyScale());
                     baseSaveDTOParam.setProjectManagerScale(item.getProjectManagerScale());
                     if (item.getCurrencyType() != null) {
                        baseSaveDTOParam.setCurrencyType(currencyTypeMap.get(item.getCurrencyType()).getValue());
                     }

                     baseSaveDTOParam.setProjectAttribute(projectAttribute);
                     baseSaveDTOParam.setDeptId(departmentMap.get(item.getDept()).getId());
                     baseSaveDTOParam.setDeptName(departmentMap.get(item.getDept()).getName());
                     baseSaveDTOParam.setStructureArea(item.getStructureArea());
                     baseSaveDTOParam.setPartyTypeName(partyTypeMap.get(item.getPartyType()).getValue());
                     baseSaveDTOParam.setInfoSourceName(infoSourceMap.get(item.getInfoSource()).getValue());
                     baseSaveDTOParam.setSendingModeName(sendMap.get(item.getSendingMode()).getValue());
                     baseSaveDTOParam.setIsBuilding("是".equals(item.getIsBuilding()) ? 1 : 0);
                     baseSaveDTOParam.setUnitType("吨".equals(item.getUnitType()) ? 1 : 2);
                     baseSaveDTOParam.setContractSignBodyId(branchCompanyMap.get(item.getContractSignBody()).getId());
                     baseSaveDTOParam.setBusinessType(ProjectBusinessTypeEnum.getTypeByName(item.getBusinessType()));
                     baseSaveDTOParam.setTaxRate(item.getTaxRate());
                     baseSaveDTOParam.setCommercialClause(item.getCommercialClause());
                     baseSaveDTOParam.setTechnologyClause(item.getTechnologyClause());
                     baseSaveDTOParam.setOtherRemarks(item.getOtherRemarks());
                     baseSaveDTOParam.setSignerId(UserUtil.getCurrentUserId());
                     baseSaveDTOParam.setSigningDate(LocalDate.now());
                     CustomerSaveDTOParam customerSaveDTOParam = new CustomerSaveDTOParam();
                     customerSaveDTOParam.setCustomerUnit(item.getCustomerUnit());
                     customerSaveDTOParam.setSocialCode(item.getSocialCode());
                     customerSaveDTOParam.setCustomerUnitPhone(item.getCustomerUnitPhone());
                     if (item.getPartProvincesAndMunicipalities() != null) {
                        HashMap<String, Long> addressMap = this.getAddressMap(
                           item.getPartProvincesAndMunicipalities(), countryMap, provinceMap, cityMap, regionMap
                        );
                        customerSaveDTOParam.setCustomerCountryId(addressMap.get("countryId"));
                        customerSaveDTOParam.setCustomerProvinceId(addressMap.get("provinceId"));
                        customerSaveDTOParam.setCustomerCityId(addressMap.get("cityId"));
                        customerSaveDTOParam.setCustomerRegionId(addressMap.get("regionId"));
                     }

                     customerSaveDTOParam.setCustomerAddress(item.getCustomerAddress());
                     customerSaveDTOParam.setCustomerBankUserName(item.getCustomerBankUserName());
                     customerSaveDTOParam.setCustomerBankCode(item.getCustomerBankCode());
                     customerSaveDTOParam.setCustomerBankName(item.getCustomerBankName());
                     customerSaveDTOParam.setReceivingManager(item.getReceivingManager());
                     customerSaveDTOParam.setReceivingManagerPhone(item.getReceivingManagerPhone());
                     customerSaveDTOParam.setSettleManager(item.getSettleManager());
                     customerSaveDTOParam.setSettleManagerPhone(item.getSettleManagerPhone());
                     customerSaveDTOParam.setFinanceManager(item.getFinanceManager());
                     customerSaveDTOParam.setFinanceManagerPhone(item.getFinanceManagerPhone());
                     customerSaveDTOParam.setAuditManager(item.getAuditManager());
                     customerSaveDTOParam.setAuditManagerPhone(item.getAuditManagerPhone());
                     customerSaveDTOParam.setDesignManager(item.getDesignManager());
                     customerSaveDTOParam.setDesignManagerPhone(item.getDesignManagerPhone());
                     customerSaveDTOParam.setCustomerRemark(item.getCustomerRemark());
                     List<Long> userIds = this.sysTemplateUserLinkService
                        .list(Wrappers.lambdaQuery(SysTemplateUserLink.class).eq(SysTemplateUserLink::getTemplateId, sysProjectPersonnel.getId()))
                        .stream()
                        .map(SysTemplateUserLink::getUserId)
                        .collect(Collectors.toList());
                     param.setBaseRequestVO(baseSaveDTOParam);
                     param.setCustomer(customerSaveDTOParam);
                     param.setUserIdList(userIds);
                     projectSaveDTOParamList.add(param);
                  }
               );
               return projectSaveDTOParamList;
            }
         }
      }
   }

   private HashMap<String, Long> getAddressMap(
      String address, Map<String, SysCountry> countryMap, Map<String, SysProvince> provinceMap, Map<String, SysCity> cityMap, Map<String, SysRegion> regionMap
   ) {
      HashMap<String, Long> map = new HashMap<>();
      String[] split = address.split("/");
      String s = split.length > 0 ? split[0] : null;
      if (s != null) {
         SysCountry country = countryMap.get(s);
         if (country != null) {
            map.put("countryId", country.getId());
         }
      }

      String s1 = split.length > 1 ? split[1] : null;
      if (s1 != null) {
         SysProvince province = provinceMap.get(s1);
         if (province != null) {
            map.put("provinceId", province.getId());
         }
      }

      String s2 = split.length > 2 ? split[2] : null;
      SysProvince cityProvince = provinceMap.get(s1);
      SysCity sysCity = cityProvince == null ? null : cityMap.get(s2 + "|" + cityProvince.getId());
      if (s2 != null) {
         if (sysCity != null) {
            map.put("cityId", sysCity.getId());
         }
      }

      String s3 = split.length > 3 ? split[3] : null;
      if (s3 != null) {
         SysRegion region = sysCity == null ? null : regionMap.get(s3 + sysCity.getId());
         if (region != null) {
            map.put("regionId", region.getId());
         }
      }

      return map;
   }

   private MistakeExportDTO getMistakeExportDTO(Integer orderNo, String errorMessage) {
      return MistakeExportDTO.builder().orderNo(orderNo).errorMessage(errorMessage).build();
   }

   public static void exportMistakeList(List<MistakeExportDTO> mistakeExportDTOList, HttpServletResponse response) {
      if (!CollectionUtils.isEmpty(mistakeExportDTOList)) {
         String title = "项目导入出错表";
         String sheetName = "项目导入出错表";
         String fileName = "项目导入出错表.xls";

         try {
            response.setHeader("result", "code=50000;message=" + URLEncoder.encode("数据导入失败,具体信息请查看错误表格!", "UTF-8"));
            response.setHeader("Access-Control-Expose-Headers", "result");
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8"));
            PoiUtils.exportExcel(mistakeExportDTOList, title, sheetName, MistakeExportDTO.class, fileName, response);
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
   }

   @Override
   public Map<String, BigDecimal> getCostSummary(ProjectLedgerDtoParam param) {
      param.setProjectAttribute(ProjectAttributeEnum.SELF_SUPPORT.getType());
      Preconditions.checkArgument(param.getBranchCompanyId() != null, "分支机构不能为空！");
      BranchCompany company = this.branchCompanyService.getById(param.getBranchCompanyId());
      Preconditions.checkArgument(company != null, "获取分支机构信息失败！");
      param.setLevel(company.getLevel());
      Map<String, BigDecimal> map = new HashMap<>();
      map.put("amount", BigDecimal.ZERO);
      map.put("cumulativeCost", BigDecimal.ZERO);
      map.put("accumulatedCollection", BigDecimal.ZERO);
      if (company.getLevel() == 1) {
         PageVO<ProjectLedgerDTO> dtoPageVO = this.getProjectSelfOwnedPageSize(param, 1, 20);
         if (CollectionUtils.isNotEmpty(dtoPageVO.getContent())) {
            ProjectLedgerDTO projectLedgerDTO = dtoPageVO.getContent().get(0);
            map.put("cumulativeCost", projectLedgerDTO.getAccumulatedCost());
            map.put("accumulatedCollection", projectLedgerDTO.getAccumulatedCollection());
            if (projectLedgerDTO.getSettlementStatus() == 1) {
               map.put("amount", projectLedgerDTO.getSettlementAmount());
            } else {
               map.put("amount", projectLedgerDTO.getAmount());
            }
         }
      } else {
         PageVO<ManufactureCostDTO> dtoPageVO = this.manufactureCostService.manufactureCostPage(null, param.getProjectId(), null, Boolean.TRUE, 1, 20);
         if (CollectionUtils.isNotEmpty(dtoPageVO.getContent())) {
            ManufactureCostDTO manufactureCostDTO = dtoPageVO.getContent().get(0);
            map.put("cumulativeCost", manufactureCostDTO.getCumulativeCost());
         }

         PageVO<ProjectLedgerDTO> ledgerDTOPageVO = this.getProjectSelfOwnedPageSize(param, 1, 20);
         if (CollectionUtils.isNotEmpty(ledgerDTOPageVO.getContent())) {
            ProjectLedgerDTO projectLedgerDTO = ledgerDTOPageVO.getContent().get(0);
            map.put("accumulatedCollection", projectLedgerDTO.getAccumulatedCollection());
            if (projectLedgerDTO.getSettlementStatus() == 1) {
               map.put("amount", projectLedgerDTO.getSettlementAmount());
            } else {
               map.put("amount", projectLedgerDTO.getAmount());
            }
         }
      }

      return map;
   }

   @Override
   public List<ProjectExpenseCostReportDTO> getProjectExpenseCostReportDTO(Long projectId, Long branchCompanyId) {
      BranchCompany company = this.branchCompanyService.getById(branchCompanyId);
      Preconditions.checkArgument(company != null, "获取分支机构信息失败！");
      List<ProjectExpenseCostReportDTO> costSubjectCost;
      if (company.getLevel() == 1) {
         ProjectSelfSupportCostReportDTO selfSupportCost = this.getSelfSupportCost(projectId, null);
         costSubjectCost = selfSupportCost.getCostSubjectCost();
      } else {
         List<String> title = Arrays.asList("一", "二", "三", "四", "五", "六", "七", "八", "九");
         List<CostSummaryDTO> costSummaryDTOS = this.manufactureCostService.costSummary(projectId, Boolean.TRUE);
         costSubjectCost = costSummaryDTOS.stream()
            .filter(e -> title.contains(e.getIndexName()))
            .map(
               e -> ProjectExpenseCostReportDTO.builder()
                  .costTypeName(e.getName())
                  .amount(e.getTotal())
                  .proportion(e.getCostProportion() != null ? e.getCostProportion().multiply(BigDecimal.valueOf(100L)) : BigDecimal.ZERO)
                  .build()
            )
            .collect(Collectors.toList());
      }

      return costSubjectCost;
   }

   @Override
   public void getProjectExpenseCostReportDownload(Long projectId, Long branchCompanyId, HttpServletResponse response) {
      List<ProjectExpenseCostReportDTO> dtoList = this.getProjectExpenseCostReportDTO(projectId, branchCompanyId);
      if (!CollectionUtils.isEmpty(dtoList)) {
         String title = "";
         if (branchCompanyId != null) {
            BranchCompany branchCompany = this.branchCompanyService.getById(branchCompanyId);
            if (branchCompany != null) {
               title = title + "分支机构：" + branchCompany.getName() + "\n";
            }
         }

         if (projectId != null) {
            ProjectInfo projectInfo = this.projectService.getSimpleById(projectId);
            if (projectInfo != null) {
               title = title + "项目：" + projectInfo.getName() + "\n";
            }
         }

         AtomicInteger index = new AtomicInteger(0);
         List<List<String>> headList = new ArrayList<>();
         headList.add(Arrays.asList(title, "序号"));
         headList.add(Arrays.asList(title, "类别"));
         headList.add(Arrays.asList(title, "累计成本（元）"));
         headList.add(Arrays.asList(title, "占比"));
         List<List<Object>> dataList = new ArrayList<>();
         dtoList.forEach(ex -> {
            List<Object> data = new ArrayList<>();
            data.add(index.incrementAndGet());
            data.add(ex.getCostTypeName());
            data.add(ex.getAmount());
            data.add(ex.getProportion());
            dataList.add(data);
         });

         try {
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            String fileName = StrUtil.concat(true, "成本费用详情.xlsx");
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
               .sheet("成本费用详情表")
               .doWrite(dataList);
         } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
         }
      }
   }

   @Override
   public List<ContractProjectPrimeListDTO> primeContractList() {
      List<ContractProject> contractProjects = this.baseService
         .list(Wrappers.lambdaQuery(ContractProject.class).eq(ContractProject::getContractType, ContractTypeEnum.MASTER_CONTRACT.getType()));
      List<ContractProjectPrimeListDTO> collect = contractProjects.stream().map(item -> {
         ContractProjectPrimeListDTO contractProjectPrimeListDTO = new ContractProjectPrimeListDTO();
         contractProjectPrimeListDTO.setId(item.getId());
         contractProjectPrimeListDTO.setSerialNumber(item.getSerialNumber());
         contractProjectPrimeListDTO.setName(item.getName());
         contractProjectPrimeListDTO.setCreateTime(item.getCreateTime());
         contractProjectPrimeListDTO.setStatus(item.getStatus());
         contractProjectPrimeListDTO.setShortName(item.getShortName());
         return contractProjectPrimeListDTO;
      }).collect(Collectors.toList());
      Stream<ContractProjectPrimeListDTO> stream = collect.stream();
      SecurityUser user = UserUtil.getCurrentUser();
      if (!user.isAdmin()) {
         List<Long> projectIds = this.projectService.listProjectIdByUser(user.getId(), null);
         stream = stream.filter(p -> projectIds.contains(p.getId()));
      }

      return stream.collect(Collectors.toList());
   }

   @Override
   public ContractProjectInfoDTO getProjectSummaryInfo() {
      List<ProjectSimpleInfoDTO> projectList = this.baseMapper
         .getProjectPlanList(null, null, null, UserUtil.getCurrentUser().isAdmin() ? null : UserUtil.getCurrentUserId());
      long selfSupportQuantity = projectList.stream().filter(p -> p.getProjectAttribute().equals(ProjectAttributeEnum.SELF_SUPPORT.getType())).count();
      long jointVentureQuantity = projectList.stream().filter(p -> p.getProjectAttribute().equals(ProjectAttributeEnum.JOINT_VENTURE.getType())).count();
      long lumpSumSystemQuantity = projectList.stream().filter(p -> p.getProjectAttribute().equals(ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType())).count();
      long annualCompletedProjectsQuantity = projectList.stream().filter(p -> p.getStatus().equals(ProjectStatusEnum.COMPLETED.getType())).count();
      long annualSettledItemsQuantity = projectList.stream().filter(p -> p.getSettlementStatus().equals(1)).count();
      long newItemsThisMonthQuantity = projectList.stream().filter(p -> p.getCreateTime().getMonth().equals(LocalDateTime.now().getMonth())).count();
      long uncreatedPlanQuantity = projectList.stream().filter(p -> {
         Long pId = p.getId();
         return CollectionUtils.isEmpty(this.monomerService.list(Wrappers.lambdaQuery(PlanMonomer.class).eq(PlanMonomer::getProjectId, pId)));
      }).count();
      long uncreatedPersonQuantity = 0L;

      for (ProjectSimpleInfoDTO projectSimpleInfoDTO : projectList) {
         Long projcetId = projectSimpleInfoDTO.getId();
         List<PlanMonomer> planMonomerList = this.monomerService.list(Wrappers.lambdaQuery(PlanMonomer.class).eq(PlanMonomer::getProjectId, projcetId));
         List<MonomerUserLink> planMonomerUserLinkList = this.monomerUserLinkService
            .list(Wrappers.lambdaQuery(MonomerUserLink.class).in(MonomerUserLink::getProjectId, projcetId));
         if (CollectionUtils.isNotEmpty(planMonomerUserLinkList)) {
            List<Long> collect = planMonomerUserLinkList.stream().map(MonomerUserLink::getMonomerId).distinct().collect(Collectors.toList());
            if (collect.size() != planMonomerList.size()) {
               uncreatedPersonQuantity++;
            }
         } else {
            uncreatedPersonQuantity++;
         }
      }

      long processingQuantity = projectList.stream().filter(p -> p.getStatus().equals(ProjectStatusEnum.PROCESSING.getType())).count();
      long completedQuantity = projectList.stream().filter(p -> p.getStatus().equals(ProjectStatusEnum.COMPLETED.getType())).count();
      List<Map<String, Object>> mapList = new ArrayList<>();
      if (CollectionUtils.isNotEmpty(projectList)) {
         Map<Long, List<ProjectSimpleInfoDTO>> listMap = projectList.stream()
            .filter(p -> p.getProvinceId() != null)
            .collect(Collectors.groupingBy(ProjectSimpleInfoDTO::getProvinceId));
         int count = Math.toIntExact(projectList.stream().filter(p -> p.getProvinceId() == null).count());
         if (listMap == null) {
            Map<String, Object> map = new HashMap<>();
            map.put("provinceName", "其他");
            map.put("quantity", projectList.size());
            mapList.add(map);
         } else {
            listMap.forEach((provinceId, projects) -> {
               Map<String, Object> mapx = new HashMap<>();
               SysProvince province = this.provinceService.getById(provinceId);
               mapx.put("provinceName", province.getName());
               mapx.put("quantity", projects.size());
               mapList.add(mapx);
            });
            if (count > 0) {
               Map<String, Object> map = new HashMap<>();
               map.put("provinceName", "其他");
               map.put("quantity", count);
               mapList.add(map);
            }
         }
      }

      if (CollectionUtils.isNotEmpty(mapList)) {
         mapList.sort(Comparator.comparingInt(o -> (Integer)o.get("quantity")));
      }

      return ContractProjectInfoDTO.builder()
         .uncreatedPersonQuantity(Math.toIntExact(uncreatedPersonQuantity))
         .selfSupportQuantity(Math.toIntExact(selfSupportQuantity))
         .jointVentureQuantity(Math.toIntExact(jointVentureQuantity))
         .lumpSumSystemQuantity(Math.toIntExact(lumpSumSystemQuantity))
         .annualCompletedProjectsQuantity(Math.toIntExact(annualCompletedProjectsQuantity))
         .annualSettledItemsQuantity(Math.toIntExact(annualSettledItemsQuantity))
         .newItemsThisMonthQuantity(Math.toIntExact(newItemsThisMonthQuantity))
         .uncreatedPlanQuantity(Math.toIntExact(uncreatedPlanQuantity))
         .quantity(projectList.size())
         .processingQuantity(Math.toIntExact(processingQuantity))
         .completedQuantity(Math.toIntExact(completedQuantity))
         .provinceList(mapList)
         .build();
   }

   @Override
   public PageVO<ProjectSimpleInfoDTO> getProjectList(Integer status, String noOrName, Integer year, Integer pageNumber, Integer pageSize) {
      return this.getProjectList(status, noOrName, year, pageNumber, pageSize, null, null);
   }

   @Override
   public PageVO<ProjectSimpleInfoDTO> getProjectList(
      Integer status, String noOrName, Integer year, Integer pageNumber, Integer pageSize, Integer projectType, Integer lumpSumSystemType
   ) {
      PageHelper.startPage(pageNumber, pageSize);
      List<ProjectSimpleInfoDTO> projectSimpleInfoDTOS = this.baseMapper.getProjectPlanListFiltered(
         status, noOrName, year, UserUtil.getCurrentUser().isAdmin() ? null : UserUtil.getCurrentUserId(), projectType, lumpSumSystemType
      );
      projectSimpleInfoDTOS.stream().forEach(p -> {
         Long userId = p.getUserId();
         if (userId != null) {
            p.setCreateName(this.userService.getById(userId).getName());
         }

         if (p.getProjectManagerId() != null) {
            p.setProjectManagerName(this.userService.getById(p.getProjectManagerId()).getName());
         }
      });
      return new PageVO<>(projectSimpleInfoDTOS);
   }

   @Override
   public List<ProjectRelevancyDTO> getProjectAdditionalProject(Integer projectId) {
      ContractProject project = this.baseMapper.selectById(projectId);
      if (project == null) {
         return new ArrayList<>();
      }

      List<ContractProject> relatedProjects = this.getRelatedProjects(project);
      if (CollectionUtils.isEmpty(relatedProjects)) {
         return new ArrayList<>();
      }

      List<Long> projectIds = relatedProjects.stream().map(ContractProject::getId).filter(Objects::nonNull).distinct().collect(Collectors.toList());
      List<Long> managerIds = relatedProjects.stream()
         .map(ContractProject::getProjectManagerId)
         .filter(Objects::nonNull)
         .distinct()
         .collect(Collectors.toList());
      Map<Long, User> userMap = new HashMap<>();
      if (CollectionUtils.isNotEmpty(managerIds)) {
         List<User> users = this.userService.listByIds(managerIds);
         userMap = users.stream().collect(Collectors.toMap(User::getId, user -> (User)user, (k1, k2) -> k1));
      }

      Map<Long, List<ProjectBranchCompanyLink>> companyLinkMap = new HashMap<>();
      if (CollectionUtils.isNotEmpty(projectIds)) {
         List<ProjectBranchCompanyLink> allLinks = this.companyLinkService
            .list((Wrapper<ProjectBranchCompanyLink>)new LambdaQueryWrapper<ProjectBranchCompanyLink>().in(ProjectBranchCompanyLink::getProjectId, projectIds));
         companyLinkMap = allLinks.stream().collect(Collectors.groupingBy(ProjectBranchCompanyLink::getProjectId));
      }

      Map<Long, List<PlanAreaBatchDTO>> areaBatchMap = new HashMap<>();

      for (Long pid : projectIds) {
         List<PlanAreaBatchDTO> areaBatchList = this.areaBatchService.getList(pid, null, null, null, null);
         areaBatchMap.put(pid, areaBatchList != null ? areaBatchList : new ArrayList<>());
      }

      Map<Long, User> finalUserMap = userMap;
      Map<Long, List<ProjectBranchCompanyLink>> finalCompanyLinkMap = companyLinkMap;
      Map<Long, List<PlanAreaBatchDTO>> finalAreaBatchMap = areaBatchMap;
      return relatedProjects.stream()
         .map(contractProject -> this.buildProjectRelevancyDTO(contractProject, finalUserMap, finalCompanyLinkMap, finalAreaBatchMap))
         .collect(Collectors.toList());
   }

   private List<ContractProject> getRelatedProjects(ContractProject project) {
      List<ContractProject> result = new ArrayList<>();
      if (ObjectUtil.isNotEmpty(project.getPId())) {
         List<ContractProject> siblingProjects = this.baseMapper
            .selectList((Wrapper<ContractProject>)new LambdaQueryWrapper<ContractProject>().eq(ContractProject::getPId, project.getPId()));
         if (CollectionUtils.isNotEmpty(siblingProjects)) {
            result.addAll(siblingProjects);
         }

         ContractProject parentProject = this.baseMapper.selectById(project.getPId());
         if (parentProject != null) {
            result.add(parentProject);
         }
      } else {
         List<ContractProject> childProjects = this.baseMapper
            .selectList((Wrapper<ContractProject>)new LambdaQueryWrapper<ContractProject>().eq(ContractProject::getPId, project.getId()));
         if (CollectionUtils.isNotEmpty(childProjects)) {
            result.addAll(childProjects);
         }

         result.add(project);
      }

      return result;
   }

   private ProjectRelevancyDTO buildProjectRelevancyDTO(
      ContractProject contractProject,
      Map<Long, User> userMap,
      Map<Long, List<ProjectBranchCompanyLink>> companyLinkMap,
      Map<Long, List<PlanAreaBatchDTO>> areaBatchMap
   ) {
      ProjectRelevancyDTO dto = BeanUtil.copy(contractProject, ProjectRelevancyDTO.class);
      if (contractProject.getProjectManagerId() != null) {
         User user = userMap.get(contractProject.getProjectManagerId());
         if (user != null) {
            dto.setProjectManagerId(user.getId());
            dto.setProjectManagerName(user.getName());
         }
      }

      List<ProjectBranchCompanyLink> links = companyLinkMap.getOrDefault(contractProject.getId(), new ArrayList<>());
      List<ProjectBranchCompanyLinkDTO> linkDTOS = cn.hutool.core.bean.BeanUtil.copyToList(links, ProjectBranchCompanyLinkDTO.class);
      dto.setCompanyLinkDTO(linkDTOS);
      dto.setAreaBatchList(areaBatchMap.getOrDefault(contractProject.getId(), new ArrayList<>()));
      return dto;
   }

   @Override
   public Map<Integer, List<ProjectRelevancyDTO>> getProjectAdditionalProjectBatch(List<Integer> projectIds) {
      Map<Integer, List<ProjectRelevancyDTO>> resultMap = new HashMap<>();
      if (projectIds != null && !projectIds.isEmpty()) {
         for (Integer projectId : projectIds) {
            if (projectId != null) {
               List<ProjectRelevancyDTO> additionalProjects = this.getProjectAdditionalProject(projectId);
               resultMap.put(projectId, additionalProjects);
            }
         }

         return resultMap;
      } else {
         return resultMap;
      }
   }
   // Preserve the original Lombok-generated unchecked rethrow without changing public signatures.
   @SuppressWarnings("unchecked")
   private static <E extends Throwable> RuntimeException rethrow(Throwable error) throws E {
      throw (E)error;
   }
}
