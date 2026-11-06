package com.hzchum.scim.rest.controller.wms.wmsReport;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryReportInboundDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsReport.ReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-入库报表")
@RestController
@RequestMapping("/api/wms/report/raw-materials/inbound")
public class InboundReportController {
   private static final Logger log = LoggerFactory.getLogger(InboundReportController.class);
   @Resource
   ReportService reportService;

   @ApiOperation("报表-批量查询入库单")
   @GetMapping("/receipt")
   @PreAuthorize("@permission.check('wms_report_rawMat_inbound_receipt:get')")
   public ResultVO list(
      QueryReportInboundDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：报表-批量查询入库单");
      return ResultBuilder.success(this.reportService.getInbound(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("报表-根据入库单ID查询入库详情")
   @GetMapping("/receipt/{id}")
   @PreAuthorize("@permission.check('wms_report_rawMat_inbound_receipt:get')")
   public ResultVO list(@PathVariable("id") Long id) {
      log.info("API 调用 ：报表-根据入库单ID查询入库详情");
      return ResultBuilder.success(this.reportService.getInboundDetailById(id));
   }

   @ApiOperation("报表-查询入库明细")
   @GetMapping("/details")
   @PreAuthorize("@permission.check('wms_report_rawMat_inbound_details:get')")
   public ResultVO detailList(
      QueryReportInboundDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：报表-查询入库明细");
      return ResultBuilder.success(this.reportService.getInboundDetails(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("报表-查询入库明细汇总")
   @GetMapping("/detailsCount")
   @PreAuthorize("@permission.check('wms_report_rawMat_inbound_details:get')")
   public ResultVO detailListCount(QueryReportInboundDTOParam param) {
      log.info("API 调用 ：报表-查询入库明细汇总");
      return ResultBuilder.success(this.reportService.getInboundDetailsCount(param));
   }
}
