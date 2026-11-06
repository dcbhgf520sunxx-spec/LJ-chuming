package com.hzchum.scim.scm.core.biz;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.afterturn.easypoi.util.PoiMergeCellUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.export.ApproveRecordDetailExportDTO;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.common.core.api.utils.ExcelExportStyler;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.scm.core.api.biz.ApplyPurchaseBiz;
import com.hzchum.scim.scm.core.api.enums.ApplyPurchaseTypeEnum;
import com.hzchum.scim.scm.core.api.pojo._do.ApplyPurchase;
import com.hzchum.scim.scm.core.api.pojo._do.ApplyPurchaseDetail;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrder;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrderDetail;
import com.hzchum.scim.scm.core.api.pojo.dto.ApplyPurchaseDTO;
import com.hzchum.scim.scm.core.api.pojo.export.ApplyPurchaseDetailExportDTO;
import com.hzchum.scim.scm.core.api.pojo.export.SheetMergeParam;
import com.hzchum.scim.scm.core.api.service.ApplyPurchaseService;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderDetailService;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import com.hzchum.scim.scm.core.mapper.ApplyPurchaseDetailMapper;
import com.hzchum.scim.system.core.api.common.enums.ArtifactTypeEnum;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.enums.DataStatusEnum;
import com.hzchum.scim.wms.core.api.enums.UnitEnum;
import com.hzchum.scim.wms.core.api.enums.UnitsPrecisionEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Classification;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Measure;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Unit;
import com.hzchum.scim.wms.core.api.service.wmsConfig.ClassificationService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.MeasureService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.UnitService;
import com.hzchum.scim.wms.core.api.utils.QueryUtilService;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
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
import org.springframework.stereotype.Service;

@Service
public class ApplyPurchaseBizImpl implements ApplyPurchaseBiz {
   @Resource
   private ApplyPurchaseService applyPurchaseService;
   @Resource
   private ApplyPurchaseDetailMapper applyPurchaseDetailMapper;
   @Resource
   private PurchaseOrderService purchaseOrderService;
   @Resource
   private PurchaseOrderDetailService purchaseOrderDetailService;
   @Resource
   ContractProjectService projectService;
   @Resource
   private WmsApproveRecordService wmsApproveRecordService;
   @Resource
   private MeasureService measureService;
   @Resource
   private ClassificationService classificationService;
   @Resource
   UnitService unitService;
   @Resource
   QueryUtilService queryUtilService;

   @Override
   public void export(Long id, HttpServletResponse response) throws IOException {
      ApplyPurchase applyPurchase = this.applyPurchaseService.getById(id);
      ApplyPurchaseDTO applyPurchaseDTO = BeanUtil.toBean(applyPurchase, ApplyPurchaseDTO.class);
      List<ApplyPurchaseDetail> applyPurchaseDetails = this.applyPurchaseDetailMapper
         .selectList((Wrapper<ApplyPurchaseDetail>)Wrappers.<ApplyPurchaseDetail>lambdaQuery().eq(ApplyPurchaseDetail::getApplyPurchaseId, applyPurchase.getId()));
      List<ProjectInfo> projectInfoList = new ArrayList<>();
      if (ObjectUtil.isNotEmpty(applyPurchaseDTO.getProjectIds())) {
         List<Long> collect = Arrays.stream(applyPurchaseDTO.getProjectIds().split(",")).map(Long::new).collect(Collectors.toList());
         List<ContractProject> contractProjects = this.projectService.listByIds(collect);
         projectInfoList = BeanUtil.copyToList(contractProjects, ProjectInfo.class);
         applyPurchaseDTO.setProjectInfos(projectInfoList);
      }

      List<ApplyPurchaseDetailExportDTO> applyPurchaseDetailExportDTOS = new ArrayList<>();

      for (ApplyPurchaseDetail applyPurchaseDetail : applyPurchaseDetails) {
         ApplyPurchaseDetailExportDTO copy = com.hzchum.pangu.common.util.BeanUtil.copy(applyPurchaseDetail, ApplyPurchaseDetailExportDTO.class);
         if (ObjectUtil.isNotEmpty(applyPurchaseDetail.getProjectId())) {
            ProjectInfo projectInfo = projectInfoList.stream().filter(p -> p.getId().equals(applyPurchaseDetail.getProjectId())).findAny().orElse(null);
            copy.setProjectName("/");
            if (ObjectUtil.isNotEmpty(projectInfo)) {
               copy.setProjectName(projectInfo.getName());
            }
         }

         Measure measure = this.measureService
            .getOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, applyPurchaseDetail.getClassifyId()));
         if (StrUtil.isBlank(measure.getAccountingUnit())) {
            Classification classification = this.classificationService.getById(applyPurchaseDetail.getClassifyId());
            measure = this.getMeasure(classification.getParentId());
         }

