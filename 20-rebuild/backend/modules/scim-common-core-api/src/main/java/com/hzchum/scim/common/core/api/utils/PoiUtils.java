package com.hzchum.scim.common.core.api.utils;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import cn.afterturn.easypoi.word.WordExportUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.util.FileUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

public class PoiUtils {
   private static final Logger log = LoggerFactory.getLogger(PoiUtils.class);

   private PoiUtils() {
   }

   public static void exportExcel(
      List<?> list, String title, String sheetName, Class<?> pojoClass, String fileName, boolean isCreateHeader, HttpServletResponse response
   ) {
      ExportParams exportParams = new ExportParams(title, sheetName);
      exportParams.setCreateHeadRows(isCreateHeader);
      defaultExport(list, pojoClass, fileName, response, exportParams);
   }

   public static void exportExcel(List<?> list, String title, String sheetName, Class<?> pojoClass, String fileName, HttpServletResponse response) {
      defaultExport(list, pojoClass, fileName, response, new ExportParams(title, sheetName));
   }

   public static void wmsExportExcel(List<?> list, String title, String sheetName, Class<?> pojoClass, String fileName, HttpServletResponse response) {
      defaultExport1(list, pojoClass, fileName, response, new ExportParams(title, sheetName));
   }

   public static void exportExcel(
      List<?> list, String title, String sheetName, Class<?> pojoClass, String fileName, ExcelType excelType, HttpServletResponse response
   ) {
      defaultExport(list, pojoClass, fileName, response, new ExportParams(title, sheetName, excelType));
   }

   public static void exportExcel(
      List<?> list, String title, String sheetName, List<ExcelExportEntity> entityList, String fileName, boolean isCreateHeader, HttpServletResponse response
   ) {
      ExportParams exportParams = new ExportParams(title, sheetName);
      exportParams.setCreateHeadRows(isCreateHeader);
      exportParams.setStyle(ExcelStyleUtil.class);
      defaultExport(list, entityList, fileName, response, exportParams);
   }

   public static void exportExcel(
      List<?> list, String title, String sheetName, List<ExcelExportEntity> entityList, String fileName, HttpServletResponse response
   ) {
      ExportParams exportParams = new ExportParams(title, sheetName);
      exportParams.setStyle(ExcelStyleUtil.class);
      defaultExport(list, entityList, fileName, response, exportParams);
   }

   public static void exportExcel(List<Map<String, Object>> list, String fileName, HttpServletResponse response) {
      defaultExport(list, fileName, response);
   }

   public static <T> List<T> importExcel(String filePath, Integer titleRows, Integer headerRows, Class<T> pojoClass) {
      if (StringUtils.isBlank(filePath)) {
         return new ArrayList<>();
      }

      ImportParams params = new ImportParams();
      params.setTitleRows(titleRows);
      params.setHeadRows(headerRows);

      try {
         return ExcelImportUtil.importExcel(new File(filePath), pojoClass, params);
      } catch (NoSuchElementException e) {
         throw new BusinessException("模板不能为空");
      } catch (Exception e) {
         throw new BusinessException(e.getMessage());
      }
   }

