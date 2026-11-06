package com.hzchum.scim.rest.controller.wms.wmsReport;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryRejectDetailDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsReport.ReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-退货报表")
@RestController
@RequestMapping("/api/v2/wms/report/raw-materials/reject")
public class RejectReportControllerV2 {
   private static final Logger log = LoggerFactory.getLogger(RejectReportControllerV2.class);
   @Resource
   ReportService reportService;

   @ApiOperation("报表-查询退货明细信息汇总")
   @GetMapping("/receiptDetailCount")
   public ResultVO receiptDetailCount(QueryRejectDetailDTOParam param) {
      log.info("API 调用 ：报表-查询退货明细信息汇总");
      return ResultBuilder.success(this.reportService.getRejectDetailListCount(param));
   }
}