         String accountingUnit = measure.getAccountingUnit();
         Map<Integer, BigDecimal> mete = this.unitConversion(applyPurchaseDetail.getMete(), accountingUnit, measure.getAccountingPrecision());
         copy.setAccountingUnit(accountingUnit);
         copy.setMete(mete.get(1));
         applyPurchaseDetailExportDTOS.add(copy);
      }

      int size = applyPurchaseDetailExportDTOS.size();
      String secondTitle = "申购单号：" + applyPurchaseDTO.getSerialNumber() + "              申购人：" + applyPurchaseDTO.getApplicantName();
      ExportParams exportParams = new ExportParams("申购详情", secondTitle, "申购详情");
      exportParams.setStyle(ExcelExportStyler.class);
      Workbook workbook = ExcelExportUtil.exportExcel(exportParams, ApplyPurchaseDetailExportDTO.class, applyPurchaseDetailExportDTOS);
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
      if (ObjectUtil.isNotEmpty(applyPurchaseDTO) && ObjectUtil.isNotEmpty(applyPurchaseDTO.getApproveRecordIdNow())) {
         Row approvalTitleRow = sheet.createRow(approvalStartRow + 1);
         String[] approvalTitles = new String[]{"节点", "审批人", "到达时间", "审批时间", "审批结果", "审批意见"};

         for (int i = 0; i < approvalTitles.length; i++) {
            Cell cell = approvalTitleRow.createCell(i);
            cell.setCellValue(approvalTitles[i]);
            cell.setCellStyle(cellStyle);
         }

         List<ApproveRecordDetailExportDTO> approveRecordDetailExportDTOS = this.wmsApproveRecordService.getExport(applyPurchaseDTO.getApproveRecordIdNow());
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

      PoiUtils.downNoBuildCellLoadExcel("申购详情-" + applyPurchase.getSerialNumber() + "-.xlsx", response, workbook);
   }

   @Override
   public void applyTrackExport(Long id, HttpServletResponse response) throws IOException {
      Map<String, Object> exportMap = new HashMap<>();
      ApplyPurchase applyPurchase = this.applyPurchaseService.getById(id);
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(applyPurchase), "申购单不存在！！！");
      List<ApplyPurchaseDetail> applyPurchaseDetails = this.applyPurchaseDetailMapper
         .selectList((Wrapper<ApplyPurchaseDetail>)new LambdaQueryWrapper<ApplyPurchaseDetail>().eq(ApplyPurchaseDetail::getApplyPurchaseId, id));
      List<Long> applyPurchaseDetailIds = applyPurchaseDetails.stream().map(ApplyPurchaseDetail::getId).collect(Collectors.toList());
      Set<Long> classifyIds = new TreeSet<>();
      Set<Long> projectIds = new TreeSet<>();
      Set<Long> monomerIds = new TreeSet<>();
      Set<Long> areaIds = new TreeSet<>();

      for (ApplyPurchaseDetail applyPurchaseDetail : applyPurchaseDetails) {
         if (ObjectUtil.isNotEmpty(applyPurchaseDetail.getClassifyId())) {
            classifyIds.add(applyPurchaseDetail.getClassifyId());
         }

         if (ObjectUtil.isNotEmpty(applyPurchaseDetail.getProjectId())) {
            projectIds.add(applyPurchaseDetail.getProjectId());
         }

         if (ObjectUtil.isNotEmpty(applyPurchaseDetail.getMonomerId())) {
            monomerIds.add(applyPurchaseDetail.getMonomerId());
         }

         if (ObjectUtil.isNotEmpty(applyPurchaseDetail.getAreaId())) {
            areaIds.add(applyPurchaseDetail.getAreaId());
         }
      }

      List<PurchaseOrderDetail> purchaseOrderDetails = new ArrayList<>();
      List<PurchaseOrder> purchaseOrders = this.purchaseOrderService
         .list(
            (Wrapper<PurchaseOrder>)(new LambdaQueryWrapper<PurchaseOrder>().eq(PurchaseOrder::getDataStatus, DataStatusEnum.SUCCEED.getType()))
               .last("and find_in_set(" + applyPurchase.getId() + ",apply_purchase_ids)")
         );
      if (CollectionUtil.isNotEmpty(purchaseOrders)) {
         List<Long> purchaseIds = purchaseOrders.stream().map(PurchaseOrder::getId).collect(Collectors.toList());
         purchaseOrderDetails = this.purchaseOrderDetailService
            .list(
               (Wrapper<PurchaseOrderDetail>)(new LambdaQueryWrapper<PurchaseOrderDetail>().in(PurchaseOrderDetail::getPurchaseId, purchaseIds))
                  .in(PurchaseOrderDetail::getApplyPurchaseDetailId, applyPurchaseDetailIds)
            );
      }

      for (PurchaseOrderDetail purchaseOrderDetail : purchaseOrderDetails) {
         if (ObjectUtil.isNotEmpty(purchaseOrderDetail.getClassifyId())) {
            classifyIds.add(purchaseOrderDetail.getClassifyId());
         }

         if (ObjectUtil.isNotEmpty(purchaseOrderDetail.getProjectId())) {
            projectIds.add(purchaseOrderDetail.getProjectId());
         }
      }

      Map<Long, Classification> classificationMapByIds = this.queryUtilService.getClassificationMapByIds(classifyIds);
      Map<Long, Measure> measureMapByClassifyIds = this.queryUtilService.getMeasureMapByClassifyIds(classifyIds);
      Map<Long, ContractProject> projectMapByIds = this.queryUtilService.getProjectMapByIds(projectIds);
      Map<Long, PlanMonomer> monomerMapByIds = this.queryUtilService.getMonomerMapByIds(monomerIds);
      Map<Long, PlanArea> areaMapByIds = this.queryUtilService.getAreaMapByIds(areaIds);
      DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      exportMap.put("serialNumber", applyPurchase.getSerialNumber());
      exportMap.put("applicantName", applyPurchase.getApplicantName());
      if (ApplyPurchaseTypeEnum.MANUFACTURES.getType().equals(applyPurchase.getType())) {
         ContractProject contractProject = projectMapByIds.get(Long.parseLong(applyPurchase.getProjectIds()));
         exportMap.put("project", ObjectUtil.isNotEmpty(contractProject) ? contractProject.getShortName() : "");
      }

      List<Map<String, Object>> mapList = new ArrayList<>();
      Integer applyNumber = 0;
      Integer purchaseNumber = 0;

      for (ApplyPurchaseDetail applyPurchaseDetail : applyPurchaseDetails) {
         Map<String, Object> mapObject = new HashMap<>();
         applyNumber = applyNumber + 1;
         mapObject.put("applyNumber", applyNumber);
         Measure measure = measureMapByClassifyIds.get(applyPurchaseDetail.getClassifyId());
         ContractProject contractProject = projectMapByIds.get(applyPurchaseDetail.getProjectId());
         if (ApplyPurchaseTypeEnum.MANUFACTURES.getType().equals(applyPurchase.getType())) {
            mapObject.put("applyManufacturedName", applyPurchaseDetail.getManufacturedName());
            mapObject.put("applyMaterialSn", applyPurchaseDetail.getManufacturedSn());
            mapObject.put("applyManufacturedType", ArtifactTypeEnum.getName(applyPurchaseDetail.getManufacturedType()));
            mapObject.put("applySpecification", applyPurchaseDetail.getSpecification());
            mapObject.put(
               "applyMonomer",
               ObjectUtil.isNotEmpty(applyPurchaseDetail.getMonomerId()) ? monomerMapByIds.get(applyPurchaseDetail.getMonomerId()).getName() : "-"
            );
            mapObject.put(
               "applyArea", ObjectUtil.isNotEmpty(applyPurchaseDetail.getAreaId()) ? areaMapByIds.get(applyPurchaseDetail.getAreaId()).getName() : "-"
            );
            mapObject.put("applyQuantity", applyPurchaseDetail.getQuantity());
            mapObject.put(
               "applyWeight", ObjectUtil.isNotEmpty(applyPurchaseDetail.getWeight()) ? applyPurchaseDetail.getWeight().divide(new BigDecimal(1000)) : "-"
            );
            mapObject.put(
               "applyTotalWeight",
               ObjectUtil.isNotEmpty(applyPurchaseDetail.getTotalWeight()) ? applyPurchaseDetail.getTotalWeight().divide(new BigDecimal(1000)) : "-"
            );
            mapObject.put(
               "applyArrivalTime",
               ObjectUtil.isNotEmpty(applyPurchaseDetail.getArrivalTime()) ? applyPurchaseDetail.getArrivalTime().format(dateTimeFormatter) : "-"
            );
            mapObject.put(
               "havePurchaseQuantity",
               ObjectUtil.isNotEmpty(applyPurchaseDetail.getProductQuantity()) ? applyPurchaseDetail.getProductQuantity().toPlainString() : "-"
            );
            mapObject.put(
               "unPurchaseQuantity",
               ObjectUtil.isNotEmpty(applyPurchaseDetail.getProductQuantity())
                  ? applyPurchaseDetail.getQuantity().subtract(applyPurchaseDetail.getProductQuantity()).toPlainString()
                  : "-"
            );
         } else {
            mapObject.put("applyMaterialSn", applyPurchaseDetail.getMaterialSn());
            mapObject.put("applyBasicClass", BasicClassEnum.getNameByType(applyPurchaseDetail.getBasicClass()));
            mapObject.put("applySpecification", applyPurchaseDetail.getSpecification());
            mapObject.put(
               "applyMeasureUnit",
               ObjectUtil.isNotEmpty(measure.getMeasureUnit()) ? (ObjectUtil.isNotEmpty(measure.getMeasureUnit()) ? measure.getMeasureUnit() : "-") : "-"
            );
            new BigDecimal("0");
            mapObject.put("applyQuantity", "-");
            if (ObjectUtil.isNotEmpty(measure.getMeasurePrecision())) {
               BigDecimal file = this.unitConversion(applyPurchaseDetail.getQuantity(), measure.getMeasureUnit(), measure.getMeasurePrecision()).get(1);
               mapObject.put("applyQuantity", file);
            }

            mapObject.put("applyAccountingUnit", ObjectUtil.isNotEmpty(measure.getAccountingUnit()) ? measure.getAccountingUnit() : "-");
            BigDecimal applyMete = this.unitConversion(applyPurchaseDetail.getMete(), measure.getAccountingUnit(), measure.getAccountingPrecision()).get(1);
            mapObject.put("applyMete", applyMete);
            mapObject.put("applyProject", ObjectUtil.isNotEmpty(contractProject) ? contractProject.getShortName() : "-");
            mapObject.put("applyBrand", applyPurchaseDetail.getBrand());
            mapObject.put("applyArrivalTime", ObjectUtil.isNotEmpty(applyPurchaseDetail.getArrivalTime()) ? applyPurchaseDetail.getArrivalTime().format(dateTimeFormatter) : "-");
            BigDecimal productMete = this.unitConversion(applyPurchaseDetail.getProductMete(), measure.getAccountingUnit(), measure.getAccountingPrecision())
               .get(1);
            mapObject.put("havePurchaseMete", productMete);
            BigDecimal unPurchaseMete = applyPurchaseDetail.getMete().subtract(applyPurchaseDetail.getProductMete());
            if (unPurchaseMete.compareTo(BigDecimal.ZERO) < 0) {
               unPurchaseMete = BigDecimal.ZERO;
            }

            BigDecimal unProductMete = this.unitConversion(unPurchaseMete, measure.getAccountingUnit(), measure.getAccountingPrecision()).get(1);
            mapObject.put("unPurchaseMete", unProductMete.toPlainString());
         }

         List<PurchaseOrderDetail> purchaseOrderDetailList = purchaseOrderDetails.stream()
            .filter(p -> p.getApplyPurchaseDetailId().equals(applyPurchaseDetail.getId()))
            .collect(Collectors.toList());
         if (ObjectUtil.isNotEmpty(purchaseOrderDetailList)) {
            for (PurchaseOrderDetail purchaseOrderDetail : purchaseOrderDetailList) {
               Map<String, Object> newMapObject = new HashMap<>(mapObject);
               purchaseNumber = purchaseNumber + 1;
               Measure measurePurchase = measureMapByClassifyIds.get(purchaseOrderDetail.getClassifyId());
               ContractProject contractProjectPurchase = projectMapByIds.get(purchaseOrderDetail.getProjectId());
               PurchaseOrder purchaseOrder = purchaseOrders.stream().filter(p -> p.getId().equals(purchaseOrderDetail.getPurchaseId())).findAny().orElse(null);
               newMapObject.put("purchaseNumber", purchaseNumber);
               if (ApplyPurchaseTypeEnum.MANUFACTURES.getType().equals(applyPurchase.getType())) {
                  newMapObject.put("purchaseSerialNumber", purchaseOrder.getSerialNumber());
                  newMapObject.put("purchaseManufacturedSpecification", purchaseOrderDetail.getManufacturedSpecification());
                  newMapObject.put("purchaseMaterialSn", purchaseOrderDetail.getManufacturedSn());
                  newMapObject.put("purchaseQuantity", purchaseOrderDetail.getQuantity());
                  newMapObject.put(
                     "purchaseWeight",
                     ObjectUtil.isNotEmpty(purchaseOrderDetail.getWeight()) ? purchaseOrderDetail.getWeight().divide(new BigDecimal(1000)) : "-"
                  );
                  newMapObject.put(
                     "purchaseTotalWeight",
                     ObjectUtil.isNotEmpty(purchaseOrderDetail.getTotalWeight()) ? purchaseOrderDetail.getTotalWeight().divide(new BigDecimal(1000)) : "-"
                  );
               } else {
                  newMapObject.put("purchaseSerialNumber", purchaseOrder.getSerialNumber());
                  newMapObject.put("purchaseMaterialSn", purchaseOrderDetail.getMaterialSn());
                  newMapObject.put("purchaseBasicClass", BasicClassEnum.getNameByType(purchaseOrderDetail.getBasicClass()));
                  newMapObject.put("purchaseSpecification", purchaseOrderDetail.getSpecification());
                  newMapObject.put("purchaseMeasureUnit", ObjectUtil.isNotEmpty(measurePurchase.getMeasureUnit()) ? measurePurchase.getMeasureUnit() : "-");
                  newMapObject.put("purchaseQuantity", ObjectUtil.isNotEmpty(purchaseOrderDetail.getQuantity()) ? purchaseOrderDetail.getQuantity() : "-");
                  if (ObjectUtil.isNotEmpty(measurePurchase.getMeasurePrecision())) {
                     BigDecimal purchaseQuantity = this.unitConversion(
                           purchaseOrderDetail.getQuantity(), measurePurchase.getMeasureUnit(), measurePurchase.getMeasurePrecision()
                        )
                        .get(1);
                     newMapObject.put("purchaseQuantity", purchaseQuantity);
                  }

                  newMapObject.put("purchaseAccountingUnit", ObjectUtil.isNotEmpty(measurePurchase) ? measurePurchase.getAccountingUnit() : "-");
                  BigDecimal purchaseMete = this.unitConversion(
                        purchaseOrderDetail.getMete(), measurePurchase.getAccountingUnit(), measurePurchase.getAccountingPrecision()
                     )
                     .get(1);
                  newMapObject.put("purchaseMete", purchaseMete);
                  newMapObject.put("purchaseProject", ObjectUtil.isNotEmpty(contractProjectPurchase) ? contractProjectPurchase.getShortName() : "-");
                  newMapObject.put("purchaseBrand", purchaseOrderDetail.getBrand());
               }

               mapList.add(newMapObject);
            }
         } else {
            mapList.add(mapObject);
         }
      }

      exportMap.put("mapList", mapList);
      if (ApplyPurchaseTypeEnum.MANUFACTURES.getType().equals(applyPurchase.getType())) {
         String tempFileName = "applyPurchaseTraceManufactured";
         String resourcePath = "files/template/supplier/applyPurchaseTraceManufactured.xlsx";
         String exportFileName = applyPurchase.getSerialNumber() + "采购申购跟踪.xlsx";
         org.springframework.core.io.Resource resource = new ClassPathResource(resourcePath);
         InputStream inputStream = resource.getInputStream();
         File file = File.createTempFile(tempFileName, "xlsx");
         FileUtil.copyInputStreamToFile(inputStream, file);
         TemplateExportParams templatePath = new TemplateExportParams(file.getAbsolutePath(), true);
         Workbook workbook = ExcelExportUtil.exportExcel(templatePath, exportMap);
         PoiUtils.downLoadExcel(exportFileName, response, workbook);
      } else {
         String tempFileName = "applyPurchaseTrace";
         String resourcePath = "files/template/supplier/applyPurchaseTrace.xlsx";
         String exportFileName = applyPurchase.getSerialNumber() + "采购申购跟踪.xlsx";
         org.springframework.core.io.Resource resource = new ClassPathResource(resourcePath);
         InputStream inputStream = resource.getInputStream();
         File file = File.createTempFile(tempFileName, "xlsx");
         FileUtil.copyInputStreamToFile(inputStream, file);
         TemplateExportParams templatePath = new TemplateExportParams(file.getAbsolutePath(), true);
         Workbook workbook = ExcelExportUtil.exportExcel(templatePath, exportMap);
         SheetMergeParam sheetMergeParam = new SheetMergeParam(
            0,
            0,
            new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12},
            Lists.newArrayList("序号", "物料编号", "物料类别", "规格", "计量单位", "申购数", "核算单位", "申购量", "项目", "品牌", "到厂日期", "已采购量", "未采购量")
         );
         mergeExcel(workbook, Lists.newArrayList(sheetMergeParam));
         PoiUtils.downLoadExcel(exportFileName, response, workbook);
      }
   }

   private static void mergeExcel(Workbook workbook, List<SheetMergeParam> sheetMergeParamList) {
      for (SheetMergeParam sheetMergeParam : sheetMergeParamList) {
         Sheet sheet = workbook.getSheetAt(sheetMergeParam.getSheetIndex());
         int lastRowNum = sheet.getLastRowNum();

         for (int i = 0; i < lastRowNum; i++) {
            if (null != sheet.getRow(i) && null != sheet.getRow(i).getCell(0)) {
               Cell cell = sheet.getRow(i).getCell(0);
               if (!sheetMergeParam.getIgnoreCellValues().contains(cell.getStringCellValue()) && !StringUtils.isEmpty(cell.getStringCellValue())) {
                  int endRowNum = 0;

                  for (int j = i + 1; j <= lastRowNum; j++) {
                     Cell desColumn = sheet.getRow(i).getCell(sheetMergeParam.getDesColumnIndex());
                     Cell nextDesColumn = sheet.getRow(j).getCell(sheetMergeParam.getDesColumnIndex());
                     if (ObjectUtil.isEmpty(nextDesColumn) || !desColumn.getStringCellValue().equals(nextDesColumn.getStringCellValue())) {
                        break;
                     }

                     endRowNum++;
                  }

                  if (endRowNum != 0) {
                     for (int z = 0; z < sheetMergeParam.getMergeColumnIndexs().length; z++) {
                        int firstRow = i;
                        int lastRow = i + endRowNum;
                        int firstCol = sheetMergeParam.getMergeColumnIndexs()[z];
                        int lastCol = sheetMergeParam.getMergeColumnIndexs()[z];
                        PoiMergeCellUtil.addMergedRegion(sheet, firstRow, lastRow, firstCol, lastCol);
                     }

                     i += endRowNum;
                  }
               }
            }
         }
      }
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

   private Measure getMeasure(Long pid) {
      Measure m = this.measureService.getOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, pid));
      if (m.getAccountingUnit() != null) {
         return m;
      }

      Classification classification = this.classificationService.getById(pid);
      return this.getMeasure(classification.getParentId());
   }

   private Map<Integer, BigDecimal> unitConversion(BigDecimal value, String unit, Integer scale) {
      Unit u = this.unitService.getOne((Wrapper<Unit>)Wrappers.<Unit>lambdaQuery().eq(Unit::getName, unit));
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
}
