package com.hzchum.scim.common.core.api.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.metadata.holder.ReadSheetHolder;
import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EasyExcelListener extends AnalysisEventListener<Map<Integer, String>> {
   private static final Logger log = LoggerFactory.getLogger(EasyExcelListener.class);
   private final List<Map<Integer, String>> headList = new ArrayList<>();
   private final List<Map<Integer, String>> dataList = new ArrayList<>();

   @Override
   public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
      log.info("解析到一条头数据:{}", JSON.toJSONString(headMap));
      headMap.put(-3, "sheetNo");
      headMap.put(-2, "sheetName");
      headMap.put(-1, "行号");
      this.headList.add(headMap);
   }

   public void invoke(Map<Integer, String> data, AnalysisContext context) {
      log.info("解析到一条数据:{}", JSON.toJSONString(data));
      ReadSheetHolder readSheetHolder = context.readSheetHolder();
      data.put(-3, String.valueOf(readSheetHolder.getSheetNo()));
      data.put(-2, String.valueOf(readSheetHolder.getSheetName()));
      data.put(-1, String.valueOf(context.readRowHolder().getRowIndex()));
      this.dataList.add(data);
   }

   @Override
   public void doAfterAllAnalysed(AnalysisContext context) {
      log.info("所有数据解析完成！");
   }

   public List<Map<Integer, String>> getHeadList() {
      return this.headList;
   }

   public List<Map<Integer, String>> getDataList() {
      return this.dataList;
   }
}
