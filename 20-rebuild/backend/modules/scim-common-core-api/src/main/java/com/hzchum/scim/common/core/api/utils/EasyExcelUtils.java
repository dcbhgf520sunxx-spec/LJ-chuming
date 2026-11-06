package com.hzchum.scim.common.core.api.utils;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.util.IoUtils;
import com.google.common.collect.Lists;
import com.hzchum.scim.common.core.api.listener.EasyExcelListener;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.util.CollectionUtils;

public class EasyExcelUtils {
   public static List<Map<String, String>> parseExcel(InputStream inputStream, Integer sheetNo, Integer parseRowNumber) {
      byte[] bytes = new byte[0];

      try {
         bytes = IoUtils.toByteArray(inputStream);
      } catch (IOException e) {
         e.printStackTrace();
      }

      EasyExcelListener readListener = new EasyExcelListener();
      if (sheetNo != null) {
         EasyExcelFactory.read(new ByteArrayInputStream(bytes)).registerReadListener(readListener).headRowNumber(parseRowNumber).sheet(sheetNo).doRead();
      } else {
         EasyExcelFactory.read(new ByteArrayInputStream(bytes)).registerReadListener(readListener).headRowNumber(parseRowNumber).doReadAll();
      }

      List<Map<Integer, String>> headList = readListener.getHeadList();
      if (CollectionUtils.isEmpty(headList)) {
         throw new RuntimeException("Excel未包含表头");
      }

      List<Map<Integer, String>> dataList = readListener.getDataList();
      if (CollectionUtils.isEmpty(dataList)) {
         throw new RuntimeException("Excel未包含数据");
      }

      Map<Integer, String> excelHeadIdxNameMap = headList.get(headList.size() - 1);
      List<Map<String, String>> excelDataList = Lists.newArrayList();

      for (Map<Integer, String> dataRow : dataList) {
         Map<String, String> rowData = new LinkedHashMap<>();
         excelHeadIdxNameMap.forEach((key, value) -> {
            String var10000 = rowData.put(value, dataRow.get(key));
         });
         excelDataList.add(rowData);
      }

      return excelDataList;
   }

   public static List<Map<String, String>> parseExcel(InputStream inputStream, Integer parseRowNumber) {
      return parseExcel(inputStream, null, parseRowNumber);
   }
}
