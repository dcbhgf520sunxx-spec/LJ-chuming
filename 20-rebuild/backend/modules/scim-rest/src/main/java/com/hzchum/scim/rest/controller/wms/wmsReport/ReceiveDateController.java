package com.hzchum.scim.rest.controller.wms.wmsReport;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryReceiveDateDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsReport.ReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "mes-领用统计")
@RestController
@RequestMapping("/api/wms/receiveDate/")
public class ReceiveDateController {
   private static final Logger log = LoggerFactory.getLogger(ReceiveDateController.class);
   @Resource
   ReportService reportService;

   @ApiOperation("领用统计")
   @PostMapping("/getReceiveDate")
   public ResultVO getReceiveDate(@RequestBody QueryReceiveDateDTOParam queryReceiveDateDTOParam) {
      log.info("API 调用 : 领用统计");
      return ResultBuilder.success(this.reportService.getReceiveDate(queryReceiveDateDTOParam));
   }

   @ApiOperation("领用统计(明细)")
   @PostMapping("/getReceiveDateDetail")
   public ResultVO getReceiveDateDetail(@RequestBody QueryReceiveDateDTOParam queryReceiveDateDTOParam) {
      log.info("API 调用 : 领用统计");
      return ResultBuilder.success(this.reportService.getReceiveDateDetail(queryReceiveDateDTOParam));
   }

   @ApiOperation("领用统计(打印)")
   @PostMapping("/printReceiveDateDetail")
   public ResultVO getReceiveDateDetail1(@RequestBody QueryReceiveDateDTOParam queryReceiveDateDTOParam) {
      log.info("API 调用 : 领用统计");
      return ResultBuilder.success(this.reportService.receiveDatePrint(queryReceiveDateDTOParam));
   }
}
