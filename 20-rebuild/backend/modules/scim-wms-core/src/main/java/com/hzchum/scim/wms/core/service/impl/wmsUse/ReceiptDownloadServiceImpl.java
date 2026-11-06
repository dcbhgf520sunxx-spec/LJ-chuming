package com.hzchum.scim.wms.core.service.impl.wmsUse;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.ZipUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import com.alibaba.excel.write.metadata.fill.FillWrapper;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.config.ConfigProperties;
import com.hzchum.scim.common.core.api.enums.ExcelEnum;
import com.hzchum.scim.common.core.api.enums.FunctionTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.vo.StatisticsPageVO;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.scm.core.api.enums.LogisticsPayerEnum;
import com.hzchum.scim.scm.core.api.enums.PlaceEnum;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrder;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrderDetail;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import com.hzchum.scim.scm.core.api.pojo.dto.PurchaseOrderDetailDTO;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderDetailService;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.pojo._do.Department;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.system.core.api.service.DepartmentService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.wms.core.api.enums.AmountShowMenuEnum;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.enums.InvoiceTypeEnum;
import com.hzchum.scim.wms.core.api.enums.MeasureEnum;
import com.hzchum.scim.wms.core.api.enums.ReceiptTypeEnum;
import com.hzchum.scim.wms.core.api.enums.RejectEnum;
import com.hzchum.scim.wms.core.api.enums.TransferTypeEnum;
import com.hzchum.scim.wms.core.api.enums.UnitEnum;
import com.hzchum.scim.wms.core.api.enums.UnitsPrecisionEnum;
import com.hzchum.scim.wms.core.api.enums.WeightedPriceEnum;
import com.hzchum.scim.wms.core.api.enums.WeightedPriceTypeEnum;
import com.hzchum.scim.wms.core.api.enums.WmsWageQuotaTypeEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.BasicConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.BasicInbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.BasicShowConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Classification;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.InventoryUseConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Measure;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.ReportDownload;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Unit;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Warehouse;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WeightedPriceConf;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WeightedExecutionPriceConf;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WmsMaterialCodeConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Workshop;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.InventoryUseRecord;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.InventoryUseStatistics;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.InventoryUseStatisticsDate;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.RejectDetailDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.DownLoadDetailDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundDetailManufactured;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundManufactured;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialFreeze;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialReturnable;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MonthWeightedAveragePrice;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.OutboundDetailManufactured;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.OutboundManufactured;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Reject;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.RejectDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Return;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.ReturnDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.ReturnDetailManufactured;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.ReturnManufactured;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WholeWeightedAveragePrice;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsDeficitDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsForSale;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsForSaleDetail;
import com.hzchum.scim.wms.core.api.pojo._doModel.wmsUse.WmsSurplus;
import com.hzchum.scim.wms.core.api.pojo._doModel.wmsUse.WmsSurplusDetail;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.ClassifySpecDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.DetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.ExcelDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.InventoryDetailsRecordDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.InventoryUseStatisticsMergeDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.PSIRecordDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.StatisticsDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.StatisticsDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.AdjustDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialInventoryDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryDetailDTOParam;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.MoveMaterialMaterialDO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.RDFeeDTO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.ReturnDetailDO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryDownloadParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryInventoryUseStatisticsDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryRejectDetailDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryReportAdjustDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryReportDeficitDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryReportInboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryReportSurplusDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryStatisticsDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryByMaterialDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryInboundManufacturedDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryOutboundManufacturedDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryReturnManufacturedDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.BasicConfigService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.ClassificationService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.MeasureService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WarehouseService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WorkshopService;
import com.hzchum.scim.wms.core.api.service.wmsReport.InventoryUseRecordService;
import com.hzchum.scim.wms.core.api.service.wmsReport.InventoryUseStatisticsDateService;
import com.hzchum.scim.wms.core.api.service.wmsReport.InventoryUseStatisticsService;
import com.hzchum.scim.wms.core.api.service.wmsReport.ReportService;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundDetailManufacturedService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialFreezeService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialInventoryService;
import com.hzchum.scim.wms.core.api.service.wmsUse.OutboundDetailManufacturedService;
import com.hzchum.scim.wms.core.api.service.wmsUse.OutboundService;
import com.hzchum.scim.wms.core.api.service.wmsUse.ReceiptDownloadService;
import com.hzchum.scim.wms.core.api.service.wmsUse.ReturnDetailManufacturedService;
import com.hzchum.scim.wms.core.api.service.wmsUse.ReturnService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsDeficitDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsForSaleDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsForSaleService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsSurplusDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsSurplusService;
import com.hzchum.scim.wms.core.api.utils.CommonUtil;
import com.hzchum.scim.wms.core.api.utils.QueryUtilService;
import com.hzchum.scim.wms.core.api.utils.WmsUtil;
import com.hzchum.scim.wms.core.mapper.wmsConfig.BasicConfigMapper;
import com.hzchum.scim.wms.core.mapper.wmsConfig.ClassificationMapper;
import com.hzchum.scim.wms.core.mapper.wmsConfig.MeasureMapper;
import com.hzchum.scim.wms.core.mapper.wmsConfig.UnitMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.InventoryUseStatisticsMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.WmsForSaleDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.InboundDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MaterialInventoryMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MaterialReturnableMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MonthWeightedAveragePriceMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MoveMaterialDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MoveOutboundDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MoveWeightedAveragePriceMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.RejectDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.RejectMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.ReturnDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.TransferDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.WholeWeightedAveragePriceMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.WmsAdjustDetailMapper;
import com.hzchum.scim.wms.core.utils.QueryUtilImpl;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

@Service
public class ReceiptDownloadServiceImpl implements ReceiptDownloadService {
   @Resource
   InboundDetailMapper inboundDetailMapper;
   @Resource
   MoveOutboundDetailMapper moveOutboundDetailMapper;
   @Resource
   TransferDetailMapper transferDetailMapper;
   @Resource
   ReturnDetailMapper returnDetailMapper;
   @Resource
   ReportService reportService;
   @Resource
   ClassificationMapper classificationMapper;
   @Resource
   UnitMapper unitMapper;
   @Resource
   MeasureMapper measureMapper;
   @Resource
   BasicConfigMapper basicConfigMapper;
   @Resource
   ClassificationService classificationService;
   @Resource
   MaterialInventoryMapper materialInventoryMapper;
   @Resource
   MaterialInventoryService materialInventoryService;
   @Resource
   MoveWeightedAveragePriceMapper wapMapper;
   @Resource
   ContractProjectService projectService;
   @Resource
   RejectDetailMapper rejectDetailMapper;
   @Resource
   RejectMapper rejectMapper;
   @Resource
   UserService userService;
   @Resource
   DepartmentService departmentService;
   @Resource
   MaterialReturnableMapper returnableMapper;
   @Value("${wms.amount-accuracy}")
   private Integer amountAccuracy;
   @Resource
   MonthWeightedAveragePriceMapper monthWAPMapper;
   @Resource
   ReturnService returnService;
   @Resource
   WarehouseService warehouseService;
   @Resource
   WorkshopService workshopService;
   @Resource
   WholeWeightedAveragePriceMapper wholeWeightedAveragePriceMapper;
   @Resource
   WmsAdjustDetailMapper wmsAdjustDetailMapper;
   @Resource
   WmsDeficitDetailService wmsDeficitDetailService;
   @Resource
   QueryUtilImpl queryUtil;
   @Resource
   OutboundService outboundService;
   @Resource
   WmsForSaleDetailService wmsForSaleDetailService;
   @Resource
   WmsForSaleService wmsForSaleService;
   @Resource
   InboundDetailManufacturedService inboundDetailManufacturedService;
   @Resource
   OutboundDetailManufacturedService outboundDetailManufacturedService;
   @Resource
   ReturnDetailManufacturedService returnDetailManufacturedService;
   @Resource
   SupplierService supplierService;
   @Resource
   BasicConfigService basicConfigService;
   @Resource
   WmsSurplusService wmsSurplusService;
   @Resource
   WmsSurplusDetailService surplusDetailService;
   @Resource
   private ConfigProperties configProperties;
   @Resource
   InventoryUseStatisticsMapper inventoryUseStatisticsMapper;
   @Resource
   InventoryUseStatisticsService inventoryUseStatisticsService;
   @Resource
   InventoryUseRecordService inventoryUseRecordService;
   @Resource
   InventoryUseStatisticsDateService inventoryUseStatisticsDateService;
   @Resource
   QueryUtilService queryUtilService;
   @Resource
   PurchaseOrderService purchaseOrderService;
   @Resource
   PurchaseOrderDetailService purchaseOrderDetailService;
   @Resource
   BranchCompanyService branchCompanyService;
   @Resource
   MaterialFreezeService materialFreezeService;
   @Resource
   MoveMaterialDetailMapper moveMaterialDetailMapper;
   @Resource
   MeasureService measureService;

   @Override
   public void inboundDownload(QueryReportInboundDTOParam param, HttpServletResponse response) {
      String message = null;
      HashMap<String, Object> map = new HashMap<>(16);
      if (!CollectionUtil.isNotEmpty(param.getInboundTime()) && !CollectionUtil.isNotEmpty(param.getRealTime())) {
         message = "请选择下载的时间范围";
      } else {
         param.setClassifyIds(this.queryUtil.getLateClassificationList(param.getClassifyId()));
         String a = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(param.getInboundTime().get(0));
         String b = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(param.getInboundTime().get(1));
         map.put("inboundData", a + "~" + b);
         List<DownLoadDetailDO> list = this.inboundDetailMapper.getDownLoadDetail(param);
         Map<Long, Classification> classificationMap = this.classificationService
            .list()
            .stream()
            .collect(Collectors.toMap(Classification::getId, Function.identity()));
         Map<Long, Measure> measureMap = this.measureMapper
            .selectList(new LambdaQueryWrapper<>())
            .stream()
            .collect(Collectors.toMap(Measure::getClassificationId, Function.identity()));
         Map<String, Unit> unitMap = this.unitMapper
            .selectList(new LambdaQueryWrapper<>())
            .stream()
            .collect(Collectors.toMap(Unit::getName, Function.identity()));
         List<Map<String, Object>> mapList = new ArrayList<>();
         BasicShowConfig basicShowConfig = this.basicConfigService.getBasicShowConfig();
         Map<String, WmsMaterialCodeConfig> materialCodeConfigMaps = this.queryUtil.getMaterialCodeConfigMaps(null);

         for (int i = 0; i < list.size(); i++) {
            Map<String, Object> mapObject = new HashMap<>();
            DownLoadDetailDO detailDO = list.get(i);
            mapObject.put("id", i + 1);
            mapObject.put("data", DateTimeFormatter.ofPattern("yyyy/MM/dd").format(detailDO.getReviewTime()));
            Map<String, String> classMap = this.setClassifyNameV2(
               detailDO.getBasicClass(), detailDO.getClassifyId(), detailDO.getClassifyName(), classificationMap
            );
            mapObject.put("basicClass", classMap.get("分类"));
            mapObject.put("classifyName", classMap.get("名称"));
            StringBuilder sb = new StringBuilder();
            StringBuilder lengths = new StringBuilder();
            StringBuilder material = new StringBuilder();
            this.setSpecs(detailDO, sb, lengths, material);
            mapObject.put("spec", this.queryUtil.getConfigShowSpec(JSON.toJSONString(detailDO), basicShowConfig));
            Measure measure = detailDO.getMeasure();
            this.setAmountAndMeteV2(mapObject, detailDO, measure, classificationMap, measureMap, unitMap, AmountShowMenuEnum.INBOUND_DETAILS.getType());
            mapObject.put("material", StrUtil.isNotBlank(material) ? material : "-");
            mapObject.put("lengths", StrUtil.isNotBlank(lengths) ? lengths : "-");
            String s1 = this.queryUtil.buildCompositeKey(detailDO.getClassifyId(), detailDO.getSpecification(), detailDO.getThickness());
            WmsMaterialCodeConfig wmsMaterialCodeConfig = materialCodeConfigMaps.get(s1);
            mapObject.put("materialSnNew", ObjectUtil.isNotEmpty(wmsMaterialCodeConfig) ? wmsMaterialCodeConfig.getMaterialSnNew() : "");
            mapObject.put("serialNumber", detailDO.getSerialNumber());
            mapObject.put("purchaseSN", detailDO.getPurchaseSN());
            mapObject.put("supplierName", detailDO.getSupplierName());
            mapObject.put("project", detailDO.getProjectName());
            mapObject.put("monomerName", detailDO.getMonomerName());
            mapObject.put("areaName", detailDO.getAreaName());
            mapObject.put("warehouseName", detailDO.getWarehouseName());
            mapObject.put("brand", StrUtil.isNotBlank(detailDO.getBrand()) ? detailDO.getBrand() : "-");
            mapObject.put("projectNumber", detailDO.getProjectNumber());
            mapObject.put("remark", detailDO.getRemark());
            if (detailDO.getRejectStatus() == 1) {
               mapObject.put("rejectStatus", RejectEnum.NO_REJECT.getName());
            }

            if (detailDO.getRejectStatus() == 2) {
               mapObject.put("rejectStatus", RejectEnum.UN_REVIEWED.getName());
            }

            if (detailDO.getRejectStatus() == 4) {
               mapObject.put("rejectStatus", RejectEnum.PART_REJECT.getName());
            }

            if (detailDO.getRejectStatus() == 8) {
               mapObject.put("rejectStatus", RejectEnum.All_REJECT.getName());
            }

            mapList.add(mapObject);
         }

         map.put("mapList", mapList);
      }

      this.download(response, message, map, 1);
   }

   @Override
   public void inboundAndRejectDownload(QueryReportInboundDTOParam param, HttpServletResponse response) {
      String message = null;
      HashMap<String, Object> map = new HashMap<>(16);
      if (CollectionUtil.isNotEmpty(param.getInboundTime())) {
         param.setClassifyIds(this.queryUtil.getLateClassificationList(param.getClassifyId()));
         String a = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(param.getInboundTime().get(0));
         String b = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(param.getInboundTime().get(1));
         map.put("inboundData", a + "~" + b);
         List<DownLoadDetailDO> list = this.inboundDetailMapper.getDownLoadDetail(param);
         Map<Long, Classification> classificationMap = this.classificationService
            .list()
            .stream()
            .collect(Collectors.toMap(Classification::getId, Function.identity()));
         Map<Long, Measure> measureMap = this.measureMapper
            .selectList(new LambdaQueryWrapper<>())
            .stream()
            .collect(Collectors.toMap(Measure::getClassificationId, Function.identity()));
         Map<String, Unit> unitMap = this.unitMapper
            .selectList(new LambdaQueryWrapper<>())
            .stream()
            .collect(Collectors.toMap(Unit::getName, Function.identity()));
         List<Long> collect = list.stream().map(DownLoadDetailDO::getInboundId).collect(Collectors.toList());
         Map<Long, List<Reject>> rejectMap = new HashMap<>();
         Map<String, List<RejectDetail>> rejectDetailsMap = new HashMap<>();
         if (CollectionUtil.isNotEmpty(collect)) {
            List<Reject> rejects = this.rejectMapper.selectList((Wrapper<Reject>)new LambdaQueryWrapper<Reject>().in(Reject::getInboundId, collect));
            rejectMap = rejects.stream().collect(Collectors.groupingBy(e -> e.getInboundId()));
            if (CollectionUtil.isNotEmpty(rejects)) {
               List<Long> rejectIds = rejects.stream().map(Reject::getId).collect(Collectors.toList());
               rejectDetailsMap = this.rejectDetailMapper
                  .selectList((Wrapper<RejectDetail>)new LambdaQueryWrapper<RejectDetail>().in(RejectDetail::getRejectId, rejectIds))
                  .stream()
                  .collect(Collectors.groupingBy(e -> e.getRejectId() + "-" + e.getInboundDetailId()));
            }
         }

         List<Map<String, Object>> mapList = new ArrayList<>();
         BasicShowConfig basicShowConfig = this.basicConfigService.getBasicShowConfig();
         Map<String, WmsMaterialCodeConfig> materialCodeConfigMaps = this.queryUtil.getMaterialCodeConfigMaps(null);

         for (int i = 0; i < list.size(); i++) {
            Map<String, Object> mapObject = new HashMap<>();
            DownLoadDetailDO detailDO = list.get(i);
            mapObject.put("id", i + 1);
            mapObject.put("data", DateTimeFormatter.ofPattern("yyyy/MM/dd").format(detailDO.getReviewTime()));
            Map<String, String> classMap = this.setClassifyNameV2(
               detailDO.getBasicClass(), detailDO.getClassifyId(), detailDO.getClassifyName(), classificationMap
            );
            mapObject.put("basicClass", classMap.get("分类"));
            mapObject.put("classifyName", classMap.get("名称"));
            StringBuilder sb = new StringBuilder();
            StringBuilder lengths = new StringBuilder();
            StringBuilder material = new StringBuilder();
            this.setSpecs(detailDO, sb, lengths, material);
            mapObject.put("spec", this.queryUtil.getConfigShowSpec(JSON.toJSONString(detailDO), basicShowConfig));
            Measure measure = detailDO.getMeasure();
            this.setAmountAndMeteV2(mapObject, detailDO, measure, classificationMap, measureMap, unitMap, AmountShowMenuEnum.INBOUND_DETAILS.getType());
            mapObject.put("material", StrUtil.isNotBlank(material) ? material : "-");
            String s1 = this.queryUtil.buildCompositeKey(detailDO.getClassifyId(), detailDO.getSpecification(), detailDO.getThickness());
            WmsMaterialCodeConfig wmsMaterialCodeConfig = materialCodeConfigMaps.get(s1);
            mapObject.put("materialSnNew", ObjectUtil.isNotEmpty(wmsMaterialCodeConfig) ? wmsMaterialCodeConfig.getMaterialSnNew() : "");
            mapObject.put("lengths", StrUtil.isNotBlank(lengths) ? lengths : "-");
            mapObject.put("serialNumber", detailDO.getSerialNumber());
            mapObject.put("purchaseSN", detailDO.getPurchaseSN());
            mapObject.put("supplierName", detailDO.getSupplierName());
            mapObject.put("project", detailDO.getProjectName());
            mapObject.put("monomerName", detailDO.getMonomerName());
            mapObject.put("areaName", detailDO.getAreaName());
            mapObject.put("warehouseName", detailDO.getWarehouseName());
            mapObject.put("brand", StrUtil.isNotBlank(detailDO.getBrand()) ? detailDO.getBrand() : "-");
            mapObject.put("projectNumber", detailDO.getProjectNumber());
            mapObject.put("remark", detailDO.getRemark());
            mapList.add(mapObject);
            if (detailDO.getRejectStatus() == 1) {
               mapObject.put("rejectStatus", "没有");
            }

            if (detailDO.getRejectStatus() == 4) {
               mapObject.put("rejectStatus", "部分");
            }

            if (detailDO.getRejectStatus() == 8) {
               mapObject.put("rejectStatus", "全部");
            }

            if (StrUtil.isBlank(measure.getAccountingUnit())) {
               Classification classification = classificationMap.get(measure.getClassificationId());
               measure = this.getMeasureV2(classification.getParentId(), measureMap, classificationMap);
            }

            if (detailDO.getRejectStatus() == 4 || detailDO.getRejectStatus() == 8 || detailDO.getRejectStatus() == 2) {
               List<Reject> rejects = rejectMap.get(detailDO.getInboundId());
               List<RejectDetail> rejectDetails = new ArrayList<>();
               Map<String, List<RejectDetail>> finalRejectDetailsMap = rejectDetailsMap;
               rejects.forEach(reject -> {
                  if (reject.getReviewStatus() == 2) {
                     List<RejectDetail> rejectDetails2 = finalRejectDetailsMap.get(reject.getId() + "-" + detailDO.getId());
                     if (CollectionUtil.isNotEmpty(rejectDetails2)) {
                        rejectDetails.addAll(rejectDetails2);
                     }
                  }
               });
               Map<String, Object> rejectMapObject = new HashMap<>();
               if (detailDO.getRejectStatus() == 2 && CollectionUtil.isNotEmpty(rejectDetails)) {
                  mapObject.put("rejectStatus", "部分");
               }

               if (CollectionUtil.isNotEmpty(rejectDetails)) {
                  BigDecimal quantity = rejectDetails.stream()
                     .filter(rejectDetail -> rejectDetail.getQuantity() != null)
                     .map(RejectDetail::getQuantity)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  rejectMapObject.putAll(mapObject);
                  rejectMapObject.put("id", "退货");
                  rejectMapObject.put(
                     "quantity",
                     quantity.compareTo(BigDecimal.ZERO) != 0
                        ? this.unitConversion(quantity, measure.getMeasureUnit(), measure.getMeasurePrecision()).get(1).negate().toPlainString()
                        : "-"
                  );
                  String accountingUnit = measure.getAccountingUnit();
                  BigDecimal rejectMete = rejectDetails.stream()
                     .filter(rejectDetail -> rejectDetail.getMete() != null)
                     .map(RejectDetail::getMete)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  Map<Integer, BigDecimal> mete = this.unitConversion(rejectMete, accountingUnit, measure.getAccountingPrecision());
                  rejectMapObject.put("mete", mete.get(1).negate().toPlainString());
                  BigDecimal amountExcludingVat = rejectDetails.stream()
                     .filter(rejectDetail -> rejectDetail.getAmountExcludingVat() != null)
                     .map(RejectDetail::getAmountExcludingVat)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  rejectMapObject.put("amountExcludingVat", amountExcludingVat.negate().toPlainString());
                  BigDecimal amount = rejectDetails.stream()
                     .filter(rejectDetail -> rejectDetail.getAmount() != null)
                     .map(RejectDetail::getAmount)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  rejectMapObject.put("amount", amount.negate().toPlainString());
                  BigDecimal amountExcludingVATNoFreight = rejectDetails.stream()
                     .filter(rejectDetail -> rejectDetail.getAmountExcludingVatNoFreight() != null)
                     .map(RejectDetail::getAmountExcludingVatNoFreight)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  rejectMapObject.put("amountExcludingVATNoFreight", amountExcludingVATNoFreight.negate().toPlainString());
                  BigDecimal amountNoFreight = rejectDetails.stream()
                     .filter(rejectDetail -> rejectDetail.getAmountNoFreight() != null)
                     .map(RejectDetail::getAmountNoFreight)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  rejectMapObject.put("amountNoFreight", amountNoFreight.negate().toPlainString());
                  if (detailDO.getRejectReviewTime() != null) {
                     rejectMapObject.put("rejectReviewTime", DateTimeFormatter.ofPattern("yyyy/MM/dd").format(detailDO.getRejectReviewTime()));
                  }

                  rejectMapObject.put("remark", "");
               }

               rejectMapObject.remove("project");
               rejectMapObject.remove("monomerName");
               rejectMapObject.remove("areaName");
               mapList.add(rejectMapObject);
            }
         }

         map.put("mapList", mapList);
      } else {
         message = "请选择下载的时间范围";
      }

      this.download(response, message, map, 1);
   }

   private static List<LocalDateTime> outboundExportRange(QueryDetailDTOParam param, boolean allowActualOutboundTime) {
      List<LocalDateTime> reviewRange = param.getReviewTime();
      if (completeDateRange(reviewRange)) {
         return reviewRange;
      }
      List<LocalDateTime> outboundRange = param.getOutboundTime();
      return allowActualOutboundTime && completeDateRange(outboundRange) ? outboundRange : null;
   }

   private static boolean completeDateRange(List<LocalDateTime> range) {
      return range != null && range.size() >= 2 && range.get(0) != null && range.get(1) != null;
   }

   @Override
   public void outboundDownload(QueryDetailDTOParam param, HttpServletResponse response, int type) {
      String message = null;
      HashMap<String, Object> map = new HashMap<>(16);
      List<LocalDateTime> exportRange = outboundExportRange(param, type == 2);
      if (exportRange != null) {
         WeightedPriceConf weightedPriceConf = JSON.parseObject(
            this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置")).getValue(),
            WeightedPriceConf.class
         );
         Map<String, Unit> unitMap = this.unitMapper
            .selectList(new LambdaQueryWrapper<>())
            .stream()
            .collect(Collectors.toMap(Unit::getName, Function.identity()));
         Map<Long, Measure> measureMap = this.measureMapper
            .selectList(new LambdaQueryWrapper<>())
            .stream()
            .collect(Collectors.toMap(Measure::getClassificationId, Function.identity()));
         Map<Long, Classification> classificationMap = this.classificationService
            .list()
            .stream()
            .collect(Collectors.toMap(Classification::getId, Function.identity()));
         Map<Long, User> userMap = this.userService.list().stream().collect(Collectors.toMap(User::getId, Function.identity()));
         Map<Long, Department> departmentMap = this.departmentService.list().stream().collect(Collectors.toMap(Department::getId, Function.identity()));
         param.setClassifyIds(this.queryUtil.getLateClassificationList(param.getClassifyId()));
         String a = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(exportRange.get(0));
         String b = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(exportRange.get(1));
         Map<Long, MonthWeightedAveragePrice> monthWeightedAveragePrices = new HashMap<>();
         Map<Long, MaterialReturnable> materialReturnableMap = new HashMap<>();
         Map<Long, List<ReturnDetail>> returnDetailMap = new HashMap<>();
         new HashMap();
         List<DownLoadDetailDO> list;
         Map<Long, ReturnDetailDO> returnCosts = new HashMap<>();
         String fileName;
         String fileName1;
         if (type == 2) {
            fileName = "outboundDetail";
            fileName1 = "出库明细";
            map.put("outboundData", a + "~" + b);
            param.setTimeType(2);
            list = this.moveOutboundDetailMapper.getDownLoadDetail(param);
            List<Long> collect = list.stream().map(DownLoadDetailDO::getWapId).collect(Collectors.toList());
            if (CollectionUtil.isNotEmpty(collect)) {
               monthWeightedAveragePrices = this.monthWAPMapper
                  .selectList((Wrapper<MonthWeightedAveragePrice>)new LambdaQueryWrapper<MonthWeightedAveragePrice>().in(MonthWeightedAveragePrice::getId, collect))
                  .stream()
                  .collect(Collectors.toMap(MonthWeightedAveragePrice::getId, Function.identity()));
            }

            List<Long> detailCollect = list.stream().map(DownLoadDetailDO::getId).collect(Collectors.toList());
            if (CollectionUtil.isNotEmpty(detailCollect)) {
               List<MaterialReturnable> materialReturnables = this.returnableMapper
                  .selectList((Wrapper<MaterialReturnable>)new LambdaQueryWrapper<MaterialReturnable>().in(MaterialReturnable::getOutboundDetailId, detailCollect));
               if (CollectionUtil.isNotEmpty(materialReturnables)) {
                  materialReturnableMap = materialReturnables.stream().collect(Collectors.toMap(MaterialReturnable::getOutboundDetailId, Function.identity()));
                  List<Long> materialReturnableIds = materialReturnables.stream().map(MaterialReturnable::getId).collect(Collectors.toList());
                  List<ReturnDetail> returnDetails = this.returnDetailMapper.getReturnList(materialReturnableIds);
                  if (CollectionUtil.isNotEmpty(returnDetails)) {
                     returnDetailMap = returnDetails.stream().collect(Collectors.groupingBy(ex -> ex.getMaterialReturnableId()));
                  }
               }
            }
         } else {
            fileName = "returnDetail";
            fileName1 = "退库明细";
            map.put("returnData", a + "~" + b);
            list = this.returnDetailMapper.getDownLoadDetail(param);
            returnCosts = this.reportService.getReturnDetail(param, 1, Integer.MAX_VALUE, null)
               .getContent().stream().collect(Collectors.toMap(ReturnDetailDO::getId, Function.identity()));
            List<MaterialReturnable> materialReturnables = this.returnableMapper.selectList(new LambdaQueryWrapper<>());
            Map<Long, MaterialReturnable> collectMap = materialReturnables.stream().collect(Collectors.toMap(MaterialReturnable::getId, Function.identity()));
         }

         List<ExcelDTO> excelDTOList = new ArrayList<>();
         List<Map<String, Object>> mapList = new ArrayList<>();
         BasicShowConfig basicShowConfig = this.basicConfigService.getBasicShowConfig();
         Map<String, WmsMaterialCodeConfig> materialCodeConfigMaps = this.queryUtil.getMaterialCodeConfigMaps(null);

         for (int i = 0; i < list.size(); i++) {
            Map<String, Object> mapObject = new HashMap<>();
            DownLoadDetailDO detailDO = list.get(i);
            mapObject.put("id", i + 1);
            mapObject.put("data", DateTimeFormatter.ofPattern("yyyy/MM/dd").format(detailDO.getReviewTime()));
            Map<String, String> classMap = this.setClassifyNameV2(
               detailDO.getBasicClass(), detailDO.getClassifyId(), detailDO.getClassifyName(), classificationMap
            );
            mapObject.put("basicClass", classMap.get("分类"));
            mapObject.put("classifyName", classMap.get("名称"));
            StringBuilder sb = new StringBuilder();
            StringBuilder lengths = new StringBuilder();
            StringBuilder material = new StringBuilder();
            this.setSpecs(detailDO, sb, lengths, material);
            mapObject.put("spec", this.queryUtil.getConfigShowSpec(JSON.toJSONString(detailDO), basicShowConfig));
            mapObject.put("material", StrUtil.isNotBlank(material) ? material : "-");
            mapObject.put("lengths", StrUtil.isNotBlank(lengths) ? lengths : "-");
            String s1 = this.queryUtil.buildCompositeKey(detailDO.getClassifyId(), detailDO.getSpecification(), detailDO.getThickness());
            WmsMaterialCodeConfig wmsMaterialCodeConfig = materialCodeConfigMaps.get(s1);
            mapObject.put("materialSnNew", ObjectUtil.isNotEmpty(wmsMaterialCodeConfig) ? wmsMaterialCodeConfig.getMaterialSnNew() : "");
            Measure measure = detailDO.getMeasure();
            if (type == 2) {
               detailDO = this.getDownLoadDetailDO(weightedPriceConf, monthWeightedAveragePrices, detailDO);
            } else {
               ReturnDetailDO cost = returnCosts.get(detailDO.getId());
               if (cost != null) {
                  detailDO.setAmount(cost.getAmount());
                  detailDO.setAmountExcludingVat(cost.getAmountExcludingVAT());
                  detailDO.setUnitPrice(cost.getUnitPrice());
                  detailDO.setUnitPriceExcludingVAT(cost.getUnitPriceExcludingVAT());
                  detailDO.setInputVat(cost.getInputVAT());
               }
            }

            this.setAmountAndMeteV2(
               mapObject,
               detailDO,
               measure,
               classificationMap,
               measureMap,
               unitMap,
               type == 2 ? AmountShowMenuEnum.OUTBOUND_DETAILS.getType() : AmountShowMenuEnum.RETURN_DETAILS.getType()
            );
            mapObject.put("serialNumber", detailDO.getSerialNumber());
            mapObject.put("projectNumber", StrUtil.isNotBlank(detailDO.getProjectNumber()) ? detailDO.getProjectNumber() : "-");
            mapObject.put("projectName", StrUtil.isNotBlank(detailDO.getProjectName()) ? detailDO.getProjectName() : "-");
            mapObject.put("monomerName", StrUtil.isNotBlank(detailDO.getMonomerName()) ? detailDO.getMonomerName() : "-");
            mapObject.put("areaName", StrUtil.isNotBlank(detailDO.getAreaName()) ? detailDO.getAreaName() : "-");
            mapObject.put("areaBatchName", StrUtil.isNotBlank(detailDO.getAreaBatchName()) ? detailDO.getAreaBatchName() : "-");
            if (type == 2) {
               Department byId1 = null;
               if (detailDO.getRecipientId() != null) {
                  User byId = userMap.get(detailDO.getRecipientId());
                  if (byId.getDepartmentId() != null) {
                     byId1 = departmentMap.get(byId.getDepartmentId());
                  }
               }

               if (byId1 != null) {
                  mapObject.put("recipient", StrUtil.isNotBlank(detailDO.getRecipientName()) ? byId1.getName() + "-" + detailDO.getRecipientName() : "-");
               } else {
                  mapObject.put("recipient", StrUtil.isNotBlank(detailDO.getRecipientName()) ? detailDO.getRecipientName() : "-");
               }

               mapObject.put("heatNoAndBatchNo", StrUtil.isNotBlank(detailDO.getHeatNoAndBatchNo()) ? detailDO.getHeatNoAndBatchNo() : "-");
               mapObject.put("workshop", StrUtil.isNotBlank(detailDO.getWorkshopName()) ? detailDO.getWorkshopName() : "-");
               mapObject.put("warehouseName", StrUtil.isNotBlank(detailDO.getWarehouseName()) ? detailDO.getWarehouseName() : "-");
               mapObject.put(
                  "sourceSerialNumber", StrUtil.isNotBlank(detailDO.getDirectionProjectSerialNumber()) ? detailDO.getDirectionProjectSerialNumber() : "-"
               );
               mapObject.put("sourceProject", StrUtil.isNotBlank(detailDO.getDirectionProjectName()) ? detailDO.getDirectionProjectName() : "公共库");
               mapObject.put("sourceMonomer", StrUtil.isNotBlank(detailDO.getDirectionMonomerName()) ? detailDO.getDirectionMonomerName() : "-");
               mapObject.put("sourceArea", StrUtil.isNotBlank(detailDO.getDirectionAreaName()) ? detailDO.getDirectionAreaName() : "-");
               mapObject.put("remark", StrUtil.isNotBlank(detailDO.getRemark()) ? detailDO.getRemark() : "-");
               mapObject.put("brand", StrUtil.isNotBlank(detailDO.getBrand()) ? detailDO.getBrand() : "-");
               MaterialReturnable materialReturnable = materialReturnableMap.get(detailDO.getId());
               List<ReturnDetail> returnDetails = new ArrayList<>();
               if (ObjectUtil.isNotEmpty(materialReturnable)) {
                  returnDetails = returnDetailMap.get(materialReturnable.getId());
               }

               if (CollectionUtil.isNotEmpty(returnDetails)) {
                  BigDecimal returnMete = returnDetails.stream()
                     .filter(returnDetail -> returnDetail.getMete() != null)
                     .map(ReturnDetail::getMete)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  if (returnMete.compareTo(materialReturnable.getMete()) == 0) {
                     mapObject.put("returnState", "全部退库");
                  } else {
                     mapObject.put("returnState", "部分退库");
                  }
               } else {
                  mapObject.put("returnState", "没有退库");
               }

               ExcelDTO excelDTO1 = convertToExcelDTO(mapObject);
               excelDTOList.add(excelDTO1);
            } else {
               MaterialReturnable materialReturnable = this.returnableMapper.selectById(detailDO.getMaterialReturnableId());
               if (materialReturnable.getRecipientId() != null) {
                  mapObject.put("recipient", StrUtil.isNotBlank(materialReturnable.getRecipientName()) ? materialReturnable.getRecipientName() : "-");
                  User byId = this.userService.getById(materialReturnable.getRecipientId());
                  if (byId.getDepartmentId() != null) {
                     Department department = this.departmentService.getById(byId.getDepartmentId());
                     mapObject.put("departmentName", StrUtil.isNotBlank(department.getName()) ? department.getName() : "-");
                  }
               }

               mapObject.put("sourceProject", "-");
               mapObject.put("remark", StrUtil.isNotBlank(detailDO.getRemark()) ? detailDO.getRemark() : "-");
               mapObject.put("outboundSerialNumber", StrUtil.isNotBlank(detailDO.getOutboundSerialNumber()) ? detailDO.getOutboundSerialNumber() : "-");
               ExcelDTO excelDTO1 = convertToExcelDTO(mapObject);
               excelDTOList.add(excelDTO1);
            }

            mapList.add(mapObject);
         }

         map.put("mapList", mapList);
         String s = "";
         if (type == 2) {
            BasicConfig basicInbound = this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "报表下载配置"));
            Preconditions.checkArgument(basicInbound != null, "请配置下载金额是否显示");
            ReportDownload reportDownload = JSON.parseObject(basicInbound.getValue(), ReportDownload.class);
            if (reportDownload.getAmountShow().equals(0) && reportDownload.getAmountExcludingTAXShow().equals(0)) {
               s = "-1";
            } else if (reportDownload.getAmountShow().equals(0)) {
               s = "-2";
            } else if (reportDownload.getAmountExcludingTAXShow().equals(0)) {
               s = "-3";
            }
         }

         Boolean boolShowAmount = null;
         if (type == 2) {
            boolShowAmount = this.getReceiptDetailsBoolShowAmount(AmountShowMenuEnum.OUTBOUND_DETAILS.getType());
         }

         if (type == 4) {
            boolShowAmount = this.getReceiptDetailsBoolShowAmount(AmountShowMenuEnum.RETURN_DETAILS.getType());
         }

         if (Boolean.FALSE.equals(boolShowAmount)) {
            s = "-1";
         }

         if (StrUtil.isNotBlank(s)) {
            fileName = fileName + s;
         }

         this.export(excelDTOList, response, fileName, fileName1, a + "~" + b);
      } else {
         response.setCharacterEncoding("UTF-8");
         response.setHeader("content-Type", "application/vnd.ms-excel");
         response.setHeader("Access-Control-Expose-Headers", "*");

         try {
            response.setHeader("Result", "code=" + ResultCodeEnum.ERROR.getCode() + ";message=" + URLEncoder.encode("请选择下载时间范围", "UTF-8"));
         } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
         }
      }
   }

   private void export(List<ExcelDTO> excelDTOList, HttpServletResponse response, String fileName, String fileName1, String data) {
      OutputStream out = null;

      try {
         out = this.getOutputStream(fileName1, response);
         String resourcePath = "files/template/" + fileName + ".xlsx";
         ClassPathResource classPathResource = new ClassPathResource(resourcePath);
         InputStream inputStream = null;

         try {
            inputStream = classPathResource.getInputStream();
         } catch (IOException e) {
            e.printStackTrace();
         }

         ExcelWriter excelWriter = EasyExcel.write(out).withTemplate(inputStream).excelType(ExcelTypeEnum.XLSX).build();
         WriteSheet writeSheet = EasyExcel.writerSheet().build();
         // The template has one detail row. Insert a row for each additional exported record.
         FillConfig fillConfig = FillConfig.builder().forceNewRow(Boolean.TRUE).build();
         excelWriter.fill(new FillWrapper("t", excelDTOList), fillConfig, writeSheet);
         Map<String, Object> map2 = new HashMap<>(1);
         map2.put("data", data);
         excelWriter.fill(map2, writeSheet);
         excelWriter.finish();
      } finally {
         try {
            if (out != null) {
               out.flush();
               out.close();
            }
         } catch (IOException var20) {
         }
      }
   }

   private OutputStream getOutputStream(String fileName, HttpServletResponse response) {
      try {
         response.setCharacterEncoding("UTF-8");
         response.setHeader("content-Type", "application/vnd.ms-excel");
         response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName + ".xlsx", "UTF-8"));
         response.setHeader("Access-Control-Expose-Headers", "*");
         response.setHeader("Result", "code=" + ResultCodeEnum.SUCCESS.getCode() + ";message=" + ResultCodeEnum.SUCCESS.getCode());
         return response.getOutputStream();
      } catch (IOException e) {
         System.out.println(e.getMessage());
         return null;
      }
   }

   @Override
   public void outboundDownloadAndReturnDownload(QueryDetailDTOParam param, HttpServletResponse response, int type) {
      String message = null;
      HashMap<String, Object> map = new HashMap<>(16);
      List<LocalDateTime> exportRange = outboundExportRange(param, type == 2);
      if (exportRange != null) {
         WeightedPriceConf weightedPriceConf = JSON.parseObject(
            this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置")).getValue(),
            WeightedPriceConf.class
         );
         param.setClassifyIds(this.queryUtil.getLateClassificationList(param.getClassifyId()));
         String a = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(exportRange.get(0));
         String b = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(exportRange.get(1));
         map.put("outboundData", a + "~" + b);
         param.setTimeType(2);
         List<DownLoadDetailDO> list = this.moveOutboundDetailMapper.getDownLoadDetail(param);
         Map<String, Unit> unitMap = this.unitMapper
            .selectList(new LambdaQueryWrapper<>())
            .stream()
            .collect(Collectors.toMap(Unit::getName, Function.identity()));
         Map<Long, User> userMap = this.userService.list().stream().collect(Collectors.toMap(User::getId, Function.identity()));
         Map<Long, Classification> classificationMap = this.classificationService
            .list()
            .stream()
            .collect(Collectors.toMap(Classification::getId, Function.identity()));
         Map<Long, Measure> measureMap = this.measureMapper
            .selectList(new LambdaQueryWrapper<>())
            .stream()
            .collect(Collectors.toMap(Measure::getClassificationId, Function.identity()));
         Map<Long, Department> departmentMap = this.departmentService.list().stream().collect(Collectors.toMap(Department::getId, Function.identity()));
         List<Long> collect = list.stream().map(DownLoadDetailDO::getWapId).collect(Collectors.toList());
         Map<Long, MonthWeightedAveragePrice> monthWeightedAveragePrices = new HashMap<>();
         if (CollectionUtil.isNotEmpty(collect)) {
            monthWeightedAveragePrices = this.monthWAPMapper
               .selectList((Wrapper<MonthWeightedAveragePrice>)new LambdaQueryWrapper<MonthWeightedAveragePrice>().in(MonthWeightedAveragePrice::getId, collect))
               .stream()
               .collect(Collectors.toMap(MonthWeightedAveragePrice::getId, Function.identity()));
         }

         List<Long> detailCollect = list.stream().map(DownLoadDetailDO::getId).collect(Collectors.toList());
         Map<Long, MaterialReturnable> materialReturnableMap = new HashMap<>();
         Map<Long, List<ReturnDetail>> returnDetailMap = new HashMap<>();
         Map<Long, Return> returnMap = new HashMap<>();
         if (CollectionUtil.isNotEmpty(detailCollect)) {
            List<MaterialReturnable> materialReturnables = this.returnableMapper
               .selectList((Wrapper<MaterialReturnable>)new LambdaQueryWrapper<MaterialReturnable>().in(MaterialReturnable::getOutboundDetailId, detailCollect));
            if (CollectionUtil.isNotEmpty(materialReturnables)) {
               materialReturnableMap = materialReturnables.stream().collect(Collectors.toMap(MaterialReturnable::getOutboundDetailId, Function.identity()));
               List<Long> materialReturnableIds = materialReturnables.stream().map(MaterialReturnable::getId).collect(Collectors.toList());
               List<ReturnDetail> returnDetails = this.returnDetailMapper.getReturnList(materialReturnableIds);
               if (CollectionUtil.isNotEmpty(returnDetails)) {
                  returnDetailMap = returnDetails.stream().collect(Collectors.groupingBy(ex -> ex.getMaterialReturnableId()));
                  List<Long> returnIds = returnDetails.stream().map(ReturnDetail::getReturnId).distinct().collect(Collectors.toList());
                  List<Return> returns = this.returnService.listByIds(returnIds);
                  if (CollectionUtil.isNotEmpty(returns)) {
                     returnMap = returns.stream().collect(Collectors.toMap(Return::getId, Function.identity()));
                  }
               }
            }
         }

         BasicShowConfig basicShowConfig = this.basicConfigService.getBasicShowConfig();
         Map<String, WmsMaterialCodeConfig> materialCodeConfigMaps = this.queryUtil.getMaterialCodeConfigMaps(null);
         List<Map<String, Object>> mapList = new ArrayList<>();
         List<ExcelDTO> excelDTOList = new ArrayList<>();

         for (int i = 0; i < list.size(); i++) {
            Map<String, Object> mapObject = new HashMap<>();
            DownLoadDetailDO detailDO = list.get(i);
            mapObject.put("id", i + 1);
            mapObject.put("data", DateTimeFormatter.ofPattern("yyyy/MM/dd").format(detailDO.getReviewTime()));
            Map<String, String> classMap = this.setClassifyNameV2(
               detailDO.getBasicClass(), detailDO.getClassifyId(), detailDO.getClassifyName(), classificationMap
            );
            mapObject.put("basicClass", classMap.get("分类"));
            mapObject.put("classifyName", classMap.get("名称"));
            StringBuilder sb = new StringBuilder();
            StringBuilder lengths = new StringBuilder();
            StringBuilder material = new StringBuilder();
            this.setSpecs(detailDO, sb, lengths, material);
            mapObject.put("spec", this.queryUtil.getConfigShowSpec(JSON.toJSONString(detailDO), basicShowConfig));
            mapObject.put("material", StrUtil.isNotBlank(material) ? material : "-");
            String s1 = this.queryUtil.buildCompositeKey(detailDO.getClassifyId(), detailDO.getSpecification(), detailDO.getThickness());
            WmsMaterialCodeConfig wmsMaterialCodeConfig = materialCodeConfigMaps.get(s1);
            mapObject.put("materialSnNew", ObjectUtil.isNotEmpty(wmsMaterialCodeConfig) ? wmsMaterialCodeConfig.getMaterialSnNew() : "");
            mapObject.put("lengths", StrUtil.isNotBlank(lengths) ? lengths : "-");
            Measure measure = detailDO.getMeasure();
            detailDO = this.getDownLoadDetailDO(weightedPriceConf, monthWeightedAveragePrices, detailDO);
            this.setAmountAndMeteV2(mapObject, detailDO, measure, classificationMap, measureMap, unitMap, AmountShowMenuEnum.OUTBOUND_DETAILS.getType());
            mapObject.put("serialNumber", detailDO.getSerialNumber());
            mapObject.put("projectNumber", StrUtil.isNotBlank(detailDO.getProjectNumber()) ? detailDO.getProjectNumber() : "-");
            mapObject.put("projectName", StrUtil.isNotBlank(detailDO.getProjectName()) ? detailDO.getProjectName() : "-");
            mapObject.put("monomerName", StrUtil.isNotBlank(detailDO.getMonomerName()) ? detailDO.getMonomerName() : "-");
            mapObject.put("areaName", StrUtil.isNotBlank(detailDO.getAreaName()) ? detailDO.getAreaName() : "-");
            mapObject.put("areaBatchName", StrUtil.isNotBlank(detailDO.getAreaBatchName()) ? detailDO.getAreaBatchName() : "-");
            mapObject.put("heatNoAndBatchNo", StrUtil.isNotBlank(detailDO.getHeatNoAndBatchNo()) ? detailDO.getHeatNoAndBatchNo() : "-");
            Department byId1 = null;
            if (detailDO.getRecipientId() != null) {
               User byId = userMap.get(detailDO.getRecipientId());
               if (byId.getDepartmentId() != null) {
                  byId1 = departmentMap.get(byId.getDepartmentId());
               }
            }

            if (byId1 != null) {
               mapObject.put("recipient", StrUtil.isNotBlank(detailDO.getRecipientName()) ? byId1.getName() + "-" + detailDO.getRecipientName() : "-");
            } else {
               mapObject.put("recipient", StrUtil.isNotBlank(detailDO.getRecipientName()) ? detailDO.getRecipientName() : "-");
            }

            mapObject.put("workshop", StrUtil.isNotBlank(detailDO.getWorkshopName()) ? detailDO.getWorkshopName() : "-");
            mapObject.put("warehouseName", StrUtil.isNotBlank(detailDO.getWarehouseName()) ? detailDO.getWarehouseName() : "-");
            mapObject.put(
               "sourceSerialNumber", StrUtil.isNotBlank(detailDO.getDirectionProjectSerialNumber()) ? detailDO.getDirectionProjectSerialNumber() : "-"
            );
            mapObject.put("sourceProject", StrUtil.isNotBlank(detailDO.getDirectionProjectName()) ? detailDO.getDirectionProjectName() : "公共库");
            mapObject.put("sourceMonomer", StrUtil.isNotBlank(detailDO.getDirectionMonomerName()) ? detailDO.getDirectionMonomerName() : "-");
            mapObject.put("sourceArea", StrUtil.isNotBlank(detailDO.getDirectionAreaName()) ? detailDO.getDirectionAreaName() : "-");
            mapObject.put("remark", StrUtil.isNotBlank(detailDO.getRemark()) ? detailDO.getRemark() : "-");
            mapObject.put("brand", StrUtil.isNotBlank(detailDO.getBrand()) ? detailDO.getBrand() : "-");
            MaterialReturnable materialReturnable = materialReturnableMap.get(detailDO.getId());
            List<ReturnDetail> returnDetails = new ArrayList<>();
            if (ObjectUtil.isNotEmpty(materialReturnable)) {
               returnDetails = returnDetailMap.get(materialReturnable.getId());
            }

            mapList.add(mapObject);
            if (StrUtil.isBlank(measure.getAccountingUnit())) {
               Classification classification = classificationMap.get(measure.getClassificationId());
               measure = this.getMeasureV2(classification.getParentId(), measureMap, classificationMap);
            }

            if (CollectionUtil.isNotEmpty(returnDetails)) {
               Measure finalMeasure = measure;

               for (ReturnDetail returnDetail : returnDetails) {
                  Return byId = returnMap.get(returnDetail.getReturnId());
                  if (byId.getReviewStatus() != 2) {
                     mapObject.put("returnState", "没有退库");
                  } else {
                     Map<String, Object> returnMapObject = new HashMap<>();
                     returnMapObject.putAll(mapObject);
                     returnMapObject.put("id", "退库");
                     StringBuilder spec = new StringBuilder();
                     DownLoadDetailDO build = DownLoadDetailDO.builder()
                        .specification(returnDetail.getSpecification())
                        .length(returnDetail.getLength())
                        .width(returnDetail.getWidth())
                        .thickness(returnDetail.getThickness())
                        .color(returnDetail.getColor())
                        .basicClass(returnDetail.getBasicClass())
                        .build();
                     this.setSpec(build, spec);
                     returnMapObject.put("lengths", returnDetail.getLength() != null ? returnDetail.getLength().stripTrailingZeros().toPlainString() : "-");
                     returnMapObject.put("spec", this.queryUtil.getConfigShowSpec(JSON.toJSONString(returnDetail), basicShowConfig));
                     if (returnDetail.getQuantity() != null) {
                        returnMapObject.put(
                           "quantity",
                           returnDetail.getQuantity().compareTo(BigDecimal.ZERO) != 0
                              ? this.unitConversionV2(returnDetail.getQuantity(), finalMeasure.getMeasureUnit(), finalMeasure.getMeasurePrecision(), unitMap)
                                 .get(1)
                                 .negate()
                                 .toPlainString()
                              : "-"
                        );
                     } else {
                        returnMapObject.put("quantity", "-");
                     }

                     String accountingUnit = finalMeasure.getAccountingUnit();
                     Map<Integer, BigDecimal> mete = this.unitConversionV2(
                        returnDetail.getMete(), accountingUnit, finalMeasure.getAccountingPrecision(), unitMap
                     );
                     returnMapObject.put("mete", mete.get(1).negate().toPlainString());
                     if (detailDO.getActualTheoryWeight() != null && detailDO.getMete() != null) {
                        BigDecimal p = returnDetail.getMete().divide(detailDO.getMete(), 20, 4);
                        Map<Integer, BigDecimal> actualTheoryWeight = this.unitConversionV2(
                           detailDO.getActualTheoryWeight().multiply(p), accountingUnit, finalMeasure.getAccountingPrecision(), unitMap
                        );
                        returnMapObject.put("actualTheoryWeight", actualTheoryWeight.get(1).negate().toPlainString());
                     }

                     if (returnDetail.getAmountExcludingVat() != null) {
                        returnMapObject.put(
                           "amountExcludingVat",
                           returnDetail.getAmountExcludingVat().compareTo(BigDecimal.ZERO) != 0
                              ? returnDetail.getAmountExcludingVat().negate().toPlainString()
                              : "-"
                        );
                     } else {
                        returnMapObject.put("amountExcludingVat", "-");
                     }

                     if (returnDetail.getAmount() != null) {
                        returnMapObject.put(
                           "amount", returnDetail.getAmount().compareTo(BigDecimal.ZERO) != 0 ? returnDetail.getAmount().negate().toPlainString() : "-"
                        );
                     } else {
                        returnMapObject.put("amount", "-");
                     }

                     returnMapObject.put("remark", StrUtil.isNotBlank(returnDetail.getRemark()) ? returnDetail.getRemark() : "-");
                     returnMapObject.put("returnTime", DateTimeFormatter.ofPattern("yyyy/MM/dd").format(byId.getReturnTime()));
                     BigDecimal returnMete = returnDetails.stream()
                        .filter(returnDetail1 -> returnDetail1.getMete() != null)
                        .map(ReturnDetail::getMete)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
                     if (returnMete.compareTo(materialReturnable.getMete()) == 0) {
                        mapObject.put("returnState", "全部退库");
                        returnMapObject.put("returnState", "全部退库");
                     } else {
                        mapObject.put("returnState", "部分退库");
                        returnMapObject.put("returnState", "部分退库");
                     }

                     mapList.add(returnMapObject);
                     ExcelDTO excelDTO1 = convertToExcelDTO(returnMapObject);
                     excelDTOList.add(excelDTO1);
                  }
               }
            } else {
               mapObject.put("returnState", "没有退库");
            }

            ExcelDTO excelDTO = convertToExcelDTO(mapObject);
            excelDTOList.add(excelDTO);
         }

         map.put("mapList", mapList);
         String fileName = "outboundDetail";
         BasicConfig basicInbound = this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "报表下载配置"));
         Preconditions.checkArgument(basicInbound != null, "请配置下载金额是否显示");
         ReportDownload reportDownload = JSON.parseObject(basicInbound.getValue(), ReportDownload.class);
         String s = "";
         if (reportDownload.getAmountShow().equals(0) && reportDownload.getAmountExcludingTAXShow().equals(0)) {
            s = "-1";
         } else if (reportDownload.getAmountShow().equals(0)) {
            s = "-2";
         } else if (reportDownload.getAmountExcludingTAXShow().equals(0)) {
            s = "-3";
         }

         Boolean boolShowAmount = null;
         if (type == 2) {
            boolShowAmount = this.getReceiptDetailsBoolShowAmount(AmountShowMenuEnum.OUTBOUND_DETAILS.getType());
         }

         if (Boolean.FALSE.equals(boolShowAmount)) {
            s = "-1";
         }

         if (StrUtil.isNotBlank(s)) {
            fileName = fileName + s;
         }

         this.export(excelDTOList, response, fileName, "出库体现退库", a + "~" + b);
      } else {
         response.setCharacterEncoding("UTF-8");
         response.setHeader("content-Type", "application/vnd.ms-excel");
         response.setHeader("Access-Control-Expose-Headers", "*");

         try {
            response.setHeader("Result", "code=" + ResultCodeEnum.ERROR.getCode() + ";message=" + URLEncoder.encode("请选择下载时间范围", "UTF-8"));
         } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
         }
      }
   }

   public static ExcelDTO convertToExcelDTO(Map<String, Object> map) {
      ExcelDTO excelDTO = new ExcelDTO();
      excelDTO.setId(map.get("id").toString());
      excelDTO.setData((String)map.get("data"));
      excelDTO.setBasicClass((String)map.get("basicClass"));
      excelDTO.setClassifyName((String)map.get("classifyName"));
      excelDTO.setSpec(map.containsKey("spec") ? map.get("spec").toString() : "-");
      excelDTO.setMaterial(map.containsKey("material") ? map.get("material").toString() : "-");
      excelDTO.setLengths(map.containsKey("lengths") ? map.get("lengths").toString() : "-");
      excelDTO.setSerialNumber(map.containsKey("serialNumber") ? map.get("serialNumber").toString() : "-");
      excelDTO.setProjectNumber(map.containsKey("projectNumber") ? map.get("projectNumber").toString() : "-");
      excelDTO.setProjectName(map.containsKey("projectName") ? map.get("projectName").toString() : "-");
      excelDTO.setHeatNoAndBatchNo(map.containsKey("heatNoAndBatchNo") ? map.get("heatNoAndBatchNo").toString() : "-");
      excelDTO.setMeasureUnit(map.containsKey("measureUnit") ? map.get("measureUnit").toString() : "-");
      excelDTO.setQuantity(map.containsKey("quantity") ? map.get("quantity").toString() : "-");
      excelDTO.setAccountingUnit(map.containsKey("accountingUnit") ? map.get("accountingUnit").toString() : "-");
      excelDTO.setMete(map.containsKey("mete") ? map.get("mete").toString() : "-");
      excelDTO.setTaxRate(map.containsKey("taxRate") ? map.get("taxRate").toString() : "-");
      excelDTO.setUnitPrice(map.containsKey("unitPrice") ? map.get("unitPrice").toString() : "-");
      excelDTO.setUnitPriceExcludingVat(map.containsKey("unitPriceExcludingVat") ? map.get("unitPriceExcludingVat").toString() : "-");
      excelDTO.setAmount(map.containsKey("amount") ? map.get("amount").toString() : "-");
      excelDTO.setAmountExcludingVat(map.containsKey("amountExcludingVat") ? map.get("amountExcludingVat").toString() : "-");
      excelDTO.setAmountNoFreight(map.containsKey("amountNoFreight") ? map.get("amountNoFreight").toString() : "-");
      excelDTO.setAmountExcludingVatNoFreight(map.containsKey("amountExcludingVatNoFreight") ? map.get("amountExcludingVatNoFreight").toString() : "-");
      excelDTO.setInputVat(map.containsKey("inputVat") ? map.get("inputVat").toString() : "-");
      excelDTO.setRdRate(map.containsKey("rdRate") ? map.get("rdRate").toString() : "-");
      excelDTO.setRdFee(map.containsKey("rdFee") ? map.get("rdFee").toString() : "-");
      excelDTO.setReturnTime(map.containsKey("returnTime") ? map.get("returnTime").toString() : "-");
      excelDTO.setRecipient(map.containsKey("recipient") ? map.get("recipient").toString() : "-");
      excelDTO.setWorkshop(map.containsKey("workshop") ? map.get("workshop").toString() : "-");
      excelDTO.setWarehouseName(map.containsKey("warehouseName") ? map.get("warehouseName").toString() : "-");
      excelDTO.setSourceSerialNumber(map.containsKey("sourceSerialNumber") ? map.get("sourceSerialNumber").toString() : "-");
      excelDTO.setSourceProject(map.containsKey("sourceProject") ? map.get("sourceProject").toString() : "-");
      excelDTO.setRemark(map.containsKey("remark") ? map.get("remark").toString() : "-");
      excelDTO.setBrand(map.containsKey("brand") ? map.get("brand").toString() : "-");
      excelDTO.setReturnState(map.containsKey("returnState") ? map.get("returnState").toString() : "-");
      excelDTO.setOutboundSerialNumber(map.containsKey("outboundSerialNumber") ? map.get("outboundSerialNumber").toString() : "-");
      excelDTO.setDepartmentName(map.containsKey("departmentName") ? map.get("departmentName").toString() : "-");
      excelDTO.setTransferType(map.containsKey("transferType") ? map.get("transferType").toString() : "-");
      excelDTO.setDirectionProjectName(map.containsKey("directionProjectName") ? map.get("directionProjectName").toString() : "-");
      excelDTO.setRejectSN(map.containsKey("rejectSN") ? map.get("rejectSN").toString() : "-");
      excelDTO.setMaterialSn(map.containsKey("materialSn") ? map.get("materialSn").toString() : "-");
      excelDTO.setSource(map.containsKey("source") ? map.get("source").toString() : "-");
      excelDTO.setDirection(map.containsKey("direction") ? map.get("direction").toString() : "-");
      excelDTO.setAreaBatchName(map.containsKey("areaBatchName") ? map.get("areaBatchName").toString() : "-");
      excelDTO.setMaterialSnNew(map.containsKey("materialSnNew") ? map.get("materialSnNew").toString() : "-");
      excelDTO.setActualTheoryWeight(map.containsKey("actualTheoryWeight") ? map.get("actualTheoryWeight").toString() : "-");
      excelDTO.setOutboundSn(map.containsKey("outboundSn") ? map.get("outboundSn").toString() : "-");
      return excelDTO;
   }

   @Override
   public void transferDownload(QueryDetailDTOParam param, HttpServletResponse response) {
      String message = null;
      HashMap<String, Object> map = new HashMap<>(16);
      if (CollectionUtil.isNotEmpty(param.getReviewTime())) {
         List<ExcelDTO> excelDTOList = new ArrayList<>();
         param.setClassifyIds(this.queryUtil.getLateClassificationList(param.getClassifyId()));
         String a = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(param.getReviewTime().get(0));
         String b = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(param.getReviewTime().get(1));
         map.put("transferData", a + "~" + b);
         List<DownLoadDetailDO> list = this.transferDetailMapper.getDownLoadDetail(param, param.getTransferType());
         Map<String, Unit> unitMap = this.unitMapper
            .selectList(new LambdaQueryWrapper<>())
            .stream()
            .collect(Collectors.toMap(Unit::getName, Function.identity()));
         Map<Long, Classification> classificationMap = this.classificationService
            .list()
            .stream()
            .collect(Collectors.toMap(Classification::getId, Function.identity()));
         Map<Long, Measure> measureMap = this.measureMapper
            .selectList(new LambdaQueryWrapper<>())
            .stream()
            .collect(Collectors.toMap(Measure::getClassificationId, Function.identity()));
         List<Map<String, Object>> mapList = new ArrayList<>();
         BasicShowConfig basicShowConfig = this.basicConfigService.getBasicShowConfig();
         Map<String, WmsMaterialCodeConfig> materialCodeConfigMaps = this.queryUtil.getMaterialCodeConfigMaps(null);

         for (int i = 0; i < list.size(); i++) {
            Map<String, Object> mapObject = new HashMap<>();
            DownLoadDetailDO detailDO = list.get(i);
            mapObject.put("id", i + 1);
            mapObject.put("data", DateTimeFormatter.ofPattern("yyyy/MM/dd").format(detailDO.getReviewTime()));
            Map<String, String> classMap = this.setClassifyNameV2(
               detailDO.getBasicClass(), detailDO.getClassifyId(), detailDO.getClassifyName(), classificationMap
            );
            mapObject.put("basicClass", classMap.get("分类"));
            mapObject.put("classifyName", classMap.get("名称"));
            String s1 = this.queryUtil.buildCompositeKey(detailDO.getClassifyId(), detailDO.getSpecification(), detailDO.getThickness());
            WmsMaterialCodeConfig wmsMaterialCodeConfig = materialCodeConfigMaps.get(s1);
            mapObject.put("materialSnNew", ObjectUtil.isNotEmpty(wmsMaterialCodeConfig) ? wmsMaterialCodeConfig.getMaterialSnNew() : "");
            if (StrUtil.isNotBlank(detailDO.getProjectName())) {
               mapObject.put("projectName", detailDO.getProjectName() + "(" + detailDO.getWarehouseName() + ")");
               mapObject.put("monomerName", StrUtil.isNotBlank(detailDO.getMonomerName()) ? detailDO.getMonomerName() : "-");
               mapObject.put("areaName", StrUtil.isNotBlank(detailDO.getAreaName()) ? detailDO.getAreaName() : "-");
            } else {
               mapObject.put("projectName", "公共库(" + detailDO.getWarehouseName() + ")");
            }

            if (StrUtil.isNotBlank(detailDO.getDirectionProjectName())) {
               mapObject.put("directionProjectName", detailDO.getDirectionProjectName() + "(" + detailDO.getDirectionWareHouseName() + ")");
               mapObject.put("directionMonomer", StrUtil.isNotBlank(detailDO.getDirectionMonomerName()) ? detailDO.getDirectionMonomerName() : "-");
               mapObject.put("directionArea", StrUtil.isNotBlank(detailDO.getDirectionAreaName()) ? detailDO.getDirectionAreaName() : "-");
            } else if (TransferTypeEnum.RETURN_PARTY_A.getType().equals(detailDO.getTransferType())) {
               mapObject.put("directionProjectName", "-");
            } else {
               mapObject.put("directionProjectName", "公共库(" + detailDO.getDirectionWareHouseName() + ")");
            }

            StringBuilder sb = new StringBuilder();
            this.setSpec(detailDO, sb);
            mapObject.put("spec", this.queryUtil.getConfigShowSpec(JSON.toJSONString(detailDO), basicShowConfig));
            Measure measure = detailDO.getMeasure();
            this.setAmountAndMeteV2(mapObject, detailDO, measure, classificationMap, measureMap, unitMap, AmountShowMenuEnum.TRANSFER_DETAILS.getType());
            mapObject.put("serialNumber", detailDO.getSerialNumber());
            mapObject.put("transferType", TransferTypeEnum.getNameByType(detailDO.getTransferType()));
            mapObject.put("outboundSn", StrUtil.isNotBlank(detailDO.getOutboundSn()) ? detailDO.getOutboundSn() : "-");
            mapList.add(mapObject);
            ExcelDTO excelDTO = convertToExcelDTO(mapObject);
            excelDTOList.add(excelDTO);
         }

         map.put("mapList", mapList);
         String fileName = "transferDetail";
         String s = "";
         Boolean boolShowAmount = this.getReceiptDetailsBoolShowAmount(AmountShowMenuEnum.TRANSFER_DETAILS.getType());
         if (!boolShowAmount) {
            s = "-1";
         }

         if (StrUtil.isNotBlank(s)) {
            fileName = fileName + s;
         }

         this.export(excelDTOList, response, fileName, "调拨明细", a + "~" + b);
      } else {
         response.setCharacterEncoding("UTF-8");
         response.setHeader("content-Type", "application/vnd.ms-excel");
         response.setHeader("Access-Control-Expose-Headers", "*");

         try {
            response.setHeader("Result", "code=" + ResultCodeEnum.ERROR.getCode() + ";message=" + URLEncoder.encode("请选择下载时间范围", "UTF-8"));
         } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
         }
      }
   }

   @Override
   public void moveMaterialDownload(QueryDetailDTOParam param, HttpServletResponse response) {
      HashMap<String, Object> map = new HashMap<>(16);
      if (CollectionUtil.isNotEmpty(param.getOutboundTime())) {
         List<ExcelDTO> excelDTOList = new ArrayList<>();
         param.setClassifyIds(this.queryUtil.getLateClassificationList(param.getClassifyId()));
         String a = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(param.getOutboundTime().get(0));
         String b = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(param.getOutboundTime().get(1));
         map.put("moveMaterialData", a + "~" + b);
         List<DownLoadDetailDO> list = this.moveMaterialDetailMapper.getDownLoadDetail(param);
         Map<Long, MoveMaterialMaterialDO> moveCosts = this.reportService.getMoveMaterialDetail(param, 1, Integer.MAX_VALUE, null)
            .getContent().stream().collect(Collectors.toMap(MoveMaterialMaterialDO::getId, Function.identity()));
         Map<String, Unit> unitMap = this.unitMapper
            .selectList(new LambdaQueryWrapper<>())
            .stream()
            .collect(Collectors.toMap(Unit::getName, Function.identity()));
         Map<Long, Classification> classificationMap = this.classificationService
            .list()
            .stream()
            .collect(Collectors.toMap(Classification::getId, Function.identity()));
         Map<Long, Measure> measureMap = this.measureMapper
            .selectList(new LambdaQueryWrapper<>())
            .stream()
            .collect(Collectors.toMap(Measure::getClassificationId, Function.identity()));
         List<Map<String, Object>> mapList = new ArrayList<>();
         BasicShowConfig basicShowConfig = this.basicConfigService.getBasicShowConfig();

         for (int i = 0; i < list.size(); i++) {
            Map<String, Object> mapObject = new HashMap<>();
            DownLoadDetailDO detailDO = list.get(i);
            MoveMaterialMaterialDO cost = moveCosts.get(detailDO.getId());
            if (cost != null) {
               detailDO.setAmount(cost.getAmount());detailDO.setAmountExcludingVat(cost.getAmountExcludingVAT());
               detailDO.setUnitPrice(cost.getUnitPrice());detailDO.setUnitPriceExcludingVAT(cost.getUnitPriceExcludingVAT());detailDO.setInputVat(cost.getInputVAT());
            }
            mapObject.put("id", i + 1);
            mapObject.put("data", DateTimeFormatter.ofPattern("yyyy/MM/dd").format(detailDO.getReviewTime()));
            Map<String, String> classMap = this.setClassifyNameV2(
               detailDO.getBasicClass(), detailDO.getClassifyId(), detailDO.getClassifyName(), classificationMap
            );
            mapObject.put("basicClass", classMap.get("分类"));
            mapObject.put("classifyName", classMap.get("名称"));
            if (StrUtil.isNotBlank(detailDO.getProjectName())) {
               mapObject.put("projectName", detailDO.getProjectName());
            } else {
               mapObject.put("projectName", "-");
            }

            mapObject.put("source", detailDO.getWmsWorkshopName() + "(" + detailDO.getWarehouseName() + ")");
            mapObject.put("direction", detailDO.getDirectionWmsWorkshopName() + "(" + detailDO.getDirectionWareHouseName() + ")");
            StringBuilder sb = new StringBuilder();
            this.setSpec(detailDO, sb);
            mapObject.put("spec", this.queryUtil.getConfigShowSpec(JSON.toJSONString(detailDO), basicShowConfig));
            Measure measure = detailDO.getMeasure();
            this.setAmountAndMeteV2(mapObject, detailDO, measure, classificationMap, measureMap, unitMap, AmountShowMenuEnum.MOVE_WAREHOUSE_DETAILS.getType());
            mapObject.put("serialNumber", detailDO.getSerialNumber());
            mapList.add(mapObject);
            ExcelDTO excelDTO = convertToExcelDTO(mapObject);
            excelDTOList.add(excelDTO);
         }

         map.put("mapList", mapList);
         this.export(excelDTOList, response, "moveMaterialDetail", "移库明细", a + "~" + b);
      } else {
         response.setCharacterEncoding("UTF-8");
         response.setHeader("content-Type", "application/vnd.ms-excel");
         response.setHeader("Access-Control-Expose-Headers", "*");

         try {
            response.setHeader("Result", "code=" + ResultCodeEnum.ERROR.getCode() + ";message=" + URLEncoder.encode("请选择下载时间范围", "UTF-8"));
         } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
         }
      }
   }

   private void setAmountAndMete(Map<String, Object> mapObject, DownLoadDetailDO detailDO, Measure measure) {
      this.setAmountAndMete(mapObject, detailDO, measure,
         UserUtil.getCurrentUser().getPermissions().contains("wms_report_rawMat_sendAndReceiveStorage:showAmount"));
   }

   private void setAmountAndMete(Map<String, Object> mapObject, DownLoadDetailDO detailDO, Measure measure, boolean boolShowAmount) {
      if (StrUtil.isBlank(measure.getAccountingUnit())) {
         Classification classification = this.classificationMapper.selectById(measure.getClassificationId());
         measure = this.getMeasure(classification.getParentId());
      }

      String measureUnit = measure.getMeasureUnit();
      String accountingUnit = measure.getAccountingUnit();
      if (BasicClassEnum.COLOR_ROLL.getType().equals(detailDO.getBasicClass()) && detailDO.getLength() != null) {
         mapObject.put("measureUnit", "张");
         mapObject.put("quantity", detailDO.getQuantity().stripTrailingZeros().toPlainString());
      } else {
         mapObject.put("measureUnit", StrUtil.isNotBlank(measureUnit) ? measureUnit : "-");
         mapObject.put(
            "quantity",
            detailDO.getQuantity() != null
               ? this.unitConversion(detailDO.getQuantity(), measureUnit, measure.getMeasurePrecision()).get(1).toPlainString()
               : "-"
         );
      }

      mapObject.put("accountingUnit", accountingUnit);
      Map<Integer, BigDecimal> mete = this.unitConversion(detailDO.getMete(), accountingUnit, measure.getAccountingPrecision());
      mapObject.put("mete", mete.get(1).toPlainString());
      if (InvoiceTypeEnum.SPECIAL.getType().equals(detailDO.getInvoiceType()) && detailDO.getTaxRate() != null) {
         mapObject.put("taxRate", detailDO.getTaxRate().setScale(0).toPlainString());
      } else {
         mapObject.put("taxRate", "-");
      }

      if (detailDO.getAmount() != null) {

         if (boolShowAmount) {
            mapObject.put("unitPrice", detailDO.getUnitPrice().multiply(mete.get(2)).setScale(2, 4));
            BigDecimal bigDecimal = detailDO.getUnitPriceExcludingVAT().multiply(mete.get(2)).setScale(2, 4);
            mapObject.put("unitPriceExcludingVat", detailDO.getUnitPriceExcludingVAT().multiply(mete.get(2)).setScale(2, 4));
            mapObject.put("amount", detailDO.getAmount().setScale(this.amountAccuracy, 4));
            mapObject.put("amountExcludingVat", detailDO.getAmountExcludingVat().setScale(this.amountAccuracy, 4));
            if (InvoiceTypeEnum.SPECIAL.getType().equals(detailDO.getInvoiceType())) {
               mapObject.put("inputVat", detailDO.getAmount().subtract(detailDO.getAmountExcludingVat()).setScale(2, 4));
            } else {
               mapObject.put("inputVat", "-");
            }

            if (measure.getRdRate() != null) {
               mapObject.put("rdRate", measure.getRdRate().toPlainString() + "%");
               mapObject.put("rdFee", detailDO.getAmountExcludingVat().multiply(measure.getRdRate().divide(BigDecimal.valueOf(100L))).setScale(2, 4));
            } else {
               mapObject.put("rdRate", "-");
               mapObject.put("rdFee", "-");
            }
         }
      } else {
         mapObject.put("unitPrice", "-");
         mapObject.put("unitPriceExcludingVat", "-");
         mapObject.put("amount", "-");
         mapObject.put("amountExcludingVat", "-");
         mapObject.put("inputVat", "-");
         mapObject.put("rdRate", "-");
         mapObject.put("rdFee", "-");
      }
   }

   private void setAmountAndMeteV2(
      Map<String, Object> mapObject,
      DownLoadDetailDO detailDO,
      Measure measure,
      Map<Long, Classification> classificationMap,
      Map<Long, Measure> measureMap,
      Map<String, Unit> unitMap,
      Integer menuType
   ) {
      if (StrUtil.isBlank(measure.getAccountingUnit())) {
         Classification classification = classificationMap.get(measure.getClassificationId());
         measure = this.getMeasureV2(classification.getParentId(), measureMap, classificationMap);
      }

      String measureUnit = measure.getMeasureUnit();
      String accountingUnit = measure.getAccountingUnit();
      if (BasicClassEnum.COLOR_ROLL.getType().equals(detailDO.getBasicClass()) && detailDO.getLength() != null) {
         mapObject.put("measureUnit", "张");
         mapObject.put("quantity", detailDO.getQuantity().stripTrailingZeros().toPlainString());
      } else {
         mapObject.put("measureUnit", StrUtil.isNotBlank(measureUnit) ? measureUnit : "-");
         mapObject.put(
            "quantity",
            detailDO.getQuantity() != null
               ? this.unitConversionV2(detailDO.getQuantity(), measureUnit, measure.getMeasurePrecision(), unitMap).get(1).toPlainString()
               : "-"
         );
      }

      mapObject.put("accountingUnit", accountingUnit);
      Map<Integer, BigDecimal> mete = this.unitConversionV2(detailDO.getMete(), accountingUnit, measure.getAccountingPrecision(), unitMap);
      mapObject.put("mete", mete.get(1).toPlainString());
      if (detailDO.getActualTheoryWeight() != null) {
         Map<Integer, BigDecimal> actualTheoryWeight = this.unitConversionV2(
            detailDO.getActualTheoryWeight(), accountingUnit, measure.getAccountingPrecision(), unitMap
         );
         mapObject.put("actualTheoryWeight", actualTheoryWeight.get(1).toPlainString());
      }

      if (InvoiceTypeEnum.SPECIAL.getType().equals(detailDO.getInvoiceType()) && detailDO.getTaxRate() != null) {
         mapObject.put("taxRate", detailDO.getTaxRate().setScale(0).toPlainString());
      } else {
         mapObject.put("taxRate", "-");
      }

      if (detailDO.getAmount() != null) {
         boolean boolShowAmount = this.getReceiptDetailsBoolShowAmount(menuType);
         if (boolShowAmount) {
            mapObject.put("unitPrice", detailDO.getUnitPrice().multiply(mete.get(2)).setScale(2, 4));
            mapObject.put("unitPriceExcludingVat", detailDO.getUnitPriceExcludingVAT().multiply(mete.get(2)).setScale(2, 4));
            mapObject.put("amount", detailDO.getAmount().setScale(this.amountAccuracy, 4));
            mapObject.put("amountExcludingVat", detailDO.getAmountExcludingVat().setScale(this.amountAccuracy, 4));
            if (detailDO.getUnitPriceNoFreight() != null) {
               mapObject.put("unitPriceNoFreight", detailDO.getUnitPriceNoFreight().multiply(mete.get(2)).setScale(2, 4));
            }

            if (detailDO.getUnitPriceExcludingVATNoFreight() != null) {
               mapObject.put("unitPriceExcludingVATNoFreight", detailDO.getUnitPriceExcludingVATNoFreight().multiply(mete.get(2)).setScale(2, 4));
            }

            if (detailDO.getAmountExcludingVATNoFreight() != null) {
               mapObject.put("amountExcludingVATNoFreight", detailDO.getAmountExcludingVATNoFreight().setScale(this.amountAccuracy, 4));
            }

            if (detailDO.getAmountNoFreight() != null) {
               mapObject.put("amountNoFreight", detailDO.getAmountNoFreight().setScale(this.amountAccuracy, 4));
            }

            if (InvoiceTypeEnum.SPECIAL.getType().equals(detailDO.getInvoiceType())) {
               mapObject.put("inputVat", detailDO.getAmount().subtract(detailDO.getAmountExcludingVat()).setScale(2, 4));
            } else {
               mapObject.put("inputVat", "-");
            }

            if (measure.getRdRate() != null) {
               mapObject.put("rdRate", measure.getRdRate().toPlainString() + "%");
               mapObject.put("rdFee", detailDO.getAmountExcludingVat().multiply(measure.getRdRate().divide(BigDecimal.valueOf(100L))).setScale(2, 4));
            } else {
               mapObject.put("rdRate", "-");
               mapObject.put("rdFee", "-");
            }
         }
      } else {
         mapObject.put("unitPrice", "-");
         mapObject.put("unitPriceExcludingVat", "-");
         mapObject.put("amount", "-");
         mapObject.put("amountExcludingVat", "-");
         mapObject.put("inputVat", "-");
         mapObject.put("rdRate", "-");
         mapObject.put("rdFee", "-");
      }
   }

   @Override
   public void returnDetailDownload(QueryDetailDTOParam param, HttpServletResponse response) {
      param.setOutboundTime(param.getReviewTime());
      this.outboundDownload(param, response, 4);
   }

   @Override
   public void rejectDetailDownload(QueryRejectDetailDTOParam param, HttpServletResponse response) {
      String message = null;
      HashMap<String, Object> map = new HashMap<>(16);
      if (CollectionUtil.isNotEmpty(param.getReviewTime())) {
         List<RejectDetailDO> list = this.rejectDetailMapper.getList(param);
         List<Map<String, Object>> mapList = new ArrayList<>();

         for (int i = 0; i < list.size(); i++) {
            Map<String, Object> mapObject = new HashMap<>();
            RejectDetailDO rejectDetailDO = list.get(i);
            mapObject.put("id", i + 1);
            String a = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(param.getReviewTime().get(0));
            String b = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(param.getReviewTime().get(1));
            map.put("rejectData", a + "~" + b);
            mapObject.put("data", DateTimeFormatter.ofPattern("yyyy/MM/dd").format(rejectDetailDO.getReviewTime()));
            Map<String, String> classMap = this.setClassifyName(
               rejectDetailDO.getBasicClass(), rejectDetailDO.getClassifyId(), rejectDetailDO.getClassifyName()
            );
            mapObject.put("basicClass", classMap.get("分类"));
            mapObject.put("classifyName", classMap.get("名称"));
            ClassifySpecDTO classifyById = this.classificationService.getClassifyById(rejectDetailDO.getClassifyId());
            mapObject.put("measureUnit", classifyById.getMeasureUnit());
            mapObject.put("serialNumber", rejectDetailDO.getMaterialSn());
            mapObject.put("spec", rejectDetailDO.getSpecification());
            mapObject.put("brand", rejectDetailDO.getBrand());
            mapObject.put("quantity", rejectDetailDO.getQuantity());
            mapObject.put("mete", rejectDetailDO.getMete());
            mapObject.put("unitPrice", rejectDetailDO.getUnitPrice());
            mapObject.put("unitPriceExcludingVAT", rejectDetailDO.getUnitPriceExcludingVAT());
            mapObject.put("amountExcludingVAT", rejectDetailDO.getAmountExcludingVAT());
            mapObject.put("amount", rejectDetailDO.getAmount());
            if (rejectDetailDO.getProject() != null) {
               mapObject.put("projectName", StrUtil.isNotBlank(rejectDetailDO.getProject().getShortName()) ? rejectDetailDO.getProject().getShortName() : "-");
            }

            if (rejectDetailDO.getWarehouse() != null) {
               mapObject.put("warehouseName", rejectDetailDO.getWarehouse().getName());
            }

            mapObject.put("rejectSN", rejectDetailDO.getRejectSN());
            mapList.add(mapObject);
         }

         map.put("mapList", mapList);
      } else {
         message = "请选择下载的月份";
      }

      this.download(response, message, map, 19);
   }

   @Override
   public void RDFeeDownload(QueryDetailDTOParam param, HttpServletResponse response) {
      String message = null;
      HashMap<String, Object> map = new HashMap<>(16);
      if (CollectionUtil.isNotEmpty(param.getOutboundTime())) {
         param.setClassifyIds(this.queryUtil.getLateClassificationList(param.getClassifyId()));
         map.put("date", DateTimeFormatter.ofPattern("yyyy/MM").format(param.getOutboundTime().get(0)));
         param.setTimeType(1);
         List<DownLoadDetailDO> list = this.moveOutboundDetailMapper.getDownLoadDetail(param);
         Map<Long, RDFeeDTO> rdCosts = this.reportService.getHighTechRDFee(param, 1, Integer.MAX_VALUE, null)
            .getContent().stream().collect(Collectors.toMap(RDFeeDTO::getId, Function.identity()));
         BasicShowConfig basicShowConfig = this.basicConfigService.getBasicShowConfig();
         List<Map<String, Object>> mapList = new ArrayList<>();

         for (int i = 0; i < list.size(); i++) {
            Map<String, Object> mapObject = new HashMap<>();
            DownLoadDetailDO detailDO = list.get(i);
            RDFeeDTO cost = rdCosts.get(detailDO.getId());
            if (cost != null) {
               detailDO.setAmount(cost.getAmount());detailDO.setAmountExcludingVat(cost.getAmountExcludingVAT());
               detailDO.setUnitPrice(cost.getUnitPrice());detailDO.setUnitPriceExcludingVAT(cost.getUnitPriceExcludingVAT());detailDO.setInputVat(cost.getInputVAT());
            }
            mapObject.put("id", i + 1);
            mapObject.put("data", DateTimeFormatter.ofPattern("yyyy/MM/dd").format(detailDO.getReviewTime()));
            Map<String, String> classMap = this.setClassifyName(detailDO.getBasicClass(), detailDO.getClassifyId(), detailDO.getClassifyName());
            mapObject.put("basicClass", classMap.get("分类"));
            mapObject.put("classifyName", classMap.get("名称"));
            StringBuilder sb = new StringBuilder();
            this.setSpec(detailDO, sb);
            mapObject.put("spec", this.queryUtil.getConfigShowSpec(JSON.toJSONString(detailDO), basicShowConfig));
            Measure measure = detailDO.getMeasure();
            this.setAmountAndMete(mapObject, detailDO, measure, true);
            mapObject.put("serialNumber", detailDO.getSerialNumber());
            mapObject.put("projectName", StrUtil.isNotBlank(detailDO.getProjectName()) ? detailDO.getProjectName() : "-");
            mapObject.put("monomerName", StrUtil.isNotBlank(detailDO.getMonomerName()) ? detailDO.getMonomerName() : "-");
            mapObject.put("areaName", StrUtil.isNotBlank(detailDO.getAreaName()) ? detailDO.getAreaName() : "-");
            mapList.add(mapObject);
         }

         map.put("mapList", mapList);
      } else {
         message = "请选择下载的月份";
      }

      this.download(response, message, map, 5);
   }

   @Override
   public void statisticsDownload(QueryStatisticsDTOParam param, HttpServletResponse response) {
      String message = null;
      HashMap<String, Object> map = new HashMap<>(16);
      if (param.getCreateTime() != null) {
         BasicShowConfig basicShowConfig = this.basicConfigService.getBasicShowConfig();
         map.put("date", DateTimeFormatter.ofPattern("yyyy/MM").format(param.getCreateTime()));
         WeightedExecutionPriceConf execution = JSON.parseObject(
            this.basicConfigService.getOne(Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权执行方式配置")).getValue(),
            WeightedExecutionPriceConf.class
         );
         List<StatisticsDTO> list = (WeightedPriceTypeEnum.MONTH.getType().equals(execution.getWeightedExecutionType())
            ? this.reportService.getStatistics(param)
            : this.reportService.getStatisticsUser(param)).getContent();
         Map<String, WmsMaterialCodeConfig> materialCodeConfigMaps = this.queryUtil.getMaterialCodeConfigMaps(null);
         List<Map<String, Object>> mapList = new ArrayList<>();

         for (int i = 0; i < list.size(); i++) {
            Map<String, Object> mapObject = new HashMap<>();
            StatisticsDTO dto = list.get(i);
            mapObject.put("id", i + 1);
            Map<String, String> classMap = this.setClassifyName(dto.getBasicClass(), dto.getClassifyId(), dto.getClassifyName());
            mapObject.put("basicClass", classMap.get("分类"));
            mapObject.put("classifyName", classMap.get("名称"));
            String s1 = this.queryUtil
               .buildCompositeKey(
                  dto.getClassifyId(), CollectionUtil.isNotEmpty(dto.getSpecifications()) ? dto.getSpecifications().get(0) : "", dto.getThickness()
               );
            WmsMaterialCodeConfig wmsMaterialCodeConfig = materialCodeConfigMaps.get(s1);
            mapObject.put("materialSnNew", ObjectUtil.isNotEmpty(wmsMaterialCodeConfig) ? wmsMaterialCodeConfig.getMaterialSnNew() : "-");
            String spec = null;
            if (BasicClassEnum.STEEL_PLATE.getType().equals(dto.getBasicClass())) {
               if (CollectionUtil.isNotEmpty(dto.getSpecifications())) {
                  List<String> collect = dto.getSpecifications()
                     .stream()
                     .map(s -> dto.getThickness().stripTrailingZeros().toPlainString() + " * " + s)
                     .collect(Collectors.toList());
                  List<String> specListByConfig = this.getStatisticsSpecList(dto.getBasicClass(), collect, basicShowConfig);
                  spec = StrUtil.join(",", specListByConfig);
               } else {
                  spec = dto.getThickness().stripTrailingZeros().toPlainString();
               }
            } else if (BasicClassEnum.COLOR_ROLL.getType().equals(dto.getBasicClass())) {
               if (CollectionUtil.isNotEmpty(dto.getSpecifications())) {
                  List<String> collect = dto.getSpecifications()
                     .stream()
                     .map(s -> dto.getThickness().stripTrailingZeros().toPlainString() + " * " + s + " * " + dto.getColor())
                     .collect(Collectors.toList());
                  List<String> specListByConfig = this.getStatisticsSpecList(dto.getBasicClass(), collect, basicShowConfig);
                  spec = StrUtil.join(",", specListByConfig);
               } else {
                  spec = dto.getThickness().stripTrailingZeros().toPlainString() + (dto.getColor() != null ? " * " + dto.getColor() : "");
               }
            } else if ((BasicClassEnum.SECTION_STEEL.getType().equals(dto.getBasicClass()) || BasicClassEnum.checkNotSteel(dto.getBasicClass()))
               && CollectionUtil.isNotEmpty(dto.getSpecifications())) {
               List<String> specListByConfig = this.getStatisticsSpecList(dto.getBasicClass(), dto.getSpecifications(), basicShowConfig);
               spec = StrUtil.join(",", specListByConfig);
            }

            mapObject.put("spec", StrUtil.isNotBlank(spec) ? spec : "-");
            mapObject.put("brand", StrUtil.isNotBlank(dto.getBrand()) ? dto.getBrand() : "-");
            if (dto.getProject() != null) {
               mapObject.put("projectName", dto.getProject().getShortName());
            }

            Measure measure = dto.getMeasure();
            DetailDTO beginPeriod = dto.getBeginPeriod();
            DetailDTO inbound = dto.getInbound();
            DetailDTO outbound = dto.getOutbound();
            DetailDTO endPeriod = dto.getEndPeriod();
            DetailDTO transfer = dto.getTransfer();
            String measureUnit;
            String accountingUnit;
            Integer measurePrecision;
            Integer accountingPrecision;
            if (measure.getAccountingUnit() != null) {
               measureUnit = measure.getMeasureUnit();
               accountingUnit = measure.getAccountingUnit();
               measurePrecision = measure.getMeasurePrecision();
               accountingPrecision = measure.getAccountingPrecision();
            } else {
               Classification classification = this.classificationMapper.selectById(dto.getClassifyId());
               Measure m = this.getMeasure(classification.getParentId());
               measureUnit = m.getMeasureUnit();
               accountingUnit = m.getAccountingUnit();
               measurePrecision = m.getMeasurePrecision();
               accountingPrecision = m.getAccountingPrecision();
            }

            if (measureUnit != null) {
               mapObject.put("measureUnit", measureUnit);
            } else {
               mapObject.put("measureUnit", "-");
            }

            mapObject.put("accountingUnit", accountingUnit);
            boolean boolShowAmount = UserUtil.getCurrentUser().getPermissions().contains("wms_report_rawMat_sendAndReceiveStorage:showAmount");
            if (beginPeriod != null) {
               mapObject.put(
                  "beginQuantity",
                  beginPeriod.getQuantity() != null
                     ? this.unitConversion(beginPeriod.getQuantity(), measureUnit, measurePrecision).get(1).toPlainString()
                     : "-"
               );
               Map<Integer, BigDecimal> decimalMap = this.unitConversion(beginPeriod.getMete(), accountingUnit, accountingPrecision);
               mapObject.put("beginMete", decimalMap.get(1) != null ? decimalMap.get(1).toPlainString() : "-");
               if (beginPeriod.getAmountExcludingVAT() != null && boolShowAmount) {
                  mapObject.put("beginUnitPrice", beginPeriod.getUnitPriceExcludingVAT().multiply(decimalMap.get(2)).setScale(2, 4).toPlainString());
                  mapObject.put("beginAmount", beginPeriod.getAmountExcludingVAT().setScale(this.amountAccuracy, 4).toPlainString());
               }
            } else {
               mapObject.put("beginQuantity", "-");
               mapObject.put("beginMete", "-");
               mapObject.put("beginUnitPrice", "-");
               mapObject.put("beginAmount", "-");
            }

            if (inbound != null) {
               mapObject.put(
                  "inboundQuantity",
                  inbound.getQuantity() != null ? this.unitConversion(inbound.getQuantity(), measureUnit, measurePrecision).get(1).toPlainString() : "-"
               );
               Map<Integer, BigDecimal> inboundMap = this.unitConversion(inbound.getMete(), accountingUnit, accountingPrecision);
               mapObject.put("inboundMete", inboundMap.get(1).toPlainString());
               if (inbound.getAmountExcludingVAT() != null && boolShowAmount) {
                  if (inbound.getUnitPriceExcludingVAT() != null && inboundMap.get(2) != null) {
                     mapObject.put("inboundUnitPrice", inbound.getUnitPriceExcludingVAT().multiply(inboundMap.get(2)).setScale(2, 4).toPlainString());
                     mapObject.put("inboundAmount", inbound.getAmountExcludingVAT().setScale(this.amountAccuracy, 4).toPlainString());
                  }
               } else {
                  BigDecimal amount1 = inbound.getAmountExcludingVAT() != null ? inbound.getAmountExcludingVAT() : BigDecimal.ZERO;
                  mapObject.put("inboundAmount", amount1.compareTo(BigDecimal.ZERO) == 0 ? "-" : amount1.setScale(this.amountAccuracy, 4).toPlainString());
               }
            } else {
               mapObject.put("inboundQuantity", "-");
               mapObject.put("inboundMete", "-");
               mapObject.put("inboundUnitPrice", "-");
               mapObject.put("inboundAmount", "-");
            }

            if (outbound != null) {
               mapObject.put(
                  "outboundQuantity",
                  outbound.getQuantity() != null ? this.unitConversion(outbound.getQuantity(), measureUnit, measurePrecision).get(1).toPlainString() : "-"
               );
               if (outbound.getMete() != null) {
                  Map<Integer, BigDecimal> outboundMap = this.unitConversion(outbound.getMete(), accountingUnit, accountingPrecision);
                  mapObject.put("outboundMete", outboundMap.get(1).toPlainString());
                  if (outbound.getAmountExcludingVAT() != null && boolShowAmount && outbound.getUnitPriceExcludingVAT() != null && outboundMap.get(2) != null) {
                     mapObject.put("outboundUnitPrice", outbound.getUnitPriceExcludingVAT().multiply(outboundMap.get(2)).setScale(2, 4).toPlainString());
                     mapObject.put("outboundAmount", outbound.getAmountExcludingVAT().setScale(this.amountAccuracy, 4).toPlainString());
                  }
               } else {
                  BigDecimal amount1 = outbound.getAmountExcludingVAT() != null ? outbound.getAmountExcludingVAT() : BigDecimal.ZERO;
                  mapObject.put("outboundAmount", amount1.compareTo(BigDecimal.ZERO) == 0 ? "-" : amount1.setScale(this.amountAccuracy, 4).toPlainString());
               }
            } else {
               mapObject.put("outboundQuantity", "-");
               mapObject.put("outboundMete", "-");
               mapObject.put("outboundUnitPrice", "-");
               mapObject.put("outboundAmount", "-");
            }

            if (endPeriod != null) {
               mapObject.put(
                  "endQuantity",
                  endPeriod.getQuantity() != null ? this.unitConversion(endPeriod.getQuantity(), measureUnit, measurePrecision).get(1).toPlainString() : "-"
               );
               if (endPeriod.getMete() != null && endPeriod.getMete().compareTo(BigDecimal.ZERO) != 0) {
                  Map<Integer, BigDecimal> endMap = this.unitConversion(endPeriod.getMete(), accountingUnit, accountingPrecision);
                  mapObject.put("endMete", endMap.get(1).toPlainString());
                  if (endPeriod.getAmountExcludingVAT() != null && boolShowAmount) {
                     mapObject.put("endUnitPrice", endPeriod.getUnitPriceExcludingVAT().multiply(endMap.get(2)).setScale(2, 4).toPlainString());
                     mapObject.put("endAmount", endPeriod.getAmountExcludingVAT().setScale(this.amountAccuracy, 4).toPlainString());
                  }
               } else {
                  BigDecimal amount1 = endPeriod.getAmountExcludingVAT() != null ? endPeriod.getAmountExcludingVAT() : BigDecimal.ZERO;
                  mapObject.put("endAmount", amount1.compareTo(BigDecimal.ZERO) == 0 ? "-" : amount1.setScale(this.amountAccuracy, 4).toPlainString());
               }
            } else {
               mapObject.put("endQuantity", 0);
               mapObject.put("endMete", 0);
               mapObject.put("endUnitPrice", 0);
               mapObject.put("endAmount", 0);
            }

            if (transfer != null) {
               mapObject.put(
                  "transferQuantity",
                  transfer.getQuantity() != null ? this.unitConversion(transfer.getQuantity(), measureUnit, measurePrecision).get(1).toPlainString() : "-"
               );
               if (transfer.getMete() != null && transfer.getMete().compareTo(BigDecimal.ZERO) != 0) {
                  Map<Integer, BigDecimal> endMap = this.unitConversion(transfer.getMete(), accountingUnit, accountingPrecision);
                  mapObject.put("transferMete", endMap.get(1).toPlainString());
                  if (boolShowAmount && transfer.getUnitPriceExcludingVAT() != null) {
                     mapObject.put("transferUnitPrice", transfer.getUnitPriceExcludingVAT().multiply(endMap.get(2)).setScale(2, 4).toPlainString());
                  }
               }
               if (boolShowAmount && transfer.getAmountExcludingVAT() != null) {
                  mapObject.put("transferAmount", transfer.getAmountExcludingVAT().setScale(this.amountAccuracy, 4).toPlainString());
               }
            } else {
               mapObject.put("transferQuantity", 0);
               mapObject.put("transferMete", 0);
               mapObject.put("transferUnitPrice", 0);
               mapObject.put("transferAmount", 0);
            }

            mapList.add(mapObject);
         }

         map.put("mapList", mapList);
      } else {
         message = "请选择下载的月份";
      }

      this.download(response, message, map, 6);
   }

   private List<String> getStatisticsSpecList(Integer basicClass, List<String> specList, BasicShowConfig basicShowConfig) {
      if (CollectionUtil.isEmpty(specList)) {
         return new ArrayList<>();
      }

      String symbol = " * ";
      return specList.stream().map(old -> {
         if (old.contains(symbol) && basicShowConfig.getSteelsSpeShowConfig().equals(2) && !BasicClassEnum.SECTION_STEEL.getType().equals(basicClass)) {
            if (BasicClassEnum.COLOR_ROLL.getType().equals(basicClass)) {
               Object[] split = StrUtil.split(old, " * ").toArray();
               if (split.length == 3) {
                  return split[1] + symbol + split[0] + symbol + split[2];
               }

               if (split.length == 2) {
                  return split[1] + symbol + split[0];
               }
            }

            return StrUtil.subAfter(old, symbol, true) + symbol + StrUtil.subBefore(old, symbol, true);
         } else {
            return (String)old;
         }
      }).collect(Collectors.toList());
   }

   private String getStatisticsSpec(Integer basicClass, String oldSpec, BasicShowConfig basicShowConfig) {
      if (StrUtil.isEmpty(oldSpec)) {
         return oldSpec;
      } else {
         String symbol = " * ";
         if (!oldSpec.contains(symbol) || !basicShowConfig.getSteelsSpeShowConfig().equals(2)) {
            return oldSpec;
         } else if (BasicClassEnum.COLOR_ROLL.getType().equals(basicClass)) {
            Object[] split = StrUtil.split(oldSpec, " * ").toArray();
            return split[1] + symbol + split[0] + symbol + split[2];
         } else {
            return StrUtil.subAfter(oldSpec, symbol, true) + symbol + StrUtil.subBefore(oldSpec, symbol, true);
         }
      }
   }

   private Measure getMeasure(Long pid) {
      Measure m = this.measureMapper.selectOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, pid));
      if (m.getAccountingUnit() != null) {
         return m;
      }

      Classification classification = this.classificationMapper.selectById(pid);
      return this.getMeasure(classification.getParentId());
   }

   private Measure getMeasureV2(Long pid, Map<Long, Measure> measureMap, Map<Long, Classification> classificationMap) {
      Measure m = measureMap.get(pid);
      if (m.getAccountingUnit() != null) {
         return m;
      }

      Classification classification = classificationMap.get(pid);
      return this.getMeasureV2(classification.getParentId(), measureMap, classificationMap);
   }

   @Override
   public void statisticsDetailDownload(List<Long> ids, Integer formType, LocalDateTime date, List<Long> statIds, HttpServletResponse response) {
      HashMap<String, Object> map = new HashMap<>(16);
      List<StatisticsDetailDTO> list = this.reportService.getStatisticsDetail(ids, statIds, formType, date).getContent();
      Map<String, WmsMaterialCodeConfig> materialCodeConfigMaps = this.queryUtil.getMaterialCodeConfigMaps(null);
      BasicShowConfig basicShowConfig = this.basicConfigService.getBasicShowConfig();
      List<Map<String, Object>> mapList = new ArrayList<>();

      for (int i = 0; i < list.size(); i++) {
         Map<String, Object> mapObject = new HashMap<>();
         StatisticsDetailDTO dto = list.get(i);
         String s1 = this.queryUtil.buildCompositeKey(dto.getClassifyId(), dto.getSpecification(), dto.getThickness());
         WmsMaterialCodeConfig wmsMaterialCodeConfig = materialCodeConfigMaps.get(s1);
         Measure measure = this.measureMapper.selectOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, dto.getClassifyId()));
         if (StrUtil.isBlank(measure.getAccountingUnit())) {
            Classification classification = this.classificationMapper.selectById(dto.getClassifyId());
            measure = this.getMeasure(classification.getParentId());
         }

         mapObject.put("id", i + 1);
         Map<String, String> classMap = this.setClassifyName(dto.getBasicClass(), dto.getClassifyId(), dto.getClassifyName());
         mapObject.put("basicClass", classMap.get("分类"));
         mapObject.put("classifyName", classMap.get("名称"));
         mapObject.put("materialSnNew", ObjectUtil.isNotEmpty(wmsMaterialCodeConfig) ? wmsMaterialCodeConfig.getMaterialSnNew() : "");
         mapObject.put("mUnit", measure.getMeasureUnit() != null ? measure.getMeasureUnit() : "-");
         mapObject.put(
            "quantity",
            dto.getQuantity() != null
               ? this.unitConversion(dto.getQuantity(), measure.getMeasureUnit(), measure.getMeasurePrecision()).get(1).toPlainString()
               : "-"
         );
         mapObject.put("aUnit", measure.getAccountingUnit());
         Map<Integer, BigDecimal> decimalMap = this.unitConversion(dto.getMete(), measure.getAccountingUnit(), measure.getAccountingPrecision());
         mapObject.put("mete", decimalMap.get(1).toPlainString());
         mapObject.put("spec", this.queryUtil.getConfigShowSpec(JSON.toJSONString(dto), basicShowConfig));
         mapObject.put("brand", StrUtil.isNotBlank(dto.getBrand()) ? dto.getBrand() : "-");
         mapObject.put("heatNo", StrUtil.isNotBlank(dto.getHeatNoAndBatchNo()) ? dto.getHeatNoAndBatchNo() : "-");
         boolean boolShowAmount = UserUtil.getCurrentUser().getPermissions().contains("wms_report_rawMat_sendAndReceiveStorage:showAmount");
         if (boolShowAmount) {
            if (dto.getUnitPrice() != null) {
               mapObject.put("unitPrice", dto.getUnitPrice().multiply(decimalMap.get(2)).setScale(2, 4));
            }

            if (dto.getAmount() != null) {
               mapObject.put("amount", dto.getAmount().setScale(this.amountAccuracy, 4));
            }

            if (dto.getAmountExcludingVAT() != null) {
               mapObject.put("amountExcludingVat", dto.getAmountExcludingVAT().setScale(this.amountAccuracy, 4));
            }

            if (InvoiceTypeEnum.SPECIAL.getType().equals(dto.getInvoiceType()) && dto.getAmount() != null && dto.getAmountExcludingVAT() != null) {
               mapObject.put("inputVat", dto.getAmount().subtract(dto.getAmountExcludingVAT()).setScale(this.amountAccuracy, 4));
            }
         }

         mapObject.put("project", dto.getProject() != null ? dto.getProject().getShortName() : "-");
         mapObject.put("monomer", StrUtil.isNotBlank(dto.getMonomerName()) ? dto.getMonomerName() : "-");
         mapObject.put("area", StrUtil.isNotBlank(dto.getAreaName()) ? dto.getAreaName() : "-");
         mapObject.put("workshop", dto.getWorkshop().getName() + "/" + dto.getWarehouse().getName());
         if (formType.equals(3) && dto.getMesWorkshop() != null && dto.getMesWorkshop().getName() != null) {
            mapObject.put("mesWorkshop", dto.getMesWorkshop().getName());
         }

         if (!formType.equals(1) && !formType.equals(4)) {
            mapObject.put("type", ReceiptTypeEnum.getName(dto.getReceipt().getReceiptType()));
            mapObject.put("sn", dto.getReceipt().getSerialNumber());
         } else {
            mapObject.put("type", "-");
            mapObject.put("sn", "-");
         }

         mapList.add(mapObject);
      }

      map.put("mapList", mapList);
      switch (formType) {
         case 1:
            map.put("heading", "收发存期初");
            break;
         case 2:
            map.put("heading", "收发存入库");
            break;
         case 3:
            map.put("heading", "收发存出库");
            break;
         case 4:
            map.put("heading", "收发存期末");
      }

      this.download(response, null, map, 7);
   }

   @Override
   public void inventoryDetailExcel(
      Integer basicClass, List<Long> classifyId, Integer orderSupplyType, List<Long> workshopIds, String specification, HttpServletResponse response
   ) {
      String message = null;
      HashMap<String, Object> map = new HashMap<>(16);
      if (CollectionUtil.isNotEmpty(classifyId)) {
         classifyId = this.queryUtil.getLateClassificationList(classifyId);
      }

      List<MaterialInventoryDTO> list = this.materialInventoryMapper
         .getTotalInventory(basicClass, classifyId, orderSupplyType, workshopIds, specification)
         .stream()
         .peek(dto -> {
            MaterialInventory materialInventory = BeanUtil.copy(dto, MaterialInventory.class);
            if (dto.getProject() != null) {
               materialInventory.setProjectId(dto.getProject().getId());
            }

            if (dto.getWorkshop() != null) {
               materialInventory.setWorkshopId(dto.getWorkshop().getId());
            }
         })
         .sorted(Comparator.comparing(MaterialInventoryDTO::getId).reversed())
         .collect(Collectors.toList());
      Map<String, List<MonthWeightedAveragePrice>> monthWeightedAveragePriceMap = new HashMap<>();
      List<MonthWeightedAveragePrice> monthWeightedAveragePriceList = this.monthWAPMapper.selectList(new LambdaQueryWrapper<>());
      if (CollectionUtil.isNotEmpty(monthWeightedAveragePriceList)) {
         monthWeightedAveragePriceMap = monthWeightedAveragePriceList.stream().collect(Collectors.groupingBy(e -> e.getClassifyId() + "-" + e.getBasicClass()));
      }

      List<Long> collect = list.stream().map(MaterialInventoryDTO::getId).collect(Collectors.toList());
      Map<Long, MaterialInventory> materialInventoryMap = new HashMap<>();
      if (CollectionUtil.isNotEmpty(collect)) {
         materialInventoryMap = this.materialInventoryMapper
            .selectList((Wrapper<MaterialInventory>)new LambdaQueryWrapper<MaterialInventory>().in(MaterialInventory::getId, collect))
            .stream()
            .collect(Collectors.toMap(MaterialInventory::getId, Function.identity()));
      }

      Map<String, Unit> unitMap = this.unitMapper.selectList(new LambdaQueryWrapper<>()).stream().collect(Collectors.toMap(Unit::getName, Function.identity()));
      Map<Long, Measure> measureMap = this.measureMapper
         .selectList(new LambdaQueryWrapper<>())
         .stream()
         .collect(Collectors.toMap(Measure::getClassificationId, Function.identity()));
      Map<Long, Classification> classificationMap = this.classificationService
         .list()
         .stream()
         .collect(Collectors.toMap(Classification::getId, Function.identity()));
      WeightedPriceConf weightedPriceConf = JSON.parseObject(
         this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置")).getValue(), WeightedPriceConf.class
      );
      BasicShowConfig basicShowConfig = this.basicConfigService.getBasicShowConfig();
      List<Map<String, Object>> mapList = new ArrayList<>();

      for (int i = 0; i < list.size(); i++) {
         Map<String, Object> mapObject = new HashMap<>();
         MaterialInventoryDTO materialInventoryDTO = list.get(i);
         DownLoadDetailDO detailDO = BeanUtil.copy(materialInventoryDTO, DownLoadDetailDO.class);
         detailDO.setAmountExcludingVat(materialInventoryDTO.getAmountExcludingVAT());
         mapObject.put("id", i + 1);
         Map<String, String> classMap = this.setClassifyName(detailDO.getBasicClass(), detailDO.getClassifyId(), detailDO.getClassifyName());
         mapObject.put("basicClass", classMap.get("分类"));
         mapObject.put("classifyName", classMap.get("名称"));
         StringBuilder sb = new StringBuilder();
         StringBuilder lengths = new StringBuilder();
         StringBuilder material = new StringBuilder();
         this.setSpecs(detailDO, sb, lengths, material);
         mapObject.put("spec", this.queryUtil.getConfigShowSpec(JSON.toJSONString(detailDO), basicShowConfig));
         Measure measure = measureMap.get(materialInventoryDTO.getClassifyId());
         if (StrUtil.isBlank(measure.getAccountingUnit())) {
            Classification classification = classificationMap.get(measure.getClassificationId());
            measure = this.getMeasureV2(classification.getParentId(), measureMap, classificationMap);
         }

         this.setAmountAndMeteV2(
            mapObject, detailDO, measure, classificationMap, measureMap, unitMap, AmountShowMenuEnum.RECEIVING_DISPATCHING_STORING.getType()
         );
         MaterialInventory materialInventory1 = materialInventoryMap.get(materialInventoryDTO.getId());
         MonthWeightedAveragePrice price = this.getWeightedAveragePrice(monthWeightedAveragePriceMap, materialInventory1);
         Preconditions.checkArgument(price != null, "操作失败,获取月末加权平均价失败!");
         if (WeightedPriceEnum.WHOLE.getType().equals(weightedPriceConf.getWeightedType())) {
            WholeWeightedAveragePrice wholeWeightedAveragePrice = this.wholeWeightedAveragePriceMapper.selectById(price.getWholeWapId());
            price.setMete(wholeWeightedAveragePrice.getMete());
            price.setAmount(wholeWeightedAveragePrice.getAmount());
            price.setAmountExcludingVat(wholeWeightedAveragePrice.getAmountExcludingVat());
         }

         BigDecimal p = materialInventoryDTO.getMete().divide(price.getMete(), 20, RoundingMode.HALF_UP);
         BigDecimal amount = price.getAmount().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
         BigDecimal amountExcludingVat = price.getAmountExcludingVat().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
         BigDecimal avgPrice = NumberUtil.div(amount, materialInventoryDTO.getMete(), 12);
         BigDecimal excludingVatAvgPrice = NumberUtil.div(amountExcludingVat, materialInventoryDTO.getMete(), 12);
         Map<Integer, BigDecimal> mete = this.unitConversion(detailDO.getMete(), measure.getAccountingUnit(), measure.getAccountingPrecision());
         mapObject.put("unitPrice", avgPrice.multiply(mete.get(2)).setScale(2, 4));
         mapObject.put("unitPriceExcludingVat", excludingVatAvgPrice.multiply(mete.get(2)).setScale(2, 4));
         mapObject.put("amount", amount);
         mapObject.put("amountExcludingVat", amountExcludingVat);
         mapObject.put("material", StrUtil.isNotBlank(material) ? material : "-");
         mapObject.put(
            "thickness", materialInventoryDTO.getThickness() != null ? materialInventoryDTO.getThickness().stripTrailingZeros().toPlainString() : "-"
         );
         mapObject.put("width", materialInventoryDTO.getWidth() != null ? materialInventoryDTO.getWidth().stripTrailingZeros().toPlainString() : "-");
         mapObject.put("lengths", StrUtil.isNotBlank(lengths) ? lengths : "-");
         mapObject.put("mUnit", StrUtil.isNotBlank(measure.getMeasureUnit()) ? measure.getMeasureUnit() : "-");
         mapObject.put("aUnit", StrUtil.isNotBlank(measure.getAccountingUnit()) ? measure.getAccountingUnit() : "-");
         mapObject.put("brand", StrUtil.isNotBlank(materialInventoryDTO.getBrand()) ? materialInventoryDTO.getBrand() : "-");
         mapObject.put("heatNo", StrUtil.isNotBlank(materialInventoryDTO.getHeatNoAndBatchNo()) ? materialInventoryDTO.getHeatNoAndBatchNo() : "-");
         mapObject.put("factory", materialInventoryDTO.getWorkshop() != null ? materialInventoryDTO.getWorkshop().getName() : "-");
         if (mapObject.get("factory").equals("-")) {
            mapObject.put("factory", materialInventoryDTO.getWarehouse() != null ? materialInventoryDTO.getWarehouse().getName() : "-");
         } else if (materialInventoryDTO.getWarehouse() != null) {
            mapObject.put("factory", materialInventoryDTO.getWorkshop().getName() + "/" + materialInventoryDTO.getWarehouse().getName());
         }

         mapObject.put("remark", materialInventoryDTO.getRemark() != null ? materialInventoryDTO.getRemark() : "-");
         mapObject.put("project", materialInventoryDTO.getProject() != null ? materialInventoryDTO.getProject().getName() : "-");
         mapObject.put("monomerName", materialInventoryDTO.getMonomerName() != null ? materialInventoryDTO.getMonomerName() : "-");
         mapObject.put("areaName", materialInventoryDTO.getAreaName() != null ? materialInventoryDTO.getAreaName() : "-");
         mapList.add(mapObject);
      }

      map.put("mapList", mapList);
      this.download(response, null, map, 8);
   }

   @Override
   public void inventoryBeginExcel(List<Integer> basicClass, Boolean boolPartyA, String specification, HttpServletResponse response) {
      basicClass = basicClass.stream().distinct().collect(Collectors.toList());
      List<MaterialFreeze> freezeList = this.materialFreezeService
         .list(Wrappers.lambdaQuery(MaterialFreeze.class).eq(MaterialFreeze::getBoolPartyA, boolPartyA).in(MaterialFreeze::getBasicClass, basicClass));
      if (CollectionUtil.isNotEmpty(freezeList)) {
         try {
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Access-Control-Expose-Headers", "*");
            response.setHeader("Result", "code=" + ResultCodeEnum.ERROR.getCode() + ";message=" + URLEncoder.encode("当前物料仓库存在冻结中的物料，请处理后再导出物料库存", "UTF-8"));
         } catch (IOException e) {
            response.setHeader("Result", "code=" + ResultCodeEnum.ERROR.getCode() + ";message=" + ResultCodeEnum.ERROR.getCode());
         }
      } else {
         if (basicClass.size() == 1) {
            this.downloadInventoryToExcel(basicClass.get(0), boolPartyA, specification, response);
         } else {
            this.packageDownloadInventory(basicClass, boolPartyA, specification, response);
         }
      }
   }

   private void downloadInventoryToExcel(Integer basicClass, Boolean boolPartyA, String specification, HttpServletResponse response) {
      HashMap<String, Object> map = new HashMap<>(16);
      List<MaterialInventoryDTO> list = this.materialInventoryMapper
         .getTotalInventory(basicClass, null, boolPartyA ? 2 : 1, null, specification)
         .stream()
         .peek(dto -> {
            MaterialInventory materialInventory = BeanUtil.copy(dto, MaterialInventory.class);
            if (dto.getProject() != null) {
               materialInventory.setProjectId(dto.getProject().getId());
            }

            if (dto.getWorkshop() != null) {
               materialInventory.setWorkshopId(dto.getWorkshop().getId());
            }
         })
         .sorted(Comparator.comparing(MaterialInventoryDTO::getId).reversed())
         .collect(Collectors.toList());
      Map<String, List<MonthWeightedAveragePrice>> monthWeightedAveragePriceMap = new HashMap<>();
      List<MonthWeightedAveragePrice> monthWeightedAveragePriceList = this.monthWAPMapper.selectList(new LambdaQueryWrapper<>());
      if (CollectionUtil.isNotEmpty(monthWeightedAveragePriceList)) {
         monthWeightedAveragePriceMap = monthWeightedAveragePriceList.stream().collect(Collectors.groupingBy(e -> e.getClassifyId() + "-" + e.getBasicClass()));
      }

      List<Long> collect = list.stream().map(MaterialInventoryDTO::getId).collect(Collectors.toList());
      Map<Long, MaterialInventory> materialInventoryMap = new HashMap<>();
      if (CollectionUtil.isNotEmpty(collect)) {
         materialInventoryMap = this.materialInventoryMapper
            .selectList((Wrapper<MaterialInventory>)new LambdaQueryWrapper<MaterialInventory>().in(MaterialInventory::getId, collect))
            .stream()
            .collect(Collectors.toMap(MaterialInventory::getId, Function.identity()));
      }

      Map<String, Unit> unitMap = this.unitMapper.selectList(new LambdaQueryWrapper<>()).stream().collect(Collectors.toMap(Unit::getName, Function.identity()));
      Map<Long, Measure> measureMap = this.measureMapper
         .selectList(new LambdaQueryWrapper<>())
         .stream()
         .collect(Collectors.toMap(Measure::getClassificationId, Function.identity()));
      Map<Long, Classification> classificationMap = this.classificationService
         .list()
         .stream()
         .collect(Collectors.toMap(Classification::getId, Function.identity()));
      WeightedPriceConf weightedPriceConf = JSON.parseObject(
         this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置")).getValue(), WeightedPriceConf.class
      );
      List<Long> classifyIds = list.stream().map(MaterialInventoryDTO::getClassifyId).distinct().collect(Collectors.toList());
      Map<Long, String> fullNamePathMap = this.getFullNamePathMap(basicClass, classifyIds);
      List<Map<String, Object>> mapList = new ArrayList<>();

      for (int i = 0; i < list.size(); i++) {
         Map<String, Object> mapObject = new HashMap<>();
         MaterialInventoryDTO materialInventoryDTO = list.get(i);
         DownLoadDetailDO detailDO = BeanUtil.copy(materialInventoryDTO, DownLoadDetailDO.class);
         detailDO.setAmountExcludingVat(materialInventoryDTO.getAmountExcludingVAT());
         mapObject.put("id", i + 1);
         Map<String, String> classMap = this.setClassifyName(detailDO.getBasicClass(), detailDO.getClassifyId(), detailDO.getClassifyName());
         mapObject.put("basicClass", classMap.get("分类"));
         mapObject.put("classifyName", fullNamePathMap.get(materialInventoryDTO.getClassifyId()));
         StringBuilder sb = new StringBuilder();
         StringBuilder lengths = new StringBuilder();
         StringBuilder material = new StringBuilder();
         this.setSpec(detailDO, sb);
         mapObject.put("spec", detailDO.getSpecification());
         if (BasicClassEnum.SECTION_STEEL.getType().equals(detailDO.getBasicClass())) {
            int lastIndex = detailDO.getSpecification().indexOf(" * ");
            String sectionSteelSpec = detailDO.getSpecification().substring(0, lastIndex);
            String doNotSectionSteelSpec = detailDO.getSpecification().substring(lastIndex + 3);
            mapObject.put("sectionSteelSpec", StrUtil.isNotBlank(sectionSteelSpec) ? sectionSteelSpec : "");
            mapObject.put("doNotSectionSteelSpec", StrUtil.isNotBlank(doNotSectionSteelSpec) ? doNotSectionSteelSpec : "");
         }

         Measure measure = measureMap.get(materialInventoryDTO.getClassifyId());
         if (StrUtil.isBlank(measure.getAccountingUnit())) {
            Classification classification = classificationMap.get(measure.getClassificationId());
            measure = this.getMeasureV2(classification.getParentId(), measureMap, classificationMap);
         }

         this.setAmountAndMeteV2(mapObject, detailDO, measure, classificationMap, measureMap, unitMap, null);
         MaterialInventory materialInventory1 = materialInventoryMap.get(materialInventoryDTO.getId());
         MonthWeightedAveragePrice price = this.getWeightedAveragePrice(monthWeightedAveragePriceMap, materialInventory1);
         Preconditions.checkArgument(price != null, "操作失败,获取月末加权平均价失败!");
         if (WeightedPriceEnum.WHOLE.getType().equals(weightedPriceConf.getWeightedType())) {
            WholeWeightedAveragePrice wholeWeightedAveragePrice = this.wholeWeightedAveragePriceMapper.selectById(price.getWholeWapId());
            price.setMete(wholeWeightedAveragePrice.getMete());
            price.setAmount(wholeWeightedAveragePrice.getAmount());
            price.setAmountExcludingVat(wholeWeightedAveragePrice.getAmountExcludingVat());
         }

         BigDecimal p = materialInventoryDTO.getMete().divide(price.getMete(), 20, RoundingMode.HALF_UP);
         BigDecimal amount = price.getAmount().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
         BigDecimal amountExcludingVat = price.getAmountExcludingVat().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
         BigDecimal avgPrice = NumberUtil.div(amount, materialInventoryDTO.getMete(), 12);
         BigDecimal excludingVatAvgPrice = NumberUtil.div(amountExcludingVat, materialInventoryDTO.getMete(), 12);
         Map<Integer, BigDecimal> mete = this.unitConversion(detailDO.getMete(), measure.getAccountingUnit(), measure.getAccountingPrecision());
         mapObject.put("unitPrice", avgPrice.multiply(mete.get(2)).setScale(2, 4));
         mapObject.put("unitPriceExcludingVat", excludingVatAvgPrice.multiply(mete.get(2)).setScale(2, 4));
         mapObject.put("amount", amount);
         mapObject.put("amountExcludingVat", amountExcludingVat);
         mapObject.put("material", StrUtil.isNotBlank(material) ? material : "-");
         mapObject.put("lengths", StrUtil.isNotBlank(lengths) ? lengths : "-");
         mapObject.put("thickness", materialInventoryDTO.getThickness() != null ? materialInventoryDTO.getThickness().stripTrailingZeros().toPlainString() : "");
         mapObject.put("standardName", materialInventoryDTO.getStandardName() != null ? materialInventoryDTO.getStandardName() : "");
         mapObject.put("width", materialInventoryDTO.getWidth() != null ? materialInventoryDTO.getWidth().stripTrailingZeros().toPlainString() : "");
         mapObject.put("length", materialInventoryDTO.getLength() != null ? materialInventoryDTO.getLength().stripTrailingZeros().toPlainString() : "");
         if (BasicClassEnum.COLOR_ROLL.getType().equals(detailDO.getBasicClass())) {
            mapObject.put(
               "length",
               materialInventoryDTO.getLength() != null
                  ? materialInventoryDTO.getLength().divide(UnitsPrecisionEnum.EG_KG.getRate(), 4, RoundingMode.CEILING).stripTrailingZeros().toPlainString()
                  : "-"
            );
         }

         mapObject.put("mUnit", StrUtil.isNotBlank(measure.getMeasureUnit()) ? measure.getMeasureUnit() : "");
         mapObject.put("aUnit", StrUtil.isNotBlank(measure.getAccountingUnit()) ? measure.getAccountingUnit() : "");
         mapObject.put("brand", StrUtil.isNotBlank(materialInventoryDTO.getBrand()) ? materialInventoryDTO.getBrand() : "");
         mapObject.put("heatNo", StrUtil.isNotBlank(materialInventoryDTO.getHeatNoAndBatchNo()) ? materialInventoryDTO.getHeatNoAndBatchNo() : "");
         mapObject.put("color", StrUtil.isNotBlank(materialInventoryDTO.getColor()) ? materialInventoryDTO.getColor() : "");
         mapObject.put("project", materialInventoryDTO.getProject() != null ? materialInventoryDTO.getProject().getSerialNumber() : "");
         mapObject.put("workshop", materialInventoryDTO.getWorkshop() != null ? materialInventoryDTO.getWorkshop().getName() : "");
         mapObject.put("warehouse", materialInventoryDTO.getWarehouse() != null ? materialInventoryDTO.getWarehouse().getName() : "");
         mapObject.put(
            "materialIsWhole", materialInventoryDTO.getMaterialIsWhole() != null ? (materialInventoryDTO.getMaterialIsWhole() == 1 ? "整料" : "余料") : "-"
         );
         mapList.add(mapObject);
      }

      map.put("mapList", mapList);
      Integer type = null;
      if (BasicClassEnum.STEEL_PLATE.getType().equals(basicClass)) {
         type = boolPartyA ? ExcelEnum.STEEL_PLATE_INBOUND_PARTY_A_BEGIN_EXCEL.getType() : ExcelEnum.STEEL_PLATE_INBOUND_SELF_BUYING_BEGIN_EXCEL.getType();
      }

      if (BasicClassEnum.SECTION_STEEL.getType().equals(basicClass)) {
         type = boolPartyA ? ExcelEnum.SECTION_STEEL_INBOUND_PARTY_A_BEGIN_EXCEL.getType() : ExcelEnum.SECTION_STEEL_INBOUND_SELF_BUYING_BEGIN_EXCEL.getType();
      }

      if (BasicClassEnum.COLOR_ROLL.getType().equals(basicClass)) {
         type = boolPartyA ? ExcelEnum.COLOR_ROLL_INBOUND_PARTY_A_BEGIN_EXCEL.getType() : ExcelEnum.COLOR_ROLL_INBOUND_SELF_BUYING_BEGIN_EXCEL.getType();
      }

      if (BasicClassEnum.GENERAL_MATERIAL.getType().equals(basicClass)) {
         type = boolPartyA
            ? ExcelEnum.GENERAL_MATERIAL_INBOUND_PARTY_A_BEGIN_EXCEL.getType()
            : ExcelEnum.GENERAL_MATERIAL_INBOUND_SELF_BUYING_BEGIN_EXCEL.getType();
      }

      if (BasicClassEnum.GAS.getType().equals(basicClass)) {
         type = boolPartyA ? ExcelEnum.GAS_INBOUND_PARTY_A_BEGIN_EXCEL.getType() : ExcelEnum.GAS_INBOUND_SELF_BUYING_BEGIN_EXCEL.getType();
      }

      if (BasicClassEnum.OTHER.getType().equals(basicClass)) {
         type = boolPartyA ? ExcelEnum.OTHER_INBOUND_PARTY_A_BEGIN_EXCEL.getType() : ExcelEnum.OTHER_INBOUND_SELF_BUYING_BEGIN_EXCEL.getType();
      }

      if (BasicClassEnum.OTHER_STEEL_MATERIALS.getType().equals(basicClass)) {
         type = boolPartyA
            ? ExcelEnum.OTHER_STEEL_MATERIALS_INBOUND_PARTY_A_BEGIN_EXCEL.getType()
            : ExcelEnum.OTHER_STEEL_MATERIALS_INBOUND_SELF_BUYING_BEGIN_EXCEL.getType();
      }

      this.downloadInventoryExcel(response, null, map, type);
   }

   private Map<Long, String> getFullNamePathMap(Integer basicClass, List<Long> classifyIds) {
      if (CollectionUtil.isEmpty(classifyIds)) {
         return new HashMap<>();
      }

      Map<Long, String> allMap = this.classificationService
         .list(Wrappers.lambdaQuery(Classification.class).eq(Classification::getBasicClass, basicClass))
         .stream()
         .collect(Collectors.toMap(Classification::getId, Classification::getName));
      return this.classificationService.listByIds(classifyIds).stream().collect(Collectors.toMap(Classification::getId, e -> {
         String fullName = "";

         for (Long pathId : Arrays.stream(e.getPath().split(",")).map(Long::valueOf).collect(Collectors.toList())) {
            if (allMap.containsKey(pathId)) {
               if (StrUtil.isBlank(fullName)) {
                  fullName = allMap.get(pathId);
               } else {
                  fullName = fullName + "/" + allMap.get(pathId);
               }
            }
         }

         return fullName;
      }));
   }

   private void downloadInventoryToExcelBaseUrl(Integer basicClass, Boolean boolPartyA, String baseUrl, String specification, HttpServletResponse response) {
      HashMap<String, Object> map = new HashMap<>(16);
      List<MaterialInventoryDTO> list = this.materialInventoryMapper
         .getTotalInventory(basicClass, null, boolPartyA ? 2 : 1, null, specification)
         .stream()
         .peek(dto -> {
            MaterialInventory materialInventory = BeanUtil.copy(dto, MaterialInventory.class);
            if (dto.getProject() != null) {
               materialInventory.setProjectId(dto.getProject().getId());
            }

            if (dto.getWorkshop() != null) {
               materialInventory.setWorkshopId(dto.getWorkshop().getId());
            }
         })
         .sorted(Comparator.comparing(MaterialInventoryDTO::getId).reversed())
         .collect(Collectors.toList());
      Map<String, List<MonthWeightedAveragePrice>> monthWeightedAveragePriceMap = new HashMap<>();
      List<MonthWeightedAveragePrice> monthWeightedAveragePriceList = this.monthWAPMapper.selectList(new LambdaQueryWrapper<>());
      if (CollectionUtil.isNotEmpty(monthWeightedAveragePriceList)) {
         monthWeightedAveragePriceMap = monthWeightedAveragePriceList.stream()
            .collect(Collectors.groupingBy(ex -> ex.getClassifyId() + "-" + ex.getBasicClass()));
      }

      List<Long> collect = list.stream().map(MaterialInventoryDTO::getId).collect(Collectors.toList());
      Map<Long, MaterialInventory> materialInventoryMap = new HashMap<>();
      if (CollectionUtil.isNotEmpty(collect)) {
         materialInventoryMap = this.materialInventoryMapper
            .selectList((Wrapper<MaterialInventory>)new LambdaQueryWrapper<MaterialInventory>().in(MaterialInventory::getId, collect))
            .stream()
            .collect(Collectors.toMap(MaterialInventory::getId, Function.identity()));
      }

      Map<String, Unit> unitMap = this.unitMapper.selectList(new LambdaQueryWrapper<>()).stream().collect(Collectors.toMap(Unit::getName, Function.identity()));
      Map<Long, Measure> measureMap = this.measureMapper
         .selectList(new LambdaQueryWrapper<>())
         .stream()
         .collect(Collectors.toMap(Measure::getClassificationId, Function.identity()));
      Map<Long, Classification> classificationMap = this.classificationService
         .list()
         .stream()
         .collect(Collectors.toMap(Classification::getId, Function.identity()));
      WeightedPriceConf weightedPriceConf = JSON.parseObject(
         this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置")).getValue(), WeightedPriceConf.class
      );
      List<Long> classifyIds = list.stream().map(MaterialInventoryDTO::getClassifyId).distinct().collect(Collectors.toList());
      Map<Long, String> fullNamePathMap = this.getFullNamePathMap(basicClass, classifyIds);
      List<Map<String, Object>> mapList = new ArrayList<>();

      for (int i = 0; i < list.size(); i++) {
         Map<String, Object> mapObject = new HashMap<>();
         MaterialInventoryDTO materialInventoryDTO = list.get(i);
         DownLoadDetailDO detailDO = BeanUtil.copy(materialInventoryDTO, DownLoadDetailDO.class);
         detailDO.setAmountExcludingVat(materialInventoryDTO.getAmountExcludingVAT());
         mapObject.put("id", i + 1);
         Map<String, String> classMap = this.setClassifyName(detailDO.getBasicClass(), detailDO.getClassifyId(), detailDO.getClassifyName());
         mapObject.put("basicClass", classMap.get("分类"));
         mapObject.put("classifyName", fullNamePathMap.get(materialInventoryDTO.getClassifyId()));
         StringBuilder sb = new StringBuilder();
         StringBuilder lengths = new StringBuilder();
         StringBuilder material = new StringBuilder();
         this.setSpec(detailDO, sb);
         mapObject.put("spec", detailDO.getSpecification());
         Measure measure = measureMap.get(materialInventoryDTO.getClassifyId());
         if (BasicClassEnum.SECTION_STEEL.getType().equals(detailDO.getBasicClass())) {
            String sectionSteelSpec = StrUtil.subBefore(detailDO.getSpecification(), " * ", false);
            String doNotSectionSteelSpec = StrUtil.subAfter(detailDO.getSpecification(), " * ", false);
            mapObject.put("sectionSteelSpec", StrUtil.isNotBlank(sectionSteelSpec) ? sectionSteelSpec : "");
            mapObject.put("doNotSectionSteelSpec", StrUtil.isNotBlank(doNotSectionSteelSpec) ? doNotSectionSteelSpec : "");
         }

         if (StrUtil.isBlank(measure.getAccountingUnit())) {
            Classification classification = classificationMap.get(measure.getClassificationId());
            measure = this.getMeasureV2(classification.getParentId(), measureMap, classificationMap);
         }

         this.setAmountAndMeteV2(mapObject, detailDO, measure, classificationMap, measureMap, unitMap, null);
         MaterialInventory materialInventory1 = materialInventoryMap.get(materialInventoryDTO.getId());
         MonthWeightedAveragePrice price = this.getWeightedAveragePrice(monthWeightedAveragePriceMap, materialInventory1);
         Preconditions.checkArgument(price != null, "操作失败,获取月末加权平均价失败!");
         if (WeightedPriceEnum.WHOLE.getType().equals(weightedPriceConf.getWeightedType())) {
            WholeWeightedAveragePrice wholeWeightedAveragePrice = this.wholeWeightedAveragePriceMapper.selectById(price.getWholeWapId());
            price.setMete(wholeWeightedAveragePrice.getMete());
            price.setAmount(wholeWeightedAveragePrice.getAmount());
            price.setAmountExcludingVat(wholeWeightedAveragePrice.getAmountExcludingVat());
         }

         BigDecimal p = materialInventoryDTO.getMete().divide(price.getMete(), 20, RoundingMode.HALF_UP);
         BigDecimal amount = price.getAmount().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
         BigDecimal amountExcludingVat = price.getAmountExcludingVat().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
         BigDecimal avgPrice = NumberUtil.div(amount, materialInventoryDTO.getMete(), 12);
         BigDecimal excludingVatAvgPrice = NumberUtil.div(amountExcludingVat, materialInventoryDTO.getMete(), 12);
         Map<Integer, BigDecimal> mete = this.unitConversion(detailDO.getMete(), measure.getAccountingUnit(), measure.getAccountingPrecision());
         mapObject.put("unitPrice", avgPrice.multiply(mete.get(2)).setScale(2, 4));
         mapObject.put("unitPriceExcludingVat", excludingVatAvgPrice.multiply(mete.get(2)).setScale(2, 4));
         mapObject.put("amount", amount);
         mapObject.put("amountExcludingVat", amountExcludingVat);
         mapObject.put("material", StrUtil.isNotBlank(material) ? material : "");
         mapObject.put("lengths", StrUtil.isNotBlank(lengths) ? lengths : "");
         mapObject.put("thickness", materialInventoryDTO.getThickness() != null ? materialInventoryDTO.getThickness().stripTrailingZeros().toPlainString() : "");
         mapObject.put("standardName", materialInventoryDTO.getStandardName() != null ? materialInventoryDTO.getStandardName() : "");
         mapObject.put("width", materialInventoryDTO.getWidth() != null ? materialInventoryDTO.getWidth().stripTrailingZeros().toPlainString() : "");
         mapObject.put("length", materialInventoryDTO.getLength() != null ? materialInventoryDTO.getLength().stripTrailingZeros().toPlainString() : "");
         if (BasicClassEnum.COLOR_ROLL.getType().equals(detailDO.getBasicClass())) {
            mapObject.put(
               "length",
               materialInventoryDTO.getLength() != null
                  ? materialInventoryDTO.getLength().divide(UnitsPrecisionEnum.EG_KG.getRate(), 4, RoundingMode.CEILING).stripTrailingZeros().toPlainString()
                  : "-"
            );
         }

         mapObject.put("mUnit", StrUtil.isNotBlank(measure.getMeasureUnit()) ? measure.getMeasureUnit() : "");
         mapObject.put("aUnit", StrUtil.isNotBlank(measure.getAccountingUnit()) ? measure.getAccountingUnit() : "");
         mapObject.put("brand", StrUtil.isNotBlank(materialInventoryDTO.getBrand()) ? materialInventoryDTO.getBrand() : "");
         mapObject.put("heatNo", StrUtil.isNotBlank(materialInventoryDTO.getHeatNoAndBatchNo()) ? materialInventoryDTO.getHeatNoAndBatchNo() : "");
         mapObject.put("color", StrUtil.isNotBlank(materialInventoryDTO.getColor()) ? materialInventoryDTO.getColor() : "");
         mapObject.put("project", materialInventoryDTO.getProject() != null ? materialInventoryDTO.getProject().getSerialNumber() : "");
         mapObject.put("workshop", materialInventoryDTO.getWorkshop() != null ? materialInventoryDTO.getWorkshop().getName() : "");
         mapObject.put("warehouse", materialInventoryDTO.getWarehouse() != null ? materialInventoryDTO.getWarehouse().getName() : "");
         mapObject.put(
            "materialIsWhole", materialInventoryDTO.getMaterialIsWhole() != null ? (materialInventoryDTO.getMaterialIsWhole() == 1 ? "整料" : "余料") : "-"
         );
         mapList.add(mapObject);
      }

      map.put("mapList", mapList);
      Integer type = null;
      if (BasicClassEnum.STEEL_PLATE.getType().equals(basicClass)) {
         type = boolPartyA ? ExcelEnum.STEEL_PLATE_INBOUND_PARTY_A_BEGIN_EXCEL.getType() : ExcelEnum.STEEL_PLATE_INBOUND_SELF_BUYING_BEGIN_EXCEL.getType();
      }

      if (BasicClassEnum.SECTION_STEEL.getType().equals(basicClass)) {
         type = boolPartyA ? ExcelEnum.SECTION_STEEL_INBOUND_PARTY_A_BEGIN_EXCEL.getType() : ExcelEnum.SECTION_STEEL_INBOUND_SELF_BUYING_BEGIN_EXCEL.getType();
      }

      if (BasicClassEnum.COLOR_ROLL.getType().equals(basicClass)) {
         type = boolPartyA ? ExcelEnum.COLOR_ROLL_INBOUND_PARTY_A_BEGIN_EXCEL.getType() : ExcelEnum.COLOR_ROLL_INBOUND_SELF_BUYING_BEGIN_EXCEL.getType();
      }

      if (BasicClassEnum.GENERAL_MATERIAL.getType().equals(basicClass)) {
         type = boolPartyA
            ? ExcelEnum.GENERAL_MATERIAL_INBOUND_PARTY_A_BEGIN_EXCEL.getType()
            : ExcelEnum.GENERAL_MATERIAL_INBOUND_SELF_BUYING_BEGIN_EXCEL.getType();
      }

      if (BasicClassEnum.GAS.getType().equals(basicClass)) {
         type = boolPartyA ? ExcelEnum.GAS_INBOUND_PARTY_A_BEGIN_EXCEL.getType() : ExcelEnum.GAS_INBOUND_SELF_BUYING_BEGIN_EXCEL.getType();
      }

      if (BasicClassEnum.OTHER.getType().equals(basicClass)) {
         type = boolPartyA ? ExcelEnum.OTHER_INBOUND_PARTY_A_BEGIN_EXCEL.getType() : ExcelEnum.OTHER_INBOUND_SELF_BUYING_BEGIN_EXCEL.getType();
      }

      if (BasicClassEnum.OTHER_STEEL_MATERIALS.getType().equals(basicClass)) {
         type = boolPartyA
            ? ExcelEnum.OTHER_STEEL_MATERIALS_INBOUND_PARTY_A_BEGIN_EXCEL.getType()
            : ExcelEnum.OTHER_STEEL_MATERIALS_INBOUND_SELF_BUYING_BEGIN_EXCEL.getType();
      }

      String resourcePath = "";
      String tempFileName = "";
      String exportFileName = "";
      switch (ExcelEnum.selectType(type)) {
         case STEEL_PLATE_INBOUND_SELF_BUYING_BEGIN_EXCEL:
            resourcePath = ExcelEnum.STEEL_PLATE_INBOUND_SELF_BUYING_BEGIN_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.STEEL_PLATE_INBOUND_SELF_BUYING_BEGIN_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.STEEL_PLATE_INBOUND_SELF_BUYING_BEGIN_EXCEL.getExportFileName();
            break;
         case SECTION_STEEL_INBOUND_SELF_BUYING_BEGIN_EXCEL:
            resourcePath = ExcelEnum.SECTION_STEEL_INBOUND_SELF_BUYING_BEGIN_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.SECTION_STEEL_INBOUND_SELF_BUYING_BEGIN_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.SECTION_STEEL_INBOUND_SELF_BUYING_BEGIN_EXCEL.getExportFileName();
            break;
         case COLOR_ROLL_INBOUND_SELF_BUYING_BEGIN_EXCEL:
            resourcePath = ExcelEnum.COLOR_ROLL_INBOUND_SELF_BUYING_BEGIN_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.COLOR_ROLL_INBOUND_SELF_BUYING_BEGIN_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.COLOR_ROLL_INBOUND_SELF_BUYING_BEGIN_EXCEL.getExportFileName();
            break;
         case GENERAL_MATERIAL_INBOUND_SELF_BUYING_BEGIN_EXCEL:
            resourcePath = ExcelEnum.GENERAL_MATERIAL_INBOUND_SELF_BUYING_BEGIN_EXCEL.getResourcePath();
            tempFileName = ExcelEnum.GENERAL_MATERIAL_INBOUND_SELF_BUYING_BEGIN_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.GENERAL_MATERIAL_INBOUND_SELF_BUYING_BEGIN_EXCEL.getExportFileName();
            break;
         case OTHER_INBOUND_SELF_BUYING_BEGIN_EXCEL:
            resourcePath = ExcelEnum.OTHER_INBOUND_SELF_BUYING_BEGIN_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.OTHER_INBOUND_SELF_BUYING_BEGIN_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.OTHER_INBOUND_SELF_BUYING_BEGIN_EXCEL.getExportFileName();
            break;
         case GAS_INBOUND_SELF_BUYING_BEGIN_EXCEL:
            resourcePath = ExcelEnum.GAS_INBOUND_SELF_BUYING_BEGIN_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.GAS_INBOUND_SELF_BUYING_BEGIN_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.GAS_INBOUND_SELF_BUYING_BEGIN_EXCEL.getExportFileName();
            break;
         case OTHER_STEEL_MATERIALS_INBOUND_SELF_BUYING_BEGIN_EXCEL:
            resourcePath = ExcelEnum.OTHER_STEEL_MATERIALS_INBOUND_SELF_BUYING_BEGIN_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.OTHER_STEEL_MATERIALS_INBOUND_SELF_BUYING_BEGIN_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.OTHER_STEEL_MATERIALS_INBOUND_SELF_BUYING_BEGIN_EXCEL.getExportFileName();
            break;
         case STEEL_PLATE_INBOUND_PARTY_A_BEGIN_EXCEL:
            resourcePath = ExcelEnum.STEEL_PLATE_INBOUND_PARTY_A_BEGIN_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.STEEL_PLATE_INBOUND_PARTY_A_BEGIN_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.STEEL_PLATE_INBOUND_PARTY_A_BEGIN_EXCEL.getExportFileName();
            break;
         case SECTION_STEEL_INBOUND_PARTY_A_BEGIN_EXCEL:
            resourcePath = ExcelEnum.SECTION_STEEL_INBOUND_PARTY_A_BEGIN_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.SECTION_STEEL_INBOUND_PARTY_A_BEGIN_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.SECTION_STEEL_INBOUND_PARTY_A_BEGIN_EXCEL.getExportFileName();
            break;
         case COLOR_ROLL_INBOUND_PARTY_A_BEGIN_EXCEL:
            resourcePath = ExcelEnum.COLOR_ROLL_INBOUND_PARTY_A_BEGIN_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.COLOR_ROLL_INBOUND_PARTY_A_BEGIN_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.COLOR_ROLL_INBOUND_PARTY_A_BEGIN_EXCEL.getExportFileName();
            break;
         case GENERAL_MATERIAL_INBOUND_PARTY_A_BEGIN_EXCEL:
            resourcePath = ExcelEnum.GENERAL_MATERIAL_INBOUND_PARTY_A_BEGIN_EXCEL.getResourcePath();
            tempFileName = ExcelEnum.GENERAL_MATERIAL_INBOUND_PARTY_A_BEGIN_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.GENERAL_MATERIAL_INBOUND_PARTY_A_BEGIN_EXCEL.getExportFileName();
            break;
         case OTHER_INBOUND_PARTY_A_BEGIN_EXCEL:
            resourcePath = ExcelEnum.OTHER_INBOUND_PARTY_A_BEGIN_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.OTHER_INBOUND_PARTY_A_BEGIN_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.OTHER_INBOUND_PARTY_A_BEGIN_EXCEL.getExportFileName();
            break;
         case GAS_INBOUND_PARTY_A_BEGIN_EXCEL:
            resourcePath = ExcelEnum.GAS_INBOUND_PARTY_A_BEGIN_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.GAS_INBOUND_PARTY_A_BEGIN_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.GAS_INBOUND_PARTY_A_BEGIN_EXCEL.getExportFileName();
            break;
         case OTHER_STEEL_MATERIALS_INBOUND_PARTY_A_BEGIN_EXCEL:
            resourcePath = ExcelEnum.OTHER_STEEL_MATERIALS_INBOUND_PARTY_A_BEGIN_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.OTHER_STEEL_MATERIALS_INBOUND_PARTY_A_BEGIN_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.OTHER_STEEL_MATERIALS_INBOUND_PARTY_A_BEGIN_EXCEL.getExportFileName();
            break;
         default:
            resourcePath = "";
            tempFileName = "";
            exportFileName = "";
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
      File excel = new File(baseUrl + File.separator + exportFileName + ".xlsx");

      try {
         FileOutputStream outputStream = new FileOutputStream(excel);
         workbook.write(outputStream);
         outputStream.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   private void packageDownloadInventory(List<Integer> basicClass, Boolean boolPartyA, String specification, HttpServletResponse response) {
      String baseUrl = this.configProperties.getFilePath() + File.separator + "inventory" + File.separator + "baseFolder";
      FileUtil.mkdirs(baseUrl);

      for (int i = 0; i < basicClass.size(); i++) {
         this.downloadInventoryToExcelBaseUrl(basicClass.get(i), boolPartyA, baseUrl, specification, response);
      }

      String packageUrl = this.configProperties.getFilePath() + File.separator + "inventory" + File.separator + (boolPartyA ? "甲供仓库" : "自购仓库") + "库存物料包.zip";

      try {
         response.setHeader("Result", "code=" + ResultCodeEnum.SUCCESS.getCode() + ";message=" + ResultCodeEnum.SUCCESS.getCode());
         ZipUtil.zip(baseUrl, packageUrl);
         FileUtil.downloadFile(packageUrl);
      } catch (Exception e1) {
         e1.printStackTrace();
         response.setHeader("Result", "code=" + ResultCodeEnum.ERROR.getCode() + ";message=" + ResultCodeEnum.ERROR.getCode());
      } finally {
         try {
            FileUtils.cleanDirectory(new File(baseUrl));
         } catch (IOException e) {
            e.printStackTrace();
         }

         FileUtil.deleteFile(packageUrl);
      }
   }

   private MonthWeightedAveragePrice getWeightedAveragePrice(
      Map<String, List<MonthWeightedAveragePrice>> monthWeightedAveragePriceMap, MaterialInventory materialInventory1
   ) {
      List<MonthWeightedAveragePrice> averagePriceList = monthWeightedAveragePriceMap.get(
         materialInventory1.getClassifyId() + "-" + materialInventory1.getBasicClass()
      );
      if (CollectionUtil.isNotEmpty(averagePriceList)) {
         for (MonthWeightedAveragePrice price : averagePriceList) {
            if (materialInventory1.getBoolPartyA().equals(price.getBoolPartyA())
               && (materialInventory1.getProjectId() == null ? price.getProjectId() == null : materialInventory1.getProjectId().equals(price.getProjectId()))
               && (
                  materialInventory1.getWeightedAverageSpec() == null
                     ? price.getSpecification() == null
                     : materialInventory1.getWeightedAverageSpec().equals(price.getSpecification())
               )
               && (materialInventory1.getThickness() == null ? price.getThickness() == null : materialInventory1.getThickness().equals(price.getThickness()))
               && (
                  materialInventory1.getStandardId() == null ? price.getStandardId() == null : materialInventory1.getStandardId().equals(price.getStandardId())
               )
               && (
                  materialInventory1.getHeatNoAndBatchNo() == null
                     ? price.getHeatNoAndBatchNo() == null
                     : materialInventory1.getHeatNoAndBatchNo().equals(price.getHeatNoAndBatchNo())
               )
               && (materialInventory1.getColor() == null ? price.getColor() == null : materialInventory1.getColor().equals(price.getColor()))
               && (materialInventory1.getBrand() == null ? price.getBrand() == null : materialInventory1.getBrand().equals(price.getBrand()))
               && (materialInventory1.getUnitNet() == null ? price.getUnitNet() == null : materialInventory1.getUnitNet().compareTo(price.getUnitNet()) == 0)) {
               return price;
            }
         }
      }

      return null;
   }

   @Override
   public void PSIExcel(Integer basicClass, List<LocalDateTime> times, String material, BigDecimal thickness, Long classifyId, HttpServletResponse response) {
      StatisticsPageVO<PSIRecordDTO> psiList = this.reportService.getPSIList(basicClass, times, material, thickness, classifyId, null, null, null);
      List<PSIRecordDTO> list = psiList.getContent();
      HashMap<String, Object> map = new HashMap<>(16);
      String a = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(times.get(0));
      String b = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(times.get(1));
      map.put("data", a + "~" + b);
      BasicShowConfig basicShowConfig = this.basicConfigService.getBasicShowConfig();
      List<Map<String, Object>> mapList = new ArrayList<>();

      for (int i = 0; i < list.size(); i++) {
         Map<String, Object> mapObject = new HashMap<>();
         PSIRecordDTO psiRecordDTO = list.get(i);
         mapObject.put("id", i + 1);
         mapObject.put("classifyName", psiRecordDTO.getClassifyName());
         mapObject.put("accountingUnit", psiRecordDTO.getAccountingUnit());
         mapObject.put("materialSn", psiRecordDTO.getMaterialSn());
         StringBuilder spec = new StringBuilder();
         if (psiRecordDTO.getThickness() != null) {
            spec.append(psiRecordDTO.getThickness().stripTrailingZeros().toPlainString());
         }

         if (psiRecordDTO.getWidth() != null) {
            spec.append("*" + psiRecordDTO.getWidth().stripTrailingZeros().toPlainString());
         }

         if (psiRecordDTO.getLength() != null) {
            spec.append("*" + psiRecordDTO.getLength().stripTrailingZeros().toPlainString());
         }

         if (StrUtil.isNotEmpty(psiRecordDTO.getSpecification())) {
            spec.append("*" + psiRecordDTO.getSpecification());
         }

         mapObject.put("spec", this.queryUtil.getConfigShowSpec(JSON.toJSONString(psiRecordDTO), basicShowConfig));
         if (BasicClassEnum.GENERAL_MATERIAL.getType().equals(basicClass)) {
            mapObject.put("inboundMete", psiRecordDTO.getInboundMete() != null ? psiRecordDTO.getInboundMete() : "-");
            mapObject.put("outboundMete", psiRecordDTO.getOutboundMete() != null ? psiRecordDTO.getOutboundMete() : "-");
            mapObject.put("inventoryMete", psiRecordDTO.getInventoryMete() != null ? psiRecordDTO.getInventoryMete() : "-");
         } else {
            mapObject.put(
               "inboundMete", psiRecordDTO.getInboundMete() != null ? psiRecordDTO.getInboundMete().divide(BigDecimal.valueOf(1000L)).toPlainString() : "-"
            );
            mapObject.put(
               "outboundMete", psiRecordDTO.getOutboundMete() != null ? psiRecordDTO.getOutboundMete().divide(BigDecimal.valueOf(1000L)).toPlainString() : "-"
            );
            mapObject.put(
               "inventoryMete",
               psiRecordDTO.getInventoryMete() != null ? psiRecordDTO.getInventoryMete().divide(BigDecimal.valueOf(1000L)).toPlainString() : "-"
            );
         }

         mapList.add(mapObject);
      }

      map.put("mapList", mapList);
      this.download(response, null, map, 9);
   }

   @Override
   public void deficitDetailExcel(QueryReportDeficitDTOParam param, HttpServletResponse response) {
      String message = null;
      HashMap<String, Object> excelMap = new HashMap<>(16);
      if (CollectionUtil.isNotEmpty(param.getCreateTime())) {
         List<WmsDeficitDetail> list = this.wmsDeficitDetailService.list(
            new LambdaQueryWrapper<WmsDeficitDetail>()
               .eq(param.getBasicClass() != null, WmsDeficitDetail::getBasicClass, param.getBasicClass())
               .eq(param.getDeficitType() != null, WmsDeficitDetail::getDeficitType, param.getDeficitType())
               .eq(param.getProjectId() != null, WmsDeficitDetail::getProjectId, param.getProjectId())
               .eq(param.getWarehouseType() != null, WmsDeficitDetail::getWarehouseType, param.getWarehouseType())
               .eq(StrUtil.isNotEmpty(param.getSerialNumber()), WmsDeficitDetail::getDeficitSerialNumber, param.getSerialNumber())
               .like(StrUtil.isNotEmpty(param.getApplicantName()), WmsDeficitDetail::getApplicantName, param.getApplicantName())
               .eq(param.getReviewStatus() != null, WmsDeficitDetail::getReviewStatus, param.getReviewStatus())
               .between(BaseEntity::getCreateTime, param.getCreateTime().get(0), param.getCreateTime().get(1))
               .orderByDesc(BaseEntity::getCreateTime)
         );
         List<Map<String, Object>> mapList = new ArrayList<>();
         String a = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(param.getCreateTime().get(0));
         String b = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(param.getCreateTime().get(1));
         excelMap.put("inboundData", a + "~" + b);
         Map<Long, Classification> classificationMap = this.queryUtil.getClassificationMap(null);
         List<Long> collect = list.stream().map(WmsDeficitDetail::getProjectId).collect(Collectors.toList());
         Map<Long, ContractProject> projectMap = new HashMap<>();
         List<ContractProject> projects = this.projectService
            .list(new LambdaQueryWrapper<ContractProject>().in(CollectionUtil.isNotEmpty(collect), ContractProject::getId, collect));
         if (CollectionUtil.isNotEmpty(projects)) {
            projectMap = projects.stream().collect(Collectors.toMap(ContractProject::getId, Function.identity()));
         }

         BasicShowConfig basicShowConfig = this.basicConfigService.getBasicShowConfig();
         Map<String, Unit> unitMap = this.unitMapper
            .selectList(new LambdaQueryWrapper<>())
            .stream()
            .collect(Collectors.toMap(Unit::getName, Function.identity()));

         for (int i = 0; i < list.size(); i++) {
            Map<String, Object> mapObject = new HashMap<>();
            mapObject.put("id", i + 1);
            WmsDeficitDetail dto = list.get(i);
            mapObject.put("createTime", dto.getCreateTime() != null ? DateTimeFormatter.ofPattern("yyyy/MM/dd").format(dto.getCreateTime()) : "");
            mapObject.put("serialNumber", dto.getSerialNumber() != null ? dto.getSerialNumber() : "");
            Map<String, String> classMap = this.setClassifyNameV2(dto.getBasicClass(), dto.getClassifyId(), dto.getClassifyName(), classificationMap);
            mapObject.put("basicClass", classMap.get("分类"));
            mapObject.put("classifyName", classMap.get("名称"));
            mapObject.put("spec", this.queryUtil.getConfigShowSpec(JSON.toJSONString(dto), basicShowConfig));
            mapObject.put("brand", dto.getBrand() != null ? dto.getBrand() : "");
            mapObject.put("heatNoAndBatchNo", dto.getHeatNoAndBatchNo() != null ? dto.getHeatNoAndBatchNo() : "");
            if (dto.getProjectId() != null) {
               mapObject.put("project", projectMap.get(dto.getProjectId()) != null ? projectMap.get(dto.getProjectId()).getName() : "");
            }

            Map<Long, Measure> measureMap = this.queryUtil.getMeasureMap();
            Measure measure = measureMap.get(dto.getClassifyId());
            if (StrUtil.isBlank(measure.getAccountingUnit())) {
               Classification classification = classificationMap.get(measure.getClassificationId());
               measure = this.getMeasureV2(classification.getParentId(), measureMap, classificationMap);
            }

            if (dto.getQuantity() != null) {
               mapObject.put(
                  "quantity",
                  dto.getQuantity().compareTo(BigDecimal.ZERO) != 0
                     ? this.unitConversionV2(dto.getQuantity(), measure.getMeasureUnit(), measure.getMeasurePrecision(), unitMap).get(1).toPlainString()
                     : "-"
               );
            } else {
               mapObject.put("quantity", "-");
            }

            Map<Integer, BigDecimal> mete = this.unitConversionV2(dto.getMete(), measure.getAccountingUnit(), measure.getAccountingPrecision(), unitMap);
            mapObject.put("mete", mete.get(1).toPlainString());
            mapObject.put("measureUnit", StrUtil.isNotBlank(measure.getMeasureUnit()) ? measure.getMeasureUnit() : "-");
            mapObject.put("accountingUnit", measure.getAccountingUnit());
            if (dto.getDeficitQuantity() != null) {
               mapObject.put(
                  "deficitQuantity",
                  dto.getDeficitQuantity().compareTo(BigDecimal.ZERO) != 0
                     ? this.unitConversionV2(dto.getDeficitQuantity(), measure.getMeasureUnit(), measure.getMeasurePrecision(), unitMap).get(1).toPlainString()
                     : "-"
               );
            } else {
               mapObject.put("deficitQuantity", "-");
            }

            Map<Integer, BigDecimal> deficitMete = this.unitConversionV2(
               dto.getDeficitMete(), measure.getAccountingUnit(), measure.getAccountingPrecision(), unitMap
            );
            mapObject.put("deficitMete", deficitMete.get(1).toPlainString());
            if (dto.getAmount() != null) {
               mapObject.put("amount", dto.getAmount().setScale(this.amountAccuracy, 4));
            }

            if (dto.getAmountExcludingVat() != null) {
               mapObject.put("amountExcludingVat", dto.getAmountExcludingVat().setScale(this.amountAccuracy, 4));
            }

            if (InvoiceTypeEnum.SPECIAL.getType().equals(dto.getInvoiceType()) && dto.getAmount() != null && dto.getInputVat() != null) {
               mapObject.put("inputVat", dto.getAmount().subtract(dto.getAmountExcludingVat()).setScale(this.amountAccuracy, 4));
            }

            mapObject.put("deficitSerialNumber", dto.getDeficitSerialNumber() != null ? dto.getDeficitSerialNumber() : "");
            mapObject.put("remark", dto.getRemark() != null ? dto.getRemark() : "");
            mapList.add(mapObject);
            excelMap.put("mapList", mapList);
         }
      } else {
         message = "请选择下载时间";
      }

      this.download(response, message, excelMap, 23);
   }

   @Override
   public void inventoryDetailsRecordExcel(List<LocalDateTime> dates, String detailKey, HttpServletResponse response) {
      HashMap<String, Object> excelMap = new HashMap<>(16);
      List<InventoryDetailsRecordDetailDTO> list = this.reportService.getInventoryDetailsRecordDetail(dates, detailKey).getContent();
      Map<String, String> map = JSON.parseObject(detailKey, Map.class);
      String specs = map.get("specs");
      Classification classify = this.classificationMapper.selectById(Long.parseLong(map.get("classifyId")));
      ContractProject project = this.projectService.getById(Long.parseLong(map.get("projectId")));
      Measure measure = this.measureMapper.selectOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, classify.getId()));
      if (StrUtil.isBlank(measure.getAccountingUnit())) {
         measure = this.getMeasure(classify.getParentId());
      }

      if (project != null) {
         excelMap.put("projectName", project.getShortName());
      }

      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
      excelMap.put("dates", formatter.format(dates.get(0)) + "~" + formatter.format(dates.get(1)));
      excelMap.put("printDate", DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now()));
      Map<String, String> classifyMap = this.setClassifyName(classify.getBasicClass(), classify.getId(), classify.getName());
      excelMap.put("classifyName", classifyMap.get("分类") + "/" + classifyMap.get("名称"));
      excelMap.put("spec", specs);
      excelMap.put("unit", measure.getAccountingUnit());
      List<Map<String, Object>> mapList = new ArrayList<>();

      for (int i = 0; i < list.size(); i++) {
         Map<String, Object> mapObject = new HashMap<>();
         InventoryDetailsRecordDetailDTO dto = list.get(i);
         mapObject.put("id", i + 1);
         mapObject.put("createTime", dto.getCreateTime() != null ? DateTimeFormatter.ofPattern("yyyy/MM/dd").format(dto.getCreateTime()) : "");
         mapObject.put("serialNumber", dto.getReceipt() != null ? dto.getReceipt().getSerialNumber() : "");
         mapObject.put("summary", dto.getSummary());
         Map<Integer, BigDecimal> unitConversion = this.unitConversion(BigDecimal.ZERO, measure.getAccountingUnit(), measure.getAccountingPrecision());
         mapObject.put(
            "inMete",
            dto.getInboundMete() != null ? dto.getInboundMete().divide(unitConversion.get(2), measure.getAccountingPrecision(), RoundingMode.HALF_UP) : ""
         );
         mapObject.put(
            "inUnitPrice",
            dto.getInboundUnitPriceExcludingVat() != null
               ? dto.getInboundUnitPriceExcludingVat().multiply(unitConversion.get(2)).setScale(2, RoundingMode.HALF_UP)
               : ""
         );
         mapObject.put(
            "inAmount",
            dto.getInboundAmountExcludingVat() != null ? dto.getInboundAmountExcludingVat().setScale(this.amountAccuracy, RoundingMode.HALF_UP) : ""
         );
         mapObject.put(
            "outMete",
            dto.getOutboundMete() != null ? dto.getOutboundMete().divide(unitConversion.get(2), measure.getAccountingPrecision(), RoundingMode.HALF_UP) : ""
         );
         mapObject.put(
            "outUnitPrice",
            dto.getOutboundUnitPriceExcludingVat() != null
               ? dto.getOutboundUnitPriceExcludingVat().multiply(unitConversion.get(2)).setScale(2, RoundingMode.HALF_UP)
               : ""
         );
         mapObject.put(
            "outAmount",
            dto.getOutboundAmountExcludingVat() != null ? dto.getOutboundAmountExcludingVat().setScale(this.amountAccuracy, RoundingMode.HALF_UP) : ""
         );
         mapObject.put(
            "endMete", dto.getEndMete() != null ? dto.getEndMete().divide(unitConversion.get(2), measure.getAccountingPrecision(), RoundingMode.HALF_UP) : ""
         );
         mapObject.put(
            "endUnitPrice",
            dto.getEndUnitPriceExcludingVat() != null
               ? dto.getEndUnitPriceExcludingVat().multiply(unitConversion.get(2)).setScale(2, RoundingMode.HALF_UP)
               : ""
         );
         mapObject.put(
            "endAmount", dto.getEndAmountExcludingVat() != null ? dto.getEndAmountExcludingVat().setScale(this.amountAccuracy, RoundingMode.HALF_UP) : ""
         );
         mapList.add(mapObject);
      }

      excelMap.put("mapList", mapList);
      this.download(response, null, excelMap, 10);
   }

   @Override
   public void templateExcel(Integer receiptType, Integer basicClass, HttpServletResponse response) {
      Integer type = null;
      if (ReceiptTypeEnum.REQUISITIONS.getType().equals(receiptType)) {
         if (BasicClassEnum.STEEL_PLATE.getType().equals(basicClass)) {
            type = 11;
         }

         if (BasicClassEnum.SECTION_STEEL.getType().equals(basicClass)) {
            type = 12;
         }

         if (BasicClassEnum.COLOR_ROLL.getType().equals(basicClass)) {
            type = 13;
         }

         if (BasicClassEnum.GENERAL_MATERIAL.getType().equals(basicClass)) {
            type = 14;
         }
      }

      if (ReceiptTypeEnum.PURCHASE.getType().equals(receiptType)) {
         if (BasicClassEnum.STEEL_PLATE.getType().equals(basicClass)) {
            type = 15;
         }

         if (BasicClassEnum.SECTION_STEEL.getType().equals(basicClass)) {
            type = 16;
         }

         if (BasicClassEnum.COLOR_ROLL.getType().equals(basicClass)) {
            type = 17;
         }

         if (BasicClassEnum.GENERAL_MATERIAL.getType().equals(basicClass)) {
            type = 18;
         }

         if (BasicClassEnum.OTHER.getType().equals(basicClass)) {
            type = 21;
         }
      }

      if (type != null) {
         this.download(response, null, new HashMap<>(), type);
      } else {
         throw new IllegalArgumentException("参数异常");
      }
   }

   @Override
   public void templateExcelV2(Integer receiptType, Integer basicClass, HttpServletResponse response) {
      Integer type = null;
      if (ReceiptTypeEnum.REQUISITIONS.getType().equals(receiptType)) {
         if (BasicClassEnum.STEEL_PLATE.getType().equals(basicClass)) {
            type = ExcelEnum.STEEL_PLATE_APPLY_PURCHASE_EXCEL.getType();
         }

         if (BasicClassEnum.SECTION_STEEL.getType().equals(basicClass)) {
            type = ExcelEnum.SECTION_STEEL_APPLY_PURCHASE_EXCEL.getType();
         }

         if (BasicClassEnum.COLOR_ROLL.getType().equals(basicClass)) {
            type = ExcelEnum.COLOR_ROLL_APPLY_PURCHASE_EXCEL.getType();
         }

         if (BasicClassEnum.GENERAL_MATERIAL.getType().equals(basicClass)) {
            type = ExcelEnum.GENERAL_MATERIAL_APPLY_PURCHASE_EXCEL.getType();
         }

         if (BasicClassEnum.GAS.getType().equals(basicClass)) {
            type = ExcelEnum.GAS_APPLY_PURCHASE_EXCEL.getType();
         }

         if (BasicClassEnum.OTHER.getType().equals(basicClass)) {
            type = ExcelEnum.OTHER_APPLY_PURCHASE_EXCEL.getType();
         }

         if (BasicClassEnum.OTHER_STEEL_MATERIALS.getType().equals(basicClass)) {
            type = ExcelEnum.OTHER_STEEL_MATERIALS_APPLY_PURCHASE_EXCEL.getType();
         }
      }

      if (ReceiptTypeEnum.PURCHASE.getType().equals(receiptType)) {
         if (BasicClassEnum.STEEL_PLATE.getType().equals(basicClass)) {
            type = ExcelEnum.STEEL_PLATE_PURCHASE_ORDER_EXCEL.getType();
         }

         if (BasicClassEnum.SECTION_STEEL.getType().equals(basicClass)) {
            type = ExcelEnum.SECTION_STEEL_PURCHASE_ORDER_EXCEL.getType();
         }

         if (BasicClassEnum.COLOR_ROLL.getType().equals(basicClass)) {
            type = ExcelEnum.COLOR_ROLL_PURCHASE_ORDER_EXCEL.getType();
         }

         if (BasicClassEnum.GENERAL_MATERIAL.getType().equals(basicClass)) {
            type = ExcelEnum.GENERAL_MATERIAL_PURCHASE_ORDER_EXCEL.getType();
         }

         if (BasicClassEnum.OTHER.getType().equals(basicClass)) {
            type = ExcelEnum.OTHER_PURCHASE_ORDER_EXCEL.getType();
         }

         if (BasicClassEnum.GAS.getType().equals(basicClass)) {
            type = ExcelEnum.GAS_PURCHASE_ORDER_EXCEL.getType();
         }

         if (BasicClassEnum.OTHER_STEEL_MATERIALS.getType().equals(basicClass)) {
            type = ExcelEnum.OTHER_STEEL_MATERIALS_PURCHASE_ORDER_EXCEL.getType();
         }
      }

      if (ReceiptTypeEnum.LUMP_SUM_SYSTEM_PURCHASE.getType().equals(receiptType)) {
         type = ExcelEnum.LUMP_SUM_SYSTEM_PURCHASE_ORDER_EXCEL.getType();
      }

      if (type != null) {
         this.downloadV2(response, null, new HashMap<>(), type);
      } else {
         throw new IllegalArgumentException("参数异常");
      }
   }

   @Override
   public void adjustDetailListExcel(QueryReportAdjustDTOParam queryInboundDTOParam, HttpServletResponse response) {
      List<AdjustDetailDTO> adjustDetailDTOS = this.wmsAdjustDetailMapper.listInfo(queryInboundDTOParam);
      HashMap<String, Object> excelMap = new HashMap<>(16);
      List<Map<String, Object>> mapList = new ArrayList<>();
      String message = null;
      if (CollectionUtil.isNotEmpty(queryInboundDTOParam.getInboundTime())) {
         String a = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(queryInboundDTOParam.getInboundTime().get(0));
         String b = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(queryInboundDTOParam.getInboundTime().get(1));
         excelMap.put("inboundData", a + "~" + b);
         Map<Long, Classification> classificationMap = this.classificationService
            .list()
            .stream()
            .collect(Collectors.toMap(Classification::getId, Function.identity()));
         List<Long> collect = adjustDetailDTOS.stream().map(AdjustDetailDTO::getProjectId).collect(Collectors.toList());
         Map<Long, ContractProject> projectMap = new HashMap<>();
         List<ContractProject> projects = this.projectService
            .list(new LambdaQueryWrapper<ContractProject>().in(CollectionUtil.isNotEmpty(collect), ContractProject::getId, collect));
         if (CollectionUtil.isNotEmpty(projects)) {
            projectMap = projects.stream().collect(Collectors.toMap(ContractProject::getId, Function.identity()));
         }

         BasicShowConfig basicShowConfig = this.basicConfigService.getBasicShowConfig();

         for (int i = 0; i < adjustDetailDTOS.size(); i++) {
            Map<String, Object> mapObject = new HashMap<>();
            mapObject.put("id", i + 1);
            AdjustDetailDTO dto = adjustDetailDTOS.get(i);
            mapObject.put("createTime", dto.getCreateTime() != null ? DateTimeFormatter.ofPattern("yyyy/MM/dd").format(dto.getCreateTime()) : "");
            mapObject.put("adjustSerialNumber", dto.getAdjustSerialNumber() != null ? dto.getAdjustSerialNumber() : "");
            mapObject.put("materialSn", dto.getMaterialSn() != null ? dto.getMaterialSn() : "");
            Map<String, String> classMap = this.setClassifyNameV2(dto.getBasicClass(), dto.getClassifyId(), dto.getClassifyName(), classificationMap);
            mapObject.put("basicClass", classMap.get("分类"));
            mapObject.put("classifyName", classMap.get("名称"));
            mapObject.put("spec", this.queryUtil.getConfigShowSpec(JSON.toJSONString(dto), basicShowConfig));
            mapObject.put("brand", dto.getBrand() != null ? dto.getBrand() : "");
            mapObject.put("heatNoAndBatchNo", dto.getHeatNoAndBatchNo() != null ? dto.getHeatNoAndBatchNo() : "");
            if (dto.getProjectId() != null) {
               mapObject.put("project", projectMap.get(dto.getProjectId()) != null ? projectMap.get(dto.getProjectId()).getName() : "");
            }

            mapObject.put("serialNumber", dto.getSerialNumber() != null ? dto.getSerialNumber() : "");
            mapObject.put("differentAmount", dto.getDifferentAmount() != null ? dto.getDifferentAmount() : "");
            mapObject.put("differentAmountExcludingVat", dto.getDifferentAmountExcludingVat() != null ? dto.getDifferentAmountExcludingVat() : "");
            mapList.add(mapObject);
         }

         excelMap.put("mapList", mapList);
      } else {
         message = "请选择下载时间";
      }

      this.download(response, message, excelMap, 22);
   }

   @Override
   public void rejectDetailsDownload(QueryRejectDetailDTOParam param, HttpServletResponse response) {
      String message = null;
      HashMap<String, Object> map = new HashMap<>(16);
      if (CollectionUtil.isNotEmpty(param.getRejectTime())) {
         param.setClassifyIds(this.queryUtil.getLateClassificationList(param.getClassifyId()));
         String a = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(param.getRejectTime().get(0));
         String b = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(param.getRejectTime().get(1));
         map.put("rejectData", a + "~" + b);
         List<DownLoadDetailDO> list = this.rejectDetailMapper.getDownLoadDetail(param);
         Map<Long, Classification> classificationMap = this.classificationService
            .list()
            .stream()
            .collect(Collectors.toMap(Classification::getId, Function.identity()));
         Map<Long, Measure> measureMap = this.measureMapper
            .selectList(new LambdaQueryWrapper<>())
            .stream()
            .collect(Collectors.toMap(Measure::getClassificationId, Function.identity()));
         Map<String, Unit> unitMap = this.unitMapper
            .selectList(new LambdaQueryWrapper<>())
            .stream()
            .collect(Collectors.toMap(Unit::getName, Function.identity()));
         BasicShowConfig basicShowConfig = this.basicConfigService.getBasicShowConfig();
         List<ExcelDTO> excelDTOList = new ArrayList<>();
         List<Map<String, Object>> mapList = new ArrayList<>();

         for (int i = 0; i < list.size(); i++) {
            Map<String, Object> mapObject = new HashMap<>();
            DownLoadDetailDO detailDO = list.get(i);
            mapObject.put("id", i + 1);
            mapObject.put("data", DateTimeFormatter.ofPattern("yyyy/MM/dd").format(detailDO.getReviewTime()));
            Map<String, String> classMap = this.setClassifyNameV2(
               detailDO.getBasicClass(), detailDO.getClassifyId(), detailDO.getClassifyName(), classificationMap
            );
            mapObject.put("basicClass", classMap.get("分类"));
            mapObject.put("classifyName", classMap.get("名称"));
            StringBuilder sb = new StringBuilder();
            StringBuilder lengths = new StringBuilder();
            StringBuilder material = new StringBuilder();
            this.setSpecs(detailDO, sb, lengths, material);
            mapObject.put("spec", this.queryUtil.getConfigShowSpec(JSON.toJSONString(detailDO), basicShowConfig));
            Measure measure = measureMap.get(detailDO.getClassifyId());
            if (StrUtil.isBlank(measure.getAccountingUnit())) {
               Classification classification = classificationMap.get(measure.getClassificationId());
               measure = this.getMeasureV2(classification.getParentId(), measureMap, classificationMap);
            }

            this.setAmountAndMeteV2(mapObject, detailDO, measure, classificationMap, measureMap, unitMap, AmountShowMenuEnum.REJECTED_DETAILS.getType());
            mapObject.put("material", StrUtil.isNotBlank(material) ? material : "-");
            mapObject.put("lengths", StrUtil.isNotBlank(lengths) ? lengths : "-");
            mapObject.put("serialNumber", detailDO.getRejectSerialNumber());
            mapObject.put("materialSn", detailDO.getMaterialSn());
            mapObject.put("purchaseSN", detailDO.getPurchaseSN());
            mapObject.put("supplierName", detailDO.getSupplierName());
            mapObject.put("projectName", StrUtil.isNotBlank(detailDO.getProjectName()) ? detailDO.getProjectName() : "-");
            mapObject.put("warehouseName", StrUtil.isNotBlank(detailDO.getWarehouseName()) ? detailDO.getWarehouseName() : "-");
            mapObject.put("brand", StrUtil.isNotBlank(detailDO.getBrand()) ? detailDO.getBrand() : "-");
            mapObject.put("projectNumber", StrUtil.isNotBlank(detailDO.getProjectNumber()) ? detailDO.getProjectNumber() : "-");
            mapObject.put("remark", StrUtil.isNotBlank(detailDO.getRemark()) ? detailDO.getRemark() : "-");
            ExcelDTO excelDTO = convertToExcelDTO(mapObject);
            excelDTOList.add(excelDTO);
            mapList.add(mapObject);
         }

         map.put("mapList", mapList);
         String fileName = "rejectDetail";
         String s = "";
         Boolean boolShowAmount = this.getReceiptDetailsBoolShowAmount(AmountShowMenuEnum.REJECTED_DETAILS.getType());
         if (!boolShowAmount) {
            s = "-1";
         }

         if (StrUtil.isNotBlank(s)) {
            fileName = fileName + s;
         }

         this.export(excelDTOList, response, fileName, "退货明细", a + "~" + b);
      } else {
         message = "请选择下载的时间范围";
      }
   }

   private Map<Integer, BigDecimal> unitConversion(BigDecimal value, String unit, Integer scale) {
      Unit u = this.unitMapper.selectOne((Wrapper<Unit>)Wrappers.<Unit>lambdaQuery().eq(Unit::getName, unit));
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(u), "单位不存在");
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

   private void setSpec(DownLoadDetailDO detailDO, StringBuilder sb) {
      String thickness = detailDO.getThickness() != null ? detailDO.getThickness().stripTrailingZeros().toPlainString() : null;
      String width = detailDO.getWidth() != null ? detailDO.getWidth().stripTrailingZeros().toPlainString() : null;
      String length = detailDO.getLength() != null ? detailDO.getLength().stripTrailingZeros().toPlainString() : null;
      boolean b = StrUtil.isNotBlank(detailDO.getSpecification());
      if (BasicClassEnum.STEEL_PLATE.getType().equals(detailDO.getBasicClass())) {
         sb.append(thickness).append("*").append(width).append("*").append(length);
         if (b) {
            sb.append(" * ").append(detailDO.getSpecification());
         }
      } else if (BasicClassEnum.SECTION_STEEL.getType().equals(detailDO.getBasicClass())) {
         sb.append(length);
         if (b) {
            sb.append(" * ").append(detailDO.getSpecification());
         }
      } else if (BasicClassEnum.COLOR_ROLL.getType().equals(detailDO.getBasicClass())) {
         sb.append(thickness).append("*").append(width).append(" * ");
         if (b) {
            sb.append(detailDO.getSpecification());
         }

         if (StrUtil.isNotBlank(detailDO.getColor())) {
            sb.append(" * ").append(detailDO.getColor());
         }
      } else if (BasicClassEnum.checkNotSteel(detailDO.getBasicClass())) {
         if (StrUtil.isNotBlank(detailDO.getSpecification())) {
            sb.append(detailDO.getSpecification());
            if (StrUtil.isNotBlank(detailDO.getColor())) {
               sb.append(" * ").append(detailDO.getColor());
            }
         } else if (StrUtil.isNotBlank(detailDO.getColor())) {
            sb.append(detailDO.getColor());
         }
      }
   }

   public void setSpecs(DownLoadDetailDO detailDO, StringBuilder sb, StringBuilder lengths, StringBuilder material) {
      String thickness = detailDO.getThickness() != null ? detailDO.getThickness().stripTrailingZeros().toPlainString() : "";
      String width = detailDO.getWidth() != null ? detailDO.getWidth().stripTrailingZeros().toPlainString() : "";
      String length = detailDO.getLength() != null ? detailDO.getLength().stripTrailingZeros().toPlainString() : "";
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
      } else if (BasicClassEnum.COLOR_ROLL.getType().equals(detailDO.getBasicClass())) {
         sb.append(thickness).append("*").append(width);
         if (b) {
            if (detailDO.getSpecification().contains("*")) {
               int index = detailDO.getSpecification().lastIndexOf("*");
               if (index != -1) {
                  String result = detailDO.getSpecification().substring(0, index);
                  sb.append(result);
               }

               String[] parts = detailDO.getSpecification().split("\\*");
               String lastPart = parts[parts.length - 1];
               material.append(lastPart);
            } else {
               material.append(detailDO.getSpecification());
            }
         }

         if (StrUtil.isNotBlank(detailDO.getColor())) {
            sb.append(" * ").append(detailDO.getColor());
         }
      } else if (BasicClassEnum.checkNotSteel(detailDO.getBasicClass())) {
         if (StrUtil.isNotBlank(detailDO.getSpecification())) {
            sb.append(detailDO.getSpecification());
            if (StrUtil.isNotBlank(detailDO.getColor())) {
               sb.append(" * ").append(detailDO.getColor());
            }
         } else if (StrUtil.isNotBlank(detailDO.getColor())) {
            sb.append(detailDO.getColor());
         }
      }
   }

   private void download(HttpServletResponse response, String message, HashMap<String, Object> map, int type) {
      String resourcePath = "";
      String tempFileName = "";
      String exportFileName = "";
      String s = "";
      BasicConfig basicInbound = this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "报表下载配置"));
      Preconditions.checkArgument(basicInbound != null, "请配置下载金额是否显示");
      ReportDownload reportDownload = JSON.parseObject(basicInbound.getValue(), ReportDownload.class);
      if (reportDownload.getAmountShow().equals(0) && reportDownload.getAmountExcludingTAXShow().equals(0)) {
         s = "-1";
      } else if (reportDownload.getAmountShow().equals(0)) {
         s = "-2";
      } else if (reportDownload.getAmountExcludingTAXShow().equals(0)) {
         s = "-3";
      }

      Boolean boolShowAmount = null;
      if (type == 1) {
         boolShowAmount = this.getReceiptDetailsBoolShowAmount(AmountShowMenuEnum.INBOUND_DETAILS.getType());
      }

      if (Boolean.FALSE.equals(boolShowAmount)) {
         s = "-1";
      }

      switch (type) {
         case 1:
            resourcePath = "files/template/inboundDetail" + s + ".xlsx";
            tempFileName = "inboundDetail" + s;
            exportFileName = "入库记录.xlsx";
            break;
         case 2:
            resourcePath = "files/template/outboundDetail" + s + ".xlsx";
            tempFileName = "outboundDetail" + s;
            exportFileName = "出库记录.xlsx";
            break;
         case 3:
            resourcePath = "files/template/transferDetail.xlsx";
            tempFileName = "transferDetail";
            exportFileName = "调拨记录.xlsx";
            break;
         case 4:
            resourcePath = "files/template/returnDetail.xlsx";
            tempFileName = "returnDetail";
            exportFileName = "退库记录.xlsx";
            break;
         case 5:
            resourcePath = "files/template/RDFeeDetail.xlsx";
            tempFileName = "RDFeeDetail";
            exportFileName = "高新研发费.xlsx";
            break;
         case 6:
            resourcePath = "files/template/statistics.xlsx";
            tempFileName = "statistics";
            exportFileName = "收发存记录.xlsx";
            break;
         case 7:
            resourcePath = "files/template/statisticsDetail.xlsx";
            tempFileName = "statisticsDetail";
            exportFileName = map.get("heading") + "记录.xlsx";
            break;
         case 8:
            resourcePath = "files/template/materialInventory.xlsx";
            tempFileName = "materialInventory";
            exportFileName = "物料库存记录.xlsx";
            break;
         case 9:
            resourcePath = "files/template/PSIDetail.xlsx";
            tempFileName = "PSIDetail";
            exportFileName = "进销存详情.xlsx";
            break;
         case 10:
            resourcePath = "files/template/inventoryDetails.xlsx";
            tempFileName = "inventoryDetails";
            exportFileName = "存货明细账.xlsx";
            break;
         case 11:
            resourcePath = "files/template/钢板申购单.xlsx";
            tempFileName = "钢板申购单";
            exportFileName = "钢板申购单.xlsx";
            break;
         case 12:
            resourcePath = "files/template/型材申购单.xlsx";
            tempFileName = "型材申购单";
            exportFileName = "型材申购单.xlsx";
            break;
         case 13:
            resourcePath = "files/template/钢卷申购单.xlsx";
            tempFileName = "钢卷申购单";
            exportFileName = "钢卷申购单.xlsx";
            break;
         case 14:
            resourcePath = "files/template/辅材申购单.xlsx";
            tempFileName = "辅材申购单";
            exportFileName = "辅材申购单.xlsx";
            break;
         case 15:
            resourcePath = "files/template/钢板采购单.xlsx";
            tempFileName = "钢板采购单";
            exportFileName = "钢板采购单.xlsx";
            break;
         case 16:
            resourcePath = "files/template/型材采购单.xlsx";
            tempFileName = "型材采购单";
            exportFileName = "型材采购单.xlsx";
            break;
         case 17:
            resourcePath = "files/template/钢卷采购单.xlsx";
            tempFileName = "钢卷采购单";
            exportFileName = "钢卷采购单.xlsx";
            break;
         case 18:
            resourcePath = "files/template/辅材采购单.xlsx";
            tempFileName = "辅材采购单";
            exportFileName = "辅材采购单.xlsx";
            break;
         case 19:
            resourcePath = "files/template/rejectDetail.xlsx";
            tempFileName = "rejectDetail";
            exportFileName = "退货详情.xlsx";
            break;
         case 20:
         default:
            resourcePath = "";
            tempFileName = "";
            exportFileName = "";
            break;
         case 21:
            resourcePath = "files/template/其它采购单.xlsx";
            tempFileName = "其它采购单";
            exportFileName = "其它采购单.xlsx";
            break;
         case 22:
            resourcePath = "files/template/adjustDetail.xlsx";
            tempFileName = "adjustDetail";
            exportFileName = "入库价格调整记录.xlsx";
            break;
         case 23:
            resourcePath = "files/template/deficitDetail.xlsx";
            tempFileName = "deficitDetail";
            exportFileName = "盘亏记录.xlsx";
            break;
         case 24:
            resourcePath = "files/template/inboundDetailManufactured.xlsx";
            tempFileName = "inboundDetailManufactured";
            exportFileName = "制成品入库记录.xlsx";
            break;
         case 25:
            resourcePath = "files/template/outboundDetailManufactured.xlsx";
            tempFileName = "outboundDetailManufactured";
            exportFileName = "制成品出库记录.xlsx";
            break;
         case 26:
            resourcePath = "files/template/returnDetailManufactured.xlsx";
            tempFileName = "returnDetailManufactured";
            exportFileName = "制成品退库记录.xlsx";
            break;
         case 27:
            resourcePath = "files/template/inventoryStatictics.xlsx";
            tempFileName = "inventoryStatictics";
            exportFileName = "库存使用分析.xlsx";
            break;
         case 28:
            resourcePath = "files/template/inventoryRecord.xlsx";
            tempFileName = "inventoryRecord";
            exportFileName = "库存使用记录.xlsx";
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
      TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath(), true);
      Workbook workbook = ExcelExportUtil.exportExcel(params, map);
      PoiUtils.wmsDownLoadExcel(exportFileName, response, workbook, message);
   }

   private void downloadInventoryExcel(HttpServletResponse response, String message, HashMap<String, Object> map, int type) {
      String resourcePath = "";
      String tempFileName = "";
      String exportFileName = "";
      switch (ExcelEnum.selectType(type)) {
         case STEEL_PLATE_INBOUND_SELF_BUYING_BEGIN_EXCEL:
            resourcePath = ExcelEnum.STEEL_PLATE_INBOUND_SELF_BUYING_BEGIN_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.STEEL_PLATE_INBOUND_SELF_BUYING_BEGIN_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.STEEL_PLATE_INBOUND_SELF_BUYING_BEGIN_EXCEL.getExportFileName();
            break;
         case SECTION_STEEL_INBOUND_SELF_BUYING_BEGIN_EXCEL:
            resourcePath = ExcelEnum.SECTION_STEEL_INBOUND_SELF_BUYING_BEGIN_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.SECTION_STEEL_INBOUND_SELF_BUYING_BEGIN_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.SECTION_STEEL_INBOUND_SELF_BUYING_BEGIN_EXCEL.getExportFileName();
            break;
         case COLOR_ROLL_INBOUND_SELF_BUYING_BEGIN_EXCEL:
            resourcePath = ExcelEnum.COLOR_ROLL_INBOUND_SELF_BUYING_BEGIN_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.COLOR_ROLL_INBOUND_SELF_BUYING_BEGIN_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.COLOR_ROLL_INBOUND_SELF_BUYING_BEGIN_EXCEL.getExportFileName();
            break;
         case GENERAL_MATERIAL_INBOUND_SELF_BUYING_BEGIN_EXCEL:
            resourcePath = ExcelEnum.GENERAL_MATERIAL_INBOUND_SELF_BUYING_BEGIN_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.GENERAL_MATERIAL_INBOUND_SELF_BUYING_BEGIN_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.GENERAL_MATERIAL_INBOUND_SELF_BUYING_BEGIN_EXCEL.getExportFileName();
            break;
         case OTHER_INBOUND_SELF_BUYING_BEGIN_EXCEL:
            resourcePath = ExcelEnum.OTHER_INBOUND_SELF_BUYING_BEGIN_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.OTHER_INBOUND_SELF_BUYING_BEGIN_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.OTHER_INBOUND_SELF_BUYING_BEGIN_EXCEL.getExportFileName();
            break;
         case GAS_INBOUND_SELF_BUYING_BEGIN_EXCEL:
            resourcePath = ExcelEnum.GAS_INBOUND_SELF_BUYING_BEGIN_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.GAS_INBOUND_SELF_BUYING_BEGIN_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.GAS_INBOUND_SELF_BUYING_BEGIN_EXCEL.getExportFileName();
            break;
         case OTHER_STEEL_MATERIALS_INBOUND_SELF_BUYING_BEGIN_EXCEL:
            resourcePath = ExcelEnum.OTHER_STEEL_MATERIALS_INBOUND_SELF_BUYING_BEGIN_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.OTHER_STEEL_MATERIALS_INBOUND_SELF_BUYING_BEGIN_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.OTHER_STEEL_MATERIALS_INBOUND_SELF_BUYING_BEGIN_EXCEL.getExportFileName();
            break;
         case STEEL_PLATE_INBOUND_PARTY_A_BEGIN_EXCEL:
            resourcePath = ExcelEnum.STEEL_PLATE_INBOUND_PARTY_A_BEGIN_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.STEEL_PLATE_INBOUND_PARTY_A_BEGIN_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.STEEL_PLATE_INBOUND_PARTY_A_BEGIN_EXCEL.getExportFileName();
            break;
         case SECTION_STEEL_INBOUND_PARTY_A_BEGIN_EXCEL:
            resourcePath = ExcelEnum.SECTION_STEEL_INBOUND_PARTY_A_BEGIN_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.SECTION_STEEL_INBOUND_PARTY_A_BEGIN_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.SECTION_STEEL_INBOUND_PARTY_A_BEGIN_EXCEL.getExportFileName();
            break;
         case COLOR_ROLL_INBOUND_PARTY_A_BEGIN_EXCEL:
            resourcePath = ExcelEnum.COLOR_ROLL_INBOUND_PARTY_A_BEGIN_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.COLOR_ROLL_INBOUND_PARTY_A_BEGIN_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.COLOR_ROLL_INBOUND_PARTY_A_BEGIN_EXCEL.getExportFileName();
            break;
         case GENERAL_MATERIAL_INBOUND_PARTY_A_BEGIN_EXCEL:
            resourcePath = ExcelEnum.GENERAL_MATERIAL_INBOUND_PARTY_A_BEGIN_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.GENERAL_MATERIAL_INBOUND_PARTY_A_BEGIN_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.GENERAL_MATERIAL_INBOUND_PARTY_A_BEGIN_EXCEL.getExportFileName();
            break;
         case OTHER_INBOUND_PARTY_A_BEGIN_EXCEL:
            resourcePath = ExcelEnum.OTHER_INBOUND_PARTY_A_BEGIN_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.OTHER_INBOUND_PARTY_A_BEGIN_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.OTHER_INBOUND_PARTY_A_BEGIN_EXCEL.getExportFileName();
            break;
         case GAS_INBOUND_PARTY_A_BEGIN_EXCEL:
            resourcePath = ExcelEnum.GAS_INBOUND_PARTY_A_BEGIN_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.GAS_INBOUND_PARTY_A_BEGIN_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.GAS_INBOUND_PARTY_A_BEGIN_EXCEL.getExportFileName();
            break;
         case OTHER_STEEL_MATERIALS_INBOUND_PARTY_A_BEGIN_EXCEL:
            resourcePath = ExcelEnum.OTHER_STEEL_MATERIALS_INBOUND_PARTY_A_BEGIN_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.OTHER_STEEL_MATERIALS_INBOUND_PARTY_A_BEGIN_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.OTHER_STEEL_MATERIALS_INBOUND_PARTY_A_BEGIN_EXCEL.getExportFileName();
            break;
         default:
            resourcePath = "";
            tempFileName = "";
            exportFileName = "";
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
      TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath(), true);
      Workbook workbook = ExcelExportUtil.exportExcel(params, map);
      PoiUtils.wmsBeginDownLoadExcel(exportFileName + ".xlsx", response, workbook, message);
   }

   private void downloadDeficitInventoryExcel(HttpServletResponse response, String message, HashMap<String, Object> map, int type, Integer deficitType) {
      String resourcePath = "";
      String tempFileName = "";
      String exportFileName = "";
      switch (ExcelEnum.selectType(type)) {
         case STEEL_PLATE_CAN_LOSS_EXCEL:
            if (deficitType == 2) {
               resourcePath = ExcelEnum.STEEL_PLATE_CAN_LOSS_EXCEL.getResourcePath() + "-2.xlsx";
               tempFileName = ExcelEnum.STEEL_PLATE_CAN_LOSS_EXCEL.getTempFileName() + "-2";
               exportFileName = ExcelEnum.STEEL_PLATE_CAN_LOSS_EXCEL.getExportFileName() + "-2";
            } else {
               resourcePath = ExcelEnum.STEEL_PLATE_CAN_LOSS_EXCEL.getResourcePath() + ".xlsx";
               tempFileName = ExcelEnum.STEEL_PLATE_CAN_LOSS_EXCEL.getTempFileName();
               exportFileName = ExcelEnum.STEEL_PLATE_CAN_LOSS_EXCEL.getExportFileName();
            }
            break;
         case SECTION_STEEL_CAN_LOSS_EXCEL:
            if (deficitType == 2) {
               resourcePath = ExcelEnum.SECTION_STEEL_CAN_LOSS_EXCEL.getResourcePath() + "-2.xlsx";
               tempFileName = ExcelEnum.SECTION_STEEL_CAN_LOSS_EXCEL.getTempFileName() + "-2";
               exportFileName = ExcelEnum.SECTION_STEEL_CAN_LOSS_EXCEL.getExportFileName() + "-2";
            } else {
               resourcePath = ExcelEnum.SECTION_STEEL_CAN_LOSS_EXCEL.getResourcePath() + ".xlsx";
               tempFileName = ExcelEnum.SECTION_STEEL_CAN_LOSS_EXCEL.getTempFileName();
               exportFileName = ExcelEnum.SECTION_STEEL_CAN_LOSS_EXCEL.getExportFileName();
            }
            break;
         case COLOR_ROLL_CAN_LOSS_EXCEL:
            if (deficitType == 2) {
               resourcePath = ExcelEnum.COLOR_ROLL_CAN_LOSS_EXCEL.getResourcePath() + "-2.xlsx";
               tempFileName = ExcelEnum.COLOR_ROLL_CAN_LOSS_EXCEL.getTempFileName() + "-2";
               exportFileName = ExcelEnum.COLOR_ROLL_CAN_LOSS_EXCEL.getExportFileName() + "-2";
            } else {
               resourcePath = ExcelEnum.COLOR_ROLL_CAN_LOSS_EXCEL.getResourcePath() + ".xlsx";
               tempFileName = ExcelEnum.COLOR_ROLL_CAN_LOSS_EXCEL.getTempFileName();
               exportFileName = ExcelEnum.COLOR_ROLL_CAN_LOSS_EXCEL.getExportFileName();
            }
            break;
         case GENERAL_MATERIAL_CAN_LOSS_EXCEL:
            if (deficitType == 2) {
               resourcePath = ExcelEnum.GENERAL_MATERIAL_CAN_LOSS_EXCEL.getResourcePath() + "-2.xlsx";
               tempFileName = ExcelEnum.GENERAL_MATERIAL_CAN_LOSS_EXCEL.getTempFileName() + "-2";
               exportFileName = ExcelEnum.GENERAL_MATERIAL_CAN_LOSS_EXCEL.getExportFileName() + "-2";
            } else {
               resourcePath = ExcelEnum.GENERAL_MATERIAL_CAN_LOSS_EXCEL.getResourcePath() + ".xlsx";
               tempFileName = ExcelEnum.GENERAL_MATERIAL_CAN_LOSS_EXCEL.getTempFileName();
               exportFileName = ExcelEnum.GENERAL_MATERIAL_CAN_LOSS_EXCEL.getExportFileName();
            }
            break;
         case OTHER_CAN_LOSS_EXCEL:
            if (deficitType == 2) {
               resourcePath = ExcelEnum.OTHER_CAN_LOSS_EXCEL.getResourcePath() + "-2.xlsx";
               tempFileName = ExcelEnum.OTHER_CAN_LOSS_EXCEL.getTempFileName() + "-2";
               exportFileName = ExcelEnum.OTHER_CAN_LOSS_EXCEL.getExportFileName() + "-2";
            } else {
               resourcePath = ExcelEnum.OTHER_CAN_LOSS_EXCEL.getResourcePath() + ".xlsx";
               tempFileName = ExcelEnum.OTHER_CAN_LOSS_EXCEL.getTempFileName();
               exportFileName = ExcelEnum.OTHER_CAN_LOSS_EXCEL.getExportFileName();
            }
            break;
         case GAS_CAN_LOSS_EXCEL:
            if (deficitType == 2) {
               resourcePath = ExcelEnum.GAS_CAN_LOSS_EXCEL.getResourcePath() + "-2.xlsx";
               tempFileName = ExcelEnum.GAS_CAN_LOSS_EXCEL.getTempFileName() + "-2";
               exportFileName = ExcelEnum.GAS_CAN_LOSS_EXCEL.getExportFileName() + "-2";
            } else {
               resourcePath = ExcelEnum.GAS_CAN_LOSS_EXCEL.getResourcePath() + ".xlsx";
               tempFileName = ExcelEnum.GAS_CAN_LOSS_EXCEL.getTempFileName();
               exportFileName = ExcelEnum.GAS_CAN_LOSS_EXCEL.getExportFileName();
            }
            break;
         case OTHER_STEEL_CAN_LOSS_EXCEL:
            if (deficitType == 2) {
               resourcePath = ExcelEnum.OTHER_STEEL_CAN_LOSS_EXCEL.getResourcePath() + "-2.xlsx";
               tempFileName = ExcelEnum.OTHER_STEEL_CAN_LOSS_EXCEL.getTempFileName() + "-2";
               exportFileName = ExcelEnum.OTHER_STEEL_CAN_LOSS_EXCEL.getExportFileName() + "-2";
            } else {
               resourcePath = ExcelEnum.OTHER_STEEL_CAN_LOSS_EXCEL.getResourcePath() + ".xlsx";
               tempFileName = ExcelEnum.OTHER_STEEL_CAN_LOSS_EXCEL.getTempFileName();
               exportFileName = ExcelEnum.OTHER_STEEL_CAN_LOSS_EXCEL.getExportFileName();
            }
            break;
         default:
            resourcePath = "";
            tempFileName = "";
            exportFileName = "";
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
      TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath(), true);
      Workbook workbook = ExcelExportUtil.exportExcel(params, map);
      PoiUtils.wmsBeginDownLoadExcel(exportFileName + ".xlsx", response, workbook, message);
   }

   private void downloadV2(HttpServletResponse response, String message, HashMap<String, Object> map, int type) {
      String resourcePath = "";
      String tempFileName = "";
      String exportFileName = "";
      String s = "";
      BasicConfig basicInbound = this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "报表下载配置"));
      Preconditions.checkArgument(basicInbound != null, "请配置下载金额是否显示");
      ReportDownload reportDownload = JSON.parseObject(basicInbound.getValue(), ReportDownload.class);
      if (reportDownload.getAmountShow().equals(0) && reportDownload.getAmountExcludingTAXShow().equals(0)) {
         s = "-1";
      } else if (reportDownload.getAmountShow().equals(0)) {
         s = "-2";
      } else if (reportDownload.getAmountExcludingTAXShow().equals(0)) {
         s = "-3";
      }

      switch (ExcelEnum.selectType(type)) {
         case INBOUND_RECORD_EXCEL:
            resourcePath = ExcelEnum.INBOUND_RECORD_EXCEL.getResourcePath() + s + ".xlsx";
            tempFileName = ExcelEnum.INBOUND_RECORD_EXCEL.getTempFileName() + s;
            exportFileName = ExcelEnum.INBOUND_RECORD_EXCEL.getExportFileName();
            break;
         case OUTBOUND_RECORD_EXCEL:
            resourcePath = ExcelEnum.OUTBOUND_RECORD_EXCEL.getResourcePath() + s + ".xlsx";
            tempFileName = ExcelEnum.OUTBOUND_RECORD_EXCEL.getTempFileName() + s;
            exportFileName = ExcelEnum.OUTBOUND_RECORD_EXCEL.getExportFileName();
            break;
         case TRANSFER_RECORD_EXCEL:
            resourcePath = ExcelEnum.TRANSFER_RECORD_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.TRANSFER_RECORD_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.TRANSFER_RECORD_EXCEL.getExportFileName() + ".xlsx";
            break;
         case RETURN_WAREHOUSE_RECORD_EXCEL:
            resourcePath = ExcelEnum.RETURN_WAREHOUSE_RECORD_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.RETURN_WAREHOUSE_RECORD_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.RETURN_WAREHOUSE_RECORD_EXCEL.getExportFileName() + ".xlsx";
            break;
         case RDRATE_EXCEL:
            resourcePath = ExcelEnum.RDRATE_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.RDRATE_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.RDRATE_EXCEL.getExportFileName() + ".xlsx";
            break;
         case RECEIVE_SEND_STORAGE_RECORD_EXCEL:
            resourcePath = ExcelEnum.RECEIVE_SEND_STORAGE_RECORD_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.RECEIVE_SEND_STORAGE_RECORD_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.RECEIVE_SEND_STORAGE_RECORD_EXCEL.getExportFileName() + ".xlsx";
            break;
         case RECORD_EXCEL:
            resourcePath = ExcelEnum.RECORD_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.RECORD_EXCEL.getTempFileName();
            exportFileName = map.get("heading") + ExcelEnum.RECORD_EXCEL.getExportFileName() + ".xlsx";
            break;
         case MATERIAL_INVENTORY_EXCEL:
            resourcePath = ExcelEnum.MATERIAL_INVENTORY_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.MATERIAL_INVENTORY_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.MATERIAL_INVENTORY_EXCEL.getExportFileName() + ".xlsx";
            break;
         case PURCHASE_SELL_STOCK_DETAIL_EXCEL:
            resourcePath = ExcelEnum.PURCHASE_SELL_STOCK_DETAIL_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.PURCHASE_SELL_STOCK_DETAIL_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.PURCHASE_SELL_STOCK_DETAIL_EXCEL.getExportFileName() + ".xlsx";
            break;
         case INVENTORY_DETAIL_BILL_EXCEL:
            resourcePath = ExcelEnum.INVENTORY_DETAIL_BILL_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.INVENTORY_DETAIL_BILL_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.INVENTORY_DETAIL_BILL_EXCEL.getExportFileName() + ".xlsx";
            break;
         case STEEL_PLATE_APPLY_PURCHASE_EXCEL:
            resourcePath = ExcelEnum.STEEL_PLATE_APPLY_PURCHASE_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.STEEL_PLATE_APPLY_PURCHASE_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.STEEL_PLATE_APPLY_PURCHASE_EXCEL.getExportFileName() + ".xlsx";
            break;
         case SECTION_STEEL_APPLY_PURCHASE_EXCEL:
            resourcePath = ExcelEnum.SECTION_STEEL_APPLY_PURCHASE_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.SECTION_STEEL_APPLY_PURCHASE_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.SECTION_STEEL_APPLY_PURCHASE_EXCEL.getExportFileName() + ".xlsx";
            break;
         case COLOR_ROLL_APPLY_PURCHASE_EXCEL:
            resourcePath = ExcelEnum.COLOR_ROLL_APPLY_PURCHASE_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.COLOR_ROLL_APPLY_PURCHASE_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.COLOR_ROLL_APPLY_PURCHASE_EXCEL.getExportFileName() + ".xlsx";
            break;
         case GENERAL_MATERIAL_APPLY_PURCHASE_EXCEL:
            resourcePath = ExcelEnum.GENERAL_MATERIAL_APPLY_PURCHASE_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.GENERAL_MATERIAL_APPLY_PURCHASE_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.GENERAL_MATERIAL_APPLY_PURCHASE_EXCEL.getExportFileName() + ".xlsx";
            break;
         case STEEL_PLATE_PURCHASE_ORDER_EXCEL:
            resourcePath = ExcelEnum.STEEL_PLATE_PURCHASE_ORDER_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.STEEL_PLATE_PURCHASE_ORDER_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.STEEL_PLATE_PURCHASE_ORDER_EXCEL.getExportFileName() + ".xlsx";
            break;
         case SECTION_STEEL_PURCHASE_ORDER_EXCEL:
            resourcePath = ExcelEnum.SECTION_STEEL_PURCHASE_ORDER_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.SECTION_STEEL_PURCHASE_ORDER_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.SECTION_STEEL_PURCHASE_ORDER_EXCEL.getExportFileName() + ".xlsx";
            break;
         case COLOR_ROLL_PURCHASE_ORDER_EXCEL:
            resourcePath = ExcelEnum.COLOR_ROLL_PURCHASE_ORDER_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.COLOR_ROLL_PURCHASE_ORDER_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.COLOR_ROLL_PURCHASE_ORDER_EXCEL.getExportFileName() + ".xlsx";
            break;
         case GENERAL_MATERIAL_PURCHASE_ORDER_EXCEL:
            resourcePath = ExcelEnum.GENERAL_MATERIAL_PURCHASE_ORDER_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.GENERAL_MATERIAL_PURCHASE_ORDER_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.GENERAL_MATERIAL_PURCHASE_ORDER_EXCEL.getExportFileName() + ".xlsx";
            break;
         case RETURN_WAREHOUSE_DETAIL_EXCEL:
            resourcePath = ExcelEnum.RETURN_WAREHOUSE_DETAIL_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.RETURN_WAREHOUSE_DETAIL_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.RETURN_WAREHOUSE_DETAIL_EXCEL.getExportFileName() + ".xlsx";
            break;
         case OTHER_PURCHASE_ORDER_EXCEL:
            resourcePath = ExcelEnum.OTHER_PURCHASE_ORDER_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.OTHER_PURCHASE_ORDER_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.OTHER_PURCHASE_ORDER_EXCEL.getExportFileName() + ".xlsx";
            break;
         case GAS_PURCHASE_ORDER_EXCEL:
            resourcePath = ExcelEnum.GAS_PURCHASE_ORDER_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.GAS_PURCHASE_ORDER_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.GAS_PURCHASE_ORDER_EXCEL.getExportFileName() + ".xlsx";
            break;
         case OTHER_STEEL_MATERIALS_PURCHASE_ORDER_EXCEL:
            resourcePath = ExcelEnum.OTHER_STEEL_MATERIALS_PURCHASE_ORDER_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.OTHER_STEEL_MATERIALS_PURCHASE_ORDER_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.OTHER_STEEL_MATERIALS_PURCHASE_ORDER_EXCEL.getExportFileName() + ".xlsx";
            break;
         case OTHER_APPLY_PURCHASE_EXCEL:
            resourcePath = ExcelEnum.OTHER_APPLY_PURCHASE_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.OTHER_APPLY_PURCHASE_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.OTHER_APPLY_PURCHASE_EXCEL.getExportFileName() + ".xlsx";
            break;
         case GAS_APPLY_PURCHASE_EXCEL:
            resourcePath = ExcelEnum.GAS_APPLY_PURCHASE_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.GAS_APPLY_PURCHASE_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.GAS_APPLY_PURCHASE_EXCEL.getExportFileName() + ".xlsx";
            break;
         case OTHER_STEEL_MATERIALS_APPLY_PURCHASE_EXCEL:
            resourcePath = ExcelEnum.OTHER_STEEL_MATERIALS_APPLY_PURCHASE_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.OTHER_STEEL_MATERIALS_APPLY_PURCHASE_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.OTHER_STEEL_MATERIALS_APPLY_PURCHASE_EXCEL.getExportFileName() + ".xlsx";
            break;
         case LUMP_SUM_SYSTEM_PURCHASE_ORDER_EXCEL:
            resourcePath = ExcelEnum.LUMP_SUM_SYSTEM_PURCHASE_ORDER_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.LUMP_SUM_SYSTEM_PURCHASE_ORDER_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.LUMP_SUM_SYSTEM_PURCHASE_ORDER_EXCEL.getExportFileName() + ".xlsx";
            break;
         case OUTSOURCING_OUTBOUND_EXCEL:
            resourcePath = ExcelEnum.OUTSOURCING_OUTBOUND_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.OUTSOURCING_OUTBOUND_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.OUTSOURCING_OUTBOUND_EXCEL.getExportFileName() + ".xlsx";
            break;
         case FOR_SALE_OUTBOUND_EXCEL:
            resourcePath = ExcelEnum.FOR_SALE_OUTBOUND_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.FOR_SALE_OUTBOUND_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.FOR_SALE_OUTBOUND_EXCEL.getExportFileName() + ".xlsx";
            break;
         case FOR_SALE_DIFFERENCE_OUTBOUND_EXCEL:
            resourcePath = ExcelEnum.FOR_SALE_DIFFERENCE_OUTBOUND_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.FOR_SALE_DIFFERENCE_OUTBOUND_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.FOR_SALE_DIFFERENCE_OUTBOUND_EXCEL.getExportFileName() + ".xlsx";
            break;
         case SCRAPS_OUTBOUND_EXCEL:
            resourcePath = ExcelEnum.SCRAPS_OUTBOUND_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.SCRAPS_OUTBOUND_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.SCRAPS_OUTBOUND_EXCEL.getExportFileName() + ".xlsx";
            break;
         case STEEL_PLATE_INBOUND_SELF_BUYING_EXCEL:
            resourcePath = ExcelEnum.STEEL_PLATE_INBOUND_SELF_BUYING_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.STEEL_PLATE_INBOUND_SELF_BUYING_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.STEEL_PLATE_INBOUND_SELF_BUYING_EXCEL.getExportFileName() + ".xlsx";
            break;
         case SECTION_STEEL_INBOUND_SELF_BUYING_EXCEL:
            resourcePath = ExcelEnum.SECTION_STEEL_INBOUND_SELF_BUYING_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.SECTION_STEEL_INBOUND_SELF_BUYING_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.SECTION_STEEL_INBOUND_SELF_BUYING_EXCEL.getExportFileName() + ".xlsx";
            break;
         case COLOR_ROLL_INBOUND_SELF_BUYING_EXCEL:
            resourcePath = ExcelEnum.COLOR_ROLL_INBOUND_SELF_BUYING_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.COLOR_ROLL_INBOUND_SELF_BUYING_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.COLOR_ROLL_INBOUND_SELF_BUYING_EXCEL.getExportFileName() + ".xlsx";
            break;
         case GENERAL_MATERIAL_INBOUND_SELF_BUYING_EXCEL:
            resourcePath = ExcelEnum.GENERAL_MATERIAL_INBOUND_SELF_BUYING_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.GENERAL_MATERIAL_INBOUND_SELF_BUYING_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.GENERAL_MATERIAL_INBOUND_SELF_BUYING_EXCEL.getExportFileName() + ".xlsx";
            break;
         case OTHER_INBOUND_SELF_BUYING_EXCEL:
            resourcePath = ExcelEnum.OTHER_INBOUND_SELF_BUYING_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.OTHER_INBOUND_SELF_BUYING_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.OTHER_INBOUND_SELF_BUYING_EXCEL.getExportFileName() + ".xlsx";
            break;
         case GAS_INBOUND_SELF_BUYING_EXCEL:
            resourcePath = ExcelEnum.GAS_INBOUND_SELF_BUYING_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.GAS_INBOUND_SELF_BUYING_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.GAS_INBOUND_SELF_BUYING_EXCEL.getExportFileName() + ".xlsx";
            break;
         case OTHER_STEEL_MATERIALS_INBOUND_SELF_BUYING_EXCEL:
            resourcePath = ExcelEnum.OTHER_STEEL_MATERIALS_INBOUND_SELF_BUYING_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.OTHER_STEEL_MATERIALS_INBOUND_SELF_BUYING_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.OTHER_STEEL_MATERIALS_INBOUND_SELF_BUYING_EXCEL.getExportFileName() + ".xlsx";
            break;
         case STEEL_PLATE_INBOUND_PARTY_A_EXCEL:
            resourcePath = ExcelEnum.STEEL_PLATE_INBOUND_PARTY_A_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.STEEL_PLATE_INBOUND_PARTY_A_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.STEEL_PLATE_INBOUND_PARTY_A_EXCEL.getExportFileName() + ".xlsx";
            break;
         case SECTION_STEEL_INBOUND_PARTY_A_EXCEL:
            resourcePath = ExcelEnum.SECTION_STEEL_INBOUND_PARTY_A_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.SECTION_STEEL_INBOUND_PARTY_A_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.SECTION_STEEL_INBOUND_PARTY_A_EXCEL.getExportFileName() + ".xlsx";
            break;
         case COLOR_ROLL_INBOUND_PARTY_A_EXCEL:
            resourcePath = ExcelEnum.COLOR_ROLL_INBOUND_PARTY_A_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.COLOR_ROLL_INBOUND_PARTY_A_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.COLOR_ROLL_INBOUND_PARTY_A_EXCEL.getExportFileName() + ".xlsx";
            break;
         case GENERAL_MATERIAL_INBOUND_PARTY_A_EXCEL:
            resourcePath = ExcelEnum.GENERAL_MATERIAL_INBOUND_PARTY_A_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.GENERAL_MATERIAL_INBOUND_PARTY_A_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.GENERAL_MATERIAL_INBOUND_PARTY_A_EXCEL.getExportFileName() + ".xlsx";
            break;
         case OTHER_INBOUND_PARTY_A_EXCEL:
            resourcePath = ExcelEnum.OTHER_INBOUND_PARTY_A_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.OTHER_INBOUND_PARTY_A_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.OTHER_INBOUND_PARTY_A_EXCEL.getExportFileName() + ".xlsx";
            break;
         case GAS_INBOUND_PARTY_A_EXCEL:
            resourcePath = ExcelEnum.GAS_INBOUND_PARTY_A_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.GAS_INBOUND_PARTY_A_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.GAS_INBOUND_PARTY_A_EXCEL.getExportFileName() + ".xlsx";
            break;
         case OTHER_STEEL_MATERIALS_INBOUND_PARTY_A_EXCEL:
            resourcePath = ExcelEnum.OTHER_STEEL_MATERIALS_INBOUND_PARTY_A_EXCEL.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.OTHER_STEEL_MATERIALS_INBOUND_PARTY_A_EXCEL.getTempFileName();
            exportFileName = ExcelEnum.OTHER_STEEL_MATERIALS_INBOUND_PARTY_A_EXCEL.getExportFileName() + ".xlsx";
            break;
         case STEEL_PLATE_INBOUND_SELF_BUYING_BEGIN_TEMPLATE:
            resourcePath = ExcelEnum.STEEL_PLATE_INBOUND_SELF_BUYING_BEGIN_TEMPLATE.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.STEEL_PLATE_INBOUND_SELF_BUYING_BEGIN_TEMPLATE.getTempFileName();
            exportFileName = ExcelEnum.STEEL_PLATE_INBOUND_SELF_BUYING_BEGIN_TEMPLATE.getExportFileName() + ".xlsx";
            break;
         case SECTION_STEEL_INBOUND_SELF_BUYING_BEGIN_TEMPLATE:
            resourcePath = ExcelEnum.SECTION_STEEL_INBOUND_SELF_BUYING_BEGIN_TEMPLATE.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.SECTION_STEEL_INBOUND_SELF_BUYING_BEGIN_TEMPLATE.getTempFileName();
            exportFileName = ExcelEnum.SECTION_STEEL_INBOUND_SELF_BUYING_BEGIN_TEMPLATE.getExportFileName() + ".xlsx";
            break;
         case COLOR_ROLL_INBOUND_SELF_BUYING_BEGIN_TEMPLATE:
            resourcePath = ExcelEnum.COLOR_ROLL_INBOUND_SELF_BUYING_BEGIN_TEMPLATE.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.COLOR_ROLL_INBOUND_SELF_BUYING_BEGIN_TEMPLATE.getTempFileName();
            exportFileName = ExcelEnum.COLOR_ROLL_INBOUND_SELF_BUYING_BEGIN_TEMPLATE.getExportFileName() + ".xlsx";
            break;
         case GENERAL_MATERIAL_INBOUND_SELF_BUYING_BEGIN_TEMPLATE:
            resourcePath = ExcelEnum.GENERAL_MATERIAL_INBOUND_SELF_BUYING_BEGIN_TEMPLATE.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.GENERAL_MATERIAL_INBOUND_SELF_BUYING_BEGIN_TEMPLATE.getTempFileName();
            exportFileName = ExcelEnum.GENERAL_MATERIAL_INBOUND_SELF_BUYING_BEGIN_TEMPLATE.getExportFileName() + ".xlsx";
            break;
         case OTHER_INBOUND_SELF_BUYING_BEGIN_TEMPLATE:
            resourcePath = ExcelEnum.OTHER_INBOUND_SELF_BUYING_BEGIN_TEMPLATE.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.OTHER_INBOUND_SELF_BUYING_BEGIN_TEMPLATE.getTempFileName();
            exportFileName = ExcelEnum.OTHER_INBOUND_SELF_BUYING_BEGIN_TEMPLATE.getExportFileName() + ".xlsx";
            break;
         case GAS_INBOUND_SELF_BUYING_BEGIN_TEMPLATE:
            resourcePath = ExcelEnum.GAS_INBOUND_SELF_BUYING_BEGIN_TEMPLATE.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.GAS_INBOUND_SELF_BUYING_BEGIN_TEMPLATE.getTempFileName();
            exportFileName = ExcelEnum.GAS_INBOUND_SELF_BUYING_BEGIN_TEMPLATE.getExportFileName() + ".xlsx";
            break;
         case OTHER_STEEL_MATERIALS_INBOUND_SELF_BUYING_BEGIN_TEMPLATE:
            resourcePath = ExcelEnum.OTHER_STEEL_MATERIALS_INBOUND_SELF_BUYING_BEGIN_TEMPLATE.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.OTHER_STEEL_MATERIALS_INBOUND_SELF_BUYING_BEGIN_TEMPLATE.getTempFileName();
            exportFileName = ExcelEnum.OTHER_STEEL_MATERIALS_INBOUND_SELF_BUYING_BEGIN_TEMPLATE.getExportFileName() + ".xlsx";
            break;
         case STEEL_PLATE_INBOUND_PARTY_A_BEGIN_TEMPLATE:
            resourcePath = ExcelEnum.STEEL_PLATE_INBOUND_PARTY_A_BEGIN_TEMPLATE.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.STEEL_PLATE_INBOUND_PARTY_A_BEGIN_TEMPLATE.getTempFileName();
            exportFileName = ExcelEnum.STEEL_PLATE_INBOUND_PARTY_A_BEGIN_TEMPLATE.getExportFileName() + ".xlsx";
            break;
         case SECTION_STEEL_INBOUND_PARTY_A_BEGIN_TEMPLATE:
            resourcePath = ExcelEnum.SECTION_STEEL_INBOUND_PARTY_A_BEGIN_TEMPLATE.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.SECTION_STEEL_INBOUND_PARTY_A_BEGIN_TEMPLATE.getTempFileName();
            exportFileName = ExcelEnum.SECTION_STEEL_INBOUND_PARTY_A_BEGIN_TEMPLATE.getExportFileName() + ".xlsx";
            break;
         case COLOR_ROLL_INBOUND_PARTY_A_BEGIN_TEMPLATE:
            resourcePath = ExcelEnum.COLOR_ROLL_INBOUND_PARTY_A_BEGIN_TEMPLATE.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.COLOR_ROLL_INBOUND_PARTY_A_BEGIN_TEMPLATE.getTempFileName();
            exportFileName = ExcelEnum.COLOR_ROLL_INBOUND_PARTY_A_BEGIN_TEMPLATE.getExportFileName() + ".xlsx";
            break;
         case GENERAL_MATERIAL_INBOUND_PARTY_A_BEGIN_TEMPLATE:
            resourcePath = ExcelEnum.GENERAL_MATERIAL_INBOUND_PARTY_A_BEGIN_TEMPLATE.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.GENERAL_MATERIAL_INBOUND_PARTY_A_BEGIN_TEMPLATE.getTempFileName();
            exportFileName = ExcelEnum.GENERAL_MATERIAL_INBOUND_PARTY_A_BEGIN_TEMPLATE.getExportFileName() + ".xlsx";
            break;
         case OTHER_INBOUND_PARTY_A_BEGIN_TEMPLATE:
            resourcePath = ExcelEnum.OTHER_INBOUND_PARTY_A_BEGIN_TEMPLATE.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.OTHER_INBOUND_PARTY_A_BEGIN_TEMPLATE.getTempFileName();
            exportFileName = ExcelEnum.OTHER_INBOUND_PARTY_A_BEGIN_TEMPLATE.getExportFileName() + ".xlsx";
            break;
         case GAS_INBOUND_PARTY_A_BEGIN_TEMPLATE:
            resourcePath = ExcelEnum.GAS_INBOUND_PARTY_A_BEGIN_TEMPLATE.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.GAS_INBOUND_PARTY_A_BEGIN_TEMPLATE.getTempFileName();
            exportFileName = ExcelEnum.GAS_INBOUND_PARTY_A_BEGIN_TEMPLATE.getExportFileName() + ".xlsx";
            break;
         case OTHER_STEEL_MATERIALS_INBOUND_PARTY_A_BEGIN_TEMPLATE:
            resourcePath = ExcelEnum.OTHER_STEEL_MATERIALS_INBOUND_PARTY_A_BEGIN_TEMPLATE.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.OTHER_STEEL_MATERIALS_INBOUND_PARTY_A_BEGIN_TEMPLATE.getTempFileName();
            exportFileName = ExcelEnum.OTHER_STEEL_MATERIALS_INBOUND_PARTY_A_BEGIN_TEMPLATE.getExportFileName() + ".xlsx";
            break;
         case STEEL_PLATE_INBOUND_SELF_SURPLUS_TEMPLATE:
            resourcePath = ExcelEnum.STEEL_PLATE_INBOUND_SELF_SURPLUS_TEMPLATE.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.STEEL_PLATE_INBOUND_SELF_SURPLUS_TEMPLATE.getTempFileName();
            exportFileName = ExcelEnum.STEEL_PLATE_INBOUND_SELF_SURPLUS_TEMPLATE.getExportFileName() + ".xlsx";
            break;
         case SECTION_STEEL_INBOUND_SELF_SURPLUS_TEMPLATE:
            resourcePath = ExcelEnum.SECTION_STEEL_INBOUND_SELF_SURPLUS_TEMPLATE.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.SECTION_STEEL_INBOUND_SELF_SURPLUS_TEMPLATE.getTempFileName();
            exportFileName = ExcelEnum.SECTION_STEEL_INBOUND_SELF_SURPLUS_TEMPLATE.getExportFileName() + ".xlsx";
            break;
         case COLOR_ROLL_INBOUND_SELF_SURPLUS_TEMPLATE:
            resourcePath = ExcelEnum.COLOR_ROLL_INBOUND_SELF_SURPLUS_TEMPLATE.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.COLOR_ROLL_INBOUND_SELF_SURPLUS_TEMPLATE.getTempFileName();
            exportFileName = ExcelEnum.COLOR_ROLL_INBOUND_SELF_SURPLUS_TEMPLATE.getExportFileName() + ".xlsx";
            break;
         case GENERAL_MATERIAL_INBOUND_SELF_SURPLUS_TEMPLATE:
            resourcePath = ExcelEnum.GENERAL_MATERIAL_INBOUND_SELF_SURPLUS_TEMPLATE.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.GENERAL_MATERIAL_INBOUND_SELF_SURPLUS_TEMPLATE.getTempFileName();
            exportFileName = ExcelEnum.GENERAL_MATERIAL_INBOUND_SELF_SURPLUS_TEMPLATE.getExportFileName() + ".xlsx";
            break;
         case OTHER_INBOUND_SELF_SURPLUS_TEMPLATE:
            resourcePath = ExcelEnum.OTHER_INBOUND_SELF_SURPLUS_TEMPLATE.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.OTHER_INBOUND_SELF_SURPLUS_TEMPLATE.getTempFileName();
            exportFileName = ExcelEnum.OTHER_INBOUND_SELF_SURPLUS_TEMPLATE.getExportFileName() + ".xlsx";
            break;
         case GAS_INBOUND_SELF_SURPLUS_TEMPLATE:
            resourcePath = ExcelEnum.GAS_INBOUND_SELF_SURPLUS_TEMPLATE.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.GAS_INBOUND_SELF_SURPLUS_TEMPLATE.getTempFileName();
            exportFileName = ExcelEnum.GAS_INBOUND_SELF_SURPLUS_TEMPLATE.getExportFileName() + ".xlsx";
            break;
         case OTHER_STEEL_MATERIALS_INBOUND_SELF_SURPLUS_TEMPLATE:
            resourcePath = ExcelEnum.OTHER_STEEL_MATERIALS_INBOUND_SELF_SURPLUS_TEMPLATE.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.OTHER_STEEL_MATERIALS_INBOUND_SELF_SURPLUS_TEMPLATE.getTempFileName();
            exportFileName = ExcelEnum.OTHER_STEEL_MATERIALS_INBOUND_SELF_SURPLUS_TEMPLATE.getExportFileName() + ".xlsx";
            break;
         case STEEL_PLATE_INBOUND_PARTY_A_SURPLUS_TEMPLATE:
            resourcePath = ExcelEnum.STEEL_PLATE_INBOUND_PARTY_A_SURPLUS_TEMPLATE.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.STEEL_PLATE_INBOUND_PARTY_A_SURPLUS_TEMPLATE.getTempFileName();
            exportFileName = ExcelEnum.STEEL_PLATE_INBOUND_PARTY_A_SURPLUS_TEMPLATE.getExportFileName() + ".xlsx";
            break;
         case SECTION_STEEL_INBOUND_PARTY_A_SURPLUS_TEMPLATE:
            resourcePath = ExcelEnum.SECTION_STEEL_INBOUND_PARTY_A_SURPLUS_TEMPLATE.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.SECTION_STEEL_INBOUND_PARTY_A_SURPLUS_TEMPLATE.getTempFileName();
            exportFileName = ExcelEnum.SECTION_STEEL_INBOUND_PARTY_A_SURPLUS_TEMPLATE.getExportFileName() + ".xlsx";
            break;
         case COLOR_ROLL_INBOUND_PARTY_A_SURPLUS_TEMPLATE:
            resourcePath = ExcelEnum.COLOR_ROLL_INBOUND_PARTY_A_SURPLUS_TEMPLATE.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.COLOR_ROLL_INBOUND_PARTY_A_SURPLUS_TEMPLATE.getTempFileName();
            exportFileName = ExcelEnum.COLOR_ROLL_INBOUND_PARTY_A_SURPLUS_TEMPLATE.getExportFileName() + ".xlsx";
            break;
         case GENERAL_MATERIAL_INBOUND_PARTY_A_SURPLUS_TEMPLATE:
            resourcePath = ExcelEnum.GENERAL_MATERIAL_INBOUND_PARTY_A_SURPLUS_TEMPLATE.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.GENERAL_MATERIAL_INBOUND_PARTY_A_SURPLUS_TEMPLATE.getTempFileName();
            exportFileName = ExcelEnum.GENERAL_MATERIAL_INBOUND_PARTY_A_SURPLUS_TEMPLATE.getExportFileName() + ".xlsx";
            break;
         case OTHER_INBOUND_PARTY_A_SURPLUS_TEMPLATE:
            resourcePath = ExcelEnum.OTHER_INBOUND_PARTY_A_SURPLUS_TEMPLATE.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.OTHER_INBOUND_PARTY_A_SURPLUS_TEMPLATE.getTempFileName();
            exportFileName = ExcelEnum.OTHER_INBOUND_PARTY_A_SURPLUS_TEMPLATE.getExportFileName() + ".xlsx";
            break;
         case GAS_INBOUND_PARTY_A_SURPLUS_TEMPLATE:
            resourcePath = ExcelEnum.GAS_INBOUND_PARTY_A_SURPLUS_TEMPLATE.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.GAS_INBOUND_PARTY_A_SURPLUS_TEMPLATE.getTempFileName();
            exportFileName = ExcelEnum.GAS_INBOUND_PARTY_A_SURPLUS_TEMPLATE.getExportFileName() + ".xlsx";
            break;
         case OTHER_STEEL_MATERIALS_INBOUND_PARTY_A_SURPLUS_TEMPLATE:
            resourcePath = ExcelEnum.OTHER_STEEL_MATERIALS_INBOUND_PARTY_A_SURPLUS_TEMPLATE.getResourcePath() + ".xlsx";
            tempFileName = ExcelEnum.OTHER_STEEL_MATERIALS_INBOUND_PARTY_A_SURPLUS_TEMPLATE.getTempFileName();
            exportFileName = ExcelEnum.OTHER_STEEL_MATERIALS_INBOUND_PARTY_A_SURPLUS_TEMPLATE.getExportFileName() + ".xlsx";
            break;
         default:
            resourcePath = "";
            tempFileName = "";
            exportFileName = "";
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
      PoiUtils.wmsDownLoadExcel(exportFileName, response, workbook, message);
   }

   private List<Long> getLastIds(Long classifyId) {
      if (classifyId != null) {
         Classification classification = this.classificationService.getById(classifyId);
         if (!classification.getBoolLastEnum()) {
            return this.classificationService.getLastSubject(classifyId).stream().map(Classification::getId).collect(Collectors.toList());
         }
      }

      return null;
   }

   private Map<String, String> setClassifyName(Integer basicClass, Long classId, String className) {
      Map<String, String> map = new HashMap<>();
      if (BasicClassEnum.checkIsSteel(basicClass)) {
         map.put("分类", "钢材");
         map.put("名称", className);
      } else {
         Classification classify = this.classificationService.getById(classId);
         if (classify != null) {
            List<Long> spilt = CommonUtil.spilt(classify.getPath(), ",");
            if (spilt.size() == 1) {
               map.put("分类", classify.getName());
            } else {
               spilt.remove(classId);
               if (spilt.size() == 1) {
                  Classification classification = this.classificationService.getById(spilt.get(0));
                  map.put("分类", classification.getName());
               } else {
                  Classification classification = this.classificationService.getById(spilt.get(0));
                  Classification classification1 = this.classificationService.getById(spilt.get(1));
                  map.put("分类", classification.getName() + "/" + classification1.getName());
               }
            }

            map.put("名称", classify.getName());
         }
      }

      return map;
   }

   private Map<String, String> setClassifyNameV2(Integer basicClass, Long classId, String className, Map<Long, Classification> classificationMap) {
      Map<String, String> map = new HashMap<>();
      if (BasicClassEnum.checkIsSteel(basicClass)) {
         map.put("分类", "钢材");
         map.put("名称", className);
      } else {
         Classification classify = classificationMap.get(classId);
         if (classify != null) {
            List<Long> spilt = CommonUtil.spilt(classify.getPath(), ",");
            if (spilt.size() == 1) {
               map.put("分类", classify.getName());
            } else {
               spilt.remove(classId);
               if (spilt.size() == 1) {
                  Classification classification = classificationMap.get(spilt.get(0));
                  map.put("分类", classification.getName());
               } else {
                  Classification classification = classificationMap.get(spilt.get(0));
                  Classification classification1 = classificationMap.get(spilt.get(1));
                  map.put("分类", classification.getName() + "/" + classification1.getName());
               }
            }

            map.put("名称", classify.getName());
         }
      }

      return map;
   }

   private DownLoadDetailDO getDownLoadDetailDO(
      WeightedPriceConf weightedPriceConf, Map<Long, MonthWeightedAveragePrice> monthWeightedAveragePrices, DownLoadDetailDO detailDO
   ) {
      if (detailDO.getAmount() == null && detailDO.getAmountExcludingVat() == null) {
         MonthWeightedAveragePrice price = monthWeightedAveragePrices.get(detailDO.getWapId());
         if (price != null) {
            if (WeightedPriceEnum.WHOLE.getType().equals(weightedPriceConf.getWeightedType())) {
               WholeWeightedAveragePrice wholeWeightedAveragePrice = this.wholeWeightedAveragePriceMapper.selectById(price.getWholeWapId());
               price.setMete(wholeWeightedAveragePrice.getMete());
               price.setAmount(wholeWeightedAveragePrice.getAmount());
               price.setAmountExcludingVat(wholeWeightedAveragePrice.getAmountExcludingVat());
            }

            if (price.getMete().compareTo(BigDecimal.ZERO) != 0) {
               BigDecimal p = detailDO.getMete().divide(price.getMete(), 20, RoundingMode.HALF_UP);
               BigDecimal amount = price.getAmount().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
               BigDecimal amountExcludingVat = price.getAmountExcludingVat().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
               BigDecimal avgPrice = NumberUtil.div(amount, detailDO.getMete(), 12);
               BigDecimal excludingVatAvgPrice = NumberUtil.div(amountExcludingVat, detailDO.getMete(), 12);
               detailDO.setAmount(amount);
               detailDO.setAmountExcludingVat(amountExcludingVat);
               detailDO.setUnitPrice(avgPrice);
               detailDO.setUnitPriceExcludingVAT(excludingVatAvgPrice);
            }
         }
      }

      return detailDO;
   }

   @Override
   public void outsourcingOutboundDownload(QueryDetailDTOParam param, HttpServletResponse response, int type) {
      String message = null;
      HashMap<String, Object> map = new HashMap<>(16);
      if (CollectionUtil.isNotEmpty(param.getReviewTime())) {
         WeightedPriceConf weightedPriceConf = JSON.parseObject(
            this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置")).getValue(),
            WeightedPriceConf.class
         );
         param.setClassifyIds(this.queryUtil.getLateClassificationList(param.getClassifyId()));
         String a = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(param.getReviewTime().get(0));
         String b = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(param.getReviewTime().get(1));
         map.put("outboundData", a + "~" + b);
         List<DownLoadDetailDO> list = this.moveOutboundDetailMapper.getDownLoadOutsourcingOrScrapsDetail(param);
         List<Map<String, Object>> mapList = new ArrayList<>();
         Map<Long, MonthWeightedAveragePrice> monthWeightedAveragePrices = new HashMap<>();
         List<Long> collect = list.stream().map(DownLoadDetailDO::getWapId).collect(Collectors.toList());
         if (CollectionUtil.isNotEmpty(collect)) {
            monthWeightedAveragePrices = this.monthWAPMapper
               .selectList((Wrapper<MonthWeightedAveragePrice>)new LambdaQueryWrapper<MonthWeightedAveragePrice>().in(MonthWeightedAveragePrice::getId, collect))
               .stream()
               .collect(Collectors.toMap(MonthWeightedAveragePrice::getId, Function.identity()));
         }

         for (int i = 0; i < list.size(); i++) {
            Map<String, Object> mapObject = new HashMap<>();
            DownLoadDetailDO detailDO = list.get(i);
            mapObject.put("id", i + 1);
            mapObject.put("outboundTime", DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(detailDO.getOutboundTime()));
            mapObject.put("reviewTime", DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(detailDO.getReviewTime()));
            Map<String, String> classMap = this.setClassifyName(detailDO.getBasicClass(), detailDO.getClassifyId(), detailDO.getClassifyName());
            mapObject.put("basicClass", classMap.get("分类"));
            mapObject.put("classifyName", classMap.get("名称"));
            StringBuilder sb = new StringBuilder();
            StringBuilder lengths = new StringBuilder();
            StringBuilder material = new StringBuilder();
            this.setSpecs(detailDO, sb, lengths, material);
            mapObject.put("spec", sb);
            mapObject.put("material", StrUtil.isNotBlank(material) ? material : "-");
            mapObject.put("lengths", StrUtil.isNotBlank(lengths) ? lengths : "-");
            Measure measure = detailDO.getMeasure();
            detailDO = this.getDownLoadDetailDO(weightedPriceConf, monthWeightedAveragePrices, detailDO);
            this.setAmountAndMete(mapObject, detailDO, measure);
            mapObject.put("serialNumber", detailDO.getSerialNumber());
            mapObject.put("heatNoAndBatchNo", StrUtil.isNotBlank(detailDO.getHeatNoAndBatchNo()) ? detailDO.getHeatNoAndBatchNo() : "-");
            mapObject.put("orderSerialNumber", detailDO.getOrderSerialNumber());
            mapObject.put("workshopName", detailDO.getWorkshopName());
            mapObject.put("remark", StrUtil.isNotBlank(detailDO.getRemark()) ? detailDO.getRemark() : "-");
            mapObject.put("brand", StrUtil.isNotBlank(detailDO.getBrand()) ? detailDO.getBrand() : "-");
            mapObject.put("applicantName", StrUtil.isNotBlank(detailDO.getApplicantName()) ? detailDO.getApplicantName() : "-");
            mapObject.put("applicantTime", DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(detailDO.getApplicantTime()));
            mapList.add(mapObject);
         }

         map.put("mapList", mapList);
      } else {
         message = "请选择下载的时间范围";
      }

      this.downloadV2(response, message, map, type);
   }

   @Override
   public void forSaleDownload(QueryDetailDTOParam param, HttpServletResponse response, int type) {
      String message = null;
      HashMap<String, Object> map = new HashMap<>(16);
      if (CollectionUtil.isNotEmpty(param.getOutboundTime())) {
         param.setClassifyIds(this.queryUtil.getLateClassificationList(param.getClassifyId()));
         String a = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(param.getOutboundTime().get(0));
         String b = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(param.getOutboundTime().get(1));
         map.put("outboundData", a + "~" + b);
         param.setTimeType(2);
         param.setFunctionType(FunctionTypeEnum.WMS_SELF_BUYING_OUT.getType());
         List<DownLoadDetailDO> list = this.moveOutboundDetailMapper.getDownLoadDetail(param);
         List<WmsForSaleDetail> wmsForSaleDetails = new ArrayList<>();
         List<WmsForSale> wmsForSaleList = new ArrayList<>();
         if (CollectionUtil.isNotEmpty(list)) {
            List<Long> outboundDetailIds = list.stream().map(DownLoadDetailDO::getId).collect(Collectors.toList());
            wmsForSaleDetails = this.wmsForSaleDetailService
               .list((Wrapper<WmsForSaleDetail>)new LambdaQueryWrapper<WmsForSaleDetail>().in(WmsForSaleDetail::getOutboundDetailId, outboundDetailIds).exists(WmsForSaleDetailMapper.OUTBOUND_PARENT_EXISTS_SQL));
            List<String> forSaleSerialNumberList = wmsForSaleDetails.stream().map(WmsForSaleDetail::getForSaleSerialNumber).collect(Collectors.toList());
            wmsForSaleList = this.wmsForSaleService
               .list((Wrapper<WmsForSale>)new LambdaQueryWrapper<WmsForSale>().in(WmsForSale::getSerialNumber, forSaleSerialNumberList));
         }

         BasicShowConfig basicShowConfig = this.basicConfigService.getBasicShowConfig();
         List<Map<String, Object>> mapList = new ArrayList<>();

         for (int i = 0; i < list.size(); i++) {
            Map<String, Object> mapObject = new HashMap<>();
            DownLoadDetailDO detailDO = list.get(i);
            mapObject.put("id", i + 1);
            mapObject.put("data", DateTimeFormatter.ofPattern("yyyy/MM/dd").format(detailDO.getOutboundTime()));
            mapObject.put("checkData", DateTimeFormatter.ofPattern("yyyy/MM/dd").format(detailDO.getReviewTime()));
            Map<String, String> classMap = this.setClassifyName(detailDO.getBasicClass(), detailDO.getClassifyId(), detailDO.getClassifyName());
            mapObject.put("basicClass", classMap.get("分类"));
            mapObject.put("classifyName", classMap.get("名称"));
            StringBuilder sb = new StringBuilder();
            StringBuilder lengths = new StringBuilder();
            StringBuilder material = new StringBuilder();
            this.setSpecs(detailDO, sb, lengths, material);
            mapObject.put("spec", this.queryUtil.getConfigShowSpec(JSON.toJSONString(detailDO), basicShowConfig));
            mapObject.put("material", StrUtil.isNotBlank(material) ? material : "-");
            mapObject.put("brand", StrUtil.isNotBlank(detailDO.getBrand()) ? detailDO.getBrand() : "-");
            mapObject.put("heatNoAndBatchNo", StrUtil.isNotBlank(detailDO.getHeatNoAndBatchNo()) ? detailDO.getHeatNoAndBatchNo() : "-");
            Measure measure = detailDO.getMeasure();
            this.setAmountAndMete(mapObject, detailDO, measure);
            DownLoadDetailDO finalDetailDO = detailDO;
            WmsForSaleDetail wmsForSaleDetail = wmsForSaleDetails.stream()
               .filter(w -> w.getOutboundDetailId().equals(finalDetailDO.getId()))
               .findAny()
               .orElse(null);
            WmsForSale wmsForSale = wmsForSaleList.stream()
               .filter(w -> w.getSerialNumber().equals(wmsForSaleDetail.getForSaleSerialNumber()))
               .findAny()
               .orElse(null);
            if (StrUtil.isBlank(measure.getAccountingUnit())) {
               Classification classification = this.classificationService.getById(detailDO.getClassifyId());
               measure = this.getMeasure(classification.getParentId());
            }

            String accountingUnit = measure.getAccountingUnit();
            Map<Integer, BigDecimal> mete = this.unitConversion(wmsForSaleDetail.getInputMete(), accountingUnit, measure.getAccountingPrecision());
            if (ObjectUtil.isNotEmpty(wmsForSaleDetail.getWeightMeasurementMode())) {
               mapObject.put("theoryMete", wmsForSaleDetail.getWeightMeasurementMode().equals(MeasureEnum.THEORY.getType()) ? mete.get(1) : "-");
               mapObject.put("weighMete", wmsForSaleDetail.getWeightMeasurementMode().equals(MeasureEnum.POUND.getType()) ? mete.get(1) : "-");
               mapObject.put("weightMeasurementModeStr", MeasureEnum.getNameByType(wmsForSaleDetail.getWeightMeasurementMode()));
            } else {
               mapObject.put("theoryMete", "-");
               mapObject.put("weighMete", "-");
               mapObject.put("weightMeasurementModeStr", "-");
            }

            mapObject.put("invoiceTypeStr", InvoiceTypeEnum.getValueByType(wmsForSale.getInvoiceType()));
            mapObject.put("forSaleTaxRate", ObjectUtil.isNotEmpty(wmsForSale.getTaxRate()) ? wmsForSale.getTaxRate().setScale(0).toPlainString() + "%" : "-");
            mapObject.put("sellUnitPrice", wmsForSaleDetail.getSellUnitPrice().multiply(mete.get(2)).setScale(2, RoundingMode.HALF_UP));
            mapObject.put("sellUnitPriceExcludingVat", wmsForSaleDetail.getSellUnitPriceExcludingVat().multiply(mete.get(2)).setScale(2, RoundingMode.HALF_UP));
            mapObject.put("sellAmount", wmsForSaleDetail.getSellAmount().setScale(this.amountAccuracy, RoundingMode.HALF_UP));
            mapObject.put("sellAmountExcludingVat", wmsForSaleDetail.getSellAmountExcludingVat().setScale(this.amountAccuracy, RoundingMode.HALF_UP));
            mapObject.put("sellInputVat", ObjectUtil.isNotEmpty(wmsForSaleDetail.getInputVat()) ? wmsForSaleDetail.getInputVat() : "-");
            mapObject.put("wmsWorkshopName", detailDO.getWmsWorkshopName());
            mapObject.put("serialNumber", detailDO.getSerialNumber());
            mapObject.put("branchCompanyName", ObjectUtil.isNotEmpty(detailDO.getBranchCompanyName()) ? detailDO.getBranchCompanyName() : "-");
            mapObject.put("applicantName", detailDO.getApplicantName());
            mapObject.put("differenceMete", wmsForSaleDetail.getDifferenceMete());
            mapObject.put("profitAmount", wmsForSaleDetail.getProfitAmount());
            mapObject.put("remark", StrUtil.isNotBlank(detailDO.getRemark()) ? detailDO.getRemark() : "-");
            mapObject.put("purchaser", ObjectUtil.isNotEmpty(wmsForSale.getPurchaser()) ? wmsForSale.getPurchaser() : "-");
            mapList.add(mapObject);
         }

         map.put("mapList", mapList);
      } else {
         message = "请选择下载的审核时间范围";
      }

      this.downloadV2(response, message, map, type);
   }

   @Override
   public void scrapsOutboundDownload(QueryDetailDTOParam param, HttpServletResponse response, int type) {
      String message = null;
      HashMap<String, Object> map = new HashMap<>(16);
      if (CollectionUtil.isNotEmpty(param.getMaterialOutboundTime())) {
         WeightedPriceConf weightedPriceConf = JSON.parseObject(
            this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置")).getValue(),
            WeightedPriceConf.class
         );
         param.setClassifyIds(this.queryUtil.getLateClassificationList(param.getClassifyId()));
         String a = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(param.getMaterialOutboundTime().get(0));
         String b = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(param.getMaterialOutboundTime().get(1));
         map.put("outboundData", a + "~" + b);
         List<DownLoadDetailDO> list = this.moveOutboundDetailMapper.getDownLoadOutsourcingOrScrapsDetail(param);
         List<Long> collect = list.stream().map(DownLoadDetailDO::getWapId).collect(Collectors.toList());
         Map<Long, MonthWeightedAveragePrice> monthWeightedAveragePrices = new HashMap<>();
         if (CollectionUtil.isNotEmpty(collect)) {
            List<MonthWeightedAveragePrice> monthWeightedAveragePriceList = this.monthWAPMapper
               .selectList((Wrapper<MonthWeightedAveragePrice>)new LambdaQueryWrapper<MonthWeightedAveragePrice>().in(MonthWeightedAveragePrice::getId, collect));
            monthWeightedAveragePrices = monthWeightedAveragePriceList.stream()
               .collect(Collectors.toMap(MonthWeightedAveragePrice::getId, Function.identity()));
         }

         List<Map<String, Object>> mapList = new ArrayList<>();

         for (int i = 0; i < list.size(); i++) {
            Map<String, Object> mapObject = new HashMap<>();
            DownLoadDetailDO detailDO = list.get(i);
            mapObject.put("id", i + 1);
            mapObject.put("outboundTime", DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(detailDO.getOutboundTime()));
            mapObject.put("reviewTime", DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(detailDO.getReviewTime()));
            Map<String, String> classMap = this.setClassifyName(detailDO.getBasicClass(), detailDO.getClassifyId(), detailDO.getClassifyName());
            mapObject.put("basicClass", classMap.get("分类"));
            mapObject.put("classifyName", classMap.get("名称"));
            StringBuilder sb = new StringBuilder();
            StringBuilder lengths = new StringBuilder();
            StringBuilder material = new StringBuilder();
            this.setSpecs(detailDO, sb, lengths, material);
            mapObject.put("spec", sb);
            mapObject.put("material", StrUtil.isNotBlank(material) ? material : "-");
            mapObject.put("lengths", StrUtil.isNotBlank(lengths) ? lengths : "-");
            Measure measure = detailDO.getMeasure();
            detailDO = this.getDownLoadDetailDO(weightedPriceConf, monthWeightedAveragePrices, detailDO);
            this.setAmountAndMete(mapObject, detailDO, measure);
            mapObject.put("serialNumber", detailDO.getSerialNumber());
            mapObject.put("heatNoAndBatchNo", StrUtil.isNotBlank(detailDO.getHeatNoAndBatchNo()) ? detailDO.getHeatNoAndBatchNo() : "-");
            mapObject.put("orderSerialNumber", detailDO.getOrderSerialNumber());
            mapObject.put("workshopName", detailDO.getWorkshopName());
            mapObject.put("remark", StrUtil.isNotBlank(detailDO.getRemark()) ? detailDO.getRemark() : "-");
            mapObject.put("brand", StrUtil.isNotBlank(detailDO.getBrand()) ? detailDO.getBrand() : "-");
            mapObject.put("applicantName", StrUtil.isNotBlank(detailDO.getApplicantName()) ? detailDO.getApplicantName() : "-");
            mapObject.put("applicantTime", DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(detailDO.getApplicantTime()));
            mapList.add(mapObject);
         }

         map.put("mapList", mapList);
      } else {
         message = "请选择下载的时间范围";
      }

      this.downloadV2(response, message, map, type);
   }

   @Override
   public void inboundManufacturedDownload(QueryInboundManufacturedDTOParam param, HttpServletResponse response) {
      String message = null;
      HashMap<String, Object> map = new HashMap<>(16);
      if (CollectionUtil.isNotEmpty(param.getReviewPassTime())) {
         String a = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(param.getReviewPassTime().get(0));
         String b = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(param.getReviewPassTime().get(1));
         map.put("inboundData", a + "~" + b);
         List<InboundDetailManufactured> inboundDetailManufactureds = this.inboundDetailManufacturedService.selectList(param);
         List<Map<String, Object>> mapList = new ArrayList<>();
         if (CollectionUtil.isNotEmpty(inboundDetailManufactureds)) {
            Set<Long> inboundManufacturedIds = new TreeSet<>();
            Set<Long> projectIds = new TreeSet<>();
            Set<Long> monomerIds = new TreeSet<>();
            Set<Long> areaIds = new TreeSet<>();
            Set<Long> purchaseIds = new TreeSet<>();

            for (InboundDetailManufactured inboundDetailManufactured : inboundDetailManufactureds) {
               if (ObjectUtil.isNotEmpty(inboundDetailManufactured.getInboundManufacturedId())) {
                  inboundManufacturedIds.add(inboundDetailManufactured.getInboundManufacturedId());
               }

               if (ObjectUtil.isNotEmpty(inboundDetailManufactured.getProjectId())) {
                  projectIds.add(inboundDetailManufactured.getProjectId());
               }

               if (ObjectUtil.isNotEmpty(inboundDetailManufactured.getMonomerId())) {
                  monomerIds.add(inboundDetailManufactured.getMonomerId());
               }

               if (ObjectUtil.isNotEmpty(inboundDetailManufactured.getAreaId())) {
                  areaIds.add(inboundDetailManufactured.getAreaId());
               }

               if (ObjectUtil.isNotEmpty(inboundDetailManufactured.getPurchaseId())) {
                  purchaseIds.add(inboundDetailManufactured.getPurchaseId());
               }
            }

            Map<Long, InboundManufactured> inboundManufacturedMap = this.queryUtil.getInboundManufacturedMapByIds(inboundManufacturedIds);
            Map<Long, ContractProject> projectMap = this.queryUtil.getProjectMapByIds(projectIds);
            Map<Long, PlanMonomer> planMonomerMap = this.queryUtil.getMonomerMapByIds(monomerIds);
            Map<Long, PlanArea> planAreaMap = this.queryUtil.getAreaMapByIds(areaIds);
            Map<Long, PurchaseOrder> purchaseOrderMap = this.queryUtil.getPurchaseOrderMapByIds(purchaseIds);
            Map<Long, Supplier> supplierMap = this.queryUtil.getSupplierMap(null);

            for (int i = 0; i < inboundDetailManufactureds.size(); i++) {
               Map<String, Object> mapObject = new HashMap<>();
               InboundDetailManufactured detail = inboundDetailManufactureds.get(i);
               InboundManufactured inboundManufactured = inboundManufacturedMap.get(detail.getInboundManufacturedId());
               mapObject.put("id", i + 1);
               mapObject.put("data", DateTimeFormatter.ofPattern("yyyy/MM/dd").format(inboundManufactured.getReviewPassTime()));
               mapObject.put("basicClass", BasicClassEnum.getNameByType(detail.getBasicClass()));
               mapObject.put("manufacturedName", detail.getManufacturedName());
               mapObject.put("manufacturedSn", detail.getManufacturedSn());
               mapObject.put("spec", detail.getSpecification());
               mapObject.put("brand", detail.getBrand());
               mapObject.put("material", detail.getMaterial());
               mapObject.put("quantity", detail.getQuantity());
               mapObject.put("weight", "-");
               if (ObjectUtil.isNotEmpty(detail.getWeight())) {
                  mapObject.put("weight", detail.getWeight().divide(UnitsPrecisionEnum.EG_KG.getRate(), 4, RoundingMode.CEILING));
               }

               mapObject.put("length", "-");
               if (ObjectUtil.isNotEmpty(detail.getLength())) {
                  mapObject.put("length", detail.getLength().divide(UnitsPrecisionEnum.LG_M.getRate(), 4, RoundingMode.CEILING));
               }

               mapObject.put("surfaceArea", "-");
               if (ObjectUtil.isNotEmpty(detail.getSurfaceArea())) {
                  mapObject.put("surfaceArea", detail.getSurfaceArea().divide(UnitsPrecisionEnum.AG_M.getRate(), 4, RoundingMode.CEILING));
               }

               mapObject.put("totalWeight", "-");
               if (ObjectUtil.isNotEmpty(detail.getTotalWeight())) {
                  mapObject.put("totalWeight", detail.getTotalWeight().divide(UnitsPrecisionEnum.EG_KG.getRate(), 4, RoundingMode.CEILING));
               }

               mapObject.put("totalLength", "-");
               if (ObjectUtil.isNotEmpty(detail.getTotalLength())) {
                  mapObject.put("totalLength", detail.getTotalLength().divide(UnitsPrecisionEnum.LG_M.getRate(), 4, RoundingMode.CEILING));
               }

               mapObject.put("totalArea", "-");
               if (ObjectUtil.isNotEmpty(detail.getTotalArea())) {
                  mapObject.put("totalArea", detail.getTotalArea().divide(UnitsPrecisionEnum.AG_M.getRate(), 4, RoundingMode.CEILING));
               }

               if (detail.getWageQuotaType().equals(WmsWageQuotaTypeEnum.WMS_WEIGHT_PRICE.getType())) {
                  mapObject.put("wageQuotaType", "元/" + UnitsPrecisionEnum.EG_T.getName());
                  mapObject.put("unitPrice", detail.getUnitPrice().multiply(UnitsPrecisionEnum.EG_T.getRate()));
                  mapObject.put("unitPriceExcludingVat", detail.getUnitPriceExcludingVat().multiply(UnitsPrecisionEnum.EG_T.getRate()));
               } else if (detail.getWageQuotaType().equals(WmsWageQuotaTypeEnum.WMS_LENGTH_PRICE.getType())) {
                  mapObject.put("wageQuotaType", "元/" + UnitsPrecisionEnum.LG_M.getName());
                  mapObject.put("unitPrice", detail.getUnitPrice().multiply(UnitsPrecisionEnum.LG_M.getRate()));
                  mapObject.put("unitPriceExcludingVat", detail.getUnitPriceExcludingVat().multiply(UnitsPrecisionEnum.LG_M.getRate()));
               } else if (detail.getWageQuotaType().equals(WmsWageQuotaTypeEnum.WMS_AREA_PRICE.getType())) {
                  mapObject.put("wageQuotaType", "元/" + UnitsPrecisionEnum.AG_M.getName());
                  mapObject.put("unitPrice", detail.getUnitPrice().multiply(UnitsPrecisionEnum.AG_M.getRate()));
                  mapObject.put("unitPriceExcludingVat", detail.getUnitPriceExcludingVat().multiply(UnitsPrecisionEnum.AG_M.getRate()));
               } else if (detail.getWageQuotaType().equals(WmsWageQuotaTypeEnum.WMS_QUANTITY_PRICE.getType())) {
                  mapObject.put("wageQuotaType", "元/数量");
                  mapObject.put("unitPrice", detail.getUnitPrice());
                  mapObject.put("unitPriceExcludingVat", detail.getUnitPriceExcludingVat());
               } else {
                  mapObject.put("wageQuotaType", "-");
                  mapObject.put("unitPrice", detail.getUnitPrice());
                  mapObject.put("unitPriceExcludingVat", detail.getUnitPriceExcludingVat());
               }

               mapObject.put("amount", detail.getAmount());
               mapObject.put("amountExcludingVat", detail.getAmountExcludingVat());
               mapObject.put("taxRate", detail.getTaxRate());
               if (ObjectUtil.isNotEmpty(detail.getProjectId())) {
                  ContractProject contractProject = projectMap.get(detail.getProjectId());
                  mapObject.put("projectNumber", contractProject.getSerialNumber());
                  mapObject.put("projectName", contractProject.getShortName());
               }

               if (ObjectUtil.isNotEmpty(detail.getMonomerId())) {
                  PlanMonomer monomer = planMonomerMap.get(detail.getMonomerId());
                  mapObject.put("monomerName", monomer.getName());
               }

               if (ObjectUtil.isNotEmpty(detail.getAreaId())) {
                  PlanArea area = planAreaMap.get(detail.getAreaId());
                  mapObject.put("areaName", area.getName());
               }

               mapObject.put("serialNumber", inboundManufactured.getSerialNumber());
               if (ObjectUtil.isNotEmpty(inboundManufactured.getPurchaseId())) {
                  PurchaseOrder purchaseOrder = purchaseOrderMap.get(inboundManufactured.getPurchaseId());
                  mapObject.put("purchaseSn", purchaseOrder.getSerialNumber());
                  Supplier supplier = supplierMap.get(purchaseOrder.getSupplierId());
                  mapObject.put("supplierName", supplier.getName());
               }

               mapObject.put("remark", detail.getBrand());
               mapList.add(mapObject);
            }
         }

         map.put("mapList", mapList);
      } else {
         message = "请选择下载的时间范围";
      }

      this.download(response, message, map, 24);
   }

   @Override
   public void outboundManufacturedDownload(QueryOutboundManufacturedDTOParam param, HttpServletResponse response) {
      String message = null;
      HashMap<String, Object> map = new HashMap<>(16);
      if (CollectionUtil.isNotEmpty(param.getReviewPassTime())) {
         String a = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(param.getReviewPassTime().get(0));
         String b = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(param.getReviewPassTime().get(1));
         map.put("outboundData", a + "~" + b);
         List<OutboundDetailManufactured> outboundDetailManufactureds = this.outboundDetailManufacturedService.selectList(param);
         List<Map<String, Object>> mapList = new ArrayList<>();
         if (CollectionUtil.isNotEmpty(outboundDetailManufactureds)) {
            Set<Long> outboundManufacturedIds = new TreeSet<>();
            Set<Long> projectIds = new TreeSet<>();
            Set<Long> monomerIds = new TreeSet<>();
            Set<Long> areaIds = new TreeSet<>();

            for (OutboundDetailManufactured outboundDetailManufactured : outboundDetailManufactureds) {
               if (ObjectUtil.isNotEmpty(outboundDetailManufactured.getOutboundManufacturedId())) {
                  outboundManufacturedIds.add(outboundDetailManufactured.getOutboundManufacturedId());
               }

               if (ObjectUtil.isNotEmpty(outboundDetailManufactured.getProjectId())) {
                  projectIds.add(outboundDetailManufactured.getProjectId());
               }

               if (ObjectUtil.isNotEmpty(outboundDetailManufactured.getMonomerId())) {
                  monomerIds.add(outboundDetailManufactured.getMonomerId());
               }

               if (ObjectUtil.isNotEmpty(outboundDetailManufactured.getAreaId())) {
                  areaIds.add(outboundDetailManufactured.getAreaId());
               }
            }

            Map<Long, OutboundManufactured> outboundManufacturedMap = this.queryUtil.getOutboundManufacturedMapByIds(outboundManufacturedIds);
            Map<Long, ContractProject> projectMap = this.queryUtil.getProjectMapByIds(projectIds);
            Map<Long, PlanMonomer> planMonomerMap = this.queryUtil.getMonomerMapByIds(monomerIds);
            Map<Long, PlanArea> planAreaMap = this.queryUtil.getAreaMapByIds(areaIds);

            for (int i = 0; i < outboundDetailManufactureds.size(); i++) {
               Map<String, Object> mapObject = new HashMap<>();
               OutboundDetailManufactured detail = outboundDetailManufactureds.get(i);
               OutboundManufactured outboundManufactured = outboundManufacturedMap.get(detail.getOutboundManufacturedId());
               mapObject.put("id", i + 1);
               mapObject.put("data", DateTimeFormatter.ofPattern("yyyy/MM/dd").format(outboundManufactured.getReviewPassTime()));
               mapObject.put("basicClass", BasicClassEnum.getNameByType(detail.getBasicClass()));
               mapObject.put("manufacturedName", detail.getManufacturedName());
               mapObject.put("manufacturedSn", detail.getManufacturedSn());
               mapObject.put("spec", detail.getSpecification());
               mapObject.put("brand", detail.getBrand());
               mapObject.put("material", detail.getMaterial());
               mapObject.put("quantity", detail.getQuantity());
               mapObject.put("weight", "-");
               if (ObjectUtil.isNotEmpty(detail.getWeight())) {
                  mapObject.put("weight", detail.getWeight().divide(UnitsPrecisionEnum.EG_KG.getRate(), 4, RoundingMode.CEILING));
               }

               mapObject.put("length", "-");
               if (ObjectUtil.isNotEmpty(detail.getLength())) {
                  mapObject.put("length", detail.getLength().divide(UnitsPrecisionEnum.LG_M.getRate(), 4, RoundingMode.CEILING));
               }

               mapObject.put("surfaceArea", "-");
               if (ObjectUtil.isNotEmpty(detail.getSurfaceArea())) {
                  mapObject.put("surfaceArea", detail.getSurfaceArea().divide(UnitsPrecisionEnum.AG_M.getRate(), 4, RoundingMode.CEILING));
               }

               mapObject.put("totalWeight", "-");
               if (ObjectUtil.isNotEmpty(detail.getTotalWeight())) {
                  mapObject.put("totalWeight", detail.getTotalWeight().divide(UnitsPrecisionEnum.EG_KG.getRate(), 4, RoundingMode.CEILING));
               }

               mapObject.put("totalLength", "-");
               if (ObjectUtil.isNotEmpty(detail.getTotalLength())) {
                  mapObject.put("totalLength", detail.getTotalLength().divide(UnitsPrecisionEnum.LG_M.getRate(), 4, RoundingMode.CEILING));
               }

               mapObject.put("totalArea", "-");
               if (ObjectUtil.isNotEmpty(detail.getTotalArea())) {
                  mapObject.put("totalArea", detail.getTotalArea().divide(UnitsPrecisionEnum.AG_M.getRate(), 4, RoundingMode.CEILING));
               }

               if (detail.getWageQuotaType().equals(WmsWageQuotaTypeEnum.WMS_WEIGHT_PRICE.getType())) {
                  mapObject.put("wageQuotaType", "元/" + UnitsPrecisionEnum.EG_T.getName());
                  mapObject.put("unitPrice", detail.getUnitPrice().multiply(UnitsPrecisionEnum.EG_T.getRate()));
                  mapObject.put("unitPriceExcludingVat", detail.getUnitPriceExcludingVat().multiply(UnitsPrecisionEnum.EG_T.getRate()));
               } else if (detail.getWageQuotaType().equals(WmsWageQuotaTypeEnum.WMS_LENGTH_PRICE.getType())) {
                  mapObject.put("wageQuotaType", "元/" + UnitsPrecisionEnum.LG_M.getName());
                  mapObject.put("unitPrice", detail.getUnitPrice().multiply(UnitsPrecisionEnum.LG_M.getRate()));
                  mapObject.put("unitPriceExcludingVat", detail.getUnitPriceExcludingVat().multiply(UnitsPrecisionEnum.LG_M.getRate()));
               } else if (detail.getWageQuotaType().equals(WmsWageQuotaTypeEnum.WMS_AREA_PRICE.getType())) {
                  mapObject.put("wageQuotaType", "元/" + UnitsPrecisionEnum.AG_M.getName());
                  mapObject.put("unitPrice", detail.getUnitPrice().multiply(UnitsPrecisionEnum.AG_M.getRate()));
                  mapObject.put("unitPriceExcludingVat", detail.getUnitPriceExcludingVat().multiply(UnitsPrecisionEnum.AG_M.getRate()));
               } else if (detail.getWageQuotaType().equals(WmsWageQuotaTypeEnum.WMS_QUANTITY_PRICE.getType())) {
                  mapObject.put("wageQuotaType", "元/数量");
                  mapObject.put("unitPrice", detail.getUnitPrice());
                  mapObject.put("unitPriceExcludingVat", detail.getUnitPriceExcludingVat());
               } else {
                  mapObject.put("wageQuotaType", "-");
                  mapObject.put("unitPrice", detail.getUnitPrice());
                  mapObject.put("unitPriceExcludingVat", detail.getUnitPriceExcludingVat());
               }

               mapObject.put("amount", detail.getAmount());
               mapObject.put("amountExcludingVat", detail.getAmountExcludingVat());
               mapObject.put("taxRate", detail.getTaxRate());
               if (ObjectUtil.isNotEmpty(detail.getProjectId())) {
                  ContractProject contractProject = projectMap.get(detail.getProjectId());
                  mapObject.put("projectNumber", contractProject.getSerialNumber());
                  mapObject.put("projectName", contractProject.getShortName());
               }

               if (ObjectUtil.isNotEmpty(detail.getMonomerId())) {
                  PlanMonomer monomer = planMonomerMap.get(detail.getMonomerId());
                  mapObject.put("monomerName", monomer.getName());
               }

               if (ObjectUtil.isNotEmpty(detail.getAreaId())) {
                  PlanArea area = planAreaMap.get(detail.getAreaId());
                  mapObject.put("areaName", area.getName());
               }

               mapObject.put("serialNumber", outboundManufactured.getSerialNumber());
               mapObject.put("remark", detail.getBrand());
               mapList.add(mapObject);
            }
         }

         map.put("mapList", mapList);
      } else {
         message = "请选择下载的时间范围";
      }

      this.download(response, message, map, 25);
   }

   @Override
   public void returnManufacturedDownload(QueryReturnManufacturedDTOParam param, HttpServletResponse response) {
      String message = null;
      HashMap<String, Object> map = new HashMap<>(16);
      if (CollectionUtil.isNotEmpty(param.getReviewPassTime())) {
         String a = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(param.getReviewPassTime().get(0));
         String b = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(param.getReviewPassTime().get(1));
         map.put("returnData", a + "~" + b);
         List<ReturnDetailManufactured> returnDetailManufactureds = this.returnDetailManufacturedService.selectList(param);
         List<Map<String, Object>> mapList = new ArrayList<>();
         if (CollectionUtil.isNotEmpty(returnDetailManufactureds)) {
            Set<Long> returnManufacturedIds = new TreeSet<>();
            Set<Long> projectIds = new TreeSet<>();
            Set<Long> monomerIds = new TreeSet<>();
            Set<Long> areaIds = new TreeSet<>();

            for (ReturnDetailManufactured returnDetailManufactured : returnDetailManufactureds) {
               if (ObjectUtil.isNotEmpty(returnDetailManufactured.getReturnManufacturedId())) {
                  returnManufacturedIds.add(returnDetailManufactured.getReturnManufacturedId());
               }

               if (ObjectUtil.isNotEmpty(returnDetailManufactured.getProjectId())) {
                  projectIds.add(returnDetailManufactured.getProjectId());
               }

               if (ObjectUtil.isNotEmpty(returnDetailManufactured.getMonomerId())) {
                  monomerIds.add(returnDetailManufactured.getMonomerId());
               }

               if (ObjectUtil.isNotEmpty(returnDetailManufactured.getAreaId())) {
                  areaIds.add(returnDetailManufactured.getAreaId());
               }
            }

            Map<Long, ReturnManufactured> returnManufacturedMap = this.queryUtil.getReturnManufacturedMapByIds(returnManufacturedIds);
            Map<Long, ContractProject> projectMap = this.queryUtil.getProjectMapByIds(projectIds);
            Map<Long, PlanMonomer> planMonomerMap = this.queryUtil.getMonomerMapByIds(monomerIds);
            Map<Long, PlanArea> planAreaMap = this.queryUtil.getAreaMapByIds(areaIds);

            for (int i = 0; i < returnDetailManufactureds.size(); i++) {
               Map<String, Object> mapObject = new HashMap<>();
               ReturnDetailManufactured detail = returnDetailManufactureds.get(i);
               ReturnManufactured returnManufactured = returnManufacturedMap.get(detail.getReturnManufacturedId());
               mapObject.put("id", i + 1);
               mapObject.put("data", DateTimeFormatter.ofPattern("yyyy/MM/dd").format(returnManufactured.getReviewPassTime()));
               mapObject.put("basicClass", BasicClassEnum.getNameByType(detail.getBasicClass()));
               mapObject.put("manufacturedName", detail.getManufacturedName());
               mapObject.put("manufacturedSn", detail.getManufacturedSn());
               mapObject.put("spec", detail.getSpecification());
               mapObject.put("brand", detail.getBrand());
               mapObject.put("material", detail.getMaterial());
               mapObject.put("quantity", detail.getQuantity());
               mapObject.put("weight", "-");
               if (ObjectUtil.isNotEmpty(detail.getWeight())) {
                  mapObject.put("weight", detail.getWeight().divide(UnitsPrecisionEnum.EG_KG.getRate(), 4, RoundingMode.CEILING));
               }

               mapObject.put("length", "-");
               if (ObjectUtil.isNotEmpty(detail.getLength())) {
                  mapObject.put("length", detail.getLength().divide(UnitsPrecisionEnum.LG_M.getRate(), 4, RoundingMode.CEILING));
               }

               mapObject.put("surfaceArea", "-");
               if (ObjectUtil.isNotEmpty(detail.getSurfaceArea())) {
                  mapObject.put("surfaceArea", detail.getSurfaceArea().divide(UnitsPrecisionEnum.AG_M.getRate(), 4, RoundingMode.CEILING));
               }

               mapObject.put("totalWeight", "-");
               if (ObjectUtil.isNotEmpty(detail.getTotalWeight())) {
                  mapObject.put("totalWeight", detail.getTotalWeight().divide(UnitsPrecisionEnum.EG_KG.getRate(), 4, RoundingMode.CEILING));
               }

               mapObject.put("totalLength", "-");
               if (ObjectUtil.isNotEmpty(detail.getTotalLength())) {
                  mapObject.put("totalLength", detail.getTotalLength().divide(UnitsPrecisionEnum.LG_M.getRate(), 4, RoundingMode.CEILING));
               }

               mapObject.put("totalArea", "-");
               if (ObjectUtil.isNotEmpty(detail.getTotalArea())) {
                  mapObject.put("totalArea", detail.getTotalArea().divide(UnitsPrecisionEnum.AG_M.getRate(), 4, RoundingMode.CEILING));
               }

               if (detail.getWageQuotaType().equals(WmsWageQuotaTypeEnum.WMS_WEIGHT_PRICE.getType())) {
                  mapObject.put("wageQuotaType", "元/" + UnitsPrecisionEnum.EG_T.getName());
                  mapObject.put("unitPrice", detail.getUnitPrice().multiply(UnitsPrecisionEnum.EG_T.getRate()));
                  mapObject.put("unitPriceExcludingVat", detail.getUnitPriceExcludingVat().multiply(UnitsPrecisionEnum.EG_T.getRate()));
               } else if (detail.getWageQuotaType().equals(WmsWageQuotaTypeEnum.WMS_LENGTH_PRICE.getType())) {
                  mapObject.put("wageQuotaType", "元/" + UnitsPrecisionEnum.LG_M.getName());
                  mapObject.put("unitPrice", detail.getUnitPrice().multiply(UnitsPrecisionEnum.LG_M.getRate()));
                  mapObject.put("unitPriceExcludingVat", detail.getUnitPriceExcludingVat().multiply(UnitsPrecisionEnum.LG_M.getRate()));
               } else if (detail.getWageQuotaType().equals(WmsWageQuotaTypeEnum.WMS_AREA_PRICE.getType())) {
                  mapObject.put("wageQuotaType", "元/" + UnitsPrecisionEnum.AG_M.getName());
                  mapObject.put("unitPrice", detail.getUnitPrice().multiply(UnitsPrecisionEnum.AG_M.getRate()));
                  mapObject.put("unitPriceExcludingVat", detail.getUnitPriceExcludingVat().multiply(UnitsPrecisionEnum.AG_M.getRate()));
               } else if (detail.getWageQuotaType().equals(WmsWageQuotaTypeEnum.WMS_QUANTITY_PRICE.getType())) {
                  mapObject.put("wageQuotaType", "元/数量");
                  mapObject.put("unitPrice", detail.getUnitPrice());
                  mapObject.put("unitPriceExcludingVat", detail.getUnitPriceExcludingVat());
               } else {
                  mapObject.put("wageQuotaType", "-");
                  mapObject.put("unitPrice", detail.getUnitPrice());
                  mapObject.put("unitPriceExcludingVat", detail.getUnitPriceExcludingVat());
               }

               mapObject.put("amount", detail.getAmount());
               mapObject.put("amountExcludingVat", detail.getAmountExcludingVat());
               mapObject.put("taxRate", detail.getTaxRate());
               if (ObjectUtil.isNotEmpty(detail.getProjectId())) {
                  ContractProject contractProject = projectMap.get(detail.getProjectId());
                  mapObject.put("projectNumber", contractProject.getSerialNumber());
                  mapObject.put("projectName", contractProject.getShortName());
               }

               if (ObjectUtil.isNotEmpty(detail.getMonomerId())) {
                  PlanMonomer monomer = planMonomerMap.get(detail.getMonomerId());
                  mapObject.put("monomerName", monomer.getName());
               }

               if (ObjectUtil.isNotEmpty(detail.getAreaId())) {
                  PlanArea area = planAreaMap.get(detail.getAreaId());
                  mapObject.put("areaName", area.getName());
               }

               mapObject.put("serialNumber", returnManufactured.getSerialNumber());
               mapObject.put("remark", detail.getBrand());
               mapList.add(mapObject);
            }
         }

         map.put("mapList", mapList);
      } else {
         message = "请选择下载的时间范围";
      }

      this.download(response, message, map, 26);
   }

   @Override
   public void inboundTemplateExcel(Boolean boolPartyA, Integer basicClass, HttpServletResponse response) {
      Integer type = null;
      if (BasicClassEnum.STEEL_PLATE.getType().equals(basicClass)) {
         type = boolPartyA ? ExcelEnum.STEEL_PLATE_INBOUND_PARTY_A_EXCEL.getType() : ExcelEnum.STEEL_PLATE_INBOUND_SELF_BUYING_EXCEL.getType();
      }

      if (BasicClassEnum.SECTION_STEEL.getType().equals(basicClass)) {
         type = boolPartyA ? ExcelEnum.SECTION_STEEL_INBOUND_PARTY_A_EXCEL.getType() : ExcelEnum.SECTION_STEEL_INBOUND_SELF_BUYING_EXCEL.getType();
      }

      if (BasicClassEnum.COLOR_ROLL.getType().equals(basicClass)) {
         type = boolPartyA ? ExcelEnum.COLOR_ROLL_INBOUND_PARTY_A_EXCEL.getType() : ExcelEnum.COLOR_ROLL_INBOUND_SELF_BUYING_EXCEL.getType();
      }

      if (BasicClassEnum.GENERAL_MATERIAL.getType().equals(basicClass)) {
         type = boolPartyA ? ExcelEnum.GENERAL_MATERIAL_INBOUND_PARTY_A_EXCEL.getType() : ExcelEnum.GENERAL_MATERIAL_INBOUND_SELF_BUYING_EXCEL.getType();
      }

      if (BasicClassEnum.GAS.getType().equals(basicClass)) {
         type = boolPartyA ? ExcelEnum.GAS_INBOUND_PARTY_A_EXCEL.getType() : ExcelEnum.GAS_INBOUND_SELF_BUYING_EXCEL.getType();
      }

      if (BasicClassEnum.OTHER.getType().equals(basicClass)) {
         type = boolPartyA ? ExcelEnum.OTHER_INBOUND_PARTY_A_EXCEL.getType() : ExcelEnum.OTHER_INBOUND_SELF_BUYING_EXCEL.getType();
      }

      if (BasicClassEnum.OTHER_STEEL_MATERIALS.getType().equals(basicClass)) {
         type = boolPartyA
            ? ExcelEnum.OTHER_STEEL_MATERIALS_INBOUND_PARTY_A_EXCEL.getType()
            : ExcelEnum.OTHER_STEEL_MATERIALS_INBOUND_SELF_BUYING_EXCEL.getType();
      }

      if (type != null) {
         this.downloadV2(response, null, new HashMap<>(), type);
         String a = "files/templateV2";
      } else {
         throw new IllegalArgumentException("参数异常");
      }
   }

   @Override
   public void beginPeriodInboundTemplateExcel(Boolean boolPartyA, Integer basicClass, HttpServletResponse response) {
      Integer type = null;
      if (BasicClassEnum.STEEL_PLATE.getType().equals(basicClass)) {
         type = boolPartyA
            ? ExcelEnum.STEEL_PLATE_INBOUND_PARTY_A_BEGIN_TEMPLATE.getType()
            : ExcelEnum.STEEL_PLATE_INBOUND_SELF_BUYING_BEGIN_TEMPLATE.getType();
      }

      if (BasicClassEnum.SECTION_STEEL.getType().equals(basicClass)) {
         type = boolPartyA
            ? ExcelEnum.SECTION_STEEL_INBOUND_PARTY_A_BEGIN_TEMPLATE.getType()
            : ExcelEnum.SECTION_STEEL_INBOUND_SELF_BUYING_BEGIN_TEMPLATE.getType();
      }

      if (BasicClassEnum.COLOR_ROLL.getType().equals(basicClass)) {
         type = boolPartyA ? ExcelEnum.COLOR_ROLL_INBOUND_PARTY_A_BEGIN_TEMPLATE.getType() : ExcelEnum.COLOR_ROLL_INBOUND_SELF_BUYING_BEGIN_TEMPLATE.getType();
      }

      if (BasicClassEnum.GENERAL_MATERIAL.getType().equals(basicClass)) {
         type = boolPartyA
            ? ExcelEnum.GENERAL_MATERIAL_INBOUND_PARTY_A_BEGIN_TEMPLATE.getType()
            : ExcelEnum.GENERAL_MATERIAL_INBOUND_SELF_BUYING_BEGIN_TEMPLATE.getType();
      }

      if (BasicClassEnum.GAS.getType().equals(basicClass)) {
         type = boolPartyA ? ExcelEnum.GAS_INBOUND_PARTY_A_BEGIN_TEMPLATE.getType() : ExcelEnum.GAS_INBOUND_SELF_BUYING_BEGIN_TEMPLATE.getType();
      }

      if (BasicClassEnum.OTHER.getType().equals(basicClass)) {
         type = boolPartyA ? ExcelEnum.OTHER_INBOUND_PARTY_A_BEGIN_TEMPLATE.getType() : ExcelEnum.OTHER_INBOUND_SELF_BUYING_BEGIN_TEMPLATE.getType();
      }

      if (BasicClassEnum.OTHER_STEEL_MATERIALS.getType().equals(basicClass)) {
         type = boolPartyA
            ? ExcelEnum.OTHER_STEEL_MATERIALS_INBOUND_PARTY_A_BEGIN_TEMPLATE.getType()
            : ExcelEnum.OTHER_STEEL_MATERIALS_INBOUND_SELF_BUYING_BEGIN_TEMPLATE.getType();
      }

      if (type != null) {
         this.downloadV2(response, null, new HashMap<>(), type);
      } else {
         throw new IllegalArgumentException("参数异常");
      }
   }

   @Override
   public void surplusBatchDownload(QueryDownloadParam param, HttpServletResponse response) {
      List<WmsSurplus> surplusList = this.wmsSurplusService.listByIds(param.getIds());
      if (!CollectionUtil.isEmpty(surplusList)) {
         Preconditions.checkArgument(surplusList.size() == param.getIds().size(), "单据信息不存在！");
         if (surplusList.size() == 1) {
            this.getSurplusExcelFile(surplusList.get(0), response);
         } else {
            this.packageDownload(surplusList);
         }
      }
   }

   private void packageDownload(List<WmsSurplus> surplusList) {
      String baseUrl = this.configProperties.getFilePath() + File.separator + "surplusExcel" + File.separator + "baseFolder";
      FileUtil.mkdirs(baseUrl);

      for (int i = 0; i < surplusList.size(); i++) {
         this.getSurplusExcelFile(surplusList.get(i), baseUrl, i + 1);
      }

      String packageUrl = this.configProperties.getFilePath() + File.separator + "surplusExcel" + File.separator + "盘盈单据包.zip";

      try {
         ZipUtil.zip(baseUrl, packageUrl);
         FileUtil.downloadFile(packageUrl);
      } catch (Exception e1) {
         e1.printStackTrace();
      } finally {
         try {
            FileUtils.cleanDirectory(new File(baseUrl));
         } catch (IOException e) {
            e.printStackTrace();
         }

         FileUtil.deleteFile(packageUrl);
      }
   }

   @Override
   public void surplusDetailsDownload(QueryReportSurplusDTOParam param, HttpServletResponse response) {
      param.setClassifyIds(this.queryUtil.getLateClassificationList(param.getClassifyId()));
      List<WmsSurplusDetail> surplusDetailList = this.wmsSurplusService.getSurplusDetailList(param);
      String message = null;
      HashMap<String, Object> map = new HashMap<>(16);
      if (CollectionUtil.isNotEmpty(surplusDetailList)) {
         Map<Long, Warehouse> warehouseMap = this.queryUtil.getWarehouseMap(null);
         Map<Long, ContractProject> projectMap = this.queryUtil.getProjectMap(null);
         List<Map<String, Object>> mapList = new ArrayList<>();
         Map<Long, Classification> classificationMap = this.classificationService
            .list()
            .stream()
            .collect(Collectors.toMap(Classification::getId, Function.identity()));
         Map<Long, Measure> measureMap = this.measureMapper
            .selectList(new LambdaQueryWrapper<>())
            .stream()
            .collect(Collectors.toMap(Measure::getClassificationId, Function.identity()));
         Map<String, Unit> unitMap = this.unitMapper
            .selectList(new LambdaQueryWrapper<>())
            .stream()
            .collect(Collectors.toMap(Unit::getName, Function.identity()));

         for (int i = 0; i < surplusDetailList.size(); i++) {
            Map<String, Object> mapObject = new HashMap<>();
            WmsSurplusDetail surplusDetail = surplusDetailList.get(i);
            DownLoadDetailDO detailDO = BeanUtil.copy(surplusDetail, DownLoadDetailDO.class);
            detailDO.setUnitPriceExcludingVAT(surplusDetail.getUnitPriceExcludingVat());
            mapObject.put("id", i + 1);
            Map<String, String> classMap = this.setClassifyName(detailDO.getBasicClass(), detailDO.getClassifyId(), detailDO.getClassifyName());
            mapObject.put("basicClass", classMap.get("分类"));
            mapObject.put("classifyName", classMap.get("名称"));
            StringBuilder sb = new StringBuilder();
            StringBuilder lengths = new StringBuilder();
            StringBuilder material = new StringBuilder();
            this.setSpecs(detailDO, sb, lengths, material);
            mapObject.put("spec", sb);
            Measure measure = Measure.builder()
               .classificationId(surplusDetail.getClassifyId())
               .accountingUnit(surplusDetail.getAccountingUnit())
               .measureUnit(surplusDetail.getMeasureUnit())
               .accountingPrecision(surplusDetail.getAccountingPrecision())
               .measurePrecision(surplusDetail.getMeasurePrecision())
               .build();
            this.setAmountAndMeteV2(mapObject, detailDO, measure, classificationMap, measureMap, unitMap, null);
            mapObject.put("heatNoAndBatchNo", StrUtil.isNotBlank(detailDO.getHeatNoAndBatchNo()) ? detailDO.getHeatNoAndBatchNo() : "-");
            mapObject.put("inboundTime", DateTimeFormatter.ofPattern("yyyy/MM/dd").format(surplusDetail.getInboundTime()));
            mapObject.put("inputVat", surplusDetail.getInputVat());
            mapObject.put("material", StrUtil.isNotBlank(material) ? material : "-");
            mapObject.put("serialNumber", surplusDetail.getSurplusSerialNumber());
            mapObject.put("materialSn", surplusDetail.getSerialNumber());
            mapObject.put("lengths", lengths.toString());
            mapObject.put("brand", StrUtil.isNotBlank(surplusDetail.getBrand()) ? surplusDetail.getBrand() : "-");
            mapObject.put("invoiceType", InvoiceTypeEnum.getValueByType(surplusDetail.getInvoiceType()));
            mapObject.put("taxRate", surplusDetail.getTaxRate() != null ? surplusDetail.getTaxRate() : "-");
            mapObject.put("surplusSerialNumber", surplusDetail.getSurplusSerialNumber());
            mapObject.put("remark", surplusDetail.getRemark() != null ? surplusDetail.getRemark() : "-");
            mapObject.put("project", "-");
            mapObject.put("projectNumber", "-");
            mapObject.put("warehouseName", "-");
            if (surplusDetail.getWarehouseId() != null) {
               Warehouse warehouse = warehouseMap.get(surplusDetail.getWarehouseId());
               mapObject.put("warehouseName", warehouse.getName());
            }

            if (surplusDetail.getProjectId() != null) {
               ContractProject project = projectMap.get(surplusDetail.getProjectId());
               mapObject.put("project", project.getName());
               mapObject.put("projectNumber", project.getSerialNumber());
            }

            mapList.add(mapObject);
         }

         map.put("mapList", mapList);
      }

      String resourcePath = "files/templateV2/wmsSurplusDetail.xlsx";
      String tempFileName = "wmsSurplusDetail";
      String exportFileName = "盘盈单详情.xlsx";
      String s = "";
      BasicConfig basicInbound = this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "报表下载配置"));
      Preconditions.checkArgument(basicInbound != null, "请配置下载金额是否显示");
      ReportDownload reportDownload = JSON.parseObject(basicInbound.getValue(), ReportDownload.class);
      if (reportDownload.getAmountShow().equals(0) && reportDownload.getAmountExcludingTAXShow().equals(0)) {
         s = "-1";
      } else if (reportDownload.getAmountShow().equals(0)) {
         s = "-2";
      } else if (reportDownload.getAmountExcludingTAXShow().equals(0)) {
         s = "-3";
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
      PoiUtils.wmsDownLoadExcel(exportFileName, response, workbook, message);
   }

   private void getSurplusExcelFile(WmsSurplus surplus, String baseUrl, int index) {
      List<WmsSurplusDetail> list = this.surplusDetailService
         .list(Wrappers.lambdaQuery(WmsSurplusDetail.class).eq(WmsSurplusDetail::getSurplusId, surplus.getId()));
      HashMap<String, Object> map = new HashMap<>(16);
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
      map.put("checkData", surplus.getReviewTime() != null ? formatter.format(surplus.getReviewTime()) : "-");
      map.put("serialNumber", surplus.getSerialNumber());
      map.put("basicClass", BasicClassEnum.getNameStr(surplus.getBasicClass()));
      map.put("project", "-");
      if (StrUtil.isNotBlank(surplus.getProjectIds())) {
         String[] split = surplus.getProjectIds().split(",");
         List<Long> projectIds = Arrays.stream(split).map(Long::valueOf).collect(Collectors.toList());
         if (CollectionUtil.isNotEmpty(projectIds)) {
            StringBuilder projectName = new StringBuilder();

            for (ProjectInfo project : this.projectService.getSimpleByIds(projectIds)) {
               if (StrUtil.isBlank(projectName.toString())) {
                  projectName.append(project.getShortName());
               } else {
                  projectName.append(",");
                  projectName.append(project.getShortName());
               }
            }

            map.put("project", projectName.toString());
         }
      }

      map.put("applicantName", surplus.getApplicantName());
      Map<Long, Warehouse> warehouseMap = this.queryUtil.getWarehouseMap(null);
      Map<Long, ContractProject> projectMap = this.queryUtil.getProjectMap(null);
      List<Map<String, Object>> mapList = new ArrayList<>();
      Map<Long, Classification> classificationMap = this.classificationService
         .list()
         .stream()
         .collect(Collectors.toMap(Classification::getId, Function.identity()));
      Map<Long, Measure> measureMap = this.measureMapper
         .selectList(new LambdaQueryWrapper<>())
         .stream()
         .collect(Collectors.toMap(Measure::getClassificationId, Function.identity()));
      Map<String, Unit> unitMap = this.unitMapper.selectList(new LambdaQueryWrapper<>()).stream().collect(Collectors.toMap(Unit::getName, Function.identity()));

      for (int i = 0; i < list.size(); i++) {
         Map<String, Object> mapObject = new HashMap<>();
         WmsSurplusDetail surplusDetail = list.get(i);
         DownLoadDetailDO detailDO = BeanUtil.copy(surplusDetail, DownLoadDetailDO.class);
         detailDO.setUnitPriceExcludingVAT(surplusDetail.getUnitPriceExcludingVat());
         mapObject.put("id", i + 1);
         Map<String, String> classMap = this.setClassifyName(detailDO.getBasicClass(), detailDO.getClassifyId(), detailDO.getClassifyName());
         mapObject.put("basicClass", classMap.get("分类"));
         mapObject.put("classifyName", classMap.get("名称"));
         StringBuilder sb = new StringBuilder();
         StringBuilder lengths = new StringBuilder();
         StringBuilder material = new StringBuilder();
         this.setSpecs(detailDO, sb, lengths, material);
         mapObject.put("spec", sb);
         Measure measure = Measure.builder()
            .classificationId(surplusDetail.getClassifyId())
            .accountingUnit(surplusDetail.getAccountingUnit())
            .measureUnit(surplusDetail.getMeasureUnit())
            .accountingPrecision(surplusDetail.getAccountingPrecision())
            .measurePrecision(surplusDetail.getMeasurePrecision())
            .build();
         this.setAmountAndMeteV2(mapObject, detailDO, measure, classificationMap, measureMap, unitMap, null);
         mapObject.put("heatNoAndBatchNo", StrUtil.isNotBlank(detailDO.getHeatNoAndBatchNo()) ? detailDO.getHeatNoAndBatchNo() : "-");
         mapObject.put("inboundTime", surplusDetail.getInboundTime() != null ? formatter.format(surplusDetail.getInboundTime()) : "-");
         mapObject.put("inputVat", surplusDetail.getInputVat());
         mapObject.put("material", StrUtil.isNotBlank(material) ? material : "-");
         mapObject.put("serialNumber", surplusDetail.getSurplusSerialNumber());
         mapObject.put("materialSn", surplusDetail.getSerialNumber());
         mapObject.put("lengths", lengths.toString());
         mapObject.put("brand", StrUtil.isNotBlank(surplusDetail.getBrand()) ? surplusDetail.getBrand() : "-");
         mapObject.put("invoiceType", InvoiceTypeEnum.getValueByType(surplusDetail.getInvoiceType()));
         mapObject.put("taxRate", surplusDetail.getTaxRate() != null ? surplusDetail.getTaxRate() : "-");
         mapObject.put("remark", surplusDetail.getRemark() != null ? surplusDetail.getRemark() : "-");
         mapObject.put("project", "-");
         mapObject.put("projectNumber", "-");
         mapObject.put("warehouseName", "-");
         if (surplusDetail.getWarehouseId() != null) {
            Warehouse warehouse = warehouseMap.get(surplusDetail.getWarehouseId());
            mapObject.put("warehouseName", warehouse.getName());
         }

         if (surplusDetail.getProjectId() != null) {
            ContractProject project = projectMap.get(surplusDetail.getProjectId());
            mapObject.put("project", project.getName());
            mapObject.put("projectNumber", project.getSerialNumber());
         }

         mapList.add(mapObject);
      }

      map.put("mapList", mapList);
      String resourcePath = ExcelEnum.SURPLUS_EXCEL.getResourcePath() + ".xlsx";
      String tempFileName = ExcelEnum.SURPLUS_EXCEL.getTempFileName();
      String exportFileName = File.separator + index + "_" + surplus.getSerialNumber() + ExcelEnum.SURPLUS_EXCEL.getExportFileName();
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
      File excel = new File(baseUrl + exportFileName + ".xlsx");

      try {
         FileOutputStream outputStream = new FileOutputStream(excel);
         workbook.write(outputStream);
         outputStream.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   private void getSurplusExcelFile(WmsSurplus surplus, HttpServletResponse response) {
      List<WmsSurplusDetail> list = this.surplusDetailService
         .list(Wrappers.lambdaQuery(WmsSurplusDetail.class).eq(WmsSurplusDetail::getSurplusId, surplus.getId()));
      HashMap<String, Object> map = new HashMap<>(16);
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
      map.put("checkData", surplus.getReviewTime() != null ? formatter.format(surplus.getReviewTime()) : "-");
      map.put("serialNumber", surplus.getSerialNumber());
      map.put("basicClass", BasicClassEnum.getNameStr(surplus.getBasicClass()));
      map.put("project", "-");
      if (StrUtil.isNotBlank(surplus.getProjectIds())) {
         String[] split = surplus.getProjectIds().split(",");
         List<Long> projectIds = Arrays.stream(split).map(Long::valueOf).collect(Collectors.toList());
         if (CollectionUtil.isNotEmpty(projectIds)) {
            StringBuilder projectName = new StringBuilder();

            for (ProjectInfo project : this.projectService.getSimpleByIds(projectIds)) {
               if (StrUtil.isBlank(projectName.toString())) {
                  projectName.append(project.getShortName());
               } else {
                  projectName.append(",");
                  projectName.append(project.getShortName());
               }
            }

            map.put("project", projectName.toString());
         }
      }

      map.put("applicantName", surplus.getApplicantName());
      Map<Long, Warehouse> warehouseMap = this.queryUtil.getWarehouseMap(null);
      Map<Long, ContractProject> projectMap = this.queryUtil.getProjectMap(null);
      List<Map<String, Object>> mapList = new ArrayList<>();
      Map<Long, Classification> classificationMap = this.classificationService
         .list()
         .stream()
         .collect(Collectors.toMap(Classification::getId, Function.identity()));
      Map<Long, Measure> measureMap = this.measureMapper
         .selectList(new LambdaQueryWrapper<>())
         .stream()
         .collect(Collectors.toMap(Measure::getClassificationId, Function.identity()));
      Map<String, Unit> unitMap = this.unitMapper.selectList(new LambdaQueryWrapper<>()).stream().collect(Collectors.toMap(Unit::getName, Function.identity()));

      for (int i = 0; i < list.size(); i++) {
         Map<String, Object> mapObject = new HashMap<>();
         WmsSurplusDetail surplusDetail = list.get(i);
         DownLoadDetailDO detailDO = BeanUtil.copy(surplusDetail, DownLoadDetailDO.class);
         detailDO.setUnitPriceExcludingVAT(surplusDetail.getUnitPriceExcludingVat());
         mapObject.put("id", i + 1);
         Map<String, String> classMap = this.setClassifyName(detailDO.getBasicClass(), detailDO.getClassifyId(), detailDO.getClassifyName());
         mapObject.put("basicClass", classMap.get("分类"));
         mapObject.put("classifyName", classMap.get("名称"));
         StringBuilder sb = new StringBuilder();
         StringBuilder lengths = new StringBuilder();
         StringBuilder material = new StringBuilder();
         this.setSpecs(detailDO, sb, lengths, material);
         mapObject.put("spec", sb);
         Measure measure = Measure.builder()
            .classificationId(surplusDetail.getClassifyId())
            .accountingUnit(surplusDetail.getAccountingUnit())
            .measureUnit(surplusDetail.getMeasureUnit())
            .accountingPrecision(surplusDetail.getAccountingPrecision())
            .measurePrecision(surplusDetail.getMeasurePrecision())
            .build();
         this.setAmountAndMeteV2(mapObject, detailDO, measure, classificationMap, measureMap, unitMap, null);
         mapObject.put("heatNoAndBatchNo", StrUtil.isNotBlank(detailDO.getHeatNoAndBatchNo()) ? detailDO.getHeatNoAndBatchNo() : "-");
         mapObject.put("inboundTime", surplusDetail.getInboundTime() != null ? formatter.format(surplusDetail.getInboundTime()) : "-");
         mapObject.put("inputVat", surplusDetail.getInputVat());
         mapObject.put("material", StrUtil.isNotBlank(material) ? material : "-");
         mapObject.put("serialNumber", surplusDetail.getSurplusSerialNumber());
         mapObject.put("materialSn", surplusDetail.getSerialNumber());
         mapObject.put("lengths", lengths.toString());
         mapObject.put("brand", StrUtil.isNotBlank(surplusDetail.getBrand()) ? surplusDetail.getBrand() : "-");
         mapObject.put("invoiceType", InvoiceTypeEnum.getValueByType(surplusDetail.getInvoiceType()));
         mapObject.put("taxRate", surplusDetail.getTaxRate() != null ? surplusDetail.getTaxRate() : "-");
         mapObject.put("remark", surplusDetail.getRemark() != null ? surplusDetail.getRemark() : "-");
         mapObject.put("project", "-");
         mapObject.put("projectNumber", "-");
         mapObject.put("warehouseName", "-");
         if (surplusDetail.getWarehouseId() != null) {
            Warehouse warehouse = warehouseMap.get(surplusDetail.getWarehouseId());
            mapObject.put("warehouseName", warehouse.getName());
         }

         if (surplusDetail.getProjectId() != null) {
            ContractProject project = projectMap.get(surplusDetail.getProjectId());
            mapObject.put("project", project.getName());
            mapObject.put("projectNumber", project.getSerialNumber());
         }

         mapList.add(mapObject);
      }

      map.put("mapList", mapList);
      String resourcePath = ExcelEnum.SURPLUS_EXCEL.getResourcePath() + ".xlsx";
      String tempFileName = ExcelEnum.SURPLUS_EXCEL.getTempFileName();
      String exportFileName = ExcelEnum.SURPLUS_EXCEL.getExportFileName() + ".xlsx";
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
   public void inventoryStatisticsDownload(QueryInventoryUseStatisticsDTOParam param, HttpServletResponse response) {
      String message = null;
      HashMap<String, Object> map = new HashMap<>(16);
      InventoryUseStatisticsDate inventoryUseStatisticsDate = this.inventoryUseStatisticsDateService.getById(param.getStatisticsDateId());
      DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      LocalDateTime startTime = inventoryUseStatisticsDate.getStartTime();
      String startTimeStr = "";
      if (ObjectUtil.isNotEmpty(startTime)) {
         startTimeStr = dateTimeFormatter.format(startTime);
      }

      LocalDateTime endTime = inventoryUseStatisticsDate.getEndTime();
      String endTimeStr = "";
      if (ObjectUtil.isNotEmpty(endTime)) {
         endTimeStr = dateTimeFormatter.format(endTime);
      }

      map.put("date", startTimeStr + "~" + endTimeStr);
      List<Map<String, Object>> mapList = new ArrayList<>();
      List<InventoryUseStatistics> list = this.inventoryUseStatisticsMapper.getInventoryUseStatistics(param);
      List<Long> projectIds = new ArrayList<>();
      List<Long> classifyIds = new ArrayList<>();
      List<Long> statisticsIds = new ArrayList<>();
      List<Long> workshopIds = new ArrayList<>();
      List<Long> warehouseIds = new ArrayList<>();

      for (InventoryUseStatistics inventoryUseStatistics : list) {
         statisticsIds.add(inventoryUseStatistics.getId());
         if (ObjectUtil.isNotEmpty(inventoryUseStatistics.getProjectId())) {
            projectIds.add(inventoryUseStatistics.getProjectId());
         }

         if (ObjectUtil.isNotEmpty(inventoryUseStatistics.getClassifyId())) {
            classifyIds.add(inventoryUseStatistics.getClassifyId());
         }

         if (ObjectUtil.isNotEmpty(inventoryUseStatistics.getWorkshopId())) {
            workshopIds.add(inventoryUseStatistics.getWorkshopId());
         }

         if (ObjectUtil.isNotEmpty(inventoryUseStatistics.getWarehouseId())) {
            warehouseIds.add(inventoryUseStatistics.getWarehouseId());
         }
      }

      Map<Long, ContractProject> projectMap = this.queryUtil.getProjectMapByIds(projectIds);
      Map<Long, Classification> classificationMap = this.queryUtil.getClassificationMapByIds(classifyIds);
      Map<String, Unit> unitMap = this.unitMapper.selectList(null).stream().collect(Collectors.toMap(Unit::getName, Function.identity()));
      Map<Long, Measure> measureMap = this.queryUtil.getMeasureMapByClassifyIds(classifyIds);
      Map<Long, Workshop> workshopMap = this.queryUtil.getWorkshopMapByIds(workshopIds);
      Map<Long, Warehouse> warehouseMap = this.queryUtil.getWarehouseMapByIds(warehouseIds);
      List<InventoryUseRecord> inventoryUseRecords = new ArrayList<>();
      if (!inventoryUseStatisticsDate.getBoolBalance()) {
         inventoryUseRecords = this.inventoryUseRecordService
            .list((Wrapper<InventoryUseRecord>)new LambdaQueryWrapper<InventoryUseRecord>().in(InventoryUseRecord::getInventoryUseStatisticsId, statisticsIds));
      }

      Map<String, WmsMaterialCodeConfig> materialCodeConfigMaps = this.queryUtil.getMaterialCodeConfigMaps(null);

      for (int i = 0; i < list.size(); i++) {
         Map<String, Object> mapObject = new HashMap<>();
         InventoryUseStatistics inventoryUseStatistics = list.get(i);
         mapObject.put("id", i + 1);
         mapObject.put("classSerialNumber", inventoryUseStatistics.getSerialNumber());
         Map<String, String> classMap = this.setClassifyName(
            inventoryUseStatistics.getBasicClass(), inventoryUseStatistics.getClassifyId(), inventoryUseStatistics.getClassifyName()
         );
         mapObject.put("basicClass", classMap.get("分类"));
         mapObject.put("classifyName", classMap.get("名称"));
         StringBuilder spec = new StringBuilder();
         if (BasicClassEnum.STEEL_PLATE.getType().equals(inventoryUseStatistics.getBasicClass())) {
            spec.append(inventoryUseStatistics.getThickness().stripTrailingZeros().toPlainString());
            if (inventoryUseStatistics.getWidth() != null) {
               spec.append("*").append(inventoryUseStatistics.getWidth().stripTrailingZeros().toPlainString());
            }

            if (inventoryUseStatistics.getLength() != null) {
               spec.append("*").append(inventoryUseStatistics.getLength().stripTrailingZeros().toPlainString());
            }

            if (inventoryUseStatistics.getSpecification() != null) {
               spec.append(" * ").append(inventoryUseStatistics.getSpecification());
            }
         } else if (BasicClassEnum.COLOR_ROLL.getType().equals(inventoryUseStatistics.getBasicClass())) {
            spec.append(inventoryUseStatistics.getThickness().stripTrailingZeros().toPlainString());
            if (inventoryUseStatistics.getWidth() != null) {
               spec.append("*").append(inventoryUseStatistics.getWidth().stripTrailingZeros().toPlainString());
            }

            if (inventoryUseStatistics.getSpecification() != null) {
               spec.append(" * ").append(inventoryUseStatistics.getSpecification());
            }
         } else if (BasicClassEnum.SECTION_STEEL.getType().equals(inventoryUseStatistics.getBasicClass())
            || BasicClassEnum.checkNotSteel(inventoryUseStatistics.getBasicClass())) {
            if (inventoryUseStatistics.getLength() != null) {
               spec.append(inventoryUseStatistics.getLength().stripTrailingZeros().toPlainString());
            }

            if (spec.length() > 0) {
               spec.append(" * ");
            }

            if (inventoryUseStatistics.getSpecification() != null) {
               spec.append(inventoryUseStatistics.getSpecification());
            }
         }

         mapObject.put("specification", spec);
         mapObject.put("brand", StrUtil.isNotBlank(inventoryUseStatistics.getBrand()) ? inventoryUseStatistics.getBrand() : "-");
         if (inventoryUseStatistics.getProjectId() != null) {
            mapObject.put("projectName", projectMap.get(inventoryUseStatistics.getProjectId()).getShortName());
         }

         String s1 = this.queryUtil
            .buildCompositeKey(inventoryUseStatistics.getClassifyId(), inventoryUseStatistics.getSpecification(), inventoryUseStatistics.getThickness());
         WmsMaterialCodeConfig wmsMaterialCodeConfig = materialCodeConfigMaps.get(s1);
         mapObject.put("materialSnNew", ObjectUtil.isNotEmpty(wmsMaterialCodeConfig) ? wmsMaterialCodeConfig.getMaterialSnNew() : "");
         mapObject.put(
            "warehouseName",
            workshopMap.get(inventoryUseStatistics.getWorkshopId()).getName() + "-" + warehouseMap.get(inventoryUseStatistics.getWarehouseId()).getName()
         );
         Measure measure = measureMap.get(inventoryUseStatistics.getClassifyId());
         BigDecimal beginStageTotalQuantity = inventoryUseStatistics.getBeginStageTotalQuantity();
         BigDecimal beginStageTotalMete = inventoryUseStatistics.getBeginStageTotalMete();
         BigDecimal inboundQuantity = BigDecimal.ZERO;
         BigDecimal inboundMete = BigDecimal.ZERO;
         BigDecimal transferQuantity = BigDecimal.ZERO;
         BigDecimal transferMete = BigDecimal.ZERO;
         BigDecimal outboundQuantity = BigDecimal.ZERO;
         BigDecimal outboundMete = BigDecimal.ZERO;
         BigDecimal endQuantity = BigDecimal.ZERO;
         BigDecimal endMete = BigDecimal.ZERO;
         if (!inventoryUseStatisticsDate.getBoolBalance()) {
            List<InventoryUseRecord> inventoryUseRecordList = inventoryUseRecords.stream()
               .filter(inventoryUseRecord -> inventoryUseRecord.getInventoryUseStatisticsId().equals(inventoryUseStatistics.getId()))
               .collect(Collectors.toList());
            List<InventoryUseRecord> inboundInventoryUseRecordList = inventoryUseRecordList.stream()
               .filter(inventoryUseRecord -> inventoryUseRecord.getEmbodyType().equals(1))
               .collect(Collectors.toList());
            inboundQuantity = inboundInventoryUseRecordList.stream()
               .map(InventoryUseRecord::getQuantity)
               .filter(ObjectUtil::isNotEmpty)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            inboundMete = inboundInventoryUseRecordList.stream()
               .map(InventoryUseRecord::getMete)
               .filter(ObjectUtil::isNotEmpty)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            List<InventoryUseRecord> transferInventoryUseRecordList = inventoryUseRecordList.stream()
               .filter(inventoryUseRecord -> inventoryUseRecord.getEmbodyType().equals(3))
               .collect(Collectors.toList());
            transferQuantity = transferInventoryUseRecordList.stream()
               .map(InventoryUseRecord::getQuantity)
               .filter(ObjectUtil::isNotEmpty)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            transferMete = transferInventoryUseRecordList.stream()
               .map(InventoryUseRecord::getMete)
               .filter(ObjectUtil::isNotEmpty)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            List<InventoryUseRecord> outboundInventoryUseRecordList = inventoryUseRecordList.stream()
               .filter(inventoryUseRecord -> inventoryUseRecord.getEmbodyType().equals(2))
               .collect(Collectors.toList());
            outboundQuantity = outboundInventoryUseRecordList.stream()
               .map(InventoryUseRecord::getQuantity)
               .filter(ObjectUtil::isNotEmpty)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            outboundMete = outboundInventoryUseRecordList.stream()
               .map(InventoryUseRecord::getMete)
               .filter(ObjectUtil::isNotEmpty)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            endQuantity = inventoryUseStatistics.getBeginStageTotalQuantity().add(inboundQuantity).subtract(outboundQuantity);
            endMete = inventoryUseStatistics.getBeginStageTotalMete().add(inboundMete).subtract(outboundMete);
         } else {
            inboundQuantity = inventoryUseStatistics.getInboundStageTotalQuantity();
            inboundMete = inventoryUseStatistics.getInboundStageTotalMete();
            outboundQuantity = inventoryUseStatistics.getOutboundStageTotalQuantity();
            outboundMete = inventoryUseStatistics.getOutboundStageTotalMete();
            endQuantity = inventoryUseStatistics.getEndStageTotalQuantity();
            endMete = inventoryUseStatistics.getEndStageTotalMete();
         }

         String measureUnit;
         String accountingUnit;
         Integer measurePrecision;
         Integer accountingPrecision;
         if (measure.getAccountingUnit() != null) {
            measureUnit = measure.getMeasureUnit();
            accountingUnit = measure.getAccountingUnit();
            measurePrecision = measure.getMeasurePrecision();
            accountingPrecision = measure.getAccountingPrecision();
         } else {
            Classification classification = classificationMap.get(inventoryUseStatistics.getClassifyId());
            Measure m = this.getMeasure(classification.getParentId());
            measureUnit = m.getMeasureUnit();
            accountingUnit = m.getAccountingUnit();
            measurePrecision = m.getMeasurePrecision();
            accountingPrecision = m.getAccountingPrecision();
         }

         mapObject.put("measureUnit", ObjectUtil.isNotEmpty(measureUnit) ? measureUnit : "-");
         mapObject.put("accountingUnit", accountingUnit);
         mapObject.put(
            "beginQuantity",
            beginStageTotalQuantity.compareTo(BigDecimal.ZERO) != 0
               ? this.unitConversionV2(beginStageTotalQuantity, measureUnit, measurePrecision, unitMap).get(1).toPlainString()
               : "-"
         );
         mapObject.put(
            "beginMete",
            beginStageTotalMete.compareTo(BigDecimal.ZERO) != 0
               ? this.unitConversionV2(beginStageTotalMete, accountingUnit, accountingPrecision, unitMap).get(1).toPlainString()
               : "-"
         );
         mapObject.put(
            "inboundQuantity",
            inboundQuantity.compareTo(BigDecimal.ZERO) != 0
               ? this.unitConversionV2(inboundQuantity, measureUnit, measurePrecision, unitMap).get(1).toPlainString()
               : "-"
         );
         mapObject.put(
            "inboundMete",
            inboundMete.compareTo(BigDecimal.ZERO) != 0
               ? this.unitConversionV2(inboundMete, accountingUnit, accountingPrecision, unitMap).get(1).toPlainString()
               : "-"
         );
         mapObject.put(
            "transferQuantity",
            transferQuantity.compareTo(BigDecimal.ZERO) != 0
               ? this.unitConversionV2(transferQuantity, measureUnit, measurePrecision, unitMap).get(1).toPlainString()
               : "-"
         );
         mapObject.put(
            "transferMete",
            transferMete.compareTo(BigDecimal.ZERO) != 0
               ? this.unitConversionV2(transferMete, accountingUnit, accountingPrecision, unitMap).get(1).toPlainString()
               : "-"
         );
         mapObject.put(
            "outboundQuantity",
            outboundQuantity.compareTo(BigDecimal.ZERO) != 0
               ? this.unitConversionV2(outboundQuantity, measureUnit, measurePrecision, unitMap).get(1).toPlainString()
               : "-"
         );
         mapObject.put(
            "outboundMete",
            outboundMete.compareTo(BigDecimal.ZERO) != 0
               ? this.unitConversionV2(outboundMete, accountingUnit, accountingPrecision, unitMap).get(1).toPlainString()
               : "-"
         );
         mapObject.put(
            "endQuantity",
            endQuantity.compareTo(BigDecimal.ZERO) != 0
               ? this.unitConversionV2(endQuantity, measureUnit, measurePrecision, unitMap).get(1).toPlainString()
               : "-"
         );
         mapObject.put(
            "endMete",
            endMete.compareTo(BigDecimal.ZERO) != 0 ? this.unitConversionV2(endMete, accountingUnit, accountingPrecision, unitMap).get(1).toPlainString() : "-"
         );
         mapList.add(mapObject);
      }

      map.put("mapList", mapList);
      this.download(response, message, map, 27);
   }

   @Override
   public void inventoryStatisticsDownloadNew(QueryInventoryUseStatisticsDTOParam param, HttpServletResponse response) {
      String message = null;
      HashMap<String, Object> map = new HashMap<>(16);
      InventoryUseStatisticsDate inventoryUseStatisticsDate = this.inventoryUseStatisticsDateService.getById(param.getStatisticsDateId());
      DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      LocalDateTime startTime = inventoryUseStatisticsDate.getStartTime();
      String startTimeStr = "";
      if (ObjectUtil.isNotEmpty(startTime)) {
         startTimeStr = dateTimeFormatter.format(startTime);
      }

      LocalDateTime endTime = inventoryUseStatisticsDate.getEndTime();
      String endTimeStr = "";
      if (ObjectUtil.isNotEmpty(endTime)) {
         endTimeStr = dateTimeFormatter.format(endTime);
      }

      map.put("date", startTimeStr + "~" + endTimeStr);
      List<Map<String, Object>> mapList = new ArrayList<>();
      InventoryUseConfig inventoryBasicConf = this.basicConfigService.getInventoryBasicConf();
      List<String> idstr = this.inventoryUseStatisticsMapper.getInventoryUseStatisticsNew(param, inventoryBasicConf);
      List<InventoryUseStatisticsMergeDTO> inventoryUseStatisticsMergeDTOS = this.inventoryUseStatisticsService
         .convertMergeDTO(idstr, inventoryUseStatisticsDate.getBoolBalance());
      List<Long> classifyIds = inventoryUseStatisticsMergeDTOS.stream().map(InventoryUseStatisticsMergeDTO::getClassifyId).collect(Collectors.toList());
      Map<Long, Classification> classificationMap = this.queryUtil.getClassificationMapByIds(classifyIds);
      Map<String, Unit> unitMap = this.unitMapper.selectList(null).stream().collect(Collectors.toMap(Unit::getName, Function.identity()));
      List<Long> statisticsIds = idstr.stream().flatMap(ix -> Arrays.stream(ix.split(",")).map(Long::valueOf)).collect(Collectors.toList());
      List<InventoryUseRecord> inventoryUseRecords = this.inventoryUseRecordService
         .list((Wrapper<InventoryUseRecord>)new LambdaQueryWrapper<InventoryUseRecord>().in(InventoryUseRecord::getInventoryUseStatisticsId, statisticsIds));

      for (int i = 0; i < inventoryUseStatisticsMergeDTOS.size(); i++) {
         Map<String, Object> mapObject = new HashMap<>();
         InventoryUseStatisticsMergeDTO inventoryUseStatisticsMergeDTO = inventoryUseStatisticsMergeDTOS.get(i);
         List<InventoryUseRecord> inventoryUseRecordList = inventoryUseRecords.stream()
            .filter(a -> inventoryUseStatisticsMergeDTO.getIdList().contains(a.getInventoryUseStatisticsId()))
            .collect(Collectors.toList());
         boolean boolInbound = CollectionUtil.isNotEmpty(inventoryUseRecordList.stream().filter(a -> a.getEmbodyType().equals(1)).collect(Collectors.toList()));
         boolean boolOutbound = CollectionUtil.isNotEmpty(inventoryUseRecordList.stream().filter(a -> a.getEmbodyType().equals(2)).collect(Collectors.toList()));
         boolean boolTransfer = CollectionUtil.isNotEmpty(inventoryUseRecordList.stream().filter(a -> a.getEmbodyType().equals(3)).collect(Collectors.toList()));
         mapObject.put("id", i + 1);
         mapObject.put("classSerialNumber", inventoryUseStatisticsMergeDTO.getSerialNumber());
         Map<String, String> classMap = this.setClassifyName(
            inventoryUseStatisticsMergeDTO.getBasicClass(), inventoryUseStatisticsMergeDTO.getClassifyId(), inventoryUseStatisticsMergeDTO.getClassifyName()
         );
         mapObject.put("basicClass", classMap.get("分类"));
         mapObject.put("classifyName", classMap.get("名称"));
         mapObject.put(
            "specification",
            CollectionUtil.isNotEmpty(inventoryUseStatisticsMergeDTO.getSpecificationList())
               ? String.join(",", inventoryUseStatisticsMergeDTO.getSpecificationList())
               : "-"
         );
         mapObject.put(
            "brand",
            CollectionUtil.isNotEmpty(inventoryUseStatisticsMergeDTO.getBrandList()) ? String.join(",", inventoryUseStatisticsMergeDTO.getBrandList()) : "-"
         );
         mapObject.put(
            "projectName",
            CollectionUtil.isNotEmpty(inventoryUseStatisticsMergeDTO.getProjectInfoList())
               ? String.join(",", inventoryUseStatisticsMergeDTO.getProjectInfoList().stream().map(ProjectInfo::getShortName).collect(Collectors.joining(",")))
               : "-"
         );
         mapObject.put("materialSnNew", inventoryUseStatisticsMergeDTO.getMaterialSnNew());
         mapObject.put(
            "warehouseName",
            CollectionUtil.isNotEmpty(inventoryUseStatisticsMergeDTO.getWarehouseNameList())
               ? String.join(",", inventoryUseStatisticsMergeDTO.getWarehouseNameList())
               : "-"
         );
         mapObject.put(
            "color",
            CollectionUtil.isNotEmpty(inventoryUseStatisticsMergeDTO.getColorList()) ? String.join(",", inventoryUseStatisticsMergeDTO.getColorList()) : "-"
         );
         mapObject.put(
            "heatNoAndBatchNo",
            CollectionUtil.isNotEmpty(inventoryUseStatisticsMergeDTO.getHeatNoAndBatchNoList())
               ? String.join(",", inventoryUseStatisticsMergeDTO.getHeatNoAndBatchNoList())
               : "-"
         );
         Measure measure = inventoryUseStatisticsMergeDTO.getMeasure();
         BigDecimal beginStageTotalQuantity = ObjectUtil.isNotEmpty(inventoryUseStatisticsMergeDTO.getBeginStageTotalQuantity())
            ? inventoryUseStatisticsMergeDTO.getBeginStageTotalQuantity()
            : BigDecimal.ZERO;
         BigDecimal beginStageTotalMete = ObjectUtil.isNotEmpty(inventoryUseStatisticsMergeDTO.getBeginStageTotalMete())
            ? inventoryUseStatisticsMergeDTO.getBeginStageTotalMete()
            : BigDecimal.ZERO;
         BigDecimal inboundQuantity = BigDecimal.ZERO;
         BigDecimal inboundMete = BigDecimal.ZERO;
         BigDecimal transferQuantity = BigDecimal.ZERO;
         BigDecimal transferMete = BigDecimal.ZERO;
         BigDecimal outboundQuantity = BigDecimal.ZERO;
         BigDecimal outboundMete = BigDecimal.ZERO;
         BigDecimal endQuantity = BigDecimal.ZERO;
         BigDecimal endMete = BigDecimal.ZERO;
         if (!inventoryUseStatisticsDate.getBoolBalance()) {
            List<InventoryUseRecord> inboundInventoryUseRecordList = inventoryUseRecordList.stream()
               .filter(inventoryUseRecord -> inventoryUseRecord.getEmbodyType().equals(1))
               .collect(Collectors.toList());
            inboundQuantity = inboundInventoryUseRecordList.stream()
               .map(InventoryUseRecord::getQuantity)
               .filter(ObjectUtil::isNotEmpty)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            inboundMete = inboundInventoryUseRecordList.stream()
               .map(InventoryUseRecord::getMete)
               .filter(ObjectUtil::isNotEmpty)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            List<InventoryUseRecord> transferInventoryUseRecordList = inventoryUseRecordList.stream()
               .filter(inventoryUseRecord -> inventoryUseRecord.getEmbodyType().equals(3))
               .collect(Collectors.toList());
            transferQuantity = transferInventoryUseRecordList.stream()
               .map(InventoryUseRecord::getQuantity)
               .filter(ObjectUtil::isNotEmpty)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            transferMete = transferInventoryUseRecordList.stream()
               .map(InventoryUseRecord::getMete)
               .filter(ObjectUtil::isNotEmpty)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            List<InventoryUseRecord> outboundInventoryUseRecordList = inventoryUseRecordList.stream()
               .filter(inventoryUseRecord -> inventoryUseRecord.getEmbodyType().equals(2))
               .collect(Collectors.toList());
            outboundQuantity = outboundInventoryUseRecordList.stream()
               .map(InventoryUseRecord::getQuantity)
               .filter(ObjectUtil::isNotEmpty)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            outboundMete = outboundInventoryUseRecordList.stream()
               .map(InventoryUseRecord::getMete)
               .filter(ObjectUtil::isNotEmpty)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            endQuantity = beginStageTotalQuantity.add(inboundQuantity).add(transferQuantity).subtract(outboundQuantity);
            endMete = beginStageTotalMete.add(inboundMete).add(transferMete).subtract(outboundMete);
         } else {
            inboundQuantity = inventoryUseStatisticsMergeDTO.getInboundStageTotalQuantity();
            inboundMete = inventoryUseStatisticsMergeDTO.getInboundStageTotalMete();
            transferQuantity = inventoryUseStatisticsMergeDTO.getTransferStageTotalQuantity();
            transferMete = inventoryUseStatisticsMergeDTO.getTransferStageTotalMete();
            outboundQuantity = inventoryUseStatisticsMergeDTO.getOutboundStageTotalQuantity();
            outboundMete = inventoryUseStatisticsMergeDTO.getOutboundStageTotalMete();
            endQuantity = inventoryUseStatisticsMergeDTO.getEndStageTotalQuantity();
            endMete = inventoryUseStatisticsMergeDTO.getEndStageTotalMete();
         }

         Integer accountingPrecision;
         String measureUnit;
         String accountingUnit;
         Integer measurePrecision;
         if (measure.getAccountingUnit() != null) {
            measureUnit = measure.getMeasureUnit();
            accountingUnit = measure.getAccountingUnit();
            measurePrecision = measure.getMeasurePrecision();
            accountingPrecision = measure.getAccountingPrecision();
         } else {
            Classification classification = classificationMap.get(inventoryUseStatisticsMergeDTO.getClassifyId());
            measure = this.getMeasure(classification.getParentId());
            measureUnit = measure.getMeasureUnit();
            accountingUnit = measure.getAccountingUnit();
            measurePrecision = measure.getMeasurePrecision();
            accountingPrecision = measure.getAccountingPrecision();
         }

         mapObject.put("measureUnit", ObjectUtil.isNotEmpty(measureUnit) ? measureUnit : "-");
         mapObject.put("accountingUnit", accountingUnit);
         mapObject.put(
            "beginMete",
            ObjectUtil.isNotEmpty(beginStageTotalMete) && beginStageTotalMete.compareTo(BigDecimal.ZERO) != 0
               ? this.unitConversionV2(beginStageTotalMete, accountingUnit, accountingPrecision, unitMap).get(1).toPlainString()
               : "-"
         );
         mapObject.put(
            "inboundMete",
            ObjectUtil.isNotEmpty(inboundMete) && inboundMete.compareTo(BigDecimal.ZERO) != 0
               ? this.unitConversionV2(inboundMete, accountingUnit, accountingPrecision, unitMap).get(1).toPlainString()
               : (boolInbound ? "0" : "-")
         );
         mapObject.put(
            "transferMete",
            ObjectUtil.isNotEmpty(transferMete) && transferMete.compareTo(BigDecimal.ZERO) != 0
               ? this.unitConversionV2(transferMete, accountingUnit, accountingPrecision, unitMap).get(1).toPlainString()
               : (boolTransfer ? "0" : "-")
         );
         mapObject.put(
            "outboundMete",
            ObjectUtil.isNotEmpty(outboundMete) && outboundMete.compareTo(BigDecimal.ZERO) != 0
               ? this.unitConversionV2(outboundMete, accountingUnit, accountingPrecision, unitMap).get(1).toPlainString()
               : (boolOutbound ? "0" : "-")
         );
         mapObject.put(
            "endMete",
            ObjectUtil.isNotEmpty(endMete) && endMete.compareTo(BigDecimal.ZERO) != 0
               ? this.unitConversionV2(endMete, accountingUnit, accountingPrecision, unitMap).get(1).toPlainString()
               : "0"
         );
         if (measure.getOutboundUnitType().equals(1)) {
            mapObject.put(
               "beginQuantity",
               ObjectUtil.isNotEmpty(beginStageTotalQuantity) && beginStageTotalQuantity.compareTo(BigDecimal.ZERO) != 0
                  ? this.unitConversionV2(beginStageTotalQuantity, measureUnit, measurePrecision, unitMap).get(1).toPlainString()
                  : "-"
            );
            mapObject.put(
               "inboundQuantity",
               ObjectUtil.isNotEmpty(inboundQuantity) && inboundQuantity.compareTo(BigDecimal.ZERO) != 0
                  ? this.unitConversionV2(inboundQuantity, measureUnit, measurePrecision, unitMap).get(1).toPlainString()
                  : (boolInbound ? "0" : "-")
            );
            mapObject.put(
               "transferQuantity",
               ObjectUtil.isNotEmpty(transferQuantity) && transferQuantity.compareTo(BigDecimal.ZERO) != 0
                  ? this.unitConversionV2(transferQuantity, measureUnit, measurePrecision, unitMap).get(1).toPlainString()
                  : (boolTransfer ? "0" : "-")
            );
            mapObject.put(
               "outboundQuantity",
               ObjectUtil.isNotEmpty(outboundQuantity) && outboundQuantity.compareTo(BigDecimal.ZERO) != 0
                  ? this.unitConversionV2(outboundQuantity, measureUnit, measurePrecision, unitMap).get(1).toPlainString()
                  : (boolOutbound ? "0" : "-")
            );
            mapObject.put(
               "endQuantity",
               ObjectUtil.isNotEmpty(endQuantity) && endQuantity.compareTo(BigDecimal.ZERO) != 0
                  ? this.unitConversionV2(endQuantity, measureUnit, measurePrecision, unitMap).get(1).toPlainString()
                  : "0"
            );
         } else {
            mapObject.put("beginQuantity", "-");
            mapObject.put("inboundQuantity", "-");
            mapObject.put("transferQuantity", "-");
            mapObject.put("outboundQuantity", "-");
            mapObject.put("endQuantity", "-");
         }

         mapList.add(mapObject);
      }

      map.put("mapList", mapList);
      this.download(response, message, map, 27);
   }

   @Override
   public void inventoryUseRecordDownload(Long id, HttpServletResponse response) {
      String message = null;
      HashMap<String, Object> map = new HashMap<>(16);
      InventoryUseStatistics inventoryUseStatistics = this.inventoryUseStatisticsMapper.selectById(id);
      InventoryUseStatisticsDate inventoryUseStatisticsDate = this.inventoryUseStatisticsDateService.getById(inventoryUseStatistics.getStatisticsDateId());
      ContractProject project = this.projectService.getById(inventoryUseStatistics.getProjectId());
      Classification classification = this.classificationService.getById(inventoryUseStatistics.getClassifyId());
      Map<String, Unit> unitMap = this.unitMapper.selectList(null).stream().collect(Collectors.toMap(Unit::getName, Function.identity()));
      Measure measure = this.measureMapper.selectOne((Wrapper<Measure>)new LambdaQueryWrapper<Measure>().eq(Measure::getClassificationId, classification.getId()));
      Workshop workshop = this.workshopService.getById(inventoryUseStatistics.getWorkshopId());
      Warehouse warehouse = this.warehouseService.getById(inventoryUseStatistics.getWarehouseId());
      List<InventoryUseRecord> inventoryUseRecords = this.inventoryUseRecordService
         .list((Wrapper<InventoryUseRecord>)new LambdaQueryWrapper<InventoryUseRecord>().eq(InventoryUseRecord::getInventoryUseStatisticsId, id));
      StringBuilder spec = new StringBuilder();
      if (BasicClassEnum.STEEL_PLATE.getType().equals(inventoryUseStatistics.getBasicClass())) {
         spec.append(inventoryUseStatistics.getThickness().stripTrailingZeros().toPlainString());
         if (inventoryUseStatistics.getWidth() != null) {
            spec.append("*").append(inventoryUseStatistics.getWidth().stripTrailingZeros().toPlainString());
         }

         if (inventoryUseStatistics.getLength() != null) {
            spec.append("*").append(inventoryUseStatistics.getLength().stripTrailingZeros().toPlainString());
         }

         if (inventoryUseStatistics.getSpecification() != null) {
            spec.append(" * ").append(inventoryUseStatistics.getSpecification());
         }
      } else if (BasicClassEnum.COLOR_ROLL.getType().equals(inventoryUseStatistics.getBasicClass())) {
         spec.append(inventoryUseStatistics.getThickness().stripTrailingZeros().toPlainString());
         if (inventoryUseStatistics.getWidth() != null) {
            spec.append("*").append(inventoryUseStatistics.getWidth().stripTrailingZeros().toPlainString());
         }

         if (inventoryUseStatistics.getSpecification() != null) {
            spec.append(" * ").append(inventoryUseStatistics.getSpecification());
         }
      } else if (BasicClassEnum.SECTION_STEEL.getType().equals(inventoryUseStatistics.getBasicClass())
         || BasicClassEnum.checkNotSteel(inventoryUseStatistics.getBasicClass())) {
         if (inventoryUseStatistics.getLength() != null) {
            spec.append(inventoryUseStatistics.getLength().stripTrailingZeros().toPlainString());
         }

         if (spec.length() > 0) {
            spec.append(" * ");
         }

         if (inventoryUseStatistics.getSpecification() != null) {
            spec.append(inventoryUseStatistics.getSpecification());
         }
      }

      Map<String, Object> mapObject = new HashMap<>();
      mapObject.put("classSerialNumber", ObjectUtil.isNotEmpty(inventoryUseStatistics.getSerialNumber()) ? inventoryUseStatistics.getSerialNumber() : "-");
      mapObject.put("classifyName", classification.getName());
      mapObject.put("specification", ObjectUtil.isNotEmpty(spec) ? spec : "-");
      mapObject.put("brand", ObjectUtil.isNotEmpty(inventoryUseStatistics.getBrand()) ? inventoryUseStatistics.getBrand() : "-");
      mapObject.put("projectName", ObjectUtil.isNotEmpty(inventoryUseStatistics.getProjectId()) ? project.getShortName() : "-");
      mapObject.put("warehouseName", workshop.getName() + "-" + warehouse.getName());
      String measureUnit = measure.getMeasureUnit();
      mapObject.put("measureUnit", measureUnit != null ? measureUnit : "-");
      Integer measurePrecision = measure.getMeasurePrecision();
      String accountingUnit = measure.getAccountingUnit();
      mapObject.put("accountingUnit", accountingUnit != null ? accountingUnit : "-");
      Integer accountingPrecision = measure.getAccountingPrecision();
      if (inventoryUseStatistics.getBeginStageTotalMete().compareTo(BigDecimal.ZERO) != 0) {
         List<Map<String, Object>> mapList = new ArrayList<>();
         Map<String, Object> newColumnMap = mapObject.entrySet().stream().collect(Collectors.toMap(Entry::getKey, Entry::getValue));
         newColumnMap.put("id", 1);
         newColumnMap.put(
            "quantity",
            inventoryUseStatistics.getBeginStageTotalQuantity().compareTo(BigDecimal.ZERO) != 0
               ? this.unitConversionV2(inventoryUseStatistics.getBeginStageTotalQuantity(), measureUnit, measurePrecision, unitMap).get(1).toPlainString()
               : "-"
         );
         newColumnMap.put(
            "mete",
            inventoryUseStatistics.getBeginStageTotalMete().compareTo(BigDecimal.ZERO) != 0
               ? this.unitConversionV2(inventoryUseStatistics.getBeginStageTotalMete(), accountingUnit, accountingPrecision, unitMap).get(1).toPlainString()
               : "-"
         );
         mapList.add(newColumnMap);
         map.put("mapList", mapList);
      }

      List<InventoryUseRecord> inboundRecords = inventoryUseRecords.stream().filter(i -> i.getEmbodyType().equals(1)).collect(Collectors.toList());
      List<Map<String, Object>> mapList = new ArrayList<>();

      for (int i = 0; i < inboundRecords.size(); i++) {
         Map<String, Object> newColumnMap = mapObject.entrySet().stream().collect(Collectors.toMap(Entry::getKey, Entry::getValue));
         InventoryUseRecord inventoryUseRecord = inboundRecords.get(i);
         newColumnMap.put("id", i + 1);
         newColumnMap.put("heatNoAndBatchNo", inventoryUseRecord.getHeatNoAndBatchNo());
         newColumnMap.put(
            "quantity",
            inventoryUseRecord.getQuantity().compareTo(BigDecimal.ZERO) != 0
               ? this.unitConversionV2(inventoryUseRecord.getQuantity(), measureUnit, measurePrecision, unitMap).get(1).toPlainString()
               : "-"
         );
         newColumnMap.put(
            "mete",
            inventoryUseRecord.getMete().compareTo(BigDecimal.ZERO) != 0
               ? this.unitConversionV2(inventoryUseRecord.getMete(), accountingUnit, accountingPrecision, unitMap).get(1).toPlainString()
               : "-"
         );
         newColumnMap.put("type", ObjectUtil.isNotEmpty(inventoryUseRecord.getUseType()) ? ReceiptTypeEnum.getName(inventoryUseRecord.getUseType()) : "-");
         newColumnMap.put("sn", ObjectUtil.isNotEmpty(inventoryUseRecord.getUseOrderSerialNumber()) ? inventoryUseRecord.getUseOrderSerialNumber() : "-");
         mapList.add(newColumnMap);
         map.put("mapListOne", mapList);
      }

      List<InventoryUseRecord> inventoryRecordsFromMapList = inventoryUseRecords.stream().filter(i -> i.getEmbodyType().equals(2)).collect(Collectors.toList());
      List<Map<String, Object>> mapListx = new ArrayList<>();

      for (int i = 0; i < inventoryRecordsFromMapList.size(); i++) {
         Map<String, Object> newColumnMap = mapObject.entrySet().stream().collect(Collectors.toMap(Entry::getKey, Entry::getValue));
         InventoryUseRecord inventoryUseRecord = (InventoryUseRecord)inventoryRecordsFromMapList.get(i);
         newColumnMap.put("id", i + 1);
         newColumnMap.put("heatNoAndBatchNo", inventoryUseRecord.getHeatNoAndBatchNo());
         newColumnMap.put(
            "quantity",
            inventoryUseRecord.getQuantity().compareTo(BigDecimal.ZERO) != 0
               ? this.unitConversionV2(inventoryUseRecord.getQuantity(), measureUnit, measurePrecision, unitMap).get(1).toPlainString()
               : "-"
         );
         newColumnMap.put(
            "mete",
            inventoryUseRecord.getMete().compareTo(BigDecimal.ZERO) != 0
               ? this.unitConversionV2(inventoryUseRecord.getMete(), accountingUnit, accountingPrecision, unitMap).get(1).toPlainString()
               : "-"
         );
         newColumnMap.put("type", ObjectUtil.isNotEmpty(inventoryUseRecord.getUseType()) ? ReceiptTypeEnum.getName(inventoryUseRecord.getUseType()) : "-");
         newColumnMap.put("sn", ObjectUtil.isNotEmpty(inventoryUseRecord.getUseOrderSerialNumber()) ? inventoryUseRecord.getUseOrderSerialNumber() : "-");
         mapListx.add(newColumnMap);
         map.put("mapListTwo", mapListx);
      }

      BigDecimal endStageTotalQuantity = inventoryUseStatistics.getEndStageTotalQuantity();
      BigDecimal endStageTotalMete = inventoryUseStatistics.getEndStageTotalMete();
      if (!inventoryUseStatisticsDate.getBoolBalance()) {
         BigDecimal inboundQuantity = inboundRecords.stream().map(InventoryUseRecord::getQuantity).reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal inboundMete = inboundRecords.stream().map(InventoryUseRecord::getMete).reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal outboundQuantity = inventoryRecordsFromMapList.stream().map(InventoryUseRecord::getQuantity).reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal outboundMete = inventoryRecordsFromMapList.stream().map(InventoryUseRecord::getMete).reduce(BigDecimal.ZERO, BigDecimal::add);
         endStageTotalQuantity = inventoryUseStatistics.getBeginStageTotalQuantity().add(inboundQuantity).subtract(outboundQuantity);
         endStageTotalMete = inventoryUseStatistics.getBeginStageTotalMete().add(inboundMete).subtract(outboundMete);
      }

      if (endStageTotalMete.compareTo(BigDecimal.ZERO) != 0) {
         List<Map<String, Object>> mapListxx = new ArrayList<>();
         Map<String, Object> newColumnMap = mapObject.entrySet().stream().collect(Collectors.toMap(Entry::getKey, Entry::getValue));
         newColumnMap.put("id", 1);
         newColumnMap.put(
            "quantity",
            endStageTotalQuantity.compareTo(BigDecimal.ZERO) != 0
               ? this.unitConversionV2(endStageTotalQuantity, measureUnit, measurePrecision, unitMap).get(1).toPlainString()
               : "-"
         );
         newColumnMap.put(
            "mete",
            endStageTotalMete.compareTo(BigDecimal.ZERO) != 0
               ? this.unitConversionV2(endStageTotalMete, accountingUnit, accountingPrecision, unitMap).get(1).toPlainString()
               : "-"
         );
         mapListxx.add(newColumnMap);
         map.put("mapListThree", mapListxx);
      }

      this.download(response, message, map, 28);
   }

   @Override
   public void inventoryUseRecordDownloadNew(List<Long> ids, HttpServletResponse response) {
      String message = null;
      HashMap<String, Object> map = new HashMap<>(16);
      List<InventoryUseStatistics> inventoryUseStatisticsList = this.inventoryUseStatisticsMapper.selectBatchIds(ids);
      InventoryUseStatistics inventoryUseStatisticsGet = inventoryUseStatisticsList.get(0);
      InventoryUseStatisticsDate inventoryUseStatisticsDate = this.inventoryUseStatisticsDateService.getById(inventoryUseStatisticsGet.getStatisticsDateId());
      List<Long> workshopIds = new ArrayList<>();
      List<Long> warehouseIds = new ArrayList<>();
      List<Long> projectIds = new ArrayList<>();

      for (InventoryUseStatistics inventoryUseStatistic : inventoryUseStatisticsList) {
         if (ObjectUtil.isNotEmpty(inventoryUseStatistic.getWorkshopId())) {
            workshopIds.add(inventoryUseStatistic.getWorkshopId());
         }

         if (ObjectUtil.isNotEmpty(inventoryUseStatistic.getWarehouseId())) {
            warehouseIds.add(inventoryUseStatistic.getWarehouseId());
         }

         if (ObjectUtil.isNotEmpty(inventoryUseStatistic.getProjectId())) {
            projectIds.add(inventoryUseStatistic.getProjectId());
         }
      }

      Classification classification = this.classificationService.getById(inventoryUseStatisticsGet.getClassifyId());
      Measure measure = this.measureMapper.selectOne((Wrapper<Measure>)new LambdaQueryWrapper<Measure>().eq(Measure::getClassificationId, classification.getId()));
      Map<Long, Workshop> workshopMap = this.queryUtilService.getWorkshopMapByIds(workshopIds);
      Map<Long, Warehouse> warehouseMap = this.queryUtilService.getWarehouseMapByIds(warehouseIds);
      Map<Long, ProjectInfo> projectInfoMap = this.queryUtilService.getProjectInfoMapByIds(projectIds);
      Map<String, Unit> unitMap = this.unitMapper.selectList(null).stream().collect(Collectors.toMap(Unit::getName, Function.identity()));
      List<InventoryUseRecord> inventoryUseRecords = this.inventoryUseRecordService
         .list((Wrapper<InventoryUseRecord>)new LambdaQueryWrapper<InventoryUseRecord>().in(InventoryUseRecord::getInventoryUseStatisticsId, ids));
      Map<String, Object> mapObject = new HashMap<>();
      mapObject.put("classifyName", classification.getName());
      String measureUnit = measure.getMeasureUnit();
      mapObject.put("measureUnit", measureUnit != null ? measureUnit : "-");
      Integer measurePrecision = measure.getMeasurePrecision();
      String accountingUnit = measure.getAccountingUnit();
      mapObject.put("accountingUnit", accountingUnit != null ? accountingUnit : "-");
      Integer accountingPrecision = measure.getAccountingPrecision();
      List<Map<String, Object>> mapList = new ArrayList<>();

      for (int i = 0; i < inventoryUseStatisticsList.size(); i++) {
         InventoryUseStatistics inventoryUseStatistics = inventoryUseStatisticsList.get(i);
         if (inventoryUseStatistics.getBeginStageTotalMete().compareTo(BigDecimal.ZERO) != 0) {
            Map<String, Object> newColumnMap = mapObject.entrySet().stream().collect(Collectors.toMap(Entry::getKey, Entry::getValue));
            newColumnMap.put("id", i + 1);
            if (measure.getOutboundUnitType().equals(1)) {
               newColumnMap.put(
                  "quantity",
                  inventoryUseStatistics.getBeginStageTotalQuantity().compareTo(BigDecimal.ZERO) != 0
                     ? this.unitConversionV2(inventoryUseStatistics.getBeginStageTotalQuantity(), measureUnit, measurePrecision, unitMap)
                        .get(1)
                        .toPlainString()
                     : "0"
               );
            } else {
               newColumnMap.put("quantity", "-");
            }

            newColumnMap.put(
               "mete",
               inventoryUseStatistics.getBeginStageTotalMete().compareTo(BigDecimal.ZERO) != 0
                  ? this.unitConversionV2(inventoryUseStatistics.getBeginStageTotalMete(), accountingUnit, accountingPrecision, unitMap).get(1).toPlainString()
                  : "-"
            );
            String specification = WmsUtil.getSpecification(
               inventoryUseStatistics.getBasicClass(),
               inventoryUseStatistics.getThickness(),
               inventoryUseStatistics.getWidth(),
               inventoryUseStatistics.getLength(),
               inventoryUseStatistics.getSpecification()
            );
            newColumnMap.put("specification", specification);
            newColumnMap.put(
               "classSerialNumber", ObjectUtil.isNotEmpty(inventoryUseStatistics.getSerialNumber()) ? inventoryUseStatistics.getSerialNumber() : "-"
            );
            newColumnMap.put("brand", ObjectUtil.isNotEmpty(inventoryUseStatistics.getBrand()) ? inventoryUseStatistics.getBrand() : "-");
            newColumnMap.put(
               "projectName",
               ObjectUtil.isNotEmpty(inventoryUseStatistics.getProjectId()) && inventoryUseStatistics.getProjectId() > 0L
                  ? projectInfoMap.get(inventoryUseStatistics.getProjectId()).getShortName()
                  : "-"
            );
            Workshop workshop = workshopMap.get(inventoryUseStatistics.getWorkshopId());
            Warehouse warehouse = warehouseMap.get(inventoryUseStatistics.getWarehouseId());
            newColumnMap.put("warehouseName", workshop.getName() + "-" + warehouse.getName());
            newColumnMap.put("color", ObjectUtil.isNotEmpty(inventoryUseStatistics.getColor()) ? inventoryUseStatistics.getColor() : "-");
            newColumnMap.put(
               "heatNoAndBatchNo", ObjectUtil.isNotEmpty(inventoryUseStatistics.getHeatNoAndBatchNo()) ? inventoryUseStatistics.getHeatNoAndBatchNo() : "-"
            );
            mapList.add(newColumnMap);
         }

         map.put("mapList", mapList);
      }

      List<InventoryUseRecord> inventoryRecordsFromMapList = inventoryUseRecords.stream().filter(ix -> ix.getEmbodyType().equals(1)).collect(Collectors.toList());
      List<Map<String, Object>> mapListx = new ArrayList<>();

      for (int i = 0; i < inventoryRecordsFromMapList.size(); i++) {
         Map<String, Object> newColumnMap = mapObject.entrySet().stream().collect(Collectors.toMap(Entry::getKey, Entry::getValue));
         InventoryUseRecord inventoryUseRecord = (InventoryUseRecord)inventoryRecordsFromMapList.get(i);
         newColumnMap.put("id", i + 1);
         newColumnMap.put("heatNoAndBatchNo", inventoryUseRecord.getHeatNoAndBatchNo());
         if (measure.getOutboundUnitType().equals(1)) {
            newColumnMap.put(
               "quantity",
               inventoryUseRecord.getQuantity().compareTo(BigDecimal.ZERO) != 0
                  ? this.unitConversionV2(inventoryUseRecord.getQuantity(), measureUnit, measurePrecision, unitMap).get(1).toPlainString()
                  : "-"
            );
         } else {
            newColumnMap.put("quantity", "-");
         }

         newColumnMap.put(
            "mete",
            inventoryUseRecord.getMete().compareTo(BigDecimal.ZERO) != 0
               ? this.unitConversionV2(inventoryUseRecord.getMete(), accountingUnit, accountingPrecision, unitMap).get(1).toPlainString()
               : "-"
         );
         newColumnMap.put("type", ObjectUtil.isNotEmpty(inventoryUseRecord.getUseType()) ? ReceiptTypeEnum.getName(inventoryUseRecord.getUseType()) : "-");
         newColumnMap.put("sn", ObjectUtil.isNotEmpty(inventoryUseRecord.getUseOrderSerialNumber()) ? inventoryUseRecord.getUseOrderSerialNumber() : "-");
         String specification = WmsUtil.getSpecification(
            inventoryUseRecord.getBasicClass(),
            inventoryUseRecord.getThickness(),
            inventoryUseRecord.getWidth(),
            inventoryUseRecord.getLength(),
            inventoryUseRecord.getSpecification()
         );
         newColumnMap.put("specification", specification);
         newColumnMap.put("classSerialNumber", ObjectUtil.isNotEmpty(inventoryUseRecord.getSerialNumber()) ? inventoryUseRecord.getSerialNumber() : "-");
         newColumnMap.put("brand", ObjectUtil.isNotEmpty(inventoryUseRecord.getBrand()) ? inventoryUseRecord.getBrand() : "-");
         newColumnMap.put(
            "projectName",
            ObjectUtil.isNotEmpty(inventoryUseRecord.getProjectId()) && inventoryUseRecord.getProjectId() > 0L
               ? projectInfoMap.get(inventoryUseRecord.getProjectId()).getShortName()
               : "-"
         );
         Workshop workshop = workshopMap.get(inventoryUseRecord.getWorkshopId());
         Warehouse warehouse = warehouseMap.get(inventoryUseRecord.getWarehouseId());
         newColumnMap.put("warehouseName", workshop.getName() + "-" + warehouse.getName());
         newColumnMap.put("color", ObjectUtil.isNotEmpty(inventoryUseRecord.getColor()) ? inventoryUseRecord.getColor() : "-");
         newColumnMap.put("heatNoAndBatchNo", ObjectUtil.isNotEmpty(inventoryUseRecord.getHeatNoAndBatchNo()) ? inventoryUseRecord.getHeatNoAndBatchNo() : "-");
         mapListx.add(newColumnMap);
      }

      map.put("mapListOne", mapListx);
      List<InventoryUseRecord> inventoryRecordsFromMapListx = inventoryUseRecords.stream().filter(ix -> ix.getEmbodyType().equals(3)).collect(Collectors.toList());
      List<Map<String, Object>> mapListxx = new ArrayList<>();

      for (int i = 0; i < inventoryRecordsFromMapListx.size(); i++) {
         Map<String, Object> newColumnMap = mapObject.entrySet().stream().collect(Collectors.toMap(Entry::getKey, Entry::getValue));
         InventoryUseRecord inventoryUseRecord = (InventoryUseRecord)inventoryRecordsFromMapListx.get(i);
         newColumnMap.put("id", i + 1);
         newColumnMap.put("heatNoAndBatchNo", inventoryUseRecord.getHeatNoAndBatchNo());
         if (measure.getOutboundUnitType().equals(1)) {
            newColumnMap.put(
               "quantity",
               inventoryUseRecord.getQuantity().compareTo(BigDecimal.ZERO) != 0
                  ? this.unitConversionV2(inventoryUseRecord.getQuantity(), measureUnit, measurePrecision, unitMap).get(1).toPlainString()
                  : "-"
            );
         } else {
            newColumnMap.put("quantity", "-");
         }

         newColumnMap.put(
            "mete",
            ((InventoryUseRecord)inventoryRecordsFromMapListx.get(i)).getMete().compareTo(BigDecimal.ZERO) != 0
               ? this.unitConversionV2(((InventoryUseRecord)inventoryRecordsFromMapListx.get(i)).getMete(), accountingUnit, accountingPrecision, unitMap).get(1).toPlainString()
               : "-"
         );
         newColumnMap.put(
            "type",
            ObjectUtil.isNotEmpty(((InventoryUseRecord)inventoryRecordsFromMapListx.get(i)).getUseType())
               ? ReceiptTypeEnum.getName(((InventoryUseRecord)inventoryRecordsFromMapListx.get(i)).getUseType())
               : "-"
         );
         newColumnMap.put(
            "sn",
            ObjectUtil.isNotEmpty(((InventoryUseRecord)inventoryRecordsFromMapListx.get(i)).getUseOrderSerialNumber())
               ? ((InventoryUseRecord)inventoryRecordsFromMapListx.get(i)).getUseOrderSerialNumber()
               : "-"
         );
         String specification = WmsUtil.getSpecification(
            inventoryUseRecord.getBasicClass(),
            inventoryUseRecord.getThickness(),
            inventoryUseRecord.getWidth(),
            inventoryUseRecord.getLength(),
            inventoryUseRecord.getSpecification()
         );
         newColumnMap.put("specification", specification);
         newColumnMap.put("classSerialNumber", ObjectUtil.isNotEmpty(inventoryUseRecord.getSerialNumber()) ? inventoryUseRecord.getSerialNumber() : "-");
         newColumnMap.put("brand", ObjectUtil.isNotEmpty(inventoryUseRecord.getBrand()) ? inventoryUseRecord.getBrand() : "-");
         newColumnMap.put(
            "projectName",
            ObjectUtil.isNotEmpty(inventoryUseRecord.getProjectId()) && inventoryUseRecord.getProjectId() > 0L
               ? projectInfoMap.get(inventoryUseRecord.getProjectId()).getShortName()
               : "-"
         );
         Workshop workshop = workshopMap.get(inventoryUseRecord.getWorkshopId());
         Warehouse warehouse = warehouseMap.get(inventoryUseRecord.getWarehouseId());
         newColumnMap.put("warehouseName", workshop.getName() + "-" + warehouse.getName());
         newColumnMap.put("color", ObjectUtil.isNotEmpty(inventoryUseRecord.getColor()) ? inventoryUseRecord.getColor() : "-");
         newColumnMap.put("heatNoAndBatchNo", ObjectUtil.isNotEmpty(inventoryUseRecord.getHeatNoAndBatchNo()) ? inventoryUseRecord.getHeatNoAndBatchNo() : "-");
         mapListxx.add(newColumnMap);
      }

      map.put("mapListFour", mapListxx);
      List<InventoryUseRecord> inventoryRecordsFromMapListxx = inventoryUseRecords.stream().filter(ix -> ix.getEmbodyType().equals(2)).collect(Collectors.toList());
      List<Map<String, Object>> mapListxxx = new ArrayList<>();

      for (int i = 0; i < inventoryRecordsFromMapListxx.size(); i++) {
         Map<String, Object> newColumnMap = mapObject.entrySet().stream().collect(Collectors.toMap(Entry::getKey, Entry::getValue));
         InventoryUseRecord inventoryUseRecord = (InventoryUseRecord)inventoryRecordsFromMapListxx.get(i);
         newColumnMap.put("id", i + 1);
         newColumnMap.put("heatNoAndBatchNo", inventoryUseRecord.getHeatNoAndBatchNo());
         if (measure.getOutboundUnitType().equals(1)) {
            newColumnMap.put(
               "quantity",
               inventoryUseRecord.getQuantity().compareTo(BigDecimal.ZERO) != 0
                  ? this.unitConversionV2(inventoryUseRecord.getQuantity(), measureUnit, measurePrecision, unitMap).get(1).toPlainString()
                  : "-"
            );
         } else {
            newColumnMap.put("quantity", "-");
         }

         newColumnMap.put(
            "mete",
            inventoryUseRecord.getMete().compareTo(BigDecimal.ZERO) != 0
               ? this.unitConversionV2(inventoryUseRecord.getMete(), accountingUnit, accountingPrecision, unitMap).get(1).toPlainString()
               : "-"
         );
         newColumnMap.put("type", ObjectUtil.isNotEmpty(inventoryUseRecord.getUseType()) ? ReceiptTypeEnum.getName(inventoryUseRecord.getUseType()) : "-");
         newColumnMap.put("sn", ObjectUtil.isNotEmpty(inventoryUseRecord.getUseOrderSerialNumber()) ? inventoryUseRecord.getUseOrderSerialNumber() : "-");
         String specification = WmsUtil.getSpecification(
            inventoryUseRecord.getBasicClass(),
            inventoryUseRecord.getThickness(),
            inventoryUseRecord.getWidth(),
            inventoryUseRecord.getLength(),
            inventoryUseRecord.getSpecification()
         );
         newColumnMap.put("specification", specification);
         newColumnMap.put("classSerialNumber", ObjectUtil.isNotEmpty(inventoryUseRecord.getSerialNumber()) ? inventoryUseRecord.getSerialNumber() : "-");
         newColumnMap.put("brand", ObjectUtil.isNotEmpty(inventoryUseRecord.getBrand()) ? inventoryUseRecord.getBrand() : "-");
         newColumnMap.put(
            "projectName",
            ObjectUtil.isNotEmpty(inventoryUseRecord.getProjectId()) && inventoryUseRecord.getProjectId() > 0L
               ? projectInfoMap.get(inventoryUseRecord.getProjectId()).getShortName()
               : "-"
         );
         Workshop workshop = workshopMap.get(inventoryUseRecord.getWorkshopId());
         Warehouse warehouse = warehouseMap.get(inventoryUseRecord.getWarehouseId());
         newColumnMap.put("warehouseName", workshop.getName() + "-" + warehouse.getName());
         newColumnMap.put("color", ObjectUtil.isNotEmpty(inventoryUseRecord.getColor()) ? inventoryUseRecord.getColor() : "-");
         newColumnMap.put("heatNoAndBatchNo", ObjectUtil.isNotEmpty(inventoryUseRecord.getHeatNoAndBatchNo()) ? inventoryUseRecord.getHeatNoAndBatchNo() : "-");
         mapListxxx.add(newColumnMap);
      }

      map.put("mapListTwo", mapListxxx);
      mapListxxx = new ArrayList<>();

      for (int i = 0; i < inventoryUseStatisticsList.size(); i++) {
         InventoryUseStatistics inventoryUseStatistics = inventoryUseStatisticsList.get(i);
         BigDecimal endStageTotalQuantity = inventoryUseStatistics.getEndStageTotalQuantity();
         BigDecimal endStageTotalMete = inventoryUseStatistics.getEndStageTotalMete();
         if (!inventoryUseStatisticsDate.getBoolBalance()) {
            BigDecimal inboundQuantity = inventoryRecordsFromMapList.stream()
               .filter(inventoryUseRecord -> inventoryUseRecord.getInventoryUseStatisticsId().equals(inventoryUseStatistics.getId()))
               .map(InventoryUseRecord::getQuantity)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal inboundMete = inventoryRecordsFromMapList.stream()
               .filter(inventoryUseRecord -> inventoryUseRecord.getInventoryUseStatisticsId().equals(inventoryUseStatistics.getId()))
               .map(InventoryUseRecord::getMete)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal transferQuantity = inventoryRecordsFromMapListx.stream()
               .filter(inventoryUseRecord -> inventoryUseRecord.getInventoryUseStatisticsId().equals(inventoryUseStatistics.getId()))
               .map(InventoryUseRecord::getQuantity)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal transferMete = inventoryRecordsFromMapListx.stream()
               .filter(inventoryUseRecord -> inventoryUseRecord.getInventoryUseStatisticsId().equals(inventoryUseStatistics.getId()))
               .map(InventoryUseRecord::getMete)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal outboundQuantity = inventoryRecordsFromMapListxx.stream()
               .filter(inventoryUseRecord -> inventoryUseRecord.getInventoryUseStatisticsId().equals(inventoryUseStatistics.getId()))
               .map(InventoryUseRecord::getQuantity)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal outboundMete = inventoryRecordsFromMapListxx.stream()
               .filter(inventoryUseRecord -> inventoryUseRecord.getInventoryUseStatisticsId().equals(inventoryUseStatistics.getId()))
               .map(InventoryUseRecord::getMete)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            endStageTotalQuantity = inventoryUseStatistics.getBeginStageTotalQuantity().add(inboundQuantity).add(transferQuantity).subtract(outboundQuantity);
            endStageTotalMete = inventoryUseStatistics.getBeginStageTotalMete().add(inboundMete).add(transferMete).subtract(outboundMete);
         }

         Map<String, Object> newColumnMap = mapObject.entrySet().stream().collect(Collectors.toMap(Entry::getKey, Entry::getValue));
         newColumnMap.put("id", i + 1);
         if (measure.getOutboundUnitType().equals(1)) {
            newColumnMap.put(
               "quantity",
               endStageTotalQuantity.compareTo(BigDecimal.ZERO) != 0
                  ? this.unitConversionV2(endStageTotalQuantity, measureUnit, measurePrecision, unitMap).get(1).toPlainString()
                  : "0"
            );
         } else {
            newColumnMap.put("quantity", "-");
         }

         newColumnMap.put(
            "mete",
            endStageTotalMete.compareTo(BigDecimal.ZERO) != 0
               ? this.unitConversionV2(endStageTotalMete, accountingUnit, accountingPrecision, unitMap).get(1).toPlainString()
               : "0"
         );
         String specification = WmsUtil.getSpecification(
            inventoryUseStatistics.getBasicClass(),
            inventoryUseStatistics.getThickness(),
            inventoryUseStatistics.getWidth(),
            inventoryUseStatistics.getLength(),
            inventoryUseStatistics.getSpecification()
         );
         newColumnMap.put("specification", specification);
         newColumnMap.put("classSerialNumber", ObjectUtil.isNotEmpty(inventoryUseStatistics.getSerialNumber()) ? inventoryUseStatistics.getSerialNumber() : "-");
         newColumnMap.put("brand", ObjectUtil.isNotEmpty(inventoryUseStatistics.getBrand()) ? inventoryUseStatistics.getBrand() : "-");
         newColumnMap.put(
            "projectName",
            ObjectUtil.isNotEmpty(inventoryUseStatistics.getProjectId()) && inventoryUseStatistics.getProjectId() > 0L
               ? projectInfoMap.get(inventoryUseStatistics.getProjectId()).getShortName()
               : "-"
         );
         Workshop workshop = workshopMap.get(inventoryUseStatistics.getWorkshopId());
         Warehouse warehouse = warehouseMap.get(inventoryUseStatistics.getWarehouseId());
         newColumnMap.put("warehouseName", workshop.getName() + "-" + warehouse.getName());
         newColumnMap.put("color", ObjectUtil.isNotEmpty(inventoryUseStatistics.getColor()) ? inventoryUseStatistics.getColor() : "-");
         newColumnMap.put(
            "heatNoAndBatchNo", ObjectUtil.isNotEmpty(inventoryUseStatistics.getHeatNoAndBatchNo()) ? inventoryUseStatistics.getHeatNoAndBatchNo() : "-"
         );
         mapListxxx.add(newColumnMap);
      }

      map.put("mapListThree", mapListxxx);
      this.download(response, message, map, 28);
   }

   @Override
   public void inboundPurchaseDetailDownload(Long id, Integer basicClass, HttpServletResponse response) {
      BasicInbound basicInboundConfig = this.basicConfigService.getInboundBasicConf();
      Integer saveInboundState = basicInboundConfig.getSaveInboundState();
      PurchaseOrder purchaseOrder = this.purchaseOrderService.getById(id);
      Preconditions.checkArgument(purchaseOrder != null, "采购单不存在！");
      List<PurchaseOrderDetail> purchaseOrderDetails = this.purchaseOrderDetailService
         .list(
            (Wrapper<PurchaseOrderDetail>)(new LambdaQueryWrapper<PurchaseOrderDetail>().eq(PurchaseOrderDetail::getPurchaseId, id))
               .eq(PurchaseOrderDetail::getBasicClass, basicClass)
         );
      if (!CollectionUtil.isEmpty(purchaseOrderDetails)) {
         List<Long> workshopIds = purchaseOrderDetails.stream()
            .map(PurchaseOrderDetail::getWorkshopId)
            .filter(ObjectUtil::isNotEmpty)
            .collect(Collectors.toList());
         Map<Long, Workshop> workshopMap = this.queryUtilService.getWorkshopMapByIds(workshopIds);
         List<Long> projectIds = purchaseOrderDetails.stream()
            .map(PurchaseOrderDetail::getProjectId)
            .filter(ObjectUtil::isNotEmpty)
            .collect(Collectors.toList());
         Map<Long, ContractProject> projectMap = this.queryUtilService.getProjectMapByIds(projectIds);
         List<Long> classifyIds = purchaseOrderDetails.stream()
            .map(PurchaseOrderDetail::getClassifyId)
            .filter(ObjectUtil::isNotEmpty)
            .collect(Collectors.toList());
         Map<Long, String> classFullPathNameMap = this.classificationService.getClassFullPathNameMap(classifyIds, "/");
         Map<Long, Measure> measureMap = this.queryUtilService.getMeasureMapByClassifyIds(classifyIds);
         Map<String, Object> map = new HashMap<>();
         List<Map<String, Object>> mapList = new ArrayList<>();
         String message = null;
         Integer type = null;

         for (int i = 0; i < purchaseOrderDetails.size(); i++) {
            Map<String, Object> mapObject = new HashMap<>();
            PurchaseOrderDetail purchaseOrderDetail = purchaseOrderDetails.get(i);
            Measure measure = measureMap.get(purchaseOrderDetail.getClassifyId());
            mapObject.put("id", i + 1);
            mapObject.put("className", classFullPathNameMap.get(purchaseOrderDetail.getClassifyId()));
            mapObject.put("brand", ObjectUtil.isNotEmpty(purchaseOrderDetail.getBrand()) ? purchaseOrderDetail.getBrand() : "");
            mapObject.put(
               "project",
               ObjectUtil.isNotEmpty(purchaseOrderDetail.getProjectId()) && purchaseOrderDetail.getProjectId() > 0L
                  ? projectMap.get(purchaseOrderDetail.getProjectId()).getShortName()
                  : ""
            );
            mapObject.put(
               "workshop",
               ObjectUtil.isNotEmpty(purchaseOrderDetail.getWorkshopId()) && purchaseOrderDetail.getWorkshopId() > 0L
                  ? workshopMap.get(purchaseOrderDetail.getWorkshopId()).getName()
                  : ""
            );
            mapObject.put(
               "uniqueIdentification",
               ObjectUtil.isNotEmpty(purchaseOrderDetail.getUniqueIdentification())
                  ? purchaseOrderDetail.getUniqueIdentification()
                  : purchaseOrderDetail.getId()
            );
            if (basicClass.equals(BasicClassEnum.STEEL_PLATE.getType())) {
               mapObject.put(
                  "model", ObjectUtil.isNotEmpty(purchaseOrderDetail.getDoNotSectionSteelSpec()) ? purchaseOrderDetail.getDoNotSectionSteelSpec() : ""
               );
               mapObject.put("thickness", ObjectUtil.isNotEmpty(purchaseOrderDetail.getThickness()) ? purchaseOrderDetail.getThickness() : "");
               mapObject.put("width", ObjectUtil.isNotEmpty(purchaseOrderDetail.getWidth()) ? purchaseOrderDetail.getWidth() : "");
               mapObject.put("length", ObjectUtil.isNotEmpty(purchaseOrderDetail.getLength()) ? purchaseOrderDetail.getLength() : "");
            } else if (basicClass.equals(BasicClassEnum.SECTION_STEEL.getType())) {
               mapObject.put("specification", ObjectUtil.isNotEmpty(purchaseOrderDetail.getSectionSteelSpec()) ? purchaseOrderDetail.getSectionSteelSpec() : "");
               mapObject.put(
                  "model", ObjectUtil.isNotEmpty(purchaseOrderDetail.getDoNotSectionSteelSpec()) ? purchaseOrderDetail.getDoNotSectionSteelSpec() : ""
               );
               mapObject.put("length", ObjectUtil.isNotEmpty(purchaseOrderDetail.getLength()) ? purchaseOrderDetail.getLength() : "");
            } else if (basicClass.equals(BasicClassEnum.COLOR_ROLL.getType())) {
               mapObject.put("model", ObjectUtil.isNotEmpty(purchaseOrderDetail.getSpecification()) ? purchaseOrderDetail.getSpecification() : "");
               mapObject.put("thickness", ObjectUtil.isNotEmpty(purchaseOrderDetail.getThickness()) ? purchaseOrderDetail.getThickness() : "");
               mapObject.put("width", ObjectUtil.isNotEmpty(purchaseOrderDetail.getWidth()) ? purchaseOrderDetail.getWidth() : "");
               mapObject.put("length", ObjectUtil.isNotEmpty(purchaseOrderDetail.getLength()) ? purchaseOrderDetail.getLength() : "");
               mapObject.put("color", ObjectUtil.isNotEmpty(purchaseOrderDetail.getColor()) ? purchaseOrderDetail.getColor() : "");
            } else if (!basicClass.equals(BasicClassEnum.GENERAL_MATERIAL.getType())
               && !basicClass.equals(BasicClassEnum.GAS.getType())
               && !basicClass.equals(BasicClassEnum.OTHER.getType())
               && !basicClass.equals(BasicClassEnum.OTHER_STEEL_MATERIALS.getType())) {
               message = "未知物料类型";
            } else {
               if (measure.getOutboundUnitType().equals(2)) {
                  mapObject.put("quantity", "/");
               }

               mapObject.put("specification", ObjectUtil.isNotEmpty(purchaseOrderDetail.getSpecification()) ? purchaseOrderDetail.getSpecification() : "");
               mapObject.put("color", ObjectUtil.isNotEmpty(purchaseOrderDetail.getColor()) ? purchaseOrderDetail.getColor() : "");
            }

            mapList.add(mapObject);
         }

         map.put("mapList", mapList);
         List<Measure> measureList = this.measureService
            .list(Wrappers.lambdaQuery(Measure.class).eq(Measure::getBasicClass, BasicClassEnum.STEEL_PLATE.getType()));
         if (CollectionUtil.isNotEmpty(measureList)) {
            String accountingUnit = measureList.get(0).getAccountingUnit();
            map.put("steelAccountingUnit", accountingUnit);
         } else {
            map.put("steelAccountingUnit", "kg");
         }

         String basicClassStr = null;
         if (basicClass.equals(BasicClassEnum.STEEL_PLATE.getType())) {
            basicClassStr = "STEEL_PLATE";
         } else if (basicClass.equals(BasicClassEnum.SECTION_STEEL.getType())) {
            basicClassStr = "SECTION_STEEL";
         } else if (basicClass.equals(BasicClassEnum.COLOR_ROLL.getType())) {
            basicClassStr = "COLOR_ROLL";
         } else if (basicClass.equals(BasicClassEnum.GENERAL_MATERIAL.getType())) {
            basicClassStr = "GENERAL_MATERIAL";
         } else if (basicClass.equals(BasicClassEnum.GAS.getType())) {
            basicClassStr = "GAS";
         } else if (basicClass.equals(BasicClassEnum.OTHER.getType())) {
            basicClassStr = "OTHER";
         } else if (basicClass.equals(BasicClassEnum.OTHER_STEEL_MATERIALS.getType())) {
            basicClassStr = "OTHER_STEEL_MATERIALS";
         } else {
            message = "未知物料类型";
         }

         basicClassStr = basicClassStr + (Integer.valueOf(2).equals(saveInboundState) ? "-2" : "");
         String resourcePath = "files/template/purchaseInboundDetail-" + basicClassStr + ".xlsx";
         String tempFileName = "purchaseInboundDetail-" + basicClassStr;
         String exportFileName = BasicClassEnum.getNameByType(basicClass) + "采购明细下载.xlsx";
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
         TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath(), true);
         Workbook workbook = ExcelExportUtil.exportExcel(params, map);
         PoiUtils.wmsDownLoadExcel(exportFileName, response, workbook, message);
      }
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printDeliveryPurchaseOrderDetailList(Long orderId) {
      PurchaseOrder purchaseOrder = this.purchaseOrderService.getById(orderId);
      Preconditions.checkArgument(purchaseOrder != null, "采购订单不存在");
      Preconditions.checkArgument(PlaceEnum.CONSTRUCTION_SITE.getType().equals(purchaseOrder.getOrderPlace()), "操作失败，仅直发工地采购单可打印发运单！");
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      Long branchCompanyId = purchaseOrder.getBranchCompanyId();
      if (branchCompanyId != null) {
         BranchCompany branchCompany = this.branchCompanyService.getById(branchCompanyId);
         header.put("branchCompany", branchCompany != null ? branchCompany.getName() : "-");
      } else {
         header.put("branchCompany", "-");
      }

      Long supplierId = purchaseOrder.getSupplierId();
      if (supplierId != null) {
         Supplier supplier = this.supplierService.getById(supplierId);
         header.put("supplier", supplier != null ? supplier.getName() : "-");
      } else {
         header.put("supplier", "-");
      }

      header.put("logisticsPayerType", LogisticsPayerEnum.getNameByType(purchaseOrder.getLogisticsPayerType()));
      ContractProject project = this.projectService.getById(Long.valueOf(purchaseOrder.getProjectIds()));
      String receivingManager = project.getReceivingManager();
      String receivingManagerPhone = project.getReceivingManagerPhone();
      String address = project.getAddress();
      String shortName = project.getShortName();
      String serialNumber = project.getSerialNumber();
      String name = project.getName();
      String customerUnit = project.getCustomerUnit();
      header.put("name", StrUtil.isNotBlank(name) ? name : "-");
      header.put("serialNumber", StrUtil.isNotBlank(serialNumber) ? serialNumber : "-");
      header.put("shortName", StrUtil.isNotBlank(shortName) ? shortName : "-");
      header.put("receivingManager", StrUtil.isNotBlank(receivingManager) ? receivingManager : "-");
      header.put("receivingManagerPhone", StrUtil.isNotBlank(receivingManagerPhone) ? receivingManagerPhone : "-");
      header.put("address", StrUtil.isNotBlank(address) ? address : "-");
      header.put("customerUnit", StrUtil.isNotBlank(customerUnit) ? customerUnit : "-");
      List<PurchaseOrderDetail> purchaseOrderDetails;
      if (ObjectUtil.isNotEmpty(purchaseOrder.getDetailIds())) {
         List<Long> collect1 = Arrays.stream(purchaseOrder.getDetailIds().split(",")).map(Long::valueOf).collect(Collectors.toList());
         purchaseOrderDetails = this.purchaseOrderDetailService.listByIds(collect1);
         purchaseOrderDetails.forEach(p -> p.setPurchaseId(purchaseOrder.getId()));
      } else {
         purchaseOrderDetails = this.purchaseOrderDetailService
            .list((Wrapper<PurchaseOrderDetail>)new LambdaQueryWrapper<PurchaseOrderDetail>().eq(PurchaseOrderDetail::getPurchaseId, purchaseOrder.getId()));
      }

      List<PurchaseOrderDetailDTO> dtoList = new ArrayList<>();
      if (purchaseOrderDetails.size() > 0) {
         for (PurchaseOrderDetail purchaseOrderDetail : purchaseOrderDetails) {
            PurchaseOrderDetailDTO purchaseOrderDetailDTO = BeanUtil.copy(purchaseOrderDetail, PurchaseOrderDetailDTO.class);
            dtoList.add(purchaseOrderDetailDTO);
         }
      }

      printVO.setHeader(header);
      List<Map<String, Object>> mapList = dtoList.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public void surplusImportTemplateExcel(Boolean boolPartyA, Integer basicClass, HttpServletResponse response) {
      Integer type = null;
      if (BasicClassEnum.STEEL_PLATE.getType().equals(basicClass)) {
         type = boolPartyA ? ExcelEnum.STEEL_PLATE_INBOUND_PARTY_A_SURPLUS_TEMPLATE.getType() : ExcelEnum.STEEL_PLATE_INBOUND_SELF_SURPLUS_TEMPLATE.getType();
      }

      if (BasicClassEnum.SECTION_STEEL.getType().equals(basicClass)) {
         type = boolPartyA
            ? ExcelEnum.SECTION_STEEL_INBOUND_PARTY_A_SURPLUS_TEMPLATE.getType()
            : ExcelEnum.SECTION_STEEL_INBOUND_SELF_SURPLUS_TEMPLATE.getType();
      }

      if (BasicClassEnum.COLOR_ROLL.getType().equals(basicClass)) {
         type = boolPartyA ? ExcelEnum.COLOR_ROLL_INBOUND_PARTY_A_SURPLUS_TEMPLATE.getType() : ExcelEnum.COLOR_ROLL_INBOUND_SELF_SURPLUS_TEMPLATE.getType();
      }

      if (BasicClassEnum.GENERAL_MATERIAL.getType().equals(basicClass)) {
         type = boolPartyA
            ? ExcelEnum.GENERAL_MATERIAL_INBOUND_PARTY_A_SURPLUS_TEMPLATE.getType()
            : ExcelEnum.GENERAL_MATERIAL_INBOUND_SELF_SURPLUS_TEMPLATE.getType();
      }

      if (BasicClassEnum.GAS.getType().equals(basicClass)) {
         type = boolPartyA ? ExcelEnum.GAS_INBOUND_PARTY_A_SURPLUS_TEMPLATE.getType() : ExcelEnum.GAS_INBOUND_SELF_SURPLUS_TEMPLATE.getType();
      }

      if (BasicClassEnum.OTHER.getType().equals(basicClass)) {
         type = boolPartyA ? ExcelEnum.OTHER_INBOUND_PARTY_A_SURPLUS_TEMPLATE.getType() : ExcelEnum.OTHER_INBOUND_SELF_SURPLUS_TEMPLATE.getType();
      }

      if (BasicClassEnum.OTHER_STEEL_MATERIALS.getType().equals(basicClass)) {
         type = boolPartyA
            ? ExcelEnum.OTHER_STEEL_MATERIALS_INBOUND_PARTY_A_SURPLUS_TEMPLATE.getType()
            : ExcelEnum.OTHER_STEEL_MATERIALS_INBOUND_SELF_SURPLUS_TEMPLATE.getType();
      }

      if (type != null) {
         this.downloadV2(response, null, new HashMap<>(), type);
      } else {
         throw new IllegalArgumentException("参数异常");
      }
   }

   @Override
   public void loseInventoryDownload(QueryByMaterialDTOParam param, HttpServletResponse response) {
      List<MaterialInventoryDTO> list = this.materialInventoryService.getSteelPlateDetail(param);
      HashMap<String, Object> map = new HashMap<>(16);
      Map<String, List<MonthWeightedAveragePrice>> monthWeightedAveragePriceMap = new HashMap<>();
      List<MonthWeightedAveragePrice> monthWeightedAveragePriceList = this.monthWAPMapper.selectList(new LambdaQueryWrapper<>());
      if (CollectionUtil.isNotEmpty(monthWeightedAveragePriceList)) {
         monthWeightedAveragePriceMap = monthWeightedAveragePriceList.stream().collect(Collectors.groupingBy(e -> e.getClassifyId() + "-" + e.getBasicClass()));
      }

      List<Long> collect = list.stream().map(MaterialInventoryDTO::getId).collect(Collectors.toList());
      Map<Long, MaterialInventory> materialInventoryMap = new HashMap<>();
      if (CollectionUtil.isNotEmpty(collect)) {
         materialInventoryMap = this.materialInventoryMapper
            .selectList((Wrapper<MaterialInventory>)new LambdaQueryWrapper<MaterialInventory>().in(MaterialInventory::getId, collect))
            .stream()
            .collect(Collectors.toMap(MaterialInventory::getId, Function.identity()));
      }

      Map<String, Unit> unitMap = this.unitMapper.selectList(new LambdaQueryWrapper<>()).stream().collect(Collectors.toMap(Unit::getName, Function.identity()));
      Map<Long, Measure> measureMap = this.measureMapper
         .selectList(new LambdaQueryWrapper<>())
         .stream()
         .collect(Collectors.toMap(Measure::getClassificationId, Function.identity()));
      Map<Long, Classification> classificationMap = this.classificationService
         .list()
         .stream()
         .collect(Collectors.toMap(Classification::getId, Function.identity()));
      WeightedPriceConf weightedPriceConf = JSON.parseObject(
         this.basicConfigMapper.selectOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置")).getValue(), WeightedPriceConf.class
      );
      List<Long> classifyIds = list.stream().map(MaterialInventoryDTO::getClassifyId).distinct().collect(Collectors.toList());
      Map<Long, String> fullNamePathMap = this.getFullNamePathMap(param.getBasicClass(), classifyIds);
      List<Map<String, Object>> mapList = new ArrayList<>();

      for (int i = 0; i < list.size(); i++) {
         Map<String, Object> mapObject = new HashMap<>();
         MaterialInventoryDTO materialInventoryDTO = list.get(i);
         DownLoadDetailDO detailDO = BeanUtil.copy(materialInventoryDTO, DownLoadDetailDO.class);
         detailDO.setAmountExcludingVat(materialInventoryDTO.getAmountExcludingVAT());
         mapObject.put("id", i + 1);
         Map<String, String> classMap = this.setClassifyName(detailDO.getBasicClass(), detailDO.getClassifyId(), detailDO.getClassifyName());
         mapObject.put("basicClass", classMap.get("分类"));
         mapObject.put("classifyName", fullNamePathMap.get(materialInventoryDTO.getClassifyId()));
         StringBuilder sb = new StringBuilder();
         StringBuilder lengths = new StringBuilder();
         StringBuilder material = new StringBuilder();
         this.setSpec(detailDO, sb);
         mapObject.put("spec", detailDO.getSpecification());
         if (BasicClassEnum.SECTION_STEEL.getType().equals(detailDO.getBasicClass())) {
            int lastIndex = detailDO.getSpecification().indexOf(" * ");
            String sectionSteelSpec = detailDO.getSpecification().substring(0, lastIndex);
            String doNotSectionSteelSpec = detailDO.getSpecification().substring(lastIndex + 3);
            mapObject.put("sectionSteelSpec", StrUtil.isNotBlank(sectionSteelSpec) ? sectionSteelSpec : "");
            mapObject.put("doNotSectionSteelSpec", StrUtil.isNotBlank(doNotSectionSteelSpec) ? doNotSectionSteelSpec : "");
         }

         Measure measure = measureMap.get(materialInventoryDTO.getClassifyId());
         if (StrUtil.isBlank(measure.getAccountingUnit())) {
            Classification classification = classificationMap.get(measure.getClassificationId());
            measure = this.getMeasureV2(classification.getParentId(), measureMap, classificationMap);
         }

         this.setAmountAndMeteV2(mapObject, detailDO, measure, classificationMap, measureMap, unitMap, null);
         MaterialInventory materialInventory1 = materialInventoryMap.get(materialInventoryDTO.getId());
         MonthWeightedAveragePrice price = this.getWeightedAveragePrice(monthWeightedAveragePriceMap, materialInventory1);
         Preconditions.checkArgument(price != null, "操作失败,获取月末加权平均价失败!");
         if (WeightedPriceEnum.WHOLE.getType().equals(weightedPriceConf.getWeightedType())) {
            WholeWeightedAveragePrice wholeWeightedAveragePrice = this.wholeWeightedAveragePriceMapper.selectById(price.getWholeWapId());
            price.setMete(wholeWeightedAveragePrice.getMete());
            price.setAmount(wholeWeightedAveragePrice.getAmount());
            price.setAmountExcludingVat(wholeWeightedAveragePrice.getAmountExcludingVat());
         }

         BigDecimal p = materialInventoryDTO.getMete().divide(price.getMete(), 20, RoundingMode.HALF_UP);
         BigDecimal amount = price.getAmount().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
         BigDecimal amountExcludingVat = price.getAmountExcludingVat().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
         BigDecimal avgPrice = NumberUtil.div(amount, materialInventoryDTO.getMete(), 12);
         BigDecimal excludingVatAvgPrice = NumberUtil.div(amountExcludingVat, materialInventoryDTO.getMete(), 12);
         Map<Integer, BigDecimal> mete = this.unitConversion(detailDO.getMete(), measure.getAccountingUnit(), measure.getAccountingPrecision());
         mapObject.put("unitPrice", avgPrice.multiply(mete.get(2)).setScale(2, 4));
         mapObject.put("unitPriceExcludingVat", excludingVatAvgPrice.multiply(mete.get(2)).setScale(2, 4));
         mapObject.put("amount", amount);
         mapObject.put("amountExcludingVat", amountExcludingVat);
         mapObject.put("material", StrUtil.isNotBlank(material) ? material : "-");
         mapObject.put("lengths", StrUtil.isNotBlank(lengths) ? lengths : "-");
         mapObject.put("thickness", materialInventoryDTO.getThickness() != null ? materialInventoryDTO.getThickness().stripTrailingZeros().toPlainString() : "");
         mapObject.put("standardName", materialInventoryDTO.getStandardName() != null ? materialInventoryDTO.getStandardName() : "");
         mapObject.put("width", materialInventoryDTO.getWidth() != null ? materialInventoryDTO.getWidth().stripTrailingZeros().toPlainString() : "");
         mapObject.put("length", materialInventoryDTO.getLength() != null ? materialInventoryDTO.getLength().stripTrailingZeros().toPlainString() : "");
         if (BasicClassEnum.COLOR_ROLL.getType().equals(detailDO.getBasicClass())) {
            mapObject.put(
               "length",
               materialInventoryDTO.getLength() != null
                  ? materialInventoryDTO.getLength().divide(UnitsPrecisionEnum.EG_KG.getRate(), 4, RoundingMode.CEILING).stripTrailingZeros().toPlainString()
                  : "-"
            );
         }

         mapObject.put("mUnit", StrUtil.isNotBlank(measure.getMeasureUnit()) ? measure.getMeasureUnit() : "");
         mapObject.put("aUnit", StrUtil.isNotBlank(measure.getAccountingUnit()) ? measure.getAccountingUnit() : "");
         mapObject.put("brand", StrUtil.isNotBlank(materialInventoryDTO.getBrand()) ? materialInventoryDTO.getBrand() : "");
         mapObject.put("heatNo", StrUtil.isNotBlank(materialInventoryDTO.getHeatNoAndBatchNo()) ? materialInventoryDTO.getHeatNoAndBatchNo() : "");
         mapObject.put("color", StrUtil.isNotBlank(materialInventoryDTO.getColor()) ? materialInventoryDTO.getColor() : "");
         mapObject.put("project", materialInventoryDTO.getProject() != null ? materialInventoryDTO.getProject().getSerialNumber() : "");
         mapObject.put("workshop", materialInventoryDTO.getWorkshop() != null ? materialInventoryDTO.getWorkshop().getName() : "");
         mapObject.put("warehouse", materialInventoryDTO.getWarehouse() != null ? materialInventoryDTO.getWarehouse().getName() : "");
         mapObject.put(
            "materialIsWhole", materialInventoryDTO.getMaterialIsWhole() != null ? (materialInventoryDTO.getMaterialIsWhole() == 1 ? "整料" : "余料") : "-"
         );
         mapList.add(mapObject);
      }

      map.put("mapList", mapList);
      List<Measure> measureList = this.measureService
         .list(Wrappers.lambdaQuery(Measure.class).eq(Measure::getBasicClass, BasicClassEnum.STEEL_PLATE.getType()));
      if (CollectionUtil.isNotEmpty(measureList)) {
         String accountingUnit = measureList.get(0).getAccountingUnit();
         map.put("steelAccountingUnit", accountingUnit);
      } else {
         map.put("steelAccountingUnit", "kg");
      }

      Integer type = null;
      if (BasicClassEnum.STEEL_PLATE.getType().equals(param.getBasicClass())) {
         type = ExcelEnum.STEEL_PLATE_CAN_LOSS_EXCEL.getType();
      }

      if (BasicClassEnum.SECTION_STEEL.getType().equals(param.getBasicClass())) {
         type = ExcelEnum.SECTION_STEEL_CAN_LOSS_EXCEL.getType();
      }

      if (BasicClassEnum.COLOR_ROLL.getType().equals(param.getBasicClass())) {
         type = ExcelEnum.COLOR_ROLL_CAN_LOSS_EXCEL.getType();
      }

      if (BasicClassEnum.GENERAL_MATERIAL.getType().equals(param.getBasicClass())) {
         type = ExcelEnum.GENERAL_MATERIAL_CAN_LOSS_EXCEL.getType();
      }

      if (BasicClassEnum.GAS.getType().equals(param.getBasicClass())) {
         type = ExcelEnum.GAS_CAN_LOSS_EXCEL.getType();
      }

      if (BasicClassEnum.OTHER.getType().equals(param.getBasicClass())) {
         type = ExcelEnum.OTHER_CAN_LOSS_EXCEL.getType();
      }

      if (BasicClassEnum.OTHER_STEEL_MATERIALS.getType().equals(param.getBasicClass())) {
         type = ExcelEnum.OTHER_STEEL_CAN_LOSS_EXCEL.getType();
      }

      this.downloadDeficitInventoryExcel(response, null, map, type, param.getDeficitType());
   }

   private Boolean getReceiptDetailsBoolShowAmount(Integer menuType) {
      if (AmountShowMenuEnum.INBOUND_DETAILS.getType().equals(menuType)) {
         return UserUtil.getCurrentUser().getPermissions().contains("wms_report_rawMat_inbound_details:showAmount");
      } else if (AmountShowMenuEnum.OUTBOUND_DETAILS.getType().equals(menuType)) {
         return UserUtil.getCurrentUser().getPermissions().contains("wms_report_rawMat_outbound_details:showAmount");
      } else if (AmountShowMenuEnum.RETURN_DETAILS.getType().equals(menuType)) {
         return UserUtil.getCurrentUser().getPermissions().contains("wms_report_rawMat_return_details:showAmount");
      } else if (AmountShowMenuEnum.TRANSFER_DETAILS.getType().equals(menuType)) {
         return UserUtil.getCurrentUser().getPermissions().contains("wms_report_rawMat_transfer_details:showAmount");
      } else if (AmountShowMenuEnum.MOVE_WAREHOUSE_DETAILS.getType().equals(menuType)) {
         return UserUtil.getCurrentUser().getPermissions().contains("wms_report_rawMat_remove_details:showAmount");
      } else if (AmountShowMenuEnum.REJECTED_DETAILS.getType().equals(menuType)) {
         return UserUtil.getCurrentUser().getPermissions().contains("wms_report_rawMat_reject_details:showAmount");
      } else {
         return AmountShowMenuEnum.RECEIVING_DISPATCHING_STORING.getType().equals(menuType)
            ? UserUtil.getCurrentUser().getPermissions().contains("wms_report_rawMat_sendAndReceiveStorage:showAmount")
            : true;
      }
   }
}
