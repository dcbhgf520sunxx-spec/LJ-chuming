package com.hzchum.scim.scm.core.api.common.utils;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.hzchum.scim.contract.core.api.enums.StructureMeasureModeEnum;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.PurchaseOrderDetailDTOParam;
import com.hzchum.scim.system.core.api.common.enums.CostBasicClassEnum;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
   public static void steelPlatesExcel(List<PurchaseOrderDetailDTOParam> list, String filePath) throws IOException {
      Path parent = Paths.get(filePath).toAbsolutePath().getParent();
      if (parent != null) Files.createDirectories(parent);
      Workbook workbook = new XSSFWorkbook();
      Sheet sheet = workbook.createSheet("采购明细");
      CellStyle headerStyle = workbook.createCellStyle();
      headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
      headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
      headerStyle.setAlignment(HorizontalAlignment.CENTER);
      headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);
      Row headerRow = sheet.createRow(0);
      String[] headers = new String[]{"申购单号", "物料编号", "物料种类", "规格", "品牌", "计量单位", "数量", "核算单位", "核算量", "含税单价", "含税金额", "计量方式"};

      for (int i = 0; i < headers.length; i++) {
         Cell cell = headerRow.createCell(i);
         cell.setCellValue(headers[i]);
         cell.setCellStyle(headerStyle);
      }

      int rowNum = 1;

      for (PurchaseOrderDetailDTOParam detail : list) {
         Row row = sheet.createRow(rowNum++);
         row.createCell(0).setCellValue(ObjectUtils.isNotEmpty(detail.getId()) ? detail.getId().toString() : null);
         row.createCell(1).setCellValue(detail.getClassifySerialNumber());
         row.createCell(2).setCellValue(CostBasicClassEnum.getNameByType(detail.getBasicClass()));
         row.createCell(3).setCellValue(detail.getSpecification());
         row.createCell(4).setCellValue(detail.getBrand());
         row.createCell(5).setCellValue(detail.getMeasureUnit());
         row.createCell(6).setCellValue(detail.getQuantity().doubleValue());
         row.createCell(7).setCellValue(detail.getAccountingUnit());
         row.createCell(8).setCellValue(detail.getMete().divide(new BigDecimal(1000000), 2, RoundingMode.HALF_UP).doubleValue());
         row.createCell(9).setCellValue(detail.getUnitPrice().multiply(new BigDecimal(1000000)).doubleValue());
         row.createCell(10).setCellValue(detail.getAmount().doubleValue());
         row.createCell(11).setCellValue(StructureMeasureModeEnum.getNameByType(detail.getWeightMeasurementMode()));
      }

      for (int i = 0; i < headers.length; i++) {
         sheet.autoSizeColumn(i);
         sheet.setColumnWidth(i, sheet.getColumnWidth(i) + 512);
      }

      try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
         workbook.write(fileOut);
      }

      workbook.close();
   }
}
