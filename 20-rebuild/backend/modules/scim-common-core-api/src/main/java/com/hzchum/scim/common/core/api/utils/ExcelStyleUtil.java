package com.hzchum.scim.common.core.api.utils;

import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import cn.afterturn.easypoi.excel.entity.params.ExcelForEachParams;
import cn.afterturn.easypoi.excel.export.styler.IExcelExportStyler;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelStyleUtil implements IExcelExportStyler {
   private static final short STRING_FORMAT = (short)BuiltinFormats.getBuiltinFormat("TEXT");
   private static final short FONT_SIZE_TEN = 10;
   private static final short FONT_SIZE_ELEVEN = 11;
   private static final short FONT_SIZE_TWELVE = 12;
   private CellStyle headerStyle;
   private CellStyle titleStyle;
   private CellStyle styles;

   public ExcelStyleUtil(Workbook workbook) {
      this.init(workbook);
   }

   private void init(Workbook workbook) {
      this.headerStyle = this.initHeaderStyle(workbook);
      this.titleStyle = this.initTitleStyle(workbook);
      this.styles = this.initStyles(workbook);
   }

   @Override
   public CellStyle getHeaderStyle(short color) {
      return this.headerStyle;
   }

   @Override
   public CellStyle getTitleStyle(short color) {
      return this.titleStyle;
   }

   @Override
   public CellStyle getStyles(boolean parity, ExcelExportEntity entity) {
      return this.styles;
   }

   @Override
   public CellStyle getStyles(Cell cell, int dataRow, ExcelExportEntity entity, Object obj, Object data) {
      return this.getStyles(true, entity);
   }

   @Override
   public CellStyle getTemplateStyles(boolean isSingle, ExcelForEachParams excelForEachParams) {
      return null;
   }

   private CellStyle initHeaderStyle(Workbook workbook) {
      CellStyle style = this.getBaseCellStyle(workbook);
      style.setFont(this.getFont(workbook, (short)12, true));
      return style;
   }

   private CellStyle initTitleStyle(Workbook workbook) {
      CellStyle style = this.getBaseCellStyle(workbook);
      style.setFont(this.getFont(workbook, (short)11, false));
      style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
      style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
      return style;
   }

   private CellStyle initStyles(Workbook workbook) {
      CellStyle style = this.getBaseCellStyle(workbook);
      style.setFont(this.getFont(workbook, (short)10, false));
      style.setDataFormat(STRING_FORMAT);
      return style;
   }

   private CellStyle getBaseCellStyle(Workbook workbook) {
      CellStyle style = workbook.createCellStyle();
      style.setBorderBottom(BorderStyle.THIN);
      style.setBorderLeft(BorderStyle.THIN);
      style.setBorderTop(BorderStyle.THIN);
      style.setBorderRight(BorderStyle.THIN);
      style.setAlignment(HorizontalAlignment.CENTER);
      style.setVerticalAlignment(VerticalAlignment.CENTER);
      style.setWrapText(true);
      return style;
   }

   private Font getFont(Workbook workbook, short size, boolean isBold) {
      Font font = workbook.createFont();
      font.setFontName("宋体");
      font.setBold(isBold);
      font.setFontHeightInPoints(size);
      return font;
   }
}
