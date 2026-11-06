package com.hzchum.pangu.common.converter;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.hzchum.pangu.common.util.DateTimeUtils;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import org.apache.poi.ss.usermodel.DateUtil;

public class LocalDateNumberConverter implements Converter<LocalDate> {
   @Override
   public Class<?> supportJavaTypeKey() {
      return LocalDate.class;
   }

   @Override
   public CellDataTypeEnum supportExcelTypeKey() {
      return CellDataTypeEnum.NUMBER;
   }

   public LocalDate convertToJavaData(ReadCellData<?> cellData, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) {
      if (contentProperty != null && contentProperty.getDateTimeFormatProperty() != null) {
         Date date = DateUtil.getJavaDate(cellData.getNumberValue().doubleValue(), contentProperty.getDateTimeFormatProperty().getUse1904windowing(), null);
         return DateTimeUtils.dateToLocalDate(date);
      } else {
         Date date = DateUtil.getJavaDate(cellData.getNumberValue().doubleValue(), globalConfiguration.getUse1904windowing(), null);
         return DateTimeUtils.dateToLocalDate(date);
      }
   }

   public WriteCellData<?> convertToExcelData(LocalDate value, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) {
      Date dateValue = DateTimeUtils.localDateToDate(value);
      return contentProperty != null && contentProperty.getDateTimeFormatProperty() != null
         ? new WriteCellData(BigDecimal.valueOf(DateUtil.getExcelDate(dateValue, contentProperty.getDateTimeFormatProperty().getUse1904windowing())))
         : new WriteCellData(BigDecimal.valueOf(DateUtil.getExcelDate(dateValue, globalConfiguration.getUse1904windowing())));
   }
}
