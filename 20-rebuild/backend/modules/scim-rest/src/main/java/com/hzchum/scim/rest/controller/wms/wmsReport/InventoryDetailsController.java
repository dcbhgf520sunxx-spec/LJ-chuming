package com.hzchum.scim.rest.controller.wms.wmsReport;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.service.wmsReport.ReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-存货明细报表")
@RestController
@RequestMapping("/api/wms/report/raw-materials/inventory-details")
public class InventoryDetailsController {
   private static final Logger log = LoggerFactory.getLogger(InventoryDetailsController.class);
   @Resource
   ReportService reportService;

   @ApiOperation("报表-存货明细列表")
   @GetMapping
   public ResultVO list(
      @RequestParam(required = false) List<LocalDateTime> times,
      @RequestParam(required = false) List<Long> classifyId,
      @RequestParam(required = false) List<Long> workshopIds,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：报表-存货明细列表");
      return ResultBuilder.success(this.reportService.getInventoryDetailsRecord(times, classifyId, workshopIds, pageNumber, pageSize, sort));
   }

   @ApiOperation("报表-存货明细详情列表")
   @GetMapping("/detail")
   public ResultVO details(@RequestParam(required = false) List<LocalDateTime> times, @RequestParam(required = false) String detailKey) {
      log.info("API 调用 ：报表-存货明细详情列表");
      return ResultBuilder.success(this.reportService.getInventoryDetailsRecordDetail(times, detailKey));
   }
}
