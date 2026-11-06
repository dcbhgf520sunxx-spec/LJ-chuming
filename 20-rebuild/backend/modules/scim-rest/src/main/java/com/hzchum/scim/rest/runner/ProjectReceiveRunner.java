package com.hzchum.scim.rest.runner;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.mes.building.core.api.service.initialization.InitializationService;
import com.hzchum.scim.project.core.api.enums.ProductTypeUpEnum;
import com.hzchum.scim.project.core.api.enums.SourceTypeEnum;
import com.hzchum.scim.project.core.api.pojo._do.ProjectReceivingRecord;
import com.hzchum.scim.project.core.api.service.ProjectReceivingRecordService;
import com.hzchum.scim.project.core.api.service.ProjectReceivingSummaryService;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrderDetail;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderDetailService;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ProjectReceiveRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(ProjectReceiveRunner.class);
   private final InitializationService service;
   private final PurchaseOrderService purchaseOrderService;
   private final PurchaseOrderDetailService purchaseOrderDetailService;
   private final ProjectReceivingRecordService receivingRecordService;
   private final ProjectReceivingSummaryService receivingSummaryService;

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public void run(String... strings) {
      String datasource = this.service.selectSql("SELECT DATABASE()").get(0);
      List<String> updateSqlList = new ArrayList<>();
      List<String> recordColumnList = this.service
         .selectSql("SELECT COLUMN_NAME FROM information_schema.columns where TABLE_NAME ='project_receiving_record' AND  TABLE_SCHEMA ='" + datasource + "'");
      List<String> summaryColumnList = this.service
         .selectSql("SELECT COLUMN_NAME FROM information_schema.columns where TABLE_NAME ='project_receiving_summary' AND  TABLE_SCHEMA ='" + datasource + "'");
      List<String> attendanceColumnList = this.service
         .selectSql("SELECT COLUMN_NAME FROM information_schema.columns where TABLE_NAME ='mes_building_attendance' AND  TABLE_SCHEMA ='" + datasource + "'");
      if (recordColumnList.contains("monomer_id")) {
         updateSqlList.add("ALTER TABLE project_receiving_record MODIFY COLUMN monomer_id bigint(20) NULL;");
      }

      if (recordColumnList.contains("product_id")) {
         updateSqlList.add("ALTER TABLE project_receiving_record MODIFY COLUMN product_id bigint(20) NULL;");
      }

      if (summaryColumnList.contains("monomer_id")) {
         updateSqlList.add("ALTER TABLE project_receiving_summary MODIFY COLUMN monomer_id bigint(20) NULL;");
      }

      if (summaryColumnList.contains("product_id")) {
         updateSqlList.add("ALTER TABLE project_receiving_summary MODIFY COLUMN product_id bigint(20) NULL;");
      }

      if (attendanceColumnList.contains("over_config_ids")) {
         updateSqlList.add("ALTER TABLE mes_building_attendance MODIFY COLUMN over_config_ids varchar(1024) NULL;");
      }

      updateSqlList.forEach(this.service::updateSql);
      List<ProjectReceivingRecord> recordList = this.receivingRecordService
         .list(
            Wrappers.lambdaQuery(ProjectReceivingRecord.class)
               .eq(ProjectReceivingRecord::getSourceType, SourceTypeEnum.OUT_SOURCE.getType())
               .eq(ProjectReceivingRecord::getProductType, ProductTypeUpEnum.ARTIFACT.getType())
               .gt(ProjectReceivingRecord::getQuantity, 0)
               .eq(ProjectReceivingRecord::getActualReceivedMete, BigDecimal.ZERO)
         )
         .stream()
         .peek(record -> record.setActualReceivedMete(record.getMete().multiply(BigDecimal.valueOf(1000L))))
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(recordList)) {
         this.receivingRecordService.updateBatchById(recordList);
         Map<Long, BigDecimal> purchaseDetailMeteMap = recordList.stream()
            .collect(
               Collectors.groupingBy(
                  ProjectReceivingRecord::getPurchaseDetailsId,
                  Collectors.mapping(ProjectReceivingRecord::getActualReceivedMete, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))
               )
            );
         List<PurchaseOrderDetail> orderDetailList = this.purchaseOrderDetailService
            .listByIds(purchaseDetailMeteMap.keySet())
            .stream()
            .peek(e -> e.setActualReceivedMete(purchaseDetailMeteMap.get(e.getId())))
            .collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(orderDetailList)) {
            this.purchaseOrderDetailService.updateBatchById(orderDetailList);
         }
      }
   }

   public ProjectReceiveRunner(
      final InitializationService service,
      final PurchaseOrderService purchaseOrderService,
      final PurchaseOrderDetailService purchaseOrderDetailService,
      final ProjectReceivingRecordService receivingRecordService,
      final ProjectReceivingSummaryService receivingSummaryService
   ) {
      this.service = service;
      this.purchaseOrderService = purchaseOrderService;
      this.purchaseOrderDetailService = purchaseOrderDetailService;
      this.receivingRecordService = receivingRecordService;
      this.receivingSummaryService = receivingSummaryService;
   }
}
