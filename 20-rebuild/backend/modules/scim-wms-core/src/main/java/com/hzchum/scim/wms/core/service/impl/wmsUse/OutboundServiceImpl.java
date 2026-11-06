package com.hzchum.scim.wms.core.service.impl.wmsUse;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.enums.AggregateTypeEnum;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.ApproveRecordStatusEnum;
import com.hzchum.scim.common.core.api.enums.ApproveTemplateVersionsFlowEnum;
import com.hzchum.scim.common.core.api.enums.CheckStatusEnum;
import com.hzchum.scim.common.core.api.enums.OutboundTypeEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo.common.MonthTimeRange;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.MountMessageDTO;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveFlowDTO;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordDetailDTO;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordFlowDTO;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.enums.SettlementStatusEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractGasSummaryDTO;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.finance.ContractGasSummaryService;
import com.hzchum.scim.mes.building.core.api.biz.util.MesBuildingUtilsBiz;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.IdAndSerialNumberDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.BatchSchedulingOutboundDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.BatchSchedulingOutboundDetailDTOParam;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingMachinePartNoProcessService;
import com.hzchum.scim.plan.core.api.manager.TechMesWmsManager;
import com.hzchum.scim.plan.core.api.pojo._do.PlanAreaBatch;
import com.hzchum.scim.plan.core.api.pojo.dto.SubscribeAuxiliaryWarehouseDTO;
import com.hzchum.scim.plan.core.api.service.PlanAreaBatchService;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrder;
import com.hzchum.scim.scm.core.api.pojo.dto.ProjectInfoDTO;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import com.hzchum.scim.system.core.api.biz.notification.SysPushFlowConfigBiz;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.enums.NumberTypeEnum;
import com.hzchum.scim.system.core.api.common.enums.notification.NotificationModuleTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.common.utils.notification.NotificationTemplateDetailsUtils;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.pojo._do.Department;
import com.hzchum.scim.system.core.api.pojo._do.NumberConfig;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo.dto.notification.NotificationServiceTriggerDTO;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.system.core.api.service.DepartmentService;
import com.hzchum.scim.system.core.api.service.NumberConfigService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.enums.HalfModeEnum;
import com.hzchum.scim.wms.core.api.enums.InvoiceTypeEnum;
import com.hzchum.scim.wms.core.api.enums.MaterialFreezeTypeEnum;
import com.hzchum.scim.wms.core.api.enums.MaterialIsWholeEnum;
import com.hzchum.scim.wms.core.api.enums.MaterialLabelPrintTypeEnum;
import com.hzchum.scim.wms.core.api.enums.MaterialOutboundModeEnum;
import com.hzchum.scim.wms.core.api.enums.MeasureTypeEnum;
import com.hzchum.scim.wms.core.api.enums.OutboundFailDestinationEnum;
import com.hzchum.scim.wms.core.api.enums.OutboundRelationTypeEnum;
import com.hzchum.scim.wms.core.api.enums.OutboundStatusEnum;
import com.hzchum.scim.wms.core.api.enums.ReceiptTypeEnum;
import com.hzchum.scim.wms.core.api.enums.SchedulingDataTypeEnum;
import com.hzchum.scim.wms.core.api.enums.TransferTypeEnum;
import com.hzchum.scim.wms.core.api.enums.UnitEnum;
import com.hzchum.scim.wms.core.api.enums.UnitsPrecisionEnum;
import com.hzchum.scim.wms.core.api.enums.WeightedPriceEnum;
import com.hzchum.scim.wms.core.api.enums.WeightedPriceTypeEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.BasicConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.BasicOutbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Classification;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Measure;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Unit;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Warehouse;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WasteConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WeightedExecutionPriceConf;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WeightedPriceConf;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WmsMaterialCodeConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Workshop;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.Statistics;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsEndPeriod;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsInbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsOutbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.WmsClosingTime;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.AccumulativeTotal;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.AccumulativeTotalRecord;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialFreeze;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialFreezeRecord;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialReturnable;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MonthWeightedAveragePrice;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MoveOutboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Outbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Print;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.PrintDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.ReturnDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Scrap;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Transfer;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.TransferDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WholeWeightedAveragePrice;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsForSale;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsForSaleDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsPickingApprove;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsPickingDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsRestitutionDetail;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefDeptAndNameDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndSNDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.MeteAndQuantity;
import com.hzchum.scim.wms.core.api.pojo.dto.common.OutboundAmountDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.PriceDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.SubjectMeasureDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.ProjectPickingDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.ProjectPickingListDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.ProjectPickingMeteListDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.AppOutboundDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialConsumingDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialInventoryDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.OutboundDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.OutboundDetailBasicDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.OutboundDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.OutboundDetailSellDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.OutboundListDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.SplitMaterialDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryProjectPickingDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.BatchOutboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.BatchOutboundDetailDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.FinishedProductsDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.OutboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.PickingApproveOutboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryByMaterialDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryOutboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.SteelPlateOutboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.UnfreezeDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.UpdateOutboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.WmsShipmentReceiveApproveDetailDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.BasicConfigService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.ClassificationService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.MeasureService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.SpecificationService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WarehouseService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WarningService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WmsSectionSteelControlTableService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WorkshopService;
import com.hzchum.scim.wms.core.api.service.wmsReport.WmsClosingTimeService;
import com.hzchum.scim.wms.core.api.service.wmsUse.AccumulativeTotalRecordService;
import com.hzchum.scim.wms.core.api.service.wmsUse.AccumulativeTotalService;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialFreezeService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialInventoryService;
import com.hzchum.scim.wms.core.api.service.wmsUse.OutboundService;
import com.hzchum.scim.wms.core.api.service.wmsUse.PrintService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WeightedAveragePriceService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsForSaleDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsForSaleService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsOutboundRemindService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsPickingApproveService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsRestitutionDetailService;
import com.hzchum.scim.wms.core.api.utils.CommonUtil;
import com.hzchum.scim.wms.core.api.utils.QueryUtilService;
import com.hzchum.scim.wms.core.api.utils.WmsUtil;
import com.hzchum.scim.wms.core.common.SimpleEntityParam;
import com.hzchum.scim.wms.core.mapper.wmsConfig.MeasureMapper;
import com.hzchum.scim.wms.core.mapper.wmsConfig.UnitMapper;
import com.hzchum.scim.wms.core.mapper.wmsConfig.WarehouseMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsEndPeriodMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsInboundMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsOutboundMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.WmsForSaleDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MaterialFreezeMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MaterialFreezeRecordMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MaterialInventoryMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MaterialReturnableMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MonthWeightedAveragePriceMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MoveOutboundDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.OutboundMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.ReturnDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.ScrapMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.TransferDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.TransferMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.WholeWeightedAveragePriceMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.WmsPickingDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.WmsPickingMapper;
import com.hzchum.scim.wms.core.utils.QueryUtilImpl;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OutboundServiceImpl extends ServiceImpl<OutboundMapper, Outbound> implements OutboundService {
   private static final BigDecimal HUNDRED = new BigDecimal("100");
   @Resource
   MoveOutboundDetailMapper moveOutboundDetailMapper;
   @Resource
   MaterialInventoryMapper materialInventoryMapper;
   @Resource
   NumberConfigService numberConfigService;
   @Resource
   ContractProjectService contractProjectService;
   @Resource
   UserService userService;
   @Resource
   OutboundService outboundService;
   @Resource
   DepartmentService departmentService;
   @Resource
   WarehouseMapper warehouseMapper;
   @Resource
   BasicConfigService basicConfigService;
   @Resource
   MeasureMapper measureMapper;
   @Resource
   TransferMapper transferMapper;
   @Resource
   TransferDetailMapper transferDetailMapper;
   @Resource
   MaterialFreezeService materialFreezeService;
   @Resource
   MaterialFreezeRecordMapper materialFreezeRecordMapper;
   @Resource
   MaterialReturnableMapper materialReturnableMapper;
   @Resource
   WorkshopService workshopService;
   @Resource
   MesBuildingWorkshopService mesBuildingWorkshopService;
   @Resource
   WarehouseService warehouseService;
   @Resource
   ScrapMapper scrapMapper;
   @Resource
   StatisticsMapper statisticsMapper;
   @Resource
   StatisticsOutboundMapper statisticsOutboundMapper;
   @Resource
   StatisticsEndPeriodMapper statisticsEndPeriodMapper;
   @Resource
   StatisticsInboundMapper statisticsInboundMapper;
   @Resource
   MaterialFreezeMapper materialFreezeMapper;
   @Resource
   PrintService printService;
   @Resource
   ReturnDetailMapper returnDetailMapper;
   @Resource
   WarningService warningService;
   @Resource
   ClassificationService classificationService;
   @Resource
   PlanAreaService planAreaService;
   @Resource
   PlanMonomerService monomerService;
   @Resource
   PlanAreaBatchService planAreaBatchService;
   @Resource
   WeightedAveragePriceService weightedAveragePriceService;
   @Resource
   MonthWeightedAveragePriceMapper monthWeightedAveragePriceMapper;
   @Resource
   WholeWeightedAveragePriceMapper wholeWAPMapper;
   @Resource
   MonthWeightedAveragePriceMapper monthWAPMapper;
   @Resource
   MesBuildingUtilsBiz mesBuildingUtilsBiz;
   @Resource
   ContractGasSummaryService gasSummaryService;
   @Resource
   MeasureService measureService;
   @Resource
   SpecificationService specificationService;
   @Resource
   WmsClosingTimeService wmsClosingTimeService;
   @Value("${wms.amount-accuracy}")
   private Integer amountAccuracy;
   @Resource
   InboundService inboundService;
   @Resource
   WmsForSaleService wmsForSaleService;
   @Resource
   WmsForSaleDetailService wmsForSaleDetailService;
   @Resource
   RedisTemplate redisTemplate;
   @Resource
   WmsApproveRecordService wmsApproveRecordService;
   @Resource
   BranchCompanyService branchCompanyService;
   @Resource
   PurchaseOrderService purchaseOrderService;
   @Resource
   AccumulativeTotalService accumulativeTotalService;
   @Resource
   AccumulativeTotalRecordService accumulativeTotalRecordService;
   @Resource
   WmsRestitutionDetailService wmsRestitutionDetailService;
   @Resource
   TechMesWmsManager techMesWmsManager;
   @Resource
   QueryUtilService queryUtilService;
   @Resource
   UnitMapper unitMapper;
   @Resource
   WmsUtil wmsUtil;
   @Resource
   MesBuildingMachinePartNoProcessService mesBuildingMachinePartNoProcessService;
   @Resource
   WmsPickingMapper wmsPickingMapper;
   @Resource
   WmsPickingDetailMapper wmsPickingDetailMapper;
   @Resource
   WmsPickingApproveService wmsPickingApproveService;
   @Resource
   QueryUtilImpl queryUtil;
   @Resource
   WmsOutboundRemindService outboundRemindService;
   @Resource
   WmsSectionSteelControlTableService wmsSectionSteelControlTableService;
   @Resource
   NotificationTemplateDetailsUtils detailsUtils;
   @Resource
   private SysPushFlowConfigBiz sysPushFlowConfigBiz;
   @Resource
   MaterialInventoryService materialInventoryService;
   RoundingMode ROUNDING = RoundingMode.HALF_UP;

   @Override
   public PageVO<OutboundListDTO> pageInfo(QueryOutboundDTOParam param, Integer pageNum, Integer size, List<String> sort) {
      String s = StringUtils.analyzeSortConditions(sort);
      PageInfo<Outbound> pageInfo = PageHelper.<Outbound>startPage(pageNum, size, s).doSelectPageInfo(() -> this.listInfo(param));
      List<OutboundListDTO> collect = pageInfo.getList()
         .stream()
         .map(
            outbound -> {
               OutboundListDTO listDTO = BeanUtil.copy(outbound, OutboundListDTO.class);
               listDTO.setOutboundEarliestTime(outbound.getOutboundStartTime());
               listDTO.setOutboundLatestTime(outbound.getOutboundEndTime());
               List<MoveOutboundDetail> moveOutboundDetails = this.moveOutboundDetailMapper
                  .selectList((Wrapper<MoveOutboundDetail>)Wrappers.<MoveOutboundDetail>lambdaQuery().eq(MoveOutboundDetail::getOutboundId, outbound.getId()));
               List<ProjectInfoDTO> list = new ArrayList<>();

               for (Long id : moveOutboundDetails.stream().map(MoveOutboundDetail::getProjectId).collect(Collectors.toSet())) {
                  if (id != null) {
                     ProjectInfo projectInfo = this.contractProjectService.getSimpleById(id);
                     list.add(BeanUtil.copy(projectInfo, ProjectInfoDTO.class));
                  }
               }

               listDTO.setProjects(list);
               listDTO.setBasicClass(outbound.getContainBasicClass());
               listDTO.setApplicationSN(outbound.getApplicationSn());
               return listDTO;
            }
         )
         .collect(Collectors.toList());
      return new PageVO<>(pageInfo, collect);
   }

   @Override
   public List<Outbound> listInfo(QueryOutboundDTOParam param) {
      return this.baseMapper.getOutboundList(param);
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public synchronized Boolean saveOutbound(SteelPlateOutboundDTOParam param) {
      Preconditions.checkArgument(param.getQuantity() != null && param.getQuantity().signum() > 0, "出库数量必须大于0");
      MaterialInventory materialInventory = this.materialInventoryMapper.selectById(param.getMaterialId());
      Preconditions.checkArgument(materialInventory != null, "仓库中不存在该物料");
      Measure measure = this.measureMapper
         .selectOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, materialInventory.getClassifyId()));
      SubjectMeasureDTO subjectMeasureDTO = this.measureService.measureListById(materialInventory.getClassifyId());
      String accountingUnit = subjectMeasureDTO.getAccountingUnit();
      Integer accountingPrecision = subjectMeasureDTO.getAccountingPrecision();
      BigDecimal UnitsPrecision = UnitsPrecisionEnum.getByName(subjectMeasureDTO.getAccountingUnit());
      WasteConfig scrapDefinitionConf = this.basicConfigService.getSteelScrapDefinitionConf();
      BasicOutbound outboundBasicConf = this.basicConfigService.getOutboundBasicConf();
      if (OutboundTypeEnum.PRODUCTION_USE.getType().equals(param.getOutboundTypeSelection())
         && Boolean.TRUE.equals(outboundBasicConf.getProductionOutBoundUserIsRequired())) {
         Preconditions.checkArgument(param.getRecipientId() != null, "出库失败,出库配置生产使用领用人不能为空！");
      }

      Outbound outbound = this.baseMapper
         .selectOne(
            (((((Wrappers.<Outbound>lambdaQuery()
                              .eq(Outbound::getApplicantId, UserUtil.getCurrentUserId()))
                           .eq(Outbound::getReviewStatus, OutboundStatusEnum.UN_REVIEWED.getType()))
                        .eq(Outbound::getBoolScheduling, Boolean.FALSE))
                     .eq(param.getConvertId() != null, Outbound::getConvertId, param.getConvertId()))
                  .eq(
                     Outbound::getOutboundTypeSelection,
                     param.getOutboundTypeSelection() != null ? param.getOutboundTypeSelection() : OutboundTypeEnum.PRODUCTION_USE.getType()
                  ))
               .eq(param.getBoolPartyA() != null, Outbound::getBoolPartyA, param.getBoolPartyA())
         );
      if (outbound != null) {
         outbound.setUserUpdateTime(LocalDateTime.now());
      } else {
         outbound = Outbound.builder()
            .applicantId(UserUtil.getCurrentUserId())
            .applicantName(UserUtil.getCurrentName())
            .userUpdateTime(LocalDateTime.now())
            .reviewStatus(OutboundStatusEnum.UN_REVIEWED.getType())
            .outboundStartTime(LocalDateTime.now())
            .outboundEndTime(LocalDateTime.now())
            .convertId(param.getConvertId())
            .boolPartyA(param.getBoolPartyA())
            .outboundTypeSelection(param.getOutboundTypeSelection() != null ? param.getOutboundTypeSelection() : OutboundTypeEnum.PRODUCTION_USE.getType())
            .build();
         String serviceNumber = this.numberConfigService.getNumber(NumberTypeEnum.OUTBOUND_APPLY, this.baseMapper.getCount(LocalDateTime.now()));
         outbound.setApplicationSn(serviceNumber);
         this.baseMapper.insert(outbound);
      }

      MoveOutboundDetail moveOutboundDetail = MoveOutboundDetail.builder()
         .warehouseId(materialInventory.getWarehouseId())
         .materialIsWhole(materialInventory.getMaterialIsWhole())
         .workshopId(param.getWorkshopId())
         .sourceWorkshopId(materialInventory.getWorkshopId())
         .materialInventoryId(materialInventory.getId())
         .outboundId(outbound.getId())
         .basicClass(materialInventory.getBasicClass())
         .classifyId(materialInventory.getClassifyId())
         .specification(materialInventory.getSpecification())
         .sourceProjectId(materialInventory.getProjectId())
         .sourceMonomerId(materialInventory.getMonomerId())
         .sourceAreaId(materialInventory.getAreaId())
         .thickness(materialInventory.getThickness())
         .theoryThickness(materialInventory.getTheoryThickness())
         .heatNoAndBatchNo(materialInventory.getHeatNoAndBatchNo())
         .brand(materialInventory.getBrand())
         .outboundTime(param.getOutboundTime() != null ? param.getOutboundTime() : LocalDateTime.now())
         .color(materialInventory.getColor())
         .recipientId(param.getRecipientId())
         .outboundMode(param.getMaterialOutboundMode())
         .remark(param.getRemark())
         .boolPartyA(materialInventory.getBoolPartyA())
         .taxRate(materialInventory.getTaxRate())
         .invoiceType(materialInventory.getInvoiceType())
         .standardId(materialInventory.getStandardId())
         .standardName(materialInventory.getStandardName())
         .materialSn(materialInventory.getSerialNumber())
         .workshopId(param.getWorkshopId())
         .outboundAddress(param.getOutboundAddress())
         .actualTheoryWeight(param.getActualTheoryWeight())
         .isNeedRemind(param.getIsNeedRemind())
         .build();
      MaterialFreeze materialFreeze = this.materialFreezeService
         .getOne((Wrapper<MaterialFreeze>)Wrappers.<MaterialFreeze>lambdaQuery().eq(MaterialFreeze::getMaterialInventoryId, materialInventory.getId()));
      MaterialFreezeRecord freezeRecord = null;
      Set<Integer> freezeTypes = null;
      BigDecimal freezeTotalMete;
      BigDecimal freezeTotalQuantity;
      if (materialFreeze != null) {
         freezeTotalMete = materialFreeze.getTotalMete();
         freezeTotalQuantity = materialFreeze.getTotalQuantity();
         freezeTypes = Arrays.stream(materialFreeze.getTotalFreezeTypes().split(",")).map(Integer::parseInt).collect(Collectors.toSet());
         if (freezeTypes.contains(MaterialFreezeTypeEnum.REQUISITIONS.getType())) {
            freezeRecord = this.materialFreezeRecordMapper
               .selectOne(
                  (Wrapper<MaterialFreezeRecord>)((Wrappers.<MaterialFreezeRecord>lambdaQuery()
                           .eq(MaterialFreezeRecord::getMaterialFreezeId, materialFreeze.getId()))
                        .eq(MaterialFreezeRecord::getFreezeType, MaterialFreezeTypeEnum.REQUISITIONS.getType()))
                     .eq(MaterialFreezeRecord::getProjectId, param.getProjectId())
               );
            if (freezeRecord != null) {
               freezeTotalMete = freezeTotalMete.subtract(freezeRecord.getMete());
               if (materialFreeze.getTotalQuantity() != null) {
                  freezeTotalQuantity = freezeTotalQuantity.subtract(freezeRecord.getQuantity());
               }
            }
         }
      } else {
         freezeTotalMete = BigDecimal.ZERO;
         freezeTotalQuantity = BigDecimal.ZERO;
      }

      BigDecimal outMete = null;
      BigDecimal outQuantity = null;
      if (param.getProjectId() != null) {
         if (materialInventory.getBoolPartyA() && ObjectUtil.notEqual(materialInventory.getProjectId(), param.getProjectId())) {
            Boolean b = this.contractProjectService.checkRelatednessById(materialInventory.getProjectId(), param.getProjectId());
            Preconditions.checkArgument(b, "出库失败,甲供物料只能出库到本身项目或增补项目");
         }

         if (!materialInventory.getBoolPartyA() && !outboundBasicConf.getBoolCanOutToOtherProject() && materialInventory.getProjectId() != null) {
            Preconditions.checkArgument(materialInventory.getProjectId().equals(param.getProjectId()), "当前出库项目与物料项目不一致,请核对.");
         }

         if (materialInventory.getProjectId() != null) {
            moveOutboundDetail.setOutboundRelationType(
               materialInventory.getProjectId().equals(param.getProjectId())
                  ? OutboundRelationTypeEnum.ROUTINE.getType()
                  : OutboundRelationTypeEnum.TRANSFER.getType()
            );
         }

         moveOutboundDetail.setProjectId(param.getProjectId());
         moveOutboundDetail.setMonomerId(param.getMonomerId());
         moveOutboundDetail.setAreaId(param.getAreaId());
         moveOutboundDetail.setAreaBatchId(param.getAreaBatchId());
      }

      if (param.getProjectId() == null && materialInventory.getProjectId() != null) {
         moveOutboundDetail.setProjectId(materialInventory.getProjectId());
         moveOutboundDetail.setMonomerId(materialInventory.getMonomerId());
         moveOutboundDetail.setAreaId(materialInventory.getAreaId());
      }

      if (moveOutboundDetail.getProjectId() != null) {
         ContractProject project = this.contractProjectService.getById(moveOutboundDetail.getProjectId());
         Preconditions.checkArgument(
            moveOutboundDetail.getProjectId() != null && SettlementStatusEnum.UN_SETTLED.getType().equals(project.getSettlementStatus()), "出库失败,当前项目已结算"
         );
      }

      if (MaterialOutboundModeEnum.HALF.getType().equals(param.getMaterialOutboundMode())) {
         Preconditions.checkArgument(
            BasicClassEnum.checkIsSteel(materialInventory.getBasicClass()) && !BasicClassEnum.COLOR_ROLL.getType().equals(materialInventory.getBasicClass()),
            "该材料不能进行整料半出"
         );
         Preconditions.checkArgument(param.getHalfSize() != null && param.getHalfSize().compareTo(BigDecimal.ONE) >= 0, "半出截取长度不能小于1mm");
         Map<Integer, BigDecimal> unitConversion = this.unitConversion(
            BigDecimal.ZERO, subjectMeasureDTO.getMeasureUnit(), subjectMeasureDTO.getMeasurePrecision()
         );
         BigDecimal inventoryQuantity = materialInventory.getQuantity();
         BigDecimal sendQuantity = param.getQuantity();
         inventoryQuantity = inventoryQuantity.subtract(freezeTotalQuantity);
         BigDecimal halfUpMete = inventoryQuantity.divide(unitConversion.get(2), subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP)
            .setScale(subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP);
         BigDecimal halfSendQuantity = sendQuantity.divide(unitConversion.get(2), subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP)
            .setScale(subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP);
         Preconditions.checkArgument(halfSendQuantity.compareTo(halfUpMete) <= 0, "当前库存量不足,请重新操作");
         if (halfSendQuantity.compareTo(halfUpMete) > -1) {
            sendQuantity = inventoryQuantity;
         }

         moveOutboundDetail.setQuantity(sendQuantity);
         moveOutboundDetail.setHalfMode(1);
         if (BasicClassEnum.SECTION_STEEL.getType().equals(materialInventory.getBasicClass())) {
            Preconditions.checkArgument(!HalfModeEnum.WIDTH.getType().equals(param.getHalfMode()), "型材半出只能按长度截取");
            Preconditions.checkArgument(param.getHalfSize().compareTo(materialInventory.getLength()) < 0, "截取长度大于或等于型材定尺长度,请选择整料整出");
            moveOutboundDetail.setMete(
               CommonUtil.getStockOutboundMete(sendQuantity, materialInventory.getQuantity().subtract(freezeTotalQuantity), materialInventory.getMete().subtract(freezeTotalMete))
                  .multiply(param.getHalfSize()).divide(materialInventory.getLength(), 8, RoundingMode.DOWN)
            );
            moveOutboundDetail.setLength(param.getHalfSize());
         } else {
            moveOutboundDetail.setHalfMode(param.getHalfMode());
            if (HalfModeEnum.LENGTH.getType().equals(param.getHalfMode())) {
               Preconditions.checkArgument(param.getHalfSize().compareTo(materialInventory.getLength()) < 0, "截取长度大于或等于钢板长度,请选择整料整出");
               moveOutboundDetail.setLength(param.getHalfSize());
               moveOutboundDetail.setWidth(materialInventory.getWidth());
               moveOutboundDetail.setMete(
               CommonUtil.getStockOutboundMete(sendQuantity, materialInventory.getQuantity().subtract(freezeTotalQuantity), materialInventory.getMete().subtract(freezeTotalMete))
                  .multiply(param.getHalfSize()).divide(materialInventory.getLength(), 8, RoundingMode.DOWN)
            );
            } else {
               Preconditions.checkArgument(param.getHalfSize().compareTo(materialInventory.getWidth()) < 0, "截取宽度大于或等于钢板宽度,请选择整料整出");
               moveOutboundDetail.setLength(materialInventory.getLength());
               moveOutboundDetail.setWidth(param.getHalfSize());
               moveOutboundDetail.setMete(
               CommonUtil.getStockOutboundMete(sendQuantity, materialInventory.getQuantity().subtract(freezeTotalQuantity), materialInventory.getMete().subtract(freezeTotalMete))
                  .multiply(param.getHalfSize()).divide(materialInventory.getWidth(), 8, RoundingMode.DOWN)
            );
            }
         }

         Preconditions.checkArgument(moveOutboundDetail.getMete().compareTo(BigDecimal.valueOf(1000L)) > 0, "出库失败,出库量必须大于1kg");
         moveOutboundDetail.setOutboundType(MaterialOutboundModeEnum.HALF.getType());
         moveOutboundDetail.setHalfSize(param.getHalfSize());
         this.checkHalfOutputDimensions(moveOutboundDetail);
         outMete = CommonUtil.getStockOutboundMete(sendQuantity, materialInventory.getQuantity().subtract(freezeTotalQuantity), materialInventory.getMete().subtract(freezeTotalMete));
      } else {
         moveOutboundDetail.setOutboundType(MaterialOutboundModeEnum.WHOLE.getType());
         BigDecimal precision = UnitsPrecisionEnum.getByName(measure.getAccountingUnit());
         MeteAndQuantity meteAndQuantitySend = new MeteAndQuantity();
         meteAndQuantitySend.setSendQuantity(param.getQuantity());
         MeteAndQuantity meteAndQuantity = this.checkInventory(
            materialInventory.getBasicClass(),
            materialInventory.getClassifyId(),
            meteAndQuantitySend,
            materialInventory.getQuantity(),
            materialInventory.getMete(),
            freezeTotalQuantity,
            freezeTotalMete,
            subjectMeasureDTO,
            measure
         );
         BigDecimal sendQuantity = meteAndQuantity.getSendQuantity();
         if (BasicClassEnum.checkNotSteel(materialInventory.getBasicClass())) {
            if (measure.getOutboundUnitType() == null) {
               measure = this.getMeasured(materialInventory.getClassifyId());
            }

            if (MeasureTypeEnum.MEASURE.getType().equals(measure.getOutboundUnitType())) {
               moveOutboundDetail.setMete(CommonUtil.getStockOutboundMete(
                  sendQuantity, materialInventory.getQuantity().subtract(freezeTotalQuantity), materialInventory.getMete().subtract(freezeTotalMete)
               ));
               moveOutboundDetail.setQuantity(sendQuantity);
            } else {
               moveOutboundDetail.setMete(sendQuantity);
               if (materialInventory.getQuantity() != null) {
                  moveOutboundDetail.setQuantity(sendQuantity.divide(materialInventory.getUnitNet(), 8, this.ROUNDING));
               }
            }
         } else if (BasicClassEnum.STEEL_PLATE.getType().equals(materialInventory.getBasicClass())) {
            moveOutboundDetail.setQuantity(sendQuantity);
            BigDecimal outboundMete1 = CommonUtil.getOutboundMete1(
               UnitsPrecision, sendQuantity, materialInventory, freezeTotalMete, freezeTotalQuantity, accountingPrecision
            );
            moveOutboundDetail.setMete(outboundMete1);
            moveOutboundDetail.setLength(materialInventory.getLength());
            moveOutboundDetail.setWidth(materialInventory.getWidth());
         } else if (BasicClassEnum.SECTION_STEEL.getType().equals(materialInventory.getBasicClass())) {
            BigDecimal outboundMete1 = CommonUtil.getOutboundMete1(
               UnitsPrecision, sendQuantity, materialInventory, freezeTotalMete, freezeTotalQuantity, accountingPrecision
            );
            moveOutboundDetail.setMete(outboundMete1);
            moveOutboundDetail.setLength(materialInventory.getLength());
            moveOutboundDetail.setQuantity(sendQuantity);
         } else if (BasicClassEnum.COLOR_ROLL.getType().equals(materialInventory.getBasicClass())) {
            Preconditions.checkArgument(sendQuantity.compareTo(scrapDefinitionConf.getSteelCoilMinLength()) > 0, "出库失败,钢卷出库长度必须大于废料定义长度.");
            Preconditions.checkArgument(sendQuantity.compareTo(BigDecimal.TEN) >= 0, "钢卷出库长度不能小于10MM");
            BigDecimal outboundMete1 = CommonUtil.getOutboundMete1(
               UnitsPrecision, sendQuantity, materialInventory, freezeTotalMete, freezeTotalQuantity, accountingPrecision
            );
            moveOutboundDetail.setMete(outboundMete1);
            Preconditions.checkArgument(moveOutboundDetail.getMete().compareTo(BigDecimal.valueOf(1000L)) > 0, "出库失败,出库量必须大于1kg");
            moveOutboundDetail.setQuantity(sendQuantity);
            moveOutboundDetail.setWidth(materialInventory.getWidth());
         }

         outMete = moveOutboundDetail.getMete();
      }

      if (moveOutboundDetail.getRecipientId() != null) {
         User user = this.userService.getById(moveOutboundDetail.getRecipientId());
         moveOutboundDetail.setRecipientName(user.getName());
         List<String> recipientName = StrUtil.isNotBlank(outbound.getRecipients())
            ? Arrays.stream(outbound.getRecipients().split(",")).collect(Collectors.toList())
            : new ArrayList<>();
         if (!recipientName.contains(user.getName())) {
            recipientName.add(user.getName());
         }

         outbound.setRecipients(StrUtil.join(",", recipientName));
      }

      if (moveOutboundDetail.getProjectId() != null) {
         if (StrUtil.isNotBlank(outbound.getProjectIds())) {
            List<Long> list = CommonUtil.spilt(outbound.getProjectIds(), ",");
            if (!list.contains(moveOutboundDetail.getProjectId())) {
               outbound.setProjectIds(outbound.getProjectIds() + "," + moveOutboundDetail.getProjectId());
            }
         } else {
            outbound.setProjectIds(moveOutboundDetail.getProjectId() + "");
         }
      }

      this.moveOutboundDetailMapper.insert(moveOutboundDetail);
      outbound.setContainBasicClass(
         outbound.getContainBasicClass() != null ? outbound.getContainBasicClass() | moveOutboundDetail.getBasicClass() : moveOutboundDetail.getBasicClass()
      );
      Integer materialFreezeType = null;
      if (outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.PRODUCTION_USE.getType())) {
         materialFreezeType = Boolean.TRUE.equals(outbound.getBoolScheduling())
            ? MaterialFreezeTypeEnum.SCHEDULING_OUTBOUND.getType() : MaterialFreezeTypeEnum.OUTBOUND.getType();
      } else if (outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.CONSTRUCTION_SITE_USE.getType())) {
         materialFreezeType = MaterialFreezeTypeEnum.CONSTRUCTION_SITE_USE.getType();
      }

      MaterialFreezeRecord materialFreezeRecord = MaterialFreezeRecord.builder()
         .freezeDetailId(moveOutboundDetail.getId())
         .freezeType(materialFreezeType)
         .freezeSourceId(outbound.getId())
         .freezeSourceSn(outbound.getApplicationSn())
         .operatorId(UserUtil.getCurrentUserId())
         .operatorName(UserUtil.getCurrentName())
         .mete(outMete != null ? outMete : moveOutboundDetail.getMete())
         .quantity(outQuantity != null ? outQuantity : moveOutboundDetail.getQuantity())
         .boolBatten(outQuantity != null)
         .projectId(moveOutboundDetail.getProjectId())
         .frozenTime(LocalDateTime.now())
         .outboundUnitType(measure.getOutboundUnitType())
         .build();
      if (materialFreeze == null) {
         materialFreeze = BeanUtil.copy(materialInventory, MaterialFreeze.class, "createTime");
         materialFreeze.setTotalQuantity(outQuantity != null ? outQuantity : moveOutboundDetail.getQuantity());
         materialFreeze.setTotalMete(outMete);
         materialFreeze.setTotalFreezeTypes(materialFreezeType + "");
         materialFreeze.setMaterialInventoryId(materialInventory.getId());
         this.materialFreezeService.save(materialFreeze);
      } else {
         if (freezeRecord != null) {
            if (freezeRecord.getMete().compareTo(moveOutboundDetail.getMete()) < 0) {
               materialFreezeRecord.setApplyPurchaseQuantity(freezeRecord.getQuantity());
               materialFreezeRecord.setApplyPurchaseMete(freezeRecord.getMete());
            } else {
               materialFreezeRecord.setApplyPurchaseQuantity(moveOutboundDetail.getQuantity());
               materialFreezeRecord.setApplyPurchaseMete(moveOutboundDetail.getMete());
            }

            if (freezeRecord.getQuantity() != null) {
               freezeRecord.setQuantity(freezeRecord.getQuantity().subtract(moveOutboundDetail.getQuantity()));
            }

            freezeRecord.setMete(freezeRecord.getMete().subtract(moveOutboundDetail.getMete()));
            if (freezeRecord.getMete().compareTo(BigDecimal.ZERO) <= 0) {
               if (freezeRecord.getMete().compareTo(BigDecimal.ZERO) != 0) {
                  materialFreeze.setTotalQuantity(
                     freezeRecord.getQuantity() != null ? materialFreeze.getTotalQuantity().add(freezeRecord.getQuantity().negate()) : null
                  );
                  materialFreeze.setTotalMete(materialFreeze.getTotalMete().add(freezeRecord.getMete().negate()));
               }

               this.materialFreezeRecordMapper.deleteById(freezeRecord);
            } else {
               this.materialFreezeRecordMapper.updateById(freezeRecord);
            }

            materialFreezeRecord.setBoolChangeOutbound(true);
            materialFreezeRecord.setApplyPurchaseId(freezeRecord.getFreezeSourceId());
            materialFreezeRecord.setApplyPurchaseDetailId(freezeRecord.getFreezeDetailId());
            materialFreezeRecord.setApplyPurchaseSn(freezeRecord.getFreezeSourceSn());
         } else {
            if (moveOutboundDetail.getQuantity() != null) {
               materialFreeze.setTotalQuantity(
                  outQuantity != null
                     ? materialFreeze.getTotalQuantity().add(outQuantity)
                     : materialFreeze.getTotalQuantity().add(moveOutboundDetail.getQuantity())
               );
            }

            freezeTypes.add(materialFreezeType);
            materialFreeze.setTotalFreezeTypes(StrUtil.join(",", freezeTypes));
            materialFreeze.setTotalMete(materialFreeze.getTotalMete().add(outMete));
         }

         this.materialFreezeService.updateById(materialFreeze);
      }

      materialFreezeRecord.setMaterialFreezeId(materialFreeze.getId());
      this.materialFreezeRecordMapper.insert(materialFreezeRecord);
      if (!materialInventory.getBoolHasFrozen()) {
         this.materialInventoryMapper.updateBoolHasFrozen(materialInventory.getId(), true);
      }

      return this.baseMapper.updateById(outbound) == 1;
   }

   @Override
   public List<Long> getIds(QueryOutboundDTOParam param) {
      return this.baseMapper.getOutboundList(param).stream().map(Outbound::getId).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
   }

   @Override
   public OutboundDTO getOutboundById(Long id) {
      Outbound outbound = this.baseMapper.selectById(id);
      Preconditions.checkArgument(outbound != null, "出库单不存在");
      OutboundDTO outboundDTO = BeanUtil.copy(outbound, OutboundDTO.class, "");
      outboundDTO.setApplicantSN(outbound.getApplicationSn());
      Department department = this.departmentService.selectByUserId(outbound.getApplicantId());
      outboundDTO.setApplicant(BriefDeptAndNameDTO.builder().name(outbound.getApplicantName()).deptName(department.getName()).build());
      int basicClass = 0;
      List<MoveOutboundDetail> moveOutboundDetails = this.moveOutboundDetailMapper
         .selectList((Wrapper<MoveOutboundDetail>)Wrappers.<MoveOutboundDetail>lambdaQuery().eq(MoveOutboundDetail::getOutboundId, outbound.getId()));
      List<OutboundDetailDTO> list = new ArrayList<>();
      this.getDetailDTO(basicClass, moveOutboundDetails, list, false);
      outboundDTO.setBasicClass(basicClass);
      outboundDTO.setList(list);
      return outboundDTO;
   }

   @Override
   public OutboundDTO getOutboundByIdV2(Long id) {
      Outbound outbound = this.baseMapper.selectById(id);
      Preconditions.checkArgument(outbound != null, "出库单不存在");
      OutboundDTO outboundDTO = BeanUtil.copy(outbound, OutboundDTO.class, "");
      outboundDTO.setApplicantSN(outbound.getApplicationSn());
      if (outbound.getApplicantId() != null) {
         Department department = this.departmentService.selectByUserId(outbound.getApplicantId());
         outboundDTO.setApplicant(BriefDeptAndNameDTO.builder().name(outbound.getApplicantName()).deptName(department.getName()).build());
      }

      if (ObjectUtil.isNotEmpty(outbound.getApproveRecordId())) {
         WmsApproveRecordFlowDTO approveRecordDTO = this.wmsApproveRecordService.getApproveRecordDTO(outbound.getApproveRecordId());
         outboundDTO.setWmsApproveRecordFlowDTOS(approveRecordDTO);
      }

      int basicClass = 0;
      List<MoveOutboundDetail> moveOutboundDetails = this.moveOutboundDetailMapper
         .selectList((Wrapper<MoveOutboundDetail>)Wrappers.<MoveOutboundDetail>lambdaQuery().eq(MoveOutboundDetail::getOutboundId, outbound.getId()));
      List<OutboundDetailDTO> list = new ArrayList<>();
      if (OutboundTypeEnum.PRODUCTION_USE.getType().equals(outbound.getOutboundTypeSelection())
         || OutboundTypeEnum.CONSTRUCTION_SITE_USE.getType().equals(outbound.getOutboundTypeSelection())) {
         this.getDetailDTO(basicClass, moveOutboundDetails, list, false);
         outboundDTO.setBasicClass(basicClass);
         outboundDTO.setList(list);
         return outboundDTO;
      }

      if (OutboundTypeEnum.FOR_SALE.getType().equals(outbound.getOutboundTypeSelection())) {
         List<Long> detailIds = moveOutboundDetails.stream().map(MoveOutboundDetail::getId).collect(Collectors.toList());
         List<WmsForSaleDetail> wmsForSaleDetails = this.wmsForSaleDetailService
            .list((Wrapper<WmsForSaleDetail>)new LambdaQueryWrapper<WmsForSaleDetail>().in(WmsForSaleDetail::getOutboundDetailId, detailIds).exists(WmsForSaleDetailMapper.OUTBOUND_PARENT_EXISTS_SQL));
         this.getDetailSellDTO(basicClass, moveOutboundDetails, list, false, wmsForSaleDetails);
         outboundDTO.setBasicClass(basicClass);
         outboundDTO.setList(list);
         return outboundDTO;
      }

      if (OutboundTypeEnum.TEMPORARY_LOAN.getType().equals(outbound.getOutboundTypeSelection())) {
         List<OutboundDetailDTO> outboundDTOS = cn.hutool.core.bean.BeanUtil.copyToList(moveOutboundDetails, OutboundDetailDTO.class);
         outboundDTOS.forEach(
            outboundDetailDTO -> {
               List<WmsRestitutionDetail> list1 = this.wmsRestitutionDetailService
                  .list(
                     (Wrapper<WmsRestitutionDetail>)(new LambdaQueryWrapper<WmsRestitutionDetail>()
                           .eq(WmsRestitutionDetail::getOutboundDetailId, outboundDetailDTO.getId()))
                        .eq(WmsRestitutionDetail::getRestitutionType, 1)
                  );
               List<WmsRestitutionDetail> list2 = this.wmsRestitutionDetailService
                  .list(
                     (Wrapper<WmsRestitutionDetail>)(new LambdaQueryWrapper<WmsRestitutionDetail>()
                           .eq(WmsRestitutionDetail::getOutboundDetailId, outboundDetailDTO.getId()))
                        .eq(WmsRestitutionDetail::getRestitutionType, 2)
                  );
               if (CollectionUtil.isNotEmpty(list1)) {
                  BigDecimal wmsRestitutionNum = list1.stream()
                     .filter(wmsRestitutionDetail -> wmsRestitutionDetail.getQuantity() != null)
                     .map(WmsRestitutionDetail::getQuantity)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  BigDecimal wmsRestitutionMete = list1.stream()
                     .filter(wmsRestitutionDetail -> wmsRestitutionDetail.getMete() != null)
                     .map(WmsRestitutionDetail::getMete)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  outboundDetailDTO.setWmsRestitutionNum(wmsRestitutionNum);
                  outboundDetailDTO.setWmsRestitutionMete(wmsRestitutionMete);
               }

               if (CollectionUtil.isNotEmpty(list2)) {
                  BigDecimal wmsWastageNum = list2.stream()
                     .filter(wmsRestitutionDetail -> wmsRestitutionDetail.getQuantity() != null)
                     .map(WmsRestitutionDetail::getQuantity)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  BigDecimal wmsWastageMete = list2.stream()
                     .filter(wmsRestitutionDetail -> wmsRestitutionDetail.getMete() != null)
                     .map(WmsRestitutionDetail::getMete)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  outboundDetailDTO.setWmsWastageMete(wmsWastageMete);
                  outboundDetailDTO.setWmsWastageNum(wmsWastageNum);
               }
            }
         );
         outboundDTO.setList(outboundDTOS);
         return outboundDTO;
      }

      if (OutboundTypeEnum.OUTSOURCING_RAW_MATERIALS.getType().equals(outbound.getOutboundTypeSelection())) {
         this.getDetailDTO(basicClass, moveOutboundDetails, list, false);
         outboundDTO.setBasicClass(basicClass);
         outboundDTO.setList(list);
         return outboundDTO;
      }

      if (OutboundTypeEnum.SCRAPS.getType().equals(outbound.getOutboundTypeSelection())) {
         this.getDetailDTO(basicClass, moveOutboundDetails, list, false);
         outboundDTO.setBasicClass(basicClass);
         outboundDTO.setList(list);
         return outboundDTO;
      }

      if (OutboundTypeEnum.SCHEDULING_OUTBOUND.getType().equals(outbound.getOutboundTypeSelection())) {
         WmsPickingApprove one = this.wmsPickingApproveService
            .getOne((Wrapper<WmsPickingApprove>)new LambdaQueryWrapper<WmsPickingApprove>().last("and find_in_set(" + outbound.getId() + ",outbound_ids)"));
         if (ObjectUtil.isNotEmpty(one) && ObjectUtil.isNotEmpty(one.getApproveRecordId())) {
            WmsApproveRecordFlowDTO approveRecordDTO = this.wmsApproveRecordService.getApproveRecordDTO(one.getApproveRecordId());
            outboundDTO.setWmsApproveRecordFlowDTOS(approveRecordDTO);
         }

         this.getDetailDTO(basicClass, moveOutboundDetails, list, false);
         outboundDTO.setBasicClass(basicClass);
         outboundDTO.setList(list);
         return outboundDTO;
      } else {
         Preconditions.checkArgument(false, "未知出库类型");
         return null;
      }
   }

   @Override
   public OutboundDTO getOutboundDTO(Long id) {
      Outbound outbound = this.baseMapper.selectById(id);
      Preconditions.checkArgument(outbound != null, "出库单不存在");
      OutboundDTO outboundDTO = BeanUtil.copy(outbound, OutboundDTO.class, "");
      outboundDTO.setApplicantSN(outbound.getApplicationSn());
      if (outbound.getApplicantId() != null) {
         Department department = this.departmentService.selectByUserId(outbound.getApplicantId());
         outboundDTO.setApplicant(BriefDeptAndNameDTO.builder().name(outbound.getApplicantName()).deptName(department.getName()).build());
      }

      if (ObjectUtil.isNotEmpty(outbound.getApproveRecordId())) {
         WmsApproveRecordFlowDTO approveRecordDTO = this.wmsApproveRecordService.getApproveRecordDTO(outbound.getApproveRecordId());
         outboundDTO.setWmsApproveRecordFlowDTOS(approveRecordDTO);
      }

      int basicClass = 0;
      List<MoveOutboundDetail> moveOutboundDetails = this.moveOutboundDetailMapper
         .selectList((Wrapper<MoveOutboundDetail>)Wrappers.<MoveOutboundDetail>lambdaQuery().eq(MoveOutboundDetail::getOutboundId, outbound.getId()));
      List<OutboundDetailDTO> list = new ArrayList<>();
      if (OutboundTypeEnum.PRODUCTION_USE.getType().equals(outbound.getOutboundTypeSelection())
         || OutboundTypeEnum.CONSTRUCTION_SITE_USE.getType().equals(outbound.getOutboundTypeSelection())) {
         this.getRealTimeAmountDetailDTO(basicClass, moveOutboundDetails, list, false);
         outboundDTO.setBasicClass(basicClass);
         outboundDTO.setList(list);
         return outboundDTO;
      }

      if (OutboundTypeEnum.FOR_SALE.getType().equals(outbound.getOutboundTypeSelection())) {
         List<Long> detailIds = moveOutboundDetails.stream().map(MoveOutboundDetail::getId).collect(Collectors.toList());
         List<WmsForSaleDetail> wmsForSaleDetails = this.wmsForSaleDetailService
            .list((Wrapper<WmsForSaleDetail>)new LambdaQueryWrapper<WmsForSaleDetail>().in(WmsForSaleDetail::getOutboundDetailId, detailIds).exists(WmsForSaleDetailMapper.OUTBOUND_PARENT_EXISTS_SQL));
         this.getDetailSellDTO(basicClass, moveOutboundDetails, list, false, wmsForSaleDetails);
         outboundDTO.setBasicClass(basicClass);
         outboundDTO.setList(list);
         return outboundDTO;
      }

      if (OutboundTypeEnum.TEMPORARY_LOAN.getType().equals(outbound.getOutboundTypeSelection())) {
         List<OutboundDetailDTO> outboundDTOS = cn.hutool.core.bean.BeanUtil.copyToList(moveOutboundDetails, OutboundDetailDTO.class);
         outboundDTOS.forEach(
            outboundDetailDTO -> {
               List<WmsRestitutionDetail> list1 = this.wmsRestitutionDetailService
                  .list(
                     (Wrapper<WmsRestitutionDetail>)(new LambdaQueryWrapper<WmsRestitutionDetail>()
                           .eq(WmsRestitutionDetail::getOutboundDetailId, outboundDetailDTO.getId()))
                        .eq(WmsRestitutionDetail::getRestitutionType, 1)
                  );
               List<WmsRestitutionDetail> list2 = this.wmsRestitutionDetailService
                  .list(
                     (Wrapper<WmsRestitutionDetail>)(new LambdaQueryWrapper<WmsRestitutionDetail>()
                           .eq(WmsRestitutionDetail::getOutboundDetailId, outboundDetailDTO.getId()))
                        .eq(WmsRestitutionDetail::getRestitutionType, 2)
                  );
               if (CollectionUtil.isNotEmpty(list1)) {
                  BigDecimal wmsRestitutionNum = list1.stream()
                     .filter(wmsRestitutionDetail -> wmsRestitutionDetail.getQuantity() != null)
                     .map(WmsRestitutionDetail::getQuantity)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  BigDecimal wmsRestitutionMete = list1.stream()
                     .filter(wmsRestitutionDetail -> wmsRestitutionDetail.getMete() != null)
                     .map(WmsRestitutionDetail::getMete)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  outboundDetailDTO.setWmsRestitutionNum(wmsRestitutionNum);
                  outboundDetailDTO.setWmsRestitutionMete(wmsRestitutionMete);
               }

               if (CollectionUtil.isNotEmpty(list2)) {
                  BigDecimal wmsWastageNum = list2.stream()
                     .filter(wmsRestitutionDetail -> wmsRestitutionDetail.getQuantity() != null)
                     .map(WmsRestitutionDetail::getQuantity)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  BigDecimal wmsWastageMete = list2.stream()
                     .filter(wmsRestitutionDetail -> wmsRestitutionDetail.getMete() != null)
                     .map(WmsRestitutionDetail::getMete)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  outboundDetailDTO.setWmsWastageMete(wmsWastageMete);
                  outboundDetailDTO.setWmsWastageNum(wmsWastageNum);
               }
            }
         );
         outboundDTO.setList(outboundDTOS);
         return outboundDTO;
      }

      if (OutboundTypeEnum.OUTSOURCING_RAW_MATERIALS.getType().equals(outbound.getOutboundTypeSelection())) {
         this.getDetailDTO(basicClass, moveOutboundDetails, list, false);
         outboundDTO.setBasicClass(basicClass);
         outboundDTO.setList(list);
         return outboundDTO;
      }

      if (OutboundTypeEnum.SCRAPS.getType().equals(outbound.getOutboundTypeSelection())) {
         this.getDetailDTO(basicClass, moveOutboundDetails, list, false);
         outboundDTO.setBasicClass(basicClass);
         outboundDTO.setList(list);
         return outboundDTO;
      }

      if (OutboundTypeEnum.SCHEDULING_OUTBOUND.getType().equals(outbound.getOutboundTypeSelection())) {
         WmsPickingApprove one = this.wmsPickingApproveService
            .getOne((Wrapper<WmsPickingApprove>)new LambdaQueryWrapper<WmsPickingApprove>().last("and find_in_set(" + outbound.getId() + ",outbound_ids)"));
         if (ObjectUtil.isNotEmpty(one) && ObjectUtil.isNotEmpty(one.getApproveRecordId())) {
            WmsApproveRecordFlowDTO approveRecordDTO = this.wmsApproveRecordService.getApproveRecordDTO(one.getApproveRecordId());
            outboundDTO.setWmsApproveRecordFlowDTOS(approveRecordDTO);
         }

         this.getRealTimeAmountDetailDTO(basicClass, moveOutboundDetails, list, false);
         outboundDTO.setBasicClass(basicClass);
         outboundDTO.setList(list);
         return outboundDTO;
      } else {
         Preconditions.checkArgument(false, "未知出库类型");
         return null;
      }
   }

   @Override
   public PrintVO<List<OutboundDetailDTO>> outboundPrint(Long id) {
      OutboundDTO outboundDTO = this.getOutboundDTO(id);
      Preconditions.checkArgument(outboundDTO != null, "操作失败，未获取到出库单信息！");
      List<OutboundDetailDTO> detailDTOS = outboundDTO.getList();
      if (CollectionUtil.isNotEmpty(detailDTOS)) {
         List<Boolean> boolPartyAs = detailDTOS.stream().map(OutboundDetailDTO::getBoolPartyA).distinct().collect(Collectors.toList());
         if (boolPartyAs.size() == 1) {
            outboundDTO.setOrderSupplyType(Boolean.TRUE.equals(boolPartyAs.get(0)) ? 2 : 1);
         }

         if (boolPartyAs.size() == 2) {
            outboundDTO.setOrderSupplyType(3);
         }
      }

      PrintVO<List<OutboundDetailDTO>> vo = new PrintVO<>();
      Map<String, Object> header = vo.initHeader(UserUtil.getCurrentName());
      Map<String, Object> headerMap = BeanUtil.beanToMap(outboundDTO);
      header.putAll(headerMap);
      header.remove("list");
      header.remove("wmsApproveRecordFlowDTOS");
      vo.setHeader(header);
      vo.setTable(detailDTOS != null ? detailDTOS : new ArrayList<>());
      return vo;
   }

   @Override
   public MaterialConsumingDTO getMaterialUseAndDeepMete(Long projectId, Long classifyId) {
      MaterialConsumingDTO dto = MaterialConsumingDTO.builder()
         .consumingMete(BigDecimal.ZERO)
         .totalGrossWeight(BigDecimal.ZERO)
         .totalGrossWeight(BigDecimal.ZERO)
         .build();
      Map<String, BigDecimal> meteMap = this.wmsSectionSteelControlTableService.getPartDeepMete(projectId, classifyId);
      dto.setTotalNetWeight(meteMap.getOrDefault("totalNetWeight", BigDecimal.ZERO));
      dto.setTotalGrossWeight(meteMap.getOrDefault("totalGrossWeight", BigDecimal.ZERO));
      BigDecimal outboundMete = this.moveOutboundDetailMapper.getMaterialOutboundMete(projectId, classifyId);
      BigDecimal returnMete = this.returnDetailMapper.getMaterialReturnMete(projectId, classifyId);
      dto.setConsumingMete(outboundMete.subtract(returnMete));
      return dto;
   }

   private void getDetailDTO(int basicClass, List<MoveOutboundDetail> moveOutboundDetails, List<OutboundDetailDTO> list, boolean bool) {
      Map<String, WmsMaterialCodeConfig> materialCodeConfigMaps = this.queryUtil.getMaterialCodeConfigMaps(null);
      Map<String, Unit> unitMap = this.queryUtil.getUnitMap(null);
      List<Measure> measures = this.measureMapper
         .selectList((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getBasicClass, BasicClassEnum.STEEL_PLATE.getType()));

      for (MoveOutboundDetail detail : moveOutboundDetails) {
         basicClass |= detail.getBasicClass();
         OutboundDetailDTO detailDTO = BeanUtil.copy(detail, OutboundDetailDTO.class);
         detailDTO.setNationalStandard(detail.getStandardName());
         detailDTO.setMaterialOutboundMode(detail.getHalfSize() != null ? 2 : 1);
         if (bool) {
            ReturnDetail byOD = this.returnDetailMapper.getByODId(detailDTO.getId());
            if (byOD != null) {
               if (detailDTO.getQuantity() != null) {
                  detailDTO.setQuantity(detailDTO.getQuantity().subtract(byOD.getQuantity()));
               }

               detailDTO.setMete(detailDTO.getMete().subtract(byOD.getMete()));
               if (detailDTO.getAmount() != null) {
                  detailDTO.setAmount(detailDTO.getAmount().subtract(byOD.getAmount()));
                  detailDTO.setAmountExcludingVat(detailDTO.getAmountExcludingVat().subtract(byOD.getAmountExcludingVat()));
               }
            }
         }

         if (detail.getRecipientId() != null) {
            Department dept = this.departmentService.selectByUserId(detail.getRecipientId());
            detailDTO.setRecipient(
               BriefDeptAndNameDTO.builder()
                  .userId(detail.getRecipientId())
                  .name(this.userService.getById(detail.getRecipientId()).getName())
                  .deptName(dept.getName())
                  .build()
            );
         }

         if (detail.getWorkshopId() != null) {
            MesBuildingWorkshop byId = this.mesBuildingWorkshopService.getById(detail.getWorkshopId());
            if (byId != null) {
               detailDTO.setMesWorkshop(BriefIdAndNameDTO.builder().id(byId.getId()).name(byId.getName()).build());
            }
         }

         detailDTO.setSourceWorkshopId(detail.getSourceWorkshopId());
         Workshop byId = this.workshopService.getById(detail.getSourceWorkshopId());
         detailDTO.setWorkshop(BriefIdAndNameDTO.builder().id(byId.getId()).name(byId.getName()).build());
         if (detail.getProjectId() != null) {
            detailDTO.setProject(this.contractProjectService.getSimpleById(detail.getProjectId()));
         }

         if (detail.getSourceProjectId() != null) {
            detailDTO.setSourceProject(this.contractProjectService.getSimpleById(detail.getSourceProjectId()));
         }

         if (detail.getMonomerId() != null) {
            detailDTO.setMonomerName(this.monomerService.getById(detail.getMonomerId()).getName());
         }

         if (detail.getAreaId() != null) {
            detailDTO.setAreaName(this.planAreaService.getById(detail.getAreaId()).getName());
         }

         if (detail.getAreaBatchId() != null) {
            PlanAreaBatch areaBatch = this.planAreaBatchService.getById(detail.getAreaBatchId());
            detailDTO.setAreaBatchName(areaBatch != null ? areaBatch.getName() : null);
         }

         if (detail.getHeatNoAndBatchNo() != null) {
            detailDTO.setHeatNoAndBatchNo(detail.getHeatNoAndBatchNo());
         }

         if (detail.getPurchaseId() != null) {
            PurchaseOrder purchaseOrder = this.purchaseOrderService.getById(detail.getPurchaseId());
            detailDTO.setPurchase(IdAndSerialNumberDO.builder().id(purchaseOrder.getId()).serialNumber(purchaseOrder.getSerialNumber()).build());
         }

         String s1 = this.queryUtil.buildCompositeKey(detailDTO.getClassifyId(), detailDTO.getSpecification(), detailDTO.getThickness());
         WmsMaterialCodeConfig wmsMaterialCodeConfig = materialCodeConfigMaps.get(s1);
         detailDTO.setMaterialSnNew(ObjectUtil.isNotEmpty(wmsMaterialCodeConfig) ? wmsMaterialCodeConfig.getMaterialSnNew() : null);
         Measure measure = this.getMeasure(detailDTO.getClassifyId());
         String[] split = measure.getAccountingUnit().split("/");
         detailDTO.setAccountingUnit(split[0]);
         detailDTO.setAccountingPrecision(measure.getAccountingPrecision());
         if (BasicClassEnum.COLOR_ROLL.getType().equals(detail.getBasicClass()) && detail.getLength() != null) {
            detailDTO.setMeasureUnit("张");
            detailDTO.setMeasurePrecision(0);
         } else {
            detailDTO.setMeasureUnit(measure.getMeasureUnit());
            detailDTO.setMeasurePrecision(measure.getMeasurePrecision());
         }

         detailDTO.setClassifyName(split[1]);
         Warehouse warehouse = this.warehouseMapper.selectById(detail.getWarehouseId());
         detailDTO.setWarehouse(BriefIdAndNameDTO.builder().id(warehouse.getId()).name(warehouse.getName()).build());
         if ((detail.getBasicClass() & 3) > 0) {
            MaterialConsumingDTO dto = this.getMaterialUseAndDeepMete(detail.getProjectId(), detail.getClassifyId());
            Map<Integer, BigDecimal> unitConversion = this.queryUtil
               .unitConversionV2(BigDecimal.ZERO, measures.get(0).getAccountingUnit(), measures.get(0).getAccountingPrecision(), unitMap);
            dto.setConsumingMete(dto.getConsumingMete().divide(unitConversion.get(2), measures.get(0).getAccountingPrecision(), RoundingMode.HALF_UP));
            dto.setTotalNetWeight(dto.getTotalNetWeight().divide(unitConversion.get(2), measures.get(0).getAccountingPrecision(), RoundingMode.HALF_UP));
            dto.setTotalGrossWeight(dto.getTotalGrossWeight().divide(unitConversion.get(2), measures.get(0).getAccountingPrecision(), RoundingMode.HALF_UP));
            detailDTO.setConsumingDTO(Arrays.asList(dto));
         }

         Unit u = unitMap.get(measures.get(0).getAccountingUnit());
         detailDTO.setConsumingUnit(u != null ? u.getSymbol() : measures.get(0).getAccountingUnit());
         list.add(detailDTO);
      }
   }

   private void getRealTimeAmountDetailDTO(int basicClass, List<MoveOutboundDetail> moveOutboundDetails, List<OutboundDetailDTO> list, boolean bool) {
      Map<String, WmsMaterialCodeConfig> materialCodeConfigMaps = this.queryUtil.getMaterialCodeConfigMaps(null);
      this.fillRealTimeAmount(moveOutboundDetails);

      for (MoveOutboundDetail detail : moveOutboundDetails) {
         basicClass |= detail.getBasicClass();
         OutboundDetailDTO detailDTO = BeanUtil.copy(detail, OutboundDetailDTO.class);
         detailDTO.setNationalStandard(detail.getStandardName());
         detailDTO.setMaterialOutboundMode(detail.getHalfSize() != null ? 2 : 1);
         if (bool) {
            ReturnDetail byOD = this.returnDetailMapper.getByODId(detailDTO.getId());
            if (byOD != null) {
               if (detailDTO.getQuantity() != null) {
                  detailDTO.setQuantity(detailDTO.getQuantity().subtract(byOD.getQuantity()));
               }

               detailDTO.setMete(detailDTO.getMete().subtract(byOD.getMete()));
               if (detailDTO.getAmount() != null) {
                  detailDTO.setAmount(detailDTO.getAmount().subtract(byOD.getAmount()));
                  detailDTO.setAmountExcludingVat(detailDTO.getAmountExcludingVat().subtract(byOD.getAmountExcludingVat()));
               }
            }
         }

         if (detail.getRecipientId() != null) {
            Department dept = this.departmentService.selectByUserId(detail.getRecipientId());
            detailDTO.setRecipient(
               BriefDeptAndNameDTO.builder()
                  .userId(detail.getRecipientId())
                  .name(this.userService.getById(detail.getRecipientId()).getName())
                  .deptName(dept.getName())
                  .build()
            );
         }

         if (detail.getWorkshopId() != null) {
            MesBuildingWorkshop byId = this.mesBuildingWorkshopService.getById(detail.getWorkshopId());
            if (byId != null) {
               detailDTO.setMesWorkshop(BriefIdAndNameDTO.builder().id(byId.getId()).name(byId.getName()).build());
            }
         }

         detailDTO.setSourceWorkshopId(detail.getSourceWorkshopId());
         Workshop byId = this.workshopService.getById(detail.getSourceWorkshopId());
         detailDTO.setWorkshop(BriefIdAndNameDTO.builder().id(byId.getId()).name(byId.getName()).build());
         if (detail.getProjectId() != null) {
            detailDTO.setProject(this.contractProjectService.getSimpleById(detail.getProjectId()));
         }

         if (detail.getSourceProjectId() != null) {
            detailDTO.setSourceProject(this.contractProjectService.getSimpleById(detail.getSourceProjectId()));
         }

         if (detail.getMonomerId() != null) {
            detailDTO.setMonomerName(this.monomerService.getById(detail.getMonomerId()).getName());
         }

         if (detail.getAreaId() != null) {
            detailDTO.setAreaName(this.planAreaService.getById(detail.getAreaId()).getName());
         }

         if (detail.getAreaBatchId() != null) {
            PlanAreaBatch areaBatch = this.planAreaBatchService.getById(detail.getAreaBatchId());
            detailDTO.setAreaBatchName(areaBatch != null ? areaBatch.getName() : null);
         }

         if (detail.getHeatNoAndBatchNo() != null) {
            detailDTO.setHeatNoAndBatchNo(detail.getHeatNoAndBatchNo());
         }

         if (detail.getPurchaseId() != null) {
            PurchaseOrder purchaseOrder = this.purchaseOrderService.getById(detail.getPurchaseId());
            detailDTO.setPurchase(IdAndSerialNumberDO.builder().id(purchaseOrder.getId()).serialNumber(purchaseOrder.getSerialNumber()).build());
         }

         String s1 = this.queryUtil.buildCompositeKey(detailDTO.getClassifyId(), detailDTO.getSpecification(), detailDTO.getThickness());
         WmsMaterialCodeConfig wmsMaterialCodeConfig = materialCodeConfigMaps.get(s1);
         detailDTO.setMaterialSnNew(ObjectUtil.isNotEmpty(wmsMaterialCodeConfig) ? wmsMaterialCodeConfig.getMaterialSnNew() : null);
         Measure measure = this.getMeasure(detailDTO.getClassifyId());
         String[] split = measure.getAccountingUnit().split("/");
         detailDTO.setAccountingUnit(split[0]);
         detailDTO.setAccountingPrecision(measure.getAccountingPrecision());
         if (BasicClassEnum.COLOR_ROLL.getType().equals(detail.getBasicClass()) && detail.getLength() != null) {
            detailDTO.setMeasureUnit("张");
            detailDTO.setMeasurePrecision(0);
         } else {
            detailDTO.setMeasureUnit(measure.getMeasureUnit());
            detailDTO.setMeasurePrecision(measure.getMeasurePrecision());
         }

         detailDTO.setClassifyName(split[1]);
         Warehouse warehouse = this.warehouseMapper.selectById(detail.getWarehouseId());
         detailDTO.setWarehouse(BriefIdAndNameDTO.builder().id(warehouse.getId()).name(warehouse.getName()).build());
         list.add(detailDTO);
      }
   }

   private void fillRealTimeAmount(List<MoveOutboundDetail> moveOutboundDetails) {
      if (!CollectionUtil.isEmpty(moveOutboundDetails)) {
         WeightedPriceConf weightedPriceConf = JSON.parseObject(
            this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置")).getValue(), WeightedPriceConf.class
         );
         Map<Long, MonthWeightedAveragePrice> monthWeightedAveragePriceMap = new HashMap<>();
         List<Long> wapIds = moveOutboundDetails.stream()
            .map(MoveOutboundDetail::getWapId)
            .filter(ObjectUtil::isNotEmpty)
            .distinct()
            .collect(Collectors.toList());
         List<MonthWeightedAveragePrice> monthWeightedAveragePriceList = this.monthWAPMapper.selectBatchIds(wapIds);
         if (CollectionUtil.isNotEmpty(wapIds)) {
            monthWeightedAveragePriceMap = monthWeightedAveragePriceList.stream()
               .collect(Collectors.toMap(MonthWeightedAveragePrice::getId, Function.identity()));
         }

         Map<Long, WholeWeightedAveragePrice> wholeWeightedAveragePriceMap = new HashMap<>();
         if (CollectionUtil.isNotEmpty(monthWeightedAveragePriceList)) {
            List<Long> wholeWapId = monthWeightedAveragePriceList.stream()
               .map(MonthWeightedAveragePrice::getWholeWapId)
               .filter(ObjectUtil::isNotEmpty)
               .collect(Collectors.toList());
            if (CollectionUtil.isNotEmpty(wholeWapId)) {
               wholeWeightedAveragePriceMap = this.wholeWAPMapper
                  .selectBatchIds(wholeWapId)
                  .stream()
                  .collect(Collectors.toMap(WholeWeightedAveragePrice::getId, Function.identity()));
            }
         }

         for (MoveOutboundDetail detail : moveOutboundDetails) {
            if (detail.getAmount() == null && detail.getAmountExcludingVat() == null) {
               MonthWeightedAveragePrice price = monthWeightedAveragePriceMap.get(detail.getWapId());
               if (price != null) {
                  if (WeightedPriceEnum.WHOLE.getType().equals(weightedPriceConf.getWeightedType())) {
                     WholeWeightedAveragePrice wholeWeightedAveragePrice = wholeWeightedAveragePriceMap.get(price.getWholeWapId());
                     price.setMete(wholeWeightedAveragePrice.getMete());
                     price.setAmount(wholeWeightedAveragePrice.getAmount());
                     price.setAmountExcludingVat(wholeWeightedAveragePrice.getAmountExcludingVat());
                  }

                  detail.setAmount(BigDecimal.ZERO);
                  detail.setAmountExcludingVat(BigDecimal.ZERO);
                  detail.setUnitPrice(BigDecimal.ZERO);
                  detail.setUnitPriceExcludingVat(BigDecimal.ZERO);
                  detail.setInputVat(BigDecimal.ZERO);
                  if (price.getMete().compareTo(BigDecimal.ZERO) != 0) {
                     BigDecimal p = detail.getMete().divide(price.getMete(), 20, RoundingMode.HALF_UP);
                     BigDecimal amount = price.getAmount().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
                     BigDecimal amountExcludingVat = price.getAmountExcludingVat().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
                     if (detail.getMete().compareTo(BigDecimal.ZERO) != 0) {
                        BigDecimal avgPrice = NumberUtil.div(amount, detail.getMete(), 12);
                        BigDecimal excludingVatAvgPrice = NumberUtil.div(amountExcludingVat, detail.getMete(), 12);
                        detail.setUnitPrice(avgPrice);
                        detail.setUnitPriceExcludingVat(excludingVatAvgPrice);
                     }

                     detail.setAmount(amount);
                     detail.setAmountExcludingVat(amountExcludingVat);
                     detail.setInputVat(amount.subtract(amountExcludingVat));
                  }
               }
            }
         }
      }
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean passed(OutboundDTOParam param) {
      String currentName;
      Long currentUserId;
      if (param.getDefaultId() != null) {
         currentName = param.getDefaultName();
         currentUserId = param.getDefaultId();
      } else {
         currentName = UserUtil.getCurrentName();
         currentUserId = UserUtil.getCurrentUserId();
      }

      LocalDateTime dateTime = LocalDateTime.now();
      Outbound outbound = this.baseMapper.selectById(param.getId());
      Preconditions.checkArgument(outbound != null, "出库单不存在,请核对后操作.");
      Preconditions.checkArgument(StrUtil.isBlank(outbound.getChildOrderNumber()), "该出库为套料出库单，只能app报工之后自动通过");
      Preconditions.checkArgument(
         OutboundStatusEnum.UN_REVIEWED.getType().equals(outbound.getReviewStatus())
            || OutboundStatusEnum.AUDITING.getType().equals(outbound.getReviewStatus()),
         "出库单已审核,请核对后操作"
      );
      List<MoveOutboundDetail> details = this.moveOutboundDetailMapper
         .selectList((Wrapper<MoveOutboundDetail>)Wrappers.<MoveOutboundDetail>lambdaQuery().eq(MoveOutboundDetail::getOutboundId, outbound.getId()));
      Preconditions.checkArgument(details.size() == param.getList().size(), "出库详情变更,请刷新后重试.");
      outbound.setReviewerId(currentUserId);
      outbound.setReviewerName(currentName);
      outbound.setReviewStatus(OutboundStatusEnum.REVIEWED.getType());
      outbound.setReviewTime(dateTime);
      outbound.setOutboundTime(dateTime);
      outbound.setUserUpdateTime(dateTime);

      String serialNumber;
      List<Outbound> wmsApproveRecords;
      do {
         Integer maxDayNumber = this.queryUtil.createInboundSerialNumber("outbound");
         serialNumber = this.numberConfigService.getNumber(NumberTypeEnum.OUTBOUND_REVIEW, maxDayNumber);
         wmsApproveRecords = this.baseMapper.selectList((Wrapper<Outbound>)new LambdaQueryWrapper<Outbound>().eq(Outbound::getSerialNumber, serialNumber));
      } while (!CollectionUtils.isEmpty(wmsApproveRecords));

      outbound.setSerialNumber(serialNumber);
      Long var44 = null;
      MaterialInventory var45 = null;
      outbound.setOutboundStartTime(null);
      outbound.setOutboundEndTime(null);
      WeightedPriceConf var46 = JSON.parseObject(
         this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置")).getValue(), WeightedPriceConf.class
      );
      HashMap transferMap = new HashMap();
      WeightedExecutionPriceConf weightedExecutionPriceConf = JSON.parseObject(
         this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权执行方式配置")).getValue(),
         WeightedExecutionPriceConf.class
      );
      Transfer transfer = null;
      this.queryUtilService.getMaterialInventorys(outbound, details, currentName, currentUserId);

      for (OutboundDetailDTO detailDTO : param.getList()) {
         MoveOutboundDetail outboundDetail = this.moveOutboundDetailMapper.selectById(detailDTO.getId());
         MaterialInventory materialInventory = this.materialInventoryMapper.selectById(outboundDetail.getMaterialInventoryId());
         if (weightedExecutionPriceConf.getWeightedExecutionType() == WeightedPriceTypeEnum.USER.getType()) {
            this.wmsClosingTimeService.checkInventoryMete(detailDTO.getOutboundTime(), materialInventory.getId(), outboundDetail.getMete());
         }

         Measure measure = this.measureMapper
            .selectOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, materialInventory.getClassifyId()));
         String accountingUnit = measure.getAccountingUnit();
         Integer accountingPrecision = measure.getAccountingPrecision();
         BigDecimal unitsPrecision = UnitsPrecisionEnum.getByName(measure.getAccountingUnit());
         MonthWeightedAveragePrice wap = this.weightedAveragePriceService.getPrice(materialInventory);
         outboundDetail.setWapId(wap.getId());
         if (ObjectUtil.isNotEmpty(detailDTO.getOutboundTime())) {
            outboundDetail.setOutboundTime(detailDTO.getOutboundTime());
            WmsClosingTime one = this.wmsClosingTimeService
               .getOne((Wrapper<WmsClosingTime>)(new LambdaQueryWrapper<WmsClosingTime>().orderBy(true, false, WmsClosingTime::getId)).last("limit 1"));
            if (one != null) {
               Preconditions.checkArgument(
                  detailDTO.getOutboundTime().isAfter(one.getEndTime()) && detailDTO.getOutboundTime().isBefore(LocalDateTime.now()),
                  "实际时间不能在实际关账时间之前,请刷新页面重新办理"
               );
            }

            if (outbound.getOutboundStartTime() != null) {
               if (detailDTO.getOutboundTime().compareTo(outbound.getOutboundEndTime()) > 0) {
                  outbound.setOutboundEndTime(detailDTO.getOutboundTime());
               }

               if (detailDTO.getOutboundTime().compareTo(outbound.getOutboundStartTime()) < 0) {
                  outbound.setOutboundStartTime(detailDTO.getOutboundTime());
               }
            } else {
               outbound.setOutboundEndTime(detailDTO.getOutboundTime());
               outbound.setOutboundStartTime(detailDTO.getOutboundTime());
            }
         }

         if (ObjectUtil.isEmpty(outboundDetail.getOutboundTime())) {
            outboundDetail.setOutboundTime(dateTime);
         }

         boolean isBattenOutbound = BasicClassEnum.COLOR_ROLL.getType().equals(outboundDetail.getBasicClass()) && outboundDetail.getLength() != null;
         Integer materialFreezeType = Boolean.TRUE.equals(outbound.getBoolScheduling())
            ? MaterialFreezeTypeEnum.SCHEDULING_OUTBOUND.getType() : MaterialFreezeTypeEnum.OUTBOUND.getType();
         if (OutboundTypeEnum.PRODUCTION_USE.getType().equals(outbound.getOutboundTypeSelection())) {
            materialFreezeType = Boolean.TRUE.equals(outbound.getBoolScheduling())
            ? MaterialFreezeTypeEnum.SCHEDULING_OUTBOUND.getType() : MaterialFreezeTypeEnum.OUTBOUND.getType();
         } else if (OutboundTypeEnum.CONSTRUCTION_SITE_USE.getType().equals(outbound.getOutboundTypeSelection())) {
            materialFreezeType = MaterialFreezeTypeEnum.CONSTRUCTION_SITE_USE.getType();
         }

         this.materialFreezeService.materialUnfreeze(outbound.getId(), outboundDetail.getId(), materialFreezeType, false);
         WasteConfig scrapDefinitionConf = this.basicConfigService.getSteelScrapDefinitionConf();
         StatisticsEndPeriod surplusEndPeriod = null;
         BigDecimal oneMete = BigDecimal.ZERO;
         if (isBattenOutbound) {
            Preconditions.checkArgument(false, "出库失败！！！");
         } else {
            materialInventory.setMete(materialInventory.getMete().subtract(outboundDetail.getMete()));
            materialInventory.setQuantity(outboundDetail.getQuantity() != null ? materialInventory.getQuantity().subtract(outboundDetail.getQuantity()) : null);
            if (BasicClassEnum.COLOR_ROLL.getType().equals(materialInventory.getBasicClass())) {
               if (materialInventory.getQuantity().compareTo(BigDecimal.ZERO) > 0) {
                  if (scrapDefinitionConf.getSteelCoilMinLength().compareTo(materialInventory.getQuantity()) >= 0) {
                     Scrap scrap = BeanUtil.copy(materialInventory, Scrap.class, "createTime");
                     scrap.setQuantity(materialInventory.getQuantity());
                     scrap.setMete(materialInventory.getMete());
                     scrap.setWidth(materialInventory.getWidth());
                     scrap.setCreateTime(LocalDateTime.now());
                     this.scrapMapper.insert(scrap);
                     this.materialInventoryMapper.deleteById(materialInventory);
                     this.wmsUtil
                        .setInventoryUse(materialInventory, scrap.getQuantity(), scrap.getMete(), ReceiptTypeEnum.SCRAP_MATERIAL, scrap.getId(), null, 1, false);
                  } else {
                     this.materialInventoryMapper.updateById(materialInventory);
                  }
               } else {
                  this.materialInventoryMapper.deleteById(materialInventory);
               }
            } else if (materialInventory.getMete().compareTo(BigDecimal.ZERO) == 0) {
               this.materialInventoryMapper.deleteById(materialInventory);
            } else {
               if (materialInventory.getQuantity() != null) {
                  materialInventory.setUseStatus(materialInventory.getQuantity().compareTo(BigDecimal.ZERO) == 0);
               }

               this.materialInventoryMapper.updateById(materialInventory);
            }

            this.wmsUtil
               .setInventoryUse(
                  materialInventory,
                  outboundDetail.getQuantity(),
                  outboundDetail.getMete(),
                  ReceiptTypeEnum.OUTBOUND,
                  outbound.getId(),
                  outbound.getSerialNumber(),
                  2,
                  true
               );
            Statistics statistics = this.statisticsMapper.get(materialInventory);
            this.setStatisticsEndPeriod(materialInventory, statistics);
            var44 = statistics.getId();
            long outPId = outboundDetail.getProjectId() != null ? outboundDetail.getProjectId() : -1L;
            long sourcePId = materialInventory.getProjectId() != null ? materialInventory.getProjectId() : -1L;
            if (outPId != sourcePId) {
               String key = outPId + "-" + materialInventory.getWorkshopId() + "-" + materialInventory.getWarehouseId();
               if (!transferMap.containsKey(key)) {
                  transfer = Transfer.builder()
                     .basicClass(outboundDetail.getBasicClass())
                     .directionProjectId(outboundDetail.getProjectId())
                     .directionWorkshopId(materialInventory.getWorkshopId())
                     .directionWarehouseId(materialInventory.getWarehouseId())
                     .directionMonomerId(outboundDetail.getMonomerId())
                     .directionAreaId(outboundDetail.getAreaId())
                     .transferType(TransferTypeEnum.PROJECT_WARE.getType())
                     .reviewStatus(ReviewStatusEnum.REVIEWED.getType())
                     .applicantId(currentUserId)
                     .editorId(currentUserId)
                     .applicantName(currentName)
                     .editorName(currentName)
                     .reviewerName(currentName)
                     .reviewTime(dateTime)
                     .reviewerId(currentUserId)
                     .userUpdateTime(dateTime)
                     .transferCreateType(2)
                     .outboundSn(outbound.getSerialNumber())
                     .outboundId(outbound.getId())
                     .build();
                  Integer count = this.transferMapper.getMaxDayNumber(LocalDateTime.now());
                  String sn = this.numberConfigService.getNumber(NumberTypeEnum.TRANSFER, count);
                  transfer.setSerialNumber(sn);
                  this.transferMapper.insert(transfer);
                  transferMap.put(key, transfer);
               } else {
                  transfer = (Transfer)transferMap.get(key);
               }

               MaterialInventory copy = BeanUtil.copy(materialInventory, MaterialInventory.class);
               copy.setMete(outboundDetail.getMete());
               PriceDTO price = this.queryUtilService.getPrice(var46, weightedExecutionPriceConf, copy, outboundDetail.getOutboundTime());
               BigDecimal amount = price.getAmount();
               BigDecimal amountExcludingVat = price.getAmountExcludingVat();
               BigDecimal amountNoFreight = price.getAmountNoFreight();
               BigDecimal amountExcludingVatNoFreight = price.getAmountExcludingVatNoFreight();
               TransferDetail transferDetail = TransferDetail.builder()
                  .boolPartyA(materialInventory.getBoolPartyA())
                  .transferId(transfer.getId())
                  .materialInventoryId(materialInventory.getId())
                  .specification(materialInventory.getSpecification())
                  .basicClass(materialInventory.getBasicClass())
                  .length(materialInventory.getLength())
                  .width(materialInventory.getWidth())
                  .thickness(materialInventory.getThickness())
                  .brand(materialInventory.getBrand())
                  .heatNoAndBatchNo(materialInventory.getHeatNoAndBatchNo())
                  .classifyId(materialInventory.getClassifyId())
                  .transferType(TransferTypeEnum.PROJECT_WARE.getType())
                  .sourceWorkshopId(materialInventory.getWorkshopId())
                  .sourceWarehouseId(materialInventory.getWarehouseId())
                  .sourceProjectId(materialInventory.getProjectId())
                  .sourceMonomerId(materialInventory.getMonomerId())
                  .sourceAreaId(materialInventory.getAreaId())
                  .mete(outboundDetail.getMete())
                  .quantity(outboundDetail.getQuantity())
                  .color(materialInventory.getColor())
                  .remark(outboundDetail.getRemark())
                  .taxRate(materialInventory.getTaxRate())
                  .invoiceType(materialInventory.getInvoiceType())
                  .standardId(materialInventory.getStandardId())
                  .standardName(materialInventory.getStandardName())
                  .realTime(outboundDetail.getOutboundTime())
                  .build();
               if (amount.compareTo(BigDecimal.ZERO) != 0) {
                  transferDetail.setUnitPrice(amount.divide(outboundDetail.getMete(), 12, RoundingMode.HALF_UP));
                  transferDetail.setUnitPriceExcludingVat(amountExcludingVat.divide(outboundDetail.getMete(), 12, RoundingMode.HALF_UP));
               } else {
                  transferDetail.setUnitPrice(BigDecimal.ZERO);
                  transferDetail.setUnitPriceExcludingVat(BigDecimal.ZERO);
               }

               transferDetail.setAmount(amount);
               transferDetail.setAmountExcludingVat(amountExcludingVat);
               transferDetail.setInputVat(transferDetail.getAmount().subtract(transferDetail.getAmountExcludingVat()));
               if (amountNoFreight.compareTo(BigDecimal.ZERO) != 0) {
                  transferDetail.setUnitPriceNoFreight(amountNoFreight.divide(outboundDetail.getMete(), 12, RoundingMode.HALF_UP));
                  transferDetail.setUnitPriceExcludingVatNoFreight(amountExcludingVatNoFreight.divide(outboundDetail.getMete(), 12, RoundingMode.HALF_UP));
               } else {
                  transferDetail.setUnitPriceNoFreight(BigDecimal.ZERO);
                  transferDetail.setUnitPriceExcludingVatNoFreight(BigDecimal.ZERO);
               }

               transferDetail.setAmountNoFreight(amountNoFreight);
               transferDetail.setAmountExcludingVatNoFreight(amountExcludingVatNoFreight);
               transferDetail.setInputVatNoFreight(transferDetail.getAmountNoFreight().subtract(transferDetail.getAmountExcludingVatNoFreight()));
               this.transferDetailMapper.insert(transferDetail);
               if (transferDetail.getQuantity() != null && outboundDetail.getHalfMode() == null) {
                  wap.setQuantity(wap.getQuantity().subtract(transferDetail.getQuantity()));
               }

               wap.setMete(wap.getMete().subtract(transferDetail.getMete()));
               if (WeightedPriceEnum.SINGLE.getType().equals(var46.getWeightedType())) {
                  wap.setAmount(wap.getAmount().subtract(amount));
                  wap.setAmountExcludingVat(wap.getAmountExcludingVat().subtract(amountExcludingVat));
                  wap.setAmountNoFreight(wap.getAmountNoFreight().subtract(amountNoFreight));
                  wap.setAmountExcludingVatNoFreight(wap.getAmountExcludingVatNoFreight().subtract(amountExcludingVatNoFreight));
               }

               this.monthWeightedAveragePriceMapper.updateById(wap);
               statistics.setTransferMete(
                  statistics.getTransferMete() != null ? statistics.getTransferMete().subtract(transferDetail.getMete()) : transferDetail.getMete().negate()
               );
               if (transferDetail.getQuantity() != null) {
                  statistics.setTransferQuantity(
                     statistics.getTransferQuantity() != null
                        ? statistics.getTransferQuantity().subtract(transferDetail.getQuantity())
                        : transferDetail.getQuantity().negate()
                  );
               }

               statistics.setTransferUnitPrice(transferDetail.getUnitPrice());
               statistics.setTransferUnitPriceExcludingVat(transferDetail.getUnitPriceExcludingVat());
               statistics.setTransferAmount(statistics.getTransferAmount() != null ? statistics.getTransferAmount().subtract(amount) : amount.negate());
               statistics.setTransferAmountExcludingVat(
                  statistics.getTransferAmountExcludingVat() != null
                     ? statistics.getTransferAmountExcludingVat().subtract(amountExcludingVat)
                     : amountExcludingVat.negate()
               );
               statistics.setTransferUnitPriceNoFreight(transferDetail.getUnitPriceNoFreight());
               statistics.setTransferUnitPriceExcludingVatNoFreight(transferDetail.getUnitPriceExcludingVatNoFreight());
               statistics.setTransferAmountNoFreight(
                  statistics.getTransferAmountNoFreight() != null
                     ? statistics.getTransferAmountNoFreight().subtract(amountNoFreight)
                     : amountNoFreight.negate()
               );
               statistics.setTransferAmountExcludingVatNoFreight(
                  statistics.getTransferAmountExcludingVatNoFreight() != null
                     ? statistics.getTransferAmountExcludingVatNoFreight().subtract(amountExcludingVatNoFreight)
                     : amountExcludingVatNoFreight.negate()
               );
               StatisticsInbound si = BeanUtil.copy(materialInventory, StatisticsInbound.class, "createTime");
               si.setMaterialInventoryId(materialInventory.getId());
               si.setReceiptType(ReceiptTypeEnum.TRANSFER.getType());
               si.setReceiptId(transfer.getId());
               si.setReceiptSerialNumber(transfer.getSerialNumber());
               si.setStatisticsId(statistics.getId());
               si.setMete(transferDetail.getMete().negate());
               if (materialInventory.getQuantity() != null) {
                  si.setQuantity(transferDetail.getQuantity().negate());
               }

               si.setUnitPrice(transferDetail.getUnitPrice());
               si.setUnitPriceExcludingVat(transferDetail.getUnitPriceExcludingVat());
               si.setAmount(transferDetail.getAmount().negate());
               si.setAmountExcludingVat(transferDetail.getAmountExcludingVat().negate());
               si.setRealTime(outboundDetail.getOutboundTime());
               si.setUnitPriceNoFreight(transferDetail.getUnitPriceNoFreight());
               si.setUnitPriceExcludingVatNoFreight(transferDetail.getUnitPriceExcludingVatNoFreight());
               si.setAmountNoFreight(transferDetail.getAmountNoFreight().negate());
               si.setAmountExcludingVatNoFreight(transferDetail.getAmountExcludingVatNoFreight().negate());
               this.statisticsInboundMapper.insert(si);
               MaterialInventory inventory = BeanUtil.copy(materialInventory, MaterialInventory.class);
               inventory.setId(-1L);
               inventory.setProjectId(outboundDetail.getProjectId());
               inventory.setWorkshopId(outboundDetail.getSourceWorkshopId());
               InboundDetail inboundDetail = InboundDetail.builder()
                  .basicClass(inventory.getBasicClass())
                  .classifyId(inventory.getClassifyId())
                  .accountingUnit(inventory.getAccountingUnit())
                  .length(inventory.getLength())
                  .width(inventory.getWidth())
                  .thickness(inventory.getThickness())
                  .brand(inventory.getBrand())
                  .heatNoAndBatchNo(inventory.getHeatNoAndBatchNo())
                  .specification(inventory.getSpecification())
                  .color(inventory.getColor())
                  .unitNet(inventory.getUnitNet())
                  .quantity(outboundDetail.getQuantity())
                  .mete(outboundDetail.getMete())
                  .workshopId(transfer.getDirectionWorkshopId())
                  .warehouseId(transfer.getDirectionWarehouseId())
                  .measureUnit(inventory.getMeasureUnit())
                  .taxRate(inventory.getTaxRate())
                  .invoiceType(inventory.getInvoiceType())
                  .standardName(inventory.getStandardName())
                  .standardId(inventory.getStandardId())
                  .oneTheoryWeight(inventory.getOneTheoryWeight())
                  .sectionSteelWeight(inventory.getSectionSteelWeight())
                  .boolPartyA(inventory.getBoolPartyA())
                  .amount(amount)
                  .amountExcludingVat(amountExcludingVat)
                  .unitPrice(transferDetail.getUnitPrice())
                  .unitPriceExcludingVat(transferDetail.getUnitPriceExcludingVat())
                  .amountNoFreight(amountNoFreight)
                  .amountExcludingVatNoFreight(amountExcludingVatNoFreight)
                  .unitPriceNoFreight(transferDetail.getUnitPriceNoFreight())
                  .unitPriceExcludingVatNoFreight(transferDetail.getUnitPriceExcludingVatNoFreight())
                  .projectId(outboundDetail.getProjectId())
                  .realTime(outboundDetail.getOutboundTime())
                  .build();
               Statistics targetStatistics = this.weightedAveragePriceService
                  .createMonthWAP(inboundDetail, inventory, transfer.getId(), transfer.getSerialNumber(), ReceiptTypeEnum.TRANSFER.getType());
               targetStatistics.setOutboundMete(
                  targetStatistics.getOutboundMete() != null ? targetStatistics.getOutboundMete().add(outboundDetail.getMete()) : outboundDetail.getMete()
               );
               targetStatistics.setOutboundQuantity(
                  targetStatistics.getOutboundQuantity() != null
                     ? targetStatistics.getOutboundQuantity().add(outboundDetail.getQuantity())
                     : outboundDetail.getQuantity()
               );
               targetStatistics.setEndMete(targetStatistics.getEndMete().subtract(outboundDetail.getMete()));
               if (targetStatistics.getEndQuantity() != null) {
                  targetStatistics.setEndQuantity(targetStatistics.getEndQuantity().subtract(outboundDetail.getQuantity()));
               }

               this.statisticsMapper.updateById(targetStatistics);
               outboundDetail.setWapId(targetStatistics.getWapId());
               var44 = targetStatistics.getId();
            }

            if (statistics.getId().equals(var44)) {
               statistics.setOutboundMete(
                  statistics.getOutboundMete() != null ? outboundDetail.getMete().add(statistics.getOutboundMete()) : outboundDetail.getMete()
               );
               statistics.setOutboundQuantity(
                  statistics.getOutboundQuantity() != null ? outboundDetail.getQuantity().add(statistics.getOutboundQuantity()) : outboundDetail.getQuantity()
               );
            }

            statistics.setEndMete(statistics.getEndMete().subtract(outboundDetail.getMete()));
            if (statistics.getEndQuantity() != null && surplusEndPeriod == null) {
               statistics.setEndQuantity(statistics.getEndQuantity().subtract(outboundDetail.getQuantity()));
            }

            this.statisticsMapper.updateById(statistics);
            this.saveStatisticsOutbound(outbound, outboundDetail, materialInventory, var44);
            MaterialReturnable materialReturnable = MaterialReturnable.builder()
               .sourceWorkshopId(materialInventory.getWorkshopId())
               .classifyId(materialInventory.getClassifyId())
               .classifyName(materialInventory.getClassifyName())
               .boolPartyA(materialInventory.getBoolPartyA())
               .outboundUnitType(measure.getOutboundUnitType())
               .basicClass(materialInventory.getBasicClass())
               .specification(materialInventory.getSpecification())
               .mete(outboundDetail.getMete())
               .accountingUnit(materialInventory.getAccountingUnit())
               .returnableMete(outboundDetail.getMete())
               .quantity(outboundDetail.getQuantity())
               .unitNet(materialInventory.getUnitNet())
               .length(outboundDetail.getLength())
               .width(outboundDetail.getWidth())
               .thickness(materialInventory.getThickness())
               .theoryThickness(materialInventory.getTheoryThickness())
               .brand(materialInventory.getBrand())
               .heatNoAndBatchNo(materialInventory.getHeatNoAndBatchNo())
               .color(materialInventory.getColor())
               .projectId(outboundDetail.getProjectId())
               .outboundId(outbound.getId())
               .outboundSn(outbound.getSerialNumber())
               .outboundDetailId(outboundDetail.getId())
               .warehouseId(materialInventory.getWarehouseId())
               .outboundTime(outboundDetail.getOutboundTime())
               .weightedAverageSpec(materialInventory.getWeightedAverageSpec())
               .taxRate(outboundDetail.getTaxRate())
               .invoiceType(outboundDetail.getInvoiceType())
               .boolReviewPending(false)
               .boolReturn(true)
               .standardId(materialInventory.getStandardId())
               .standardName(materialInventory.getStandardName())
               .sectionSteelWeight(materialInventory.getSectionSteelWeight())
               .oneTheoryWeight(materialInventory.getOneTheoryWeight())
               .materialSn(materialInventory.getSerialNumber())
               .monomerId(outboundDetail.getMonomerId())
               .areaId(outboundDetail.getAreaId())
               .workshopId(outboundDetail.getWorkshopId())
               .areaBatchId(outboundDetail.getAreaBatchId())
               .build();
            if (outboundDetail.getRecipientId() != null) {
               materialReturnable.setRecipientId(outboundDetail.getRecipientId());
               materialReturnable.setRecipientName(this.userService.getById(outboundDetail.getRecipientId()).getName());
            }

            if (MaterialIsWholeEnum.WHOLE.getType().equals(materialInventory.getMaterialIsWhole())) {
               if (outboundDetail.getOutboundType() == 1) {
                  materialReturnable.setMaterialIsWhole(MaterialIsWholeEnum.WHOLE.getType());
               } else {
                  materialReturnable.setMaterialIsWhole(MaterialIsWholeEnum.ODDMENT.getType());
               }
            } else {
               materialReturnable.setMaterialIsWhole(MaterialIsWholeEnum.ODDMENT.getType());
            }

            if (BasicClassEnum.SECTION_STEEL.getType().equals(materialInventory.getBasicClass())) {
               if (MaterialOutboundModeEnum.HALF.getType().equals(outboundDetail.getOutboundType())) {
                  Preconditions.checkArgument(false, "半出失败");
                  materialReturnable.setSingleReturnableLength(outboundDetail.getLength());
               } else {
                  materialReturnable.setSingleReturnableLength(materialInventory.getLength());
               }
            }

            if (BasicClassEnum.COLOR_ROLL.getType().equals(materialInventory.getBasicClass())) {
               materialReturnable.setSingleMete(outboundDetail.getMete());
               materialReturnable.setSingleReturnableMete(outboundDetail.getMete());
            } else if (MeasureTypeEnum.MEASURE.getType().equals(measure.getOutboundUnitType())) {
               if (BasicClassEnum.SECTION_STEEL.getType().equals(materialInventory.getBasicClass())
                  || BasicClassEnum.STEEL_PLATE.getType().equals(materialInventory.getBasicClass())) {
                  BigDecimal singleMete = outboundDetail.getMete().divide(outboundDetail.getQuantity(), 8, RoundingMode.DOWN);
                  BigDecimal multiply = singleMete;
                  materialReturnable.setSingleMete(multiply);
                  materialReturnable.setSingleReturnableMete(multiply);
               }
            } else {
               materialReturnable.setSingleMete(outboundDetail.getMete());
               materialReturnable.setSingleReturnableMete(outboundDetail.getMete());
            }

            this.materialReturnableMapper.insert(materialReturnable);
         }

         this.moveOutboundDetailMapper.updateById(outboundDetail);
         this.warningService.updateStatus(materialInventory, 2);
      }

      if (var45 != null) {
         BigDecimal outboundMete = outbound.getOutboundMete();
         BigDecimal outboundLength = outbound.getOutboundLength();
         var45.setMete(var45.getMete().subtract(outboundMete));
         var45.setQuantity(var45.getQuantity().subtract(outboundLength));
         if (var45.getQuantity().compareTo(BigDecimal.ZERO) > 0) {
            this.materialInventoryMapper.updateById((MaterialInventory)var45);
         } else {
            this.materialInventoryMapper.deleteById((Serializable)var45);
         }

         this.wmsUtil
            .setInventoryUse(
               (MaterialInventory)var45, outboundLength, outboundMete, ReceiptTypeEnum.OUTBOUND, outbound.getId(), outbound.getSerialNumber(), 2, true
            );
         Statistics statistics = this.statisticsMapper.selectById(var44);
         this.setStatisticsEndPeriod((MaterialInventory)var45, statistics);
         statistics.setOutboundMete(statistics.getOutboundMete() != null ? outboundMete.add(statistics.getOutboundMete()) : outboundMete);
         statistics.setOutboundQuantity(statistics.getOutboundQuantity() != null ? outboundLength.add(statistics.getOutboundQuantity()) : outboundLength);
         statistics.setEndMete(statistics.getEndMete().subtract(outboundMete));
         statistics.setEndQuantity(statistics.getEndQuantity().subtract(outboundLength));
         this.statisticsMapper.updateById(statistics);
      }

      if (outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.CONSTRUCTION_SITE_USE.getType())) {
         this.saveMesOutboundDetail(outbound);
      }

      if (outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.PRODUCTION_USE.getType())) {
         this.outboundRemindService.saveOutboundRemind(outbound);
      }

      return this.baseMapper.updateById(outbound) == 1;
   }

   private void saveMesOutboundDetail(Outbound outbound) {
      List<MoveOutboundDetail> moveOutboundDetails = this.moveOutboundDetailMapper
         .selectList((Wrapper<MoveOutboundDetail>)new LambdaQueryWrapper<MoveOutboundDetail>().eq(MoveOutboundDetail::getOutboundId, outbound.getId()));
      if (!CollectionUtil.isEmpty(moveOutboundDetails)) {
         List<Long> classifyIds = new ArrayList<>();
         List<Long> materialInventoryIds = new ArrayList<>();

         for (MoveOutboundDetail moveOutboundDetail : moveOutboundDetails) {
            classifyIds.add(moveOutboundDetail.getClassifyId());
            materialInventoryIds.add(moveOutboundDetail.getMaterialInventoryId());
         }

         Map<String, Unit> unitMap = this.unitMapper.selectList(null).stream().collect(Collectors.toMap(Unit::getName, Function.identity()));
         Map<Long, Measure> measureMap = this.queryUtil.getMeasureMapByClassifyIds(classifyIds);
         Map<Long, Classification> classificationMap = this.queryUtilService.getClassificationMap(classifyIds);
         Map<Long, MaterialInventory> materialInventoryMap = this.materialInventoryMapper
            .selectAllByIds(materialInventoryIds)
            .stream()
            .collect(Collectors.toMap(MaterialInventory::getId, Function.identity()));
         List<SubscribeAuxiliaryWarehouseDTO> subscribeAuxiliaryWarehouseDTOS = moveOutboundDetails.stream()
            .map(
               m -> {
                  Measure measure = measureMap.get(m.getClassifyId());
                  Classification classification = classificationMap.get(m.getClassifyId());
                  MaterialInventory materialInventory = materialInventoryMap.get(m.getMaterialInventoryId());
                  Integer quantity = 0;
                  String measureUnitStr = "";
                  BigDecimal mete = BigDecimal.ZERO;
                  String accountingUnitStr = "";
                  Unit unit = unitMap.get(measure.getAccountingUnit());
                  if (unit.getType().equals(UnitEnum.DIGIT.getType())) {
                     mete = m.getMete();
                     accountingUnitStr = measure.getAccountingUnit();
                  } else if (unit.getType().equals(UnitEnum.WEIGHT.getType())) {
                     if (unit.getName().equals("克")) {
                        mete = m.getMete();
                        accountingUnitStr = "克";
                     } else if (!unit.getName().equals("千克") && !unit.getName().equals("吨")) {
                        mete = m.getMete();
                        accountingUnitStr = measure.getAccountingUnit();
                     } else {
                        mete = m.getMete().divide(UnitsPrecisionEnum.EG_KG.getRate());
                        accountingUnitStr = "千克";
                     }
                  } else if (unit.getType().equals(UnitEnum.LENGTH.getType())) {
                     if (unit.getName().equals("毫米")) {
                        mete = m.getMete();
                        accountingUnitStr = "毫米";
                     } else if (unit.getName().equals("厘米")) {
                        mete = m.getMete().divide(UnitsPrecisionEnum.LG_CM.getRate());
                        accountingUnitStr = "厘米";
                     } else if (unit.getName().equals("分米")) {
                        mete = m.getMete().divide(UnitsPrecisionEnum.LG_DM.getRate());
                        accountingUnitStr = "分米";
                     } else if (!unit.getName().equals("米") && !unit.getName().equals("千米")) {
                        mete = m.getMete();
                        accountingUnitStr = measure.getAccountingUnit();
                     } else {
                        mete = m.getMete().divide(UnitsPrecisionEnum.LG_M.getRate());
                        accountingUnitStr = "米";
                     }
                  } else if (unit.getType().equals(UnitEnum.AREA.getType())) {
                     if (unit.getName().equals("平方毫米")) {
                        mete = m.getMete();
                        accountingUnitStr = "平方毫米";
                     } else if (unit.getName().equals("平方厘米")) {
                        mete = m.getMete().divide(UnitsPrecisionEnum.AG_CM.getRate());
                        accountingUnitStr = "平方厘米";
                     } else if (unit.getName().equals("平方分米")) {
                        mete = m.getMete().divide(UnitsPrecisionEnum.AG_DM.getRate());
                        accountingUnitStr = "平方分米";
                     } else if (!unit.getName().equals("平方米") && !unit.getName().equals("公顷") && !unit.getName().equals("平方千米")) {
                        mete = m.getMete();
                        accountingUnitStr = measure.getAccountingUnit();
                     } else {
                        mete = m.getMete().divide(UnitsPrecisionEnum.AG_M.getRate());
                        accountingUnitStr = "平方米";
                     }
                  } else if (unit.getType().equals(UnitEnum.VOLUME.getType())) {
                     if (unit.getName().equals("立方毫米")) {
                        mete = m.getMete();
                        accountingUnitStr = "立方毫米";
                     } else if (unit.getName().equals("立方厘米")) {
                        mete = m.getMete().divide(UnitsPrecisionEnum.VG_CM.getRate());
                        accountingUnitStr = "立方厘米";
                     } else if (unit.getName().equals("立方分米")) {
                        mete = m.getMete().divide(UnitsPrecisionEnum.VG_DM.getRate());
                        accountingUnitStr = "立方分米";
                     } else if (unit.getName().equals("立方米")) {
                        mete = m.getMete().divide(UnitsPrecisionEnum.VG_M.getRate());
                        accountingUnitStr = "立方米";
                     }

                     if (unit.getName().equals("微升")) {
                        mete = m.getMete();
                        accountingUnitStr = "微升";
                     } else if (unit.getName().equals("毫升")) {
                        mete = m.getMete().divide(UnitsPrecisionEnum.ML.getRate());
                        accountingUnitStr = "毫升";
                     } else if (unit.getName().equals("厘升")) {
                        mete = m.getMete().divide(UnitsPrecisionEnum.CL.getRate());
                        accountingUnitStr = "厘升";
                     } else if (unit.getName().equals("分升")) {
                        mete = m.getMete().divide(UnitsPrecisionEnum.DL.getRate());
                        accountingUnitStr = "分升";
                     } else if (unit.getName().equals("升")) {
                        mete = m.getMete().divide(UnitsPrecisionEnum.L.getRate());
                        accountingUnitStr = "升";
                     }

                     if (ObjectUtil.isNotEmpty(measure.getAccountingUnit())) {
                        mete = m.getMete();
                        accountingUnitStr = measure.getAccountingUnit();
                     }
                  }

                  if (ObjectUtil.isNotEmpty(measure.getMeasureUnit())) {
                     unit = unitMap.get(measure.getMeasureUnit());
                     if (unit.getType().equals(UnitEnum.DIGIT.getType())) {
                        quantity = m.getQuantity().setScale(0, this.ROUNDING).intValue();
                        measureUnitStr = measure.getMeasureUnit();
                     } else if (unit.getType().equals(UnitEnum.WEIGHT.getType())) {
                        if (unit.getName().equals("克")) {
                           quantity = m.getQuantity().setScale(0, this.ROUNDING).intValue();
                           measureUnitStr = "克";
                        } else if (!unit.getName().equals("千克") && !unit.getName().equals("吨")) {
                           quantity = m.getQuantity().setScale(0, this.ROUNDING).intValue();
                           measureUnitStr = measure.getMeasureUnit();
                        } else {
                           quantity = m.getQuantity().divide(UnitsPrecisionEnum.EG_KG.getRate()).setScale(0, this.ROUNDING).intValue();
                           measureUnitStr = "千克";
                        }
                     } else if (unit.getType().equals(UnitEnum.LENGTH.getType())) {
                        if (unit.getName().equals("毫米")) {
                           quantity = m.getQuantity().setScale(0, this.ROUNDING).intValue();
                           measureUnitStr = "毫米";
                        } else if (unit.getName().equals("厘米")) {
                           quantity = m.getQuantity().divide(UnitsPrecisionEnum.LG_CM.getRate()).setScale(0, this.ROUNDING).intValue();
                           measureUnitStr = "厘米";
                        } else if (unit.getName().equals("分米")) {
                           quantity = m.getQuantity().divide(UnitsPrecisionEnum.LG_DM.getRate()).setScale(0, this.ROUNDING).intValue();
                           measureUnitStr = "分米";
                        } else if (!unit.getName().equals("米") && !unit.getName().equals("千米")) {
                           quantity = m.getQuantity().setScale(0, this.ROUNDING).intValue();
                           measureUnitStr = measure.getMeasureUnit();
                        } else {
                           quantity = m.getQuantity().divide(UnitsPrecisionEnum.LG_M.getRate()).setScale(0, this.ROUNDING).intValue();
                           measureUnitStr = "米";
                        }
                     } else if (unit.getType().equals(UnitEnum.AREA.getType())) {
                        if (unit.getName().equals("平方毫米")) {
                           quantity = m.getQuantity().setScale(0, this.ROUNDING).intValue();
                           measureUnitStr = "平方毫米";
                        } else if (unit.getName().equals("平方厘米")) {
                           quantity = m.getQuantity().divide(UnitsPrecisionEnum.AG_CM.getRate()).setScale(0, this.ROUNDING).intValue();
                           measureUnitStr = "平方厘米";
                        } else if (unit.getName().equals("平方分米")) {
                           quantity = m.getQuantity().divide(UnitsPrecisionEnum.AG_DM.getRate()).setScale(0, this.ROUNDING).intValue();
                           measureUnitStr = "平方分米";
                        } else if (!unit.getName().equals("平方米") && !unit.getName().equals("公顷") && !unit.getName().equals("平方千米")) {
                           quantity = m.getQuantity().setScale(0, this.ROUNDING).intValue();
                           measureUnitStr = measure.getMeasureUnit();
                        } else {
                           quantity = m.getQuantity().divide(UnitsPrecisionEnum.AG_M.getRate()).setScale(0, this.ROUNDING).intValue();
                           measureUnitStr = "平方米";
                        }
                     } else if (unit.getType().equals(UnitEnum.VOLUME.getType())) {
                        if (unit.getName().equals("立方毫米")) {
                           quantity = m.getQuantity().setScale(0, this.ROUNDING).intValue();
                           measureUnitStr = "立方毫米";
                        } else if (unit.getName().equals("立方厘米")) {
                           quantity = m.getQuantity().divide(UnitsPrecisionEnum.VG_CM.getRate()).setScale(0, this.ROUNDING).intValue();
                           measureUnitStr = "立方厘米";
                        } else if (unit.getName().equals("立方分米")) {
                           quantity = m.getQuantity().divide(UnitsPrecisionEnum.VG_DM.getRate()).setScale(0, this.ROUNDING).intValue();
                           measureUnitStr = "立方分米";
                        } else if (unit.getName().equals("立方米")) {
                           quantity = m.getQuantity().divide(UnitsPrecisionEnum.VG_M.getRate()).setScale(0, this.ROUNDING).intValue();
                           measureUnitStr = "立方米";
                        }

                        if (unit.getName().equals("微升")) {
                           quantity = m.getQuantity().setScale(0, this.ROUNDING).intValue();
                           measureUnitStr = "微升";
                        } else if (unit.getName().equals("毫升")) {
                           quantity = m.getQuantity().divide(UnitsPrecisionEnum.ML.getRate()).setScale(0, this.ROUNDING).intValue();
                           measureUnitStr = "毫升";
                        } else if (unit.getName().equals("厘升")) {
                           quantity = m.getQuantity().divide(UnitsPrecisionEnum.CL.getRate()).setScale(0, this.ROUNDING).intValue();
                           measureUnitStr = "厘升";
                        } else if (unit.getName().equals("分升")) {
                           quantity = m.getQuantity().divide(UnitsPrecisionEnum.DL.getRate()).setScale(0, this.ROUNDING).intValue();
                           measureUnitStr = "分升";
                        } else if (unit.getName().equals("升")) {
                           quantity = m.getQuantity().divide(UnitsPrecisionEnum.L.getRate()).setScale(0, this.ROUNDING).intValue();
                           measureUnitStr = "升";
                        }

                        if (ObjectUtil.isEmpty(measureUnitStr)) {
                           quantity = m.getQuantity().setScale(0, this.ROUNDING).intValue();
                           measureUnitStr = measure.getMeasureUnit();
                        }
                     }
                  } else {
                     quantity = mete.setScale(0, this.ROUNDING).intValue();
                  }

                  return SubscribeAuxiliaryWarehouseDTO.builder()
                     .projectId(m.getProjectId())
                     .materialInventoryId(m.getMaterialInventoryId())
                     .outboundDetailId(m.getId())
                     .serialNumber(classification.getSerialNumber())
                     .name(classification.getName())
                     .basicClass(classification.getBasicClass())
                     .specification(ObjectUtil.isNotEmpty(m.getSpecification()) ? m.getSpecification() : "")
                     .quantity(mete)
                     .measureUnit(accountingUnitStr)
                     .mete(mete)
                     .accountingUnit(accountingUnitStr)
                     .remark(m.getRemark())
                     .classifyId(classification.getId())
                     .classifyName(classification.getName())
                     .model(materialInventory.getModel())
                     .width(m.getWidth())
                     .thickness(m.getThickness())
                     .theoryThickness(m.getTheoryThickness())
                     .brand(m.getBrand())
                     .heatNoAndBatchNo(m.getHeatNoAndBatchNo())
                     .color(m.getColor())
                     .accountingPrecision(materialInventory.getAccountingPrecision())
                     .build();
               }
            )
            .collect(Collectors.toList());
         this.techMesWmsManager.saveSubscribeAuxiliaryWarehouseEntry(subscribeAuxiliaryWarehouseDTOS);
      }
   }

   private void setStatisticsEndPeriod(MaterialInventory materialInventory, Statistics statistics) {
      StatisticsEndPeriod endPeriod = this.statisticsEndPeriodMapper.getOne(statistics.getId(), materialInventory.getId());
      endPeriod.setMete(materialInventory.getMete());
      endPeriod.setQuantity(materialInventory.getQuantity());
      this.statisticsEndPeriodMapper.updateById(endPeriod);
   }

   private void saveStatisticsOutbound(Outbound outbound, MoveOutboundDetail outboundDetail, MaterialInventory materialInventory, Long statisticsId) {
      StatisticsOutbound statisticsOutbound = BeanUtil.copy(outboundDetail, StatisticsOutbound.class, "createTime");
      statisticsOutbound.setReceiptType(ReceiptTypeEnum.OUTBOUND.getType());
      statisticsOutbound.setReceiptId(outbound.getId());
      statisticsOutbound.setReceiptSerialNumber(outbound.getSerialNumber());
      statisticsOutbound.setWarehouseType(materialInventory.getWarehouseType());
      statisticsOutbound.setBoolPartyA(materialInventory.getBoolPartyA());
      statisticsOutbound.setStatisticsId(statisticsId);
      statisticsOutbound.setClassifyName(materialInventory.getClassifyName());
      statisticsOutbound.setTheoryThickness(materialInventory.getTheoryThickness());
      statisticsOutbound.setDetailId(outboundDetail.getId());
      statisticsOutbound.setWorkshopId(outboundDetail.getSourceWorkshopId());
      this.statisticsOutboundMapper.insert(statisticsOutbound);
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean delete(Long listId, Long materialId) {
      Outbound outbound = this.baseMapper.selectById(listId);
      Preconditions.checkArgument(outbound != null, "当前出库单不存在");
      Preconditions.checkArgument(UserUtil.getCurrentUserId().equals(outbound.getApplicantId()), "仅创建此出库单的人才可删除出库草稿物料");
      MoveOutboundDetail moveOutboundDetail = this.moveOutboundDetailMapper.selectById(materialId);
      Preconditions.checkArgument(moveOutboundDetail != null, "当前出库详情不存在");
      Preconditions.checkArgument(moveOutboundDetail.getOutboundId().equals(listId), "当前出库物料不属于该出库单,请核对后操作.");
      if (!outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.PRODUCTION_USE.getType())
         && !outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.CONSTRUCTION_SITE_USE.getType())) {
         Preconditions.checkArgument(ReviewStatusEnum.NOT_SUBMITTED.getType().equals(outbound.getReviewStatus()), "出库单已提交审核,请核对后操作");
      } else {
         Preconditions.checkArgument(ReviewStatusEnum.UN_REVIEWED.getType().equals(outbound.getReviewStatus()), "出库单已审核,请核对后操作");
      }

      this.moveOutboundDetailMapper.deleteById(moveOutboundDetail);
      Integer freezeType = null;
      if (outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.PRODUCTION_USE.getType())) {
         freezeType = Boolean.TRUE.equals(outbound.getBoolScheduling())
            ? MaterialFreezeTypeEnum.SCHEDULING_OUTBOUND.getType() : MaterialFreezeTypeEnum.OUTBOUND.getType();
      } else if (outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.CONSTRUCTION_SITE_USE.getType())) {
         freezeType = MaterialFreezeTypeEnum.CONSTRUCTION_SITE_USE.getType();
      } else if (outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.FOR_SALE.getType())) {
         List<Long> detailIds = new ArrayList<>(Arrays.asList(materialId));
         this.delForSale(detailIds);
         freezeType = MaterialFreezeTypeEnum.FOR_SALE.getType();
      } else if (outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.TEMPORARY_LOAN.getType())) {
         freezeType = MaterialFreezeTypeEnum.BORROW.getType();
      } else if (outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.OUTSOURCING_RAW_MATERIALS.getType())) {
         freezeType = MaterialFreezeTypeEnum.OUTSOURCING.getType();
      } else if (outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.SCRAPS.getType())) {
         freezeType = MaterialFreezeTypeEnum.SCRAPS.getType();
      } else if (outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.PRODUCTION_USE.getType()) && outbound.getBoolScheduling()) {
         freezeType = MaterialFreezeTypeEnum.SCHEDULING_OUTBOUND.getType();
      } else {
         Preconditions.checkArgument(false, "未知出库类型");
      }

      this.materialFreezeService.materialUnfreeze(outbound.getId(), moveOutboundDetail.getId(), freezeType, true);
      List<MoveOutboundDetail> moveOutboundDetails = this.moveOutboundDetailMapper
         .selectList((Wrapper<MoveOutboundDetail>)Wrappers.<MoveOutboundDetail>lambdaQuery().eq(MoveOutboundDetail::getOutboundId, listId));
      if (CollectionUtil.isEmpty(moveOutboundDetails)) {
         this.baseMapper.deleteById(outbound);
      } else {
         List<String> list = new ArrayList<>();
         Set<Long> pIds = new HashSet<>();
         int basicClass = 0;

         for (MoveOutboundDetail detail : moveOutboundDetails) {
            User user = this.userService.getById(detail.getRecipientId());
            if (user != null) {
               list.add(user.getName());
            }

            if (detail.getProjectId() != null) {
               pIds.add(detail.getProjectId());
            }

            basicClass |= detail.getBasicClass();
         }

         outbound.setProjectIds(CollectionUtil.isNotEmpty(pIds) ? StrUtil.join(",", pIds) : null);
         outbound.setContainBasicClass(basicClass);
         outbound.setRecipients(StrUtil.join(",", list));
         this.baseMapper.updateById(outbound);
      }

      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean returned(Long id) {
      Outbound outbound = this.baseMapper.selectById(id);
      Preconditions.checkArgument(outbound != null, "出库单不存在,请核对后操作");
      Preconditions.checkArgument(UserUtil.getCurrentUserId().equals(outbound.getApplicantId()), "仅创建此出库单的人才可删除出库单");
      Preconditions.checkArgument(
         ReviewStatusEnum.UN_REVIEWED.getType().equals(outbound.getReviewStatus())
            || ReviewStatusEnum.NOT_SUBMITTED.getType().equals(outbound.getReviewStatus()),
         "出库单已审核,请核对后操作"
      );
      outbound.setReviewerId(UserUtil.getCurrentUserId());
      outbound.setReviewerName(UserUtil.getCurrentName());
      outbound.setReviewStatus(15);
      outbound.setReviewTime(LocalDateTime.now());
      outbound.setOutboundTime(LocalDateTime.now());
      outbound.setUserUpdateTime(LocalDateTime.now());
      this.baseMapper.deleteById(outbound);
      List<MoveOutboundDetail> moveOutboundDetails = this.moveOutboundDetailMapper
         .selectList((Wrapper<MoveOutboundDetail>)Wrappers.<MoveOutboundDetail>lambdaQuery().eq(MoveOutboundDetail::getOutboundId, id));
      List<Long> detailIds = moveOutboundDetails.stream().map(MoveOutboundDetail::getId).collect(Collectors.toList());
      this.moveOutboundDetailMapper.delete((Wrapper<MoveOutboundDetail>)Wrappers.<MoveOutboundDetail>lambdaQuery().eq(MoveOutboundDetail::getOutboundId, id));
      Integer freezeType = null;
      if (outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.PRODUCTION_USE.getType())) {
         freezeType = Boolean.TRUE.equals(outbound.getBoolScheduling())
            ? MaterialFreezeTypeEnum.SCHEDULING_OUTBOUND.getType() : MaterialFreezeTypeEnum.OUTBOUND.getType();
      } else if (outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.CONSTRUCTION_SITE_USE.getType())) {
         freezeType = MaterialFreezeTypeEnum.CONSTRUCTION_SITE_USE.getType();
      } else if (outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.FOR_SALE.getType())) {
         this.delForSale(detailIds);
         freezeType = MaterialFreezeTypeEnum.FOR_SALE.getType();
      } else if (outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.TEMPORARY_LOAN.getType())) {
         freezeType = MaterialFreezeTypeEnum.BORROW.getType();
      } else if (outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.OUTSOURCING_RAW_MATERIALS.getType())) {
         freezeType = MaterialFreezeTypeEnum.OUTSOURCING.getType();
      } else if (outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.SCRAPS.getType())) {
         freezeType = MaterialFreezeTypeEnum.SCRAPS.getType();
      } else {
         Preconditions.checkArgument(false, "未知出库类型");
      }

      this.materialFreezeService.materialUnfreeze(outbound.getId(), -1L, freezeType, true);
      return true;
   }

   @Override
   public OutboundDTO getByCurrentUser() {
      Outbound outbound = this.baseMapper
         .selectOne(
            (Wrapper<Outbound>)(((Wrappers.<Outbound>lambdaQuery()
                        .eq(Outbound::getOutboundTypeSelection, OutboundTypeEnum.PRODUCTION_USE.getType()))
                     .eq(Outbound::getReviewStatus, ReviewStatusEnum.UN_REVIEWED.getType()))
                  .eq(Outbound::getBoolScheduling, false))
               .eq(Outbound::getApplicantId, UserUtil.getCurrentUserId())
         );
      return outbound == null ? null : this.getOutboundById(outbound.getId());
   }

   @Override
   public Integer getDetailNumber() {
      Outbound outbound = this.baseMapper
         .selectOne(
            (Wrapper<Outbound>)((Wrappers.<Outbound>lambdaQuery()
                     .eq(Outbound::getReviewStatus, ReviewStatusEnum.UN_REVIEWED.getType()))
                  .eq(Outbound::getApplicantId, UserUtil.getCurrentUserId()))
               .eq(Outbound::getBoolScheduling, Boolean.FALSE)
         );
      return outbound == null
         ? 0
         : this.moveOutboundDetailMapper
            .selectList((Wrapper<MoveOutboundDetail>)Wrappers.<MoveOutboundDetail>lambdaQuery().eq(MoveOutboundDetail::getOutboundId, outbound.getId()))
            .size();
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public synchronized Boolean BatchOutbound(BatchOutboundDTOParam param) {
      SteelPlateOutboundDTOParam copy = BeanUtil.copy(param, SteelPlateOutboundDTOParam.class);

      for (BatchOutboundDetailDTOParam detailDTOParam : param.getList()) {
         BeanUtil.copy(detailDTOParam, copy);
         copy.setMaterialId(detailDTOParam.getId());
         copy.setMaterialOutboundMode(1);
         this.saveOutbound(copy);
      }

      return true;
   }

   @Override
   public List<BriefIdAndSNDTO> getSNById(List<Long> spilt) {
      List<Outbound> outbounds = this.listByIds(spilt);
      List<BriefIdAndSNDTO> list = new ArrayList<>();

      for (Outbound outbound : outbounds) {
         list.add(BriefIdAndSNDTO.builder().id(outbound.getId()).serialNumber(outbound.getSerialNumber()).build());
      }

      return list;
   }

   @Override
   public MaterialInventoryDTO getMaterials(String barcode) {
      MaterialInventory materialInventory = this.materialInventoryMapper
         .selectOne((Wrapper<MaterialInventory>)Wrappers.<MaterialInventory>lambdaQuery().eq(MaterialInventory::getBarcode, barcode));
      Preconditions.checkArgument(materialInventory != null, "当前条码对应物料不存在");
      MaterialInventoryDTO materialInventoryDTO = BeanUtil.copy(materialInventory, MaterialInventoryDTO.class);
      materialInventoryDTO.setNationalStandard(materialInventory.getStandardName());
      Workshop workshop = this.workshopService.getById(materialInventory.getWorkshopId());
      if (workshop != null) {
         materialInventoryDTO.setWorkshop(BriefIdAndNameDTO.builder().id(workshop.getId()).name(workshop.getName()).build());
      }

      Warehouse warehouse = this.warehouseService.getById(materialInventory.getWarehouseId());
      materialInventoryDTO.setWarehouse(BriefIdAndNameDTO.builder().id(warehouse.getId()).name(warehouse.getName()).build());
      if (materialInventory.getProjectId() != null) {
         materialInventoryDTO.setProject(this.contractProjectService.getSimpleById(materialInventory.getProjectId()));
      }

      if (materialInventory.getMonomerId() != null) {
         materialInventoryDTO.setMonomerName(this.monomerService.getById(materialInventory.getMonomerId()).getName());
      }

      if (materialInventory.getAreaId() != null) {
         materialInventoryDTO.setAreaName(this.planAreaService.getById(materialInventory.getAreaId()).getName());
      }

      MaterialFreeze materialFreeze = this.materialFreezeMapper
         .selectOne((Wrapper<MaterialFreeze>)Wrappers.<MaterialFreeze>lambdaQuery().eq(MaterialFreeze::getMaterialInventoryId, materialInventory.getId()));
      if (materialFreeze != null) {
         materialInventoryDTO.setFrozenMete(
            materialFreeze.getTotalMete().compareTo(materialInventory.getMete()) > 0 ? materialInventory.getMete() : materialFreeze.getTotalMete()
         );
         materialInventoryDTO.setFrozenQuantity(materialFreeze.getTotalQuantity());
         materialInventoryDTO.setBoolHasFrozen(true);
      } else {
         materialInventoryDTO.setFrozenMete(BigDecimal.ZERO);
         materialInventoryDTO.setFrozenQuantity(BigDecimal.ZERO);
         materialInventoryDTO.setBoolHasFrozen(false);
      }

      return materialInventoryDTO;
   }

   @Override
   public AppOutboundDTO getPendingQuantity() {
      Integer integer = this.baseMapper
         .selectCount((Wrapper<Outbound>)Wrappers.<Outbound>lambdaQuery().eq(Outbound::getReviewStatus, ReviewStatusEnum.UN_REVIEWED.getType()));
      return AppOutboundDTO.builder().outboundAudit(integer != null ? integer : 0).build();
   }

   @Override
   public Map<Long, BigDecimal> getProjectUseSteel(List<Long> ids) {
      Map<Long, BigDecimal> map = new HashMap<>();

      for (Long id : ids) {
         BigDecimal mete = BigDecimal.ZERO;
         List<MoveOutboundDetail> moveOutboundDetails = this.moveOutboundDetailMapper
            .selectList(
               (Wrapper<MoveOutboundDetail>)(Wrappers.<MoveOutboundDetail>lambdaQuery().eq(MoveOutboundDetail::getProjectId, id))
                  .last("and basic_class & 7 > 0")
            );
         if (CollectionUtil.isNotEmpty(moveOutboundDetails)) {
            for (MoveOutboundDetail detail : moveOutboundDetails) {
               BigDecimal returnMete = this.returnDetailMapper.getMeteById(detail.getOutboundId());
               mete = mete.add(detail.getMete().subtract(returnMete));
            }
         }

         map.put(id, mete.divide(BigDecimal.valueOf(1000L), 0, this.ROUNDING));
      }

      return map;
   }

   @Override
   public Integer getUnReviewed(Long projectId, Integer reviewStatus) {
      return this.baseMapper.getUnReviewed(projectId, reviewStatus);
   }

   @Override
   public List<OutboundAmountDTO> getAuxiliaryMaterialAmount(LocalDateTime year) {
      List<Classification> classifications = this.classificationService
         .list(
            (Wrapper<Classification>)(Wrappers.<Classification>lambdaQuery().eq(Classification::getBasicClass, BasicClassEnum.GENERAL_MATERIAL.getType()))
               .eq(Classification::getParentId, 0)
         );
      return classifications.stream().map(c -> {
         OutboundAmountDTO amountDTO = OutboundAmountDTO.builder().classifyId(c.getId()).classifyName(c.getName()).build();
         List<Long> collect = this.classificationService.getLastSubject(c.getId()).stream().map(Classification::getId).collect(Collectors.toList());
         if (CollectionUtil.isNotEmpty(collect)) {
            Map<Integer, BigDecimal> map = new HashMap<>();

            for (int i = 1; i < 13; i++) {
               String y = year.format(DateTimeFormatter.ofPattern("yyyy"));
               String s = i < 10 ? "-0" + i : "-" + i;
               LocalDate localDate = LocalDate.parse(y + s + "-01");
               BigDecimal amount = this.moveOutboundDetailMapper.getAmountByDate(collect, localDate);
               BigDecimal returnAmount = this.returnDetailMapper.getAmountByDate(collect, localDate);
               map.put(i, amount.subtract(returnAmount));
            }

            amountDTO.setAmount(map);
         }

         return amountDTO;
      }).collect(Collectors.toList());
   }

   @Override
   public BigDecimal getUseSteelAmount(Long projectId, int amountType) {
      BigDecimal outboundAmount = this.moveOutboundDetailMapper.getSteelTotalAmount(projectId, amountType);
      BigDecimal returnAmount = this.returnDetailMapper.getSteelTotalAmount(projectId, amountType);
      return outboundAmount.subtract(returnAmount);
   }

   @Override
   public Integer getWorkshopCount(Long id) {
      return this.moveOutboundDetailMapper.selectCount((Wrapper<MoveOutboundDetail>)Wrappers.<MoveOutboundDetail>lambdaQuery().eq(MoveOutboundDetail::getWorkshopId, id));
   }

   @Override
   public Map<String, BigDecimal> getUseMete(Long pid, String year) {
      int b = BasicClassEnum.STEEL_PLATE.getType() | BasicClassEnum.SECTION_STEEL.getType() | BasicClassEnum.COLOR_ROLL.getType();
      BigDecimal outboundMete = this.moveOutboundDetailMapper.getTotalMete(pid, year, b);
      Map<String, BigDecimal> map = new HashMap<>();
      map.put("outbound", outboundMete);
      if (outboundMete.compareTo(BigDecimal.ZERO) > 0) {
         BigDecimal returnMete = this.returnDetailMapper.getTotalMete(pid, year, b);
         map.put("return", returnMete);
      }

      return map;
   }

   @Override
   public Map<Integer, BigDecimal> getMeteByProjectId(Long projectId, LocalDateTime year) {
      List<SimpleEntityParam<Integer, BigDecimal>> list = this.moveOutboundDetailMapper.getMeteByProjectId(projectId, year);
      Map<Integer, BigDecimal> map = new HashMap<>();

      for (SimpleEntityParam<Integer, BigDecimal> param : list) {
         map.put(Integer.valueOf(param.getV() + ""), param.getV2());
      }

      for (int i = 1; i < 13; i++) {
         BigDecimal outMete = map.get(i);
         if (outMete != null) {
            if (outMete.compareTo(BigDecimal.ZERO) > 0) {
               BigDecimal returnMete = this.returnDetailMapper.getTotalMeteByDate(projectId, year, i);
               map.put(i, outMete.subtract(returnMete));
            }
         } else {
            map.put(i, BigDecimal.ZERO);
         }
      }

      return map;
   }

   @Override
   public PageVO getUseDetail(
      Long projectId, Integer basicClass, List<Long> classifyIds, BigDecimal thickness, String spec, boolean bool, Integer pageNumber, Integer pageSize
   ) {
      Page page = null;
      if (pageNumber != null) {
         page = PageHelper.startPage(pageNumber, pageSize);
      }

      List<MoveOutboundDetail> moveOutboundDetails = this.moveOutboundDetailMapper.getUseDetail(projectId, basicClass, classifyIds, thickness, spec);
      List<OutboundDetailDTO> list = new ArrayList<>();
      this.getDetailDTO(0, moveOutboundDetails, list, bool);
      List<Long> collect = list.stream().map(OutboundDetailDTO::getId).collect(Collectors.toList());
      if (CollectionUtil.isNotEmpty(collect)) {
         List<MoveOutboundDetail> details = this.moveOutboundDetailMapper
            .selectList(Wrappers.lambdaQuery(MoveOutboundDetail.class).in(MoveOutboundDetail::getId, collect));
         Set<Long> outBoundId = details.stream().map(MoveOutboundDetail::getOutboundId).collect(Collectors.toSet());
         Map<Long, Long> idAndOutBoundIds = details.stream()
            .collect(Collectors.toMap(MoveOutboundDetail::getId, MoveOutboundDetail::getOutboundId, (s1, s2) -> s1));
         Map<Long, Outbound> outboundIds = this.outboundService.listByIds(outBoundId).stream().collect(Collectors.toMap(Outbound::getId, s -> (Outbound)s));

         for (OutboundDetailDTO dto : list) {
            Outbound outbound = outboundIds.get(idAndOutBoundIds.get(dto.getId()));
            dto.setReviewerName(outbound.getReviewerName());
         }
      }

      return page != null ? new PageVO<>(page, list) : new PageVO<>(list);
   }

   @Override
   public Map<String, Object> getUseByYear(String year) {
      Map<String, Object> dtoMap = new HashMap<>();
      Map<Long, BriefIdAndNameDTO> listMap = new HashMap<>();

      for (BriefIdAndNameDTO l : this.moveOutboundDetailMapper.getClassIds(year, BasicClassEnum.GENERAL_MATERIAL.getType(), LocalDateTime.now())) {
         Classification classify = this.classificationService.getById(l.getId());
         Long pid = Long.parseLong(classify.getPath().split(",")[0]);
         BriefIdAndNameDTO dto = listMap.get(pid);
         if (dto == null) {
            Classification classification = this.classificationService.getById(pid);
            listMap.put(pid, BriefIdAndNameDTO.builder().id(pid).name(classification.getName()).build());
         }
      }

      dtoMap.put("auxiliary", new ArrayList<>(listMap.values()));
      listMap = new HashMap<>();
      List<ContractGasSummaryDTO> contractGasSummaryDTOS = this.gasSummaryService.listByCondition(null, Integer.valueOf(year));

      for (ContractGasSummaryDTO gasSummaryDTO : contractGasSummaryDTOS) {
         Long pid = gasSummaryDTO.getClassifyId();
         BriefIdAndNameDTO dto = listMap.get(pid);
         if (dto == null) {
            listMap.put(pid, BriefIdAndNameDTO.builder().id(pid).name(gasSummaryDTO.getClassifyName()).build());
         }
      }

      dtoMap.put("gas", new ArrayList<>(listMap.values()));
      Map<String, BigDecimal> meteMap = this.mesBuildingUtilsBiz.getMeteByYear(LocalDateTime.of(Integer.parseInt(year), 1, 1, 1, 1), null);

      for (int i = 1; i < 13; i++) {
         String date = year + "-" + (i < 10 ? "0" + i : i);
         Map<String, Object> map = new HashMap<>();
         Map<String, MaterialInventoryDTO> classMap = this.getOutboundAmount(date);
         map.put("auxiliary", new ArrayList<>(classMap.values()));
         map.put("productionMete", meteMap.get(date));
         classMap = new HashMap<>();

         for (ContractGasSummaryDTO gasSummaryDTO : contractGasSummaryDTOS) {
            String pid = gasSummaryDTO.getClassifyId() + "";
            MaterialInventoryDTO inventoryDTO = classMap.get(pid);
            if (inventoryDTO != null) {
               inventoryDTO.setAmount(inventoryDTO.getAmount().add(gasSummaryDTO.getTotalAmount()));
               inventoryDTO.setAmountExcludingVAT(inventoryDTO.getAmountExcludingVAT().add(gasSummaryDTO.getTotalAmount()));
               inventoryDTO.setMete(inventoryDTO.getMete().add(gasSummaryDTO.getUsedMete()));
            } else {
               classMap.put(
                  pid,
                  MaterialInventoryDTO.builder()
                     .classifyId(Long.parseLong(pid))
                     .accountingUnit(gasSummaryDTO.getAccountingUnit())
                     .amount(gasSummaryDTO.getTotalAmount())
                     .amountExcludingVAT(gasSummaryDTO.getTotalAmount())
                     .mete(gasSummaryDTO.getUsedMete())
                     .basicClass(gasSummaryDTO.getBasicClass())
                     .build()
               );
            }
         }

         map.put("gas", new ArrayList<>(classMap.values()));
         dtoMap.put(i + "", map);
         LocalDate now = LocalDate.now();
         if (year.equals(now.getYear() + "") && now.getMonthValue() == i) {
            i = 13;
         }
      }

      return dtoMap;
   }

   @Override
   public Map<Integer, BigDecimal> getUseAmountByYear(String year) {
      Map<Integer, BigDecimal> map = new HashMap<>();

      for (int i = 1; i < 13; i++) {
         String date = year + (i < 10 ? "0" + i : i);
         LocalDateTime now = LocalDateTime.now();
         if (now.getYear() == Integer.parseInt(year) && now.getMonthValue() == i) {
            map.put(i, BigDecimal.ZERO);
         } else {
            Map<String, MaterialInventoryDTO> classMap = this.getOutboundAmount(date);
            map.put(i, classMap.values().stream().map(MaterialInventoryDTO::getAmountExcludingVAT).reduce(BigDecimal.ZERO, BigDecimal::add));
         }
      }

      return map;
   }

   @Override
   public Map<String, BigDecimal> getMeteByYear(String year) {
      int basicClass = BasicClassEnum.STEEL_PLATE.getType() | BasicClassEnum.SECTION_STEEL.getType();
      Map<String, BigDecimal> map = new HashMap<>();

      for (int i = 1; i < 13; i++) {
         String date = year + (i < 10 ? "0" + i : i);
         BigDecimal mete = this.moveOutboundDetailMapper.getByYear(date, basicClass);
         map.put(i + "", mete.subtract(this.returnDetailMapper.getByYear(date, basicClass)));
      }

      return map;
   }

   @Override
   public List<OutboundDetailDTO> getDetailByCondition(Integer basicClass, Long projectId, LocalDateTime startDate, LocalDateTime endDate) {
      return this.moveOutboundDetailMapper.getDetailByCondition(basicClass, projectId, startDate, endDate);
   }

   @Override
   public List<OutboundDetailBasicDTO> getMeteByProject(Integer basicClass, List<Long> projectIds, LocalDateTime startDate, LocalDateTime endDate) {
      return this.moveOutboundDetailMapper.getMeteByProject(basicClass, projectIds, startDate, endDate);
   }

   @Override
   public Map<Long, BigDecimal> getNotProject(List<Long> classifyIds, MonthTimeRange monthTimeRange) {
      Map<Long, BigDecimal> map = new HashMap<>();

      for (Long id : classifyIds) {
         List<Long> list = this.classificationService.getLastSubject(id).stream().map(Classification::getId).collect(Collectors.toList());
         BigDecimal outboundAmount = this.moveOutboundDetailMapper
            .queryCurrentMonth(null, monthTimeRange, list, null)
            .stream()
            .map(MoveOutboundDetail::getAmountExcludingVat)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal returnAmount = this.returnDetailMapper
            .queryCurrentMonth(null, monthTimeRange, list)
            .stream()
            .map(ReturnDetail::getAmountExcludingVat)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         map.put(id, outboundAmount.subtract(returnAmount));
      }

      return map;
   }

   @Override
   public Boolean finishedProductsOutbound(FinishedProductsDTOParam param) {
      return null;
   }

   @NotNull
   private Map<String, MaterialInventoryDTO> getOutboundAmount(String date) {
      List<MaterialInventoryDTO> auxiliary = this.moveOutboundDetailMapper.getByWIdDetail(date, BasicClassEnum.GENERAL_MATERIAL.getType());
      Map<String, MaterialInventoryDTO> classMap = new HashMap<>();

      for (MaterialInventoryDTO dto : auxiliary) {
         BigDecimal amount = this.returnDetailMapper.getByWIdDetail(dto.getClassifyId(), date);
         if (amount != null) {
            dto.setAmountExcludingVAT(dto.getAmountExcludingVAT().subtract(amount));
         }

         String pid = this.classificationService.getById(dto.getClassifyId()).getPath().split(",")[0];
         MaterialInventoryDTO inventoryDTO = classMap.get(pid);
         if (inventoryDTO != null) {
            inventoryDTO.setAmountExcludingVAT(inventoryDTO.getAmountExcludingVAT().add(dto.getAmountExcludingVAT()));
         } else {
            classMap.put(pid, MaterialInventoryDTO.builder().classifyId(Long.parseLong(pid)).amountExcludingVAT(dto.getAmountExcludingVAT()).build());
         }
      }

      return classMap;
   }

   private Measure getMeasure(Long pid) {
      Classification classification = this.classificationService.getById(pid);
      Measure m = this.measureService.getOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, pid));
      if (m.getAccountingUnit() != null) {
         m.setAccountingUnit(m.getAccountingUnit() + "/" + classification.getName());
         return m;
      } else {
         return this.getMeasure(classification.getParentId());
      }
   }

   private Measure getMeasured(Long id) {
      Classification classification = this.classificationService.getById(id);
      Measure m = this.measureService.getOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, id));
      return m.getOutboundUnitType() != null ? m : this.getMeasure(classification.getParentId());
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean manuallyFreezeDirectOutbound(SteelPlateOutboundDTOParam param) {
      UnfreezeDTOParam unfreezeDTOParam = UnfreezeDTOParam.builder().id(param.getMaterialFreezeRecordId()).quantity(param.getQuantity()).build();
      Boolean b = this.materialFreezeService.setUnfreeze(unfreezeDTOParam);
      return this.saveOutbound(param);
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean manuallyFreezeSaveForSaleOutbound(SteelPlateOutboundDTOParam param) {
      UnfreezeDTOParam unfreezeDTOParam = UnfreezeDTOParam.builder().id(param.getMaterialFreezeRecordId()).quantity(param.getQuantity()).build();
      Boolean b = this.materialFreezeService.setUnfreeze(unfreezeDTOParam);
      return this.saveForSaleOutbound(param);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean manuallyFreezeSubmitForSaleOutbound(SteelPlateOutboundDTOParam param) {
      UnfreezeDTOParam unfreezeDTOParam = UnfreezeDTOParam.builder().id(param.getMaterialFreezeRecordId()).quantity(param.getQuantity()).build();
      Boolean b = this.materialFreezeService.setUnfreeze(unfreezeDTOParam);
      return this.submitForSaleOutbound(param);
   }

   private void setMaterialFreeze(MaterialInventory materialInventory, MoveOutboundDetail convertDetail, Outbound outbound) {
      MaterialFreeze materialFreeze = this.materialFreezeService
         .getOne((Wrapper<MaterialFreeze>)Wrappers.<MaterialFreeze>lambdaQuery().eq(MaterialFreeze::getMaterialInventoryId, materialInventory.getId()));
      if (materialFreeze == null) {
         materialFreeze = BeanUtil.copy(materialInventory, MaterialFreeze.class, "createTime");
         materialFreeze.setTotalQuantity(convertDetail.getQuantity());
         materialFreeze.setTotalMete(convertDetail.getMete());
         materialFreeze.setTotalFreezeTypes(MaterialFreezeTypeEnum.OUTBOUND.getType() + "");
         materialFreeze.setMaterialInventoryId(materialInventory.getId());
         this.materialFreezeService.save(materialFreeze);
      } else {
         if (convertDetail.getQuantity() != null) {
            materialFreeze.setTotalQuantity(
               convertDetail.getQuantity() != null
                  ? materialFreeze.getTotalQuantity().add(convertDetail.getQuantity())
                  : materialFreeze.getTotalQuantity().add(convertDetail.getQuantity())
            );
         }

         List<Integer> t = Arrays.stream(materialFreeze.getTotalFreezeTypes().split(",")).map(Integer::parseInt).collect(Collectors.toList());
         if (!t.contains(MaterialFreezeTypeEnum.CONVERT.getType())) {
            t.add(MaterialFreezeTypeEnum.CONVERT.getType());
            materialFreeze.setTotalFreezeTypes(StrUtil.join(",", t));
         }

         materialFreeze.setTotalMete(materialFreeze.getTotalMete().add(convertDetail.getMete()));
         this.materialFreezeService.updateById(materialFreeze);
      }

      MaterialFreezeRecord materialFreezeRecord = MaterialFreezeRecord.builder()
         .materialFreezeId(materialFreeze.getId())
         .freezeDetailId(convertDetail.getId())
         .freezeType(MaterialFreezeTypeEnum.CONVERT.getType())
         .freezeSourceId(convertDetail.getOutboundId())
         .freezeSourceSn(outbound.getSerialNumber())
         .operatorId(UserUtil.getCurrentUserId())
         .operatorName(UserUtil.getCurrentName())
         .mete(convertDetail.getMete())
         .quantity(convertDetail.getQuantity())
         .boolBatten(false)
         .projectId(convertDetail.getProjectId())
         .frozenTime(LocalDateTime.now())
         .outboundUnitType(1)
         .build();
      this.materialFreezeRecordMapper.insert(materialFreezeRecord);
      if (!materialInventory.getBoolHasFrozen()) {
         this.materialInventoryMapper.updateBoolHasFrozen(materialInventory.getId(), true);
      }
   }

   public MaterialReturnable saveReturnable(Outbound outbound, MoveOutboundDetail outboundDetail, MaterialInventory materialInventory) {
      Measure measure = this.measureMapper
         .selectOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, materialInventory.getClassifyId()));
      if (measure.getOutboundUnitType() == null) {
         measure = this.getMeasured(materialInventory.getClassifyId());
      }

      BigDecimal UnitsPrecision = UnitsPrecisionEnum.getByName(measure.getAccountingUnit());
      MaterialReturnable materialReturnable = MaterialReturnable.builder()
         .sourceWorkshopId(materialInventory.getWorkshopId())
         .classifyId(materialInventory.getClassifyId())
         .classifyName(materialInventory.getClassifyName())
         .boolPartyA(materialInventory.getBoolPartyA())
         .outboundUnitType(measure.getOutboundUnitType())
         .basicClass(materialInventory.getBasicClass())
         .specification(materialInventory.getSpecification())
         .mete(outboundDetail.getMete())
         .accountingUnit(materialInventory.getAccountingUnit())
         .returnableMete(outboundDetail.getMete())
         .quantity(outboundDetail.getQuantity())
         .unitNet(materialInventory.getUnitNet())
         .length(outboundDetail.getLength())
         .width(outboundDetail.getWidth())
         .thickness(materialInventory.getThickness())
         .theoryThickness(materialInventory.getTheoryThickness())
         .brand(materialInventory.getBrand())
         .heatNoAndBatchNo(materialInventory.getHeatNoAndBatchNo())
         .color(materialInventory.getColor())
         .projectId(outboundDetail.getProjectId())
         .outboundId(outbound.getId())
         .outboundSn(outbound.getSerialNumber())
         .outboundDetailId(outboundDetail.getId())
         .workshopId(materialInventory.getWorkshopId())
         .warehouseId(materialInventory.getWarehouseId())
         .outboundTime(outboundDetail.getOutboundTime())
         .weightedAverageSpec(materialInventory.getWeightedAverageSpec())
         .taxRate(outboundDetail.getTaxRate())
         .invoiceType(outboundDetail.getInvoiceType())
         .boolReviewPending(false)
         .boolReturn(true)
         .standardId(materialInventory.getStandardId())
         .standardName(materialInventory.getStandardName())
         .sectionSteelWeight(materialInventory.getSectionSteelWeight())
         .oneTheoryWeight(materialInventory.getOneTheoryWeight())
         .materialSn(materialInventory.getSerialNumber())
         .monomerId(outboundDetail.getMonomerId())
         .areaId(outboundDetail.getAreaId())
         .workshopId(outboundDetail.getWorkshopId())
         .areaBatchId(outboundDetail.getAreaBatchId())
         .build();
      if (outboundDetail.getRecipientId() != null) {
         materialReturnable.setRecipientId(outboundDetail.getRecipientId());
         materialReturnable.setRecipientName(this.userService.getById(outboundDetail.getRecipientId()).getName());
      }

      if (MaterialIsWholeEnum.WHOLE.getType().equals(materialInventory.getMaterialIsWhole())) {
         if (outboundDetail.getOutboundType() == 1) {
            materialReturnable.setMaterialIsWhole(MaterialIsWholeEnum.WHOLE.getType());
         } else {
            materialReturnable.setMaterialIsWhole(MaterialIsWholeEnum.ODDMENT.getType());
         }
      } else {
         materialReturnable.setMaterialIsWhole(MaterialIsWholeEnum.ODDMENT.getType());
      }

      if (BasicClassEnum.SECTION_STEEL.getType().equals(materialInventory.getBasicClass())) {
         if (MaterialOutboundModeEnum.HALF.getType().equals(outboundDetail.getOutboundType())) {
            materialReturnable.setSingleReturnableLength(outboundDetail.getLength());
         } else {
            materialReturnable.setSingleReturnableLength(materialInventory.getLength());
         }
      }

      if (BasicClassEnum.COLOR_ROLL.getType().equals(materialInventory.getBasicClass())) {
         materialReturnable.setSingleMete(outboundDetail.getMete());
         materialReturnable.setSingleReturnableMete(outboundDetail.getMete());
      } else if (MeasureTypeEnum.MEASURE.getType().equals(measure.getOutboundUnitType())) {
         if (BasicClassEnum.SECTION_STEEL.getType().equals(materialInventory.getBasicClass())
            || BasicClassEnum.STEEL_PLATE.getType().equals(materialInventory.getBasicClass())) {
            BigDecimal singleMete = outboundDetail.getMete().divide(outboundDetail.getQuantity(), 8, RoundingMode.DOWN);
            BigDecimal multiply = singleMete;
            materialReturnable.setSingleMete(multiply);
            materialReturnable.setSingleReturnableMete(multiply);
         }
      } else {
         materialReturnable.setSingleMete(outboundDetail.getMete());
         materialReturnable.setSingleReturnableMete(outboundDetail.getMete());
      }

      this.materialReturnableMapper.insert(materialReturnable);
      return materialReturnable;
   }

   @Override
   public PageVO<OutboundListDTO> pageInfoV2(QueryOutboundDTOParam param, Integer pageNum, Integer size, List<String> sort) {
      String s = StringUtils.analyzeSortConditions(sort);
      PageInfo<Outbound> pageInfo = PageHelper.<Outbound>startPage(pageNum, size, s).doSelectPageInfo(() -> this.listInfoV2(param));
      List<OutboundListDTO> collect = pageInfo.getList()
         .stream()
         .map(
            outbound -> {
               OutboundListDTO listDTO = BeanUtil.copy(outbound, OutboundListDTO.class);
               listDTO.setOutboundEarliestTime(outbound.getOutboundStartTime());
               listDTO.setOutboundLatestTime(outbound.getOutboundEndTime());
               List<MoveOutboundDetail> moveOutboundDetails = this.moveOutboundDetailMapper
                  .selectList((Wrapper<MoveOutboundDetail>)Wrappers.<MoveOutboundDetail>lambdaQuery().eq(MoveOutboundDetail::getOutboundId, outbound.getId()));
               List<ProjectInfoDTO> list = new ArrayList<>();

               for (Long id : moveOutboundDetails.stream().map(MoveOutboundDetail::getProjectId).collect(Collectors.toSet())) {
                  if (id != null) {
                     ProjectInfo projectInfo = this.contractProjectService.getSimpleById(id);
                     list.add(BeanUtil.copy(projectInfo, ProjectInfoDTO.class));
                  }
               }

               listDTO.setProjects(list);
               listDTO.setBasicClass(outbound.getContainBasicClass());
               listDTO.setApplicationSN(outbound.getApplicationSn());
               return listDTO;
            }
         )
         .collect(Collectors.toList());
      return new PageVO<>(pageInfo, collect);
   }

   @Override
   public List<Outbound> listInfoV2(QueryOutboundDTOParam param) {
      return this.baseMapper.getOutboundListV2(param);
   }

   @Override
   public List<OutboundDTO> getByCurrentUserV2(Boolean boolPartyA, List<Integer> outboundTypes) {
      List<OutboundDTO> outboundDTOS = new ArrayList<>();
      if (CollectionUtil.isNotEmpty(outboundTypes)) {
         for (Integer outboundType : outboundTypes) {
            Outbound outbound = this.baseMapper
               .selectOne(
                  (Wrapper<Outbound>)((((Wrappers.<Outbound>lambdaQuery()
                                 .eq(Outbound::getApplicantId, UserUtil.getCurrentUserId()))
                              .eq(Outbound::getBoolPartyA, boolPartyA))
                           .eq(Outbound::getBoolScheduling, Boolean.FALSE))
                        .eq(Outbound::getOutboundTypeSelection, outboundType))
                     .and(
                        o -> {
                           LambdaQueryWrapper var10000 = ((o.eq(
                                    Outbound::getReviewStatus, ReviewStatusEnum.UN_REVIEWED.getType()
                                 ))
                                 .or())
                              .eq(Outbound::getReviewStatus, ReviewStatusEnum.NOT_SUBMITTED.getType());
                        }
                     )
               );
            if (!ObjectUtil.isEmpty(outbound)) {
               OutboundDTO outboundById = this.getOutboundByIdV2(outbound.getId());
               List<OutboundDetailDTO> list = outboundById.getList();
               List<Long> materialInventoryIds = list.stream().map(OutboundDetailDTO::getMaterialInventoryId).collect(Collectors.toList());
               List<MaterialInventory> materialInventories = this.materialInventoryService
                  .listInfoV2(QueryByMaterialDTOParam.builder().ids(materialInventoryIds).build());
               List<MaterialInventoryDTO> materialInventoryDTO1 = this.materialInventoryService.getMaterialInventoryDTO1(materialInventories);

               for (OutboundDetailDTO outboundDetailDTO : list) {
                  MaterialInventoryDTO materialInventoryDTO = materialInventoryDTO1.stream()
                     .filter(m -> m.getId().equals(outboundDetailDTO.getMaterialInventoryId()))
                     .findAny()
                     .orElse(null);
                  outboundDetailDTO.setMaterialInventoryDTO(materialInventoryDTO);
               }

               outboundById.setList(list);
               outboundDTOS.add(outboundById);
            }
         }
      } else {
         Outbound outbound = this.baseMapper
            .selectOne(
               (Wrapper<Outbound>)(((Wrappers.<Outbound>lambdaQuery()
                           .eq(Outbound::getApplicantId, UserUtil.getCurrentUserId()))
                        .eq(Outbound::getBoolPartyA, boolPartyA))
                     .eq(Outbound::getBoolScheduling, Boolean.FALSE))
                  .and(
                     o -> {
                        LambdaQueryWrapper var10000 = ((o.eq(
                                 Outbound::getReviewStatus, ReviewStatusEnum.UN_REVIEWED.getType()
                              ))
                              .or())
                           .eq(Outbound::getReviewStatus, ReviewStatusEnum.NOT_SUBMITTED.getType());
                     }
                  )
            );
         if (ObjectUtil.isEmpty(outbound)) {
            return outboundDTOS;
         }

         OutboundDTO outboundById = this.getOutboundByIdV2(outbound.getId());
         List<OutboundDetailDTO> list = outboundById.getList();
         List<Long> materialInventoryIds = list.stream().map(OutboundDetailDTO::getMaterialInventoryId).collect(Collectors.toList());
         List<MaterialInventory> materialInventories = this.materialInventoryService
            .listInfoV2(QueryByMaterialDTOParam.builder().ids(materialInventoryIds).build());
         List<MaterialInventoryDTO> materialInventoryDTO1 = this.materialInventoryService.getMaterialInventoryDTO1(materialInventories);

         for (OutboundDetailDTO outboundDetailDTO : list) {
            MaterialInventoryDTO materialInventoryDTO = materialInventoryDTO1.stream()
               .filter(m -> m.getId().equals(outboundDetailDTO.getMaterialInventoryId()))
               .findAny()
               .orElse(null);
            outboundDetailDTO.setMaterialInventoryDTO(materialInventoryDTO);
         }

         outboundById.setList(list);
         outboundDTOS.add(outboundById);
      }

      return outboundDTOS;
   }

   private void getDetailSellDTO(
      int basicClass, List<MoveOutboundDetail> moveOutboundDetails, List<OutboundDetailDTO> list, boolean bool, List<WmsForSaleDetail> wmsForSaleDetails
   ) {
      List<String> forSaleSerialNumbers = wmsForSaleDetails.stream().map(WmsForSaleDetail::getForSaleSerialNumber).distinct().collect(Collectors.toList());
      List<WmsForSale> wmsForSaleList = this.wmsForSaleService
         .list((Wrapper<WmsForSale>)new LambdaQueryWrapper<WmsForSale>().in(WmsForSale::getSerialNumber, forSaleSerialNumbers));
      List<Long> branchCompanyIds = wmsForSaleList.stream().map(WmsForSale::getBranchCompanyId).distinct().collect(Collectors.toList());
      List<BranchCompany> branchCompanyList = this.branchCompanyService
         .list((Wrapper<BranchCompany>)new LambdaQueryWrapper<BranchCompany>().in(BranchCompany::getId, branchCompanyIds));

      for (MoveOutboundDetail detail : moveOutboundDetails) {
         OutboundDetailDTO outboundDetailDTO = this.transitionDetailDTO(detail, basicClass, bool);
         WmsForSaleDetail wmsForSaleDetail = wmsForSaleDetails.stream().filter(w -> w.getOutboundDetailId().equals(detail.getId())).findAny().orElse(null);
         if (ObjectUtil.isNotEmpty(wmsForSaleDetail)) {
            OutboundDetailSellDTO outboundDetailSellDTO = cn.hutool.core.bean.BeanUtil.toBean(wmsForSaleDetail, OutboundDetailSellDTO.class);
            WmsForSale wmsForSale = wmsForSaleList.stream()
               .filter(w -> w.getSerialNumber().equals(wmsForSaleDetail.getForSaleSerialNumber()))
               .findAny()
               .orElse(null);
            if (ObjectUtil.isNotEmpty(wmsForSale)) {
               outboundDetailSellDTO.setInvoiceType(wmsForSale.getInvoiceType());
               outboundDetailSellDTO.setTaxRate(wmsForSale.getTaxRate());
               BranchCompany branchCompany = branchCompanyList.stream().filter(b -> b.getId().equals(wmsForSale.getBranchCompanyId())).findAny().orElse(null);
               if (ObjectUtil.isNotEmpty(branchCompany)) {
                  outboundDetailSellDTO.setBranchCompany(BriefIdAndNameDTO.builder().id(branchCompany.getId()).name(branchCompany.getName()).build());
               }

               outboundDetailSellDTO.setPurchaser(wmsForSale.getPurchaser());
            }

            outboundDetailDTO.setOutboundDetailSellDTO(outboundDetailSellDTO);
         }

         list.add(outboundDetailDTO);
      }
   }

   private OutboundDetailDTO transitionDetailDTO(MoveOutboundDetail detail, Integer basicClass, boolean bool) {
      basicClass = basicClass | detail.getBasicClass();
      OutboundDetailDTO detailDTO = BeanUtil.copy(detail, OutboundDetailDTO.class);
      detailDTO.setNationalStandard(detail.getStandardName());
      detailDTO.setMaterialOutboundMode(detail.getHalfSize() != null ? 2 : 1);
      if (bool) {
         ReturnDetail byOD = this.returnDetailMapper.getByODId(detailDTO.getId());
         if (byOD != null) {
            if (detailDTO.getQuantity() != null) {
               detailDTO.setQuantity(detailDTO.getQuantity().subtract(byOD.getQuantity()));
            }

            detailDTO.setMete(detailDTO.getMete().subtract(byOD.getMete()));
            if (detailDTO.getAmount() != null) {
               detailDTO.setAmount(detailDTO.getAmount().subtract(byOD.getAmount()));
               detailDTO.setAmountExcludingVat(detailDTO.getAmountExcludingVat().subtract(byOD.getAmountExcludingVat()));
            }
         }
      }

      if (detail.getRecipientId() != null) {
         Department dept = this.departmentService.selectByUserId(detail.getRecipientId());
         detailDTO.setRecipient(
            BriefDeptAndNameDTO.builder().name(this.userService.getById(detail.getRecipientId()).getName()).deptName(dept.getName()).build()
         );
      }

      if (detail.getWorkshopId() != null) {
         MesBuildingWorkshop byId = this.mesBuildingWorkshopService.getById(detail.getWorkshopId());
         if (byId != null) {
            detailDTO.setMesWorkshop(BriefIdAndNameDTO.builder().id(byId.getId()).name(byId.getName()).build());
         }
      }

      detailDTO.setSourceWorkshopId(detail.getSourceWorkshopId());
      Workshop byId = this.workshopService.getById(detail.getSourceWorkshopId());
      detailDTO.setWorkshop(BriefIdAndNameDTO.builder().id(byId.getId()).name(byId.getName()).build());
      if (detail.getProjectId() != null) {
         detailDTO.setProject(this.contractProjectService.getSimpleById(detail.getProjectId()));
      }

      if (detail.getSourceProjectId() != null) {
         detailDTO.setSourceProject(this.contractProjectService.getSimpleById(detail.getSourceProjectId()));
      }

      if (detail.getMonomerId() != null) {
         detailDTO.setMonomerName(this.monomerService.getById(detail.getMonomerId()).getName());
      }

      if (detail.getAreaId() != null) {
         detailDTO.setAreaName(this.planAreaService.getById(detail.getAreaId()).getName());
      }

      if (detail.getHeatNoAndBatchNo() != null) {
         detailDTO.setHeatNoAndBatchNo(detail.getHeatNoAndBatchNo());
      }

      Measure measure = this.getMeasure(detailDTO.getClassifyId());
      String[] split = measure.getAccountingUnit().split("/");
      detailDTO.setAccountingUnit(split[0]);
      detailDTO.setAccountingPrecision(measure.getAccountingPrecision());
      if (BasicClassEnum.COLOR_ROLL.getType().equals(detail.getBasicClass()) && detail.getLength() != null) {
         detailDTO.setMeasureUnit("张");
         detailDTO.setMeasurePrecision(0);
      } else {
         detailDTO.setMeasureUnit(measure.getMeasureUnit());
         detailDTO.setMeasurePrecision(measure.getMeasurePrecision());
      }

      detailDTO.setClassifyName(split[1]);
      Warehouse warehouse = this.warehouseMapper.selectById(detail.getWarehouseId());
      detailDTO.setWarehouse(BriefIdAndNameDTO.builder().id(warehouse.getId()).name(warehouse.getName()).build());
      return detailDTO;
   }

   @Override
   public Integer getDetailNumberV2(Boolean boolPartyA) {
      List<Integer> reviewStatus = new ArrayList<>();
      reviewStatus.add(ReviewStatusEnum.UN_REVIEWED.getType());
      reviewStatus.add(ReviewStatusEnum.NOT_SUBMITTED.getType());
      List<Outbound> outbound = this.baseMapper
         .selectList(
            ((((Wrappers.<Outbound>lambdaQuery()
                           .in(Outbound::getReviewStatus, reviewStatus))
                        .eq(Outbound::getApplicantId, UserUtil.getCurrentUserId()))
                     .eq(Outbound::getBoolScheduling, Boolean.FALSE))
                  .isNull(Outbound::getConvertId))
               .eq(boolPartyA != null, Outbound::getBoolPartyA, boolPartyA)
         );
      if (CollectionUtil.isEmpty(outbound)) {
         return 0;
      }

      List<Long> outId = new ArrayList<>();

      for (Outbound out : outbound) {
         outId.add(out.getId());
      }

      return this.moveOutboundDetailMapper
         .selectList(
            (Wrappers.<MoveOutboundDetail>lambdaQuery().in(MoveOutboundDetail::getOutboundId, outId))
               .eq(boolPartyA != null, MoveOutboundDetail::getBoolPartyA, boolPartyA)
         )
         .size();
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean saveOutsourcingOutbound(SteelPlateOutboundDTOParam param) {
      Preconditions.checkArgument(param.getQuantity() != null && param.getQuantity().signum() > 0, "出库数量必须大于0");
      MaterialInventory materialInventory = this.materialInventoryMapper.selectById(param.getMaterialId());
      Preconditions.checkArgument(materialInventory != null, "仓库中不存在该物料");
      Measure measure = this.measureMapper
         .selectOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, materialInventory.getClassifyId()));
      SubjectMeasureDTO subjectMeasureDTO = this.measureService.measureListById(materialInventory.getClassifyId());
      WasteConfig scrapDefinitionConf = this.basicConfigService.getSteelScrapDefinitionConf();
      BasicOutbound outboundBasicConf = this.basicConfigService.getOutboundBasicConf();
      Outbound outbound = this.baseMapper
         .selectOne(
            ((((Wrappers.<Outbound>lambdaQuery()
                           .eq(Outbound::getApplicantId, UserUtil.getCurrentUserId()))
                        .eq(Outbound::getReviewStatus, ReviewStatusEnum.NOT_SUBMITTED.getType()))
                     .eq(param.getConvertId() != null, Outbound::getConvertId, param.getConvertId()))
                  .eq(param.getOutboundTypeSelection() != null, Outbound::getOutboundTypeSelection, param.getOutboundTypeSelection()))
               .eq(param.getBoolPartyA() != null, Outbound::getBoolPartyA, param.getBoolPartyA())
         );
      if (outbound != null) {
         outbound.setUserUpdateTime(LocalDateTime.now());
         param.setId(outbound.getId());
      } else {
         outbound = Outbound.builder()
            .applicantId(UserUtil.getCurrentUserId())
            .applicantName(UserUtil.getCurrentName())
            .userUpdateTime(LocalDateTime.now())
            .reviewStatus(ReviewStatusEnum.NOT_SUBMITTED.getType())
            .outboundStartTime(LocalDateTime.now())
            .outboundEndTime(LocalDateTime.now())
            .convertId(param.getConvertId())
            .boolPartyA(param.getBoolPartyA())
            .outboundTypeSelection(OutboundTypeEnum.OUTSOURCING_RAW_MATERIALS.getType())
            .build();
         String serviceNumber = this.numberConfigService.getNumber(NumberTypeEnum.OUTSOURCING_RAW_MATERIALS, this.baseMapper.getCount(LocalDateTime.now()));
         outbound.setApplicationSn(serviceNumber);
         this.baseMapper.insert(outbound);
         param.setId(outbound.getId());
      }

      MoveOutboundDetail moveOutboundDetail = MoveOutboundDetail.builder()
         .warehouseId(materialInventory.getWarehouseId())
         .materialIsWhole(materialInventory.getMaterialIsWhole())
         .sourceWorkshopId(materialInventory.getWorkshopId())
         .materialInventoryId(materialInventory.getId())
         .outboundId(outbound.getId())
         .basicClass(materialInventory.getBasicClass())
         .classifyId(materialInventory.getClassifyId())
         .specification(materialInventory.getSpecification())
         .sourceProjectId(materialInventory.getProjectId())
         .sourceMonomerId(materialInventory.getMonomerId())
         .sourceAreaId(materialInventory.getAreaId())
         .thickness(materialInventory.getThickness())
         .theoryThickness(materialInventory.getTheoryThickness())
         .heatNoAndBatchNo(materialInventory.getHeatNoAndBatchNo())
         .brand(materialInventory.getBrand())
         .outboundTime(param.getOutboundTime() != null ? param.getOutboundTime() : LocalDateTime.now())
         .color(materialInventory.getColor())
         .recipientId(param.getRecipientId())
         .outboundMode(param.getMaterialOutboundMode())
         .remark(param.getRemark())
         .boolPartyA(materialInventory.getBoolPartyA())
         .taxRate(materialInventory.getTaxRate())
         .invoiceType(materialInventory.getInvoiceType())
         .standardId(materialInventory.getStandardId())
         .standardName(materialInventory.getStandardName())
         .materialSn(materialInventory.getSerialNumber())
         .outboundAddress(param.getOutboundAddress())
         .workshopId(param.getWorkshopId())
         .outboundTypeSelection(OutboundTypeEnum.OUTSOURCING_RAW_MATERIALS.getType())
         .purchaseId(param.getPurchaseId())
         .build();
      MaterialFreeze materialFreeze = this.materialFreezeService
         .getOne((Wrapper<MaterialFreeze>)Wrappers.<MaterialFreeze>lambdaQuery().eq(MaterialFreeze::getMaterialInventoryId, materialInventory.getId()));
      MaterialFreezeRecord freezeRecord = null;
      Set<Integer> freezeTypes = null;
      BigDecimal freezeTotalMete;
      BigDecimal freezeTotalQuantity;
      if (materialFreeze != null) {
         freezeTotalMete = materialFreeze.getTotalMete();
         freezeTotalQuantity = materialFreeze.getTotalQuantity();
         freezeTypes = Arrays.stream(materialFreeze.getTotalFreezeTypes().split(",")).map(Integer::parseInt).collect(Collectors.toSet());
         if (freezeTypes.contains(MaterialFreezeTypeEnum.REQUISITIONS.getType())) {
            freezeRecord = this.materialFreezeRecordMapper
               .selectOne(
                  (Wrapper<MaterialFreezeRecord>)((Wrappers.<MaterialFreezeRecord>lambdaQuery()
                           .eq(MaterialFreezeRecord::getMaterialFreezeId, materialFreeze.getId()))
                        .eq(MaterialFreezeRecord::getFreezeType, MaterialFreezeTypeEnum.REQUISITIONS.getType()))
                     .eq(MaterialFreezeRecord::getProjectId, param.getProjectId())
               );
            if (freezeRecord != null) {
               freezeTotalMete = freezeTotalMete.subtract(freezeRecord.getMete());
               if (materialFreeze.getTotalQuantity() != null) {
                  freezeTotalQuantity = freezeTotalQuantity.subtract(freezeRecord.getQuantity());
               }
            }
         }
      } else {
         freezeTotalMete = BigDecimal.ZERO;
         freezeTotalQuantity = BigDecimal.ZERO;
      }

      String accountingUnit = subjectMeasureDTO.getAccountingUnit();
      Integer accountingPrecision = subjectMeasureDTO.getAccountingPrecision();
      BigDecimal unitsPrecision = UnitsPrecisionEnum.getByName(subjectMeasureDTO.getAccountingUnit());
      BigDecimal outMete = null;
      BigDecimal outQuantity = null;
      if (param.getProjectId() != null) {
         if (materialInventory.getBoolPartyA()) {
            Preconditions.checkArgument(materialInventory.getProjectId().equals(param.getProjectId()), "出库失败,甲供物料不能出库到其他项目.");
         }

         if (!outboundBasicConf.getBoolCanOutToOtherProject() && materialInventory.getProjectId() != null) {
            Preconditions.checkArgument(materialInventory.getProjectId().equals(param.getProjectId()), "当前出库项目与物料项目不一致,请核对.");
         }

         if (materialInventory.getProjectId() != null) {
            moveOutboundDetail.setOutboundRelationType(
               materialInventory.getProjectId().equals(param.getProjectId())
                  ? OutboundRelationTypeEnum.ROUTINE.getType()
                  : OutboundRelationTypeEnum.TRANSFER.getType()
            );
         }

         moveOutboundDetail.setProjectId(param.getProjectId());
         moveOutboundDetail.setMonomerId(param.getMonomerId());
         moveOutboundDetail.setAreaId(param.getAreaId());
      }

      if (param.getProjectId() == null && materialInventory.getProjectId() != null) {
         moveOutboundDetail.setProjectId(materialInventory.getProjectId());
         moveOutboundDetail.setMonomerId(materialInventory.getMonomerId());
         moveOutboundDetail.setAreaId(materialInventory.getAreaId());
      }

      if (moveOutboundDetail.getProjectId() != null) {
         ContractProject project = this.contractProjectService.getById(moveOutboundDetail.getProjectId());
         Preconditions.checkArgument(
            moveOutboundDetail.getProjectId() != null && SettlementStatusEnum.UN_SETTLED.getType().equals(project.getSettlementStatus()), "出库失败,当前项目已结算"
         );
      }

      if (MaterialOutboundModeEnum.HALF.getType().equals(param.getMaterialOutboundMode())) {
         Preconditions.checkArgument(
            BasicClassEnum.checkIsSteel(materialInventory.getBasicClass()) && !BasicClassEnum.COLOR_ROLL.getType().equals(materialInventory.getBasicClass()),
            "该材料不能进行整料半出"
         );
         Preconditions.checkArgument(param.getHalfSize() != null && param.getHalfSize().compareTo(BigDecimal.ONE) >= 0, "半出截取长度不能小于1mm");
         Map<Integer, BigDecimal> unitConversion = this.unitConversion(
            BigDecimal.ZERO, subjectMeasureDTO.getMeasureUnit(), subjectMeasureDTO.getMeasurePrecision()
         );
         BigDecimal inventoryQuantity = materialInventory.getQuantity();
         BigDecimal sendQuantity = param.getQuantity();
         inventoryQuantity = inventoryQuantity.subtract(freezeTotalQuantity);
         BigDecimal halfUpMete = inventoryQuantity.divide(unitConversion.get(2), subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP)
            .setScale(subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP);
         BigDecimal halfSendQuantity = sendQuantity.divide(unitConversion.get(2), subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP)
            .setScale(subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP);
         Preconditions.checkArgument(halfSendQuantity.compareTo(halfUpMete) <= 0, "当前库存量不足,请重新操作");
         if (halfSendQuantity.compareTo(halfUpMete) > -1) {
            sendQuantity = inventoryQuantity;
         }

         moveOutboundDetail.setQuantity(sendQuantity);
         moveOutboundDetail.setHalfMode(1);
         if (BasicClassEnum.SECTION_STEEL.getType().equals(materialInventory.getBasicClass())) {
            Preconditions.checkArgument(!HalfModeEnum.WIDTH.getType().equals(param.getHalfMode()), "型材半出只能按长度截取");
            Preconditions.checkArgument(param.getHalfSize().compareTo(materialInventory.getLength()) < 0, "截取长度大于或等于型材定尺长度,请选择整料整出");
            moveOutboundDetail.setMete(
               CommonUtil.getStockOutboundMete(sendQuantity, materialInventory.getQuantity().subtract(freezeTotalQuantity), materialInventory.getMete().subtract(freezeTotalMete))
                  .multiply(param.getHalfSize()).divide(materialInventory.getLength(), 8, RoundingMode.DOWN)
            );
            moveOutboundDetail.setLength(param.getHalfSize());
         } else {
            moveOutboundDetail.setHalfMode(param.getHalfMode());
            if (HalfModeEnum.LENGTH.getType().equals(param.getHalfMode())) {
               Preconditions.checkArgument(param.getHalfSize().compareTo(materialInventory.getLength()) < 0, "截取长度大于或等于钢板长度,请选择整料整出");
               moveOutboundDetail.setLength(param.getHalfSize());
               moveOutboundDetail.setWidth(materialInventory.getWidth());
               moveOutboundDetail.setMete(
               CommonUtil.getStockOutboundMete(sendQuantity, materialInventory.getQuantity().subtract(freezeTotalQuantity), materialInventory.getMete().subtract(freezeTotalMete))
                  .multiply(param.getHalfSize()).divide(materialInventory.getLength(), 8, RoundingMode.DOWN)
            );
            } else {
               Preconditions.checkArgument(param.getHalfSize().compareTo(materialInventory.getWidth()) < 0, "截取宽度大于或等于钢板宽度,请选择整料整出");
               moveOutboundDetail.setLength(materialInventory.getLength());
               moveOutboundDetail.setWidth(param.getHalfSize());
               moveOutboundDetail.setMete(
               CommonUtil.getStockOutboundMete(sendQuantity, materialInventory.getQuantity().subtract(freezeTotalQuantity), materialInventory.getMete().subtract(freezeTotalMete))
                  .multiply(param.getHalfSize()).divide(materialInventory.getWidth(), 8, RoundingMode.DOWN)
            );
            }
         }

         Preconditions.checkArgument(moveOutboundDetail.getMete().compareTo(BigDecimal.valueOf(1000L)) > 0, "出库失败,出库量必须大于1kg");
         moveOutboundDetail.setOutboundType(MaterialOutboundModeEnum.HALF.getType());
         moveOutboundDetail.setHalfSize(param.getHalfSize());
         this.checkHalfOutputDimensions(moveOutboundDetail);
         outMete = CommonUtil.getStockOutboundMete(sendQuantity, materialInventory.getQuantity().subtract(freezeTotalQuantity), materialInventory.getMete().subtract(freezeTotalMete));
      } else {
         moveOutboundDetail.setOutboundType(MaterialOutboundModeEnum.WHOLE.getType());
         BigDecimal precision = UnitsPrecisionEnum.getByName(measure.getAccountingUnit());
         MeteAndQuantity meteAndQuantitySend = new MeteAndQuantity();
         meteAndQuantitySend.setSendQuantity(param.getQuantity());
         MeteAndQuantity meteAndQuantity = this.checkInventory(
            materialInventory.getBasicClass(),
            materialInventory.getClassifyId(),
            meteAndQuantitySend,
            materialInventory.getQuantity(),
            materialInventory.getMete(),
            freezeTotalQuantity,
            freezeTotalMete,
            subjectMeasureDTO,
            measure
         );
         BigDecimal sendQuantity = meteAndQuantity.getSendQuantity();
         if (BasicClassEnum.checkNotSteel(materialInventory.getBasicClass())) {
            if (measure.getOutboundUnitType() == null) {
               measure = this.getMeasured(materialInventory.getClassifyId());
            }

            if (MeasureTypeEnum.MEASURE.getType().equals(measure.getOutboundUnitType())) {
               moveOutboundDetail.setMete(CommonUtil.getStockOutboundMete(
                  sendQuantity, materialInventory.getQuantity().subtract(freezeTotalQuantity), materialInventory.getMete().subtract(freezeTotalMete)
               ));
               moveOutboundDetail.setQuantity(sendQuantity);
            } else {
               moveOutboundDetail.setMete(sendQuantity);
               if (materialInventory.getQuantity() != null) {
                  moveOutboundDetail.setQuantity(sendQuantity.divide(materialInventory.getUnitNet(), 8, this.ROUNDING));
               }
            }
         } else if (BasicClassEnum.STEEL_PLATE.getType().equals(materialInventory.getBasicClass())) {
            moveOutboundDetail.setQuantity(sendQuantity);
            moveOutboundDetail.setMete(
               CommonUtil.getOutboundMete1(unitsPrecision, sendQuantity, materialInventory, freezeTotalMete, freezeTotalQuantity, accountingPrecision)
            );
            moveOutboundDetail.setLength(materialInventory.getLength());
            moveOutboundDetail.setWidth(materialInventory.getWidth());
         } else if (BasicClassEnum.SECTION_STEEL.getType().equals(materialInventory.getBasicClass())) {
            moveOutboundDetail.setMete(
               CommonUtil.getOutboundMete1(unitsPrecision, sendQuantity, materialInventory, freezeTotalMete, freezeTotalQuantity, accountingPrecision)
            );
            moveOutboundDetail.setLength(materialInventory.getLength());
            moveOutboundDetail.setQuantity(sendQuantity);
         } else if (BasicClassEnum.COLOR_ROLL.getType().equals(materialInventory.getBasicClass())) {
            Preconditions.checkArgument(sendQuantity.compareTo(scrapDefinitionConf.getSteelCoilMinLength()) > 0, "出库失败,钢卷出库长度必须大于废料定义长度.");
            Preconditions.checkArgument(sendQuantity.compareTo(BigDecimal.TEN) >= 0, "钢卷出库长度不能小于10MM");
            moveOutboundDetail.setMete(
               CommonUtil.getOutboundMete1(unitsPrecision, sendQuantity, materialInventory, freezeTotalMete, freezeTotalQuantity, accountingPrecision)
            );
            Preconditions.checkArgument(moveOutboundDetail.getMete().compareTo(BigDecimal.valueOf(1000L)) > 0, "出库失败,出库量必须大于1kg");
            moveOutboundDetail.setQuantity(sendQuantity);
            moveOutboundDetail.setWidth(materialInventory.getWidth());
         }

         outMete = moveOutboundDetail.getMete();
      }

      if (moveOutboundDetail.getRecipientId() != null) {
         User user = this.userService.getById(moveOutboundDetail.getRecipientId());
         moveOutboundDetail.setRecipientName(user.getName());
         List<String> recipientName = StrUtil.isNotBlank(outbound.getRecipients())
            ? Arrays.stream(outbound.getRecipients().split(",")).collect(Collectors.toList())
            : new ArrayList<>();
         if (!recipientName.contains(user.getName())) {
            recipientName.add(user.getName());
         }

         outbound.setRecipients(StrUtil.join(",", recipientName));
      }

      if (moveOutboundDetail.getProjectId() != null) {
         if (StrUtil.isNotBlank(outbound.getProjectIds())) {
            List<Long> list = CommonUtil.spilt(outbound.getProjectIds(), ",");
            if (!list.contains(moveOutboundDetail.getProjectId())) {
               outbound.setProjectIds(outbound.getProjectIds() + "," + moveOutboundDetail.getProjectId());
            }
         } else {
            outbound.setProjectIds(moveOutboundDetail.getProjectId() + "");
         }
      }

      this.moveOutboundDetailMapper.insert(moveOutboundDetail);
      outbound.setContainBasicClass(
         outbound.getContainBasicClass() != null ? outbound.getContainBasicClass() | moveOutboundDetail.getBasicClass() : moveOutboundDetail.getBasicClass()
      );
      MaterialFreezeRecord materialFreezeRecord = MaterialFreezeRecord.builder()
         .freezeDetailId(moveOutboundDetail.getId())
         .freezeType(MaterialFreezeTypeEnum.OUTSOURCING.getType())
         .freezeSourceId(outbound.getId())
         .freezeSourceSn(outbound.getApplicationSn())
         .operatorId(UserUtil.getCurrentUserId())
         .operatorName(UserUtil.getCurrentName())
         .mete(outMete != null ? outMete : moveOutboundDetail.getMete())
         .quantity(outQuantity != null ? outQuantity : moveOutboundDetail.getQuantity())
         .boolBatten(outQuantity != null)
         .projectId(moveOutboundDetail.getProjectId())
         .frozenTime(LocalDateTime.now())
         .outboundUnitType(measure.getOutboundUnitType())
         .build();
      if (materialFreeze == null) {
         materialFreeze = BeanUtil.copy(materialInventory, MaterialFreeze.class, "createTime");
         materialFreeze.setTotalQuantity(outQuantity != null ? outQuantity : moveOutboundDetail.getQuantity());
         materialFreeze.setTotalMete(outMete);
         materialFreeze.setTotalFreezeTypes(MaterialFreezeTypeEnum.OUTSOURCING.getType() + "");
         materialFreeze.setMaterialInventoryId(materialInventory.getId());
         this.materialFreezeService.save(materialFreeze);
      } else {
         if (freezeRecord != null) {
            if (freezeRecord.getMete().compareTo(moveOutboundDetail.getMete()) < 0) {
               materialFreezeRecord.setApplyPurchaseQuantity(freezeRecord.getQuantity());
               materialFreezeRecord.setApplyPurchaseMete(freezeRecord.getMete());
            } else {
               materialFreezeRecord.setApplyPurchaseQuantity(moveOutboundDetail.getQuantity());
               materialFreezeRecord.setApplyPurchaseMete(moveOutboundDetail.getMete());
            }

            if (freezeRecord.getQuantity() != null) {
               freezeRecord.setQuantity(freezeRecord.getQuantity().subtract(moveOutboundDetail.getQuantity()));
            }

            freezeRecord.setMete(freezeRecord.getMete().subtract(moveOutboundDetail.getMete()));
            if (freezeRecord.getMete().compareTo(BigDecimal.ZERO) <= 0) {
               if (freezeRecord.getMete().compareTo(BigDecimal.ZERO) != 0) {
                  materialFreeze.setTotalQuantity(
                     freezeRecord.getQuantity() != null ? materialFreeze.getTotalQuantity().add(freezeRecord.getQuantity().negate()) : null
                  );
                  materialFreeze.setTotalMete(materialFreeze.getTotalMete().add(freezeRecord.getMete().negate()));
               }

               this.materialFreezeRecordMapper.deleteById(freezeRecord);
            } else {
               this.materialFreezeRecordMapper.updateById(freezeRecord);
            }

            materialFreezeRecord.setBoolChangeOutbound(true);
            materialFreezeRecord.setApplyPurchaseId(freezeRecord.getFreezeSourceId());
            materialFreezeRecord.setApplyPurchaseDetailId(freezeRecord.getFreezeDetailId());
            materialFreezeRecord.setApplyPurchaseSn(freezeRecord.getFreezeSourceSn());
         } else {
            if (moveOutboundDetail.getQuantity() != null) {
               materialFreeze.setTotalQuantity(
                  outQuantity != null
                     ? materialFreeze.getTotalQuantity().add(outQuantity)
                     : materialFreeze.getTotalQuantity().add(moveOutboundDetail.getQuantity())
               );
            }

            freezeTypes.add(MaterialFreezeTypeEnum.OUTSOURCING.getType());
            materialFreeze.setTotalFreezeTypes(StrUtil.join(",", freezeTypes));
            materialFreeze.setTotalMete(materialFreeze.getTotalMete().add(outMete));
         }

         this.materialFreezeService.updateById(materialFreeze);
      }

      materialFreezeRecord.setMaterialFreezeId(materialFreeze.getId());
      this.materialFreezeRecordMapper.insert(materialFreezeRecord);
      if (!materialInventory.getBoolHasFrozen()) {
         this.materialInventoryMapper.updateBoolHasFrozen(materialInventory.getId(), true);
      }

      return this.baseMapper.updateById(outbound) == 1;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean outsourcingDirectSubmitReview(SteelPlateOutboundDTOParam param) {
      if (param.getOutboundTypeSelection().equals(OutboundTypeEnum.OUTSOURCING_RAW_MATERIALS.getType())) {
         if (param.getBoolSubmitCheck()) {
            this.saveOutsourcingOutbound(param);
            List<OutboundDetailDTO> outboundDetailDTOS = new ArrayList<>();
            OutboundDTOParam outboundDTOParam = OutboundDTOParam.builder().id(param.getId()).list(outboundDetailDTOS).build();
            this.submitReview(outboundDTOParam);
         } else {
            this.saveOutsourcingOutbound(param);
         }
      } else if (param.getOutboundTypeSelection().equals(OutboundTypeEnum.SCRAPS.getType())) {
         if (param.getBoolSubmitCheck()) {
            this.saveScrapsOutbound(param);
            List<OutboundDetailDTO> outboundDetailDTOS = new ArrayList<>();
            OutboundDetailDTO outboundDetailDTO = OutboundDetailDTO.builder().id(param.getMaterialId()).outboundTime(param.getOutboundTime()).build();
            outboundDetailDTOS.add(outboundDetailDTO);
            OutboundDTOParam outboundDTOParam = OutboundDTOParam.builder().id(param.getId()).list(outboundDetailDTOS).build();
            this.submitReview(outboundDTOParam);
         } else {
            this.saveScrapsOutbound(param);
         }
      }

      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean outsourcingApproval(Long id, Long approveRecordId, Integer decision, String opinion) {
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService.getById(approveRecordId);
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(wmsApproveRecord), "审批日志不存在");
      String jsonData = null;
      Boolean b = this.wmsApproveRecordService.commonApproveStep(wmsApproveRecord.getDataId(), decision, opinion, wmsApproveRecord.getSerialNumber(), jsonData);
      if (b) {
         if (decision.equals(CheckStatusEnum.PASS.getType())) {
            Outbound outbound = this.baseMapper.selectById(wmsApproveRecord.getDataId());
            this.outsourcingPassed(outbound);
         } else {
            this.outsourcingReturned(id, ReviewStatusEnum.RETURNED.getType());
         }
      }

      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   public Boolean outsourcingPassed(Outbound outbound) {
      String currentName = UserUtil.getCurrentName();
      Long currentUserId = UserUtil.getCurrentUserId();
      LocalDateTime dateTime = LocalDateTime.now();
      Preconditions.checkArgument(outbound != null, "出库单不存在,请核对后操作.");
      Preconditions.checkArgument(ReviewStatusEnum.AUDITING.getType().equals(outbound.getReviewStatus()), "出库单已审核,请核对后操作");
      outbound.setReviewerId(currentUserId);
      outbound.setReviewerId(currentUserId);
      outbound.setReviewerName(currentName);
      outbound.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
      outbound.setReviewTime(dateTime);
      outbound.setOutboundTime(dateTime);
      outbound.setUserUpdateTime(dateTime);
      String serviceNumber = this.numberConfigService.getNumber(NumberTypeEnum.OUTBOUND_REVIEW, this.baseMapper.getCount(LocalDateTime.now()));
      outbound.setSerialNumber(serviceNumber);
      Long statisticsId = null;
      MaterialInventory colorRollMaterial = null;
      outbound.setOutboundStartTime(null);
      outbound.setOutboundEndTime(null);
      WeightedPriceConf weightedPriceConf = JSON.parseObject(
         this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置")).getValue(), WeightedPriceConf.class
      );
      WeightedExecutionPriceConf weightedExecutionPriceConf = JSON.parseObject(
         this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权执行方式配置")).getValue(),
         WeightedExecutionPriceConf.class
      );
      Map<String, Transfer> transferMap = new HashMap<>();
      Transfer transfer = null;

      for (MoveOutboundDetail outboundDetail : this.moveOutboundDetailMapper
         .selectList((Wrapper<MoveOutboundDetail>)Wrappers.<MoveOutboundDetail>lambdaQuery().eq(MoveOutboundDetail::getOutboundId, outbound.getId()))) {
         MaterialInventory materialInventory = this.materialInventoryMapper.selectById(outboundDetail.getMaterialInventoryId());
         Measure measure = this.measureMapper
            .selectOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, materialInventory.getClassifyId()));
         Integer accountingPrecision = measure.getAccountingPrecision();
         BigDecimal unitsPrecision = UnitsPrecisionEnum.getByName(measure.getAccountingUnit());
         MonthWeightedAveragePrice wap = this.weightedAveragePriceService.getPrice(materialInventory);
         outboundDetail.setWapId(wap.getId());
         boolean isBattenOutbound = BasicClassEnum.COLOR_ROLL.getType().equals(outboundDetail.getBasicClass()) && outboundDetail.getLength() != null;
         BigDecimal reservedHalfMete = MaterialOutboundModeEnum.HALF.getType().equals(outboundDetail.getOutboundType())
            ? this.getHalfSourceMete(outbound, outboundDetail, materialInventory, MaterialFreezeTypeEnum.OUTSOURCING.getType()) : null;
         this.materialFreezeService.materialUnfreeze(outbound.getId(), outboundDetail.getId(), MaterialFreezeTypeEnum.OUTSOURCING.getType(), false);
         WasteConfig scrapDefinitionConf = this.basicConfigService.getSteelScrapDefinitionConf();
         StatisticsEndPeriod surplusEndPeriod = null;
         BigDecimal oneMete = BigDecimal.ZERO;
         if (isBattenOutbound) {
            Preconditions.checkArgument(false, "出库失败！！！");
         } else {
            if (MaterialOutboundModeEnum.HALF.getType().equals(outboundDetail.getOutboundType())) {
               BigDecimal outMete = reservedHalfMete;
               oneMete = materialInventory.getMete().divide(materialInventory.getQuantity(), 0, this.ROUNDING);
               materialInventory.setQuantity(materialInventory.getQuantity().subtract(outboundDetail.getQuantity()));
               materialInventory.setMete(materialInventory.getMete().subtract(outMete));
               BigDecimal length = materialInventory.getLength();
               BigDecimal width = materialInventory.getWidth();
               if (outboundDetail.getHalfMode() != null) {
                  if (HalfModeEnum.LENGTH.getType().equals(outboundDetail.getHalfMode())) {
                     length = materialInventory.getLength().subtract(outboundDetail.getLength());
                  } else {
                     width = materialInventory.getWidth().subtract(outboundDetail.getWidth());
                  }
               }

               boolean isScrap;
               if (BasicClassEnum.STEEL_PLATE.getType().equals(materialInventory.getBasicClass())) {
                  isScrap = length.compareTo(scrapDefinitionConf.getSteelPlateShortestSideMinLength()) <= 0
                     || width.compareTo(scrapDefinitionConf.getSteelPlateShortestSideMinLength()) <= 0;
               } else {
                  isScrap = length.compareTo(scrapDefinitionConf.getSectionSteelMinLength()) <= 0;
               }

               BigDecimal outboundRearMete = outMete.subtract(outboundDetail.getMete());
               if (isScrap) {
                  Scrap scrap = BeanUtil.copy(materialInventory, Scrap.class, "createTime");
                  scrap.setQuantity(outboundDetail.getQuantity());
                  scrap.setMete(outboundRearMete);
                  scrap.setLength(length);
                  scrap.setWidth(width);
                  scrap.setCreateTime(LocalDateTime.now());
                  this.scrapMapper.insert(scrap);
               } else {
                  MaterialInventory newMaterialInventory = BeanUtil.copy(materialInventory, MaterialInventory.class, "createTime");
                  newMaterialInventory.setSourceMaterielId(materialInventory.getId());
                  newMaterialInventory.setMaterialIsWhole(2);
                  newMaterialInventory.setLength(length);
                  newMaterialInventory.setWidth(width);
                  newMaterialInventory.setQuantity(outboundDetail.getQuantity());
                  newMaterialInventory.setCreateTime(dateTime);
                  newMaterialInventory.setInventoryStartTime(dateTime);
                  newMaterialInventory.setOutboundSn(outbound.getSerialNumber());
                  newMaterialInventory.setMete(outboundRearMete);
                  newMaterialInventory.setBoolHasFrozen(false);
                  if (BasicClassEnum.STEEL_PLATE.getType().equals(materialInventory.getBasicClass())) {
                     newMaterialInventory.setOneTheoryWeight(
                        CommonUtil.getTheoryMete(
                           materialInventory.getClassifyName(),
                           newMaterialInventory.getLength(),
                           newMaterialInventory.getWidth(),
                           newMaterialInventory.getThickness(),
                           null,
                           materialInventory.getClassifyId()
                        )
                     );
                  } else {
                     newMaterialInventory.setOneTheoryWeight(
                        CommonUtil.getTheoryMete(
                           null, newMaterialInventory.getLength(), null, null, newMaterialInventory.getSectionSteelWeight(), materialInventory.getClassifyId()
                        )
                     );
                  }

                  Print print = Print.builder()
                     .receiptId(newMaterialInventory.getId())
                     .receiptSerialNumber(newMaterialInventory.getSerialNumber())
                     .receiptReviewer(outbound.getReviewerName())
                     .receiptReviewTime(outbound.getReviewTime())
                     .receiptType(ReceiptTypeEnum.OUTSOURCING.getType())
                     .type(MaterialLabelPrintTypeEnum.OUTBOUND.getType())
                     .totalNotPrintNumber(newMaterialInventory.getQuantity().intValue())
                     .projectIds(materialInventory.getProjectId() != null ? "" + materialInventory.getProjectId() : null)
                     .containBasicClass(materialInventory.getBasicClass())
                     .build();
                  this.printService.save(print);
                  String barcode = this.printService
                     .savePrint(
                        PrintDetail.builder()
                           .printId(print.getId())
                           .basicClass(newMaterialInventory.getBasicClass())
                           .classifyId(newMaterialInventory.getClassifyId())
                           .classifyName(materialInventory.getClassifyName())
                           .specification(newMaterialInventory.getSpecification())
                           .mete(newMaterialInventory.getMete())
                           .quantity(newMaterialInventory.getQuantity())
                           .brand(newMaterialInventory.getBrand())
                           .heatNoAndBatchNo(newMaterialInventory.getHeatNoAndBatchNo())
                           .workshopId(newMaterialInventory.getWorkshopId())
                           .warehouseId(newMaterialInventory.getWarehouseId())
                           .projectId(newMaterialInventory.getProjectId())
                           .type(MaterialLabelPrintTypeEnum.OUTBOUND.getType())
                           .boolPartyA(newMaterialInventory.getBoolPartyA())
                           .length(newMaterialInventory.getLength())
                           .width(newMaterialInventory.getWidth())
                           .thickness(newMaterialInventory.getThickness())
                           .color(newMaterialInventory.getColor())
                           .notPrintNumber(
                              BasicClassEnum.COLOR_ROLL.getType().equals(newMaterialInventory.getBasicClass()) ? 1 : outboundDetail.getQuantity().intValue()
                           )
                           .standardId(newMaterialInventory.getStandardId())
                           .standardName(newMaterialInventory.getStandardName())
                           .materialIsWhole(newMaterialInventory.getMaterialIsWhole())
                           .monomerId(newMaterialInventory.getMonomerId())
                           .areaId(newMaterialInventory.getAreaId())
                           .build()
                     );
                  newMaterialInventory.setBarcode(barcode);
                  if (!BasicClassEnum.COLOR_ROLL.getType().equals(newMaterialInventory.getBasicClass())) {
                     MaterialInventory byMaterial = this.materialInventoryMapper.getByMaterial(newMaterialInventory);
                     if (byMaterial != null) {
                        if (byMaterial.getQuantity() != null) {
                           byMaterial.setQuantity(byMaterial.getQuantity().add(newMaterialInventory.getQuantity()));
                        }

                        byMaterial.setMete(byMaterial.getMete().add(newMaterialInventory.getMete()));
                        byMaterial.setInventoryEndTime(LocalDateTime.now());
                        this.materialInventoryMapper.updateById(byMaterial);
                        newMaterialInventory = byMaterial;
                     } else {
                        this.materialInventoryMapper.insert(newMaterialInventory);
                     }
                  } else {
                     this.materialInventoryMapper.insert(newMaterialInventory);
                  }

                  StatisticsEndPeriod statisticsEndPeriod = this.statisticsEndPeriodMapper
                     .selectOne(
                        (Wrapper<StatisticsEndPeriod>)Wrappers.<StatisticsEndPeriod>lambdaQuery().eq(StatisticsEndPeriod::getMaterialInventoryId, newMaterialInventory.getId())
                     );
                  if (statisticsEndPeriod != null) {
                     statisticsEndPeriod.setMete(newMaterialInventory.getMete());
                     if (newMaterialInventory.getQuantity() != null && statisticsEndPeriod.getQuantity() != null) {
                        statisticsEndPeriod.setQuantity(newMaterialInventory.getQuantity());
                     }

                     this.statisticsEndPeriodMapper.updateById(statisticsEndPeriod);
                  } else {
                     Statistics statistics = this.statisticsMapper.get(materialInventory);
                     surplusEndPeriod = BeanUtil.copy(newMaterialInventory, StatisticsEndPeriod.class, "createTime");
                     surplusEndPeriod.setMaterialInventoryId(newMaterialInventory.getId());
                     surplusEndPeriod.setStatisticsId(statistics.getId());
                     this.statisticsEndPeriodMapper.insert(surplusEndPeriod);
                  }
               }
            } else {
               materialInventory.setMete(materialInventory.getMete().subtract(outboundDetail.getMete()));
               materialInventory.setQuantity(
                  outboundDetail.getQuantity() != null ? materialInventory.getQuantity().subtract(outboundDetail.getQuantity()) : null
               );
            }

            if (BasicClassEnum.COLOR_ROLL.getType().equals(materialInventory.getBasicClass())) {
               if (materialInventory.getQuantity().compareTo(BigDecimal.ZERO) > 0) {
                  if (scrapDefinitionConf.getSteelCoilMinLength().compareTo(materialInventory.getQuantity()) >= 0) {
                     Scrap scrap = BeanUtil.copy(materialInventory, Scrap.class, "createTime");
                     scrap.setQuantity(materialInventory.getQuantity());
                     scrap.setMete(materialInventory.getMete());
                     scrap.setWidth(materialInventory.getWidth());
                     scrap.setCreateTime(LocalDateTime.now());
                     this.scrapMapper.insert(scrap);
                     this.materialInventoryMapper.deleteById(materialInventory);
                     this.wmsUtil
                        .setInventoryUse(materialInventory, scrap.getQuantity(), scrap.getMete(), ReceiptTypeEnum.SCRAP_MATERIAL, scrap.getId(), null, 1, false);
                  } else {
                     this.materialInventoryMapper.updateById(materialInventory);
                  }
               } else {
                  this.materialInventoryMapper.deleteById(materialInventory);
               }
            } else if (materialInventory.getMete().compareTo(BigDecimal.ZERO) == 0) {
               this.materialInventoryMapper.deleteById(materialInventory);
            } else {
               if (materialInventory.getQuantity() != null) {
                  materialInventory.setUseStatus(materialInventory.getQuantity().compareTo(BigDecimal.ZERO) == 0);
               }

               this.materialInventoryMapper.updateById(materialInventory);
            }

            this.wmsUtil
               .setInventoryUse(
                  materialInventory,
                  outboundDetail.getQuantity(),
                  outboundDetail.getMete(),
                  ReceiptTypeEnum.OUTBOUND,
                  outbound.getId(),
                  outbound.getSerialNumber(),
                  2,
                  true
               );
            Statistics statistics = this.statisticsMapper.get(materialInventory);
            this.setStatisticsEndPeriod(materialInventory, statistics);
            statisticsId = statistics.getId();
            long outPId = outboundDetail.getProjectId() != null ? outboundDetail.getProjectId() : -1L;
            long sourcePId = materialInventory.getProjectId() != null ? materialInventory.getProjectId() : -1L;
            if (outPId != sourcePId) {
               String key = outPId + "-" + materialInventory.getWorkshopId() + "-" + materialInventory.getWarehouseId();
               if (!transferMap.containsKey(key)) {
                  transfer = Transfer.builder()
                     .basicClass(outboundDetail.getBasicClass())
                     .directionProjectId(outboundDetail.getProjectId())
                     .directionWorkshopId(materialInventory.getWorkshopId())
                     .directionWarehouseId(materialInventory.getWarehouseId())
                     .directionMonomerId(outboundDetail.getMonomerId())
                     .directionAreaId(outboundDetail.getAreaId())
                     .transferType(TransferTypeEnum.PROJECT_WARE.getType())
                     .reviewStatus(ReviewStatusEnum.REVIEWED.getType())
                     .applicantId(currentUserId)
                     .editorId(currentUserId)
                     .applicantName(currentName)
                     .editorName(currentName)
                     .reviewerName(currentName)
                     .reviewTime(dateTime)
                     .reviewerId(currentUserId)
                     .userUpdateTime(dateTime)
                     .transferCreateType(2)
                     .outboundSn(outbound.getSerialNumber())
                     .outboundId(outbound.getId())
                     .build();
                  Integer count = this.transferMapper.getMaxDayNumber(LocalDateTime.now());
                  String sn = this.numberConfigService.getNumber(NumberTypeEnum.TRANSFER, count);
                  transfer.setSerialNumber(sn);
                  this.transferMapper.insert(transfer);
                  transferMap.put(key, transfer);
               } else {
                  transfer = transferMap.get(key);
               }

               MaterialInventory copy = BeanUtil.copy(materialInventory, MaterialInventory.class);
               copy.setMete(outboundDetail.getMete());
               PriceDTO price = this.queryUtilService.getPrice(weightedPriceConf, weightedExecutionPriceConf, copy, outboundDetail.getOutboundTime());
               BigDecimal amount = price.getAmount();
               BigDecimal amountExcludingVat = price.getAmountExcludingVat();
               BigDecimal amountNoFreight = price.getAmountNoFreight();
               BigDecimal amountExcludingVatNoFreight = price.getAmountExcludingVatNoFreight();
               TransferDetail transferDetail = TransferDetail.builder()
                  .boolPartyA(materialInventory.getBoolPartyA())
                  .transferId(transfer.getId())
                  .materialInventoryId(materialInventory.getId())
                  .specification(materialInventory.getSpecification())
                  .basicClass(materialInventory.getBasicClass())
                  .length(materialInventory.getLength())
                  .width(materialInventory.getWidth())
                  .thickness(materialInventory.getThickness())
                  .brand(materialInventory.getBrand())
                  .heatNoAndBatchNo(materialInventory.getHeatNoAndBatchNo())
                  .classifyId(materialInventory.getClassifyId())
                  .transferType(TransferTypeEnum.PROJECT_WARE.getType())
                  .sourceWorkshopId(materialInventory.getWorkshopId())
                  .sourceWarehouseId(materialInventory.getWarehouseId())
                  .sourceProjectId(materialInventory.getProjectId())
                  .sourceMonomerId(materialInventory.getMonomerId())
                  .sourceAreaId(materialInventory.getAreaId())
                  .mete(outboundDetail.getMete())
                  .quantity(outboundDetail.getQuantity())
                  .color(materialInventory.getColor())
                  .remark(outboundDetail.getRemark())
                  .taxRate(materialInventory.getTaxRate())
                  .invoiceType(materialInventory.getInvoiceType())
                  .standardId(materialInventory.getStandardId())
                  .standardName(materialInventory.getStandardName())
                  .build();
               if (amount.compareTo(BigDecimal.ZERO) != 0) {
                  transferDetail.setUnitPrice(amount.divide(outboundDetail.getMete(), 12, RoundingMode.HALF_UP));
                  transferDetail.setUnitPriceExcludingVat(amountExcludingVat.divide(outboundDetail.getMete(), 12, RoundingMode.HALF_UP));
               } else {
                  transferDetail.setUnitPrice(BigDecimal.ZERO);
                  transferDetail.setUnitPriceExcludingVat(BigDecimal.ZERO);
               }

               transferDetail.setAmount(amount);
               transferDetail.setAmountExcludingVat(amountExcludingVat);
               transferDetail.setInputVat(transferDetail.getAmount().subtract(transferDetail.getAmountExcludingVat()));
               if (amountNoFreight.compareTo(BigDecimal.ZERO) != 0) {
                  transferDetail.setUnitPriceNoFreight(amountNoFreight.divide(outboundDetail.getMete(), 12, RoundingMode.HALF_UP));
                  transferDetail.setUnitPriceExcludingVatNoFreight(amountExcludingVatNoFreight.divide(outboundDetail.getMete(), 12, RoundingMode.HALF_UP));
               } else {
                  transferDetail.setUnitPriceNoFreight(BigDecimal.ZERO);
                  transferDetail.setUnitPriceExcludingVatNoFreight(BigDecimal.ZERO);
               }

               transferDetail.setAmountNoFreight(amountNoFreight);
               transferDetail.setAmountExcludingVatNoFreight(amountExcludingVatNoFreight);
               transferDetail.setInputVatNoFreight(transferDetail.getAmountNoFreight().subtract(transferDetail.getAmountExcludingVatNoFreight()));
               this.transferDetailMapper.insert(transferDetail);
               if (transferDetail.getQuantity() != null && outboundDetail.getHalfMode() == null) {
                  wap.setQuantity(wap.getQuantity().subtract(transferDetail.getQuantity()));
               }

               wap.setMete(wap.getMete().subtract(transferDetail.getMete()));
               if (WeightedPriceEnum.SINGLE.getType().equals(weightedPriceConf.getWeightedType())) {
                  wap.setAmount(wap.getAmount().subtract(amount));
                  wap.setAmountExcludingVat(wap.getAmountExcludingVat().subtract(amountExcludingVat));
                  wap.setAmountNoFreight(wap.getAmountNoFreight().subtract(amountNoFreight));
                  wap.setAmountExcludingVatNoFreight(wap.getAmountExcludingVatNoFreight().subtract(amountExcludingVatNoFreight));
               }

               this.monthWeightedAveragePriceMapper.updateById(wap);
               statistics.setInboundMete(
                  statistics.getInboundMete() != null ? statistics.getInboundMete().subtract(transferDetail.getMete()) : transferDetail.getMete().negate()
               );
               if (transferDetail.getQuantity() != null) {
                  statistics.setInboundQuantity(
                     statistics.getInboundQuantity() != null
                        ? statistics.getInboundQuantity().subtract(transferDetail.getQuantity())
                        : transferDetail.getQuantity().negate()
                  );
               }

               statistics.setInboundUnitPrice(transferDetail.getUnitPrice());
               statistics.setInboundUnitPriceExcludingVat(transferDetail.getUnitPriceExcludingVat());
               statistics.setInboundAmount(statistics.getInboundAmount() != null ? statistics.getInboundAmount().subtract(amount) : amount.negate());
               statistics.setInboundAmountExcludingVat(
                  statistics.getInboundAmountExcludingVat() != null
                     ? statistics.getInboundAmountExcludingVat().subtract(amountExcludingVat)
                     : amountExcludingVat.negate()
               );
               statistics.setInboundUnitPriceNoFreight(transferDetail.getUnitPriceNoFreight());
               statistics.setInboundUnitPriceExcludingVatNoFreight(transferDetail.getUnitPriceExcludingVatNoFreight());
               statistics.setInboundAmountNoFreight(
                  statistics.getInboundAmountNoFreight() != null ? statistics.getInboundAmountNoFreight().subtract(amountNoFreight) : amountNoFreight.negate()
               );
               statistics.setInboundAmountExcludingVatNoFreight(
                  statistics.getInboundAmountExcludingVatNoFreight() != null
                     ? statistics.getInboundAmountExcludingVatNoFreight().subtract(amountExcludingVatNoFreight)
                     : amountExcludingVatNoFreight.negate()
               );
               StatisticsInbound si = BeanUtil.copy(materialInventory, StatisticsInbound.class, "createTime");
               si.setMaterialInventoryId(materialInventory.getId());
               si.setReceiptType(ReceiptTypeEnum.TRANSFER.getType());
               si.setReceiptId(transfer.getId());
               si.setReceiptSerialNumber(transfer.getSerialNumber());
               si.setStatisticsId(statistics.getId());
               si.setMete(transferDetail.getMete().negate());
               if (materialInventory.getQuantity() != null) {
                  si.setQuantity(transferDetail.getQuantity().negate());
               }

               si.setUnitPrice(transferDetail.getUnitPrice());
               si.setUnitPriceExcludingVat(transferDetail.getUnitPriceExcludingVat());
               si.setAmount(transferDetail.getAmount().negate());
               si.setAmountExcludingVat(transferDetail.getAmountExcludingVat().negate());
               si.setRealTime(outboundDetail.getOutboundTime());
               si.setUnitPriceNoFreight(transferDetail.getUnitPriceNoFreight());
               si.setUnitPriceExcludingVatNoFreight(transferDetail.getUnitPriceExcludingVatNoFreight());
               si.setAmountNoFreight(transferDetail.getAmountNoFreight().negate());
               si.setAmountExcludingVatNoFreight(transferDetail.getAmountExcludingVatNoFreight().negate());
               this.statisticsInboundMapper.insert(si);
               MaterialInventory inventory = BeanUtil.copy(materialInventory, MaterialInventory.class);
               inventory.setId(-1L);
               inventory.setProjectId(outboundDetail.getProjectId());
               inventory.setWorkshopId(outboundDetail.getSourceWorkshopId());
               InboundDetail inboundDetail = InboundDetail.builder()
                  .basicClass(inventory.getBasicClass())
                  .classifyId(inventory.getClassifyId())
                  .accountingUnit(inventory.getAccountingUnit())
                  .length(inventory.getLength())
                  .width(inventory.getWidth())
                  .thickness(inventory.getThickness())
                  .brand(inventory.getBrand())
                  .heatNoAndBatchNo(inventory.getHeatNoAndBatchNo())
                  .specification(inventory.getSpecification())
                  .color(inventory.getColor())
                  .unitNet(inventory.getUnitNet())
                  .quantity(outboundDetail.getQuantity())
                  .mete(outboundDetail.getMete())
                  .workshopId(transfer.getDirectionWorkshopId())
                  .warehouseId(transfer.getDirectionWarehouseId())
                  .measureUnit(inventory.getMeasureUnit())
                  .taxRate(inventory.getTaxRate())
                  .invoiceType(inventory.getInvoiceType())
                  .standardName(inventory.getStandardName())
                  .standardId(inventory.getStandardId())
                  .oneTheoryWeight(inventory.getOneTheoryWeight())
                  .sectionSteelWeight(inventory.getSectionSteelWeight())
                  .boolPartyA(inventory.getBoolPartyA())
                  .amount(amount)
                  .amountExcludingVat(amountExcludingVat)
                  .unitPrice(transferDetail.getUnitPrice())
                  .unitPriceExcludingVat(transferDetail.getUnitPriceExcludingVat())
                  .amountNoFreight(amountNoFreight)
                  .amountExcludingVatNoFreight(amountExcludingVatNoFreight)
                  .unitPriceNoFreight(transferDetail.getUnitPriceNoFreight())
                  .unitPriceExcludingVatNoFreight(transferDetail.getUnitPriceExcludingVatNoFreight())
                  .projectId(outboundDetail.getProjectId())
                  .build();
               Statistics targetStatistics = this.weightedAveragePriceService
                  .createMonthWAP(inboundDetail, inventory, transfer.getId(), transfer.getSerialNumber(), ReceiptTypeEnum.TRANSFER.getType());
               targetStatistics.setOutboundMete(
                  targetStatistics.getOutboundMete() != null ? targetStatistics.getOutboundMete().add(outboundDetail.getMete()) : outboundDetail.getMete()
               );
               targetStatistics.setOutboundQuantity(
                  targetStatistics.getOutboundQuantity() != null
                     ? targetStatistics.getOutboundQuantity().add(outboundDetail.getQuantity())
                     : outboundDetail.getQuantity()
               );
               targetStatistics.setEndMete(targetStatistics.getEndMete().subtract(outboundDetail.getMete()));
               if (targetStatistics.getEndQuantity() != null) {
                  targetStatistics.setEndQuantity(targetStatistics.getEndQuantity().subtract(outboundDetail.getQuantity()));
               }

               this.statisticsMapper.updateById(targetStatistics);
               outboundDetail.setWapId(targetStatistics.getWapId());
               statisticsId = targetStatistics.getId();
            }

            if (statistics.getId().equals(statisticsId)) {
               statistics.setOutboundMete(
                  statistics.getOutboundMete() != null ? outboundDetail.getMete().add(statistics.getOutboundMete()) : outboundDetail.getMete()
               );
               statistics.setOutboundQuantity(
                  statistics.getOutboundQuantity() != null ? outboundDetail.getQuantity().add(statistics.getOutboundQuantity()) : outboundDetail.getQuantity()
               );
            }

            statistics.setEndMete(statistics.getEndMete().subtract(outboundDetail.getMete()));
            if (statistics.getEndQuantity() != null && surplusEndPeriod == null) {
               statistics.setEndQuantity(statistics.getEndQuantity().subtract(outboundDetail.getQuantity()));
            }

            this.statisticsMapper.updateById(statistics);
            this.saveStatisticsOutbound(outbound, outboundDetail, materialInventory, statisticsId);
            MaterialReturnable materialReturnable = MaterialReturnable.builder()
               .sourceWorkshopId(materialInventory.getWorkshopId())
               .classifyId(materialInventory.getClassifyId())
               .classifyName(materialInventory.getClassifyName())
               .boolPartyA(materialInventory.getBoolPartyA())
               .outboundUnitType(measure.getOutboundUnitType())
               .basicClass(materialInventory.getBasicClass())
               .specification(materialInventory.getSpecification())
               .mete(outboundDetail.getMete())
               .accountingUnit(materialInventory.getAccountingUnit())
               .returnableMete(outboundDetail.getMete())
               .quantity(outboundDetail.getQuantity())
               .unitNet(materialInventory.getUnitNet())
               .length(outboundDetail.getLength())
               .width(outboundDetail.getWidth())
               .thickness(materialInventory.getThickness())
               .theoryThickness(materialInventory.getTheoryThickness())
               .brand(materialInventory.getBrand())
               .heatNoAndBatchNo(materialInventory.getHeatNoAndBatchNo())
               .color(materialInventory.getColor())
               .projectId(outboundDetail.getProjectId())
               .outboundId(outbound.getId())
               .outboundSn(outbound.getSerialNumber())
               .outboundDetailId(outboundDetail.getId())
               .workshopId(materialInventory.getWorkshopId())
               .warehouseId(materialInventory.getWarehouseId())
               .outboundTime(outboundDetail.getOutboundTime())
               .weightedAverageSpec(materialInventory.getWeightedAverageSpec())
               .taxRate(outboundDetail.getTaxRate())
               .invoiceType(outboundDetail.getInvoiceType())
               .boolReviewPending(false)
               .boolReturn(true)
               .standardId(materialInventory.getStandardId())
               .standardName(materialInventory.getStandardName())
               .sectionSteelWeight(materialInventory.getSectionSteelWeight())
               .oneTheoryWeight(materialInventory.getOneTheoryWeight())
               .materialSn(materialInventory.getSerialNumber())
               .monomerId(outboundDetail.getMonomerId())
               .areaId(outboundDetail.getAreaId())
               .workshopId(outboundDetail.getWorkshopId())
               .outboundTypeSelection(outboundDetail.getOutboundTypeSelection())
               .areaBatchId(outboundDetail.getAreaBatchId())
               .build();
            if (outboundDetail.getRecipientId() != null) {
               materialReturnable.setRecipientId(outboundDetail.getRecipientId());
               materialReturnable.setRecipientName(this.userService.getById(outboundDetail.getRecipientId()).getName());
            }

            if (MaterialIsWholeEnum.WHOLE.getType().equals(materialInventory.getMaterialIsWhole())) {
               if (outboundDetail.getOutboundType() == 1) {
                  materialReturnable.setMaterialIsWhole(MaterialIsWholeEnum.WHOLE.getType());
               } else {
                  materialReturnable.setMaterialIsWhole(MaterialIsWholeEnum.ODDMENT.getType());
               }
            } else {
               materialReturnable.setMaterialIsWhole(MaterialIsWholeEnum.ODDMENT.getType());
            }

            if (BasicClassEnum.SECTION_STEEL.getType().equals(materialInventory.getBasicClass())) {
               if (MaterialOutboundModeEnum.HALF.getType().equals(outboundDetail.getOutboundType())) {
                  materialReturnable.setSingleReturnableLength(outboundDetail.getLength());
               } else {
                  materialReturnable.setSingleReturnableLength(materialInventory.getLength());
               }
            }

            if (BasicClassEnum.COLOR_ROLL.getType().equals(materialInventory.getBasicClass())) {
               materialReturnable.setSingleMete(outboundDetail.getMete());
               materialReturnable.setSingleReturnableMete(outboundDetail.getMete());
            } else if (MeasureTypeEnum.MEASURE.getType().equals(measure.getOutboundUnitType())) {
               if (BasicClassEnum.SECTION_STEEL.getType().equals(materialInventory.getBasicClass())
                  || BasicClassEnum.STEEL_PLATE.getType().equals(materialInventory.getBasicClass())) {
                  BigDecimal singleMete = outboundDetail.getMete().divide(outboundDetail.getQuantity(), 8, RoundingMode.DOWN);
                  BigDecimal multiply = singleMete;
                  materialReturnable.setSingleMete(multiply);
                  materialReturnable.setSingleReturnableMete(multiply);
               }
            } else {
               materialReturnable.setSingleMete(outboundDetail.getMete());
               materialReturnable.setSingleReturnableMete(outboundDetail.getMete());
            }

            this.materialReturnableMapper.insert(materialReturnable);
         }

         this.moveOutboundDetailMapper.updateById(outboundDetail);
         this.warningService.updateStatus(materialInventory, 2);
      }

      if (colorRollMaterial != null) {
         BigDecimal outboundMete = outbound.getOutboundMete();
         BigDecimal outboundLength = outbound.getOutboundLength();
         colorRollMaterial.setMete(colorRollMaterial.getMete().subtract(outboundMete));
         colorRollMaterial.setQuantity(colorRollMaterial.getQuantity().subtract(outboundLength));
         if (colorRollMaterial.getQuantity().compareTo(BigDecimal.ZERO) > 0) {
            this.materialInventoryMapper.updateById(colorRollMaterial);
         } else {
            this.materialInventoryMapper.deleteById(colorRollMaterial);
         }

         this.wmsUtil
            .setInventoryUse(colorRollMaterial, outboundLength, outboundMete, ReceiptTypeEnum.OUTBOUND, outbound.getId(), outbound.getSerialNumber(), 2, true);
         Statistics statistics = this.statisticsMapper.selectById(statisticsId);
         this.setStatisticsEndPeriod(colorRollMaterial, statistics);
         statistics.setOutboundMete(statistics.getOutboundMete() != null ? outboundMete.add(statistics.getOutboundMete()) : outboundMete);
         statistics.setOutboundQuantity(statistics.getOutboundQuantity() != null ? outboundLength.add(statistics.getOutboundQuantity()) : outboundLength);
         statistics.setEndMete(statistics.getEndMete().subtract(outboundMete));
         statistics.setEndQuantity(statistics.getEndQuantity().subtract(outboundLength));
         this.statisticsMapper.updateById(statistics);
      }

      return this.baseMapper.updateById(outbound) == 1;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean outsourcingReturned(Long id, Integer reviewStatus) {
      Outbound outbound = this.baseMapper.selectById(id);
      Preconditions.checkArgument(outbound != null, "出库单不存在,请核对后操作");
      Preconditions.checkArgument(ReviewStatusEnum.AUDITING.getType().equals(outbound.getReviewStatus()), "出库单已审核,请核对后操作");
      outbound.setReviewerId(UserUtil.getCurrentUserId());
      outbound.setReviewerName(UserUtil.getCurrentName());
      outbound.setReviewStatus(reviewStatus);
      outbound.setReviewTime(LocalDateTime.now());
      outbound.setOutboundTime(LocalDateTime.now());
      outbound.setUserUpdateTime(LocalDateTime.now());
      this.baseMapper.updateById(outbound);
      this.materialFreezeService.materialUnfreeze(outbound.getId(), -1L, MaterialFreezeTypeEnum.OUTSOURCING.getType(), true);
      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean BatchOutsourcingSubmitReview(BatchOutboundDTOParam param) {
      SteelPlateOutboundDTOParam copy = BeanUtil.copy(param, SteelPlateOutboundDTOParam.class);
      if (copy.getOutboundTypeSelection().equals(OutboundTypeEnum.OUTSOURCING_RAW_MATERIALS.getType())) {
         if (copy.getBoolSubmitCheck()) {
            for (BatchOutboundDetailDTOParam detailDTOParam : param.getList()) {
               BeanUtil.copy(detailDTOParam, copy);
               copy.setMaterialId(detailDTOParam.getId());
               copy.setMaterialOutboundMode(1);
               this.saveOutsourcingOutbound(copy);
            }
            OutboundDTOParam review = OutboundDTOParam.builder().id(copy.getId()).list(new ArrayList<>()).build();
            this.submitReview(review);
         } else {
            for (BatchOutboundDetailDTOParam detailDTOParam : param.getList()) {
               BeanUtil.copy(detailDTOParam, copy);
               copy.setMaterialId(detailDTOParam.getId());
               copy.setMaterialOutboundMode(1);
               this.saveOutsourcingOutbound(copy);
            }
         }
      } else if (copy.getOutboundTypeSelection().equals(OutboundTypeEnum.SCRAPS.getType())) {
         if (copy.getBoolSubmitCheck()) {
            for (BatchOutboundDetailDTOParam detailDTOParam : param.getList()) {
               BeanUtil.copy(detailDTOParam, copy);
               copy.setMaterialId(detailDTOParam.getId());
               copy.setMaterialOutboundMode(1);
               this.saveOutsourcingOutbound(copy);
            }
         } else {
            for (BatchOutboundDetailDTOParam detailDTOParam : param.getList()) {
               BeanUtil.copy(detailDTOParam, copy);
               copy.setMaterialId(detailDTOParam.getId());
               copy.setMaterialOutboundMode(1);
               this.saveScrapsOutbound(copy);
            }
         }
      }

      return true;
   }

   public OutboundDTO getByCurrentUserOutsourcing(Integer outboundType) {
      Outbound outbound = this.baseMapper
         .selectOne(
            ((Wrappers.<Outbound>lambdaQuery().eq(Outbound::getReviewStatus, ReviewStatusEnum.UN_REVIEWED.getType()))
                  .eq(Outbound::getApplicantId, UserUtil.getCurrentUserId()))
               .eq(outboundType != null, Outbound::getOutboundTypeSelection, outboundType)
         );
      return outbound == null ? null : this.getOutsourcingOutboundById(outbound.getId());
   }

   public OutboundDTO getOutsourcingOutboundById(Long id) {
      Outbound outbound = this.baseMapper.selectById(id);
      Preconditions.checkArgument(outbound != null, "出库单不存在");
      OutboundDTO outboundDTO = BeanUtil.copy(outbound, OutboundDTO.class, "");
      outboundDTO.setApplicantSN(outbound.getApplicationSn());
      Department department = this.departmentService.selectByUserId(outbound.getApplicantId());
      outboundDTO.setApplicant(BriefDeptAndNameDTO.builder().name(outbound.getApplicantName()).deptName(department.getName()).build());
      int basicClass = 0;
      List<MoveOutboundDetail> moveOutboundDetails = this.moveOutboundDetailMapper
         .selectList((Wrapper<MoveOutboundDetail>)Wrappers.<MoveOutboundDetail>lambdaQuery().eq(MoveOutboundDetail::getOutboundId, outbound.getId()));
      List<OutboundDetailDTO> list = new ArrayList<>();
      this.getDetailDTO(basicClass, moveOutboundDetails, list, false);
      outboundDTO.setBasicClass(basicClass);
      outboundDTO.setList(list);
      return outboundDTO;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean deleteOutsourcing(Long listId, Long materialId) {
      Outbound outbound = this.baseMapper.selectById(listId);
      Preconditions.checkArgument(outbound != null, "当前出库单不存在");
      Preconditions.checkArgument(UserUtil.getCurrentUserId().equals(outbound.getApplicantId()), "仅创建此出库单的人才可删除外协草稿物料");
      MoveOutboundDetail moveOutboundDetail = this.moveOutboundDetailMapper.selectById(materialId);
      Preconditions.checkArgument(moveOutboundDetail != null, "当前出库详情不存在");
      Preconditions.checkArgument(moveOutboundDetail.getOutboundId().equals(listId), "当前出库物料不属于该出库单,请核对后操作.");
      Preconditions.checkArgument(ReviewStatusEnum.NOT_SUBMITTED.getType().equals(outbound.getReviewStatus()), "出库单正在审核中或已审核,请核对后操作");
      this.moveOutboundDetailMapper.deleteById(moveOutboundDetail);
      this.materialFreezeService.materialUnfreeze(outbound.getId(), moveOutboundDetail.getId(), MaterialFreezeTypeEnum.OUTSOURCING.getType(), true);
      List<MoveOutboundDetail> moveOutboundDetails = this.moveOutboundDetailMapper
         .selectList((Wrapper<MoveOutboundDetail>)Wrappers.<MoveOutboundDetail>lambdaQuery().eq(MoveOutboundDetail::getOutboundId, listId));
      if (CollectionUtil.isEmpty(moveOutboundDetails)) {
         this.baseMapper.deleteById(outbound);
      } else {
         List<String> list = new ArrayList<>();
         Set<Long> pIds = new HashSet<>();
         int basicClass = 0;

         for (MoveOutboundDetail detail : moveOutboundDetails) {
            User user = this.userService.getById(detail.getRecipientId());
            if (user != null) {
               list.add(user.getName());
            }

            if (detail.getProjectId() != null) {
               pIds.add(detail.getProjectId());
            }

            basicClass |= detail.getBasicClass();
         }

         outbound.setProjectIds(CollectionUtil.isNotEmpty(pIds) ? StrUtil.join(",", pIds) : null);
         outbound.setContainBasicClass(basicClass);
         outbound.setRecipients(StrUtil.join(",", list));
         this.baseMapper.updateById(outbound);
      }

      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean deleteOutsourcingOutbound(Long id) {
      Outbound outbound = this.baseMapper.selectById(id);
      Preconditions.checkArgument(outbound != null, "出库单不存在,请核对后操作");
      Preconditions.checkArgument(ReviewStatusEnum.NOT_SUBMITTED.getType().equals(outbound.getReviewStatus()), "出库单正在审核中或已审核,请核对后操作");
      outbound.setReviewerId(UserUtil.getCurrentUserId());
      outbound.setReviewerName(UserUtil.getCurrentName());
      outbound.setReviewStatus(15);
      outbound.setReviewTime(LocalDateTime.now());
      outbound.setOutboundTime(LocalDateTime.now());
      outbound.setUserUpdateTime(LocalDateTime.now());
      this.baseMapper.deleteById(outbound);
      this.moveOutboundDetailMapper.delete((Wrapper<MoveOutboundDetail>)Wrappers.<MoveOutboundDetail>lambdaQuery().eq(MoveOutboundDetail::getOutboundId, id));
      this.materialFreezeService.materialUnfreeze(outbound.getId(), -1L, MaterialFreezeTypeEnum.OUTSOURCING.getType(), true);
      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean saveScrapsOutbound(SteelPlateOutboundDTOParam param) {
      Preconditions.checkArgument(param.getQuantity() != null && param.getQuantity().signum() > 0, "出库数量必须大于0");
      MaterialInventory materialInventory = this.materialInventoryMapper.selectById(param.getMaterialId());
      Preconditions.checkArgument(materialInventory != null, "仓库中不存在该物料");
      Measure measure = this.measureMapper
         .selectOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, materialInventory.getClassifyId()));
      SubjectMeasureDTO subjectMeasureDTO = this.measureService.measureListById(materialInventory.getClassifyId());
      Integer accountingPrecision = subjectMeasureDTO.getAccountingPrecision();
      BigDecimal UnitsPrecision = UnitsPrecisionEnum.getByName(subjectMeasureDTO.getAccountingUnit());
      WasteConfig scrapDefinitionConf = this.basicConfigService.getSteelScrapDefinitionConf();
      BasicOutbound outboundBasicConf = this.basicConfigService.getOutboundBasicConf();
      Outbound outbound = this.baseMapper
         .selectOne(
            ((((Wrappers.<Outbound>lambdaQuery()
                           .eq(Outbound::getApplicantId, UserUtil.getCurrentUserId()))
                        .eq(Outbound::getReviewStatus, ReviewStatusEnum.NOT_SUBMITTED.getType()))
                     .eq(param.getConvertId() != null, Outbound::getConvertId, param.getConvertId()))
                  .eq(param.getOutboundTypeSelection() != null, Outbound::getOutboundTypeSelection, param.getOutboundTypeSelection()))
               .eq(param.getBoolPartyA() != null, Outbound::getBoolPartyA, param.getBoolPartyA())
         );
      if (outbound != null) {
         outbound.setUserUpdateTime(LocalDateTime.now());
         param.setId(outbound.getId());
      } else {
         outbound = Outbound.builder()
            .applicantId(UserUtil.getCurrentUserId())
            .applicantName(UserUtil.getCurrentName())
            .userUpdateTime(LocalDateTime.now())
            .reviewStatus(ReviewStatusEnum.NOT_SUBMITTED.getType())
            .outboundStartTime(LocalDateTime.now())
            .outboundEndTime(LocalDateTime.now())
            .convertId(param.getConvertId())
            .boolPartyA(param.getBoolPartyA())
            .outboundTypeSelection(OutboundTypeEnum.SCRAPS.getType())
            .build();
         String serviceNumber = this.numberConfigService.getNumber(NumberTypeEnum.SCRAPS, this.baseMapper.getCount(LocalDateTime.now()));
         outbound.setApplicationSn(serviceNumber);
         this.baseMapper.insert(outbound);
         param.setId(outbound.getId());
      }

      MoveOutboundDetail moveOutboundDetail = MoveOutboundDetail.builder()
         .warehouseId(materialInventory.getWarehouseId())
         .materialIsWhole(materialInventory.getMaterialIsWhole())
         .sourceWorkshopId(materialInventory.getWorkshopId())
         .materialInventoryId(materialInventory.getId())
         .outboundId(outbound.getId())
         .basicClass(materialInventory.getBasicClass())
         .classifyId(materialInventory.getClassifyId())
         .specification(materialInventory.getSpecification())
         .sourceProjectId(materialInventory.getProjectId())
         .sourceMonomerId(materialInventory.getMonomerId())
         .sourceAreaId(materialInventory.getAreaId())
         .thickness(materialInventory.getThickness())
         .theoryThickness(materialInventory.getTheoryThickness())
         .heatNoAndBatchNo(materialInventory.getHeatNoAndBatchNo())
         .brand(materialInventory.getBrand())
         .outboundTime(param.getOutboundTime() != null ? param.getOutboundTime() : LocalDateTime.now())
         .color(materialInventory.getColor())
         .recipientId(param.getRecipientId())
         .outboundMode(param.getMaterialOutboundMode())
         .remark(param.getRemark())
         .boolPartyA(materialInventory.getBoolPartyA())
         .taxRate(materialInventory.getTaxRate())
         .invoiceType(materialInventory.getInvoiceType())
         .standardId(materialInventory.getStandardId())
         .standardName(materialInventory.getStandardName())
         .materialSn(materialInventory.getSerialNumber())
         .outboundAddress(param.getOutboundAddress())
         .outboundTypeSelection(OutboundTypeEnum.SCRAPS.getType())
         .build();
      MaterialFreeze materialFreeze = this.materialFreezeService
         .getOne((Wrapper<MaterialFreeze>)Wrappers.<MaterialFreeze>lambdaQuery().eq(MaterialFreeze::getMaterialInventoryId, materialInventory.getId()));
      MaterialFreezeRecord freezeRecord = null;
      Set<Integer> freezeTypes = null;
      BigDecimal freezeTotalMete;
      BigDecimal freezeTotalQuantity;
      if (materialFreeze != null) {
         freezeTotalMete = materialFreeze.getTotalMete();
         freezeTotalQuantity = materialFreeze.getTotalQuantity();
         freezeTypes = Arrays.stream(materialFreeze.getTotalFreezeTypes().split(",")).map(Integer::parseInt).collect(Collectors.toSet());
         if (freezeTypes.contains(MaterialFreezeTypeEnum.REQUISITIONS.getType())) {
            freezeRecord = this.materialFreezeRecordMapper
               .selectOne(
                  (Wrapper<MaterialFreezeRecord>)((Wrappers.<MaterialFreezeRecord>lambdaQuery()
                           .eq(MaterialFreezeRecord::getMaterialFreezeId, materialFreeze.getId()))
                        .eq(MaterialFreezeRecord::getFreezeType, MaterialFreezeTypeEnum.REQUISITIONS.getType()))
                     .eq(MaterialFreezeRecord::getProjectId, param.getProjectId())
               );
            if (freezeRecord != null) {
               freezeTotalMete = freezeTotalMete.subtract(freezeRecord.getMete());
               if (materialFreeze.getTotalQuantity() != null) {
                  freezeTotalQuantity = freezeTotalQuantity.subtract(freezeRecord.getQuantity());
               }
            }
         }
      } else {
         freezeTotalMete = BigDecimal.ZERO;
         freezeTotalQuantity = BigDecimal.ZERO;
      }

      BigDecimal outMete = null;
      BigDecimal outQuantity = null;
      if (param.getProjectId() != null) {
         if (materialInventory.getBoolPartyA()) {
            Preconditions.checkArgument(materialInventory.getProjectId().equals(param.getProjectId()), "出库失败,甲供物料不能出库到其他项目.");
         }

         if (!outboundBasicConf.getBoolCanOutToOtherProject() && materialInventory.getProjectId() != null) {
            Preconditions.checkArgument(materialInventory.getProjectId().equals(param.getProjectId()), "当前出库项目与物料项目不一致,请核对.");
         }

         if (materialInventory.getProjectId() != null) {
            moveOutboundDetail.setOutboundRelationType(
               materialInventory.getProjectId().equals(param.getProjectId())
                  ? OutboundRelationTypeEnum.ROUTINE.getType()
                  : OutboundRelationTypeEnum.TRANSFER.getType()
            );
         }

         moveOutboundDetail.setProjectId(param.getProjectId());
         moveOutboundDetail.setMonomerId(param.getMonomerId());
         moveOutboundDetail.setAreaId(param.getAreaId());
      }

      if (param.getProjectId() == null && materialInventory.getProjectId() != null) {
         moveOutboundDetail.setProjectId(materialInventory.getProjectId());
         moveOutboundDetail.setMonomerId(materialInventory.getMonomerId());
         moveOutboundDetail.setAreaId(materialInventory.getAreaId());
      }

      if (moveOutboundDetail.getProjectId() != null) {
         ContractProject project = this.contractProjectService.getById(moveOutboundDetail.getProjectId());
         Preconditions.checkArgument(
            moveOutboundDetail.getProjectId() != null && SettlementStatusEnum.UN_SETTLED.getType().equals(project.getSettlementStatus()), "出库失败,当前项目已结算"
         );
      }

      moveOutboundDetail.setOutboundType(MaterialOutboundModeEnum.WHOLE.getType());
      BigDecimal precision = UnitsPrecisionEnum.getByName(measure.getAccountingUnit());
      MeteAndQuantity meteAndQuantitySend = new MeteAndQuantity();
      meteAndQuantitySend.setSendQuantity(param.getQuantity());
      MeteAndQuantity meteAndQuantity = this.checkInventory(
         materialInventory.getBasicClass(),
         materialInventory.getClassifyId(),
         meteAndQuantitySend,
         materialInventory.getQuantity(),
         materialInventory.getMete(),
         freezeTotalQuantity,
         freezeTotalMete,
         subjectMeasureDTO,
         measure
      );
      BigDecimal sendQuantity = meteAndQuantity.getSendQuantity();
      if (BasicClassEnum.checkNotSteel(materialInventory.getBasicClass())) {
         if (measure.getOutboundUnitType() == null) {
            measure = this.getMeasured(materialInventory.getClassifyId());
         }

         if (MeasureTypeEnum.MEASURE.getType().equals(measure.getOutboundUnitType())) {
            moveOutboundDetail.setMete(CommonUtil.getStockOutboundMete(
               sendQuantity, materialInventory.getQuantity().subtract(freezeTotalQuantity), materialInventory.getMete().subtract(freezeTotalMete)
            ));
            moveOutboundDetail.setQuantity(sendQuantity);
         } else {
            moveOutboundDetail.setMete(sendQuantity);
            if (materialInventory.getQuantity() != null) {
               moveOutboundDetail.setQuantity(sendQuantity.divide(materialInventory.getUnitNet(), 8, this.ROUNDING));
            }
         }
      } else if (BasicClassEnum.STEEL_PLATE.getType().equals(materialInventory.getBasicClass())) {
         moveOutboundDetail.setQuantity(sendQuantity);
         BigDecimal outboundMete1 = CommonUtil.getOutboundMete1(
            UnitsPrecision, sendQuantity, materialInventory, freezeTotalMete, freezeTotalQuantity, accountingPrecision
         );
         moveOutboundDetail.setMete(outboundMete1);
         moveOutboundDetail.setLength(materialInventory.getLength());
         moveOutboundDetail.setWidth(materialInventory.getWidth());
      } else if (BasicClassEnum.SECTION_STEEL.getType().equals(materialInventory.getBasicClass())) {
         BigDecimal outboundMete1 = CommonUtil.getOutboundMete1(
            UnitsPrecision, sendQuantity, materialInventory, freezeTotalMete, freezeTotalQuantity, accountingPrecision
         );
         moveOutboundDetail.setMete(outboundMete1);
         moveOutboundDetail.setLength(materialInventory.getLength());
         moveOutboundDetail.setQuantity(sendQuantity);
      } else if (BasicClassEnum.COLOR_ROLL.getType().equals(materialInventory.getBasicClass())) {
         Preconditions.checkArgument(sendQuantity.compareTo(scrapDefinitionConf.getSteelCoilMinLength()) > 0, "出库失败,钢卷出库长度必须大于废料定义长度.");
         Preconditions.checkArgument(sendQuantity.compareTo(BigDecimal.TEN) >= 0, "钢卷出库长度不能小于10MM");
         BigDecimal outboundMete1 = CommonUtil.getOutboundMete1(
            UnitsPrecision, sendQuantity, materialInventory, freezeTotalMete, freezeTotalQuantity, accountingPrecision
         );
         moveOutboundDetail.setMete(outboundMete1);
         Preconditions.checkArgument(moveOutboundDetail.getMete().compareTo(BigDecimal.valueOf(1000L)) > 0, "出库失败,出库量必须大于1kg");
         moveOutboundDetail.setQuantity(sendQuantity);
         moveOutboundDetail.setWidth(materialInventory.getWidth());
      }

      outMete = moveOutboundDetail.getMete();
      if (moveOutboundDetail.getRecipientId() != null) {
         User user = this.userService.getById(moveOutboundDetail.getRecipientId());
         moveOutboundDetail.setRecipientName(user.getName());
         List<String> recipientName = StrUtil.isNotBlank(outbound.getRecipients())
            ? Arrays.stream(outbound.getRecipients().split(",")).collect(Collectors.toList())
            : new ArrayList<>();
         if (!recipientName.contains(user.getName())) {
            recipientName.add(user.getName());
         }

         outbound.setRecipients(StrUtil.join(",", recipientName));
      }

      if (moveOutboundDetail.getProjectId() != null) {
         if (StrUtil.isNotBlank(outbound.getProjectIds())) {
            List<Long> list = CommonUtil.spilt(outbound.getProjectIds(), ",");
            if (!list.contains(moveOutboundDetail.getProjectId())) {
               outbound.setProjectIds(outbound.getProjectIds() + "," + moveOutboundDetail.getProjectId());
            }
         } else {
            outbound.setProjectIds(moveOutboundDetail.getProjectId() + "");
         }
      }

      this.moveOutboundDetailMapper.insert(moveOutboundDetail);
      outbound.setContainBasicClass(
         outbound.getContainBasicClass() != null ? outbound.getContainBasicClass() | moveOutboundDetail.getBasicClass() : moveOutboundDetail.getBasicClass()
      );
      MaterialFreezeRecord materialFreezeRecord = MaterialFreezeRecord.builder()
         .freezeDetailId(moveOutboundDetail.getId())
         .freezeType(MaterialFreezeTypeEnum.SCRAPS.getType())
         .freezeSourceId(outbound.getId())
         .freezeSourceSn(outbound.getApplicationSn())
         .operatorId(UserUtil.getCurrentUserId())
         .operatorName(UserUtil.getCurrentName())
         .mete(outMete != null ? outMete : moveOutboundDetail.getMete())
         .quantity(outQuantity != null ? outQuantity : moveOutboundDetail.getQuantity())
         .boolBatten(outQuantity != null)
         .projectId(moveOutboundDetail.getProjectId())
         .frozenTime(LocalDateTime.now())
         .outboundUnitType(measure.getOutboundUnitType())
         .build();
      if (materialFreeze == null) {
         materialFreeze = BeanUtil.copy(materialInventory, MaterialFreeze.class, "createTime");
         materialFreeze.setTotalQuantity(outQuantity != null ? outQuantity : moveOutboundDetail.getQuantity());
         materialFreeze.setTotalMete(outMete);
         materialFreeze.setTotalFreezeTypes(MaterialFreezeTypeEnum.SCRAPS.getType() + "");
         materialFreeze.setMaterialInventoryId(materialInventory.getId());
         this.materialFreezeService.save(materialFreeze);
      } else {
         if (freezeRecord != null) {
            if (freezeRecord.getMete().compareTo(moveOutboundDetail.getMete()) < 0) {
               materialFreezeRecord.setApplyPurchaseQuantity(freezeRecord.getQuantity());
               materialFreezeRecord.setApplyPurchaseMete(freezeRecord.getMete());
            } else {
               materialFreezeRecord.setApplyPurchaseQuantity(moveOutboundDetail.getQuantity());
               materialFreezeRecord.setApplyPurchaseMete(moveOutboundDetail.getMete());
            }

            if (freezeRecord.getQuantity() != null) {
               freezeRecord.setQuantity(freezeRecord.getQuantity().subtract(moveOutboundDetail.getQuantity()));
            }

            freezeRecord.setMete(freezeRecord.getMete().subtract(moveOutboundDetail.getMete()));
            if (freezeRecord.getMete().compareTo(BigDecimal.ZERO) <= 0) {
               if (freezeRecord.getMete().compareTo(BigDecimal.ZERO) != 0) {
                  materialFreeze.setTotalQuantity(
                     freezeRecord.getQuantity() != null ? materialFreeze.getTotalQuantity().add(freezeRecord.getQuantity().negate()) : null
                  );
                  materialFreeze.setTotalMete(materialFreeze.getTotalMete().add(freezeRecord.getMete().negate()));
               }

               this.materialFreezeRecordMapper.deleteById(freezeRecord);
            } else {
               this.materialFreezeRecordMapper.updateById(freezeRecord);
            }

            materialFreezeRecord.setBoolChangeOutbound(true);
            materialFreezeRecord.setApplyPurchaseId(freezeRecord.getFreezeSourceId());
            materialFreezeRecord.setApplyPurchaseDetailId(freezeRecord.getFreezeDetailId());
            materialFreezeRecord.setApplyPurchaseSn(freezeRecord.getFreezeSourceSn());
         } else {
            if (moveOutboundDetail.getQuantity() != null) {
               materialFreeze.setTotalQuantity(
                  outQuantity != null
                     ? materialFreeze.getTotalQuantity().add(outQuantity)
                     : materialFreeze.getTotalQuantity().add(moveOutboundDetail.getQuantity())
               );
            }

            freezeTypes.add(MaterialFreezeTypeEnum.SCRAPS.getType());
            materialFreeze.setTotalFreezeTypes(StrUtil.join(",", freezeTypes));
            materialFreeze.setTotalMete(materialFreeze.getTotalMete().add(outMete));
         }

         this.materialFreezeService.updateById(materialFreeze);
      }

      materialFreezeRecord.setMaterialFreezeId(materialFreeze.getId());
      this.materialFreezeRecordMapper.insert(materialFreezeRecord);
      if (!materialInventory.getBoolHasFrozen()) {
         this.materialInventoryMapper.updateBoolHasFrozen(materialInventory.getId(), true);
      }

      return this.baseMapper.updateById(outbound) == 1;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean BatchScrapsOutbound(BatchOutboundDTOParam param) {
      SteelPlateOutboundDTOParam copy = BeanUtil.copy(param, SteelPlateOutboundDTOParam.class);

      for (BatchOutboundDetailDTOParam detailDTOParam : param.getList()) {
         BeanUtil.copy(detailDTOParam, copy);
         copy.setMaterialId(detailDTOParam.getId());
         copy.setMaterialOutboundMode(1);
         this.saveScrapsOutbound(copy);
      }

      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean deleteScraps(Long listId, Long materialId) {
      Outbound outbound = this.baseMapper.selectById(listId);
      Preconditions.checkArgument(outbound != null, "当前出库单不存在");
      MoveOutboundDetail moveOutboundDetail = this.moveOutboundDetailMapper.selectById(materialId);
      Preconditions.checkArgument(moveOutboundDetail != null, "当前出库详情不存在");
      Preconditions.checkArgument(moveOutboundDetail.getOutboundId().equals(listId), "当前出库物料不属于该出库单,请核对后操作.");
      Preconditions.checkArgument(ReviewStatusEnum.NOT_SUBMITTED.getType().equals(outbound.getReviewStatus()), "出库单正在审核中或已审核,请核对后操作");
      this.moveOutboundDetailMapper.deleteById(moveOutboundDetail);
      this.materialFreezeService.materialUnfreeze(outbound.getId(), moveOutboundDetail.getId(), MaterialFreezeTypeEnum.SCRAPS.getType(), true);
      List<MoveOutboundDetail> moveOutboundDetails = this.moveOutboundDetailMapper
         .selectList((Wrapper<MoveOutboundDetail>)Wrappers.<MoveOutboundDetail>lambdaQuery().eq(MoveOutboundDetail::getOutboundId, listId));
      if (CollectionUtil.isEmpty(moveOutboundDetails)) {
         this.baseMapper.deleteById(outbound);
      } else {
         List<String> list = new ArrayList<>();
         Set<Long> pIds = new HashSet<>();
         int basicClass = 0;

         for (MoveOutboundDetail detail : moveOutboundDetails) {
            User user = this.userService.getById(detail.getRecipientId());
            if (user != null) {
               list.add(user.getName());
            }

            if (detail.getProjectId() != null) {
               pIds.add(detail.getProjectId());
            }

            basicClass |= detail.getBasicClass();
         }

         outbound.setProjectIds(CollectionUtil.isNotEmpty(pIds) ? StrUtil.join(",", pIds) : null);
         outbound.setContainBasicClass(basicClass);
         outbound.setRecipients(StrUtil.join(",", list));
         this.baseMapper.updateById(outbound);
      }

      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean ScrapsPassed(Long id) {
      String currentName = UserUtil.getCurrentName();
      Long currentUserId = UserUtil.getCurrentUserId();
      LocalDateTime dateTime = LocalDateTime.now();
      Outbound outbound = this.baseMapper.selectById(id);
      Preconditions.checkArgument(outbound != null, "出库单不存在,请核对后操作.");
      Preconditions.checkArgument(OutboundStatusEnum.AUDITING.getType().equals(outbound.getReviewStatus()), "出库单已审核,请核对后操作");
      List<MoveOutboundDetail> details = this.moveOutboundDetailMapper
         .selectList((Wrapper<MoveOutboundDetail>)Wrappers.<MoveOutboundDetail>lambdaQuery().eq(MoveOutboundDetail::getOutboundId, outbound.getId()));
      outbound.setReviewerId(currentUserId);
      outbound.setReviewerName(currentName);
      outbound.setReviewStatus(OutboundStatusEnum.REVIEWED.getType());
      outbound.setReviewTime(dateTime);
      outbound.setOutboundTime(dateTime);
      outbound.setUserUpdateTime(dateTime);
      String serviceNumber = this.numberConfigService.getNumber(NumberTypeEnum.SCRAPS, this.baseMapper.getCount(LocalDateTime.now()));
      outbound.setSerialNumber(serviceNumber);
      outbound.setOutboundStartTime(null);
      outbound.setOutboundEndTime(null);
      WeightedPriceConf weightedPriceConf = JSON.parseObject(
         this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置")).getValue(), WeightedPriceConf.class
      );

      for (MoveOutboundDetail detail : details) {
         MoveOutboundDetail outboundDetail = this.moveOutboundDetailMapper.selectById(detail.getId());
         MaterialInventory materialInventory = this.materialInventoryMapper.selectById(outboundDetail.getMaterialInventoryId());
         MonthWeightedAveragePrice wap = this.weightedAveragePriceService.getPrice(materialInventory);
         outboundDetail.setWapId(wap.getId());
         if (outboundDetail.getOutboundTime() == null) {
            Preconditions.checkArgument(detail.getOutboundTime() != null, "请设置出库时间");
            outboundDetail.setOutboundTime(detail.getOutboundTime());
            if (outbound.getOutboundStartTime() != null) {
               if (detail.getOutboundTime().compareTo(outbound.getOutboundEndTime()) > 0) {
                  outbound.setOutboundEndTime(detail.getOutboundTime());
               }

               if (detail.getOutboundTime().compareTo(outbound.getOutboundStartTime()) < 0) {
                  outbound.setOutboundStartTime(detail.getOutboundTime());
               }
            } else {
               outbound.setOutboundEndTime(detail.getOutboundTime());
               outbound.setOutboundStartTime(detail.getOutboundTime());
            }
         }

         this.materialFreezeService.materialUnfreeze(outbound.getId(), outboundDetail.getId(), MaterialFreezeTypeEnum.SCRAPS.getType(), false);
         BigDecimal amount;
         BigDecimal amountExcludingVat;
         BigDecimal amountNoFreight;
         BigDecimal amountExcludingVatNoFreight;
         if (WeightedPriceEnum.SINGLE.getType().equals(weightedPriceConf.getWeightedType())) {
            BigDecimal p = outboundDetail.getMete().divide(wap.getMete(), 20, this.ROUNDING);
            amount = wap.getAmount().multiply(p).setScale(this.amountAccuracy, this.ROUNDING);
            amountExcludingVat = wap.getAmountExcludingVat().multiply(p).setScale(this.amountAccuracy, this.ROUNDING);
            amountNoFreight = wap.getAmountNoFreight().multiply(p).setScale(this.amountAccuracy, this.ROUNDING);
            amountExcludingVatNoFreight = wap.getAmountExcludingVatNoFreight().multiply(p).setScale(this.amountAccuracy, this.ROUNDING);
         } else {
            WholeWeightedAveragePrice price = this.wholeWAPMapper.getPrice(materialInventory);
            BigDecimal p = outboundDetail.getMete().divide(price.getMete(), 20, this.ROUNDING);
            amount = price.getAmount().multiply(p).setScale(this.amountAccuracy, this.ROUNDING);
            amountExcludingVat = price.getAmountExcludingVat().multiply(p).setScale(this.amountAccuracy, this.ROUNDING);
            amountNoFreight = price.getAmountNoFreight().multiply(p).setScale(this.amountAccuracy, this.ROUNDING);
            amountExcludingVatNoFreight = price.getAmountExcludingVatNoFreight().multiply(p).setScale(this.amountAccuracy, this.ROUNDING);
         }

         outboundDetail.setAmount(amount);
         outboundDetail.setAmountExcludingVat(amountExcludingVat);
         outboundDetail.setInputVat(amount.subtract(amountExcludingVat));
         outboundDetail.setUnitPrice(amount.divide(outboundDetail.getMete(), 12, RoundingMode.HALF_UP));
         outboundDetail.setUnitPriceExcludingVat(amountExcludingVat.divide(outboundDetail.getMete(), 12, RoundingMode.HALF_UP));
         outboundDetail.setAmountNoFreight(amountNoFreight);
         outboundDetail.setAmountExcludingVatNoFreight(amountExcludingVatNoFreight);
         outboundDetail.setInputVatNoFreight(amountNoFreight.subtract(amountExcludingVatNoFreight));
         outboundDetail.setUnitPriceNoFreight(amountNoFreight.divide(outboundDetail.getMete(), 12, RoundingMode.HALF_UP));
         outboundDetail.setUnitPriceExcludingVatNoFreight(amountExcludingVatNoFreight.divide(outboundDetail.getMete(), 12, RoundingMode.HALF_UP));
         this.weightedAveragePriceService
            .createMonthWAP(
               InboundDetail.builder()
                  .mete(outboundDetail.getMete().negate())
                  .quantity(outboundDetail.getQuantity().negate())
                  .projectId(materialInventory.getProjectId())
                  .accountingUnit(materialInventory.getAccountingUnit())
                  .unitPrice(amount.divide(outboundDetail.getMete(), 12, RoundingMode.HALF_UP))
                  .unitPriceExcludingVat(amountExcludingVat.divide(outboundDetail.getMete(), 12, RoundingMode.HALF_UP))
                  .amount(amount.negate())
                  .amountExcludingVat(amountExcludingVat.negate())
                  .unitPriceNoFreight(amountNoFreight.divide(outboundDetail.getMete(), 12, RoundingMode.HALF_UP))
                  .unitPriceExcludingVatNoFreight(amountExcludingVatNoFreight.divide(outboundDetail.getMete(), 12, RoundingMode.HALF_UP))
                  .amountNoFreight(amountNoFreight.negate())
                  .amountExcludingVatNoFreight(amountExcludingVatNoFreight.negate())
                  .invoiceType(materialInventory.getInvoiceType())
                  .build(),
               materialInventory,
               outbound.getId(),
               outbound.getSerialNumber(),
               30
            );
         materialInventory.setQuantity(materialInventory.getQuantity().subtract(outboundDetail.getQuantity()));
         materialInventory.setMete(materialInventory.getMete().subtract(outboundDetail.getMete()));
         if (materialInventory.getMete().compareTo(BigDecimal.ZERO) == 0) {
            this.materialInventoryMapper.deleteById(materialInventory);
         } else {
            this.materialInventoryMapper.updateById(materialInventory);
         }

         this.wmsUtil
            .setInventoryUse(
               materialInventory,
               outboundDetail.getQuantity(),
               outboundDetail.getMete(),
               ReceiptTypeEnum.OUTBOUND,
               outbound.getId(),
               outbound.getSerialNumber(),
               2,
               true
            );
         this.warningService.updateStatus(materialInventory, 2);
         this.moveOutboundDetailMapper.updateById(outboundDetail);
      }

      return this.baseMapper.updateById(outbound) == 1;
   }

   private void saveStatisticsInbound(Outbound outbound, MoveOutboundDetail outboundDetail, MaterialInventory materialInventory, Long statisticsId) {
      StatisticsInbound si = BeanUtil.copy(materialInventory, StatisticsInbound.class, "createTime");
      si.setMaterialInventoryId(materialInventory.getId());
      Integer receiptType = null;
      if (outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.PRODUCTION_USE.getType())) {
         receiptType = ReceiptTypeEnum.OUTBOUND.getType();
      } else if (outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.CONSTRUCTION_SITE_USE.getType())) {
         receiptType = ReceiptTypeEnum.CONSTRUCTION_SITE_USE.getType();
      } else if (outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.FOR_SALE.getType())) {
         receiptType = ReceiptTypeEnum.FOR_SALE.getType();
      } else if (outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.TEMPORARY_LOAN.getType())) {
         receiptType = ReceiptTypeEnum.BORROW.getType();
      } else if (outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.OUTSOURCING_RAW_MATERIALS.getType())) {
         receiptType = ReceiptTypeEnum.OUTSOURCING.getType();
      } else if (outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.SCRAPS.getType())) {
         receiptType = ReceiptTypeEnum.SCRAPS.getType();
      } else {
         Preconditions.checkArgument(false, "未知出库类型");
      }

      si.setReceiptType(receiptType);
      si.setReceiptId(outbound.getId());
      si.setReceiptSerialNumber(outbound.getSerialNumber());
      si.setStatisticsId(statisticsId);
      si.setMete(BigDecimal.ZERO.subtract(outboundDetail.getMete()));
      if (materialInventory.getQuantity() != null) {
         si.setQuantity(BigDecimal.ZERO.subtract(outboundDetail.getQuantity()));
      }

      si.setUnitPrice(outboundDetail.getUnitPrice());
      si.setUnitPriceExcludingVat(outboundDetail.getUnitPriceExcludingVat());
      si.setAmount(BigDecimal.ZERO.subtract(outboundDetail.getAmount()));
      si.setAmountExcludingVat(BigDecimal.ZERO.subtract(outboundDetail.getAmountExcludingVat()));
      si.setUnitPriceNoFreight(outboundDetail.getUnitPriceNoFreight());
      si.setUnitPriceExcludingVatNoFreight(outboundDetail.getUnitPriceExcludingVatNoFreight());
      si.setAmountNoFreight(BigDecimal.ZERO.subtract(outboundDetail.getAmountNoFreight()));
      si.setAmountExcludingVatNoFreight(BigDecimal.ZERO.subtract(outboundDetail.getAmountExcludingVatNoFreight()));
      si.setRealTime(LocalDateTime.now());
      this.statisticsInboundMapper.insert(si);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public synchronized Boolean saveForSaleOutbound(SteelPlateOutboundDTOParam param) {
      param.setBoolSubmitCheck(false);
      param.setReviewStatus(ReviewStatusEnum.NOT_SUBMITTED.getType());
      Outbound outbound = this.saveOutboundNew(param, null);
      this.outboundService.updateById(outbound);
      WmsForSale wmsForSale = this.saveForSale(param, null, outbound);
      this.wmsForSaleService.save(wmsForSale);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public synchronized Boolean submitForSaleOutbound(SteelPlateOutboundDTOParam param) {
      SecurityUser currentUser = UserUtil.getCurrentUser();
      param.setBoolSubmitCheck(true);
      param.setReviewStatus(ReviewStatusEnum.AUDITING.getType());
      Outbound outbound = this.saveOutboundNew(param, null);
      this.outboundService.updateById(outbound);
      WmsForSale wmsForSale = this.saveForSale(param, null, outbound);
      this.wmsForSaleService.save(wmsForSale);
      WmsApproveRecord wmsApproveRecord = this.submitCheck(outbound, OutboundTypeEnum.FOR_SALE.getType());
      outbound.setApproveRecordId(wmsApproveRecord.getId());
      outbound.setReviewStatus(ReviewStatusEnum.AUDITING.getType());
      if (wmsApproveRecord.getStatus().equals(ApproveRecordStatusEnum.END.getType())) {
         OutboundDTOParam outboundDTOParam = cn.hutool.core.bean.BeanUtil.toBean(outbound, OutboundDTOParam.class);
         List<MoveOutboundDetail> moveOutboundDetails = this.moveOutboundDetailMapper
            .selectList((Wrapper<MoveOutboundDetail>)new LambdaQueryWrapper<MoveOutboundDetail>().eq(MoveOutboundDetail::getOutboundId, outbound.getId()));
         List<OutboundDetailDTO> outboundDetailDTOS = cn.hutool.core.bean.BeanUtil.copyToList(moveOutboundDetails, OutboundDetailDTO.class);
         outboundDTOParam.setList(outboundDetailDTOS);
         outbound = this.forSalePassed(outboundDTOParam, outbound, null, null);
         this.reviewForSale(outbound, currentUser, ReviewStatusEnum.REVIEWED.getType());
         outbound.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
      }

      return this.outboundService.updateById(outbound);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public synchronized Boolean BatchSaveForSale(BatchOutboundDTOParam param) {
      SteelPlateOutboundDTOParam copy = BeanUtil.copy(param, SteelPlateOutboundDTOParam.class);
      copy.setBoolSubmitCheck(false);
      copy.setReviewStatus(ReviewStatusEnum.NOT_SUBMITTED.getType());
      Outbound outbound = null;
      WmsForSale wmsForSale = null;
      String serialNumber = null;

      for (BatchOutboundDetailDTOParam detailDTOParam : param.getList()) {
         BeanUtil.copy(detailDTOParam, copy);
         copy.setMaterialId(detailDTOParam.getId());
         copy.setMaterialOutboundMode(1);
         copy.setSerialNumber(serialNumber);
         outbound = this.saveOutboundNew(copy, outbound);
         this.baseMapper.updateById(outbound);
         if (ObjectUtil.isEmpty(serialNumber)) {
            serialNumber = outbound.getSerialNumber();
         }

         wmsForSale = this.saveForSale(copy, wmsForSale, outbound);
      }

      this.wmsForSaleService.save(wmsForSale);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public synchronized Boolean BatchSubmitForSale(BatchOutboundDTOParam param) {
      SecurityUser currentUser = UserUtil.getCurrentUser();
      SteelPlateOutboundDTOParam copy = BeanUtil.copy(param, SteelPlateOutboundDTOParam.class);
      copy.setBoolSubmitCheck(true);
      copy.setReviewStatus(ReviewStatusEnum.AUDITING.getType());
      Outbound outbound = null;
      WmsForSale wmsForSale = null;
      String serialNumber = null;

      for (BatchOutboundDetailDTOParam detailDTOParam : param.getList()) {
         BeanUtil.copy(detailDTOParam, copy);
         copy.setMaterialId(detailDTOParam.getId());
         copy.setMaterialOutboundMode(1);
         copy.setSerialNumber(serialNumber);
         outbound = this.saveOutboundNew(copy, outbound);
         if (ObjectUtil.isEmpty(serialNumber)) {
            serialNumber = outbound.getSerialNumber();
         }

         wmsForSale = this.saveForSale(copy, wmsForSale, outbound);
      }

      this.wmsForSaleService.save(wmsForSale);
      WmsApproveRecord wmsApproveRecord = this.submitCheck(outbound, OutboundTypeEnum.FOR_SALE.getType());
      outbound.setApproveRecordId(wmsApproveRecord.getId());
      outbound.setReviewStatus(ReviewStatusEnum.AUDITING.getType());
      if (wmsApproveRecord.getStatus().equals(ApproveRecordStatusEnum.END.getType())) {
         OutboundDTOParam outboundDTOParam = cn.hutool.core.bean.BeanUtil.toBean(outbound, OutboundDTOParam.class);
         List<MoveOutboundDetail> moveOutboundDetails = this.moveOutboundDetailMapper
            .selectList((Wrapper<MoveOutboundDetail>)new LambdaQueryWrapper<MoveOutboundDetail>().eq(MoveOutboundDetail::getOutboundId, outbound.getId()));
         List<OutboundDetailDTO> outboundDetailDTOS = cn.hutool.core.bean.BeanUtil.copyToList(moveOutboundDetails, OutboundDetailDTO.class);
         outboundDTOParam.setList(outboundDetailDTOS);
         outbound = this.forSalePassed(outboundDTOParam, outbound, null, null);
         this.reviewForSale(outbound, currentUser, ReviewStatusEnum.REVIEWED.getType());
         outbound.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
      }

      return this.outboundService.updateById(outbound);
   }

   private Outbound saveOutboundNew(SteelPlateOutboundDTOParam param, Outbound outbound) {
      Preconditions.checkArgument(param.getQuantity() != null && param.getQuantity().signum() > 0, "出库数量必须大于0");
      MaterialInventory materialInventory = this.materialInventoryMapper.selectById(param.getMaterialId());
      Preconditions.checkArgument(materialInventory != null, "仓库中不存在该物料");
      Measure measure = this.measureMapper
         .selectOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, materialInventory.getClassifyId()));
      SubjectMeasureDTO subjectMeasureDTO = this.measureService.measureListById(materialInventory.getClassifyId());
      String accountingUnit = subjectMeasureDTO.getAccountingUnit();
      Integer accountingPrecision = subjectMeasureDTO.getAccountingPrecision();
      BigDecimal UnitsPrecision = UnitsPrecisionEnum.getByName(subjectMeasureDTO.getAccountingUnit());
      BasicOutbound outboundBasicConf = this.basicConfigService.getOutboundBasicConf();
      Preconditions.checkArgument((OutboundTypeEnum.FOR_SALE.getType() & outboundBasicConf.getOutboundType()) > 0, "出库配置未选择对外出售功能，出库失败!!");
      if (ObjectUtil.isEmpty(outbound)) {
         if (!param.getBoolSubmitCheck() || ObjectUtil.isNotEmpty(param.getSerialNumber())) {
            outbound = this.baseMapper
               .selectOne(
                  (((((Wrappers.<Outbound>lambdaQuery()
                                    .eq(Outbound::getApplicantId, UserUtil.getCurrentUserId()))
                                 .eq(param.getConvertId() != null, Outbound::getConvertId, param.getConvertId()))
                              .eq(param.getBoolPartyA() != null, Outbound::getBoolPartyA, param.getBoolPartyA()))
                           .eq(Outbound::getOutboundTypeSelection, param.getOutboundTypeSelection()))
                        .eq(Outbound::getReviewStatus, ReviewStatusEnum.NOT_SUBMITTED.getType()))
                     .eq(param.getSerialNumber() != null, Outbound::getSerialNumber, param.getSerialNumber())
               );
         }

         if (ObjectUtil.isEmpty(outbound)) {
            outbound = Outbound.builder()
               .applicantId(UserUtil.getCurrentUserId())
               .applicantName(UserUtil.getCurrentName())
               .userUpdateTime(LocalDateTime.now())
               .outboundStartTime(LocalDateTime.now())
               .outboundEndTime(LocalDateTime.now())
               .convertId(param.getConvertId())
               .boolPartyA(param.getBoolPartyA())
               .outboundTypeSelection(param.getOutboundTypeSelection())
               .reviewStatus(param.getReviewStatus())
               .build();
            String serviceNumber = this.numberConfigService.getNumber(NumberTypeEnum.FOR_SALE, this.baseMapper.getCount(LocalDateTime.now()));
            outbound.setApplicationSn(serviceNumber);
            this.baseMapper.insert(outbound);
         }
      }

      MoveOutboundDetail moveOutboundDetail = MoveOutboundDetail.builder()
         .warehouseId(materialInventory.getWarehouseId())
         .materialIsWhole(materialInventory.getMaterialIsWhole())
         .workshopId(param.getWorkshopId())
         .sourceWorkshopId(materialInventory.getWorkshopId())
         .materialInventoryId(materialInventory.getId())
         .outboundId(outbound.getId())
         .basicClass(materialInventory.getBasicClass())
         .classifyId(materialInventory.getClassifyId())
         .specification(materialInventory.getSpecification())
         .sourceProjectId(materialInventory.getProjectId())
         .sourceMonomerId(materialInventory.getMonomerId())
         .sourceAreaId(materialInventory.getAreaId())
         .thickness(materialInventory.getThickness())
         .theoryThickness(materialInventory.getTheoryThickness())
         .heatNoAndBatchNo(materialInventory.getHeatNoAndBatchNo())
         .brand(materialInventory.getBrand())
         .outboundTime(param.getOutboundTime() != null ? param.getOutboundTime() : LocalDateTime.now())
         .color(materialInventory.getColor())
         .recipientId(param.getRecipientId())
         .outboundMode(param.getMaterialOutboundMode())
         .remark(param.getRemark())
         .boolPartyA(materialInventory.getBoolPartyA())
         .taxRate(materialInventory.getTaxRate())
         .invoiceType(materialInventory.getInvoiceType())
         .standardId(materialInventory.getStandardId())
         .standardName(materialInventory.getStandardName())
         .materialSn(materialInventory.getSerialNumber())
         .workshopId(param.getWorkshopId())
         .outboundAddress(param.getOutboundAddress())
         .outboundTypeSelection(param.getOutboundTypeSelection())
         .build();
      MaterialFreeze materialFreeze = this.materialFreezeService
         .getOne((Wrapper<MaterialFreeze>)Wrappers.<MaterialFreeze>lambdaQuery().eq(MaterialFreeze::getMaterialInventoryId, materialInventory.getId()));
      MaterialFreezeRecord freezeRecord = null;
      Set<Integer> freezeTypes = null;
      BigDecimal freezeTotalMete;
      BigDecimal freezeTotalQuantity;
      if (materialFreeze != null) {
         freezeTotalMete = materialFreeze.getTotalMete();
         freezeTotalQuantity = materialFreeze.getTotalQuantity();
         freezeTypes = Arrays.stream(materialFreeze.getTotalFreezeTypes().split(",")).map(Integer::parseInt).collect(Collectors.toSet());
         if (freezeTypes.contains(MaterialFreezeTypeEnum.REQUISITIONS.getType())) {
            freezeRecord = this.materialFreezeRecordMapper
               .selectOne(
                  (Wrapper<MaterialFreezeRecord>)((Wrappers.<MaterialFreezeRecord>lambdaQuery()
                           .eq(MaterialFreezeRecord::getMaterialFreezeId, materialFreeze.getId()))
                        .eq(MaterialFreezeRecord::getFreezeType, MaterialFreezeTypeEnum.REQUISITIONS.getType()))
                     .eq(MaterialFreezeRecord::getProjectId, param.getProjectId())
               );
            if (freezeRecord != null) {
               freezeTotalMete = freezeTotalMete.subtract(freezeRecord.getMete());
               if (materialFreeze.getTotalQuantity() != null) {
                  freezeTotalQuantity = freezeTotalQuantity.subtract(freezeRecord.getQuantity());
               }
            }
         }
      } else {
         freezeTotalMete = BigDecimal.ZERO;
         freezeTotalQuantity = BigDecimal.ZERO;
      }

      BigDecimal outMete = null;
      BigDecimal outQuantity = null;
      if (MaterialOutboundModeEnum.HALF.getType().equals(param.getMaterialOutboundMode())) {
         Preconditions.checkArgument(
            BasicClassEnum.checkIsSteel(materialInventory.getBasicClass()) && !BasicClassEnum.COLOR_ROLL.getType().equals(materialInventory.getBasicClass()),
            "该材料不能进行整料半出"
         );
         Preconditions.checkArgument(materialInventory.getQuantity().subtract(freezeTotalQuantity).compareTo(param.getQuantity()) >= 0, "当前可出库数量不足");
         moveOutboundDetail.setQuantity(param.getQuantity());
         moveOutboundDetail.setHalfMode(HalfModeEnum.LENGTH.getType());
         if (BasicClassEnum.SECTION_STEEL.getType().equals(materialInventory.getBasicClass())) {
            Preconditions.checkArgument(!HalfModeEnum.WIDTH.getType().equals(param.getHalfMode()), "型材半出只能按长度截取");
            Preconditions.checkArgument(param.getHalfSize().compareTo(materialInventory.getLength()) < 0, "截取长度大于或等于型材定尺长度,请选择整料整出");
            moveOutboundDetail.setMete(
               CommonUtil.getStockOutboundMete(param.getQuantity(), materialInventory.getQuantity().subtract(freezeTotalQuantity), materialInventory.getMete().subtract(freezeTotalMete))
                  .multiply(param.getHalfSize()).divide(materialInventory.getLength(), 8, RoundingMode.DOWN)
            );
            moveOutboundDetail.setLength(param.getHalfSize());
         } else {
            moveOutboundDetail.setHalfMode(param.getHalfMode());
            if (HalfModeEnum.LENGTH.getType().equals(param.getHalfMode())) {
               Preconditions.checkArgument(param.getHalfSize().compareTo(materialInventory.getLength()) < 0, "截取长度大于或等于钢板长度,请选择整料整出");
               moveOutboundDetail.setLength(param.getHalfSize());
               moveOutboundDetail.setWidth(materialInventory.getWidth());
               moveOutboundDetail.setMete(
               CommonUtil.getStockOutboundMete(param.getQuantity(), materialInventory.getQuantity().subtract(freezeTotalQuantity), materialInventory.getMete().subtract(freezeTotalMete))
                  .multiply(param.getHalfSize()).divide(materialInventory.getLength(), 8, RoundingMode.DOWN)
            );
            } else {
               Preconditions.checkArgument(param.getHalfSize().compareTo(materialInventory.getWidth()) < 0, "截取宽度大于或等于钢板宽度,请选择整料整出");
               moveOutboundDetail.setLength(materialInventory.getLength());
               moveOutboundDetail.setWidth(param.getHalfSize());
               moveOutboundDetail.setMete(
               CommonUtil.getStockOutboundMete(param.getQuantity(), materialInventory.getQuantity().subtract(freezeTotalQuantity), materialInventory.getMete().subtract(freezeTotalMete))
                  .multiply(param.getHalfSize()).divide(materialInventory.getWidth(), 8, RoundingMode.DOWN)
            );
            }
         }

         Preconditions.checkArgument(moveOutboundDetail.getMete().compareTo(BigDecimal.valueOf(1000L)) > 0, "出库失败,出库量必须大于1kg");
         moveOutboundDetail.setOutboundType(MaterialOutboundModeEnum.HALF.getType());
         moveOutboundDetail.setHalfSize(param.getHalfSize());
         this.checkHalfOutputDimensions(moveOutboundDetail);
         outMete = CommonUtil.getStockOutboundMete(param.getQuantity(), materialInventory.getQuantity().subtract(freezeTotalQuantity), materialInventory.getMete().subtract(freezeTotalMete));
      } else {
         moveOutboundDetail.setOutboundType(MaterialOutboundModeEnum.WHOLE.getType());
         BigDecimal precision = UnitsPrecisionEnum.getByName(measure.getAccountingUnit());
         MeteAndQuantity meteAndQuantitySend = new MeteAndQuantity();
         meteAndQuantitySend.setSendQuantity(param.getQuantity());
         MeteAndQuantity meteAndQuantity = this.checkInventory(
            materialInventory.getBasicClass(),
            materialInventory.getClassifyId(),
            meteAndQuantitySend,
            materialInventory.getQuantity(),
            materialInventory.getMete(),
            freezeTotalQuantity,
            freezeTotalMete,
            subjectMeasureDTO,
            measure
         );
         BigDecimal sendQuantity = meteAndQuantity.getSendQuantity();
         if (BasicClassEnum.checkNotSteel(materialInventory.getBasicClass())) {
            if (measure.getOutboundUnitType() == null) {
               measure = this.getMeasured(materialInventory.getClassifyId());
            }

            if (MeasureTypeEnum.MEASURE.getType().equals(measure.getOutboundUnitType())) {
               moveOutboundDetail.setMete(CommonUtil.getStockOutboundMete(
                  sendQuantity, materialInventory.getQuantity().subtract(freezeTotalQuantity), materialInventory.getMete().subtract(freezeTotalMete)
               ));
               moveOutboundDetail.setQuantity(sendQuantity);
            } else {
               moveOutboundDetail.setMete(sendQuantity);
               if (materialInventory.getQuantity() != null) {
                  moveOutboundDetail.setQuantity(sendQuantity.divide(materialInventory.getUnitNet(), 8, this.ROUNDING));
               }
            }
         } else if (BasicClassEnum.STEEL_PLATE.getType().equals(materialInventory.getBasicClass())) {
            moveOutboundDetail.setQuantity(sendQuantity);
            BigDecimal outboundMete1 = CommonUtil.getOutboundMete1(
               UnitsPrecision, sendQuantity, materialInventory, freezeTotalMete, freezeTotalQuantity, accountingPrecision
            );
            moveOutboundDetail.setMete(outboundMete1);
            moveOutboundDetail.setLength(materialInventory.getLength());
            moveOutboundDetail.setWidth(materialInventory.getWidth());
         } else if (BasicClassEnum.SECTION_STEEL.getType().equals(materialInventory.getBasicClass())) {
            BigDecimal outboundMete1 = CommonUtil.getOutboundMete1(
               UnitsPrecision, sendQuantity, materialInventory, freezeTotalMete, freezeTotalQuantity, accountingPrecision
            );
            moveOutboundDetail.setMete(outboundMete1);
            moveOutboundDetail.setLength(materialInventory.getLength());
            moveOutboundDetail.setQuantity(sendQuantity);
         } else if (BasicClassEnum.COLOR_ROLL.getType().equals(materialInventory.getBasicClass())) {
            BigDecimal outboundMete1 = CommonUtil.getOutboundMete1(
               UnitsPrecision, sendQuantity, materialInventory, freezeTotalMete, freezeTotalQuantity, accountingPrecision
            );
            moveOutboundDetail.setMete(outboundMete1);
            Preconditions.checkArgument(moveOutboundDetail.getMete().compareTo(BigDecimal.valueOf(1000L)) > 0, "出库失败,出库量必须大于1kg");
            moveOutboundDetail.setQuantity(sendQuantity);
            moveOutboundDetail.setWidth(materialInventory.getWidth());
         }

         outMete = moveOutboundDetail.getMete();
      }

      this.moveOutboundDetailMapper.insert(moveOutboundDetail);
      outbound.setContainBasicClass(
         outbound.getContainBasicClass() != null ? outbound.getContainBasicClass() | moveOutboundDetail.getBasicClass() : moveOutboundDetail.getBasicClass()
      );
      MaterialFreezeRecord materialFreezeRecord = MaterialFreezeRecord.builder()
         .freezeDetailId(moveOutboundDetail.getId())
         .freezeType(MaterialFreezeTypeEnum.FOR_SALE.getType())
         .freezeSourceId(outbound.getId())
         .freezeSourceSn(outbound.getApplicationSn())
         .operatorId(UserUtil.getCurrentUserId())
         .operatorName(UserUtil.getCurrentName())
         .mete(outMete != null ? outMete : moveOutboundDetail.getMete())
         .quantity(outQuantity != null ? outQuantity : moveOutboundDetail.getQuantity())
         .boolBatten(outQuantity != null)
         .projectId(moveOutboundDetail.getProjectId())
         .frozenTime(LocalDateTime.now())
         .outboundUnitType(measure.getOutboundUnitType())
         .build();
      if (materialFreeze == null) {
         materialFreeze = BeanUtil.copy(materialInventory, MaterialFreeze.class, "createTime");
         materialFreeze.setTotalQuantity(outQuantity != null ? outQuantity : moveOutboundDetail.getQuantity());
         materialFreeze.setTotalMete(outMete);
         materialFreeze.setTotalFreezeTypes(MaterialFreezeTypeEnum.FOR_SALE.getType() + "");
         materialFreeze.setMaterialInventoryId(materialInventory.getId());
         this.materialFreezeService.save(materialFreeze);
      } else {
         if (freezeRecord != null) {
            if (freezeRecord.getMete().compareTo(moveOutboundDetail.getMete()) < 0) {
               materialFreezeRecord.setApplyPurchaseQuantity(freezeRecord.getQuantity());
               materialFreezeRecord.setApplyPurchaseMete(freezeRecord.getMete());
            } else {
               materialFreezeRecord.setApplyPurchaseQuantity(moveOutboundDetail.getQuantity());
               materialFreezeRecord.setApplyPurchaseMete(moveOutboundDetail.getMete());
            }

            if (freezeRecord.getQuantity() != null) {
               freezeRecord.setQuantity(freezeRecord.getQuantity().subtract(moveOutboundDetail.getQuantity()));
            }

            freezeRecord.setMete(freezeRecord.getMete().subtract(moveOutboundDetail.getMete()));
            if (freezeRecord.getMete().compareTo(BigDecimal.ZERO) <= 0) {
               if (freezeRecord.getMete().compareTo(BigDecimal.ZERO) != 0) {
                  materialFreeze.setTotalQuantity(
                     freezeRecord.getQuantity() != null ? materialFreeze.getTotalQuantity().add(freezeRecord.getQuantity().negate()) : null
                  );
                  materialFreeze.setTotalMete(materialFreeze.getTotalMete().add(freezeRecord.getMete().negate()));
               }

               this.materialFreezeRecordMapper.deleteById(freezeRecord);
            } else {
               this.materialFreezeRecordMapper.updateById(freezeRecord);
            }

            materialFreezeRecord.setBoolChangeOutbound(true);
            materialFreezeRecord.setApplyPurchaseId(freezeRecord.getFreezeSourceId());
            materialFreezeRecord.setApplyPurchaseDetailId(freezeRecord.getFreezeDetailId());
            materialFreezeRecord.setApplyPurchaseSn(freezeRecord.getFreezeSourceSn());
         } else {
            if (moveOutboundDetail.getQuantity() != null) {
               materialFreeze.setTotalQuantity(
                  outQuantity != null
                     ? materialFreeze.getTotalQuantity().add(outQuantity)
                     : materialFreeze.getTotalQuantity().add(moveOutboundDetail.getQuantity())
               );
            }

            freezeTypes.add(MaterialFreezeTypeEnum.OUTBOUND.getType());
            materialFreeze.setTotalFreezeTypes(StrUtil.join(",", freezeTypes));
            materialFreeze.setTotalMete(materialFreeze.getTotalMete().add(outMete));
         }

         this.materialFreezeService.updateById(materialFreeze);
      }

      materialFreezeRecord.setMaterialFreezeId(materialFreeze.getId());
      this.materialFreezeRecordMapper.insert(materialFreezeRecord);
      if (!materialInventory.getBoolHasFrozen()) {
         this.materialInventoryMapper.updateBoolHasFrozen(materialInventory.getId(), true);
      }

      return outbound;
   }

   private WmsForSale saveForSale(SteelPlateOutboundDTOParam param, WmsForSale wmsForSale, Outbound outbound) {
      if (ObjectUtil.isEmpty(wmsForSale)) {
         String serialNumber = "";
         NumberConfig numberConfig = this.numberConfigService
            .getOne((Wrapper<NumberConfig>)new LambdaQueryWrapper<NumberConfig>().eq(NumberConfig::getType, NumberTypeEnum.FOR_SALE.getType()));

         List<WmsForSale> wmsForSales;
         do {
            serialNumber = this.createForSaleSerialNumber("for_sale_operation", numberConfig.getCode());
            wmsForSales = this.wmsForSaleService.list((Wrapper<WmsForSale>)new LambdaQueryWrapper<WmsForSale>().eq(WmsForSale::getSerialNumber, serialNumber));
         } while (!CollectionUtils.isEmpty(wmsForSales));

         wmsForSale = WmsForSale.builder()
            .serialNumber(serialNumber)
            .branchCompanyId(param.getBranchCompanyId())
            .invoiceType(param.getInvoiceType())
            .taxRate(param.getTaxRate())
            .sellAmount(BigDecimal.ZERO)
            .sellAmountExcludingVat(BigDecimal.ZERO)
            .sellInputVat(param.getInvoiceType().equals(InvoiceTypeEnum.SPECIAL.getType()) ? BigDecimal.ZERO : null)
            .outboundId(outbound.getId())
            .outboundSerialNumber(outbound.getSerialNumber())
            .branchCompanyId(param.getBranchCompanyId())
            .systemMete(BigDecimal.ZERO)
            .inputMete(BigDecimal.ZERO)
            .differenceMete(BigDecimal.ZERO)
            .purchaser(param.getPurchaser())
            .build();
      }

      MoveOutboundDetail moveOutboundDetail = this.moveOutboundDetailMapper
         .selectOne(
            (Wrapper<MoveOutboundDetail>)((new LambdaQueryWrapper<MoveOutboundDetail>()
                     .eq(MoveOutboundDetail::getOutboundId, outbound.getId()))
                  .orderByDesc(MoveOutboundDetail::getId))
               .last("limit 1")
         );
      WmsForSaleDetail wmsForSaleDetail = WmsForSaleDetail.builder()
         .forSaleSerialNumber(wmsForSale.getSerialNumber())
         .quantity(moveOutboundDetail.getQuantity())
         .systemMete(moveOutboundDetail.getMete())
         .inputMete(param.getInputMete())
         .weightMeasurementMode(param.getWeightMeasurementMode())
         .sellUnitPrice(param.getSellUnitPrice())
         .sellAmount(param.getSellAmount())
         .outboundDetailId(moveOutboundDetail.getId())
         .branchCompanyId(wmsForSale.getBranchCompanyId())
         .build();
      wmsForSaleDetail.setCreateTime(LocalDateTime.now());
      if (wmsForSale.getInvoiceType().equals(InvoiceTypeEnum.SPECIAL.getType())) {
         BigDecimal value = wmsForSale.getTaxRate().divide(HUNDRED).add(BigDecimal.ONE);
         wmsForSaleDetail.setSellAmountExcludingVat(wmsForSaleDetail.getSellAmount().divide(value, 8, RoundingMode.HALF_UP));
         wmsForSaleDetail.setSellUnitPriceExcludingVat(wmsForSaleDetail.getSellUnitPrice().divide(value, 8, RoundingMode.HALF_UP));
         wmsForSaleDetail.setSellInputVat(wmsForSaleDetail.getSellAmount().subtract(wmsForSaleDetail.getSellAmountExcludingVat()));
      } else {
         wmsForSaleDetail.setSellAmountExcludingVat(wmsForSaleDetail.getSellAmount());
         wmsForSaleDetail.setSellUnitPriceExcludingVat(wmsForSaleDetail.getSellUnitPrice());
      }

      wmsForSaleDetail.setDifferenceMete(wmsForSaleDetail.getInputMete().subtract(wmsForSaleDetail.getSystemMete()));
      this.wmsForSaleDetailService.save(wmsForSaleDetail);
      wmsForSale.setSellAmount(wmsForSale.getSellAmount().add(wmsForSaleDetail.getSellAmount()));
      wmsForSale.setSellAmountExcludingVat(wmsForSale.getSellAmountExcludingVat().add(wmsForSaleDetail.getSellAmountExcludingVat()));
      wmsForSale.setSystemMete(wmsForSale.getSystemMete().add(wmsForSaleDetail.getSystemMete()));
      wmsForSale.setInputMete(wmsForSale.getInputMete().add(wmsForSaleDetail.getInputMete()));
      wmsForSale.setDifferenceMete(wmsForSale.getInputMete().subtract(wmsForSale.getSystemMete()));
      if (wmsForSale.getInvoiceType().equals(InvoiceTypeEnum.SPECIAL.getType())) {
         wmsForSale.setSellInputVat(wmsForSale.getSellInputVat().add(wmsForSaleDetail.getSellInputVat()));
      }

      return wmsForSale;
   }

   private WmsApproveRecord submitCheck(Outbound outbound, Integer outboundType) {
      MountMessageDTO mountMessageDTO = new MountMessageDTO();
      List<Integer> outboundTypeList = new ArrayList<>();
      outboundTypeList.add(outboundType);
      mountMessageDTO.setOutboundType(outboundTypeList);
      List<Integer> nameStr2 = BasicClassEnum.getNameStr2(outbound.getContainBasicClass());
      Preconditions.checkArgument(nameStr2.size() == 1, "当前出库单存在多种材料类型的物料，请删除多余的物料，仅留一种材料类型的物料才可提交成功");
      List<Integer> materialType = new ArrayList<>();
      materialType.add(outbound.getContainBasicClass());
      mountMessageDTO.setMaterialType(materialType);
      return this.wmsApproveRecordService
         .createRecord(
            outbound.getId(),
            outbound.getApplicationSn(),
            ApproveProcessTypeEnumV2.SELF_BUYING_OUT.getType(),
            null,
            null,
            null,
            false,
            mountMessageDTO,
            null,
            null
         );
   }

   @Override
   public Outbound forSalePassed(OutboundDTOParam param, Outbound outbound, Integer decision, String opinion) {
      String currentName;
      Long currentUserId;
      if (param.getDefaultId() != null) {
         currentName = param.getDefaultName();
         currentUserId = param.getDefaultId();
      } else {
         currentName = UserUtil.getCurrentName();
         currentUserId = UserUtil.getCurrentUserId();
      }

      LocalDateTime dateTime = LocalDateTime.now();
      if (ObjectUtil.isEmpty(outbound)) {
         outbound = this.baseMapper.selectById(param.getId());
      }

      Preconditions.checkArgument(outbound != null, "出库单不存在,请核对后操作.");
      Preconditions.checkArgument(OutboundStatusEnum.AUDITING.getType().equals(outbound.getReviewStatus()), "出库单已审核,请核对后操作");
      List<MoveOutboundDetail> details = this.moveOutboundDetailMapper
         .selectList((Wrapper<MoveOutboundDetail>)Wrappers.<MoveOutboundDetail>lambdaQuery().eq(MoveOutboundDetail::getOutboundId, outbound.getId()));
      Preconditions.checkArgument(details.size() == param.getList().size(), "出库详情变更,请刷新后重试.");
      outbound.setReviewerId(currentUserId);
      outbound.setReviewerName(currentName);
      outbound.setReviewStatus(OutboundStatusEnum.REVIEWED.getType());
      outbound.setReviewTime(dateTime);
      outbound.setOutboundTime(dateTime);
      outbound.setUserUpdateTime(dateTime);
      String serviceNumber = this.numberConfigService.getNumber(NumberTypeEnum.FOR_SALE_REVIEW, this.baseMapper.getCount(LocalDateTime.now()));
      outbound.setSerialNumber(serviceNumber);
      outbound.setOutboundStartTime(null);
      outbound.setOutboundEndTime(null);
      WeightedPriceConf weightedPriceConf = JSON.parseObject(
         this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置")).getValue(), WeightedPriceConf.class
      );
      WeightedExecutionPriceConf weightedExecutionPriceConf = JSON.parseObject(
         this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权执行方式配置")).getValue(),
         WeightedExecutionPriceConf.class
      );
      this.queryUtilService.getMaterialInventorys(outbound, details, currentName, currentUserId);

      for (OutboundDetailDTO detailDTO : param.getList()) {
         MoveOutboundDetail outboundDetail = this.moveOutboundDetailMapper.selectById(detailDTO.getId());
         WmsForSaleDetail wmsForSaleDetail = this.wmsForSaleDetailService
            .getOne((Wrapper<WmsForSaleDetail>)new LambdaQueryWrapper<WmsForSaleDetail>().eq(WmsForSaleDetail::getOutboundDetailId, outboundDetail.getId()).exists(WmsForSaleDetailMapper.OUTBOUND_PARENT_EXISTS_SQL));
         MaterialInventory materialInventory = this.materialInventoryMapper.selectById(outboundDetail.getMaterialInventoryId());
         Measure measure = this.measureMapper
            .selectOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, materialInventory.getClassifyId()));
         String accountingUnit = measure.getAccountingUnit();
         Integer accountingPrecision = measure.getAccountingPrecision();
         BigDecimal unitsPrecision = UnitsPrecisionEnum.getByName(measure.getAccountingUnit());
         MonthWeightedAveragePrice wap = this.weightedAveragePriceService.getPrice(materialInventory);
         outboundDetail.setWapId(wap.getId());
         if (outboundDetail.getOutboundTime() == null) {
            Preconditions.checkArgument(detailDTO.getOutboundTime() != null, "请设置出库时间");
            outboundDetail.setOutboundTime(detailDTO.getOutboundTime());
            if (outbound.getOutboundStartTime() != null) {
               if (detailDTO.getOutboundTime().compareTo(outbound.getOutboundEndTime()) > 0) {
                  outbound.setOutboundEndTime(detailDTO.getOutboundTime());
               }

               if (detailDTO.getOutboundTime().compareTo(outbound.getOutboundStartTime()) < 0) {
                  outbound.setOutboundStartTime(detailDTO.getOutboundTime());
               }
            } else {
               outbound.setOutboundEndTime(detailDTO.getOutboundTime());
               outbound.setOutboundStartTime(detailDTO.getOutboundTime());
            }
         }

         this.materialFreezeService.materialUnfreeze(outbound.getId(), outboundDetail.getId(), MaterialFreezeTypeEnum.FOR_SALE.getType(), false);
         WasteConfig scrapDefinitionConf = this.basicConfigService.getSteelScrapDefinitionConf();
         materialInventory.setMete(materialInventory.getMete().subtract(outboundDetail.getMete()));
         materialInventory.setQuantity(outboundDetail.getQuantity() != null ? materialInventory.getQuantity().subtract(outboundDetail.getQuantity()) : null);
         if (BasicClassEnum.COLOR_ROLL.getType().equals(materialInventory.getBasicClass())) {
            if (materialInventory.getQuantity().compareTo(BigDecimal.ZERO) > 0) {
               if (scrapDefinitionConf.getSteelCoilMinLength().compareTo(materialInventory.getQuantity()) >= 0) {
                  Scrap scrap = BeanUtil.copy(materialInventory, Scrap.class, "createTime");
                  scrap.setQuantity(materialInventory.getQuantity());
                  scrap.setMete(materialInventory.getMete());
                  scrap.setWidth(materialInventory.getWidth());
                  scrap.setCreateTime(LocalDateTime.now());
                  this.scrapMapper.insert(scrap);
                  this.materialInventoryMapper.deleteById(materialInventory);
                  this.wmsUtil
                     .setInventoryUse(materialInventory, scrap.getQuantity(), scrap.getMete(), ReceiptTypeEnum.SCRAP_MATERIAL, scrap.getId(), null, 1, false);
               } else {
                  this.materialInventoryMapper.updateById(materialInventory);
               }
            } else {
               this.materialInventoryMapper.deleteById(materialInventory);
            }
         } else if (materialInventory.getMete().compareTo(BigDecimal.ZERO) == 0) {
            this.materialInventoryMapper.deleteById(materialInventory);
         } else {
            if (materialInventory.getQuantity() != null) {
               materialInventory.setUseStatus(materialInventory.getQuantity().compareTo(BigDecimal.ZERO) == 0);
            }

            this.materialInventoryMapper.updateById(materialInventory);
         }

         this.wmsUtil
            .setInventoryUse(
               materialInventory,
               outboundDetail.getQuantity(),
               outboundDetail.getMete(),
               ReceiptTypeEnum.OUTBOUND,
               outbound.getId(),
               outbound.getSerialNumber(),
               2,
               true
            );
         boolean isDel = false;
         MaterialInventory copy = BeanUtil.copy(materialInventory, MaterialInventory.class);
         copy.setMete(outboundDetail.getMete());
         PriceDTO price = this.queryUtilService.getPrice(weightedPriceConf, weightedExecutionPriceConf, copy, LocalDateTime.now());
         BigDecimal amount = price.getAmount();
         BigDecimal amountExcludingVat = price.getAmountExcludingVat();
         BigDecimal amountNoFreight = price.getAmountNoFreight();
         BigDecimal amountExcludingVatNoFreight = price.getAmountExcludingVatNoFreight();
         if (WeightedPriceEnum.SINGLE.getType().equals(weightedPriceConf.getWeightedType())) {
            wap.setAmount(wap.getAmount().subtract(amount));
            wap.setAmountExcludingVat(wap.getAmountExcludingVat().subtract(amountExcludingVat));
            wap.setAmountNoFreight(wap.getAmountNoFreight().subtract(amountNoFreight));
            wap.setAmountExcludingVatNoFreight(wap.getAmountExcludingVatNoFreight().subtract(amountExcludingVatNoFreight));
            if (wap.getMete().compareTo(BigDecimal.ZERO) == 0 && wap.getAmount().compareTo(BigDecimal.ZERO) == 0) {
               boolean var35 = true;
            } else {
               boolean var10000 = false;
            }
         } else {
            WholeWeightedAveragePrice wholeWAP = this.wholeWAPMapper.selectById(wap.getWholeWapId());
            wholeWAP.setMete(wholeWAP.getMete().subtract(outboundDetail.getMete()));
            wholeWAP.setAmount(wholeWAP.getAmount().subtract(amount));
            wholeWAP.setAmountExcludingVat(wholeWAP.getAmountExcludingVat().subtract(amountExcludingVat));
            wholeWAP.setAmountNoFreight(wholeWAP.getAmountNoFreight().subtract(amountNoFreight));
            wholeWAP.setAmountExcludingVatNoFreight(wholeWAP.getAmountExcludingVatNoFreight().subtract(amountExcludingVatNoFreight));
            if (wholeWAP.getQuantity() != null) {
               wholeWAP.setQuantity(wholeWAP.getQuantity().subtract(outboundDetail.getQuantity()));
            }

            this.wholeWAPMapper.updateById(wholeWAP);
            isDel = wap.getMete().compareTo(BigDecimal.ZERO) == 0;
         }

         wap.setMete(wap.getMete().subtract(outboundDetail.getMete()));
         if (wap.getQuantity() != null) {
            wap.setQuantity(wap.getQuantity().subtract(outboundDetail.getQuantity()));
         }

         this.monthWeightedAveragePriceMapper.updateById(wap);
         outboundDetail.setWapId(null);
         outboundDetail.setAmount(amount);
         outboundDetail.setAmountExcludingVat(amountExcludingVat);
         outboundDetail.setInputVat(amount.subtract(amountExcludingVat));
         outboundDetail.setUnitPrice(amount.divide(outboundDetail.getMete(), 12, RoundingMode.HALF_UP));
         outboundDetail.setUnitPriceExcludingVat(amountExcludingVat.divide(outboundDetail.getMete(), 12, RoundingMode.HALF_UP));
         wmsForSaleDetail.setAmount(amount);
         wmsForSaleDetail.setAmountExcludingVat(amountExcludingVat);
         if (ObjectUtil.isNotEmpty(wmsForSaleDetail.getInputVat())) {
            wmsForSaleDetail.setInputVat(amount.subtract(amountExcludingVat));
         }

         wmsForSaleDetail.setUnitPrice(amount.divide(outboundDetail.getMete(), 12, RoundingMode.HALF_UP));
         wmsForSaleDetail.setUnitPriceExcludingVat(amountExcludingVat.divide(outboundDetail.getMete(), 12, RoundingMode.HALF_UP));
         wmsForSaleDetail.setProfitAmount(wmsForSaleDetail.getSellAmount().subtract(wmsForSaleDetail.getAmount()));
         wmsForSaleDetail.setProfitAmountExcludingVat(wmsForSaleDetail.getSellAmountExcludingVat().subtract(wmsForSaleDetail.getAmountExcludingVat()));
         if (ObjectUtil.isNotEmpty(wmsForSaleDetail.getInputVat())) {
            wmsForSaleDetail.setProfitInputVat(wmsForSaleDetail.getSellInputVat().subtract(wmsForSaleDetail.getInputVat()));
         }

         this.wmsForSaleDetailService.updateById(wmsForSaleDetail);
         outboundDetail.setAmountNoFreight(amountNoFreight);
         outboundDetail.setAmountExcludingVatNoFreight(amountExcludingVatNoFreight);
         outboundDetail.setInputVatNoFreight(amountNoFreight.subtract(amountExcludingVatNoFreight));
         outboundDetail.setUnitPriceNoFreight(amountNoFreight.divide(outboundDetail.getMete(), 12, RoundingMode.HALF_UP));
         outboundDetail.setUnitPriceExcludingVatNoFreight(amountExcludingVatNoFreight.divide(outboundDetail.getMete(), 12, RoundingMode.HALF_UP));
         this.monthWeightedAveragePriceMapper.updateById(wap);
         Statistics statistics = this.statisticsMapper.get(materialInventory);
         this.saveStatisticsInbound(outbound, outboundDetail, materialInventory, statistics.getId());
         this.moveOutboundDetailMapper.updateById(outboundDetail);
         this.warningService.updateStatus(materialInventory, 2);
         if (statistics != null) {
            statistics.setInboundMete(
               statistics.getInboundMete() != null
                  ? statistics.getInboundMete().subtract(outboundDetail.getMete())
                  : BigDecimal.ZERO.subtract(outboundDetail.getMete())
            );
            statistics.setEndMete(statistics.getEndMete().subtract(outboundDetail.getMete()));
            if (outboundDetail.getQuantity() != null) {
               statistics.setInboundQuantity(
                  statistics.getInboundQuantity() != null
                     ? statistics.getInboundQuantity().subtract(outboundDetail.getQuantity())
                     : BigDecimal.ZERO.subtract(outboundDetail.getQuantity())
               );
               statistics.setEndQuantity(statistics.getEndQuantity().subtract(outboundDetail.getQuantity()));
            }

            statistics.setInboundAmount(
               statistics.getInboundAmount() != null
                  ? statistics.getInboundAmount().subtract(outboundDetail.getAmount())
                  : BigDecimal.ZERO.subtract(outboundDetail.getAmount())
            );
            statistics.setInboundAmountExcludingVat(
               statistics.getInboundAmountExcludingVat() != null
                  ? statistics.getInboundAmountExcludingVat().subtract(outboundDetail.getAmountExcludingVat())
                  : BigDecimal.ZERO.subtract(outboundDetail.getAmountExcludingVat())
            );
            statistics.setInboundAmountNoFreight(
               statistics.getInboundAmountNoFreight() != null
                  ? statistics.getInboundAmountNoFreight().subtract(outboundDetail.getAmountNoFreight())
                  : BigDecimal.ZERO.subtract(outboundDetail.getAmountNoFreight())
            );
            statistics.setInboundAmountExcludingVatNoFreight(
               statistics.getInboundAmountExcludingVatNoFreight() != null
                  ? statistics.getInboundAmountExcludingVatNoFreight().subtract(outboundDetail.getAmountExcludingVatNoFreight())
                  : BigDecimal.ZERO.subtract(outboundDetail.getAmountExcludingVatNoFreight())
            );
            if (statistics.getEndAmount() != null) {
               statistics.setEndAmount(statistics.getEndAmount().subtract(outboundDetail.getAmount()));
               statistics.setEndAmountExcludingVat(statistics.getEndAmountExcludingVat().subtract(outboundDetail.getAmountExcludingVat()));
            }

            if (statistics.getEndAmountNoFreight() != null) {
               statistics.setEndAmountNoFreight(statistics.getEndAmountNoFreight().subtract(outboundDetail.getAmountNoFreight()));
               statistics.setEndAmountExcludingVatNoFreight(
                  statistics.getEndAmountExcludingVatNoFreight().subtract(outboundDetail.getAmountExcludingVatNoFreight())
               );
            }

            if (statistics.getInboundMete().compareTo(BigDecimal.ZERO) > 0 && statistics.getInboundAmount().compareTo(BigDecimal.ZERO) > 0) {
               statistics.setInboundUnitPrice(statistics.getInboundAmount().divide(statistics.getInboundMete(), 12, RoundingMode.HALF_UP));
               statistics.setInboundUnitPriceExcludingVat(
                  statistics.getInboundAmountExcludingVat().divide(statistics.getInboundMete(), 12, RoundingMode.HALF_UP)
               );
            } else {
               statistics.setInboundUnitPrice(BigDecimal.ZERO);
               statistics.setInboundUnitPriceExcludingVat(BigDecimal.ZERO);
            }

            if (statistics.getInboundMete().compareTo(BigDecimal.ZERO) > 0 && statistics.getInboundAmountNoFreight().compareTo(BigDecimal.ZERO) > 0) {
               statistics.setInboundUnitPriceNoFreight(statistics.getInboundAmountNoFreight().divide(statistics.getInboundMete(), 12, RoundingMode.HALF_UP));
               statistics.setInboundUnitPriceExcludingVatNoFreight(
                  statistics.getInboundAmountExcludingVatNoFreight().divide(statistics.getInboundMete(), 12, RoundingMode.HALF_UP)
               );
            } else {
               statistics.setInboundUnitPriceNoFreight(BigDecimal.ZERO);
               statistics.setInboundUnitPriceExcludingVatNoFreight(BigDecimal.ZERO);
            }

            if (statistics.getEndMete().compareTo(BigDecimal.ZERO) <= 0) {
               statistics.setEndUnitPrice(null);
               statistics.setEndUnitPriceExcludingVat(null);
               statistics.setEndAmount(null);
               statistics.setEndAmountExcludingVat(null);
               statistics.setEndUnitPriceNoFreight(null);
               statistics.setEndUnitPriceExcludingVatNoFreight(null);
               statistics.setEndAmountNoFreight(null);
               statistics.setEndAmountExcludingVatNoFreight(null);
            }

            this.statisticsMapper.updateById(statistics);
         }

         StatisticsEndPeriod statisticsEndPeriod = this.statisticsEndPeriodMapper
            .selectOne((Wrapper<StatisticsEndPeriod>)Wrappers.<StatisticsEndPeriod>lambdaQuery().eq(StatisticsEndPeriod::getMaterialInventoryId, materialInventory.getId()));
         this.setStatisticsEndPeriod(materialInventory, statistics);
      }

      return outbound;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean reviewOutbound(Long approveRecordId, Integer decision, String opinion) {
      SecurityUser currentUser = UserUtil.getCurrentUser();
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService.getById(approveRecordId);
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(wmsApproveRecord), "审批日志不存在");
      Outbound outbound = this.baseMapper.selectById(wmsApproveRecord.getDataId());
      Boolean b = this.wmsApproveRecordService.commonApproveStep(outbound.getId(), decision, opinion, wmsApproveRecord.getSerialNumber(), null);
      if (b) {
         if (decision.equals(CheckStatusEnum.PASS.getType())) {
            if (!OutboundTypeEnum.PRODUCTION_USE.getType().equals(outbound.getOutboundTypeSelection())
               && !OutboundTypeEnum.CONSTRUCTION_SITE_USE.getType().equals(outbound.getOutboundTypeSelection())) {
               if (OutboundTypeEnum.FOR_SALE.getType().equals(outbound.getOutboundTypeSelection())) {
                  OutboundDTOParam outboundDTOParam = cn.hutool.core.bean.BeanUtil.toBean(outbound, OutboundDTOParam.class);
                  List<MoveOutboundDetail> moveOutboundDetails = this.moveOutboundDetailMapper
                     .selectList((Wrapper<MoveOutboundDetail>)new LambdaQueryWrapper<MoveOutboundDetail>().eq(MoveOutboundDetail::getOutboundId, outbound.getId()));
                  List<OutboundDetailDTO> outboundDetailDTOS = cn.hutool.core.bean.BeanUtil.copyToList(moveOutboundDetails, OutboundDetailDTO.class);
                  outboundDTOParam.setList(outboundDetailDTOS);
                  outbound = this.forSalePassed(outboundDTOParam, outbound, null, null);
                  this.reviewForSale(outbound, currentUser, ReviewStatusEnum.REVIEWED.getType());
                  outbound.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
                  return this.outboundService.updateById(outbound);
               }

               if (!OutboundTypeEnum.TEMPORARY_LOAN.getType().equals(outbound.getOutboundTypeSelection())) {
                  if (OutboundTypeEnum.OUTSOURCING_RAW_MATERIALS.getType().equals(outbound.getOutboundTypeSelection())) {
                     this.outsourcingPassed(outbound);
                  } else if (OutboundTypeEnum.SCRAPS.getType().equals(outbound.getOutboundTypeSelection())) {
                     this.ScrapsPassed(outbound.getId());
                  } else {
                     Preconditions.checkArgument(false, "未知出库类型");
                  }
               }
            } else {
               OutboundDTOParam outboundDTOParam = cn.hutool.core.bean.BeanUtil.toBean(outbound, OutboundDTOParam.class);
               List<MoveOutboundDetail> moveOutboundDetails = this.moveOutboundDetailMapper
                  .selectList((Wrapper<MoveOutboundDetail>)new LambdaQueryWrapper<MoveOutboundDetail>().eq(MoveOutboundDetail::getOutboundId, outbound.getId()));
               List<OutboundDetailDTO> outboundDetailDTOS = cn.hutool.core.bean.BeanUtil.copyToList(moveOutboundDetails, OutboundDetailDTO.class);
               outboundDTOParam.setList(outboundDetailDTOS);
               this.passed(outboundDTOParam);
            }
         } else if (OutboundTypeEnum.PRODUCTION_USE.getType().equals(outbound.getOutboundTypeSelection())
            || OutboundTypeEnum.CONSTRUCTION_SITE_USE.getType().equals(outbound.getOutboundTypeSelection())) {
            this.fail(outbound.getId(), ReviewStatusEnum.RETURNED.getType(), MaterialFreezeTypeEnum.OUTBOUND.getType(), true);
         } else if (OutboundTypeEnum.FOR_SALE.getType().equals(outbound.getOutboundTypeSelection())) {
            this.fail(outbound.getId(), ReviewStatusEnum.RETURNED.getType(), MaterialFreezeTypeEnum.FOR_SALE.getType(), true);
         } else if (!OutboundTypeEnum.TEMPORARY_LOAN.getType().equals(outbound.getOutboundTypeSelection())) {
            if (OutboundTypeEnum.OUTSOURCING_RAW_MATERIALS.getType().equals(outbound.getOutboundTypeSelection())) {
               this.fail(outbound.getId(), ReviewStatusEnum.RETURNED.getType(), MaterialFreezeTypeEnum.OUTSOURCING.getType(), true);
            } else if (OutboundTypeEnum.SCRAPS.getType().equals(outbound.getOutboundTypeSelection())) {
               this.fail(outbound.getId(), ReviewStatusEnum.REVIEWED.getType(), MaterialFreezeTypeEnum.SCRAPS.getType(), true);
            } else {
               Preconditions.checkArgument(false, "未知出库类型");
            }
         }
      }

      return true;
   }

   public String createForSaleSerialNumber(String tableNameKey, String prefix) {
      String yyyy_mm_dd = new SimpleDateFormat("yyyy_MM_dd").format(new Date());
      String key = MessageFormat.format("{0}:{1}", tableNameKey, yyyy_mm_dd);
      Long increment = this.redisTemplate.opsForValue().increment(key, 1L);
      if (increment.equals(1L)) {
         this.redisTemplate.expire(key, 24L, TimeUnit.HOURS);
      }

      String datetime = new SimpleDateFormat("yyyyMMdd").format(new Date());
      String value = org.apache.commons.lang.StringUtils.leftPad(String.valueOf(increment), 6, "0");
      String code = MessageFormat.format("{0}{1}", datetime, value);
      return prefix + code;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean fail(Long id, Integer reviewStatus, Integer materialFreezeType, Boolean boolInventory) {
      Outbound outbound = this.baseMapper.selectById(id);
      Preconditions.checkArgument(outbound != null, "出库单不存在,请核对后操作");
      if (Boolean.TRUE.equals(outbound.getBoolScheduling()) && MaterialFreezeTypeEnum.OUTBOUND.getType().equals(materialFreezeType)) {
         materialFreezeType = MaterialFreezeTypeEnum.SCHEDULING_OUTBOUND.getType();
      }
      Preconditions.checkArgument(ReviewStatusEnum.AUDITING.getType().equals(outbound.getReviewStatus()), "出库单已审核,请核对后操作");
      outbound.setReviewerId(UserUtil.getCurrentUserId());
      outbound.setReviewerName(UserUtil.getCurrentName());
      outbound.setReviewStatus(reviewStatus);
      outbound.setReviewTime(LocalDateTime.now());
      outbound.setOutboundTime(LocalDateTime.now());
      outbound.setUserUpdateTime(LocalDateTime.now());
      this.baseMapper.updateById(outbound);
      BasicOutbound outboundBasicConf = this.basicConfigService.getOutboundBasicConf();
      Boolean boolUnfreeze = true;
      if (boolInventory) {
         if (ReviewStatusEnum.CANCEL.getType().equals(reviewStatus)) {
            if (outboundBasicConf.getCancelDestination().equals(OutboundFailDestinationEnum.returnOutboundInventory.getType())) {
               boolUnfreeze = false;
            }
         } else if (ReviewStatusEnum.RETURNED.getType().equals(reviewStatus)
            && outboundBasicConf.getReturnedDestination().equals(OutboundFailDestinationEnum.returnOutboundInventory.getType())) {
            boolUnfreeze = false;
         }
      }

      if (boolUnfreeze) {
         this.materialFreezeService.materialUnfreeze(outbound.getId(), -1L, materialFreezeType, true);
      } else {
         this.returnOutboundInventory(outbound, materialFreezeType);
      }

      return true;
   }

   @Override
   public List<OutboundDetailDTO> getOutboundDetailDTO(List<Long> outboundDetailIds) {
      if (CollectionUtil.isEmpty(outboundDetailIds)) {
         return new ArrayList<>();
      }

      List<MoveOutboundDetail> moveOutboundDetails = this.moveOutboundDetailMapper.selectBatchIds(outboundDetailIds);
      List<Long> outboundIds = new ArrayList<>();
      List<Long> projectIds = new ArrayList<>();
      List<Long> workshopIds = new ArrayList<>();
      List<Long> warehouseIds = new ArrayList<>();
      List<Long> mesWorkshopIds = new ArrayList<>();

      for (MoveOutboundDetail moveOutboundDetail : moveOutboundDetails) {
         outboundIds.add(moveOutboundDetail.getOutboundId());
         if (ObjectUtil.isNotEmpty(moveOutboundDetail.getSourceProjectId())) {
            projectIds.add(moveOutboundDetail.getSourceProjectId());
         }

         if (ObjectUtil.isNotEmpty(moveOutboundDetail.getProjectId())) {
            projectIds.add(moveOutboundDetail.getProjectId());
         }

         if (ObjectUtil.isNotEmpty(moveOutboundDetail.getSourceWorkshopId())) {
            workshopIds.add(moveOutboundDetail.getSourceWorkshopId());
         }

         if (ObjectUtil.isNotEmpty(moveOutboundDetail.getWarehouseId())) {
            warehouseIds.add(moveOutboundDetail.getWarehouseId());
         }

         if (ObjectUtil.isNotEmpty(moveOutboundDetail.getWorkshopId())) {
            mesWorkshopIds.add(moveOutboundDetail.getWorkshopId());
         }
      }

      Map<Long, Outbound> outboundMap = this.outboundService
         .listByIds(outboundIds.stream().distinct().collect(Collectors.toList()))
         .stream()
         .collect(Collectors.toMap(Outbound::getId, Function.identity()));
      Map<Long, ProjectInfo> projectInfoMap = this.contractProjectService
         .getSimpleByIds(projectIds.stream().distinct().collect(Collectors.toList()))
         .stream()
         .collect(Collectors.toMap(ProjectInfo::getId, Function.identity()));
      Map<Long, Workshop> workshopMap = new HashMap<>();
      if (CollectionUtils.isNotEmpty(workshopIds)) {
         workshopMap = this.workshopService
            .listByIds(workshopIds.stream().distinct().collect(Collectors.toList()))
            .stream()
            .collect(Collectors.toMap(Workshop::getId, Function.identity()));
      }

      Map<Long, Warehouse> warehouseMap = new HashMap<>();
      if (CollectionUtils.isNotEmpty(workshopIds)) {
         warehouseMap = this.warehouseService
            .listByIds(warehouseIds.stream().distinct().collect(Collectors.toList()))
            .stream()
            .collect(Collectors.toMap(Warehouse::getId, Function.identity()));
      }

      Map<Long, MesBuildingWorkshop> mesBuildingWorkshopMap = new HashMap<>();
      if (CollectionUtils.isNotEmpty(mesWorkshopIds)) {
         mesBuildingWorkshopMap = this.mesBuildingWorkshopService
            .listByIds(mesWorkshopIds.stream().distinct().collect(Collectors.toList()))
            .stream()
            .collect(Collectors.toMap(MesBuildingWorkshop::getId, Function.identity()));
      }

      List<OutboundDetailDTO> outboundDetailDTOS = new ArrayList<>();

      for (MoveOutboundDetail moveOutboundDetail : moveOutboundDetails) {
         OutboundDetailDTO outboundDetailDTO = BeanUtil.copy(moveOutboundDetail, OutboundDetailDTO.class);
         outboundDetailDTO.setOutboundSerialNumber(outboundMap.get(moveOutboundDetail.getOutboundId()).getSerialNumber());
         if (ObjectUtil.isNotEmpty(moveOutboundDetail.getSourceProjectId())) {
            outboundDetailDTO.setSourceProject(projectInfoMap.get(moveOutboundDetail.getSourceProjectId()));
         }

         if (ObjectUtil.isNotEmpty(moveOutboundDetail.getProjectId())) {
            outboundDetailDTO.setProject(projectInfoMap.get(moveOutboundDetail.getProjectId()));
         }

         if (ObjectUtil.isNotEmpty(moveOutboundDetail.getSourceWorkshopId())) {
            Workshop workshop = workshopMap.get(moveOutboundDetail.getSourceWorkshopId());
            outboundDetailDTO.setWorkshop(BriefIdAndNameDTO.builder().id(workshop.getId()).name(workshop.getName()).build());
         }

         if (ObjectUtil.isNotEmpty(moveOutboundDetail.getWarehouseId())) {
            Warehouse warehouse = warehouseMap.get(moveOutboundDetail.getWarehouseId());
            outboundDetailDTO.setWarehouse(BriefIdAndNameDTO.builder().id(warehouse.getId()).name(warehouse.getName()).build());
         }

         if (ObjectUtil.isNotEmpty(moveOutboundDetail.getWorkshopId())) {
            MesBuildingWorkshop mesBuildingWorkshop = mesBuildingWorkshopMap.get(moveOutboundDetail.getWorkshopId());
            outboundDetailDTO.setMesWorkshop(BriefIdAndNameDTO.builder().id(mesBuildingWorkshop.getId()).name(mesBuildingWorkshop.getName()).build());
         }

         outboundDetailDTOS.add(outboundDetailDTO);
      }

      return outboundDetailDTOS;
   }

   @Override
   public List<MoveOutboundDetail> getPassOrderDetail(Integer basicClass, Long workshopId, int size) {
      return this.baseMapper.getPassOrderDetail(basicClass, workshopId, size);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateOutboundDetail(UpdateOutboundDTOParam param) {
      Outbound outbound = this.outboundService.getById(param.getId());
      Preconditions.checkArgument(outbound != null, "出库单不存在");
      Preconditions.checkArgument(UserUtil.getCurrentUserId().equals(outbound.getApplicantId()), "仅创建此出库单的人才可修改出库草稿");
      Preconditions.checkArgument(ReviewStatusEnum.UN_REVIEWED.getType().equals(outbound.getReviewStatus())
         || ReviewStatusEnum.NOT_SUBMITTED.getType().equals(outbound.getReviewStatus()), "出库单已提交审核或已审核,请核对后操作");
      if (CollectionUtils.isNotEmpty(param.getDeleteDetailIds())) {
         for (Long deleteDetailId : param.getDeleteDetailIds()) {
            this.delete(param.getId(), deleteDetailId);
         }
      }

      for (SteelPlateOutboundDTOParam steelPlateOutboundDTOParam : param.getList()) {
         this.saveOutbound(steelPlateOutboundDTOParam);
      }

      return true;
   }

   @Override
   public PageVO<OutboundDetailDTO> getAppProjectPicking(QueryProjectPickingDTOParam param, Integer pageNumber, Integer pageSize) {
      List<ProjectPickingDTO> list = new ArrayList<>();
      ProjectPickingListDTO projectPicking = this.getProjectPicking(param);
      if (CollectionUtil.isNotEmpty(projectPicking.getMoveOutboundDetails())) {
         list.addAll(projectPicking.getMoveOutboundDetails());
      }

      if (CollectionUtil.isNotEmpty(projectPicking.getReturnDetails())) {
         projectPicking.getReturnDetails().forEach(e -> e.setMete(e.getMete().negate()));
         list.addAll(projectPicking.getReturnDetails());
      }

      return new PageVO<>(list.stream().map(e -> BeanUtil.copy(e, OutboundDetailDTO.class)).collect(Collectors.toList()));
   }

   @Override
   public Outbound saveOutbound(List<PickingApproveOutboundDTOParam> params, List<SplitMaterialDTO> partASplitParams, boolean boolPartyA) {
      Outbound outbound = Outbound.builder()
         .applicantId(UserUtil.getCurrentUserId())
         .applicantName(UserUtil.getCurrentName())
         .userUpdateTime(LocalDateTime.now())
         .outboundStartTime(LocalDateTime.now())
         .outboundEndTime(LocalDateTime.now())
         .boolPartyA(boolPartyA)
         .outboundTypeSelection(OutboundTypeEnum.SCHEDULING_OUTBOUND.getType())
         .reviewStatus(ReviewStatusEnum.AUDITING.getType())
         .build();
      String serviceNumber = this.numberConfigService.getNumber(NumberTypeEnum.OUTBOUND_APPLY, this.baseMapper.getCount(LocalDateTime.now()));
      outbound.setApplicationSn(serviceNumber);
      this.baseMapper.insert(outbound);
      this.fullMaterial(outbound, params);
      this.splitMaterial(outbound, partASplitParams);
      this.baseMapper.updateById(outbound);
      return outbound;
   }

   private void splitMaterial(Outbound outbound, List<SplitMaterialDTO> splitMaterialDTOList) {
      for (SplitMaterialDTO splitMaterialDTO : splitMaterialDTOList) {
         MaterialInventory materialInventory = this.materialInventoryMapper.selectById(splitMaterialDTO.getMaterialInventoryId());
         Preconditions.checkArgument(materialInventory != null, "仓库中不存在该物料");
         Measure measure = this.measureMapper
            .selectOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, materialInventory.getClassifyId()));
         SubjectMeasureDTO subjectMeasureDTO = this.measureService.measureListById(materialInventory.getClassifyId());
         WasteConfig scrapDefinitionConf = this.basicConfigService.getSteelScrapDefinitionConf();
         BasicOutbound outboundBasicConf = this.basicConfigService.getOutboundBasicConf();
         BigDecimal precision = UnitsPrecisionEnum.getByName(measure.getAccountingUnit());
         MaterialFreeze materialFreeze = this.materialFreezeService
            .getOne((Wrapper<MaterialFreeze>)Wrappers.<MaterialFreeze>lambdaQuery().eq(MaterialFreeze::getMaterialInventoryId, materialInventory.getId()));
         MaterialFreezeRecord freezeRecord = null;
         Set<Integer> freezeTypes = null;
         BigDecimal freezeTotalMete;
         BigDecimal freezeTotalQuantity;
         if (materialFreeze != null) {
            freezeTotalMete = materialFreeze.getTotalMete();
            freezeTotalQuantity = materialFreeze.getTotalQuantity();
            freezeTypes = Arrays.stream(materialFreeze.getTotalFreezeTypes().split(",")).map(Integer::parseInt).collect(Collectors.toSet());
         } else {
            freezeTotalMete = BigDecimal.ZERO;
            freezeTotalQuantity = BigDecimal.ZERO;
         }

         MeteAndQuantity meteAndQuantitySend = new MeteAndQuantity();
         meteAndQuantitySend.setSendQuantity(splitMaterialDTO.getQuantity());
         MeteAndQuantity meteAndQuantity = this.checkInventory(
            materialInventory.getBasicClass(),
            materialInventory.getClassifyId(),
            meteAndQuantitySend,
            materialInventory.getQuantity(),
            materialInventory.getMete(),
            freezeTotalQuantity,
            freezeTotalMete,
            subjectMeasureDTO,
            measure
         );
         BigDecimal availableMete = materialInventory.getMete().subtract(freezeTotalMete);
         Preconditions.checkArgument(
            splitMaterialDTO.getMaterialInventoryMete() != null && splitMaterialDTO.getMaterialInventoryMete().signum() >= 0
               && splitMaterialDTO.getMaterialInventoryMete().stripTrailingZeros().scale() <= 8
               && splitMaterialDTO.getMaterialInventoryMete().compareTo(availableMete) <= 0
               && CollectionUtil.isNotEmpty(splitMaterialDTO.getPickingApproveOutboundDTOParams())
               && splitMaterialDTO.getPickingApproveOutboundDTOParams().stream().allMatch(
                  p -> p.getOutboundMete() != null && p.getOutboundMete().signum() >= 0 && p.getOutboundMete().stripTrailingZeros().scale() <= 8
               ),
            "物料拆分重量与可用库存不一致,请重新分配物料"
         );
         BigDecimal splitMete = splitMaterialDTO.getPickingApproveOutboundDTOParams().stream()
            .map(PickingApproveOutboundDTOParam::getOutboundMete).reduce(BigDecimal.ZERO, BigDecimal::add);
         Preconditions.checkArgument(
            splitMete.compareTo(splitMaterialDTO.getMaterialInventoryMete()) == 0,
            "物料拆分重量与可用库存不一致,请重新分配物料"
         );
         MaterialFreezeRecord materialFreezeRecord = MaterialFreezeRecord.builder()
            .freezeDetailId(null)
            .freezeType(MaterialFreezeTypeEnum.SCHEDULING_OUTBOUND.getType())
            .freezeSourceId(outbound.getId())
            .freezeSourceSn(outbound.getApplicationSn())
            .operatorId(UserUtil.getCurrentUserId())
            .operatorName(UserUtil.getCurrentName())
            .mete(splitMaterialDTO.getMaterialInventoryMete())
            .quantity(splitMaterialDTO.getQuantity())
            .boolBatten(false)
            .projectId(null)
            .frozenTime(LocalDateTime.now())
            .outboundUnitType(measure.getOutboundUnitType())
            .build();
         if (materialFreeze == null) {
            materialFreeze = BeanUtil.copy(materialInventory, MaterialFreeze.class, "createTime");
            materialFreeze.setTotalQuantity(splitMaterialDTO.getQuantity());
            materialFreeze.setTotalMete(splitMaterialDTO.getMaterialInventoryMete());
            materialFreeze.setTotalFreezeTypes(MaterialFreezeTypeEnum.OUTBOUND.getType() + "");
            materialFreeze.setMaterialInventoryId(materialInventory.getId());
            this.materialFreezeService.save(materialFreeze);
         } else {
            materialFreeze.setTotalQuantity(materialFreeze.getTotalQuantity().add(splitMaterialDTO.getQuantity()));
            freezeTypes.add(MaterialFreezeTypeEnum.OUTBOUND.getType());
            materialFreeze.setTotalFreezeTypes(StrUtil.join(",", freezeTypes));
            materialFreeze.setTotalMete(materialFreeze.getTotalMete().add(splitMaterialDTO.getMaterialInventoryMete()));
            this.materialFreezeService.updateById(materialFreeze);
         }

         materialFreezeRecord.setMaterialFreezeId(materialFreeze.getId());
         this.materialFreezeRecordMapper.insert(materialFreezeRecord);
         if (!materialInventory.getBoolHasFrozen()) {
            this.materialInventoryMapper.updateBoolHasFrozen(materialInventory.getId(), true);
         }

         List<PickingApproveOutboundDTOParam> pickingApproveOutboundDTOParams = splitMaterialDTO.getPickingApproveOutboundDTOParams();

         for (PickingApproveOutboundDTOParam param : pickingApproveOutboundDTOParams) {
            MoveOutboundDetail moveOutboundDetail = MoveOutboundDetail.builder()
               .warehouseId(materialInventory.getWarehouseId())
               .materialIsWhole(materialInventory.getMaterialIsWhole())
               .workshopId(param.getMesWorkshopId())
               .sourceWorkshopId(materialInventory.getWorkshopId())
               .materialInventoryId(materialInventory.getId())
               .outboundId(outbound.getId())
               .basicClass(materialInventory.getBasicClass())
               .classifyId(materialInventory.getClassifyId())
               .specification(materialInventory.getSpecification())
               .sourceProjectId(materialInventory.getProjectId())
               .sourceMonomerId(materialInventory.getMonomerId())
               .sourceAreaId(materialInventory.getAreaId())
               .thickness(materialInventory.getThickness())
               .theoryThickness(materialInventory.getTheoryThickness())
               .heatNoAndBatchNo(materialInventory.getHeatNoAndBatchNo())
               .brand(materialInventory.getBrand())
               .outboundTime(LocalDateTime.now())
               .color(materialInventory.getColor())
               .recipientId(param.getRecipientId())
               .outboundMode(MaterialOutboundModeEnum.WHOLE.getType())
               .boolPartyA(materialInventory.getBoolPartyA())
               .taxRate(materialInventory.getTaxRate())
               .invoiceType(materialInventory.getInvoiceType())
               .standardId(materialInventory.getStandardId())
               .standardName(materialInventory.getStandardName())
               .materialSn(materialInventory.getSerialNumber())
               .outboundAddress(1)
               .pickingDetailId(param.getPickingDetailId())
               .outboundTypeSelection(outbound.getOutboundTypeSelection())
               .build();
            BigDecimal outMete = null;
            BigDecimal outQuantity = null;
            if (param.getProjectId() != null) {
               if (materialInventory.getBoolPartyA()) {
                  Preconditions.checkArgument(materialInventory.getProjectId().equals(param.getProjectId()), "出库失败,甲供物料不能出库到其他项目.");
               }

               if (!outboundBasicConf.getBoolCanOutToOtherProject() && materialInventory.getProjectId() != null) {
                  Preconditions.checkArgument(materialInventory.getProjectId().equals(param.getProjectId()), "当前出库项目与物料项目不一致,请核对.");
               }

               if (materialInventory.getProjectId() != null) {
                  moveOutboundDetail.setOutboundRelationType(
                     materialInventory.getProjectId().equals(param.getProjectId())
                        ? OutboundRelationTypeEnum.ROUTINE.getType()
                        : OutboundRelationTypeEnum.TRANSFER.getType()
                  );
               }

               moveOutboundDetail.setProjectId(param.getProjectId());
            }

            if (param.getProjectId() == null && materialInventory.getProjectId() != null) {
               moveOutboundDetail.setProjectId(materialInventory.getProjectId());
               moveOutboundDetail.setMonomerId(materialInventory.getMonomerId());
               moveOutboundDetail.setAreaId(materialInventory.getAreaId());
            }

            if (moveOutboundDetail.getProjectId() != null) {
               ContractProject project = this.contractProjectService.getById(moveOutboundDetail.getProjectId());
               Preconditions.checkArgument(
                  moveOutboundDetail.getProjectId() != null && SettlementStatusEnum.UN_SETTLED.getType().equals(project.getSettlementStatus()), "出库失败,当前项目已结算"
               );
            }

            moveOutboundDetail.setOutboundType(MaterialOutboundModeEnum.WHOLE.getType());
            moveOutboundDetail.setQuantity(param.getQuantity());
            moveOutboundDetail.setMete(param.getOutboundMete());
            if (BasicClassEnum.STEEL_PLATE.getType().equals(moveOutboundDetail.getBasicClass())) {
               moveOutboundDetail.setActualTheoryWeight(param.getOutboundMete());
            }

            if (materialInventory.getBasicClass().equals(BasicClassEnum.SECTION_STEEL.getType())) {
               moveOutboundDetail.setLength(param.getOutboundLength());
            }

            outMete = moveOutboundDetail.getMete();
            if (moveOutboundDetail.getRecipientId() != null) {
               User user = this.userService.getById(moveOutboundDetail.getRecipientId());
               moveOutboundDetail.setRecipientName(user.getName());
               List<String> recipientName = StrUtil.isNotBlank(outbound.getRecipients())
                  ? Arrays.stream(outbound.getRecipients().split(",")).collect(Collectors.toList())
                  : new ArrayList<>();
               if (!recipientName.contains(user.getName())) {
                  recipientName.add(user.getName());
               }

               outbound.setRecipients(StrUtil.join(",", recipientName));
            }

            if (moveOutboundDetail.getProjectId() != null) {
               if (StrUtil.isNotBlank(outbound.getProjectIds())) {
                  List<Long> list = CommonUtil.spilt(outbound.getProjectIds(), ",");
                  if (!list.contains(moveOutboundDetail.getProjectId())) {
                     outbound.setProjectIds(outbound.getProjectIds() + "," + moveOutboundDetail.getProjectId());
                  }
               } else {
                  outbound.setProjectIds(moveOutboundDetail.getProjectId() + "");
               }
            }

            this.moveOutboundDetailMapper.insert(moveOutboundDetail);
            param.setOutboundId(outbound.getId());
            param.setOutboundDetailId(moveOutboundDetail.getId());
            param.setOutboundQuantity(moveOutboundDetail.getQuantity());
            param.setOutboundMete(outMete);
            outbound.setContainBasicClass(
               outbound.getContainBasicClass() != null
                  ? outbound.getContainBasicClass() | moveOutboundDetail.getBasicClass()
                  : moveOutboundDetail.getBasicClass()
            );
         }

         splitMaterialDTO.setPickingApproveOutboundDTOParams(pickingApproveOutboundDTOParams);
      }
   }

   private void fullMaterial(Outbound outbound, List<PickingApproveOutboundDTOParam> params) {
      for (PickingApproveOutboundDTOParam param : params) {
         MaterialInventory materialInventory = this.materialInventoryMapper.selectById(param.getMaterialId());
         Preconditions.checkArgument(materialInventory != null, "仓库中不存在该物料");
         Measure measure = this.measureMapper
            .selectOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, materialInventory.getClassifyId()));
         SubjectMeasureDTO subjectMeasureDTO = this.measureService.measureListById(materialInventory.getClassifyId());
         WasteConfig scrapDefinitionConf = this.basicConfigService.getSteelScrapDefinitionConf();
         BasicOutbound outboundBasicConf = this.basicConfigService.getOutboundBasicConf();
         MoveOutboundDetail moveOutboundDetail = MoveOutboundDetail.builder()
            .warehouseId(materialInventory.getWarehouseId())
            .materialIsWhole(materialInventory.getMaterialIsWhole())
            .workshopId(param.getMesWorkshopId())
            .sourceWorkshopId(materialInventory.getWorkshopId())
            .materialInventoryId(materialInventory.getId())
            .outboundId(outbound.getId())
            .basicClass(materialInventory.getBasicClass())
            .classifyId(materialInventory.getClassifyId())
            .specification(materialInventory.getSpecification())
            .sourceProjectId(materialInventory.getProjectId())
            .sourceMonomerId(materialInventory.getMonomerId())
            .sourceAreaId(materialInventory.getAreaId())
            .thickness(materialInventory.getThickness())
            .theoryThickness(materialInventory.getTheoryThickness())
            .heatNoAndBatchNo(materialInventory.getHeatNoAndBatchNo())
            .brand(materialInventory.getBrand())
            .outboundTime(LocalDateTime.now())
            .color(materialInventory.getColor())
            .recipientId(param.getRecipientId())
            .outboundMode(MaterialOutboundModeEnum.WHOLE.getType())
            .boolPartyA(materialInventory.getBoolPartyA())
            .taxRate(materialInventory.getTaxRate())
            .invoiceType(materialInventory.getInvoiceType())
            .standardId(materialInventory.getStandardId())
            .standardName(materialInventory.getStandardName())
            .materialSn(materialInventory.getSerialNumber())
            .outboundAddress(1)
            .pickingDetailId(param.getPickingDetailId())
            .outboundTypeSelection(outbound.getOutboundTypeSelection())
            .build();
         MaterialFreeze materialFreeze = this.materialFreezeService
            .getOne((Wrapper<MaterialFreeze>)Wrappers.<MaterialFreeze>lambdaQuery().eq(MaterialFreeze::getMaterialInventoryId, materialInventory.getId()));
         MaterialFreezeRecord freezeRecord = null;
         Set<Integer> freezeTypes = null;
         BigDecimal freezeTotalMete;
         BigDecimal freezeTotalQuantity;
         if (materialFreeze != null) {
            freezeTotalMete = materialFreeze.getTotalMete();
            freezeTotalQuantity = materialFreeze.getTotalQuantity();
            freezeTypes = Arrays.stream(materialFreeze.getTotalFreezeTypes().split(",")).map(Integer::parseInt).collect(Collectors.toSet());
         } else {
            freezeTotalMete = BigDecimal.ZERO;
            freezeTotalQuantity = BigDecimal.ZERO;
         }

         BigDecimal outMete = null;
         BigDecimal outQuantity = null;
         if (param.getProjectId() != null) {
            if (materialInventory.getBoolPartyA()) {
               Preconditions.checkArgument(materialInventory.getProjectId().equals(param.getProjectId()), "出库失败,甲供物料不能出库到其他项目.");
            }

            if (!outboundBasicConf.getBoolCanOutToOtherProject() && materialInventory.getProjectId() != null) {
               Preconditions.checkArgument(materialInventory.getProjectId().equals(param.getProjectId()), "当前出库项目与物料项目不一致,请核对.");
            }

            if (materialInventory.getProjectId() != null) {
               moveOutboundDetail.setOutboundRelationType(
                  materialInventory.getProjectId().equals(param.getProjectId())
                     ? OutboundRelationTypeEnum.ROUTINE.getType()
                     : OutboundRelationTypeEnum.TRANSFER.getType()
               );
            }

            moveOutboundDetail.setProjectId(param.getProjectId());
         }

         if (param.getProjectId() == null && materialInventory.getProjectId() != null) {
            moveOutboundDetail.setProjectId(materialInventory.getProjectId());
            moveOutboundDetail.setMonomerId(materialInventory.getMonomerId());
            moveOutboundDetail.setAreaId(materialInventory.getAreaId());
         }

         if (moveOutboundDetail.getProjectId() != null) {
            ContractProject project = this.contractProjectService.getById(moveOutboundDetail.getProjectId());
            Preconditions.checkArgument(
               moveOutboundDetail.getProjectId() != null && SettlementStatusEnum.UN_SETTLED.getType().equals(project.getSettlementStatus()), "出库失败,当前项目已结算"
            );
         }

         moveOutboundDetail.setOutboundType(MaterialOutboundModeEnum.WHOLE.getType());
         BigDecimal precision = UnitsPrecisionEnum.getByName(measure.getAccountingUnit());
         MeteAndQuantity meteAndQuantitySend = new MeteAndQuantity();
         meteAndQuantitySend.setSendQuantity(param.getQuantity());
         MeteAndQuantity meteAndQuantity = this.checkInventory(
            materialInventory.getBasicClass(),
            materialInventory.getClassifyId(),
            meteAndQuantitySend,
            materialInventory.getQuantity(),
            materialInventory.getMete(),
            freezeTotalQuantity,
            freezeTotalMete,
            subjectMeasureDTO,
            measure
         );
         BigDecimal sendQuantity = meteAndQuantity.getSendQuantity();
         if (BasicClassEnum.checkNotSteel(materialInventory.getBasicClass())) {
            if (measure.getOutboundUnitType() == null) {
               measure = this.getMeasured(materialInventory.getClassifyId());
            }

            if (MeasureTypeEnum.MEASURE.getType().equals(measure.getOutboundUnitType())) {
               moveOutboundDetail.setMete(CommonUtil.getStockOutboundMete(
                  sendQuantity, materialInventory.getQuantity().subtract(freezeTotalQuantity), materialInventory.getMete().subtract(freezeTotalMete)
               ));
               moveOutboundDetail.setQuantity(sendQuantity);
            } else {
               moveOutboundDetail.setMete(sendQuantity);
               if (materialInventory.getQuantity() != null) {
                  moveOutboundDetail.setQuantity(sendQuantity.divide(materialInventory.getUnitNet(), 8, this.ROUNDING));
               }
            }
         } else if (BasicClassEnum.STEEL_PLATE.getType().equals(materialInventory.getBasicClass())) {
            moveOutboundDetail.setQuantity(sendQuantity);
            moveOutboundDetail.setMete(
               CommonUtil.getStockOutboundMete(
                  sendQuantity, materialInventory.getQuantity().subtract(freezeTotalQuantity), materialInventory.getMete().subtract(freezeTotalMete)
               )
            );
            moveOutboundDetail.setLength(materialInventory.getLength());
            moveOutboundDetail.setWidth(materialInventory.getWidth());
            Classification classification = this.classificationService.getById(moveOutboundDetail.getClassifyId());
            BigDecimal oneTheoryMete = CommonUtil.getTheoryMete(
               classification.getName(),
               moveOutboundDetail.getLength(),
               moveOutboundDetail.getWidth(),
               moveOutboundDetail.getThickness(),
               null,
               classification.getId()
            );
            moveOutboundDetail.setActualTheoryWeight(
               oneTheoryMete.multiply(moveOutboundDetail.getQuantity()).setScale(0, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(1000L))
            );
         } else if (BasicClassEnum.SECTION_STEEL.getType().equals(materialInventory.getBasicClass())) {
            moveOutboundDetail.setMete(
               CommonUtil.getStockOutboundMete(
                  sendQuantity, materialInventory.getQuantity().subtract(freezeTotalQuantity), materialInventory.getMete().subtract(freezeTotalMete)
               )
            );
            moveOutboundDetail.setLength(materialInventory.getLength());
            moveOutboundDetail.setQuantity(sendQuantity);
         } else if (BasicClassEnum.COLOR_ROLL.getType().equals(materialInventory.getBasicClass())) {
            Preconditions.checkArgument(sendQuantity.compareTo(scrapDefinitionConf.getSteelCoilMinLength()) > 0, "出库失败,钢卷出库长度必须大于废料定义长度.");
            Preconditions.checkArgument(sendQuantity.compareTo(BigDecimal.TEN) >= 0, "钢卷出库长度不能小于10MM");
            moveOutboundDetail.setMete(
               CommonUtil.getStockOutboundMete(
                  sendQuantity, materialInventory.getQuantity().subtract(freezeTotalQuantity), materialInventory.getMete().subtract(freezeTotalMete)
               )
            );
            Preconditions.checkArgument(moveOutboundDetail.getMete().compareTo(BigDecimal.valueOf(1000L)) > 0, "出库失败,出库量必须大于1kg");
            moveOutboundDetail.setQuantity(sendQuantity);
            moveOutboundDetail.setWidth(materialInventory.getWidth());
         }

         outMete = moveOutboundDetail.getMete();
         if (moveOutboundDetail.getRecipientId() != null) {
            User user = this.userService.getById(moveOutboundDetail.getRecipientId());
            moveOutboundDetail.setRecipientName(user.getName());
            List<String> recipientName = StrUtil.isNotBlank(outbound.getRecipients())
               ? Arrays.stream(outbound.getRecipients().split(",")).collect(Collectors.toList())
               : new ArrayList<>();
            if (!recipientName.contains(user.getName())) {
               recipientName.add(user.getName());
            }

            outbound.setRecipients(StrUtil.join(",", recipientName));
         }

         if (moveOutboundDetail.getProjectId() != null) {
            if (StrUtil.isNotBlank(outbound.getProjectIds())) {
               List<Long> list = CommonUtil.spilt(outbound.getProjectIds(), ",");
               if (!list.contains(moveOutboundDetail.getProjectId())) {
                  outbound.setProjectIds(outbound.getProjectIds() + "," + moveOutboundDetail.getProjectId());
               }
            } else {
               outbound.setProjectIds(moveOutboundDetail.getProjectId() + "");
            }
         }

         this.moveOutboundDetailMapper.insert(moveOutboundDetail);
         param.setOutboundId(outbound.getId());
         param.setOutboundDetailId(moveOutboundDetail.getId());
         param.setOutboundQuantity(moveOutboundDetail.getQuantity());
         param.setOutboundMete(outMete);
         outbound.setContainBasicClass(
            outbound.getContainBasicClass() != null ? outbound.getContainBasicClass() | moveOutboundDetail.getBasicClass() : moveOutboundDetail.getBasicClass()
         );
         MaterialFreezeRecord materialFreezeRecord = MaterialFreezeRecord.builder()
            .freezeDetailId(moveOutboundDetail.getId())
            .freezeType(MaterialFreezeTypeEnum.SCHEDULING_OUTBOUND.getType())
            .freezeSourceId(outbound.getId())
            .freezeSourceSn(outbound.getApplicationSn())
            .operatorId(UserUtil.getCurrentUserId())
            .operatorName(UserUtil.getCurrentName())
            .mete(outMete != null ? outMete : moveOutboundDetail.getMete())
            .quantity(outQuantity != null ? outQuantity : moveOutboundDetail.getQuantity())
            .boolBatten(outQuantity != null)
            .projectId(moveOutboundDetail.getProjectId())
            .frozenTime(LocalDateTime.now())
            .outboundUnitType(measure.getOutboundUnitType())
            .build();
         if (materialFreeze == null) {
            materialFreeze = BeanUtil.copy(materialInventory, MaterialFreeze.class, "createTime");
            materialFreeze.setTotalQuantity(outQuantity != null ? outQuantity : moveOutboundDetail.getQuantity());
            materialFreeze.setTotalMete(outMete);
            materialFreeze.setTotalFreezeTypes(MaterialFreezeTypeEnum.OUTBOUND.getType() + "");
            materialFreeze.setMaterialInventoryId(materialInventory.getId());
            this.materialFreezeService.save(materialFreeze);
         } else {
            if (freezeRecord != null) {
               if (freezeRecord.getMete().compareTo(moveOutboundDetail.getMete()) < 0) {
                  materialFreezeRecord.setApplyPurchaseQuantity(freezeRecord.getQuantity());
                  materialFreezeRecord.setApplyPurchaseMete(freezeRecord.getMete());
               } else {
                  materialFreezeRecord.setApplyPurchaseQuantity(moveOutboundDetail.getQuantity());
                  materialFreezeRecord.setApplyPurchaseMete(moveOutboundDetail.getMete());
               }

               if (freezeRecord.getQuantity() != null) {
                  freezeRecord.setQuantity(freezeRecord.getQuantity().subtract(moveOutboundDetail.getQuantity()));
               }

               freezeRecord.setMete(freezeRecord.getMete().subtract(moveOutboundDetail.getMete()));
               if (freezeRecord.getMete().compareTo(BigDecimal.ZERO) <= 0) {
                  if (freezeRecord.getMete().compareTo(BigDecimal.ZERO) != 0) {
                     materialFreeze.setTotalQuantity(
                        freezeRecord.getQuantity() != null ? materialFreeze.getTotalQuantity().add(freezeRecord.getQuantity().negate()) : null
                     );
                     materialFreeze.setTotalMete(materialFreeze.getTotalMete().add(freezeRecord.getMete().negate()));
                  }

                  this.materialFreezeRecordMapper.deleteById(freezeRecord);
               } else {
                  this.materialFreezeRecordMapper.updateById(freezeRecord);
               }

               materialFreezeRecord.setBoolChangeOutbound(true);
               materialFreezeRecord.setApplyPurchaseId(freezeRecord.getFreezeSourceId());
               materialFreezeRecord.setApplyPurchaseDetailId(freezeRecord.getFreezeDetailId());
               materialFreezeRecord.setApplyPurchaseSn(freezeRecord.getFreezeSourceSn());
            } else {
               if (moveOutboundDetail.getQuantity() != null) {
                  materialFreeze.setTotalQuantity(
                     outQuantity != null
                        ? materialFreeze.getTotalQuantity().add(outQuantity)
                        : materialFreeze.getTotalQuantity().add(moveOutboundDetail.getQuantity())
                  );
               }

               freezeTypes.add(MaterialFreezeTypeEnum.OUTBOUND.getType());
               materialFreeze.setTotalFreezeTypes(StrUtil.join(",", freezeTypes));
               materialFreeze.setTotalMete(materialFreeze.getTotalMete().add(outMete));
            }

            this.materialFreezeService.updateById(materialFreeze);
         }

         materialFreezeRecord.setMaterialFreezeId(materialFreeze.getId());
         this.materialFreezeRecordMapper.insert(materialFreezeRecord);
         if (!materialInventory.getBoolHasFrozen()) {
            this.materialInventoryMapper.updateBoolHasFrozen(materialInventory.getId(), true);
         }
      }
   }

   @Override
   public Outbound saveOutbound(List<WmsShipmentReceiveApproveDetailDTOParam> params, OutboundTypeEnum outboundType, boolean boolPartyA) {
      Outbound outbound = Outbound.builder()
         .applicantId(UserUtil.getCurrentUserId())
         .applicantName(UserUtil.getCurrentName())
         .userUpdateTime(LocalDateTime.now())
         .outboundStartTime(LocalDateTime.now())
         .outboundEndTime(LocalDateTime.now())
         .boolPartyA(boolPartyA)
         .outboundTypeSelection(outboundType.getType())
         .reviewStatus(ReviewStatusEnum.AUDITING.getType())
         .build();
      String serviceNumber = this.numberConfigService.getNumber(NumberTypeEnum.OUTBOUND_APPLY, this.baseMapper.getCount(LocalDateTime.now()));
      outbound.setApplicationSn(serviceNumber);
      this.baseMapper.insert(outbound);
      this.saveOutboundDetail(outbound, params);
      this.baseMapper.updateById(outbound);
      return outbound;
   }

   private void saveOutboundDetail(Outbound outbound, List<WmsShipmentReceiveApproveDetailDTOParam> params) {
      for (WmsShipmentReceiveApproveDetailDTOParam param : params) {
         MaterialInventory materialInventory = this.materialInventoryMapper.selectById(param.getMaterialId());
         Preconditions.checkArgument(materialInventory != null, "仓库中不存在该物料");
         Measure measure = this.measureMapper
            .selectOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, materialInventory.getClassifyId()));
         SubjectMeasureDTO subjectMeasureDTO = this.measureService.measureListById(materialInventory.getClassifyId());
         WasteConfig scrapDefinitionConf = this.basicConfigService.getSteelScrapDefinitionConf();
         BasicOutbound outboundBasicConf = this.basicConfigService.getOutboundBasicConf();
         MoveOutboundDetail moveOutboundDetail = MoveOutboundDetail.builder()
            .warehouseId(materialInventory.getWarehouseId())
            .materialIsWhole(materialInventory.getMaterialIsWhole())
            .workshopId(param.getMesWorkshopId())
            .sourceWorkshopId(materialInventory.getWorkshopId())
            .materialInventoryId(materialInventory.getId())
            .outboundId(outbound.getId())
            .basicClass(materialInventory.getBasicClass())
            .classifyId(materialInventory.getClassifyId())
            .specification(materialInventory.getSpecification())
            .sourceProjectId(materialInventory.getProjectId())
            .sourceMonomerId(materialInventory.getMonomerId())
            .sourceAreaId(materialInventory.getAreaId())
            .thickness(materialInventory.getThickness())
            .theoryThickness(materialInventory.getTheoryThickness())
            .heatNoAndBatchNo(materialInventory.getHeatNoAndBatchNo())
            .brand(materialInventory.getBrand())
            .outboundTime(LocalDateTime.now())
            .color(materialInventory.getColor())
            .recipientId(param.getRecipientId())
            .outboundMode(MaterialOutboundModeEnum.WHOLE.getType())
            .boolPartyA(materialInventory.getBoolPartyA())
            .taxRate(materialInventory.getTaxRate())
            .invoiceType(materialInventory.getInvoiceType())
            .standardId(materialInventory.getStandardId())
            .standardName(materialInventory.getStandardName())
            .materialSn(materialInventory.getSerialNumber())
            .outboundAddress(param.getOutboundAddress())
            .shipmentDetailId(param.getDetailId())
            .outboundTypeSelection(outbound.getOutboundTypeSelection())
            .remark(param.getRemark())
            .build();
         MaterialFreeze materialFreeze = this.materialFreezeService
            .getOne((Wrapper<MaterialFreeze>)Wrappers.<MaterialFreeze>lambdaQuery().eq(MaterialFreeze::getMaterialInventoryId, materialInventory.getId()));
         MaterialFreezeRecord freezeRecord = null;
         Set<Integer> freezeTypes = null;
         BigDecimal freezeTotalMete;
         BigDecimal freezeTotalQuantity;
         if (materialFreeze != null) {
            freezeTotalMete = materialFreeze.getTotalMete();
            freezeTotalQuantity = materialFreeze.getTotalQuantity();
            freezeTypes = Arrays.stream(materialFreeze.getTotalFreezeTypes().split(",")).map(Integer::parseInt).collect(Collectors.toSet());
         } else {
            freezeTotalMete = BigDecimal.ZERO;
            freezeTotalQuantity = BigDecimal.ZERO;
         }

         BigDecimal outMete = null;
         BigDecimal outQuantity = null;
         if (param.getProjectId() != null) {
            if (materialInventory.getBoolPartyA()) {
               Preconditions.checkArgument(materialInventory.getProjectId().equals(param.getProjectId()), "出库失败,甲供物料不能出库到其他项目.");
            }

            if (!outboundBasicConf.getBoolCanOutToOtherProject() && materialInventory.getProjectId() != null) {
               Preconditions.checkArgument(materialInventory.getProjectId().equals(param.getProjectId()), "当前出库项目与物料项目不一致,请核对.");
            }

            if (materialInventory.getProjectId() != null) {
               moveOutboundDetail.setOutboundRelationType(
                  materialInventory.getProjectId().equals(param.getProjectId())
                     ? OutboundRelationTypeEnum.ROUTINE.getType()
                     : OutboundRelationTypeEnum.TRANSFER.getType()
               );
            }

            moveOutboundDetail.setProjectId(param.getProjectId());
         }

         if (param.getProjectId() == null && materialInventory.getProjectId() != null) {
            moveOutboundDetail.setProjectId(materialInventory.getProjectId());
            moveOutboundDetail.setMonomerId(materialInventory.getMonomerId());
            moveOutboundDetail.setAreaId(materialInventory.getAreaId());
         }

         if (moveOutboundDetail.getProjectId() != null) {
            ContractProject project = this.contractProjectService.getById(moveOutboundDetail.getProjectId());
            Preconditions.checkArgument(
               moveOutboundDetail.getProjectId() != null && SettlementStatusEnum.UN_SETTLED.getType().equals(project.getSettlementStatus()), "出库失败,当前项目已结算"
            );
         }

         moveOutboundDetail.setOutboundType(MaterialOutboundModeEnum.WHOLE.getType());
         BigDecimal precision = UnitsPrecisionEnum.getByName(measure.getAccountingUnit());
         MeteAndQuantity meteAndQuantitySend = new MeteAndQuantity();
         meteAndQuantitySend.setSendQuantity(param.getQuantity());
         MeteAndQuantity meteAndQuantity = this.checkInventory(
            materialInventory.getBasicClass(),
            materialInventory.getClassifyId(),
            meteAndQuantitySend,
            materialInventory.getQuantity(),
            materialInventory.getMete(),
            freezeTotalQuantity,
            freezeTotalMete,
            subjectMeasureDTO,
            measure
         );
         BigDecimal sendQuantity = meteAndQuantity.getSendQuantity();
         if (BasicClassEnum.checkNotSteel(materialInventory.getBasicClass())) {
            if (measure.getOutboundUnitType() == null) {
               measure = this.getMeasured(materialInventory.getClassifyId());
            }

            if (MeasureTypeEnum.MEASURE.getType().equals(measure.getOutboundUnitType())) {
               moveOutboundDetail.setMete(CommonUtil.getStockOutboundMete(
                  sendQuantity, materialInventory.getQuantity().subtract(freezeTotalQuantity), materialInventory.getMete().subtract(freezeTotalMete)
               ));
               moveOutboundDetail.setQuantity(sendQuantity);
            } else {
               moveOutboundDetail.setMete(sendQuantity);
               if (materialInventory.getQuantity() != null) {
                  moveOutboundDetail.setQuantity(sendQuantity.divide(materialInventory.getUnitNet(), 8, this.ROUNDING));
               }
            }
         } else if (BasicClassEnum.STEEL_PLATE.getType().equals(materialInventory.getBasicClass())) {
            moveOutboundDetail.setQuantity(sendQuantity);
            moveOutboundDetail.setMete(
               CommonUtil.getStockOutboundMete(
                  sendQuantity, materialInventory.getQuantity().subtract(freezeTotalQuantity), materialInventory.getMete().subtract(freezeTotalMete)
               )
            );
            moveOutboundDetail.setLength(materialInventory.getLength());
            moveOutboundDetail.setWidth(materialInventory.getWidth());
            if (OutboundTypeEnum.PRODUCTION_USE.getType().equals(outbound.getOutboundTypeSelection())) {
               Classification classification = this.classificationService.getById(moveOutboundDetail.getClassifyId());
               BigDecimal oneTheoryMete = CommonUtil.getTheoryMete(
                  classification.getName(),
                  moveOutboundDetail.getLength(),
                  moveOutboundDetail.getWidth(),
                  moveOutboundDetail.getThickness(),
                  null,
                  classification.getId()
               );
               moveOutboundDetail.setActualTheoryWeight(
                  oneTheoryMete.multiply(moveOutboundDetail.getQuantity()).setScale(0, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(1000L))
               );
            }
         } else if (BasicClassEnum.SECTION_STEEL.getType().equals(materialInventory.getBasicClass())) {
            moveOutboundDetail.setMete(
               CommonUtil.getStockOutboundMete(
                  sendQuantity, materialInventory.getQuantity().subtract(freezeTotalQuantity), materialInventory.getMete().subtract(freezeTotalMete)
               )
            );
            moveOutboundDetail.setLength(materialInventory.getLength());
            moveOutboundDetail.setQuantity(sendQuantity);
         } else if (BasicClassEnum.COLOR_ROLL.getType().equals(materialInventory.getBasicClass())) {
            Preconditions.checkArgument(sendQuantity.compareTo(scrapDefinitionConf.getSteelCoilMinLength()) > 0, "出库失败,钢卷出库长度必须大于废料定义长度.");
            Preconditions.checkArgument(sendQuantity.compareTo(BigDecimal.TEN) >= 0, "钢卷出库长度不能小于10MM");
            moveOutboundDetail.setMete(
               CommonUtil.getStockOutboundMete(
                  sendQuantity, materialInventory.getQuantity().subtract(freezeTotalQuantity), materialInventory.getMete().subtract(freezeTotalMete)
               )
            );
            Preconditions.checkArgument(moveOutboundDetail.getMete().compareTo(BigDecimal.valueOf(1000L)) > 0, "出库失败,出库量必须大于1kg");
            moveOutboundDetail.setQuantity(sendQuantity);
            moveOutboundDetail.setWidth(materialInventory.getWidth());
         }

         outMete = moveOutboundDetail.getMete();
         if (moveOutboundDetail.getRecipientId() != null) {
            User user = this.userService.getById(moveOutboundDetail.getRecipientId());
            moveOutboundDetail.setRecipientName(user.getName());
            List<String> recipientName = StrUtil.isNotBlank(outbound.getRecipients())
               ? Arrays.stream(outbound.getRecipients().split(",")).collect(Collectors.toList())
               : new ArrayList<>();
            if (!recipientName.contains(user.getName())) {
               recipientName.add(user.getName());
            }

            outbound.setRecipients(StrUtil.join(",", recipientName));
         }

         if (moveOutboundDetail.getProjectId() != null) {
            if (StrUtil.isNotBlank(outbound.getProjectIds())) {
               List<Long> list = CommonUtil.spilt(outbound.getProjectIds(), ",");
               if (!list.contains(moveOutboundDetail.getProjectId())) {
                  outbound.setProjectIds(outbound.getProjectIds() + "," + moveOutboundDetail.getProjectId());
               }
            } else {
               outbound.setProjectIds(moveOutboundDetail.getProjectId() + "");
            }
         }

         this.moveOutboundDetailMapper.insert(moveOutboundDetail);
         param.setOutboundId(outbound.getId());
         param.setOutboundDetailId(moveOutboundDetail.getId());
         param.setOutboundQuantity(moveOutboundDetail.getQuantity());
         param.setOutboundMete(moveOutboundDetail.getMete());
         param.setUnitNet(moveOutboundDetail.getUnitNet());
         param.setWorkshopId(moveOutboundDetail.getSourceWorkshopId());
         param.setWarehouseId(moveOutboundDetail.getWarehouseId());
         outbound.setContainBasicClass(
            outbound.getContainBasicClass() != null ? outbound.getContainBasicClass() | moveOutboundDetail.getBasicClass() : moveOutboundDetail.getBasicClass()
         );
         Integer materialFreezeType = null;
         if (outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.SCHEDULING_OUTBOUND.getType())) {
            materialFreezeType = MaterialFreezeTypeEnum.SCHEDULING_OUTBOUND.getType();
         } else if (outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.CONSTRUCTION_SITE_USE.getType())) {
            materialFreezeType = MaterialFreezeTypeEnum.CONSTRUCTION_SITE_USE.getType();
         } else if (outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.PRODUCTION_USE.getType())) {
            materialFreezeType = Boolean.TRUE.equals(outbound.getBoolScheduling())
            ? MaterialFreezeTypeEnum.SCHEDULING_OUTBOUND.getType() : MaterialFreezeTypeEnum.OUTBOUND.getType();
         } else {
            Preconditions.checkArgument(false, "出库类型错误");
         }

         MaterialFreezeRecord materialFreezeRecord = MaterialFreezeRecord.builder()
            .freezeDetailId(moveOutboundDetail.getId())
            .freezeType(materialFreezeType)
            .freezeSourceId(outbound.getId())
            .freezeSourceSn(outbound.getApplicationSn())
            .operatorId(UserUtil.getCurrentUserId())
            .operatorName(UserUtil.getCurrentName())
            .mete(outMete != null ? outMete : moveOutboundDetail.getMete())
            .quantity(outQuantity != null ? outQuantity : moveOutboundDetail.getQuantity())
            .boolBatten(outQuantity != null)
            .projectId(moveOutboundDetail.getProjectId())
            .frozenTime(LocalDateTime.now())
            .outboundUnitType(measure.getOutboundUnitType())
            .build();
         if (materialFreeze == null) {
            materialFreeze = BeanUtil.copy(materialInventory, MaterialFreeze.class, "createTime");
            materialFreeze.setTotalQuantity(outQuantity != null ? outQuantity : moveOutboundDetail.getQuantity());
            materialFreeze.setTotalMete(outMete);
            materialFreeze.setTotalFreezeTypes(MaterialFreezeTypeEnum.OUTBOUND.getType() + "");
            materialFreeze.setMaterialInventoryId(materialInventory.getId());
            this.materialFreezeService.save(materialFreeze);
         } else {
            if (freezeRecord != null) {
               if (freezeRecord.getMete().compareTo(moveOutboundDetail.getMete()) < 0) {
                  materialFreezeRecord.setApplyPurchaseQuantity(freezeRecord.getQuantity());
                  materialFreezeRecord.setApplyPurchaseMete(freezeRecord.getMete());
               } else {
                  materialFreezeRecord.setApplyPurchaseQuantity(moveOutboundDetail.getQuantity());
                  materialFreezeRecord.setApplyPurchaseMete(moveOutboundDetail.getMete());
               }

               if (freezeRecord.getQuantity() != null) {
                  freezeRecord.setQuantity(freezeRecord.getQuantity().subtract(moveOutboundDetail.getQuantity()));
               }

               freezeRecord.setMete(freezeRecord.getMete().subtract(moveOutboundDetail.getMete()));
               if (freezeRecord.getMete().compareTo(BigDecimal.ZERO) <= 0) {
                  if (freezeRecord.getMete().compareTo(BigDecimal.ZERO) != 0) {
                     materialFreeze.setTotalQuantity(
                        freezeRecord.getQuantity() != null ? materialFreeze.getTotalQuantity().add(freezeRecord.getQuantity().negate()) : null
                     );
                     materialFreeze.setTotalMete(materialFreeze.getTotalMete().add(freezeRecord.getMete().negate()));
                  }

                  this.materialFreezeRecordMapper.deleteById(freezeRecord);
               } else {
                  this.materialFreezeRecordMapper.updateById(freezeRecord);
               }

               materialFreezeRecord.setBoolChangeOutbound(true);
               materialFreezeRecord.setApplyPurchaseId(freezeRecord.getFreezeSourceId());
               materialFreezeRecord.setApplyPurchaseDetailId(freezeRecord.getFreezeDetailId());
               materialFreezeRecord.setApplyPurchaseSn(freezeRecord.getFreezeSourceSn());
            } else {
               if (moveOutboundDetail.getQuantity() != null) {
                  materialFreeze.setTotalQuantity(
                     outQuantity != null
                        ? materialFreeze.getTotalQuantity().add(outQuantity)
                        : materialFreeze.getTotalQuantity().add(moveOutboundDetail.getQuantity())
                  );
               }

               freezeTypes.add(MaterialFreezeTypeEnum.OUTBOUND.getType());
               materialFreeze.setTotalFreezeTypes(StrUtil.join(",", freezeTypes));
               materialFreeze.setTotalMete(materialFreeze.getTotalMete().add(outMete));
            }

            this.materialFreezeService.updateById(materialFreeze);
         }

         materialFreezeRecord.setMaterialFreezeId(materialFreeze.getId());
         this.materialFreezeRecordMapper.insert(materialFreezeRecord);
         if (!materialInventory.getBoolHasFrozen()) {
            this.materialInventoryMapper.updateBoolHasFrozen(materialInventory.getId(), true);
         }
      }
   }

   private void returnOutboundInventory(Outbound outbound, Integer materialFreezeType) {
      Long oldId = outbound.getId();
      Outbound outboundInventory = this.baseMapper
         .selectOne(
            (Wrapper<Outbound>)((((Wrappers.<Outbound>lambdaQuery()
                           .eq(Outbound::getApplicantId, outbound.getApplicantId()))
                        .eq(Outbound::getBoolPartyA, outbound.getBoolPartyA()))
                     .eq(Outbound::getBoolScheduling, outbound.getBoolScheduling()))
                  .eq(Outbound::getOutboundTypeSelection, outbound.getOutboundTypeSelection()))
               .and(
                  o -> {
                     LambdaQueryWrapper var10000 = ((o.eq(
                              Outbound::getReviewStatus, ReviewStatusEnum.UN_REVIEWED.getType()
                           ))
                           .or())
                        .eq(Outbound::getReviewStatus, ReviewStatusEnum.NOT_SUBMITTED.getType());
                  }
               )
         );
      if (outboundInventory == null) {
         outboundInventory = BeanUtil.copy(outbound, Outbound.class);
         NumberTypeEnum numberTypeEnum = null;
         if (outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.PRODUCTION_USE.getType())
            || outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.CONSTRUCTION_SITE_USE.getType())) {
            numberTypeEnum = NumberTypeEnum.OUTBOUND_APPLY;
         } else if (outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.FOR_SALE.getType())) {
            numberTypeEnum = NumberTypeEnum.FOR_SALE;
         } else if (outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.TEMPORARY_LOAN.getType())) {
            numberTypeEnum = NumberTypeEnum.MANUFACTURES_BORROW;
         } else if (outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.OUTSOURCING_RAW_MATERIALS.getType())) {
            numberTypeEnum = NumberTypeEnum.OUTSOURCING_RAW_MATERIALS;
         } else if (outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.SCRAPS.getType())) {
            numberTypeEnum = NumberTypeEnum.SCRAPS;
         } else {
            Preconditions.checkArgument(false, "未知出库类型");
         }

         String serviceNumber = this.numberConfigService.getNumber(numberTypeEnum, this.baseMapper.getCount(LocalDateTime.now()));
         outboundInventory.setApplicationSn(serviceNumber);
         outboundInventory.setReviewerId(null);
         outboundInventory.setReviewerName(null);
         outboundInventory.setApproveRecordId(null);
         if (!outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.PRODUCTION_USE.getType())
            && !outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.TEMPORARY_LOAN.getType())
            && !outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.CONSTRUCTION_SITE_USE.getType())) {
            outboundInventory.setReviewStatus(ReviewStatusEnum.NOT_SUBMITTED.getType());
         } else {
            outboundInventory.setReviewStatus(ReviewStatusEnum.UN_REVIEWED.getType());
         }

         outboundInventory.setReviewTime(null);
         outboundInventory.setOutboundTime(null);
         outboundInventory.setUserUpdateTime(LocalDateTime.now());
         outboundInventory.setId(null);
         outboundInventory.setCreateTime(LocalDateTime.now());
         this.baseMapper.insert(outboundInventory);
      }

      Map<String, String> forSaleSerialNumberMap = new HashMap<>();
      if (!outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.PRODUCTION_USE.getType())
         && !outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.CONSTRUCTION_SITE_USE.getType())) {
         if (outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.FOR_SALE.getType())) {
            for (WmsForSale wmsForSale : this.wmsForSaleService
               .list((Wrapper<WmsForSale>)new LambdaQueryWrapper<WmsForSale>().eq(WmsForSale::getOutboundId, outbound.getId()))) {
               WmsForSale newWmsForSale = BeanUtil.copy(wmsForSale, WmsForSale.class);
               newWmsForSale.setId(null);
               newWmsForSale.setOutboundId(outboundInventory.getId());
               newWmsForSale.setOutboundSerialNumber(outboundInventory.getSerialNumber());
               NumberConfig numberConfig = this.numberConfigService
                  .getOne((Wrapper<NumberConfig>)new LambdaQueryWrapper<NumberConfig>().eq(NumberConfig::getType, NumberTypeEnum.FOR_SALE.getType()));
               String forSaleSerialNumber = null;

               List<WmsForSale> wmsForSales;
               do {
                  forSaleSerialNumber = this.createForSaleSerialNumber("for_sale_operation", numberConfig.getCode());
                  wmsForSales = this.wmsForSaleService.list((Wrapper<WmsForSale>)new LambdaQueryWrapper<WmsForSale>().eq(WmsForSale::getSerialNumber, forSaleSerialNumber));
               } while (!CollectionUtils.isEmpty(wmsForSales));

               newWmsForSale.setSerialNumber(forSaleSerialNumber);
               forSaleSerialNumberMap.put(wmsForSale.getSerialNumber(), forSaleSerialNumber);
               this.wmsForSaleService.save(newWmsForSale);
            }

            this.wmsForSaleService
               .update(
                  null,
                  (Wrapper<WmsForSale>)(new LambdaUpdateWrapper<WmsForSale>().eq(WmsForSale::getOutboundId, outbound.getId()))
                     .set(WmsForSale::getReviewStatus, outbound.getReviewStatus())
               );
         } else if (!outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.TEMPORARY_LOAN.getType())
            && !outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.OUTSOURCING_RAW_MATERIALS.getType())
            && !outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.SCRAPS.getType())) {
            Preconditions.checkArgument(false, "未知出库类型");
         }
      }

      for (MoveOutboundDetail moveOutboundDetail : this.moveOutboundDetailMapper
         .selectList((Wrapper<MoveOutboundDetail>)new LambdaQueryWrapper<MoveOutboundDetail>().eq(MoveOutboundDetail::getOutboundId, outbound.getId()))) {
         MoveOutboundDetail newMoveOutboundDetail = BeanUtil.copy(moveOutboundDetail, MoveOutboundDetail.class);
         newMoveOutboundDetail.setId(null);
         newMoveOutboundDetail.setCreateTime(LocalDateTime.now());
         newMoveOutboundDetail.setOutboundId(outboundInventory.getId());
         this.moveOutboundDetailMapper.insert(newMoveOutboundDetail);
         this.materialFreezeRecordMapper
            .update(
               null,
               (Wrapper<MaterialFreezeRecord>)((((((new LambdaUpdateWrapper<MaterialFreezeRecord>()
                                    .eq(MaterialFreezeRecord::getFreezeType, materialFreezeType))
                                 .eq(MaterialFreezeRecord::getFreezeSourceId, oldId))
                              .eq(MaterialFreezeRecord::getFreezeDetailId, moveOutboundDetail.getId()))
                           .set(MaterialFreezeRecord::getFreezeDetailId, newMoveOutboundDetail.getId()))
                        .set(MaterialFreezeRecord::getFreezeSourceId, outboundInventory.getId()))
                     .set(MaterialFreezeRecord::getFreezeSourceSn, outboundInventory.getApplicationSn()))
                  .set(BaseEntity::getUpdateTime, LocalDateTime.now())
            );
         if (!outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.PRODUCTION_USE.getType())
            && !outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.CONSTRUCTION_SITE_USE.getType())) {
            if (outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.FOR_SALE.getType())) {
               WmsForSaleDetail wmsForSaleDetail = this.wmsForSaleDetailService
                  .getOne((Wrapper<WmsForSaleDetail>)new LambdaQueryWrapper<WmsForSaleDetail>().eq(WmsForSaleDetail::getOutboundDetailId, moveOutboundDetail.getId()).exists(WmsForSaleDetailMapper.OUTBOUND_PARENT_EXISTS_SQL));
               wmsForSaleDetail.setId(null);
               wmsForSaleDetail.setOutboundDetailId(newMoveOutboundDetail.getId());
               wmsForSaleDetail.setCreateTime(LocalDateTime.now());
               wmsForSaleDetail.setForSaleSerialNumber(forSaleSerialNumberMap.get(wmsForSaleDetail.getForSaleSerialNumber()));
               this.wmsForSaleDetailService.save(wmsForSaleDetail);
            } else if (!outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.TEMPORARY_LOAN.getType())
               && !outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.OUTSOURCING_RAW_MATERIALS.getType())
               && !outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.SCRAPS.getType())) {
               Preconditions.checkArgument(false, "未知出库类型");
            }
         }
      }

      List<MoveOutboundDetail> moveOutboundDetailsAll = this.moveOutboundDetailMapper
         .selectList((Wrapper<MoveOutboundDetail>)new LambdaQueryWrapper<MoveOutboundDetail>().eq(MoveOutboundDetail::getOutboundId, outboundInventory.getId()));
      Integer containBasicClass = moveOutboundDetailsAll.stream().map(MoveOutboundDetail::getBasicClass).reduce((a, b) -> a | b).orElse(0);
      outboundInventory.setContainBasicClass(containBasicClass);
      this.outboundService.updateById(outboundInventory);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public synchronized Boolean submitReview(OutboundDTOParam param) {
      SecurityUser currentUser = UserUtil.getCurrentUser();
      Outbound outbound = this.baseMapper.selectById(param.getId());

      for (OutboundDetailDTO outboundDetailDTO : param.getList()) {
         this.moveOutboundDetailMapper
            .update(
               null,
               (Wrapper<MoveOutboundDetail>)(new LambdaUpdateWrapper<MoveOutboundDetail>().eq(MoveOutboundDetail::getId, outboundDetailDTO.getId()))
                  .set(MoveOutboundDetail::getOutboundTime, outboundDetailDTO.getOutboundTime())
            );
      }

      Preconditions.checkArgument(ObjectUtil.isNotEmpty(outbound), "出库单不存在请刷新页面");
      Preconditions.checkArgument(outbound.getApproveRecordId() == null, "该出库单已提交审核");
      MountMessageDTO mountMessageDTO = new MountMessageDTO();
      ArrayList<Integer> outboundType = new ArrayList<>();
      outboundType.add(outbound.getOutboundTypeSelection());
      mountMessageDTO.setOutboundType(outboundType);
      Integer approveProcessType = null;
      if (outbound.getBoolPartyA()) {
         approveProcessType = ApproveProcessTypeEnumV2.PARTY_A_SUPPLY_OUT.getType();
         mountMessageDTO.setOutboundType(null);
      } else {
         approveProcessType = ApproveProcessTypeEnumV2.SELF_BUYING_OUT.getType();
      }

      String subjoinMsg = null;
      List<String> subjoinMsgList = new ArrayList<>();
      List<MoveOutboundDetail> details = this.moveOutboundDetailMapper
         .selectList((Wrapper<MoveOutboundDetail>)new LambdaQueryWrapper<MoveOutboundDetail>().eq(MoveOutboundDetail::getOutboundId, outbound.getId()));
      List<Long> areaBatchIds = details.stream().map(MoveOutboundDetail::getAreaBatchId).filter(ObjectUtil::isNotEmpty).distinct().collect(Collectors.toList());
      List<Long> projectIds = details.stream().map(MoveOutboundDetail::getProjectId).filter(ObjectUtil::isNotEmpty).distinct().collect(Collectors.toList());
      if (projectIds.size() > 0) {
         List<ContractProject> projects = this.contractProjectService.listByIds(projectIds);
         Map<Long, List<PlanAreaBatch>> longListHashMap = new HashMap<>();
         if (areaBatchIds.size() > 0) {
            List<PlanAreaBatch> planAreaBatches = this.planAreaBatchService.listByIds(areaBatchIds);
            longListHashMap = planAreaBatches.stream().collect(Collectors.groupingBy(PlanAreaBatch::getProjectId));
         }

         for (ContractProject project : projects) {
            List<PlanAreaBatch> planAreaBatches = longListHashMap.get(project.getId());
            if (CollectionUtil.isNotEmpty(planAreaBatches)) {
               for (PlanAreaBatch planAreaBatch : planAreaBatches) {
                  String msg = project.getShortName() + "/" + planAreaBatch.getName();
                  subjoinMsgList.add(msg);
               }
            } else {
               subjoinMsgList.add(project.getShortName());
            }
         }
      }

      if (CollectionUtil.isNotEmpty(subjoinMsgList)) {
         subjoinMsg = JSONArray.toJSONString(subjoinMsgList);
      }

      List<Integer> nameStr2 = BasicClassEnum.getNameStr2(outbound.getContainBasicClass());
      Preconditions.checkArgument(nameStr2.size() == 1, "当前出库单存在多种材料类型的物料，请删除多余的物料，仅留一种材料类型的物料才可提交成功");
      List<Integer> materialType = new ArrayList<>();
      materialType.add(outbound.getContainBasicClass());
      mountMessageDTO.setMaterialType(materialType);
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService
         .createRecord(outbound.getId(), outbound.getApplicationSn(), approveProcessType, null, null, null, false, mountMessageDTO, subjoinMsg, null);
      outbound.setApproveRecordId(wmsApproveRecord.getId());
      outbound.setReviewStatus(ReviewStatusEnum.AUDITING.getType());
      outbound.setRemark(param.getRemark());
      if (wmsApproveRecord.getStatus().equals(ApproveRecordStatusEnum.END.getType())) {
         if (OutboundTypeEnum.PRODUCTION_USE.getType().equals(outbound.getOutboundTypeSelection())
            || OutboundTypeEnum.CONSTRUCTION_SITE_USE.getType().equals(outbound.getOutboundTypeSelection())) {
            this.baseMapper.updateById(outbound);
            return this.passed(param);
         }

         if (OutboundTypeEnum.FOR_SALE.getType().equals(outbound.getOutboundTypeSelection())) {
            OutboundDTOParam outboundDTOParam = cn.hutool.core.bean.BeanUtil.toBean(outbound, OutboundDTOParam.class);
            List<MoveOutboundDetail> moveOutboundDetails = this.moveOutboundDetailMapper
               .selectList((Wrapper<MoveOutboundDetail>)new LambdaQueryWrapper<MoveOutboundDetail>().eq(MoveOutboundDetail::getOutboundId, outbound.getId()));
            List<OutboundDetailDTO> outboundDetailDTOS = cn.hutool.core.bean.BeanUtil.copyToList(moveOutboundDetails, OutboundDetailDTO.class);
            outboundDTOParam.setList(outboundDetailDTOS);
            outbound = this.forSalePassed(outboundDTOParam, outbound, null, null);
            this.reviewForSale(outbound, currentUser, ReviewStatusEnum.REVIEWED.getType());
            outbound.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
            return this.outboundService.updateById(outbound);
         }

         if (!OutboundTypeEnum.TEMPORARY_LOAN.getType().equals(outbound.getOutboundTypeSelection())) {
            if (OutboundTypeEnum.OUTSOURCING_RAW_MATERIALS.getType().equals(outbound.getOutboundTypeSelection())) {
               this.outsourcingPassed(outbound);
            } else if (OutboundTypeEnum.SCRAPS.getType().equals(outbound.getOutboundTypeSelection())) {
               OutboundDTOParam outboundDTOParam = cn.hutool.core.bean.BeanUtil.toBean(outbound, OutboundDTOParam.class);
               List<MoveOutboundDetail> moveOutboundDetails = this.moveOutboundDetailMapper
                  .selectList((Wrapper<MoveOutboundDetail>)new LambdaQueryWrapper<MoveOutboundDetail>().eq(MoveOutboundDetail::getOutboundId, outbound.getId()));
               List<OutboundDetailDTO> outboundDetailDTOS = cn.hutool.core.bean.BeanUtil.copyToList(moveOutboundDetails, OutboundDetailDTO.class);
               outboundDTOParam.setList(outboundDetailDTOS);
               this.ScrapsPassed(outbound.getId());
            } else {
               Preconditions.checkArgument(false, "未知出库类型");
            }
         }
      }

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

      this.sysPushFlowConfigBiz
         .triggerFlow(
            NotificationServiceTriggerDTO.builder()
               .projectId(null)
               .dataId(outbound.getId())
               .userPhoneList(userPhoneList)
               .contentDetails(this.detailsUtils.getMaterialOutboundDetails(UserUtil.getCurrentUser().getName(), outbound.getApplicationSn()))
               .notificationTypeEnum(NotificationModuleTypeEnum.WMS_MATERIAL_OUTBOUND.getNotificationType())
               .userList(new ArrayList<>())
               .build()
         );
      return this.baseMapper.updateById(outbound) == 1;
   }

   private Boolean reviewForSale(Outbound outbound, SecurityUser currentUser, Integer reviewStatus) {
      for (WmsForSale forSale : this.wmsForSaleService.list((Wrapper<WmsForSale>)new LambdaQueryWrapper<WmsForSale>().eq(WmsForSale::getOutboundId, outbound.getId()))) {
         List<WmsForSaleDetail> wmsForSaleDetailList = this.wmsForSaleDetailService
            .list((Wrapper<WmsForSaleDetail>)new LambdaQueryWrapper<WmsForSaleDetail>().eq(WmsForSaleDetail::getForSaleSerialNumber, forSale.getSerialNumber()));
         BigDecimal amountSum = wmsForSaleDetailList.stream()
            .map(WmsForSaleDetail::getAmount)
            .filter(ObjectUtil::isNotEmpty)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal amountExcludingVatSum = wmsForSaleDetailList.stream()
            .map(WmsForSaleDetail::getAmountExcludingVat)
            .filter(ObjectUtil::isNotEmpty)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal inputVatSum = wmsForSaleDetailList.stream()
            .map(WmsForSaleDetail::getInputVat)
            .filter(ObjectUtil::isNotEmpty)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         forSale.setAmount(amountSum);
         forSale.setAmountExcludingVat(amountExcludingVatSum);
         forSale.setInputVat(inputVatSum);
         forSale.setProfitAmount(forSale.getSellAmount().subtract(amountSum));
         forSale.setProfitAmountExcludingVat(forSale.getSellAmountExcludingVat().subtract(amountExcludingVatSum));
         if (forSale.getInvoiceType().equals(InvoiceTypeEnum.SPECIAL.getType())) {
            forSale.setProfitInputVat(forSale.getSellInputVat().subtract(inputVatSum));
         }

         forSale.setReviewStatus(reviewStatus);
         forSale.setReviewerId(currentUser.getId());
         forSale.setReviewerName(currentUser.getName());
         AccumulativeTotalRecord accumulativeTotalRecord = new AccumulativeTotalRecord();
         accumulativeTotalRecord.setCreateTime(LocalDateTime.now());
         accumulativeTotalRecord.setAddValue(forSale.getProfitAmount());
         accumulativeTotalRecord.setAddValueExcludingVat(forSale.getProfitAmountExcludingVat());
         accumulativeTotalRecord.setAggregateType(AggregateTypeEnum.FOR_SALE_CV.getType());
         accumulativeTotalRecord.setDataId(forSale.getId());
         this.accumulativeTotalRecordService.save(accumulativeTotalRecord);
         AccumulativeTotal accumulativeTotal = this.accumulativeTotalService
            .getOne((Wrapper<AccumulativeTotal>)new LambdaQueryWrapper<AccumulativeTotal>().eq(AccumulativeTotal::getAggregateType, AggregateTypeEnum.FOR_SALE_CV.getType()));
         if (ObjectUtil.isEmpty(accumulativeTotal)) {
            accumulativeTotal = AccumulativeTotal.builder()
               .aggregateValue(accumulativeTotalRecord.getAddValue())
               .aggregateValueExcludingVat(accumulativeTotalRecord.getAddValueExcludingVat())
               .aggregateType(AggregateTypeEnum.FOR_SALE_CV.getType())
               .build();
            accumulativeTotal.setCreateTime(LocalDateTime.now());
            this.accumulativeTotalService.save(accumulativeTotal);
         } else {
            accumulativeTotal.setAggregateValue(accumulativeTotal.getAggregateValue().add(accumulativeTotalRecord.getAddValue()));
            accumulativeTotal.setAggregateValueExcludingVat(
               accumulativeTotal.getAggregateValueExcludingVat().add(accumulativeTotalRecord.getAddValueExcludingVat())
            );
            accumulativeTotal.setUpdateTime(LocalDateTime.now());
            this.accumulativeTotalService.updateById(accumulativeTotal);
         }

         this.wmsForSaleService.updateById(forSale);
      }

      return true;
   }

   @Override
   public Set<ProjectInfo> getOutsourcingProject() {
      List<Outbound> outbounds = this.baseMapper
         .selectList(
            (Wrapper<Outbound>)(new LambdaQueryWrapper<Outbound>()
                  .eq(Outbound::getOutboundTypeSelection, OutboundTypeEnum.OUTSOURCING_RAW_MATERIALS.getType()))
               .eq(Outbound::getReviewStatus, ReviewStatusEnum.REVIEWED.getType())
         );
      Set<ProjectInfo> projectInfos = new HashSet<>();

      for (Outbound outbound : outbounds) {
         for (MoveOutboundDetail moveOutboundDetail : this.moveOutboundDetailMapper
            .selectList((Wrapper<MoveOutboundDetail>)new LambdaQueryWrapper<MoveOutboundDetail>().eq(MoveOutboundDetail::getOutboundId, outbound.getId()))) {
            ContractProject contractProject = this.contractProjectService.getById(moveOutboundDetail.getProjectId());
            ProjectInfo projectInfo = ProjectInfo.builder()
               .id(contractProject.getId())
               .name(contractProject.getName())
               .shortName(contractProject.getShortName())
               .serialNumber(contractProject.getSerialNumber())
               .createTime(contractProject.getCreateTime())
               .build();
            projectInfos.add(projectInfo);
         }
      }

      return projectInfos;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean revocation(Long id) {
      SecurityUser currentUser = UserUtil.getCurrentUser();
      Outbound outbound = this.baseMapper.selectById(id);
      Preconditions.checkArgument(currentUser.getId().equals(outbound.getApplicantId()), "仅创建此出库单的人才可进行撤销操作");
      Preconditions.checkArgument(ReviewStatusEnum.AUDITING.getType().equals(outbound.getReviewStatus()), "只可在创建中才可撤销申请，撤销失败");
      if (ObjectUtil.isNotEmpty(outbound.getApproveRecordId())) {
         this.wmsApproveRecordService.revocation(outbound.getApproveRecordId());
      }

      Integer materialFreezeType = null;
      if (OutboundTypeEnum.PRODUCTION_USE.getType().equals(outbound.getOutboundTypeSelection())) {
         materialFreezeType = Boolean.TRUE.equals(outbound.getBoolScheduling())
            ? MaterialFreezeTypeEnum.SCHEDULING_OUTBOUND.getType() : MaterialFreezeTypeEnum.OUTBOUND.getType();
      } else if (OutboundTypeEnum.CONSTRUCTION_SITE_USE.getType().equals(outbound.getOutboundTypeSelection())) {
         materialFreezeType = MaterialFreezeTypeEnum.CONSTRUCTION_SITE_USE.getType();
      } else if (OutboundTypeEnum.FOR_SALE.getType().equals(outbound.getOutboundTypeSelection())) {
         materialFreezeType = MaterialFreezeTypeEnum.FOR_SALE.getType();
      } else if (OutboundTypeEnum.TEMPORARY_LOAN.getType().equals(outbound.getOutboundTypeSelection())) {
         materialFreezeType = MaterialFreezeTypeEnum.BORROW.getType();
      } else if (OutboundTypeEnum.OUTSOURCING_RAW_MATERIALS.getType().equals(outbound.getOutboundTypeSelection())) {
         materialFreezeType = MaterialFreezeTypeEnum.OUTSOURCING.getType();
      } else if (OutboundTypeEnum.SCRAPS.getType().equals(outbound.getOutboundTypeSelection())) {
         materialFreezeType = MaterialFreezeTypeEnum.SCRAPS.getType();
      } else {
         Preconditions.checkArgument(false, "未知出库类型");
      }

      this.fail(outbound.getId(), ReviewStatusEnum.CANCEL.getType(), materialFreezeType, true);
      return true;
   }

   private MeteAndQuantity checkInventory(
      Integer basicClass,
      Long classifyId,
      MeteAndQuantity meteAndQuantity,
      BigDecimal inventoryQuantity,
      BigDecimal inventoryMete,
      BigDecimal freezeTotalQuantity,
      BigDecimal freezeTotalMete,
      SubjectMeasureDTO subjectMeasureDTO,
      Measure measure
   ) {
      if (BasicClassEnum.checkNotSteel(basicClass)) {
         if (measure.getOutboundUnitType() == null) {
            measure = this.getMeasured(classifyId);
         }

         if (MeasureTypeEnum.MEASURE.getType().equals(measure.getOutboundUnitType())) {
            Map<Integer, BigDecimal> unitConversion = this.unitConversion(
               BigDecimal.ZERO, subjectMeasureDTO.getMeasureUnit(), subjectMeasureDTO.getMeasurePrecision()
            );
            inventoryQuantity = inventoryQuantity.subtract(freezeTotalQuantity);
            Preconditions.checkArgument(subjectMeasureDTO.getMeasurePrecision() != null, "计量精度为空, 请先设置计量精度");
            BigDecimal halfUpMete = inventoryQuantity.divide(unitConversion.get(2), subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP)
               .setScale(subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP);
            BigDecimal halfSendQuantity = meteAndQuantity.getSendQuantity()
               .divide(unitConversion.get(2), subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP)
               .setScale(subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP);
            Preconditions.checkArgument(halfSendQuantity.compareTo(halfUpMete) <= 0, "当前库存量不足,请重新操作");
            if (halfSendQuantity.compareTo(halfUpMete) > -1) {
               meteAndQuantity.setSendQuantity(inventoryQuantity);
            }
         } else {
            Map<Integer, BigDecimal> unitConversion = this.unitConversion(
               BigDecimal.ZERO, subjectMeasureDTO.getAccountingUnit(), subjectMeasureDTO.getAccountingPrecision()
            );
            inventoryMete = inventoryMete.subtract(freezeTotalMete);
            BigDecimal halfUpMete = inventoryMete.divide(unitConversion.get(2), subjectMeasureDTO.getAccountingPrecision(), RoundingMode.HALF_UP)
               .setScale(subjectMeasureDTO.getAccountingPrecision(), RoundingMode.HALF_UP);
            BigDecimal halfSendQuantity = meteAndQuantity.getSendQuantity()
               .divide(unitConversion.get(2), subjectMeasureDTO.getAccountingPrecision(), RoundingMode.HALF_UP)
               .setScale(subjectMeasureDTO.getAccountingPrecision(), RoundingMode.HALF_UP);
            Preconditions.checkArgument(halfSendQuantity.compareTo(halfUpMete) <= 0, "当前库存量不足,请重新操作");
            if (halfSendQuantity.compareTo(halfUpMete) > -1) {
               meteAndQuantity.setSendQuantity(inventoryMete);
            }
         }
      } else {
         Map<Integer, BigDecimal> unitConversion = this.unitConversion(
            BigDecimal.ZERO, subjectMeasureDTO.getMeasureUnit(), subjectMeasureDTO.getMeasurePrecision()
         );
         if (BasicClassEnum.STEEL_PLATE.getType().equals(basicClass)) {
            inventoryQuantity = inventoryQuantity.subtract(freezeTotalQuantity);
            BigDecimal halfUpMete = inventoryQuantity.divide(unitConversion.get(2), subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP)
               .setScale(subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP);
            BigDecimal halfSendQuantity = meteAndQuantity.getSendQuantity()
               .divide(unitConversion.get(2), subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP)
               .setScale(subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP);
            Preconditions.checkArgument(halfSendQuantity.compareTo(halfUpMete) <= 0, "当前库存量不足,请重新操作");
            if (halfSendQuantity.compareTo(halfUpMete) > -1) {
               meteAndQuantity.setSendQuantity(inventoryQuantity);
            }
         } else if (BasicClassEnum.SECTION_STEEL.getType().equals(basicClass)) {
            inventoryQuantity = inventoryQuantity.subtract(freezeTotalQuantity);
            BigDecimal halfUpMete = inventoryQuantity.divide(unitConversion.get(2), subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP)
               .setScale(subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP);
            BigDecimal halfSendQuantity = meteAndQuantity.getSendQuantity()
               .divide(unitConversion.get(2), subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP)
               .setScale(subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP);
            Preconditions.checkArgument(halfSendQuantity.compareTo(halfUpMete) <= 0, "当前库存量不足,请重新操作");
            if (halfSendQuantity.compareTo(halfUpMete) > -1) {
               meteAndQuantity.setSendQuantity(inventoryQuantity);
            }
         } else if (BasicClassEnum.COLOR_ROLL.getType().equals(basicClass)) {
            inventoryQuantity = inventoryQuantity.subtract(freezeTotalQuantity);
            BigDecimal halfUpMete = inventoryQuantity.divide(unitConversion.get(2), subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP)
               .setScale(subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP);
            BigDecimal halfSendQuantity = meteAndQuantity.getSendQuantity()
               .divide(unitConversion.get(2), subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP)
               .setScale(subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP);
            Preconditions.checkArgument(halfSendQuantity.compareTo(halfUpMete) <= 0, "当前库存量不足,请重新操作");
            if (halfSendQuantity.compareTo(halfUpMete) > -1) {
               meteAndQuantity.setSendQuantity(inventoryQuantity);
            }
         }
      }

      return meteAndQuantity;
   }

   private Map<Integer, BigDecimal> unitConversion(BigDecimal value, String unit, Integer scale) {
      Unit u = this.unitMapper.selectOne((Wrapper<Unit>)Wrappers.<Unit>lambdaQuery().eq(Unit::getName, unit));
      Map<Integer, BigDecimal> map = new HashMap<>();
      if (UnitEnum.DIGIT.getType().equals(u.getType())) {
         map.put(2, BigDecimal.ONE);
         map.put(1, new BigDecimal(value.stripTrailingZeros().toPlainString()));
      } else {
         BigDecimal precision = UnitsPrecisionEnum.getByName(unit);
         if (value != null && precision.compareTo(BigDecimal.ZERO) != 0) {
            map.put(1, value.divide(precision, scale, 4));
            map.put(2, precision);
         } else {
            map.put(1, BigDecimal.ZERO);
            map.put(2, precision);
         }
      }

      return map;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean BatchNestingDockingOutbound(BatchSchedulingOutboundDTOParam param) {
      SteelPlateOutboundDTOParam copy = BeanUtil.copy(param, SteelPlateOutboundDTOParam.class);
      List<OutboundDetailDTO> outboundDetailDTOS = new ArrayList<>();

      for (BatchSchedulingOutboundDetailDTOParam detailDTOParam : param.getList()) {
         BeanUtil.copy(detailDTOParam, copy);
         copy.setMaterialId(detailDTOParam.getId());
         copy.setMaterialOutboundMode(1);
         this.nestingDockingOutbound(copy);
         OutboundDetailDTO outboundDetailDTO = BeanUtil.copy(detailDTOParam, OutboundDetailDTO.class);
         outboundDetailDTOS.add(outboundDetailDTO);
      }

      OutboundDTOParam outboundDTOParam = BeanUtil.copy(copy, OutboundDTOParam.class);
      outboundDTOParam.setList(outboundDetailDTOS);
      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean saveNestingDockingOutbound(SteelPlateOutboundDTOParam param) {
      return true;
   }

   @Override
   public Boolean nestingDockingOutbound(SteelPlateOutboundDTOParam param) {
      Preconditions.checkArgument(param.getQuantity() != null && param.getQuantity().signum() > 0, "出库数量必须大于0");
      MaterialInventory materialInventory = this.materialInventoryMapper.selectById(param.getMaterialId());
      Preconditions.checkArgument(materialInventory != null, "仓库中不存在该物料");
      Measure measure = this.measureMapper
         .selectOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, materialInventory.getClassifyId()));
      WasteConfig scrapDefinitionConf = this.basicConfigService.getSteelScrapDefinitionConf();
      BasicOutbound outboundBasicConf = this.basicConfigService.getOutboundBasicConf();
      SubjectMeasureDTO subjectMeasureDTO = this.measureService.measureListById(materialInventory.getClassifyId());
      String accountingUnit = subjectMeasureDTO.getAccountingUnit();
      Integer accountingPrecision = subjectMeasureDTO.getAccountingPrecision();
      BigDecimal UnitsPrecision = UnitsPrecisionEnum.getByName(subjectMeasureDTO.getAccountingUnit());
      Outbound outbound = this.baseMapper
         .selectOne(
            ((((((Wrappers.<Outbound>lambdaQuery()
                                 .eq(Outbound::getApplicantId, UserUtil.getCurrentUserId()))
                              .eq(Outbound::getReviewStatus, ReviewStatusEnum.NOT_SUBMITTED.getType()))
                           .eq(param.getOutboundTypeSelection() != null, Outbound::getOutboundTypeSelection, param.getOutboundTypeSelection()))
                        .eq(Outbound::getBoolScheduling, Boolean.TRUE))
                     .eq(Outbound::getTaskOrderId, param.getTaskOrderId()))
                  .eq(param.getBoolPartyA() != null, Outbound::getBoolPartyA, param.getBoolPartyA()))
               .eq(param.getConvertId() != null, Outbound::getConvertId, param.getConvertId())
         );
      if (outbound != null) {
         outbound.setUserUpdateTime(LocalDateTime.now());
         param.setId(outbound.getId());
      } else {
         outbound = Outbound.builder()
            .applicantId(UserUtil.getCurrentUserId())
            .applicantName(UserUtil.getCurrentName())
            .userUpdateTime(LocalDateTime.now())
            .reviewStatus(ReviewStatusEnum.NOT_SUBMITTED.getType())
            .outboundStartTime(LocalDateTime.now())
            .outboundEndTime(LocalDateTime.now())
            .convertId(param.getConvertId())
            .boolPartyA(param.getBoolPartyA())
            .boolScheduling(Boolean.TRUE)
            .taskOrderId(param.getTaskOrderId())
            .taskOrderNumber(param.getTaskOrderNumber())
            .mesWorkshopId(param.getWorkshopId())
            .schedulingDataSource(SchedulingDataTypeEnum.MES_DATA.getType())
            .build();
         String serviceNumber = this.numberConfigService.getNumber(NumberTypeEnum.OUTBOUND_APPLY, this.baseMapper.getCount(LocalDateTime.now()));
         outbound.setApplicationSn(serviceNumber);
         this.baseMapper.insert(outbound);
         param.setId(outbound.getId());
      }

      MoveOutboundDetail moveOutboundDetail = MoveOutboundDetail.builder()
         .warehouseId(materialInventory.getWarehouseId())
         .materialIsWhole(materialInventory.getMaterialIsWhole())
         .workshopId(param.getWorkshopId())
         .sourceWorkshopId(materialInventory.getWorkshopId())
         .materialInventoryId(materialInventory.getId())
         .outboundId(outbound.getId())
         .basicClass(materialInventory.getBasicClass())
         .classifyId(materialInventory.getClassifyId())
         .specification(materialInventory.getSpecification())
         .sourceProjectId(materialInventory.getProjectId())
         .sourceMonomerId(materialInventory.getMonomerId())
         .sourceAreaId(materialInventory.getAreaId())
         .thickness(materialInventory.getThickness())
         .theoryThickness(materialInventory.getTheoryThickness())
         .heatNoAndBatchNo(materialInventory.getHeatNoAndBatchNo())
         .brand(materialInventory.getBrand())
         .outboundTime(param.getOutboundTime() != null ? param.getOutboundTime() : LocalDateTime.now())
         .color(materialInventory.getColor())
         .recipientId(param.getRecipientId())
         .outboundMode(param.getMaterialOutboundMode())
         .remark(param.getRemark())
         .boolPartyA(materialInventory.getBoolPartyA())
         .taxRate(materialInventory.getTaxRate())
         .invoiceType(materialInventory.getInvoiceType())
         .standardId(materialInventory.getStandardId())
         .standardName(materialInventory.getStandardName())
         .materialSn(materialInventory.getSerialNumber())
         .outboundAddress(param.getOutboundAddress())
         .boolScheduling(Boolean.TRUE)
         .taskOrderId(param.getTaskOrderId())
         .pickingDetailId(param.getPickingDetailId())
         .handlingArea(param.getHandlingArea())
         .build();
      MaterialFreeze materialFreeze = this.materialFreezeService
         .getOne((Wrapper<MaterialFreeze>)Wrappers.<MaterialFreeze>lambdaQuery().eq(MaterialFreeze::getMaterialInventoryId, materialInventory.getId()));
      MaterialFreezeRecord freezeRecord = null;
      Set<Integer> freezeTypes = null;
      BigDecimal freezeTotalMete;
      BigDecimal freezeTotalQuantity;
      if (materialFreeze != null) {
         freezeTotalMete = materialFreeze.getTotalMete();
         freezeTotalQuantity = materialFreeze.getTotalQuantity();
         freezeTypes = Arrays.stream(materialFreeze.getTotalFreezeTypes().split(",")).map(Integer::parseInt).collect(Collectors.toSet());
         if (freezeTypes.contains(MaterialFreezeTypeEnum.REQUISITIONS.getType())) {
            freezeRecord = this.materialFreezeRecordMapper
               .selectOne(
                  (Wrapper<MaterialFreezeRecord>)((Wrappers.<MaterialFreezeRecord>lambdaQuery()
                           .eq(MaterialFreezeRecord::getMaterialFreezeId, materialFreeze.getId()))
                        .eq(MaterialFreezeRecord::getFreezeType, MaterialFreezeTypeEnum.REQUISITIONS.getType()))
                     .eq(MaterialFreezeRecord::getProjectId, param.getProjectId())
               );
            if (freezeRecord != null) {
               freezeTotalMete = freezeTotalMete.subtract(freezeRecord.getMete());
               if (materialFreeze.getTotalQuantity() != null) {
                  freezeTotalQuantity = freezeTotalQuantity.subtract(freezeRecord.getQuantity());
               }
            }
         }
      } else {
         freezeTotalMete = BigDecimal.ZERO;
         freezeTotalQuantity = BigDecimal.ZERO;
      }

      BigDecimal outMete = null;
      BigDecimal outQuantity = null;
      if (param.getProjectId() != null) {
         if (materialInventory.getBoolPartyA()) {
            Preconditions.checkArgument(materialInventory.getProjectId().equals(param.getProjectId()), "出库失败,甲供物料不能出库到其他项目.");
         }

         if (!outboundBasicConf.getBoolCanOutToOtherProject() && materialInventory.getProjectId() != null) {
            Preconditions.checkArgument(materialInventory.getProjectId().equals(param.getProjectId()), "当前出库项目与物料项目不一致,请核对.");
         }

         if (materialInventory.getProjectId() != null) {
            moveOutboundDetail.setOutboundRelationType(
               materialInventory.getProjectId().equals(param.getProjectId())
                  ? OutboundRelationTypeEnum.ROUTINE.getType()
                  : OutboundRelationTypeEnum.TRANSFER.getType()
            );
         }

         moveOutboundDetail.setProjectId(param.getProjectId());
         moveOutboundDetail.setMonomerId(param.getMonomerId());
         moveOutboundDetail.setAreaId(param.getAreaId());
      }

      if (param.getProjectId() == null && materialInventory.getProjectId() != null) {
         moveOutboundDetail.setProjectId(materialInventory.getProjectId());
         moveOutboundDetail.setMonomerId(materialInventory.getMonomerId());
         moveOutboundDetail.setAreaId(materialInventory.getAreaId());
      }

      if (moveOutboundDetail.getProjectId() != null) {
         ContractProject project = this.contractProjectService.getById(moveOutboundDetail.getProjectId());
         Preconditions.checkArgument(
            moveOutboundDetail.getProjectId() != null && SettlementStatusEnum.UN_SETTLED.getType().equals(project.getSettlementStatus()), "出库失败,当前项目已结算"
         );
      }

      if (MaterialOutboundModeEnum.HALF.getType().equals(param.getMaterialOutboundMode())) {
         Preconditions.checkArgument(
            BasicClassEnum.checkIsSteel(materialInventory.getBasicClass()) && !BasicClassEnum.COLOR_ROLL.getType().equals(materialInventory.getBasicClass()),
            "该材料不能进行整料半出"
         );
         Preconditions.checkArgument(param.getHalfSize() != null && param.getHalfSize().compareTo(BigDecimal.ONE) >= 0, "半出截取长度不能小于1mm");
         Map<Integer, BigDecimal> unitConversion = this.unitConversion(
            BigDecimal.ZERO, subjectMeasureDTO.getMeasureUnit(), subjectMeasureDTO.getMeasurePrecision()
         );
         BigDecimal inventoryQuantity = materialInventory.getQuantity();
         BigDecimal sendQuantity = param.getQuantity();
         inventoryQuantity = inventoryQuantity.subtract(freezeTotalQuantity);
         BigDecimal halfUpMete = inventoryQuantity.divide(unitConversion.get(2), subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP)
            .setScale(subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP);
         BigDecimal halfSendQuantity = sendQuantity.divide(unitConversion.get(2), subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP)
            .setScale(subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP);
         Preconditions.checkArgument(halfSendQuantity.compareTo(halfUpMete) <= 0, "当前库存量不足,请重新操作");
         if (halfSendQuantity.compareTo(halfUpMete) > -1) {
            sendQuantity = inventoryQuantity;
         }

         moveOutboundDetail.setQuantity(sendQuantity);
         moveOutboundDetail.setHalfMode(1);
         if (BasicClassEnum.SECTION_STEEL.getType().equals(materialInventory.getBasicClass())) {
            Preconditions.checkArgument(!HalfModeEnum.WIDTH.getType().equals(param.getHalfMode()), "型材半出只能按长度截取");
            Preconditions.checkArgument(param.getHalfSize().compareTo(materialInventory.getLength()) < 0, "截取长度大于或等于型材定尺长度,请选择整料整出");
            moveOutboundDetail.setMete(
               CommonUtil.getStockOutboundMete(sendQuantity, materialInventory.getQuantity().subtract(freezeTotalQuantity), materialInventory.getMete().subtract(freezeTotalMete))
                  .multiply(param.getHalfSize()).divide(materialInventory.getLength(), 8, RoundingMode.DOWN)
            );
            moveOutboundDetail.setLength(param.getHalfSize());
         } else {
            moveOutboundDetail.setHalfMode(param.getHalfMode());
            if (HalfModeEnum.LENGTH.getType().equals(param.getHalfMode())) {
               Preconditions.checkArgument(param.getHalfSize().compareTo(materialInventory.getLength()) < 0, "截取长度大于或等于钢板长度,请选择整料整出");
               moveOutboundDetail.setLength(param.getHalfSize());
               moveOutboundDetail.setWidth(materialInventory.getWidth());
               moveOutboundDetail.setMete(
               CommonUtil.getStockOutboundMete(sendQuantity, materialInventory.getQuantity().subtract(freezeTotalQuantity), materialInventory.getMete().subtract(freezeTotalMete))
                  .multiply(param.getHalfSize()).divide(materialInventory.getLength(), 8, RoundingMode.DOWN)
            );
            } else {
               Preconditions.checkArgument(param.getHalfSize().compareTo(materialInventory.getWidth()) < 0, "截取宽度大于或等于钢板宽度,请选择整料整出");
               moveOutboundDetail.setLength(materialInventory.getLength());
               moveOutboundDetail.setWidth(param.getHalfSize());
               moveOutboundDetail.setMete(
               CommonUtil.getStockOutboundMete(sendQuantity, materialInventory.getQuantity().subtract(freezeTotalQuantity), materialInventory.getMete().subtract(freezeTotalMete))
                  .multiply(param.getHalfSize()).divide(materialInventory.getWidth(), 8, RoundingMode.DOWN)
            );
            }
         }

         Preconditions.checkArgument(moveOutboundDetail.getMete().compareTo(BigDecimal.valueOf(1000L)) > 0, "出库失败,出库量必须大于1kg");
         moveOutboundDetail.setOutboundType(MaterialOutboundModeEnum.HALF.getType());
         moveOutboundDetail.setHalfSize(param.getHalfSize());
         this.checkHalfOutputDimensions(moveOutboundDetail);
         outMete = CommonUtil.getStockOutboundMete(sendQuantity, materialInventory.getQuantity().subtract(freezeTotalQuantity), materialInventory.getMete().subtract(freezeTotalMete));
      } else {
         moveOutboundDetail.setOutboundType(MaterialOutboundModeEnum.WHOLE.getType());
         BigDecimal precision = UnitsPrecisionEnum.getByName(measure.getAccountingUnit());
         MeteAndQuantity meteAndQuantitySend = new MeteAndQuantity();
         meteAndQuantitySend.setSendQuantity(param.getQuantity());
         MeteAndQuantity meteAndQuantity = this.checkInventory(
            materialInventory.getBasicClass(),
            materialInventory.getClassifyId(),
            meteAndQuantitySend,
            materialInventory.getQuantity(),
            materialInventory.getMete(),
            freezeTotalQuantity,
            freezeTotalMete,
            subjectMeasureDTO,
            measure
         );
         BigDecimal sendQuantity = meteAndQuantity.getSendQuantity();
         if (BasicClassEnum.checkNotSteel(materialInventory.getBasicClass())) {
            if (measure.getOutboundUnitType() == null) {
               measure = this.getMeasured(materialInventory.getClassifyId());
            }

            if (MeasureTypeEnum.MEASURE.getType().equals(measure.getOutboundUnitType())) {
               moveOutboundDetail.setMete(CommonUtil.getStockOutboundMete(
                  sendQuantity, materialInventory.getQuantity().subtract(freezeTotalQuantity), materialInventory.getMete().subtract(freezeTotalMete)
               ));
               moveOutboundDetail.setQuantity(sendQuantity);
            } else {
               moveOutboundDetail.setMete(sendQuantity);
               if (materialInventory.getQuantity() != null) {
                  moveOutboundDetail.setQuantity(sendQuantity.divide(materialInventory.getUnitNet(), 8, this.ROUNDING));
               }
            }
         } else if (BasicClassEnum.STEEL_PLATE.getType().equals(materialInventory.getBasicClass())) {
            moveOutboundDetail.setQuantity(sendQuantity);
            BigDecimal outboundMete1 = CommonUtil.getOutboundMete1(
               UnitsPrecision, sendQuantity, materialInventory, freezeTotalMete, freezeTotalQuantity, accountingPrecision
            );
            moveOutboundDetail.setMete(outboundMete1);
            moveOutboundDetail.setLength(materialInventory.getLength());
            moveOutboundDetail.setWidth(materialInventory.getWidth());
         } else if (BasicClassEnum.SECTION_STEEL.getType().equals(materialInventory.getBasicClass())) {
            BigDecimal outboundMete1 = CommonUtil.getOutboundMete1(
               UnitsPrecision, sendQuantity, materialInventory, freezeTotalMete, freezeTotalQuantity, accountingPrecision
            );
            moveOutboundDetail.setMete(outboundMete1);
            moveOutboundDetail.setLength(materialInventory.getLength());
            moveOutboundDetail.setQuantity(sendQuantity);
         } else if (BasicClassEnum.COLOR_ROLL.getType().equals(materialInventory.getBasicClass())) {
            Preconditions.checkArgument(sendQuantity.compareTo(scrapDefinitionConf.getSteelCoilMinLength()) > 0, "出库失败,钢卷出库长度必须大于废料定义长度.");
            Preconditions.checkArgument(sendQuantity.compareTo(BigDecimal.TEN) >= 0, "钢卷出库长度不能小于10MM");
            BigDecimal outboundMete1 = CommonUtil.getOutboundMete1(
               UnitsPrecision, sendQuantity, materialInventory, freezeTotalMete, freezeTotalQuantity, accountingPrecision
            );
            moveOutboundDetail.setMete(outboundMete1);
            Preconditions.checkArgument(moveOutboundDetail.getMete().compareTo(BigDecimal.valueOf(1000L)) > 0, "出库失败,出库量必须大于1kg");
            moveOutboundDetail.setQuantity(sendQuantity);
            moveOutboundDetail.setWidth(materialInventory.getWidth());
         }

         outMete = moveOutboundDetail.getMete();
      }

      if (moveOutboundDetail.getRecipientId() != null) {
         User user = this.userService.getById(moveOutboundDetail.getRecipientId());
         moveOutboundDetail.setRecipientName(user.getName());
         List<String> recipientName = StrUtil.isNotBlank(outbound.getRecipients())
            ? Arrays.stream(outbound.getRecipients().split(",")).collect(Collectors.toList())
            : new ArrayList<>();
         if (!recipientName.contains(user.getName())) {
            recipientName.add(user.getName());
         }

         outbound.setRecipients(StrUtil.join(",", recipientName));
      }

      if (moveOutboundDetail.getProjectId() != null) {
         if (StrUtil.isNotBlank(outbound.getProjectIds())) {
            List<Long> list = CommonUtil.spilt(outbound.getProjectIds(), ",");
            if (!list.contains(moveOutboundDetail.getProjectId())) {
               outbound.setProjectIds(outbound.getProjectIds() + "," + moveOutboundDetail.getProjectId());
            }
         } else {
            outbound.setProjectIds(moveOutboundDetail.getProjectId() + "");
         }
      }

      this.moveOutboundDetailMapper.insert(moveOutboundDetail);
      outbound.setContainBasicClass(
         outbound.getContainBasicClass() != null ? outbound.getContainBasicClass() | moveOutboundDetail.getBasicClass() : moveOutboundDetail.getBasicClass()
      );
      MaterialFreezeRecord materialFreezeRecord = MaterialFreezeRecord.builder()
         .freezeDetailId(moveOutboundDetail.getId())
         .freezeType(MaterialFreezeTypeEnum.SCHEDULING_OUTBOUND.getType())
         .freezeSourceId(outbound.getId())
         .freezeSourceSn(outbound.getApplicationSn())
         .operatorId(UserUtil.getCurrentUserId())
         .operatorName(UserUtil.getCurrentName())
         .mete(outMete != null ? outMete : moveOutboundDetail.getMete())
         .quantity(outQuantity != null ? outQuantity : moveOutboundDetail.getQuantity())
         .boolBatten(outQuantity != null)
         .projectId(moveOutboundDetail.getProjectId())
         .frozenTime(LocalDateTime.now())
         .outboundUnitType(measure.getOutboundUnitType())
         .build();
      if (materialFreeze == null) {
         materialFreeze = BeanUtil.copy(materialInventory, MaterialFreeze.class, "createTime");
         materialFreeze.setTotalQuantity(outQuantity != null ? outQuantity : moveOutboundDetail.getQuantity());
         materialFreeze.setTotalMete(outMete);
         materialFreeze.setTotalFreezeTypes(MaterialFreezeTypeEnum.SCHEDULING_OUTBOUND.getType() + "");
         materialFreeze.setMaterialInventoryId(materialInventory.getId());
         this.materialFreezeService.save(materialFreeze);
      } else {
         if (freezeRecord != null) {
            if (freezeRecord.getMete().compareTo(moveOutboundDetail.getMete()) < 0) {
               materialFreezeRecord.setApplyPurchaseQuantity(freezeRecord.getQuantity());
               materialFreezeRecord.setApplyPurchaseMete(freezeRecord.getMete());
            } else {
               materialFreezeRecord.setApplyPurchaseQuantity(moveOutboundDetail.getQuantity());
               materialFreezeRecord.setApplyPurchaseMete(moveOutboundDetail.getMete());
            }

            if (freezeRecord.getQuantity() != null) {
               freezeRecord.setQuantity(freezeRecord.getQuantity().subtract(moveOutboundDetail.getQuantity()));
            }

            freezeRecord.setMete(freezeRecord.getMete().subtract(moveOutboundDetail.getMete()));
            if (freezeRecord.getMete().compareTo(BigDecimal.ZERO) <= 0) {
               if (freezeRecord.getMete().compareTo(BigDecimal.ZERO) != 0) {
                  materialFreeze.setTotalQuantity(
                     freezeRecord.getQuantity() != null ? materialFreeze.getTotalQuantity().add(freezeRecord.getQuantity().negate()) : null
                  );
                  materialFreeze.setTotalMete(materialFreeze.getTotalMete().add(freezeRecord.getMete().negate()));
               }

               this.materialFreezeRecordMapper.deleteById(freezeRecord);
            } else {
               this.materialFreezeRecordMapper.updateById(freezeRecord);
            }

            materialFreezeRecord.setBoolChangeOutbound(true);
            materialFreezeRecord.setApplyPurchaseId(freezeRecord.getFreezeSourceId());
            materialFreezeRecord.setApplyPurchaseDetailId(freezeRecord.getFreezeDetailId());
            materialFreezeRecord.setApplyPurchaseSn(freezeRecord.getFreezeSourceSn());
         } else {
            if (moveOutboundDetail.getQuantity() != null) {
               materialFreeze.setTotalQuantity(
                  outQuantity != null
                     ? materialFreeze.getTotalQuantity().add(outQuantity)
                     : materialFreeze.getTotalQuantity().add(moveOutboundDetail.getQuantity())
               );
            }

            freezeTypes.add(MaterialFreezeTypeEnum.SCHEDULING_OUTBOUND.getType());
            materialFreeze.setTotalFreezeTypes(StrUtil.join(",", freezeTypes));
            materialFreeze.setTotalMete(materialFreeze.getTotalMete().add(outMete));
         }

         this.materialFreezeService.updateById(materialFreeze);
      }

      materialFreezeRecord.setMaterialFreezeId(materialFreeze.getId());
      this.materialFreezeRecordMapper.insert(materialFreezeRecord);
      if (!materialInventory.getBoolHasFrozen()) {
         this.materialInventoryMapper.updateBoolHasFrozen(materialInventory.getId(), true);
      }

      return this.baseMapper.updateById(outbound) == 1;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean nestingDockingPassed(Long outboundId) {
      String currentName = UserUtil.getCurrentName();
      Long currentUserId = UserUtil.getCurrentUserId();
      LocalDateTime dateTime = LocalDateTime.now();
      Outbound outbound = this.baseMapper.selectById(outboundId);
      Preconditions.checkArgument(outbound != null, "出库单不存在,请核对后操作.");
      Preconditions.checkArgument(ReviewStatusEnum.AUDITING.getType().equals(outbound.getReviewStatus()), "出库单已审核,请核对后操作");
      outbound.setReviewerId(currentUserId);
      outbound.setReviewerId(currentUserId);
      outbound.setReviewerName(currentName);
      outbound.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
      outbound.setReviewTime(dateTime);
      outbound.setOutboundTime(dateTime);
      outbound.setUserUpdateTime(dateTime);
      String serviceNumber = this.numberConfigService.getNumber(NumberTypeEnum.OUTBOUND_REVIEW, this.baseMapper.getCount(LocalDateTime.now()));
      outbound.setSerialNumber(serviceNumber);
      Long statisticsId = null;
      MaterialInventory colorRollMaterial = null;
      outbound.setOutboundStartTime(null);
      outbound.setOutboundEndTime(null);
      WeightedPriceConf weightedPriceConf = JSON.parseObject(
         this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置")).getValue(), WeightedPriceConf.class
      );
      Map<String, Transfer> transferMap = new HashMap<>();
      Transfer transfer = null;

      for (MoveOutboundDetail outboundDetail : this.moveOutboundDetailMapper
         .selectList((Wrapper<MoveOutboundDetail>)Wrappers.<MoveOutboundDetail>lambdaQuery().eq(MoveOutboundDetail::getOutboundId, outbound.getId()))) {
         MaterialInventory materialInventory = this.materialInventoryMapper.selectById(outboundDetail.getMaterialInventoryId());
         Measure measure = this.measureMapper
            .selectOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, materialInventory.getClassifyId()));
         String accountingUnit = measure.getAccountingUnit();
         Integer accountingPrecision = measure.getAccountingPrecision();
         BigDecimal unitsPrecision = UnitsPrecisionEnum.getByName(measure.getAccountingUnit());
         MonthWeightedAveragePrice wap = this.weightedAveragePriceService.getPrice(materialInventory);
         outboundDetail.setWapId(wap.getId());
         BigDecimal reservedHalfMete = MaterialOutboundModeEnum.HALF.getType().equals(outboundDetail.getOutboundType())
            ? this.getHalfSourceMete(outbound, outboundDetail, materialInventory, MaterialFreezeTypeEnum.SCHEDULING_OUTBOUND.getType()) : null;
         this.materialFreezeService.materialUnfreeze(outbound.getId(), outboundDetail.getId(), MaterialFreezeTypeEnum.SCHEDULING_OUTBOUND.getType(), false);
         WasteConfig scrapDefinitionConf = this.basicConfigService.getSteelScrapDefinitionConf();
         StatisticsEndPeriod surplusEndPeriod = null;
         BigDecimal oneMete = BigDecimal.ZERO;
         if (MaterialOutboundModeEnum.HALF.getType().equals(outboundDetail.getOutboundType())) {
            BigDecimal outMete = reservedHalfMete;
            oneMete = materialInventory.getMete().divide(materialInventory.getQuantity(), 0, this.ROUNDING);
            materialInventory.setQuantity(materialInventory.getQuantity().subtract(outboundDetail.getQuantity()));
            materialInventory.setMete(materialInventory.getMete().subtract(outMete));
            BigDecimal length = materialInventory.getLength();
            BigDecimal width = materialInventory.getWidth();
            if (outboundDetail.getHalfMode() != null) {
               if (HalfModeEnum.LENGTH.getType().equals(outboundDetail.getHalfMode())) {
                  length = materialInventory.getLength().subtract(outboundDetail.getLength());
               } else {
                  width = materialInventory.getWidth().subtract(outboundDetail.getWidth());
               }
            }

            boolean isScrap;
            if (!BasicClassEnum.STEEL_PLATE.getType().equals(materialInventory.getBasicClass())) {
               isScrap = length.compareTo(scrapDefinitionConf.getSectionSteelMinLength()) <= 0;
            } else {
               isScrap = length.compareTo(scrapDefinitionConf.getSteelPlateShortestSideMinLength()) <= 0
                  || width.compareTo(scrapDefinitionConf.getSteelPlateShortestSideMinLength()) <= 0;
            }

            BigDecimal outboundRearMete = outMete.subtract(outboundDetail.getMete());
            if (isScrap) {
               Scrap scrap = BeanUtil.copy(materialInventory, Scrap.class, "createTime");
               scrap.setQuantity(outboundDetail.getQuantity());
               scrap.setMete(outboundRearMete);
               scrap.setLength(length);
               scrap.setWidth(width);
               scrap.setCreateTime(LocalDateTime.now());
               this.scrapMapper.insert(scrap);
            } else {
               MaterialInventory newMaterialInventory = BeanUtil.copy(materialInventory, MaterialInventory.class, "createTime");
               newMaterialInventory.setSourceMaterielId(materialInventory.getId());
               newMaterialInventory.setMaterialIsWhole(2);
               newMaterialInventory.setLength(length);
               newMaterialInventory.setWidth(width);
               newMaterialInventory.setQuantity(outboundDetail.getQuantity());
               newMaterialInventory.setCreateTime(dateTime);
               newMaterialInventory.setInventoryStartTime(dateTime);
               newMaterialInventory.setOutboundSn(outbound.getSerialNumber());
               newMaterialInventory.setMete(outboundRearMete);
               newMaterialInventory.setBoolHasFrozen(false);
               if (BasicClassEnum.STEEL_PLATE.getType().equals(materialInventory.getBasicClass())) {
                  newMaterialInventory.setOneTheoryWeight(
                     CommonUtil.getTheoryMete(
                        materialInventory.getClassifyName(),
                        newMaterialInventory.getLength(),
                        newMaterialInventory.getWidth(),
                        newMaterialInventory.getThickness(),
                        null,
                        materialInventory.getClassifyId()
                     )
                  );
               } else {
                  newMaterialInventory.setOneTheoryWeight(
                     CommonUtil.getTheoryMete(
                        null, newMaterialInventory.getLength(), null, null, newMaterialInventory.getSectionSteelWeight(), materialInventory.getClassifyId()
                     )
                  );
               }

               Print print = Print.builder()
                  .receiptId(outbound.getId())
                  .receiptSerialNumber(outbound.getSerialNumber())
                  .receiptReviewer(outbound.getReviewerName())
                  .receiptReviewTime(outbound.getReviewTime())
                  .receiptType(ReceiptTypeEnum.OUTBOUND.getType())
                  .type(MaterialLabelPrintTypeEnum.OUTBOUND.getType())
                  .totalNotPrintNumber(outboundDetail.getQuantity().intValue())
                  .projectIds(materialInventory.getProjectId() != null ? "" + materialInventory.getProjectId() : null)
                  .containBasicClass(materialInventory.getBasicClass())
                  .build();
               this.printService.save(print);
               String barcode = this.printService
                  .savePrint(
                     PrintDetail.builder()
                        .printId(print.getId())
                        .basicClass(outboundDetail.getBasicClass())
                        .classifyId(outboundDetail.getClassifyId())
                        .classifyName(materialInventory.getClassifyName())
                        .specification(outboundDetail.getSpecification())
                        .mete(outboundDetail.getMete())
                        .quantity(outboundDetail.getQuantity())
                        .brand(outboundDetail.getBrand())
                        .heatNoAndBatchNo(outboundDetail.getHeatNoAndBatchNo())
                        .warehouseId(outboundDetail.getWarehouseId())
                        .projectId(materialInventory.getProjectId())
                        .type(MaterialLabelPrintTypeEnum.OUTBOUND.getType())
                        .boolPartyA(outboundDetail.getBoolPartyA())
                        .length(outboundDetail.getLength())
                        .width(outboundDetail.getWidth())
                        .thickness(outboundDetail.getThickness())
                        .color(outboundDetail.getColor())
                        .notPrintNumber(
                           BasicClassEnum.COLOR_ROLL.getType().equals(newMaterialInventory.getBasicClass()) ? 1 : outboundDetail.getQuantity().intValue()
                        )
                        .standardId(newMaterialInventory.getStandardId())
                        .standardName(newMaterialInventory.getStandardName())
                        .materialIsWhole(newMaterialInventory.getMaterialIsWhole())
                        .monomerId(newMaterialInventory.getMonomerId())
                        .areaId(newMaterialInventory.getAreaId())
                        .build()
                  );
               newMaterialInventory.setBarcode(barcode);
               this.materialInventoryMapper.insert(newMaterialInventory);
               surplusEndPeriod = BeanUtil.copy(newMaterialInventory, StatisticsEndPeriod.class, "createTime");
               surplusEndPeriod.setMaterialInventoryId(newMaterialInventory.getId());
            }
         } else {
            materialInventory.setMete(materialInventory.getMete().subtract(outboundDetail.getMete()));
            materialInventory.setQuantity(outboundDetail.getQuantity() != null ? materialInventory.getQuantity().subtract(outboundDetail.getQuantity()) : null);
         }

         if (BasicClassEnum.COLOR_ROLL.getType().equals(materialInventory.getBasicClass())) {
            if (materialInventory.getQuantity().compareTo(BigDecimal.ZERO) > 0) {
               if (scrapDefinitionConf.getSteelCoilMinLength().compareTo(materialInventory.getQuantity()) >= 0) {
                  Scrap scrap = BeanUtil.copy(materialInventory, Scrap.class, "createTime");
                  scrap.setQuantity(materialInventory.getQuantity());
                  scrap.setMete(materialInventory.getMete());
                  scrap.setWidth(materialInventory.getWidth());
                  scrap.setCreateTime(LocalDateTime.now());
                  this.scrapMapper.insert(scrap);
                  this.materialInventoryMapper.deleteById(materialInventory);
                  this.wmsUtil
                     .setInventoryUse(materialInventory, scrap.getQuantity(), scrap.getMete(), ReceiptTypeEnum.SCRAP_MATERIAL, scrap.getId(), null, 1, false);
               } else {
                  this.materialInventoryMapper.updateById(materialInventory);
               }
            } else {
               this.materialInventoryMapper.deleteById(materialInventory);
            }
         } else if (materialInventory.getMete().compareTo(BigDecimal.ZERO) == 0) {
            this.materialInventoryMapper.deleteById(materialInventory);
         } else {
            if (materialInventory.getQuantity() != null) {
               materialInventory.setUseStatus(materialInventory.getQuantity().compareTo(BigDecimal.ZERO) == 0);
            }

            this.materialInventoryMapper.updateById(materialInventory);
         }

         this.wmsUtil
            .setInventoryUse(
               materialInventory,
               outboundDetail.getQuantity(),
               outboundDetail.getMete(),
               ReceiptTypeEnum.OUTBOUND,
               outbound.getId(),
               outbound.getSerialNumber(),
               2,
               true
            );
         Statistics statistics = this.statisticsMapper.get(materialInventory);
         this.setStatisticsEndPeriod(materialInventory, statistics);
         if (surplusEndPeriod != null) {
            surplusEndPeriod.setStatisticsId(statistics.getId());
            this.statisticsEndPeriodMapper.insert(surplusEndPeriod);
         }

         statisticsId = statistics.getId();
         long outPId = outboundDetail.getProjectId() != null ? outboundDetail.getProjectId() : -1L;
         long sourcePId = materialInventory.getProjectId() != null ? materialInventory.getProjectId() : -1L;
         if (outPId != sourcePId) {
            String key = outPId + "-" + materialInventory.getWorkshopId() + "-" + materialInventory.getWarehouseId();
            if (!transferMap.containsKey(key)) {
               transfer = Transfer.builder()
                  .basicClass(outboundDetail.getBasicClass())
                  .directionProjectId(outboundDetail.getProjectId())
                  .directionWorkshopId(materialInventory.getWorkshopId())
                  .directionWarehouseId(materialInventory.getWarehouseId())
                  .directionMonomerId(outboundDetail.getMonomerId())
                  .directionAreaId(outboundDetail.getAreaId())
                  .transferType(TransferTypeEnum.PROJECT_WARE.getType())
                  .reviewStatus(ReviewStatusEnum.REVIEWED.getType())
                  .applicantId(currentUserId)
                  .editorId(currentUserId)
                  .applicantName(currentName)
                  .editorName(currentName)
                  .reviewerName(currentName)
                  .reviewTime(dateTime)
                  .reviewerId(currentUserId)
                  .userUpdateTime(dateTime)
                  .transferCreateType(2)
                  .outboundSn(outbound.getSerialNumber())
                  .outboundId(outbound.getId())
                  .build();
               Integer count = this.transferMapper.getMaxDayNumber(LocalDateTime.now());
               String sn = this.numberConfigService.getNumber(NumberTypeEnum.TRANSFER, count);
               transfer.setSerialNumber(sn);
               this.transferMapper.insert(transfer);
               transferMap.put(key, transfer);
            } else {
               transfer = transferMap.get(key);
            }

            BigDecimal amount;
            BigDecimal amountExcludingVat;
            BigDecimal amountNoFreight;
            BigDecimal amountExcludingVatNoFreight;
            if (WeightedPriceEnum.SINGLE.getType().equals(weightedPriceConf.getWeightedType())) {
               BigDecimal p = outboundDetail.getMete().divide(wap.getMete(), 20, this.ROUNDING);
               amount = wap.getAmount().multiply(p).setScale(2, this.ROUNDING);
               amountExcludingVat = wap.getAmountExcludingVat().multiply(p).setScale(2, this.ROUNDING);
               amountNoFreight = wap.getAmountNoFreight().multiply(p).setScale(2, this.ROUNDING);
               amountExcludingVatNoFreight = wap.getAmountExcludingVatNoFreight().multiply(p).setScale(2, this.ROUNDING);
            } else {
               WholeWeightedAveragePrice price = this.wholeWAPMapper.getPrice(materialInventory);
               BigDecimal p = outboundDetail.getMete().divide(price.getMete(), 20, this.ROUNDING);
               amount = price.getAmount().multiply(p).setScale(2, this.ROUNDING);
               amountExcludingVat = price.getAmountExcludingVat().multiply(p).setScale(2, this.ROUNDING);
               amountNoFreight = price.getAmountNoFreight().multiply(p).setScale(2, this.ROUNDING);
               amountExcludingVatNoFreight = price.getAmountExcludingVatNoFreight().multiply(p).setScale(2, this.ROUNDING);
            }

            TransferDetail transferDetail = TransferDetail.builder()
               .boolPartyA(materialInventory.getBoolPartyA())
               .transferId(transfer.getId())
               .materialInventoryId(materialInventory.getId())
               .specification(materialInventory.getSpecification())
               .basicClass(materialInventory.getBasicClass())
               .length(materialInventory.getLength())
               .width(materialInventory.getWidth())
               .thickness(materialInventory.getThickness())
               .brand(materialInventory.getBrand())
               .heatNoAndBatchNo(materialInventory.getHeatNoAndBatchNo())
               .classifyId(materialInventory.getClassifyId())
               .transferType(TransferTypeEnum.PROJECT_WARE.getType())
               .sourceWarehouseId(materialInventory.getWarehouseId())
               .sourceProjectId(materialInventory.getProjectId())
               .sourceMonomerId(materialInventory.getMonomerId())
               .sourceAreaId(materialInventory.getAreaId())
               .mete(outboundDetail.getMete())
               .quantity(outboundDetail.getQuantity())
               .color(materialInventory.getColor())
               .remark(outboundDetail.getRemark())
               .taxRate(materialInventory.getTaxRate())
               .invoiceType(materialInventory.getInvoiceType())
               .standardId(materialInventory.getStandardId())
               .standardName(materialInventory.getStandardName())
               .build();
            if (amount.compareTo(BigDecimal.ZERO) != 0) {
               transferDetail.setUnitPrice(amount.divide(outboundDetail.getMete(), 12, RoundingMode.HALF_UP));
               transferDetail.setUnitPriceExcludingVat(amountExcludingVat.divide(outboundDetail.getMete(), 12, RoundingMode.HALF_UP));
            } else {
               transferDetail.setUnitPrice(BigDecimal.ZERO);
               transferDetail.setUnitPriceExcludingVat(BigDecimal.ZERO);
            }

            transferDetail.setAmount(amount);
            transferDetail.setAmountExcludingVat(amountExcludingVat);
            transferDetail.setInputVat(transferDetail.getAmount().subtract(transferDetail.getAmountExcludingVat()));
            if (amountNoFreight.compareTo(BigDecimal.ZERO) != 0) {
               transferDetail.setUnitPriceNoFreight(amountNoFreight.divide(outboundDetail.getMete(), 12, RoundingMode.HALF_UP));
               transferDetail.setUnitPriceExcludingVatNoFreight(amountExcludingVatNoFreight.divide(outboundDetail.getMete(), 12, RoundingMode.HALF_UP));
            } else {
               transferDetail.setUnitPriceNoFreight(BigDecimal.ZERO);
               transferDetail.setUnitPriceExcludingVatNoFreight(BigDecimal.ZERO);
            }

            transferDetail.setAmountNoFreight(amountNoFreight);
            transferDetail.setAmountExcludingVatNoFreight(amountExcludingVatNoFreight);
            transferDetail.setInputVatNoFreight(transferDetail.getAmountNoFreight().subtract(transferDetail.getAmountExcludingVatNoFreight()));
            this.transferDetailMapper.insert(transferDetail);
            if (transferDetail.getQuantity() != null && outboundDetail.getHalfMode() == null) {
               wap.setQuantity(wap.getQuantity().subtract(transferDetail.getQuantity()));
            }

            wap.setMete(wap.getMete().subtract(transferDetail.getMete()));
            if (WeightedPriceEnum.SINGLE.getType().equals(weightedPriceConf.getWeightedType())) {
               wap.setAmount(wap.getAmount().subtract(amount));
               wap.setAmountExcludingVat(wap.getAmountExcludingVat().subtract(amountExcludingVat));
            }

            this.monthWeightedAveragePriceMapper.updateById(wap);
            statistics.setInboundMete(
               statistics.getInboundMete() != null ? statistics.getInboundMete().subtract(transferDetail.getMete()) : transferDetail.getMete().negate()
            );
            if (transferDetail.getQuantity() != null) {
               statistics.setInboundQuantity(
                  statistics.getInboundQuantity() != null
                     ? statistics.getInboundQuantity().subtract(transferDetail.getQuantity())
                     : transferDetail.getQuantity().negate()
               );
            }

            statistics.setInboundUnitPrice(transferDetail.getUnitPrice());
            statistics.setInboundUnitPriceExcludingVat(transferDetail.getUnitPriceExcludingVat());
            statistics.setInboundAmount(statistics.getInboundAmount() != null ? statistics.getInboundAmount().subtract(amount) : amount.negate());
            statistics.setInboundAmountExcludingVat(
               statistics.getInboundAmountExcludingVat() != null
                  ? statistics.getInboundAmountExcludingVat().subtract(amountExcludingVat)
                  : amountExcludingVat.negate()
            );
            StatisticsInbound si = BeanUtil.copy(materialInventory, StatisticsInbound.class, "createTime");
            si.setMaterialInventoryId(materialInventory.getId());
            si.setReceiptType(ReceiptTypeEnum.TRANSFER.getType());
            si.setReceiptId(transfer.getId());
            si.setReceiptSerialNumber(transfer.getSerialNumber());
            si.setStatisticsId(statistics.getId());
            si.setMete(transferDetail.getMete().negate());
            if (materialInventory.getQuantity() != null) {
               si.setQuantity(transferDetail.getQuantity().negate());
            }

            si.setUnitPrice(transferDetail.getUnitPrice());
            si.setUnitPriceExcludingVat(transferDetail.getUnitPriceExcludingVat());
            si.setAmount(transferDetail.getAmount().negate());
            si.setAmountExcludingVat(transferDetail.getAmountExcludingVat().negate());
            si.setUnitPriceNoFreight(transferDetail.getUnitPriceNoFreight());
            si.setUnitPriceExcludingVatNoFreight(transferDetail.getUnitPriceExcludingVatNoFreight());
            si.setAmountNoFreight(transferDetail.getAmountNoFreight().negate());
            si.setAmountExcludingVatNoFreight(transferDetail.getAmountExcludingVatNoFreight().negate());
            this.statisticsInboundMapper.insert(si);
            MaterialInventory inventory = BeanUtil.copy(materialInventory, MaterialInventory.class);
            inventory.setId(-1L);
            inventory.setProjectId(outboundDetail.getProjectId());
            InboundDetail inboundDetail = InboundDetail.builder()
               .basicClass(inventory.getBasicClass())
               .classifyId(inventory.getClassifyId())
               .accountingUnit(inventory.getAccountingUnit())
               .length(inventory.getLength())
               .width(inventory.getWidth())
               .thickness(inventory.getThickness())
               .brand(inventory.getBrand())
               .heatNoAndBatchNo(inventory.getHeatNoAndBatchNo())
               .specification(inventory.getSpecification())
               .color(inventory.getColor())
               .unitNet(inventory.getUnitNet())
               .quantity(outboundDetail.getQuantity())
               .mete(outboundDetail.getMete())
               .workshopId(transfer.getDirectionWorkshopId())
               .warehouseId(transfer.getDirectionWarehouseId())
               .measureUnit(inventory.getMeasureUnit())
               .taxRate(inventory.getTaxRate())
               .invoiceType(inventory.getInvoiceType())
               .standardName(inventory.getStandardName())
               .standardId(inventory.getStandardId())
               .oneTheoryWeight(inventory.getOneTheoryWeight())
               .sectionSteelWeight(inventory.getSectionSteelWeight())
               .boolPartyA(inventory.getBoolPartyA())
               .amount(amount)
               .amountExcludingVat(amountExcludingVat)
               .unitPrice(transferDetail.getUnitPrice())
               .unitPriceExcludingVat(transferDetail.getUnitPriceExcludingVat())
               .amountNoFreight(amountNoFreight)
               .amountExcludingVatNoFreight(amountExcludingVatNoFreight)
               .unitPriceNoFreight(transferDetail.getUnitPriceNoFreight())
               .unitPriceExcludingVatNoFreight(transferDetail.getUnitPriceExcludingVatNoFreight())
               .projectId(outboundDetail.getProjectId())
               .build();
            Statistics targetStatistics = this.weightedAveragePriceService
               .createMonthWAP(inboundDetail, inventory, transfer.getId(), transfer.getSerialNumber(), ReceiptTypeEnum.TRANSFER.getType());
            targetStatistics.setOutboundMete(
               targetStatistics.getOutboundMete() != null ? targetStatistics.getOutboundMete().add(outboundDetail.getMete()) : outboundDetail.getMete()
            );
            targetStatistics.setOutboundQuantity(
               targetStatistics.getOutboundQuantity() != null
                  ? targetStatistics.getOutboundQuantity().add(outboundDetail.getQuantity())
                  : outboundDetail.getQuantity()
            );
            targetStatistics.setEndMete(targetStatistics.getEndMete().subtract(outboundDetail.getMete()));
            if (targetStatistics.getEndQuantity() != null) {
               targetStatistics.setEndQuantity(targetStatistics.getEndQuantity().subtract(outboundDetail.getQuantity()));
            }

            this.statisticsMapper.updateById(targetStatistics);
            outboundDetail.setWapId(targetStatistics.getWapId());
            statisticsId = targetStatistics.getId();
         }

         if (statistics.getId().equals(statisticsId)) {
            statistics.setOutboundMete(
               statistics.getOutboundMete() != null ? outboundDetail.getMete().add(statistics.getOutboundMete()) : outboundDetail.getMete()
            );
            statistics.setOutboundQuantity(
               statistics.getOutboundQuantity() != null ? outboundDetail.getQuantity().add(statistics.getOutboundQuantity()) : outboundDetail.getQuantity()
            );
         }

         statistics.setEndMete(statistics.getEndMete().subtract(outboundDetail.getMete()));
         if (statistics.getEndQuantity() != null && surplusEndPeriod == null) {
            statistics.setEndQuantity(statistics.getEndQuantity().subtract(outboundDetail.getQuantity()));
         }

         this.statisticsMapper.updateById(statistics);
         this.saveStatisticsOutbound(outbound, outboundDetail, materialInventory, statisticsId);
         MaterialReturnable materialReturnable = MaterialReturnable.builder()
            .classifyId(materialInventory.getClassifyId())
            .classifyName(materialInventory.getClassifyName())
            .boolPartyA(materialInventory.getBoolPartyA())
            .outboundUnitType(measure.getOutboundUnitType())
            .basicClass(materialInventory.getBasicClass())
            .specification(materialInventory.getSpecification())
            .mete(outboundDetail.getMete())
            .accountingUnit(materialInventory.getAccountingUnit())
            .returnableMete(outboundDetail.getMete())
            .quantity(outboundDetail.getQuantity())
            .unitNet(materialInventory.getUnitNet())
            .length(outboundDetail.getLength())
            .width(outboundDetail.getWidth())
            .thickness(materialInventory.getThickness())
            .theoryThickness(materialInventory.getTheoryThickness())
            .brand(materialInventory.getBrand())
            .heatNoAndBatchNo(materialInventory.getHeatNoAndBatchNo())
            .color(materialInventory.getColor())
            .projectId(outboundDetail.getProjectId())
            .outboundId(outbound.getId())
            .outboundSn(outbound.getSerialNumber())
            .outboundDetailId(outboundDetail.getId())
            .warehouseId(materialInventory.getWarehouseId())
            .outboundTime(outboundDetail.getOutboundTime())
            .weightedAverageSpec(materialInventory.getWeightedAverageSpec())
            .taxRate(outboundDetail.getTaxRate())
            .invoiceType(outboundDetail.getInvoiceType())
            .boolReviewPending(false)
            .boolReturn(true)
            .standardId(materialInventory.getStandardId())
            .standardName(materialInventory.getStandardName())
            .sectionSteelWeight(materialInventory.getSectionSteelWeight())
            .oneTheoryWeight(materialInventory.getOneTheoryWeight())
            .materialSn(materialInventory.getSerialNumber())
            .monomerId(outboundDetail.getMonomerId())
            .areaId(outboundDetail.getAreaId())
            .workshopId(outboundDetail.getWorkshopId())
            .build();
         if (outboundDetail.getRecipientId() != null) {
            materialReturnable.setRecipientId(outboundDetail.getRecipientId());
            materialReturnable.setRecipientName(this.userService.getById(outboundDetail.getRecipientId()).getName());
         }

         if (MaterialIsWholeEnum.WHOLE.getType().equals(materialInventory.getMaterialIsWhole())) {
            if (outboundDetail.getOutboundType() == 1) {
               materialReturnable.setMaterialIsWhole(MaterialIsWholeEnum.WHOLE.getType());
            } else {
               materialReturnable.setMaterialIsWhole(MaterialIsWholeEnum.ODDMENT.getType());
            }
         } else {
            materialReturnable.setMaterialIsWhole(MaterialIsWholeEnum.ODDMENT.getType());
         }

         if (BasicClassEnum.SECTION_STEEL.getType().equals(materialInventory.getBasicClass())) {
            if (MaterialOutboundModeEnum.HALF.getType().equals(outboundDetail.getOutboundType())) {
               materialReturnable.setSingleReturnableLength(outboundDetail.getLength());
            } else {
               materialReturnable.setSingleReturnableLength(materialInventory.getLength());
            }
         }

         if (BasicClassEnum.COLOR_ROLL.getType().equals(materialInventory.getBasicClass())) {
            materialReturnable.setSingleMete(outboundDetail.getMete());
            materialReturnable.setSingleReturnableMete(outboundDetail.getMete());
         } else if (MeasureTypeEnum.MEASURE.getType().equals(measure.getOutboundUnitType())) {
            if (BasicClassEnum.SECTION_STEEL.getType().equals(materialInventory.getBasicClass())
               || BasicClassEnum.STEEL_PLATE.getType().equals(materialInventory.getBasicClass())) {
               BigDecimal singleMete = outboundDetail.getMete().divide(outboundDetail.getQuantity(), 8, RoundingMode.DOWN);
               BigDecimal multiply = singleMete;
               materialReturnable.setSingleMete(multiply);
               materialReturnable.setSingleReturnableMete(multiply);
            }
         } else {
            materialReturnable.setSingleMete(outboundDetail.getMete());
            materialReturnable.setSingleReturnableMete(outboundDetail.getMete());
         }

         this.materialReturnableMapper.insert(materialReturnable);
         this.moveOutboundDetailMapper.updateById(outboundDetail);
         this.warningService.updateStatus(materialInventory, 2);
      }

      if (colorRollMaterial != null) {
         BigDecimal outboundMete = outbound.getOutboundMete();
         BigDecimal outboundLength = outbound.getOutboundLength();
         colorRollMaterial.setMete(colorRollMaterial.getMete().subtract(outboundMete));
         colorRollMaterial.setQuantity(colorRollMaterial.getQuantity().subtract(outboundLength));
         if (colorRollMaterial.getQuantity().compareTo(BigDecimal.ZERO) > 0) {
            this.materialInventoryMapper.updateById(colorRollMaterial);
         } else {
            this.materialInventoryMapper.deleteById(colorRollMaterial);
         }

         this.wmsUtil
            .setInventoryUse(colorRollMaterial, outboundLength, outboundMete, ReceiptTypeEnum.OUTBOUND, outbound.getId(), outbound.getSerialNumber(), 2, true);
         Statistics statistics = this.statisticsMapper.selectById(statisticsId);
         this.setStatisticsEndPeriod(colorRollMaterial, statistics);
         statistics.setOutboundMete(statistics.getOutboundMete() != null ? outboundMete.add(statistics.getOutboundMete()) : outboundMete);
         statistics.setOutboundQuantity(statistics.getOutboundQuantity() != null ? outboundLength.add(statistics.getOutboundQuantity()) : outboundLength);
         statistics.setEndMete(statistics.getEndMete().subtract(outboundMete));
         statistics.setEndQuantity(statistics.getEndQuantity().subtract(outboundLength));
         this.statisticsMapper.updateById(statistics);
      }

      return this.baseMapper.updateById(outbound) == 1;
   }

   @Override
   public PageVO<OutboundListDTO> nestingDockingPageInfo(QueryOutboundDTOParam param, Integer pageNum, Integer size, List<String> sort) {
      String s = StringUtils.analyzeSortConditions(sort);
      PageInfo<Outbound> pageInfo = PageHelper.<Outbound>startPage(pageNum, size, s).doSelectPageInfo(() -> this.nestingDockingListInfo(param));
      List<OutboundListDTO> collect = pageInfo.getList()
         .stream()
         .map(
            outbound -> {
               OutboundListDTO listDTO = BeanUtil.copy(outbound, OutboundListDTO.class);
               listDTO.setOutboundEarliestTime(outbound.getOutboundStartTime());
               listDTO.setOutboundLatestTime(outbound.getOutboundEndTime());
               List<MoveOutboundDetail> moveOutboundDetails = this.moveOutboundDetailMapper
                  .selectList((Wrapper<MoveOutboundDetail>)Wrappers.<MoveOutboundDetail>lambdaQuery().eq(MoveOutboundDetail::getOutboundId, outbound.getId()));
               List<ProjectInfoDTO> list = new ArrayList<>();

               for (Long id : moveOutboundDetails.stream().map(MoveOutboundDetail::getProjectId).collect(Collectors.toSet())) {
                  if (id != null) {
                     ProjectInfo projectInfo = this.contractProjectService.getSimpleById(id);
                     list.add(BeanUtil.copy(projectInfo, ProjectInfoDTO.class));
                  }
               }

               listDTO.setProjects(list);
               if (outbound.getMesWorkshopId() != null) {
                  MesBuildingWorkshop workshop = this.mesBuildingWorkshopService.getWorkshopById(outbound.getMesWorkshopId());
                  listDTO.setMesWorkshop(BriefIdAndNameDTO.builder().id(workshop.getId()).name(workshop.getName()).build());
               }

               listDTO.setBasicClass(outbound.getContainBasicClass());
               BigDecimal quantityCount = BigDecimal.ZERO;
               BigDecimal meteCount = BigDecimal.ZERO;

               for (MoveOutboundDetail moveOutboundDetail : moveOutboundDetails) {
                  if (moveOutboundDetail.getQuantity() != null) {
                     quantityCount = quantityCount.add(moveOutboundDetail.getQuantity());
                  }

                  meteCount = meteCount.add(moveOutboundDetail.getMete());
               }

               if (moveOutboundDetails.get(0).getRecipientId() != null) {
                  User user = this.userService.getById(moveOutboundDetails.get(0).getRecipientId());
                  listDTO.setScheduler(BriefIdAndNameDTO.builder().id(user.getId()).name(user.getName()).build());
               }

               listDTO.setQuantityCount(quantityCount);
               listDTO.setMeteCount(meteCount);
               listDTO.setApplicationSN(outbound.getApplicationSn());
               return listDTO;
            }
         )
         .collect(Collectors.toList());
      return new PageVO<>(pageInfo, collect);
   }

   @Override
   public List<Outbound> nestingDockingListInfo(QueryOutboundDTOParam param) {
      return this.baseMapper.getNestingDockingOutboundList(param);
   }

   @Override
   public OutboundDTO nestingDockingGetById(Long id) {
      Outbound outbound = this.baseMapper.selectById(id);
      Preconditions.checkArgument(outbound != null, "出库单不存在");
      OutboundDTO outboundDTO = BeanUtil.copy(outbound, OutboundDTO.class, "");
      outboundDTO.setApplicantSN(outbound.getApplicationSn());
      Department department = this.departmentService.selectByUserId(outbound.getApplicantId());
      outboundDTO.setApplicant(BriefDeptAndNameDTO.builder().name(outbound.getApplicantName()).deptName(department.getName()).build());
      int basicClass = 0;
      List<MoveOutboundDetail> moveOutboundDetails = this.moveOutboundDetailMapper
         .selectList((Wrapper<MoveOutboundDetail>)Wrappers.<MoveOutboundDetail>lambdaQuery().eq(MoveOutboundDetail::getOutboundId, outbound.getId()));
      List<OutboundDetailDTO> list = new ArrayList<>();
      this.getDetailDTO(basicClass, moveOutboundDetails, list, false);
      outboundDTO.setBasicClass(basicClass);
      outboundDTO.setList(list);
      return outboundDTO;
   }

   @Override
   public OutboundDTO getSchedulingMaterial(Long id) {
      Outbound outbound = this.baseMapper.selectOne((Wrapper<Outbound>)new LambdaQueryWrapper<Outbound>().eq(Outbound::getTaskOrderId, id));
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(outbound), "没有绑定原材料，无出库数据");
      OutboundDTO outboundDTO = BeanUtil.copy(outbound, OutboundDTO.class);
      List<MoveOutboundDetail> moveOutboundDetails = this.moveOutboundDetailMapper
         .selectList((Wrapper<MoveOutboundDetail>)new LambdaQueryWrapper<MoveOutboundDetail>().eq(MoveOutboundDetail::getOutboundId, outbound.getId()));
      List<OutboundDetailDTO> outboundDetailDTOS = new ArrayList<>();
      moveOutboundDetails.forEach(moveOutboundDetail -> {
         OutboundDetailDTO outboundDetailDTO = BeanUtil.copy(moveOutboundDetail, OutboundDetailDTO.class);
         if (moveOutboundDetail.getWarehouseId() != null) {
            Warehouse warehouse = this.warehouseService.getById(moveOutboundDetail.getWarehouseId());
            outboundDetailDTO.setWarehouse(BriefIdAndNameDTO.builder().id(warehouse.getId()).name(warehouse.getName()).build());
         }

         if (moveOutboundDetail.getProjectId() != null) {
            outboundDetailDTO.setProject(this.contractProjectService.getSimpleById(moveOutboundDetail.getProjectId()));
         }

         if (moveOutboundDetail.getSourceProjectId() != null) {
            outboundDetailDTO.setSourceProject(this.contractProjectService.getSimpleById(moveOutboundDetail.getSourceProjectId()));
         }

         outboundDetailDTOS.add(outboundDetailDTO);
      });
      outboundDTO.setList(outboundDetailDTOS);
      return outboundDTO;
   }

   @Override
   public ProjectPickingListDTO getProjectPicking(QueryProjectPickingDTOParam param) {
      if (param.getBasicClass() != null && param.getBasicClass().equals(BasicClassEnum.SECTION_STEEL.getType())) {
         param.setPrefixSpecification(param.getSpecification() + " * " + param.getMaterial());
         param.setSpecification(param.getSpecification().replaceFirst("^[A-Za-z]+", "") + " * " + param.getMaterial());
      }

      Map<Long, Classification> classificationMap = this.classificationService
         .list()
         .stream()
         .collect(Collectors.toMap(Classification::getId, Function.identity()));
      Map<Long, Measure> measureMap = this.measureMapper
         .selectList(new LambdaQueryWrapper<>())
         .stream()
         .collect(Collectors.toMap(Measure::getClassificationId, Function.identity()));
      List<ProjectPickingDTO> moveOutboundDetails = this.moveOutboundDetailMapper.getProjectPicking(param);
      moveOutboundDetails.forEach(projectPickingDTO -> {
         Measure measure = measureMap.get(projectPickingDTO.getClassifyId());
         if (StrUtil.isBlank(measure.getAccountingUnit())) {
            Classification classification = classificationMap.get(measure.getClassificationId());
            measure = this.getMeasureV2(classification.getParentId(), measureMap, classificationMap);
         }

         projectPickingDTO.setMeasureUnit(measure.getMeasureUnit());
         projectPickingDTO.setAccountingUnit(measure.getAccountingUnit());
         projectPickingDTO.setType("出库");
      });
      List<ProjectPickingDTO> returnDetails = this.returnDetailMapper.getProjectPickingReturnDetail(param);
      returnDetails.forEach(projectPickingDTO -> {
         Measure measure = measureMap.get(projectPickingDTO.getClassifyId());
         if (StrUtil.isBlank(measure.getAccountingUnit())) {
            Classification classification = classificationMap.get(measure.getClassificationId());
            measure = this.getMeasureV2(classification.getParentId(), measureMap, classificationMap);
         }

         projectPickingDTO.setMeasureUnit(measure.getMeasureUnit());
         projectPickingDTO.setAccountingUnit(measure.getAccountingUnit());
         projectPickingDTO.setType("退库");
      });
      return ProjectPickingListDTO.builder().moveOutboundDetails(moveOutboundDetails).returnDetails(returnDetails).build();
   }

   @Override
   public ProjectPickingMeteListDTO PickingMete(QueryProjectPickingDTOParam param) {
      List<ProjectPickingDTO> projectPickingSteelMete = this.moveOutboundDetailMapper.getProjectPickingSteelMete(param);
      List<ProjectPickingDTO> projectPickingSectionSteelMete = this.moveOutboundDetailMapper.getProjectPickingSectionSteelMete(param);
      List<ProjectPickingDTO> projectPickingSteelReturnMete = this.returnDetailMapper.getProjectPickingSteelReturnMete(param);
      List<ProjectPickingDTO> projectPickingSectionSteelReturnMete = this.returnDetailMapper.getProjectPickingSectionSteelReturnMete(param);
      List<ProjectPickingDTO> projectPickingSteelMeteList = new ArrayList<>();
      if (CollectionUtil.isNotEmpty(projectPickingSteelMete)) {
         for (ProjectPickingDTO projectPickingDTO : projectPickingSteelMete) {
            Optional<ProjectPickingDTO> first = projectPickingSteelReturnMete.stream()
               .filter(
                  returnDetailDTO -> returnDetailDTO.getThickness().compareTo(projectPickingDTO.getThickness()) == 0
                     && ObjectUtil.equals(returnDetailDTO.getSpecification(), projectPickingDTO.getSpecification())
               )
               .findFirst();
            if (first.isPresent()) {
               projectPickingDTO.setMeteCount(projectPickingDTO.getMeteCount().subtract(first.get().getMeteCount()));
            }

            projectPickingSteelMeteList.add(projectPickingDTO);
         }
      }

      List<ProjectPickingDTO> projectPickingSectionSteelMeteList = new ArrayList<>();
      if (CollectionUtil.isNotEmpty(projectPickingSectionSteelMete)) {
         for (ProjectPickingDTO projectPickingDTO : projectPickingSectionSteelMete) {
            Optional<ProjectPickingDTO> first = projectPickingSectionSteelReturnMete.stream()
               .filter(returnDetailDTO -> ObjectUtil.equals(returnDetailDTO.getSpecification(), projectPickingDTO.getSpecification()))
               .findFirst();
            if (first.isPresent()) {
               projectPickingDTO.setMeteCount(projectPickingDTO.getMeteCount().subtract(first.get().getMeteCount()));
            }

            projectPickingSectionSteelMeteList.add(projectPickingDTO);
         }
      }

      return ProjectPickingMeteListDTO.builder()
         .projectPickingSteelMeteList(projectPickingSteelMeteList)
         .projectPickingSectionSteelMeteList(projectPickingSectionSteelMeteList)
         .build();
   }

   @Override
   public Map<String, BigDecimal> CumulativePickingMete(QueryProjectPickingDTOParam param) {
      if (param.getBasicClass() != null && param.getBasicClass().equals(BasicClassEnum.SECTION_STEEL.getType())) {
         param.setPrefixSpecification(param.getSpecification() + " * " + param.getMaterial());
         param.setSpecification(param.getSpecification().replaceFirst("^[A-Za-z]+", "") + " * " + param.getMaterial());
      }

      List<ProjectPickingDTO> outbound = this.moveOutboundDetailMapper.getProjectPicking(param);
      List<ProjectPickingDTO> returns = this.returnDetailMapper.getProjectPickingReturnDetail(param);
      LocalDateTime now = LocalDateTime.now();
      String month = DateTimeFormatter.ofPattern("yyyy-MM").format(now);
      String previous = DateTimeFormatter.ofPattern("yyyy-MM").format(now.minusMonths(1L));
      Map<String, BigDecimal> map = new HashMap<>();
      // Match the signed actual quantities in the detail table; theory remains a separate measurement.
      map.put("meteCount", this.sumProjectPickingMete(outbound, null).subtract(this.sumProjectPickingMete(returns, null)));
      map.put("MonthMete", this.sumProjectPickingMete(outbound, month).subtract(this.sumProjectPickingMete(returns, month)));
      map.put("aboveMonthMete", this.sumProjectPickingMete(outbound, previous).subtract(this.sumProjectPickingMete(returns, previous)));
      return map;
   }

   private BigDecimal sumProjectPickingMete(List<ProjectPickingDTO> rows, String month) {
      if (CollectionUtil.isEmpty(rows)) return BigDecimal.ZERO;
      return rows.stream()
         .filter(row -> month == null || month.equals(DateTimeFormatter.ofPattern("yyyy-MM").format(row.getTime())))
         .map(ProjectPickingDTO::getMete)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
   }

   @Override
   public void ProjectPickingDownload(QueryProjectPickingDTOParam param, HttpServletResponse response) {
      String resourcePath = "files/templateV2/项目领料详情.xlsx";
      String tempFileName = "项目领料详情";
      String exportFileName = "项目领料详情.xlsx";
      String message = null;
      if (param.getBasicClass() != null && param.getBasicClass().equals(BasicClassEnum.SECTION_STEEL.getType())) {
         param.setPrefixSpecification(param.getSpecification() + " * " + param.getMaterial());
         param.setSpecification(param.getSpecification().replaceFirst("^[A-Za-z]+", "") + " * " + param.getMaterial());
      }

      List<ProjectPickingDTO> moveOutboundDetails = this.moveOutboundDetailMapper.getProjectPicking(param);
      Map<Long, Classification> classificationMap = this.classificationService
         .list()
         .stream()
         .collect(Collectors.toMap(Classification::getId, Function.identity()));
      Map<Long, Measure> measureMap = this.measureMapper
         .selectList(new LambdaQueryWrapper<>())
         .stream()
         .collect(Collectors.toMap(Measure::getClassificationId, Function.identity()));
      Map<String, Unit> unitMap = this.unitMapper.selectList(new LambdaQueryWrapper<>()).stream().collect(Collectors.toMap(Unit::getName, Function.identity()));
      if (CollectionUtil.isNotEmpty(moveOutboundDetails)) {
         moveOutboundDetails.forEach(dto -> dto.setType("出库"));
      }

      List<ProjectPickingDTO> returnDetails = this.returnDetailMapper.getProjectPickingReturnDetail(param);
      if (CollectionUtil.isNotEmpty(returnDetails)) {
         returnDetails.forEach(dto -> dto.setType("退库"));
         moveOutboundDetails.addAll(returnDetails);
      }

      int orderNo = 0;
      Map<String, Object> map = new HashMap<>();
      List<Map<String, Object>> mapList = new ArrayList<>();

      for (ProjectPickingDTO moveOutboundDetail : moveOutboundDetails) {
         HashMap<String, Object> mapObject = new HashMap<>();
         mapObject.put("orderNo", ++orderNo);
         mapObject.put("type", moveOutboundDetail.getType());
         mapObject.put("classifyName", moveOutboundDetail.getClassifyName());
         mapObject.put("length", moveOutboundDetail.getLength());
         StringBuilder sb = new StringBuilder();
         StringBuilder lengths = new StringBuilder();
         StringBuilder material = new StringBuilder();
         this.setSpecs(moveOutboundDetail, sb, lengths, material);
         mapObject.put("specification", sb);
         mapObject.put("material", StrUtil.isNotBlank(material) ? material : "-");
         Measure measure = measureMap.get(moveOutboundDetail.getClassifyId());
         if (StrUtil.isBlank(measure.getAccountingUnit())) {
            Classification classification = classificationMap.get(measure.getClassificationId());
            measure = this.getMeasureV2(classification.getParentId(), measureMap, classificationMap);
         }

         mapObject.put("measureUnit", measure.getMeasureUnit());
         mapObject.put("accountingUnit", measure.getAccountingUnit());
         mapObject.put("quantity", moveOutboundDetail.getQuantity());
         Map<Integer, BigDecimal> mete = this.unitConversionV2(
            moveOutboundDetail.getMete(), measure.getAccountingUnit(), measure.getAccountingPrecision(), unitMap
         );
         mapObject.put("mete", mete.get(1).toPlainString());
         mapObject.put("time", moveOutboundDetail.getTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
         mapObject.put("recipientName", StrUtil.isNotBlank(moveOutboundDetail.getRecipientName()) ? moveOutboundDetail.getRecipientName() : "-");
         mapList.add(mapObject);
      }

      map.put("mapList", mapList);
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
      PoiUtils.wmsDownLoadExcel(exportFileName, response, workbook, message);
   }

   private Measure getMeasureV2(Long pid, Map<Long, Measure> measureMap, Map<Long, Classification> classificationMap) {
      Measure m = measureMap.get(pid);
      if (m.getAccountingUnit() != null) {
         return m;
      }

      Classification classification = classificationMap.get(pid);
      return this.getMeasureV2(classification.getParentId(), measureMap, classificationMap);
   }

   public void setSpecs(ProjectPickingDTO detailDO, StringBuilder sb, StringBuilder lengths, StringBuilder material) {
      String thickness = detailDO.getThickness() != null ? detailDO.getThickness().stripTrailingZeros().toPlainString() : null;
      String width = detailDO.getWidth() != null ? detailDO.getWidth().stripTrailingZeros().toPlainString() : null;
      String length = detailDO.getLength() != null ? detailDO.getLength().stripTrailingZeros().toPlainString() : null;
      boolean b = StrUtil.isNotBlank(detailDO.getSpecification());
      if (BasicClassEnum.STEEL_PLATE.getType().equals(detailDO.getBasicClass())) {
         sb.append(thickness).append("*").append(width);
         lengths.append(length);
         material.append(StrUtil.isNotBlank(detailDO.getSpecification()) ? detailDO.getSpecification() : "-");
      } else if (BasicClassEnum.SECTION_STEEL.getType().equals(detailDO.getBasicClass())) {
         lengths = lengths.append(length);
         if (b && detailDO.getSpecification().contains("*")) {
            int index = detailDO.getSpecification().lastIndexOf("*");
            if (index != -1) {
               String result = detailDO.getSpecification().substring(0, index);
               sb.append(result);
            }

            String[] parts = detailDO.getSpecification().split("\\*");
            String lastPart = parts[parts.length - 1];
            material.append(StrUtil.isNotBlank(lastPart) ? lastPart : "-");
         }
      }
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

   @Override
   public OutboundDTO getPickingDetail(Long id) {
      Outbound outbound = this.outboundService.getOne((Wrapper<Outbound>)new LambdaQueryWrapper<Outbound>().eq(Outbound::getSchedulingId, id));
      OutboundDTO outboundDTO = BeanUtil.copy(outbound, OutboundDTO.class);
      if (outbound != null) {
         List<MoveOutboundDetail> moveOutboundDetails = this.moveOutboundDetailMapper
            .selectList((Wrapper<MoveOutboundDetail>)new LambdaQueryWrapper<MoveOutboundDetail>().eq(MoveOutboundDetail::getOutboundId, outbound.getId()));
         List<OutboundDetailDTO> outboundDetailDTOS = new ArrayList<>();

         for (MoveOutboundDetail moveOutboundDetail : moveOutboundDetails) {
            OutboundDetailDTO outboundDetailDTO = BeanUtil.copy(moveOutboundDetail, OutboundDetailDTO.class);
            outboundDetailDTO.setClassifyName(this.classificationService.getById(moveOutboundDetail.getClassifyId()).getName());
            if (moveOutboundDetail.getWorkshopId() != null) {
               Workshop workshop = this.workshopService.getById(moveOutboundDetail.getWorkshopId());
               outboundDetailDTO.setWorkshop(BriefIdAndNameDTO.builder().id(workshop.getId()).name(workshop.getName()).build());
            }

            if (moveOutboundDetail.getWarehouseId() != null) {
               Warehouse warehouse = this.warehouseService.getById(moveOutboundDetail.getWarehouseId());
               outboundDetailDTO.setWarehouse(BriefIdAndNameDTO.builder().id(warehouse.getId()).name(warehouse.getName()).build());
            }

            MaterialInventory materialInventory = this.materialInventoryMapper.selectById(moveOutboundDetail.getMaterialInventoryId());
            outboundDetailDTO.setSurplusSn(materialInventory.getSurplusSn());
            outboundDetailDTO.setMaterialIsWhole(materialInventory.getMaterialIsWhole());
            outboundDetailDTOS.add(outboundDetailDTO);
            outboundDTO.setList(outboundDetailDTOS);
         }

         if (outbound.getApproveRecordId() != null) {
            WmsApproveRecordFlowDTO approveRecordDTO = this.wmsApproveRecordService.getApproveRecordDTO(outbound.getApproveRecordId());
            outboundDTO.setWmsApproveRecordFlowDTOS(approveRecordDTO);
         }
      }

      return outboundDTO;
   }

   @Override
   public List<OutboundDetailDTO> getNumericalControlDetail(List<String> guids) {
      List<MoveOutboundDetail> moveOutboundDetails = this.moveOutboundDetailMapper
         .selectList((Wrapper<MoveOutboundDetail>)new LambdaQueryWrapper<MoveOutboundDetail>().in(MoveOutboundDetail::getStockGuid, guids));
      List<OutboundDetailDTO> outboundDetailDTOS = new ArrayList<>();

      for (MoveOutboundDetail moveOutboundDetail : moveOutboundDetails) {
         OutboundDetailDTO outboundDetailDTO = OutboundDetailDTO.builder()
            .classifyName(this.classificationService.getById(moveOutboundDetail.getClassifyId()).getName())
            .specification(moveOutboundDetail.getSpecification())
            .mete(moveOutboundDetail.getMete())
            .length(moveOutboundDetail.getLength())
            .width(moveOutboundDetail.getWidth())
            .thickness(moveOutboundDetail.getThickness())
            .materialIsWhole(moveOutboundDetail.getMaterialIsWhole())
            .surplusSn(moveOutboundDetail.getSurplusSn())
            .build();
         if (moveOutboundDetail.getSourceWorkshopId() != null) {
            Workshop workshop = this.workshopService.getById(moveOutboundDetail.getSourceWorkshopId());
            outboundDetailDTO.setWorkshop(BriefIdAndNameDTO.builder().id(workshop.getId()).name(workshop.getName()).build());
         }

         if (moveOutboundDetail.getWarehouseId() != null) {
            Warehouse warehouse = this.warehouseService.getById(moveOutboundDetail.getWarehouseId());
            outboundDetailDTO.setWarehouse(BriefIdAndNameDTO.builder().id(warehouse.getId()).name(warehouse.getName()).build());
         }

         outboundDetailDTOS.add(outboundDetailDTO);
      }

      return outboundDetailDTOS;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean SchedulingSubmitReview(String ids, Integer transactStatus) {
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean SchedulingReviewOutbound(Long approveRecordId, Integer decision, String opinion) {
      return true;
   }

   public void updatePicking(Long id) {
   }

   @Override
   public List<OutboundDTO> getSchedulingOutboundDetail(Long id) {
      return null;
   }

   public void updatePickingDetail(Long id) {
      List<MoveOutboundDetail> moveOutboundDetails = this.moveOutboundDetailMapper
         .selectList((Wrapper<MoveOutboundDetail>)new LambdaQueryWrapper<MoveOutboundDetail>().eq(MoveOutboundDetail::getOutboundId, id));
      Map<Long, List<MoveOutboundDetail>> collect = moveOutboundDetails.stream().collect(Collectors.groupingBy(MoveOutboundDetail::getPickingDetailId));
      List<Long> pickingDetailId = moveOutboundDetails.stream().map(MoveOutboundDetail::getPickingDetailId).distinct().collect(Collectors.toList());
      Map<Long, WmsPickingDetail> wmsPickingDetailMap = this.wmsPickingDetailMapper
         .selectBatchIds(pickingDetailId)
         .stream()
         .collect(Collectors.toMap(WmsPickingDetail::getId, Function.identity()));
      collect.forEach((k, v) -> {
         WmsPickingDetail wmsPickingDetail = wmsPickingDetailMap.get(k);
         BigDecimal reduce = v.stream().map(MoveOutboundDetail::getMete).reduce(BigDecimal.ZERO, BigDecimal::add);
         this.wmsPickingDetailMapper.updateById(wmsPickingDetail);
      });
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean deleteSchedulingOutboundDetail(Long listId, Long materialId) {
      Outbound outbound = this.baseMapper.selectById(listId);
      Preconditions.checkArgument(outbound != null, "当前出库单不存在");
      MoveOutboundDetail moveOutboundDetail = this.moveOutboundDetailMapper.selectById(materialId);
      Preconditions.checkArgument(moveOutboundDetail != null, "当前出库详情不存在");
      Preconditions.checkArgument(moveOutboundDetail.getOutboundId().equals(listId), "当前出库物料不属于该出库单,请核对后操作.");
      Preconditions.checkArgument(ReviewStatusEnum.NOT_SUBMITTED.getType().equals(outbound.getReviewStatus()), "出库单正在审核中或已审核,请核对后操作");
      WmsPickingDetail wmsPickingDetail = this.wmsPickingDetailMapper.selectById(moveOutboundDetail.getPickingDetailId());
      this.wmsPickingDetailMapper.updateById(wmsPickingDetail);
      this.moveOutboundDetailMapper.deleteById(moveOutboundDetail);
      this.materialFreezeService.materialUnfreeze(outbound.getId(), moveOutboundDetail.getId(), MaterialFreezeTypeEnum.SCHEDULING_OUTBOUND.getType(), true);
      List<MoveOutboundDetail> moveOutboundDetails = this.moveOutboundDetailMapper
         .selectList((Wrapper<MoveOutboundDetail>)Wrappers.<MoveOutboundDetail>lambdaQuery().eq(MoveOutboundDetail::getOutboundId, listId));
      if (CollectionUtil.isEmpty(moveOutboundDetails)) {
         this.baseMapper.deleteById(outbound);
      } else {
         List<String> list = new ArrayList<>();
         Set<Long> pIds = new HashSet<>();
         int basicClass = 0;

         for (MoveOutboundDetail detail : moveOutboundDetails) {
            User user = this.userService.getById(detail.getRecipientId());
            if (user != null) {
               list.add(user.getName());
            }

            if (detail.getProjectId() != null) {
               pIds.add(detail.getProjectId());
            }

            basicClass |= detail.getBasicClass();
         }

         outbound.setProjectIds(CollectionUtil.isNotEmpty(pIds) ? StrUtil.join(",", pIds) : null);
         outbound.setContainBasicClass(basicClass);
         outbound.setRecipients(StrUtil.join(",", list));
         this.baseMapper.updateById(outbound);
      }

      return true;
   }

   private void checkHalfOutputDimensions(MoveOutboundDetail detail) {
      WasteConfig waste = this.basicConfigService.getSteelScrapDefinitionConf();
      boolean isScrap = BasicClassEnum.STEEL_PLATE.getType().equals(detail.getBasicClass())
         ? detail.getLength().compareTo(waste.getSteelPlateShortestSideMinLength()) <= 0
            || detail.getWidth().compareTo(waste.getSteelPlateShortestSideMinLength()) <= 0
         : detail.getLength().compareTo(waste.getSectionSteelMinLength()) <= 0;
      Preconditions.checkArgument(!isScrap, "截取尺寸低于废料标准，不能作为原料出库");
   }

   private BigDecimal getHalfSourceMete(Outbound outbound, MoveOutboundDetail detail, MaterialInventory inventory, Integer freezeType) {
      this.checkHalfOutputDimensions(detail);
      MaterialFreezeRecord source = this.materialFreezeRecordMapper.selectOne(
         Wrappers.<MaterialFreezeRecord>lambdaQuery().eq(MaterialFreezeRecord::getFreezeSourceId, outbound.getId())
            .eq(MaterialFreezeRecord::getFreezeDetailId, detail.getId()).eq(MaterialFreezeRecord::getFreezeType, freezeType)
      );
      Preconditions.checkArgument(
         source != null && source.getMete() != null && source.getQuantity() != null && detail.getQuantity() != null
            && detail.getQuantity().signum() > 0 && source.getQuantity().compareTo(detail.getQuantity()) == 0
            && source.getMete().stripTrailingZeros().scale() <= 8 && source.getMete().signum() > 0
            && source.getMete().compareTo(inventory.getMete()) <= 0 && source.getQuantity().compareTo(inventory.getQuantity()) <= 0
            && detail.getMete() != null && detail.getMete().signum() > 0 && detail.getMete().compareTo(source.getMete()) < 0,
         "半出重量与来源冻结量不一致,请重新操作"
      );
      return source.getMete();
   }

   @Override
   public Boolean passedOutbound(Outbound outbound) {
      Long currentUserId = UserUtil.getCurrentUserId();
      String currentName = UserUtil.getCurrentName();
      LocalDateTime dateTime = LocalDateTime.now();
      Preconditions.checkArgument(
         OutboundStatusEnum.UN_REVIEWED.getType().equals(outbound.getReviewStatus())
            || OutboundStatusEnum.AUDITING.getType().equals(outbound.getReviewStatus()),
         "出库单已审核,请核对后操作"
      );
      List<MoveOutboundDetail> moveOutboundDetails = this.moveOutboundDetailMapper
         .selectList((Wrapper<MoveOutboundDetail>)Wrappers.<MoveOutboundDetail>lambdaQuery().eq(MoveOutboundDetail::getOutboundId, outbound.getId()));
      outbound.setReviewerId(currentUserId);
      outbound.setReviewerName(currentName);
      outbound.setReviewStatus(OutboundStatusEnum.REVIEWED.getType());
      outbound.setReviewTime(dateTime);
      outbound.setOutboundTime(dateTime);
      outbound.setUserUpdateTime(dateTime);
      String serviceNumber = this.numberConfigService.getNumber(NumberTypeEnum.OUTBOUND_REVIEW, this.baseMapper.getCount(LocalDateTime.now()));
      outbound.setSerialNumber(serviceNumber);
      Long statisticsId = null;
      outbound.setOutboundStartTime(null);
      outbound.setOutboundEndTime(null);
      WeightedPriceConf weightedPriceConf = JSON.parseObject(
         this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置")).getValue(), WeightedPriceConf.class
      );
      Map<String, Transfer> transferMap = new HashMap<>();
      Transfer transfer = null;
      Integer materialFreezeType = null;
      if (outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.SCHEDULING_OUTBOUND.getType())) {
         materialFreezeType = MaterialFreezeTypeEnum.SCHEDULING_OUTBOUND.getType();
      } else if (outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.CONSTRUCTION_SITE_USE.getType())) {
         materialFreezeType = MaterialFreezeTypeEnum.CONSTRUCTION_SITE_USE.getType();
      } else if (outbound.getOutboundTypeSelection().equals(OutboundTypeEnum.PRODUCTION_USE.getType())) {
         materialFreezeType = Boolean.TRUE.equals(outbound.getBoolScheduling())
            ? MaterialFreezeTypeEnum.SCHEDULING_OUTBOUND.getType() : MaterialFreezeTypeEnum.OUTBOUND.getType();
      }

      if (OutboundTypeEnum.SCHEDULING_OUTBOUND.getType().equals(outbound.getOutboundTypeSelection())
         || OutboundTypeEnum.PRODUCTION_USE.getType().equals(outbound.getOutboundTypeSelection())
         || OutboundTypeEnum.CONSTRUCTION_SITE_USE.getType().equals(outbound.getOutboundTypeSelection())) {
         Map<Long, BigDecimal> materialMetes = new HashMap<>();
         Map<Long, BigDecimal> materialQuantities = new HashMap<>();
         for (MoveOutboundDetail detail : moveOutboundDetails) {
            if (!BasicClassEnum.checkIsSteel(detail.getBasicClass())) {
               continue;
            }
            MaterialInventory inventory = this.materialInventoryMapper.selectById(detail.getMaterialInventoryId());
            BigDecimal mete = materialMetes.merge(detail.getMaterialInventoryId(), detail.getMete(), BigDecimal::add);
            BigDecimal quantity = materialQuantities.merge(detail.getMaterialInventoryId(), detail.getQuantity(), BigDecimal::add);
            Preconditions.checkArgument(
               inventory != null && detail.getMete().signum() >= 0 && detail.getQuantity().signum() > 0
                  && mete.compareTo(inventory.getMete()) <= 0 && quantity.compareTo(inventory.getQuantity()) <= 0,
               "当前库存量不足,请重新操作"
            );
         }
      }

      this.materialFreezeService.materialUnfreeze(outbound.getId(), -1L, materialFreezeType, false);

      for (MoveOutboundDetail outboundDetail : moveOutboundDetails) {
         MaterialInventory materialInventory = this.materialInventoryMapper.selectById(outboundDetail.getMaterialInventoryId());
         Measure measure = this.measureMapper
            .selectOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, materialInventory.getClassifyId()));
         MonthWeightedAveragePrice wap = this.weightedAveragePriceService.getPrice(materialInventory);
         outboundDetail.setWapId(wap.getId());
         if (ObjectUtil.isEmpty(outboundDetail.getOutboundTime())) {
            outboundDetail.setOutboundTime(dateTime);
         }

         StatisticsEndPeriod surplusEndPeriod = null;
         materialInventory.setMete(materialInventory.getMete().subtract(outboundDetail.getMete()));
         materialInventory.setQuantity(outboundDetail.getQuantity() != null ? materialInventory.getQuantity().subtract(outboundDetail.getQuantity()) : null);
         if (materialInventory.getMete().compareTo(BigDecimal.ZERO) == 0) {
            this.materialInventoryMapper.deleteById(materialInventory);
         } else {
            if (materialInventory.getQuantity() != null) {
               materialInventory.setUseStatus(materialInventory.getQuantity().compareTo(BigDecimal.ZERO) == 0);
            }

            this.materialInventoryMapper.updateById(materialInventory);
         }

         this.wmsUtil
            .setInventoryUse(
               materialInventory,
               outboundDetail.getQuantity(),
               outboundDetail.getMete(),
               ReceiptTypeEnum.OUTBOUND,
               outbound.getId(),
               outbound.getSerialNumber(),
               2,
               true
            );
         Statistics statistics = this.statisticsMapper.get(materialInventory);
         this.setStatisticsEndPeriod(materialInventory, statistics);
         statisticsId = statistics.getId();
         long outPId = outboundDetail.getProjectId() != null ? outboundDetail.getProjectId() : -1L;
         long sourcePId = materialInventory.getProjectId() != null ? materialInventory.getProjectId() : -1L;
         if (outPId != sourcePId) {
            String key = outPId + "-" + materialInventory.getWorkshopId() + "-" + materialInventory.getWarehouseId();
            if (!transferMap.containsKey(key)) {
               transfer = Transfer.builder()
                  .basicClass(outboundDetail.getBasicClass())
                  .directionProjectId(outboundDetail.getProjectId())
                  .directionWorkshopId(materialInventory.getWorkshopId())
                  .directionWarehouseId(materialInventory.getWarehouseId())
                  .directionMonomerId(outboundDetail.getMonomerId())
                  .directionAreaId(outboundDetail.getAreaId())
                  .transferType(TransferTypeEnum.PROJECT_WARE.getType())
                  .reviewStatus(ReviewStatusEnum.REVIEWED.getType())
                  .applicantId(currentUserId)
                  .editorId(currentUserId)
                  .applicantName(currentName)
                  .editorName(currentName)
                  .reviewerName(currentName)
                  .reviewTime(dateTime)
                  .reviewerId(currentUserId)
                  .userUpdateTime(dateTime)
                  .transferCreateType(2)
                  .outboundSn(outbound.getSerialNumber())
                  .outboundId(outbound.getId())
                  .build();
               Integer count = this.transferMapper.getMaxDayNumber(LocalDateTime.now());
               String sn = this.numberConfigService.getNumber(NumberTypeEnum.TRANSFER, count);
               transfer.setSerialNumber(sn);
               this.transferMapper.insert(transfer);
               transferMap.put(key, transfer);
            } else {
               transfer = transferMap.get(key);
            }

            BigDecimal amountNoFreight;
            BigDecimal amountExcludingVatNoFreight;
            BigDecimal amount;
            BigDecimal amountExcludingVat;
            if (WeightedPriceEnum.SINGLE.getType().equals(weightedPriceConf.getWeightedType())) {
               BigDecimal p = outboundDetail.getMete().divide(wap.getMete(), 20, this.ROUNDING);
               amount = wap.getAmount().multiply(p).setScale(2, this.ROUNDING);
               amountExcludingVat = wap.getAmountExcludingVat().multiply(p).setScale(2, this.ROUNDING);
               amountNoFreight = wap.getAmountNoFreight().multiply(p).setScale(2, this.ROUNDING);
               amountExcludingVatNoFreight = wap.getAmountExcludingVatNoFreight().multiply(p).setScale(2, this.ROUNDING);
            } else {
               WholeWeightedAveragePrice price = this.wholeWAPMapper.getPrice(materialInventory);
               BigDecimal p = outboundDetail.getMete().divide(price.getMete(), 20, this.ROUNDING);
               amount = price.getAmount().multiply(p).setScale(2, this.ROUNDING);
               amountExcludingVat = price.getAmountExcludingVat().multiply(p).setScale(2, this.ROUNDING);
               amountNoFreight = price.getAmountNoFreight().multiply(p).setScale(2, this.ROUNDING);
               amountExcludingVatNoFreight = price.getAmountExcludingVatNoFreight().multiply(p).setScale(2, this.ROUNDING);
            }

            TransferDetail transferDetail = TransferDetail.builder()
               .boolPartyA(materialInventory.getBoolPartyA())
               .transferId(transfer.getId())
               .materialInventoryId(materialInventory.getId())
               .specification(materialInventory.getSpecification())
               .basicClass(materialInventory.getBasicClass())
               .length(materialInventory.getLength())
               .width(materialInventory.getWidth())
               .thickness(materialInventory.getThickness())
               .brand(materialInventory.getBrand())
               .heatNoAndBatchNo(materialInventory.getHeatNoAndBatchNo())
               .classifyId(materialInventory.getClassifyId())
               .transferType(TransferTypeEnum.PROJECT_WARE.getType())
               .sourceWorkshopId(materialInventory.getWorkshopId())
               .sourceWarehouseId(materialInventory.getWarehouseId())
               .sourceProjectId(materialInventory.getProjectId())
               .sourceMonomerId(materialInventory.getMonomerId())
               .sourceAreaId(materialInventory.getAreaId())
               .mete(outboundDetail.getMete())
               .quantity(outboundDetail.getQuantity())
               .color(materialInventory.getColor())
               .remark(outboundDetail.getRemark())
               .taxRate(materialInventory.getTaxRate())
               .invoiceType(materialInventory.getInvoiceType())
               .standardId(materialInventory.getStandardId())
               .standardName(materialInventory.getStandardName())
               .build();
            if (amount.compareTo(BigDecimal.ZERO) != 0) {
               transferDetail.setUnitPrice(amount.divide(outboundDetail.getMete(), 12, RoundingMode.HALF_UP));
               transferDetail.setUnitPriceExcludingVat(amountExcludingVat.divide(outboundDetail.getMete(), 12, RoundingMode.HALF_UP));
            } else {
               transferDetail.setUnitPrice(BigDecimal.ZERO);
               transferDetail.setUnitPriceExcludingVat(BigDecimal.ZERO);
            }

            transferDetail.setAmount(amount);
            transferDetail.setAmountExcludingVat(amountExcludingVat);
            transferDetail.setInputVat(transferDetail.getAmount().subtract(transferDetail.getAmountExcludingVat()));
            if (amountNoFreight.compareTo(BigDecimal.ZERO) != 0) {
               transferDetail.setUnitPriceNoFreight(amountNoFreight.divide(outboundDetail.getMete(), 12, RoundingMode.HALF_UP));
               transferDetail.setUnitPriceExcludingVatNoFreight(amountExcludingVatNoFreight.divide(outboundDetail.getMete(), 12, RoundingMode.HALF_UP));
            } else {
               transferDetail.setUnitPriceNoFreight(BigDecimal.ZERO);
               transferDetail.setUnitPriceExcludingVatNoFreight(BigDecimal.ZERO);
            }

            transferDetail.setAmountNoFreight(amountNoFreight);
            transferDetail.setAmountExcludingVatNoFreight(amountExcludingVatNoFreight);
            transferDetail.setInputVatNoFreight(transferDetail.getAmountNoFreight().subtract(transferDetail.getAmountExcludingVatNoFreight()));
            this.transferDetailMapper.insert(transferDetail);
            if (transferDetail.getQuantity() != null && outboundDetail.getHalfMode() == null) {
               wap.setQuantity(wap.getQuantity().subtract(transferDetail.getQuantity()));
            }

            wap.setMete(wap.getMete().subtract(transferDetail.getMete()));
            if (WeightedPriceEnum.SINGLE.getType().equals(weightedPriceConf.getWeightedType())) {
               wap.setAmount(wap.getAmount().subtract(amount));
               wap.setAmountExcludingVat(wap.getAmountExcludingVat().subtract(amountExcludingVat));
               wap.setAmountNoFreight(wap.getAmountNoFreight().subtract(amountNoFreight));
               wap.setAmountExcludingVatNoFreight(wap.getAmountExcludingVatNoFreight().subtract(amountExcludingVatNoFreight));
            }

            this.monthWeightedAveragePriceMapper.updateById(wap);
            statistics.setInboundMete(
               statistics.getInboundMete() != null ? statistics.getInboundMete().subtract(transferDetail.getMete()) : transferDetail.getMete().negate()
            );
            if (transferDetail.getQuantity() != null) {
               statistics.setInboundQuantity(
                  statistics.getInboundQuantity() != null
                     ? statistics.getInboundQuantity().subtract(transferDetail.getQuantity())
                     : transferDetail.getQuantity().negate()
               );
            }

            statistics.setInboundUnitPrice(transferDetail.getUnitPrice());
            statistics.setInboundUnitPriceExcludingVat(transferDetail.getUnitPriceExcludingVat());
            statistics.setInboundAmount(statistics.getInboundAmount() != null ? statistics.getInboundAmount().subtract(amount) : amount.negate());
            statistics.setInboundAmountExcludingVat(
               statistics.getInboundAmountExcludingVat() != null
                  ? statistics.getInboundAmountExcludingVat().subtract(amountExcludingVat)
                  : amountExcludingVat.negate()
            );
            statistics.setInboundUnitPriceNoFreight(transferDetail.getUnitPriceNoFreight());
            statistics.setInboundUnitPriceExcludingVatNoFreight(transferDetail.getUnitPriceExcludingVatNoFreight());
            statistics.setInboundAmountNoFreight(
               statistics.getInboundAmountNoFreight() != null ? statistics.getInboundAmountNoFreight().subtract(amountNoFreight) : amountNoFreight.negate()
            );
            statistics.setInboundAmountExcludingVatNoFreight(
               statistics.getInboundAmountExcludingVatNoFreight() != null
                  ? statistics.getInboundAmountExcludingVatNoFreight().subtract(amountExcludingVatNoFreight)
                  : amountExcludingVatNoFreight.negate()
            );
            StatisticsInbound si = BeanUtil.copy(materialInventory, StatisticsInbound.class, "createTime");
            si.setMaterialInventoryId(materialInventory.getId());
            si.setReceiptType(ReceiptTypeEnum.TRANSFER.getType());
            si.setReceiptId(transfer.getId());
            si.setReceiptSerialNumber(transfer.getSerialNumber());
            si.setStatisticsId(statistics.getId());
            si.setMete(transferDetail.getMete().negate());
            if (materialInventory.getQuantity() != null) {
               si.setQuantity(transferDetail.getQuantity().negate());
            }

            si.setUnitPrice(transferDetail.getUnitPrice());
            si.setUnitPriceExcludingVat(transferDetail.getUnitPriceExcludingVat());
            si.setAmount(transferDetail.getAmount().negate());
            si.setAmountExcludingVat(transferDetail.getAmountExcludingVat().negate());
            si.setUnitPriceNoFreight(transferDetail.getUnitPriceNoFreight());
            si.setUnitPriceExcludingVatNoFreight(transferDetail.getUnitPriceExcludingVatNoFreight());
            si.setAmountNoFreight(transferDetail.getAmountNoFreight().negate());
            si.setAmountExcludingVatNoFreight(transferDetail.getAmountExcludingVatNoFreight().negate());
            this.statisticsInboundMapper.insert(si);
            MaterialInventory inventory = BeanUtil.copy(materialInventory, MaterialInventory.class);
            inventory.setId(-1L);
            inventory.setProjectId(outboundDetail.getProjectId());
            inventory.setWorkshopId(outboundDetail.getSourceWorkshopId());
            InboundDetail inboundDetail = InboundDetail.builder()
               .basicClass(inventory.getBasicClass())
               .classifyId(inventory.getClassifyId())
               .accountingUnit(inventory.getAccountingUnit())
               .length(inventory.getLength())
               .width(inventory.getWidth())
               .thickness(inventory.getThickness())
               .brand(inventory.getBrand())
               .heatNoAndBatchNo(inventory.getHeatNoAndBatchNo())
               .specification(inventory.getSpecification())
               .color(inventory.getColor())
               .unitNet(inventory.getUnitNet())
               .quantity(outboundDetail.getQuantity())
               .mete(outboundDetail.getMete())
               .workshopId(transfer.getDirectionWorkshopId())
               .warehouseId(transfer.getDirectionWarehouseId())
               .measureUnit(inventory.getMeasureUnit())
               .taxRate(inventory.getTaxRate())
               .invoiceType(inventory.getInvoiceType())
               .standardName(inventory.getStandardName())
               .standardId(inventory.getStandardId())
               .oneTheoryWeight(inventory.getOneTheoryWeight())
               .sectionSteelWeight(inventory.getSectionSteelWeight())
               .boolPartyA(inventory.getBoolPartyA())
               .amount(amount)
               .amountExcludingVat(amountExcludingVat)
               .unitPrice(transferDetail.getUnitPrice())
               .unitPriceExcludingVat(transferDetail.getUnitPriceExcludingVat())
               .amountNoFreight(amountNoFreight)
               .amountExcludingVatNoFreight(amountExcludingVatNoFreight)
               .unitPriceNoFreight(transferDetail.getUnitPriceNoFreight())
               .unitPriceExcludingVatNoFreight(transferDetail.getUnitPriceExcludingVatNoFreight())
               .projectId(outboundDetail.getProjectId())
               .build();
            Statistics targetStatistics = this.weightedAveragePriceService
               .createMonthWAP(inboundDetail, inventory, transfer.getId(), transfer.getSerialNumber(), ReceiptTypeEnum.TRANSFER.getType());
            targetStatistics.setOutboundMete(
               targetStatistics.getOutboundMete() != null ? targetStatistics.getOutboundMete().add(outboundDetail.getMete()) : outboundDetail.getMete()
            );
            targetStatistics.setOutboundQuantity(
               targetStatistics.getOutboundQuantity() != null
                  ? targetStatistics.getOutboundQuantity().add(outboundDetail.getQuantity())
                  : outboundDetail.getQuantity()
            );
            targetStatistics.setEndMete(targetStatistics.getEndMete().subtract(outboundDetail.getMete()));
            if (targetStatistics.getEndQuantity() != null) {
               targetStatistics.setEndQuantity(targetStatistics.getEndQuantity().subtract(outboundDetail.getQuantity()));
            }

            this.statisticsMapper.updateById(targetStatistics);
            outboundDetail.setWapId(targetStatistics.getWapId());
            statisticsId = targetStatistics.getId();
         }

         if (statistics.getId().equals(statisticsId)) {
            statistics.setOutboundMete(
               statistics.getOutboundMete() != null ? outboundDetail.getMete().add(statistics.getOutboundMete()) : outboundDetail.getMete()
            );
            statistics.setOutboundQuantity(
               statistics.getOutboundQuantity() != null ? outboundDetail.getQuantity().add(statistics.getOutboundQuantity()) : outboundDetail.getQuantity()
            );
         }

         statistics.setEndMete(statistics.getEndMete().subtract(outboundDetail.getMete()));
         if (statistics.getEndQuantity() != null && surplusEndPeriod == null) {
            statistics.setEndQuantity(statistics.getEndQuantity().subtract(outboundDetail.getQuantity()));
         }

         this.statisticsMapper.updateById(statistics);
         this.saveStatisticsOutbound(outbound, outboundDetail, materialInventory, statisticsId);
         MaterialReturnable materialReturnable = MaterialReturnable.builder()
            .sourceWorkshopId(materialInventory.getWorkshopId())
            .classifyId(materialInventory.getClassifyId())
            .classifyName(materialInventory.getClassifyName())
            .boolPartyA(materialInventory.getBoolPartyA())
            .outboundUnitType(measure.getOutboundUnitType())
            .basicClass(materialInventory.getBasicClass())
            .specification(materialInventory.getSpecification())
            .mete(outboundDetail.getMete())
            .accountingUnit(materialInventory.getAccountingUnit())
            .returnableMete(outboundDetail.getMete())
            .quantity(outboundDetail.getQuantity())
            .unitNet(materialInventory.getUnitNet())
            .length(outboundDetail.getLength())
            .width(outboundDetail.getWidth())
            .thickness(materialInventory.getThickness())
            .theoryThickness(materialInventory.getTheoryThickness())
            .brand(materialInventory.getBrand())
            .heatNoAndBatchNo(materialInventory.getHeatNoAndBatchNo())
            .color(materialInventory.getColor())
            .projectId(outboundDetail.getProjectId())
            .outboundId(outbound.getId())
            .outboundSn(outbound.getSerialNumber())
            .outboundDetailId(outboundDetail.getId())
            .warehouseId(materialInventory.getWarehouseId())
            .outboundTime(outboundDetail.getOutboundTime())
            .weightedAverageSpec(materialInventory.getWeightedAverageSpec())
            .taxRate(outboundDetail.getTaxRate())
            .invoiceType(outboundDetail.getInvoiceType())
            .boolReviewPending(false)
            .boolReturn(true)
            .standardId(materialInventory.getStandardId())
            .standardName(materialInventory.getStandardName())
            .sectionSteelWeight(materialInventory.getSectionSteelWeight())
            .oneTheoryWeight(materialInventory.getOneTheoryWeight())
            .materialSn(materialInventory.getSerialNumber())
            .monomerId(outboundDetail.getMonomerId())
            .areaId(outboundDetail.getAreaId())
            .workshopId(outboundDetail.getWorkshopId())
            .areaBatchId(outboundDetail.getAreaBatchId())
            .build();
         if (outboundDetail.getRecipientId() != null) {
            materialReturnable.setRecipientId(outboundDetail.getRecipientId());
            materialReturnable.setRecipientName(this.userService.getById(outboundDetail.getRecipientId()).getName());
         }

         if (MaterialIsWholeEnum.WHOLE.getType().equals(materialInventory.getMaterialIsWhole())) {
            if (outboundDetail.getOutboundType() == 1) {
               materialReturnable.setMaterialIsWhole(MaterialIsWholeEnum.WHOLE.getType());
            } else {
               materialReturnable.setMaterialIsWhole(MaterialIsWholeEnum.ODDMENT.getType());
            }
         } else {
            materialReturnable.setMaterialIsWhole(MaterialIsWholeEnum.ODDMENT.getType());
         }

         if (BasicClassEnum.SECTION_STEEL.getType().equals(materialInventory.getBasicClass())) {
            if (MaterialOutboundModeEnum.HALF.getType().equals(outboundDetail.getOutboundType())) {
               materialReturnable.setSingleReturnableLength(outboundDetail.getLength());
            } else {
               materialReturnable.setSingleReturnableLength(materialInventory.getLength());
            }
         }

         if (BasicClassEnum.COLOR_ROLL.getType().equals(materialInventory.getBasicClass())) {
            materialReturnable.setSingleMete(outboundDetail.getMete());
            materialReturnable.setSingleReturnableMete(outboundDetail.getMete());
         } else if (MeasureTypeEnum.MEASURE.getType().equals(measure.getOutboundUnitType())) {
            if (BasicClassEnum.SECTION_STEEL.getType().equals(materialInventory.getBasicClass())
               || BasicClassEnum.STEEL_PLATE.getType().equals(materialInventory.getBasicClass())) {
               BigDecimal singleMete = outboundDetail.getMete().divide(outboundDetail.getQuantity(), 8, RoundingMode.DOWN);
               BigDecimal multiply = singleMete;
               materialReturnable.setSingleMete(multiply);
               materialReturnable.setSingleReturnableMete(multiply);
            }
         } else {
            materialReturnable.setSingleMete(outboundDetail.getMete());
            materialReturnable.setSingleReturnableMete(outboundDetail.getMete());
         }

         this.materialReturnableMapper.insert(materialReturnable);
         this.moveOutboundDetailMapper.updateById(outboundDetail);
         this.warningService.updateStatus(materialInventory, 2);
      }

      return this.baseMapper.updateById(outbound) == 1;
   }

   private void delForSale(List<Long> detailIds) {
      List<WmsForSaleDetail> forSaleDetails = this.wmsForSaleDetailService
         .list((Wrapper<WmsForSaleDetail>)new LambdaQueryWrapper<WmsForSaleDetail>().in(WmsForSaleDetail::getOutboundDetailId, detailIds).exists(WmsForSaleDetailMapper.OUTBOUND_PARENT_EXISTS_SQL));
      List<String> serialNumbers = forSaleDetails.stream().map(WmsForSaleDetail::getForSaleSerialNumber).distinct().collect(Collectors.toList());

      for (WmsForSale wmsForSale : this.wmsForSaleService.list((Wrapper<WmsForSale>)new LambdaQueryWrapper<WmsForSale>().in(WmsForSale::getSerialNumber, serialNumbers))) {
         List<WmsForSaleDetail> wmsForSaleDetails = forSaleDetails.stream()
            .filter(f -> f.getForSaleSerialNumber().equals(wmsForSale.getSerialNumber()))
            .collect(Collectors.toList());
         BigDecimal sellAmountSum = BigDecimal.ZERO;
         BigDecimal sellAmountExcludingVatSum = BigDecimal.ZERO;
         BigDecimal sellInputVatSum = BigDecimal.ZERO;
         BigDecimal systemMeteSum = BigDecimal.ZERO;
         BigDecimal inputMeteSum = BigDecimal.ZERO;
         BigDecimal differenceMeteSum = BigDecimal.ZERO;

         for (WmsForSaleDetail wmsForSaleDetail : wmsForSaleDetails) {
            sellAmountSum = sellAmountSum.add(wmsForSaleDetail.getSellAmount());
            sellAmountExcludingVatSum = sellAmountExcludingVatSum.add(wmsForSaleDetail.getSellAmountExcludingVat());
            if (wmsForSaleDetail.getSellInputVat() != null) {
               sellInputVatSum = sellInputVatSum.add(wmsForSaleDetail.getSellInputVat());
            }

            systemMeteSum = systemMeteSum.add(wmsForSaleDetail.getSystemMete());
            inputMeteSum = inputMeteSum.add(wmsForSaleDetail.getInputMete());
            differenceMeteSum = differenceMeteSum.add(wmsForSaleDetail.getDifferenceMete());
         }

         wmsForSale.setSellAmount(wmsForSale.getSellAmount().subtract(sellAmountSum));
         wmsForSale.setSellAmountExcludingVat(wmsForSale.getSellAmountExcludingVat().subtract(sellAmountExcludingVatSum));
         if (wmsForSale.getSellInputVat() != null) {
            wmsForSale.setSellInputVat(wmsForSale.getSellInputVat().subtract(sellInputVatSum));
         }

         wmsForSale.setSystemMete(wmsForSale.getSystemMete().subtract(systemMeteSum));
         wmsForSale.setInputMete(wmsForSale.getInputMete().subtract(inputMeteSum));
         wmsForSale.setDifferenceMete(wmsForSale.getDifferenceMete().subtract(differenceMeteSum));
         if (wmsForSale.getSellAmount().compareTo(BigDecimal.ZERO) == 0) {
            this.wmsForSaleService.removeById(wmsForSale.getId());
         } else {
            wmsForSale.setUpdateTime(LocalDateTime.now());
            this.wmsForSaleService.updateById(wmsForSale);
         }

         this.wmsForSaleDetailService.removeByIds(forSaleDetails.stream().map(WmsForSaleDetail::getId).collect(Collectors.toList()));
      }
   }
}
