package com.hzchum.scim.mes.building.core.service.impl.task.util;

import com.alibaba.excel.write.handler.SheetWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteWorkbookHolder;

public class CustomTemplateSheetStrategy implements SheetWriteHandler {
   private Integer sheetNo;
   private String sheetName;

   public CustomTemplateSheetStrategy(String sheetName) {
      this.sheetName = sheetName;
   }

   public CustomTemplateSheetStrategy(Integer sheetNo, String sheetName) {
      this.sheetNo = sheetNo;
      this.sheetName = sheetName;
   }

   @Override
   public void beforeSheetCreate(WriteWorkbookHolder writeWorkbookHolder, WriteSheetHolder writeSheetHolder) {
   }

   @Override
   public void afterSheetCreate(WriteWorkbookHolder writeWorkbookHolder, WriteSheetHolder writeSheetHolder) {
      if (this.sheetName != null) {
         if (this.sheetNo == null) {
            this.sheetNo = 0;
         }

         writeWorkbookHolder.getCachedWorkbook().setSheetName(this.sheetNo, this.sheetName);
      }
   }
}
