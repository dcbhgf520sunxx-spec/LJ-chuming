package com.hzchum.scim.wms.core.service.impl.wmsUse;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.io.FileUtil;
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
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.config.ConfigProperties;
import com.hzchum.scim.common.core.api.enums.ApproveFlowOperationEnum;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.ApproveRecordStatusEnum;
import com.hzchum.scim.common.core.api.enums.ApproveTemplateVersionsFlowEnum;
import com.hzchum.scim.common.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.common.core.api.enums.CheckStatusEnum;
import com.hzchum.scim.common.core.api.enums.FunctionTypeEnum;
import com.hzchum.scim.common.core.api.enums.ModuleTypeEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.enums.TableNameTypeEnum;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveFlowOperation;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecordDetail;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveTemplateVersions;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveTemplateVersionsFlow;
import com.hzchum.scim.common.core.api.pojo.common.ClassificationCheckDTO;
import com.hzchum.scim.common.core.api.pojo.common.IdsStatusDTO;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.MountMessageDTO;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveFlowDTO;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordDetailDTO;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordFlowDTO;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.common.core.api.service.WmsApproveFlowOperationService;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordDetailService;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.common.core.api.service.WmsApproveTemplateService;
import com.hzchum.scim.common.core.api.service.WmsApproveTemplateVersionsService;
import com.hzchum.scim.contract.core.api.enums.SettlementStatusEnum;
import com.hzchum.scim.contract.core.api.enums.payment.SupplierPropertyTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierInvoice;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierPayment;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.SupplierInvoiceService;
import com.hzchum.scim.contract.core.api.service.SupplierPaymentService;
import com.hzchum.scim.cut.core.api.pojo._do.WmsPlantPart;
import com.hzchum.scim.cut.core.api.service.WmsPlantPartService;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingSinglePartArtifactPrintBiz;
import com.hzchum.scim.mes.building.core.api.enums.scheduling.CutStatusEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingBoChuNestingResult;
import com.hzchum.scim.mes.building.core.api.pojo._dto.util.IdAndNameDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.ExternalArtifactDTO;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingBoChuNestingResultService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskOrderService;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactDTO;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.project.core.api.pojo._do.ProjectReceivingRecord;
import com.hzchum.scim.project.core.api.service.ProjectReceivingRecordService;
import com.hzchum.scim.scm.core.api.enums.LogisticsPayerEnum;
import com.hzchum.scim.scm.core.api.enums.LogisticsTransportTypeEnum;
import com.hzchum.scim.scm.core.api.enums.PlaceEnum;
import com.hzchum.scim.scm.core.api.enums.PurchaseEnum;
import com.hzchum.scim.scm.core.api.enums.PurchaseStatusEnum;
import com.hzchum.scim.scm.core.api.enums.SupplyTypeEnum;
import com.hzchum.scim.scm.core.api.pojo._do.LogisticsOrder;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrder;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrderDetail;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import com.hzchum.scim.scm.core.api.pojo.dto.SupplierAllBriefDTO;
import com.hzchum.scim.scm.core.api.service.ApplyPurchaseService;
import com.hzchum.scim.scm.core.api.service.LogisticsOrderService;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderDetailService;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import com.hzchum.scim.system.core.api.biz.notification.SysPushFlowConfigBiz;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.enums.NumberTypeEnum;
import com.hzchum.scim.system.core.api.common.enums.notification.NotificationModuleTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.common.utils.notification.NotificationTemplateDetailsUtils;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.pojo._do.NumberConfig;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo.dto.notification.NotificationServiceTriggerDTO;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.system.core.api.service.NumberConfigService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.wms.core.api.biz.SectionSteelSpecService;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.enums.DataStatusEnum;
import com.hzchum.scim.wms.core.api.enums.FillWayEnum;
import com.hzchum.scim.wms.core.api.enums.InboundWayEnum;
import com.hzchum.scim.wms.core.api.enums.InvoiceTypeEnum;
import com.hzchum.scim.wms.core.api.enums.MaterialIsWholeEnum;
import com.hzchum.scim.wms.core.api.enums.MaterialLabelPrintTypeEnum;
import com.hzchum.scim.wms.core.api.enums.MeasureTypeEnum;
import com.hzchum.scim.wms.core.api.enums.PrintMaterialTypeEnum;
import com.hzchum.scim.wms.core.api.enums.QualityTestingEnum;
import com.hzchum.scim.wms.core.api.enums.ReceiptTypeEnum;
import com.hzchum.scim.wms.core.api.enums.RejectEnum;
import com.hzchum.scim.wms.core.api.enums.UnitEnum;
import com.hzchum.scim.wms.core.api.enums.UnitsPrecisionEnum;
import com.hzchum.scim.wms.core.api.enums.WmsWageQuotaTypeEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.BasicConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.BasicInbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.BasicShowConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Classification;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Measure;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.SectionSteelConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.SectionSteelSpec;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.SectionSteelSpecStandardDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Standard;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.SteelInbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Unit;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Warehouse;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WasteConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WmsMaterialCodeConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Workshop;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.Statistics;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.WmsClosingTime;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Barcode;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.DownLoadDetailDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Inbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundDetailManufactured;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundManufactured;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MonthSummaryDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Outbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Print;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.PrintDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Reject;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.RejectDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Scrap;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsAdjustDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.YearSummaryDO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.SectionSteelSpecDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.SubjectMeasureDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.AdjustDetailsDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.AppInboundDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.BriefInboundDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ConstructionInboundDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.InboundAmountDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.InboundDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.InboundDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialInventoryDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.PuchaseInboundDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ReconciliationDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.RejectMaterialDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.APPInboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.APPInboundPassDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.AppCutMaterialDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.ConditionsDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.InboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.InboundDetailDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.InboundDetailMoneyDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.InboundQualityTestingDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryInboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryPurchaseInboundDetailDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.SurplusDetailDTO;
import com.hzchum.scim.wms.core.api.service.wmsConfig.BasicConfigService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.ClassificationService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.MeasureService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.SpecificationService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.UnitService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WarehouseService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WarningService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WmsMaterialCodeConfigService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WorkshopService;
import com.hzchum.scim.wms.core.api.service.wmsReport.ReportService;
import com.hzchum.scim.wms.core.api.service.wmsReport.WmsClosingTimeService;
import com.hzchum.scim.wms.core.api.service.wmsUse.BarcodeService;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundDetailManufacturedService;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundManufacturedService;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialInventoryService;
import com.hzchum.scim.wms.core.api.service.wmsUse.PrintDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.PrintService;
import com.hzchum.scim.wms.core.api.service.wmsUse.RejectService;
import com.hzchum.scim.wms.core.api.service.wmsUse.ScrapService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WeightedAveragePriceService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsAdjustDetailService;
import com.hzchum.scim.wms.core.api.utils.CommonUtil;
import com.hzchum.scim.wms.core.api.utils.DownloadFile;
import com.hzchum.scim.wms.core.api.utils.WmsUtil;
import com.hzchum.scim.wms.core.mapper.wmsConfig.BasicConfigMapper;
import com.hzchum.scim.wms.core.mapper.wmsConfig.MeasureMapper;
import com.hzchum.scim.wms.core.mapper.wmsConfig.SectionSteelConfigMapper;
import com.hzchum.scim.wms.core.mapper.wmsConfig.SectionSteelSpecStandardDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsConfig.StandardMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.BarcodeMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.InboundDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.InboundMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.PrintDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.RejectDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.RejectMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.ScrapMapper;
import com.hzchum.scim.wms.core.utils.CorrectDXF;
import com.hzchum.scim.wms.core.utils.QueryUtilImpl;
import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InboundServiceImpl extends ServiceImpl<InboundMapper, Inbound> implements InboundService {
   private static final BigDecimal THOUSAND = new BigDecimal("1000");
   private static final BigDecimal HUNDRED = new BigDecimal("100");
   @Resource
   PurchaseOrderService purchaseOrderService;
   @Resource
   PurchaseOrderDetailService orderDetailService;
   @Resource
   ReportService reportService;
   @Resource
   BasicConfigService basicConfigService;
   @Resource
   SpecificationService specificationService;
   @Resource
   ScrapMapper scrapMapper;
   @Resource
   ScrapService scrapService;
   @Resource
   ClassificationService classificationService;
   @Resource
   InboundDetailMapper inboundDetailMapper;
   @Resource
   LogisticsOrderService logisticsOrderService;
   @Resource
   NumberConfigService numberConfigService;
   @Resource
   SectionSteelSpecService sectionSteelSpecService;
   @Resource
   SectionSteelConfigMapper sectionSteelConfigMapper;
   @Resource
   ContractProjectService contractProjectService;
   @Resource
   MaterialInventoryService materialInventoryService;
   @Resource
   WarehouseService warehouseService;
   @Resource
   WeightedAveragePriceService weightedAveragePriceService;
   @Resource
   MeasureMapper measureMapper;
   @Resource
   SupplierService supplierService;
   @Resource
   WorkshopService workshopService;
   @Resource
   SectionSteelSpecStandardDetailMapper sectionSteelSpecStandardDetailMapper;
   @Resource
   RejectMapper rejectMapper;
   @Resource
   RejectDetailMapper rejectDetailMapper;
   @Resource
   WarningService warningService;
   @Resource
   PrintService printService;
   @Resource
   PrintDetailMapper printDetailMapper;
   @Resource
   AttachmentService attachmentService;
   @Resource
   PlanAreaService planAreaService;
   @Resource
   PlanMonomerService monomerService;
   @Resource
   PurchaseOrderDetailService poDetailService;
   @Resource
   MesBuildingSinglePartArtifactPrintBiz mesSPABiz;
   @Resource
   TechArtifactService artifactService;
   @Resource
   ApplyPurchaseService applyPurchaseService;
   @Resource
   private InboundManufacturedService inboundManufacturedService;
   @Resource
   StandardMapper standardMapper;
   @Resource
   BasicConfigMapper basicConfigMapper;
   @Resource
   WmsApproveTemplateService wmsApproveTemplateService;
   @Resource
   WmsApproveRecordService wmsApproveRecordService;
   @Resource
   WmsApproveTemplateVersionsService wmsApproveTemplateVersionsService;
   @Resource
   WmsAdjustDetailService wmsAdjustDetailService;
   @Resource
   QueryUtilImpl queryUtil;
   @Resource
   WmsApproveFlowOperationService wmsApproveFlowOperationService;
   @Resource
   WmsClosingTimeService wmsClosingTimeService;
   @Resource
   WmsApproveRecordDetailService wmsApproveRecordDetailService;
   @Resource
   DownloadFile downloadFile;
   @Resource
   BranchCompanyService branchCompanyService;
   @Resource
   InboundDetailService inboundDetailService;
   @Resource
   InboundDetailManufacturedService inboundDetailManufacturedService;
   @Resource
   ProjectReceivingRecordService projectReceivingRecordService;
   @Resource
   private RejectService rejectService;
   @Resource
   private UserService userService;
   @Resource
   MesBuildingTaskOrderService mesBuildingTaskOrderService;
   @Resource
   private MesBuildingWorkshopService mesWorkshopService;
   @Resource
   private SupplierPaymentService supplierPaymentService;
   @Resource
   private SupplierInvoiceService supplierInvoiceService;
   @Resource
   WmsUtil wmsUtil;
   @Value("${wms.amount-accuracy}")
   private Integer amountAccuracy;
   @Resource
   MeasureService measureService;
   @Resource
   private RedisTemplate redisTemplate;
   @Resource
   private ConfigProperties configProperties;
   @Resource
   private MesBuildingBoChuNestingResultService mesBuildingBoChuNestingResultService;
   @Resource
   WmsPlantPartService wmsPlantPartService;
   RoundingMode ROUNDING = RoundingMode.HALF_UP;
   @Resource
   WmsMaterialCodeConfigService wmsMaterialCodeConfigService;
   @Resource
   private UnitService unitService;
   @Resource
   private BarcodeMapper barcodeMapper;
   @Resource
   private BarcodeService barcodeService;
   @Resource
   private PrintDetailService printDetailService;
   @Resource
   private SysPushFlowConfigBiz sysPushFlowConfigBiz;
   @Resource
   private NotificationTemplateDetailsUtils detailsUtils;

   @Override
   public PageVO<BriefInboundDTO> pageInfo(QueryInboundDTOParam dtoParam, Integer pageNum, Integer size, List<String> sort) {
      String s = StringUtils.analyzeSortConditions(sort);
      PageInfo<Inbound> pageInfo = PageHelper.<Inbound>startPage(pageNum, size, s).doSelectPageInfo(() -> this.listInfo(dtoParam));
      Map<Long, Supplier> supplierMap = this.queryUtil.getSupplierMap(null);
      Map<Long, PurchaseOrder> prchaseOrderMap = this.queryUtil.getPrchaseOrderMap(null);
      Map<Long, ContractProject> projectMap = this.queryUtil.getProjectMap(null);
      return new PageVO<>(
         pageInfo,
         pageInfo.getList()
            .stream()
            .map(
               inbound -> {
                  BriefInboundDTO inboundDTO = BeanUtil.copy(inbound, BriefInboundDTO.class);
                  if (inbound.getRejectStatus().equals(RejectEnum.PART_REJECT.getType()) && CollectionUtil.isNotEmpty(dtoParam.getRejectStatus())) {
                     Integer integer = this.inboundDetailMapper
                        .selectCount(
                           (Wrapper<InboundDetail>)(new LambdaQueryWrapper<InboundDetail>().eq(InboundDetail::getInboundId, inbound.getId()))
                              .eq(InboundDetail::getRejectStatus, RejectEnum.NO_REJECT.getType())
                        );
                     if (integer > 0) {
                        inboundDTO = BeanUtil.copy(inbound, BriefInboundDTO.class);
                     }

                     return null;
                  } else {
                     inboundDTO.setPurchaseSN(inbound.getPurchaseSn());
                     inboundDTO.setSupplier(supplierMap.get(inbound.getSupplierId()));
                     if (StrUtil.isNotBlank(inbound.getProjectIds())) {
                        List<Long> idList = Arrays.stream(org.apache.commons.lang3.StringUtils.split(inbound.getProjectIds(), ","))
                           .map(Long::parseLong)
                           .collect(Collectors.toList());
                        List<ContractProject> list = new ArrayList<>();
                        idList.forEach(id -> {
                           if (projectMap.containsKey(id)) {
                              list.add(projectMap.get(id));
                           }
                        });
                        List<ProjectInfo> collect = list.stream().map(project -> BeanUtil.copy(project, ProjectInfo.class)).collect(Collectors.toList());
                        inboundDTO.setProjects(collect);
                     }

                     if (StrUtil.isNotBlank(inbound.getAttachmentIds())) {
                        inboundDTO.setAttachments(this.attachmentService.listByIds(inbound.getAttachmentIds()));
                     }

                     if (inbound.getPurchaseId() != null) {
                        PurchaseOrder byId = prchaseOrderMap.get(inbound.getPurchaseId());
                        inboundDTO.setPurchaseSN(byId.getSerialNumber());
                     }

                     return inboundDTO;
                  }
               }
            )
            .filter(inboundDTO -> inboundDTO != null)
            .collect(Collectors.toList())
      );
   }

   @Override
   public List<Inbound> listInfo(QueryInboundDTOParam dtoParam) {
      return this.baseMapper.listInfo(dtoParam);
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean saveInbound(InboundDTOParam dtoParam) {
      Inbound inbound = new Inbound();
      PurchaseOrder order = null;
      if (dtoParam.getPurchaseId() != null && !SupplyTypeEnum.PARTY_A.getType().equals(dtoParam.getSupplyType())) {
         order = this.purchaseOrderService.getById(dtoParam.getPurchaseId());
         Preconditions.checkArgument(order != null, "采购订单不存在");
         Preconditions.checkArgument(PurchaseStatusEnum.DURING.getType().equals(order.getPurchaseStatus()), "新增入库单失败订单[" + order.getSerialNumber() + "]已完成采购.");
         Preconditions.checkArgument(
            SettlementStatusEnum.UN_SETTLED.getType().equals(order.getSettlementStatus()), "新增入库单失败,订单[" + order.getSerialNumber() + "]已结算"
         );
         if (LogisticsPayerEnum.DEMAND.getType().equals(order.getLogisticsPayerType())
            && LogisticsTransportTypeEnum.FREIGHT.getType().equals(order.getLogisticsTransportType())) {
            Preconditions.checkArgument(StrUtil.isNotBlank(dtoParam.getLicensePlate()), "请输入车牌号");
            StringBuilder builder = CommonUtil.checkLicensePlate(dtoParam.getLicensePlate());
            inbound.setLicensePlate(builder.toString());
         } else if (StrUtil.isNotBlank(dtoParam.getLicensePlate())) {
            StringBuilder builder = CommonUtil.checkLicensePlate(dtoParam.getLicensePlate());
            inbound.setLicensePlate(builder.toString());
         }
      }

      if (order != null) {
         inbound.setSupplierId(order.getSupplierId());
         inbound.setPurchaseSn(order.getSerialNumber());
         inbound.setPurchaseId(order.getId());
      }

      if (dtoParam.getBoolNestSurplus() != null && dtoParam.getBoolNestSurplus()) {
         inbound.setBoolPartyA(false);
      } else {
         inbound.setBoolPartyA(Objects.isNull(order));
      }

      inbound.setReviewStatus(ReviewStatusEnum.UN_REVIEWED.getType());
      inbound.setApplicantId(UserUtil.getCurrentUserId());
      inbound.setApplicantName(UserUtil.getCurrentName());
      inbound.setUserUpdateTime(LocalDateTime.now());
      inbound.setEditorId(UserUtil.getCurrentUserId());
      inbound.setEditorName(UserUtil.getCurrentName());
      inbound.setShipmentNumber(dtoParam.getShipmentNumber());
      inbound.setRejectStatus(RejectEnum.NO_REJECT.getType());
      if (dtoParam.getBoolNestSurplus() != null) {
         inbound.setBoolNestSurplus(dtoParam.getBoolNestSurplus());
      }

      if (dtoParam.getReviewStatus() != null && ReviewStatusEnum.RETURNED.getType().equals(dtoParam.getReviewStatus())) {
         Inbound sourceInbound = this.baseMapper.selectById(dtoParam.getId());
         if (sourceInbound.getOriginalId() != null) {
            sourceInbound = this.baseMapper.selectById(sourceInbound.getOriginalId());
         }

         this.baseMapper.updateEditable(sourceInbound.getId(), 0);
         Integer number = sourceInbound.getOriginalNumber();
         number = number + 1;
         sourceInbound.setOriginalNumber(number);
         sourceInbound.setEditable(false);
         this.baseMapper.updateById(sourceInbound);
         inbound.setSerialNumber(sourceInbound.getSerialNumber() + "-" + number);
         inbound.setOriginalId(sourceInbound.getId());
         inbound.setEditable(true);
         this.baseMapper.insert(inbound);
      } else {
         String serialNumber;
         List<Inbound> wmsApproveRecords;
         Integer maxDayNumber;
         do {
            maxDayNumber = this.queryUtil.createInboundSerialNumber("inbound");
            serialNumber = this.numberConfigService.getNumber(NumberTypeEnum.INBOUND, maxDayNumber);
            wmsApproveRecords = this.baseMapper.selectList((Wrapper<Inbound>)new LambdaQueryWrapper<Inbound>().eq(Inbound::getSerialNumber, serialNumber));
         } while (!CollectionUtils.isEmpty(wmsApproveRecords));

         inbound.setEditable(true);
         inbound.setEstablishQuantity(maxDayNumber);
         inbound.setSerialNumber(serialNumber);
         this.baseMapper.insert(inbound);
      }

      this.checkInboundDetailParam(inbound, dtoParam, order);
      this.classificationService.updateClassifyUsed(IdsStatusDTO.builder().idsStr(inbound.getClassifyIds()).build());
      if (order != null && LogisticsPayerEnum.DEMAND.getType().equals(order.getLogisticsPayerType()) && inbound.getFreight() != null) {
         inbound.setFreightWeight(dtoParam.getLogistics().getFreightWeight());
         this.generateLogisticsOrder(dtoParam, inbound, order, ReviewStatusEnum.UN_REVIEWED.getType());
      }

      return this.baseMapper.updateById(inbound) == 1;
   }

   private void checkInboundDetailParam(Inbound inbound, InboundDTOParam dtoParam, PurchaseOrder order) {
      Print print = null;
      BasicInbound inboundBasicConf = this.basicConfigService.getInboundBasicConf();
      List<Long> projectIds = new ArrayList<>();
      int basicClass = 0;
      BigDecimal inboundTotalWeight = new BigDecimal(BigInteger.ZERO);
      BigDecimal loadingWeight = dtoParam.getLoadingWeight();
      boolean boolQualityTesting = false;
      WmsClosingTime one = this.wmsClosingTimeService
         .getOne((Wrapper<WmsClosingTime>)(new LambdaQueryWrapper<WmsClosingTime>().orderBy(true, false, WmsClosingTime::getId)).last("limit 1"));
      TreeSet<String> classifyIds = new TreeSet<>();
      Map<Long, Classification> classificationMap = new HashMap<>();
      if (CollectionUtil.isNotEmpty(dtoParam.getList())) {
         List<ClassificationCheckDTO> classificationCheckDTOS = dtoParam.getList()
            .stream()
            .map(d -> cn.hutool.core.bean.BeanUtil.toBean(d, ClassificationCheckDTO.class))
            .collect(Collectors.toList());
         classificationMap = this.classificationService.checkClassification(classificationCheckDTOS, dtoParam.getClickTime());
      }

      for (InboundDetailDTOParam detailParam : dtoParam.getList()) {
         Measure measure = this.measureMapper.selectOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, detailParam.getClassifyId()));
         if (one != null && detailParam.getRealTime() != null) {
            Preconditions.checkArgument(
               detailParam.getRealTime().isAfter(one.getEndTime()) && detailParam.getRealTime().isBefore(LocalDateTime.now()), "实际时间不能在实际关账时间之前,请刷新页面重新办理"
            );
         }

         PurchaseOrderDetail orderDetail = null;
         Long purchaseOrderDetailId = detailParam.getApplyPurchaseId() == null ? detailParam.getPurchaseOrderDetailId() : detailParam.getPurchaseDetailId();
         if (purchaseOrderDetailId != null) {
            orderDetail = this.poDetailService.getById(purchaseOrderDetailId);
         }

         Preconditions.checkArgument(detailParam.getWorkshopId() != null, "请选择车间");
         Preconditions.checkArgument(detailParam.getWarehouseId() != null, "请选择仓库");
         this.checkInfo(detailParam);
         if (orderDetail != null) {
            Preconditions.checkArgument(
               orderDetail.getMete()
                     .add(orderDetail.getMete().multiply(inboundBasicConf.getProcureMeteDiff().divide(BigDecimal.valueOf(100L))))
                     .compareTo(orderDetail.getInboundMete().add(detailParam.getMete()))
                  >= 0,
               "当前入库量已超出采购量允许误差范围（" + inboundBasicConf.getProcureMeteDiff().toPlainString() + "%)"
            );
         }

         Classification classification = classificationMap.get(detailParam.getClassifyId());
         classifyIds.add(classification.getId().toString());
         InboundDetail inboundDetail = BeanUtil.copy(detailParam, InboundDetail.class);
         inboundDetail.setPurchaseOrderDetailId(purchaseOrderDetailId);
         if (measure.getBoolQualityTesting()) {
            inboundDetail.setQualityTestingEnum(QualityTestingEnum.UN_REVIEWED.getType());
            if (!boolQualityTesting) {
               boolQualityTesting = true;
            }
         } else {
            inboundDetail.setQualityTestingEnum(QualityTestingEnum.NO.getType());
         }

         inboundDetail.setMeasureUnit(measure.getMeasureUnit());
         inboundDetail.setMeasurePrecision(measure.getMeasurePrecision());
         inboundDetail.setAccountingUnit(measure.getAccountingUnit());
         inboundDetail.setAccountingPrecision(measure.getAccountingPrecision());
         inboundDetail.setBrand(StrUtil.trimToNull(detailParam.getBrand()));
         inboundDetail.setColor(StrUtil.trimToNull(detailParam.getColor()));
         inboundDetail.setHeatNoAndBatchNo(StrUtil.trimToNull(detailParam.getHeatNoAndBatchNo()));
         inboundDetail.setClassifyName(classification.getName());
         inboundDetail.setLength(BasicClassEnum.COLOR_ROLL.getType().equals(inboundDetail.getBasicClass()) ? null : detailParam.getLength());
         inboundDetail.setInboundId(inbound.getId());
         if (order != null) {
            inboundDetail.setInvoiceType(order.getInvoiceType());
            inboundDetail.setTaxRate(order.getTaxRate());
            inboundDetail.setUnitPrice(detailParam.getUnitPrice());
            inboundDetail.setAmount(detailParam.getAmount());
            inboundDetail.setApplyPurchaseId(detailParam.getApplyPurchaseId());
            if (InvoiceTypeEnum.SPECIAL.getType().equals(order.getInvoiceType())) {
               BigDecimal value = order.getTaxRate().divide(HUNDRED).add(BigDecimal.ONE);
               if (inboundDetail.getAmount() != null) {
                  inboundDetail.setAmountExcludingVat(inboundDetail.getAmount().divide(value, 2, RoundingMode.HALF_UP));
                  inboundDetail.setUnitPriceExcludingVat(inboundDetail.getAmountExcludingVat().divide(inboundDetail.getMete(), 12, RoundingMode.HALF_UP));
                  inboundDetail.setInputVat(inboundDetail.getAmount().subtract(inboundDetail.getAmountExcludingVat()));
               }
            } else {
               inboundDetail.setAmountExcludingVat(inboundDetail.getAmount());
               inboundDetail.setUnitPriceExcludingVat(inboundDetail.getUnitPrice());
            }
         } else {
            inboundDetail.setAmount(BigDecimal.ZERO);
            inboundDetail.setAmountExcludingVat(BigDecimal.ZERO);
            inboundDetail.setUnitPriceExcludingVat(BigDecimal.ZERO);
            inboundDetail.setUnitPrice(BigDecimal.ZERO);
         }

         if (detailParam.getBoolNestSurplus() != null) {
            if (detailParam.getBoolNestSurplus()) {
               String surplusSn = this.queryUtil.getSurplusSn();
               inboundDetail.setSurplusSn(surplusSn);
               inboundDetail.setNestSurplusCode(surplusSn);
               inboundDetail.setBoolNestSurplus(true);
               inboundDetail.setBoolPartyA(false);
               String fileName = inboundDetail.getDxfUrl().substring(inboundDetail.getDxfUrl().lastIndexOf(47) + 1);
               String s = this.downloadFile.downloadFile(inboundDetail.getDxfUrl(), fileName);
               String s1 = inboundDetail.getImgUrl().substring(inboundDetail.getImgUrl().lastIndexOf(47) + 1);
               String image = this.downloadFile.downloadFile(inboundDetail.getImgUrl(), s1);
               inboundDetail.setDxfUrl(s);
               inboundDetail.setImgUrl(image);
            }
         } else {
            inboundDetail.setBoolNestSurplus(false);
         }

         if (order != null) {
            Preconditions.checkArgument((order.getBasicClass() & detailParam.getBasicClass()) > 0, "当前物料不符合采购订单物料类型");
         }

         basicClass |= detailParam.getBasicClass();
         Set<String> keys = new HashSet<>();
         if (detailParam.getSpecificationMap() != null) {
            keys = detailParam.getSpecificationMap().keySet();
         }

         StringBuilder specification = new StringBuilder();
         if (!BasicClassEnum.SECTION_STEEL.getType().equals(detailParam.getBasicClass())) {
            if (BasicClassEnum.STEEL_PLATE.getType().equals(detailParam.getBasicClass())) {
               Map<String, String> map = this.specificationService.checkClassifySpec(detailParam.getClassifyId(), detailParam.getSpecification());
               String specCode = map.get("code");
               specification.append(map.get("ids"));
               inboundDetail.setMaterialSn(classification.getSerialNumber() + (StrUtil.isNotBlank(specCode) ? "-" + specCode : ""));
               inboundDetail.setTheoryThickness(detailParam.getThickness().setScale(0, RoundingMode.HALF_UP));
               BigDecimal oneTheoryMete = CommonUtil.getTheoryMete(
                  classification.getName(), inboundDetail.getLength(), inboundDetail.getWidth(), inboundDetail.getThickness(), null, classification.getId()
               );
               BigDecimal theoryWeight = oneTheoryMete.multiply(
                     BasicClassEnum.COLOR_ROLL.getType().equals(detailParam.getBasicClass()) ? BigDecimal.ONE : detailParam.getQuantity()
                  )
                  .setScale(0, RoundingMode.HALF_UP);
               inboundDetail.setOneTheoryWeight(oneTheoryMete);
               inboundDetail.setTheoryWeight(theoryWeight);
               inboundTotalWeight = inboundTotalWeight.add(detailParam.getMete());
            } else if (BasicClassEnum.COLOR_ROLL.getType().equals(detailParam.getBasicClass())) {
               Map<String, String> map = this.specificationService.checkClassifySpec(detailParam.getClassifyId(), detailParam.getSpecification());
               String specCode = map.get("code");
               specification.append(map.get("ids"));
               inboundDetail.setMaterialSn(classification.getSerialNumber() + (StrUtil.isNotBlank(specCode) ? "-" + specCode : ""));
               BigDecimal inboundMete = detailParam.getMete().divide(THOUSAND, 0, RoundingMode.HALF_UP);
               if (loadingWeight != null) {
                  loadingWeight = loadingWeight.subtract(inboundMete);
               }

               inboundDetail.setOneTheoryWeight(inboundMete);
            } else if (BasicClassEnum.checkNotSteel(detailParam.getBasicClass())) {
               Map<String, String> map = this.specificationService.checkClassifySpec(detailParam.getClassifyId(), detailParam.getSpecification());
               String specCode = map.get("code");
               specification.append(map.get("ids"));
               inboundDetail.setMaterialSn(classification.getSerialNumber() + (StrUtil.isNotBlank(specCode) ? "-" + specCode : ""));
               inboundDetail.setUnitNet(
                  detailParam.getQuantity() != null ? detailParam.getMete().divide(detailParam.getQuantity(), 8, RoundingMode.HALF_UP) : BigDecimal.ONE
               );
            }
         } else {
            String sn = "";
            String specCode = "";

            for (String key : keys) {
               String spec = detailParam.getSpecificationMap().get(key);
               String[] split = key.split("_");
               if (split.length == 2) {
                  SectionSteelConfig sectionSteelConfig = this.sectionSteelConfigMapper.selectById(Long.parseLong(split[1]));
                  SectionSteelSpec sectionSteelSpec = this.sectionSteelSpecService
                     .getOne(
                        (Wrapper<SectionSteelSpec>)(Wrappers.<SectionSteelSpec>lambdaQuery()
                              .eq(SectionSteelSpec::getClassificationId, classification.getId()))
                           .eq(SectionSteelSpec::getSpecification, spec)
                     );
                  Preconditions.checkArgument(sectionSteelSpec != null, "当前规格为[" + spec + "]的型材不存在.");
                  SectionSteelSpecStandardDetail standardDetail = this.sectionSteelSpecStandardDetailMapper
                     .selectOne(
                        (Wrapper<SectionSteelSpecStandardDetail>)((Wrappers.<SectionSteelSpecStandardDetail>lambdaQuery()
                                 .eq(SectionSteelSpecStandardDetail::getSpecId, sectionSteelSpec.getId()))
                              .eq(SectionSteelSpecStandardDetail::getStandardId, sectionSteelConfig.getStandardId()))
                           .eq(SectionSteelSpecStandardDetail::getSectionSteelId, sectionSteelConfig.getId())
                     );
                  Preconditions.checkArgument(ObjectUtil.isNotEmpty(standardDetail), "入库失败,当前型材规格未配置国标重量");
                  Preconditions.checkArgument(
                     standardDetail.getUnitNet() != null && standardDetail.getUnitNet().compareTo(BigDecimal.ZERO) > 0, "入库失败,当前型材规格未配置国标重量"
                  );
                  Standard standard = this.standardMapper.selectById(sectionSteelConfig.getStandardId());
                  sn = standard.getCode() + "-" + standardDetail.getCode();
                  SectionSteelSpecDTO weightByClassifyId = this.sectionSteelSpecService.getWeightByClassifyId(detailParam.getClassifyId(), spec);
                  BigDecimal oneMete = CommonUtil.getTheoryMete(
                     null, inboundDetail.getLength(), null, null, weightByClassifyId.getDetail().getUnitNet(), classification.getId()
                  );
                  BigDecimal theoryWeight = oneMete.multiply(detailParam.getQuantity()).setScale(0, RoundingMode.HALF_UP);
                  inboundDetail.setSectionSteelWeight(weightByClassifyId.getDetail().getUnitNet());
                  inboundDetail.setOneTheoryWeight(oneMete);
                  inboundDetail.setTheoryWeight(theoryWeight);
                  inboundDetail.setStandardId(sectionSteelConfig.getStandardId());
                  inboundDetail.setStandardName(sectionSteelConfig.getStandardName());
                  inboundDetail.setSectionSteelSpecId(sectionSteelSpec.getId());
               } else {
                  Map<String, String> map = this.specificationService.checkClassifySpec(detailParam.getClassifyId(), spec);
                  specCode = map.get("code");
                  specification.append(map.get("ids"));
               }
            }

            inboundDetail.setMaterialSn(classification.getSerialNumber() + "-" + sn + specCode);
            inboundTotalWeight = inboundTotalWeight.add(detailParam.getMete());
         }

         Measure measure1 = this.getMeasure(classification.getId());
         if (measure1.getOutboundUnitType().equals(MeasureTypeEnum.MEASURE.getType())) {
            Preconditions.checkArgument(ObjectUtil.isNotEmpty(inboundDetail.getQuantity()), classification.getName() + "为计量方式，但未提交数量，请检查该科目计量配置！！！");
         }

         if (measure1.getOutboundUnitType().equals(MeasureTypeEnum.ACCOUNTING.getType())) {
            Preconditions.checkArgument(ObjectUtil.isEmpty(inboundDetail.getQuantity()), classification.getName() + "为核算方式，但提交了数量，请检查该科目计量配置！！！");
         }

         inboundDetail.setBoolPartyA(inbound.getBoolPartyA());
         inboundDetail.setSpecificationIds(specification.toString());
         if (StrUtil.isEmpty(inboundDetail.getSpecification())) {
            inboundDetail.setSpecification(null);
         }

         this.inboundDetailMapper.insert(inboundDetail);
         if (!measure.getBoolQualityTesting()) {
            print = this.setBarcode(inbound, inboundDetail, print);
            this.inboundDetailMapper.updateById(inboundDetail);
         }

         if (orderDetail != null) {
            if (inboundDetail.getQuantity() != null) {
               orderDetail.setInboundQuantity(
                  orderDetail.getInboundQuantity() != null ? orderDetail.getInboundQuantity().add(inboundDetail.getQuantity()) : inboundDetail.getQuantity()
               );
            }

            orderDetail.setInboundMete(
               orderDetail.getInboundMete() != null ? orderDetail.getInboundMete().add(inboundDetail.getMete()) : inboundDetail.getMete()
            );
            this.poDetailService.updateById(orderDetail);
         }

         if (inboundDetail.getProjectId() != null && !projectIds.contains(inboundDetail.getProjectId())) {
            projectIds.add(inboundDetail.getProjectId());
         }
      }

      if (CollectionUtils.isNotEmpty(classifyIds)) {
         inbound.setClassifyIds(String.join(",", classifyIds));
      }

      Map<String, Unit> unitMap = this.queryUtil.getUnitMap(null);
      if (dtoParam.getLoadingWeight() == null && BasicClassEnum.checkIsSteel(basicClass)) {
         List<Integer> nameStr2 = BasicClassEnum.getNameStr2(basicClass);
         List<Measure> measures = this.measureMapper.selectList((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().in(Measure::getBasicClass, nameStr2));
         Map<Integer, BigDecimal> mete = this.queryUtil
            .unitConversionV2(inboundTotalWeight, measures.get(0).getAccountingUnit(), measures.get(0).getAccountingPrecision(), unitMap);
         inbound.setLoadingWeight(dtoParam.getLoadingWeight() != null ? dtoParam.getLoadingWeight() : mete.get(1));
      } else {
         inbound.setLoadingWeight(dtoParam.getLoadingWeight());
      }

      if (boolQualityTesting) {
         inbound.setQualityTestingEnum(QualityTestingEnum.UN_REVIEWED.getType());
      } else {
         inbound.setQualityTestingEnum(QualityTestingEnum.NO.getType());
      }

      if (order != null && LogisticsPayerEnum.DEMAND.getType().equals(order.getLogisticsPayerType())) {
         if (dtoParam.getLogistics() != null) {
            LogisticsOrder logistics = dtoParam.getLogistics();
            if (logistics.getFreight() != null && logistics.getSupplierId() != null) {
               inbound.setLogisticsSupplierId(logistics.getSupplierId());
               inbound.setFreight(logistics.getFreight());
            } else {
               Preconditions.checkArgument(logistics.getFreight() != null, "请设置运费");
               Preconditions.checkArgument(logistics.getSupplierId() != null, "请设置物流公司");
            }
         } else {
            Preconditions.checkArgument(LogisticsPayerEnum.DEMAND.getType().equals(order.getLogisticsPayerType()), "运费由需方承担,请设置物流信息");
         }
      }

      if (CollectionUtil.isNotEmpty(projectIds)) {
         String idStr = StrUtil.join(",", projectIds);
         inbound.setProjectIds(idStr);
      }

      inbound.setPurchaseId(dtoParam.getPurchaseId());
      inbound.setBasicClass(basicClass);
      if (print != null) {
         print.setProjectIds(inbound.getProjectIds());
         print.setContainBasicClass(inbound.getBasicClass());
         this.printService.updateById(print);
      }
   }

   private Integer getFlows(InboundDTOParam dtoParam, BasicInbound basicInbound, PurchaseOrder order, MountMessageDTO mountMessageDTO) {
      Integer approveProcessType = null;
      new ArrayList();
      if (dtoParam.getSupplyType().equals(SupplyTypeEnum.PARTY_A.getType())) {
         return ApproveProcessTypeEnumV2.PARTY_A_SUPPLY_IN.getType();
      }

      if (dtoParam.getSupplyType().equals(SupplyTypeEnum.SELF.getType())) {
         approveProcessType = ApproveProcessTypeEnumV2.SELF_BUYING_IN.getType();
         List<WmsApproveTemplateVersionsFlow> wmsApproveTemplateVersionsFlows = this.wmsApproveTemplateService
            .getWmsApproveTemplateVersionsFlows(ApproveProcessTypeEnumV2.SELF_BUYING_IN.getType(), null, mountMessageDTO);
         StringBuffer msg = new StringBuffer();
         if (order.getBoolDetail().equals(Boolean.FALSE) && basicInbound.getAmountFillWay().equals(FillWayEnum.AUDIT.getType())) {
            if (msg.length() > 0) {
               msg.append("和");
            }

            msg.append("无明细金额显示场景");
         }

         StringBuffer msgTwo = new StringBuffer();
         if (order.getLogisticsPayerType().equals(LogisticsPayerEnum.DEMAND.getType())) {
            if (basicInbound.getMoney().equals(FillWayEnum.AUDIT.getType())) {
               if (msgTwo.length() > 0) {
                  msgTwo.append("和");
               }

               msgTwo.append("运费金额");
            }

            if (basicInbound.getWeight().equals(FillWayEnum.AUDIT.getType())) {
               if (msgTwo.length() > 0) {
                  msgTwo.append("和");
               }

               msgTwo.append("运输重量");
            }

            if (basicInbound.getLoadingFee().equals(FillWayEnum.AUDIT.getType())) {
               if (msgTwo.length() > 0) {
                  msgTwo.append("和");
               }

               msgTwo.append("装车费");
            }

            if (basicInbound.getInvoiceTax().equals(FillWayEnum.AUDIT.getType())) {
               if (msgTwo.length() > 0) {
                  msgTwo.append("和");
               }

               msgTwo.append("发票税率");
            }

            if (basicInbound.getLogisticsUnit().equals(FillWayEnum.AUDIT.getType())) {
               if (msgTwo.length() > 0) {
                  msgTwo.append("和");
               }

               msgTwo.append("物流单位");
            }
         }

         if (ObjectUtil.isEmpty(msg) && ObjectUtil.isEmpty(msgTwo)) {
            return approveProcessType;
         }

         Preconditions.checkArgument(
            CollectionUtils.isNotEmpty(wmsApproveTemplateVersionsFlows), (ObjectUtil.isNotEmpty(msg) ? msg : msgTwo) + "为审核时填写，但无审核流程，提交失败"
         );
         Long approveVersionsId = ((WmsApproveTemplateVersionsFlow)wmsApproveTemplateVersionsFlows.get(0)).getApproveVersionsId();
         WmsApproveTemplateVersions wmsApproveTemplateVersions = this.wmsApproveTemplateVersionsService.getById(approveVersionsId);
         List<WmsApproveTemplateVersionsFlow> noCopySendList = wmsApproveTemplateVersionsFlows.stream()
            .filter(w -> !w.getType().equals(ApproveTemplateVersionsFlowEnum.COPY_SEND.getType()))
            .collect(Collectors.toList());
         Preconditions.checkArgument(
            CollectionUtils.isNotEmpty(noCopySendList),
            (ObjectUtil.isNotEmpty(msg) ? msg : msgTwo) + "为审核时填写--但" + wmsApproveTemplateVersions.getName() + "流程仅存在抄送，提交失败"
         );
         List<Long> collect = noCopySendList.stream().map(WmsApproveTemplateVersionsFlow::getId).collect(Collectors.toList());
         List<WmsApproveFlowOperation> wmsApproveFlowOperations = this.wmsApproveFlowOperationService
            .list((Wrapper<WmsApproveFlowOperation>)new LambdaQueryWrapper<WmsApproveFlowOperation>().in(WmsApproveFlowOperation::getFlowId, collect));
         boolean hasMoneyOperation = false;
         boolean hasFreightOperation = false;

         for (WmsApproveFlowOperation operation : wmsApproveFlowOperations) {
            if (operation.getOperationType().equals(ApproveFlowOperationEnum.OPERATION_MONEY.getType()) && "1".equals(operation.getOperation())) {
               hasMoneyOperation = true;
            }

            if (operation.getOperationType().equals(ApproveFlowOperationEnum.FREIGHT_MSG.getType()) && "1".equals(operation.getOperation())) {
               hasFreightOperation = true;
            }
         }

         if (ObjectUtil.isNotEmpty(msg)) {
            Preconditions.checkArgument(hasMoneyOperation, msg + "为审核时填写--但" + wmsApproveTemplateVersions.getName() + "流程中未存在可编辑金额的流程，提交失败");
         }

         if (ObjectUtil.isNotEmpty(msgTwo)) {
            Preconditions.checkArgument(hasFreightOperation, msgTwo + "为审核时填写--但" + wmsApproveTemplateVersions.getName() + "流程中未存在运费信息填写的流程，提交失败");
         }
      }

      return approveProcessType;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean saveSelfBuyingInboundV2(InboundDTOParam dtoParam) {
      dtoParam.setSupplyType(SupplyTypeEnum.SELF.getType());
      PurchaseOrder order = this.purchaseOrderService.getById(dtoParam.getPurchaseId());
      Preconditions.checkArgument(order != null, "采购订单不存在");
      Preconditions.checkArgument(order.getDataStatus().equals(DataStatusEnum.SUCCEED.getType()), "新增入库单失败,订单[" + order.getSerialNumber() + "]状态有变化");
      Preconditions.checkArgument(PurchaseStatusEnum.DURING.getType().equals(order.getPurchaseStatus()), "新增入库单失败订单[" + order.getSerialNumber() + "]已完成采购.");
      Preconditions.checkArgument(
         SettlementStatusEnum.UN_SETTLED.getType().equals(order.getSettlementStatus()), "新增入库单失败,订单[" + order.getSerialNumber() + "]已结算"
      );
      List<Long> projectIds = dtoParam.getList().stream().map(InboundDetailDTOParam::getProjectId).filter(ObjectUtil::isNotEmpty).collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(projectIds)) {
         BranchCompany byId = this.branchCompanyService.getById(order.getBranchCompanyId());
         List<ContractProject> projects = this.contractProjectService.listByIds(projectIds);
         List<ContractProject> collect = projects.stream().filter(p -> (byId.getLevel() & p.getLevel()) <= 0).collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(collect)) {
            List<String> shortNames = collect.stream().map(ContractProject::getShortName).collect(Collectors.toList());
            Preconditions.checkArgument(false, shortNames + "与采购单所选签订主体层级不一致");
         }
      }

      BasicInbound basicInbound = this.basicConfigService.getInboundBasicConfV2();
      List<Integer> basicClass = new ArrayList<>();
      basicClass.add(dtoParam.getBasicClass());
      MountMessageDTO mountMessageDTO = new MountMessageDTO();
      mountMessageDTO.setBasicClass(basicClass);
      Integer approveProcessType = this.getFlows(dtoParam, basicInbound, order, mountMessageDTO);
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(approveProcessType), "未查询到审批模板枚举类型，添加失败");
      Inbound inbound = new Inbound();
      if (LogisticsPayerEnum.DEMAND.getType().equals(order.getLogisticsPayerType())
         && LogisticsTransportTypeEnum.FREIGHT.getType().equals(order.getLogisticsTransportType())) {
         Preconditions.checkArgument(StrUtil.isNotBlank(dtoParam.getLicensePlate()), "请输入车牌号");
      }

      if (StrUtil.isNotBlank(dtoParam.getLicensePlate())) {
         StringBuilder builder = CommonUtil.checkLicensePlate(dtoParam.getLicensePlate());
         inbound.setLicensePlate(builder.toString());
      }

      inbound.setMesWorkshopId(order.getWorkshopId());
      inbound.setSupplierId(order.getSupplierId());
      inbound.setPurchaseSn(order.getSerialNumber());
      inbound.setPurchaseId(order.getId());
      inbound.setBoolPartyA(false);
      inbound.setReviewStatus(ReviewStatusEnum.AUDITING.getType());
      inbound.setApplicantId(UserUtil.getCurrentUserId());
      inbound.setApplicantName(UserUtil.getCurrentName());
      inbound.setUserUpdateTime(LocalDateTime.now());
      inbound.setEditorId(UserUtil.getCurrentUserId());
      inbound.setEditorName(UserUtil.getCurrentName());
      inbound.setShipmentNumber(dtoParam.getShipmentNumber());
      inbound.setRejectStatus(RejectEnum.NO_REJECT.getType());
      if ((dtoParam.getReviewStatus() == null || !ReviewStatusEnum.RETURNED.getType().equals(dtoParam.getReviewStatus()))
         && !ReviewStatusEnum.CANCEL.getType().equals(dtoParam.getReviewStatus())) {
         while (true) {
            Integer maxDayNumber = this.queryUtil.createInboundSerialNumber("inbound");
            String serialNumber = this.numberConfigService.getNumber(NumberTypeEnum.INBOUND, maxDayNumber);
            List<Inbound> wmsApproveRecords = this.baseMapper.selectList((Wrapper<Inbound>)new LambdaQueryWrapper<Inbound>().eq(Inbound::getSerialNumber, serialNumber));
            if (CollectionUtils.isEmpty(wmsApproveRecords)) {
               inbound.setEditable(true);
               inbound.setEstablishQuantity(maxDayNumber);
               inbound.setSerialNumber(serialNumber);
               break;
            }
         }
      } else {
         Inbound sourceInbound = this.baseMapper.selectById(dtoParam.getId());
         if (sourceInbound.getOriginalId() != null) {
            sourceInbound = this.baseMapper.selectById(sourceInbound.getOriginalId());
         }

         this.baseMapper.updateEditable(sourceInbound.getId(), 0);
         Integer number = sourceInbound.getOriginalNumber();
         number = number + 1;
         sourceInbound.setOriginalNumber(number);
         sourceInbound.setEditable(false);
         this.baseMapper.updateById(sourceInbound);
         inbound.setSerialNumber(sourceInbound.getSerialNumber() + "-" + number);
         inbound.setOriginalId(sourceInbound.getId());
         inbound.setEditable(true);
      }

      if (ObjectUtil.isNotEmpty(dtoParam.getLogistics())) {
         inbound.setFreightJson(JSON.toJSONString(dtoParam.getLogistics(), SerializerFeature.DisableCircularReferenceDetect));
      }

      this.baseMapper.insert(inbound);
      this.checkInboundDetailParamV2(inbound, dtoParam, order, basicInbound);
      this.classificationService.updateClassifyUsed(IdsStatusDTO.builder().idsStr(inbound.getClassifyIds()).build());
      boolean boolQualityTesting = inbound.getQualityTestingEnum().equals(QualityTestingEnum.UN_REVIEWED.getType());
      WmsApproveRecordDetail wmsApproveRecordDetail = null;
      if (boolQualityTesting) {
         wmsApproveRecordDetail = new WmsApproveRecordDetail();
         wmsApproveRecordDetail.setCreateTime(LocalDateTime.now());
         wmsApproveRecordDetail.setArrivalTime(LocalDateTime.now());
         wmsApproveRecordDetail.setDataId(inbound.getId());
         wmsApproveRecordDetail.setModuleType(ModuleTypeEnum.WMS.getType());
         wmsApproveRecordDetail.setFunctionType(FunctionTypeEnum.WMS_SELF_BUYING_IN.getType());
         wmsApproveRecordDetail.setApproveProcessType(approveProcessType);
         wmsApproveRecordDetail.setFlowType(ApproveTemplateVersionsFlowEnum.QUALITY_TESTING.getType());
         wmsApproveRecordDetail.setStatus(ApproveRecordStatusEnum.UNDERWAY.getType());
      }

      this.baseMapper.updateById(inbound);
      InboundDTO inboundDTO = this.getInboundDTOById(inbound.getId(), false);
      String jsonData = JSON.toJSONString(inboundDTO, SerializerFeature.DisableCircularReferenceDetect);
      StringBuilder subjoinMsgBuilder = new StringBuilder();
      String subjoinMsg = null;
      if (subjoinMsgBuilder.length() > 0) {
         subjoinMsg = subjoinMsgBuilder.toString();
      }

      subjoinMsg = subjoinMsgBuilder.toString();
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService
         .createRecord(
            inbound.getId(),
            inbound.getSerialNumber(),
            approveProcessType,
            dtoParam.getCause(),
            wmsApproveRecordDetail,
            jsonData,
            false,
            mountMessageDTO,
            subjoinMsg,
            null
         );
      inbound.setApproveRecordId(wmsApproveRecord.getId());
      this.baseMapper.updateById(inbound);
      if (wmsApproveRecord.getStatus().equals(ApproveRecordStatusEnum.END.getType())) {
         dtoParam.setInbound(inbound);
         this.passedSelfBuyingV2(dtoParam);
      }

      this.pushMessage(
         inbound, wmsApproveRecord, NotificationModuleTypeEnum.WMS_MATERIAL_SELF_PURCHASE_INBOUND.getNotificationType(), SupplyTypeEnum.SELF.getType()
      );
      return true;
   }

   @Transactional
   @Override
   public synchronized Boolean saveBeginSelfBuyingInbound(InboundDTOParam dtoParam) {
      Inbound inbound = new Inbound();
      dtoParam.setSupplyType(SupplyTypeEnum.SELF.getType());
      List<Integer> basicClass = new ArrayList<>();
      basicClass.add(dtoParam.getBasicClass());
      MountMessageDTO mountMessageDTO = new MountMessageDTO();
      mountMessageDTO.setBasicClass(basicClass);
      mountMessageDTO.setInboundWay(Collections.singletonList(InboundWayEnum.BEGIN_PERIOD.getType()));
      Integer approveProcessType = ApproveProcessTypeEnumV2.SELF_BUYING_IN.getType();
      inbound.setBoolPartyA(false);
      inbound.setReviewStatus(ReviewStatusEnum.AUDITING.getType());
      inbound.setApplicantId(UserUtil.getCurrentUserId());
      inbound.setApplicantName(UserUtil.getCurrentName());
      inbound.setUserUpdateTime(LocalDateTime.now());
      inbound.setEditorId(UserUtil.getCurrentUserId());
      inbound.setEditorName(UserUtil.getCurrentName());
      inbound.setShipmentNumber(dtoParam.getShipmentNumber());
      inbound.setRejectStatus(RejectEnum.NO_REJECT.getType());
      inbound.setInboundWay(InboundWayEnum.BEGIN_PERIOD.getType());
      if ((dtoParam.getReviewStatus() == null || !ReviewStatusEnum.RETURNED.getType().equals(dtoParam.getReviewStatus()))
         && !ReviewStatusEnum.CANCEL.getType().equals(dtoParam.getReviewStatus())) {
         while (true) {
            Integer maxDayNumber = this.queryUtil.createInboundSerialNumber("inbound");
            String serialNumber = this.numberConfigService.getNumber(NumberTypeEnum.INBOUND, maxDayNumber);
            List<Inbound> wmsApproveRecords = this.baseMapper.selectList((Wrapper<Inbound>)new LambdaQueryWrapper<Inbound>().eq(Inbound::getSerialNumber, serialNumber));
            if (CollectionUtils.isEmpty(wmsApproveRecords)) {
               inbound.setEditable(true);
               inbound.setEstablishQuantity(maxDayNumber);
               inbound.setSerialNumber(serialNumber);
               break;
            }
         }
      } else {
         Inbound sourceInbound = this.baseMapper.selectById(dtoParam.getId());
         if (sourceInbound.getOriginalId() != null) {
            sourceInbound = this.baseMapper.selectById(sourceInbound.getOriginalId());
         }

         this.baseMapper.updateEditable(sourceInbound.getId(), 0);
         Integer number = sourceInbound.getOriginalNumber();
         number = number + 1;
         sourceInbound.setOriginalNumber(number);
         sourceInbound.setEditable(false);
         this.baseMapper.updateById(sourceInbound);
         inbound.setSerialNumber(sourceInbound.getSerialNumber() + "-" + number);
         inbound.setOriginalId(sourceInbound.getId());
         inbound.setEditable(true);
      }

      this.baseMapper.insert(inbound);
      this.saveInboundDetailAndFillInboundInfo(inbound, dtoParam);
      this.classificationService.updateClassifyUsed(IdsStatusDTO.builder().idsStr(inbound.getClassifyIds()).build());
      boolean boolQualityTesting = inbound.getQualityTestingEnum().equals(QualityTestingEnum.UN_REVIEWED.getType());
      WmsApproveRecordDetail wmsApproveRecordDetail = null;
      if (boolQualityTesting) {
         wmsApproveRecordDetail = new WmsApproveRecordDetail();
         wmsApproveRecordDetail.setCreateTime(LocalDateTime.now());
         wmsApproveRecordDetail.setArrivalTime(LocalDateTime.now());
         wmsApproveRecordDetail.setDataId(inbound.getId());
         wmsApproveRecordDetail.setModuleType(ModuleTypeEnum.WMS.getType());
         wmsApproveRecordDetail.setFunctionType(FunctionTypeEnum.WMS_SELF_BUYING_IN.getType());
         wmsApproveRecordDetail.setApproveProcessType(approveProcessType);
         wmsApproveRecordDetail.setFlowType(ApproveTemplateVersionsFlowEnum.QUALITY_TESTING.getType());
         wmsApproveRecordDetail.setStatus(ApproveRecordStatusEnum.UNDERWAY.getType());
      }

      this.baseMapper.updateById(inbound);
      InboundDTO inboundDTO = this.getInboundDTOById(inbound.getId(), false);
      String jsonData = JSON.toJSONString(inboundDTO, SerializerFeature.DisableCircularReferenceDetect);
      StringBuilder subjoinMsgBuilder = new StringBuilder();
      String subjoinMsg = null;
      if (subjoinMsgBuilder.length() > 0) {
         subjoinMsg = subjoinMsgBuilder.toString();
      }

      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService
         .createRecord(
            inbound.getId(),
            inbound.getSerialNumber(),
            approveProcessType,
            dtoParam.getCause(),
            wmsApproveRecordDetail,
            jsonData,
            false,
            mountMessageDTO,
            subjoinMsg,
            null
         );
      inbound.setApproveRecordId(wmsApproveRecord.getId());
      this.baseMapper.updateById(inbound);
      if (wmsApproveRecord.getStatus().equals(ApproveRecordStatusEnum.END.getType())) {
         dtoParam.setInbound(inbound);
         this.passedBeginSelfBuyingV2(dtoParam);
      }

      this.pushMessage(
         inbound, wmsApproveRecord, NotificationModuleTypeEnum.WMS_MATERIAL_SELF_PURCHASE_INBOUND.getNotificationType(), SupplyTypeEnum.SELF.getType()
      );
      return true;
   }

   private void pushMessage(Inbound inbound, WmsApproveRecord wmsApproveRecord, Integer notificationModuleTypeEnum, Integer supplyTypeEnum) {
      List<String> userPhoneList = new ArrayList<>();
      WmsApproveRecordFlowDTO approveRecordDTO = this.wmsApproveRecordService.getApproveRecordDTO(wmsApproveRecord.getId());
      if (approveRecordDTO != null) {
         List<WmsApproveFlowDTO> wmsApproveFlowDTOS = approveRecordDTO.getWmsApproveFlowDTOS();
         if (CollectionUtils.isNotEmpty(wmsApproveFlowDTOS)) {
            wmsApproveFlowDTOS.forEach(
               wmsApproveFlowDTO -> {
                  List<WmsApproveRecordDetailDTO> wmsApproveRecordDetailDTOS = wmsApproveFlowDTO.getWmsApproveRecordDetailDTOS();
                  if (CollectionUtils.isNotEmpty(wmsApproveRecordDetailDTOS)) {
                     wmsApproveRecordDetailDTOS.forEach(
                        wmsApproveRecordDetailDTO -> {
                           if (wmsApproveRecordDetailDTO.getUserSimpleResponseVOS() != null
                              && !wmsApproveRecordDetailDTO.getFlowType().equals(ApproveTemplateVersionsFlowEnum.LAUNCH_APPLICATION.getType())) {
                              userPhoneList.add(wmsApproveRecordDetailDTO.getUserSimpleResponseVOS().getPhone());
                           }
                        }
                     );
                  }
               }
            );
         }
      }

      if (CollectionUtils.isNotEmpty(userPhoneList)) {
         this.sysPushFlowConfigBiz
            .triggerFlow(
               NotificationServiceTriggerDTO.builder()
                  .projectId(null)
                  .dataId(inbound.getId())
                  .userPhoneList(userPhoneList)
                  .contentDetails(
                     supplyTypeEnum.equals(SupplyTypeEnum.SELF.getType())
                        ? this.detailsUtils.getMaterialInboundDetails2(UserUtil.getCurrentUser().getName(), inbound.getSerialNumber())
                        : this.detailsUtils.getMaterialInboundDetails(UserUtil.getCurrentUser().getName(), inbound.getSerialNumber())
                  )
                  .notificationTypeEnum(notificationModuleTypeEnum)
                  .userList(new ArrayList<>())
                  .build()
            );
      }
   }

   private Boolean passedBeginSelfBuyingV2(InboundDTOParam request) {
      Inbound inbound = request.getInbound();
      List<InboundDetail> inboundDetails = request.getInboundDetails();
      inboundDetails = inboundDetails.stream()
         .filter(
            i -> QualityTestingEnum.ALL_PASS.getType().equals(i.getQualityTestingEnum()) || QualityTestingEnum.NO.getType().equals(i.getQualityTestingEnum())
         )
         .collect(Collectors.toList());
      inbound.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
      inbound.setReviewTime(LocalDateTime.now());
      inbound.setReviewerId(UserUtil.getCurrentUserId());
      inbound.setReviewerName(UserUtil.getCurrentName());
      inbound.setEditable(false);
      inbound.setApprovalComments(request.getApprovalComments());
      BigDecimal amount = BigDecimal.ZERO;
      BigDecimal amountNoFreight = BigDecimal.ZERO;
      BigDecimal amountExcludingVAT = BigDecimal.ZERO;
      BigDecimal amountExcludingVATNoFreight = BigDecimal.ZERO;
      WasteConfig scrapDefinitionConf = this.basicConfigService.getSteelScrapDefinitionConf();
      List<Scrap> saveScrapList = new ArrayList<>();
      List<InboundDetail> updateInboundDetailList = new ArrayList<>();

      for (InboundDetail inboundDetail : inboundDetails) {
         inboundDetail.setRejectStatus(RejectEnum.NO_REJECT.getType());
         inboundDetail.setRejectMete(BigDecimal.ZERO);
         inboundDetail.setRejectQuantity(BigDecimal.ZERO);
         boolean isScrap = false;
         if (BasicClassEnum.STEEL_PLATE.getType().equals(inboundDetail.getBasicClass())) {
            isScrap = inboundDetail.getLength().compareTo(scrapDefinitionConf.getSteelPlateShortestSideMinLength()) <= 0
               || inboundDetail.getWidth().compareTo(scrapDefinitionConf.getSteelPlateShortestSideMinLength()) <= 0;
         }

         if (BasicClassEnum.SECTION_STEEL.getType().equals(inboundDetail.getBasicClass())) {
            isScrap = inboundDetail.getLength().compareTo(scrapDefinitionConf.getSectionSteelMinLength()) <= 0;
         }

         if (BasicClassEnum.COLOR_ROLL.getType().equals(inboundDetail.getBasicClass())) {
            isScrap = inboundDetail.getQuantity().compareTo(scrapDefinitionConf.getSteelCoilMinLength()) <= 0;
         }

         if (isScrap) {
            Scrap scrap = BeanUtil.copy(inboundDetail, Scrap.class, "createTime");
            scrap.setWarehouseType(inboundDetail.getProjectId() != null ? 2 : 1);
            scrap.setAmount(inboundDetail.getAmount());
            scrap.setAmountExcludingVat(inboundDetail.getAmountExcludingVat());
            scrap.setAmountNoFreight(inboundDetail.getAmountNoFreight());
            scrap.setAmountExcludingVatNoFreight(inboundDetail.getAmountExcludingVatNoFreight());
            scrap.setCreateTime(LocalDateTime.now());
            saveScrapList.add(scrap);
         } else {
            MaterialInventory materialInventory = null;
            if (!BasicClassEnum.COLOR_ROLL.getType().equals(inboundDetail.getBasicClass())) {
               materialInventory = this.materialInventoryService.getByBeginInboundDetail(inboundDetail);
            }

            MaterialInventory newMaterialInventory = this.setMaterialInventoryV2(inboundDetail, materialInventory);
            newMaterialInventory.setUseStatus(false);
            if (materialInventory != null) {
               newMaterialInventory.setUpdateTime(LocalDateTime.now());
               this.materialInventoryService.updateById(newMaterialInventory);
            } else {
               this.materialInventoryService.save(newMaterialInventory);
            }

            this.wmsUtil
               .setInventoryUse(
                  newMaterialInventory,
                  inboundDetail.getQuantity(),
                  inboundDetail.getMete(),
                  ReceiptTypeEnum.INBOUND,
                  inbound.getId(),
                  inbound.getSerialNumber(),
                  1,
                  true
               );
            this.weightedAveragePriceService
               .createMonthWAP(inboundDetail, newMaterialInventory, inbound.getId(), inbound.getSerialNumber(), ReceiptTypeEnum.INBOUND.getType());
            this.warningService.updateStatus(newMaterialInventory, 1);
         }

         amount = amount.add(inboundDetail.getAmount());
         amountNoFreight = amountNoFreight.add(inboundDetail.getAmountNoFreight());
         amountExcludingVAT = amountExcludingVAT.add(inboundDetail.getAmountExcludingVat());
         amountExcludingVATNoFreight = amountExcludingVATNoFreight.add(inboundDetail.getAmountExcludingVatNoFreight());
         inboundDetail.setInboundTime(LocalDateTime.now());
         updateInboundDetailList.add(inboundDetail);
      }

      inbound.setAmount(amount);
      inbound.setAmountNoFreight(amountNoFreight);
      inbound.setAmountExcludingVat(amountExcludingVAT);
      inbound.setAmountExcludingVatNoFreight(amountExcludingVATNoFreight);
      Print print = this.printService
         .getOne(
            (Wrapper<Print>)((Wrappers.<Print>lambdaQuery().eq(Print::getReceiptId, inbound.getId()))
                  .eq(Print::getReceiptType, ReceiptTypeEnum.INBOUND.getType()))
               .eq(Print::getBoolPrinted, false)
         );
      if (print != null) {
         print.setReceiptReviewer(inbound.getReviewerName());
         print.setReceiptReviewTime(inbound.getReviewTime());
         this.printService.updateById(print);
      }

      this.scrapService.saveBatch(saveScrapList);
      this.inboundDetailService.updateBatchById(updateInboundDetailList);
      return this.baseMapper.updateById(inbound) == 1;
   }

   private void saveInboundDetailAndFillInboundInfo(Inbound inbound, InboundDTOParam dtoParam) {
      List<Long> projectIds = new ArrayList<>();
      int basicClass = 0;
      BigDecimal inboundTotalWeight = new BigDecimal(BigInteger.ZERO);
      BigDecimal loadingWeight = dtoParam.getLoadingWeight();
      boolean boolQualityTesting = false;
      TreeSet<String> classifyIds = new TreeSet<>();
      List<InboundDetail> saveList = new ArrayList<>();
      Map<Long, Classification> classificationMap = new HashMap<>();
      Map<Long, Measure> measureMap = new HashMap<>();
      Map<String, SectionSteelSpec> sectionSteelSpecMap = new HashMap<>();
      Map<String, SectionSteelSpecStandardDetail> specStandardDetailMap = new HashMap<>();
      Map<Long, Standard> standardMap = new HashMap<>();
      Map<Long, Warehouse> warehouseMap = new HashMap<>();
      if (CollectionUtil.isNotEmpty(dtoParam.getList())) {
         HashSet<ClassificationCheckDTO> checkDTOSet = new HashSet<>();
         HashSet<Long> classifyIdSet = new HashSet<>();
         HashSet<String> sectionSteelSpecSet = new HashSet<>();
         HashSet<Long> standardIdSet = new HashSet<>();
         int paramBasicClass = 0;

         for (InboundDetailDTOParam detailDTOParam : dtoParam.getList()) {
            ClassificationCheckDTO checkDTO = cn.hutool.core.bean.BeanUtil.toBean(detailDTOParam, ClassificationCheckDTO.class);
            checkDTOSet.add(checkDTO);
            classifyIdSet.add(detailDTOParam.getClassifyId());
            if (StrUtil.isNotBlank(detailDTOParam.getSectionSteelSpec())) {
               sectionSteelSpecSet.add(detailDTOParam.getSectionSteelSpec());
            }

            if (detailDTOParam.getStandardId() != null) {
               standardIdSet.add(detailDTOParam.getStandardId());
            }

            paramBasicClass |= detailDTOParam.getBasicClass();
         }

         warehouseMap = this.warehouseService
            .list(
               (Wrapper<Warehouse>)(Wrappers.<Warehouse>lambdaQuery().eq(Warehouse::getEnabled, Boolean.TRUE))
                  .last("and " + paramBasicClass + " & material_type")
            )
            .stream()
            .collect(Collectors.toMap(Warehouse::getId, Function.identity()));
         classificationMap = this.classificationService.checkClassification(new ArrayList<>(checkDTOSet), dtoParam.getClickTime());
         measureMap = this.measureMapper
            .selectList(Wrappers.lambdaQuery(Measure.class).in(Measure::getClassificationId, classificationMap.keySet()))
            .stream()
            .collect(Collectors.toMap(Measure::getClassificationId, Function.identity()));
         if (CollectionUtil.isNotEmpty(sectionSteelSpecSet)) {
            Preconditions.checkArgument(CollectionUtil.isNotEmpty(standardIdSet), "国标信息不能为空！");
            List<SectionSteelSpec> specList = this.sectionSteelSpecService
               .list(
                  Wrappers.lambdaQuery(SectionSteelSpec.class)
                     .in(SectionSteelSpec::getClassificationId, classifyIdSet)
                     .in(SectionSteelSpec::getSpecification, sectionSteelSpecSet)
               );
            if (CollectionUtil.isNotEmpty(specList)) {
               sectionSteelSpecMap = specList.stream()
                  .collect(Collectors.toMap(spec -> spec.getClassificationId() + "-" + spec.getSpecification(), Function.identity()));
               List<Long> specIds = specList.stream().map(SectionSteelSpec::getId).collect(Collectors.toList());
               List<Long> sectionSteelIds = specList.stream().map(SectionSteelSpec::getSectionSteelId).collect(Collectors.toList());
               specStandardDetailMap = this.sectionSteelSpecStandardDetailMapper
                  .selectList(
                     Wrappers.lambdaQuery(SectionSteelSpecStandardDetail.class)
                        .in(SectionSteelSpecStandardDetail::getSpecId, specIds)
                        .in(SectionSteelSpecStandardDetail::getSectionSteelId, sectionSteelIds)
                        .in(SectionSteelSpecStandardDetail::getStandardId, standardIdSet)
                  )
                  .stream()
                  .collect(
                     Collectors.toMap(
                        specStandardDetail -> specStandardDetail.getSpecId()
                           + "-"
                           + specStandardDetail.getSectionSteelId()
                           + "-"
                           + specStandardDetail.getStandardId(),
                        Function.identity()
                     )
                  );
            }

            standardMap = this.standardMapper.selectBatchIds(standardIdSet).stream().collect(Collectors.toMap(Standard::getId, Function.identity()));
         }
      }

      WmsClosingTime oneTime = this.wmsClosingTimeService
         .getOne((Wrapper<WmsClosingTime>)(new LambdaQueryWrapper<WmsClosingTime>().orderBy(true, false, WmsClosingTime::getId)).last("limit 1"));

      for (InboundDetailDTOParam detailParam : dtoParam.getList()) {
         if (detailParam.getRealTime() == null) {
            detailParam.setRealTime(LocalDateTime.now().minusMinutes(1L));
         }

         if (oneTime != null) {
            Preconditions.checkArgument(
               detailParam.getRealTime().isAfter(oneTime.getEndTime()) && detailParam.getRealTime().isBefore(LocalDateTime.now()), "实际时间不能在实际关账时间之前,请刷新页面重新办理"
            );
         }

         Measure measure = measureMap.get(detailParam.getClassifyId());
         Preconditions.checkArgument(measure != null, "操作失败，未获取到科目对应的单位配置信息！");
         Preconditions.checkArgument(detailParam.getWorkshopId() != null, "请选择车间");
         Preconditions.checkArgument(detailParam.getWarehouseId() != null, "请选择仓库");
         Warehouse warehouse = warehouseMap.get(detailParam.getWarehouseId());
         Preconditions.checkArgument(warehouse != null, "操作失败，填写的仓库不存在，或类型不匹配！");
         Preconditions.checkArgument(detailParam.getWorkshopId().equals(warehouse.getWorkshopId()), "操作失败，" + warehouse.getName() + "父级车间不匹配！");
         this.checkInfo(detailParam);
         Classification classification = classificationMap.get(detailParam.getClassifyId());
         if (measure.getMeasureUnit() != null) {
            Preconditions.checkArgument(measure.getMeasureUnit().equals(detailParam.getMeasureUnit()), classification.getName() + "配置的计量单位和填写计量单位不匹配！");
         }

         if (measure.getAccountingUnit() != null) {
            Preconditions.checkArgument(measure.getAccountingUnit().equals(detailParam.getAccountingUnit()), classification.getName() + "配置的核算单位和填写核算单位不匹配！");
         }

         classifyIds.add(classification.getId().toString());
         InboundDetail inboundDetail = BeanUtil.copy(detailParam, InboundDetail.class);
         inboundDetail.setDoNotSectionSteelSpec(
            ObjectUtil.isNotEmpty(detailParam.getDoNotSectionSteelSpec()) ? detailParam.getDoNotSectionSteelSpec() : detailParam.getSpecification()
         );
         if (measure.getBoolQualityTesting()) {
            inboundDetail.setQualityTestingEnum(QualityTestingEnum.UN_REVIEWED.getType());
            if (!boolQualityTesting) {
               boolQualityTesting = true;
            }
         } else {
            inboundDetail.setQualityTestingEnum(QualityTestingEnum.NO.getType());
         }

         inboundDetail.setMeasureUnit(measure.getMeasureUnit());
         inboundDetail.setMeasurePrecision(measure.getMeasurePrecision());
         inboundDetail.setAccountingUnit(measure.getAccountingUnit());
         inboundDetail.setAccountingPrecision(measure.getAccountingPrecision());
         inboundDetail.setBrand(StrUtil.trimToNull(detailParam.getBrand()));
         inboundDetail.setColor(StrUtil.trimToNull(detailParam.getColor()));
         inboundDetail.setHeatNoAndBatchNo(StrUtil.trimToNull(detailParam.getHeatNoAndBatchNo()));
         inboundDetail.setClassifyName(classification.getName());
         inboundDetail.setLength(BasicClassEnum.COLOR_ROLL.getType().equals(inboundDetail.getBasicClass()) ? null : detailParam.getLength());
         inboundDetail.setInboundId(inbound.getId());
         if (!inbound.getBoolPartyA()) {
            Preconditions.checkArgument(detailParam.getUnitPrice() != null, "含税单价不能为空！");
            Preconditions.checkArgument(detailParam.getAmount() != null, "含税金额不能为空！");
            Preconditions.checkArgument(detailParam.getUnitPriceExcludingVatFreight() != null, "不含税单价不能为空！");
            Preconditions.checkArgument(detailParam.getAmountExcludingVatFreight() != null, "不含税金额不能为空！");
            detailParam.setAmount(detailParam.getAmount().setScale(2, RoundingMode.HALF_UP));
            detailParam.setAmountExcludingVatFreight(detailParam.getAmountExcludingVatFreight().setScale(2, RoundingMode.HALF_UP));
            detailParam.setUnitPrice(detailParam.getUnitPrice().setScale(12, RoundingMode.HALF_UP));
            detailParam.setUnitPriceExcludingVatFreight(detailParam.getUnitPriceExcludingVatFreight().setScale(12, RoundingMode.HALF_UP));
            inboundDetail.setUnitPriceNoFreight(detailParam.getUnitPrice());
            inboundDetail.setAmount(detailParam.getAmount());
            inboundDetail.setAmountNoFreight(detailParam.getAmount());
            inboundDetail.setAmountExcludingVatNoFreight(detailParam.getAmountExcludingVatFreight());
            inboundDetail.setUnitPriceExcludingVatNoFreight(detailParam.getUnitPriceExcludingVatFreight());
            inboundDetail.setAmountExcludingVat(detailParam.getAmountExcludingVatFreight());
            inboundDetail.setUnitPriceExcludingVat(detailParam.getUnitPriceExcludingVatFreight());
            if (detailParam.getAmount().compareTo(detailParam.getAmountExcludingVatFreight()) > 0) {
               inboundDetail.setInputVat(inboundDetail.getAmount().subtract(inboundDetail.getAmountExcludingVat()));
               inboundDetail.setInputVatNoFreight(inboundDetail.getAmount().subtract(inboundDetail.getAmountExcludingVat()));
               inboundDetail.setInvoiceType(InvoiceTypeEnum.SPECIAL.getType());
            }
         } else {
            Preconditions.checkArgument(detailParam.getProjectId() != null, "入库失败,甲供入库请选择项目");
            inboundDetail.setAmount(BigDecimal.ZERO);
            inboundDetail.setAmountNoFreight(BigDecimal.ZERO);
            inboundDetail.setAmountExcludingVat(BigDecimal.ZERO);
            inboundDetail.setAmountExcludingVatNoFreight(BigDecimal.ZERO);
            inboundDetail.setUnitPriceExcludingVat(BigDecimal.ZERO);
            inboundDetail.setUnitPriceExcludingVatNoFreight(BigDecimal.ZERO);
            inboundDetail.setUnitPrice(BigDecimal.ZERO);
            inboundDetail.setUnitPriceNoFreight(BigDecimal.ZERO);
         }

         basicClass |= detailParam.getBasicClass();
         StringBuilder specification = new StringBuilder();
         if (BasicClassEnum.SECTION_STEEL.getType().equals(detailParam.getBasicClass())) {
            String sn = "";
            String specCode = "";
            Preconditions.checkArgument(ObjectUtil.isNotEmpty(detailParam.getSectionSteelSpec()), "该型材未配置国标规格");
            Preconditions.checkArgument(ObjectUtil.isNotEmpty(detailParam.getStandardId()), "国标标准不能为空");
            SectionSteelSpec sectionSteelSpec = sectionSteelSpecMap.get(classification.getId() + "-" + detailParam.getSectionSteelSpec());
            Preconditions.checkArgument(sectionSteelSpec != null, "操作失败,未获取到相应的国标规格");
            SectionSteelSpecStandardDetail standardDetail = specStandardDetailMap.get(
               sectionSteelSpec.getId() + "-" + sectionSteelSpec.getSectionSteelId() + "-" + detailParam.getStandardId()
            );
            Preconditions.checkArgument(ObjectUtil.isNotEmpty(standardDetail), "入库失败," + classification.getName() + "未查询到型材规格国标重量");
            Preconditions.checkArgument(standardDetail.getUnitNet() != null && standardDetail.getUnitNet().compareTo(BigDecimal.ZERO) > 0, "入库失败,当前型材规格未配置国标重量");
            Standard standard = standardMap.get(detailParam.getStandardId());
            sn = standard.getCode() + "-" + standardDetail.getCode();
            SectionSteelSpecDTO weightByClassifyId = this.sectionSteelSpecService
               .getWeightByClassifyId(detailParam.getClassifyId(), detailParam.getSectionSteelSpec());
            BigDecimal oneMete = CommonUtil.getTheoryMete(
               null, inboundDetail.getLength(), null, null, weightByClassifyId.getDetail().getUnitNet(), classification.getId()
            );
            BigDecimal theoryWeight = oneMete.multiply(detailParam.getQuantity()).setScale(0, RoundingMode.HALF_UP);
            inboundDetail.setSectionSteelWeight(weightByClassifyId.getDetail().getUnitNet());
            inboundDetail.setOneTheoryWeight(oneMete);
            inboundDetail.setTheoryWeight(theoryWeight);
            inboundDetail.setStandardId(standard.getId());
            inboundDetail.setStandardName(standard.getName());
            inboundDetail.setSectionSteelSpecId(sectionSteelSpec.getId());
            inboundDetail.setSectionSteelSpec(sectionSteelSpec.getSpecification());
            inboundDetail.setDoNotSectionSteelSpec(detailParam.getDoNotSectionSteelSpec());
            if (ObjectUtil.isNotEmpty(detailParam.getDoNotSectionSteelSpec())) {
               Map<String, String> map = this.specificationService.checkClassifySpec(detailParam.getClassifyId(), detailParam.getDoNotSectionSteelSpec());
               specCode = map.get("code");
               specification.append(map.get("ids"));
            }

            inboundDetail.setMaterialSn(classification.getSerialNumber() + "-" + sn + specCode);
            inboundTotalWeight = inboundTotalWeight.add(detailParam.getMete());
         } else if (BasicClassEnum.STEEL_PLATE.getType().equals(detailParam.getBasicClass())) {
            Map<String, String> map = this.specificationService.checkClassifySpec(detailParam.getClassifyId(), detailParam.getSpecification());
            String specCode = map.get("code");
            specification.append(map.get("ids"));
            inboundDetail.setMaterialSn(classification.getSerialNumber() + (StrUtil.isNotBlank(specCode) ? "-" + specCode : ""));
            inboundDetail.setTheoryThickness(detailParam.getThickness().setScale(0, RoundingMode.HALF_UP));
            BigDecimal oneTheoryMete = CommonUtil.getTheoryMete(
               classification.getName(), inboundDetail.getLength(), inboundDetail.getWidth(), inboundDetail.getThickness(), null, classification.getId()
            );
            BigDecimal theoryWeight = oneTheoryMete.multiply(
                  BasicClassEnum.COLOR_ROLL.getType().equals(detailParam.getBasicClass()) ? BigDecimal.ONE : detailParam.getQuantity()
               )
               .setScale(0, RoundingMode.HALF_UP);
            inboundDetail.setOneTheoryWeight(oneTheoryMete);
            inboundDetail.setTheoryWeight(theoryWeight);
            inboundTotalWeight = inboundTotalWeight.add(detailParam.getMete());
         } else if (BasicClassEnum.COLOR_ROLL.getType().equals(detailParam.getBasicClass())) {
            Map<String, String> map = this.specificationService.checkClassifySpec(detailParam.getClassifyId(), detailParam.getSpecification());
            String specCode = map.get("code");
            specification.append(map.get("ids"));
            inboundDetail.setMaterialSn(classification.getSerialNumber() + (StrUtil.isNotBlank(specCode) ? "-" + specCode : ""));
            BigDecimal inboundMete = detailParam.getMete().divide(THOUSAND, 0, RoundingMode.HALF_UP);
            if (loadingWeight != null) {
               loadingWeight = loadingWeight.subtract(inboundMete);
            }

            inboundDetail.setOneTheoryWeight(inboundMete);
         } else if (BasicClassEnum.checkNotSteel(detailParam.getBasicClass())) {
            Map<String, String> map = this.specificationService.checkClassifySpec(detailParam.getClassifyId(), detailParam.getSpecification());
            String specCode = map.get("code");
            specification.append(map.get("ids"));
            inboundDetail.setMaterialSn(classification.getSerialNumber() + (StrUtil.isNotBlank(specCode) ? "-" + specCode : ""));
            inboundDetail.setUnitNet(
               detailParam.getQuantity() != null ? detailParam.getMete().divide(detailParam.getQuantity(), 8, RoundingMode.HALF_UP) : BigDecimal.ONE
            );
         }

         Measure measure1 = this.getMeasure(classification.getId());
         if (measure1.getOutboundUnitType().equals(MeasureTypeEnum.MEASURE.getType())) {
            Preconditions.checkArgument(ObjectUtil.isNotEmpty(inboundDetail.getQuantity()), classification.getName() + "为计量方式，但未提交数量，请检查该科目计量配置！！！");
         }

         if (measure1.getOutboundUnitType().equals(MeasureTypeEnum.ACCOUNTING.getType())) {
            Preconditions.checkArgument(ObjectUtil.isEmpty(inboundDetail.getQuantity()), classification.getName() + "为核算方式，但提交了数量，请检查该科目计量配置！！！");
         }

         inboundDetail.setBoolPartyA(inbound.getBoolPartyA());
         inboundDetail.setSpecificationIds(specification.toString());
         if (StrUtil.isEmpty(inboundDetail.getSpecification())) {
            inboundDetail.setSpecification(null);
         }

         if (inboundDetail.getProjectId() != null && !projectIds.contains(inboundDetail.getProjectId())) {
            projectIds.add(inboundDetail.getProjectId());
         }

         saveList.add(inboundDetail);
      }

      if (CollectionUtils.isNotEmpty(classifyIds)) {
         inbound.setClassifyIds(String.join(",", classifyIds));
      }

      dtoParam.setInboundDetails(saveList);
      Map<String, Unit> unitMap = this.queryUtil.getUnitMap(null);
      if (dtoParam.getLoadingWeight() == null && BasicClassEnum.checkIsSteel(basicClass)) {
         List<Integer> nameStr2 = BasicClassEnum.getNameStr2(basicClass);
         List<Measure> measures = this.measureMapper.selectList((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().in(Measure::getBasicClass, nameStr2));
         Map<Integer, BigDecimal> mete = this.queryUtil
            .unitConversionV2(inboundTotalWeight, measures.get(0).getAccountingUnit(), measures.get(0).getAccountingPrecision(), unitMap);
         inbound.setLoadingWeight(dtoParam.getLoadingWeight() != null ? dtoParam.getLoadingWeight() : mete.get(1));
      } else {
         inbound.setLoadingWeight(dtoParam.getLoadingWeight());
      }

      if (boolQualityTesting) {
         inbound.setQualityTestingEnum(QualityTestingEnum.UN_REVIEWED.getType());
      } else {
         inbound.setQualityTestingEnum(QualityTestingEnum.NO.getType());
      }

      if (CollectionUtil.isNotEmpty(projectIds)) {
         String idStr = StrUtil.join(",", projectIds);
         inbound.setProjectIds(idStr);
      }

      inbound.setPurchaseId(dtoParam.getPurchaseId());
      inbound.setBasicClass(basicClass);
      this.inboundDetailService.saveBatch(saveList);
      this.saveBatchPrintInfo(inbound, saveList);
   }

   private Boolean passedSelfBuyingV2(InboundDTOParam request) {
      Inbound inbound = request.getInbound();
      List<InboundDetail> inboundDetails = request.getInboundDetails();
      inboundDetails = inboundDetails.stream()
         .filter(
            i -> QualityTestingEnum.ALL_PASS.getType().equals(i.getQualityTestingEnum()) || QualityTestingEnum.NO.getType().equals(i.getQualityTestingEnum())
         )
         .collect(Collectors.toList());
      PurchaseOrder order = this.purchaseOrderService.getById(inbound.getPurchaseId());
      Preconditions.checkArgument(order.getPurchaseStatus() != 2, "订单[" + order.getSerialNumber() + "]已完成采购.");
      inbound.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
      inbound.setReviewTime(LocalDateTime.now());
      inbound.setReviewerId(UserUtil.getCurrentUserId());
      inbound.setReviewerName(UserUtil.getCurrentName());
      inbound.setEditable(false);
      inbound.setApprovalComments(request.getApprovalComments());
      if (ObjectUtil.isNotEmpty(inbound.getFreightJson()) && LogisticsPayerEnum.DEMAND.getType().equals(order.getLogisticsPayerType())) {
         LogisticsOrder logistics = JSONObject.parseObject(inbound.getFreightJson(), LogisticsOrder.class);
         Preconditions.checkArgument(logistics.getFreight() != null, "请设置运费");
         Preconditions.checkArgument(logistics.getSupplierId() != null, "请设置物流公司");
         inbound.setLogisticsSupplierId(logistics.getSupplierId());
         inbound.setFreight(logistics.getFreight());
         inbound.setFreightWeight(logistics.getFreightWeight());
         this.generateLogisticsOrderV2(logistics, inbound, order, ReviewStatusEnum.UN_REVIEWED.getType());
      }

      BigDecimal amount = BigDecimal.ZERO;
      BigDecimal amountNoFreight = BigDecimal.ZERO;
      BigDecimal amountExcludingVAT = BigDecimal.ZERO;
      BigDecimal amountExcludingVATNoFreight = BigDecimal.ZERO;
      BigDecimal loadingWeight = BigDecimal.ZERO;
      if (order.getLogisticsPayerType().equals(LogisticsPayerEnum.DEMAND.getType())) {
         LogisticsOrder one = this.logisticsOrderService
            .getOne(
               (Wrapper<LogisticsOrder>)(new LambdaQueryWrapper<LogisticsOrder>().eq(LogisticsOrder::getInboundId, inbound.getId()))
                  .eq(LogisticsOrder::getTableNameType, TableNameTypeEnum.WMS_INBOUND.getType())
            );
         BigDecimal freight = one.getFreight();
         BigDecimal freightAmountExcludingVat = one.getAmountExcludingVat();
         if (ObjectUtil.isNotEmpty(one.getLoadingCharge())) {
            freight = freight.add(one.getLoadingCharge());
            freightAmountExcludingVat = freightAmountExcludingVat.add(one.getLoadingChargeExcludingVat());
         }

         BigDecimal meteSum = inboundDetails.stream().map(InboundDetail::getMete).reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal amountSum = inboundDetails.stream().map(InboundDetail::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
         Integer num = 0;
         List<InboundDetail> ltAndEqAmountZeroDetails = inboundDetails.stream()
            .filter(i -> i.getAmount().compareTo(BigDecimal.ZERO) < 1)
            .collect(Collectors.toList());
         List<InboundDetail> gtAmountZeroDetails = inboundDetails.stream()
            .filter(i -> i.getAmount().compareTo(BigDecimal.ZERO) > 0)
            .collect(Collectors.toList());
         BigDecimal inboundDetailsSize = new BigDecimal(inboundDetails.size());
         Integer gtZeroNum = 0;

         for (InboundDetail inboundDetail : inboundDetails) {
            num = num + 1;
            if (BasicClassEnum.checkIsSteelAddOtherSteelMaterials(inboundDetail.getBasicClass())) {
               BigDecimal meteNow = inboundDetail.getMete();
               if (num == inboundDetails.size()) {
                  inboundDetail.setAmount(inboundDetail.getAmount().add(freight));
                  inboundDetail.setUnitPrice(inboundDetail.getAmount().divide(meteNow, 12, RoundingMode.HALF_UP));
                  inboundDetail.setAmountExcludingVat(inboundDetail.getAmountExcludingVat().add(freightAmountExcludingVat));
                  inboundDetail.setUnitPriceExcludingVat(inboundDetail.getAmountExcludingVat().divide(meteNow, 12, RoundingMode.HALF_UP));
               } else {
                  BigDecimal ratio = inboundDetail.getMete().divide(meteSum, 12, RoundingMode.HALF_UP);
                  BigDecimal halveAllFreightTax = freight.multiply(ratio).setScale(2, 4);
                  inboundDetail.setAmount(inboundDetail.getAmount().add(halveAllFreightTax));
                  inboundDetail.setUnitPrice(inboundDetail.getAmount().divide(meteNow, 12, RoundingMode.HALF_UP));
                  freight = freight.subtract(halveAllFreightTax);
                  BigDecimal halveAllFreightNoTax = freightAmountExcludingVat.multiply(ratio);
                  inboundDetail.setAmountExcludingVat(inboundDetail.getAmountExcludingVat().add(halveAllFreightNoTax));
                  inboundDetail.setUnitPriceExcludingVat(inboundDetail.getAmountExcludingVat().divide(meteNow, 12, RoundingMode.HALF_UP));
                  freightAmountExcludingVat = freightAmountExcludingVat.subtract(halveAllFreightNoTax);
                  meteSum = meteSum.subtract(inboundDetail.getMete());
               }
            } else {
               if (inboundDetail.getAmount().compareTo(BigDecimal.ZERO) > 0) {
                  gtZeroNum = gtZeroNum + 1;
               }

               BigDecimal meteNow = inboundDetail.getMete();
               if (inboundDetail.getAmount().compareTo(BigDecimal.ZERO) < 1
                  ? ltAndEqAmountZeroDetails.size() != inboundDetails.size() || num != inboundDetails.size()
                  : gtZeroNum != gtAmountZeroDetails.size()) {
                  BigDecimal ratio = null;
                  if (ltAndEqAmountZeroDetails.size() == inboundDetails.size()) {
                     ratio = BigDecimal.ONE.divide(inboundDetailsSize, 12, RoundingMode.HALF_UP);
                  } else {
                     ratio = inboundDetail.getAmount().compareTo(BigDecimal.ZERO) < 1
                        ? BigDecimal.ZERO
                        : inboundDetail.getAmount().divide(amountSum, 12, RoundingMode.HALF_UP);
                  }

                  amountSum = amountSum.subtract(inboundDetail.getAmount());
                  BigDecimal halveAllFreightTax = freight.multiply(ratio).setScale(2, 4);
                  inboundDetail.setAmount(inboundDetail.getAmount().add(halveAllFreightTax));
                  inboundDetail.setUnitPrice(inboundDetail.getAmount().divide(meteNow, 12, RoundingMode.HALF_UP));
                  freight = freight.subtract(halveAllFreightTax);
                  BigDecimal halveAllFreightNoTax = freightAmountExcludingVat.multiply(ratio);
                  inboundDetail.setAmountExcludingVat(inboundDetail.getAmountExcludingVat().add(halveAllFreightNoTax));
                  inboundDetail.setUnitPriceExcludingVat(inboundDetail.getAmountExcludingVat().divide(meteNow, 12, RoundingMode.HALF_UP));
                  freightAmountExcludingVat = freightAmountExcludingVat.subtract(halveAllFreightNoTax);
               } else {
                  inboundDetail.setAmount(inboundDetail.getAmount().add(freight));
                  inboundDetail.setUnitPrice(inboundDetail.getAmount().divide(meteNow, 12, RoundingMode.HALF_UP));
                  inboundDetail.setAmountExcludingVat(inboundDetail.getAmountExcludingVat().add(freightAmountExcludingVat));
                  inboundDetail.setUnitPriceExcludingVat(inboundDetail.getAmountExcludingVat().divide(meteNow, 12, RoundingMode.HALF_UP));
               }
            }

            inboundDetail.setInputVat(inboundDetail.getAmount().subtract(inboundDetail.getAmountExcludingVat()));
            inboundDetail.setInputVatNoFreight(inboundDetail.getAmountNoFreight().subtract(inboundDetail.getAmountExcludingVatNoFreight()));
            amount = amount.add(inboundDetail.getAmount());
            amountNoFreight = amountNoFreight.add(inboundDetail.getAmountNoFreight());
            amountExcludingVAT = amountExcludingVAT.add(inboundDetail.getAmountExcludingVat());
            amountExcludingVATNoFreight = amountExcludingVATNoFreight.add(inboundDetail.getAmountExcludingVatNoFreight());
            loadingWeight = loadingWeight.add(inboundDetail.getMete());
            inboundDetail.setRejectStatus(RejectEnum.NO_REJECT.getType());
            inboundDetail.setRejectMete(BigDecimal.ZERO);
            inboundDetail.setRejectQuantity(BigDecimal.ZERO);
            WasteConfig scrapDefinitionConf = this.basicConfigService.getSteelScrapDefinitionConf();
            boolean isScrap = false;
            if (BasicClassEnum.STEEL_PLATE.getType().equals(inboundDetail.getBasicClass())) {
               isScrap = inboundDetail.getLength().compareTo(scrapDefinitionConf.getSteelPlateShortestSideMinLength()) <= 0
                  || inboundDetail.getWidth().compareTo(scrapDefinitionConf.getSteelPlateShortestSideMinLength()) <= 0;
            }

            if (BasicClassEnum.SECTION_STEEL.getType().equals(inboundDetail.getBasicClass())) {
               isScrap = inboundDetail.getLength().compareTo(scrapDefinitionConf.getSectionSteelMinLength()) <= 0;
            }

            if (BasicClassEnum.COLOR_ROLL.getType().equals(inboundDetail.getBasicClass())) {
               isScrap = inboundDetail.getQuantity().compareTo(scrapDefinitionConf.getSteelCoilMinLength()) <= 0;
            }

            if (isScrap) {
               Scrap scrap = BeanUtil.copy(inboundDetail, Scrap.class, "createTime");
               scrap.setWarehouseType(inboundDetail.getProjectId() != null ? 2 : 1);
               scrap.setAmount(inboundDetail.getAmount());
               scrap.setAmountExcludingVat(inboundDetail.getAmountExcludingVat());
               scrap.setAmountNoFreight(inboundDetail.getAmountNoFreight());
               scrap.setAmountExcludingVatNoFreight(inboundDetail.getAmountExcludingVatNoFreight());
               scrap.setCreateTime(LocalDateTime.now());
               this.scrapMapper.insert(scrap);
            } else {
               MaterialInventory materialInventory = null;
               if (!BasicClassEnum.COLOR_ROLL.getType().equals(inboundDetail.getBasicClass()) || inboundDetail.getBoolNestSurplus()) {
                  materialInventory = this.materialInventoryService.getByInboundDetail(inboundDetail);
               }

               MaterialInventory newMaterialInventory = this.setMaterialInventoryV2(inboundDetail, materialInventory);
               newMaterialInventory.setUseStatus(false);
               if (materialInventory != null) {
                  this.materialInventoryService.updateById(newMaterialInventory);
               } else {
                  this.materialInventoryService.save(newMaterialInventory);
               }

               this.wmsUtil
                  .setInventoryUse(
                     newMaterialInventory,
                     inboundDetail.getQuantity(),
                     inboundDetail.getMete(),
                     ReceiptTypeEnum.INBOUND,
                     inbound.getId(),
                     inbound.getSerialNumber(),
                     1,
                     true
                  );
               Statistics monthWAP = this.weightedAveragePriceService
                  .createMonthWAP(inboundDetail, newMaterialInventory, inbound.getId(), inbound.getSerialNumber(), ReceiptTypeEnum.INBOUND.getType());
               inboundDetail.setWapId(monthWAP.getWapId());
               this.warningService.updateStatus(newMaterialInventory, 1);
            }

            inboundDetail.setInboundTime(LocalDateTime.now());
            this.inboundDetailMapper.updateById(inboundDetail);
         }
      } else {
         for (InboundDetail inboundDetail : inboundDetails) {
            inboundDetail.setRejectStatus(RejectEnum.NO_REJECT.getType());
            inboundDetail.setRejectMete(BigDecimal.ZERO);
            inboundDetail.setRejectQuantity(BigDecimal.ZERO);
            WasteConfig scrapDefinitionConf = this.basicConfigService.getSteelScrapDefinitionConf();
            boolean isScrap = false;
            if (BasicClassEnum.STEEL_PLATE.getType().equals(inboundDetail.getBasicClass())) {
               isScrap = inboundDetail.getLength().compareTo(scrapDefinitionConf.getSteelPlateShortestSideMinLength()) <= 0
                  || inboundDetail.getWidth().compareTo(scrapDefinitionConf.getSteelPlateShortestSideMinLength()) <= 0;
            }

            if (BasicClassEnum.SECTION_STEEL.getType().equals(inboundDetail.getBasicClass())) {
               isScrap = inboundDetail.getLength().compareTo(scrapDefinitionConf.getSectionSteelMinLength()) <= 0;
            }

            if (BasicClassEnum.COLOR_ROLL.getType().equals(inboundDetail.getBasicClass())) {
               isScrap = inboundDetail.getQuantity().compareTo(scrapDefinitionConf.getSteelCoilMinLength()) <= 0;
            }

            if (isScrap) {
               Scrap scrap = BeanUtil.copy(inboundDetail, Scrap.class, "createTime");
               scrap.setWarehouseType(inboundDetail.getProjectId() != null ? 2 : 1);
               scrap.setAmount(inboundDetail.getAmount());
               scrap.setAmountExcludingVat(inboundDetail.getAmountExcludingVat());
               scrap.setAmountNoFreight(inboundDetail.getAmountNoFreight());
               scrap.setAmountExcludingVatNoFreight(inboundDetail.getAmountExcludingVatNoFreight());
               scrap.setCreateTime(LocalDateTime.now());
               this.scrapMapper.insert(scrap);
            } else {
               MaterialInventory materialInventory = null;
               if (!BasicClassEnum.COLOR_ROLL.getType().equals(inboundDetail.getBasicClass())) {
                  materialInventory = this.materialInventoryService.getByInboundDetail(inboundDetail);
               }

               MaterialInventory newMaterialInventory = this.setMaterialInventoryV2(inboundDetail, materialInventory);
               newMaterialInventory.setUseStatus(false);
               if (materialInventory != null) {
                  newMaterialInventory.setUpdateTime(LocalDateTime.now());
                  this.materialInventoryService.updateById(newMaterialInventory);
               } else {
                  this.materialInventoryService.save(newMaterialInventory);
               }

               this.wmsUtil
                  .setInventoryUse(
                     newMaterialInventory,
                     inboundDetail.getQuantity(),
                     inboundDetail.getMete(),
                     ReceiptTypeEnum.INBOUND,
                     inbound.getId(),
                     inbound.getSerialNumber(),
                     1,
                     true
                  );
               Statistics monthWAP = this.weightedAveragePriceService
                  .createMonthWAP(inboundDetail, newMaterialInventory, inbound.getId(), inbound.getSerialNumber(), ReceiptTypeEnum.INBOUND.getType());
               inboundDetail.setWapId(monthWAP.getWapId());
               inboundDetail.setReviewStatus(2);
               this.warningService.updateStatus(newMaterialInventory, 1);
            }

            amount = amount.add(inboundDetail.getAmount());
            amountNoFreight = amountNoFreight.add(inboundDetail.getAmountNoFreight());
            amountExcludingVAT = amountExcludingVAT.add(inboundDetail.getAmountExcludingVat());
            amountExcludingVATNoFreight = amountExcludingVATNoFreight.add(inboundDetail.getAmountExcludingVatNoFreight());
            inboundDetail.setInboundTime(LocalDateTime.now());
            this.inboundDetailMapper.updateById(inboundDetail);
         }
      }

      inbound.setAmount(amount);
      inbound.setAmountNoFreight(amountNoFreight);
      inbound.setAmountExcludingVat(amountExcludingVAT);
      inbound.setAmountExcludingVatNoFreight(amountExcludingVATNoFreight);
      Print print = this.printService
         .getOne(
            (Wrapper<Print>)((Wrappers.<Print>lambdaQuery().eq(Print::getReceiptId, inbound.getId()))
                  .eq(Print::getReceiptType, ReceiptTypeEnum.INBOUND.getType()))
               .eq(Print::getBoolPrinted, false)
         );
      if (print != null) {
         print.setReceiptReviewer(inbound.getReviewerName());
         print.setReceiptReviewTime(inbound.getReviewTime());
         this.printService.updateById(print);
      }

      LogisticsOrder logisticsOrder = this.logisticsOrderService
         .getOne(
            (Wrapper<LogisticsOrder>)(Wrappers.<LogisticsOrder>lambdaQuery().eq(LogisticsOrder::getInboundId, inbound.getId()))
               .eq(LogisticsOrder::getTableNameType, TableNameTypeEnum.WMS_INBOUND.getType())
         );
      if (logisticsOrder != null) {
         logisticsOrder.setInboundReviewStatus(ReviewStatusEnum.REVIEWED.getType());
         this.logisticsOrderService.updateById(logisticsOrder);
      }

      return this.baseMapper.updateById(inbound) == 1;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean savePartyAInboundV2(InboundDTOParam dtoParam) {
      dtoParam.setSupplyType(SupplyTypeEnum.PARTY_A.getType());
      BasicInbound basicInbound = this.basicConfigService.getInboundBasicConfV2();
      List<Integer> basicClass = new ArrayList<>();
      basicClass.add(dtoParam.getBasicClass());
      MountMessageDTO mountMessageDTO = new MountMessageDTO();
      mountMessageDTO.setBasicClass(basicClass);
      Integer approveProcessType = this.getFlows(dtoParam, basicInbound, null, mountMessageDTO);
      Inbound inbound = new Inbound();
      inbound.setBoolPartyA(true);
      inbound.setReviewStatus(ReviewStatusEnum.AUDITING.getType());
      inbound.setApplicantId(UserUtil.getCurrentUserId());
      inbound.setApplicantName(UserUtil.getCurrentName());
      inbound.setUserUpdateTime(LocalDateTime.now());
      inbound.setEditorId(UserUtil.getCurrentUserId());
      inbound.setEditorName(UserUtil.getCurrentName());
      inbound.setShipmentNumber(dtoParam.getShipmentNumber());
      inbound.setRejectStatus(RejectEnum.NO_REJECT.getType());
      if ((dtoParam.getReviewStatus() == null || !ReviewStatusEnum.RETURNED.getType().equals(dtoParam.getReviewStatus()))
         && !ReviewStatusEnum.CANCEL.getType().equals(dtoParam.getReviewStatus())) {
         while (true) {
            Integer maxDayNumber = this.queryUtil.createInboundSerialNumber("inbound");
            String serialNumber = this.numberConfigService.getNumber(NumberTypeEnum.INBOUND, maxDayNumber);
            List<Inbound> wmsApproveRecords = this.baseMapper.selectList((Wrapper<Inbound>)new LambdaQueryWrapper<Inbound>().eq(Inbound::getSerialNumber, serialNumber));
            if (CollectionUtils.isEmpty(wmsApproveRecords)) {
               inbound.setEditable(true);
               inbound.setEstablishQuantity(maxDayNumber);
               inbound.setSerialNumber(serialNumber);
               break;
            }
         }
      } else {
         Inbound sourceInbound = this.baseMapper.selectById(dtoParam.getId());
         if (sourceInbound.getOriginalId() != null) {
            sourceInbound = this.baseMapper.selectById(sourceInbound.getOriginalId());
         }

         this.baseMapper.updateEditable(sourceInbound.getId(), 0);
         Integer number = sourceInbound.getOriginalNumber();
         number = number + 1;
         sourceInbound.setOriginalNumber(number);
         sourceInbound.setEditable(false);
         this.baseMapper.updateById(sourceInbound);
         inbound.setSerialNumber(sourceInbound.getSerialNumber() + "-" + number);
         inbound.setOriginalId(sourceInbound.getId());
         inbound.setEditable(true);
      }

      this.baseMapper.insert(inbound);
      this.checkInboundDetailParamV2(inbound, dtoParam, null, basicInbound);
      this.classificationService.updateClassifyUsed(IdsStatusDTO.builder().idsStr(inbound.getClassifyIds()).build());
      this.baseMapper.updateById(inbound);
      boolean boolQualityTesting = inbound.getQualityTestingEnum().equals(QualityTestingEnum.UN_REVIEWED.getType());
      WmsApproveRecordDetail wmsApproveRecordDetail = null;
      if (boolQualityTesting) {
         wmsApproveRecordDetail = new WmsApproveRecordDetail();
         wmsApproveRecordDetail.setCreateTime(LocalDateTime.now());
         wmsApproveRecordDetail.setArrivalTime(LocalDateTime.now());
         wmsApproveRecordDetail.setDataId(inbound.getId());
         wmsApproveRecordDetail.setModuleType(ModuleTypeEnum.WMS.getType());
         wmsApproveRecordDetail.setFunctionType(FunctionTypeEnum.WMS_PARTY_A_SUPPLY_IN.getType());
         wmsApproveRecordDetail.setApproveProcessType(approveProcessType);
         wmsApproveRecordDetail.setFlowType(ApproveTemplateVersionsFlowEnum.QUALITY_TESTING.getType());
         wmsApproveRecordDetail.setStatus(ApproveRecordStatusEnum.UNDERWAY.getType());
      }

      this.baseMapper.updateById(inbound);
      InboundDTO inboundDTO = this.getInboundDTOById(inbound.getId(), false);
      String jsonData = JSON.toJSONString(inboundDTO);
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService
         .createRecord(
            inbound.getId(),
            inbound.getSerialNumber(),
            approveProcessType,
            dtoParam.getCause(),
            wmsApproveRecordDetail,
            jsonData,
            false,
            mountMessageDTO,
            null,
            null
         );
      inbound.setApproveRecordId(wmsApproveRecord.getId());
      this.baseMapper.updateById(inbound);
      if (wmsApproveRecord.getStatus().equals(ApproveRecordStatusEnum.END.getType())) {
         dtoParam.setInbound(inbound);
         this.passedPartyAV2(dtoParam);
      }

      this.pushMessage(
         inbound, wmsApproveRecord, NotificationModuleTypeEnum.WMS_MATERIAL_PARTY_A_INBOUND.getNotificationType(), SupplyTypeEnum.PARTY_A.getType()
      );
      return this.baseMapper.updateById(inbound) == 1;
   }

   @Transactional
   @Override
   public synchronized Boolean saveBeginPartyAInbound(InboundDTOParam dtoParam) {
      dtoParam.setSupplyType(SupplyTypeEnum.PARTY_A.getType());
      List<Integer> basicClass = new ArrayList<>();
      basicClass.add(dtoParam.getBasicClass());
      MountMessageDTO mountMessageDTO = new MountMessageDTO();
      mountMessageDTO.setBasicClass(basicClass);
      mountMessageDTO.setInboundWay(Collections.singletonList(InboundWayEnum.BEGIN_PERIOD.getType()));
      Integer approveProcessType = ApproveProcessTypeEnumV2.PARTY_A_SUPPLY_IN.getType();
      Inbound inbound = new Inbound();
      inbound.setBoolPartyA(true);
      inbound.setReviewStatus(ReviewStatusEnum.AUDITING.getType());
      inbound.setApplicantId(UserUtil.getCurrentUserId());
      inbound.setApplicantName(UserUtil.getCurrentName());
      inbound.setUserUpdateTime(LocalDateTime.now());
      inbound.setEditorId(UserUtil.getCurrentUserId());
      inbound.setEditorName(UserUtil.getCurrentName());
      inbound.setShipmentNumber(dtoParam.getShipmentNumber());
      inbound.setRejectStatus(RejectEnum.NO_REJECT.getType());
      inbound.setInboundWay(InboundWayEnum.BEGIN_PERIOD.getType());
      if ((dtoParam.getReviewStatus() == null || !ReviewStatusEnum.RETURNED.getType().equals(dtoParam.getReviewStatus()))
         && !ReviewStatusEnum.CANCEL.getType().equals(dtoParam.getReviewStatus())) {
         while (true) {
            Integer maxDayNumber = this.queryUtil.createInboundSerialNumber("inbound");
            String serialNumber = this.numberConfigService.getNumber(NumberTypeEnum.INBOUND, maxDayNumber);
            List<Inbound> wmsApproveRecords = this.baseMapper.selectList((Wrapper<Inbound>)new LambdaQueryWrapper<Inbound>().eq(Inbound::getSerialNumber, serialNumber));
            if (CollectionUtils.isEmpty(wmsApproveRecords)) {
               inbound.setEditable(true);
               inbound.setEstablishQuantity(maxDayNumber);
               inbound.setSerialNumber(serialNumber);
               break;
            }
         }
      } else {
         Inbound sourceInbound = this.baseMapper.selectById(dtoParam.getId());
         if (sourceInbound.getOriginalId() != null) {
            sourceInbound = this.baseMapper.selectById(sourceInbound.getOriginalId());
         }

         this.baseMapper.updateEditable(sourceInbound.getId(), 0);
         Integer number = sourceInbound.getOriginalNumber();
         number = number + 1;
         sourceInbound.setOriginalNumber(number);
         sourceInbound.setEditable(false);
         this.baseMapper.updateById(sourceInbound);
         inbound.setSerialNumber(sourceInbound.getSerialNumber() + "-" + number);
         inbound.setOriginalId(sourceInbound.getId());
         inbound.setEditable(true);
      }

      this.baseMapper.insert(inbound);
      this.saveInboundDetailAndFillInboundInfo(inbound, dtoParam);
      this.classificationService.updateClassifyUsed(IdsStatusDTO.builder().idsStr(inbound.getClassifyIds()).build());
      this.baseMapper.updateById(inbound);
      boolean boolQualityTesting = inbound.getQualityTestingEnum().equals(QualityTestingEnum.UN_REVIEWED.getType());
      WmsApproveRecordDetail wmsApproveRecordDetail = null;
      if (boolQualityTesting) {
         wmsApproveRecordDetail = new WmsApproveRecordDetail();
         wmsApproveRecordDetail.setCreateTime(LocalDateTime.now());
         wmsApproveRecordDetail.setArrivalTime(LocalDateTime.now());
         wmsApproveRecordDetail.setDataId(inbound.getId());
         wmsApproveRecordDetail.setModuleType(ModuleTypeEnum.WMS.getType());
         wmsApproveRecordDetail.setFunctionType(FunctionTypeEnum.WMS_PARTY_A_SUPPLY_IN.getType());
         wmsApproveRecordDetail.setApproveProcessType(approveProcessType);
         wmsApproveRecordDetail.setFlowType(ApproveTemplateVersionsFlowEnum.QUALITY_TESTING.getType());
         wmsApproveRecordDetail.setStatus(ApproveRecordStatusEnum.UNDERWAY.getType());
      }

      this.baseMapper.updateById(inbound);
      InboundDTO inboundDTO = this.getInboundDTOById(inbound.getId(), false);
      String jsonData = JSON.toJSONString(inboundDTO);
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService
         .createRecord(
            inbound.getId(),
            inbound.getSerialNumber(),
            approveProcessType,
            dtoParam.getCause(),
            wmsApproveRecordDetail,
            jsonData,
            false,
            mountMessageDTO,
            null,
            null
         );
      inbound.setApproveRecordId(wmsApproveRecord.getId());
      this.baseMapper.updateById(inbound);
      if (wmsApproveRecord.getStatus().equals(ApproveRecordStatusEnum.END.getType())) {
         dtoParam.setInbound(inbound);
         this.passedPartyBeginAV2(dtoParam);
      }

      this.pushMessage(
         inbound, wmsApproveRecord, NotificationModuleTypeEnum.WMS_MATERIAL_PARTY_A_INBOUND.getNotificationType(), SupplyTypeEnum.PARTY_A.getType()
      );
      return this.baseMapper.updateById(inbound) == 1;
   }

   public Boolean passedPartyAV2(InboundDTOParam request) {
      Inbound inbound = request.getInbound();
      List<InboundDetail> inboundDetails = request.getInboundDetails();
      inboundDetails = inboundDetails.stream()
         .filter(
            i -> QualityTestingEnum.ALL_PASS.getType().equals(i.getQualityTestingEnum()) || QualityTestingEnum.NO.getType().equals(i.getQualityTestingEnum())
         )
         .collect(Collectors.toList());
      inbound.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
      inbound.setReviewTime(LocalDateTime.now());
      inbound.setReviewerId(UserUtil.getCurrentUserId());
      inbound.setReviewerName(UserUtil.getCurrentName());
      inbound.setEditable(false);
      inbound.setApprovalComments(request.getApprovalComments());
      BigDecimal loadingWeight = BigDecimal.ZERO;
      if (BasicClassEnum.STRUC_MANUFACTURED.getType().equals(inbound.getBasicClass())
         | BasicClassEnum.ENCL_MANUFACTURED.getType().equals(inbound.getBasicClass())) {
         inboundDetails = this.inboundDetailMapper.selectList((Wrapper<InboundDetail>)Wrappers.<InboundDetail>lambdaQuery().eq(InboundDetail::getInboundId, inbound.getId()));
         this.mesSPABiz
            .assistArtifactReport(
               inboundDetails.stream()
                  .map(
                     i -> ExternalArtifactDTO.builder()
                        .productId(i.getArtifactEnclosureId())
                        .quantity(i.getQuantity().intValue())
                        .warehousingType(i.getWorkshopId() != null ? 0 : 1)
                        .workShopId(i.getWorkshopId())
                        .build()
                  )
                  .collect(Collectors.toList())
            );
      } else {
         for (InboundDetail inboundDetail : inboundDetails) {
            if (QualityTestingEnum.ALL_PASS.getType().equals(inboundDetail.getQualityTestingEnum())
               || QualityTestingEnum.NO.getType().equals(inboundDetail.getQualityTestingEnum())) {
               loadingWeight = inboundDetail.getMete().add(loadingWeight);
               inboundDetail.setRejectStatus(RejectEnum.NO_REJECT.getType());
               inboundDetail.setRejectMete(BigDecimal.ZERO);
               inboundDetail.setRejectQuantity(BigDecimal.ZERO);
               WasteConfig scrapDefinitionConf = this.basicConfigService.getSteelScrapDefinitionConf();
               boolean isScrap = false;
               if (BasicClassEnum.STEEL_PLATE.getType().equals(inboundDetail.getBasicClass())) {
                  isScrap = inboundDetail.getLength().compareTo(scrapDefinitionConf.getSteelPlateShortestSideMinLength()) <= 0
                     || inboundDetail.getWidth().compareTo(scrapDefinitionConf.getSteelPlateShortestSideMinLength()) <= 0;
               }

               if (BasicClassEnum.SECTION_STEEL.getType().equals(inboundDetail.getBasicClass())) {
                  isScrap = inboundDetail.getLength().compareTo(scrapDefinitionConf.getSectionSteelMinLength()) <= 0;
               }

               if (BasicClassEnum.COLOR_ROLL.getType().equals(inboundDetail.getBasicClass())) {
                  isScrap = inboundDetail.getQuantity().compareTo(scrapDefinitionConf.getSteelCoilMinLength()) <= 0;
               }

               if (isScrap) {
                  Scrap scrap = BeanUtil.copy(inboundDetail, Scrap.class, "createTime");
                  scrap.setWarehouseType(inboundDetail.getProjectId() != null ? 2 : 1);
                  scrap.setAmount(inboundDetail.getAmount());
                  scrap.setAmountExcludingVat(inboundDetail.getAmountExcludingVat());
                  scrap.setAmountNoFreight(inboundDetail.getAmountNoFreight());
                  scrap.setAmountExcludingVatNoFreight(inboundDetail.getAmountExcludingVatNoFreight());
                  scrap.setCreateTime(LocalDateTime.now());
                  this.scrapMapper.insert(scrap);
               } else {
                  MaterialInventory materialInventory = null;
                  if (!BasicClassEnum.COLOR_ROLL.getType().equals(inboundDetail.getBasicClass())) {
                     if (InboundWayEnum.BEGIN_PERIOD.getType().equals(inbound.getInboundWay())) {
                        materialInventory = this.materialInventoryService.getByBeginInboundDetail(inboundDetail);
                     } else {
                        materialInventory = this.materialInventoryService.getByInboundDetail(inboundDetail);
                     }
                  }

                  MaterialInventory newMaterialInventory = this.setMaterialInventoryV2(inboundDetail, materialInventory);
                  newMaterialInventory.setUseStatus(false);
                  if (materialInventory != null) {
                     newMaterialInventory.setUpdateTime(LocalDateTime.now());
                     this.materialInventoryService.updateById(newMaterialInventory);
                  } else {
                     this.materialInventoryService.save(newMaterialInventory);
                  }

                  this.wmsUtil
                     .setInventoryUse(
                        newMaterialInventory,
                        inboundDetail.getQuantity(),
                        inboundDetail.getMete(),
                        ReceiptTypeEnum.INBOUND,
                        inbound.getId(),
                        inbound.getSerialNumber(),
                        1,
                        true
                     );
                  this.weightedAveragePriceService
                     .createMonthWAP(inboundDetail, newMaterialInventory, inbound.getId(), inbound.getSerialNumber(), ReceiptTypeEnum.INBOUND.getType());
                  this.warningService.updateStatus(newMaterialInventory, 1);
               }

               inboundDetail.setInboundTime(LocalDateTime.now());
               this.inboundDetailMapper.updateById(inboundDetail);
            }
         }
      }

      Print print = this.printService
         .getOne(
            (Wrapper<Print>)((Wrappers.<Print>lambdaQuery().eq(Print::getReceiptId, inbound.getId()))
                  .eq(Print::getReceiptType, ReceiptTypeEnum.INBOUND.getType()))
               .eq(Print::getBoolPrinted, false)
         );
      if (print != null) {
         print.setReceiptReviewer(inbound.getReviewerName());
         print.setReceiptReviewTime(inbound.getReviewTime());
         this.printService.updateById(print);
      }

      LogisticsOrder logisticsOrder = this.logisticsOrderService
         .getOne(
            (Wrapper<LogisticsOrder>)(Wrappers.<LogisticsOrder>lambdaQuery().eq(LogisticsOrder::getInboundId, inbound.getId()))
               .eq(LogisticsOrder::getTableNameType, TableNameTypeEnum.WMS_INBOUND.getType())
         );
      if (logisticsOrder != null) {
         logisticsOrder.setInboundReviewStatus(ReviewStatusEnum.REVIEWED.getType());
         this.logisticsOrderService.updateById(logisticsOrder);
      }

      return this.baseMapper.updateById(inbound) == 1;
   }

   public Boolean passedPartyBeginAV2(InboundDTOParam request) {
      Inbound inbound = request.getInbound();
      List<InboundDetail> inboundDetails = request.getInboundDetails();
      inboundDetails = inboundDetails.stream()
         .filter(
            i -> QualityTestingEnum.ALL_PASS.getType().equals(i.getQualityTestingEnum()) || QualityTestingEnum.NO.getType().equals(i.getQualityTestingEnum())
         )
         .collect(Collectors.toList());
      inbound.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
      inbound.setReviewTime(LocalDateTime.now());
      inbound.setReviewerId(UserUtil.getCurrentUserId());
      inbound.setReviewerName(UserUtil.getCurrentName());
      inbound.setEditable(false);
      inbound.setApprovalComments(request.getApprovalComments());
      BigDecimal loadingWeight = BigDecimal.ZERO;
      WasteConfig scrapDefinitionConf = this.basicConfigService.getSteelScrapDefinitionConf();
      List<Scrap> saveScrapList = new ArrayList<>();
      List<InboundDetail> updateInboundDetailList = new ArrayList<>();

      for (InboundDetail inboundDetail : inboundDetails) {
         if (QualityTestingEnum.ALL_PASS.getType().equals(inboundDetail.getQualityTestingEnum())
            || QualityTestingEnum.NO.getType().equals(inboundDetail.getQualityTestingEnum())) {
            loadingWeight = inboundDetail.getMete().add(loadingWeight);
            inboundDetail.setRejectStatus(RejectEnum.NO_REJECT.getType());
            inboundDetail.setRejectMete(BigDecimal.ZERO);
            inboundDetail.setRejectQuantity(BigDecimal.ZERO);
            boolean isScrap = false;
            if (BasicClassEnum.STEEL_PLATE.getType().equals(inboundDetail.getBasicClass())) {
               isScrap = inboundDetail.getLength().compareTo(scrapDefinitionConf.getSteelPlateShortestSideMinLength()) <= 0
                  || inboundDetail.getWidth().compareTo(scrapDefinitionConf.getSteelPlateShortestSideMinLength()) <= 0;
            }

            if (BasicClassEnum.SECTION_STEEL.getType().equals(inboundDetail.getBasicClass())) {
               isScrap = inboundDetail.getLength().compareTo(scrapDefinitionConf.getSectionSteelMinLength()) <= 0;
            }

            if (BasicClassEnum.COLOR_ROLL.getType().equals(inboundDetail.getBasicClass())) {
               isScrap = inboundDetail.getQuantity().compareTo(scrapDefinitionConf.getSteelCoilMinLength()) <= 0;
            }

            if (isScrap) {
               Scrap scrap = BeanUtil.copy(inboundDetail, Scrap.class, "createTime");
               scrap.setWarehouseType(inboundDetail.getProjectId() != null ? 2 : 1);
               scrap.setAmount(inboundDetail.getAmount());
               scrap.setAmountExcludingVat(inboundDetail.getAmountExcludingVat());
               scrap.setAmountNoFreight(inboundDetail.getAmountNoFreight());
               scrap.setAmountExcludingVatNoFreight(inboundDetail.getAmountExcludingVatNoFreight());
               scrap.setCreateTime(LocalDateTime.now());
               saveScrapList.add(scrap);
            } else {
               MaterialInventory materialInventory = null;
               if (!BasicClassEnum.COLOR_ROLL.getType().equals(inboundDetail.getBasicClass())) {
                  if (InboundWayEnum.BEGIN_PERIOD.getType().equals(inbound.getInboundWay())) {
                     materialInventory = this.materialInventoryService.getByBeginInboundDetail(inboundDetail);
                  } else {
                     materialInventory = this.materialInventoryService.getByInboundDetail(inboundDetail);
                  }
               }

               MaterialInventory newMaterialInventory = this.setMaterialInventoryV2(inboundDetail, materialInventory);
               newMaterialInventory.setUseStatus(false);
               if (materialInventory != null) {
                  newMaterialInventory.setUpdateTime(LocalDateTime.now());
                  this.materialInventoryService.updateById(newMaterialInventory);
               } else {
                  this.materialInventoryService.save(newMaterialInventory);
               }

               this.wmsUtil
                  .setInventoryUse(
                     newMaterialInventory,
                     inboundDetail.getQuantity(),
                     inboundDetail.getMete(),
                     ReceiptTypeEnum.INBOUND,
                     inbound.getId(),
                     inbound.getSerialNumber(),
                     1,
                     true
                  );
               this.weightedAveragePriceService
                  .createMonthWAP(inboundDetail, newMaterialInventory, inbound.getId(), inbound.getSerialNumber(), ReceiptTypeEnum.INBOUND.getType());
               this.warningService.updateStatus(newMaterialInventory, 1);
            }

            inboundDetail.setInboundTime(LocalDateTime.now());
            updateInboundDetailList.add(inboundDetail);
         }
      }

      this.scrapService.saveBatch(saveScrapList);
      this.inboundDetailService.updateBatchById(updateInboundDetailList);
      Print print = this.printService
         .getOne(
            (Wrapper<Print>)((Wrappers.<Print>lambdaQuery().eq(Print::getReceiptId, inbound.getId()))
                  .eq(Print::getReceiptType, ReceiptTypeEnum.INBOUND.getType()))
               .eq(Print::getBoolPrinted, false)
         );
      if (print != null) {
         print.setReceiptReviewer(inbound.getReviewerName());
         print.setReceiptReviewTime(inbound.getReviewTime());
         this.printService.updateById(print);
      }

      return this.baseMapper.updateById(inbound) == 1;
   }

   private void checkInboundDetailParamV2(Inbound inbound, InboundDTOParam dtoParam, PurchaseOrder order, BasicInbound basicInbound) {
      if (!inbound.getBoolPartyA()) {
         Preconditions.checkArgument(ObjectUtil.isNotEmpty(basicInbound.getMoney()), "入库基础配置未配置运费金额填写场景，请前往设置");
         Preconditions.checkArgument(ObjectUtil.isNotEmpty(basicInbound.getWeight()), "入库基础配置未配置运费重量填写场景，请前往设置");
         Preconditions.checkArgument(ObjectUtil.isNotEmpty(basicInbound.getLoadingFee()), "入库基础配置未配置装车费填写场景，请前往设置");
         Preconditions.checkArgument(ObjectUtil.isNotEmpty(basicInbound.getInvoiceTax()), "入库基础配置未配置发票税率填写场景，请前往设置");
         Preconditions.checkArgument(ObjectUtil.isNotEmpty(basicInbound.getLogisticsUnit()), "入库基础配置未配置物流单位填写场景，请前往设置");
         if (order.getLogisticsPayerType().equals(LogisticsPayerEnum.DEMAND.getType())) {
            StringBuffer msg = new StringBuffer();
            if (ObjectUtil.isEmpty(dtoParam.getLogistics())) {
               if (basicInbound.getMoney().equals(FillWayEnum.APPLICATION.getType())) {
                  msg.append("运费金额");
               }

               if (basicInbound.getInvoiceTax().equals(FillWayEnum.APPLICATION.getType())) {
                  if (msg.length() > 0) {
                     msg.append("和");
                  }

                  msg.append("发票税率");
               }

               if (basicInbound.getLogisticsUnit().equals(FillWayEnum.APPLICATION.getType())) {
                  if (msg.length() > 0) {
                     msg.append("和");
                  }

                  msg.append("物流单位");
               }

               Preconditions.checkArgument(msg.length() == 0, msg + "填写场景为提交时填写,但提交时未传输信息");
            } else {
               if (basicInbound.getMoney().equals(FillWayEnum.AUDIT.getType()) && ObjectUtil.isNotEmpty(dtoParam.getLogistics().getFreight())) {
                  Preconditions.checkArgument(false, "运费金额填写场景为审核时填写,但提交时传输了运费信息，非法调用");
               }

               if (basicInbound.getMoney().equals(FillWayEnum.APPLICATION.getType()) && ObjectUtil.isEmpty(dtoParam.getLogistics().getFreight())) {
                  Preconditions.checkArgument(false, "运费金额填写场景为提交时填写,但提交时未传输运费信息，请传运费信息");
               }

               if (basicInbound.getWeight().equals(FillWayEnum.AUDIT.getType()) && ObjectUtil.isNotEmpty(dtoParam.getLogistics().getFreightWeight())) {
                  Preconditions.checkArgument(false, "运费重量填写场景为审核时填写,但提交时传输了运费信息，非法调用");
               }

               if (basicInbound.getLoadingFee().equals(FillWayEnum.AUDIT.getType()) && ObjectUtil.isNotEmpty(dtoParam.getLogistics().getLoadingCharge())) {
                  Preconditions.checkArgument(false, "装车费填写场景为审核时填写,但提交时传输了装车费信息，非法调用");
               }

               if (basicInbound.getInvoiceTax().equals(FillWayEnum.AUDIT.getType()) && ObjectUtil.isNotEmpty(dtoParam.getLogistics().getInvoiceType())) {
                  Preconditions.checkArgument(false, "发票税率填写场景为审核时填写,但提交时传输了发票税率信息，非法调用");
               }

               if (basicInbound.getInvoiceTax().equals(FillWayEnum.APPLICATION.getType()) && ObjectUtil.isEmpty(dtoParam.getLogistics().getInvoiceType())) {
                  Preconditions.checkArgument(false, "发票税率填写场景为提交时填写,但提交时未传输发票税率信息，请传发票税率信息");
               }

               if (basicInbound.getLogisticsUnit().equals(FillWayEnum.AUDIT.getType()) && ObjectUtil.isNotEmpty(dtoParam.getLogistics().getSupplierId())) {
                  Preconditions.checkArgument(false, "物流单位填写场景为审核时填写,但提交时传输了物流单位信息，非法调用");
               }

               if (basicInbound.getLogisticsUnit().equals(FillWayEnum.APPLICATION.getType()) && ObjectUtil.isEmpty(dtoParam.getLogistics().getSupplierId())) {
                  Preconditions.checkArgument(false, "物流单位填写场景为提交时填写,但提交时未传输物流单位信息，请传物流单位信息");
               }
            }
         }

         if (ObjectUtil.isNotEmpty(order) && !order.getBoolDetail()) {
            List<InboundDetailDTOParam> amountList = dtoParam.getList()
               .stream()
               .filter(detail -> ObjectUtil.isNotEmpty(detail.getAmount()))
               .collect(Collectors.toList());
            List<InboundDetailDTOParam> noAmountList = dtoParam.getList()
               .stream()
               .filter(detail -> ObjectUtil.isEmpty(detail.getAmount()))
               .collect(Collectors.toList());
            if (basicInbound.getAmountFillWay().equals(FillWayEnum.AUDIT.getType()) && CollectionUtils.isNotEmpty(amountList)) {
               Preconditions.checkArgument(false, "无明细金额填写场景为审核时填写,但提交时传输了金额信息，非法调用");
            }

            if (basicInbound.getAmountFillWay().equals(FillWayEnum.APPLICATION.getType()) && ObjectUtil.isNotEmpty(noAmountList)) {
               Preconditions.checkArgument(false, "无明细金额填写场景为提交时填写,但提交时存在未填写金额信息数据，请传金额");
            }
         }
      }

      Print print = null;
      List<Long> projectIds = new ArrayList<>();
      int basicClass = 0;
      BigDecimal inboundTotalWeight = new BigDecimal(BigInteger.ZERO);
      boolean boolQualityTesting = false;
      List<InboundDetail> inboundDetails = new ArrayList<>();
      TreeSet<String> classifyIds = new TreeSet<>();
      Map<Long, Classification> classificationMap = new HashMap<>();
      if (CollectionUtil.isNotEmpty(dtoParam.getList())) {
         List<ClassificationCheckDTO> classificationCheckDTOS = dtoParam.getList()
            .stream()
            .map(d -> cn.hutool.core.bean.BeanUtil.toBean(d, ClassificationCheckDTO.class))
            .collect(Collectors.toList());
         classificationMap = this.classificationService.checkClassification(classificationCheckDTOS, dtoParam.getClickTime());
      }

      WmsClosingTime one = this.wmsClosingTimeService
         .getOne((Wrapper<WmsClosingTime>)(new LambdaQueryWrapper<WmsClosingTime>().orderBy(true, false, WmsClosingTime::getId)).last("limit 1"));

      for (InboundDetailDTOParam detailParam : dtoParam.getList()) {
         Measure measure = this.measureMapper.selectOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, detailParam.getClassifyId()));
         if (one != null && detailParam.getRealTime() != null) {
            Preconditions.checkArgument(
               detailParam.getRealTime().isAfter(one.getEndTime()) && detailParam.getRealTime().isBefore(LocalDateTime.now()), "实际时间不能在实际关账时间之前,请刷新页面重新办理"
            );
         }

         PurchaseOrderDetail orderDetail = null;
         Long purchaseOrderDetailId = detailParam.getApplyPurchaseId() == null ? detailParam.getPurchaseOrderDetailId() : detailParam.getPurchaseDetailId();
         if (purchaseOrderDetailId != null) {
            orderDetail = this.poDetailService.getById(purchaseOrderDetailId);
         }

         InboundDetail inboundDetail;
         if (orderDetail != null && orderDetail.getArtifactEnclosureId() != null) {
            inboundDetail = InboundDetail.builder()
               .inboundId(inbound.getId())
               .purchaseOrderDetailId(purchaseOrderDetailId)
               .projectId(detailParam.getProjectId())
               .basicClass(orderDetail.getBasicClass())
               .quantity(detailParam.getQuantity())
               .artifactEnclosureId(orderDetail.getArtifactEnclosureId())
               .remark(detailParam.getRemark())
               .taxRate(order.getTaxRate())
               .invoiceType(order.getInvoiceType())
               .workshopId(detailParam.getWorkshopId())
               .mergeId(detailParam.getMergeId())
               .build();
            inboundDetail.setUnitPrice(orderDetail.getUnitPrice());
            inboundDetail.setAmount(orderDetail.getUnitPrice().multiply(inboundDetail.getQuantity()));
            if (InvoiceTypeEnum.SPECIAL.getType().equals(order.getInvoiceType())) {
               BigDecimal value = order.getTaxRate().divide(HUNDRED).add(BigDecimal.ONE);
               inboundDetail.setAmountExcludingVat(inboundDetail.getAmount().divide(value, 2, RoundingMode.HALF_UP));
               inboundDetail.setUnitPriceExcludingVat(inboundDetail.getAmountExcludingVat().divide(inboundDetail.getQuantity(), 12, RoundingMode.HALF_UP));
               inboundDetail.setInputVat(inboundDetail.getAmount().subtract(inboundDetail.getAmountExcludingVat()));
            } else {
               inboundDetail.setAmountExcludingVat(inboundDetail.getAmount());
               inboundDetail.setUnitPriceExcludingVat(inboundDetail.getUnitPrice());
            }

            orderDetail.setInboundQuantity(orderDetail.getInboundQuantity().add(detailParam.getQuantity()));
            basicClass = inboundDetail.getBasicClass();
            this.inboundDetailMapper.insert(inboundDetail);
         } else {
            Preconditions.checkArgument(detailParam.getWorkshopId() != null, "请选择车间");
            Preconditions.checkArgument(detailParam.getWarehouseId() != null, "请选择仓库");
            this.checkInfo(detailParam);
            if (orderDetail != null && basicInbound.getProcureMeteDiffState()) {
               Preconditions.checkArgument(
                  orderDetail.getMete()
                        .add(orderDetail.getMete().multiply(basicInbound.getProcureMeteDiff().divide(BigDecimal.valueOf(100L))))
                        .compareTo(orderDetail.getInboundMete().add(detailParam.getMete()))
                     >= 0,
                  "当前入库量已超出采购量允许误差范围（" + basicInbound.getProcureMeteDiff().toPlainString() + "%)"
               );
            }

            Classification classification = classificationMap.get(detailParam.getClassifyId());
            classifyIds.add(classification.getId().toString());
            inboundDetail = BeanUtil.copy(detailParam, InboundDetail.class);
            inboundDetail.setPurchaseOrderDetailId(purchaseOrderDetailId);
            inboundDetail.setDoNotSectionSteelSpec(
               ObjectUtil.isNotEmpty(detailParam.getDoNotSectionSteelSpec()) ? detailParam.getDoNotSectionSteelSpec() : detailParam.getSpecification()
            );
            if (measure.getBoolQualityTesting()) {
               inboundDetail.setQualityTestingEnum(QualityTestingEnum.UN_REVIEWED.getType());
               if (!boolQualityTesting) {
                  boolQualityTesting = true;
               }
            } else {
               inboundDetail.setQualityTestingEnum(QualityTestingEnum.NO.getType());
            }

            inboundDetail.setPurchaseId(ObjectUtil.isNotEmpty(order) ? order.getId() : null);
            inboundDetail.setMeasureUnit(measure.getMeasureUnit());
            inboundDetail.setMeasurePrecision(measure.getMeasurePrecision());
            inboundDetail.setAccountingUnit(measure.getAccountingUnit());
            inboundDetail.setAccountingPrecision(measure.getAccountingPrecision());
            inboundDetail.setBrand(StrUtil.trimToNull(detailParam.getBrand()));
            inboundDetail.setColor(StrUtil.trimToNull(detailParam.getColor()));
            inboundDetail.setHeatNoAndBatchNo(StrUtil.trimToNull(detailParam.getHeatNoAndBatchNo()));
            inboundDetail.setClassifyName(classification.getName());
            inboundDetail.setLength(BasicClassEnum.COLOR_ROLL.getType().equals(inboundDetail.getBasicClass()) ? null : detailParam.getLength());
            inboundDetail.setInboundId(inbound.getId());
            if (!inbound.getBoolPartyA()) {
               Preconditions.checkArgument((order.getBasicClass() & detailParam.getBasicClass()) > 0, "当前物料不符合采购订单物料类型");
               inboundDetail.setInvoiceType(order.getInvoiceType());
               inboundDetail.setTaxRate(order.getTaxRate());
               inboundDetail.setUnitPrice(detailParam.getUnitPrice());
               inboundDetail.setUnitPriceNoFreight(detailParam.getUnitPrice());
               inboundDetail.setAmount(detailParam.getAmount());
               inboundDetail.setAmountNoFreight(detailParam.getAmount());
               inboundDetail.setApplyPurchaseId(detailParam.getApplyPurchaseId());
               if (InvoiceTypeEnum.SPECIAL.getType().equals(order.getInvoiceType())) {
                  BigDecimal value = order.getTaxRate().divide(HUNDRED).add(BigDecimal.ONE);
                  if (inboundDetail.getAmount() != null) {
                     inboundDetail.setAmountExcludingVat(inboundDetail.getAmount().divide(value, 2, RoundingMode.HALF_UP));
                     inboundDetail.setAmountExcludingVatNoFreight(inboundDetail.getAmount().divide(value, 2, RoundingMode.HALF_UP));
                     inboundDetail.setUnitPriceExcludingVat(inboundDetail.getAmountExcludingVat().divide(inboundDetail.getMete(), 12, RoundingMode.HALF_UP));
                     inboundDetail.setUnitPriceExcludingVatNoFreight(
                        inboundDetail.getAmountExcludingVat().divide(inboundDetail.getMete(), 12, RoundingMode.HALF_UP)
                     );
                     inboundDetail.setInputVat(inboundDetail.getAmount().subtract(inboundDetail.getAmountExcludingVat()));
                     inboundDetail.setInputVatNoFreight(inboundDetail.getAmount().subtract(inboundDetail.getAmountExcludingVat()));
                  }
               } else {
                  inboundDetail.setAmountExcludingVat(inboundDetail.getAmount());
                  inboundDetail.setAmountExcludingVatNoFreight(inboundDetail.getAmount());
                  inboundDetail.setUnitPriceExcludingVat(inboundDetail.getUnitPrice());
                  inboundDetail.setUnitPriceExcludingVatNoFreight(inboundDetail.getUnitPrice());
               }
            } else {
               Preconditions.checkArgument(detailParam.getProjectId() != null, "入库失败,甲供入库请选择项目");
               inboundDetail.setAmount(BigDecimal.ZERO);
               inboundDetail.setAmountNoFreight(BigDecimal.ZERO);
               inboundDetail.setAmountExcludingVat(BigDecimal.ZERO);
               inboundDetail.setAmountExcludingVatNoFreight(BigDecimal.ZERO);
               inboundDetail.setUnitPriceExcludingVat(BigDecimal.ZERO);
               inboundDetail.setUnitPriceExcludingVatNoFreight(BigDecimal.ZERO);
               inboundDetail.setUnitPrice(BigDecimal.ZERO);
               inboundDetail.setUnitPriceNoFreight(BigDecimal.ZERO);
            }

            if (detailParam.getBoolNestSurplus() != null) {
               if (detailParam.getBoolNestSurplus()) {
                  String surplusSn = this.queryUtil.getSurplusSn();
                  inboundDetail.setSurplusSn(surplusSn);
                  inboundDetail.setNestSurplusCode(surplusSn);
                  inboundDetail.setBoolNestSurplus(true);
                  inboundDetail.setBoolPartyA(false);
                  String fileName = inboundDetail.getDxfUrl().substring(inboundDetail.getDxfUrl().lastIndexOf(47) + 1);
                  String s = this.downloadFile.downloadFile(inboundDetail.getDxfUrl(), fileName);
                  String s1 = inboundDetail.getImgUrl().substring(inboundDetail.getImgUrl().lastIndexOf(47) + 1);
                  String image = this.downloadFile.downloadFile(inboundDetail.getImgUrl(), s1);
                  inboundDetail.setDxfUrl(s);
                  inboundDetail.setImgUrl(image);
               }
            } else {
               inboundDetail.setBoolNestSurplus(false);
            }

            basicClass |= detailParam.getBasicClass();
            StringBuilder specification = new StringBuilder();
            if (BasicClassEnum.SECTION_STEEL.getType().equals(detailParam.getBasicClass())) {
               String sn = "";
               String specCode = "";
               Preconditions.checkArgument(ObjectUtil.isNotEmpty(detailParam.getSectionSteelSpec()), "该型材未配置国标规格");
               SectionSteelSpec sectionSteelSpec = this.sectionSteelSpecService
                  .getOne(
                     (Wrapper<SectionSteelSpec>)(Wrappers.<SectionSteelSpec>lambdaQuery().eq(SectionSteelSpec::getClassificationId, classification.getId()))
                        .eq(SectionSteelSpec::getSpecification, detailParam.getSectionSteelSpec())
                  );
               Preconditions.checkArgument(sectionSteelSpec != null, "当前型材库规格为[" + detailParam.getSectionSteelSpec() + "]的型材不存在.");
               if (ObjectUtil.isEmpty(detailParam.getPurchaseOrderDetailId())) {
                  Preconditions.checkArgument(sectionSteelSpec.getStatus(), "当前型材库规格为[" + detailParam.getSectionSteelSpec() + "]的型材已禁用.");
               }

               SectionSteelSpecStandardDetail standardDetail = this.sectionSteelSpecStandardDetailMapper
                  .selectOne(
                     (Wrapper<SectionSteelSpecStandardDetail>)((Wrappers.<SectionSteelSpecStandardDetail>lambdaQuery()
                              .eq(SectionSteelSpecStandardDetail::getSpecId, sectionSteelSpec.getId()))
                           .eq(SectionSteelSpecStandardDetail::getStandardId, detailParam.getStandardId()))
                        .eq(SectionSteelSpecStandardDetail::getSectionSteelId, sectionSteelSpec.getSectionSteelId())
                  );
               Preconditions.checkArgument(ObjectUtil.isNotEmpty(standardDetail), "入库失败," + classification.getName() + "未查询到型材规格国标重量");
               Preconditions.checkArgument(
                  standardDetail.getUnitNet() != null && standardDetail.getUnitNet().compareTo(BigDecimal.ZERO) > 0, "入库失败,当前型材规格未配置国标重量"
               );
               Standard standard = this.standardMapper.selectById(standardDetail.getStandardId());
               sn = standard.getCode() + "-" + standardDetail.getCode();
               SectionSteelSpecDTO weightByClassifyId = this.sectionSteelSpecService
                  .getWeightByClassifyId(detailParam.getClassifyId(), detailParam.getSectionSteelSpec());
               BigDecimal oneMete = CommonUtil.getTheoryMete(
                  null, inboundDetail.getLength(), null, null, weightByClassifyId.getDetail().getUnitNet(), classification.getId()
               );
               BigDecimal theoryWeight = oneMete.multiply(detailParam.getQuantity()).setScale(0, RoundingMode.HALF_UP);
               inboundDetail.setSectionSteelWeight(weightByClassifyId.getDetail().getUnitNet());
               inboundDetail.setOneTheoryWeight(oneMete);
               inboundDetail.setTheoryWeight(theoryWeight);
               inboundDetail.setStandardId(standard.getId());
               inboundDetail.setStandardName(standard.getName());
               inboundDetail.setSectionSteelSpecId(sectionSteelSpec.getId());
               inboundDetail.setSectionSteelSpec(sectionSteelSpec.getSpecification());
               inboundDetail.setDoNotSectionSteelSpec(detailParam.getDoNotSectionSteelSpec());
               if (ObjectUtil.isNotEmpty(detailParam.getDoNotSectionSteelSpec())) {
                  Map<String, String> map = this.specificationService.checkClassifySpec(detailParam.getClassifyId(), detailParam.getDoNotSectionSteelSpec());
                  specCode = map.get("code");
                  specification.append(map.get("ids"));
               }

               inboundDetail.setMaterialSn(classification.getSerialNumber() + "-" + sn + specCode);
               inboundTotalWeight = inboundTotalWeight.add(detailParam.getMete());
            } else if (BasicClassEnum.STEEL_PLATE.getType().equals(detailParam.getBasicClass())) {
               Map<String, String> map = this.specificationService.checkClassifySpec(detailParam.getClassifyId(), detailParam.getSpecification());
               String specCode = map.get("code");
               specification.append(map.get("ids"));
               inboundDetail.setMaterialSn(classification.getSerialNumber() + (StrUtil.isNotBlank(specCode) ? "-" + specCode : ""));
               inboundDetail.setTheoryThickness(detailParam.getThickness().setScale(0, RoundingMode.HALF_UP));
               BigDecimal oneTheoryMete = CommonUtil.getTheoryMete(
                  classification.getName(), inboundDetail.getLength(), inboundDetail.getWidth(), inboundDetail.getThickness(), null, classification.getId()
               );
               BigDecimal theoryWeight = oneTheoryMete.multiply(
                     BasicClassEnum.COLOR_ROLL.getType().equals(detailParam.getBasicClass()) ? BigDecimal.ONE : detailParam.getQuantity()
                  )
                  .setScale(0, RoundingMode.HALF_UP);
               inboundDetail.setOneTheoryWeight(oneTheoryMete);
               inboundDetail.setTheoryWeight(theoryWeight);
               inboundTotalWeight = inboundTotalWeight.add(detailParam.getMete());
            } else if (BasicClassEnum.COLOR_ROLL.getType().equals(detailParam.getBasicClass())) {
               Map<String, String> map = this.specificationService.checkClassifySpec(detailParam.getClassifyId(), detailParam.getSpecification());
               String specCode = map.get("code");
               specification.append(map.get("ids"));
               inboundDetail.setMaterialSn(classification.getSerialNumber() + (StrUtil.isNotBlank(specCode) ? "-" + specCode : ""));
               BigDecimal inboundMete = detailParam.getMete().divide(THOUSAND, 0, RoundingMode.HALF_UP);
               inboundDetail.setOneTheoryWeight(inboundMete);
            } else if (BasicClassEnum.checkNotSteel(detailParam.getBasicClass())) {
               Map<String, String> map = this.specificationService.checkClassifySpec(detailParam.getClassifyId(), detailParam.getSpecification());
               String specCode = map.get("code");
               specification.append(map.get("ids"));
               inboundDetail.setMaterialSn(classification.getSerialNumber() + (StrUtil.isNotBlank(specCode) ? "-" + specCode : ""));
               inboundDetail.setUnitNet(
                  detailParam.getQuantity() != null ? detailParam.getMete().divide(detailParam.getQuantity(), 8, RoundingMode.HALF_UP) : BigDecimal.ONE
               );
            }

            Measure measure1 = this.getMeasure(classification.getId());
            if (measure1.getOutboundUnitType().equals(MeasureTypeEnum.MEASURE.getType())) {
               Preconditions.checkArgument(ObjectUtil.isNotEmpty(inboundDetail.getQuantity()), classification.getName() + "为计量方式，但未提交数量，请检查该科目计量配置！！！");
            }

            if (measure1.getOutboundUnitType().equals(MeasureTypeEnum.ACCOUNTING.getType())) {
               Preconditions.checkArgument(ObjectUtil.isEmpty(inboundDetail.getQuantity()), classification.getName() + "为核算方式，但提交了数量，请检查该科目计量配置！！！");
            }

            inboundDetail.setBoolPartyA(inbound.getBoolPartyA());
            inboundDetail.setSpecificationIds(specification.toString());
            if (StrUtil.isEmpty(inboundDetail.getSpecification())) {
               inboundDetail.setSpecification(null);
            }

            this.inboundDetailMapper.insert(inboundDetail);
            if (!measure.getBoolQualityTesting()) {
               print = this.setBarcode(inbound, inboundDetail, print);
               this.inboundDetailMapper.updateById(inboundDetail);
            }

            if (orderDetail != null) {
               if (inboundDetail.getQuantity() != null) {
                  orderDetail.setInboundQuantity(
                     orderDetail.getInboundQuantity() != null ? orderDetail.getInboundQuantity().add(inboundDetail.getQuantity()) : inboundDetail.getQuantity()
                  );
               }

               orderDetail.setInboundMete(
                  orderDetail.getInboundMete() != null ? orderDetail.getInboundMete().add(inboundDetail.getMete()) : inboundDetail.getMete()
               );
               this.poDetailService.updateById(orderDetail);
            }
         }

         if (inboundDetail.getProjectId() != null && !projectIds.contains(inboundDetail.getProjectId())) {
            projectIds.add(inboundDetail.getProjectId());
         }

         inboundDetails.add(inboundDetail);
      }

      if (CollectionUtils.isNotEmpty(classifyIds)) {
         inbound.setClassifyIds(String.join(",", classifyIds));
      }

      dtoParam.setInboundDetails(inboundDetails);
      Map<String, Unit> unitMap = this.queryUtil.getUnitMap(null);
      if (dtoParam.getLoadingWeight() == null && BasicClassEnum.checkIsSteel(basicClass)) {
         List<Integer> nameStr2 = BasicClassEnum.getNameStr2(basicClass);
         List<Measure> measures = this.measureMapper.selectList((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().in(Measure::getBasicClass, nameStr2));
         Map<Integer, BigDecimal> mete = this.queryUtil
            .unitConversionV2(inboundTotalWeight, measures.get(0).getAccountingUnit(), measures.get(0).getAccountingPrecision(), unitMap);
         inbound.setLoadingWeight(dtoParam.getLoadingWeight() != null ? dtoParam.getLoadingWeight() : mete.get(1));
      } else {
         inbound.setLoadingWeight(dtoParam.getLoadingWeight());
      }

      if (boolQualityTesting) {
         inbound.setQualityTestingEnum(QualityTestingEnum.UN_REVIEWED.getType());
      } else {
         inbound.setQualityTestingEnum(QualityTestingEnum.NO.getType());
      }

      if (CollectionUtil.isNotEmpty(projectIds)) {
         String idStr = StrUtil.join(",", projectIds);
         inbound.setProjectIds(idStr);
      }

      inbound.setPurchaseId(dtoParam.getPurchaseId());
      inbound.setBasicClass(basicClass);
      if (print != null) {
         print.setProjectIds(inbound.getProjectIds());
         print.setContainBasicClass(inbound.getBasicClass());
         this.printService.updateById(print);
      }
   }

   private void checkTheoryWeight(SteelInbound inboundSteelConf, InboundDetailDTOParam param, Measure measure, BigDecimal theoryWeight, String s) {
      if (!inboundSteelConf.getOverDiffSubmittable()) {
         BigDecimal inboundMete = param.getMete().divide(THOUSAND, 0, RoundingMode.HALF_UP);
         if (inboundSteelConf.getSteelDiffType() == 2) {
            BigDecimal value = inboundSteelConf.getSteelDiff().divide(HUNDRED);
            BigDecimal diffWeight = theoryWeight.multiply(value).setScale(0, RoundingMode.HALF_UP);
            Preconditions.checkArgument(
               theoryWeight.add(diffWeight).compareTo(inboundMete) >= 0 && theoryWeight.subtract(diffWeight).compareTo(inboundMete) <= 0, s
            );
         } else {
            Preconditions.checkArgument(
               theoryWeight.add(inboundSteelConf.getSteelDiff()).compareTo(inboundMete) >= 0
                  && theoryWeight.subtract(inboundSteelConf.getSteelDiff()).compareTo(inboundMete) <= 0,
               s
            );
         }
      }
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean updateInbound(InboundDTOParam dtoParam) {
      PurchaseOrder order = null;
      if (dtoParam.getPurchaseId() != null) {
         order = this.purchaseOrderService.getById(dtoParam.getPurchaseId());
         Preconditions.checkArgument(order != null, "采购订单不存在");
      }

      Inbound inbound = this.baseMapper.selectById(dtoParam.getId());
      Preconditions.checkArgument(inbound != null, "入库单不存在");
      Preconditions.checkArgument(!ReviewStatusEnum.REVIEWED.getType().equals(inbound.getReviewStatus()), "当前入库单已审核通过,不能修改");
      Preconditions.checkArgument(
         QualityTestingEnum.UN_REVIEWED.getType().equals(inbound.getQualityTestingEnum())
            || QualityTestingEnum.NO.getType().equals(inbound.getQualityTestingEnum()),
         "当前入库单已质检审核, 禁止修改"
      );
      this.printService.updateByInboundId(inbound.getId());
      if (ReviewStatusEnum.RETURNED.getType().equals(inbound.getReviewStatus())) {
         this.saveInbound(dtoParam);
         return true;
      }

      if (order != null) {
         if (LogisticsPayerEnum.DEMAND.getType().equals(order.getLogisticsPayerType())
            && LogisticsTransportTypeEnum.FREIGHT.getType().equals(order.getLogisticsTransportType())) {
            StringBuilder builder = CommonUtil.checkLicensePlate(dtoParam.getLicensePlate());
            inbound.setLicensePlate(builder.toString());
         } else if (StrUtil.isNotBlank(dtoParam.getLicensePlate())) {
            StringBuilder builder = CommonUtil.checkLicensePlate(dtoParam.getLicensePlate());
            inbound.setLicensePlate(builder.toString());
         }

         inbound.setPurchaseId(order.getId());
         inbound.setPurchaseSn(order.getSerialNumber());
      }

      inbound.setUserUpdateTime(LocalDateTime.now());
      inbound.setEditorId(UserUtil.getCurrentUserId());
      inbound.setEditorName(UserUtil.getCurrentName());
      inbound.setShipmentNumber(dtoParam.getShipmentNumber());
      this.updateOPDetail(inbound);
      IdsStatusDTO idsStatusDTO = new IdsStatusDTO();
      if (ObjectUtil.isNotEmpty(inbound.getClassifyIds())) {
         List<InboundDetail> inboundDetails = this.inboundDetailMapper
            .selectList((Wrapper<InboundDetail>)Wrappers.<InboundDetail>lambdaQuery().eq(InboundDetail::getInboundId, inbound.getId()));
         List<Long> classifyIds = inboundDetails.stream().map(InboundDetail::getClassifyId).collect(Collectors.toList());
         idsStatusDTO.setIds(classifyIds);
      } else {
         idsStatusDTO.setIdsStr(inbound.getClassifyIds());
      }

      this.inboundDetailMapper.delete((Wrapper<InboundDetail>)Wrappers.<InboundDetail>lambdaQuery().eq(InboundDetail::getInboundId, inbound.getId()));
      this.classificationService.deleteDataUpdateClass(idsStatusDTO);
      Print print = this.printService
         .getOne(
            (Wrapper<Print>)(Wrappers.<Print>lambdaQuery().eq(Print::getReceiptId, inbound.getId()))
               .eq(Print::getReceiptType, ReceiptTypeEnum.INBOUND.getType())
         );
      if (print != null) {
         this.printDetailMapper.delete((Wrapper<PrintDetail>)Wrappers.<PrintDetail>lambdaQuery().eq(PrintDetail::getPrintId, print.getId()));
         this.printService.removeById(print.getId());
      }

      this.checkInboundDetailParam(inbound, dtoParam, order);
      this.classificationService.updateClassifyUsed(IdsStatusDTO.builder().idsStr(inbound.getClassifyIds()).build());
      this.logisticsOrderService
         .remove(
            (Wrapper<LogisticsOrder>)(Wrappers.<LogisticsOrder>lambdaQuery().eq(LogisticsOrder::getInboundId, inbound.getId()))
               .eq(LogisticsOrder::getTableNameType, TableNameTypeEnum.WMS_INBOUND.getType())
         );
      if (order != null && LogisticsPayerEnum.DEMAND.getType().equals(order.getLogisticsPayerType()) && inbound.getFreight() != null) {
         this.generateLogisticsOrder(dtoParam, inbound, order, ReviewStatusEnum.UN_REVIEWED.getType());
      }

      return this.baseMapper.updateById(inbound) == 1;
   }

   @Override
   public InboundDTO getList(Long id, Boolean b, Boolean qualityTestingBool) {
      Inbound inbound = this.baseMapper.selectById(id);
      Preconditions.checkArgument(inbound != null, "入库单不存在");
      InboundDTO inboundDTO = BeanUtil.copy(inbound, InboundDTO.class);
      if (inbound.getPurchaseId() != null) {
         inboundDTO.setPurchaseOrder(this.purchaseOrderService.selectById(inbound.getPurchaseId()));
         PurchaseOrder order = this.purchaseOrderService.getById(inbound.getPurchaseId());
         LogisticsOrder one = this.logisticsOrderService
            .getOne(
               (Wrapper<LogisticsOrder>)(new LambdaQueryWrapper<LogisticsOrder>().eq(LogisticsOrder::getInboundId, inbound.getId()))
                  .eq(LogisticsOrder::getTableNameType, TableNameTypeEnum.WMS_INBOUND.getType())
            );
         if (one != null) {
            inboundDTO.setLogistics(one);
         }

         inboundDTO.setSupplyType(1);
      } else if (InboundWayEnum.ORDINARY.getType().equals(inbound.getInboundWay())) {
         inboundDTO.setSupplyType(2);
      }

      if (StrUtil.isNotBlank(inbound.getAttachmentIds())) {
         inboundDTO.setAttachments(this.attachmentService.listByIds(inbound.getAttachmentIds()));
      }

      LogisticsOrder logisticsOrder = this.logisticsOrderService
         .getOne(
            (Wrapper<LogisticsOrder>)(Wrappers.<LogisticsOrder>lambdaQuery().eq(LogisticsOrder::getInboundId, inbound.getId()))
               .eq(LogisticsOrder::getTableNameType, TableNameTypeEnum.WMS_INBOUND.getType())
         );
      if (logisticsOrder != null) {
         inboundDTO.setLogisticsOrder(logisticsOrder);
      }

      List<InboundDetail> inboundDetails = this.inboundDetailMapper
         .selectList((Wrapper<InboundDetail>)Wrappers.<InboundDetail>lambdaQuery().eq(InboundDetail::getInboundId, inbound.getId()));
      List<InboundDetailDTO> list = new ArrayList<>();
      if (BasicClassEnum.STRUC_MANUFACTURED.getType().equals(inbound.getBasicClass())
         | BasicClassEnum.ENCL_MANUFACTURED.getType().equals(inbound.getBasicClass())) {
         for (InboundDetail inboundDetail : inboundDetails) {
            if (!qualityTestingBool
               || QualityTestingEnum.ALL_PASS.getType().equals(inboundDetail.getQualityTestingEnum())
               || QualityTestingEnum.NO.getType().equals(inboundDetail.getQualityTestingEnum())) {
               ArtifactDTO artifactDTO = this.artifactService.getInfoById(inboundDetail.getArtifactEnclosureId(), 1);
               InboundDetailDTO dto = BeanUtil.copy(artifactDTO, InboundDetailDTO.class);
               dto.setPurchaseOrderDetailId(inboundDetail.getPurchaseOrderDetailId());
               dto.setQuantity(inboundDetail.getQuantity());
               dto.setBasicClass(inboundDetail.getBasicClass());
               dto.setAmount(inboundDetail.getAmount());
               dto.setUnitPrice(inboundDetail.getUnitPrice());
               dto.setMonomerName(artifactDTO.getMonomer().getName());
               dto.setAreaName(artifactDTO.getArea().getName());
               dto.setQualityTestingEnum(QualityTestingEnum.NO.getType());
               list.add(dto);
            }
         }
      } else {
         list = this.getInboundDetailDTOS(b, inbound, inboundDetails, qualityTestingBool);
      }

      inboundDTO.setList(list);
      return inboundDTO;
   }

   @Override
   public InboundDTO getListV2(Long id, Boolean b) {
      Inbound inbound = this.baseMapper.selectById(id);
      Preconditions.checkArgument(inbound != null, "入库单不存在");
      InboundDTO inboundDTO = BeanUtil.copy(inbound, InboundDTO.class);
      if (inbound.getPurchaseId() != null) {
         inboundDTO.setPurchaseOrder(this.purchaseOrderService.selectByIdPurchaseOrder(inbound.getPurchaseId()));
         LogisticsOrder one = this.logisticsOrderService
            .getOne(
               (Wrapper<LogisticsOrder>)(new LambdaQueryWrapper<LogisticsOrder>().eq(LogisticsOrder::getInboundId, inbound.getId()))
                  .eq(LogisticsOrder::getTableNameType, TableNameTypeEnum.WMS_INBOUND.getType())
            );
         if (one != null) {
            inboundDTO.setLogistics(one);
         }

         inboundDTO.setSupplyType(SupplyTypeEnum.SELF.getType());
         List<Inbound> inbounds = this.baseMapper
            .selectList(
               (Wrapper<Inbound>)(new LambdaQueryWrapper<Inbound>().eq(Inbound::getPurchaseId, inbound.getPurchaseId()))
                  .eq(Inbound::getReviewStatus, ReviewStatusEnum.REVIEWED.getType())
            );
         BigDecimal sumAmount = inbounds.stream().map(Inbound::getAmount).filter(ObjectUtil::isNotEmpty).reduce(BigDecimal.ZERO, BigDecimal::add);
         if (CollectionUtil.isNotEmpty(inbounds)) {
            List<Long> collect1 = inbounds.stream().map(Inbound::getId).collect(Collectors.toList());
            List<Reject> rejects = this.rejectMapper
               .selectList(
                  (Wrapper<Reject>)(new LambdaQueryWrapper<Reject>().in(Reject::getInboundId, collect1))
                     .eq(Reject::getReviewStatus, ReviewStatusEnum.REVIEWED.getType())
               );
            if (CollectionUtil.isNotEmpty(rejects)) {
               BigDecimal sumRejectAmount = rejects.stream().map(Reject::getAmount).filter(ObjectUtil::isNotEmpty).reduce(BigDecimal.ZERO, BigDecimal::add);
               sumAmount = sumAmount.subtract(sumRejectAmount);
            }
         }

         inboundDTO.setSumAmount(sumAmount);
         if (BasicClassEnum.checkIsSteel(inboundDTO.getBasicClass())) {
            BigDecimal sumLoadingWeight = inbounds.stream()
               .map(Inbound::getLoadingWeight)
               .filter(ObjectUtil::isNotEmpty)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            inboundDTO.setSumLoadingWeight(sumLoadingWeight);
         }
      } else if (inbound.getBoolPartyA()) {
         inboundDTO.setSupplyType(SupplyTypeEnum.PARTY_A.getType());
      } else {
         inboundDTO.setSupplyType(SupplyTypeEnum.SELF.getType());
      }

      if (StrUtil.isNotBlank(inbound.getAttachmentIds())) {
         inboundDTO.setAttachments(this.attachmentService.listByIds(inbound.getAttachmentIds()));
      }

      LogisticsOrder logisticsOrder = this.logisticsOrderService
         .getOne(
            (Wrapper<LogisticsOrder>)(Wrappers.<LogisticsOrder>lambdaQuery().eq(LogisticsOrder::getInboundId, inbound.getId()))
               .eq(LogisticsOrder::getTableNameType, TableNameTypeEnum.WMS_INBOUND.getType())
         );
      if (logisticsOrder != null) {
         inboundDTO.setLogisticsOrder(logisticsOrder);
      }

      if (inbound.getMesWorkshopId() != null) {
         MesBuildingWorkshop mesWorkshop = this.mesWorkshopService.getWorkshopById(inbound.getMesWorkshopId());
         inboundDTO.setMesWorkshop(IdAndNameDTO.builder().id(mesWorkshop.getId()).name(mesWorkshop.getName()).build());
      }

      if (inbound.getFreightJson() != null) {
         if (inboundDTO.getLogisticsOrder() == null) {
            inboundDTO.setLogisticsOrder(JSONObject.parseObject(inbound.getFreightJson(), LogisticsOrder.class));
         }

         if (inboundDTO.getLogistics() == null) {
            inboundDTO.setLogistics(JSONObject.parseObject(inbound.getFreightJson(), LogisticsOrder.class));
         }
      }

      List<InboundDetail> inboundDetails = this.inboundDetailMapper
         .selectList((Wrapper<InboundDetail>)Wrappers.<InboundDetail>lambdaQuery().eq(InboundDetail::getInboundId, inbound.getId()));
      List<InboundDetailDTO> list = new ArrayList<>();
      if (BasicClassEnum.STRUC_MANUFACTURED.getType().equals(inbound.getBasicClass())
         | BasicClassEnum.ENCL_MANUFACTURED.getType().equals(inbound.getBasicClass())) {
         for (InboundDetail inboundDetail : inboundDetails) {
            ArtifactDTO artifactDTO = this.artifactService.getInfoById(inboundDetail.getArtifactEnclosureId(), 1);
            InboundDetailDTO dto = BeanUtil.copy(artifactDTO, InboundDetailDTO.class);
            dto.setPurchaseOrderDetailId(inboundDetail.getPurchaseOrderDetailId());
            dto.setQuantity(inboundDetail.getQuantity());
            dto.setBasicClass(inboundDetail.getBasicClass());
            dto.setAmount(inboundDetail.getAmount());
            dto.setUnitPrice(inboundDetail.getUnitPrice());
            dto.setAmountNoFreight(inboundDetail.getAmountNoFreight());
            dto.setUnitPriceNoFreight(inboundDetail.getUnitPriceNoFreight());
            dto.setMonomerName(artifactDTO.getMonomer().getName());
            dto.setAreaName(artifactDTO.getArea().getName());
            dto.setQualityTestingEnum(QualityTestingEnum.NO.getType());
            dto.setSectionSteelSpec(inboundDetail.getSectionSteelSpec());
            dto.setStandardId(inboundDetail.getStandardId());
            dto.setDoNotSectionSteelSpec(inboundDetail.getDoNotSectionSteelSpec());
            list.add(dto);
         }
      } else {
         list = this.getInboundDetailDTOS(b, inbound, inboundDetails, false);
      }

      inboundDTO.setList(list);
      inboundDTO.setEditMoney(false);
      inboundDTO.setEditFreight(false);
      if (inbound.getReviewStatus().equals(ReviewStatusEnum.AUDITING.getType())) {
         new ArrayList();
         List<WmsApproveRecordDetail> var21;
         if (inbound.getBoolPartyA()) {
            var21 = this.wmsApproveRecordService.getCheckDataIdList(FunctionTypeEnum.WMS_PARTY_A_SUPPLY_IN.getType());
         } else {
            var21 = this.wmsApproveRecordService.getCheckDataIdList(FunctionTypeEnum.WMS_SELF_BUYING_IN.getType());
         }

         List<Long> flowIdList = var21.stream().map(WmsApproveRecordDetail::getFlowId).filter(ObjectUtil::isNotEmpty).collect(Collectors.toList());
         List<WmsApproveFlowOperation> wmsApproveFlowOperations = new ArrayList<>();
         if (CollectionUtils.isNotEmpty(flowIdList)) {
            wmsApproveFlowOperations = this.wmsApproveFlowOperationService
               .list((Wrapper<WmsApproveFlowOperation>)new LambdaQueryWrapper<WmsApproveFlowOperation>().in(WmsApproveFlowOperation::getFlowId, flowIdList));
         }

         if (CollectionUtils.isNotEmpty(wmsApproveFlowOperations)) {
            WmsApproveRecordDetail wmsApproveRecordDetail = var21.stream().filter(c -> c.getDataId().equals(inbound.getId())).findAny().orElse(null);
            List<WmsApproveFlowOperation> wmsApproveFlowOperationList = wmsApproveFlowOperations.stream()
               .filter(w -> w.getFlowId().equals(wmsApproveRecordDetail.getFlowId()))
               .collect(Collectors.toList());
            WmsApproveFlowOperation wmsApproveFlowOperation = wmsApproveFlowOperationList.stream()
               .filter(w -> ObjectUtil.isNotEmpty(w.getOperationType()) && w.getOperationType().equals(ApproveFlowOperationEnum.OPERATION_MONEY.getType()))
               .findAny()
               .orElse(null);
            if (ObjectUtil.isNotEmpty(wmsApproveFlowOperation) && wmsApproveFlowOperation.getOperation().equals("1")) {
               inboundDTO.setEditMoney(true);
            }

            WmsApproveFlowOperation wmsApproveFlowOperationFreight = wmsApproveFlowOperationList.stream()
               .filter(w -> ObjectUtil.isNotEmpty(w.getOperationType()) && w.getOperationType().equals(ApproveFlowOperationEnum.FREIGHT_MSG.getType()))
               .findAny()
               .orElse(null);
            if (ObjectUtil.isNotEmpty(wmsApproveFlowOperationFreight) && wmsApproveFlowOperationFreight.getOperation().equals("1")) {
               inboundDTO.setEditFreight(true);
            }
         }
      }

      if (ObjectUtil.isNotEmpty(inbound.getApproveRecordId())) {
         WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService.getById(inbound.getApproveRecordId());
         inboundDTO.setJsonData(wmsApproveRecord.getJsonData());
         WmsApproveRecordFlowDTO approveRecordFlowDTO = this.wmsApproveRecordService.getApproveRecordDTO(inbound.getApproveRecordId());
         inboundDTO.setWmsApproveRecordFlowDTOS(approveRecordFlowDTO);
      }

      return inboundDTO;
   }

   public InboundDTO getInboundDTOById(Long id, Boolean b) {
      Inbound inbound = this.baseMapper.selectById(id);
      Preconditions.checkArgument(inbound != null, "入库单不存在");
      InboundDTO inboundDTO = BeanUtil.copy(inbound, InboundDTO.class);
      if (inbound.getPurchaseId() != null) {
         inboundDTO.setPurchaseOrder(this.purchaseOrderService.selectById(inbound.getPurchaseId()));
         LogisticsOrder one = this.logisticsOrderService
            .getOne(
               (Wrapper<LogisticsOrder>)(new LambdaQueryWrapper<LogisticsOrder>().eq(LogisticsOrder::getInboundId, inbound.getId()))
                  .eq(LogisticsOrder::getTableNameType, TableNameTypeEnum.WMS_INBOUND.getType())
            );
         if (one != null) {
            inboundDTO.setLogistics(one);
         }

         inboundDTO.setSupplyType(1);
      } else {
         inboundDTO.setSupplyType(2);
      }

      if (StrUtil.isNotBlank(inbound.getAttachmentIds())) {
         inboundDTO.setAttachments(this.attachmentService.listByIds(inbound.getAttachmentIds()));
      }

      LogisticsOrder logisticsOrder = this.logisticsOrderService
         .getOne(
            (Wrapper<LogisticsOrder>)(Wrappers.<LogisticsOrder>lambdaQuery().eq(LogisticsOrder::getInboundId, inbound.getId()))
               .eq(LogisticsOrder::getTableNameType, TableNameTypeEnum.WMS_INBOUND.getType())
         );
      if (logisticsOrder != null) {
         inboundDTO.setLogisticsOrder(logisticsOrder);
      }

      List<InboundDetail> inboundDetails = this.inboundDetailMapper
         .selectList((Wrapper<InboundDetail>)Wrappers.<InboundDetail>lambdaQuery().eq(InboundDetail::getInboundId, inbound.getId()));
      List<InboundDetailDTO> list = new ArrayList<>();
      if (BasicClassEnum.STRUC_MANUFACTURED.getType().equals(inbound.getBasicClass())
         | BasicClassEnum.ENCL_MANUFACTURED.getType().equals(inbound.getBasicClass())) {
         for (InboundDetail inboundDetail : inboundDetails) {
            ArtifactDTO artifactDTO = this.artifactService.getInfoById(inboundDetail.getArtifactEnclosureId(), 1);
            InboundDetailDTO dto = BeanUtil.copy(artifactDTO, InboundDetailDTO.class);
            dto.setPurchaseOrderDetailId(inboundDetail.getPurchaseOrderDetailId());
            dto.setQuantity(inboundDetail.getQuantity());
            dto.setBasicClass(inboundDetail.getBasicClass());
            dto.setAmount(inboundDetail.getAmount());
            dto.setUnitPrice(inboundDetail.getUnitPrice());
            dto.setMonomerName(artifactDTO.getMonomer().getName());
            dto.setAreaName(artifactDTO.getArea().getName());
            dto.setQualityTestingEnum(QualityTestingEnum.NO.getType());
            dto.setSectionSteelSpec(inboundDetail.getSectionSteelSpec());
            dto.setStandardId(inboundDetail.getStandardId());
            dto.setDoNotSectionSteelSpec(inboundDetail.getDoNotSectionSteelSpec());
            list.add(dto);
         }
      } else {
         list = this.getInboundDetailDTOS(b, inbound, inboundDetails, false);
      }

      inboundDTO.setList(list);
      return inboundDTO;
   }

   @NotNull
   private List<InboundDetailDTO> getInboundDetailDTOS(Boolean b, Inbound inbound, List<InboundDetail> inboundDetails, Boolean qualityTestingBool) {
      List<InboundDetailDTO> list = new ArrayList<>();
      Map<String, WmsMaterialCodeConfig> materialCodeConfigMaps = this.queryUtil.getMaterialCodeConfigMaps(null);

      for (InboundDetail inboundDetail : inboundDetails) {
         if (!qualityTestingBool
            || QualityTestingEnum.ALL_PASS.getType().equals(inboundDetail.getQualityTestingEnum())
            || QualityTestingEnum.NO.getType().equals(inboundDetail.getQualityTestingEnum())) {
            InboundDetailDTO inboundDetailDTO = BeanUtil.copy(inboundDetail, InboundDetailDTO.class);
            List<WmsAdjustDetail> list1 = this.wmsAdjustDetailService
               .list(
                  (Wrapper<WmsAdjustDetail>)(new LambdaQueryWrapper<WmsAdjustDetail>().eq(WmsAdjustDetail::getInboundDetailId, inboundDetail.getId()))
                     .orderByDesc(BaseEntity::getCreateTime)
               );
            List<AdjustDetailsDTO> adjustDetailsDTOS = cn.hutool.core.bean.BeanUtil.copyToList(list1, AdjustDetailsDTO.class);
            inboundDetailDTO.setAdjustDetailList(adjustDetailsDTOS);
            inboundDetailDTO.setNationalStandard(inboundDetail.getStandardName());
            inboundDetailDTO.setClassifyId(inboundDetail.getClassifyId());
            inboundDetailDTO.setUnitPriceExcludingVAT(inboundDetail.getUnitPriceExcludingVat());
            inboundDetailDTO.setMete(inboundDetail.getMete());
            inboundDetailDTO.setAmountExcludingVAT(inboundDetail.getAmountExcludingVat());
            inboundDetailDTO.setInputVAT(inboundDetail.getInputVat());
            inboundDetailDTO.setAmountExcludingVATNoFreight(inboundDetail.getAmountExcludingVatNoFreight());
            inboundDetailDTO.setUnitPriceExcludingVATNoFreight(inboundDetail.getUnitPriceExcludingVatNoFreight());
            inboundDetailDTO.setInputVATNoFreight(inboundDetail.getInputVatNoFreight());
            inboundDetailDTO.setUnitPriceNoFreight(inboundDetail.getUnitPriceNoFreight());
            inboundDetailDTO.setAmountNoFreight(inboundDetail.getAmountNoFreight());
            String s1 = this.queryUtil
               .buildCompositeKey(inboundDetailDTO.getClassifyId(), inboundDetailDTO.getSpecification(), inboundDetailDTO.getThickness());
            WmsMaterialCodeConfig wmsMaterialCodeConfig = materialCodeConfigMaps.get(s1);
            inboundDetailDTO.setMaterialSnNew(ObjectUtil.isNotEmpty(wmsMaterialCodeConfig) ? wmsMaterialCodeConfig.getMaterialSnNew() : null);
            if (BasicClassEnum.COLOR_ROLL.getType().equals(inboundDetail.getBasicClass())) {
               inboundDetailDTO.setLength(inboundDetail.getQuantity());
            }

            if (inboundDetail.getProjectId() != null) {
               inboundDetailDTO.setProject(this.contractProjectService.getSimpleById(inboundDetail.getProjectId()));
            }

            if (inboundDetail.getWarehouseId() != null) {
               Warehouse warehouse = this.warehouseService.getById(inboundDetail.getWarehouseId());
               inboundDetailDTO.setWarehouse(BriefIdAndNameDTO.builder().id(warehouse.getId()).name(warehouse.getName()).build());
            }

            if (inboundDetail.getWorkshopId() != null) {
               Workshop workshop = this.workshopService.getById(inboundDetail.getWorkshopId());
               inboundDetailDTO.setWorkshop(BriefIdAndNameDTO.builder().id(workshop.getId()).name(workshop.getName()).build());
            }

            if (inboundDetail.getMonomerId() != null) {
               PlanMonomer byId = this.monomerService.getById(inboundDetail.getMonomerId());
               inboundDetailDTO.setMonomerName(ObjectUtil.isNotEmpty(byId) ? byId.getName() : null);
            }

            if (inboundDetail.getAreaId() != null) {
               PlanArea byId = this.planAreaService.getById(inboundDetail.getAreaId());
               inboundDetailDTO.setAreaName(ObjectUtil.isNotEmpty(byId) ? byId.getName() : null);
            }

            if (b) {
               List<Reject> rejects = this.rejectMapper
                  .selectList(
                     (Wrapper<Reject>)(Wrappers.<Reject>lambdaQuery().eq(Reject::getInboundId, inbound.getId()))
                        .ne(Reject::getReviewStatus, ReviewStatusEnum.RETURNED.getType())
                  );
               List<RejectMaterialDTO> l = new ArrayList<>();

               for (Reject reject : rejects) {
                  for (RejectDetail detail : this.rejectDetailMapper
                     .selectList(
                        (Wrapper<RejectDetail>)(Wrappers.<RejectDetail>lambdaQuery().eq(RejectDetail::getRejectId, reject.getId()))
                           .eq(RejectDetail::getInboundDetailId, inboundDetail.getId())
                     )) {
                     RejectMaterialDTO dto = BeanUtil.copy(detail, RejectMaterialDTO.class);
                     dto.setCreateTime(reject.getCreateTime());
                     dto.setReviewStatus(reject.getReviewStatus());
                     MaterialInventoryDTO materialInventoryDTO = BeanUtil.copy(detail, MaterialInventoryDTO.class);
                     Warehouse wa = this.warehouseService.getById(detail.getWarehouseId());
                     Workshop workshop = this.workshopService.getById(detail.getWorkshopId());
                     if (detail.getProjectId() != null) {
                        materialInventoryDTO.setProject(this.contractProjectService.getSimpleById(detail.getProjectId()));
                     }

                     materialInventoryDTO.setNationalStandard(detail.getStandardName());
                     materialInventoryDTO.setWarehouse(BriefIdAndNameDTO.builder().id(wa.getId()).name(wa.getName()).build());
                     materialInventoryDTO.setWorkshop(BriefIdAndNameDTO.builder().id(workshop.getId()).name(workshop.getName()).build());
                     dto.setMaterial(materialInventoryDTO);
                     l.add(dto);
                  }
               }

               inboundDetailDTO.setRejectList(l);
            }

            list.add(inboundDetailDTO);
         }
      }

      return list;
   }

   @Override
   public List<Long> getIds(QueryInboundDTOParam queryInboundDTOParam) {
      queryInboundDTOParam.setReviewStatus(ReviewStatusEnum.UN_REVIEWED.getType());
      queryInboundDTOParam.setQualityTestingEnum(
         QualityTestingEnum.NO.getType()
            | QualityTestingEnum.ALL_PASS.getType()
            | QualityTestingEnum.ALL_RETURN.getType()
            | QualityTestingEnum.PART_PASS.getType()
      );
      return this.baseMapper.listInfo(queryInboundDTOParam).stream().map(Inbound::getId).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean returned(Map<String, Object> map) {
      Inbound inbound = this.baseMapper.selectById((Integer)map.get("id"));
      Preconditions.checkArgument(inbound != null, "入库单不存在");
      inbound.setReviewStatus(ReviewStatusEnum.RETURNED.getType());
      inbound.setEditorId(UserUtil.getCurrentUserId());
      inbound.setEditorName(UserUtil.getCurrentName());
      inbound.setReviewTime(LocalDateTime.now());
      inbound.setUserUpdateTime(LocalDateTime.now());
      inbound.setReviewerId(UserUtil.getCurrentUserId());
      inbound.setReviewerName(UserUtil.getCurrentName());
      inbound.setApprovalComments((String)map.get("approvalComments"));
      inbound.setEditable(true);
      this.printService.updateByInboundId(inbound.getId());
      this.updateOPDetail(inbound);
      if (inbound.getOriginalId() != null) {
         this.baseMapper.updateEditable(inbound.getOriginalId(), 1);
      }

      LogisticsOrder logisticsOrder = this.logisticsOrderService
         .getOne(
            (Wrapper<LogisticsOrder>)(Wrappers.<LogisticsOrder>lambdaQuery().eq(LogisticsOrder::getInboundId, inbound.getId()))
               .eq(LogisticsOrder::getTableNameType, TableNameTypeEnum.WMS_INBOUND.getType())
         );
      if (logisticsOrder != null) {
         logisticsOrder.setInboundReviewStatus(ReviewStatusEnum.RETURNED.getType());
         logisticsOrder.setUserUpdateTime(LocalDateTime.now());
         this.logisticsOrderService.updateById(logisticsOrder);
      }

      return this.baseMapper.updateById(inbound) == 1;
   }

   @Override
   public Boolean returned(APPInboundPassDTOParam request) {
      Inbound inbound = this.baseMapper.selectById(request.getId());
      Preconditions.checkArgument(inbound != null, "入库单不存在");
      inbound.setReviewStatus(ReviewStatusEnum.RETURNED.getType());
      inbound.setEditorId(UserUtil.getCurrentUserId());
      inbound.setEditorName(UserUtil.getCurrentName());
      inbound.setReviewTime(LocalDateTime.now());
      inbound.setUserUpdateTime(LocalDateTime.now());
      inbound.setReviewerId(UserUtil.getCurrentUserId());
      inbound.setReviewerName(UserUtil.getCurrentName());
      return this.baseMapper.updateById(inbound) == 1;
   }

   public Boolean returnedV2(InboundDTOParam inboundDTOParam, String opinion) {
      Inbound inbound = this.baseMapper.selectById(inboundDTOParam.getId());
      Preconditions.checkArgument(inbound != null, "入库单不存在");
      inbound.setReviewStatus(ReviewStatusEnum.RETURNED.getType());
      inbound.setEditorId(UserUtil.getCurrentUserId());
      inbound.setEditorName(UserUtil.getCurrentName());
      inbound.setReviewTime(LocalDateTime.now());
      inbound.setUserUpdateTime(LocalDateTime.now());
      inbound.setReviewerId(UserUtil.getCurrentUserId());
      inbound.setReviewerName(UserUtil.getCurrentName());
      inbound.setApprovalComments(opinion);
      inbound.setEditable(true);
      this.printService.updateByInboundId(inbound.getId());
      this.updateOPDetail(inbound);
      if (inbound.getOriginalId() != null) {
         this.baseMapper.updateEditable(inbound.getOriginalId(), 1);
      }

      LogisticsOrder logisticsOrder = this.logisticsOrderService
         .getOne(
            (Wrapper<LogisticsOrder>)(Wrappers.<LogisticsOrder>lambdaQuery().eq(LogisticsOrder::getInboundId, inbound.getId()))
               .eq(LogisticsOrder::getTableNameType, TableNameTypeEnum.WMS_INBOUND.getType())
         );
      if (logisticsOrder != null) {
         logisticsOrder.setInboundReviewStatus(ReviewStatusEnum.RETURNED.getType());
         logisticsOrder.setUserUpdateTime(LocalDateTime.now());
         this.logisticsOrderService.updateById(logisticsOrder);
      }

      return this.baseMapper.updateById(inbound) == 1;
   }

   private void updateOPDetail(Inbound inbound) {
      if (inbound.getPurchaseId() != null) {
         for (InboundDetail detail : this.inboundDetailMapper
            .selectList((Wrapper<InboundDetail>)Wrappers.<InboundDetail>lambdaQuery().eq(InboundDetail::getInboundId, inbound.getId()))) {
            PurchaseOrderDetail orderDetail = this.poDetailService.getById(detail.getPurchaseOrderDetailId());
            if (orderDetail != null) {
               if (detail.getQuantity() != null) {
                  orderDetail.setInboundQuantity(orderDetail.getInboundQuantity().subtract(detail.getQuantity()));
               }

               if (detail.getMete() != null) {
                  orderDetail.setInboundMete(orderDetail.getInboundMete().subtract(detail.getMete()));
               }

               this.poDetailService.updateById(orderDetail);
            }
         }
      }
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean passed(InboundDTOParam request) {
      Inbound inbound = this.baseMapper.selectById(request.getId());
      PurchaseOrder order = null;
      if (inbound.getPurchaseId() != null) {
         order = this.purchaseOrderService.getById(inbound.getPurchaseId());
         Preconditions.checkArgument(order.getPurchaseStatus() != 2, "订单[" + order.getSerialNumber() + "]已完成采购.");
      }

      Preconditions.checkArgument(!QualityTestingEnum.UN_REVIEWED.getType().equals(inbound.getQualityTestingEnum()), "入库失败，入库单存在需质检物料");
      inbound.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
      inbound.setReviewTime(LocalDateTime.now());
      inbound.setEditable(false);
      inbound.setApprovalComments(request.getApprovalComments());
      BigDecimal amount = BigDecimal.ZERO;
      BigDecimal amountExcludingVAT = BigDecimal.ZERO;
      BigDecimal loadingWeight = BigDecimal.ZERO;
      if (BasicClassEnum.STRUC_MANUFACTURED.getType().equals(inbound.getBasicClass())
         | BasicClassEnum.ENCL_MANUFACTURED.getType().equals(inbound.getBasicClass())) {
         List<InboundDetail> inboundDetails = this.inboundDetailMapper
            .selectList((Wrapper<InboundDetail>)Wrappers.<InboundDetail>lambdaQuery().eq(InboundDetail::getInboundId, inbound.getId()));
         this.mesSPABiz
            .assistArtifactReport(
               inboundDetails.stream()
                  .map(
                     i -> ExternalArtifactDTO.builder()
                        .productId(i.getArtifactEnclosureId())
                        .quantity(i.getQuantity().intValue())
                        .warehousingType(i.getWorkshopId() != null ? 0 : 1)
                        .workShopId(i.getWorkshopId())
                        .build()
                  )
                  .collect(Collectors.toList())
            );
         amount = inboundDetails.stream().map(InboundDetail::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
         amountExcludingVAT = inboundDetails.stream().map(InboundDetail::getAmountExcludingVat).reduce(BigDecimal.ZERO, BigDecimal::add);
      } else {
         Outbound outbound = null;

         for (InboundDetailDTOParam dtoParam : request.getList()) {
            InboundDetail inboundDetail = this.inboundDetailMapper.selectById(dtoParam.getId());
            Preconditions.checkArgument(inboundDetail != null, "入库详情不存在,请核对后操作");
            if (QualityTestingEnum.ALL_PASS.getType().equals(inboundDetail.getQualityTestingEnum())
               || QualityTestingEnum.NO.getType().equals(inboundDetail.getQualityTestingEnum())) {
               loadingWeight = inboundDetail.getMete().add(loadingWeight);
               inboundDetail.setRejectStatus(RejectEnum.NO_REJECT.getType());
               inboundDetail.setRejectMete(BigDecimal.ZERO);
               inboundDetail.setRejectQuantity(BigDecimal.ZERO);
               BasicConfig basicInbound = this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "基础入库配置"));
               BasicInbound basicInbound1 = JSON.parseObject(basicInbound.getValue(), BasicInbound.class);
               if (basicInbound1.getAmountFillWay() == 2 && order != null) {
                  inboundDetail.setAmount(dtoParam.getAmount());
                  inboundDetail.setUnitPrice(dtoParam.getUnitPrice());
                  inboundDetail.setAmount(dtoParam.getAmount());
                  if (InvoiceTypeEnum.SPECIAL.getType().equals(order.getInvoiceType())) {
                     BigDecimal value = order.getTaxRate().divide(HUNDRED).add(BigDecimal.ONE);
                     if (inboundDetail.getAmount() != null) {
                        inboundDetail.setAmountExcludingVat(inboundDetail.getAmount().divide(value, 2, RoundingMode.HALF_UP));
                        inboundDetail.setUnitPriceExcludingVat(inboundDetail.getAmountExcludingVat().divide(inboundDetail.getMete(), 12, RoundingMode.HALF_UP));
                        inboundDetail.setInputVat(inboundDetail.getAmount().subtract(inboundDetail.getAmountExcludingVat()));
                     }
                  } else {
                     inboundDetail.setAmountExcludingVat(inboundDetail.getAmount());
                     inboundDetail.setUnitPriceExcludingVat(inboundDetail.getUnitPrice());
                  }
               }

               if (inboundDetail.getBoolNestSurplus()) {
                  inboundDetail.setUnitPrice(dtoParam.getUnitPrice());
                  inboundDetail.setAmount(dtoParam.getUnitPrice().multiply(inboundDetail.getMete()).setScale(this.amountAccuracy, RoundingMode.HALF_UP));
                  inboundDetail.setTaxRate(BigDecimal.valueOf(13L));
                  inboundDetail.setInvoiceType(1);
                  BigDecimal value = inboundDetail.getTaxRate().divide(HUNDRED).add(BigDecimal.ONE);
                  if (inboundDetail.getAmount() != null) {
                     inboundDetail.setAmountExcludingVat(inboundDetail.getAmount().divide(value, 2, RoundingMode.HALF_UP));
                     inboundDetail.setUnitPriceExcludingVat(inboundDetail.getAmountExcludingVat().divide(inboundDetail.getMete(), 12, RoundingMode.HALF_UP));
                     inboundDetail.setInputVat(inboundDetail.getAmount().subtract(inboundDetail.getAmountExcludingVat()));
                  }

                  inboundDetail.setAmountNoFreight(inboundDetail.getAmount());
                  inboundDetail.setAmountExcludingVatNoFreight(inboundDetail.getAmountExcludingVat());
                  inboundDetail.setUnitPriceNoFreight(inboundDetail.getUnitPrice());
                  inboundDetail.setUnitPriceExcludingVatNoFreight(inboundDetail.getUnitPriceExcludingVat());
                  inboundDetail.setInputVatNoFreight(inboundDetail.getInputVat());
               }

               if (StrUtil.isNotBlank(dtoParam.getRemark())) {
                  Preconditions.checkArgument(dtoParam.getRemark().length() <= 200, "备注字数超出限制.");
                  inboundDetail.setRemark(dtoParam.getRemark());
               }

               Measure measure = this.measureMapper
                  .selectOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, inboundDetail.getClassifyId()));
               WasteConfig scrapDefinitionConf = this.basicConfigService.getSteelScrapDefinitionConf();
               boolean isScrap = false;
               if (BasicClassEnum.STEEL_PLATE.getType().equals(inboundDetail.getBasicClass())) {
                  isScrap = inboundDetail.getLength().compareTo(scrapDefinitionConf.getSteelPlateShortestSideMinLength()) <= 0
                     || inboundDetail.getWidth().compareTo(scrapDefinitionConf.getSteelPlateShortestSideMinLength()) <= 0;
               }

               if (BasicClassEnum.SECTION_STEEL.getType().equals(inboundDetail.getBasicClass())) {
                  isScrap = inboundDetail.getLength().compareTo(scrapDefinitionConf.getSectionSteelMinLength()) <= 0;
               }

               if (BasicClassEnum.COLOR_ROLL.getType().equals(inboundDetail.getBasicClass())) {
                  isScrap = inboundDetail.getQuantity().compareTo(scrapDefinitionConf.getSteelCoilMinLength()) <= 0;
               }

               if (isScrap) {
                  Scrap scrap = BeanUtil.copy(inboundDetail, Scrap.class, "createTime");
                  scrap.setWarehouseType(inboundDetail.getProjectId() != null ? 2 : 1);
                  scrap.setAmount(inboundDetail.getAmount());
                  scrap.setAmountExcludingVat(inboundDetail.getAmountExcludingVat());
                  scrap.setAmountNoFreight(inboundDetail.getAmountNoFreight());
                  scrap.setAmountExcludingVatNoFreight(inboundDetail.getAmountExcludingVatNoFreight());
                  scrap.setCreateTime(LocalDateTime.now());
                  this.scrapMapper.insert(scrap);
               } else {
                  MaterialInventory materialInventory = null;
                  if (!BasicClassEnum.COLOR_ROLL.getType().equals(dtoParam.getBasicClass()) || !inboundDetail.getBoolNestSurplus()) {
                     materialInventory = this.materialInventoryService.getByInboundDetail(inboundDetail);
                  }

                  MaterialInventory newMaterialInventory = this.setMaterialInventory(dtoParam, inboundDetail, materialInventory);
                  newMaterialInventory.setUseStatus(false);
                  if (inboundDetail.getBoolNestSurplus()) {
                     newMaterialInventory.setMaterialIsWhole(2);
                  }

                  if (materialInventory != null) {
                     this.materialInventoryService.updateById(newMaterialInventory);
                  } else {
                     this.materialInventoryService.save(newMaterialInventory);
                  }

                  this.wmsUtil
                     .setInventoryUse(
                        newMaterialInventory,
                        inboundDetail.getQuantity(),
                        inboundDetail.getMete(),
                        ReceiptTypeEnum.INBOUND,
                        inbound.getId(),
                        inbound.getSerialNumber(),
                        1,
                        true
                     );
                  this.weightedAveragePriceService
                     .createMonthWAP(inboundDetail, newMaterialInventory, inbound.getId(), inbound.getSerialNumber(), ReceiptTypeEnum.INBOUND.getType());
                  this.warningService.updateStatus(newMaterialInventory, 1);
               }

               amount = amount.add(inboundDetail.getAmount());
               amountExcludingVAT = amountExcludingVAT.add(inboundDetail.getAmountExcludingVat());
               inboundDetail.setInboundTime(LocalDateTime.now());
               this.inboundDetailMapper.updateById(inboundDetail);
               this.applyPurchaseService.updateInboundMete(inboundDetail.getApplyPurchaseId(), inboundDetail.getMete());
            }
         }
      }

      inbound.setAmount(amount);
      inbound.setAmountExcludingVat(amountExcludingVAT);
      Print print = this.printService
         .getOne(
            (Wrapper<Print>)((Wrappers.<Print>lambdaQuery().eq(Print::getReceiptId, inbound.getId()))
                  .eq(Print::getReceiptType, ReceiptTypeEnum.INBOUND.getType()))
               .eq(Print::getBoolPrinted, false)
         );
      if (print != null) {
         if (ReviewStatusEnum.REVIEWED.getType().equals(inbound.getReviewStatus())) {
            print.setReceiptReviewer(inbound.getReviewerName());
            print.setReceiptReviewTime(inbound.getReviewTime());
            this.printService.updateById(print);
         } else {
            this.printService.removeById(print.getId());
            this.printDetailMapper.delete((Wrapper<PrintDetail>)Wrappers.<PrintDetail>lambdaQuery().eq(PrintDetail::getPrintId, print.getId()));
         }
      }

      LogisticsOrder logisticsOrder = this.logisticsOrderService
         .getOne(
            (Wrapper<LogisticsOrder>)(Wrappers.<LogisticsOrder>lambdaQuery().eq(LogisticsOrder::getInboundId, inbound.getId()))
               .eq(LogisticsOrder::getTableNameType, TableNameTypeEnum.WMS_INBOUND.getType())
         );
      if (logisticsOrder != null) {
         LogisticsOrder logistics = request.getLogistics();
         logisticsOrder.setInboundReviewStatus(ReviewStatusEnum.REVIEWED.getType());
         logisticsOrder.setUserUpdateTime(LocalDateTime.now());
         logisticsOrder.setSupplierId(logistics.getSupplierId());
         logisticsOrder.setFreight(logistics.getFreight());
         logisticsOrder.setFreightWeight(logistics.getFreightWeight());
         Supplier byId = this.supplierService.getById(logistics.getSupplierId());
         logisticsOrder.setSupplierName(byId.getName());
         this.logisticsOrderService.updateById(logisticsOrder);
      }

      return this.baseMapper.updateById(inbound) == 1;
   }

   @Override
   public List<InboundAmountDetailDTO> getDetails(Long purchaseOrderId) {
      return this.inboundDetailMapper.getListByPOId(purchaseOrderId);
   }

   @Override
   public Map<String, BigDecimal> getAmount(Long purchaseOrderId) {
      List<InboundAmountDetailDTO> list = this.inboundDetailMapper.getListByPOId(purchaseOrderId);
      BigDecimal rejectAmount = BigDecimal.ZERO;
      BigDecimal excludingAmount = BigDecimal.ZERO;

      for (InboundAmountDetailDTO dto : list) {
         for (Reject reject : this.rejectMapper
            .selectList(
               (Wrapper<Reject>)(Wrappers.<Reject>lambdaQuery().eq(Reject::getInboundId, dto.getInboundId()))
                  .eq(Reject::getReviewStatus, ReviewStatusEnum.REVIEWED.getType())
            )) {
            rejectAmount = rejectAmount.add(reject.getAmount());
            excludingAmount = excludingAmount.add(reject.getAmountExcludingVat());
         }
      }

      Map<String, BigDecimal> amount = this.inboundDetailMapper.getAmount(purchaseOrderId);
      amount.put("amount", amount.get("amount").subtract(rejectAmount));
      amount.put("amountExcludingVat", amount.get("amountExcludingVat").subtract(excludingAmount));
      return amount;
   }

   @NotNull
   private MaterialInventory setMaterialInventory(InboundDetailDTOParam dtoParam, InboundDetail inboundDetail, MaterialInventory materialInventory) {
      if (materialInventory == null) {
         MaterialInventory mi = BeanUtil.copy(inboundDetail, MaterialInventory.class, "createTime");
         if (mi.getProjectId() != null) {
            mi.setWarehouseType(2);
         } else {
            mi.setWarehouseType(1);
         }

         mi.setSerialNumber(inboundDetail.getMaterialSn());
         mi.setMaterialIsWhole(MaterialIsWholeEnum.WHOLE.getType());
         mi.setInventoryStartTime(LocalDateTime.now());
         if (BasicClassEnum.SECTION_STEEL.getType().equals(mi.getBasicClass())) {
            String[] split = mi.getSpecification().split(" \\* ");
            if (split.length > 1 && StrUtil.isNotBlank(split[1])) {
               String spec = this.specificationService.getJoinSpec(inboundDetail.getClassifyId(), split[1]);
               if (StrUtil.isNotBlank(spec)) {
                  mi.setWeightedAverageSpec(split[0] + "*" + spec);
               } else {
                  mi.setWeightedAverageSpec(split[0]);
               }
            } else {
               mi.setWeightedAverageSpec(split[0]);
            }
         } else if (StrUtil.isNotBlank(inboundDetail.getSpecification())) {
            String spec = this.specificationService.getJoinSpec(inboundDetail.getClassifyId(), inboundDetail.getSpecification());
            mi.setWeightedAverageSpec(spec);
         }

         return mi;
      } else {
         if (dtoParam.getQuantity() != null) {
            materialInventory.setQuantity(materialInventory.getQuantity().add(dtoParam.getQuantity()));
         }

         materialInventory.setMete(materialInventory.getMete().add(inboundDetail.getMete()));
         materialInventory.setInventoryEndTime(LocalDateTime.now());
         return materialInventory;
      }
   }

   @NotNull
   private MaterialInventory setMaterialInventoryV2(InboundDetail inboundDetail, MaterialInventory materialInventory) {
      if (materialInventory == null) {
         MaterialInventory mi = BeanUtil.copy(inboundDetail, MaterialInventory.class, "createTime");
         if (mi.getProjectId() != null) {
            mi.setWarehouseType(2);
         } else {
            mi.setWarehouseType(1);
         }

         mi.setSerialNumber(inboundDetail.getMaterialSn());
         mi.setMaterialIsWhole(inboundDetail.getMaterialIsWhole());
         mi.setInventoryStartTime(LocalDateTime.now());
         if (BasicClassEnum.SECTION_STEEL.getType().equals(mi.getBasicClass())) {
            String[] split = mi.getSpecification().split(" \\* ");
            if (split.length > 1 && StrUtil.isNotBlank(split[1])) {
               String spec = this.specificationService.getJoinSpec(inboundDetail.getClassifyId(), inboundDetail.getDoNotSectionSteelSpec());
               if (StrUtil.isNotBlank(spec)) {
                  mi.setWeightedAverageSpec(split[0] + "*" + spec);
               } else {
                  mi.setWeightedAverageSpec(split[0]);
               }
            } else {
               mi.setWeightedAverageSpec(split[0]);
            }
         } else if (StrUtil.isNotBlank(inboundDetail.getSpecification())) {
            String spec = this.specificationService.getJoinSpec(inboundDetail.getClassifyId(), inboundDetail.getSpecification());
            mi.setWeightedAverageSpec(spec);
         }

         return mi;
      } else {
         if (inboundDetail.getQuantity() != null) {
            materialInventory.setQuantity(materialInventory.getQuantity().add(inboundDetail.getQuantity()));
         }

         materialInventory.setMete(materialInventory.getMete().add(inboundDetail.getMete()));
         materialInventory.setInventoryEndTime(LocalDateTime.now());
         return materialInventory;
      }
   }

   private void checkAmount(PurchaseOrder order, InboundDetailDTOParam dtoParam, InboundDetail inboundDetail) {
      if (order != null) {
         Preconditions.checkArgument(dtoParam.getAmount() != null && dtoParam.getAmount().compareTo(BigDecimal.ZERO) >= 0, "非甲供订单,请填写金额");
         inboundDetail.setAmount(dtoParam.getAmount());
         BigDecimal unitPrice = dtoParam.getAmount().divide(dtoParam.getMete(), 12, 4);
         inboundDetail.setUnitPrice(unitPrice);
         if (InvoiceTypeEnum.SPECIAL.getType().equals(order.getInvoiceType())) {
            BigDecimal value = order.getTaxRate().divide(HUNDRED).add(BigDecimal.ONE);
            inboundDetail.setAmountExcludingVat(dtoParam.getAmount().divide(value, this.amountAccuracy, 4));
            inboundDetail.setUnitPriceExcludingVat(inboundDetail.getAmountExcludingVat().divide(dtoParam.getMete(), 12, 4));
            inboundDetail.setInputVat(inboundDetail.getAmount().subtract(inboundDetail.getAmountExcludingVat()));
         } else {
            inboundDetail.setAmountExcludingVat(dtoParam.getAmount());
            inboundDetail.setUnitPriceExcludingVat(unitPrice);
         }
      } else {
         inboundDetail.setAmount(BigDecimal.ZERO);
         inboundDetail.setAmountExcludingVat(BigDecimal.ZERO);
         inboundDetail.setUnitPriceExcludingVat(BigDecimal.ZERO);
         inboundDetail.setUnitPrice(BigDecimal.ZERO);
      }
   }

   private void checkInfo(InboundDetailDTOParam param) {
      Measure measure = this.measureMapper.selectOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, param.getClassifyId()));
      BigDecimal zero = BigDecimal.ZERO;
      if (BasicClassEnum.STEEL_PLATE.getType().equals(param.getBasicClass())) {
         Preconditions.checkArgument(param.getMete() != null && param.getMete().compareTo(zero) > 0, "钢板重量不能为空");
         Preconditions.checkArgument(param.getLength() != null && param.getLength().compareTo(zero) > 0, "钢板长度不能为空");
         Preconditions.checkArgument(param.getThickness() != null && param.getThickness().compareTo(zero) > 0, "钢板厚度不能为空");
         Preconditions.checkArgument(param.getWidth() != null && param.getWidth().compareTo(zero) > 0, "钢板宽度不能为空");
      } else if (BasicClassEnum.SECTION_STEEL.getType().equals(param.getBasicClass())) {
         Preconditions.checkArgument(StrUtil.isNotBlank(param.getSpecification()), "型材规格不能为空");
         Preconditions.checkArgument(param.getLength() != null && param.getLength().compareTo(zero) > 0, "型材定尺长度不能为空");
         Preconditions.checkArgument(param.getQuantity() != null, "型材数量不能为空");
         Preconditions.checkArgument(param.getWeight() != null && param.getWeight().compareTo(zero) > 0, "型材重量不能为空");
      } else if (BasicClassEnum.COLOR_ROLL.getType().equals(param.getBasicClass())) {
         Preconditions.checkArgument(param.getWidth() != null && param.getWidth().compareTo(zero) > 0, "钢卷宽度不能为空，且最小值为0.001mm");
         Preconditions.checkArgument(param.getThickness() != null && param.getThickness().compareTo(zero) > 0, "钢卷厚度不能为空，且最小值为0.001mm");
         Preconditions.checkArgument(param.getLength() != null && param.getLength().compareTo(zero) > 0, "钢卷总重不能为空");
      } else if (BasicClassEnum.GENERAL_MATERIAL.getType().equals(param.getBasicClass())) {
         Preconditions.checkArgument(param.getMete() != null, "请输入辅材核算量");
      }
   }

   private String generateStorageListNo(Integer maxDayNumber) {
      StringBuilder storageListNo = new StringBuilder();
      storageListNo.append(LocalDate.now().toString().replace("-", "/").substring(2)).append("/R-");
      if (maxDayNumber < 10) {
         storageListNo.append("00").append(maxDayNumber);
      } else if (maxDayNumber < 100) {
         storageListNo.append("0").append(maxDayNumber);
      } else {
         if (maxDayNumber >= 1000) {
            throw new RuntimeException("保存失败，当日入库清单数量超出限制");
         }

         storageListNo.append(maxDayNumber);
      }

      return storageListNo.toString();
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean deleteByIds(List<Long> ids) {
      for (Long id : ids) {
         Inbound inbound = this.baseMapper.selectById(id);
         Preconditions.checkArgument(inbound != null, "删除失败,入库单不存在");
         Preconditions.checkArgument(ReviewStatusEnum.UN_REVIEWED.getType().equals(inbound.getReviewStatus()), "删除失败,入库单已审核.");
         IdsStatusDTO idsStatusDTO = new IdsStatusDTO();
         if (ObjectUtil.isNotEmpty(inbound.getClassifyIds())) {
            List<InboundDetail> inboundDetails = this.inboundDetailMapper
               .selectList((Wrapper<InboundDetail>)Wrappers.<InboundDetail>lambdaQuery().eq(InboundDetail::getInboundId, inbound.getId()));
            List<Long> classifyIds = inboundDetails.stream().map(InboundDetail::getClassifyId).collect(Collectors.toList());
            idsStatusDTO.setIds(classifyIds);
         } else {
            idsStatusDTO.setIdsStr(inbound.getClassifyIds());
         }

         this.baseMapper.deleteById(id);
         this.inboundDetailMapper.delete((Wrapper<InboundDetail>)Wrappers.<InboundDetail>lambdaQuery().eq(InboundDetail::getInboundId, id));
         this.classificationService.deleteDataUpdateClass(idsStatusDTO);
         this.printService.updateByInboundId(id);
      }

      return true;
   }

   @Override
   public void updateRejectStatus(Long inboundId) {
      Inbound inbound = this.baseMapper.selectById(inboundId);
      inbound.setRejectStatus(this.inboundDetailMapper.getRejectStatus(inboundId));
      this.baseMapper.updateById(inbound);
   }

   private void generateLogisticsOrder(InboundDTOParam dtoParam, Inbound inbound, PurchaseOrder order, Integer inboundReviewStatus) {
      Supplier byId = this.supplierService.getById(dtoParam.getLogistics().getSupplierId());
      LogisticsOrder logistics = LogisticsOrder.builder()
         .purchaseId(order.getId())
         .invoiceType(dtoParam.getLogistics().getInvoiceType())
         .basicClass(inbound.getBasicClass())
         .purchaseType(order.getPurchaseType())
         .inboundId(inbound.getId())
         .inboundSn(inbound.getSerialNumber())
         .purchaseSn(order.getSerialNumber())
         .licensePlate(inbound.getLicensePlate())
         .shipmentNumber(dtoParam.getShipmentNumber())
         .projectIds(inbound.getProjectIds())
         .loadingWeight(inbound.getLoadingWeight())
         .freight(inbound.getFreight())
         .supplierName(byId.getName())
         .supplierId(dtoParam.getLogistics().getSupplierId())
         .applicantId(UserUtil.getCurrentUserId())
         .applicantName(UserUtil.getCurrentName())
         .userUpdateTime(LocalDateTime.now())
         .inboundReviewStatus(inboundReviewStatus)
         .logisticsPayerType(order.getLogisticsPayerType())
         .logisticsTransportType(order.getLogisticsTransportType())
         .freightWeight(dtoParam.getLogistics().getFreightWeight())
         .tableNameType(TableNameTypeEnum.WMS_INBOUND.getType())
         .build();
      Integer count = this.logisticsOrderService.getCreateCount();
      NumberConfig numberConfig = this.numberConfigService
         .getOne((Wrapper<NumberConfig>)Wrappers.<NumberConfig>lambdaQuery().eq(NumberConfig::getType, NumberTypeEnum.LOGISTICS_ORDER.getType()));
      String code = CommonUtil.generateSerialNumber(numberConfig.getCode(), LocalDate.now(), count);
      logistics.setSerialNumber(code);
      if (order.getInvoiceType() != 4 && inbound.getFreight() != null) {
         logistics.setTaxRate(dtoParam.getLogistics().getTaxRate());
         BigDecimal taxRate = logistics.getTaxRate();
         BigDecimal value = taxRate.divide(new BigDecimal(100)).add(BigDecimal.ONE);
         logistics.setAmountExcludingVat(logistics.getFreight().divide(value, 12, 4));
         if (logistics.getInvoiceType() == 1) {
            logistics.setInputVat(logistics.getFreight().subtract(logistics.getAmountExcludingVat()));
         }
      } else {
         logistics.setAmountExcludingVat(logistics.getFreight());
      }

      this.logisticsOrderService.save(logistics);
   }

   private void generateLogisticsOrderV2(LogisticsOrder logisticsDto, Inbound inbound, PurchaseOrder order, Integer inboundReviewStatus) {
      Supplier byId = this.supplierService.getById(logisticsDto.getSupplierId());
      LogisticsOrder logistics = LogisticsOrder.builder()
         .purchaseId(order.getId())
         .invoiceType(logisticsDto.getInvoiceType())
         .basicClass(inbound.getBasicClass())
         .purchaseType(order.getPurchaseType())
         .inboundId(inbound.getId())
         .inboundSn(inbound.getSerialNumber())
         .purchaseSn(order.getSerialNumber())
         .licensePlate(inbound.getLicensePlate())
         .shipmentNumber(inbound.getShipmentNumber())
         .projectIds(inbound.getProjectIds())
         .loadingWeight(inbound.getLoadingWeight())
         .freight(inbound.getFreight())
         .freightInitial(inbound.getFreight())
         .supplierName(byId.getName())
         .supplierId(logisticsDto.getSupplierId())
         .applicantId(UserUtil.getCurrentUserId())
         .applicantName(UserUtil.getCurrentName())
         .userUpdateTime(LocalDateTime.now())
         .inboundReviewStatus(inboundReviewStatus)
         .logisticsPayerType(order.getLogisticsPayerType())
         .logisticsTransportType(order.getLogisticsTransportType())
         .freightWeight(logisticsDto.getFreightWeight())
         .loadingCharge(logisticsDto.getLoadingCharge())
         .tableNameType(TableNameTypeEnum.WMS_INBOUND.getType())
         .build();
      Integer count = this.logisticsOrderService.getCreateCount();
      NumberConfig numberConfig = this.numberConfigService
         .getOne((Wrapper<NumberConfig>)Wrappers.<NumberConfig>lambdaQuery().eq(NumberConfig::getType, NumberTypeEnum.LOGISTICS_ORDER.getType()));
      String code = CommonUtil.generateSerialNumber(numberConfig.getCode(), LocalDate.now(), count);
      logistics.setSerialNumber(code);
      if ((logistics.getInvoiceType().equals(InvoiceTypeEnum.SPECIAL.getType()) || logistics.getInvoiceType().equals(InvoiceTypeEnum.ORDINARY.getType()))
         && inbound.getFreight() != null) {
         logistics.setTaxRate(logisticsDto.getTaxRate());
         BigDecimal taxRate = logistics.getTaxRate();
         BigDecimal value = taxRate.divide(new BigDecimal(100)).add(BigDecimal.ONE);
         logistics.setAmountExcludingVat(logistics.getFreight().divide(value, 12, 4));
         logistics.setAmountExcludingVatInitial(logistics.getFreight().divide(value, 12, 4));
         if (logistics.getInvoiceType().equals(InvoiceTypeEnum.SPECIAL.getType())) {
            logistics.setInputVat(logistics.getFreight().subtract(logistics.getAmountExcludingVat()));
            logistics.setInputVatInitial(logistics.getFreight().subtract(logistics.getAmountExcludingVat()));
         }

         if (ObjectUtil.isNotEmpty(logistics.getLoadingCharge())) {
            logistics.setLoadingChargeExcludingVat(logistics.getLoadingCharge().divide(value, 12, 4));
         }
      } else {
         logistics.setAmountExcludingVat(logistics.getFreight());
         logistics.setAmountExcludingVatInitial(logistics.getFreight());
         if (ObjectUtil.isNotEmpty(logistics.getLoadingCharge())) {
            logistics.setLoadingChargeExcludingVat(logistics.getLoadingCharge());
         }
      }

      this.logisticsOrderService.save(logistics);
   }

   @Override
   public BigDecimal getInboundAmountSum(Long purchaseOrderId, Long supplierId) {
      return this.baseMapper.selectInboundAmountSum(purchaseOrderId, supplierId);
   }

   @Override
   public BigDecimal getInboundAmountSumV2(Long purchaseOrderId, Long supplierId) {
      return this.baseMapper.selectInboundAmountSumV2(purchaseOrderId, supplierId);
   }

   @Override
   public Map<Long, BigDecimal> getInboundAmountSumMap(Collection<Long> supplierIds, LocalDate startDate, LocalDate endDate) {
      LambdaQueryWrapper<Inbound> inboundWrapper = Wrappers.lambdaQuery(Inbound.class)
         .eq(Inbound::getReviewStatus, ReviewStatusEnum.REVIEWED.getType())
         .in(CollectionUtils.isNotEmpty(supplierIds), Inbound::getSupplierId, supplierIds);
      LambdaQueryWrapper<Reject> rejectWrapper = Wrappers.lambdaQuery(Reject.class)
         .eq(Reject::getReviewStatus, ReviewStatusEnum.REVIEWED.getType())
         .in(CollectionUtils.isNotEmpty(supplierIds), Reject::getSupplierId, supplierIds);
      if (startDate != null) {
         inboundWrapper.ge(Inbound::getReviewTime, startDate.atStartOfDay());
         rejectWrapper.ge(Reject::getReviewTime, startDate.atStartOfDay());
      }

      if (endDate != null) {
         inboundWrapper.lt(Inbound::getReviewTime, endDate.plusDays(1L).atStartOfDay());
         rejectWrapper.lt(Reject::getReviewTime, endDate.plusDays(1L).atStartOfDay());
      }

      Map<Long, BigDecimal> supplierInboundAmountMap = this.baseMapper
         .selectList(inboundWrapper)
         .stream()
         .collect(Collectors.groupingBy(Inbound::getSupplierId, Collectors.mapping(Inbound::getAmount, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))));
      Map<Long, BigDecimal> supplierRejectAmountMap = this.rejectMapper
         .selectList(rejectWrapper)
         .stream()
         .collect(Collectors.groupingBy(Reject::getSupplierId, Collectors.mapping(Reject::getAmount, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))));
      Map<Long, BigDecimal> inboundAmountSumMap = new HashMap<>(1024);
      inboundAmountSumMap.putAll(supplierInboundAmountMap);
      supplierRejectAmountMap.forEach((supplierId, rejectAmount) -> {
         BigDecimal inboundAmount = inboundAmountSumMap.getOrDefault(supplierId, BigDecimal.ZERO);
         inboundAmountSumMap.put(supplierId, inboundAmount.subtract(rejectAmount));
      });
      return inboundAmountSumMap;
   }

   @Override
   public List<MonthSummaryDO> getMonthSummary(LocalDateTime year, Integer basicClass, Long classifyId, Integer thickness, Long specId, Long sectionSteelSpecId) {
      return this.inboundDetailMapper.selectMonthTotal(year, basicClass, classifyId, thickness, specId, sectionSteelSpecId);
   }

   @Override
   public List<YearSummaryDO> getYearSummary(LocalDateTime year, Integer basicClass) {
      if (BasicClassEnum.STEEL_PLATE.getType().equals(basicClass)) {
         return this.inboundDetailMapper.selectYearTotalSteelPlate(year, basicClass);
      } else {
         return BasicClassEnum.SECTION_STEEL.getType().equals(basicClass) ? this.inboundDetailMapper.selectYearTotalSectionSteel(year, basicClass) : null;
      }
   }

   @Override
   public List<Integer> getThickness(Long classifyId) {
      return this.inboundDetailMapper.getThickness(classifyId);
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public boolean qualityTesting(InboundQualityTestingDTOParam param) {
      Inbound inbound = this.baseMapper.selectById(param.getInboundId());
      Preconditions.checkArgument(inbound != null, "当前入库单不存在");
      Preconditions.checkArgument(QualityTestingEnum.UN_REVIEWED.getType().equals(inbound.getQualityTestingEnum()), "当前入库单已质检完毕，请核对后操作.");
      Preconditions.checkArgument(!QualityTestingEnum.NO.getType().equals(inbound.getQualityTestingEnum()), "当前入库单无需质检，请核对后操作.");
      inbound.setQualityTestingTime(LocalDateTime.now());
      inbound.setQualityTestingUserId(UserUtil.getCurrentUserId());
      inbound.setQualityTestingUserName(UserUtil.getCurrentName());
      inbound.setQualityTestingRemark(param.getQualityTestingRemark());
      inbound.setAttachmentIds(StrUtil.join(",", param.getAttachments()));
      inbound.setEditable(false);
      List<InboundDetail> inboundDetails = this.inboundDetailMapper
         .selectList((Wrapper<InboundDetail>)Wrappers.<InboundDetail>lambdaQuery().eq(InboundDetail::getInboundId, inbound.getId()));
      Map<Long, Integer> detail = param.getDetail();
      int type = 0;
      Print print = this.printService
         .getOne(
            (Wrapper<Print>)(Wrappers.<Print>lambdaQuery().eq(Print::getReceiptId, inbound.getId()))
               .eq(Print::getReceiptType, ReceiptTypeEnum.INBOUND.getType())
         );

      for (InboundDetail inboundDetail : inboundDetails) {
         Preconditions.checkArgument(inboundDetail != null, "当前入库详情不存在");
         Integer qualityTestingEnum = detail.get(inboundDetail.getId());
         if (qualityTestingEnum != null) {
            inboundDetail.setQualityTestingEnum(qualityTestingEnum);
            type |= qualityTestingEnum;
         }

         if (QualityTestingEnum.ALL_PASS.getType().equals(inboundDetail.getQualityTestingEnum())) {
            print = this.setBarcode(inbound, inboundDetail, print);
         }

         this.inboundDetailMapper.updateById(inboundDetail);
      }

      if (print != null) {
         print.setProjectIds(inbound.getProjectIds());
         print.setContainBasicClass(inbound.getBasicClass());
         this.printService.updateById(print);
      }

      Map<String, Long> map = this.inboundDetailMapper.getQualityTestingById(inbound.getId());
      Preconditions.checkArgument(map.get("待质检") <= 0L, "当前入库单还存在未质检物料,请核对后操作");
      if (QualityTestingEnum.ALL_RETURN.getType().equals(type) && map.get("无质检") > 0L) {
         type = QualityTestingEnum.PART_PASS.getType();
      }

      if (type == (QualityTestingEnum.ALL_PASS.getType() | QualityTestingEnum.ALL_RETURN.getType())) {
         inbound.setQualityTestingEnum(QualityTestingEnum.PART_PASS.getType());
      } else {
         inbound.setQualityTestingEnum(type);
         if (QualityTestingEnum.ALL_RETURN.getType().equals(type)) {
            inbound.setReviewStatus(ReviewStatusEnum.RETURNED.getType());
         }
      }

      return this.baseMapper.updateById(inbound) == 1;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public boolean qualityTestingV2(InboundQualityTestingDTOParam param) {
      Inbound inbound = this.baseMapper.selectById(param.getInboundId());
      Preconditions.checkArgument(inbound != null, "当前入库单不存在");
      Preconditions.checkArgument(QualityTestingEnum.UN_REVIEWED.getType().equals(inbound.getQualityTestingEnum()), "当前入库单已质检完毕，请核对后操作.");
      Preconditions.checkArgument(!QualityTestingEnum.NO.getType().equals(inbound.getQualityTestingEnum()), "当前入库单无需质检，请核对后操作.");
      inbound.setQualityTestingTime(LocalDateTime.now());
      inbound.setQualityTestingUserId(UserUtil.getCurrentUserId());
      inbound.setQualityTestingUserName(UserUtil.getCurrentName());
      inbound.setQualityTestingRemark(param.getQualityTestingRemark());
      inbound.setAttachmentIds(StrUtil.join(",", param.getAttachments()));
      inbound.setEditable(false);
      List<InboundDetail> inboundDetails = this.inboundDetailMapper
         .selectList((Wrapper<InboundDetail>)Wrappers.<InboundDetail>lambdaQuery().eq(InboundDetail::getInboundId, inbound.getId()));
      Map<Long, Integer> detail = param.getDetail();
      int type = 0;
      Print print = this.printService
         .getOne(
            (Wrapper<Print>)(Wrappers.<Print>lambdaQuery().eq(Print::getReceiptId, inbound.getId()))
               .eq(Print::getReceiptType, ReceiptTypeEnum.INBOUND.getType())
         );

      for (InboundDetail inboundDetail : inboundDetails) {
         Preconditions.checkArgument(inboundDetail != null, "当前入库详情不存在");
         Integer qualityTestingEnum = detail.get(inboundDetail.getId());
         if (qualityTestingEnum != null) {
            inboundDetail.setQualityTestingEnum(qualityTestingEnum);
            type |= qualityTestingEnum;
         }

         if (QualityTestingEnum.ALL_PASS.getType().equals(inboundDetail.getQualityTestingEnum())) {
            print = this.setBarcode(inbound, inboundDetail, print);
         }

         this.inboundDetailMapper.updateById(inboundDetail);
      }

      if (print != null) {
         print.setProjectIds(inbound.getProjectIds());
         print.setContainBasicClass(inbound.getBasicClass());
         this.printService.updateById(print);
      }

      Map<String, Long> map = this.inboundDetailMapper.getQualityTestingById(inbound.getId());
      Integer decision = CheckStatusEnum.PASS.getType();
      Preconditions.checkArgument(map.get("待质检") <= 0L, "当前入库单还存在未质检物料,请核对后操作");
      if (QualityTestingEnum.ALL_RETURN.getType().equals(type) && map.get("无质检") > 0L) {
         type = QualityTestingEnum.PART_PASS.getType();
      }

      if (type == (QualityTestingEnum.ALL_PASS.getType() | QualityTestingEnum.ALL_RETURN.getType())) {
         inbound.setQualityTestingEnum(QualityTestingEnum.PART_PASS.getType());
      } else {
         inbound.setQualityTestingEnum(type);
         if (QualityTestingEnum.ALL_RETURN.getType().equals(type)) {
            inbound.setReviewStatus(ReviewStatusEnum.RETURNED.getType());
            decision = CheckStatusEnum.FAIL.getType();
         }
      }

      this.baseMapper.updateById(inbound);
      InboundDTO inboundDTO = this.getInboundDTOById(inbound.getId(), false);
      String jsonData = JSON.toJSONString(inboundDTO, SerializerFeature.DisableCircularReferenceDetect);
      WmsApproveRecord byId = this.wmsApproveRecordService.getById(inbound.getApproveRecordId());
      Boolean b = this.wmsApproveRecordService.commonApproveStep(inbound.getId(), decision, param.getQualityTestingRemark(), byId.getSerialNumber(), jsonData);
      if (b) {
         inbound.setReviewStatus(decision);
         InboundDTOParam inboundDTOParam = new InboundDTOParam();
         inboundDTOParam.setId(inbound.getId());
         inboundDTOParam.setInbound(inbound);
         inboundDTOParam.setInboundDetails(inboundDetails);
         if (inbound.getReviewStatus().equals(ReviewStatusEnum.REVIEWED.getType())) {
            List<InboundDetail> inboundDetailList = inboundDetails.stream()
               .filter(
                  i -> i.getQualityTestingEnum().equals(QualityTestingEnum.NO.getType())
                     || i.getQualityTestingEnum().equals(QualityTestingEnum.ALL_PASS.getType())
               )
               .collect(Collectors.toList());
            inboundDTOParam.setInboundDetails(inboundDetailList);
            if (!inbound.getBoolPartyA()) {
               if (InboundWayEnum.BEGIN_PERIOD.getType().equals(inbound.getInboundWay())) {
                  this.passedBeginSelfBuyingV2(inboundDTOParam);
               } else {
                  this.passedSelfBuyingV2(inboundDTOParam);
               }
            }

            if (inbound.getBoolPartyA()) {
               if (InboundWayEnum.BEGIN_PERIOD.getType().equals(inbound.getInboundWay())) {
                  this.passedPartyBeginAV2(inboundDTOParam);
               } else {
                  this.passedPartyAV2(inboundDTOParam);
               }
            }
         } else {
            this.returnedV2(inboundDTOParam, "质检未通过");
         }

         return true;
      } else {
         return this.baseMapper.updateById(inbound) == 1;
      }
   }

   private Print setBarcode(Inbound inbound, InboundDetail inboundDetail, Print print) {
      if (BasicClassEnum.checkIsSteel(inboundDetail.getBasicClass())) {
         if (print == null) {
            print = Print.builder()
               .receiptId(inbound.getId())
               .receiptSerialNumber(inbound.getSerialNumber())
               .receiptReviewer(inbound.getReviewerName())
               .receiptReviewTime(inbound.getReviewTime())
               .receiptType(ReceiptTypeEnum.INBOUND.getType())
               .type(MaterialLabelPrintTypeEnum.INBOUND.getType())
               .build();
            this.printService.save(print);
         }

         this.setPrintDetail(print, inboundDetail);
      }

      return print;
   }

   private void setPrintDetail(Print print, InboundDetail inboundDetail) {
      int printNumber = BasicClassEnum.COLOR_ROLL.getType().equals(inboundDetail.getBasicClass()) ? 1 : inboundDetail.getQuantity().intValue();
      String barcode = this.printService
         .savePrint(
            PrintDetail.builder()
               .printId(print.getId())
               .receiptDetailId(inboundDetail.getId())
               .basicClass(inboundDetail.getBasicClass())
               .classifyId(inboundDetail.getClassifyId())
               .classifyName(inboundDetail.getClassifyName())
               .specification(inboundDetail.getSpecification())
               .mete(inboundDetail.getMete())
               .quantity(inboundDetail.getQuantity())
               .brand(inboundDetail.getBrand())
               .heatNoAndBatchNo(inboundDetail.getHeatNoAndBatchNo())
               .workshopId(inboundDetail.getWorkshopId())
               .warehouseId(inboundDetail.getWarehouseId())
               .projectId(inboundDetail.getProjectId())
               .type(MaterialLabelPrintTypeEnum.INBOUND.getType())
               .boolPartyA(inboundDetail.getBoolPartyA())
               .length(inboundDetail.getLength())
               .width(inboundDetail.getWidth())
               .thickness(inboundDetail.getThickness())
               .color(inboundDetail.getColor())
               .notPrintNumber(printNumber)
               .standardId(inboundDetail.getStandardId())
               .standardName(inboundDetail.getStandardName())
               .materialIsWhole(MaterialIsWholeEnum.WHOLE.getType())
               .monomerId(inboundDetail.getMonomerId())
               .areaId(inboundDetail.getAreaId())
               .build()
         );
      inboundDetail.setBarcode(barcode);
      print.setTotalNotPrintNumber(print.getTotalNotPrintNumber() != null ? print.getTotalNotPrintNumber() + printNumber : printNumber);
   }

   private void saveBatchPrintInfo(Inbound inbound, List<InboundDetail> inboundDetailList) {
      List<InboundDetail> detailList = inboundDetailList.stream()
         .filter(e -> BasicClassEnum.checkIsSteel(e.getBasicClass()) && QualityTestingEnum.NO.getType().equals(e.getQualityTestingEnum()))
         .collect(Collectors.toList());
      if (!CollectionUtils.isEmpty(detailList)) {
         Print print = Print.builder()
            .receiptId(inbound.getId())
            .receiptSerialNumber(inbound.getSerialNumber())
            .receiptReviewer(inbound.getReviewerName())
            .receiptReviewTime(inbound.getReviewTime())
            .receiptType(ReceiptTypeEnum.INBOUND.getType())
            .type(MaterialLabelPrintTypeEnum.INBOUND.getType())
            .build();
         this.printService.save(print);
         int totalNotPrintNumber = 0;
         int basicClass = 0;
         List<InboundDetail> updateList = new ArrayList<>();
         List<PrintDetail> saveList = new ArrayList<>();
         List<Barcode> saveBarcodeList = new ArrayList<>();
         List<Barcode> allBarcode = this.barcodeMapper.selectList(Wrappers.lambdaQuery());

         for (InboundDetail inboundDetail : detailList) {
            int printNumber = BasicClassEnum.COLOR_ROLL.getType().equals(inboundDetail.getBasicClass()) ? 1 : inboundDetail.getQuantity().intValue();
            PrintDetail printDetail = PrintDetail.builder()
               .printId(print.getId())
               .receiptDetailId(inboundDetail.getId())
               .basicClass(inboundDetail.getBasicClass())
               .classifyId(inboundDetail.getClassifyId())
               .classifyName(inboundDetail.getClassifyName())
               .specification(inboundDetail.getSpecification())
               .mete(inboundDetail.getMete())
               .quantity(inboundDetail.getQuantity())
               .brand(inboundDetail.getBrand())
               .heatNoAndBatchNo(inboundDetail.getHeatNoAndBatchNo())
               .workshopId(inboundDetail.getWorkshopId())
               .warehouseId(inboundDetail.getWarehouseId())
               .projectId(inboundDetail.getProjectId())
               .type(MaterialLabelPrintTypeEnum.INBOUND.getType())
               .boolPartyA(inboundDetail.getBoolPartyA())
               .length(inboundDetail.getLength())
               .width(inboundDetail.getWidth())
               .thickness(inboundDetail.getThickness())
               .color(inboundDetail.getColor())
               .notPrintNumber(printNumber)
               .standardId(inboundDetail.getStandardId())
               .standardName(inboundDetail.getStandardName())
               .materialIsWhole(MaterialIsWholeEnum.WHOLE.getType())
               .monomerId(inboundDetail.getMonomerId())
               .areaId(inboundDetail.getAreaId())
               .build();
            printDetail.setPrinterId(UserUtil.getCurrentUserId());
            printDetail.setPrinterName(UserUtil.getCurrentName());
            printDetail.setPrintTime(LocalDateTime.now());
            printDetail.setStandardId(printDetail.getStandardId());
            printDetail.setStandardName(printDetail.getStandardName());
            printDetail.setPrintNumber(0);
            Barcode param = BeanUtil.copy(printDetail, Barcode.class);
            if (BasicClassEnum.COLOR_ROLL.getType().equals(printDetail.getBasicClass())) {
               param.setBasicClass(3);
            }

            if (printDetail.getProjectId() != null) {
               int type;
               if (printDetail.getBoolPartyA()) {
                  type = MaterialIsWholeEnum.WHOLE.getType().equals(printDetail.getMaterialIsWhole())
                     ? PrintMaterialTypeEnum.A_COMPLETE.getType()
                     : PrintMaterialTypeEnum.A_SURPLUS.getType();
               } else {
                  type = MaterialIsWholeEnum.WHOLE.getType().equals(printDetail.getMaterialIsWhole())
                     ? PrintMaterialTypeEnum.PROJECT_COMPLETE.getType()
                     : PrintMaterialTypeEnum.PROJECT_SURPLUS.getType();
               }

               param.setType(type);
               PrintDetail paramPrintDetail = BeanUtil.copy(param, PrintDetail.class);
               Barcode barcode = this.getBarcode(paramPrintDetail, allBarcode);
               if (barcode != null) {
                  printDetail.setBarcode(barcode.getValue());
               } else {
                  Barcode copy = BeanUtil.copy(printDetail, Barcode.class);
                  List<Barcode> bs = this.getFilteredBarcodes(printDetail, type, allBarcode);
                  if (CollectionUtil.isNotEmpty(bs)) {
                     copy.setAfterSerialNumber(bs.get(0).getAfterSerialNumber() + 1L);
                     copy.setFrontSerialNumber(bs.get(0).getFrontSerialNumber());
                  } else {
                     List<Barcode> ps = allBarcode.stream().filter(e -> printDetail.getProjectId().equals(e.getProjectId())).collect(Collectors.toList());
                     if (CollectionUtil.isNotEmpty(ps)) {
                        copy.setFrontSerialNumber(ps.get(0).getFrontSerialNumber());
                     } else {
                        List<Barcode> barcodes = allBarcode.stream()
                           .filter(e -> e.getProjectId() != null)
                           .sorted((e1, e2) -> Long.compare(e2.getFrontSerialNumber(), e1.getFrontSerialNumber()))
                           .collect(Collectors.toList());
                        copy.setFrontSerialNumber(CollectionUtil.isNotEmpty(barcodes) ? barcodes.get(0).getFrontSerialNumber() + 1L : 1L);
                     }

                     copy.setAfterSerialNumber(1L);
                  }

                  copy.setType(type);
                  copy.setBasicClass(BasicClassEnum.COLOR_ROLL.getType().equals(printDetail.getBasicClass()) ? 3 : printDetail.getBasicClass());
                  copy.setValue(
                     ""
                        + copy.getBasicClass()
                        + type
                        + CommonUtil.getProjectZeroStr(copy.getFrontSerialNumber())
                        + CommonUtil.getProjectZeroStr(copy.getAfterSerialNumber())
                  );
                  saveBarcodeList.add(copy);
                  printDetail.setBarcode(copy.getValue());
                  allBarcode.add(copy);
               }
            } else {
               int type = MaterialIsWholeEnum.WHOLE.getType().equals(printDetail.getMaterialIsWhole())
                  ? PrintMaterialTypeEnum.PUBLIC_COMPLETE.getType()
                  : PrintMaterialTypeEnum.PUBLIC_SURPLUS.getType();
               param.setType(type);
               PrintDetail paramPrintDetail = BeanUtil.copy(param, PrintDetail.class);
               paramPrintDetail.setType(type);
               Barcode barcode = this.getBarcode(paramPrintDetail, allBarcode);
               if (barcode != null) {
                  printDetail.setBarcode(barcode.getValue());
               } else {
                  Barcode copy = BeanUtil.copy(printDetail, Barcode.class);
                  List<Barcode> bs = this.getFilteredBarcodes2(printDetail, type, allBarcode);
                  if (CollectionUtil.isNotEmpty(bs)) {
                     copy.setPublicSerialNumber(bs.get(0).getPublicSerialNumber() + 1L);
                  } else {
                     copy.setPublicSerialNumber(1L);
                  }

                  copy.setType(type);
                  copy.setBasicClass(BasicClassEnum.COLOR_ROLL.getType().equals(printDetail.getBasicClass()) ? 3 : printDetail.getBasicClass());
                  copy.setValue("" + copy.getBasicClass() + type + CommonUtil.getZeroStr(copy.getPublicSerialNumber()));
                  saveBarcodeList.add(copy);
                  printDetail.setBarcode(copy.getValue());
                  allBarcode.add(copy);
               }
            }

            saveList.add(printDetail);
            inboundDetail.setBarcode(printDetail.getBarcode());
            updateList.add(inboundDetail);
            totalNotPrintNumber += printNumber;
            basicClass |= inboundDetail.getBasicClass();
         }

         print.setTotalNotPrintNumber(totalNotPrintNumber);
         print.setContainBasicClass(basicClass);
         this.barcodeService.saveBatch(saveBarcodeList);
         this.printDetailService.saveBatch(saveList);
         this.printService.updateById(print);
         this.inboundDetailService.updateBatchById(updateList);
      }
   }

   private Barcode getBarcode(PrintDetail printDetail, List<Barcode> allBarcode) {
      List<Barcode> barcodeList = allBarcode.stream()
         .filter(
            barcode -> printDetail.getMaterialIsWhole() != null
               ? printDetail.getMaterialIsWhole().equals(barcode.getMaterialIsWhole())
               : barcode.getMaterialIsWhole() == null
         )
         .collect(Collectors.toList());
      barcodeList = barcodeList.stream()
         .filter(barcode -> printDetail.getBoolPartyA() != null ? printDetail.getBoolPartyA().equals(barcode.getBoolPartyA()) : barcode.getBoolPartyA() == null)
         .collect(Collectors.toList());
      barcodeList = barcodeList.stream()
         .filter(barcode -> printDetail.getWorkshopId() != null ? printDetail.getWorkshopId().equals(barcode.getWorkshopId()) : barcode.getWorkshopId() == null)
         .collect(Collectors.toList());
      barcodeList = barcodeList.stream()
         .filter(
            barcode -> printDetail.getWarehouseId() != null ? printDetail.getWarehouseId().equals(barcode.getWarehouseId()) : barcode.getWarehouseId() == null
         )
         .collect(Collectors.toList());
      barcodeList = barcodeList.stream()
         .filter(barcode -> printDetail.getBasicClass() != null ? printDetail.getBasicClass().equals(barcode.getBasicClass()) : barcode.getBasicClass() == null)
         .collect(Collectors.toList());
      barcodeList = barcodeList.stream()
         .filter(barcode -> printDetail.getType() != null ? printDetail.getType().equals(barcode.getType()) : barcode.getType() == null)
         .collect(Collectors.toList());
      barcodeList = barcodeList.stream()
         .filter(barcode -> printDetail.getProjectId() != null ? printDetail.getProjectId().equals(barcode.getProjectId()) : barcode.getProjectId() == null)
         .collect(Collectors.toList());
      barcodeList = barcodeList.stream()
         .filter(barcode -> printDetail.getMonomerId() != null ? printDetail.getMonomerId().equals(barcode.getMonomerId()) : barcode.getMonomerId() == null)
         .collect(Collectors.toList());
      barcodeList = barcodeList.stream()
         .filter(barcode -> printDetail.getAreaId() != null ? printDetail.getAreaId().equals(barcode.getAreaId()) : barcode.getAreaId() == null)
         .collect(Collectors.toList());
      barcodeList = barcodeList.stream()
         .filter(
            barcode -> printDetail.getLength() != null
               ? printDetail.getLength()
                     .stripTrailingZeros()
                     .compareTo(barcode.getLength() != null ? barcode.getLength().stripTrailingZeros() : BigDecimal.ZERO)
                  == 0
               : barcode.getLength() == null
         )
         .collect(Collectors.toList());
      barcodeList = barcodeList.stream()
         .filter(
            barcode -> printDetail.getWidth() != null
               ? printDetail.getWidth().stripTrailingZeros().compareTo(barcode.getWidth() != null ? barcode.getWidth().stripTrailingZeros() : BigDecimal.ZERO)
                  == 0
               : barcode.getWidth() == null
         )
         .collect(Collectors.toList());
      barcodeList = barcodeList.stream()
         .filter(
            barcode -> printDetail.getThickness() != null
               ? printDetail.getThickness()
                     .stripTrailingZeros()
                     .compareTo(barcode.getThickness() != null ? barcode.getThickness().stripTrailingZeros() : BigDecimal.ZERO)
                  == 0
               : barcode.getThickness() == null
         )
         .collect(Collectors.toList());
      barcodeList = barcodeList.stream()
         .filter(
            barcode -> printDetail.getBrand() != null && !"".equals(printDetail.getBrand())
               ? printDetail.getBrand().equals(barcode.getBrand())
               : barcode.getBrand() == null
         )
         .collect(Collectors.toList());
      barcodeList = barcodeList.stream()
         .filter(
            barcode -> printDetail.getHeatNoAndBatchNo() != null && !"".equals(printDetail.getHeatNoAndBatchNo())
               ? printDetail.getHeatNoAndBatchNo().equals(barcode.getHeatNoAndBatchNo())
               : barcode.getHeatNoAndBatchNo() == null
         )
         .collect(Collectors.toList());
      barcodeList = barcodeList.stream()
         .filter(
            barcode -> printDetail.getColor() != null && !"".equals(printDetail.getColor())
               ? printDetail.getColor().equals(barcode.getColor())
               : barcode.getColor() == null
         )
         .collect(Collectors.toList());
      barcodeList = barcodeList.stream()
         .filter(barcode -> printDetail.getStandardId() != null ? printDetail.getStandardId().equals(barcode.getStandardId()) : barcode.getStandardId() == null)
         .collect(Collectors.toList());
      barcodeList = barcodeList.stream()
         .filter(
            barcode -> printDetail.getSpecification() != null
               ? printDetail.getSpecification().equals(barcode.getSpecification())
               : barcode.getSpecification() == null
         )
         .collect(Collectors.toList());
      if (CollectionUtil.isEmpty(barcodeList)) {
         return null;
      } else if (barcodeList.size() == 1) {
         return barcodeList.get(0);
      } else {
         throw new BusinessException("获取条形码记录失败");
      }
   }

   public List<Barcode> getFilteredBarcodes(PrintDetail printDetail, Integer type, List<Barcode> allBarcode) {
      return allBarcode.stream()
         .filter(
            barcode -> BasicClassEnum.COLOR_ROLL.getType().equals(printDetail.getBasicClass())
               ? barcode.getBasicClass() == 3
               : barcode.getBasicClass().equals(printDetail.getBasicClass())
         )
         .filter(barcode -> barcode.getType().equals(type))
         .filter(barcode -> barcode.getProjectId().equals(printDetail.getProjectId()))
         .sorted((b1, b2) -> b2.getAfterSerialNumber().compareTo(b1.getAfterSerialNumber()))
         .collect(Collectors.toList());
   }

   public List<Barcode> getFilteredBarcodes2(PrintDetail printDetail, Integer type, List<Barcode> allBarcode) {
      return allBarcode.stream()
         .filter(
            barcode -> BasicClassEnum.COLOR_ROLL.getType().equals(printDetail.getBasicClass())
               ? barcode.getBasicClass() == 3
               : barcode.getBasicClass().equals(printDetail.getBasicClass())
         )
         .filter(barcode -> barcode.getType().equals(type))
         .sorted((b1, b2) -> b2.getPublicSerialNumber().compareTo(b1.getPublicSerialNumber()))
         .collect(Collectors.toList());
   }

   @Override
   public InboundDTO getQualityTestingDetail(Long id) {
      Inbound inbound = this.baseMapper.selectById(id);
      Preconditions.checkArgument(inbound != null, "入库单不存在");
      InboundDTO inboundDTO = BeanUtil.copy(inbound, InboundDTO.class);
      if (inbound.getPurchaseId() != null) {
         inboundDTO.setPurchaseOrder(this.purchaseOrderService.selectById(inbound.getPurchaseId()));
      }

      if (StrUtil.isNotBlank(inbound.getAttachmentIds())) {
         inboundDTO.setAttachments(this.attachmentService.listByIds(inbound.getAttachmentIds()));
      }

      List<InboundDetail> inboundDetails = this.inboundDetailMapper
         .selectList(
            (Wrapper<InboundDetail>)(Wrappers.<InboundDetail>lambdaQuery().eq(InboundDetail::getInboundId, inbound.getId()))
               .ne(InboundDetail::getQualityTestingEnum, QualityTestingEnum.NO.getType())
         );
      List<InboundDetailDTO> list = this.getInboundDetailDTOS(false, inbound, inboundDetails, false);
      inboundDTO.setList(list);
      return inboundDTO;
   }

   @Override
   public PageVO<InboundDetailDTO> getQualityTestingDetailList(QueryInboundDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort) {
      String s = StringUtils.analyzeSortConditions(sort);
      Page page = PageHelper.startPage(pageNumber, pageSize, s);
      return new PageVO<>(page, this.inboundDetailMapper.getQualityTestingList(param));
   }

   @Override
   public Map<String, BigDecimal> getMeteByProjectId(Long pid, String year) {
      int b = BasicClassEnum.STEEL_PLATE.getType() | BasicClassEnum.SECTION_STEEL.getType() | BasicClassEnum.COLOR_ROLL.getType();
      List<InboundDetail> list = this.inboundDetailMapper.getMeteByProjectId(pid, year, b);
      BigDecimal mete = BigDecimal.ZERO;
      BigDecimal amount = BigDecimal.ZERO;

      for (InboundDetail detail : list) {
         mete = mete.add(detail.getMete());
         amount = amount.add(detail.getAmountExcludingVat());

         for (RejectDetail rejectDetail : this.rejectDetailMapper.getDetailByInboundDetailId(detail.getId())) {
            mete = mete.subtract(rejectDetail.getMete());
            amount = amount.subtract(rejectDetail.getAmountExcludingVat());
         }
      }

      Map<String, BigDecimal> map = new HashMap<>();
      map.put("mete", mete);
      map.put("amount", amount);
      return map;
   }

   @Override
   public List<BriefInboundDTO> getCanCheck(List<Integer> functionTypeList) {
      List<BriefInboundDTO> briefInboundDTOS = new ArrayList<>();
      List<WmsApproveRecordDetail> checkDataIdList = new ArrayList<>();

      for (Integer funcationType : functionTypeList) {
         checkDataIdList.addAll(this.wmsApproveRecordService.getCheckDataIdList(funcationType));
      }

      List<Long> flowIdList = checkDataIdList.stream().map(WmsApproveRecordDetail::getFlowId).filter(ObjectUtil::isNotEmpty).collect(Collectors.toList());
      if (CollectionUtils.isEmpty(flowIdList)) {
         return briefInboundDTOS;
      }

      List<WmsApproveFlowOperation> wmsApproveFlowOperations = this.wmsApproveFlowOperationService
         .list((Wrapper<WmsApproveFlowOperation>)new LambdaQueryWrapper<WmsApproveFlowOperation>().in(WmsApproveFlowOperation::getFlowId, flowIdList));
      List<Long> dataIds = checkDataIdList.stream().map(WmsApproveRecordDetail::getDataId).collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(dataIds)) {
         for (Inbound inbound : this.baseMapper.selectBatchIds(dataIds)) {
            BriefInboundDTO briefInboundDTO = cn.hutool.core.bean.BeanUtil.toBean(inbound, BriefInboundDTO.class);
            briefInboundDTO.setPurchaseSN(inbound.getPurchaseSn());
            briefInboundDTO.setSupplier(this.supplierService.getById(inbound.getSupplierId()));
            if (StrUtil.isNotBlank(inbound.getProjectIds())) {
               briefInboundDTO.setProjects(this.contractProjectService.listByIds(inbound.getProjectIds()));
            }

            if (StrUtil.isNotBlank(inbound.getAttachmentIds())) {
               briefInboundDTO.setAttachments(this.attachmentService.listByIds(inbound.getAttachmentIds()));
            }

            if (inbound.getPurchaseId() != null) {
               PurchaseOrder byId = this.purchaseOrderService.getById(inbound.getPurchaseId());
               briefInboundDTO.setPurchaseSN(byId.getSerialNumber());
            }

            WmsApproveRecordDetail wmsApproveRecordDetail = checkDataIdList.stream().filter(c -> c.getDataId().equals(inbound.getId())).findAny().orElse(null);
            if (CollectionUtils.isNotEmpty(wmsApproveFlowOperations) && ObjectUtil.isNotEmpty(wmsApproveRecordDetail)) {
               List<WmsApproveFlowOperation> wmsApproveFlowOperationList = wmsApproveFlowOperations.stream()
                  .filter(w -> w.getFlowId().equals(wmsApproveRecordDetail.getFlowId()))
                  .collect(Collectors.toList());
               WmsApproveFlowOperation wmsApproveFlowOperation = wmsApproveFlowOperationList.stream()
                  .filter(w -> w.getOperationType().equals(ApproveFlowOperationEnum.OPERATION_MONEY.getType()))
                  .findAny()
                  .orElse(null);
               if (ObjectUtil.isNotEmpty(wmsApproveFlowOperation) && wmsApproveFlowOperation.getOperation().equals("1")) {
                  briefInboundDTO.setEditMoney(true);
               }
            }

            briefInboundDTOS.add(briefInboundDTO);
         }
      }

      return briefInboundDTOS;
   }

   @Override
   public Integer getCanCheckCount(List<Integer> functionTypeList) {
      Integer count = 0;

      for (Integer functionType : functionTypeList) {
         count = count + this.wmsApproveRecordService.getCheckDataIdList(functionType).size();
      }

      return count;
   }

   @Transactional(rollbackFor = Exception.class)
   public Boolean approvalSelfBuyingInbound(InboundDTOParam inboundDTOParam, Long approveRecordId, Integer decision, String opinion) {
      BasicInbound basicInbound = this.basicConfigService.getInboundBasicConfV2();
      Inbound inbound = this.baseMapper.selectById(inboundDTOParam.getId());
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(inbound), "入库单不存在");
      Preconditions.checkArgument(!ReviewStatusEnum.REVIEWED.getType().equals(inbound.getReviewStatus()), "当前入库单已审核通过,不能修改");
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService.getById(approveRecordId);
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(wmsApproveRecord), "审批日志不存在");
      Long currentUserId = UserUtil.getCurrentUserId();
      WmsApproveRecordDetail wmsApproveRecordDetailNow = this.wmsApproveRecordDetailService
         .getOne(
            (Wrapper<WmsApproveRecordDetail>)((((new LambdaQueryWrapper<WmsApproveRecordDetail>()
                           .eq(WmsApproveRecordDetail::getDataId, inbound.getId()))
                        .eq(WmsApproveRecordDetail::getCheckUserId, currentUserId))
                     .eq(WmsApproveRecordDetail::getDecision, CheckStatusEnum.PENDING.getType()))
                  .eq(WmsApproveRecordDetail::getStatus, ApproveRecordStatusEnum.UNDERWAY.getType()))
               .eq(WmsApproveRecordDetail::getApproveRecordSerialNumber, wmsApproveRecord.getSerialNumber())
         );
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(wmsApproveRecordDetailNow), "当前用户没有待审核节点，单据已审核或无审核权限");
      List<WmsApproveFlowOperation> list = this.wmsApproveFlowOperationService
         .list((Wrapper<WmsApproveFlowOperation>)new LambdaQueryWrapper<WmsApproveFlowOperation>().eq(WmsApproveFlowOperation::getFlowId, wmsApproveRecordDetailNow.getFlowId()));
      WmsApproveFlowOperation wmsApproveFlowOperation = list.stream()
         .filter(l -> l.getOperationType().equals(ApproveFlowOperationEnum.OPERATION_MONEY.getType()) && l.getOperation().equals("1"))
         .findAny()
         .orElse(null);
      List<InboundDetail> inboundDetails = this.inboundDetailMapper
         .selectList((Wrapper<InboundDetail>)new LambdaQueryWrapper<InboundDetail>().eq(InboundDetail::getInboundId, inbound.getId()));
      WmsApproveFlowOperation wmsApproveFlowOperationFreight = list.stream()
         .filter(l -> l.getOperationType().equals(ApproveFlowOperationEnum.FREIGHT_MSG.getType()) && l.getOperation().equals("1"))
         .findAny()
         .orElse(null);
      if (InboundWayEnum.ORDINARY.getType().equals(inbound.getInboundWay())) {
         PurchaseOrder purchaseOrder = this.purchaseOrderService.getById(inbound.getPurchaseId());
         Preconditions.checkArgument(ObjectUtil.isNotEmpty(purchaseOrder), "采购订单不存在");
         if (!purchaseOrder.getBoolDetail()) {
            if (decision.equals(CheckStatusEnum.PASS.getType())
               && (!basicInbound.getAmountFillWay().equals(FillWayEnum.AUDIT.getType()) || ObjectUtil.isEmpty(wmsApproveFlowOperation))) {
               Preconditions.checkArgument(CollectionUtils.isEmpty(inboundDTOParam.getInboundDetailMoneyDTOParams()), "该流程不可编辑金额，非法调用");
            }

            if (basicInbound.getAmountFillWay().equals(FillWayEnum.AUDIT.getType()) && ObjectUtil.isNotEmpty(wmsApproveFlowOperation)) {
               if (decision.equals(CheckStatusEnum.PASS.getType())) {
                  List<Long> updateAmountId = new ArrayList<>();
                  if (CollectionUtils.isNotEmpty(inboundDTOParam.getInboundDetailMoneyDTOParams())) {
                     updateAmountId = inboundDTOParam.getInboundDetailMoneyDTOParams()
                        .stream()
                        .map(InboundDetailMoneyDTOParam::getId)
                        .collect(Collectors.toList());
                  }

                  List<InboundDetail> inboundDetailsAmountIsNull = inboundDetails.stream()
                     .filter(i -> ObjectUtil.isEmpty(i.getAmount()))
                     .collect(Collectors.toList());
                  List<Long> amountNullId = new ArrayList<>();
                  if (CollectionUtils.isNotEmpty(inboundDetailsAmountIsNull)) {
                     amountNullId = inboundDetailsAmountIsNull.stream().map(InboundDetail::getId).collect(Collectors.toList());
                  }

                  amountNullId.removeAll(updateAmountId);
                  Preconditions.checkArgument(CollectionUtils.isEmpty(amountNullId), "该流程需编辑金额，请传全明细金额");
                  List<InboundDetailMoneyDTOParam> collect = inboundDTOParam.getInboundDetailMoneyDTOParams()
                     .stream()
                     .filter(i -> i.getUnitPrice().compareTo(BigDecimal.ZERO) < 1)
                     .collect(Collectors.toList());
                  Preconditions.checkArgument(CollectionUtils.isEmpty(collect), "编辑金额中存在单价为0的数据，通过失败");
               }

               if (CollectionUtils.isNotEmpty(inboundDTOParam.getInboundDetailMoneyDTOParams())) {
                  inboundDetails = this.updateInboundDetailMoney(inboundDTOParam.getInboundDetailMoneyDTOParams(), purchaseOrder, inboundDetails);
               }
            }
         } else {
            if (decision.equals(CheckStatusEnum.PASS.getType())
               && (!basicInbound.getPassedInboundState().equals(2) || ObjectUtil.isEmpty(wmsApproveFlowOperation))) {
               Preconditions.checkArgument(CollectionUtils.isEmpty(inboundDTOParam.getInboundDetailMoneyDTOParams()), "该流程不可编辑金额，非法调用");
            }

            if (CollectionUtils.isNotEmpty(inboundDTOParam.getInboundDetailMoneyDTOParams())) {
               inboundDetails = this.updateInboundDetailMoney(inboundDTOParam.getInboundDetailMoneyDTOParams(), purchaseOrder, inboundDetails);
            }
         }

         if (ObjectUtil.isNotEmpty(inboundDTOParam.getLogistics())) {
            if (purchaseOrder.getLogisticsPayerType().equals(LogisticsPayerEnum.SUPPLIER.getType())) {
               Preconditions.checkArgument(false, "不可编辑运费信息，非法调用");
            }

            if (ObjectUtil.isEmpty(wmsApproveFlowOperationFreight)) {
               Preconditions.checkArgument(false, "不可编辑运费金额");
            }

            LogisticsOrder logistics = inboundDTOParam.getLogistics();
            if (basicInbound.getMoney().equals(FillWayEnum.APPLICATION.getType())) {
               Preconditions.checkArgument(ObjectUtil.isEmpty(logistics.getFreight()), "不可编辑运费金额");
            }

            if (basicInbound.getWeight().equals(FillWayEnum.APPLICATION.getType())) {
               Preconditions.checkArgument(ObjectUtil.isEmpty(logistics.getFreightWeight()), "不可编辑运输重量");
            }

            if (basicInbound.getLoadingFee().equals(FillWayEnum.APPLICATION.getType())) {
               Preconditions.checkArgument(ObjectUtil.isEmpty(logistics.getLoadingCharge()), "不可编辑装车费");
            }

            if (basicInbound.getInvoiceTax().equals(FillWayEnum.APPLICATION.getType())) {
               Preconditions.checkArgument(ObjectUtil.isEmpty(logistics.getInvoiceType()), "不可编辑发票信息");
            }

            if (basicInbound.getLogisticsUnit().equals(FillWayEnum.APPLICATION.getType())) {
               Preconditions.checkArgument(ObjectUtil.isEmpty(logistics.getSupplierId()), "不可编辑物流单位");
            }
         }

         if (decision.equals(CheckStatusEnum.PASS.getType())
            && purchaseOrder.getLogisticsPayerType().equals(LogisticsPayerEnum.DEMAND.getType())
            && ObjectUtil.isNotEmpty(wmsApproveFlowOperationFreight)
            && ObjectUtil.isEmpty(inbound.getFreightJson())) {
            LogisticsOrder logistics = inboundDTOParam.getLogistics();
            Preconditions.checkArgument(ObjectUtil.isNotEmpty(logistics), "该流程需要编辑运费信息，请填写运费信息后提交");
            if (basicInbound.getMoney().equals(FillWayEnum.AUDIT.getType())) {
               Preconditions.checkArgument(ObjectUtil.isNotEmpty(logistics.getFreight()), "该流程需要编辑运费金额，请填写运费金额后提交");
            }

            if (basicInbound.getInvoiceTax().equals(FillWayEnum.AUDIT.getType())) {
               Preconditions.checkArgument(ObjectUtil.isNotEmpty(logistics.getInvoiceType()), "该流程需要编辑发票信息，请填写发票信息后提交");
            }

            if (basicInbound.getLogisticsUnit().equals(FillWayEnum.AUDIT.getType())) {
               Preconditions.checkArgument(ObjectUtil.isNotEmpty(logistics.getSupplierId()), "该流程需要编辑物流单位，请填写物流单位后提交");
            }
         }

         if (ObjectUtil.isNotEmpty(inboundDTOParam.getLogistics())) {
            LogisticsOrder logistics = inboundDTOParam.getLogistics();
            LogisticsOrder logisticsOrder = ObjectUtil.isNotEmpty(inbound.getFreightJson())
               ? JSONObject.parseObject(inbound.getFreightJson(), LogisticsOrder.class)
               : new LogisticsOrder();
            if (logistics.getFreight() != null) {
               logisticsOrder.setFreight(logistics.getFreight());
            }

            if (logistics.getFreightWeight() != null) {
               logisticsOrder.setFreightWeight(logistics.getFreightWeight());
            }

            if (logistics.getLoadingCharge() != null) {
               logisticsOrder.setLoadingCharge(logistics.getLoadingCharge());
            }

            if (logistics.getInvoiceType() != null) {
               logisticsOrder.setInvoiceType(logistics.getInvoiceType());
            }

            if (logistics.getTaxRate() != null) {
               logisticsOrder.setTaxRate(logistics.getTaxRate());
            }

            if (logistics.getSupplierId() != null) {
               logisticsOrder.setSupplierId(logistics.getSupplierId());
            }

            inbound.setFreightJson(JSON.toJSONString(logisticsOrder));
         }
      }

      inboundDTOParam.setInboundDetails(inboundDetails);
      this.baseMapper.updateById(inbound);
      InboundDTO inboundDTO = this.getInboundDTOById(inbound.getId(), false);
      String jsonData = JSON.toJSONString(inboundDTO);
      Boolean b = this.wmsApproveRecordService.commonApproveStep(inbound.getId(), decision, opinion, wmsApproveRecord.getSerialNumber(), jsonData);
      if (b) {
         if (decision.equals(CheckStatusEnum.PASS.getType())) {
            inbound.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
            inboundDTOParam.setInbound(inbound);
            if (InboundWayEnum.BEGIN_PERIOD.getType().equals(inbound.getInboundWay())) {
               this.passedBeginSelfBuyingV2(inboundDTOParam);
            } else {
               this.passedSelfBuyingV2(inboundDTOParam);
            }
         } else {
            this.returnedV2(inboundDTOParam, opinion);
         }
      }

      return true;
   }

   private List<InboundDetail> updateInboundDetailMoney(
      List<InboundDetailMoneyDTOParam> inboundDetailMoneyDTOParams, PurchaseOrder purchaseOrder, List<InboundDetail> inboundDetailsOld
   ) {
      List<InboundDetail> inboundDetailsNew = new ArrayList<>();

      for (InboundDetail inboundDetail : inboundDetailsOld) {
         InboundDetailMoneyDTOParam inboundDetailMoneyDTOParam = inboundDetailMoneyDTOParams.stream()
            .filter(i -> i.getId().equals(inboundDetail.getId()))
            .findAny()
            .orElse(null);
         if (ObjectUtil.isEmpty(inboundDetailMoneyDTOParam)) {
            inboundDetailsNew.add(inboundDetail);
         } else {
            Preconditions.checkArgument(ObjectUtil.isNotEmpty(inboundDetailMoneyDTOParam), "修改金额明细与原明细不匹配");
            inboundDetail.setUnitPrice(inboundDetailMoneyDTOParam.getUnitPrice());
            inboundDetail.setUnitPriceNoFreight(inboundDetailMoneyDTOParam.getUnitPrice());
            inboundDetail.setAmount(inboundDetailMoneyDTOParam.getAmount());
            inboundDetail.setAmountNoFreight(inboundDetailMoneyDTOParam.getAmount());
            if (InvoiceTypeEnum.SPECIAL.getType().equals(purchaseOrder.getInvoiceType())) {
               BigDecimal value = purchaseOrder.getTaxRate().divide(HUNDRED).add(BigDecimal.ONE);
               if (inboundDetail.getAmount() != null) {
                  inboundDetail.setAmountExcludingVat(inboundDetail.getAmount().divide(value, 2, RoundingMode.HALF_UP));
                  inboundDetail.setAmountExcludingVatNoFreight(inboundDetail.getAmount().divide(value, 2, RoundingMode.HALF_UP));
                  inboundDetail.setUnitPriceExcludingVat(inboundDetail.getAmountExcludingVat().divide(inboundDetail.getMete(), 12, RoundingMode.HALF_UP));
                  inboundDetail.setUnitPriceExcludingVatNoFreight(
                     inboundDetail.getAmountExcludingVat().divide(inboundDetail.getMete(), 12, RoundingMode.HALF_UP)
                  );
                  inboundDetail.setInputVat(inboundDetail.getAmount().subtract(inboundDetail.getAmountExcludingVat()));
                  inboundDetail.setInputVatNoFreight(inboundDetail.getAmount().subtract(inboundDetail.getAmountExcludingVat()));
               }
            } else {
               inboundDetail.setAmountExcludingVat(inboundDetail.getAmount());
               inboundDetail.setAmountExcludingVatNoFreight(inboundDetail.getAmount());
               inboundDetail.setUnitPriceExcludingVat(inboundDetail.getUnitPrice());
               inboundDetail.setUnitPriceExcludingVatNoFreight(inboundDetail.getUnitPrice());
            }

            this.inboundDetailMapper.updateById(inboundDetail);
            inboundDetailsNew.add(inboundDetail);
         }
      }

      return inboundDetailsNew;
   }

   private void updateLogisticsOrder(LogisticsOrder logisticsNew, LogisticsOrder logisticsOrderOld, PurchaseOrder purchaseOrder, Inbound inbound) {
      Supplier byId = this.supplierService.getById(logisticsNew.getSupplierId());
      LogisticsOrder logistics = LogisticsOrder.builder()
         .purchaseId(purchaseOrder.getId())
         .invoiceType(logisticsNew.getInvoiceType())
         .basicClass(inbound.getBasicClass())
         .purchaseType(purchaseOrder.getPurchaseType())
         .inboundId(inbound.getId())
         .inboundSn(inbound.getSerialNumber())
         .purchaseSn(purchaseOrder.getSerialNumber())
         .licensePlate(inbound.getLicensePlate())
         .projectIds(inbound.getProjectIds())
         .loadingWeight(inbound.getLoadingWeight())
         .supplierName(byId.getName())
         .supplierId(logisticsNew.getSupplierId())
         .applicantId(UserUtil.getCurrentUserId())
         .applicantName(UserUtil.getCurrentName())
         .userUpdateTime(LocalDateTime.now())
         .inboundReviewStatus(ReviewStatusEnum.UN_REVIEWED.getType())
         .logisticsPayerType(purchaseOrder.getLogisticsPayerType())
         .logisticsTransportType(purchaseOrder.getLogisticsTransportType())
         .freightWeight(logisticsNew.getFreightWeight())
         .freight(logisticsNew.getFreight())
         .freightInitial(logisticsNew.getFreight())
         .loadingCharge(logisticsNew.getLoadingCharge())
         .tableNameType(TableNameTypeEnum.WMS_INBOUND.getType())
         .build();
      if ((logistics.getInvoiceType().equals(InvoiceTypeEnum.SPECIAL.getType()) || logistics.getInvoiceType().equals(InvoiceTypeEnum.ORDINARY.getType()))
         && logistics.getFreight() != null) {
         logistics.setTaxRate(logisticsNew.getTaxRate());
         BigDecimal taxRate = logistics.getTaxRate();
         BigDecimal value = taxRate.divide(new BigDecimal(100)).add(BigDecimal.ONE);
         logistics.setAmountExcludingVat(logistics.getFreight().divide(value, 12, 4));
         logistics.setAmountExcludingVatInitial(logistics.getFreight().divide(value, 12, 4));
         if (logistics.getInvoiceType().equals(InvoiceTypeEnum.SPECIAL.getType())) {
            logistics.setInputVat(logistics.getFreight().subtract(logistics.getAmountExcludingVat()));
            logistics.setInputVatInitial(logistics.getFreight().subtract(logistics.getAmountExcludingVat()));
         }

         if (ObjectUtil.isNotEmpty(logistics.getLoadingCharge())) {
            logistics.setLoadingChargeExcludingVat(logistics.getLoadingCharge().divide(value, 12, 4));
            logistics.setInputVat(
               logistics.getFreight()
                  .add(logistics.getLoadingCharge())
                  .subtract(logistics.getAmountExcludingVat())
                  .subtract(logistics.getLoadingChargeExcludingVat())
            );
            logistics.setInputVatInitial(
               logistics.getFreight()
                  .add(logistics.getLoadingCharge())
                  .subtract(logistics.getAmountExcludingVat())
                  .subtract(logistics.getLoadingChargeExcludingVat())
            );
         }

         if (ObjectUtil.isNotEmpty(logistics.getLoadingCharge())) {
            logistics.setLoadingChargeExcludingVat(logistics.getLoadingCharge());
         }
      } else {
         logistics.setAmountExcludingVat(logistics.getFreight());
         logistics.setAmountExcludingVatInitial(logistics.getFreight());
         if (ObjectUtil.isNotEmpty(logistics.getLoadingCharge())) {
            logistics.setLoadingChargeExcludingVat(logistics.getLoadingCharge());
         }
      }

      if (ObjectUtil.isNotEmpty(logisticsOrderOld)) {
         logistics.setId(logisticsOrderOld.getId());
         logistics.setUpdateTime(LocalDateTime.now());
         this.logisticsOrderService.updateById(logistics);
      } else {
         this.logisticsOrderService.save(logistics);
      }

      inbound.setFreight(logistics.getFreight());
      inbound.setFreightWeight(logistics.getFreightWeight());
      inbound.setFreightTaxRate(logistics.getTaxRate());
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean approvalPartyAInbound(InboundDTOParam inboundDTOParam, Long approveRecordId, Integer decision, String opinion) {
      Inbound inbound = this.baseMapper.selectById(inboundDTOParam.getId());
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(inbound), "入库单不存在");
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService.getById(approveRecordId);
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(wmsApproveRecord), "审批日志不存在");
      InboundDTO inboundDTOById = this.getInboundDTOById(inbound.getId(), false);
      String jsonData = JSON.toJSONString(inboundDTOById);
      Boolean b = this.wmsApproveRecordService.commonApproveStep(inbound.getId(), decision, opinion, wmsApproveRecord.getSerialNumber(), jsonData);
      if (b) {
         if (decision.equals(CheckStatusEnum.PASS.getType())) {
            inbound.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
            inboundDTOParam.setInbound(inbound);
            List<InboundDetail> inboundDetails = this.inboundDetailMapper
               .selectList((Wrapper<InboundDetail>)new LambdaQueryWrapper<InboundDetail>().eq(InboundDetail::getInboundId, inbound.getId()));
            inboundDTOParam.setInboundDetails(inboundDetails);
            if (InboundWayEnum.BEGIN_PERIOD.getType().equals(inbound.getInboundWay())) {
               this.passedPartyBeginAV2(inboundDTOParam);
            } else {
               this.passedPartyAV2(inboundDTOParam);
            }
         } else {
            this.returnedV2(inboundDTOParam, opinion);
         }
      }

      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean returnUpdateInbound(InboundDTOParam dtoParam) {
      PurchaseOrder order = null;
      if (dtoParam.getPurchaseId() != null) {
         order = this.purchaseOrderService.getById(dtoParam.getPurchaseId());
         Preconditions.checkArgument(order != null, "采购订单不存在");
         Preconditions.checkArgument(order.getDataStatus().equals(DataStatusEnum.SUCCEED.getType()), "采购订单状态发生改变");
      }

      Inbound inbound = this.baseMapper.selectById(dtoParam.getId());
      Preconditions.checkArgument(inbound != null, "入库单不存在");
      Preconditions.checkArgument(!ReviewStatusEnum.REVIEWED.getType().equals(inbound.getReviewStatus()), "当前入库单已审核通过,不能修改");
      if (inbound.getReviewStatus().equals(ReviewStatusEnum.AUDITING.getType())) {
         dtoParam.setReviewStatus(ReviewStatusEnum.CANCEL.getType());
         this.revocation(inbound.getId());
      }

      this.printService.updateByInboundId(inbound.getId());
      if (BasicClassEnum.checkIsSteelAddOtherSteelMaterials(dtoParam.getBasicClass())) {
         dtoParam.setBasicClass(BasicClassEnum.STEEL_PLATE.getType());
      }

      if (!ReviewStatusEnum.RETURNED.getType().equals(inbound.getReviewStatus()) && !ReviewStatusEnum.CANCEL.getType().equals(inbound.getReviewStatus())) {
         Preconditions.checkArgument(false, "仅驳回或撤销后可编辑入库单");
      } else if (InboundWayEnum.ORDINARY.getType().equals(inbound.getInboundWay())) {
         if (ObjectUtil.isNotEmpty(dtoParam.getPurchaseId())) {
            this.saveSelfBuyingInboundV2(dtoParam);
         } else {
            this.savePartyAInboundV2(dtoParam);
         }
      } else if (!inbound.getBoolPartyA()) {
         this.saveBeginSelfBuyingInbound(dtoParam);
      } else {
         this.saveBeginPartyAInbound(dtoParam);
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean revocation(Long id) {
      SecurityUser currentUser = UserUtil.getCurrentUser();
      Inbound inbound = this.baseMapper.selectById(id);
      Preconditions.checkArgument(currentUser.getId().equals(inbound.getApplicantId()), "仅创建此申购单的人才可进行撤销操作");
      Preconditions.checkArgument(ReviewStatusEnum.AUDITING.getType().equals(inbound.getReviewStatus()), "只可在创建中才可撤销申请，撤销失败");
      if (ObjectUtil.isNotEmpty(inbound.getApproveRecordId())) {
         this.wmsApproveRecordService.revocation(inbound.getApproveRecordId());
      }

      inbound.setReviewStatus(ReviewStatusEnum.CANCEL.getType());
      this.printService.updateByInboundId(inbound.getId());
      this.updateOPDetail(inbound);
      LogisticsOrder logisticsOrder = this.logisticsOrderService
         .getOne(
            (Wrapper<LogisticsOrder>)(Wrappers.<LogisticsOrder>lambdaQuery().eq(LogisticsOrder::getInboundId, inbound.getId()))
               .eq(LogisticsOrder::getTableNameType, TableNameTypeEnum.WMS_INBOUND.getType())
         );
      if (logisticsOrder != null) {
         logisticsOrder.setInboundReviewStatus(ReviewStatusEnum.CANCEL.getType());
         logisticsOrder.setUserUpdateTime(LocalDateTime.now());
         this.logisticsOrderService.updateById(logisticsOrder);
      }

      int i = this.baseMapper.updateById(inbound);
      Preconditions.checkArgument(i == 1, "撤销失败");
      return true;
   }

   @Override
   public InboundDTO getInboundDTOByRecordId(Long id) {
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService.getById(id);
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(wmsApproveRecord), "未查询到日志信息");
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(wmsApproveRecord.getJsonData()), "该日志JsonData数据为空，日志编号为：" + wmsApproveRecord.getSerialNumber());
      JSONObject jsonObject = JSONObject.parseObject(wmsApproveRecord.getJsonData());
      InboundDTO inboundDTO = JSON.toJavaObject(jsonObject, InboundDTO.class);
      if (ObjectUtil.isNotEmpty(inboundDTO.getPurchaseOrder())) {
         PurchaseOrder byId = this.purchaseOrderService.getById(inboundDTO.getPurchaseOrder().getId());
         Preconditions.checkArgument(byId != null, "采购订单不存在");
         Preconditions.checkArgument(byId.getDataStatus().equals(DataStatusEnum.SUCCEED.getType()), "采购订单状态发生改变");
      }

      inboundDTO.setReviewStatus(wmsApproveRecord.getReviewStatus());
      return inboundDTO;
   }

   private void updateApproveBoolRewrite(Long id, Boolean boolRewrite) {
      Inbound byId = this.baseMapper.selectById(id);
      List<Long> idsAll = new ArrayList<>();
      idsAll.add(byId.getApproveRecordId());

      for (Inbound inbound : this.baseMapper
         .selectList(
            (Wrapper<Inbound>)(new LambdaQueryWrapper<Inbound>().ne(Inbound::getId, id))
               .and(
                  i -> {
                     LambdaQueryWrapper var10000 = ((i.eq(Inbound::getId, byId.getOriginalId()))
                           .or())
                        .eq(Inbound::getOriginalId, byId.getOriginalId());
                  }
               )
         )) {
         if (ObjectUtil.isNotEmpty(inbound.getApproveRecordId())) {
            idsAll.add(inbound.getApproveRecordId());
         }
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveAPPInbound(APPInboundDTOParam appInboundDTOParam) {
      InboundDTOParam request = new InboundDTOParam();
      ArrayList<InboundDetailDTOParam> objects = new ArrayList<>();
      InboundDetailDTOParam copy = BeanUtil.copy(appInboundDTOParam, InboundDetailDTOParam.class);
      Classification byId = this.classificationService.getById(copy.getClassifyId());
      SubjectMeasureDTO subjectMeasureDTO = this.measureService.measureListById(byId.getId());
      BigDecimal materialInventoryMete = this.queryUtil.getMete(subjectMeasureDTO, appInboundDTOParam.getMete());
      copy.setMete(materialInventoryMete);
      copy.setClassifyName(byId.getName());
      copy.setClassifySerialNumber(byId.getSerialNumber());
      copy.setQuantity(BigDecimal.ONE);
      copy.setBoolNestSurplus(true);
      copy.setRealTime(LocalDateTime.now());
      objects.add(copy);
      request.setList(objects);
      request.setBoolNestSurplus(true);
      this.saveInbound(request);
      return true;
   }

   @Override
   public Double getArea(APPInboundDTOParam request) {
      String url = request.getDxfUrl();
      String fileName = url.substring(url.lastIndexOf(47) + 1);
      String s = this.downloadFile.downloadFile(url, fileName);
      File file = FileUtil.newFile(this.configProperties.getFilePath1() + s);
      double v = 0.0;

      try {
         v = CorrectDXF.resolverDXFForImport(file);
      } catch (Exception e) {
         e.printStackTrace();
      }

      return v;
   }

   @Override
   public Double getArea(String request) {
      File file = FileUtil.newFile(this.configProperties.getFilePath1() + request);
      double v = 0.0;

      try {
         v = CorrectDXF.resolverDXFForImport(file);
      } catch (Exception e) {
         e.printStackTrace();
      }

      return v;
   }

   @Override
   public PageVO<AppInboundDetailDTO> selectAPPInboundDetailDTO(QueryInboundDTOParam dtoParam, Integer pageNumber, Integer pageSize, List<String> sort) {
      String s = StringUtils.analyzeSortConditions(sort);
      String s1 = this.configProperties.getUrl();
      Map<Long, Workshop> workshopMap = this.queryUtil.getWorkshopMap(null);
      dtoParam.setBoolNestSurplus(true);
      Page page = PageHelper.startPage(pageNumber, pageSize, s);
      List<AppInboundDetailDTO> appInboundDetailDTOS = this.baseMapper.selectAPPInboundDetailDTO(dtoParam);
      List<AppInboundDetailDTO> updatedList = appInboundDetailDTOS.stream()
         .peek(dto -> dto.setNestType(1))
         .peek(dto -> dto.setWorkshopName(workshopMap.get(dto.getWorkshopId()).getName()))
         .peek(dto -> dto.setImgUrl(s1 + "files/" + dto.getImgUrl()))
         .peek(dto -> dto.setDxfUrl(s1 + "files/" + dto.getDxfUrl()))
         .collect(Collectors.toList());
      return new PageVO<>(page, updatedList);
   }

   @Override
   public PageVO<SurplusDetailDTO> getSurplusList(
      Integer pageNumber, Integer pageSize, Boolean marking, String specification, BigDecimal thickness, Boolean boolPartyA, List<String> sort
   ) {
      String s = StringUtils.analyzeSortConditions(sort);
      Page page = PageHelper.startPage(pageNumber, pageSize, s);
      List<MaterialInventory> list = this.materialInventoryService
         .list(
            ((((((new LambdaQueryWrapper<MaterialInventory>()
                                 .eq(MaterialInventory::getBoolNestSurplus, true))
                              .isNotNull(MaterialInventory::getDxfUrl))
                           .isNotNull(MaterialInventory::getArea))
                        .eq(ObjectUtil.isNotEmpty(marking), MaterialInventory::getMarking, marking))
                     .eq(StrUtil.isNotBlank(specification), MaterialInventory::getSpecification, specification))
                  .eq(ObjectUtil.isNotEmpty(thickness), MaterialInventory::getThickness, thickness))
               .eq(ObjectUtil.isNotEmpty(boolPartyA), MaterialInventory::getBoolPartyA, boolPartyA)
         );
      ArrayList<SurplusDetailDTO> objects = new ArrayList<>();
      list.forEach(materialInventory -> {
         SurplusDetailDTO copy = BeanUtil.copy(materialInventory, SurplusDetailDTO.class);
         copy.setNestSurplusCode(materialInventory.getSurplusSn());
         String s1 = this.configProperties.getUrl();
         copy.setImgUrl(s1 + "files/" + materialInventory.getImgUrl());
         copy.setWorkNumber(materialInventory.getChildOrderNumber());
         copy.setWorkId(materialInventory.getChildOrderId());
         objects.add(copy);
      });
      return new PageVO<>(page, objects);
   }

   @Override
   public Boolean updateMarking(Long id) {
      MaterialInventory materialInventory = new MaterialInventory();
      materialInventory.setId(id);
      materialInventory.setMarking(true);
      this.materialInventoryService.updateById(materialInventory);
      return null;
   }

   @Override
   public ConditionsDTO getConditions() {
      List<MaterialInventory> list = this.materialInventoryService
         .list(
            (Wrapper<MaterialInventory>)((new LambdaQueryWrapper<MaterialInventory>().eq(MaterialInventory::getBoolNestSurplus, true))
                  .isNotNull(MaterialInventory::getDxfUrl))
               .isNotNull(MaterialInventory::getArea)
         );
      List<String> collect = list.stream().map(MaterialInventory::getSpecification).distinct().collect(Collectors.toList());
      List<BigDecimal> collect2 = list.stream().map(MaterialInventory::getThickness).distinct().collect(Collectors.toList());
      return ConditionsDTO.builder().thicknessList(collect2).specificationList(collect).build();
   }

   @Override
   public List<AppCutMaterialDTO> getMaterialInventory(Long id) {
      List<MesBuildingBoChuNestingResult> list = this.mesBuildingBoChuNestingResultService
         .list(
            (Wrapper<MesBuildingBoChuNestingResult>)(new LambdaQueryWrapper<MesBuildingBoChuNestingResult>().eq(MesBuildingBoChuNestingResult::getJobId, id))
               .ne(MesBuildingBoChuNestingResult::getCutStatus, CutStatusEnum.CUT_COMPLETED)
         );
      Map<Long, Workshop> workshopMap = this.queryUtil.getWorkshopMap(null);
      Map<Long, Warehouse> warehouseMap = this.queryUtil.getWarehouseMap(null);
      ArrayList<AppCutMaterialDTO> objects = new ArrayList<>();
      list.forEach(
         materialInventory1 -> {
            AppCutMaterialDTO build = AppCutMaterialDTO.builder()
               .quantity(materialInventory1.getAmount())
               .length(materialInventory1.getPlateHeight())
               .width(materialInventory1.getPlateWidth())
               .thickness(materialInventory1.getThickness())
               .specification(materialInventory1.getMaterial())
               .build();
            List<WmsPlantPart> list1 = this.wmsPlantPartService
               .list((Wrapper<WmsPlantPart>)new LambdaQueryWrapper<WmsPlantPart>().eq(WmsPlantPart::getStockGuid, materialInventory1.getGuid()));
            if (CollectionUtil.isNotEmpty(list1)) {
               if (StrUtil.containsAny(list1.get(0).getSyncVirtualId(), "虚拟")) {
                  build.setWorkshopName("虚拟余料库");
               } else {
                  MaterialInventory materialInventory = this.materialInventoryService.getById(list1.get(0).getSyncId());
                  if (materialInventory != null) {
                     if (materialInventory.getWorkshopId() != null) {
                        Workshop workshop = workshopMap.get(materialInventory.getWorkshopId());
                        build.setWorkshopName(workshop.getName());
                     }

                     Warehouse warehouse = warehouseMap.get(materialInventory.getWarehouseId());
                     if (warehouse != null) {
                        build.setWarehouseName(warehouse.getName());
                     }
                  }
               }
            }

            objects.add(build);
         }
      );
      return objects;
   }

   private void updatePurchaseDetail(InboundDetail inboundDetail) {
      PurchaseOrderDetail orderDetail = this.poDetailService.getById(inboundDetail.getPurchaseOrderDetailId());
      if (ObjectUtil.isNotEmpty(orderDetail)) {
         this.poDetailService.updateInboundMete(inboundDetail.getPurchaseOrderDetailId(), inboundDetail.getMete(), inboundDetail.getQuantity());
      }
   }

   private Measure getMeasure(Long pid) {
      Measure m = this.measureMapper.selectOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, pid));
      if (m.getOutboundUnitType() != null) {
         return m;
      }

      Classification classification = this.classificationService.getById(pid);
      return classification.getLevel() != 1 ? this.getMeasure(classification.getParentId()) : m;
   }

   @Override
   public List<PuchaseInboundDetailDTO> orderDetailV2(Long orderId, LocalDate startDate, LocalDate endDate) {
      List<PuchaseInboundDetailDTO> inboundDetailDTOList = this.orderDetailV3(orderId);
      return inboundDetailDTOList.stream()
         .filter(i -> startDate == null || !startDate.isAfter(i.getReviewerDate().toLocalDate()))
         .filter(i -> endDate == null || !endDate.isBefore(i.getReviewerDate().toLocalDate()))
         .collect(Collectors.toList());
   }

   @Override
   public List<PuchaseInboundDetailDTO> orderDetailV3(Long orderId) {
      PurchaseOrder order = this.purchaseOrderService.getById(orderId);
      Preconditions.checkArgument(order != null, "采购合同已不存在！,请刷新后重试！");
      if (PlaceEnum.FACTORY.getType().equals(order.getOrderPlace())) {
         if (PurchaseEnum.MATERIAL.getType().equals(order.getPurchaseType())) {
            return this.getFactoryInboundDetailList(orderId, null);
         }

         if (PurchaseEnum.FINISHED_GOODS.getType().equals(order.getPurchaseType())) {
            return this.inboundManufacturedService.orderDetailV2(orderId, null);
         }
      }

      return PlaceEnum.CONSTRUCTION_SITE.getType().equals(order.getOrderPlace()) ? this.getConstructionInboundDetailList(orderId, null) : new ArrayList<>();
   }

   @Override
   public List<PuchaseInboundDetailDTO> getConstructionInboundDetailList(Long orderId, List<Long> orderDetailIds) {
      List<PuchaseInboundDetailDTO> dtos = new ArrayList<>();
      PurchaseOrder order = this.purchaseOrderService.getById(orderId);
      Preconditions.checkArgument(order != null, "采购合同已不存在，请刷新重试！");
      List<PurchaseOrderDetail> detailList = this.orderDetailService
         .list(
            Wrappers.lambdaQuery(PurchaseOrderDetail.class)
               .eq(PurchaseOrderDetail::getPurchaseId, orderId)
               .in(CollectionUtil.isNotEmpty(orderDetailIds), PurchaseOrderDetail::getId, orderDetailIds)
         );
      if (CollectionUtil.isEmpty(detailList)) {
         return dtos;
      }

      Map<Long, ProjectInfo> projectMap = this.contractProjectService
         .listByIds(order.getProjectIds())
         .stream()
         .collect(Collectors.toMap(ProjectInfo::getId, Function.identity()));
      List<Long> detailIds = detailList.stream().map(PurchaseOrderDetail::getId).collect(Collectors.toList());
      Map<Long, PurchaseOrderDetail> detailMap = detailList.stream().collect(Collectors.toMap(PurchaseOrderDetail::getId, Function.identity()));
      List<ConstructionInboundDetailDTO> constructionInboundDetailDTOList = this.reportService.getConstructionInboundDetailList(detailIds);
      return constructionInboundDetailDTOList.stream()
         .map(
            e -> {
               PuchaseInboundDetailDTO detailDTO = BeanUtil.copy(e, PuchaseInboundDetailDTO.class);
               if (detailMap.containsKey(e.getPurchaseDetailId())) {
                  PurchaseOrderDetail detail = detailMap.get(e.getPurchaseDetailId());
                  detailDTO.setProjectId(detail.getProjectId());
                  detailDTO.setProject(projectMap.get(detail.getProjectId()));
                  detailDTO.setClassifyId(detail.getClassifyId());
                  detailDTO.setBasicClassEnum(detail.getBasicClass());
                  detailDTO.setManufacturedName(detail.getManufacturedName());
                  detailDTO.setManufacturedType(detail.getManufacturedType());
                  detailDTO.setWageQuotaType(detail.getWageQuotaType());
                  detailDTO.setBrand(detail.getBrand());
                  detailDTO.setColor(detail.getColor());
                  detailDTO.setActualReceivedMete(e.getActualReceivedMete());
                  detailDTO.setPrice(detail.getUnitPrice());
                  detailDTO.setPriceExcludingVat(detail.getUnitPriceExcludingVat());
                  detailDTO.setReviewerDate(e.getApplicantDate());
                  detailDTO.setReviewer(e.getApplicant());
                  if (e.getQuantity() != null && e.getQuantity().compareTo(BigDecimal.valueOf(0L)) > 0) {
                     BigDecimal p = e.getQuantity().divide(detail.getQuantity(), 20, 4);
                     if ((608 & detail.getBasicClass()) > 0) {
                        if (WmsWageQuotaTypeEnum.WMS_QUANTITY_PRICE.getType() == detail.getWageQuotaType()) {
                           detailDTO.setMete(detail.getQuantity().multiply(p).setScale(0, 4));
                        } else if (WmsWageQuotaTypeEnum.WMS_LENGTH_PRICE.getType() == detail.getWageQuotaType()) {
                           detailDTO.setMete(detail.getTotalLength().multiply(p));
                        } else if (WmsWageQuotaTypeEnum.WMS_AREA_PRICE.getType() == detail.getWageQuotaType()) {
                           detailDTO.setMete(detail.getTotalArea().multiply(p));
                        } else {
                           if (WmsWageQuotaTypeEnum.WMS_WEIGHT_PRICE.getType() != detail.getWageQuotaType()) {
                              throw new BusinessException("制成品计价方式类型不存在！");
                           }

                           detailDTO.setMete(detail.getTotalWeight().multiply(p));
                        }

                        detailDTO.setAmount(detail.getUnitPrice().multiply(e.getActualReceivedMete()).setScale(2, RoundingMode.HALF_UP));
                        detailDTO.setAmountExcludingVat(detail.getUnitPriceExcludingVat().multiply(e.getActualReceivedMete()).setScale(2, RoundingMode.HALF_UP));
                        detailDTO.setRejectAmount(detail.getUnitPrice().multiply(e.getRejectActualReceivedMete()).setScale(2, RoundingMode.HALF_UP));
                     } else {
                        detailDTO.setMete(detail.getMete().multiply(p));
                        detailDTO.setAmount(detail.getUnitPrice().multiply(e.getActualReceivedMete()).setScale(2, RoundingMode.HALF_UP));
                        detailDTO.setAmountExcludingVat(detail.getUnitPriceExcludingVat().multiply(e.getActualReceivedMete()).setScale(2, RoundingMode.HALF_UP));
                        detailDTO.setRejectAmount(detail.getUnitPrice().multiply(e.getRejectActualReceivedMete()).setScale(2, RoundingMode.HALF_UP));
                     }
                  } else if ((608 & detail.getBasicClass()) <= 0) {
                     detailDTO.setMete(e.getMete());
                     detailDTO.setAmount(detail.getUnitPrice().multiply(e.getActualReceivedMete()).setScale(2, RoundingMode.HALF_UP));
                     detailDTO.setAmountExcludingVat(detail.getUnitPriceExcludingVat().multiply(e.getActualReceivedMete()).setScale(2, RoundingMode.HALF_UP));
                     detailDTO.setRejectAmount(detail.getUnitPrice().multiply(e.getRejectActualReceivedMete()).setScale(2, RoundingMode.HALF_UP));
                  }

                  String specification = "";
                  if ((608 & detail.getBasicClass()) > 0) {
                     specification = detail.getSpecification();
                  } else {
                     if (ObjectUtil.isNotEmpty(detail.getThickness())) {
                        specification = detail.getThickness().stripTrailingZeros().toPlainString();
                     }

                     if (ObjectUtil.isNotEmpty(detail.getWidth())) {
                        specification = ObjectUtil.isEmpty(specification)
                           ? detail.getWidth().stripTrailingZeros().toPlainString()
                           : specification + "*" + detail.getWidth().stripTrailingZeros().toPlainString();
                     }

                     if (ObjectUtil.isNotEmpty(detail.getLength())) {
                        specification = ObjectUtil.isEmpty(specification)
                           ? detail.getLength().stripTrailingZeros().toPlainString()
                           : specification + "*" + detail.getLength().stripTrailingZeros().toPlainString();
                     }

                     if (ObjectUtil.isNotEmpty(detail.getSpecification())) {
                        specification = ObjectUtil.isEmpty(specification) ? detail.getSpecification() : specification + "*" + detail.getSpecification();
                     }
                  }

                  detailDTO.setSpecification(specification);
               }

               detailDTO.setRealityInboundAmount(
                  detailDTO.getAmount()
                     .add(ObjectUtil.isNotEmpty(detailDTO.getDifferentAmount()) ? detailDTO.getDifferentAmount() : BigDecimal.ZERO)
                     .subtract(ObjectUtil.isNotEmpty(detailDTO.getRejectAmount()) ? detailDTO.getRejectAmount() : BigDecimal.ZERO)
               );
               if (detailDTO.getQuantity() != null) {
                  detailDTO.setRealityQuantity(
                     detailDTO.getQuantity().subtract(ObjectUtil.isNotEmpty(detailDTO.getRejectQuantity()) ? detailDTO.getRejectQuantity() : BigDecimal.ZERO)
                  );
               }

               detailDTO.setRealityMete(
                  detailDTO.getMete().subtract(ObjectUtil.isNotEmpty(detailDTO.getRejectMete()) ? detailDTO.getRejectMete() : BigDecimal.ZERO)
               );
               return detailDTO;
            }
         )
         .collect(Collectors.toList());
   }

   @Override
   public List<PuchaseInboundDetailDTO> getFactoryInboundDetailList(Long orderId, List<Long> orderDetailIds) {
      List<Inbound> inbounds = this.baseMapper
         .selectList(Wrappers.lambdaQuery(Inbound.class).eq(Inbound::getPurchaseId, orderId).eq(Inbound::getReviewStatus, ReviewStatusEnum.REVIEWED.getType()));
      if (CollectionUtils.isEmpty(inbounds)) {
         return Collections.emptyList();
      }

      List<Long> inboundIds = inbounds.stream().map(Inbound::getId).collect(Collectors.toList());
      Map<Long, Inbound> inboundMap = inbounds.stream().collect(Collectors.toMap(Inbound::getId, Function.identity()));
      List<InboundDetail> inboundDetailList = this.inboundDetailService
         .list(
            Wrappers.lambdaQuery(InboundDetail.class)
               .in(InboundDetail::getInboundId, inboundIds)
               .in(CollectionUtil.isNotEmpty(orderDetailIds), InboundDetail::getPurchaseOrderDetailId, orderDetailIds)
               .orderByDesc(InboundDetail::getId)
         );
      if (CollectionUtils.isEmpty(inboundDetailList)) {
         return Collections.emptyList();
      }

      List<Long> inboundDetailIds = inboundDetailList.stream().map(InboundDetail::getId).collect(Collectors.toList());
      List<Reject> rejectList = this.rejectMapper
         .selectList(Wrappers.lambdaQuery(Reject.class).in(Reject::getInboundId, inboundIds).eq(Reject::getReviewStatus, ReviewStatusEnum.REVIEWED.getType()));
      List<RejectDetail> rejectDetailList = Collections.emptyList();
      if (CollectionUtils.isNotEmpty(rejectList)) {
         rejectDetailList = this.rejectDetailMapper
            .selectList(
               Wrappers.lambdaQuery(RejectDetail.class)
                  .in(RejectDetail::getRejectId, rejectList.stream().map(Reject::getId).collect(Collectors.toList()))
                  .in(CollectionUtil.isNotEmpty(orderDetailIds), RejectDetail::getInboundDetailId, inboundDetailIds)
            );
      }

      Map<Long, List<RejectDetail>> rejectDetailMap = rejectDetailList.stream().collect(Collectors.groupingBy(RejectDetail::getInboundDetailId));
      Map<Long, BigDecimal> inboundDetailIdAdjustAmountMap = this.wmsAdjustDetailService
         .list(
            Wrappers.lambdaQuery(WmsAdjustDetail.class)
               .in(WmsAdjustDetail::getInboundDetailId, inboundDetailIds)
               .eq(WmsAdjustDetail::getReviewStatus, ReviewStatusEnum.REVIEWED.getType())
         )
         .stream()
         .filter(ad -> ad.getDifferentAmount() != null)
         .collect(
            Collectors.groupingBy(
               WmsAdjustDetail::getInboundDetailId, Collectors.reducing(BigDecimal.ZERO, WmsAdjustDetail::getDifferentAmount, BigDecimal::add)
            )
         );
      Map<Long, ProjectInfo> projectMap = this.contractProjectService
         .listInfoByIdList(inboundDetailList.stream().map(InboundDetail::getProjectId).collect(Collectors.toSet()))
         .stream()
         .collect(Collectors.toMap(ProjectInfo::getId, Function.identity()));
      List<PuchaseInboundDetailDTO> dtos = new ArrayList<>();
      inboundDetailList.forEach(
         detail -> {
            Inbound inbound = inboundMap.get(detail.getInboundId());
            List<RejectDetail> rejectDetails = rejectDetailMap.get(detail.getId());
            rejectDetails = rejectDetails == null ? Collections.emptyList() : rejectDetails;
            PuchaseInboundDetailDTO build = PuchaseInboundDetailDTO.builder()
               .inboundId(detail.getInboundId())
               .inboundSerialNumber(inbound.getSerialNumber())
               .projectId(detail.getProjectId())
               .project(projectMap.get(detail.getProjectId()))
               .classifyId(detail.getClassifyId())
               .inboundDetailId(detail.getId())
               .basicClassEnum(detail.getBasicClass())
               .brand(detail.getBrand())
               .color(detail.getColor())
               .unit(detail.getMeasureUnit())
               .mete(detail.getMete())
               .quantity(detail.getQuantity())
               .accountingUnit(detail.getAccountingUnit())
               .price(detail.getUnitPriceNoFreight())
               .amount(detail.getAmountNoFreight())
               .priceExcludingVat(detail.getUnitPriceExcludingVatNoFreight())
               .amountExcludingVat(detail.getAmountExcludingVatNoFreight())
               .rejectAmount(
                  rejectDetails.stream()
                     .filter(rd -> rd.getAmountNoFreight() != null)
                     .map(RejectDetail::getAmountNoFreight)
                     .reduce(BigDecimal.ZERO, BigDecimal::add)
                     .setScale(2, RoundingMode.HALF_UP)
               )
               .rejectQuantity(
                  rejectDetails.stream().filter(rd -> rd.getQuantity() != null).map(RejectDetail::getQuantity).reduce(BigDecimal.ZERO, BigDecimal::add)
               )
               .rejectMete(rejectDetails.stream().filter(rd -> rd.getMete() != null).map(RejectDetail::getMete).reduce(BigDecimal.ZERO, BigDecimal::add))
               .differentAmount(inboundDetailIdAdjustAmountMap.getOrDefault(detail.getId(), BigDecimal.ZERO).setScale(2, RoundingMode.HALF_UP))
               .applicant(NameInfo.builder().id(inbound.getApplicantId()).name(inbound.getApplicantName()).build())
               .applicantDate(inbound.getCreateTime())
               .reviewer(NameInfo.builder().id(inbound.getReviewerId()).name(inbound.getReviewerName()).build())
               .reviewerDate(inbound.getReviewTime())
               .build();
            if (build.getQuantity() != null) {
               build.setRealityQuantity(
                  build.getQuantity().subtract(ObjectUtil.isNotEmpty(build.getRejectQuantity()) ? build.getRejectQuantity() : BigDecimal.ZERO)
               );
            }

            build.setRealityMete(build.getMete().subtract(ObjectUtil.isNotEmpty(build.getRejectMete()) ? build.getRejectMete() : BigDecimal.ZERO));
            build.setRealityInboundAmount(
               build.getAmount()
                  .add(ObjectUtil.isNotEmpty(build.getDifferentAmount()) ? build.getDifferentAmount() : BigDecimal.ZERO)
                  .subtract(ObjectUtil.isNotEmpty(build.getRejectAmount()) ? build.getRejectAmount() : BigDecimal.ZERO)
            );
            String specification = "";
            if (ObjectUtil.isNotEmpty(detail.getThickness())) {
               specification = detail.getThickness().stripTrailingZeros().toPlainString();
            }

            if (ObjectUtil.isNotEmpty(detail.getWidth())) {
               specification = ObjectUtil.isEmpty(specification)
                  ? detail.getWidth().stripTrailingZeros().toPlainString()
                  : specification + "*" + detail.getWidth().stripTrailingZeros().toPlainString();
            }

            if (ObjectUtil.isNotEmpty(detail.getLength())) {
               specification = ObjectUtil.isEmpty(specification)
                  ? detail.getLength().stripTrailingZeros().toPlainString()
                  : specification + "*" + detail.getLength().stripTrailingZeros().toPlainString();
            }

            if (ObjectUtil.isNotEmpty(detail.getSpecification())) {
               specification = ObjectUtil.isEmpty(specification) ? detail.getSpecification() : specification + "*" + detail.getSpecification();
            }

            build.setSpecification(specification);
            dtos.add(build);
         }
      );
      return dtos;
   }

   @Override
   public PrintVO<List<PuchaseInboundDetailDTO>> orderDetailV2Download(Long orderId, LocalDate startTime, LocalDate endTime) {
      PurchaseOrder order = this.purchaseOrderService.getById(orderId);
      Preconditions.checkArgument(order != null, "采购单不存在!");
      PrintVO<List<PuchaseInboundDetailDTO>> printVO = new PrintVO<>();
      List<ProjectInfo> projectInfoList = this.contractProjectService.listByIds(order.getProjectIds());
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("serialNumber", order.getSerialNumber());
      header.put("applicantName", order.getApplicantName());
      header.put("createTime", order.getCreateTime());
      header.put("branchCompany", this.branchCompanyService.getNameById(order.getBranchCompanyId()));
      header.put("supplier", this.supplierService.getNameById(order.getSupplierId()));
      header.put("project", projectInfoList.stream().map(s -> s.getSerialNumber() + "_" + s.getShortName()).collect(Collectors.joining("/")));
      header.put("amount", order.getAmount());
      header.put("mete", order.getMete());
      header.put("meteUnit", order.getMeteUnit());
      header.put(
         "settlementStatus", order.getSettlementStatus() != null && order.getSettlementStatus().equals(SettlementStatusEnum.SETTLED.getType()) ? "已结算" : "未结算"
      );
      header.put("settlementAmount", order.getSettlementAmount());
      header.put("inboundAmount", this.getActualInboundAmount(orderId, order.getOrderPlace(), order.getPurchaseType()).setScale(2, RoundingMode.HALF_UP));
      header.put("basicClass", BasicClassEnum.getNameStr(order.getBasicClass()).replace("、", "|"));
      BigDecimal freight1 = this.baseMapper
         .selectList(Wrappers.lambdaQuery(Inbound.class).eq(Inbound::getReviewStatus, ReviewStatusEnum.REVIEWED.getType()).eq(Inbound::getPurchaseId, orderId))
         .stream()
         .map(Inbound::getFreight)
         .filter(Objects::nonNull)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal freight2 = this.inboundManufacturedService
         .list(
            Wrappers.lambdaQuery(InboundManufactured.class)
               .eq(InboundManufactured::getReviewStatus, ReviewStatusEnum.REVIEWED.getType())
               .eq(InboundManufactured::getPurchaseId, orderId)
         )
         .stream()
         .map(InboundManufactured::getFreight)
         .filter(Objects::nonNull)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      header.put(
         "freight", LogisticsPayerEnum.DEMAND.getType().equals(order.getLogisticsPayerType()) ? freight1.add(freight2).setScale(2, RoundingMode.HALF_UP) : null
      );
      String logisticsPayerType = LogisticsPayerEnum.getNameByType(order.getLogisticsPayerType());
      header.put("logisticsPayerType", logisticsPayerType != null ? logisticsPayerType : "/");
      BigDecimal paymentAmount = this.supplierPaymentService
         .list(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .in(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .eq(SupplierPayment::getOrderId, orderId)
               .in(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(), SupplierPropertyTypeEnum.PURCHASE_FEE.getType())
         )
         .stream()
         .map(SupplierPayment::getActuallyPaymentAmount)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal invoiceAmount = this.supplierInvoiceService
         .list(
            Wrappers.lambdaQuery(SupplierInvoice.class)
               .eq(SupplierInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .eq(SupplierInvoice::getOrderId, orderId)
               .in(SupplierInvoice::getPropertyType, SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(), SupplierPropertyTypeEnum.PURCHASE_FEE.getType())
         )
         .stream()
         .map(SupplierInvoice::getActualInvoiceAmount)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      header.put("cumulativePayment", paymentAmount);
      BigDecimal paymentRate = order.getSettlementStatus() != null && order.getSettlementStatus().equals(SettlementStatusEnum.SETTLED.getType())
         ? paymentAmount.multiply(BigDecimal.valueOf(100L)).divide(order.getSettlementAmount(), 2, RoundingMode.HALF_UP)
         : (
            order.getAmount().compareTo(BigDecimal.ZERO) > 0
               ? paymentAmount.multiply(BigDecimal.valueOf(100L)).divide(order.getAmount(), 2, RoundingMode.HALF_UP)
               : BigDecimal.ZERO
         );
      header.put("paymentRate", paymentRate);
      header.put("cumulativeInvoice", invoiceAmount);
      BigDecimal invoiceRate = order.getSettlementStatus() != null && order.getSettlementStatus().equals(SettlementStatusEnum.SETTLED.getType())
         ? invoiceAmount.multiply(BigDecimal.valueOf(100L)).divide(order.getSettlementAmount(), 2, RoundingMode.HALF_UP)
         : (
            order.getAmount().compareTo(BigDecimal.ZERO) > 0
               ? invoiceAmount.multiply(BigDecimal.valueOf(100L)).divide(order.getAmount(), 2, RoundingMode.HALF_UP)
               : BigDecimal.ZERO
         );
      header.put("invoiceRate", invoiceRate);
      List<PuchaseInboundDetailDTO> dtoList = this.orderDetailV2(orderId, startTime, endTime);
      printVO.setTable(dtoList);
      printVO.setHeader(header);
      return printVO;
   }

   @Override
   public PrintVO<List<PuchaseInboundDetailDTO>> orderInboundDetailPrint(Long orderId, LocalDate startTime, LocalDate endTime) {
      PurchaseOrder order = this.purchaseOrderService.getById(orderId);
      Preconditions.checkArgument(order != null, "采购单不存在!");
      PrintVO<List<PuchaseInboundDetailDTO>> printVO = new PrintVO<>();
      List<ProjectInfo> projectInfoList = this.contractProjectService.listByIds(order.getProjectIds());
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("serialNumber", order.getSerialNumber());
      header.put("applicantName", order.getApplicantName());
      header.put("createTime", order.getCreateTime());
      header.put("branchCompany", this.branchCompanyService.getNameById(order.getBranchCompanyId()));
      header.put("supplier", this.supplierService.getNameById(order.getSupplierId()));
      header.put("project", projectInfoList.stream().map(s -> s.getSerialNumber() + "_" + s.getShortName()).collect(Collectors.joining("/")));
      header.put("amount", order.getAmount());
      header.put("mete", order.getMete());
      header.put("meteUnit", order.getMeteUnit());
      header.put(
         "settlementStatus", order.getSettlementStatus() != null && order.getSettlementStatus().equals(SettlementStatusEnum.SETTLED.getType()) ? "已结算" : "未结算"
      );
      header.put("settlementAmount", order.getSettlementAmount());
      header.put("inboundAmount", this.getActualInboundAmount(orderId, order.getOrderPlace(), order.getPurchaseType()).setScale(2, RoundingMode.HALF_UP));
      header.put("basicClass", BasicClassEnum.getNameStr(order.getBasicClass()).replace("、", "|"));
      BigDecimal freight1 = this.baseMapper
         .selectList(Wrappers.lambdaQuery(Inbound.class).eq(Inbound::getReviewStatus, ReviewStatusEnum.REVIEWED.getType()).eq(Inbound::getPurchaseId, orderId))
         .stream()
         .map(Inbound::getFreight)
         .filter(Objects::nonNull)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal freight2 = this.inboundManufacturedService
         .list(
            Wrappers.lambdaQuery(InboundManufactured.class)
               .eq(InboundManufactured::getReviewStatus, ReviewStatusEnum.REVIEWED.getType())
               .eq(InboundManufactured::getPurchaseId, orderId)
         )
         .stream()
         .map(InboundManufactured::getFreight)
         .filter(Objects::nonNull)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      header.put(
         "freight", LogisticsPayerEnum.DEMAND.getType().equals(order.getLogisticsPayerType()) ? freight1.add(freight2).setScale(2, RoundingMode.HALF_UP) : null
      );
      String logisticsPayerType = LogisticsPayerEnum.getNameByType(order.getLogisticsPayerType());
      header.put("logisticsPayerType", logisticsPayerType != null ? logisticsPayerType : "/");
      BigDecimal paymentAmount = this.supplierPaymentService
         .list(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .in(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .eq(SupplierPayment::getOrderId, orderId)
               .in(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(), SupplierPropertyTypeEnum.PURCHASE_FEE.getType())
         )
         .stream()
         .map(SupplierPayment::getActuallyPaymentAmount)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal invoiceAmount = this.supplierInvoiceService
         .list(
            Wrappers.lambdaQuery(SupplierInvoice.class)
               .eq(SupplierInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .eq(SupplierInvoice::getOrderId, orderId)
               .in(SupplierInvoice::getPropertyType, SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(), SupplierPropertyTypeEnum.PURCHASE_FEE.getType())
         )
         .stream()
         .map(SupplierInvoice::getActualInvoiceAmount)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      header.put("cumulativePayment", paymentAmount);
      BigDecimal paymentRate = order.getSettlementStatus() != null && order.getSettlementStatus().equals(SettlementStatusEnum.SETTLED.getType())
         ? paymentAmount.multiply(BigDecimal.valueOf(100L)).divide(order.getSettlementAmount(), 2, RoundingMode.HALF_UP)
         : (
            order.getAmount().compareTo(BigDecimal.ZERO) > 0
               ? paymentAmount.multiply(BigDecimal.valueOf(100L)).divide(order.getAmount(), 2, RoundingMode.HALF_UP)
               : BigDecimal.ZERO
         );
      header.put("paymentRate", paymentRate);
      header.put("cumulativeInvoice", invoiceAmount);
      BigDecimal invoiceRate = order.getSettlementStatus() != null && order.getSettlementStatus().equals(SettlementStatusEnum.SETTLED.getType())
         ? invoiceAmount.multiply(BigDecimal.valueOf(100L)).divide(order.getSettlementAmount(), 2, RoundingMode.HALF_UP)
         : (
            order.getAmount().compareTo(BigDecimal.ZERO) > 0
               ? invoiceAmount.multiply(BigDecimal.valueOf(100L)).divide(order.getAmount(), 2, RoundingMode.HALF_UP)
               : BigDecimal.ZERO
         );
      header.put("invoiceRate", invoiceRate);
      List<PuchaseInboundDetailDTO> dtoList = this.orderDetailV2(orderId, startTime, endTime);
      printVO.setTable(dtoList);
      printVO.setHeader(header);
      if (Boolean.FALSE.equals(order.getStandingBookIsPrint())) {
         order.setStandingBookIsPrint(Boolean.TRUE);
         this.purchaseOrderService.updateById(order);
      }

      return printVO;
   }

   @Override
   public BigDecimal getActualInboundAmount(Long orderId, Integer orderPlace, Integer purchaseType) {
      BigDecimal actualInboundAmount;
      if (PlaceEnum.FACTORY.getType().equals(orderPlace)) {
         if (purchaseType.equals(PurchaseEnum.MATERIAL.getType())) {
            BigDecimal inboundAmount = this.baseMapper
               .selectList(
                  Wrappers.lambdaQuery(Inbound.class).eq(Inbound::getReviewStatus, ReviewStatusEnum.REVIEWED.getType()).eq(Inbound::getPurchaseId, orderId)
               )
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
            BigDecimal adjustAmount = this.purchaseOrderService
               .getOrderIdAdjustAmountMap(Collections.singletonList(orderId))
               .getOrDefault(orderId, BigDecimal.ZERO);
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
            BigDecimal adjustAmount = this.purchaseOrderService
               .getOrderIdAdjustAmountMap(Collections.singletonList(orderId))
               .getOrDefault(orderId, BigDecimal.ZERO);
            actualInboundAmount = inboundManufacturedAmount.add(adjustAmount);
         }
      } else {
         List<PurchaseOrderDetail> orderDetailList = this.orderDetailService
            .list(Wrappers.lambdaQuery(PurchaseOrderDetail.class).in(PurchaseOrderDetail::getPurchaseId, orderId));
         actualInboundAmount = orderDetailList.stream()
            .filter(e -> e.getUnitPrice() != null)
            .filter(e -> e.getActualReceivedMete() != null)
            .map(orderDetail -> orderDetail.getActualReceivedMete().multiply(orderDetail.getUnitPrice()))
            .reduce(BigDecimal.ZERO, BigDecimal::add);
      }

      return actualInboundAmount;
   }

   @Override
   public Map<Long, BigDecimal> getPurchaseActualInboundAmountMap(Collection<Long> orderIds) {
      if (CollectionUtils.isEmpty(orderIds)) {
         return Collections.emptyMap();
      }

      Map<Long, BigDecimal> orderIdInboundAmountMap = this.baseMapper
         .selectList(Wrappers.lambdaQuery(Inbound.class).eq(Inbound::getReviewStatus, ReviewStatusEnum.REVIEWED.getType()).in(Inbound::getPurchaseId, orderIds))
         .stream()
         .filter(s -> s.getAmountNoFreight() != null)
         .collect(Collectors.groupingBy(Inbound::getPurchaseId, Collectors.reducing(BigDecimal.ZERO, Inbound::getAmountNoFreight, BigDecimal::add)));
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
      Map<Long, BigDecimal> orderIdRejectAmountMap = this.rejectService
         .list(Wrappers.lambdaQuery(Reject.class).eq(Reject::getReviewStatus, ReviewStatusEnum.REVIEWED.getType()).in(Reject::getPurchaseOrderId, orderIds))
         .stream()
         .filter(s -> s.getAmountNoFreight() != null)
         .collect(Collectors.groupingBy(Reject::getPurchaseOrderId, Collectors.reducing(BigDecimal.ZERO, Reject::getAmountNoFreight, BigDecimal::add)));
      Map<Long, BigDecimal> orderIdAdjustAmountMap = this.purchaseOrderService.getOrderIdAdjustAmountMap(orderIds);
      Map<Long, BigDecimal> orderDetailMap = this.orderDetailService
         .list(Wrappers.lambdaQuery(PurchaseOrderDetail.class).in(PurchaseOrderDetail::getPurchaseId, orderIds))
         .stream()
         .filter(s -> s.getUnitPrice() != null)
         .filter(s -> s.getActualReceivedMete() != null)
         .collect(
            Collectors.groupingBy(
               PurchaseOrderDetail::getPurchaseId,
               Collectors.reducing(BigDecimal.ZERO, s -> s.getActualReceivedMete().multiply(s.getUnitPrice()), BigDecimal::add)
            )
         );
      Map<Long, BigDecimal> actualInboundAmountMap = new HashMap<>(orderIds.size() * 2);
      orderIds.forEach(
         orderId -> {
            BigDecimal inboundAmount1 = orderIdInboundAmountMap.getOrDefault(orderId, BigDecimal.ZERO);
            BigDecimal inboundAmount2 = orderIdInboundManufacturedAmountMap.getOrDefault(orderId, BigDecimal.ZERO);
            BigDecimal inboundAmount3 = orderDetailMap.getOrDefault(orderId, BigDecimal.ZERO);
            BigDecimal adjustAmount = orderIdAdjustAmountMap.getOrDefault(orderId, BigDecimal.ZERO);
            BigDecimal actualInboundAmount = inboundAmount1.add(inboundAmount2)
               .add(inboundAmount3)
               .subtract(orderIdRejectAmountMap.getOrDefault(orderId, BigDecimal.ZERO))
               .add(adjustAmount)
               .setScale(4, RoundingMode.HALF_UP);
            actualInboundAmountMap.put(orderId, actualInboundAmount);
         }
      );
      return actualInboundAmountMap;
   }

   @Override
   public PageVO<PuchaseInboundDetailDTO> orderReconciliationDetailAll(QueryPurchaseInboundDetailDTOParam queryDTOParam, Integer pageNumber, Integer pageSize) {
      List<ReconciliationDetailDTO> reconciliationDetailDTOSAll = new ArrayList<>();
      if (queryDTOParam.getMaterialType() == 1) {
         queryDTOParam.setBasicClassBit(BasicClassEnum.getMaterialNum());
      } else if (queryDTOParam.getMaterialType() == 2) {
         queryDTOParam.setBasicClassBit(BasicClassEnum.getFinishedProductsNum());
      }

      List<ReconciliationDetailDTO> reconciliationDetailDTOS = this.inboundDetailService.orderReconciliationDetail(queryDTOParam);
      reconciliationDetailDTOSAll.addAll(CollectionUtil.isNotEmpty(reconciliationDetailDTOS) ? reconciliationDetailDTOS : new ArrayList<>());
      List<ReconciliationDetailDTO> reconciliationDetailDTOS1 = this.inboundDetailManufacturedService.orderReconciliationDetail(queryDTOParam);
      reconciliationDetailDTOSAll.addAll(CollectionUtil.isNotEmpty(reconciliationDetailDTOS1) ? reconciliationDetailDTOS1 : new ArrayList<>());
      List<ReconciliationDetailDTO> reconciliationDetailDTOS2 = this.projectReceivingRecordService.orderReconciliationDetail(queryDTOParam);
      reconciliationDetailDTOSAll.addAll(CollectionUtil.isNotEmpty(reconciliationDetailDTOS2) ? reconciliationDetailDTOS2 : new ArrayList<>());
      if (CollectionUtil.isEmpty(reconciliationDetailDTOSAll)) {
         return new PageVO<>(new ArrayList<>());
      }

      PageVO<PuchaseInboundDetailDTO> puchaseInboundDetailDTOPageVO = new PageVO<>();
      puchaseInboundDetailDTOPageVO.setTotalElements(reconciliationDetailDTOSAll.size());
      List<ReconciliationDetailDTO> collect = reconciliationDetailDTOSAll.stream()
         .sorted(Comparator.comparing(ReconciliationDetailDTO::getCreateTime).reversed())
         .skip((pageNumber - 1) * pageSize)
         .limit(pageSize.intValue())
         .collect(Collectors.toList());
      if (CollectionUtil.isEmpty(collect)) {
         int i = reconciliationDetailDTOSAll.size() % pageSize;
         if (i == 0) {
            pageNumber = reconciliationDetailDTOSAll.size() / pageSize;
         } else {
            pageNumber = reconciliationDetailDTOSAll.size() / pageSize + 1;
         }

         collect = reconciliationDetailDTOSAll.stream()
            .sorted(Comparator.comparing(ReconciliationDetailDTO::getCreateTime).reversed())
            .skip((pageNumber - 1) * pageSize)
            .limit(pageSize.intValue())
            .collect(Collectors.toList());
      }

      List<Long> purchaseIds = collect.stream().map(ReconciliationDetailDTO::getPurchaseId).filter(ObjectUtil::isNotEmpty).collect(Collectors.toList());
      List<PurchaseOrder> purchaseOrders = this.purchaseOrderService.listByIds(purchaseIds);
      List<Long> purchaseDetailIds = collect.stream()
         .map(ReconciliationDetailDTO::getPurchaseDetailId)
         .filter(ObjectUtil::isNotEmpty)
         .collect(Collectors.toList());
      List<PurchaseOrderDetail> purchaseOrderDetails = new ArrayList<>();
      if (CollectionUtil.isNotEmpty(purchaseDetailIds)) {
         purchaseOrderDetails = this.orderDetailService.listByIds(purchaseDetailIds);
      }

      List<Long> inboundDetailIds = collect.stream().filter(s -> s.getType() == 1).map(ReconciliationDetailDTO::getId).collect(Collectors.toList());
      List<Long> inboundDetailManufacturedIds = collect.stream().filter(s -> s.getType() == 2).map(ReconciliationDetailDTO::getId).collect(Collectors.toList());
      List<Long> projectReceivingRecordIds = collect.stream().filter(s -> s.getType() == 3).map(ReconciliationDetailDTO::getId).collect(Collectors.toList());
      List<InboundDetail> inboundDetails = new ArrayList<>();
      if (CollectionUtil.isNotEmpty(inboundDetailIds)) {
         inboundDetails = this.inboundDetailService.listByIds(inboundDetailIds);
      }

      List<InboundDetailManufactured> inboundDetailManufactureds = new ArrayList<>();
      if (CollectionUtil.isNotEmpty(inboundDetailManufacturedIds)) {
         inboundDetailManufactureds = this.inboundDetailManufacturedService.listByIds(inboundDetailManufacturedIds);
      }

      List<ProjectReceivingRecord> projectReceivingRecords = new ArrayList<>();
      if (CollectionUtil.isNotEmpty(projectReceivingRecordIds)) {
         projectReceivingRecords = this.projectReceivingRecordService.listByIds(projectReceivingRecordIds);
      }

      List<PuchaseInboundDetailDTO> puchaseInboundDetailDTOS = this.convertPuchaseInboundDetail(
         purchaseOrders, purchaseOrderDetails, inboundDetails, inboundDetailManufactureds, projectReceivingRecords
      );
      List<PuchaseInboundDetailDTO> sortPuchaseInboundDetailDTO = new ArrayList<>();

      for (ReconciliationDetailDTO reconciliationDetailDTO : collect) {
         PuchaseInboundDetailDTO puchaseInboundDetailDTO = puchaseInboundDetailDTOS.stream()
            .filter(p -> p.getId().equals(reconciliationDetailDTO.getId()) && p.getType() == reconciliationDetailDTO.getType())
            .findAny()
            .orElse(null);
         sortPuchaseInboundDetailDTO.add(puchaseInboundDetailDTO);
      }

      puchaseInboundDetailDTOPageVO.setContent(sortPuchaseInboundDetailDTO);
      if (pageSize.intValue() >= puchaseInboundDetailDTOPageVO.getTotalElements()) {
         puchaseInboundDetailDTOPageVO.setHasNextPage(false);
         puchaseInboundDetailDTOPageVO.setHasPreviousPage(false);
      } else {
         if (pageNumber == 1) {
            puchaseInboundDetailDTOPageVO.setHasPreviousPage(false);
         } else {
            puchaseInboundDetailDTOPageVO.setHasPreviousPage(true);
         }

         puchaseInboundDetailDTOPageVO.setHasNextPage(hasNextPage(puchaseInboundDetailDTOPageVO.getTotalElements(), pageNumber, pageSize));
      }

      return puchaseInboundDetailDTOPageVO;
   }

   @Override
   public PrintVO<List<PuchaseInboundDetailDTO>> printOrderReconciliationDetailAll(QueryPurchaseInboundDetailDTOParam queryDTOParam) {
      PrintVO<List<PuchaseInboundDetailDTO>> vo = new PrintVO<>();
      Map<String, Object> header = vo.initHeader(UserUtil.getCurrentName());
      vo.setHeader(header);
      List<ReconciliationDetailDTO> reconciliationDetailDTOSAll = new ArrayList<>();
      if (queryDTOParam.getMaterialType() == 1) {
         queryDTOParam.setBasicClassBit(BasicClassEnum.getMaterialNum());
      } else if (queryDTOParam.getMaterialType() == 2) {
         queryDTOParam.setBasicClassBit(BasicClassEnum.getFinishedProductsNum());
      }

      List<ReconciliationDetailDTO> reconciliationDetailDTOS = this.inboundDetailService.orderReconciliationDetail(queryDTOParam);
      reconciliationDetailDTOSAll.addAll(CollectionUtil.isNotEmpty(reconciliationDetailDTOS) ? reconciliationDetailDTOS : new ArrayList<>());
      List<ReconciliationDetailDTO> reconciliationDetailDTOS1 = this.inboundDetailManufacturedService.orderReconciliationDetail(queryDTOParam);
      reconciliationDetailDTOSAll.addAll(CollectionUtil.isNotEmpty(reconciliationDetailDTOS1) ? reconciliationDetailDTOS1 : new ArrayList<>());
      List<ReconciliationDetailDTO> reconciliationDetailDTOS2 = this.projectReceivingRecordService.orderReconciliationDetail(queryDTOParam);
      reconciliationDetailDTOSAll.addAll(CollectionUtil.isNotEmpty(reconciliationDetailDTOS2) ? reconciliationDetailDTOS2 : new ArrayList<>());
      if (CollectionUtil.isEmpty(reconciliationDetailDTOSAll)) {
         return vo;
      }

      List<ReconciliationDetailDTO> collect = reconciliationDetailDTOSAll.stream()
         .sorted(Comparator.comparing(ReconciliationDetailDTO::getCreateTime).reversed())
         .collect(Collectors.toList());
      List<Long> purchaseIds = collect.stream().map(ReconciliationDetailDTO::getPurchaseId).filter(ObjectUtil::isNotEmpty).collect(Collectors.toList());
      List<PurchaseOrder> purchaseOrders = this.purchaseOrderService.listByIds(purchaseIds);
      List<Long> purchaseDetailIds = collect.stream()
         .map(ReconciliationDetailDTO::getPurchaseDetailId)
         .filter(ObjectUtil::isNotEmpty)
         .collect(Collectors.toList());
      List<PurchaseOrderDetail> purchaseOrderDetails = new ArrayList<>();
      if (CollectionUtil.isNotEmpty(purchaseDetailIds)) {
         purchaseOrderDetails = this.orderDetailService.listByIds(purchaseDetailIds);
      }

      List<Long> inboundDetailIds = collect.stream().filter(s -> s.getType() == 1).map(ReconciliationDetailDTO::getId).collect(Collectors.toList());
      List<Long> inboundDetailManufacturedIds = collect.stream().filter(s -> s.getType() == 2).map(ReconciliationDetailDTO::getId).collect(Collectors.toList());
      List<Long> projectReceivingRecordIds = collect.stream().filter(s -> s.getType() == 3).map(ReconciliationDetailDTO::getId).collect(Collectors.toList());
      List<InboundDetail> inboundDetails = new ArrayList<>();
      if (CollectionUtil.isNotEmpty(inboundDetailIds)) {
         inboundDetails = this.inboundDetailService.listByIds(inboundDetailIds);
      }

      List<InboundDetailManufactured> inboundDetailManufactureds = new ArrayList<>();
      if (CollectionUtil.isNotEmpty(inboundDetailManufacturedIds)) {
         inboundDetailManufactureds = this.inboundDetailManufacturedService.listByIds(inboundDetailManufacturedIds);
      }

      List<ProjectReceivingRecord> projectReceivingRecords = new ArrayList<>();
      if (CollectionUtil.isNotEmpty(projectReceivingRecordIds)) {
         projectReceivingRecords = this.projectReceivingRecordService.listByIds(projectReceivingRecordIds);
      }

      List<PuchaseInboundDetailDTO> puchaseInboundDetailDTOS = this.convertPuchaseInboundDetail(
         purchaseOrders, purchaseOrderDetails, inboundDetails, inboundDetailManufactureds, projectReceivingRecords
      );
      List<PuchaseInboundDetailDTO> sortPuchaseInboundDetailDTO = new ArrayList<>();

      for (ReconciliationDetailDTO reconciliationDetailDTO : collect) {
         PuchaseInboundDetailDTO puchaseInboundDetailDTO = puchaseInboundDetailDTOS.stream()
            .filter(p -> p.getId().equals(reconciliationDetailDTO.getId()) && p.getType() == reconciliationDetailDTO.getType())
            .findAny()
            .orElse(null);
         sortPuchaseInboundDetailDTO.add(puchaseInboundDetailDTO);
      }

      vo.setTable(sortPuchaseInboundDetailDTO);
      return vo;
   }

   private List<PuchaseInboundDetailDTO> convertPuchaseInboundDetail(
      List<PurchaseOrder> purchaseOrders,
      List<PurchaseOrderDetail> purchaseOrderDetails,
      List<InboundDetail> inboundDetails,
      List<InboundDetailManufactured> inboundDetailManufactureds,
      List<ProjectReceivingRecord> projectReceivingRecords
   ) {
      List<PuchaseInboundDetailDTO> puchaseInboundDetailDTOS = new ArrayList<>();
      List<Long> supplierIds = purchaseOrders.stream().map(PurchaseOrder::getSupplierId).filter(ObjectUtil::isNotEmpty).collect(Collectors.toList());
      Map<Long, SupplierAllBriefDTO> supplierMap = this.supplierService
         .getListBriefByIds(supplierIds)
         .stream()
         .collect(Collectors.toMap(SupplierAllBriefDTO::getId, Function.identity()));
      if (CollectionUtil.isNotEmpty(inboundDetails)) {
         List<Long> inboundIds = inboundDetails.stream().map(InboundDetail::getInboundId).distinct().collect(Collectors.toList());
         Map<Long, Inbound> inboundMap = this.baseMapper.selectBatchIds(inboundIds).stream().collect(Collectors.toMap(Inbound::getId, Function.identity()));
         List<Reject> rejectList = this.rejectMapper
            .selectList(
               Wrappers.lambdaQuery(Reject.class).in(Reject::getInboundId, inboundIds).eq(Reject::getReviewStatus, ReviewStatusEnum.REVIEWED.getType())
            );
         List<RejectDetail> rejectDetailList = Collections.emptyList();
         if (CollectionUtils.isNotEmpty(rejectList)) {
            rejectDetailList = this.rejectDetailMapper
               .selectList(
                  Wrappers.lambdaQuery(RejectDetail.class).in(RejectDetail::getRejectId, rejectList.stream().map(Reject::getId).collect(Collectors.toList()))
               );
         }

         Map<Long, BigDecimal> inboundDetailIdRejectAmountMap = rejectDetailList.stream()
            .filter(rd -> rd.getAmountNoFreight() != null)
            .collect(
               Collectors.groupingBy(RejectDetail::getInboundDetailId, Collectors.reducing(BigDecimal.ZERO, RejectDetail::getAmountNoFreight, BigDecimal::add))
            );
         Map<Long, BigDecimal> inboundDetailIdAdjustAmountMap = this.wmsAdjustDetailService
            .list(
               Wrappers.lambdaQuery(WmsAdjustDetail.class)
                  .in(WmsAdjustDetail::getInboundDetailId, inboundDetails.stream().map(InboundDetail::getId).collect(Collectors.toList()))
                  .eq(WmsAdjustDetail::getReviewStatus, ReviewStatusEnum.REVIEWED.getType())
            )
            .stream()
            .filter(ad -> ad.getDifferentAmount() != null)
            .collect(
               Collectors.groupingBy(
                  WmsAdjustDetail::getInboundDetailId, Collectors.reducing(BigDecimal.ZERO, WmsAdjustDetail::getDifferentAmount, BigDecimal::add)
               )
            );
         Map<Long, ProjectInfo> projectMap = this.contractProjectService
            .listInfoByIdList(inboundDetails.stream().map(InboundDetail::getProjectId).collect(Collectors.toSet()))
            .stream()
            .collect(Collectors.toMap(ProjectInfo::getId, Function.identity()));
         List<PuchaseInboundDetailDTO> dtos = new ArrayList<>();
         inboundDetails.forEach(
            detail -> {
               Inbound inbound = inboundMap.get(detail.getInboundId());
               PurchaseOrder purchaseOrder = purchaseOrders.stream().filter(p -> p.getId().equals(inbound.getPurchaseId())).findAny().orElse(null);
               PuchaseInboundDetailDTO build = PuchaseInboundDetailDTO.builder()
                  .id(detail.getId())
                  .inboundId(detail.getInboundId())
                  .inboundSerialNumber(inbound.getSerialNumber())
                  .purchaseSerialNumber(ObjectUtil.isNotEmpty(purchaseOrder) ? purchaseOrder.getSerialNumber() : null)
                  .projectId(detail.getProjectId())
                  .project(projectMap.get(detail.getProjectId()))
                  .classifyId(detail.getClassifyId())
                  .inboundDetailId(detail.getId())
                  .basicClassEnum(detail.getBasicClass())
                  .brand(detail.getBrand())
                  .color(detail.getColor())
                  .unit(detail.getMeasureUnit())
                  .mete(detail.getMete())
                  .quantity(detail.getQuantity())
                  .accountingUnit(detail.getAccountingUnit())
                  .price(detail.getUnitPriceNoFreight())
                  .amount(detail.getAmountNoFreight())
                  .priceExcludingVat(detail.getUnitPriceExcludingVatNoFreight())
                  .amountExcludingVat(detail.getAmountExcludingVatNoFreight())
                  .rejectAmount(inboundDetailIdRejectAmountMap.getOrDefault(detail.getId(), BigDecimal.ZERO).setScale(2, RoundingMode.HALF_UP))
                  .differentAmount(inboundDetailIdAdjustAmountMap.getOrDefault(detail.getId(), BigDecimal.ZERO).setScale(2, RoundingMode.HALF_UP))
                  .applicant(NameInfo.builder().id(inbound.getApplicantId()).name(inbound.getApplicantName()).build())
                  .applicantDate(inbound.getCreateTime())
                  .reviewer(NameInfo.builder().id(inbound.getReviewerId()).name(inbound.getReviewerName()).build())
                  .reviewerDate(inbound.getReviewTime())
                  .type(1)
                  .supplier(supplierMap.get(purchaseOrder.getSupplierId()))
                  .classifyName(detail.getClassifyName())
                  .build();
               build.setRealityInboundAmount(
                  build.getAmount()
                     .add(ObjectUtil.isNotEmpty(build.getDifferentAmount()) ? build.getDifferentAmount() : BigDecimal.ZERO)
                     .subtract(ObjectUtil.isNotEmpty(build.getRejectAmount()) ? build.getRejectAmount() : BigDecimal.ZERO)
               );
               String specification = "";
               if (ObjectUtil.isNotEmpty(detail.getThickness())) {
                  specification = detail.getThickness() + "";
               }

               if (ObjectUtil.isNotEmpty(detail.getWidth())) {
                  specification = ObjectUtil.isEmpty(specification) ? detail.getWidth() + "" : specification + "*" + detail.getWidth();
               }

               if (ObjectUtil.isNotEmpty(detail.getLength())) {
                  specification = ObjectUtil.isEmpty(specification) ? detail.getLength() + "" : specification + "*" + detail.getLength();
               }

               if (ObjectUtil.isNotEmpty(detail.getSpecification())) {
                  specification = ObjectUtil.isEmpty(specification) ? detail.getSpecification() + "" : specification + "*" + detail.getSpecification();
               }

               build.setSpecification(specification);
               dtos.add(build);
            }
         );
         puchaseInboundDetailDTOS.addAll(dtos);
      }

      if (CollectionUtils.isNotEmpty(inboundDetailManufactureds)) {
         List<Long> inboundManufacturedIds = inboundDetailManufactureds.stream()
            .map(InboundDetailManufactured::getInboundManufacturedId)
            .collect(Collectors.toList());
         List<InboundManufactured> inboundManufactureds = this.inboundManufacturedService.listByIds(inboundManufacturedIds);
         if (CollectionUtils.isEmpty(inboundManufactureds)) {
            return Collections.emptyList();
         }

         List<Long> inboundIds = inboundManufactureds.stream().map(InboundManufactured::getId).collect(Collectors.toList());
         Map<Long, InboundManufactured> inboundManufacturedMap = inboundManufactureds.stream()
            .collect(Collectors.toMap(InboundManufactured::getId, Function.identity()));
         List<WmsApproveRecord> approveRecordList = this.wmsApproveRecordService
            .listByIds(inboundManufactureds.stream().map(InboundManufactured::getApproveRecordId).collect(Collectors.toList()));
         Map<Long, Long> approveRecordIdUserIdMap = approveRecordList.stream()
            .collect(Collectors.toMap(WmsApproveRecord::getId, WmsApproveRecord::getLastApproverId));
         Map<Long, String> reviewUserMap = this.userService
            .listByIds(approveRecordList.stream().map(WmsApproveRecord::getLastApproverId).collect(Collectors.toSet()))
            .stream()
            .collect(Collectors.toMap(User::getId, User::getName));
         Map<Long, ProjectInfo> projectMap = this.contractProjectService
            .listInfoByIdList(inboundDetailManufactureds.stream().map(InboundDetailManufactured::getProjectId).collect(Collectors.toSet()))
            .stream()
            .collect(Collectors.toMap(ProjectInfo::getId, Function.identity()));
         List<PuchaseInboundDetailDTO> dtos = new ArrayList<>();
         inboundDetailManufactureds.forEach(
            detail -> {
               InboundManufactured inboundManufactured = inboundManufacturedMap.get(detail.getInboundManufacturedId());
               PurchaseOrder purchaseOrder = purchaseOrders.stream().filter(p -> p.getId().equals(inboundManufactured.getPurchaseId())).findAny().orElse(null);
               List<PurchaseOrderDetail> purchaseOrderDetailList = purchaseOrderDetails.stream()
                  .filter(p -> p.getId().equals(detail.getPurchaseOrderDetailId()))
                  .collect(Collectors.toList());
               BigDecimal mete;
               if (detail.getWageQuotaType().equals(WmsWageQuotaTypeEnum.WMS_WEIGHT_PRICE.getType())) {
                  mete = detail.getTotalWeight();
               } else if (detail.getWageQuotaType().equals(WmsWageQuotaTypeEnum.WMS_LENGTH_PRICE.getType())) {
                  mete = detail.getTotalLength();
               } else if (detail.getWageQuotaType().equals(WmsWageQuotaTypeEnum.WMS_AREA_PRICE.getType())) {
                  mete = detail.getTotalArea();
               } else {
                  mete = detail.getQuantity();
               }

               PuchaseInboundDetailDTO build = PuchaseInboundDetailDTO.builder()
                  .id(detail.getId())
                  .inboundId(detail.getInboundManufacturedId())
                  .inboundSerialNumber(inboundManufactured.getSerialNumber())
                  .purchaseSerialNumber(ObjectUtil.isNotEmpty(purchaseOrder) ? purchaseOrder.getSerialNumber() : null)
                  .projectId(detail.getProjectId())
                  .project(projectMap.get(detail.getProjectId()))
                  .classifyId(null)
                  .inboundDetailId(detail.getId())
                  .basicClassEnum(detail.getBasicClass())
                  .unit(null)
                  .brand(detail.getBrand())
                  .color(detail.getColor())
                  .mete(mete)
                  .quantity(detail.getQuantity())
                  .accountingUnit(null)
                  .wageQuotaType(detail.getWageQuotaType())
                  .manufacturedName(detail.getManufacturedName())
                  .manufacturedSn(detail.getManufacturedSn())
                  .price(detail.getUnitPrice())
                  .amount(detail.getAmount())
                  .priceExcludingVat(detail.getUnitPriceExcludingVat())
                  .amountExcludingVat(detail.getAmountExcludingVat())
                  .rejectAmount(null)
                  .differentAmount(null)
                  .applicant(NameInfo.builder().id(inboundManufactured.getApplicantId()).name(inboundManufactured.getApplicantName()).build())
                  .applicantDate(inboundManufactured.getCreateTime())
                  .reviewer(
                     NameInfo.builder()
                        .id(approveRecordIdUserIdMap.get(inboundManufactured.getApproveRecordId()))
                        .name(reviewUserMap.get(approveRecordIdUserIdMap.get(inboundManufactured.getApproveRecordId())))
                        .build()
                  )
                  .reviewerDate(inboundManufactured.getReviewPassTime())
                  .type(2)
                  .supplier(supplierMap.get(purchaseOrder.getSupplierId()))
                  .finishedGoodsTypeName(purchaseOrderDetailList.get(0).getFinishedGoodsTypeName())
                  .material(detail.getMaterial())
                  .build();
               build.setRealityInboundAmount(
                  build.getAmount()
                     .add(ObjectUtil.isNotEmpty(build.getDifferentAmount()) ? build.getDifferentAmount() : BigDecimal.ZERO)
                     .subtract(ObjectUtil.isNotEmpty(build.getRejectAmount()) ? build.getRejectAmount() : BigDecimal.ZERO)
               );
               String specification = "";
               if (ObjectUtil.isNotEmpty(detail.getThickness())) {
                  specification = detail.getThickness() + "";
               }

               if (ObjectUtil.isNotEmpty(detail.getWidth())) {
                  specification = ObjectUtil.isEmpty(specification) ? detail.getWidth() + "" : specification + "*" + detail.getWidth();
               }

               if (ObjectUtil.isNotEmpty(detail.getLength())) {
                  specification = ObjectUtil.isEmpty(specification) ? detail.getLength() + "" : specification + "*" + detail.getLength();
               }

               if (ObjectUtil.isNotEmpty(detail.getSpecification())) {
                  specification = ObjectUtil.isEmpty(specification) ? detail.getSpecification() + "" : specification + "*" + detail.getSpecification();
               }

               build.setSpecification(specification);
               dtos.add(build);
            }
         );
         puchaseInboundDetailDTOS.addAll(dtos);
      }

      if (CollectionUtils.isNotEmpty(projectReceivingRecords)) {
         List<Long> detailIds = projectReceivingRecords.stream().map(ProjectReceivingRecord::getPurchaseDetailsId).distinct().collect(Collectors.toList());
         Map<Long, PurchaseOrderDetail> detailMap = purchaseOrderDetails.stream()
            .filter(p -> detailIds.contains(p.getId()))
            .collect(Collectors.toMap(PurchaseOrderDetail::getId, Function.identity()));
         List<Long> purchaseIds = detailMap.values().stream().map(PurchaseOrderDetail::getPurchaseId).distinct().collect(Collectors.toList());
         Map<Long, PurchaseOrder> purchaseOrderMap = purchaseOrders.stream()
            .filter(p -> purchaseIds.contains(p.getId()))
            .collect(Collectors.toMap(PurchaseOrder::getId, Function.identity()));
         List<Long> projectIds = purchaseOrders.stream()
            .filter(p -> ObjectUtil.isNotEmpty(p.getProjectIds()))
            .flatMap(p -> Arrays.stream(p.getProjectIds().split(",")).map(Long::valueOf))
            .collect(Collectors.toList());
         Map<Long, ProjectInfo> projectMap = this.contractProjectService
            .listSimpleByIdList(projectIds)
            .stream()
            .collect(Collectors.toMap(ProjectInfo::getId, Function.identity()));
         List<ConstructionInboundDetailDTO> constructionInboundDetailDTOList = this.reportService.getConstructionInboundDetailList(detailIds);
         List<PuchaseInboundDetailDTO> collect = constructionInboundDetailDTOList.stream()
            .map(
               e -> {
                  PurchaseOrderDetail purchaseOrderDetail = detailMap.get(e.getPurchaseDetailId());
                  PurchaseOrder purchaseOrder = purchaseOrderMap.get(purchaseOrderDetail.getPurchaseId());
                  PuchaseInboundDetailDTO detailDTO = BeanUtil.copy(e, PuchaseInboundDetailDTO.class);
                  if (detailMap.containsKey(e.getPurchaseDetailId())) {
                     PurchaseOrderDetail detail = detailMap.get(e.getPurchaseDetailId());
                     detailDTO.setId(e.getId());
                     detailDTO.setPurchaseSerialNumber(ObjectUtil.isNotEmpty(purchaseOrder) ? purchaseOrder.getSerialNumber() : null);
                     detailDTO.setProjectId(detail.getProjectId());
                     detailDTO.setProject(projectMap.get(detail.getProjectId()));
                     detailDTO.setClassifyId(detail.getClassifyId());
                     detailDTO.setBasicClassEnum(detail.getBasicClass());
                     detailDTO.setManufacturedName(detail.getManufacturedName());
                     detailDTO.setManufacturedType(detail.getManufacturedType());
                     detailDTO.setWageQuotaType(detail.getWageQuotaType());
                     detailDTO.setBrand(detail.getBrand());
                     detailDTO.setColor(detail.getColor());
                     detailDTO.setActualReceivedMete(e.getActualReceivedMete());
                     detailDTO.setPrice(detail.getUnitPrice());
                     detailDTO.setPriceExcludingVat(detail.getUnitPriceExcludingVat());
                     detailDTO.setReviewerDate(e.getApplicantDate());
                     detailDTO.setReviewer(e.getApplicant());
                     detailDTO.setType(3);
                     detailDTO.setSupplier(supplierMap.get(purchaseOrder.getSupplierId()));
                     detailDTO.setClassifyName(detail.getClassifyName());
                     if (e.getQuantity() != null && e.getQuantity().compareTo(BigDecimal.valueOf(0L)) > 0) {
                        BigDecimal p = e.getQuantity().divide(detail.getQuantity(), 20, 4);
                        if ((608 & detail.getBasicClass()) > 0) {
                           if (WmsWageQuotaTypeEnum.WMS_QUANTITY_PRICE.getType() == detail.getWageQuotaType()) {
                              detailDTO.setMete(detail.getQuantity().multiply(p).setScale(0, 4));
                           } else if (WmsWageQuotaTypeEnum.WMS_LENGTH_PRICE.getType() == detail.getWageQuotaType()) {
                              detailDTO.setMete(detail.getTotalLength().multiply(p));
                           } else if (WmsWageQuotaTypeEnum.WMS_AREA_PRICE.getType() == detail.getWageQuotaType()) {
                              detailDTO.setMete(detail.getTotalArea().multiply(p));
                           } else {
                              if (WmsWageQuotaTypeEnum.WMS_WEIGHT_PRICE.getType() != detail.getWageQuotaType()) {
                                 throw new BusinessException("制成品计价方式类型不存在！");
                              }

                              detailDTO.setMete(detail.getTotalWeight().multiply(p));
                           }

                           detailDTO.setAmount(detail.getUnitPrice().multiply(e.getActualReceivedMete()).setScale(2, RoundingMode.HALF_UP));
                           detailDTO.setAmountExcludingVat(
                              detail.getUnitPriceExcludingVat().multiply(e.getActualReceivedMete()).setScale(2, RoundingMode.HALF_UP)
                           );
                           detailDTO.setRejectAmount(detail.getUnitPrice().multiply(e.getRejectActualReceivedMete()).setScale(2, RoundingMode.HALF_UP));
                        } else {
                           detailDTO.setMete(detail.getMete().multiply(p));
                           detailDTO.setAmount(detail.getUnitPrice().multiply(e.getActualReceivedMete()).setScale(2, RoundingMode.HALF_UP));
                           detailDTO.setAmountExcludingVat(
                              detail.getUnitPriceExcludingVat().multiply(e.getActualReceivedMete()).setScale(2, RoundingMode.HALF_UP)
                           );
                           detailDTO.setRejectAmount(detail.getUnitPrice().multiply(e.getRejectActualReceivedMete()).setScale(2, RoundingMode.HALF_UP));
                        }
                     } else if ((608 & detail.getBasicClass()) <= 0) {
                        detailDTO.setMete(e.getMete());
                        detailDTO.setAmount(detail.getUnitPrice().multiply(e.getActualReceivedMete()).setScale(2, RoundingMode.HALF_UP));
                        detailDTO.setAmountExcludingVat(detail.getUnitPriceExcludingVat().multiply(e.getActualReceivedMete()).setScale(2, RoundingMode.HALF_UP));
                        detailDTO.setRejectAmount(detail.getUnitPrice().multiply(e.getRejectActualReceivedMete()).setScale(2, RoundingMode.HALF_UP));
                     }

                     String specification = "";
                     if ((608 & detail.getBasicClass()) > 0) {
                        specification = detail.getSpecification();
                     } else {
                        if (ObjectUtil.isNotEmpty(detail.getThickness())) {
                           specification = detail.getThickness() + "";
                        }

                        if (ObjectUtil.isNotEmpty(detail.getWidth())) {
                           specification = ObjectUtil.isEmpty(specification) ? detail.getWidth() + "" : specification + "*" + detail.getWidth();
                        }

                        if (ObjectUtil.isNotEmpty(detail.getLength())) {
                           specification = ObjectUtil.isEmpty(specification) ? detail.getLength() + "" : specification + "*" + detail.getLength();
                        }

                        if (ObjectUtil.isNotEmpty(detail.getSpecification())) {
                           specification = ObjectUtil.isEmpty(specification) ? detail.getSpecification() + "" : specification + "*" + detail.getSpecification();
                        }
                     }

                     detailDTO.setSpecification(specification);
                  }

                  detailDTO.setRealityInboundAmount(
                     detailDTO.getAmount()
                        .add(ObjectUtil.isNotEmpty(detailDTO.getDifferentAmount()) ? detailDTO.getDifferentAmount() : BigDecimal.ZERO)
                        .subtract(ObjectUtil.isNotEmpty(detailDTO.getRejectAmount()) ? detailDTO.getRejectAmount() : BigDecimal.ZERO)
                  );
                  return detailDTO;
               }
            )
            .collect(Collectors.toList());
         puchaseInboundDetailDTOS.addAll(collect);
      }

      return puchaseInboundDetailDTOS;
   }

   public static boolean hasNextPage(long totalRecords, int pageSize, int currentPage) {
      long totalPages = (totalRecords + pageSize - 1L) / pageSize;
      return currentPage < totalPages;
   }

   @Override
   public void orderDetailDownload(Long orderId, HttpServletResponse response) {
      PurchaseOrder order = this.purchaseOrderService.getById(orderId);
      if (order != null) {
         List<PuchaseInboundDetailDTO> dtoList = this.orderDetailV3(orderId);
         if (!CollectionUtils.isEmpty(dtoList)) {
            String title = "";
            if (order.getBranchCompanyId() != null) {
               BranchCompany branchCompany = this.branchCompanyService.getById(order.getBranchCompanyId());
               if (branchCompany != null) {
                  title = title + "分支机构：" + branchCompany.getName() + "\n";
               }
            }

            title = title + "采购单号：" + order.getSerialNumber() + "\n";
            title = title + "合同额：" + order.getAmount().stripTrailingZeros().toPlainString() + "\n";
            BigDecimal inboundAmount = this.getActualInboundAmount(order.getId(), order.getOrderPlace(), order.getPurchaseType());
            title = title + "入库额：" + inboundAmount.stripTrailingZeros().toPlainString() + "\n";
            AtomicInteger index = new AtomicInteger(0);
            List<List<String>> headList = new ArrayList<>();
            headList.add(Arrays.asList(title, "序号"));
            headList.add(Arrays.asList(title, "物料种类"));
            headList.add(Arrays.asList(title, "规格"));
            headList.add(Arrays.asList(title, "单位"));
            headList.add(Arrays.asList(title, "数量"));
            headList.add(Arrays.asList(title, "单价"));
            headList.add(Arrays.asList(title, "金额"));
            headList.add(Arrays.asList(title, "退货金额"));
            headList.add(Arrays.asList(title, "办理人"));
            headList.add(Arrays.asList(title, "入库日期"));
            List<List<Object>> dataList = new ArrayList<>();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            BasicShowConfig basicShowConfig = this.basicConfigService.getBasicShowConfig();
            dtoList.forEach(
               ex -> {
                  List<Object> data = new ArrayList<>();
                  data.add(index.incrementAndGet());
                  if (ex.getClassifyId() != null) {
                     Classification classification = this.classificationService.getById(ex.getClassifyId());
                     data.add(classification.getName());
                  } else {
                     data.add(ex.getManufacturedName());
                  }

                  if (ex.getClassifyId() != null) {
                     DownLoadDetailDO copy = BeanUtil.copy(ex, DownLoadDetailDO.class);
                     copy.setBasicClass(ex.getBasicClassEnum());
                     String spec = this.queryUtil.getConfigShowSpec(JSON.toJSONString(copy), basicShowConfig);
                     data.add(spec);
                  } else {
                     data.add(ex.getSpecification());
                  }

                  data.add(ex.getAccountingUnit());
                  if (ex.getClassifyId() != null) {
                     SubjectMeasureDTO subjectMeasureDTO = this.measureService.measureListById(ex.getClassifyId());
                     Map<Integer, BigDecimal> unitConversion = this.unitConversion(
                        BigDecimal.ZERO, subjectMeasureDTO.getAccountingUnit(), subjectMeasureDTO.getAccountingPrecision()
                     );
                     BigDecimal convertMete = ex.getMete().divide(unitConversion.get(2), subjectMeasureDTO.getAccountingPrecision(), RoundingMode.HALF_UP);
                     data.add(convertMete);
                     data.add(ex.getPrice().multiply(unitConversion.get(2)));
                  } else if (WmsWageQuotaTypeEnum.WMS_QUANTITY_PRICE.getType() == ex.getWageQuotaType()) {
                     data.add(ex.getMete());
                     data.add(ex.getPrice().setScale(2, RoundingMode.HALF_UP));
                  } else if (WmsWageQuotaTypeEnum.WMS_LENGTH_PRICE.getType() == ex.getWageQuotaType()) {
                     data.add(ex.getMete().divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP));
                     data.add(ex.getPrice().multiply(BigDecimal.valueOf(1000L)).setScale(2, RoundingMode.HALF_UP));
                  } else if (WmsWageQuotaTypeEnum.WMS_AREA_PRICE.getType() == ex.getWageQuotaType()) {
                     data.add(ex.getMete().divide(BigDecimal.valueOf(1000000L), 2, RoundingMode.HALF_UP));
                     data.add(ex.getPrice().multiply(BigDecimal.valueOf(1000000L)).setScale(2, RoundingMode.HALF_UP));
                  } else {
                     if (WmsWageQuotaTypeEnum.WMS_WEIGHT_PRICE.getType() != ex.getWageQuotaType()) {
                        throw new BusinessException("制成品计价方式类型不存在！");
                     }

                     data.add(ex.getMete().divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP));
                     data.add(ex.getPrice().multiply(BigDecimal.valueOf(1000L)).setScale(2, RoundingMode.HALF_UP));
                  }

                  data.add(ex.getAmount());
                  data.add(ex.getRejectAmount());
                  if (ex.getApplicant() != null) {
                     data.add(ex.getApplicant().getName());
                  } else {
                     data.add("-");
                  }

                  if (ex.getReviewerDate() != null) {
                     data.add(ex.getReviewerDate().format(formatter));
                  } else {
                     data.add("-");
                  }

                  dataList.add(data);
               }
            );

            try {
               response.reset();
               response.setContentType("application/vnd.ms-excel;charset=utf-8");
               String fileName = StrUtil.concat(true, "入库明细.xlsx");
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
                              row.setHeight((short)1000);
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
                  .sheet("入库明细")
                  .doWrite(dataList);
            } catch (Exception e) {
               throw new RuntimeException(e.getMessage());
            }
         }
      }
   }

   private Map<Integer, BigDecimal> unitConversion(BigDecimal value, String unit, Integer scale) {
      Unit u = this.unitService.getOne((Wrapper<Unit>)Wrappers.<Unit>lambdaQuery().eq(Unit::getName, unit));
      Map<Integer, BigDecimal> map = new HashMap<>();
      if (UnitEnum.DIGIT.getType().equals(u.getType())) {
         map.put(1, new BigDecimal(value.stripTrailingZeros().toPlainString()));
         map.put(2, BigDecimal.ONE);
      } else {
         BigDecimal precision = UnitsPrecisionEnum.getByName(unit);
         map.put(1, value.divide(precision, scale, 4));
         map.put(2, precision);
      }

      return map;
   }
}