   public static <T> List<T> importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Integer startSheetIndex, Class<T> pojoClass) {
      if (file == null) {
         return new ArrayList<>();
      }

      ImportParams params = new ImportParams();
      params.setTitleRows(titleRows);
      params.setHeadRows(headerRows);
      params.setStartSheetIndex(startSheetIndex);

      try {
         return ExcelImportUtil.importExcel(file.getInputStream(), pojoClass, params);
      } catch (NoSuchElementException e) {
         throw new BusinessException("excel文件不能为空");
      } catch (Exception e) {
         ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
         HttpServletResponse response = servletRequestAttributes.getResponse();

         try {
            response.setHeader("result", "code=50000;message=" + URLEncoder.encode("excel不合法", "UTF-8"));
            response.setHeader("Access-Control-Expose-Headers", "result");
         } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
         }

         response.setHeader("code", String.valueOf(50000));
         throw new BusinessException(e.getMessage());
      }
   }

   public static <T> List<T> importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass) {
      return importExcel(file, titleRows, headerRows, 0, pojoClass);
   }

   public static void exportTemplateWord(String templateFilePath, Map<String, Object> params, String fileName, HttpServletResponse response) {
      OutputStream fos = null;

      try {
         XWPFDocument doc = WordExportUtil.exportWord07(templateFilePath, params);
         response.setCharacterEncoding("UTF-8");
         response.setHeader("content-Type", "application/vnd.ms-word");
         response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
         response.setHeader("Access-Control-Expose-Headers", "*");
         fos = response.getOutputStream();
         doc.write(fos);
      } catch (Exception e) {
         log.info("导出word出现错误");
      } finally {
         if (fos != null) {
            try {
               fos.close();
            } catch (IOException e) {
               log.info("导出word出现未知错误");
            }
         }
      }
   }

   public static void exportTemplateWord(String templateFilePath, List<Map<String, Object>> list, String fileName, HttpServletResponse response) {
      OutputStream fos = null;

      try {
         XWPFDocument word = WordExportUtil.exportWord07(templateFilePath, list);
         response.setCharacterEncoding("UTF-8");
         response.setHeader("content-Type", "application/vnd.ms-word");
         response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
         response.setHeader("Access-Control-Expose-Headers", "*");
         fos = response.getOutputStream();
         word.write(fos);
      } catch (Exception e) {
         log.info("导出word出现错误");
      } finally {
         if (fos != null) {
            try {
               fos.close();
            } catch (IOException e) {
               log.info("导出word出现未知错误");
            }
         }
      }
   }

   private static void defaultExport(List<?> list, Class<?> pojoClass, String fileName, HttpServletResponse response, ExportParams exportParams) {
      Workbook workbook = ExcelExportUtil.exportExcel(exportParams, pojoClass, list);
      downLoadExcel(fileName, response, workbook);
   }

   private static void defaultExport1(List<?> list, Class<?> pojoClass, String fileName, HttpServletResponse response, ExportParams exportParams) {
      Workbook workbook = ExcelExportUtil.exportExcel(exportParams, pojoClass, list);
      unBuilderDownLoadExcel(fileName, response, workbook);
   }

   private static void defaultExport(List<?> list, List<ExcelExportEntity> entityList, String fileName, HttpServletResponse response, ExportParams exportParams) {
      Workbook workbook = ExcelExportUtil.exportExcel(exportParams, entityList, list);
      downLoadExcel(fileName, response, workbook);
   }

   public static void mesDownLoadExcel(
      String exportFileName, HttpServletResponse response, String tempFileName, String resourcePath, Map<String, Object> result
   ) {
      File file = null;
      ClassPathResource resource = new ClassPathResource(resourcePath);

      try (InputStream inputStream = resource.getInputStream()) {
         file = File.createTempFile(tempFileName, "xls");
         FileUtil.copyInputStreamToFile(inputStream, file);
      } catch (IOException e) {
         e.printStackTrace();
      }

      TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath(), true);
      Workbook workbook = ExcelExportUtil.exportExcel(params, result);
      downLoadExcel(exportFileName, response, workbook);
   }

   public static void downLoadExcel(String fileName, HttpServletResponse response, Workbook workbook) {
      buildCellStyle(workbook, Collections.singletonList(0));

      try {
         response.setCharacterEncoding("UTF-8");
         response.setHeader("content-Type", "application/vnd.ms-excel");
         response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
         response.setHeader("Access-Control-Expose-Headers", "*");
         workbook.write(response.getOutputStream());
      } catch (IOException e) {
         throw new BusinessException(e.getMessage());
      }
   }

   public static void unBuilderDownLoadExcel(String fileName, HttpServletResponse response, Workbook workbook) {
      try {
         response.setCharacterEncoding("UTF-8");
         response.setHeader("content-Type", "application/vnd.ms-excel");
         response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
         response.setHeader("Access-Control-Expose-Headers", "*");
         response.setHeader("Result", "code=" + ResultCodeEnum.SUCCESS.getCode() + ";message=" + ResultCodeEnum.SUCCESS.getCode());
         workbook.write(response.getOutputStream());
      } catch (IOException e) {
         throw new BusinessException(e.getMessage());
      }
   }

   public static void downNoBuildCellLoadExcel(String fileName, HttpServletResponse response, Workbook workbook) {
      try {
         response.setCharacterEncoding("UTF-8");
         response.setHeader("content-Type", "application/vnd.ms-excel");
         response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
         response.setHeader("Access-Control-Expose-Headers", "*");
         workbook.write(response.getOutputStream());
      } catch (IOException e) {
         throw new BusinessException(e.getMessage());
      }
   }

   public static void downLoadExcel(String fileName, HttpServletResponse response, Workbook workbook, List<Integer> sheets) {
      buildCellStyle(workbook, sheets);

      try {
         response.setCharacterEncoding("UTF-8");
         response.setHeader("content-Type", "application/vnd.ms-excel");
         response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
         response.setHeader("Access-Control-Expose-Headers", "*");
         workbook.write(response.getOutputStream());
      } catch (IOException e) {
         throw new BusinessException(e.getMessage());
      }
   }

   public static void downLoadExcel(String fileName, String path, Workbook workbook) {
      try {
         FileOutputStream fout = new FileOutputStream(path);
         HSSFFormulaEvaluator hssfFormulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook)workbook);
         Sheet sheet0 = workbook.getSheetAt(0);
         HSSFCellStyle contextstyle = (HSSFCellStyle)workbook.createCellStyle();
         sheet0.forEach(x -> {
            if (x.getRowNum() != 0 && x.getRowNum() <= sheet0.getLastRowNum()) {
               Cell cell5 = x.getCell(5);
               Cell cell2 = x.getCell(2);
               Cell cell3 = x.getCell(3);
               cell5.setCellFormula(cell5.getStringCellValue());
               hssfFormulaEvaluator.evaluateFormulaCell(x.getCell(5));
               HSSFDataFormat df = (HSSFDataFormat)workbook.createDataFormat();
               contextstyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,#0"));
               cell2.setCellStyle(contextstyle);
               cell2.setCellValue(Double.parseDouble(cell2.getStringCellValue()));
               cell3.setCellStyle(contextstyle);
               cell3.setCellValue(Double.parseDouble(cell3.getStringCellValue()));
            }
         });
         workbook.setForceFormulaRecalculation(true);
         workbook.write(fout);
         fout.close();
      } catch (IOException e) {
         throw new BusinessException(e.getMessage());
      } finally {
         System.gc();
      }
   }

   public static void wmsDownLoadExcel(String fileName, HttpServletResponse response, Workbook workbook, String message) {
      try {
         buildCellStyle(workbook, Collections.singletonList(0));
         if (StrUtil.isBlank(message)) {
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            response.setHeader("Access-Control-Expose-Headers", "*");
            response.setHeader("Result", "code=" + ResultCodeEnum.SUCCESS.getCode() + ";message=" + ResultCodeEnum.SUCCESS.getCode());
            workbook.write(response.getOutputStream());
         } else {
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Access-Control-Expose-Headers", "*");
            response.setHeader("Result", "code=" + ResultCodeEnum.ERROR.getCode() + ";message=" + URLEncoder.encode(message, "UTF-8"));
         }
      } catch (IOException e) {
         response.setHeader("Result", "code=" + ResultCodeEnum.ERROR.getCode() + ";message=" + ResultCodeEnum.ERROR.getCode());
      }
   }

   public static void wmsBeginDownLoadExcel(String fileName, HttpServletResponse response, Workbook workbook, String message) {
      try {
         buildBeginCellStyle(workbook, Collections.singletonList(0));
         if (StrUtil.isBlank(message)) {
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            response.setHeader("Access-Control-Expose-Headers", "*");
            response.setHeader("Result", "code=" + ResultCodeEnum.SUCCESS.getCode() + ";message=" + ResultCodeEnum.SUCCESS.getCode());
            workbook.write(response.getOutputStream());
         } else {
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Access-Control-Expose-Headers", "*");
            response.setHeader("Result", "code=" + ResultCodeEnum.ERROR.getCode() + ";message=" + URLEncoder.encode(message, "UTF-8"));
         }
      } catch (IOException e) {
         response.setHeader("Result", "code=" + ResultCodeEnum.ERROR.getCode() + ";message=" + ResultCodeEnum.ERROR.getCode());
      }
   }

   private static void defaultExport(List<Map<String, Object>> list, String fileName, HttpServletResponse response) {
      Workbook workbook = ExcelExportUtil.exportExcel(list, ExcelType.HSSF);
      downLoadExcel(fileName, response, workbook);
   }

   public static InputStream getInputStream(String name) {
      return Thread.currentThread().getContextClassLoader().getResourceAsStream(name);
   }

   public static void downLoadExcel(String resourcePath, String tempFileName, String exportFileName, Map<String, Object> map, HttpServletResponse response) {
      File file = creatTempFile(resourcePath, tempFileName, exportFileName);
      TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath());
      Workbook workbook = ExcelExportUtil.exportExcel(params, map);
      downLoadExcel(exportFileName, response, workbook);
   }

   private static File creatTempFile(String resourcePath, String tempFileName, String exportFileName) {
      Resource resource = new ClassPathResource(resourcePath);
      InputStream inputStream = null;
      File file = null;

      try {
         inputStream = resource.getInputStream();
         file = File.createTempFile(tempFileName, "xlsx");
      } catch (IOException e) {
         log.error("文件下载异常，请联系管理员, {}", e);
      }

      FileUtil.copyInputStreamToFile(inputStream, file);
      return file;
   }

   public static void downLoadExcelClone(
      String resourcePath, String tempFileName, String exportFileName, Map<Integer, List<Map<String, Object>>> realMap, HttpServletResponse response
   ) {
      File file = creatTempFile(resourcePath, tempFileName, exportFileName);
      TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath(), true);
      Workbook workbook = ExcelExportUtil.exportExcelClone(realMap, params);
      downLoadExcel(exportFileName, response, workbook);
   }

   public static void createExcel(Map<String, List<String>> map, String[] strArray, String path) {
      HSSFWorkbook wb = new HSSFWorkbook();
      HSSFSheet sheet = wb.createSheet("sheet1");
      sheet.setDefaultColumnWidth(20);
      HSSFRow row = sheet.createRow(0);
      HSSFCellStyle style = wb.createCellStyle();
      style.setAlignment(HorizontalAlignment.CENTER);
      HSSFCell cell = null;

      for (int i = 0; i < strArray.length; i++) {
         cell = row.createCell((short)i);
         cell.setCellValue(strArray[i]);
         cell.setCellStyle(style);
      }

      wb.setForceFormulaRecalculation(true);
      int i = 0;

      for (String str : map.keySet()) {
         row = sheet.createRow(i + 1);
         List<String> list = map.get(str);

         for (int j = 0; j < strArray.length; j++) {
            row.createCell((short)j).setCellValue(list.get(j));
         }

         try {
            FileOutputStream fout = new FileOutputStream(path);
            wb.write(fout);
            fout.close();
         } catch (Exception e) {
            e.printStackTrace();
         }

         i++;
      }
   }

   private static void buildCellStyle(Workbook workbook, List<Integer> sheets) {
      CellStyle cellStyle = workbook.createCellStyle();
      Font font = workbook.createFont();
      font.setFontName("宋体");
      font.setFontHeightInPoints((short)10);
      cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
      cellStyle.setAlignment(HorizontalAlignment.CENTER);
      cellStyle.setBorderBottom(BorderStyle.THIN);
      cellStyle.setBorderTop(BorderStyle.THIN);
      cellStyle.setBorderLeft(BorderStyle.THIN);
      cellStyle.setBorderRight(BorderStyle.THIN);
      cellStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
      cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
      Integer columnIndex = null;

      for (Integer sheet : sheets) {
         Sheet sheetAt = workbook.getSheetAt(sheet == null ? 0 : sheet);
         if (sheetAt != null) {
            for (int i = 0; i <= sheetAt.getPhysicalNumberOfRows(); i++) {
               Row row = sheetAt.getRow(i);
               if (row != null) {
                  for (Cell cell : row) {
                     if (cell.toString().equals("材料编码")) {
                        columnIndex = cell.getColumnIndex();
                     }

                     CellType cellType = cell.getCellType();
                     if (CellType.STRING.getCode() == cellType.getCode()
                        && NumberUtils.isNumber(cell.getStringCellValue())
                        && cell.getStringCellValue().matches("^(-?\\d+)(\\.\\d+)?$")
                        && !cell.getStringCellValue().contains("%")) {
                        cell.setCellType(CellType.STRING);
                        String stringCellValue = cell.getStringCellValue();
                        String[] split = stringCellValue.split("\\.");
                        if (split.length > 1) {
                           if (columnIndex == null || ObjectUtil.notEqual(columnIndex, cell.getColumnIndex())) {
                              cell.setCellValue(Double.parseDouble(stringCellValue));
                              cellStyle.setDataFormat((short)BuiltinFormats.getBuiltinFormat("0.00000000_ "));
                           }
                        } else {
                           try {
                              cell.setCellValue(Long.parseLong(stringCellValue));
                           } catch (NumberFormatException e) {
                              e.printStackTrace();
                           }

                           cellStyle.setDataFormat((short)BuiltinFormats.getBuiltinFormat("0_ "));
                        }

                        cellStyle.setFont(font);
                        cell.setCellStyle(cellStyle);
                     }
                  }
               }
            }
         }
      }
   }

   private static void buildBeginCellStyle(Workbook workbook, List<Integer> sheets) {
      CellStyle cellStyle = workbook.createCellStyle();
      Font font = workbook.createFont();
      font.setFontName("宋体");
      font.setFontHeightInPoints((short)10);
      cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
      cellStyle.setAlignment(HorizontalAlignment.CENTER);
      cellStyle.setBorderBottom(BorderStyle.THIN);
      cellStyle.setBorderTop(BorderStyle.THIN);
      cellStyle.setBorderLeft(BorderStyle.THIN);
      cellStyle.setBorderRight(BorderStyle.THIN);
      cellStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
      cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
   }

   public static void setRegionStyle(Sheet sheet, CellRangeAddress region, CellStyle cellStyle) {
      for (int rowNum = region.getFirstRow(); rowNum <= region.getLastRow(); rowNum++) {
         Row row = sheet.getRow(rowNum);
         if (row == null) {
            row = sheet.createRow(rowNum);
         }

         for (int colNum = region.getFirstColumn(); colNum <= region.getLastColumn(); colNum++) {
            Cell cell = row.getCell(colNum);
            if (cell == null) {
               cell = row.createCell(colNum);
            }

            cell.setCellStyle(cellStyle);
         }
      }
   }

   public static List<String> getTitles(MultipartFile file, Integer sheetAt, Integer row) {
      List<String> titles = new ArrayList<>();
      if (file == null) {
         return titles;
      }

      try {
         InputStream inputStream = file.getInputStream();
         Workbook workbook = new XSSFWorkbook(inputStream);
         Sheet sheet = workbook.getSheetAt(sheetAt);
         Row headerRow = sheet.getRow(row);
         if (headerRow != null) {
            for (int i = 0; i < headerRow.getLastCellNum(); i++) {
               Cell cell = headerRow.getCell(i);
               if (cell != null) {
                  titles.add(cell.getStringCellValue());
               }
            }
         }

         return titles;
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
   }

   public static void annotatedExportExcel(
      List<?> list, String title, String sheetName, Class<?> pojoClass, String fileName, ExcelType excelType, HttpServletResponse response
   ) {
      Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(title, sheetName, excelType), pojoClass, list);
      Font headerFont = workbook.createFont();
      headerFont.setBold(true);
      headerFont.setFontHeightInPoints((short)14);
      List<Integer> sheets = Collections.singletonList(0);
      CellStyle cellStyle = workbook.createCellStyle();
      cellStyle.setWrapText(true);
      cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
      cellStyle.setAlignment(HorizontalAlignment.CENTER);
      cellStyle.setBorderBottom(BorderStyle.THIN);
      cellStyle.setBorderTop(BorderStyle.THIN);
      cellStyle.setBorderLeft(BorderStyle.THIN);
      cellStyle.setBorderRight(BorderStyle.THIN);
      cellStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
      cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

      for (Integer sheet : sheets) {
         Sheet sheetAt = workbook.getSheetAt(sheet == null ? 0 : sheet);
         if (sheetAt != null) {
            for (int i = 0; i <= sheetAt.getPhysicalNumberOfRows(); i++) {
               Row row = sheetAt.getRow(i);
               if (row != null) {
                  for (Cell cell : row) {
                     CellType cellType = cell.getCellType();
                     if (CellType.STRING.getCode() == cellType.getCode()
                        && NumberUtils.isNumber(cell.getStringCellValue())
                        && cell.getStringCellValue().matches("^(-?\\d+)(\\.\\d+)?$")
                        && !cell.getStringCellValue().contains("%")) {
                        cell.setCellType(CellType.STRING);
                        String stringCellValue = cell.getStringCellValue();
                        String[] split = stringCellValue.split("\\.");
                        if (split.length > 1) {
                           cell.setCellValue(Double.parseDouble(stringCellValue));
                           cellStyle.setDataFormat((short)BuiltinFormats.getBuiltinFormat("0.00000000_ "));
                        } else if (new BigInteger(stringCellValue).compareTo(BigInteger.valueOf(2147483647L)) <= 0
                           && new BigInteger(stringCellValue).compareTo(BigInteger.valueOf(-2147483648L)) >= 0) {
                           cell.setCellValue(Integer.parseInt(stringCellValue));
                           cellStyle.setDataFormat((short)BuiltinFormats.getBuiltinFormat("0_ "));
                        }

                        Font font = workbook.createFont();
                        font.setFontName("宋体");
                        font.setFontHeightInPoints((short)10);
                        cellStyle.setFont(font);
                        cell.setCellStyle(cellStyle);
                     }

                     cell.setCellStyle(cellStyle);
                  }
               }
            }
         }
      }

      try {
         response.setCharacterEncoding("UTF-8");
         response.setHeader("content-Type", "application/vnd.ms-excel");
         response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
         response.setHeader("Access-Control-Expose-Headers", "*");
         workbook.write(response.getOutputStream());
      } catch (IOException e) {
         throw new BusinessException(e.getMessage());
      }
   }
}
