package com.hzchum.scim.operational.core.biz.impl;

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
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.operational.analysis.core.api.biz.WarehouseDataAnalysisBiz;
import com.hzchum.scim.operational.analysis.core.api.enums.DateTypeEnum;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.ClassificationSimpleDTO;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.CommonHeadDTO;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.MaterialOutInCostDTO;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.enums.UnitEnum;
import com.hzchum.scim.wms.core.api.enums.UnitsPrecisionEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Classification;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Measure;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Unit;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.DownLoadDetailDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MoveOutboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.ReturnDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsWorkshop;
import com.hzchum.scim.wms.core.api.pojo.dto.common.CommonDetailSimpleDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.CommonSummaryDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ClassCostDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ClassifyCostDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.DateCostDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialInventorySimpleDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MonthInventoryCostDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ProjectOutSummaryDTO;
import com.hzchum.scim.wms.core.api.service.wmsConfig.ClassificationService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.MeasureService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.UnitService;
import com.hzchum.scim.wms.core.api.service.wmsReport.ReportService;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MoveOutboundDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsWorkshopService;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class WarehouseDataAnalysisBizImpl implements WarehouseDataAnalysisBiz {
   private static final Logger log = LoggerFactory.getLogger(WarehouseDataAnalysisBizImpl.class);
   @Resource
   private ReportService reportService;
   @Resource
   private InboundDetailService inboundDetailService;
   @Resource
   private MoveOutboundDetailService moveOutboundDetailService;
   @Resource
   private MeasureService measureService;
   @Resource
   private ClassificationService classificationService;
   @Resource
   private TechArtifactService techArtifactService;
   @Resource
   private BranchCompanyService branchCompanyService;
   @Resource
   private WmsWorkshopService workshopService;
   @Resource
   private ContractProjectService projectService;
   @Resource
   private UnitService unitService;
   private static final Integer TON_DIGIT = 0;
   private static final Integer WAN_YUAN = 0;

   @Override
   public List<ClassCostDTO> getSteelsInventoryInventory(LocalDate yearDate, Long branchCompanyId, Long workshopId) {
      return this.reportService.getOperationsAnalysisInventory(yearDate, 263, branchCompanyId, workshopId);
   }

   @Override
   public List<ClassifyCostDTO> getAuxiliaryOrOtherInventory(LocalDate yearDate, Integer basicClass, Long branchCompanyId, Long workshopId) {
      return this.reportService.getAuxiliaryOrOtherInventory(yearDate, basicClass, branchCompanyId, workshopId);
   }

   @Override
   public PageVO<MaterialInventorySimpleDTO> getInventorySimpleDTOPage(
      LocalDate yearDate, Integer basicClass, Long classifyId, Long branchCompanyId, Long workshopId, Integer pageNumber, Integer pageSize
   ) {
      return this.reportService.getInventorySimpleDTOPage(yearDate, basicClass, classifyId, branchCompanyId, workshopId, pageNumber, pageSize);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> getInventorySimpleDTOPrint(
      LocalDate yearDate, Integer basicClass, Long classifyId, Long branchCompanyId, Long workshopId
   ) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      CommonHeadDTO headDTO = this.getWarehouseDataAnalysisHeadDTO(yearDate, branchCompanyId, workshopId, DateTypeEnum.YEAR.getType());
      Map<String, Object> commonHeadMap = BeanUtil.beanToMap(headDTO);
      header.putAll(commonHeadMap);
      printVO.setHeader(header);
      List<MaterialInventorySimpleDTO> resultList = this.reportService.getInventorySimpleDTOList(yearDate, basicClass, classifyId, branchCompanyId, workshopId);
      List<Map<String, Object>> mapList = resultList.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public void getInventorySimpleDTODownload(LocalDate yearMouthDate, Integer basicClass, Long classifyId, Long branchCompanyId, Long workshopId) {
      CommonHeadDTO headDTO = this.getWarehouseDataAnalysisHeadDTO(yearMouthDate, branchCompanyId, workshopId, DateTypeEnum.YEAR.getType());
      Map<String, Object> resultMap = BeanUtil.beanToMap(headDTO);
      List<MaterialInventorySimpleDTO> resultList = this.reportService
         .getInventorySimpleDTOList(yearMouthDate, basicClass, classifyId, branchCompanyId, workshopId);
      AtomicReference<Long> orderNo = new AtomicReference<>(0L);
      resultList.forEach(e -> {
         orderNo.set(orderNo.get() + 1L);
         e.setIndex(orderNo.get());
      });
      resultMap.put("resultList", resultList);
      String tempFileName = "ResourcePlan";
      String resourcePath = "files/InventorySimpleDetails.xlsx";
      String exportFileName = "年度库存详情.xlsx";
      this.download(resultMap, tempFileName, resourcePath, exportFileName);
   }

   @Override
   public List<DateCostDTO> getOperationsAnalysisInventoryGroupByMonth(LocalDate yearDate, Integer basicClass, Long branchCompanyId, Long workshopId) {
      return this.reportService.getOperationsAnalysisInventoryGroupByMonth(yearDate, basicClass, branchCompanyId, workshopId);
   }

   @Override
   public PageVO<MaterialInventorySimpleDTO> getOperationsAnalysisInventoryGroupByMonthPageList(
      LocalDate yearMouthDate, Integer basicClass, Long classifyId, Long branchCompanyId, Long workshopId, Integer pageNumber, Integer pageSize
   ) {
      return this.reportService
         .getOperationsAnalysisInventoryGroupByMonthPageList(yearMouthDate, basicClass, classifyId, branchCompanyId, workshopId, pageNumber, pageSize);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> getOperationsAnalysisInventoryGroupByMonthPrint(
      LocalDate yearMouthDate, Integer basicClass, Long classifyId, Long branchCompanyId, Long workshopId
   ) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      CommonHeadDTO headDTO = this.getWarehouseDataAnalysisHeadDTO(yearMouthDate, branchCompanyId, workshopId, DateTypeEnum.YEAR.getType());
      Map<String, Object> commonHeadMap = BeanUtil.beanToMap(headDTO);
      header.putAll(commonHeadMap);
      printVO.setHeader(header);
      List<MaterialInventorySimpleDTO> resultList = this.reportService
         .getOperationsAnalysisInventoryGroupByMonthList(yearMouthDate, basicClass, classifyId, branchCompanyId, workshopId);
      List<Map<String, Object>> mapList = resultList.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public void getOperationsAnalysisInventoryGroupByMonthDownload(
      LocalDate yearMouthDate, Integer basicClass, Long classifyId, Long branchCompanyId, Long workshopId
   ) {
      CommonHeadDTO headDTO = this.getWarehouseDataAnalysisHeadDTO(yearMouthDate, branchCompanyId, workshopId, DateTypeEnum.MONTH.getType());
      Map<String, Object> resultMap = BeanUtil.beanToMap(headDTO);
      List<MaterialInventorySimpleDTO> resultList = this.reportService
         .getOperationsAnalysisInventoryGroupByMonthList(yearMouthDate, basicClass, classifyId, branchCompanyId, workshopId);
      AtomicReference<Long> orderNo = new AtomicReference<>(0L);
      resultList.forEach(e -> {
         orderNo.set(orderNo.get() + 1L);
         e.setIndex(orderNo.get());
      });
      resultMap.put("resultList", resultList);
      String tempFileName = "ResourcePlan";
      String resourcePath = "files/InventorySimpleDetails.xlsx";
      String exportFileName = "月度库存详情.xlsx";
      this.download(resultMap, tempFileName, resourcePath, exportFileName);
   }

   @Override
   public Map<String, Object> getMainMaterialOutInMete(Integer basicClass, LocalDate yearDate, Long branchCompanyId, Long workshopId) {
      Map<String, BigDecimal> inMeteMap = this.inboundDetailService
         .getMaterialInboundMete(basicClass, null, yearDate, branchCompanyId, workshopId)
         .stream()
         .collect(Collectors.toMap(CommonSummaryDTO::getDateTime, CommonSummaryDTO::getTotalCost));
      Map<String, BigDecimal> outMeteMap = this.moveOutboundDetailService
         .getMaterialOutMeteV2(basicClass, null, yearDate, branchCompanyId, workshopId)
         .stream()
         .collect(Collectors.toMap(CommonSummaryDTO::getDateTime, CommonSummaryDTO::getTotalCost));
      ArrayList<CommonSummaryDTO> inMeteList = new ArrayList<>();
      ArrayList<CommonSummaryDTO> outMeteList = new ArrayList<>();

      for (int i = 1; i <= 12; i++) {
         String dateTime = yearDate.getYear() + "-" + String.format("%02d", i);
         inMeteList.add(CommonSummaryDTO.builder().dateTime(dateTime).totalMete(inMeteMap.getOrDefault(dateTime, BigDecimal.ZERO)).build());
         outMeteList.add(CommonSummaryDTO.builder().dateTime(dateTime).totalMete(outMeteMap.getOrDefault(dateTime, BigDecimal.ZERO)).build());
      }

      Map<String, Object> resultMap = new HashMap<>();
      resultMap.put("inMeteList", inMeteList);
      resultMap.put("outMeteList", outMeteList);
      return resultMap;
   }

   @Override
   public Map<String, Object> getAuxiliaryMaterialOutInMete(Long classifyId, LocalDate yearDate, Long branchCompanyId, Long workshopId) {
      List<Long> endLeveList = this.getAuxiliaryClassifyIds(classifyId);
      Map<String, BigDecimal> inCostMap = this.inboundDetailService
         .getMaterialInboundMete(BasicClassEnum.GENERAL_MATERIAL.getType(), endLeveList, yearDate, branchCompanyId, workshopId)
         .stream()
         .collect(Collectors.toMap(CommonSummaryDTO::getDateTime, CommonSummaryDTO::getTotalCost));
      Map<String, BigDecimal> outCostMap = this.moveOutboundDetailService
         .getMaterialOutMeteV2(BasicClassEnum.GENERAL_MATERIAL.getType(), endLeveList, yearDate, branchCompanyId, workshopId)
         .stream()
         .collect(Collectors.toMap(CommonSummaryDTO::getDateTime, CommonSummaryDTO::getTotalCost));
      ArrayList<CommonSummaryDTO> inMeteList = new ArrayList<>();
      ArrayList<CommonSummaryDTO> outMeteList = new ArrayList<>();

      for (int i = 1; i <= 12; i++) {
         String dateTime = yearDate.getYear() + "-" + String.format("%02d", i);
         inMeteList.add(CommonSummaryDTO.builder().dateTime(dateTime).totalCost(inCostMap.getOrDefault(dateTime, BigDecimal.ZERO).setScale(0, 4)).build());
         outMeteList.add(CommonSummaryDTO.builder().dateTime(dateTime).totalCost(outCostMap.getOrDefault(dateTime, BigDecimal.ZERO).setScale(0, 4)).build());
      }

      Map<String, Object> resultMap = new HashMap<>();
      resultMap.put("inCostList", inMeteList);
      resultMap.put("outCostList", outMeteList);
      return resultMap;
   }

   @Override
   public List<MaterialOutInCostDTO> getMaterialOutInCost(Integer basicClass, LocalDate yearDate, Long branchCompanyId, Long workshopId) {
      Map<String, BigDecimal> inCostMap = this.inboundDetailService
         .getMaterialInboundMete(basicClass, null, yearDate, branchCompanyId, workshopId)
         .stream()
         .collect(Collectors.toMap(CommonSummaryDTO::getDateTime, CommonSummaryDTO::getTotalCost));
      Map<String, BigDecimal> outCostMap = this.moveOutboundDetailService
         .getMaterialOutMeteV2(basicClass, null, yearDate, branchCompanyId, workshopId)
         .stream()
         .collect(Collectors.toMap(CommonSummaryDTO::getDateTime, CommonSummaryDTO::getTotalCost));
      ArrayList<MaterialOutInCostDTO> resultList = new ArrayList<>();

      for (int i = 1; i <= 12; i++) {
         String dateTime = yearDate.getYear() + "-" + String.format("%02d", i);
         resultList.add(
            MaterialOutInCostDTO.builder()
               .dateTime(dateTime)
               .inCost(inCostMap.getOrDefault(dateTime, BigDecimal.ZERO).setScale(0, 4))
               .outCost(outCostMap.getOrDefault(dateTime, BigDecimal.ZERO).setScale(0, 4))
               .build()
         );
      }

      return resultList;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> getMaterialOutInCostPrint(Integer basicClass, LocalDate yearDate, Long branchCompanyId, Long workshopId) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      CommonHeadDTO headDTO = this.getWarehouseDataAnalysisHeadDTO(yearDate, branchCompanyId, workshopId, DateTypeEnum.YEAR.getType());
      Map<String, Object> commonHeadMap = BeanUtil.beanToMap(headDTO);
      header.putAll(commonHeadMap);
      List<MaterialOutInCostDTO> resultList = this.getMaterialOutInCost(basicClass, yearDate, branchCompanyId, workshopId);
      resultList.forEach(e -> {
         e.setOutCost(e.getOutCost().divide(BigDecimal.valueOf(10000L), 0, 4));
         e.setInCost(e.getInCost().divide(BigDecimal.valueOf(10000L), 0, 4));
      });
      printVO.setHeader(header);
      List<Map<String, Object>> mapList = resultList.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public void getMaterialOutInCostDownload(Integer basicClass, LocalDate mouthDate, Long branchCompanyId, Long workshopId) {
      CommonHeadDTO headDTO = this.getWarehouseDataAnalysisHeadDTO(mouthDate, branchCompanyId, workshopId, DateTypeEnum.YEAR.getType());
      Map<String, Object> resultMap = BeanUtil.beanToMap(headDTO);
      List<MaterialOutInCostDTO> resultList = this.getMaterialOutInCost(basicClass, mouthDate, branchCompanyId, workshopId);
      AtomicReference<Long> orderNo = new AtomicReference<>(0L);
      resultList.forEach(
         e -> {
            orderNo.set(orderNo.get() + 1L);
            e.setIndex(orderNo.get());
            e.setRatio(
               e.getOutCost().compareTo(BigDecimal.ZERO) != 0 && e.getInCost().compareTo(BigDecimal.ZERO) != 0
                  ? e.getOutCost().multiply(BigDecimal.valueOf(100L)).divide(e.getInCost(), 2, 4)
                  : BigDecimal.ZERO
            );
         }
      );
      resultMap.put("resultList", resultList);
      String tempFileName = "ResourcePlan";
      String resourcePath = "files/MaterialOutInCostDetails.xlsx";
      String exportFileName = "库存周转详情.xlsx";
      this.download(resultMap, tempFileName, resourcePath, exportFileName);
   }

   @Override
   public PageVO<CommonDetailSimpleDTO> getMaterialInRecord(
      Integer basicClass, Long classifyId, LocalDate mouthDate, Long branchCompanyId, Long workshopId, Integer pageNumber, Integer pageSize
   ) {
      List<Long> endLeveList = this.getEndLeveList(classifyId);
      Page page = PageHelper.startPage(pageNumber, pageSize);
      List<InboundDetail> inDetailList = this.inboundDetailService
         .getOperationsAnalysisInboundDetail(basicClass, endLeveList, mouthDate, branchCompanyId, workshopId);
      if (CollectionUtil.isEmpty(inDetailList)) {
         return new PageVO<>();
      }

      List<CommonDetailSimpleDTO> simpleDTOList = this.getInRecordDTO(inDetailList);
      return new PageVO<>(page, simpleDTOList);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> getMaterialInRecordPrint(
      Integer basicClass, Long classifyId, LocalDate mouthDate, Long branchCompanyId, Long workshopId
   ) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      CommonHeadDTO headDTO = this.getWarehouseDataAnalysisHeadDTO(mouthDate, branchCompanyId, workshopId, DateTypeEnum.MONTH.getType());
      Map<String, Object> commonHeadMap = BeanUtil.beanToMap(headDTO);
      header.putAll(commonHeadMap);
      List<Long> endLeveList = this.getEndLeveList(classifyId);
      List<InboundDetail> inDetailList = this.inboundDetailService
         .getOperationsAnalysisInboundDetail(basicClass, endLeveList, mouthDate, branchCompanyId, workshopId);
      List<CommonDetailSimpleDTO> resultList = this.getInRecordDTO(inDetailList);
      printVO.setHeader(header);
      List<Map<String, Object>> mapList = resultList.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public void getMaterialInRecordDownload(Integer basicClass, Long classifyId, LocalDate mouthDate, Long branchCompanyId, Long workshopId) {
      CommonHeadDTO headDTO = this.getWarehouseDataAnalysisHeadDTO(mouthDate, branchCompanyId, workshopId, DateTypeEnum.MONTH.getType());
      Map<String, Object> resultMap = BeanUtil.beanToMap(headDTO);
      List<Long> endLeveList = this.getEndLeveList(classifyId);
      List<InboundDetail> inDetailList = this.inboundDetailService
         .getOperationsAnalysisInboundDetail(basicClass, endLeveList, mouthDate, branchCompanyId, workshopId);
      List<CommonDetailSimpleDTO> resultList = this.getInRecordDTOV2(inDetailList);
      AtomicReference<Long> orderNo = new AtomicReference<>(0L);
      resultList.forEach(e -> {
         orderNo.set(orderNo.get() + 1L);
         e.setIndex(orderNo.get());
      });
      resultMap.put("resultList", resultList);
      String tempFileName = "ResourcePlan";
      String resourcePath = "files/InventorySimpleDetails.xlsx";
      String exportFileName = "入库详情.xlsx";
      this.download(resultMap, tempFileName, resourcePath, exportFileName);
   }

   @Override
   public List<ProjectOutSummaryDTO> getProjectOutSummaryList(Integer status, LocalDate yearDate, Long branchCompanyId, Long workshopId) {
      List<ProjectOutSummaryDTO> outSummaryList = this.moveOutboundDetailService.getProjectOutSummaryList(status, 263, yearDate, branchCompanyId, workshopId);
      outSummaryList.forEach(e -> {
         BigDecimal deepenMete = this.techArtifactService.selectListQuantity(e.getProject().getId());
         e.setDeepenMete(deepenMete == null ? BigDecimal.ZERO : deepenMete);
      });
      outSummaryList.sort((o1, o2) -> o2.getOutMete().compareTo(o1.getOutMete()));
      return outSummaryList;
   }

   @Override
   public Map<String, List<CommonDetailSimpleDTO>> getProjectOutDetailList(
      Long projectId, LocalDate yearDate, LocalDate mouthDate, Long branchCompanyId, Long workshopId
   ) {
      HashMap<String, List<CommonDetailSimpleDTO>> resultMap = new HashMap<>();
      resultMap.put("outDetailsList", new ArrayList<>());
      resultMap.put("returnDetailList", new ArrayList<>());
      List<MoveOutboundDetail> outDetailsList = this.moveOutboundDetailService
         .getOperationsAnalysisOutDetails(263, null, projectId, yearDate, mouthDate, branchCompanyId, workshopId);
      List<ReturnDetail> returnDetailList = this.reportService
         .getOperationsAnalysisReturnDetails(263, null, projectId, yearDate, mouthDate, branchCompanyId, workshopId);
      if (CollectionUtil.isNotEmpty(outDetailsList)) {
         List<Long> classifyIds = outDetailsList.stream().map(MoveOutboundDetail::getClassifyId).distinct().collect(Collectors.toList());
         Map<Long, String> classifyNameMap = this.classificationService
            .list((Wrapper<Classification>)new LambdaQueryWrapper<Classification>().in(Classification::getId, classifyIds))
            .stream()
            .collect(Collectors.toMap(Classification::getId, Classification::getName));
         List<CommonDetailSimpleDTO> simpleDTOList = outDetailsList.stream().map(outDetail -> {
            CommonDetailSimpleDTO simpleDTO = BeanUtil.copy(outDetail, CommonDetailSimpleDTO.class);
            simpleDTO.setClassifyName(classifyNameMap.getOrDefault(outDetail.getClassifyId(), null));
            simpleDTO.setAmountExcludingVAT(outDetail.getAmountExcludingVat());
            simpleDTO.setAccountingUnit("kg");
            simpleDTO.setMete(outDetail.getMete().divide(BigDecimal.valueOf(1000L)));
            DownLoadDetailDO detailDO = BeanUtil.copy(outDetail, DownLoadDetailDO.class);
            StringBuilder sb = new StringBuilder();
            StringBuilder lengths = new StringBuilder();
            StringBuilder material = new StringBuilder();
            this.setSpecs(detailDO, sb, lengths, material);
            StringBuilder model = new StringBuilder();
            if (ObjectUtil.isNotEmpty(sb)) {
               model.append(sb);
            }

            if (BasicClassEnum.STEEL_PLATE.getType().equals(outDetail.getBasicClass()) && ObjectUtil.isNotEmpty(lengths)) {
               model.append("*").append(lengths);
            }

            simpleDTO.setSpecification(model.toString().replace(" ", ""));
            simpleDTO.setMaterial(material.toString().replace(" ", ""));
            return simpleDTO;
         }).collect(Collectors.toList());
         resultMap.put("outDetailsList", simpleDTOList);
      }

      if (CollectionUtil.isNotEmpty(returnDetailList)) {
         List<Long> classifyIds = returnDetailList.stream().map(ReturnDetail::getClassifyId).distinct().collect(Collectors.toList());
         Map<Long, String> classifyNameMap = this.classificationService
            .list((Wrapper<Classification>)new LambdaQueryWrapper<Classification>().in(Classification::getId, classifyIds))
            .stream()
            .collect(Collectors.toMap(Classification::getId, Classification::getName));
         List<CommonDetailSimpleDTO> simpleDTOList = returnDetailList.stream().map(detail -> {
            CommonDetailSimpleDTO simpleDTO = BeanUtil.copy(detail, CommonDetailSimpleDTO.class);
            simpleDTO.setClassifyName(classifyNameMap.getOrDefault(detail.getClassifyId(), null));
            simpleDTO.setAccountingUnit("kg");
            simpleDTO.setAmountExcludingVAT(detail.getAmountExcludingVat());
            simpleDTO.setMete(detail.getMete().divide(BigDecimal.valueOf(1000L)));
            DownLoadDetailDO detailDO = BeanUtil.copy(detail, DownLoadDetailDO.class);
            StringBuilder sb = new StringBuilder();
            StringBuilder lengths = new StringBuilder();
            StringBuilder material = new StringBuilder();
            this.setSpecs(detailDO, sb, lengths, material);
            StringBuilder model = new StringBuilder();
            if (ObjectUtil.isNotEmpty(sb)) {
               model.append(sb);
            }

            if (BasicClassEnum.STEEL_PLATE.getType().equals(detail.getBasicClass()) && ObjectUtil.isNotEmpty(lengths)) {
               model.append("*").append(lengths);
            }

            simpleDTO.setSpecification(model.toString().replace(" ", ""));
            simpleDTO.setMaterial(material.toString().replace(" ", ""));
            return simpleDTO;
         }).collect(Collectors.toList());
         resultMap.put("returnDetailList", simpleDTOList);
      }

      return resultMap;
   }

   @Override
   public void downloadProjectOutDetailList(Long projectId, LocalDate yearDate, LocalDate mouthDate, Long branchCompanyId, Long workshopId) {
      Map<String, List<CommonDetailSimpleDTO>> detailMap = this.getProjectOutDetailList(projectId, yearDate, mouthDate, branchCompanyId, workshopId);
      List<CommonDetailSimpleDTO> outDetailsList = detailMap.get("outDetailsList");
      List<CommonDetailSimpleDTO> returnDetailList = detailMap.get("returnDetailList");
      BigDecimal outMete = outDetailsList.stream().map(CommonDetailSimpleDTO::getMete).reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal returnMete = returnDetailList.stream().map(CommonDetailSimpleDTO::getMete).reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal actualMte = outMete.subtract(returnMete);
      Map<String, Object> result = new HashMap<>(detailMap);
      result.put("outMete", outMete);
      result.put("returnMete", returnMete);
      result.put("actualMte", actualMte);
      CommonHeadDTO headDTO = this.getWarehouseDataAnalysisHeadDTO(yearDate, branchCompanyId, workshopId, DateTypeEnum.YEAR.getType());
      Map<String, Object> headMap = BeanUtil.beanToMap(headDTO);
      result.putAll(headMap);
      ContractProject project = this.projectService.getById(projectId);
      result.put("projectName", project != null ? project.getName() : "");
      String tempFileName = "ResourcePlan";
      String resourcePath = "files/wmsOutDetail.xlsx";
      String exportFileName = "项目出库详情(体现退库).xlsx";
      this.download(result, tempFileName, resourcePath, exportFileName);
   }

   @Override
   public List<ClassificationSimpleDTO> getAuxiliaryOneLevel() {
      List<Classification> classificationList = this.classificationService
         .list(
            (Wrapper<Classification>)(new LambdaQueryWrapper<Classification>().eq(Classification::getBasicClass, BasicClassEnum.GENERAL_MATERIAL.getType()))
               .eq(Classification::getLevel, 1)
         );
      return CollectionUtil.isEmpty(classificationList) ? new ArrayList<>() : classificationList.stream().map(e -> {
         ClassificationSimpleDTO copy = BeanUtil.copy(e, ClassificationSimpleDTO.class);
         copy.setClassifyId(e.getId());
         return copy;
      }).collect(Collectors.toList());
   }

   @Override
   public List<DateCostDTO> getSurplusMaterialInventoryGroupByMonth(LocalDate yearDate, Long branchCompanyId, Long workshopId) {
      List<DateCostDTO> groupByMonth = this.reportService.getInventoryGroupByMonth(yearDate, branchCompanyId, 2, 263);
      groupByMonth.forEach(e -> {
         BigDecimal mete = e.getMete().divide(BigDecimal.valueOf(1000000L), 2, RoundingMode.HALF_UP);
         if (mete.compareTo(BigDecimal.ZERO) != 0) {
            e.setAvgUnitPriceExcludingVAT(e.getAmountExcludingVAT().divide(mete, 0, RoundingMode.HALF_UP));
         } else {
            e.setAvgUnitPriceExcludingVAT(BigDecimal.ZERO);
         }
      });
      return groupByMonth;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> getSurplusMaterialInventoryGroupByMonthPrint(LocalDate yearDate, Long branchCompanyId, Long workshopId) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      CommonHeadDTO headDTO = this.getWarehouseDataAnalysisHeadDTO(yearDate, branchCompanyId, workshopId, DateTypeEnum.YEAR.getType());
      Map<String, Object> commonHeadMap = BeanUtil.beanToMap(headDTO);
      header.putAll(commonHeadMap);
      List<DateCostDTO> resultList = this.getSurplusMaterialInventoryGroupByMonth(yearDate, branchCompanyId, workshopId);
      printVO.setHeader(header);
      List<Map<String, Object>> mapList = resultList.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public void getSurplusMaterialInventoryGroupByMonthDownload(LocalDate yearDate, Long branchCompanyId, Long workshopId) {
      CommonHeadDTO headDTO = this.getWarehouseDataAnalysisHeadDTO(yearDate, branchCompanyId, workshopId, DateTypeEnum.YEAR.getType());
      Map<String, Object> resultMap = BeanUtil.beanToMap(headDTO);
      List<DateCostDTO> resultList = this.getSurplusMaterialInventoryGroupByMonth(yearDate, branchCompanyId, workshopId);
      AtomicReference<Long> orderNo = new AtomicReference<>(0L);
      resultList.forEach(e -> {
         orderNo.set(orderNo.get() + 1L);
         e.setIndex(orderNo.get());
         e.setMete(e.getMete().divide(BigDecimal.valueOf(1000000L), 0, RoundingMode.HALF_UP));
      });
      resultMap.put("resultList", resultList);
      String tempFileName = "ResourcePlan";
      String resourcePath = "files/SurplusMaterialInventoryDetails.xlsx";
      String exportFileName = "余料库存详情.xlsx";
      this.download(resultMap, tempFileName, resourcePath, exportFileName);
   }

   @Override
   public List<ClassCostDTO> getInventoryCost(LocalDate yearDate, Long branchCompanyId) {
      return this.reportService.getInventoryAnalysis(yearDate, branchCompanyId);
   }

   @Override
   public List<MonthInventoryCostDTO> getInventoryInventoryCostDetail(LocalDate yearDate, Long branchCompanyId, Integer basicClass) {
      return this.reportService.getInventoryInventoryCostDetail(yearDate, branchCompanyId, basicClass);
   }

   @Override
   public void getInventoryInventoryCostDetailDownload(LocalDate yearDate, Long branchCompanyId, Integer basicClass, HttpServletResponse response) {
      List<MonthInventoryCostDTO> dtoList = this.getInventoryInventoryCostDetail(yearDate, branchCompanyId, basicClass);
      if (!CollectionUtils.isEmpty(dtoList)) {
         String title = "";
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
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
         headList.add(Arrays.asList(title, "库存金额（万元）"));
         headList.add(Arrays.asList(title, "占比"));
         List<List<Object>> dataList = new ArrayList<>();
         dtoList.forEach(ex -> {
            List<Object> data = new ArrayList<>();
            data.add(index.incrementAndGet());
            data.add(ex.getClassName());
            data.add(ex.getAmountExcludingVAT().divide(BigDecimal.valueOf(10000L), 0, RoundingMode.HALF_UP));
            data.add(ex.getRatio());
            dataList.add(data);
         });

         try {
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            String fileName = StrUtil.concat(true, "实时库存详情.xlsx");
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
               .sheet("实时库存详情表")
               .doWrite(dataList);
         } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
         }
      }
   }

   @Override
   public List<DateCostDTO> getInventoryGroupByMonth(LocalDate yearDate, Long branchCompanyId) {
      return this.reportService.getInventoryGroupByMonth(yearDate, branchCompanyId, null, null);
   }

   @Override
   public List<MonthInventoryCostDTO> getInventoryGroupByMonthDetail(LocalDate monthDate, Long branchCompanyId) {
      return this.reportService.getInventoryGroupByMonthDetail(monthDate, branchCompanyId);
   }

   @Override
   public void getInventoryGroupByMonthDetailDownload(LocalDate mouthDate, Long branchCompanyId) {
      CommonHeadDTO headDTO = this.getWarehouseDataAnalysisHeadDTO(mouthDate, branchCompanyId, null, DateTypeEnum.YEAR.getType());
      Map<String, Object> resultMap = BeanUtil.beanToMap(headDTO);
      List<MonthInventoryCostDTO> resultList = this.getInventoryGroupByMonthDetail(mouthDate, branchCompanyId);
      resultList.forEach(e -> e.setAmountExcludingVAT(e.getAmountExcludingVAT().divide(BigDecimal.valueOf(10000L), 0, RoundingMode.HALF_UP)));
      resultMap.put("resultList", resultList);
      String tempFileName = "ResourcePlan";
      String resourcePath = "files/InventoryMonthlyBalance.xlsx";
      String exportFileName = "月度库存结存详情.xlsx";
      this.download(resultMap, tempFileName, resourcePath, exportFileName);
   }

   @Override
   public void getOutInCostGroupByMonth(Integer basicClass, Long classifyId, LocalDate yearDate, Long branchCompanyId, Long workshopId) {
      boolean auxiliary = BasicClassEnum.GENERAL_MATERIAL.getType().equals(basicClass);
      List<Long> endLeveList = auxiliary ? this.getAuxiliaryClassifyIds(classifyId) : this.getEndLeveList(classifyId);
      int amountScale = auxiliary ? 4 : 0;

      Map<String, BigDecimal> inMap = this.inboundDetailService
         .getMaterialInboundMete(basicClass, endLeveList, yearDate, branchCompanyId, workshopId)
         .stream()
         .collect(Collectors.toMap(CommonSummaryDTO::getDateTime, CommonSummaryDTO::getTotalCost));
      Map<String, BigDecimal> outMap = this.moveOutboundDetailService
         .getMaterialOutMeteV2(basicClass, endLeveList, yearDate, branchCompanyId, workshopId)
         .stream()
         .collect(Collectors.toMap(CommonSummaryDTO::getDateTime, CommonSummaryDTO::getTotalCost));
      ArrayList<MaterialOutInCostDTO> resultList = new ArrayList<>();

      for (int i = 1; i <= 12; i++) {
         String key = yearDate.getYear() + "-" + String.format("%02d", i);
         MaterialOutInCostDTO build = MaterialOutInCostDTO.builder()
            .dateTime(key)
            .index((long)i)
            .inCost(inMap.getOrDefault(key, BigDecimal.ZERO).divide(BigDecimal.valueOf(10000L), amountScale, RoundingMode.HALF_UP))
            .outCost(outMap.getOrDefault(key, BigDecimal.ZERO).divide(BigDecimal.valueOf(10000L), amountScale, RoundingMode.HALF_UP))
            .build();
         resultList.add(build);
      }

      CommonHeadDTO headDTO = this.getWarehouseDataAnalysisHeadDTO(yearDate, branchCompanyId, workshopId, DateTypeEnum.YEAR.getType());
      Map<String, Object> resultMap = BeanUtil.beanToMap(headDTO);
      resultMap.put("resultList", resultList);
      String tempFileName = "ResourcePlan";
      String resourcePath = "files/OutInCost.xlsx";
      String exportFileName = "年度出入库费用详情.xlsx";
      this.download(resultMap, tempFileName, resourcePath, exportFileName);
   }

   @Override
   public PageVO<CommonDetailSimpleDTO> getMaterialOutRecord(
      Integer basicClass, Long classifyId, LocalDate mouthDate, Long branchCompanyId, Long workshopId, Integer pageNumber, Integer pageSize
   ) {
      List<Long> endLeveList = this.getEndLeveList(classifyId);
      Page page = PageHelper.startPage(pageNumber, pageSize);
      List<MoveOutboundDetail> outDetailList = this.moveOutboundDetailService
         .getOperationsAnalysisOutDetails(basicClass, endLeveList, null, null, mouthDate, branchCompanyId, workshopId);
      if (CollectionUtil.isEmpty(outDetailList)) {
         return new PageVO<>();
      }

      List<CommonDetailSimpleDTO> simpleDTOList = this.getOutRecordDTO(outDetailList);
      return new PageVO<>(page, simpleDTOList);
   }

   private List<CommonDetailSimpleDTO> getInRecordDTO(List<InboundDetail> inDetailList) {
      if (CollectionUtil.isEmpty(inDetailList)) {
         return new ArrayList<>();
      }

      List<Long> classifyIds = inDetailList.stream().map(InboundDetail::getClassifyId).distinct().collect(Collectors.toList());
      Map<Long, String> accountingUnitMap = this.measureService
         .list((Wrapper<Measure>)new LambdaQueryWrapper<Measure>().in(Measure::getClassificationId, classifyIds))
         .stream()
         .collect(Collectors.toMap(Measure::getClassificationId, Measure::getAccountingUnit));
      Map<Long, String> classifyNameMap = this.classificationService
         .list((Wrapper<Classification>)new LambdaQueryWrapper<Classification>().in(Classification::getId, classifyIds))
         .stream()
         .collect(Collectors.toMap(Classification::getId, Classification::getName));
      return inDetailList.stream().map(inboundDetail -> {
         CommonDetailSimpleDTO simpleDTO = BeanUtil.copy(inboundDetail, CommonDetailSimpleDTO.class);
         simpleDTO.setClassifyName(classifyNameMap.getOrDefault(inboundDetail.getClassifyId(), null));
         simpleDTO.setAccountingUnit(accountingUnitMap.getOrDefault(inboundDetail.getClassifyId(), null));
         simpleDTO.setAmountExcludingVAT(inboundDetail.getAmountExcludingVat());
         simpleDTO.setUnitPriceExcludingVAT(inboundDetail.getUnitPriceExcludingVat());
         DownLoadDetailDO detailDO = BeanUtil.copy(inboundDetail, DownLoadDetailDO.class);
         StringBuilder sb = new StringBuilder();
         StringBuilder lengths = new StringBuilder();
         StringBuilder material = new StringBuilder();
         this.setSpecs(detailDO, sb, lengths, material);
         StringBuilder model = new StringBuilder();
         if (ObjectUtil.isNotEmpty(sb)) {
            model.append(sb);
         }

         if (BasicClassEnum.STEEL_PLATE.getType().equals(inboundDetail.getBasicClass())) {
            if (ObjectUtil.isNotEmpty(lengths)) {
               model.append("*").append(lengths);
            }

            if (ObjectUtil.isNotEmpty(material)) {
               model.append("*").append(material);
            }
         }

         if (BasicClassEnum.SECTION_STEEL.getType().equals(inboundDetail.getBasicClass()) && ObjectUtil.isNotEmpty(material)) {
            model.append("*").append(material);
         }

         simpleDTO.setSpecification(model.toString().replace(" ", ""));
         return simpleDTO;
      }).collect(Collectors.toList());
   }

   private List<CommonDetailSimpleDTO> getInRecordDTOV2(List<InboundDetail> inDetailList) {
      if (CollectionUtil.isEmpty(inDetailList)) {
         return new ArrayList<>();
      }

      List<Long> classifyIds = inDetailList.stream().map(InboundDetail::getClassifyId).distinct().collect(Collectors.toList());
      Map<String, Unit> unitMap = this.unitService.list(new LambdaQueryWrapper<>()).stream().collect(Collectors.toMap(Unit::getName, Function.identity()));
      Map<Long, Measure> measureMap = this.measureService
         .list(new LambdaQueryWrapper<>())
         .stream()
         .collect(Collectors.toMap(Measure::getClassificationId, Function.identity()));
      Map<Long, Classification> classificationMap = this.classificationService
         .list()
         .stream()
         .collect(Collectors.toMap(Classification::getId, Function.identity()));
      Map<Long, String> classifyNameMap = this.classificationService
         .list((Wrapper<Classification>)new LambdaQueryWrapper<Classification>().in(Classification::getId, classifyIds))
         .stream()
         .collect(Collectors.toMap(Classification::getId, Classification::getName));
      return inDetailList.stream().map(inboundDetail -> {
         CommonDetailSimpleDTO simpleDTO = BeanUtil.copy(inboundDetail, CommonDetailSimpleDTO.class);
         simpleDTO.setClassifyName(classifyNameMap.getOrDefault(inboundDetail.getClassifyId(), null));
         Measure measure = measureMap.get(inboundDetail.getClassifyId());
         if (StrUtil.isBlank(measure.getAccountingUnit())) {
            Classification classification = classificationMap.get(measure.getClassificationId());
            measure = this.getMeasureV2(classification.getParentId(), measureMap, classificationMap);
         }

         DownLoadDetailDO detailDO = BeanUtil.copy(inboundDetail, DownLoadDetailDO.class);
         this.setMeteV2(simpleDTO, detailDO, measure, classificationMap, measureMap, unitMap);
         simpleDTO.setAmountExcludingVAT(inboundDetail.getAmountExcludingVat());
         Map<Integer, BigDecimal> mete = this.unitConversion(inboundDetail.getMete(), measure.getAccountingUnit(), measure.getAccountingPrecision());
         simpleDTO.setUnitPriceExcludingVAT(inboundDetail.getUnitPriceExcludingVat().multiply(mete.get(2)).setScale(2, 4));
         StringBuilder sb = new StringBuilder();
         StringBuilder lengths = new StringBuilder();
         StringBuilder material = new StringBuilder();
         this.setSpecs(detailDO, sb, lengths, material);
         StringBuilder model = new StringBuilder();
         if (ObjectUtil.isNotEmpty(sb)) {
            model.append(sb);
         }

         if (BasicClassEnum.STEEL_PLATE.getType().equals(inboundDetail.getBasicClass())) {
            if (ObjectUtil.isNotEmpty(lengths)) {
               model.append("*").append(lengths);
            }

            if (ObjectUtil.isNotEmpty(material)) {
               model.append("*").append(material);
            }
         }

         if (BasicClassEnum.SECTION_STEEL.getType().equals(inboundDetail.getBasicClass()) && ObjectUtil.isNotEmpty(material)) {
            model.append("*").append(material);
         }

         simpleDTO.setSpecification(model.toString().replace(" ", ""));
         return simpleDTO;
      }).collect(Collectors.toList());
   }

   private List<CommonDetailSimpleDTO> getOutRecordDTO(List<MoveOutboundDetail> outDetailList) {
      if (CollectionUtil.isEmpty(outDetailList)) {
         return new ArrayList<>();
      }

      List<Long> classifyIds = outDetailList.stream().map(MoveOutboundDetail::getClassifyId).distinct().collect(Collectors.toList());
      Map<Long, String> accountingUnitMap = this.measureService
         .list((Wrapper<Measure>)new LambdaQueryWrapper<Measure>().in(Measure::getClassificationId, classifyIds))
         .stream()
         .collect(Collectors.toMap(Measure::getClassificationId, Measure::getAccountingUnit));
      Map<Long, String> classifyNameMap = this.classificationService
         .list((Wrapper<Classification>)new LambdaQueryWrapper<Classification>().in(Classification::getId, classifyIds))
         .stream()
         .collect(Collectors.toMap(Classification::getId, Classification::getName));
      return outDetailList.stream().map(outDetail -> {
         CommonDetailSimpleDTO simpleDTO = BeanUtil.copy(outDetail, CommonDetailSimpleDTO.class);
         simpleDTO.setClassifyName(classifyNameMap.getOrDefault(outDetail.getClassifyId(), null));
         simpleDTO.setAccountingUnit(accountingUnitMap.getOrDefault(outDetail.getClassifyId(), null));
         simpleDTO.setAmountExcludingVAT(outDetail.getAmountExcludingVat());
         simpleDTO.setUnitPriceExcludingVAT(outDetail.getUnitPriceExcludingVat());
         DownLoadDetailDO detailDO = BeanUtil.copy(outDetail, DownLoadDetailDO.class);
         StringBuilder sb = new StringBuilder();
         StringBuilder lengths = new StringBuilder();
         StringBuilder material = new StringBuilder();
         this.setSpecs(detailDO, sb, lengths, material);
         StringBuilder model = new StringBuilder();
         if (ObjectUtil.isNotEmpty(sb)) {
            model.append(sb);
         }

         if (BasicClassEnum.STEEL_PLATE.getType().equals(outDetail.getBasicClass())) {
            if (ObjectUtil.isNotEmpty(lengths)) {
               model.append("*").append(lengths);
            }

            if (ObjectUtil.isNotEmpty(material)) {
               model.append("*").append(material);
            }
         }

         if (BasicClassEnum.SECTION_STEEL.getType().equals(outDetail.getBasicClass()) && ObjectUtil.isNotEmpty(material)) {
            model.append("*").append(material);
         }

         simpleDTO.setSpecification(model.toString().replace(" ", ""));
         return simpleDTO;
      }).collect(Collectors.toList());
   }

   private List<CommonDetailSimpleDTO> getOutRecordDTOV2(List<MoveOutboundDetail> outDetailList) {
      if (CollectionUtil.isEmpty(outDetailList)) {
         return new ArrayList<>();
      }

      List<Long> classifyIds = outDetailList.stream().map(MoveOutboundDetail::getClassifyId).distinct().collect(Collectors.toList());
      Map<String, Unit> unitMap = this.unitService.list(new LambdaQueryWrapper<>()).stream().collect(Collectors.toMap(Unit::getName, Function.identity()));
      Map<Long, Measure> measureMap = this.measureService
         .list(new LambdaQueryWrapper<>())
         .stream()
         .collect(Collectors.toMap(Measure::getClassificationId, Function.identity()));
      Map<Long, Classification> classificationMap = this.classificationService
         .list()
         .stream()
         .collect(Collectors.toMap(Classification::getId, Function.identity()));
      Map<Long, String> classifyNameMap = this.classificationService
         .list((Wrapper<Classification>)new LambdaQueryWrapper<Classification>().in(Classification::getId, classifyIds))
         .stream()
         .collect(Collectors.toMap(Classification::getId, Classification::getName));
      return outDetailList.stream().map(outDetail -> {
         CommonDetailSimpleDTO simpleDTO = BeanUtil.copy(outDetail, CommonDetailSimpleDTO.class);
         simpleDTO.setClassifyName(classifyNameMap.getOrDefault(outDetail.getClassifyId(), null));
         Measure measure = measureMap.get(outDetail.getClassifyId());
         if (StrUtil.isBlank(measure.getAccountingUnit())) {
            Classification classification = classificationMap.get(measure.getClassificationId());
            measure = this.getMeasureV2(classification.getParentId(), measureMap, classificationMap);
         }

         DownLoadDetailDO detailDO = BeanUtil.copy(outDetail, DownLoadDetailDO.class);
         this.setMeteV2(simpleDTO, detailDO, measure, classificationMap, measureMap, unitMap);
         simpleDTO.setAmountExcludingVAT(outDetail.getAmountExcludingVat());
         Map<Integer, BigDecimal> mete = this.unitConversion(outDetail.getMete(), measure.getAccountingUnit(), measure.getAccountingPrecision());
         simpleDTO.setUnitPriceExcludingVAT(outDetail.getUnitPriceExcludingVat().multiply(mete.get(2)).setScale(2, 4));
         StringBuilder sb = new StringBuilder();
         StringBuilder lengths = new StringBuilder();
         StringBuilder material = new StringBuilder();
         this.setSpecs(detailDO, sb, lengths, material);
         StringBuilder model = new StringBuilder();
         if (ObjectUtil.isNotEmpty(sb)) {
            model.append(sb);
         }

         if (BasicClassEnum.STEEL_PLATE.getType().equals(outDetail.getBasicClass())) {
            if (ObjectUtil.isNotEmpty(lengths)) {
               model.append("*").append(lengths);
            }

            if (ObjectUtil.isNotEmpty(material)) {
               model.append("*").append(material);
            }
         }

         if (BasicClassEnum.SECTION_STEEL.getType().equals(outDetail.getBasicClass()) && ObjectUtil.isNotEmpty(material)) {
            model.append("*").append(material);
         }

         simpleDTO.setSpecification(model.toString().replace(" ", ""));
         return simpleDTO;
      }).collect(Collectors.toList());
   }

   @Override
   public PrintVO<List<Map<String, Object>>> getMaterialOutRecordPrint(
      Integer basicClass, Long classifyId, LocalDate mouthDate, Long branchCompanyId, Long workshopId
   ) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      CommonHeadDTO headDTO = this.getWarehouseDataAnalysisHeadDTO(mouthDate, branchCompanyId, workshopId, DateTypeEnum.MONTH.getType());
      Map<String, Object> commonHeadMap = BeanUtil.beanToMap(headDTO);
      header.putAll(commonHeadMap);
      List<Long> endLeveList = this.getEndLeveList(classifyId);
      List<MoveOutboundDetail> outDetailList = this.moveOutboundDetailService
         .getOperationsAnalysisOutDetails(basicClass, endLeveList, null, null, mouthDate, branchCompanyId, workshopId);
      List<CommonDetailSimpleDTO> resultList = this.getOutRecordDTO(outDetailList);
      printVO.setHeader(header);
      List<Map<String, Object>> mapList = resultList.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public void getMaterialOutRecordDownload(Integer basicClass, Long classifyId, LocalDate mouthDate, Long branchCompanyId, Long workshopId) {
      CommonHeadDTO headDTO = this.getWarehouseDataAnalysisHeadDTO(mouthDate, branchCompanyId, workshopId, DateTypeEnum.MONTH.getType());
      Map<String, Object> resultMap = BeanUtil.beanToMap(headDTO);
      List<Long> endLeveList = this.getEndLeveList(classifyId);
      List<MoveOutboundDetail> outDetailList = this.moveOutboundDetailService
         .getOperationsAnalysisOutDetails(basicClass, endLeveList, null, null, mouthDate, branchCompanyId, workshopId);
      List<CommonDetailSimpleDTO> resultList = this.getOutRecordDTOV2(outDetailList);
      AtomicReference<Long> orderNo = new AtomicReference<>(0L);
      resultList.forEach(e -> {
         orderNo.set(orderNo.get() + 1L);
         e.setIndex(orderNo.get());
      });
      resultMap.put("resultList", resultList);
      String tempFileName = "ResourcePlan";
      String resourcePath = "files/InventorySimpleDetails.xlsx";
      String exportFileName = "出库详情.xlsx";
      this.download(resultMap, tempFileName, resourcePath, exportFileName);
   }

   private void download(Map<String, Object> result, String tempFileName, String resourcePath, String exportFileName) {
      ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
      assert servletRequestAttributes != null;
      HttpServletResponse response = servletRequestAttributes.getResponse();
      org.springframework.core.io.Resource resource = new ClassPathResource(resourcePath);
      InputStream inputStream = null;

      try {
         inputStream = resource.getInputStream();
      } catch (IOException e) {
         e.printStackTrace();
      }

      File file = null;

      try {
         file = File.createTempFile(tempFileName, "xlsx");
      } catch (IOException e) {
         e.printStackTrace();
      }

      FileUtil.copyInputStreamToFile(inputStream, file);
      assert file != null;
      TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath(), true);
      params.setColForEach(true);
      Workbook workbook = ExcelExportUtil.exportExcel(params, result);
      assert response != null;
      PoiUtils.downLoadExcel(exportFileName, response, workbook);
   }

   private CommonHeadDTO getWarehouseDataAnalysisHeadDTO(LocalDate dateTime, Long branchCompanyId, Long workshopId, @NotNull Integer dateType) {
      CommonHeadDTO commonHeadDTO = CommonHeadDTO.builder().dateTime("全部").branchCompanyName("全部").workshopName("全部").build();
      if (dateTime != null) {
         String formatStr = DateTypeEnum.getFormatByType(dateType);
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatStr);
         commonHeadDTO.setDateTime(dateTime.format(formatter));
      }

      if (branchCompanyId != null) {
         BranchCompany branchCompany = this.branchCompanyService.getById(branchCompanyId);
         if (branchCompany != null) {
            commonHeadDTO.setBranchCompanyName(branchCompany.getName());
         }
      }

      if (workshopId != null) {
         WmsWorkshop workshop = this.workshopService.getById(workshopId);
         if (workshop != null) {
            commonHeadDTO.setWorkshopName(workshop.getName());
         }
      }

      return commonHeadDTO;
   }

   private List<Long> getAuxiliaryClassifyIds(Long classifyId) {
      List<Long> ids = this.getEndLeveList(classifyId);
      return classifyId != null && ids.isEmpty() ? java.util.Collections.singletonList(classifyId) : ids;
   }

   private List<Long> getEndLeveList(Long oneLevelId) {
      ArrayList<Long> childList = new ArrayList<>();
      if (oneLevelId == null) {
         return childList;
      }

      List<Classification> child2 = this.classificationService
         .list(Wrappers.lambdaQuery(Classification.class).eq(Classification::getParentId, oneLevelId).eq(Classification::getLevel, 2));
      if (CollectionUtils.isNotEmpty(child2)) {
         List<Long> endTwoLeveIds = child2.stream()
            .filter(e -> e.getBoolLastEnum().equals(Boolean.TRUE))
            .map(Classification::getId)
            .collect(Collectors.toList());
         if (CollectionUtil.isNotEmpty(endTwoLeveIds)) {
            childList.addAll(endTwoLeveIds);
         }

         List<Long> twoLeveIds = child2.stream().filter(e -> e.getBoolLastEnum().equals(Boolean.FALSE)).map(Classification::getId).collect(Collectors.toList());
         if (CollectionUtil.isNotEmpty(twoLeveIds)) {
            List<Long> child3 = this.classificationService
               .list(Wrappers.lambdaQuery(Classification.class).in(Classification::getParentId, twoLeveIds).eq(Classification::getLevel, 3))
               .stream()
               .map(Classification::getId)
               .collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(child3)) {
               childList.addAll(child3);
            }
         }
      }

      return childList;
   }

   private Map<Integer, BigDecimal> unitConversion(BigDecimal value, String unit, Integer scale) {
      Unit u = this.unitService.getOne((Wrapper<Unit>)Wrappers.<Unit>lambdaQuery().eq(Unit::getName, unit));
      Map<Integer, BigDecimal> map = new HashMap<>();
      if (UnitEnum.DIGIT.getType().equals(u.getType())) {
         map.put(2, BigDecimal.ONE);
         map.put(1, value.stripTrailingZeros());
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

   private void setMeteV2(
      CommonDetailSimpleDTO simpleDTO,
      DownLoadDetailDO detailDO,
      Measure measure,
      Map<Long, Classification> classificationMap,
      Map<Long, Measure> measureMap,
      Map<String, Unit> unitMap
   ) {
      if (StrUtil.isBlank(measure.getAccountingUnit())) {
         Classification classification = classificationMap.get(measure.getClassificationId());
         measure = this.getMeasureV2(classification.getParentId(), measureMap, classificationMap);
      }

      String accountingUnit = measure.getAccountingUnit();
      simpleDTO.setAccountingUnit(accountingUnit);
      Map<Integer, BigDecimal> mete = this.unitConversionV2(detailDO.getMete(), accountingUnit, measure.getAccountingPrecision(), unitMap);
      simpleDTO.setMete(mete.get(1));
   }

   private Map<Integer, BigDecimal> unitConversionV2(BigDecimal value, String unit, Integer scale, Map<String, Unit> unitMap) {
      Unit u = unitMap.get(unit);
      Map<Integer, BigDecimal> map = new HashMap<>();
      if (scale == null) {
         scale = 0;
      }

      if (UnitEnum.DIGIT.getType().equals(u.getType())) {
         map.put(2, BigDecimal.ONE);
         map.put(1, value.stripTrailingZeros());
      } else {
         BigDecimal precision = UnitsPrecisionEnum.getByName(unit);
         map.put(1, value.divide(precision, scale, 4));
         map.put(2, precision);
      }

      return map;
   }

   private Measure getMeasureV2(Long pid, Map<Long, Measure> measureMap, Map<Long, Classification> classificationMap) {
      Measure m = measureMap.get(pid);
      if (m.getAccountingUnit() != null) {
         return m;
      }

      Classification classification = classificationMap.get(pid);
      return this.getMeasureV2(classification.getParentId(), measureMap, classificationMap);
   }

   private void setSpecs(DownLoadDetailDO detailDO, StringBuilder sb, StringBuilder lengths, StringBuilder material) {
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
            sb.append("*").append(detailDO.getColor());
         }
      } else if (BasicClassEnum.checkNotSteel(detailDO.getBasicClass())) {
         if (StrUtil.isNotBlank(detailDO.getSpecification())) {
            sb.append(detailDO.getSpecification());
            if (StrUtil.isNotBlank(detailDO.getColor())) {
               sb.append("*").append(detailDO.getColor());
            }
         } else if (StrUtil.isNotBlank(detailDO.getColor())) {
            sb.append(detailDO.getColor());
         }
      }
   }
}
